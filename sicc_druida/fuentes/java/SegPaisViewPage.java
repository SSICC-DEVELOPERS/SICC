
import org.w3c.dom.*;
import java.util.ArrayList;

public class SegPaisViewPage  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","SegPaisViewPage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","segPaisViewInitComponents()" );
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
      ((Element)v.get(4)).setAttribute("src","segpaisview.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","segPaisViewFrm" );
      ((Element)v.get(5)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(6)).setAttribute("valor","SegPaisViewLPExecution" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","ON" );
      ((Element)v.get(7)).setAttribute("valor","SegPaisViewLPExecution" );
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
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","indSaldUnicCheckValue" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","indTratAcumDescCheckValue" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","indEmisVencCheckValue" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","valIndiSecuMoniCheckValue" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(41)).setAttribute("nombre","segPaisViewFormLayer" );
      ((Element)v.get(41)).setAttribute("alto","" );
      ((Element)v.get(41)).setAttribute("ancho","100%" );
      ((Element)v.get(41)).setAttribute("colorf","" );
      ((Element)v.get(41)).setAttribute("borde","0" );
      ((Element)v.get(41)).setAttribute("imagenf","" );
      ((Element)v.get(41)).setAttribute("repeat","" );
      ((Element)v.get(41)).setAttribute("padding","" );
      ((Element)v.get(41)).setAttribute("visibilidad","visible" );
      ((Element)v.get(41)).setAttribute("contravsb","" );
      ((Element)v.get(41)).setAttribute("x","0" );
      ((Element)v.get(41)).setAttribute("y","0" );
      ((Element)v.get(41)).setAttribute("zindex","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(5)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(42)).setAttribute("width","100%" );
      ((Element)v.get(42)).setAttribute("border","0" );
      ((Element)v.get(42)).setAttribute("cellspacing","0" );
      ((Element)v.get(42)).setAttribute("cellpadding","0" );
      ((Element)v.get(42)).setAttribute("align","left" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(44)).setAttribute("align","center" );
      ((Element)v.get(44)).setAttribute("width","12" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","12" );
      ((Element)v.get(45)).setAttribute("height","12" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(46)).setAttribute("align","center" );
      ((Element)v.get(46)).setAttribute("width","750" );
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","12" );
      ((Element)v.get(47)).setAttribute("height","12" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 43   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(48)).setAttribute("align","center" );
      ((Element)v.get(48)).setAttribute("width","12" );
      ((Element)v.get(43)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","12" );
      ((Element)v.get(49)).setAttribute("height","12" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:43   */

      /* Empieza nodo:50 / Elemento padre: 42   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(42)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(51)).setAttribute("align","center" );
      ((Element)v.get(51)).setAttribute("width","12" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","12" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 50   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(53)).setAttribute("width","100%" );
      ((Element)v.get(50)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(55)).setAttribute("class","legend" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(56)).setAttribute("nombre","legendLbl" );
      ((Element)v.get(56)).setAttribute("alto","13" );
      ((Element)v.get(56)).setAttribute("filas","1" );
      ((Element)v.get(56)).setAttribute("id","legend" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(56)).setAttribute("cod","SegPaisView.legend.label" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 54   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(57)).setAttribute("width","100%" );
      ((Element)v.get(57)).setAttribute("border","0" );
      ((Element)v.get(57)).setAttribute("align","center" );
      ((Element)v.get(57)).setAttribute("cellspacing","0" );
      ((Element)v.get(57)).setAttribute("cellpadding","0" );
      ((Element)v.get(54)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(59)).setAttribute("width","100%" );
      ((Element)v.get(59)).setAttribute("nowrap","true" );
      ((Element)v.get(59)).setAttribute("class","datosCampos" );
      ((Element)v.get(59)).setAttribute("colspan","3" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:61 / Elemento padre: 57   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(61)).setAttribute("nombre","formTr0" );
      ((Element)v.get(57)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(62)).setAttribute("align","center" );
      ((Element)v.get(62)).setAttribute("width","8" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(63)).setAttribute("height","12" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 61   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(64)).setAttribute("width","100%" );
      ((Element)v.get(61)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(65)).setAttribute("width","100%" );
      ((Element)v.get(65)).setAttribute("border","0" );
      ((Element)v.get(65)).setAttribute("cellspacing","0" );
      ((Element)v.get(65)).setAttribute("cellpadding","0" );
      ((Element)v.get(65)).setAttribute("align","left" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(66)).setAttribute("align","left" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(67)).setAttribute("nombre","idTdId" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(68)).setAttribute("width","100%" );
      ((Element)v.get(68)).setAttribute("border","0" );
      ((Element)v.get(68)).setAttribute("cellspacing","0" );
      ((Element)v.get(68)).setAttribute("cellpadding","0" );
      ((Element)v.get(68)).setAttribute("align","left" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(70)).setAttribute("valign","top" );
      ((Element)v.get(70)).setAttribute("height","13" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(71)).setAttribute("nombre","lblId" );
      ((Element)v.get(71)).setAttribute("alto","13" );
      ((Element)v.get(71)).setAttribute("filas","1" );
      ((Element)v.get(71)).setAttribute("id","datosTitle" );
      ((Element)v.get(71)).setAttribute("cod","SegPaisView.id.label" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:72 / Elemento padre: 68   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(72)).setAttribute("nombre","idWidgetTrId" );
      ((Element)v.get(68)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(73)).setAttribute("align","left" );
      ((Element)v.get(73)).setAttribute("nowrap","true" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(74)).setAttribute("nombre","id" );
      ((Element)v.get(74)).setAttribute("id","datosCampos" );
      ((Element)v.get(74)).setAttribute("trim","S" );
      ((Element)v.get(74)).setAttribute("max","12" );
      ((Element)v.get(74)).setAttribute("onchange","" );
      ((Element)v.get(74)).setAttribute("req","N" );
      ((Element)v.get(74)).setAttribute("size","12" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(74)).setAttribute("validacion","" );
      ((Element)v.get(74)).setAttribute("disabled","" );
      ((Element)v.get(74)).setAttribute("onblur","" );
      ((Element)v.get(74)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',1, true)" );
      ((Element)v.get(74)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 1, false)" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:75 / Elemento padre: 66   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(75)).setAttribute("nombre","idGapTdId" );
      ((Element)v.get(75)).setAttribute("nowrap","true" );
      ((Element)v.get(75)).setAttribute("class","datosCampos" );
      ((Element)v.get(66)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","25" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 66   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(77)).setAttribute("width","100%" );
      ((Element)v.get(66)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:61   */

      /* Empieza nodo:79 / Elemento padre: 57   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(79)).setAttribute("nombre","formGapTr0" );
      ((Element)v.get(57)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(80)).setAttribute("align","center" );
      ((Element)v.get(80)).setAttribute("width","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

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

      /* Empieza nodo:82 / Elemento padre: 79   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(79)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","8" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 79   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(84)).setAttribute("align","center" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","12" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:79   */

      /* Empieza nodo:86 / Elemento padre: 57   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(86)).setAttribute("nombre","formTr1" );
      ((Element)v.get(57)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(87)).setAttribute("align","center" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","8" );
      ((Element)v.get(88)).setAttribute("height","12" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 86   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(89)).setAttribute("width","100%" );
      ((Element)v.get(86)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(90)).setAttribute("width","100%" );
      ((Element)v.get(90)).setAttribute("border","0" );
      ((Element)v.get(90)).setAttribute("cellspacing","0" );
      ((Element)v.get(90)).setAttribute("cellpadding","0" );
      ((Element)v.get(90)).setAttribute("align","left" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(91)).setAttribute("align","left" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(92)).setAttribute("nombre","codPaisTdId" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(93)).setAttribute("width","100%" );
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
      ((Element)v.get(96)).setAttribute("nombre","lblCodPais" );
      ((Element)v.get(96)).setAttribute("alto","13" );
      ((Element)v.get(96)).setAttribute("filas","1" );
      ((Element)v.get(96)).setAttribute("id","datosTitle" );
      ((Element)v.get(96)).setAttribute("cod","SegPaisView.codPais.label" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:97 / Elemento padre: 93   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(97)).setAttribute("nombre","codPaisWidgetTrId" );
      ((Element)v.get(93)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(98)).setAttribute("align","left" );
      ((Element)v.get(98)).setAttribute("nowrap","true" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(99)).setAttribute("nombre","codPais" );
      ((Element)v.get(99)).setAttribute("id","datosCampos" );
      ((Element)v.get(99)).setAttribute("trim","S" );
      ((Element)v.get(99)).setAttribute("max","3" );
      ((Element)v.get(99)).setAttribute("onchange","" );
      ((Element)v.get(99)).setAttribute("req","N" );
      ((Element)v.get(99)).setAttribute("size","3" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(99)).setAttribute("validacion","" );
      ((Element)v.get(99)).setAttribute("disabled","" );
      ((Element)v.get(99)).setAttribute("onblur","" );
      ((Element)v.get(99)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',2, true)" );
      ((Element)v.get(99)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 2, false)" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:100 / Elemento padre: 91   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(100)).setAttribute("nombre","codPaisGapTdId" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(100)).setAttribute("nowrap","true" );
      ((Element)v.get(100)).setAttribute("class","datosCampos" );
      ((Element)v.get(91)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","25" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 91   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(102)).setAttribute("nombre","moneOidMoneTdId" );
      ((Element)v.get(91)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(103)).setAttribute("border","0" );
      ((Element)v.get(103)).setAttribute("cellspacing","0" );
      ((Element)v.get(103)).setAttribute("cellpadding","0" );
      ((Element)v.get(103)).setAttribute("align","left" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(105)).setAttribute("valign","top" );
      ((Element)v.get(105)).setAttribute("height","13" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(106)).setAttribute("nombre","lblmoneOidMone" );
      ((Element)v.get(106)).setAttribute("id","datosTitle" );
      ((Element)v.get(106)).setAttribute("ancho","150" );
      ((Element)v.get(106)).setAttribute("alto","13" );
      ((Element)v.get(106)).setAttribute("cod","SegPaisView.moneOidMone.label" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:107 / Elemento padre: 103   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(107)).setAttribute("nombre","moneOidMoneWidgetTrId" );
      ((Element)v.get(103)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(108)).setAttribute("align","left" );
      ((Element)v.get(108)).setAttribute("nowrap","true" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(109)).setAttribute("nombre","moneOidMone" );
      ((Element)v.get(109)).setAttribute("id","datosCampos" );
      ((Element)v.get(109)).setAttribute("multiple","N" );
      ((Element)v.get(109)).setAttribute("req","N" );
      ((Element)v.get(109)).setAttribute("size","1" );
      ((Element)v.get(109)).setAttribute("disabled","" );
      ((Element)v.get(109)).setAttribute("validacion","" );
      ((Element)v.get(109)).setAttribute("onchange","" );
      ((Element)v.get(109)).setAttribute("onfocus","" );
      ((Element)v.get(109)).setAttribute("valorinicial","" );
      ((Element)v.get(109)).setAttribute("textoinicial","" );
      ((Element)v.get(109)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',3, true);" );
      ((Element)v.get(109)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',3, false);" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:111 / Elemento padre: 91   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(111)).setAttribute("nombre","moneOidMoneGapTdId" );
      ((Element)v.get(111)).setAttribute("nowrap","true" );
      ((Element)v.get(111)).setAttribute("class","datosCampos" );
      ((Element)v.get(91)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","25" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 91   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(113)).setAttribute("nombre","moneOidMoneAltTdId" );
      ((Element)v.get(91)).appendChild((Element)v.get(113));

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
      ((Element)v.get(117)).setAttribute("nombre","lblmoneOidMoneAlt" );
      ((Element)v.get(117)).setAttribute("id","datosTitle" );
      ((Element)v.get(117)).setAttribute("ancho","150" );
      ((Element)v.get(117)).setAttribute("alto","13" );
      ((Element)v.get(117)).setAttribute("cod","SegPaisView.moneOidMoneAlt.label" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:118 / Elemento padre: 114   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(118)).setAttribute("nombre","moneOidMoneAltWidgetTrId" );
      ((Element)v.get(114)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("TD"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(119)).setAttribute("align","left" );
      ((Element)v.get(119)).setAttribute("nowrap","true" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(120)).setAttribute("nombre","moneOidMoneAlt" );
      ((Element)v.get(120)).setAttribute("id","datosCampos" );
      ((Element)v.get(120)).setAttribute("multiple","N" );
      ((Element)v.get(120)).setAttribute("req","N" );
      ((Element)v.get(120)).setAttribute("size","1" );
      ((Element)v.get(120)).setAttribute("disabled","" );
      ((Element)v.get(120)).setAttribute("validacion","" );
      ((Element)v.get(120)).setAttribute("onchange","" );
      ((Element)v.get(120)).setAttribute("onfocus","" );
      ((Element)v.get(120)).setAttribute("valorinicial","" );
      ((Element)v.get(120)).setAttribute("textoinicial","" );
      ((Element)v.get(120)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',4, true);" );
      ((Element)v.get(120)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',4, false);" );
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

      /* Empieza nodo:122 / Elemento padre: 91   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(122)).setAttribute("nombre","moneOidMoneAltGapTdId" );
      ((Element)v.get(122)).setAttribute("nowrap","true" );
      ((Element)v.get(122)).setAttribute("class","datosCampos" );
      ((Element)v.get(91)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","25" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 91   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(124)).setAttribute("nombre","DescripcionTdId" );
      ((Element)v.get(91)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(125)).setAttribute("width","100%" );
      ((Element)v.get(125)).setAttribute("border","0" );
      ((Element)v.get(125)).setAttribute("cellspacing","0" );
      ((Element)v.get(125)).setAttribute("cellpadding","0" );
      ((Element)v.get(125)).setAttribute("align","left" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(127)).setAttribute("valign","top" );
      ((Element)v.get(127)).setAttribute("height","13" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(128)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(128)).setAttribute("alto","13" );
      ((Element)v.get(128)).setAttribute("filas","1" );
      ((Element)v.get(128)).setAttribute("id","datosTitle" );
      ((Element)v.get(128)).setAttribute("cod","SegPaisView.Descripcion.label" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 126   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(129)).setAttribute("nombre","DescripcionTdLocalizationButtonGapHeader" );
      ((Element)v.get(129)).setAttribute("colspan","2" );
      ((Element)v.get(126)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:126   */

      /* Empieza nodo:130 / Elemento padre: 125   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(130)).setAttribute("nombre","DescripcionWidgetTrId" );
      ((Element)v.get(125)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(131)).setAttribute("align","left" );
      ((Element)v.get(131)).setAttribute("nowrap","true" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(132)).setAttribute("nombre","Descripcion" );
      ((Element)v.get(132)).setAttribute("id","datosCampos" );
      ((Element)v.get(132)).setAttribute("trim","S" );
      ((Element)v.get(132)).setAttribute("max","30" );
      ((Element)v.get(132)).setAttribute("onchange","" );
      ((Element)v.get(132)).setAttribute("req","N" );
      ((Element)v.get(132)).setAttribute("size","30" );
      ((Element)v.get(132)).setAttribute("valor","" );
      ((Element)v.get(132)).setAttribute("validacion","" );
      ((Element)v.get(132)).setAttribute("disabled","" );
      ((Element)v.get(132)).setAttribute("onblur","" );
      ((Element)v.get(132)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',5, true)" );
      ((Element)v.get(132)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 5, false)" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 130   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(130)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","8" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 130   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(135)).setAttribute("nombre","DescripcionTdLocalizationButton" );
      ((Element)v.get(135)).setAttribute("align","left" );
      ((Element)v.get(135)).setAttribute("nowrap","true" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(135)).setAttribute("valign","bottom" );
      ((Element)v.get(130)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("A"));
      ((Element)v.get(136)).setAttribute("id","DescripcionLocalizationButton" );
      ((Element)v.get(136)).setAttribute("href","javascript:openLocalizationDialog('segPaisViewFrm', 'Descripcion', 1);" );
      ((Element)v.get(136)).setAttribute("onKeyDown","javascript:mmgImgEventDispatcherForFocus(event, 'ejecutarAccionFoco(\"segPaisViewFrm\",5, true)', 'ejecutarAccionFoco(\"segPaisViewFrm\",5, false)')" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("nombre","DescripcionLocalizationButton" );
      ((Element)v.get(137)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(137)).setAttribute("border","0" );
      ((Element)v.get(137)).setAttribute("width","21" );
      ((Element)v.get(137)).setAttribute("height","15" );
      ((Element)v.get(137)).setAttribute("class","main" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:130   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:138 / Elemento padre: 91   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(138)).setAttribute("nombre","DescripcionGapTdId" );
      ((Element)v.get(138)).setAttribute("nowrap","true" );
      ((Element)v.get(138)).setAttribute("class","datosCampos" );
      ((Element)v.get(91)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","25" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 91   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(140)).setAttribute("width","100%" );
      ((Element)v.get(91)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:86   */

      /* Empieza nodo:142 / Elemento padre: 57   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(142)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(57)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(143)).setAttribute("align","center" );
      ((Element)v.get(143)).setAttribute("width","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","12" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 142   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(142)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 142   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(147)).setAttribute("align","center" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","12" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:142   */

      /* Empieza nodo:149 / Elemento padre: 57   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(149)).setAttribute("nombre","formTr2" );
      ((Element)v.get(57)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(150)).setAttribute("align","center" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(151)).setAttribute("height","12" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 149   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(152)).setAttribute("width","100%" );
      ((Element)v.get(149)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(153)).setAttribute("width","100%" );
      ((Element)v.get(153)).setAttribute("border","0" );
      ((Element)v.get(153)).setAttribute("cellspacing","0" );
      ((Element)v.get(153)).setAttribute("cellpadding","0" );
      ((Element)v.get(153)).setAttribute("align","left" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(154)).setAttribute("align","left" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(155)).setAttribute("nombre","indInteGisTdId" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(156)).setAttribute("width","100%" );
      ((Element)v.get(156)).setAttribute("border","0" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(156)).setAttribute("cellspacing","0" );
      ((Element)v.get(156)).setAttribute("cellpadding","0" );
      ((Element)v.get(156)).setAttribute("align","left" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(158)).setAttribute("valign","top" );
      ((Element)v.get(158)).setAttribute("height","13" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(159)).setAttribute("nombre","lblIndInteGis" );
      ((Element)v.get(159)).setAttribute("ancho","150" );
      ((Element)v.get(159)).setAttribute("alto","13" );
      ((Element)v.get(159)).setAttribute("filas","1" );
      ((Element)v.get(159)).setAttribute("id","datosTitle" );
      ((Element)v.get(159)).setAttribute("cod","SegPaisView.indInteGis.label" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:160 / Elemento padre: 156   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(160)).setAttribute("nombre","indInteGisWidgetTrId" );
      ((Element)v.get(156)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(161)).setAttribute("align","left" );
      ((Element)v.get(161)).setAttribute("nowrap","true" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(162)).setAttribute("nombre","indInteGis" );
      ((Element)v.get(162)).setAttribute("id","datosCampos" );
      ((Element)v.get(162)).setAttribute("multiple","N" );
      ((Element)v.get(162)).setAttribute("req","N" );
      ((Element)v.get(162)).setAttribute("size","1" );
      ((Element)v.get(162)).setAttribute("validacion","" );
      ((Element)v.get(162)).setAttribute("onchange","" );
      ((Element)v.get(162)).setAttribute("onfocus","" );
      ((Element)v.get(162)).setAttribute("valorinicial","" );
      ((Element)v.get(162)).setAttribute("textoinicial","" );
      ((Element)v.get(162)).setAttribute("disabled","" );
      ((Element)v.get(162)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',6, true)" );
      ((Element)v.get(162)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',6, false)" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(164)).setAttribute("ID","I" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(165)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(165)).setAttribute("TIPO","STRING" );
      ((Element)v.get(165)).setAttribute("VALOR","I" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 164   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(166)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(166)).setAttribute("TIPO","STRING" );
      ((Element)v.get(166)).setAttribute("VALOR","GIS" );
      ((Element)v.get(164)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:164   */

      /* Empieza nodo:167 / Elemento padre: 163   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(167)).setAttribute("ID","G" );
      ((Element)v.get(163)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(168)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(168)).setAttribute("TIPO","STRING" );
      ((Element)v.get(168)).setAttribute("VALOR","G" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 167   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(169)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(169)).setAttribute("TIPO","STRING" );
      ((Element)v.get(169)).setAttribute("VALOR","Georreferenciador" );
      ((Element)v.get(167)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:167   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:170 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(170)).setAttribute("nombre","indInteGisGapTdId" );
      ((Element)v.get(170)).setAttribute("nowrap","true" );
      ((Element)v.get(170)).setAttribute("class","datosCampos" );
      ((Element)v.get(154)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","25" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(172)).setAttribute("nombre","valIdenTdId" );
      ((Element)v.get(154)).appendChild((Element)v.get(172));

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
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(175)).setAttribute("valign","top" );
      ((Element)v.get(175)).setAttribute("height","13" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(176)).setAttribute("nombre","lblValIden" );
      ((Element)v.get(176)).setAttribute("ancho","150" );
      ((Element)v.get(176)).setAttribute("alto","13" );
      ((Element)v.get(176)).setAttribute("filas","1" );
      ((Element)v.get(176)).setAttribute("id","datosTitle" );
      ((Element)v.get(176)).setAttribute("cod","SegPaisView.valIden.label" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:177 / Elemento padre: 173   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(177)).setAttribute("nombre","valIdenWidgetTrId" );
      ((Element)v.get(173)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(178)).setAttribute("align","left" );
      ((Element)v.get(178)).setAttribute("nowrap","true" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(179)).setAttribute("nombre","valIden" );
      ((Element)v.get(179)).setAttribute("id","datosCampos" );
      ((Element)v.get(179)).setAttribute("multiple","N" );
      ((Element)v.get(179)).setAttribute("req","N" );
      ((Element)v.get(179)).setAttribute("size","1" );
      ((Element)v.get(179)).setAttribute("validacion","" );
      ((Element)v.get(179)).setAttribute("onchange","" );
      ((Element)v.get(179)).setAttribute("onfocus","" );
      ((Element)v.get(179)).setAttribute("valorinicial","" );
      ((Element)v.get(179)).setAttribute("textoinicial","" );
      ((Element)v.get(179)).setAttribute("disabled","" );
      ((Element)v.get(179)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',7, true)" );
      ((Element)v.get(179)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',7, false)" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(181)).setAttribute("ID","B" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(182)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(182)).setAttribute("TIPO","STRING" );
      ((Element)v.get(182)).setAttribute("VALOR","B" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 181   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(183)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(183)).setAttribute("TIPO","STRING" );
      ((Element)v.get(183)).setAttribute("VALOR","Boleta" );
      ((Element)v.get(181)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:181   */

      /* Empieza nodo:184 / Elemento padre: 180   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(184)).setAttribute("ID","F" );
      ((Element)v.get(180)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(185)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(185)).setAttribute("TIPO","STRING" );
      ((Element)v.get(185)).setAttribute("VALOR","F" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 184   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(186)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(186)).setAttribute("TIPO","STRING" );
      ((Element)v.get(186)).setAttribute("VALOR","Factura" );
      ((Element)v.get(184)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:184   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:187 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(187)).setAttribute("nombre","valIdenGapTdId" );
      ((Element)v.get(187)).setAttribute("nowrap","true" );
      ((Element)v.get(187)).setAttribute("class","datosCampos" );
      ((Element)v.get(154)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","25" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(189)).setAttribute("nombre","indSaldUnicTdId" );
      ((Element)v.get(154)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(190)).setAttribute("width","100%" );
      ((Element)v.get(190)).setAttribute("border","0" );
      ((Element)v.get(190)).setAttribute("cellspacing","0" );
      ((Element)v.get(190)).setAttribute("cellpadding","0" );
      ((Element)v.get(190)).setAttribute("align","left" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(192)).setAttribute("valign","top" );
      ((Element)v.get(192)).setAttribute("height","13" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(193)).setAttribute("nombre","lblIndSaldUnic" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(193)).setAttribute("alto","13" );
      ((Element)v.get(193)).setAttribute("filas","1" );
      ((Element)v.get(193)).setAttribute("id","datosTitle" );
      ((Element)v.get(193)).setAttribute("cod","SegPaisView.indSaldUnic.label" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:194 / Elemento padre: 190   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(194)).setAttribute("nombre","indSaldUnicWidgetTrId" );
      ((Element)v.get(190)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(195)).setAttribute("align","left" );
      ((Element)v.get(195)).setAttribute("nowrap","true" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(196)).setAttribute("nombre","indSaldUnic" );
      ((Element)v.get(196)).setAttribute("tipo","H" );
      ((Element)v.get(196)).setAttribute("req","N" );
      ((Element)v.get(196)).setAttribute("id","datosCampos" );
      ((Element)v.get(196)).setAttribute("valor","" );
      ((Element)v.get(196)).setAttribute("disabled","" );
      ((Element)v.get(196)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',8, true)" );
      ((Element)v.get(196)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',8, false)" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(197)).setAttribute("id","datosCampos" );
      ((Element)v.get(197)).setAttribute("valor","1" );
      ((Element)v.get(197)).setAttribute("cod","SegPaisView.indSaldUnic.1.label" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Elemento padre:197 / Elemento actual: 198   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(197)).appendChild((Text)v.get(198));

      /* Termina nodo Texto:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 196   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(199)).setAttribute("id","datosCampos" );
      ((Element)v.get(199)).setAttribute("valor","0" );
      ((Element)v.get(199)).setAttribute("cod","SegPaisView.indSaldUnic.0.label" );
      ((Element)v.get(196)).appendChild((Element)v.get(199));

      /* Elemento padre:199 / Elemento actual: 200   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(199)).appendChild((Text)v.get(200));

      /* Termina nodo Texto:200   */
      /* Termina nodo:199   */
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:201 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(201)).setAttribute("nombre","indSaldUnicGapTdId" );
      ((Element)v.get(201)).setAttribute("nowrap","true" );
      ((Element)v.get(201)).setAttribute("class","datosCampos" );
      ((Element)v.get(154)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","25" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(203)).setAttribute("nombre","valProgEjecTdId" );
      ((Element)v.get(154)).appendChild((Element)v.get(203));

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
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(206)).setAttribute("valign","top" );
      ((Element)v.get(206)).setAttribute("height","13" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(207)).setAttribute("nombre","lblValProgEjec" );
      ((Element)v.get(207)).setAttribute("alto","13" );
      ((Element)v.get(207)).setAttribute("filas","1" );
      ((Element)v.get(207)).setAttribute("id","datosTitle" );
      ((Element)v.get(207)).setAttribute("cod","SegPaisView.valProgEjec.label" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:208 / Elemento padre: 204   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(208)).setAttribute("nombre","valProgEjecWidgetTrId" );
      ((Element)v.get(204)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(209)).setAttribute("align","left" );
      ((Element)v.get(209)).setAttribute("nowrap","true" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(210)).setAttribute("nombre","valProgEjec" );
      ((Element)v.get(210)).setAttribute("id","datosCampos" );
      ((Element)v.get(210)).setAttribute("trim","S" );
      ((Element)v.get(210)).setAttribute("max","10" );
      ((Element)v.get(210)).setAttribute("onchange","" );
      ((Element)v.get(210)).setAttribute("req","N" );
      ((Element)v.get(210)).setAttribute("size","10" );
      ((Element)v.get(210)).setAttribute("valor","" );
      ((Element)v.get(210)).setAttribute("validacion","" );
      ((Element)v.get(210)).setAttribute("disabled","" );
      ((Element)v.get(210)).setAttribute("onblur","" );
      ((Element)v.get(210)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',9, true)" );
      ((Element)v.get(210)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 9, false)" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:211 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(211)).setAttribute("nombre","valProgEjecGapTdId" );
      ((Element)v.get(211)).setAttribute("nowrap","true" );
      ((Element)v.get(211)).setAttribute("class","datosCampos" );
      ((Element)v.get(154)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","25" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(213)).setAttribute("nombre","valPorcAlarTdId" );
      ((Element)v.get(154)).appendChild((Element)v.get(213));

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
      ((Element)v.get(217)).setAttribute("nombre","lblValPorcAlar" );
      ((Element)v.get(217)).setAttribute("alto","13" );
      ((Element)v.get(217)).setAttribute("filas","1" );
      ((Element)v.get(217)).setAttribute("id","datosTitle" );
      ((Element)v.get(217)).setAttribute("cod","SegPaisView.valPorcAlar.label" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:218 / Elemento padre: 214   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(218)).setAttribute("nombre","valPorcAlarWidgetTrId" );
      ((Element)v.get(214)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(219)).setAttribute("align","left" );
      ((Element)v.get(219)).setAttribute("nowrap","true" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(220)).setAttribute("nombre","valPorcAlar" );
      ((Element)v.get(220)).setAttribute("id","datosCampos" );
      ((Element)v.get(220)).setAttribute("trim","S" );
      ((Element)v.get(220)).setAttribute("max","5" );
      ((Element)v.get(220)).setAttribute("onchange","" );
      ((Element)v.get(220)).setAttribute("req","N" );
      ((Element)v.get(220)).setAttribute("size","5" );
      ((Element)v.get(220)).setAttribute("valor","" );
      ((Element)v.get(220)).setAttribute("validacion","" );
      ((Element)v.get(220)).setAttribute("disabled","" );
      ((Element)v.get(220)).setAttribute("onblur","" );
      ((Element)v.get(220)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',10, true)" );
      ((Element)v.get(220)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 10, false)" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:221 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(221)).setAttribute("nombre","valPorcAlarGapTdId" );
      ((Element)v.get(221)).setAttribute("nowrap","true" );
      ((Element)v.get(221)).setAttribute("class","datosCampos" );
      ((Element)v.get(154)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","25" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(223)).setAttribute("width","100%" );
      ((Element)v.get(154)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:149   */

      /* Empieza nodo:225 / Elemento padre: 57   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(225)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(57)).appendChild((Element)v.get(225));

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
   }

   private void getXML1080(Document doc) {
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

      /* Empieza nodo:232 / Elemento padre: 57   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(232)).setAttribute("nombre","formTr3" );
      ((Element)v.get(57)).appendChild((Element)v.get(232));

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
      ((Element)v.get(238)).setAttribute("nombre","indCompAutoTdId" );
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
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(241)).setAttribute("valign","top" );
      ((Element)v.get(241)).setAttribute("height","13" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(242)).setAttribute("nombre","lblIndCompAuto" );
      ((Element)v.get(242)).setAttribute("alto","13" );
      ((Element)v.get(242)).setAttribute("filas","1" );
      ((Element)v.get(242)).setAttribute("id","datosTitle" );
      ((Element)v.get(242)).setAttribute("cod","SegPaisView.indCompAuto.label" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:243 / Elemento padre: 239   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(243)).setAttribute("nombre","indCompAutoWidgetTrId" );
      ((Element)v.get(239)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(244)).setAttribute("align","left" );
      ((Element)v.get(244)).setAttribute("nowrap","true" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(245)).setAttribute("nombre","indCompAuto" );
      ((Element)v.get(245)).setAttribute("id","datosCampos" );
      ((Element)v.get(245)).setAttribute("trim","S" );
      ((Element)v.get(245)).setAttribute("max","1" );
      ((Element)v.get(245)).setAttribute("onchange","" );
      ((Element)v.get(245)).setAttribute("req","N" );
      ((Element)v.get(245)).setAttribute("size","1" );
      ((Element)v.get(245)).setAttribute("valor","" );
      ((Element)v.get(245)).setAttribute("validacion","" );
      ((Element)v.get(245)).setAttribute("disabled","" );
      ((Element)v.get(245)).setAttribute("onblur","" );
      ((Element)v.get(245)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',11, true)" );
      ((Element)v.get(245)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 11, false)" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:246 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(246)).setAttribute("nombre","indCompAutoGapTdId" );
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
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(248)).setAttribute("nombre","numDiasMoraTdId" );
      ((Element)v.get(237)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(249)).setAttribute("width","100%" );
      ((Element)v.get(249)).setAttribute("border","0" );
      ((Element)v.get(249)).setAttribute("cellspacing","0" );
      ((Element)v.get(249)).setAttribute("cellpadding","0" );
      ((Element)v.get(249)).setAttribute("align","left" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(251)).setAttribute("valign","top" );
      ((Element)v.get(251)).setAttribute("height","13" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(252)).setAttribute("nombre","lblNumDiasMora" );
      ((Element)v.get(252)).setAttribute("alto","13" );
      ((Element)v.get(252)).setAttribute("filas","1" );
      ((Element)v.get(252)).setAttribute("id","datosTitle" );
      ((Element)v.get(252)).setAttribute("cod","SegPaisView.numDiasMora.label" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:253 / Elemento padre: 249   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(253)).setAttribute("nombre","numDiasMoraWidgetTrId" );
      ((Element)v.get(249)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(254)).setAttribute("align","left" );
      ((Element)v.get(254)).setAttribute("nowrap","true" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(255)).setAttribute("nombre","numDiasMora" );
      ((Element)v.get(255)).setAttribute("id","datosCampos" );
      ((Element)v.get(255)).setAttribute("trim","S" );
      ((Element)v.get(255)).setAttribute("max","3" );
      ((Element)v.get(255)).setAttribute("onchange","" );
      ((Element)v.get(255)).setAttribute("req","N" );
      ((Element)v.get(255)).setAttribute("size","3" );
      ((Element)v.get(255)).setAttribute("valor","" );
      ((Element)v.get(255)).setAttribute("validacion","" );
      ((Element)v.get(255)).setAttribute("disabled","" );
      ((Element)v.get(255)).setAttribute("onblur","" );
      ((Element)v.get(255)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',12, true)" );
      ((Element)v.get(255)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 12, false)" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:256 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(256)).setAttribute("nombre","numDiasMoraGapTdId" );
      ((Element)v.get(256)).setAttribute("nowrap","true" );
      ((Element)v.get(256)).setAttribute("class","datosCampos" );
      ((Element)v.get(237)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","25" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(258)).setAttribute("nombre","indTratAcumDescTdId" );
      ((Element)v.get(237)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(259)).setAttribute("width","100%" );
      ((Element)v.get(259)).setAttribute("border","0" );
      ((Element)v.get(259)).setAttribute("cellspacing","0" );
      ((Element)v.get(259)).setAttribute("cellpadding","0" );
      ((Element)v.get(259)).setAttribute("align","left" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(261)).setAttribute("valign","top" );
      ((Element)v.get(261)).setAttribute("height","13" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(262)).setAttribute("nombre","lblIndTratAcumDesc" );
      ((Element)v.get(262)).setAttribute("alto","13" );
      ((Element)v.get(262)).setAttribute("filas","1" );
      ((Element)v.get(262)).setAttribute("id","datosTitle" );
      ((Element)v.get(262)).setAttribute("cod","SegPaisView.indTratAcumDesc.label" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:263 / Elemento padre: 259   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(263)).setAttribute("nombre","indTratAcumDescWidgetTrId" );
      ((Element)v.get(259)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(264)).setAttribute("align","left" );
      ((Element)v.get(264)).setAttribute("nowrap","true" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(265)).setAttribute("nombre","indTratAcumDesc" );
      ((Element)v.get(265)).setAttribute("tipo","H" );
      ((Element)v.get(265)).setAttribute("req","N" );
      ((Element)v.get(265)).setAttribute("id","datosCampos" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(265)).setAttribute("valor","" );
      ((Element)v.get(265)).setAttribute("disabled","" );
      ((Element)v.get(265)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',13, true)" );
      ((Element)v.get(265)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',13, false)" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(266)).setAttribute("id","datosCampos" );
      ((Element)v.get(266)).setAttribute("valor","1" );
      ((Element)v.get(266)).setAttribute("cod","SegPaisView.indTratAcumDesc.1.label" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Elemento padre:266 / Elemento actual: 267   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(266)).appendChild((Text)v.get(267));

      /* Termina nodo Texto:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 265   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(268)).setAttribute("id","datosCampos" );
      ((Element)v.get(268)).setAttribute("valor","0" );
      ((Element)v.get(268)).setAttribute("cod","SegPaisView.indTratAcumDesc.0.label" );
      ((Element)v.get(265)).appendChild((Element)v.get(268));

      /* Elemento padre:268 / Elemento actual: 269   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(268)).appendChild((Text)v.get(269));

      /* Termina nodo Texto:269   */
      /* Termina nodo:268   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:270 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(270)).setAttribute("nombre","indTratAcumDescGapTdId" );
      ((Element)v.get(270)).setAttribute("nowrap","true" );
      ((Element)v.get(270)).setAttribute("class","datosCampos" );
      ((Element)v.get(237)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","25" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(272)).setAttribute("nombre","valTiemRezoTdId" );
      ((Element)v.get(237)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(273)).setAttribute("width","100%" );
      ((Element)v.get(273)).setAttribute("border","0" );
      ((Element)v.get(273)).setAttribute("cellspacing","0" );
      ((Element)v.get(273)).setAttribute("cellpadding","0" );
      ((Element)v.get(273)).setAttribute("align","left" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(275)).setAttribute("valign","top" );
      ((Element)v.get(275)).setAttribute("height","13" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(276)).setAttribute("nombre","lblValTiemRezo" );
      ((Element)v.get(276)).setAttribute("alto","13" );
      ((Element)v.get(276)).setAttribute("filas","1" );
      ((Element)v.get(276)).setAttribute("id","datosTitle" );
      ((Element)v.get(276)).setAttribute("cod","SegPaisView.valTiemRezo.label" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:277 / Elemento padre: 273   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(277)).setAttribute("nombre","valTiemRezoWidgetTrId" );
      ((Element)v.get(273)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(278)).setAttribute("align","left" );
      ((Element)v.get(278)).setAttribute("nowrap","true" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(279)).setAttribute("nombre","valTiemRezo" );
      ((Element)v.get(279)).setAttribute("id","datosCampos" );
      ((Element)v.get(279)).setAttribute("trim","S" );
      ((Element)v.get(279)).setAttribute("max","2" );
      ((Element)v.get(279)).setAttribute("onchange","" );
      ((Element)v.get(279)).setAttribute("req","N" );
      ((Element)v.get(279)).setAttribute("size","2" );
      ((Element)v.get(279)).setAttribute("valor","" );
      ((Element)v.get(279)).setAttribute("validacion","" );
      ((Element)v.get(279)).setAttribute("disabled","" );
      ((Element)v.get(279)).setAttribute("onblur","" );
      ((Element)v.get(279)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',14, true)" );
      ((Element)v.get(279)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 14, false)" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:277   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:280 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(280)).setAttribute("nombre","valTiemRezoGapTdId" );
      ((Element)v.get(280)).setAttribute("nowrap","true" );
      ((Element)v.get(280)).setAttribute("class","datosCampos" );
      ((Element)v.get(237)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).setAttribute("width","25" );
      ((Element)v.get(281)).setAttribute("height","8" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(282)).setAttribute("nombre","valConfSecuCccTdId" );
      ((Element)v.get(237)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(283)).setAttribute("width","100%" );
      ((Element)v.get(283)).setAttribute("border","0" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(283)).setAttribute("cellspacing","0" );
      ((Element)v.get(283)).setAttribute("cellpadding","0" );
      ((Element)v.get(283)).setAttribute("align","left" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(285)).setAttribute("valign","top" );
      ((Element)v.get(285)).setAttribute("height","13" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(286)).setAttribute("nombre","lblValConfSecuCcc" );
      ((Element)v.get(286)).setAttribute("ancho","150" );
      ((Element)v.get(286)).setAttribute("alto","13" );
      ((Element)v.get(286)).setAttribute("filas","1" );
      ((Element)v.get(286)).setAttribute("id","datosTitle" );
      ((Element)v.get(286)).setAttribute("cod","SegPaisView.valConfSecuCcc.label" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:287 / Elemento padre: 283   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(287)).setAttribute("nombre","valConfSecuCccWidgetTrId" );
      ((Element)v.get(283)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(288)).setAttribute("align","left" );
      ((Element)v.get(288)).setAttribute("nowrap","true" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(289)).setAttribute("nombre","valConfSecuCcc" );
      ((Element)v.get(289)).setAttribute("id","datosCampos" );
      ((Element)v.get(289)).setAttribute("multiple","N" );
      ((Element)v.get(289)).setAttribute("req","N" );
      ((Element)v.get(289)).setAttribute("size","1" );
      ((Element)v.get(289)).setAttribute("validacion","" );
      ((Element)v.get(289)).setAttribute("onchange","" );
      ((Element)v.get(289)).setAttribute("onfocus","" );
      ((Element)v.get(289)).setAttribute("valorinicial","" );
      ((Element)v.get(289)).setAttribute("textoinicial","" );
      ((Element)v.get(289)).setAttribute("disabled","" );
      ((Element)v.get(289)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',15, true)" );
      ((Element)v.get(289)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',15, false)" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(291)).setAttribute("ID","U" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(292)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(292)).setAttribute("TIPO","STRING" );
      ((Element)v.get(292)).setAttribute("VALOR","U" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 291   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(293)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(293)).setAttribute("TIPO","STRING" );
      ((Element)v.get(293)).setAttribute("VALOR","�nico" );
      ((Element)v.get(291)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:291   */

      /* Empieza nodo:294 / Elemento padre: 290   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(294)).setAttribute("ID","A" );
      ((Element)v.get(290)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(295)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(295)).setAttribute("TIPO","STRING" );
      ((Element)v.get(295)).setAttribute("VALOR","A" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 294   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(296)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(296)).setAttribute("TIPO","STRING" );
      ((Element)v.get(296)).setAttribute("VALOR","A�o" );
      ((Element)v.get(294)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:294   */

      /* Empieza nodo:297 / Elemento padre: 290   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(297)).setAttribute("ID","M" );
      ((Element)v.get(290)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(298)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(298)).setAttribute("TIPO","STRING" );
      ((Element)v.get(298)).setAttribute("VALOR","M" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 297   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(299)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(299)).setAttribute("TIPO","STRING" );
      ((Element)v.get(299)).setAttribute("VALOR","Mes y a�o" );
      ((Element)v.get(297)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:297   */
      /* Termina nodo:290   */
      /* Termina nodo:289   */
      /* Termina nodo:288   */
      /* Termina nodo:287   */
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:300 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(300)).setAttribute("nombre","valConfSecuCccGapTdId" );
      ((Element)v.get(300)).setAttribute("nowrap","true" );
      ((Element)v.get(300)).setAttribute("class","datosCampos" );
      ((Element)v.get(237)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(301)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).setAttribute("width","25" );
      ((Element)v.get(301)).setAttribute("height","8" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:302 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(302)).setAttribute("width","100%" );
      ((Element)v.get(237)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(303)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:232   */

      /* Empieza nodo:304 / Elemento padre: 57   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(304)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(57)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(305)).setAttribute("align","center" );
      ((Element)v.get(305)).setAttribute("width","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","12" );
      ((Element)v.get(306)).setAttribute("height","8" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 304   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(304)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(308)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).setAttribute("width","8" );
      ((Element)v.get(308)).setAttribute("height","8" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:309 / Elemento padre: 304   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(309)).setAttribute("align","center" );
      ((Element)v.get(309)).setAttribute("width","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(310)).setAttribute("src","b.gif" );
      ((Element)v.get(310)).setAttribute("width","12" );
      ((Element)v.get(310)).setAttribute("height","8" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */
      /* Termina nodo:304   */

      /* Empieza nodo:311 / Elemento padre: 57   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(311)).setAttribute("nombre","formTr4" );
      ((Element)v.get(57)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(312)).setAttribute("align","center" );
      ((Element)v.get(312)).setAttribute("width","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).setAttribute("width","8" );
      ((Element)v.get(313)).setAttribute("height","12" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 311   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(314)).setAttribute("width","100%" );
      ((Element)v.get(311)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(315)).setAttribute("width","100%" );
      ((Element)v.get(315)).setAttribute("border","0" );
      ((Element)v.get(315)).setAttribute("cellspacing","0" );
      ((Element)v.get(315)).setAttribute("cellpadding","0" );
      ((Element)v.get(315)).setAttribute("align","left" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(316)).setAttribute("align","left" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(317)).setAttribute("nombre","numDiasFactTdId" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));

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
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(320)).setAttribute("valign","top" );
      ((Element)v.get(320)).setAttribute("height","13" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(321)).setAttribute("nombre","lblNumDiasFact" );
      ((Element)v.get(321)).setAttribute("alto","13" );
      ((Element)v.get(321)).setAttribute("filas","1" );
      ((Element)v.get(321)).setAttribute("id","datosTitle" );
      ((Element)v.get(321)).setAttribute("cod","SegPaisView.numDiasFact.label" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:322 / Elemento padre: 318   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(322)).setAttribute("nombre","numDiasFactWidgetTrId" );
      ((Element)v.get(318)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(323)).setAttribute("align","left" );
      ((Element)v.get(323)).setAttribute("nowrap","true" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(324)).setAttribute("nombre","numDiasFact" );
      ((Element)v.get(324)).setAttribute("id","datosCampos" );
      ((Element)v.get(324)).setAttribute("trim","S" );
      ((Element)v.get(324)).setAttribute("max","2" );
      ((Element)v.get(324)).setAttribute("onchange","" );
      ((Element)v.get(324)).setAttribute("req","N" );
      ((Element)v.get(324)).setAttribute("size","2" );
      ((Element)v.get(324)).setAttribute("valor","" );
      ((Element)v.get(324)).setAttribute("validacion","" );
      ((Element)v.get(324)).setAttribute("disabled","" );
      ((Element)v.get(324)).setAttribute("onblur","" );
      ((Element)v.get(324)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',16, true)" );
      ((Element)v.get(324)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 16, false)" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */
      /* Termina nodo:322   */
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:325 / Elemento padre: 316   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(325)).setAttribute("nombre","numDiasFactGapTdId" );
      ((Element)v.get(325)).setAttribute("nowrap","true" );
      ((Element)v.get(325)).setAttribute("class","datosCampos" );
      ((Element)v.get(316)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(326)).setAttribute("src","b.gif" );
      ((Element)v.get(326)).setAttribute("width","25" );
      ((Element)v.get(326)).setAttribute("height","8" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:327 / Elemento padre: 316   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(327)).setAttribute("nombre","numLimiDifePagoTdId" );
      ((Element)v.get(316)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(328)).setAttribute("width","100%" );
      ((Element)v.get(328)).setAttribute("border","0" );
      ((Element)v.get(328)).setAttribute("cellspacing","0" );
      ((Element)v.get(328)).setAttribute("cellpadding","0" );
      ((Element)v.get(328)).setAttribute("align","left" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(330)).setAttribute("valign","top" );
      ((Element)v.get(330)).setAttribute("height","13" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(331)).setAttribute("nombre","lblNumLimiDifePago" );
      ((Element)v.get(331)).setAttribute("alto","13" );
      ((Element)v.get(331)).setAttribute("filas","1" );
      ((Element)v.get(331)).setAttribute("id","datosTitle" );
      ((Element)v.get(331)).setAttribute("cod","SegPaisView.numLimiDifePago.label" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:332 / Elemento padre: 328   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(332)).setAttribute("nombre","numLimiDifePagoWidgetTrId" );
      ((Element)v.get(328)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(333)).setAttribute("align","left" );
      ((Element)v.get(333)).setAttribute("nowrap","true" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(334)).setAttribute("nombre","numLimiDifePago" );
      ((Element)v.get(334)).setAttribute("id","datosCampos" );
      ((Element)v.get(334)).setAttribute("trim","S" );
      ((Element)v.get(334)).setAttribute("max","12" );
      ((Element)v.get(334)).setAttribute("onchange","" );
      ((Element)v.get(334)).setAttribute("req","N" );
      ((Element)v.get(334)).setAttribute("size","12" );
      ((Element)v.get(334)).setAttribute("valor","" );
      ((Element)v.get(334)).setAttribute("validacion","" );
      ((Element)v.get(334)).setAttribute("disabled","" );
      ((Element)v.get(334)).setAttribute("onblur","" );
      ((Element)v.get(334)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',17, true)" );
      ((Element)v.get(334)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 17, false)" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:335 / Elemento padre: 316   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(335)).setAttribute("nombre","numLimiDifePagoGapTdId" );
      ((Element)v.get(335)).setAttribute("nowrap","true" );
      ((Element)v.get(335)).setAttribute("class","datosCampos" );
      ((Element)v.get(316)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","25" );
      ((Element)v.get(336)).setAttribute("height","8" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 316   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(337)).setAttribute("nombre","indEmisVencTdId" );
      ((Element)v.get(316)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(338)).setAttribute("width","100%" );
      ((Element)v.get(338)).setAttribute("border","0" );
      ((Element)v.get(338)).setAttribute("cellspacing","0" );
      ((Element)v.get(338)).setAttribute("cellpadding","0" );
      ((Element)v.get(338)).setAttribute("align","left" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
   }

   private void getXML1620(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(340)).setAttribute("valign","top" );
      ((Element)v.get(340)).setAttribute("height","13" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(341)).setAttribute("nombre","lblIndEmisVenc" );
      ((Element)v.get(341)).setAttribute("alto","13" );
      ((Element)v.get(341)).setAttribute("filas","1" );
      ((Element)v.get(341)).setAttribute("id","datosTitle" );
      ((Element)v.get(341)).setAttribute("cod","SegPaisView.indEmisVenc.label" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:342 / Elemento padre: 338   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(342)).setAttribute("nombre","indEmisVencWidgetTrId" );
      ((Element)v.get(338)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(343)).setAttribute("align","left" );
      ((Element)v.get(343)).setAttribute("nowrap","true" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(344)).setAttribute("nombre","indEmisVenc" );
      ((Element)v.get(344)).setAttribute("tipo","H" );
      ((Element)v.get(344)).setAttribute("req","N" );
      ((Element)v.get(344)).setAttribute("id","datosCampos" );
      ((Element)v.get(344)).setAttribute("valor","" );
      ((Element)v.get(344)).setAttribute("disabled","" );
      ((Element)v.get(344)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',18, true)" );
      ((Element)v.get(344)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',18, false)" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(345)).setAttribute("id","datosCampos" );
      ((Element)v.get(345)).setAttribute("valor","1" );
      ((Element)v.get(345)).setAttribute("cod","SegPaisView.indEmisVenc.1.label" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Elemento padre:345 / Elemento actual: 346   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(345)).appendChild((Text)v.get(346));

      /* Termina nodo Texto:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 344   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(347)).setAttribute("id","datosCampos" );
      ((Element)v.get(347)).setAttribute("valor","0" );
      ((Element)v.get(347)).setAttribute("cod","SegPaisView.indEmisVenc.0.label" );
      ((Element)v.get(344)).appendChild((Element)v.get(347));

      /* Elemento padre:347 / Elemento actual: 348   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(347)).appendChild((Text)v.get(348));

      /* Termina nodo Texto:348   */
      /* Termina nodo:347   */
      /* Termina nodo:344   */
      /* Termina nodo:343   */
      /* Termina nodo:342   */
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:349 / Elemento padre: 316   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(349)).setAttribute("nombre","indEmisVencGapTdId" );
      ((Element)v.get(349)).setAttribute("nowrap","true" );
      ((Element)v.get(349)).setAttribute("class","datosCampos" );
      ((Element)v.get(316)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(350)).setAttribute("src","b.gif" );
      ((Element)v.get(350)).setAttribute("width","25" );
      ((Element)v.get(350)).setAttribute("height","8" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 316   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(351)).setAttribute("nombre","valMaxiDifeAnlsCombTdId" );
      ((Element)v.get(316)).appendChild((Element)v.get(351));

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
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(354)).setAttribute("valign","top" );
      ((Element)v.get(354)).setAttribute("height","13" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(355)).setAttribute("nombre","lblValMaxiDifeAnlsComb" );
      ((Element)v.get(355)).setAttribute("alto","13" );
      ((Element)v.get(355)).setAttribute("filas","1" );
      ((Element)v.get(355)).setAttribute("id","datosTitle" );
      ((Element)v.get(355)).setAttribute("cod","SegPaisView.valMaxiDifeAnlsComb.label" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:356 / Elemento padre: 352   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(356)).setAttribute("nombre","valMaxiDifeAnlsCombWidgetTrId" );
      ((Element)v.get(352)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(357)).setAttribute("align","left" );
      ((Element)v.get(357)).setAttribute("nowrap","true" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(358)).setAttribute("nombre","valMaxiDifeAnlsComb" );
      ((Element)v.get(358)).setAttribute("id","datosCampos" );
      ((Element)v.get(358)).setAttribute("trim","S" );
      ((Element)v.get(358)).setAttribute("max","12" );
      ((Element)v.get(358)).setAttribute("onchange","" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(358)).setAttribute("req","N" );
      ((Element)v.get(358)).setAttribute("size","12" );
      ((Element)v.get(358)).setAttribute("valor","" );
      ((Element)v.get(358)).setAttribute("validacion","" );
      ((Element)v.get(358)).setAttribute("disabled","" );
      ((Element)v.get(358)).setAttribute("onblur","" );
      ((Element)v.get(358)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',19, true)" );
      ((Element)v.get(358)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 19, false)" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:359 / Elemento padre: 316   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(359)).setAttribute("nombre","valMaxiDifeAnlsCombGapTdId" );
      ((Element)v.get(359)).setAttribute("nowrap","true" );
      ((Element)v.get(359)).setAttribute("class","datosCampos" );
      ((Element)v.get(316)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(360)).setAttribute("src","b.gif" );
      ((Element)v.get(360)).setAttribute("width","25" );
      ((Element)v.get(360)).setAttribute("height","8" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:361 / Elemento padre: 316   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(361)).setAttribute("width","100%" );
      ((Element)v.get(316)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:316   */
      /* Termina nodo:315   */
      /* Termina nodo:314   */
      /* Termina nodo:311   */

      /* Empieza nodo:363 / Elemento padre: 57   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(363)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(57)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(364)).setAttribute("align","center" );
      ((Element)v.get(364)).setAttribute("width","8" );
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
      ((Element)v.get(368)).setAttribute("width","8" );
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

      /* Empieza nodo:370 / Elemento padre: 57   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(370)).setAttribute("nombre","formTr5" );
      ((Element)v.get(57)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(371)).setAttribute("align","center" );
      ((Element)v.get(371)).setAttribute("width","8" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(372)).setAttribute("src","b.gif" );
      ((Element)v.get(372)).setAttribute("width","8" );
      ((Element)v.get(372)).setAttribute("height","12" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */

      /* Empieza nodo:373 / Elemento padre: 370   */
      v.add(doc.createElement("TD"));
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
      ((Element)v.get(376)).setAttribute("nombre","numPosiNumeClieTdId" );
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
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(379)).setAttribute("valign","top" );
      ((Element)v.get(379)).setAttribute("height","13" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(380)).setAttribute("nombre","lblNumPosiNumeClie" );
      ((Element)v.get(380)).setAttribute("alto","13" );
      ((Element)v.get(380)).setAttribute("filas","1" );
      ((Element)v.get(380)).setAttribute("id","datosTitle" );
      ((Element)v.get(380)).setAttribute("cod","SegPaisView.numPosiNumeClie.label" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:381 / Elemento padre: 377   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(381)).setAttribute("nombre","numPosiNumeClieWidgetTrId" );
      ((Element)v.get(377)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(382)).setAttribute("align","left" );
      ((Element)v.get(382)).setAttribute("nowrap","true" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(383)).setAttribute("nombre","numPosiNumeClie" );
      ((Element)v.get(383)).setAttribute("id","datosCampos" );
      ((Element)v.get(383)).setAttribute("trim","S" );
      ((Element)v.get(383)).setAttribute("max","2" );
      ((Element)v.get(383)).setAttribute("onchange","" );
      ((Element)v.get(383)).setAttribute("req","N" );
      ((Element)v.get(383)).setAttribute("size","2" );
      ((Element)v.get(383)).setAttribute("valor","" );
      ((Element)v.get(383)).setAttribute("validacion","" );
      ((Element)v.get(383)).setAttribute("disabled","" );
      ((Element)v.get(383)).setAttribute("onblur","" );
      ((Element)v.get(383)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',20, true)" );
      ((Element)v.get(383)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 20, false)" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */
      /* Termina nodo:381   */
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:384 / Elemento padre: 375   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(384)).setAttribute("nombre","numPosiNumeClieGapTdId" );
      ((Element)v.get(384)).setAttribute("nowrap","true" );
      ((Element)v.get(384)).setAttribute("class","datosCampos" );
      ((Element)v.get(375)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(385)).setAttribute("width","25" );
      ((Element)v.get(385)).setAttribute("height","8" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:386 / Elemento padre: 375   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(386)).setAttribute("nombre","valFormFechTdId" );
      ((Element)v.get(375)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(387)).setAttribute("width","100%" );
      ((Element)v.get(387)).setAttribute("border","0" );
      ((Element)v.get(387)).setAttribute("cellspacing","0" );
      ((Element)v.get(387)).setAttribute("cellpadding","0" );
      ((Element)v.get(387)).setAttribute("align","left" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(389)).setAttribute("valign","top" );
      ((Element)v.get(389)).setAttribute("height","13" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(390)).setAttribute("nombre","lblValFormFech" );
      ((Element)v.get(390)).setAttribute("ancho","150" );
      ((Element)v.get(390)).setAttribute("alto","13" );
      ((Element)v.get(390)).setAttribute("filas","1" );
      ((Element)v.get(390)).setAttribute("id","datosTitle" );
      ((Element)v.get(390)).setAttribute("cod","SegPaisView.valFormFech.label" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:391 / Elemento padre: 387   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(391)).setAttribute("nombre","valFormFechWidgetTrId" );
      ((Element)v.get(387)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(392)).setAttribute("align","left" );
      ((Element)v.get(392)).setAttribute("nowrap","true" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(393)).setAttribute("nombre","valFormFech" );
      ((Element)v.get(393)).setAttribute("id","datosCampos" );
      ((Element)v.get(393)).setAttribute("multiple","N" );
      ((Element)v.get(393)).setAttribute("req","N" );
      ((Element)v.get(393)).setAttribute("size","1" );
      ((Element)v.get(393)).setAttribute("validacion","" );
      ((Element)v.get(393)).setAttribute("onchange","" );
      ((Element)v.get(393)).setAttribute("onfocus","" );
      ((Element)v.get(393)).setAttribute("valorinicial","" );
      ((Element)v.get(393)).setAttribute("textoinicial","" );
      ((Element)v.get(393)).setAttribute("disabled","" );
      ((Element)v.get(393)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',21, true)" );
      ((Element)v.get(393)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',21, false)" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("ROWSET"));
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(395)).setAttribute("ID","dd/mm/yyyy" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(396)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(396)).setAttribute("TIPO","STRING" );
      ((Element)v.get(396)).setAttribute("VALOR","dd/mm/yyyy" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */

      /* Empieza nodo:397 / Elemento padre: 395   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(397)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(397)).setAttribute("TIPO","STRING" );
      ((Element)v.get(397)).setAttribute("VALOR","dd/mm/aaaa" );
      ((Element)v.get(395)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:395   */

      /* Empieza nodo:398 / Elemento padre: 394   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(398)).setAttribute("ID","mm/dd/yyyy" );
      ((Element)v.get(394)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(399)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(399)).setAttribute("TIPO","STRING" );
      ((Element)v.get(399)).setAttribute("VALOR","mm/dd/yyyy" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */

      /* Empieza nodo:400 / Elemento padre: 398   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(400)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(400)).setAttribute("TIPO","STRING" );
      ((Element)v.get(400)).setAttribute("VALOR","mm/dd/aaaa" );
      ((Element)v.get(398)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:398   */

      /* Empieza nodo:401 / Elemento padre: 394   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(401)).setAttribute("ID","dd-mm-yyyy" );
      ((Element)v.get(394)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(402)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(402)).setAttribute("TIPO","STRING" );
      ((Element)v.get(402)).setAttribute("VALOR","dd-mm-yyyy" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */

      /* Empieza nodo:403 / Elemento padre: 401   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(403)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(403)).setAttribute("TIPO","STRING" );
      ((Element)v.get(403)).setAttribute("VALOR","dd-mm-aaaa" );
      ((Element)v.get(401)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:401   */
      /* Termina nodo:394   */
      /* Termina nodo:393   */
      /* Termina nodo:392   */
      /* Termina nodo:391   */
      /* Termina nodo:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:404 / Elemento padre: 375   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(404)).setAttribute("nombre","valFormFechGapTdId" );
      ((Element)v.get(404)).setAttribute("nowrap","true" );
      ((Element)v.get(404)).setAttribute("class","datosCampos" );
      ((Element)v.get(375)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(405)).setAttribute("src","b.gif" );
      ((Element)v.get(405)).setAttribute("width","25" );
      ((Element)v.get(405)).setAttribute("height","8" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:406 / Elemento padre: 375   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(406)).setAttribute("nombre","valSepaMileTdId" );
      ((Element)v.get(375)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(407)).setAttribute("width","100%" );
      ((Element)v.get(407)).setAttribute("border","0" );
      ((Element)v.get(407)).setAttribute("cellspacing","0" );
      ((Element)v.get(407)).setAttribute("cellpadding","0" );
      ((Element)v.get(407)).setAttribute("align","left" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(407)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(409)).setAttribute("valign","top" );
      ((Element)v.get(409)).setAttribute("height","13" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(410)).setAttribute("nombre","lblValSepaMile" );
      ((Element)v.get(410)).setAttribute("ancho","150" );
      ((Element)v.get(410)).setAttribute("alto","13" );
      ((Element)v.get(410)).setAttribute("filas","1" );
      ((Element)v.get(410)).setAttribute("id","datosTitle" );
      ((Element)v.get(410)).setAttribute("cod","SegPaisView.valSepaMile.label" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */
      /* Termina nodo:408   */

      /* Empieza nodo:411 / Elemento padre: 407   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(411)).setAttribute("nombre","valSepaMileWidgetTrId" );
      ((Element)v.get(407)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(412)).setAttribute("align","left" );
      ((Element)v.get(412)).setAttribute("nowrap","true" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(413)).setAttribute("nombre","valSepaMile" );
      ((Element)v.get(413)).setAttribute("id","datosCampos" );
      ((Element)v.get(413)).setAttribute("multiple","N" );
      ((Element)v.get(413)).setAttribute("req","N" );
      ((Element)v.get(413)).setAttribute("size","1" );
      ((Element)v.get(413)).setAttribute("validacion","" );
      ((Element)v.get(413)).setAttribute("onchange","" );
      ((Element)v.get(413)).setAttribute("onfocus","" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(413)).setAttribute("valorinicial","" );
      ((Element)v.get(413)).setAttribute("textoinicial","" );
      ((Element)v.get(413)).setAttribute("disabled","" );
      ((Element)v.get(413)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',22, true)" );
      ((Element)v.get(413)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',22, false)" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(413)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(415)).setAttribute("ID","," );
      ((Element)v.get(414)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(416)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(416)).setAttribute("TIPO","STRING" );
      ((Element)v.get(416)).setAttribute("VALOR","," );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */

      /* Empieza nodo:417 / Elemento padre: 415   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(417)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(417)).setAttribute("TIPO","STRING" );
      ((Element)v.get(417)).setAttribute("VALOR","," );
      ((Element)v.get(415)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:415   */

      /* Empieza nodo:418 / Elemento padre: 414   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(418)).setAttribute("ID","." );
      ((Element)v.get(414)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(419)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(419)).setAttribute("TIPO","STRING" );
      ((Element)v.get(419)).setAttribute("VALOR","." );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */

      /* Empieza nodo:420 / Elemento padre: 418   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(420)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(420)).setAttribute("TIPO","STRING" );
      ((Element)v.get(420)).setAttribute("VALOR","." );
      ((Element)v.get(418)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:418   */
      /* Termina nodo:414   */
      /* Termina nodo:413   */
      /* Termina nodo:412   */
      /* Termina nodo:411   */
      /* Termina nodo:407   */
      /* Termina nodo:406   */

      /* Empieza nodo:421 / Elemento padre: 375   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(421)).setAttribute("nombre","valSepaMileGapTdId" );
      ((Element)v.get(421)).setAttribute("nowrap","true" );
      ((Element)v.get(421)).setAttribute("class","datosCampos" );
      ((Element)v.get(375)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(422)).setAttribute("src","b.gif" );
      ((Element)v.get(422)).setAttribute("width","25" );
      ((Element)v.get(422)).setAttribute("height","8" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:421   */

      /* Empieza nodo:423 / Elemento padre: 375   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(423)).setAttribute("nombre","valSepaDeciTdId" );
      ((Element)v.get(375)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(424)).setAttribute("width","100%" );
      ((Element)v.get(424)).setAttribute("border","0" );
      ((Element)v.get(424)).setAttribute("cellspacing","0" );
      ((Element)v.get(424)).setAttribute("cellpadding","0" );
      ((Element)v.get(424)).setAttribute("align","left" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(424)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(426)).setAttribute("valign","top" );
      ((Element)v.get(426)).setAttribute("height","13" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(427)).setAttribute("nombre","lblValSepaDeci" );
      ((Element)v.get(427)).setAttribute("ancho","150" );
      ((Element)v.get(427)).setAttribute("alto","13" );
      ((Element)v.get(427)).setAttribute("filas","1" );
      ((Element)v.get(427)).setAttribute("id","datosTitle" );
      ((Element)v.get(427)).setAttribute("cod","SegPaisView.valSepaDeci.label" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */
      /* Termina nodo:425   */

      /* Empieza nodo:428 / Elemento padre: 424   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(428)).setAttribute("nombre","valSepaDeciWidgetTrId" );
      ((Element)v.get(424)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(429)).setAttribute("align","left" );
      ((Element)v.get(429)).setAttribute("nowrap","true" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(430)).setAttribute("nombre","valSepaDeci" );
      ((Element)v.get(430)).setAttribute("id","datosCampos" );
      ((Element)v.get(430)).setAttribute("multiple","N" );
      ((Element)v.get(430)).setAttribute("req","N" );
      ((Element)v.get(430)).setAttribute("size","1" );
      ((Element)v.get(430)).setAttribute("validacion","" );
      ((Element)v.get(430)).setAttribute("onchange","" );
      ((Element)v.get(430)).setAttribute("onfocus","" );
      ((Element)v.get(430)).setAttribute("valorinicial","" );
      ((Element)v.get(430)).setAttribute("textoinicial","" );
      ((Element)v.get(430)).setAttribute("disabled","" );
      ((Element)v.get(430)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',23, true)" );
      ((Element)v.get(430)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',23, false)" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
   }

   private void getXML2070(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(432)).setAttribute("ID","," );
      ((Element)v.get(431)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(433)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(433)).setAttribute("TIPO","STRING" );
      ((Element)v.get(433)).setAttribute("VALOR","," );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */

      /* Empieza nodo:434 / Elemento padre: 432   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(434)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(434)).setAttribute("TIPO","STRING" );
      ((Element)v.get(434)).setAttribute("VALOR","," );
      ((Element)v.get(432)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:432   */

      /* Empieza nodo:435 / Elemento padre: 431   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(435)).setAttribute("ID","." );
      ((Element)v.get(431)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(436)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(436)).setAttribute("TIPO","STRING" );
      ((Element)v.get(436)).setAttribute("VALOR","." );
      ((Element)v.get(435)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */

      /* Empieza nodo:437 / Elemento padre: 435   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(437)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(437)).setAttribute("TIPO","STRING" );
      ((Element)v.get(437)).setAttribute("VALOR","." );
      ((Element)v.get(435)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:435   */
      /* Termina nodo:431   */
      /* Termina nodo:430   */
      /* Termina nodo:429   */
      /* Termina nodo:428   */
      /* Termina nodo:424   */
      /* Termina nodo:423   */

      /* Empieza nodo:438 / Elemento padre: 375   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(438)).setAttribute("nombre","valSepaDeciGapTdId" );
      ((Element)v.get(438)).setAttribute("nowrap","true" );
      ((Element)v.get(438)).setAttribute("class","datosCampos" );
      ((Element)v.get(375)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(439)).setAttribute("src","b.gif" );
      ((Element)v.get(439)).setAttribute("width","25" );
      ((Element)v.get(439)).setAttribute("height","8" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */
      /* Termina nodo:438   */

      /* Empieza nodo:440 / Elemento padre: 375   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(440)).setAttribute("nombre","numPeriEgreTdId" );
      ((Element)v.get(375)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(441)).setAttribute("width","100%" );
      ((Element)v.get(441)).setAttribute("border","0" );
      ((Element)v.get(441)).setAttribute("cellspacing","0" );
      ((Element)v.get(441)).setAttribute("cellpadding","0" );
      ((Element)v.get(441)).setAttribute("align","left" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(441)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(443)).setAttribute("valign","top" );
      ((Element)v.get(443)).setAttribute("height","13" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(444)).setAttribute("nombre","lblNumPeriEgre" );
      ((Element)v.get(444)).setAttribute("alto","13" );
      ((Element)v.get(444)).setAttribute("filas","1" );
      ((Element)v.get(444)).setAttribute("id","datosTitle" );
      ((Element)v.get(444)).setAttribute("cod","SegPaisView.numPeriEgre.label" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */
      /* Termina nodo:442   */

      /* Empieza nodo:445 / Elemento padre: 441   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(445)).setAttribute("nombre","numPeriEgreWidgetTrId" );
      ((Element)v.get(441)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(446)).setAttribute("align","left" );
      ((Element)v.get(446)).setAttribute("nowrap","true" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(447)).setAttribute("nombre","numPeriEgre" );
      ((Element)v.get(447)).setAttribute("id","datosCampos" );
      ((Element)v.get(447)).setAttribute("trim","S" );
      ((Element)v.get(447)).setAttribute("max","2" );
      ((Element)v.get(447)).setAttribute("onchange","" );
      ((Element)v.get(447)).setAttribute("req","N" );
      ((Element)v.get(447)).setAttribute("size","2" );
      ((Element)v.get(447)).setAttribute("valor","" );
      ((Element)v.get(447)).setAttribute("validacion","" );
      ((Element)v.get(447)).setAttribute("disabled","" );
      ((Element)v.get(447)).setAttribute("onblur","" );
      ((Element)v.get(447)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',24, true)" );
      ((Element)v.get(447)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 24, false)" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */
      /* Termina nodo:445   */
      /* Termina nodo:441   */
      /* Termina nodo:440   */

      /* Empieza nodo:448 / Elemento padre: 375   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(448)).setAttribute("nombre","numPeriEgreGapTdId" );
      ((Element)v.get(448)).setAttribute("nowrap","true" );
      ((Element)v.get(448)).setAttribute("class","datosCampos" );
      ((Element)v.get(375)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(449)).setAttribute("src","b.gif" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(449)).setAttribute("width","25" );
      ((Element)v.get(449)).setAttribute("height","8" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:448   */

      /* Empieza nodo:450 / Elemento padre: 375   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(450)).setAttribute("width","100%" );
      ((Element)v.get(375)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(451)).setAttribute("src","b.gif" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */
      /* Termina nodo:375   */
      /* Termina nodo:374   */
      /* Termina nodo:373   */
      /* Termina nodo:370   */

      /* Empieza nodo:452 / Elemento padre: 57   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(452)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(57)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(453)).setAttribute("align","center" );
      ((Element)v.get(453)).setAttribute("width","8" );
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
      ((Element)v.get(457)).setAttribute("width","8" );
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

      /* Empieza nodo:459 / Elemento padre: 57   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(459)).setAttribute("nombre","formTr6" );
      ((Element)v.get(57)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(460)).setAttribute("align","center" );
      ((Element)v.get(460)).setAttribute("width","8" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(461)).setAttribute("src","b.gif" );
      ((Element)v.get(461)).setAttribute("width","8" );
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
      ((Element)v.get(465)).setAttribute("nombre","numPeriRetiTdId" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(466)).setAttribute("width","100%" );
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
      ((Element)v.get(469)).setAttribute("nombre","lblNumPeriReti" );
      ((Element)v.get(469)).setAttribute("alto","13" );
      ((Element)v.get(469)).setAttribute("filas","1" );
      ((Element)v.get(469)).setAttribute("id","datosTitle" );
      ((Element)v.get(469)).setAttribute("cod","SegPaisView.numPeriReti.label" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */
      /* Termina nodo:467   */

      /* Empieza nodo:470 / Elemento padre: 466   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(470)).setAttribute("nombre","numPeriRetiWidgetTrId" );
      ((Element)v.get(466)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(471)).setAttribute("align","left" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(471)).setAttribute("nowrap","true" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(472)).setAttribute("nombre","numPeriReti" );
      ((Element)v.get(472)).setAttribute("id","datosCampos" );
      ((Element)v.get(472)).setAttribute("trim","S" );
      ((Element)v.get(472)).setAttribute("max","2" );
      ((Element)v.get(472)).setAttribute("onchange","" );
      ((Element)v.get(472)).setAttribute("req","N" );
      ((Element)v.get(472)).setAttribute("size","2" );
      ((Element)v.get(472)).setAttribute("valor","" );
      ((Element)v.get(472)).setAttribute("validacion","" );
      ((Element)v.get(472)).setAttribute("disabled","" );
      ((Element)v.get(472)).setAttribute("onblur","" );
      ((Element)v.get(472)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',25, true)" );
      ((Element)v.get(472)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 25, false)" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */
      /* Termina nodo:471   */
      /* Termina nodo:470   */
      /* Termina nodo:466   */
      /* Termina nodo:465   */

      /* Empieza nodo:473 / Elemento padre: 464   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(473)).setAttribute("nombre","numPeriRetiGapTdId" );
      ((Element)v.get(473)).setAttribute("nowrap","true" );
      ((Element)v.get(473)).setAttribute("class","datosCampos" );
      ((Element)v.get(464)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(474)).setAttribute("src","b.gif" );
      ((Element)v.get(474)).setAttribute("width","25" );
      ((Element)v.get(474)).setAttribute("height","8" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:473   */

      /* Empieza nodo:475 / Elemento padre: 464   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(475)).setAttribute("nombre","fopaOidFormPagoTdId" );
      ((Element)v.get(464)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(476)).setAttribute("border","0" );
      ((Element)v.get(476)).setAttribute("cellspacing","0" );
      ((Element)v.get(476)).setAttribute("cellpadding","0" );
      ((Element)v.get(476)).setAttribute("align","left" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(476)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(478)).setAttribute("valign","top" );
      ((Element)v.get(478)).setAttribute("height","13" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(479)).setAttribute("nombre","lblfopaOidFormPago" );
      ((Element)v.get(479)).setAttribute("id","datosTitle" );
      ((Element)v.get(479)).setAttribute("ancho","150" );
      ((Element)v.get(479)).setAttribute("alto","13" );
      ((Element)v.get(479)).setAttribute("cod","SegPaisView.fopaOidFormPago.label" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */
      /* Termina nodo:478   */
      /* Termina nodo:477   */

      /* Empieza nodo:480 / Elemento padre: 476   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(480)).setAttribute("nombre","fopaOidFormPagoWidgetTrId" );
      ((Element)v.get(476)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(481)).setAttribute("align","left" );
      ((Element)v.get(481)).setAttribute("nowrap","true" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(482)).setAttribute("nombre","fopaOidFormPago" );
      ((Element)v.get(482)).setAttribute("id","datosCampos" );
      ((Element)v.get(482)).setAttribute("multiple","N" );
      ((Element)v.get(482)).setAttribute("req","N" );
      ((Element)v.get(482)).setAttribute("size","1" );
      ((Element)v.get(482)).setAttribute("disabled","" );
      ((Element)v.get(482)).setAttribute("validacion","" );
      ((Element)v.get(482)).setAttribute("onchange","" );
      ((Element)v.get(482)).setAttribute("onfocus","" );
      ((Element)v.get(482)).setAttribute("valorinicial","" );
      ((Element)v.get(482)).setAttribute("textoinicial","" );
      ((Element)v.get(482)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',26, true);" );
      ((Element)v.get(482)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',26, false);" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(482)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */
      /* Termina nodo:482   */
      /* Termina nodo:481   */
      /* Termina nodo:480   */
      /* Termina nodo:476   */
      /* Termina nodo:475   */

      /* Empieza nodo:484 / Elemento padre: 464   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(484)).setAttribute("nombre","fopaOidFormPagoGapTdId" );
      ((Element)v.get(484)).setAttribute("nowrap","true" );
      ((Element)v.get(484)).setAttribute("class","datosCampos" );
      ((Element)v.get(464)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(485)).setAttribute("src","b.gif" );
      ((Element)v.get(485)).setAttribute("width","25" );
      ((Element)v.get(485)).setAttribute("height","8" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */
      /* Termina nodo:484   */

      /* Empieza nodo:486 / Elemento padre: 464   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(486)).setAttribute("nombre","valCompTeleTdId" );
      ((Element)v.get(464)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(487)).setAttribute("width","100%" );
      ((Element)v.get(487)).setAttribute("border","0" );
      ((Element)v.get(487)).setAttribute("cellspacing","0" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(487)).setAttribute("cellpadding","0" );
      ((Element)v.get(487)).setAttribute("align","left" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(487)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(489)).setAttribute("valign","top" );
      ((Element)v.get(489)).setAttribute("height","13" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(490)).setAttribute("nombre","lblValCompTele" );
      ((Element)v.get(490)).setAttribute("alto","13" );
      ((Element)v.get(490)).setAttribute("filas","1" );
      ((Element)v.get(490)).setAttribute("id","datosTitle" );
      ((Element)v.get(490)).setAttribute("cod","SegPaisView.valCompTele.label" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */
      /* Termina nodo:489   */
      /* Termina nodo:488   */

      /* Empieza nodo:491 / Elemento padre: 487   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(491)).setAttribute("nombre","valCompTeleWidgetTrId" );
      ((Element)v.get(487)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(492)).setAttribute("align","left" );
      ((Element)v.get(492)).setAttribute("nowrap","true" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(493)).setAttribute("nombre","valCompTele" );
      ((Element)v.get(493)).setAttribute("id","datosCampos" );
      ((Element)v.get(493)).setAttribute("trim","S" );
      ((Element)v.get(493)).setAttribute("max","40" );
      ((Element)v.get(493)).setAttribute("onchange","" );
      ((Element)v.get(493)).setAttribute("req","N" );
      ((Element)v.get(493)).setAttribute("size","40" );
      ((Element)v.get(493)).setAttribute("valor","" );
      ((Element)v.get(493)).setAttribute("validacion","" );
      ((Element)v.get(493)).setAttribute("disabled","" );
      ((Element)v.get(493)).setAttribute("onblur","" );
      ((Element)v.get(493)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',27, true)" );
      ((Element)v.get(493)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 27, false)" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */
      /* Termina nodo:492   */
      /* Termina nodo:491   */
      /* Termina nodo:487   */
      /* Termina nodo:486   */

      /* Empieza nodo:494 / Elemento padre: 464   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(494)).setAttribute("nombre","valCompTeleGapTdId" );
      ((Element)v.get(494)).setAttribute("nowrap","true" );
      ((Element)v.get(494)).setAttribute("class","datosCampos" );
      ((Element)v.get(464)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(495)).setAttribute("src","b.gif" );
      ((Element)v.get(495)).setAttribute("width","25" );
      ((Element)v.get(495)).setAttribute("height","8" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:496 / Elemento padre: 464   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(496)).setAttribute("width","100%" );
      ((Element)v.get(464)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(497)).setAttribute("src","b.gif" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */
      /* Termina nodo:496   */
      /* Termina nodo:464   */
      /* Termina nodo:463   */
      /* Termina nodo:462   */
      /* Termina nodo:459   */

      /* Empieza nodo:498 / Elemento padre: 57   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(498)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(57)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(499)).setAttribute("align","center" );
      ((Element)v.get(499)).setAttribute("width","8" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(500)).setAttribute("src","b.gif" );
      ((Element)v.get(500)).setAttribute("width","12" );
      ((Element)v.get(500)).setAttribute("height","8" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */
      /* Termina nodo:499   */

      /* Empieza nodo:501 / Elemento padre: 498   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(498)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(502)).setAttribute("src","b.gif" );
      ((Element)v.get(502)).setAttribute("width","8" );
      ((Element)v.get(502)).setAttribute("height","8" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */
      /* Termina nodo:501   */

      /* Empieza nodo:503 / Elemento padre: 498   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(503)).setAttribute("align","center" );
      ((Element)v.get(503)).setAttribute("width","8" );
      ((Element)v.get(498)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(504)).setAttribute("src","b.gif" );
      ((Element)v.get(504)).setAttribute("width","12" );
      ((Element)v.get(504)).setAttribute("height","8" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */
      /* Termina nodo:503   */
      /* Termina nodo:498   */

      /* Empieza nodo:505 / Elemento padre: 57   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(505)).setAttribute("nombre","formTr7" );
      ((Element)v.get(57)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(506)).setAttribute("align","center" );
      ((Element)v.get(506)).setAttribute("width","8" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(507)).setAttribute("src","b.gif" );
      ((Element)v.get(507)).setAttribute("width","8" );
      ((Element)v.get(507)).setAttribute("height","12" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */
      /* Termina nodo:506   */

      /* Empieza nodo:508 / Elemento padre: 505   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(508)).setAttribute("width","100%" );
      ((Element)v.get(505)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(509)).setAttribute("width","100%" );
      ((Element)v.get(509)).setAttribute("border","0" );
      ((Element)v.get(509)).setAttribute("cellspacing","0" );
      ((Element)v.get(509)).setAttribute("cellpadding","0" );
      ((Element)v.get(509)).setAttribute("align","left" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(510)).setAttribute("align","left" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(511)).setAttribute("nombre","indFletZonaUbigTdId" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(512)).setAttribute("width","100%" );
      ((Element)v.get(512)).setAttribute("border","0" );
      ((Element)v.get(512)).setAttribute("cellspacing","0" );
      ((Element)v.get(512)).setAttribute("cellpadding","0" );
      ((Element)v.get(512)).setAttribute("align","left" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(512)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(514)).setAttribute("valign","top" );
      ((Element)v.get(514)).setAttribute("height","13" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(515)).setAttribute("nombre","lblIndFletZonaUbig" );
      ((Element)v.get(515)).setAttribute("ancho","150" );
      ((Element)v.get(515)).setAttribute("alto","13" );
      ((Element)v.get(515)).setAttribute("filas","1" );
      ((Element)v.get(515)).setAttribute("id","datosTitle" );
      ((Element)v.get(515)).setAttribute("cod","SegPaisView.indFletZonaUbig.label" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:514   */
      /* Termina nodo:513   */

      /* Empieza nodo:516 / Elemento padre: 512   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(516)).setAttribute("nombre","indFletZonaUbigWidgetTrId" );
      ((Element)v.get(512)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(517)).setAttribute("align","left" );
      ((Element)v.get(517)).setAttribute("nowrap","true" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(518)).setAttribute("nombre","indFletZonaUbig" );
      ((Element)v.get(518)).setAttribute("id","datosCampos" );
      ((Element)v.get(518)).setAttribute("multiple","N" );
      ((Element)v.get(518)).setAttribute("req","N" );
      ((Element)v.get(518)).setAttribute("size","1" );
      ((Element)v.get(518)).setAttribute("validacion","" );
      ((Element)v.get(518)).setAttribute("onchange","" );
      ((Element)v.get(518)).setAttribute("onfocus","" );
      ((Element)v.get(518)).setAttribute("valorinicial","" );
      ((Element)v.get(518)).setAttribute("textoinicial","" );
      ((Element)v.get(518)).setAttribute("disabled","" );
      ((Element)v.get(518)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',28, true)" );
      ((Element)v.get(518)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',28, false)" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(518)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(520)).setAttribute("ID","U" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(521)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(521)).setAttribute("TIPO","STRING" );
      ((Element)v.get(521)).setAttribute("VALOR","U" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */

      /* Empieza nodo:522 / Elemento padre: 520   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(522)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(522)).setAttribute("TIPO","STRING" );
      ((Element)v.get(522)).setAttribute("VALOR","Ubigeo" );
      ((Element)v.get(520)).appendChild((Element)v.get(522));
      /* Termina nodo:522   */
      /* Termina nodo:520   */

      /* Empieza nodo:523 / Elemento padre: 519   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(523)).setAttribute("ID","Z" );
      ((Element)v.get(519)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(524)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(524)).setAttribute("TIPO","STRING" );
      ((Element)v.get(524)).setAttribute("VALOR","Z" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */

      /* Empieza nodo:525 / Elemento padre: 523   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(525)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(525)).setAttribute("TIPO","STRING" );
      ((Element)v.get(525)).setAttribute("VALOR","Zona" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(523)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:523   */
      /* Termina nodo:519   */
      /* Termina nodo:518   */
      /* Termina nodo:517   */
      /* Termina nodo:516   */
      /* Termina nodo:512   */
      /* Termina nodo:511   */

      /* Empieza nodo:526 / Elemento padre: 510   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(526)).setAttribute("nombre","indFletZonaUbigGapTdId" );
      ((Element)v.get(526)).setAttribute("nowrap","true" );
      ((Element)v.get(526)).setAttribute("class","datosCampos" );
      ((Element)v.get(510)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(527)).setAttribute("src","b.gif" );
      ((Element)v.get(527)).setAttribute("width","25" );
      ((Element)v.get(527)).setAttribute("height","8" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */

      /* Empieza nodo:528 / Elemento padre: 510   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(528)).setAttribute("nombre","valIndiSecuMoniTdId" );
      ((Element)v.get(510)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(529)).setAttribute("width","100%" );
      ((Element)v.get(529)).setAttribute("border","0" );
      ((Element)v.get(529)).setAttribute("cellspacing","0" );
      ((Element)v.get(529)).setAttribute("cellpadding","0" );
      ((Element)v.get(529)).setAttribute("align","left" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(529)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(531)).setAttribute("valign","top" );
      ((Element)v.get(531)).setAttribute("height","13" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(532)).setAttribute("nombre","lblValIndiSecuMoni" );
      ((Element)v.get(532)).setAttribute("alto","13" );
      ((Element)v.get(532)).setAttribute("filas","1" );
      ((Element)v.get(532)).setAttribute("id","datosTitle" );
      ((Element)v.get(532)).setAttribute("cod","SegPaisView.valIndiSecuMoni.label" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:531   */
      /* Termina nodo:530   */

      /* Empieza nodo:533 / Elemento padre: 529   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(533)).setAttribute("nombre","valIndiSecuMoniWidgetTrId" );
      ((Element)v.get(529)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(534)).setAttribute("align","left" );
      ((Element)v.get(534)).setAttribute("nowrap","true" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(535)).setAttribute("nombre","valIndiSecuMoni" );
      ((Element)v.get(535)).setAttribute("tipo","H" );
      ((Element)v.get(535)).setAttribute("req","N" );
      ((Element)v.get(535)).setAttribute("id","datosCampos" );
      ((Element)v.get(535)).setAttribute("valor","" );
      ((Element)v.get(535)).setAttribute("disabled","" );
      ((Element)v.get(535)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',29, true)" );
      ((Element)v.get(535)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',29, false)" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(536)).setAttribute("id","datosCampos" );
      ((Element)v.get(536)).setAttribute("valor","1" );
      ((Element)v.get(536)).setAttribute("cod","SegPaisView.valIndiSecuMoni.1.label" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));

      /* Elemento padre:536 / Elemento actual: 537   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(536)).appendChild((Text)v.get(537));

      /* Termina nodo Texto:537   */
      /* Termina nodo:536   */

      /* Empieza nodo:538 / Elemento padre: 535   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(538)).setAttribute("id","datosCampos" );
      ((Element)v.get(538)).setAttribute("valor","0" );
      ((Element)v.get(538)).setAttribute("cod","SegPaisView.valIndiSecuMoni.0.label" );
      ((Element)v.get(535)).appendChild((Element)v.get(538));

      /* Elemento padre:538 / Elemento actual: 539   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(538)).appendChild((Text)v.get(539));

      /* Termina nodo Texto:539   */
      /* Termina nodo:538   */
      /* Termina nodo:535   */
      /* Termina nodo:534   */
      /* Termina nodo:533   */
      /* Termina nodo:529   */
      /* Termina nodo:528   */

      /* Empieza nodo:540 / Elemento padre: 510   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(540)).setAttribute("nombre","valIndiSecuMoniGapTdId" );
      ((Element)v.get(540)).setAttribute("nowrap","true" );
      ((Element)v.get(540)).setAttribute("class","datosCampos" );
      ((Element)v.get(510)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(541)).setAttribute("src","b.gif" );
      ((Element)v.get(541)).setAttribute("width","25" );
      ((Element)v.get(541)).setAttribute("height","8" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */
      /* Termina nodo:540   */

      /* Empieza nodo:542 / Elemento padre: 510   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(542)).setAttribute("nombre","indSecuTdId" );
      ((Element)v.get(510)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(543)).setAttribute("width","100%" );
      ((Element)v.get(543)).setAttribute("border","0" );
      ((Element)v.get(543)).setAttribute("cellspacing","0" );
      ((Element)v.get(543)).setAttribute("cellpadding","0" );
      ((Element)v.get(543)).setAttribute("align","left" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(543)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(545)).setAttribute("valign","top" );
      ((Element)v.get(545)).setAttribute("height","13" );
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(544)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(546)).setAttribute("nombre","lblIndSecu" );
      ((Element)v.get(546)).setAttribute("ancho","150" );
      ((Element)v.get(546)).setAttribute("alto","13" );
      ((Element)v.get(546)).setAttribute("filas","1" );
      ((Element)v.get(546)).setAttribute("id","datosTitle" );
      ((Element)v.get(546)).setAttribute("cod","SegPaisView.indSecu.label" );
      ((Element)v.get(545)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */
      /* Termina nodo:545   */
      /* Termina nodo:544   */

      /* Empieza nodo:547 / Elemento padre: 543   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(547)).setAttribute("nombre","indSecuWidgetTrId" );
      ((Element)v.get(543)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(548)).setAttribute("align","left" );
      ((Element)v.get(548)).setAttribute("nowrap","true" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(549)).setAttribute("nombre","indSecu" );
      ((Element)v.get(549)).setAttribute("id","datosCampos" );
      ((Element)v.get(549)).setAttribute("multiple","N" );
      ((Element)v.get(549)).setAttribute("req","N" );
      ((Element)v.get(549)).setAttribute("size","1" );
      ((Element)v.get(549)).setAttribute("validacion","" );
      ((Element)v.get(549)).setAttribute("onchange","" );
      ((Element)v.get(549)).setAttribute("onfocus","" );
      ((Element)v.get(549)).setAttribute("valorinicial","" );
      ((Element)v.get(549)).setAttribute("textoinicial","" );
      ((Element)v.get(549)).setAttribute("disabled","" );
      ((Element)v.get(549)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',30, true)" );
      ((Element)v.get(549)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',30, false)" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(549)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(551)).setAttribute("ID","M" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(552)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(552)).setAttribute("TIPO","STRING" );
      ((Element)v.get(552)).setAttribute("VALOR","M" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */

      /* Empieza nodo:553 / Elemento padre: 551   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(553)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(553)).setAttribute("TIPO","STRING" );
      ((Element)v.get(553)).setAttribute("VALOR","Monto" );
      ((Element)v.get(551)).appendChild((Element)v.get(553));
      /* Termina nodo:553   */
      /* Termina nodo:551   */

      /* Empieza nodo:554 / Elemento padre: 550   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(554)).setAttribute("ID","T" );
      ((Element)v.get(550)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(555)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(555)).setAttribute("TIPO","STRING" );
      ((Element)v.get(555)).setAttribute("VALOR","T" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));
      /* Termina nodo:555   */

      /* Empieza nodo:556 / Elemento padre: 554   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(556)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(556)).setAttribute("TIPO","STRING" );
      ((Element)v.get(556)).setAttribute("VALOR","Transporte" );
      ((Element)v.get(554)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */
      /* Termina nodo:554   */
      /* Termina nodo:550   */
      /* Termina nodo:549   */
      /* Termina nodo:548   */
      /* Termina nodo:547   */
      /* Termina nodo:543   */
      /* Termina nodo:542   */

      /* Empieza nodo:557 / Elemento padre: 510   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(557)).setAttribute("nombre","indSecuGapTdId" );
      ((Element)v.get(557)).setAttribute("nowrap","true" );
      ((Element)v.get(557)).setAttribute("class","datosCampos" );
      ((Element)v.get(510)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(558)).setAttribute("src","b.gif" );
      ((Element)v.get(558)).setAttribute("width","25" );
      ((Element)v.get(558)).setAttribute("height","8" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));
      /* Termina nodo:558   */
      /* Termina nodo:557   */

      /* Empieza nodo:559 / Elemento padre: 510   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(559)).setAttribute("nombre","indBalaAreaCheqTdId" );
      ((Element)v.get(510)).appendChild((Element)v.get(559));

      /* Empieza nodo:560 / Elemento padre: 559   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(560)).setAttribute("width","100%" );
      ((Element)v.get(560)).setAttribute("border","0" );
      ((Element)v.get(560)).setAttribute("cellspacing","0" );
      ((Element)v.get(560)).setAttribute("cellpadding","0" );
      ((Element)v.get(560)).setAttribute("align","left" );
      ((Element)v.get(559)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(560)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(562)).setAttribute("valign","top" );
      ((Element)v.get(562)).setAttribute("height","13" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(563)).setAttribute("nombre","lblIndBalaAreaCheq" );
      ((Element)v.get(563)).setAttribute("ancho","150" );
      ((Element)v.get(563)).setAttribute("alto","13" );
      ((Element)v.get(563)).setAttribute("filas","1" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(563)).setAttribute("id","datosTitle" );
      ((Element)v.get(563)).setAttribute("cod","SegPaisView.indBalaAreaCheq.label" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */
      /* Termina nodo:562   */
      /* Termina nodo:561   */

      /* Empieza nodo:564 / Elemento padre: 560   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(564)).setAttribute("nombre","indBalaAreaCheqWidgetTrId" );
      ((Element)v.get(560)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(565)).setAttribute("align","left" );
      ((Element)v.get(565)).setAttribute("nowrap","true" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(566)).setAttribute("nombre","indBalaAreaCheq" );
      ((Element)v.get(566)).setAttribute("id","datosCampos" );
      ((Element)v.get(566)).setAttribute("multiple","N" );
      ((Element)v.get(566)).setAttribute("req","N" );
      ((Element)v.get(566)).setAttribute("size","1" );
      ((Element)v.get(566)).setAttribute("validacion","" );
      ((Element)v.get(566)).setAttribute("onchange","" );
      ((Element)v.get(566)).setAttribute("onfocus","" );
      ((Element)v.get(566)).setAttribute("valorinicial","" );
      ((Element)v.get(566)).setAttribute("textoinicial","" );
      ((Element)v.get(566)).setAttribute("disabled","" );
      ((Element)v.get(566)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',31, true)" );
      ((Element)v.get(566)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',31, false)" );
      ((Element)v.get(565)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(566)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(568)).setAttribute("ID","P" );
      ((Element)v.get(567)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(569)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(569)).setAttribute("TIPO","STRING" );
      ((Element)v.get(569)).setAttribute("VALOR","P" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */

      /* Empieza nodo:570 / Elemento padre: 568   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(570)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(570)).setAttribute("TIPO","STRING" );
      ((Element)v.get(570)).setAttribute("VALOR","MODELO PERU" );
      ((Element)v.get(568)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */
      /* Termina nodo:568   */

      /* Empieza nodo:571 / Elemento padre: 567   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(571)).setAttribute("ID","C" );
      ((Element)v.get(567)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(572)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(572)).setAttribute("TIPO","STRING" );
      ((Element)v.get(572)).setAttribute("VALOR","C" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));
      /* Termina nodo:572   */

      /* Empieza nodo:573 / Elemento padre: 571   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(573)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(573)).setAttribute("TIPO","STRING" );
      ((Element)v.get(573)).setAttribute("VALOR","MODELO COLOMBIA" );
      ((Element)v.get(571)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:571   */
      /* Termina nodo:567   */
      /* Termina nodo:566   */
      /* Termina nodo:565   */
      /* Termina nodo:564   */
      /* Termina nodo:560   */
      /* Termina nodo:559   */

      /* Empieza nodo:574 / Elemento padre: 510   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(574)).setAttribute("nombre","indBalaAreaCheqGapTdId" );
      ((Element)v.get(574)).setAttribute("nowrap","true" );
      ((Element)v.get(574)).setAttribute("class","datosCampos" );
      ((Element)v.get(510)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(575)).setAttribute("src","b.gif" );
      ((Element)v.get(575)).setAttribute("width","25" );
      ((Element)v.get(575)).setAttribute("height","8" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));
      /* Termina nodo:575   */
      /* Termina nodo:574   */

      /* Empieza nodo:576 / Elemento padre: 510   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(576)).setAttribute("width","100%" );
      ((Element)v.get(510)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(577)).setAttribute("src","b.gif" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */
      /* Termina nodo:576   */
      /* Termina nodo:510   */
      /* Termina nodo:509   */
      /* Termina nodo:508   */
      /* Termina nodo:505   */

      /* Empieza nodo:578 / Elemento padre: 57   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(578)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(57)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(579)).setAttribute("align","center" );
      ((Element)v.get(579)).setAttribute("width","8" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(580)).setAttribute("src","b.gif" );
      ((Element)v.get(580)).setAttribute("width","12" );
      ((Element)v.get(580)).setAttribute("height","8" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));
      /* Termina nodo:580   */
      /* Termina nodo:579   */

      /* Empieza nodo:581 / Elemento padre: 578   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(578)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(582)).setAttribute("src","b.gif" );
      ((Element)v.get(582)).setAttribute("width","8" );
      ((Element)v.get(582)).setAttribute("height","8" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */
      /* Termina nodo:581   */

      /* Empieza nodo:583 / Elemento padre: 578   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(583)).setAttribute("align","center" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(583)).setAttribute("width","8" );
      ((Element)v.get(578)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(584)).setAttribute("src","b.gif" );
      ((Element)v.get(584)).setAttribute("width","12" );
      ((Element)v.get(584)).setAttribute("height","8" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */
      /* Termina nodo:583   */
      /* Termina nodo:578   */

      /* Empieza nodo:585 / Elemento padre: 57   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(585)).setAttribute("nombre","formTr8" );
      ((Element)v.get(57)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(586)).setAttribute("align","center" );
      ((Element)v.get(586)).setAttribute("width","8" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(587)).setAttribute("src","b.gif" );
      ((Element)v.get(587)).setAttribute("width","8" );
      ((Element)v.get(587)).setAttribute("height","12" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */
      /* Termina nodo:586   */

      /* Empieza nodo:588 / Elemento padre: 585   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(588)).setAttribute("width","100%" );
      ((Element)v.get(585)).appendChild((Element)v.get(588));

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
      ((Element)v.get(590)).setAttribute("align","left" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(591)).setAttribute("nombre","valUrlTdId" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(592)).setAttribute("width","100%" );
      ((Element)v.get(592)).setAttribute("border","0" );
      ((Element)v.get(592)).setAttribute("cellspacing","0" );
      ((Element)v.get(592)).setAttribute("cellpadding","0" );
      ((Element)v.get(592)).setAttribute("align","left" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(592)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(594)).setAttribute("valign","top" );
      ((Element)v.get(594)).setAttribute("height","13" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(595)).setAttribute("nombre","lblValUrl" );
      ((Element)v.get(595)).setAttribute("alto","13" );
      ((Element)v.get(595)).setAttribute("filas","1" );
      ((Element)v.get(595)).setAttribute("id","datosTitle" );
      ((Element)v.get(595)).setAttribute("cod","SegPaisView.valUrl.label" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));
      /* Termina nodo:595   */
      /* Termina nodo:594   */
      /* Termina nodo:593   */

      /* Empieza nodo:596 / Elemento padre: 592   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(596)).setAttribute("nombre","valUrlWidgetTrId" );
      ((Element)v.get(592)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(597)).setAttribute("align","left" );
      ((Element)v.get(597)).setAttribute("nowrap","true" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(598)).setAttribute("nombre","valUrl" );
      ((Element)v.get(598)).setAttribute("valor","" );
      ((Element)v.get(598)).setAttribute("rows","3" );
      ((Element)v.get(598)).setAttribute("cols","40" );
      ((Element)v.get(598)).setAttribute("validacion","" );
      ((Element)v.get(598)).setAttribute("disabled","" );
      ((Element)v.get(598)).setAttribute("req","N" );
      ((Element)v.get(598)).setAttribute("id","datosCampos" );
      ((Element)v.get(598)).setAttribute("onblur","" );
      ((Element)v.get(598)).setAttribute("onfocus","" );
      ((Element)v.get(598)).setAttribute("onchange","" );
      ((Element)v.get(598)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',32, true)" );
      ((Element)v.get(598)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',32, false)" );
      ((Element)v.get(597)).appendChild((Element)v.get(598));
      /* Termina nodo:598   */
      /* Termina nodo:597   */
      /* Termina nodo:596   */
      /* Termina nodo:592   */
      /* Termina nodo:591   */

      /* Empieza nodo:599 / Elemento padre: 590   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(599)).setAttribute("nombre","valUrlGapTdId" );
      ((Element)v.get(599)).setAttribute("nowrap","true" );
      ((Element)v.get(599)).setAttribute("class","datosCampos" );
      ((Element)v.get(590)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(600)).setAttribute("src","b.gif" );
      ((Element)v.get(600)).setAttribute("width","25" );
      ((Element)v.get(600)).setAttribute("height","8" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));
      /* Termina nodo:600   */
      /* Termina nodo:599   */

      /* Empieza nodo:601 / Elemento padre: 590   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(601)).setAttribute("width","100%" );
      ((Element)v.get(590)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
   }

   private void getXML2880(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(602)).setAttribute("src","b.gif" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));
      /* Termina nodo:602   */
      /* Termina nodo:601   */
      /* Termina nodo:590   */
      /* Termina nodo:589   */
      /* Termina nodo:588   */

      /* Empieza nodo:603 / Elemento padre: 585   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(603)).setAttribute("width","100%" );
      ((Element)v.get(585)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */
      /* Termina nodo:585   */

      /* Empieza nodo:604 / Elemento padre: 57   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(604)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(57)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(605)).setAttribute("align","center" );
      ((Element)v.get(605)).setAttribute("width","8" );
      ((Element)v.get(604)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(606)).setAttribute("src","b.gif" );
      ((Element)v.get(606)).setAttribute("width","8" );
      ((Element)v.get(606)).setAttribute("height","8" );
      ((Element)v.get(605)).appendChild((Element)v.get(606));
      /* Termina nodo:606   */
      /* Termina nodo:605   */

      /* Empieza nodo:607 / Elemento padre: 604   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(604)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(608)).setAttribute("src","b.gif" );
      ((Element)v.get(608)).setAttribute("width","8" );
      ((Element)v.get(608)).setAttribute("height","8" );
      ((Element)v.get(607)).appendChild((Element)v.get(608));
      /* Termina nodo:608   */
      /* Termina nodo:607   */

      /* Empieza nodo:609 / Elemento padre: 604   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(609)).setAttribute("align","center" );
      ((Element)v.get(609)).setAttribute("width","8" );
      ((Element)v.get(604)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(610)).setAttribute("src","b.gif" );
      ((Element)v.get(610)).setAttribute("width","8" );
      ((Element)v.get(610)).setAttribute("height","8" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));
      /* Termina nodo:610   */
      /* Termina nodo:609   */
      /* Termina nodo:604   */
      /* Termina nodo:57   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:611 / Elemento padre: 50   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(611)).setAttribute("align","center" );
      ((Element)v.get(611)).setAttribute("width","12" );
      ((Element)v.get(50)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(612)).setAttribute("src","b.gif" );
      ((Element)v.get(612)).setAttribute("width","12" );
      ((Element)v.get(612)).setAttribute("height","12" );
      ((Element)v.get(611)).appendChild((Element)v.get(612));
      /* Termina nodo:612   */
      /* Termina nodo:611   */
      /* Termina nodo:50   */

      /* Empieza nodo:613 / Elemento padre: 42   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(613)).setAttribute("nombre","segPaisViewTrButtons" );
      ((Element)v.get(42)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(614)).setAttribute("align","center" );
      ((Element)v.get(614)).setAttribute("width","12" );
      ((Element)v.get(613)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(615)).setAttribute("src","b.gif" );
      ((Element)v.get(615)).setAttribute("width","12" );
      ((Element)v.get(615)).setAttribute("height","12" );
      ((Element)v.get(614)).appendChild((Element)v.get(615));
      /* Termina nodo:615   */
      /* Termina nodo:614   */

      /* Empieza nodo:616 / Elemento padre: 613   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(613)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(616)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(618)).setAttribute("width","100%" );
      ((Element)v.get(618)).setAttribute("border","0" );
      ((Element)v.get(618)).setAttribute("align","center" );
      ((Element)v.get(618)).setAttribute("cellspacing","0" );
      ((Element)v.get(618)).setAttribute("cellpadding","0" );
      ((Element)v.get(617)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(618)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(620)).setAttribute("class","tablaTitle" );
      ((Element)v.get(620)).setAttribute("nombre","segPaisViewTdQueryButton" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(621)).setAttribute("nombre","segPaisViewQueryButton" );
      ((Element)v.get(621)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(621)).setAttribute("estado","false" );
      ((Element)v.get(621)).setAttribute("accion","segPaisViewFirstPage();" );
      ((Element)v.get(621)).setAttribute("tipo","html" );
      ((Element)v.get(621)).setAttribute("ID","botonContenido" );
      ((Element)v.get(620)).appendChild((Element)v.get(621));
      /* Termina nodo:621   */
      /* Termina nodo:620   */

      /* Empieza nodo:622 / Elemento padre: 619   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(622)).setAttribute("class","tablaTitle" );
      ((Element)v.get(622)).setAttribute("nombre","segPaisViewTdLovNullSelectionButton" );
      ((Element)v.get(622)).setAttribute("align","left" );
      ((Element)v.get(622)).setAttribute("width","100%" );
      ((Element)v.get(619)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(623)).setAttribute("src","b.gif" );
      ((Element)v.get(623)).setAttribute("height","8" );
      ((Element)v.get(623)).setAttribute("width","8" );
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(622)).appendChild((Element)v.get(623));
      /* Termina nodo:623   */

      /* Empieza nodo:624 / Elemento padre: 622   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(624)).setAttribute("nombre","segPaisViewLovNullButton" );
      ((Element)v.get(624)).setAttribute("ID","botonContenido" );
      ((Element)v.get(624)).setAttribute("tipo","html" );
      ((Element)v.get(624)).setAttribute("accion","segPaisViewLovNullSelectionAction();" );
      ((Element)v.get(624)).setAttribute("estado","true" );
      ((Element)v.get(624)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(622)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */
      /* Termina nodo:622   */
      /* Termina nodo:619   */
      /* Termina nodo:618   */
      /* Termina nodo:617   */
      /* Termina nodo:616   */

      /* Empieza nodo:625 / Elemento padre: 613   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(625)).setAttribute("align","center" );
      ((Element)v.get(625)).setAttribute("width","12" );
      ((Element)v.get(613)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(626)).setAttribute("src","b.gif" );
      ((Element)v.get(626)).setAttribute("width","12" );
      ((Element)v.get(626)).setAttribute("height","12" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));
      /* Termina nodo:626   */
      /* Termina nodo:625   */
      /* Termina nodo:613   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:627 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(627)).setAttribute("nombre","segPaisViewListLayer" );
      ((Element)v.get(627)).setAttribute("alto","310" );
      ((Element)v.get(627)).setAttribute("ancho","99%" );
      ((Element)v.get(627)).setAttribute("colorf","" );
      ((Element)v.get(627)).setAttribute("borde","0" );
      ((Element)v.get(627)).setAttribute("imagenf","" );
      ((Element)v.get(627)).setAttribute("repeat","" );
      ((Element)v.get(627)).setAttribute("padding","" );
      ((Element)v.get(627)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(627)).setAttribute("contravsb","" );
      ((Element)v.get(627)).setAttribute("x","3" );
      ((Element)v.get(627)).setAttribute("y","" );
      ((Element)v.get(627)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(628)).setAttribute("nombre","segPaisViewList" );
      ((Element)v.get(628)).setAttribute("ancho","680" );
      ((Element)v.get(628)).setAttribute("alto","275" );
      ((Element)v.get(628)).setAttribute("x","12" );
      ((Element)v.get(628)).setAttribute("y","0" );
      ((Element)v.get(628)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(628)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(627)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(629)).setAttribute("precarga","S" );
      ((Element)v.get(629)).setAttribute("conROver","S" );
      ((Element)v.get(628)).appendChild((Element)v.get(629));

      /* Empieza nodo:630 / Elemento padre: 629   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(630)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(630)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(630)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(630)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(629)).appendChild((Element)v.get(630));
      /* Termina nodo:630   */

      /* Empieza nodo:631 / Elemento padre: 629   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(631)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(631)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(631)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(631)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(629)).appendChild((Element)v.get(631));
      /* Termina nodo:631   */
      /* Termina nodo:629   */

      /* Empieza nodo:632 / Elemento padre: 628   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(628)).appendChild((Element)v.get(632));

      /* Empieza nodo:633 / Elemento padre: 632   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(633)).setAttribute("borde","1" );
      ((Element)v.get(633)).setAttribute("horizDatos","1" );
      ((Element)v.get(633)).setAttribute("horizCabecera","1" );
      ((Element)v.get(633)).setAttribute("vertical","1" );
      ((Element)v.get(633)).setAttribute("horizTitulo","1" );
      ((Element)v.get(633)).setAttribute("horizBase","1" );
      ((Element)v.get(632)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */

      /* Empieza nodo:634 / Elemento padre: 632   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(634)).setAttribute("borde","#999999" );
      ((Element)v.get(634)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(634)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(634)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(634)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(634)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(634)).setAttribute("horizBase","#999999" );
      ((Element)v.get(632)).appendChild((Element)v.get(634));
      /* Termina nodo:634   */
      /* Termina nodo:632   */

      /* Empieza nodo:635 / Elemento padre: 628   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(635)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(635)).setAttribute("alto","22" );
      ((Element)v.get(635)).setAttribute("imgFondo","" );
      ((Element)v.get(635)).setAttribute("cod","00135" );
      ((Element)v.get(635)).setAttribute("ID","datosTitle" );
      ((Element)v.get(628)).appendChild((Element)v.get(635));
      /* Termina nodo:635   */

      /* Empieza nodo:636 / Elemento padre: 628   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(636)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(636)).setAttribute("alto","22" );
      ((Element)v.get(636)).setAttribute("imgFondo","" );
      ((Element)v.get(628)).appendChild((Element)v.get(636));
      /* Termina nodo:636   */

      /* Empieza nodo:637 / Elemento padre: 628   */
      v.add(doc.createElement("COLUMNAS"));
   }

   private void getXML3060(Document doc) {
      ((Element)v.get(637)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(637)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(637)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(637)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(637)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(628)).appendChild((Element)v.get(637));

      /* Empieza nodo:638 / Elemento padre: 637   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(638)).setAttribute("ancho","100" );
      ((Element)v.get(638)).setAttribute("minimizable","S" );
      ((Element)v.get(638)).setAttribute("minimizada","N" );
      ((Element)v.get(637)).appendChild((Element)v.get(638));
      /* Termina nodo:638   */

      /* Empieza nodo:639 / Elemento padre: 637   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(639)).setAttribute("ancho","100" );
      ((Element)v.get(639)).setAttribute("minimizable","S" );
      ((Element)v.get(639)).setAttribute("minimizada","N" );
      ((Element)v.get(637)).appendChild((Element)v.get(639));
      /* Termina nodo:639   */
      /* Termina nodo:637   */

      /* Empieza nodo:640 / Elemento padre: 628   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(640)).setAttribute("height","20" );
      ((Element)v.get(640)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(640)).setAttribute("imgFondo","" );
      ((Element)v.get(640)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(628)).appendChild((Element)v.get(640));

      /* Empieza nodo:641 / Elemento padre: 640   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(641)).setAttribute("colFondo","" );
      ((Element)v.get(641)).setAttribute("ID","EstCab" );
      ((Element)v.get(641)).setAttribute("cod","SegPaisView.codPais.label" );
      ((Element)v.get(640)).appendChild((Element)v.get(641));
      /* Termina nodo:641   */

      /* Empieza nodo:642 / Elemento padre: 640   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(642)).setAttribute("colFondo","" );
      ((Element)v.get(642)).setAttribute("ID","EstCab" );
      ((Element)v.get(642)).setAttribute("cod","SegPaisView.moneOidMone.label" );
      ((Element)v.get(640)).appendChild((Element)v.get(642));
      /* Termina nodo:642   */
      /* Termina nodo:640   */

      /* Empieza nodo:643 / Elemento padre: 628   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(643)).setAttribute("alto","22" );
      ((Element)v.get(643)).setAttribute("accion","" );
      ((Element)v.get(643)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(643)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(643)).setAttribute("maxSel","1" );
      ((Element)v.get(643)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(643)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(643)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(643)).setAttribute("onLoad","" );
      ((Element)v.get(643)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(628)).appendChild((Element)v.get(643));

      /* Empieza nodo:644 / Elemento padre: 643   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(644)).setAttribute("tipo","texto" );
      ((Element)v.get(644)).setAttribute("ID","EstDat" );
      ((Element)v.get(643)).appendChild((Element)v.get(644));
      /* Termina nodo:644   */

      /* Empieza nodo:645 / Elemento padre: 643   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(645)).setAttribute("tipo","texto" );
      ((Element)v.get(645)).setAttribute("ID","EstDat2" );
      ((Element)v.get(643)).appendChild((Element)v.get(645));
      /* Termina nodo:645   */
      /* Termina nodo:643   */

      /* Empieza nodo:646 / Elemento padre: 628   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(628)).appendChild((Element)v.get(646));
      /* Termina nodo:646   */
      /* Termina nodo:628   */
      /* Termina nodo:627   */

      /* Empieza nodo:647 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(647)).setAttribute("nombre","segPaisViewListButtonsLayer" );
      ((Element)v.get(647)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(647)).setAttribute("alto","30" );
      ((Element)v.get(647)).setAttribute("ancho","98%" );
      ((Element)v.get(647)).setAttribute("borde","n" );
      ((Element)v.get(647)).setAttribute("imagenf","" );
      ((Element)v.get(647)).setAttribute("repeat","" );
      ((Element)v.get(647)).setAttribute("padding","0" );
      ((Element)v.get(647)).setAttribute("contravsb","" );
      ((Element)v.get(647)).setAttribute("x","16" );
      ((Element)v.get(647)).setAttribute("y","" );
      ((Element)v.get(647)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(647));

      /* Empieza nodo:648 / Elemento padre: 647   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(648)).setAttribute("nombre","toolbarSeparatorLayer" );
      ((Element)v.get(648)).setAttribute("visibilidad","inherit" );
      ((Element)v.get(648)).setAttribute("alto","23" );
      ((Element)v.get(648)).setAttribute("ancho","1" );
      ((Element)v.get(648)).setAttribute("borde","1" );
      ((Element)v.get(648)).setAttribute("imagenf","" );
      ((Element)v.get(648)).setAttribute("repeat","" );
      ((Element)v.get(648)).setAttribute("padding","0" );
      ((Element)v.get(648)).setAttribute("contravsb","" );
      ((Element)v.get(648)).setAttribute("x","56" );
      ((Element)v.get(648)).setAttribute("y","0" );
      ((Element)v.get(648)).setAttribute("zindex","" );
      ((Element)v.get(648)).setAttribute("colborde","#999999" );
      ((Element)v.get(647)).appendChild((Element)v.get(648));
      /* Termina nodo:648   */

      /* Empieza nodo:649 / Elemento padre: 647   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(649)).setAttribute("width","100%" );
      ((Element)v.get(649)).setAttribute("border","0" );
      ((Element)v.get(649)).setAttribute("cellspacing","1" );
      ((Element)v.get(649)).setAttribute("cellpadding","0" );
      ((Element)v.get(647)).appendChild((Element)v.get(649));

      /* Empieza nodo:650 / Elemento padre: 649   */
      v.add(doc.createElement("TD"));
   }

   private void getXML3150(Document doc) {
      ((Element)v.get(649)).appendChild((Element)v.get(650));

      /* Empieza nodo:651 / Elemento padre: 650   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(651)).setAttribute("src","b.gif" );
      ((Element)v.get(651)).setAttribute("height","22" );
      ((Element)v.get(651)).setAttribute("width","5" );
      ((Element)v.get(650)).appendChild((Element)v.get(651));
      /* Termina nodo:651   */
      /* Termina nodo:650   */

      /* Empieza nodo:652 / Elemento padre: 649   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(649)).appendChild((Element)v.get(652));

      /* Empieza nodo:653 / Elemento padre: 652   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(653)).setAttribute("nombre","segPaisViewPaginationButtonBar" );
      ((Element)v.get(653)).setAttribute("tipo","H" );
      ((Element)v.get(653)).setAttribute("x","0" );
      ((Element)v.get(653)).setAttribute("y","0" );
      ((Element)v.get(652)).appendChild((Element)v.get(653));

      /* Empieza nodo:654 / Elemento padre: 653   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(654)).setAttribute("nombre","segPaisViewFirstPageButton" );
      ((Element)v.get(654)).setAttribute("funcion","segPaisViewFirstPage();" );
      ((Element)v.get(654)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(654)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(654)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(654)).setAttribute("estado","inactivo" );
      ((Element)v.get(653)).appendChild((Element)v.get(654));
      /* Termina nodo:654   */

      /* Empieza nodo:655 / Elemento padre: 653   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(655)).setAttribute("nombre","segPaisViewFirstPageButtonGapTd" );
      ((Element)v.get(653)).appendChild((Element)v.get(655));

      /* Empieza nodo:656 / Elemento padre: 655   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(656)).setAttribute("src","b.gif" );
      ((Element)v.get(656)).setAttribute("height","8" );
      ((Element)v.get(656)).setAttribute("width","5" );
      ((Element)v.get(655)).appendChild((Element)v.get(656));
      /* Termina nodo:656   */
      /* Termina nodo:655   */

      /* Empieza nodo:657 / Elemento padre: 653   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(657)).setAttribute("nombre","segPaisViewPreviousPageButton" );
      ((Element)v.get(657)).setAttribute("funcion","segPaisViewPreviousPage();" );
      ((Element)v.get(657)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(657)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(657)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(657)).setAttribute("estado","inactivo" );
      ((Element)v.get(653)).appendChild((Element)v.get(657));
      /* Termina nodo:657   */

      /* Empieza nodo:658 / Elemento padre: 653   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(658)).setAttribute("nombre","segPaisViewPreviousPageButtonGapTd" );
      ((Element)v.get(653)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(659)).setAttribute("src","b.gif" );
      ((Element)v.get(659)).setAttribute("height","8" );
      ((Element)v.get(659)).setAttribute("width","8" );
      ((Element)v.get(658)).appendChild((Element)v.get(659));
      /* Termina nodo:659   */
      /* Termina nodo:658   */

      /* Empieza nodo:660 / Elemento padre: 653   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(660)).setAttribute("nombre","segPaisViewNextPageButton" );
      ((Element)v.get(660)).setAttribute("funcion","segPaisViewNextPage();" );
      ((Element)v.get(660)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(660)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(660)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(660)).setAttribute("estado","inactivo" );
      ((Element)v.get(653)).appendChild((Element)v.get(660));
      /* Termina nodo:660   */
      /* Termina nodo:653   */
      /* Termina nodo:652   */

      /* Empieza nodo:661 / Elemento padre: 649   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(649)).appendChild((Element)v.get(661));

      /* Empieza nodo:662 / Elemento padre: 661   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(662)).setAttribute("src","b.gif" );
      ((Element)v.get(662)).setAttribute("height","22" );
      ((Element)v.get(662)).setAttribute("width","19" );
      ((Element)v.get(661)).appendChild((Element)v.get(662));
      /* Termina nodo:662   */
      /* Termina nodo:661   */

      /* Empieza nodo:663 / Elemento padre: 649   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(663)).setAttribute("class","tablaTitle" );
      ((Element)v.get(663)).setAttribute("nombre","segPaisViewUpdateButtonTd" );
      ((Element)v.get(649)).appendChild((Element)v.get(663));

      /* Empieza nodo:664 / Elemento padre: 663   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(664)).setAttribute("nombre","segPaisViewUpdateButton" );
      ((Element)v.get(664)).setAttribute("ID","botonContenido" );
      ((Element)v.get(664)).setAttribute("tipo","html" );
      ((Element)v.get(664)).setAttribute("accion","segPaisViewUpdateSelection();" );
      ((Element)v.get(664)).setAttribute("estado","false" );
      ((Element)v.get(664)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(663)).appendChild((Element)v.get(664));
      /* Termina nodo:664   */
      /* Termina nodo:663   */

      /* Empieza nodo:665 / Elemento padre: 649   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(665)).setAttribute("nombre","segPaisViewUpdateButtonGapTd" );
      ((Element)v.get(649)).appendChild((Element)v.get(665));

      /* Empieza nodo:666 / Elemento padre: 665   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(666)).setAttribute("src","b.gif" );
      ((Element)v.get(666)).setAttribute("height","8" );
      ((Element)v.get(666)).setAttribute("width","10" );
      ((Element)v.get(665)).appendChild((Element)v.get(666));
      /* Termina nodo:666   */
      /* Termina nodo:665   */

      /* Empieza nodo:667 / Elemento padre: 649   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(667)).setAttribute("class","tablaTitle" );
      ((Element)v.get(667)).setAttribute("nombre","segPaisViewViewForRemoveButtonTd" );
      ((Element)v.get(649)).appendChild((Element)v.get(667));

      /* Empieza nodo:668 / Elemento padre: 667   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(668)).setAttribute("nombre","segPaisViewViewForRemoveButton" );
      ((Element)v.get(668)).setAttribute("ID","botonContenido" );
      ((Element)v.get(668)).setAttribute("tipo","html" );
      ((Element)v.get(668)).setAttribute("accion","segPaisViewViewSelection();" );
   }

   private void getXML3240(Document doc) {
      ((Element)v.get(668)).setAttribute("estado","false" );
      ((Element)v.get(668)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(667)).appendChild((Element)v.get(668));
      /* Termina nodo:668   */
      /* Termina nodo:667   */

      /* Empieza nodo:669 / Elemento padre: 649   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(669)).setAttribute("nombre","segPaisViewViewForRemoveButtonGapTd" );
      ((Element)v.get(649)).appendChild((Element)v.get(669));

      /* Empieza nodo:670 / Elemento padre: 669   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(670)).setAttribute("src","b.gif" );
      ((Element)v.get(670)).setAttribute("height","8" );
      ((Element)v.get(670)).setAttribute("width","10" );
      ((Element)v.get(669)).appendChild((Element)v.get(670));
      /* Termina nodo:670   */
      /* Termina nodo:669   */

      /* Empieza nodo:671 / Elemento padre: 649   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(671)).setAttribute("class","tablaTitle" );
      ((Element)v.get(671)).setAttribute("nombre","segPaisViewLovSelectButtonTd" );
      ((Element)v.get(649)).appendChild((Element)v.get(671));

      /* Empieza nodo:672 / Elemento padre: 671   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(672)).setAttribute("nombre","segPaisViewLovSelectButton" );
      ((Element)v.get(672)).setAttribute("ID","botonContenido" );
      ((Element)v.get(672)).setAttribute("tipo","html" );
      ((Element)v.get(672)).setAttribute("accion","segPaisViewLovSelectionAction();" );
      ((Element)v.get(672)).setAttribute("estado","true" );
      ((Element)v.get(672)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(671)).appendChild((Element)v.get(672));
      /* Termina nodo:672   */
      /* Termina nodo:671   */

      /* Empieza nodo:673 / Elemento padre: 649   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(673)).setAttribute("nombre","segPaisViewLovSelectButtonGapTd" );
      ((Element)v.get(649)).appendChild((Element)v.get(673));

      /* Empieza nodo:674 / Elemento padre: 673   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(674)).setAttribute("src","b.gif" );
      ((Element)v.get(674)).setAttribute("height","8" );
      ((Element)v.get(674)).setAttribute("width","10" );
      ((Element)v.get(673)).appendChild((Element)v.get(674));
      /* Termina nodo:674   */
      /* Termina nodo:673   */

      /* Empieza nodo:675 / Elemento padre: 649   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(675)).setAttribute("class","tablaTitle" );
      ((Element)v.get(675)).setAttribute("nombre","segPaisViewViewButtonTd" );
      ((Element)v.get(649)).appendChild((Element)v.get(675));

      /* Empieza nodo:676 / Elemento padre: 675   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(676)).setAttribute("nombre","segPaisViewViewButton" );
      ((Element)v.get(676)).setAttribute("ID","botonContenido" );
      ((Element)v.get(676)).setAttribute("tipo","html" );
      ((Element)v.get(676)).setAttribute("accion","segPaisViewViewSelection();" );
      ((Element)v.get(676)).setAttribute("estado","false" );
      ((Element)v.get(676)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(675)).appendChild((Element)v.get(676));
      /* Termina nodo:676   */
      /* Termina nodo:675   */

      /* Empieza nodo:677 / Elemento padre: 649   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(677)).setAttribute("nombre","segPaisViewViewButtonGapTd" );
      ((Element)v.get(649)).appendChild((Element)v.get(677));

      /* Empieza nodo:678 / Elemento padre: 677   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(678)).setAttribute("src","b.gif" );
      ((Element)v.get(678)).setAttribute("height","8" );
      ((Element)v.get(678)).setAttribute("width","10" );
      ((Element)v.get(677)).appendChild((Element)v.get(678));
      /* Termina nodo:678   */
      /* Termina nodo:677   */

      /* Empieza nodo:679 / Elemento padre: 649   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(679)).setAttribute("width","100%" );
      ((Element)v.get(649)).appendChild((Element)v.get(679));
      /* Termina nodo:679   */
      /* Termina nodo:649   */
      /* Termina nodo:647   */
      /* Termina nodo:5   */


   }

}

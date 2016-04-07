
import org.w3c.dom.*;
import java.util.ArrayList;

public class SegPaisPage  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","SegPaisPage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","segPaisInitComponents()" );
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
      ((Element)v.get(4)).setAttribute("src","segpais.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","segPaisFrm" );
      ((Element)v.get(5)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(6)).setAttribute("valor","SegPaisLPExecution" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","ON" );
      ((Element)v.get(7)).setAttribute("valor","SegPaisLPExecution" );
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
      ((Element)v.get(38)).setAttribute("nombre","indCompAutoCheckValue" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","indTratAcumDescCheckValue" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","indEmisVencCheckValue" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","valIndiSecuMoniCheckValue" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","indImpuInclCheckValue" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(43)).setAttribute("nombre","segPaisFormLayer" );
      ((Element)v.get(43)).setAttribute("alto","" );
      ((Element)v.get(43)).setAttribute("ancho","100%" );
      ((Element)v.get(43)).setAttribute("colorf","" );
      ((Element)v.get(43)).setAttribute("borde","0" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(43)).setAttribute("imagenf","" );
      ((Element)v.get(43)).setAttribute("repeat","" );
      ((Element)v.get(43)).setAttribute("padding","" );
      ((Element)v.get(43)).setAttribute("visibilidad","visible" );
      ((Element)v.get(43)).setAttribute("contravsb","" );
      ((Element)v.get(43)).setAttribute("x","0" );
      ((Element)v.get(43)).setAttribute("y","0" );
      ((Element)v.get(43)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(44)).setAttribute("width","100%" );
      ((Element)v.get(44)).setAttribute("border","0" );
      ((Element)v.get(44)).setAttribute("cellspacing","0" );
      ((Element)v.get(44)).setAttribute("cellpadding","0" );
      ((Element)v.get(44)).setAttribute("align","left" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(46)).setAttribute("align","center" );
      ((Element)v.get(46)).setAttribute("width","12" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","12" );
      ((Element)v.get(47)).setAttribute("height","12" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 45   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(48)).setAttribute("align","center" );
      ((Element)v.get(48)).setAttribute("width","750" );
      ((Element)v.get(45)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","12" );
      ((Element)v.get(49)).setAttribute("height","12" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 45   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(50)).setAttribute("align","center" );
      ((Element)v.get(50)).setAttribute("width","12" );
      ((Element)v.get(45)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","12" );
      ((Element)v.get(51)).setAttribute("height","12" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:45   */

      /* Empieza nodo:52 / Elemento padre: 44   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(44)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(53)).setAttribute("align","center" );
      ((Element)v.get(53)).setAttribute("width","12" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","12" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 52   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(52)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(57)).setAttribute("class","legend" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(58)).setAttribute("nombre","legendLbl" );
      ((Element)v.get(58)).setAttribute("alto","13" );
      ((Element)v.get(58)).setAttribute("filas","1" );
      ((Element)v.get(58)).setAttribute("id","legend" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(58)).setAttribute("cod","SegPais.legend.label" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 56   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(59)).setAttribute("width","100%" );
      ((Element)v.get(59)).setAttribute("border","0" );
      ((Element)v.get(59)).setAttribute("align","center" );
      ((Element)v.get(59)).setAttribute("cellspacing","0" );
      ((Element)v.get(59)).setAttribute("cellpadding","0" );
      ((Element)v.get(56)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(61)).setAttribute("width","100%" );
      ((Element)v.get(61)).setAttribute("nowrap","true" );
      ((Element)v.get(61)).setAttribute("class","datosCampos" );
      ((Element)v.get(61)).setAttribute("colspan","3" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","8" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:63 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(63)).setAttribute("nombre","formTr0" );
      ((Element)v.get(59)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(64)).setAttribute("align","center" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","8" );
      ((Element)v.get(65)).setAttribute("height","12" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 63   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(66)).setAttribute("width","100%" );
      ((Element)v.get(63)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(67)).setAttribute("width","100%" );
      ((Element)v.get(67)).setAttribute("border","0" );
      ((Element)v.get(67)).setAttribute("cellspacing","0" );
      ((Element)v.get(67)).setAttribute("cellpadding","0" );
      ((Element)v.get(67)).setAttribute("align","left" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(68)).setAttribute("align","left" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(69)).setAttribute("nombre","idTdId" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(70)).setAttribute("width","100%" );
      ((Element)v.get(70)).setAttribute("border","0" );
      ((Element)v.get(70)).setAttribute("cellspacing","0" );
      ((Element)v.get(70)).setAttribute("cellpadding","0" );
      ((Element)v.get(70)).setAttribute("align","left" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(72)).setAttribute("valign","top" );
      ((Element)v.get(72)).setAttribute("height","13" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(73)).setAttribute("nombre","lblId" );
      ((Element)v.get(73)).setAttribute("alto","13" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("id","datosTitle" );
      ((Element)v.get(73)).setAttribute("cod","SegPais.id.label" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:74 / Elemento padre: 70   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(74)).setAttribute("nombre","idWidgetTrId" );
      ((Element)v.get(70)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(75)).setAttribute("align","left" );
      ((Element)v.get(75)).setAttribute("nowrap","true" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(76)).setAttribute("nombre","id" );
      ((Element)v.get(76)).setAttribute("id","datosCampos" );
      ((Element)v.get(76)).setAttribute("trim","S" );
      ((Element)v.get(76)).setAttribute("max","12" );
      ((Element)v.get(76)).setAttribute("onchange","" );
      ((Element)v.get(76)).setAttribute("req","N" );
      ((Element)v.get(76)).setAttribute("size","12" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(76)).setAttribute("validacion","" );
      ((Element)v.get(76)).setAttribute("disabled","" );
      ((Element)v.get(76)).setAttribute("onblur","" );
      ((Element)v.get(76)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',1, true)" );
      ((Element)v.get(76)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 1, false)" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:77 / Elemento padre: 68   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(77)).setAttribute("nombre","idGapTdId" );
      ((Element)v.get(77)).setAttribute("nowrap","true" );
      ((Element)v.get(77)).setAttribute("class","datosCampos" );
      ((Element)v.get(68)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","25" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 68   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(79)).setAttribute("width","100%" );
      ((Element)v.get(68)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:63   */

      /* Empieza nodo:81 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(81)).setAttribute("nombre","formGapTr0" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(59)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(82)).setAttribute("align","center" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","12" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 81   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(81)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 81   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(86)).setAttribute("align","center" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","12" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:81   */

      /* Empieza nodo:88 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(88)).setAttribute("nombre","formTr1" );
      ((Element)v.get(59)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(89)).setAttribute("align","center" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(90)).setAttribute("height","12" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(91)).setAttribute("width","100%" );
      ((Element)v.get(88)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(92)).setAttribute("width","100%" );
      ((Element)v.get(92)).setAttribute("border","0" );
      ((Element)v.get(92)).setAttribute("cellspacing","0" );
      ((Element)v.get(92)).setAttribute("cellpadding","0" );
      ((Element)v.get(92)).setAttribute("align","left" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(93)).setAttribute("align","left" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(94)).setAttribute("nombre","codPaisTdId" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(95)).setAttribute("width","100%" );
      ((Element)v.get(95)).setAttribute("border","0" );
      ((Element)v.get(95)).setAttribute("cellspacing","0" );
      ((Element)v.get(95)).setAttribute("cellpadding","0" );
      ((Element)v.get(95)).setAttribute("align","left" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(97)).setAttribute("valign","top" );
      ((Element)v.get(97)).setAttribute("height","13" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(98)).setAttribute("nombre","lblCodPais" );
      ((Element)v.get(98)).setAttribute("alto","13" );
      ((Element)v.get(98)).setAttribute("filas","1" );
      ((Element)v.get(98)).setAttribute("id","datosTitle" );
      ((Element)v.get(98)).setAttribute("cod","SegPais.codPais.label" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:99 / Elemento padre: 95   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(99)).setAttribute("nombre","codPaisWidgetTrId" );
      ((Element)v.get(95)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(100)).setAttribute("align","left" );
      ((Element)v.get(100)).setAttribute("nowrap","true" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(101)).setAttribute("nombre","codPais" );
      ((Element)v.get(101)).setAttribute("id","datosCampos" );
      ((Element)v.get(101)).setAttribute("trim","S" );
      ((Element)v.get(101)).setAttribute("max","3" );
      ((Element)v.get(101)).setAttribute("onchange","" );
      ((Element)v.get(101)).setAttribute("req","N" );
      ((Element)v.get(101)).setAttribute("size","3" );
      ((Element)v.get(101)).setAttribute("valor","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(101)).setAttribute("validacion","" );
      ((Element)v.get(101)).setAttribute("disabled","" );
      ((Element)v.get(101)).setAttribute("onblur","" );
      ((Element)v.get(101)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',2, true)" );
      ((Element)v.get(101)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 2, false)" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:102 / Elemento padre: 93   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(102)).setAttribute("nombre","codPaisGapTdId" );
      ((Element)v.get(102)).setAttribute("nowrap","true" );
      ((Element)v.get(102)).setAttribute("class","datosCampos" );
      ((Element)v.get(93)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","25" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 93   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(104)).setAttribute("nombre","moneOidMoneTdId" );
      ((Element)v.get(93)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(105)).setAttribute("border","0" );
      ((Element)v.get(105)).setAttribute("cellspacing","0" );
      ((Element)v.get(105)).setAttribute("cellpadding","0" );
      ((Element)v.get(105)).setAttribute("align","left" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(107)).setAttribute("valign","top" );
      ((Element)v.get(107)).setAttribute("height","13" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(108)).setAttribute("nombre","lblmoneOidMone" );
      ((Element)v.get(108)).setAttribute("id","datosTitle" );
      ((Element)v.get(108)).setAttribute("ancho","150" );
      ((Element)v.get(108)).setAttribute("alto","13" );
      ((Element)v.get(108)).setAttribute("cod","SegPais.moneOidMone.label" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:109 / Elemento padre: 105   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(109)).setAttribute("nombre","moneOidMoneWidgetTrId" );
      ((Element)v.get(105)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(110)).setAttribute("align","left" );
      ((Element)v.get(110)).setAttribute("nowrap","true" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(111)).setAttribute("nombre","moneOidMone" );
      ((Element)v.get(111)).setAttribute("id","datosCampos" );
      ((Element)v.get(111)).setAttribute("multiple","N" );
      ((Element)v.get(111)).setAttribute("req","N" );
      ((Element)v.get(111)).setAttribute("size","1" );
      ((Element)v.get(111)).setAttribute("disabled","" );
      ((Element)v.get(111)).setAttribute("validacion","" );
      ((Element)v.get(111)).setAttribute("onchange","" );
      ((Element)v.get(111)).setAttribute("onfocus","" );
      ((Element)v.get(111)).setAttribute("valorinicial","" );
      ((Element)v.get(111)).setAttribute("textoinicial","" );
      ((Element)v.get(111)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',3, true);" );
      ((Element)v.get(111)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',3, false);" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:113 / Elemento padre: 93   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(113)).setAttribute("nombre","moneOidMoneGapTdId" );
      ((Element)v.get(113)).setAttribute("nowrap","true" );
      ((Element)v.get(113)).setAttribute("class","datosCampos" );
      ((Element)v.get(93)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","25" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 93   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(115)).setAttribute("nombre","moneOidMoneAltTdId" );
      ((Element)v.get(93)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(116)).setAttribute("border","0" );
      ((Element)v.get(116)).setAttribute("cellspacing","0" );
      ((Element)v.get(116)).setAttribute("cellpadding","0" );
      ((Element)v.get(116)).setAttribute("align","left" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(118)).setAttribute("valign","top" );
      ((Element)v.get(118)).setAttribute("height","13" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(119)).setAttribute("nombre","lblmoneOidMoneAlt" );
      ((Element)v.get(119)).setAttribute("id","datosTitle" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(119)).setAttribute("ancho","150" );
      ((Element)v.get(119)).setAttribute("alto","13" );
      ((Element)v.get(119)).setAttribute("cod","SegPais.moneOidMoneAlt.label" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:120 / Elemento padre: 116   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(120)).setAttribute("nombre","moneOidMoneAltWidgetTrId" );
      ((Element)v.get(116)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(121)).setAttribute("align","left" );
      ((Element)v.get(121)).setAttribute("nowrap","true" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(122)).setAttribute("nombre","moneOidMoneAlt" );
      ((Element)v.get(122)).setAttribute("id","datosCampos" );
      ((Element)v.get(122)).setAttribute("multiple","N" );
      ((Element)v.get(122)).setAttribute("req","N" );
      ((Element)v.get(122)).setAttribute("size","1" );
      ((Element)v.get(122)).setAttribute("disabled","" );
      ((Element)v.get(122)).setAttribute("validacion","" );
      ((Element)v.get(122)).setAttribute("onchange","" );
      ((Element)v.get(122)).setAttribute("onfocus","" );
      ((Element)v.get(122)).setAttribute("valorinicial","" );
      ((Element)v.get(122)).setAttribute("textoinicial","" );
      ((Element)v.get(122)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',4, true);" );
      ((Element)v.get(122)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',4, false);" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:124 / Elemento padre: 93   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(124)).setAttribute("nombre","moneOidMoneAltGapTdId" );
      ((Element)v.get(124)).setAttribute("nowrap","true" );
      ((Element)v.get(124)).setAttribute("class","datosCampos" );
      ((Element)v.get(93)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","25" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 93   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(126)).setAttribute("nombre","DescripcionTdId" );
      ((Element)v.get(93)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(127)).setAttribute("width","100%" );
      ((Element)v.get(127)).setAttribute("border","0" );
      ((Element)v.get(127)).setAttribute("cellspacing","0" );
      ((Element)v.get(127)).setAttribute("cellpadding","0" );
      ((Element)v.get(127)).setAttribute("align","left" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(129)).setAttribute("valign","top" );
      ((Element)v.get(129)).setAttribute("height","13" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(130)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(130)).setAttribute("alto","13" );
      ((Element)v.get(130)).setAttribute("filas","1" );
      ((Element)v.get(130)).setAttribute("id","datosTitle" );
      ((Element)v.get(130)).setAttribute("cod","SegPais.Descripcion.label" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(131)).setAttribute("nombre","DescripcionTdLocalizationButtonGapHeader" );
      ((Element)v.get(131)).setAttribute("colspan","2" );
      ((Element)v.get(128)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:128   */

      /* Empieza nodo:132 / Elemento padre: 127   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(132)).setAttribute("nombre","DescripcionWidgetTrId" );
      ((Element)v.get(127)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(133)).setAttribute("align","left" );
      ((Element)v.get(133)).setAttribute("nowrap","true" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(134)).setAttribute("nombre","Descripcion" );
      ((Element)v.get(134)).setAttribute("id","datosCampos" );
      ((Element)v.get(134)).setAttribute("trim","S" );
      ((Element)v.get(134)).setAttribute("max","30" );
      ((Element)v.get(134)).setAttribute("onchange","" );
      ((Element)v.get(134)).setAttribute("req","N" );
      ((Element)v.get(134)).setAttribute("size","30" );
      ((Element)v.get(134)).setAttribute("valor","" );
      ((Element)v.get(134)).setAttribute("validacion","" );
      ((Element)v.get(134)).setAttribute("disabled","" );
      ((Element)v.get(134)).setAttribute("onblur","" );
      ((Element)v.get(134)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',5, true)" );
      ((Element)v.get(134)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 5, false)" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 132   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(132)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","8" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 132   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(137)).setAttribute("nombre","DescripcionTdLocalizationButton" );
      ((Element)v.get(137)).setAttribute("align","left" );
      ((Element)v.get(137)).setAttribute("nowrap","true" );
      ((Element)v.get(137)).setAttribute("valign","bottom" );
      ((Element)v.get(132)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("A"));
      ((Element)v.get(138)).setAttribute("id","DescripcionLocalizationButton" );
      ((Element)v.get(138)).setAttribute("href","javascript:openLocalizationDialog('segPaisFrm', 'Descripcion', 1);" );
      ((Element)v.get(138)).setAttribute("onKeyDown","javascript:mmgImgEventDispatcherForFocus(event, 'ejecutarAccionFoco(\"segPaisFrm\",5, true)', 'ejecutarAccionFoco(\"segPaisFrm\",5, false)')" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("nombre","DescripcionLocalizationButton" );
      ((Element)v.get(139)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(139)).setAttribute("border","0" );
      ((Element)v.get(139)).setAttribute("width","21" );
      ((Element)v.get(139)).setAttribute("height","15" );
      ((Element)v.get(139)).setAttribute("class","main" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:132   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:140 / Elemento padre: 93   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(140)).setAttribute("nombre","DescripcionGapTdId" );
      ((Element)v.get(140)).setAttribute("nowrap","true" );
      ((Element)v.get(140)).setAttribute("class","datosCampos" );
      ((Element)v.get(93)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","25" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 93   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(142)).setAttribute("width","100%" );
      ((Element)v.get(93)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:88   */

      /* Empieza nodo:144 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(144)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(59)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(145)).setAttribute("align","center" );
      ((Element)v.get(145)).setAttribute("width","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","12" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 144   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(144)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","8" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 144   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(149)).setAttribute("align","center" );
      ((Element)v.get(149)).setAttribute("width","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","12" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:144   */

      /* Empieza nodo:151 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(151)).setAttribute("nombre","formTr2" );
      ((Element)v.get(59)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(152)).setAttribute("align","center" );
      ((Element)v.get(152)).setAttribute("width","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","8" );
      ((Element)v.get(153)).setAttribute("height","12" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 151   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(154)).setAttribute("width","100%" );
      ((Element)v.get(151)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(155)).setAttribute("width","100%" );
      ((Element)v.get(155)).setAttribute("border","0" );
      ((Element)v.get(155)).setAttribute("cellspacing","0" );
      ((Element)v.get(155)).setAttribute("cellpadding","0" );
      ((Element)v.get(155)).setAttribute("align","left" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("TR"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(156)).setAttribute("align","left" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(157)).setAttribute("nombre","indInteGisTdId" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(158)).setAttribute("width","100%" );
      ((Element)v.get(158)).setAttribute("border","0" );
      ((Element)v.get(158)).setAttribute("cellspacing","0" );
      ((Element)v.get(158)).setAttribute("cellpadding","0" );
      ((Element)v.get(158)).setAttribute("align","left" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(160)).setAttribute("valign","top" );
      ((Element)v.get(160)).setAttribute("height","13" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(161)).setAttribute("nombre","lblIndInteGis" );
      ((Element)v.get(161)).setAttribute("ancho","150" );
      ((Element)v.get(161)).setAttribute("alto","13" );
      ((Element)v.get(161)).setAttribute("filas","1" );
      ((Element)v.get(161)).setAttribute("id","datosTitle" );
      ((Element)v.get(161)).setAttribute("cod","SegPais.indInteGis.label" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:162 / Elemento padre: 158   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(162)).setAttribute("nombre","indInteGisWidgetTrId" );
      ((Element)v.get(158)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(163)).setAttribute("align","left" );
      ((Element)v.get(163)).setAttribute("nowrap","true" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(164)).setAttribute("nombre","indInteGis" );
      ((Element)v.get(164)).setAttribute("id","datosCampos" );
      ((Element)v.get(164)).setAttribute("multiple","N" );
      ((Element)v.get(164)).setAttribute("req","N" );
      ((Element)v.get(164)).setAttribute("size","1" );
      ((Element)v.get(164)).setAttribute("validacion","" );
      ((Element)v.get(164)).setAttribute("onchange","" );
      ((Element)v.get(164)).setAttribute("onfocus","" );
      ((Element)v.get(164)).setAttribute("valorinicial","" );
      ((Element)v.get(164)).setAttribute("textoinicial","" );
      ((Element)v.get(164)).setAttribute("disabled","" );
      ((Element)v.get(164)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',6, true)" );
      ((Element)v.get(164)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',6, false)" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(166)).setAttribute("ID","I" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(167)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(167)).setAttribute("TIPO","STRING" );
      ((Element)v.get(167)).setAttribute("VALOR","I" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 166   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(168)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(168)).setAttribute("TIPO","STRING" );
      ((Element)v.get(168)).setAttribute("VALOR","GIS" );
      ((Element)v.get(166)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:166   */

      /* Empieza nodo:169 / Elemento padre: 165   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(169)).setAttribute("ID","G" );
      ((Element)v.get(165)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(170)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(170)).setAttribute("TIPO","STRING" );
      ((Element)v.get(170)).setAttribute("VALOR","G" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 169   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(171)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(171)).setAttribute("TIPO","STRING" );
      ((Element)v.get(171)).setAttribute("VALOR","Georreferenciador" );
      ((Element)v.get(169)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:169   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:172 / Elemento padre: 156   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(172)).setAttribute("nombre","indInteGisGapTdId" );
      ((Element)v.get(172)).setAttribute("nowrap","true" );
      ((Element)v.get(172)).setAttribute("class","datosCampos" );
      ((Element)v.get(156)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","25" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 156   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(174)).setAttribute("nombre","valIdenTdId" );
      ((Element)v.get(156)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("TABLE"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(175)).setAttribute("width","100%" );
      ((Element)v.get(175)).setAttribute("border","0" );
      ((Element)v.get(175)).setAttribute("cellspacing","0" );
      ((Element)v.get(175)).setAttribute("cellpadding","0" );
      ((Element)v.get(175)).setAttribute("align","left" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(177)).setAttribute("valign","top" );
      ((Element)v.get(177)).setAttribute("height","13" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(178)).setAttribute("nombre","lblValIden" );
      ((Element)v.get(178)).setAttribute("ancho","150" );
      ((Element)v.get(178)).setAttribute("alto","13" );
      ((Element)v.get(178)).setAttribute("filas","1" );
      ((Element)v.get(178)).setAttribute("id","datosTitle" );
      ((Element)v.get(178)).setAttribute("cod","SegPais.valIden.label" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:179 / Elemento padre: 175   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(179)).setAttribute("nombre","valIdenWidgetTrId" );
      ((Element)v.get(175)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(180)).setAttribute("align","left" );
      ((Element)v.get(180)).setAttribute("nowrap","true" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(181)).setAttribute("nombre","valIden" );
      ((Element)v.get(181)).setAttribute("id","datosCampos" );
      ((Element)v.get(181)).setAttribute("multiple","N" );
      ((Element)v.get(181)).setAttribute("req","N" );
      ((Element)v.get(181)).setAttribute("size","1" );
      ((Element)v.get(181)).setAttribute("validacion","" );
      ((Element)v.get(181)).setAttribute("onchange","" );
      ((Element)v.get(181)).setAttribute("onfocus","" );
      ((Element)v.get(181)).setAttribute("valorinicial","" );
      ((Element)v.get(181)).setAttribute("textoinicial","" );
      ((Element)v.get(181)).setAttribute("disabled","" );
      ((Element)v.get(181)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',7, true)" );
      ((Element)v.get(181)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',7, false)" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(183)).setAttribute("ID","B" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(184)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(184)).setAttribute("TIPO","STRING" );
      ((Element)v.get(184)).setAttribute("VALOR","B" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 183   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(185)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(185)).setAttribute("TIPO","STRING" );
      ((Element)v.get(185)).setAttribute("VALOR","Boleta" );
      ((Element)v.get(183)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:183   */

      /* Empieza nodo:186 / Elemento padre: 182   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(186)).setAttribute("ID","F" );
      ((Element)v.get(182)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(187)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(187)).setAttribute("TIPO","STRING" );
      ((Element)v.get(187)).setAttribute("VALOR","F" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 186   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(188)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(188)).setAttribute("TIPO","STRING" );
      ((Element)v.get(188)).setAttribute("VALOR","Factura" );
      ((Element)v.get(186)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:186   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:189 / Elemento padre: 156   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(189)).setAttribute("nombre","valIdenGapTdId" );
      ((Element)v.get(189)).setAttribute("nowrap","true" );
      ((Element)v.get(189)).setAttribute("class","datosCampos" );
      ((Element)v.get(156)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","25" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 156   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(191)).setAttribute("nombre","indSaldUnicTdId" );
      ((Element)v.get(156)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(192)).setAttribute("width","100%" );
      ((Element)v.get(192)).setAttribute("border","0" );
      ((Element)v.get(192)).setAttribute("cellspacing","0" );
      ((Element)v.get(192)).setAttribute("cellpadding","0" );
      ((Element)v.get(192)).setAttribute("align","left" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(194)).setAttribute("valign","top" );
      ((Element)v.get(194)).setAttribute("height","13" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(195)).setAttribute("nombre","lblIndSaldUnic" );
      ((Element)v.get(195)).setAttribute("alto","13" );
      ((Element)v.get(195)).setAttribute("filas","1" );
      ((Element)v.get(195)).setAttribute("id","datosTitle" );
      ((Element)v.get(195)).setAttribute("cod","SegPais.indSaldUnic.label" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:196 / Elemento padre: 192   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(196)).setAttribute("nombre","indSaldUnicWidgetTrId" );
      ((Element)v.get(192)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(197)).setAttribute("align","left" );
      ((Element)v.get(197)).setAttribute("nowrap","true" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(198)).setAttribute("nombre","indSaldUnic" );
      ((Element)v.get(198)).setAttribute("tipo","H" );
      ((Element)v.get(198)).setAttribute("req","N" );
      ((Element)v.get(198)).setAttribute("id","datosCampos" );
      ((Element)v.get(198)).setAttribute("valor","" );
      ((Element)v.get(198)).setAttribute("disabled","" );
      ((Element)v.get(198)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',8, true)" );
      ((Element)v.get(198)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',8, false)" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(199)).setAttribute("id","datosCampos" );
      ((Element)v.get(199)).setAttribute("valor","1" );
      ((Element)v.get(199)).setAttribute("cod","SegPais.indSaldUnic.1.label" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Elemento padre:199 / Elemento actual: 200   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(199)).appendChild((Text)v.get(200));

      /* Termina nodo Texto:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 198   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(201)).setAttribute("id","datosCampos" );
      ((Element)v.get(201)).setAttribute("valor","0" );
      ((Element)v.get(201)).setAttribute("cod","SegPais.indSaldUnic.0.label" );
      ((Element)v.get(198)).appendChild((Element)v.get(201));

      /* Elemento padre:201 / Elemento actual: 202   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(201)).appendChild((Text)v.get(202));

      /* Termina nodo Texto:202   */
      /* Termina nodo:201   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:203 / Elemento padre: 156   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(203)).setAttribute("nombre","indSaldUnicGapTdId" );
      ((Element)v.get(203)).setAttribute("nowrap","true" );
      ((Element)v.get(203)).setAttribute("class","datosCampos" );
      ((Element)v.get(156)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","25" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 156   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(205)).setAttribute("nombre","valProgEjecTdId" );
      ((Element)v.get(156)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(206)).setAttribute("width","100%" );
      ((Element)v.get(206)).setAttribute("border","0" );
      ((Element)v.get(206)).setAttribute("cellspacing","0" );
      ((Element)v.get(206)).setAttribute("cellpadding","0" );
      ((Element)v.get(206)).setAttribute("align","left" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(208)).setAttribute("valign","top" );
      ((Element)v.get(208)).setAttribute("height","13" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(209)).setAttribute("nombre","lblValProgEjec" );
      ((Element)v.get(209)).setAttribute("alto","13" );
      ((Element)v.get(209)).setAttribute("filas","1" );
      ((Element)v.get(209)).setAttribute("id","datosTitle" );
      ((Element)v.get(209)).setAttribute("cod","SegPais.valProgEjec.label" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:210 / Elemento padre: 206   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(210)).setAttribute("nombre","valProgEjecWidgetTrId" );
      ((Element)v.get(206)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(211)).setAttribute("align","left" );
      ((Element)v.get(211)).setAttribute("nowrap","true" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(212)).setAttribute("nombre","valProgEjec" );
      ((Element)v.get(212)).setAttribute("id","datosCampos" );
      ((Element)v.get(212)).setAttribute("trim","S" );
      ((Element)v.get(212)).setAttribute("max","10" );
      ((Element)v.get(212)).setAttribute("onchange","" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(212)).setAttribute("req","N" );
      ((Element)v.get(212)).setAttribute("size","10" );
      ((Element)v.get(212)).setAttribute("valor","" );
      ((Element)v.get(212)).setAttribute("validacion","" );
      ((Element)v.get(212)).setAttribute("disabled","" );
      ((Element)v.get(212)).setAttribute("onblur","" );
      ((Element)v.get(212)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',9, true)" );
      ((Element)v.get(212)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 9, false)" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:213 / Elemento padre: 156   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(213)).setAttribute("nombre","valProgEjecGapTdId" );
      ((Element)v.get(213)).setAttribute("nowrap","true" );
      ((Element)v.get(213)).setAttribute("class","datosCampos" );
      ((Element)v.get(156)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","25" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 156   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(215)).setAttribute("nombre","valPorcAlarTdId" );
      ((Element)v.get(156)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(216)).setAttribute("width","100%" );
      ((Element)v.get(216)).setAttribute("border","0" );
      ((Element)v.get(216)).setAttribute("cellspacing","0" );
      ((Element)v.get(216)).setAttribute("cellpadding","0" );
      ((Element)v.get(216)).setAttribute("align","left" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(218)).setAttribute("valign","top" );
      ((Element)v.get(218)).setAttribute("height","13" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(219)).setAttribute("nombre","lblValPorcAlar" );
      ((Element)v.get(219)).setAttribute("alto","13" );
      ((Element)v.get(219)).setAttribute("filas","1" );
      ((Element)v.get(219)).setAttribute("id","datosTitle" );
      ((Element)v.get(219)).setAttribute("cod","SegPais.valPorcAlar.label" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:220 / Elemento padre: 216   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(220)).setAttribute("nombre","valPorcAlarWidgetTrId" );
      ((Element)v.get(216)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(221)).setAttribute("align","left" );
      ((Element)v.get(221)).setAttribute("nowrap","true" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(222)).setAttribute("nombre","valPorcAlar" );
      ((Element)v.get(222)).setAttribute("id","datosCampos" );
      ((Element)v.get(222)).setAttribute("trim","S" );
      ((Element)v.get(222)).setAttribute("max","5" );
      ((Element)v.get(222)).setAttribute("onchange","" );
      ((Element)v.get(222)).setAttribute("req","N" );
      ((Element)v.get(222)).setAttribute("size","5" );
      ((Element)v.get(222)).setAttribute("valor","" );
      ((Element)v.get(222)).setAttribute("validacion","" );
      ((Element)v.get(222)).setAttribute("disabled","" );
      ((Element)v.get(222)).setAttribute("onblur","" );
      ((Element)v.get(222)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',10, true)" );
      ((Element)v.get(222)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 10, false)" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:223 / Elemento padre: 156   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(223)).setAttribute("nombre","valPorcAlarGapTdId" );
      ((Element)v.get(223)).setAttribute("nowrap","true" );
      ((Element)v.get(223)).setAttribute("class","datosCampos" );
      ((Element)v.get(156)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","25" );
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 156   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(225)).setAttribute("width","100%" );
      ((Element)v.get(156)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:151   */

      /* Empieza nodo:227 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(227)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(59)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(228)).setAttribute("align","center" );
      ((Element)v.get(228)).setAttribute("width","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","12" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(229)).setAttribute("height","8" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 227   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(227)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","8" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 227   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(232)).setAttribute("align","center" );
      ((Element)v.get(232)).setAttribute("width","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","12" );
      ((Element)v.get(233)).setAttribute("height","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:227   */

      /* Empieza nodo:234 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(234)).setAttribute("nombre","formTr3" );
      ((Element)v.get(59)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(235)).setAttribute("align","center" );
      ((Element)v.get(235)).setAttribute("width","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(236)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).setAttribute("width","8" );
      ((Element)v.get(236)).setAttribute("height","12" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(237)).setAttribute("width","100%" );
      ((Element)v.get(234)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(238)).setAttribute("width","100%" );
      ((Element)v.get(238)).setAttribute("border","0" );
      ((Element)v.get(238)).setAttribute("cellspacing","0" );
      ((Element)v.get(238)).setAttribute("cellpadding","0" );
      ((Element)v.get(238)).setAttribute("align","left" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(239)).setAttribute("align","left" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(240)).setAttribute("nombre","indCompAutoTdId" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(241)).setAttribute("width","100%" );
      ((Element)v.get(241)).setAttribute("border","0" );
      ((Element)v.get(241)).setAttribute("cellspacing","0" );
      ((Element)v.get(241)).setAttribute("cellpadding","0" );
      ((Element)v.get(241)).setAttribute("align","left" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(243)).setAttribute("valign","top" );
      ((Element)v.get(243)).setAttribute("height","13" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(244)).setAttribute("nombre","lblIndCompAuto" );
      ((Element)v.get(244)).setAttribute("alto","13" );
      ((Element)v.get(244)).setAttribute("filas","1" );
      ((Element)v.get(244)).setAttribute("id","datosTitle" );
      ((Element)v.get(244)).setAttribute("cod","SegPais.indCompAuto.label" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:245 / Elemento padre: 241   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(245)).setAttribute("nombre","indCompAutoWidgetTrId" );
      ((Element)v.get(241)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(246)).setAttribute("align","left" );
      ((Element)v.get(246)).setAttribute("nowrap","true" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(247)).setAttribute("nombre","indCompAuto" );
      ((Element)v.get(247)).setAttribute("tipo","H" );
      ((Element)v.get(247)).setAttribute("req","N" );
      ((Element)v.get(247)).setAttribute("id","datosCampos" );
      ((Element)v.get(247)).setAttribute("valor","" );
      ((Element)v.get(247)).setAttribute("disabled","" );
      ((Element)v.get(247)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',11, true)" );
      ((Element)v.get(247)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',11, false)" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(248)).setAttribute("id","datosCampos" );
      ((Element)v.get(248)).setAttribute("valor","1" );
      ((Element)v.get(248)).setAttribute("cod","SegPais.indCompAuto.1.label" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Elemento padre:248 / Elemento actual: 249   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(248)).appendChild((Text)v.get(249));

      /* Termina nodo Texto:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 247   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(250)).setAttribute("id","datosCampos" );
      ((Element)v.get(250)).setAttribute("valor","0" );
      ((Element)v.get(250)).setAttribute("cod","SegPais.indCompAuto.0.label" );
      ((Element)v.get(247)).appendChild((Element)v.get(250));

      /* Elemento padre:250 / Elemento actual: 251   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(250)).appendChild((Text)v.get(251));

      /* Termina nodo Texto:251   */
      /* Termina nodo:250   */
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:252 / Elemento padre: 239   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(252)).setAttribute("nombre","indCompAutoGapTdId" );
      ((Element)v.get(252)).setAttribute("nowrap","true" );
      ((Element)v.get(252)).setAttribute("class","datosCampos" );
      ((Element)v.get(239)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","25" );
      ((Element)v.get(253)).setAttribute("height","8" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 239   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(254)).setAttribute("nombre","numDiasMoraTdId" );
      ((Element)v.get(239)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(255)).setAttribute("width","100%" );
      ((Element)v.get(255)).setAttribute("border","0" );
      ((Element)v.get(255)).setAttribute("cellspacing","0" );
      ((Element)v.get(255)).setAttribute("cellpadding","0" );
      ((Element)v.get(255)).setAttribute("align","left" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(257)).setAttribute("valign","top" );
      ((Element)v.get(257)).setAttribute("height","13" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(258)).setAttribute("nombre","lblNumDiasMora" );
      ((Element)v.get(258)).setAttribute("alto","13" );
      ((Element)v.get(258)).setAttribute("filas","1" );
      ((Element)v.get(258)).setAttribute("id","datosTitle" );
      ((Element)v.get(258)).setAttribute("cod","SegPais.numDiasMora.label" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:259 / Elemento padre: 255   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(259)).setAttribute("nombre","numDiasMoraWidgetTrId" );
      ((Element)v.get(255)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(260)).setAttribute("align","left" );
      ((Element)v.get(260)).setAttribute("nowrap","true" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(261)).setAttribute("nombre","numDiasMora" );
      ((Element)v.get(261)).setAttribute("id","datosCampos" );
      ((Element)v.get(261)).setAttribute("trim","S" );
      ((Element)v.get(261)).setAttribute("max","3" );
      ((Element)v.get(261)).setAttribute("onchange","" );
      ((Element)v.get(261)).setAttribute("req","N" );
      ((Element)v.get(261)).setAttribute("size","3" );
      ((Element)v.get(261)).setAttribute("valor","" );
      ((Element)v.get(261)).setAttribute("validacion","" );
      ((Element)v.get(261)).setAttribute("disabled","" );
      ((Element)v.get(261)).setAttribute("onblur","" );
      ((Element)v.get(261)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',12, true)" );
      ((Element)v.get(261)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 12, false)" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:262 / Elemento padre: 239   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(262)).setAttribute("nombre","numDiasMoraGapTdId" );
      ((Element)v.get(262)).setAttribute("nowrap","true" );
      ((Element)v.get(262)).setAttribute("class","datosCampos" );
      ((Element)v.get(239)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","25" );
      ((Element)v.get(263)).setAttribute("height","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 239   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(264)).setAttribute("nombre","indTratAcumDescTdId" );
      ((Element)v.get(239)).appendChild((Element)v.get(264));

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
      ((Element)v.get(268)).setAttribute("nombre","lblIndTratAcumDesc" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(268)).setAttribute("alto","13" );
      ((Element)v.get(268)).setAttribute("filas","1" );
      ((Element)v.get(268)).setAttribute("id","datosTitle" );
      ((Element)v.get(268)).setAttribute("cod","SegPais.indTratAcumDesc.label" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:269 / Elemento padre: 265   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(269)).setAttribute("nombre","indTratAcumDescWidgetTrId" );
      ((Element)v.get(265)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(270)).setAttribute("align","left" );
      ((Element)v.get(270)).setAttribute("nowrap","true" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(271)).setAttribute("nombre","indTratAcumDesc" );
      ((Element)v.get(271)).setAttribute("tipo","H" );
      ((Element)v.get(271)).setAttribute("req","N" );
      ((Element)v.get(271)).setAttribute("id","datosCampos" );
      ((Element)v.get(271)).setAttribute("valor","" );
      ((Element)v.get(271)).setAttribute("disabled","" );
      ((Element)v.get(271)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',13, true)" );
      ((Element)v.get(271)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',13, false)" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(272)).setAttribute("id","datosCampos" );
      ((Element)v.get(272)).setAttribute("valor","1" );
      ((Element)v.get(272)).setAttribute("cod","SegPais.indTratAcumDesc.1.label" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Elemento padre:272 / Elemento actual: 273   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(272)).appendChild((Text)v.get(273));

      /* Termina nodo Texto:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:274 / Elemento padre: 271   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(274)).setAttribute("id","datosCampos" );
      ((Element)v.get(274)).setAttribute("valor","0" );
      ((Element)v.get(274)).setAttribute("cod","SegPais.indTratAcumDesc.0.label" );
      ((Element)v.get(271)).appendChild((Element)v.get(274));

      /* Elemento padre:274 / Elemento actual: 275   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(274)).appendChild((Text)v.get(275));

      /* Termina nodo Texto:275   */
      /* Termina nodo:274   */
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:276 / Elemento padre: 239   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(276)).setAttribute("nombre","indTratAcumDescGapTdId" );
      ((Element)v.get(276)).setAttribute("nowrap","true" );
      ((Element)v.get(276)).setAttribute("class","datosCampos" );
      ((Element)v.get(239)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(277)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).setAttribute("width","25" );
      ((Element)v.get(277)).setAttribute("height","8" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 239   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(278)).setAttribute("nombre","valTiemRezoTdId" );
      ((Element)v.get(239)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(279)).setAttribute("width","100%" );
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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(282)).setAttribute("nombre","lblValTiemRezo" );
      ((Element)v.get(282)).setAttribute("alto","13" );
      ((Element)v.get(282)).setAttribute("filas","1" );
      ((Element)v.get(282)).setAttribute("id","datosTitle" );
      ((Element)v.get(282)).setAttribute("cod","SegPais.valTiemRezo.label" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:283 / Elemento padre: 279   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(283)).setAttribute("nombre","valTiemRezoWidgetTrId" );
      ((Element)v.get(279)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(284)).setAttribute("align","left" );
      ((Element)v.get(284)).setAttribute("nowrap","true" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(285)).setAttribute("nombre","valTiemRezo" );
      ((Element)v.get(285)).setAttribute("id","datosCampos" );
      ((Element)v.get(285)).setAttribute("trim","S" );
      ((Element)v.get(285)).setAttribute("max","2" );
      ((Element)v.get(285)).setAttribute("onchange","" );
      ((Element)v.get(285)).setAttribute("req","N" );
      ((Element)v.get(285)).setAttribute("size","2" );
      ((Element)v.get(285)).setAttribute("valor","" );
      ((Element)v.get(285)).setAttribute("validacion","" );
      ((Element)v.get(285)).setAttribute("disabled","" );
      ((Element)v.get(285)).setAttribute("onblur","" );
      ((Element)v.get(285)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',14, true)" );
      ((Element)v.get(285)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 14, false)" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:283   */
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:286 / Elemento padre: 239   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(286)).setAttribute("nombre","valTiemRezoGapTdId" );
      ((Element)v.get(286)).setAttribute("nowrap","true" );
      ((Element)v.get(286)).setAttribute("class","datosCampos" );
      ((Element)v.get(239)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(287)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).setAttribute("width","25" );
      ((Element)v.get(287)).setAttribute("height","8" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 239   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(288)).setAttribute("nombre","valConfSecuCccTdId" );
      ((Element)v.get(239)).appendChild((Element)v.get(288));

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
      ((Element)v.get(292)).setAttribute("nombre","lblValConfSecuCcc" );
      ((Element)v.get(292)).setAttribute("ancho","150" );
      ((Element)v.get(292)).setAttribute("alto","13" );
      ((Element)v.get(292)).setAttribute("filas","1" );
      ((Element)v.get(292)).setAttribute("id","datosTitle" );
      ((Element)v.get(292)).setAttribute("cod","SegPais.valConfSecuCcc.label" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:293 / Elemento padre: 289   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(293)).setAttribute("nombre","valConfSecuCccWidgetTrId" );
      ((Element)v.get(289)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(294)).setAttribute("align","left" );
      ((Element)v.get(294)).setAttribute("nowrap","true" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(295)).setAttribute("nombre","valConfSecuCcc" );
      ((Element)v.get(295)).setAttribute("id","datosCampos" );
      ((Element)v.get(295)).setAttribute("multiple","N" );
      ((Element)v.get(295)).setAttribute("req","N" );
      ((Element)v.get(295)).setAttribute("size","1" );
      ((Element)v.get(295)).setAttribute("validacion","" );
      ((Element)v.get(295)).setAttribute("onchange","" );
      ((Element)v.get(295)).setAttribute("onfocus","" );
      ((Element)v.get(295)).setAttribute("valorinicial","" );
      ((Element)v.get(295)).setAttribute("textoinicial","" );
      ((Element)v.get(295)).setAttribute("disabled","" );
      ((Element)v.get(295)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',15, true)" );
      ((Element)v.get(295)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',15, false)" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(295)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(297)).setAttribute("ID","U" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(298)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(298)).setAttribute("TIPO","STRING" );
      ((Element)v.get(298)).setAttribute("VALOR","U" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 297   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(299)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(299)).setAttribute("TIPO","STRING" );
      ((Element)v.get(299)).setAttribute("VALOR","Único" );
      ((Element)v.get(297)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:297   */

      /* Empieza nodo:300 / Elemento padre: 296   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(300)).setAttribute("ID","A" );
      ((Element)v.get(296)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(301)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(301)).setAttribute("TIPO","STRING" );
      ((Element)v.get(301)).setAttribute("VALOR","A" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 300   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(302)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(302)).setAttribute("TIPO","STRING" );
      ((Element)v.get(302)).setAttribute("VALOR","Año" );
      ((Element)v.get(300)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:300   */

      /* Empieza nodo:303 / Elemento padre: 296   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(303)).setAttribute("ID","M" );
      ((Element)v.get(296)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(304)).setAttribute("NOMBRE","CODIGO" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(304)).setAttribute("TIPO","STRING" );
      ((Element)v.get(304)).setAttribute("VALOR","M" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 303   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(305)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(305)).setAttribute("TIPO","STRING" );
      ((Element)v.get(305)).setAttribute("VALOR","Mes y año" );
      ((Element)v.get(303)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:303   */
      /* Termina nodo:296   */
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:293   */
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:306 / Elemento padre: 239   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(306)).setAttribute("nombre","valConfSecuCccGapTdId" );
      ((Element)v.get(306)).setAttribute("nowrap","true" );
      ((Element)v.get(306)).setAttribute("class","datosCampos" );
      ((Element)v.get(239)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
      ((Element)v.get(307)).setAttribute("width","25" );
      ((Element)v.get(307)).setAttribute("height","8" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 239   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(308)).setAttribute("width","100%" );
      ((Element)v.get(239)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:234   */

      /* Empieza nodo:310 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(310)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(59)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(311)).setAttribute("align","center" );
      ((Element)v.get(311)).setAttribute("width","8" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("width","12" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 310   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(310)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(314)).setAttribute("src","b.gif" );
      ((Element)v.get(314)).setAttribute("width","8" );
      ((Element)v.get(314)).setAttribute("height","8" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 310   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(315)).setAttribute("align","center" );
      ((Element)v.get(315)).setAttribute("width","8" );
      ((Element)v.get(310)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","12" );
      ((Element)v.get(316)).setAttribute("height","8" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */
      /* Termina nodo:310   */

      /* Empieza nodo:317 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(317)).setAttribute("nombre","formTr4" );
      ((Element)v.get(59)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(318)).setAttribute("align","center" );
      ((Element)v.get(318)).setAttribute("width","8" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(319)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).setAttribute("width","8" );
      ((Element)v.get(319)).setAttribute("height","12" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 317   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(320)).setAttribute("width","100%" );
      ((Element)v.get(317)).appendChild((Element)v.get(320));

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
      ((Element)v.get(322)).setAttribute("align","left" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(323)).setAttribute("nombre","numDiasFactTdId" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(324)).setAttribute("width","100%" );
      ((Element)v.get(324)).setAttribute("border","0" );
      ((Element)v.get(324)).setAttribute("cellspacing","0" );
      ((Element)v.get(324)).setAttribute("cellpadding","0" );
      ((Element)v.get(324)).setAttribute("align","left" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("TD"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(326)).setAttribute("valign","top" );
      ((Element)v.get(326)).setAttribute("height","13" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(327)).setAttribute("nombre","lblNumDiasFact" );
      ((Element)v.get(327)).setAttribute("alto","13" );
      ((Element)v.get(327)).setAttribute("filas","1" );
      ((Element)v.get(327)).setAttribute("id","datosTitle" );
      ((Element)v.get(327)).setAttribute("cod","SegPais.numDiasFact.label" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:328 / Elemento padre: 324   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(328)).setAttribute("nombre","numDiasFactWidgetTrId" );
      ((Element)v.get(324)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(329)).setAttribute("align","left" );
      ((Element)v.get(329)).setAttribute("nowrap","true" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(330)).setAttribute("nombre","numDiasFact" );
      ((Element)v.get(330)).setAttribute("id","datosCampos" );
      ((Element)v.get(330)).setAttribute("trim","S" );
      ((Element)v.get(330)).setAttribute("max","2" );
      ((Element)v.get(330)).setAttribute("onchange","" );
      ((Element)v.get(330)).setAttribute("req","N" );
      ((Element)v.get(330)).setAttribute("size","2" );
      ((Element)v.get(330)).setAttribute("valor","" );
      ((Element)v.get(330)).setAttribute("validacion","" );
      ((Element)v.get(330)).setAttribute("disabled","" );
      ((Element)v.get(330)).setAttribute("onblur","" );
      ((Element)v.get(330)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',16, true)" );
      ((Element)v.get(330)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 16, false)" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */
      /* Termina nodo:328   */
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:331 / Elemento padre: 322   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(331)).setAttribute("nombre","numDiasFactGapTdId" );
      ((Element)v.get(331)).setAttribute("nowrap","true" );
      ((Element)v.get(331)).setAttribute("class","datosCampos" );
      ((Element)v.get(322)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(332)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).setAttribute("width","25" );
      ((Element)v.get(332)).setAttribute("height","8" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 322   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(333)).setAttribute("nombre","numLimiDifePagoTdId" );
      ((Element)v.get(322)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(334)).setAttribute("width","100%" );
      ((Element)v.get(334)).setAttribute("border","0" );
      ((Element)v.get(334)).setAttribute("cellspacing","0" );
      ((Element)v.get(334)).setAttribute("cellpadding","0" );
      ((Element)v.get(334)).setAttribute("align","left" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(336)).setAttribute("valign","top" );
      ((Element)v.get(336)).setAttribute("height","13" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(337)).setAttribute("nombre","lblNumLimiDifePago" );
      ((Element)v.get(337)).setAttribute("alto","13" );
      ((Element)v.get(337)).setAttribute("filas","1" );
      ((Element)v.get(337)).setAttribute("id","datosTitle" );
      ((Element)v.get(337)).setAttribute("cod","SegPais.numLimiDifePago.label" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:338 / Elemento padre: 334   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(338)).setAttribute("nombre","numLimiDifePagoWidgetTrId" );
      ((Element)v.get(334)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(339)).setAttribute("align","left" );
      ((Element)v.get(339)).setAttribute("nowrap","true" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(340)).setAttribute("nombre","numLimiDifePago" );
      ((Element)v.get(340)).setAttribute("id","datosCampos" );
      ((Element)v.get(340)).setAttribute("trim","S" );
      ((Element)v.get(340)).setAttribute("max","12" );
      ((Element)v.get(340)).setAttribute("onchange","" );
      ((Element)v.get(340)).setAttribute("req","N" );
      ((Element)v.get(340)).setAttribute("size","12" );
      ((Element)v.get(340)).setAttribute("valor","" );
      ((Element)v.get(340)).setAttribute("validacion","" );
      ((Element)v.get(340)).setAttribute("disabled","" );
      ((Element)v.get(340)).setAttribute("onblur","" );
      ((Element)v.get(340)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',17, true)" );
      ((Element)v.get(340)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 17, false)" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:338   */
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:341 / Elemento padre: 322   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(341)).setAttribute("nombre","numLimiDifePagoGapTdId" );
      ((Element)v.get(341)).setAttribute("nowrap","true" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(341)).setAttribute("class","datosCampos" );
      ((Element)v.get(322)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","25" );
      ((Element)v.get(342)).setAttribute("height","8" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 322   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(343)).setAttribute("nombre","indEmisVencTdId" );
      ((Element)v.get(322)).appendChild((Element)v.get(343));

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
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(346)).setAttribute("valign","top" );
      ((Element)v.get(346)).setAttribute("height","13" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(347)).setAttribute("nombre","lblIndEmisVenc" );
      ((Element)v.get(347)).setAttribute("alto","13" );
      ((Element)v.get(347)).setAttribute("filas","1" );
      ((Element)v.get(347)).setAttribute("id","datosTitle" );
      ((Element)v.get(347)).setAttribute("cod","SegPais.indEmisVenc.label" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:348 / Elemento padre: 344   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(348)).setAttribute("nombre","indEmisVencWidgetTrId" );
      ((Element)v.get(344)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(349)).setAttribute("align","left" );
      ((Element)v.get(349)).setAttribute("nowrap","true" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(350)).setAttribute("nombre","indEmisVenc" );
      ((Element)v.get(350)).setAttribute("tipo","H" );
      ((Element)v.get(350)).setAttribute("req","N" );
      ((Element)v.get(350)).setAttribute("id","datosCampos" );
      ((Element)v.get(350)).setAttribute("valor","" );
      ((Element)v.get(350)).setAttribute("disabled","" );
      ((Element)v.get(350)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',18, true)" );
      ((Element)v.get(350)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',18, false)" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(351)).setAttribute("id","datosCampos" );
      ((Element)v.get(351)).setAttribute("valor","1" );
      ((Element)v.get(351)).setAttribute("cod","SegPais.indEmisVenc.1.label" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Elemento padre:351 / Elemento actual: 352   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(351)).appendChild((Text)v.get(352));

      /* Termina nodo Texto:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:353 / Elemento padre: 350   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(353)).setAttribute("id","datosCampos" );
      ((Element)v.get(353)).setAttribute("valor","0" );
      ((Element)v.get(353)).setAttribute("cod","SegPais.indEmisVenc.0.label" );
      ((Element)v.get(350)).appendChild((Element)v.get(353));

      /* Elemento padre:353 / Elemento actual: 354   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(353)).appendChild((Text)v.get(354));

      /* Termina nodo Texto:354   */
      /* Termina nodo:353   */
      /* Termina nodo:350   */
      /* Termina nodo:349   */
      /* Termina nodo:348   */
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:355 / Elemento padre: 322   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(355)).setAttribute("nombre","indEmisVencGapTdId" );
      ((Element)v.get(355)).setAttribute("nowrap","true" );
      ((Element)v.get(355)).setAttribute("class","datosCampos" );
      ((Element)v.get(322)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(356)).setAttribute("src","b.gif" );
      ((Element)v.get(356)).setAttribute("width","25" );
      ((Element)v.get(356)).setAttribute("height","8" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:355   */

      /* Empieza nodo:357 / Elemento padre: 322   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(357)).setAttribute("nombre","valMaxiDifeAnlsCombTdId" );
      ((Element)v.get(322)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(358)).setAttribute("width","100%" );
      ((Element)v.get(358)).setAttribute("border","0" );
      ((Element)v.get(358)).setAttribute("cellspacing","0" );
      ((Element)v.get(358)).setAttribute("cellpadding","0" );
      ((Element)v.get(358)).setAttribute("align","left" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(360)).setAttribute("valign","top" );
      ((Element)v.get(360)).setAttribute("height","13" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(361)).setAttribute("nombre","lblValMaxiDifeAnlsComb" );
      ((Element)v.get(361)).setAttribute("alto","13" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(361)).setAttribute("filas","1" );
      ((Element)v.get(361)).setAttribute("id","datosTitle" );
      ((Element)v.get(361)).setAttribute("cod","SegPais.valMaxiDifeAnlsComb.label" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:362 / Elemento padre: 358   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(362)).setAttribute("nombre","valMaxiDifeAnlsCombWidgetTrId" );
      ((Element)v.get(358)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(363)).setAttribute("align","left" );
      ((Element)v.get(363)).setAttribute("nowrap","true" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(364)).setAttribute("nombre","valMaxiDifeAnlsComb" );
      ((Element)v.get(364)).setAttribute("id","datosCampos" );
      ((Element)v.get(364)).setAttribute("trim","S" );
      ((Element)v.get(364)).setAttribute("max","12" );
      ((Element)v.get(364)).setAttribute("onchange","" );
      ((Element)v.get(364)).setAttribute("req","N" );
      ((Element)v.get(364)).setAttribute("size","12" );
      ((Element)v.get(364)).setAttribute("valor","" );
      ((Element)v.get(364)).setAttribute("validacion","" );
      ((Element)v.get(364)).setAttribute("disabled","" );
      ((Element)v.get(364)).setAttribute("onblur","" );
      ((Element)v.get(364)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',19, true)" );
      ((Element)v.get(364)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 19, false)" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */
      /* Termina nodo:362   */
      /* Termina nodo:358   */
      /* Termina nodo:357   */

      /* Empieza nodo:365 / Elemento padre: 322   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(365)).setAttribute("nombre","valMaxiDifeAnlsCombGapTdId" );
      ((Element)v.get(365)).setAttribute("nowrap","true" );
      ((Element)v.get(365)).setAttribute("class","datosCampos" );
      ((Element)v.get(322)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(366)).setAttribute("src","b.gif" );
      ((Element)v.get(366)).setAttribute("width","25" );
      ((Element)v.get(366)).setAttribute("height","8" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:367 / Elemento padre: 322   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(367)).setAttribute("width","100%" );
      ((Element)v.get(322)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(368)).setAttribute("src","b.gif" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */
      /* Termina nodo:322   */
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:317   */

      /* Empieza nodo:369 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(369)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(59)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(370)).setAttribute("align","center" );
      ((Element)v.get(370)).setAttribute("width","8" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).setAttribute("width","12" );
      ((Element)v.get(371)).setAttribute("height","8" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:372 / Elemento padre: 369   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(369)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(373)).setAttribute("src","b.gif" );
      ((Element)v.get(373)).setAttribute("width","8" );
      ((Element)v.get(373)).setAttribute("height","8" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */

      /* Empieza nodo:374 / Elemento padre: 369   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(374)).setAttribute("align","center" );
      ((Element)v.get(374)).setAttribute("width","8" );
      ((Element)v.get(369)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(375)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).setAttribute("width","12" );
      ((Element)v.get(375)).setAttribute("height","8" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */
      /* Termina nodo:369   */

      /* Empieza nodo:376 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(376)).setAttribute("nombre","formTr5" );
      ((Element)v.get(59)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(377)).setAttribute("align","center" );
      ((Element)v.get(377)).setAttribute("width","8" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(378)).setAttribute("src","b.gif" );
      ((Element)v.get(378)).setAttribute("width","8" );
      ((Element)v.get(378)).setAttribute("height","12" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 376   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(379)).setAttribute("width","100%" );
      ((Element)v.get(376)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(380)).setAttribute("width","100%" );
      ((Element)v.get(380)).setAttribute("border","0" );
      ((Element)v.get(380)).setAttribute("cellspacing","0" );
      ((Element)v.get(380)).setAttribute("cellpadding","0" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(380)).setAttribute("align","left" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(381)).setAttribute("align","left" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(382)).setAttribute("nombre","numPosiNumeClieTdId" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(383)).setAttribute("width","100%" );
      ((Element)v.get(383)).setAttribute("border","0" );
      ((Element)v.get(383)).setAttribute("cellspacing","0" );
      ((Element)v.get(383)).setAttribute("cellpadding","0" );
      ((Element)v.get(383)).setAttribute("align","left" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(385)).setAttribute("valign","top" );
      ((Element)v.get(385)).setAttribute("height","13" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(386)).setAttribute("nombre","lblNumPosiNumeClie" );
      ((Element)v.get(386)).setAttribute("alto","13" );
      ((Element)v.get(386)).setAttribute("filas","1" );
      ((Element)v.get(386)).setAttribute("id","datosTitle" );
      ((Element)v.get(386)).setAttribute("cod","SegPais.numPosiNumeClie.label" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:387 / Elemento padre: 383   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(387)).setAttribute("nombre","numPosiNumeClieWidgetTrId" );
      ((Element)v.get(383)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(388)).setAttribute("align","left" );
      ((Element)v.get(388)).setAttribute("nowrap","true" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(389)).setAttribute("nombre","numPosiNumeClie" );
      ((Element)v.get(389)).setAttribute("id","datosCampos" );
      ((Element)v.get(389)).setAttribute("trim","S" );
      ((Element)v.get(389)).setAttribute("max","2" );
      ((Element)v.get(389)).setAttribute("onchange","" );
      ((Element)v.get(389)).setAttribute("req","N" );
      ((Element)v.get(389)).setAttribute("size","2" );
      ((Element)v.get(389)).setAttribute("valor","" );
      ((Element)v.get(389)).setAttribute("validacion","" );
      ((Element)v.get(389)).setAttribute("disabled","" );
      ((Element)v.get(389)).setAttribute("onblur","" );
      ((Element)v.get(389)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',20, true)" );
      ((Element)v.get(389)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 20, false)" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:387   */
      /* Termina nodo:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:390 / Elemento padre: 381   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(390)).setAttribute("nombre","numPosiNumeClieGapTdId" );
      ((Element)v.get(390)).setAttribute("nowrap","true" );
      ((Element)v.get(390)).setAttribute("class","datosCampos" );
      ((Element)v.get(381)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(391)).setAttribute("src","b.gif" );
      ((Element)v.get(391)).setAttribute("width","25" );
      ((Element)v.get(391)).setAttribute("height","8" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 381   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(392)).setAttribute("nombre","valFormFechTdId" );
      ((Element)v.get(381)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(393)).setAttribute("width","100%" );
      ((Element)v.get(393)).setAttribute("border","0" );
      ((Element)v.get(393)).setAttribute("cellspacing","0" );
      ((Element)v.get(393)).setAttribute("cellpadding","0" );
      ((Element)v.get(393)).setAttribute("align","left" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(395)).setAttribute("valign","top" );
      ((Element)v.get(395)).setAttribute("height","13" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(396)).setAttribute("nombre","lblValFormFech" );
      ((Element)v.get(396)).setAttribute("ancho","150" );
      ((Element)v.get(396)).setAttribute("alto","13" );
      ((Element)v.get(396)).setAttribute("filas","1" );
      ((Element)v.get(396)).setAttribute("id","datosTitle" );
      ((Element)v.get(396)).setAttribute("cod","SegPais.valFormFech.label" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:397 / Elemento padre: 393   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(397)).setAttribute("nombre","valFormFechWidgetTrId" );
      ((Element)v.get(393)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(398)).setAttribute("align","left" );
      ((Element)v.get(398)).setAttribute("nowrap","true" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(397)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(399)).setAttribute("nombre","valFormFech" );
      ((Element)v.get(399)).setAttribute("id","datosCampos" );
      ((Element)v.get(399)).setAttribute("multiple","N" );
      ((Element)v.get(399)).setAttribute("req","N" );
      ((Element)v.get(399)).setAttribute("size","1" );
      ((Element)v.get(399)).setAttribute("validacion","" );
      ((Element)v.get(399)).setAttribute("onchange","" );
      ((Element)v.get(399)).setAttribute("onfocus","" );
      ((Element)v.get(399)).setAttribute("valorinicial","" );
      ((Element)v.get(399)).setAttribute("textoinicial","" );
      ((Element)v.get(399)).setAttribute("disabled","" );
      ((Element)v.get(399)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',21, true)" );
      ((Element)v.get(399)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',21, false)" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(399)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(401)).setAttribute("ID","dd/mm/yyyy" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(402)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(402)).setAttribute("TIPO","STRING" );
      ((Element)v.get(402)).setAttribute("VALOR","dd/mm/yyyy" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */

      /* Empieza nodo:403 / Elemento padre: 401   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(403)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(403)).setAttribute("TIPO","STRING" );
      ((Element)v.get(403)).setAttribute("VALOR","dd/mm/aaaa" );
      ((Element)v.get(401)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:401   */

      /* Empieza nodo:404 / Elemento padre: 400   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(404)).setAttribute("ID","mm/dd/yyyy" );
      ((Element)v.get(400)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(405)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(405)).setAttribute("TIPO","STRING" );
      ((Element)v.get(405)).setAttribute("VALOR","mm/dd/yyyy" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */

      /* Empieza nodo:406 / Elemento padre: 404   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(406)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(406)).setAttribute("TIPO","STRING" );
      ((Element)v.get(406)).setAttribute("VALOR","mm/dd/aaaa" );
      ((Element)v.get(404)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:404   */

      /* Empieza nodo:407 / Elemento padre: 400   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(407)).setAttribute("ID","dd-mm-yyyy" );
      ((Element)v.get(400)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(408)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(408)).setAttribute("TIPO","STRING" );
      ((Element)v.get(408)).setAttribute("VALOR","dd-mm-yyyy" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */

      /* Empieza nodo:409 / Elemento padre: 407   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(409)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(409)).setAttribute("TIPO","STRING" );
      ((Element)v.get(409)).setAttribute("VALOR","dd-mm-aaaa" );
      ((Element)v.get(407)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:407   */
      /* Termina nodo:400   */
      /* Termina nodo:399   */
      /* Termina nodo:398   */
      /* Termina nodo:397   */
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:410 / Elemento padre: 381   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(410)).setAttribute("nombre","valFormFechGapTdId" );
      ((Element)v.get(410)).setAttribute("nowrap","true" );
      ((Element)v.get(410)).setAttribute("class","datosCampos" );
      ((Element)v.get(381)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(411)).setAttribute("src","b.gif" );
      ((Element)v.get(411)).setAttribute("width","25" );
      ((Element)v.get(411)).setAttribute("height","8" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */

      /* Empieza nodo:412 / Elemento padre: 381   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(412)).setAttribute("nombre","valSepaMileTdId" );
      ((Element)v.get(381)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(413)).setAttribute("width","100%" );
      ((Element)v.get(413)).setAttribute("border","0" );
      ((Element)v.get(413)).setAttribute("cellspacing","0" );
      ((Element)v.get(413)).setAttribute("cellpadding","0" );
      ((Element)v.get(413)).setAttribute("align","left" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(413)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(415)).setAttribute("valign","top" );
      ((Element)v.get(415)).setAttribute("height","13" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(416)).setAttribute("nombre","lblValSepaMile" );
      ((Element)v.get(416)).setAttribute("ancho","150" );
      ((Element)v.get(416)).setAttribute("alto","13" );
      ((Element)v.get(416)).setAttribute("filas","1" );
      ((Element)v.get(416)).setAttribute("id","datosTitle" );
      ((Element)v.get(416)).setAttribute("cod","SegPais.valSepaMile.label" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */
      /* Termina nodo:414   */

      /* Empieza nodo:417 / Elemento padre: 413   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(417)).setAttribute("nombre","valSepaMileWidgetTrId" );
      ((Element)v.get(413)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(418)).setAttribute("align","left" );
      ((Element)v.get(418)).setAttribute("nowrap","true" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(419)).setAttribute("nombre","valSepaMile" );
      ((Element)v.get(419)).setAttribute("id","datosCampos" );
      ((Element)v.get(419)).setAttribute("multiple","N" );
      ((Element)v.get(419)).setAttribute("req","N" );
      ((Element)v.get(419)).setAttribute("size","1" );
      ((Element)v.get(419)).setAttribute("validacion","" );
      ((Element)v.get(419)).setAttribute("onchange","" );
      ((Element)v.get(419)).setAttribute("onfocus","" );
      ((Element)v.get(419)).setAttribute("valorinicial","" );
      ((Element)v.get(419)).setAttribute("textoinicial","" );
      ((Element)v.get(419)).setAttribute("disabled","" );
      ((Element)v.get(419)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',22, true)" );
      ((Element)v.get(419)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',22, false)" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(419)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(421)).setAttribute("ID","," );
      ((Element)v.get(420)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(422)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(422)).setAttribute("TIPO","STRING" );
      ((Element)v.get(422)).setAttribute("VALOR","," );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */

      /* Empieza nodo:423 / Elemento padre: 421   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(423)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(423)).setAttribute("TIPO","STRING" );
      ((Element)v.get(423)).setAttribute("VALOR","," );
      ((Element)v.get(421)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:421   */

      /* Empieza nodo:424 / Elemento padre: 420   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(424)).setAttribute("ID","." );
      ((Element)v.get(420)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(425)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(425)).setAttribute("TIPO","STRING" );
      ((Element)v.get(425)).setAttribute("VALOR","." );
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */

      /* Empieza nodo:426 / Elemento padre: 424   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(426)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(426)).setAttribute("TIPO","STRING" );
      ((Element)v.get(426)).setAttribute("VALOR","." );
      ((Element)v.get(424)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:424   */
      /* Termina nodo:420   */
      /* Termina nodo:419   */
      /* Termina nodo:418   */
      /* Termina nodo:417   */
      /* Termina nodo:413   */
      /* Termina nodo:412   */

      /* Empieza nodo:427 / Elemento padre: 381   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(427)).setAttribute("nombre","valSepaMileGapTdId" );
      ((Element)v.get(427)).setAttribute("nowrap","true" );
      ((Element)v.get(427)).setAttribute("class","datosCampos" );
      ((Element)v.get(381)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(428)).setAttribute("src","b.gif" );
      ((Element)v.get(428)).setAttribute("width","25" );
      ((Element)v.get(428)).setAttribute("height","8" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */

      /* Empieza nodo:429 / Elemento padre: 381   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(429)).setAttribute("nombre","valSepaDeciTdId" );
      ((Element)v.get(381)).appendChild((Element)v.get(429));

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
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(432)).setAttribute("valign","top" );
      ((Element)v.get(432)).setAttribute("height","13" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(433)).setAttribute("nombre","lblValSepaDeci" );
      ((Element)v.get(433)).setAttribute("ancho","150" );
      ((Element)v.get(433)).setAttribute("alto","13" );
      ((Element)v.get(433)).setAttribute("filas","1" );
      ((Element)v.get(433)).setAttribute("id","datosTitle" );
      ((Element)v.get(433)).setAttribute("cod","SegPais.valSepaDeci.label" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:432   */
      /* Termina nodo:431   */

      /* Empieza nodo:434 / Elemento padre: 430   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(434)).setAttribute("nombre","valSepaDeciWidgetTrId" );
      ((Element)v.get(430)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(435)).setAttribute("align","left" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(435)).setAttribute("nowrap","true" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(436)).setAttribute("nombre","valSepaDeci" );
      ((Element)v.get(436)).setAttribute("id","datosCampos" );
      ((Element)v.get(436)).setAttribute("multiple","N" );
      ((Element)v.get(436)).setAttribute("req","N" );
      ((Element)v.get(436)).setAttribute("size","1" );
      ((Element)v.get(436)).setAttribute("validacion","" );
      ((Element)v.get(436)).setAttribute("onchange","" );
      ((Element)v.get(436)).setAttribute("onfocus","" );
      ((Element)v.get(436)).setAttribute("valorinicial","" );
      ((Element)v.get(436)).setAttribute("textoinicial","" );
      ((Element)v.get(436)).setAttribute("disabled","" );
      ((Element)v.get(436)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',23, true)" );
      ((Element)v.get(436)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',23, false)" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(438)).setAttribute("ID","," );
      ((Element)v.get(437)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(439)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(439)).setAttribute("TIPO","STRING" );
      ((Element)v.get(439)).setAttribute("VALOR","," );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */

      /* Empieza nodo:440 / Elemento padre: 438   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(440)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(440)).setAttribute("TIPO","STRING" );
      ((Element)v.get(440)).setAttribute("VALOR","," );
      ((Element)v.get(438)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:438   */

      /* Empieza nodo:441 / Elemento padre: 437   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(441)).setAttribute("ID","." );
      ((Element)v.get(437)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(442)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(442)).setAttribute("TIPO","STRING" );
      ((Element)v.get(442)).setAttribute("VALOR","." );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */

      /* Empieza nodo:443 / Elemento padre: 441   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(443)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(443)).setAttribute("TIPO","STRING" );
      ((Element)v.get(443)).setAttribute("VALOR","." );
      ((Element)v.get(441)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:441   */
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:435   */
      /* Termina nodo:434   */
      /* Termina nodo:430   */
      /* Termina nodo:429   */

      /* Empieza nodo:444 / Elemento padre: 381   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(444)).setAttribute("nombre","valSepaDeciGapTdId" );
      ((Element)v.get(444)).setAttribute("nowrap","true" );
      ((Element)v.get(444)).setAttribute("class","datosCampos" );
      ((Element)v.get(381)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(445)).setAttribute("src","b.gif" );
      ((Element)v.get(445)).setAttribute("width","25" );
      ((Element)v.get(445)).setAttribute("height","8" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:444   */

      /* Empieza nodo:446 / Elemento padre: 381   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(446)).setAttribute("nombre","numPeriEgreTdId" );
      ((Element)v.get(381)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(447)).setAttribute("width","100%" );
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
      ((Element)v.get(450)).setAttribute("nombre","lblNumPeriEgre" );
      ((Element)v.get(450)).setAttribute("alto","13" );
      ((Element)v.get(450)).setAttribute("filas","1" );
      ((Element)v.get(450)).setAttribute("id","datosTitle" );
      ((Element)v.get(450)).setAttribute("cod","SegPais.numPeriEgre.label" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:449   */
      /* Termina nodo:448   */

      /* Empieza nodo:451 / Elemento padre: 447   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(451)).setAttribute("nombre","numPeriEgreWidgetTrId" );
      ((Element)v.get(447)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(452)).setAttribute("align","left" );
      ((Element)v.get(452)).setAttribute("nowrap","true" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(453)).setAttribute("nombre","numPeriEgre" );
      ((Element)v.get(453)).setAttribute("id","datosCampos" );
      ((Element)v.get(453)).setAttribute("trim","S" );
      ((Element)v.get(453)).setAttribute("max","2" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(453)).setAttribute("onchange","" );
      ((Element)v.get(453)).setAttribute("req","N" );
      ((Element)v.get(453)).setAttribute("size","2" );
      ((Element)v.get(453)).setAttribute("valor","" );
      ((Element)v.get(453)).setAttribute("validacion","" );
      ((Element)v.get(453)).setAttribute("disabled","" );
      ((Element)v.get(453)).setAttribute("onblur","" );
      ((Element)v.get(453)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',24, true)" );
      ((Element)v.get(453)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 24, false)" );
      ((Element)v.get(452)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */
      /* Termina nodo:452   */
      /* Termina nodo:451   */
      /* Termina nodo:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:454 / Elemento padre: 381   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(454)).setAttribute("nombre","numPeriEgreGapTdId" );
      ((Element)v.get(454)).setAttribute("nowrap","true" );
      ((Element)v.get(454)).setAttribute("class","datosCampos" );
      ((Element)v.get(381)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(455)).setAttribute("src","b.gif" );
      ((Element)v.get(455)).setAttribute("width","25" );
      ((Element)v.get(455)).setAttribute("height","8" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:454   */

      /* Empieza nodo:456 / Elemento padre: 381   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(456)).setAttribute("width","100%" );
      ((Element)v.get(381)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(457)).setAttribute("src","b.gif" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */
      /* Termina nodo:456   */
      /* Termina nodo:381   */
      /* Termina nodo:380   */
      /* Termina nodo:379   */
      /* Termina nodo:376   */

      /* Empieza nodo:458 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(458)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(59)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(459)).setAttribute("align","center" );
      ((Element)v.get(459)).setAttribute("width","8" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(460)).setAttribute("src","b.gif" );
      ((Element)v.get(460)).setAttribute("width","12" );
      ((Element)v.get(460)).setAttribute("height","8" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */
      /* Termina nodo:459   */

      /* Empieza nodo:461 / Elemento padre: 458   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(458)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(462)).setAttribute("src","b.gif" );
      ((Element)v.get(462)).setAttribute("width","8" );
      ((Element)v.get(462)).setAttribute("height","8" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */
      /* Termina nodo:461   */

      /* Empieza nodo:463 / Elemento padre: 458   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(463)).setAttribute("align","center" );
      ((Element)v.get(463)).setAttribute("width","8" );
      ((Element)v.get(458)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(464)).setAttribute("src","b.gif" );
      ((Element)v.get(464)).setAttribute("width","12" );
      ((Element)v.get(464)).setAttribute("height","8" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */
      /* Termina nodo:463   */
      /* Termina nodo:458   */

      /* Empieza nodo:465 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(465)).setAttribute("nombre","formTr6" );
      ((Element)v.get(59)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(466)).setAttribute("align","center" );
      ((Element)v.get(466)).setAttribute("width","8" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(467)).setAttribute("src","b.gif" );
      ((Element)v.get(467)).setAttribute("width","8" );
      ((Element)v.get(467)).setAttribute("height","12" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:466   */

      /* Empieza nodo:468 / Elemento padre: 465   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(468)).setAttribute("width","100%" );
      ((Element)v.get(465)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(469)).setAttribute("width","100%" );
      ((Element)v.get(469)).setAttribute("border","0" );
      ((Element)v.get(469)).setAttribute("cellspacing","0" );
      ((Element)v.get(469)).setAttribute("cellpadding","0" );
      ((Element)v.get(469)).setAttribute("align","left" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(470)).setAttribute("align","left" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(471)).setAttribute("nombre","numPeriRetiTdId" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(472)).setAttribute("width","100%" );
      ((Element)v.get(472)).setAttribute("border","0" );
      ((Element)v.get(472)).setAttribute("cellspacing","0" );
      ((Element)v.get(472)).setAttribute("cellpadding","0" );
      ((Element)v.get(472)).setAttribute("align","left" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("TR"));
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(472)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(474)).setAttribute("valign","top" );
      ((Element)v.get(474)).setAttribute("height","13" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(475)).setAttribute("nombre","lblNumPeriReti" );
      ((Element)v.get(475)).setAttribute("alto","13" );
      ((Element)v.get(475)).setAttribute("filas","1" );
      ((Element)v.get(475)).setAttribute("id","datosTitle" );
      ((Element)v.get(475)).setAttribute("cod","SegPais.numPeriReti.label" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */
      /* Termina nodo:474   */
      /* Termina nodo:473   */

      /* Empieza nodo:476 / Elemento padre: 472   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(476)).setAttribute("nombre","numPeriRetiWidgetTrId" );
      ((Element)v.get(472)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(477)).setAttribute("align","left" );
      ((Element)v.get(477)).setAttribute("nowrap","true" );
      ((Element)v.get(476)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(478)).setAttribute("nombre","numPeriReti" );
      ((Element)v.get(478)).setAttribute("id","datosCampos" );
      ((Element)v.get(478)).setAttribute("trim","S" );
      ((Element)v.get(478)).setAttribute("max","2" );
      ((Element)v.get(478)).setAttribute("onchange","" );
      ((Element)v.get(478)).setAttribute("req","N" );
      ((Element)v.get(478)).setAttribute("size","2" );
      ((Element)v.get(478)).setAttribute("valor","" );
      ((Element)v.get(478)).setAttribute("validacion","" );
      ((Element)v.get(478)).setAttribute("disabled","" );
      ((Element)v.get(478)).setAttribute("onblur","" );
      ((Element)v.get(478)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',25, true)" );
      ((Element)v.get(478)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 25, false)" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */
      /* Termina nodo:477   */
      /* Termina nodo:476   */
      /* Termina nodo:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:479 / Elemento padre: 470   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(479)).setAttribute("nombre","numPeriRetiGapTdId" );
      ((Element)v.get(479)).setAttribute("nowrap","true" );
      ((Element)v.get(479)).setAttribute("class","datosCampos" );
      ((Element)v.get(470)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(480)).setAttribute("src","b.gif" );
      ((Element)v.get(480)).setAttribute("width","25" );
      ((Element)v.get(480)).setAttribute("height","8" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:479   */

      /* Empieza nodo:481 / Elemento padre: 470   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(481)).setAttribute("nombre","fopaOidFormPagoTdId" );
      ((Element)v.get(470)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(482)).setAttribute("border","0" );
      ((Element)v.get(482)).setAttribute("cellspacing","0" );
      ((Element)v.get(482)).setAttribute("cellpadding","0" );
      ((Element)v.get(482)).setAttribute("align","left" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(482)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(484)).setAttribute("valign","top" );
      ((Element)v.get(484)).setAttribute("height","13" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(485)).setAttribute("nombre","lblfopaOidFormPago" );
      ((Element)v.get(485)).setAttribute("id","datosTitle" );
      ((Element)v.get(485)).setAttribute("ancho","150" );
      ((Element)v.get(485)).setAttribute("alto","13" );
      ((Element)v.get(485)).setAttribute("cod","SegPais.fopaOidFormPago.label" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */
      /* Termina nodo:484   */
      /* Termina nodo:483   */

      /* Empieza nodo:486 / Elemento padre: 482   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(486)).setAttribute("nombre","fopaOidFormPagoWidgetTrId" );
      ((Element)v.get(482)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(487)).setAttribute("align","left" );
      ((Element)v.get(487)).setAttribute("nowrap","true" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(488)).setAttribute("nombre","fopaOidFormPago" );
      ((Element)v.get(488)).setAttribute("id","datosCampos" );
      ((Element)v.get(488)).setAttribute("multiple","N" );
      ((Element)v.get(488)).setAttribute("req","N" );
      ((Element)v.get(488)).setAttribute("size","1" );
      ((Element)v.get(488)).setAttribute("disabled","" );
      ((Element)v.get(488)).setAttribute("validacion","" );
      ((Element)v.get(488)).setAttribute("onchange","" );
      ((Element)v.get(488)).setAttribute("onfocus","" );
      ((Element)v.get(488)).setAttribute("valorinicial","" );
      ((Element)v.get(488)).setAttribute("textoinicial","" );
      ((Element)v.get(488)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',26, true);" );
      ((Element)v.get(488)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',26, false);" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(488)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:488   */
      /* Termina nodo:487   */
      /* Termina nodo:486   */
      /* Termina nodo:482   */
      /* Termina nodo:481   */

      /* Empieza nodo:490 / Elemento padre: 470   */
   }

   private void getXML2340(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(490)).setAttribute("nombre","fopaOidFormPagoGapTdId" );
      ((Element)v.get(490)).setAttribute("nowrap","true" );
      ((Element)v.get(490)).setAttribute("class","datosCampos" );
      ((Element)v.get(470)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(491)).setAttribute("src","b.gif" );
      ((Element)v.get(491)).setAttribute("width","25" );
      ((Element)v.get(491)).setAttribute("height","8" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */

      /* Empieza nodo:492 / Elemento padre: 470   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(492)).setAttribute("nombre","valCompTeleTdId" );
      ((Element)v.get(470)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(493)).setAttribute("width","100%" );
      ((Element)v.get(493)).setAttribute("border","0" );
      ((Element)v.get(493)).setAttribute("cellspacing","0" );
      ((Element)v.get(493)).setAttribute("cellpadding","0" );
      ((Element)v.get(493)).setAttribute("align","left" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(493)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(495)).setAttribute("valign","top" );
      ((Element)v.get(495)).setAttribute("height","13" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(496)).setAttribute("nombre","lblValCompTele" );
      ((Element)v.get(496)).setAttribute("alto","13" );
      ((Element)v.get(496)).setAttribute("filas","1" );
      ((Element)v.get(496)).setAttribute("id","datosTitle" );
      ((Element)v.get(496)).setAttribute("cod","SegPais.valCompTele.label" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */
      /* Termina nodo:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:497 / Elemento padre: 493   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(497)).setAttribute("nombre","valCompTeleWidgetTrId" );
      ((Element)v.get(493)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(498)).setAttribute("align","left" );
      ((Element)v.get(498)).setAttribute("nowrap","true" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(499)).setAttribute("nombre","valCompTele" );
      ((Element)v.get(499)).setAttribute("id","datosCampos" );
      ((Element)v.get(499)).setAttribute("trim","S" );
      ((Element)v.get(499)).setAttribute("max","40" );
      ((Element)v.get(499)).setAttribute("onchange","" );
      ((Element)v.get(499)).setAttribute("req","N" );
      ((Element)v.get(499)).setAttribute("size","40" );
      ((Element)v.get(499)).setAttribute("valor","" );
      ((Element)v.get(499)).setAttribute("validacion","" );
      ((Element)v.get(499)).setAttribute("disabled","" );
      ((Element)v.get(499)).setAttribute("onblur","" );
      ((Element)v.get(499)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',27, true)" );
      ((Element)v.get(499)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 27, false)" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */
      /* Termina nodo:498   */
      /* Termina nodo:497   */
      /* Termina nodo:493   */
      /* Termina nodo:492   */

      /* Empieza nodo:500 / Elemento padre: 470   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(500)).setAttribute("nombre","valCompTeleGapTdId" );
      ((Element)v.get(500)).setAttribute("nowrap","true" );
      ((Element)v.get(500)).setAttribute("class","datosCampos" );
      ((Element)v.get(470)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(501)).setAttribute("src","b.gif" );
      ((Element)v.get(501)).setAttribute("width","25" );
      ((Element)v.get(501)).setAttribute("height","8" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */
      /* Termina nodo:500   */

      /* Empieza nodo:502 / Elemento padre: 470   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(502)).setAttribute("width","100%" );
      ((Element)v.get(470)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(503)).setAttribute("src","b.gif" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */
      /* Termina nodo:470   */
      /* Termina nodo:469   */
      /* Termina nodo:468   */
      /* Termina nodo:465   */

      /* Empieza nodo:504 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(504)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(59)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(505)).setAttribute("align","center" );
      ((Element)v.get(505)).setAttribute("width","8" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(506)).setAttribute("src","b.gif" );
      ((Element)v.get(506)).setAttribute("width","12" );
      ((Element)v.get(506)).setAttribute("height","8" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */
      /* Termina nodo:505   */

      /* Empieza nodo:507 / Elemento padre: 504   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(504)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(508)).setAttribute("src","b.gif" );
      ((Element)v.get(508)).setAttribute("width","8" );
      ((Element)v.get(508)).setAttribute("height","8" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */
      /* Termina nodo:507   */

      /* Empieza nodo:509 / Elemento padre: 504   */
   }

   private void getXML2430(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(509)).setAttribute("align","center" );
      ((Element)v.get(509)).setAttribute("width","8" );
      ((Element)v.get(504)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(510)).setAttribute("src","b.gif" );
      ((Element)v.get(510)).setAttribute("width","12" );
      ((Element)v.get(510)).setAttribute("height","8" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:509   */
      /* Termina nodo:504   */

      /* Empieza nodo:511 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(511)).setAttribute("nombre","formTr7" );
      ((Element)v.get(59)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(512)).setAttribute("align","center" );
      ((Element)v.get(512)).setAttribute("width","8" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(513)).setAttribute("src","b.gif" );
      ((Element)v.get(513)).setAttribute("width","8" );
      ((Element)v.get(513)).setAttribute("height","12" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */
      /* Termina nodo:512   */

      /* Empieza nodo:514 / Elemento padre: 511   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(514)).setAttribute("width","100%" );
      ((Element)v.get(511)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(515)).setAttribute("width","100%" );
      ((Element)v.get(515)).setAttribute("border","0" );
      ((Element)v.get(515)).setAttribute("cellspacing","0" );
      ((Element)v.get(515)).setAttribute("cellpadding","0" );
      ((Element)v.get(515)).setAttribute("align","left" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(516)).setAttribute("align","left" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(517)).setAttribute("nombre","indFletZonaUbigTdId" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(518)).setAttribute("width","100%" );
      ((Element)v.get(518)).setAttribute("border","0" );
      ((Element)v.get(518)).setAttribute("cellspacing","0" );
      ((Element)v.get(518)).setAttribute("cellpadding","0" );
      ((Element)v.get(518)).setAttribute("align","left" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(518)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(520)).setAttribute("valign","top" );
      ((Element)v.get(520)).setAttribute("height","13" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(521)).setAttribute("nombre","lblIndFletZonaUbig" );
      ((Element)v.get(521)).setAttribute("ancho","150" );
      ((Element)v.get(521)).setAttribute("alto","13" );
      ((Element)v.get(521)).setAttribute("filas","1" );
      ((Element)v.get(521)).setAttribute("id","datosTitle" );
      ((Element)v.get(521)).setAttribute("cod","SegPais.indFletZonaUbig.label" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */
      /* Termina nodo:519   */

      /* Empieza nodo:522 / Elemento padre: 518   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(522)).setAttribute("nombre","indFletZonaUbigWidgetTrId" );
      ((Element)v.get(518)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(523)).setAttribute("align","left" );
      ((Element)v.get(523)).setAttribute("nowrap","true" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(524)).setAttribute("nombre","indFletZonaUbig" );
      ((Element)v.get(524)).setAttribute("id","datosCampos" );
      ((Element)v.get(524)).setAttribute("multiple","N" );
      ((Element)v.get(524)).setAttribute("req","N" );
      ((Element)v.get(524)).setAttribute("size","1" );
      ((Element)v.get(524)).setAttribute("validacion","" );
      ((Element)v.get(524)).setAttribute("onchange","" );
      ((Element)v.get(524)).setAttribute("onfocus","" );
      ((Element)v.get(524)).setAttribute("valorinicial","" );
      ((Element)v.get(524)).setAttribute("textoinicial","" );
      ((Element)v.get(524)).setAttribute("disabled","" );
      ((Element)v.get(524)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',28, true)" );
      ((Element)v.get(524)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',28, false)" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(524)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(526)).setAttribute("ID","U" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(527)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(527)).setAttribute("TIPO","STRING" );
      ((Element)v.get(527)).setAttribute("VALOR","U" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */

      /* Empieza nodo:528 / Elemento padre: 526   */
   }

   private void getXML2520(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(528)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(528)).setAttribute("TIPO","STRING" );
      ((Element)v.get(528)).setAttribute("VALOR","Ubigeo" );
      ((Element)v.get(526)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */
      /* Termina nodo:526   */

      /* Empieza nodo:529 / Elemento padre: 525   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(529)).setAttribute("ID","Z" );
      ((Element)v.get(525)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(530)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(530)).setAttribute("TIPO","STRING" );
      ((Element)v.get(530)).setAttribute("VALOR","Z" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */

      /* Empieza nodo:531 / Elemento padre: 529   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(531)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(531)).setAttribute("TIPO","STRING" );
      ((Element)v.get(531)).setAttribute("VALOR","Zona" );
      ((Element)v.get(529)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */
      /* Termina nodo:529   */
      /* Termina nodo:525   */
      /* Termina nodo:524   */
      /* Termina nodo:523   */
      /* Termina nodo:522   */
      /* Termina nodo:518   */
      /* Termina nodo:517   */

      /* Empieza nodo:532 / Elemento padre: 516   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(532)).setAttribute("nombre","indFletZonaUbigGapTdId" );
      ((Element)v.get(532)).setAttribute("nowrap","true" );
      ((Element)v.get(532)).setAttribute("class","datosCampos" );
      ((Element)v.get(516)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(533)).setAttribute("src","b.gif" );
      ((Element)v.get(533)).setAttribute("width","25" );
      ((Element)v.get(533)).setAttribute("height","8" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */
      /* Termina nodo:532   */

      /* Empieza nodo:534 / Elemento padre: 516   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(534)).setAttribute("nombre","valIndiSecuMoniTdId" );
      ((Element)v.get(516)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(535)).setAttribute("width","100%" );
      ((Element)v.get(535)).setAttribute("border","0" );
      ((Element)v.get(535)).setAttribute("cellspacing","0" );
      ((Element)v.get(535)).setAttribute("cellpadding","0" );
      ((Element)v.get(535)).setAttribute("align","left" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(535)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(537)).setAttribute("valign","top" );
      ((Element)v.get(537)).setAttribute("height","13" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(538)).setAttribute("nombre","lblValIndiSecuMoni" );
      ((Element)v.get(538)).setAttribute("alto","13" );
      ((Element)v.get(538)).setAttribute("filas","1" );
      ((Element)v.get(538)).setAttribute("id","datosTitle" );
      ((Element)v.get(538)).setAttribute("cod","SegPais.valIndiSecuMoni.label" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:537   */
      /* Termina nodo:536   */

      /* Empieza nodo:539 / Elemento padre: 535   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(539)).setAttribute("nombre","valIndiSecuMoniWidgetTrId" );
      ((Element)v.get(535)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(540)).setAttribute("align","left" );
      ((Element)v.get(540)).setAttribute("nowrap","true" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(541)).setAttribute("nombre","valIndiSecuMoni" );
      ((Element)v.get(541)).setAttribute("tipo","H" );
      ((Element)v.get(541)).setAttribute("req","N" );
      ((Element)v.get(541)).setAttribute("id","datosCampos" );
      ((Element)v.get(541)).setAttribute("valor","" );
      ((Element)v.get(541)).setAttribute("disabled","" );
      ((Element)v.get(541)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',29, true)" );
      ((Element)v.get(541)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',29, false)" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(542)).setAttribute("id","datosCampos" );
      ((Element)v.get(542)).setAttribute("valor","1" );
      ((Element)v.get(542)).setAttribute("cod","SegPais.valIndiSecuMoni.1.label" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));

      /* Elemento padre:542 / Elemento actual: 543   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(542)).appendChild((Text)v.get(543));

      /* Termina nodo Texto:543   */
      /* Termina nodo:542   */

      /* Empieza nodo:544 / Elemento padre: 541   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(544)).setAttribute("id","datosCampos" );
      ((Element)v.get(544)).setAttribute("valor","0" );
      ((Element)v.get(544)).setAttribute("cod","SegPais.valIndiSecuMoni.0.label" );
      ((Element)v.get(541)).appendChild((Element)v.get(544));

      /* Elemento padre:544 / Elemento actual: 545   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(544)).appendChild((Text)v.get(545));

      /* Termina nodo Texto:545   */
      /* Termina nodo:544   */
      /* Termina nodo:541   */
      /* Termina nodo:540   */
      /* Termina nodo:539   */
      /* Termina nodo:535   */
      /* Termina nodo:534   */

      /* Empieza nodo:546 / Elemento padre: 516   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(546)).setAttribute("nombre","valIndiSecuMoniGapTdId" );
      ((Element)v.get(546)).setAttribute("nowrap","true" );
      ((Element)v.get(546)).setAttribute("class","datosCampos" );
      ((Element)v.get(516)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(547)).setAttribute("src","b.gif" );
      ((Element)v.get(547)).setAttribute("width","25" );
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(547)).setAttribute("height","8" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:546   */

      /* Empieza nodo:548 / Elemento padre: 516   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(548)).setAttribute("nombre","indSecuTdId" );
      ((Element)v.get(516)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(549)).setAttribute("width","100%" );
      ((Element)v.get(549)).setAttribute("border","0" );
      ((Element)v.get(549)).setAttribute("cellspacing","0" );
      ((Element)v.get(549)).setAttribute("cellpadding","0" );
      ((Element)v.get(549)).setAttribute("align","left" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(549)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(551)).setAttribute("valign","top" );
      ((Element)v.get(551)).setAttribute("height","13" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(552)).setAttribute("nombre","lblIndSecu" );
      ((Element)v.get(552)).setAttribute("ancho","150" );
      ((Element)v.get(552)).setAttribute("alto","13" );
      ((Element)v.get(552)).setAttribute("filas","1" );
      ((Element)v.get(552)).setAttribute("id","datosTitle" );
      ((Element)v.get(552)).setAttribute("cod","SegPais.indSecu.label" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */
      /* Termina nodo:550   */

      /* Empieza nodo:553 / Elemento padre: 549   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(553)).setAttribute("nombre","indSecuWidgetTrId" );
      ((Element)v.get(549)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(554)).setAttribute("align","left" );
      ((Element)v.get(554)).setAttribute("nowrap","true" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(555)).setAttribute("nombre","indSecu" );
      ((Element)v.get(555)).setAttribute("id","datosCampos" );
      ((Element)v.get(555)).setAttribute("multiple","N" );
      ((Element)v.get(555)).setAttribute("req","N" );
      ((Element)v.get(555)).setAttribute("size","1" );
      ((Element)v.get(555)).setAttribute("validacion","" );
      ((Element)v.get(555)).setAttribute("onchange","" );
      ((Element)v.get(555)).setAttribute("onfocus","" );
      ((Element)v.get(555)).setAttribute("valorinicial","" );
      ((Element)v.get(555)).setAttribute("textoinicial","" );
      ((Element)v.get(555)).setAttribute("disabled","" );
      ((Element)v.get(555)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',30, true)" );
      ((Element)v.get(555)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',30, false)" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(555)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(557)).setAttribute("ID","M" );
      ((Element)v.get(556)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(558)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(558)).setAttribute("TIPO","STRING" );
      ((Element)v.get(558)).setAttribute("VALOR","M" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));
      /* Termina nodo:558   */

      /* Empieza nodo:559 / Elemento padre: 557   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(559)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(559)).setAttribute("TIPO","STRING" );
      ((Element)v.get(559)).setAttribute("VALOR","Monto" );
      ((Element)v.get(557)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:557   */

      /* Empieza nodo:560 / Elemento padre: 556   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(560)).setAttribute("ID","T" );
      ((Element)v.get(556)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(561)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(561)).setAttribute("TIPO","STRING" );
      ((Element)v.get(561)).setAttribute("VALOR","T" );
      ((Element)v.get(560)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */

      /* Empieza nodo:562 / Elemento padre: 560   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(562)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(562)).setAttribute("TIPO","STRING" );
      ((Element)v.get(562)).setAttribute("VALOR","Transporte" );
      ((Element)v.get(560)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */
      /* Termina nodo:560   */

      /* Empieza nodo:563 / Elemento padre: 556   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(563)).setAttribute("ID","I" );
      ((Element)v.get(556)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(564)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(564)).setAttribute("TIPO","STRING" );
      ((Element)v.get(564)).setAttribute("VALOR","I" );
      ((Element)v.get(563)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */

      /* Empieza nodo:565 / Elemento padre: 563   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(565)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(565)).setAttribute("TIPO","STRING" );
      ((Element)v.get(565)).setAttribute("VALOR","Inicio" );
      ((Element)v.get(563)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */
      /* Termina nodo:563   */

      /* Empieza nodo:566 / Elemento padre: 556   */
      v.add(doc.createElement("ROW"));
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(566)).setAttribute("ID","F" );
      ((Element)v.get(556)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(567)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(567)).setAttribute("TIPO","STRING" );
      ((Element)v.get(567)).setAttribute("VALOR","F" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */

      /* Empieza nodo:568 / Elemento padre: 566   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(568)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(568)).setAttribute("TIPO","STRING" );
      ((Element)v.get(568)).setAttribute("VALOR","Final" );
      ((Element)v.get(566)).appendChild((Element)v.get(568));
      /* Termina nodo:568   */
      /* Termina nodo:566   */
      /* Termina nodo:556   */
      /* Termina nodo:555   */
      /* Termina nodo:554   */
      /* Termina nodo:553   */
      /* Termina nodo:549   */
      /* Termina nodo:548   */

      /* Empieza nodo:569 / Elemento padre: 516   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(569)).setAttribute("nombre","indSecuGapTdId" );
      ((Element)v.get(569)).setAttribute("nowrap","true" );
      ((Element)v.get(569)).setAttribute("class","datosCampos" );
      ((Element)v.get(516)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(570)).setAttribute("src","b.gif" );
      ((Element)v.get(570)).setAttribute("width","25" );
      ((Element)v.get(570)).setAttribute("height","8" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */
      /* Termina nodo:569   */

      /* Empieza nodo:571 / Elemento padre: 516   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(571)).setAttribute("nombre","indBalaAreaCheqTdId" );
      ((Element)v.get(516)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(572)).setAttribute("width","100%" );
      ((Element)v.get(572)).setAttribute("border","0" );
      ((Element)v.get(572)).setAttribute("cellspacing","0" );
      ((Element)v.get(572)).setAttribute("cellpadding","0" );
      ((Element)v.get(572)).setAttribute("align","left" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(572)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(574)).setAttribute("valign","top" );
      ((Element)v.get(574)).setAttribute("height","13" );
      ((Element)v.get(573)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(575)).setAttribute("nombre","lblIndBalaAreaCheq" );
      ((Element)v.get(575)).setAttribute("ancho","150" );
      ((Element)v.get(575)).setAttribute("alto","13" );
      ((Element)v.get(575)).setAttribute("filas","1" );
      ((Element)v.get(575)).setAttribute("id","datosTitle" );
      ((Element)v.get(575)).setAttribute("cod","SegPais.indBalaAreaCheq.label" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));
      /* Termina nodo:575   */
      /* Termina nodo:574   */
      /* Termina nodo:573   */

      /* Empieza nodo:576 / Elemento padre: 572   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(576)).setAttribute("nombre","indBalaAreaCheqWidgetTrId" );
      ((Element)v.get(572)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(577)).setAttribute("align","left" );
      ((Element)v.get(577)).setAttribute("nowrap","true" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(578)).setAttribute("nombre","indBalaAreaCheq" );
      ((Element)v.get(578)).setAttribute("id","datosCampos" );
      ((Element)v.get(578)).setAttribute("multiple","N" );
      ((Element)v.get(578)).setAttribute("req","N" );
      ((Element)v.get(578)).setAttribute("size","1" );
      ((Element)v.get(578)).setAttribute("validacion","" );
      ((Element)v.get(578)).setAttribute("onchange","" );
      ((Element)v.get(578)).setAttribute("onfocus","" );
      ((Element)v.get(578)).setAttribute("valorinicial","" );
      ((Element)v.get(578)).setAttribute("textoinicial","" );
      ((Element)v.get(578)).setAttribute("disabled","" );
      ((Element)v.get(578)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',31, true)" );
      ((Element)v.get(578)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',31, false)" );
      ((Element)v.get(577)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(578)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(580)).setAttribute("ID","P" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(581)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(581)).setAttribute("TIPO","STRING" );
      ((Element)v.get(581)).setAttribute("VALOR","P" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */

      /* Empieza nodo:582 / Elemento padre: 580   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(582)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(582)).setAttribute("TIPO","STRING" );
      ((Element)v.get(582)).setAttribute("VALOR","MODELO PERU" );
      ((Element)v.get(580)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */
      /* Termina nodo:580   */

      /* Empieza nodo:583 / Elemento padre: 579   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(583)).setAttribute("ID","C" );
      ((Element)v.get(579)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(584)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(584)).setAttribute("TIPO","STRING" );
      ((Element)v.get(584)).setAttribute("VALOR","C" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(583)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */

      /* Empieza nodo:585 / Elemento padre: 583   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(585)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(585)).setAttribute("TIPO","STRING" );
      ((Element)v.get(585)).setAttribute("VALOR","MODELO COLOMBIA" );
      ((Element)v.get(583)).appendChild((Element)v.get(585));
      /* Termina nodo:585   */
      /* Termina nodo:583   */
      /* Termina nodo:579   */
      /* Termina nodo:578   */
      /* Termina nodo:577   */
      /* Termina nodo:576   */
      /* Termina nodo:572   */
      /* Termina nodo:571   */

      /* Empieza nodo:586 / Elemento padre: 516   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(586)).setAttribute("nombre","indBalaAreaCheqGapTdId" );
      ((Element)v.get(586)).setAttribute("nowrap","true" );
      ((Element)v.get(586)).setAttribute("class","datosCampos" );
      ((Element)v.get(516)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(587)).setAttribute("src","b.gif" );
      ((Element)v.get(587)).setAttribute("width","25" );
      ((Element)v.get(587)).setAttribute("height","8" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */
      /* Termina nodo:586   */

      /* Empieza nodo:588 / Elemento padre: 516   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(588)).setAttribute("width","100%" );
      ((Element)v.get(516)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(589)).setAttribute("src","b.gif" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */
      /* Termina nodo:588   */
      /* Termina nodo:516   */
      /* Termina nodo:515   */
      /* Termina nodo:514   */
      /* Termina nodo:511   */

      /* Empieza nodo:590 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(590)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(59)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(591)).setAttribute("align","center" );
      ((Element)v.get(591)).setAttribute("width","8" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(592)).setAttribute("src","b.gif" );
      ((Element)v.get(592)).setAttribute("width","12" );
      ((Element)v.get(592)).setAttribute("height","8" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */
      /* Termina nodo:591   */

      /* Empieza nodo:593 / Elemento padre: 590   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(590)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(594)).setAttribute("src","b.gif" );
      ((Element)v.get(594)).setAttribute("width","8" );
      ((Element)v.get(594)).setAttribute("height","8" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));
      /* Termina nodo:594   */
      /* Termina nodo:593   */

      /* Empieza nodo:595 / Elemento padre: 590   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(595)).setAttribute("align","center" );
      ((Element)v.get(595)).setAttribute("width","8" );
      ((Element)v.get(590)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(596)).setAttribute("src","b.gif" );
      ((Element)v.get(596)).setAttribute("width","12" );
      ((Element)v.get(596)).setAttribute("height","8" );
      ((Element)v.get(595)).appendChild((Element)v.get(596));
      /* Termina nodo:596   */
      /* Termina nodo:595   */
      /* Termina nodo:590   */

      /* Empieza nodo:597 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(597)).setAttribute("nombre","formTr8" );
      ((Element)v.get(59)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(598)).setAttribute("align","center" );
      ((Element)v.get(598)).setAttribute("width","8" );
      ((Element)v.get(597)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(599)).setAttribute("src","b.gif" );
      ((Element)v.get(599)).setAttribute("width","8" );
      ((Element)v.get(599)).setAttribute("height","12" );
      ((Element)v.get(598)).appendChild((Element)v.get(599));
      /* Termina nodo:599   */
      /* Termina nodo:598   */

      /* Empieza nodo:600 / Elemento padre: 597   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(600)).setAttribute("width","100%" );
      ((Element)v.get(597)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(601)).setAttribute("width","100%" );
      ((Element)v.get(601)).setAttribute("border","0" );
      ((Element)v.get(601)).setAttribute("cellspacing","0" );
      ((Element)v.get(601)).setAttribute("cellpadding","0" );
      ((Element)v.get(601)).setAttribute("align","left" );
      ((Element)v.get(600)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(602)).setAttribute("align","left" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(603)).setAttribute("nombre","valUrlTdId" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));

      /* Empieza nodo:604 / Elemento padre: 603   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(604)).setAttribute("width","100%" );
      ((Element)v.get(604)).setAttribute("border","0" );
      ((Element)v.get(604)).setAttribute("cellspacing","0" );
      ((Element)v.get(604)).setAttribute("cellpadding","0" );
      ((Element)v.get(604)).setAttribute("align","left" );
      ((Element)v.get(603)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(604)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(606)).setAttribute("valign","top" );
      ((Element)v.get(606)).setAttribute("height","13" );
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(605)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(607)).setAttribute("nombre","lblValUrl" );
      ((Element)v.get(607)).setAttribute("alto","13" );
      ((Element)v.get(607)).setAttribute("filas","1" );
      ((Element)v.get(607)).setAttribute("id","datosTitle" );
      ((Element)v.get(607)).setAttribute("cod","SegPais.valUrl.label" );
      ((Element)v.get(606)).appendChild((Element)v.get(607));
      /* Termina nodo:607   */
      /* Termina nodo:606   */
      /* Termina nodo:605   */

      /* Empieza nodo:608 / Elemento padre: 604   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(608)).setAttribute("nombre","valUrlWidgetTrId" );
      ((Element)v.get(604)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(609)).setAttribute("align","left" );
      ((Element)v.get(609)).setAttribute("nowrap","true" );
      ((Element)v.get(608)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(610)).setAttribute("nombre","valUrl" );
      ((Element)v.get(610)).setAttribute("valor","" );
      ((Element)v.get(610)).setAttribute("rows","3" );
      ((Element)v.get(610)).setAttribute("cols","40" );
      ((Element)v.get(610)).setAttribute("validacion","" );
      ((Element)v.get(610)).setAttribute("disabled","" );
      ((Element)v.get(610)).setAttribute("req","N" );
      ((Element)v.get(610)).setAttribute("id","datosCampos" );
      ((Element)v.get(610)).setAttribute("onblur","" );
      ((Element)v.get(610)).setAttribute("onfocus","" );
      ((Element)v.get(610)).setAttribute("onchange","" );
      ((Element)v.get(610)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',32, true)" );
      ((Element)v.get(610)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',32, false)" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));
      /* Termina nodo:610   */
      /* Termina nodo:609   */
      /* Termina nodo:608   */
      /* Termina nodo:604   */
      /* Termina nodo:603   */

      /* Empieza nodo:611 / Elemento padre: 602   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(611)).setAttribute("nombre","valUrlGapTdId" );
      ((Element)v.get(611)).setAttribute("nowrap","true" );
      ((Element)v.get(611)).setAttribute("class","datosCampos" );
      ((Element)v.get(602)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(612)).setAttribute("src","b.gif" );
      ((Element)v.get(612)).setAttribute("width","25" );
      ((Element)v.get(612)).setAttribute("height","8" );
      ((Element)v.get(611)).appendChild((Element)v.get(612));
      /* Termina nodo:612   */
      /* Termina nodo:611   */

      /* Empieza nodo:613 / Elemento padre: 602   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(613)).setAttribute("nombre","indImpuInclTdId" );
      ((Element)v.get(602)).appendChild((Element)v.get(613));

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
      ((Element)v.get(614)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(616)).setAttribute("valign","top" );
      ((Element)v.get(616)).setAttribute("height","13" );
      ((Element)v.get(615)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(617)).setAttribute("nombre","lblIndImpuIncl" );
      ((Element)v.get(617)).setAttribute("alto","13" );
      ((Element)v.get(617)).setAttribute("filas","1" );
      ((Element)v.get(617)).setAttribute("id","datosTitle" );
      ((Element)v.get(617)).setAttribute("cod","SegPais.indImpuIncl.label" );
      ((Element)v.get(616)).appendChild((Element)v.get(617));
      /* Termina nodo:617   */
      /* Termina nodo:616   */
      /* Termina nodo:615   */

      /* Empieza nodo:618 / Elemento padre: 614   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(618)).setAttribute("nombre","indImpuInclWidgetTrId" );
      ((Element)v.get(614)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(619)).setAttribute("align","left" );
      ((Element)v.get(619)).setAttribute("nowrap","true" );
      ((Element)v.get(618)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(620)).setAttribute("nombre","indImpuIncl" );
      ((Element)v.get(620)).setAttribute("tipo","H" );
      ((Element)v.get(620)).setAttribute("req","N" );
      ((Element)v.get(620)).setAttribute("id","datosCampos" );
      ((Element)v.get(620)).setAttribute("valor","" );
      ((Element)v.get(620)).setAttribute("disabled","" );
      ((Element)v.get(620)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',33, true)" );
      ((Element)v.get(620)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',33, false)" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(621)).setAttribute("id","datosCampos" );
      ((Element)v.get(621)).setAttribute("valor","1" );
      ((Element)v.get(621)).setAttribute("cod","SegPais.indImpuIncl.1.label" );
      ((Element)v.get(620)).appendChild((Element)v.get(621));

      /* Elemento padre:621 / Elemento actual: 622   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(621)).appendChild((Text)v.get(622));

      /* Termina nodo Texto:622   */
      /* Termina nodo:621   */

      /* Empieza nodo:623 / Elemento padre: 620   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(623)).setAttribute("id","datosCampos" );
      ((Element)v.get(623)).setAttribute("valor","0" );
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(623)).setAttribute("cod","SegPais.indImpuIncl.0.label" );
      ((Element)v.get(620)).appendChild((Element)v.get(623));

      /* Elemento padre:623 / Elemento actual: 624   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(623)).appendChild((Text)v.get(624));

      /* Termina nodo Texto:624   */
      /* Termina nodo:623   */
      /* Termina nodo:620   */
      /* Termina nodo:619   */
      /* Termina nodo:618   */
      /* Termina nodo:614   */
      /* Termina nodo:613   */

      /* Empieza nodo:625 / Elemento padre: 602   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(625)).setAttribute("nombre","indImpuInclGapTdId" );
      ((Element)v.get(625)).setAttribute("nowrap","true" );
      ((Element)v.get(625)).setAttribute("class","datosCampos" );
      ((Element)v.get(602)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(626)).setAttribute("src","b.gif" );
      ((Element)v.get(626)).setAttribute("width","25" );
      ((Element)v.get(626)).setAttribute("height","8" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));
      /* Termina nodo:626   */
      /* Termina nodo:625   */

      /* Empieza nodo:627 / Elemento padre: 602   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(627)).setAttribute("width","100%" );
      ((Element)v.get(602)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(628)).setAttribute("src","b.gif" );
      ((Element)v.get(627)).appendChild((Element)v.get(628));
      /* Termina nodo:628   */
      /* Termina nodo:627   */
      /* Termina nodo:602   */
      /* Termina nodo:601   */
      /* Termina nodo:600   */

      /* Empieza nodo:629 / Elemento padre: 597   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(629)).setAttribute("width","100%" );
      ((Element)v.get(597)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */
      /* Termina nodo:597   */

      /* Empieza nodo:630 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(630)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(59)).appendChild((Element)v.get(630));

      /* Empieza nodo:631 / Elemento padre: 630   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(631)).setAttribute("align","center" );
      ((Element)v.get(631)).setAttribute("width","8" );
      ((Element)v.get(630)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(632)).setAttribute("src","b.gif" );
      ((Element)v.get(632)).setAttribute("width","8" );
      ((Element)v.get(632)).setAttribute("height","8" );
      ((Element)v.get(631)).appendChild((Element)v.get(632));
      /* Termina nodo:632   */
      /* Termina nodo:631   */

      /* Empieza nodo:633 / Elemento padre: 630   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(630)).appendChild((Element)v.get(633));

      /* Empieza nodo:634 / Elemento padre: 633   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(634)).setAttribute("src","b.gif" );
      ((Element)v.get(634)).setAttribute("width","8" );
      ((Element)v.get(634)).setAttribute("height","8" );
      ((Element)v.get(633)).appendChild((Element)v.get(634));
      /* Termina nodo:634   */
      /* Termina nodo:633   */

      /* Empieza nodo:635 / Elemento padre: 630   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(635)).setAttribute("align","center" );
      ((Element)v.get(635)).setAttribute("width","8" );
      ((Element)v.get(630)).appendChild((Element)v.get(635));

      /* Empieza nodo:636 / Elemento padre: 635   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(636)).setAttribute("src","b.gif" );
      ((Element)v.get(636)).setAttribute("width","8" );
      ((Element)v.get(636)).setAttribute("height","8" );
      ((Element)v.get(635)).appendChild((Element)v.get(636));
      /* Termina nodo:636   */
      /* Termina nodo:635   */
      /* Termina nodo:630   */
      /* Termina nodo:59   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:637 / Elemento padre: 52   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(637)).setAttribute("align","center" );
      ((Element)v.get(637)).setAttribute("width","12" );
      ((Element)v.get(52)).appendChild((Element)v.get(637));

      /* Empieza nodo:638 / Elemento padre: 637   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(638)).setAttribute("src","b.gif" );
      ((Element)v.get(638)).setAttribute("width","12" );
      ((Element)v.get(638)).setAttribute("height","12" );
      ((Element)v.get(637)).appendChild((Element)v.get(638));
      /* Termina nodo:638   */
      /* Termina nodo:637   */
      /* Termina nodo:52   */

      /* Empieza nodo:639 / Elemento padre: 44   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(639)).setAttribute("nombre","segPaisTrButtons" );
      ((Element)v.get(44)).appendChild((Element)v.get(639));

      /* Empieza nodo:640 / Elemento padre: 639   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(640)).setAttribute("align","center" );
      ((Element)v.get(640)).setAttribute("width","12" );
      ((Element)v.get(639)).appendChild((Element)v.get(640));

      /* Empieza nodo:641 / Elemento padre: 640   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(641)).setAttribute("src","b.gif" );
      ((Element)v.get(641)).setAttribute("width","12" );
      ((Element)v.get(641)).setAttribute("height","12" );
      ((Element)v.get(640)).appendChild((Element)v.get(641));
      /* Termina nodo:641   */
      /* Termina nodo:640   */

      /* Empieza nodo:642 / Elemento padre: 639   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(639)).appendChild((Element)v.get(642));

      /* Empieza nodo:643 / Elemento padre: 642   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(642)).appendChild((Element)v.get(643));

      /* Empieza nodo:644 / Elemento padre: 643   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(644)).setAttribute("width","100%" );
      ((Element)v.get(644)).setAttribute("border","0" );
      ((Element)v.get(644)).setAttribute("align","center" );
      ((Element)v.get(644)).setAttribute("cellspacing","0" );
      ((Element)v.get(644)).setAttribute("cellpadding","0" );
      ((Element)v.get(643)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(644)).appendChild((Element)v.get(645));

      /* Empieza nodo:646 / Elemento padre: 645   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(646)).setAttribute("class","tablaTitle" );
      ((Element)v.get(646)).setAttribute("nombre","segPaisTdQueryButton" );
      ((Element)v.get(645)).appendChild((Element)v.get(646));

      /* Empieza nodo:647 / Elemento padre: 646   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML3060(Document doc) {
      ((Element)v.get(647)).setAttribute("nombre","segPaisQueryButton" );
      ((Element)v.get(647)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(647)).setAttribute("estado","false" );
      ((Element)v.get(647)).setAttribute("accion","segPaisFirstPage();" );
      ((Element)v.get(647)).setAttribute("tipo","html" );
      ((Element)v.get(647)).setAttribute("ID","botonContenido" );
      ((Element)v.get(646)).appendChild((Element)v.get(647));
      /* Termina nodo:647   */
      /* Termina nodo:646   */

      /* Empieza nodo:648 / Elemento padre: 645   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(648)).setAttribute("class","tablaTitle" );
      ((Element)v.get(648)).setAttribute("nombre","segPaisTdLovNullSelectionButton" );
      ((Element)v.get(648)).setAttribute("align","left" );
      ((Element)v.get(648)).setAttribute("width","100%" );
      ((Element)v.get(645)).appendChild((Element)v.get(648));

      /* Empieza nodo:649 / Elemento padre: 648   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(649)).setAttribute("src","b.gif" );
      ((Element)v.get(649)).setAttribute("height","8" );
      ((Element)v.get(649)).setAttribute("width","8" );
      ((Element)v.get(648)).appendChild((Element)v.get(649));
      /* Termina nodo:649   */

      /* Empieza nodo:650 / Elemento padre: 648   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(650)).setAttribute("nombre","segPaisLovNullButton" );
      ((Element)v.get(650)).setAttribute("ID","botonContenido" );
      ((Element)v.get(650)).setAttribute("tipo","html" );
      ((Element)v.get(650)).setAttribute("accion","segPaisLovNullSelectionAction();" );
      ((Element)v.get(650)).setAttribute("estado","true" );
      ((Element)v.get(650)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(648)).appendChild((Element)v.get(650));
      /* Termina nodo:650   */
      /* Termina nodo:648   */
      /* Termina nodo:645   */
      /* Termina nodo:644   */
      /* Termina nodo:643   */
      /* Termina nodo:642   */

      /* Empieza nodo:651 / Elemento padre: 639   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(651)).setAttribute("align","center" );
      ((Element)v.get(651)).setAttribute("width","12" );
      ((Element)v.get(639)).appendChild((Element)v.get(651));

      /* Empieza nodo:652 / Elemento padre: 651   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(652)).setAttribute("src","b.gif" );
      ((Element)v.get(652)).setAttribute("width","12" );
      ((Element)v.get(652)).setAttribute("height","12" );
      ((Element)v.get(651)).appendChild((Element)v.get(652));
      /* Termina nodo:652   */
      /* Termina nodo:651   */
      /* Termina nodo:639   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:653 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(653)).setAttribute("nombre","segPaisListLayer" );
      ((Element)v.get(653)).setAttribute("alto","310" );
      ((Element)v.get(653)).setAttribute("ancho","99%" );
      ((Element)v.get(653)).setAttribute("colorf","" );
      ((Element)v.get(653)).setAttribute("borde","0" );
      ((Element)v.get(653)).setAttribute("imagenf","" );
      ((Element)v.get(653)).setAttribute("repeat","" );
      ((Element)v.get(653)).setAttribute("padding","" );
      ((Element)v.get(653)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(653)).setAttribute("contravsb","" );
      ((Element)v.get(653)).setAttribute("x","3" );
      ((Element)v.get(653)).setAttribute("y","" );
      ((Element)v.get(653)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(653));

      /* Empieza nodo:654 / Elemento padre: 653   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(654)).setAttribute("nombre","segPaisList" );
      ((Element)v.get(654)).setAttribute("ancho","680" );
      ((Element)v.get(654)).setAttribute("alto","275" );
      ((Element)v.get(654)).setAttribute("x","12" );
      ((Element)v.get(654)).setAttribute("y","0" );
      ((Element)v.get(654)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(654)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(653)).appendChild((Element)v.get(654));

      /* Empieza nodo:655 / Elemento padre: 654   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(655)).setAttribute("precarga","S" );
      ((Element)v.get(655)).setAttribute("conROver","S" );
      ((Element)v.get(654)).appendChild((Element)v.get(655));

      /* Empieza nodo:656 / Elemento padre: 655   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(656)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(656)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(656)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(656)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(655)).appendChild((Element)v.get(656));
      /* Termina nodo:656   */

      /* Empieza nodo:657 / Elemento padre: 655   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(657)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(657)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(657)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(657)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(655)).appendChild((Element)v.get(657));
      /* Termina nodo:657   */
      /* Termina nodo:655   */

      /* Empieza nodo:658 / Elemento padre: 654   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(654)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(659)).setAttribute("borde","1" );
      ((Element)v.get(659)).setAttribute("horizDatos","1" );
      ((Element)v.get(659)).setAttribute("horizCabecera","1" );
      ((Element)v.get(659)).setAttribute("vertical","1" );
      ((Element)v.get(659)).setAttribute("horizTitulo","1" );
      ((Element)v.get(659)).setAttribute("horizBase","1" );
      ((Element)v.get(658)).appendChild((Element)v.get(659));
      /* Termina nodo:659   */

      /* Empieza nodo:660 / Elemento padre: 658   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(660)).setAttribute("borde","#999999" );
      ((Element)v.get(660)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(660)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(660)).setAttribute("horizDatos","#FFFFFF" );
   }

   private void getXML3150(Document doc) {
      ((Element)v.get(660)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(660)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(660)).setAttribute("horizBase","#999999" );
      ((Element)v.get(658)).appendChild((Element)v.get(660));
      /* Termina nodo:660   */
      /* Termina nodo:658   */

      /* Empieza nodo:661 / Elemento padre: 654   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(661)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(661)).setAttribute("alto","22" );
      ((Element)v.get(661)).setAttribute("imgFondo","" );
      ((Element)v.get(661)).setAttribute("cod","00135" );
      ((Element)v.get(661)).setAttribute("ID","datosTitle" );
      ((Element)v.get(654)).appendChild((Element)v.get(661));
      /* Termina nodo:661   */

      /* Empieza nodo:662 / Elemento padre: 654   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(662)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(662)).setAttribute("alto","22" );
      ((Element)v.get(662)).setAttribute("imgFondo","" );
      ((Element)v.get(654)).appendChild((Element)v.get(662));
      /* Termina nodo:662   */

      /* Empieza nodo:663 / Elemento padre: 654   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(663)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(663)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(663)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(663)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(663)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(654)).appendChild((Element)v.get(663));

      /* Empieza nodo:664 / Elemento padre: 663   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(664)).setAttribute("ancho","100" );
      ((Element)v.get(664)).setAttribute("minimizable","S" );
      ((Element)v.get(664)).setAttribute("minimizada","N" );
      ((Element)v.get(663)).appendChild((Element)v.get(664));
      /* Termina nodo:664   */

      /* Empieza nodo:665 / Elemento padre: 663   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(665)).setAttribute("ancho","100" );
      ((Element)v.get(665)).setAttribute("minimizable","S" );
      ((Element)v.get(665)).setAttribute("minimizada","N" );
      ((Element)v.get(663)).appendChild((Element)v.get(665));
      /* Termina nodo:665   */
      /* Termina nodo:663   */

      /* Empieza nodo:666 / Elemento padre: 654   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(666)).setAttribute("height","20" );
      ((Element)v.get(666)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(666)).setAttribute("imgFondo","" );
      ((Element)v.get(666)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(654)).appendChild((Element)v.get(666));

      /* Empieza nodo:667 / Elemento padre: 666   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(667)).setAttribute("colFondo","" );
      ((Element)v.get(667)).setAttribute("ID","EstCab" );
      ((Element)v.get(667)).setAttribute("cod","SegPais.codPais.label" );
      ((Element)v.get(666)).appendChild((Element)v.get(667));
      /* Termina nodo:667   */

      /* Empieza nodo:668 / Elemento padre: 666   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(668)).setAttribute("colFondo","" );
      ((Element)v.get(668)).setAttribute("ID","EstCab" );
      ((Element)v.get(668)).setAttribute("cod","SegPais.moneOidMone.label" );
      ((Element)v.get(666)).appendChild((Element)v.get(668));
      /* Termina nodo:668   */
      /* Termina nodo:666   */

      /* Empieza nodo:669 / Elemento padre: 654   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(669)).setAttribute("alto","22" );
      ((Element)v.get(669)).setAttribute("accion","" );
      ((Element)v.get(669)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(669)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(669)).setAttribute("maxSel","1" );
      ((Element)v.get(669)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(669)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(669)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(669)).setAttribute("onLoad","" );
      ((Element)v.get(669)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(654)).appendChild((Element)v.get(669));

      /* Empieza nodo:670 / Elemento padre: 669   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(670)).setAttribute("tipo","texto" );
      ((Element)v.get(670)).setAttribute("ID","EstDat" );
      ((Element)v.get(669)).appendChild((Element)v.get(670));
      /* Termina nodo:670   */

      /* Empieza nodo:671 / Elemento padre: 669   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(671)).setAttribute("tipo","texto" );
      ((Element)v.get(671)).setAttribute("ID","EstDat2" );
      ((Element)v.get(669)).appendChild((Element)v.get(671));
      /* Termina nodo:671   */
      /* Termina nodo:669   */

      /* Empieza nodo:672 / Elemento padre: 654   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(654)).appendChild((Element)v.get(672));
      /* Termina nodo:672   */
      /* Termina nodo:654   */
      /* Termina nodo:653   */

      /* Empieza nodo:673 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(673)).setAttribute("nombre","segPaisListButtonsLayer" );
      ((Element)v.get(673)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(673)).setAttribute("alto","30" );
      ((Element)v.get(673)).setAttribute("ancho","98%" );
      ((Element)v.get(673)).setAttribute("borde","n" );
      ((Element)v.get(673)).setAttribute("imagenf","" );
      ((Element)v.get(673)).setAttribute("repeat","" );
      ((Element)v.get(673)).setAttribute("padding","0" );
      ((Element)v.get(673)).setAttribute("contravsb","" );
      ((Element)v.get(673)).setAttribute("x","16" );
      ((Element)v.get(673)).setAttribute("y","" );
      ((Element)v.get(673)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(673));

      /* Empieza nodo:674 / Elemento padre: 673   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(674)).setAttribute("nombre","toolbarSeparatorLayer" );
      ((Element)v.get(674)).setAttribute("visibilidad","inherit" );
      ((Element)v.get(674)).setAttribute("alto","23" );
      ((Element)v.get(674)).setAttribute("ancho","1" );
   }

   private void getXML3240(Document doc) {
      ((Element)v.get(674)).setAttribute("borde","1" );
      ((Element)v.get(674)).setAttribute("imagenf","" );
      ((Element)v.get(674)).setAttribute("repeat","" );
      ((Element)v.get(674)).setAttribute("padding","0" );
      ((Element)v.get(674)).setAttribute("contravsb","" );
      ((Element)v.get(674)).setAttribute("x","56" );
      ((Element)v.get(674)).setAttribute("y","0" );
      ((Element)v.get(674)).setAttribute("zindex","" );
      ((Element)v.get(674)).setAttribute("colborde","#999999" );
      ((Element)v.get(673)).appendChild((Element)v.get(674));
      /* Termina nodo:674   */

      /* Empieza nodo:675 / Elemento padre: 673   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(675)).setAttribute("width","100%" );
      ((Element)v.get(675)).setAttribute("border","0" );
      ((Element)v.get(675)).setAttribute("cellspacing","1" );
      ((Element)v.get(675)).setAttribute("cellpadding","0" );
      ((Element)v.get(673)).appendChild((Element)v.get(675));

      /* Empieza nodo:676 / Elemento padre: 675   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(675)).appendChild((Element)v.get(676));

      /* Empieza nodo:677 / Elemento padre: 676   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(677)).setAttribute("src","b.gif" );
      ((Element)v.get(677)).setAttribute("height","22" );
      ((Element)v.get(677)).setAttribute("width","5" );
      ((Element)v.get(676)).appendChild((Element)v.get(677));
      /* Termina nodo:677   */
      /* Termina nodo:676   */

      /* Empieza nodo:678 / Elemento padre: 675   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(675)).appendChild((Element)v.get(678));

      /* Empieza nodo:679 / Elemento padre: 678   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(679)).setAttribute("nombre","segPaisPaginationButtonBar" );
      ((Element)v.get(679)).setAttribute("tipo","H" );
      ((Element)v.get(679)).setAttribute("x","0" );
      ((Element)v.get(679)).setAttribute("y","0" );
      ((Element)v.get(678)).appendChild((Element)v.get(679));

      /* Empieza nodo:680 / Elemento padre: 679   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(680)).setAttribute("nombre","segPaisFirstPageButton" );
      ((Element)v.get(680)).setAttribute("funcion","segPaisFirstPage();" );
      ((Element)v.get(680)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(680)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(680)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(680)).setAttribute("estado","inactivo" );
      ((Element)v.get(679)).appendChild((Element)v.get(680));
      /* Termina nodo:680   */

      /* Empieza nodo:681 / Elemento padre: 679   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(681)).setAttribute("nombre","segPaisFirstPageButtonGapTd" );
      ((Element)v.get(679)).appendChild((Element)v.get(681));

      /* Empieza nodo:682 / Elemento padre: 681   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(682)).setAttribute("src","b.gif" );
      ((Element)v.get(682)).setAttribute("height","8" );
      ((Element)v.get(682)).setAttribute("width","5" );
      ((Element)v.get(681)).appendChild((Element)v.get(682));
      /* Termina nodo:682   */
      /* Termina nodo:681   */

      /* Empieza nodo:683 / Elemento padre: 679   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(683)).setAttribute("nombre","segPaisPreviousPageButton" );
      ((Element)v.get(683)).setAttribute("funcion","segPaisPreviousPage();" );
      ((Element)v.get(683)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(683)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(683)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(683)).setAttribute("estado","inactivo" );
      ((Element)v.get(679)).appendChild((Element)v.get(683));
      /* Termina nodo:683   */

      /* Empieza nodo:684 / Elemento padre: 679   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(684)).setAttribute("nombre","segPaisPreviousPageButtonGapTd" );
      ((Element)v.get(679)).appendChild((Element)v.get(684));

      /* Empieza nodo:685 / Elemento padre: 684   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(685)).setAttribute("src","b.gif" );
      ((Element)v.get(685)).setAttribute("height","8" );
      ((Element)v.get(685)).setAttribute("width","8" );
      ((Element)v.get(684)).appendChild((Element)v.get(685));
      /* Termina nodo:685   */
      /* Termina nodo:684   */

      /* Empieza nodo:686 / Elemento padre: 679   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(686)).setAttribute("nombre","segPaisNextPageButton" );
      ((Element)v.get(686)).setAttribute("funcion","segPaisNextPage();" );
      ((Element)v.get(686)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(686)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(686)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(686)).setAttribute("estado","inactivo" );
      ((Element)v.get(679)).appendChild((Element)v.get(686));
      /* Termina nodo:686   */
      /* Termina nodo:679   */
      /* Termina nodo:678   */

      /* Empieza nodo:687 / Elemento padre: 675   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(675)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(688)).setAttribute("src","b.gif" );
      ((Element)v.get(688)).setAttribute("height","22" );
      ((Element)v.get(688)).setAttribute("width","19" );
      ((Element)v.get(687)).appendChild((Element)v.get(688));
      /* Termina nodo:688   */
      /* Termina nodo:687   */

      /* Empieza nodo:689 / Elemento padre: 675   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(689)).setAttribute("class","tablaTitle" );
      ((Element)v.get(689)).setAttribute("nombre","segPaisUpdateButtonTd" );
      ((Element)v.get(675)).appendChild((Element)v.get(689));

      /* Empieza nodo:690 / Elemento padre: 689   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(690)).setAttribute("nombre","segPaisUpdateButton" );
      ((Element)v.get(690)).setAttribute("ID","botonContenido" );
      ((Element)v.get(690)).setAttribute("tipo","html" );
      ((Element)v.get(690)).setAttribute("accion","segPaisUpdateSelection();" );
      ((Element)v.get(690)).setAttribute("estado","false" );
      ((Element)v.get(690)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(689)).appendChild((Element)v.get(690));
      /* Termina nodo:690   */
      /* Termina nodo:689   */

      /* Empieza nodo:691 / Elemento padre: 675   */
   }

   private void getXML3330(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(691)).setAttribute("nombre","segPaisUpdateButtonGapTd" );
      ((Element)v.get(675)).appendChild((Element)v.get(691));

      /* Empieza nodo:692 / Elemento padre: 691   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(692)).setAttribute("src","b.gif" );
      ((Element)v.get(692)).setAttribute("height","8" );
      ((Element)v.get(692)).setAttribute("width","10" );
      ((Element)v.get(691)).appendChild((Element)v.get(692));
      /* Termina nodo:692   */
      /* Termina nodo:691   */

      /* Empieza nodo:693 / Elemento padre: 675   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(693)).setAttribute("class","tablaTitle" );
      ((Element)v.get(693)).setAttribute("nombre","segPaisViewForRemoveButtonTd" );
      ((Element)v.get(675)).appendChild((Element)v.get(693));

      /* Empieza nodo:694 / Elemento padre: 693   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(694)).setAttribute("nombre","segPaisViewForRemoveButton" );
      ((Element)v.get(694)).setAttribute("ID","botonContenido" );
      ((Element)v.get(694)).setAttribute("tipo","html" );
      ((Element)v.get(694)).setAttribute("accion","segPaisViewSelection();" );
      ((Element)v.get(694)).setAttribute("estado","false" );
      ((Element)v.get(694)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(693)).appendChild((Element)v.get(694));
      /* Termina nodo:694   */
      /* Termina nodo:693   */

      /* Empieza nodo:695 / Elemento padre: 675   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(695)).setAttribute("nombre","segPaisViewForRemoveButtonGapTd" );
      ((Element)v.get(675)).appendChild((Element)v.get(695));

      /* Empieza nodo:696 / Elemento padre: 695   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(696)).setAttribute("src","b.gif" );
      ((Element)v.get(696)).setAttribute("height","8" );
      ((Element)v.get(696)).setAttribute("width","10" );
      ((Element)v.get(695)).appendChild((Element)v.get(696));
      /* Termina nodo:696   */
      /* Termina nodo:695   */

      /* Empieza nodo:697 / Elemento padre: 675   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(697)).setAttribute("class","tablaTitle" );
      ((Element)v.get(697)).setAttribute("nombre","segPaisLovSelectButtonTd" );
      ((Element)v.get(675)).appendChild((Element)v.get(697));

      /* Empieza nodo:698 / Elemento padre: 697   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(698)).setAttribute("nombre","segPaisLovSelectButton" );
      ((Element)v.get(698)).setAttribute("ID","botonContenido" );
      ((Element)v.get(698)).setAttribute("tipo","html" );
      ((Element)v.get(698)).setAttribute("accion","segPaisLovSelectionAction();" );
      ((Element)v.get(698)).setAttribute("estado","true" );
      ((Element)v.get(698)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(697)).appendChild((Element)v.get(698));
      /* Termina nodo:698   */
      /* Termina nodo:697   */

      /* Empieza nodo:699 / Elemento padre: 675   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(699)).setAttribute("nombre","segPaisLovSelectButtonGapTd" );
      ((Element)v.get(675)).appendChild((Element)v.get(699));

      /* Empieza nodo:700 / Elemento padre: 699   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(700)).setAttribute("src","b.gif" );
      ((Element)v.get(700)).setAttribute("height","8" );
      ((Element)v.get(700)).setAttribute("width","10" );
      ((Element)v.get(699)).appendChild((Element)v.get(700));
      /* Termina nodo:700   */
      /* Termina nodo:699   */

      /* Empieza nodo:701 / Elemento padre: 675   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(701)).setAttribute("class","tablaTitle" );
      ((Element)v.get(701)).setAttribute("nombre","segPaisViewButtonTd" );
      ((Element)v.get(675)).appendChild((Element)v.get(701));

      /* Empieza nodo:702 / Elemento padre: 701   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(702)).setAttribute("nombre","segPaisViewButton" );
      ((Element)v.get(702)).setAttribute("ID","botonContenido" );
      ((Element)v.get(702)).setAttribute("tipo","html" );
      ((Element)v.get(702)).setAttribute("accion","segPaisViewSelection();" );
      ((Element)v.get(702)).setAttribute("estado","false" );
      ((Element)v.get(702)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(701)).appendChild((Element)v.get(702));
      /* Termina nodo:702   */
      /* Termina nodo:701   */

      /* Empieza nodo:703 / Elemento padre: 675   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(703)).setAttribute("nombre","segPaisViewButtonGapTd" );
      ((Element)v.get(675)).appendChild((Element)v.get(703));

      /* Empieza nodo:704 / Elemento padre: 703   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(704)).setAttribute("src","b.gif" );
      ((Element)v.get(704)).setAttribute("height","8" );
      ((Element)v.get(704)).setAttribute("width","10" );
      ((Element)v.get(703)).appendChild((Element)v.get(704));
      /* Termina nodo:704   */
      /* Termina nodo:703   */

      /* Empieza nodo:705 / Elemento padre: 675   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(705)).setAttribute("width","100%" );
      ((Element)v.get(675)).appendChild((Element)v.get(705));
      /* Termina nodo:705   */
      /* Termina nodo:675   */
      /* Termina nodo:673   */
      /* Termina nodo:5   */


   }

}

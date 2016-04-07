
import org.w3c.dom.*;
import java.util.ArrayList;

public class CobEtapaDeudaPage  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","CobEtapaDeudaPage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","cobEtapaDeudaInitComponents()" );
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
      ((Element)v.get(3)).setAttribute("src","cobetapadeuda.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","cobEtapaDeudaFrm" );
      ((Element)v.get(4)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","CobEtapaDeudaLPExecution" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","ON" );
      ((Element)v.get(6)).setAttribute("valor","CobEtapaDeudaLPExecution" );
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
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","indExclCheckValue" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","indTelfCheckValue" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(38)).setAttribute("nombre","cobEtapaDeudaFormLayer" );
      ((Element)v.get(38)).setAttribute("alto","" );
      ((Element)v.get(38)).setAttribute("ancho","100%" );
      ((Element)v.get(38)).setAttribute("colorf","" );
      ((Element)v.get(38)).setAttribute("borde","0" );
      ((Element)v.get(38)).setAttribute("imagenf","" );
      ((Element)v.get(38)).setAttribute("repeat","" );
      ((Element)v.get(38)).setAttribute("padding","" );
      ((Element)v.get(38)).setAttribute("visibilidad","visible" );
      ((Element)v.get(38)).setAttribute("contravsb","" );
      ((Element)v.get(38)).setAttribute("x","0" );
      ((Element)v.get(38)).setAttribute("y","0" );
      ((Element)v.get(38)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(39)).setAttribute("width","100%" );
      ((Element)v.get(39)).setAttribute("border","0" );
      ((Element)v.get(39)).setAttribute("cellspacing","0" );
      ((Element)v.get(39)).setAttribute("cellpadding","0" );
      ((Element)v.get(39)).setAttribute("align","left" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("TD"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(41)).setAttribute("align","center" );
      ((Element)v.get(41)).setAttribute("width","12" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(42)).setAttribute("height","12" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 40   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(43)).setAttribute("align","center" );
      ((Element)v.get(43)).setAttribute("width","750" );
      ((Element)v.get(40)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","12" );
      ((Element)v.get(44)).setAttribute("height","12" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 40   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(45)).setAttribute("align","center" );
      ((Element)v.get(45)).setAttribute("width","12" );
      ((Element)v.get(40)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","12" );
      ((Element)v.get(46)).setAttribute("height","12" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:40   */

      /* Empieza nodo:47 / Elemento padre: 39   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(39)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(48)).setAttribute("align","center" );
      ((Element)v.get(48)).setAttribute("width","12" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","12" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(50)).setAttribute("width","100%" );
      ((Element)v.get(47)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(52)).setAttribute("class","legend" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(53)).setAttribute("nombre","legendLbl" );
      ((Element)v.get(53)).setAttribute("alto","13" );
      ((Element)v.get(53)).setAttribute("filas","1" );
      ((Element)v.get(53)).setAttribute("id","legend" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(53)).setAttribute("cod","CobEtapaDeuda.legend.label" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 51   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(54)).setAttribute("width","100%" );
      ((Element)v.get(54)).setAttribute("border","0" );
      ((Element)v.get(54)).setAttribute("align","center" );
      ((Element)v.get(54)).setAttribute("cellspacing","0" );
      ((Element)v.get(54)).setAttribute("cellpadding","0" );
      ((Element)v.get(51)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(56)).setAttribute("width","100%" );
      ((Element)v.get(56)).setAttribute("nowrap","true" );
      ((Element)v.get(56)).setAttribute("class","datosCampos" );
      ((Element)v.get(56)).setAttribute("colspan","3" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:58 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(58)).setAttribute("nombre","formTr0" );
      ((Element)v.get(54)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(59)).setAttribute("align","center" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","12" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 58   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(61)).setAttribute("width","100%" );
      ((Element)v.get(58)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(62)).setAttribute("width","100%" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(62)).setAttribute("border","0" );
      ((Element)v.get(62)).setAttribute("cellspacing","0" );
      ((Element)v.get(62)).setAttribute("cellpadding","0" );
      ((Element)v.get(62)).setAttribute("align","left" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(63)).setAttribute("align","left" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(64)).setAttribute("nombre","idTdId" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

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
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(67)).setAttribute("valign","top" );
      ((Element)v.get(67)).setAttribute("height","13" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(68)).setAttribute("nombre","lblId" );
      ((Element)v.get(68)).setAttribute("alto","13" );
      ((Element)v.get(68)).setAttribute("filas","1" );
      ((Element)v.get(68)).setAttribute("id","datosTitle" );
      ((Element)v.get(68)).setAttribute("cod","CobEtapaDeuda.id.label" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:69 / Elemento padre: 65   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(69)).setAttribute("nombre","idWidgetTrId" );
      ((Element)v.get(65)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(70)).setAttribute("align","left" );
      ((Element)v.get(70)).setAttribute("nowrap","true" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(71)).setAttribute("nombre","id" );
      ((Element)v.get(71)).setAttribute("id","datosCampos" );
      ((Element)v.get(71)).setAttribute("trim","S" );
      ((Element)v.get(71)).setAttribute("max","12" );
      ((Element)v.get(71)).setAttribute("onchange","" );
      ((Element)v.get(71)).setAttribute("req","N" );
      ((Element)v.get(71)).setAttribute("size","12" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(71)).setAttribute("validacion","" );
      ((Element)v.get(71)).setAttribute("disabled","" );
      ((Element)v.get(71)).setAttribute("onblur","" );
      ((Element)v.get(71)).setAttribute("ontab","ejecutarAccionFoco('cobEtapaDeudaFrm',1, true)" );
      ((Element)v.get(71)).setAttribute("onshtab","ejecutarAccionFoco('cobEtapaDeudaFrm', 1, false)" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:72 / Elemento padre: 63   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(72)).setAttribute("nombre","idGapTdId" );
      ((Element)v.get(72)).setAttribute("nowrap","true" );
      ((Element)v.get(72)).setAttribute("class","datosCampos" );
      ((Element)v.get(63)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","25" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 63   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(74)).setAttribute("width","100%" );
      ((Element)v.get(63)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:58   */

      /* Empieza nodo:76 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(76)).setAttribute("nombre","formGapTr0" );
      ((Element)v.get(54)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(77)).setAttribute("align","center" );
      ((Element)v.get(77)).setAttribute("width","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","12" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 76   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(76)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","8" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 76   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(81)).setAttribute("align","center" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","12" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:76   */

      /* Empieza nodo:83 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(83)).setAttribute("nombre","formTr1" );
      ((Element)v.get(54)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(84)).setAttribute("align","center" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","12" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 83   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(86)).setAttribute("width","100%" );
      ((Element)v.get(83)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(87)).setAttribute("width","100%" );
      ((Element)v.get(87)).setAttribute("border","0" );
      ((Element)v.get(87)).setAttribute("cellspacing","0" );
      ((Element)v.get(87)).setAttribute("cellpadding","0" );
      ((Element)v.get(87)).setAttribute("align","left" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(88)).setAttribute("align","left" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(89)).setAttribute("nombre","codEtapDeudTdId" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

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
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(92)).setAttribute("valign","top" );
      ((Element)v.get(92)).setAttribute("height","13" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(93)).setAttribute("nombre","lblCodEtapDeud" );
      ((Element)v.get(93)).setAttribute("alto","13" );
      ((Element)v.get(93)).setAttribute("filas","1" );
      ((Element)v.get(93)).setAttribute("id","datosTitle" );
      ((Element)v.get(93)).setAttribute("cod","CobEtapaDeuda.codEtapDeud.label" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:94 / Elemento padre: 90   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(94)).setAttribute("nombre","codEtapDeudWidgetTrId" );
      ((Element)v.get(90)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(95)).setAttribute("align","left" );
      ((Element)v.get(95)).setAttribute("nowrap","true" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(96)).setAttribute("nombre","codEtapDeud" );
      ((Element)v.get(96)).setAttribute("id","datosCampos" );
      ((Element)v.get(96)).setAttribute("trim","S" );
      ((Element)v.get(96)).setAttribute("max","4" );
      ((Element)v.get(96)).setAttribute("onchange","" );
      ((Element)v.get(96)).setAttribute("req","N" );
      ((Element)v.get(96)).setAttribute("size","4" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(96)).setAttribute("validacion","" );
      ((Element)v.get(96)).setAttribute("disabled","" );
      ((Element)v.get(96)).setAttribute("onblur","" );
      ((Element)v.get(96)).setAttribute("ontab","ejecutarAccionFoco('cobEtapaDeudaFrm',2, true)" );
      ((Element)v.get(96)).setAttribute("onshtab","ejecutarAccionFoco('cobEtapaDeudaFrm', 2, false)" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:97 / Elemento padre: 88   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(97)).setAttribute("nombre","codEtapDeudGapTdId" );
      ((Element)v.get(97)).setAttribute("nowrap","true" );
      ((Element)v.get(97)).setAttribute("class","datosCampos" );
      ((Element)v.get(88)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","25" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 88   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(99)).setAttribute("width","100%" );
      ((Element)v.get(88)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:83   */

      /* Empieza nodo:101 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(101)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(54)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(102)).setAttribute("align","center" );
      ((Element)v.get(102)).setAttribute("width","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","12" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 101   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(101)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","8" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 101   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(106)).setAttribute("align","center" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","12" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:101   */

      /* Empieza nodo:108 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(108)).setAttribute("nombre","formTr2" );
      ((Element)v.get(54)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(109)).setAttribute("align","center" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","8" );
      ((Element)v.get(110)).setAttribute("height","12" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 108   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(111)).setAttribute("width","100%" );
      ((Element)v.get(108)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(112)).setAttribute("width","100%" );
      ((Element)v.get(112)).setAttribute("border","0" );
      ((Element)v.get(112)).setAttribute("cellspacing","0" );
      ((Element)v.get(112)).setAttribute("cellpadding","0" );
      ((Element)v.get(112)).setAttribute("align","left" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(113)).setAttribute("align","left" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(114)).setAttribute("nombre","valDescTdId" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(115)).setAttribute("width","100%" );
      ((Element)v.get(115)).setAttribute("border","0" );
      ((Element)v.get(115)).setAttribute("cellspacing","0" );
      ((Element)v.get(115)).setAttribute("cellpadding","0" );
      ((Element)v.get(115)).setAttribute("align","left" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(117)).setAttribute("valign","top" );
      ((Element)v.get(117)).setAttribute("height","13" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(118)).setAttribute("nombre","lblValDesc" );
      ((Element)v.get(118)).setAttribute("alto","13" );
      ((Element)v.get(118)).setAttribute("filas","1" );
      ((Element)v.get(118)).setAttribute("id","datosTitle" );
      ((Element)v.get(118)).setAttribute("cod","CobEtapaDeuda.valDesc.label" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:119 / Elemento padre: 115   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(119)).setAttribute("nombre","valDescWidgetTrId" );
      ((Element)v.get(115)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(120)).setAttribute("align","left" );
      ((Element)v.get(120)).setAttribute("nowrap","true" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(121)).setAttribute("nombre","valDesc" );
      ((Element)v.get(121)).setAttribute("id","datosCampos" );
      ((Element)v.get(121)).setAttribute("trim","S" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(121)).setAttribute("max","40" );
      ((Element)v.get(121)).setAttribute("onchange","" );
      ((Element)v.get(121)).setAttribute("req","N" );
      ((Element)v.get(121)).setAttribute("size","40" );
      ((Element)v.get(121)).setAttribute("valor","" );
      ((Element)v.get(121)).setAttribute("validacion","" );
      ((Element)v.get(121)).setAttribute("disabled","" );
      ((Element)v.get(121)).setAttribute("onblur","" );
      ((Element)v.get(121)).setAttribute("ontab","ejecutarAccionFoco('cobEtapaDeudaFrm',3, true)" );
      ((Element)v.get(121)).setAttribute("onshtab","ejecutarAccionFoco('cobEtapaDeudaFrm', 3, false)" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:122 / Elemento padre: 113   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(122)).setAttribute("nombre","valDescGapTdId" );
      ((Element)v.get(122)).setAttribute("nowrap","true" );
      ((Element)v.get(122)).setAttribute("class","datosCampos" );
      ((Element)v.get(113)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","25" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 113   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(113)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:108   */

      /* Empieza nodo:126 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(126)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(54)).appendChild((Element)v.get(126));

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

      /* Empieza nodo:133 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(133)).setAttribute("nombre","formTr3" );
      ((Element)v.get(54)).appendChild((Element)v.get(133));

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
      ((Element)v.get(139)).setAttribute("nombre","indExclTdId" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(140)).setAttribute("width","100%" );
      ((Element)v.get(140)).setAttribute("border","0" );
      ((Element)v.get(140)).setAttribute("cellspacing","0" );
      ((Element)v.get(140)).setAttribute("cellpadding","0" );
      ((Element)v.get(140)).setAttribute("align","left" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(142)).setAttribute("valign","top" );
      ((Element)v.get(142)).setAttribute("height","13" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(143)).setAttribute("nombre","lblIndExcl" );
      ((Element)v.get(143)).setAttribute("alto","13" );
      ((Element)v.get(143)).setAttribute("filas","1" );
      ((Element)v.get(143)).setAttribute("id","datosTitle" );
      ((Element)v.get(143)).setAttribute("cod","CobEtapaDeuda.indExcl.label" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:144 / Elemento padre: 140   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(144)).setAttribute("nombre","indExclWidgetTrId" );
      ((Element)v.get(140)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(145)).setAttribute("align","left" );
      ((Element)v.get(145)).setAttribute("nowrap","true" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(146)).setAttribute("nombre","indExcl" );
      ((Element)v.get(146)).setAttribute("tipo","H" );
      ((Element)v.get(146)).setAttribute("req","N" );
      ((Element)v.get(146)).setAttribute("id","datosCampos" );
      ((Element)v.get(146)).setAttribute("valor","" );
      ((Element)v.get(146)).setAttribute("disabled","" );
      ((Element)v.get(146)).setAttribute("ontab","ejecutarAccionFoco('cobEtapaDeudaFrm',4, true)" );
      ((Element)v.get(146)).setAttribute("onshtab","ejecutarAccionFoco('cobEtapaDeudaFrm',4, false)" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(147)).setAttribute("id","datosCampos" );
      ((Element)v.get(147)).setAttribute("valor","1" );
      ((Element)v.get(147)).setAttribute("cod","CobEtapaDeuda.indExcl.1.label" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Elemento padre:147 / Elemento actual: 148   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(147)).appendChild((Text)v.get(148));

      /* Termina nodo Texto:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 146   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(149)).setAttribute("id","datosCampos" );
      ((Element)v.get(149)).setAttribute("valor","0" );
      ((Element)v.get(149)).setAttribute("cod","CobEtapaDeuda.indExcl.0.label" );
      ((Element)v.get(146)).appendChild((Element)v.get(149));

      /* Elemento padre:149 / Elemento actual: 150   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(149)).appendChild((Text)v.get(150));

      /* Termina nodo Texto:150   */
      /* Termina nodo:149   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:151 / Elemento padre: 138   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(151)).setAttribute("nombre","indExclGapTdId" );
      ((Element)v.get(151)).setAttribute("nowrap","true" );
      ((Element)v.get(151)).setAttribute("class","datosCampos" );
      ((Element)v.get(138)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","25" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 138   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(153)).setAttribute("width","100%" );
      ((Element)v.get(138)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:133   */

      /* Empieza nodo:155 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(155)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(54)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(156)).setAttribute("align","center" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","12" );
      ((Element)v.get(157)).setAttribute("height","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 155   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(155)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 155   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(160)).setAttribute("align","center" );
      ((Element)v.get(160)).setAttribute("width","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","12" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:155   */

      /* Empieza nodo:162 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(162)).setAttribute("nombre","formTr4" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(54)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(163)).setAttribute("align","center" );
      ((Element)v.get(163)).setAttribute("width","8" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","12" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 162   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(165)).setAttribute("width","100%" );
      ((Element)v.get(162)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(166)).setAttribute("width","100%" );
      ((Element)v.get(166)).setAttribute("border","0" );
      ((Element)v.get(166)).setAttribute("cellspacing","0" );
      ((Element)v.get(166)).setAttribute("cellpadding","0" );
      ((Element)v.get(166)).setAttribute("align","left" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(167)).setAttribute("align","left" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(168)).setAttribute("nombre","valEdadInicTdId" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(169)).setAttribute("width","100%" );
      ((Element)v.get(169)).setAttribute("border","0" );
      ((Element)v.get(169)).setAttribute("cellspacing","0" );
      ((Element)v.get(169)).setAttribute("cellpadding","0" );
      ((Element)v.get(169)).setAttribute("align","left" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(171)).setAttribute("valign","top" );
      ((Element)v.get(171)).setAttribute("height","13" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(172)).setAttribute("nombre","lblValEdadInic" );
      ((Element)v.get(172)).setAttribute("alto","13" );
      ((Element)v.get(172)).setAttribute("filas","1" );
      ((Element)v.get(172)).setAttribute("id","datosTitle" );
      ((Element)v.get(172)).setAttribute("cod","CobEtapaDeuda.valEdadInic.label" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:173 / Elemento padre: 169   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(173)).setAttribute("nombre","valEdadInicWidgetTrId" );
      ((Element)v.get(169)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(174)).setAttribute("align","left" );
      ((Element)v.get(174)).setAttribute("nowrap","true" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(175)).setAttribute("nombre","valEdadInic" );
      ((Element)v.get(175)).setAttribute("id","datosCampos" );
      ((Element)v.get(175)).setAttribute("trim","S" );
      ((Element)v.get(175)).setAttribute("max","4" );
      ((Element)v.get(175)).setAttribute("onchange","" );
      ((Element)v.get(175)).setAttribute("req","N" );
      ((Element)v.get(175)).setAttribute("size","4" );
      ((Element)v.get(175)).setAttribute("valor","" );
      ((Element)v.get(175)).setAttribute("validacion","" );
      ((Element)v.get(175)).setAttribute("disabled","" );
      ((Element)v.get(175)).setAttribute("onblur","" );
      ((Element)v.get(175)).setAttribute("ontab","ejecutarAccionFoco('cobEtapaDeudaFrm',5, true)" );
      ((Element)v.get(175)).setAttribute("onshtab","ejecutarAccionFoco('cobEtapaDeudaFrm', 5, false)" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:176 / Elemento padre: 167   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(176)).setAttribute("nombre","valEdadInicGapTdId" );
      ((Element)v.get(176)).setAttribute("nowrap","true" );
      ((Element)v.get(176)).setAttribute("class","datosCampos" );
      ((Element)v.get(167)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","25" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 167   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(178)).setAttribute("width","100%" );
      ((Element)v.get(167)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:162   */

      /* Empieza nodo:180 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(180)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(54)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(181)).setAttribute("align","center" );
      ((Element)v.get(181)).setAttribute("width","8" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","12" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 180   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(180)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 180   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(185)).setAttribute("align","center" );
      ((Element)v.get(185)).setAttribute("width","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","12" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:180   */

      /* Empieza nodo:187 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(187)).setAttribute("nombre","formTr5" );
      ((Element)v.get(54)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(188)).setAttribute("align","center" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","8" );
      ((Element)v.get(189)).setAttribute("height","12" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 187   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(190)).setAttribute("width","100%" );
      ((Element)v.get(187)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(191)).setAttribute("width","100%" );
      ((Element)v.get(191)).setAttribute("border","0" );
      ((Element)v.get(191)).setAttribute("cellspacing","0" );
      ((Element)v.get(191)).setAttribute("cellpadding","0" );
      ((Element)v.get(191)).setAttribute("align","left" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(192)).setAttribute("align","left" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(193)).setAttribute("nombre","valEdadFinaTdId" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

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
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(196)).setAttribute("valign","top" );
      ((Element)v.get(196)).setAttribute("height","13" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(197)).setAttribute("nombre","lblValEdadFina" );
      ((Element)v.get(197)).setAttribute("alto","13" );
      ((Element)v.get(197)).setAttribute("filas","1" );
      ((Element)v.get(197)).setAttribute("id","datosTitle" );
      ((Element)v.get(197)).setAttribute("cod","CobEtapaDeuda.valEdadFina.label" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:198 / Elemento padre: 194   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(198)).setAttribute("nombre","valEdadFinaWidgetTrId" );
      ((Element)v.get(194)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(199)).setAttribute("align","left" );
      ((Element)v.get(199)).setAttribute("nowrap","true" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(200)).setAttribute("nombre","valEdadFina" );
      ((Element)v.get(200)).setAttribute("id","datosCampos" );
      ((Element)v.get(200)).setAttribute("trim","S" );
      ((Element)v.get(200)).setAttribute("max","4" );
      ((Element)v.get(200)).setAttribute("onchange","" );
      ((Element)v.get(200)).setAttribute("req","N" );
      ((Element)v.get(200)).setAttribute("size","4" );
      ((Element)v.get(200)).setAttribute("valor","" );
      ((Element)v.get(200)).setAttribute("validacion","" );
      ((Element)v.get(200)).setAttribute("disabled","" );
      ((Element)v.get(200)).setAttribute("onblur","" );
      ((Element)v.get(200)).setAttribute("ontab","ejecutarAccionFoco('cobEtapaDeudaFrm',6, true)" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(200)).setAttribute("onshtab","ejecutarAccionFoco('cobEtapaDeudaFrm', 6, false)" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:201 / Elemento padre: 192   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(201)).setAttribute("nombre","valEdadFinaGapTdId" );
      ((Element)v.get(201)).setAttribute("nowrap","true" );
      ((Element)v.get(201)).setAttribute("class","datosCampos" );
      ((Element)v.get(192)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","25" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 192   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(203)).setAttribute("width","100%" );
      ((Element)v.get(192)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:187   */

      /* Empieza nodo:205 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(205)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(54)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(206)).setAttribute("align","center" );
      ((Element)v.get(206)).setAttribute("width","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","12" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 205   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(205)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 205   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(210)).setAttribute("align","center" );
      ((Element)v.get(210)).setAttribute("width","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","12" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:205   */

      /* Empieza nodo:212 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(212)).setAttribute("nombre","formTr6" );
      ((Element)v.get(54)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(213)).setAttribute("align","center" );
      ((Element)v.get(213)).setAttribute("width","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","8" );
      ((Element)v.get(214)).setAttribute("height","12" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 212   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(215)).setAttribute("width","100%" );
      ((Element)v.get(212)).appendChild((Element)v.get(215));

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
      ((Element)v.get(217)).setAttribute("align","left" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(218)).setAttribute("nombre","indTelfTdId" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

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
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(221)).setAttribute("valign","top" );
      ((Element)v.get(221)).setAttribute("height","13" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(222)).setAttribute("nombre","lblIndTelf" );
      ((Element)v.get(222)).setAttribute("alto","13" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(222)).setAttribute("filas","1" );
      ((Element)v.get(222)).setAttribute("id","datosTitle" );
      ((Element)v.get(222)).setAttribute("cod","CobEtapaDeuda.indTelf.label" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:223 / Elemento padre: 219   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(223)).setAttribute("nombre","indTelfWidgetTrId" );
      ((Element)v.get(219)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(224)).setAttribute("align","left" );
      ((Element)v.get(224)).setAttribute("nowrap","true" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(225)).setAttribute("nombre","indTelf" );
      ((Element)v.get(225)).setAttribute("tipo","H" );
      ((Element)v.get(225)).setAttribute("req","N" );
      ((Element)v.get(225)).setAttribute("id","datosCampos" );
      ((Element)v.get(225)).setAttribute("valor","" );
      ((Element)v.get(225)).setAttribute("disabled","" );
      ((Element)v.get(225)).setAttribute("ontab","ejecutarAccionFoco('cobEtapaDeudaFrm',7, true)" );
      ((Element)v.get(225)).setAttribute("onshtab","ejecutarAccionFoco('cobEtapaDeudaFrm',7, false)" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(226)).setAttribute("id","datosCampos" );
      ((Element)v.get(226)).setAttribute("valor","1" );
      ((Element)v.get(226)).setAttribute("cod","CobEtapaDeuda.indTelf.1.label" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Elemento padre:226 / Elemento actual: 227   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(226)).appendChild((Text)v.get(227));

      /* Termina nodo Texto:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 225   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(228)).setAttribute("id","datosCampos" );
      ((Element)v.get(228)).setAttribute("valor","0" );
      ((Element)v.get(228)).setAttribute("cod","CobEtapaDeuda.indTelf.0.label" );
      ((Element)v.get(225)).appendChild((Element)v.get(228));

      /* Elemento padre:228 / Elemento actual: 229   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(228)).appendChild((Text)v.get(229));

      /* Termina nodo Texto:229   */
      /* Termina nodo:228   */
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:230 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(230)).setAttribute("nombre","indTelfGapTdId" );
      ((Element)v.get(230)).setAttribute("nowrap","true" );
      ((Element)v.get(230)).setAttribute("class","datosCampos" );
      ((Element)v.get(217)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","25" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(232)).setAttribute("width","100%" );
      ((Element)v.get(217)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:212   */

      /* Empieza nodo:234 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(234)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(54)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(235)).setAttribute("align","center" );
      ((Element)v.get(235)).setAttribute("width","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(236)).setAttribute("src","b.gif" );
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

      /* Empieza nodo:241 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(241)).setAttribute("nombre","formTr7" );
      ((Element)v.get(54)).appendChild((Element)v.get(241));

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
   }

   private void getXML1080(Document doc) {
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
      ((Element)v.get(247)).setAttribute("nombre","impDesdTdId" );
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
      ((Element)v.get(251)).setAttribute("nombre","lblImpDesd" );
      ((Element)v.get(251)).setAttribute("alto","13" );
      ((Element)v.get(251)).setAttribute("filas","1" );
      ((Element)v.get(251)).setAttribute("id","datosTitle" );
      ((Element)v.get(251)).setAttribute("cod","CobEtapaDeuda.impDesd.label" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:252 / Elemento padre: 248   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(252)).setAttribute("nombre","impDesdWidgetTrId" );
      ((Element)v.get(248)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(253)).setAttribute("align","left" );
      ((Element)v.get(253)).setAttribute("nowrap","true" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(254)).setAttribute("nombre","impDesd" );
      ((Element)v.get(254)).setAttribute("id","datosCampos" );
      ((Element)v.get(254)).setAttribute("trim","S" );
      ((Element)v.get(254)).setAttribute("max","12" );
      ((Element)v.get(254)).setAttribute("onchange","" );
      ((Element)v.get(254)).setAttribute("req","N" );
      ((Element)v.get(254)).setAttribute("size","12" );
      ((Element)v.get(254)).setAttribute("valor","" );
      ((Element)v.get(254)).setAttribute("validacion","" );
      ((Element)v.get(254)).setAttribute("disabled","" );
      ((Element)v.get(254)).setAttribute("onblur","" );
      ((Element)v.get(254)).setAttribute("ontab","ejecutarAccionFoco('cobEtapaDeudaFrm',8, true)" );
      ((Element)v.get(254)).setAttribute("onshtab","ejecutarAccionFoco('cobEtapaDeudaFrm', 8, false)" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:255 / Elemento padre: 246   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(255)).setAttribute("nombre","impDesdGapTdId" );
      ((Element)v.get(255)).setAttribute("nowrap","true" );
      ((Element)v.get(255)).setAttribute("class","datosCampos" );
      ((Element)v.get(246)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","25" );
      ((Element)v.get(256)).setAttribute("height","8" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 246   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(257)).setAttribute("width","100%" );
      ((Element)v.get(246)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:241   */

      /* Empieza nodo:259 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(259)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(54)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(260)).setAttribute("align","center" );
      ((Element)v.get(260)).setAttribute("width","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).setAttribute("width","12" );
      ((Element)v.get(261)).setAttribute("height","8" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 259   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(259)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","8" );
      ((Element)v.get(263)).setAttribute("height","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 259   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(264)).setAttribute("align","center" );
      ((Element)v.get(264)).setAttribute("width","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","12" );
      ((Element)v.get(265)).setAttribute("height","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:259   */

      /* Empieza nodo:266 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(266)).setAttribute("nombre","formTr8" );
      ((Element)v.get(54)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(267)).setAttribute("align","center" );
      ((Element)v.get(267)).setAttribute("width","8" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","8" );
      ((Element)v.get(268)).setAttribute("height","12" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 266   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(269)).setAttribute("width","100%" );
      ((Element)v.get(266)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(270)).setAttribute("width","100%" );
      ((Element)v.get(270)).setAttribute("border","0" );
      ((Element)v.get(270)).setAttribute("cellspacing","0" );
      ((Element)v.get(270)).setAttribute("cellpadding","0" );
      ((Element)v.get(270)).setAttribute("align","left" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(271)).setAttribute("align","left" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(272)).setAttribute("nombre","impHastTdId" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));

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
      ((Element)v.get(276)).setAttribute("nombre","lblImpHast" );
      ((Element)v.get(276)).setAttribute("alto","13" );
      ((Element)v.get(276)).setAttribute("filas","1" );
      ((Element)v.get(276)).setAttribute("id","datosTitle" );
      ((Element)v.get(276)).setAttribute("cod","CobEtapaDeuda.impHast.label" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:277 / Elemento padre: 273   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(277)).setAttribute("nombre","impHastWidgetTrId" );
      ((Element)v.get(273)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(278)).setAttribute("align","left" );
      ((Element)v.get(278)).setAttribute("nowrap","true" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(279)).setAttribute("nombre","impHast" );
      ((Element)v.get(279)).setAttribute("id","datosCampos" );
      ((Element)v.get(279)).setAttribute("trim","S" );
      ((Element)v.get(279)).setAttribute("max","12" );
      ((Element)v.get(279)).setAttribute("onchange","" );
      ((Element)v.get(279)).setAttribute("req","N" );
      ((Element)v.get(279)).setAttribute("size","12" );
      ((Element)v.get(279)).setAttribute("valor","" );
      ((Element)v.get(279)).setAttribute("validacion","" );
      ((Element)v.get(279)).setAttribute("disabled","" );
      ((Element)v.get(279)).setAttribute("onblur","" );
      ((Element)v.get(279)).setAttribute("ontab","ejecutarAccionFoco('cobEtapaDeudaFrm',9, true)" );
      ((Element)v.get(279)).setAttribute("onshtab","ejecutarAccionFoco('cobEtapaDeudaFrm', 9, false)" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:277   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:280 / Elemento padre: 271   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(280)).setAttribute("nombre","impHastGapTdId" );
      ((Element)v.get(280)).setAttribute("nowrap","true" );
      ((Element)v.get(280)).setAttribute("class","datosCampos" );
      ((Element)v.get(271)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(281)).setAttribute("width","25" );
      ((Element)v.get(281)).setAttribute("height","8" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 271   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(282)).setAttribute("width","100%" );
      ((Element)v.get(271)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:266   */

      /* Empieza nodo:284 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(284)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(54)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(285)).setAttribute("align","center" );
      ((Element)v.get(285)).setAttribute("width","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(286)).setAttribute("src","b.gif" );
      ((Element)v.get(286)).setAttribute("width","12" );
      ((Element)v.get(286)).setAttribute("height","8" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:287 / Elemento padre: 284   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(284)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).setAttribute("width","8" );
      ((Element)v.get(288)).setAttribute("height","8" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:289 / Elemento padre: 284   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(289)).setAttribute("align","center" );
      ((Element)v.get(289)).setAttribute("width","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(290)).setAttribute("src","b.gif" );
      ((Element)v.get(290)).setAttribute("width","12" );
      ((Element)v.get(290)).setAttribute("height","8" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */
      /* Termina nodo:284   */

      /* Empieza nodo:291 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(291)).setAttribute("nombre","formTr9" );
      ((Element)v.get(54)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(292)).setAttribute("align","center" );
      ((Element)v.get(292)).setAttribute("width","8" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","8" );
      ((Element)v.get(293)).setAttribute("height","12" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 291   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(294)).setAttribute("width","100%" );
      ((Element)v.get(291)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(295)).setAttribute("width","100%" );
      ((Element)v.get(295)).setAttribute("border","0" );
      ((Element)v.get(295)).setAttribute("cellspacing","0" );
      ((Element)v.get(295)).setAttribute("cellpadding","0" );
      ((Element)v.get(295)).setAttribute("align","left" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(296)).setAttribute("align","left" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(297)).setAttribute("nombre","numDiasGracCompPagoTdId" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));

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
      ((Element)v.get(301)).setAttribute("nombre","lblNumDiasGracCompPago" );
      ((Element)v.get(301)).setAttribute("alto","13" );
      ((Element)v.get(301)).setAttribute("filas","1" );
      ((Element)v.get(301)).setAttribute("id","datosTitle" );
      ((Element)v.get(301)).setAttribute("cod","CobEtapaDeuda.numDiasGracCompPago.label" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:302 / Elemento padre: 298   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(302)).setAttribute("nombre","numDiasGracCompPagoWidgetTrId" );
      ((Element)v.get(298)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(303)).setAttribute("align","left" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(303)).setAttribute("nowrap","true" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(304)).setAttribute("nombre","numDiasGracCompPago" );
      ((Element)v.get(304)).setAttribute("id","datosCampos" );
      ((Element)v.get(304)).setAttribute("trim","S" );
      ((Element)v.get(304)).setAttribute("max","3" );
      ((Element)v.get(304)).setAttribute("onchange","" );
      ((Element)v.get(304)).setAttribute("req","N" );
      ((Element)v.get(304)).setAttribute("size","3" );
      ((Element)v.get(304)).setAttribute("valor","" );
      ((Element)v.get(304)).setAttribute("validacion","" );
      ((Element)v.get(304)).setAttribute("disabled","" );
      ((Element)v.get(304)).setAttribute("onblur","" );
      ((Element)v.get(304)).setAttribute("ontab","ejecutarAccionFoco('cobEtapaDeudaFrm',10, true)" );
      ((Element)v.get(304)).setAttribute("onshtab","ejecutarAccionFoco('cobEtapaDeudaFrm', 10, false)" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:305 / Elemento padre: 296   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(305)).setAttribute("nombre","numDiasGracCompPagoGapTdId" );
      ((Element)v.get(305)).setAttribute("nowrap","true" );
      ((Element)v.get(305)).setAttribute("class","datosCampos" );
      ((Element)v.get(296)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","25" );
      ((Element)v.get(306)).setAttribute("height","8" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 296   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(307)).setAttribute("width","100%" );
      ((Element)v.get(296)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(308)).setAttribute("src","b.gif" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:296   */
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:291   */

      /* Empieza nodo:309 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(309)).setAttribute("nombre","formGapTr9" );
      ((Element)v.get(54)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(310)).setAttribute("align","center" );
      ((Element)v.get(310)).setAttribute("width","8" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","12" );
      ((Element)v.get(311)).setAttribute("height","8" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 309   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(309)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).setAttribute("width","8" );
      ((Element)v.get(313)).setAttribute("height","8" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 309   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(314)).setAttribute("align","center" );
      ((Element)v.get(314)).setAttribute("width","8" );
      ((Element)v.get(309)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(315)).setAttribute("width","12" );
      ((Element)v.get(315)).setAttribute("height","8" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */
      /* Termina nodo:309   */

      /* Empieza nodo:316 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(316)).setAttribute("nombre","formTr10" );
      ((Element)v.get(54)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(317)).setAttribute("align","center" );
      ((Element)v.get(317)).setAttribute("width","8" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).setAttribute("width","8" );
      ((Element)v.get(318)).setAttribute("height","12" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 316   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(319)).setAttribute("width","100%" );
      ((Element)v.get(316)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(320)).setAttribute("width","100%" );
      ((Element)v.get(320)).setAttribute("border","0" );
      ((Element)v.get(320)).setAttribute("cellspacing","0" );
      ((Element)v.get(320)).setAttribute("cellpadding","0" );
      ((Element)v.get(320)).setAttribute("align","left" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(321)).setAttribute("align","left" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(322)).setAttribute("nombre","valPorcIncuTdId" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("TABLE"));
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(323)).setAttribute("width","100%" );
      ((Element)v.get(323)).setAttribute("border","0" );
      ((Element)v.get(323)).setAttribute("cellspacing","0" );
      ((Element)v.get(323)).setAttribute("cellpadding","0" );
      ((Element)v.get(323)).setAttribute("align","left" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(325)).setAttribute("valign","top" );
      ((Element)v.get(325)).setAttribute("height","13" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(326)).setAttribute("nombre","lblValPorcIncu" );
      ((Element)v.get(326)).setAttribute("alto","13" );
      ((Element)v.get(326)).setAttribute("filas","1" );
      ((Element)v.get(326)).setAttribute("id","datosTitle" );
      ((Element)v.get(326)).setAttribute("cod","CobEtapaDeuda.valPorcIncu.label" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:327 / Elemento padre: 323   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(327)).setAttribute("nombre","valPorcIncuWidgetTrId" );
      ((Element)v.get(323)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(328)).setAttribute("align","left" );
      ((Element)v.get(328)).setAttribute("nowrap","true" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(329)).setAttribute("nombre","valPorcIncu" );
      ((Element)v.get(329)).setAttribute("id","datosCampos" );
      ((Element)v.get(329)).setAttribute("trim","S" );
      ((Element)v.get(329)).setAttribute("max","5" );
      ((Element)v.get(329)).setAttribute("onchange","" );
      ((Element)v.get(329)).setAttribute("req","N" );
      ((Element)v.get(329)).setAttribute("size","5" );
      ((Element)v.get(329)).setAttribute("valor","" );
      ((Element)v.get(329)).setAttribute("validacion","" );
      ((Element)v.get(329)).setAttribute("disabled","" );
      ((Element)v.get(329)).setAttribute("onblur","" );
      ((Element)v.get(329)).setAttribute("ontab","ejecutarAccionFoco('cobEtapaDeudaFrm',11, true)" );
      ((Element)v.get(329)).setAttribute("onshtab","ejecutarAccionFoco('cobEtapaDeudaFrm', 11, false)" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */
      /* Termina nodo:327   */
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:330 / Elemento padre: 321   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(330)).setAttribute("nombre","valPorcIncuGapTdId" );
      ((Element)v.get(330)).setAttribute("nowrap","true" );
      ((Element)v.get(330)).setAttribute("class","datosCampos" );
      ((Element)v.get(321)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","25" );
      ((Element)v.get(331)).setAttribute("height","8" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 321   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(332)).setAttribute("width","100%" );
      ((Element)v.get(321)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(333)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:316   */

      /* Empieza nodo:334 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(334)).setAttribute("nombre","formGapTr10" );
      ((Element)v.get(54)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(335)).setAttribute("align","center" );
      ((Element)v.get(335)).setAttribute("width","8" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","12" );
      ((Element)v.get(336)).setAttribute("height","8" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 334   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(334)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","8" );
      ((Element)v.get(338)).setAttribute("height","8" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 334   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(339)).setAttribute("align","center" );
      ((Element)v.get(339)).setAttribute("width","8" );
      ((Element)v.get(334)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","12" );
      ((Element)v.get(340)).setAttribute("height","8" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:334   */

      /* Empieza nodo:341 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(341)).setAttribute("nombre","formTr11" );
      ((Element)v.get(54)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(342)).setAttribute("align","center" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(342)).setAttribute("width","8" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).setAttribute("width","8" );
      ((Element)v.get(343)).setAttribute("height","12" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 341   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(344)).setAttribute("width","100%" );
      ((Element)v.get(341)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(345)).setAttribute("width","100%" );
      ((Element)v.get(345)).setAttribute("border","0" );
      ((Element)v.get(345)).setAttribute("cellspacing","0" );
      ((Element)v.get(345)).setAttribute("cellpadding","0" );
      ((Element)v.get(345)).setAttribute("align","left" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(346)).setAttribute("align","left" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(347)).setAttribute("nombre","mensOidMensTdId" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(348)).setAttribute("border","0" );
      ((Element)v.get(348)).setAttribute("cellspacing","0" );
      ((Element)v.get(348)).setAttribute("cellpadding","0" );
      ((Element)v.get(348)).setAttribute("align","left" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(350)).setAttribute("valign","top" );
      ((Element)v.get(350)).setAttribute("height","13" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(351)).setAttribute("nombre","lblmensOidMens" );
      ((Element)v.get(351)).setAttribute("id","datosTitle" );
      ((Element)v.get(351)).setAttribute("ancho","150" );
      ((Element)v.get(351)).setAttribute("alto","13" );
      ((Element)v.get(351)).setAttribute("cod","CobEtapaDeuda.mensOidMens.label" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:352 / Elemento padre: 348   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(352)).setAttribute("nombre","mensOidMensWidgetTrId" );
      ((Element)v.get(348)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(353)).setAttribute("align","left" );
      ((Element)v.get(353)).setAttribute("nowrap","true" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(354)).setAttribute("nombre","mensOidMens" );
      ((Element)v.get(354)).setAttribute("id","datosCampos" );
      ((Element)v.get(354)).setAttribute("multiple","N" );
      ((Element)v.get(354)).setAttribute("req","N" );
      ((Element)v.get(354)).setAttribute("size","1" );
      ((Element)v.get(354)).setAttribute("disabled","" );
      ((Element)v.get(354)).setAttribute("validacion","" );
      ((Element)v.get(354)).setAttribute("onchange","" );
      ((Element)v.get(354)).setAttribute("onfocus","" );
      ((Element)v.get(354)).setAttribute("valorinicial","" );
      ((Element)v.get(354)).setAttribute("textoinicial","" );
      ((Element)v.get(354)).setAttribute("ontab","ejecutarAccionFoco('cobEtapaDeudaFrm',12, true);" );
      ((Element)v.get(354)).setAttribute("onshtab","ejecutarAccionFoco('cobEtapaDeudaFrm',12, false);" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:353   */
      /* Termina nodo:352   */
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:356 / Elemento padre: 346   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(356)).setAttribute("nombre","mensOidMensGapTdId" );
      ((Element)v.get(356)).setAttribute("nowrap","true" );
      ((Element)v.get(356)).setAttribute("class","datosCampos" );
      ((Element)v.get(346)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).setAttribute("width","25" );
      ((Element)v.get(357)).setAttribute("height","8" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 346   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(358)).setAttribute("width","100%" );
      ((Element)v.get(346)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(359)).setAttribute("src","b.gif" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */
      /* Termina nodo:346   */
      /* Termina nodo:345   */
      /* Termina nodo:344   */
      /* Termina nodo:341   */

      /* Empieza nodo:360 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(360)).setAttribute("nombre","formGapTr11" );
      ((Element)v.get(54)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(361)).setAttribute("align","center" );
      ((Element)v.get(361)).setAttribute("width","8" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(362)).setAttribute("width","12" );
      ((Element)v.get(362)).setAttribute("height","8" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */

      /* Empieza nodo:363 / Elemento padre: 360   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(360)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(364)).setAttribute("src","b.gif" );
      ((Element)v.get(364)).setAttribute("width","8" );
      ((Element)v.get(364)).setAttribute("height","8" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */

      /* Empieza nodo:365 / Elemento padre: 360   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(365)).setAttribute("align","center" );
      ((Element)v.get(365)).setAttribute("width","8" );
      ((Element)v.get(360)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(366)).setAttribute("src","b.gif" );
      ((Element)v.get(366)).setAttribute("width","12" );
      ((Element)v.get(366)).setAttribute("height","8" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */
      /* Termina nodo:360   */

      /* Empieza nodo:367 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(367)).setAttribute("nombre","formTr12" );
      ((Element)v.get(54)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(368)).setAttribute("align","center" );
      ((Element)v.get(368)).setAttribute("width","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).setAttribute("width","8" );
      ((Element)v.get(369)).setAttribute("height","12" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 367   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(370)).setAttribute("width","100%" );
      ((Element)v.get(367)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(371)).setAttribute("width","100%" );
      ((Element)v.get(371)).setAttribute("border","0" );
      ((Element)v.get(371)).setAttribute("cellspacing","0" );
      ((Element)v.get(371)).setAttribute("cellpadding","0" );
      ((Element)v.get(371)).setAttribute("align","left" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(372)).setAttribute("align","left" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(373)).setAttribute("nombre","melcOidMetoLiquCobrTdId" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(374)).setAttribute("border","0" );
      ((Element)v.get(374)).setAttribute("cellspacing","0" );
      ((Element)v.get(374)).setAttribute("cellpadding","0" );
      ((Element)v.get(374)).setAttribute("align","left" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(374)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(376)).setAttribute("valign","top" );
      ((Element)v.get(376)).setAttribute("height","13" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(377)).setAttribute("nombre","lblmelcOidMetoLiquCobr" );
      ((Element)v.get(377)).setAttribute("id","datosTitle" );
      ((Element)v.get(377)).setAttribute("ancho","150" );
      ((Element)v.get(377)).setAttribute("alto","13" );
      ((Element)v.get(377)).setAttribute("cod","CobEtapaDeuda.melcOidMetoLiquCobr.label" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:378 / Elemento padre: 374   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(378)).setAttribute("nombre","melcOidMetoLiquCobrWidgetTrId" );
      ((Element)v.get(374)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(379)).setAttribute("align","left" );
      ((Element)v.get(379)).setAttribute("nowrap","true" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(380)).setAttribute("nombre","melcOidMetoLiquCobr" );
      ((Element)v.get(380)).setAttribute("id","datosCampos" );
      ((Element)v.get(380)).setAttribute("multiple","N" );
      ((Element)v.get(380)).setAttribute("req","N" );
      ((Element)v.get(380)).setAttribute("size","1" );
      ((Element)v.get(380)).setAttribute("disabled","" );
      ((Element)v.get(380)).setAttribute("validacion","" );
      ((Element)v.get(380)).setAttribute("onchange","" );
      ((Element)v.get(380)).setAttribute("onfocus","" );
      ((Element)v.get(380)).setAttribute("valorinicial","" );
      ((Element)v.get(380)).setAttribute("textoinicial","" );
      ((Element)v.get(380)).setAttribute("ontab","ejecutarAccionFoco('cobEtapaDeudaFrm',13, true);" );
      ((Element)v.get(380)).setAttribute("onshtab","ejecutarAccionFoco('cobEtapaDeudaFrm',13, false);" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("ROWSET"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */
      /* Termina nodo:379   */
      /* Termina nodo:378   */
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:382 / Elemento padre: 372   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(382)).setAttribute("nombre","melcOidMetoLiquCobrGapTdId" );
      ((Element)v.get(382)).setAttribute("nowrap","true" );
      ((Element)v.get(382)).setAttribute("class","datosCampos" );
      ((Element)v.get(372)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(383)).setAttribute("src","b.gif" );
      ((Element)v.get(383)).setAttribute("width","25" );
      ((Element)v.get(383)).setAttribute("height","8" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:384 / Elemento padre: 372   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(384)).setAttribute("width","100%" );
      ((Element)v.get(372)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */
      /* Termina nodo:372   */
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:367   */

      /* Empieza nodo:386 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(386)).setAttribute("nombre","formGapTr12" );
      ((Element)v.get(54)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(387)).setAttribute("align","center" );
      ((Element)v.get(387)).setAttribute("width","8" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(388)).setAttribute("src","b.gif" );
      ((Element)v.get(388)).setAttribute("width","12" );
      ((Element)v.get(388)).setAttribute("height","8" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */
      /* Termina nodo:387   */

      /* Empieza nodo:389 / Elemento padre: 386   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(386)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(390)).setAttribute("src","b.gif" );
      ((Element)v.get(390)).setAttribute("width","8" );
      ((Element)v.get(390)).setAttribute("height","8" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:389   */

      /* Empieza nodo:391 / Elemento padre: 386   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(391)).setAttribute("align","center" );
      ((Element)v.get(391)).setAttribute("width","8" );
      ((Element)v.get(386)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(392)).setAttribute("src","b.gif" );
      ((Element)v.get(392)).setAttribute("width","12" );
      ((Element)v.get(392)).setAttribute("height","8" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */
      /* Termina nodo:386   */

      /* Empieza nodo:393 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(393)).setAttribute("nombre","formTr13" );
      ((Element)v.get(54)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(394)).setAttribute("align","center" );
      ((Element)v.get(394)).setAttribute("width","8" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(395)).setAttribute("src","b.gif" );
      ((Element)v.get(395)).setAttribute("width","8" );
      ((Element)v.get(395)).setAttribute("height","12" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 393   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(396)).setAttribute("width","100%" );
      ((Element)v.get(393)).appendChild((Element)v.get(396));

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
      ((Element)v.get(398)).setAttribute("align","left" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(399)).setAttribute("nombre","tbalOidTipoBalaTdId" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(400)).setAttribute("border","0" );
      ((Element)v.get(400)).setAttribute("cellspacing","0" );
      ((Element)v.get(400)).setAttribute("cellpadding","0" );
      ((Element)v.get(400)).setAttribute("align","left" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(400)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(402)).setAttribute("valign","top" );
      ((Element)v.get(402)).setAttribute("height","13" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(403)).setAttribute("nombre","lbltbalOidTipoBala" );
      ((Element)v.get(403)).setAttribute("id","datosTitle" );
      ((Element)v.get(403)).setAttribute("ancho","150" );
      ((Element)v.get(403)).setAttribute("alto","13" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(403)).setAttribute("cod","CobEtapaDeuda.tbalOidTipoBala.label" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:402   */
      /* Termina nodo:401   */

      /* Empieza nodo:404 / Elemento padre: 400   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(404)).setAttribute("nombre","tbalOidTipoBalaWidgetTrId" );
      ((Element)v.get(400)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(405)).setAttribute("align","left" );
      ((Element)v.get(405)).setAttribute("nowrap","true" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(406)).setAttribute("nombre","tbalOidTipoBala" );
      ((Element)v.get(406)).setAttribute("id","datosCampos" );
      ((Element)v.get(406)).setAttribute("multiple","N" );
      ((Element)v.get(406)).setAttribute("req","N" );
      ((Element)v.get(406)).setAttribute("size","1" );
      ((Element)v.get(406)).setAttribute("disabled","" );
      ((Element)v.get(406)).setAttribute("validacion","" );
      ((Element)v.get(406)).setAttribute("onchange","" );
      ((Element)v.get(406)).setAttribute("onfocus","" );
      ((Element)v.get(406)).setAttribute("valorinicial","" );
      ((Element)v.get(406)).setAttribute("textoinicial","" );
      ((Element)v.get(406)).setAttribute("ontab","ejecutarAccionFoco('cobEtapaDeudaFrm',14, true);" );
      ((Element)v.get(406)).setAttribute("onshtab","ejecutarAccionFoco('cobEtapaDeudaFrm',14, false);" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */
      /* Termina nodo:405   */
      /* Termina nodo:404   */
      /* Termina nodo:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:408 / Elemento padre: 398   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(408)).setAttribute("nombre","tbalOidTipoBalaGapTdId" );
      ((Element)v.get(408)).setAttribute("nowrap","true" );
      ((Element)v.get(408)).setAttribute("class","datosCampos" );
      ((Element)v.get(398)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(409)).setAttribute("src","b.gif" );
      ((Element)v.get(409)).setAttribute("width","25" );
      ((Element)v.get(409)).setAttribute("height","8" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:408   */

      /* Empieza nodo:410 / Elemento padre: 398   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(410)).setAttribute("width","100%" );
      ((Element)v.get(398)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(411)).setAttribute("src","b.gif" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */
      /* Termina nodo:398   */
      /* Termina nodo:397   */
      /* Termina nodo:396   */
      /* Termina nodo:393   */

      /* Empieza nodo:412 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(412)).setAttribute("nombre","formGapTr13" );
      ((Element)v.get(54)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(413)).setAttribute("align","center" );
      ((Element)v.get(413)).setAttribute("width","8" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(414)).setAttribute("src","b.gif" );
      ((Element)v.get(414)).setAttribute("width","12" );
      ((Element)v.get(414)).setAttribute("height","8" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */

      /* Empieza nodo:415 / Elemento padre: 412   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(412)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(416)).setAttribute("src","b.gif" );
      ((Element)v.get(416)).setAttribute("width","8" );
      ((Element)v.get(416)).setAttribute("height","8" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:417 / Elemento padre: 412   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(417)).setAttribute("align","center" );
      ((Element)v.get(417)).setAttribute("width","8" );
      ((Element)v.get(412)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(418)).setAttribute("src","b.gif" );
      ((Element)v.get(418)).setAttribute("width","12" );
      ((Element)v.get(418)).setAttribute("height","8" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */
      /* Termina nodo:412   */

      /* Empieza nodo:419 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(419)).setAttribute("nombre","formTr14" );
      ((Element)v.get(54)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(420)).setAttribute("align","center" );
      ((Element)v.get(420)).setAttribute("width","8" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(421)).setAttribute("src","b.gif" );
      ((Element)v.get(421)).setAttribute("width","8" );
      ((Element)v.get(421)).setAttribute("height","12" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */

      /* Empieza nodo:422 / Elemento padre: 419   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(422)).setAttribute("width","100%" );
      ((Element)v.get(419)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(423)).setAttribute("width","100%" );
      ((Element)v.get(423)).setAttribute("border","0" );
      ((Element)v.get(423)).setAttribute("cellspacing","0" );
      ((Element)v.get(423)).setAttribute("cellpadding","0" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(423)).setAttribute("align","left" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(424)).setAttribute("align","left" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(425)).setAttribute("nombre","gacaOidGuioArguCabeTdId" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(426)).setAttribute("border","0" );
      ((Element)v.get(426)).setAttribute("cellspacing","0" );
      ((Element)v.get(426)).setAttribute("cellpadding","0" );
      ((Element)v.get(426)).setAttribute("align","left" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(426)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(428)).setAttribute("valign","top" );
      ((Element)v.get(428)).setAttribute("height","13" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(429)).setAttribute("nombre","lblgacaOidGuioArguCabe" );
      ((Element)v.get(429)).setAttribute("id","datosTitle" );
      ((Element)v.get(429)).setAttribute("ancho","150" );
      ((Element)v.get(429)).setAttribute("alto","13" );
      ((Element)v.get(429)).setAttribute("cod","CobEtapaDeuda.gacaOidGuioArguCabe.label" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:428   */
      /* Termina nodo:427   */

      /* Empieza nodo:430 / Elemento padre: 426   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(430)).setAttribute("nombre","gacaOidGuioArguCabeWidgetTrId" );
      ((Element)v.get(426)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(431)).setAttribute("align","left" );
      ((Element)v.get(431)).setAttribute("nowrap","true" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(432)).setAttribute("nombre","gacaOidGuioArguCabe" );
      ((Element)v.get(432)).setAttribute("id","datosCampos" );
      ((Element)v.get(432)).setAttribute("multiple","N" );
      ((Element)v.get(432)).setAttribute("req","N" );
      ((Element)v.get(432)).setAttribute("size","1" );
      ((Element)v.get(432)).setAttribute("disabled","" );
      ((Element)v.get(432)).setAttribute("validacion","" );
      ((Element)v.get(432)).setAttribute("onchange","" );
      ((Element)v.get(432)).setAttribute("onfocus","" );
      ((Element)v.get(432)).setAttribute("valorinicial","" );
      ((Element)v.get(432)).setAttribute("textoinicial","" );
      ((Element)v.get(432)).setAttribute("ontab","ejecutarAccionFoco('cobEtapaDeudaFrm',15, true);" );
      ((Element)v.get(432)).setAttribute("onshtab","ejecutarAccionFoco('cobEtapaDeudaFrm',15, false);" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:432   */
      /* Termina nodo:431   */
      /* Termina nodo:430   */
      /* Termina nodo:426   */
      /* Termina nodo:425   */

      /* Empieza nodo:434 / Elemento padre: 424   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(434)).setAttribute("nombre","gacaOidGuioArguCabeGapTdId" );
      ((Element)v.get(434)).setAttribute("nowrap","true" );
      ((Element)v.get(434)).setAttribute("class","datosCampos" );
      ((Element)v.get(424)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(435)).setAttribute("src","b.gif" );
      ((Element)v.get(435)).setAttribute("width","25" );
      ((Element)v.get(435)).setAttribute("height","8" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */

      /* Empieza nodo:436 / Elemento padre: 424   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(436)).setAttribute("width","100%" );
      ((Element)v.get(424)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(437)).setAttribute("src","b.gif" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:424   */
      /* Termina nodo:423   */
      /* Termina nodo:422   */
      /* Termina nodo:419   */

      /* Empieza nodo:438 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(438)).setAttribute("nombre","formGapTr14" );
      ((Element)v.get(54)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(439)).setAttribute("align","center" );
      ((Element)v.get(439)).setAttribute("width","8" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(440)).setAttribute("src","b.gif" );
      ((Element)v.get(440)).setAttribute("width","12" );
      ((Element)v.get(440)).setAttribute("height","8" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:439   */

      /* Empieza nodo:441 / Elemento padre: 438   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(438)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(442)).setAttribute("src","b.gif" );
      ((Element)v.get(442)).setAttribute("width","8" );
      ((Element)v.get(442)).setAttribute("height","8" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:441   */

      /* Empieza nodo:443 / Elemento padre: 438   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(443)).setAttribute("align","center" );
      ((Element)v.get(443)).setAttribute("width","8" );
      ((Element)v.get(438)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(444)).setAttribute("src","b.gif" );
      ((Element)v.get(444)).setAttribute("width","12" );
      ((Element)v.get(444)).setAttribute("height","8" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */
      /* Termina nodo:438   */

      /* Empieza nodo:445 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(445)).setAttribute("nombre","formTr15" );
      ((Element)v.get(54)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(446)).setAttribute("align","center" );
      ((Element)v.get(446)).setAttribute("width","8" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(447)).setAttribute("src","b.gif" );
      ((Element)v.get(447)).setAttribute("width","8" );
      ((Element)v.get(447)).setAttribute("height","12" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:448 / Elemento padre: 445   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(448)).setAttribute("width","100%" );
      ((Element)v.get(445)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(449)).setAttribute("width","100%" );
      ((Element)v.get(449)).setAttribute("border","0" );
      ((Element)v.get(449)).setAttribute("cellspacing","0" );
      ((Element)v.get(449)).setAttribute("cellpadding","0" );
      ((Element)v.get(449)).setAttribute("align","left" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(450)).setAttribute("align","left" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(451)).setAttribute("nombre","paisOidPaisTdId" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(452)).setAttribute("border","0" );
      ((Element)v.get(452)).setAttribute("cellspacing","0" );
      ((Element)v.get(452)).setAttribute("cellpadding","0" );
      ((Element)v.get(452)).setAttribute("align","left" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(452)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(454)).setAttribute("valign","top" );
      ((Element)v.get(454)).setAttribute("height","13" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(455)).setAttribute("nombre","lblpaisOidPais" );
      ((Element)v.get(455)).setAttribute("id","datosTitle" );
      ((Element)v.get(455)).setAttribute("ancho","150" );
      ((Element)v.get(455)).setAttribute("alto","13" );
      ((Element)v.get(455)).setAttribute("cod","CobEtapaDeuda.paisOidPais.label" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:454   */
      /* Termina nodo:453   */

      /* Empieza nodo:456 / Elemento padre: 452   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(456)).setAttribute("nombre","paisOidPaisWidgetTrId" );
      ((Element)v.get(452)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(457)).setAttribute("align","left" );
      ((Element)v.get(457)).setAttribute("nowrap","true" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(458)).setAttribute("nombre","paisOidPais" );
      ((Element)v.get(458)).setAttribute("id","datosCampos" );
      ((Element)v.get(458)).setAttribute("multiple","N" );
      ((Element)v.get(458)).setAttribute("req","N" );
      ((Element)v.get(458)).setAttribute("size","1" );
      ((Element)v.get(458)).setAttribute("disabled","" );
      ((Element)v.get(458)).setAttribute("validacion","" );
      ((Element)v.get(458)).setAttribute("onchange","" );
      ((Element)v.get(458)).setAttribute("onfocus","" );
      ((Element)v.get(458)).setAttribute("valorinicial","" );
      ((Element)v.get(458)).setAttribute("textoinicial","" );
      ((Element)v.get(458)).setAttribute("ontab","ejecutarAccionFoco('cobEtapaDeudaFrm',16, true);" );
      ((Element)v.get(458)).setAttribute("onshtab","ejecutarAccionFoco('cobEtapaDeudaFrm',16, false);" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(458)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:458   */
      /* Termina nodo:457   */
      /* Termina nodo:456   */
      /* Termina nodo:452   */
      /* Termina nodo:451   */

      /* Empieza nodo:460 / Elemento padre: 450   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(460)).setAttribute("nombre","paisOidPaisGapTdId" );
      ((Element)v.get(460)).setAttribute("nowrap","true" );
      ((Element)v.get(460)).setAttribute("class","datosCampos" );
      ((Element)v.get(450)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(461)).setAttribute("src","b.gif" );
      ((Element)v.get(461)).setAttribute("width","25" );
      ((Element)v.get(461)).setAttribute("height","8" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:460   */

      /* Empieza nodo:462 / Elemento padre: 450   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(462)).setAttribute("nombre","oredOidEtapDeu1TdId" );
      ((Element)v.get(450)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("TABLE"));
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(463)).setAttribute("border","0" );
      ((Element)v.get(463)).setAttribute("cellspacing","0" );
      ((Element)v.get(463)).setAttribute("cellpadding","0" );
      ((Element)v.get(463)).setAttribute("align","left" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(463)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(465)).setAttribute("valign","top" );
      ((Element)v.get(465)).setAttribute("height","13" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(466)).setAttribute("nombre","lbloredOidEtapDeu1" );
      ((Element)v.get(466)).setAttribute("id","datosTitle" );
      ((Element)v.get(466)).setAttribute("ancho","150" );
      ((Element)v.get(466)).setAttribute("alto","13" );
      ((Element)v.get(466)).setAttribute("cod","CobEtapaDeuda.oredOidEtapDeu1.label" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */
      /* Termina nodo:465   */
      /* Termina nodo:464   */

      /* Empieza nodo:467 / Elemento padre: 463   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(467)).setAttribute("nombre","oredOidEtapDeu1WidgetTrId" );
      ((Element)v.get(463)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(468)).setAttribute("align","left" );
      ((Element)v.get(468)).setAttribute("nowrap","true" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(469)).setAttribute("nombre","oredOidEtapDeu1" );
      ((Element)v.get(469)).setAttribute("id","datosCampos" );
      ((Element)v.get(469)).setAttribute("multiple","N" );
      ((Element)v.get(469)).setAttribute("req","N" );
      ((Element)v.get(469)).setAttribute("size","1" );
      ((Element)v.get(469)).setAttribute("disabled","" );
      ((Element)v.get(469)).setAttribute("validacion","" );
      ((Element)v.get(469)).setAttribute("onchange","" );
      ((Element)v.get(469)).setAttribute("onfocus","" );
      ((Element)v.get(469)).setAttribute("valorinicial","" );
      ((Element)v.get(469)).setAttribute("textoinicial","" );
      ((Element)v.get(469)).setAttribute("ontab","ejecutarAccionFoco('cobEtapaDeudaFrm',17, true);" );
      ((Element)v.get(469)).setAttribute("onshtab","ejecutarAccionFoco('cobEtapaDeudaFrm',17, false);" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(469)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */
      /* Termina nodo:469   */
      /* Termina nodo:468   */
      /* Termina nodo:467   */
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:471 / Elemento padre: 450   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(471)).setAttribute("nombre","oredOidEtapDeu1GapTdId" );
      ((Element)v.get(471)).setAttribute("nowrap","true" );
      ((Element)v.get(471)).setAttribute("class","datosCampos" );
      ((Element)v.get(450)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(472)).setAttribute("src","b.gif" );
      ((Element)v.get(472)).setAttribute("width","25" );
      ((Element)v.get(472)).setAttribute("height","8" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:473 / Elemento padre: 450   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(473)).setAttribute("width","100%" );
      ((Element)v.get(450)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(474)).setAttribute("src","b.gif" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:473   */
      /* Termina nodo:450   */
      /* Termina nodo:449   */
      /* Termina nodo:448   */
      /* Termina nodo:445   */

      /* Empieza nodo:475 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(475)).setAttribute("nombre","formGapTr15" );
      ((Element)v.get(54)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("TD"));
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

      /* Empieza nodo:482 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(482)).setAttribute("nombre","formTr16" );
      ((Element)v.get(54)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("TD"));
   }

   private void getXML2160(Document doc) {
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
      ((Element)v.get(488)).setAttribute("nombre","oredOidEtapDeu2TdId" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("TABLE"));
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
      ((Element)v.get(492)).setAttribute("nombre","lbloredOidEtapDeu2" );
      ((Element)v.get(492)).setAttribute("id","datosTitle" );
      ((Element)v.get(492)).setAttribute("ancho","150" );
      ((Element)v.get(492)).setAttribute("alto","13" );
      ((Element)v.get(492)).setAttribute("cod","CobEtapaDeuda.oredOidEtapDeu2.label" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */
      /* Termina nodo:491   */
      /* Termina nodo:490   */

      /* Empieza nodo:493 / Elemento padre: 489   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(493)).setAttribute("nombre","oredOidEtapDeu2WidgetTrId" );
      ((Element)v.get(489)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(494)).setAttribute("align","left" );
      ((Element)v.get(494)).setAttribute("nowrap","true" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(495)).setAttribute("nombre","oredOidEtapDeu2" );
      ((Element)v.get(495)).setAttribute("id","datosCampos" );
      ((Element)v.get(495)).setAttribute("multiple","N" );
      ((Element)v.get(495)).setAttribute("req","N" );
      ((Element)v.get(495)).setAttribute("size","1" );
      ((Element)v.get(495)).setAttribute("disabled","" );
      ((Element)v.get(495)).setAttribute("validacion","" );
      ((Element)v.get(495)).setAttribute("onchange","" );
      ((Element)v.get(495)).setAttribute("onfocus","" );
      ((Element)v.get(495)).setAttribute("valorinicial","" );
      ((Element)v.get(495)).setAttribute("textoinicial","" );
      ((Element)v.get(495)).setAttribute("ontab","ejecutarAccionFoco('cobEtapaDeudaFrm',18, true);" );
      ((Element)v.get(495)).setAttribute("onshtab","ejecutarAccionFoco('cobEtapaDeudaFrm',18, false);" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(495)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */
      /* Termina nodo:495   */
      /* Termina nodo:494   */
      /* Termina nodo:493   */
      /* Termina nodo:489   */
      /* Termina nodo:488   */

      /* Empieza nodo:497 / Elemento padre: 487   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(497)).setAttribute("nombre","oredOidEtapDeu2GapTdId" );
      ((Element)v.get(497)).setAttribute("nowrap","true" );
      ((Element)v.get(497)).setAttribute("class","datosCampos" );
      ((Element)v.get(487)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(498)).setAttribute("src","b.gif" );
      ((Element)v.get(498)).setAttribute("width","25" );
      ((Element)v.get(498)).setAttribute("height","8" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */

      /* Empieza nodo:499 / Elemento padre: 487   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(499)).setAttribute("width","100%" );
      ((Element)v.get(487)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(500)).setAttribute("src","b.gif" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */
      /* Termina nodo:499   */
      /* Termina nodo:487   */
      /* Termina nodo:486   */
      /* Termina nodo:485   */
      /* Termina nodo:482   */

      /* Empieza nodo:501 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(501)).setAttribute("nombre","formGapTr16" );
      ((Element)v.get(54)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(502)).setAttribute("align","center" );
      ((Element)v.get(502)).setAttribute("width","8" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
   }

   private void getXML2250(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(503)).setAttribute("src","b.gif" );
      ((Element)v.get(503)).setAttribute("width","12" );
      ((Element)v.get(503)).setAttribute("height","8" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */

      /* Empieza nodo:504 / Elemento padre: 501   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(501)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(505)).setAttribute("src","b.gif" );
      ((Element)v.get(505)).setAttribute("width","8" );
      ((Element)v.get(505)).setAttribute("height","8" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */

      /* Empieza nodo:506 / Elemento padre: 501   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(506)).setAttribute("align","center" );
      ((Element)v.get(506)).setAttribute("width","8" );
      ((Element)v.get(501)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(507)).setAttribute("src","b.gif" );
      ((Element)v.get(507)).setAttribute("width","12" );
      ((Element)v.get(507)).setAttribute("height","8" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */
      /* Termina nodo:506   */
      /* Termina nodo:501   */

      /* Empieza nodo:508 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(508)).setAttribute("nombre","formTr17" );
      ((Element)v.get(54)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(509)).setAttribute("align","center" );
      ((Element)v.get(509)).setAttribute("width","8" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(510)).setAttribute("src","b.gif" );
      ((Element)v.get(510)).setAttribute("width","8" );
      ((Element)v.get(510)).setAttribute("height","12" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:509   */

      /* Empieza nodo:511 / Elemento padre: 508   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(511)).setAttribute("width","100%" );
      ((Element)v.get(508)).appendChild((Element)v.get(511));

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
      ((Element)v.get(513)).setAttribute("align","left" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(514)).setAttribute("nombre","oredOidEtapDeu3TdId" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(515)).setAttribute("border","0" );
      ((Element)v.get(515)).setAttribute("cellspacing","0" );
      ((Element)v.get(515)).setAttribute("cellpadding","0" );
      ((Element)v.get(515)).setAttribute("align","left" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(515)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(517)).setAttribute("valign","top" );
      ((Element)v.get(517)).setAttribute("height","13" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(518)).setAttribute("nombre","lbloredOidEtapDeu3" );
      ((Element)v.get(518)).setAttribute("id","datosTitle" );
      ((Element)v.get(518)).setAttribute("ancho","150" );
      ((Element)v.get(518)).setAttribute("alto","13" );
      ((Element)v.get(518)).setAttribute("cod","CobEtapaDeuda.oredOidEtapDeu3.label" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */
      /* Termina nodo:517   */
      /* Termina nodo:516   */

      /* Empieza nodo:519 / Elemento padre: 515   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(519)).setAttribute("nombre","oredOidEtapDeu3WidgetTrId" );
      ((Element)v.get(515)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(520)).setAttribute("align","left" );
      ((Element)v.get(520)).setAttribute("nowrap","true" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(521)).setAttribute("nombre","oredOidEtapDeu3" );
      ((Element)v.get(521)).setAttribute("id","datosCampos" );
      ((Element)v.get(521)).setAttribute("multiple","N" );
      ((Element)v.get(521)).setAttribute("req","N" );
      ((Element)v.get(521)).setAttribute("size","1" );
      ((Element)v.get(521)).setAttribute("disabled","" );
      ((Element)v.get(521)).setAttribute("validacion","" );
      ((Element)v.get(521)).setAttribute("onchange","" );
      ((Element)v.get(521)).setAttribute("onfocus","" );
      ((Element)v.get(521)).setAttribute("valorinicial","" );
      ((Element)v.get(521)).setAttribute("textoinicial","" );
      ((Element)v.get(521)).setAttribute("ontab","ejecutarAccionFoco('cobEtapaDeudaFrm',19, true);" );
      ((Element)v.get(521)).setAttribute("onshtab","ejecutarAccionFoco('cobEtapaDeudaFrm',19, false);" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));

      /* Empieza nodo:522 / Elemento padre: 521   */
   }

   private void getXML2340(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(521)).appendChild((Element)v.get(522));
      /* Termina nodo:522   */
      /* Termina nodo:521   */
      /* Termina nodo:520   */
      /* Termina nodo:519   */
      /* Termina nodo:515   */
      /* Termina nodo:514   */

      /* Empieza nodo:523 / Elemento padre: 513   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(523)).setAttribute("nombre","oredOidEtapDeu3GapTdId" );
      ((Element)v.get(523)).setAttribute("nowrap","true" );
      ((Element)v.get(523)).setAttribute("class","datosCampos" );
      ((Element)v.get(513)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(524)).setAttribute("src","b.gif" );
      ((Element)v.get(524)).setAttribute("width","25" );
      ((Element)v.get(524)).setAttribute("height","8" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */
      /* Termina nodo:523   */

      /* Empieza nodo:525 / Elemento padre: 513   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(525)).setAttribute("width","100%" );
      ((Element)v.get(513)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(526)).setAttribute("src","b.gif" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */
      /* Termina nodo:525   */
      /* Termina nodo:513   */
      /* Termina nodo:512   */
      /* Termina nodo:511   */

      /* Empieza nodo:527 / Elemento padre: 508   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(527)).setAttribute("width","100%" );
      ((Element)v.get(508)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:508   */

      /* Empieza nodo:528 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(528)).setAttribute("nombre","formGapTr17" );
      ((Element)v.get(54)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(529)).setAttribute("align","center" );
      ((Element)v.get(529)).setAttribute("width","8" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(530)).setAttribute("src","b.gif" );
      ((Element)v.get(530)).setAttribute("width","8" );
      ((Element)v.get(530)).setAttribute("height","8" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:529   */

      /* Empieza nodo:531 / Elemento padre: 528   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(528)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(532)).setAttribute("src","b.gif" );
      ((Element)v.get(532)).setAttribute("width","8" );
      ((Element)v.get(532)).setAttribute("height","8" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:531   */

      /* Empieza nodo:533 / Elemento padre: 528   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(533)).setAttribute("align","center" );
      ((Element)v.get(533)).setAttribute("width","8" );
      ((Element)v.get(528)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(534)).setAttribute("src","b.gif" );
      ((Element)v.get(534)).setAttribute("width","8" );
      ((Element)v.get(534)).setAttribute("height","8" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:533   */
      /* Termina nodo:528   */
      /* Termina nodo:54   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:535 / Elemento padre: 47   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(535)).setAttribute("align","center" );
      ((Element)v.get(535)).setAttribute("width","12" );
      ((Element)v.get(47)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(536)).setAttribute("src","b.gif" );
      ((Element)v.get(536)).setAttribute("width","12" );
      ((Element)v.get(536)).setAttribute("height","12" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */
      /* Termina nodo:535   */
      /* Termina nodo:47   */

      /* Empieza nodo:537 / Elemento padre: 39   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(537)).setAttribute("nombre","cobEtapaDeudaTrButtons" );
      ((Element)v.get(39)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(538)).setAttribute("align","center" );
      ((Element)v.get(538)).setAttribute("width","12" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(539)).setAttribute("src","b.gif" );
      ((Element)v.get(539)).setAttribute("width","12" );
      ((Element)v.get(539)).setAttribute("height","12" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */
      /* Termina nodo:538   */

      /* Empieza nodo:540 / Elemento padre: 537   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(537)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(540)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(542)).setAttribute("width","100%" );
      ((Element)v.get(542)).setAttribute("border","0" );
      ((Element)v.get(542)).setAttribute("align","center" );
      ((Element)v.get(542)).setAttribute("cellspacing","0" );
      ((Element)v.get(542)).setAttribute("cellpadding","0" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(542)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(544)).setAttribute("class","tablaTitle" );
      ((Element)v.get(544)).setAttribute("nombre","cobEtapaDeudaTdQueryButton" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(545)).setAttribute("nombre","cobEtapaDeudaQueryButton" );
      ((Element)v.get(545)).setAttribute("cod","MMGGlobal.queryButton.label" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(545)).setAttribute("estado","false" );
      ((Element)v.get(545)).setAttribute("accion","cobEtapaDeudaFirstPage();" );
      ((Element)v.get(545)).setAttribute("tipo","html" );
      ((Element)v.get(545)).setAttribute("ID","botonContenido" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:544   */

      /* Empieza nodo:546 / Elemento padre: 543   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(546)).setAttribute("class","tablaTitle" );
      ((Element)v.get(546)).setAttribute("nombre","cobEtapaDeudaTdLovNullSelectionButton" );
      ((Element)v.get(546)).setAttribute("align","left" );
      ((Element)v.get(546)).setAttribute("width","100%" );
      ((Element)v.get(543)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(547)).setAttribute("src","b.gif" );
      ((Element)v.get(547)).setAttribute("height","8" );
      ((Element)v.get(547)).setAttribute("width","8" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */

      /* Empieza nodo:548 / Elemento padre: 546   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(548)).setAttribute("nombre","cobEtapaDeudaLovNullButton" );
      ((Element)v.get(548)).setAttribute("ID","botonContenido" );
      ((Element)v.get(548)).setAttribute("tipo","html" );
      ((Element)v.get(548)).setAttribute("accion","cobEtapaDeudaLovNullSelectionAction();" );
      ((Element)v.get(548)).setAttribute("estado","true" );
      ((Element)v.get(548)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(546)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */
      /* Termina nodo:546   */
      /* Termina nodo:543   */
      /* Termina nodo:542   */
      /* Termina nodo:541   */
      /* Termina nodo:540   */

      /* Empieza nodo:549 / Elemento padre: 537   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(549)).setAttribute("align","center" );
      ((Element)v.get(549)).setAttribute("width","12" );
      ((Element)v.get(537)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(550)).setAttribute("src","b.gif" );
      ((Element)v.get(550)).setAttribute("width","12" );
      ((Element)v.get(550)).setAttribute("height","12" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));
      /* Termina nodo:550   */
      /* Termina nodo:549   */
      /* Termina nodo:537   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:551 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(551)).setAttribute("nombre","cobEtapaDeudaListLayer" );
      ((Element)v.get(551)).setAttribute("alto","310" );
      ((Element)v.get(551)).setAttribute("ancho","99%" );
      ((Element)v.get(551)).setAttribute("colorf","" );
      ((Element)v.get(551)).setAttribute("borde","0" );
      ((Element)v.get(551)).setAttribute("imagenf","" );
      ((Element)v.get(551)).setAttribute("repeat","" );
      ((Element)v.get(551)).setAttribute("padding","" );
      ((Element)v.get(551)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(551)).setAttribute("contravsb","" );
      ((Element)v.get(551)).setAttribute("x","3" );
      ((Element)v.get(551)).setAttribute("y","" );
      ((Element)v.get(551)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(552)).setAttribute("nombre","cobEtapaDeudaList" );
      ((Element)v.get(552)).setAttribute("ancho","680" );
      ((Element)v.get(552)).setAttribute("alto","275" );
      ((Element)v.get(552)).setAttribute("x","12" );
      ((Element)v.get(552)).setAttribute("y","0" );
      ((Element)v.get(552)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(552)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(553)).setAttribute("precarga","S" );
      ((Element)v.get(553)).setAttribute("conROver","S" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(554)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(554)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(554)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(554)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */

      /* Empieza nodo:555 / Elemento padre: 553   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(555)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(555)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(555)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(555)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(553)).appendChild((Element)v.get(555));
      /* Termina nodo:555   */
      /* Termina nodo:553   */

      /* Empieza nodo:556 / Elemento padre: 552   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(552)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(557)).setAttribute("borde","1" );
      ((Element)v.get(557)).setAttribute("horizDatos","1" );
      ((Element)v.get(557)).setAttribute("horizCabecera","1" );
      ((Element)v.get(557)).setAttribute("vertical","1" );
      ((Element)v.get(557)).setAttribute("horizTitulo","1" );
      ((Element)v.get(557)).setAttribute("horizBase","1" );
      ((Element)v.get(556)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */

      /* Empieza nodo:558 / Elemento padre: 556   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(558)).setAttribute("borde","#999999" );
      ((Element)v.get(558)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(558)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(558)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(558)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(558)).setAttribute("horizTitulo","#999999" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(558)).setAttribute("horizBase","#999999" );
      ((Element)v.get(556)).appendChild((Element)v.get(558));
      /* Termina nodo:558   */
      /* Termina nodo:556   */

      /* Empieza nodo:559 / Elemento padre: 552   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(559)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(559)).setAttribute("alto","22" );
      ((Element)v.get(559)).setAttribute("imgFondo","" );
      ((Element)v.get(559)).setAttribute("cod","00135" );
      ((Element)v.get(559)).setAttribute("ID","datosTitle" );
      ((Element)v.get(552)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */

      /* Empieza nodo:560 / Elemento padre: 552   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(560)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(560)).setAttribute("alto","22" );
      ((Element)v.get(560)).setAttribute("imgFondo","" );
      ((Element)v.get(552)).appendChild((Element)v.get(560));
      /* Termina nodo:560   */

      /* Empieza nodo:561 / Elemento padre: 552   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(561)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(561)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(561)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(561)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(561)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(552)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(562)).setAttribute("ancho","100" );
      ((Element)v.get(562)).setAttribute("minimizable","S" );
      ((Element)v.get(562)).setAttribute("minimizada","N" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */

      /* Empieza nodo:563 / Elemento padre: 561   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(563)).setAttribute("ancho","100" );
      ((Element)v.get(563)).setAttribute("minimizable","S" );
      ((Element)v.get(563)).setAttribute("minimizada","N" );
      ((Element)v.get(561)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */

      /* Empieza nodo:564 / Elemento padre: 561   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(564)).setAttribute("ancho","100" );
      ((Element)v.get(564)).setAttribute("minimizable","S" );
      ((Element)v.get(564)).setAttribute("minimizada","N" );
      ((Element)v.get(561)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */

      /* Empieza nodo:565 / Elemento padre: 561   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(565)).setAttribute("ancho","100" );
      ((Element)v.get(565)).setAttribute("minimizable","S" );
      ((Element)v.get(565)).setAttribute("minimizada","N" );
      ((Element)v.get(561)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */
      /* Termina nodo:561   */

      /* Empieza nodo:566 / Elemento padre: 552   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(566)).setAttribute("height","20" );
      ((Element)v.get(566)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(566)).setAttribute("imgFondo","" );
      ((Element)v.get(566)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(552)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(567)).setAttribute("colFondo","" );
      ((Element)v.get(567)).setAttribute("ID","EstCab" );
      ((Element)v.get(567)).setAttribute("cod","CobEtapaDeuda.codEtapDeud.label" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */

      /* Empieza nodo:568 / Elemento padre: 566   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(568)).setAttribute("colFondo","" );
      ((Element)v.get(568)).setAttribute("ID","EstCab" );
      ((Element)v.get(568)).setAttribute("cod","CobEtapaDeuda.valDesc.label" );
      ((Element)v.get(566)).appendChild((Element)v.get(568));
      /* Termina nodo:568   */

      /* Empieza nodo:569 / Elemento padre: 566   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(569)).setAttribute("colFondo","" );
      ((Element)v.get(569)).setAttribute("ID","EstCab" );
      ((Element)v.get(569)).setAttribute("cod","CobEtapaDeuda.valEdadInic.label" );
      ((Element)v.get(566)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */

      /* Empieza nodo:570 / Elemento padre: 566   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(570)).setAttribute("colFondo","" );
      ((Element)v.get(570)).setAttribute("ID","EstCab" );
      ((Element)v.get(570)).setAttribute("cod","CobEtapaDeuda.valEdadFina.label" );
      ((Element)v.get(566)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */
      /* Termina nodo:566   */

      /* Empieza nodo:571 / Elemento padre: 552   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(571)).setAttribute("alto","22" );
      ((Element)v.get(571)).setAttribute("accion","" );
      ((Element)v.get(571)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(571)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(571)).setAttribute("maxSel","1" );
      ((Element)v.get(571)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(571)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(571)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(571)).setAttribute("onLoad","" );
      ((Element)v.get(571)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(552)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(572)).setAttribute("tipo","texto" );
      ((Element)v.get(572)).setAttribute("ID","EstDat" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));
      /* Termina nodo:572   */

      /* Empieza nodo:573 / Elemento padre: 571   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(573)).setAttribute("tipo","texto" );
      ((Element)v.get(573)).setAttribute("ID","EstDat2" );
      ((Element)v.get(571)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */

      /* Empieza nodo:574 / Elemento padre: 571   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(574)).setAttribute("tipo","texto" );
      ((Element)v.get(574)).setAttribute("ID","EstDat" );
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(571)).appendChild((Element)v.get(574));
      /* Termina nodo:574   */

      /* Empieza nodo:575 / Elemento padre: 571   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(575)).setAttribute("tipo","texto" );
      ((Element)v.get(575)).setAttribute("ID","EstDat2" );
      ((Element)v.get(571)).appendChild((Element)v.get(575));
      /* Termina nodo:575   */
      /* Termina nodo:571   */

      /* Empieza nodo:576 / Elemento padre: 552   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(552)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */
      /* Termina nodo:552   */
      /* Termina nodo:551   */

      /* Empieza nodo:577 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(577)).setAttribute("nombre","cobEtapaDeudaListButtonsLayer" );
      ((Element)v.get(577)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(577)).setAttribute("alto","30" );
      ((Element)v.get(577)).setAttribute("ancho","98%" );
      ((Element)v.get(577)).setAttribute("borde","n" );
      ((Element)v.get(577)).setAttribute("imagenf","" );
      ((Element)v.get(577)).setAttribute("repeat","" );
      ((Element)v.get(577)).setAttribute("padding","0" );
      ((Element)v.get(577)).setAttribute("contravsb","" );
      ((Element)v.get(577)).setAttribute("x","16" );
      ((Element)v.get(577)).setAttribute("y","" );
      ((Element)v.get(577)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(578)).setAttribute("nombre","toolbarSeparatorLayer" );
      ((Element)v.get(578)).setAttribute("visibilidad","inherit" );
      ((Element)v.get(578)).setAttribute("alto","23" );
      ((Element)v.get(578)).setAttribute("ancho","1" );
      ((Element)v.get(578)).setAttribute("borde","1" );
      ((Element)v.get(578)).setAttribute("imagenf","" );
      ((Element)v.get(578)).setAttribute("repeat","" );
      ((Element)v.get(578)).setAttribute("padding","0" );
      ((Element)v.get(578)).setAttribute("contravsb","" );
      ((Element)v.get(578)).setAttribute("x","56" );
      ((Element)v.get(578)).setAttribute("y","0" );
      ((Element)v.get(578)).setAttribute("zindex","" );
      ((Element)v.get(578)).setAttribute("colborde","#999999" );
      ((Element)v.get(577)).appendChild((Element)v.get(578));
      /* Termina nodo:578   */

      /* Empieza nodo:579 / Elemento padre: 577   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(579)).setAttribute("width","100%" );
      ((Element)v.get(579)).setAttribute("border","0" );
      ((Element)v.get(579)).setAttribute("cellspacing","1" );
      ((Element)v.get(579)).setAttribute("cellpadding","0" );
      ((Element)v.get(577)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(579)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(581)).setAttribute("src","b.gif" );
      ((Element)v.get(581)).setAttribute("height","22" );
      ((Element)v.get(581)).setAttribute("width","5" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */
      /* Termina nodo:580   */

      /* Empieza nodo:582 / Elemento padre: 579   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(579)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(583)).setAttribute("nombre","cobEtapaDeudaPaginationButtonBar" );
      ((Element)v.get(583)).setAttribute("tipo","H" );
      ((Element)v.get(583)).setAttribute("x","0" );
      ((Element)v.get(583)).setAttribute("y","0" );
      ((Element)v.get(582)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(584)).setAttribute("nombre","cobEtapaDeudaFirstPageButton" );
      ((Element)v.get(584)).setAttribute("funcion","cobEtapaDeudaFirstPage();" );
      ((Element)v.get(584)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(584)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(584)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(584)).setAttribute("estado","inactivo" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */

      /* Empieza nodo:585 / Elemento padre: 583   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(585)).setAttribute("nombre","cobEtapaDeudaFirstPageButtonGapTd" );
      ((Element)v.get(583)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(586)).setAttribute("src","b.gif" );
      ((Element)v.get(586)).setAttribute("height","8" );
      ((Element)v.get(586)).setAttribute("width","5" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */
      /* Termina nodo:585   */

      /* Empieza nodo:587 / Elemento padre: 583   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(587)).setAttribute("nombre","cobEtapaDeudaPreviousPageButton" );
      ((Element)v.get(587)).setAttribute("funcion","cobEtapaDeudaPreviousPage();" );
      ((Element)v.get(587)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(587)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(587)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(587)).setAttribute("estado","inactivo" );
      ((Element)v.get(583)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */

      /* Empieza nodo:588 / Elemento padre: 583   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(588)).setAttribute("nombre","cobEtapaDeudaPreviousPageButtonGapTd" );
      ((Element)v.get(583)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(589)).setAttribute("src","b.gif" );
      ((Element)v.get(589)).setAttribute("height","8" );
      ((Element)v.get(589)).setAttribute("width","8" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */
      /* Termina nodo:588   */

      /* Empieza nodo:590 / Elemento padre: 583   */
      v.add(doc.createElement("BTN"));
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(590)).setAttribute("nombre","cobEtapaDeudaNextPageButton" );
      ((Element)v.get(590)).setAttribute("funcion","cobEtapaDeudaNextPage();" );
      ((Element)v.get(590)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(590)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(590)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(590)).setAttribute("estado","inactivo" );
      ((Element)v.get(583)).appendChild((Element)v.get(590));
      /* Termina nodo:590   */
      /* Termina nodo:583   */
      /* Termina nodo:582   */

      /* Empieza nodo:591 / Elemento padre: 579   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(579)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(592)).setAttribute("src","b.gif" );
      ((Element)v.get(592)).setAttribute("height","22" );
      ((Element)v.get(592)).setAttribute("width","19" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */
      /* Termina nodo:591   */

      /* Empieza nodo:593 / Elemento padre: 579   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(593)).setAttribute("class","tablaTitle" );
      ((Element)v.get(593)).setAttribute("nombre","cobEtapaDeudaUpdateButtonTd" );
      ((Element)v.get(579)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(594)).setAttribute("nombre","cobEtapaDeudaUpdateButton" );
      ((Element)v.get(594)).setAttribute("ID","botonContenido" );
      ((Element)v.get(594)).setAttribute("tipo","html" );
      ((Element)v.get(594)).setAttribute("accion","cobEtapaDeudaUpdateSelection();" );
      ((Element)v.get(594)).setAttribute("estado","false" );
      ((Element)v.get(594)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));
      /* Termina nodo:594   */
      /* Termina nodo:593   */

      /* Empieza nodo:595 / Elemento padre: 579   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(595)).setAttribute("nombre","cobEtapaDeudaUpdateButtonGapTd" );
      ((Element)v.get(579)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(596)).setAttribute("src","b.gif" );
      ((Element)v.get(596)).setAttribute("height","8" );
      ((Element)v.get(596)).setAttribute("width","10" );
      ((Element)v.get(595)).appendChild((Element)v.get(596));
      /* Termina nodo:596   */
      /* Termina nodo:595   */

      /* Empieza nodo:597 / Elemento padre: 579   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(597)).setAttribute("class","tablaTitle" );
      ((Element)v.get(597)).setAttribute("nombre","cobEtapaDeudaViewForRemoveButtonTd" );
      ((Element)v.get(579)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(598)).setAttribute("nombre","cobEtapaDeudaViewForRemoveButton" );
      ((Element)v.get(598)).setAttribute("ID","botonContenido" );
      ((Element)v.get(598)).setAttribute("tipo","html" );
      ((Element)v.get(598)).setAttribute("accion","cobEtapaDeudaViewSelection();" );
      ((Element)v.get(598)).setAttribute("estado","false" );
      ((Element)v.get(598)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(597)).appendChild((Element)v.get(598));
      /* Termina nodo:598   */
      /* Termina nodo:597   */

      /* Empieza nodo:599 / Elemento padre: 579   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(599)).setAttribute("nombre","cobEtapaDeudaViewForRemoveButtonGapTd" );
      ((Element)v.get(579)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(600)).setAttribute("src","b.gif" );
      ((Element)v.get(600)).setAttribute("height","8" );
      ((Element)v.get(600)).setAttribute("width","10" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));
      /* Termina nodo:600   */
      /* Termina nodo:599   */

      /* Empieza nodo:601 / Elemento padre: 579   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(601)).setAttribute("class","tablaTitle" );
      ((Element)v.get(601)).setAttribute("nombre","cobEtapaDeudaLovSelectButtonTd" );
      ((Element)v.get(579)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(602)).setAttribute("nombre","cobEtapaDeudaLovSelectButton" );
      ((Element)v.get(602)).setAttribute("ID","botonContenido" );
      ((Element)v.get(602)).setAttribute("tipo","html" );
      ((Element)v.get(602)).setAttribute("accion","cobEtapaDeudaLovSelectionAction();" );
      ((Element)v.get(602)).setAttribute("estado","true" );
      ((Element)v.get(602)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));
      /* Termina nodo:602   */
      /* Termina nodo:601   */

      /* Empieza nodo:603 / Elemento padre: 579   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(603)).setAttribute("nombre","cobEtapaDeudaLovSelectButtonGapTd" );
      ((Element)v.get(579)).appendChild((Element)v.get(603));

      /* Empieza nodo:604 / Elemento padre: 603   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(604)).setAttribute("src","b.gif" );
      ((Element)v.get(604)).setAttribute("height","8" );
      ((Element)v.get(604)).setAttribute("width","10" );
      ((Element)v.get(603)).appendChild((Element)v.get(604));
      /* Termina nodo:604   */
      /* Termina nodo:603   */

      /* Empieza nodo:605 / Elemento padre: 579   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(605)).setAttribute("class","tablaTitle" );
      ((Element)v.get(605)).setAttribute("nombre","cobEtapaDeudaViewButtonTd" );
      ((Element)v.get(579)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(606)).setAttribute("nombre","cobEtapaDeudaViewButton" );
      ((Element)v.get(606)).setAttribute("ID","botonContenido" );
      ((Element)v.get(606)).setAttribute("tipo","html" );
      ((Element)v.get(606)).setAttribute("accion","cobEtapaDeudaViewSelection();" );
      ((Element)v.get(606)).setAttribute("estado","false" );
      ((Element)v.get(606)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(605)).appendChild((Element)v.get(606));
      /* Termina nodo:606   */
      /* Termina nodo:605   */

      /* Empieza nodo:607 / Elemento padre: 579   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(607)).setAttribute("nombre","cobEtapaDeudaViewButtonGapTd" );
      ((Element)v.get(579)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(608)).setAttribute("src","b.gif" );
      ((Element)v.get(608)).setAttribute("height","8" );
      ((Element)v.get(608)).setAttribute("width","10" );
      ((Element)v.get(607)).appendChild((Element)v.get(608));
      /* Termina nodo:608   */
      /* Termina nodo:607   */

      /* Empieza nodo:609 / Elemento padre: 579   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(609)).setAttribute("width","100%" );
      ((Element)v.get(579)).appendChild((Element)v.get(609));
      /* Termina nodo:609   */
      /* Termina nodo:579   */
      /* Termina nodo:577   */
      /* Termina nodo:4   */


   }

}

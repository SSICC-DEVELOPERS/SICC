
import org.w3c.dom.*;
import java.util.ArrayList;

public class PedTipoSolicPaisPage  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","PedTipoSolicPaisPage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","pedTipoSolicPaisInitComponents()" );
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
      ((Element)v.get(3)).setAttribute("src","pedtiposolicpais.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","pedTipoSolicPaisFrm" );
      ((Element)v.get(4)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","PedTipoSolicPaisLPExecution" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","ON" );
      ((Element)v.get(6)).setAttribute("valor","PedTipoSolicPaisLPExecution" );
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
      ((Element)v.get(36)).setAttribute("nombre","pedTipoSolicPaisFormLayer" );
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
      ((Element)v.get(51)).setAttribute("cod","PedTipoSolicPais.legend.label" );
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
      ((Element)v.get(66)).setAttribute("cod","PedTipoSolicPais.id.label" );
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
      ((Element)v.get(69)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',1, true)" );
      ((Element)v.get(69)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 1, false)" );
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
      ((Element)v.get(91)).setAttribute("cod","PedTipoSolicPais.paisOidPais.label" );
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
      ((Element)v.get(94)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',2, true);" );
      ((Element)v.get(94)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',2, false);" );
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
      ((Element)v.get(98)).setAttribute("nombre","tsolOidTipoSoliTdId" );
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
      ((Element)v.get(102)).setAttribute("nombre","lbltsolOidTipoSoli" );
      ((Element)v.get(102)).setAttribute("id","datosTitle" );
      ((Element)v.get(102)).setAttribute("ancho","150" );
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("cod","PedTipoSolicPais.tsolOidTipoSoli.label" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:103 / Elemento padre: 99   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(103)).setAttribute("nombre","tsolOidTipoSoliWidgetTrId" );
      ((Element)v.get(99)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(104)).setAttribute("align","left" );
      ((Element)v.get(104)).setAttribute("nowrap","true" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(105)).setAttribute("nombre","tsolOidTipoSoli" );
      ((Element)v.get(105)).setAttribute("id","datosCampos" );
      ((Element)v.get(105)).setAttribute("multiple","N" );
      ((Element)v.get(105)).setAttribute("req","N" );
      ((Element)v.get(105)).setAttribute("size","1" );
      ((Element)v.get(105)).setAttribute("disabled","" );
      ((Element)v.get(105)).setAttribute("validacion","" );
      ((Element)v.get(105)).setAttribute("onchange","" );
      ((Element)v.get(105)).setAttribute("onfocus","" );
      ((Element)v.get(105)).setAttribute("valorinicial","" );
      ((Element)v.get(105)).setAttribute("textoinicial","" );
      ((Element)v.get(105)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',3, true);" );
      ((Element)v.get(105)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',3, false);" );
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
      ((Element)v.get(107)).setAttribute("nombre","tsolOidTipoSoliGapTdId" );
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
      ((Element)v.get(109)).setAttribute("width","100%" );
      ((Element)v.get(86)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:81   */

      /* Empieza nodo:111 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(111)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(52)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(112)).setAttribute("align","center" );
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","12" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(111)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(116)).setAttribute("align","center" );
      ((Element)v.get(116)).setAttribute("width","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","12" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:111   */

      /* Empieza nodo:118 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(118)).setAttribute("nombre","formTr2" );
      ((Element)v.get(52)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(119)).setAttribute("align","center" );
      ((Element)v.get(119)).setAttribute("width","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","8" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(120)).setAttribute("height","12" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 118   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(121)).setAttribute("width","100%" );
      ((Element)v.get(118)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(122)).setAttribute("width","100%" );
      ((Element)v.get(122)).setAttribute("border","0" );
      ((Element)v.get(122)).setAttribute("cellspacing","0" );
      ((Element)v.get(122)).setAttribute("cellpadding","0" );
      ((Element)v.get(122)).setAttribute("align","left" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(123)).setAttribute("align","left" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(124)).setAttribute("nombre","numSoliLoteTdId" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

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
      ((Element)v.get(128)).setAttribute("nombre","lblNumSoliLote" );
      ((Element)v.get(128)).setAttribute("alto","13" );
      ((Element)v.get(128)).setAttribute("filas","1" );
      ((Element)v.get(128)).setAttribute("id","datosTitle" );
      ((Element)v.get(128)).setAttribute("cod","PedTipoSolicPais.numSoliLote.label" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:129 / Elemento padre: 125   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(129)).setAttribute("nombre","numSoliLoteWidgetTrId" );
      ((Element)v.get(125)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(130)).setAttribute("align","left" );
      ((Element)v.get(130)).setAttribute("nowrap","true" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(131)).setAttribute("nombre","numSoliLote" );
      ((Element)v.get(131)).setAttribute("id","datosCampos" );
      ((Element)v.get(131)).setAttribute("trim","S" );
      ((Element)v.get(131)).setAttribute("max","3" );
      ((Element)v.get(131)).setAttribute("onchange","" );
      ((Element)v.get(131)).setAttribute("req","N" );
      ((Element)v.get(131)).setAttribute("size","3" );
      ((Element)v.get(131)).setAttribute("valor","" );
      ((Element)v.get(131)).setAttribute("validacion","" );
      ((Element)v.get(131)).setAttribute("disabled","" );
      ((Element)v.get(131)).setAttribute("onblur","" );
      ((Element)v.get(131)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',4, true)" );
      ((Element)v.get(131)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 4, false)" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:132 / Elemento padre: 123   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(132)).setAttribute("nombre","numSoliLoteGapTdId" );
      ((Element)v.get(132)).setAttribute("nowrap","true" );
      ((Element)v.get(132)).setAttribute("class","datosCampos" );
      ((Element)v.get(123)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","25" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 123   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(134)).setAttribute("width","100%" );
      ((Element)v.get(123)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:118   */

      /* Empieza nodo:136 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(136)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(52)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(137)).setAttribute("align","center" );
      ((Element)v.get(137)).setAttribute("width","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","12" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(136)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","8" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(141)).setAttribute("align","center" );
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","12" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:136   */

      /* Empieza nodo:143 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(143)).setAttribute("nombre","formTr3" );
      ((Element)v.get(52)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(144)).setAttribute("align","center" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","8" );
      ((Element)v.get(145)).setAttribute("height","12" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 143   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(146)).setAttribute("width","100%" );
      ((Element)v.get(143)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(147)).setAttribute("width","100%" );
      ((Element)v.get(147)).setAttribute("border","0" );
      ((Element)v.get(147)).setAttribute("cellspacing","0" );
      ((Element)v.get(147)).setAttribute("cellpadding","0" );
      ((Element)v.get(147)).setAttribute("align","left" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(148)).setAttribute("align","left" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(149)).setAttribute("nombre","numUnidAlarTdId" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(150)).setAttribute("width","100%" );
      ((Element)v.get(150)).setAttribute("border","0" );
      ((Element)v.get(150)).setAttribute("cellspacing","0" );
      ((Element)v.get(150)).setAttribute("cellpadding","0" );
      ((Element)v.get(150)).setAttribute("align","left" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(152)).setAttribute("valign","top" );
      ((Element)v.get(152)).setAttribute("height","13" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(153)).setAttribute("nombre","lblNumUnidAlar" );
      ((Element)v.get(153)).setAttribute("alto","13" );
      ((Element)v.get(153)).setAttribute("filas","1" );
      ((Element)v.get(153)).setAttribute("id","datosTitle" );
      ((Element)v.get(153)).setAttribute("cod","PedTipoSolicPais.numUnidAlar.label" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:154 / Elemento padre: 150   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(154)).setAttribute("nombre","numUnidAlarWidgetTrId" );
      ((Element)v.get(150)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(155)).setAttribute("align","left" );
      ((Element)v.get(155)).setAttribute("nowrap","true" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(156)).setAttribute("nombre","numUnidAlar" );
      ((Element)v.get(156)).setAttribute("id","datosCampos" );
      ((Element)v.get(156)).setAttribute("trim","S" );
      ((Element)v.get(156)).setAttribute("max","5" );
      ((Element)v.get(156)).setAttribute("onchange","" );
      ((Element)v.get(156)).setAttribute("req","N" );
      ((Element)v.get(156)).setAttribute("size","5" );
      ((Element)v.get(156)).setAttribute("valor","" );
      ((Element)v.get(156)).setAttribute("validacion","" );
      ((Element)v.get(156)).setAttribute("disabled","" );
      ((Element)v.get(156)).setAttribute("onblur","" );
      ((Element)v.get(156)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',5, true)" );
      ((Element)v.get(156)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 5, false)" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:157 / Elemento padre: 148   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(157)).setAttribute("nombre","numUnidAlarGapTdId" );
      ((Element)v.get(157)).setAttribute("nowrap","true" );
      ((Element)v.get(157)).setAttribute("class","datosCampos" );
      ((Element)v.get(148)).appendChild((Element)v.get(157));

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

      /* Empieza nodo:159 / Elemento padre: 148   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(159)).setAttribute("width","100%" );
      ((Element)v.get(148)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:143   */

      /* Empieza nodo:161 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(161)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(52)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(162)).setAttribute("align","center" );
      ((Element)v.get(162)).setAttribute("width","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","12" );
      ((Element)v.get(163)).setAttribute("height","8" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 161   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(161)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","8" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 161   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(166)).setAttribute("align","center" );
      ((Element)v.get(166)).setAttribute("width","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","12" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:161   */

      /* Empieza nodo:168 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(168)).setAttribute("nombre","formTr4" );
      ((Element)v.get(52)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(169)).setAttribute("align","center" );
      ((Element)v.get(169)).setAttribute("width","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","8" );
      ((Element)v.get(170)).setAttribute("height","12" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 168   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(171)).setAttribute("width","100%" );
      ((Element)v.get(168)).appendChild((Element)v.get(171));

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
      ((Element)v.get(173)).setAttribute("align","left" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(174)).setAttribute("nombre","fopaOidFormPagoTdId" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("TABLE"));
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
      ((Element)v.get(178)).setAttribute("nombre","lblfopaOidFormPago" );
      ((Element)v.get(178)).setAttribute("id","datosTitle" );
      ((Element)v.get(178)).setAttribute("ancho","150" );
      ((Element)v.get(178)).setAttribute("alto","13" );
      ((Element)v.get(178)).setAttribute("cod","PedTipoSolicPais.fopaOidFormPago.label" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:179 / Elemento padre: 175   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(179)).setAttribute("nombre","fopaOidFormPagoWidgetTrId" );
      ((Element)v.get(175)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(180)).setAttribute("align","left" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(180)).setAttribute("nowrap","true" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(181)).setAttribute("nombre","fopaOidFormPago" );
      ((Element)v.get(181)).setAttribute("id","datosCampos" );
      ((Element)v.get(181)).setAttribute("multiple","N" );
      ((Element)v.get(181)).setAttribute("req","N" );
      ((Element)v.get(181)).setAttribute("size","1" );
      ((Element)v.get(181)).setAttribute("disabled","" );
      ((Element)v.get(181)).setAttribute("validacion","" );
      ((Element)v.get(181)).setAttribute("onchange","" );
      ((Element)v.get(181)).setAttribute("onfocus","" );
      ((Element)v.get(181)).setAttribute("valorinicial","" );
      ((Element)v.get(181)).setAttribute("textoinicial","" );
      ((Element)v.get(181)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',6, true);" );
      ((Element)v.get(181)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',6, false);" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:183 / Elemento padre: 173   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(183)).setAttribute("nombre","fopaOidFormPagoGapTdId" );
      ((Element)v.get(183)).setAttribute("nowrap","true" );
      ((Element)v.get(183)).setAttribute("class","datosCampos" );
      ((Element)v.get(173)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","25" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 173   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(185)).setAttribute("width","100%" );
      ((Element)v.get(173)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:168   */

      /* Empieza nodo:187 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(187)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(52)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(188)).setAttribute("align","center" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","12" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 187   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(187)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","8" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 187   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(192)).setAttribute("align","center" );
      ((Element)v.get(192)).setAttribute("width","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","12" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:187   */

      /* Empieza nodo:194 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(194)).setAttribute("nombre","formTr5" );
      ((Element)v.get(52)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(195)).setAttribute("align","center" );
      ((Element)v.get(195)).setAttribute("width","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","8" );
      ((Element)v.get(196)).setAttribute("height","12" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 194   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(197)).setAttribute("width","100%" );
      ((Element)v.get(194)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(198)).setAttribute("width","100%" );
      ((Element)v.get(198)).setAttribute("border","0" );
      ((Element)v.get(198)).setAttribute("cellspacing","0" );
      ((Element)v.get(198)).setAttribute("cellpadding","0" );
      ((Element)v.get(198)).setAttribute("align","left" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(199)).setAttribute("align","left" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(200)).setAttribute("nombre","indSujeFletTdId" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(201)).setAttribute("width","100%" );
      ((Element)v.get(201)).setAttribute("border","0" );
      ((Element)v.get(201)).setAttribute("cellspacing","0" );
      ((Element)v.get(201)).setAttribute("cellpadding","0" );
      ((Element)v.get(201)).setAttribute("align","left" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(203)).setAttribute("valign","top" );
      ((Element)v.get(203)).setAttribute("height","13" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(204)).setAttribute("nombre","lblIndSujeFlet" );
      ((Element)v.get(204)).setAttribute("alto","13" );
      ((Element)v.get(204)).setAttribute("filas","1" );
      ((Element)v.get(204)).setAttribute("id","datosTitle" );
      ((Element)v.get(204)).setAttribute("cod","PedTipoSolicPais.indSujeFlet.label" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:205 / Elemento padre: 201   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(205)).setAttribute("nombre","indSujeFletWidgetTrId" );
      ((Element)v.get(201)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(206)).setAttribute("align","left" );
      ((Element)v.get(206)).setAttribute("nowrap","true" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(207)).setAttribute("nombre","indSujeFlet" );
      ((Element)v.get(207)).setAttribute("id","datosCampos" );
      ((Element)v.get(207)).setAttribute("trim","S" );
      ((Element)v.get(207)).setAttribute("max","1" );
      ((Element)v.get(207)).setAttribute("onchange","" );
      ((Element)v.get(207)).setAttribute("req","N" );
      ((Element)v.get(207)).setAttribute("size","1" );
      ((Element)v.get(207)).setAttribute("valor","" );
      ((Element)v.get(207)).setAttribute("validacion","" );
      ((Element)v.get(207)).setAttribute("disabled","" );
      ((Element)v.get(207)).setAttribute("onblur","" );
      ((Element)v.get(207)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',7, true)" );
      ((Element)v.get(207)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 7, false)" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:208 / Elemento padre: 199   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(208)).setAttribute("nombre","indSujeFletGapTdId" );
      ((Element)v.get(208)).setAttribute("nowrap","true" );
      ((Element)v.get(208)).setAttribute("class","datosCampos" );
      ((Element)v.get(199)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","25" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 199   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(210)).setAttribute("width","100%" );
      ((Element)v.get(199)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:194   */

      /* Empieza nodo:212 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(212)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(52)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(213)).setAttribute("align","center" );
      ((Element)v.get(213)).setAttribute("width","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","12" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 212   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(212)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","8" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 212   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(217)).setAttribute("align","center" );
      ((Element)v.get(217)).setAttribute("width","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","12" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:212   */

      /* Empieza nodo:219 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(219)).setAttribute("nombre","formTr6" );
      ((Element)v.get(52)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(220)).setAttribute("align","center" );
      ((Element)v.get(220)).setAttribute("width","8" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","8" );
      ((Element)v.get(221)).setAttribute("height","12" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 219   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(222)).setAttribute("width","100%" );
      ((Element)v.get(219)).appendChild((Element)v.get(222));

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
      ((Element)v.get(224)).setAttribute("align","left" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(225)).setAttribute("nombre","indReseStocTdId" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));

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
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(228)).setAttribute("valign","top" );
      ((Element)v.get(228)).setAttribute("height","13" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(229)).setAttribute("nombre","lblIndReseStoc" );
      ((Element)v.get(229)).setAttribute("alto","13" );
      ((Element)v.get(229)).setAttribute("filas","1" );
      ((Element)v.get(229)).setAttribute("id","datosTitle" );
      ((Element)v.get(229)).setAttribute("cod","PedTipoSolicPais.indReseStoc.label" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:230 / Elemento padre: 226   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(230)).setAttribute("nombre","indReseStocWidgetTrId" );
      ((Element)v.get(226)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(231)).setAttribute("align","left" );
      ((Element)v.get(231)).setAttribute("nowrap","true" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(232)).setAttribute("nombre","indReseStoc" );
      ((Element)v.get(232)).setAttribute("id","datosCampos" );
      ((Element)v.get(232)).setAttribute("trim","S" );
      ((Element)v.get(232)).setAttribute("max","1" );
      ((Element)v.get(232)).setAttribute("onchange","" );
      ((Element)v.get(232)).setAttribute("req","N" );
      ((Element)v.get(232)).setAttribute("size","1" );
      ((Element)v.get(232)).setAttribute("valor","" );
      ((Element)v.get(232)).setAttribute("validacion","" );
      ((Element)v.get(232)).setAttribute("disabled","" );
      ((Element)v.get(232)).setAttribute("onblur","" );
      ((Element)v.get(232)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',8, true)" );
      ((Element)v.get(232)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 8, false)" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:233 / Elemento padre: 224   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(233)).setAttribute("nombre","indReseStocGapTdId" );
      ((Element)v.get(233)).setAttribute("nowrap","true" );
      ((Element)v.get(233)).setAttribute("class","datosCampos" );
      ((Element)v.get(224)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","25" );
      ((Element)v.get(234)).setAttribute("height","8" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 224   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(235)).setAttribute("width","100%" );
      ((Element)v.get(224)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(236)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:219   */

      /* Empieza nodo:237 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(237)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(52)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(238)).setAttribute("align","center" );
      ((Element)v.get(238)).setAttribute("width","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(239)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).setAttribute("width","12" );
      ((Element)v.get(239)).setAttribute("height","8" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(237)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(241)).setAttribute("src","b.gif" );
      ((Element)v.get(241)).setAttribute("width","8" );
      ((Element)v.get(241)).setAttribute("height","8" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(242)).setAttribute("align","center" );
      ((Element)v.get(242)).setAttribute("width","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","12" );
      ((Element)v.get(243)).setAttribute("height","8" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:237   */

      /* Empieza nodo:244 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(244)).setAttribute("nombre","formTr7" );
      ((Element)v.get(52)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(245)).setAttribute("align","center" );
      ((Element)v.get(245)).setAttribute("width","8" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("width","8" );
      ((Element)v.get(246)).setAttribute("height","12" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 244   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(247)).setAttribute("width","100%" );
      ((Element)v.get(244)).appendChild((Element)v.get(247));

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
      ((Element)v.get(249)).setAttribute("align","left" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(250)).setAttribute("nombre","indPermReveTdId" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));

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
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(253)).setAttribute("valign","top" );
      ((Element)v.get(253)).setAttribute("height","13" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(254)).setAttribute("nombre","lblIndPermReve" );
      ((Element)v.get(254)).setAttribute("alto","13" );
      ((Element)v.get(254)).setAttribute("filas","1" );
      ((Element)v.get(254)).setAttribute("id","datosTitle" );
      ((Element)v.get(254)).setAttribute("cod","PedTipoSolicPais.indPermReve.label" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:255 / Elemento padre: 251   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(255)).setAttribute("nombre","indPermReveWidgetTrId" );
      ((Element)v.get(251)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(256)).setAttribute("align","left" );
      ((Element)v.get(256)).setAttribute("nowrap","true" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(257)).setAttribute("nombre","indPermReve" );
      ((Element)v.get(257)).setAttribute("id","datosCampos" );
      ((Element)v.get(257)).setAttribute("trim","S" );
      ((Element)v.get(257)).setAttribute("max","1" );
      ((Element)v.get(257)).setAttribute("onchange","" );
      ((Element)v.get(257)).setAttribute("req","N" );
      ((Element)v.get(257)).setAttribute("size","1" );
      ((Element)v.get(257)).setAttribute("valor","" );
      ((Element)v.get(257)).setAttribute("validacion","" );
      ((Element)v.get(257)).setAttribute("disabled","" );
      ((Element)v.get(257)).setAttribute("onblur","" );
      ((Element)v.get(257)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',9, true)" );
      ((Element)v.get(257)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 9, false)" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:258 / Elemento padre: 249   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(258)).setAttribute("nombre","indPermReveGapTdId" );
      ((Element)v.get(258)).setAttribute("nowrap","true" );
      ((Element)v.get(258)).setAttribute("class","datosCampos" );
      ((Element)v.get(249)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","25" );
      ((Element)v.get(259)).setAttribute("height","8" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 249   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(260)).setAttribute("width","100%" );
      ((Element)v.get(249)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:244   */

      /* Empieza nodo:262 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(262)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(52)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(263)).setAttribute("align","center" );
      ((Element)v.get(263)).setAttribute("width","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).setAttribute("width","12" );
      ((Element)v.get(264)).setAttribute("height","8" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 262   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(262)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","8" );
      ((Element)v.get(266)).setAttribute("height","8" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 262   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(267)).setAttribute("align","center" );
      ((Element)v.get(267)).setAttribute("width","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","12" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:262   */

      /* Empieza nodo:269 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(269)).setAttribute("nombre","formTr8" );
      ((Element)v.get(52)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(270)).setAttribute("align","center" );
      ((Element)v.get(270)).setAttribute("width","8" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","8" );
      ((Element)v.get(271)).setAttribute("height","12" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 269   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(272)).setAttribute("width","100%" );
      ((Element)v.get(269)).appendChild((Element)v.get(272));

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
      ((Element)v.get(274)).setAttribute("align","left" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(275)).setAttribute("nombre","indPediPrueTdId" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));

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
      ((Element)v.get(276)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(278)).setAttribute("valign","top" );
      ((Element)v.get(278)).setAttribute("height","13" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(279)).setAttribute("nombre","lblIndPediPrue" );
      ((Element)v.get(279)).setAttribute("alto","13" );
      ((Element)v.get(279)).setAttribute("filas","1" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(279)).setAttribute("id","datosTitle" );
      ((Element)v.get(279)).setAttribute("cod","PedTipoSolicPais.indPediPrue.label" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:280 / Elemento padre: 276   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(280)).setAttribute("nombre","indPediPrueWidgetTrId" );
      ((Element)v.get(276)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(281)).setAttribute("align","left" );
      ((Element)v.get(281)).setAttribute("nowrap","true" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(282)).setAttribute("nombre","indPediPrue" );
      ((Element)v.get(282)).setAttribute("id","datosCampos" );
      ((Element)v.get(282)).setAttribute("trim","S" );
      ((Element)v.get(282)).setAttribute("max","1" );
      ((Element)v.get(282)).setAttribute("onchange","" );
      ((Element)v.get(282)).setAttribute("req","N" );
      ((Element)v.get(282)).setAttribute("size","1" );
      ((Element)v.get(282)).setAttribute("valor","" );
      ((Element)v.get(282)).setAttribute("validacion","" );
      ((Element)v.get(282)).setAttribute("disabled","" );
      ((Element)v.get(282)).setAttribute("onblur","" );
      ((Element)v.get(282)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',10, true)" );
      ((Element)v.get(282)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 10, false)" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */
      /* Termina nodo:280   */
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:283 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(283)).setAttribute("nombre","indPediPrueGapTdId" );
      ((Element)v.get(283)).setAttribute("nowrap","true" );
      ((Element)v.get(283)).setAttribute("class","datosCampos" );
      ((Element)v.get(274)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","25" );
      ((Element)v.get(284)).setAttribute("height","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(285)).setAttribute("width","100%" );
      ((Element)v.get(274)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(286)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:269   */

      /* Empieza nodo:287 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(287)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(52)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(288)).setAttribute("align","center" );
      ((Element)v.get(288)).setAttribute("width","8" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","12" );
      ((Element)v.get(289)).setAttribute("height","8" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 287   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(287)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(291)).setAttribute("src","b.gif" );
      ((Element)v.get(291)).setAttribute("width","8" );
      ((Element)v.get(291)).setAttribute("height","8" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 287   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(292)).setAttribute("align","center" );
      ((Element)v.get(292)).setAttribute("width","8" );
      ((Element)v.get(287)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","12" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */
      /* Termina nodo:287   */

      /* Empieza nodo:294 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(294)).setAttribute("nombre","formTr9" );
      ((Element)v.get(52)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(295)).setAttribute("align","center" );
      ((Element)v.get(295)).setAttribute("width","8" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(296)).setAttribute("width","8" );
      ((Element)v.get(296)).setAttribute("height","12" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 294   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(297)).setAttribute("width","100%" );
      ((Element)v.get(294)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(298)).setAttribute("width","100%" );
      ((Element)v.get(298)).setAttribute("border","0" );
      ((Element)v.get(298)).setAttribute("cellspacing","0" );
      ((Element)v.get(298)).setAttribute("cellpadding","0" );
      ((Element)v.get(298)).setAttribute("align","left" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(299)).setAttribute("align","left" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(300)).setAttribute("nombre","indComiTdId" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(301)).setAttribute("width","100%" );
      ((Element)v.get(301)).setAttribute("border","0" );
      ((Element)v.get(301)).setAttribute("cellspacing","0" );
      ((Element)v.get(301)).setAttribute("cellpadding","0" );
      ((Element)v.get(301)).setAttribute("align","left" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(301)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(303)).setAttribute("valign","top" );
      ((Element)v.get(303)).setAttribute("height","13" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(304)).setAttribute("nombre","lblIndComi" );
      ((Element)v.get(304)).setAttribute("alto","13" );
      ((Element)v.get(304)).setAttribute("filas","1" );
      ((Element)v.get(304)).setAttribute("id","datosTitle" );
      ((Element)v.get(304)).setAttribute("cod","PedTipoSolicPais.indComi.label" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:305 / Elemento padre: 301   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(305)).setAttribute("nombre","indComiWidgetTrId" );
      ((Element)v.get(301)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(306)).setAttribute("align","left" );
      ((Element)v.get(306)).setAttribute("nowrap","true" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(307)).setAttribute("nombre","indComi" );
      ((Element)v.get(307)).setAttribute("id","datosCampos" );
      ((Element)v.get(307)).setAttribute("trim","S" );
      ((Element)v.get(307)).setAttribute("max","1" );
      ((Element)v.get(307)).setAttribute("onchange","" );
      ((Element)v.get(307)).setAttribute("req","N" );
      ((Element)v.get(307)).setAttribute("size","1" );
      ((Element)v.get(307)).setAttribute("valor","" );
      ((Element)v.get(307)).setAttribute("validacion","" );
      ((Element)v.get(307)).setAttribute("disabled","" );
      ((Element)v.get(307)).setAttribute("onblur","" );
      ((Element)v.get(307)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',11, true)" );
      ((Element)v.get(307)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 11, false)" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */
      /* Termina nodo:305   */
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:308 / Elemento padre: 299   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(308)).setAttribute("nombre","indComiGapTdId" );
      ((Element)v.get(308)).setAttribute("nowrap","true" );
      ((Element)v.get(308)).setAttribute("class","datosCampos" );
      ((Element)v.get(299)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","25" );
      ((Element)v.get(309)).setAttribute("height","8" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 299   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(310)).setAttribute("width","100%" );
      ((Element)v.get(299)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:297   */
      /* Termina nodo:294   */

      /* Empieza nodo:312 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(312)).setAttribute("nombre","formGapTr9" );
      ((Element)v.get(52)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(313)).setAttribute("align","center" );
      ((Element)v.get(313)).setAttribute("width","8" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(314)).setAttribute("src","b.gif" );
      ((Element)v.get(314)).setAttribute("width","12" );
      ((Element)v.get(314)).setAttribute("height","8" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 312   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(312)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","8" );
      ((Element)v.get(316)).setAttribute("height","8" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 312   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(317)).setAttribute("align","center" );
      ((Element)v.get(317)).setAttribute("width","8" );
      ((Element)v.get(312)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(318)).setAttribute("width","12" );
      ((Element)v.get(318)).setAttribute("height","8" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */
      /* Termina nodo:312   */

      /* Empieza nodo:319 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(319)).setAttribute("nombre","formTr10" );
      ((Element)v.get(52)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(320)).setAttribute("align","center" );
      ((Element)v.get(320)).setAttribute("width","8" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(321)).setAttribute("src","b.gif" );
      ((Element)v.get(321)).setAttribute("width","8" );
      ((Element)v.get(321)).setAttribute("height","12" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:322 / Elemento padre: 319   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(322)).setAttribute("width","100%" );
      ((Element)v.get(319)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(323)).setAttribute("width","100%" );
      ((Element)v.get(323)).setAttribute("border","0" );
      ((Element)v.get(323)).setAttribute("cellspacing","0" );
      ((Element)v.get(323)).setAttribute("cellpadding","0" );
      ((Element)v.get(323)).setAttribute("align","left" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(324)).setAttribute("align","left" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(325)).setAttribute("nombre","indVentInteSab14TdId" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(326)).setAttribute("width","100%" );
      ((Element)v.get(326)).setAttribute("border","0" );
      ((Element)v.get(326)).setAttribute("cellspacing","0" );
      ((Element)v.get(326)).setAttribute("cellpadding","0" );
      ((Element)v.get(326)).setAttribute("align","left" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(328)).setAttribute("valign","top" );
      ((Element)v.get(328)).setAttribute("height","13" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(329)).setAttribute("nombre","lblIndVentInteSab14" );
      ((Element)v.get(329)).setAttribute("alto","13" );
      ((Element)v.get(329)).setAttribute("filas","1" );
      ((Element)v.get(329)).setAttribute("id","datosTitle" );
      ((Element)v.get(329)).setAttribute("cod","PedTipoSolicPais.indVentInteSab14.label" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:330 / Elemento padre: 326   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(330)).setAttribute("nombre","indVentInteSab14WidgetTrId" );
      ((Element)v.get(326)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(331)).setAttribute("align","left" );
      ((Element)v.get(331)).setAttribute("nowrap","true" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(332)).setAttribute("nombre","indVentInteSab14" );
      ((Element)v.get(332)).setAttribute("id","datosCampos" );
      ((Element)v.get(332)).setAttribute("trim","S" );
      ((Element)v.get(332)).setAttribute("max","1" );
      ((Element)v.get(332)).setAttribute("onchange","" );
      ((Element)v.get(332)).setAttribute("req","N" );
      ((Element)v.get(332)).setAttribute("size","1" );
      ((Element)v.get(332)).setAttribute("valor","" );
      ((Element)v.get(332)).setAttribute("validacion","" );
      ((Element)v.get(332)).setAttribute("disabled","" );
      ((Element)v.get(332)).setAttribute("onblur","" );
      ((Element)v.get(332)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',12, true)" );
      ((Element)v.get(332)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 12, false)" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:333 / Elemento padre: 324   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(333)).setAttribute("nombre","indVentInteSab14GapTdId" );
      ((Element)v.get(333)).setAttribute("nowrap","true" );
      ((Element)v.get(333)).setAttribute("class","datosCampos" );
      ((Element)v.get(324)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","25" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 324   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(335)).setAttribute("width","100%" );
      ((Element)v.get(324)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */
      /* Termina nodo:324   */
      /* Termina nodo:323   */
      /* Termina nodo:322   */
      /* Termina nodo:319   */

      /* Empieza nodo:337 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(337)).setAttribute("nombre","formGapTr10" );
      ((Element)v.get(52)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(338)).setAttribute("align","center" );
      ((Element)v.get(338)).setAttribute("width","8" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(339)).setAttribute("src","b.gif" );
      ((Element)v.get(339)).setAttribute("width","12" );
      ((Element)v.get(339)).setAttribute("height","8" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:338   */

      /* Empieza nodo:340 / Elemento padre: 337   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(337)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(341)).setAttribute("src","b.gif" );
      ((Element)v.get(341)).setAttribute("width","8" );
      ((Element)v.get(341)).setAttribute("height","8" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:342 / Elemento padre: 337   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(342)).setAttribute("align","center" );
      ((Element)v.get(342)).setAttribute("width","8" );
      ((Element)v.get(337)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).setAttribute("width","12" );
      ((Element)v.get(343)).setAttribute("height","8" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */
      /* Termina nodo:337   */

      /* Empieza nodo:344 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(344)).setAttribute("nombre","formTr11" );
      ((Element)v.get(52)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(345)).setAttribute("align","center" );
      ((Element)v.get(345)).setAttribute("width","8" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(346)).setAttribute("src","b.gif" );
      ((Element)v.get(346)).setAttribute("width","8" );
      ((Element)v.get(346)).setAttribute("height","12" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 344   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(347)).setAttribute("width","100%" );
      ((Element)v.get(344)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(348)).setAttribute("width","100%" );
      ((Element)v.get(348)).setAttribute("border","0" );
      ((Element)v.get(348)).setAttribute("cellspacing","0" );
      ((Element)v.get(348)).setAttribute("cellpadding","0" );
      ((Element)v.get(348)).setAttribute("align","left" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(349)).setAttribute("align","left" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(350)).setAttribute("nombre","cactOidActiTdId" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(351)).setAttribute("border","0" );
      ((Element)v.get(351)).setAttribute("cellspacing","0" );
      ((Element)v.get(351)).setAttribute("cellpadding","0" );
      ((Element)v.get(351)).setAttribute("align","left" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(353)).setAttribute("valign","top" );
      ((Element)v.get(353)).setAttribute("height","13" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(354)).setAttribute("nombre","lblcactOidActi" );
      ((Element)v.get(354)).setAttribute("id","datosTitle" );
      ((Element)v.get(354)).setAttribute("ancho","150" );
      ((Element)v.get(354)).setAttribute("alto","13" );
      ((Element)v.get(354)).setAttribute("cod","PedTipoSolicPais.cactOidActi.label" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:355 / Elemento padre: 351   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(355)).setAttribute("nombre","cactOidActiWidgetTrId" );
      ((Element)v.get(351)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(356)).setAttribute("align","left" );
      ((Element)v.get(356)).setAttribute("nowrap","true" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(357)).setAttribute("nombre","cactOidActi" );
      ((Element)v.get(357)).setAttribute("id","datosCampos" );
      ((Element)v.get(357)).setAttribute("multiple","N" );
      ((Element)v.get(357)).setAttribute("req","N" );
      ((Element)v.get(357)).setAttribute("size","1" );
      ((Element)v.get(357)).setAttribute("disabled","" );
      ((Element)v.get(357)).setAttribute("validacion","" );
      ((Element)v.get(357)).setAttribute("onchange","" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(357)).setAttribute("onfocus","" );
      ((Element)v.get(357)).setAttribute("valorinicial","" );
      ((Element)v.get(357)).setAttribute("textoinicial","" );
      ((Element)v.get(357)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',13, true);" );
      ((Element)v.get(357)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',13, false);" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:355   */
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:359 / Elemento padre: 349   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(359)).setAttribute("nombre","cactOidActiGapTdId" );
      ((Element)v.get(359)).setAttribute("nowrap","true" );
      ((Element)v.get(359)).setAttribute("class","datosCampos" );
      ((Element)v.get(349)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(360)).setAttribute("src","b.gif" );
      ((Element)v.get(360)).setAttribute("width","25" );
      ((Element)v.get(360)).setAttribute("height","8" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:361 / Elemento padre: 349   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(361)).setAttribute("width","100%" );
      ((Element)v.get(349)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:349   */
      /* Termina nodo:348   */
      /* Termina nodo:347   */
      /* Termina nodo:344   */

      /* Empieza nodo:363 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(363)).setAttribute("nombre","formGapTr11" );
      ((Element)v.get(52)).appendChild((Element)v.get(363));

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

      /* Empieza nodo:370 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(370)).setAttribute("nombre","formTr12" );
      ((Element)v.get(52)).appendChild((Element)v.get(370));

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
      ((Element)v.get(376)).setAttribute("nombre","moneOidMoneTdId" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(377)).setAttribute("border","0" );
      ((Element)v.get(377)).setAttribute("cellspacing","0" );
      ((Element)v.get(377)).setAttribute("cellpadding","0" );
      ((Element)v.get(377)).setAttribute("align","left" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(379)).setAttribute("valign","top" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(379)).setAttribute("height","13" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(380)).setAttribute("nombre","lblmoneOidMone" );
      ((Element)v.get(380)).setAttribute("id","datosTitle" );
      ((Element)v.get(380)).setAttribute("ancho","150" );
      ((Element)v.get(380)).setAttribute("alto","13" );
      ((Element)v.get(380)).setAttribute("cod","PedTipoSolicPais.moneOidMone.label" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:381 / Elemento padre: 377   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(381)).setAttribute("nombre","moneOidMoneWidgetTrId" );
      ((Element)v.get(377)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(382)).setAttribute("align","left" );
      ((Element)v.get(382)).setAttribute("nowrap","true" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(383)).setAttribute("nombre","moneOidMone" );
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
      ((Element)v.get(383)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',14, true);" );
      ((Element)v.get(383)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',14, false);" );
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

      /* Empieza nodo:385 / Elemento padre: 375   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(385)).setAttribute("nombre","moneOidMoneGapTdId" );
      ((Element)v.get(385)).setAttribute("nowrap","true" );
      ((Element)v.get(385)).setAttribute("class","datosCampos" );
      ((Element)v.get(375)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(386)).setAttribute("src","b.gif" );
      ((Element)v.get(386)).setAttribute("width","25" );
      ((Element)v.get(386)).setAttribute("height","8" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */
      /* Termina nodo:385   */

      /* Empieza nodo:387 / Elemento padre: 375   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(387)).setAttribute("width","100%" );
      ((Element)v.get(375)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(388)).setAttribute("src","b.gif" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */
      /* Termina nodo:387   */
      /* Termina nodo:375   */
      /* Termina nodo:374   */
      /* Termina nodo:373   */
      /* Termina nodo:370   */

      /* Empieza nodo:389 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(389)).setAttribute("nombre","formGapTr12" );
      ((Element)v.get(52)).appendChild((Element)v.get(389));

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

      /* Empieza nodo:396 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(396)).setAttribute("nombre","formTr13" );
      ((Element)v.get(52)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(397)).setAttribute("align","center" );
      ((Element)v.get(397)).setAttribute("width","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(398)).setAttribute("src","b.gif" );
      ((Element)v.get(398)).setAttribute("width","8" );
      ((Element)v.get(398)).setAttribute("height","12" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:399 / Elemento padre: 396   */
      v.add(doc.createElement("TD"));
   }

   private void getXML1800(Document doc) {
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
      ((Element)v.get(402)).setAttribute("nombre","tmalOidTipoMoviAsigTdId" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("TABLE"));
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
      ((Element)v.get(406)).setAttribute("nombre","lbltmalOidTipoMoviAsig" );
      ((Element)v.get(406)).setAttribute("id","datosTitle" );
      ((Element)v.get(406)).setAttribute("ancho","150" );
      ((Element)v.get(406)).setAttribute("alto","13" );
      ((Element)v.get(406)).setAttribute("cod","PedTipoSolicPais.tmalOidTipoMoviAsig.label" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:407 / Elemento padre: 403   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(407)).setAttribute("nombre","tmalOidTipoMoviAsigWidgetTrId" );
      ((Element)v.get(403)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(408)).setAttribute("align","left" );
      ((Element)v.get(408)).setAttribute("nowrap","true" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(409)).setAttribute("nombre","tmalOidTipoMoviAsig" );
      ((Element)v.get(409)).setAttribute("id","datosCampos" );
      ((Element)v.get(409)).setAttribute("multiple","N" );
      ((Element)v.get(409)).setAttribute("req","N" );
      ((Element)v.get(409)).setAttribute("size","1" );
      ((Element)v.get(409)).setAttribute("disabled","" );
      ((Element)v.get(409)).setAttribute("validacion","" );
      ((Element)v.get(409)).setAttribute("onchange","" );
      ((Element)v.get(409)).setAttribute("onfocus","" );
      ((Element)v.get(409)).setAttribute("valorinicial","" );
      ((Element)v.get(409)).setAttribute("textoinicial","" );
      ((Element)v.get(409)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',15, true);" );
      ((Element)v.get(409)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',15, false);" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */
      /* Termina nodo:408   */
      /* Termina nodo:407   */
      /* Termina nodo:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:411 / Elemento padre: 401   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(411)).setAttribute("nombre","tmalOidTipoMoviAsigGapTdId" );
      ((Element)v.get(411)).setAttribute("nowrap","true" );
      ((Element)v.get(411)).setAttribute("class","datosCampos" );
      ((Element)v.get(401)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(412)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).setAttribute("width","25" );
      ((Element)v.get(412)).setAttribute("height","8" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */

      /* Empieza nodo:413 / Elemento padre: 401   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(413)).setAttribute("width","100%" );
      ((Element)v.get(401)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(414)).setAttribute("src","b.gif" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */
      /* Termina nodo:401   */
      /* Termina nodo:400   */
      /* Termina nodo:399   */
      /* Termina nodo:396   */

      /* Empieza nodo:415 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(415)).setAttribute("nombre","formGapTr13" );
      ((Element)v.get(52)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(416)).setAttribute("align","center" );
      ((Element)v.get(416)).setAttribute("width","8" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(417)).setAttribute("src","b.gif" );
      ((Element)v.get(417)).setAttribute("width","12" );
      ((Element)v.get(417)).setAttribute("height","8" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */

      /* Empieza nodo:418 / Elemento padre: 415   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(415)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(419)).setAttribute("src","b.gif" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(419)).setAttribute("width","8" );
      ((Element)v.get(419)).setAttribute("height","8" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:420 / Elemento padre: 415   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(420)).setAttribute("align","center" );
      ((Element)v.get(420)).setAttribute("width","8" );
      ((Element)v.get(415)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(421)).setAttribute("src","b.gif" );
      ((Element)v.get(421)).setAttribute("width","12" );
      ((Element)v.get(421)).setAttribute("height","8" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */
      /* Termina nodo:415   */

      /* Empieza nodo:422 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(422)).setAttribute("nombre","formTr14" );
      ((Element)v.get(52)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(423)).setAttribute("align","center" );
      ((Element)v.get(423)).setAttribute("width","8" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(424)).setAttribute("src","b.gif" );
      ((Element)v.get(424)).setAttribute("width","8" );
      ((Element)v.get(424)).setAttribute("height","12" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:423   */

      /* Empieza nodo:425 / Elemento padre: 422   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(425)).setAttribute("width","100%" );
      ((Element)v.get(422)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(426)).setAttribute("width","100%" );
      ((Element)v.get(426)).setAttribute("border","0" );
      ((Element)v.get(426)).setAttribute("cellspacing","0" );
      ((Element)v.get(426)).setAttribute("cellpadding","0" );
      ((Element)v.get(426)).setAttribute("align","left" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(427)).setAttribute("align","left" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(428)).setAttribute("nombre","tmalOidTipoMoviReseTdId" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(429)).setAttribute("border","0" );
      ((Element)v.get(429)).setAttribute("cellspacing","0" );
      ((Element)v.get(429)).setAttribute("cellpadding","0" );
      ((Element)v.get(429)).setAttribute("align","left" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(429)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(431)).setAttribute("valign","top" );
      ((Element)v.get(431)).setAttribute("height","13" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(432)).setAttribute("nombre","lbltmalOidTipoMoviRese" );
      ((Element)v.get(432)).setAttribute("id","datosTitle" );
      ((Element)v.get(432)).setAttribute("ancho","150" );
      ((Element)v.get(432)).setAttribute("alto","13" );
      ((Element)v.get(432)).setAttribute("cod","PedTipoSolicPais.tmalOidTipoMoviRese.label" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:431   */
      /* Termina nodo:430   */

      /* Empieza nodo:433 / Elemento padre: 429   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(433)).setAttribute("nombre","tmalOidTipoMoviReseWidgetTrId" );
      ((Element)v.get(429)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(434)).setAttribute("align","left" );
      ((Element)v.get(434)).setAttribute("nowrap","true" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(435)).setAttribute("nombre","tmalOidTipoMoviRese" );
      ((Element)v.get(435)).setAttribute("id","datosCampos" );
      ((Element)v.get(435)).setAttribute("multiple","N" );
      ((Element)v.get(435)).setAttribute("req","N" );
      ((Element)v.get(435)).setAttribute("size","1" );
      ((Element)v.get(435)).setAttribute("disabled","" );
      ((Element)v.get(435)).setAttribute("validacion","" );
      ((Element)v.get(435)).setAttribute("onchange","" );
      ((Element)v.get(435)).setAttribute("onfocus","" );
      ((Element)v.get(435)).setAttribute("valorinicial","" );
      ((Element)v.get(435)).setAttribute("textoinicial","" );
      ((Element)v.get(435)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',16, true);" );
      ((Element)v.get(435)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',16, false);" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(435)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */
      /* Termina nodo:435   */
      /* Termina nodo:434   */
      /* Termina nodo:433   */
      /* Termina nodo:429   */
      /* Termina nodo:428   */

      /* Empieza nodo:437 / Elemento padre: 427   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(437)).setAttribute("nombre","tmalOidTipoMoviReseGapTdId" );
      ((Element)v.get(437)).setAttribute("nowrap","true" );
      ((Element)v.get(437)).setAttribute("class","datosCampos" );
      ((Element)v.get(427)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(438)).setAttribute("src","b.gif" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(438)).setAttribute("width","25" );
      ((Element)v.get(438)).setAttribute("height","8" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:437   */

      /* Empieza nodo:439 / Elemento padre: 427   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(439)).setAttribute("width","100%" );
      ((Element)v.get(427)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(440)).setAttribute("src","b.gif" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:439   */
      /* Termina nodo:427   */
      /* Termina nodo:426   */
      /* Termina nodo:425   */
      /* Termina nodo:422   */

      /* Empieza nodo:441 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(441)).setAttribute("nombre","formGapTr14" );
      ((Element)v.get(52)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(442)).setAttribute("align","center" );
      ((Element)v.get(442)).setAttribute("width","8" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(443)).setAttribute("src","b.gif" );
      ((Element)v.get(443)).setAttribute("width","12" );
      ((Element)v.get(443)).setAttribute("height","8" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:442   */

      /* Empieza nodo:444 / Elemento padre: 441   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(441)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(445)).setAttribute("src","b.gif" );
      ((Element)v.get(445)).setAttribute("width","8" );
      ((Element)v.get(445)).setAttribute("height","8" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:444   */

      /* Empieza nodo:446 / Elemento padre: 441   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(446)).setAttribute("align","center" );
      ((Element)v.get(446)).setAttribute("width","8" );
      ((Element)v.get(441)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(447)).setAttribute("src","b.gif" );
      ((Element)v.get(447)).setAttribute("width","12" );
      ((Element)v.get(447)).setAttribute("height","8" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */
      /* Termina nodo:441   */

      /* Empieza nodo:448 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(448)).setAttribute("nombre","formTr15" );
      ((Element)v.get(52)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(449)).setAttribute("align","center" );
      ((Element)v.get(449)).setAttribute("width","8" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(450)).setAttribute("src","b.gif" );
      ((Element)v.get(450)).setAttribute("width","8" );
      ((Element)v.get(450)).setAttribute("height","12" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:449   */

      /* Empieza nodo:451 / Elemento padre: 448   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(451)).setAttribute("width","100%" );
      ((Element)v.get(448)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(452)).setAttribute("width","100%" );
      ((Element)v.get(452)).setAttribute("border","0" );
      ((Element)v.get(452)).setAttribute("cellspacing","0" );
      ((Element)v.get(452)).setAttribute("cellpadding","0" );
      ((Element)v.get(452)).setAttribute("align","left" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(453)).setAttribute("align","left" );
      ((Element)v.get(452)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(454)).setAttribute("nombre","tmalOidTipoMoviFactTdId" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(455)).setAttribute("border","0" );
      ((Element)v.get(455)).setAttribute("cellspacing","0" );
      ((Element)v.get(455)).setAttribute("cellpadding","0" );
      ((Element)v.get(455)).setAttribute("align","left" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(455)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(457)).setAttribute("valign","top" );
      ((Element)v.get(457)).setAttribute("height","13" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(458)).setAttribute("nombre","lbltmalOidTipoMoviFact" );
      ((Element)v.get(458)).setAttribute("id","datosTitle" );
      ((Element)v.get(458)).setAttribute("ancho","150" );
      ((Element)v.get(458)).setAttribute("alto","13" );
      ((Element)v.get(458)).setAttribute("cod","PedTipoSolicPais.tmalOidTipoMoviFact.label" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:457   */
      /* Termina nodo:456   */

      /* Empieza nodo:459 / Elemento padre: 455   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(459)).setAttribute("nombre","tmalOidTipoMoviFactWidgetTrId" );
      ((Element)v.get(455)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(460)).setAttribute("align","left" );
      ((Element)v.get(460)).setAttribute("nowrap","true" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(459)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(461)).setAttribute("nombre","tmalOidTipoMoviFact" );
      ((Element)v.get(461)).setAttribute("id","datosCampos" );
      ((Element)v.get(461)).setAttribute("multiple","N" );
      ((Element)v.get(461)).setAttribute("req","N" );
      ((Element)v.get(461)).setAttribute("size","1" );
      ((Element)v.get(461)).setAttribute("disabled","" );
      ((Element)v.get(461)).setAttribute("validacion","" );
      ((Element)v.get(461)).setAttribute("onchange","" );
      ((Element)v.get(461)).setAttribute("onfocus","" );
      ((Element)v.get(461)).setAttribute("valorinicial","" );
      ((Element)v.get(461)).setAttribute("textoinicial","" );
      ((Element)v.get(461)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',17, true);" );
      ((Element)v.get(461)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',17, false);" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(461)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */
      /* Termina nodo:461   */
      /* Termina nodo:460   */
      /* Termina nodo:459   */
      /* Termina nodo:455   */
      /* Termina nodo:454   */

      /* Empieza nodo:463 / Elemento padre: 453   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(463)).setAttribute("nombre","tmalOidTipoMoviFactGapTdId" );
      ((Element)v.get(463)).setAttribute("nowrap","true" );
      ((Element)v.get(463)).setAttribute("class","datosCampos" );
      ((Element)v.get(453)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(464)).setAttribute("src","b.gif" );
      ((Element)v.get(464)).setAttribute("width","25" );
      ((Element)v.get(464)).setAttribute("height","8" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */
      /* Termina nodo:463   */

      /* Empieza nodo:465 / Elemento padre: 453   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(465)).setAttribute("width","100%" );
      ((Element)v.get(453)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(466)).setAttribute("src","b.gif" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */
      /* Termina nodo:465   */
      /* Termina nodo:453   */
      /* Termina nodo:452   */
      /* Termina nodo:451   */
      /* Termina nodo:448   */

      /* Empieza nodo:467 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(467)).setAttribute("nombre","formGapTr15" );
      ((Element)v.get(52)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(468)).setAttribute("align","center" );
      ((Element)v.get(468)).setAttribute("width","8" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(469)).setAttribute("src","b.gif" );
      ((Element)v.get(469)).setAttribute("width","12" );
      ((Element)v.get(469)).setAttribute("height","8" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */

      /* Empieza nodo:470 / Elemento padre: 467   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(467)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(471)).setAttribute("src","b.gif" );
      ((Element)v.get(471)).setAttribute("width","8" );
      ((Element)v.get(471)).setAttribute("height","8" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */
      /* Termina nodo:470   */

      /* Empieza nodo:472 / Elemento padre: 467   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(472)).setAttribute("align","center" );
      ((Element)v.get(472)).setAttribute("width","8" );
      ((Element)v.get(467)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(473)).setAttribute("src","b.gif" );
      ((Element)v.get(473)).setAttribute("width","12" );
      ((Element)v.get(473)).setAttribute("height","8" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:472   */
      /* Termina nodo:467   */

      /* Empieza nodo:474 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(474)).setAttribute("nombre","formTr16" );
      ((Element)v.get(52)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(475)).setAttribute("align","center" );
      ((Element)v.get(475)).setAttribute("width","8" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(476)).setAttribute("src","b.gif" );
      ((Element)v.get(476)).setAttribute("width","8" );
      ((Element)v.get(476)).setAttribute("height","12" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */

      /* Empieza nodo:477 / Elemento padre: 474   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(477)).setAttribute("width","100%" );
      ((Element)v.get(474)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(478)).setAttribute("width","100%" );
      ((Element)v.get(478)).setAttribute("border","0" );
      ((Element)v.get(478)).setAttribute("cellspacing","0" );
      ((Element)v.get(478)).setAttribute("cellpadding","0" );
      ((Element)v.get(478)).setAttribute("align","left" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(479)).setAttribute("align","left" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(480)).setAttribute("nombre","tidoOidTipoDocuTdId" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
   }

   private void getXML2160(Document doc) {
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(481)).setAttribute("border","0" );
      ((Element)v.get(481)).setAttribute("cellspacing","0" );
      ((Element)v.get(481)).setAttribute("cellpadding","0" );
      ((Element)v.get(481)).setAttribute("align","left" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(481)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(483)).setAttribute("valign","top" );
      ((Element)v.get(483)).setAttribute("height","13" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(484)).setAttribute("nombre","lbltidoOidTipoDocu" );
      ((Element)v.get(484)).setAttribute("id","datosTitle" );
      ((Element)v.get(484)).setAttribute("ancho","150" );
      ((Element)v.get(484)).setAttribute("alto","13" );
      ((Element)v.get(484)).setAttribute("cod","PedTipoSolicPais.tidoOidTipoDocu.label" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */
      /* Termina nodo:483   */
      /* Termina nodo:482   */

      /* Empieza nodo:485 / Elemento padre: 481   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(485)).setAttribute("nombre","tidoOidTipoDocuWidgetTrId" );
      ((Element)v.get(481)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(486)).setAttribute("align","left" );
      ((Element)v.get(486)).setAttribute("nowrap","true" );
      ((Element)v.get(485)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(487)).setAttribute("nombre","tidoOidTipoDocu" );
      ((Element)v.get(487)).setAttribute("id","datosCampos" );
      ((Element)v.get(487)).setAttribute("multiple","N" );
      ((Element)v.get(487)).setAttribute("req","N" );
      ((Element)v.get(487)).setAttribute("size","1" );
      ((Element)v.get(487)).setAttribute("disabled","" );
      ((Element)v.get(487)).setAttribute("validacion","" );
      ((Element)v.get(487)).setAttribute("onchange","" );
      ((Element)v.get(487)).setAttribute("onfocus","" );
      ((Element)v.get(487)).setAttribute("valorinicial","" );
      ((Element)v.get(487)).setAttribute("textoinicial","" );
      ((Element)v.get(487)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',18, true);" );
      ((Element)v.get(487)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',18, false);" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(487)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */
      /* Termina nodo:487   */
      /* Termina nodo:486   */
      /* Termina nodo:485   */
      /* Termina nodo:481   */
      /* Termina nodo:480   */

      /* Empieza nodo:489 / Elemento padre: 479   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(489)).setAttribute("nombre","tidoOidTipoDocuGapTdId" );
      ((Element)v.get(489)).setAttribute("nowrap","true" );
      ((Element)v.get(489)).setAttribute("class","datosCampos" );
      ((Element)v.get(479)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(490)).setAttribute("src","b.gif" );
      ((Element)v.get(490)).setAttribute("width","25" );
      ((Element)v.get(490)).setAttribute("height","8" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */
      /* Termina nodo:489   */

      /* Empieza nodo:491 / Elemento padre: 479   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(491)).setAttribute("width","100%" );
      ((Element)v.get(479)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(492)).setAttribute("src","b.gif" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */
      /* Termina nodo:491   */
      /* Termina nodo:479   */
      /* Termina nodo:478   */
      /* Termina nodo:477   */
      /* Termina nodo:474   */

      /* Empieza nodo:493 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(493)).setAttribute("nombre","formGapTr16" );
      ((Element)v.get(52)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(494)).setAttribute("align","center" );
      ((Element)v.get(494)).setAttribute("width","8" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(495)).setAttribute("src","b.gif" );
      ((Element)v.get(495)).setAttribute("width","12" );
      ((Element)v.get(495)).setAttribute("height","8" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:496 / Elemento padre: 493   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(493)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(497)).setAttribute("src","b.gif" );
      ((Element)v.get(497)).setAttribute("width","8" );
      ((Element)v.get(497)).setAttribute("height","8" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:498 / Elemento padre: 493   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(498)).setAttribute("align","center" );
      ((Element)v.get(498)).setAttribute("width","8" );
      ((Element)v.get(493)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(499)).setAttribute("src","b.gif" );
      ((Element)v.get(499)).setAttribute("width","12" );
      ((Element)v.get(499)).setAttribute("height","8" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */
      /* Termina nodo:498   */
      /* Termina nodo:493   */

      /* Empieza nodo:500 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(500)).setAttribute("nombre","formTr17" );
      ((Element)v.get(52)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
   }

   private void getXML2250(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(501)).setAttribute("align","center" );
      ((Element)v.get(501)).setAttribute("width","8" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(502)).setAttribute("src","b.gif" );
      ((Element)v.get(502)).setAttribute("width","8" );
      ((Element)v.get(502)).setAttribute("height","12" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */
      /* Termina nodo:501   */

      /* Empieza nodo:503 / Elemento padre: 500   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(503)).setAttribute("width","100%" );
      ((Element)v.get(500)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(504)).setAttribute("width","100%" );
      ((Element)v.get(504)).setAttribute("border","0" );
      ((Element)v.get(504)).setAttribute("cellspacing","0" );
      ((Element)v.get(504)).setAttribute("cellpadding","0" );
      ((Element)v.get(504)).setAttribute("align","left" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(505)).setAttribute("align","left" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(506)).setAttribute("nombre","indPermUnioTdId" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(507)).setAttribute("width","100%" );
      ((Element)v.get(507)).setAttribute("border","0" );
      ((Element)v.get(507)).setAttribute("cellspacing","0" );
      ((Element)v.get(507)).setAttribute("cellpadding","0" );
      ((Element)v.get(507)).setAttribute("align","left" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(507)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(509)).setAttribute("valign","top" );
      ((Element)v.get(509)).setAttribute("height","13" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(510)).setAttribute("nombre","lblIndPermUnio" );
      ((Element)v.get(510)).setAttribute("alto","13" );
      ((Element)v.get(510)).setAttribute("filas","1" );
      ((Element)v.get(510)).setAttribute("id","datosTitle" );
      ((Element)v.get(510)).setAttribute("cod","PedTipoSolicPais.indPermUnio.label" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:511 / Elemento padre: 507   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(511)).setAttribute("nombre","indPermUnioWidgetTrId" );
      ((Element)v.get(507)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(512)).setAttribute("align","left" );
      ((Element)v.get(512)).setAttribute("nowrap","true" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(513)).setAttribute("nombre","indPermUnio" );
      ((Element)v.get(513)).setAttribute("id","datosCampos" );
      ((Element)v.get(513)).setAttribute("trim","S" );
      ((Element)v.get(513)).setAttribute("max","1" );
      ((Element)v.get(513)).setAttribute("onchange","" );
      ((Element)v.get(513)).setAttribute("req","N" );
      ((Element)v.get(513)).setAttribute("size","1" );
      ((Element)v.get(513)).setAttribute("valor","" );
      ((Element)v.get(513)).setAttribute("validacion","" );
      ((Element)v.get(513)).setAttribute("disabled","" );
      ((Element)v.get(513)).setAttribute("onblur","" );
      ((Element)v.get(513)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',19, true)" );
      ((Element)v.get(513)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 19, false)" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */
      /* Termina nodo:512   */
      /* Termina nodo:511   */
      /* Termina nodo:507   */
      /* Termina nodo:506   */

      /* Empieza nodo:514 / Elemento padre: 505   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(514)).setAttribute("nombre","indPermUnioGapTdId" );
      ((Element)v.get(514)).setAttribute("nowrap","true" );
      ((Element)v.get(514)).setAttribute("class","datosCampos" );
      ((Element)v.get(505)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(515)).setAttribute("src","b.gif" );
      ((Element)v.get(515)).setAttribute("width","25" );
      ((Element)v.get(515)).setAttribute("height","8" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:514   */

      /* Empieza nodo:516 / Elemento padre: 505   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(516)).setAttribute("width","100%" );
      ((Element)v.get(505)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(517)).setAttribute("src","b.gif" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */
      /* Termina nodo:516   */
      /* Termina nodo:505   */
      /* Termina nodo:504   */
      /* Termina nodo:503   */
      /* Termina nodo:500   */

      /* Empieza nodo:518 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(518)).setAttribute("nombre","formGapTr17" );
      ((Element)v.get(52)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(519)).setAttribute("align","center" );
      ((Element)v.get(519)).setAttribute("width","8" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
   }

   private void getXML2340(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(520)).setAttribute("src","b.gif" );
      ((Element)v.get(520)).setAttribute("width","12" );
      ((Element)v.get(520)).setAttribute("height","8" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */
      /* Termina nodo:519   */

      /* Empieza nodo:521 / Elemento padre: 518   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(518)).appendChild((Element)v.get(521));

      /* Empieza nodo:522 / Elemento padre: 521   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(522)).setAttribute("src","b.gif" );
      ((Element)v.get(522)).setAttribute("width","8" );
      ((Element)v.get(522)).setAttribute("height","8" );
      ((Element)v.get(521)).appendChild((Element)v.get(522));
      /* Termina nodo:522   */
      /* Termina nodo:521   */

      /* Empieza nodo:523 / Elemento padre: 518   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(523)).setAttribute("align","center" );
      ((Element)v.get(523)).setAttribute("width","8" );
      ((Element)v.get(518)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(524)).setAttribute("src","b.gif" );
      ((Element)v.get(524)).setAttribute("width","12" );
      ((Element)v.get(524)).setAttribute("height","8" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */
      /* Termina nodo:523   */
      /* Termina nodo:518   */

      /* Empieza nodo:525 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(525)).setAttribute("nombre","formTr18" );
      ((Element)v.get(52)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(526)).setAttribute("align","center" );
      ((Element)v.get(526)).setAttribute("width","8" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(527)).setAttribute("src","b.gif" );
      ((Element)v.get(527)).setAttribute("width","8" );
      ((Element)v.get(527)).setAttribute("height","12" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */

      /* Empieza nodo:528 / Elemento padre: 525   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(528)).setAttribute("width","100%" );
      ((Element)v.get(525)).appendChild((Element)v.get(528));

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
      ((Element)v.get(530)).setAttribute("align","left" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(531)).setAttribute("nombre","indPediGtZonaTdId" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(532)).setAttribute("width","100%" );
      ((Element)v.get(532)).setAttribute("border","0" );
      ((Element)v.get(532)).setAttribute("cellspacing","0" );
      ((Element)v.get(532)).setAttribute("cellpadding","0" );
      ((Element)v.get(532)).setAttribute("align","left" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(532)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(534)).setAttribute("valign","top" );
      ((Element)v.get(534)).setAttribute("height","13" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(535)).setAttribute("nombre","lblIndPediGtZona" );
      ((Element)v.get(535)).setAttribute("alto","13" );
      ((Element)v.get(535)).setAttribute("filas","1" );
      ((Element)v.get(535)).setAttribute("id","datosTitle" );
      ((Element)v.get(535)).setAttribute("cod","PedTipoSolicPais.indPediGtZona.label" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */
      /* Termina nodo:534   */
      /* Termina nodo:533   */

      /* Empieza nodo:536 / Elemento padre: 532   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(536)).setAttribute("nombre","indPediGtZonaWidgetTrId" );
      ((Element)v.get(532)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(537)).setAttribute("align","left" );
      ((Element)v.get(537)).setAttribute("nowrap","true" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(538)).setAttribute("nombre","indPediGtZona" );
      ((Element)v.get(538)).setAttribute("id","datosCampos" );
      ((Element)v.get(538)).setAttribute("trim","S" );
      ((Element)v.get(538)).setAttribute("max","1" );
      ((Element)v.get(538)).setAttribute("onchange","" );
      ((Element)v.get(538)).setAttribute("req","N" );
      ((Element)v.get(538)).setAttribute("size","1" );
      ((Element)v.get(538)).setAttribute("valor","" );
      ((Element)v.get(538)).setAttribute("validacion","" );
      ((Element)v.get(538)).setAttribute("disabled","" );
      ((Element)v.get(538)).setAttribute("onblur","" );
      ((Element)v.get(538)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',20, true)" );
      ((Element)v.get(538)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 20, false)" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:537   */
      /* Termina nodo:536   */
      /* Termina nodo:532   */
      /* Termina nodo:531   */

      /* Empieza nodo:539 / Elemento padre: 530   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(539)).setAttribute("nombre","indPediGtZonaGapTdId" );
      ((Element)v.get(539)).setAttribute("nowrap","true" );
      ((Element)v.get(539)).setAttribute("class","datosCampos" );
      ((Element)v.get(530)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(540)).setAttribute("src","b.gif" );
      ((Element)v.get(540)).setAttribute("width","25" );
      ((Element)v.get(540)).setAttribute("height","8" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */

      /* Empieza nodo:541 / Elemento padre: 530   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(541)).setAttribute("width","100%" );
      ((Element)v.get(530)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(542)).setAttribute("src","b.gif" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */
      /* Termina nodo:541   */
      /* Termina nodo:530   */
      /* Termina nodo:529   */
      /* Termina nodo:528   */
      /* Termina nodo:525   */

      /* Empieza nodo:543 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(543)).setAttribute("nombre","formGapTr18" );
      ((Element)v.get(52)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(544)).setAttribute("align","center" );
      ((Element)v.get(544)).setAttribute("width","8" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(545)).setAttribute("src","b.gif" );
      ((Element)v.get(545)).setAttribute("width","12" );
      ((Element)v.get(545)).setAttribute("height","8" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:544   */

      /* Empieza nodo:546 / Elemento padre: 543   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(543)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(547)).setAttribute("src","b.gif" );
      ((Element)v.get(547)).setAttribute("width","8" );
      ((Element)v.get(547)).setAttribute("height","8" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:546   */

      /* Empieza nodo:548 / Elemento padre: 543   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(548)).setAttribute("align","center" );
      ((Element)v.get(548)).setAttribute("width","8" );
      ((Element)v.get(543)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(549)).setAttribute("src","b.gif" );
      ((Element)v.get(549)).setAttribute("width","12" );
      ((Element)v.get(549)).setAttribute("height","8" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));
      /* Termina nodo:549   */
      /* Termina nodo:548   */
      /* Termina nodo:543   */

      /* Empieza nodo:550 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(550)).setAttribute("nombre","formTr19" );
      ((Element)v.get(52)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(551)).setAttribute("align","center" );
      ((Element)v.get(551)).setAttribute("width","8" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(552)).setAttribute("src","b.gif" );
      ((Element)v.get(552)).setAttribute("width","8" );
      ((Element)v.get(552)).setAttribute("height","12" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */

      /* Empieza nodo:553 / Elemento padre: 550   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(553)).setAttribute("width","100%" );
      ((Element)v.get(550)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(554)).setAttribute("width","100%" );
      ((Element)v.get(554)).setAttribute("border","0" );
      ((Element)v.get(554)).setAttribute("cellspacing","0" );
      ((Element)v.get(554)).setAttribute("cellpadding","0" );
      ((Element)v.get(554)).setAttribute("align","left" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(555)).setAttribute("align","left" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(556)).setAttribute("nombre","indCambVentBelTdId" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(557)).setAttribute("width","100%" );
      ((Element)v.get(557)).setAttribute("border","0" );
      ((Element)v.get(557)).setAttribute("cellspacing","0" );
      ((Element)v.get(557)).setAttribute("cellpadding","0" );
      ((Element)v.get(557)).setAttribute("align","left" );
      ((Element)v.get(556)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(557)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(559)).setAttribute("valign","top" );
      ((Element)v.get(559)).setAttribute("height","13" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));

      /* Empieza nodo:560 / Elemento padre: 559   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(560)).setAttribute("nombre","lblIndCambVentBel" );
      ((Element)v.get(560)).setAttribute("alto","13" );
      ((Element)v.get(560)).setAttribute("filas","1" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(560)).setAttribute("id","datosTitle" );
      ((Element)v.get(560)).setAttribute("cod","PedTipoSolicPais.indCambVentBel.label" );
      ((Element)v.get(559)).appendChild((Element)v.get(560));
      /* Termina nodo:560   */
      /* Termina nodo:559   */
      /* Termina nodo:558   */

      /* Empieza nodo:561 / Elemento padre: 557   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(561)).setAttribute("nombre","indCambVentBelWidgetTrId" );
      ((Element)v.get(557)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(562)).setAttribute("align","left" );
      ((Element)v.get(562)).setAttribute("nowrap","true" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(563)).setAttribute("nombre","indCambVentBel" );
      ((Element)v.get(563)).setAttribute("id","datosCampos" );
      ((Element)v.get(563)).setAttribute("trim","S" );
      ((Element)v.get(563)).setAttribute("max","1" );
      ((Element)v.get(563)).setAttribute("onchange","" );
      ((Element)v.get(563)).setAttribute("req","N" );
      ((Element)v.get(563)).setAttribute("size","1" );
      ((Element)v.get(563)).setAttribute("valor","" );
      ((Element)v.get(563)).setAttribute("validacion","" );
      ((Element)v.get(563)).setAttribute("disabled","" );
      ((Element)v.get(563)).setAttribute("onblur","" );
      ((Element)v.get(563)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',21, true)" );
      ((Element)v.get(563)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 21, false)" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */
      /* Termina nodo:562   */
      /* Termina nodo:561   */
      /* Termina nodo:557   */
      /* Termina nodo:556   */

      /* Empieza nodo:564 / Elemento padre: 555   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(564)).setAttribute("nombre","indCambVentBelGapTdId" );
      ((Element)v.get(564)).setAttribute("nowrap","true" );
      ((Element)v.get(564)).setAttribute("class","datosCampos" );
      ((Element)v.get(555)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(565)).setAttribute("src","b.gif" );
      ((Element)v.get(565)).setAttribute("width","25" );
      ((Element)v.get(565)).setAttribute("height","8" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */
      /* Termina nodo:564   */

      /* Empieza nodo:566 / Elemento padre: 555   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(566)).setAttribute("width","100%" );
      ((Element)v.get(555)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(567)).setAttribute("src","b.gif" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:566   */
      /* Termina nodo:555   */
      /* Termina nodo:554   */
      /* Termina nodo:553   */
      /* Termina nodo:550   */

      /* Empieza nodo:568 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(568)).setAttribute("nombre","formGapTr19" );
      ((Element)v.get(52)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(569)).setAttribute("align","center" );
      ((Element)v.get(569)).setAttribute("width","8" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(570)).setAttribute("src","b.gif" );
      ((Element)v.get(570)).setAttribute("width","12" );
      ((Element)v.get(570)).setAttribute("height","8" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */
      /* Termina nodo:569   */

      /* Empieza nodo:571 / Elemento padre: 568   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(568)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(572)).setAttribute("src","b.gif" );
      ((Element)v.get(572)).setAttribute("width","8" );
      ((Element)v.get(572)).setAttribute("height","8" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));
      /* Termina nodo:572   */
      /* Termina nodo:571   */

      /* Empieza nodo:573 / Elemento padre: 568   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(573)).setAttribute("align","center" );
      ((Element)v.get(573)).setAttribute("width","8" );
      ((Element)v.get(568)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(574)).setAttribute("src","b.gif" );
      ((Element)v.get(574)).setAttribute("width","12" );
      ((Element)v.get(574)).setAttribute("height","8" );
      ((Element)v.get(573)).appendChild((Element)v.get(574));
      /* Termina nodo:574   */
      /* Termina nodo:573   */
      /* Termina nodo:568   */

      /* Empieza nodo:575 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(575)).setAttribute("nombre","formTr20" );
      ((Element)v.get(52)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(576)).setAttribute("align","center" );
      ((Element)v.get(576)).setAttribute("width","8" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(577)).setAttribute("src","b.gif" );
      ((Element)v.get(577)).setAttribute("width","8" );
      ((Element)v.get(577)).setAttribute("height","12" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */
      /* Termina nodo:576   */

      /* Empieza nodo:578 / Elemento padre: 575   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(578)).setAttribute("width","100%" );
      ((Element)v.get(575)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(579)).setAttribute("width","100%" );
      ((Element)v.get(579)).setAttribute("border","0" );
      ((Element)v.get(579)).setAttribute("cellspacing","0" );
      ((Element)v.get(579)).setAttribute("cellpadding","0" );
      ((Element)v.get(579)).setAttribute("align","left" );
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(578)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(580)).setAttribute("align","left" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(581)).setAttribute("nombre","almcOidAlmaTdId" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(582)).setAttribute("border","0" );
      ((Element)v.get(582)).setAttribute("cellspacing","0" );
      ((Element)v.get(582)).setAttribute("cellpadding","0" );
      ((Element)v.get(582)).setAttribute("align","left" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(582)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(584)).setAttribute("valign","top" );
      ((Element)v.get(584)).setAttribute("height","13" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(585)).setAttribute("nombre","lblalmcOidAlma" );
      ((Element)v.get(585)).setAttribute("id","datosTitle" );
      ((Element)v.get(585)).setAttribute("ancho","150" );
      ((Element)v.get(585)).setAttribute("alto","13" );
      ((Element)v.get(585)).setAttribute("cod","PedTipoSolicPais.almcOidAlma.label" );
      ((Element)v.get(584)).appendChild((Element)v.get(585));
      /* Termina nodo:585   */
      /* Termina nodo:584   */
      /* Termina nodo:583   */

      /* Empieza nodo:586 / Elemento padre: 582   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(586)).setAttribute("nombre","almcOidAlmaWidgetTrId" );
      ((Element)v.get(582)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(587)).setAttribute("align","left" );
      ((Element)v.get(587)).setAttribute("nowrap","true" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(588)).setAttribute("nombre","almcOidAlma" );
      ((Element)v.get(588)).setAttribute("id","datosCampos" );
      ((Element)v.get(588)).setAttribute("multiple","N" );
      ((Element)v.get(588)).setAttribute("req","N" );
      ((Element)v.get(588)).setAttribute("size","1" );
      ((Element)v.get(588)).setAttribute("disabled","" );
      ((Element)v.get(588)).setAttribute("validacion","" );
      ((Element)v.get(588)).setAttribute("onchange","" );
      ((Element)v.get(588)).setAttribute("onfocus","" );
      ((Element)v.get(588)).setAttribute("valorinicial","" );
      ((Element)v.get(588)).setAttribute("textoinicial","" );
      ((Element)v.get(588)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',22, true);" );
      ((Element)v.get(588)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',22, false);" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(588)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */
      /* Termina nodo:588   */
      /* Termina nodo:587   */
      /* Termina nodo:586   */
      /* Termina nodo:582   */
      /* Termina nodo:581   */

      /* Empieza nodo:590 / Elemento padre: 580   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(590)).setAttribute("nombre","almcOidAlmaGapTdId" );
      ((Element)v.get(590)).setAttribute("nowrap","true" );
      ((Element)v.get(590)).setAttribute("class","datosCampos" );
      ((Element)v.get(580)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(591)).setAttribute("src","b.gif" );
      ((Element)v.get(591)).setAttribute("width","25" );
      ((Element)v.get(591)).setAttribute("height","8" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));
      /* Termina nodo:591   */
      /* Termina nodo:590   */

      /* Empieza nodo:592 / Elemento padre: 580   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(592)).setAttribute("width","100%" );
      ((Element)v.get(580)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(593)).setAttribute("src","b.gif" );
      ((Element)v.get(592)).appendChild((Element)v.get(593));
      /* Termina nodo:593   */
      /* Termina nodo:592   */
      /* Termina nodo:580   */
      /* Termina nodo:579   */
      /* Termina nodo:578   */
      /* Termina nodo:575   */

      /* Empieza nodo:594 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(594)).setAttribute("nombre","formGapTr20" );
      ((Element)v.get(52)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(595)).setAttribute("align","center" );
      ((Element)v.get(595)).setAttribute("width","8" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(596)).setAttribute("src","b.gif" );
      ((Element)v.get(596)).setAttribute("width","12" );
      ((Element)v.get(596)).setAttribute("height","8" );
      ((Element)v.get(595)).appendChild((Element)v.get(596));
      /* Termina nodo:596   */
      /* Termina nodo:595   */

      /* Empieza nodo:597 / Elemento padre: 594   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(594)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(598)).setAttribute("src","b.gif" );
      ((Element)v.get(598)).setAttribute("width","8" );
      ((Element)v.get(598)).setAttribute("height","8" );
      ((Element)v.get(597)).appendChild((Element)v.get(598));
      /* Termina nodo:598   */
      /* Termina nodo:597   */

      /* Empieza nodo:599 / Elemento padre: 594   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(599)).setAttribute("align","center" );
      ((Element)v.get(599)).setAttribute("width","8" );
      ((Element)v.get(594)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(600)).setAttribute("src","b.gif" );
      ((Element)v.get(600)).setAttribute("width","12" );
      ((Element)v.get(600)).setAttribute("height","8" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));
      /* Termina nodo:600   */
      /* Termina nodo:599   */
      /* Termina nodo:594   */

      /* Empieza nodo:601 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(601)).setAttribute("nombre","formTr21" );
      ((Element)v.get(52)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(602)).setAttribute("align","center" );
      ((Element)v.get(602)).setAttribute("width","8" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(603)).setAttribute("src","b.gif" );
      ((Element)v.get(603)).setAttribute("width","8" );
      ((Element)v.get(603)).setAttribute("height","12" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */
      /* Termina nodo:602   */

      /* Empieza nodo:604 / Elemento padre: 601   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(604)).setAttribute("width","100%" );
      ((Element)v.get(601)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(605)).setAttribute("width","100%" );
      ((Element)v.get(605)).setAttribute("border","0" );
      ((Element)v.get(605)).setAttribute("cellspacing","0" );
      ((Element)v.get(605)).setAttribute("cellpadding","0" );
      ((Element)v.get(605)).setAttribute("align","left" );
      ((Element)v.get(604)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(606)).setAttribute("align","left" );
      ((Element)v.get(605)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(607)).setAttribute("nombre","sociOidSociTdId" );
      ((Element)v.get(606)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(608)).setAttribute("border","0" );
      ((Element)v.get(608)).setAttribute("cellspacing","0" );
      ((Element)v.get(608)).setAttribute("cellpadding","0" );
      ((Element)v.get(608)).setAttribute("align","left" );
      ((Element)v.get(607)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(608)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(610)).setAttribute("valign","top" );
      ((Element)v.get(610)).setAttribute("height","13" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(611)).setAttribute("nombre","lblsociOidSoci" );
      ((Element)v.get(611)).setAttribute("id","datosTitle" );
      ((Element)v.get(611)).setAttribute("ancho","150" );
      ((Element)v.get(611)).setAttribute("alto","13" );
      ((Element)v.get(611)).setAttribute("cod","PedTipoSolicPais.sociOidSoci.label" );
      ((Element)v.get(610)).appendChild((Element)v.get(611));
      /* Termina nodo:611   */
      /* Termina nodo:610   */
      /* Termina nodo:609   */

      /* Empieza nodo:612 / Elemento padre: 608   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(612)).setAttribute("nombre","sociOidSociWidgetTrId" );
      ((Element)v.get(608)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(613)).setAttribute("align","left" );
      ((Element)v.get(613)).setAttribute("nowrap","true" );
      ((Element)v.get(612)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(614)).setAttribute("nombre","sociOidSoci" );
      ((Element)v.get(614)).setAttribute("id","datosCampos" );
      ((Element)v.get(614)).setAttribute("multiple","N" );
      ((Element)v.get(614)).setAttribute("req","N" );
      ((Element)v.get(614)).setAttribute("size","1" );
      ((Element)v.get(614)).setAttribute("disabled","" );
      ((Element)v.get(614)).setAttribute("validacion","" );
      ((Element)v.get(614)).setAttribute("onchange","" );
      ((Element)v.get(614)).setAttribute("onfocus","" );
      ((Element)v.get(614)).setAttribute("valorinicial","" );
      ((Element)v.get(614)).setAttribute("textoinicial","" );
      ((Element)v.get(614)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',23, true);" );
      ((Element)v.get(614)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',23, false);" );
      ((Element)v.get(613)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(614)).appendChild((Element)v.get(615));
      /* Termina nodo:615   */
      /* Termina nodo:614   */
      /* Termina nodo:613   */
      /* Termina nodo:612   */
      /* Termina nodo:608   */
      /* Termina nodo:607   */

      /* Empieza nodo:616 / Elemento padre: 606   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(616)).setAttribute("nombre","sociOidSociGapTdId" );
      ((Element)v.get(616)).setAttribute("nowrap","true" );
      ((Element)v.get(616)).setAttribute("class","datosCampos" );
      ((Element)v.get(606)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(617)).setAttribute("src","b.gif" );
      ((Element)v.get(617)).setAttribute("width","25" );
      ((Element)v.get(617)).setAttribute("height","8" );
      ((Element)v.get(616)).appendChild((Element)v.get(617));
      /* Termina nodo:617   */
      /* Termina nodo:616   */

      /* Empieza nodo:618 / Elemento padre: 606   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(618)).setAttribute("width","100%" );
      ((Element)v.get(606)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(619)).setAttribute("src","b.gif" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(618)).appendChild((Element)v.get(619));
      /* Termina nodo:619   */
      /* Termina nodo:618   */
      /* Termina nodo:606   */
      /* Termina nodo:605   */
      /* Termina nodo:604   */
      /* Termina nodo:601   */

      /* Empieza nodo:620 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(620)).setAttribute("nombre","formGapTr21" );
      ((Element)v.get(52)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(621)).setAttribute("align","center" );
      ((Element)v.get(621)).setAttribute("width","8" );
      ((Element)v.get(620)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(622)).setAttribute("src","b.gif" );
      ((Element)v.get(622)).setAttribute("width","12" );
      ((Element)v.get(622)).setAttribute("height","8" );
      ((Element)v.get(621)).appendChild((Element)v.get(622));
      /* Termina nodo:622   */
      /* Termina nodo:621   */

      /* Empieza nodo:623 / Elemento padre: 620   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(620)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(624)).setAttribute("src","b.gif" );
      ((Element)v.get(624)).setAttribute("width","8" );
      ((Element)v.get(624)).setAttribute("height","8" );
      ((Element)v.get(623)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */
      /* Termina nodo:623   */

      /* Empieza nodo:625 / Elemento padre: 620   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(625)).setAttribute("align","center" );
      ((Element)v.get(625)).setAttribute("width","8" );
      ((Element)v.get(620)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(626)).setAttribute("src","b.gif" );
      ((Element)v.get(626)).setAttribute("width","12" );
      ((Element)v.get(626)).setAttribute("height","8" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));
      /* Termina nodo:626   */
      /* Termina nodo:625   */
      /* Termina nodo:620   */

      /* Empieza nodo:627 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(627)).setAttribute("nombre","formTr22" );
      ((Element)v.get(52)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(628)).setAttribute("align","center" );
      ((Element)v.get(628)).setAttribute("width","8" );
      ((Element)v.get(627)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(629)).setAttribute("src","b.gif" );
      ((Element)v.get(629)).setAttribute("width","8" );
      ((Element)v.get(629)).setAttribute("height","12" );
      ((Element)v.get(628)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */
      /* Termina nodo:628   */

      /* Empieza nodo:630 / Elemento padre: 627   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(630)).setAttribute("width","100%" );
      ((Element)v.get(627)).appendChild((Element)v.get(630));

      /* Empieza nodo:631 / Elemento padre: 630   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(631)).setAttribute("width","100%" );
      ((Element)v.get(631)).setAttribute("border","0" );
      ((Element)v.get(631)).setAttribute("cellspacing","0" );
      ((Element)v.get(631)).setAttribute("cellpadding","0" );
      ((Element)v.get(631)).setAttribute("align","left" );
      ((Element)v.get(630)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(632)).setAttribute("align","left" );
      ((Element)v.get(631)).appendChild((Element)v.get(632));

      /* Empieza nodo:633 / Elemento padre: 632   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(633)).setAttribute("nombre","valGlosTdId" );
      ((Element)v.get(632)).appendChild((Element)v.get(633));

      /* Empieza nodo:634 / Elemento padre: 633   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(634)).setAttribute("width","100%" );
      ((Element)v.get(634)).setAttribute("border","0" );
      ((Element)v.get(634)).setAttribute("cellspacing","0" );
      ((Element)v.get(634)).setAttribute("cellpadding","0" );
      ((Element)v.get(634)).setAttribute("align","left" );
      ((Element)v.get(633)).appendChild((Element)v.get(634));

      /* Empieza nodo:635 / Elemento padre: 634   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(634)).appendChild((Element)v.get(635));

      /* Empieza nodo:636 / Elemento padre: 635   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(636)).setAttribute("valign","top" );
      ((Element)v.get(636)).setAttribute("height","13" );
      ((Element)v.get(635)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(637)).setAttribute("nombre","lblValGlos" );
      ((Element)v.get(637)).setAttribute("alto","13" );
      ((Element)v.get(637)).setAttribute("filas","1" );
      ((Element)v.get(637)).setAttribute("id","datosTitle" );
      ((Element)v.get(637)).setAttribute("cod","PedTipoSolicPais.valGlos.label" );
      ((Element)v.get(636)).appendChild((Element)v.get(637));
      /* Termina nodo:637   */
      /* Termina nodo:636   */
      /* Termina nodo:635   */

      /* Empieza nodo:638 / Elemento padre: 634   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(638)).setAttribute("nombre","valGlosWidgetTrId" );
      ((Element)v.get(634)).appendChild((Element)v.get(638));

      /* Empieza nodo:639 / Elemento padre: 638   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(639)).setAttribute("align","left" );
      ((Element)v.get(639)).setAttribute("nowrap","true" );
      ((Element)v.get(638)).appendChild((Element)v.get(639));

      /* Empieza nodo:640 / Elemento padre: 639   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(640)).setAttribute("nombre","valGlos" );
      ((Element)v.get(640)).setAttribute("id","datosCampos" );
      ((Element)v.get(640)).setAttribute("trim","S" );
      ((Element)v.get(640)).setAttribute("max","255" );
      ((Element)v.get(640)).setAttribute("onchange","" );
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(640)).setAttribute("req","N" );
      ((Element)v.get(640)).setAttribute("size","255" );
      ((Element)v.get(640)).setAttribute("valor","" );
      ((Element)v.get(640)).setAttribute("validacion","" );
      ((Element)v.get(640)).setAttribute("disabled","" );
      ((Element)v.get(640)).setAttribute("onblur","" );
      ((Element)v.get(640)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',24, true)" );
      ((Element)v.get(640)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 24, false)" );
      ((Element)v.get(639)).appendChild((Element)v.get(640));
      /* Termina nodo:640   */
      /* Termina nodo:639   */
      /* Termina nodo:638   */
      /* Termina nodo:634   */
      /* Termina nodo:633   */

      /* Empieza nodo:641 / Elemento padre: 632   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(641)).setAttribute("nombre","valGlosGapTdId" );
      ((Element)v.get(641)).setAttribute("nowrap","true" );
      ((Element)v.get(641)).setAttribute("class","datosCampos" );
      ((Element)v.get(632)).appendChild((Element)v.get(641));

      /* Empieza nodo:642 / Elemento padre: 641   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(642)).setAttribute("src","b.gif" );
      ((Element)v.get(642)).setAttribute("width","25" );
      ((Element)v.get(642)).setAttribute("height","8" );
      ((Element)v.get(641)).appendChild((Element)v.get(642));
      /* Termina nodo:642   */
      /* Termina nodo:641   */

      /* Empieza nodo:643 / Elemento padre: 632   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(643)).setAttribute("width","100%" );
      ((Element)v.get(632)).appendChild((Element)v.get(643));

      /* Empieza nodo:644 / Elemento padre: 643   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(644)).setAttribute("src","b.gif" );
      ((Element)v.get(643)).appendChild((Element)v.get(644));
      /* Termina nodo:644   */
      /* Termina nodo:643   */
      /* Termina nodo:632   */
      /* Termina nodo:631   */
      /* Termina nodo:630   */
      /* Termina nodo:627   */

      /* Empieza nodo:645 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(645)).setAttribute("nombre","formGapTr22" );
      ((Element)v.get(52)).appendChild((Element)v.get(645));

      /* Empieza nodo:646 / Elemento padre: 645   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(646)).setAttribute("align","center" );
      ((Element)v.get(646)).setAttribute("width","8" );
      ((Element)v.get(645)).appendChild((Element)v.get(646));

      /* Empieza nodo:647 / Elemento padre: 646   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(647)).setAttribute("src","b.gif" );
      ((Element)v.get(647)).setAttribute("width","12" );
      ((Element)v.get(647)).setAttribute("height","8" );
      ((Element)v.get(646)).appendChild((Element)v.get(647));
      /* Termina nodo:647   */
      /* Termina nodo:646   */

      /* Empieza nodo:648 / Elemento padre: 645   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(645)).appendChild((Element)v.get(648));

      /* Empieza nodo:649 / Elemento padre: 648   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(649)).setAttribute("src","b.gif" );
      ((Element)v.get(649)).setAttribute("width","8" );
      ((Element)v.get(649)).setAttribute("height","8" );
      ((Element)v.get(648)).appendChild((Element)v.get(649));
      /* Termina nodo:649   */
      /* Termina nodo:648   */

      /* Empieza nodo:650 / Elemento padre: 645   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(650)).setAttribute("align","center" );
      ((Element)v.get(650)).setAttribute("width","8" );
      ((Element)v.get(645)).appendChild((Element)v.get(650));

      /* Empieza nodo:651 / Elemento padre: 650   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(651)).setAttribute("src","b.gif" );
      ((Element)v.get(651)).setAttribute("width","12" );
      ((Element)v.get(651)).setAttribute("height","8" );
      ((Element)v.get(650)).appendChild((Element)v.get(651));
      /* Termina nodo:651   */
      /* Termina nodo:650   */
      /* Termina nodo:645   */

      /* Empieza nodo:652 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(652)).setAttribute("nombre","formTr23" );
      ((Element)v.get(52)).appendChild((Element)v.get(652));

      /* Empieza nodo:653 / Elemento padre: 652   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(653)).setAttribute("align","center" );
      ((Element)v.get(653)).setAttribute("width","8" );
      ((Element)v.get(652)).appendChild((Element)v.get(653));

      /* Empieza nodo:654 / Elemento padre: 653   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(654)).setAttribute("src","b.gif" );
      ((Element)v.get(654)).setAttribute("width","8" );
      ((Element)v.get(654)).setAttribute("height","12" );
      ((Element)v.get(653)).appendChild((Element)v.get(654));
      /* Termina nodo:654   */
      /* Termina nodo:653   */

      /* Empieza nodo:655 / Elemento padre: 652   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(655)).setAttribute("width","100%" );
      ((Element)v.get(652)).appendChild((Element)v.get(655));

      /* Empieza nodo:656 / Elemento padre: 655   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(656)).setAttribute("width","100%" );
      ((Element)v.get(656)).setAttribute("border","0" );
      ((Element)v.get(656)).setAttribute("cellspacing","0" );
      ((Element)v.get(656)).setAttribute("cellpadding","0" );
      ((Element)v.get(656)).setAttribute("align","left" );
      ((Element)v.get(655)).appendChild((Element)v.get(656));

      /* Empieza nodo:657 / Elemento padre: 656   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(657)).setAttribute("align","left" );
      ((Element)v.get(656)).appendChild((Element)v.get(657));

      /* Empieza nodo:658 / Elemento padre: 657   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(658)).setAttribute("nombre","tsolOidTipoConsTdId" );
      ((Element)v.get(657)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(659)).setAttribute("border","0" );
      ((Element)v.get(659)).setAttribute("cellspacing","0" );
      ((Element)v.get(659)).setAttribute("cellpadding","0" );
      ((Element)v.get(659)).setAttribute("align","left" );
      ((Element)v.get(658)).appendChild((Element)v.get(659));

      /* Empieza nodo:660 / Elemento padre: 659   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(659)).appendChild((Element)v.get(660));

      /* Empieza nodo:661 / Elemento padre: 660   */
      v.add(doc.createElement("TD"));
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(661)).setAttribute("valign","top" );
      ((Element)v.get(661)).setAttribute("height","13" );
      ((Element)v.get(660)).appendChild((Element)v.get(661));

      /* Empieza nodo:662 / Elemento padre: 661   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(662)).setAttribute("nombre","lbltsolOidTipoCons" );
      ((Element)v.get(662)).setAttribute("id","datosTitle" );
      ((Element)v.get(662)).setAttribute("ancho","150" );
      ((Element)v.get(662)).setAttribute("alto","13" );
      ((Element)v.get(662)).setAttribute("cod","PedTipoSolicPais.tsolOidTipoCons.label" );
      ((Element)v.get(661)).appendChild((Element)v.get(662));
      /* Termina nodo:662   */
      /* Termina nodo:661   */
      /* Termina nodo:660   */

      /* Empieza nodo:663 / Elemento padre: 659   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(663)).setAttribute("nombre","tsolOidTipoConsWidgetTrId" );
      ((Element)v.get(659)).appendChild((Element)v.get(663));

      /* Empieza nodo:664 / Elemento padre: 663   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(664)).setAttribute("align","left" );
      ((Element)v.get(664)).setAttribute("nowrap","true" );
      ((Element)v.get(663)).appendChild((Element)v.get(664));

      /* Empieza nodo:665 / Elemento padre: 664   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(665)).setAttribute("nombre","tsolOidTipoCons" );
      ((Element)v.get(665)).setAttribute("id","datosCampos" );
      ((Element)v.get(665)).setAttribute("multiple","N" );
      ((Element)v.get(665)).setAttribute("req","N" );
      ((Element)v.get(665)).setAttribute("size","1" );
      ((Element)v.get(665)).setAttribute("disabled","" );
      ((Element)v.get(665)).setAttribute("validacion","" );
      ((Element)v.get(665)).setAttribute("onchange","" );
      ((Element)v.get(665)).setAttribute("onfocus","" );
      ((Element)v.get(665)).setAttribute("valorinicial","" );
      ((Element)v.get(665)).setAttribute("textoinicial","" );
      ((Element)v.get(665)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',25, true);" );
      ((Element)v.get(665)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',25, false);" );
      ((Element)v.get(664)).appendChild((Element)v.get(665));

      /* Empieza nodo:666 / Elemento padre: 665   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(665)).appendChild((Element)v.get(666));
      /* Termina nodo:666   */
      /* Termina nodo:665   */
      /* Termina nodo:664   */
      /* Termina nodo:663   */
      /* Termina nodo:659   */
      /* Termina nodo:658   */

      /* Empieza nodo:667 / Elemento padre: 657   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(667)).setAttribute("nombre","tsolOidTipoConsGapTdId" );
      ((Element)v.get(667)).setAttribute("nowrap","true" );
      ((Element)v.get(667)).setAttribute("class","datosCampos" );
      ((Element)v.get(657)).appendChild((Element)v.get(667));

      /* Empieza nodo:668 / Elemento padre: 667   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(668)).setAttribute("src","b.gif" );
      ((Element)v.get(668)).setAttribute("width","25" );
      ((Element)v.get(668)).setAttribute("height","8" );
      ((Element)v.get(667)).appendChild((Element)v.get(668));
      /* Termina nodo:668   */
      /* Termina nodo:667   */

      /* Empieza nodo:669 / Elemento padre: 657   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(669)).setAttribute("width","100%" );
      ((Element)v.get(657)).appendChild((Element)v.get(669));

      /* Empieza nodo:670 / Elemento padre: 669   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(670)).setAttribute("src","b.gif" );
      ((Element)v.get(669)).appendChild((Element)v.get(670));
      /* Termina nodo:670   */
      /* Termina nodo:669   */
      /* Termina nodo:657   */
      /* Termina nodo:656   */
      /* Termina nodo:655   */

      /* Empieza nodo:671 / Elemento padre: 652   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(671)).setAttribute("width","100%" );
      ((Element)v.get(652)).appendChild((Element)v.get(671));
      /* Termina nodo:671   */
      /* Termina nodo:652   */

      /* Empieza nodo:672 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(672)).setAttribute("nombre","formGapTr23" );
      ((Element)v.get(52)).appendChild((Element)v.get(672));

      /* Empieza nodo:673 / Elemento padre: 672   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(673)).setAttribute("align","center" );
      ((Element)v.get(673)).setAttribute("width","8" );
      ((Element)v.get(672)).appendChild((Element)v.get(673));

      /* Empieza nodo:674 / Elemento padre: 673   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(674)).setAttribute("src","b.gif" );
      ((Element)v.get(674)).setAttribute("width","8" );
      ((Element)v.get(674)).setAttribute("height","8" );
      ((Element)v.get(673)).appendChild((Element)v.get(674));
      /* Termina nodo:674   */
      /* Termina nodo:673   */

      /* Empieza nodo:675 / Elemento padre: 672   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(672)).appendChild((Element)v.get(675));

      /* Empieza nodo:676 / Elemento padre: 675   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(676)).setAttribute("src","b.gif" );
      ((Element)v.get(676)).setAttribute("width","8" );
      ((Element)v.get(676)).setAttribute("height","8" );
      ((Element)v.get(675)).appendChild((Element)v.get(676));
      /* Termina nodo:676   */
      /* Termina nodo:675   */

      /* Empieza nodo:677 / Elemento padre: 672   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(677)).setAttribute("align","center" );
      ((Element)v.get(677)).setAttribute("width","8" );
      ((Element)v.get(672)).appendChild((Element)v.get(677));

      /* Empieza nodo:678 / Elemento padre: 677   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(678)).setAttribute("src","b.gif" );
      ((Element)v.get(678)).setAttribute("width","8" );
      ((Element)v.get(678)).setAttribute("height","8" );
      ((Element)v.get(677)).appendChild((Element)v.get(678));
      /* Termina nodo:678   */
      /* Termina nodo:677   */
      /* Termina nodo:672   */
      /* Termina nodo:52   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:679 / Elemento padre: 45   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(679)).setAttribute("align","center" );
      ((Element)v.get(679)).setAttribute("width","12" );
      ((Element)v.get(45)).appendChild((Element)v.get(679));

      /* Empieza nodo:680 / Elemento padre: 679   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(680)).setAttribute("src","b.gif" );
      ((Element)v.get(680)).setAttribute("width","12" );
      ((Element)v.get(680)).setAttribute("height","12" );
      ((Element)v.get(679)).appendChild((Element)v.get(680));
      /* Termina nodo:680   */
      /* Termina nodo:679   */
      /* Termina nodo:45   */

      /* Empieza nodo:681 / Elemento padre: 37   */
   }

   private void getXML3060(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(681)).setAttribute("nombre","pedTipoSolicPaisTrButtons" );
      ((Element)v.get(37)).appendChild((Element)v.get(681));

      /* Empieza nodo:682 / Elemento padre: 681   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(682)).setAttribute("align","center" );
      ((Element)v.get(682)).setAttribute("width","12" );
      ((Element)v.get(681)).appendChild((Element)v.get(682));

      /* Empieza nodo:683 / Elemento padre: 682   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(683)).setAttribute("src","b.gif" );
      ((Element)v.get(683)).setAttribute("width","12" );
      ((Element)v.get(683)).setAttribute("height","12" );
      ((Element)v.get(682)).appendChild((Element)v.get(683));
      /* Termina nodo:683   */
      /* Termina nodo:682   */

      /* Empieza nodo:684 / Elemento padre: 681   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(681)).appendChild((Element)v.get(684));

      /* Empieza nodo:685 / Elemento padre: 684   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(684)).appendChild((Element)v.get(685));

      /* Empieza nodo:686 / Elemento padre: 685   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(686)).setAttribute("width","100%" );
      ((Element)v.get(686)).setAttribute("border","0" );
      ((Element)v.get(686)).setAttribute("align","center" );
      ((Element)v.get(686)).setAttribute("cellspacing","0" );
      ((Element)v.get(686)).setAttribute("cellpadding","0" );
      ((Element)v.get(685)).appendChild((Element)v.get(686));

      /* Empieza nodo:687 / Elemento padre: 686   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(686)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(688)).setAttribute("class","tablaTitle" );
      ((Element)v.get(688)).setAttribute("nombre","pedTipoSolicPaisTdQueryButton" );
      ((Element)v.get(687)).appendChild((Element)v.get(688));

      /* Empieza nodo:689 / Elemento padre: 688   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(689)).setAttribute("nombre","pedTipoSolicPaisQueryButton" );
      ((Element)v.get(689)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(689)).setAttribute("estado","false" );
      ((Element)v.get(689)).setAttribute("accion","pedTipoSolicPaisFirstPage();" );
      ((Element)v.get(689)).setAttribute("tipo","html" );
      ((Element)v.get(689)).setAttribute("ID","botonContenido" );
      ((Element)v.get(688)).appendChild((Element)v.get(689));
      /* Termina nodo:689   */
      /* Termina nodo:688   */

      /* Empieza nodo:690 / Elemento padre: 687   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(690)).setAttribute("class","tablaTitle" );
      ((Element)v.get(690)).setAttribute("nombre","pedTipoSolicPaisTdLovNullSelectionButton" );
      ((Element)v.get(690)).setAttribute("align","left" );
      ((Element)v.get(690)).setAttribute("width","100%" );
      ((Element)v.get(687)).appendChild((Element)v.get(690));

      /* Empieza nodo:691 / Elemento padre: 690   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(691)).setAttribute("src","b.gif" );
      ((Element)v.get(691)).setAttribute("height","8" );
      ((Element)v.get(691)).setAttribute("width","8" );
      ((Element)v.get(690)).appendChild((Element)v.get(691));
      /* Termina nodo:691   */

      /* Empieza nodo:692 / Elemento padre: 690   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(692)).setAttribute("nombre","pedTipoSolicPaisLovNullButton" );
      ((Element)v.get(692)).setAttribute("ID","botonContenido" );
      ((Element)v.get(692)).setAttribute("tipo","html" );
      ((Element)v.get(692)).setAttribute("accion","pedTipoSolicPaisLovNullSelectionAction();" );
      ((Element)v.get(692)).setAttribute("estado","true" );
      ((Element)v.get(692)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(690)).appendChild((Element)v.get(692));
      /* Termina nodo:692   */
      /* Termina nodo:690   */
      /* Termina nodo:687   */
      /* Termina nodo:686   */
      /* Termina nodo:685   */
      /* Termina nodo:684   */

      /* Empieza nodo:693 / Elemento padre: 681   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(693)).setAttribute("align","center" );
      ((Element)v.get(693)).setAttribute("width","12" );
      ((Element)v.get(681)).appendChild((Element)v.get(693));

      /* Empieza nodo:694 / Elemento padre: 693   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(694)).setAttribute("src","b.gif" );
      ((Element)v.get(694)).setAttribute("width","12" );
      ((Element)v.get(694)).setAttribute("height","12" );
      ((Element)v.get(693)).appendChild((Element)v.get(694));
      /* Termina nodo:694   */
      /* Termina nodo:693   */
      /* Termina nodo:681   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:695 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(695)).setAttribute("nombre","pedTipoSolicPaisListLayer" );
      ((Element)v.get(695)).setAttribute("alto","310" );
      ((Element)v.get(695)).setAttribute("ancho","99%" );
      ((Element)v.get(695)).setAttribute("colorf","" );
      ((Element)v.get(695)).setAttribute("borde","0" );
      ((Element)v.get(695)).setAttribute("imagenf","" );
      ((Element)v.get(695)).setAttribute("repeat","" );
      ((Element)v.get(695)).setAttribute("padding","" );
      ((Element)v.get(695)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(695)).setAttribute("contravsb","" );
      ((Element)v.get(695)).setAttribute("x","3" );
      ((Element)v.get(695)).setAttribute("y","" );
      ((Element)v.get(695)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(695));

      /* Empieza nodo:696 / Elemento padre: 695   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(696)).setAttribute("nombre","pedTipoSolicPaisList" );
      ((Element)v.get(696)).setAttribute("ancho","680" );
      ((Element)v.get(696)).setAttribute("alto","275" );
      ((Element)v.get(696)).setAttribute("x","12" );
      ((Element)v.get(696)).setAttribute("y","0" );
      ((Element)v.get(696)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(696)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(695)).appendChild((Element)v.get(696));

      /* Empieza nodo:697 / Elemento padre: 696   */
      v.add(doc.createElement("IMGBOTONES"));
   }

   private void getXML3150(Document doc) {
      ((Element)v.get(697)).setAttribute("precarga","S" );
      ((Element)v.get(697)).setAttribute("conROver","S" );
      ((Element)v.get(696)).appendChild((Element)v.get(697));

      /* Empieza nodo:698 / Elemento padre: 697   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(698)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(698)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(698)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(698)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(697)).appendChild((Element)v.get(698));
      /* Termina nodo:698   */

      /* Empieza nodo:699 / Elemento padre: 697   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(699)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(699)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(699)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(699)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(697)).appendChild((Element)v.get(699));
      /* Termina nodo:699   */
      /* Termina nodo:697   */

      /* Empieza nodo:700 / Elemento padre: 696   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(696)).appendChild((Element)v.get(700));

      /* Empieza nodo:701 / Elemento padre: 700   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(701)).setAttribute("borde","1" );
      ((Element)v.get(701)).setAttribute("horizDatos","1" );
      ((Element)v.get(701)).setAttribute("horizCabecera","1" );
      ((Element)v.get(701)).setAttribute("vertical","1" );
      ((Element)v.get(701)).setAttribute("horizTitulo","1" );
      ((Element)v.get(701)).setAttribute("horizBase","1" );
      ((Element)v.get(700)).appendChild((Element)v.get(701));
      /* Termina nodo:701   */

      /* Empieza nodo:702 / Elemento padre: 700   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(702)).setAttribute("borde","#999999" );
      ((Element)v.get(702)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(702)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(702)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(702)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(702)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(702)).setAttribute("horizBase","#999999" );
      ((Element)v.get(700)).appendChild((Element)v.get(702));
      /* Termina nodo:702   */
      /* Termina nodo:700   */

      /* Empieza nodo:703 / Elemento padre: 696   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(703)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(703)).setAttribute("alto","22" );
      ((Element)v.get(703)).setAttribute("imgFondo","" );
      ((Element)v.get(703)).setAttribute("cod","00135" );
      ((Element)v.get(703)).setAttribute("ID","datosTitle" );
      ((Element)v.get(696)).appendChild((Element)v.get(703));
      /* Termina nodo:703   */

      /* Empieza nodo:704 / Elemento padre: 696   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(704)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(704)).setAttribute("alto","22" );
      ((Element)v.get(704)).setAttribute("imgFondo","" );
      ((Element)v.get(696)).appendChild((Element)v.get(704));
      /* Termina nodo:704   */

      /* Empieza nodo:705 / Elemento padre: 696   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(705)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(705)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(705)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(705)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(705)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(696)).appendChild((Element)v.get(705));

      /* Empieza nodo:706 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(706)).setAttribute("ancho","100" );
      ((Element)v.get(706)).setAttribute("minimizable","S" );
      ((Element)v.get(706)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(706));
      /* Termina nodo:706   */

      /* Empieza nodo:707 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(707)).setAttribute("ancho","100" );
      ((Element)v.get(707)).setAttribute("minimizable","S" );
      ((Element)v.get(707)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(707));
      /* Termina nodo:707   */

      /* Empieza nodo:708 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(708)).setAttribute("ancho","100" );
      ((Element)v.get(708)).setAttribute("minimizable","S" );
      ((Element)v.get(708)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(708));
      /* Termina nodo:708   */

      /* Empieza nodo:709 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(709)).setAttribute("ancho","100" );
      ((Element)v.get(709)).setAttribute("minimizable","S" );
      ((Element)v.get(709)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(709));
      /* Termina nodo:709   */

      /* Empieza nodo:710 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(710)).setAttribute("ancho","100" );
      ((Element)v.get(710)).setAttribute("minimizable","S" );
      ((Element)v.get(710)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(710));
      /* Termina nodo:710   */

      /* Empieza nodo:711 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(711)).setAttribute("ancho","100" );
      ((Element)v.get(711)).setAttribute("minimizable","S" );
      ((Element)v.get(711)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(711));
      /* Termina nodo:711   */

      /* Empieza nodo:712 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(712)).setAttribute("ancho","100" );
      ((Element)v.get(712)).setAttribute("minimizable","S" );
      ((Element)v.get(712)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(712));
      /* Termina nodo:712   */

      /* Empieza nodo:713 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(713)).setAttribute("ancho","100" );
   }

   private void getXML3240(Document doc) {
      ((Element)v.get(713)).setAttribute("minimizable","S" );
      ((Element)v.get(713)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(713));
      /* Termina nodo:713   */

      /* Empieza nodo:714 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(714)).setAttribute("ancho","100" );
      ((Element)v.get(714)).setAttribute("minimizable","S" );
      ((Element)v.get(714)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(714));
      /* Termina nodo:714   */

      /* Empieza nodo:715 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(715)).setAttribute("ancho","100" );
      ((Element)v.get(715)).setAttribute("minimizable","S" );
      ((Element)v.get(715)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(715));
      /* Termina nodo:715   */

      /* Empieza nodo:716 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(716)).setAttribute("ancho","100" );
      ((Element)v.get(716)).setAttribute("minimizable","S" );
      ((Element)v.get(716)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(716));
      /* Termina nodo:716   */

      /* Empieza nodo:717 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(717)).setAttribute("ancho","100" );
      ((Element)v.get(717)).setAttribute("minimizable","S" );
      ((Element)v.get(717)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(717));
      /* Termina nodo:717   */

      /* Empieza nodo:718 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(718)).setAttribute("ancho","100" );
      ((Element)v.get(718)).setAttribute("minimizable","S" );
      ((Element)v.get(718)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(718));
      /* Termina nodo:718   */

      /* Empieza nodo:719 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(719)).setAttribute("ancho","100" );
      ((Element)v.get(719)).setAttribute("minimizable","S" );
      ((Element)v.get(719)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(719));
      /* Termina nodo:719   */

      /* Empieza nodo:720 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(720)).setAttribute("ancho","100" );
      ((Element)v.get(720)).setAttribute("minimizable","S" );
      ((Element)v.get(720)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(720));
      /* Termina nodo:720   */

      /* Empieza nodo:721 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(721)).setAttribute("ancho","100" );
      ((Element)v.get(721)).setAttribute("minimizable","S" );
      ((Element)v.get(721)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(721));
      /* Termina nodo:721   */

      /* Empieza nodo:722 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(722)).setAttribute("ancho","100" );
      ((Element)v.get(722)).setAttribute("minimizable","S" );
      ((Element)v.get(722)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(722));
      /* Termina nodo:722   */

      /* Empieza nodo:723 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(723)).setAttribute("ancho","100" );
      ((Element)v.get(723)).setAttribute("minimizable","S" );
      ((Element)v.get(723)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(723));
      /* Termina nodo:723   */

      /* Empieza nodo:724 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(724)).setAttribute("ancho","100" );
      ((Element)v.get(724)).setAttribute("minimizable","S" );
      ((Element)v.get(724)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(724));
      /* Termina nodo:724   */

      /* Empieza nodo:725 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(725)).setAttribute("ancho","100" );
      ((Element)v.get(725)).setAttribute("minimizable","S" );
      ((Element)v.get(725)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(725));
      /* Termina nodo:725   */

      /* Empieza nodo:726 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(726)).setAttribute("ancho","100" );
      ((Element)v.get(726)).setAttribute("minimizable","S" );
      ((Element)v.get(726)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(726));
      /* Termina nodo:726   */

      /* Empieza nodo:727 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(727)).setAttribute("ancho","100" );
      ((Element)v.get(727)).setAttribute("minimizable","S" );
      ((Element)v.get(727)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(727));
      /* Termina nodo:727   */

      /* Empieza nodo:728 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(728)).setAttribute("ancho","100" );
      ((Element)v.get(728)).setAttribute("minimizable","S" );
      ((Element)v.get(728)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(728));
      /* Termina nodo:728   */
      /* Termina nodo:705   */

      /* Empieza nodo:729 / Elemento padre: 696   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(729)).setAttribute("height","20" );
      ((Element)v.get(729)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(729)).setAttribute("imgFondo","" );
      ((Element)v.get(729)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(696)).appendChild((Element)v.get(729));

      /* Empieza nodo:730 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(730)).setAttribute("colFondo","" );
      ((Element)v.get(730)).setAttribute("ID","EstCab" );
      ((Element)v.get(730)).setAttribute("cod","PedTipoSolicPais.tsolOidTipoSoli.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(730));
      /* Termina nodo:730   */

      /* Empieza nodo:731 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
   }

   private void getXML3330(Document doc) {
      ((Element)v.get(731)).setAttribute("colFondo","" );
      ((Element)v.get(731)).setAttribute("ID","EstCab" );
      ((Element)v.get(731)).setAttribute("cod","PedTipoSolicPais.numSoliLote.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(731));
      /* Termina nodo:731   */

      /* Empieza nodo:732 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(732)).setAttribute("colFondo","" );
      ((Element)v.get(732)).setAttribute("ID","EstCab" );
      ((Element)v.get(732)).setAttribute("cod","PedTipoSolicPais.numUnidAlar.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(732));
      /* Termina nodo:732   */

      /* Empieza nodo:733 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(733)).setAttribute("colFondo","" );
      ((Element)v.get(733)).setAttribute("ID","EstCab" );
      ((Element)v.get(733)).setAttribute("cod","PedTipoSolicPais.fopaOidFormPago.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(733));
      /* Termina nodo:733   */

      /* Empieza nodo:734 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(734)).setAttribute("colFondo","" );
      ((Element)v.get(734)).setAttribute("ID","EstCab" );
      ((Element)v.get(734)).setAttribute("cod","PedTipoSolicPais.indSujeFlet.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(734));
      /* Termina nodo:734   */

      /* Empieza nodo:735 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(735)).setAttribute("colFondo","" );
      ((Element)v.get(735)).setAttribute("ID","EstCab" );
      ((Element)v.get(735)).setAttribute("cod","PedTipoSolicPais.indReseStoc.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(735));
      /* Termina nodo:735   */

      /* Empieza nodo:736 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(736)).setAttribute("colFondo","" );
      ((Element)v.get(736)).setAttribute("ID","EstCab" );
      ((Element)v.get(736)).setAttribute("cod","PedTipoSolicPais.indPermReve.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(736));
      /* Termina nodo:736   */

      /* Empieza nodo:737 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(737)).setAttribute("colFondo","" );
      ((Element)v.get(737)).setAttribute("ID","EstCab" );
      ((Element)v.get(737)).setAttribute("cod","PedTipoSolicPais.indPediPrue.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(737));
      /* Termina nodo:737   */

      /* Empieza nodo:738 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(738)).setAttribute("colFondo","" );
      ((Element)v.get(738)).setAttribute("ID","EstCab" );
      ((Element)v.get(738)).setAttribute("cod","PedTipoSolicPais.indComi.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(738));
      /* Termina nodo:738   */

      /* Empieza nodo:739 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(739)).setAttribute("colFondo","" );
      ((Element)v.get(739)).setAttribute("ID","EstCab" );
      ((Element)v.get(739)).setAttribute("cod","PedTipoSolicPais.indVentInteSab14.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(739));
      /* Termina nodo:739   */

      /* Empieza nodo:740 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(740)).setAttribute("colFondo","" );
      ((Element)v.get(740)).setAttribute("ID","EstCab" );
      ((Element)v.get(740)).setAttribute("cod","PedTipoSolicPais.cactOidActi.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(740));
      /* Termina nodo:740   */

      /* Empieza nodo:741 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(741)).setAttribute("colFondo","" );
      ((Element)v.get(741)).setAttribute("ID","EstCab" );
      ((Element)v.get(741)).setAttribute("cod","PedTipoSolicPais.moneOidMone.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(741));
      /* Termina nodo:741   */

      /* Empieza nodo:742 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(742)).setAttribute("colFondo","" );
      ((Element)v.get(742)).setAttribute("ID","EstCab" );
      ((Element)v.get(742)).setAttribute("cod","PedTipoSolicPais.tmalOidTipoMoviAsig.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(742));
      /* Termina nodo:742   */

      /* Empieza nodo:743 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(743)).setAttribute("colFondo","" );
      ((Element)v.get(743)).setAttribute("ID","EstCab" );
      ((Element)v.get(743)).setAttribute("cod","PedTipoSolicPais.tmalOidTipoMoviRese.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(743));
      /* Termina nodo:743   */

      /* Empieza nodo:744 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(744)).setAttribute("colFondo","" );
      ((Element)v.get(744)).setAttribute("ID","EstCab" );
      ((Element)v.get(744)).setAttribute("cod","PedTipoSolicPais.tmalOidTipoMoviFact.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(744));
      /* Termina nodo:744   */

      /* Empieza nodo:745 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(745)).setAttribute("colFondo","" );
      ((Element)v.get(745)).setAttribute("ID","EstCab" );
      ((Element)v.get(745)).setAttribute("cod","PedTipoSolicPais.tidoOidTipoDocu.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(745));
      /* Termina nodo:745   */

      /* Empieza nodo:746 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(746)).setAttribute("colFondo","" );
      ((Element)v.get(746)).setAttribute("ID","EstCab" );
      ((Element)v.get(746)).setAttribute("cod","PedTipoSolicPais.indPermUnio.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(746));
      /* Termina nodo:746   */

      /* Empieza nodo:747 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(747)).setAttribute("colFondo","" );
      ((Element)v.get(747)).setAttribute("ID","EstCab" );
      ((Element)v.get(747)).setAttribute("cod","PedTipoSolicPais.indPediGtZona.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(747));
      /* Termina nodo:747   */

      /* Empieza nodo:748 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(748)).setAttribute("colFondo","" );
      ((Element)v.get(748)).setAttribute("ID","EstCab" );
      ((Element)v.get(748)).setAttribute("cod","PedTipoSolicPais.indCambVentBel.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(748));
      /* Termina nodo:748   */

      /* Empieza nodo:749 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
   }

   private void getXML3420(Document doc) {
      ((Element)v.get(749)).setAttribute("colFondo","" );
      ((Element)v.get(749)).setAttribute("ID","EstCab" );
      ((Element)v.get(749)).setAttribute("cod","PedTipoSolicPais.almcOidAlma.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(749));
      /* Termina nodo:749   */

      /* Empieza nodo:750 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(750)).setAttribute("colFondo","" );
      ((Element)v.get(750)).setAttribute("ID","EstCab" );
      ((Element)v.get(750)).setAttribute("cod","PedTipoSolicPais.sociOidSoci.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(750));
      /* Termina nodo:750   */

      /* Empieza nodo:751 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(751)).setAttribute("colFondo","" );
      ((Element)v.get(751)).setAttribute("ID","EstCab" );
      ((Element)v.get(751)).setAttribute("cod","PedTipoSolicPais.valGlos.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(751));
      /* Termina nodo:751   */

      /* Empieza nodo:752 / Elemento padre: 729   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(752)).setAttribute("colFondo","" );
      ((Element)v.get(752)).setAttribute("ID","EstCab" );
      ((Element)v.get(752)).setAttribute("cod","PedTipoSolicPais.tsolOidTipoCons.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(752));
      /* Termina nodo:752   */
      /* Termina nodo:729   */

      /* Empieza nodo:753 / Elemento padre: 696   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(753)).setAttribute("alto","22" );
      ((Element)v.get(753)).setAttribute("accion","" );
      ((Element)v.get(753)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(753)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(753)).setAttribute("maxSel","1" );
      ((Element)v.get(753)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(753)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(753)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(753)).setAttribute("onLoad","" );
      ((Element)v.get(753)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(696)).appendChild((Element)v.get(753));

      /* Empieza nodo:754 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(754)).setAttribute("tipo","texto" );
      ((Element)v.get(754)).setAttribute("ID","EstDat" );
      ((Element)v.get(753)).appendChild((Element)v.get(754));
      /* Termina nodo:754   */

      /* Empieza nodo:755 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(755)).setAttribute("tipo","texto" );
      ((Element)v.get(755)).setAttribute("ID","EstDat2" );
      ((Element)v.get(753)).appendChild((Element)v.get(755));
      /* Termina nodo:755   */

      /* Empieza nodo:756 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(756)).setAttribute("tipo","texto" );
      ((Element)v.get(756)).setAttribute("ID","EstDat" );
      ((Element)v.get(753)).appendChild((Element)v.get(756));
      /* Termina nodo:756   */

      /* Empieza nodo:757 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(757)).setAttribute("tipo","texto" );
      ((Element)v.get(757)).setAttribute("ID","EstDat2" );
      ((Element)v.get(753)).appendChild((Element)v.get(757));
      /* Termina nodo:757   */

      /* Empieza nodo:758 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(758)).setAttribute("tipo","texto" );
      ((Element)v.get(758)).setAttribute("ID","EstDat" );
      ((Element)v.get(753)).appendChild((Element)v.get(758));
      /* Termina nodo:758   */

      /* Empieza nodo:759 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(759)).setAttribute("tipo","texto" );
      ((Element)v.get(759)).setAttribute("ID","EstDat2" );
      ((Element)v.get(753)).appendChild((Element)v.get(759));
      /* Termina nodo:759   */

      /* Empieza nodo:760 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(760)).setAttribute("tipo","texto" );
      ((Element)v.get(760)).setAttribute("ID","EstDat" );
      ((Element)v.get(753)).appendChild((Element)v.get(760));
      /* Termina nodo:760   */

      /* Empieza nodo:761 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(761)).setAttribute("tipo","texto" );
      ((Element)v.get(761)).setAttribute("ID","EstDat2" );
      ((Element)v.get(753)).appendChild((Element)v.get(761));
      /* Termina nodo:761   */

      /* Empieza nodo:762 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(762)).setAttribute("tipo","texto" );
      ((Element)v.get(762)).setAttribute("ID","EstDat" );
      ((Element)v.get(753)).appendChild((Element)v.get(762));
      /* Termina nodo:762   */

      /* Empieza nodo:763 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(763)).setAttribute("tipo","texto" );
      ((Element)v.get(763)).setAttribute("ID","EstDat2" );
      ((Element)v.get(753)).appendChild((Element)v.get(763));
      /* Termina nodo:763   */

      /* Empieza nodo:764 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(764)).setAttribute("tipo","texto" );
      ((Element)v.get(764)).setAttribute("ID","EstDat" );
      ((Element)v.get(753)).appendChild((Element)v.get(764));
      /* Termina nodo:764   */

      /* Empieza nodo:765 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(765)).setAttribute("tipo","texto" );
      ((Element)v.get(765)).setAttribute("ID","EstDat2" );
      ((Element)v.get(753)).appendChild((Element)v.get(765));
      /* Termina nodo:765   */

      /* Empieza nodo:766 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(766)).setAttribute("tipo","texto" );
      ((Element)v.get(766)).setAttribute("ID","EstDat" );
      ((Element)v.get(753)).appendChild((Element)v.get(766));
      /* Termina nodo:766   */

      /* Empieza nodo:767 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(767)).setAttribute("tipo","texto" );
      ((Element)v.get(767)).setAttribute("ID","EstDat2" );
      ((Element)v.get(753)).appendChild((Element)v.get(767));
      /* Termina nodo:767   */

      /* Empieza nodo:768 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(768)).setAttribute("tipo","texto" );
      ((Element)v.get(768)).setAttribute("ID","EstDat" );
   }

   private void getXML3510(Document doc) {
      ((Element)v.get(753)).appendChild((Element)v.get(768));
      /* Termina nodo:768   */

      /* Empieza nodo:769 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(769)).setAttribute("tipo","texto" );
      ((Element)v.get(769)).setAttribute("ID","EstDat2" );
      ((Element)v.get(753)).appendChild((Element)v.get(769));
      /* Termina nodo:769   */

      /* Empieza nodo:770 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(770)).setAttribute("tipo","texto" );
      ((Element)v.get(770)).setAttribute("ID","EstDat" );
      ((Element)v.get(753)).appendChild((Element)v.get(770));
      /* Termina nodo:770   */

      /* Empieza nodo:771 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(771)).setAttribute("tipo","texto" );
      ((Element)v.get(771)).setAttribute("ID","EstDat2" );
      ((Element)v.get(753)).appendChild((Element)v.get(771));
      /* Termina nodo:771   */

      /* Empieza nodo:772 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(772)).setAttribute("tipo","texto" );
      ((Element)v.get(772)).setAttribute("ID","EstDat" );
      ((Element)v.get(753)).appendChild((Element)v.get(772));
      /* Termina nodo:772   */

      /* Empieza nodo:773 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(773)).setAttribute("tipo","texto" );
      ((Element)v.get(773)).setAttribute("ID","EstDat2" );
      ((Element)v.get(753)).appendChild((Element)v.get(773));
      /* Termina nodo:773   */

      /* Empieza nodo:774 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(774)).setAttribute("tipo","texto" );
      ((Element)v.get(774)).setAttribute("ID","EstDat" );
      ((Element)v.get(753)).appendChild((Element)v.get(774));
      /* Termina nodo:774   */

      /* Empieza nodo:775 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(775)).setAttribute("tipo","texto" );
      ((Element)v.get(775)).setAttribute("ID","EstDat2" );
      ((Element)v.get(753)).appendChild((Element)v.get(775));
      /* Termina nodo:775   */

      /* Empieza nodo:776 / Elemento padre: 753   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(776)).setAttribute("tipo","texto" );
      ((Element)v.get(776)).setAttribute("ID","EstDat" );
      ((Element)v.get(753)).appendChild((Element)v.get(776));
      /* Termina nodo:776   */
      /* Termina nodo:753   */

      /* Empieza nodo:777 / Elemento padre: 696   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(696)).appendChild((Element)v.get(777));
      /* Termina nodo:777   */
      /* Termina nodo:696   */
      /* Termina nodo:695   */

      /* Empieza nodo:778 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(778)).setAttribute("nombre","pedTipoSolicPaisListButtonsLayer" );
      ((Element)v.get(778)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(778)).setAttribute("alto","30" );
      ((Element)v.get(778)).setAttribute("ancho","98%" );
      ((Element)v.get(778)).setAttribute("borde","n" );
      ((Element)v.get(778)).setAttribute("imagenf","" );
      ((Element)v.get(778)).setAttribute("repeat","" );
      ((Element)v.get(778)).setAttribute("padding","0" );
      ((Element)v.get(778)).setAttribute("contravsb","" );
      ((Element)v.get(778)).setAttribute("x","16" );
      ((Element)v.get(778)).setAttribute("y","" );
      ((Element)v.get(778)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(778));

      /* Empieza nodo:779 / Elemento padre: 778   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(779)).setAttribute("nombre","toolbarSeparatorLayer" );
      ((Element)v.get(779)).setAttribute("visibilidad","inherit" );
      ((Element)v.get(779)).setAttribute("alto","23" );
      ((Element)v.get(779)).setAttribute("ancho","1" );
      ((Element)v.get(779)).setAttribute("borde","1" );
      ((Element)v.get(779)).setAttribute("imagenf","" );
      ((Element)v.get(779)).setAttribute("repeat","" );
      ((Element)v.get(779)).setAttribute("padding","0" );
      ((Element)v.get(779)).setAttribute("contravsb","" );
      ((Element)v.get(779)).setAttribute("x","56" );
      ((Element)v.get(779)).setAttribute("y","0" );
      ((Element)v.get(779)).setAttribute("zindex","" );
      ((Element)v.get(779)).setAttribute("colborde","#999999" );
      ((Element)v.get(778)).appendChild((Element)v.get(779));
      /* Termina nodo:779   */

      /* Empieza nodo:780 / Elemento padre: 778   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(780)).setAttribute("width","100%" );
      ((Element)v.get(780)).setAttribute("border","0" );
      ((Element)v.get(780)).setAttribute("cellspacing","1" );
      ((Element)v.get(780)).setAttribute("cellpadding","0" );
      ((Element)v.get(778)).appendChild((Element)v.get(780));

      /* Empieza nodo:781 / Elemento padre: 780   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(780)).appendChild((Element)v.get(781));

      /* Empieza nodo:782 / Elemento padre: 781   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(782)).setAttribute("src","b.gif" );
      ((Element)v.get(782)).setAttribute("height","22" );
      ((Element)v.get(782)).setAttribute("width","5" );
      ((Element)v.get(781)).appendChild((Element)v.get(782));
      /* Termina nodo:782   */
      /* Termina nodo:781   */

      /* Empieza nodo:783 / Elemento padre: 780   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(780)).appendChild((Element)v.get(783));

      /* Empieza nodo:784 / Elemento padre: 783   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(784)).setAttribute("nombre","pedTipoSolicPaisPaginationButtonBar" );
      ((Element)v.get(784)).setAttribute("tipo","H" );
      ((Element)v.get(784)).setAttribute("x","0" );
      ((Element)v.get(784)).setAttribute("y","0" );
      ((Element)v.get(783)).appendChild((Element)v.get(784));

      /* Empieza nodo:785 / Elemento padre: 784   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(785)).setAttribute("nombre","pedTipoSolicPaisFirstPageButton" );
      ((Element)v.get(785)).setAttribute("funcion","pedTipoSolicPaisFirstPage();" );
      ((Element)v.get(785)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(785)).setAttribute("on","primera_over0.gif" );
   }

   private void getXML3600(Document doc) {
      ((Element)v.get(785)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(785)).setAttribute("estado","inactivo" );
      ((Element)v.get(784)).appendChild((Element)v.get(785));
      /* Termina nodo:785   */

      /* Empieza nodo:786 / Elemento padre: 784   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(786)).setAttribute("nombre","pedTipoSolicPaisFirstPageButtonGapTd" );
      ((Element)v.get(784)).appendChild((Element)v.get(786));

      /* Empieza nodo:787 / Elemento padre: 786   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(787)).setAttribute("src","b.gif" );
      ((Element)v.get(787)).setAttribute("height","8" );
      ((Element)v.get(787)).setAttribute("width","5" );
      ((Element)v.get(786)).appendChild((Element)v.get(787));
      /* Termina nodo:787   */
      /* Termina nodo:786   */

      /* Empieza nodo:788 / Elemento padre: 784   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(788)).setAttribute("nombre","pedTipoSolicPaisPreviousPageButton" );
      ((Element)v.get(788)).setAttribute("funcion","pedTipoSolicPaisPreviousPage();" );
      ((Element)v.get(788)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(788)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(788)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(788)).setAttribute("estado","inactivo" );
      ((Element)v.get(784)).appendChild((Element)v.get(788));
      /* Termina nodo:788   */

      /* Empieza nodo:789 / Elemento padre: 784   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(789)).setAttribute("nombre","pedTipoSolicPaisPreviousPageButtonGapTd" );
      ((Element)v.get(784)).appendChild((Element)v.get(789));

      /* Empieza nodo:790 / Elemento padre: 789   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(790)).setAttribute("src","b.gif" );
      ((Element)v.get(790)).setAttribute("height","8" );
      ((Element)v.get(790)).setAttribute("width","8" );
      ((Element)v.get(789)).appendChild((Element)v.get(790));
      /* Termina nodo:790   */
      /* Termina nodo:789   */

      /* Empieza nodo:791 / Elemento padre: 784   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(791)).setAttribute("nombre","pedTipoSolicPaisNextPageButton" );
      ((Element)v.get(791)).setAttribute("funcion","pedTipoSolicPaisNextPage();" );
      ((Element)v.get(791)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(791)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(791)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(791)).setAttribute("estado","inactivo" );
      ((Element)v.get(784)).appendChild((Element)v.get(791));
      /* Termina nodo:791   */
      /* Termina nodo:784   */
      /* Termina nodo:783   */

      /* Empieza nodo:792 / Elemento padre: 780   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(780)).appendChild((Element)v.get(792));

      /* Empieza nodo:793 / Elemento padre: 792   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(793)).setAttribute("src","b.gif" );
      ((Element)v.get(793)).setAttribute("height","22" );
      ((Element)v.get(793)).setAttribute("width","19" );
      ((Element)v.get(792)).appendChild((Element)v.get(793));
      /* Termina nodo:793   */
      /* Termina nodo:792   */

      /* Empieza nodo:794 / Elemento padre: 780   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(794)).setAttribute("class","tablaTitle" );
      ((Element)v.get(794)).setAttribute("nombre","pedTipoSolicPaisUpdateButtonTd" );
      ((Element)v.get(780)).appendChild((Element)v.get(794));

      /* Empieza nodo:795 / Elemento padre: 794   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(795)).setAttribute("nombre","pedTipoSolicPaisUpdateButton" );
      ((Element)v.get(795)).setAttribute("ID","botonContenido" );
      ((Element)v.get(795)).setAttribute("tipo","html" );
      ((Element)v.get(795)).setAttribute("accion","pedTipoSolicPaisUpdateSelection();" );
      ((Element)v.get(795)).setAttribute("estado","false" );
      ((Element)v.get(795)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(794)).appendChild((Element)v.get(795));
      /* Termina nodo:795   */
      /* Termina nodo:794   */

      /* Empieza nodo:796 / Elemento padre: 780   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(796)).setAttribute("nombre","pedTipoSolicPaisUpdateButtonGapTd" );
      ((Element)v.get(780)).appendChild((Element)v.get(796));

      /* Empieza nodo:797 / Elemento padre: 796   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(797)).setAttribute("src","b.gif" );
      ((Element)v.get(797)).setAttribute("height","8" );
      ((Element)v.get(797)).setAttribute("width","10" );
      ((Element)v.get(796)).appendChild((Element)v.get(797));
      /* Termina nodo:797   */
      /* Termina nodo:796   */

      /* Empieza nodo:798 / Elemento padre: 780   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(798)).setAttribute("class","tablaTitle" );
      ((Element)v.get(798)).setAttribute("nombre","pedTipoSolicPaisViewForRemoveButtonTd" );
      ((Element)v.get(780)).appendChild((Element)v.get(798));

      /* Empieza nodo:799 / Elemento padre: 798   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(799)).setAttribute("nombre","pedTipoSolicPaisViewForRemoveButton" );
      ((Element)v.get(799)).setAttribute("ID","botonContenido" );
      ((Element)v.get(799)).setAttribute("tipo","html" );
      ((Element)v.get(799)).setAttribute("accion","pedTipoSolicPaisViewSelection();" );
      ((Element)v.get(799)).setAttribute("estado","false" );
      ((Element)v.get(799)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(798)).appendChild((Element)v.get(799));
      /* Termina nodo:799   */
      /* Termina nodo:798   */

      /* Empieza nodo:800 / Elemento padre: 780   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(800)).setAttribute("nombre","pedTipoSolicPaisViewForRemoveButtonGapTd" );
      ((Element)v.get(780)).appendChild((Element)v.get(800));

      /* Empieza nodo:801 / Elemento padre: 800   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(801)).setAttribute("src","b.gif" );
      ((Element)v.get(801)).setAttribute("height","8" );
      ((Element)v.get(801)).setAttribute("width","10" );
      ((Element)v.get(800)).appendChild((Element)v.get(801));
      /* Termina nodo:801   */
      /* Termina nodo:800   */

      /* Empieza nodo:802 / Elemento padre: 780   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(802)).setAttribute("class","tablaTitle" );
      ((Element)v.get(802)).setAttribute("nombre","pedTipoSolicPaisLovSelectButtonTd" );
      ((Element)v.get(780)).appendChild((Element)v.get(802));

      /* Empieza nodo:803 / Elemento padre: 802   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(803)).setAttribute("nombre","pedTipoSolicPaisLovSelectButton" );
      ((Element)v.get(803)).setAttribute("ID","botonContenido" );
      ((Element)v.get(803)).setAttribute("tipo","html" );
   }

   private void getXML3690(Document doc) {
      ((Element)v.get(803)).setAttribute("accion","pedTipoSolicPaisLovSelectionAction();" );
      ((Element)v.get(803)).setAttribute("estado","true" );
      ((Element)v.get(803)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(802)).appendChild((Element)v.get(803));
      /* Termina nodo:803   */
      /* Termina nodo:802   */

      /* Empieza nodo:804 / Elemento padre: 780   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(804)).setAttribute("nombre","pedTipoSolicPaisLovSelectButtonGapTd" );
      ((Element)v.get(780)).appendChild((Element)v.get(804));

      /* Empieza nodo:805 / Elemento padre: 804   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(805)).setAttribute("src","b.gif" );
      ((Element)v.get(805)).setAttribute("height","8" );
      ((Element)v.get(805)).setAttribute("width","10" );
      ((Element)v.get(804)).appendChild((Element)v.get(805));
      /* Termina nodo:805   */
      /* Termina nodo:804   */

      /* Empieza nodo:806 / Elemento padre: 780   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(806)).setAttribute("class","tablaTitle" );
      ((Element)v.get(806)).setAttribute("nombre","pedTipoSolicPaisViewButtonTd" );
      ((Element)v.get(780)).appendChild((Element)v.get(806));

      /* Empieza nodo:807 / Elemento padre: 806   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(807)).setAttribute("nombre","pedTipoSolicPaisViewButton" );
      ((Element)v.get(807)).setAttribute("ID","botonContenido" );
      ((Element)v.get(807)).setAttribute("tipo","html" );
      ((Element)v.get(807)).setAttribute("accion","pedTipoSolicPaisViewSelection();" );
      ((Element)v.get(807)).setAttribute("estado","false" );
      ((Element)v.get(807)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(806)).appendChild((Element)v.get(807));
      /* Termina nodo:807   */
      /* Termina nodo:806   */

      /* Empieza nodo:808 / Elemento padre: 780   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(808)).setAttribute("nombre","pedTipoSolicPaisViewButtonGapTd" );
      ((Element)v.get(780)).appendChild((Element)v.get(808));

      /* Empieza nodo:809 / Elemento padre: 808   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(809)).setAttribute("src","b.gif" );
      ((Element)v.get(809)).setAttribute("height","8" );
      ((Element)v.get(809)).setAttribute("width","10" );
      ((Element)v.get(808)).appendChild((Element)v.get(809));
      /* Termina nodo:809   */
      /* Termina nodo:808   */

      /* Empieza nodo:810 / Elemento padre: 780   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(810)).setAttribute("width","100%" );
      ((Element)v.get(780)).appendChild((Element)v.get(810));
      /* Termina nodo:810   */
      /* Termina nodo:780   */
      /* Termina nodo:778   */
      /* Termina nodo:4   */


   }

}

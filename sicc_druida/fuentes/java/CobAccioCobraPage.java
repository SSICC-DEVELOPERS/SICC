
import org.w3c.dom.*;
import java.util.ArrayList;

public class CobAccioCobraPage  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","CobAccioCobraPage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","cobAccioCobraInitComponents()" );
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
      ((Element)v.get(3)).setAttribute("src","cobacciocobra.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","cobAccioCobraFrm" );
      ((Element)v.get(4)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","CobAccioCobraLPExecution" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","ON" );
      ((Element)v.get(6)).setAttribute("valor","CobAccioCobraLPExecution" );
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
      ((Element)v.get(36)).setAttribute("nombre","indFechHoraSeguCheckValue" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","indFechImpoCompCheckValue" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","indFechHoraNuevSeguCheckValue" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","indAporPrueCheckValue" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","indDescPrueCheckValue" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","indNumeDocuSopoCheckValue" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","indTipoDocuPagoCheckValue" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","indBancSucuCheckValue" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(44)).setAttribute("nombre","indNuevDireCheckValue" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","indNuevTelfCheckValue" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","indPasaAdmiCheckValue" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","indPetiBloqAdmiCheckValue" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","indPetiDesbAdmiCheckValue" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","indAcciMensRecoCheckValue" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","indObseCheckValue" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(51)).setAttribute("nombre","cobAccioCobraFormLayer" );
      ((Element)v.get(51)).setAttribute("alto","" );
      ((Element)v.get(51)).setAttribute("ancho","100%" );
      ((Element)v.get(51)).setAttribute("colorf","" );
      ((Element)v.get(51)).setAttribute("borde","0" );
      ((Element)v.get(51)).setAttribute("imagenf","" );
      ((Element)v.get(51)).setAttribute("repeat","" );
      ((Element)v.get(51)).setAttribute("padding","" );
      ((Element)v.get(51)).setAttribute("visibilidad","visible" );
      ((Element)v.get(51)).setAttribute("contravsb","" );
      ((Element)v.get(51)).setAttribute("x","0" );
      ((Element)v.get(51)).setAttribute("y","0" );
      ((Element)v.get(51)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(52)).setAttribute("width","100%" );
      ((Element)v.get(52)).setAttribute("border","0" );
      ((Element)v.get(52)).setAttribute("cellspacing","0" );
      ((Element)v.get(52)).setAttribute("cellpadding","0" );
      ((Element)v.get(52)).setAttribute("align","left" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(54)).setAttribute("align","center" );
      ((Element)v.get(54)).setAttribute("width","12" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","12" );
      ((Element)v.get(55)).setAttribute("height","12" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 53   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(56)).setAttribute("align","center" );
      ((Element)v.get(56)).setAttribute("width","750" );
      ((Element)v.get(53)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","12" );
      ((Element)v.get(57)).setAttribute("height","12" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 53   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(58)).setAttribute("align","center" );
      ((Element)v.get(58)).setAttribute("width","12" );
      ((Element)v.get(53)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","12" );
      ((Element)v.get(59)).setAttribute("height","12" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:53   */

      /* Empieza nodo:60 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(52)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(61)).setAttribute("align","center" );
      ((Element)v.get(61)).setAttribute("width","12" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","12" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 60   */
      v.add(doc.createElement("TD"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(63)).setAttribute("width","100%" );
      ((Element)v.get(60)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(65)).setAttribute("class","legend" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(66)).setAttribute("nombre","legendLbl" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("filas","1" );
      ((Element)v.get(66)).setAttribute("id","legend" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(66)).setAttribute("cod","CobAccioCobra.legend.label" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 64   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(67)).setAttribute("width","100%" );
      ((Element)v.get(67)).setAttribute("border","0" );
      ((Element)v.get(67)).setAttribute("align","center" );
      ((Element)v.get(67)).setAttribute("cellspacing","0" );
      ((Element)v.get(67)).setAttribute("cellpadding","0" );
      ((Element)v.get(64)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(69)).setAttribute("width","100%" );
      ((Element)v.get(69)).setAttribute("nowrap","true" );
      ((Element)v.get(69)).setAttribute("class","datosCampos" );
      ((Element)v.get(69)).setAttribute("colspan","3" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:71 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(71)).setAttribute("nombre","formTr0" );
      ((Element)v.get(67)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(72)).setAttribute("align","center" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","8" );
      ((Element)v.get(73)).setAttribute("height","12" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 71   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(74)).setAttribute("width","100%" );
      ((Element)v.get(71)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(75)).setAttribute("width","100%" );
      ((Element)v.get(75)).setAttribute("border","0" );
      ((Element)v.get(75)).setAttribute("cellspacing","0" );
      ((Element)v.get(75)).setAttribute("cellpadding","0" );
      ((Element)v.get(75)).setAttribute("align","left" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(76)).setAttribute("align","left" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(77)).setAttribute("nombre","idTdId" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(78)).setAttribute("width","100%" );
      ((Element)v.get(78)).setAttribute("border","0" );
      ((Element)v.get(78)).setAttribute("cellspacing","0" );
      ((Element)v.get(78)).setAttribute("cellpadding","0" );
      ((Element)v.get(78)).setAttribute("align","left" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(80)).setAttribute("valign","top" );
      ((Element)v.get(80)).setAttribute("height","13" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(81)).setAttribute("nombre","lblId" );
      ((Element)v.get(81)).setAttribute("alto","13" );
      ((Element)v.get(81)).setAttribute("filas","1" );
      ((Element)v.get(81)).setAttribute("id","datosTitle" );
      ((Element)v.get(81)).setAttribute("cod","CobAccioCobra.id.label" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:82 / Elemento padre: 78   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(82)).setAttribute("nombre","idWidgetTrId" );
      ((Element)v.get(78)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(83)).setAttribute("align","left" );
      ((Element)v.get(83)).setAttribute("nowrap","true" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(84)).setAttribute("nombre","id" );
      ((Element)v.get(84)).setAttribute("id","datosCampos" );
      ((Element)v.get(84)).setAttribute("trim","S" );
      ((Element)v.get(84)).setAttribute("max","12" );
      ((Element)v.get(84)).setAttribute("onchange","" );
      ((Element)v.get(84)).setAttribute("req","N" );
      ((Element)v.get(84)).setAttribute("size","12" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(84)).setAttribute("validacion","" );
      ((Element)v.get(84)).setAttribute("disabled","" );
      ((Element)v.get(84)).setAttribute("onblur","" );
      ((Element)v.get(84)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',1, true)" );
      ((Element)v.get(84)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm', 1, false)" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:85 / Elemento padre: 76   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(85)).setAttribute("nombre","idGapTdId" );
      ((Element)v.get(85)).setAttribute("nowrap","true" );
      ((Element)v.get(85)).setAttribute("class","datosCampos" );
      ((Element)v.get(76)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","25" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 76   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(87)).setAttribute("width","100%" );
      ((Element)v.get(76)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:71   */

      /* Empieza nodo:89 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(89)).setAttribute("nombre","formGapTr0" );
      ((Element)v.get(67)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(90)).setAttribute("align","center" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","12" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 89   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(89)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 89   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(94)).setAttribute("align","center" );
      ((Element)v.get(94)).setAttribute("width","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","12" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:89   */

      /* Empieza nodo:96 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(96)).setAttribute("nombre","formTr1" );
      ((Element)v.get(67)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(97)).setAttribute("align","center" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","8" );
      ((Element)v.get(98)).setAttribute("height","12" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 96   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(99)).setAttribute("width","100%" );
      ((Element)v.get(96)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(100)).setAttribute("width","100%" );
      ((Element)v.get(100)).setAttribute("border","0" );
      ((Element)v.get(100)).setAttribute("cellspacing","0" );
      ((Element)v.get(100)).setAttribute("cellpadding","0" );
      ((Element)v.get(100)).setAttribute("align","left" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(101)).setAttribute("align","left" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(102)).setAttribute("nombre","codAcciCobrTdId" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(103)).setAttribute("width","100%" );
      ((Element)v.get(103)).setAttribute("border","0" );
   }

   private void getXML450(Document doc) {
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
      ((Element)v.get(106)).setAttribute("nombre","lblCodAcciCobr" );
      ((Element)v.get(106)).setAttribute("alto","13" );
      ((Element)v.get(106)).setAttribute("filas","1" );
      ((Element)v.get(106)).setAttribute("id","datosTitle" );
      ((Element)v.get(106)).setAttribute("cod","CobAccioCobra.codAcciCobr.label" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:107 / Elemento padre: 103   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(107)).setAttribute("nombre","codAcciCobrWidgetTrId" );
      ((Element)v.get(103)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(108)).setAttribute("align","left" );
      ((Element)v.get(108)).setAttribute("nowrap","true" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(109)).setAttribute("nombre","codAcciCobr" );
      ((Element)v.get(109)).setAttribute("id","datosCampos" );
      ((Element)v.get(109)).setAttribute("trim","S" );
      ((Element)v.get(109)).setAttribute("max","2" );
      ((Element)v.get(109)).setAttribute("onchange","" );
      ((Element)v.get(109)).setAttribute("req","N" );
      ((Element)v.get(109)).setAttribute("size","2" );
      ((Element)v.get(109)).setAttribute("valor","" );
      ((Element)v.get(109)).setAttribute("validacion","" );
      ((Element)v.get(109)).setAttribute("disabled","" );
      ((Element)v.get(109)).setAttribute("onblur","" );
      ((Element)v.get(109)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',2, true)" );
      ((Element)v.get(109)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm', 2, false)" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:110 / Elemento padre: 101   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(110)).setAttribute("nombre","codAcciCobrGapTdId" );
      ((Element)v.get(110)).setAttribute("nowrap","true" );
      ((Element)v.get(110)).setAttribute("class","datosCampos" );
      ((Element)v.get(101)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","25" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 101   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(112)).setAttribute("nombre","valDescTdId" );
      ((Element)v.get(101)).appendChild((Element)v.get(112));

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
      ((Element)v.get(116)).setAttribute("nombre","lblValDesc" );
      ((Element)v.get(116)).setAttribute("alto","13" );
      ((Element)v.get(116)).setAttribute("filas","1" );
      ((Element)v.get(116)).setAttribute("id","datosTitle" );
      ((Element)v.get(116)).setAttribute("cod","CobAccioCobra.valDesc.label" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:117 / Elemento padre: 113   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(117)).setAttribute("nombre","valDescWidgetTrId" );
      ((Element)v.get(113)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(118)).setAttribute("align","left" );
      ((Element)v.get(118)).setAttribute("nowrap","true" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(119)).setAttribute("nombre","valDesc" );
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(119)).setAttribute("trim","S" );
      ((Element)v.get(119)).setAttribute("max","40" );
      ((Element)v.get(119)).setAttribute("onchange","" );
      ((Element)v.get(119)).setAttribute("req","N" );
      ((Element)v.get(119)).setAttribute("size","40" );
      ((Element)v.get(119)).setAttribute("valor","" );
      ((Element)v.get(119)).setAttribute("validacion","" );
      ((Element)v.get(119)).setAttribute("disabled","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(119)).setAttribute("onblur","" );
      ((Element)v.get(119)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',3, true)" );
      ((Element)v.get(119)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm', 3, false)" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:120 / Elemento padre: 101   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(120)).setAttribute("nombre","valDescGapTdId" );
      ((Element)v.get(120)).setAttribute("nowrap","true" );
      ((Element)v.get(120)).setAttribute("class","datosCampos" );
      ((Element)v.get(101)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","25" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 101   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(122)).setAttribute("nombre","saccOidSubtAcciTdId" );
      ((Element)v.get(101)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(123)).setAttribute("border","0" );
      ((Element)v.get(123)).setAttribute("cellspacing","0" );
      ((Element)v.get(123)).setAttribute("cellpadding","0" );
      ((Element)v.get(123)).setAttribute("align","left" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(125)).setAttribute("valign","top" );
      ((Element)v.get(125)).setAttribute("height","13" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(126)).setAttribute("nombre","lblsaccOidSubtAcci" );
      ((Element)v.get(126)).setAttribute("id","datosTitle" );
      ((Element)v.get(126)).setAttribute("ancho","150" );
      ((Element)v.get(126)).setAttribute("alto","13" );
      ((Element)v.get(126)).setAttribute("cod","CobAccioCobra.saccOidSubtAcci.label" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:127 / Elemento padre: 123   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(127)).setAttribute("nombre","saccOidSubtAcciWidgetTrId" );
      ((Element)v.get(123)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(128)).setAttribute("align","left" );
      ((Element)v.get(128)).setAttribute("nowrap","true" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(129)).setAttribute("nombre","saccOidSubtAcci" );
      ((Element)v.get(129)).setAttribute("id","datosCampos" );
      ((Element)v.get(129)).setAttribute("multiple","N" );
      ((Element)v.get(129)).setAttribute("req","N" );
      ((Element)v.get(129)).setAttribute("size","1" );
      ((Element)v.get(129)).setAttribute("disabled","" );
      ((Element)v.get(129)).setAttribute("validacion","" );
      ((Element)v.get(129)).setAttribute("onchange","" );
      ((Element)v.get(129)).setAttribute("onfocus","" );
      ((Element)v.get(129)).setAttribute("valorinicial","" );
      ((Element)v.get(129)).setAttribute("textoinicial","" );
      ((Element)v.get(129)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',4, true);" );
      ((Element)v.get(129)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',4, false);" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:131 / Elemento padre: 101   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(131)).setAttribute("nombre","saccOidSubtAcciGapTdId" );
      ((Element)v.get(131)).setAttribute("nowrap","true" );
      ((Element)v.get(131)).setAttribute("class","datosCampos" );
      ((Element)v.get(101)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","25" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 101   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(133)).setAttribute("width","100%" );
      ((Element)v.get(101)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:96   */

      /* Empieza nodo:135 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(135)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(67)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(136)).setAttribute("align","center" );
      ((Element)v.get(136)).setAttribute("width","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","12" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 135   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(135)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","8" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 135   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(140)).setAttribute("align","center" );
      ((Element)v.get(140)).setAttribute("width","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","12" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:135   */

      /* Empieza nodo:142 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(142)).setAttribute("nombre","formTr2" );
      ((Element)v.get(67)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(143)).setAttribute("align","center" );
      ((Element)v.get(143)).setAttribute("width","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(144)).setAttribute("height","12" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 142   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(145)).setAttribute("width","100%" );
      ((Element)v.get(142)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(146)).setAttribute("width","100%" );
      ((Element)v.get(146)).setAttribute("border","0" );
      ((Element)v.get(146)).setAttribute("cellspacing","0" );
      ((Element)v.get(146)).setAttribute("cellpadding","0" );
      ((Element)v.get(146)).setAttribute("align","left" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(147)).setAttribute("align","left" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(148)).setAttribute("nombre","indFechHoraSeguTdId" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

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
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(151)).setAttribute("valign","top" );
      ((Element)v.get(151)).setAttribute("height","13" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(152)).setAttribute("nombre","lblIndFechHoraSegu" );
      ((Element)v.get(152)).setAttribute("alto","13" );
      ((Element)v.get(152)).setAttribute("filas","1" );
      ((Element)v.get(152)).setAttribute("id","datosTitle" );
      ((Element)v.get(152)).setAttribute("cod","CobAccioCobra.indFechHoraSegu.label" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:153 / Elemento padre: 149   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(153)).setAttribute("nombre","indFechHoraSeguWidgetTrId" );
      ((Element)v.get(149)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(154)).setAttribute("align","left" );
      ((Element)v.get(154)).setAttribute("nowrap","true" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(155)).setAttribute("nombre","indFechHoraSegu" );
      ((Element)v.get(155)).setAttribute("tipo","H" );
      ((Element)v.get(155)).setAttribute("req","N" );
      ((Element)v.get(155)).setAttribute("id","datosCampos" );
      ((Element)v.get(155)).setAttribute("valor","" );
      ((Element)v.get(155)).setAttribute("disabled","" );
      ((Element)v.get(155)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',5, true)" );
      ((Element)v.get(155)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',5, false)" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(156)).setAttribute("id","datosCampos" );
      ((Element)v.get(156)).setAttribute("valor","1" );
      ((Element)v.get(156)).setAttribute("cod","CobAccioCobra.indFechHoraSegu.1.label" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Elemento padre:156 / Elemento actual: 157   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(156)).appendChild((Text)v.get(157));

      /* Termina nodo Texto:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 155   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(158)).setAttribute("id","datosCampos" );
      ((Element)v.get(158)).setAttribute("valor","0" );
      ((Element)v.get(158)).setAttribute("cod","CobAccioCobra.indFechHoraSegu.0.label" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(155)).appendChild((Element)v.get(158));

      /* Elemento padre:158 / Elemento actual: 159   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(158)).appendChild((Text)v.get(159));

      /* Termina nodo Texto:159   */
      /* Termina nodo:158   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:160 / Elemento padre: 147   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(160)).setAttribute("nombre","indFechHoraSeguGapTdId" );
      ((Element)v.get(160)).setAttribute("nowrap","true" );
      ((Element)v.get(160)).setAttribute("class","datosCampos" );
      ((Element)v.get(147)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","25" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 147   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(162)).setAttribute("width","100%" );
      ((Element)v.get(147)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:142   */

      /* Empieza nodo:164 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(164)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(67)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(165)).setAttribute("align","center" );
      ((Element)v.get(165)).setAttribute("width","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","12" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 164   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(164)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 164   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(169)).setAttribute("align","center" );
      ((Element)v.get(169)).setAttribute("width","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","12" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:164   */

      /* Empieza nodo:171 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(171)).setAttribute("nombre","formTr3" );
      ((Element)v.get(67)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(172)).setAttribute("align","center" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","8" );
      ((Element)v.get(173)).setAttribute("height","12" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 171   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(174)).setAttribute("width","100%" );
      ((Element)v.get(171)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(175)).setAttribute("width","100%" );
      ((Element)v.get(175)).setAttribute("border","0" );
      ((Element)v.get(175)).setAttribute("cellspacing","0" );
      ((Element)v.get(175)).setAttribute("cellpadding","0" );
      ((Element)v.get(175)).setAttribute("align","left" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(176)).setAttribute("align","left" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(177)).setAttribute("nombre","indFechImpoCompTdId" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(178)).setAttribute("width","100%" );
      ((Element)v.get(178)).setAttribute("border","0" );
      ((Element)v.get(178)).setAttribute("cellspacing","0" );
      ((Element)v.get(178)).setAttribute("cellpadding","0" );
      ((Element)v.get(178)).setAttribute("align","left" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(180)).setAttribute("valign","top" );
      ((Element)v.get(180)).setAttribute("height","13" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(181)).setAttribute("nombre","lblIndFechImpoComp" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(181)).setAttribute("alto","13" );
      ((Element)v.get(181)).setAttribute("filas","1" );
      ((Element)v.get(181)).setAttribute("id","datosTitle" );
      ((Element)v.get(181)).setAttribute("cod","CobAccioCobra.indFechImpoComp.label" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:182 / Elemento padre: 178   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(182)).setAttribute("nombre","indFechImpoCompWidgetTrId" );
      ((Element)v.get(178)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(183)).setAttribute("align","left" );
      ((Element)v.get(183)).setAttribute("nowrap","true" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(184)).setAttribute("nombre","indFechImpoComp" );
      ((Element)v.get(184)).setAttribute("tipo","H" );
      ((Element)v.get(184)).setAttribute("req","N" );
      ((Element)v.get(184)).setAttribute("id","datosCampos" );
      ((Element)v.get(184)).setAttribute("valor","" );
      ((Element)v.get(184)).setAttribute("disabled","" );
      ((Element)v.get(184)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',6, true)" );
      ((Element)v.get(184)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',6, false)" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(185)).setAttribute("id","datosCampos" );
      ((Element)v.get(185)).setAttribute("valor","1" );
      ((Element)v.get(185)).setAttribute("cod","CobAccioCobra.indFechImpoComp.1.label" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Elemento padre:185 / Elemento actual: 186   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(185)).appendChild((Text)v.get(186));

      /* Termina nodo Texto:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 184   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(187)).setAttribute("id","datosCampos" );
      ((Element)v.get(187)).setAttribute("valor","0" );
      ((Element)v.get(187)).setAttribute("cod","CobAccioCobra.indFechImpoComp.0.label" );
      ((Element)v.get(184)).appendChild((Element)v.get(187));

      /* Elemento padre:187 / Elemento actual: 188   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(187)).appendChild((Text)v.get(188));

      /* Termina nodo Texto:188   */
      /* Termina nodo:187   */
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:189 / Elemento padre: 176   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(189)).setAttribute("nombre","indFechImpoCompGapTdId" );
      ((Element)v.get(189)).setAttribute("nowrap","true" );
      ((Element)v.get(189)).setAttribute("class","datosCampos" );
      ((Element)v.get(176)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","25" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 176   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(191)).setAttribute("width","100%" );
      ((Element)v.get(176)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:171   */

      /* Empieza nodo:193 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(193)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(67)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(194)).setAttribute("align","center" );
      ((Element)v.get(194)).setAttribute("width","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","12" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 193   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(193)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 193   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(198)).setAttribute("align","center" );
      ((Element)v.get(198)).setAttribute("width","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).setAttribute("width","12" );
      ((Element)v.get(199)).setAttribute("height","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:193   */

      /* Empieza nodo:200 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(200)).setAttribute("nombre","formTr4" );
      ((Element)v.get(67)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(201)).setAttribute("align","center" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","8" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(202)).setAttribute("height","12" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 200   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(203)).setAttribute("width","100%" );
      ((Element)v.get(200)).appendChild((Element)v.get(203));

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
      ((Element)v.get(205)).setAttribute("align","left" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(206)).setAttribute("nombre","indFechHoraNuevSeguTdId" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

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
      ((Element)v.get(210)).setAttribute("nombre","lblIndFechHoraNuevSegu" );
      ((Element)v.get(210)).setAttribute("alto","13" );
      ((Element)v.get(210)).setAttribute("filas","1" );
      ((Element)v.get(210)).setAttribute("id","datosTitle" );
      ((Element)v.get(210)).setAttribute("cod","CobAccioCobra.indFechHoraNuevSegu.label" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:211 / Elemento padre: 207   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(211)).setAttribute("nombre","indFechHoraNuevSeguWidgetTrId" );
      ((Element)v.get(207)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(212)).setAttribute("align","left" );
      ((Element)v.get(212)).setAttribute("nowrap","true" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(213)).setAttribute("nombre","indFechHoraNuevSegu" );
      ((Element)v.get(213)).setAttribute("tipo","H" );
      ((Element)v.get(213)).setAttribute("req","N" );
      ((Element)v.get(213)).setAttribute("id","datosCampos" );
      ((Element)v.get(213)).setAttribute("valor","" );
      ((Element)v.get(213)).setAttribute("disabled","" );
      ((Element)v.get(213)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',7, true)" );
      ((Element)v.get(213)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',7, false)" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(214)).setAttribute("id","datosCampos" );
      ((Element)v.get(214)).setAttribute("valor","1" );
      ((Element)v.get(214)).setAttribute("cod","CobAccioCobra.indFechHoraNuevSegu.1.label" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Elemento padre:214 / Elemento actual: 215   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(214)).appendChild((Text)v.get(215));

      /* Termina nodo Texto:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 213   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(216)).setAttribute("id","datosCampos" );
      ((Element)v.get(216)).setAttribute("valor","0" );
      ((Element)v.get(216)).setAttribute("cod","CobAccioCobra.indFechHoraNuevSegu.0.label" );
      ((Element)v.get(213)).appendChild((Element)v.get(216));

      /* Elemento padre:216 / Elemento actual: 217   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(216)).appendChild((Text)v.get(217));

      /* Termina nodo Texto:217   */
      /* Termina nodo:216   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:218 / Elemento padre: 205   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(218)).setAttribute("nombre","indFechHoraNuevSeguGapTdId" );
      ((Element)v.get(218)).setAttribute("nowrap","true" );
      ((Element)v.get(218)).setAttribute("class","datosCampos" );
      ((Element)v.get(205)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","25" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 205   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(220)).setAttribute("width","100%" );
      ((Element)v.get(205)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:200   */

      /* Empieza nodo:222 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(222)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(67)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(223)).setAttribute("align","center" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(223)).setAttribute("width","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","12" );
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 222   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(222)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","8" );
      ((Element)v.get(226)).setAttribute("height","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 222   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(227)).setAttribute("align","center" );
      ((Element)v.get(227)).setAttribute("width","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","12" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:222   */

      /* Empieza nodo:229 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(229)).setAttribute("nombre","formTr5" );
      ((Element)v.get(67)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(230)).setAttribute("align","center" );
      ((Element)v.get(230)).setAttribute("width","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","8" );
      ((Element)v.get(231)).setAttribute("height","12" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 229   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(232)).setAttribute("width","100%" );
      ((Element)v.get(229)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(233)).setAttribute("width","100%" );
      ((Element)v.get(233)).setAttribute("border","0" );
      ((Element)v.get(233)).setAttribute("cellspacing","0" );
      ((Element)v.get(233)).setAttribute("cellpadding","0" );
      ((Element)v.get(233)).setAttribute("align","left" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(234)).setAttribute("align","left" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(235)).setAttribute("nombre","indAporPrueTdId" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

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
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(238)).setAttribute("valign","top" );
      ((Element)v.get(238)).setAttribute("height","13" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(239)).setAttribute("nombre","lblIndAporPrue" );
      ((Element)v.get(239)).setAttribute("alto","13" );
      ((Element)v.get(239)).setAttribute("filas","1" );
      ((Element)v.get(239)).setAttribute("id","datosTitle" );
      ((Element)v.get(239)).setAttribute("cod","CobAccioCobra.indAporPrue.label" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:240 / Elemento padre: 236   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(240)).setAttribute("nombre","indAporPrueWidgetTrId" );
      ((Element)v.get(236)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(241)).setAttribute("align","left" );
      ((Element)v.get(241)).setAttribute("nowrap","true" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(242)).setAttribute("nombre","indAporPrue" );
      ((Element)v.get(242)).setAttribute("tipo","H" );
      ((Element)v.get(242)).setAttribute("req","N" );
      ((Element)v.get(242)).setAttribute("id","datosCampos" );
      ((Element)v.get(242)).setAttribute("valor","" );
      ((Element)v.get(242)).setAttribute("disabled","" );
      ((Element)v.get(242)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',8, true)" );
      ((Element)v.get(242)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',8, false)" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(243)).setAttribute("id","datosCampos" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(243)).setAttribute("valor","1" );
      ((Element)v.get(243)).setAttribute("cod","CobAccioCobra.indAporPrue.1.label" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Elemento padre:243 / Elemento actual: 244   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(243)).appendChild((Text)v.get(244));

      /* Termina nodo Texto:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 242   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(245)).setAttribute("id","datosCampos" );
      ((Element)v.get(245)).setAttribute("valor","0" );
      ((Element)v.get(245)).setAttribute("cod","CobAccioCobra.indAporPrue.0.label" );
      ((Element)v.get(242)).appendChild((Element)v.get(245));

      /* Elemento padre:245 / Elemento actual: 246   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(245)).appendChild((Text)v.get(246));

      /* Termina nodo Texto:246   */
      /* Termina nodo:245   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:247 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(247)).setAttribute("nombre","indAporPrueGapTdId" );
      ((Element)v.get(247)).setAttribute("nowrap","true" );
      ((Element)v.get(247)).setAttribute("class","datosCampos" );
      ((Element)v.get(234)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","25" );
      ((Element)v.get(248)).setAttribute("height","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(249)).setAttribute("width","100%" );
      ((Element)v.get(234)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:229   */

      /* Empieza nodo:251 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(251)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(67)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(252)).setAttribute("align","center" );
      ((Element)v.get(252)).setAttribute("width","8" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","12" );
      ((Element)v.get(253)).setAttribute("height","8" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 251   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(251)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","8" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 251   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(256)).setAttribute("align","center" );
      ((Element)v.get(256)).setAttribute("width","8" );
      ((Element)v.get(251)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","12" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:251   */

      /* Empieza nodo:258 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(258)).setAttribute("nombre","formTr6" );
      ((Element)v.get(67)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(259)).setAttribute("align","center" );
      ((Element)v.get(259)).setAttribute("width","8" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","8" );
      ((Element)v.get(260)).setAttribute("height","12" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 258   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(261)).setAttribute("width","100%" );
      ((Element)v.get(258)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(262)).setAttribute("width","100%" );
      ((Element)v.get(262)).setAttribute("border","0" );
      ((Element)v.get(262)).setAttribute("cellspacing","0" );
      ((Element)v.get(262)).setAttribute("cellpadding","0" );
      ((Element)v.get(262)).setAttribute("align","left" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(263)).setAttribute("align","left" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(264)).setAttribute("nombre","indDescPrueTdId" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(265)).setAttribute("width","100%" );
      ((Element)v.get(265)).setAttribute("border","0" );
      ((Element)v.get(265)).setAttribute("cellspacing","0" );
      ((Element)v.get(265)).setAttribute("cellpadding","0" );
      ((Element)v.get(265)).setAttribute("align","left" );
   }

   private void getXML1170(Document doc) {
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
      ((Element)v.get(268)).setAttribute("nombre","lblIndDescPrue" );
      ((Element)v.get(268)).setAttribute("alto","13" );
      ((Element)v.get(268)).setAttribute("filas","1" );
      ((Element)v.get(268)).setAttribute("id","datosTitle" );
      ((Element)v.get(268)).setAttribute("cod","CobAccioCobra.indDescPrue.label" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:269 / Elemento padre: 265   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(269)).setAttribute("nombre","indDescPrueWidgetTrId" );
      ((Element)v.get(265)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(270)).setAttribute("align","left" );
      ((Element)v.get(270)).setAttribute("nowrap","true" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(271)).setAttribute("nombre","indDescPrue" );
      ((Element)v.get(271)).setAttribute("tipo","H" );
      ((Element)v.get(271)).setAttribute("req","N" );
      ((Element)v.get(271)).setAttribute("id","datosCampos" );
      ((Element)v.get(271)).setAttribute("valor","" );
      ((Element)v.get(271)).setAttribute("disabled","" );
      ((Element)v.get(271)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',9, true)" );
      ((Element)v.get(271)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',9, false)" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(272)).setAttribute("id","datosCampos" );
      ((Element)v.get(272)).setAttribute("valor","1" );
      ((Element)v.get(272)).setAttribute("cod","CobAccioCobra.indDescPrue.1.label" );
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
      ((Element)v.get(274)).setAttribute("cod","CobAccioCobra.indDescPrue.0.label" );
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

      /* Empieza nodo:276 / Elemento padre: 263   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(276)).setAttribute("nombre","indDescPrueGapTdId" );
      ((Element)v.get(276)).setAttribute("nowrap","true" );
      ((Element)v.get(276)).setAttribute("class","datosCampos" );
      ((Element)v.get(263)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(277)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).setAttribute("width","25" );
      ((Element)v.get(277)).setAttribute("height","8" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 263   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(278)).setAttribute("width","100%" );
      ((Element)v.get(263)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:258   */

      /* Empieza nodo:280 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(280)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(67)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(281)).setAttribute("align","center" );
      ((Element)v.get(281)).setAttribute("width","8" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).setAttribute("width","12" );
      ((Element)v.get(282)).setAttribute("height","8" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 280   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(280)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","8" );
      ((Element)v.get(284)).setAttribute("height","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 280   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(285)).setAttribute("align","center" );
      ((Element)v.get(285)).setAttribute("width","8" );
      ((Element)v.get(280)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(286)).setAttribute("src","b.gif" );
      ((Element)v.get(286)).setAttribute("width","12" );
      ((Element)v.get(286)).setAttribute("height","8" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:280   */

      /* Empieza nodo:287 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(287)).setAttribute("nombre","formTr7" );
      ((Element)v.get(67)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(288)).setAttribute("align","center" );
      ((Element)v.get(288)).setAttribute("width","8" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","8" );
      ((Element)v.get(289)).setAttribute("height","12" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 287   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(290)).setAttribute("width","100%" );
      ((Element)v.get(287)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(291)).setAttribute("width","100%" );
      ((Element)v.get(291)).setAttribute("border","0" );
      ((Element)v.get(291)).setAttribute("cellspacing","0" );
      ((Element)v.get(291)).setAttribute("cellpadding","0" );
      ((Element)v.get(291)).setAttribute("align","left" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(292)).setAttribute("align","left" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(293)).setAttribute("nombre","indNumeDocuSopoTdId" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));

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
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(296)).setAttribute("valign","top" );
      ((Element)v.get(296)).setAttribute("height","13" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(297)).setAttribute("nombre","lblIndNumeDocuSopo" );
      ((Element)v.get(297)).setAttribute("alto","13" );
      ((Element)v.get(297)).setAttribute("filas","1" );
      ((Element)v.get(297)).setAttribute("id","datosTitle" );
      ((Element)v.get(297)).setAttribute("cod","CobAccioCobra.indNumeDocuSopo.label" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:298 / Elemento padre: 294   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(298)).setAttribute("nombre","indNumeDocuSopoWidgetTrId" );
      ((Element)v.get(294)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(299)).setAttribute("align","left" );
      ((Element)v.get(299)).setAttribute("nowrap","true" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(300)).setAttribute("nombre","indNumeDocuSopo" );
      ((Element)v.get(300)).setAttribute("tipo","H" );
      ((Element)v.get(300)).setAttribute("req","N" );
      ((Element)v.get(300)).setAttribute("id","datosCampos" );
      ((Element)v.get(300)).setAttribute("valor","" );
      ((Element)v.get(300)).setAttribute("disabled","" );
      ((Element)v.get(300)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',10, true)" );
      ((Element)v.get(300)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',10, false)" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(301)).setAttribute("id","datosCampos" );
      ((Element)v.get(301)).setAttribute("valor","1" );
      ((Element)v.get(301)).setAttribute("cod","CobAccioCobra.indNumeDocuSopo.1.label" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Elemento padre:301 / Elemento actual: 302   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(301)).appendChild((Text)v.get(302));

      /* Termina nodo Texto:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 300   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(303)).setAttribute("id","datosCampos" );
      ((Element)v.get(303)).setAttribute("valor","0" );
      ((Element)v.get(303)).setAttribute("cod","CobAccioCobra.indNumeDocuSopo.0.label" );
      ((Element)v.get(300)).appendChild((Element)v.get(303));

      /* Elemento padre:303 / Elemento actual: 304   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(303)).appendChild((Text)v.get(304));

      /* Termina nodo Texto:304   */
      /* Termina nodo:303   */
      /* Termina nodo:300   */
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:305 / Elemento padre: 292   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(305)).setAttribute("nombre","indNumeDocuSopoGapTdId" );
      ((Element)v.get(305)).setAttribute("nowrap","true" );
      ((Element)v.get(305)).setAttribute("class","datosCampos" );
      ((Element)v.get(292)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","25" );
      ((Element)v.get(306)).setAttribute("height","8" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 292   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(307)).setAttribute("width","100%" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(292)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(308)).setAttribute("src","b.gif" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:292   */
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:287   */

      /* Empieza nodo:309 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(309)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(67)).appendChild((Element)v.get(309));

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

      /* Empieza nodo:316 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(316)).setAttribute("nombre","formTr8" );
      ((Element)v.get(67)).appendChild((Element)v.get(316));

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
      ((Element)v.get(322)).setAttribute("nombre","indTipoDocuPagoTdId" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

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
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(325)).setAttribute("valign","top" );
      ((Element)v.get(325)).setAttribute("height","13" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(326)).setAttribute("nombre","lblIndTipoDocuPago" );
      ((Element)v.get(326)).setAttribute("alto","13" );
      ((Element)v.get(326)).setAttribute("filas","1" );
      ((Element)v.get(326)).setAttribute("id","datosTitle" );
      ((Element)v.get(326)).setAttribute("cod","CobAccioCobra.indTipoDocuPago.label" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:327 / Elemento padre: 323   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(327)).setAttribute("nombre","indTipoDocuPagoWidgetTrId" );
      ((Element)v.get(323)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(328)).setAttribute("align","left" );
      ((Element)v.get(328)).setAttribute("nowrap","true" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(329)).setAttribute("nombre","indTipoDocuPago" );
      ((Element)v.get(329)).setAttribute("tipo","H" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(329)).setAttribute("req","N" );
      ((Element)v.get(329)).setAttribute("id","datosCampos" );
      ((Element)v.get(329)).setAttribute("valor","" );
      ((Element)v.get(329)).setAttribute("disabled","" );
      ((Element)v.get(329)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',11, true)" );
      ((Element)v.get(329)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',11, false)" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(330)).setAttribute("id","datosCampos" );
      ((Element)v.get(330)).setAttribute("valor","1" );
      ((Element)v.get(330)).setAttribute("cod","CobAccioCobra.indTipoDocuPago.1.label" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Elemento padre:330 / Elemento actual: 331   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(330)).appendChild((Text)v.get(331));

      /* Termina nodo Texto:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 329   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(332)).setAttribute("id","datosCampos" );
      ((Element)v.get(332)).setAttribute("valor","0" );
      ((Element)v.get(332)).setAttribute("cod","CobAccioCobra.indTipoDocuPago.0.label" );
      ((Element)v.get(329)).appendChild((Element)v.get(332));

      /* Elemento padre:332 / Elemento actual: 333   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(332)).appendChild((Text)v.get(333));

      /* Termina nodo Texto:333   */
      /* Termina nodo:332   */
      /* Termina nodo:329   */
      /* Termina nodo:328   */
      /* Termina nodo:327   */
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:334 / Elemento padre: 321   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(334)).setAttribute("nombre","indTipoDocuPagoGapTdId" );
      ((Element)v.get(334)).setAttribute("nowrap","true" );
      ((Element)v.get(334)).setAttribute("class","datosCampos" );
      ((Element)v.get(321)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(335)).setAttribute("src","b.gif" );
      ((Element)v.get(335)).setAttribute("width","25" );
      ((Element)v.get(335)).setAttribute("height","8" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:336 / Elemento padre: 321   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(336)).setAttribute("width","100%" );
      ((Element)v.get(321)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(337)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:316   */

      /* Empieza nodo:338 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(338)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(67)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(339)).setAttribute("align","center" );
      ((Element)v.get(339)).setAttribute("width","8" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","12" );
      ((Element)v.get(340)).setAttribute("height","8" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 338   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(338)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","8" );
      ((Element)v.get(342)).setAttribute("height","8" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 338   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(343)).setAttribute("align","center" );
      ((Element)v.get(343)).setAttribute("width","8" );
      ((Element)v.get(338)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("width","12" );
      ((Element)v.get(344)).setAttribute("height","8" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */
      /* Termina nodo:338   */

      /* Empieza nodo:345 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(345)).setAttribute("nombre","formTr9" );
      ((Element)v.get(67)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(346)).setAttribute("align","center" );
      ((Element)v.get(346)).setAttribute("width","8" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(347)).setAttribute("src","b.gif" );
      ((Element)v.get(347)).setAttribute("width","8" );
      ((Element)v.get(347)).setAttribute("height","12" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:348 / Elemento padre: 345   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(348)).setAttribute("width","100%" );
      ((Element)v.get(345)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(349)).setAttribute("width","100%" );
      ((Element)v.get(349)).setAttribute("border","0" );
      ((Element)v.get(349)).setAttribute("cellspacing","0" );
      ((Element)v.get(349)).setAttribute("cellpadding","0" );
      ((Element)v.get(349)).setAttribute("align","left" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(350)).setAttribute("align","left" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(351)).setAttribute("nombre","indBancSucuTdId" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));

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
      ((Element)v.get(355)).setAttribute("nombre","lblIndBancSucu" );
      ((Element)v.get(355)).setAttribute("alto","13" );
      ((Element)v.get(355)).setAttribute("filas","1" );
      ((Element)v.get(355)).setAttribute("id","datosTitle" );
      ((Element)v.get(355)).setAttribute("cod","CobAccioCobra.indBancSucu.label" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:356 / Elemento padre: 352   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(356)).setAttribute("nombre","indBancSucuWidgetTrId" );
      ((Element)v.get(352)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(357)).setAttribute("align","left" );
      ((Element)v.get(357)).setAttribute("nowrap","true" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(358)).setAttribute("nombre","indBancSucu" );
      ((Element)v.get(358)).setAttribute("tipo","H" );
      ((Element)v.get(358)).setAttribute("req","N" );
      ((Element)v.get(358)).setAttribute("id","datosCampos" );
      ((Element)v.get(358)).setAttribute("valor","" );
      ((Element)v.get(358)).setAttribute("disabled","" );
      ((Element)v.get(358)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',12, true)" );
      ((Element)v.get(358)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',12, false)" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(359)).setAttribute("id","datosCampos" );
      ((Element)v.get(359)).setAttribute("valor","1" );
      ((Element)v.get(359)).setAttribute("cod","CobAccioCobra.indBancSucu.1.label" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Elemento padre:359 / Elemento actual: 360   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(359)).appendChild((Text)v.get(360));

      /* Termina nodo Texto:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:361 / Elemento padre: 358   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(361)).setAttribute("id","datosCampos" );
      ((Element)v.get(361)).setAttribute("valor","0" );
      ((Element)v.get(361)).setAttribute("cod","CobAccioCobra.indBancSucu.0.label" );
      ((Element)v.get(358)).appendChild((Element)v.get(361));

      /* Elemento padre:361 / Elemento actual: 362   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(361)).appendChild((Text)v.get(362));

      /* Termina nodo Texto:362   */
      /* Termina nodo:361   */
      /* Termina nodo:358   */
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:363 / Elemento padre: 350   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(363)).setAttribute("nombre","indBancSucuGapTdId" );
      ((Element)v.get(363)).setAttribute("nowrap","true" );
      ((Element)v.get(363)).setAttribute("class","datosCampos" );
      ((Element)v.get(350)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(364)).setAttribute("src","b.gif" );
      ((Element)v.get(364)).setAttribute("width","25" );
      ((Element)v.get(364)).setAttribute("height","8" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */

      /* Empieza nodo:365 / Elemento padre: 350   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(365)).setAttribute("width","100%" );
      ((Element)v.get(350)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(366)).setAttribute("src","b.gif" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */
      /* Termina nodo:350   */
      /* Termina nodo:349   */
      /* Termina nodo:348   */
      /* Termina nodo:345   */

      /* Empieza nodo:367 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(367)).setAttribute("nombre","formGapTr9" );
      ((Element)v.get(67)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(368)).setAttribute("align","center" );
      ((Element)v.get(368)).setAttribute("width","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).setAttribute("width","12" );
      ((Element)v.get(369)).setAttribute("height","8" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 367   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(367)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).setAttribute("width","8" );
      ((Element)v.get(371)).setAttribute("height","8" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:372 / Elemento padre: 367   */
      v.add(doc.createElement("TD"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(372)).setAttribute("align","center" );
      ((Element)v.get(372)).setAttribute("width","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(373)).setAttribute("src","b.gif" );
      ((Element)v.get(373)).setAttribute("width","12" );
      ((Element)v.get(373)).setAttribute("height","8" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */
      /* Termina nodo:367   */

      /* Empieza nodo:374 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(374)).setAttribute("nombre","formTr10" );
      ((Element)v.get(67)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(375)).setAttribute("align","center" );
      ((Element)v.get(375)).setAttribute("width","8" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(376)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).setAttribute("width","8" );
      ((Element)v.get(376)).setAttribute("height","12" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 374   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(377)).setAttribute("width","100%" );
      ((Element)v.get(374)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(378)).setAttribute("width","100%" );
      ((Element)v.get(378)).setAttribute("border","0" );
      ((Element)v.get(378)).setAttribute("cellspacing","0" );
      ((Element)v.get(378)).setAttribute("cellpadding","0" );
      ((Element)v.get(378)).setAttribute("align","left" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(379)).setAttribute("align","left" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(380)).setAttribute("nombre","indNuevDireTdId" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(381)).setAttribute("width","100%" );
      ((Element)v.get(381)).setAttribute("border","0" );
      ((Element)v.get(381)).setAttribute("cellspacing","0" );
      ((Element)v.get(381)).setAttribute("cellpadding","0" );
      ((Element)v.get(381)).setAttribute("align","left" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(383)).setAttribute("valign","top" );
      ((Element)v.get(383)).setAttribute("height","13" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(384)).setAttribute("nombre","lblIndNuevDire" );
      ((Element)v.get(384)).setAttribute("alto","13" );
      ((Element)v.get(384)).setAttribute("filas","1" );
      ((Element)v.get(384)).setAttribute("id","datosTitle" );
      ((Element)v.get(384)).setAttribute("cod","CobAccioCobra.indNuevDire.label" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:385 / Elemento padre: 381   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(385)).setAttribute("nombre","indNuevDireWidgetTrId" );
      ((Element)v.get(381)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(386)).setAttribute("align","left" );
      ((Element)v.get(386)).setAttribute("nowrap","true" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(387)).setAttribute("nombre","indNuevDire" );
      ((Element)v.get(387)).setAttribute("tipo","H" );
      ((Element)v.get(387)).setAttribute("req","N" );
      ((Element)v.get(387)).setAttribute("id","datosCampos" );
      ((Element)v.get(387)).setAttribute("valor","" );
      ((Element)v.get(387)).setAttribute("disabled","" );
      ((Element)v.get(387)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',13, true)" );
      ((Element)v.get(387)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',13, false)" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(388)).setAttribute("id","datosCampos" );
      ((Element)v.get(388)).setAttribute("valor","1" );
      ((Element)v.get(388)).setAttribute("cod","CobAccioCobra.indNuevDire.1.label" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Elemento padre:388 / Elemento actual: 389   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(388)).appendChild((Text)v.get(389));

      /* Termina nodo Texto:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:390 / Elemento padre: 387   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(390)).setAttribute("id","datosCampos" );
      ((Element)v.get(390)).setAttribute("valor","0" );
      ((Element)v.get(390)).setAttribute("cod","CobAccioCobra.indNuevDire.0.label" );
      ((Element)v.get(387)).appendChild((Element)v.get(390));

      /* Elemento padre:390 / Elemento actual: 391   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(390)).appendChild((Text)v.get(391));

      /* Termina nodo Texto:391   */
      /* Termina nodo:390   */
      /* Termina nodo:387   */
      /* Termina nodo:386   */
      /* Termina nodo:385   */
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:392 / Elemento padre: 379   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(392)).setAttribute("nombre","indNuevDireGapTdId" );
      ((Element)v.get(392)).setAttribute("nowrap","true" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(392)).setAttribute("class","datosCampos" );
      ((Element)v.get(379)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(393)).setAttribute("src","b.gif" );
      ((Element)v.get(393)).setAttribute("width","25" );
      ((Element)v.get(393)).setAttribute("height","8" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:394 / Elemento padre: 379   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(394)).setAttribute("width","100%" );
      ((Element)v.get(379)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(395)).setAttribute("src","b.gif" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */
      /* Termina nodo:379   */
      /* Termina nodo:378   */
      /* Termina nodo:377   */
      /* Termina nodo:374   */

      /* Empieza nodo:396 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(396)).setAttribute("nombre","formGapTr10" );
      ((Element)v.get(67)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(397)).setAttribute("align","center" );
      ((Element)v.get(397)).setAttribute("width","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(398)).setAttribute("src","b.gif" );
      ((Element)v.get(398)).setAttribute("width","12" );
      ((Element)v.get(398)).setAttribute("height","8" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:399 / Elemento padre: 396   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(396)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(400)).setAttribute("src","b.gif" );
      ((Element)v.get(400)).setAttribute("width","8" );
      ((Element)v.get(400)).setAttribute("height","8" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:401 / Elemento padre: 396   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(401)).setAttribute("align","center" );
      ((Element)v.get(401)).setAttribute("width","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(402)).setAttribute("src","b.gif" );
      ((Element)v.get(402)).setAttribute("width","12" );
      ((Element)v.get(402)).setAttribute("height","8" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */
      /* Termina nodo:396   */

      /* Empieza nodo:403 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(403)).setAttribute("nombre","formTr11" );
      ((Element)v.get(67)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(404)).setAttribute("align","center" );
      ((Element)v.get(404)).setAttribute("width","8" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(405)).setAttribute("src","b.gif" );
      ((Element)v.get(405)).setAttribute("width","8" );
      ((Element)v.get(405)).setAttribute("height","12" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:406 / Elemento padre: 403   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(406)).setAttribute("width","100%" );
      ((Element)v.get(403)).appendChild((Element)v.get(406));

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
      ((Element)v.get(408)).setAttribute("align","left" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(409)).setAttribute("nombre","indNuevTelfTdId" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(410)).setAttribute("width","100%" );
      ((Element)v.get(410)).setAttribute("border","0" );
      ((Element)v.get(410)).setAttribute("cellspacing","0" );
      ((Element)v.get(410)).setAttribute("cellpadding","0" );
      ((Element)v.get(410)).setAttribute("align","left" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(410)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(412)).setAttribute("valign","top" );
      ((Element)v.get(412)).setAttribute("height","13" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(413)).setAttribute("nombre","lblIndNuevTelf" );
      ((Element)v.get(413)).setAttribute("alto","13" );
      ((Element)v.get(413)).setAttribute("filas","1" );
      ((Element)v.get(413)).setAttribute("id","datosTitle" );
      ((Element)v.get(413)).setAttribute("cod","CobAccioCobra.indNuevTelf.label" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */
      /* Termina nodo:411   */

      /* Empieza nodo:414 / Elemento padre: 410   */
      v.add(doc.createElement("TR"));
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(414)).setAttribute("nombre","indNuevTelfWidgetTrId" );
      ((Element)v.get(410)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(415)).setAttribute("align","left" );
      ((Element)v.get(415)).setAttribute("nowrap","true" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(416)).setAttribute("nombre","indNuevTelf" );
      ((Element)v.get(416)).setAttribute("tipo","H" );
      ((Element)v.get(416)).setAttribute("req","N" );
      ((Element)v.get(416)).setAttribute("id","datosCampos" );
      ((Element)v.get(416)).setAttribute("valor","" );
      ((Element)v.get(416)).setAttribute("disabled","" );
      ((Element)v.get(416)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',14, true)" );
      ((Element)v.get(416)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',14, false)" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(417)).setAttribute("id","datosCampos" );
      ((Element)v.get(417)).setAttribute("valor","1" );
      ((Element)v.get(417)).setAttribute("cod","CobAccioCobra.indNuevTelf.1.label" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));

      /* Elemento padre:417 / Elemento actual: 418   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(417)).appendChild((Text)v.get(418));

      /* Termina nodo Texto:418   */
      /* Termina nodo:417   */

      /* Empieza nodo:419 / Elemento padre: 416   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(419)).setAttribute("id","datosCampos" );
      ((Element)v.get(419)).setAttribute("valor","0" );
      ((Element)v.get(419)).setAttribute("cod","CobAccioCobra.indNuevTelf.0.label" );
      ((Element)v.get(416)).appendChild((Element)v.get(419));

      /* Elemento padre:419 / Elemento actual: 420   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(419)).appendChild((Text)v.get(420));

      /* Termina nodo Texto:420   */
      /* Termina nodo:419   */
      /* Termina nodo:416   */
      /* Termina nodo:415   */
      /* Termina nodo:414   */
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:421 / Elemento padre: 408   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(421)).setAttribute("nombre","indNuevTelfGapTdId" );
      ((Element)v.get(421)).setAttribute("nowrap","true" );
      ((Element)v.get(421)).setAttribute("class","datosCampos" );
      ((Element)v.get(408)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(422)).setAttribute("src","b.gif" );
      ((Element)v.get(422)).setAttribute("width","25" );
      ((Element)v.get(422)).setAttribute("height","8" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:421   */

      /* Empieza nodo:423 / Elemento padre: 408   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(423)).setAttribute("width","100%" );
      ((Element)v.get(408)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(424)).setAttribute("src","b.gif" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:423   */
      /* Termina nodo:408   */
      /* Termina nodo:407   */
      /* Termina nodo:406   */
      /* Termina nodo:403   */

      /* Empieza nodo:425 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(425)).setAttribute("nombre","formGapTr11" );
      ((Element)v.get(67)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(426)).setAttribute("align","center" );
      ((Element)v.get(426)).setAttribute("width","8" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(427)).setAttribute("src","b.gif" );
      ((Element)v.get(427)).setAttribute("width","12" );
      ((Element)v.get(427)).setAttribute("height","8" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:428 / Elemento padre: 425   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(425)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(429)).setAttribute("src","b.gif" );
      ((Element)v.get(429)).setAttribute("width","8" );
      ((Element)v.get(429)).setAttribute("height","8" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:428   */

      /* Empieza nodo:430 / Elemento padre: 425   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(430)).setAttribute("align","center" );
      ((Element)v.get(430)).setAttribute("width","8" );
      ((Element)v.get(425)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(431)).setAttribute("src","b.gif" );
      ((Element)v.get(431)).setAttribute("width","12" );
      ((Element)v.get(431)).setAttribute("height","8" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:430   */
      /* Termina nodo:425   */

      /* Empieza nodo:432 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(432)).setAttribute("nombre","formTr12" );
      ((Element)v.get(67)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(433)).setAttribute("align","center" );
      ((Element)v.get(433)).setAttribute("width","8" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(434)).setAttribute("src","b.gif" );
      ((Element)v.get(434)).setAttribute("width","8" );
      ((Element)v.get(434)).setAttribute("height","12" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:435 / Elemento padre: 432   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(435)).setAttribute("width","100%" );
      ((Element)v.get(432)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("TABLE"));
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(436)).setAttribute("width","100%" );
      ((Element)v.get(436)).setAttribute("border","0" );
      ((Element)v.get(436)).setAttribute("cellspacing","0" );
      ((Element)v.get(436)).setAttribute("cellpadding","0" );
      ((Element)v.get(436)).setAttribute("align","left" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(437)).setAttribute("align","left" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(438)).setAttribute("nombre","indPasaAdmiTdId" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(439)).setAttribute("width","100%" );
      ((Element)v.get(439)).setAttribute("border","0" );
      ((Element)v.get(439)).setAttribute("cellspacing","0" );
      ((Element)v.get(439)).setAttribute("cellpadding","0" );
      ((Element)v.get(439)).setAttribute("align","left" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(439)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(441)).setAttribute("valign","top" );
      ((Element)v.get(441)).setAttribute("height","13" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(442)).setAttribute("nombre","lblIndPasaAdmi" );
      ((Element)v.get(442)).setAttribute("alto","13" );
      ((Element)v.get(442)).setAttribute("filas","1" );
      ((Element)v.get(442)).setAttribute("id","datosTitle" );
      ((Element)v.get(442)).setAttribute("cod","CobAccioCobra.indPasaAdmi.label" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:441   */
      /* Termina nodo:440   */

      /* Empieza nodo:443 / Elemento padre: 439   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(443)).setAttribute("nombre","indPasaAdmiWidgetTrId" );
      ((Element)v.get(439)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(444)).setAttribute("align","left" );
      ((Element)v.get(444)).setAttribute("nowrap","true" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(445)).setAttribute("nombre","indPasaAdmi" );
      ((Element)v.get(445)).setAttribute("tipo","H" );
      ((Element)v.get(445)).setAttribute("req","N" );
      ((Element)v.get(445)).setAttribute("id","datosCampos" );
      ((Element)v.get(445)).setAttribute("valor","" );
      ((Element)v.get(445)).setAttribute("disabled","" );
      ((Element)v.get(445)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',15, true)" );
      ((Element)v.get(445)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',15, false)" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(446)).setAttribute("id","datosCampos" );
      ((Element)v.get(446)).setAttribute("valor","1" );
      ((Element)v.get(446)).setAttribute("cod","CobAccioCobra.indPasaAdmi.1.label" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));

      /* Elemento padre:446 / Elemento actual: 447   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(446)).appendChild((Text)v.get(447));

      /* Termina nodo Texto:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:448 / Elemento padre: 445   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(448)).setAttribute("id","datosCampos" );
      ((Element)v.get(448)).setAttribute("valor","0" );
      ((Element)v.get(448)).setAttribute("cod","CobAccioCobra.indPasaAdmi.0.label" );
      ((Element)v.get(445)).appendChild((Element)v.get(448));

      /* Elemento padre:448 / Elemento actual: 449   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(448)).appendChild((Text)v.get(449));

      /* Termina nodo Texto:449   */
      /* Termina nodo:448   */
      /* Termina nodo:445   */
      /* Termina nodo:444   */
      /* Termina nodo:443   */
      /* Termina nodo:439   */
      /* Termina nodo:438   */

      /* Empieza nodo:450 / Elemento padre: 437   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(450)).setAttribute("nombre","indPasaAdmiGapTdId" );
      ((Element)v.get(450)).setAttribute("nowrap","true" );
      ((Element)v.get(450)).setAttribute("class","datosCampos" );
      ((Element)v.get(437)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(451)).setAttribute("src","b.gif" );
      ((Element)v.get(451)).setAttribute("width","25" );
      ((Element)v.get(451)).setAttribute("height","8" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */

      /* Empieza nodo:452 / Elemento padre: 437   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(452)).setAttribute("width","100%" );
      ((Element)v.get(437)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(453)).setAttribute("src","b.gif" );
      ((Element)v.get(452)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */
      /* Termina nodo:452   */
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:435   */
      /* Termina nodo:432   */

      /* Empieza nodo:454 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(454)).setAttribute("nombre","formGapTr12" );
      ((Element)v.get(67)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(455)).setAttribute("align","center" );
      ((Element)v.get(455)).setAttribute("width","8" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(456)).setAttribute("src","b.gif" );
      ((Element)v.get(456)).setAttribute("width","12" );
      ((Element)v.get(456)).setAttribute("height","8" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:455   */

      /* Empieza nodo:457 / Elemento padre: 454   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(454)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(458)).setAttribute("src","b.gif" );
      ((Element)v.get(458)).setAttribute("width","8" );
      ((Element)v.get(458)).setAttribute("height","8" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:457   */

      /* Empieza nodo:459 / Elemento padre: 454   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(459)).setAttribute("align","center" );
      ((Element)v.get(459)).setAttribute("width","8" );
      ((Element)v.get(454)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(460)).setAttribute("src","b.gif" );
      ((Element)v.get(460)).setAttribute("width","12" );
      ((Element)v.get(460)).setAttribute("height","8" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */
      /* Termina nodo:459   */
      /* Termina nodo:454   */

      /* Empieza nodo:461 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(461)).setAttribute("nombre","formTr13" );
      ((Element)v.get(67)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(462)).setAttribute("align","center" );
      ((Element)v.get(462)).setAttribute("width","8" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(463)).setAttribute("src","b.gif" );
      ((Element)v.get(463)).setAttribute("width","8" );
      ((Element)v.get(463)).setAttribute("height","12" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:464 / Elemento padre: 461   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(464)).setAttribute("width","100%" );
      ((Element)v.get(461)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(465)).setAttribute("width","100%" );
      ((Element)v.get(465)).setAttribute("border","0" );
      ((Element)v.get(465)).setAttribute("cellspacing","0" );
      ((Element)v.get(465)).setAttribute("cellpadding","0" );
      ((Element)v.get(465)).setAttribute("align","left" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(466)).setAttribute("align","left" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(467)).setAttribute("nombre","indPetiBloqAdmiTdId" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(468)).setAttribute("width","100%" );
      ((Element)v.get(468)).setAttribute("border","0" );
      ((Element)v.get(468)).setAttribute("cellspacing","0" );
      ((Element)v.get(468)).setAttribute("cellpadding","0" );
      ((Element)v.get(468)).setAttribute("align","left" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(468)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(470)).setAttribute("valign","top" );
      ((Element)v.get(470)).setAttribute("height","13" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(471)).setAttribute("nombre","lblIndPetiBloqAdmi" );
      ((Element)v.get(471)).setAttribute("alto","13" );
      ((Element)v.get(471)).setAttribute("filas","1" );
      ((Element)v.get(471)).setAttribute("id","datosTitle" );
      ((Element)v.get(471)).setAttribute("cod","CobAccioCobra.indPetiBloqAdmi.label" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */
      /* Termina nodo:470   */
      /* Termina nodo:469   */

      /* Empieza nodo:472 / Elemento padre: 468   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(472)).setAttribute("nombre","indPetiBloqAdmiWidgetTrId" );
      ((Element)v.get(468)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(473)).setAttribute("align","left" );
      ((Element)v.get(473)).setAttribute("nowrap","true" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(474)).setAttribute("nombre","indPetiBloqAdmi" );
      ((Element)v.get(474)).setAttribute("tipo","H" );
      ((Element)v.get(474)).setAttribute("req","N" );
      ((Element)v.get(474)).setAttribute("id","datosCampos" );
      ((Element)v.get(474)).setAttribute("valor","" );
      ((Element)v.get(474)).setAttribute("disabled","" );
      ((Element)v.get(474)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',16, true)" );
      ((Element)v.get(474)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',16, false)" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(475)).setAttribute("id","datosCampos" );
      ((Element)v.get(475)).setAttribute("valor","1" );
      ((Element)v.get(475)).setAttribute("cod","CobAccioCobra.indPetiBloqAdmi.1.label" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));

      /* Elemento padre:475 / Elemento actual: 476   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(475)).appendChild((Text)v.get(476));

      /* Termina nodo Texto:476   */
      /* Termina nodo:475   */

      /* Empieza nodo:477 / Elemento padre: 474   */
      v.add(doc.createElement("RBINPUT"));
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(477)).setAttribute("id","datosCampos" );
      ((Element)v.get(477)).setAttribute("valor","0" );
      ((Element)v.get(477)).setAttribute("cod","CobAccioCobra.indPetiBloqAdmi.0.label" );
      ((Element)v.get(474)).appendChild((Element)v.get(477));

      /* Elemento padre:477 / Elemento actual: 478   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(477)).appendChild((Text)v.get(478));

      /* Termina nodo Texto:478   */
      /* Termina nodo:477   */
      /* Termina nodo:474   */
      /* Termina nodo:473   */
      /* Termina nodo:472   */
      /* Termina nodo:468   */
      /* Termina nodo:467   */

      /* Empieza nodo:479 / Elemento padre: 466   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(479)).setAttribute("nombre","indPetiBloqAdmiGapTdId" );
      ((Element)v.get(479)).setAttribute("nowrap","true" );
      ((Element)v.get(479)).setAttribute("class","datosCampos" );
      ((Element)v.get(466)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(480)).setAttribute("src","b.gif" );
      ((Element)v.get(480)).setAttribute("width","25" );
      ((Element)v.get(480)).setAttribute("height","8" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:479   */

      /* Empieza nodo:481 / Elemento padre: 466   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(481)).setAttribute("width","100%" );
      ((Element)v.get(466)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(482)).setAttribute("src","b.gif" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */
      /* Termina nodo:481   */
      /* Termina nodo:466   */
      /* Termina nodo:465   */
      /* Termina nodo:464   */
      /* Termina nodo:461   */

      /* Empieza nodo:483 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(483)).setAttribute("nombre","formGapTr13" );
      ((Element)v.get(67)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(484)).setAttribute("align","center" );
      ((Element)v.get(484)).setAttribute("width","8" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(485)).setAttribute("src","b.gif" );
      ((Element)v.get(485)).setAttribute("width","12" );
      ((Element)v.get(485)).setAttribute("height","8" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */
      /* Termina nodo:484   */

      /* Empieza nodo:486 / Elemento padre: 483   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(483)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(487)).setAttribute("src","b.gif" );
      ((Element)v.get(487)).setAttribute("width","8" );
      ((Element)v.get(487)).setAttribute("height","8" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */
      /* Termina nodo:486   */

      /* Empieza nodo:488 / Elemento padre: 483   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(488)).setAttribute("align","center" );
      ((Element)v.get(488)).setAttribute("width","8" );
      ((Element)v.get(483)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(489)).setAttribute("src","b.gif" );
      ((Element)v.get(489)).setAttribute("width","12" );
      ((Element)v.get(489)).setAttribute("height","8" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:488   */
      /* Termina nodo:483   */

      /* Empieza nodo:490 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(490)).setAttribute("nombre","formTr14" );
      ((Element)v.get(67)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(491)).setAttribute("align","center" );
      ((Element)v.get(491)).setAttribute("width","8" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(492)).setAttribute("src","b.gif" );
      ((Element)v.get(492)).setAttribute("width","8" );
      ((Element)v.get(492)).setAttribute("height","12" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */
      /* Termina nodo:491   */

      /* Empieza nodo:493 / Elemento padre: 490   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(493)).setAttribute("width","100%" );
      ((Element)v.get(490)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(494)).setAttribute("width","100%" );
      ((Element)v.get(494)).setAttribute("border","0" );
      ((Element)v.get(494)).setAttribute("cellspacing","0" );
      ((Element)v.get(494)).setAttribute("cellpadding","0" );
      ((Element)v.get(494)).setAttribute("align","left" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(495)).setAttribute("align","left" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(496)).setAttribute("nombre","indPetiDesbAdmiTdId" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(497)).setAttribute("width","100%" );
      ((Element)v.get(497)).setAttribute("border","0" );
      ((Element)v.get(497)).setAttribute("cellspacing","0" );
      ((Element)v.get(497)).setAttribute("cellpadding","0" );
      ((Element)v.get(497)).setAttribute("align","left" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(497)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(499)).setAttribute("valign","top" );
      ((Element)v.get(499)).setAttribute("height","13" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(498)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(500)).setAttribute("nombre","lblIndPetiDesbAdmi" );
      ((Element)v.get(500)).setAttribute("alto","13" );
      ((Element)v.get(500)).setAttribute("filas","1" );
      ((Element)v.get(500)).setAttribute("id","datosTitle" );
      ((Element)v.get(500)).setAttribute("cod","CobAccioCobra.indPetiDesbAdmi.label" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */
      /* Termina nodo:499   */
      /* Termina nodo:498   */

      /* Empieza nodo:501 / Elemento padre: 497   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(501)).setAttribute("nombre","indPetiDesbAdmiWidgetTrId" );
      ((Element)v.get(497)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(502)).setAttribute("align","left" );
      ((Element)v.get(502)).setAttribute("nowrap","true" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(503)).setAttribute("nombre","indPetiDesbAdmi" );
      ((Element)v.get(503)).setAttribute("tipo","H" );
      ((Element)v.get(503)).setAttribute("req","N" );
      ((Element)v.get(503)).setAttribute("id","datosCampos" );
      ((Element)v.get(503)).setAttribute("valor","" );
      ((Element)v.get(503)).setAttribute("disabled","" );
      ((Element)v.get(503)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',17, true)" );
      ((Element)v.get(503)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',17, false)" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(504)).setAttribute("id","datosCampos" );
      ((Element)v.get(504)).setAttribute("valor","1" );
      ((Element)v.get(504)).setAttribute("cod","CobAccioCobra.indPetiDesbAdmi.1.label" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));

      /* Elemento padre:504 / Elemento actual: 505   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(504)).appendChild((Text)v.get(505));

      /* Termina nodo Texto:505   */
      /* Termina nodo:504   */

      /* Empieza nodo:506 / Elemento padre: 503   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(506)).setAttribute("id","datosCampos" );
      ((Element)v.get(506)).setAttribute("valor","0" );
      ((Element)v.get(506)).setAttribute("cod","CobAccioCobra.indPetiDesbAdmi.0.label" );
      ((Element)v.get(503)).appendChild((Element)v.get(506));

      /* Elemento padre:506 / Elemento actual: 507   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(506)).appendChild((Text)v.get(507));

      /* Termina nodo Texto:507   */
      /* Termina nodo:506   */
      /* Termina nodo:503   */
      /* Termina nodo:502   */
      /* Termina nodo:501   */
      /* Termina nodo:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:508 / Elemento padre: 495   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(508)).setAttribute("nombre","indPetiDesbAdmiGapTdId" );
      ((Element)v.get(508)).setAttribute("nowrap","true" );
      ((Element)v.get(508)).setAttribute("class","datosCampos" );
      ((Element)v.get(495)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(509)).setAttribute("src","b.gif" );
      ((Element)v.get(509)).setAttribute("width","25" );
      ((Element)v.get(509)).setAttribute("height","8" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:510 / Elemento padre: 495   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(510)).setAttribute("width","100%" );
      ((Element)v.get(495)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(511)).setAttribute("src","b.gif" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */
      /* Termina nodo:510   */
      /* Termina nodo:495   */
      /* Termina nodo:494   */
      /* Termina nodo:493   */
      /* Termina nodo:490   */

      /* Empieza nodo:512 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(512)).setAttribute("nombre","formGapTr14" );
      ((Element)v.get(67)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(513)).setAttribute("align","center" );
      ((Element)v.get(513)).setAttribute("width","8" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(514)).setAttribute("src","b.gif" );
      ((Element)v.get(514)).setAttribute("width","12" );
      ((Element)v.get(514)).setAttribute("height","8" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */
      /* Termina nodo:513   */

      /* Empieza nodo:515 / Elemento padre: 512   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(512)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(516)).setAttribute("src","b.gif" );
      ((Element)v.get(516)).setAttribute("width","8" );
      ((Element)v.get(516)).setAttribute("height","8" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */
      /* Termina nodo:515   */

      /* Empieza nodo:517 / Elemento padre: 512   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(517)).setAttribute("align","center" );
      ((Element)v.get(517)).setAttribute("width","8" );
      ((Element)v.get(512)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(518)).setAttribute("src","b.gif" );
      ((Element)v.get(518)).setAttribute("width","12" );
      ((Element)v.get(518)).setAttribute("height","8" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */
      /* Termina nodo:517   */
      /* Termina nodo:512   */

      /* Empieza nodo:519 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(519)).setAttribute("nombre","formTr15" );
      ((Element)v.get(67)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(520)).setAttribute("align","center" );
      ((Element)v.get(520)).setAttribute("width","8" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
   }

   private void getXML2250(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(521)).setAttribute("src","b.gif" );
      ((Element)v.get(521)).setAttribute("width","8" );
      ((Element)v.get(521)).setAttribute("height","12" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 519   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(522)).setAttribute("width","100%" );
      ((Element)v.get(519)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(523)).setAttribute("width","100%" );
      ((Element)v.get(523)).setAttribute("border","0" );
      ((Element)v.get(523)).setAttribute("cellspacing","0" );
      ((Element)v.get(523)).setAttribute("cellpadding","0" );
      ((Element)v.get(523)).setAttribute("align","left" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(524)).setAttribute("align","left" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(525)).setAttribute("nombre","indAcciMensRecoTdId" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(526)).setAttribute("width","100%" );
      ((Element)v.get(526)).setAttribute("border","0" );
      ((Element)v.get(526)).setAttribute("cellspacing","0" );
      ((Element)v.get(526)).setAttribute("cellpadding","0" );
      ((Element)v.get(526)).setAttribute("align","left" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(526)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(528)).setAttribute("valign","top" );
      ((Element)v.get(528)).setAttribute("height","13" );
      ((Element)v.get(527)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(529)).setAttribute("nombre","lblIndAcciMensReco" );
      ((Element)v.get(529)).setAttribute("alto","13" );
      ((Element)v.get(529)).setAttribute("filas","1" );
      ((Element)v.get(529)).setAttribute("id","datosTitle" );
      ((Element)v.get(529)).setAttribute("cod","CobAccioCobra.indAcciMensReco.label" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */
      /* Termina nodo:527   */

      /* Empieza nodo:530 / Elemento padre: 526   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(530)).setAttribute("nombre","indAcciMensRecoWidgetTrId" );
      ((Element)v.get(526)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(531)).setAttribute("align","left" );
      ((Element)v.get(531)).setAttribute("nowrap","true" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(532)).setAttribute("nombre","indAcciMensReco" );
      ((Element)v.get(532)).setAttribute("tipo","H" );
      ((Element)v.get(532)).setAttribute("req","N" );
      ((Element)v.get(532)).setAttribute("id","datosCampos" );
      ((Element)v.get(532)).setAttribute("valor","" );
      ((Element)v.get(532)).setAttribute("disabled","" );
      ((Element)v.get(532)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',18, true)" );
      ((Element)v.get(532)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',18, false)" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(533)).setAttribute("id","datosCampos" );
      ((Element)v.get(533)).setAttribute("valor","1" );
      ((Element)v.get(533)).setAttribute("cod","CobAccioCobra.indAcciMensReco.1.label" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));

      /* Elemento padre:533 / Elemento actual: 534   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(533)).appendChild((Text)v.get(534));

      /* Termina nodo Texto:534   */
      /* Termina nodo:533   */

      /* Empieza nodo:535 / Elemento padre: 532   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(535)).setAttribute("id","datosCampos" );
      ((Element)v.get(535)).setAttribute("valor","0" );
      ((Element)v.get(535)).setAttribute("cod","CobAccioCobra.indAcciMensReco.0.label" );
      ((Element)v.get(532)).appendChild((Element)v.get(535));

      /* Elemento padre:535 / Elemento actual: 536   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(535)).appendChild((Text)v.get(536));

      /* Termina nodo Texto:536   */
      /* Termina nodo:535   */
      /* Termina nodo:532   */
      /* Termina nodo:531   */
      /* Termina nodo:530   */
      /* Termina nodo:526   */
      /* Termina nodo:525   */

      /* Empieza nodo:537 / Elemento padre: 524   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(537)).setAttribute("nombre","indAcciMensRecoGapTdId" );
      ((Element)v.get(537)).setAttribute("nowrap","true" );
      ((Element)v.get(537)).setAttribute("class","datosCampos" );
      ((Element)v.get(524)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(538)).setAttribute("src","b.gif" );
      ((Element)v.get(538)).setAttribute("width","25" );
      ((Element)v.get(538)).setAttribute("height","8" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:537   */

      /* Empieza nodo:539 / Elemento padre: 524   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(539)).setAttribute("width","100%" );
      ((Element)v.get(524)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(540)).setAttribute("src","b.gif" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */
      /* Termina nodo:524   */
      /* Termina nodo:523   */
      /* Termina nodo:522   */
      /* Termina nodo:519   */

      /* Empieza nodo:541 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(541)).setAttribute("nombre","formGapTr15" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(67)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(542)).setAttribute("align","center" );
      ((Element)v.get(542)).setAttribute("width","8" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(543)).setAttribute("src","b.gif" );
      ((Element)v.get(543)).setAttribute("width","12" );
      ((Element)v.get(543)).setAttribute("height","8" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */
      /* Termina nodo:542   */

      /* Empieza nodo:544 / Elemento padre: 541   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(541)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(545)).setAttribute("src","b.gif" );
      ((Element)v.get(545)).setAttribute("width","8" );
      ((Element)v.get(545)).setAttribute("height","8" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:544   */

      /* Empieza nodo:546 / Elemento padre: 541   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(546)).setAttribute("align","center" );
      ((Element)v.get(546)).setAttribute("width","8" );
      ((Element)v.get(541)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(547)).setAttribute("src","b.gif" );
      ((Element)v.get(547)).setAttribute("width","12" );
      ((Element)v.get(547)).setAttribute("height","8" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:546   */
      /* Termina nodo:541   */

      /* Empieza nodo:548 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(548)).setAttribute("nombre","formTr16" );
      ((Element)v.get(67)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(549)).setAttribute("align","center" );
      ((Element)v.get(549)).setAttribute("width","8" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(550)).setAttribute("src","b.gif" );
      ((Element)v.get(550)).setAttribute("width","8" );
      ((Element)v.get(550)).setAttribute("height","12" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));
      /* Termina nodo:550   */
      /* Termina nodo:549   */

      /* Empieza nodo:551 / Elemento padre: 548   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(551)).setAttribute("width","100%" );
      ((Element)v.get(548)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(552)).setAttribute("width","100%" );
      ((Element)v.get(552)).setAttribute("border","0" );
      ((Element)v.get(552)).setAttribute("cellspacing","0" );
      ((Element)v.get(552)).setAttribute("cellpadding","0" );
      ((Element)v.get(552)).setAttribute("align","left" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(553)).setAttribute("align","left" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(554)).setAttribute("nombre","indObseTdId" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(555)).setAttribute("width","100%" );
      ((Element)v.get(555)).setAttribute("border","0" );
      ((Element)v.get(555)).setAttribute("cellspacing","0" );
      ((Element)v.get(555)).setAttribute("cellpadding","0" );
      ((Element)v.get(555)).setAttribute("align","left" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(555)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(557)).setAttribute("valign","top" );
      ((Element)v.get(557)).setAttribute("height","13" );
      ((Element)v.get(556)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(558)).setAttribute("nombre","lblIndObse" );
      ((Element)v.get(558)).setAttribute("alto","13" );
      ((Element)v.get(558)).setAttribute("filas","1" );
      ((Element)v.get(558)).setAttribute("id","datosTitle" );
      ((Element)v.get(558)).setAttribute("cod","CobAccioCobra.indObse.label" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));
      /* Termina nodo:558   */
      /* Termina nodo:557   */
      /* Termina nodo:556   */

      /* Empieza nodo:559 / Elemento padre: 555   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(559)).setAttribute("nombre","indObseWidgetTrId" );
      ((Element)v.get(555)).appendChild((Element)v.get(559));

      /* Empieza nodo:560 / Elemento padre: 559   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(560)).setAttribute("align","left" );
      ((Element)v.get(560)).setAttribute("nowrap","true" );
      ((Element)v.get(559)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(561)).setAttribute("nombre","indObse" );
      ((Element)v.get(561)).setAttribute("tipo","H" );
      ((Element)v.get(561)).setAttribute("req","N" );
      ((Element)v.get(561)).setAttribute("id","datosCampos" );
      ((Element)v.get(561)).setAttribute("valor","" );
      ((Element)v.get(561)).setAttribute("disabled","" );
      ((Element)v.get(561)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',19, true)" );
      ((Element)v.get(561)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',19, false)" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(560)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(562)).setAttribute("id","datosCampos" );
      ((Element)v.get(562)).setAttribute("valor","1" );
      ((Element)v.get(562)).setAttribute("cod","CobAccioCobra.indObse.1.label" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));

      /* Elemento padre:562 / Elemento actual: 563   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(562)).appendChild((Text)v.get(563));

      /* Termina nodo Texto:563   */
      /* Termina nodo:562   */

      /* Empieza nodo:564 / Elemento padre: 561   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(564)).setAttribute("id","datosCampos" );
      ((Element)v.get(564)).setAttribute("valor","0" );
      ((Element)v.get(564)).setAttribute("cod","CobAccioCobra.indObse.0.label" );
      ((Element)v.get(561)).appendChild((Element)v.get(564));

      /* Elemento padre:564 / Elemento actual: 565   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(564)).appendChild((Text)v.get(565));

      /* Termina nodo Texto:565   */
      /* Termina nodo:564   */
      /* Termina nodo:561   */
      /* Termina nodo:560   */
      /* Termina nodo:559   */
      /* Termina nodo:555   */
      /* Termina nodo:554   */

      /* Empieza nodo:566 / Elemento padre: 553   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(566)).setAttribute("nombre","indObseGapTdId" );
      ((Element)v.get(566)).setAttribute("nowrap","true" );
      ((Element)v.get(566)).setAttribute("class","datosCampos" );
      ((Element)v.get(553)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(567)).setAttribute("src","b.gif" );
      ((Element)v.get(567)).setAttribute("width","25" );
      ((Element)v.get(567)).setAttribute("height","8" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:566   */

      /* Empieza nodo:568 / Elemento padre: 553   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(568)).setAttribute("width","100%" );
      ((Element)v.get(553)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(569)).setAttribute("src","b.gif" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */
      /* Termina nodo:568   */
      /* Termina nodo:553   */
      /* Termina nodo:552   */
      /* Termina nodo:551   */
      /* Termina nodo:548   */

      /* Empieza nodo:570 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(570)).setAttribute("nombre","formGapTr16" );
      ((Element)v.get(67)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(571)).setAttribute("align","center" );
      ((Element)v.get(571)).setAttribute("width","8" );
      ((Element)v.get(570)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(572)).setAttribute("src","b.gif" );
      ((Element)v.get(572)).setAttribute("width","12" );
      ((Element)v.get(572)).setAttribute("height","8" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));
      /* Termina nodo:572   */
      /* Termina nodo:571   */

      /* Empieza nodo:573 / Elemento padre: 570   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(570)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(574)).setAttribute("src","b.gif" );
      ((Element)v.get(574)).setAttribute("width","8" );
      ((Element)v.get(574)).setAttribute("height","8" );
      ((Element)v.get(573)).appendChild((Element)v.get(574));
      /* Termina nodo:574   */
      /* Termina nodo:573   */

      /* Empieza nodo:575 / Elemento padre: 570   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(575)).setAttribute("align","center" );
      ((Element)v.get(575)).setAttribute("width","8" );
      ((Element)v.get(570)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(576)).setAttribute("src","b.gif" );
      ((Element)v.get(576)).setAttribute("width","12" );
      ((Element)v.get(576)).setAttribute("height","8" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */
      /* Termina nodo:575   */
      /* Termina nodo:570   */

      /* Empieza nodo:577 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(577)).setAttribute("nombre","formTr17" );
      ((Element)v.get(67)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(578)).setAttribute("align","center" );
      ((Element)v.get(578)).setAttribute("width","8" );
      ((Element)v.get(577)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(579)).setAttribute("src","b.gif" );
      ((Element)v.get(579)).setAttribute("width","8" );
      ((Element)v.get(579)).setAttribute("height","12" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));
      /* Termina nodo:579   */
      /* Termina nodo:578   */

      /* Empieza nodo:580 / Elemento padre: 577   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(580)).setAttribute("width","100%" );
      ((Element)v.get(577)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(581)).setAttribute("width","100%" );
      ((Element)v.get(581)).setAttribute("border","0" );
      ((Element)v.get(581)).setAttribute("cellspacing","0" );
      ((Element)v.get(581)).setAttribute("cellpadding","0" );
      ((Element)v.get(581)).setAttribute("align","left" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(582)).setAttribute("align","left" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(583)).setAttribute("nombre","valObseTdId" );
      ((Element)v.get(582)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(584)).setAttribute("width","100%" );
      ((Element)v.get(584)).setAttribute("border","0" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(584)).setAttribute("cellspacing","0" );
      ((Element)v.get(584)).setAttribute("cellpadding","0" );
      ((Element)v.get(584)).setAttribute("align","left" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(584)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(586)).setAttribute("valign","top" );
      ((Element)v.get(586)).setAttribute("height","13" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(587)).setAttribute("nombre","lblValObse" );
      ((Element)v.get(587)).setAttribute("alto","13" );
      ((Element)v.get(587)).setAttribute("filas","1" );
      ((Element)v.get(587)).setAttribute("id","datosTitle" );
      ((Element)v.get(587)).setAttribute("cod","CobAccioCobra.valObse.label" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */
      /* Termina nodo:586   */
      /* Termina nodo:585   */

      /* Empieza nodo:588 / Elemento padre: 584   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(588)).setAttribute("nombre","valObseWidgetTrId" );
      ((Element)v.get(584)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(589)).setAttribute("align","left" );
      ((Element)v.get(589)).setAttribute("nowrap","true" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(590)).setAttribute("nombre","valObse" );
      ((Element)v.get(590)).setAttribute("id","datosCampos" );
      ((Element)v.get(590)).setAttribute("trim","S" );
      ((Element)v.get(590)).setAttribute("max","100" );
      ((Element)v.get(590)).setAttribute("onchange","" );
      ((Element)v.get(590)).setAttribute("req","N" );
      ((Element)v.get(590)).setAttribute("size","100" );
      ((Element)v.get(590)).setAttribute("valor","" );
      ((Element)v.get(590)).setAttribute("validacion","" );
      ((Element)v.get(590)).setAttribute("disabled","" );
      ((Element)v.get(590)).setAttribute("onblur","" );
      ((Element)v.get(590)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',20, true)" );
      ((Element)v.get(590)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm', 20, false)" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));
      /* Termina nodo:590   */
      /* Termina nodo:589   */
      /* Termina nodo:588   */
      /* Termina nodo:584   */
      /* Termina nodo:583   */

      /* Empieza nodo:591 / Elemento padre: 582   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(591)).setAttribute("nombre","valObseGapTdId" );
      ((Element)v.get(591)).setAttribute("nowrap","true" );
      ((Element)v.get(591)).setAttribute("class","datosCampos" );
      ((Element)v.get(582)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(592)).setAttribute("src","b.gif" );
      ((Element)v.get(592)).setAttribute("width","25" );
      ((Element)v.get(592)).setAttribute("height","8" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */
      /* Termina nodo:591   */

      /* Empieza nodo:593 / Elemento padre: 582   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(593)).setAttribute("width","100%" );
      ((Element)v.get(582)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(594)).setAttribute("src","b.gif" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));
      /* Termina nodo:594   */
      /* Termina nodo:593   */
      /* Termina nodo:582   */
      /* Termina nodo:581   */
      /* Termina nodo:580   */
      /* Termina nodo:577   */

      /* Empieza nodo:595 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(595)).setAttribute("nombre","formGapTr17" );
      ((Element)v.get(67)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(596)).setAttribute("align","center" );
      ((Element)v.get(596)).setAttribute("width","8" );
      ((Element)v.get(595)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(597)).setAttribute("src","b.gif" );
      ((Element)v.get(597)).setAttribute("width","12" );
      ((Element)v.get(597)).setAttribute("height","8" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));
      /* Termina nodo:597   */
      /* Termina nodo:596   */

      /* Empieza nodo:598 / Elemento padre: 595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(595)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(599)).setAttribute("src","b.gif" );
      ((Element)v.get(599)).setAttribute("width","8" );
      ((Element)v.get(599)).setAttribute("height","8" );
      ((Element)v.get(598)).appendChild((Element)v.get(599));
      /* Termina nodo:599   */
      /* Termina nodo:598   */

      /* Empieza nodo:600 / Elemento padre: 595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(600)).setAttribute("align","center" );
      ((Element)v.get(600)).setAttribute("width","8" );
      ((Element)v.get(595)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(601)).setAttribute("src","b.gif" );
      ((Element)v.get(601)).setAttribute("width","12" );
      ((Element)v.get(601)).setAttribute("height","8" );
      ((Element)v.get(600)).appendChild((Element)v.get(601));
      /* Termina nodo:601   */
      /* Termina nodo:600   */
      /* Termina nodo:595   */

      /* Empieza nodo:602 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(602)).setAttribute("nombre","formTr18" );
      ((Element)v.get(67)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(603)).setAttribute("align","center" );
      ((Element)v.get(603)).setAttribute("width","8" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));

      /* Empieza nodo:604 / Elemento padre: 603   */
   }

   private void getXML2610(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(604)).setAttribute("src","b.gif" );
      ((Element)v.get(604)).setAttribute("width","8" );
      ((Element)v.get(604)).setAttribute("height","12" );
      ((Element)v.get(603)).appendChild((Element)v.get(604));
      /* Termina nodo:604   */
      /* Termina nodo:603   */

      /* Empieza nodo:605 / Elemento padre: 602   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(605)).setAttribute("width","100%" );
      ((Element)v.get(602)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(606)).setAttribute("width","100%" );
      ((Element)v.get(606)).setAttribute("border","0" );
      ((Element)v.get(606)).setAttribute("cellspacing","0" );
      ((Element)v.get(606)).setAttribute("cellpadding","0" );
      ((Element)v.get(606)).setAttribute("align","left" );
      ((Element)v.get(605)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(607)).setAttribute("align","left" );
      ((Element)v.get(606)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(608)).setAttribute("nombre","paisOidPaisTdId" );
      ((Element)v.get(607)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(609)).setAttribute("border","0" );
      ((Element)v.get(609)).setAttribute("cellspacing","0" );
      ((Element)v.get(609)).setAttribute("cellpadding","0" );
      ((Element)v.get(609)).setAttribute("align","left" );
      ((Element)v.get(608)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(609)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(611)).setAttribute("valign","top" );
      ((Element)v.get(611)).setAttribute("height","13" );
      ((Element)v.get(610)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(612)).setAttribute("nombre","lblpaisOidPais" );
      ((Element)v.get(612)).setAttribute("id","datosTitle" );
      ((Element)v.get(612)).setAttribute("ancho","150" );
      ((Element)v.get(612)).setAttribute("alto","13" );
      ((Element)v.get(612)).setAttribute("cod","CobAccioCobra.paisOidPais.label" );
      ((Element)v.get(611)).appendChild((Element)v.get(612));
      /* Termina nodo:612   */
      /* Termina nodo:611   */
      /* Termina nodo:610   */

      /* Empieza nodo:613 / Elemento padre: 609   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(613)).setAttribute("nombre","paisOidPaisWidgetTrId" );
      ((Element)v.get(609)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(614)).setAttribute("align","left" );
      ((Element)v.get(614)).setAttribute("nowrap","true" );
      ((Element)v.get(613)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(615)).setAttribute("nombre","paisOidPais" );
      ((Element)v.get(615)).setAttribute("id","datosCampos" );
      ((Element)v.get(615)).setAttribute("multiple","N" );
      ((Element)v.get(615)).setAttribute("req","N" );
      ((Element)v.get(615)).setAttribute("size","1" );
      ((Element)v.get(615)).setAttribute("disabled","" );
      ((Element)v.get(615)).setAttribute("validacion","" );
      ((Element)v.get(615)).setAttribute("onchange","" );
      ((Element)v.get(615)).setAttribute("onfocus","" );
      ((Element)v.get(615)).setAttribute("valorinicial","" );
      ((Element)v.get(615)).setAttribute("textoinicial","" );
      ((Element)v.get(615)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',21, true);" );
      ((Element)v.get(615)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',21, false);" );
      ((Element)v.get(614)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(615)).appendChild((Element)v.get(616));
      /* Termina nodo:616   */
      /* Termina nodo:615   */
      /* Termina nodo:614   */
      /* Termina nodo:613   */
      /* Termina nodo:609   */
      /* Termina nodo:608   */

      /* Empieza nodo:617 / Elemento padre: 607   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(617)).setAttribute("nombre","paisOidPaisGapTdId" );
      ((Element)v.get(617)).setAttribute("nowrap","true" );
      ((Element)v.get(617)).setAttribute("class","datosCampos" );
      ((Element)v.get(607)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(618)).setAttribute("src","b.gif" );
      ((Element)v.get(618)).setAttribute("width","25" );
      ((Element)v.get(618)).setAttribute("height","8" );
      ((Element)v.get(617)).appendChild((Element)v.get(618));
      /* Termina nodo:618   */
      /* Termina nodo:617   */

      /* Empieza nodo:619 / Elemento padre: 607   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(619)).setAttribute("width","100%" );
      ((Element)v.get(607)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(620)).setAttribute("src","b.gif" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));
      /* Termina nodo:620   */
      /* Termina nodo:619   */
      /* Termina nodo:607   */
      /* Termina nodo:606   */
      /* Termina nodo:605   */

      /* Empieza nodo:621 / Elemento padre: 602   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(621)).setAttribute("width","100%" );
      ((Element)v.get(602)).appendChild((Element)v.get(621));
      /* Termina nodo:621   */
      /* Termina nodo:602   */

      /* Empieza nodo:622 / Elemento padre: 67   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(622)).setAttribute("nombre","formGapTr18" );
      ((Element)v.get(67)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(623)).setAttribute("align","center" );
      ((Element)v.get(623)).setAttribute("width","8" );
      ((Element)v.get(622)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
   }

   private void getXML2700(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(624)).setAttribute("src","b.gif" );
      ((Element)v.get(624)).setAttribute("width","8" );
      ((Element)v.get(624)).setAttribute("height","8" );
      ((Element)v.get(623)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */
      /* Termina nodo:623   */

      /* Empieza nodo:625 / Elemento padre: 622   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(622)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(626)).setAttribute("src","b.gif" );
      ((Element)v.get(626)).setAttribute("width","8" );
      ((Element)v.get(626)).setAttribute("height","8" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));
      /* Termina nodo:626   */
      /* Termina nodo:625   */

      /* Empieza nodo:627 / Elemento padre: 622   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(627)).setAttribute("align","center" );
      ((Element)v.get(627)).setAttribute("width","8" );
      ((Element)v.get(622)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(628)).setAttribute("src","b.gif" );
      ((Element)v.get(628)).setAttribute("width","8" );
      ((Element)v.get(628)).setAttribute("height","8" );
      ((Element)v.get(627)).appendChild((Element)v.get(628));
      /* Termina nodo:628   */
      /* Termina nodo:627   */
      /* Termina nodo:622   */
      /* Termina nodo:67   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:629 / Elemento padre: 60   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(629)).setAttribute("align","center" );
      ((Element)v.get(629)).setAttribute("width","12" );
      ((Element)v.get(60)).appendChild((Element)v.get(629));

      /* Empieza nodo:630 / Elemento padre: 629   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(630)).setAttribute("src","b.gif" );
      ((Element)v.get(630)).setAttribute("width","12" );
      ((Element)v.get(630)).setAttribute("height","12" );
      ((Element)v.get(629)).appendChild((Element)v.get(630));
      /* Termina nodo:630   */
      /* Termina nodo:629   */
      /* Termina nodo:60   */

      /* Empieza nodo:631 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(631)).setAttribute("nombre","cobAccioCobraTrButtons" );
      ((Element)v.get(52)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(632)).setAttribute("align","center" );
      ((Element)v.get(632)).setAttribute("width","12" );
      ((Element)v.get(631)).appendChild((Element)v.get(632));

      /* Empieza nodo:633 / Elemento padre: 632   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(633)).setAttribute("src","b.gif" );
      ((Element)v.get(633)).setAttribute("width","12" );
      ((Element)v.get(633)).setAttribute("height","12" );
      ((Element)v.get(632)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */
      /* Termina nodo:632   */

      /* Empieza nodo:634 / Elemento padre: 631   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(631)).appendChild((Element)v.get(634));

      /* Empieza nodo:635 / Elemento padre: 634   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(634)).appendChild((Element)v.get(635));

      /* Empieza nodo:636 / Elemento padre: 635   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(636)).setAttribute("width","100%" );
      ((Element)v.get(636)).setAttribute("border","0" );
      ((Element)v.get(636)).setAttribute("align","center" );
      ((Element)v.get(636)).setAttribute("cellspacing","0" );
      ((Element)v.get(636)).setAttribute("cellpadding","0" );
      ((Element)v.get(635)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(636)).appendChild((Element)v.get(637));

      /* Empieza nodo:638 / Elemento padre: 637   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(638)).setAttribute("class","tablaTitle" );
      ((Element)v.get(638)).setAttribute("nombre","cobAccioCobraTdQueryButton" );
      ((Element)v.get(637)).appendChild((Element)v.get(638));

      /* Empieza nodo:639 / Elemento padre: 638   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(639)).setAttribute("nombre","cobAccioCobraQueryButton" );
      ((Element)v.get(639)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(639)).setAttribute("estado","false" );
      ((Element)v.get(639)).setAttribute("accion","cobAccioCobraFirstPage();" );
      ((Element)v.get(639)).setAttribute("tipo","html" );
      ((Element)v.get(639)).setAttribute("ID","botonContenido" );
      ((Element)v.get(638)).appendChild((Element)v.get(639));
      /* Termina nodo:639   */
      /* Termina nodo:638   */

      /* Empieza nodo:640 / Elemento padre: 637   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(640)).setAttribute("class","tablaTitle" );
      ((Element)v.get(640)).setAttribute("nombre","cobAccioCobraTdLovNullSelectionButton" );
      ((Element)v.get(640)).setAttribute("align","left" );
      ((Element)v.get(640)).setAttribute("width","100%" );
      ((Element)v.get(637)).appendChild((Element)v.get(640));

      /* Empieza nodo:641 / Elemento padre: 640   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(641)).setAttribute("src","b.gif" );
      ((Element)v.get(641)).setAttribute("height","8" );
      ((Element)v.get(641)).setAttribute("width","8" );
      ((Element)v.get(640)).appendChild((Element)v.get(641));
      /* Termina nodo:641   */

      /* Empieza nodo:642 / Elemento padre: 640   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(642)).setAttribute("nombre","cobAccioCobraLovNullButton" );
      ((Element)v.get(642)).setAttribute("ID","botonContenido" );
      ((Element)v.get(642)).setAttribute("tipo","html" );
      ((Element)v.get(642)).setAttribute("accion","cobAccioCobraLovNullSelectionAction();" );
      ((Element)v.get(642)).setAttribute("estado","true" );
      ((Element)v.get(642)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(640)).appendChild((Element)v.get(642));
      /* Termina nodo:642   */
      /* Termina nodo:640   */
      /* Termina nodo:637   */
      /* Termina nodo:636   */
      /* Termina nodo:635   */
      /* Termina nodo:634   */

      /* Empieza nodo:643 / Elemento padre: 631   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(643)).setAttribute("align","center" );
      ((Element)v.get(643)).setAttribute("width","12" );
      ((Element)v.get(631)).appendChild((Element)v.get(643));

      /* Empieza nodo:644 / Elemento padre: 643   */
   }

   private void getXML2790(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(644)).setAttribute("src","b.gif" );
      ((Element)v.get(644)).setAttribute("width","12" );
      ((Element)v.get(644)).setAttribute("height","12" );
      ((Element)v.get(643)).appendChild((Element)v.get(644));
      /* Termina nodo:644   */
      /* Termina nodo:643   */
      /* Termina nodo:631   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:645 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(645)).setAttribute("nombre","cobAccioCobraListLayer" );
      ((Element)v.get(645)).setAttribute("alto","310" );
      ((Element)v.get(645)).setAttribute("ancho","99%" );
      ((Element)v.get(645)).setAttribute("colorf","" );
      ((Element)v.get(645)).setAttribute("borde","0" );
      ((Element)v.get(645)).setAttribute("imagenf","" );
      ((Element)v.get(645)).setAttribute("repeat","" );
      ((Element)v.get(645)).setAttribute("padding","" );
      ((Element)v.get(645)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(645)).setAttribute("contravsb","" );
      ((Element)v.get(645)).setAttribute("x","3" );
      ((Element)v.get(645)).setAttribute("y","" );
      ((Element)v.get(645)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(645));

      /* Empieza nodo:646 / Elemento padre: 645   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(646)).setAttribute("nombre","cobAccioCobraList" );
      ((Element)v.get(646)).setAttribute("ancho","680" );
      ((Element)v.get(646)).setAttribute("alto","275" );
      ((Element)v.get(646)).setAttribute("x","12" );
      ((Element)v.get(646)).setAttribute("y","0" );
      ((Element)v.get(646)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(646)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(645)).appendChild((Element)v.get(646));

      /* Empieza nodo:647 / Elemento padre: 646   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(647)).setAttribute("precarga","S" );
      ((Element)v.get(647)).setAttribute("conROver","S" );
      ((Element)v.get(646)).appendChild((Element)v.get(647));

      /* Empieza nodo:648 / Elemento padre: 647   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(648)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(648)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(648)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(648)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(647)).appendChild((Element)v.get(648));
      /* Termina nodo:648   */

      /* Empieza nodo:649 / Elemento padre: 647   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(649)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(649)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(649)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(649)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(647)).appendChild((Element)v.get(649));
      /* Termina nodo:649   */
      /* Termina nodo:647   */

      /* Empieza nodo:650 / Elemento padre: 646   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(646)).appendChild((Element)v.get(650));

      /* Empieza nodo:651 / Elemento padre: 650   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(651)).setAttribute("borde","1" );
      ((Element)v.get(651)).setAttribute("horizDatos","1" );
      ((Element)v.get(651)).setAttribute("horizCabecera","1" );
      ((Element)v.get(651)).setAttribute("vertical","1" );
      ((Element)v.get(651)).setAttribute("horizTitulo","1" );
      ((Element)v.get(651)).setAttribute("horizBase","1" );
      ((Element)v.get(650)).appendChild((Element)v.get(651));
      /* Termina nodo:651   */

      /* Empieza nodo:652 / Elemento padre: 650   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(652)).setAttribute("borde","#999999" );
      ((Element)v.get(652)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(652)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(652)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(652)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(652)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(652)).setAttribute("horizBase","#999999" );
      ((Element)v.get(650)).appendChild((Element)v.get(652));
      /* Termina nodo:652   */
      /* Termina nodo:650   */

      /* Empieza nodo:653 / Elemento padre: 646   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(653)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(653)).setAttribute("alto","22" );
      ((Element)v.get(653)).setAttribute("imgFondo","" );
      ((Element)v.get(653)).setAttribute("cod","00135" );
      ((Element)v.get(653)).setAttribute("ID","datosTitle" );
      ((Element)v.get(646)).appendChild((Element)v.get(653));
      /* Termina nodo:653   */

      /* Empieza nodo:654 / Elemento padre: 646   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(654)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(654)).setAttribute("alto","22" );
      ((Element)v.get(654)).setAttribute("imgFondo","" );
      ((Element)v.get(646)).appendChild((Element)v.get(654));
      /* Termina nodo:654   */

      /* Empieza nodo:655 / Elemento padre: 646   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(655)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(655)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(655)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(655)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(655)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(646)).appendChild((Element)v.get(655));

      /* Empieza nodo:656 / Elemento padre: 655   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(656)).setAttribute("ancho","100" );
      ((Element)v.get(656)).setAttribute("minimizable","S" );
      ((Element)v.get(656)).setAttribute("minimizada","N" );
      ((Element)v.get(655)).appendChild((Element)v.get(656));
      /* Termina nodo:656   */

      /* Empieza nodo:657 / Elemento padre: 655   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(657)).setAttribute("ancho","100" );
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(657)).setAttribute("minimizable","S" );
      ((Element)v.get(657)).setAttribute("minimizada","N" );
      ((Element)v.get(655)).appendChild((Element)v.get(657));
      /* Termina nodo:657   */
      /* Termina nodo:655   */

      /* Empieza nodo:658 / Elemento padre: 646   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(658)).setAttribute("height","20" );
      ((Element)v.get(658)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(658)).setAttribute("imgFondo","" );
      ((Element)v.get(658)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(646)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(659)).setAttribute("colFondo","" );
      ((Element)v.get(659)).setAttribute("ID","EstCab" );
      ((Element)v.get(659)).setAttribute("cod","CobAccioCobra.codAcciCobr.label" );
      ((Element)v.get(658)).appendChild((Element)v.get(659));
      /* Termina nodo:659   */

      /* Empieza nodo:660 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(660)).setAttribute("colFondo","" );
      ((Element)v.get(660)).setAttribute("ID","EstCab" );
      ((Element)v.get(660)).setAttribute("cod","CobAccioCobra.valDesc.label" );
      ((Element)v.get(658)).appendChild((Element)v.get(660));
      /* Termina nodo:660   */
      /* Termina nodo:658   */

      /* Empieza nodo:661 / Elemento padre: 646   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(661)).setAttribute("alto","22" );
      ((Element)v.get(661)).setAttribute("accion","" );
      ((Element)v.get(661)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(661)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(661)).setAttribute("maxSel","1" );
      ((Element)v.get(661)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(661)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(661)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(661)).setAttribute("onLoad","" );
      ((Element)v.get(661)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(646)).appendChild((Element)v.get(661));

      /* Empieza nodo:662 / Elemento padre: 661   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(662)).setAttribute("tipo","texto" );
      ((Element)v.get(662)).setAttribute("ID","EstDat" );
      ((Element)v.get(661)).appendChild((Element)v.get(662));
      /* Termina nodo:662   */

      /* Empieza nodo:663 / Elemento padre: 661   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(663)).setAttribute("tipo","texto" );
      ((Element)v.get(663)).setAttribute("ID","EstDat2" );
      ((Element)v.get(661)).appendChild((Element)v.get(663));
      /* Termina nodo:663   */
      /* Termina nodo:661   */

      /* Empieza nodo:664 / Elemento padre: 646   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(646)).appendChild((Element)v.get(664));
      /* Termina nodo:664   */
      /* Termina nodo:646   */
      /* Termina nodo:645   */

      /* Empieza nodo:665 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(665)).setAttribute("nombre","cobAccioCobraListButtonsLayer" );
      ((Element)v.get(665)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(665)).setAttribute("alto","30" );
      ((Element)v.get(665)).setAttribute("ancho","98%" );
      ((Element)v.get(665)).setAttribute("borde","n" );
      ((Element)v.get(665)).setAttribute("imagenf","" );
      ((Element)v.get(665)).setAttribute("repeat","" );
      ((Element)v.get(665)).setAttribute("padding","0" );
      ((Element)v.get(665)).setAttribute("contravsb","" );
      ((Element)v.get(665)).setAttribute("x","16" );
      ((Element)v.get(665)).setAttribute("y","" );
      ((Element)v.get(665)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(665));

      /* Empieza nodo:666 / Elemento padre: 665   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(666)).setAttribute("nombre","toolbarSeparatorLayer" );
      ((Element)v.get(666)).setAttribute("visibilidad","inherit" );
      ((Element)v.get(666)).setAttribute("alto","23" );
      ((Element)v.get(666)).setAttribute("ancho","1" );
      ((Element)v.get(666)).setAttribute("borde","1" );
      ((Element)v.get(666)).setAttribute("imagenf","" );
      ((Element)v.get(666)).setAttribute("repeat","" );
      ((Element)v.get(666)).setAttribute("padding","0" );
      ((Element)v.get(666)).setAttribute("contravsb","" );
      ((Element)v.get(666)).setAttribute("x","56" );
      ((Element)v.get(666)).setAttribute("y","0" );
      ((Element)v.get(666)).setAttribute("zindex","" );
      ((Element)v.get(666)).setAttribute("colborde","#999999" );
      ((Element)v.get(665)).appendChild((Element)v.get(666));
      /* Termina nodo:666   */

      /* Empieza nodo:667 / Elemento padre: 665   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(667)).setAttribute("width","100%" );
      ((Element)v.get(667)).setAttribute("border","0" );
      ((Element)v.get(667)).setAttribute("cellspacing","1" );
      ((Element)v.get(667)).setAttribute("cellpadding","0" );
      ((Element)v.get(665)).appendChild((Element)v.get(667));

      /* Empieza nodo:668 / Elemento padre: 667   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(667)).appendChild((Element)v.get(668));

      /* Empieza nodo:669 / Elemento padre: 668   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(669)).setAttribute("src","b.gif" );
      ((Element)v.get(669)).setAttribute("height","22" );
      ((Element)v.get(669)).setAttribute("width","5" );
      ((Element)v.get(668)).appendChild((Element)v.get(669));
      /* Termina nodo:669   */
      /* Termina nodo:668   */

      /* Empieza nodo:670 / Elemento padre: 667   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(667)).appendChild((Element)v.get(670));

      /* Empieza nodo:671 / Elemento padre: 670   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(671)).setAttribute("nombre","cobAccioCobraPaginationButtonBar" );
      ((Element)v.get(671)).setAttribute("tipo","H" );
      ((Element)v.get(671)).setAttribute("x","0" );
      ((Element)v.get(671)).setAttribute("y","0" );
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(670)).appendChild((Element)v.get(671));

      /* Empieza nodo:672 / Elemento padre: 671   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(672)).setAttribute("nombre","cobAccioCobraFirstPageButton" );
      ((Element)v.get(672)).setAttribute("funcion","cobAccioCobraFirstPage();" );
      ((Element)v.get(672)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(672)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(672)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(672)).setAttribute("estado","inactivo" );
      ((Element)v.get(671)).appendChild((Element)v.get(672));
      /* Termina nodo:672   */

      /* Empieza nodo:673 / Elemento padre: 671   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(673)).setAttribute("nombre","cobAccioCobraFirstPageButtonGapTd" );
      ((Element)v.get(671)).appendChild((Element)v.get(673));

      /* Empieza nodo:674 / Elemento padre: 673   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(674)).setAttribute("src","b.gif" );
      ((Element)v.get(674)).setAttribute("height","8" );
      ((Element)v.get(674)).setAttribute("width","5" );
      ((Element)v.get(673)).appendChild((Element)v.get(674));
      /* Termina nodo:674   */
      /* Termina nodo:673   */

      /* Empieza nodo:675 / Elemento padre: 671   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(675)).setAttribute("nombre","cobAccioCobraPreviousPageButton" );
      ((Element)v.get(675)).setAttribute("funcion","cobAccioCobraPreviousPage();" );
      ((Element)v.get(675)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(675)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(675)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(675)).setAttribute("estado","inactivo" );
      ((Element)v.get(671)).appendChild((Element)v.get(675));
      /* Termina nodo:675   */

      /* Empieza nodo:676 / Elemento padre: 671   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(676)).setAttribute("nombre","cobAccioCobraPreviousPageButtonGapTd" );
      ((Element)v.get(671)).appendChild((Element)v.get(676));

      /* Empieza nodo:677 / Elemento padre: 676   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(677)).setAttribute("src","b.gif" );
      ((Element)v.get(677)).setAttribute("height","8" );
      ((Element)v.get(677)).setAttribute("width","8" );
      ((Element)v.get(676)).appendChild((Element)v.get(677));
      /* Termina nodo:677   */
      /* Termina nodo:676   */

      /* Empieza nodo:678 / Elemento padre: 671   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(678)).setAttribute("nombre","cobAccioCobraNextPageButton" );
      ((Element)v.get(678)).setAttribute("funcion","cobAccioCobraNextPage();" );
      ((Element)v.get(678)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(678)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(678)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(678)).setAttribute("estado","inactivo" );
      ((Element)v.get(671)).appendChild((Element)v.get(678));
      /* Termina nodo:678   */
      /* Termina nodo:671   */
      /* Termina nodo:670   */

      /* Empieza nodo:679 / Elemento padre: 667   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(667)).appendChild((Element)v.get(679));

      /* Empieza nodo:680 / Elemento padre: 679   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(680)).setAttribute("src","b.gif" );
      ((Element)v.get(680)).setAttribute("height","22" );
      ((Element)v.get(680)).setAttribute("width","19" );
      ((Element)v.get(679)).appendChild((Element)v.get(680));
      /* Termina nodo:680   */
      /* Termina nodo:679   */

      /* Empieza nodo:681 / Elemento padre: 667   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(681)).setAttribute("class","tablaTitle" );
      ((Element)v.get(681)).setAttribute("nombre","cobAccioCobraUpdateButtonTd" );
      ((Element)v.get(667)).appendChild((Element)v.get(681));

      /* Empieza nodo:682 / Elemento padre: 681   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(682)).setAttribute("nombre","cobAccioCobraUpdateButton" );
      ((Element)v.get(682)).setAttribute("ID","botonContenido" );
      ((Element)v.get(682)).setAttribute("tipo","html" );
      ((Element)v.get(682)).setAttribute("accion","cobAccioCobraUpdateSelection();" );
      ((Element)v.get(682)).setAttribute("estado","false" );
      ((Element)v.get(682)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(681)).appendChild((Element)v.get(682));
      /* Termina nodo:682   */
      /* Termina nodo:681   */

      /* Empieza nodo:683 / Elemento padre: 667   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(683)).setAttribute("nombre","cobAccioCobraUpdateButtonGapTd" );
      ((Element)v.get(667)).appendChild((Element)v.get(683));

      /* Empieza nodo:684 / Elemento padre: 683   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(684)).setAttribute("src","b.gif" );
      ((Element)v.get(684)).setAttribute("height","8" );
      ((Element)v.get(684)).setAttribute("width","10" );
      ((Element)v.get(683)).appendChild((Element)v.get(684));
      /* Termina nodo:684   */
      /* Termina nodo:683   */

      /* Empieza nodo:685 / Elemento padre: 667   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(685)).setAttribute("class","tablaTitle" );
      ((Element)v.get(685)).setAttribute("nombre","cobAccioCobraViewForRemoveButtonTd" );
      ((Element)v.get(667)).appendChild((Element)v.get(685));

      /* Empieza nodo:686 / Elemento padre: 685   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(686)).setAttribute("nombre","cobAccioCobraViewForRemoveButton" );
      ((Element)v.get(686)).setAttribute("ID","botonContenido" );
      ((Element)v.get(686)).setAttribute("tipo","html" );
      ((Element)v.get(686)).setAttribute("accion","cobAccioCobraViewSelection();" );
      ((Element)v.get(686)).setAttribute("estado","false" );
      ((Element)v.get(686)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(685)).appendChild((Element)v.get(686));
      /* Termina nodo:686   */
      /* Termina nodo:685   */

      /* Empieza nodo:687 / Elemento padre: 667   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(687)).setAttribute("nombre","cobAccioCobraViewForRemoveButtonGapTd" );
      ((Element)v.get(667)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(688)).setAttribute("src","b.gif" );
      ((Element)v.get(688)).setAttribute("height","8" );
      ((Element)v.get(688)).setAttribute("width","10" );
      ((Element)v.get(687)).appendChild((Element)v.get(688));
      /* Termina nodo:688   */
      /* Termina nodo:687   */

      /* Empieza nodo:689 / Elemento padre: 667   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(689)).setAttribute("class","tablaTitle" );
   }

   private void getXML3060(Document doc) {
      ((Element)v.get(689)).setAttribute("nombre","cobAccioCobraLovSelectButtonTd" );
      ((Element)v.get(667)).appendChild((Element)v.get(689));

      /* Empieza nodo:690 / Elemento padre: 689   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(690)).setAttribute("nombre","cobAccioCobraLovSelectButton" );
      ((Element)v.get(690)).setAttribute("ID","botonContenido" );
      ((Element)v.get(690)).setAttribute("tipo","html" );
      ((Element)v.get(690)).setAttribute("accion","cobAccioCobraLovSelectionAction();" );
      ((Element)v.get(690)).setAttribute("estado","true" );
      ((Element)v.get(690)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(689)).appendChild((Element)v.get(690));
      /* Termina nodo:690   */
      /* Termina nodo:689   */

      /* Empieza nodo:691 / Elemento padre: 667   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(691)).setAttribute("nombre","cobAccioCobraLovSelectButtonGapTd" );
      ((Element)v.get(667)).appendChild((Element)v.get(691));

      /* Empieza nodo:692 / Elemento padre: 691   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(692)).setAttribute("src","b.gif" );
      ((Element)v.get(692)).setAttribute("height","8" );
      ((Element)v.get(692)).setAttribute("width","10" );
      ((Element)v.get(691)).appendChild((Element)v.get(692));
      /* Termina nodo:692   */
      /* Termina nodo:691   */

      /* Empieza nodo:693 / Elemento padre: 667   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(693)).setAttribute("class","tablaTitle" );
      ((Element)v.get(693)).setAttribute("nombre","cobAccioCobraViewButtonTd" );
      ((Element)v.get(667)).appendChild((Element)v.get(693));

      /* Empieza nodo:694 / Elemento padre: 693   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(694)).setAttribute("nombre","cobAccioCobraViewButton" );
      ((Element)v.get(694)).setAttribute("ID","botonContenido" );
      ((Element)v.get(694)).setAttribute("tipo","html" );
      ((Element)v.get(694)).setAttribute("accion","cobAccioCobraViewSelection();" );
      ((Element)v.get(694)).setAttribute("estado","false" );
      ((Element)v.get(694)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(693)).appendChild((Element)v.get(694));
      /* Termina nodo:694   */
      /* Termina nodo:693   */

      /* Empieza nodo:695 / Elemento padre: 667   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(695)).setAttribute("nombre","cobAccioCobraViewButtonGapTd" );
      ((Element)v.get(667)).appendChild((Element)v.get(695));

      /* Empieza nodo:696 / Elemento padre: 695   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(696)).setAttribute("src","b.gif" );
      ((Element)v.get(696)).setAttribute("height","8" );
      ((Element)v.get(696)).setAttribute("width","10" );
      ((Element)v.get(695)).appendChild((Element)v.get(696));
      /* Termina nodo:696   */
      /* Termina nodo:695   */

      /* Empieza nodo:697 / Elemento padre: 667   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(697)).setAttribute("width","100%" );
      ((Element)v.get(667)).appendChild((Element)v.get(697));
      /* Termina nodo:697   */
      /* Termina nodo:667   */
      /* Termina nodo:665   */
      /* Termina nodo:4   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class CccParamContaPage  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","CccParamContaPage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","cccParamContaInitComponents()" );
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
      ((Element)v.get(3)).setAttribute("src","cccparamconta.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","cccParamContaFrm" );
      ((Element)v.get(4)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","CccParamContaLPExecution" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","ON" );
      ((Element)v.get(6)).setAttribute("valor","CccParamContaLPExecution" );
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
      ((Element)v.get(36)).setAttribute("nombre","valDebeHabeCheckValue" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","indConcFechCheckValue" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(38)).setAttribute("nombre","cccParamContaFormLayer" );
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
      ((Element)v.get(53)).setAttribute("cod","CccParamConta.legend.label" );
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
      ((Element)v.get(68)).setAttribute("cod","CccParamConta.id.label" );
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
      ((Element)v.get(71)).setAttribute("ontab","ejecutarAccionFoco('cccParamContaFrm',1, true)" );
      ((Element)v.get(71)).setAttribute("onshtab","ejecutarAccionFoco('cccParamContaFrm', 1, false)" );
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
      ((Element)v.get(89)).setAttribute("nombre","subpOidSubp_ccprOidProcTdId" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("TABLE"));
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
      ((Element)v.get(93)).setAttribute("nombre","lblsubpOidSubp_ccprOidProc" );
      ((Element)v.get(93)).setAttribute("id","datosTitle" );
      ((Element)v.get(93)).setAttribute("ancho","150" );
      ((Element)v.get(93)).setAttribute("alto","13" );
      ((Element)v.get(93)).setAttribute("cod","CccSubpr.ccprOidProc.label" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:94 / Elemento padre: 90   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(94)).setAttribute("nombre","subpOidSubp_ccprOidProcWidgetTrId" );
      ((Element)v.get(90)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(95)).setAttribute("align","left" );
      ((Element)v.get(95)).setAttribute("nowrap","true" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(96)).setAttribute("nombre","subpOidSubp_ccprOidProc" );
      ((Element)v.get(96)).setAttribute("id","datosCampos" );
      ((Element)v.get(96)).setAttribute("multiple","N" );
      ((Element)v.get(96)).setAttribute("req","N" );
      ((Element)v.get(96)).setAttribute("size","1" );
      ((Element)v.get(96)).setAttribute("disabled","" );
      ((Element)v.get(96)).setAttribute("validacion","" );
      ((Element)v.get(96)).setAttribute("onchange","mmgDependeneChange('subpOidSubp_ccprOidProc', 'subpOidSubp' , 'cccParamConta')" );
      ((Element)v.get(96)).setAttribute("onfocus","" );
      ((Element)v.get(96)).setAttribute("valorinicial","" );
      ((Element)v.get(96)).setAttribute("textoinicial","" );
      ((Element)v.get(96)).setAttribute("ontab","focaliza('cccParamContaFrm.subpOidSubp');" );
      ((Element)v.get(96)).setAttribute("onshtab","ejecutarAccionFoco('cccParamContaFrm',3, false);" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:98 / Elemento padre: 88   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(98)).setAttribute("nombre","subpOidSubp_ccprOidProcGapTdId" );
      ((Element)v.get(98)).setAttribute("nowrap","true" );
      ((Element)v.get(98)).setAttribute("class","datosCampos" );
      ((Element)v.get(88)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","25" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 88   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(100)).setAttribute("nombre","subpOidSubpTdId" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(88)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(101)).setAttribute("border","0" );
      ((Element)v.get(101)).setAttribute("cellspacing","0" );
      ((Element)v.get(101)).setAttribute("cellpadding","0" );
      ((Element)v.get(101)).setAttribute("align","left" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(103)).setAttribute("valign","top" );
      ((Element)v.get(103)).setAttribute("height","13" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(104)).setAttribute("nombre","lblsubpOidSubp" );
      ((Element)v.get(104)).setAttribute("id","datosTitle" );
      ((Element)v.get(104)).setAttribute("ancho","150" );
      ((Element)v.get(104)).setAttribute("alto","13" );
      ((Element)v.get(104)).setAttribute("cod","CccParamConta.subpOidSubp.label" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:105 / Elemento padre: 101   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(105)).setAttribute("nombre","subpOidSubpWidgetTrId" );
      ((Element)v.get(101)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(106)).setAttribute("align","left" );
      ((Element)v.get(106)).setAttribute("nowrap","true" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(107)).setAttribute("nombre","subpOidSubp" );
      ((Element)v.get(107)).setAttribute("id","datosCampos" );
      ((Element)v.get(107)).setAttribute("multiple","N" );
      ((Element)v.get(107)).setAttribute("req","N" );
      ((Element)v.get(107)).setAttribute("size","1" );
      ((Element)v.get(107)).setAttribute("disabled","" );
      ((Element)v.get(107)).setAttribute("validacion","" );
      ((Element)v.get(107)).setAttribute("onchange","" );
      ((Element)v.get(107)).setAttribute("onfocus","" );
      ((Element)v.get(107)).setAttribute("valorinicial","" );
      ((Element)v.get(107)).setAttribute("textoinicial","" );
      ((Element)v.get(107)).setAttribute("ontab","ejecutarAccionFoco('cccParamContaFrm',3, true);" );
      ((Element)v.get(107)).setAttribute("onshtab","focaliza('cccParamContaFrm.subpOidSubp_ccprOidProc');" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:109 / Elemento padre: 88   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(109)).setAttribute("nombre","subpOidSubpGapTdId" );
      ((Element)v.get(109)).setAttribute("nowrap","true" );
      ((Element)v.get(109)).setAttribute("class","datosCampos" );
      ((Element)v.get(88)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","25" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 88   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(111)).setAttribute("nombre","valDebeHabeTdId" );
      ((Element)v.get(88)).appendChild((Element)v.get(111));

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
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(114)).setAttribute("valign","top" );
      ((Element)v.get(114)).setAttribute("height","13" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(115)).setAttribute("nombre","lblValDebeHabe" );
      ((Element)v.get(115)).setAttribute("alto","13" );
      ((Element)v.get(115)).setAttribute("filas","1" );
      ((Element)v.get(115)).setAttribute("id","datosTitle" );
      ((Element)v.get(115)).setAttribute("cod","CccParamConta.valDebeHabe.label" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:116 / Elemento padre: 112   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(116)).setAttribute("nombre","valDebeHabeWidgetTrId" );
      ((Element)v.get(112)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(117)).setAttribute("align","left" );
      ((Element)v.get(117)).setAttribute("nowrap","true" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(118)).setAttribute("nombre","valDebeHabe" );
      ((Element)v.get(118)).setAttribute("tipo","H" );
      ((Element)v.get(118)).setAttribute("req","N" );
      ((Element)v.get(118)).setAttribute("id","datosCampos" );
      ((Element)v.get(118)).setAttribute("valor","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(118)).setAttribute("disabled","" );
      ((Element)v.get(118)).setAttribute("ontab","ejecutarAccionFoco('cccParamContaFrm',4, true)" );
      ((Element)v.get(118)).setAttribute("onshtab","ejecutarAccionFoco('cccParamContaFrm',4, false)" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(119)).setAttribute("valor","D" );
      ((Element)v.get(119)).setAttribute("cod","CccParamConta.valDebeHabe.D.label" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Elemento padre:119 / Elemento actual: 120   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(119)).appendChild((Text)v.get(120));

      /* Termina nodo Texto:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 118   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(121)).setAttribute("id","datosCampos" );
      ((Element)v.get(121)).setAttribute("valor","H" );
      ((Element)v.get(121)).setAttribute("cod","CccParamConta.valDebeHabe.H.label" );
      ((Element)v.get(118)).appendChild((Element)v.get(121));

      /* Elemento padre:121 / Elemento actual: 122   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(121)).appendChild((Text)v.get(122));

      /* Termina nodo Texto:122   */
      /* Termina nodo:121   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:123 / Elemento padre: 88   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(123)).setAttribute("nombre","valDebeHabeGapTdId" );
      ((Element)v.get(123)).setAttribute("nowrap","true" );
      ((Element)v.get(123)).setAttribute("class","datosCampos" );
      ((Element)v.get(88)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","25" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 88   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(125)).setAttribute("width","100%" );
      ((Element)v.get(88)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:83   */

      /* Empieza nodo:127 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(127)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(54)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(128)).setAttribute("align","center" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","12" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 127   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(127)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","8" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 127   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(132)).setAttribute("align","center" );
      ((Element)v.get(132)).setAttribute("width","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","12" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:127   */

      /* Empieza nodo:134 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(134)).setAttribute("nombre","formTr2" );
      ((Element)v.get(54)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(135)).setAttribute("align","center" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","8" );
      ((Element)v.get(136)).setAttribute("height","12" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 134   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(137)).setAttribute("width","100%" );
      ((Element)v.get(134)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(138)).setAttribute("width","100%" );
      ((Element)v.get(138)).setAttribute("border","0" );
      ((Element)v.get(138)).setAttribute("cellspacing","0" );
      ((Element)v.get(138)).setAttribute("cellpadding","0" );
      ((Element)v.get(138)).setAttribute("align","left" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(139)).setAttribute("align","left" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(140)).setAttribute("nombre","valObteCuenTdId" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(141)).setAttribute("border","0" );
      ((Element)v.get(141)).setAttribute("cellspacing","0" );
      ((Element)v.get(141)).setAttribute("cellpadding","0" );
      ((Element)v.get(141)).setAttribute("align","left" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(143)).setAttribute("valign","top" );
      ((Element)v.get(143)).setAttribute("height","13" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(144)).setAttribute("nombre","lblValObteCuen" );
      ((Element)v.get(144)).setAttribute("ancho","150" );
      ((Element)v.get(144)).setAttribute("alto","13" );
      ((Element)v.get(144)).setAttribute("filas","1" );
      ((Element)v.get(144)).setAttribute("id","datosTitle" );
      ((Element)v.get(144)).setAttribute("cod","CccParamConta.valObteCuen.label" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:145 / Elemento padre: 141   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(145)).setAttribute("nombre","valObteCuenWidgetTrId" );
      ((Element)v.get(141)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(146)).setAttribute("align","left" );
      ((Element)v.get(146)).setAttribute("nowrap","true" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(147)).setAttribute("nombre","valObteCuen" );
      ((Element)v.get(147)).setAttribute("id","datosCampos" );
      ((Element)v.get(147)).setAttribute("multiple","N" );
      ((Element)v.get(147)).setAttribute("req","N" );
      ((Element)v.get(147)).setAttribute("size","1" );
      ((Element)v.get(147)).setAttribute("validacion","" );
      ((Element)v.get(147)).setAttribute("onchange","" );
      ((Element)v.get(147)).setAttribute("onfocus","" );
      ((Element)v.get(147)).setAttribute("valorinicial","" );
      ((Element)v.get(147)).setAttribute("textoinicial","" );
      ((Element)v.get(147)).setAttribute("disabled","" );
      ((Element)v.get(147)).setAttribute("ontab","ejecutarAccionFoco('cccParamContaFrm',5, true)" );
      ((Element)v.get(147)).setAttribute("onshtab","ejecutarAccionFoco('cccParamContaFrm',5, false)" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(149)).setAttribute("ID","D" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(150)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(150)).setAttribute("TIPO","STRING" );
      ((Element)v.get(150)).setAttribute("VALOR","D" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 149   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(151)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(151)).setAttribute("TIPO","STRING" );
      ((Element)v.get(151)).setAttribute("VALOR","Cuenta Directa" );
      ((Element)v.get(149)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:149   */

      /* Empieza nodo:152 / Elemento padre: 148   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(152)).setAttribute("ID","B" );
      ((Element)v.get(148)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(153)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(153)).setAttribute("TIPO","STRING" );
      ((Element)v.get(153)).setAttribute("VALOR","B" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 152   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(154)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(154)).setAttribute("TIPO","STRING" );
      ((Element)v.get(154)).setAttribute("VALOR","Cuenta Banco" );
      ((Element)v.get(152)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:152   */

      /* Empieza nodo:155 / Elemento padre: 148   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(155)).setAttribute("ID","P" );
      ((Element)v.get(148)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(156)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(156)).setAttribute("TIPO","STRING" );
      ((Element)v.get(156)).setAttribute("VALOR","P" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 155   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(157)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(157)).setAttribute("TIPO","STRING" );
      ((Element)v.get(157)).setAttribute("VALOR","Cuenta Puente banco" );
      ((Element)v.get(155)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:155   */

      /* Empieza nodo:158 / Elemento padre: 148   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(158)).setAttribute("ID","T" );
      ((Element)v.get(148)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(159)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(159)).setAttribute("TIPO","STRING" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(159)).setAttribute("VALOR","T" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 158   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(160)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(160)).setAttribute("TIPO","STRING" );
      ((Element)v.get(160)).setAttribute("VALOR","Cuenta Tipo abono/cargo" );
      ((Element)v.get(158)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:158   */

      /* Empieza nodo:161 / Elemento padre: 148   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(161)).setAttribute("ID","C" );
      ((Element)v.get(148)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(162)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(162)).setAttribute("TIPO","STRING" );
      ((Element)v.get(162)).setAttribute("VALOR","C" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 161   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(163)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(163)).setAttribute("TIPO","STRING" );
      ((Element)v.get(163)).setAttribute("VALOR","Cuenta Cuota anterior" );
      ((Element)v.get(161)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:161   */

      /* Empieza nodo:164 / Elemento padre: 148   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(164)).setAttribute("ID","N" );
      ((Element)v.get(148)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(165)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(165)).setAttribute("TIPO","STRING" );
      ((Element)v.get(165)).setAttribute("VALOR","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 164   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(166)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(166)).setAttribute("TIPO","STRING" );
      ((Element)v.get(166)).setAttribute("VALOR","Cuenta cuota Nueva" );
      ((Element)v.get(164)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:164   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:167 / Elemento padre: 139   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(167)).setAttribute("nombre","valObteCuenGapTdId" );
      ((Element)v.get(167)).setAttribute("nowrap","true" );
      ((Element)v.get(167)).setAttribute("class","datosCampos" );
      ((Element)v.get(139)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","25" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 139   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(169)).setAttribute("nombre","cucoOidCuenContDireTdId" );
      ((Element)v.get(139)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(170)).setAttribute("border","0" );
      ((Element)v.get(170)).setAttribute("cellspacing","0" );
      ((Element)v.get(170)).setAttribute("cellpadding","0" );
      ((Element)v.get(170)).setAttribute("align","left" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(172)).setAttribute("valign","top" );
      ((Element)v.get(172)).setAttribute("height","13" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(173)).setAttribute("nombre","lblcucoOidCuenContDire" );
      ((Element)v.get(173)).setAttribute("id","datosTitle" );
      ((Element)v.get(173)).setAttribute("ancho","150" );
      ((Element)v.get(173)).setAttribute("alto","13" );
      ((Element)v.get(173)).setAttribute("cod","CccParamConta.cucoOidCuenContDire.label" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:174 / Elemento padre: 170   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(174)).setAttribute("nombre","cucoOidCuenContDireWidgetTrId" );
      ((Element)v.get(170)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(175)).setAttribute("align","left" );
      ((Element)v.get(175)).setAttribute("nowrap","true" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(176)).setAttribute("nombre","cucoOidCuenContDire" );
      ((Element)v.get(176)).setAttribute("id","datosCampos" );
      ((Element)v.get(176)).setAttribute("multiple","N" );
      ((Element)v.get(176)).setAttribute("req","N" );
      ((Element)v.get(176)).setAttribute("size","1" );
      ((Element)v.get(176)).setAttribute("disabled","" );
      ((Element)v.get(176)).setAttribute("validacion","" );
      ((Element)v.get(176)).setAttribute("onchange","" );
      ((Element)v.get(176)).setAttribute("onfocus","" );
      ((Element)v.get(176)).setAttribute("valorinicial","" );
      ((Element)v.get(176)).setAttribute("textoinicial","" );
      ((Element)v.get(176)).setAttribute("ontab","ejecutarAccionFoco('cccParamContaFrm',6, true);" );
      ((Element)v.get(176)).setAttribute("onshtab","ejecutarAccionFoco('cccParamContaFrm',6, false);" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:178 / Elemento padre: 139   */
      v.add(doc.createElement("TD"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(178)).setAttribute("nombre","cucoOidCuenContDireGapTdId" );
      ((Element)v.get(178)).setAttribute("nowrap","true" );
      ((Element)v.get(178)).setAttribute("class","datosCampos" );
      ((Element)v.get(139)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","25" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 139   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(180)).setAttribute("nombre","valTextApunTdId" );
      ((Element)v.get(139)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(181)).setAttribute("width","100%" );
      ((Element)v.get(181)).setAttribute("border","0" );
      ((Element)v.get(181)).setAttribute("cellspacing","0" );
      ((Element)v.get(181)).setAttribute("cellpadding","0" );
      ((Element)v.get(181)).setAttribute("align","left" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(183)).setAttribute("valign","top" );
      ((Element)v.get(183)).setAttribute("height","13" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(184)).setAttribute("nombre","lblValTextApun" );
      ((Element)v.get(184)).setAttribute("alto","13" );
      ((Element)v.get(184)).setAttribute("filas","1" );
      ((Element)v.get(184)).setAttribute("id","datosTitle" );
      ((Element)v.get(184)).setAttribute("cod","CccParamConta.valTextApun.label" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:185 / Elemento padre: 181   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(185)).setAttribute("nombre","valTextApunWidgetTrId" );
      ((Element)v.get(181)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(186)).setAttribute("align","left" );
      ((Element)v.get(186)).setAttribute("nowrap","true" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(187)).setAttribute("nombre","valTextApun" );
      ((Element)v.get(187)).setAttribute("id","datosCampos" );
      ((Element)v.get(187)).setAttribute("trim","S" );
      ((Element)v.get(187)).setAttribute("max","40" );
      ((Element)v.get(187)).setAttribute("onchange","" );
      ((Element)v.get(187)).setAttribute("req","N" );
      ((Element)v.get(187)).setAttribute("size","40" );
      ((Element)v.get(187)).setAttribute("valor","" );
      ((Element)v.get(187)).setAttribute("validacion","" );
      ((Element)v.get(187)).setAttribute("disabled","" );
      ((Element)v.get(187)).setAttribute("onblur","" );
      ((Element)v.get(187)).setAttribute("ontab","ejecutarAccionFoco('cccParamContaFrm',7, true)" );
      ((Element)v.get(187)).setAttribute("onshtab","ejecutarAccionFoco('cccParamContaFrm', 7, false)" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:188 / Elemento padre: 139   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(188)).setAttribute("nombre","valTextApunGapTdId" );
      ((Element)v.get(188)).setAttribute("nowrap","true" );
      ((Element)v.get(188)).setAttribute("class","datosCampos" );
      ((Element)v.get(139)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","25" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 139   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(190)).setAttribute("width","100%" );
      ((Element)v.get(139)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:134   */

      /* Empieza nodo:192 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(192)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(54)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(193)).setAttribute("align","center" );
      ((Element)v.get(193)).setAttribute("width","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","12" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 192   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(192)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","8" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 192   */
      v.add(doc.createElement("TD"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(197)).setAttribute("align","center" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","12" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:192   */

      /* Empieza nodo:199 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(199)).setAttribute("nombre","formTr3" );
      ((Element)v.get(54)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(200)).setAttribute("align","center" );
      ((Element)v.get(200)).setAttribute("width","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(201)).setAttribute("height","12" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 199   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(202)).setAttribute("width","100%" );
      ((Element)v.get(199)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(203)).setAttribute("width","100%" );
      ((Element)v.get(203)).setAttribute("border","0" );
      ((Element)v.get(203)).setAttribute("cellspacing","0" );
      ((Element)v.get(203)).setAttribute("cellpadding","0" );
      ((Element)v.get(203)).setAttribute("align","left" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(204)).setAttribute("align","left" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(205)).setAttribute("nombre","indConcFechTdId" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

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
      ((Element)v.get(209)).setAttribute("nombre","lblIndConcFech" );
      ((Element)v.get(209)).setAttribute("alto","13" );
      ((Element)v.get(209)).setAttribute("filas","1" );
      ((Element)v.get(209)).setAttribute("id","datosTitle" );
      ((Element)v.get(209)).setAttribute("cod","CccParamConta.indConcFech.label" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:210 / Elemento padre: 206   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(210)).setAttribute("nombre","indConcFechWidgetTrId" );
      ((Element)v.get(206)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(211)).setAttribute("align","left" );
      ((Element)v.get(211)).setAttribute("nowrap","true" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(212)).setAttribute("nombre","indConcFech" );
      ((Element)v.get(212)).setAttribute("tipo","H" );
      ((Element)v.get(212)).setAttribute("req","N" );
      ((Element)v.get(212)).setAttribute("id","datosCampos" );
      ((Element)v.get(212)).setAttribute("valor","" );
      ((Element)v.get(212)).setAttribute("disabled","" );
      ((Element)v.get(212)).setAttribute("ontab","ejecutarAccionFoco('cccParamContaFrm',8, true)" );
      ((Element)v.get(212)).setAttribute("onshtab","ejecutarAccionFoco('cccParamContaFrm',8, false)" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(213)).setAttribute("id","datosCampos" );
      ((Element)v.get(213)).setAttribute("valor","1" );
      ((Element)v.get(213)).setAttribute("cod","CccParamConta.indConcFech.1.label" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Elemento padre:213 / Elemento actual: 214   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(213)).appendChild((Text)v.get(214));

      /* Termina nodo Texto:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 212   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(215)).setAttribute("id","datosCampos" );
      ((Element)v.get(215)).setAttribute("valor","0" );
      ((Element)v.get(215)).setAttribute("cod","CccParamConta.indConcFech.0.label" );
      ((Element)v.get(212)).appendChild((Element)v.get(215));

      /* Elemento padre:215 / Elemento actual: 216   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(215)).appendChild((Text)v.get(216));

      /* Termina nodo Texto:216   */
      /* Termina nodo:215   */
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:217 / Elemento padre: 204   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(217)).setAttribute("nombre","indConcFechGapTdId" );
      ((Element)v.get(217)).setAttribute("nowrap","true" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(217)).setAttribute("class","datosCampos" );
      ((Element)v.get(204)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","25" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 204   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(219)).setAttribute("nombre","valObseTdId" );
      ((Element)v.get(204)).appendChild((Element)v.get(219));

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
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(222)).setAttribute("valign","top" );
      ((Element)v.get(222)).setAttribute("height","13" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(223)).setAttribute("nombre","lblValObse" );
      ((Element)v.get(223)).setAttribute("alto","13" );
      ((Element)v.get(223)).setAttribute("filas","1" );
      ((Element)v.get(223)).setAttribute("id","datosTitle" );
      ((Element)v.get(223)).setAttribute("cod","CccParamConta.valObse.label" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:224 / Elemento padre: 220   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(224)).setAttribute("nombre","valObseWidgetTrId" );
      ((Element)v.get(220)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(225)).setAttribute("align","left" );
      ((Element)v.get(225)).setAttribute("nowrap","true" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(226)).setAttribute("nombre","valObse" );
      ((Element)v.get(226)).setAttribute("id","datosCampos" );
      ((Element)v.get(226)).setAttribute("trim","S" );
      ((Element)v.get(226)).setAttribute("max","100" );
      ((Element)v.get(226)).setAttribute("onchange","" );
      ((Element)v.get(226)).setAttribute("req","N" );
      ((Element)v.get(226)).setAttribute("size","100" );
      ((Element)v.get(226)).setAttribute("valor","" );
      ((Element)v.get(226)).setAttribute("validacion","" );
      ((Element)v.get(226)).setAttribute("disabled","" );
      ((Element)v.get(226)).setAttribute("onblur","" );
      ((Element)v.get(226)).setAttribute("ontab","ejecutarAccionFoco('cccParamContaFrm',9, true)" );
      ((Element)v.get(226)).setAttribute("onshtab","ejecutarAccionFoco('cccParamContaFrm', 9, false)" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:227 / Elemento padre: 204   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(227)).setAttribute("nombre","valObseGapTdId" );
      ((Element)v.get(227)).setAttribute("nowrap","true" );
      ((Element)v.get(227)).setAttribute("class","datosCampos" );
      ((Element)v.get(204)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","25" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 204   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(229)).setAttribute("width","100%" );
      ((Element)v.get(204)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:231 / Elemento padre: 199   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(231)).setAttribute("width","100%" );
      ((Element)v.get(199)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:199   */

      /* Empieza nodo:232 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(232)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(54)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(233)).setAttribute("align","center" );
      ((Element)v.get(233)).setAttribute("width","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","8" );
      ((Element)v.get(234)).setAttribute("height","8" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 232   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(232)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(236)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).setAttribute("width","8" );
      ((Element)v.get(236)).setAttribute("height","8" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 232   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(237)).setAttribute("align","center" );
      ((Element)v.get(237)).setAttribute("width","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","8" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:232   */
      /* Termina nodo:54   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:239 / Elemento padre: 47   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(239)).setAttribute("align","center" );
      ((Element)v.get(239)).setAttribute("width","12" );
      ((Element)v.get(47)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","12" );
      ((Element)v.get(240)).setAttribute("height","12" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:47   */

      /* Empieza nodo:241 / Elemento padre: 39   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(241)).setAttribute("nombre","cccParamContaTrButtons" );
      ((Element)v.get(39)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(242)).setAttribute("align","center" );
      ((Element)v.get(242)).setAttribute("width","12" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","12" );
      ((Element)v.get(243)).setAttribute("height","12" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 241   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(241)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(246)).setAttribute("width","100%" );
      ((Element)v.get(246)).setAttribute("border","0" );
      ((Element)v.get(246)).setAttribute("align","center" );
      ((Element)v.get(246)).setAttribute("cellspacing","0" );
      ((Element)v.get(246)).setAttribute("cellpadding","0" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(248)).setAttribute("class","tablaTitle" );
      ((Element)v.get(248)).setAttribute("nombre","cccParamContaTdQueryButton" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(249)).setAttribute("nombre","cccParamContaQueryButton" );
      ((Element)v.get(249)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(249)).setAttribute("estado","false" );
      ((Element)v.get(249)).setAttribute("accion","cccParamContaFirstPage();" );
      ((Element)v.get(249)).setAttribute("tipo","html" );
      ((Element)v.get(249)).setAttribute("ID","botonContenido" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 247   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(250)).setAttribute("class","tablaTitle" );
      ((Element)v.get(250)).setAttribute("nombre","cccParamContaTdLovNullSelectionButton" );
      ((Element)v.get(250)).setAttribute("align","left" );
      ((Element)v.get(250)).setAttribute("width","100%" );
      ((Element)v.get(247)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(251)).setAttribute("width","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 250   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(252)).setAttribute("nombre","cccParamContaLovNullButton" );
      ((Element)v.get(252)).setAttribute("ID","botonContenido" );
      ((Element)v.get(252)).setAttribute("tipo","html" );
      ((Element)v.get(252)).setAttribute("accion","cccParamContaLovNullSelectionAction();" );
      ((Element)v.get(252)).setAttribute("estado","true" );
      ((Element)v.get(252)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(250)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:250   */
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:253 / Elemento padre: 241   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(253)).setAttribute("align","center" );
      ((Element)v.get(253)).setAttribute("width","12" );
      ((Element)v.get(241)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","12" );
      ((Element)v.get(254)).setAttribute("height","12" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:241   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:255 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(255)).setAttribute("nombre","cccParamContaListLayer" );
      ((Element)v.get(255)).setAttribute("alto","310" );
      ((Element)v.get(255)).setAttribute("ancho","99%" );
      ((Element)v.get(255)).setAttribute("colorf","" );
      ((Element)v.get(255)).setAttribute("borde","0" );
      ((Element)v.get(255)).setAttribute("imagenf","" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(255)).setAttribute("repeat","" );
      ((Element)v.get(255)).setAttribute("padding","" );
      ((Element)v.get(255)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(255)).setAttribute("contravsb","" );
      ((Element)v.get(255)).setAttribute("x","3" );
      ((Element)v.get(255)).setAttribute("y","" );
      ((Element)v.get(255)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(256)).setAttribute("nombre","cccParamContaList" );
      ((Element)v.get(256)).setAttribute("ancho","680" );
      ((Element)v.get(256)).setAttribute("alto","275" );
      ((Element)v.get(256)).setAttribute("x","12" );
      ((Element)v.get(256)).setAttribute("y","0" );
      ((Element)v.get(256)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(256)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(257)).setAttribute("precarga","S" );
      ((Element)v.get(257)).setAttribute("conROver","S" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(258)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(258)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(258)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(258)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 257   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(259)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(259)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(259)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(259)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(257)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:257   */

      /* Empieza nodo:260 / Elemento padre: 256   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(256)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(261)).setAttribute("borde","1" );
      ((Element)v.get(261)).setAttribute("horizDatos","1" );
      ((Element)v.get(261)).setAttribute("horizCabecera","1" );
      ((Element)v.get(261)).setAttribute("vertical","1" );
      ((Element)v.get(261)).setAttribute("horizTitulo","1" );
      ((Element)v.get(261)).setAttribute("horizBase","1" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */

      /* Empieza nodo:262 / Elemento padre: 260   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(262)).setAttribute("borde","#999999" );
      ((Element)v.get(262)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(262)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(262)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(262)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(262)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(262)).setAttribute("horizBase","#999999" );
      ((Element)v.get(260)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:260   */

      /* Empieza nodo:263 / Elemento padre: 256   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(263)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(263)).setAttribute("alto","22" );
      ((Element)v.get(263)).setAttribute("imgFondo","" );
      ((Element)v.get(263)).setAttribute("cod","00135" );
      ((Element)v.get(263)).setAttribute("ID","datosTitle" );
      ((Element)v.get(256)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */

      /* Empieza nodo:264 / Elemento padre: 256   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(264)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(264)).setAttribute("alto","22" );
      ((Element)v.get(264)).setAttribute("imgFondo","" );
      ((Element)v.get(256)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 256   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(265)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(265)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(265)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(265)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(265)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(256)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(266)).setAttribute("ancho","100" );
      ((Element)v.get(266)).setAttribute("minimizable","S" );
      ((Element)v.get(266)).setAttribute("minimizada","N" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 265   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(267)).setAttribute("ancho","100" );
      ((Element)v.get(267)).setAttribute("minimizable","S" );
      ((Element)v.get(267)).setAttribute("minimizada","N" );
      ((Element)v.get(265)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 265   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("ancho","100" );
      ((Element)v.get(268)).setAttribute("minimizable","S" );
      ((Element)v.get(268)).setAttribute("minimizada","N" );
      ((Element)v.get(265)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 265   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("ancho","100" );
      ((Element)v.get(269)).setAttribute("minimizable","S" );
      ((Element)v.get(269)).setAttribute("minimizada","N" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(265)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:265   */

      /* Empieza nodo:270 / Elemento padre: 256   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(270)).setAttribute("height","20" );
      ((Element)v.get(270)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(270)).setAttribute("imgFondo","" );
      ((Element)v.get(270)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(256)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(271)).setAttribute("colFondo","" );
      ((Element)v.get(271)).setAttribute("ID","EstCab" );
      ((Element)v.get(271)).setAttribute("cod","CccParamConta.subpOidSubp.label" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 270   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("colFondo","" );
      ((Element)v.get(272)).setAttribute("ID","EstCab" );
      ((Element)v.get(272)).setAttribute("cod","CccParamConta.valDebeHabe.label" );
      ((Element)v.get(270)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 270   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("colFondo","" );
      ((Element)v.get(273)).setAttribute("ID","EstCab" );
      ((Element)v.get(273)).setAttribute("cod","CccParamConta.valObteCuen.label" );
      ((Element)v.get(270)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 270   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("colFondo","" );
      ((Element)v.get(274)).setAttribute("ID","EstCab" );
      ((Element)v.get(274)).setAttribute("cod","CccParamConta.valTextApun.label" );
      ((Element)v.get(270)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:270   */

      /* Empieza nodo:275 / Elemento padre: 256   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(275)).setAttribute("alto","22" );
      ((Element)v.get(275)).setAttribute("accion","" );
      ((Element)v.get(275)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(275)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(275)).setAttribute("maxSel","1" );
      ((Element)v.get(275)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(275)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(275)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(275)).setAttribute("onLoad","" );
      ((Element)v.get(275)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(256)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("tipo","texto" );
      ((Element)v.get(276)).setAttribute("ID","EstDat" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 275   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("tipo","texto" );
      ((Element)v.get(277)).setAttribute("ID","EstDat2" );
      ((Element)v.get(275)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 275   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("tipo","texto" );
      ((Element)v.get(278)).setAttribute("ID","EstDat" );
      ((Element)v.get(275)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 275   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("tipo","texto" );
      ((Element)v.get(279)).setAttribute("ID","EstDat2" );
      ((Element)v.get(275)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:275   */

      /* Empieza nodo:280 / Elemento padre: 256   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(256)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:281 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(281)).setAttribute("nombre","cccParamContaListButtonsLayer" );
      ((Element)v.get(281)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(281)).setAttribute("alto","30" );
      ((Element)v.get(281)).setAttribute("ancho","98%" );
      ((Element)v.get(281)).setAttribute("borde","n" );
      ((Element)v.get(281)).setAttribute("imagenf","" );
      ((Element)v.get(281)).setAttribute("repeat","" );
      ((Element)v.get(281)).setAttribute("padding","0" );
      ((Element)v.get(281)).setAttribute("contravsb","" );
      ((Element)v.get(281)).setAttribute("x","16" );
      ((Element)v.get(281)).setAttribute("y","" );
      ((Element)v.get(281)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(282)).setAttribute("nombre","toolbarSeparatorLayer" );
      ((Element)v.get(282)).setAttribute("visibilidad","inherit" );
      ((Element)v.get(282)).setAttribute("alto","23" );
      ((Element)v.get(282)).setAttribute("ancho","1" );
      ((Element)v.get(282)).setAttribute("borde","1" );
      ((Element)v.get(282)).setAttribute("imagenf","" );
      ((Element)v.get(282)).setAttribute("repeat","" );
      ((Element)v.get(282)).setAttribute("padding","0" );
      ((Element)v.get(282)).setAttribute("contravsb","" );
      ((Element)v.get(282)).setAttribute("x","56" );
      ((Element)v.get(282)).setAttribute("y","0" );
      ((Element)v.get(282)).setAttribute("zindex","" );
      ((Element)v.get(282)).setAttribute("colborde","#999999" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 281   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(283)).setAttribute("width","100%" );
      ((Element)v.get(283)).setAttribute("border","0" );
      ((Element)v.get(283)).setAttribute("cellspacing","1" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(283)).setAttribute("cellpadding","0" );
      ((Element)v.get(281)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("height","22" );
      ((Element)v.get(285)).setAttribute("width","5" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(283)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(287)).setAttribute("nombre","cccParamContaPaginationButtonBar" );
      ((Element)v.get(287)).setAttribute("tipo","H" );
      ((Element)v.get(287)).setAttribute("x","0" );
      ((Element)v.get(287)).setAttribute("y","0" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(288)).setAttribute("nombre","cccParamContaFirstPageButton" );
      ((Element)v.get(288)).setAttribute("funcion","cccParamContaFirstPage();" );
      ((Element)v.get(288)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(288)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(288)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(288)).setAttribute("estado","inactivo" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 287   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(289)).setAttribute("nombre","cccParamContaFirstPageButtonGapTd" );
      ((Element)v.get(287)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(290)).setAttribute("src","b.gif" );
      ((Element)v.get(290)).setAttribute("height","8" );
      ((Element)v.get(290)).setAttribute("width","5" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:291 / Elemento padre: 287   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(291)).setAttribute("nombre","cccParamContaPreviousPageButton" );
      ((Element)v.get(291)).setAttribute("funcion","cccParamContaPreviousPage();" );
      ((Element)v.get(291)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(291)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(291)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(291)).setAttribute("estado","inactivo" );
      ((Element)v.get(287)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 287   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(292)).setAttribute("nombre","cccParamContaPreviousPageButtonGapTd" );
      ((Element)v.get(287)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(293)).setAttribute("width","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 287   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(294)).setAttribute("nombre","cccParamContaNextPageButton" );
      ((Element)v.get(294)).setAttribute("funcion","cccParamContaNextPage();" );
      ((Element)v.get(294)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(294)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(294)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(294)).setAttribute("estado","inactivo" );
      ((Element)v.get(287)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:295 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(283)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(296)).setAttribute("height","22" );
      ((Element)v.get(296)).setAttribute("width","19" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(297)).setAttribute("class","tablaTitle" );
      ((Element)v.get(297)).setAttribute("nombre","cccParamContaUpdateButtonTd" );
      ((Element)v.get(283)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(298)).setAttribute("nombre","cccParamContaUpdateButton" );
      ((Element)v.get(298)).setAttribute("ID","botonContenido" );
      ((Element)v.get(298)).setAttribute("tipo","html" );
      ((Element)v.get(298)).setAttribute("accion","cccParamContaUpdateSelection();" );
      ((Element)v.get(298)).setAttribute("estado","false" );
      ((Element)v.get(298)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(299)).setAttribute("nombre","cccParamContaUpdateButtonGapTd" );
      ((Element)v.get(283)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(300)).setAttribute("src","b.gif" );
      ((Element)v.get(300)).setAttribute("height","8" );
      ((Element)v.get(300)).setAttribute("width","10" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(301)).setAttribute("class","tablaTitle" );
      ((Element)v.get(301)).setAttribute("nombre","cccParamContaViewForRemoveButtonTd" );
      ((Element)v.get(283)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(302)).setAttribute("nombre","cccParamContaViewForRemoveButton" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(302)).setAttribute("ID","botonContenido" );
      ((Element)v.get(302)).setAttribute("tipo","html" );
      ((Element)v.get(302)).setAttribute("accion","cccParamContaViewSelection();" );
      ((Element)v.get(302)).setAttribute("estado","false" );
      ((Element)v.get(302)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(303)).setAttribute("nombre","cccParamContaViewForRemoveButtonGapTd" );
      ((Element)v.get(283)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).setAttribute("height","8" );
      ((Element)v.get(304)).setAttribute("width","10" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(305)).setAttribute("class","tablaTitle" );
      ((Element)v.get(305)).setAttribute("nombre","cccParamContaLovSelectButtonTd" );
      ((Element)v.get(283)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(306)).setAttribute("nombre","cccParamContaLovSelectButton" );
      ((Element)v.get(306)).setAttribute("ID","botonContenido" );
      ((Element)v.get(306)).setAttribute("tipo","html" );
      ((Element)v.get(306)).setAttribute("accion","cccParamContaLovSelectionAction();" );
      ((Element)v.get(306)).setAttribute("estado","true" );
      ((Element)v.get(306)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(307)).setAttribute("nombre","cccParamContaLovSelectButtonGapTd" );
      ((Element)v.get(283)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(308)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).setAttribute("height","8" );
      ((Element)v.get(308)).setAttribute("width","10" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:309 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(309)).setAttribute("class","tablaTitle" );
      ((Element)v.get(309)).setAttribute("nombre","cccParamContaViewButtonTd" );
      ((Element)v.get(283)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(310)).setAttribute("nombre","cccParamContaViewButton" );
      ((Element)v.get(310)).setAttribute("ID","botonContenido" );
      ((Element)v.get(310)).setAttribute("tipo","html" );
      ((Element)v.get(310)).setAttribute("accion","cccParamContaViewSelection();" );
      ((Element)v.get(310)).setAttribute("estado","false" );
      ((Element)v.get(310)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:311 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(311)).setAttribute("nombre","cccParamContaViewButtonGapTd" );
      ((Element)v.get(283)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(312)).setAttribute("width","10" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(313)).setAttribute("width","100%" );
      ((Element)v.get(283)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:283   */
      /* Termina nodo:281   */
      /* Termina nodo:4   */


   }

}

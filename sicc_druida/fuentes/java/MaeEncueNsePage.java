
import org.w3c.dom.*;
import java.util.ArrayList;

public class MaeEncueNsePage  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","MaeEncueNsePage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","maeEncueNseInitComponents()" );
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
      ((Element)v.get(4)).setAttribute("src","maeencuense.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","maeEncueNseFrm" );
      ((Element)v.get(5)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(6)).setAttribute("valor","MaeEncueNseLPExecution" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","ON" );
      ((Element)v.get(7)).setAttribute("valor","MaeEncueNseLPExecution" );
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
      ((Element)v.get(37)).setAttribute("nombre","maeEncueNseFormLayer" );
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
      ((Element)v.get(52)).setAttribute("cod","MaeEncueNse.legend.label" );
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
      ((Element)v.get(67)).setAttribute("cod","MaeEncueNse.id.label" );
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
      ((Element)v.get(70)).setAttribute("ontab","ejecutarAccionFoco('maeEncueNseFrm',1, true)" );
      ((Element)v.get(70)).setAttribute("onshtab","ejecutarAccionFoco('maeEncueNseFrm', 1, false)" );
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
      ((Element)v.get(92)).setAttribute("ancho","150" );
      ((Element)v.get(92)).setAttribute("alto","13" );
      ((Element)v.get(92)).setAttribute("cod","MaeEncueNse.paisOidPais.label" );
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
      ((Element)v.get(95)).setAttribute("ontab","ejecutarAccionFoco('maeEncueNseFrm',2, true);" );
      ((Element)v.get(95)).setAttribute("onshtab","ejecutarAccionFoco('maeEncueNseFrm',2, false);" );
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
      ((Element)v.get(99)).setAttribute("width","100%" );
      ((Element)v.get(87)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:82   */

      /* Empieza nodo:101 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(101)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(53)).appendChild((Element)v.get(101));

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

      /* Empieza nodo:108 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(108)).setAttribute("nombre","formTr2" );
      ((Element)v.get(53)).appendChild((Element)v.get(108));

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
      ((Element)v.get(114)).setAttribute("nombre","codTipoEncuTdId" );
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
      ((Element)v.get(118)).setAttribute("nombre","lblCodTipoEncu" );
      ((Element)v.get(118)).setAttribute("alto","13" );
      ((Element)v.get(118)).setAttribute("filas","1" );
      ((Element)v.get(118)).setAttribute("id","datosTitle" );
      ((Element)v.get(118)).setAttribute("cod","MaeEncueNse.codTipoEncu.label" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:119 / Elemento padre: 115   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(119)).setAttribute("nombre","codTipoEncuWidgetTrId" );
      ((Element)v.get(115)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(120)).setAttribute("align","left" );
      ((Element)v.get(120)).setAttribute("nowrap","true" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(121)).setAttribute("nombre","codTipoEncu" );
      ((Element)v.get(121)).setAttribute("id","datosCampos" );
      ((Element)v.get(121)).setAttribute("trim","S" );
      ((Element)v.get(121)).setAttribute("max","3" );
      ((Element)v.get(121)).setAttribute("onchange","" );
      ((Element)v.get(121)).setAttribute("req","N" );
      ((Element)v.get(121)).setAttribute("size","3" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(121)).setAttribute("valor","" );
      ((Element)v.get(121)).setAttribute("validacion","" );
      ((Element)v.get(121)).setAttribute("disabled","" );
      ((Element)v.get(121)).setAttribute("onblur","" );
      ((Element)v.get(121)).setAttribute("ontab","ejecutarAccionFoco('maeEncueNseFrm',3, true)" );
      ((Element)v.get(121)).setAttribute("onshtab","ejecutarAccionFoco('maeEncueNseFrm', 3, false)" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:122 / Elemento padre: 113   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(122)).setAttribute("nombre","codTipoEncuGapTdId" );
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
      ((Element)v.get(124)).setAttribute("nombre","DescripcionTdId" );
      ((Element)v.get(113)).appendChild((Element)v.get(124));

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
      ((Element)v.get(128)).setAttribute("cod","MaeEncueNse.Descripcion.label" );
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
      ((Element)v.get(132)).setAttribute("max","40" );
      ((Element)v.get(132)).setAttribute("onchange","" );
      ((Element)v.get(132)).setAttribute("req","N" );
      ((Element)v.get(132)).setAttribute("size","40" );
      ((Element)v.get(132)).setAttribute("valor","" );
      ((Element)v.get(132)).setAttribute("validacion","" );
      ((Element)v.get(132)).setAttribute("disabled","" );
      ((Element)v.get(132)).setAttribute("onblur","" );
      ((Element)v.get(132)).setAttribute("ontab","ejecutarAccionFoco('maeEncueNseFrm',4, true)" );
      ((Element)v.get(132)).setAttribute("onshtab","ejecutarAccionFoco('maeEncueNseFrm', 4, false)" );
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
      ((Element)v.get(135)).setAttribute("valign","bottom" );
      ((Element)v.get(130)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("A"));
      ((Element)v.get(136)).setAttribute("id","DescripcionLocalizationButton" );
      ((Element)v.get(136)).setAttribute("href","javascript:openLocalizationDialog('maeEncueNseFrm', 'Descripcion', 1);" );
      ((Element)v.get(136)).setAttribute("onKeyDown","javascript:mmgImgEventDispatcherForFocus(event, 'ejecutarAccionFoco(\"maeEncueNseFrm\",4, true)', 'ejecutarAccionFoco(\"maeEncueNseFrm\",4, false)')" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("nombre","DescripcionLocalizationButton" );
      ((Element)v.get(137)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(137)).setAttribute("border","0" );
      ((Element)v.get(137)).setAttribute("width","21" );
      ((Element)v.get(137)).setAttribute("height","15" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(137)).setAttribute("class","main" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:130   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:138 / Elemento padre: 113   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(138)).setAttribute("nombre","DescripcionGapTdId" );
      ((Element)v.get(138)).setAttribute("nowrap","true" );
      ((Element)v.get(138)).setAttribute("class","datosCampos" );
      ((Element)v.get(113)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","25" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 113   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(140)).setAttribute("width","100%" );
      ((Element)v.get(113)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:108   */

      /* Empieza nodo:142 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(142)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(53)).appendChild((Element)v.get(142));

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

      /* Empieza nodo:149 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(149)).setAttribute("nombre","formTr3" );
      ((Element)v.get(53)).appendChild((Element)v.get(149));

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
      ((Element)v.get(155)).setAttribute("nombre","marcOidMarcTdId" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(156)).setAttribute("border","0" );
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
      ((Element)v.get(159)).setAttribute("nombre","lblmarcOidMarc" );
      ((Element)v.get(159)).setAttribute("id","datosTitle" );
      ((Element)v.get(159)).setAttribute("ancho","150" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(159)).setAttribute("alto","13" );
      ((Element)v.get(159)).setAttribute("cod","MaeEncueNse.marcOidMarc.label" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:160 / Elemento padre: 156   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(160)).setAttribute("nombre","marcOidMarcWidgetTrId" );
      ((Element)v.get(156)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(161)).setAttribute("align","left" );
      ((Element)v.get(161)).setAttribute("nowrap","true" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(162)).setAttribute("nombre","marcOidMarc" );
      ((Element)v.get(162)).setAttribute("id","datosCampos" );
      ((Element)v.get(162)).setAttribute("multiple","N" );
      ((Element)v.get(162)).setAttribute("req","N" );
      ((Element)v.get(162)).setAttribute("size","1" );
      ((Element)v.get(162)).setAttribute("disabled","" );
      ((Element)v.get(162)).setAttribute("validacion","" );
      ((Element)v.get(162)).setAttribute("onchange","" );
      ((Element)v.get(162)).setAttribute("onfocus","" );
      ((Element)v.get(162)).setAttribute("valorinicial","" );
      ((Element)v.get(162)).setAttribute("textoinicial","" );
      ((Element)v.get(162)).setAttribute("ontab","ejecutarAccionFoco('maeEncueNseFrm',7, true);" );
      ((Element)v.get(162)).setAttribute("onshtab","ejecutarAccionFoco('maeEncueNseFrm',7, false);" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:164 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(164)).setAttribute("nombre","marcOidMarcGapTdId" );
      ((Element)v.get(164)).setAttribute("nowrap","true" );
      ((Element)v.get(164)).setAttribute("class","datosCampos" );
      ((Element)v.get(154)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","25" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(166)).setAttribute("width","100%" );
      ((Element)v.get(154)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:168 / Elemento padre: 149   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(168)).setAttribute("width","100%" );
      ((Element)v.get(149)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:149   */

      /* Empieza nodo:169 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(169)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(53)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(170)).setAttribute("align","center" );
      ((Element)v.get(170)).setAttribute("width","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","8" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 169   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(169)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","8" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 169   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(174)).setAttribute("align","center" );
      ((Element)v.get(174)).setAttribute("width","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","8" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:169   */
      /* Termina nodo:53   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:176 / Elemento padre: 46   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(176)).setAttribute("align","center" );
      ((Element)v.get(176)).setAttribute("width","12" );
      ((Element)v.get(46)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","12" );
      ((Element)v.get(177)).setAttribute("height","12" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:46   */

      /* Empieza nodo:178 / Elemento padre: 38   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(178)).setAttribute("nombre","maeEncueNseTrButtons" );
      ((Element)v.get(38)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(179)).setAttribute("align","center" );
      ((Element)v.get(179)).setAttribute("width","12" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","12" );
      ((Element)v.get(180)).setAttribute("height","12" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 178   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(178)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(183)).setAttribute("width","100%" );
      ((Element)v.get(183)).setAttribute("border","0" );
      ((Element)v.get(183)).setAttribute("align","center" );
      ((Element)v.get(183)).setAttribute("cellspacing","0" );
      ((Element)v.get(183)).setAttribute("cellpadding","0" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(185)).setAttribute("class","tablaTitle" );
      ((Element)v.get(185)).setAttribute("nombre","maeEncueNseTdQueryButton" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(186)).setAttribute("nombre","maeEncueNseQueryButton" );
      ((Element)v.get(186)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(186)).setAttribute("estado","false" );
      ((Element)v.get(186)).setAttribute("accion","maeEncueNseFirstPage();" );
      ((Element)v.get(186)).setAttribute("tipo","html" );
      ((Element)v.get(186)).setAttribute("ID","botonContenido" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 184   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(187)).setAttribute("class","tablaTitle" );
      ((Element)v.get(187)).setAttribute("nombre","maeEncueNseTdLovNullSelectionButton" );
      ((Element)v.get(187)).setAttribute("align","left" );
      ((Element)v.get(187)).setAttribute("width","100%" );
      ((Element)v.get(184)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 187   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(189)).setAttribute("nombre","maeEncueNseLovNullButton" );
      ((Element)v.get(189)).setAttribute("ID","botonContenido" );
      ((Element)v.get(189)).setAttribute("tipo","html" );
      ((Element)v.get(189)).setAttribute("accion","maeEncueNseLovNullSelectionAction();" );
      ((Element)v.get(189)).setAttribute("estado","true" );
      ((Element)v.get(189)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(187)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:187   */
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:190 / Elemento padre: 178   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(190)).setAttribute("align","center" );
      ((Element)v.get(190)).setAttribute("width","12" );
      ((Element)v.get(178)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","12" );
      ((Element)v.get(191)).setAttribute("height","12" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:178   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:192 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(192)).setAttribute("nombre","maeEncueNseListLayer" );
      ((Element)v.get(192)).setAttribute("alto","310" );
      ((Element)v.get(192)).setAttribute("ancho","99%" );
      ((Element)v.get(192)).setAttribute("colorf","" );
      ((Element)v.get(192)).setAttribute("borde","0" );
      ((Element)v.get(192)).setAttribute("imagenf","" );
      ((Element)v.get(192)).setAttribute("repeat","" );
      ((Element)v.get(192)).setAttribute("padding","" );
      ((Element)v.get(192)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(192)).setAttribute("contravsb","" );
      ((Element)v.get(192)).setAttribute("x","3" );
      ((Element)v.get(192)).setAttribute("y","" );
      ((Element)v.get(192)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(193)).setAttribute("nombre","maeEncueNseList" );
      ((Element)v.get(193)).setAttribute("ancho","680" );
      ((Element)v.get(193)).setAttribute("alto","275" );
      ((Element)v.get(193)).setAttribute("x","12" );
      ((Element)v.get(193)).setAttribute("y","0" );
      ((Element)v.get(193)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(193)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(194)).setAttribute("precarga","S" );
      ((Element)v.get(194)).setAttribute("conROver","S" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(195)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(195)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(195)).setAttribute("seleccionado","btnLista2M.gif" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(195)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 194   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(196)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(196)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(196)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(196)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(194)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:194   */

      /* Empieza nodo:197 / Elemento padre: 193   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(193)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(198)).setAttribute("borde","1" );
      ((Element)v.get(198)).setAttribute("horizDatos","1" );
      ((Element)v.get(198)).setAttribute("horizCabecera","1" );
      ((Element)v.get(198)).setAttribute("vertical","1" );
      ((Element)v.get(198)).setAttribute("horizTitulo","1" );
      ((Element)v.get(198)).setAttribute("horizBase","1" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 197   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(199)).setAttribute("borde","#999999" );
      ((Element)v.get(199)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(199)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(199)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(199)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(199)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(199)).setAttribute("horizBase","#999999" );
      ((Element)v.get(197)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:197   */

      /* Empieza nodo:200 / Elemento padre: 193   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(200)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(200)).setAttribute("alto","22" );
      ((Element)v.get(200)).setAttribute("imgFondo","" );
      ((Element)v.get(200)).setAttribute("cod","00135" );
      ((Element)v.get(200)).setAttribute("ID","datosTitle" );
      ((Element)v.get(193)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 193   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(201)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(201)).setAttribute("alto","22" );
      ((Element)v.get(201)).setAttribute("imgFondo","" );
      ((Element)v.get(193)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 193   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(202)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(202)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(202)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(202)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(202)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(193)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(203)).setAttribute("ancho","100" );
      ((Element)v.get(203)).setAttribute("minimizable","S" );
      ((Element)v.get(203)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("ancho","100" );
      ((Element)v.get(204)).setAttribute("minimizable","S" );
      ((Element)v.get(204)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(205)).setAttribute("ancho","100" );
      ((Element)v.get(205)).setAttribute("minimizable","S" );
      ((Element)v.get(205)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:202   */

      /* Empieza nodo:206 / Elemento padre: 193   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(206)).setAttribute("height","20" );
      ((Element)v.get(206)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(206)).setAttribute("imgFondo","" );
      ((Element)v.get(206)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(193)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("colFondo","" );
      ((Element)v.get(207)).setAttribute("ID","EstCab" );
      ((Element)v.get(207)).setAttribute("cod","MaeEncueNse.codTipoEncu.label" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 206   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("colFondo","" );
      ((Element)v.get(208)).setAttribute("ID","EstCab" );
      ((Element)v.get(208)).setAttribute("cod","MaeEncueNse.Descripcion.label" );
      ((Element)v.get(206)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 206   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(209)).setAttribute("colFondo","" );
      ((Element)v.get(209)).setAttribute("ID","EstCab" );
      ((Element)v.get(209)).setAttribute("cod","MaeEncueNse.marcOidMarc.label" );
      ((Element)v.get(206)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:206   */

      /* Empieza nodo:210 / Elemento padre: 193   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(210)).setAttribute("alto","22" );
      ((Element)v.get(210)).setAttribute("accion","" );
      ((Element)v.get(210)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(210)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(210)).setAttribute("maxSel","1" );
      ((Element)v.get(210)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(210)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(210)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(210)).setAttribute("onLoad","" );
      ((Element)v.get(210)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(193)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(211)).setAttribute("tipo","texto" );
      ((Element)v.get(211)).setAttribute("ID","EstDat" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("tipo","texto" );
      ((Element)v.get(212)).setAttribute("ID","EstDat2" );
      ((Element)v.get(210)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(213)).setAttribute("tipo","texto" );
      ((Element)v.get(213)).setAttribute("ID","EstDat" );
      ((Element)v.get(210)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:210   */

      /* Empieza nodo:214 / Elemento padre: 193   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(193)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:215 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(215)).setAttribute("nombre","maeEncueNseListButtonsLayer" );
      ((Element)v.get(215)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(215)).setAttribute("alto","30" );
      ((Element)v.get(215)).setAttribute("ancho","98%" );
      ((Element)v.get(215)).setAttribute("borde","n" );
      ((Element)v.get(215)).setAttribute("imagenf","" );
      ((Element)v.get(215)).setAttribute("repeat","" );
      ((Element)v.get(215)).setAttribute("padding","0" );
      ((Element)v.get(215)).setAttribute("contravsb","" );
      ((Element)v.get(215)).setAttribute("x","16" );
      ((Element)v.get(215)).setAttribute("y","" );
      ((Element)v.get(215)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(216)).setAttribute("nombre","toolbarSeparatorLayer" );
      ((Element)v.get(216)).setAttribute("visibilidad","inherit" );
      ((Element)v.get(216)).setAttribute("alto","23" );
      ((Element)v.get(216)).setAttribute("ancho","1" );
      ((Element)v.get(216)).setAttribute("borde","1" );
      ((Element)v.get(216)).setAttribute("imagenf","" );
      ((Element)v.get(216)).setAttribute("repeat","" );
      ((Element)v.get(216)).setAttribute("padding","0" );
      ((Element)v.get(216)).setAttribute("contravsb","" );
      ((Element)v.get(216)).setAttribute("x","56" );
      ((Element)v.get(216)).setAttribute("y","0" );
      ((Element)v.get(216)).setAttribute("zindex","" );
      ((Element)v.get(216)).setAttribute("colborde","#999999" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 215   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(217)).setAttribute("width","100%" );
      ((Element)v.get(217)).setAttribute("border","0" );
      ((Element)v.get(217)).setAttribute("cellspacing","1" );
      ((Element)v.get(217)).setAttribute("cellpadding","0" );
      ((Element)v.get(215)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("height","22" );
      ((Element)v.get(219)).setAttribute("width","5" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(217)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(221)).setAttribute("nombre","maeEncueNsePaginationButtonBar" );
      ((Element)v.get(221)).setAttribute("tipo","H" );
      ((Element)v.get(221)).setAttribute("x","0" );
      ((Element)v.get(221)).setAttribute("y","0" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(222)).setAttribute("nombre","maeEncueNseFirstPageButton" );
      ((Element)v.get(222)).setAttribute("funcion","maeEncueNseFirstPage();" );
      ((Element)v.get(222)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(222)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(222)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(222)).setAttribute("estado","inactivo" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 221   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(223)).setAttribute("nombre","maeEncueNseFirstPageButtonGapTd" );
      ((Element)v.get(221)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(224)).setAttribute("width","5" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 221   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(225)).setAttribute("nombre","maeEncueNsePreviousPageButton" );
      ((Element)v.get(225)).setAttribute("funcion","maeEncueNsePreviousPage();" );
      ((Element)v.get(225)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(225)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(225)).setAttribute("disable","retroceder_on0.gif" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(225)).setAttribute("estado","inactivo" );
      ((Element)v.get(221)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 221   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(226)).setAttribute("nombre","maeEncueNsePreviousPageButtonGapTd" );
      ((Element)v.get(221)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(227)).setAttribute("width","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 221   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(228)).setAttribute("nombre","maeEncueNseNextPageButton" );
      ((Element)v.get(228)).setAttribute("funcion","maeEncueNseNextPage();" );
      ((Element)v.get(228)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(228)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(228)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(228)).setAttribute("estado","inactivo" );
      ((Element)v.get(221)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:229 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(217)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("height","22" );
      ((Element)v.get(230)).setAttribute("width","19" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(231)).setAttribute("class","tablaTitle" );
      ((Element)v.get(231)).setAttribute("nombre","maeEncueNseUpdateButtonTd" );
      ((Element)v.get(217)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(232)).setAttribute("nombre","maeEncueNseUpdateButton" );
      ((Element)v.get(232)).setAttribute("ID","botonContenido" );
      ((Element)v.get(232)).setAttribute("tipo","html" );
      ((Element)v.get(232)).setAttribute("accion","maeEncueNseUpdateSelection();" );
      ((Element)v.get(232)).setAttribute("estado","false" );
      ((Element)v.get(232)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(233)).setAttribute("nombre","maeEncueNseUpdateButtonGapTd" );
      ((Element)v.get(217)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("height","8" );
      ((Element)v.get(234)).setAttribute("width","10" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(235)).setAttribute("class","tablaTitle" );
      ((Element)v.get(235)).setAttribute("nombre","maeEncueNseViewForRemoveButtonTd" );
      ((Element)v.get(217)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(236)).setAttribute("nombre","maeEncueNseViewForRemoveButton" );
      ((Element)v.get(236)).setAttribute("ID","botonContenido" );
      ((Element)v.get(236)).setAttribute("tipo","html" );
      ((Element)v.get(236)).setAttribute("accion","maeEncueNseViewSelection();" );
      ((Element)v.get(236)).setAttribute("estado","false" );
      ((Element)v.get(236)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(237)).setAttribute("nombre","maeEncueNseViewForRemoveButtonGapTd" );
      ((Element)v.get(217)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(238)).setAttribute("width","10" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(239)).setAttribute("class","tablaTitle" );
      ((Element)v.get(239)).setAttribute("nombre","maeEncueNseLovSelectButtonTd" );
      ((Element)v.get(217)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(240)).setAttribute("nombre","maeEncueNseLovSelectButton" );
      ((Element)v.get(240)).setAttribute("ID","botonContenido" );
      ((Element)v.get(240)).setAttribute("tipo","html" );
      ((Element)v.get(240)).setAttribute("accion","maeEncueNseLovSelectionAction();" );
      ((Element)v.get(240)).setAttribute("estado","true" );
      ((Element)v.get(240)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(241)).setAttribute("nombre","maeEncueNseLovSelectButtonGapTd" );
      ((Element)v.get(217)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("height","8" );
      ((Element)v.get(242)).setAttribute("width","10" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(243)).setAttribute("class","tablaTitle" );
      ((Element)v.get(243)).setAttribute("nombre","maeEncueNseViewButtonTd" );
      ((Element)v.get(217)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(244)).setAttribute("nombre","maeEncueNseViewButton" );
      ((Element)v.get(244)).setAttribute("ID","botonContenido" );
      ((Element)v.get(244)).setAttribute("tipo","html" );
      ((Element)v.get(244)).setAttribute("accion","maeEncueNseViewSelection();" );
      ((Element)v.get(244)).setAttribute("estado","false" );
      ((Element)v.get(244)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(245)).setAttribute("nombre","maeEncueNseViewButtonGapTd" );
      ((Element)v.get(217)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("height","8" );
      ((Element)v.get(246)).setAttribute("width","10" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(247)).setAttribute("width","100%" );
      ((Element)v.get(217)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:217   */
      /* Termina nodo:215   */
      /* Termina nodo:5   */


   }

}

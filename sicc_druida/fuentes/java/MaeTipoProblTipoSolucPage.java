
import org.w3c.dom.*;
import java.util.ArrayList;

public class MaeTipoProblTipoSolucPage  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","MaeTipoProblTipoSolucPage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","maeTipoProblTipoSolucInitComponents()" );
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
      ((Element)v.get(3)).setAttribute("src","maetipoprobltiposoluc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","maeTipoProblTipoSolucFrm" );
      ((Element)v.get(4)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","MaeTipoProblTipoSolucLPExecution" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","ON" );
      ((Element)v.get(6)).setAttribute("valor","MaeTipoProblTipoSolucLPExecution" );
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
      ((Element)v.get(36)).setAttribute("nombre","maeTipoProblTipoSolucFormLayer" );
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
      ((Element)v.get(51)).setAttribute("cod","MaeTipoProblTipoSoluc.legend.label" );
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
      ((Element)v.get(66)).setAttribute("cod","MaeTipoProblTipoSoluc.id.label" );
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
      ((Element)v.get(69)).setAttribute("ontab","ejecutarAccionFoco('maeTipoProblTipoSolucFrm',1, true)" );
      ((Element)v.get(69)).setAttribute("onshtab","ejecutarAccionFoco('maeTipoProblTipoSolucFrm', 1, false)" );
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
      ((Element)v.get(87)).setAttribute("nombre","tipbOidTipoProbTdId" );
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
      ((Element)v.get(91)).setAttribute("nombre","lbltipbOidTipoProb" );
      ((Element)v.get(91)).setAttribute("id","datosTitle" );
      ((Element)v.get(91)).setAttribute("ancho","150" );
      ((Element)v.get(91)).setAttribute("alto","13" );
      ((Element)v.get(91)).setAttribute("cod","MaeTipoProblTipoSoluc.tipbOidTipoProb.label" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:92 / Elemento padre: 88   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(92)).setAttribute("nombre","tipbOidTipoProbWidgetTrId" );
      ((Element)v.get(88)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(93)).setAttribute("align","left" );
      ((Element)v.get(93)).setAttribute("nowrap","true" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(94)).setAttribute("nombre","tipbOidTipoProb" );
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
      ((Element)v.get(94)).setAttribute("ontab","ejecutarAccionFoco('maeTipoProblTipoSolucFrm',2, true);" );
      ((Element)v.get(94)).setAttribute("onshtab","ejecutarAccionFoco('maeTipoProblTipoSolucFrm',2, false);" );
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
      ((Element)v.get(96)).setAttribute("nombre","tipbOidTipoProbGapTdId" );
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
      ((Element)v.get(98)).setAttribute("width","100%" );
      ((Element)v.get(86)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:81   */

      /* Empieza nodo:100 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(100)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(52)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("TD"));
   }

   private void getXML450(Document doc) {
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

      /* Empieza nodo:107 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(107)).setAttribute("nombre","formTr2" );
      ((Element)v.get(52)).appendChild((Element)v.get(107));

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
      ((Element)v.get(113)).setAttribute("nombre","tsocOidTipoSoluTdId" );
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
      ((Element)v.get(117)).setAttribute("nombre","lbltsocOidTipoSolu" );
      ((Element)v.get(117)).setAttribute("id","datosTitle" );
      ((Element)v.get(117)).setAttribute("ancho","150" );
      ((Element)v.get(117)).setAttribute("alto","13" );
      ((Element)v.get(117)).setAttribute("cod","MaeTipoProblTipoSoluc.tsocOidTipoSolu.label" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:118 / Elemento padre: 114   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(118)).setAttribute("nombre","tsocOidTipoSoluWidgetTrId" );
      ((Element)v.get(114)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(119)).setAttribute("align","left" );
      ((Element)v.get(119)).setAttribute("nowrap","true" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(120)).setAttribute("nombre","tsocOidTipoSolu" );
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
   }

   private void getXML540(Document doc) {
      ((Element)v.get(120)).setAttribute("ontab","ejecutarAccionFoco('maeTipoProblTipoSolucFrm',3, true);" );
      ((Element)v.get(120)).setAttribute("onshtab","ejecutarAccionFoco('maeTipoProblTipoSolucFrm',3, false);" );
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
      ((Element)v.get(122)).setAttribute("nombre","tsocOidTipoSoluGapTdId" );
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

      /* Empieza nodo:126 / Elemento padre: 107   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(126)).setAttribute("width","100%" );
      ((Element)v.get(107)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:107   */

      /* Empieza nodo:127 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(127)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(52)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(128)).setAttribute("align","center" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","8" );
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
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:127   */
      /* Termina nodo:52   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:134 / Elemento padre: 45   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(134)).setAttribute("align","center" );
      ((Element)v.get(134)).setAttribute("width","12" );
      ((Element)v.get(45)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","12" );
      ((Element)v.get(135)).setAttribute("height","12" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:45   */

      /* Empieza nodo:136 / Elemento padre: 37   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(136)).setAttribute("nombre","maeTipoProblTipoSolucTrButtons" );
      ((Element)v.get(37)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(137)).setAttribute("align","center" );
      ((Element)v.get(137)).setAttribute("width","12" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","12" );
      ((Element)v.get(138)).setAttribute("height","12" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(136)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(141)).setAttribute("border","0" );
      ((Element)v.get(141)).setAttribute("align","center" );
      ((Element)v.get(141)).setAttribute("cellspacing","0" );
      ((Element)v.get(141)).setAttribute("cellpadding","0" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(143)).setAttribute("class","tablaTitle" );
      ((Element)v.get(143)).setAttribute("nombre","maeTipoProblTipoSolucTdQueryButton" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(144)).setAttribute("nombre","maeTipoProblTipoSolucQueryButton" );
      ((Element)v.get(144)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(144)).setAttribute("estado","false" );
      ((Element)v.get(144)).setAttribute("accion","maeTipoProblTipoSolucFirstPage();" );
      ((Element)v.get(144)).setAttribute("tipo","html" );
      ((Element)v.get(144)).setAttribute("ID","botonContenido" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 142   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(145)).setAttribute("class","tablaTitle" );
      ((Element)v.get(145)).setAttribute("nombre","maeTipoProblTipoSolucTdLovNullSelectionButton" );
      ((Element)v.get(145)).setAttribute("align","left" );
      ((Element)v.get(145)).setAttribute("width","100%" );
      ((Element)v.get(142)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 145   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(147)).setAttribute("nombre","maeTipoProblTipoSolucLovNullButton" );
      ((Element)v.get(147)).setAttribute("ID","botonContenido" );
      ((Element)v.get(147)).setAttribute("tipo","html" );
      ((Element)v.get(147)).setAttribute("accion","maeTipoProblTipoSolucLovNullSelectionAction();" );
      ((Element)v.get(147)).setAttribute("estado","true" );
      ((Element)v.get(147)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(145)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:145   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:148 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(148)).setAttribute("align","center" );
      ((Element)v.get(148)).setAttribute("width","12" );
      ((Element)v.get(136)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","12" );
      ((Element)v.get(149)).setAttribute("height","12" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:136   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:150 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(150)).setAttribute("nombre","maeTipoProblTipoSolucListLayer" );
      ((Element)v.get(150)).setAttribute("alto","310" );
      ((Element)v.get(150)).setAttribute("ancho","99%" );
      ((Element)v.get(150)).setAttribute("colorf","" );
      ((Element)v.get(150)).setAttribute("borde","0" );
      ((Element)v.get(150)).setAttribute("imagenf","" );
      ((Element)v.get(150)).setAttribute("repeat","" );
      ((Element)v.get(150)).setAttribute("padding","" );
      ((Element)v.get(150)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(150)).setAttribute("contravsb","" );
      ((Element)v.get(150)).setAttribute("x","3" );
      ((Element)v.get(150)).setAttribute("y","" );
      ((Element)v.get(150)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(151)).setAttribute("nombre","maeTipoProblTipoSolucList" );
      ((Element)v.get(151)).setAttribute("ancho","680" );
      ((Element)v.get(151)).setAttribute("alto","275" );
      ((Element)v.get(151)).setAttribute("x","12" );
      ((Element)v.get(151)).setAttribute("y","0" );
      ((Element)v.get(151)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(151)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(152)).setAttribute("precarga","S" );
      ((Element)v.get(152)).setAttribute("conROver","S" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(153)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(153)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(153)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(153)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 152   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(154)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(154)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(154)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(154)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(152)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:152   */

      /* Empieza nodo:155 / Elemento padre: 151   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(151)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(156)).setAttribute("borde","1" );
      ((Element)v.get(156)).setAttribute("horizDatos","1" );
      ((Element)v.get(156)).setAttribute("horizCabecera","1" );
      ((Element)v.get(156)).setAttribute("vertical","1" );
      ((Element)v.get(156)).setAttribute("horizTitulo","1" );
      ((Element)v.get(156)).setAttribute("horizBase","1" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 155   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(157)).setAttribute("borde","#999999" );
      ((Element)v.get(157)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(157)).setAttribute("vertDatos","#FFFFFF" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(157)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(157)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(157)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(157)).setAttribute("horizBase","#999999" );
      ((Element)v.get(155)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:155   */

      /* Empieza nodo:158 / Elemento padre: 151   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(158)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(158)).setAttribute("alto","22" );
      ((Element)v.get(158)).setAttribute("imgFondo","" );
      ((Element)v.get(158)).setAttribute("cod","00135" );
      ((Element)v.get(158)).setAttribute("ID","datosTitle" );
      ((Element)v.get(151)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 151   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(159)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(159)).setAttribute("alto","22" );
      ((Element)v.get(159)).setAttribute("imgFondo","" );
      ((Element)v.get(151)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 151   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(160)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(160)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(160)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(160)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(160)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(151)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("ancho","100" );
      ((Element)v.get(161)).setAttribute("minimizable","S" );
      ((Element)v.get(161)).setAttribute("minimizada","N" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("ancho","100" );
      ((Element)v.get(162)).setAttribute("minimizable","S" );
      ((Element)v.get(162)).setAttribute("minimizada","N" );
      ((Element)v.get(160)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:160   */

      /* Empieza nodo:163 / Elemento padre: 151   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(163)).setAttribute("height","20" );
      ((Element)v.get(163)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(163)).setAttribute("imgFondo","" );
      ((Element)v.get(163)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(151)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("colFondo","" );
      ((Element)v.get(164)).setAttribute("ID","EstCab" );
      ((Element)v.get(164)).setAttribute("cod","MaeTipoProblTipoSoluc.tipbOidTipoProb.label" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("colFondo","" );
      ((Element)v.get(165)).setAttribute("ID","EstCab" );
      ((Element)v.get(165)).setAttribute("cod","MaeTipoProblTipoSoluc.tsocOidTipoSolu.label" );
      ((Element)v.get(163)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:163   */

      /* Empieza nodo:166 / Elemento padre: 151   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(166)).setAttribute("alto","22" );
      ((Element)v.get(166)).setAttribute("accion","" );
      ((Element)v.get(166)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(166)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(166)).setAttribute("maxSel","1" );
      ((Element)v.get(166)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(166)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(166)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(166)).setAttribute("onLoad","" );
      ((Element)v.get(166)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(151)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("tipo","texto" );
      ((Element)v.get(167)).setAttribute("ID","EstDat" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("tipo","texto" );
      ((Element)v.get(168)).setAttribute("ID","EstDat2" );
      ((Element)v.get(166)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:166   */

      /* Empieza nodo:169 / Elemento padre: 151   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(151)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:170 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(170)).setAttribute("nombre","maeTipoProblTipoSolucListButtonsLayer" );
      ((Element)v.get(170)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(170)).setAttribute("alto","30" );
      ((Element)v.get(170)).setAttribute("ancho","98%" );
      ((Element)v.get(170)).setAttribute("borde","n" );
      ((Element)v.get(170)).setAttribute("imagenf","" );
      ((Element)v.get(170)).setAttribute("repeat","" );
      ((Element)v.get(170)).setAttribute("padding","0" );
      ((Element)v.get(170)).setAttribute("contravsb","" );
      ((Element)v.get(170)).setAttribute("x","16" );
      ((Element)v.get(170)).setAttribute("y","" );
      ((Element)v.get(170)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(171)).setAttribute("nombre","toolbarSeparatorLayer" );
      ((Element)v.get(171)).setAttribute("visibilidad","inherit" );
      ((Element)v.get(171)).setAttribute("alto","23" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(171)).setAttribute("ancho","1" );
      ((Element)v.get(171)).setAttribute("borde","1" );
      ((Element)v.get(171)).setAttribute("imagenf","" );
      ((Element)v.get(171)).setAttribute("repeat","" );
      ((Element)v.get(171)).setAttribute("padding","0" );
      ((Element)v.get(171)).setAttribute("contravsb","" );
      ((Element)v.get(171)).setAttribute("x","56" );
      ((Element)v.get(171)).setAttribute("y","0" );
      ((Element)v.get(171)).setAttribute("zindex","" );
      ((Element)v.get(171)).setAttribute("colborde","#999999" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 170   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(172)).setAttribute("width","100%" );
      ((Element)v.get(172)).setAttribute("border","0" );
      ((Element)v.get(172)).setAttribute("cellspacing","1" );
      ((Element)v.get(172)).setAttribute("cellpadding","0" );
      ((Element)v.get(170)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("height","22" );
      ((Element)v.get(174)).setAttribute("width","5" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(172)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(176)).setAttribute("nombre","maeTipoProblTipoSolucPaginationButtonBar" );
      ((Element)v.get(176)).setAttribute("tipo","H" );
      ((Element)v.get(176)).setAttribute("x","0" );
      ((Element)v.get(176)).setAttribute("y","0" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(177)).setAttribute("nombre","maeTipoProblTipoSolucFirstPageButton" );
      ((Element)v.get(177)).setAttribute("funcion","maeTipoProblTipoSolucFirstPage();" );
      ((Element)v.get(177)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(177)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(177)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(177)).setAttribute("estado","inactivo" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 176   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(178)).setAttribute("nombre","maeTipoProblTipoSolucFirstPageButtonGapTd" );
      ((Element)v.get(176)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(179)).setAttribute("width","5" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 176   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(180)).setAttribute("nombre","maeTipoProblTipoSolucPreviousPageButton" );
      ((Element)v.get(180)).setAttribute("funcion","maeTipoProblTipoSolucPreviousPage();" );
      ((Element)v.get(180)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(180)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(180)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(180)).setAttribute("estado","inactivo" );
      ((Element)v.get(176)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 176   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(181)).setAttribute("nombre","maeTipoProblTipoSolucPreviousPageButtonGapTd" );
      ((Element)v.get(176)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(182)).setAttribute("width","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 176   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(183)).setAttribute("nombre","maeTipoProblTipoSolucNextPageButton" );
      ((Element)v.get(183)).setAttribute("funcion","maeTipoProblTipoSolucNextPage();" );
      ((Element)v.get(183)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(183)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(183)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(183)).setAttribute("estado","inactivo" );
      ((Element)v.get(176)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:184 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(172)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("height","22" );
      ((Element)v.get(185)).setAttribute("width","19" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(186)).setAttribute("class","tablaTitle" );
      ((Element)v.get(186)).setAttribute("nombre","maeTipoProblTipoSolucUpdateButtonTd" );
      ((Element)v.get(172)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(187)).setAttribute("nombre","maeTipoProblTipoSolucUpdateButton" );
      ((Element)v.get(187)).setAttribute("ID","botonContenido" );
      ((Element)v.get(187)).setAttribute("tipo","html" );
      ((Element)v.get(187)).setAttribute("accion","maeTipoProblTipoSolucUpdateSelection();" );
      ((Element)v.get(187)).setAttribute("estado","false" );
      ((Element)v.get(187)).setAttribute("cod","MMGGlobal.updateButton.label" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(188)).setAttribute("nombre","maeTipoProblTipoSolucUpdateButtonGapTd" );
      ((Element)v.get(172)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(189)).setAttribute("width","10" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(190)).setAttribute("class","tablaTitle" );
      ((Element)v.get(190)).setAttribute("nombre","maeTipoProblTipoSolucViewForRemoveButtonTd" );
      ((Element)v.get(172)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(191)).setAttribute("nombre","maeTipoProblTipoSolucViewForRemoveButton" );
      ((Element)v.get(191)).setAttribute("ID","botonContenido" );
      ((Element)v.get(191)).setAttribute("tipo","html" );
      ((Element)v.get(191)).setAttribute("accion","maeTipoProblTipoSolucViewSelection();" );
      ((Element)v.get(191)).setAttribute("estado","false" );
      ((Element)v.get(191)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(192)).setAttribute("nombre","maeTipoProblTipoSolucViewForRemoveButtonGapTd" );
      ((Element)v.get(172)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(193)).setAttribute("width","10" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(194)).setAttribute("class","tablaTitle" );
      ((Element)v.get(194)).setAttribute("nombre","maeTipoProblTipoSolucLovSelectButtonTd" );
      ((Element)v.get(172)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(195)).setAttribute("nombre","maeTipoProblTipoSolucLovSelectButton" );
      ((Element)v.get(195)).setAttribute("ID","botonContenido" );
      ((Element)v.get(195)).setAttribute("tipo","html" );
      ((Element)v.get(195)).setAttribute("accion","maeTipoProblTipoSolucLovSelectionAction();" );
      ((Element)v.get(195)).setAttribute("estado","true" );
      ((Element)v.get(195)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(196)).setAttribute("nombre","maeTipoProblTipoSolucLovSelectButtonGapTd" );
      ((Element)v.get(172)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(197)).setAttribute("width","10" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(198)).setAttribute("class","tablaTitle" );
      ((Element)v.get(198)).setAttribute("nombre","maeTipoProblTipoSolucViewButtonTd" );
      ((Element)v.get(172)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(199)).setAttribute("nombre","maeTipoProblTipoSolucViewButton" );
      ((Element)v.get(199)).setAttribute("ID","botonContenido" );
      ((Element)v.get(199)).setAttribute("tipo","html" );
      ((Element)v.get(199)).setAttribute("accion","maeTipoProblTipoSolucViewSelection();" );
      ((Element)v.get(199)).setAttribute("estado","false" );
      ((Element)v.get(199)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(200)).setAttribute("nombre","maeTipoProblTipoSolucViewButtonGapTd" );
      ((Element)v.get(172)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(201)).setAttribute("width","10" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(202)).setAttribute("width","100%" );
      ((Element)v.get(172)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:172   */
      /* Termina nodo:170   */
      /* Termina nodo:4   */


   }

}

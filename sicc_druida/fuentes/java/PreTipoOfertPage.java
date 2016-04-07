
import org.w3c.dom.*;
import java.util.ArrayList;

public class PreTipoOfertPage  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","PreTipoOfertPage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","preTipoOfertInitComponents()" );
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
      ((Element)v.get(4)).setAttribute("src","pretipoofert.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","preTipoOfertFrm" );
      ((Element)v.get(5)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(6)).setAttribute("valor","PreTipoOfertLPExecution" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","ON" );
      ((Element)v.get(7)).setAttribute("valor","PreTipoOfertLPExecution" );
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
      ((Element)v.get(37)).setAttribute("nombre","preTipoOfertFormLayer" );
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
      ((Element)v.get(52)).setAttribute("cod","PreTipoOfert.legend.label" );
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
      ((Element)v.get(67)).setAttribute("cod","PreTipoOfert.id.label" );
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
      ((Element)v.get(70)).setAttribute("ontab","ejecutarAccionFoco('preTipoOfertFrm',1, true)" );
      ((Element)v.get(70)).setAttribute("onshtab","ejecutarAccionFoco('preTipoOfertFrm', 1, false)" );
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
      ((Element)v.get(88)).setAttribute("nombre","canaOidCanaTdId" );
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
      ((Element)v.get(92)).setAttribute("nombre","lblcanaOidCana" );
      ((Element)v.get(92)).setAttribute("id","datosTitle" );
      ((Element)v.get(92)).setAttribute("ancho","150" );
      ((Element)v.get(92)).setAttribute("alto","13" );
      ((Element)v.get(92)).setAttribute("cod","PreTipoOfert.canaOidCana.label" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:93 / Elemento padre: 89   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(93)).setAttribute("nombre","canaOidCanaWidgetTrId" );
      ((Element)v.get(89)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(94)).setAttribute("align","left" );
      ((Element)v.get(94)).setAttribute("nowrap","true" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(95)).setAttribute("nombre","canaOidCana" );
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
      ((Element)v.get(95)).setAttribute("ontab","ejecutarAccionFoco('preTipoOfertFrm',2, true);" );
      ((Element)v.get(95)).setAttribute("onshtab","ejecutarAccionFoco('preTipoOfertFrm',2, false);" );
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
      ((Element)v.get(97)).setAttribute("nombre","canaOidCanaGapTdId" );
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
      ((Element)v.get(99)).setAttribute("nombre","codTipoOferTdId" );
      ((Element)v.get(87)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(100)).setAttribute("width","100%" );
      ((Element)v.get(100)).setAttribute("border","0" );
      ((Element)v.get(100)).setAttribute("cellspacing","0" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(100)).setAttribute("cellpadding","0" );
      ((Element)v.get(100)).setAttribute("align","left" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(102)).setAttribute("valign","top" );
      ((Element)v.get(102)).setAttribute("height","13" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(103)).setAttribute("nombre","lblCodTipoOfer" );
      ((Element)v.get(103)).setAttribute("alto","13" );
      ((Element)v.get(103)).setAttribute("filas","1" );
      ((Element)v.get(103)).setAttribute("id","datosTitle" );
      ((Element)v.get(103)).setAttribute("cod","PreTipoOfert.codTipoOfer.label" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:104 / Elemento padre: 100   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(104)).setAttribute("nombre","codTipoOferWidgetTrId" );
      ((Element)v.get(100)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(105)).setAttribute("align","left" );
      ((Element)v.get(105)).setAttribute("nowrap","true" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(106)).setAttribute("nombre","codTipoOfer" );
      ((Element)v.get(106)).setAttribute("id","datosCampos" );
      ((Element)v.get(106)).setAttribute("trim","S" );
      ((Element)v.get(106)).setAttribute("max","4" );
      ((Element)v.get(106)).setAttribute("onchange","" );
      ((Element)v.get(106)).setAttribute("req","N" );
      ((Element)v.get(106)).setAttribute("size","4" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(106)).setAttribute("validacion","" );
      ((Element)v.get(106)).setAttribute("disabled","" );
      ((Element)v.get(106)).setAttribute("onblur","" );
      ((Element)v.get(106)).setAttribute("ontab","ejecutarAccionFoco('preTipoOfertFrm',3, true)" );
      ((Element)v.get(106)).setAttribute("onshtab","ejecutarAccionFoco('preTipoOfertFrm', 3, false)" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:107 / Elemento padre: 87   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(107)).setAttribute("nombre","codTipoOferGapTdId" );
      ((Element)v.get(107)).setAttribute("nowrap","true" );
      ((Element)v.get(107)).setAttribute("class","datosCampos" );
      ((Element)v.get(87)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","25" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 87   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(109)).setAttribute("nombre","DescripcionTdId" );
      ((Element)v.get(87)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(110)).setAttribute("width","100%" );
      ((Element)v.get(110)).setAttribute("border","0" );
      ((Element)v.get(110)).setAttribute("cellspacing","0" );
      ((Element)v.get(110)).setAttribute("cellpadding","0" );
      ((Element)v.get(110)).setAttribute("align","left" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(112)).setAttribute("valign","top" );
      ((Element)v.get(112)).setAttribute("height","13" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(113)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(113)).setAttribute("alto","13" );
      ((Element)v.get(113)).setAttribute("filas","1" );
      ((Element)v.get(113)).setAttribute("id","datosTitle" );
      ((Element)v.get(113)).setAttribute("cod","PreTipoOfert.Descripcion.label" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(114)).setAttribute("nombre","DescripcionTdLocalizationButtonGapHeader" );
      ((Element)v.get(114)).setAttribute("colspan","2" );
      ((Element)v.get(111)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:111   */

      /* Empieza nodo:115 / Elemento padre: 110   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(115)).setAttribute("nombre","DescripcionWidgetTrId" );
      ((Element)v.get(110)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(116)).setAttribute("align","left" );
      ((Element)v.get(116)).setAttribute("nowrap","true" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(117)).setAttribute("nombre","Descripcion" );
      ((Element)v.get(117)).setAttribute("id","datosCampos" );
      ((Element)v.get(117)).setAttribute("trim","S" );
      ((Element)v.get(117)).setAttribute("max","30" );
      ((Element)v.get(117)).setAttribute("onchange","" );
      ((Element)v.get(117)).setAttribute("req","N" );
      ((Element)v.get(117)).setAttribute("size","30" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(117)).setAttribute("valor","" );
      ((Element)v.get(117)).setAttribute("validacion","" );
      ((Element)v.get(117)).setAttribute("disabled","" );
      ((Element)v.get(117)).setAttribute("onblur","" );
      ((Element)v.get(117)).setAttribute("ontab","ejecutarAccionFoco('preTipoOfertFrm',4, true)" );
      ((Element)v.get(117)).setAttribute("onshtab","ejecutarAccionFoco('preTipoOfertFrm', 4, false)" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 115   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(115)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","8" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 115   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(120)).setAttribute("nombre","DescripcionTdLocalizationButton" );
      ((Element)v.get(120)).setAttribute("align","left" );
      ((Element)v.get(120)).setAttribute("nowrap","true" );
      ((Element)v.get(120)).setAttribute("valign","bottom" );
      ((Element)v.get(115)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("A"));
      ((Element)v.get(121)).setAttribute("id","DescripcionLocalizationButton" );
      ((Element)v.get(121)).setAttribute("href","javascript:openLocalizationDialog('preTipoOfertFrm', 'Descripcion', 1);" );
      ((Element)v.get(121)).setAttribute("onKeyDown","javascript:mmgImgEventDispatcherForFocus(event, 'ejecutarAccionFoco(\"preTipoOfertFrm\",4, true)', 'ejecutarAccionFoco(\"preTipoOfertFrm\",4, false)')" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("nombre","DescripcionLocalizationButton" );
      ((Element)v.get(122)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(122)).setAttribute("border","0" );
      ((Element)v.get(122)).setAttribute("width","21" );
      ((Element)v.get(122)).setAttribute("height","15" );
      ((Element)v.get(122)).setAttribute("class","main" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:115   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:123 / Elemento padre: 87   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(123)).setAttribute("nombre","DescripcionGapTdId" );
      ((Element)v.get(123)).setAttribute("nowrap","true" );
      ((Element)v.get(123)).setAttribute("class","datosCampos" );
      ((Element)v.get(87)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","25" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 87   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(125)).setAttribute("width","100%" );
      ((Element)v.get(87)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:82   */

      /* Empieza nodo:127 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(127)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(53)).appendChild((Element)v.get(127));

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

      /* Empieza nodo:134 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(134)).setAttribute("nombre","formTr2" );
      ((Element)v.get(53)).appendChild((Element)v.get(134));

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
   }

   private void getXML630(Document doc) {
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
      ((Element)v.get(140)).setAttribute("nombre","indComiTdId" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
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
      ((Element)v.get(144)).setAttribute("nombre","lblIndComi" );
      ((Element)v.get(144)).setAttribute("alto","13" );
      ((Element)v.get(144)).setAttribute("filas","1" );
      ((Element)v.get(144)).setAttribute("id","datosTitle" );
      ((Element)v.get(144)).setAttribute("cod","PreTipoOfert.indComi.label" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:145 / Elemento padre: 141   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(145)).setAttribute("nombre","indComiWidgetTrId" );
      ((Element)v.get(141)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(146)).setAttribute("align","left" );
      ((Element)v.get(146)).setAttribute("nowrap","true" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(147)).setAttribute("nombre","indComi" );
      ((Element)v.get(147)).setAttribute("check","N" );
      ((Element)v.get(147)).setAttribute("id","datosCampos" );
      ((Element)v.get(147)).setAttribute("onclick","" );
      ((Element)v.get(147)).setAttribute("onfocus","" );
      ((Element)v.get(147)).setAttribute("disabled","" );
      ((Element)v.get(147)).setAttribute("ontab","ejecutarAccionFoco('preTipoOfertFrm',5, true)" );
      ((Element)v.get(147)).setAttribute("onshtab","ejecutarAccionFoco('preTipoOfertFrm',5, false)" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:148 / Elemento padre: 139   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(148)).setAttribute("nombre","indComiGapTdId" );
      ((Element)v.get(148)).setAttribute("nowrap","true" );
      ((Element)v.get(148)).setAttribute("class","datosCampos" );
      ((Element)v.get(139)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","25" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 139   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(150)).setAttribute("nombre","indPuntTdId" );
      ((Element)v.get(139)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(151)).setAttribute("width","100%" );
      ((Element)v.get(151)).setAttribute("border","0" );
      ((Element)v.get(151)).setAttribute("cellspacing","0" );
      ((Element)v.get(151)).setAttribute("cellpadding","0" );
      ((Element)v.get(151)).setAttribute("align","left" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(153)).setAttribute("valign","top" );
      ((Element)v.get(153)).setAttribute("height","13" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(154)).setAttribute("nombre","lblIndPunt" );
      ((Element)v.get(154)).setAttribute("alto","13" );
      ((Element)v.get(154)).setAttribute("filas","1" );
      ((Element)v.get(154)).setAttribute("id","datosTitle" );
      ((Element)v.get(154)).setAttribute("cod","PreTipoOfert.indPunt.label" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:155 / Elemento padre: 151   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(155)).setAttribute("nombre","indPuntWidgetTrId" );
      ((Element)v.get(151)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(156)).setAttribute("align","left" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(156)).setAttribute("nowrap","true" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(157)).setAttribute("nombre","indPunt" );
      ((Element)v.get(157)).setAttribute("check","N" );
      ((Element)v.get(157)).setAttribute("id","datosCampos" );
      ((Element)v.get(157)).setAttribute("onclick","" );
      ((Element)v.get(157)).setAttribute("onfocus","" );
      ((Element)v.get(157)).setAttribute("disabled","" );
      ((Element)v.get(157)).setAttribute("ontab","ejecutarAccionFoco('preTipoOfertFrm',6, true)" );
      ((Element)v.get(157)).setAttribute("onshtab","ejecutarAccionFoco('preTipoOfertFrm',6, false)" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:158 / Elemento padre: 139   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(158)).setAttribute("nombre","indPuntGapTdId" );
      ((Element)v.get(158)).setAttribute("nowrap","true" );
      ((Element)v.get(158)).setAttribute("class","datosCampos" );
      ((Element)v.get(139)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","25" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 139   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(160)).setAttribute("nombre","indEstaTdId" );
      ((Element)v.get(139)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(161)).setAttribute("width","100%" );
      ((Element)v.get(161)).setAttribute("border","0" );
      ((Element)v.get(161)).setAttribute("cellspacing","0" );
      ((Element)v.get(161)).setAttribute("cellpadding","0" );
      ((Element)v.get(161)).setAttribute("align","left" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(163)).setAttribute("valign","top" );
      ((Element)v.get(163)).setAttribute("height","13" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(164)).setAttribute("nombre","lblIndEsta" );
      ((Element)v.get(164)).setAttribute("alto","13" );
      ((Element)v.get(164)).setAttribute("filas","1" );
      ((Element)v.get(164)).setAttribute("id","datosTitle" );
      ((Element)v.get(164)).setAttribute("cod","PreTipoOfert.indEsta.label" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:165 / Elemento padre: 161   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(165)).setAttribute("nombre","indEstaWidgetTrId" );
      ((Element)v.get(161)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(166)).setAttribute("align","left" );
      ((Element)v.get(166)).setAttribute("nowrap","true" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(167)).setAttribute("nombre","indEsta" );
      ((Element)v.get(167)).setAttribute("check","N" );
      ((Element)v.get(167)).setAttribute("id","datosCampos" );
      ((Element)v.get(167)).setAttribute("onclick","" );
      ((Element)v.get(167)).setAttribute("onfocus","" );
      ((Element)v.get(167)).setAttribute("disabled","" );
      ((Element)v.get(167)).setAttribute("ontab","ejecutarAccionFoco('preTipoOfertFrm',7, true)" );
      ((Element)v.get(167)).setAttribute("onshtab","ejecutarAccionFoco('preTipoOfertFrm',7, false)" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:168 / Elemento padre: 139   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(168)).setAttribute("nombre","indEstaGapTdId" );
      ((Element)v.get(168)).setAttribute("nowrap","true" );
      ((Element)v.get(168)).setAttribute("class","datosCampos" );
      ((Element)v.get(139)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","25" );
      ((Element)v.get(169)).setAttribute("height","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 139   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(170)).setAttribute("width","100%" );
      ((Element)v.get(139)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:134   */

      /* Empieza nodo:172 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(172)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(53)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(173)).setAttribute("align","center" );
      ((Element)v.get(173)).setAttribute("width","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","12" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 172   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(172)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(177)).setAttribute("align","center" );
      ((Element)v.get(177)).setAttribute("width","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","12" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:172   */

      /* Empieza nodo:179 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(179)).setAttribute("nombre","formTr3" );
      ((Element)v.get(53)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(180)).setAttribute("align","center" );
      ((Element)v.get(180)).setAttribute("width","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","12" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 179   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(182)).setAttribute("width","100%" );
      ((Element)v.get(179)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(183)).setAttribute("width","100%" );
      ((Element)v.get(183)).setAttribute("border","0" );
      ((Element)v.get(183)).setAttribute("cellspacing","0" );
      ((Element)v.get(183)).setAttribute("cellpadding","0" );
      ((Element)v.get(183)).setAttribute("align","left" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(184)).setAttribute("align","left" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(185)).setAttribute("nombre","indMontMiniTdId" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(186)).setAttribute("width","100%" );
      ((Element)v.get(186)).setAttribute("border","0" );
      ((Element)v.get(186)).setAttribute("cellspacing","0" );
      ((Element)v.get(186)).setAttribute("cellpadding","0" );
      ((Element)v.get(186)).setAttribute("align","left" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(188)).setAttribute("valign","top" );
      ((Element)v.get(188)).setAttribute("height","13" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(189)).setAttribute("nombre","lblIndMontMini" );
      ((Element)v.get(189)).setAttribute("alto","13" );
      ((Element)v.get(189)).setAttribute("filas","1" );
      ((Element)v.get(189)).setAttribute("id","datosTitle" );
      ((Element)v.get(189)).setAttribute("cod","PreTipoOfert.indMontMini.label" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:190 / Elemento padre: 186   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(190)).setAttribute("nombre","indMontMiniWidgetTrId" );
      ((Element)v.get(186)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(191)).setAttribute("align","left" );
      ((Element)v.get(191)).setAttribute("nowrap","true" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(192)).setAttribute("nombre","indMontMini" );
      ((Element)v.get(192)).setAttribute("check","N" );
      ((Element)v.get(192)).setAttribute("id","datosCampos" );
      ((Element)v.get(192)).setAttribute("onclick","" );
      ((Element)v.get(192)).setAttribute("onfocus","" );
      ((Element)v.get(192)).setAttribute("disabled","" );
      ((Element)v.get(192)).setAttribute("ontab","ejecutarAccionFoco('preTipoOfertFrm',8, true)" );
      ((Element)v.get(192)).setAttribute("onshtab","ejecutarAccionFoco('preTipoOfertFrm',8, false)" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:193 / Elemento padre: 184   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(193)).setAttribute("nombre","indMontMiniGapTdId" );
      ((Element)v.get(193)).setAttribute("nowrap","true" );
      ((Element)v.get(193)).setAttribute("class","datosCampos" );
      ((Element)v.get(184)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","25" );
      ((Element)v.get(194)).setAttribute("height","8" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 184   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(195)).setAttribute("nombre","indAporMontEscaTdId" );
      ((Element)v.get(184)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(196)).setAttribute("width","100%" );
      ((Element)v.get(196)).setAttribute("border","0" );
      ((Element)v.get(196)).setAttribute("cellspacing","0" );
      ((Element)v.get(196)).setAttribute("cellpadding","0" );
      ((Element)v.get(196)).setAttribute("align","left" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(198)).setAttribute("valign","top" );
      ((Element)v.get(198)).setAttribute("height","13" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(199)).setAttribute("nombre","lblIndAporMontEsca" );
      ((Element)v.get(199)).setAttribute("alto","13" );
      ((Element)v.get(199)).setAttribute("filas","1" );
      ((Element)v.get(199)).setAttribute("id","datosTitle" );
      ((Element)v.get(199)).setAttribute("cod","PreTipoOfert.indAporMontEsca.label" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:200 / Elemento padre: 196   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(200)).setAttribute("nombre","indAporMontEscaWidgetTrId" );
      ((Element)v.get(196)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(201)).setAttribute("align","left" );
      ((Element)v.get(201)).setAttribute("nowrap","true" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(202)).setAttribute("nombre","indAporMontEsca" );
      ((Element)v.get(202)).setAttribute("check","N" );
      ((Element)v.get(202)).setAttribute("id","datosCampos" );
      ((Element)v.get(202)).setAttribute("onclick","" );
      ((Element)v.get(202)).setAttribute("onfocus","" );
      ((Element)v.get(202)).setAttribute("disabled","" );
      ((Element)v.get(202)).setAttribute("ontab","ejecutarAccionFoco('preTipoOfertFrm',9, true)" );
      ((Element)v.get(202)).setAttribute("onshtab","ejecutarAccionFoco('preTipoOfertFrm',9, false)" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:203 / Elemento padre: 184   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(203)).setAttribute("nombre","indAporMontEscaGapTdId" );
      ((Element)v.get(203)).setAttribute("nowrap","true" );
      ((Element)v.get(203)).setAttribute("class","datosCampos" );
      ((Element)v.get(184)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","25" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 184   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(205)).setAttribute("nombre","indGratTdId" );
      ((Element)v.get(184)).appendChild((Element)v.get(205));

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
      ((Element)v.get(209)).setAttribute("nombre","lblIndGrat" );
      ((Element)v.get(209)).setAttribute("alto","13" );
      ((Element)v.get(209)).setAttribute("filas","1" );
      ((Element)v.get(209)).setAttribute("id","datosTitle" );
      ((Element)v.get(209)).setAttribute("cod","PreTipoOfert.indGrat.label" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:210 / Elemento padre: 206   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(210)).setAttribute("nombre","indGratWidgetTrId" );
      ((Element)v.get(206)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(211)).setAttribute("align","left" );
      ((Element)v.get(211)).setAttribute("nowrap","true" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(212)).setAttribute("nombre","indGrat" );
      ((Element)v.get(212)).setAttribute("check","N" );
      ((Element)v.get(212)).setAttribute("id","datosCampos" );
      ((Element)v.get(212)).setAttribute("onclick","" );
      ((Element)v.get(212)).setAttribute("onfocus","" );
      ((Element)v.get(212)).setAttribute("disabled","" );
      ((Element)v.get(212)).setAttribute("ontab","ejecutarAccionFoco('preTipoOfertFrm',10, true)" );
      ((Element)v.get(212)).setAttribute("onshtab","ejecutarAccionFoco('preTipoOfertFrm',10, false)" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:213 / Elemento padre: 184   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(213)).setAttribute("nombre","indGratGapTdId" );
      ((Element)v.get(213)).setAttribute("nowrap","true" );
      ((Element)v.get(213)).setAttribute("class","datosCampos" );
      ((Element)v.get(184)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","25" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 184   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(215)).setAttribute("width","100%" );
      ((Element)v.get(184)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:217 / Elemento padre: 179   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(217)).setAttribute("width","100%" );
      ((Element)v.get(179)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:179   */

      /* Empieza nodo:218 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(218)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(53)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(219)).setAttribute("align","center" );
      ((Element)v.get(219)).setAttribute("width","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","8" );
      ((Element)v.get(220)).setAttribute("height","8" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 218   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(218)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","8" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 218   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(223)).setAttribute("align","center" );
      ((Element)v.get(223)).setAttribute("width","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","8" );
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:218   */
      /* Termina nodo:53   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:225 / Elemento padre: 46   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(225)).setAttribute("align","center" );
      ((Element)v.get(225)).setAttribute("width","12" );
      ((Element)v.get(46)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","12" );
      ((Element)v.get(226)).setAttribute("height","12" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:46   */

      /* Empieza nodo:227 / Elemento padre: 38   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(227)).setAttribute("nombre","preTipoOfertTrButtons" );
      ((Element)v.get(38)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(228)).setAttribute("align","center" );
      ((Element)v.get(228)).setAttribute("width","12" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","12" );
      ((Element)v.get(229)).setAttribute("height","12" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 227   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(227)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(232)).setAttribute("width","100%" );
      ((Element)v.get(232)).setAttribute("border","0" );
      ((Element)v.get(232)).setAttribute("align","center" );
      ((Element)v.get(232)).setAttribute("cellspacing","0" );
      ((Element)v.get(232)).setAttribute("cellpadding","0" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(234)).setAttribute("class","tablaTitle" );
      ((Element)v.get(234)).setAttribute("nombre","preTipoOfertTdQueryButton" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(235)).setAttribute("nombre","preTipoOfertQueryButton" );
      ((Element)v.get(235)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(235)).setAttribute("estado","false" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(235)).setAttribute("accion","preTipoOfertFirstPage();" );
      ((Element)v.get(235)).setAttribute("tipo","html" );
      ((Element)v.get(235)).setAttribute("ID","botonContenido" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 233   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(236)).setAttribute("class","tablaTitle" );
      ((Element)v.get(236)).setAttribute("nombre","preTipoOfertTdLovNullSelectionButton" );
      ((Element)v.get(236)).setAttribute("align","left" );
      ((Element)v.get(236)).setAttribute("width","100%" );
      ((Element)v.get(233)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("height","8" );
      ((Element)v.get(237)).setAttribute("width","8" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 236   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(238)).setAttribute("nombre","preTipoOfertLovNullButton" );
      ((Element)v.get(238)).setAttribute("ID","botonContenido" );
      ((Element)v.get(238)).setAttribute("tipo","html" );
      ((Element)v.get(238)).setAttribute("accion","preTipoOfertLovNullSelectionAction();" );
      ((Element)v.get(238)).setAttribute("estado","true" );
      ((Element)v.get(238)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(236)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:236   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:239 / Elemento padre: 227   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(239)).setAttribute("align","center" );
      ((Element)v.get(239)).setAttribute("width","12" );
      ((Element)v.get(227)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","12" );
      ((Element)v.get(240)).setAttribute("height","12" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:227   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:241 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(241)).setAttribute("nombre","preTipoOfertListLayer" );
      ((Element)v.get(241)).setAttribute("alto","310" );
      ((Element)v.get(241)).setAttribute("ancho","99%" );
      ((Element)v.get(241)).setAttribute("colorf","" );
      ((Element)v.get(241)).setAttribute("borde","0" );
      ((Element)v.get(241)).setAttribute("imagenf","" );
      ((Element)v.get(241)).setAttribute("repeat","" );
      ((Element)v.get(241)).setAttribute("padding","" );
      ((Element)v.get(241)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(241)).setAttribute("contravsb","" );
      ((Element)v.get(241)).setAttribute("x","3" );
      ((Element)v.get(241)).setAttribute("y","" );
      ((Element)v.get(241)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(242)).setAttribute("nombre","preTipoOfertList" );
      ((Element)v.get(242)).setAttribute("ancho","680" );
      ((Element)v.get(242)).setAttribute("alto","275" );
      ((Element)v.get(242)).setAttribute("x","12" );
      ((Element)v.get(242)).setAttribute("y","0" );
      ((Element)v.get(242)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(242)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(243)).setAttribute("precarga","S" );
      ((Element)v.get(243)).setAttribute("conROver","S" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(244)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(244)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(244)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(244)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 243   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(245)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(245)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(245)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(245)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(243)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:243   */

      /* Empieza nodo:246 / Elemento padre: 242   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(242)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(247)).setAttribute("borde","1" );
      ((Element)v.get(247)).setAttribute("horizDatos","1" );
      ((Element)v.get(247)).setAttribute("horizCabecera","1" );
      ((Element)v.get(247)).setAttribute("vertical","1" );
      ((Element)v.get(247)).setAttribute("horizTitulo","1" );
      ((Element)v.get(247)).setAttribute("horizBase","1" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 246   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(248)).setAttribute("borde","#999999" );
      ((Element)v.get(248)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(248)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(248)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(248)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(248)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(248)).setAttribute("horizBase","#999999" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(246)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:246   */

      /* Empieza nodo:249 / Elemento padre: 242   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(249)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(249)).setAttribute("alto","22" );
      ((Element)v.get(249)).setAttribute("imgFondo","" );
      ((Element)v.get(249)).setAttribute("cod","00135" );
      ((Element)v.get(249)).setAttribute("ID","datosTitle" );
      ((Element)v.get(242)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 242   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(250)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(250)).setAttribute("alto","22" );
      ((Element)v.get(250)).setAttribute("imgFondo","" );
      ((Element)v.get(242)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 242   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(251)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(251)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(251)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(251)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(251)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(242)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("ancho","100" );
      ((Element)v.get(252)).setAttribute("minimizable","S" );
      ((Element)v.get(252)).setAttribute("minimizada","N" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(253)).setAttribute("ancho","100" );
      ((Element)v.get(253)).setAttribute("minimizable","S" );
      ((Element)v.get(253)).setAttribute("minimizada","N" );
      ((Element)v.get(251)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(254)).setAttribute("ancho","100" );
      ((Element)v.get(254)).setAttribute("minimizable","S" );
      ((Element)v.get(254)).setAttribute("minimizada","N" );
      ((Element)v.get(251)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("ancho","100" );
      ((Element)v.get(255)).setAttribute("minimizable","S" );
      ((Element)v.get(255)).setAttribute("minimizada","N" );
      ((Element)v.get(251)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(256)).setAttribute("ancho","100" );
      ((Element)v.get(256)).setAttribute("minimizable","S" );
      ((Element)v.get(256)).setAttribute("minimizada","N" );
      ((Element)v.get(251)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("ancho","100" );
      ((Element)v.get(257)).setAttribute("minimizable","S" );
      ((Element)v.get(257)).setAttribute("minimizada","N" );
      ((Element)v.get(251)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(258)).setAttribute("ancho","100" );
      ((Element)v.get(258)).setAttribute("minimizable","S" );
      ((Element)v.get(258)).setAttribute("minimizada","N" );
      ((Element)v.get(251)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(259)).setAttribute("ancho","100" );
      ((Element)v.get(259)).setAttribute("minimizable","S" );
      ((Element)v.get(259)).setAttribute("minimizada","N" );
      ((Element)v.get(251)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(260)).setAttribute("ancho","100" );
      ((Element)v.get(260)).setAttribute("minimizable","S" );
      ((Element)v.get(260)).setAttribute("minimizada","N" );
      ((Element)v.get(251)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:251   */

      /* Empieza nodo:261 / Elemento padre: 242   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(261)).setAttribute("height","20" );
      ((Element)v.get(261)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(261)).setAttribute("imgFondo","" );
      ((Element)v.get(261)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(242)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(262)).setAttribute("colFondo","" );
      ((Element)v.get(262)).setAttribute("ID","EstCab" );
      ((Element)v.get(262)).setAttribute("cod","PreTipoOfert.canaOidCana.label" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(263)).setAttribute("colFondo","" );
      ((Element)v.get(263)).setAttribute("ID","EstCab" );
      ((Element)v.get(263)).setAttribute("cod","PreTipoOfert.codTipoOfer.label" );
      ((Element)v.get(261)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */

      /* Empieza nodo:264 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(264)).setAttribute("colFondo","" );
      ((Element)v.get(264)).setAttribute("ID","EstCab" );
      ((Element)v.get(264)).setAttribute("cod","PreTipoOfert.Descripcion.label" );
      ((Element)v.get(261)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("colFondo","" );
      ((Element)v.get(265)).setAttribute("ID","EstCab" );
      ((Element)v.get(265)).setAttribute("cod","PreTipoOfert.indComi.label" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(261)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(266)).setAttribute("colFondo","" );
      ((Element)v.get(266)).setAttribute("ID","EstCab" );
      ((Element)v.get(266)).setAttribute("cod","PreTipoOfert.indPunt.label" );
      ((Element)v.get(261)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(267)).setAttribute("colFondo","" );
      ((Element)v.get(267)).setAttribute("ID","EstCab" );
      ((Element)v.get(267)).setAttribute("cod","PreTipoOfert.indEsta.label" );
      ((Element)v.get(261)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("colFondo","" );
      ((Element)v.get(268)).setAttribute("ID","EstCab" );
      ((Element)v.get(268)).setAttribute("cod","PreTipoOfert.indMontMini.label" );
      ((Element)v.get(261)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("colFondo","" );
      ((Element)v.get(269)).setAttribute("ID","EstCab" );
      ((Element)v.get(269)).setAttribute("cod","PreTipoOfert.indAporMontEsca.label" );
      ((Element)v.get(261)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("colFondo","" );
      ((Element)v.get(270)).setAttribute("ID","EstCab" );
      ((Element)v.get(270)).setAttribute("cod","PreTipoOfert.indGrat.label" );
      ((Element)v.get(261)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:261   */

      /* Empieza nodo:271 / Elemento padre: 242   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(271)).setAttribute("alto","22" );
      ((Element)v.get(271)).setAttribute("accion","" );
      ((Element)v.get(271)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(271)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(271)).setAttribute("maxSel","1" );
      ((Element)v.get(271)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(271)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(271)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(271)).setAttribute("onLoad","" );
      ((Element)v.get(271)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(242)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("tipo","texto" );
      ((Element)v.get(272)).setAttribute("ID","EstDat" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("tipo","texto" );
      ((Element)v.get(273)).setAttribute("ID","EstDat2" );
      ((Element)v.get(271)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("tipo","texto" );
      ((Element)v.get(274)).setAttribute("ID","EstDat" );
      ((Element)v.get(271)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("tipo","texto" );
      ((Element)v.get(275)).setAttribute("ID","EstDat2" );
      ((Element)v.get(271)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("tipo","texto" );
      ((Element)v.get(276)).setAttribute("ID","EstDat" );
      ((Element)v.get(271)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("tipo","texto" );
      ((Element)v.get(277)).setAttribute("ID","EstDat2" );
      ((Element)v.get(271)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("tipo","texto" );
      ((Element)v.get(278)).setAttribute("ID","EstDat" );
      ((Element)v.get(271)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("tipo","texto" );
      ((Element)v.get(279)).setAttribute("ID","EstDat2" );
      ((Element)v.get(271)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("tipo","texto" );
      ((Element)v.get(280)).setAttribute("ID","EstDat" );
      ((Element)v.get(271)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:271   */

      /* Empieza nodo:281 / Elemento padre: 242   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(242)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:282 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(282)).setAttribute("nombre","preTipoOfertListButtonsLayer" );
      ((Element)v.get(282)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(282)).setAttribute("alto","30" );
      ((Element)v.get(282)).setAttribute("ancho","98%" );
      ((Element)v.get(282)).setAttribute("borde","n" );
      ((Element)v.get(282)).setAttribute("imagenf","" );
      ((Element)v.get(282)).setAttribute("repeat","" );
      ((Element)v.get(282)).setAttribute("padding","0" );
      ((Element)v.get(282)).setAttribute("contravsb","" );
      ((Element)v.get(282)).setAttribute("x","16" );
      ((Element)v.get(282)).setAttribute("y","" );
      ((Element)v.get(282)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(283)).setAttribute("nombre","toolbarSeparatorLayer" );
      ((Element)v.get(283)).setAttribute("visibilidad","inherit" );
      ((Element)v.get(283)).setAttribute("alto","23" );
      ((Element)v.get(283)).setAttribute("ancho","1" );
      ((Element)v.get(283)).setAttribute("borde","1" );
      ((Element)v.get(283)).setAttribute("imagenf","" );
      ((Element)v.get(283)).setAttribute("repeat","" );
      ((Element)v.get(283)).setAttribute("padding","0" );
      ((Element)v.get(283)).setAttribute("contravsb","" );
      ((Element)v.get(283)).setAttribute("x","56" );
      ((Element)v.get(283)).setAttribute("y","0" );
      ((Element)v.get(283)).setAttribute("zindex","" );
      ((Element)v.get(283)).setAttribute("colborde","#999999" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 282   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(284)).setAttribute("width","100%" );
      ((Element)v.get(284)).setAttribute("border","0" );
      ((Element)v.get(284)).setAttribute("cellspacing","1" );
      ((Element)v.get(284)).setAttribute("cellpadding","0" );
      ((Element)v.get(282)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(286)).setAttribute("src","b.gif" );
      ((Element)v.get(286)).setAttribute("height","22" );
      ((Element)v.get(286)).setAttribute("width","5" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:287 / Elemento padre: 284   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(284)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(288)).setAttribute("nombre","preTipoOfertPaginationButtonBar" );
      ((Element)v.get(288)).setAttribute("tipo","H" );
      ((Element)v.get(288)).setAttribute("x","0" );
      ((Element)v.get(288)).setAttribute("y","0" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(289)).setAttribute("nombre","preTipoOfertFirstPageButton" );
      ((Element)v.get(289)).setAttribute("funcion","preTipoOfertFirstPage();" );
      ((Element)v.get(289)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(289)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(289)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(289)).setAttribute("estado","inactivo" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 288   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(290)).setAttribute("nombre","preTipoOfertFirstPageButtonGapTd" );
      ((Element)v.get(288)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(291)).setAttribute("src","b.gif" );
      ((Element)v.get(291)).setAttribute("height","8" );
      ((Element)v.get(291)).setAttribute("width","5" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 288   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(292)).setAttribute("nombre","preTipoOfertPreviousPageButton" );
      ((Element)v.get(292)).setAttribute("funcion","preTipoOfertPreviousPage();" );
      ((Element)v.get(292)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(292)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(292)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(292)).setAttribute("estado","inactivo" );
      ((Element)v.get(288)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 288   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(293)).setAttribute("nombre","preTipoOfertPreviousPageButtonGapTd" );
      ((Element)v.get(288)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(294)).setAttribute("src","b.gif" );
      ((Element)v.get(294)).setAttribute("height","8" );
      ((Element)v.get(294)).setAttribute("width","8" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 288   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(295)).setAttribute("nombre","preTipoOfertNextPageButton" );
      ((Element)v.get(295)).setAttribute("funcion","preTipoOfertNextPage();" );
      ((Element)v.get(295)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(295)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(295)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(295)).setAttribute("estado","inactivo" );
      ((Element)v.get(288)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:296 / Elemento padre: 284   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(284)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(297)).setAttribute("src","b.gif" );
      ((Element)v.get(297)).setAttribute("height","22" );
      ((Element)v.get(297)).setAttribute("width","19" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:298 / Elemento padre: 284   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(298)).setAttribute("class","tablaTitle" );
      ((Element)v.get(298)).setAttribute("nombre","preTipoOfertUpdateButtonTd" );
      ((Element)v.get(284)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(299)).setAttribute("nombre","preTipoOfertUpdateButton" );
      ((Element)v.get(299)).setAttribute("ID","botonContenido" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(299)).setAttribute("tipo","html" );
      ((Element)v.get(299)).setAttribute("accion","preTipoOfertUpdateSelection();" );
      ((Element)v.get(299)).setAttribute("estado","false" );
      ((Element)v.get(299)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:300 / Elemento padre: 284   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(300)).setAttribute("nombre","preTipoOfertUpdateButtonGapTd" );
      ((Element)v.get(284)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(301)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).setAttribute("height","8" );
      ((Element)v.get(301)).setAttribute("width","10" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:302 / Elemento padre: 284   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(302)).setAttribute("class","tablaTitle" );
      ((Element)v.get(302)).setAttribute("nombre","preTipoOfertViewForRemoveButtonTd" );
      ((Element)v.get(284)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(303)).setAttribute("nombre","preTipoOfertViewForRemoveButton" );
      ((Element)v.get(303)).setAttribute("ID","botonContenido" );
      ((Element)v.get(303)).setAttribute("tipo","html" );
      ((Element)v.get(303)).setAttribute("accion","preTipoOfertViewSelection();" );
      ((Element)v.get(303)).setAttribute("estado","false" );
      ((Element)v.get(303)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:304 / Elemento padre: 284   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(304)).setAttribute("nombre","preTipoOfertViewForRemoveButtonGapTd" );
      ((Element)v.get(284)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).setAttribute("height","8" );
      ((Element)v.get(305)).setAttribute("width","10" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 284   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(306)).setAttribute("class","tablaTitle" );
      ((Element)v.get(306)).setAttribute("nombre","preTipoOfertLovSelectButtonTd" );
      ((Element)v.get(284)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(307)).setAttribute("nombre","preTipoOfertLovSelectButton" );
      ((Element)v.get(307)).setAttribute("ID","botonContenido" );
      ((Element)v.get(307)).setAttribute("tipo","html" );
      ((Element)v.get(307)).setAttribute("accion","preTipoOfertLovSelectionAction();" );
      ((Element)v.get(307)).setAttribute("estado","true" );
      ((Element)v.get(307)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 284   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(308)).setAttribute("nombre","preTipoOfertLovSelectButtonGapTd" );
      ((Element)v.get(284)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("height","8" );
      ((Element)v.get(309)).setAttribute("width","10" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 284   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(310)).setAttribute("class","tablaTitle" );
      ((Element)v.get(310)).setAttribute("nombre","preTipoOfertViewButtonTd" );
      ((Element)v.get(284)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(311)).setAttribute("nombre","preTipoOfertViewButton" );
      ((Element)v.get(311)).setAttribute("ID","botonContenido" );
      ((Element)v.get(311)).setAttribute("tipo","html" );
      ((Element)v.get(311)).setAttribute("accion","preTipoOfertViewSelection();" );
      ((Element)v.get(311)).setAttribute("estado","false" );
      ((Element)v.get(311)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 284   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(312)).setAttribute("nombre","preTipoOfertViewButtonGapTd" );
      ((Element)v.get(284)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).setAttribute("height","8" );
      ((Element)v.get(313)).setAttribute("width","10" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 284   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(314)).setAttribute("width","100%" );
      ((Element)v.get(284)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:284   */
      /* Termina nodo:282   */
      /* Termina nodo:5   */


   }

}

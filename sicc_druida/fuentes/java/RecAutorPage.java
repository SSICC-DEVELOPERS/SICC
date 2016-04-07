
import org.w3c.dom.*;
import java.util.ArrayList;

public class RecAutorPage  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","RecAutorPage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","recAutorInitComponents()" );
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
      ((Element)v.get(3)).setAttribute("src","recautor.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","recAutorFrm" );
      ((Element)v.get(4)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","RecAutorLPExecution" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","ON" );
      ((Element)v.get(6)).setAttribute("valor","RecAutorLPExecution" );
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
      ((Element)v.get(36)).setAttribute("nombre","indIngrCheckValue" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","indDesbCheckValue" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(38)).setAttribute("nombre","recAutorFormLayer" );
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
      ((Element)v.get(53)).setAttribute("cod","RecAutor.legend.label" );
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
      ((Element)v.get(68)).setAttribute("cod","RecAutor.id.label" );
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
      ((Element)v.get(71)).setAttribute("ontab","ejecutarAccionFoco('recAutorFrm',1, true)" );
      ((Element)v.get(71)).setAttribute("onshtab","ejecutarAccionFoco('recAutorFrm', 1, false)" );
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
      ((Element)v.get(89)).setAttribute("nombre","codUsuaTdId" );
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
      ((Element)v.get(93)).setAttribute("nombre","lblcodUsua" );
      ((Element)v.get(93)).setAttribute("id","datosTitle" );
      ((Element)v.get(93)).setAttribute("ancho","150" );
      ((Element)v.get(93)).setAttribute("alto","13" );
      ((Element)v.get(93)).setAttribute("cod","RecAutor.codUsua.label" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:94 / Elemento padre: 90   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(94)).setAttribute("nombre","codUsuaWidgetTrId" );
      ((Element)v.get(90)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(95)).setAttribute("align","left" );
      ((Element)v.get(95)).setAttribute("nowrap","true" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(96)).setAttribute("nombre","codUsua" );
      ((Element)v.get(96)).setAttribute("id","datosCampos" );
      ((Element)v.get(96)).setAttribute("multiple","N" );
      ((Element)v.get(96)).setAttribute("req","N" );
      ((Element)v.get(96)).setAttribute("size","1" );
      ((Element)v.get(96)).setAttribute("disabled","" );
      ((Element)v.get(96)).setAttribute("validacion","" );
      ((Element)v.get(96)).setAttribute("onchange","" );
      ((Element)v.get(96)).setAttribute("onfocus","" );
      ((Element)v.get(96)).setAttribute("valorinicial","" );
      ((Element)v.get(96)).setAttribute("textoinicial","" );
      ((Element)v.get(96)).setAttribute("ontab","ejecutarAccionFoco('recAutorFrm',2, true);" );
      ((Element)v.get(96)).setAttribute("onshtab","ejecutarAccionFoco('recAutorFrm',2, false);" );
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
      ((Element)v.get(98)).setAttribute("nombre","codUsuaGapTdId" );
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
      ((Element)v.get(100)).setAttribute("width","100%" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(88)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:83   */

      /* Empieza nodo:102 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(102)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(54)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(103)).setAttribute("align","center" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","12" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 102   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(102)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 102   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(107)).setAttribute("align","center" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","12" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:102   */

      /* Empieza nodo:109 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(109)).setAttribute("nombre","formTr2" );
      ((Element)v.get(54)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(110)).setAttribute("align","center" );
      ((Element)v.get(110)).setAttribute("width","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","8" );
      ((Element)v.get(111)).setAttribute("height","12" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(112)).setAttribute("width","100%" );
      ((Element)v.get(109)).appendChild((Element)v.get(112));

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
      ((Element)v.get(114)).setAttribute("align","left" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(115)).setAttribute("nombre","tiopOidTipoOper_ropeOidOperTdId" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

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
      ((Element)v.get(119)).setAttribute("nombre","lbltiopOidTipoOper_ropeOidOper" );
      ((Element)v.get(119)).setAttribute("id","datosTitle" );
      ((Element)v.get(119)).setAttribute("ancho","150" );
      ((Element)v.get(119)).setAttribute("alto","13" );
      ((Element)v.get(119)).setAttribute("cod","RecTiposOperaView.ropeOidOper.label" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:120 / Elemento padre: 116   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(120)).setAttribute("nombre","tiopOidTipoOper_ropeOidOperWidgetTrId" );
      ((Element)v.get(116)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(121)).setAttribute("align","left" );
      ((Element)v.get(121)).setAttribute("nowrap","true" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(122)).setAttribute("nombre","tiopOidTipoOper_ropeOidOper" );
      ((Element)v.get(122)).setAttribute("id","datosCampos" );
      ((Element)v.get(122)).setAttribute("multiple","N" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(122)).setAttribute("req","N" );
      ((Element)v.get(122)).setAttribute("size","1" );
      ((Element)v.get(122)).setAttribute("disabled","" );
      ((Element)v.get(122)).setAttribute("validacion","" );
      ((Element)v.get(122)).setAttribute("onchange","mmgDependeneChange('tiopOidTipoOper_ropeOidOper', 'tiopOidTipoOper' , 'recAutor')" );
      ((Element)v.get(122)).setAttribute("onfocus","" );
      ((Element)v.get(122)).setAttribute("valorinicial","" );
      ((Element)v.get(122)).setAttribute("textoinicial","" );
      ((Element)v.get(122)).setAttribute("ontab","focaliza('recAutorFrm.tiopOidTipoOper');" );
      ((Element)v.get(122)).setAttribute("onshtab","ejecutarAccionFoco('recAutorFrm',3, false);" );
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

      /* Empieza nodo:124 / Elemento padre: 114   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(124)).setAttribute("nombre","tiopOidTipoOper_ropeOidOperGapTdId" );
      ((Element)v.get(124)).setAttribute("nowrap","true" );
      ((Element)v.get(124)).setAttribute("class","datosCampos" );
      ((Element)v.get(114)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","25" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 114   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(126)).setAttribute("nombre","tiopOidTipoOperTdId" );
      ((Element)v.get(114)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("TABLE"));
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
      ((Element)v.get(130)).setAttribute("nombre","lbltiopOidTipoOper" );
      ((Element)v.get(130)).setAttribute("id","datosTitle" );
      ((Element)v.get(130)).setAttribute("ancho","150" );
      ((Element)v.get(130)).setAttribute("alto","13" );
      ((Element)v.get(130)).setAttribute("cod","RecAutor.tiopOidTipoOper.label" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:131 / Elemento padre: 127   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(131)).setAttribute("nombre","tiopOidTipoOperWidgetTrId" );
      ((Element)v.get(127)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(132)).setAttribute("align","left" );
      ((Element)v.get(132)).setAttribute("nowrap","true" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(133)).setAttribute("nombre","tiopOidTipoOper" );
      ((Element)v.get(133)).setAttribute("id","datosCampos" );
      ((Element)v.get(133)).setAttribute("multiple","N" );
      ((Element)v.get(133)).setAttribute("req","N" );
      ((Element)v.get(133)).setAttribute("size","1" );
      ((Element)v.get(133)).setAttribute("disabled","" );
      ((Element)v.get(133)).setAttribute("validacion","" );
      ((Element)v.get(133)).setAttribute("onchange","" );
      ((Element)v.get(133)).setAttribute("onfocus","" );
      ((Element)v.get(133)).setAttribute("valorinicial","" );
      ((Element)v.get(133)).setAttribute("textoinicial","" );
      ((Element)v.get(133)).setAttribute("ontab","ejecutarAccionFoco('recAutorFrm',3, true);" );
      ((Element)v.get(133)).setAttribute("onshtab","focaliza('recAutorFrm.tiopOidTipoOper_ropeOidOper');" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:135 / Elemento padre: 114   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(135)).setAttribute("nombre","tiopOidTipoOperGapTdId" );
      ((Element)v.get(135)).setAttribute("nowrap","true" );
      ((Element)v.get(135)).setAttribute("class","datosCampos" );
      ((Element)v.get(114)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","25" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 114   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(137)).setAttribute("width","100%" );
      ((Element)v.get(114)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:109   */

      /* Empieza nodo:139 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(139)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(54)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(140)).setAttribute("align","center" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(140)).setAttribute("width","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","12" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 139   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(139)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","8" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 139   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(144)).setAttribute("align","center" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","12" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:139   */

      /* Empieza nodo:146 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(146)).setAttribute("nombre","formTr3" );
      ((Element)v.get(54)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(147)).setAttribute("align","center" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","8" );
      ((Element)v.get(148)).setAttribute("height","12" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 146   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(149)).setAttribute("width","100%" );
      ((Element)v.get(146)).appendChild((Element)v.get(149));

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
      ((Element)v.get(151)).setAttribute("align","left" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(152)).setAttribute("nombre","impMaxiTdId" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

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
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(155)).setAttribute("valign","top" );
      ((Element)v.get(155)).setAttribute("height","13" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(156)).setAttribute("nombre","lblImpMaxi" );
      ((Element)v.get(156)).setAttribute("alto","13" );
      ((Element)v.get(156)).setAttribute("filas","1" );
      ((Element)v.get(156)).setAttribute("id","datosTitle" );
      ((Element)v.get(156)).setAttribute("cod","RecAutor.impMaxi.label" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:157 / Elemento padre: 153   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(157)).setAttribute("nombre","impMaxiWidgetTrId" );
      ((Element)v.get(153)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(158)).setAttribute("align","left" );
      ((Element)v.get(158)).setAttribute("nowrap","true" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(159)).setAttribute("nombre","impMaxi" );
      ((Element)v.get(159)).setAttribute("id","datosCampos" );
      ((Element)v.get(159)).setAttribute("trim","S" );
      ((Element)v.get(159)).setAttribute("max","12" );
      ((Element)v.get(159)).setAttribute("onchange","" );
      ((Element)v.get(159)).setAttribute("req","N" );
      ((Element)v.get(159)).setAttribute("size","12" );
      ((Element)v.get(159)).setAttribute("valor","" );
      ((Element)v.get(159)).setAttribute("validacion","" );
      ((Element)v.get(159)).setAttribute("disabled","" );
      ((Element)v.get(159)).setAttribute("onblur","" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(159)).setAttribute("ontab","ejecutarAccionFoco('recAutorFrm',4, true)" );
      ((Element)v.get(159)).setAttribute("onshtab","ejecutarAccionFoco('recAutorFrm', 4, false)" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:160 / Elemento padre: 151   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(160)).setAttribute("nombre","impMaxiGapTdId" );
      ((Element)v.get(160)).setAttribute("nowrap","true" );
      ((Element)v.get(160)).setAttribute("class","datosCampos" );
      ((Element)v.get(151)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","25" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 151   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(162)).setAttribute("width","100%" );
      ((Element)v.get(151)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:146   */

      /* Empieza nodo:164 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(164)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(54)).appendChild((Element)v.get(164));

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

      /* Empieza nodo:171 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(171)).setAttribute("nombre","formTr4" );
      ((Element)v.get(54)).appendChild((Element)v.get(171));

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
      ((Element)v.get(177)).setAttribute("nombre","impMontMaxiDifeTdId" );
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
      ((Element)v.get(181)).setAttribute("nombre","lblImpMontMaxiDife" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(181)).setAttribute("alto","13" );
      ((Element)v.get(181)).setAttribute("filas","1" );
      ((Element)v.get(181)).setAttribute("id","datosTitle" );
      ((Element)v.get(181)).setAttribute("cod","RecAutor.impMontMaxiDife.label" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:182 / Elemento padre: 178   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(182)).setAttribute("nombre","impMontMaxiDifeWidgetTrId" );
      ((Element)v.get(178)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(183)).setAttribute("align","left" );
      ((Element)v.get(183)).setAttribute("nowrap","true" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(184)).setAttribute("nombre","impMontMaxiDife" );
      ((Element)v.get(184)).setAttribute("id","datosCampos" );
      ((Element)v.get(184)).setAttribute("trim","S" );
      ((Element)v.get(184)).setAttribute("max","12" );
      ((Element)v.get(184)).setAttribute("onchange","" );
      ((Element)v.get(184)).setAttribute("req","N" );
      ((Element)v.get(184)).setAttribute("size","12" );
      ((Element)v.get(184)).setAttribute("valor","" );
      ((Element)v.get(184)).setAttribute("validacion","" );
      ((Element)v.get(184)).setAttribute("disabled","" );
      ((Element)v.get(184)).setAttribute("onblur","" );
      ((Element)v.get(184)).setAttribute("ontab","ejecutarAccionFoco('recAutorFrm',5, true)" );
      ((Element)v.get(184)).setAttribute("onshtab","ejecutarAccionFoco('recAutorFrm', 5, false)" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:185 / Elemento padre: 176   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(185)).setAttribute("nombre","impMontMaxiDifeGapTdId" );
      ((Element)v.get(185)).setAttribute("nowrap","true" );
      ((Element)v.get(185)).setAttribute("class","datosCampos" );
      ((Element)v.get(176)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","25" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 176   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(187)).setAttribute("width","100%" );
      ((Element)v.get(176)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:171   */

      /* Empieza nodo:189 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(189)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(54)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(190)).setAttribute("align","center" );
      ((Element)v.get(190)).setAttribute("width","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","12" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 189   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(189)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","8" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 189   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(194)).setAttribute("align","center" );
      ((Element)v.get(194)).setAttribute("width","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","12" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:189   */

      /* Empieza nodo:196 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(196)).setAttribute("nombre","formTr5" );
      ((Element)v.get(54)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(197)).setAttribute("align","center" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","8" );
      ((Element)v.get(198)).setAttribute("height","12" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 196   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(199)).setAttribute("width","100%" );
      ((Element)v.get(196)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(200)).setAttribute("width","100%" );
      ((Element)v.get(200)).setAttribute("border","0" );
      ((Element)v.get(200)).setAttribute("cellspacing","0" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(200)).setAttribute("cellpadding","0" );
      ((Element)v.get(200)).setAttribute("align","left" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(201)).setAttribute("align","left" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(202)).setAttribute("nombre","indIngrTdId" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

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
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(205)).setAttribute("valign","top" );
      ((Element)v.get(205)).setAttribute("height","13" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(206)).setAttribute("nombre","lblIndIngr" );
      ((Element)v.get(206)).setAttribute("alto","13" );
      ((Element)v.get(206)).setAttribute("filas","1" );
      ((Element)v.get(206)).setAttribute("id","datosTitle" );
      ((Element)v.get(206)).setAttribute("cod","RecAutor.indIngr.label" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:207 / Elemento padre: 203   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(207)).setAttribute("nombre","indIngrWidgetTrId" );
      ((Element)v.get(203)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(208)).setAttribute("align","left" );
      ((Element)v.get(208)).setAttribute("nowrap","true" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(209)).setAttribute("nombre","indIngr" );
      ((Element)v.get(209)).setAttribute("tipo","H" );
      ((Element)v.get(209)).setAttribute("req","N" );
      ((Element)v.get(209)).setAttribute("id","datosCampos" );
      ((Element)v.get(209)).setAttribute("valor","" );
      ((Element)v.get(209)).setAttribute("disabled","" );
      ((Element)v.get(209)).setAttribute("ontab","ejecutarAccionFoco('recAutorFrm',6, true)" );
      ((Element)v.get(209)).setAttribute("onshtab","ejecutarAccionFoco('recAutorFrm',6, false)" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(210)).setAttribute("id","datosCampos" );
      ((Element)v.get(210)).setAttribute("valor","1" );
      ((Element)v.get(210)).setAttribute("cod","RecAutor.indIngr.1.label" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Elemento padre:210 / Elemento actual: 211   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(210)).appendChild((Text)v.get(211));

      /* Termina nodo Texto:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 209   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(212)).setAttribute("id","datosCampos" );
      ((Element)v.get(212)).setAttribute("valor","0" );
      ((Element)v.get(212)).setAttribute("cod","RecAutor.indIngr.0.label" );
      ((Element)v.get(209)).appendChild((Element)v.get(212));

      /* Elemento padre:212 / Elemento actual: 213   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(212)).appendChild((Text)v.get(213));

      /* Termina nodo Texto:213   */
      /* Termina nodo:212   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:214 / Elemento padre: 201   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(214)).setAttribute("nombre","indIngrGapTdId" );
      ((Element)v.get(214)).setAttribute("nowrap","true" );
      ((Element)v.get(214)).setAttribute("class","datosCampos" );
      ((Element)v.get(201)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","25" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 201   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(216)).setAttribute("width","100%" );
      ((Element)v.get(201)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:196   */

      /* Empieza nodo:218 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(218)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(54)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(219)).setAttribute("align","center" );
      ((Element)v.get(219)).setAttribute("width","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","12" );
      ((Element)v.get(220)).setAttribute("height","8" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 218   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(218)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
   }

   private void getXML990(Document doc) {
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
      ((Element)v.get(224)).setAttribute("width","12" );
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:218   */

      /* Empieza nodo:225 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(225)).setAttribute("nombre","formTr6" );
      ((Element)v.get(54)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(226)).setAttribute("align","center" );
      ((Element)v.get(226)).setAttribute("width","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","8" );
      ((Element)v.get(227)).setAttribute("height","12" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 225   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(228)).setAttribute("width","100%" );
      ((Element)v.get(225)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(229)).setAttribute("width","100%" );
      ((Element)v.get(229)).setAttribute("border","0" );
      ((Element)v.get(229)).setAttribute("cellspacing","0" );
      ((Element)v.get(229)).setAttribute("cellpadding","0" );
      ((Element)v.get(229)).setAttribute("align","left" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(230)).setAttribute("align","left" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(231)).setAttribute("nombre","indDesbTdId" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));

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
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(234)).setAttribute("valign","top" );
      ((Element)v.get(234)).setAttribute("height","13" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(235)).setAttribute("nombre","lblIndDesb" );
      ((Element)v.get(235)).setAttribute("alto","13" );
      ((Element)v.get(235)).setAttribute("filas","1" );
      ((Element)v.get(235)).setAttribute("id","datosTitle" );
      ((Element)v.get(235)).setAttribute("cod","RecAutor.indDesb.label" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:236 / Elemento padre: 232   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(236)).setAttribute("nombre","indDesbWidgetTrId" );
      ((Element)v.get(232)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(237)).setAttribute("align","left" );
      ((Element)v.get(237)).setAttribute("nowrap","true" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(238)).setAttribute("nombre","indDesb" );
      ((Element)v.get(238)).setAttribute("tipo","H" );
      ((Element)v.get(238)).setAttribute("req","N" );
      ((Element)v.get(238)).setAttribute("id","datosCampos" );
      ((Element)v.get(238)).setAttribute("valor","" );
      ((Element)v.get(238)).setAttribute("disabled","" );
      ((Element)v.get(238)).setAttribute("ontab","ejecutarAccionFoco('recAutorFrm',7, true)" );
      ((Element)v.get(238)).setAttribute("onshtab","ejecutarAccionFoco('recAutorFrm',7, false)" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(239)).setAttribute("id","datosCampos" );
      ((Element)v.get(239)).setAttribute("valor","1" );
      ((Element)v.get(239)).setAttribute("cod","RecAutor.indDesb.1.label" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Elemento padre:239 / Elemento actual: 240   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(239)).appendChild((Text)v.get(240));

      /* Termina nodo Texto:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 238   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(241)).setAttribute("id","datosCampos" );
      ((Element)v.get(241)).setAttribute("valor","0" );
      ((Element)v.get(241)).setAttribute("cod","RecAutor.indDesb.0.label" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(238)).appendChild((Element)v.get(241));

      /* Elemento padre:241 / Elemento actual: 242   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(241)).appendChild((Text)v.get(242));

      /* Termina nodo Texto:242   */
      /* Termina nodo:241   */
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:243 / Elemento padre: 230   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(243)).setAttribute("nombre","indDesbGapTdId" );
      ((Element)v.get(243)).setAttribute("nowrap","true" );
      ((Element)v.get(243)).setAttribute("class","datosCampos" );
      ((Element)v.get(230)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","25" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 230   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(245)).setAttribute("width","100%" );
      ((Element)v.get(230)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:225   */

      /* Empieza nodo:247 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(247)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(54)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(248)).setAttribute("align","center" );
      ((Element)v.get(248)).setAttribute("width","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","12" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 247   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(247)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","8" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 247   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(252)).setAttribute("align","center" );
      ((Element)v.get(252)).setAttribute("width","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","12" );
      ((Element)v.get(253)).setAttribute("height","8" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:247   */

      /* Empieza nodo:254 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(254)).setAttribute("nombre","formTr7" );
      ((Element)v.get(54)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(255)).setAttribute("align","center" );
      ((Element)v.get(255)).setAttribute("width","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","8" );
      ((Element)v.get(256)).setAttribute("height","12" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 254   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(257)).setAttribute("width","100%" );
      ((Element)v.get(254)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(258)).setAttribute("width","100%" );
      ((Element)v.get(258)).setAttribute("border","0" );
      ((Element)v.get(258)).setAttribute("cellspacing","0" );
      ((Element)v.get(258)).setAttribute("cellpadding","0" );
      ((Element)v.get(258)).setAttribute("align","left" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(259)).setAttribute("align","left" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(260)).setAttribute("nombre","paisOidPaisTdId" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(261)).setAttribute("border","0" );
      ((Element)v.get(261)).setAttribute("cellspacing","0" );
      ((Element)v.get(261)).setAttribute("cellpadding","0" );
      ((Element)v.get(261)).setAttribute("align","left" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(263)).setAttribute("valign","top" );
      ((Element)v.get(263)).setAttribute("height","13" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(264)).setAttribute("nombre","lblpaisOidPais" );
      ((Element)v.get(264)).setAttribute("id","datosTitle" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(264)).setAttribute("ancho","150" );
      ((Element)v.get(264)).setAttribute("alto","13" );
      ((Element)v.get(264)).setAttribute("cod","RecAutor.paisOidPais.label" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:265 / Elemento padre: 261   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(265)).setAttribute("nombre","paisOidPaisWidgetTrId" );
      ((Element)v.get(261)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(266)).setAttribute("align","left" );
      ((Element)v.get(266)).setAttribute("nowrap","true" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(267)).setAttribute("nombre","paisOidPais" );
      ((Element)v.get(267)).setAttribute("id","datosCampos" );
      ((Element)v.get(267)).setAttribute("multiple","N" );
      ((Element)v.get(267)).setAttribute("req","N" );
      ((Element)v.get(267)).setAttribute("size","1" );
      ((Element)v.get(267)).setAttribute("disabled","" );
      ((Element)v.get(267)).setAttribute("validacion","" );
      ((Element)v.get(267)).setAttribute("onchange","" );
      ((Element)v.get(267)).setAttribute("onfocus","" );
      ((Element)v.get(267)).setAttribute("valorinicial","" );
      ((Element)v.get(267)).setAttribute("textoinicial","" );
      ((Element)v.get(267)).setAttribute("ontab","ejecutarAccionFoco('recAutorFrm',8, true);" );
      ((Element)v.get(267)).setAttribute("onshtab","ejecutarAccionFoco('recAutorFrm',8, false);" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:269 / Elemento padre: 259   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(269)).setAttribute("nombre","paisOidPaisGapTdId" );
      ((Element)v.get(269)).setAttribute("nowrap","true" );
      ((Element)v.get(269)).setAttribute("class","datosCampos" );
      ((Element)v.get(259)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(270)).setAttribute("src","b.gif" );
      ((Element)v.get(270)).setAttribute("width","25" );
      ((Element)v.get(270)).setAttribute("height","8" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:271 / Elemento padre: 259   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(271)).setAttribute("width","100%" );
      ((Element)v.get(259)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */
      /* Termina nodo:259   */
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:273 / Elemento padre: 254   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(273)).setAttribute("width","100%" );
      ((Element)v.get(254)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:254   */

      /* Empieza nodo:274 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(274)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(54)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(275)).setAttribute("align","center" );
      ((Element)v.get(275)).setAttribute("width","8" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","8" );
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(274)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).setAttribute("width","8" );
      ((Element)v.get(278)).setAttribute("height","8" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(279)).setAttribute("align","center" );
      ((Element)v.get(279)).setAttribute("width","8" );
      ((Element)v.get(274)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","8" );
      ((Element)v.get(280)).setAttribute("height","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */
      /* Termina nodo:274   */
      /* Termina nodo:54   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:281 / Elemento padre: 47   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(281)).setAttribute("align","center" );
      ((Element)v.get(281)).setAttribute("width","12" );
      ((Element)v.get(47)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).setAttribute("width","12" );
      ((Element)v.get(282)).setAttribute("height","12" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */
      /* Termina nodo:47   */

      /* Empieza nodo:283 / Elemento padre: 39   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(283)).setAttribute("nombre","recAutorTrButtons" );
      ((Element)v.get(39)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(284)).setAttribute("align","center" );
      ((Element)v.get(284)).setAttribute("width","12" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","12" );
      ((Element)v.get(285)).setAttribute("height","12" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(283)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(288)).setAttribute("width","100%" );
      ((Element)v.get(288)).setAttribute("border","0" );
      ((Element)v.get(288)).setAttribute("align","center" );
      ((Element)v.get(288)).setAttribute("cellspacing","0" );
      ((Element)v.get(288)).setAttribute("cellpadding","0" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(290)).setAttribute("class","tablaTitle" );
      ((Element)v.get(290)).setAttribute("nombre","recAutorTdQueryButton" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(291)).setAttribute("nombre","recAutorQueryButton" );
      ((Element)v.get(291)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(291)).setAttribute("estado","false" );
      ((Element)v.get(291)).setAttribute("accion","recAutorFirstPage();" );
      ((Element)v.get(291)).setAttribute("tipo","html" );
      ((Element)v.get(291)).setAttribute("ID","botonContenido" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 289   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(292)).setAttribute("class","tablaTitle" );
      ((Element)v.get(292)).setAttribute("nombre","recAutorTdLovNullSelectionButton" );
      ((Element)v.get(292)).setAttribute("align","left" );
      ((Element)v.get(292)).setAttribute("width","100%" );
      ((Element)v.get(289)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(293)).setAttribute("width","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 292   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(294)).setAttribute("nombre","recAutorLovNullButton" );
      ((Element)v.get(294)).setAttribute("ID","botonContenido" );
      ((Element)v.get(294)).setAttribute("tipo","html" );
      ((Element)v.get(294)).setAttribute("accion","recAutorLovNullSelectionAction();" );
      ((Element)v.get(294)).setAttribute("estado","true" );
      ((Element)v.get(294)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(292)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:292   */
      /* Termina nodo:289   */
      /* Termina nodo:288   */
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:295 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(295)).setAttribute("align","center" );
      ((Element)v.get(295)).setAttribute("width","12" );
      ((Element)v.get(283)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(296)).setAttribute("width","12" );
      ((Element)v.get(296)).setAttribute("height","12" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */
      /* Termina nodo:283   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:297 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(297)).setAttribute("nombre","recAutorListLayer" );
      ((Element)v.get(297)).setAttribute("alto","310" );
      ((Element)v.get(297)).setAttribute("ancho","99%" );
      ((Element)v.get(297)).setAttribute("colorf","" );
      ((Element)v.get(297)).setAttribute("borde","0" );
      ((Element)v.get(297)).setAttribute("imagenf","" );
      ((Element)v.get(297)).setAttribute("repeat","" );
      ((Element)v.get(297)).setAttribute("padding","" );
      ((Element)v.get(297)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(297)).setAttribute("contravsb","" );
      ((Element)v.get(297)).setAttribute("x","3" );
      ((Element)v.get(297)).setAttribute("y","" );
      ((Element)v.get(297)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(298)).setAttribute("nombre","recAutorList" );
      ((Element)v.get(298)).setAttribute("ancho","680" );
      ((Element)v.get(298)).setAttribute("alto","275" );
      ((Element)v.get(298)).setAttribute("x","12" );
      ((Element)v.get(298)).setAttribute("y","0" );
      ((Element)v.get(298)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(298)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(299)).setAttribute("precarga","S" );
      ((Element)v.get(299)).setAttribute("conROver","S" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(300)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(300)).setAttribute("rollOver","btnLista2S.gif" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(300)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(300)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 299   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(301)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(301)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(301)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(301)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(299)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:299   */

      /* Empieza nodo:302 / Elemento padre: 298   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(298)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(303)).setAttribute("borde","1" );
      ((Element)v.get(303)).setAttribute("horizDatos","1" );
      ((Element)v.get(303)).setAttribute("horizCabecera","1" );
      ((Element)v.get(303)).setAttribute("vertical","1" );
      ((Element)v.get(303)).setAttribute("horizTitulo","1" );
      ((Element)v.get(303)).setAttribute("horizBase","1" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 302   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(304)).setAttribute("borde","#999999" );
      ((Element)v.get(304)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(304)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(304)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(304)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(304)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(304)).setAttribute("horizBase","#999999" );
      ((Element)v.get(302)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:302   */

      /* Empieza nodo:305 / Elemento padre: 298   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(305)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(305)).setAttribute("alto","22" );
      ((Element)v.get(305)).setAttribute("imgFondo","" );
      ((Element)v.get(305)).setAttribute("cod","00135" );
      ((Element)v.get(305)).setAttribute("ID","datosTitle" );
      ((Element)v.get(298)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 298   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(306)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(306)).setAttribute("alto","22" );
      ((Element)v.get(306)).setAttribute("imgFondo","" );
      ((Element)v.get(298)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 298   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(307)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(307)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(307)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(307)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(307)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(298)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(308)).setAttribute("ancho","100" );
      ((Element)v.get(308)).setAttribute("minimizable","S" );
      ((Element)v.get(308)).setAttribute("minimizada","N" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(309)).setAttribute("ancho","100" );
      ((Element)v.get(309)).setAttribute("minimizable","S" );
      ((Element)v.get(309)).setAttribute("minimizada","N" );
      ((Element)v.get(307)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */

      /* Empieza nodo:310 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(310)).setAttribute("ancho","100" );
      ((Element)v.get(310)).setAttribute("minimizable","S" );
      ((Element)v.get(310)).setAttribute("minimizada","N" );
      ((Element)v.get(307)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(311)).setAttribute("ancho","100" );
      ((Element)v.get(311)).setAttribute("minimizable","S" );
      ((Element)v.get(311)).setAttribute("minimizada","N" );
      ((Element)v.get(307)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(312)).setAttribute("ancho","100" );
      ((Element)v.get(312)).setAttribute("minimizable","S" );
      ((Element)v.get(312)).setAttribute("minimizada","N" );
      ((Element)v.get(307)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */

      /* Empieza nodo:313 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(313)).setAttribute("ancho","100" );
      ((Element)v.get(313)).setAttribute("minimizable","S" );
      ((Element)v.get(313)).setAttribute("minimizada","N" );
      ((Element)v.get(307)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:307   */

      /* Empieza nodo:314 / Elemento padre: 298   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(314)).setAttribute("height","20" );
      ((Element)v.get(314)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(314)).setAttribute("imgFondo","" );
      ((Element)v.get(314)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(298)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(315)).setAttribute("colFondo","" );
      ((Element)v.get(315)).setAttribute("ID","EstCab" );
      ((Element)v.get(315)).setAttribute("cod","RecAutor.codUsua.label" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */

      /* Empieza nodo:316 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(316)).setAttribute("colFondo","" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(316)).setAttribute("ID","EstCab" );
      ((Element)v.get(316)).setAttribute("cod","RecAutor.tiopOidTipoOper.label" );
      ((Element)v.get(314)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */

      /* Empieza nodo:317 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(317)).setAttribute("colFondo","" );
      ((Element)v.get(317)).setAttribute("ID","EstCab" );
      ((Element)v.get(317)).setAttribute("cod","RecAutor.impMaxi.label" );
      ((Element)v.get(314)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */

      /* Empieza nodo:318 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(318)).setAttribute("colFondo","" );
      ((Element)v.get(318)).setAttribute("ID","EstCab" );
      ((Element)v.get(318)).setAttribute("cod","RecAutor.impMontMaxiDife.label" );
      ((Element)v.get(314)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */

      /* Empieza nodo:319 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(319)).setAttribute("colFondo","" );
      ((Element)v.get(319)).setAttribute("ID","EstCab" );
      ((Element)v.get(319)).setAttribute("cod","RecAutor.indIngr.label" );
      ((Element)v.get(314)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(320)).setAttribute("colFondo","" );
      ((Element)v.get(320)).setAttribute("ID","EstCab" );
      ((Element)v.get(320)).setAttribute("cod","RecAutor.indDesb.label" );
      ((Element)v.get(314)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:314   */

      /* Empieza nodo:321 / Elemento padre: 298   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(321)).setAttribute("alto","22" );
      ((Element)v.get(321)).setAttribute("accion","" );
      ((Element)v.get(321)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(321)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(321)).setAttribute("maxSel","1" );
      ((Element)v.get(321)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(321)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(321)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(321)).setAttribute("onLoad","" );
      ((Element)v.get(321)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(298)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(322)).setAttribute("tipo","texto" );
      ((Element)v.get(322)).setAttribute("ID","EstDat" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */

      /* Empieza nodo:323 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(323)).setAttribute("tipo","texto" );
      ((Element)v.get(323)).setAttribute("ID","EstDat2" );
      ((Element)v.get(321)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */

      /* Empieza nodo:324 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(324)).setAttribute("tipo","texto" );
      ((Element)v.get(324)).setAttribute("ID","EstDat" );
      ((Element)v.get(321)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */

      /* Empieza nodo:325 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(325)).setAttribute("tipo","texto" );
      ((Element)v.get(325)).setAttribute("ID","EstDat2" );
      ((Element)v.get(321)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(326)).setAttribute("tipo","texto" );
      ((Element)v.get(326)).setAttribute("ID","EstDat" );
      ((Element)v.get(321)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */

      /* Empieza nodo:327 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(327)).setAttribute("tipo","texto" );
      ((Element)v.get(327)).setAttribute("ID","EstDat2" );
      ((Element)v.get(321)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:321   */

      /* Empieza nodo:328 / Elemento padre: 298   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(298)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:329 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(329)).setAttribute("nombre","recAutorListButtonsLayer" );
      ((Element)v.get(329)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(329)).setAttribute("alto","30" );
      ((Element)v.get(329)).setAttribute("ancho","98%" );
      ((Element)v.get(329)).setAttribute("borde","n" );
      ((Element)v.get(329)).setAttribute("imagenf","" );
      ((Element)v.get(329)).setAttribute("repeat","" );
      ((Element)v.get(329)).setAttribute("padding","0" );
      ((Element)v.get(329)).setAttribute("contravsb","" );
      ((Element)v.get(329)).setAttribute("x","16" );
      ((Element)v.get(329)).setAttribute("y","" );
      ((Element)v.get(329)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(330)).setAttribute("nombre","toolbarSeparatorLayer" );
      ((Element)v.get(330)).setAttribute("visibilidad","inherit" );
      ((Element)v.get(330)).setAttribute("alto","23" );
      ((Element)v.get(330)).setAttribute("ancho","1" );
      ((Element)v.get(330)).setAttribute("borde","1" );
      ((Element)v.get(330)).setAttribute("imagenf","" );
      ((Element)v.get(330)).setAttribute("repeat","" );
      ((Element)v.get(330)).setAttribute("padding","0" );
      ((Element)v.get(330)).setAttribute("contravsb","" );
      ((Element)v.get(330)).setAttribute("x","56" );
      ((Element)v.get(330)).setAttribute("y","0" );
      ((Element)v.get(330)).setAttribute("zindex","" );
      ((Element)v.get(330)).setAttribute("colborde","#999999" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */

      /* Empieza nodo:331 / Elemento padre: 329   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(331)).setAttribute("width","100%" );
      ((Element)v.get(331)).setAttribute("border","0" );
      ((Element)v.get(331)).setAttribute("cellspacing","1" );
      ((Element)v.get(331)).setAttribute("cellpadding","0" );
      ((Element)v.get(329)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(331)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(333)).setAttribute("src","b.gif" );
      ((Element)v.get(333)).setAttribute("height","22" );
      ((Element)v.get(333)).setAttribute("width","5" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */

      /* Empieza nodo:334 / Elemento padre: 331   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(331)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(335)).setAttribute("nombre","recAutorPaginationButtonBar" );
      ((Element)v.get(335)).setAttribute("tipo","H" );
      ((Element)v.get(335)).setAttribute("x","0" );
      ((Element)v.get(335)).setAttribute("y","0" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(336)).setAttribute("nombre","recAutorFirstPageButton" );
      ((Element)v.get(336)).setAttribute("funcion","recAutorFirstPage();" );
      ((Element)v.get(336)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(336)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(336)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(336)).setAttribute("estado","inactivo" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */

      /* Empieza nodo:337 / Elemento padre: 335   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(337)).setAttribute("nombre","recAutorFirstPageButtonGapTd" );
      ((Element)v.get(335)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("height","8" );
      ((Element)v.get(338)).setAttribute("width","5" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 335   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(339)).setAttribute("nombre","recAutorPreviousPageButton" );
      ((Element)v.get(339)).setAttribute("funcion","recAutorPreviousPage();" );
      ((Element)v.get(339)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(339)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(339)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(339)).setAttribute("estado","inactivo" );
      ((Element)v.get(335)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */

      /* Empieza nodo:340 / Elemento padre: 335   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(340)).setAttribute("nombre","recAutorPreviousPageButtonGapTd" );
      ((Element)v.get(335)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(341)).setAttribute("src","b.gif" );
      ((Element)v.get(341)).setAttribute("height","8" );
      ((Element)v.get(341)).setAttribute("width","8" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:342 / Elemento padre: 335   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(342)).setAttribute("nombre","recAutorNextPageButton" );
      ((Element)v.get(342)).setAttribute("funcion","recAutorNextPage();" );
      ((Element)v.get(342)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(342)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(342)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(342)).setAttribute("estado","inactivo" );
      ((Element)v.get(335)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:343 / Elemento padre: 331   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(331)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("height","22" );
      ((Element)v.get(344)).setAttribute("width","19" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 331   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(345)).setAttribute("class","tablaTitle" );
      ((Element)v.get(345)).setAttribute("nombre","recAutorUpdateButtonTd" );
      ((Element)v.get(331)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(346)).setAttribute("nombre","recAutorUpdateButton" );
      ((Element)v.get(346)).setAttribute("ID","botonContenido" );
      ((Element)v.get(346)).setAttribute("tipo","html" );
      ((Element)v.get(346)).setAttribute("accion","recAutorUpdateSelection();" );
      ((Element)v.get(346)).setAttribute("estado","false" );
      ((Element)v.get(346)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 331   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(347)).setAttribute("nombre","recAutorUpdateButtonGapTd" );
      ((Element)v.get(331)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(348)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).setAttribute("height","8" );
      ((Element)v.get(348)).setAttribute("width","10" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 331   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(349)).setAttribute("class","tablaTitle" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(349)).setAttribute("nombre","recAutorViewForRemoveButtonTd" );
      ((Element)v.get(331)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(350)).setAttribute("nombre","recAutorViewForRemoveButton" );
      ((Element)v.get(350)).setAttribute("ID","botonContenido" );
      ((Element)v.get(350)).setAttribute("tipo","html" );
      ((Element)v.get(350)).setAttribute("accion","recAutorViewSelection();" );
      ((Element)v.get(350)).setAttribute("estado","false" );
      ((Element)v.get(350)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 331   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(351)).setAttribute("nombre","recAutorViewForRemoveButtonGapTd" );
      ((Element)v.get(331)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(352)).setAttribute("src","b.gif" );
      ((Element)v.get(352)).setAttribute("height","8" );
      ((Element)v.get(352)).setAttribute("width","10" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:353 / Elemento padre: 331   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(353)).setAttribute("class","tablaTitle" );
      ((Element)v.get(353)).setAttribute("nombre","recAutorLovSelectButtonTd" );
      ((Element)v.get(331)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(354)).setAttribute("nombre","recAutorLovSelectButton" );
      ((Element)v.get(354)).setAttribute("ID","botonContenido" );
      ((Element)v.get(354)).setAttribute("tipo","html" );
      ((Element)v.get(354)).setAttribute("accion","recAutorLovSelectionAction();" );
      ((Element)v.get(354)).setAttribute("estado","true" );
      ((Element)v.get(354)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:355 / Elemento padre: 331   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(355)).setAttribute("nombre","recAutorLovSelectButtonGapTd" );
      ((Element)v.get(331)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(356)).setAttribute("src","b.gif" );
      ((Element)v.get(356)).setAttribute("height","8" );
      ((Element)v.get(356)).setAttribute("width","10" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:355   */

      /* Empieza nodo:357 / Elemento padre: 331   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(357)).setAttribute("class","tablaTitle" );
      ((Element)v.get(357)).setAttribute("nombre","recAutorViewButtonTd" );
      ((Element)v.get(331)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(358)).setAttribute("nombre","recAutorViewButton" );
      ((Element)v.get(358)).setAttribute("ID","botonContenido" );
      ((Element)v.get(358)).setAttribute("tipo","html" );
      ((Element)v.get(358)).setAttribute("accion","recAutorViewSelection();" );
      ((Element)v.get(358)).setAttribute("estado","false" );
      ((Element)v.get(358)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */

      /* Empieza nodo:359 / Elemento padre: 331   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(359)).setAttribute("nombre","recAutorViewButtonGapTd" );
      ((Element)v.get(331)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(360)).setAttribute("src","b.gif" );
      ((Element)v.get(360)).setAttribute("height","8" );
      ((Element)v.get(360)).setAttribute("width","10" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:361 / Elemento padre: 331   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(361)).setAttribute("width","100%" );
      ((Element)v.get(331)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:331   */
      /* Termina nodo:329   */
      /* Termina nodo:4   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class MaeTipoVincuPage  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","MaeTipoVincuPage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","maeTipoVincuInitComponents()" );
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
      ((Element)v.get(4)).setAttribute("src","maetipovincu.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","maeTipoVincuFrm" );
      ((Element)v.get(5)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(6)).setAttribute("valor","MaeTipoVincuLPExecution" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","ON" );
      ((Element)v.get(7)).setAttribute("valor","MaeTipoVincuLPExecution" );
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
      ((Element)v.get(37)).setAttribute("nombre","indRecoCheckValue" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(38)).setAttribute("nombre","maeTipoVincuFormLayer" );
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
      ((Element)v.get(5)).appendChild((Element)v.get(38));

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
      ((Element)v.get(41)).setAttribute("align","center" );
   }

   private void getXML180(Document doc) {
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
      ((Element)v.get(53)).setAttribute("cod","MaeTipoVincu.legend.label" );
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
      ((Element)v.get(62)).setAttribute("border","0" );
   }

   private void getXML270(Document doc) {
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
      ((Element)v.get(68)).setAttribute("cod","MaeTipoVincu.id.label" );
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
      ((Element)v.get(71)).setAttribute("ontab","ejecutarAccionFoco('maeTipoVincuFrm',1, true)" );
      ((Element)v.get(71)).setAttribute("onshtab","ejecutarAccionFoco('maeTipoVincuFrm', 1, false)" );
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
      ((Element)v.get(81)).setAttribute("width","8" );
   }

   private void getXML360(Document doc) {
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
      ((Element)v.get(89)).setAttribute("nombre","paisOidPaisTdId" );
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
      ((Element)v.get(93)).setAttribute("nombre","lblpaisOidPais" );
      ((Element)v.get(93)).setAttribute("id","datosTitle" );
      ((Element)v.get(93)).setAttribute("ancho","150" );
      ((Element)v.get(93)).setAttribute("alto","13" );
      ((Element)v.get(93)).setAttribute("cod","MaeTipoVincu.paisOidPais.label" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:94 / Elemento padre: 90   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(94)).setAttribute("nombre","paisOidPaisWidgetTrId" );
      ((Element)v.get(90)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(95)).setAttribute("align","left" );
      ((Element)v.get(95)).setAttribute("nowrap","true" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(96)).setAttribute("nombre","paisOidPais" );
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
      ((Element)v.get(96)).setAttribute("ontab","ejecutarAccionFoco('maeTipoVincuFrm',2, true);" );
      ((Element)v.get(96)).setAttribute("onshtab","ejecutarAccionFoco('maeTipoVincuFrm',2, false);" );
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
      ((Element)v.get(98)).setAttribute("nombre","paisOidPaisGapTdId" );
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
      ((Element)v.get(88)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
   }

   private void getXML450(Document doc) {
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
      ((Element)v.get(115)).setAttribute("nombre","codTipoVincTdId" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(116)).setAttribute("width","100%" );
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
      ((Element)v.get(119)).setAttribute("nombre","lblCodTipoVinc" );
      ((Element)v.get(119)).setAttribute("alto","13" );
      ((Element)v.get(119)).setAttribute("filas","1" );
      ((Element)v.get(119)).setAttribute("id","datosTitle" );
      ((Element)v.get(119)).setAttribute("cod","MaeTipoVincu.codTipoVinc.label" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:120 / Elemento padre: 116   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(120)).setAttribute("nombre","codTipoVincWidgetTrId" );
      ((Element)v.get(116)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(121)).setAttribute("align","left" );
      ((Element)v.get(121)).setAttribute("nowrap","true" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(122)).setAttribute("nombre","codTipoVinc" );
      ((Element)v.get(122)).setAttribute("id","datosCampos" );
      ((Element)v.get(122)).setAttribute("trim","S" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(122)).setAttribute("max","2" );
      ((Element)v.get(122)).setAttribute("onchange","" );
      ((Element)v.get(122)).setAttribute("req","N" );
      ((Element)v.get(122)).setAttribute("size","2" );
      ((Element)v.get(122)).setAttribute("valor","" );
      ((Element)v.get(122)).setAttribute("validacion","" );
      ((Element)v.get(122)).setAttribute("disabled","" );
      ((Element)v.get(122)).setAttribute("onblur","" );
      ((Element)v.get(122)).setAttribute("ontab","ejecutarAccionFoco('maeTipoVincuFrm',3, true)" );
      ((Element)v.get(122)).setAttribute("onshtab","ejecutarAccionFoco('maeTipoVincuFrm', 3, false)" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:123 / Elemento padre: 114   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(123)).setAttribute("nombre","codTipoVincGapTdId" );
      ((Element)v.get(123)).setAttribute("nowrap","true" );
      ((Element)v.get(123)).setAttribute("class","datosCampos" );
      ((Element)v.get(114)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","25" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 114   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(125)).setAttribute("nombre","DescripcionTdId" );
      ((Element)v.get(114)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(126)).setAttribute("width","100%" );
      ((Element)v.get(126)).setAttribute("border","0" );
      ((Element)v.get(126)).setAttribute("cellspacing","0" );
      ((Element)v.get(126)).setAttribute("cellpadding","0" );
      ((Element)v.get(126)).setAttribute("align","left" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(128)).setAttribute("valign","top" );
      ((Element)v.get(128)).setAttribute("height","13" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(129)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(129)).setAttribute("alto","13" );
      ((Element)v.get(129)).setAttribute("filas","1" );
      ((Element)v.get(129)).setAttribute("id","datosTitle" );
      ((Element)v.get(129)).setAttribute("cod","MaeTipoVincu.Descripcion.label" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 127   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(130)).setAttribute("nombre","DescripcionTdLocalizationButtonGapHeader" );
      ((Element)v.get(130)).setAttribute("colspan","2" );
      ((Element)v.get(127)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:127   */

      /* Empieza nodo:131 / Elemento padre: 126   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(131)).setAttribute("nombre","DescripcionWidgetTrId" );
      ((Element)v.get(126)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(132)).setAttribute("align","left" );
      ((Element)v.get(132)).setAttribute("nowrap","true" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(133)).setAttribute("nombre","Descripcion" );
      ((Element)v.get(133)).setAttribute("id","datosCampos" );
      ((Element)v.get(133)).setAttribute("trim","S" );
      ((Element)v.get(133)).setAttribute("max","40" );
      ((Element)v.get(133)).setAttribute("onchange","" );
      ((Element)v.get(133)).setAttribute("req","N" );
      ((Element)v.get(133)).setAttribute("size","40" );
      ((Element)v.get(133)).setAttribute("valor","" );
      ((Element)v.get(133)).setAttribute("validacion","" );
      ((Element)v.get(133)).setAttribute("disabled","" );
      ((Element)v.get(133)).setAttribute("onblur","" );
      ((Element)v.get(133)).setAttribute("ontab","ejecutarAccionFoco('maeTipoVincuFrm',4, true)" );
      ((Element)v.get(133)).setAttribute("onshtab","ejecutarAccionFoco('maeTipoVincuFrm', 4, false)" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 131   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(131)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 131   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(136)).setAttribute("nombre","DescripcionTdLocalizationButton" );
      ((Element)v.get(136)).setAttribute("align","left" );
      ((Element)v.get(136)).setAttribute("nowrap","true" );
      ((Element)v.get(136)).setAttribute("valign","bottom" );
      ((Element)v.get(131)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("A"));
      ((Element)v.get(137)).setAttribute("id","DescripcionLocalizationButton" );
      ((Element)v.get(137)).setAttribute("href","javascript:openLocalizationDialog('maeTipoVincuFrm', 'Descripcion', 1);" );
      ((Element)v.get(137)).setAttribute("onKeyDown","javascript:mmgImgEventDispatcherForFocus(event, 'ejecutarAccionFoco(\"maeTipoVincuFrm\",4, true)', 'ejecutarAccionFoco(\"maeTipoVincuFrm\",4, false)')" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("nombre","DescripcionLocalizationButton" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(138)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(138)).setAttribute("border","0" );
      ((Element)v.get(138)).setAttribute("width","21" );
      ((Element)v.get(138)).setAttribute("height","15" );
      ((Element)v.get(138)).setAttribute("class","main" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:131   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:139 / Elemento padre: 114   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(139)).setAttribute("nombre","DescripcionGapTdId" );
      ((Element)v.get(139)).setAttribute("nowrap","true" );
      ((Element)v.get(139)).setAttribute("class","datosCampos" );
      ((Element)v.get(114)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","25" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 114   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(141)).setAttribute("nombre","indRecoTdId" );
      ((Element)v.get(114)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(142)).setAttribute("width","100%" );
      ((Element)v.get(142)).setAttribute("border","0" );
      ((Element)v.get(142)).setAttribute("cellspacing","0" );
      ((Element)v.get(142)).setAttribute("cellpadding","0" );
      ((Element)v.get(142)).setAttribute("align","left" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(144)).setAttribute("valign","top" );
      ((Element)v.get(144)).setAttribute("height","13" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(145)).setAttribute("nombre","lblIndReco" );
      ((Element)v.get(145)).setAttribute("alto","13" );
      ((Element)v.get(145)).setAttribute("filas","1" );
      ((Element)v.get(145)).setAttribute("id","datosTitle" );
      ((Element)v.get(145)).setAttribute("cod","MaeTipoVincu.indReco.label" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:146 / Elemento padre: 142   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(146)).setAttribute("nombre","indRecoWidgetTrId" );
      ((Element)v.get(142)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(147)).setAttribute("align","left" );
      ((Element)v.get(147)).setAttribute("nowrap","true" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(148)).setAttribute("nombre","indReco" );
      ((Element)v.get(148)).setAttribute("tipo","H" );
      ((Element)v.get(148)).setAttribute("req","N" );
      ((Element)v.get(148)).setAttribute("id","datosCampos" );
      ((Element)v.get(148)).setAttribute("valor","" );
      ((Element)v.get(148)).setAttribute("disabled","" );
      ((Element)v.get(148)).setAttribute("ontab","ejecutarAccionFoco('maeTipoVincuFrm',5, true)" );
      ((Element)v.get(148)).setAttribute("onshtab","ejecutarAccionFoco('maeTipoVincuFrm',5, false)" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(149)).setAttribute("id","datosCampos" );
      ((Element)v.get(149)).setAttribute("valor","1" );
      ((Element)v.get(149)).setAttribute("cod","MaeTipoVincu.indReco.1.label" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Elemento padre:149 / Elemento actual: 150   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(149)).appendChild((Text)v.get(150));

      /* Termina nodo Texto:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 148   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(151)).setAttribute("id","datosCampos" );
      ((Element)v.get(151)).setAttribute("valor","0" );
      ((Element)v.get(151)).setAttribute("cod","MaeTipoVincu.indReco.0.label" );
      ((Element)v.get(148)).appendChild((Element)v.get(151));

      /* Elemento padre:151 / Elemento actual: 152   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(151)).appendChild((Text)v.get(152));

      /* Termina nodo Texto:152   */
      /* Termina nodo:151   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:153 / Elemento padre: 114   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(153)).setAttribute("nombre","indRecoGapTdId" );
      ((Element)v.get(153)).setAttribute("nowrap","true" );
      ((Element)v.get(153)).setAttribute("class","datosCampos" );
      ((Element)v.get(114)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","25" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 114   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(155)).setAttribute("width","100%" );
      ((Element)v.get(114)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:157 / Elemento padre: 109   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(157)).setAttribute("width","100%" );
      ((Element)v.get(109)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:109   */

      /* Empieza nodo:158 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(158)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(54)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(159)).setAttribute("align","center" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","8" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 158   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(158)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","8" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 158   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(163)).setAttribute("align","center" );
      ((Element)v.get(163)).setAttribute("width","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:158   */
      /* Termina nodo:54   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:165 / Elemento padre: 47   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(165)).setAttribute("align","center" );
      ((Element)v.get(165)).setAttribute("width","12" );
      ((Element)v.get(47)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","12" );
      ((Element)v.get(166)).setAttribute("height","12" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:47   */

      /* Empieza nodo:167 / Elemento padre: 39   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(167)).setAttribute("nombre","maeTipoVincuTrButtons" );
      ((Element)v.get(39)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(168)).setAttribute("align","center" );
      ((Element)v.get(168)).setAttribute("width","12" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","12" );
      ((Element)v.get(169)).setAttribute("height","12" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 167   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(167)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(172)).setAttribute("width","100%" );
      ((Element)v.get(172)).setAttribute("border","0" );
      ((Element)v.get(172)).setAttribute("align","center" );
      ((Element)v.get(172)).setAttribute("cellspacing","0" );
      ((Element)v.get(172)).setAttribute("cellpadding","0" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(174)).setAttribute("class","tablaTitle" );
      ((Element)v.get(174)).setAttribute("nombre","maeTipoVincuTdQueryButton" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(175)).setAttribute("nombre","maeTipoVincuQueryButton" );
      ((Element)v.get(175)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(175)).setAttribute("estado","false" );
      ((Element)v.get(175)).setAttribute("accion","maeTipoVincuFirstPage();" );
      ((Element)v.get(175)).setAttribute("tipo","html" );
      ((Element)v.get(175)).setAttribute("ID","botonContenido" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 173   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(176)).setAttribute("class","tablaTitle" );
      ((Element)v.get(176)).setAttribute("nombre","maeTipoVincuTdLovNullSelectionButton" );
      ((Element)v.get(176)).setAttribute("align","left" );
      ((Element)v.get(176)).setAttribute("width","100%" );
      ((Element)v.get(173)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(177)).setAttribute("width","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 176   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(178)).setAttribute("nombre","maeTipoVincuLovNullButton" );
      ((Element)v.get(178)).setAttribute("ID","botonContenido" );
      ((Element)v.get(178)).setAttribute("tipo","html" );
      ((Element)v.get(178)).setAttribute("accion","maeTipoVincuLovNullSelectionAction();" );
      ((Element)v.get(178)).setAttribute("estado","true" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(178)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(176)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:176   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:179 / Elemento padre: 167   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(179)).setAttribute("align","center" );
      ((Element)v.get(179)).setAttribute("width","12" );
      ((Element)v.get(167)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","12" );
      ((Element)v.get(180)).setAttribute("height","12" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */
      /* Termina nodo:167   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:181 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(181)).setAttribute("nombre","maeTipoVincuListLayer" );
      ((Element)v.get(181)).setAttribute("alto","310" );
      ((Element)v.get(181)).setAttribute("ancho","99%" );
      ((Element)v.get(181)).setAttribute("colorf","" );
      ((Element)v.get(181)).setAttribute("borde","0" );
      ((Element)v.get(181)).setAttribute("imagenf","" );
      ((Element)v.get(181)).setAttribute("repeat","" );
      ((Element)v.get(181)).setAttribute("padding","" );
      ((Element)v.get(181)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(181)).setAttribute("contravsb","" );
      ((Element)v.get(181)).setAttribute("x","3" );
      ((Element)v.get(181)).setAttribute("y","" );
      ((Element)v.get(181)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(182)).setAttribute("nombre","maeTipoVincuList" );
      ((Element)v.get(182)).setAttribute("ancho","680" );
      ((Element)v.get(182)).setAttribute("alto","275" );
      ((Element)v.get(182)).setAttribute("x","12" );
      ((Element)v.get(182)).setAttribute("y","0" );
      ((Element)v.get(182)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(182)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(183)).setAttribute("precarga","S" );
      ((Element)v.get(183)).setAttribute("conROver","S" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(184)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(184)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(184)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(184)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 183   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(185)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(185)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(185)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(185)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(183)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:183   */

      /* Empieza nodo:186 / Elemento padre: 182   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(182)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(187)).setAttribute("borde","1" );
      ((Element)v.get(187)).setAttribute("horizDatos","1" );
      ((Element)v.get(187)).setAttribute("horizCabecera","1" );
      ((Element)v.get(187)).setAttribute("vertical","1" );
      ((Element)v.get(187)).setAttribute("horizTitulo","1" );
      ((Element)v.get(187)).setAttribute("horizBase","1" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 186   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(188)).setAttribute("borde","#999999" );
      ((Element)v.get(188)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(188)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(188)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(188)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(188)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(188)).setAttribute("horizBase","#999999" );
      ((Element)v.get(186)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:186   */

      /* Empieza nodo:189 / Elemento padre: 182   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(189)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(189)).setAttribute("alto","22" );
      ((Element)v.get(189)).setAttribute("imgFondo","" );
      ((Element)v.get(189)).setAttribute("cod","00135" );
      ((Element)v.get(189)).setAttribute("ID","datosTitle" );
      ((Element)v.get(182)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 182   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(190)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(190)).setAttribute("alto","22" );
      ((Element)v.get(190)).setAttribute("imgFondo","" );
      ((Element)v.get(182)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 182   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(191)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(191)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(191)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(191)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(191)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(182)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("COL"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(192)).setAttribute("ancho","100" );
      ((Element)v.get(192)).setAttribute("minimizable","S" );
      ((Element)v.get(192)).setAttribute("minimizada","N" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 191   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("ancho","100" );
      ((Element)v.get(193)).setAttribute("minimizable","S" );
      ((Element)v.get(193)).setAttribute("minimizada","N" );
      ((Element)v.get(191)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 191   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("ancho","100" );
      ((Element)v.get(194)).setAttribute("minimizable","S" );
      ((Element)v.get(194)).setAttribute("minimizada","N" );
      ((Element)v.get(191)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:191   */

      /* Empieza nodo:195 / Elemento padre: 182   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(195)).setAttribute("height","20" );
      ((Element)v.get(195)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(195)).setAttribute("imgFondo","" );
      ((Element)v.get(195)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(182)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(196)).setAttribute("colFondo","" );
      ((Element)v.get(196)).setAttribute("ID","EstCab" );
      ((Element)v.get(196)).setAttribute("cod","MaeTipoVincu.codTipoVinc.label" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(197)).setAttribute("colFondo","" );
      ((Element)v.get(197)).setAttribute("ID","EstCab" );
      ((Element)v.get(197)).setAttribute("cod","MaeTipoVincu.Descripcion.label" );
      ((Element)v.get(195)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("colFondo","" );
      ((Element)v.get(198)).setAttribute("ID","EstCab" );
      ((Element)v.get(198)).setAttribute("cod","MaeTipoVincu.indReco.label" );
      ((Element)v.get(195)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:195   */

      /* Empieza nodo:199 / Elemento padre: 182   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(199)).setAttribute("alto","22" );
      ((Element)v.get(199)).setAttribute("accion","" );
      ((Element)v.get(199)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(199)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(199)).setAttribute("maxSel","1" );
      ((Element)v.get(199)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(199)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(199)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(199)).setAttribute("onLoad","" );
      ((Element)v.get(199)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(182)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(200)).setAttribute("tipo","texto" );
      ((Element)v.get(200)).setAttribute("ID","EstDat" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 199   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(201)).setAttribute("tipo","texto" );
      ((Element)v.get(201)).setAttribute("ID","EstDat2" );
      ((Element)v.get(199)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 199   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(202)).setAttribute("tipo","texto" );
      ((Element)v.get(202)).setAttribute("ID","EstDat" );
      ((Element)v.get(199)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:199   */

      /* Empieza nodo:203 / Elemento padre: 182   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(182)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:204 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(204)).setAttribute("nombre","maeTipoVincuListButtonsLayer" );
      ((Element)v.get(204)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(204)).setAttribute("alto","30" );
      ((Element)v.get(204)).setAttribute("ancho","98%" );
      ((Element)v.get(204)).setAttribute("borde","n" );
      ((Element)v.get(204)).setAttribute("imagenf","" );
      ((Element)v.get(204)).setAttribute("repeat","" );
      ((Element)v.get(204)).setAttribute("padding","0" );
      ((Element)v.get(204)).setAttribute("contravsb","" );
      ((Element)v.get(204)).setAttribute("x","16" );
      ((Element)v.get(204)).setAttribute("y","" );
      ((Element)v.get(204)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(205)).setAttribute("nombre","toolbarSeparatorLayer" );
      ((Element)v.get(205)).setAttribute("visibilidad","inherit" );
      ((Element)v.get(205)).setAttribute("alto","23" );
      ((Element)v.get(205)).setAttribute("ancho","1" );
      ((Element)v.get(205)).setAttribute("borde","1" );
      ((Element)v.get(205)).setAttribute("imagenf","" );
      ((Element)v.get(205)).setAttribute("repeat","" );
      ((Element)v.get(205)).setAttribute("padding","0" );
      ((Element)v.get(205)).setAttribute("contravsb","" );
      ((Element)v.get(205)).setAttribute("x","56" );
      ((Element)v.get(205)).setAttribute("y","0" );
      ((Element)v.get(205)).setAttribute("zindex","" );
      ((Element)v.get(205)).setAttribute("colborde","#999999" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 204   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(206)).setAttribute("width","100%" );
      ((Element)v.get(206)).setAttribute("border","0" );
      ((Element)v.get(206)).setAttribute("cellspacing","1" );
      ((Element)v.get(206)).setAttribute("cellpadding","0" );
      ((Element)v.get(204)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("height","22" );
      ((Element)v.get(208)).setAttribute("width","5" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 206   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(206)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(210)).setAttribute("nombre","maeTipoVincuPaginationButtonBar" );
      ((Element)v.get(210)).setAttribute("tipo","H" );
      ((Element)v.get(210)).setAttribute("x","0" );
      ((Element)v.get(210)).setAttribute("y","0" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(211)).setAttribute("nombre","maeTipoVincuFirstPageButton" );
      ((Element)v.get(211)).setAttribute("funcion","maeTipoVincuFirstPage();" );
      ((Element)v.get(211)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(211)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(211)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(211)).setAttribute("estado","inactivo" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 210   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(212)).setAttribute("nombre","maeTipoVincuFirstPageButtonGapTd" );
      ((Element)v.get(210)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).setAttribute("height","8" );
      ((Element)v.get(213)).setAttribute("width","5" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 210   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(214)).setAttribute("nombre","maeTipoVincuPreviousPageButton" );
      ((Element)v.get(214)).setAttribute("funcion","maeTipoVincuPreviousPage();" );
      ((Element)v.get(214)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(214)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(214)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(214)).setAttribute("estado","inactivo" );
      ((Element)v.get(210)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 210   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(215)).setAttribute("nombre","maeTipoVincuPreviousPageButtonGapTd" );
      ((Element)v.get(210)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(216)).setAttribute("width","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 210   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(217)).setAttribute("nombre","maeTipoVincuNextPageButton" );
      ((Element)v.get(217)).setAttribute("funcion","maeTipoVincuNextPage();" );
      ((Element)v.get(217)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(217)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(217)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(217)).setAttribute("estado","inactivo" );
      ((Element)v.get(210)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:218 / Elemento padre: 206   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(206)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("height","22" );
      ((Element)v.get(219)).setAttribute("width","19" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 206   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(220)).setAttribute("class","tablaTitle" );
      ((Element)v.get(220)).setAttribute("nombre","maeTipoVincuUpdateButtonTd" );
      ((Element)v.get(206)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(221)).setAttribute("nombre","maeTipoVincuUpdateButton" );
      ((Element)v.get(221)).setAttribute("ID","botonContenido" );
      ((Element)v.get(221)).setAttribute("tipo","html" );
      ((Element)v.get(221)).setAttribute("accion","maeTipoVincuUpdateSelection();" );
      ((Element)v.get(221)).setAttribute("estado","false" );
      ((Element)v.get(221)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 206   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(222)).setAttribute("nombre","maeTipoVincuUpdateButtonGapTd" );
      ((Element)v.get(206)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(223)).setAttribute("width","10" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 206   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(224)).setAttribute("class","tablaTitle" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(224)).setAttribute("nombre","maeTipoVincuViewForRemoveButtonTd" );
      ((Element)v.get(206)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(225)).setAttribute("nombre","maeTipoVincuViewForRemoveButton" );
      ((Element)v.get(225)).setAttribute("ID","botonContenido" );
      ((Element)v.get(225)).setAttribute("tipo","html" );
      ((Element)v.get(225)).setAttribute("accion","maeTipoVincuViewSelection();" );
      ((Element)v.get(225)).setAttribute("estado","false" );
      ((Element)v.get(225)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 206   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(226)).setAttribute("nombre","maeTipoVincuViewForRemoveButtonGapTd" );
      ((Element)v.get(206)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(227)).setAttribute("width","10" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 206   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(228)).setAttribute("class","tablaTitle" );
      ((Element)v.get(228)).setAttribute("nombre","maeTipoVincuLovSelectButtonTd" );
      ((Element)v.get(206)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(229)).setAttribute("nombre","maeTipoVincuLovSelectButton" );
      ((Element)v.get(229)).setAttribute("ID","botonContenido" );
      ((Element)v.get(229)).setAttribute("tipo","html" );
      ((Element)v.get(229)).setAttribute("accion","maeTipoVincuLovSelectionAction();" );
      ((Element)v.get(229)).setAttribute("estado","true" );
      ((Element)v.get(229)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 206   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(230)).setAttribute("nombre","maeTipoVincuLovSelectButtonGapTd" );
      ((Element)v.get(206)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(231)).setAttribute("width","10" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 206   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(232)).setAttribute("class","tablaTitle" );
      ((Element)v.get(232)).setAttribute("nombre","maeTipoVincuViewButtonTd" );
      ((Element)v.get(206)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(233)).setAttribute("nombre","maeTipoVincuViewButton" );
      ((Element)v.get(233)).setAttribute("ID","botonContenido" );
      ((Element)v.get(233)).setAttribute("tipo","html" );
      ((Element)v.get(233)).setAttribute("accion","maeTipoVincuViewSelection();" );
      ((Element)v.get(233)).setAttribute("estado","false" );
      ((Element)v.get(233)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 206   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(234)).setAttribute("nombre","maeTipoVincuViewButtonGapTd" );
      ((Element)v.get(206)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(235)).setAttribute("width","10" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 206   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(236)).setAttribute("width","100%" );
      ((Element)v.get(206)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:206   */
      /* Termina nodo:204   */
      /* Termina nodo:5   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_linea_armado_insertar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_linea_armado_insertar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","contenido_linea_armado_insertar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtLongitudNroEtiqueta" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("group","validacion1" );
      ((Element)v.get(8)).setAttribute("cod","2920" );
      ((Element)v.get(8)).setAttribute("format","e" );
      ((Element)v.get(8)).setAttribute("min","1" );
      ((Element)v.get(8)).setAttribute("max","9" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbCentroDistribucion" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("group","validacion1" );
      ((Element)v.get(9)).setAttribute("cod","2054" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtDescripcion" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("group","validacion1" );
      ((Element)v.get(10)).setAttribute("cod","MMGGlobal.localization.description.label" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbProgramaCubicaje" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("group","validacion1" );
      ((Element)v.get(11)).setAttribute("cod","2919" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbTiposSolicitudConsolidado" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("group","validacion1" );
      ((Element)v.get(12)).setAttribute("cod","1470" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","txtNumeroEtiquetasAFP" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("group","validacion2" );
      ((Element)v.get(13)).setAttribute("cod","2924" );
      ((Element)v.get(13)).setAttribute("format","e" );
      ((Element)v.get(13)).setAttribute("min","0" );
      ((Element)v.get(13)).setAttribute("max","99" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:7   */

      /* Empieza nodo:14 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(14)).setAttribute("nombre","formulario" );
      ((Element)v.get(14)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","accion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(18)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(14)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hPais" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hDeshabilitar" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","casoUso" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hEliminados" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hlstTipoSolicitudConsolidado" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hlstUsuariosAlarmaProd" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hListaUsuarios" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hOidsSolicitudEliminados" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hOidsUsuariosEliminados" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hValorDefecto" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hDefecto" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","htxtLineaArmado" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hOidLinea" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hOidDescripcionCD" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hDescripcion" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hImprimir" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hLineaAFP" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hPrograma" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hLongitud" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hEtiquetas" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(41)).setAttribute("nombre","hNumEtiquetas" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(42)).setAttribute("nombre","capa1" );
      ((Element)v.get(14)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("table"));
      ((Element)v.get(43)).setAttribute("width","100%" );
      ((Element)v.get(43)).setAttribute("border","0" );
      ((Element)v.get(43)).setAttribute("cellspacing","0" );
      ((Element)v.get(43)).setAttribute("cellpadding","0" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).setAttribute("width","12" );
      ((Element)v.get(45)).setAttribute("align","center" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","12" );
      ((Element)v.get(46)).setAttribute("height","12" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("width","750" );
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("width","12" );
      ((Element)v.get(44)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","12" );
      ((Element)v.get(50)).setAttribute("height","1" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:44   */

      /* Empieza nodo:51 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(56)).setAttribute("class","legend" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(57)).setAttribute("nombre","lblDatosDeAlta" );
      ((Element)v.get(57)).setAttribute("alto","13" );
      ((Element)v.get(57)).setAttribute("filas","1" );
      ((Element)v.get(57)).setAttribute("cod","00127" );
      ((Element)v.get(57)).setAttribute("id","legend" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("table"));
      ((Element)v.get(58)).setAttribute("width","100%" );
      ((Element)v.get(58)).setAttribute("border","0" );
      ((Element)v.get(58)).setAttribute("align","center" );
      ((Element)v.get(58)).setAttribute("cellspacing","0" );
      ((Element)v.get(58)).setAttribute("cellpadding","0" );
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("colspan","4" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","8" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:62 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(66)).setAttribute("nombre","lblCentroDistribucion" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("filas","1" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(66)).setAttribute("id","datosTitle" );
      ((Element)v.get(66)).setAttribute("cod","2054" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","25" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(70)).setAttribute("nombre","lblLineaArmado" );
      ((Element)v.get(70)).setAttribute("alto","13" );
      ((Element)v.get(70)).setAttribute("filas","1" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(70)).setAttribute("id","datosTitle" );
      ((Element)v.get(70)).setAttribute("cod","2095" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
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
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(74)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("filas","1" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(74)).setAttribute("id","datosTitle" );
      ((Element)v.get(74)).setAttribute("cod","MMGGlobal.localization.description.label" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","100%" );
      ((Element)v.get(62)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:62   */

      /* Empieza nodo:77 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(77)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(81)).setAttribute("nombre","cbCentroDistribucion" );
      ((Element)v.get(81)).setAttribute("id","datosCampos" );
      ((Element)v.get(81)).setAttribute("size","1" );
      ((Element)v.get(81)).setAttribute("multiple","N" );
      ((Element)v.get(81)).setAttribute("req","S" );
      ((Element)v.get(81)).setAttribute("onchange","" );
      ((Element)v.get(81)).setAttribute("ontab","onTab('cbCentroDistribucion');" );
      ((Element)v.get(81)).setAttribute("onshtab","onShTab('cbCentroDistribucion');" );
      ((Element)v.get(81)).setAttribute("valorinicial","" );
      ((Element)v.get(81)).setAttribute("textoinicial","" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:83 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","25" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(77)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(86)).setAttribute("nombre","txtLineaArmado" );
      ((Element)v.get(86)).setAttribute("id","datosCampos" );
      ((Element)v.get(86)).setAttribute("max","2" );
      ((Element)v.get(86)).setAttribute("tipo","" );
      ((Element)v.get(86)).setAttribute("onchange","" );
      ((Element)v.get(86)).setAttribute("ontab","onTab('txtLineaArmado');" );
      ((Element)v.get(86)).setAttribute("onshtab","onShTab('txtLineaArmado');" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(86)).setAttribute("req","N" );
      ((Element)v.get(86)).setAttribute("size","2" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(86)).setAttribute("validacion","" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","25" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(77)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(90)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(90)).setAttribute("id","datosCampos" );
      ((Element)v.get(90)).setAttribute("max","25" );
      ((Element)v.get(90)).setAttribute("tipo","" );
      ((Element)v.get(90)).setAttribute("onchange","" );
      ((Element)v.get(90)).setAttribute("ontab","onTab('txtDescripcion');" );
      ((Element)v.get(90)).setAttribute("onshtab","onShTab('txtDescripcion');" );
      ((Element)v.get(90)).setAttribute("req","S" );
      ((Element)v.get(90)).setAttribute("size","25" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(90)).setAttribute("validacion","" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(91)).setAttribute("width","21" );
      ((Element)v.get(91)).setAttribute("height","15" );
      ((Element)v.get(91)).setAttribute("onclick","levantarI18N('formulario','1');" );
      ((Element)v.get(89)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:89   */

      /* Empieza nodo:92 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("width","100%" );
      ((Element)v.get(77)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:77   */

      /* Empieza nodo:94 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("colspan","4" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:58   */

      /* Empieza nodo:97 / Elemento padre: 55   */
      v.add(doc.createElement("table"));
      ((Element)v.get(97)).setAttribute("width","100%" );
      ((Element)v.get(97)).setAttribute("border","0" );
      ((Element)v.get(97)).setAttribute("align","center" );
      ((Element)v.get(97)).setAttribute("cellspacing","0" );
      ((Element)v.get(97)).setAttribute("cellpadding","0" );
      ((Element)v.get(55)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(102)).setAttribute("nombre","lblProgramaCubicaje" );
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("filas","1" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(102)).setAttribute("id","datosTitle" );
      ((Element)v.get(102)).setAttribute("cod","2919" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","25" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(106)).setAttribute("nombre","lblLongitudNroEtiqueta" );
      ((Element)v.get(106)).setAttribute("alto","13" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(106)).setAttribute("filas","1" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(106)).setAttribute("id","datosTitle" );
      ((Element)v.get(106)).setAttribute("cod","2920" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("width","100%" );
      ((Element)v.get(98)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:98   */

      /* Empieza nodo:109 / Elemento padre: 97   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(97)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","8" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(109)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(113)).setAttribute("nombre","cbProgramaCubicaje" );
      ((Element)v.get(113)).setAttribute("id","datosCampos" );
      ((Element)v.get(113)).setAttribute("size","1" );
      ((Element)v.get(113)).setAttribute("multiple","N" );
      ((Element)v.get(113)).setAttribute("req","S" );
      ((Element)v.get(113)).setAttribute("onchange","" );
      ((Element)v.get(113)).setAttribute("ontab","onTab('cbProgramaCubicaje');" );
      ((Element)v.get(113)).setAttribute("onshtab","onShTab('cbProgramaCubicaje');" );
      ((Element)v.get(113)).setAttribute("valorinicial","" );
      ((Element)v.get(113)).setAttribute("textoinicial","" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:115 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","25" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(109)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(118)).setAttribute("nombre","txtLongitudNroEtiqueta" );
      ((Element)v.get(118)).setAttribute("id","datosCampos" );
      ((Element)v.get(118)).setAttribute("max","1" );
      ((Element)v.get(118)).setAttribute("tipo","" );
      ((Element)v.get(118)).setAttribute("onchange","" );
      ((Element)v.get(118)).setAttribute("ontab","onTab('txtLongitudNroEtiqueta');" );
      ((Element)v.get(118)).setAttribute("onshtab","onShTab('txtLongitudNroEtiqueta');" );
      ((Element)v.get(118)).setAttribute("req","S" );
      ((Element)v.get(118)).setAttribute("size","2" );
      ((Element)v.get(118)).setAttribute("valor","" );
      ((Element)v.get(118)).setAttribute("validacion","" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","25" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:109   */

      /* Empieza nodo:121 / Elemento padre: 97   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(97)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("colspan","4" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:97   */

      /* Empieza nodo:124 / Elemento padre: 55   */
      v.add(doc.createElement("table"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(124)).setAttribute("border","0" );
      ((Element)v.get(124)).setAttribute("align","center" );
      ((Element)v.get(124)).setAttribute("cellspacing","0" );
      ((Element)v.get(124)).setAttribute("cellpadding","0" );
      ((Element)v.get(55)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(129)).setAttribute("nombre","lblTiposSolicitudConsolidado" );
      ((Element)v.get(129)).setAttribute("alto","13" );
      ((Element)v.get(129)).setAttribute("filas","1" );
      ((Element)v.get(129)).setAttribute("valor","" );
      ((Element)v.get(129)).setAttribute("id","datosTitle" );
      ((Element)v.get(129)).setAttribute("cod","3123" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","25" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(133)).setAttribute("nombre","lblLineaAFP" );
      ((Element)v.get(133)).setAttribute("alto","13" );
      ((Element)v.get(133)).setAttribute("filas","1" );
      ((Element)v.get(133)).setAttribute("valor","" );
      ((Element)v.get(133)).setAttribute("id","datosTitle" );
      ((Element)v.get(133)).setAttribute("cod","2922" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("width","100%" );
      ((Element)v.get(125)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:125   */

      /* Empieza nodo:136 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(136)).setAttribute("valign","top" );
      ((Element)v.get(124)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(136)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(140)).setAttribute("nombre","cbTiposSolicitudConsolidado" );
      ((Element)v.get(140)).setAttribute("id","datosCampos" );
      ((Element)v.get(140)).setAttribute("size","4" );
      ((Element)v.get(140)).setAttribute("multiple","S" );
      ((Element)v.get(140)).setAttribute("req","S" );
      ((Element)v.get(140)).setAttribute("onmouseover","return false;" );
      ((Element)v.get(140)).setAttribute("onclick","onClickTSL();" );
      ((Element)v.get(140)).setAttribute("onchange","onChangeTSL();" );
      ((Element)v.get(140)).setAttribute("onfocus","onFocusTSL();" );
      ((Element)v.get(140)).setAttribute("ontab","onTab('cbTiposSolicitudConsolidado');" );
      ((Element)v.get(140)).setAttribute("onshtab","onShTab('cbTiposSolicitudConsolidado');" );
      ((Element)v.get(140)).setAttribute("valorinicial","" );
      ((Element)v.get(140)).setAttribute("textoinicial","" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:142 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","25" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(136)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(145)).setAttribute("nombre","chkLineaAFP" );
      ((Element)v.get(145)).setAttribute("id","datosCampos" );
      ((Element)v.get(145)).setAttribute("onclick","onClickChkLineaAFP();" );
      ((Element)v.get(145)).setAttribute("check","N" );
      ((Element)v.get(145)).setAttribute("ontab","onTab('chkLineaAFP');" );
      ((Element)v.get(145)).setAttribute("onshtab","onShTab('chkLineaAFP');" );
      ((Element)v.get(145)).setAttribute("req","N" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(146)).setAttribute("width","100%" );
      ((Element)v.get(136)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:136   */

      /* Empieza nodo:148 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("colspan","4" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:124   */

      /* Empieza nodo:151 / Elemento padre: 55   */
      v.add(doc.createElement("table"));
      ((Element)v.get(151)).setAttribute("width","100%" );
      ((Element)v.get(151)).setAttribute("border","0" );
      ((Element)v.get(151)).setAttribute("align","center" );
      ((Element)v.get(151)).setAttribute("cellspacing","0" );
      ((Element)v.get(151)).setAttribute("cellpadding","0" );
      ((Element)v.get(55)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","8" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(156)).setAttribute("nombre","lblNumeroEtiquetasAFP" );
      ((Element)v.get(156)).setAttribute("alto","13" );
      ((Element)v.get(156)).setAttribute("filas","1" );
      ((Element)v.get(156)).setAttribute("valor","" );
      ((Element)v.get(156)).setAttribute("id","datosTitle" );
      ((Element)v.get(156)).setAttribute("cod","3125" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("width","100%" );
      ((Element)v.get(152)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","8" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:152   */

      /* Empieza nodo:159 / Elemento padre: 151   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(151)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","8" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(159)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(163)).setAttribute("nombre","txtNumeroEtiquetasAFP" );
      ((Element)v.get(163)).setAttribute("id","datosCampos" );
      ((Element)v.get(163)).setAttribute("max","2" );
      ((Element)v.get(163)).setAttribute("tipo","" );
      ((Element)v.get(163)).setAttribute("onchange","" );
      ((Element)v.get(163)).setAttribute("ontab","onTab('txtNumeroEtiquetasAFP');" );
      ((Element)v.get(163)).setAttribute("onshtab","onShTab('txtNumeroEtiquetasAFP');" );
      ((Element)v.get(163)).setAttribute("req","S" );
      ((Element)v.get(163)).setAttribute("size","2" );
      ((Element)v.get(163)).setAttribute("valor","" );
      ((Element)v.get(163)).setAttribute("validacion","" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("width","100%" );
      ((Element)v.get(159)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","8" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:159   */

      /* Empieza nodo:166 / Elemento padre: 151   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(151)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("colspan","4" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:151   */

      /* Empieza nodo:169 / Elemento padre: 55   */
      v.add(doc.createElement("table"));
      ((Element)v.get(169)).setAttribute("width","100%" );
      ((Element)v.get(169)).setAttribute("border","0" );
      ((Element)v.get(169)).setAttribute("align","center" );
      ((Element)v.get(169)).setAttribute("cellspacing","0" );
      ((Element)v.get(169)).setAttribute("cellpadding","0" );
      ((Element)v.get(55)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(174)).setAttribute("nombre","lblLineaDefault" );
      ((Element)v.get(174)).setAttribute("alto","13" );
      ((Element)v.get(174)).setAttribute("filas","1" );
      ((Element)v.get(174)).setAttribute("valor","" );
      ((Element)v.get(174)).setAttribute("id","datosTitle" );
      ((Element)v.get(174)).setAttribute("cod","3038" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).setAttribute("width","100%" );
      ((Element)v.get(170)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:170   */

      /* Empieza nodo:177 / Elemento padre: 169   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(169)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(177)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(181)).setAttribute("nombre","chkLineaDefault" );
      ((Element)v.get(181)).setAttribute("id","datosCampos" );
      ((Element)v.get(181)).setAttribute("onclick","" );
      ((Element)v.get(181)).setAttribute("check","N" );
      ((Element)v.get(181)).setAttribute("ontab","onTab('chkLineaDefault');" );
      ((Element)v.get(181)).setAttribute("onshtab","onShTab('chkLineaDefault');" );
      ((Element)v.get(181)).setAttribute("req","N" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).setAttribute("width","100%" );
      ((Element)v.get(177)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","8" );
      ((Element)v.get(183)).setAttribute("height","8" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:177   */

      /* Empieza nodo:184 / Elemento padre: 169   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(169)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).setAttribute("colspan","4" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","8" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:169   */

      /* Empieza nodo:187 / Elemento padre: 55   */
      v.add(doc.createElement("table"));
      ((Element)v.get(187)).setAttribute("width","100%" );
      ((Element)v.get(187)).setAttribute("border","0" );
      ((Element)v.get(187)).setAttribute("height","330" );
      ((Element)v.get(187)).setAttribute("align","center" );
      ((Element)v.get(187)).setAttribute("cellspacing","0" );
      ((Element)v.get(187)).setAttribute("cellpadding","0" );
      ((Element)v.get(55)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).setAttribute("colspan","4" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","8" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:51   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:191 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(191)).setAttribute("nombre","capaLista" );
      ((Element)v.get(191)).setAttribute("ancho","100%" );
      ((Element)v.get(191)).setAttribute("alto","330" );
      ((Element)v.get(191)).setAttribute("x","16" );
      ((Element)v.get(191)).setAttribute("y","290" );
      ((Element)v.get(191)).setAttribute("colorf","" );
      ((Element)v.get(191)).setAttribute("borde","0" );
      ((Element)v.get(191)).setAttribute("imagenf","" );
      ((Element)v.get(191)).setAttribute("repeat","" );
      ((Element)v.get(191)).setAttribute("padding","" );
      ((Element)v.get(191)).setAttribute("visibilidad","" );
      ((Element)v.get(191)).setAttribute("contravsb","" );
      ((Element)v.get(191)).setAttribute("zindex","" );
      ((Element)v.get(14)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(192)).setAttribute("nombre","listado1" );
      ((Element)v.get(192)).setAttribute("ancho","369" );
      ((Element)v.get(192)).setAttribute("alto","301" );
      ((Element)v.get(192)).setAttribute("x","10" );
      ((Element)v.get(192)).setAttribute("y","0" );
      ((Element)v.get(192)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(192)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(192)).setAttribute("pintadoSimplificado","S" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(193)).setAttribute("precarga","S" );
      ((Element)v.get(193)).setAttribute("conROver","S" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(194)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(194)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(194)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(194)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 193   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(195)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(195)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(195)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(195)).setAttribute("aximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(193)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 193   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(196)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(196)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(193)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:193   */

      /* Empieza nodo:197 / Elemento padre: 192   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(192)).appendChild((Element)v.get(197));

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

      /* Empieza nodo:200 / Elemento padre: 192   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(200)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(200)).setAttribute("alto","22" );
      ((Element)v.get(200)).setAttribute("imgFondo","" );
      ((Element)v.get(200)).setAttribute("cod","2921" );
      ((Element)v.get(200)).setAttribute("ID","datosTitle" );
      ((Element)v.get(192)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 192   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(201)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(201)).setAttribute("alto","22" );
      ((Element)v.get(201)).setAttribute("imgFondo","" );
      ((Element)v.get(192)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 192   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(202)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(202)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(202)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(202)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(202)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(202)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(192)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(203)).setAttribute("ancho","100" );
      ((Element)v.get(203)).setAttribute("minimizable","S" );
      ((Element)v.get(203)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 192   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(204)).setAttribute("alto","25" );
      ((Element)v.get(204)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(204)).setAttribute("imgFondo","" );
      ((Element)v.get(204)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(192)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(205)).setAttribute("colFondo","" );
      ((Element)v.get(205)).setAttribute("ID","EstCab" );
      ((Element)v.get(205)).setAttribute("cod","55" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Elemento padre:205 / Elemento actual: 206   */
      v.add(doc.createTextNode("Mail"));
      ((Element)v.get(205)).appendChild((Text)v.get(206));

      /* Termina nodo Texto:206   */
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:207 / Elemento padre: 192   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(207)).setAttribute("alto","22" );
      ((Element)v.get(207)).setAttribute("accion","" );
      ((Element)v.get(207)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(207)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(207)).setAttribute("maxSel","-1" );
      ((Element)v.get(207)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(207)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(207)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(207)).setAttribute("onLoad","" );
      ((Element)v.get(207)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(192)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(208)).setAttribute("nombre","txtMail" );
      ((Element)v.get(208)).setAttribute("size","25" );
      ((Element)v.get(208)).setAttribute("max","50" );
      ((Element)v.get(208)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(208)).setAttribute("ID","EstDat" );
      ((Element)v.get(208)).setAttribute("onchange","txtMailOnChange(this);" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 192   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(192)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:192   */

      /* Empieza nodo:210 / Elemento padre: 191   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(210)).setAttribute("nombre","btnAnyadir" );
      ((Element)v.get(210)).setAttribute("x","15" );
      ((Element)v.get(210)).setAttribute("y","279" );
      ((Element)v.get(210)).setAttribute("ID","botonContenido" );
      ((Element)v.get(210)).setAttribute("tipo","html" );
      ((Element)v.get(210)).setAttribute("estado","false" );
      ((Element)v.get(210)).setAttribute("cod","MMGGlobal.localization.addbutton.label" );
      ((Element)v.get(210)).setAttribute("ontab","onTab('btnAnyadir');" );
      ((Element)v.get(210)).setAttribute("onshtab","onShTab('btnAnyadir');" );
      ((Element)v.get(210)).setAttribute("accion","onClickAnyadirUsuarioAlarma();" );
      ((Element)v.get(191)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 191   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(211)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(211)).setAttribute("x","75" );
      ((Element)v.get(211)).setAttribute("y","279" );
      ((Element)v.get(211)).setAttribute("ID","botonContenido" );
      ((Element)v.get(211)).setAttribute("tipo","html" );
      ((Element)v.get(211)).setAttribute("estado","false" );
      ((Element)v.get(211)).setAttribute("cod","MMGGlobal.localization.removebutton.label" );
      ((Element)v.get(211)).setAttribute("ontab","onTab('btnEliminar');" );
      ((Element)v.get(211)).setAttribute("onshtab","onShTab('btnEliminar');" );
      ((Element)v.get(211)).setAttribute("accion","onClickEliminarUsuarioAlarma();" );
      ((Element)v.get(191)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:191   */

      /* Empieza nodo:212 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(212)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(212)).setAttribute("alto","12" );
      ((Element)v.get(212)).setAttribute("ancho","100%" );
      ((Element)v.get(212)).setAttribute("colorf","" );
      ((Element)v.get(212)).setAttribute("borde","0" );
      ((Element)v.get(212)).setAttribute("imagenf","" );
      ((Element)v.get(212)).setAttribute("repeat","" );
      ((Element)v.get(212)).setAttribute("padding","" );
      ((Element)v.get(212)).setAttribute("visibilidad","visible" );
      ((Element)v.get(212)).setAttribute("contravsb","" );
      ((Element)v.get(212)).setAttribute("x","0" );
      ((Element)v.get(212)).setAttribute("y","428" );
      ((Element)v.get(212)).setAttribute("zindex","" );
      ((Element)v.get(14)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:14   */


   }

}

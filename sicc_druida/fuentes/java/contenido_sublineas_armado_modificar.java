
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_sublineas_armado_modificar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_sublineas_armado_modificar" );
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
      ((Element)v.get(3)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","contenido_sublineas_armado_modificar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","formulario" );
      ((Element)v.get(7)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","idioma" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","pais" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","accion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hOidCentroDistribucionDefecto" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hOidsLineasArmadoDefecto" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hCbCentroDistribucion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hCbLineaArmado" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hCbSistemaPicado" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hCbLetraAnaquel" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hTxtCodigoSublinea" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hTxtDescripcion" );
      ((Element)v.get(22)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(7)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(23)).setAttribute("nombre","capa1" );
      ((Element)v.get(7)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("table"));
      ((Element)v.get(24)).setAttribute("width","100%" );
      ((Element)v.get(24)).setAttribute("border","0" );
      ((Element)v.get(24)).setAttribute("cellspacing","0" );
      ((Element)v.get(24)).setAttribute("cellpadding","0" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(26)).setAttribute("align","center" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(27)).setAttribute("height","12" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).setAttribute("width","750" );
      ((Element)v.get(25)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).setAttribute("width","12" );
      ((Element)v.get(25)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).setAttribute("width","12" );
      ((Element)v.get(31)).setAttribute("height","1" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */
      /* Termina nodo:25   */

      /* Empieza nodo:32 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(34)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(37)).setAttribute("class","legend" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(38)).setAttribute("nombre","lblCriterioDeBusqueda" );
      ((Element)v.get(38)).setAttribute("alto","13" );
      ((Element)v.get(38)).setAttribute("filas","1" );
      ((Element)v.get(38)).setAttribute("cod","MMGGlobal.legend.searchcriteria.label" );
      ((Element)v.get(38)).setAttribute("id","legend" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("table"));
      ((Element)v.get(39)).setAttribute("width","100%" );
      ((Element)v.get(39)).setAttribute("border","0" );
      ((Element)v.get(39)).setAttribute("align","center" );
      ((Element)v.get(39)).setAttribute("cellspacing","0" );
      ((Element)v.get(39)).setAttribute("cellpadding","0" );
      ((Element)v.get(36)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("colspan","4" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","8" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:43 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","8" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblCentroDistribucion" );
      ((Element)v.get(47)).setAttribute("alto","13" );
      ((Element)v.get(47)).setAttribute("filas","1" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(47)).setAttribute("id","datosTitle" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("cod","2054" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","25" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(51)).setAttribute("nombre","lblLineaArmado" );
      ((Element)v.get(51)).setAttribute("alto","13" );
      ((Element)v.get(51)).setAttribute("filas","1" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(51)).setAttribute("id","datosTitle" );
      ((Element)v.get(51)).setAttribute("cod","2095" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("width","100%" );
      ((Element)v.get(43)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","8" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:43   */

      /* Empieza nodo:54 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(54)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(58)).setAttribute("nombre","cbCentroDistribucion" );
      ((Element)v.get(58)).setAttribute("id","datosCampos" );
      ((Element)v.get(58)).setAttribute("size","1" );
      ((Element)v.get(58)).setAttribute("multiple","N" );
      ((Element)v.get(58)).setAttribute("req","N" );
      ((Element)v.get(58)).setAttribute("onchange","onChangeCbCentroDistribucion();" );
      ((Element)v.get(58)).setAttribute("ontab","tab('cbCentroDistribucion')" );
      ((Element)v.get(58)).setAttribute("onshtab","shtab('cbCentroDistribucion')" );
      ((Element)v.get(58)).setAttribute("valorinicial","" );
      ((Element)v.get(58)).setAttribute("textoinicial","" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:60 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","25" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(54)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(63)).setAttribute("nombre","cbLineaArmado" );
      ((Element)v.get(63)).setAttribute("id","datosCampos" );
      ((Element)v.get(63)).setAttribute("size","1" );
      ((Element)v.get(63)).setAttribute("multiple","N" );
      ((Element)v.get(63)).setAttribute("req","N" );
      ((Element)v.get(63)).setAttribute("onchange","" );
      ((Element)v.get(63)).setAttribute("ontab","tab('cbLineaArmado')" );
      ((Element)v.get(63)).setAttribute("onshtab","shtab('cbLineaArmado')" );
      ((Element)v.get(63)).setAttribute("valorinicial","" );
      ((Element)v.get(63)).setAttribute("textoinicial","" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:65 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","100%" );
      ((Element)v.get(54)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","8" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:54   */

      /* Empieza nodo:67 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("colspan","4" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","8" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:39   */

      /* Empieza nodo:70 / Elemento padre: 36   */
      v.add(doc.createElement("table"));
      ((Element)v.get(70)).setAttribute("width","100%" );
      ((Element)v.get(70)).setAttribute("border","0" );
      ((Element)v.get(70)).setAttribute("align","center" );
      ((Element)v.get(70)).setAttribute("cellspacing","0" );
      ((Element)v.get(70)).setAttribute("cellpadding","0" );
      ((Element)v.get(36)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","8" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(75)).setAttribute("nombre","lblCodigoSublinea" );
      ((Element)v.get(75)).setAttribute("alto","13" );
      ((Element)v.get(75)).setAttribute("filas","1" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(75)).setAttribute("id","datosTitle" );
      ((Element)v.get(75)).setAttribute("cod","2929" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","25" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(79)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(79)).setAttribute("alto","13" );
      ((Element)v.get(79)).setAttribute("filas","1" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(79)).setAttribute("id","datosTitle" );
      ((Element)v.get(79)).setAttribute("cod","MMGGlobal.localization.description.label" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","25" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(83)).setAttribute("nombre","lblSistemaPicado" );
      ((Element)v.get(83)).setAttribute("alto","13" );
      ((Element)v.get(83)).setAttribute("filas","1" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(83)).setAttribute("id","datosTitle" );
      ((Element)v.get(83)).setAttribute("cod","3039" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","25" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(87)).setAttribute("nombre","lblLetraAnaquel" );
      ((Element)v.get(87)).setAttribute("alto","13" );
      ((Element)v.get(87)).setAttribute("filas","1" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(87)).setAttribute("id","datosTitle" );
      ((Element)v.get(87)).setAttribute("cod","2957" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","25" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(71)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(91)).setAttribute("nombre","lblCodigoImpresora" );
      ((Element)v.get(91)).setAttribute("alto","13" );
      ((Element)v.get(91)).setAttribute("filas","1" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(91)).setAttribute("id","datosTitle" );
      ((Element)v.get(91)).setAttribute("cod","3138" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("width","100%" );
      ((Element)v.get(71)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:71   */

      /* Empieza nodo:94 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(94)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(98)).setAttribute("nombre","txtCodigoSublinea" );
      ((Element)v.get(98)).setAttribute("id","datosCampos" );
      ((Element)v.get(98)).setAttribute("max","2" );
      ((Element)v.get(98)).setAttribute("tipo","" );
      ((Element)v.get(98)).setAttribute("onchange","" );
      ((Element)v.get(98)).setAttribute("ontab","tab('txtCodigoSublinea')" );
      ((Element)v.get(98)).setAttribute("onshtab","shtab('txtCodigoSublinea')" );
      ((Element)v.get(98)).setAttribute("req","N" );
      ((Element)v.get(98)).setAttribute("size","2" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(98)).setAttribute("validacion","" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","25" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(94)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(102)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(102)).setAttribute("id","datosCampos" );
      ((Element)v.get(102)).setAttribute("max","25" );
      ((Element)v.get(102)).setAttribute("tipo","" );
      ((Element)v.get(102)).setAttribute("onchange","" );
      ((Element)v.get(102)).setAttribute("ontab","tab('txtDescripcion')" );
      ((Element)v.get(102)).setAttribute("onshtab","shtab('txtDescripcion')" );
      ((Element)v.get(102)).setAttribute("req","N" );
      ((Element)v.get(102)).setAttribute("size","25" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(102)).setAttribute("validacion","" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(94)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(106)).setAttribute("nombre","cbSistemaPicado" );
      ((Element)v.get(106)).setAttribute("id","datosCampos" );
      ((Element)v.get(106)).setAttribute("size","1" );
      ((Element)v.get(106)).setAttribute("multiple","N" );
      ((Element)v.get(106)).setAttribute("req","N" );
      ((Element)v.get(106)).setAttribute("ontab","tab('cbSistemaPicado')" );
      ((Element)v.get(106)).setAttribute("onshtab","shtab('cbSistemaPicado')" );
      ((Element)v.get(106)).setAttribute("valorinicial","" );
      ((Element)v.get(106)).setAttribute("textoinicial","" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:108 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","25" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(94)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(111)).setAttribute("nombre","cbLetraAnaquel" );
      ((Element)v.get(111)).setAttribute("id","datosCampos" );
      ((Element)v.get(111)).setAttribute("size","1" );
      ((Element)v.get(111)).setAttribute("multiple","N" );
      ((Element)v.get(111)).setAttribute("req","N" );
      ((Element)v.get(111)).setAttribute("ontab","tab('cbLetraAnaquel')" );
      ((Element)v.get(111)).setAttribute("onshtab","shtab('cbLetraAnaquel')" );
      ((Element)v.get(111)).setAttribute("valorinicial","" );
      ((Element)v.get(111)).setAttribute("textoinicial","" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:113 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","25" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(94)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(116)).setAttribute("nombre","cbCodigoImpresora" );
      ((Element)v.get(116)).setAttribute("id","datosCampos" );
      ((Element)v.get(116)).setAttribute("size","1" );
      ((Element)v.get(116)).setAttribute("multiple","N" );
      ((Element)v.get(116)).setAttribute("req","N" );
      ((Element)v.get(116)).setAttribute("ontab","tab('cbCodigoImpresora')" );
      ((Element)v.get(116)).setAttribute("onshtab","shtab('cbCodigoImpresora')" );
      ((Element)v.get(116)).setAttribute("valorinicial","" );
      ((Element)v.get(116)).setAttribute("textoinicial","" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:118 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("width","100%" );
      ((Element)v.get(94)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","8" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:94   */

      /* Empieza nodo:120 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("colspan","4" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:70   */
      /* Termina nodo:36   */

      /* Empieza nodo:123 / Elemento padre: 35   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(35)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("table"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(124)).setAttribute("border","0" );
      ((Element)v.get(124)).setAttribute("align","center" );
      ((Element)v.get(124)).setAttribute("cellspacing","0" );
      ((Element)v.get(124)).setAttribute("cellpadding","0" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("class","botonera" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(127)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(127)).setAttribute("ID","botonContenido" );
      ((Element)v.get(127)).setAttribute("tipo","html" );
      ((Element)v.get(127)).setAttribute("accion","btnBuscarOnClick()" );
      ((Element)v.get(127)).setAttribute("estado","false" );
      ((Element)v.get(127)).setAttribute("cod","1" );
      ((Element)v.get(127)).setAttribute("ontab","tab('btnBuscar')" );
      ((Element)v.get(127)).setAttribute("onshtab","shtab('btnBuscar')" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:35   */

      /* Empieza nodo:128 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(129)).setAttribute("width","8" );
      ((Element)v.get(129)).setAttribute("height","12" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:32   */

      /* Empieza nodo:130 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("width","12" );
      ((Element)v.get(131)).setAttribute("align","center" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","12" );
      ((Element)v.get(132)).setAttribute("height","12" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("width","756" );
      ((Element)v.get(130)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("width","12" );
      ((Element)v.get(130)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","12" );
      ((Element)v.get(136)).setAttribute("height","1" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:130   */
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:137 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(137)).setAttribute("nombre","capaLista" );
      ((Element)v.get(137)).setAttribute("ancho","100%" );
      ((Element)v.get(137)).setAttribute("alto","330" );
      ((Element)v.get(137)).setAttribute("x","8" );
      ((Element)v.get(137)).setAttribute("y","170" );
      ((Element)v.get(137)).setAttribute("colorf","" );
      ((Element)v.get(137)).setAttribute("borde","0" );
      ((Element)v.get(137)).setAttribute("imagenf","" );
      ((Element)v.get(137)).setAttribute("repeat","" );
      ((Element)v.get(137)).setAttribute("padding","" );
      ((Element)v.get(137)).setAttribute("visibilidad","" );
      ((Element)v.get(137)).setAttribute("contravsb","" );
      ((Element)v.get(137)).setAttribute("zindex","" );
      ((Element)v.get(7)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(138)).setAttribute("nombre","listado1" );
      ((Element)v.get(138)).setAttribute("ancho","369" );
      ((Element)v.get(138)).setAttribute("alto","301" );
      ((Element)v.get(138)).setAttribute("x","12" );
      ((Element)v.get(138)).setAttribute("y","0" );
      ((Element)v.get(138)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(138)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(139)).setAttribute("precarga","S" );
      ((Element)v.get(139)).setAttribute("conROver","S" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(140)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(140)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(140)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(140)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 139   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(141)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(141)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(141)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(141)).setAttribute("aximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(139)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 139   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(142)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(142)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(139)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:139   */

      /* Empieza nodo:143 / Elemento padre: 138   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(138)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(144)).setAttribute("borde","1" );
      ((Element)v.get(144)).setAttribute("horizDatos","1" );
      ((Element)v.get(144)).setAttribute("horizCabecera","1" );
      ((Element)v.get(144)).setAttribute("vertical","1" );
      ((Element)v.get(144)).setAttribute("horizTitulo","1" );
      ((Element)v.get(144)).setAttribute("horizBase","1" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 143   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(145)).setAttribute("borde","#999999" );
      ((Element)v.get(145)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(145)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(145)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(145)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(145)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(145)).setAttribute("horizBase","#999999" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(143)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:143   */

      /* Empieza nodo:146 / Elemento padre: 138   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(146)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(146)).setAttribute("alto","22" );
      ((Element)v.get(146)).setAttribute("imgFondo","" );
      ((Element)v.get(146)).setAttribute("cod","00135" );
      ((Element)v.get(146)).setAttribute("ID","datosTitle" );
      ((Element)v.get(138)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 138   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(147)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(147)).setAttribute("alto","22" );
      ((Element)v.get(147)).setAttribute("imgFondo","" );
      ((Element)v.get(138)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 138   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(148)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(148)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(148)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(148)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(148)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(148)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(138)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(149)).setAttribute("ancho","50" );
      ((Element)v.get(149)).setAttribute("minimizable","S" );
      ((Element)v.get(149)).setAttribute("minimizada","N" );
      ((Element)v.get(149)).setAttribute("oculta","S" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("ancho","50" );
      ((Element)v.get(150)).setAttribute("minimizable","S" );
      ((Element)v.get(150)).setAttribute("minimizada","N" );
      ((Element)v.get(148)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("ancho","50" );
      ((Element)v.get(151)).setAttribute("minimizable","S" );
      ((Element)v.get(151)).setAttribute("minimizada","N" );
      ((Element)v.get(151)).setAttribute("oculta","S" );
      ((Element)v.get(148)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("ancho","50" );
      ((Element)v.get(152)).setAttribute("minimizable","S" );
      ((Element)v.get(152)).setAttribute("minimizada","N" );
      ((Element)v.get(148)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("ancho","50" );
      ((Element)v.get(153)).setAttribute("minimizable","S" );
      ((Element)v.get(153)).setAttribute("minimizada","N" );
      ((Element)v.get(148)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("ancho","50" );
      ((Element)v.get(154)).setAttribute("minimizable","S" );
      ((Element)v.get(154)).setAttribute("minimizada","N" );
      ((Element)v.get(148)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("ancho","50" );
      ((Element)v.get(155)).setAttribute("minimizable","S" );
      ((Element)v.get(155)).setAttribute("minimizada","N" );
      ((Element)v.get(155)).setAttribute("oculta","S" );
      ((Element)v.get(148)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("ancho","50" );
      ((Element)v.get(156)).setAttribute("minimizable","S" );
      ((Element)v.get(156)).setAttribute("minimizada","N" );
      ((Element)v.get(148)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("ancho","50" );
      ((Element)v.get(157)).setAttribute("minimizable","S" );
      ((Element)v.get(157)).setAttribute("minimizada","N" );
      ((Element)v.get(148)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("ancho","50" );
      ((Element)v.get(158)).setAttribute("minimizable","S" );
      ((Element)v.get(158)).setAttribute("minimizada","N" );
      ((Element)v.get(158)).setAttribute("oculta","S" );
      ((Element)v.get(148)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("ancho","50" );
      ((Element)v.get(159)).setAttribute("minimizable","S" );
      ((Element)v.get(159)).setAttribute("minimizada","N" );
      ((Element)v.get(159)).setAttribute("oculta","S" );
      ((Element)v.get(148)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("ancho","50" );
      ((Element)v.get(160)).setAttribute("minimizable","S" );
      ((Element)v.get(160)).setAttribute("minimizada","N" );
      ((Element)v.get(160)).setAttribute("oculta","S" );
      ((Element)v.get(148)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("ancho","50" );
      ((Element)v.get(161)).setAttribute("minimizable","S" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(161)).setAttribute("minimizada","N" );
      ((Element)v.get(161)).setAttribute("oculta","S" );
      ((Element)v.get(148)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("ancho","50" );
      ((Element)v.get(162)).setAttribute("minimizable","S" );
      ((Element)v.get(162)).setAttribute("minimizada","N" );
      ((Element)v.get(162)).setAttribute("oculta","S" );
      ((Element)v.get(148)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("ancho","50" );
      ((Element)v.get(163)).setAttribute("minimizable","S" );
      ((Element)v.get(163)).setAttribute("minimizada","N" );
      ((Element)v.get(163)).setAttribute("oculta","S" );
      ((Element)v.get(148)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("ancho","50" );
      ((Element)v.get(164)).setAttribute("minimizable","S" );
      ((Element)v.get(164)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).setAttribute("oculta","S" );
      ((Element)v.get(148)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("ancho","50" );
      ((Element)v.get(165)).setAttribute("minimizable","S" );
      ((Element)v.get(165)).setAttribute("minimizada","N" );
      ((Element)v.get(165)).setAttribute("oculta","S" );
      ((Element)v.get(148)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("ancho","50" );
      ((Element)v.get(166)).setAttribute("minimizable","S" );
      ((Element)v.get(166)).setAttribute("minimizada","N" );
      ((Element)v.get(166)).setAttribute("oculta","S" );
      ((Element)v.get(148)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("ancho","50" );
      ((Element)v.get(167)).setAttribute("minimizable","S" );
      ((Element)v.get(167)).setAttribute("minimizada","N" );
      ((Element)v.get(167)).setAttribute("oculta","S" );
      ((Element)v.get(148)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("ancho","50" );
      ((Element)v.get(168)).setAttribute("minimizable","S" );
      ((Element)v.get(168)).setAttribute("minimizada","N" );
      ((Element)v.get(148)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("ancho","50" );
      ((Element)v.get(169)).setAttribute("minimizable","S" );
      ((Element)v.get(169)).setAttribute("minimizada","N" );
      ((Element)v.get(148)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("ancho","50" );
      ((Element)v.get(170)).setAttribute("minimizable","S" );
      ((Element)v.get(170)).setAttribute("minimizada","N" );
      ((Element)v.get(170)).setAttribute("oculta","S" );
      ((Element)v.get(148)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:148   */

      /* Empieza nodo:171 / Elemento padre: 138   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(171)).setAttribute("alto","25" );
      ((Element)v.get(171)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(171)).setAttribute("imgFondo","" );
      ((Element)v.get(171)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(138)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("colFondo","" );
      ((Element)v.get(172)).setAttribute("ID","EstCab" );
      ((Element)v.get(172)).setAttribute("cod","00441" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Elemento padre:172 / Elemento actual: 173   */
      v.add(doc.createTextNode("OID_CONF_CENT_DIST"));
      ((Element)v.get(172)).appendChild((Text)v.get(173));

      /* Termina nodo Texto:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("colFondo","" );
      ((Element)v.get(174)).setAttribute("ID","EstCab" );
      ((Element)v.get(174)).setAttribute("cod","00441" );
      ((Element)v.get(171)).appendChild((Element)v.get(174));

      /* Elemento padre:174 / Elemento actual: 175   */
      v.add(doc.createTextNode("descripcionCentroDistribucion"));
      ((Element)v.get(174)).appendChild((Text)v.get(175));

      /* Termina nodo Texto:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("colFondo","" );
      ((Element)v.get(176)).setAttribute("ID","EstCab" );
      ((Element)v.get(176)).setAttribute("cod","00441" );
      ((Element)v.get(171)).appendChild((Element)v.get(176));

      /* Elemento padre:176 / Elemento actual: 177   */
      v.add(doc.createTextNode("OID_LINE_ARMA"));
      ((Element)v.get(176)).appendChild((Text)v.get(177));

      /* Termina nodo Texto:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("colFondo","" );
      ((Element)v.get(178)).setAttribute("ID","EstCab" );
      ((Element)v.get(178)).setAttribute("cod","ApeParamBalanAreaCheq.lineaArmado.label" );
      ((Element)v.get(171)).appendChild((Element)v.get(178));

      /* Elemento padre:178 / Elemento actual: 179   */
      v.add(doc.createTextNode("descripcionLineaArmado"));
      ((Element)v.get(178)).appendChild((Text)v.get(179));

      /* Termina nodo Texto:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(180)).setAttribute("colFondo","" );
      ((Element)v.get(180)).setAttribute("ID","EstCab" );
      ((Element)v.get(180)).setAttribute("cod","ApeSubLineaArmado.codSublinea.label" );
      ((Element)v.get(171)).appendChild((Element)v.get(180));

      /* Elemento padre:180 / Elemento actual: 181   */
      v.add(doc.createTextNode("codigoSublinea"));
      ((Element)v.get(180)).appendChild((Text)v.get(181));

      /* Termina nodo Texto:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("colFondo","" );
      ((Element)v.get(182)).setAttribute("ID","EstCab" );
      ((Element)v.get(182)).setAttribute("cod","ApeSubLineaArmado.descripcion.label" );
      ((Element)v.get(171)).appendChild((Element)v.get(182));

      /* Elemento padre:182 / Elemento actual: 183   */
      v.add(doc.createTextNode("descripcionSublinea"));
      ((Element)v.get(182)).appendChild((Text)v.get(183));

      /* Termina nodo Texto:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("colFondo","" );
      ((Element)v.get(184)).setAttribute("ID","EstCab" );
      ((Element)v.get(184)).setAttribute("cod","00441" );
      ((Element)v.get(171)).appendChild((Element)v.get(184));

      /* Elemento padre:184 / Elemento actual: 185   */
      v.add(doc.createTextNode("OID_SIST_PICA"));
      ((Element)v.get(184)).appendChild((Text)v.get(185));

      /* Termina nodo Texto:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("colFondo","" );
      ((Element)v.get(186)).setAttribute("ID","EstCab" );
      ((Element)v.get(186)).setAttribute("cod","3039" );
      ((Element)v.get(171)).appendChild((Element)v.get(186));

      /* Elemento padre:186 / Elemento actual: 187   */
      v.add(doc.createTextNode("descripcionSistemaPicado"));
      ((Element)v.get(186)).appendChild((Text)v.get(187));

      /* Termina nodo Texto:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("colFondo","" );
      ((Element)v.get(188)).setAttribute("ID","EstCab" );
      ((Element)v.get(188)).setAttribute("cod","2957" );
      ((Element)v.get(171)).appendChild((Element)v.get(188));

      /* Elemento padre:188 / Elemento actual: 189   */
      v.add(doc.createTextNode("letraParaAnaquel"));
      ((Element)v.get(188)).appendChild((Text)v.get(189));

      /* Termina nodo Texto:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("colFondo","" );
      ((Element)v.get(190)).setAttribute("ID","EstCab" );
      ((Element)v.get(190)).setAttribute("cod","0979" );
      ((Element)v.get(171)).appendChild((Element)v.get(190));

      /* Elemento padre:190 / Elemento actual: 191   */
      v.add(doc.createTextNode("imprimirListaPicado"));
      ((Element)v.get(190)).appendChild((Text)v.get(191));

      /* Termina nodo Texto:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("colFondo","" );
      ((Element)v.get(192)).setAttribute("ID","EstCab" );
      ((Element)v.get(192)).setAttribute("cod","2956" );
      ((Element)v.get(171)).appendChild((Element)v.get(192));

      /* Elemento padre:192 / Elemento actual: 193   */
      v.add(doc.createTextNode("postVenta"));
      ((Element)v.get(192)).appendChild((Text)v.get(193));

      /* Termina nodo Texto:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("colFondo","" );
      ((Element)v.get(194)).setAttribute("ID","EstCab" );
      ((Element)v.get(194)).setAttribute("cod","" );
      ((Element)v.get(171)).appendChild((Element)v.get(194));

      /* Elemento padre:194 / Elemento actual: 195   */
      v.add(doc.createTextNode("frenteEspalda"));
      ((Element)v.get(194)).appendChild((Text)v.get(195));

      /* Termina nodo Texto:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(196)).setAttribute("colFondo","" );
      ((Element)v.get(196)).setAttribute("ID","EstCab" );
      ((Element)v.get(196)).setAttribute("cod","" );
      ((Element)v.get(171)).appendChild((Element)v.get(196));

      /* Elemento padre:196 / Elemento actual: 197   */
      v.add(doc.createTextNode("bahiasFrente"));
      ((Element)v.get(196)).appendChild((Text)v.get(197));

      /* Termina nodo Texto:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("colFondo","" );
      ((Element)v.get(198)).setAttribute("ID","EstCab" );
      ((Element)v.get(198)).setAttribute("cod","" );
      ((Element)v.get(171)).appendChild((Element)v.get(198));

      /* Elemento padre:198 / Elemento actual: 199   */
      v.add(doc.createTextNode("bahiasEspalda"));
      ((Element)v.get(198)).appendChild((Text)v.get(199));

      /* Termina nodo Texto:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(200)).setAttribute("colFondo","" );
      ((Element)v.get(200)).setAttribute("ID","EstCab" );
      ((Element)v.get(200)).setAttribute("cod","" );
      ((Element)v.get(171)).appendChild((Element)v.get(200));

      /* Elemento padre:200 / Elemento actual: 201   */
      v.add(doc.createTextNode("numeroNivelesFrente"));
      ((Element)v.get(200)).appendChild((Text)v.get(201));

      /* Termina nodo Texto:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(202)).setAttribute("colFondo","" );
      ((Element)v.get(202)).setAttribute("ID","EstCab" );
      ((Element)v.get(202)).setAttribute("cod","" );
      ((Element)v.get(171)).appendChild((Element)v.get(202));

      /* Elemento padre:202 / Elemento actual: 203   */
      v.add(doc.createTextNode("numeroNivelesEspalda"));
      ((Element)v.get(202)).appendChild((Text)v.get(203));

      /* Termina nodo Texto:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("colFondo","" );
      ((Element)v.get(204)).setAttribute("ID","EstCab" );
      ((Element)v.get(204)).setAttribute("cod","" );
      ((Element)v.get(171)).appendChild((Element)v.get(204));

      /* Elemento padre:204 / Elemento actual: 205   */
      v.add(doc.createTextNode("numeroColumnasFrente"));
      ((Element)v.get(204)).appendChild((Text)v.get(205));

      /* Termina nodo Texto:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 171   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("colFondo","" );
      ((Element)v.get(206)).setAttribute("ID","EstCab" );
      ((Element)v.get(206)).setAttribute("cod","" );
      ((Element)v.get(171)).appendChild((Element)v.get(206));

      /* Elemento padre:206 / Elemento actual: 207   */
      v.add(doc.createTextNode("numeroColumnasEspalda"));
      ((Element)v.get(206)).appendChild((Text)v.get(207));

      /* Termina nodo Texto:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("colFondo","" );
      ((Element)v.get(208)).setAttribute("ID","EstCab" );
      ((Element)v.get(208)).setAttribute("cod","" );
      ((Element)v.get(171)).appendChild((Element)v.get(208));

      /* Elemento padre:208 / Elemento actual: 209   */
      v.add(doc.createTextNode("numeroOrdenBalanceo"));
      ((Element)v.get(208)).appendChild((Text)v.get(209));

      /* Termina nodo Texto:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("colFondo","" );
      ((Element)v.get(210)).setAttribute("ID","EstCab" );
      ((Element)v.get(210)).setAttribute("cod","3138" );
      ((Element)v.get(171)).appendChild((Element)v.get(210));

      /* Elemento padre:210 / Elemento actual: 211   */
      v.add(doc.createTextNode("CódigoImpresora"));
      ((Element)v.get(210)).appendChild((Text)v.get(211));

      /* Termina nodo Texto:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("colFondo","" );
      ((Element)v.get(212)).setAttribute("ID","EstCab" );
      ((Element)v.get(212)).setAttribute("cod","ape00003" );
      ((Element)v.get(171)).appendChild((Element)v.get(212));

      /* Elemento padre:212 / Elemento actual: 213   */
      v.add(doc.createTextNode("Nro Impresora PTL"));
      ((Element)v.get(212)).appendChild((Text)v.get(213));

      /* Termina nodo Texto:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("colFondo","" );
      ((Element)v.get(214)).setAttribute("ID","EstCab" );
      ((Element)v.get(214)).setAttribute("cod","" );
      ((Element)v.get(171)).appendChild((Element)v.get(214));

      /* Elemento padre:214 / Elemento actual: 215   */
      v.add(doc.createTextNode("OID Codigo Impresora "));
      ((Element)v.get(214)).appendChild((Text)v.get(215));

      /* Termina nodo Texto:215   */
      /* Termina nodo:214   */
      /* Termina nodo:171   */

      /* Empieza nodo:216 / Elemento padre: 138   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(216)).setAttribute("alto","22" );
      ((Element)v.get(216)).setAttribute("accion","" );
      ((Element)v.get(216)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(216)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(216)).setAttribute("maxSel","-1" );
      ((Element)v.get(216)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(216)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(216)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(216)).setAttribute("onLoad","" );
      ((Element)v.get(216)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(138)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("tipo","texto" );
      ((Element)v.get(217)).setAttribute("ID","EstDat" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(218)).setAttribute("tipo","texto" );
      ((Element)v.get(218)).setAttribute("ID","EstDat2" );
      ((Element)v.get(216)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(219)).setAttribute("tipo","texto" );
      ((Element)v.get(219)).setAttribute("ID","EstDat" );
      ((Element)v.get(216)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(220)).setAttribute("tipo","texto" );
      ((Element)v.get(220)).setAttribute("ID","EstDat2" );
      ((Element)v.get(216)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(221)).setAttribute("tipo","texto" );
      ((Element)v.get(221)).setAttribute("ID","EstDat" );
      ((Element)v.get(216)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("tipo","texto" );
      ((Element)v.get(222)).setAttribute("ID","EstDat2" );
      ((Element)v.get(216)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(223)).setAttribute("tipo","texto" );
      ((Element)v.get(223)).setAttribute("ID","EstDat" );
      ((Element)v.get(216)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("tipo","texto" );
      ((Element)v.get(224)).setAttribute("ID","EstDat2" );
      ((Element)v.get(216)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(225)).setAttribute("tipo","texto" );
      ((Element)v.get(225)).setAttribute("ID","EstDat" );
      ((Element)v.get(216)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(226)).setAttribute("tipo","texto" );
      ((Element)v.get(226)).setAttribute("ID","EstDat2" );
      ((Element)v.get(216)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */

      /* Empieza nodo:227 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("tipo","texto" );
      ((Element)v.get(227)).setAttribute("ID","EstDat" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(216)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(228)).setAttribute("tipo","texto" );
      ((Element)v.get(228)).setAttribute("ID","EstDat2" );
      ((Element)v.get(216)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("tipo","texto" );
      ((Element)v.get(229)).setAttribute("ID","EstDat" );
      ((Element)v.get(216)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("tipo","texto" );
      ((Element)v.get(230)).setAttribute("ID","EstDat2" );
      ((Element)v.get(216)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("tipo","texto" );
      ((Element)v.get(231)).setAttribute("ID","EstDat" );
      ((Element)v.get(216)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(232)).setAttribute("tipo","texto" );
      ((Element)v.get(232)).setAttribute("ID","EstDat2" );
      ((Element)v.get(216)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(233)).setAttribute("tipo","texto" );
      ((Element)v.get(233)).setAttribute("ID","EstDat" );
      ((Element)v.get(216)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */

      /* Empieza nodo:234 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(234)).setAttribute("tipo","texto" );
      ((Element)v.get(234)).setAttribute("ID","EstDat2" );
      ((Element)v.get(216)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(235)).setAttribute("tipo","texto" );
      ((Element)v.get(235)).setAttribute("ID","EstDat" );
      ((Element)v.get(216)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(236)).setAttribute("tipo","texto" );
      ((Element)v.get(236)).setAttribute("ID","EstDat2" );
      ((Element)v.get(216)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(237)).setAttribute("tipo","texto" );
      ((Element)v.get(237)).setAttribute("ID","EstDat" );
      ((Element)v.get(216)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(238)).setAttribute("tipo","texto" );
      ((Element)v.get(238)).setAttribute("ID","EstDat2" );
      ((Element)v.get(216)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:216   */

      /* Empieza nodo:239 / Elemento padre: 138   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(138)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 138   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(240)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(240)).setAttribute("ancho","679" );
      ((Element)v.get(240)).setAttribute("sep","$" );
      ((Element)v.get(240)).setAttribute("x","12" );
      ((Element)v.get(240)).setAttribute("class","botonera" );
      ((Element)v.get(240)).setAttribute("y","294" );
      ((Element)v.get(240)).setAttribute("control","|" );
      ((Element)v.get(240)).setAttribute("conector","ConectorBuscarCargosAbonos" );
      ((Element)v.get(240)).setAttribute("rowset","" );
      ((Element)v.get(240)).setAttribute("cargainicial","N" );
      ((Element)v.get(240)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(138)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(241)).setAttribute("nombre","ret1" );
      ((Element)v.get(241)).setAttribute("x","37" );
      ((Element)v.get(241)).setAttribute("y","282" );
      ((Element)v.get(241)).setAttribute("ID","botonContenido" );
      ((Element)v.get(241)).setAttribute("img","retroceder_on" );
      ((Element)v.get(241)).setAttribute("tipo","0" );
      ((Element)v.get(241)).setAttribute("estado","false" );
      ((Element)v.get(241)).setAttribute("alt","" );
      ((Element)v.get(241)).setAttribute("codigo","" );
      ((Element)v.get(241)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 240   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(242)).setAttribute("nombre","ava1" );
      ((Element)v.get(242)).setAttribute("x","52" );
      ((Element)v.get(242)).setAttribute("y","282" );
      ((Element)v.get(242)).setAttribute("ID","botonContenido" );
      ((Element)v.get(242)).setAttribute("img","avanzar_on" );
      ((Element)v.get(242)).setAttribute("tipo","0" );
      ((Element)v.get(242)).setAttribute("estado","false" );
      ((Element)v.get(242)).setAttribute("alt","" );
      ((Element)v.get(242)).setAttribute("codigo","" );
      ((Element)v.get(242)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(240)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:240   */
      /* Termina nodo:138   */

      /* Empieza nodo:243 / Elemento padre: 137   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(243)).setAttribute("nombre","primera1" );
      ((Element)v.get(243)).setAttribute("x","20" );
      ((Element)v.get(243)).setAttribute("y","282" );
      ((Element)v.get(243)).setAttribute("ID","botonContenido" );
      ((Element)v.get(243)).setAttribute("img","primera_on" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(243)).setAttribute("tipo","-2" );
      ((Element)v.get(243)).setAttribute("estado","false" );
      ((Element)v.get(243)).setAttribute("alt","" );
      ((Element)v.get(243)).setAttribute("codigo","" );
      ((Element)v.get(243)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(137)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 137   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(244)).setAttribute("nombre","separa" );
      ((Element)v.get(244)).setAttribute("x","59" );
      ((Element)v.get(244)).setAttribute("y","278" );
      ((Element)v.get(244)).setAttribute("ID","botonContenido" );
      ((Element)v.get(244)).setAttribute("img","separa_base" );
      ((Element)v.get(244)).setAttribute("tipo","0" );
      ((Element)v.get(244)).setAttribute("estado","false" );
      ((Element)v.get(244)).setAttribute("alt","" );
      ((Element)v.get(244)).setAttribute("codigo","" );
      ((Element)v.get(244)).setAttribute("accion","" );
      ((Element)v.get(137)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 137   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(245)).setAttribute("nombre","btnModificar" );
      ((Element)v.get(245)).setAttribute("x","80" );
      ((Element)v.get(245)).setAttribute("y","279" );
      ((Element)v.get(245)).setAttribute("ID","botonContenido" );
      ((Element)v.get(245)).setAttribute("tipo","html" );
      ((Element)v.get(245)).setAttribute("estado","false" );
      ((Element)v.get(245)).setAttribute("cod","2" );
      ((Element)v.get(245)).setAttribute("accion","onClickModificar()" );
      ((Element)v.get(245)).setAttribute("ontab","tab('btnModificar')" );
      ((Element)v.get(245)).setAttribute("onshtab","shtab('btnModificar')" );
      ((Element)v.get(137)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */

      /* Empieza nodo:246 / Elemento padre: 137   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(246)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(246)).setAttribute("x","80" );
      ((Element)v.get(246)).setAttribute("y","279" );
      ((Element)v.get(246)).setAttribute("ID","botonContenido" );
      ((Element)v.get(246)).setAttribute("tipo","html" );
      ((Element)v.get(246)).setAttribute("estado","false" );
      ((Element)v.get(246)).setAttribute("cod","3" );
      ((Element)v.get(246)).setAttribute("accion","onClickDetalle()" );
      ((Element)v.get(246)).setAttribute("ontab","tab('btnDetalle')" );
      ((Element)v.get(246)).setAttribute("onshtab","shtab('btnDetalle')" );
      ((Element)v.get(137)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:137   */
      /* Termina nodo:7   */


   }

}

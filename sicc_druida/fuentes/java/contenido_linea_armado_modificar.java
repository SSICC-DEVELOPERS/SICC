
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_linea_armado_modificar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_linea_armado_modificar" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_linea_armado_modificar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbCentroDistribucion" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("group","validacion1" );
      ((Element)v.get(7)).setAttribute("cod","2054" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtLineaArmado" );
      ((Element)v.get(8)).setAttribute("required","false" );
      ((Element)v.get(8)).setAttribute("group","validacion1" );
      ((Element)v.get(8)).setAttribute("cod","2095" );
      ((Element)v.get(8)).setAttribute("format","e" );
      ((Element)v.get(8)).setAttribute("min","0" );
      ((Element)v.get(8)).setAttribute("max","99" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:6   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(9)).setAttribute("nombre","formulario" );
      ((Element)v.get(9)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","accion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hPais" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hDeshabilitar" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","casoUso" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(19)).setAttribute("nombre","capa1" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("table"));
      ((Element)v.get(20)).setAttribute("width","100%" );
      ((Element)v.get(20)).setAttribute("border","0" );
      ((Element)v.get(20)).setAttribute("cellspacing","0" );
      ((Element)v.get(20)).setAttribute("cellpadding","0" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(22)).setAttribute("align","center" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(23)).setAttribute("height","12" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","750" );
      ((Element)v.get(21)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(21)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(27)).setAttribute("height","1" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */
      /* Termina nodo:21   */

      /* Empieza nodo:28 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(33)).setAttribute("class","legend" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(34)).setAttribute("nombre","lblCriterioBusqueda" );
      ((Element)v.get(34)).setAttribute("alto","13" );
      ((Element)v.get(34)).setAttribute("filas","1" );
      ((Element)v.get(34)).setAttribute("cod","MMGGlobal.legend.searchcriteria.label" );
      ((Element)v.get(34)).setAttribute("id","legend" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 32   */
      v.add(doc.createElement("table"));
      ((Element)v.get(35)).setAttribute("width","100%" );
      ((Element)v.get(35)).setAttribute("border","0" );
      ((Element)v.get(35)).setAttribute("align","center" );
      ((Element)v.get(35)).setAttribute("cellspacing","0" );
      ((Element)v.get(35)).setAttribute("cellpadding","0" );
      ((Element)v.get(32)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("colspan","4" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).setAttribute("width","8" );
      ((Element)v.get(38)).setAttribute("height","8" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:39 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","8" );
      ((Element)v.get(41)).setAttribute("height","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(43)).setAttribute("nombre","lblCentroDistribucion" );
      ((Element)v.get(43)).setAttribute("alto","13" );
      ((Element)v.get(43)).setAttribute("filas","1" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(43)).setAttribute("id","datosTitle" );
      ((Element)v.get(43)).setAttribute("cod","2054" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","25" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(39)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblLineaArmado" );
      ((Element)v.get(47)).setAttribute("alto","13" );
      ((Element)v.get(47)).setAttribute("filas","1" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(47)).setAttribute("id","datosTitle" );
      ((Element)v.get(47)).setAttribute("cod","2095" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","25" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(51)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(51)).setAttribute("alto","13" );
      ((Element)v.get(51)).setAttribute("filas","1" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(51)).setAttribute("id","datosTitle" );
      ((Element)v.get(51)).setAttribute("cod","MMGGlobal.localization.description.label" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("width","100%" );
      ((Element)v.get(39)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","8" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:39   */

      /* Empieza nodo:54 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(54));

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
      ((Element)v.get(58)).setAttribute("req","S" );
      ((Element)v.get(58)).setAttribute("onchange","onChangeCbCentroDistribucion()" );
      ((Element)v.get(58)).setAttribute("ontab","onTab('cbCentroDistribucion');" );
      ((Element)v.get(58)).setAttribute("onshtab","onShTab('cbCentroDistribucion');" );
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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(63)).setAttribute("nombre","txtLineaArmado" );
      ((Element)v.get(63)).setAttribute("id","datosCampos" );
      ((Element)v.get(63)).setAttribute("max","2" );
      ((Element)v.get(63)).setAttribute("tipo","" );
      ((Element)v.get(63)).setAttribute("onchange","" );
      ((Element)v.get(63)).setAttribute("ontab","onTab('txtLineaArmado');" );
      ((Element)v.get(63)).setAttribute("onshtab","onShTab('txtLineaArmado');" );
      ((Element)v.get(63)).setAttribute("req","N" );
      ((Element)v.get(63)).setAttribute("size","2" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(63)).setAttribute("validacion","" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","25" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 54   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(54)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(67)).setAttribute("nombre","cbDescripcion" );
      ((Element)v.get(67)).setAttribute("id","datosCampos" );
      ((Element)v.get(67)).setAttribute("size","1" );
      ((Element)v.get(67)).setAttribute("multiple","N" );
      ((Element)v.get(67)).setAttribute("req","N" );
      ((Element)v.get(67)).setAttribute("onchange","" );
      ((Element)v.get(67)).setAttribute("ontab","onTab('cbDescripcion');" );
      ((Element)v.get(67)).setAttribute("onshtab","onShTab('cbDescripcion');" );
      ((Element)v.get(67)).setAttribute("valorinicial","" );
      ((Element)v.get(67)).setAttribute("textoinicial","" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:69 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("width","100%" );
      ((Element)v.get(54)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:54   */

      /* Empieza nodo:71 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("colspan","4" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","8" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:35   */
      /* Termina nodo:32   */

      /* Empieza nodo:74 / Elemento padre: 31   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(31)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("table"));
      ((Element)v.get(75)).setAttribute("width","100%" );
      ((Element)v.get(75)).setAttribute("border","0" );
      ((Element)v.get(75)).setAttribute("align","center" );
      ((Element)v.get(75)).setAttribute("cellspacing","0" );
      ((Element)v.get(75)).setAttribute("cellpadding","0" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("class","botonera" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(78)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(78)).setAttribute("ID","botonContenido" );
      ((Element)v.get(78)).setAttribute("tipo","html" );
      ((Element)v.get(78)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(78)).setAttribute("estado","false" );
      ((Element)v.get(78)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(78)).setAttribute("ontab","onTab('btnBuscar');" );
      ((Element)v.get(78)).setAttribute("onshtab","onShTab('btnBuscar');" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:31   */
      /* Termina nodo:28   */
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:79 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(79)).setAttribute("nombre","capaLista" );
      ((Element)v.get(79)).setAttribute("ancho","100%" );
      ((Element)v.get(79)).setAttribute("alto","330" );
      ((Element)v.get(79)).setAttribute("x","10" );
      ((Element)v.get(79)).setAttribute("y","125" );
      ((Element)v.get(79)).setAttribute("colorf","" );
      ((Element)v.get(79)).setAttribute("borde","0" );
      ((Element)v.get(79)).setAttribute("imagenf","" );
      ((Element)v.get(79)).setAttribute("repeat","" );
      ((Element)v.get(79)).setAttribute("padding","" );
      ((Element)v.get(79)).setAttribute("visibilidad","" );
      ((Element)v.get(79)).setAttribute("contravsb","" );
      ((Element)v.get(79)).setAttribute("zindex","" );
      ((Element)v.get(9)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(80)).setAttribute("nombre","listado1" );
      ((Element)v.get(80)).setAttribute("ancho","369" );
      ((Element)v.get(80)).setAttribute("alto","301" );
      ((Element)v.get(80)).setAttribute("x","12" );
      ((Element)v.get(80)).setAttribute("y","0" );
      ((Element)v.get(80)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(80)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(81)).setAttribute("precarga","S" );
      ((Element)v.get(81)).setAttribute("conROver","S" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(82)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(82)).setAttribute("rollOver","btnLista2S.gif" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(82)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(82)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 81   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(83)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(83)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(83)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(83)).setAttribute("aximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(81)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 81   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(84)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(84)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(81)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:81   */

      /* Empieza nodo:85 / Elemento padre: 80   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(80)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(86)).setAttribute("borde","1" );
      ((Element)v.get(86)).setAttribute("horizDatos","1" );
      ((Element)v.get(86)).setAttribute("horizCabecera","1" );
      ((Element)v.get(86)).setAttribute("vertical","1" );
      ((Element)v.get(86)).setAttribute("horizTitulo","1" );
      ((Element)v.get(86)).setAttribute("horizBase","1" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 85   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(87)).setAttribute("borde","#999999" );
      ((Element)v.get(87)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(87)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(87)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(87)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(87)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(87)).setAttribute("horizBase","#999999" );
      ((Element)v.get(85)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:85   */

      /* Empieza nodo:88 / Elemento padre: 80   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(88)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(88)).setAttribute("alto","22" );
      ((Element)v.get(88)).setAttribute("imgFondo","" );
      ((Element)v.get(88)).setAttribute("cod","00135" );
      ((Element)v.get(88)).setAttribute("ID","datosTitle" );
      ((Element)v.get(80)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 80   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(89)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(89)).setAttribute("alto","22" );
      ((Element)v.get(89)).setAttribute("imgFondo","" );
      ((Element)v.get(80)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 80   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(90)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(90)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(90)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(90)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(90)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(90)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(80)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(91)).setAttribute("ancho","50" );
      ((Element)v.get(91)).setAttribute("minimizable","S" );
      ((Element)v.get(91)).setAttribute("minimizada","N" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(92)).setAttribute("ancho","50" );
      ((Element)v.get(92)).setAttribute("minimizable","S" );
      ((Element)v.get(92)).setAttribute("minimizada","N" );
      ((Element)v.get(90)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(93)).setAttribute("ancho","50" );
      ((Element)v.get(93)).setAttribute("minimizable","S" );
      ((Element)v.get(93)).setAttribute("minimizada","N" );
      ((Element)v.get(90)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(94)).setAttribute("ancho","50" );
      ((Element)v.get(94)).setAttribute("minimizable","S" );
      ((Element)v.get(94)).setAttribute("minimizada","N" );
      ((Element)v.get(90)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("ancho","50" );
      ((Element)v.get(95)).setAttribute("minimizable","S" );
      ((Element)v.get(95)).setAttribute("minimizada","N" );
      ((Element)v.get(90)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(96)).setAttribute("ancho","50" );
      ((Element)v.get(96)).setAttribute("minimizable","S" );
      ((Element)v.get(96)).setAttribute("minimizada","N" );
      ((Element)v.get(96)).setAttribute("oculta","S" );
      ((Element)v.get(90)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("ancho","50" );
      ((Element)v.get(97)).setAttribute("minimizable","S" );
      ((Element)v.get(97)).setAttribute("minimizada","N" );
      ((Element)v.get(97)).setAttribute("oculta","S" );
      ((Element)v.get(90)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(98)).setAttribute("ancho","50" );
      ((Element)v.get(98)).setAttribute("minimizable","S" );
      ((Element)v.get(98)).setAttribute("minimizada","N" );
      ((Element)v.get(98)).setAttribute("oculta","S" );
      ((Element)v.get(90)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("ancho","50" );
      ((Element)v.get(99)).setAttribute("minimizable","S" );
      ((Element)v.get(99)).setAttribute("minimizada","N" );
      ((Element)v.get(99)).setAttribute("oculta","S" );
      ((Element)v.get(90)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(100)).setAttribute("ancho","50" );
      ((Element)v.get(100)).setAttribute("minimizable","S" );
      ((Element)v.get(100)).setAttribute("minimizada","N" );
      ((Element)v.get(100)).setAttribute("oculta","S" );
      ((Element)v.get(90)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:90   */

      /* Empieza nodo:101 / Elemento padre: 80   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(101)).setAttribute("alto","25" );
      ((Element)v.get(101)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(101)).setAttribute("imgFondo","" );
      ((Element)v.get(101)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(80)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(102)).setAttribute("colFondo","" );
      ((Element)v.get(102)).setAttribute("ID","EstCab" );
      ((Element)v.get(102)).setAttribute("cod","00441" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Elemento padre:102 / Elemento actual: 103   */
      v.add(doc.createTextNode("Centro Distribucion"));
      ((Element)v.get(102)).appendChild((Text)v.get(103));

      /* Termina nodo Texto:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("colFondo","" );
      ((Element)v.get(104)).setAttribute("ID","EstCab" );
      ((Element)v.get(104)).setAttribute("cod","2095" );
      ((Element)v.get(101)).appendChild((Element)v.get(104));

      /* Elemento padre:104 / Elemento actual: 105   */
      v.add(doc.createTextNode("Linea de Armado"));
      ((Element)v.get(104)).appendChild((Text)v.get(105));

      /* Termina nodo Texto:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("colFondo","" );
      ((Element)v.get(106)).setAttribute("ID","EstCab" );
      ((Element)v.get(106)).setAttribute("cod","MMGGlobal.localization.description.label" );
      ((Element)v.get(101)).appendChild((Element)v.get(106));

      /* Elemento padre:106 / Elemento actual: 107   */
      v.add(doc.createTextNode("Descripcion"));
      ((Element)v.get(106)).appendChild((Text)v.get(107));

      /* Termina nodo Texto:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("colFondo","" );
      ((Element)v.get(108)).setAttribute("ID","EstCab" );
      ((Element)v.get(108)).setAttribute("cod","2922" );
      ((Element)v.get(101)).appendChild((Element)v.get(108));

      /* Elemento padre:108 / Elemento actual: 109   */
      v.add(doc.createTextNode("Línea AFP"));
      ((Element)v.get(108)).appendChild((Text)v.get(109));

      /* Termina nodo Texto:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("colFondo","" );
      ((Element)v.get(110)).setAttribute("ID","EstCab" );
      ((Element)v.get(110)).setAttribute("cod","3038" );
      ((Element)v.get(101)).appendChild((Element)v.get(110));

      /* Elemento padre:110 / Elemento actual: 111   */
      v.add(doc.createTextNode("Línea por defecto"));
      ((Element)v.get(110)).appendChild((Text)v.get(111));

      /* Termina nodo Texto:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("colFondo","" );
      ((Element)v.get(112)).setAttribute("ID","EstCab" );
      ((Element)v.get(112)).setAttribute("cod","2920" );
      ((Element)v.get(101)).appendChild((Element)v.get(112));

      /* Elemento padre:112 / Elemento actual: 113   */
      v.add(doc.createTextNode("Longitud"));
      ((Element)v.get(112)).appendChild((Text)v.get(113));

      /* Termina nodo Texto:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("colFondo","" );
      ((Element)v.get(114)).setAttribute("ID","EstCab" );
      ((Element)v.get(114)).setAttribute("cod","2924" );
      ((Element)v.get(101)).appendChild((Element)v.get(114));

      /* Elemento padre:114 / Elemento actual: 115   */
      v.add(doc.createTextNode("Numero etiquetas"));
      ((Element)v.get(114)).appendChild((Text)v.get(115));

      /* Termina nodo Texto:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("colFondo","" );
      ((Element)v.get(116)).setAttribute("ID","EstCab" );
      ((Element)v.get(101)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("colFondo","" );
      ((Element)v.get(117)).setAttribute("ID","EstCab" );
      ((Element)v.get(101)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("colFondo","" );
      ((Element)v.get(118)).setAttribute("ID","EstCab" );
      ((Element)v.get(101)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:101   */

      /* Empieza nodo:119 / Elemento padre: 80   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(119)).setAttribute("alto","22" );
      ((Element)v.get(119)).setAttribute("accion","" );
      ((Element)v.get(119)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(119)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(119)).setAttribute("maxSel","-1" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(119)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(119)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(119)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(119)).setAttribute("onLoad","" );
      ((Element)v.get(119)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(80)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("tipo","texto" );
      ((Element)v.get(120)).setAttribute("ID","EstDat" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("tipo","texto" );
      ((Element)v.get(121)).setAttribute("ID","EstDat2" );
      ((Element)v.get(119)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("tipo","texto" );
      ((Element)v.get(122)).setAttribute("ID","EstDat" );
      ((Element)v.get(119)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("tipo","texto" );
      ((Element)v.get(123)).setAttribute("ID","EstDat2" );
      ((Element)v.get(119)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("tipo","texto" );
      ((Element)v.get(124)).setAttribute("ID","EstDat" );
      ((Element)v.get(119)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("tipo","texto" );
      ((Element)v.get(125)).setAttribute("ID","EstDat" );
      ((Element)v.get(119)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("tipo","texto" );
      ((Element)v.get(126)).setAttribute("ID","EstDat" );
      ((Element)v.get(119)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("tipo","texto" );
      ((Element)v.get(127)).setAttribute("ID","EstDat" );
      ((Element)v.get(119)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("tipo","texto" );
      ((Element)v.get(128)).setAttribute("ID","EstDat" );
      ((Element)v.get(119)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("tipo","texto" );
      ((Element)v.get(129)).setAttribute("ID","EstDat" );
      ((Element)v.get(119)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:119   */

      /* Empieza nodo:130 / Elemento padre: 80   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(80)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 80   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(131)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(131)).setAttribute("ancho","679" );
      ((Element)v.get(131)).setAttribute("sep","$" );
      ((Element)v.get(131)).setAttribute("x","12" );
      ((Element)v.get(131)).setAttribute("class","botonera" );
      ((Element)v.get(131)).setAttribute("y","294" );
      ((Element)v.get(131)).setAttribute("control","|" );
      ((Element)v.get(131)).setAttribute("conector","ConectorBuscarCargosAbonos" );
      ((Element)v.get(131)).setAttribute("rowset","" );
      ((Element)v.get(131)).setAttribute("cargainicial","N" );
      ((Element)v.get(131)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(80)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(132)).setAttribute("nombre","ret1" );
      ((Element)v.get(132)).setAttribute("x","37" );
      ((Element)v.get(132)).setAttribute("y","282" );
      ((Element)v.get(132)).setAttribute("ID","botonContenido" );
      ((Element)v.get(132)).setAttribute("img","retroceder_on" );
      ((Element)v.get(132)).setAttribute("tipo","0" );
      ((Element)v.get(132)).setAttribute("estado","false" );
      ((Element)v.get(132)).setAttribute("alt","" );
      ((Element)v.get(132)).setAttribute("codigo","" );
      ((Element)v.get(132)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 131   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(133)).setAttribute("nombre","ava1" );
      ((Element)v.get(133)).setAttribute("x","52" );
      ((Element)v.get(133)).setAttribute("y","282" );
      ((Element)v.get(133)).setAttribute("ID","botonContenido" );
      ((Element)v.get(133)).setAttribute("img","avanzar_on" );
      ((Element)v.get(133)).setAttribute("tipo","0" );
      ((Element)v.get(133)).setAttribute("estado","false" );
      ((Element)v.get(133)).setAttribute("alt","" );
      ((Element)v.get(133)).setAttribute("codigo","" );
      ((Element)v.get(133)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(131)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:131   */
      /* Termina nodo:80   */

      /* Empieza nodo:134 / Elemento padre: 79   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(134)).setAttribute("nombre","primera1" );
      ((Element)v.get(134)).setAttribute("x","20" );
      ((Element)v.get(134)).setAttribute("y","282" );
      ((Element)v.get(134)).setAttribute("ID","botonContenido" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(134)).setAttribute("img","primera_on" );
      ((Element)v.get(134)).setAttribute("tipo","-2" );
      ((Element)v.get(134)).setAttribute("estado","false" );
      ((Element)v.get(134)).setAttribute("alt","" );
      ((Element)v.get(134)).setAttribute("codigo","" );
      ((Element)v.get(134)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(79)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 79   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(135)).setAttribute("nombre","separa" );
      ((Element)v.get(135)).setAttribute("x","59" );
      ((Element)v.get(135)).setAttribute("y","278" );
      ((Element)v.get(135)).setAttribute("ID","botonContenido" );
      ((Element)v.get(135)).setAttribute("img","separa_base" );
      ((Element)v.get(135)).setAttribute("tipo","0" );
      ((Element)v.get(135)).setAttribute("estado","false" );
      ((Element)v.get(135)).setAttribute("alt","" );
      ((Element)v.get(135)).setAttribute("codigo","" );
      ((Element)v.get(135)).setAttribute("accion","" );
      ((Element)v.get(79)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 79   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(136)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(136)).setAttribute("x","80" );
      ((Element)v.get(136)).setAttribute("y","279" );
      ((Element)v.get(136)).setAttribute("ID","botonContenido" );
      ((Element)v.get(136)).setAttribute("tipo","html" );
      ((Element)v.get(136)).setAttribute("estado","false" );
      ((Element)v.get(136)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(136)).setAttribute("accion","onClickDetalle();" );
      ((Element)v.get(136)).setAttribute("ontab","onTab('btnDetalle');" );
      ((Element)v.get(136)).setAttribute("onshtab","onShTab('btnDetalle');" );
      ((Element)v.get(79)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 79   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(137)).setAttribute("nombre","btnModificar" );
      ((Element)v.get(137)).setAttribute("x","80" );
      ((Element)v.get(137)).setAttribute("y","279" );
      ((Element)v.get(137)).setAttribute("ID","botonContenido" );
      ((Element)v.get(137)).setAttribute("tipo","html" );
      ((Element)v.get(137)).setAttribute("estado","false" );
      ((Element)v.get(137)).setAttribute("cod","MMGGlobal.localization.updatebutton.label" );
      ((Element)v.get(137)).setAttribute("accion","onClickModificar();" );
      ((Element)v.get(137)).setAttribute("ontab","onTab('btnModificar');" );
      ((Element)v.get(137)).setAttribute("onshtab","onShTab('btnModificar');" );
      ((Element)v.get(79)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:79   */
      /* Termina nodo:9   */


   }

}

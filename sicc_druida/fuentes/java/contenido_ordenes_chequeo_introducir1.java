
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_ordenes_chequeo_introducir1  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_ordenes_chequeo_introducir1" );
      ((Element)v.get(0)).setAttribute("cod","0146" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","contenido_ordenes_chequeo_introducir1.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","cbMarca" );
      ((Element)v.get(5)).setAttribute("required","true" );
      ((Element)v.get(5)).setAttribute("cod","6" );
      ((Element)v.get(5)).setAttribute("group","encabezado" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","cbCanal" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","7" );
      ((Element)v.get(6)).setAttribute("group","encabezado" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbPeriodo" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","276" );
      ((Element)v.get(7)).setAttribute("group","encabezado" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtCantidadTotal" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","2400" );
      ((Element)v.get(8)).setAttribute("format","E" );
      ((Element)v.get(8)).setAttribute("min","0" );
      ((Element)v.get(8)).setAttribute("max","999999" );
      ((Element)v.get(8)).setAttribute("group","CHEQUEO" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cblPeriodoInicialEvaluacion2" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","1674" );
      ((Element)v.get(9)).setAttribute("group","CHEQUEO" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbPeriodoFinalEvaluacion2" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","1739" );
      ((Element)v.get(10)).setAttribute("group","CHEQUEO" );
      ((Element)v.get(4)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbPeriodoReclamoEvaluacion" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","2401" );
      ((Element)v.get(11)).setAttribute("group","CHEQUEO" );
      ((Element)v.get(4)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbSubgerenciaVentas2" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","124" );
      ((Element)v.get(12)).setAttribute("group","GEO" );
      ((Element)v.get(4)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:4   */

      /* Empieza nodo:13 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(13)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(17)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(13)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","accion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","idioma" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","pais" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","casoUso" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","oidChequeo" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","tipoOrdenChequeo" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","nombreChequeo" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","marcaPorDefecto" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","canalPorDefecto" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","periodo" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","zonas" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hid_SeparadorMiles" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hid_SeparadorDecimales" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(31)).setAttribute("nombre","capaContenido1" );
      ((Element)v.get(31)).setAttribute("x","0" );
      ((Element)v.get(31)).setAttribute("y","0" );
      ((Element)v.get(13)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("table"));
      ((Element)v.get(32)).setAttribute("width","100%" );
      ((Element)v.get(32)).setAttribute("border","0" );
      ((Element)v.get(32)).setAttribute("cellspacing","0" );
      ((Element)v.get(32)).setAttribute("cellpadding","0" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).setAttribute("width","12" );
      ((Element)v.get(34)).setAttribute("align","center" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).setAttribute("width","12" );
      ((Element)v.get(35)).setAttribute("height","12" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).setAttribute("width","750" );
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("width","12" );
      ((Element)v.get(33)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","12" );
      ((Element)v.get(39)).setAttribute("height","1" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:33   */

      /* Empieza nodo:40 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(32)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(45)).setAttribute("class","legend" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(46)).setAttribute("nombre","lblOrdenesChequeo" );
      ((Element)v.get(46)).setAttribute("alto","13" );
      ((Element)v.get(46)).setAttribute("filas","1" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(46)).setAttribute("id","legend" );
      ((Element)v.get(46)).setAttribute("cod","00223" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("table"));
      ((Element)v.get(47)).setAttribute("width","100%" );
      ((Element)v.get(47)).setAttribute("border","0" );
      ((Element)v.get(47)).setAttribute("align","center" );
      ((Element)v.get(47)).setAttribute("cellspacing","0" );
      ((Element)v.get(47)).setAttribute("cellpadding","0" );
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("table"));
      ((Element)v.get(50)).setAttribute("width","600" );
      ((Element)v.get(50)).setAttribute("border","0" );
      ((Element)v.get(50)).setAttribute("align","left" );
      ((Element)v.get(50)).setAttribute("cellspacing","0" );
      ((Element)v.get(50)).setAttribute("cellpadding","0" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("colspan","3" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","8" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:54 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(54));

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
      ((Element)v.get(54)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(58)).setAttribute("nombre","lblSeleccionarChequeo" );
      ((Element)v.get(58)).setAttribute("alto","13" );
      ((Element)v.get(58)).setAttribute("filas","1" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(58)).setAttribute("id","datosTitle" );
      ((Element)v.get(58)).setAttribute("cod","2385" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("width","100%" );
      ((Element)v.get(54)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:54   */

      /* Empieza nodo:61 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(65)).setAttribute("nombre","lbldtSeleccionarChequeo" );
      ((Element)v.get(65)).setAttribute("alto","13" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(65)).setAttribute("filas","1" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(65)).setAttribute("id","datosCampos" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","100%" );
      ((Element)v.get(61)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:61   */

      /* Empieza nodo:68 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
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
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:71 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:40   */

      /* Empieza nodo:73 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("colspan","4" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","12" );
      ((Element)v.get(75)).setAttribute("height","15" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:76 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(81)).setAttribute("class","legend" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(82)).setAttribute("nombre","lblChequeoSeleccion" );
      ((Element)v.get(82)).setAttribute("alto","13" );
      ((Element)v.get(82)).setAttribute("filas","1" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(82)).setAttribute("id","legend" );
      ((Element)v.get(82)).setAttribute("cod","00263" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("table"));
      ((Element)v.get(83)).setAttribute("width","100%" );
      ((Element)v.get(83)).setAttribute("border","0" );
      ((Element)v.get(83)).setAttribute("align","center" );
      ((Element)v.get(83)).setAttribute("cellspacing","0" );
      ((Element)v.get(83)).setAttribute("cellpadding","0" );
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("table"));
      ((Element)v.get(86)).setAttribute("width","600" );
      ((Element)v.get(86)).setAttribute("border","0" );
      ((Element)v.get(86)).setAttribute("align","left" );
      ((Element)v.get(86)).setAttribute("cellspacing","0" );
      ((Element)v.get(86)).setAttribute("cellpadding","0" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("colspan","4" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:90 / Elemento padre: 86   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(86)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(94)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(94)).setAttribute("alto","13" );
      ((Element)v.get(94)).setAttribute("filas","1" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(94)).setAttribute("id","datosTitle" );
      ((Element)v.get(94)).setAttribute("cod","6" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","25" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(98)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(98)).setAttribute("alto","13" );
      ((Element)v.get(98)).setAttribute("filas","1" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(98)).setAttribute("id","datosTitle" );
      ((Element)v.get(98)).setAttribute("cod","7" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("width","100%" );
      ((Element)v.get(90)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:90   */

      /* Empieza nodo:101 / Elemento padre: 86   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(86)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(101)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(105)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(105)).setAttribute("id","datosCampos" );
      ((Element)v.get(105)).setAttribute("size","1" );
      ((Element)v.get(105)).setAttribute("onchange","cbMarcaOnChange();" );
      ((Element)v.get(105)).setAttribute("onshtab","document.all['btnAceptar'].focus();" );
      ((Element)v.get(105)).setAttribute("multiple","N" );
      ((Element)v.get(105)).setAttribute("req","S" );
      ((Element)v.get(105)).setAttribute("valorinicial","" );
      ((Element)v.get(105)).setAttribute("textoinicial","" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:107 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","25" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(101)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(110)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(110)).setAttribute("id","datosCampos" );
      ((Element)v.get(110)).setAttribute("size","1" );
      ((Element)v.get(110)).setAttribute("onchange","cbMarcaOnChange();" );
      ((Element)v.get(110)).setAttribute("multiple","N" );
      ((Element)v.get(110)).setAttribute("req","S" );
      ((Element)v.get(110)).setAttribute("valorinicial","" );
      ((Element)v.get(110)).setAttribute("textoinicial","" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:112 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("width","100%" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(101)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","8" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:101   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:114 / Elemento padre: 83   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(83)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("table"));
      ((Element)v.get(116)).setAttribute("width","600" );
      ((Element)v.get(116)).setAttribute("border","0" );
      ((Element)v.get(116)).setAttribute("align","left" );
      ((Element)v.get(116)).setAttribute("cellspacing","0" );
      ((Element)v.get(116)).setAttribute("cellpadding","0" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("colspan","3" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","8" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:120 / Elemento padre: 116   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(116)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(124)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(124)).setAttribute("alto","13" );
      ((Element)v.get(124)).setAttribute("filas","1" );
      ((Element)v.get(124)).setAttribute("valor","" );
      ((Element)v.get(124)).setAttribute("id","datosTitle" );
      ((Element)v.get(124)).setAttribute("cod","276" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("width","100%" );
      ((Element)v.get(120)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:120   */

      /* Empieza nodo:127 / Elemento padre: 116   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(116)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
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
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(127)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(131)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(131)).setAttribute("id","datosCampos" );
      ((Element)v.get(131)).setAttribute("size","1" );
      ((Element)v.get(131)).setAttribute("multiple","N" );
      ((Element)v.get(131)).setAttribute("req","S" );
      ((Element)v.get(131)).setAttribute("valorinicial","" );
      ((Element)v.get(131)).setAttribute("textoinicial","" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:133 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("width","100%" );
      ((Element)v.get(127)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","8" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:127   */

      /* Empieza nodo:135 / Elemento padre: 116   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(116)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("colspan","3" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","8" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:83   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:76   */

      /* Empieza nodo:138 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("table"));
      ((Element)v.get(143)).setAttribute("width","100%" );
      ((Element)v.get(143)).setAttribute("border","0" );
      ((Element)v.get(143)).setAttribute("align","center" );
      ((Element)v.get(143)).setAttribute("cellspacing","0" );
      ((Element)v.get(143)).setAttribute("cellpadding","0" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("class","botonera" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(146)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(146)).setAttribute("ID","botonContenido" );
      ((Element)v.get(146)).setAttribute("ontab","focaliza(FORMULARIO + '.cbMarca')" );
      ((Element)v.get(146)).setAttribute("tipo","html" );
      ((Element)v.get(146)).setAttribute("accion","btnAceptarOnClick();" );
      ((Element)v.get(146)).setAttribute("estado","false" );
      ((Element)v.get(146)).setAttribute("cod","12" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:147 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","8" );
      ((Element)v.get(148)).setAttribute("height","12" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:138   */

      /* Empieza nodo:149 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("width","12" );
      ((Element)v.get(150)).setAttribute("align","center" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","12" );
      ((Element)v.get(151)).setAttribute("height","12" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("width","756" );
      ((Element)v.get(149)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("width","12" );
      ((Element)v.get(149)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","12" );
      ((Element)v.get(155)).setAttribute("height","1" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:149   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:156 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(156)).setAttribute("nombre","capaChequeoEnCampo" );
      ((Element)v.get(156)).setAttribute("x","0" );
      ((Element)v.get(156)).setAttribute("y","224" );
      ((Element)v.get(156)).setAttribute("visibilidad","" );
      ((Element)v.get(13)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("table"));
      ((Element)v.get(157)).setAttribute("width","100%" );
      ((Element)v.get(157)).setAttribute("border","0" );
      ((Element)v.get(157)).setAttribute("cellspacing","0" );
      ((Element)v.get(157)).setAttribute("cellpadding","0" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).setAttribute("width","12" );
      ((Element)v.get(159)).setAttribute("align","center" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","12" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(160)).setAttribute("height","12" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).setAttribute("width","750" );
      ((Element)v.get(158)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("width","12" );
      ((Element)v.get(158)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","12" );
      ((Element)v.get(164)).setAttribute("height","1" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:158   */

      /* Empieza nodo:165 / Elemento padre: 157   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(157)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(170)).setAttribute("class","legend" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(171)).setAttribute("nombre","lblChequeoCampo" );
      ((Element)v.get(171)).setAttribute("alto","13" );
      ((Element)v.get(171)).setAttribute("filas","1" );
      ((Element)v.get(171)).setAttribute("valor","" );
      ((Element)v.get(171)).setAttribute("id","legend" );
      ((Element)v.get(171)).setAttribute("cod","00585" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 169   */
      v.add(doc.createElement("table"));
      ((Element)v.get(172)).setAttribute("width","100%" );
      ((Element)v.get(172)).setAttribute("border","0" );
      ((Element)v.get(172)).setAttribute("align","center" );
      ((Element)v.get(172)).setAttribute("cellspacing","0" );
      ((Element)v.get(172)).setAttribute("cellpadding","0" );
      ((Element)v.get(169)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("table"));
      ((Element)v.get(175)).setAttribute("width","705" );
      ((Element)v.get(175)).setAttribute("border","0" );
      ((Element)v.get(175)).setAttribute("align","left" );
      ((Element)v.get(175)).setAttribute("cellspacing","0" );
      ((Element)v.get(175)).setAttribute("cellpadding","0" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).setAttribute("colspan","4" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","8" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:179 / Elemento padre: 175   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("colspan","3" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(183)).setAttribute("nombre","lblCantidadTotal" );
      ((Element)v.get(183)).setAttribute("alto","13" );
      ((Element)v.get(183)).setAttribute("filas","1" );
      ((Element)v.get(183)).setAttribute("valor","" );
      ((Element)v.get(183)).setAttribute("id","datosTitle" );
      ((Element)v.get(183)).setAttribute("cod","2400" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).setAttribute("width","100%" );
      ((Element)v.get(179)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","8" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:179   */

      /* Empieza nodo:186 / Elemento padre: 175   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).setAttribute("colspan","3" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(186)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(190)).setAttribute("nombre","txtCantidadTotal" );
      ((Element)v.get(190)).setAttribute("id","datosCampos" );
      ((Element)v.get(190)).setAttribute("onshtab","document.body.focus();document.all['btnAnadir2'].focus();" );
      ((Element)v.get(190)).setAttribute("max","5" );
      ((Element)v.get(190)).setAttribute("tipo","" );
      ((Element)v.get(190)).setAttribute("onblur","/*validaTotal(4);*/" );
      ((Element)v.get(190)).setAttribute("onchange","" );
      ((Element)v.get(190)).setAttribute("req","S" );
      ((Element)v.get(190)).setAttribute("size","5" );
      ((Element)v.get(190)).setAttribute("valor","" );
      ((Element)v.get(190)).setAttribute("validacion","" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).setAttribute("width","100%" );
      ((Element)v.get(186)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","8" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:186   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:193 / Elemento padre: 172   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(172)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("table"));
      ((Element)v.get(195)).setAttribute("width","705" );
      ((Element)v.get(195)).setAttribute("border","0" );
      ((Element)v.get(195)).setAttribute("align","left" );
      ((Element)v.get(195)).setAttribute("cellspacing","0" );
      ((Element)v.get(195)).setAttribute("cellpadding","0" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("colspan","4" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","8" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:199 / Elemento padre: 195   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(195)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(203)).setAttribute("nombre","lblPeriodoInicialEvaluacion2" );
      ((Element)v.get(203)).setAttribute("alto","13" );
      ((Element)v.get(203)).setAttribute("filas","1" );
      ((Element)v.get(203)).setAttribute("valor","" );
      ((Element)v.get(203)).setAttribute("id","datosTitle" );
      ((Element)v.get(203)).setAttribute("cod","1674" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","25" );
      ((Element)v.get(205)).setAttribute("height","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(207)).setAttribute("nombre","lbllPeriodoFinalEvaluacion2" );
      ((Element)v.get(207)).setAttribute("alto","13" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(207)).setAttribute("filas","1" );
      ((Element)v.get(207)).setAttribute("valor","" );
      ((Element)v.get(207)).setAttribute("id","datosTitle" );
      ((Element)v.get(207)).setAttribute("cod","1739" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","25" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(211)).setAttribute("nombre","lbllPeriodoReclamoEvaluacion" );
      ((Element)v.get(211)).setAttribute("alto","13" );
      ((Element)v.get(211)).setAttribute("filas","1" );
      ((Element)v.get(211)).setAttribute("valor","" );
      ((Element)v.get(211)).setAttribute("id","datosTitle" );
      ((Element)v.get(211)).setAttribute("cod","2401" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).setAttribute("width","100%" );
      ((Element)v.get(199)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).setAttribute("width","8" );
      ((Element)v.get(213)).setAttribute("height","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:199   */

      /* Empieza nodo:214 / Elemento padre: 195   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(195)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","8" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(214)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(218)).setAttribute("nombre","cblPeriodoInicialEvaluacion2" );
      ((Element)v.get(218)).setAttribute("id","datosCampos" );
      ((Element)v.get(218)).setAttribute("size","1" );
      ((Element)v.get(218)).setAttribute("multiple","N" );
      ((Element)v.get(218)).setAttribute("req","S" );
      ((Element)v.get(218)).setAttribute("valorinicial","" );
      ((Element)v.get(218)).setAttribute("textoinicial","" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:220 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","25" );
      ((Element)v.get(221)).setAttribute("height","8" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(214)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(223)).setAttribute("nombre","cbPeriodoFinalEvaluacion2" );
      ((Element)v.get(223)).setAttribute("id","datosCampos" );
      ((Element)v.get(223)).setAttribute("size","1" );
      ((Element)v.get(223)).setAttribute("multiple","N" );
      ((Element)v.get(223)).setAttribute("req","S" );
      ((Element)v.get(223)).setAttribute("valorinicial","" );
      ((Element)v.get(223)).setAttribute("textoinicial","" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:225 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","25" );
      ((Element)v.get(226)).setAttribute("height","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(214)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(228)).setAttribute("nombre","cbPeriodoReclamoEvaluacion" );
      ((Element)v.get(228)).setAttribute("id","datosCampos" );
      ((Element)v.get(228)).setAttribute("size","1" );
      ((Element)v.get(228)).setAttribute("multiple","N" );
      ((Element)v.get(228)).setAttribute("req","S" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(228)).setAttribute("valorinicial","" );
      ((Element)v.get(228)).setAttribute("textoinicial","" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:230 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).setAttribute("width","100%" );
      ((Element)v.get(214)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","8" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:214   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:232 / Elemento padre: 172   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(172)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("table"));
      ((Element)v.get(234)).setAttribute("width","705" );
      ((Element)v.get(234)).setAttribute("border","0" );
      ((Element)v.get(234)).setAttribute("align","left" );
      ((Element)v.get(234)).setAttribute("cellspacing","0" );
      ((Element)v.get(234)).setAttribute("cellpadding","0" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).setAttribute("colspan","4" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","8" );
      ((Element)v.get(237)).setAttribute("height","8" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:238 / Elemento padre: 234   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(234)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","8" );
      ((Element)v.get(240)).setAttribute("height","8" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(242)).setAttribute("nombre","lblConsultorasNuevas2" );
      ((Element)v.get(242)).setAttribute("alto","13" );
      ((Element)v.get(242)).setAttribute("filas","1" );
      ((Element)v.get(242)).setAttribute("valor","" );
      ((Element)v.get(242)).setAttribute("id","datosTitle" );
      ((Element)v.get(242)).setAttribute("cod","2386" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("width","100%" );
      ((Element)v.get(238)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","8" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:238   */

      /* Empieza nodo:245 / Elemento padre: 234   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(234)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","8" );
      ((Element)v.get(247)).setAttribute("height","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(249)).setAttribute("check","" );
      ((Element)v.get(249)).setAttribute("id","" );
      ((Element)v.get(249)).setAttribute("msjreq","" );
      ((Element)v.get(249)).setAttribute("nombre","chkConsultorasNuevas2" );
      ((Element)v.get(249)).setAttribute("onclick","" );
      ((Element)v.get(249)).setAttribute("ontab","focaliza(FORMULARIO + '.cbSubgerenciaVentas2')" );
      ((Element)v.get(249)).setAttribute("onshtab","focaliza(FORMULARIO + '.cbPeriodoReclamoEvaluacion')" );
      ((Element)v.get(249)).setAttribute("onfocus","" );
      ((Element)v.get(249)).setAttribute("readonly","" );
      ((Element)v.get(249)).setAttribute("req","" );
      ((Element)v.get(249)).setAttribute("tabindex","1" );
      ((Element)v.get(249)).setAttribute("texto","" );
      ((Element)v.get(249)).setAttribute("validacion","" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("width","100%" );
      ((Element)v.get(250)).setAttribute("colspan","8" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(245)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","8" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:245   */

      /* Empieza nodo:252 / Elemento padre: 234   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(234)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).setAttribute("colspan","4" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","8" );
      ((Element)v.get(254)).setAttribute("height","8" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:255 / Elemento padre: 172   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(172)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("table"));
      ((Element)v.get(257)).setAttribute("width","100%" );
      ((Element)v.get(257)).setAttribute("border","0" );
      ((Element)v.get(257)).setAttribute("align","left" );
      ((Element)v.get(257)).setAttribute("cellspacing","0" );
      ((Element)v.get(257)).setAttribute("cellpadding","0" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","8" );
      ((Element)v.get(260)).setAttribute("height","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).setAttribute("width","100%" );
      ((Element)v.get(258)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("table"));
      ((Element)v.get(262)).setAttribute("width","100%" );
      ((Element)v.get(262)).setAttribute("border","0" );
      ((Element)v.get(262)).setAttribute("cellspacing","0" );
      ((Element)v.get(262)).setAttribute("cellpadding","0" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(266)).setAttribute("class","legend" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(267)).setAttribute("nombre","lblDatosZonas" );
      ((Element)v.get(267)).setAttribute("alto","13" );
      ((Element)v.get(267)).setAttribute("filas","1" );
      ((Element)v.get(267)).setAttribute("valor","" );
      ((Element)v.get(267)).setAttribute("id","legend" );
      ((Element)v.get(267)).setAttribute("cod","00261" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 265   */
      v.add(doc.createElement("table"));
      ((Element)v.get(268)).setAttribute("width","100%" );
      ((Element)v.get(268)).setAttribute("border","0" );
      ((Element)v.get(268)).setAttribute("align","center" );
      ((Element)v.get(268)).setAttribute("cellspacing","0" );
      ((Element)v.get(268)).setAttribute("cellpadding","0" );
      ((Element)v.get(265)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("table"));
      ((Element)v.get(271)).setAttribute("width","683" );
      ((Element)v.get(271)).setAttribute("border","0" );
      ((Element)v.get(271)).setAttribute("align","left" );
      ((Element)v.get(271)).setAttribute("cellspacing","0" );
      ((Element)v.get(271)).setAttribute("cellpadding","0" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).setAttribute("colspan","3" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(274)).setAttribute("width","8" );
      ((Element)v.get(274)).setAttribute("height","7" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:275 / Elemento padre: 271   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(271)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(277)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).setAttribute("width","8" );
      ((Element)v.get(277)).setAttribute("height","8" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(279)).setAttribute("nombre","lblSubgerenciaVentas2" );
      ((Element)v.get(279)).setAttribute("alto","13" );
      ((Element)v.get(279)).setAttribute("filas","1" );
      ((Element)v.get(279)).setAttribute("valor","" );
      ((Element)v.get(279)).setAttribute("id","datosTitle" );
      ((Element)v.get(279)).setAttribute("cod","124" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).setAttribute("width","25" );
      ((Element)v.get(281)).setAttribute("height","8" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(283)).setAttribute("nombre","lblRegion2" );
      ((Element)v.get(283)).setAttribute("alto","13" );
      ((Element)v.get(283)).setAttribute("filas","1" );
      ((Element)v.get(283)).setAttribute("valor","" );
      ((Element)v.get(283)).setAttribute("id","datosTitle" );
      ((Element)v.get(283)).setAttribute("cod","109" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(284)).setAttribute("width","100%" );
      ((Element)v.get(275)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","8" );
      ((Element)v.get(285)).setAttribute("height","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:275   */

      /* Empieza nodo:286 / Elemento padre: 271   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(271)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).setAttribute("width","8" );
      ((Element)v.get(288)).setAttribute("height","8" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:289 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(286)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(290)).setAttribute("nombre","cbSubgerenciaVentas2" );
      ((Element)v.get(290)).setAttribute("id","datosCampos" );
      ((Element)v.get(290)).setAttribute("onchange","cbSubgerenciaVentasOnChange();" );
      ((Element)v.get(290)).setAttribute("size","1" );
      ((Element)v.get(290)).setAttribute("multiple","N" );
      ((Element)v.get(290)).setAttribute("req","S" );
      ((Element)v.get(290)).setAttribute("valorinicial","" );
      ((Element)v.get(290)).setAttribute("textoinicial","" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:292 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","25" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(295)).setAttribute("nombre","cbRegion2" );
      ((Element)v.get(295)).setAttribute("id","datosCampos" );
      ((Element)v.get(295)).setAttribute("onchange","cbRegionOnChange();" );
      ((Element)v.get(295)).setAttribute("size","1" );
      ((Element)v.get(295)).setAttribute("multiple","N" );
      ((Element)v.get(295)).setAttribute("req","N" );
      ((Element)v.get(295)).setAttribute("valorinicial","" );
      ((Element)v.get(295)).setAttribute("textoinicial","" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:297 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(297)).setAttribute("width","100%" );
      ((Element)v.get(286)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).setAttribute("width","8" );
      ((Element)v.get(298)).setAttribute("height","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */
      /* Termina nodo:286   */

      /* Empieza nodo:299 / Elemento padre: 271   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(271)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).setAttribute("colspan","3" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(301)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).setAttribute("width","8" );
      ((Element)v.get(301)).setAttribute("height","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */
      /* Termina nodo:299   */
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:302 / Elemento padre: 268   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(268)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("td"));
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("table"));
      ((Element)v.get(304)).setAttribute("width","683" );
      ((Element)v.get(304)).setAttribute("border","0" );
      ((Element)v.get(304)).setAttribute("align","left" );
      ((Element)v.get(304)).setAttribute("cellspacing","0" );
      ((Element)v.get(304)).setAttribute("cellpadding","0" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(304)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
      ((Element)v.get(307)).setAttribute("width","8" );
      ((Element)v.get(307)).setAttribute("height","8" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(309)).setAttribute("nombre","lblZona2" );
      ((Element)v.get(309)).setAttribute("alto","13" );
      ((Element)v.get(309)).setAttribute("filas","1" );
      ((Element)v.get(309)).setAttribute("valor","" );
      ((Element)v.get(309)).setAttribute("id","datosTitle" );
      ((Element)v.get(309)).setAttribute("cod","143" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","25" );
      ((Element)v.get(311)).setAttribute("height","8" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(313)).setAttribute("nombre","lblSeccion2" );
      ((Element)v.get(313)).setAttribute("alto","13" );
      ((Element)v.get(313)).setAttribute("filas","1" );
      ((Element)v.get(313)).setAttribute("valor","" );
      ((Element)v.get(313)).setAttribute("id","datosTitle" );
      ((Element)v.get(313)).setAttribute("cod","112" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(314)).setAttribute("width","100%" );
      ((Element)v.get(305)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(315)).setAttribute("width","8" );
      ((Element)v.get(315)).setAttribute("height","8" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */
      /* Termina nodo:305   */

      /* Empieza nodo:316 / Elemento padre: 304   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(304)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).setAttribute("width","8" );
      ((Element)v.get(318)).setAttribute("height","8" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(320)).setAttribute("nombre","cbZona2" );
      ((Element)v.get(320)).setAttribute("id","datosCampos" );
      ((Element)v.get(320)).setAttribute("size","1" );
      ((Element)v.get(320)).setAttribute("onchange","cbZonaOnChange();" );
      ((Element)v.get(320)).setAttribute("multiple","N" );
      ((Element)v.get(320)).setAttribute("req","N" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(320)).setAttribute("valorinicial","" );
      ((Element)v.get(320)).setAttribute("textoinicial","" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:322 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","25" );
      ((Element)v.get(323)).setAttribute("height","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(325)).setAttribute("nombre","cbSeccion2" );
      ((Element)v.get(325)).setAttribute("id","datosCampos" );
      ((Element)v.get(325)).setAttribute("size","1" );
      ((Element)v.get(325)).setAttribute("multiple","N" );
      ((Element)v.get(325)).setAttribute("req","N" );
      ((Element)v.get(325)).setAttribute("valorinicial","" );
      ((Element)v.get(325)).setAttribute("textoinicial","" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:327 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).setAttribute("width","100%" );
      ((Element)v.get(316)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","8" );
      ((Element)v.get(328)).setAttribute("height","8" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */
      /* Termina nodo:316   */

      /* Empieza nodo:329 / Elemento padre: 304   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(304)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(330)).setAttribute("colspan","3" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","8" );
      ((Element)v.get(331)).setAttribute("height","8" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:329   */
      /* Termina nodo:304   */
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:268   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:258   */

      /* Empieza nodo:332 / Elemento padre: 257   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(257)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("table"));
      ((Element)v.get(337)).setAttribute("width","100%" );
      ((Element)v.get(337)).setAttribute("border","0" );
      ((Element)v.get(337)).setAttribute("align","center" );
      ((Element)v.get(337)).setAttribute("cellspacing","0" );
      ((Element)v.get(337)).setAttribute("cellpadding","0" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(337)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).setAttribute("class","botonera" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(340)).setAttribute("nombre","btnAnadir2" );
      ((Element)v.get(340)).setAttribute("ID","botonContenido" );
      ((Element)v.get(340)).setAttribute("tipo","html" );
      ((Element)v.get(340)).setAttribute("ontab","focaliza(FORMULARIO + '.txtCantidadTotal')" );
      ((Element)v.get(340)).setAttribute("accion","btnAnyadirOnClick()" );
      ((Element)v.get(340)).setAttribute("estado","false" );
      ((Element)v.get(340)).setAttribute("cod","404" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:338   */
      /* Termina nodo:337   */
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:341 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","8" );
      ((Element)v.get(342)).setAttribute("height","12" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */
      /* Termina nodo:332   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:343 / Elemento padre: 172   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(172)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).setAttribute("colspan","4" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(345)).setAttribute("src","b.gif" );
      ((Element)v.get(345)).setAttribute("width","8" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(345)).setAttribute("height","331" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */
      /* Termina nodo:343   */
      /* Termina nodo:172   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:346 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(347)).setAttribute("src","b.gif" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */
      /* Termina nodo:165   */

      /* Empieza nodo:348 / Elemento padre: 157   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(157)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).setAttribute("width","12" );
      ((Element)v.get(349)).setAttribute("align","center" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(350)).setAttribute("src","b.gif" );
      ((Element)v.get(350)).setAttribute("width","12" );
      ((Element)v.get(350)).setAttribute("height","12" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).setAttribute("width","750" );
      ((Element)v.get(348)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(352)).setAttribute("src","b.gif" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:353 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).setAttribute("width","12" );
      ((Element)v.get(348)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(354)).setAttribute("src","b.gif" );
      ((Element)v.get(354)).setAttribute("width","12" );
      ((Element)v.get(354)).setAttribute("height","1" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */
      /* Termina nodo:348   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:355 / Elemento padre: 13   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(355)).setAttribute("nombre","listado2" );
      ((Element)v.get(355)).setAttribute("ancho","686" );
      ((Element)v.get(355)).setAttribute("alto","295" );
      ((Element)v.get(355)).setAttribute("x","24" );
      ((Element)v.get(355)).setAttribute("y","535" );
      ((Element)v.get(355)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(355)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(13)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(356)).setAttribute("precarga","S" );
      ((Element)v.get(356)).setAttribute("conROver","S" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(357)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(357)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(357)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(357)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */

      /* Empieza nodo:358 / Elemento padre: 356   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(358)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(358)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(358)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(358)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(356)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 356   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(359)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(359)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(356)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:356   */

      /* Empieza nodo:360 / Elemento padre: 355   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(355)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(361)).setAttribute("borde","1" );
      ((Element)v.get(361)).setAttribute("horizDatos","1" );
      ((Element)v.get(361)).setAttribute("horizCabecera","1" );
      ((Element)v.get(361)).setAttribute("vertical","1" );
      ((Element)v.get(361)).setAttribute("horizTitulo","1" );
      ((Element)v.get(361)).setAttribute("horizBase","1" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 360   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(362)).setAttribute("borde","#999999" );
      ((Element)v.get(362)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(362)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(362)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(362)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(362)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(362)).setAttribute("horizBase","#999999" );
      ((Element)v.get(360)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:360   */

      /* Empieza nodo:363 / Elemento padre: 355   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(363)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(363)).setAttribute("alto","22" );
      ((Element)v.get(363)).setAttribute("imgFondo","" );
      ((Element)v.get(363)).setAttribute("cod","1309" );
      ((Element)v.get(363)).setAttribute("ID","datosTitle" );
      ((Element)v.get(355)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */

      /* Empieza nodo:364 / Elemento padre: 355   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(364)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(364)).setAttribute("permiteOrdenar","S" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(364)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(364)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(364)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(364)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(355)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(365)).setAttribute("ancho","100" );
      ((Element)v.get(365)).setAttribute("minimizable","S" );
      ((Element)v.get(365)).setAttribute("minimizada","N" );
      ((Element)v.get(365)).setAttribute("oculta","S" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */

      /* Empieza nodo:366 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(366)).setAttribute("ancho","100" );
      ((Element)v.get(366)).setAttribute("minimizable","S" );
      ((Element)v.get(366)).setAttribute("minimizada","N" );
      ((Element)v.get(366)).setAttribute("oculta","S" );
      ((Element)v.get(364)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */

      /* Empieza nodo:367 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(367)).setAttribute("ancho","100" );
      ((Element)v.get(367)).setAttribute("minimizable","S" );
      ((Element)v.get(367)).setAttribute("minimizada","N" );
      ((Element)v.get(364)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */

      /* Empieza nodo:368 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(368)).setAttribute("ancho","100" );
      ((Element)v.get(368)).setAttribute("minimizable","S" );
      ((Element)v.get(368)).setAttribute("minimizada","N" );
      ((Element)v.get(368)).setAttribute("oculta","S" );
      ((Element)v.get(364)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */

      /* Empieza nodo:369 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(369)).setAttribute("ancho","80" );
      ((Element)v.get(369)).setAttribute("minimizable","S" );
      ((Element)v.get(369)).setAttribute("minimizada","N" );
      ((Element)v.get(364)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */

      /* Empieza nodo:370 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(370)).setAttribute("ancho","100" );
      ((Element)v.get(370)).setAttribute("minimizable","S" );
      ((Element)v.get(370)).setAttribute("minimizada","N" );
      ((Element)v.get(370)).setAttribute("oculta","S" );
      ((Element)v.get(364)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */

      /* Empieza nodo:371 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(371)).setAttribute("ancho","80" );
      ((Element)v.get(371)).setAttribute("minimizable","S" );
      ((Element)v.get(371)).setAttribute("minimizada","N" );
      ((Element)v.get(364)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */

      /* Empieza nodo:372 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(372)).setAttribute("ancho","100" );
      ((Element)v.get(372)).setAttribute("minimizable","S" );
      ((Element)v.get(372)).setAttribute("minimizada","N" );
      ((Element)v.get(372)).setAttribute("oculta","S" );
      ((Element)v.get(364)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */

      /* Empieza nodo:373 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(373)).setAttribute("ancho","80" );
      ((Element)v.get(373)).setAttribute("minimizable","S" );
      ((Element)v.get(373)).setAttribute("minimizada","N" );
      ((Element)v.get(364)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:364   */

      /* Empieza nodo:374 / Elemento padre: 355   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(374)).setAttribute("alto","20" );
      ((Element)v.get(374)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(374)).setAttribute("imgFondo","" );
      ((Element)v.get(374)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(355)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(375)).setAttribute("colFondo","" );
      ((Element)v.get(375)).setAttribute("ID","EstCab" );
      ((Element)v.get(375)).setAttribute("cod","124" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */

      /* Empieza nodo:376 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(376)).setAttribute("colFondo","" );
      ((Element)v.get(376)).setAttribute("ID","EstCab" );
      ((Element)v.get(376)).setAttribute("cod","124" );
      ((Element)v.get(374)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */

      /* Empieza nodo:377 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(377)).setAttribute("colFondo","" );
      ((Element)v.get(377)).setAttribute("ID","EstCab" );
      ((Element)v.get(377)).setAttribute("cod","124" );
      ((Element)v.get(374)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */

      /* Empieza nodo:378 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(378)).setAttribute("colFondo","" );
      ((Element)v.get(378)).setAttribute("ID","EstCab" );
      ((Element)v.get(378)).setAttribute("cod","124" );
      ((Element)v.get(374)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */

      /* Empieza nodo:379 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(379)).setAttribute("colFondo","" );
      ((Element)v.get(379)).setAttribute("ID","EstCab" );
      ((Element)v.get(379)).setAttribute("cod","109" );
      ((Element)v.get(374)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */

      /* Empieza nodo:380 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(380)).setAttribute("colFondo","" );
      ((Element)v.get(380)).setAttribute("ID","EstCab" );
      ((Element)v.get(380)).setAttribute("cod","124" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(374)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */

      /* Empieza nodo:381 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(381)).setAttribute("colFondo","" );
      ((Element)v.get(381)).setAttribute("ID","EstCab" );
      ((Element)v.get(381)).setAttribute("cod","143" );
      ((Element)v.get(374)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */

      /* Empieza nodo:382 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(382)).setAttribute("colFondo","" );
      ((Element)v.get(382)).setAttribute("ID","EstCab" );
      ((Element)v.get(382)).setAttribute("cod","124" );
      ((Element)v.get(374)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */

      /* Empieza nodo:383 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(383)).setAttribute("colFondo","" );
      ((Element)v.get(383)).setAttribute("ID","EstCab" );
      ((Element)v.get(383)).setAttribute("cod","112" );
      ((Element)v.get(374)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:374   */

      /* Empieza nodo:384 / Elemento padre: 355   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(384)).setAttribute("alto","22" );
      ((Element)v.get(384)).setAttribute("accion","" );
      ((Element)v.get(384)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(384)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(384)).setAttribute("maxSel","-1" );
      ((Element)v.get(384)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(384)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(384)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(384)).setAttribute("onLoad","" );
      ((Element)v.get(384)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(355)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(385)).setAttribute("tipo","texto" );
      ((Element)v.get(385)).setAttribute("ID","EstDat" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */

      /* Empieza nodo:386 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(386)).setAttribute("tipo","texto" );
      ((Element)v.get(386)).setAttribute("ID","EstDat" );
      ((Element)v.get(384)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */

      /* Empieza nodo:387 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(387)).setAttribute("tipo","texto" );
      ((Element)v.get(387)).setAttribute("ID","EstDat" );
      ((Element)v.get(384)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */

      /* Empieza nodo:388 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(388)).setAttribute("tipo","texto" );
      ((Element)v.get(388)).setAttribute("ID","EstDat" );
      ((Element)v.get(384)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */

      /* Empieza nodo:389 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(389)).setAttribute("tipo","texto" );
      ((Element)v.get(389)).setAttribute("ID","EstDat2" );
      ((Element)v.get(384)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */

      /* Empieza nodo:390 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(390)).setAttribute("tipo","texto" );
      ((Element)v.get(390)).setAttribute("ID","EstDat" );
      ((Element)v.get(384)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */

      /* Empieza nodo:391 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(391)).setAttribute("tipo","texto" );
      ((Element)v.get(391)).setAttribute("ID","EstDat" );
      ((Element)v.get(384)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */

      /* Empieza nodo:392 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(392)).setAttribute("tipo","texto" );
      ((Element)v.get(392)).setAttribute("ID","EstDat" );
      ((Element)v.get(384)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */

      /* Empieza nodo:393 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(393)).setAttribute("tipo","texto" );
      ((Element)v.get(393)).setAttribute("ID","EstDat2" );
      ((Element)v.get(384)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:384   */

      /* Empieza nodo:394 / Elemento padre: 355   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(355)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:355   */
      /* Termina nodo:13   */


   }

}

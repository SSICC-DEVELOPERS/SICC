
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_datos_cupones_introducir  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_datos_cupones_introducir" );
      ((Element)v.get(0)).setAttribute("cod","0168" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Introducir cupon 3" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
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
      ((Element)v.get(3)).setAttribute("src","ccc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","contenido_datos_cupones_introducir.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","textFechaDocumento" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","383" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","textCodCliente" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","263" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","textImporte" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","573" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbBanco" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","637" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:6   */

      /* Empieza nodo:11 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(11)).setAttribute("nombre","frmCapturarCupon" );
      ((Element)v.get(11)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","accion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","idioma" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","pais" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","casoUso" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","longitudCodigoCliente" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","marca" );
      ((Element)v.get(21)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(11)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","canal" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","periodo" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","anyo" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","mes" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","numero" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","fechaDigit" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","refExterna" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","observaciones" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hid_SeparadorMiles" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hid_NumeroDecimales" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hid_SeparadorDecimales" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 11   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(33)).setAttribute("nombre","capaUnica" );
      ((Element)v.get(33)).setAttribute("alto","362" );
      ((Element)v.get(33)).setAttribute("ancho","100%" );
      ((Element)v.get(11)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("table"));
      ((Element)v.get(34)).setAttribute("width","100%" );
      ((Element)v.get(34)).setAttribute("border","0" );
      ((Element)v.get(34)).setAttribute("cellspacing","0" );
      ((Element)v.get(34)).setAttribute("cellpadding","0" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).setAttribute("width","12" );
      ((Element)v.get(36)).setAttribute("align","center" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).setAttribute("width","12" );
      ((Element)v.get(37)).setAttribute("height","12" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("width","750" );
      ((Element)v.get(35)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("width","12" );
      ((Element)v.get(35)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","12" );
      ((Element)v.get(41)).setAttribute("height","1" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:35   */

      /* Empieza nodo:42 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(47)).setAttribute("class","legend" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(48)).setAttribute("nombre","lblTitCritBusc" );
      ((Element)v.get(48)).setAttribute("alto","13" );
      ((Element)v.get(48)).setAttribute("filas","1" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(48)).setAttribute("cod","0083" );
      ((Element)v.get(48)).setAttribute("id","legend" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 46   */
      v.add(doc.createElement("table"));
      ((Element)v.get(49)).setAttribute("width","100%" );
      ((Element)v.get(49)).setAttribute("border","0" );
      ((Element)v.get(49)).setAttribute("align","center" );
      ((Element)v.get(49)).setAttribute("cellspacing","0" );
      ((Element)v.get(49)).setAttribute("cellpadding","0" );
      ((Element)v.get(46)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("table"));
      ((Element)v.get(52)).setAttribute("width","600" );
      ((Element)v.get(52)).setAttribute("border","0" );
      ((Element)v.get(52)).setAttribute("align","left" );
      ((Element)v.get(52)).setAttribute("cellspacing","0" );
      ((Element)v.get(52)).setAttribute("cellpadding","0" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("colspan","4" );
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
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(60)).setAttribute("nombre","lblAno" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("id","datosTitle" );
      ((Element)v.get(60)).setAttribute("cod","171" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","25" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(64)).setAttribute("nombre","lblMes" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(64)).setAttribute("id","datosTitle" );
      ((Element)v.get(64)).setAttribute("cod","674" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","25" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(68)).setAttribute("nombre","lblNumero" );
      ((Element)v.get(68)).setAttribute("alto","13" );
      ((Element)v.get(68)).setAttribute("filas","1" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(68)).setAttribute("id","datosTitle" );
      ((Element)v.get(68)).setAttribute("cod","226" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("width","100%" );
      ((Element)v.get(56)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:56   */

      /* Empieza nodo:71 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(71));

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
      ((Element)v.get(75)).setAttribute("nombre","lblAnoActual" );
      ((Element)v.get(75)).setAttribute("alto","13" );
      ((Element)v.get(75)).setAttribute("filas","1" );
      ((Element)v.get(75)).setAttribute("valor","xx" );
      ((Element)v.get(75)).setAttribute("id","datosCampos" );
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
      ((Element)v.get(79)).setAttribute("nombre","lblMesActual" );
      ((Element)v.get(79)).setAttribute("alto","13" );
      ((Element)v.get(79)).setAttribute("filas","1" );
      ((Element)v.get(79)).setAttribute("valor","xx" );
      ((Element)v.get(79)).setAttribute("id","datosCampos" );
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
      ((Element)v.get(83)).setAttribute("nombre","lbldtNumero" );
      ((Element)v.get(83)).setAttribute("alto","13" );
      ((Element)v.get(83)).setAttribute("filas","1" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(83)).setAttribute("id","datosCampos" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("width","100%" );
      ((Element)v.get(71)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:71   */

      /* Empieza nodo:86 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("colspan","4" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","8" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:89 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("table"));
      ((Element)v.get(91)).setAttribute("width","600" );
      ((Element)v.get(91)).setAttribute("border","0" );
      ((Element)v.get(91)).setAttribute("align","left" );
      ((Element)v.get(91)).setAttribute("cellspacing","0" );
      ((Element)v.get(91)).setAttribute("cellpadding","0" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","8" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(96)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(96)).setAttribute("alto","13" );
      ((Element)v.get(96)).setAttribute("filas","1" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(96)).setAttribute("id","datosTitle" );
      ((Element)v.get(96)).setAttribute("cod","6" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","25" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(100)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(100)).setAttribute("alto","13" );
      ((Element)v.get(100)).setAttribute("filas","1" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(100)).setAttribute("id","datosTitle" );
      ((Element)v.get(100)).setAttribute("cod","7" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","25" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(104)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(104)).setAttribute("alto","13" );
      ((Element)v.get(104)).setAttribute("filas","1" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(104)).setAttribute("id","datosTitle" );
      ((Element)v.get(104)).setAttribute("cod","447" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("width","100%" );
      ((Element)v.get(92)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:92   */

      /* Empieza nodo:107 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(91)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(111)).setAttribute("nombre","lblMarcaActual" );
      ((Element)v.get(111)).setAttribute("alto","13" );
      ((Element)v.get(111)).setAttribute("filas","1" );
      ((Element)v.get(111)).setAttribute("valor","" );
      ((Element)v.get(111)).setAttribute("id","datosCampos" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","25" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(115)).setAttribute("nombre","lblCanalActual" );
      ((Element)v.get(115)).setAttribute("alto","13" );
      ((Element)v.get(115)).setAttribute("filas","1" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(115)).setAttribute("id","datosCampos" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","25" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(119)).setAttribute("nombre","lblPeriodoActual" );
      ((Element)v.get(119)).setAttribute("alto","13" );
      ((Element)v.get(119)).setAttribute("filas","1" );
      ((Element)v.get(119)).setAttribute("valor","" );
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","100%" );
      ((Element)v.get(107)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:107   */

      /* Empieza nodo:122 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(91)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("colspan","4" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","8" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:125 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("table"));
      ((Element)v.get(127)).setAttribute("width","600" );
      ((Element)v.get(127)).setAttribute("border","0" );
      ((Element)v.get(127)).setAttribute("align","left" );
      ((Element)v.get(127)).setAttribute("cellspacing","0" );
      ((Element)v.get(127)).setAttribute("cellpadding","0" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(132)).setAttribute("nombre","lblFechaDigitacion" );
      ((Element)v.get(132)).setAttribute("alto","13" );
      ((Element)v.get(132)).setAttribute("filas","1" );
      ((Element)v.get(132)).setAttribute("valor","" );
      ((Element)v.get(132)).setAttribute("id","datosTitle" );
      ((Element)v.get(132)).setAttribute("cod","647" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","25" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(136)).setAttribute("nombre","lblRefExt" );
      ((Element)v.get(136)).setAttribute("alto","13" );
      ((Element)v.get(136)).setAttribute("filas","1" );
      ((Element)v.get(136)).setAttribute("valor","" );
      ((Element)v.get(136)).setAttribute("id","datosTitle" );
      ((Element)v.get(136)).setAttribute("cod","692" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("width","100%" );
      ((Element)v.get(128)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:128   */

      /* Empieza nodo:139 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(143)).setAttribute("nombre","lblFechaDigitActual" );
      ((Element)v.get(143)).setAttribute("alto","13" );
      ((Element)v.get(143)).setAttribute("filas","1" );
      ((Element)v.get(143)).setAttribute("valor","" );
      ((Element)v.get(143)).setAttribute("id","datosCampos" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","25" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(147)).setAttribute("nombre","lblRefExtActual" );
      ((Element)v.get(147)).setAttribute("alto","13" );
      ((Element)v.get(147)).setAttribute("filas","1" );
      ((Element)v.get(147)).setAttribute("valor","" );
      ((Element)v.get(147)).setAttribute("id","datosCampos" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("width","100%" );
      ((Element)v.get(139)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","8" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:139   */

      /* Empieza nodo:150 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("colspan","4" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","8" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:153 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("table"));
      ((Element)v.get(155)).setAttribute("width","600" );
      ((Element)v.get(155)).setAttribute("border","0" );
      ((Element)v.get(155)).setAttribute("align","left" );
      ((Element)v.get(155)).setAttribute("cellspacing","0" );
      ((Element)v.get(155)).setAttribute("cellpadding","0" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","8" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(160)).setAttribute("nombre","lblObservaciones" );
      ((Element)v.get(160)).setAttribute("alto","13" );
      ((Element)v.get(160)).setAttribute("filas","1" );
      ((Element)v.get(160)).setAttribute("valor","" );
      ((Element)v.get(160)).setAttribute("id","datosTitle" );
      ((Element)v.get(160)).setAttribute("cod","169" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).setAttribute("width","100%" );
      ((Element)v.get(156)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","8" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:156   */

      /* Empieza nodo:163 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","8" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(167)).setAttribute("nombre","lblObservacionesActual" );
      ((Element)v.get(167)).setAttribute("ancho","300" );
      ((Element)v.get(167)).setAttribute("alto","45" );
      ((Element)v.get(167)).setAttribute("filas","1" );
      ((Element)v.get(167)).setAttribute("valor","" );
      ((Element)v.get(167)).setAttribute("id","datosCampos" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).setAttribute("width","100%" );
      ((Element)v.get(163)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","8" );
      ((Element)v.get(169)).setAttribute("height","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:163   */

      /* Empieza nodo:170 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).setAttribute("colspan","4" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:173 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("table"));
      ((Element)v.get(175)).setAttribute("width","600" );
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
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","8" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).setAttribute("colspan","2" );
      ((Element)v.get(176)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(180)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(180)).setAttribute("alto","13" );
      ((Element)v.get(180)).setAttribute("filas","1" );
      ((Element)v.get(180)).setAttribute("valor","" );
      ((Element)v.get(180)).setAttribute("id","datosTitle" );
      ((Element)v.get(180)).setAttribute("cod","263" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","25" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(184)).setAttribute("nombre","lblBanco" );
      ((Element)v.get(184)).setAttribute("alto","13" );
      ((Element)v.get(184)).setAttribute("filas","1" );
      ((Element)v.get(184)).setAttribute("valor","" );
      ((Element)v.get(184)).setAttribute("id","datosTitle" );
      ((Element)v.get(184)).setAttribute("cod","617" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 176   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("td"));
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
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(188)).setAttribute("nombre","lblImporte" );
      ((Element)v.get(188)).setAttribute("alto","13" );
      ((Element)v.get(188)).setAttribute("filas","1" );
      ((Element)v.get(188)).setAttribute("valor","" );
      ((Element)v.get(188)).setAttribute("id","datosTitle" );
      ((Element)v.get(188)).setAttribute("cod","573" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","25" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(192)).setAttribute("nombre","lblNCupon" );
      ((Element)v.get(192)).setAttribute("alto","13" );
      ((Element)v.get(192)).setAttribute("filas","1" );
      ((Element)v.get(192)).setAttribute("valor","" );
      ((Element)v.get(192)).setAttribute("id","datosTitle" );
      ((Element)v.get(192)).setAttribute("cod","675" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","25" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(196)).setAttribute("nombre","lblFechaDocumento" );
      ((Element)v.get(196)).setAttribute("alto","13" );
      ((Element)v.get(196)).setAttribute("filas","1" );
      ((Element)v.get(196)).setAttribute("valor","" );
      ((Element)v.get(196)).setAttribute("id","datosTitle" );
      ((Element)v.get(196)).setAttribute("cod","383" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("width","100%" );
      ((Element)v.get(176)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","8" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:176   */

      /* Empieza nodo:199 / Elemento padre: 175   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).appendChild((Element)v.get(199));

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
      ((Element)v.get(202)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(199)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(203)).setAttribute("nombre","textCodCliente" );
      ((Element)v.get(203)).setAttribute("id","datosCampos" );
      ((Element)v.get(203)).setAttribute("max","15" );
      ((Element)v.get(203)).setAttribute("tipo","" );
      ((Element)v.get(203)).setAttribute("onshtab","document.all['btnVerificar'].focus();" );
      ((Element)v.get(203)).setAttribute("onblur","codigoClienteOnBlur()" );
      ((Element)v.get(203)).setAttribute("onchange","" );
      ((Element)v.get(203)).setAttribute("req","S" );
      ((Element)v.get(203)).setAttribute("size","19" );
      ((Element)v.get(203)).setAttribute("valor","" );
      ((Element)v.get(203)).setAttribute("validacion","" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","8" );
      ((Element)v.get(205)).setAttribute("height","8" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(206)).setAttribute("onclick","accionSeleccionarCliente()" );
      ((Element)v.get(204)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:204   */

      /* Empieza nodo:207 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","25" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(199)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(210)).setAttribute("nombre","cbBanco" );
      ((Element)v.get(210)).setAttribute("id","datosCampos" );
      ((Element)v.get(210)).setAttribute("size","1" );
      ((Element)v.get(210)).setAttribute("multiple","N" );
      ((Element)v.get(210)).setAttribute("req","S" );
      ((Element)v.get(210)).setAttribute("valorinicial","" );
      ((Element)v.get(210)).setAttribute("textoinicial","" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:212 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).setAttribute("width","25" );
      ((Element)v.get(213)).setAttribute("height","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(199)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(215)).setAttribute("nombre","textImporte" );
      ((Element)v.get(215)).setAttribute("id","datosCampos" );
      ((Element)v.get(215)).setAttribute("max","16" );
      ((Element)v.get(215)).setAttribute("tipo","" );
      ((Element)v.get(215)).setAttribute("onblur","importeOnBlur();" );
      ((Element)v.get(215)).setAttribute("onchange","" );
      ((Element)v.get(215)).setAttribute("req","S" );
      ((Element)v.get(215)).setAttribute("size","12" );
      ((Element)v.get(215)).setAttribute("valor","" );
      ((Element)v.get(215)).setAttribute("validacion","" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(217)).setAttribute("width","25" );
      ((Element)v.get(217)).setAttribute("height","8" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(199)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(219)).setAttribute("nombre","textNCupon" );
      ((Element)v.get(219)).setAttribute("id","datosCampos" );
      ((Element)v.get(219)).setAttribute("max","10" );
      ((Element)v.get(219)).setAttribute("tipo","" );
      ((Element)v.get(219)).setAttribute("onblur","onBlurNCupon();" );
      ((Element)v.get(219)).setAttribute("onchange","" );
      ((Element)v.get(219)).setAttribute("req","N" );
      ((Element)v.get(219)).setAttribute("size","12" );
      ((Element)v.get(219)).setAttribute("valor","" );
      ((Element)v.get(219)).setAttribute("validacion","" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","25" );
      ((Element)v.get(221)).setAttribute("height","8" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(199)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(223)).setAttribute("nombre","textFechaDocumento" );
      ((Element)v.get(223)).setAttribute("id","datosCampos" );
      ((Element)v.get(223)).setAttribute("max","10" );
      ((Element)v.get(223)).setAttribute("tipo","" );
      ((Element)v.get(223)).setAttribute("onblur","validaFecha()" );
      ((Element)v.get(223)).setAttribute("onchange","" );
      ((Element)v.get(223)).setAttribute("req","S" );
      ((Element)v.get(223)).setAttribute("size","12" );
      ((Element)v.get(223)).setAttribute("valor","" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(223)).setAttribute("validacion","" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("width","100%" );
      ((Element)v.get(199)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:199   */

      /* Empieza nodo:226 / Elemento padre: 175   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).setAttribute("colspan","4" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","8" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:49   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:229 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","8" );
      ((Element)v.get(230)).setAttribute("height","12" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:42   */

      /* Empieza nodo:231 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("table"));
      ((Element)v.get(236)).setAttribute("width","100%" );
      ((Element)v.get(236)).setAttribute("border","0" );
      ((Element)v.get(236)).setAttribute("align","center" );
      ((Element)v.get(236)).setAttribute("cellspacing","0" );
      ((Element)v.get(236)).setAttribute("cellpadding","0" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).setAttribute("class","botonera" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(239)).setAttribute("nombre","btnVerificar" );
      ((Element)v.get(239)).setAttribute("ID","botonContenido" );
      ((Element)v.get(239)).setAttribute("ontab","focaliza(FORMULARIO + '.textCodCliente');" );
      ((Element)v.get(239)).setAttribute("tipo","html" );
      ((Element)v.get(239)).setAttribute("accion","accionBTN_Verificar()" );
      ((Element)v.get(239)).setAttribute("estado","false" );
      ((Element)v.get(239)).setAttribute("cod","705" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:240 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(241)).setAttribute("src","b.gif" );
      ((Element)v.get(241)).setAttribute("width","8" );
      ((Element)v.get(241)).setAttribute("height","12" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:231   */

      /* Empieza nodo:242 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("width","12" );
      ((Element)v.get(243)).setAttribute("align","center" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","12" );
      ((Element)v.get(244)).setAttribute("height","12" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).setAttribute("width","750" );
      ((Element)v.get(242)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).setAttribute("width","12" );
      ((Element)v.get(242)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","12" );
      ((Element)v.get(248)).setAttribute("height","12" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:242   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:11   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_descuento_recargo_automatico_generar  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML1710(doc);
         

      getXML1800(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_descuento_recargo_automatico_generar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","contenido_descuento_recargo_automatico_generar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","ccc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbEmpresa" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","57" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbSubproceso" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","696" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","textDiasCadencia" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","640" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","textDiasCorte" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","641" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","textTipoInteres" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","701" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","textImporteFijo" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","664" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","textTipoInteres" );
      ((Element)v.get(13)).setAttribute("required","false" );
      ((Element)v.get(13)).setAttribute("min","0" );
      ((Element)v.get(13)).setAttribute("max","9999.99" );
      ((Element)v.get(13)).setAttribute("format","n" );
      ((Element)v.get(13)).setAttribute("group","gTipoInteres" );
      ((Element)v.get(13)).setAttribute("cod","701" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:6   */

      /* Empieza nodo:14 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(14)).setAttribute("nombre","frmCapturarCupon" );
      ((Element)v.get(14)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","idioma" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","pais" );
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
      ((Element)v.get(18)).setAttribute("nombre","casoUso" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","accion" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 14   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hid_SeparadorMiles" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hid_NumeroDecimales" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hid_SeparadorDecimales" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","longitudCodigoCliente" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","numero" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hid_textTipoInteres" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hid_textImporteFijo" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","anio" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","mes" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","entidades" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","oids" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 14   */
      v.add(doc.createElement("table"));
      ((Element)v.get(33)).setAttribute("width","100%" );
      ((Element)v.get(33)).setAttribute("border","0" );
      ((Element)v.get(33)).setAttribute("cellspacing","0" );
      ((Element)v.get(33)).setAttribute("cellpadding","0" );
      ((Element)v.get(14)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("width","12" );
      ((Element)v.get(35)).setAttribute("align","center" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","12" );
      ((Element)v.get(36)).setAttribute("height","12" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("width","750" );
      ((Element)v.get(34)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("width","12" );
      ((Element)v.get(34)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","12" );
      ((Element)v.get(40)).setAttribute("height","1" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:34   */

      /* Empieza nodo:41 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(46)).setAttribute("class","legend" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblTitCritBusc" );
      ((Element)v.get(47)).setAttribute("alto","13" );
      ((Element)v.get(47)).setAttribute("filas","1" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(47)).setAttribute("cod","0075" );
      ((Element)v.get(47)).setAttribute("id","legend" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 45   */
      v.add(doc.createElement("table"));
      ((Element)v.get(48)).setAttribute("width","100%" );
      ((Element)v.get(48)).setAttribute("border","0" );
      ((Element)v.get(48)).setAttribute("align","center" );
      ((Element)v.get(48)).setAttribute("cellspacing","0" );
      ((Element)v.get(48)).setAttribute("cellpadding","0" );
      ((Element)v.get(45)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("table"));
      ((Element)v.get(51)).setAttribute("width","712" );
      ((Element)v.get(51)).setAttribute("border","0" );
      ((Element)v.get(51)).setAttribute("align","left" );
      ((Element)v.get(51)).setAttribute("cellspacing","0" );
      ((Element)v.get(51)).setAttribute("cellpadding","0" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("colspan","4" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","8" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:55 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(59)).setAttribute("nombre","lblNumero" );
      ((Element)v.get(59)).setAttribute("alto","13" );
      ((Element)v.get(59)).setAttribute("filas","1" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(59)).setAttribute("id","datosTitle" );
      ((Element)v.get(59)).setAttribute("cod","226" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","25" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(63)).setAttribute("nombre","lblAno" );
      ((Element)v.get(63)).setAttribute("alto","13" );
      ((Element)v.get(63)).setAttribute("filas","1" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(63)).setAttribute("id","datosTitle" );
      ((Element)v.get(63)).setAttribute("cod","171" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","25" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(67)).setAttribute("nombre","lblMes" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(67)).setAttribute("alto","13" );
      ((Element)v.get(67)).setAttribute("filas","1" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(67)).setAttribute("id","datosTitle" );
      ((Element)v.get(67)).setAttribute("cod","674" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","25" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(71)).setAttribute("nombre","lblFechaDoc" );
      ((Element)v.get(71)).setAttribute("alto","13" );
      ((Element)v.get(71)).setAttribute("filas","1" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(71)).setAttribute("id","datosTitle" );
      ((Element)v.get(71)).setAttribute("cod","383" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","25" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(75)).setAttribute("nombre","lblEmpresa" );
      ((Element)v.get(75)).setAttribute("alto","13" );
      ((Element)v.get(75)).setAttribute("filas","1" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(75)).setAttribute("id","datosTitle" );
      ((Element)v.get(75)).setAttribute("cod","57" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("width","100%" );
      ((Element)v.get(55)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","8" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:55   */

      /* Empieza nodo:78 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","8" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(82)).setAttribute("nombre","lblNLoteActual" );
      ((Element)v.get(82)).setAttribute("alto","13" );
      ((Element)v.get(82)).setAttribute("filas","1" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(82)).setAttribute("id","datosCampos" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","25" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(86)).setAttribute("nombre","lblAnoActual" );
      ((Element)v.get(86)).setAttribute("alto","13" );
      ((Element)v.get(86)).setAttribute("filas","1" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(86)).setAttribute("id","datosCampos" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","25" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(78)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(90)).setAttribute("nombre","lblMesActual" );
      ((Element)v.get(90)).setAttribute("alto","13" );
      ((Element)v.get(90)).setAttribute("filas","1" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(90)).setAttribute("id","datosCampos" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","25" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(94)).setAttribute("nombre","lbldtFechaDoc" );
      ((Element)v.get(94)).setAttribute("alto","13" );
      ((Element)v.get(94)).setAttribute("filas","1" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(94)).setAttribute("id","datosCampos" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","25" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(78)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(98)).setAttribute("nombre","cbEmpresa" );
      ((Element)v.get(98)).setAttribute("id","datosCampos" );
      ((Element)v.get(98)).setAttribute("size","1" );
      ((Element)v.get(98)).setAttribute("onshtab","cbEmpresaOnShTab()" );
      ((Element)v.get(98)).setAttribute("multiple","N" );
      ((Element)v.get(98)).setAttribute("req","S" );
      ((Element)v.get(98)).setAttribute("valorinicial","" );
      ((Element)v.get(98)).setAttribute("textoinicial","" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:100 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("width","100%" );
      ((Element)v.get(78)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:78   */

      /* Empieza nodo:102 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("colspan","4" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:105 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("table"));
      ((Element)v.get(107)).setAttribute("width","712" );
      ((Element)v.get(107)).setAttribute("border","0" );
      ((Element)v.get(107)).setAttribute("align","left" );
      ((Element)v.get(107)).setAttribute("cellspacing","0" );
      ((Element)v.get(107)).setAttribute("cellpadding","0" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","8" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(112)).setAttribute("nombre","lblSubproceso" );
      ((Element)v.get(112)).setAttribute("alto","13" );
      ((Element)v.get(112)).setAttribute("filas","1" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(112)).setAttribute("valor","" );
      ((Element)v.get(112)).setAttribute("id","datosTitle" );
      ((Element)v.get(112)).setAttribute("cod","696" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","25" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(116)).setAttribute("nombre","lblReferenciaExterna" );
      ((Element)v.get(116)).setAttribute("alto","13" );
      ((Element)v.get(116)).setAttribute("filas","1" );
      ((Element)v.get(116)).setAttribute("valor","" );
      ((Element)v.get(116)).setAttribute("id","datosTitle" );
      ((Element)v.get(116)).setAttribute("cod","692" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("width","100%" );
      ((Element)v.get(108)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:108   */

      /* Empieza nodo:119 / Elemento padre: 107   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(107)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(119)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(123)).setAttribute("nombre","cbSubproceso" );
      ((Element)v.get(123)).setAttribute("id","datosCampos" );
      ((Element)v.get(123)).setAttribute("size","1" );
      ((Element)v.get(123)).setAttribute("multiple","N" );
      ((Element)v.get(123)).setAttribute("req","S" );
      ((Element)v.get(123)).setAttribute("valorinicial","" );
      ((Element)v.get(123)).setAttribute("textoinicial","" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:125 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","25" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("valign","bottom" );
      ((Element)v.get(119)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(128)).setAttribute("nombre","textReferenciaExterna" );
      ((Element)v.get(128)).setAttribute("id","datosCampos" );
      ((Element)v.get(128)).setAttribute("max","20" );
      ((Element)v.get(128)).setAttribute("tipo","" );
      ((Element)v.get(128)).setAttribute("onchange","" );
      ((Element)v.get(128)).setAttribute("req","N" );
      ((Element)v.get(128)).setAttribute("size","26" );
      ((Element)v.get(128)).setAttribute("valor","" );
      ((Element)v.get(128)).setAttribute("validacion","" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","100%" );
      ((Element)v.get(119)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:119   */

      /* Empieza nodo:131 / Elemento padre: 107   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(107)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("colspan","4" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:134 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("table"));
      ((Element)v.get(136)).setAttribute("width","712" );
      ((Element)v.get(136)).setAttribute("border","0" );
      ((Element)v.get(136)).setAttribute("align","left" );
      ((Element)v.get(136)).setAttribute("cellspacing","0" );
      ((Element)v.get(136)).setAttribute("cellpadding","0" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","8" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(141)).setAttribute("nombre","lblObservaciones" );
      ((Element)v.get(141)).setAttribute("alto","13" );
      ((Element)v.get(141)).setAttribute("filas","1" );
      ((Element)v.get(141)).setAttribute("valor","" );
      ((Element)v.get(141)).setAttribute("id","datosTitle" );
      ((Element)v.get(141)).setAttribute("cod","169" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("width","100%" );
      ((Element)v.get(137)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","8" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:137   */

      /* Empieza nodo:144 / Elemento padre: 136   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(136)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(144)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(148)).setAttribute("cols","50" );
      ((Element)v.get(148)).setAttribute("id","datosCampos" );
      ((Element)v.get(148)).setAttribute("nombre","textObservaciones" );
      ((Element)v.get(148)).setAttribute("readonly","N" );
      ((Element)v.get(148)).setAttribute("req","N" );
      ((Element)v.get(148)).setAttribute("rows","3" );
      ((Element)v.get(148)).setAttribute("tabindex","2" );
      ((Element)v.get(148)).setAttribute("max","100" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("width","100%" );
      ((Element)v.get(144)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:144   */

      /* Empieza nodo:151 / Elemento padre: 136   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(136)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("colspan","4" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","8" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:154 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("table"));
      ((Element)v.get(156)).setAttribute("width","100%" );
      ((Element)v.get(156)).setAttribute("border","0" );
      ((Element)v.get(156)).setAttribute("align","center" );
      ((Element)v.get(156)).setAttribute("cellspacing","0" );
      ((Element)v.get(156)).setAttribute("cellpadding","0" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("width","100%" );
      ((Element)v.get(157)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("table"));
      ((Element)v.get(161)).setAttribute("width","100%" );
      ((Element)v.get(161)).setAttribute("border","0" );
      ((Element)v.get(161)).setAttribute("cellspacing","0" );
      ((Element)v.get(161)).setAttribute("cellpadding","0" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(165)).setAttribute("class","legend" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(166)).setAttribute("nombre","lblCriteriosSeleccion" );
      ((Element)v.get(166)).setAttribute("alto","13" );
      ((Element)v.get(166)).setAttribute("filas","1" );
      ((Element)v.get(166)).setAttribute("valor","" );
      ((Element)v.get(166)).setAttribute("id","legend" );
      ((Element)v.get(166)).setAttribute("cod","00275" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 164   */
      v.add(doc.createElement("table"));
      ((Element)v.get(167)).setAttribute("width","100%" );
      ((Element)v.get(167)).setAttribute("border","0" );
      ((Element)v.get(167)).setAttribute("align","center" );
      ((Element)v.get(167)).setAttribute("cellspacing","0" );
      ((Element)v.get(167)).setAttribute("cellpadding","0" );
      ((Element)v.get(164)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("table"));
      ((Element)v.get(170)).setAttribute("width","690" );
      ((Element)v.get(170)).setAttribute("border","0" );
      ((Element)v.get(170)).setAttribute("align","left" );
      ((Element)v.get(170)).setAttribute("cellspacing","0" );
      ((Element)v.get(170)).setAttribute("cellpadding","0" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("colspan","3" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","8" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:174 / Elemento padre: 170   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(170)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(178)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(178)).setAttribute("alto","13" );
      ((Element)v.get(178)).setAttribute("filas","1" );
      ((Element)v.get(178)).setAttribute("valor","" );
      ((Element)v.get(178)).setAttribute("id","datosTitle" );
      ((Element)v.get(178)).setAttribute("cod","7" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","25" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(174)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(182)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(182)).setAttribute("alto","13" );
      ((Element)v.get(182)).setAttribute("filas","1" );
      ((Element)v.get(182)).setAttribute("valor","" );
      ((Element)v.get(182)).setAttribute("id","datosTitle" );
      ((Element)v.get(182)).setAttribute("cod","10" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","25" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(186)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(186)).setAttribute("alto","13" );
      ((Element)v.get(186)).setAttribute("filas","1" );
      ((Element)v.get(186)).setAttribute("valor","" );
      ((Element)v.get(186)).setAttribute("id","datosTitle" );
      ((Element)v.get(186)).setAttribute("cod","122" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).setAttribute("width","100%" );
      ((Element)v.get(174)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:174   */

      /* Empieza nodo:189 / Elemento padre: 170   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(170)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","8" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(189)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(193)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(193)).setAttribute("id","datosCampos" );
      ((Element)v.get(193)).setAttribute("size","1" );
      ((Element)v.get(193)).setAttribute("onchange","canalOnChange()" );
      ((Element)v.get(193)).setAttribute("multiple","N" );
      ((Element)v.get(193)).setAttribute("req","N" );
      ((Element)v.get(193)).setAttribute("valorinicial","" );
      ((Element)v.get(193)).setAttribute("textoinicial","" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:195 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","25" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(189)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(198)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(198)).setAttribute("id","datosCampos" );
      ((Element)v.get(198)).setAttribute("size","1" );
      ((Element)v.get(198)).setAttribute("onchange","accesoOnChange()" );
      ((Element)v.get(198)).setAttribute("multiple","N" );
      ((Element)v.get(198)).setAttribute("req","N" );
      ((Element)v.get(198)).setAttribute("valorinicial","" );
      ((Element)v.get(198)).setAttribute("textoinicial","" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:200 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","25" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(189)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(203)).setAttribute("nombre","cbSubacceso" );
      ((Element)v.get(203)).setAttribute("id","datosCampos" );
      ((Element)v.get(203)).setAttribute("size","1" );
      ((Element)v.get(203)).setAttribute("multiple","N" );
      ((Element)v.get(203)).setAttribute("req","N" );
      ((Element)v.get(203)).setAttribute("valorinicial","" );
      ((Element)v.get(203)).setAttribute("textoinicial","" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:205 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("width","100%" );
      ((Element)v.get(189)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","8" );
      ((Element)v.get(206)).setAttribute("height","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:189   */

      /* Empieza nodo:207 / Elemento padre: 170   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(170)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("colspan","4" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:210 / Elemento padre: 167   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(167)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("table"));
      ((Element)v.get(212)).setAttribute("width","690" );
      ((Element)v.get(212)).setAttribute("border","0" );
      ((Element)v.get(212)).setAttribute("align","left" );
      ((Element)v.get(212)).setAttribute("cellspacing","0" );
      ((Element)v.get(212)).setAttribute("cellpadding","0" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","8" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).setAttribute("colspan","3" );
      ((Element)v.get(213)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(217)).setAttribute("nombre","lblClienteDesde" );
      ((Element)v.get(217)).setAttribute("alto","13" );
      ((Element)v.get(217)).setAttribute("filas","1" );
      ((Element)v.get(217)).setAttribute("valor","" );
      ((Element)v.get(217)).setAttribute("id","datosTitle" );
      ((Element)v.get(217)).setAttribute("cod","624" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","25" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).setAttribute("colspan","3" );
      ((Element)v.get(213)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(221)).setAttribute("nombre","lblClienteHasta" );
      ((Element)v.get(221)).setAttribute("alto","13" );
      ((Element)v.get(221)).setAttribute("filas","1" );
      ((Element)v.get(221)).setAttribute("valor","" );
      ((Element)v.get(221)).setAttribute("id","datosTitle" );
      ((Element)v.get(221)).setAttribute("cod","1318" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).setAttribute("width","100%" );
      ((Element)v.get(213)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","8" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:213   */

      /* Empieza nodo:224 / Elemento padre: 212   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(212)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","8" );
      ((Element)v.get(226)).setAttribute("height","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(228)).setAttribute("nombre","textClienteD" );
      ((Element)v.get(228)).setAttribute("id","datosCampos" );
      ((Element)v.get(228)).setAttribute("max","15" );
      ((Element)v.get(228)).setAttribute("tipo","" );
      ((Element)v.get(228)).setAttribute("onblur","textCodClienteOnBlur('textClienteD')" );
      ((Element)v.get(228)).setAttribute("onchange","" );
      ((Element)v.get(228)).setAttribute("req","N" );
      ((Element)v.get(228)).setAttribute("size","19" );
      ((Element)v.get(228)).setAttribute("valor","" );
      ((Element)v.get(228)).setAttribute("validacion","" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","8" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(232)).setAttribute("onclick","popupCliente('textClienteD')" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","25" );
      ((Element)v.get(234)).setAttribute("height","8" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(236)).setAttribute("nombre","textClienteH" );
      ((Element)v.get(236)).setAttribute("id","datosCampos" );
      ((Element)v.get(236)).setAttribute("max","15" );
      ((Element)v.get(236)).setAttribute("tipo","" );
      ((Element)v.get(236)).setAttribute("onblur","textCodClienteOnBlur('textClienteH')" );
      ((Element)v.get(236)).setAttribute("onchange","" );
      ((Element)v.get(236)).setAttribute("req","N" );
      ((Element)v.get(236)).setAttribute("size","19" );
      ((Element)v.get(236)).setAttribute("valor","" );
      ((Element)v.get(236)).setAttribute("validacion","" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","8" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(240)).setAttribute("onclick","popupCliente('textClienteH')" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).setAttribute("width","100%" );
      ((Element)v.get(224)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","8" );
      ((Element)v.get(242)).setAttribute("height","8" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:224   */

      /* Empieza nodo:243 / Elemento padre: 212   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(212)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).setAttribute("colspan","4" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","8" );
      ((Element)v.get(245)).setAttribute("height","8" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:246 / Elemento padre: 167   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(167)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("table"));
      ((Element)v.get(248)).setAttribute("width","690" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(248)).setAttribute("border","0" );
      ((Element)v.get(248)).setAttribute("align","left" );
      ((Element)v.get(248)).setAttribute("cellspacing","0" );
      ((Element)v.get(248)).setAttribute("cellpadding","0" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","8" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(253)).setAttribute("nombre","lblFechaDocDesde" );
      ((Element)v.get(253)).setAttribute("alto","13" );
      ((Element)v.get(253)).setAttribute("filas","1" );
      ((Element)v.get(253)).setAttribute("valor","" );
      ((Element)v.get(253)).setAttribute("id","datosTitle" );
      ((Element)v.get(253)).setAttribute("cod","648" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","25" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(257)).setAttribute("nombre","lblFechaDocHasta" );
      ((Element)v.get(257)).setAttribute("alto","13" );
      ((Element)v.get(257)).setAttribute("filas","1" );
      ((Element)v.get(257)).setAttribute("valor","" );
      ((Element)v.get(257)).setAttribute("id","datosTitle" );
      ((Element)v.get(257)).setAttribute("cod","649" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","25" );
      ((Element)v.get(259)).setAttribute("height","8" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(261)).setAttribute("nombre","lblFechaVenDesde" );
      ((Element)v.get(261)).setAttribute("alto","13" );
      ((Element)v.get(261)).setAttribute("filas","1" );
      ((Element)v.get(261)).setAttribute("valor","" );
      ((Element)v.get(261)).setAttribute("id","datosTitle" );
      ((Element)v.get(261)).setAttribute("cod","657" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","25" );
      ((Element)v.get(263)).setAttribute("height","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(265)).setAttribute("nombre","lblFechaVenHasta" );
      ((Element)v.get(265)).setAttribute("alto","13" );
      ((Element)v.get(265)).setAttribute("filas","1" );
      ((Element)v.get(265)).setAttribute("valor","" );
      ((Element)v.get(265)).setAttribute("id","datosTitle" );
      ((Element)v.get(265)).setAttribute("cod","658" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).setAttribute("width","100%" );
      ((Element)v.get(249)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(267)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).setAttribute("width","8" );
      ((Element)v.get(267)).setAttribute("height","8" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:249   */

      /* Empieza nodo:268 / Elemento padre: 248   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(248)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(270)).setAttribute("src","b.gif" );
      ((Element)v.get(270)).setAttribute("width","8" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(270)).setAttribute("height","8" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:271 / Elemento padre: 268   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(272)).setAttribute("nombre","textFechaDocD" );
      ((Element)v.get(272)).setAttribute("id","datosCampos" );
      ((Element)v.get(272)).setAttribute("max","10" );
      ((Element)v.get(272)).setAttribute("tipo","" );
      ((Element)v.get(272)).setAttribute("onblur","validaFecha('textFechaDocD')" );
      ((Element)v.get(272)).setAttribute("onchange","" );
      ((Element)v.get(272)).setAttribute("req","N" );
      ((Element)v.get(272)).setAttribute("size","12" );
      ((Element)v.get(272)).setAttribute("valor","" );
      ((Element)v.get(272)).setAttribute("validacion","" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 268   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(274)).setAttribute("width","25" );
      ((Element)v.get(274)).setAttribute("height","8" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 268   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(276)).setAttribute("nombre","textFechaDocH" );
      ((Element)v.get(276)).setAttribute("id","datosCampos" );
      ((Element)v.get(276)).setAttribute("max","10" );
      ((Element)v.get(276)).setAttribute("tipo","" );
      ((Element)v.get(276)).setAttribute("onblur","validaFecha('textFechaDocH')" );
      ((Element)v.get(276)).setAttribute("onchange","" );
      ((Element)v.get(276)).setAttribute("req","N" );
      ((Element)v.get(276)).setAttribute("size","12" );
      ((Element)v.get(276)).setAttribute("valor","" );
      ((Element)v.get(276)).setAttribute("validacion","" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 268   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).setAttribute("width","25" );
      ((Element)v.get(278)).setAttribute("height","8" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 268   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(280)).setAttribute("nombre","textFechaVenD" );
      ((Element)v.get(280)).setAttribute("id","datosCampos" );
      ((Element)v.get(280)).setAttribute("max","10" );
      ((Element)v.get(280)).setAttribute("tipo","" );
      ((Element)v.get(280)).setAttribute("onblur","validaFecha('textFechaVenD')" );
      ((Element)v.get(280)).setAttribute("onchange","" );
      ((Element)v.get(280)).setAttribute("req","N" );
      ((Element)v.get(280)).setAttribute("size","12" );
      ((Element)v.get(280)).setAttribute("valor","" );
      ((Element)v.get(280)).setAttribute("validacion","" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:281 / Elemento padre: 268   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).setAttribute("width","25" );
      ((Element)v.get(282)).setAttribute("height","8" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 268   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(284)).setAttribute("nombre","textFechaVenH" );
      ((Element)v.get(284)).setAttribute("id","datosCampos" );
      ((Element)v.get(284)).setAttribute("max","10" );
      ((Element)v.get(284)).setAttribute("tipo","" );
      ((Element)v.get(284)).setAttribute("onblur","validaFecha('textFechaVenH')" );
      ((Element)v.get(284)).setAttribute("onchange","" );
      ((Element)v.get(284)).setAttribute("req","N" );
      ((Element)v.get(284)).setAttribute("size","12" );
      ((Element)v.get(284)).setAttribute("valor","" );
      ((Element)v.get(284)).setAttribute("validacion","" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 268   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).setAttribute("width","100%" );
      ((Element)v.get(268)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(286)).setAttribute("src","b.gif" );
      ((Element)v.get(286)).setAttribute("width","8" );
      ((Element)v.get(286)).setAttribute("height","8" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:268   */

      /* Empieza nodo:287 / Elemento padre: 248   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(248)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(288)).setAttribute("colspan","4" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","8" );
      ((Element)v.get(289)).setAttribute("height","8" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */
      /* Termina nodo:287   */
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:167   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:290 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(291)).setAttribute("src","b.gif" );
      ((Element)v.get(291)).setAttribute("width","8" );
      ((Element)v.get(291)).setAttribute("height","8" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:157   */

      /* Empieza nodo:292 / Elemento padre: 156   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(156)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).setAttribute("colspan","4" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(294)).setAttribute("src","b.gif" );
      ((Element)v.get(294)).setAttribute("width","8" );
      ((Element)v.get(294)).setAttribute("height","15" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */
      /* Termina nodo:292   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:295 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(295)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("table"));
      ((Element)v.get(297)).setAttribute("width","100%" );
      ((Element)v.get(297)).setAttribute("border","0" );
      ((Element)v.get(297)).setAttribute("align","center" );
      ((Element)v.get(297)).setAttribute("cellspacing","0" );
      ((Element)v.get(297)).setAttribute("cellpadding","0" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(300)).setAttribute("src","b.gif" );
      ((Element)v.get(300)).setAttribute("width","8" );
      ((Element)v.get(300)).setAttribute("height","8" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(301)).setAttribute("width","100%" );
      ((Element)v.get(298)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("table"));
      ((Element)v.get(302)).setAttribute("width","100%" );
      ((Element)v.get(302)).setAttribute("border","0" );
      ((Element)v.get(302)).setAttribute("cellspacing","0" );
      ((Element)v.get(302)).setAttribute("cellpadding","0" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(304)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(306)).setAttribute("class","legend" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(307)).setAttribute("nombre","lblDatosCalculo" );
      ((Element)v.get(307)).setAttribute("alto","13" );
      ((Element)v.get(307)).setAttribute("filas","1" );
      ((Element)v.get(307)).setAttribute("valor","" );
      ((Element)v.get(307)).setAttribute("id","legend" );
      ((Element)v.get(307)).setAttribute("cod","00614" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 305   */
      v.add(doc.createElement("table"));
      ((Element)v.get(308)).setAttribute("width","100%" );
      ((Element)v.get(308)).setAttribute("border","0" );
      ((Element)v.get(308)).setAttribute("align","center" );
      ((Element)v.get(308)).setAttribute("cellspacing","0" );
      ((Element)v.get(308)).setAttribute("cellpadding","0" );
      ((Element)v.get(305)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("table"));
      ((Element)v.get(311)).setAttribute("width","690" );
      ((Element)v.get(311)).setAttribute("border","0" );
      ((Element)v.get(311)).setAttribute("align","left" );
      ((Element)v.get(311)).setAttribute("cellspacing","0" );
      ((Element)v.get(311)).setAttribute("cellpadding","0" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(311)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(313)).setAttribute("colspan","3" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(314)).setAttribute("src","b.gif" );
      ((Element)v.get(314)).setAttribute("width","8" );
      ((Element)v.get(314)).setAttribute("height","8" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:315 / Elemento padre: 311   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(311)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(317)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).setAttribute("width","8" );
      ((Element)v.get(317)).setAttribute("height","8" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:318 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(319)).setAttribute("nombre","lblDiasCadencia" );
      ((Element)v.get(319)).setAttribute("alto","13" );
      ((Element)v.get(319)).setAttribute("filas","1" );
      ((Element)v.get(319)).setAttribute("valor","" );
      ((Element)v.get(319)).setAttribute("id","datosTitle" );
      ((Element)v.get(319)).setAttribute("cod","640" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(321)).setAttribute("src","b.gif" );
      ((Element)v.get(321)).setAttribute("width","25" );
      ((Element)v.get(321)).setAttribute("height","8" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:322 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(323)).setAttribute("nombre","lblDiasCorte" );
      ((Element)v.get(323)).setAttribute("alto","13" );
      ((Element)v.get(323)).setAttribute("filas","1" );
      ((Element)v.get(323)).setAttribute("valor","" );
      ((Element)v.get(323)).setAttribute("id","datosTitle" );
      ((Element)v.get(323)).setAttribute("cod","641" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","25" );
      ((Element)v.get(325)).setAttribute("height","8" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(327)).setAttribute("nombre","lbltextTipoInteres" );
      ((Element)v.get(327)).setAttribute("alto","13" );
      ((Element)v.get(327)).setAttribute("filas","1" );
      ((Element)v.get(327)).setAttribute("valor","" );
      ((Element)v.get(327)).setAttribute("id","datosTitle" );
      ((Element)v.get(327)).setAttribute("cod","701" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).setAttribute("width","25" );
      ((Element)v.get(329)).setAttribute("height","8" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(331)).setAttribute("nombre","lblImporteFijo" );
      ((Element)v.get(331)).setAttribute("alto","13" );
      ((Element)v.get(331)).setAttribute("filas","1" );
      ((Element)v.get(331)).setAttribute("valor","" );
      ((Element)v.get(331)).setAttribute("id","datosTitle" );
      ((Element)v.get(331)).setAttribute("cod","664" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).setAttribute("width","100%" );
      ((Element)v.get(315)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(333)).setAttribute("src","b.gif" );
      ((Element)v.get(333)).setAttribute("width","8" );
      ((Element)v.get(333)).setAttribute("height","8" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:315   */

      /* Empieza nodo:334 / Elemento padre: 311   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(311)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","8" );
      ((Element)v.get(336)).setAttribute("height","8" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(334)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(338)).setAttribute("nombre","textDiasCadencia" );
      ((Element)v.get(338)).setAttribute("id","datosCampos" );
      ((Element)v.get(338)).setAttribute("max","3" );
      ((Element)v.get(338)).setAttribute("tipo","" );
      ((Element)v.get(338)).setAttribute("onblur","soloDias('textDiasCadencia')" );
      ((Element)v.get(338)).setAttribute("onchange","" );
      ((Element)v.get(338)).setAttribute("req","S" );
      ((Element)v.get(338)).setAttribute("size","3" );
      ((Element)v.get(338)).setAttribute("valor","" );
      ((Element)v.get(338)).setAttribute("validacion","" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","25" );
      ((Element)v.get(340)).setAttribute("height","8" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(334)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(342)).setAttribute("nombre","textDiasCorte" );
      ((Element)v.get(342)).setAttribute("id","datosCampos" );
      ((Element)v.get(342)).setAttribute("max","3" );
      ((Element)v.get(342)).setAttribute("tipo","" );
      ((Element)v.get(342)).setAttribute("onblur","soloDias('textDiasCorte')" );
      ((Element)v.get(342)).setAttribute("onchange","" );
      ((Element)v.get(342)).setAttribute("req","S" );
      ((Element)v.get(342)).setAttribute("size","3" );
      ((Element)v.get(342)).setAttribute("valor","" );
      ((Element)v.get(342)).setAttribute("validacion","" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("width","25" );
      ((Element)v.get(344)).setAttribute("height","8" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(345)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(334)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(346)).setAttribute("nombre","textTipoInteres" );
      ((Element)v.get(346)).setAttribute("id","datosCampos" );
      ((Element)v.get(346)).setAttribute("max","8" );
      ((Element)v.get(346)).setAttribute("tipo","" );
      ((Element)v.get(346)).setAttribute("onblur","validarTipoInteres();" );
      ((Element)v.get(346)).setAttribute("onchange","" );
      ((Element)v.get(346)).setAttribute("req","S" );
      ((Element)v.get(346)).setAttribute("size","10" );
      ((Element)v.get(346)).setAttribute("valor","" );
      ((Element)v.get(346)).setAttribute("validacion","" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(348)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).setAttribute("width","25" );
      ((Element)v.get(348)).setAttribute("height","8" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(334)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(350)).setAttribute("nombre","textImporteFijo" );
      ((Element)v.get(350)).setAttribute("id","datosCampos" );
      ((Element)v.get(350)).setAttribute("max","16" );
      ((Element)v.get(350)).setAttribute("tipo","" );
      ((Element)v.get(350)).setAttribute("onblur","esValorNumerico('textImporteFijo', 10)" );
      ((Element)v.get(350)).setAttribute("onchange","" );
      ((Element)v.get(350)).setAttribute("req","S" );
      ((Element)v.get(350)).setAttribute("ontab","onTabImpFijo();" );
      ((Element)v.get(350)).setAttribute("size","18" );
      ((Element)v.get(350)).setAttribute("valor","" );
      ((Element)v.get(350)).setAttribute("validacion","" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).setAttribute("width","100%" );
      ((Element)v.get(334)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(352)).setAttribute("src","b.gif" );
      ((Element)v.get(352)).setAttribute("width","8" );
      ((Element)v.get(352)).setAttribute("height","8" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */
      /* Termina nodo:334   */

      /* Empieza nodo:353 / Elemento padre: 311   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(311)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(354)).setAttribute("colspan","4" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(355)).setAttribute("src","b.gif" );
      ((Element)v.get(355)).setAttribute("width","8" );
      ((Element)v.get(355)).setAttribute("height","8" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:353   */
      /* Termina nodo:311   */
      /* Termina nodo:310   */
      /* Termina nodo:309   */
      /* Termina nodo:308   */
      /* Termina nodo:305   */
      /* Termina nodo:304   */
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:356 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).setAttribute("width","8" );
      ((Element)v.get(357)).setAttribute("height","8" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:298   */

      /* Empieza nodo:358 / Elemento padre: 297   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(297)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(359)).setAttribute("colspan","4" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(360)).setAttribute("src","b.gif" );
      ((Element)v.get(360)).setAttribute("width","8" );
      ((Element)v.get(360)).setAttribute("height","8" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */
      /* Termina nodo:358   */
      /* Termina nodo:297   */
      /* Termina nodo:296   */
      /* Termina nodo:295   */
      /* Termina nodo:48   */
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:361 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(362)).setAttribute("width","8" );
      ((Element)v.get(362)).setAttribute("height","12" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:41   */

      /* Empieza nodo:363 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).setAttribute("width","12" );
      ((Element)v.get(364)).setAttribute("align","center" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(365)).setAttribute("src","b.gif" );
      ((Element)v.get(365)).setAttribute("width","12" );
      ((Element)v.get(365)).setAttribute("height","24" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:366 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).setAttribute("width","750" );
      ((Element)v.get(363)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(367)).setAttribute("src","b.gif" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).setAttribute("width","12" );
      ((Element)v.get(363)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).setAttribute("width","12" );
      ((Element)v.get(369)).setAttribute("height","24" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:363   */
      /* Termina nodo:33   */

      /* Empieza nodo:370 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(370)).setAttribute("nombre","capaLista" );
      ((Element)v.get(370)).setAttribute("ancho","100%" );
      ((Element)v.get(370)).setAttribute("alto","317" );
      ((Element)v.get(370)).setAttribute("x","12" );
      ((Element)v.get(370)).setAttribute("y","438" );
      ((Element)v.get(370)).setAttribute("borde","0" );
      ((Element)v.get(370)).setAttribute("imagenf","" );
      ((Element)v.get(370)).setAttribute("repeat","" );
      ((Element)v.get(370)).setAttribute("padding","" );
      ((Element)v.get(370)).setAttribute("visibilidad","" );
      ((Element)v.get(370)).setAttribute("contravsb","" );
      ((Element)v.get(370)).setAttribute("zindex","" );
      ((Element)v.get(14)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(371)).setAttribute("nombre","listado1" );
      ((Element)v.get(371)).setAttribute("ancho","716" );
      ((Element)v.get(371)).setAttribute("alto","317" );
      ((Element)v.get(371)).setAttribute("x","0" );
      ((Element)v.get(371)).setAttribute("y","0" );
      ((Element)v.get(371)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(371)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(372)).setAttribute("precarga","S" );
      ((Element)v.get(372)).setAttribute("conROver","S" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(371)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(373)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(373)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(373)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(373)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */

      /* Empieza nodo:374 / Elemento padre: 372   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(374)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(374)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(374)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(374)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(372)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */

      /* Empieza nodo:375 / Elemento padre: 372   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(375)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(375)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(372)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:372   */

      /* Empieza nodo:376 / Elemento padre: 371   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(371)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(377)).setAttribute("borde","1" );
      ((Element)v.get(377)).setAttribute("horizDatos","1" );
      ((Element)v.get(377)).setAttribute("horizCabecera","1" );
      ((Element)v.get(377)).setAttribute("vertical","1" );
      ((Element)v.get(377)).setAttribute("horizTitulo","1" );
      ((Element)v.get(377)).setAttribute("horizBase","1" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */

      /* Empieza nodo:378 / Elemento padre: 376   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(378)).setAttribute("borde","#999999" );
      ((Element)v.get(378)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(378)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(378)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(378)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(378)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(378)).setAttribute("horizBase","#999999" );
      ((Element)v.get(376)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:376   */

      /* Empieza nodo:379 / Elemento padre: 371   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(379)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(379)).setAttribute("alto","22" );
      ((Element)v.get(379)).setAttribute("imgFondo","" );
      ((Element)v.get(379)).setAttribute("cod","00639" );
      ((Element)v.get(379)).setAttribute("ID","datosTitle" );
      ((Element)v.get(371)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */

      /* Empieza nodo:380 / Elemento padre: 371   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(380)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(380)).setAttribute("alto","22" );
      ((Element)v.get(380)).setAttribute("imgFondo","" );
      ((Element)v.get(371)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */

      /* Empieza nodo:381 / Elemento padre: 371   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(381)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(381)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(381)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(381)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(381)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(381)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(371)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(382)).setAttribute("ancho","120" );
      ((Element)v.get(382)).setAttribute("minimizable","S" );
      ((Element)v.get(382)).setAttribute("minimizada","N" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */

      /* Empieza nodo:383 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(383)).setAttribute("ancho","120" );
      ((Element)v.get(383)).setAttribute("minimizable","S" );
      ((Element)v.get(383)).setAttribute("minimizada","N" );
      ((Element)v.get(381)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */

      /* Empieza nodo:384 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(384)).setAttribute("ancho","120" );
      ((Element)v.get(384)).setAttribute("minimizable","S" );
      ((Element)v.get(384)).setAttribute("minimizada","N" );
      ((Element)v.get(381)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */

      /* Empieza nodo:385 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(385)).setAttribute("ancho","120" );
      ((Element)v.get(385)).setAttribute("minimizable","S" );
      ((Element)v.get(385)).setAttribute("minimizada","N" );
      ((Element)v.get(381)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */

      /* Empieza nodo:386 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(386)).setAttribute("ancho","120" );
      ((Element)v.get(386)).setAttribute("minimizable","S" );
      ((Element)v.get(386)).setAttribute("minimizada","N" );
      ((Element)v.get(381)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */

      /* Empieza nodo:387 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(387)).setAttribute("ancho","120" );
      ((Element)v.get(387)).setAttribute("minimizable","S" );
      ((Element)v.get(387)).setAttribute("minimizada","N" );
      ((Element)v.get(381)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */

      /* Empieza nodo:388 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(388)).setAttribute("ancho","120" );
      ((Element)v.get(388)).setAttribute("minimizable","S" );
      ((Element)v.get(388)).setAttribute("minimizada","N" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(381)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */

      /* Empieza nodo:389 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(389)).setAttribute("ancho","120" );
      ((Element)v.get(389)).setAttribute("minimizable","S" );
      ((Element)v.get(389)).setAttribute("minimizada","N" );
      ((Element)v.get(389)).setAttribute("orden","" );
      ((Element)v.get(381)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */

      /* Empieza nodo:390 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(390)).setAttribute("ancho","120" );
      ((Element)v.get(390)).setAttribute("minimizable","S" );
      ((Element)v.get(390)).setAttribute("minimizada","N" );
      ((Element)v.get(381)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */

      /* Empieza nodo:391 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(391)).setAttribute("ancho","120" );
      ((Element)v.get(391)).setAttribute("minimizable","S" );
      ((Element)v.get(391)).setAttribute("minimizada","N" );
      ((Element)v.get(381)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */

      /* Empieza nodo:392 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(392)).setAttribute("ancho","120" );
      ((Element)v.get(392)).setAttribute("minimizable","S" );
      ((Element)v.get(392)).setAttribute("minimizada","N" );
      ((Element)v.get(381)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */

      /* Empieza nodo:393 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(393)).setAttribute("ancho","120" );
      ((Element)v.get(393)).setAttribute("minimizable","S" );
      ((Element)v.get(393)).setAttribute("minimizada","N" );
      ((Element)v.get(381)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */

      /* Empieza nodo:394 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(394)).setAttribute("ancho","120" );
      ((Element)v.get(394)).setAttribute("minimizable","S" );
      ((Element)v.get(394)).setAttribute("minimizada","N" );
      ((Element)v.get(381)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */

      /* Empieza nodo:395 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(395)).setAttribute("ancho","10" );
      ((Element)v.get(395)).setAttribute("minimizable","S" );
      ((Element)v.get(395)).setAttribute("minimizada","N" );
      ((Element)v.get(381)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:381   */

      /* Empieza nodo:396 / Elemento padre: 371   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(396)).setAttribute("alto","20" );
      ((Element)v.get(396)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(396)).setAttribute("imgFondo","" );
      ((Element)v.get(396)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(371)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(397)).setAttribute("colFondo","" );
      ((Element)v.get(397)).setAttribute("ID","EstCab" );
      ((Element)v.get(397)).setAttribute("cod","263" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */

      /* Empieza nodo:398 / Elemento padre: 396   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(398)).setAttribute("colFondo","" );
      ((Element)v.get(398)).setAttribute("ID","EstCab" );
      ((Element)v.get(398)).setAttribute("cod","1203" );
      ((Element)v.get(396)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */

      /* Empieza nodo:399 / Elemento padre: 396   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(399)).setAttribute("colFondo","" );
      ((Element)v.get(399)).setAttribute("ID","EstCab" );
      ((Element)v.get(399)).setAttribute("cod","1232" );
      ((Element)v.get(396)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */

      /* Empieza nodo:400 / Elemento padre: 396   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(400)).setAttribute("colFondo","" );
      ((Element)v.get(400)).setAttribute("ID","EstCab" );
      ((Element)v.get(400)).setAttribute("cod","1192" );
      ((Element)v.get(396)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */

      /* Empieza nodo:401 / Elemento padre: 396   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(401)).setAttribute("colFondo","" );
      ((Element)v.get(401)).setAttribute("ID","EstCab" );
      ((Element)v.get(401)).setAttribute("cod","1233" );
      ((Element)v.get(396)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */

      /* Empieza nodo:402 / Elemento padre: 396   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(402)).setAttribute("colFondo","" );
      ((Element)v.get(402)).setAttribute("ID","EstCab" );
      ((Element)v.get(402)).setAttribute("cod","692" );
      ((Element)v.get(396)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */

      /* Empieza nodo:403 / Elemento padre: 396   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(403)).setAttribute("colFondo","" );
      ((Element)v.get(403)).setAttribute("ID","EstCab" );
      ((Element)v.get(403)).setAttribute("cod","383" );
      ((Element)v.get(396)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */

      /* Empieza nodo:404 / Elemento padre: 396   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(404)).setAttribute("colFondo","" );
      ((Element)v.get(404)).setAttribute("ID","EstCab" );
      ((Element)v.get(404)).setAttribute("cod","883" );
      ((Element)v.get(396)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */

      /* Empieza nodo:405 / Elemento padre: 396   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(405)).setAttribute("colFondo","" );
      ((Element)v.get(405)).setAttribute("ID","EstCab" );
      ((Element)v.get(405)).setAttribute("cod","1205" );
      ((Element)v.get(396)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */

      /* Empieza nodo:406 / Elemento padre: 396   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(406)).setAttribute("colFondo","" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(406)).setAttribute("ID","EstCab" );
      ((Element)v.get(406)).setAttribute("cod","1206" );
      ((Element)v.get(396)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */

      /* Empieza nodo:407 / Elemento padre: 396   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(407)).setAttribute("colFondo","" );
      ((Element)v.get(407)).setAttribute("ID","EstCab" );
      ((Element)v.get(407)).setAttribute("cod","1204" );
      ((Element)v.get(396)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */

      /* Empieza nodo:408 / Elemento padre: 396   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(408)).setAttribute("colFondo","" );
      ((Element)v.get(408)).setAttribute("ID","EstCab" );
      ((Element)v.get(408)).setAttribute("cod","670" );
      ((Element)v.get(396)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */

      /* Empieza nodo:409 / Elemento padre: 396   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(409)).setAttribute("colFondo","" );
      ((Element)v.get(409)).setAttribute("ID","EstCab" );
      ((Element)v.get(409)).setAttribute("cod","1207" );
      ((Element)v.get(396)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */

      /* Empieza nodo:410 / Elemento padre: 396   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(410)).setAttribute("colFondo","" );
      ((Element)v.get(410)).setAttribute("ID","EstCab" );
      ((Element)v.get(410)).setAttribute("oculta","S" );
      ((Element)v.get(396)).appendChild((Element)v.get(410));

      /* Elemento padre:410 / Elemento actual: 411   */
      v.add(doc.createTextNode("Entidad"));
      ((Element)v.get(410)).appendChild((Text)v.get(411));

      /* Termina nodo Texto:411   */
      /* Termina nodo:410   */
      /* Termina nodo:396   */

      /* Empieza nodo:412 / Elemento padre: 371   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(412)).setAttribute("alto","22" );
      ((Element)v.get(412)).setAttribute("accion","" );
      ((Element)v.get(412)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(412)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(412)).setAttribute("maxSel","-1" );
      ((Element)v.get(412)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(412)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(412)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(412)).setAttribute("onLoad","" );
      ((Element)v.get(412)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(371)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(413)).setAttribute("tipo","texto" );
      ((Element)v.get(413)).setAttribute("ID","EstDat" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */

      /* Empieza nodo:414 / Elemento padre: 412   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(414)).setAttribute("tipo","texto" );
      ((Element)v.get(414)).setAttribute("ID","EstDat2" );
      ((Element)v.get(412)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */

      /* Empieza nodo:415 / Elemento padre: 412   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(415)).setAttribute("tipo","texto" );
      ((Element)v.get(415)).setAttribute("ID","EstDat" );
      ((Element)v.get(412)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */

      /* Empieza nodo:416 / Elemento padre: 412   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(416)).setAttribute("tipo","texto" );
      ((Element)v.get(416)).setAttribute("ID","EstDat2" );
      ((Element)v.get(412)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */

      /* Empieza nodo:417 / Elemento padre: 412   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(417)).setAttribute("tipo","texto" );
      ((Element)v.get(417)).setAttribute("ID","EstDat" );
      ((Element)v.get(412)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */

      /* Empieza nodo:418 / Elemento padre: 412   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(418)).setAttribute("tipo","texto" );
      ((Element)v.get(418)).setAttribute("ID","EstDat2" );
      ((Element)v.get(412)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */

      /* Empieza nodo:419 / Elemento padre: 412   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(419)).setAttribute("tipo","texto" );
      ((Element)v.get(419)).setAttribute("ID","EstDat" );
      ((Element)v.get(412)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */

      /* Empieza nodo:420 / Elemento padre: 412   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(420)).setAttribute("tipo","texto" );
      ((Element)v.get(420)).setAttribute("ID","EstDat2" );
      ((Element)v.get(412)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */

      /* Empieza nodo:421 / Elemento padre: 412   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(421)).setAttribute("tipo","texto" );
      ((Element)v.get(421)).setAttribute("ID","EstDat" );
      ((Element)v.get(412)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */

      /* Empieza nodo:422 / Elemento padre: 412   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(422)).setAttribute("tipo","texto" );
      ((Element)v.get(422)).setAttribute("ID","EstDat2" );
      ((Element)v.get(412)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */

      /* Empieza nodo:423 / Elemento padre: 412   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(423)).setAttribute("tipo","texto" );
      ((Element)v.get(423)).setAttribute("ID","EstDat" );
      ((Element)v.get(412)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */

      /* Empieza nodo:424 / Elemento padre: 412   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(424)).setAttribute("tipo","texto" );
      ((Element)v.get(424)).setAttribute("ID","EstDat2" );
      ((Element)v.get(412)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */

      /* Empieza nodo:425 / Elemento padre: 412   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(425)).setAttribute("tipo","texto" );
      ((Element)v.get(425)).setAttribute("ID","EstDat" );
      ((Element)v.get(412)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */

      /* Empieza nodo:426 / Elemento padre: 412   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(426)).setAttribute("tipo","texto" );
      ((Element)v.get(426)).setAttribute("ID","EstDat2" );
      ((Element)v.get(412)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:412   */

      /* Empieza nodo:427 / Elemento padre: 371   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(371)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */

      /* Empieza nodo:428 / Elemento padre: 371   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(428)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(428)).setAttribute("ancho","716" );
      ((Element)v.get(428)).setAttribute("sep","$" );
      ((Element)v.get(428)).setAttribute("x","0" );
      ((Element)v.get(428)).setAttribute("class","botonera" );
      ((Element)v.get(428)).setAttribute("y","294" );
      ((Element)v.get(428)).setAttribute("control","|" );
      ((Element)v.get(428)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(428)).setAttribute("rowset","" );
      ((Element)v.get(428)).setAttribute("cargainicial","N" );
      ((Element)v.get(428)).setAttribute("onload","" );
      ((Element)v.get(371)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:371   */

      /* Empieza nodo:429 / Elemento padre: 370   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(429)).setAttribute("nombre","Confirmar" );
      ((Element)v.get(429)).setAttribute("x","1" );
      ((Element)v.get(429)).setAttribute("y","295" );
      ((Element)v.get(429)).setAttribute("ID","botonContenido" );
      ((Element)v.get(429)).setAttribute("accion","btnConfirmar()" );
      ((Element)v.get(429)).setAttribute("tipo","html" );
      ((Element)v.get(429)).setAttribute("onshtab","btnConfirmarOnshTab()" );
      ((Element)v.get(429)).setAttribute("estado","false" );
      ((Element)v.get(429)).setAttribute("cod","633" );
      ((Element)v.get(370)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */

      /* Empieza nodo:430 / Elemento padre: 370   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(430)).setAttribute("nombre","Insertar" );
      ((Element)v.get(430)).setAttribute("x","71" );
      ((Element)v.get(430)).setAttribute("y","295" );
      ((Element)v.get(430)).setAttribute("ID","botonContenido" );
      ((Element)v.get(430)).setAttribute("accion","btnInsertar()" );
      ((Element)v.get(430)).setAttribute("tipo","html" );
      ((Element)v.get(430)).setAttribute("ontab","btnInsertarOnTab()" );
      ((Element)v.get(430)).setAttribute("estado","false" );
      ((Element)v.get(430)).setAttribute("cod","1217" );
      ((Element)v.get(370)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:370   */

      /* Empieza nodo:431 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(431)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(431)).setAttribute("alto","12" );
      ((Element)v.get(431)).setAttribute("ancho","100%" );
      ((Element)v.get(431)).setAttribute("colorf","" );
      ((Element)v.get(431)).setAttribute("borde","0" );
      ((Element)v.get(431)).setAttribute("imagenf","" );
      ((Element)v.get(431)).setAttribute("repeat","" );
      ((Element)v.get(431)).setAttribute("padding","" );
      ((Element)v.get(431)).setAttribute("visibilidad","visible" );
      ((Element)v.get(431)).setAttribute("contravsb","" );
      ((Element)v.get(431)).setAttribute("x","0" );
      ((Element)v.get(431)).setAttribute("y","755" );
      ((Element)v.get(431)).setAttribute("zindex","" );
      ((Element)v.get(14)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:14   */


   }

}

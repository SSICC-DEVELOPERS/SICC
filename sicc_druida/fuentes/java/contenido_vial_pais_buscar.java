
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_vial_pais_buscar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_vial_pais_buscar" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("cod","071" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","inicializacion()" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_vial_pais_buscar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(5)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","comboTipoVia" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","215" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtNombreVia" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","216" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtNumero" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("format","e" );
      ((Element)v.get(9)).setAttribute("cod","226" );
      ((Element)v.get(9)).setAttribute("min","0" );
      ((Element)v.get(9)).setAttribute("max","999999" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","comboUnidad1" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","217" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","comboUnidad2" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","218" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","comboUnidad3" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","219" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:13 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(13)).setAttribute("nombre","frmDatos" );
      ((Element)v.get(0)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","accion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hPais" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hOidUG" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hComboTipoVia" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hDescComboTipoVia" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hTxtNombreVia" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 13   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hTxtNumero" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hComboUnidad1" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hComboUnidad2" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hComboUnidad3" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hComboUnidad4" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hComboUnidad5" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hComboUnidad6" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hComboUnidad7" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hComboUnidad8" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hComboUnidad9" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hContComboUnidad1" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hContComboUnidad2" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hContComboUnidad3" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hContComboUnidad4" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hContComboUnidad5" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hContComboUnidad6" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hContComboUnidad7" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hContComboUnidad8" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hContComboUnidad9" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hFormatoDef" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hUltimoOidUG" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(44)).setAttribute("nombre","capaFormulario" );
      ((Element)v.get(44)).setAttribute("x","0" );
      ((Element)v.get(44)).setAttribute("y","0" );
      ((Element)v.get(44)).setAttribute("ancho","100%" );
      ((Element)v.get(44)).setAttribute("alto","100%" );
      ((Element)v.get(13)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("table"));
      ((Element)v.get(45)).setAttribute("width","100%" );
      ((Element)v.get(45)).setAttribute("border","0" );
      ((Element)v.get(45)).setAttribute("cellspacing","0" );
      ((Element)v.get(45)).setAttribute("cellpadding","0" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("width","12" );
      ((Element)v.get(47)).setAttribute("align","center" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","12" );
      ((Element)v.get(48)).setAttribute("height","12" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("width","750" );
      ((Element)v.get(46)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("width","12" );
      ((Element)v.get(46)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","12" );
      ((Element)v.get(52)).setAttribute("height","1" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:46   */

      /* Empieza nodo:53 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(58)).setAttribute("class","legend" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(59)).setAttribute("nombre","lblTitCritBusc" );
      ((Element)v.get(59)).setAttribute("alto","13" );
      ((Element)v.get(59)).setAttribute("filas","1" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(59)).setAttribute("cod","0075" );
      ((Element)v.get(59)).setAttribute("id","legend" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 57   */
      v.add(doc.createElement("table"));
      ((Element)v.get(60)).setAttribute("width","100%" );
      ((Element)v.get(60)).setAttribute("border","0" );
      ((Element)v.get(60)).setAttribute("align","center" );
      ((Element)v.get(60)).setAttribute("cellspacing","0" );
      ((Element)v.get(60)).setAttribute("cellpadding","0" );
      ((Element)v.get(57)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("table"));
      ((Element)v.get(63)).setAttribute("width","600" );
      ((Element)v.get(63)).setAttribute("border","0" );
      ((Element)v.get(63)).setAttribute("align","left" );
      ((Element)v.get(63)).setAttribute("cellspacing","0" );
      ((Element)v.get(63)).setAttribute("cellpadding","0" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("colspan","4" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","8" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:67 / Elemento padre: 63   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(63)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","8" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(71)).setAttribute("nombre","lblTipoVia" );
      ((Element)v.get(71)).setAttribute("alto","13" );
      ((Element)v.get(71)).setAttribute("filas","1" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(71)).setAttribute("id","datosTitle" );
      ((Element)v.get(71)).setAttribute("cod","215" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","25" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(75)).setAttribute("nombre","lblNombreVia" );
      ((Element)v.get(75)).setAttribute("alto","13" );
      ((Element)v.get(75)).setAttribute("filas","1" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(75)).setAttribute("id","datosTitle" );
      ((Element)v.get(75)).setAttribute("cod","216" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","25" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(79)).setAttribute("nombre","lblNumero" );
      ((Element)v.get(79)).setAttribute("alto","13" );
      ((Element)v.get(79)).setAttribute("filas","1" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(79)).setAttribute("id","datosTitle" );
      ((Element)v.get(79)).setAttribute("cod","226" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("width","100%" );
      ((Element)v.get(67)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:67   */

      /* Empieza nodo:82 / Elemento padre: 63   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(63)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(82)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(86)).setAttribute("textoinicial","" );
      ((Element)v.get(86)).setAttribute("valorinicial","" );
      ((Element)v.get(86)).setAttribute("req","S" );
      ((Element)v.get(86)).setAttribute("multiple","N" );
      ((Element)v.get(86)).setAttribute("size","1" );
      ((Element)v.get(86)).setAttribute("id","estCombo" );
      ((Element)v.get(86)).setAttribute("nombre","comboTipoVia" );
      ((Element)v.get(86)).setAttribute("ontab","setTabFocus('comboTipoVia');" );
      ((Element)v.get(86)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnCrear');" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:88 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(89)).setAttribute("width","25" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(82)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(91)).setAttribute("nombre","txtNombreVia" );
      ((Element)v.get(91)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(91)).setAttribute("max","40" );
      ((Element)v.get(91)).setAttribute("tipo","" );
      ((Element)v.get(91)).setAttribute("onchange","" );
      ((Element)v.get(91)).setAttribute("req","S" );
      ((Element)v.get(91)).setAttribute("size","40" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(91)).setAttribute("validacion","" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","25" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("valign","bottom" );
      ((Element)v.get(82)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(95)).setAttribute("nombre","txtNumero" );
      ((Element)v.get(95)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(95)).setAttribute("max","9" );
      ((Element)v.get(95)).setAttribute("tipo","" );
      ((Element)v.get(95)).setAttribute("onchange","" );
      ((Element)v.get(95)).setAttribute("req","N" );
      ((Element)v.get(95)).setAttribute("size","10" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(95)).setAttribute("validacion","" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","100%" );
      ((Element)v.get(82)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:82   */

      /* Empieza nodo:98 / Elemento padre: 63   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(63)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("colspan","4" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:101 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("table"));
      ((Element)v.get(103)).setAttribute("width","600" );
      ((Element)v.get(103)).setAttribute("border","0" );
      ((Element)v.get(103)).setAttribute("align","left" );
      ((Element)v.get(103)).setAttribute("cellspacing","0" );
      ((Element)v.get(103)).setAttribute("cellpadding","0" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(108)).setAttribute("nombre","lblUnidad1" );
      ((Element)v.get(108)).setAttribute("alto","13" );
      ((Element)v.get(108)).setAttribute("filas","1" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(108)).setAttribute("id","datosTitle" );
      ((Element)v.get(108)).setAttribute("cod","217" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(110)).setAttribute("width","25" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(112)).setAttribute("nombre","lblUnidad2" );
      ((Element)v.get(112)).setAttribute("alto","13" );
      ((Element)v.get(112)).setAttribute("filas","1" );
      ((Element)v.get(112)).setAttribute("valor","" );
      ((Element)v.get(112)).setAttribute("id","datosTitle" );
      ((Element)v.get(112)).setAttribute("cod","218" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","100%" );
      ((Element)v.get(104)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:104   */

      /* Empieza nodo:115 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(115)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(119)).setAttribute("textoinicial","" );
      ((Element)v.get(119)).setAttribute("valorinicial","" );
      ((Element)v.get(119)).setAttribute("req","S" );
      ((Element)v.get(119)).setAttribute("multiple","N" );
      ((Element)v.get(119)).setAttribute("size","1" );
      ((Element)v.get(119)).setAttribute("id","estCombo" );
      ((Element)v.get(119)).setAttribute("nombre","comboUnidad1" );
      ((Element)v.get(119)).setAttribute("onchange","seleccionarUG(1)" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","25" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(115)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(123)).setAttribute("textoinicial","" );
      ((Element)v.get(123)).setAttribute("valorinicial","" );
      ((Element)v.get(123)).setAttribute("req","S" );
      ((Element)v.get(123)).setAttribute("multiple","N" );
      ((Element)v.get(123)).setAttribute("size","1" );
      ((Element)v.get(123)).setAttribute("id","estCombo" );
      ((Element)v.get(123)).setAttribute("nombre","comboUnidad2" );
      ((Element)v.get(123)).setAttribute("onchange","seleccionarUG(2)" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(115)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:115   */

      /* Empieza nodo:126 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("colspan","4" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:129 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("table"));
      ((Element)v.get(131)).setAttribute("width","600" );
      ((Element)v.get(131)).setAttribute("border","0" );
      ((Element)v.get(131)).setAttribute("align","left" );
      ((Element)v.get(131)).setAttribute("cellspacing","0" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(131)).setAttribute("cellpadding","0" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","8" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(136)).setAttribute("nombre","lblUnidad3" );
      ((Element)v.get(136)).setAttribute("alto","13" );
      ((Element)v.get(136)).setAttribute("filas","1" );
      ((Element)v.get(136)).setAttribute("valor","" );
      ((Element)v.get(136)).setAttribute("id","datosTitle" );
      ((Element)v.get(136)).setAttribute("cod","219" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","25" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(140)).setAttribute("nombre","lblUnidad4" );
      ((Element)v.get(140)).setAttribute("alto","13" );
      ((Element)v.get(140)).setAttribute("filas","1" );
      ((Element)v.get(140)).setAttribute("valor","" );
      ((Element)v.get(140)).setAttribute("id","datosTitle" );
      ((Element)v.get(140)).setAttribute("cod","220" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(132)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:132   */

      /* Empieza nodo:143 / Elemento padre: 131   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(131)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","8" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(143)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(147)).setAttribute("textoinicial","" );
      ((Element)v.get(147)).setAttribute("valorinicial","" );
      ((Element)v.get(147)).setAttribute("req","S" );
      ((Element)v.get(147)).setAttribute("multiple","N" );
      ((Element)v.get(147)).setAttribute("size","1" );
      ((Element)v.get(147)).setAttribute("id","estCombo" );
      ((Element)v.get(147)).setAttribute("nombre","comboUnidad3" );
      ((Element)v.get(147)).setAttribute("onchange","seleccionarUG(3)" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","25" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(143)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(151)).setAttribute("textoinicial","" );
      ((Element)v.get(151)).setAttribute("valorinicial","" );
      ((Element)v.get(151)).setAttribute("req","N" );
      ((Element)v.get(151)).setAttribute("multiple","N" );
      ((Element)v.get(151)).setAttribute("size","1" );
      ((Element)v.get(151)).setAttribute("id","estCombo" );
      ((Element)v.get(151)).setAttribute("nombre","comboUnidad4" );
      ((Element)v.get(151)).setAttribute("onchange","seleccionarUG(4)" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("width","100%" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(143)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","8" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:143   */

      /* Empieza nodo:154 / Elemento padre: 131   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(131)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("colspan","4" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:157 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("table"));
      ((Element)v.get(159)).setAttribute("width","600" );
      ((Element)v.get(159)).setAttribute("border","0" );
      ((Element)v.get(159)).setAttribute("align","left" );
      ((Element)v.get(159)).setAttribute("cellspacing","0" );
      ((Element)v.get(159)).setAttribute("cellpadding","0" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","8" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(164)).setAttribute("nombre","lblUNidad5" );
      ((Element)v.get(164)).setAttribute("alto","13" );
      ((Element)v.get(164)).setAttribute("filas","1" );
      ((Element)v.get(164)).setAttribute("valor","" );
      ((Element)v.get(164)).setAttribute("id","datosTitle" );
      ((Element)v.get(164)).setAttribute("cod","221" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","25" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(168)).setAttribute("nombre","lblUnidad6" );
      ((Element)v.get(168)).setAttribute("alto","13" );
      ((Element)v.get(168)).setAttribute("filas","1" );
      ((Element)v.get(168)).setAttribute("valor","" );
      ((Element)v.get(168)).setAttribute("id","datosTitle" );
      ((Element)v.get(168)).setAttribute("cod","222" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).setAttribute("width","100%" );
      ((Element)v.get(160)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","8" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:160   */

      /* Empieza nodo:171 / Elemento padre: 159   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(159)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","8" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(171)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(175)).setAttribute("textoinicial","" );
      ((Element)v.get(175)).setAttribute("valorinicial","" );
      ((Element)v.get(175)).setAttribute("req","N" );
      ((Element)v.get(175)).setAttribute("multiple","N" );
      ((Element)v.get(175)).setAttribute("size","1" );
      ((Element)v.get(175)).setAttribute("id","estCombo" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(175)).setAttribute("nombre","comboUnidad5" );
      ((Element)v.get(175)).setAttribute("onchange","seleccionarUG(5)" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","25" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(171)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(179)).setAttribute("textoinicial","" );
      ((Element)v.get(179)).setAttribute("valorinicial","" );
      ((Element)v.get(179)).setAttribute("req","N" );
      ((Element)v.get(179)).setAttribute("multiple","N" );
      ((Element)v.get(179)).setAttribute("size","1" );
      ((Element)v.get(179)).setAttribute("id","estCombo" );
      ((Element)v.get(179)).setAttribute("nombre","comboUnidad6" );
      ((Element)v.get(179)).setAttribute("onchange","seleccionarUG(6)" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("width","100%" );
      ((Element)v.get(171)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:171   */

      /* Empieza nodo:182 / Elemento padre: 159   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(159)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).setAttribute("colspan","4" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:185 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("table"));
      ((Element)v.get(187)).setAttribute("width","600" );
      ((Element)v.get(187)).setAttribute("border","0" );
      ((Element)v.get(187)).setAttribute("align","left" );
      ((Element)v.get(187)).setAttribute("cellspacing","0" );
      ((Element)v.get(187)).setAttribute("cellpadding","0" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","8" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(192)).setAttribute("nombre","lblUnidad7" );
      ((Element)v.get(192)).setAttribute("alto","13" );
      ((Element)v.get(192)).setAttribute("filas","1" );
      ((Element)v.get(192)).setAttribute("valor","" );
      ((Element)v.get(192)).setAttribute("id","datosTitle" );
      ((Element)v.get(192)).setAttribute("cod","223" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","25" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(196)).setAttribute("nombre","lblUnidad8" );
      ((Element)v.get(196)).setAttribute("alto","13" );
      ((Element)v.get(196)).setAttribute("filas","1" );
      ((Element)v.get(196)).setAttribute("valor","" );
      ((Element)v.get(196)).setAttribute("id","datosTitle" );
      ((Element)v.get(196)).setAttribute("cod","224" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("width","100%" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(188)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","8" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:188   */

      /* Empieza nodo:199 / Elemento padre: 187   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(187)).appendChild((Element)v.get(199));

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
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(203)).setAttribute("textoinicial","" );
      ((Element)v.get(203)).setAttribute("valorinicial","" );
      ((Element)v.get(203)).setAttribute("req","N" );
      ((Element)v.get(203)).setAttribute("multiple","N" );
      ((Element)v.get(203)).setAttribute("size","1" );
      ((Element)v.get(203)).setAttribute("id","estCombo" );
      ((Element)v.get(203)).setAttribute("nombre","comboUnidad7" );
      ((Element)v.get(203)).setAttribute("onchange","seleccionarUG(7)" );
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
      ((Element)v.get(206)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(199)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(207)).setAttribute("textoinicial","" );
      ((Element)v.get(207)).setAttribute("valorinicial","" );
      ((Element)v.get(207)).setAttribute("req","N" );
      ((Element)v.get(207)).setAttribute("multiple","N" );
      ((Element)v.get(207)).setAttribute("size","1" );
      ((Element)v.get(207)).setAttribute("id","estCombo" );
      ((Element)v.get(207)).setAttribute("nombre","comboUnidad8" );
      ((Element)v.get(207)).setAttribute("onchange","seleccionarUG(8)" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("width","100%" );
      ((Element)v.get(199)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:199   */

      /* Empieza nodo:210 / Elemento padre: 187   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(187)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).setAttribute("colspan","4" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","8" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:213 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("table"));
      ((Element)v.get(215)).setAttribute("width","600" );
      ((Element)v.get(215)).setAttribute("border","0" );
      ((Element)v.get(215)).setAttribute("align","left" );
      ((Element)v.get(215)).setAttribute("cellspacing","0" );
      ((Element)v.get(215)).setAttribute("cellpadding","0" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","8" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(220)).setAttribute("nombre","lblUnidad9" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(220)).setAttribute("alto","13" );
      ((Element)v.get(220)).setAttribute("filas","1" );
      ((Element)v.get(220)).setAttribute("valor","" );
      ((Element)v.get(220)).setAttribute("id","datosTitle" );
      ((Element)v.get(220)).setAttribute("cod","225" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).setAttribute("width","100%" );
      ((Element)v.get(216)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","8" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:216   */

      /* Empieza nodo:223 / Elemento padre: 215   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(215)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(223)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(227)).setAttribute("textoinicial","" );
      ((Element)v.get(227)).setAttribute("valorinicial","" );
      ((Element)v.get(227)).setAttribute("req","N" );
      ((Element)v.get(227)).setAttribute("multiple","N" );
      ((Element)v.get(227)).setAttribute("size","1" );
      ((Element)v.get(227)).setAttribute("id","estCombo" );
      ((Element)v.get(227)).setAttribute("nombre","comboUnidad9" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).setAttribute("width","100%" );
      ((Element)v.get(223)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","8" );
      ((Element)v.get(229)).setAttribute("height","8" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:223   */

      /* Empieza nodo:230 / Elemento padre: 215   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(215)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).setAttribute("colspan","4" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","8" );
      ((Element)v.get(232)).setAttribute("height","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:60   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:233 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","8" );
      ((Element)v.get(234)).setAttribute("height","12" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:53   */

      /* Empieza nodo:235 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("table"));
      ((Element)v.get(240)).setAttribute("width","100%" );
      ((Element)v.get(240)).setAttribute("border","0" );
      ((Element)v.get(240)).setAttribute("align","center" );
      ((Element)v.get(240)).setAttribute("cellspacing","0" );
      ((Element)v.get(240)).setAttribute("cellpadding","0" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).setAttribute("class","botonera" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(243)).setAttribute("nombre","btnCrear" );
      ((Element)v.get(243)).setAttribute("ID","botonContenido" );
      ((Element)v.get(243)).setAttribute("tipo","html" );
      ((Element)v.get(243)).setAttribute("accion","buscar();" );
      ((Element)v.get(243)).setAttribute("estado","false" );
      ((Element)v.get(243)).setAttribute("alt","Buscar" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(243)).setAttribute("cod","1" );
      ((Element)v.get(243)).setAttribute("ontab","focaliza('frmDatos.comboTipoVia');" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:244 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","8" );
      ((Element)v.get(245)).setAttribute("height","12" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:235   */

      /* Empieza nodo:246 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).setAttribute("width","12" );
      ((Element)v.get(247)).setAttribute("align","center" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","12" );
      ((Element)v.get(248)).setAttribute("height","12" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).setAttribute("width","750" );
      ((Element)v.get(246)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).setAttribute("width","12" );
      ((Element)v.get(246)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","12" );
      ((Element)v.get(252)).setAttribute("height","12" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:246   */
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:253 / Elemento padre: 13   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(253)).setAttribute("nombre","listaResultados" );
      ((Element)v.get(253)).setAttribute("ancho","604" );
      ((Element)v.get(253)).setAttribute("alto","317" );
      ((Element)v.get(253)).setAttribute("x","12" );
      ((Element)v.get(253)).setAttribute("y","328" );
      ((Element)v.get(253)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(253)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(13)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(254)).setAttribute("precarga","S" );
      ((Element)v.get(254)).setAttribute("conROver","S" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(255)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(255)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(255)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(255)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 254   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(256)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(256)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(256)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(256)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(254)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 254   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(257)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(257)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(254)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:254   */

      /* Empieza nodo:258 / Elemento padre: 253   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(253)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(259)).setAttribute("borde","1" );
      ((Element)v.get(259)).setAttribute("horizDatos","1" );
      ((Element)v.get(259)).setAttribute("horizCabecera","1" );
      ((Element)v.get(259)).setAttribute("vertical","0" );
      ((Element)v.get(259)).setAttribute("horizTitulo","1" );
      ((Element)v.get(259)).setAttribute("horizBase","1" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 258   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(260)).setAttribute("borde","#999999" );
      ((Element)v.get(260)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(260)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(260)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(260)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(260)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(260)).setAttribute("horizBase","#999999" );
      ((Element)v.get(258)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:258   */

      /* Empieza nodo:261 / Elemento padre: 253   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(261)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(261)).setAttribute("alto","22" );
      ((Element)v.get(261)).setAttribute("imgFondo","" );
      ((Element)v.get(261)).setAttribute("cod","00135" );
      ((Element)v.get(261)).setAttribute("ID","datosTitle" );
      ((Element)v.get(253)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */

      /* Empieza nodo:262 / Elemento padre: 253   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("BASE"));
      ((Element)v.get(262)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(262)).setAttribute("alto","22" );
      ((Element)v.get(262)).setAttribute("imgFondo","" );
      ((Element)v.get(253)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 253   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(263)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(263)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(263)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(263)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(263)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(263)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(253)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(264)).setAttribute("ancho","100" );
      ((Element)v.get(264)).setAttribute("minimizable","S" );
      ((Element)v.get(264)).setAttribute("minimizada","N" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("ancho","100" );
      ((Element)v.get(265)).setAttribute("minimizable","S" );
      ((Element)v.get(265)).setAttribute("minimizada","N" );
      ((Element)v.get(263)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(266)).setAttribute("ancho","100" );
      ((Element)v.get(266)).setAttribute("minimizable","S" );
      ((Element)v.get(266)).setAttribute("minimizada","N" );
      ((Element)v.get(263)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(267)).setAttribute("ancho","100" );
      ((Element)v.get(267)).setAttribute("minimizable","S" );
      ((Element)v.get(267)).setAttribute("minimizada","N" );
      ((Element)v.get(263)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("ancho","100" );
      ((Element)v.get(268)).setAttribute("minimizable","S" );
      ((Element)v.get(268)).setAttribute("minimizada","N" );
      ((Element)v.get(263)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:263   */

      /* Empieza nodo:269 / Elemento padre: 253   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(269)).setAttribute("alto","20" );
      ((Element)v.get(269)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(269)).setAttribute("imgFondo","" );
      ((Element)v.get(269)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(269)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(253)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("colFondo","" );
      ((Element)v.get(270)).setAttribute("ID","EstCab" );
      ((Element)v.get(270)).setAttribute("align","center" );
      ((Element)v.get(270)).setAttribute("cod","227" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 269   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(271)).setAttribute("colFondo","" );
      ((Element)v.get(271)).setAttribute("ID","EstCab" );
      ((Element)v.get(271)).setAttribute("align","center" );
      ((Element)v.get(271)).setAttribute("cod","215" );
      ((Element)v.get(269)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 269   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("colFondo","" );
      ((Element)v.get(272)).setAttribute("ID","EstCab" );
      ((Element)v.get(272)).setAttribute("align","center" );
      ((Element)v.get(272)).setAttribute("cod","216" );
      ((Element)v.get(269)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 269   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("colFondo","" );
      ((Element)v.get(273)).setAttribute("ID","EstCab" );
      ((Element)v.get(273)).setAttribute("align","center" );
      ((Element)v.get(273)).setAttribute("cod","2691" );
      ((Element)v.get(269)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 269   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("colFondo","" );
      ((Element)v.get(274)).setAttribute("ID","EstCab" );
      ((Element)v.get(274)).setAttribute("align","center" );
      ((Element)v.get(274)).setAttribute("cod","2692" );
      ((Element)v.get(269)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:269   */

      /* Empieza nodo:275 / Elemento padre: 253   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(275)).setAttribute("alto","22" );
      ((Element)v.get(275)).setAttribute("accion","" );
      ((Element)v.get(275)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(275)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(275)).setAttribute("maxSel","0" );
      ((Element)v.get(275)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(275)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(275)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(275)).setAttribute("onLoad","" );
      ((Element)v.get(275)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(253)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("tipo","texto" );
      ((Element)v.get(276)).setAttribute("ID","EstDat" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 275   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("tipo","texto" );
      ((Element)v.get(277)).setAttribute("ID","EstDat2" );
      ((Element)v.get(275)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 275   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("tipo","texto" );
      ((Element)v.get(278)).setAttribute("ID","EstDat" );
      ((Element)v.get(275)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 275   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("tipo","texto" );
      ((Element)v.get(279)).setAttribute("ID","EstDat2" );
      ((Element)v.get(275)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 275   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("tipo","texto" );
      ((Element)v.get(280)).setAttribute("ID","EstDat" );
      ((Element)v.get(275)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:275   */

      /* Empieza nodo:281 / Elemento padre: 253   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(253)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 253   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(282)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(282)).setAttribute("ancho","604" );
      ((Element)v.get(282)).setAttribute("sep","$" );
      ((Element)v.get(282)).setAttribute("x","12" );
      ((Element)v.get(282)).setAttribute("class","botonera" );
      ((Element)v.get(282)).setAttribute("y","622" );
      ((Element)v.get(282)).setAttribute("control","" );
      ((Element)v.get(282)).setAttribute("conector","" );
      ((Element)v.get(282)).setAttribute("rowset","" );
      ((Element)v.get(282)).setAttribute("cargainicial","N" );
      ((Element)v.get(282)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(253)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(283)).setAttribute("nombre","ret1" );
      ((Element)v.get(283)).setAttribute("x","37" );
      ((Element)v.get(283)).setAttribute("y","626" );
      ((Element)v.get(283)).setAttribute("ID","botonContenido" );
      ((Element)v.get(283)).setAttribute("img","retroceder_on" );
      ((Element)v.get(283)).setAttribute("tipo","0" );
      ((Element)v.get(283)).setAttribute("estado","false" );
      ((Element)v.get(283)).setAttribute("alt","" );
      ((Element)v.get(283)).setAttribute("codigo","" );
      ((Element)v.get(283)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 282   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(284)).setAttribute("nombre","ava1" );
      ((Element)v.get(284)).setAttribute("x","52" );
      ((Element)v.get(284)).setAttribute("y","626" );
      ((Element)v.get(284)).setAttribute("ID","botonContenido" );
      ((Element)v.get(284)).setAttribute("img","avanzar_on" );
      ((Element)v.get(284)).setAttribute("tipo","0" );
      ((Element)v.get(284)).setAttribute("estado","false" );
      ((Element)v.get(284)).setAttribute("alt","" );
      ((Element)v.get(284)).setAttribute("codigo","" );
      ((Element)v.get(284)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(282)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:282   */
      /* Termina nodo:253   */

      /* Empieza nodo:285 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(285)).setAttribute("nombre","primera1" );
      ((Element)v.get(285)).setAttribute("x","20" );
      ((Element)v.get(285)).setAttribute("y","626" );
      ((Element)v.get(285)).setAttribute("ID","botonContenido" );
      ((Element)v.get(285)).setAttribute("img","primera_on" );
      ((Element)v.get(285)).setAttribute("tipo","-2" );
      ((Element)v.get(285)).setAttribute("estado","false" );
      ((Element)v.get(285)).setAttribute("alt","" );
      ((Element)v.get(285)).setAttribute("codigo","" );
      ((Element)v.get(285)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(13)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(286)).setAttribute("nombre","separa" );
      ((Element)v.get(286)).setAttribute("x","59" );
      ((Element)v.get(286)).setAttribute("y","622" );
      ((Element)v.get(286)).setAttribute("ID","botonContenido" );
      ((Element)v.get(286)).setAttribute("img","separa_base" );
      ((Element)v.get(286)).setAttribute("tipo","0" );
      ((Element)v.get(286)).setAttribute("estado","false" );
      ((Element)v.get(286)).setAttribute("alt","" );
      ((Element)v.get(286)).setAttribute("codigo","" );
      ((Element)v.get(286)).setAttribute("accion","" );
      ((Element)v.get(13)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(287)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(287)).setAttribute("alto","12" );
      ((Element)v.get(287)).setAttribute("ancho","100%" );
      ((Element)v.get(287)).setAttribute("colorf","" );
      ((Element)v.get(287)).setAttribute("borde","0" );
      ((Element)v.get(287)).setAttribute("imagenf","" );
      ((Element)v.get(287)).setAttribute("repeat","" );
      ((Element)v.get(287)).setAttribute("padding","" );
      ((Element)v.get(287)).setAttribute("visibilidad","visible" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(287)).setAttribute("contravsb","" );
      ((Element)v.get(287)).setAttribute("x","0" );
      ((Element)v.get(287)).setAttribute("y","645" );
      ((Element)v.get(287)).setAttribute("zindex","" );
      ((Element)v.get(13)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:13   */


   }

}

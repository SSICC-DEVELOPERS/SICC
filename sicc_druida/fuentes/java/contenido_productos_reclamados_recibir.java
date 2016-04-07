
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_productos_reclamados_recibir  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_productos_reclamados_recibir" );
      ((Element)v.get(0)).setAttribute("cod","0147" );
      ((Element)v.get(0)).setAttribute("titulo","Recibir Productos Reclamados" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Recibir Productos Reclamados" );
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
      ((Element)v.get(5)).setAttribute("src","contenido_productos_reclamados_recibir.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(6)).setAttribute("oculto","" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","casoUso" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","accion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","lista" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","idioma" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","pais" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(16)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(16)).setAttribute("x","0" );
      ((Element)v.get(16)).setAttribute("y","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("table"));
      ((Element)v.get(17)).setAttribute("width","100%" );
      ((Element)v.get(17)).setAttribute("border","0" );
      ((Element)v.get(17)).setAttribute("cellspacing","0" );
      ((Element)v.get(17)).setAttribute("cellpadding","0" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","12" );
      ((Element)v.get(19)).setAttribute("align","center" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(20)).setAttribute("height","12" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:21 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","750" );
      ((Element)v.get(18)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(22)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:23 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(18)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("height","1" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */
      /* Termina nodo:18   */

      /* Empieza nodo:25 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(30)).setAttribute("class","legend" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(31)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(31)).setAttribute("alto","13" );
      ((Element)v.get(31)).setAttribute("filas","1" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(31)).setAttribute("id","legend" );
      ((Element)v.get(31)).setAttribute("cod","0075" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("table"));
      ((Element)v.get(32)).setAttribute("width","100%" );
      ((Element)v.get(32)).setAttribute("border","0" );
      ((Element)v.get(32)).setAttribute("align","center" );
      ((Element)v.get(32)).setAttribute("cellspacing","0" );
      ((Element)v.get(32)).setAttribute("cellpadding","0" );
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("table"));
      ((Element)v.get(35)).setAttribute("width","536" );
      ((Element)v.get(35)).setAttribute("border","0" );
      ((Element)v.get(35)).setAttribute("align","left" );
      ((Element)v.get(35)).setAttribute("cellspacing","0" );
      ((Element)v.get(35)).setAttribute("cellpadding","0" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("colspan","3" );
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
      ((Element)v.get(43)).setAttribute("nombre","lblNumReclamo" );
      ((Element)v.get(43)).setAttribute("alto","13" );
      ((Element)v.get(43)).setAttribute("filas","1" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(43)).setAttribute("id","datosTitle" );
      ((Element)v.get(43)).setAttribute("cod","396" );
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
      ((Element)v.get(39)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("nombre","lblFechaReclamo" );
      ((Element)v.get(47)).setAttribute("alto","13" );
      ((Element)v.get(47)).setAttribute("filas","1" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(47)).setAttribute("id","datosTitle" );
      ((Element)v.get(47)).setAttribute("cod","385" );
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
      ((Element)v.get(51)).setAttribute("nombre","lblOperacion" );
      ((Element)v.get(51)).setAttribute("alto","13" );
      ((Element)v.get(51)).setAttribute("filas","1" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(51)).setAttribute("id","datosTitle" );
      ((Element)v.get(51)).setAttribute("cod","406" );
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
      ((Element)v.get(54)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(58)).setAttribute("nombre","txtNumReclamo" );
      ((Element)v.get(58)).setAttribute("id","datosCampos" );
      ((Element)v.get(58)).setAttribute("max","10" );
      ((Element)v.get(58)).setAttribute("tipo","" );
      ((Element)v.get(58)).setAttribute("onchange","" );
      ((Element)v.get(58)).setAttribute("req","N" );
      ((Element)v.get(58)).setAttribute("size","13" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(58)).setAttribute("validacion","" );
      ((Element)v.get(58)).setAttribute("onshtab","onShTabNumeroReclamo();" );
      ((Element)v.get(58)).setAttribute("onblur","onBlurNumAtencion();" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","25" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(62)).setAttribute("nombre","txtFechaReclamo" );
      ((Element)v.get(62)).setAttribute("id","datosCampos" );
      ((Element)v.get(62)).setAttribute("max","10" );
      ((Element)v.get(62)).setAttribute("tipo","" );
      ((Element)v.get(62)).setAttribute("onchange","" );
      ((Element)v.get(62)).setAttribute("req","N" );
      ((Element)v.get(62)).setAttribute("size","12" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(62)).setAttribute("validacion","" );
      ((Element)v.get(62)).setAttribute("onblur","onBlurFecha();" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","25" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(66)).setAttribute("nombre","cbOperacion" );
      ((Element)v.get(66)).setAttribute("id","datosCampos" );
      ((Element)v.get(66)).setAttribute("size","1" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(66)).setAttribute("multiple","N" );
      ((Element)v.get(66)).setAttribute("req","N" );
      ((Element)v.get(66)).setAttribute("valorinicial","" );
      ((Element)v.get(66)).setAttribute("textoinicial","" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:68 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("width","100%" );
      ((Element)v.get(54)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","8" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:54   */

      /* Empieza nodo:70 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("colspan","3" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(72)).setAttribute("height","7" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:73 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:25   */

      /* Empieza nodo:75 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("table"));
      ((Element)v.get(80)).setAttribute("width","100%" );
      ((Element)v.get(80)).setAttribute("border","0" );
      ((Element)v.get(80)).setAttribute("align","center" );
      ((Element)v.get(80)).setAttribute("cellspacing","0" );
      ((Element)v.get(80)).setAttribute("cellpadding","0" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("class","botonera" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(83)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(83)).setAttribute("ID","botonContenido" );
      ((Element)v.get(83)).setAttribute("tipo","html" );
      ((Element)v.get(83)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(83)).setAttribute("estado","false" );
      ((Element)v.get(83)).setAttribute("cod","1" );
      ((Element)v.get(83)).setAttribute("ontab","onTabBuscar();" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:84 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","12" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:75   */

      /* Empieza nodo:86 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("width","12" );
      ((Element)v.get(87)).setAttribute("align","center" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","12" );
      ((Element)v.get(88)).setAttribute("height","12" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("width","756" );
      ((Element)v.get(86)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","12" );
      ((Element)v.get(86)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","12" );
      ((Element)v.get(92)).setAttribute("height","1" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:86   */
      /* Termina nodo:17   */
      /* Termina nodo:16   */

      /* Empieza nodo:93 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(93)).setAttribute("nombre","capaLista" );
      ((Element)v.get(93)).setAttribute("alto","660" );
      ((Element)v.get(93)).setAttribute("ancho","100%" );
      ((Element)v.get(93)).setAttribute("colorf","" );
      ((Element)v.get(93)).setAttribute("borde","0" );
      ((Element)v.get(93)).setAttribute("imagenf","" );
      ((Element)v.get(93)).setAttribute("repeat","" );
      ((Element)v.get(93)).setAttribute("padding","" );
      ((Element)v.get(93)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(93)).setAttribute("contravsb","" );
      ((Element)v.get(93)).setAttribute("x","12" );
      ((Element)v.get(93)).setAttribute("y","123" );
      ((Element)v.get(93)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(94)).setAttribute("nombre","listado1" );
      ((Element)v.get(94)).setAttribute("ancho","539" );
      ((Element)v.get(94)).setAttribute("alto","317" );
      ((Element)v.get(94)).setAttribute("x","0" );
      ((Element)v.get(94)).setAttribute("y","0" );
      ((Element)v.get(94)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(94)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(95)).setAttribute("precarga","S" );
      ((Element)v.get(95)).setAttribute("conROver","S" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(96)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(96)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(96)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(96)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 95   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(97)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(97)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(97)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(97)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(95)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 95   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(98)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(98)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(95)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:95   */

      /* Empieza nodo:99 / Elemento padre: 94   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(94)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(100)).setAttribute("borde","1" );
      ((Element)v.get(100)).setAttribute("horizDatos","1" );
      ((Element)v.get(100)).setAttribute("horizCabecera","1" );
      ((Element)v.get(100)).setAttribute("vertical","1" );
      ((Element)v.get(100)).setAttribute("horizTitulo","1" );
      ((Element)v.get(100)).setAttribute("horizBase","1" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 99   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(101)).setAttribute("borde","#999999" );
      ((Element)v.get(101)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(101)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(101)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(101)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(101)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(101)).setAttribute("horizBase","#999999" );
      ((Element)v.get(99)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:99   */

      /* Empieza nodo:102 / Elemento padre: 94   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(102)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(102)).setAttribute("alto","22" );
      ((Element)v.get(102)).setAttribute("imgFondo","" );
      ((Element)v.get(102)).setAttribute("cod","00135" );
      ((Element)v.get(102)).setAttribute("ID","datosTitle" );
      ((Element)v.get(94)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 94   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(103)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(103)).setAttribute("alto","22" );
      ((Element)v.get(103)).setAttribute("imgFondo","" );
      ((Element)v.get(94)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 94   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(104)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(104)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(104)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(104)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(104)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(104)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(94)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("ancho","100" );
      ((Element)v.get(105)).setAttribute("minimizable","S" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(105)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).setAttribute("oculta","S" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("ancho","100" );
      ((Element)v.get(106)).setAttribute("minimizable","S" );
      ((Element)v.get(106)).setAttribute("minimizada","N" );
      ((Element)v.get(106)).setAttribute("oculta","S" );
      ((Element)v.get(104)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("ancho","100" );
      ((Element)v.get(107)).setAttribute("minimizable","S" );
      ((Element)v.get(107)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("ancho","150" );
      ((Element)v.get(108)).setAttribute("minimizable","S" );
      ((Element)v.get(108)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("ancho","100" );
      ((Element)v.get(109)).setAttribute("minimizable","S" );
      ((Element)v.get(109)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("ancho","100" );
      ((Element)v.get(110)).setAttribute("minimizable","S" );
      ((Element)v.get(110)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("ancho","100" );
      ((Element)v.get(111)).setAttribute("minimizable","S" );
      ((Element)v.get(111)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("ancho","100" );
      ((Element)v.get(112)).setAttribute("minimizable","S" );
      ((Element)v.get(112)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("ancho","100" );
      ((Element)v.get(113)).setAttribute("minimizable","S" );
      ((Element)v.get(113)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("ancho","100" );
      ((Element)v.get(114)).setAttribute("minimizable","S" );
      ((Element)v.get(114)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("ancho","100" );
      ((Element)v.get(115)).setAttribute("minimizable","S" );
      ((Element)v.get(115)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("ancho","150" );
      ((Element)v.get(116)).setAttribute("minimizable","S" );
      ((Element)v.get(116)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("ancho","150" );
      ((Element)v.get(117)).setAttribute("minimizable","S" );
      ((Element)v.get(117)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("ancho","150" );
      ((Element)v.get(118)).setAttribute("minimizable","S" );
      ((Element)v.get(118)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("ancho","100" );
      ((Element)v.get(119)).setAttribute("minimizable","S" );
      ((Element)v.get(119)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("ancho","100" );
      ((Element)v.get(120)).setAttribute("minimizable","S" );
      ((Element)v.get(120)).setAttribute("minimizada","N" );
      ((Element)v.get(120)).setAttribute("oculta","S" );
      ((Element)v.get(104)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("ancho","100" );
      ((Element)v.get(121)).setAttribute("minimizable","S" );
      ((Element)v.get(121)).setAttribute("minimizada","N" );
      ((Element)v.get(121)).setAttribute("oculta","S" );
      ((Element)v.get(104)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("ancho","100" );
      ((Element)v.get(122)).setAttribute("minimizable","S" );
      ((Element)v.get(122)).setAttribute("minimizada","N" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(122)).setAttribute("oculta","S" );
      ((Element)v.get(104)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("ancho","100" );
      ((Element)v.get(123)).setAttribute("minimizable","S" );
      ((Element)v.get(123)).setAttribute("minimizada","N" );
      ((Element)v.get(123)).setAttribute("oculta","S" );
      ((Element)v.get(104)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("ancho","100" );
      ((Element)v.get(124)).setAttribute("minimizable","S" );
      ((Element)v.get(124)).setAttribute("minimizada","N" );
      ((Element)v.get(124)).setAttribute("oculta","S" );
      ((Element)v.get(104)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("ancho","100" );
      ((Element)v.get(125)).setAttribute("minimizable","S" );
      ((Element)v.get(125)).setAttribute("minimizada","N" );
      ((Element)v.get(125)).setAttribute("oculta","S" );
      ((Element)v.get(104)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("ancho","100" );
      ((Element)v.get(126)).setAttribute("minimizable","S" );
      ((Element)v.get(126)).setAttribute("minimizada","N" );
      ((Element)v.get(126)).setAttribute("oculta","S" );
      ((Element)v.get(104)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("ancho","100" );
      ((Element)v.get(127)).setAttribute("minimizable","S" );
      ((Element)v.get(127)).setAttribute("minimizada","N" );
      ((Element)v.get(127)).setAttribute("oculta","S" );
      ((Element)v.get(104)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("ancho","100" );
      ((Element)v.get(128)).setAttribute("minimizable","S" );
      ((Element)v.get(128)).setAttribute("minimizada","N" );
      ((Element)v.get(128)).setAttribute("oculta","S" );
      ((Element)v.get(104)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("ancho","100" );
      ((Element)v.get(129)).setAttribute("minimizable","S" );
      ((Element)v.get(129)).setAttribute("minimizada","N" );
      ((Element)v.get(129)).setAttribute("oculta","S" );
      ((Element)v.get(104)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("ancho","100" );
      ((Element)v.get(130)).setAttribute("minimizable","S" );
      ((Element)v.get(130)).setAttribute("minimizada","N" );
      ((Element)v.get(130)).setAttribute("oculta","S" );
      ((Element)v.get(104)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("ancho","100" );
      ((Element)v.get(131)).setAttribute("minimizable","S" );
      ((Element)v.get(131)).setAttribute("minimizada","N" );
      ((Element)v.get(131)).setAttribute("oculta","S" );
      ((Element)v.get(104)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:104   */

      /* Empieza nodo:132 / Elemento padre: 94   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(132)).setAttribute("alto","20" );
      ((Element)v.get(132)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(132)).setAttribute("imgFondo","" );
      ((Element)v.get(132)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(94)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("colFondo","" );
      ((Element)v.get(133)).setAttribute("ID","EstCab" );
      ((Element)v.get(133)).setAttribute("cod","396" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("colFondo","" );
      ((Element)v.get(134)).setAttribute("ID","EstCab" );
      ((Element)v.get(134)).setAttribute("cod","396" );
      ((Element)v.get(132)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(135)).setAttribute("colFondo","" );
      ((Element)v.get(135)).setAttribute("ID","EstCab" );
      ((Element)v.get(135)).setAttribute("cod","396" );
      ((Element)v.get(132)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("colFondo","" );
      ((Element)v.get(136)).setAttribute("ID","EstCab" );
      ((Element)v.get(136)).setAttribute("cod","367" );
      ((Element)v.get(132)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(137)).setAttribute("colFondo","" );
      ((Element)v.get(137)).setAttribute("ID","EstCab" );
      ((Element)v.get(137)).setAttribute("cod","263" );
      ((Element)v.get(132)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("colFondo","" );
      ((Element)v.get(138)).setAttribute("ID","EstCab" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(138)).setAttribute("cod","418" );
      ((Element)v.get(132)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("colFondo","" );
      ((Element)v.get(139)).setAttribute("ID","EstCab" );
      ((Element)v.get(139)).setAttribute("cod","299" );
      ((Element)v.get(132)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(140)).setAttribute("colFondo","" );
      ((Element)v.get(140)).setAttribute("ID","EstCab" );
      ((Element)v.get(140)).setAttribute("cod","375" );
      ((Element)v.get(132)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("colFondo","" );
      ((Element)v.get(141)).setAttribute("ID","EstCab" );
      ((Element)v.get(141)).setAttribute("cod","401" );
      ((Element)v.get(132)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("colFondo","" );
      ((Element)v.get(142)).setAttribute("ID","EstCab" );
      ((Element)v.get(142)).setAttribute("cod","402" );
      ((Element)v.get(132)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("colFondo","" );
      ((Element)v.get(143)).setAttribute("ID","EstCab" );
      ((Element)v.get(143)).setAttribute("cod","336" );
      ((Element)v.get(132)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("colFondo","" );
      ((Element)v.get(144)).setAttribute("ID","EstCab" );
      ((Element)v.get(144)).setAttribute("cod","9" );
      ((Element)v.get(132)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(145)).setAttribute("colFondo","" );
      ((Element)v.get(145)).setAttribute("ID","EstCab" );
      ((Element)v.get(145)).setAttribute("cod","408" );
      ((Element)v.get(132)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("colFondo","" );
      ((Element)v.get(146)).setAttribute("ID","EstCab" );
      ((Element)v.get(146)).setAttribute("cod","309" );
      ((Element)v.get(132)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(147)).setAttribute("colFondo","" );
      ((Element)v.get(147)).setAttribute("ID","EstCab" );
      ((Element)v.get(147)).setAttribute("cod","2494" );
      ((Element)v.get(132)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("colFondo","" );
      ((Element)v.get(148)).setAttribute("ID","EstCab" );
      ((Element)v.get(148)).setAttribute("cod","2494" );
      ((Element)v.get(132)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(149)).setAttribute("colFondo","" );
      ((Element)v.get(149)).setAttribute("ID","EstCab" );
      ((Element)v.get(149)).setAttribute("cod","2494" );
      ((Element)v.get(132)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("colFondo","" );
      ((Element)v.get(150)).setAttribute("ID","EstCab" );
      ((Element)v.get(150)).setAttribute("cod","2494" );
      ((Element)v.get(132)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("colFondo","" );
      ((Element)v.get(151)).setAttribute("ID","EstCab" );
      ((Element)v.get(151)).setAttribute("cod","2494" );
      ((Element)v.get(132)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("colFondo","" );
      ((Element)v.get(152)).setAttribute("ID","EstCab" );
      ((Element)v.get(152)).setAttribute("cod","2494" );
      ((Element)v.get(132)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("colFondo","" );
      ((Element)v.get(153)).setAttribute("ID","EstCab" );
      ((Element)v.get(153)).setAttribute("cod","2494" );
      ((Element)v.get(132)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("colFondo","" );
      ((Element)v.get(154)).setAttribute("ID","EstCab" );
      ((Element)v.get(154)).setAttribute("cod","2494" );
      ((Element)v.get(132)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("colFondo","" );
      ((Element)v.get(155)).setAttribute("ID","EstCab" );
      ((Element)v.get(155)).setAttribute("cod","2494" );
      ((Element)v.get(132)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("colFondo","" );
      ((Element)v.get(156)).setAttribute("ID","EstCab" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(156)).setAttribute("cod","2494" );
      ((Element)v.get(132)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("colFondo","" );
      ((Element)v.get(157)).setAttribute("ID","EstCab" );
      ((Element)v.get(157)).setAttribute("cod","2494" );
      ((Element)v.get(132)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("colFondo","" );
      ((Element)v.get(158)).setAttribute("ID","EstCab" );
      ((Element)v.get(158)).setAttribute("cod","2494" );
      ((Element)v.get(132)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("colFondo","" );
      ((Element)v.get(159)).setAttribute("ID","EstCab" );
      ((Element)v.get(159)).setAttribute("cod","2494" );
      ((Element)v.get(132)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:132   */

      /* Empieza nodo:160 / Elemento padre: 94   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(160)).setAttribute("alto","22" );
      ((Element)v.get(160)).setAttribute("accion","" );
      ((Element)v.get(160)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(160)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(160)).setAttribute("maxSel","-1" );
      ((Element)v.get(160)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(160)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(160)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(160)).setAttribute("onLoad","" );
      ((Element)v.get(160)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(94)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("tipo","texto" );
      ((Element)v.get(161)).setAttribute("ID","EstDat" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("tipo","texto" );
      ((Element)v.get(162)).setAttribute("ID","EstDat" );
      ((Element)v.get(160)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("tipo","texto" );
      ((Element)v.get(163)).setAttribute("ID","EstDat" );
      ((Element)v.get(160)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("tipo","texto" );
      ((Element)v.get(164)).setAttribute("ID","EstDat2" );
      ((Element)v.get(160)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("tipo","texto" );
      ((Element)v.get(165)).setAttribute("ID","EstDat" );
      ((Element)v.get(160)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("tipo","texto" );
      ((Element)v.get(166)).setAttribute("ID","EstDat2" );
      ((Element)v.get(160)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("tipo","texto" );
      ((Element)v.get(167)).setAttribute("ID","EstDat" );
      ((Element)v.get(160)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("tipo","texto" );
      ((Element)v.get(168)).setAttribute("ID","EstDat2" );
      ((Element)v.get(160)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("tipo","texto" );
      ((Element)v.get(169)).setAttribute("ID","EstDat" );
      ((Element)v.get(160)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("tipo","texto" );
      ((Element)v.get(170)).setAttribute("ID","EstDat2" );
      ((Element)v.get(160)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("tipo","texto" );
      ((Element)v.get(171)).setAttribute("ID","EstDat" );
      ((Element)v.get(160)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("tipo","texto" );
      ((Element)v.get(172)).setAttribute("ID","EstDat2" );
      ((Element)v.get(160)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("tipo","texto" );
      ((Element)v.get(173)).setAttribute("ID","EstDat" );
      ((Element)v.get(160)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("tipo","texto" );
      ((Element)v.get(174)).setAttribute("ID","EstDat2" );
      ((Element)v.get(160)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(175)).setAttribute("nombre","Texto1" );
      ((Element)v.get(175)).setAttribute("size","4" );
      ((Element)v.get(175)).setAttribute("max","4" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(175)).setAttribute("IDOBJ","datosCampos" );
      ((Element)v.get(175)).setAttribute("ID","EstDat" );
      ((Element)v.get(175)).setAttribute("onShTab","filaActual=FILAEVENTO;focalizaAnteriorLista(FILAEVENTO, TECLAEVENTO)" );
      ((Element)v.get(175)).setAttribute("onTab","filaActual=FILAEVENTO;focalizaSiguienteLista(FILAEVENTO, TECLAEVENTO)" );
      ((Element)v.get(175)).setAttribute("onBlur","filaActual=FILAEVENTO;validarUnidadesDevolver(FILAEVENTO);" );
      ((Element)v.get(175)).setAttribute("validacion","validar()" );
      ((Element)v.get(160)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("tipo","texto" );
      ((Element)v.get(176)).setAttribute("ID","EstDat2" );
      ((Element)v.get(160)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("tipo","texto" );
      ((Element)v.get(177)).setAttribute("ID","EstDat2" );
      ((Element)v.get(160)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("tipo","texto" );
      ((Element)v.get(178)).setAttribute("ID","EstDat2" );
      ((Element)v.get(160)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("tipo","texto" );
      ((Element)v.get(179)).setAttribute("ID","EstDat2" );
      ((Element)v.get(160)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("tipo","texto" );
      ((Element)v.get(180)).setAttribute("ID","EstDat2" );
      ((Element)v.get(160)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("tipo","texto" );
      ((Element)v.get(181)).setAttribute("ID","EstDat2" );
      ((Element)v.get(160)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("tipo","texto" );
      ((Element)v.get(182)).setAttribute("ID","EstDat2" );
      ((Element)v.get(160)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("tipo","texto" );
      ((Element)v.get(183)).setAttribute("ID","EstDat2" );
      ((Element)v.get(160)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("tipo","texto" );
      ((Element)v.get(184)).setAttribute("ID","EstDat2" );
      ((Element)v.get(160)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("tipo","texto" );
      ((Element)v.get(185)).setAttribute("ID","EstDat2" );
      ((Element)v.get(160)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("tipo","texto" );
      ((Element)v.get(186)).setAttribute("ID","EstDat2" );
      ((Element)v.get(160)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("tipo","texto" );
      ((Element)v.get(187)).setAttribute("ID","EstDat2" );
      ((Element)v.get(160)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:160   */

      /* Empieza nodo:188 / Elemento padre: 94   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(188)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(188)).setAttribute("ancho","539" );
      ((Element)v.get(188)).setAttribute("sep","$" );
      ((Element)v.get(188)).setAttribute("x","0" );
      ((Element)v.get(188)).setAttribute("class","botonera" );
      ((Element)v.get(188)).setAttribute("y","294" );
      ((Element)v.get(188)).setAttribute("control","|" );
      ((Element)v.get(188)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(188)).setAttribute("rowset","" );
      ((Element)v.get(188)).setAttribute("cargainicial","N" );
      ((Element)v.get(188)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(94)).appendChild((Element)v.get(188));

      /* Elemento padre:188 / Elemento actual: 189   */
      v.add(doc.createTextNode(">\r    	"));
      ((Element)v.get(188)).appendChild((Text)v.get(189));

      /* Termina nodo Texto:189   */

      /* Empieza nodo:190 / Elemento padre: 188   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(190)).setAttribute("nombre","ret1" );
      ((Element)v.get(190)).setAttribute("x","25" );
      ((Element)v.get(190)).setAttribute("y","298" );
      ((Element)v.get(190)).setAttribute("ID","botonContenido" );
      ((Element)v.get(190)).setAttribute("img","retroceder_on" );
      ((Element)v.get(190)).setAttribute("tipo","0" );
      ((Element)v.get(190)).setAttribute("estado","false" );
      ((Element)v.get(190)).setAttribute("alt","" );
      ((Element)v.get(190)).setAttribute("codigo","" );
      ((Element)v.get(190)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(188)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 188   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(191)).setAttribute("nombre","ava1" );
      ((Element)v.get(191)).setAttribute("x","40" );
      ((Element)v.get(191)).setAttribute("y","298" );
      ((Element)v.get(191)).setAttribute("ID","botonContenido" );
      ((Element)v.get(191)).setAttribute("img","avanzar_on" );
      ((Element)v.get(191)).setAttribute("tipo","0" );
      ((Element)v.get(191)).setAttribute("estado","false" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(191)).setAttribute("alt","" );
      ((Element)v.get(191)).setAttribute("codigo","" );
      ((Element)v.get(191)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(188)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:188   */
      /* Termina nodo:94   */

      /* Empieza nodo:192 / Elemento padre: 93   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(192)).setAttribute("nombre","primera1" );
      ((Element)v.get(192)).setAttribute("x","8" );
      ((Element)v.get(192)).setAttribute("y","298" );
      ((Element)v.get(192)).setAttribute("ID","botonContenido" );
      ((Element)v.get(192)).setAttribute("img","primera_on" );
      ((Element)v.get(192)).setAttribute("tipo","0" );
      ((Element)v.get(192)).setAttribute("estado","false" );
      ((Element)v.get(192)).setAttribute("alt","" );
      ((Element)v.get(192)).setAttribute("codigo","" );
      ((Element)v.get(192)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(93)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 93   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(193)).setAttribute("nombre","separa" );
      ((Element)v.get(193)).setAttribute("x","47" );
      ((Element)v.get(193)).setAttribute("y","294" );
      ((Element)v.get(193)).setAttribute("ID","botonContenido" );
      ((Element)v.get(193)).setAttribute("img","separa_base" );
      ((Element)v.get(193)).setAttribute("tipo","0" );
      ((Element)v.get(193)).setAttribute("estado","false" );
      ((Element)v.get(193)).setAttribute("alt","" );
      ((Element)v.get(193)).setAttribute("codigo","" );
      ((Element)v.get(193)).setAttribute("accion","" );
      ((Element)v.get(93)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 93   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(194)).setAttribute("nombre","Anadir" );
      ((Element)v.get(194)).setAttribute("x","68" );
      ((Element)v.get(194)).setAttribute("y","295" );
      ((Element)v.get(194)).setAttribute("ID","botonContenido" );
      ((Element)v.get(194)).setAttribute("img","" );
      ((Element)v.get(194)).setAttribute("tipo","html" );
      ((Element)v.get(194)).setAttribute("estado","false" );
      ((Element)v.get(194)).setAttribute("alt","" );
      ((Element)v.get(194)).setAttribute("cod","404" );
      ((Element)v.get(194)).setAttribute("accion","onClickAnyadir();" );
      ((Element)v.get(194)).setAttribute("ontab","onTabAnyadir();" );
      ((Element)v.get(194)).setAttribute("onshtab","onShTabAnyadir();" );
      ((Element)v.get(93)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 93   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(195)).setAttribute("nombre","listado2" );
      ((Element)v.get(195)).setAttribute("ancho","539" );
      ((Element)v.get(195)).setAttribute("alto","317" );
      ((Element)v.get(195)).setAttribute("x","0" );
      ((Element)v.get(195)).setAttribute("y","341" );
      ((Element)v.get(195)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(195)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(93)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(196)).setAttribute("precarga","S" );
      ((Element)v.get(196)).setAttribute("conROver","S" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(197)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(197)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(197)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(197)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 196   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(198)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(198)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(198)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(198)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(196)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 196   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(199)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(199)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(196)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:196   */

      /* Empieza nodo:200 / Elemento padre: 195   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(195)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(201)).setAttribute("borde","1" );
      ((Element)v.get(201)).setAttribute("horizDatos","1" );
      ((Element)v.get(201)).setAttribute("horizCabecera","1" );
      ((Element)v.get(201)).setAttribute("vertical","1" );
      ((Element)v.get(201)).setAttribute("horizTitulo","1" );
      ((Element)v.get(201)).setAttribute("horizBase","1" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 200   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(202)).setAttribute("borde","#999999" );
      ((Element)v.get(202)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(202)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(202)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(202)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(202)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(202)).setAttribute("horizBase","#999999" );
      ((Element)v.get(200)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:200   */

      /* Empieza nodo:203 / Elemento padre: 195   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(203)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(203)).setAttribute("alto","22" );
      ((Element)v.get(203)).setAttribute("imgFondo","" );
      ((Element)v.get(203)).setAttribute("cod","00658" );
      ((Element)v.get(203)).setAttribute("ID","datosTitle" );
      ((Element)v.get(195)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 195   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(204)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(204)).setAttribute("alto","22" );
      ((Element)v.get(204)).setAttribute("imgFondo","" );
      ((Element)v.get(195)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 195   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(205)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(205)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(205)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(205)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(205)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(205)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(195)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("ancho","100" );
      ((Element)v.get(206)).setAttribute("minimizable","S" );
      ((Element)v.get(206)).setAttribute("minimizada","N" );
      ((Element)v.get(206)).setAttribute("oculta","S" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("ancho","100" );
      ((Element)v.get(207)).setAttribute("minimizable","S" );
      ((Element)v.get(207)).setAttribute("minimizada","N" );
      ((Element)v.get(207)).setAttribute("oculta","S" );
      ((Element)v.get(205)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("ancho","100" );
      ((Element)v.get(208)).setAttribute("minimizable","S" );
      ((Element)v.get(208)).setAttribute("minimizada","N" );
      ((Element)v.get(205)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(209)).setAttribute("ancho","150" );
      ((Element)v.get(209)).setAttribute("minimizable","S" );
      ((Element)v.get(209)).setAttribute("minimizada","N" );
      ((Element)v.get(205)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */

      /* Empieza nodo:210 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("ancho","100" );
      ((Element)v.get(210)).setAttribute("minimizable","S" );
      ((Element)v.get(210)).setAttribute("minimizada","N" );
      ((Element)v.get(205)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(211)).setAttribute("ancho","100" );
      ((Element)v.get(211)).setAttribute("minimizable","S" );
      ((Element)v.get(211)).setAttribute("minimizada","N" );
      ((Element)v.get(205)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("ancho","100" );
      ((Element)v.get(212)).setAttribute("minimizable","S" );
      ((Element)v.get(212)).setAttribute("minimizada","N" );
      ((Element)v.get(205)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(213)).setAttribute("ancho","100" );
      ((Element)v.get(213)).setAttribute("minimizable","S" );
      ((Element)v.get(213)).setAttribute("minimizada","N" );
      ((Element)v.get(205)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("ancho","100" );
      ((Element)v.get(214)).setAttribute("minimizable","S" );
      ((Element)v.get(214)).setAttribute("minimizada","N" );
      ((Element)v.get(205)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(215)).setAttribute("ancho","100" );
      ((Element)v.get(215)).setAttribute("minimizable","S" );
      ((Element)v.get(215)).setAttribute("minimizada","N" );
      ((Element)v.get(205)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("ancho","100" );
      ((Element)v.get(216)).setAttribute("minimizable","S" );
      ((Element)v.get(216)).setAttribute("minimizada","N" );
      ((Element)v.get(205)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("ancho","100" );
      ((Element)v.get(217)).setAttribute("minimizable","S" );
      ((Element)v.get(217)).setAttribute("minimizada","N" );
      ((Element)v.get(205)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(218)).setAttribute("ancho","150" );
      ((Element)v.get(218)).setAttribute("minimizable","S" );
      ((Element)v.get(218)).setAttribute("minimizada","N" );
      ((Element)v.get(205)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(219)).setAttribute("ancho","150" );
      ((Element)v.get(219)).setAttribute("minimizable","S" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(219)).setAttribute("minimizada","N" );
      ((Element)v.get(205)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(220)).setAttribute("ancho","150" );
      ((Element)v.get(220)).setAttribute("minimizable","S" );
      ((Element)v.get(220)).setAttribute("minimizada","N" );
      ((Element)v.get(205)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(221)).setAttribute("ancho","100" );
      ((Element)v.get(221)).setAttribute("minimizable","S" );
      ((Element)v.get(221)).setAttribute("minimizada","N" );
      ((Element)v.get(221)).setAttribute("oculta","S" );
      ((Element)v.get(205)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("ancho","100" );
      ((Element)v.get(222)).setAttribute("minimizable","S" );
      ((Element)v.get(222)).setAttribute("minimizada","N" );
      ((Element)v.get(222)).setAttribute("oculta","S" );
      ((Element)v.get(205)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(223)).setAttribute("ancho","100" );
      ((Element)v.get(223)).setAttribute("minimizable","S" );
      ((Element)v.get(223)).setAttribute("minimizada","N" );
      ((Element)v.get(223)).setAttribute("oculta","S" );
      ((Element)v.get(205)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("ancho","100" );
      ((Element)v.get(224)).setAttribute("minimizable","S" );
      ((Element)v.get(224)).setAttribute("minimizada","N" );
      ((Element)v.get(224)).setAttribute("oculta","S" );
      ((Element)v.get(205)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(225)).setAttribute("ancho","100" );
      ((Element)v.get(225)).setAttribute("minimizable","S" );
      ((Element)v.get(225)).setAttribute("minimizada","N" );
      ((Element)v.get(225)).setAttribute("oculta","S" );
      ((Element)v.get(205)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(226)).setAttribute("ancho","100" );
      ((Element)v.get(226)).setAttribute("minimizable","S" );
      ((Element)v.get(226)).setAttribute("minimizada","N" );
      ((Element)v.get(226)).setAttribute("oculta","S" );
      ((Element)v.get(205)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */

      /* Empieza nodo:227 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("ancho","100" );
      ((Element)v.get(227)).setAttribute("minimizable","S" );
      ((Element)v.get(227)).setAttribute("minimizada","N" );
      ((Element)v.get(227)).setAttribute("oculta","S" );
      ((Element)v.get(205)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(228)).setAttribute("ancho","100" );
      ((Element)v.get(228)).setAttribute("minimizable","S" );
      ((Element)v.get(228)).setAttribute("minimizada","N" );
      ((Element)v.get(228)).setAttribute("oculta","S" );
      ((Element)v.get(205)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("ancho","100" );
      ((Element)v.get(229)).setAttribute("minimizable","S" );
      ((Element)v.get(229)).setAttribute("minimizada","N" );
      ((Element)v.get(229)).setAttribute("oculta","S" );
      ((Element)v.get(205)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("ancho","100" );
      ((Element)v.get(230)).setAttribute("minimizable","S" );
      ((Element)v.get(230)).setAttribute("minimizada","N" );
      ((Element)v.get(230)).setAttribute("oculta","S" );
      ((Element)v.get(205)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("ancho","100" );
      ((Element)v.get(231)).setAttribute("minimizable","S" );
      ((Element)v.get(231)).setAttribute("minimizada","N" );
      ((Element)v.get(231)).setAttribute("oculta","S" );
      ((Element)v.get(205)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(232)).setAttribute("ancho","100" );
      ((Element)v.get(232)).setAttribute("minimizable","S" );
      ((Element)v.get(232)).setAttribute("minimizada","N" );
      ((Element)v.get(232)).setAttribute("oculta","S" );
      ((Element)v.get(205)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:205   */

      /* Empieza nodo:233 / Elemento padre: 195   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(233)).setAttribute("alto","20" );
      ((Element)v.get(233)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(233)).setAttribute("imgFondo","" );
      ((Element)v.get(233)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(195)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(234)).setAttribute("colFondo","" );
      ((Element)v.get(234)).setAttribute("ID","EstCab" );
      ((Element)v.get(234)).setAttribute("cod","396" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 233   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(235)).setAttribute("colFondo","" );
      ((Element)v.get(235)).setAttribute("ID","EstCab" );
      ((Element)v.get(235)).setAttribute("cod","396" );
      ((Element)v.get(233)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(236)).setAttribute("colFondo","" );
      ((Element)v.get(236)).setAttribute("ID","EstCab" );
      ((Element)v.get(236)).setAttribute("cod","396" );
      ((Element)v.get(233)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(237)).setAttribute("colFondo","" );
      ((Element)v.get(237)).setAttribute("ID","EstCab" );
      ((Element)v.get(237)).setAttribute("cod","367" );
      ((Element)v.get(233)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(238)).setAttribute("colFondo","" );
      ((Element)v.get(238)).setAttribute("ID","EstCab" );
      ((Element)v.get(238)).setAttribute("cod","263" );
      ((Element)v.get(233)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(239)).setAttribute("colFondo","" );
      ((Element)v.get(239)).setAttribute("ID","EstCab" );
      ((Element)v.get(239)).setAttribute("cod","418" );
      ((Element)v.get(233)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(240)).setAttribute("colFondo","" );
      ((Element)v.get(240)).setAttribute("ID","EstCab" );
      ((Element)v.get(240)).setAttribute("cod","299" );
      ((Element)v.get(233)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(241)).setAttribute("colFondo","" );
      ((Element)v.get(241)).setAttribute("ID","EstCab" );
      ((Element)v.get(241)).setAttribute("cod","375" );
      ((Element)v.get(233)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(242)).setAttribute("colFondo","" );
      ((Element)v.get(242)).setAttribute("ID","EstCab" );
      ((Element)v.get(242)).setAttribute("cod","401" );
      ((Element)v.get(233)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(243)).setAttribute("colFondo","" );
      ((Element)v.get(243)).setAttribute("ID","EstCab" );
      ((Element)v.get(243)).setAttribute("cod","402" );
      ((Element)v.get(233)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(244)).setAttribute("colFondo","" );
      ((Element)v.get(244)).setAttribute("ID","EstCab" );
      ((Element)v.get(244)).setAttribute("cod","336" );
      ((Element)v.get(233)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(245)).setAttribute("colFondo","" );
      ((Element)v.get(245)).setAttribute("ID","EstCab" );
      ((Element)v.get(245)).setAttribute("cod","9" );
      ((Element)v.get(233)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */

      /* Empieza nodo:246 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(246)).setAttribute("colFondo","" );
      ((Element)v.get(246)).setAttribute("ID","EstCab" );
      ((Element)v.get(246)).setAttribute("cod","408" );
      ((Element)v.get(233)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */

      /* Empieza nodo:247 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(247)).setAttribute("colFondo","" );
      ((Element)v.get(247)).setAttribute("ID","EstCab" );
      ((Element)v.get(247)).setAttribute("cod","309" );
      ((Element)v.get(233)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(248)).setAttribute("colFondo","" );
      ((Element)v.get(248)).setAttribute("ID","EstCab" );
      ((Element)v.get(248)).setAttribute("cod","2494" );
      ((Element)v.get(233)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */

      /* Empieza nodo:249 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(249)).setAttribute("tipo","texto" );
      ((Element)v.get(249)).setAttribute("ID","EstDat2" );
      ((Element)v.get(233)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(250)).setAttribute("tipo","texto" );
      ((Element)v.get(250)).setAttribute("ID","EstDat2" );
      ((Element)v.get(233)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(251)).setAttribute("tipo","texto" );
      ((Element)v.get(251)).setAttribute("ID","EstDat2" );
      ((Element)v.get(233)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("tipo","texto" );
      ((Element)v.get(252)).setAttribute("ID","EstDat2" );
      ((Element)v.get(233)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(253)).setAttribute("tipo","texto" );
      ((Element)v.get(253)).setAttribute("ID","EstDat2" );
      ((Element)v.get(233)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 233   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(254)).setAttribute("tipo","texto" );
      ((Element)v.get(254)).setAttribute("ID","EstDat2" );
      ((Element)v.get(233)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("tipo","texto" );
      ((Element)v.get(255)).setAttribute("ID","EstDat2" );
      ((Element)v.get(233)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(256)).setAttribute("tipo","texto" );
      ((Element)v.get(256)).setAttribute("ID","EstDat2" );
      ((Element)v.get(233)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("tipo","texto" );
      ((Element)v.get(257)).setAttribute("ID","EstDat2" );
      ((Element)v.get(233)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(258)).setAttribute("tipo","texto" );
      ((Element)v.get(258)).setAttribute("ID","EstDat2" );
      ((Element)v.get(233)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(259)).setAttribute("tipo","texto" );
      ((Element)v.get(259)).setAttribute("ID","EstDat2" );
      ((Element)v.get(233)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(260)).setAttribute("tipo","texto" );
      ((Element)v.get(260)).setAttribute("ID","EstDat2" );
      ((Element)v.get(233)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:233   */

      /* Empieza nodo:261 / Elemento padre: 195   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(261)).setAttribute("alto","22" );
      ((Element)v.get(261)).setAttribute("accion","" );
      ((Element)v.get(261)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(261)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(261)).setAttribute("maxSel","-1" );
      ((Element)v.get(261)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(261)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(261)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(261)).setAttribute("onLoad","" );
      ((Element)v.get(261)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(195)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(262)).setAttribute("tipo","texto" );
      ((Element)v.get(262)).setAttribute("ID","EstDat" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(263)).setAttribute("tipo","texto" );
      ((Element)v.get(263)).setAttribute("ID","EstDat" );
      ((Element)v.get(261)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */

      /* Empieza nodo:264 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(264)).setAttribute("tipo","texto" );
      ((Element)v.get(264)).setAttribute("ID","EstDat" );
      ((Element)v.get(261)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("tipo","texto" );
      ((Element)v.get(265)).setAttribute("ID","EstDat2" );
      ((Element)v.get(261)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(266)).setAttribute("tipo","texto" );
      ((Element)v.get(266)).setAttribute("ID","EstDat" );
      ((Element)v.get(261)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(267)).setAttribute("tipo","texto" );
      ((Element)v.get(267)).setAttribute("ID","EstDat2" );
      ((Element)v.get(261)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("tipo","texto" );
      ((Element)v.get(268)).setAttribute("ID","EstDat" );
      ((Element)v.get(261)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("tipo","texto" );
      ((Element)v.get(269)).setAttribute("ID","EstDat2" );
      ((Element)v.get(261)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("tipo","texto" );
      ((Element)v.get(270)).setAttribute("ID","EstDat" );
      ((Element)v.get(261)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(271)).setAttribute("tipo","texto" );
      ((Element)v.get(271)).setAttribute("ID","EstDat2" );
      ((Element)v.get(261)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("tipo","texto" );
      ((Element)v.get(272)).setAttribute("ID","EstDat" );
      ((Element)v.get(261)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("tipo","texto" );
      ((Element)v.get(273)).setAttribute("ID","EstDat2" );
      ((Element)v.get(261)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("tipo","texto" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(274)).setAttribute("ID","EstDat" );
      ((Element)v.get(261)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("tipo","texto" );
      ((Element)v.get(275)).setAttribute("ID","EstDat2" );
      ((Element)v.get(261)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("tipo","texto" );
      ((Element)v.get(276)).setAttribute("ID","EstDat" );
      ((Element)v.get(261)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("tipo","texto" );
      ((Element)v.get(277)).setAttribute("ID","EstDat2" );
      ((Element)v.get(261)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("tipo","texto" );
      ((Element)v.get(278)).setAttribute("ID","EstDat2" );
      ((Element)v.get(261)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("tipo","texto" );
      ((Element)v.get(279)).setAttribute("ID","EstDat2" );
      ((Element)v.get(261)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("tipo","texto" );
      ((Element)v.get(280)).setAttribute("ID","EstDat2" );
      ((Element)v.get(261)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(281)).setAttribute("tipo","texto" );
      ((Element)v.get(281)).setAttribute("ID","EstDat2" );
      ((Element)v.get(261)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(282)).setAttribute("tipo","texto" );
      ((Element)v.get(282)).setAttribute("ID","EstDat2" );
      ((Element)v.get(261)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(283)).setAttribute("tipo","texto" );
      ((Element)v.get(283)).setAttribute("ID","EstDat2" );
      ((Element)v.get(261)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("tipo","texto" );
      ((Element)v.get(284)).setAttribute("ID","EstDat2" );
      ((Element)v.get(261)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("tipo","texto" );
      ((Element)v.get(285)).setAttribute("ID","EstDat2" );
      ((Element)v.get(261)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(286)).setAttribute("tipo","texto" );
      ((Element)v.get(286)).setAttribute("ID","EstDat2" );
      ((Element)v.get(261)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(287)).setAttribute("tipo","texto" );
      ((Element)v.get(287)).setAttribute("ID","EstDat2" );
      ((Element)v.get(261)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 261   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(288)).setAttribute("tipo","texto" );
      ((Element)v.get(288)).setAttribute("ID","EstDat2" );
      ((Element)v.get(261)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:261   */
      /* Termina nodo:195   */

      /* Empieza nodo:289 / Elemento padre: 93   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(289)).setAttribute("nombre","Eliminar" );
      ((Element)v.get(289)).setAttribute("x","1" );
      ((Element)v.get(289)).setAttribute("y","636" );
      ((Element)v.get(289)).setAttribute("ID","botonContenido" );
      ((Element)v.get(289)).setAttribute("img","" );
      ((Element)v.get(289)).setAttribute("tipo","html" );
      ((Element)v.get(289)).setAttribute("estado","false" );
      ((Element)v.get(289)).setAttribute("alt","" );
      ((Element)v.get(289)).setAttribute("cod","1254" );
      ((Element)v.get(289)).setAttribute("accion","fBorrar();" );
      ((Element)v.get(289)).setAttribute("onshtab","onShTabEliminar();" );
      ((Element)v.get(93)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 93   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(290)).setAttribute("nombre","Aceptar" );
      ((Element)v.get(290)).setAttribute("x","55" );
      ((Element)v.get(290)).setAttribute("y","636" );
      ((Element)v.get(290)).setAttribute("ID","botonContenido" );
      ((Element)v.get(290)).setAttribute("img","" );
      ((Element)v.get(290)).setAttribute("tipo","html" );
      ((Element)v.get(290)).setAttribute("estado","false" );
      ((Element)v.get(290)).setAttribute("alt","" );
      ((Element)v.get(290)).setAttribute("cod","12" );
      ((Element)v.get(290)).setAttribute("accion","onClickAceptar();" );
      ((Element)v.get(290)).setAttribute("ontab","onTabAceptar();" );
      ((Element)v.get(93)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:93   */
      /* Termina nodo:6   */


   }

}

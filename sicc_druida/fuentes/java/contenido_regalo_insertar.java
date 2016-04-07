
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_regalo_insertar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_regalo_insertar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoad();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","contenido_regalo_insertar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","txtCodRegalo" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","717" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtDescripcion" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","9" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:6   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(9)).setAttribute("nombre","Formulario" );
      ((Element)v.get(9)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","accion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","casoUso" );
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
      ((Element)v.get(15)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hOids" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","oidRegalo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","idioma" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","pais" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","descripcion" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","codigoRegalo" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("nombre","capa" );
      ((Element)v.get(9)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("table"));
      ((Element)v.get(23)).setAttribute("width","100%" );
      ((Element)v.get(23)).setAttribute("border","0" );
      ((Element)v.get(23)).setAttribute("cellspacing","0" );
      ((Element)v.get(23)).setAttribute("cellpadding","0" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("align","center" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(26)).setAttribute("height","12" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","750" );
      ((Element)v.get(24)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).setAttribute("width","12" );
      ((Element)v.get(24)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).setAttribute("width","12" );
      ((Element)v.get(30)).setAttribute("height","1" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */
      /* Termina nodo:24   */

      /* Empieza nodo:31 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(36)).setAttribute("class","legend" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(37)).setAttribute("nombre","lblAlta" );
      ((Element)v.get(37)).setAttribute("alto","13" );
      ((Element)v.get(37)).setAttribute("filas","1" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(37)).setAttribute("id","legend" );
      ((Element)v.get(37)).setAttribute("cod","00127" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("table"));
      ((Element)v.get(38)).setAttribute("width","100%" );
      ((Element)v.get(38)).setAttribute("border","0" );
      ((Element)v.get(38)).setAttribute("align","center" );
      ((Element)v.get(38)).setAttribute("cellspacing","0" );
      ((Element)v.get(38)).setAttribute("cellpadding","0" );
      ((Element)v.get(35)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("table"));
      ((Element)v.get(41)).setAttribute("width","400" );
      ((Element)v.get(41)).setAttribute("border","0" );
      ((Element)v.get(41)).setAttribute("align","left" );
      ((Element)v.get(41)).setAttribute("cellspacing","0" );
      ((Element)v.get(41)).setAttribute("cellpadding","0" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).setAttribute("colspan","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","8" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:45 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","8" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("height","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(49)).setAttribute("nombre","lblCodRegalo" );
      ((Element)v.get(49)).setAttribute("alto","13" );
      ((Element)v.get(49)).setAttribute("filas","1" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(49)).setAttribute("id","datosTitle" );
      ((Element)v.get(49)).setAttribute("cod","717" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","25" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("colspan","3" );
      ((Element)v.get(45)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(53)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(53)).setAttribute("alto","13" );
      ((Element)v.get(53)).setAttribute("filas","1" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(53)).setAttribute("id","datosTitle" );
      ((Element)v.get(53)).setAttribute("cod","9" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("width","100%" );
      ((Element)v.get(45)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","8" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:45   */

      /* Empieza nodo:56 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(56));

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
      ((Element)v.get(59)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(56)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(60)).setAttribute("nombre","txtCodRegalo" );
      ((Element)v.get(60)).setAttribute("id","datosCampos" );
      ((Element)v.get(60)).setAttribute("max","3" );
      ((Element)v.get(60)).setAttribute("tipo","" );
      ((Element)v.get(60)).setAttribute("onblur","" );
      ((Element)v.get(60)).setAttribute("onchange","" );
      ((Element)v.get(60)).setAttribute("req","S" );
      ((Element)v.get(60)).setAttribute("size","3" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("validacion","" );
      ((Element)v.get(60)).setAttribute("onshtab","document.all['btnEliminarProducto'].focus();" );
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
      ((Element)v.get(63)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(56)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(64)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(64)).setAttribute("id","datosCampos" );
      ((Element)v.get(64)).setAttribute("max","30" );
      ((Element)v.get(64)).setAttribute("tipo","" );
      ((Element)v.get(64)).setAttribute("onchange","" );
      ((Element)v.get(64)).setAttribute("req","S" );
      ((Element)v.get(64)).setAttribute("size","30" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(64)).setAttribute("validacion","" );
      ((Element)v.get(64)).setAttribute("onshtab","focalizaOnshtab();" );
      ((Element)v.get(64)).setAttribute("ontab","document.all['btnBuscarProducto'].focus();" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(68)).setAttribute("width","21" );
      ((Element)v.get(68)).setAttribute("height","15" );
      ((Element)v.get(68)).setAttribute("onclick","levantarI18N('Formulario', '1');" );
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

      /* Empieza nodo:71 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("colspan","9" );
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
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:74 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:31   */

      /* Empieza nodo:76 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","12" );
      ((Element)v.get(77)).setAttribute("align","center" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","12" );
      ((Element)v.get(78)).setAttribute("height","12" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("width","756" );
      ((Element)v.get(76)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","12" );
      ((Element)v.get(76)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","12" );
      ((Element)v.get(82)).setAttribute("height","1" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:76   */
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:83 / Elemento padre: 9   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(83)).setAttribute("nombre","listado1" );
      ((Element)v.get(83)).setAttribute("ancho","404" );
      ((Element)v.get(83)).setAttribute("alto","299" );
      ((Element)v.get(83)).setAttribute("x","12" );
      ((Element)v.get(83)).setAttribute("y","102" );
      ((Element)v.get(83)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(83)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(9)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(84)).setAttribute("precarga","S" );
      ((Element)v.get(84)).setAttribute("conROver","S" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(85)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(85)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(85)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(85)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 84   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(86)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(86)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(86)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(86)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(84)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 84   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(87)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(87)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(84)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:84   */

      /* Empieza nodo:88 / Elemento padre: 83   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(83)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(89)).setAttribute("borde","1" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(89)).setAttribute("horizDatos","1" );
      ((Element)v.get(89)).setAttribute("horizCabecera","1" );
      ((Element)v.get(89)).setAttribute("vertical","1" );
      ((Element)v.get(89)).setAttribute("horizTitulo","1" );
      ((Element)v.get(89)).setAttribute("horizBase","1" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 88   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(90)).setAttribute("borde","#999999" );
      ((Element)v.get(90)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(90)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(90)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(90)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(90)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(90)).setAttribute("horizBase","#999999" );
      ((Element)v.get(88)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:88   */

      /* Empieza nodo:91 / Elemento padre: 83   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(91)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(91)).setAttribute("alto","22" );
      ((Element)v.get(91)).setAttribute("imgFondo","" );
      ((Element)v.get(91)).setAttribute("cod","00499" );
      ((Element)v.get(91)).setAttribute("ID","datosTitle" );
      ((Element)v.get(83)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 83   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(92)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(92)).setAttribute("alto","22" );
      ((Element)v.get(92)).setAttribute("imgFondo","" );
      ((Element)v.get(83)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 83   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(93)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(93)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(93)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(93)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(93)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(93)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(83)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(94)).setAttribute("ancho","100" );
      ((Element)v.get(94)).setAttribute("minimizable","S" );
      ((Element)v.get(94)).setAttribute("minimizada","N" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 93   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("ancho","100" );
      ((Element)v.get(95)).setAttribute("minimizable","S" );
      ((Element)v.get(95)).setAttribute("minimizada","N" );
      ((Element)v.get(93)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:93   */

      /* Empieza nodo:96 / Elemento padre: 83   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(96)).setAttribute("alto","20" );
      ((Element)v.get(96)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(96)).setAttribute("imgFondo","" );
      ((Element)v.get(96)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(83)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("colFondo","" );
      ((Element)v.get(97)).setAttribute("ID","EstCab" );
      ((Element)v.get(97)).setAttribute("cod","00329" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 96   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(98)).setAttribute("colFondo","" );
      ((Element)v.get(98)).setAttribute("ID","EstCab" );
      ((Element)v.get(98)).setAttribute("cod","338" );
      ((Element)v.get(96)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:96   */

      /* Empieza nodo:99 / Elemento padre: 83   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(99)).setAttribute("alto","22" );
      ((Element)v.get(99)).setAttribute("accion","" );
      ((Element)v.get(99)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(99)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(99)).setAttribute("maxSel","-1" );
      ((Element)v.get(99)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(99)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(99)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(99)).setAttribute("onLoad","" );
      ((Element)v.get(99)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(83)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(100)).setAttribute("tipo","texto" );
      ((Element)v.get(100)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("tipo","texto" );
      ((Element)v.get(101)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:99   */

      /* Empieza nodo:102 / Elemento padre: 83   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(83)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 83   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(103)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(103)).setAttribute("ancho","404" );
      ((Element)v.get(103)).setAttribute("sep","$" );
      ((Element)v.get(103)).setAttribute("x","12" );
      ((Element)v.get(103)).setAttribute("class","botonera" );
      ((Element)v.get(103)).setAttribute("y","378" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(103)).setAttribute("control","|" );
      ((Element)v.get(103)).setAttribute("conector","" );
      ((Element)v.get(103)).setAttribute("rowset","" );
      ((Element)v.get(103)).setAttribute("cargainicial","N" );
      ((Element)v.get(83)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(104)).setAttribute("nombre","ret1" );
      ((Element)v.get(104)).setAttribute("x","37" );
      ((Element)v.get(104)).setAttribute("y","382" );
      ((Element)v.get(104)).setAttribute("ID","botonContenido" );
      ((Element)v.get(104)).setAttribute("img","retroceder_on" );
      ((Element)v.get(104)).setAttribute("tipo","0" );
      ((Element)v.get(104)).setAttribute("estado","false" );
      ((Element)v.get(104)).setAttribute("alt","" );
      ((Element)v.get(104)).setAttribute("codigo","" );
      ((Element)v.get(104)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 103   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(105)).setAttribute("nombre","ava1" );
      ((Element)v.get(105)).setAttribute("x","52" );
      ((Element)v.get(105)).setAttribute("y","382" );
      ((Element)v.get(105)).setAttribute("ID","botonContenido" );
      ((Element)v.get(105)).setAttribute("img","avanzar_on" );
      ((Element)v.get(105)).setAttribute("tipo","0" );
      ((Element)v.get(105)).setAttribute("estado","false" );
      ((Element)v.get(105)).setAttribute("alt","" );
      ((Element)v.get(105)).setAttribute("codigo","" );
      ((Element)v.get(105)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(103)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:103   */
      /* Termina nodo:83   */

      /* Empieza nodo:106 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(106)).setAttribute("nombre","primera1" );
      ((Element)v.get(106)).setAttribute("x","20" );
      ((Element)v.get(106)).setAttribute("y","382" );
      ((Element)v.get(106)).setAttribute("ID","botonContenido" );
      ((Element)v.get(106)).setAttribute("img","primera_on" );
      ((Element)v.get(106)).setAttribute("tipo","-2" );
      ((Element)v.get(106)).setAttribute("estado","false" );
      ((Element)v.get(106)).setAttribute("alt","" );
      ((Element)v.get(106)).setAttribute("codigo","" );
      ((Element)v.get(106)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(9)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(107)).setAttribute("nombre","separa" );
      ((Element)v.get(107)).setAttribute("x","59" );
      ((Element)v.get(107)).setAttribute("y","378" );
      ((Element)v.get(107)).setAttribute("ID","botonContenido" );
      ((Element)v.get(107)).setAttribute("img","separa_base" );
      ((Element)v.get(107)).setAttribute("tipo","0" );
      ((Element)v.get(107)).setAttribute("estado","false" );
      ((Element)v.get(107)).setAttribute("alt","" );
      ((Element)v.get(107)).setAttribute("codigo","" );
      ((Element)v.get(107)).setAttribute("accion","" );
      ((Element)v.get(9)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(108)).setAttribute("nombre","btnBuscarProducto" );
      ((Element)v.get(108)).setAttribute("x","80" );
      ((Element)v.get(108)).setAttribute("y","379" );
      ((Element)v.get(108)).setAttribute("ID","botonContenido" );
      ((Element)v.get(108)).setAttribute("tipo","html" );
      ((Element)v.get(108)).setAttribute("estado","false" );
      ((Element)v.get(108)).setAttribute("cod","445" );
      ((Element)v.get(108)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(108)).setAttribute("onshtab","focaliza('Formulario.txtDescripcion');" );
      ((Element)v.get(9)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(109)).setAttribute("nombre","btnEliminarProducto" );
      ((Element)v.get(109)).setAttribute("x","201" );
      ((Element)v.get(109)).setAttribute("y","379" );
      ((Element)v.get(109)).setAttribute("ID","botonContenido" );
      ((Element)v.get(109)).setAttribute("tipo","html" );
      ((Element)v.get(109)).setAttribute("estado","false" );
      ((Element)v.get(109)).setAttribute("cod","2025" );
      ((Element)v.get(109)).setAttribute("accion","onClickQuitar();" );
      ((Element)v.get(109)).setAttribute("ontab","focalizaOntab();" );
      ((Element)v.get(9)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(110)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(110)).setAttribute("alto","12" );
      ((Element)v.get(110)).setAttribute("ancho","50" );
      ((Element)v.get(110)).setAttribute("x","0" );
      ((Element)v.get(110)).setAttribute("y","401" );
      ((Element)v.get(9)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:9   */


   }

}

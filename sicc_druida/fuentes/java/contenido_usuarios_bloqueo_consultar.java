
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_usuarios_bloqueo_consultar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_usuarios_bloqueo_consultar" );
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
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","contenido_usuarios_bloqueo_consultar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","formulario" );
      ((Element)v.get(6)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","conectorAction" );
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
      ((Element)v.get(12)).setAttribute("nombre","oidPais" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(14)).setAttribute("nombre","capa1" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("table"));
      ((Element)v.get(15)).setAttribute("width","100%" );
      ((Element)v.get(15)).setAttribute("border","0" );
      ((Element)v.get(15)).setAttribute("cellspacing","0" );
      ((Element)v.get(15)).setAttribute("cellpadding","0" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).setAttribute("width","12" );
      ((Element)v.get(17)).setAttribute("align","center" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(18)).setAttribute("src","b.gif" );
      ((Element)v.get(18)).setAttribute("width","12" );
      ((Element)v.get(18)).setAttribute("height","12" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:19 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","750" );
      ((Element)v.get(16)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:21 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(16)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(22)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(22)).setAttribute("height","1" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */
      /* Termina nodo:16   */

      /* Empieza nodo:23 / Elemento padre: 15   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(28)).setAttribute("class","legend" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(29)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(29)).setAttribute("alto","13" );
      ((Element)v.get(29)).setAttribute("filas","1" );
      ((Element)v.get(29)).setAttribute("cod","0075" );
      ((Element)v.get(29)).setAttribute("id","legend" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 27   */
      v.add(doc.createElement("table"));
      ((Element)v.get(30)).setAttribute("width","98%" );
      ((Element)v.get(30)).setAttribute("border","0" );
      ((Element)v.get(30)).setAttribute("align","center" );
      ((Element)v.get(30)).setAttribute("cellspacing","0" );
      ((Element)v.get(30)).setAttribute("cellpadding","0" );
      ((Element)v.get(27)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).setAttribute("colspan","4" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).setAttribute("width","8" );
      ((Element)v.get(33)).setAttribute("height","8" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:34 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","8" );
      ((Element)v.get(36)).setAttribute("height","8" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(38)).setAttribute("nombre","lblCodigoUsuario" );
      ((Element)v.get(38)).setAttribute("alto","13" );
      ((Element)v.get(38)).setAttribute("filas","1" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(38)).setAttribute("id","datosTitle" );
      ((Element)v.get(38)).setAttribute("cod","3210" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","25" );
      ((Element)v.get(40)).setAttribute("height","8" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("width","100%" );
      ((Element)v.get(34)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","8" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:34   */

      /* Empieza nodo:43 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(43));

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
      ((Element)v.get(46)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(47)).setAttribute("nombre","txtCodigoUsuario" );
      ((Element)v.get(47)).setAttribute("id","datosCampos" );
      ((Element)v.get(47)).setAttribute("max","20" );
      ((Element)v.get(47)).setAttribute("tipo","" );
      ((Element)v.get(47)).setAttribute("req","N" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("size","30" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(47)).setAttribute("validacion","" );
      ((Element)v.get(47)).setAttribute("onshtab","onShTabTxtCodigoUsuario();" );
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
      ((Element)v.get(50)).setAttribute("width","100%" );
      ((Element)v.get(43)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","8" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:43   */
      /* Termina nodo:30   */

      /* Empieza nodo:52 / Elemento padre: 27   */
      v.add(doc.createElement("table"));
      ((Element)v.get(52)).setAttribute("width","98%" );
      ((Element)v.get(52)).setAttribute("border","0" );
      ((Element)v.get(52)).setAttribute("align","center" );
      ((Element)v.get(52)).setAttribute("cellspacing","0" );
      ((Element)v.get(52)).setAttribute("cellpadding","0" );
      ((Element)v.get(27)).appendChild((Element)v.get(52));

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
      ((Element)v.get(55)).setAttribute("height","12" );
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
      ((Element)v.get(60)).setAttribute("nombre","lblTipoBloqueo" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("id","datosTitle" );
      ((Element)v.get(60)).setAttribute("cod","3207" );
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
      ((Element)v.get(64)).setAttribute("nombre","lblAccionPermitida" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(64)).setAttribute("id","datosTitle" );
      ((Element)v.get(64)).setAttribute("cod","3212" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","100%" );
      ((Element)v.get(56)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","8" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:56   */

      /* Empieza nodo:67 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(67));

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
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(67)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(71)).setAttribute("nombre","cbTipoBloqueo" );
      ((Element)v.get(71)).setAttribute("id","datosCampos" );
      ((Element)v.get(71)).setAttribute("size","1" );
      ((Element)v.get(71)).setAttribute("multiple","N" );
      ((Element)v.get(71)).setAttribute("req","N" );
      ((Element)v.get(71)).setAttribute("valorinicial","" );
      ((Element)v.get(71)).setAttribute("textoinicial","" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:73 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","25" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(67)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(76)).setAttribute("nombre","cbAccionPermitida" );
      ((Element)v.get(76)).setAttribute("id","datosCampos" );
      ((Element)v.get(76)).setAttribute("size","1" );
      ((Element)v.get(76)).setAttribute("multiple","N" );
      ((Element)v.get(76)).setAttribute("req","N" );
      ((Element)v.get(76)).setAttribute("valorinicial","" );
      ((Element)v.get(76)).setAttribute("textoinicial","" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:78 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","100%" );
      ((Element)v.get(67)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:67   */

      /* Empieza nodo:80 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("colspan","4" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","16" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:52   */
      /* Termina nodo:27   */
      /* Termina nodo:26   */
      /* Termina nodo:23   */

      /* Empieza nodo:83 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("table"));
      ((Element)v.get(88)).setAttribute("width","100%" );
      ((Element)v.get(88)).setAttribute("border","0" );
      ((Element)v.get(88)).setAttribute("align","center" );
      ((Element)v.get(88)).setAttribute("cellspacing","0" );
      ((Element)v.get(88)).setAttribute("cellpadding","0" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("width","3" );
      ((Element)v.get(90)).setAttribute("class","botonera" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("class","botonera" );
      ((Element)v.get(89)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(92)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(92)).setAttribute("ID","botonContenido" );
      ((Element)v.get(92)).setAttribute("tipo","html" );
      ((Element)v.get(92)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(92)).setAttribute("cod","1" );
      ((Element)v.get(92)).setAttribute("estado","false" );
      ((Element)v.get(92)).setAttribute("onshtab","foco('formulario.cbAccionPermitida');" );
      ((Element)v.get(92)).setAttribute("ontab","onTabBuscar();" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:93 / Elemento padre: 83   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","8" );
      ((Element)v.get(94)).setAttribute("height","12" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:83   */
      /* Termina nodo:15   */
      /* Termina nodo:14   */

      /* Empieza nodo:95 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(95)).setAttribute("nombre","capaLista1" );
      ((Element)v.get(95)).setAttribute("ancho","100%" );
      ((Element)v.get(95)).setAttribute("alto","330" );
      ((Element)v.get(95)).setAttribute("x","6" );
      ((Element)v.get(95)).setAttribute("y","170" );
      ((Element)v.get(95)).setAttribute("colorf","" );
      ((Element)v.get(95)).setAttribute("borde","0" );
      ((Element)v.get(95)).setAttribute("imagenf","" );
      ((Element)v.get(95)).setAttribute("repeat","" );
      ((Element)v.get(95)).setAttribute("padding","" );
      ((Element)v.get(95)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(95)).setAttribute("contravsb","" );
      ((Element)v.get(95)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(96)).setAttribute("nombre","listado1" );
      ((Element)v.get(96)).setAttribute("ancho","300" );
      ((Element)v.get(96)).setAttribute("alto","301" );
      ((Element)v.get(96)).setAttribute("x","12" );
      ((Element)v.get(96)).setAttribute("y","0" );
      ((Element)v.get(96)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(96)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(96)).setAttribute("pintadoSimplificado","S" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(97)).setAttribute("precarga","S" );
      ((Element)v.get(97)).setAttribute("conROver","S" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(98)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(98)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(98)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(98)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 97   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(99)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(99)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(99)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(99)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(97)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(100)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(100)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(97)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:97   */

      /* Empieza nodo:101 / Elemento padre: 96   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(96)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(102)).setAttribute("borde","1" );
      ((Element)v.get(102)).setAttribute("horizDatos","1" );
      ((Element)v.get(102)).setAttribute("horizCabecera","1" );
      ((Element)v.get(102)).setAttribute("vertical","1" );
      ((Element)v.get(102)).setAttribute("horizTitulo","1" );
      ((Element)v.get(102)).setAttribute("horizBase","1" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 101   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(103)).setAttribute("borde","#999999" );
      ((Element)v.get(103)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(103)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(103)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(103)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(103)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(103)).setAttribute("horizBase","#999999" );
      ((Element)v.get(101)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:101   */

      /* Empieza nodo:104 / Elemento padre: 96   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(104)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(104)).setAttribute("alto","22" );
      ((Element)v.get(104)).setAttribute("imgFondo","" );
      ((Element)v.get(104)).setAttribute("cod","00135" );
      ((Element)v.get(104)).setAttribute("ID","datosTitle" );
      ((Element)v.get(96)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 96   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(105)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(105)).setAttribute("alto","22" );
      ((Element)v.get(105)).setAttribute("imgFondo","" );
      ((Element)v.get(96)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 96   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(106)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(106)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(106)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(106)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(106)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(106)).setAttribute("botonOrdenar","S" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(96)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("ancho","0" );
      ((Element)v.get(107)).setAttribute("minimizable","S" );
      ((Element)v.get(107)).setAttribute("minimizada","N" );
      ((Element)v.get(107)).setAttribute("oculta","S" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("ancho","0" );
      ((Element)v.get(108)).setAttribute("minimizable","S" );
      ((Element)v.get(108)).setAttribute("minimizada","N" );
      ((Element)v.get(108)).setAttribute("oculta","S" );
      ((Element)v.get(106)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("ancho","90" );
      ((Element)v.get(109)).setAttribute("minimizable","S" );
      ((Element)v.get(109)).setAttribute("minimizada","N" );
      ((Element)v.get(106)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("ancho","0" );
      ((Element)v.get(110)).setAttribute("minimizable","S" );
      ((Element)v.get(110)).setAttribute("minimizada","N" );
      ((Element)v.get(110)).setAttribute("oculta","S" );
      ((Element)v.get(106)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("ancho","0" );
      ((Element)v.get(111)).setAttribute("minimizable","S" );
      ((Element)v.get(111)).setAttribute("minimizada","N" );
      ((Element)v.get(111)).setAttribute("oculta","S" );
      ((Element)v.get(106)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("ancho","90" );
      ((Element)v.get(112)).setAttribute("minimizable","S" );
      ((Element)v.get(112)).setAttribute("minimizada","N" );
      ((Element)v.get(106)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("ancho","0" );
      ((Element)v.get(113)).setAttribute("minimizable","S" );
      ((Element)v.get(113)).setAttribute("minimizada","N" );
      ((Element)v.get(113)).setAttribute("oculta","S" );
      ((Element)v.get(106)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("ancho","90" );
      ((Element)v.get(114)).setAttribute("minimizable","S" );
      ((Element)v.get(114)).setAttribute("minimizada","N" );
      ((Element)v.get(106)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("ancho","0" );
      ((Element)v.get(115)).setAttribute("minimizable","S" );
      ((Element)v.get(115)).setAttribute("minimizada","N" );
      ((Element)v.get(115)).setAttribute("oculta","S" );
      ((Element)v.get(106)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:106   */

      /* Empieza nodo:116 / Elemento padre: 96   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(116)).setAttribute("alto","25" );
      ((Element)v.get(116)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(116)).setAttribute("imgFondo","" );
      ((Element)v.get(116)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(96)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("colFondo","" );
      ((Element)v.get(117)).setAttribute("ID","EstCab" );
      ((Element)v.get(117)).setAttribute("cod","" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Elemento padre:117 / Elemento actual: 118   */
      v.add(doc.createTextNode("OID_USUA_BLOQ"));
      ((Element)v.get(117)).appendChild((Text)v.get(118));

      /* Termina nodo Texto:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("colFondo","" );
      ((Element)v.get(119)).setAttribute("ID","EstCab" );
      ((Element)v.get(119)).setAttribute("cod","" );
      ((Element)v.get(116)).appendChild((Element)v.get(119));

      /* Elemento padre:119 / Elemento actual: 120   */
      v.add(doc.createTextNode("IDUSER"));
      ((Element)v.get(119)).appendChild((Text)v.get(120));

      /* Termina nodo Texto:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("colFondo","" );
      ((Element)v.get(121)).setAttribute("ID","EstCab" );
      ((Element)v.get(121)).setAttribute("cod","3210" );
      ((Element)v.get(116)).appendChild((Element)v.get(121));

      /* Elemento padre:121 / Elemento actual: 122   */
      v.add(doc.createTextNode("COD_USUA"));
      ((Element)v.get(121)).appendChild((Text)v.get(122));

      /* Termina nodo Texto:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("colFondo","" );
      ((Element)v.get(123)).setAttribute("ID","EstCab" );
      ((Element)v.get(123)).setAttribute("cod","" );
      ((Element)v.get(116)).appendChild((Element)v.get(123));

      /* Elemento padre:123 / Elemento actual: 124   */
      v.add(doc.createTextNode("NOM_USUA"));
      ((Element)v.get(123)).appendChild((Text)v.get(124));

      /* Termina nodo Texto:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("colFondo","" );
      ((Element)v.get(125)).setAttribute("ID","EstCab" );
      ((Element)v.get(125)).setAttribute("cod","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(116)).appendChild((Element)v.get(125));

      /* Elemento padre:125 / Elemento actual: 126   */
      v.add(doc.createTextNode("OID_TIPO_BLOQ"));
      ((Element)v.get(125)).appendChild((Text)v.get(126));

      /* Termina nodo Texto:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("colFondo","" );
      ((Element)v.get(127)).setAttribute("ID","EstCab" );
      ((Element)v.get(127)).setAttribute("cod","3207" );
      ((Element)v.get(116)).appendChild((Element)v.get(127));

      /* Elemento padre:127 / Elemento actual: 128   */
      v.add(doc.createTextNode("DES_TIPO_BLOQ"));
      ((Element)v.get(127)).appendChild((Text)v.get(128));

      /* Termina nodo Texto:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("colFondo","" );
      ((Element)v.get(129)).setAttribute("ID","EstCab" );
      ((Element)v.get(129)).setAttribute("cod","" );
      ((Element)v.get(116)).appendChild((Element)v.get(129));

      /* Elemento padre:129 / Elemento actual: 130   */
      v.add(doc.createTextNode("OID_VALO_USUA_BLOQ"));
      ((Element)v.get(129)).appendChild((Text)v.get(130));

      /* Termina nodo Texto:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("colFondo","" );
      ((Element)v.get(131)).setAttribute("ID","EstCab" );
      ((Element)v.get(131)).setAttribute("cod","3212" );
      ((Element)v.get(116)).appendChild((Element)v.get(131));

      /* Elemento padre:131 / Elemento actual: 132   */
      v.add(doc.createTextNode("DES_ACCI_PERM"));
      ((Element)v.get(131)).appendChild((Text)v.get(132));

      /* Termina nodo Texto:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("colFondo","" );
      ((Element)v.get(133)).setAttribute("ID","EstCab" );
      ((Element)v.get(133)).setAttribute("cod","" );
      ((Element)v.get(116)).appendChild((Element)v.get(133));

      /* Elemento padre:133 / Elemento actual: 134   */
      v.add(doc.createTextNode("indUltimaPagina"));
      ((Element)v.get(133)).appendChild((Text)v.get(134));

      /* Termina nodo Texto:134   */
      /* Termina nodo:133   */
      /* Termina nodo:116   */

      /* Empieza nodo:135 / Elemento padre: 96   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(135)).setAttribute("alto","22" );
      ((Element)v.get(135)).setAttribute("accion","" );
      ((Element)v.get(135)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(135)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(135)).setAttribute("maxSel","-1" );
      ((Element)v.get(135)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(135)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(135)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(135)).setAttribute("onLoad","" );
      ((Element)v.get(135)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(96)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("tipo","texto" );
      ((Element)v.get(136)).setAttribute("ID","EstDat" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(137)).setAttribute("tipo","texto" );
      ((Element)v.get(137)).setAttribute("ID","EstDat" );
      ((Element)v.get(135)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("tipo","texto" );
      ((Element)v.get(138)).setAttribute("ID","EstDat" );
      ((Element)v.get(135)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("tipo","texto" );
      ((Element)v.get(139)).setAttribute("ID","EstDat" );
      ((Element)v.get(135)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(140)).setAttribute("tipo","texto" );
      ((Element)v.get(140)).setAttribute("ID","EstDat" );
      ((Element)v.get(135)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("tipo","texto" );
      ((Element)v.get(141)).setAttribute("ID","EstDat2" );
      ((Element)v.get(135)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("tipo","texto" );
      ((Element)v.get(142)).setAttribute("ID","EstDat" );
      ((Element)v.get(135)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("tipo","texto" );
      ((Element)v.get(143)).setAttribute("ID","EstDat" );
      ((Element)v.get(135)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("tipo","texto" );
      ((Element)v.get(144)).setAttribute("ID","EstDat" );
      ((Element)v.get(135)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:135   */

      /* Empieza nodo:145 / Elemento padre: 96   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(96)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 96   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(146)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(146)).setAttribute("ancho","300" );
      ((Element)v.get(146)).setAttribute("sep","$" );
      ((Element)v.get(146)).setAttribute("x","12" );
      ((Element)v.get(146)).setAttribute("class","botonera" );
      ((Element)v.get(146)).setAttribute("y","170" );
      ((Element)v.get(146)).setAttribute("control","|" );
      ((Element)v.get(146)).setAttribute("conector","" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(146)).setAttribute("rowset","" );
      ((Element)v.get(146)).setAttribute("cargainicial","N" );
      ((Element)v.get(146)).setAttribute("onload","procesarPaginado(mipgndo, msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(96)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(147)).setAttribute("nombre","ret1" );
      ((Element)v.get(147)).setAttribute("x","37" );
      ((Element)v.get(147)).setAttribute("y","282" );
      ((Element)v.get(147)).setAttribute("ID","botonContenido" );
      ((Element)v.get(147)).setAttribute("img","retroceder_on" );
      ((Element)v.get(147)).setAttribute("tipo","0" );
      ((Element)v.get(147)).setAttribute("estado","false" );
      ((Element)v.get(147)).setAttribute("alt","" );
      ((Element)v.get(147)).setAttribute("codigo","" );
      ((Element)v.get(147)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 146   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(148)).setAttribute("nombre","ava1" );
      ((Element)v.get(148)).setAttribute("x","52" );
      ((Element)v.get(148)).setAttribute("y","282" );
      ((Element)v.get(148)).setAttribute("ID","botonContenido" );
      ((Element)v.get(148)).setAttribute("img","avanzar_on" );
      ((Element)v.get(148)).setAttribute("tipo","0" );
      ((Element)v.get(148)).setAttribute("estado","false" );
      ((Element)v.get(148)).setAttribute("alt","" );
      ((Element)v.get(148)).setAttribute("codigo","" );
      ((Element)v.get(148)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(146)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:146   */
      /* Termina nodo:96   */

      /* Empieza nodo:149 / Elemento padre: 95   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(149)).setAttribute("nombre","primera1" );
      ((Element)v.get(149)).setAttribute("x","20" );
      ((Element)v.get(149)).setAttribute("y","282" );
      ((Element)v.get(149)).setAttribute("ID","botonContenido" );
      ((Element)v.get(149)).setAttribute("img","primera_on" );
      ((Element)v.get(149)).setAttribute("tipo","-2" );
      ((Element)v.get(149)).setAttribute("estado","false" );
      ((Element)v.get(149)).setAttribute("alt","" );
      ((Element)v.get(149)).setAttribute("codigo","" );
      ((Element)v.get(149)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(95)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 95   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(150)).setAttribute("nombre","separa" );
      ((Element)v.get(150)).setAttribute("x","59" );
      ((Element)v.get(150)).setAttribute("y","278" );
      ((Element)v.get(150)).setAttribute("ID","botonContenido" );
      ((Element)v.get(150)).setAttribute("img","separa_base" );
      ((Element)v.get(150)).setAttribute("tipo","0" );
      ((Element)v.get(150)).setAttribute("estado","false" );
      ((Element)v.get(150)).setAttribute("alt","" );
      ((Element)v.get(150)).setAttribute("codigo","" );
      ((Element)v.get(150)).setAttribute("accion","" );
      ((Element)v.get(95)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 95   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(151)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(151)).setAttribute("x","75" );
      ((Element)v.get(151)).setAttribute("y","279" );
      ((Element)v.get(151)).setAttribute("ID","botonContenido" );
      ((Element)v.get(151)).setAttribute("tipo","html" );
      ((Element)v.get(151)).setAttribute("estado","false" );
      ((Element)v.get(151)).setAttribute("cod","3" );
      ((Element)v.get(151)).setAttribute("accion","onClickDetalle();" );
      ((Element)v.get(151)).setAttribute("onshtab","focalizaBotonHTML('botonContenido', 'btnBuscar');" );
      ((Element)v.get(151)).setAttribute("ontab","foco('formulario.txtCodigoUsuario');" );
      ((Element)v.get(95)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 95   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(152)).setAttribute("nombre","btnModificar" );
      ((Element)v.get(152)).setAttribute("x","75" );
      ((Element)v.get(152)).setAttribute("y","279" );
      ((Element)v.get(152)).setAttribute("ID","botonContenido" );
      ((Element)v.get(152)).setAttribute("tipo","html" );
      ((Element)v.get(152)).setAttribute("estado","false" );
      ((Element)v.get(152)).setAttribute("cod","2" );
      ((Element)v.get(152)).setAttribute("accion","onClickModificar();" );
      ((Element)v.get(152)).setAttribute("onshtab","focalizaBotonHTML('botonContenido', 'btnBuscar');" );
      ((Element)v.get(152)).setAttribute("ontab","foco('formulario.txtCodigoUsuario');" );
      ((Element)v.get(95)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:95   */
      /* Termina nodo:6   */


   }

}

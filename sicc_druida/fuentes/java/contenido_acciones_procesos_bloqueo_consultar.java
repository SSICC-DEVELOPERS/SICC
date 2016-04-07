
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_acciones_procesos_bloqueo_consultar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_acciones_procesos_bloqueo_consultar" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_acciones_procesos_bloqueo_consultar.js" );
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
      ((Element)v.get(38)).setAttribute("nombre","lblTipoBloqueo" );
      ((Element)v.get(38)).setAttribute("alto","13" );
      ((Element)v.get(38)).setAttribute("filas","1" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(38)).setAttribute("id","datosTitle" );
      ((Element)v.get(38)).setAttribute("cod","3207" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("width","100%" );
      ((Element)v.get(34)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","8" );
      ((Element)v.get(40)).setAttribute("height","8" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:34   */

      /* Empieza nodo:41 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","8" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(45)).setAttribute("nombre","cbTipoBloqueo" );
      ((Element)v.get(45)).setAttribute("id","datosCampos" );
      ((Element)v.get(45)).setAttribute("size","1" );
      ((Element)v.get(45)).setAttribute("multiple","N" );
      ((Element)v.get(45)).setAttribute("req","N" );
      ((Element)v.get(45)).setAttribute("valorinicial","" );
      ((Element)v.get(45)).setAttribute("textoinicial","" );
      ((Element)v.get(45)).setAttribute("onshtab","onShTabComboTipoBloqueo();" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:47 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("width","100%" );
      ((Element)v.get(41)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","8" );
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:41   */
      /* Termina nodo:30   */

      /* Empieza nodo:49 / Elemento padre: 27   */
      v.add(doc.createElement("table"));
      ((Element)v.get(49)).setAttribute("width","98%" );
      ((Element)v.get(49)).setAttribute("border","0" );
      ((Element)v.get(49)).setAttribute("align","center" );
      ((Element)v.get(49)).setAttribute("cellspacing","0" );
      ((Element)v.get(49)).setAttribute("cellpadding","0" );
      ((Element)v.get(27)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("colspan","4" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","8" );
      ((Element)v.get(52)).setAttribute("height","12" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:53 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","8" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(57)).setAttribute("nombre","lblProcesoBloqueo" );
      ((Element)v.get(57)).setAttribute("alto","13" );
      ((Element)v.get(57)).setAttribute("filas","1" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("id","datosTitle" );
      ((Element)v.get(57)).setAttribute("cod","3208" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","25" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(61)).setAttribute("nombre","lblAccionBloqueo" );
      ((Element)v.get(61)).setAttribute("alto","13" );
      ((Element)v.get(61)).setAttribute("filas","1" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(61)).setAttribute("id","datosTitle" );
      ((Element)v.get(61)).setAttribute("cod","3209" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("width","100%" );
      ((Element)v.get(53)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:53   */

      /* Empieza nodo:64 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","8" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(64)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(68)).setAttribute("nombre","cbProcesoBloqueo" );
      ((Element)v.get(68)).setAttribute("id","datosCampos" );
      ((Element)v.get(68)).setAttribute("size","1" );
      ((Element)v.get(68)).setAttribute("multiple","N" );
      ((Element)v.get(68)).setAttribute("req","N" );
      ((Element)v.get(68)).setAttribute("valorinicial","" );
      ((Element)v.get(68)).setAttribute("textoinicial","" );
      ((Element)v.get(68)).setAttribute("onchange","recargarComboAcciones();" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:70 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","25" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(64)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(73)).setAttribute("nombre","cbAccionBloqueo" );
      ((Element)v.get(73)).setAttribute("id","datosCampos" );
      ((Element)v.get(73)).setAttribute("size","1" );
      ((Element)v.get(73)).setAttribute("multiple","N" );
      ((Element)v.get(73)).setAttribute("req","N" );
      ((Element)v.get(73)).setAttribute("valorinicial","" );
      ((Element)v.get(73)).setAttribute("textoinicial","" );
      ((Element)v.get(73)).setAttribute("ontab","focalizaBotonHTML('botonContenido', 'btnBuscar');" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:75 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","100%" );
      ((Element)v.get(64)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:64   */

      /* Empieza nodo:77 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("colspan","4" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","16" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:49   */
      /* Termina nodo:27   */
      /* Termina nodo:26   */
      /* Termina nodo:23   */

      /* Empieza nodo:80 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("table"));
      ((Element)v.get(85)).setAttribute("width","100%" );
      ((Element)v.get(85)).setAttribute("border","0" );
      ((Element)v.get(85)).setAttribute("align","center" );
      ((Element)v.get(85)).setAttribute("cellspacing","0" );
      ((Element)v.get(85)).setAttribute("cellpadding","0" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("width","3" );
      ((Element)v.get(87)).setAttribute("class","botonera" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("class","botonera" );
      ((Element)v.get(86)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(89)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(89)).setAttribute("ID","botonContenido" );
      ((Element)v.get(89)).setAttribute("tipo","html" );
      ((Element)v.get(89)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(89)).setAttribute("cod","1" );
      ((Element)v.get(89)).setAttribute("estado","false" );
      ((Element)v.get(89)).setAttribute("onshtab","foco('formulario.cbAccionBloqueo');" );
      ((Element)v.get(89)).setAttribute("ontab","onTabBuscar();" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:90 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","12" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:80   */
      /* Termina nodo:15   */
      /* Termina nodo:14   */

      /* Empieza nodo:92 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(92)).setAttribute("nombre","capaLista1" );
      ((Element)v.get(92)).setAttribute("ancho","100%" );
      ((Element)v.get(92)).setAttribute("alto","330" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(92)).setAttribute("x","6" );
      ((Element)v.get(92)).setAttribute("y","170" );
      ((Element)v.get(92)).setAttribute("colorf","" );
      ((Element)v.get(92)).setAttribute("borde","0" );
      ((Element)v.get(92)).setAttribute("imagenf","" );
      ((Element)v.get(92)).setAttribute("repeat","" );
      ((Element)v.get(92)).setAttribute("padding","" );
      ((Element)v.get(92)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(92)).setAttribute("contravsb","" );
      ((Element)v.get(92)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(93)).setAttribute("nombre","listado1" );
      ((Element)v.get(93)).setAttribute("ancho","300" );
      ((Element)v.get(93)).setAttribute("alto","301" );
      ((Element)v.get(93)).setAttribute("x","12" );
      ((Element)v.get(93)).setAttribute("y","0" );
      ((Element)v.get(93)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(93)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(93)).setAttribute("pintadoSimplificado","S" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(94)).setAttribute("precarga","S" );
      ((Element)v.get(94)).setAttribute("conROver","S" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(95)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(95)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(95)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(95)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 94   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(96)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(96)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(96)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(96)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(94)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 94   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(97)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(97)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(94)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:94   */

      /* Empieza nodo:98 / Elemento padre: 93   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(93)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(99)).setAttribute("borde","1" );
      ((Element)v.get(99)).setAttribute("horizDatos","1" );
      ((Element)v.get(99)).setAttribute("horizCabecera","1" );
      ((Element)v.get(99)).setAttribute("vertical","1" );
      ((Element)v.get(99)).setAttribute("horizTitulo","1" );
      ((Element)v.get(99)).setAttribute("horizBase","1" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 98   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(100)).setAttribute("borde","#999999" );
      ((Element)v.get(100)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(100)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(100)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(100)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(100)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(100)).setAttribute("horizBase","#999999" );
      ((Element)v.get(98)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:98   */

      /* Empieza nodo:101 / Elemento padre: 93   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(101)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(101)).setAttribute("alto","22" );
      ((Element)v.get(101)).setAttribute("imgFondo","" );
      ((Element)v.get(101)).setAttribute("cod","00135" );
      ((Element)v.get(101)).setAttribute("ID","datosTitle" );
      ((Element)v.get(93)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 93   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(102)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(102)).setAttribute("alto","22" );
      ((Element)v.get(102)).setAttribute("imgFondo","" );
      ((Element)v.get(93)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 93   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(103)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(103)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(103)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(103)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(103)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(103)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(93)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("ancho","0" );
      ((Element)v.get(104)).setAttribute("minimizable","S" );
      ((Element)v.get(104)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).setAttribute("oculta","S" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 103   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("ancho","0" );
      ((Element)v.get(105)).setAttribute("minimizable","S" );
      ((Element)v.get(105)).setAttribute("minimizada","N" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(105)).setAttribute("oculta","S" );
      ((Element)v.get(103)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 103   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("ancho","80" );
      ((Element)v.get(106)).setAttribute("minimizable","S" );
      ((Element)v.get(106)).setAttribute("minimizada","N" );
      ((Element)v.get(103)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 103   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("ancho","0" );
      ((Element)v.get(107)).setAttribute("minimizable","S" );
      ((Element)v.get(107)).setAttribute("minimizada","N" );
      ((Element)v.get(107)).setAttribute("oculta","S" );
      ((Element)v.get(103)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 103   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("ancho","80" );
      ((Element)v.get(108)).setAttribute("minimizable","S" );
      ((Element)v.get(108)).setAttribute("minimizada","N" );
      ((Element)v.get(103)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 103   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("ancho","0" );
      ((Element)v.get(109)).setAttribute("minimizable","S" );
      ((Element)v.get(109)).setAttribute("minimizada","N" );
      ((Element)v.get(109)).setAttribute("oculta","S" );
      ((Element)v.get(103)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 103   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("ancho","80" );
      ((Element)v.get(110)).setAttribute("minimizable","S" );
      ((Element)v.get(110)).setAttribute("minimizada","N" );
      ((Element)v.get(103)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 103   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("ancho","0" );
      ((Element)v.get(111)).setAttribute("minimizable","S" );
      ((Element)v.get(111)).setAttribute("minimizada","N" );
      ((Element)v.get(111)).setAttribute("oculta","S" );
      ((Element)v.get(103)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:103   */

      /* Empieza nodo:112 / Elemento padre: 93   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(112)).setAttribute("alto","25" );
      ((Element)v.get(112)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(112)).setAttribute("imgFondo","" );
      ((Element)v.get(112)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(93)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("colFondo","" );
      ((Element)v.get(113)).setAttribute("ID","EstCab" );
      ((Element)v.get(113)).setAttribute("cod","" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Elemento padre:113 / Elemento actual: 114   */
      v.add(doc.createTextNode("OID_ACCI_PROC_BLOQ"));
      ((Element)v.get(113)).appendChild((Text)v.get(114));

      /* Termina nodo Texto:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("colFondo","" );
      ((Element)v.get(115)).setAttribute("ID","EstCab" );
      ((Element)v.get(115)).setAttribute("cod","" );
      ((Element)v.get(112)).appendChild((Element)v.get(115));

      /* Elemento padre:115 / Elemento actual: 116   */
      v.add(doc.createTextNode("OID_TIPO_BLOQ"));
      ((Element)v.get(115)).appendChild((Text)v.get(116));

      /* Termina nodo Texto:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("colFondo","" );
      ((Element)v.get(117)).setAttribute("ID","EstCab" );
      ((Element)v.get(117)).setAttribute("cod","3207" );
      ((Element)v.get(112)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("colFondo","" );
      ((Element)v.get(118)).setAttribute("ID","EstCab" );
      ((Element)v.get(118)).setAttribute("cod","" );
      ((Element)v.get(112)).appendChild((Element)v.get(118));

      /* Elemento padre:118 / Elemento actual: 119   */
      v.add(doc.createTextNode("OID_PROC_BLOQ"));
      ((Element)v.get(118)).appendChild((Text)v.get(119));

      /* Termina nodo Texto:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("colFondo","" );
      ((Element)v.get(120)).setAttribute("ID","EstCab" );
      ((Element)v.get(120)).setAttribute("cod","3208" );
      ((Element)v.get(112)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("colFondo","" );
      ((Element)v.get(121)).setAttribute("ID","EstCab" );
      ((Element)v.get(121)).setAttribute("cod","" );
      ((Element)v.get(112)).appendChild((Element)v.get(121));

      /* Elemento padre:121 / Elemento actual: 122   */
      v.add(doc.createTextNode("OID_ACCI_BLOQ"));
      ((Element)v.get(121)).appendChild((Text)v.get(122));

      /* Termina nodo Texto:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("colFondo","" );
      ((Element)v.get(123)).setAttribute("ID","EstCab" );
      ((Element)v.get(123)).setAttribute("cod","3209" );
      ((Element)v.get(112)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("colFondo","" );
      ((Element)v.get(124)).setAttribute("ID","EstCab" );
      ((Element)v.get(124)).setAttribute("cod","" );
      ((Element)v.get(112)).appendChild((Element)v.get(124));

      /* Elemento padre:124 / Elemento actual: 125   */
      v.add(doc.createTextNode("indUltimaPagina"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(124)).appendChild((Text)v.get(125));

      /* Termina nodo Texto:125   */
      /* Termina nodo:124   */
      /* Termina nodo:112   */

      /* Empieza nodo:126 / Elemento padre: 93   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(126)).setAttribute("alto","22" );
      ((Element)v.get(126)).setAttribute("accion","" );
      ((Element)v.get(126)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(126)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(126)).setAttribute("maxSel","-1" );
      ((Element)v.get(126)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(126)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(126)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(126)).setAttribute("onLoad","" );
      ((Element)v.get(126)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(93)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("tipo","texto" );
      ((Element)v.get(127)).setAttribute("ID","EstDat" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 126   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("tipo","texto" );
      ((Element)v.get(128)).setAttribute("ID","EstDat" );
      ((Element)v.get(126)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 126   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("tipo","texto" );
      ((Element)v.get(129)).setAttribute("ID","EstDat" );
      ((Element)v.get(126)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 126   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("tipo","texto" );
      ((Element)v.get(130)).setAttribute("ID","EstDat" );
      ((Element)v.get(126)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 126   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("tipo","texto" );
      ((Element)v.get(131)).setAttribute("ID","EstDat2" );
      ((Element)v.get(126)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 126   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("tipo","texto" );
      ((Element)v.get(132)).setAttribute("ID","EstDat" );
      ((Element)v.get(126)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 126   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("tipo","texto" );
      ((Element)v.get(133)).setAttribute("ID","EstDat" );
      ((Element)v.get(126)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 126   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("tipo","texto" );
      ((Element)v.get(134)).setAttribute("ID","EstDat" );
      ((Element)v.get(126)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:126   */

      /* Empieza nodo:135 / Elemento padre: 93   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(93)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 93   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(136)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(136)).setAttribute("ancho","300" );
      ((Element)v.get(136)).setAttribute("sep","$" );
      ((Element)v.get(136)).setAttribute("x","12" );
      ((Element)v.get(136)).setAttribute("class","botonera" );
      ((Element)v.get(136)).setAttribute("y","170" );
      ((Element)v.get(136)).setAttribute("control","|" );
      ((Element)v.get(136)).setAttribute("conector","" );
      ((Element)v.get(136)).setAttribute("rowset","" );
      ((Element)v.get(136)).setAttribute("cargainicial","N" );
      ((Element)v.get(136)).setAttribute("onload","procesarPaginado(mipgndo, msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(93)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(137)).setAttribute("nombre","ret1" );
      ((Element)v.get(137)).setAttribute("x","37" );
      ((Element)v.get(137)).setAttribute("y","282" );
      ((Element)v.get(137)).setAttribute("ID","botonContenido" );
      ((Element)v.get(137)).setAttribute("img","retroceder_on" );
      ((Element)v.get(137)).setAttribute("tipo","0" );
      ((Element)v.get(137)).setAttribute("estado","false" );
      ((Element)v.get(137)).setAttribute("alt","" );
      ((Element)v.get(137)).setAttribute("codigo","" );
      ((Element)v.get(137)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 136   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(138)).setAttribute("nombre","ava1" );
      ((Element)v.get(138)).setAttribute("x","52" );
      ((Element)v.get(138)).setAttribute("y","282" );
      ((Element)v.get(138)).setAttribute("ID","botonContenido" );
      ((Element)v.get(138)).setAttribute("img","avanzar_on" );
      ((Element)v.get(138)).setAttribute("tipo","0" );
      ((Element)v.get(138)).setAttribute("estado","false" );
      ((Element)v.get(138)).setAttribute("alt","" );
      ((Element)v.get(138)).setAttribute("codigo","" );
      ((Element)v.get(138)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(136)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:136   */
      /* Termina nodo:93   */

      /* Empieza nodo:139 / Elemento padre: 92   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(139)).setAttribute("nombre","primera1" );
      ((Element)v.get(139)).setAttribute("x","20" );
      ((Element)v.get(139)).setAttribute("y","282" );
      ((Element)v.get(139)).setAttribute("ID","botonContenido" );
      ((Element)v.get(139)).setAttribute("img","primera_on" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(139)).setAttribute("tipo","-2" );
      ((Element)v.get(139)).setAttribute("estado","false" );
      ((Element)v.get(139)).setAttribute("alt","" );
      ((Element)v.get(139)).setAttribute("codigo","" );
      ((Element)v.get(139)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(92)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 92   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(140)).setAttribute("nombre","separa" );
      ((Element)v.get(140)).setAttribute("x","59" );
      ((Element)v.get(140)).setAttribute("y","278" );
      ((Element)v.get(140)).setAttribute("ID","botonContenido" );
      ((Element)v.get(140)).setAttribute("img","separa_base" );
      ((Element)v.get(140)).setAttribute("tipo","0" );
      ((Element)v.get(140)).setAttribute("estado","false" );
      ((Element)v.get(140)).setAttribute("alt","" );
      ((Element)v.get(140)).setAttribute("codigo","" );
      ((Element)v.get(140)).setAttribute("accion","" );
      ((Element)v.get(92)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 92   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(141)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(141)).setAttribute("x","75" );
      ((Element)v.get(141)).setAttribute("y","279" );
      ((Element)v.get(141)).setAttribute("ID","botonContenido" );
      ((Element)v.get(141)).setAttribute("tipo","html" );
      ((Element)v.get(141)).setAttribute("estado","false" );
      ((Element)v.get(141)).setAttribute("cod","3" );
      ((Element)v.get(141)).setAttribute("accion","onClickDetalle();" );
      ((Element)v.get(141)).setAttribute("onshtab","focalizaBotonHTML('botonContenido', 'btnBuscar');" );
      ((Element)v.get(141)).setAttribute("ontab","foco('formulario.cbTipoBloqueo');" );
      ((Element)v.get(92)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:92   */
      /* Termina nodo:6   */


   }

}

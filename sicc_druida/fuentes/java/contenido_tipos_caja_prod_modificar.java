
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_tipos_caja_prod_modificar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         

      getXML540(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_tipos_caja_prod_modificar" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_tipos_caja_prod_modificar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","formulario" );
      ((Element)v.get(7)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","accion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","oidPais" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(15)).setAttribute("nombre","capa1" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("table"));
      ((Element)v.get(16)).setAttribute("width","100%" );
      ((Element)v.get(16)).setAttribute("border","0" );
      ((Element)v.get(16)).setAttribute("cellspacing","0" );
      ((Element)v.get(16)).setAttribute("cellpadding","0" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("td"));
      ((Element)v.get(18)).setAttribute("width","12" );
      ((Element)v.get(18)).setAttribute("align","center" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(19)).setAttribute("src","b.gif" );
      ((Element)v.get(19)).setAttribute("width","12" );
      ((Element)v.get(19)).setAttribute("height","12" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */
      /* Termina nodo:18   */

      /* Empieza nodo:20 / Elemento padre: 17   */
      v.add(doc.createElement("td"));
      ((Element)v.get(20)).setAttribute("width","750" );
      ((Element)v.get(17)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(21)).setAttribute("src","b.gif" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:22 / Elemento padre: 17   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(17)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(23)).setAttribute("height","1" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */
      /* Termina nodo:17   */

      /* Empieza nodo:24 / Elemento padre: 16   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(16)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(29)).setAttribute("class","legend" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(30)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(30)).setAttribute("alto","13" );
      ((Element)v.get(30)).setAttribute("filas","1" );
      ((Element)v.get(30)).setAttribute("cod","0075" );
      ((Element)v.get(30)).setAttribute("id","legend" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 28   */
      v.add(doc.createElement("table"));
      ((Element)v.get(31)).setAttribute("width","95%" );
      ((Element)v.get(31)).setAttribute("border","0" );
      ((Element)v.get(31)).setAttribute("align","center" );
      ((Element)v.get(31)).setAttribute("cellspacing","0" );
      ((Element)v.get(31)).setAttribute("cellpadding","0" );
      ((Element)v.get(28)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).setAttribute("colspan","4" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(34)).setAttribute("src","b.gif" );
      ((Element)v.get(34)).setAttribute("width","8" );
      ((Element)v.get(34)).setAttribute("height","8" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:35 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).setAttribute("width","8" );
      ((Element)v.get(37)).setAttribute("height","8" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(39)).setAttribute("nombre","lblCodigoCaja" );
      ((Element)v.get(39)).setAttribute("alto","13" );
      ((Element)v.get(39)).setAttribute("filas","1" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(39)).setAttribute("id","datosTitle" );
      ((Element)v.get(39)).setAttribute("cod","3106" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","25" );
      ((Element)v.get(41)).setAttribute("height","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(43)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(43)).setAttribute("alto","13" );
      ((Element)v.get(43)).setAttribute("filas","1" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(43)).setAttribute("id","datosTitle" );
      ((Element)v.get(43)).setAttribute("cod","3107" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("width","100%" );
      ((Element)v.get(35)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","8" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:35   */

      /* Empieza nodo:46 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","8" );
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(46)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(50)).setAttribute("nombre","txtCodigoCaja" );
      ((Element)v.get(50)).setAttribute("id","datosCampos" );
      ((Element)v.get(50)).setAttribute("max","2" );
      ((Element)v.get(50)).setAttribute("tipo","" );
      ((Element)v.get(50)).setAttribute("req","N" );
      ((Element)v.get(50)).setAttribute("size","4" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(50)).setAttribute("validacion","" );
      ((Element)v.get(50)).setAttribute("onshtab","onShtabCodigoCaja();" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","48" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(46)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(54)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(54)).setAttribute("id","datosCampos" );
      ((Element)v.get(54)).setAttribute("max","40" );
      ((Element)v.get(54)).setAttribute("tipo","" );
      ((Element)v.get(54)).setAttribute("req","N" );
      ((Element)v.get(54)).setAttribute("size","50" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(54)).setAttribute("validacion","" );
      ((Element)v.get(54)).setAttribute("ontab","focalizaBotonHTML('botonContenido', 'btnBuscar');" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(46)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:46   */

      /* Empieza nodo:57 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("colspan","4" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","25" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:31   */

      /* Empieza nodo:60 / Elemento padre: 28   */
      v.add(doc.createElement("table"));
      ((Element)v.get(60)).setAttribute("height","20" );
      ((Element)v.get(28)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("colspan","4" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:28   */
      /* Termina nodo:27   */
      /* Termina nodo:24   */

      /* Empieza nodo:64 / Elemento padre: 16   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(16)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("table"));
      ((Element)v.get(69)).setAttribute("width","100%" );
      ((Element)v.get(69)).setAttribute("border","0" );
      ((Element)v.get(69)).setAttribute("align","center" );
      ((Element)v.get(69)).setAttribute("cellspacing","0" );
      ((Element)v.get(69)).setAttribute("cellpadding","0" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("width","3" );
      ((Element)v.get(71)).setAttribute("class","botonera" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("class","botonera" );
      ((Element)v.get(70)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(73)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(73)).setAttribute("ID","botonContenido" );
      ((Element)v.get(73)).setAttribute("tipo","html" );
      ((Element)v.get(73)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(73)).setAttribute("cod","1" );
      ((Element)v.get(73)).setAttribute("estado","false" );
      ((Element)v.get(73)).setAttribute("onshtab","focaliza('formulario.txtDescripcion');" );
      ((Element)v.get(73)).setAttribute("ontab","onTabBuscar();" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:74 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","8" );
      ((Element)v.get(75)).setAttribute("height","12" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:64   */

      /* Empieza nodo:76 / Elemento padre: 16   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(16)).appendChild((Element)v.get(76));

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
      /* Termina nodo:16   */
      /* Termina nodo:15   */

      /* Empieza nodo:83 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(83)).setAttribute("nombre","capaLista1" );
      ((Element)v.get(83)).setAttribute("ancho","100%" );
      ((Element)v.get(83)).setAttribute("alto","330" );
      ((Element)v.get(83)).setAttribute("x","7" );
      ((Element)v.get(83)).setAttribute("y","130" );
      ((Element)v.get(83)).setAttribute("colorf","" );
      ((Element)v.get(83)).setAttribute("borde","0" );
      ((Element)v.get(83)).setAttribute("imagenf","" );
      ((Element)v.get(83)).setAttribute("repeat","" );
      ((Element)v.get(83)).setAttribute("padding","" );
      ((Element)v.get(83)).setAttribute("visibilidad","" );
      ((Element)v.get(83)).setAttribute("contravsb","" );
      ((Element)v.get(83)).setAttribute("zindex","" );
      ((Element)v.get(7)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(84)).setAttribute("nombre","listado1" );
      ((Element)v.get(84)).setAttribute("ancho","369" );
      ((Element)v.get(84)).setAttribute("alto","301" );
      ((Element)v.get(84)).setAttribute("x","12" );
      ((Element)v.get(84)).setAttribute("y","0" );
      ((Element)v.get(84)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(84)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(84)).setAttribute("pintadoSimplificado","S" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(85)).setAttribute("precarga","S" );
      ((Element)v.get(85)).setAttribute("conROver","S" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(86)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(86)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(86)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(86)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 85   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(87)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(87)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(87)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(87)).setAttribute("aximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(85)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 85   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(88)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(88)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(85)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:85   */

      /* Empieza nodo:89 / Elemento padre: 84   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(84)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(90)).setAttribute("borde","1" );
      ((Element)v.get(90)).setAttribute("horizDatos","1" );
      ((Element)v.get(90)).setAttribute("horizCabecera","1" );
      ((Element)v.get(90)).setAttribute("vertical","1" );
      ((Element)v.get(90)).setAttribute("horizTitulo","1" );
      ((Element)v.get(90)).setAttribute("horizBase","1" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 89   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(91)).setAttribute("borde","#999999" );
      ((Element)v.get(91)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(91)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(91)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(91)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(91)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(91)).setAttribute("horizBase","#999999" );
      ((Element)v.get(89)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:89   */

      /* Empieza nodo:92 / Elemento padre: 84   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(92)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(92)).setAttribute("alto","22" );
      ((Element)v.get(92)).setAttribute("imgFondo","" );
      ((Element)v.get(92)).setAttribute("cod","00135" );
      ((Element)v.get(92)).setAttribute("ID","datosTitle" );
      ((Element)v.get(84)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 84   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(93)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(93)).setAttribute("alto","22" );
      ((Element)v.get(93)).setAttribute("imgFondo","" );
      ((Element)v.get(84)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 84   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(94)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(94)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(94)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(94)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(94)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(94)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(84)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("ancho","20" );
      ((Element)v.get(95)).setAttribute("minimizable","S" );
      ((Element)v.get(95)).setAttribute("minimizada","N" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 94   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(96)).setAttribute("ancho","80" );
      ((Element)v.get(96)).setAttribute("minimizable","S" );
      ((Element)v.get(96)).setAttribute("minimizada","N" );
      ((Element)v.get(94)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 94   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("ancho","0" );
      ((Element)v.get(97)).setAttribute("minimizable","S" );
      ((Element)v.get(97)).setAttribute("minimizada","N" );
      ((Element)v.get(97)).setAttribute("oculta","S" );
      ((Element)v.get(94)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:94   */

      /* Empieza nodo:98 / Elemento padre: 84   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(98)).setAttribute("alto","25" );
      ((Element)v.get(98)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(98)).setAttribute("imgFondo","" );
      ((Element)v.get(98)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(84)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("colFondo","" );
      ((Element)v.get(99)).setAttribute("ID","EstCab" );
      ((Element)v.get(99)).setAttribute("cod","3106" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(100)).setAttribute("colFondo","" );
      ((Element)v.get(100)).setAttribute("ID","EstCab" );
      ((Element)v.get(100)).setAttribute("cod","3107" );
      ((Element)v.get(98)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("colFondo","" );
      ((Element)v.get(101)).setAttribute("ID","EstCab" );
      ((Element)v.get(101)).setAttribute("cod","" );
      ((Element)v.get(98)).appendChild((Element)v.get(101));

      /* Elemento padre:101 / Elemento actual: 102   */
      v.add(doc.createTextNode("indUltimaPagina"));
      ((Element)v.get(101)).appendChild((Text)v.get(102));

      /* Termina nodo Texto:102   */
      /* Termina nodo:101   */
      /* Termina nodo:98   */

      /* Empieza nodo:103 / Elemento padre: 84   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(103)).setAttribute("alto","22" );
      ((Element)v.get(103)).setAttribute("accion","" );
      ((Element)v.get(103)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(103)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(103)).setAttribute("maxSel","-1" );
      ((Element)v.get(103)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(103)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(103)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(103)).setAttribute("onLoad","" );
      ((Element)v.get(103)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(84)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("tipo","texto" );
      ((Element)v.get(104)).setAttribute("ID","EstDat" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 103   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("tipo","texto" );
      ((Element)v.get(105)).setAttribute("ID","EstDat2" );
      ((Element)v.get(103)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 103   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("tipo","texto" );
      ((Element)v.get(106)).setAttribute("ID","EstDat" );
      ((Element)v.get(103)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:103   */

      /* Empieza nodo:107 / Elemento padre: 84   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(84)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 84   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(108)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(108)).setAttribute("ancho","679" );
      ((Element)v.get(108)).setAttribute("sep","$" );
      ((Element)v.get(108)).setAttribute("x","12" );
      ((Element)v.get(108)).setAttribute("class","botonera" );
      ((Element)v.get(108)).setAttribute("y","1294" );
      ((Element)v.get(108)).setAttribute("control","|" );
      ((Element)v.get(108)).setAttribute("conector","" );
      ((Element)v.get(108)).setAttribute("rowset","" );
      ((Element)v.get(108)).setAttribute("cargainicial","N" );
      ((Element)v.get(108)).setAttribute("onload","procesarPaginado(mipgndo, msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(84)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(109)).setAttribute("nombre","ret1" );
      ((Element)v.get(109)).setAttribute("x","37" );
      ((Element)v.get(109)).setAttribute("y","282" );
      ((Element)v.get(109)).setAttribute("ID","botonContenido" );
      ((Element)v.get(109)).setAttribute("img","retroceder_on" );
      ((Element)v.get(109)).setAttribute("tipo","0" );
      ((Element)v.get(109)).setAttribute("estado","false" );
      ((Element)v.get(109)).setAttribute("alt","" );
      ((Element)v.get(109)).setAttribute("codigo","" );
      ((Element)v.get(109)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 108   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(110)).setAttribute("nombre","ava1" );
      ((Element)v.get(110)).setAttribute("x","52" );
      ((Element)v.get(110)).setAttribute("y","282" );
      ((Element)v.get(110)).setAttribute("ID","botonContenido" );
      ((Element)v.get(110)).setAttribute("img","avanzar_on" );
      ((Element)v.get(110)).setAttribute("tipo","0" );
      ((Element)v.get(110)).setAttribute("estado","false" );
      ((Element)v.get(110)).setAttribute("alt","" );
      ((Element)v.get(110)).setAttribute("codigo","" );
      ((Element)v.get(110)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(108)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:108   */
      /* Termina nodo:84   */

      /* Empieza nodo:111 / Elemento padre: 83   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(111)).setAttribute("nombre","primera1" );
      ((Element)v.get(111)).setAttribute("x","20" );
      ((Element)v.get(111)).setAttribute("y","282" );
      ((Element)v.get(111)).setAttribute("ID","botonContenido" );
      ((Element)v.get(111)).setAttribute("img","primera_on" );
      ((Element)v.get(111)).setAttribute("tipo","-2" );
      ((Element)v.get(111)).setAttribute("estado","false" );
      ((Element)v.get(111)).setAttribute("alt","" );
      ((Element)v.get(111)).setAttribute("codigo","" );
      ((Element)v.get(111)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(83)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 83   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(112)).setAttribute("nombre","separa" );
      ((Element)v.get(112)).setAttribute("x","59" );
      ((Element)v.get(112)).setAttribute("y","278" );
      ((Element)v.get(112)).setAttribute("ID","botonContenido" );
      ((Element)v.get(112)).setAttribute("img","separa_base" );
      ((Element)v.get(112)).setAttribute("tipo","0" );
      ((Element)v.get(112)).setAttribute("estado","false" );
      ((Element)v.get(112)).setAttribute("alt","" );
      ((Element)v.get(112)).setAttribute("codigo","" );
      ((Element)v.get(112)).setAttribute("accion","" );
      ((Element)v.get(83)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 83   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(113)).setAttribute("nombre","btnModificar" );
      ((Element)v.get(113)).setAttribute("x","75" );
      ((Element)v.get(113)).setAttribute("y","279" );
      ((Element)v.get(113)).setAttribute("ID","botonContenido" );
      ((Element)v.get(113)).setAttribute("tipo","html" );
      ((Element)v.get(113)).setAttribute("estado","false" );
      ((Element)v.get(113)).setAttribute("cod","2" );
      ((Element)v.get(113)).setAttribute("accion","onClickModificar();" );
      ((Element)v.get(113)).setAttribute("onshtab","focalizaBotonHTML('botonContenido', 'btnBuscar');" );
      ((Element)v.get(113)).setAttribute("ontab","focaliza('formulario.txtCodigoCaja');" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(83)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 83   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(114)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(114)).setAttribute("x","75" );
      ((Element)v.get(114)).setAttribute("y","279" );
      ((Element)v.get(114)).setAttribute("ID","botonContenido" );
      ((Element)v.get(114)).setAttribute("tipo","html" );
      ((Element)v.get(114)).setAttribute("estado","false" );
      ((Element)v.get(114)).setAttribute("cod","3" );
      ((Element)v.get(114)).setAttribute("accion","onClickDetalle();" );
      ((Element)v.get(114)).setAttribute("onshtab","focalizaBotonHTML('botonContenido', 'btnBuscar');" );
      ((Element)v.get(114)).setAttribute("ontab","focaliza('formulario.txtCodigoCaja');" );
      ((Element)v.get(83)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:83   */
      /* Termina nodo:7   */


   }

}

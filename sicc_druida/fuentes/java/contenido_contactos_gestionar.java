
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_contactos_gestionar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_contactos_gestionar" );
      ((Element)v.get(0)).setAttribute("cod","0561" );
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
      ((Element)v.get(4)).setAttribute("src","ccc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","contenido_contactos_gestionar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbPeriodo" );
      ((Element)v.get(7)).setAttribute("required","false" );
      ((Element)v.get(7)).setAttribute("cod","276" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("STYLE"));
      ((Element)v.get(8)).setAttribute("TYPE","text/css" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Elemento padre:8 / Elemento actual: 9   */
      v.add(doc.createTextNode("\r   \r\r#capaLista1{visibility:hidden;}\r#capaLista2{visibility:hidden;}\r\r   \r"));
      ((Element)v.get(8)).appendChild((Text)v.get(9));

      /* Termina nodo Texto:9   */
      /* Termina nodo:8   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(10)).setAttribute("nombre","formulario" );
      ((Element)v.get(10)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","accion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","idioma" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","pais" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","cadena" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","codCliente" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","oidTipoCliente" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("nombre","oidPeriodo" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","oidMarca" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","oidCanal" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","oidZona" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","oidContacto" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","indConsultoraInterna" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","oidSubTipoCliente" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(30)).setAttribute("nombre","capa1" );
      ((Element)v.get(10)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("table"));
      ((Element)v.get(31)).setAttribute("width","100%" );
      ((Element)v.get(31)).setAttribute("border","0" );
      ((Element)v.get(31)).setAttribute("cellspacing","0" );
      ((Element)v.get(31)).setAttribute("cellpadding","0" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).setAttribute("width","12" );
      ((Element)v.get(33)).setAttribute("align","center" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(34)).setAttribute("src","b.gif" );
      ((Element)v.get(34)).setAttribute("width","12" );
      ((Element)v.get(34)).setAttribute("height","12" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("width","750" );
      ((Element)v.get(32)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("width","12" );
      ((Element)v.get(32)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).setAttribute("width","12" );
      ((Element)v.get(38)).setAttribute("height","1" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:32   */

      /* Empieza nodo:39 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(44)).setAttribute("class","legend" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(45)).setAttribute("nombre","lblDatosContacto" );
      ((Element)v.get(45)).setAttribute("alto","13" );
      ((Element)v.get(45)).setAttribute("filas","1" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(45)).setAttribute("id","legend" );
      ((Element)v.get(45)).setAttribute("cod","00424" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("table"));
      ((Element)v.get(46)).setAttribute("width","100%" );
      ((Element)v.get(46)).setAttribute("border","0" );
      ((Element)v.get(46)).setAttribute("align","center" );
      ((Element)v.get(46)).setAttribute("cellspacing","0" );
      ((Element)v.get(46)).setAttribute("cellpadding","0" );
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(49)).setAttribute("width","400" );
      ((Element)v.get(49)).setAttribute("border","0" );
      ((Element)v.get(49)).setAttribute("align","left" );
      ((Element)v.get(49)).setAttribute("cellspacing","0" );
      ((Element)v.get(49)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

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
      ((Element)v.get(52)).setAttribute("height","8" );
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
      ((Element)v.get(57)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(57)).setAttribute("alto","13" );
      ((Element)v.get(57)).setAttribute("filas","1" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("id","datosTitle" );
      ((Element)v.get(57)).setAttribute("cod","276" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("width","100%" );
      ((Element)v.get(53)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:53   */

      /* Empieza nodo:60 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","8" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(60)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(64)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(64)).setAttribute("id","datosCampos" );
      ((Element)v.get(64)).setAttribute("size","1" );
      ((Element)v.get(64)).setAttribute("multiple","N" );
      ((Element)v.get(64)).setAttribute("req","N" );
      ((Element)v.get(64)).setAttribute("valorinicial","" );
      ((Element)v.get(64)).setAttribute("textoinicial","" );
      ((Element)v.get(64)).setAttribute("onshtab","shtabPeriodo();" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:66 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","100%" );
      ((Element)v.get(60)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:60   */

      /* Empieza nodo:68 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("colspan","4" );
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
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:71 / Elemento padre: 39   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:39   */

      /* Empieza nodo:73 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("table"));
      ((Element)v.get(78)).setAttribute("width","100%" );
      ((Element)v.get(78)).setAttribute("border","0" );
      ((Element)v.get(78)).setAttribute("align","center" );
      ((Element)v.get(78)).setAttribute("cellspacing","0" );
      ((Element)v.get(78)).setAttribute("cellpadding","0" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("class","botonera" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(81)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(81)).setAttribute("ID","botonContenido" );
      ((Element)v.get(81)).setAttribute("tipo","html" );
      ((Element)v.get(81)).setAttribute("accion","onClickAceptar();" );
      ((Element)v.get(81)).setAttribute("ontab","tabAceptar();" );
      ((Element)v.get(81)).setAttribute("estado","false" );
      ((Element)v.get(81)).setAttribute("cod","12" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:82 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","8" );
      ((Element)v.get(83)).setAttribute("height","12" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:73   */

      /* Empieza nodo:84 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("width","12" );
      ((Element)v.get(85)).setAttribute("align","center" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","12" );
      ((Element)v.get(86)).setAttribute("height","12" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("width","750" );
      ((Element)v.get(84)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("width","12" );
      ((Element)v.get(84)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","12" );
      ((Element)v.get(90)).setAttribute("height","1" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:84   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:91 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(91)).setAttribute("nombre","capaLista1" );
      ((Element)v.get(91)).setAttribute("alto","317" );
      ((Element)v.get(91)).setAttribute("ancho","100%" );
      ((Element)v.get(91)).setAttribute("colorf","" );
      ((Element)v.get(91)).setAttribute("borde","0" );
      ((Element)v.get(91)).setAttribute("imagenf","" );
      ((Element)v.get(91)).setAttribute("repeat","" );
      ((Element)v.get(91)).setAttribute("padding","" );
      ((Element)v.get(91)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(91)).setAttribute("contravsb","" );
      ((Element)v.get(91)).setAttribute("x","0" );
      ((Element)v.get(91)).setAttribute("y","450" );
      ((Element)v.get(91)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(92)).setAttribute("nombre","listado1" );
      ((Element)v.get(92)).setAttribute("ancho","404" );
      ((Element)v.get(92)).setAttribute("alto","317" );
      ((Element)v.get(92)).setAttribute("x","12" );
      ((Element)v.get(92)).setAttribute("y","0" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(92)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(92)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(93)).setAttribute("precarga","S" );
      ((Element)v.get(93)).setAttribute("conROver","S" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(94)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(94)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(94)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(94)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 93   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(95)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(95)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(95)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(95)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(93)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 93   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(96)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(96)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(93)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:93   */

      /* Empieza nodo:97 / Elemento padre: 92   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(92)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(98)).setAttribute("borde","1" );
      ((Element)v.get(98)).setAttribute("horizDatos","1" );
      ((Element)v.get(98)).setAttribute("horizCabecera","1" );
      ((Element)v.get(98)).setAttribute("vertical","0" );
      ((Element)v.get(98)).setAttribute("horizTitulo","1" );
      ((Element)v.get(98)).setAttribute("horizBase","1" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 97   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(99)).setAttribute("borde","#999999" );
      ((Element)v.get(99)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(99)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(99)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(99)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(99)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(99)).setAttribute("horizBase","#999999" );
      ((Element)v.get(97)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:97   */

      /* Empieza nodo:100 / Elemento padre: 92   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(100)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(100)).setAttribute("alto","22" );
      ((Element)v.get(100)).setAttribute("imgFondo","" );
      ((Element)v.get(100)).setAttribute("cod","00411" );
      ((Element)v.get(100)).setAttribute("ID","datosTitle" );
      ((Element)v.get(92)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 92   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(101)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(101)).setAttribute("alto","22" );
      ((Element)v.get(101)).setAttribute("imgFondo","" );
      ((Element)v.get(92)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 92   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(102)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(102)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(102)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(102)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(102)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(102)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(92)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("ancho","100" );
      ((Element)v.get(103)).setAttribute("minimizable","S" );
      ((Element)v.get(103)).setAttribute("minimizada","N" );
      ((Element)v.get(103)).setAttribute("oculta","S" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("ancho","100" );
      ((Element)v.get(104)).setAttribute("minimizable","S" );
      ((Element)v.get(104)).setAttribute("minimizada","N" );
      ((Element)v.get(102)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("ancho","130" );
      ((Element)v.get(105)).setAttribute("minimizable","S" );
      ((Element)v.get(105)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(102)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("ancho","130" );
      ((Element)v.get(106)).setAttribute("minimizable","S" );
      ((Element)v.get(106)).setAttribute("minimizada","N" );
      ((Element)v.get(102)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("ancho","150" );
      ((Element)v.get(107)).setAttribute("minimizable","S" );
      ((Element)v.get(107)).setAttribute("minimizada","N" );
      ((Element)v.get(102)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(108)).setAttribute("ancho","100" );
      ((Element)v.get(108)).setAttribute("minimizable","S" );
      ((Element)v.get(108)).setAttribute("minimizada","N" );
      ((Element)v.get(108)).setAttribute("orden","numerico" );
      ((Element)v.get(102)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("ancho","100" );
      ((Element)v.get(109)).setAttribute("minimizable","S" );
      ((Element)v.get(109)).setAttribute("minimizada","N" );
      ((Element)v.get(102)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("ancho","100" );
      ((Element)v.get(110)).setAttribute("minimizable","S" );
      ((Element)v.get(110)).setAttribute("minimizada","N" );
      ((Element)v.get(110)).setAttribute("orden","numerico" );
      ((Element)v.get(102)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:102   */

      /* Empieza nodo:111 / Elemento padre: 92   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(111)).setAttribute("alto","20" );
      ((Element)v.get(111)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(111)).setAttribute("imgFondo","" );
      ((Element)v.get(111)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(92)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("colFondo","" );
      ((Element)v.get(112)).setAttribute("ID","EstCab" );
      ((Element)v.get(112)).setAttribute("align","center" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Elemento padre:112 / Elemento actual: 113   */
      v.add(doc.createTextNode("oidContacto"));
      ((Element)v.get(112)).appendChild((Text)v.get(113));

      /* Termina nodo Texto:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("colFondo","" );
      ((Element)v.get(114)).setAttribute("ID","EstCab" );
      ((Element)v.get(114)).setAttribute("align","center" );
      ((Element)v.get(114)).setAttribute("cod","2002" );
      ((Element)v.get(111)).appendChild((Element)v.get(114));

      /* Elemento padre:114 / Elemento actual: 115   */
      v.add(doc.createTextNode("C�d. operador"));
      ((Element)v.get(114)).appendChild((Text)v.get(115));

      /* Termina nodo Texto:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("colFondo","" );
      ((Element)v.get(116)).setAttribute("ID","EstCab" );
      ((Element)v.get(116)).setAttribute("cod","387" );
      ((Element)v.get(111)).appendChild((Element)v.get(116));

      /* Elemento padre:116 / Elemento actual: 117   */
      v.add(doc.createTextNode("Descripci�n motivo"));
      ((Element)v.get(116)).appendChild((Text)v.get(117));

      /* Termina nodo Texto:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("colFondo","" );
      ((Element)v.get(118)).setAttribute("ID","EstCab" );
      ((Element)v.get(118)).setAttribute("cod","1293" );
      ((Element)v.get(111)).appendChild((Element)v.get(118));

      /* Elemento padre:118 / Elemento actual: 119   */
      v.add(doc.createTextNode("Descripci�n estado"));
      ((Element)v.get(118)).appendChild((Text)v.get(119));

      /* Termina nodo Texto:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("colFondo","" );
      ((Element)v.get(120)).setAttribute("ID","EstCab" );
      ((Element)v.get(120)).setAttribute("cod","2047" );
      ((Element)v.get(111)).appendChild((Element)v.get(120));

      /* Elemento padre:120 / Elemento actual: 121   */
      v.add(doc.createTextNode("Descripci�n atributo estado"));
      ((Element)v.get(120)).appendChild((Text)v.get(121));

      /* Termina nodo Texto:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("colFondo","" );
      ((Element)v.get(122)).setAttribute("ID","EstCab" );
      ((Element)v.get(122)).setAttribute("cod","1078" );
      ((Element)v.get(111)).appendChild((Element)v.get(122));

      /* Elemento padre:122 / Elemento actual: 123   */
      v.add(doc.createTextNode("Fecha contacto"));
      ((Element)v.get(122)).appendChild((Text)v.get(123));

      /* Termina nodo Texto:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("colFondo","" );
      ((Element)v.get(124)).setAttribute("ID","EstCab" );
      ((Element)v.get(124)).setAttribute("cod","2048" );
      ((Element)v.get(111)).appendChild((Element)v.get(124));

      /* Elemento padre:124 / Elemento actual: 125   */
      v.add(doc.createTextNode("Hora inicio"));
      ((Element)v.get(124)).appendChild((Text)v.get(125));

      /* Termina nodo Texto:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("colFondo","" );
      ((Element)v.get(126)).setAttribute("ID","EstCab" );
      ((Element)v.get(126)).setAttribute("cod","2049" );
      ((Element)v.get(111)).appendChild((Element)v.get(126));

      /* Elemento padre:126 / Elemento actual: 127   */
      v.add(doc.createTextNode("Hora fin"));
      ((Element)v.get(126)).appendChild((Text)v.get(127));

      /* Termina nodo Texto:127   */
      /* Termina nodo:126   */
      /* Termina nodo:111   */

      /* Empieza nodo:128 / Elemento padre: 92   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(128)).setAttribute("alto","22" );
      ((Element)v.get(128)).setAttribute("accion","" );
      ((Element)v.get(128)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(128)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(128)).setAttribute("maxSel","1" );
      ((Element)v.get(128)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(128)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(128)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(128)).setAttribute("onLoad","" );
      ((Element)v.get(128)).setAttribute("colorSelecc","#D0D9E8" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(128)).setAttribute("deseleccionaSiMaxSel","S" );
      ((Element)v.get(92)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("tipo","texto" );
      ((Element)v.get(129)).setAttribute("ID","EstDat2" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 128   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("tipo","texto" );
      ((Element)v.get(130)).setAttribute("ID","EstDat" );
      ((Element)v.get(128)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("tipo","texto" );
      ((Element)v.get(131)).setAttribute("ID","EstDat2" );
      ((Element)v.get(128)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 128   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("tipo","texto" );
      ((Element)v.get(132)).setAttribute("ID","EstDat" );
      ((Element)v.get(128)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 128   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("tipo","texto" );
      ((Element)v.get(133)).setAttribute("ID","EstDat2" );
      ((Element)v.get(128)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 128   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("tipo","texto" );
      ((Element)v.get(134)).setAttribute("ID","EstDat" );
      ((Element)v.get(128)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 128   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(135)).setAttribute("tipo","texto" );
      ((Element)v.get(135)).setAttribute("ID","EstDat2" );
      ((Element)v.get(128)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 128   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("tipo","texto" );
      ((Element)v.get(136)).setAttribute("ID","EstDat" );
      ((Element)v.get(128)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:128   */

      /* Empieza nodo:137 / Elemento padre: 92   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(92)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 92   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(138)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(138)).setAttribute("ancho","404" );
      ((Element)v.get(138)).setAttribute("sep","$" );
      ((Element)v.get(138)).setAttribute("x","12" );
      ((Element)v.get(138)).setAttribute("class","botonera" );
      ((Element)v.get(138)).setAttribute("y","294" );
      ((Element)v.get(138)).setAttribute("control","|" );
      ((Element)v.get(138)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(138)).setAttribute("rowset","" );
      ((Element)v.get(138)).setAttribute("cargainicial","N" );
      ((Element)v.get(138)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista1(ultima, rowset)')" );
      ((Element)v.get(92)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(139)).setAttribute("nombre","ret1" );
      ((Element)v.get(139)).setAttribute("x","37" );
      ((Element)v.get(139)).setAttribute("y","298" );
      ((Element)v.get(139)).setAttribute("ID","botonContenido" );
      ((Element)v.get(139)).setAttribute("img","retroceder_on" );
      ((Element)v.get(139)).setAttribute("tipo","0" );
      ((Element)v.get(139)).setAttribute("estado","false" );
      ((Element)v.get(139)).setAttribute("alt","" );
      ((Element)v.get(139)).setAttribute("codigo","" );
      ((Element)v.get(139)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 138   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(140)).setAttribute("nombre","ava1" );
      ((Element)v.get(140)).setAttribute("x","52" );
      ((Element)v.get(140)).setAttribute("y","298" );
      ((Element)v.get(140)).setAttribute("ID","botonContenido" );
      ((Element)v.get(140)).setAttribute("img","avanzar_on" );
      ((Element)v.get(140)).setAttribute("tipo","0" );
      ((Element)v.get(140)).setAttribute("estado","false" );
      ((Element)v.get(140)).setAttribute("alt","" );
      ((Element)v.get(140)).setAttribute("codigo","" );
      ((Element)v.get(140)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(138)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:138   */
      /* Termina nodo:92   */

      /* Empieza nodo:141 / Elemento padre: 91   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(141)).setAttribute("nombre","primera1" );
      ((Element)v.get(141)).setAttribute("x","20" );
      ((Element)v.get(141)).setAttribute("y","298" );
      ((Element)v.get(141)).setAttribute("ID","botonContenido" );
      ((Element)v.get(141)).setAttribute("img","primera_on" );
      ((Element)v.get(141)).setAttribute("tipo","-2" );
      ((Element)v.get(141)).setAttribute("estado","false" );
      ((Element)v.get(141)).setAttribute("alt","" );
      ((Element)v.get(141)).setAttribute("codigo","" );
      ((Element)v.get(141)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(91)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 91   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(142)).setAttribute("nombre","separa" );
      ((Element)v.get(142)).setAttribute("x","59" );
      ((Element)v.get(142)).setAttribute("y","294" );
      ((Element)v.get(142)).setAttribute("ID","botonContenido" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(142)).setAttribute("img","separa_base" );
      ((Element)v.get(142)).setAttribute("tipo","0" );
      ((Element)v.get(142)).setAttribute("estado","false" );
      ((Element)v.get(142)).setAttribute("alt","" );
      ((Element)v.get(142)).setAttribute("codigo","" );
      ((Element)v.get(142)).setAttribute("accion","" );
      ((Element)v.get(91)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 91   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(143)).setAttribute("nombre","btnActualizar" );
      ((Element)v.get(143)).setAttribute("x","81" );
      ((Element)v.get(143)).setAttribute("y","295" );
      ((Element)v.get(143)).setAttribute("ID","botonContenido" );
      ((Element)v.get(143)).setAttribute("tipo","html" );
      ((Element)v.get(143)).setAttribute("accion","onClickActualizar();" );
      ((Element)v.get(143)).setAttribute("estado","false" );
      ((Element)v.get(143)).setAttribute("codi","2" );
      ((Element)v.get(143)).setAttribute("cod","2077" );
      ((Element)v.get(143)).setAttribute("ontab","tabActualizar();" );
      ((Element)v.get(143)).setAttribute("onshtab","shtabActualizar();" );
      ((Element)v.get(91)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:91   */

      /* Empieza nodo:144 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(144)).setAttribute("nombre","capaLista2" );
      ((Element)v.get(144)).setAttribute("alto","317" );
      ((Element)v.get(144)).setAttribute("ancho","100%" );
      ((Element)v.get(144)).setAttribute("colorf","" );
      ((Element)v.get(144)).setAttribute("borde","0" );
      ((Element)v.get(144)).setAttribute("imagenf","" );
      ((Element)v.get(144)).setAttribute("repeat","" );
      ((Element)v.get(144)).setAttribute("padding","" );
      ((Element)v.get(144)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(144)).setAttribute("contravsb","" );
      ((Element)v.get(144)).setAttribute("x","0" );
      ((Element)v.get(144)).setAttribute("y","126" );
      ((Element)v.get(144)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(145)).setAttribute("nombre","listado2" );
      ((Element)v.get(145)).setAttribute("ancho","404" );
      ((Element)v.get(145)).setAttribute("alto","301" );
      ((Element)v.get(145)).setAttribute("x","12" );
      ((Element)v.get(145)).setAttribute("y","0" );
      ((Element)v.get(145)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(145)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(146)).setAttribute("precarga","S" );
      ((Element)v.get(146)).setAttribute("conROver","S" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(147)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(147)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(147)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(147)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 146   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(148)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(148)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(148)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(148)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(146)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 146   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(149)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(149)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(146)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:146   */

      /* Empieza nodo:150 / Elemento padre: 145   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(145)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(151)).setAttribute("borde","1" );
      ((Element)v.get(151)).setAttribute("horizDatos","1" );
      ((Element)v.get(151)).setAttribute("horizCabecera","1" );
      ((Element)v.get(151)).setAttribute("vertical","0" );
      ((Element)v.get(151)).setAttribute("horizTitulo","1" );
      ((Element)v.get(151)).setAttribute("horizBase","1" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 150   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(152)).setAttribute("borde","#999999" );
      ((Element)v.get(152)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(152)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(152)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(152)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(152)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(152)).setAttribute("horizBase","#999999" );
      ((Element)v.get(150)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:150   */

      /* Empieza nodo:153 / Elemento padre: 145   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(153)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(153)).setAttribute("alto","22" );
      ((Element)v.get(153)).setAttribute("imgFondo","" );
      ((Element)v.get(153)).setAttribute("cod","00534" );
      ((Element)v.get(153)).setAttribute("ID","datosTitle" );
      ((Element)v.get(145)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 145   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("BASE"));
      ((Element)v.get(154)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(154)).setAttribute("alto","22" );
      ((Element)v.get(154)).setAttribute("imgFondo","" );
      ((Element)v.get(145)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 145   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(155)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(155)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(155)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(155)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(155)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(155)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(145)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("ancho","100" );
      ((Element)v.get(156)).setAttribute("minimizable","S" );
      ((Element)v.get(156)).setAttribute("minimizada","N" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 155   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("ancho","100" );
      ((Element)v.get(157)).setAttribute("minimizable","S" );
      ((Element)v.get(157)).setAttribute("minimizada","N" );
      ((Element)v.get(157)).setAttribute("oculta","S" );
      ((Element)v.get(155)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:155   */

      /* Empieza nodo:158 / Elemento padre: 145   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(158)).setAttribute("alto","20" );
      ((Element)v.get(158)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(158)).setAttribute("imgFondo","" );
      ((Element)v.get(158)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(145)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("colFondo","" );
      ((Element)v.get(159)).setAttribute("ID","EstCab" );
      ((Element)v.get(159)).setAttribute("align","center" );
      ((Element)v.get(159)).setAttribute("cod","387" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Elemento padre:159 / Elemento actual: 160   */
      v.add(doc.createTextNode("Descripci�n motivo"));
      ((Element)v.get(159)).appendChild((Text)v.get(160));

      /* Termina nodo Texto:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 158   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("colFondo","" );
      ((Element)v.get(161)).setAttribute("ID","EstCab" );
      ((Element)v.get(161)).setAttribute("align","center" );
      ((Element)v.get(158)).appendChild((Element)v.get(161));

      /* Elemento padre:161 / Elemento actual: 162   */
      v.add(doc.createTextNode("oidCodProceso"));
      ((Element)v.get(161)).appendChild((Text)v.get(162));

      /* Termina nodo Texto:162   */
      /* Termina nodo:161   */
      /* Termina nodo:158   */

      /* Empieza nodo:163 / Elemento padre: 145   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(163)).setAttribute("alto","22" );
      ((Element)v.get(163)).setAttribute("accion","" );
      ((Element)v.get(163)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(163)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(163)).setAttribute("maxSel","-1" );
      ((Element)v.get(163)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(163)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(163)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(163)).setAttribute("onLoad","" );
      ((Element)v.get(163)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(145)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("tipo","texto" );
      ((Element)v.get(164)).setAttribute("ID","EstDat" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("tipo","texto" );
      ((Element)v.get(165)).setAttribute("ID","EstDat2" );
      ((Element)v.get(163)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:163   */

      /* Empieza nodo:166 / Elemento padre: 145   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(145)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 145   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(167)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(167)).setAttribute("ancho","404" );
      ((Element)v.get(167)).setAttribute("sep","$" );
      ((Element)v.get(167)).setAttribute("x","12" );
      ((Element)v.get(167)).setAttribute("class","botonera" );
      ((Element)v.get(167)).setAttribute("y","278" );
      ((Element)v.get(167)).setAttribute("control","|" );
      ((Element)v.get(167)).setAttribute("conector","conectorSandra1" );
      ((Element)v.get(167)).setAttribute("rowset","" );
      ((Element)v.get(167)).setAttribute("cargainicial","N" );
      ((Element)v.get(167)).setAttribute("onload","procesarPaginado(mipgndo2,msgError, ultima, rowset, 'muestraLista2(ultima, rowset)')" );
      ((Element)v.get(145)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(168)).setAttribute("nombre","ret2" );
      ((Element)v.get(168)).setAttribute("x","37" );
      ((Element)v.get(168)).setAttribute("y","282" );
      ((Element)v.get(168)).setAttribute("ID","botonContenido" );
      ((Element)v.get(168)).setAttribute("img","retroceder_on" );
      ((Element)v.get(168)).setAttribute("tipo","0" );
      ((Element)v.get(168)).setAttribute("estado","false" );
      ((Element)v.get(168)).setAttribute("alt","" );
      ((Element)v.get(168)).setAttribute("codigo","" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(168)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 167   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(169)).setAttribute("nombre","ava2" );
      ((Element)v.get(169)).setAttribute("x","52" );
      ((Element)v.get(169)).setAttribute("y","282" );
      ((Element)v.get(169)).setAttribute("ID","botonContenido" );
      ((Element)v.get(169)).setAttribute("img","avanzar_on" );
      ((Element)v.get(169)).setAttribute("tipo","0" );
      ((Element)v.get(169)).setAttribute("estado","false" );
      ((Element)v.get(169)).setAttribute("alt","" );
      ((Element)v.get(169)).setAttribute("codigo","" );
      ((Element)v.get(169)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(167)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:167   */
      /* Termina nodo:145   */

      /* Empieza nodo:170 / Elemento padre: 144   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(170)).setAttribute("nombre","primera2" );
      ((Element)v.get(170)).setAttribute("x","20" );
      ((Element)v.get(170)).setAttribute("y","282" );
      ((Element)v.get(170)).setAttribute("ID","botonContenido" );
      ((Element)v.get(170)).setAttribute("img","primera_on" );
      ((Element)v.get(170)).setAttribute("tipo","-2" );
      ((Element)v.get(170)).setAttribute("estado","false" );
      ((Element)v.get(170)).setAttribute("alt","" );
      ((Element)v.get(170)).setAttribute("codigo","" );
      ((Element)v.get(170)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(144)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 144   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(171)).setAttribute("nombre","separa2" );
      ((Element)v.get(171)).setAttribute("x","59" );
      ((Element)v.get(171)).setAttribute("y","278" );
      ((Element)v.get(171)).setAttribute("ID","botonContenido" );
      ((Element)v.get(171)).setAttribute("img","separa_base" );
      ((Element)v.get(171)).setAttribute("tipo","0" );
      ((Element)v.get(171)).setAttribute("estado","false" );
      ((Element)v.get(171)).setAttribute("alt","" );
      ((Element)v.get(171)).setAttribute("codigo","" );
      ((Element)v.get(171)).setAttribute("accion","" );
      ((Element)v.get(144)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 144   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(172)).setAttribute("nombre","btnEjecutar" );
      ((Element)v.get(172)).setAttribute("x","80" );
      ((Element)v.get(172)).setAttribute("y","279" );
      ((Element)v.get(172)).setAttribute("ID","botonContenido" );
      ((Element)v.get(172)).setAttribute("tipo","html" );
      ((Element)v.get(172)).setAttribute("estado","false" );
      ((Element)v.get(172)).setAttribute("cod","382" );
      ((Element)v.get(172)).setAttribute("accion","onClickEjecutar();" );
      ((Element)v.get(172)).setAttribute("ontab","tabEjecutar();" );
      ((Element)v.get(172)).setAttribute("onshtab","shEjecutar();" );
      ((Element)v.get(144)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:144   */

      /* Empieza nodo:173 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(173)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(173)).setAttribute("alto","12" );
      ((Element)v.get(173)).setAttribute("ancho","100%" );
      ((Element)v.get(173)).setAttribute("colorf","" );
      ((Element)v.get(173)).setAttribute("borde","0" );
      ((Element)v.get(173)).setAttribute("imagenf","" );
      ((Element)v.get(173)).setAttribute("repeat","" );
      ((Element)v.get(173)).setAttribute("padding","" );
      ((Element)v.get(173)).setAttribute("visibilidad","visible" );
      ((Element)v.get(173)).setAttribute("contravsb","" );
      ((Element)v.get(173)).setAttribute("x","0" );
      ((Element)v.get(173)).setAttribute("y","768" );
      ((Element)v.get(173)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:10   */


   }

}

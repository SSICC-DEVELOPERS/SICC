
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_clientes_desbloquear  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_clientes_desbloquear" );
      ((Element)v.get(0)).setAttribute("cod","0396" );
      ((Element)v.get(0)).setAttribute("titulo","Bloquear/Desbloquear Clientes" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Desbloquear Clientes" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_clientes_desbloquear.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","cbSeleccionarOpcion" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","2507" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","frmDesbloquearClientes" );
      ((Element)v.get(7)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","accion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","idioma" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","pais" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("var"));
      ((Element)v.get(12)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","oidsSeleccionados" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","listaCompleta" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","parametros" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","datos" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","tamanio" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 7   */
      v.add(doc.createElement("table"));
      ((Element)v.get(19)).setAttribute("width","100%" );
      ((Element)v.get(19)).setAttribute("border","0" );
      ((Element)v.get(19)).setAttribute("cellspacing","0" );
      ((Element)v.get(19)).setAttribute("cellpadding","0" );
      ((Element)v.get(7)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(21)).setAttribute("align","center" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(22)).setAttribute("height","12" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:23 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).setAttribute("width","750" );
      ((Element)v.get(20)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(20)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(26)).setAttribute("height","1" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */
      /* Termina nodo:20   */

      /* Empieza nodo:27 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(32)).setAttribute("class","legend" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(33)).setAttribute("nombre","lblCriteriosBuscqueda" );
      ((Element)v.get(33)).setAttribute("alto","13" );
      ((Element)v.get(33)).setAttribute("filas","1" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(33)).setAttribute("cod","0075" );
      ((Element)v.get(33)).setAttribute("id","legend" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 31   */
      v.add(doc.createElement("table"));
      ((Element)v.get(34)).setAttribute("width","100%" );
      ((Element)v.get(34)).setAttribute("border","0" );
      ((Element)v.get(34)).setAttribute("align","center" );
      ((Element)v.get(34)).setAttribute("cellspacing","0" );
      ((Element)v.get(34)).setAttribute("cellpadding","0" );
      ((Element)v.get(31)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("table"));
      ((Element)v.get(37)).setAttribute("width","566" );
      ((Element)v.get(37)).setAttribute("border","0" );
      ((Element)v.get(37)).setAttribute("align","left" );
      ((Element)v.get(37)).setAttribute("cellspacing","0" );
      ((Element)v.get(37)).setAttribute("cellpadding","0" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("colspan","4" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","8" );
      ((Element)v.get(40)).setAttribute("height","8" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:41 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(41));

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
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(45)).setAttribute("nombre","lblSeleccionarOpcion" );
      ((Element)v.get(45)).setAttribute("alto","13" );
      ((Element)v.get(45)).setAttribute("filas","1" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(45)).setAttribute("id","datosTitle" );
      ((Element)v.get(45)).setAttribute("cod","2507" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","25" );
      ((Element)v.get(47)).setAttribute("height","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(49)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(49)).setAttribute("alto","13" );
      ((Element)v.get(49)).setAttribute("filas","1" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(49)).setAttribute("id","datosTitle" );
      ((Element)v.get(49)).setAttribute("cod","263" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","25" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(53)).setAttribute("nombre","lblNombre1" );
      ((Element)v.get(53)).setAttribute("alto","13" );
      ((Element)v.get(53)).setAttribute("filas","1" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(53)).setAttribute("id","datosTitle" );
      ((Element)v.get(53)).setAttribute("cod","93" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","25" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(57)).setAttribute("nombre","lblNombre2" );
      ((Element)v.get(57)).setAttribute("alto","13" );
      ((Element)v.get(57)).setAttribute("filas","1" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("id","datosTitle" );
      ((Element)v.get(57)).setAttribute("cod","94" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("width","100%" );
      ((Element)v.get(41)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:41   */

      /* Empieza nodo:60 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(60));

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
      ((Element)v.get(64)).setAttribute("nombre","cbSeleccionarOpcion" );
      ((Element)v.get(64)).setAttribute("id","datosCampos" );
      ((Element)v.get(64)).setAttribute("size","1" );
      ((Element)v.get(64)).setAttribute("multiple","N" );
      ((Element)v.get(64)).setAttribute("req","S" );
      ((Element)v.get(64)).setAttribute("valorinicial","" );
      ((Element)v.get(64)).setAttribute("textoinicial","" );
      ((Element)v.get(64)).setAttribute("onshtab","focalizaShiftTabComboOpcion()" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(67)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(67)).setAttribute("TIPO","STRING" );
      ((Element)v.get(67)).setAttribute("VALOR","1" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 66   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(68)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(68)).setAttribute("TIPO","STRING" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).setAttribute("VALOR","Bloqueo" );
      ((Element)v.get(66)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:66   */

      /* Empieza nodo:69 / Elemento padre: 65   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(65)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(70)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(70)).setAttribute("TIPO","STRING" );
      ((Element)v.get(70)).setAttribute("VALOR","0" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 69   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(71)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(71)).setAttribute("TIPO","STRING" );
      ((Element)v.get(71)).setAttribute("VALOR","Desbloqueo" );
      ((Element)v.get(69)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:69   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:72 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","25" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(75)).setAttribute("nombre","textCodCliente" );
      ((Element)v.get(75)).setAttribute("id","datosCampos" );
      ((Element)v.get(75)).setAttribute("max","15" );
      ((Element)v.get(75)).setAttribute("tipo","" );
      ((Element)v.get(75)).setAttribute("onchange","" );
      ((Element)v.get(75)).setAttribute("onblur","codigoClienteOnBlur()" );
      ((Element)v.get(75)).setAttribute("req","N" );
      ((Element)v.get(75)).setAttribute("size","15" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(75)).setAttribute("validacion","" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","25" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(79)).setAttribute("nombre","textNombre1" );
      ((Element)v.get(79)).setAttribute("id","datosCampos" );
      ((Element)v.get(79)).setAttribute("max","25" );
      ((Element)v.get(79)).setAttribute("tipo","" );
      ((Element)v.get(79)).setAttribute("onchange","" );
      ((Element)v.get(79)).setAttribute("req","N" );
      ((Element)v.get(79)).setAttribute("size","25" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(79)).setAttribute("validacion","" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","25" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(83)).setAttribute("nombre","textNombre2" );
      ((Element)v.get(83)).setAttribute("id","datosCampos" );
      ((Element)v.get(83)).setAttribute("max","25" );
      ((Element)v.get(83)).setAttribute("tipo","" );
      ((Element)v.get(83)).setAttribute("onchange","" );
      ((Element)v.get(83)).setAttribute("req","N" );
      ((Element)v.get(83)).setAttribute("size","25" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(83)).setAttribute("validacion","" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("width","100%" );
      ((Element)v.get(60)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:60   */

      /* Empieza nodo:86 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("colspan","4" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(88)).setAttribute("width","8" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:89 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("table"));
      ((Element)v.get(91)).setAttribute("width","566" );
      ((Element)v.get(91)).setAttribute("border","0" );
      ((Element)v.get(91)).setAttribute("align","left" );
      ((Element)v.get(91)).setAttribute("cellspacing","0" );
      ((Element)v.get(91)).setAttribute("cellpadding","0" );
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
      ((Element)v.get(96)).setAttribute("nombre","lblApellido1" );
      ((Element)v.get(96)).setAttribute("alto","13" );
      ((Element)v.get(96)).setAttribute("filas","1" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(96)).setAttribute("id","datosTitle" );
      ((Element)v.get(96)).setAttribute("cod","16" );
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
      ((Element)v.get(100)).setAttribute("nombre","lblApellido2" );
      ((Element)v.get(100)).setAttribute("alto","13" );
      ((Element)v.get(100)).setAttribute("filas","1" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(100)).setAttribute("id","datosTitle" );
      ((Element)v.get(100)).setAttribute("cod","17" );
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
      ((Element)v.get(104)).setAttribute("nombre","lblDocumentoIdentidadCliente" );
      ((Element)v.get(104)).setAttribute("alto","13" );
      ((Element)v.get(104)).setAttribute("filas","1" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(104)).setAttribute("id","datosTitle" );
      ((Element)v.get(104)).setAttribute("cod","1327" );
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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(111)).setAttribute("nombre","textApellido1" );
      ((Element)v.get(111)).setAttribute("id","datosCampos" );
      ((Element)v.get(111)).setAttribute("max","25" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(111)).setAttribute("tipo","" );
      ((Element)v.get(111)).setAttribute("onchange","" );
      ((Element)v.get(111)).setAttribute("req","N" );
      ((Element)v.get(111)).setAttribute("size","25" );
      ((Element)v.get(111)).setAttribute("valor","" );
      ((Element)v.get(111)).setAttribute("validacion","" );
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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(115)).setAttribute("nombre","textApellido2" );
      ((Element)v.get(115)).setAttribute("id","datosCampos" );
      ((Element)v.get(115)).setAttribute("max","25" );
      ((Element)v.get(115)).setAttribute("tipo","" );
      ((Element)v.get(115)).setAttribute("onchange","" );
      ((Element)v.get(115)).setAttribute("req","N" );
      ((Element)v.get(115)).setAttribute("size","25" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(115)).setAttribute("validacion","" );
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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(119)).setAttribute("nombre","textDocumentoIdentidadCliente" );
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(119)).setAttribute("max","30" );
      ((Element)v.get(119)).setAttribute("tipo","" );
      ((Element)v.get(119)).setAttribute("onchange","" );
      ((Element)v.get(119)).setAttribute("req","N" );
      ((Element)v.get(119)).setAttribute("size","30" );
      ((Element)v.get(119)).setAttribute("valor","" );
      ((Element)v.get(119)).setAttribute("validacion","" );
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
      /* Termina nodo:34   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:125 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(126)).setAttribute("height","12" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:27   */

      /* Empieza nodo:127 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("table"));
      ((Element)v.get(132)).setAttribute("width","100%" );
      ((Element)v.get(132)).setAttribute("border","0" );
      ((Element)v.get(132)).setAttribute("align","center" );
      ((Element)v.get(132)).setAttribute("cellspacing","0" );
      ((Element)v.get(132)).setAttribute("cellpadding","0" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("class","botonera" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(135)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(135)).setAttribute("ID","botonContenido" );
      ((Element)v.get(135)).setAttribute("tipo","html" );
      ((Element)v.get(135)).setAttribute("accion","accionBuscar()" );
      ((Element)v.get(135)).setAttribute("estado","false" );
      ((Element)v.get(135)).setAttribute("cod","1" );
      ((Element)v.get(135)).setAttribute("ontab","focalizaTabBtnBuscar()" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:136 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","8" );
      ((Element)v.get(137)).setAttribute("height","12" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:127   */

      /* Empieza nodo:138 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("width","12" );
      ((Element)v.get(139)).setAttribute("align","center" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","12" );
      ((Element)v.get(140)).setAttribute("height","24" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("width","750" );
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("width","12" );
      ((Element)v.get(138)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","12" );
      ((Element)v.get(144)).setAttribute("height","24" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:138   */
      /* Termina nodo:19   */

      /* Empieza nodo:145 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(145)).setAttribute("nombre","capaLista" );
      ((Element)v.get(145)).setAttribute("ancho","100%" );
      ((Element)v.get(145)).setAttribute("alto","371" );
      ((Element)v.get(145)).setAttribute("x","0" );
      ((Element)v.get(145)).setAttribute("y","164" );
      ((Element)v.get(145)).setAttribute("colorf","" );
      ((Element)v.get(145)).setAttribute("borde","0" );
      ((Element)v.get(145)).setAttribute("imagenf","" );
      ((Element)v.get(145)).setAttribute("repeat","" );
      ((Element)v.get(145)).setAttribute("padding","" );
      ((Element)v.get(145)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(145)).setAttribute("contravsb","" );
      ((Element)v.get(145)).setAttribute("zindex","" );
      ((Element)v.get(7)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(146)).setAttribute("nombre","listado1" );
      ((Element)v.get(146)).setAttribute("ancho","570" );
      ((Element)v.get(146)).setAttribute("alto","371" );
      ((Element)v.get(146)).setAttribute("x","12" );
      ((Element)v.get(146)).setAttribute("y","0" );
      ((Element)v.get(146)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(146)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(147)).setAttribute("precarga","S" );
      ((Element)v.get(147)).setAttribute("conROver","S" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(148)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(148)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(148)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(148)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 147   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(149)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(149)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(149)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(149)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(147)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(150)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(150)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(147)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:147   */

      /* Empieza nodo:151 / Elemento padre: 146   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(146)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(152)).setAttribute("borde","1" );
      ((Element)v.get(152)).setAttribute("horizDatos","1" );
      ((Element)v.get(152)).setAttribute("horizCabecera","1" );
      ((Element)v.get(152)).setAttribute("vertical","1" );
      ((Element)v.get(152)).setAttribute("horizTitulo","1" );
      ((Element)v.get(152)).setAttribute("horizBase","1" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 151   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(153)).setAttribute("borde","#999999" );
      ((Element)v.get(153)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(153)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(153)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(153)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(153)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(153)).setAttribute("horizBase","#999999" );
      ((Element)v.get(151)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:151   */

      /* Empieza nodo:154 / Elemento padre: 146   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(154)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(154)).setAttribute("alto","22" );
      ((Element)v.get(154)).setAttribute("imgFondo","" );
      ((Element)v.get(154)).setAttribute("cod","00135" );
      ((Element)v.get(154)).setAttribute("ID","datosTitle" );
      ((Element)v.get(146)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 146   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(155)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(155)).setAttribute("alto","22" );
      ((Element)v.get(155)).setAttribute("imgFondo","" );
      ((Element)v.get(146)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 146   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(156)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(156)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(156)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(156)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(156)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(156)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(146)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("ancho","160" );
      ((Element)v.get(157)).setAttribute("minimizable","S" );
      ((Element)v.get(157)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("ancho","160" );
      ((Element)v.get(158)).setAttribute("minimizable","S" );
      ((Element)v.get(158)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("ancho","160" );
      ((Element)v.get(159)).setAttribute("minimizable","S" );
      ((Element)v.get(159)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("ancho","160" );
      ((Element)v.get(160)).setAttribute("minimizable","S" );
      ((Element)v.get(160)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("ancho","160" );
      ((Element)v.get(161)).setAttribute("minimizable","S" );
      ((Element)v.get(161)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("ancho","160" );
      ((Element)v.get(162)).setAttribute("minimizable","S" );
      ((Element)v.get(162)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("ancho","160" );
      ((Element)v.get(163)).setAttribute("minimizable","S" );
      ((Element)v.get(163)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:156   */

      /* Empieza nodo:164 / Elemento padre: 146   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(164)).setAttribute("alto","20" );
      ((Element)v.get(164)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(164)).setAttribute("imgFondo","" );
      ((Element)v.get(164)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(146)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("colFondo","" );
      ((Element)v.get(165)).setAttribute("ID","EstCab" );
      ((Element)v.get(165)).setAttribute("align","center" );
      ((Element)v.get(165)).setAttribute("cod","263" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("colFondo","" );
      ((Element)v.get(166)).setAttribute("ID","EstCab" );
      ((Element)v.get(166)).setAttribute("cod","93" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(164)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("colFondo","" );
      ((Element)v.get(167)).setAttribute("ID","EstCab" );
      ((Element)v.get(167)).setAttribute("cod","94" );
      ((Element)v.get(164)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("colFondo","" );
      ((Element)v.get(168)).setAttribute("ID","EstCab" );
      ((Element)v.get(168)).setAttribute("cod","16" );
      ((Element)v.get(164)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("colFondo","" );
      ((Element)v.get(169)).setAttribute("ID","EstCab" );
      ((Element)v.get(169)).setAttribute("cod","17" );
      ((Element)v.get(164)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("colFondo","" );
      ((Element)v.get(170)).setAttribute("ID","EstCab" );
      ((Element)v.get(170)).setAttribute("cod","1681" );
      ((Element)v.get(164)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("colFondo","" );
      ((Element)v.get(171)).setAttribute("ID","EstCab" );
      ((Element)v.get(171)).setAttribute("cod","169" );
      ((Element)v.get(164)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:164   */

      /* Empieza nodo:172 / Elemento padre: 146   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(172)).setAttribute("alto","22" );
      ((Element)v.get(172)).setAttribute("accion","" );
      ((Element)v.get(172)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(172)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(172)).setAttribute("maxSel","-1" );
      ((Element)v.get(172)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(172)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(172)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(172)).setAttribute("onLoad","" );
      ((Element)v.get(172)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(146)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("tipo","texto" );
      ((Element)v.get(173)).setAttribute("ID","EstDat" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("tipo","texto" );
      ((Element)v.get(174)).setAttribute("ID","EstDat2" );
      ((Element)v.get(172)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("tipo","texto" );
      ((Element)v.get(175)).setAttribute("ID","EstDat" );
      ((Element)v.get(172)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("tipo","texto" );
      ((Element)v.get(176)).setAttribute("ID","EstDat2" );
      ((Element)v.get(172)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("tipo","texto" );
      ((Element)v.get(177)).setAttribute("ID","EstDat" );
      ((Element)v.get(172)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(178)).setAttribute("nombre","txtMotivo" );
      ((Element)v.get(178)).setAttribute("size","40" );
      ((Element)v.get(178)).setAttribute("max","40" );
      ((Element)v.get(178)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(178)).setAttribute("ID","EstDat2" );
      ((Element)v.get(178)).setAttribute("onShTab","focalizaAnt(FILAEVENTO,TECLAEVENTO)" );
      ((Element)v.get(178)).setAttribute("validacion","" );
      ((Element)v.get(172)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("tipo","areatexto" );
      ((Element)v.get(179)).setAttribute("nombre","atxtObservaciones" );
      ((Element)v.get(179)).setAttribute("ID","EstDat" );
      ((Element)v.get(179)).setAttribute("IDOBJ","EstDatCajaForm2" );
      ((Element)v.get(179)).setAttribute("rows","3" );
      ((Element)v.get(179)).setAttribute("cols","50" );
      ((Element)v.get(179)).setAttribute("onTab","focalizaSig(FILAEVENTO,TECLAEVENTO);" );
      ((Element)v.get(179)).setAttribute("req","N" );
      ((Element)v.get(172)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:172   */

      /* Empieza nodo:180 / Elemento padre: 146   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(146)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 146   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(181)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(181)).setAttribute("ancho","570" );
      ((Element)v.get(181)).setAttribute("sep","$" );
      ((Element)v.get(181)).setAttribute("x","12" );
      ((Element)v.get(181)).setAttribute("class","botonera" );
      ((Element)v.get(181)).setAttribute("y","348" );
      ((Element)v.get(181)).setAttribute("control","|" );
      ((Element)v.get(181)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(181)).setAttribute("rowset","" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(181)).setAttribute("cargainicial","N" );
      ((Element)v.get(181)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(146)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(182)).setAttribute("nombre","ret1" );
      ((Element)v.get(182)).setAttribute("x","37" );
      ((Element)v.get(182)).setAttribute("y","352" );
      ((Element)v.get(182)).setAttribute("ID","botonContenido" );
      ((Element)v.get(182)).setAttribute("img","retroceder_on" );
      ((Element)v.get(182)).setAttribute("tipo","0" );
      ((Element)v.get(182)).setAttribute("estado","false" );
      ((Element)v.get(182)).setAttribute("alt","" );
      ((Element)v.get(182)).setAttribute("codigo","" );
      ((Element)v.get(182)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 181   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(183)).setAttribute("nombre","ava1" );
      ((Element)v.get(183)).setAttribute("x","52" );
      ((Element)v.get(183)).setAttribute("y","352" );
      ((Element)v.get(183)).setAttribute("ID","botonContenido" );
      ((Element)v.get(183)).setAttribute("img","avanzar_on" );
      ((Element)v.get(183)).setAttribute("tipo","0" );
      ((Element)v.get(183)).setAttribute("estado","false" );
      ((Element)v.get(183)).setAttribute("alt","" );
      ((Element)v.get(183)).setAttribute("codigo","" );
      ((Element)v.get(183)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(181)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:181   */
      /* Termina nodo:146   */

      /* Empieza nodo:184 / Elemento padre: 145   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(184)).setAttribute("nombre","primera1" );
      ((Element)v.get(184)).setAttribute("x","20" );
      ((Element)v.get(184)).setAttribute("y","352" );
      ((Element)v.get(184)).setAttribute("ID","botonContenido" );
      ((Element)v.get(184)).setAttribute("img","primera_on" );
      ((Element)v.get(184)).setAttribute("tipo","-2" );
      ((Element)v.get(184)).setAttribute("estado","false" );
      ((Element)v.get(184)).setAttribute("alt","" );
      ((Element)v.get(184)).setAttribute("codigo","" );
      ((Element)v.get(184)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(145)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 145   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(185)).setAttribute("nombre","separa" );
      ((Element)v.get(185)).setAttribute("x","59" );
      ((Element)v.get(185)).setAttribute("y","348" );
      ((Element)v.get(185)).setAttribute("ID","botonContenido" );
      ((Element)v.get(185)).setAttribute("img","separa_base" );
      ((Element)v.get(185)).setAttribute("tipo","0" );
      ((Element)v.get(185)).setAttribute("estado","false" );
      ((Element)v.get(185)).setAttribute("alt","" );
      ((Element)v.get(185)).setAttribute("codigo","" );
      ((Element)v.get(185)).setAttribute("accion","" );
      ((Element)v.get(145)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 145   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(186)).setAttribute("nombre","btnEjecutar" );
      ((Element)v.get(186)).setAttribute("x","80" );
      ((Element)v.get(186)).setAttribute("y","349" );
      ((Element)v.get(186)).setAttribute("ID","botonContenido" );
      ((Element)v.get(186)).setAttribute("accion","accionEjecutar()" );
      ((Element)v.get(186)).setAttribute("tipo","html" );
      ((Element)v.get(186)).setAttribute("estado","false" );
      ((Element)v.get(186)).setAttribute("cod","382" );
      ((Element)v.get(186)).setAttribute("onshtab","focalizaShTabBtnEjecutar();" );
      ((Element)v.get(186)).setAttribute("ontab","focaliza('frmDesbloquearClientes.cbSeleccionarOpcion');" );
      ((Element)v.get(145)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:145   */

      /* Empieza nodo:187 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(187)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(187)).setAttribute("alto","12" );
      ((Element)v.get(187)).setAttribute("ancho","100%" );
      ((Element)v.get(187)).setAttribute("colorf","" );
      ((Element)v.get(187)).setAttribute("borde","0" );
      ((Element)v.get(187)).setAttribute("imagenf","" );
      ((Element)v.get(187)).setAttribute("repeat","" );
      ((Element)v.get(187)).setAttribute("padding","" );
      ((Element)v.get(187)).setAttribute("visibilidad","visible" );
      ((Element)v.get(187)).setAttribute("contravsb","" );
      ((Element)v.get(187)).setAttribute("x","0" );
      ((Element)v.get(187)).setAttribute("y","535" );
      ((Element)v.get(187)).setAttribute("zindex","" );
      ((Element)v.get(7)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:7   */


   }

}

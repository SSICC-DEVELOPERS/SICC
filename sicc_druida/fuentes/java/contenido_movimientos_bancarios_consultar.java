
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_movimientos_bancarios_consultar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_movimientos_bancarios_consultar" );
      ((Element)v.get(0)).setAttribute("cod","0181" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Cosnultar Movimientos bancarios" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("STYLE"));
      ((Element)v.get(1)).setAttribute("TYPE","text/css" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r   \r\r\r#ret1Div {visibility:hidden;}\r#ava1Div {visibility:hidden;}\r#primera1Div {visibility:hidden;}\r#separa1Div {visibility:hidden;}\r#Cplistado1{visibility:hidden;}\r#CpLin1listado1{visibility:hidden;}\r#CpLin2listado1{visibility:hidden;}\r#CpLin3listado1{visibility:hidden;}\r#CpLin4listado1{visibility:hidden;}\r\r#DetalleDiv{visibility:hidden;}\r\r   \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","ccc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(7)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(8)).setAttribute("src","contenido_movimientos_bancarios_consultar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(9)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","accion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","idioma" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","pais" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","casoUso" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","oidsMovimiento" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","longitudCodigoCliente" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 9   */
      v.add(doc.createElement("table"));
      ((Element)v.get(20)).setAttribute("width","100%" );
      ((Element)v.get(20)).setAttribute("border","0" );
      ((Element)v.get(20)).setAttribute("cellspacing","0" );
      ((Element)v.get(20)).setAttribute("cellpadding","0" );
      ((Element)v.get(9)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(22)).setAttribute("align","center" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(23)).setAttribute("height","12" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","750" );
      ((Element)v.get(21)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(21)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(27)).setAttribute("height","1" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */
      /* Termina nodo:21   */

      /* Empieza nodo:28 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(33)).setAttribute("class","legend" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(34)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(34)).setAttribute("alto","13" );
      ((Element)v.get(34)).setAttribute("filas","1" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(34)).setAttribute("id","legend" );
      ((Element)v.get(34)).setAttribute("cod","0075" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 32   */
      v.add(doc.createElement("table"));
      ((Element)v.get(35)).setAttribute("width","100%" );
      ((Element)v.get(35)).setAttribute("border","0" );
      ((Element)v.get(35)).setAttribute("align","center" );
      ((Element)v.get(35)).setAttribute("cellspacing","0" );
      ((Element)v.get(35)).setAttribute("cellpadding","0" );
      ((Element)v.get(32)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("table"));
      ((Element)v.get(38)).setAttribute("width","694" );
      ((Element)v.get(38)).setAttribute("border","0" );
      ((Element)v.get(38)).setAttribute("align","left" );
      ((Element)v.get(38)).setAttribute("cellspacing","0" );
      ((Element)v.get(38)).setAttribute("cellpadding","0" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("colspan","4" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","8" );
      ((Element)v.get(41)).setAttribute("height","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:42 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","8" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(46)).setAttribute("nombre","lblBanco" );
      ((Element)v.get(46)).setAttribute("alto","13" );
      ((Element)v.get(46)).setAttribute("filas","1" );
      ((Element)v.get(46)).setAttribute("id","datosTitle" );
      ((Element)v.get(46)).setAttribute("cod","617" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","25" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(50)).setAttribute("nombre","lblCCC" );
      ((Element)v.get(50)).setAttribute("alto","13" );
      ((Element)v.get(50)).setAttribute("filas","1" );
      ((Element)v.get(50)).setAttribute("id","datosTitle" );
      ((Element)v.get(50)).setAttribute("cod","636" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","25" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(54)).setAttribute("nombre","lblFechaMov" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("id","datosTitle" );
      ((Element)v.get(54)).setAttribute("cod","651" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(42)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:42   */

      /* Empieza nodo:57 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(61)).setAttribute("nombre","cbBanco" );
      ((Element)v.get(61)).setAttribute("size","1" );
      ((Element)v.get(61)).setAttribute("multiple","N" );
      ((Element)v.get(61)).setAttribute("valorinicial","" );
      ((Element)v.get(61)).setAttribute("textoinicial","" );
      ((Element)v.get(61)).setAttribute("onshtab","focalizaAnteriorBanco();" );
      ((Element)v.get(61)).setAttribute("onchange","bancoOnChange()" );
      ((Element)v.get(61)).setAttribute("id","datosCampos" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:63 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","25" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(66)).setAttribute("nombre","cbCCC" );
      ((Element)v.get(66)).setAttribute("size","1" );
      ((Element)v.get(66)).setAttribute("multiple","N" );
      ((Element)v.get(66)).setAttribute("valorinicial","" );
      ((Element)v.get(66)).setAttribute("textoinicial","" );
      ((Element)v.get(66)).setAttribute("id","datosCampos" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:68 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","25" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(71)).setAttribute("nombre","FechaMov" );
      ((Element)v.get(71)).setAttribute("id","datosCampos" );
      ((Element)v.get(71)).setAttribute("max","10" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(71)).setAttribute("tipo","" );
      ((Element)v.get(71)).setAttribute("onchange","" );
      ((Element)v.get(71)).setAttribute("onblur","validaFecha('FechaMov');" );
      ((Element)v.get(71)).setAttribute("req","N" );
      ((Element)v.get(71)).setAttribute("size","12" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(71)).setAttribute("validacion","" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("width","100%" );
      ((Element)v.get(57)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","8" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:57   */

      /* Empieza nodo:74 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("colspan","4" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:77 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("table"));
      ((Element)v.get(79)).setAttribute("width","694" );
      ((Element)v.get(79)).setAttribute("border","0" );
      ((Element)v.get(79)).setAttribute("align","left" );
      ((Element)v.get(79)).setAttribute("cellspacing","0" );
      ((Element)v.get(79)).setAttribute("cellpadding","0" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(84)).setAttribute("nombre","lblCheckMov" );
      ((Element)v.get(84)).setAttribute("alto","13" );
      ((Element)v.get(84)).setAttribute("filas","1" );
      ((Element)v.get(84)).setAttribute("id","datosTitle" );
      ((Element)v.get(84)).setAttribute("cod","623" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","25" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(88)).setAttribute("nombre","lblTipoTransaccion" );
      ((Element)v.get(88)).setAttribute("alto","13" );
      ((Element)v.get(88)).setAttribute("filas","1" );
      ((Element)v.get(88)).setAttribute("id","datosTitle" );
      ((Element)v.get(88)).setAttribute("cod","702" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","25" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("colspan","2" );
      ((Element)v.get(80)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(92)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(92)).setAttribute("alto","13" );
      ((Element)v.get(92)).setAttribute("filas","1" );
      ((Element)v.get(92)).setAttribute("id","datosTitle" );
      ((Element)v.get(92)).setAttribute("cod","263" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("width","100%" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(80)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","8" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:80   */

      /* Empieza nodo:95 / Elemento padre: 79   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(79)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("table"));
      ((Element)v.get(99)).setAttribute("width","100%" );
      ((Element)v.get(99)).setAttribute("border","0" );
      ((Element)v.get(99)).setAttribute("cellspacing","0" );
      ((Element)v.get(99)).setAttribute("cellpadding","0" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("class","datosCampos" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(102)).setAttribute("nombre","CheckMov" );
      ((Element)v.get(102)).setAttribute("tipo","H" );
      ((Element)v.get(102)).setAttribute("id","datosCampos" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(103)).setAttribute("valor","true" );
      ((Element)v.get(103)).setAttribute("check","N" );
      ((Element)v.get(103)).setAttribute("onfocus","" );
      ((Element)v.get(103)).setAttribute("id","datosCampos" );
      ((Element)v.get(103)).setAttribute("cod","117" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Elemento padre:103 / Elemento actual: 104   */
      v.add(doc.createTextNode("yy"));
      ((Element)v.get(103)).appendChild((Text)v.get(104));

      /* Termina nodo Texto:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 102   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(105)).setAttribute("valor","N" );
      ((Element)v.get(105)).setAttribute("check","N" );
      ((Element)v.get(105)).setAttribute("onfocus","" );
      ((Element)v.get(105)).setAttribute("id","datosCampos" );
      ((Element)v.get(105)).setAttribute("cod","87" );
      ((Element)v.get(102)).appendChild((Element)v.get(105));

      /* Elemento padre:105 / Elemento actual: 106   */
      v.add(doc.createTextNode("nn"));
      ((Element)v.get(105)).appendChild((Text)v.get(106));

      /* Termina nodo Texto:106   */
      /* Termina nodo:105   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:107 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","25" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(110)).setAttribute("nombre","cbTipoTransaccion" );
      ((Element)v.get(110)).setAttribute("size","1" );
      ((Element)v.get(110)).setAttribute("multiple","N" );
      ((Element)v.get(110)).setAttribute("valorinicial","" );
      ((Element)v.get(110)).setAttribute("textoinicial","" );
      ((Element)v.get(110)).setAttribute("id","datosCampos" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:112 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","25" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(115)).setAttribute("nombre","CodCliente" );
      ((Element)v.get(115)).setAttribute("id","datosCampos" );
      ((Element)v.get(115)).setAttribute("max","15" );
      ((Element)v.get(115)).setAttribute("tipo","" );
      ((Element)v.get(115)).setAttribute("onchange","" );
      ((Element)v.get(115)).setAttribute("req","N" );
      ((Element)v.get(115)).setAttribute("size","19" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(115)).setAttribute("onblur","codigoClienteOnBlur();" );
      ((Element)v.get(115)).setAttribute("validacion","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(118)).setAttribute("onclick","accionSeleccionarCliente()" );
      ((Element)v.get(116)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:116   */

      /* Empieza nodo:119 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("width","100%" );
      ((Element)v.get(95)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","8" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:95   */

      /* Empieza nodo:121 / Elemento padre: 79   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(79)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("colspan","4" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:124 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("table"));
      ((Element)v.get(126)).setAttribute("width","694" );
      ((Element)v.get(126)).setAttribute("border","0" );
      ((Element)v.get(126)).setAttribute("align","left" );
      ((Element)v.get(126)).setAttribute("cellspacing","0" );
      ((Element)v.get(126)).setAttribute("cellpadding","0" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","8" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(131)).setAttribute("nombre","lblSaldoInicial" );
      ((Element)v.get(131)).setAttribute("alto","13" );
      ((Element)v.get(131)).setAttribute("filas","1" );
      ((Element)v.get(131)).setAttribute("id","datosTitle" );
      ((Element)v.get(131)).setAttribute("cod","707" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("width","100%" );
      ((Element)v.get(127)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:127   */

      /* Empieza nodo:134 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","8" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("table"));
      ((Element)v.get(138)).setAttribute("width","100%" );
      ((Element)v.get(138)).setAttribute("border","0" );
      ((Element)v.get(138)).setAttribute("cellspacing","0" );
      ((Element)v.get(138)).setAttribute("cellpadding","0" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("class","datosCampos" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("RADIOB"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(141)).setAttribute("nombre","SaldoInicial" );
      ((Element)v.get(141)).setAttribute("tipo","H" );
      ((Element)v.get(141)).setAttribute("id","datosCampos" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(142)).setAttribute("valor","true" );
      ((Element)v.get(142)).setAttribute("check","N" );
      ((Element)v.get(142)).setAttribute("onfocus","" );
      ((Element)v.get(142)).setAttribute("id","datosCampos" );
      ((Element)v.get(142)).setAttribute("cod","117" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Elemento padre:142 / Elemento actual: 143   */
      v.add(doc.createTextNode("yy"));
      ((Element)v.get(142)).appendChild((Text)v.get(143));

      /* Termina nodo Texto:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 141   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(144)).setAttribute("valor","N" );
      ((Element)v.get(144)).setAttribute("check","N" );
      ((Element)v.get(144)).setAttribute("onfocus","" );
      ((Element)v.get(144)).setAttribute("id","datosCampos" );
      ((Element)v.get(144)).setAttribute("cod","87" );
      ((Element)v.get(141)).appendChild((Element)v.get(144));

      /* Elemento padre:144 / Elemento actual: 145   */
      v.add(doc.createTextNode("nn"));
      ((Element)v.get(144)).appendChild((Text)v.get(145));

      /* Termina nodo Texto:145   */
      /* Termina nodo:144   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:146 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("width","100%" );
      ((Element)v.get(134)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:134   */

      /* Empieza nodo:148 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("colspan","4" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:35   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:151 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:28   */

      /* Empieza nodo:153 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("table"));
      ((Element)v.get(158)).setAttribute("width","100%" );
      ((Element)v.get(158)).setAttribute("border","0" );
      ((Element)v.get(158)).setAttribute("align","center" );
      ((Element)v.get(158)).setAttribute("cellspacing","0" );
      ((Element)v.get(158)).setAttribute("cellpadding","0" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("class","botonera" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(161)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(161)).setAttribute("ID","botonContenido" );
      ((Element)v.get(161)).setAttribute("ontab","focalizaSiguienteBuscar();" );
      ((Element)v.get(161)).setAttribute("tipo","html" );
      ((Element)v.get(161)).setAttribute("accion","accionBuscar()" );
      ((Element)v.get(161)).setAttribute("estado","false" );
      ((Element)v.get(161)).setAttribute("cod","1" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:162 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","8" );
      ((Element)v.get(163)).setAttribute("height","12" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:153   */

      /* Empieza nodo:164 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("width","12" );
      ((Element)v.get(165)).setAttribute("align","center" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","12" );
      ((Element)v.get(166)).setAttribute("height","12" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("width","756" );
      ((Element)v.get(164)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).setAttribute("width","12" );
      ((Element)v.get(164)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","12" );
      ((Element)v.get(170)).setAttribute("height","1" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:164   */
      /* Termina nodo:20   */

      /* Empieza nodo:171 / Elemento padre: 9   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(171)).setAttribute("nombre","listado1" );
      ((Element)v.get(171)).setAttribute("ancho","698" );
      ((Element)v.get(171)).setAttribute("alto","317" );
      ((Element)v.get(171)).setAttribute("x","12" );
      ((Element)v.get(171)).setAttribute("y","204" );
      ((Element)v.get(171)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(171)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(9)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(172)).setAttribute("precarga","S" );
      ((Element)v.get(172)).setAttribute("conROver","S" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(173)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(173)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(173)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(173)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 172   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(174)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(174)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(174)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(174)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(172)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 172   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(175)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(175)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(172)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:172   */

      /* Empieza nodo:176 / Elemento padre: 171   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(171)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(177)).setAttribute("borde","1" );
      ((Element)v.get(177)).setAttribute("horizDatos","1" );
      ((Element)v.get(177)).setAttribute("horizCabecera","1" );
      ((Element)v.get(177)).setAttribute("vertical","1" );
      ((Element)v.get(177)).setAttribute("horizTitulo","1" );
      ((Element)v.get(177)).setAttribute("horizBase","1" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 176   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(178)).setAttribute("borde","#999999" );
      ((Element)v.get(178)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(178)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(178)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(178)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(178)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(178)).setAttribute("horizBase","#999999" );
      ((Element)v.get(176)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:176   */

      /* Empieza nodo:179 / Elemento padre: 171   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(179)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(179)).setAttribute("alto","22" );
      ((Element)v.get(179)).setAttribute("imgFondo","" );
      ((Element)v.get(179)).setAttribute("cod","00135" );
      ((Element)v.get(179)).setAttribute("ID","datosTitle" );
      ((Element)v.get(171)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 171   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(180)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(180)).setAttribute("alto","22" );
      ((Element)v.get(180)).setAttribute("imgFondo","" );
      ((Element)v.get(171)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 171   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(181)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(181)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(181)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(181)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(181)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(181)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(171)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("ancho","150" );
      ((Element)v.get(182)).setAttribute("minimizable","S" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(182)).setAttribute("minimizada","N" );
      ((Element)v.get(182)).setAttribute("oculta","S" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 181   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("ancho","150" );
      ((Element)v.get(183)).setAttribute("minimizable","S" );
      ((Element)v.get(183)).setAttribute("minimizada","N" );
      ((Element)v.get(181)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 181   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("ancho","120" );
      ((Element)v.get(184)).setAttribute("minimizable","S" );
      ((Element)v.get(184)).setAttribute("minimizada","N" );
      ((Element)v.get(184)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(181)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 181   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("ancho","110" );
      ((Element)v.get(185)).setAttribute("minimizable","S" );
      ((Element)v.get(185)).setAttribute("minimizada","N" );
      ((Element)v.get(181)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 181   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("ancho","110" );
      ((Element)v.get(186)).setAttribute("minimizable","S" );
      ((Element)v.get(186)).setAttribute("minimizada","N" );
      ((Element)v.get(181)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 181   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("ancho","150" );
      ((Element)v.get(187)).setAttribute("minimizable","S" );
      ((Element)v.get(187)).setAttribute("minimizada","N" );
      ((Element)v.get(181)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 181   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("ancho","110" );
      ((Element)v.get(188)).setAttribute("minimizable","S" );
      ((Element)v.get(188)).setAttribute("minimizada","N" );
      ((Element)v.get(181)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 181   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("ancho","110" );
      ((Element)v.get(189)).setAttribute("minimizable","S" );
      ((Element)v.get(189)).setAttribute("minimizada","N" );
      ((Element)v.get(181)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 181   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("ancho","110" );
      ((Element)v.get(190)).setAttribute("minimizable","S" );
      ((Element)v.get(190)).setAttribute("minimizada","N" );
      ((Element)v.get(181)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:181   */

      /* Empieza nodo:191 / Elemento padre: 171   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(191)).setAttribute("alto","20" );
      ((Element)v.get(191)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(191)).setAttribute("imgFondo","" );
      ((Element)v.get(191)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(171)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("colFondo","" );
      ((Element)v.get(192)).setAttribute("ID","EstCab" );
      ((Element)v.get(192)).setAttribute("cod","636" );
      ((Element)v.get(192)).setAttribute("oculta","S" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 191   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("colFondo","" );
      ((Element)v.get(193)).setAttribute("ID","EstCab" );
      ((Element)v.get(193)).setAttribute("cod","636" );
      ((Element)v.get(191)).appendChild((Element)v.get(193));

      /* Elemento padre:193 / Elemento actual: 194   */
      v.add(doc.createTextNode("Cuenta corriente"));
      ((Element)v.get(193)).appendChild((Text)v.get(194));

      /* Termina nodo Texto:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 191   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(195)).setAttribute("colFondo","" );
      ((Element)v.get(195)).setAttribute("ID","EstCab" );
      ((Element)v.get(195)).setAttribute("cod","651" );
      ((Element)v.get(191)).appendChild((Element)v.get(195));

      /* Elemento padre:195 / Elemento actual: 196   */
      v.add(doc.createTextNode("Fecha movimiento"));
      ((Element)v.get(195)).appendChild((Text)v.get(196));

      /* Termina nodo Texto:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 191   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(197)).setAttribute("colFondo","" );
      ((Element)v.get(197)).setAttribute("ID","EstCab" );
      ((Element)v.get(197)).setAttribute("align","center" );
      ((Element)v.get(197)).setAttribute("cod","680" );
      ((Element)v.get(191)).appendChild((Element)v.get(197));

      /* Elemento padre:197 / Elemento actual: 198   */
      v.add(doc.createTextNode("Nº Lote"));
      ((Element)v.get(197)).appendChild((Text)v.get(198));

      /* Termina nodo Texto:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 191   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(199)).setAttribute("colFondo","" );
      ((Element)v.get(199)).setAttribute("ID","EstCab" );
      ((Element)v.get(199)).setAttribute("cod","263" );
      ((Element)v.get(191)).appendChild((Element)v.get(199));

      /* Elemento padre:199 / Elemento actual: 200   */
      v.add(doc.createTextNode("Cód. cliente"));
      ((Element)v.get(199)).appendChild((Text)v.get(200));

      /* Termina nodo Texto:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 191   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(201)).setAttribute("colFondo","" );
      ((Element)v.get(201)).setAttribute("ID","EstCab" );
      ((Element)v.get(201)).setAttribute("cod","943" );
      ((Element)v.get(191)).appendChild((Element)v.get(201));

      /* Elemento padre:201 / Elemento actual: 202   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createTextNode("Nombre y apellidos"));
      ((Element)v.get(201)).appendChild((Text)v.get(202));

      /* Termina nodo Texto:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 191   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(203)).setAttribute("colFondo","" );
      ((Element)v.get(203)).setAttribute("ID","EstCab" );
      ((Element)v.get(203)).setAttribute("cod","422" );
      ((Element)v.get(191)).appendChild((Element)v.get(203));

      /* Elemento padre:203 / Elemento actual: 204   */
      v.add(doc.createTextNode("Nº documento"));
      ((Element)v.get(203)).appendChild((Text)v.get(204));

      /* Termina nodo Texto:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 191   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(205)).setAttribute("colFondo","" );
      ((Element)v.get(205)).setAttribute("ID","EstCab" );
      ((Element)v.get(205)).setAttribute("cod","670" );
      ((Element)v.get(191)).appendChild((Element)v.get(205));

      /* Elemento padre:205 / Elemento actual: 206   */
      v.add(doc.createTextNode("Importe pago"));
      ((Element)v.get(205)).appendChild((Text)v.get(206));

      /* Termina nodo Texto:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 191   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("colFondo","" );
      ((Element)v.get(207)).setAttribute("ID","EstCab" );
      ((Element)v.get(207)).setAttribute("cod","2865" );
      ((Element)v.get(191)).appendChild((Element)v.get(207));

      /* Elemento padre:207 / Elemento actual: 208   */
      v.add(doc.createTextNode("Saldo Posterior"));
      ((Element)v.get(207)).appendChild((Text)v.get(208));

      /* Termina nodo Texto:208   */
      /* Termina nodo:207   */
      /* Termina nodo:191   */

      /* Empieza nodo:209 / Elemento padre: 171   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(209)).setAttribute("alto","22" );
      ((Element)v.get(209)).setAttribute("accion","" );
      ((Element)v.get(209)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(209)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(209)).setAttribute("maxSel","-1" );
      ((Element)v.get(209)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(209)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(209)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(209)).setAttribute("onLoad","" );
      ((Element)v.get(209)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(171)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("tipo","texto" );
      ((Element)v.get(210)).setAttribute("ID","EstDat" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(211)).setAttribute("tipo","texto" );
      ((Element)v.get(211)).setAttribute("ID","EstDat2" );
      ((Element)v.get(209)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("tipo","texto" );
      ((Element)v.get(212)).setAttribute("ID","EstDat" );
      ((Element)v.get(209)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(213)).setAttribute("tipo","texto" );
      ((Element)v.get(213)).setAttribute("ID","EstDat2" );
      ((Element)v.get(209)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("tipo","texto" );
      ((Element)v.get(214)).setAttribute("ID","EstDat" );
      ((Element)v.get(209)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(215)).setAttribute("tipo","texto" );
      ((Element)v.get(215)).setAttribute("ID","EstDat2" );
      ((Element)v.get(209)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("tipo","texto" );
      ((Element)v.get(216)).setAttribute("ID","EstDat" );
      ((Element)v.get(209)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("tipo","texto" );
      ((Element)v.get(217)).setAttribute("ID","EstDat2" );
      ((Element)v.get(209)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(218)).setAttribute("tipo","texto" );
      ((Element)v.get(218)).setAttribute("ID","EstDat" );
      ((Element)v.get(209)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:209   */

      /* Empieza nodo:219 / Elemento padre: 171   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(171)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 171   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(220)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(220)).setAttribute("ancho","698" );
      ((Element)v.get(220)).setAttribute("sep","$" );
      ((Element)v.get(220)).setAttribute("x","12" );
      ((Element)v.get(220)).setAttribute("class","botonera" );
      ((Element)v.get(220)).setAttribute("y","498" );
      ((Element)v.get(220)).setAttribute("control","|" );
      ((Element)v.get(220)).setAttribute("conector","ConectorBuscarMovBancConsultar" );
      ((Element)v.get(220)).setAttribute("rowset","" );
      ((Element)v.get(220)).setAttribute("onload","procesarPaginado(mipgndo, msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(220)).setAttribute("cargainicial","N" );
      ((Element)v.get(171)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(221)).setAttribute("nombre","ret1" );
      ((Element)v.get(221)).setAttribute("x","37" );
      ((Element)v.get(221)).setAttribute("y","502" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(221)).setAttribute("ID","botonContenido" );
      ((Element)v.get(221)).setAttribute("img","retroceder_on" );
      ((Element)v.get(221)).setAttribute("tipo","0" );
      ((Element)v.get(221)).setAttribute("estado","false" );
      ((Element)v.get(221)).setAttribute("alt","" );
      ((Element)v.get(221)).setAttribute("codigo","" );
      ((Element)v.get(221)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 220   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(222)).setAttribute("nombre","ava1" );
      ((Element)v.get(222)).setAttribute("x","52" );
      ((Element)v.get(222)).setAttribute("y","502" );
      ((Element)v.get(222)).setAttribute("ID","botonContenido" );
      ((Element)v.get(222)).setAttribute("img","avanzar_on" );
      ((Element)v.get(222)).setAttribute("tipo","0" );
      ((Element)v.get(222)).setAttribute("estado","false" );
      ((Element)v.get(222)).setAttribute("alt","" );
      ((Element)v.get(222)).setAttribute("codigo","" );
      ((Element)v.get(222)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(220)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:220   */
      /* Termina nodo:171   */

      /* Empieza nodo:223 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(223)).setAttribute("nombre","primera1" );
      ((Element)v.get(223)).setAttribute("x","20" );
      ((Element)v.get(223)).setAttribute("y","502" );
      ((Element)v.get(223)).setAttribute("ID","botonContenido" );
      ((Element)v.get(223)).setAttribute("img","primera_on" );
      ((Element)v.get(223)).setAttribute("tipo","-2" );
      ((Element)v.get(223)).setAttribute("estado","false" );
      ((Element)v.get(223)).setAttribute("alt","" );
      ((Element)v.get(223)).setAttribute("codigo","" );
      ((Element)v.get(223)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(9)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(224)).setAttribute("nombre","separa1" );
      ((Element)v.get(224)).setAttribute("x","59" );
      ((Element)v.get(224)).setAttribute("y","498" );
      ((Element)v.get(224)).setAttribute("ID","botonContenido" );
      ((Element)v.get(224)).setAttribute("img","separa_base" );
      ((Element)v.get(224)).setAttribute("tipo","0" );
      ((Element)v.get(224)).setAttribute("estado","false" );
      ((Element)v.get(224)).setAttribute("alt","" );
      ((Element)v.get(224)).setAttribute("codigo","" );
      ((Element)v.get(224)).setAttribute("accion","" );
      ((Element)v.get(9)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(225)).setAttribute("nombre","Detalle" );
      ((Element)v.get(225)).setAttribute("x","80" );
      ((Element)v.get(225)).setAttribute("y","499" );
      ((Element)v.get(225)).setAttribute("ID","botonContenido" );
      ((Element)v.get(225)).setAttribute("tipo","html" );
      ((Element)v.get(225)).setAttribute("estado","false" );
      ((Element)v.get(225)).setAttribute("onshtab","document.all['btnBuscar'].focus();" );
      ((Element)v.get(225)).setAttribute("ontab","focaliza(FORMULARIO + '.cbBanco');" );
      ((Element)v.get(225)).setAttribute("accion","accionBTN_Detalle()" );
      ((Element)v.get(225)).setAttribute("cod","3" );
      ((Element)v.get(9)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(226)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(226)).setAttribute("alto","12" );
      ((Element)v.get(226)).setAttribute("ancho","100%" );
      ((Element)v.get(226)).setAttribute("colorf","" );
      ((Element)v.get(226)).setAttribute("borde","0" );
      ((Element)v.get(226)).setAttribute("imagenf","" );
      ((Element)v.get(226)).setAttribute("repeat","" );
      ((Element)v.get(226)).setAttribute("padding","" );
      ((Element)v.get(226)).setAttribute("visibilidad","visible" );
      ((Element)v.get(226)).setAttribute("contravsb","" );
      ((Element)v.get(226)).setAttribute("x","0" );
      ((Element)v.get(226)).setAttribute("y","521" );
      ((Element)v.get(226)).setAttribute("zindex","" );
      ((Element)v.get(9)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:9   */


   }

}

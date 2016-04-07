
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_seguimiento_telecobranza_realizar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_seguimiento_telecobranza_realizar" );
      ((Element)v.get(0)).setAttribute("cod","0281" );
      ((Element)v.get(0)).setAttribute("titulo","Realizar Seguimiento de Telecobranza" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_seguimiento_telecobranza_realizar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("STYLE"));
      ((Element)v.get(6)).setAttribute("TYPE","text/css" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Elemento padre:6 / Elemento actual: 7   */
      v.add(doc.createTextNode("\r   \r\r#Cplistado1{visibility:hidden;}\r#CpLin1listado1{visibility:hidden;}\r#CpLin2listado1{visibility:hidden;}\r#CpLin3listado1{visibility:hidden;}\r#CpLin4listado1{visibility:hidden;}\r#primera1Div{visibility:hidden;}\r#ret1Div{visibility:hidden;}\r#ava1Div{visibility:hidden;}\r#separa1Div{visibility:hidden;}\r#VerAccion1Div{visibility:hidden;}\r#EjecutarDiv{visibility:hidden;}\r\r#Cplistado2{visibility:hidden;}\r#CpLin1listado2{visibility:hidden;}\r#CpLin2listado2{visibility:hidden;}\r#CpLin3listado2{visibility:hidden;}\r#CpLin4listado2{visibility:hidden;}\r#primera2Div{visibility:hidden;}\r#ret2Div{visibility:hidden;}\r#ava2Div{visibility:hidden;}\r#separa2Div{visibility:hidden;}\r#Detalle2Div{visibility:hidden;}\r#CompromisoPago2Div{visibility:hidden;}\r#capa3{visibility:hidden;}\r\r\r   \r"));
      ((Element)v.get(6)).appendChild((Text)v.get(7));

      /* Termina nodo Texto:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(8)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","accion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hPais" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hCbMarca" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hCbCanal" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(17)).setAttribute("nombre","capa1" );
      ((Element)v.get(8)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("table"));
      ((Element)v.get(18)).setAttribute("width","100%" );
      ((Element)v.get(18)).setAttribute("border","0" );
      ((Element)v.get(18)).setAttribute("cellspacing","0" );
      ((Element)v.get(18)).setAttribute("cellpadding","0" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(20)).setAttribute("align","center" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(21)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(21)).setAttribute("height","12" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:22 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).setAttribute("width","750" );
      ((Element)v.get(19)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 19   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(19)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("height","1" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */
      /* Termina nodo:19   */

      /* Empieza nodo:26 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(31)).setAttribute("class","legend" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(32)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(32)).setAttribute("alto","13" );
      ((Element)v.get(32)).setAttribute("filas","1" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(32)).setAttribute("id","legend" );
      ((Element)v.get(32)).setAttribute("cod","0075" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("table"));
      ((Element)v.get(33)).setAttribute("width","100%" );
      ((Element)v.get(33)).setAttribute("border","0" );
      ((Element)v.get(33)).setAttribute("align","center" );
      ((Element)v.get(33)).setAttribute("cellspacing","0" );
      ((Element)v.get(33)).setAttribute("cellpadding","0" );
      ((Element)v.get(30)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("table"));
      ((Element)v.get(36)).setAttribute("width","715" );
      ((Element)v.get(36)).setAttribute("border","0" );
      ((Element)v.get(36)).setAttribute("align","left" );
      ((Element)v.get(36)).setAttribute("cellspacing","0" );
      ((Element)v.get(36)).setAttribute("cellpadding","0" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("colspan","3" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","8" );
      ((Element)v.get(39)).setAttribute("height","7" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:40 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","8" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(44)).setAttribute("nombre","lblEtapa" );
      ((Element)v.get(44)).setAttribute("alto","13" );
      ((Element)v.get(44)).setAttribute("filas","1" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(44)).setAttribute("id","datosTitle" );
      ((Element)v.get(44)).setAttribute("cod","865" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","25" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(48)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(48)).setAttribute("alto","13" );
      ((Element)v.get(48)).setAttribute("filas","1" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(48)).setAttribute("id","datosTitle" );
      ((Element)v.get(48)).setAttribute("cod","6" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","25" );
      ((Element)v.get(50)).setAttribute("height","8" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(52)).setAttribute("alto","13" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(52)).setAttribute("id","datosTitle" );
      ((Element)v.get(52)).setAttribute("cod","7" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","25" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(56)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(56)).setAttribute("alto","13" );
      ((Element)v.get(56)).setAttribute("filas","1" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(56)).setAttribute("id","datosTitle" );
      ((Element)v.get(56)).setAttribute("cod","276" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","25" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(60)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("id","datosTitle" );
      ((Element)v.get(60)).setAttribute("cod","109" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","100%" );
      ((Element)v.get(40)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","8" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:40   */

      /* Empieza nodo:63 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","8" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(67)).setAttribute("nombre","cbEtapa" );
      ((Element)v.get(67)).setAttribute("id","datosCampos" );
      ((Element)v.get(67)).setAttribute("size","1" );
      ((Element)v.get(67)).setAttribute("multiple","N" );
      ((Element)v.get(67)).setAttribute("req","N" );
      ((Element)v.get(67)).setAttribute("onshtab","focalizaShTab(1);" );
      ((Element)v.get(67)).setAttribute("valorinicial","" );
      ((Element)v.get(67)).setAttribute("textoinicial","" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:69 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","25" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(72)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(72)).setAttribute("id","datosCampos" );
      ((Element)v.get(72)).setAttribute("size","1" );
      ((Element)v.get(72)).setAttribute("multiple","N" );
      ((Element)v.get(72)).setAttribute("req","N" );
      ((Element)v.get(72)).setAttribute("onchange","marcaOnChange();" );
      ((Element)v.get(72)).setAttribute("valorinicial","" );
      ((Element)v.get(72)).setAttribute("textoinicial","" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:74 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","25" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(77)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(77)).setAttribute("id","datosCampos" );
      ((Element)v.get(77)).setAttribute("size","1" );
      ((Element)v.get(77)).setAttribute("multiple","N" );
      ((Element)v.get(77)).setAttribute("req","N" );
      ((Element)v.get(77)).setAttribute("onchange","canalOnChange();" );
      ((Element)v.get(77)).setAttribute("valorinicial","" );
      ((Element)v.get(77)).setAttribute("textoinicial","" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:79 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","25" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(82)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(82)).setAttribute("id","datosCampos" );
      ((Element)v.get(82)).setAttribute("size","1" );
      ((Element)v.get(82)).setAttribute("multiple","N" );
      ((Element)v.get(82)).setAttribute("req","N" );
      ((Element)v.get(82)).setAttribute("valorinicial","" );
      ((Element)v.get(82)).setAttribute("textoinicial","" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:84 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","25" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(63)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(87)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(87)).setAttribute("id","datosCampos" );
      ((Element)v.get(87)).setAttribute("size","1" );
      ((Element)v.get(87)).setAttribute("multiple","N" );
      ((Element)v.get(87)).setAttribute("req","N" );
      ((Element)v.get(87)).setAttribute("valorinicial","" );
      ((Element)v.get(87)).setAttribute("textoinicial","" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:89 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("width","100%" );
      ((Element)v.get(63)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:63   */

      /* Empieza nodo:91 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("colspan","3" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","7" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:94 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("table"));
      ((Element)v.get(96)).setAttribute("width","715" );
      ((Element)v.get(96)).setAttribute("border","0" );
      ((Element)v.get(96)).setAttribute("align","left" );
      ((Element)v.get(96)).setAttribute("cellspacing","0" );
      ((Element)v.get(96)).setAttribute("cellpadding","0" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("colspan","3" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","8" );
      ((Element)v.get(99)).setAttribute("height","7" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:100 / Elemento padre: 96   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(96)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","8" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(104)).setAttribute("nombre","lblOrdenacion" );
      ((Element)v.get(104)).setAttribute("alto","13" );
      ((Element)v.get(104)).setAttribute("filas","1" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(104)).setAttribute("id","datosTitle" );
      ((Element)v.get(104)).setAttribute("cod","953" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(108)).setAttribute("nombre","lblNumConsultoras" );
      ((Element)v.get(108)).setAttribute("alto","13" );
      ((Element)v.get(108)).setAttribute("filas","1" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(108)).setAttribute("id","datosTitle" );
      ((Element)v.get(108)).setAttribute("cod","3133" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","8" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(112)).setAttribute("nombre","lblSaldoXCobrar" );
      ((Element)v.get(112)).setAttribute("alto","13" );
      ((Element)v.get(112)).setAttribute("filas","1" );
      ((Element)v.get(112)).setAttribute("valor","" );
      ((Element)v.get(112)).setAttribute("id","datosTitle" );
      ((Element)v.get(112)).setAttribute("cod","3134" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","100%" );
      ((Element)v.get(100)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:100   */

      /* Empieza nodo:115 / Elemento padre: 96   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(96)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
   }

   private void getXML450(Document doc) {
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
      ((Element)v.get(115)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(119)).setAttribute("nombre","cbOrdenacion" );
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(119)).setAttribute("size","1" );
      ((Element)v.get(119)).setAttribute("multiple","N" );
      ((Element)v.get(119)).setAttribute("req","N" );
      ((Element)v.get(119)).setAttribute("valorinicial","" );
      ((Element)v.get(119)).setAttribute("textoinicial","" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:121 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(124)).setAttribute("nombre","lblValNumConsultoras" );
      ((Element)v.get(124)).setAttribute("alto","13" );
      ((Element)v.get(124)).setAttribute("filas","1" );
      ((Element)v.get(124)).setAttribute("id","datosCampos" );
      ((Element)v.get(124)).setAttribute("valor","" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(128)).setAttribute("nombre","lblValSaldoXCobrar" );
      ((Element)v.get(128)).setAttribute("alto","13" );
      ((Element)v.get(128)).setAttribute("filas","1" );
      ((Element)v.get(128)).setAttribute("id","datosCampos" );
      ((Element)v.get(128)).setAttribute("valor","" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","100%" );
      ((Element)v.get(115)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:115   */

      /* Empieza nodo:131 / Elemento padre: 96   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(96)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("colspan","3" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","7" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:33   */
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:134 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:26   */

      /* Empieza nodo:136 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("table"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(141)).setAttribute("border","0" );
      ((Element)v.get(141)).setAttribute("align","center" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(141)).setAttribute("cellspacing","0" );
      ((Element)v.get(141)).setAttribute("cellpadding","0" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("class","botonera" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(144)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(144)).setAttribute("ID","botonContenido" );
      ((Element)v.get(144)).setAttribute("tipo","html" );
      ((Element)v.get(144)).setAttribute("accion","buscarOnClick();" );
      ((Element)v.get(144)).setAttribute("ontab","focalizaTab(1);" );
      ((Element)v.get(144)).setAttribute("estado","false" );
      ((Element)v.get(144)).setAttribute("cod","1" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:145 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(146)).setAttribute("height","12" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:136   */

      /* Empieza nodo:147 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("width","12" );
      ((Element)v.get(148)).setAttribute("align","center" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","12" );
      ((Element)v.get(149)).setAttribute("height","12" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("width","756" );
      ((Element)v.get(147)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("width","12" );
      ((Element)v.get(147)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","12" );
      ((Element)v.get(153)).setAttribute("height","1" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:147   */
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:154 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(154)).setAttribute("nombre","listado1" );
      ((Element)v.get(154)).setAttribute("ancho","719" );
      ((Element)v.get(154)).setAttribute("alto","317" );
      ((Element)v.get(154)).setAttribute("x","12" );
      ((Element)v.get(154)).setAttribute("y","166" );
      ((Element)v.get(154)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(154)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(154)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(8)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(155)).setAttribute("precarga","S" );
      ((Element)v.get(155)).setAttribute("conROver","S" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(156)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(156)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(156)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(156)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 155   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(157)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(157)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(157)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(157)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(155)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 155   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(158)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(158)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(155)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:155   */

      /* Empieza nodo:159 / Elemento padre: 154   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(154)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(160)).setAttribute("borde","1" );
      ((Element)v.get(160)).setAttribute("horizDatos","1" );
      ((Element)v.get(160)).setAttribute("horizCabecera","1" );
      ((Element)v.get(160)).setAttribute("vertical","1" );
      ((Element)v.get(160)).setAttribute("horizTitulo","1" );
      ((Element)v.get(160)).setAttribute("horizBase","1" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 159   */
      v.add(doc.createElement("COLOR"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(161)).setAttribute("borde","#999999" );
      ((Element)v.get(161)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(161)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(161)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(161)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(161)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(161)).setAttribute("horizBase","#999999" );
      ((Element)v.get(159)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:159   */

      /* Empieza nodo:162 / Elemento padre: 154   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(162)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(162)).setAttribute("alto","22" );
      ((Element)v.get(162)).setAttribute("imgFondo","" );
      ((Element)v.get(162)).setAttribute("cod","00135" );
      ((Element)v.get(162)).setAttribute("ID","datosTitle" );
      ((Element)v.get(154)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 154   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(163)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(163)).setAttribute("alto","22" );
      ((Element)v.get(163)).setAttribute("imgFondo","" );
      ((Element)v.get(154)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 154   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(164)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(164)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(164)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(164)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(164)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(164)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(154)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("ancho","10" );
      ((Element)v.get(165)).setAttribute("minimizable","S" );
      ((Element)v.get(165)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("ancho","100" );
      ((Element)v.get(166)).setAttribute("minimizable","S" );
      ((Element)v.get(166)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("ancho","180" );
      ((Element)v.get(167)).setAttribute("minimizable","S" );
      ((Element)v.get(167)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("ancho","90" );
      ((Element)v.get(168)).setAttribute("minimizable","S" );
      ((Element)v.get(168)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("ancho","90" );
      ((Element)v.get(169)).setAttribute("minimizable","S" );
      ((Element)v.get(169)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("ancho","120" );
      ((Element)v.get(170)).setAttribute("minimizable","S" );
      ((Element)v.get(170)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("ancho","90" );
      ((Element)v.get(171)).setAttribute("minimizable","S" );
      ((Element)v.get(171)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("ancho","180" );
      ((Element)v.get(172)).setAttribute("minimizable","S" );
      ((Element)v.get(172)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("ancho","180" );
      ((Element)v.get(173)).setAttribute("minimizable","S" );
      ((Element)v.get(173)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("ancho","180" );
      ((Element)v.get(174)).setAttribute("minimizable","S" );
      ((Element)v.get(174)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("ancho","180" );
      ((Element)v.get(175)).setAttribute("minimizable","S" );
      ((Element)v.get(175)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("ancho","180" );
      ((Element)v.get(176)).setAttribute("minimizable","S" );
      ((Element)v.get(176)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("ancho","180" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(177)).setAttribute("minimizable","S" );
      ((Element)v.get(177)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("ancho","180" );
      ((Element)v.get(178)).setAttribute("minimizable","S" );
      ((Element)v.get(178)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("ancho","180" );
      ((Element)v.get(179)).setAttribute("minimizable","S" );
      ((Element)v.get(179)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("ancho","180" );
      ((Element)v.get(180)).setAttribute("minimizable","S" );
      ((Element)v.get(180)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("ancho","180" );
      ((Element)v.get(181)).setAttribute("minimizable","S" );
      ((Element)v.get(181)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("ancho","180" );
      ((Element)v.get(182)).setAttribute("minimizable","S" );
      ((Element)v.get(182)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("ancho","180" );
      ((Element)v.get(183)).setAttribute("minimizable","S" );
      ((Element)v.get(183)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("ancho","180" );
      ((Element)v.get(184)).setAttribute("minimizable","S" );
      ((Element)v.get(184)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("ancho","180" );
      ((Element)v.get(185)).setAttribute("minimizable","S" );
      ((Element)v.get(185)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("ancho","180" );
      ((Element)v.get(186)).setAttribute("minimizable","S" );
      ((Element)v.get(186)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("ancho","180" );
      ((Element)v.get(187)).setAttribute("minimizable","S" );
      ((Element)v.get(187)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("ancho","100" );
      ((Element)v.get(188)).setAttribute("minimizable","S" );
      ((Element)v.get(188)).setAttribute("minimizada","N" );
      ((Element)v.get(188)).setAttribute("oculta","S" );
      ((Element)v.get(164)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("ancho","100" );
      ((Element)v.get(189)).setAttribute("minimizable","S" );
      ((Element)v.get(189)).setAttribute("minimizada","N" );
      ((Element)v.get(189)).setAttribute("oculta","S" );
      ((Element)v.get(164)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("ancho","100" );
      ((Element)v.get(190)).setAttribute("minimizable","S" );
      ((Element)v.get(190)).setAttribute("minimizada","N" );
      ((Element)v.get(190)).setAttribute("oculta","S" );
      ((Element)v.get(164)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("ancho","100" );
      ((Element)v.get(191)).setAttribute("minimizable","S" );
      ((Element)v.get(191)).setAttribute("minimizada","N" );
      ((Element)v.get(191)).setAttribute("oculta","S" );
      ((Element)v.get(164)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("ancho","100" );
      ((Element)v.get(192)).setAttribute("minimizable","S" );
      ((Element)v.get(192)).setAttribute("minimizada","N" );
      ((Element)v.get(192)).setAttribute("oculta","S" );
      ((Element)v.get(164)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("ancho","100" );
      ((Element)v.get(193)).setAttribute("minimizable","S" );
      ((Element)v.get(193)).setAttribute("minimizada","N" );
      ((Element)v.get(193)).setAttribute("oculta","S" );
      ((Element)v.get(164)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(194)).setAttribute("ancho","100" );
      ((Element)v.get(194)).setAttribute("minimizable","S" );
      ((Element)v.get(194)).setAttribute("minimizada","N" );
      ((Element)v.get(194)).setAttribute("oculta","S" );
      ((Element)v.get(164)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(195)).setAttribute("ancho","100" );
      ((Element)v.get(195)).setAttribute("minimizable","S" );
      ((Element)v.get(195)).setAttribute("minimizada","N" );
      ((Element)v.get(195)).setAttribute("oculta","S" );
      ((Element)v.get(164)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(196)).setAttribute("ancho","100" );
      ((Element)v.get(196)).setAttribute("minimizable","S" );
      ((Element)v.get(196)).setAttribute("minimizada","N" );
      ((Element)v.get(196)).setAttribute("oculta","S" );
      ((Element)v.get(164)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:164   */

      /* Empieza nodo:197 / Elemento padre: 154   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(197)).setAttribute("alto","20" );
      ((Element)v.get(197)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(197)).setAttribute("imgFondo","" );
      ((Element)v.get(197)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(154)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("colFondo","" );
      ((Element)v.get(198)).setAttribute("ID","EstCab" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(199)).setAttribute("colFondo","" );
      ((Element)v.get(199)).setAttribute("ID","EstCab" );
      ((Element)v.get(199)).setAttribute("cod","263" );
      ((Element)v.get(197)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(200)).setAttribute("colFondo","" );
      ((Element)v.get(200)).setAttribute("ID","EstCab" );
      ((Element)v.get(200)).setAttribute("cod","264" );
      ((Element)v.get(197)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(201)).setAttribute("colFondo","" );
      ((Element)v.get(201)).setAttribute("ID","EstCab" );
      ((Element)v.get(201)).setAttribute("cod","2520" );
      ((Element)v.get(197)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(202)).setAttribute("colFondo","" );
      ((Element)v.get(202)).setAttribute("ID","EstCab" );
      ((Element)v.get(202)).setAttribute("cod","2521" );
      ((Element)v.get(197)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(203)).setAttribute("colFondo","" );
      ((Element)v.get(203)).setAttribute("ID","EstCab" );
      ((Element)v.get(203)).setAttribute("cod","902" );
      ((Element)v.get(197)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("colFondo","" );
      ((Element)v.get(204)).setAttribute("ID","EstCab" );
      ((Element)v.get(204)).setAttribute("cod","2130" );
      ((Element)v.get(197)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(205)).setAttribute("colFondo","" );
      ((Element)v.get(205)).setAttribute("ID","EstCab" );
      ((Element)v.get(205)).setAttribute("cod","3135" );
      ((Element)v.get(197)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("colFondo","" );
      ((Element)v.get(206)).setAttribute("ID","EstCab" );
      ((Element)v.get(206)).setAttribute("cod","276" );
      ((Element)v.get(197)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("colFondo","" );
      ((Element)v.get(207)).setAttribute("ID","EstCab" );
      ((Element)v.get(207)).setAttribute("cod","865" );
      ((Element)v.get(197)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("colFondo","" );
      ((Element)v.get(208)).setAttribute("ID","EstCab" );
      ((Element)v.get(208)).setAttribute("cod","143" );
      ((Element)v.get(197)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(209)).setAttribute("colFondo","" );
      ((Element)v.get(209)).setAttribute("ID","EstCab" );
      ((Element)v.get(209)).setAttribute("cod","112" );
      ((Element)v.get(197)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */

      /* Empieza nodo:210 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("colFondo","" );
      ((Element)v.get(210)).setAttribute("ID","EstCab" );
      ((Element)v.get(210)).setAttribute("cod","126" );
      ((Element)v.get(197)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(211)).setAttribute("colFondo","" );
      ((Element)v.get(211)).setAttribute("ID","EstCab" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(211)).setAttribute("cod","895" );
      ((Element)v.get(197)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("colFondo","" );
      ((Element)v.get(212)).setAttribute("ID","EstCab" );
      ((Element)v.get(212)).setAttribute("cod","2514" );
      ((Element)v.get(197)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(213)).setAttribute("colFondo","" );
      ((Element)v.get(213)).setAttribute("ID","EstCab" );
      ((Element)v.get(213)).setAttribute("cod","2128" );
      ((Element)v.get(197)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("colFondo","" );
      ((Element)v.get(214)).setAttribute("ID","EstCab" );
      ((Element)v.get(214)).setAttribute("cod","124" );
      ((Element)v.get(197)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(215)).setAttribute("colFondo","" );
      ((Element)v.get(215)).setAttribute("ID","EstCab" );
      ((Element)v.get(215)).setAttribute("cod","109" );
      ((Element)v.get(197)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("colFondo","" );
      ((Element)v.get(216)).setAttribute("ID","EstCab" );
      ((Element)v.get(216)).setAttribute("cod","999" );
      ((Element)v.get(197)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("colFondo","" );
      ((Element)v.get(217)).setAttribute("ID","EstCab" );
      ((Element)v.get(217)).setAttribute("cod","6" );
      ((Element)v.get(197)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(218)).setAttribute("colFondo","" );
      ((Element)v.get(218)).setAttribute("ID","EstCab" );
      ((Element)v.get(218)).setAttribute("cod","7" );
      ((Element)v.get(197)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(219)).setAttribute("colFondo","" );
      ((Element)v.get(219)).setAttribute("ID","EstCab" );
      ((Element)v.get(219)).setAttribute("cod","1660" );
      ((Element)v.get(197)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(220)).setAttribute("colFondo","" );
      ((Element)v.get(220)).setAttribute("ID","EstCab" );
      ((Element)v.get(220)).setAttribute("cod","400" );
      ((Element)v.get(197)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(221)).setAttribute("colFondo","" );
      ((Element)v.get(221)).setAttribute("ID","EstCab" );
      ((Element)v.get(221)).setAttribute("cod","400" );
      ((Element)v.get(197)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("colFondo","" );
      ((Element)v.get(222)).setAttribute("ID","EstCab" );
      ((Element)v.get(222)).setAttribute("cod","400" );
      ((Element)v.get(197)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(223)).setAttribute("colFondo","" );
      ((Element)v.get(223)).setAttribute("ID","EstCab" );
      ((Element)v.get(223)).setAttribute("cod","400" );
      ((Element)v.get(197)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("colFondo","" );
      ((Element)v.get(224)).setAttribute("ID","EstCab" );
      ((Element)v.get(224)).setAttribute("cod","400" );
      ((Element)v.get(197)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(225)).setAttribute("colFondo","" );
      ((Element)v.get(225)).setAttribute("ID","EstCab" );
      ((Element)v.get(225)).setAttribute("cod","400" );
      ((Element)v.get(197)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(226)).setAttribute("colFondo","" );
      ((Element)v.get(226)).setAttribute("ID","EstCab" );
      ((Element)v.get(226)).setAttribute("cod","400" );
      ((Element)v.get(197)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */

      /* Empieza nodo:227 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("colFondo","" );
      ((Element)v.get(227)).setAttribute("ID","EstCab" );
      ((Element)v.get(227)).setAttribute("cod","400" );
      ((Element)v.get(197)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(228)).setAttribute("colFondo","" );
      ((Element)v.get(228)).setAttribute("ID","EstCab" );
      ((Element)v.get(228)).setAttribute("cod","400" );
      ((Element)v.get(197)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("colFondo","" );
      ((Element)v.get(229)).setAttribute("ID","EstCab" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(229)).setAttribute("cod","400" );
      ((Element)v.get(197)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:197   */

      /* Empieza nodo:230 / Elemento padre: 154   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(230)).setAttribute("alto","22" );
      ((Element)v.get(230)).setAttribute("accion","" );
      ((Element)v.get(230)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(230)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(230)).setAttribute("maxSel","-1" );
      ((Element)v.get(230)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(230)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(230)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(230)).setAttribute("onLoad","" );
      ((Element)v.get(230)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(154)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("tipo","imagen" );
      ((Element)v.get(231)).setAttribute("ID","EstDat" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(232)).setAttribute("tipo","texto" );
      ((Element)v.get(232)).setAttribute("ID","EstDat2" );
      ((Element)v.get(230)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(233)).setAttribute("tipo","texto" );
      ((Element)v.get(233)).setAttribute("ID","EstDat" );
      ((Element)v.get(230)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */

      /* Empieza nodo:234 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(234)).setAttribute("tipo","texto" );
      ((Element)v.get(234)).setAttribute("ID","EstDat2" );
      ((Element)v.get(230)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(235)).setAttribute("tipo","texto" );
      ((Element)v.get(235)).setAttribute("ID","EstDat" );
      ((Element)v.get(230)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(236)).setAttribute("tipo","texto" );
      ((Element)v.get(236)).setAttribute("ID","EstDat2" );
      ((Element)v.get(230)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(237)).setAttribute("tipo","texto" );
      ((Element)v.get(237)).setAttribute("ID","EstDat" );
      ((Element)v.get(230)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(238)).setAttribute("tipo","texto" );
      ((Element)v.get(238)).setAttribute("ID","EstDat2" );
      ((Element)v.get(230)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(239)).setAttribute("tipo","texto" );
      ((Element)v.get(239)).setAttribute("ID","EstDat" );
      ((Element)v.get(230)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(240)).setAttribute("tipo","texto" );
      ((Element)v.get(240)).setAttribute("ID","EstDat2" );
      ((Element)v.get(230)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(241)).setAttribute("tipo","texto" );
      ((Element)v.get(241)).setAttribute("ID","EstDat" );
      ((Element)v.get(230)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(242)).setAttribute("tipo","texto" );
      ((Element)v.get(242)).setAttribute("ID","EstDat2" );
      ((Element)v.get(230)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(243)).setAttribute("tipo","texto" );
      ((Element)v.get(243)).setAttribute("ID","EstDat" );
      ((Element)v.get(230)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(244)).setAttribute("tipo","texto" );
      ((Element)v.get(244)).setAttribute("ID","EstDat2" );
      ((Element)v.get(230)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(245)).setAttribute("tipo","texto" );
      ((Element)v.get(245)).setAttribute("ID","EstDat" );
      ((Element)v.get(230)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */

      /* Empieza nodo:246 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(246)).setAttribute("tipo","texto" );
      ((Element)v.get(246)).setAttribute("ID","EstDat2" );
      ((Element)v.get(230)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */

      /* Empieza nodo:247 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(247)).setAttribute("tipo","texto" );
      ((Element)v.get(247)).setAttribute("ID","EstDat" );
      ((Element)v.get(230)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(248)).setAttribute("tipo","texto" );
      ((Element)v.get(248)).setAttribute("ID","EstDat2" );
      ((Element)v.get(230)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */

      /* Empieza nodo:249 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(249)).setAttribute("tipo","texto" );
      ((Element)v.get(249)).setAttribute("ID","EstDat" );
      ((Element)v.get(230)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 230   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(250)).setAttribute("tipo","texto" );
      ((Element)v.get(250)).setAttribute("ID","EstDat2" );
      ((Element)v.get(230)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(251)).setAttribute("tipo","texto" );
      ((Element)v.get(251)).setAttribute("ID","EstDat" );
      ((Element)v.get(230)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("tipo","texto" );
      ((Element)v.get(252)).setAttribute("ID","EstDat2" );
      ((Element)v.get(230)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(253)).setAttribute("tipo","texto" );
      ((Element)v.get(253)).setAttribute("ID","EstDat" );
      ((Element)v.get(230)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(254)).setAttribute("tipo","texto" );
      ((Element)v.get(254)).setAttribute("ID","EstDat2" );
      ((Element)v.get(230)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("tipo","texto" );
      ((Element)v.get(255)).setAttribute("ID","EstDat2" );
      ((Element)v.get(230)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(256)).setAttribute("tipo","texto" );
      ((Element)v.get(256)).setAttribute("ID","EstDat2" );
      ((Element)v.get(230)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("tipo","texto" );
      ((Element)v.get(257)).setAttribute("ID","EstDat2" );
      ((Element)v.get(230)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(258)).setAttribute("tipo","texto" );
      ((Element)v.get(258)).setAttribute("ID","EstDat2" );
      ((Element)v.get(230)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(259)).setAttribute("tipo","texto" );
      ((Element)v.get(259)).setAttribute("ID","EstDat2" );
      ((Element)v.get(230)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(260)).setAttribute("tipo","texto" );
      ((Element)v.get(260)).setAttribute("ID","EstDat2" );
      ((Element)v.get(230)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(261)).setAttribute("tipo","texto" );
      ((Element)v.get(261)).setAttribute("ID","EstDat2" );
      ((Element)v.get(230)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */

      /* Empieza nodo:262 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(262)).setAttribute("tipo","texto" );
      ((Element)v.get(262)).setAttribute("ID","EstDat2" );
      ((Element)v.get(230)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:230   */

      /* Empieza nodo:263 / Elemento padre: 154   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(154)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */

      /* Empieza nodo:264 / Elemento padre: 154   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(264)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(264)).setAttribute("ancho","719" );
      ((Element)v.get(264)).setAttribute("sep","$" );
      ((Element)v.get(264)).setAttribute("x","12" );
      ((Element)v.get(264)).setAttribute("class","botonera" );
      ((Element)v.get(264)).setAttribute("y","460" );
      ((Element)v.get(264)).setAttribute("control","|" );
      ((Element)v.get(264)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(264)).setAttribute("rowset","" );
      ((Element)v.get(264)).setAttribute("cargainicial","N" );
      ((Element)v.get(264)).setAttribute("onload","procesarPaginado(mipgndo1,msgError,ultima,rowset,'muestraLista(ultima,rowset)');" );
      ((Element)v.get(154)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(265)).setAttribute("nombre","ret1" );
      ((Element)v.get(265)).setAttribute("x","37" );
      ((Element)v.get(265)).setAttribute("y","464" );
      ((Element)v.get(265)).setAttribute("ID","botonContenido" );
      ((Element)v.get(265)).setAttribute("img","retroceder_on" );
      ((Element)v.get(265)).setAttribute("tipo","0" );
      ((Element)v.get(265)).setAttribute("estado","false" );
      ((Element)v.get(265)).setAttribute("alt","" );
      ((Element)v.get(265)).setAttribute("codigo","" );
      ((Element)v.get(265)).setAttribute("accion","mipgndo1.retroceder();" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 264   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(266)).setAttribute("nombre","ava1" );
      ((Element)v.get(266)).setAttribute("x","52" );
      ((Element)v.get(266)).setAttribute("y","464" );
      ((Element)v.get(266)).setAttribute("ID","botonContenido" );
      ((Element)v.get(266)).setAttribute("img","avanzar_on" );
      ((Element)v.get(266)).setAttribute("tipo","0" );
      ((Element)v.get(266)).setAttribute("estado","false" );
      ((Element)v.get(266)).setAttribute("alt","" );
      ((Element)v.get(266)).setAttribute("codigo","" );
      ((Element)v.get(266)).setAttribute("accion","mipgndo1.avanzar();" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(264)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:264   */
      /* Termina nodo:154   */

      /* Empieza nodo:267 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(267)).setAttribute("nombre","primera1" );
      ((Element)v.get(267)).setAttribute("x","20" );
      ((Element)v.get(267)).setAttribute("y","464" );
      ((Element)v.get(267)).setAttribute("ID","botonContenido" );
      ((Element)v.get(267)).setAttribute("img","primera_on" );
      ((Element)v.get(267)).setAttribute("tipo","0" );
      ((Element)v.get(267)).setAttribute("estado","false" );
      ((Element)v.get(267)).setAttribute("alt","" );
      ((Element)v.get(267)).setAttribute("codigo","" );
      ((Element)v.get(267)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(268)).setAttribute("nombre","separa1" );
      ((Element)v.get(268)).setAttribute("x","59" );
      ((Element)v.get(268)).setAttribute("y","460" );
      ((Element)v.get(268)).setAttribute("ID","botonContenido" );
      ((Element)v.get(268)).setAttribute("img","separa_base" );
      ((Element)v.get(268)).setAttribute("tipo","0" );
      ((Element)v.get(268)).setAttribute("estado","false" );
      ((Element)v.get(268)).setAttribute("alt","" );
      ((Element)v.get(268)).setAttribute("codigo","" );
      ((Element)v.get(268)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(269)).setAttribute("nombre","VerAccion1" );
      ((Element)v.get(269)).setAttribute("x","80" );
      ((Element)v.get(269)).setAttribute("y","461" );
      ((Element)v.get(269)).setAttribute("ID","botonContenido" );
      ((Element)v.get(269)).setAttribute("tipo","html" );
      ((Element)v.get(269)).setAttribute("accion","verAccionOnClick();" );
      ((Element)v.get(269)).setAttribute("ontab","focalizaTab(4);" );
      ((Element)v.get(269)).setAttribute("onshtab","focalizaShTab(2);" );
      ((Element)v.get(269)).setAttribute("estado","false" );
      ((Element)v.get(269)).setAttribute("cod","2522" );
      ((Element)v.get(8)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(270)).setAttribute("nombre","Ejecutar" );
      ((Element)v.get(270)).setAttribute("x","415" );
      ((Element)v.get(270)).setAttribute("y","461" );
      ((Element)v.get(270)).setAttribute("ID","botonContenido" );
      ((Element)v.get(270)).setAttribute("tipo","html" );
      ((Element)v.get(270)).setAttribute("accion","ejecutarOnClick();" );
      ((Element)v.get(270)).setAttribute("onshtab","focalizaShTab(4);" );
      ((Element)v.get(270)).setAttribute("ontab","focalizaTab(2);" );
      ((Element)v.get(270)).setAttribute("estado","false" );
      ((Element)v.get(270)).setAttribute("cod","382" );
      ((Element)v.get(8)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(271)).setAttribute("nombre","listado2" );
      ((Element)v.get(271)).setAttribute("ancho","719" );
      ((Element)v.get(271)).setAttribute("alto","317" );
      ((Element)v.get(271)).setAttribute("x","12" );
      ((Element)v.get(271)).setAttribute("y","507" );
      ((Element)v.get(271)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(271)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(271)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(8)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(272)).setAttribute("precarga","S" );
      ((Element)v.get(272)).setAttribute("conROver","S" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(273)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(273)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(273)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(273)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 272   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(274)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(274)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(274)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(274)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(272)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 272   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(275)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(275)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(272)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:272   */

      /* Empieza nodo:276 / Elemento padre: 271   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(271)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(277)).setAttribute("borde","1" );
      ((Element)v.get(277)).setAttribute("horizDatos","1" );
      ((Element)v.get(277)).setAttribute("horizCabecera","1" );
      ((Element)v.get(277)).setAttribute("vertical","1" );
      ((Element)v.get(277)).setAttribute("horizTitulo","1" );
      ((Element)v.get(277)).setAttribute("horizBase","1" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 276   */
      v.add(doc.createElement("COLOR"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(278)).setAttribute("borde","#999999" );
      ((Element)v.get(278)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(278)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(278)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(278)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(278)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(278)).setAttribute("horizBase","#999999" );
      ((Element)v.get(276)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:276   */

      /* Empieza nodo:279 / Elemento padre: 271   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(279)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(279)).setAttribute("alto","22" );
      ((Element)v.get(279)).setAttribute("imgFondo","" );
      ((Element)v.get(279)).setAttribute("cod","2201" );
      ((Element)v.get(279)).setAttribute("ID","datosTitle" );
      ((Element)v.get(271)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 271   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(280)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(280)).setAttribute("alto","22" );
      ((Element)v.get(280)).setAttribute("imgFondo","" );
      ((Element)v.get(271)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 271   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(281)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(281)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(281)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(281)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(281)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(281)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(271)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(282)).setAttribute("ancho","100" );
      ((Element)v.get(282)).setAttribute("minimizable","S" );
      ((Element)v.get(282)).setAttribute("minimizada","N" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(283)).setAttribute("ancho","180" );
      ((Element)v.get(283)).setAttribute("minimizable","S" );
      ((Element)v.get(283)).setAttribute("minimizada","N" );
      ((Element)v.get(281)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("ancho","100" );
      ((Element)v.get(284)).setAttribute("minimizable","S" );
      ((Element)v.get(284)).setAttribute("minimizada","N" );
      ((Element)v.get(281)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("ancho","180" );
      ((Element)v.get(285)).setAttribute("minimizable","S" );
      ((Element)v.get(285)).setAttribute("minimizada","N" );
      ((Element)v.get(281)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(286)).setAttribute("ancho","180" );
      ((Element)v.get(286)).setAttribute("minimizable","S" );
      ((Element)v.get(286)).setAttribute("minimizada","N" );
      ((Element)v.get(281)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(287)).setAttribute("ancho","180" );
      ((Element)v.get(287)).setAttribute("minimizable","S" );
      ((Element)v.get(287)).setAttribute("minimizada","N" );
      ((Element)v.get(281)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(288)).setAttribute("ancho","180" );
      ((Element)v.get(288)).setAttribute("minimizable","S" );
      ((Element)v.get(288)).setAttribute("minimizada","N" );
      ((Element)v.get(281)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(289)).setAttribute("ancho","180" );
      ((Element)v.get(289)).setAttribute("minimizable","S" );
      ((Element)v.get(289)).setAttribute("minimizada","N" );
      ((Element)v.get(281)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:281   */

      /* Empieza nodo:290 / Elemento padre: 271   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(290)).setAttribute("alto","20" );
      ((Element)v.get(290)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(290)).setAttribute("imgFondo","" );
      ((Element)v.get(290)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(271)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(291)).setAttribute("colFondo","" );
      ((Element)v.get(291)).setAttribute("ID","EstCab" );
      ((Element)v.get(291)).setAttribute("cod","793" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("colFondo","" );
      ((Element)v.get(292)).setAttribute("ID","EstCab" );
      ((Element)v.get(292)).setAttribute("cod","841" );
      ((Element)v.get(290)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(293)).setAttribute("colFondo","" );
      ((Element)v.get(293)).setAttribute("ID","EstCab" );
      ((Element)v.get(293)).setAttribute("cod","994" );
      ((Element)v.get(290)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(294)).setAttribute("colFondo","" );
      ((Element)v.get(294)).setAttribute("ID","EstCab" );
      ((Element)v.get(294)).setAttribute("cod","880" );
      ((Element)v.get(290)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(295)).setAttribute("colFondo","" );
      ((Element)v.get(295)).setAttribute("ID","EstCab" );
      ((Element)v.get(295)).setAttribute("cod","892" );
      ((Element)v.get(290)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(296)).setAttribute("colFondo","" );
      ((Element)v.get(296)).setAttribute("ID","EstCab" );
      ((Element)v.get(296)).setAttribute("cod","879" );
      ((Element)v.get(290)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(297)).setAttribute("colFondo","" );
      ((Element)v.get(297)).setAttribute("ID","EstCab" );
      ((Element)v.get(297)).setAttribute("cod","891" );
      ((Element)v.get(290)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */

      /* Empieza nodo:298 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(298)).setAttribute("colFondo","" );
      ((Element)v.get(298)).setAttribute("ID","EstCab" );
      ((Element)v.get(298)).setAttribute("cod","924" );
      ((Element)v.get(290)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:290   */

      /* Empieza nodo:299 / Elemento padre: 271   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(299)).setAttribute("alto","22" );
      ((Element)v.get(299)).setAttribute("accion","" );
      ((Element)v.get(299)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(299)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(299)).setAttribute("maxSel","-1" );
      ((Element)v.get(299)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(299)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(299)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(299)).setAttribute("onLoad","" );
      ((Element)v.get(299)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(271)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(300)).setAttribute("tipo","texto" );
      ((Element)v.get(300)).setAttribute("ID","EstDat" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(301)).setAttribute("tipo","texto" );
      ((Element)v.get(301)).setAttribute("ID","EstDat2" );
      ((Element)v.get(299)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(302)).setAttribute("tipo","texto" );
      ((Element)v.get(302)).setAttribute("ID","EstDat" );
      ((Element)v.get(299)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(303)).setAttribute("tipo","texto" );
      ((Element)v.get(303)).setAttribute("ID","EstDat2" );
      ((Element)v.get(299)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(304)).setAttribute("tipo","texto" );
      ((Element)v.get(304)).setAttribute("ID","EstDat" );
      ((Element)v.get(299)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("tipo","texto" );
      ((Element)v.get(305)).setAttribute("ID","EstDat2" );
      ((Element)v.get(299)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(306)).setAttribute("tipo","texto" );
      ((Element)v.get(306)).setAttribute("ID","EstDat" );
      ((Element)v.get(299)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(307)).setAttribute("tipo","texto" );
      ((Element)v.get(307)).setAttribute("ID","EstDat2" );
      ((Element)v.get(299)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:299   */

      /* Empieza nodo:308 / Elemento padre: 271   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(271)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 271   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(309)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(309)).setAttribute("ancho","719" );
      ((Element)v.get(309)).setAttribute("sep","$" );
      ((Element)v.get(309)).setAttribute("x","12" );
      ((Element)v.get(309)).setAttribute("class","botonera" );
      ((Element)v.get(309)).setAttribute("y","801" );
      ((Element)v.get(309)).setAttribute("control","|" );
      ((Element)v.get(309)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(309)).setAttribute("rowset","" );
      ((Element)v.get(309)).setAttribute("cargainicial","N" );
      ((Element)v.get(309)).setAttribute("onload","procesarPaginado(mipgndo2,msgError,ultima,rowset,'muestraLista2(ultima,rowset)');" );
      ((Element)v.get(271)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(310)).setAttribute("nombre","ret2" );
      ((Element)v.get(310)).setAttribute("x","37" );
      ((Element)v.get(310)).setAttribute("y","805" );
      ((Element)v.get(310)).setAttribute("ID","botonContenido" );
      ((Element)v.get(310)).setAttribute("img","retroceder_on" );
      ((Element)v.get(310)).setAttribute("tipo","0" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(310)).setAttribute("estado","false" );
      ((Element)v.get(310)).setAttribute("alt","" );
      ((Element)v.get(310)).setAttribute("codigo","" );
      ((Element)v.get(310)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 309   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(311)).setAttribute("nombre","ava2" );
      ((Element)v.get(311)).setAttribute("x","52" );
      ((Element)v.get(311)).setAttribute("y","805" );
      ((Element)v.get(311)).setAttribute("ID","botonContenido" );
      ((Element)v.get(311)).setAttribute("img","avanzar_on" );
      ((Element)v.get(311)).setAttribute("tipo","0" );
      ((Element)v.get(311)).setAttribute("estado","false" );
      ((Element)v.get(311)).setAttribute("alt","" );
      ((Element)v.get(311)).setAttribute("codigo","" );
      ((Element)v.get(311)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(309)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:309   */
      /* Termina nodo:271   */

      /* Empieza nodo:312 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(312)).setAttribute("nombre","primera2" );
      ((Element)v.get(312)).setAttribute("x","20" );
      ((Element)v.get(312)).setAttribute("y","805" );
      ((Element)v.get(312)).setAttribute("ID","botonContenido" );
      ((Element)v.get(312)).setAttribute("img","primera_on" );
      ((Element)v.get(312)).setAttribute("tipo","0" );
      ((Element)v.get(312)).setAttribute("estado","false" );
      ((Element)v.get(312)).setAttribute("alt","" );
      ((Element)v.get(312)).setAttribute("codigo","" );
      ((Element)v.get(312)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */

      /* Empieza nodo:313 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(313)).setAttribute("nombre","separa2" );
      ((Element)v.get(313)).setAttribute("x","59" );
      ((Element)v.get(313)).setAttribute("y","801" );
      ((Element)v.get(313)).setAttribute("ID","botonContenido" );
      ((Element)v.get(313)).setAttribute("img","separa_base" );
      ((Element)v.get(313)).setAttribute("tipo","0" );
      ((Element)v.get(313)).setAttribute("estado","false" );
      ((Element)v.get(313)).setAttribute("alt","" );
      ((Element)v.get(313)).setAttribute("codigo","" );
      ((Element)v.get(313)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */

      /* Empieza nodo:314 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(314)).setAttribute("nombre","Detalle2" );
      ((Element)v.get(314)).setAttribute("x","80" );
      ((Element)v.get(314)).setAttribute("y","802" );
      ((Element)v.get(314)).setAttribute("ID","botonContenido" );
      ((Element)v.get(314)).setAttribute("tipo","html" );
      ((Element)v.get(314)).setAttribute("accion","detalleOnClick();" );
      ((Element)v.get(314)).setAttribute("onshtab","focalizaShTab(3);" );
      ((Element)v.get(314)).setAttribute("estado","false" );
      ((Element)v.get(314)).setAttribute("cod","3" );
      ((Element)v.get(8)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */

      /* Empieza nodo:315 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(315)).setAttribute("nombre","CompromisoPago2" );
      ((Element)v.get(315)).setAttribute("x","128" );
      ((Element)v.get(315)).setAttribute("y","802" );
      ((Element)v.get(315)).setAttribute("ID","botonContenido" );
      ((Element)v.get(315)).setAttribute("tipo","html" );
      ((Element)v.get(315)).setAttribute("accion","compromisoPagoOnClick();" );
      ((Element)v.get(315)).setAttribute("ontab","focalizaTab(3);" );
      ((Element)v.get(315)).setAttribute("estado","false" );
      ((Element)v.get(315)).setAttribute("cod","2515" );
      ((Element)v.get(8)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */

      /* Empieza nodo:316 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(316)).setAttribute("nombre","capa3" );
      ((Element)v.get(316)).setAttribute("alto","30" );
      ((Element)v.get(316)).setAttribute("ancho","250" );
      ((Element)v.get(316)).setAttribute("colorf","" );
      ((Element)v.get(316)).setAttribute("borde","0" );
      ((Element)v.get(316)).setAttribute("imagenf","" );
      ((Element)v.get(316)).setAttribute("repeat","" );
      ((Element)v.get(316)).setAttribute("padding","" );
      ((Element)v.get(316)).setAttribute("visibilidad","" );
      ((Element)v.get(316)).setAttribute("contravsb","" );
      ((Element)v.get(316)).setAttribute("x","167" );
      ((Element)v.get(316)).setAttribute("y","461" );
      ((Element)v.get(316)).setAttribute("zindex","" );
      ((Element)v.get(8)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("table"));
      ((Element)v.get(317)).setAttribute("width","100%" );
      ((Element)v.get(317)).setAttribute("border","0" );
      ((Element)v.get(317)).setAttribute("cellspacing","0" );
      ((Element)v.get(317)).setAttribute("cellpadding","0" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(320)).setAttribute("nombre","cbEjecucion" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(320)).setAttribute("id","datosCampos" );
      ((Element)v.get(320)).setAttribute("size","1" );
      ((Element)v.get(320)).setAttribute("multiple","N" );
      ((Element)v.get(320)).setAttribute("req","N" );
      ((Element)v.get(320)).setAttribute("ontab","focalizaTab(5);" );
      ((Element)v.get(320)).setAttribute("onshtab","focalizaShTab(5);" );
      ((Element)v.get(320)).setAttribute("valorinicial","" );
      ((Element)v.get(320)).setAttribute("textoinicial","" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:318   */
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:322 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(322)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(322)).setAttribute("alto","12" );
      ((Element)v.get(322)).setAttribute("ancho","50" );
      ((Element)v.get(322)).setAttribute("colorf","" );
      ((Element)v.get(322)).setAttribute("borde","0" );
      ((Element)v.get(322)).setAttribute("imagenf","" );
      ((Element)v.get(322)).setAttribute("repeat","" );
      ((Element)v.get(322)).setAttribute("padding","" );
      ((Element)v.get(322)).setAttribute("visibilidad","visible" );
      ((Element)v.get(322)).setAttribute("contravsb","" );
      ((Element)v.get(322)).setAttribute("x","0" );
      ((Element)v.get(322)).setAttribute("y","824" );
      ((Element)v.get(322)).setAttribute("zindex","" );
      ((Element)v.get(8)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:8   */

      /* Empieza nodo:323 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(323)).setAttribute("nombre","frmFormularioEnviar" );
      ((Element)v.get(323)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(324)).setAttribute("nombre","accion" );
      ((Element)v.get(324)).setAttribute("valor","" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */

      /* Empieza nodo:325 / Elemento padre: 323   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(325)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(325)).setAttribute("valor","" );
      ((Element)v.get(323)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 323   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(326)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(326)).setAttribute("valor","" );
      ((Element)v.get(323)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */

      /* Empieza nodo:327 / Elemento padre: 323   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(327)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(327)).setAttribute("valor","" );
      ((Element)v.get(323)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:323   */


   }

}

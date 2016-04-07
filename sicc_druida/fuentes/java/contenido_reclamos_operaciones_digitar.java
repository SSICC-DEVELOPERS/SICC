
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_reclamos_operaciones_digitar  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML1620(doc);
         

      getXML1710(doc);
         

      getXML1800(doc);
         

      getXML1890(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_reclamos_operaciones_digitar" );
      ((Element)v.get(0)).setAttribute("cod","0139" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("STYLE"));
      ((Element)v.get(1)).setAttribute("TYPE","text/css" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r   \r\r#Cplistado1{visibility:hidden;}\r#CpLin1listado1{visibility:hidden;}\r#CpLin2listado1{visibility:hidden;}\r#CpLin3listado1{visibility:hidden;}\r#CpLin4listado1{visibility:hidden;}\r#capa1{visibility:hidden;}\r\r\r#Cplistado2{visibility:hidden;}\r#CpLin1listado2{visibility:hidden;}\r#CpLin2listado2{visibility:hidden;}\r#CpLin3listado2{visibility:hidden;}\r#CpLin4listado2{visibility:hidden;}\r#capa2{visibility:hidden;}\r#AceptarDiv{visibility:hidden;}\r\r   \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(4)).setAttribute("name","txtCodDocRef" );
      ((Element)v.get(4)).setAttribute("required","true" );
      ((Element)v.get(4)).setAttribute("group","cabecera" );
      ((Element)v.get(4)).setAttribute("cod","295" );
      ((Element)v.get(3)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","txtCodCliente" );
      ((Element)v.get(5)).setAttribute("required","true" );
      ((Element)v.get(5)).setAttribute("group","cabecera" );
      ((Element)v.get(5)).setAttribute("cod","263" );
      ((Element)v.get(3)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","cbTipoMov" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","304" );
      ((Element)v.get(6)).setAttribute("group","linea" );
      ((Element)v.get(3)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","txtCodVenta" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","336" );
      ((Element)v.get(7)).setAttribute("group","linea" );
      ((Element)v.get(3)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtNUniReclamadas" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","339" );
      ((Element)v.get(8)).setAttribute("group","linea" );
      ((Element)v.get(3)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbCodOperacion" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","299" );
      ((Element)v.get(9)).setAttribute("group","operacion" );
      ((Element)v.get(3)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbCodTipoOperacion" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","301" );
      ((Element)v.get(10)).setAttribute("group","operacion" );
      ((Element)v.get(3)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:3   */

      /* Empieza nodo:11 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(11)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(12)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(13)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(14)).setAttribute("src","contenido_reclamos_operaciones_digitar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 0   */
      v.add(doc.createElement("MATRIZJS"));
      ((Element)v.get(15)).setAttribute("nombre","codigosOperacion" );
      ((Element)v.get(0)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */
      /* Termina nodo:15   */

      /* Empieza nodo:17 / Elemento padre: 0   */
      v.add(doc.createElement("MATRIZJS"));
      ((Element)v.get(17)).setAttribute("nombre","operacionesAnulacion" );
      ((Element)v.get(0)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(17)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:19 / Elemento padre: 0   */
      v.add(doc.createElement("MATRIZJS"));
      ((Element)v.get(19)).setAttribute("nombre","lineasDeOperacionModificacion" );
      ((Element)v.get(0)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:21 / Elemento padre: 0   */
      v.add(doc.createElement("MATRIZJS"));
      ((Element)v.get(21)).setAttribute("nombre","TipoLineaOperacion" );
      ((Element)v.get(0)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("ROWSET"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:23 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(23)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(23)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 23   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(23)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 23   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(23)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 23   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(23)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 23   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","accion" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(23)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 23   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","idioma" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(23)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 23   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","pais" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(23)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 23   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","casoUso" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(23)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 23   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","numDigitosCodigoCliente" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(23)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 23   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","operacionesReclamo" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(23)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 23   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","lineasOperacion" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(23)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 23   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","asumeSeguro" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(23)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 23   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","numeroOperacion" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(23)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 23   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hid_SeparadorMiles" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(23)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 23   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hid_SeparadorDecimales" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(23)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 23   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hid_NumeroDecimales" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(23)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 23   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","codigosOperacion" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(23)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 23   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","numeroLinea" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(23)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 23   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","modificacionDigitados" );
      ((Element)v.get(42)).setAttribute("valor","false" );
      ((Element)v.get(23)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 23   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(43)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(43)).setAttribute("x","0" );
      ((Element)v.get(43)).setAttribute("y","0" );
      ((Element)v.get(23)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("table"));
      ((Element)v.get(44)).setAttribute("width","100%" );
      ((Element)v.get(44)).setAttribute("border","0" );
      ((Element)v.get(44)).setAttribute("cellspacing","0" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(44)).setAttribute("cellpadding","0" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("width","12" );
      ((Element)v.get(46)).setAttribute("align","center" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","12" );
      ((Element)v.get(47)).setAttribute("height","12" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","750" );
      ((Element)v.get(45)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("width","12" );
      ((Element)v.get(45)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","12" );
      ((Element)v.get(51)).setAttribute("height","1" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:45   */

      /* Empieza nodo:52 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(57)).setAttribute("class","legend" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(58)).setAttribute("nombre","lblDatosCabecera" );
      ((Element)v.get(58)).setAttribute("alto","13" );
      ((Element)v.get(58)).setAttribute("filas","1" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(58)).setAttribute("id","legend" );
      ((Element)v.get(58)).setAttribute("cod","00156" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 56   */
      v.add(doc.createElement("table"));
      ((Element)v.get(59)).setAttribute("width","100%" );
      ((Element)v.get(59)).setAttribute("border","0" );
      ((Element)v.get(59)).setAttribute("align","center" );
      ((Element)v.get(59)).setAttribute("cellspacing","0" );
      ((Element)v.get(59)).setAttribute("cellpadding","0" );
      ((Element)v.get(56)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("table"));
      ((Element)v.get(62)).setAttribute("width","665" );
      ((Element)v.get(62)).setAttribute("border","0" );
      ((Element)v.get(62)).setAttribute("align","left" );
      ((Element)v.get(62)).setAttribute("cellspacing","0" );
      ((Element)v.get(62)).setAttribute("cellpadding","0" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("colspan","4" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","8" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:66 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(70)).setAttribute("nombre","lblCodDocRef" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(70)).setAttribute("alto","13" );
      ((Element)v.get(70)).setAttribute("filas","1" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(70)).setAttribute("id","datosTitle" );
      ((Element)v.get(70)).setAttribute("cod","295" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","25" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("colspan","3" );
      ((Element)v.get(66)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(74)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("filas","1" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(74)).setAttribute("id","datosTitle" );
      ((Element)v.get(74)).setAttribute("cod","263" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","25" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(78)).setAttribute("nombre","lblNumeroReclamo" );
      ((Element)v.get(78)).setAttribute("alto","13" );
      ((Element)v.get(78)).setAttribute("filas","1" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(78)).setAttribute("id","datosTitle" );
      ((Element)v.get(78)).setAttribute("cod","396" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("width","100%" );
      ((Element)v.get(66)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","8" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:66   */

      /* Empieza nodo:81 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","8" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(81)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(85)).setAttribute("nombre","txtCodDocRef" );
      ((Element)v.get(85)).setAttribute("id","datosCampos" );
      ((Element)v.get(85)).setAttribute("max","10" );
      ((Element)v.get(85)).setAttribute("tipo","" );
      ((Element)v.get(85)).setAttribute("onshtab","onshtabCodRefe();" );
      ((Element)v.get(85)).setAttribute("onblur","validarNumerico('txtCodDocRef');" );
      ((Element)v.get(85)).setAttribute("onchange","" );
      ((Element)v.get(85)).setAttribute("req","S" );
      ((Element)v.get(85)).setAttribute("size","13" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(85)).setAttribute("validacion","" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","25" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(81)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(89)).setAttribute("nombre","txtCodCliente" );
      ((Element)v.get(89)).setAttribute("id","datosCampos" );
      ((Element)v.get(89)).setAttribute("max","15" );
      ((Element)v.get(89)).setAttribute("tipo","" );
      ((Element)v.get(89)).setAttribute("onblur","codigoClienteOnBlur('txtCodCliente');" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(89)).setAttribute("onchange","" );
      ((Element)v.get(89)).setAttribute("req","S" );
      ((Element)v.get(89)).setAttribute("size","19" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(89)).setAttribute("validacion","" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(93)).setAttribute("onclick","iconoCliente('txtCodCliente');" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","25" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("valign","bottom" );
      ((Element)v.get(81)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(97)).setAttribute("nombre","txtNumeroReclamo" );
      ((Element)v.get(97)).setAttribute("id","datosCampos" );
      ((Element)v.get(97)).setAttribute("max","9" );
      ((Element)v.get(97)).setAttribute("tipo","" );
      ((Element)v.get(97)).setAttribute("onblur","validarNumerico('txtNumeroReclamo');" );
      ((Element)v.get(97)).setAttribute("onchange","" );
      ((Element)v.get(97)).setAttribute("req","N" );
      ((Element)v.get(97)).setAttribute("size","11" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(97)).setAttribute("validacion","" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("width","100%" );
      ((Element)v.get(81)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","8" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:81   */

      /* Empieza nodo:100 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("colspan","4" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","8" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:103 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:52   */

      /* Empieza nodo:105 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("table"));
      ((Element)v.get(110)).setAttribute("width","100%" );
      ((Element)v.get(110)).setAttribute("border","0" );
      ((Element)v.get(110)).setAttribute("align","center" );
      ((Element)v.get(110)).setAttribute("cellspacing","0" );
      ((Element)v.get(110)).setAttribute("cellpadding","0" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("class","botonera" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(113)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(113)).setAttribute("ID","botonContenido" );
      ((Element)v.get(113)).setAttribute("tipo","html" );
      ((Element)v.get(113)).setAttribute("accion","aceptarOnClick();" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(113)).setAttribute("ontab","aceptarOntab();" );
      ((Element)v.get(113)).setAttribute("estado","false" );
      ((Element)v.get(113)).setAttribute("cod","12" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:114 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","12" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:105   */

      /* Empieza nodo:116 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("width","12" );
      ((Element)v.get(117)).setAttribute("align","center" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","12" );
      ((Element)v.get(118)).setAttribute("height","12" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("width","750" );
      ((Element)v.get(116)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("width","12" );
      ((Element)v.get(116)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","12" );
      ((Element)v.get(122)).setAttribute("height","1" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:116   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:123 / Elemento padre: 23   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(123)).setAttribute("nombre","capa1" );
      ((Element)v.get(123)).setAttribute("alto","150" );
      ((Element)v.get(123)).setAttribute("ancho","100%" );
      ((Element)v.get(123)).setAttribute("colorf","" );
      ((Element)v.get(123)).setAttribute("borde","0" );
      ((Element)v.get(123)).setAttribute("imagenf","" );
      ((Element)v.get(123)).setAttribute("repeat","" );
      ((Element)v.get(123)).setAttribute("padding","" );
      ((Element)v.get(123)).setAttribute("visibilidad","visible" );
      ((Element)v.get(123)).setAttribute("contravsb","" );
      ((Element)v.get(123)).setAttribute("x","0" );
      ((Element)v.get(123)).setAttribute("y","95" );
      ((Element)v.get(123)).setAttribute("zindex","" );
      ((Element)v.get(23)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("table"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(124)).setAttribute("border","0" );
      ((Element)v.get(124)).setAttribute("cellspacing","0" );
      ((Element)v.get(124)).setAttribute("cellpadding","0" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("width","12" );
      ((Element)v.get(126)).setAttribute("align","center" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","12" );
      ((Element)v.get(127)).setAttribute("height","12" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("width","750" );
      ((Element)v.get(125)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("width","12" );
      ((Element)v.get(125)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","12" );
      ((Element)v.get(131)).setAttribute("height","1" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:125   */

      /* Empieza nodo:132 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(132)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(137)).setAttribute("class","legend" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(138)).setAttribute("nombre","lblDatos" );
      ((Element)v.get(138)).setAttribute("alto","13" );
      ((Element)v.get(138)).setAttribute("filas","1" );
      ((Element)v.get(138)).setAttribute("valor","" );
      ((Element)v.get(138)).setAttribute("id","legend" );
      ((Element)v.get(138)).setAttribute("cod","00298" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("table"));
      ((Element)v.get(139)).setAttribute("width","100%" );
      ((Element)v.get(139)).setAttribute("border","0" );
      ((Element)v.get(139)).setAttribute("align","center" );
      ((Element)v.get(139)).setAttribute("cellspacing","0" );
      ((Element)v.get(139)).setAttribute("cellpadding","0" );
      ((Element)v.get(136)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("table"));
      ((Element)v.get(142)).setAttribute("width","665" );
      ((Element)v.get(142)).setAttribute("border","0" );
      ((Element)v.get(142)).setAttribute("align","left" );
      ((Element)v.get(142)).setAttribute("cellspacing","0" );
      ((Element)v.get(142)).setAttribute("cellpadding","0" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("colspan","4" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","8" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:146 / Elemento padre: 142   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(142)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","8" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(150)).setAttribute("nombre","lblCodOperacion" );
      ((Element)v.get(150)).setAttribute("alto","13" );
      ((Element)v.get(150)).setAttribute("filas","1" );
      ((Element)v.get(150)).setAttribute("valor","" );
      ((Element)v.get(150)).setAttribute("id","datosTitle" );
      ((Element)v.get(150)).setAttribute("cod","299" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","25" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(154)).setAttribute("nombre","lblCodTipoOperacion" );
      ((Element)v.get(154)).setAttribute("alto","13" );
      ((Element)v.get(154)).setAttribute("filas","1" );
      ((Element)v.get(154)).setAttribute("valor","" );
      ((Element)v.get(154)).setAttribute("id","datosTitle" );
      ((Element)v.get(154)).setAttribute("cod","301" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","25" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(158)).setAttribute("nombre","lblNOperacion" );
      ((Element)v.get(158)).setAttribute("alto","13" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(158)).setAttribute("filas","1" );
      ((Element)v.get(158)).setAttribute("valor","" );
      ((Element)v.get(158)).setAttribute("id","datosTitle" );
      ((Element)v.get(158)).setAttribute("cod","401" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","25" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).setAttribute("colspan","3" );
      ((Element)v.get(146)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(162)).setAttribute("nombre","lblCodCliResponsable" );
      ((Element)v.get(162)).setAttribute("alto","13" );
      ((Element)v.get(162)).setAttribute("filas","1" );
      ((Element)v.get(162)).setAttribute("valor","" );
      ((Element)v.get(162)).setAttribute("id","datosTitle" );
      ((Element)v.get(162)).setAttribute("cod","412" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("width","100%" );
      ((Element)v.get(146)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","8" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(168)).setAttribute("nombre","lblAsumePerdida" );
      ((Element)v.get(168)).setAttribute("alto","13" );
      ((Element)v.get(168)).setAttribute("filas","1" );
      ((Element)v.get(168)).setAttribute("valor","" );
      ((Element)v.get(168)).setAttribute("id","datosTitle" );
      ((Element)v.get(168)).setAttribute("cod","343" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","25" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(172)).setAttribute("nombre","lblMontoArt" );
      ((Element)v.get(172)).setAttribute("alto","13" );
      ((Element)v.get(172)).setAttribute("filas","1" );
      ((Element)v.get(172)).setAttribute("valor","" );
      ((Element)v.get(172)).setAttribute("id","datosTitle" );
      ((Element)v.get(172)).setAttribute("cod","414" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","25" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(176)).setAttribute("nombre","lblCodArtPagado" );
      ((Element)v.get(176)).setAttribute("alto","13" );
      ((Element)v.get(176)).setAttribute("filas","1" );
      ((Element)v.get(176)).setAttribute("valor","" );
      ((Element)v.get(176)).setAttribute("id","datosTitle" );
      ((Element)v.get(176)).setAttribute("cod","413" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","25" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(179)).setAttribute("colspan","3" );
      ((Element)v.get(146)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(180)).setAttribute("nombre","lblCodClienteSeguro" );
      ((Element)v.get(180)).setAttribute("alto","13" );
      ((Element)v.get(180)).setAttribute("filas","1" );
      ((Element)v.get(180)).setAttribute("valor","" );
      ((Element)v.get(180)).setAttribute("id","datosTitle" );
      ((Element)v.get(180)).setAttribute("cod","2764" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).setAttribute("width","100%" );
      ((Element)v.get(146)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","8" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:146   */

      /* Empieza nodo:183 / Elemento padre: 142   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(142)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","8" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(183)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(187)).setAttribute("nombre","cbCodOperacion" );
      ((Element)v.get(187)).setAttribute("id","datosCampos" );
      ((Element)v.get(187)).setAttribute("size","1" );
      ((Element)v.get(187)).setAttribute("multiple","N" );
      ((Element)v.get(187)).setAttribute("onshtab","focalizaAnteriorCodOperacion();" );
      ((Element)v.get(187)).setAttribute("onchange","cbOperacion_onChange();" );
      ((Element)v.get(187)).setAttribute("req","S" );
      ((Element)v.get(187)).setAttribute("valorinicial","" );
      ((Element)v.get(187)).setAttribute("textoinicial","" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:189 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","25" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(183)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(192)).setAttribute("nombre","cbCodTipoOperacion" );
      ((Element)v.get(192)).setAttribute("id","datosCampos" );
      ((Element)v.get(192)).setAttribute("size","1" );
      ((Element)v.get(192)).setAttribute("multiple","N" );
      ((Element)v.get(192)).setAttribute("req","S" );
      ((Element)v.get(192)).setAttribute("valorinicial","" );
      ((Element)v.get(192)).setAttribute("textoinicial","" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:194 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","25" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(197)).setAttribute("nombre","lblNOperacionX" );
      ((Element)v.get(197)).setAttribute("alto","13" );
      ((Element)v.get(197)).setAttribute("filas","1" );
      ((Element)v.get(197)).setAttribute("valor","" );
      ((Element)v.get(197)).setAttribute("id","datosCampos" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).setAttribute("width","25" );
      ((Element)v.get(199)).setAttribute("height","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("CTEXTO"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(201)).setAttribute("nombre","txtCodCliResponsable" );
      ((Element)v.get(201)).setAttribute("id","datosCampos" );
      ((Element)v.get(201)).setAttribute("max","15" );
      ((Element)v.get(201)).setAttribute("tipo","" );
      ((Element)v.get(201)).setAttribute("onblur","codigoClienteOnBlur('txtCodCliResponsable');" );
      ((Element)v.get(201)).setAttribute("onchange","" );
      ((Element)v.get(201)).setAttribute("req","N" );
      ((Element)v.get(201)).setAttribute("size","19" );
      ((Element)v.get(201)).setAttribute("valor","" );
      ((Element)v.get(201)).setAttribute("validacion","" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","8" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(205)).setAttribute("onclick","iconoCliente('txtCodCliResponsable');" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).setAttribute("width","100%" );
      ((Element)v.get(183)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","8" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(211)).setAttribute("nombre","cbAsumePerdida" );
      ((Element)v.get(211)).setAttribute("id","datosCampos" );
      ((Element)v.get(211)).setAttribute("size","1" );
      ((Element)v.get(211)).setAttribute("multiple","N" );
      ((Element)v.get(211)).setAttribute("onchange","cbAsumePerdida_onChange();" );
      ((Element)v.get(211)).setAttribute("req","N" );
      ((Element)v.get(211)).setAttribute("valorinicial","" );
      ((Element)v.get(211)).setAttribute("textoinicial","" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:213 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","25" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(216)).setAttribute("nombre","txtMontoArt" );
      ((Element)v.get(216)).setAttribute("id","datosCampos" );
      ((Element)v.get(216)).setAttribute("max","10" );
      ((Element)v.get(216)).setAttribute("tipo","" );
      ((Element)v.get(216)).setAttribute("onblur","validaMonto('txtMontoArt', 6)" );
      ((Element)v.get(216)).setAttribute("onchange","" );
      ((Element)v.get(216)).setAttribute("req","N" );
      ((Element)v.get(216)).setAttribute("size","12" );
      ((Element)v.get(216)).setAttribute("valor","" );
      ((Element)v.get(216)).setAttribute("validacion","" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","25" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(220)).setAttribute("nombre","txtCodArtPagado" );
      ((Element)v.get(220)).setAttribute("id","datosCampos" );
      ((Element)v.get(220)).setAttribute("max","18" );
      ((Element)v.get(220)).setAttribute("tipo","" );
      ((Element)v.get(220)).setAttribute("onblur","mayusculas('txtCodArtPagado')" );
      ((Element)v.get(220)).setAttribute("onchange","" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(220)).setAttribute("req","N" );
      ((Element)v.get(220)).setAttribute("size","12" );
      ((Element)v.get(220)).setAttribute("valor","" );
      ((Element)v.get(220)).setAttribute("validacion","" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","25" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).setAttribute("valign","bottom" );
      ((Element)v.get(183)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(224)).setAttribute("nombre","txtCodClienteSeguro" );
      ((Element)v.get(224)).setAttribute("id","datosCampos" );
      ((Element)v.get(224)).setAttribute("max","15" );
      ((Element)v.get(224)).setAttribute("tipo","" );
      ((Element)v.get(224)).setAttribute("onblur","codigoClienteOnBlur('txtCodClienteSeguro');" );
      ((Element)v.get(224)).setAttribute("onchange","" );
      ((Element)v.get(224)).setAttribute("req","N" );
      ((Element)v.get(224)).setAttribute("size","19" );
      ((Element)v.get(224)).setAttribute("valor","" );
      ((Element)v.get(224)).setAttribute("validacion","" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).setAttribute("valign","bottom" );
      ((Element)v.get(183)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","8" );
      ((Element)v.get(226)).setAttribute("height","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).setAttribute("valign","bottom" );
      ((Element)v.get(183)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(228)).setAttribute("onclick","iconoCliente('txtCodClienteSeguro');" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).setAttribute("width","100%" );
      ((Element)v.get(183)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","8" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:183   */

      /* Empieza nodo:231 / Elemento padre: 142   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(142)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).setAttribute("colspan","4" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","8" );
      ((Element)v.get(233)).setAttribute("height","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:234 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:132   */

      /* Empieza nodo:236 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("table"));
      ((Element)v.get(241)).setAttribute("width","100%" );
      ((Element)v.get(241)).setAttribute("border","0" );
      ((Element)v.get(241)).setAttribute("align","center" );
      ((Element)v.get(241)).setAttribute("cellspacing","0" );
      ((Element)v.get(241)).setAttribute("cellpadding","0" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("class","botonera" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(244)).setAttribute("nombre","btnAnadirOperacion" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(244)).setAttribute("ID","botonContenido" );
      ((Element)v.get(244)).setAttribute("tipo","html" );
      ((Element)v.get(244)).setAttribute("accion","btnAnyadirOperacion_onClick();" );
      ((Element)v.get(244)).setAttribute("ontab","focalizaSiguienteAdd();" );
      ((Element)v.get(244)).setAttribute("estado","false" );
      ((Element)v.get(244)).setAttribute("cod","1793" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:245 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("width","8" );
      ((Element)v.get(246)).setAttribute("height","12" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:236   */

      /* Empieza nodo:247 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).setAttribute("width","12" );
      ((Element)v.get(248)).setAttribute("align","center" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","12" );
      ((Element)v.get(249)).setAttribute("height","12" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("width","750" );
      ((Element)v.get(247)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).setAttribute("width","12" );
      ((Element)v.get(247)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","12" );
      ((Element)v.get(253)).setAttribute("height","1" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:247   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:254 / Elemento padre: 23   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(254)).setAttribute("nombre","listado1" );
      ((Element)v.get(254)).setAttribute("ancho","669" );
      ((Element)v.get(254)).setAttribute("alto","120" );
      ((Element)v.get(254)).setAttribute("x","12" );
      ((Element)v.get(254)).setAttribute("y","200" );
      ((Element)v.get(254)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(254)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(23)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(255)).setAttribute("precarga","S" );
      ((Element)v.get(255)).setAttribute("conROver","S" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(256)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(256)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(256)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(256)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 255   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(257)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(257)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(257)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(257)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(255)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 255   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(258)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(258)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(255)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:255   */

      /* Empieza nodo:259 / Elemento padre: 254   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(254)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(260)).setAttribute("borde","1" );
      ((Element)v.get(260)).setAttribute("horizDatos","1" );
      ((Element)v.get(260)).setAttribute("horizCabecera","1" );
      ((Element)v.get(260)).setAttribute("vertical","1" );
      ((Element)v.get(260)).setAttribute("horizTitulo","1" );
      ((Element)v.get(260)).setAttribute("horizBase","1" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 259   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(261)).setAttribute("borde","#999999" );
      ((Element)v.get(261)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(261)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(261)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(261)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(261)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(261)).setAttribute("horizBase","#999999" );
      ((Element)v.get(259)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:259   */

      /* Empieza nodo:262 / Elemento padre: 254   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(262)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(262)).setAttribute("alto","22" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(262)).setAttribute("imgFondo","" );
      ((Element)v.get(262)).setAttribute("cod","00291" );
      ((Element)v.get(262)).setAttribute("ID","datosTitle" );
      ((Element)v.get(254)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 254   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(263)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(263)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(263)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(263)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(263)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(263)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(254)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(264)).setAttribute("ancho","90" );
      ((Element)v.get(264)).setAttribute("minimizable","S" );
      ((Element)v.get(264)).setAttribute("minimizada","N" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("ancho","60" );
      ((Element)v.get(265)).setAttribute("minimizable","S" );
      ((Element)v.get(265)).setAttribute("minimizada","N" );
      ((Element)v.get(263)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(266)).setAttribute("ancho","120" );
      ((Element)v.get(266)).setAttribute("minimizable","S" );
      ((Element)v.get(266)).setAttribute("minimizada","N" );
      ((Element)v.get(263)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(267)).setAttribute("ancho","120" );
      ((Element)v.get(267)).setAttribute("minimizable","S" );
      ((Element)v.get(267)).setAttribute("minimizada","N" );
      ((Element)v.get(267)).setAttribute("oculta","S" );
      ((Element)v.get(263)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("ancho","120" );
      ((Element)v.get(268)).setAttribute("minimizable","S" );
      ((Element)v.get(268)).setAttribute("minimizada","N" );
      ((Element)v.get(268)).setAttribute("oculta","S" );
      ((Element)v.get(263)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("ancho","120" );
      ((Element)v.get(269)).setAttribute("minimizable","S" );
      ((Element)v.get(269)).setAttribute("minimizada","N" );
      ((Element)v.get(269)).setAttribute("oculta","S" );
      ((Element)v.get(263)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("ancho","120" );
      ((Element)v.get(270)).setAttribute("minimizable","S" );
      ((Element)v.get(270)).setAttribute("minimizada","N" );
      ((Element)v.get(270)).setAttribute("oculta","S" );
      ((Element)v.get(263)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(271)).setAttribute("ancho","120" );
      ((Element)v.get(271)).setAttribute("minimizable","S" );
      ((Element)v.get(271)).setAttribute("minimizada","N" );
      ((Element)v.get(271)).setAttribute("oculta","S" );
      ((Element)v.get(263)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("ancho","120" );
      ((Element)v.get(272)).setAttribute("minimizable","S" );
      ((Element)v.get(272)).setAttribute("minimizada","N" );
      ((Element)v.get(272)).setAttribute("oculta","S" );
      ((Element)v.get(263)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:263   */

      /* Empieza nodo:273 / Elemento padre: 254   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(273)).setAttribute("alto","20" );
      ((Element)v.get(273)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(273)).setAttribute("imgFondo","" );
      ((Element)v.get(273)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(254)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("colFondo","" );
      ((Element)v.get(274)).setAttribute("ID","EstCab" );
      ((Element)v.get(274)).setAttribute("cod","401" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 273   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("colFondo","" );
      ((Element)v.get(275)).setAttribute("ID","EstCab" );
      ((Element)v.get(275)).setAttribute("cod","299" );
      ((Element)v.get(273)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 273   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("colFondo","" );
      ((Element)v.get(276)).setAttribute("ID","EstCab" );
      ((Element)v.get(276)).setAttribute("cod","301" );
      ((Element)v.get(273)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 273   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("colFondo","" );
      ((Element)v.get(277)).setAttribute("ID","EstCab" );
      ((Element)v.get(277)).setAttribute("cod","301" );
      ((Element)v.get(273)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 273   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(278)).setAttribute("colFondo","" );
      ((Element)v.get(278)).setAttribute("ID","EstCab" );
      ((Element)v.get(278)).setAttribute("cod","301" );
      ((Element)v.get(273)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 273   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("colFondo","" );
      ((Element)v.get(279)).setAttribute("ID","EstCab" );
      ((Element)v.get(279)).setAttribute("cod","301" );
      ((Element)v.get(273)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 273   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("colFondo","" );
      ((Element)v.get(280)).setAttribute("ID","EstCab" );
      ((Element)v.get(280)).setAttribute("cod","301" );
      ((Element)v.get(273)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 273   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(281)).setAttribute("colFondo","" );
      ((Element)v.get(281)).setAttribute("ID","EstCab" );
      ((Element)v.get(281)).setAttribute("cod","301" );
      ((Element)v.get(273)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 273   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(282)).setAttribute("colFondo","" );
      ((Element)v.get(282)).setAttribute("ID","EstCab" );
      ((Element)v.get(282)).setAttribute("cod","301" );
      ((Element)v.get(273)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:273   */

      /* Empieza nodo:283 / Elemento padre: 254   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(283)).setAttribute("alto","22" );
      ((Element)v.get(283)).setAttribute("accion","modificarOperacion();" );
      ((Element)v.get(283)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(283)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(283)).setAttribute("maxSel","1" );
      ((Element)v.get(283)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(283)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(283)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(283)).setAttribute("onLoad","" );
      ((Element)v.get(283)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(283)).setAttribute("deseleccionaSiMaxSel","S" );
      ((Element)v.get(254)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("tipo","texto" );
      ((Element)v.get(284)).setAttribute("ID","EstDat" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("tipo","texto" );
      ((Element)v.get(285)).setAttribute("ID","EstDat2" );
      ((Element)v.get(283)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(286)).setAttribute("tipo","texto" );
      ((Element)v.get(286)).setAttribute("ID","EstDat" );
      ((Element)v.get(283)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(287)).setAttribute("tipo","texto" );
      ((Element)v.get(287)).setAttribute("ID","EstDat" );
      ((Element)v.get(283)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(288)).setAttribute("tipo","texto" );
      ((Element)v.get(288)).setAttribute("ID","EstDat" );
      ((Element)v.get(283)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(289)).setAttribute("tipo","texto" );
      ((Element)v.get(289)).setAttribute("ID","EstDat" );
      ((Element)v.get(283)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(290)).setAttribute("tipo","texto" );
      ((Element)v.get(290)).setAttribute("ID","EstDat" );
      ((Element)v.get(283)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(291)).setAttribute("tipo","texto" );
      ((Element)v.get(291)).setAttribute("ID","EstDat" );
      ((Element)v.get(283)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("tipo","texto" );
      ((Element)v.get(292)).setAttribute("ID","EstDat" );
      ((Element)v.get(283)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:283   */

      /* Empieza nodo:293 / Elemento padre: 254   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(254)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:254   */

      /* Empieza nodo:294 / Elemento padre: 23   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(294)).setAttribute("nombre","capa2" );
      ((Element)v.get(294)).setAttribute("alto","150" );
      ((Element)v.get(294)).setAttribute("ancho","100%" );
      ((Element)v.get(294)).setAttribute("colorf","" );
      ((Element)v.get(294)).setAttribute("borde","0" );
      ((Element)v.get(294)).setAttribute("imagenf","" );
      ((Element)v.get(294)).setAttribute("repeat","" );
      ((Element)v.get(294)).setAttribute("padding","" );
      ((Element)v.get(294)).setAttribute("visibilidad","visible" );
      ((Element)v.get(294)).setAttribute("contravsb","" );
      ((Element)v.get(294)).setAttribute("x","0" );
      ((Element)v.get(294)).setAttribute("y","320" );
      ((Element)v.get(294)).setAttribute("zindex","" );
      ((Element)v.get(23)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("table"));
      ((Element)v.get(295)).setAttribute("width","100%" );
      ((Element)v.get(295)).setAttribute("border","0" );
      ((Element)v.get(295)).setAttribute("cellspacing","0" );
      ((Element)v.get(295)).setAttribute("cellpadding","0" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(295)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).setAttribute("width","12" );
      ((Element)v.get(297)).setAttribute("align","center" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).setAttribute("width","12" );
      ((Element)v.get(298)).setAttribute("height","12" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 296   */
      v.add(doc.createElement("td"));
      ((Element)v.get(299)).setAttribute("width","750" );
      ((Element)v.get(296)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(300)).setAttribute("src","b.gif" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 296   */
      v.add(doc.createElement("td"));
      ((Element)v.get(301)).setAttribute("width","12" );
      ((Element)v.get(296)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","12" );
      ((Element)v.get(302)).setAttribute("height","1" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */
      /* Termina nodo:296   */

      /* Empieza nodo:303 / Elemento padre: 295   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(295)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(306)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(308)).setAttribute("class","legend" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(309)).setAttribute("nombre","lblDatosLineasOperacion" );
      ((Element)v.get(309)).setAttribute("alto","13" );
      ((Element)v.get(309)).setAttribute("filas","1" );
      ((Element)v.get(309)).setAttribute("valor","" );
      ((Element)v.get(309)).setAttribute("id","legend" );
      ((Element)v.get(309)).setAttribute("cod","00538" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 307   */
      v.add(doc.createElement("table"));
      ((Element)v.get(310)).setAttribute("width","100%" );
      ((Element)v.get(310)).setAttribute("border","0" );
      ((Element)v.get(310)).setAttribute("align","center" );
      ((Element)v.get(310)).setAttribute("cellspacing","0" );
      ((Element)v.get(310)).setAttribute("cellpadding","0" );
      ((Element)v.get(307)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("table"));
      ((Element)v.get(313)).setAttribute("width","629" );
      ((Element)v.get(313)).setAttribute("border","0" );
      ((Element)v.get(313)).setAttribute("align","left" );
      ((Element)v.get(313)).setAttribute("cellspacing","0" );
      ((Element)v.get(313)).setAttribute("cellpadding","0" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(313)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).setAttribute("colspan","4" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","8" );
      ((Element)v.get(316)).setAttribute("height","8" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:317 / Elemento padre: 313   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(313)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(319)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).setAttribute("width","8" );
      ((Element)v.get(319)).setAttribute("height","8" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 317   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(321)).setAttribute("nombre","lblNumeroLinea" );
      ((Element)v.get(321)).setAttribute("alto","13" );
      ((Element)v.get(321)).setAttribute("filas","1" );
      ((Element)v.get(321)).setAttribute("valor","" );
      ((Element)v.get(321)).setAttribute("id","datosTitle" );
      ((Element)v.get(321)).setAttribute("cod","402" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:322 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","25" );
      ((Element)v.get(323)).setAttribute("height","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(325)).setAttribute("nombre","lblTipoMov" );
      ((Element)v.get(325)).setAttribute("alto","13" );
      ((Element)v.get(325)).setAttribute("filas","1" );
      ((Element)v.get(325)).setAttribute("valor","" );
      ((Element)v.get(325)).setAttribute("id","datosTitle" );
      ((Element)v.get(325)).setAttribute("cod","304" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(327)).setAttribute("src","b.gif" );
      ((Element)v.get(327)).setAttribute("width","25" );
      ((Element)v.get(327)).setAttribute("height","8" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(329)).setAttribute("nombre","lblCodVenta" );
      ((Element)v.get(329)).setAttribute("alto","13" );
      ((Element)v.get(329)).setAttribute("filas","1" );
      ((Element)v.get(329)).setAttribute("valor","" );
      ((Element)v.get(329)).setAttribute("id","datosTitle" );
      ((Element)v.get(329)).setAttribute("cod","336" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","25" );
      ((Element)v.get(331)).setAttribute("height","8" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(333)).setAttribute("nombre","lblUniReclamadas" );
      ((Element)v.get(333)).setAttribute("alto","13" );
      ((Element)v.get(333)).setAttribute("filas","1" );
      ((Element)v.get(333)).setAttribute("valor","" );
      ((Element)v.get(333)).setAttribute("id","datosTitle" );
      ((Element)v.get(333)).setAttribute("cod","339" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */

      /* Empieza nodo:334 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(335)).setAttribute("src","b.gif" );
      ((Element)v.get(335)).setAttribute("width","25" );
      ((Element)v.get(335)).setAttribute("height","8" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:336 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(337)).setAttribute("nombre","lblNUniDevueltas" );
      ((Element)v.get(337)).setAttribute("alto","13" );
      ((Element)v.get(337)).setAttribute("filas","1" );
      ((Element)v.get(337)).setAttribute("valor","" );
      ((Element)v.get(337)).setAttribute("id","datosTitle" );
      ((Element)v.get(337)).setAttribute("cod","309" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:338 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(338)).setAttribute("width","100%" );
      ((Element)v.get(317)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(339)).setAttribute("src","b.gif" );
      ((Element)v.get(339)).setAttribute("width","8" );
      ((Element)v.get(339)).setAttribute("height","8" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:338   */

      /* Empieza nodo:340 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(341)).setAttribute("src","b.gif" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(341)).setAttribute("width","8" );
      ((Element)v.get(341)).setAttribute("height","8" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:342 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(343)).setAttribute("nombre","lblMotivoDev" );
      ((Element)v.get(343)).setAttribute("alto","13" );
      ((Element)v.get(343)).setAttribute("filas","1" );
      ((Element)v.get(343)).setAttribute("valor","" );
      ((Element)v.get(343)).setAttribute("id","datosTitle" );
      ((Element)v.get(343)).setAttribute("cod","302" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).setAttribute("width","100%" );
      ((Element)v.get(317)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(345)).setAttribute("src","b.gif" );
      ((Element)v.get(345)).setAttribute("width","8" );
      ((Element)v.get(345)).setAttribute("height","8" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */
      /* Termina nodo:317   */

      /* Empieza nodo:346 / Elemento padre: 313   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(313)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(348)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).setAttribute("width","8" );
      ((Element)v.get(348)).setAttribute("height","8" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(350)).setAttribute("nombre","lblNumeroLineaX" );
      ((Element)v.get(350)).setAttribute("alto","13" );
      ((Element)v.get(350)).setAttribute("filas","1" );
      ((Element)v.get(350)).setAttribute("valor","" );
      ((Element)v.get(350)).setAttribute("id","datosCampos" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(352)).setAttribute("src","b.gif" );
      ((Element)v.get(352)).setAttribute("width","25" );
      ((Element)v.get(352)).setAttribute("height","8" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:353 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(346)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(354)).setAttribute("nombre","cbTipoMov" );
      ((Element)v.get(354)).setAttribute("id","datosCampos" );
      ((Element)v.get(354)).setAttribute("size","1" );
      ((Element)v.get(354)).setAttribute("onshtab","document.all['Aceptar'].focus()" );
      ((Element)v.get(354)).setAttribute("multiple","N" );
      ((Element)v.get(354)).setAttribute("req","S" );
      ((Element)v.get(354)).setAttribute("valorinicial","" );
      ((Element)v.get(354)).setAttribute("textoinicial","" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:356 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).setAttribute("width","25" );
      ((Element)v.get(357)).setAttribute("height","8" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(358)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(346)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(359)).setAttribute("nombre","txtCodVenta" );
      ((Element)v.get(359)).setAttribute("id","datosCampos" );
      ((Element)v.get(359)).setAttribute("max","18" );
      ((Element)v.get(359)).setAttribute("tipo","" );
      ((Element)v.get(359)).setAttribute("onblur","mayusculas('txtCodVenta')" );
      ((Element)v.get(359)).setAttribute("onchange","" );
      ((Element)v.get(359)).setAttribute("req","S" );
      ((Element)v.get(359)).setAttribute("size","18" );
      ((Element)v.get(359)).setAttribute("valor","" );
      ((Element)v.get(359)).setAttribute("validacion","" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:360 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(361)).setAttribute("src","b.gif" );
      ((Element)v.get(361)).setAttribute("width","25" );
      ((Element)v.get(361)).setAttribute("height","8" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:362 / Elemento padre: 346   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(362)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(346)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(363)).setAttribute("nombre","txtNUniReclamadas" );
      ((Element)v.get(363)).setAttribute("id","datosCampos" );
      ((Element)v.get(363)).setAttribute("max","5" );
      ((Element)v.get(363)).setAttribute("tipo","" );
      ((Element)v.get(363)).setAttribute("onblur","validaUnidades('txtNUniReclamadas', 4)" );
      ((Element)v.get(363)).setAttribute("onchange","" );
      ((Element)v.get(363)).setAttribute("req","S" );
      ((Element)v.get(363)).setAttribute("size","12" );
      ((Element)v.get(363)).setAttribute("valor","" );
      ((Element)v.get(363)).setAttribute("validacion","" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:364 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(365)).setAttribute("src","b.gif" );
      ((Element)v.get(365)).setAttribute("width","25" );
      ((Element)v.get(365)).setAttribute("height","8" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:366 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(346)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(367)).setAttribute("nombre","txtNUniDevueltas" );
      ((Element)v.get(367)).setAttribute("id","datosCampos" );
      ((Element)v.get(367)).setAttribute("max","3" );
      ((Element)v.get(367)).setAttribute("tipo","" );
      ((Element)v.get(367)).setAttribute("onblur","validaUnidades('txtNUniDevueltas', 3)" );
      ((Element)v.get(367)).setAttribute("onchange","" );
      ((Element)v.get(367)).setAttribute("req","N" );
      ((Element)v.get(367)).setAttribute("size","12" );
      ((Element)v.get(367)).setAttribute("valor","" );
      ((Element)v.get(367)).setAttribute("validacion","" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).setAttribute("width","100%" );
      ((Element)v.get(346)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).setAttribute("width","8" );
      ((Element)v.get(369)).setAttribute("height","8" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).setAttribute("width","8" );
      ((Element)v.get(371)).setAttribute("height","8" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:372 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(373)).setAttribute("nombre","cbMotivoDev" );
      ((Element)v.get(373)).setAttribute("id","datosCampos" );
      ((Element)v.get(373)).setAttribute("size","1" );
      ((Element)v.get(373)).setAttribute("multiple","N" );
      ((Element)v.get(373)).setAttribute("req","N" );
      ((Element)v.get(373)).setAttribute("valorinicial","" );
      ((Element)v.get(373)).setAttribute("textoinicial","" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */
      /* Termina nodo:372   */

      /* Empieza nodo:375 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).setAttribute("width","100%" );
      ((Element)v.get(346)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(376)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).setAttribute("width","8" );
      ((Element)v.get(376)).setAttribute("height","8" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */
      /* Termina nodo:346   */

      /* Empieza nodo:377 / Elemento padre: 313   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(313)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(378)).setAttribute("colspan","4" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(379)).setAttribute("src","b.gif" );
      ((Element)v.get(379)).setAttribute("width","8" );
      ((Element)v.get(379)).setAttribute("height","8" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */
      /* Termina nodo:377   */
      /* Termina nodo:313   */
      /* Termina nodo:312   */
      /* Termina nodo:311   */
      /* Termina nodo:310   */
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:380 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(381)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */
      /* Termina nodo:303   */

      /* Empieza nodo:382 / Elemento padre: 295   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(295)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
   }

   private void getXML1620(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(382)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(384)).setAttribute("src","b.gif" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */

      /* Empieza nodo:385 / Elemento padre: 382   */
      v.add(doc.createElement("td"));
      ((Element)v.get(382)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("table"));
      ((Element)v.get(387)).setAttribute("width","100%" );
      ((Element)v.get(387)).setAttribute("border","0" );
      ((Element)v.get(387)).setAttribute("align","center" );
      ((Element)v.get(387)).setAttribute("cellspacing","0" );
      ((Element)v.get(387)).setAttribute("cellpadding","0" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("td"));
      ((Element)v.get(389)).setAttribute("class","botonera" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(390)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(390)).setAttribute("ID","botonContenido" );
      ((Element)v.get(390)).setAttribute("ontab","document.all['Aceptar'].focus()" );
      ((Element)v.get(390)).setAttribute("tipo","html" );
      ((Element)v.get(390)).setAttribute("accion","btnAnyadir_onClick();" );
      ((Element)v.get(390)).setAttribute("estado","false" );
      ((Element)v.get(390)).setAttribute("cod","404" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:387   */
      /* Termina nodo:386   */
      /* Termina nodo:385   */

      /* Empieza nodo:391 / Elemento padre: 382   */
      v.add(doc.createElement("td"));
      ((Element)v.get(382)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(392)).setAttribute("src","b.gif" );
      ((Element)v.get(392)).setAttribute("width","8" );
      ((Element)v.get(392)).setAttribute("height","12" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */
      /* Termina nodo:382   */

      /* Empieza nodo:393 / Elemento padre: 295   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(295)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("td"));
      ((Element)v.get(394)).setAttribute("width","12" );
      ((Element)v.get(394)).setAttribute("align","center" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(395)).setAttribute("src","b.gif" );
      ((Element)v.get(395)).setAttribute("width","12" );
      ((Element)v.get(395)).setAttribute("height","12" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 393   */
      v.add(doc.createElement("td"));
      ((Element)v.get(396)).setAttribute("width","750" );
      ((Element)v.get(393)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 393   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).setAttribute("width","12" );
      ((Element)v.get(393)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(399)).setAttribute("src","b.gif" );
      ((Element)v.get(399)).setAttribute("width","12" );
      ((Element)v.get(399)).setAttribute("height","1" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */
      /* Termina nodo:393   */
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:400 / Elemento padre: 23   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(400)).setAttribute("nombre","listado2" );
      ((Element)v.get(400)).setAttribute("ancho","669" );
      ((Element)v.get(400)).setAttribute("alto","373" );
      ((Element)v.get(400)).setAttribute("x","14" );
      ((Element)v.get(400)).setAttribute("y","430" );
      ((Element)v.get(400)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(400)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(23)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(401)).setAttribute("precarga","S" );
      ((Element)v.get(401)).setAttribute("conROver","S" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(402)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(402)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(402)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(402)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */

      /* Empieza nodo:403 / Elemento padre: 401   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(403)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(403)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(403)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(403)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(401)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */

      /* Empieza nodo:404 / Elemento padre: 401   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(404)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(404)).setAttribute("ordenarInv","descendente_on.gif" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(401)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:401   */

      /* Empieza nodo:405 / Elemento padre: 400   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(400)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(406)).setAttribute("borde","1" );
      ((Element)v.get(406)).setAttribute("horizDatos","1" );
      ((Element)v.get(406)).setAttribute("horizCabecera","1" );
      ((Element)v.get(406)).setAttribute("vertical","1" );
      ((Element)v.get(406)).setAttribute("horizTitulo","1" );
      ((Element)v.get(406)).setAttribute("horizBase","1" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */

      /* Empieza nodo:407 / Elemento padre: 405   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(407)).setAttribute("borde","#999999" );
      ((Element)v.get(407)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(407)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(407)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(407)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(407)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(407)).setAttribute("horizBase","#999999" );
      ((Element)v.get(405)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:405   */

      /* Empieza nodo:408 / Elemento padre: 400   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(408)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(408)).setAttribute("alto","22" );
      ((Element)v.get(408)).setAttribute("imgFondo","" );
      ((Element)v.get(408)).setAttribute("cod","00299" );
      ((Element)v.get(408)).setAttribute("ID","datosTitle" );
      ((Element)v.get(400)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */

      /* Empieza nodo:409 / Elemento padre: 400   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(409)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(409)).setAttribute("alto","22" );
      ((Element)v.get(409)).setAttribute("imgFondo","" );
      ((Element)v.get(400)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */

      /* Empieza nodo:410 / Elemento padre: 400   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(410)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(410)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(410)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(410)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(410)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(410)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(400)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(411)).setAttribute("ancho","90" );
      ((Element)v.get(411)).setAttribute("minimizable","S" );
      ((Element)v.get(411)).setAttribute("minimizada","N" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */

      /* Empieza nodo:412 / Elemento padre: 410   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(412)).setAttribute("ancho","60" );
      ((Element)v.get(412)).setAttribute("minimizable","S" );
      ((Element)v.get(412)).setAttribute("minimizada","N" );
      ((Element)v.get(410)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */

      /* Empieza nodo:413 / Elemento padre: 410   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(413)).setAttribute("ancho","120" );
      ((Element)v.get(413)).setAttribute("minimizable","S" );
      ((Element)v.get(413)).setAttribute("minimizada","N" );
      ((Element)v.get(410)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */

      /* Empieza nodo:414 / Elemento padre: 410   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(414)).setAttribute("ancho","100" );
      ((Element)v.get(414)).setAttribute("minimizable","S" );
      ((Element)v.get(414)).setAttribute("minimizada","N" );
      ((Element)v.get(410)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */

      /* Empieza nodo:415 / Elemento padre: 410   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(415)).setAttribute("ancho","120" );
      ((Element)v.get(415)).setAttribute("minimizable","S" );
      ((Element)v.get(415)).setAttribute("minimizada","N" );
      ((Element)v.get(410)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */

      /* Empieza nodo:416 / Elemento padre: 410   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(416)).setAttribute("ancho","120" );
      ((Element)v.get(416)).setAttribute("minimizable","S" );
      ((Element)v.get(416)).setAttribute("minimizada","N" );
      ((Element)v.get(416)).setAttribute("oculta","S" );
      ((Element)v.get(410)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */

      /* Empieza nodo:417 / Elemento padre: 410   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(417)).setAttribute("ancho","120" );
      ((Element)v.get(417)).setAttribute("minimizable","S" );
      ((Element)v.get(417)).setAttribute("minimizada","N" );
      ((Element)v.get(417)).setAttribute("oculta","S" );
      ((Element)v.get(410)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:410   */

      /* Empieza nodo:418 / Elemento padre: 400   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(418)).setAttribute("alto","20" );
      ((Element)v.get(418)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(418)).setAttribute("imgFondo","" );
      ((Element)v.get(418)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(400)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(419)).setAttribute("colFondo","" );
      ((Element)v.get(419)).setAttribute("ID","EstCab" );
      ((Element)v.get(419)).setAttribute("cod","304" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */

      /* Empieza nodo:420 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(420)).setAttribute("colFondo","" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(420)).setAttribute("ID","EstCab" );
      ((Element)v.get(420)).setAttribute("cod","336" );
      ((Element)v.get(418)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */

      /* Empieza nodo:421 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(421)).setAttribute("colFondo","" );
      ((Element)v.get(421)).setAttribute("ID","EstCab" );
      ((Element)v.get(421)).setAttribute("cod","408" );
      ((Element)v.get(418)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */

      /* Empieza nodo:422 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(422)).setAttribute("colFondo","" );
      ((Element)v.get(422)).setAttribute("ID","EstCab" );
      ((Element)v.get(422)).setAttribute("cod","302" );
      ((Element)v.get(418)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */

      /* Empieza nodo:423 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(423)).setAttribute("colFondo","" );
      ((Element)v.get(423)).setAttribute("ID","EstCab" );
      ((Element)v.get(423)).setAttribute("cod","309" );
      ((Element)v.get(418)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */

      /* Empieza nodo:424 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(424)).setAttribute("colFondo","" );
      ((Element)v.get(424)).setAttribute("ID","EstCab" );
      ((Element)v.get(424)).setAttribute("cod","309" );
      ((Element)v.get(418)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */

      /* Empieza nodo:425 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(425)).setAttribute("colFondo","" );
      ((Element)v.get(425)).setAttribute("ID","EstCab" );
      ((Element)v.get(425)).setAttribute("cod","309" );
      ((Element)v.get(418)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:418   */

      /* Empieza nodo:426 / Elemento padre: 400   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(426)).setAttribute("alto","22" );
      ((Element)v.get(426)).setAttribute("accion","" );
      ((Element)v.get(426)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(426)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(426)).setAttribute("maxSel","1" );
      ((Element)v.get(426)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(426)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(426)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(426)).setAttribute("onLoad","" );
      ((Element)v.get(426)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(426)).setAttribute("deseleccionaSiMaxSel","S" );
      ((Element)v.get(400)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(427)).setAttribute("tipo","texto" );
      ((Element)v.get(427)).setAttribute("ID","EstDat" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */

      /* Empieza nodo:428 / Elemento padre: 426   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(428)).setAttribute("tipo","texto" );
      ((Element)v.get(428)).setAttribute("ID","EstDat2" );
      ((Element)v.get(426)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */

      /* Empieza nodo:429 / Elemento padre: 426   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(429)).setAttribute("tipo","texto" );
      ((Element)v.get(429)).setAttribute("ID","EstDat" );
      ((Element)v.get(426)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */

      /* Empieza nodo:430 / Elemento padre: 426   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(430)).setAttribute("tipo","texto" );
      ((Element)v.get(430)).setAttribute("ID","EstDat2" );
      ((Element)v.get(426)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */

      /* Empieza nodo:431 / Elemento padre: 426   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(431)).setAttribute("tipo","texto" );
      ((Element)v.get(431)).setAttribute("ID","EstDat" );
      ((Element)v.get(426)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */

      /* Empieza nodo:432 / Elemento padre: 426   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(432)).setAttribute("tipo","texto" );
      ((Element)v.get(432)).setAttribute("ID","EstDat" );
      ((Element)v.get(426)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */

      /* Empieza nodo:433 / Elemento padre: 426   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(433)).setAttribute("tipo","texto" );
      ((Element)v.get(433)).setAttribute("ID","EstDat" );
      ((Element)v.get(426)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:426   */

      /* Empieza nodo:434 / Elemento padre: 400   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(400)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:400   */

      /* Empieza nodo:435 / Elemento padre: 23   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(435)).setAttribute("nombre","Aceptar" );
      ((Element)v.get(435)).setAttribute("x","15" );
      ((Element)v.get(435)).setAttribute("y","781" );
      ((Element)v.get(435)).setAttribute("accion","btnAceptar_onclick();" );
      ((Element)v.get(435)).setAttribute("ontab","focaliza(FORMULARIO + '.cbTipoMov')" );
      ((Element)v.get(435)).setAttribute("onshtab","document.all['btnAnadir'].focus()" );
      ((Element)v.get(435)).setAttribute("ID","botonContenido" );
      ((Element)v.get(435)).setAttribute("tipo","html" );
      ((Element)v.get(435)).setAttribute("estado","false" );
      ((Element)v.get(435)).setAttribute("cod","12" );
      ((Element)v.get(23)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:23   */

      /* Empieza nodo:436 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(436)).setAttribute("nombre","frmConsultaExistencia" );
      ((Element)v.get(436)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(437)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(437)).setAttribute("valor","LPDigitarReclamos" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */

      /* Empieza nodo:438 / Elemento padre: 436   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(438)).setAttribute("nombre","accion" );
      ((Element)v.get(438)).setAttribute("valor","Buscar" );
      ((Element)v.get(436)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */

      /* Empieza nodo:439 / Elemento padre: 436   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(439)).setAttribute("nombre","codDocRef" );
      ((Element)v.get(439)).setAttribute("valor","" );
      ((Element)v.get(436)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */

      /* Empieza nodo:440 / Elemento padre: 436   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(440)).setAttribute("nombre","codClie" );
      ((Element)v.get(440)).setAttribute("valor","" );
      ((Element)v.get(436)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */

      /* Empieza nodo:441 / Elemento padre: 436   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(441)).setAttribute("nombre","numRecla" );
      ((Element)v.get(441)).setAttribute("valor","" );
      ((Element)v.get(436)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */
      /* Termina nodo:436   */


   }

}

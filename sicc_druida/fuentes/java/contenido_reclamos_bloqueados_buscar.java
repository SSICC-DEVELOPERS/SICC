
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_reclamos_bloqueados_buscar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_reclamos_bloqueados_buscar" );
      ((Element)v.get(0)).setAttribute("cod","0130" );
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
      v.add(doc.createTextNode("\r   \r\r#ret1Div {visibility:hidden;}\r#ava1Div {visibility:hidden;}\r#primera1Div {visibility:hidden;}\r#separaDiv {visibility:hidden;}\r#Cplistado1{visibility:hidden;}\r#CpLin1listado1{visibility:hidden;}\r#CpLin2listado1{visibility:hidden;}\r#CpLin3listado1{visibility:hidden;}\r#CpLin4listado1{visibility:hidden;}\r\r#DetalleDiv{visibility:hidden;}\r#DesbloquearDiv{visibility:hidden;}\r#RechazarDiv{visibility:hidden;}\r\r\r \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(4)).setAttribute("name","cbMotivoDesbloqueo" );
      ((Element)v.get(4)).setAttribute("required","true" );
      ((Element)v.get(4)).setAttribute("cod","380" );
      ((Element)v.get(4)).setAttribute("group","desbloqueo" );
      ((Element)v.get(3)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","cbMotivoRechazo" );
      ((Element)v.get(5)).setAttribute("required","true" );
      ((Element)v.get(5)).setAttribute("cod","381" );
      ((Element)v.get(5)).setAttribute("group","rechazo" );
      ((Element)v.get(3)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */
      /* Termina nodo:3   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(7)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(8)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(9)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(10)).setAttribute("src","contenido_reclamos_bloqueados_buscar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(11)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(11)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","accion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","idioma" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","pais" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","casoUso" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","oid" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","opcion" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","oidsLista" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","oidMotivoRechazo" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","oidMotivoDesbloqueo" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","numDigitosCodigoCliente" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 11   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(26)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(11)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("table"));
      ((Element)v.get(27)).setAttribute("width","100%" );
      ((Element)v.get(27)).setAttribute("border","0" );
      ((Element)v.get(27)).setAttribute("cellspacing","0" );
      ((Element)v.get(27)).setAttribute("cellpadding","0" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).setAttribute("width","12" );
      ((Element)v.get(29)).setAttribute("align","center" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).setAttribute("width","12" );
      ((Element)v.get(30)).setAttribute("height","12" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).setAttribute("width","750" );
      ((Element)v.get(28)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).setAttribute("width","12" );
      ((Element)v.get(28)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(34)).setAttribute("src","b.gif" );
      ((Element)v.get(34)).setAttribute("width","12" );
      ((Element)v.get(34)).setAttribute("height","1" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:28   */

      /* Empieza nodo:35 / Elemento padre: 27   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(27)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(40)).setAttribute("class","legend" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(41)).setAttribute("nombre","lblCriterios" );
      ((Element)v.get(41)).setAttribute("alto","13" );
      ((Element)v.get(41)).setAttribute("filas","1" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(41)).setAttribute("id","legend" );
      ((Element)v.get(41)).setAttribute("cod","0075" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("table"));
      ((Element)v.get(42)).setAttribute("width","100%" );
      ((Element)v.get(42)).setAttribute("border","0" );
      ((Element)v.get(42)).setAttribute("align","center" );
      ((Element)v.get(42)).setAttribute("cellspacing","0" );
      ((Element)v.get(42)).setAttribute("cellpadding","0" );
      ((Element)v.get(39)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("table"));
      ((Element)v.get(45)).setAttribute("width","635" );
      ((Element)v.get(45)).setAttribute("border","0" );
      ((Element)v.get(45)).setAttribute("align","left" );
      ((Element)v.get(45)).setAttribute("cellspacing","0" );
      ((Element)v.get(45)).setAttribute("cellpadding","0" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("colspan","4" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","8" );
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:49 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","8" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(53)).setAttribute("nombre","lblNatencion" );
      ((Element)v.get(53)).setAttribute("alto","13" );
      ((Element)v.get(53)).setAttribute("filas","1" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(53)).setAttribute("id","datosTitle" );
      ((Element)v.get(53)).setAttribute("cod","262" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","25" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(57)).setAttribute("nombre","lblNumDocRef" );
      ((Element)v.get(57)).setAttribute("alto","13" );
      ((Element)v.get(57)).setAttribute("filas","1" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("id","datosTitle" );
      ((Element)v.get(57)).setAttribute("cod","367" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","25" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("colspan","3" );
      ((Element)v.get(49)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(61)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(61)).setAttribute("alto","13" );
      ((Element)v.get(61)).setAttribute("filas","1" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(61)).setAttribute("id","datosTitle" );
      ((Element)v.get(61)).setAttribute("cod","263" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("width","100%" );
      ((Element)v.get(49)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:49   */

      /* Empieza nodo:64 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(64));

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
      ((Element)v.get(64)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(68)).setAttribute("nombre","txtNatencion" );
      ((Element)v.get(68)).setAttribute("id","datosCampos" );
      ((Element)v.get(68)).setAttribute("max","10" );
      ((Element)v.get(68)).setAttribute("tipo","" );
      ((Element)v.get(68)).setAttribute("onchange","" );
      ((Element)v.get(68)).setAttribute("onblur","validarNumerico('txtNatencion');" );
      ((Element)v.get(68)).setAttribute("onshtab","focalizaAnteriorNAtencion();" );
      ((Element)v.get(68)).setAttribute("req","N" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).setAttribute("size","13" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(68)).setAttribute("validacion","" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","25" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(72)).setAttribute("nombre","txtNumDocRef" );
      ((Element)v.get(72)).setAttribute("id","datosCampos" );
      ((Element)v.get(72)).setAttribute("max","10" );
      ((Element)v.get(72)).setAttribute("tipo","" );
      ((Element)v.get(72)).setAttribute("onchange","" );
      ((Element)v.get(72)).setAttribute("onblur","validarNumerico('txtNumDocRef');" );
      ((Element)v.get(72)).setAttribute("req","N" );
      ((Element)v.get(72)).setAttribute("size","13" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(72)).setAttribute("validacion","" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","25" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(76)).setAttribute("nombre","txtCodCliente" );
      ((Element)v.get(76)).setAttribute("id","datosCampos" );
      ((Element)v.get(76)).setAttribute("max","15" );
      ((Element)v.get(76)).setAttribute("tipo","" );
      ((Element)v.get(76)).setAttribute("onblur","codigoClienteOnBlur();" );
      ((Element)v.get(76)).setAttribute("onchange","" );
      ((Element)v.get(76)).setAttribute("req","N" );
      ((Element)v.get(76)).setAttribute("size","19" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(76)).setAttribute("validacion","" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","8" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(80)).setAttribute("onclick","iconoCliente();" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","100%" );
      ((Element)v.get(64)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:64   */

      /* Empieza nodo:83 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("colspan","4" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:86 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("table"));
      ((Element)v.get(88)).setAttribute("width","635" );
      ((Element)v.get(88)).setAttribute("border","0" );
      ((Element)v.get(88)).setAttribute("align","left" );
      ((Element)v.get(88)).setAttribute("cellspacing","0" );
      ((Element)v.get(88)).setAttribute("cellpadding","0" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(93)).setAttribute("nombre","lblOperacion" );
      ((Element)v.get(93)).setAttribute("alto","13" );
      ((Element)v.get(93)).setAttribute("filas","1" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(93)).setAttribute("id","datosTitle" );
      ((Element)v.get(93)).setAttribute("cod","368" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","25" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(97)).setAttribute("nombre","lblTipoBloqueo" );
      ((Element)v.get(97)).setAttribute("alto","13" );
      ((Element)v.get(97)).setAttribute("filas","1" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(97)).setAttribute("id","datosTitle" );
      ((Element)v.get(97)).setAttribute("cod","369" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("width","100%" );
      ((Element)v.get(89)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","8" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:89   */

      /* Empieza nodo:100 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(100));

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
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(104)).setAttribute("nombre","cbOperacion" );
      ((Element)v.get(104)).setAttribute("id","datosCampos" );
      ((Element)v.get(104)).setAttribute("size","5" );
      ((Element)v.get(104)).setAttribute("multiple","S" );
      ((Element)v.get(104)).setAttribute("req","N" );
      ((Element)v.get(104)).setAttribute("valorinicial","" );
      ((Element)v.get(104)).setAttribute("textoinicial","" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:106 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","25" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(109)).setAttribute("nombre","cbTipoBloqueo" );
      ((Element)v.get(109)).setAttribute("id","datosCampos" );
      ((Element)v.get(109)).setAttribute("size","5" );
      ((Element)v.get(109)).setAttribute("multiple","S" );
      ((Element)v.get(109)).setAttribute("req","N" );
      ((Element)v.get(109)).setAttribute("valorinicial","" );
      ((Element)v.get(109)).setAttribute("textoinicial","" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:111 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("width","100%" );
      ((Element)v.get(100)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:100   */

      /* Empieza nodo:113 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("colspan","4" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:116 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("table"));
      ((Element)v.get(118)).setAttribute("width","635" );
      ((Element)v.get(118)).setAttribute("border","0" );
      ((Element)v.get(118)).setAttribute("align","left" );
      ((Element)v.get(118)).setAttribute("cellspacing","0" );
      ((Element)v.get(118)).setAttribute("cellpadding","0" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(123)).setAttribute("nombre","lblSoloRechazadas" );
      ((Element)v.get(123)).setAttribute("alto","13" );
      ((Element)v.get(123)).setAttribute("filas","1" );
      ((Element)v.get(123)).setAttribute("valor","" );
      ((Element)v.get(123)).setAttribute("id","datosTitle" );
      ((Element)v.get(123)).setAttribute("cod","370" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","25" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(127)).setAttribute("nombre","lblFechaRecDesde" );
      ((Element)v.get(127)).setAttribute("alto","13" );
      ((Element)v.get(127)).setAttribute("filas","1" );
      ((Element)v.get(127)).setAttribute("valor","" );
      ((Element)v.get(127)).setAttribute("id","datosTitle" );
      ((Element)v.get(127)).setAttribute("cod","371" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","25" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(131)).setAttribute("nombre","lblFechaRecHasta" );
      ((Element)v.get(131)).setAttribute("alto","13" );
      ((Element)v.get(131)).setAttribute("filas","1" );
      ((Element)v.get(131)).setAttribute("valor","" );
      ((Element)v.get(131)).setAttribute("id","datosTitle" );
      ((Element)v.get(131)).setAttribute("cod","1685" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","25" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(135)).setAttribute("nombre","lblRecLinea" );
      ((Element)v.get(135)).setAttribute("alto","13" );
      ((Element)v.get(135)).setAttribute("filas","1" );
      ((Element)v.get(135)).setAttribute("valor","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(135)).setAttribute("id","datosTitle" );
      ((Element)v.get(135)).setAttribute("cod","372" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","25" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(139)).setAttribute("nombre","lblRecDigitados" );
      ((Element)v.get(139)).setAttribute("alto","13" );
      ((Element)v.get(139)).setAttribute("filas","1" );
      ((Element)v.get(139)).setAttribute("valor","" );
      ((Element)v.get(139)).setAttribute("id","datosTitle" );
      ((Element)v.get(139)).setAttribute("cod","373" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("width","100%" );
      ((Element)v.get(119)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:119   */

      /* Empieza nodo:142 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(146)).setAttribute("check","N" );
      ((Element)v.get(146)).setAttribute("id","" );
      ((Element)v.get(146)).setAttribute("nombre","chkSoloRechazadas" );
      ((Element)v.get(146)).setAttribute("onclick","" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","25" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(150)).setAttribute("nombre","txtFechaRecDesde" );
      ((Element)v.get(150)).setAttribute("id","datosCampos" );
      ((Element)v.get(150)).setAttribute("max","10" );
      ((Element)v.get(150)).setAttribute("tipo","" );
      ((Element)v.get(150)).setAttribute("onchange","" );
      ((Element)v.get(150)).setAttribute("onblur","comprobarFecha('txtFechaRecDesde');" );
      ((Element)v.get(150)).setAttribute("req","N" );
      ((Element)v.get(150)).setAttribute("size","12" );
      ((Element)v.get(150)).setAttribute("valor","" );
      ((Element)v.get(150)).setAttribute("validacion","" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","25" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(154)).setAttribute("nombre","txtFechaRecHasta" );
      ((Element)v.get(154)).setAttribute("id","datosCampos" );
      ((Element)v.get(154)).setAttribute("max","10" );
      ((Element)v.get(154)).setAttribute("tipo","" );
      ((Element)v.get(154)).setAttribute("onchange","" );
      ((Element)v.get(154)).setAttribute("onblur","comprobarFecha('txtFechaRecHasta');" );
      ((Element)v.get(154)).setAttribute("req","N" );
      ((Element)v.get(154)).setAttribute("size","12" );
      ((Element)v.get(154)).setAttribute("valor","" );
      ((Element)v.get(154)).setAttribute("validacion","" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","25" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(158)).setAttribute("check","N" );
      ((Element)v.get(158)).setAttribute("id","" );
      ((Element)v.get(158)).setAttribute("nombre","chkRecLinea" );
      ((Element)v.get(158)).setAttribute("onclick","" );
      ((Element)v.get(158)).setAttribute("req","" );
      ((Element)v.get(158)).setAttribute("texto","" );
      ((Element)v.get(158)).setAttribute("validacion","" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","25" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(162)).setAttribute("check","N" );
      ((Element)v.get(162)).setAttribute("id","" );
      ((Element)v.get(162)).setAttribute("nombre","chkRecDigitados" );
      ((Element)v.get(162)).setAttribute("readonly","" );
      ((Element)v.get(162)).setAttribute("req","" );
      ((Element)v.get(162)).setAttribute("texto","" );
      ((Element)v.get(162)).setAttribute("validacion","" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("width","100%" );
      ((Element)v.get(163)).setAttribute("colspan","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:142   */

      /* Empieza nodo:165 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).setAttribute("colspan","10" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","8" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:168 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("table"));
      ((Element)v.get(170)).setAttribute("width","635" );
      ((Element)v.get(170)).setAttribute("border","0" );
      ((Element)v.get(170)).setAttribute("align","left" );
      ((Element)v.get(170)).setAttribute("cellspacing","0" );
      ((Element)v.get(170)).setAttribute("cellpadding","0" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","8" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(175)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(175)).setAttribute("alto","13" );
      ((Element)v.get(175)).setAttribute("filas","1" );
      ((Element)v.get(175)).setAttribute("valor","" );
      ((Element)v.get(175)).setAttribute("id","datosTitle" );
      ((Element)v.get(175)).setAttribute("cod","6" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","25" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(171)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(179)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(179)).setAttribute("alto","13" );
      ((Element)v.get(179)).setAttribute("filas","1" );
      ((Element)v.get(179)).setAttribute("valor","" );
      ((Element)v.get(179)).setAttribute("id","datosTitle" );
      ((Element)v.get(179)).setAttribute("cod","7" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("width","100%" );
      ((Element)v.get(171)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:171   */

      /* Empieza nodo:182 / Elemento padre: 170   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(170)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(186)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(186)).setAttribute("id","datosCampos" );
      ((Element)v.get(186)).setAttribute("size","1" );
      ((Element)v.get(186)).setAttribute("multiple","N" );
      ((Element)v.get(186)).setAttribute("req","N" );
      ((Element)v.get(186)).setAttribute("onchange","onChangeMarca();" );
      ((Element)v.get(186)).setAttribute("valorinicial","" );
      ((Element)v.get(186)).setAttribute("textoinicial","" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:188 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","25" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(191)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(191)).setAttribute("id","datosCampos" );
      ((Element)v.get(191)).setAttribute("size","1" );
      ((Element)v.get(191)).setAttribute("multiple","N" );
      ((Element)v.get(191)).setAttribute("req","N" );
      ((Element)v.get(191)).setAttribute("onchange","onChangeCanal();" );
      ((Element)v.get(191)).setAttribute("valorinicial","" );
      ((Element)v.get(191)).setAttribute("textoinicial","" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:193 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).setAttribute("width","100%" );
      ((Element)v.get(182)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","8" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:182   */

      /* Empieza nodo:195 / Elemento padre: 170   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(170)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).setAttribute("colspan","4" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:198 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("table"));
      ((Element)v.get(200)).setAttribute("width","635" );
      ((Element)v.get(200)).setAttribute("border","0" );
      ((Element)v.get(200)).setAttribute("align","left" );
      ((Element)v.get(200)).setAttribute("cellspacing","0" );
      ((Element)v.get(200)).setAttribute("cellpadding","0" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","8" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(205)).setAttribute("nombre","lblPerRefDesde" );
      ((Element)v.get(205)).setAttribute("alto","13" );
      ((Element)v.get(205)).setAttribute("filas","1" );
      ((Element)v.get(205)).setAttribute("valor","" );
      ((Element)v.get(205)).setAttribute("id","datosTitle" );
      ((Element)v.get(205)).setAttribute("cod","271" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","25" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(209)).setAttribute("nombre","lblPerRefHasta" );
      ((Element)v.get(209)).setAttribute("alto","13" );
      ((Element)v.get(209)).setAttribute("filas","1" );
      ((Element)v.get(209)).setAttribute("valor","" );
      ((Element)v.get(209)).setAttribute("id","datosTitle" );
      ((Element)v.get(209)).setAttribute("cod","1650" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).setAttribute("width","100%" );
      ((Element)v.get(201)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","8" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:201   */

      /* Empieza nodo:212 / Elemento padre: 200   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(200)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","8" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(216)).setAttribute("nombre","cbPerRefDesde" );
      ((Element)v.get(216)).setAttribute("id","datosCampos" );
      ((Element)v.get(216)).setAttribute("size","1" );
      ((Element)v.get(216)).setAttribute("multiple","N" );
      ((Element)v.get(216)).setAttribute("req","N" );
      ((Element)v.get(216)).setAttribute("valorinicial","" );
      ((Element)v.get(216)).setAttribute("textoinicial","" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:218 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","25" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(221)).setAttribute("nombre","cbPerRefHasta" );
      ((Element)v.get(221)).setAttribute("id","datosCampos" );
      ((Element)v.get(221)).setAttribute("size","1" );
      ((Element)v.get(221)).setAttribute("multiple","N" );
      ((Element)v.get(221)).setAttribute("req","N" );
      ((Element)v.get(221)).setAttribute("valorinicial","" );
      ((Element)v.get(221)).setAttribute("textoinicial","" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:223 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).setAttribute("width","100%" );
      ((Element)v.get(212)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","8" );
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:212   */

      /* Empieza nodo:225 / Elemento padre: 200   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(200)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).setAttribute("colspan","4" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","8" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:42   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:228 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:35   */

      /* Empieza nodo:230 / Elemento padre: 27   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(27)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("table"));
      ((Element)v.get(235)).setAttribute("width","100%" );
      ((Element)v.get(235)).setAttribute("border","0" );
      ((Element)v.get(235)).setAttribute("align","center" );
      ((Element)v.get(235)).setAttribute("cellspacing","0" );
      ((Element)v.get(235)).setAttribute("cellpadding","0" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).setAttribute("class","botonera" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(238)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(238)).setAttribute("ID","botonContenido" );
      ((Element)v.get(238)).setAttribute("tipo","html" );
      ((Element)v.get(238)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(238)).setAttribute("ontab","focalizaSiguienteBuscar();" );
      ((Element)v.get(238)).setAttribute("estado","false" );
      ((Element)v.get(238)).setAttribute("cod","1" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:239 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","8" );
      ((Element)v.get(240)).setAttribute("height","12" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:230   */

      /* Empieza nodo:241 / Elemento padre: 27   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(27)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).setAttribute("colspan","4" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","8" );
      ((Element)v.get(243)).setAttribute("height","365" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:244 / Elemento padre: 27   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(27)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(249)).setAttribute("class","legend" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(250)).setAttribute("nombre","lblDatosAccion" );
      ((Element)v.get(250)).setAttribute("alto","13" );
      ((Element)v.get(250)).setAttribute("filas","1" );
      ((Element)v.get(250)).setAttribute("valor","" );
      ((Element)v.get(250)).setAttribute("id","legend" );
      ((Element)v.get(250)).setAttribute("cod","00537" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 248   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("table"));
      ((Element)v.get(251)).setAttribute("width","100%" );
      ((Element)v.get(251)).setAttribute("border","0" );
      ((Element)v.get(251)).setAttribute("align","center" );
      ((Element)v.get(251)).setAttribute("cellspacing","0" );
      ((Element)v.get(251)).setAttribute("cellpadding","0" );
      ((Element)v.get(248)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("table"));
      ((Element)v.get(254)).setAttribute("width","635" );
      ((Element)v.get(254)).setAttribute("border","0" );
      ((Element)v.get(254)).setAttribute("align","left" );
      ((Element)v.get(254)).setAttribute("cellspacing","0" );
      ((Element)v.get(254)).setAttribute("cellpadding","0" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).setAttribute("colspan","4" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","8" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:258 / Elemento padre: 254   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(254)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","8" );
      ((Element)v.get(260)).setAttribute("height","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(262)).setAttribute("nombre","lblMotivoDesbloqueo" );
      ((Element)v.get(262)).setAttribute("alto","17" );
      ((Element)v.get(262)).setAttribute("filas","1" );
      ((Element)v.get(262)).setAttribute("valor","" );
      ((Element)v.get(262)).setAttribute("id","datosTitle" );
      ((Element)v.get(262)).setAttribute("cod","380" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).setAttribute("width","25" );
      ((Element)v.get(264)).setAttribute("height","8" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(266)).setAttribute("nombre","lblMotivoRechazo" );
      ((Element)v.get(266)).setAttribute("alto","17" );
      ((Element)v.get(266)).setAttribute("filas","1" );
      ((Element)v.get(266)).setAttribute("valor","" );
      ((Element)v.get(266)).setAttribute("id","datosTitle" );
      ((Element)v.get(266)).setAttribute("cod","381" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).setAttribute("width","100%" );
      ((Element)v.get(258)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","8" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:258   */

      /* Empieza nodo:269 / Elemento padre: 254   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(254)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","8" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(269)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(273)).setAttribute("nombre","cbMotivoDesbloqueo" );
      ((Element)v.get(273)).setAttribute("id","datosCampos" );
      ((Element)v.get(273)).setAttribute("size","1" );
      ((Element)v.get(273)).setAttribute("multiple","N" );
      ((Element)v.get(273)).setAttribute("req","S" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(273)).setAttribute("valorinicial","" );
      ((Element)v.get(273)).setAttribute("textoinicial","" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:275 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","25" );
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(269)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(278)).setAttribute("nombre","cbMotivoRechazo" );
      ((Element)v.get(278)).setAttribute("id","datosCampos" );
      ((Element)v.get(278)).setAttribute("size","1" );
      ((Element)v.get(278)).setAttribute("multiple","N" );
      ((Element)v.get(278)).setAttribute("req","S" );
      ((Element)v.get(278)).setAttribute("valorinicial","" );
      ((Element)v.get(278)).setAttribute("textoinicial","" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:280 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).setAttribute("width","100%" );
      ((Element)v.get(269)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).setAttribute("width","8" );
      ((Element)v.get(281)).setAttribute("height","8" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */
      /* Termina nodo:269   */

      /* Empieza nodo:282 / Elemento padre: 254   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(254)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).setAttribute("colspan","4" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","8" );
      ((Element)v.get(284)).setAttribute("height","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */
      /* Termina nodo:282   */
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:285 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(286)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:244   */

      /* Empieza nodo:287 / Elemento padre: 27   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(27)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("table"));
      ((Element)v.get(292)).setAttribute("width","100%" );
      ((Element)v.get(292)).setAttribute("border","0" );
      ((Element)v.get(292)).setAttribute("align","center" );
      ((Element)v.get(292)).setAttribute("cellspacing","0" );
      ((Element)v.get(292)).setAttribute("cellpadding","0" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).setAttribute("class","botonera" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(295)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(295)).setAttribute("ID","botonContenido" );
      ((Element)v.get(295)).setAttribute("accion","onClickAceptar();" );
      ((Element)v.get(295)).setAttribute("tipo","html" );
      ((Element)v.get(295)).setAttribute("onshtab","shtabAceptar();" );
      ((Element)v.get(295)).setAttribute("ontab","focaliza(FORMULARIO + '.txtNatencion');" );
      ((Element)v.get(295)).setAttribute("estado","false" );
      ((Element)v.get(295)).setAttribute("cod","12" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:293   */
      /* Termina nodo:292   */
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:296 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(297)).setAttribute("src","b.gif" );
      ((Element)v.get(297)).setAttribute("width","8" );
      ((Element)v.get(297)).setAttribute("height","12" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */
      /* Termina nodo:287   */

      /* Empieza nodo:298 / Elemento padre: 27   */
      v.add(doc.createElement("tr"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(27)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(299)).setAttribute("width","12" );
      ((Element)v.get(299)).setAttribute("align","center" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(300)).setAttribute("src","b.gif" );
      ((Element)v.get(300)).setAttribute("width","12" );
      ((Element)v.get(300)).setAttribute("height","12" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(301)).setAttribute("width","750" );
      ((Element)v.get(298)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).setAttribute("width","12" );
      ((Element)v.get(298)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).setAttribute("width","12" );
      ((Element)v.get(304)).setAttribute("height","1" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */
      /* Termina nodo:298   */
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:305 / Elemento padre: 11   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(305)).setAttribute("nombre","listado1" );
      ((Element)v.get(305)).setAttribute("ancho","639" );
      ((Element)v.get(305)).setAttribute("alto","317" );
      ((Element)v.get(305)).setAttribute("x","12" );
      ((Element)v.get(305)).setAttribute("y","328" );
      ((Element)v.get(305)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(305)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(11)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(306)).setAttribute("precarga","S" );
      ((Element)v.get(306)).setAttribute("conROver","S" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(307)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(307)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(307)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(307)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */

      /* Empieza nodo:308 / Elemento padre: 306   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(308)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(308)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(308)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(308)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(306)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 306   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(309)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(309)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(306)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:306   */

      /* Empieza nodo:310 / Elemento padre: 305   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(305)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(311)).setAttribute("borde","1" );
      ((Element)v.get(311)).setAttribute("horizDatos","1" );
      ((Element)v.get(311)).setAttribute("horizCabecera","1" );
      ((Element)v.get(311)).setAttribute("vertical","1" );
      ((Element)v.get(311)).setAttribute("horizTitulo","1" );
      ((Element)v.get(311)).setAttribute("horizBase","1" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 310   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(312)).setAttribute("borde","#999999" );
      ((Element)v.get(312)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(312)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(312)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(312)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(312)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(312)).setAttribute("horizBase","#999999" );
      ((Element)v.get(310)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:310   */

      /* Empieza nodo:313 / Elemento padre: 305   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(313)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(313)).setAttribute("alto","22" );
      ((Element)v.get(313)).setAttribute("imgFondo","" );
      ((Element)v.get(313)).setAttribute("cod","00135" );
      ((Element)v.get(313)).setAttribute("ID","datosTitle" );
      ((Element)v.get(305)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */

      /* Empieza nodo:314 / Elemento padre: 305   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(314)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(314)).setAttribute("alto","22" );
      ((Element)v.get(314)).setAttribute("imgFondo","" );
      ((Element)v.get(305)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */

      /* Empieza nodo:315 / Elemento padre: 305   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(315)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(315)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(315)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(315)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(315)).setAttribute("AnchoMinimizadas","20" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(315)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(305)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(316)).setAttribute("ancho","100" );
      ((Element)v.get(316)).setAttribute("minimizable","S" );
      ((Element)v.get(316)).setAttribute("minimizada","N" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */

      /* Empieza nodo:317 / Elemento padre: 315   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(317)).setAttribute("ancho","100" );
      ((Element)v.get(317)).setAttribute("minimizable","S" );
      ((Element)v.get(317)).setAttribute("minimizada","N" );
      ((Element)v.get(315)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */

      /* Empieza nodo:318 / Elemento padre: 315   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(318)).setAttribute("ancho","150" );
      ((Element)v.get(318)).setAttribute("minimizable","S" );
      ((Element)v.get(318)).setAttribute("minimizada","N" );
      ((Element)v.get(315)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */

      /* Empieza nodo:319 / Elemento padre: 315   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(319)).setAttribute("ancho","100" );
      ((Element)v.get(319)).setAttribute("minimizable","S" );
      ((Element)v.get(319)).setAttribute("minimizada","N" );
      ((Element)v.get(315)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 315   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(320)).setAttribute("ancho","120" );
      ((Element)v.get(320)).setAttribute("minimizable","S" );
      ((Element)v.get(320)).setAttribute("minimizada","N" );
      ((Element)v.get(315)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 315   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(321)).setAttribute("ancho","120" );
      ((Element)v.get(321)).setAttribute("minimizable","S" );
      ((Element)v.get(321)).setAttribute("minimizada","N" );
      ((Element)v.get(315)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */

      /* Empieza nodo:322 / Elemento padre: 315   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(322)).setAttribute("ancho","100" );
      ((Element)v.get(322)).setAttribute("minimizable","S" );
      ((Element)v.get(322)).setAttribute("minimizada","N" );
      ((Element)v.get(315)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */

      /* Empieza nodo:323 / Elemento padre: 315   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(323)).setAttribute("ancho","100" );
      ((Element)v.get(323)).setAttribute("minimizable","S" );
      ((Element)v.get(323)).setAttribute("minimizada","N" );
      ((Element)v.get(315)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */

      /* Empieza nodo:324 / Elemento padre: 315   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(324)).setAttribute("ancho","100" );
      ((Element)v.get(324)).setAttribute("minimizable","S" );
      ((Element)v.get(324)).setAttribute("minimizada","N" );
      ((Element)v.get(315)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */

      /* Empieza nodo:325 / Elemento padre: 315   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(325)).setAttribute("ancho","100" );
      ((Element)v.get(325)).setAttribute("minimizable","S" );
      ((Element)v.get(325)).setAttribute("minimizada","N" );
      ((Element)v.get(315)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 315   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(326)).setAttribute("ancho","100" );
      ((Element)v.get(326)).setAttribute("minimizable","S" );
      ((Element)v.get(326)).setAttribute("minimizada","N" );
      ((Element)v.get(315)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */

      /* Empieza nodo:327 / Elemento padre: 315   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(327)).setAttribute("ancho","100" );
      ((Element)v.get(327)).setAttribute("minimizable","S" );
      ((Element)v.get(327)).setAttribute("minimizada","N" );
      ((Element)v.get(315)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:315   */

      /* Empieza nodo:328 / Elemento padre: 305   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(328)).setAttribute("alto","20" );
      ((Element)v.get(328)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(328)).setAttribute("imgFondo","" );
      ((Element)v.get(328)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(305)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(329)).setAttribute("colFondo","" );
      ((Element)v.get(329)).setAttribute("ID","EstCab" );
      ((Element)v.get(329)).setAttribute("cod","262" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */

      /* Empieza nodo:330 / Elemento padre: 328   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(330)).setAttribute("colFondo","" );
      ((Element)v.get(330)).setAttribute("ID","EstCab" );
      ((Element)v.get(330)).setAttribute("cod","263" );
      ((Element)v.get(328)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */

      /* Empieza nodo:331 / Elemento padre: 328   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(331)).setAttribute("colFondo","" );
      ((Element)v.get(331)).setAttribute("ID","EstCab" );
      ((Element)v.get(331)).setAttribute("cod","1655" );
      ((Element)v.get(328)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */

      /* Empieza nodo:332 / Elemento padre: 328   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(332)).setAttribute("colFondo","" );
      ((Element)v.get(332)).setAttribute("ID","EstCab" );
      ((Element)v.get(332)).setAttribute("cod","383" );
      ((Element)v.get(328)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */

      /* Empieza nodo:333 / Elemento padre: 328   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(333)).setAttribute("colFondo","" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(333)).setAttribute("ID","EstCab" );
      ((Element)v.get(333)).setAttribute("cod","367" );
      ((Element)v.get(328)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */

      /* Empieza nodo:334 / Elemento padre: 328   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(334)).setAttribute("colFondo","" );
      ((Element)v.get(334)).setAttribute("ID","EstCab" );
      ((Element)v.get(334)).setAttribute("cod","297" );
      ((Element)v.get(328)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */

      /* Empieza nodo:335 / Elemento padre: 328   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(335)).setAttribute("colFondo","" );
      ((Element)v.get(335)).setAttribute("ID","EstCab" );
      ((Element)v.get(335)).setAttribute("cod","310" );
      ((Element)v.get(328)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */

      /* Empieza nodo:336 / Elemento padre: 328   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(336)).setAttribute("colFondo","" );
      ((Element)v.get(336)).setAttribute("ID","EstCab" );
      ((Element)v.get(336)).setAttribute("cod","311" );
      ((Element)v.get(328)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */

      /* Empieza nodo:337 / Elemento padre: 328   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(337)).setAttribute("colFondo","" );
      ((Element)v.get(337)).setAttribute("ID","EstCab" );
      ((Element)v.get(337)).setAttribute("cod","312" );
      ((Element)v.get(328)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */

      /* Empieza nodo:338 / Elemento padre: 328   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(338)).setAttribute("colFondo","" );
      ((Element)v.get(338)).setAttribute("ID","EstCab" );
      ((Element)v.get(338)).setAttribute("cod","385" );
      ((Element)v.get(328)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */

      /* Empieza nodo:339 / Elemento padre: 328   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(339)).setAttribute("colFondo","" );
      ((Element)v.get(339)).setAttribute("ID","EstCab" );
      ((Element)v.get(339)).setAttribute("cod","386" );
      ((Element)v.get(328)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */

      /* Empieza nodo:340 / Elemento padre: 328   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(340)).setAttribute("colFondo","" );
      ((Element)v.get(340)).setAttribute("ID","EstCab" );
      ((Element)v.get(340)).setAttribute("cod","379" );
      ((Element)v.get(328)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:328   */

      /* Empieza nodo:341 / Elemento padre: 305   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(341)).setAttribute("alto","22" );
      ((Element)v.get(341)).setAttribute("accion","dehabilitarCombos();" );
      ((Element)v.get(341)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(341)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(341)).setAttribute("maxSel","-1" );
      ((Element)v.get(341)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(341)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(341)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(341)).setAttribute("onLoad","" );
      ((Element)v.get(341)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(305)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(342)).setAttribute("tipo","texto" );
      ((Element)v.get(342)).setAttribute("ID","EstDat" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */

      /* Empieza nodo:343 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(343)).setAttribute("tipo","texto" );
      ((Element)v.get(343)).setAttribute("ID","EstDat2" );
      ((Element)v.get(341)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */

      /* Empieza nodo:344 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(344)).setAttribute("tipo","texto" );
      ((Element)v.get(344)).setAttribute("ID","EstDat" );
      ((Element)v.get(341)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */

      /* Empieza nodo:345 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(345)).setAttribute("tipo","texto" );
      ((Element)v.get(345)).setAttribute("ID","EstDat2" );
      ((Element)v.get(341)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */

      /* Empieza nodo:346 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(346)).setAttribute("tipo","texto" );
      ((Element)v.get(346)).setAttribute("ID","EstDat" );
      ((Element)v.get(341)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */

      /* Empieza nodo:347 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(347)).setAttribute("tipo","texto" );
      ((Element)v.get(347)).setAttribute("ID","EstDat2" );
      ((Element)v.get(341)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */

      /* Empieza nodo:348 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(348)).setAttribute("tipo","texto" );
      ((Element)v.get(348)).setAttribute("ID","EstDat" );
      ((Element)v.get(341)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */

      /* Empieza nodo:349 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(349)).setAttribute("tipo","texto" );
      ((Element)v.get(349)).setAttribute("ID","EstDat2" );
      ((Element)v.get(341)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */

      /* Empieza nodo:350 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(350)).setAttribute("tipo","texto" );
      ((Element)v.get(350)).setAttribute("ID","EstDat" );
      ((Element)v.get(341)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */

      /* Empieza nodo:351 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(351)).setAttribute("tipo","texto" );
      ((Element)v.get(351)).setAttribute("ID","EstDat2" );
      ((Element)v.get(341)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */

      /* Empieza nodo:352 / Elemento padre: 341   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(352)).setAttribute("tipo","texto" );
      ((Element)v.get(352)).setAttribute("ID","EstDat" );
      ((Element)v.get(341)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */

      /* Empieza nodo:353 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(353)).setAttribute("tipo","texto" );
      ((Element)v.get(353)).setAttribute("ID","EstDat2" );
      ((Element)v.get(341)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:341   */

      /* Empieza nodo:354 / Elemento padre: 305   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(305)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */

      /* Empieza nodo:355 / Elemento padre: 305   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(355)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(355)).setAttribute("ancho","639" );
      ((Element)v.get(355)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)');" );
      ((Element)v.get(355)).setAttribute("sep","$" );
      ((Element)v.get(355)).setAttribute("x","12" );
      ((Element)v.get(355)).setAttribute("class","botonera" );
      ((Element)v.get(355)).setAttribute("y","622" );
      ((Element)v.get(355)).setAttribute("control","|" );
      ((Element)v.get(355)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(355)).setAttribute("rowset","" );
      ((Element)v.get(355)).setAttribute("cargainicial","N" );
      ((Element)v.get(305)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(356)).setAttribute("nombre","ret1" );
      ((Element)v.get(356)).setAttribute("x","37" );
      ((Element)v.get(356)).setAttribute("y","626" );
      ((Element)v.get(356)).setAttribute("ID","botonContenido" );
      ((Element)v.get(356)).setAttribute("img","retroceder_on" );
      ((Element)v.get(356)).setAttribute("tipo","0" );
      ((Element)v.get(356)).setAttribute("estado","false" );
      ((Element)v.get(356)).setAttribute("alt","" );
      ((Element)v.get(356)).setAttribute("codigo","" );
      ((Element)v.get(356)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */

      /* Empieza nodo:357 / Elemento padre: 355   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(357)).setAttribute("nombre","ava1" );
      ((Element)v.get(357)).setAttribute("x","52" );
      ((Element)v.get(357)).setAttribute("y","626" );
      ((Element)v.get(357)).setAttribute("ID","botonContenido" );
      ((Element)v.get(357)).setAttribute("img","avanzar_on" );
      ((Element)v.get(357)).setAttribute("tipo","0" );
      ((Element)v.get(357)).setAttribute("estado","false" );
      ((Element)v.get(357)).setAttribute("alt","" );
      ((Element)v.get(357)).setAttribute("codigo","" );
      ((Element)v.get(357)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(355)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:355   */
      /* Termina nodo:305   */

      /* Empieza nodo:358 / Elemento padre: 11   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(358)).setAttribute("nombre","primera1" );
      ((Element)v.get(358)).setAttribute("x","20" );
      ((Element)v.get(358)).setAttribute("y","626" );
      ((Element)v.get(358)).setAttribute("ID","botonContenido" );
      ((Element)v.get(358)).setAttribute("img","primera_on" );
      ((Element)v.get(358)).setAttribute("tipo","-2" );
      ((Element)v.get(358)).setAttribute("estado","false" );
      ((Element)v.get(358)).setAttribute("alt","" );
      ((Element)v.get(358)).setAttribute("codigo","" );
      ((Element)v.get(358)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(11)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 11   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(359)).setAttribute("nombre","separa" );
      ((Element)v.get(359)).setAttribute("x","59" );
      ((Element)v.get(359)).setAttribute("y","622" );
      ((Element)v.get(359)).setAttribute("ID","botonContenido" );
      ((Element)v.get(359)).setAttribute("img","separa_base" );
      ((Element)v.get(359)).setAttribute("tipo","0" );
      ((Element)v.get(359)).setAttribute("estado","false" );
      ((Element)v.get(359)).setAttribute("alt","" );
      ((Element)v.get(359)).setAttribute("codigo","" );
      ((Element)v.get(359)).setAttribute("accion","" );
      ((Element)v.get(11)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 11   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(360)).setAttribute("nombre","Detalle" );
      ((Element)v.get(360)).setAttribute("x","80" );
      ((Element)v.get(360)).setAttribute("y","623" );
      ((Element)v.get(360)).setAttribute("ID","botonContenido" );
      ((Element)v.get(360)).setAttribute("tipo","html" );
      ((Element)v.get(360)).setAttribute("accion","onClickDetalle();" );
      ((Element)v.get(360)).setAttribute("estado","false" );
      ((Element)v.get(360)).setAttribute("onshtab","onShTabBtnDetalle();" );
      ((Element)v.get(360)).setAttribute("cod","3" );
      ((Element)v.get(11)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */

      /* Empieza nodo:361 / Elemento padre: 11   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(361)).setAttribute("nombre","Desbloquear" );
      ((Element)v.get(361)).setAttribute("x","128" );
      ((Element)v.get(361)).setAttribute("y","623" );
      ((Element)v.get(361)).setAttribute("ID","botonContenido" );
      ((Element)v.get(361)).setAttribute("img","" );
      ((Element)v.get(361)).setAttribute("tipo","html" );
      ((Element)v.get(361)).setAttribute("accion","onClickDesbloquear();" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(361)).setAttribute("estado","false" );
      ((Element)v.get(361)).setAttribute("alt","" );
      ((Element)v.get(361)).setAttribute("cod","1329" );
      ((Element)v.get(11)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 11   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(362)).setAttribute("nombre","Rechazar" );
      ((Element)v.get(362)).setAttribute("x","219" );
      ((Element)v.get(362)).setAttribute("y","623" );
      ((Element)v.get(362)).setAttribute("ID","botonContenido" );
      ((Element)v.get(362)).setAttribute("img","" );
      ((Element)v.get(362)).setAttribute("tipo","html" );
      ((Element)v.get(362)).setAttribute("accion","onClickRechazar();" );
      ((Element)v.get(362)).setAttribute("ontab","focalizaSiguiente();" );
      ((Element)v.get(362)).setAttribute("estado","false" );
      ((Element)v.get(362)).setAttribute("alt","" );
      ((Element)v.get(362)).setAttribute("cod","979" );
      ((Element)v.get(11)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */

      /* Empieza nodo:363 / Elemento padre: 11   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(363)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(363)).setAttribute("alto","12" );
      ((Element)v.get(363)).setAttribute("ancho","50" );
      ((Element)v.get(363)).setAttribute("colorf","" );
      ((Element)v.get(363)).setAttribute("borde","0" );
      ((Element)v.get(363)).setAttribute("imagenf","" );
      ((Element)v.get(363)).setAttribute("repeat","" );
      ((Element)v.get(363)).setAttribute("padding","" );
      ((Element)v.get(363)).setAttribute("visibilidad","visible" );
      ((Element)v.get(363)).setAttribute("contravsb","" );
      ((Element)v.get(363)).setAttribute("x","0" );
      ((Element)v.get(363)).setAttribute("y","645" );
      ((Element)v.get(363)).setAttribute("zindex","" );
      ((Element)v.get(11)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:11   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_rec_mantener2  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_reclamos_linea_mantener" );
      ((Element)v.get(0)).setAttribute("cod","0134" );
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
      v.add(doc.createTextNode("\r   \r              \r              \r              #Cplistado1 {visibility:hidden;}\r              #CpLin1listado1 {visibility:hidden;}\r              #CpLin2listado1 {visibility:hidden;}\r              #CpLin3listado1 {visibility:hidden;}\r              #CpLin4listado1 {visibility:hidden;}\r              #Cplistado2 {visibility:hidden;}\r              #CpLin1listado2 {visibility:hidden;}\r              #CpLin2listado2 {visibility:hidden;}\r              #CpLin3listado2 {visibility:hidden;}\r              #CpLin4listado2 {visibility:hidden;}\r          \r              #primera1Div {visibility:hidden;}\r              #ret1Div {visibility:hidden;}\r              #ava1Div {visibility:hidden;}\r              #separa1Div {visibility:hidden;}\r              #primera2Div {visibility:hidden;}\r              #ret2Div {visibility:hidden;}\r              #ava2Div {visibility:hidden;} \r              #separa2Div {visibility:hidden;}\r              \r              #ocultarAbajo {visibility:hidden;}\r              #botonesAbajo {visibility:hidden;}\r              #AgregarDiv {visibility:hidden;}\r              #btnDetalleDiv {visibility:hidden;}\r              \r\r   \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("sssFRAME"));
      ((Element)v.get(3)).setAttribute("nombre","dssd" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(7)).setAttribute("src","contenido_reclamos_linea_mantener.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(8)).setAttribute("nombre","frmContenido" );
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
      ((Element)v.get(11)).setAttribute("nombre","casoUso" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","pais" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","idioma" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hCanal" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hAcceso" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hSubAcceso" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","oidSolicitud" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hLblCodClienteX" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hLblNDocX" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hLblNombreApellidosX" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hLblNumeroZonaX" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hLblEstadoClienteX" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("nombre","hMoneda" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hVModificar" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hLinea" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hOperacion" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hOidReclamo" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hExisteAnulacion" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hExisteOperacion" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hOidsAEliminar" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","numAtencion" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","oidNumDocumento" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","numDocumento" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","oidPeriodo" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","cargaPopUp" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","oidTerriAdmin" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hMatrizReclamoCabeceras" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hMatrizReclamoDetalles" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hTotalEnvia" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hTotalDevuelve" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hSaldoPagar" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hReclamoBloq" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hid_SeparadorMiles" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hid_NumeroDecimales" );
      ((Element)v.get(45)).setAttribute("valor","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(8)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hid_SeparadorDecimales" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","tamanio" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(51)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(8)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("table"));
      ((Element)v.get(52)).setAttribute("width","100%" );
      ((Element)v.get(52)).setAttribute("border","0" );
      ((Element)v.get(52)).setAttribute("cellspacing","0" );
      ((Element)v.get(52)).setAttribute("cellpadding","0" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("width","12" );
      ((Element)v.get(54)).setAttribute("align","center" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","12" );
      ((Element)v.get(55)).setAttribute("height","12" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("width","750" );
      ((Element)v.get(53)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("width","12" );
      ((Element)v.get(53)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","12" );
      ((Element)v.get(59)).setAttribute("height","1" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:53   */

      /* Empieza nodo:60 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("id","ocultarAbajo" );
      ((Element)v.get(60)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(64)).setAttribute("id","fieldResBus" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(65)).setAttribute("class","legend" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(66)).setAttribute("nombre","lblResultadosBusqueda" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("filas","1" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(66)).setAttribute("id","legend" );
      ((Element)v.get(66)).setAttribute("cod","00135" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 64   */
      v.add(doc.createElement("table"));
      ((Element)v.get(67)).setAttribute("width","100%" );
      ((Element)v.get(67)).setAttribute("border","0" );
      ((Element)v.get(67)).setAttribute("align","center" );
      ((Element)v.get(67)).setAttribute("cellspacing","0" );
      ((Element)v.get(67)).setAttribute("cellpadding","0" );
      ((Element)v.get(64)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("table"));
      ((Element)v.get(70)).setAttribute("width","627" );
      ((Element)v.get(70)).setAttribute("border","0" );
      ((Element)v.get(70)).setAttribute("align","left" );
      ((Element)v.get(70)).setAttribute("cellspacing","0" );
      ((Element)v.get(70)).setAttribute("cellpadding","0" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("colspan","4" );
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

      /* Empieza nodo:74 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(78)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(78)).setAttribute("alto","13" );
      ((Element)v.get(78)).setAttribute("filas","1" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(78)).setAttribute("id","datosTitle" );
      ((Element)v.get(78)).setAttribute("cod","263" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","25" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(82)).setAttribute("nombre","lblNDoc" );
      ((Element)v.get(82)).setAttribute("alto","13" );
      ((Element)v.get(82)).setAttribute("filas","1" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(82)).setAttribute("id","datosTitle" );
      ((Element)v.get(82)).setAttribute("cod","422" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","25" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(86)).setAttribute("nombre","lblNReclamo" );
      ((Element)v.get(86)).setAttribute("alto","13" );
      ((Element)v.get(86)).setAttribute("filas","1" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(86)).setAttribute("id","datosTitle" );
      ((Element)v.get(86)).setAttribute("cod","396" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("width","100%" );
      ((Element)v.get(74)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","8" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:74   */

      /* Empieza nodo:89 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
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
   }

   private void getXML360(Document doc) {
      ((Element)v.get(93)).setAttribute("nombre","lblCodClienteX" );
      ((Element)v.get(93)).setAttribute("alto","13" );
      ((Element)v.get(93)).setAttribute("filas","1" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(93)).setAttribute("id","datosCampos" );
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
      ((Element)v.get(97)).setAttribute("nombre","lblNDocX" );
      ((Element)v.get(97)).setAttribute("alto","13" );
      ((Element)v.get(97)).setAttribute("filas","1" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(97)).setAttribute("id","datosCampos" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","25" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(101)).setAttribute("nombre","txtNReclamo" );
      ((Element)v.get(101)).setAttribute("id","datosCampos" );
      ((Element)v.get(101)).setAttribute("max","10" );
      ((Element)v.get(101)).setAttribute("tipo","" );
      ((Element)v.get(101)).setAttribute("onchange","" );
      ((Element)v.get(101)).setAttribute("req","N" );
      ((Element)v.get(101)).setAttribute("size","15" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(101)).setAttribute("validacion","" );
      ((Element)v.get(101)).setAttribute("onblur","validaNumReclamo()" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("width","100%" );
      ((Element)v.get(89)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:89   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:104 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("table"));
      ((Element)v.get(106)).setAttribute("width","627" );
      ((Element)v.get(106)).setAttribute("border","0" );
      ((Element)v.get(106)).setAttribute("align","left" );
      ((Element)v.get(106)).setAttribute("cellspacing","0" );
      ((Element)v.get(106)).setAttribute("cellpadding","0" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("colspan","4" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:110 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(114)).setAttribute("nombre","lblNombreApellidos" );
      ((Element)v.get(114)).setAttribute("alto","13" );
      ((Element)v.get(114)).setAttribute("filas","1" );
      ((Element)v.get(114)).setAttribute("valor","" );
      ((Element)v.get(114)).setAttribute("id","datosTitle" );
      ((Element)v.get(114)).setAttribute("cod","943" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","25" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(118)).setAttribute("nombre","lblNumeroZona" );
      ((Element)v.get(118)).setAttribute("alto","13" );
      ((Element)v.get(118)).setAttribute("filas","1" );
      ((Element)v.get(118)).setAttribute("valor","" );
      ((Element)v.get(118)).setAttribute("id","datosTitle" );
      ((Element)v.get(118)).setAttribute("cod","398" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","25" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(122)).setAttribute("nombre","lblEstadoCliente" );
      ((Element)v.get(122)).setAttribute("alto","13" );
      ((Element)v.get(122)).setAttribute("filas","1" );
      ((Element)v.get(122)).setAttribute("valor","" );
      ((Element)v.get(122)).setAttribute("id","datosTitle" );
      ((Element)v.get(122)).setAttribute("cod","294" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("width","100%" );
      ((Element)v.get(110)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","8" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:110   */

      /* Empieza nodo:125 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(129)).setAttribute("nombre","lblNombreApellidosX" );
      ((Element)v.get(129)).setAttribute("alto","13" );
      ((Element)v.get(129)).setAttribute("filas","1" );
      ((Element)v.get(129)).setAttribute("valor","" );
      ((Element)v.get(129)).setAttribute("id","datosCampos" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","25" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(133)).setAttribute("nombre","lblNumeroZonaX" );
      ((Element)v.get(133)).setAttribute("alto","13" );
      ((Element)v.get(133)).setAttribute("filas","1" );
      ((Element)v.get(133)).setAttribute("valor","" );
      ((Element)v.get(133)).setAttribute("id","datosCampos" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","25" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(137)).setAttribute("nombre","lblEstadoClienteX" );
      ((Element)v.get(137)).setAttribute("alto","13" );
      ((Element)v.get(137)).setAttribute("filas","1" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(137)).setAttribute("valor","" );
      ((Element)v.get(137)).setAttribute("id","datosCampos" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("width","100%" );
      ((Element)v.get(125)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","8" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:125   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:140 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("table"));
      ((Element)v.get(142)).setAttribute("width","627" );
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
      ((Element)v.get(149)).setAttribute("width","100%" );
      ((Element)v.get(146)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:146   */

      /* Empieza nodo:151 / Elemento padre: 142   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(142)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","8" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("width","100%" );
      ((Element)v.get(151)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","8" );
      ((Element)v.get(155)).setAttribute("height","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:151   */

      /* Empieza nodo:156 / Elemento padre: 142   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(142)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("colspan","4" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","8" );
      ((Element)v.get(158)).setAttribute("height","682" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:159 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("table"));
      ((Element)v.get(161)).setAttribute("width","627" );
      ((Element)v.get(161)).setAttribute("border","0" );
      ((Element)v.get(161)).setAttribute("align","left" );
      ((Element)v.get(161)).setAttribute("cellspacing","0" );
      ((Element)v.get(161)).setAttribute("cellpadding","0" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(166)).setAttribute("nombre","lblTotalEnvia" );
      ((Element)v.get(166)).setAttribute("alto","13" );
      ((Element)v.get(166)).setAttribute("filas","1" );
      ((Element)v.get(166)).setAttribute("valor","" );
      ((Element)v.get(166)).setAttribute("id","datosTitle" );
      ((Element)v.get(166)).setAttribute("cod","310" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","25" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(170)).setAttribute("nombre","lblTotalDevuelve" );
      ((Element)v.get(170)).setAttribute("alto","13" );
      ((Element)v.get(170)).setAttribute("filas","1" );
      ((Element)v.get(170)).setAttribute("valor","" );
      ((Element)v.get(170)).setAttribute("id","datosTitle" );
      ((Element)v.get(170)).setAttribute("cod","311" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","25" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(174)).setAttribute("nombre","lblSaldoAPagar" );
      ((Element)v.get(174)).setAttribute("alto","13" );
      ((Element)v.get(174)).setAttribute("filas","1" );
      ((Element)v.get(174)).setAttribute("valor","" );
      ((Element)v.get(174)).setAttribute("id","datosTitle" );
      ((Element)v.get(174)).setAttribute("cod","312" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).setAttribute("width","100%" );
      ((Element)v.get(162)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:162   */

      /* Empieza nodo:177 / Elemento padre: 161   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(161)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(181)).setAttribute("nombre","lblTotalEnviaX" );
      ((Element)v.get(181)).setAttribute("alto","13" );
      ((Element)v.get(181)).setAttribute("filas","1" );
      ((Element)v.get(181)).setAttribute("valor","" );
      ((Element)v.get(181)).setAttribute("id","datosCampos" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","25" );
      ((Element)v.get(183)).setAttribute("height","8" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(185)).setAttribute("nombre","lblTotalDevuelveX" );
      ((Element)v.get(185)).setAttribute("alto","13" );
      ((Element)v.get(185)).setAttribute("filas","1" );
      ((Element)v.get(185)).setAttribute("valor","" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(185)).setAttribute("id","datosCampos" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","25" );
      ((Element)v.get(187)).setAttribute("height","8" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(189)).setAttribute("nombre","lblSaldoAPagarX" );
      ((Element)v.get(189)).setAttribute("alto","13" );
      ((Element)v.get(189)).setAttribute("filas","1" );
      ((Element)v.get(189)).setAttribute("valor","" );
      ((Element)v.get(189)).setAttribute("id","datosCampos" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("width","100%" );
      ((Element)v.get(177)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","8" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:177   */

      /* Empieza nodo:192 / Elemento padre: 161   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(161)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).setAttribute("colspan","4" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","8" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:67   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:195 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:60   */

      /* Empieza nodo:197 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).setAttribute("id","botonesAbajo" );
      ((Element)v.get(197)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("table"));
      ((Element)v.get(202)).setAttribute("width","100%" );
      ((Element)v.get(202)).setAttribute("border","0" );
      ((Element)v.get(202)).setAttribute("align","center" );
      ((Element)v.get(202)).setAttribute("cellspacing","0" );
      ((Element)v.get(202)).setAttribute("cellpadding","0" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).setAttribute("class","botonera" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(205)).setAttribute("nombre","ConsRec" );
      ((Element)v.get(205)).setAttribute("ID","botonContenido" );
      ((Element)v.get(205)).setAttribute("tipo","html" );
      ((Element)v.get(205)).setAttribute("accion","onclickConsultaReclamo();" );
      ((Element)v.get(205)).setAttribute("estado","false" );
      ((Element)v.get(205)).setAttribute("cod","427" );
      ((Element)v.get(205)).setAttribute("ontab","gestionFocoConsRec();" );
      ((Element)v.get(205)).setAttribute("onshtab","document.all['Agregar'].focus();" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 204   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(206)).setAttribute("nombre","GenSol" );
      ((Element)v.get(206)).setAttribute("ID","botonContenido" );
      ((Element)v.get(206)).setAttribute("accion","onClickGenerar();" );
      ((Element)v.get(206)).setAttribute("ontab","focaliza('frmContenido.btnDetalle');" );
      ((Element)v.get(206)).setAttribute("tipo","html" );
      ((Element)v.get(206)).setAttribute("estado","false" );
      ((Element)v.get(206)).setAttribute("cod","1789" );
      ((Element)v.get(204)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:207 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(208)).setAttribute("height","12" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:197   */

      /* Empieza nodo:209 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).setAttribute("width","12" );
      ((Element)v.get(210)).setAttribute("align","center" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","12" );
      ((Element)v.get(211)).setAttribute("height","12" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).setAttribute("width","750" );
      ((Element)v.get(209)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).setAttribute("width","12" );
      ((Element)v.get(209)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","12" );
      ((Element)v.get(215)).setAttribute("height","1" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:209   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:216 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(216)).setAttribute("nombre","listado1" );
      ((Element)v.get(216)).setAttribute("ancho","630" );
      ((Element)v.get(216)).setAttribute("alto","317" );
      ((Element)v.get(216)).setAttribute("x","24" );
      ((Element)v.get(216)).setAttribute("y","140" );
      ((Element)v.get(216)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(216)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(217)).setAttribute("precarga","S" );
      ((Element)v.get(217)).setAttribute("conROver","S" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(218)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(218)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(218)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(218)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 217   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(219)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(219)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(219)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(219)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(217)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 217   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(220)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(220)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(217)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:217   */

      /* Empieza nodo:221 / Elemento padre: 216   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(216)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(222)).setAttribute("borde","1" );
      ((Element)v.get(222)).setAttribute("horizDatos","1" );
      ((Element)v.get(222)).setAttribute("horizCabecera","1" );
      ((Element)v.get(222)).setAttribute("vertical","1" );
      ((Element)v.get(222)).setAttribute("horizTitulo","1" );
      ((Element)v.get(222)).setAttribute("horizBase","1" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 221   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(223)).setAttribute("borde","#999999" );
      ((Element)v.get(223)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(223)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(223)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(223)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(223)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(223)).setAttribute("horizBase","#999999" );
      ((Element)v.get(221)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:221   */

      /* Empieza nodo:224 / Elemento padre: 216   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(224)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(224)).setAttribute("alto","22" );
      ((Element)v.get(224)).setAttribute("imgFondo","" );
      ((Element)v.get(224)).setAttribute("cod","00291" );
      ((Element)v.get(224)).setAttribute("ID","datosTitle" );
      ((Element)v.get(216)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 216   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(225)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(225)).setAttribute("alto","22" );
      ((Element)v.get(225)).setAttribute("imgFondo","" );
      ((Element)v.get(216)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 216   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(226)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(226)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(226)).setAttribute("blancosAInsertar","1" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(226)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(226)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(226)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(216)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("ancho","105" );
      ((Element)v.get(227)).setAttribute("minimizable","S" );
      ((Element)v.get(227)).setAttribute("minimizada","N" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(228)).setAttribute("ancho","125" );
      ((Element)v.get(228)).setAttribute("minimizable","S" );
      ((Element)v.get(228)).setAttribute("minimizada","N" );
      ((Element)v.get(226)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("ancho","135" );
      ((Element)v.get(229)).setAttribute("minimizable","S" );
      ((Element)v.get(229)).setAttribute("minimizada","N" );
      ((Element)v.get(226)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("ancho","135" );
      ((Element)v.get(230)).setAttribute("minimizable","S" );
      ((Element)v.get(230)).setAttribute("minimizada","N" );
      ((Element)v.get(226)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("ancho","155" );
      ((Element)v.get(231)).setAttribute("minimizable","S" );
      ((Element)v.get(231)).setAttribute("minimizada","N" );
      ((Element)v.get(226)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(232)).setAttribute("ancho","105" );
      ((Element)v.get(232)).setAttribute("minimizable","S" );
      ((Element)v.get(232)).setAttribute("minimizada","N" );
      ((Element)v.get(226)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(233)).setAttribute("ancho","30" );
      ((Element)v.get(233)).setAttribute("minimizable","S" );
      ((Element)v.get(233)).setAttribute("minimizada","N" );
      ((Element)v.get(233)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */

      /* Empieza nodo:234 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(234)).setAttribute("ancho","30" );
      ((Element)v.get(234)).setAttribute("minimizable","S" );
      ((Element)v.get(234)).setAttribute("minimizada","N" );
      ((Element)v.get(234)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(235)).setAttribute("ancho","30" );
      ((Element)v.get(235)).setAttribute("minimizable","S" );
      ((Element)v.get(235)).setAttribute("minimizada","N" );
      ((Element)v.get(235)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(236)).setAttribute("ancho","30" );
      ((Element)v.get(236)).setAttribute("minimizable","S" );
      ((Element)v.get(236)).setAttribute("minimizada","N" );
      ((Element)v.get(236)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(237)).setAttribute("ancho","30" );
      ((Element)v.get(237)).setAttribute("minimizable","S" );
      ((Element)v.get(237)).setAttribute("minimizada","N" );
      ((Element)v.get(237)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(238)).setAttribute("ancho","30" );
      ((Element)v.get(238)).setAttribute("minimizable","S" );
      ((Element)v.get(238)).setAttribute("minimizada","N" );
      ((Element)v.get(238)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(239)).setAttribute("ancho","30" );
      ((Element)v.get(239)).setAttribute("minimizable","S" );
      ((Element)v.get(239)).setAttribute("minimizada","N" );
      ((Element)v.get(239)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(240)).setAttribute("ancho","30" );
      ((Element)v.get(240)).setAttribute("minimizable","S" );
      ((Element)v.get(240)).setAttribute("minimizada","N" );
      ((Element)v.get(240)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(241)).setAttribute("ancho","30" );
      ((Element)v.get(241)).setAttribute("minimizable","S" );
      ((Element)v.get(241)).setAttribute("minimizada","N" );
      ((Element)v.get(241)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(242)).setAttribute("ancho","30" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(242)).setAttribute("minimizable","S" );
      ((Element)v.get(242)).setAttribute("minimizada","N" );
      ((Element)v.get(242)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(243)).setAttribute("ancho","30" );
      ((Element)v.get(243)).setAttribute("minimizable","S" );
      ((Element)v.get(243)).setAttribute("minimizada","N" );
      ((Element)v.get(243)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(244)).setAttribute("ancho","30" );
      ((Element)v.get(244)).setAttribute("minimizable","S" );
      ((Element)v.get(244)).setAttribute("minimizada","N" );
      ((Element)v.get(244)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(245)).setAttribute("ancho","30" );
      ((Element)v.get(245)).setAttribute("minimizable","S" );
      ((Element)v.get(245)).setAttribute("minimizada","N" );
      ((Element)v.get(245)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */

      /* Empieza nodo:246 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(246)).setAttribute("ancho","95" );
      ((Element)v.get(246)).setAttribute("minimizable","S" );
      ((Element)v.get(246)).setAttribute("minimizada","N" );
      ((Element)v.get(246)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */

      /* Empieza nodo:247 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(247)).setAttribute("ancho","105" );
      ((Element)v.get(247)).setAttribute("minimizable","S" );
      ((Element)v.get(247)).setAttribute("minimizada","N" );
      ((Element)v.get(247)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(248)).setAttribute("ancho","105" );
      ((Element)v.get(248)).setAttribute("minimizable","S" );
      ((Element)v.get(248)).setAttribute("minimizada","N" );
      ((Element)v.get(248)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */

      /* Empieza nodo:249 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(249)).setAttribute("ancho","105" );
      ((Element)v.get(249)).setAttribute("minimizable","S" );
      ((Element)v.get(249)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(250)).setAttribute("ancho","105" );
      ((Element)v.get(250)).setAttribute("minimizable","S" );
      ((Element)v.get(250)).setAttribute("minimizada","N" );
      ((Element)v.get(250)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(251)).setAttribute("ancho","105" );
      ((Element)v.get(251)).setAttribute("minimizable","S" );
      ((Element)v.get(251)).setAttribute("minimizada","N" );
      ((Element)v.get(251)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("ancho","105" );
      ((Element)v.get(252)).setAttribute("minimizable","S" );
      ((Element)v.get(252)).setAttribute("minimizada","N" );
      ((Element)v.get(252)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(253)).setAttribute("ancho","105" );
      ((Element)v.get(253)).setAttribute("minimizable","S" );
      ((Element)v.get(253)).setAttribute("minimizada","N" );
      ((Element)v.get(253)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(254)).setAttribute("ancho","105" );
      ((Element)v.get(254)).setAttribute("minimizable","S" );
      ((Element)v.get(254)).setAttribute("minimizada","N" );
      ((Element)v.get(254)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("ancho","105" );
      ((Element)v.get(255)).setAttribute("minimizable","S" );
      ((Element)v.get(255)).setAttribute("minimizada","N" );
      ((Element)v.get(255)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(256)).setAttribute("ancho","105" );
      ((Element)v.get(256)).setAttribute("minimizable","S" );
      ((Element)v.get(256)).setAttribute("minimizada","N" );
      ((Element)v.get(256)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("ancho","105" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(257)).setAttribute("minimizable","S" );
      ((Element)v.get(257)).setAttribute("minimizada","N" );
      ((Element)v.get(257)).setAttribute("oculta","S" );
      ((Element)v.get(226)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:226   */

      /* Empieza nodo:258 / Elemento padre: 216   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(258)).setAttribute("alto","34" );
      ((Element)v.get(258)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(258)).setAttribute("imgFondo","" );
      ((Element)v.get(258)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(216)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(259)).setAttribute("colFondo","" );
      ((Element)v.get(259)).setAttribute("ID","EstCab" );
      ((Element)v.get(259)).setAttribute("cod","299" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(260)).setAttribute("colFondo","" );
      ((Element)v.get(260)).setAttribute("ID","EstCab" );
      ((Element)v.get(260)).setAttribute("cod","301" );
      ((Element)v.get(258)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(261)).setAttribute("colFondo","" );
      ((Element)v.get(261)).setAttribute("ID","EstCab" );
      ((Element)v.get(261)).setAttribute("cod","374" );
      ((Element)v.get(258)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */

      /* Empieza nodo:262 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(262)).setAttribute("colFondo","" );
      ((Element)v.get(262)).setAttribute("ID","EstCab" );
      ((Element)v.get(262)).setAttribute("cod","331" );
      ((Element)v.get(258)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(263)).setAttribute("colFondo","" );
      ((Element)v.get(263)).setAttribute("ID","EstCab" );
      ((Element)v.get(263)).setAttribute("cod","425" );
      ((Element)v.get(258)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */

      /* Empieza nodo:264 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(264)).setAttribute("colFondo","" );
      ((Element)v.get(264)).setAttribute("ID","EstCab" );
      ((Element)v.get(264)).setAttribute("cod","1393" );
      ((Element)v.get(258)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("colFondo","" );
      ((Element)v.get(265)).setAttribute("ID","EstCab" );
      ((Element)v.get(258)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(266)).setAttribute("colFondo","" );
      ((Element)v.get(266)).setAttribute("ID","EstCab" );
      ((Element)v.get(258)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(267)).setAttribute("colFondo","" );
      ((Element)v.get(267)).setAttribute("ID","EstCab" );
      ((Element)v.get(258)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("colFondo","" );
      ((Element)v.get(268)).setAttribute("ID","EstCab" );
      ((Element)v.get(258)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("colFondo","" );
      ((Element)v.get(269)).setAttribute("ID","EstCab" );
      ((Element)v.get(258)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("colFondo","" );
      ((Element)v.get(270)).setAttribute("ID","EstCab" );
      ((Element)v.get(258)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(271)).setAttribute("colFondo","" );
      ((Element)v.get(271)).setAttribute("ID","EstCab" );
      ((Element)v.get(258)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("colFondo","" );
      ((Element)v.get(272)).setAttribute("ID","EstCab" );
      ((Element)v.get(258)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("colFondo","" );
      ((Element)v.get(273)).setAttribute("ID","EstCab" );
      ((Element)v.get(258)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("colFondo","" );
      ((Element)v.get(274)).setAttribute("ID","EstCab" );
      ((Element)v.get(258)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("colFondo","" );
      ((Element)v.get(275)).setAttribute("ID","EstCab" );
      ((Element)v.get(258)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("colFondo","" );
      ((Element)v.get(276)).setAttribute("ID","EstCab" );
      ((Element)v.get(258)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("colFondo","" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(277)).setAttribute("ID","EstCab" );
      ((Element)v.get(258)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("colFondo","" );
      ((Element)v.get(278)).setAttribute("ID","EstCab" );
      ((Element)v.get(278)).setAttribute("cod","1560" );
      ((Element)v.get(258)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("colFondo","" );
      ((Element)v.get(279)).setAttribute("ID","EstCab" );
      ((Element)v.get(279)).setAttribute("cod","342" );
      ((Element)v.get(258)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("colFondo","" );
      ((Element)v.get(280)).setAttribute("ID","EstCab" );
      ((Element)v.get(280)).setAttribute("cod","343" );
      ((Element)v.get(258)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(281)).setAttribute("colFondo","" );
      ((Element)v.get(281)).setAttribute("ID","EstCab" );
      ((Element)v.get(281)).setAttribute("cod","346" );
      ((Element)v.get(258)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(282)).setAttribute("colFondo","" );
      ((Element)v.get(282)).setAttribute("ID","EstCab" );
      ((Element)v.get(282)).setAttribute("cod","347" );
      ((Element)v.get(258)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(283)).setAttribute("colFondo","" );
      ((Element)v.get(283)).setAttribute("ID","EstCab" );
      ((Element)v.get(283)).setAttribute("cod","2764" );
      ((Element)v.get(258)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("colFondo","" );
      ((Element)v.get(284)).setAttribute("ID","EstCab" );
      ((Element)v.get(284)).setAttribute("cod","3073" );
      ((Element)v.get(258)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("colFondo","" );
      ((Element)v.get(285)).setAttribute("ID","EstCab" );
      ((Element)v.get(285)).setAttribute("cod","3072" );
      ((Element)v.get(258)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(286)).setAttribute("colFondo","" );
      ((Element)v.get(286)).setAttribute("ID","EstCab" );
      ((Element)v.get(286)).setAttribute("cod","345" );
      ((Element)v.get(258)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(287)).setAttribute("colFondo","" );
      ((Element)v.get(287)).setAttribute("ID","EstCab" );
      ((Element)v.get(287)).setAttribute("cod","348" );
      ((Element)v.get(258)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(288)).setAttribute("colFondo","" );
      ((Element)v.get(288)).setAttribute("ID","EstCab" );
      ((Element)v.get(288)).setAttribute("cod","349" );
      ((Element)v.get(258)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 258   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(289)).setAttribute("colFondo","" );
      ((Element)v.get(289)).setAttribute("ID","EstCab" );
      ((Element)v.get(289)).setAttribute("cod","350" );
      ((Element)v.get(258)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:258   */

      /* Empieza nodo:290 / Elemento padre: 216   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(290)).setAttribute("alto","22" );
      ((Element)v.get(290)).setAttribute("accion","" );
      ((Element)v.get(290)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(290)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(290)).setAttribute("maxSel","-1" );
      ((Element)v.get(290)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(290)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(290)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(290)).setAttribute("onLoad","" );
      ((Element)v.get(290)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(216)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(291)).setAttribute("tipo","texto" );
      ((Element)v.get(291)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("tipo","texto" );
      ((Element)v.get(292)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(293)).setAttribute("tipo","texto" );
      ((Element)v.get(293)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(294)).setAttribute("tipo","texto" );
      ((Element)v.get(294)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 290   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(295)).setAttribute("tipo","texto" );
      ((Element)v.get(295)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(296)).setAttribute("tipo","texto" );
      ((Element)v.get(296)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(297)).setAttribute("tipo","texto" );
      ((Element)v.get(297)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */

      /* Empieza nodo:298 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(298)).setAttribute("tipo","texto" );
      ((Element)v.get(298)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(299)).setAttribute("tipo","texto" );
      ((Element)v.get(299)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(300)).setAttribute("tipo","texto" );
      ((Element)v.get(300)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(301)).setAttribute("tipo","texto" );
      ((Element)v.get(301)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(302)).setAttribute("tipo","texto" );
      ((Element)v.get(302)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(303)).setAttribute("tipo","texto" );
      ((Element)v.get(303)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(304)).setAttribute("tipo","texto" );
      ((Element)v.get(304)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("tipo","texto" );
      ((Element)v.get(305)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(306)).setAttribute("tipo","texto" );
      ((Element)v.get(306)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(307)).setAttribute("tipo","texto" );
      ((Element)v.get(307)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */

      /* Empieza nodo:308 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(308)).setAttribute("tipo","texto" );
      ((Element)v.get(308)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(309)).setAttribute("tipo","texto" );
      ((Element)v.get(309)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */

      /* Empieza nodo:310 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(310)).setAttribute("tipo","texto" );
      ((Element)v.get(310)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(311)).setAttribute("tipo","texto" );
      ((Element)v.get(311)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(312)).setAttribute("tipo","texto" );
      ((Element)v.get(312)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */

      /* Empieza nodo:313 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(313)).setAttribute("tipo","texto" );
      ((Element)v.get(313)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */

      /* Empieza nodo:314 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(314)).setAttribute("tipo","texto" );
      ((Element)v.get(314)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */

      /* Empieza nodo:315 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(315)).setAttribute("tipo","texto" );
      ((Element)v.get(315)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */

      /* Empieza nodo:316 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(316)).setAttribute("tipo","texto" );
      ((Element)v.get(316)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */

      /* Empieza nodo:317 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(317)).setAttribute("tipo","texto" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(317)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */

      /* Empieza nodo:318 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(318)).setAttribute("tipo","texto" );
      ((Element)v.get(318)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */

      /* Empieza nodo:319 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(319)).setAttribute("tipo","texto" );
      ((Element)v.get(319)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(320)).setAttribute("tipo","texto" );
      ((Element)v.get(320)).setAttribute("ID","EstDat" );
      ((Element)v.get(290)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(321)).setAttribute("tipo","texto" );
      ((Element)v.get(321)).setAttribute("ID","EstDat2" );
      ((Element)v.get(290)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:290   */

      /* Empieza nodo:322 / Elemento padre: 216   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(216)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */

      /* Empieza nodo:323 / Elemento padre: 216   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(323)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(323)).setAttribute("ancho","630" );
      ((Element)v.get(323)).setAttribute("sep","$" );
      ((Element)v.get(323)).setAttribute("x","24" );
      ((Element)v.get(323)).setAttribute("class","botonera" );
      ((Element)v.get(323)).setAttribute("y","434" );
      ((Element)v.get(323)).setAttribute("control","|" );
      ((Element)v.get(323)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(323)).setAttribute("rowset","" );
      ((Element)v.get(323)).setAttribute("cargainicial","N" );
      ((Element)v.get(216)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(324)).setAttribute("nombre","ret1" );
      ((Element)v.get(324)).setAttribute("x","49" );
      ((Element)v.get(324)).setAttribute("y","438" );
      ((Element)v.get(324)).setAttribute("ID","botonContenido" );
      ((Element)v.get(324)).setAttribute("img","retroceder_on" );
      ((Element)v.get(324)).setAttribute("tipo","0" );
      ((Element)v.get(324)).setAttribute("estado","false" );
      ((Element)v.get(324)).setAttribute("alt","" );
      ((Element)v.get(324)).setAttribute("codigo","" );
      ((Element)v.get(324)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */

      /* Empieza nodo:325 / Elemento padre: 323   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(325)).setAttribute("nombre","ava1" );
      ((Element)v.get(325)).setAttribute("x","64" );
      ((Element)v.get(325)).setAttribute("y","438" );
      ((Element)v.get(325)).setAttribute("ID","botonContenido" );
      ((Element)v.get(325)).setAttribute("img","avanzar_on" );
      ((Element)v.get(325)).setAttribute("tipo","0" );
      ((Element)v.get(325)).setAttribute("estado","false" );
      ((Element)v.get(325)).setAttribute("alt","" );
      ((Element)v.get(325)).setAttribute("codigo","" );
      ((Element)v.get(325)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(323)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:323   */
      /* Termina nodo:216   */

      /* Empieza nodo:326 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(326)).setAttribute("nombre","primera1" );
      ((Element)v.get(326)).setAttribute("x","32" );
      ((Element)v.get(326)).setAttribute("y","438" );
      ((Element)v.get(326)).setAttribute("ID","botonContenido" );
      ((Element)v.get(326)).setAttribute("img","primera_on" );
      ((Element)v.get(326)).setAttribute("tipo","0" );
      ((Element)v.get(326)).setAttribute("estado","false" );
      ((Element)v.get(326)).setAttribute("alt","" );
      ((Element)v.get(326)).setAttribute("codigo","" );
      ((Element)v.get(326)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */

      /* Empieza nodo:327 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(327)).setAttribute("nombre","separa1" );
      ((Element)v.get(327)).setAttribute("x","71" );
      ((Element)v.get(327)).setAttribute("y","434" );
      ((Element)v.get(327)).setAttribute("ID","botonContenido" );
      ((Element)v.get(327)).setAttribute("img","separa_base" );
      ((Element)v.get(327)).setAttribute("tipo","0" );
      ((Element)v.get(327)).setAttribute("estado","false" );
      ((Element)v.get(327)).setAttribute("alt","" );
      ((Element)v.get(327)).setAttribute("codigo","" );
      ((Element)v.get(327)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */

      /* Empieza nodo:328 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(328)).setAttribute("nombre","Agregar" );
      ((Element)v.get(328)).setAttribute("x","92" );
      ((Element)v.get(328)).setAttribute("y","434" );
      ((Element)v.get(328)).setAttribute("ID","botonContenido" );
      ((Element)v.get(328)).setAttribute("tipo","html" );
      ((Element)v.get(328)).setAttribute("estado","false" );
      ((Element)v.get(328)).setAttribute("cod","426" );
      ((Element)v.get(328)).setAttribute("accion","onClickAgregar();" );
      ((Element)v.get(328)).setAttribute("onshtab","focaliza('frmContenido.ConsRec');" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(8)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */

      /* Empieza nodo:329 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(329)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(329)).setAttribute("x","160" );
      ((Element)v.get(329)).setAttribute("y","434" );
      ((Element)v.get(329)).setAttribute("ID","botonContenido" );
      ((Element)v.get(329)).setAttribute("tipo","html" );
      ((Element)v.get(329)).setAttribute("accion","onClickDetalle();" );
      ((Element)v.get(329)).setAttribute("ontab","document.all['ConsRec'].focus();" );
      ((Element)v.get(329)).setAttribute("estado","false" );
      ((Element)v.get(329)).setAttribute("cod","3" );
      ((Element)v.get(329)).setAttribute("onshtab","document.all['Agregar'].focus();" );
      ((Element)v.get(8)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */

      /* Empieza nodo:330 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(330)).setAttribute("nombre","listado2" );
      ((Element)v.get(330)).setAttribute("ancho","630" );
      ((Element)v.get(330)).setAttribute("alto","317" );
      ((Element)v.get(330)).setAttribute("x","24" );
      ((Element)v.get(330)).setAttribute("y","480" );
      ((Element)v.get(330)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(330)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(331)).setAttribute("precarga","S" );
      ((Element)v.get(331)).setAttribute("conROver","S" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(332)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(332)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(332)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(332)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */

      /* Empieza nodo:333 / Elemento padre: 331   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(333)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(333)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(333)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(333)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(331)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */

      /* Empieza nodo:334 / Elemento padre: 331   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(334)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(334)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(331)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:331   */

      /* Empieza nodo:335 / Elemento padre: 330   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(330)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(336)).setAttribute("borde","1" );
      ((Element)v.get(336)).setAttribute("horizDatos","1" );
      ((Element)v.get(336)).setAttribute("horizCabecera","1" );
      ((Element)v.get(336)).setAttribute("vertical","1" );
      ((Element)v.get(336)).setAttribute("horizTitulo","1" );
      ((Element)v.get(336)).setAttribute("horizBase","1" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */

      /* Empieza nodo:337 / Elemento padre: 335   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(337)).setAttribute("borde","#999999" );
      ((Element)v.get(337)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(337)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(337)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(337)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(337)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(337)).setAttribute("horizBase","#999999" );
      ((Element)v.get(335)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:335   */

      /* Empieza nodo:338 / Elemento padre: 330   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(338)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(338)).setAttribute("alto","22" );
      ((Element)v.get(338)).setAttribute("imgFondo","" );
      ((Element)v.get(338)).setAttribute("cod","00299" );
      ((Element)v.get(338)).setAttribute("ID","datosTitle" );
      ((Element)v.get(330)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */

      /* Empieza nodo:339 / Elemento padre: 330   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(339)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(339)).setAttribute("alto","22" );
      ((Element)v.get(339)).setAttribute("imgFondo","" );
      ((Element)v.get(330)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */

      /* Empieza nodo:340 / Elemento padre: 330   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(340)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(340)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(340)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(340)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(340)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(340)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(330)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(341)).setAttribute("ancho","100" );
      ((Element)v.get(341)).setAttribute("minimizable","S" );
      ((Element)v.get(341)).setAttribute("minimizada","N" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */

      /* Empieza nodo:342 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(342)).setAttribute("ancho","100" );
      ((Element)v.get(342)).setAttribute("minimizable","S" );
      ((Element)v.get(342)).setAttribute("minimizada","N" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(340)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */

      /* Empieza nodo:343 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(343)).setAttribute("ancho","100" );
      ((Element)v.get(343)).setAttribute("minimizable","S" );
      ((Element)v.get(343)).setAttribute("minimizada","N" );
      ((Element)v.get(340)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */

      /* Empieza nodo:344 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(344)).setAttribute("ancho","100" );
      ((Element)v.get(344)).setAttribute("minimizable","S" );
      ((Element)v.get(344)).setAttribute("minimizada","N" );
      ((Element)v.get(340)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */

      /* Empieza nodo:345 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(345)).setAttribute("ancho","135" );
      ((Element)v.get(345)).setAttribute("minimizable","S" );
      ((Element)v.get(345)).setAttribute("minimizada","N" );
      ((Element)v.get(340)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */

      /* Empieza nodo:346 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(346)).setAttribute("ancho","100" );
      ((Element)v.get(346)).setAttribute("minimizable","S" );
      ((Element)v.get(346)).setAttribute("minimizada","N" );
      ((Element)v.get(340)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */

      /* Empieza nodo:347 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(347)).setAttribute("ancho","100" );
      ((Element)v.get(347)).setAttribute("minimizable","S" );
      ((Element)v.get(347)).setAttribute("minimizada","N" );
      ((Element)v.get(340)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */

      /* Empieza nodo:348 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(348)).setAttribute("ancho","130" );
      ((Element)v.get(348)).setAttribute("minimizable","S" );
      ((Element)v.get(348)).setAttribute("minimizada","N" );
      ((Element)v.get(340)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */

      /* Empieza nodo:349 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(349)).setAttribute("ancho","100" );
      ((Element)v.get(349)).setAttribute("minimizable","S" );
      ((Element)v.get(349)).setAttribute("minimizada","N" );
      ((Element)v.get(340)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */

      /* Empieza nodo:350 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(350)).setAttribute("ancho","100" );
      ((Element)v.get(350)).setAttribute("minimizable","S" );
      ((Element)v.get(350)).setAttribute("minimizada","N" );
      ((Element)v.get(340)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */

      /* Empieza nodo:351 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(351)).setAttribute("ancho","100" );
      ((Element)v.get(351)).setAttribute("minimizable","S" );
      ((Element)v.get(351)).setAttribute("minimizada","N" );
      ((Element)v.get(351)).setAttribute("oculta","S" );
      ((Element)v.get(340)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */

      /* Empieza nodo:352 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(352)).setAttribute("ancho","30" );
      ((Element)v.get(352)).setAttribute("minimizable","S" );
      ((Element)v.get(352)).setAttribute("minimizada","N" );
      ((Element)v.get(352)).setAttribute("oculta","S" );
      ((Element)v.get(340)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */

      /* Empieza nodo:353 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(353)).setAttribute("ancho","30" );
      ((Element)v.get(353)).setAttribute("minimizable","S" );
      ((Element)v.get(353)).setAttribute("minimizada","N" );
      ((Element)v.get(353)).setAttribute("oculta","S" );
      ((Element)v.get(340)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */

      /* Empieza nodo:354 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(354)).setAttribute("ancho","30" );
      ((Element)v.get(354)).setAttribute("minimizable","S" );
      ((Element)v.get(354)).setAttribute("minimizada","N" );
      ((Element)v.get(354)).setAttribute("oculta","S" );
      ((Element)v.get(340)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */

      /* Empieza nodo:355 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(355)).setAttribute("ancho","30" );
      ((Element)v.get(355)).setAttribute("minimizable","S" );
      ((Element)v.get(355)).setAttribute("minimizada","N" );
      ((Element)v.get(355)).setAttribute("oculta","S" );
      ((Element)v.get(340)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */

      /* Empieza nodo:356 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(356)).setAttribute("ancho","100" );
      ((Element)v.get(356)).setAttribute("minimizable","S" );
      ((Element)v.get(356)).setAttribute("minimizada","N" );
      ((Element)v.get(356)).setAttribute("oculta","S" );
      ((Element)v.get(340)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */

      /* Empieza nodo:357 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(357)).setAttribute("ancho","100" );
      ((Element)v.get(357)).setAttribute("minimizable","S" );
      ((Element)v.get(357)).setAttribute("minimizada","N" );
      ((Element)v.get(357)).setAttribute("oculta","S" );
      ((Element)v.get(340)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */

      /* Empieza nodo:358 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(358)).setAttribute("ancho","30" );
      ((Element)v.get(358)).setAttribute("minimizable","S" );
      ((Element)v.get(358)).setAttribute("minimizada","N" );
      ((Element)v.get(358)).setAttribute("oculta","S" );
      ((Element)v.get(340)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(359)).setAttribute("ancho","30" );
      ((Element)v.get(359)).setAttribute("minimizable","S" );
      ((Element)v.get(359)).setAttribute("minimizada","N" );
      ((Element)v.get(359)).setAttribute("oculta","S" );
      ((Element)v.get(340)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:340   */

      /* Empieza nodo:360 / Elemento padre: 330   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(360)).setAttribute("alto","20" );
      ((Element)v.get(360)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(360)).setAttribute("imgFondo","" );
      ((Element)v.get(360)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(330)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(361)).setAttribute("colFondo","" );
      ((Element)v.get(361)).setAttribute("ID","EstCab" );
      ((Element)v.get(361)).setAttribute("cod","304" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(362)).setAttribute("colFondo","" );
      ((Element)v.get(362)).setAttribute("ID","EstCab" );
      ((Element)v.get(362)).setAttribute("cod","336" );
      ((Element)v.get(360)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */

      /* Empieza nodo:363 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(363)).setAttribute("colFondo","" );
      ((Element)v.get(363)).setAttribute("ID","EstCab" );
      ((Element)v.get(363)).setAttribute("cod","337" );
      ((Element)v.get(360)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */

      /* Empieza nodo:364 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(364)).setAttribute("colFondo","" );
      ((Element)v.get(364)).setAttribute("ID","EstCab" );
      ((Element)v.get(364)).setAttribute("cod","9" );
      ((Element)v.get(360)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */

      /* Empieza nodo:365 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(365)).setAttribute("colFondo","" );
      ((Element)v.get(365)).setAttribute("ID","EstCab" );
      ((Element)v.get(365)).setAttribute("cod","339" );
      ((Element)v.get(360)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */

      /* Empieza nodo:366 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(366)).setAttribute("colFondo","" );
      ((Element)v.get(366)).setAttribute("ID","EstCab" );
      ((Element)v.get(366)).setAttribute("cod","377" );
      ((Element)v.get(360)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */

      /* Empieza nodo:367 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(367)).setAttribute("colFondo","" );
      ((Element)v.get(367)).setAttribute("ID","EstCab" );
      ((Element)v.get(367)).setAttribute("cod","341" );
      ((Element)v.get(360)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */

      /* Empieza nodo:368 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(368)).setAttribute("colFondo","" );
      ((Element)v.get(368)).setAttribute("ID","EstCab" );
      ((Element)v.get(368)).setAttribute("cod","309" );
      ((Element)v.get(360)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */

      /* Empieza nodo:369 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(369)).setAttribute("colFondo","" );
      ((Element)v.get(369)).setAttribute("ID","EstCab" );
      ((Element)v.get(369)).setAttribute("cod","307" );
      ((Element)v.get(360)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */

      /* Empieza nodo:370 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(370)).setAttribute("colFondo","" );
      ((Element)v.get(370)).setAttribute("ID","EstCab" );
      ((Element)v.get(370)).setAttribute("cod","308" );
      ((Element)v.get(360)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */

      /* Empieza nodo:371 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(371)).setAttribute("colFondo","" );
      ((Element)v.get(371)).setAttribute("ID","EstCab" );
      ((Element)v.get(360)).appendChild((Element)v.get(371));

      /* Elemento padre:371 / Elemento actual: 372   */
      v.add(doc.createTextNode("motivoDevolucion"));
      ((Element)v.get(371)).appendChild((Text)v.get(372));

      /* Termina nodo Texto:372   */
      /* Termina nodo:371   */

      /* Empieza nodo:373 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(373)).setAttribute("colFondo","" );
      ((Element)v.get(373)).setAttribute("ID","EstCab" );
      ((Element)v.get(360)).appendChild((Element)v.get(373));

      /* Elemento padre:373 / Elemento actual: 374   */
      v.add(doc.createTextNode("numLinea"));
      ((Element)v.get(373)).appendChild((Text)v.get(374));

      /* Termina nodo Texto:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:375 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(375)).setAttribute("colFondo","" );
      ((Element)v.get(375)).setAttribute("ID","EstCab" );
      ((Element)v.get(360)).appendChild((Element)v.get(375));

      /* Elemento padre:375 / Elemento actual: 376   */
      v.add(doc.createTextNode("oidTipoMovi"));
      ((Element)v.get(375)).appendChild((Text)v.get(376));

      /* Termina nodo Texto:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(377)).setAttribute("colFondo","" );
      ((Element)v.get(377)).setAttribute("ID","EstCab" );
      ((Element)v.get(360)).appendChild((Element)v.get(377));

      /* Elemento padre:377 / Elemento actual: 378   */
      v.add(doc.createTextNode("oidCodVenta"));
      ((Element)v.get(377)).appendChild((Text)v.get(378));

      /* Termina nodo Texto:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(379)).setAttribute("colFondo","" );
      ((Element)v.get(379)).setAttribute("ID","EstCab" );
      ((Element)v.get(360)).appendChild((Element)v.get(379));

      /* Elemento padre:379 / Elemento actual: 380   */
      v.add(doc.createTextNode("oidCodProducto"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(379)).appendChild((Text)v.get(380));

      /* Termina nodo Texto:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(381)).setAttribute("colFondo","" );
      ((Element)v.get(381)).setAttribute("ID","EstCab" );
      ((Element)v.get(381)).setAttribute("cod","348" );
      ((Element)v.get(360)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */

      /* Empieza nodo:382 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(382)).setAttribute("colFondo","" );
      ((Element)v.get(382)).setAttribute("ID","EstCab" );
      ((Element)v.get(360)).appendChild((Element)v.get(382));

      /* Elemento padre:382 / Elemento actual: 383   */
      v.add(doc.createTextNode("precioCalculo"));
      ((Element)v.get(382)).appendChild((Text)v.get(383));

      /* Termina nodo Texto:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:384 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(384)).setAttribute("colFondo","" );
      ((Element)v.get(384)).setAttribute("ID","EstCab" );
      ((Element)v.get(360)).appendChild((Element)v.get(384));

      /* Elemento padre:384 / Elemento actual: 385   */
      v.add(doc.createTextNode("oidOperacion"));
      ((Element)v.get(384)).appendChild((Text)v.get(385));

      /* Termina nodo Texto:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:386 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(386)).setAttribute("colFondo","" );
      ((Element)v.get(386)).setAttribute("ID","EstCab" );
      ((Element)v.get(360)).appendChild((Element)v.get(386));

      /* Elemento padre:386 / Elemento actual: 387   */
      v.add(doc.createTextNode("oidPosicion"));
      ((Element)v.get(386)).appendChild((Text)v.get(387));

      /* Termina nodo Texto:387   */
      /* Termina nodo:386   */
      /* Termina nodo:360   */

      /* Empieza nodo:388 / Elemento padre: 330   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(388)).setAttribute("alto","22" );
      ((Element)v.get(388)).setAttribute("accion","" );
      ((Element)v.get(388)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(388)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(388)).setAttribute("maxSel","-1" );
      ((Element)v.get(388)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(388)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(388)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(388)).setAttribute("onLoad","" );
      ((Element)v.get(388)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(330)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(389)).setAttribute("tipo","texto" );
      ((Element)v.get(389)).setAttribute("ID","EstDat" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */

      /* Empieza nodo:390 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(390)).setAttribute("tipo","texto" );
      ((Element)v.get(390)).setAttribute("ID","EstDat2" );
      ((Element)v.get(388)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */

      /* Empieza nodo:391 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(391)).setAttribute("tipo","texto" );
      ((Element)v.get(391)).setAttribute("ID","EstDat" );
      ((Element)v.get(388)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */

      /* Empieza nodo:392 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(392)).setAttribute("tipo","texto" );
      ((Element)v.get(392)).setAttribute("ID","EstDat2" );
      ((Element)v.get(388)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */

      /* Empieza nodo:393 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(393)).setAttribute("tipo","texto" );
      ((Element)v.get(393)).setAttribute("ID","EstDat" );
      ((Element)v.get(388)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */

      /* Empieza nodo:394 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(394)).setAttribute("tipo","texto" );
      ((Element)v.get(394)).setAttribute("ID","EstDat2" );
      ((Element)v.get(388)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */

      /* Empieza nodo:395 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(395)).setAttribute("tipo","texto" );
      ((Element)v.get(395)).setAttribute("ID","EstDat" );
      ((Element)v.get(388)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */

      /* Empieza nodo:396 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(396)).setAttribute("tipo","texto" );
      ((Element)v.get(396)).setAttribute("ID","EstDat2" );
      ((Element)v.get(388)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */

      /* Empieza nodo:397 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(397)).setAttribute("tipo","texto" );
      ((Element)v.get(397)).setAttribute("ID","EstDat" );
      ((Element)v.get(388)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */

      /* Empieza nodo:398 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(398)).setAttribute("tipo","texto" );
      ((Element)v.get(398)).setAttribute("ID","EstDat2" );
      ((Element)v.get(388)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */

      /* Empieza nodo:399 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(399)).setAttribute("tipo","texto" );
      ((Element)v.get(399)).setAttribute("ID","EstDat" );
      ((Element)v.get(388)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */

      /* Empieza nodo:400 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(400)).setAttribute("tipo","texto" );
      ((Element)v.get(400)).setAttribute("ID","EstDat2" );
      ((Element)v.get(388)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */

      /* Empieza nodo:401 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(401)).setAttribute("tipo","texto" );
      ((Element)v.get(401)).setAttribute("ID","EstDat" );
      ((Element)v.get(388)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */

      /* Empieza nodo:402 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(402)).setAttribute("tipo","texto" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(402)).setAttribute("ID","EstDat2" );
      ((Element)v.get(388)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */

      /* Empieza nodo:403 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(403)).setAttribute("tipo","texto" );
      ((Element)v.get(403)).setAttribute("ID","EstDat" );
      ((Element)v.get(388)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */

      /* Empieza nodo:404 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(404)).setAttribute("tipo","texto" );
      ((Element)v.get(404)).setAttribute("ID","EstDat2" );
      ((Element)v.get(388)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */

      /* Empieza nodo:405 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(405)).setAttribute("tipo","texto" );
      ((Element)v.get(405)).setAttribute("ID","EstDat" );
      ((Element)v.get(388)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */

      /* Empieza nodo:406 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(406)).setAttribute("tipo","texto" );
      ((Element)v.get(406)).setAttribute("ID","EstDat2" );
      ((Element)v.get(388)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */

      /* Empieza nodo:407 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(407)).setAttribute("tipo","texto" );
      ((Element)v.get(407)).setAttribute("ID","EstDat" );
      ((Element)v.get(388)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:388   */

      /* Empieza nodo:408 / Elemento padre: 330   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(330)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */

      /* Empieza nodo:409 / Elemento padre: 330   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(409)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(409)).setAttribute("ancho","630" );
      ((Element)v.get(409)).setAttribute("sep","$" );
      ((Element)v.get(409)).setAttribute("x","24" );
      ((Element)v.get(409)).setAttribute("class","botonera" );
      ((Element)v.get(409)).setAttribute("y","774" );
      ((Element)v.get(409)).setAttribute("control","|" );
      ((Element)v.get(409)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(409)).setAttribute("rowset","" );
      ((Element)v.get(409)).setAttribute("cargainicial","N" );
      ((Element)v.get(330)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(410)).setAttribute("nombre","ret2" );
      ((Element)v.get(410)).setAttribute("x","49" );
      ((Element)v.get(410)).setAttribute("y","778" );
      ((Element)v.get(410)).setAttribute("ID","botonContenido" );
      ((Element)v.get(410)).setAttribute("img","retroceder_on" );
      ((Element)v.get(410)).setAttribute("tipo","0" );
      ((Element)v.get(410)).setAttribute("estado","false" );
      ((Element)v.get(410)).setAttribute("alt","" );
      ((Element)v.get(410)).setAttribute("codigo","" );
      ((Element)v.get(410)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */

      /* Empieza nodo:411 / Elemento padre: 409   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(411)).setAttribute("nombre","ava2" );
      ((Element)v.get(411)).setAttribute("x","64" );
      ((Element)v.get(411)).setAttribute("y","778" );
      ((Element)v.get(411)).setAttribute("ID","botonContenido" );
      ((Element)v.get(411)).setAttribute("img","avanzar_on" );
      ((Element)v.get(411)).setAttribute("tipo","0" );
      ((Element)v.get(411)).setAttribute("estado","false" );
      ((Element)v.get(411)).setAttribute("alt","" );
      ((Element)v.get(411)).setAttribute("codigo","" );
      ((Element)v.get(411)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(409)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:409   */
      /* Termina nodo:330   */

      /* Empieza nodo:412 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(412)).setAttribute("nombre","primera2" );
      ((Element)v.get(412)).setAttribute("x","32" );
      ((Element)v.get(412)).setAttribute("y","778" );
      ((Element)v.get(412)).setAttribute("ID","botonContenido" );
      ((Element)v.get(412)).setAttribute("img","primera_on" );
      ((Element)v.get(412)).setAttribute("tipo","-2" );
      ((Element)v.get(412)).setAttribute("estado","false" );
      ((Element)v.get(412)).setAttribute("alt","" );
      ((Element)v.get(412)).setAttribute("codigo","" );
      ((Element)v.get(412)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */

      /* Empieza nodo:413 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(413)).setAttribute("nombre","separa2" );
      ((Element)v.get(413)).setAttribute("x","71" );
      ((Element)v.get(413)).setAttribute("y","774" );
      ((Element)v.get(413)).setAttribute("ID","botonContenido" );
      ((Element)v.get(413)).setAttribute("img","separa_base" );
      ((Element)v.get(413)).setAttribute("tipo","0" );
      ((Element)v.get(413)).setAttribute("estado","false" );
      ((Element)v.get(413)).setAttribute("alt","" );
      ((Element)v.get(413)).setAttribute("codigo","" );
      ((Element)v.get(413)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:8   */


   }

}

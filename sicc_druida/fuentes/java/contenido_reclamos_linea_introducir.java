
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_reclamos_linea_introducir  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML1980(doc);
         

      getXML2070(doc);
         

      getXML2160(doc);
         

      getXML2250(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_reclamos_linea_introducir" );
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
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","contenido_reclamos_linea_introducir.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbPeriodoRec" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","276" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtNReclamo" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","396" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:7   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(10)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","accion" );
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
      ((Element)v.get(13)).setAttribute("nombre","casoUso" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","pais" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","idioma" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hCanal" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hAcceso" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hSubAcceso" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oidSolicitud" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hLblCodClienteX" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hLblNDocX" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hLblNombreApellidosX" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 10   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hLblNumeroZonaX" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hLblEstadoClienteX" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hMoneda" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hFechaIngreso" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hVModificar" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hLinea" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hOperacion" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hOidReclamo" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hCierre" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hExisteAnulacion" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hExisteOperacion" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hOidsAEliminar" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","numAtencion" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","oidNumDocumento" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","numDocumento" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","oidPeriodo" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","cargaPopUp" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","oidTerriAdmin" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hMatrizReclamoCabeceras" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hMatrizReclamoDetalles" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hTotalEnvia" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hTotalDevuelve" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hSaldoPagar" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hReclamoBloq" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hid_SeparadorMiles" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hid_NumeroDecimales" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hid_SeparadorDecimales" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","tamanio" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","oidMotivoBloqueo" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","chequeoFisico" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(57)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(10)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("table"));
      ((Element)v.get(58)).setAttribute("width","100%" );
      ((Element)v.get(58)).setAttribute("border","0" );
      ((Element)v.get(58)).setAttribute("cellspacing","0" );
      ((Element)v.get(58)).setAttribute("cellpadding","0" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("width","12" );
      ((Element)v.get(60)).setAttribute("align","center" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","12" );
      ((Element)v.get(61)).setAttribute("height","12" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("width","750" );
      ((Element)v.get(59)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("width","12" );
      ((Element)v.get(59)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","12" );
      ((Element)v.get(65)).setAttribute("height","1" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:59   */

      /* Empieza nodo:66 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("id","ocultarbusqueda" );
      ((Element)v.get(66)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(71)).setAttribute("class","legend" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(72)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(72)).setAttribute("alto","13" );
      ((Element)v.get(72)).setAttribute("filas","1" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(72)).setAttribute("id","legend" );
      ((Element)v.get(72)).setAttribute("cod","0075" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 70   */
      v.add(doc.createElement("table"));
      ((Element)v.get(73)).setAttribute("width","100%" );
      ((Element)v.get(73)).setAttribute("border","0" );
      ((Element)v.get(73)).setAttribute("align","center" );
      ((Element)v.get(73)).setAttribute("cellspacing","0" );
      ((Element)v.get(73)).setAttribute("cellpadding","0" );
      ((Element)v.get(70)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("table"));
      ((Element)v.get(76)).setAttribute("width","627" );
      ((Element)v.get(76)).setAttribute("border","0" );
      ((Element)v.get(76)).setAttribute("align","left" );
      ((Element)v.get(76)).setAttribute("cellspacing","0" );
      ((Element)v.get(76)).setAttribute("cellpadding","0" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("colspan","4" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:80 / Elemento padre: 76   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(76)).appendChild((Element)v.get(80));

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
      ((Element)v.get(83)).setAttribute("colspan","3" );
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(84)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(84)).setAttribute("alto","13" );
      ((Element)v.get(84)).setAttribute("filas","1" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(84)).setAttribute("id","datosTitle" );
      ((Element)v.get(84)).setAttribute("cod","263" );
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
      ((Element)v.get(88)).setAttribute("nombre","lblNumeroDocumento" );
      ((Element)v.get(88)).setAttribute("alto","13" );
      ((Element)v.get(88)).setAttribute("filas","1" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(88)).setAttribute("id","datosTitle" );
      ((Element)v.get(88)).setAttribute("cod","422" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("width","100%" );
      ((Element)v.get(80)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:80   */

      /* Empieza nodo:91 / Elemento padre: 76   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(76)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(95)).setAttribute("nombre","txtCodCliente" );
      ((Element)v.get(95)).setAttribute("id","datosCampos" );
      ((Element)v.get(95)).setAttribute("onshtab","onshtabCliente();" );
      ((Element)v.get(95)).setAttribute("max","15" );
      ((Element)v.get(95)).setAttribute("tipo","" );
      ((Element)v.get(95)).setAttribute("onchange","" );
      ((Element)v.get(95)).setAttribute("req","N" );
      ((Element)v.get(95)).setAttribute("size","15" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(95)).setAttribute("validacion","" );
      ((Element)v.get(95)).setAttribute("onblur","codigoClienteOnBlur();" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(99)).setAttribute("onclick","accionBuscarCliente();" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","25" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(103)).setAttribute("nombre","txtNumeroDocumento" );
      ((Element)v.get(103)).setAttribute("id","datosCampos" );
      ((Element)v.get(103)).setAttribute("max","30" );
      ((Element)v.get(103)).setAttribute("tipo","" );
      ((Element)v.get(103)).setAttribute("onchange","" );
      ((Element)v.get(103)).setAttribute("req","N" );
      ((Element)v.get(103)).setAttribute("size","30" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(103)).setAttribute("validacion","" );
      ((Element)v.get(103)).setAttribute("onblur","validaNumDocumento();" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("width","100%" );
      ((Element)v.get(91)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","8" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:91   */

      /* Empieza nodo:106 / Elemento padre: 76   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(76)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("colspan","4" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:109 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("table"));
      ((Element)v.get(111)).setAttribute("width","627" );
      ((Element)v.get(111)).setAttribute("border","0" );
      ((Element)v.get(111)).setAttribute("align","left" );
      ((Element)v.get(111)).setAttribute("cellspacing","0" );
      ((Element)v.get(111)).setAttribute("cellpadding","0" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(116)).setAttribute("nombre","lblNombre" );
      ((Element)v.get(116)).setAttribute("alto","13" );
      ((Element)v.get(116)).setAttribute("filas","1" );
      ((Element)v.get(116)).setAttribute("valor","" );
      ((Element)v.get(116)).setAttribute("id","datosTitle" );
      ((Element)v.get(116)).setAttribute("cod","264" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","25" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(120)).setAttribute("nombre","lblApellidoPaterno" );
      ((Element)v.get(120)).setAttribute("alto","13" );
      ((Element)v.get(120)).setAttribute("filas","1" );
      ((Element)v.get(120)).setAttribute("valor","" );
      ((Element)v.get(120)).setAttribute("id","datosTitle" );
      ((Element)v.get(120)).setAttribute("cod","2382" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","25" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(124)).setAttribute("nombre","lblApellidoMaterno" );
      ((Element)v.get(124)).setAttribute("alto","13" );
      ((Element)v.get(124)).setAttribute("filas","1" );
      ((Element)v.get(124)).setAttribute("valor","" );
      ((Element)v.get(124)).setAttribute("id","datosTitle" );
      ((Element)v.get(124)).setAttribute("cod","2383" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("width","100%" );
      ((Element)v.get(112)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:112   */

      /* Empieza nodo:127 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(111)).appendChild((Element)v.get(127));

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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(131)).setAttribute("nombre","txtNombre" );
      ((Element)v.get(131)).setAttribute("id","datosCampos" );
      ((Element)v.get(131)).setAttribute("max","25" );
      ((Element)v.get(131)).setAttribute("tipo","" );
      ((Element)v.get(131)).setAttribute("onchange","" );
      ((Element)v.get(131)).setAttribute("req","N" );
      ((Element)v.get(131)).setAttribute("size","25" );
      ((Element)v.get(131)).setAttribute("valor","" );
      ((Element)v.get(131)).setAttribute("validacion","" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","25" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(135)).setAttribute("nombre","txtApellidoPaterno" );
      ((Element)v.get(135)).setAttribute("id","datosCampos" );
      ((Element)v.get(135)).setAttribute("max","25" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(135)).setAttribute("tipo","" );
      ((Element)v.get(135)).setAttribute("onchange","" );
      ((Element)v.get(135)).setAttribute("req","N" );
      ((Element)v.get(135)).setAttribute("size","25" );
      ((Element)v.get(135)).setAttribute("valor","" );
      ((Element)v.get(135)).setAttribute("validacion","" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","25" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(139)).setAttribute("nombre","txtApellidoMaterno" );
      ((Element)v.get(139)).setAttribute("id","datosCampos" );
      ((Element)v.get(139)).setAttribute("max","25" );
      ((Element)v.get(139)).setAttribute("tipo","" );
      ((Element)v.get(139)).setAttribute("onchange","" );
      ((Element)v.get(139)).setAttribute("req","N" );
      ((Element)v.get(139)).setAttribute("size","25" );
      ((Element)v.get(139)).setAttribute("valor","" );
      ((Element)v.get(139)).setAttribute("validacion","" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("width","100%" );
      ((Element)v.get(127)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:127   */

      /* Empieza nodo:142 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(111)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("colspan","4" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:73   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:145 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:66   */

      /* Empieza nodo:147 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("id","ocultarBotonbusqueda" );
      ((Element)v.get(147)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("table"));
      ((Element)v.get(152)).setAttribute("width","100%" );
      ((Element)v.get(152)).setAttribute("border","0" );
      ((Element)v.get(152)).setAttribute("align","center" );
      ((Element)v.get(152)).setAttribute("cellspacing","0" );
      ((Element)v.get(152)).setAttribute("cellpadding","0" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("class","botonera" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(155)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(155)).setAttribute("ID","botonContenido" );
      ((Element)v.get(155)).setAttribute("tipo","html" );
      ((Element)v.get(155)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(155)).setAttribute("estado","false" );
      ((Element)v.get(155)).setAttribute("cod","1" );
      ((Element)v.get(155)).setAttribute("ontab","gestionFocoBuscar();" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:156 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","8" );
      ((Element)v.get(157)).setAttribute("height","12" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:147   */

      /* Empieza nodo:158 / Elemento padre: 58   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).setAttribute("colspan","4" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","8" );
      ((Element)v.get(160)).setAttribute("height","15" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:161 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("id","ocultarAbajo" );
      ((Element)v.get(161)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(165)).setAttribute("id","fieldResBus" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(166)).setAttribute("class","legend" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(167)).setAttribute("nombre","lblResultadosBusqueda" );
      ((Element)v.get(167)).setAttribute("alto","13" );
      ((Element)v.get(167)).setAttribute("filas","1" );
      ((Element)v.get(167)).setAttribute("valor","" );
      ((Element)v.get(167)).setAttribute("id","legend" );
      ((Element)v.get(167)).setAttribute("cod","00135" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 165   */
      v.add(doc.createElement("table"));
      ((Element)v.get(168)).setAttribute("width","100%" );
      ((Element)v.get(168)).setAttribute("border","0" );
      ((Element)v.get(168)).setAttribute("align","center" );
      ((Element)v.get(168)).setAttribute("cellspacing","0" );
      ((Element)v.get(168)).setAttribute("cellpadding","0" );
      ((Element)v.get(165)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("table"));
      ((Element)v.get(171)).setAttribute("width","667" );
      ((Element)v.get(171)).setAttribute("border","0" );
      ((Element)v.get(171)).setAttribute("align","left" );
      ((Element)v.get(171)).setAttribute("cellspacing","0" );
      ((Element)v.get(171)).setAttribute("cellpadding","0" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).setAttribute("colspan","4" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","8" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:175 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","8" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(179)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(179)).setAttribute("alto","13" );
      ((Element)v.get(179)).setAttribute("filas","1" );
      ((Element)v.get(179)).setAttribute("valor","" );
      ((Element)v.get(179)).setAttribute("id","datosTitle" );
      ((Element)v.get(179)).setAttribute("cod","263" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","25" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(183)).setAttribute("nombre","lblNDoc" );
      ((Element)v.get(183)).setAttribute("alto","13" );
      ((Element)v.get(183)).setAttribute("filas","1" );
      ((Element)v.get(183)).setAttribute("valor","" );
      ((Element)v.get(183)).setAttribute("id","datosTitle" );
      ((Element)v.get(183)).setAttribute("cod","422" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","25" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(187)).setAttribute("nombre","lblNReclamo" );
      ((Element)v.get(187)).setAttribute("alto","13" );
      ((Element)v.get(187)).setAttribute("filas","1" );
      ((Element)v.get(187)).setAttribute("valor","" );
      ((Element)v.get(187)).setAttribute("id","datosTitle" );
      ((Element)v.get(187)).setAttribute("cod","396" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","25" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(191)).setAttribute("nombre","lblPeriodoRec" );
      ((Element)v.get(191)).setAttribute("alto","13" );
      ((Element)v.get(191)).setAttribute("filas","1" );
      ((Element)v.get(191)).setAttribute("valor","" );
      ((Element)v.get(191)).setAttribute("id","datosTitle" );
      ((Element)v.get(191)).setAttribute("cod","276" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).setAttribute("width","35%" );
      ((Element)v.get(175)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","8" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:175   */

      /* Empieza nodo:194 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","8" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(198)).setAttribute("nombre","lblCodClienteX" );
      ((Element)v.get(198)).setAttribute("alto","13" );
      ((Element)v.get(198)).setAttribute("filas","1" );
      ((Element)v.get(198)).setAttribute("valor","" );
      ((Element)v.get(198)).setAttribute("id","datosCampos" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","25" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(202)).setAttribute("nombre","lblNDocX" );
      ((Element)v.get(202)).setAttribute("alto","13" );
      ((Element)v.get(202)).setAttribute("filas","1" );
      ((Element)v.get(202)).setAttribute("valor","" );
      ((Element)v.get(202)).setAttribute("id","datosCampos" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","25" );
      ((Element)v.get(204)).setAttribute("height","8" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(206)).setAttribute("nombre","txtNReclamo" );
      ((Element)v.get(206)).setAttribute("id","datosCampos" );
      ((Element)v.get(206)).setAttribute("max","10" );
      ((Element)v.get(206)).setAttribute("tipo","" );
      ((Element)v.get(206)).setAttribute("onchange","" );
      ((Element)v.get(206)).setAttribute("req","S" );
      ((Element)v.get(206)).setAttribute("size","15" );
      ((Element)v.get(206)).setAttribute("valor","" );
      ((Element)v.get(206)).setAttribute("validacion","" );
      ((Element)v.get(206)).setAttribute("onblur","validaNumReclamo()" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","25" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(210)).setAttribute("nombre","cbPeriodoRec" );
      ((Element)v.get(210)).setAttribute("id","datosCampos" );
      ((Element)v.get(210)).setAttribute("size","1" );
      ((Element)v.get(210)).setAttribute("multiple","N" );
      ((Element)v.get(210)).setAttribute("req","S" );
      ((Element)v.get(210)).setAttribute("valorinicial","" );
      ((Element)v.get(210)).setAttribute("textoinicial","" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:212 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).setAttribute("width","35%" );
      ((Element)v.get(194)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).setAttribute("width","8" );
      ((Element)v.get(213)).setAttribute("height","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:194   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:214 / Elemento padre: 168   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(168)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("table"));
      ((Element)v.get(216)).setAttribute("width","627" );
      ((Element)v.get(216)).setAttribute("border","0" );
      ((Element)v.get(216)).setAttribute("align","left" );
      ((Element)v.get(216)).setAttribute("cellspacing","0" );
      ((Element)v.get(216)).setAttribute("cellpadding","0" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).setAttribute("colspan","4" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","8" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:220 / Elemento padre: 216   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(216)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","8" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(224)).setAttribute("nombre","lblNombreApellidos" );
      ((Element)v.get(224)).setAttribute("alto","13" );
      ((Element)v.get(224)).setAttribute("filas","1" );
      ((Element)v.get(224)).setAttribute("valor","" );
      ((Element)v.get(224)).setAttribute("id","datosTitle" );
      ((Element)v.get(224)).setAttribute("cod","943" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","25" );
      ((Element)v.get(226)).setAttribute("height","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 220   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(228)).setAttribute("nombre","lblNumeroZona" );
      ((Element)v.get(228)).setAttribute("alto","13" );
      ((Element)v.get(228)).setAttribute("filas","1" );
      ((Element)v.get(228)).setAttribute("valor","" );
      ((Element)v.get(228)).setAttribute("id","datosTitle" );
      ((Element)v.get(228)).setAttribute("cod","398" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","25" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(232)).setAttribute("nombre","lblEstadoCliente" );
      ((Element)v.get(232)).setAttribute("alto","13" );
      ((Element)v.get(232)).setAttribute("filas","1" );
      ((Element)v.get(232)).setAttribute("valor","" );
      ((Element)v.get(232)).setAttribute("id","datosTitle" );
      ((Element)v.get(232)).setAttribute("cod","294" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(233)).setAttribute("width","100%" );
      ((Element)v.get(220)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","8" );
      ((Element)v.get(234)).setAttribute("height","8" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:220   */

      /* Empieza nodo:235 / Elemento padre: 216   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(216)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","8" );
      ((Element)v.get(237)).setAttribute("height","8" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(239)).setAttribute("nombre","lblNombreApellidosX" );
      ((Element)v.get(239)).setAttribute("alto","13" );
      ((Element)v.get(239)).setAttribute("filas","1" );
      ((Element)v.get(239)).setAttribute("valor","" );
      ((Element)v.get(239)).setAttribute("id","datosCampos" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(241)).setAttribute("src","b.gif" );
      ((Element)v.get(241)).setAttribute("width","25" );
      ((Element)v.get(241)).setAttribute("height","8" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(243)).setAttribute("nombre","lblNumeroZonaX" );
      ((Element)v.get(243)).setAttribute("alto","13" );
      ((Element)v.get(243)).setAttribute("filas","1" );
      ((Element)v.get(243)).setAttribute("valor","" );
      ((Element)v.get(243)).setAttribute("id","datosCampos" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","25" );
      ((Element)v.get(245)).setAttribute("height","8" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(247)).setAttribute("nombre","lblEstadoClienteX" );
      ((Element)v.get(247)).setAttribute("alto","13" );
      ((Element)v.get(247)).setAttribute("filas","1" );
      ((Element)v.get(247)).setAttribute("valor","" );
      ((Element)v.get(247)).setAttribute("id","datosCampos" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).setAttribute("width","100%" );
      ((Element)v.get(235)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(249)).setAttribute("width","8" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:235   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:250 / Elemento padre: 168   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(168)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("table"));
      ((Element)v.get(252)).setAttribute("width","627" );
      ((Element)v.get(252)).setAttribute("border","0" );
      ((Element)v.get(252)).setAttribute("align","left" );
      ((Element)v.get(252)).setAttribute("cellspacing","0" );
      ((Element)v.get(252)).setAttribute("cellpadding","0" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).setAttribute("colspan","4" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","8" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:256 / Elemento padre: 252   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(252)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","8" );
      ((Element)v.get(258)).setAttribute("height","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(260)).setAttribute("nombre","lblMotivoBloqueo" );
      ((Element)v.get(260)).setAttribute("alto","13" );
      ((Element)v.get(260)).setAttribute("filas","1" );
      ((Element)v.get(260)).setAttribute("valor","" );
      ((Element)v.get(260)).setAttribute("id","datosTitle" );
      ((Element)v.get(260)).setAttribute("cod","379" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).setAttribute("width","100%" );
      ((Element)v.get(256)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).setAttribute("width","8" );
      ((Element)v.get(262)).setAttribute("height","8" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:256   */

      /* Empieza nodo:263 / Elemento padre: 252   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(252)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","8" );
      ((Element)v.get(265)).setAttribute("height","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(267)).setAttribute("nombre","cbMotivoBloqueo" );
      ((Element)v.get(267)).setAttribute("id","datosCampos" );
      ((Element)v.get(267)).setAttribute("size","1" );
      ((Element)v.get(267)).setAttribute("multiple","N" );
      ((Element)v.get(267)).setAttribute("req","N" );
      ((Element)v.get(267)).setAttribute("valorinicial","" );
      ((Element)v.get(267)).setAttribute("textoinicial","" );
      ((Element)v.get(267)).setAttribute("onchange","onChangeMotivoBloqueo();" );
      ((Element)v.get(267)).setAttribute("ontab","document.all['Agregar'].focus();" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:269 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).setAttribute("width","100%" );
      ((Element)v.get(263)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(270)).setAttribute("src","b.gif" );
      ((Element)v.get(270)).setAttribute("width","8" );
      ((Element)v.get(270)).setAttribute("height","8" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:263   */

      /* Empieza nodo:271 / Elemento padre: 252   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(252)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).setAttribute("colspan","4" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(273)).setAttribute("src","b.gif" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(273)).setAttribute("width","8" );
      ((Element)v.get(273)).setAttribute("height","682" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:271   */
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:274 / Elemento padre: 168   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(168)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("table"));
      ((Element)v.get(276)).setAttribute("width","627" );
      ((Element)v.get(276)).setAttribute("border","0" );
      ((Element)v.get(276)).setAttribute("align","left" );
      ((Element)v.get(276)).setAttribute("cellspacing","0" );
      ((Element)v.get(276)).setAttribute("cellpadding","0" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(276)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).setAttribute("width","8" );
      ((Element)v.get(279)).setAttribute("height","8" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 277   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(281)).setAttribute("nombre","lblTotalEnvia" );
      ((Element)v.get(281)).setAttribute("alto","13" );
      ((Element)v.get(281)).setAttribute("filas","1" );
      ((Element)v.get(281)).setAttribute("valor","" );
      ((Element)v.get(281)).setAttribute("id","datosTitle" );
      ((Element)v.get(281)).setAttribute("cod","310" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 277   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(283)).setAttribute("width","25" );
      ((Element)v.get(283)).setAttribute("height","8" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 277   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(285)).setAttribute("nombre","lblTotalDevuelve" );
      ((Element)v.get(285)).setAttribute("alto","13" );
      ((Element)v.get(285)).setAttribute("filas","1" );
      ((Element)v.get(285)).setAttribute("valor","" );
      ((Element)v.get(285)).setAttribute("id","datosTitle" );
      ((Element)v.get(285)).setAttribute("cod","311" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 277   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(287)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).setAttribute("width","25" );
      ((Element)v.get(287)).setAttribute("height","8" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 277   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(289)).setAttribute("nombre","lblSaldoAPagar" );
      ((Element)v.get(289)).setAttribute("alto","13" );
      ((Element)v.get(289)).setAttribute("filas","1" );
      ((Element)v.get(289)).setAttribute("valor","" );
      ((Element)v.get(289)).setAttribute("id","datosTitle" );
      ((Element)v.get(289)).setAttribute("cod","312" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 277   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).setAttribute("width","100%" );
      ((Element)v.get(277)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(291)).setAttribute("src","b.gif" );
      ((Element)v.get(291)).setAttribute("width","8" );
      ((Element)v.get(291)).setAttribute("height","8" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:277   */

      /* Empieza nodo:292 / Elemento padre: 276   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(276)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(294)).setAttribute("src","b.gif" );
      ((Element)v.get(294)).setAttribute("width","8" );
      ((Element)v.get(294)).setAttribute("height","8" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(296)).setAttribute("nombre","lblTotalEnviaX" );
      ((Element)v.get(296)).setAttribute("alto","13" );
      ((Element)v.get(296)).setAttribute("filas","1" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(296)).setAttribute("valor","" );
      ((Element)v.get(296)).setAttribute("id","datosCampos" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).setAttribute("width","25" );
      ((Element)v.get(298)).setAttribute("height","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(300)).setAttribute("nombre","lblTotalDevuelveX" );
      ((Element)v.get(300)).setAttribute("alto","13" );
      ((Element)v.get(300)).setAttribute("filas","1" );
      ((Element)v.get(300)).setAttribute("valor","" );
      ((Element)v.get(300)).setAttribute("id","datosCampos" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","25" );
      ((Element)v.get(302)).setAttribute("height","8" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(304)).setAttribute("nombre","lblSaldoAPagarX" );
      ((Element)v.get(304)).setAttribute("alto","13" );
      ((Element)v.get(304)).setAttribute("filas","1" );
      ((Element)v.get(304)).setAttribute("valor","" );
      ((Element)v.get(304)).setAttribute("id","datosCampos" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).setAttribute("width","100%" );
      ((Element)v.get(292)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","8" );
      ((Element)v.get(306)).setAttribute("height","8" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */
      /* Termina nodo:292   */

      /* Empieza nodo:307 / Elemento padre: 276   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(276)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).setAttribute("colspan","4" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","8" );
      ((Element)v.get(309)).setAttribute("height","8" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:274   */
      /* Termina nodo:168   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:310 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */
      /* Termina nodo:161   */

      /* Empieza nodo:312 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(314)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).setAttribute("id","botonesAbajo" );
      ((Element)v.get(312)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(315)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("table"));
      ((Element)v.get(317)).setAttribute("width","100%" );
      ((Element)v.get(317)).setAttribute("border","0" );
      ((Element)v.get(317)).setAttribute("align","center" );
      ((Element)v.get(317)).setAttribute("cellspacing","0" );
      ((Element)v.get(317)).setAttribute("cellpadding","0" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).setAttribute("class","botonera" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(320)).setAttribute("nombre","ConsRec" );
      ((Element)v.get(320)).setAttribute("ID","botonContenido" );
      ((Element)v.get(320)).setAttribute("tipo","html" );
      ((Element)v.get(320)).setAttribute("accion","onclickConsultaReclamo();" );
      ((Element)v.get(320)).setAttribute("estado","false" );
      ((Element)v.get(320)).setAttribute("cod","427" );
      ((Element)v.get(320)).setAttribute("ontab","gestionFocoConsRec();" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(320)).setAttribute("onshtab","document.all['btnDetalle'].focus();" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 319   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(321)).setAttribute("nombre","Bloquear" );
      ((Element)v.get(321)).setAttribute("ID","botonContenido" );
      ((Element)v.get(321)).setAttribute("accion","onClickbloquear();" );
      ((Element)v.get(321)).setAttribute("tipo","html" );
      ((Element)v.get(321)).setAttribute("disabled","S" );
      ((Element)v.get(321)).setAttribute("estado","false" );
      ((Element)v.get(321)).setAttribute("cod","428" );
      ((Element)v.get(321)).setAttribute("ontab","gestionFocoBloquear();" );
      ((Element)v.get(319)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */

      /* Empieza nodo:322 / Elemento padre: 319   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(322)).setAttribute("nombre","GenSol" );
      ((Element)v.get(322)).setAttribute("ID","botonContenido" );
      ((Element)v.get(322)).setAttribute("accion","onClickGenerar();" );
      ((Element)v.get(322)).setAttribute("ontab","focaliza('frmContenido.txtCodCliente');" );
      ((Element)v.get(322)).setAttribute("tipo","html" );
      ((Element)v.get(322)).setAttribute("estado","false" );
      ((Element)v.get(322)).setAttribute("cod","1789" );
      ((Element)v.get(319)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:319   */
      /* Termina nodo:318   */
      /* Termina nodo:317   */
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:323 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(324)).setAttribute("src","b.gif" );
      ((Element)v.get(324)).setAttribute("width","8" );
      ((Element)v.get(324)).setAttribute("height","12" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */
      /* Termina nodo:312   */

      /* Empieza nodo:325 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).setAttribute("width","12" );
      ((Element)v.get(326)).setAttribute("align","center" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(327)).setAttribute("src","b.gif" );
      ((Element)v.get(327)).setAttribute("width","12" );
      ((Element)v.get(327)).setAttribute("height","12" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).setAttribute("width","750" );
      ((Element)v.get(325)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(330)).setAttribute("width","12" );
      ((Element)v.get(325)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","12" );
      ((Element)v.get(331)).setAttribute("height","1" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:325   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:332 / Elemento padre: 10   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(332)).setAttribute("nombre","listado1" );
      ((Element)v.get(332)).setAttribute("ancho","630" );
      ((Element)v.get(332)).setAttribute("alto","317" );
      ((Element)v.get(332)).setAttribute("x","24" );
      ((Element)v.get(332)).setAttribute("y","292" );
      ((Element)v.get(332)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(332)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(10)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(333)).setAttribute("precarga","S" );
      ((Element)v.get(333)).setAttribute("conROver","S" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(334)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(334)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(334)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(334)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */

      /* Empieza nodo:335 / Elemento padre: 333   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(335)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(335)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(335)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(335)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(333)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */

      /* Empieza nodo:336 / Elemento padre: 333   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(336)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(336)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(333)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:333   */

      /* Empieza nodo:337 / Elemento padre: 332   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(332)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(338)).setAttribute("borde","1" );
      ((Element)v.get(338)).setAttribute("horizDatos","1" );
      ((Element)v.get(338)).setAttribute("horizCabecera","1" );
      ((Element)v.get(338)).setAttribute("vertical","1" );
      ((Element)v.get(338)).setAttribute("horizTitulo","1" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(338)).setAttribute("horizBase","1" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */

      /* Empieza nodo:339 / Elemento padre: 337   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(339)).setAttribute("borde","#999999" );
      ((Element)v.get(339)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(339)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(339)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(339)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(339)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(339)).setAttribute("horizBase","#999999" );
      ((Element)v.get(337)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:337   */

      /* Empieza nodo:340 / Elemento padre: 332   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(340)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(340)).setAttribute("alto","22" );
      ((Element)v.get(340)).setAttribute("imgFondo","" );
      ((Element)v.get(340)).setAttribute("cod","00291" );
      ((Element)v.get(340)).setAttribute("ID","datosTitle" );
      ((Element)v.get(332)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */

      /* Empieza nodo:341 / Elemento padre: 332   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(341)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(341)).setAttribute("alto","22" );
      ((Element)v.get(341)).setAttribute("imgFondo","" );
      ((Element)v.get(332)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */

      /* Empieza nodo:342 / Elemento padre: 332   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(342)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(342)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(342)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(342)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(342)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(342)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(332)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(343)).setAttribute("ancho","105" );
      ((Element)v.get(343)).setAttribute("minimizable","S" );
      ((Element)v.get(343)).setAttribute("minimizada","N" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */

      /* Empieza nodo:344 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(344)).setAttribute("ancho","125" );
      ((Element)v.get(344)).setAttribute("minimizable","S" );
      ((Element)v.get(344)).setAttribute("minimizada","N" );
      ((Element)v.get(342)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */

      /* Empieza nodo:345 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(345)).setAttribute("ancho","135" );
      ((Element)v.get(345)).setAttribute("minimizable","S" );
      ((Element)v.get(345)).setAttribute("minimizada","N" );
      ((Element)v.get(342)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */

      /* Empieza nodo:346 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(346)).setAttribute("ancho","135" );
      ((Element)v.get(346)).setAttribute("minimizable","S" );
      ((Element)v.get(346)).setAttribute("minimizada","N" );
      ((Element)v.get(342)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */

      /* Empieza nodo:347 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(347)).setAttribute("ancho","155" );
      ((Element)v.get(347)).setAttribute("minimizable","S" );
      ((Element)v.get(347)).setAttribute("minimizada","N" );
      ((Element)v.get(342)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */

      /* Empieza nodo:348 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(348)).setAttribute("ancho","105" );
      ((Element)v.get(348)).setAttribute("minimizable","S" );
      ((Element)v.get(348)).setAttribute("minimizada","N" );
      ((Element)v.get(342)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */

      /* Empieza nodo:349 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(349)).setAttribute("ancho","30" );
      ((Element)v.get(349)).setAttribute("minimizable","S" );
      ((Element)v.get(349)).setAttribute("minimizada","N" );
      ((Element)v.get(349)).setAttribute("oculta","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */

      /* Empieza nodo:350 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(350)).setAttribute("ancho","30" );
      ((Element)v.get(350)).setAttribute("minimizable","S" );
      ((Element)v.get(350)).setAttribute("minimizada","N" );
      ((Element)v.get(350)).setAttribute("oculta","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */

      /* Empieza nodo:351 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(351)).setAttribute("ancho","30" );
      ((Element)v.get(351)).setAttribute("minimizable","S" );
      ((Element)v.get(351)).setAttribute("minimizada","N" );
      ((Element)v.get(351)).setAttribute("oculta","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */

      /* Empieza nodo:352 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(352)).setAttribute("ancho","30" );
      ((Element)v.get(352)).setAttribute("minimizable","S" );
      ((Element)v.get(352)).setAttribute("minimizada","N" );
      ((Element)v.get(352)).setAttribute("oculta","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */

      /* Empieza nodo:353 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(353)).setAttribute("ancho","30" );
      ((Element)v.get(353)).setAttribute("minimizable","S" );
      ((Element)v.get(353)).setAttribute("minimizada","N" );
      ((Element)v.get(353)).setAttribute("oculta","S" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(342)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */

      /* Empieza nodo:354 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(354)).setAttribute("ancho","30" );
      ((Element)v.get(354)).setAttribute("minimizable","S" );
      ((Element)v.get(354)).setAttribute("minimizada","N" );
      ((Element)v.get(354)).setAttribute("oculta","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */

      /* Empieza nodo:355 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(355)).setAttribute("ancho","30" );
      ((Element)v.get(355)).setAttribute("minimizable","S" );
      ((Element)v.get(355)).setAttribute("minimizada","N" );
      ((Element)v.get(355)).setAttribute("oculta","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */

      /* Empieza nodo:356 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(356)).setAttribute("ancho","30" );
      ((Element)v.get(356)).setAttribute("minimizable","S" );
      ((Element)v.get(356)).setAttribute("minimizada","N" );
      ((Element)v.get(356)).setAttribute("oculta","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */

      /* Empieza nodo:357 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(357)).setAttribute("ancho","30" );
      ((Element)v.get(357)).setAttribute("minimizable","S" );
      ((Element)v.get(357)).setAttribute("minimizada","N" );
      ((Element)v.get(357)).setAttribute("oculta","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */

      /* Empieza nodo:358 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(358)).setAttribute("ancho","30" );
      ((Element)v.get(358)).setAttribute("minimizable","S" );
      ((Element)v.get(358)).setAttribute("minimizada","N" );
      ((Element)v.get(358)).setAttribute("oculta","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(359)).setAttribute("ancho","30" );
      ((Element)v.get(359)).setAttribute("minimizable","S" );
      ((Element)v.get(359)).setAttribute("minimizada","N" );
      ((Element)v.get(359)).setAttribute("oculta","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(360)).setAttribute("ancho","30" );
      ((Element)v.get(360)).setAttribute("minimizable","S" );
      ((Element)v.get(360)).setAttribute("minimizada","N" );
      ((Element)v.get(360)).setAttribute("oculta","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */

      /* Empieza nodo:361 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(361)).setAttribute("ancho","30" );
      ((Element)v.get(361)).setAttribute("minimizable","S" );
      ((Element)v.get(361)).setAttribute("minimizada","N" );
      ((Element)v.get(361)).setAttribute("oculta","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(362)).setAttribute("ancho","30" );
      ((Element)v.get(362)).setAttribute("minimizable","S" );
      ((Element)v.get(362)).setAttribute("minimizada","N" );
      ((Element)v.get(362)).setAttribute("oculta","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:342   */

      /* Empieza nodo:363 / Elemento padre: 332   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(363)).setAttribute("alto","20" );
      ((Element)v.get(363)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(363)).setAttribute("imgFondo","" );
      ((Element)v.get(363)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(332)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(364)).setAttribute("colFondo","" );
      ((Element)v.get(364)).setAttribute("ID","EstCab" );
      ((Element)v.get(364)).setAttribute("cod","299" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */

      /* Empieza nodo:365 / Elemento padre: 363   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(365)).setAttribute("colFondo","" );
      ((Element)v.get(365)).setAttribute("ID","EstCab" );
      ((Element)v.get(365)).setAttribute("cod","301" );
      ((Element)v.get(363)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */

      /* Empieza nodo:366 / Elemento padre: 363   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(366)).setAttribute("colFondo","" );
      ((Element)v.get(366)).setAttribute("ID","EstCab" );
      ((Element)v.get(366)).setAttribute("cod","374" );
      ((Element)v.get(363)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */

      /* Empieza nodo:367 / Elemento padre: 363   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(367)).setAttribute("colFondo","" );
      ((Element)v.get(367)).setAttribute("ID","EstCab" );
      ((Element)v.get(367)).setAttribute("cod","331" );
      ((Element)v.get(363)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */

      /* Empieza nodo:368 / Elemento padre: 363   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(368)).setAttribute("colFondo","" );
      ((Element)v.get(368)).setAttribute("ID","EstCab" );
      ((Element)v.get(368)).setAttribute("cod","425" );
      ((Element)v.get(363)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */

      /* Empieza nodo:369 / Elemento padre: 363   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(369)).setAttribute("colFondo","" );
      ((Element)v.get(369)).setAttribute("ID","EstCab" );
      ((Element)v.get(369)).setAttribute("cod","1393" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(363)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */

      /* Empieza nodo:370 / Elemento padre: 363   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(370)).setAttribute("colFondo","" );
      ((Element)v.get(370)).setAttribute("ID","EstCab" );
      ((Element)v.get(363)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */

      /* Empieza nodo:371 / Elemento padre: 363   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(371)).setAttribute("colFondo","" );
      ((Element)v.get(371)).setAttribute("ID","EstCab" );
      ((Element)v.get(363)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */

      /* Empieza nodo:372 / Elemento padre: 363   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(372)).setAttribute("colFondo","" );
      ((Element)v.get(372)).setAttribute("ID","EstCab" );
      ((Element)v.get(363)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */

      /* Empieza nodo:373 / Elemento padre: 363   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(373)).setAttribute("colFondo","" );
      ((Element)v.get(373)).setAttribute("ID","EstCab" );
      ((Element)v.get(363)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */

      /* Empieza nodo:374 / Elemento padre: 363   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(374)).setAttribute("colFondo","" );
      ((Element)v.get(374)).setAttribute("ID","EstCab" );
      ((Element)v.get(363)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */

      /* Empieza nodo:375 / Elemento padre: 363   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(375)).setAttribute("colFondo","" );
      ((Element)v.get(375)).setAttribute("ID","EstCab" );
      ((Element)v.get(363)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */

      /* Empieza nodo:376 / Elemento padre: 363   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(376)).setAttribute("colFondo","" );
      ((Element)v.get(376)).setAttribute("ID","EstCab" );
      ((Element)v.get(363)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */

      /* Empieza nodo:377 / Elemento padre: 363   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(377)).setAttribute("colFondo","" );
      ((Element)v.get(377)).setAttribute("ID","EstCab" );
      ((Element)v.get(363)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */

      /* Empieza nodo:378 / Elemento padre: 363   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(378)).setAttribute("colFondo","" );
      ((Element)v.get(378)).setAttribute("ID","EstCab" );
      ((Element)v.get(363)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */

      /* Empieza nodo:379 / Elemento padre: 363   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(379)).setAttribute("colFondo","" );
      ((Element)v.get(379)).setAttribute("ID","EstCab" );
      ((Element)v.get(363)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */

      /* Empieza nodo:380 / Elemento padre: 363   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(380)).setAttribute("colFondo","" );
      ((Element)v.get(380)).setAttribute("ID","EstCab" );
      ((Element)v.get(363)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */

      /* Empieza nodo:381 / Elemento padre: 363   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(381)).setAttribute("colFondo","" );
      ((Element)v.get(381)).setAttribute("ID","EstCab" );
      ((Element)v.get(363)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */

      /* Empieza nodo:382 / Elemento padre: 363   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(382)).setAttribute("colFondo","" );
      ((Element)v.get(382)).setAttribute("ID","EstCab" );
      ((Element)v.get(363)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */

      /* Empieza nodo:383 / Elemento padre: 363   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(383)).setAttribute("colFondo","" );
      ((Element)v.get(383)).setAttribute("ID","EstCab" );
      ((Element)v.get(383)).setAttribute("cod","1560" );
      ((Element)v.get(363)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:363   */

      /* Empieza nodo:384 / Elemento padre: 332   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(384)).setAttribute("alto","22" );
      ((Element)v.get(384)).setAttribute("accion","" );
      ((Element)v.get(384)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(384)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(384)).setAttribute("maxSel","-1" );
      ((Element)v.get(384)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(384)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(384)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(384)).setAttribute("onLoad","" );
      ((Element)v.get(384)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(332)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(385)).setAttribute("tipo","texto" );
      ((Element)v.get(385)).setAttribute("ID","EstDat" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */

      /* Empieza nodo:386 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(386)).setAttribute("tipo","texto" );
      ((Element)v.get(386)).setAttribute("ID","EstDat2" );
      ((Element)v.get(384)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */

      /* Empieza nodo:387 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(387)).setAttribute("tipo","texto" );
      ((Element)v.get(387)).setAttribute("ID","EstDat" );
      ((Element)v.get(384)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */

      /* Empieza nodo:388 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(388)).setAttribute("tipo","texto" );
      ((Element)v.get(388)).setAttribute("ID","EstDat2" );
      ((Element)v.get(384)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */

      /* Empieza nodo:389 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(389)).setAttribute("tipo","texto" );
      ((Element)v.get(389)).setAttribute("ID","EstDat" );
      ((Element)v.get(384)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */

      /* Empieza nodo:390 / Elemento padre: 384   */
   }

   private void getXML1620(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(390)).setAttribute("tipo","texto" );
      ((Element)v.get(390)).setAttribute("ID","EstDat2" );
      ((Element)v.get(384)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */

      /* Empieza nodo:391 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(391)).setAttribute("tipo","texto" );
      ((Element)v.get(391)).setAttribute("ID","EstDat" );
      ((Element)v.get(384)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */

      /* Empieza nodo:392 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(392)).setAttribute("tipo","texto" );
      ((Element)v.get(392)).setAttribute("ID","EstDat2" );
      ((Element)v.get(384)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */

      /* Empieza nodo:393 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(393)).setAttribute("tipo","texto" );
      ((Element)v.get(393)).setAttribute("ID","EstDat" );
      ((Element)v.get(384)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */

      /* Empieza nodo:394 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(394)).setAttribute("tipo","texto" );
      ((Element)v.get(394)).setAttribute("ID","EstDat2" );
      ((Element)v.get(384)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */

      /* Empieza nodo:395 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(395)).setAttribute("tipo","texto" );
      ((Element)v.get(395)).setAttribute("ID","EstDat" );
      ((Element)v.get(384)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */

      /* Empieza nodo:396 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(396)).setAttribute("tipo","texto" );
      ((Element)v.get(396)).setAttribute("ID","EstDat2" );
      ((Element)v.get(384)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */

      /* Empieza nodo:397 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(397)).setAttribute("tipo","texto" );
      ((Element)v.get(397)).setAttribute("ID","EstDat" );
      ((Element)v.get(384)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */

      /* Empieza nodo:398 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(398)).setAttribute("tipo","texto" );
      ((Element)v.get(398)).setAttribute("ID","EstDat2" );
      ((Element)v.get(384)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */

      /* Empieza nodo:399 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(399)).setAttribute("tipo","texto" );
      ((Element)v.get(399)).setAttribute("ID","EstDat" );
      ((Element)v.get(384)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */

      /* Empieza nodo:400 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(400)).setAttribute("tipo","texto" );
      ((Element)v.get(400)).setAttribute("ID","EstDat2" );
      ((Element)v.get(384)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */

      /* Empieza nodo:401 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(401)).setAttribute("tipo","texto" );
      ((Element)v.get(401)).setAttribute("ID","EstDat" );
      ((Element)v.get(384)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */

      /* Empieza nodo:402 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(402)).setAttribute("tipo","texto" );
      ((Element)v.get(402)).setAttribute("ID","EstDat2" );
      ((Element)v.get(384)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */

      /* Empieza nodo:403 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(403)).setAttribute("tipo","texto" );
      ((Element)v.get(403)).setAttribute("ID","EstDat" );
      ((Element)v.get(384)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */

      /* Empieza nodo:404 / Elemento padre: 384   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(404)).setAttribute("tipo","texto" );
      ((Element)v.get(404)).setAttribute("ID","EstDat" );
      ((Element)v.get(384)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:384   */

      /* Empieza nodo:405 / Elemento padre: 332   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(332)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */

      /* Empieza nodo:406 / Elemento padre: 332   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(406)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(406)).setAttribute("ancho","630" );
      ((Element)v.get(406)).setAttribute("sep","$" );
      ((Element)v.get(406)).setAttribute("x","24" );
      ((Element)v.get(406)).setAttribute("class","botonera" );
      ((Element)v.get(406)).setAttribute("y","586" );
      ((Element)v.get(406)).setAttribute("control","|" );
      ((Element)v.get(406)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(406)).setAttribute("rowset","" );
      ((Element)v.get(406)).setAttribute("cargainicial","N" );
      ((Element)v.get(332)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(407)).setAttribute("nombre","ret1" );
      ((Element)v.get(407)).setAttribute("x","49" );
      ((Element)v.get(407)).setAttribute("y","590" );
      ((Element)v.get(407)).setAttribute("ID","botonContenido" );
      ((Element)v.get(407)).setAttribute("img","retroceder_on" );
      ((Element)v.get(407)).setAttribute("tipo","0" );
      ((Element)v.get(407)).setAttribute("estado","false" );
      ((Element)v.get(407)).setAttribute("alt","" );
      ((Element)v.get(407)).setAttribute("codigo","" );
      ((Element)v.get(407)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */

      /* Empieza nodo:408 / Elemento padre: 406   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(408)).setAttribute("nombre","ava1" );
      ((Element)v.get(408)).setAttribute("x","64" );
      ((Element)v.get(408)).setAttribute("y","590" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(408)).setAttribute("ID","botonContenido" );
      ((Element)v.get(408)).setAttribute("img","avanzar_on" );
      ((Element)v.get(408)).setAttribute("tipo","0" );
      ((Element)v.get(408)).setAttribute("estado","false" );
      ((Element)v.get(408)).setAttribute("alt","" );
      ((Element)v.get(408)).setAttribute("codigo","" );
      ((Element)v.get(408)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(406)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:406   */
      /* Termina nodo:332   */

      /* Empieza nodo:409 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(409)).setAttribute("nombre","primera1" );
      ((Element)v.get(409)).setAttribute("x","32" );
      ((Element)v.get(409)).setAttribute("y","590" );
      ((Element)v.get(409)).setAttribute("ID","botonContenido" );
      ((Element)v.get(409)).setAttribute("img","primera_on" );
      ((Element)v.get(409)).setAttribute("tipo","0" );
      ((Element)v.get(409)).setAttribute("estado","false" );
      ((Element)v.get(409)).setAttribute("alt","" );
      ((Element)v.get(409)).setAttribute("codigo","" );
      ((Element)v.get(409)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(10)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */

      /* Empieza nodo:410 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(410)).setAttribute("nombre","separa1" );
      ((Element)v.get(410)).setAttribute("x","71" );
      ((Element)v.get(410)).setAttribute("y","586" );
      ((Element)v.get(410)).setAttribute("ID","botonContenido" );
      ((Element)v.get(410)).setAttribute("img","separa_base" );
      ((Element)v.get(410)).setAttribute("tipo","0" );
      ((Element)v.get(410)).setAttribute("estado","false" );
      ((Element)v.get(410)).setAttribute("alt","" );
      ((Element)v.get(410)).setAttribute("codigo","" );
      ((Element)v.get(410)).setAttribute("accion","" );
      ((Element)v.get(10)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */

      /* Empieza nodo:411 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(411)).setAttribute("nombre","Agregar" );
      ((Element)v.get(411)).setAttribute("x","92" );
      ((Element)v.get(411)).setAttribute("y","587" );
      ((Element)v.get(411)).setAttribute("ID","botonContenido" );
      ((Element)v.get(411)).setAttribute("tipo","html" );
      ((Element)v.get(411)).setAttribute("estado","false" );
      ((Element)v.get(411)).setAttribute("cod","426" );
      ((Element)v.get(411)).setAttribute("accion","onClickAgregar();" );
      ((Element)v.get(411)).setAttribute("onshtab","focaliza('frmContenido.cbMotivoBloqueo');" );
      ((Element)v.get(10)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */

      /* Empieza nodo:412 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(412)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(412)).setAttribute("x","160" );
      ((Element)v.get(412)).setAttribute("y","587" );
      ((Element)v.get(412)).setAttribute("ID","botonContenido" );
      ((Element)v.get(412)).setAttribute("tipo","html" );
      ((Element)v.get(412)).setAttribute("accion","onClickDetalle();" );
      ((Element)v.get(412)).setAttribute("ontab","document.all['ConsRec'].focus();" );
      ((Element)v.get(412)).setAttribute("estado","false" );
      ((Element)v.get(412)).setAttribute("cod","3" );
      ((Element)v.get(412)).setAttribute("onshtab","document.all['Agregar'].focus();" );
      ((Element)v.get(10)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */

      /* Empieza nodo:413 / Elemento padre: 10   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(413)).setAttribute("nombre","listado2" );
      ((Element)v.get(413)).setAttribute("ancho","630" );
      ((Element)v.get(413)).setAttribute("alto","317" );
      ((Element)v.get(413)).setAttribute("x","24" );
      ((Element)v.get(413)).setAttribute("y","633" );
      ((Element)v.get(413)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(413)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(10)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(414)).setAttribute("precarga","S" );
      ((Element)v.get(414)).setAttribute("conROver","S" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(415)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(415)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(415)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(415)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */

      /* Empieza nodo:416 / Elemento padre: 414   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(416)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(416)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(416)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(416)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(414)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */

      /* Empieza nodo:417 / Elemento padre: 414   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(417)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(417)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(414)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:414   */

      /* Empieza nodo:418 / Elemento padre: 413   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(413)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(419)).setAttribute("borde","1" );
      ((Element)v.get(419)).setAttribute("horizDatos","1" );
      ((Element)v.get(419)).setAttribute("horizCabecera","1" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(419)).setAttribute("vertical","1" );
      ((Element)v.get(419)).setAttribute("horizTitulo","1" );
      ((Element)v.get(419)).setAttribute("horizBase","1" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */

      /* Empieza nodo:420 / Elemento padre: 418   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(420)).setAttribute("borde","#999999" );
      ((Element)v.get(420)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(420)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(420)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(420)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(420)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(420)).setAttribute("horizBase","#999999" );
      ((Element)v.get(418)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:418   */

      /* Empieza nodo:421 / Elemento padre: 413   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(421)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(421)).setAttribute("alto","22" );
      ((Element)v.get(421)).setAttribute("imgFondo","" );
      ((Element)v.get(421)).setAttribute("cod","00299" );
      ((Element)v.get(421)).setAttribute("ID","datosTitle" );
      ((Element)v.get(413)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */

      /* Empieza nodo:422 / Elemento padre: 413   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(422)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(422)).setAttribute("alto","22" );
      ((Element)v.get(422)).setAttribute("imgFondo","" );
      ((Element)v.get(413)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */

      /* Empieza nodo:423 / Elemento padre: 413   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(423)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(423)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(423)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(423)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(423)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(423)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(413)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(424)).setAttribute("ancho","100" );
      ((Element)v.get(424)).setAttribute("minimizable","S" );
      ((Element)v.get(424)).setAttribute("minimizada","N" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */

      /* Empieza nodo:425 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(425)).setAttribute("ancho","100" );
      ((Element)v.get(425)).setAttribute("minimizable","S" );
      ((Element)v.get(425)).setAttribute("minimizada","N" );
      ((Element)v.get(423)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */

      /* Empieza nodo:426 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(426)).setAttribute("ancho","100" );
      ((Element)v.get(426)).setAttribute("minimizable","S" );
      ((Element)v.get(426)).setAttribute("minimizada","N" );
      ((Element)v.get(423)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */

      /* Empieza nodo:427 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(427)).setAttribute("ancho","100" );
      ((Element)v.get(427)).setAttribute("minimizable","S" );
      ((Element)v.get(427)).setAttribute("minimizada","N" );
      ((Element)v.get(423)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */

      /* Empieza nodo:428 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(428)).setAttribute("ancho","135" );
      ((Element)v.get(428)).setAttribute("minimizable","S" );
      ((Element)v.get(428)).setAttribute("minimizada","N" );
      ((Element)v.get(423)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */

      /* Empieza nodo:429 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(429)).setAttribute("ancho","100" );
      ((Element)v.get(429)).setAttribute("minimizable","S" );
      ((Element)v.get(429)).setAttribute("minimizada","N" );
      ((Element)v.get(423)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */

      /* Empieza nodo:430 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(430)).setAttribute("ancho","100" );
      ((Element)v.get(430)).setAttribute("minimizable","S" );
      ((Element)v.get(430)).setAttribute("minimizada","N" );
      ((Element)v.get(423)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */

      /* Empieza nodo:431 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(431)).setAttribute("ancho","100" );
      ((Element)v.get(431)).setAttribute("minimizable","S" );
      ((Element)v.get(431)).setAttribute("minimizada","N" );
      ((Element)v.get(423)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */

      /* Empieza nodo:432 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(432)).setAttribute("ancho","130" );
      ((Element)v.get(432)).setAttribute("minimizable","S" );
      ((Element)v.get(432)).setAttribute("minimizada","N" );
      ((Element)v.get(423)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */

      /* Empieza nodo:433 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(433)).setAttribute("ancho","100" );
      ((Element)v.get(433)).setAttribute("minimizable","S" );
      ((Element)v.get(433)).setAttribute("minimizada","N" );
      ((Element)v.get(423)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */

      /* Empieza nodo:434 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(434)).setAttribute("ancho","100" );
      ((Element)v.get(434)).setAttribute("minimizable","S" );
      ((Element)v.get(434)).setAttribute("minimizada","N" );
      ((Element)v.get(423)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */

      /* Empieza nodo:435 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(435)).setAttribute("ancho","30" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(435)).setAttribute("minimizable","S" );
      ((Element)v.get(435)).setAttribute("minimizada","N" );
      ((Element)v.get(435)).setAttribute("oculta","S" );
      ((Element)v.get(423)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */

      /* Empieza nodo:436 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(436)).setAttribute("ancho","30" );
      ((Element)v.get(436)).setAttribute("minimizable","S" );
      ((Element)v.get(436)).setAttribute("minimizada","N" );
      ((Element)v.get(436)).setAttribute("oculta","S" );
      ((Element)v.get(423)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */

      /* Empieza nodo:437 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(437)).setAttribute("ancho","30" );
      ((Element)v.get(437)).setAttribute("minimizable","S" );
      ((Element)v.get(437)).setAttribute("minimizada","N" );
      ((Element)v.get(437)).setAttribute("oculta","S" );
      ((Element)v.get(423)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */

      /* Empieza nodo:438 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(438)).setAttribute("ancho","30" );
      ((Element)v.get(438)).setAttribute("minimizable","S" );
      ((Element)v.get(438)).setAttribute("minimizada","N" );
      ((Element)v.get(438)).setAttribute("oculta","S" );
      ((Element)v.get(423)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */

      /* Empieza nodo:439 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(439)).setAttribute("ancho","30" );
      ((Element)v.get(439)).setAttribute("minimizable","S" );
      ((Element)v.get(439)).setAttribute("minimizada","N" );
      ((Element)v.get(439)).setAttribute("oculta","S" );
      ((Element)v.get(423)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */

      /* Empieza nodo:440 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(440)).setAttribute("ancho","30" );
      ((Element)v.get(440)).setAttribute("minimizable","S" );
      ((Element)v.get(440)).setAttribute("minimizada","N" );
      ((Element)v.get(440)).setAttribute("oculta","S" );
      ((Element)v.get(423)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */

      /* Empieza nodo:441 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(441)).setAttribute("ancho","30" );
      ((Element)v.get(441)).setAttribute("minimizable","S" );
      ((Element)v.get(441)).setAttribute("minimizada","N" );
      ((Element)v.get(441)).setAttribute("oculta","S" );
      ((Element)v.get(423)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */

      /* Empieza nodo:442 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(442)).setAttribute("ancho","30" );
      ((Element)v.get(442)).setAttribute("minimizable","S" );
      ((Element)v.get(442)).setAttribute("minimizada","N" );
      ((Element)v.get(442)).setAttribute("oculta","S" );
      ((Element)v.get(423)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */

      /* Empieza nodo:443 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(443)).setAttribute("ancho","30" );
      ((Element)v.get(443)).setAttribute("minimizable","S" );
      ((Element)v.get(443)).setAttribute("minimizada","N" );
      ((Element)v.get(443)).setAttribute("oculta","S" );
      ((Element)v.get(423)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */

      /* Empieza nodo:444 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(444)).setAttribute("ancho","30" );
      ((Element)v.get(444)).setAttribute("minimizable","S" );
      ((Element)v.get(444)).setAttribute("minimizada","N" );
      ((Element)v.get(444)).setAttribute("oculta","S" );
      ((Element)v.get(423)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */

      /* Empieza nodo:445 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(445)).setAttribute("ancho","30" );
      ((Element)v.get(445)).setAttribute("minimizable","S" );
      ((Element)v.get(445)).setAttribute("minimizada","N" );
      ((Element)v.get(445)).setAttribute("oculta","S" );
      ((Element)v.get(423)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */

      /* Empieza nodo:446 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(446)).setAttribute("ancho","30" );
      ((Element)v.get(446)).setAttribute("minimizable","S" );
      ((Element)v.get(446)).setAttribute("minimizada","N" );
      ((Element)v.get(446)).setAttribute("oculta","S" );
      ((Element)v.get(423)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:423   */

      /* Empieza nodo:447 / Elemento padre: 413   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(447)).setAttribute("alto","20" );
      ((Element)v.get(447)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(447)).setAttribute("imgFondo","" );
      ((Element)v.get(447)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(413)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(448)).setAttribute("colFondo","" );
      ((Element)v.get(448)).setAttribute("ID","EstCab" );
      ((Element)v.get(448)).setAttribute("cod","304" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */

      /* Empieza nodo:449 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(449)).setAttribute("colFondo","" );
      ((Element)v.get(449)).setAttribute("ID","EstCab" );
      ((Element)v.get(449)).setAttribute("cod","336" );
      ((Element)v.get(447)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */

      /* Empieza nodo:450 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(450)).setAttribute("colFondo","" );
      ((Element)v.get(450)).setAttribute("ID","EstCab" );
      ((Element)v.get(450)).setAttribute("cod","337" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(447)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */

      /* Empieza nodo:451 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(451)).setAttribute("colFondo","" );
      ((Element)v.get(451)).setAttribute("ID","EstCab" );
      ((Element)v.get(451)).setAttribute("cod","9" );
      ((Element)v.get(447)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */

      /* Empieza nodo:452 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(452)).setAttribute("colFondo","" );
      ((Element)v.get(452)).setAttribute("ID","EstCab" );
      ((Element)v.get(452)).setAttribute("cod","339" );
      ((Element)v.get(447)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */

      /* Empieza nodo:453 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(453)).setAttribute("colFondo","" );
      ((Element)v.get(453)).setAttribute("ID","EstCab" );
      ((Element)v.get(453)).setAttribute("cod","377" );
      ((Element)v.get(447)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */

      /* Empieza nodo:454 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(454)).setAttribute("colFondo","" );
      ((Element)v.get(454)).setAttribute("ID","EstCab" );
      ((Element)v.get(454)).setAttribute("cod","974" );
      ((Element)v.get(447)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */

      /* Empieza nodo:455 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(455)).setAttribute("colFondo","" );
      ((Element)v.get(455)).setAttribute("ID","EstCab" );
      ((Element)v.get(455)).setAttribute("cod","341" );
      ((Element)v.get(447)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */

      /* Empieza nodo:456 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(456)).setAttribute("colFondo","" );
      ((Element)v.get(456)).setAttribute("ID","EstCab" );
      ((Element)v.get(456)).setAttribute("cod","309" );
      ((Element)v.get(447)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */

      /* Empieza nodo:457 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(457)).setAttribute("colFondo","" );
      ((Element)v.get(457)).setAttribute("ID","EstCab" );
      ((Element)v.get(457)).setAttribute("cod","307" );
      ((Element)v.get(447)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */

      /* Empieza nodo:458 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(458)).setAttribute("colFondo","" );
      ((Element)v.get(458)).setAttribute("ID","EstCab" );
      ((Element)v.get(458)).setAttribute("cod","308" );
      ((Element)v.get(447)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */

      /* Empieza nodo:459 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(459)).setAttribute("colFondo","" );
      ((Element)v.get(459)).setAttribute("ID","EstCab" );
      ((Element)v.get(447)).appendChild((Element)v.get(459));

      /* Elemento padre:459 / Elemento actual: 460   */
      v.add(doc.createTextNode("motivoDevolucion"));
      ((Element)v.get(459)).appendChild((Text)v.get(460));

      /* Termina nodo Texto:460   */
      /* Termina nodo:459   */

      /* Empieza nodo:461 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(461)).setAttribute("colFondo","" );
      ((Element)v.get(461)).setAttribute("ID","EstCab" );
      ((Element)v.get(447)).appendChild((Element)v.get(461));

      /* Elemento padre:461 / Elemento actual: 462   */
      v.add(doc.createTextNode("numLinea"));
      ((Element)v.get(461)).appendChild((Text)v.get(462));

      /* Termina nodo Texto:462   */
      /* Termina nodo:461   */

      /* Empieza nodo:463 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(463)).setAttribute("colFondo","" );
      ((Element)v.get(463)).setAttribute("ID","EstCab" );
      ((Element)v.get(447)).appendChild((Element)v.get(463));

      /* Elemento padre:463 / Elemento actual: 464   */
      v.add(doc.createTextNode("oidTipoMovi"));
      ((Element)v.get(463)).appendChild((Text)v.get(464));

      /* Termina nodo Texto:464   */
      /* Termina nodo:463   */

      /* Empieza nodo:465 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(465)).setAttribute("colFondo","" );
      ((Element)v.get(465)).setAttribute("ID","EstCab" );
      ((Element)v.get(447)).appendChild((Element)v.get(465));

      /* Elemento padre:465 / Elemento actual: 466   */
      v.add(doc.createTextNode("oidCodVenta"));
      ((Element)v.get(465)).appendChild((Text)v.get(466));

      /* Termina nodo Texto:466   */
      /* Termina nodo:465   */

      /* Empieza nodo:467 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(467)).setAttribute("colFondo","" );
      ((Element)v.get(467)).setAttribute("ID","EstCab" );
      ((Element)v.get(447)).appendChild((Element)v.get(467));

      /* Elemento padre:467 / Elemento actual: 468   */
      v.add(doc.createTextNode("oidCodProducto"));
      ((Element)v.get(467)).appendChild((Text)v.get(468));

      /* Termina nodo Texto:468   */
      /* Termina nodo:467   */

      /* Empieza nodo:469 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(469)).setAttribute("colFondo","" );
      ((Element)v.get(469)).setAttribute("ID","EstCab" );
      ((Element)v.get(447)).appendChild((Element)v.get(469));

      /* Elemento padre:469 / Elemento actual: 470   */
      v.add(doc.createTextNode("montoPerdida"));
      ((Element)v.get(469)).appendChild((Text)v.get(470));

      /* Termina nodo Texto:470   */
      /* Termina nodo:469   */

      /* Empieza nodo:471 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(471)).setAttribute("colFondo","" );
      ((Element)v.get(471)).setAttribute("ID","EstCab" );
      ((Element)v.get(447)).appendChild((Element)v.get(471));

      /* Elemento padre:471 / Elemento actual: 472   */
      v.add(doc.createTextNode("precioCalculo"));
      ((Element)v.get(471)).appendChild((Text)v.get(472));

      /* Termina nodo Texto:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:473 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(473)).setAttribute("colFondo","" );
      ((Element)v.get(473)).setAttribute("ID","EstCab" );
      ((Element)v.get(447)).appendChild((Element)v.get(473));

      /* Elemento padre:473 / Elemento actual: 474   */
      v.add(doc.createTextNode("oidOperacion"));
      ((Element)v.get(473)).appendChild((Text)v.get(474));

      /* Termina nodo Texto:474   */
      /* Termina nodo:473   */

      /* Empieza nodo:475 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(475)).setAttribute("colFondo","" );
      ((Element)v.get(475)).setAttribute("ID","EstCab" );
      ((Element)v.get(447)).appendChild((Element)v.get(475));

      /* Elemento padre:475 / Elemento actual: 476   */
      v.add(doc.createTextNode("oidPosicion"));
      ((Element)v.get(475)).appendChild((Text)v.get(476));

      /* Termina nodo Texto:476   */
      /* Termina nodo:475   */

      /* Empieza nodo:477 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(477)).setAttribute("colFondo","" );
      ((Element)v.get(477)).setAttribute("ID","EstCab" );
      ((Element)v.get(447)).appendChild((Element)v.get(477));

      /* Elemento padre:477 / Elemento actual: 478   */
      v.add(doc.createTextNode("oidConcurso"));
      ((Element)v.get(477)).appendChild((Text)v.get(478));

      /* Termina nodo Texto:478   */
      /* Termina nodo:477   */

      /* Empieza nodo:479 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(479)).setAttribute("colFondo","" );
      ((Element)v.get(479)).setAttribute("ID","EstCab" );
      ((Element)v.get(447)).appendChild((Element)v.get(479));

      /* Elemento padre:479 / Elemento actual: 480   */
      v.add(doc.createTextNode("oidNivel"));
      ((Element)v.get(479)).appendChild((Text)v.get(480));

      /* Termina nodo Texto:480   */
      /* Termina nodo:479   */

      /* Empieza nodo:481 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(481)).setAttribute("colFondo","" );
      ((Element)v.get(481)).setAttribute("ID","EstCab" );
      ((Element)v.get(447)).appendChild((Element)v.get(481));

      /* Elemento padre:481 / Elemento actual: 482   */
      v.add(doc.createTextNode("oidPremio"));
      ((Element)v.get(481)).appendChild((Text)v.get(482));

      /* Termina nodo Texto:482   */
      /* Termina nodo:481   */
      /* Termina nodo:447   */

      /* Empieza nodo:483 / Elemento padre: 413   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(483)).setAttribute("alto","22" );
      ((Element)v.get(483)).setAttribute("accion","" );
      ((Element)v.get(483)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(483)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(483)).setAttribute("maxSel","-1" );
      ((Element)v.get(483)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(483)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(483)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(483)).setAttribute("onLoad","" );
      ((Element)v.get(483)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(413)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(484)).setAttribute("tipo","texto" );
      ((Element)v.get(484)).setAttribute("ID","EstDat" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */

      /* Empieza nodo:485 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(485)).setAttribute("tipo","texto" );
      ((Element)v.get(485)).setAttribute("ID","EstDat2" );
      ((Element)v.get(483)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */

      /* Empieza nodo:486 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(486)).setAttribute("tipo","texto" );
      ((Element)v.get(486)).setAttribute("ID","EstDat" );
      ((Element)v.get(483)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */

      /* Empieza nodo:487 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(487)).setAttribute("tipo","texto" );
      ((Element)v.get(487)).setAttribute("ID","EstDat2" );
      ((Element)v.get(483)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */

      /* Empieza nodo:488 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(488)).setAttribute("tipo","texto" );
      ((Element)v.get(488)).setAttribute("ID","EstDat" );
      ((Element)v.get(483)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */

      /* Empieza nodo:489 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(489)).setAttribute("tipo","texto" );
      ((Element)v.get(489)).setAttribute("ID","EstDat2" );
      ((Element)v.get(483)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */

      /* Empieza nodo:490 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(490)).setAttribute("tipo","texto" );
      ((Element)v.get(490)).setAttribute("ID","EstDat" );
      ((Element)v.get(483)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */

      /* Empieza nodo:491 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(491)).setAttribute("tipo","texto" );
      ((Element)v.get(491)).setAttribute("ID","EstDat2" );
      ((Element)v.get(483)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */

      /* Empieza nodo:492 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(492)).setAttribute("tipo","texto" );
      ((Element)v.get(492)).setAttribute("ID","EstDat" );
      ((Element)v.get(483)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */

      /* Empieza nodo:493 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(493)).setAttribute("tipo","texto" );
      ((Element)v.get(493)).setAttribute("ID","EstDat2" );
      ((Element)v.get(483)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */

      /* Empieza nodo:494 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(494)).setAttribute("tipo","texto" );
      ((Element)v.get(494)).setAttribute("ID","EstDat" );
      ((Element)v.get(483)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */

      /* Empieza nodo:495 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(495)).setAttribute("tipo","texto" );
      ((Element)v.get(495)).setAttribute("ID","EstDat2" );
      ((Element)v.get(483)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */

      /* Empieza nodo:496 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(496)).setAttribute("tipo","texto" );
      ((Element)v.get(496)).setAttribute("ID","EstDat" );
      ((Element)v.get(483)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */

      /* Empieza nodo:497 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(497)).setAttribute("tipo","texto" );
      ((Element)v.get(497)).setAttribute("ID","EstDat2" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(483)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */

      /* Empieza nodo:498 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(498)).setAttribute("tipo","texto" );
      ((Element)v.get(498)).setAttribute("ID","EstDat" );
      ((Element)v.get(483)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */

      /* Empieza nodo:499 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(499)).setAttribute("tipo","texto" );
      ((Element)v.get(499)).setAttribute("ID","EstDat2" );
      ((Element)v.get(483)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */

      /* Empieza nodo:500 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(500)).setAttribute("tipo","texto" );
      ((Element)v.get(500)).setAttribute("ID","EstDat" );
      ((Element)v.get(483)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */

      /* Empieza nodo:501 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(501)).setAttribute("tipo","texto" );
      ((Element)v.get(501)).setAttribute("ID","EstDat2" );
      ((Element)v.get(483)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */

      /* Empieza nodo:502 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(502)).setAttribute("tipo","texto" );
      ((Element)v.get(502)).setAttribute("ID","EstDat" );
      ((Element)v.get(483)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */

      /* Empieza nodo:503 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(503)).setAttribute("tipo","texto" );
      ((Element)v.get(503)).setAttribute("ID","EstDat2" );
      ((Element)v.get(483)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */

      /* Empieza nodo:504 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(504)).setAttribute("tipo","texto" );
      ((Element)v.get(504)).setAttribute("ID","EstDat" );
      ((Element)v.get(483)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */

      /* Empieza nodo:505 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(505)).setAttribute("tipo","texto" );
      ((Element)v.get(505)).setAttribute("ID","EstDat2" );
      ((Element)v.get(483)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */

      /* Empieza nodo:506 / Elemento padre: 483   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(506)).setAttribute("tipo","texto" );
      ((Element)v.get(506)).setAttribute("ID","EstDat" );
      ((Element)v.get(483)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */
      /* Termina nodo:483   */

      /* Empieza nodo:507 / Elemento padre: 413   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(413)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */

      /* Empieza nodo:508 / Elemento padre: 413   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(508)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(508)).setAttribute("ancho","630" );
      ((Element)v.get(508)).setAttribute("sep","$" );
      ((Element)v.get(508)).setAttribute("x","24" );
      ((Element)v.get(508)).setAttribute("class","botonera" );
      ((Element)v.get(508)).setAttribute("y","927" );
      ((Element)v.get(508)).setAttribute("control","|" );
      ((Element)v.get(508)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(508)).setAttribute("rowset","" );
      ((Element)v.get(508)).setAttribute("cargainicial","N" );
      ((Element)v.get(413)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(509)).setAttribute("nombre","ret2" );
      ((Element)v.get(509)).setAttribute("x","49" );
      ((Element)v.get(509)).setAttribute("y","931" );
      ((Element)v.get(509)).setAttribute("ID","botonContenido" );
      ((Element)v.get(509)).setAttribute("img","retroceder_on" );
      ((Element)v.get(509)).setAttribute("tipo","0" );
      ((Element)v.get(509)).setAttribute("estado","false" );
      ((Element)v.get(509)).setAttribute("alt","" );
      ((Element)v.get(509)).setAttribute("codigo","" );
      ((Element)v.get(509)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */

      /* Empieza nodo:510 / Elemento padre: 508   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(510)).setAttribute("nombre","ava2" );
      ((Element)v.get(510)).setAttribute("x","64" );
      ((Element)v.get(510)).setAttribute("y","931" );
      ((Element)v.get(510)).setAttribute("ID","botonContenido" );
      ((Element)v.get(510)).setAttribute("img","avanzar_on" );
      ((Element)v.get(510)).setAttribute("tipo","0" );
      ((Element)v.get(510)).setAttribute("estado","false" );
      ((Element)v.get(510)).setAttribute("alt","" );
      ((Element)v.get(510)).setAttribute("codigo","" );
      ((Element)v.get(510)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(508)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:508   */
      /* Termina nodo:413   */

      /* Empieza nodo:511 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(511)).setAttribute("nombre","primera2" );
      ((Element)v.get(511)).setAttribute("x","32" );
      ((Element)v.get(511)).setAttribute("y","931" );
      ((Element)v.get(511)).setAttribute("ID","botonContenido" );
      ((Element)v.get(511)).setAttribute("img","primera_on" );
      ((Element)v.get(511)).setAttribute("tipo","-2" );
      ((Element)v.get(511)).setAttribute("estado","false" );
      ((Element)v.get(511)).setAttribute("alt","" );
      ((Element)v.get(511)).setAttribute("codigo","" );
      ((Element)v.get(511)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(10)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */

      /* Empieza nodo:512 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(512)).setAttribute("nombre","separa2" );
      ((Element)v.get(512)).setAttribute("x","71" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(512)).setAttribute("y","927" );
      ((Element)v.get(512)).setAttribute("ID","botonContenido" );
      ((Element)v.get(512)).setAttribute("img","separa_base" );
      ((Element)v.get(512)).setAttribute("tipo","0" );
      ((Element)v.get(512)).setAttribute("estado","false" );
      ((Element)v.get(512)).setAttribute("alt","" );
      ((Element)v.get(512)).setAttribute("codigo","" );
      ((Element)v.get(512)).setAttribute("accion","" );
      ((Element)v.get(10)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */
      /* Termina nodo:10   */


   }

}

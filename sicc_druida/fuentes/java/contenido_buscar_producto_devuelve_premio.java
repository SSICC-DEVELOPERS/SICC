
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_buscar_producto_devuelve_premio  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_producto_no_buscar" );
      ((Element)v.get(0)).setAttribute("cod","0223" );
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
      v.add(doc.createTextNode("\r   \r\r#ret1Div {visibility:visible;}\r#ava1Div {visibility:visible;}\r#primera1Div {visibility:visible;}\r#separaDiv {visibility:visible;}\r\r#CplstResultado{visibility:visible;}\r#CpLin1lstResultado{visibility:visible;}\r#CpLin2lstResultado{visibility:visible;}\r#CpLin3lstResultado{visibility:visible;}\r#CpLin4lstResultado{visibility:visible;}\r\r#CplstProductos{visibility:visible;}\r#CpLin1lstProductos{visibility:visible;}\r#CpLin2lstProductos{visibility:visible;}\r#CpLin3lstProductos{visibility:visible;}\r#CpLin4lstProductos{visibility:visible;}\r\r#buscarDiv{visibility:visible;}\r#anadirDiv{visibility:visible;}\r#aceptarDiv{visibility:visible;}\r#eliminarDiv{visibility:visible;}\r\r   \r"));
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
      ((Element)v.get(6)).setAttribute("src","contenido_buscar_producto_devuelve_premio.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","descUnidadesAReclamar" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("cod","506" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","descUnidadesADevolver" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("cod","309" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtPagCat" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("cod","571" );
      ((Element)v.get(11)).setAttribute("group","CuadroBusqueda" );
      ((Element)v.get(11)).setAttribute("format","e" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */
      /* Termina nodo:8   */

      /* Empieza nodo:12 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(12)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","accion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","idioma" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","pais" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","casoUso" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","ingresaDevuelve" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","devuelveFactura" );
      ((Element)v.get(22)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(12)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","ingresaEnvia" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","enviaFactura" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hid_SeparadorMiles" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hid_SeparadorDecimales" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hid_NumeroDecimales" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","arrayList" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","pagina" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","cerrar" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","visible" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hOidsMotivoDevolucion" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hDescsMotivoDevolucion" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hOidMotivoDevolucionDefecto" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","devuelveFisicoFactura" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","indBuscar" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","oidNumDocumento" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","oidOperacion" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","oidTipoOperacion" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","numeroLinea" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","precioEnvia" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","tipoMovimiento" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","oidTipoMovimiento" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).setAttribute("nombre","controlProductosDevuelve" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","indicadorDevuelveProcesado" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","ind2doDevuelve" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","ind2doDevuelveProcesado" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","datosListaDevuelve" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","matriz" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 12   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(51)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(51)).setAttribute("visibilidad","visible" );
      ((Element)v.get(12)).appendChild((Element)v.get(51));

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
      ((Element)v.get(60)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(65)).setAttribute("class","legend" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(66)).setAttribute("nombre","lblCriterios" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("filas","1" );
      ((Element)v.get(66)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(66)).setAttribute("id","legend" );
      ((Element)v.get(66)).setAttribute("cod","0075" );
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
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("table"));
      ((Element)v.get(70)).setAttribute("width","628" );
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
      ((Element)v.get(78)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(78)).setAttribute("alto","13" );
      ((Element)v.get(78)).setAttribute("filas","1" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(78)).setAttribute("id","datosTitle" );
      ((Element)v.get(78)).setAttribute("cod","9" );
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
      ((Element)v.get(82)).setAttribute("nombre","lblCodVenta" );
      ((Element)v.get(82)).setAttribute("alto","13" );
      ((Element)v.get(82)).setAttribute("filas","1" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(82)).setAttribute("id","datosTitle" );
      ((Element)v.get(82)).setAttribute("cod","1853" );
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
      ((Element)v.get(86)).setAttribute("nombre","lblCodProducto" );
      ((Element)v.get(86)).setAttribute("alto","13" );
      ((Element)v.get(86)).setAttribute("filas","1" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(86)).setAttribute("id","datosTitle" );
      ((Element)v.get(86)).setAttribute("cod","337" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","25" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(90)).setAttribute("nombre","lblPagCat" );
      ((Element)v.get(90)).setAttribute("alto","13" );
      ((Element)v.get(90)).setAttribute("filas","1" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(90)).setAttribute("id","datosTitle" );
      ((Element)v.get(90)).setAttribute("cod","571" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","100%" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(74)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:74   */

      /* Empieza nodo:93 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","8" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(93)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(97)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(97)).setAttribute("id","datosCampos" );
      ((Element)v.get(97)).setAttribute("max","30" );
      ((Element)v.get(97)).setAttribute("tipo","" );
      ((Element)v.get(97)).setAttribute("onchange","" );
      ((Element)v.get(97)).setAttribute("ontab","setTabFocus('txtDescripcion');" );
      ((Element)v.get(97)).setAttribute("onshtab","setShTabFocus('txtDescripcion');" );
      ((Element)v.get(97)).setAttribute("req","N" );
      ((Element)v.get(97)).setAttribute("size","40" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(97)).setAttribute("validacion","" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","25" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(93)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(101)).setAttribute("nombre","txtCodVenta" );
      ((Element)v.get(101)).setAttribute("id","datosCampos" );
      ((Element)v.get(101)).setAttribute("max","18" );
      ((Element)v.get(101)).setAttribute("tipo","" );
      ((Element)v.get(101)).setAttribute("ontab","setTabFocus('txtCodVenta');" );
      ((Element)v.get(101)).setAttribute("onshtab","setShTabFocus('txtCodVenta');" );
      ((Element)v.get(101)).setAttribute("onchange","mayusculas('txtCodVenta')" );
      ((Element)v.get(101)).setAttribute("req","N" );
      ((Element)v.get(101)).setAttribute("size","24" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(101)).setAttribute("validacion","" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","25" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(93)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(105)).setAttribute("nombre","txtCodProducto" );
      ((Element)v.get(105)).setAttribute("id","datosCampos" );
      ((Element)v.get(105)).setAttribute("max","20" );
      ((Element)v.get(105)).setAttribute("tipo","" );
      ((Element)v.get(105)).setAttribute("ontab","setTabFocus('txtCodProducto');" );
      ((Element)v.get(105)).setAttribute("onshtab","setShTabFocus('txtCodProducto');" );
      ((Element)v.get(105)).setAttribute("onchange","mayusculas('txtCodProducto')" );
      ((Element)v.get(105)).setAttribute("req","N" );
      ((Element)v.get(105)).setAttribute("size","20" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(105)).setAttribute("validacion","" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","25" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(93)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(109)).setAttribute("nombre","txtPagCat" );
      ((Element)v.get(109)).setAttribute("id","datosCampos" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(109)).setAttribute("max","3" );
      ((Element)v.get(109)).setAttribute("tipo","" );
      ((Element)v.get(109)).setAttribute("onblur","" );
      ((Element)v.get(109)).setAttribute("ontab","setTabFocus('txtPagCat');" );
      ((Element)v.get(109)).setAttribute("onshtab","setShTabFocus('txtPagCat');" );
      ((Element)v.get(109)).setAttribute("onchange","" );
      ((Element)v.get(109)).setAttribute("req","N" );
      ((Element)v.get(109)).setAttribute("size","3" );
      ((Element)v.get(109)).setAttribute("valor","" );
      ((Element)v.get(109)).setAttribute("validacion","" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("width","100%" );
      ((Element)v.get(93)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","8" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:93   */

      /* Empieza nodo:112 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("colspan","4" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:115 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:60   */

      /* Empieza nodo:117 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("table"));
      ((Element)v.get(122)).setAttribute("width","100%" );
      ((Element)v.get(122)).setAttribute("border","0" );
      ((Element)v.get(122)).setAttribute("align","center" );
      ((Element)v.get(122)).setAttribute("cellspacing","0" );
      ((Element)v.get(122)).setAttribute("cellpadding","0" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("class","botonera" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(125)).setAttribute("nombre","buscar" );
      ((Element)v.get(125)).setAttribute("ID","botonContenido" );
      ((Element)v.get(125)).setAttribute("tipo","html" );
      ((Element)v.get(125)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(125)).setAttribute("estado","false" );
      ((Element)v.get(125)).setAttribute("cod","1" );
      ((Element)v.get(125)).setAttribute("ontab","setTabFocus('buscar');" );
      ((Element)v.get(125)).setAttribute("onshtab","setShTabFocus('buscar');" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:126 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","12" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:117   */

      /* Empieza nodo:128 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","12" );
      ((Element)v.get(129)).setAttribute("align","center" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","12" );
      ((Element)v.get(130)).setAttribute("height","12" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("width","750" );
      ((Element)v.get(128)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("width","12" );
      ((Element)v.get(128)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","12" );
      ((Element)v.get(134)).setAttribute("height","1" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:128   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:135 / Elemento padre: 12   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(135)).setAttribute("nombre","lstResultado" );
      ((Element)v.get(135)).setAttribute("ancho","631" );
      ((Element)v.get(135)).setAttribute("alto","317" );
      ((Element)v.get(135)).setAttribute("x","12" );
      ((Element)v.get(135)).setAttribute("y","124" );
      ((Element)v.get(135)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(135)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(12)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(136)).setAttribute("precarga","S" );
      ((Element)v.get(136)).setAttribute("conROver","S" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(137)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(137)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(137)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(137)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 136   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(138)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(138)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(138)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(138)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(136)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(139)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(139)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(136)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:136   */

      /* Empieza nodo:140 / Elemento padre: 135   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(135)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(141)).setAttribute("borde","1" );
      ((Element)v.get(141)).setAttribute("horizDatos","1" );
      ((Element)v.get(141)).setAttribute("horizCabecera","1" );
      ((Element)v.get(141)).setAttribute("vertical","1" );
      ((Element)v.get(141)).setAttribute("horizTitulo","1" );
      ((Element)v.get(141)).setAttribute("horizBase","1" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 140   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(142)).setAttribute("borde","#999999" );
      ((Element)v.get(142)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(142)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(142)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(142)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(142)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(142)).setAttribute("horizBase","#999999" );
      ((Element)v.get(140)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:140   */

      /* Empieza nodo:143 / Elemento padre: 135   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(143)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(143)).setAttribute("alto","22" );
      ((Element)v.get(143)).setAttribute("imgFondo","" );
      ((Element)v.get(143)).setAttribute("cod","00135" );
      ((Element)v.get(143)).setAttribute("ID","datosTitle" );
      ((Element)v.get(135)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 135   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(144)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(144)).setAttribute("alto","22" );
      ((Element)v.get(144)).setAttribute("imgFondo","" );
      ((Element)v.get(135)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 135   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(145)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(145)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(145)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(145)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(145)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(145)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(135)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("ancho","150" );
      ((Element)v.get(146)).setAttribute("minimizable","S" );
      ((Element)v.get(146)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(147)).setAttribute("ancho","100" );
      ((Element)v.get(147)).setAttribute("minimizable","S" );
      ((Element)v.get(147)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("ancho","130" );
      ((Element)v.get(148)).setAttribute("minimizable","S" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(148)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(149)).setAttribute("ancho","130" );
      ((Element)v.get(149)).setAttribute("minimizable","S" );
      ((Element)v.get(149)).setAttribute("minimizada","N" );
      ((Element)v.get(149)).setAttribute("oculta","S" );
      ((Element)v.get(145)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("ancho","100" );
      ((Element)v.get(150)).setAttribute("minimizable","S" );
      ((Element)v.get(150)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("ancho","100" );
      ((Element)v.get(151)).setAttribute("minimizable","S" );
      ((Element)v.get(151)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("ancho","150" );
      ((Element)v.get(152)).setAttribute("minimizable","S" );
      ((Element)v.get(152)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("ancho","130" );
      ((Element)v.get(153)).setAttribute("minimizable","S" );
      ((Element)v.get(153)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("ancho","100" );
      ((Element)v.get(154)).setAttribute("minimizable","S" );
      ((Element)v.get(154)).setAttribute("minimizada","N" );
      ((Element)v.get(154)).setAttribute("oculta","S" );
      ((Element)v.get(145)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("ancho","150" );
      ((Element)v.get(155)).setAttribute("minimizable","S" );
      ((Element)v.get(155)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("ancho","130" );
      ((Element)v.get(156)).setAttribute("minimizable","S" );
      ((Element)v.get(156)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).setAttribute("oculta","S" );
      ((Element)v.get(145)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("ancho","110" );
      ((Element)v.get(157)).setAttribute("minimizable","S" );
      ((Element)v.get(157)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("ancho","110" );
      ((Element)v.get(158)).setAttribute("minimizable","S" );
      ((Element)v.get(158)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("ancho","110" );
      ((Element)v.get(159)).setAttribute("minimizable","S" );
      ((Element)v.get(159)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("ancho","110" );
      ((Element)v.get(160)).setAttribute("minimizable","S" );
      ((Element)v.get(160)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("ancho","110" );
      ((Element)v.get(161)).setAttribute("minimizable","S" );
      ((Element)v.get(161)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("ancho","110" );
      ((Element)v.get(162)).setAttribute("minimizable","S" );
      ((Element)v.get(162)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("ancho","130" );
      ((Element)v.get(163)).setAttribute("minimizable","S" );
      ((Element)v.get(163)).setAttribute("minimizada","N" );
      ((Element)v.get(163)).setAttribute("oculta","S" );
      ((Element)v.get(145)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("ancho","110" );
      ((Element)v.get(164)).setAttribute("minimizable","S" );
      ((Element)v.get(164)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("ancho","110" );
      ((Element)v.get(165)).setAttribute("minimizable","S" );
      ((Element)v.get(165)).setAttribute("minimizada","N" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(145)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("ancho","110" );
      ((Element)v.get(166)).setAttribute("minimizable","S" );
      ((Element)v.get(166)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("ancho","110" );
      ((Element)v.get(167)).setAttribute("minimizable","S" );
      ((Element)v.get(167)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("ancho","130" );
      ((Element)v.get(168)).setAttribute("minimizable","S" );
      ((Element)v.get(168)).setAttribute("minimizada","N" );
      ((Element)v.get(168)).setAttribute("oculta","S" );
      ((Element)v.get(145)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("ancho","130" );
      ((Element)v.get(169)).setAttribute("minimizable","S" );
      ((Element)v.get(169)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).setAttribute("oculta","S" );
      ((Element)v.get(145)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("ancho","130" );
      ((Element)v.get(170)).setAttribute("minimizable","S" );
      ((Element)v.get(170)).setAttribute("minimizada","N" );
      ((Element)v.get(170)).setAttribute("oculta","S" );
      ((Element)v.get(145)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:145   */

      /* Empieza nodo:171 / Elemento padre: 135   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(171)).setAttribute("alto","25" );
      ((Element)v.get(171)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(171)).setAttribute("imgFondo","" );
      ((Element)v.get(171)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(135)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("colFondo","" );
      ((Element)v.get(172)).setAttribute("ID","EstCab" );
      ((Element)v.get(172)).setAttribute("cod","338" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("colFondo","" );
      ((Element)v.get(173)).setAttribute("ID","EstCab" );
      ((Element)v.get(173)).setAttribute("cod","276" );
      ((Element)v.get(171)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("colFondo","" );
      ((Element)v.get(174)).setAttribute("ID","EstCab" );
      ((Element)v.get(174)).setAttribute("cod","465" );
      ((Element)v.get(171)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("colFondo","" );
      ((Element)v.get(175)).setAttribute("ID","EstCab" );
      ((Element)v.get(175)).setAttribute("cod","302" );
      ((Element)v.get(171)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("colFondo","" );
      ((Element)v.get(176)).setAttribute("ID","EstCab" );
      ((Element)v.get(176)).setAttribute("cod","1604" );
      ((Element)v.get(171)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("colFondo","" );
      ((Element)v.get(177)).setAttribute("ID","EstCab" );
      ((Element)v.get(177)).setAttribute("cod","1664" );
      ((Element)v.get(171)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("colFondo","" );
      ((Element)v.get(178)).setAttribute("ID","EstCab" );
      ((Element)v.get(178)).setAttribute("cod","680" );
      ((Element)v.get(171)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("colFondo","" );
      ((Element)v.get(179)).setAttribute("ID","EstCab" );
      ((Element)v.get(179)).setAttribute("cod","1853" );
      ((Element)v.get(171)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("colFondo","" );
      ((Element)v.get(180)).setAttribute("ID","EstCab" );
      ((Element)v.get(180)).setAttribute("cod","2354" );
      ((Element)v.get(171)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("colFondo","" );
      ((Element)v.get(181)).setAttribute("ID","EstCab" );
      ((Element)v.get(181)).setAttribute("cod","337" );
      ((Element)v.get(171)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("colFondo","" );
      ((Element)v.get(182)).setAttribute("ID","EstCab" );
      ((Element)v.get(182)).setAttribute("cod","2356" );
      ((Element)v.get(171)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 171   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("colFondo","" );
      ((Element)v.get(183)).setAttribute("ID","EstCab" );
      ((Element)v.get(183)).setAttribute("cod","2354" );
      ((Element)v.get(171)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("colFondo","" );
      ((Element)v.get(184)).setAttribute("ID","EstCab" );
      ((Element)v.get(184)).setAttribute("cod","341" );
      ((Element)v.get(171)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("colFondo","" );
      ((Element)v.get(185)).setAttribute("ID","EstCab" );
      ((Element)v.get(185)).setAttribute("cod","2356" );
      ((Element)v.get(171)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("colFondo","" );
      ((Element)v.get(186)).setAttribute("ID","EstCab" );
      ((Element)v.get(186)).setAttribute("cod","504" );
      ((Element)v.get(171)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("colFondo","" );
      ((Element)v.get(187)).setAttribute("ID","EstCab" );
      ((Element)v.get(187)).setAttribute("cod","339" );
      ((Element)v.get(171)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("colFondo","" );
      ((Element)v.get(188)).setAttribute("ID","EstCab" );
      ((Element)v.get(188)).setAttribute("cod","1011" );
      ((Element)v.get(171)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("colFondo","" );
      ((Element)v.get(189)).setAttribute("ID","EstCab" );
      ((Element)v.get(189)).setAttribute("cod","1419" );
      ((Element)v.get(171)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("colFondo","" );
      ((Element)v.get(190)).setAttribute("ID","EstCab" );
      ((Element)v.get(190)).setAttribute("cod","" );
      ((Element)v.get(171)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("colFondo","" );
      ((Element)v.get(191)).setAttribute("ID","EstCab" );
      ((Element)v.get(191)).setAttribute("cod","" );
      ((Element)v.get(171)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("colFondo","" );
      ((Element)v.get(192)).setAttribute("ID","EstCab" );
      ((Element)v.get(192)).setAttribute("cod","" );
      ((Element)v.get(171)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("colFondo","" );
      ((Element)v.get(193)).setAttribute("ID","EstCab" );
      ((Element)v.get(193)).setAttribute("cod","" );
      ((Element)v.get(171)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("colFondo","" );
      ((Element)v.get(194)).setAttribute("ID","EstCab" );
      ((Element)v.get(194)).setAttribute("cod","1011" );
      ((Element)v.get(171)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(195)).setAttribute("colFondo","" );
      ((Element)v.get(195)).setAttribute("ID","EstCab" );
      ((Element)v.get(195)).setAttribute("cod","1604" );
      ((Element)v.get(171)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(196)).setAttribute("colFondo","" );
      ((Element)v.get(196)).setAttribute("ID","EstCab" );
      ((Element)v.get(196)).setAttribute("cod","1664" );
      ((Element)v.get(171)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(197)).setAttribute("colFondo","" );
      ((Element)v.get(197)).setAttribute("ID","EstCab" );
      ((Element)v.get(197)).setAttribute("cod","1691" );
      ((Element)v.get(171)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("colFondo","" );
      ((Element)v.get(198)).setAttribute("ID","EstCab" );
      ((Element)v.get(198)).setAttribute("cod","2578" );
      ((Element)v.get(171)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(199)).setAttribute("colFondo","" );
      ((Element)v.get(199)).setAttribute("ID","EstCab" );
      ((Element)v.get(199)).setAttribute("cod","1604" );
      ((Element)v.get(171)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(200)).setAttribute("colFondo","" );
      ((Element)v.get(200)).setAttribute("ID","EstCab" );
      ((Element)v.get(200)).setAttribute("cod","1664" );
      ((Element)v.get(171)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 171   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(201)).setAttribute("colFondo","" );
      ((Element)v.get(201)).setAttribute("ID","EstCab" );
      ((Element)v.get(201)).setAttribute("cod","1691" );
      ((Element)v.get(171)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:171   */

      /* Empieza nodo:202 / Elemento padre: 135   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(202)).setAttribute("alto","22" );
      ((Element)v.get(202)).setAttribute("accion","" );
      ((Element)v.get(202)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(202)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(202)).setAttribute("maxSel","-1" );
      ((Element)v.get(202)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(202)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(202)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(202)).setAttribute("onLoad","" );
      ((Element)v.get(202)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(135)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(203)).setAttribute("tipo","texto" );
      ((Element)v.get(203)).setAttribute("ID","EstDat" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("tipo","texto" );
      ((Element)v.get(204)).setAttribute("ID","EstDat2" );
      ((Element)v.get(202)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(205)).setAttribute("tipo","texto" );
      ((Element)v.get(205)).setAttribute("ID","EstDat" );
      ((Element)v.get(202)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("tipo","texto" );
      ((Element)v.get(206)).setAttribute("ID","EstDat" );
      ((Element)v.get(202)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("tipo","texto" );
      ((Element)v.get(207)).setAttribute("ID","EstDat2" );
      ((Element)v.get(202)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("tipo","texto" );
      ((Element)v.get(208)).setAttribute("ID","EstDat" );
      ((Element)v.get(202)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(209)).setAttribute("tipo","texto" );
      ((Element)v.get(209)).setAttribute("ID","EstDat2" );
      ((Element)v.get(202)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */

      /* Empieza nodo:210 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("tipo","texto" );
      ((Element)v.get(210)).setAttribute("ID","EstDat" );
      ((Element)v.get(202)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(211)).setAttribute("tipo","texto" );
      ((Element)v.get(211)).setAttribute("ID","EstDat" );
      ((Element)v.get(202)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("tipo","texto" );
      ((Element)v.get(212)).setAttribute("ID","EstDat2" );
      ((Element)v.get(202)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(213)).setAttribute("tipo","texto" );
      ((Element)v.get(213)).setAttribute("ID","EstDat2" );
      ((Element)v.get(202)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("tipo","texto" );
      ((Element)v.get(214)).setAttribute("ID","EstDat" );
      ((Element)v.get(202)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(215)).setAttribute("tipo","texto" );
      ((Element)v.get(215)).setAttribute("ID","EstDat2" );
      ((Element)v.get(202)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("tipo","texto" );
      ((Element)v.get(216)).setAttribute("ID","EstDat" );
      ((Element)v.get(202)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("tipo","texto" );
      ((Element)v.get(217)).setAttribute("ID","EstDat2" );
      ((Element)v.get(202)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(218)).setAttribute("tipo","texto" );
      ((Element)v.get(218)).setAttribute("ID","EstDat" );
      ((Element)v.get(202)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(219)).setAttribute("tipo","texto" );
      ((Element)v.get(219)).setAttribute("ID","EstDat2" );
      ((Element)v.get(202)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(220)).setAttribute("tipo","texto" );
      ((Element)v.get(220)).setAttribute("ID","EstDat" );
      ((Element)v.get(202)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(221)).setAttribute("tipo","texto" );
      ((Element)v.get(221)).setAttribute("ID","EstDat2" );
      ((Element)v.get(202)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("tipo","texto" );
      ((Element)v.get(222)).setAttribute("ID","EstDat" );
      ((Element)v.get(202)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(223)).setAttribute("tipo","texto" );
      ((Element)v.get(223)).setAttribute("ID","EstDat2" );
      ((Element)v.get(202)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("tipo","texto" );
      ((Element)v.get(224)).setAttribute("ID","EstDat" );
      ((Element)v.get(202)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(225)).setAttribute("tipo","texto" );
      ((Element)v.get(225)).setAttribute("ID","EstDat2" );
      ((Element)v.get(202)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(226)).setAttribute("tipo","texto" );
      ((Element)v.get(226)).setAttribute("ID","EstDat" );
      ((Element)v.get(202)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */

      /* Empieza nodo:227 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("tipo","texto" );
      ((Element)v.get(227)).setAttribute("ID","EstDat2" );
      ((Element)v.get(202)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(228)).setAttribute("tipo","texto" );
      ((Element)v.get(228)).setAttribute("ID","EstDat" );
      ((Element)v.get(202)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("tipo","texto" );
      ((Element)v.get(229)).setAttribute("ID","EstDat2" );
      ((Element)v.get(202)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("tipo","texto" );
      ((Element)v.get(230)).setAttribute("ID","EstDat" );
      ((Element)v.get(202)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("tipo","texto" );
      ((Element)v.get(231)).setAttribute("ID","EstDat2" );
      ((Element)v.get(202)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:202   */

      /* Empieza nodo:232 / Elemento padre: 135   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(135)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 135   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(233)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(233)).setAttribute("ancho","631" );
      ((Element)v.get(233)).setAttribute("sep","$" );
      ((Element)v.get(233)).setAttribute("x","12" );
      ((Element)v.get(233)).setAttribute("class","botonera" );
      ((Element)v.get(233)).setAttribute("y","418" );
      ((Element)v.get(233)).setAttribute("control","|" );
      ((Element)v.get(233)).setAttribute("conector","" );
      ((Element)v.get(233)).setAttribute("rowset","" );
      ((Element)v.get(233)).setAttribute("onload","procesarPaginado(mipgndo, msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(233)).setAttribute("cargainicial","N" );
      ((Element)v.get(135)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(234)).setAttribute("nombre","ret1" );
      ((Element)v.get(234)).setAttribute("x","37" );
      ((Element)v.get(234)).setAttribute("y","422" );
      ((Element)v.get(234)).setAttribute("ID","botonContenido" );
      ((Element)v.get(234)).setAttribute("img","retroceder_on" );
      ((Element)v.get(234)).setAttribute("tipo","0" );
      ((Element)v.get(234)).setAttribute("estado","false" );
      ((Element)v.get(234)).setAttribute("alt","" );
      ((Element)v.get(234)).setAttribute("codigo","" );
      ((Element)v.get(234)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 233   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(235)).setAttribute("nombre","ava1" );
      ((Element)v.get(235)).setAttribute("x","52" );
      ((Element)v.get(235)).setAttribute("y","422" );
      ((Element)v.get(235)).setAttribute("ID","botonContenido" );
      ((Element)v.get(235)).setAttribute("img","avanzar_on" );
      ((Element)v.get(235)).setAttribute("tipo","0" );
      ((Element)v.get(235)).setAttribute("estado","false" );
      ((Element)v.get(235)).setAttribute("alt","" );
      ((Element)v.get(235)).setAttribute("codigo","" );
      ((Element)v.get(235)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(233)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:233   */
      /* Termina nodo:135   */

      /* Empieza nodo:236 / Elemento padre: 12   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(236)).setAttribute("nombre","primera1" );
      ((Element)v.get(236)).setAttribute("x","20" );
      ((Element)v.get(236)).setAttribute("y","422" );
      ((Element)v.get(236)).setAttribute("ID","botonContenido" );
      ((Element)v.get(236)).setAttribute("img","primera_on" );
      ((Element)v.get(236)).setAttribute("tipo","-2" );
      ((Element)v.get(236)).setAttribute("estado","false" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(236)).setAttribute("alt","" );
      ((Element)v.get(236)).setAttribute("codigo","" );
      ((Element)v.get(236)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(12)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 12   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(237)).setAttribute("nombre","separa" );
      ((Element)v.get(237)).setAttribute("x","59" );
      ((Element)v.get(237)).setAttribute("y","418" );
      ((Element)v.get(237)).setAttribute("ID","botonContenido" );
      ((Element)v.get(237)).setAttribute("img","separa_base" );
      ((Element)v.get(237)).setAttribute("tipo","0" );
      ((Element)v.get(237)).setAttribute("estado","false" );
      ((Element)v.get(237)).setAttribute("alt","" );
      ((Element)v.get(237)).setAttribute("codigo","" );
      ((Element)v.get(237)).setAttribute("accion","" );
      ((Element)v.get(12)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 12   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(238)).setAttribute("nombre","anadir" );
      ((Element)v.get(238)).setAttribute("x","80" );
      ((Element)v.get(238)).setAttribute("y","419" );
      ((Element)v.get(238)).setAttribute("ID","botonContenido" );
      ((Element)v.get(238)).setAttribute("ontab","setTabFocus('anadir');" );
      ((Element)v.get(238)).setAttribute("onshtab","setShTabFocus('anadir');" );
      ((Element)v.get(238)).setAttribute("accion","onClickAnyadir();" );
      ((Element)v.get(238)).setAttribute("tipo","html" );
      ((Element)v.get(238)).setAttribute("estado","false" );
      ((Element)v.get(238)).setAttribute("cod","404" );
      ((Element)v.get(12)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 12   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(239)).setAttribute("nombre","lstProductos" );
      ((Element)v.get(239)).setAttribute("ancho","631" );
      ((Element)v.get(239)).setAttribute("alto","317" );
      ((Element)v.get(239)).setAttribute("x","12" );
      ((Element)v.get(239)).setAttribute("y","465" );
      ((Element)v.get(239)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(239)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(12)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(240)).setAttribute("precarga","S" );
      ((Element)v.get(240)).setAttribute("conROver","S" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(241)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(241)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(241)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(241)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 240   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(242)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(242)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(242)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(242)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(240)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 240   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(243)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(243)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(240)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:240   */

      /* Empieza nodo:244 / Elemento padre: 239   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(239)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(245)).setAttribute("borde","1" );
      ((Element)v.get(245)).setAttribute("horizDatos","1" );
      ((Element)v.get(245)).setAttribute("horizCabecera","1" );
      ((Element)v.get(245)).setAttribute("vertical","1" );
      ((Element)v.get(245)).setAttribute("horizTitulo","1" );
      ((Element)v.get(245)).setAttribute("horizBase","1" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */

      /* Empieza nodo:246 / Elemento padre: 244   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(246)).setAttribute("borde","#999999" );
      ((Element)v.get(246)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(246)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(246)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(246)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(246)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(246)).setAttribute("horizBase","#999999" );
      ((Element)v.get(244)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:244   */

      /* Empieza nodo:247 / Elemento padre: 239   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(247)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(247)).setAttribute("alto","22" );
      ((Element)v.get(247)).setAttribute("imgFondo","" );
      ((Element)v.get(247)).setAttribute("cod","00499" );
      ((Element)v.get(247)).setAttribute("ID","datosTitle" );
      ((Element)v.get(239)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 239   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(248)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(248)).setAttribute("alto","22" );
      ((Element)v.get(248)).setAttribute("imgFondo","" );
      ((Element)v.get(239)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */

      /* Empieza nodo:249 / Elemento padre: 239   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(249)).setAttribute("ajustarMinimo","S" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(249)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(249)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(249)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(249)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(249)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(239)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(250)).setAttribute("ancho","150" );
      ((Element)v.get(250)).setAttribute("minimizable","S" );
      ((Element)v.get(250)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(251)).setAttribute("ancho","100" );
      ((Element)v.get(251)).setAttribute("minimizable","S" );
      ((Element)v.get(251)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("ancho","130" );
      ((Element)v.get(252)).setAttribute("minimizable","S" );
      ((Element)v.get(252)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(253)).setAttribute("ancho","130" );
      ((Element)v.get(253)).setAttribute("minimizable","S" );
      ((Element)v.get(253)).setAttribute("minimizada","N" );
      ((Element)v.get(253)).setAttribute("oculta","S" );
      ((Element)v.get(249)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(254)).setAttribute("ancho","100" );
      ((Element)v.get(254)).setAttribute("minimizable","S" );
      ((Element)v.get(254)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("ancho","100" );
      ((Element)v.get(255)).setAttribute("minimizable","S" );
      ((Element)v.get(255)).setAttribute("minimizada","N" );
      ((Element)v.get(255)).setAttribute("oculta","S" );
      ((Element)v.get(249)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(256)).setAttribute("ancho","130" );
      ((Element)v.get(256)).setAttribute("minimizable","S" );
      ((Element)v.get(256)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("ancho","150" );
      ((Element)v.get(257)).setAttribute("minimizable","S" );
      ((Element)v.get(257)).setAttribute("minimizada","N" );
      ((Element)v.get(257)).setAttribute("oculta","S" );
      ((Element)v.get(249)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(258)).setAttribute("ancho","100" );
      ((Element)v.get(258)).setAttribute("minimizable","S" );
      ((Element)v.get(258)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(259)).setAttribute("ancho","110" );
      ((Element)v.get(259)).setAttribute("minimizable","S" );
      ((Element)v.get(259)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(260)).setAttribute("ancho","110" );
      ((Element)v.get(260)).setAttribute("minimizable","S" );
      ((Element)v.get(260)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(261)).setAttribute("ancho","110" );
      ((Element)v.get(261)).setAttribute("minimizable","S" );
      ((Element)v.get(261)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */

      /* Empieza nodo:262 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(262)).setAttribute("ancho","110" );
      ((Element)v.get(262)).setAttribute("minimizable","S" );
      ((Element)v.get(262)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(263)).setAttribute("ancho","110" );
      ((Element)v.get(263)).setAttribute("minimizable","S" );
      ((Element)v.get(263)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */

      /* Empieza nodo:264 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(264)).setAttribute("ancho","110" );
      ((Element)v.get(264)).setAttribute("minimizable","S" );
      ((Element)v.get(264)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("ancho","110" );
      ((Element)v.get(265)).setAttribute("minimizable","S" );
      ((Element)v.get(265)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(266)).setAttribute("ancho","110" );
      ((Element)v.get(266)).setAttribute("minimizable","S" );
      ((Element)v.get(266)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(267)).setAttribute("ancho","130" );
      ((Element)v.get(267)).setAttribute("minimizable","S" );
      ((Element)v.get(267)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("ancho","130" );
      ((Element)v.get(268)).setAttribute("minimizable","S" );
      ((Element)v.get(268)).setAttribute("minimizada","N" );
      ((Element)v.get(268)).setAttribute("oculta","S" );
      ((Element)v.get(249)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("ancho","110" );
      ((Element)v.get(269)).setAttribute("minimizable","S" );
      ((Element)v.get(269)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("ancho","110" );
      ((Element)v.get(270)).setAttribute("minimizable","S" );
      ((Element)v.get(270)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(271)).setAttribute("ancho","110" );
      ((Element)v.get(271)).setAttribute("minimizable","S" );
      ((Element)v.get(271)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("ancho","110" );
      ((Element)v.get(272)).setAttribute("minimizable","S" );
      ((Element)v.get(272)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("ancho","130" );
      ((Element)v.get(273)).setAttribute("minimizable","S" );
      ((Element)v.get(273)).setAttribute("minimizada","N" );
      ((Element)v.get(273)).setAttribute("oculta","S" );
      ((Element)v.get(249)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("ancho","130" );
      ((Element)v.get(274)).setAttribute("minimizable","S" );
      ((Element)v.get(274)).setAttribute("minimizada","N" );
      ((Element)v.get(274)).setAttribute("oculta","S" );
      ((Element)v.get(249)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("ancho","130" );
      ((Element)v.get(275)).setAttribute("minimizable","S" );
      ((Element)v.get(275)).setAttribute("minimizada","N" );
      ((Element)v.get(275)).setAttribute("oculta","S" );
      ((Element)v.get(249)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:249   */

      /* Empieza nodo:276 / Elemento padre: 239   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(276)).setAttribute("alto","25" );
      ((Element)v.get(276)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(276)).setAttribute("imgFondo","" );
      ((Element)v.get(276)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(239)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("colFondo","" );
      ((Element)v.get(277)).setAttribute("ID","EstCab" );
      ((Element)v.get(277)).setAttribute("cod","338" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("colFondo","" );
      ((Element)v.get(278)).setAttribute("ID","EstCab" );
      ((Element)v.get(278)).setAttribute("cod","276" );
      ((Element)v.get(276)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("colFondo","" );
      ((Element)v.get(279)).setAttribute("ID","EstCab" );
      ((Element)v.get(279)).setAttribute("cod","465" );
      ((Element)v.get(276)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("colFondo","" );
      ((Element)v.get(280)).setAttribute("ID","EstCab" );
      ((Element)v.get(280)).setAttribute("cod","302" );
      ((Element)v.get(276)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(281)).setAttribute("colFondo","" );
      ((Element)v.get(281)).setAttribute("ID","EstCab" );
      ((Element)v.get(281)).setAttribute("cod","1853" );
      ((Element)v.get(276)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(282)).setAttribute("colFondo","" );
      ((Element)v.get(282)).setAttribute("ID","EstCab" );
      ((Element)v.get(282)).setAttribute("cod","465" );
      ((Element)v.get(276)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(283)).setAttribute("colFondo","" );
      ((Element)v.get(283)).setAttribute("ID","EstCab" );
      ((Element)v.get(283)).setAttribute("cod","337" );
      ((Element)v.get(276)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("colFondo","" );
      ((Element)v.get(284)).setAttribute("ID","EstCab" );
      ((Element)v.get(284)).setAttribute("cod","337" );
      ((Element)v.get(276)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("colFondo","" );
      ((Element)v.get(285)).setAttribute("ID","EstCab" );
      ((Element)v.get(285)).setAttribute("cod","2354" );
      ((Element)v.get(276)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(286)).setAttribute("colFondo","" );
      ((Element)v.get(286)).setAttribute("ID","EstCab" );
      ((Element)v.get(286)).setAttribute("cod","341" );
      ((Element)v.get(276)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(287)).setAttribute("colFondo","" );
      ((Element)v.get(287)).setAttribute("ID","EstCab" );
      ((Element)v.get(287)).setAttribute("cod","2356" );
      ((Element)v.get(276)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(288)).setAttribute("colFondo","" );
      ((Element)v.get(288)).setAttribute("ID","EstCab" );
      ((Element)v.get(288)).setAttribute("cod","504" );
      ((Element)v.get(276)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(289)).setAttribute("colFondo","" );
      ((Element)v.get(289)).setAttribute("ID","EstCab" );
      ((Element)v.get(289)).setAttribute("cod","339" );
      ((Element)v.get(276)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(290)).setAttribute("colFondo","" );
      ((Element)v.get(290)).setAttribute("ID","EstCab" );
      ((Element)v.get(290)).setAttribute("cod","1011" );
      ((Element)v.get(276)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(291)).setAttribute("colFondo","" );
      ((Element)v.get(291)).setAttribute("ID","EstCab" );
      ((Element)v.get(291)).setAttribute("cod","506" );
      ((Element)v.get(276)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("colFondo","" );
      ((Element)v.get(292)).setAttribute("ID","EstCab" );
      ((Element)v.get(292)).setAttribute("cod","2492" );
      ((Element)v.get(276)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(293)).setAttribute("colFondo","" );
      ((Element)v.get(293)).setAttribute("ID","EstCab" );
      ((Element)v.get(293)).setAttribute("cod","309" );
      ((Element)v.get(276)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(294)).setAttribute("colFondo","" );
      ((Element)v.get(294)).setAttribute("ID","EstCab" );
      ((Element)v.get(294)).setAttribute("cod","302" );
      ((Element)v.get(276)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(295)).setAttribute("colFondo","" );
      ((Element)v.get(295)).setAttribute("ID","EstCab" );
      ((Element)v.get(295)).setAttribute("cod","302" );
      ((Element)v.get(276)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(296)).setAttribute("colFondo","" );
      ((Element)v.get(296)).setAttribute("ID","EstCab" );
      ((Element)v.get(296)).setAttribute("cod","1604" );
      ((Element)v.get(276)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(297)).setAttribute("colFondo","" );
      ((Element)v.get(297)).setAttribute("ID","EstCab" );
      ((Element)v.get(297)).setAttribute("cod","1664" );
      ((Element)v.get(276)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */

      /* Empieza nodo:298 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(298)).setAttribute("colFondo","" );
      ((Element)v.get(298)).setAttribute("ID","EstCab" );
      ((Element)v.get(298)).setAttribute("cod","1691" );
      ((Element)v.get(276)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(299)).setAttribute("colFondo","" );
      ((Element)v.get(299)).setAttribute("ID","EstCab" );
      ((Element)v.get(299)).setAttribute("cod","2578" );
      ((Element)v.get(276)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(300)).setAttribute("colFondo","" );
      ((Element)v.get(300)).setAttribute("ID","EstCab" );
      ((Element)v.get(300)).setAttribute("cod","1604" );
      ((Element)v.get(276)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(301)).setAttribute("colFondo","" );
      ((Element)v.get(301)).setAttribute("ID","EstCab" );
      ((Element)v.get(301)).setAttribute("cod","1664" );
      ((Element)v.get(276)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(302)).setAttribute("colFondo","" );
      ((Element)v.get(302)).setAttribute("ID","EstCab" );
      ((Element)v.get(302)).setAttribute("cod","1691" );
      ((Element)v.get(276)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:276   */

      /* Empieza nodo:303 / Elemento padre: 239   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(303)).setAttribute("alto","22" );
      ((Element)v.get(303)).setAttribute("accion","" );
      ((Element)v.get(303)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(303)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(303)).setAttribute("maxSel","-1" );
      ((Element)v.get(303)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(303)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(303)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(303)).setAttribute("onLoad","" );
      ((Element)v.get(303)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(239)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(304)).setAttribute("tipo","texto" );
      ((Element)v.get(304)).setAttribute("ID","EstDat" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("tipo","texto" );
      ((Element)v.get(305)).setAttribute("ID","EstDat2" );
      ((Element)v.get(303)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(306)).setAttribute("tipo","texto" );
      ((Element)v.get(306)).setAttribute("ID","EstDat" );
      ((Element)v.get(303)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(307)).setAttribute("tipo","texto" );
      ((Element)v.get(307)).setAttribute("ID","EstDat" );
      ((Element)v.get(303)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */

      /* Empieza nodo:308 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(308)).setAttribute("tipo","texto" );
      ((Element)v.get(308)).setAttribute("ID","EstDat2" );
      ((Element)v.get(303)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(309)).setAttribute("tipo","texto" );
      ((Element)v.get(309)).setAttribute("ID","EstDat2" );
      ((Element)v.get(303)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */

      /* Empieza nodo:310 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(310)).setAttribute("tipo","texto" );
      ((Element)v.get(310)).setAttribute("ID","EstDat" );
      ((Element)v.get(303)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(311)).setAttribute("tipo","texto" );
      ((Element)v.get(311)).setAttribute("ID","EstDat" );
      ((Element)v.get(303)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(312)).setAttribute("tipo","texto" );
      ((Element)v.get(312)).setAttribute("ID","EstDat2" );
      ((Element)v.get(303)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */

      /* Empieza nodo:313 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(313)).setAttribute("tipo","texto" );
      ((Element)v.get(313)).setAttribute("ID","EstDat" );
      ((Element)v.get(303)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */

      /* Empieza nodo:314 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(314)).setAttribute("tipo","texto" );
      ((Element)v.get(314)).setAttribute("ID","EstDat2" );
      ((Element)v.get(303)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */

      /* Empieza nodo:315 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(315)).setAttribute("tipo","texto" );
      ((Element)v.get(315)).setAttribute("ID","EstDat" );
      ((Element)v.get(303)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */

      /* Empieza nodo:316 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(316)).setAttribute("tipo","texto" );
      ((Element)v.get(316)).setAttribute("ID","EstDat2" );
      ((Element)v.get(303)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */

      /* Empieza nodo:317 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(317)).setAttribute("tipo","texto" );
      ((Element)v.get(317)).setAttribute("ID","EstDat" );
      ((Element)v.get(303)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */

      /* Empieza nodo:318 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(318)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(318)).setAttribute("nombre","txtUnidadesReclamadasSi" );
      ((Element)v.get(318)).setAttribute("size","7" );
      ((Element)v.get(318)).setAttribute("max","7" );
      ((Element)v.get(318)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(318)).setAttribute("ID","EstDat2" );
      ((Element)v.get(318)).setAttribute("onchange","onChangeUnidadesAReclamar(FILAEVENTO);" );
      ((Element)v.get(303)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */

      /* Empieza nodo:319 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(319)).setAttribute("tipo","texto" );
      ((Element)v.get(319)).setAttribute("ID","EstDat" );
      ((Element)v.get(303)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 303   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(320)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(320)).setAttribute("nombre","txtUnidadesDevueltasSi" );
      ((Element)v.get(320)).setAttribute("size","7" );
      ((Element)v.get(320)).setAttribute("max","7" );
      ((Element)v.get(320)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(320)).setAttribute("ID","EstDat2" );
      ((Element)v.get(303)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(321)).setAttribute("tipo","combo" );
      ((Element)v.get(321)).setAttribute("nombre","cbMotivoDevolucionSi" );
      ((Element)v.get(321)).setAttribute("ID","EstDat" );
      ((Element)v.get(321)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(303)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:323 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(323)).setAttribute("tipo","texto" );
      ((Element)v.get(323)).setAttribute("ID","EstDat2" );
      ((Element)v.get(303)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */

      /* Empieza nodo:324 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(324)).setAttribute("tipo","texto" );
      ((Element)v.get(324)).setAttribute("ID","EstDat" );
      ((Element)v.get(303)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */

      /* Empieza nodo:325 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(325)).setAttribute("tipo","texto" );
      ((Element)v.get(325)).setAttribute("ID","EstDat2" );
      ((Element)v.get(303)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(326)).setAttribute("tipo","texto" );
      ((Element)v.get(326)).setAttribute("ID","EstDat" );
      ((Element)v.get(303)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */

      /* Empieza nodo:327 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(327)).setAttribute("tipo","texto" );
      ((Element)v.get(327)).setAttribute("ID","EstDat2" );
      ((Element)v.get(303)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */

      /* Empieza nodo:328 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(328)).setAttribute("tipo","texto" );
      ((Element)v.get(328)).setAttribute("ID","EstDat" );
      ((Element)v.get(303)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */

      /* Empieza nodo:329 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(329)).setAttribute("tipo","texto" );
      ((Element)v.get(329)).setAttribute("ID","EstDat2" );
      ((Element)v.get(303)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */

      /* Empieza nodo:330 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(330)).setAttribute("tipo","texto" );
      ((Element)v.get(330)).setAttribute("ID","EstDat" );
      ((Element)v.get(303)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:303   */

      /* Empieza nodo:331 / Elemento padre: 239   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(239)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */

      /* Empieza nodo:332 / Elemento padre: 239   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(332)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(332)).setAttribute("ancho","631" );
      ((Element)v.get(332)).setAttribute("sep","$" );
      ((Element)v.get(332)).setAttribute("x","12" );
      ((Element)v.get(332)).setAttribute("class","botonera" );
      ((Element)v.get(332)).setAttribute("y","418" );
      ((Element)v.get(332)).setAttribute("control","|" );
      ((Element)v.get(332)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(332)).setAttribute("rowset","" );
      ((Element)v.get(332)).setAttribute("onload","" );
      ((Element)v.get(332)).setAttribute("cargainicial","N" );
      ((Element)v.get(239)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(333)).setAttribute("nombre","ret1" );
      ((Element)v.get(333)).setAttribute("x","37" );
      ((Element)v.get(333)).setAttribute("y","422" );
      ((Element)v.get(333)).setAttribute("ID","botonContenido" );
      ((Element)v.get(333)).setAttribute("img","retroceder_on" );
      ((Element)v.get(333)).setAttribute("tipo","0" );
      ((Element)v.get(333)).setAttribute("estado","false" );
      ((Element)v.get(333)).setAttribute("alt","" );
      ((Element)v.get(333)).setAttribute("codigo","" );
      ((Element)v.get(333)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */

      /* Empieza nodo:334 / Elemento padre: 332   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(334)).setAttribute("nombre","ava1" );
      ((Element)v.get(334)).setAttribute("x","52" );
      ((Element)v.get(334)).setAttribute("y","422" );
      ((Element)v.get(334)).setAttribute("ID","botonContenido" );
      ((Element)v.get(334)).setAttribute("img","avanzar_on" );
      ((Element)v.get(334)).setAttribute("tipo","0" );
      ((Element)v.get(334)).setAttribute("estado","false" );
      ((Element)v.get(334)).setAttribute("alt","" );
      ((Element)v.get(334)).setAttribute("codigo","" );
      ((Element)v.get(334)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(332)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:332   */
      /* Termina nodo:239   */

      /* Empieza nodo:335 / Elemento padre: 12   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(335)).setAttribute("nombre","aceptar" );
      ((Element)v.get(335)).setAttribute("x","13" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(335)).setAttribute("y","760" );
      ((Element)v.get(335)).setAttribute("ID","botonContenido" );
      ((Element)v.get(335)).setAttribute("ontab","setTabFocus('aceptar');" );
      ((Element)v.get(335)).setAttribute("onshtab","setShTabFocus('aceptar');" );
      ((Element)v.get(335)).setAttribute("accion","onClickAceptar();" );
      ((Element)v.get(335)).setAttribute("tipo","html" );
      ((Element)v.get(335)).setAttribute("estado","false" );
      ((Element)v.get(335)).setAttribute("cod","12" );
      ((Element)v.get(12)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */

      /* Empieza nodo:336 / Elemento padre: 12   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(336)).setAttribute("nombre","eliminar" );
      ((Element)v.get(336)).setAttribute("x","71" );
      ((Element)v.get(336)).setAttribute("y","760" );
      ((Element)v.get(336)).setAttribute("ID","botonContenido" );
      ((Element)v.get(336)).setAttribute("ontab","setTabFocus('eliminar');" );
      ((Element)v.get(336)).setAttribute("onshtab","setShTabFocus('eliminar');" );
      ((Element)v.get(336)).setAttribute("accion","onClickEliminar();" );
      ((Element)v.get(336)).setAttribute("tipo","html" );
      ((Element)v.get(336)).setAttribute("estado","false" );
      ((Element)v.get(336)).setAttribute("cod","1254" );
      ((Element)v.get(12)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */

      /* Empieza nodo:337 / Elemento padre: 12   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(337)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(337)).setAttribute("alto","12" );
      ((Element)v.get(337)).setAttribute("ancho","50" );
      ((Element)v.get(337)).setAttribute("colorf","" );
      ((Element)v.get(337)).setAttribute("borde","0" );
      ((Element)v.get(337)).setAttribute("imagenf","" );
      ((Element)v.get(337)).setAttribute("repeat","" );
      ((Element)v.get(337)).setAttribute("padding","" );
      ((Element)v.get(337)).setAttribute("visibilidad","visible" );
      ((Element)v.get(337)).setAttribute("contravsb","" );
      ((Element)v.get(337)).setAttribute("x","0" );
      ((Element)v.get(337)).setAttribute("y","782" );
      ((Element)v.get(337)).setAttribute("zindex","" );
      ((Element)v.get(12)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:12   */


   }

}

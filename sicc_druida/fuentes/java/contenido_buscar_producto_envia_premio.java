
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_buscar_producto_envia_premio  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(6)).setAttribute("src","validaciones_sicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(7)).setAttribute("src","contenido_buscar_producto_envia_premio.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","xxx" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("cod","506" );
      ((Element)v.get(9)).setAttribute("group","noValida" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtPagCat" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("cod","571" );
      ((Element)v.get(10)).setAttribute("group","CuadroBusqueda" );
      ((Element)v.get(10)).setAttribute("format","e" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:8   */

      /* Empieza nodo:11 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(11)).setAttribute("nombre","frmContenido" );
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
      ((Element)v.get(20)).setAttribute("nombre","ingresaDevuelve" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","devuelveFisicoFactura" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","devuelveFactura" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","ingresaEnvia" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","enviaFactura" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","oidNumDocumento" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","oidOperacion" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","oidTipoOperacion" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","tipoMovimiento" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","oidTipoMovimiento" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hid_SeparadorMiles" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hid_SeparadorDecimales" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hid_NumeroDecimales" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","arrayList" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","pagina" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","cerrar" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","visible" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","numeroLinea" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hOidsMotivoDevolucion" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hDescsMotivoDevolucion" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","indBuscar" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","visibilidadPGBuscarProductoEnviaContenido" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","datosListaDevuelve" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","indicadorDevuelveProcesado" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 11   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","matriz" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 11   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(46)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(46)).setAttribute("visibilidad","visible" );
      ((Element)v.get(11)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("table"));
      ((Element)v.get(47)).setAttribute("width","100%" );
      ((Element)v.get(47)).setAttribute("border","0" );
      ((Element)v.get(47)).setAttribute("cellspacing","0" );
      ((Element)v.get(47)).setAttribute("cellpadding","0" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("width","12" );
      ((Element)v.get(49)).setAttribute("align","center" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","12" );
      ((Element)v.get(50)).setAttribute("height","12" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("width","750" );
      ((Element)v.get(48)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","12" );
      ((Element)v.get(48)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","12" );
      ((Element)v.get(54)).setAttribute("height","1" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:48   */

      /* Empieza nodo:55 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(60)).setAttribute("class","legend" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(61)).setAttribute("nombre","lblCriterios" );
      ((Element)v.get(61)).setAttribute("alto","13" );
      ((Element)v.get(61)).setAttribute("filas","1" );
      ((Element)v.get(61)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(61)).setAttribute("id","legend" );
      ((Element)v.get(61)).setAttribute("cod","0075" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 59   */
      v.add(doc.createElement("table"));
      ((Element)v.get(62)).setAttribute("width","100%" );
      ((Element)v.get(62)).setAttribute("border","0" );
      ((Element)v.get(62)).setAttribute("align","center" );
      ((Element)v.get(62)).setAttribute("cellspacing","0" );
      ((Element)v.get(62)).setAttribute("cellpadding","0" );
      ((Element)v.get(59)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("table"));
      ((Element)v.get(65)).setAttribute("width","628" );
      ((Element)v.get(65)).setAttribute("border","0" );
      ((Element)v.get(65)).setAttribute("align","left" );
      ((Element)v.get(65)).setAttribute("cellspacing","0" );
      ((Element)v.get(65)).setAttribute("cellpadding","0" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("colspan","4" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:69 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(65)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(73)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(73)).setAttribute("alto","13" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(73)).setAttribute("id","datosTitle" );
      ((Element)v.get(73)).setAttribute("cod","9" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","25" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(77)).setAttribute("nombre","lblCodVenta" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("filas","1" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(77)).setAttribute("id","datosTitle" );
      ((Element)v.get(77)).setAttribute("cod","1853" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","25" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(81)).setAttribute("nombre","lblCodProducto" );
      ((Element)v.get(81)).setAttribute("alto","13" );
      ((Element)v.get(81)).setAttribute("filas","1" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(81)).setAttribute("id","datosTitle" );
      ((Element)v.get(81)).setAttribute("cod","337" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","25" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(85)).setAttribute("nombre","lblPagCat" );
      ((Element)v.get(85)).setAttribute("alto","13" );
      ((Element)v.get(85)).setAttribute("filas","1" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(85)).setAttribute("id","datosTitle" );
      ((Element)v.get(85)).setAttribute("cod","571" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("width","100%" );
      ((Element)v.get(69)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:69   */

      /* Empieza nodo:88 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(88)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("CTEXTO"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(92)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(92)).setAttribute("id","datosCampos" );
      ((Element)v.get(92)).setAttribute("max","30" );
      ((Element)v.get(92)).setAttribute("tipo","" );
      ((Element)v.get(92)).setAttribute("onchange","" );
      ((Element)v.get(92)).setAttribute("onshtab","onshtab_Descripcion();" );
      ((Element)v.get(92)).setAttribute("req","N" );
      ((Element)v.get(92)).setAttribute("size","40" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(92)).setAttribute("validacion","" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","25" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(88)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(96)).setAttribute("nombre","txtCodVenta" );
      ((Element)v.get(96)).setAttribute("id","datosCampos" );
      ((Element)v.get(96)).setAttribute("max","18" );
      ((Element)v.get(96)).setAttribute("tipo","" );
      ((Element)v.get(96)).setAttribute("onchange","mayusculas('txtCodVenta')" );
      ((Element)v.get(96)).setAttribute("req","N" );
      ((Element)v.get(96)).setAttribute("size","24" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(96)).setAttribute("validacion","" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","25" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(88)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(100)).setAttribute("nombre","txtCodProducto" );
      ((Element)v.get(100)).setAttribute("id","datosCampos" );
      ((Element)v.get(100)).setAttribute("max","20" );
      ((Element)v.get(100)).setAttribute("tipo","" );
      ((Element)v.get(100)).setAttribute("onchange","mayusculas('txtCodProducto')" );
      ((Element)v.get(100)).setAttribute("req","N" );
      ((Element)v.get(100)).setAttribute("size","20" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(100)).setAttribute("validacion","" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","25" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(88)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(104)).setAttribute("nombre","txtPagCat" );
      ((Element)v.get(104)).setAttribute("id","datosCampos" );
      ((Element)v.get(104)).setAttribute("max","3" );
      ((Element)v.get(104)).setAttribute("tipo","" );
      ((Element)v.get(104)).setAttribute("onblur","" );
      ((Element)v.get(104)).setAttribute("onchange","" );
      ((Element)v.get(104)).setAttribute("req","N" );
      ((Element)v.get(104)).setAttribute("size","3" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(104)).setAttribute("validacion","" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("width","100%" );
      ((Element)v.get(88)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:88   */

      /* Empieza nodo:107 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("colspan","4" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:110 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:55   */

      /* Empieza nodo:112 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("table"));
      ((Element)v.get(117)).setAttribute("width","100%" );
      ((Element)v.get(117)).setAttribute("border","0" );
      ((Element)v.get(117)).setAttribute("align","center" );
      ((Element)v.get(117)).setAttribute("cellspacing","0" );
      ((Element)v.get(117)).setAttribute("cellpadding","0" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("class","botonera" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(120)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(120)).setAttribute("ID","botonContenido" );
      ((Element)v.get(120)).setAttribute("tipo","html" );
      ((Element)v.get(120)).setAttribute("ontab","focalizaSiguienteBuscar();" );
      ((Element)v.get(120)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(120)).setAttribute("estado","false" );
      ((Element)v.get(120)).setAttribute("cod","1" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:121 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","12" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:112   */

      /* Empieza nodo:123 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("width","12" );
      ((Element)v.get(124)).setAttribute("align","center" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","12" );
      ((Element)v.get(125)).setAttribute("height","12" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("width","750" );
      ((Element)v.get(123)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("width","12" );
      ((Element)v.get(123)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","12" );
      ((Element)v.get(129)).setAttribute("height","1" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:123   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:130 / Elemento padre: 11   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(130)).setAttribute("nombre","lstResultado" );
      ((Element)v.get(130)).setAttribute("ancho","631" );
      ((Element)v.get(130)).setAttribute("alto","317" );
      ((Element)v.get(130)).setAttribute("x","12" );
      ((Element)v.get(130)).setAttribute("y","124" );
      ((Element)v.get(130)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(130)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(11)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(131)).setAttribute("precarga","S" );
      ((Element)v.get(131)).setAttribute("conROver","S" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(132)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(132)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(132)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(132)).setAttribute("desactivado","btnLista2D.gif" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 131   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(133)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(133)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(133)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(133)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(131)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 131   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(134)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(134)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(131)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:131   */

      /* Empieza nodo:135 / Elemento padre: 130   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(130)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(136)).setAttribute("borde","1" );
      ((Element)v.get(136)).setAttribute("horizDatos","1" );
      ((Element)v.get(136)).setAttribute("horizCabecera","1" );
      ((Element)v.get(136)).setAttribute("vertical","1" );
      ((Element)v.get(136)).setAttribute("horizTitulo","1" );
      ((Element)v.get(136)).setAttribute("horizBase","1" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 135   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(137)).setAttribute("borde","#999999" );
      ((Element)v.get(137)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(137)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(137)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(137)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(137)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(137)).setAttribute("horizBase","#999999" );
      ((Element)v.get(135)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:135   */

      /* Empieza nodo:138 / Elemento padre: 130   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(138)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(138)).setAttribute("alto","22" );
      ((Element)v.get(138)).setAttribute("imgFondo","" );
      ((Element)v.get(138)).setAttribute("cod","00135" );
      ((Element)v.get(138)).setAttribute("ID","datosTitle" );
      ((Element)v.get(130)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 130   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(139)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(139)).setAttribute("alto","22" );
      ((Element)v.get(139)).setAttribute("imgFondo","" );
      ((Element)v.get(130)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 130   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(140)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(140)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(140)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(140)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(140)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(140)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(130)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("ancho","150" );
      ((Element)v.get(141)).setAttribute("minimizable","S" );
      ((Element)v.get(141)).setAttribute("minimizada","N" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("ancho","100" );
      ((Element)v.get(142)).setAttribute("minimizable","S" );
      ((Element)v.get(142)).setAttribute("minimizada","N" );
      ((Element)v.get(140)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("ancho","100" );
      ((Element)v.get(143)).setAttribute("minimizable","S" );
      ((Element)v.get(143)).setAttribute("minimizada","N" );
      ((Element)v.get(140)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("ancho","100" );
      ((Element)v.get(144)).setAttribute("minimizable","S" );
      ((Element)v.get(144)).setAttribute("minimizada","N" );
      ((Element)v.get(144)).setAttribute("oculta","S" );
      ((Element)v.get(140)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(145)).setAttribute("ancho","100" );
      ((Element)v.get(145)).setAttribute("minimizable","S" );
      ((Element)v.get(145)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).setAttribute("oculta","S" );
      ((Element)v.get(140)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("ancho","100" );
      ((Element)v.get(146)).setAttribute("minimizable","S" );
      ((Element)v.get(146)).setAttribute("minimizada","N" );
      ((Element)v.get(146)).setAttribute("oculta","S" );
      ((Element)v.get(140)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(147)).setAttribute("ancho","100" );
      ((Element)v.get(147)).setAttribute("minimizable","S" );
      ((Element)v.get(147)).setAttribute("minimizada","N" );
      ((Element)v.get(147)).setAttribute("oculta","S" );
      ((Element)v.get(140)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(148)).setAttribute("ancho","100" );
      ((Element)v.get(148)).setAttribute("minimizable","S" );
      ((Element)v.get(148)).setAttribute("minimizada","N" );
      ((Element)v.get(140)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(149)).setAttribute("ancho","130" );
      ((Element)v.get(149)).setAttribute("minimizable","S" );
      ((Element)v.get(149)).setAttribute("minimizada","N" );
      ((Element)v.get(149)).setAttribute("oculta","S" );
      ((Element)v.get(140)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("ancho","130" );
      ((Element)v.get(150)).setAttribute("minimizable","S" );
      ((Element)v.get(150)).setAttribute("minimizada","N" );
      ((Element)v.get(140)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("ancho","130" );
      ((Element)v.get(151)).setAttribute("minimizable","S" );
      ((Element)v.get(151)).setAttribute("minimizada","N" );
      ((Element)v.get(151)).setAttribute("oculta","S" );
      ((Element)v.get(140)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("ancho","100" );
      ((Element)v.get(152)).setAttribute("minimizable","S" );
      ((Element)v.get(152)).setAttribute("minimizada","N" );
      ((Element)v.get(140)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("ancho","100" );
      ((Element)v.get(153)).setAttribute("minimizable","S" );
      ((Element)v.get(153)).setAttribute("minimizada","N" );
      ((Element)v.get(140)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("ancho","100" );
      ((Element)v.get(154)).setAttribute("minimizable","S" );
      ((Element)v.get(154)).setAttribute("minimizada","N" );
      ((Element)v.get(140)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("ancho","150" );
      ((Element)v.get(155)).setAttribute("minimizable","S" );
      ((Element)v.get(155)).setAttribute("minimizada","N" );
      ((Element)v.get(155)).setAttribute("oculta","S" );
      ((Element)v.get(140)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("ancho","110" );
      ((Element)v.get(156)).setAttribute("minimizable","S" );
      ((Element)v.get(156)).setAttribute("minimizada","N" );
      ((Element)v.get(140)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("ancho","110" );
      ((Element)v.get(157)).setAttribute("minimizable","S" );
      ((Element)v.get(157)).setAttribute("minimizada","N" );
      ((Element)v.get(140)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("ancho","110" );
      ((Element)v.get(158)).setAttribute("minimizable","S" );
      ((Element)v.get(158)).setAttribute("minimizada","N" );
      ((Element)v.get(140)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("ancho","110" );
      ((Element)v.get(159)).setAttribute("minimizable","S" );
      ((Element)v.get(159)).setAttribute("minimizada","N" );
      ((Element)v.get(140)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("ancho","130" );
      ((Element)v.get(160)).setAttribute("minimizable","S" );
      ((Element)v.get(160)).setAttribute("minimizada","N" );
      ((Element)v.get(160)).setAttribute("oculta","S" );
      ((Element)v.get(140)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("ancho","130" );
      ((Element)v.get(161)).setAttribute("minimizable","S" );
      ((Element)v.get(161)).setAttribute("minimizada","N" );
      ((Element)v.get(161)).setAttribute("oculta","S" );
      ((Element)v.get(140)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("ancho","130" );
      ((Element)v.get(162)).setAttribute("minimizable","S" );
      ((Element)v.get(162)).setAttribute("minimizada","N" );
      ((Element)v.get(162)).setAttribute("oculta","S" );
      ((Element)v.get(140)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:140   */

      /* Empieza nodo:163 / Elemento padre: 130   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(163)).setAttribute("alto","25" );
      ((Element)v.get(163)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(163)).setAttribute("imgFondo","" );
      ((Element)v.get(163)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(130)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("colFondo","" );
      ((Element)v.get(164)).setAttribute("ID","EstCab" );
      ((Element)v.get(164)).setAttribute("cod","338" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("colFondo","" );
      ((Element)v.get(165)).setAttribute("ID","EstCab" );
      ((Element)v.get(165)).setAttribute("cod","276" );
      ((Element)v.get(163)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("colFondo","" );
      ((Element)v.get(166)).setAttribute("ID","EstCab" );
      ((Element)v.get(166)).setAttribute("cod","465" );
      ((Element)v.get(163)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("colFondo","" );
      ((Element)v.get(167)).setAttribute("ID","EstCab" );
      ((Element)v.get(167)).setAttribute("cod","302" );
      ((Element)v.get(163)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("colFondo","" );
      ((Element)v.get(168)).setAttribute("ID","EstCab" );
      ((Element)v.get(168)).setAttribute("cod","302" );
      ((Element)v.get(163)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("colFondo","" );
      ((Element)v.get(169)).setAttribute("ID","EstCab" );
      ((Element)v.get(169)).setAttribute("cod","302" );
      ((Element)v.get(163)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("colFondo","" );
      ((Element)v.get(170)).setAttribute("ID","EstCab" );
      ((Element)v.get(170)).setAttribute("cod","302" );
      ((Element)v.get(163)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("colFondo","" );
      ((Element)v.get(171)).setAttribute("ID","EstCab" );
      ((Element)v.get(171)).setAttribute("cod","1853" );
      ((Element)v.get(163)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("colFondo","" );
      ((Element)v.get(172)).setAttribute("ID","EstCab" );
      ((Element)v.get(172)).setAttribute("cod","302" );
      ((Element)v.get(163)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("colFondo","" );
      ((Element)v.get(173)).setAttribute("ID","EstCab" );
      ((Element)v.get(173)).setAttribute("cod","337" );
      ((Element)v.get(163)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("colFondo","" );
      ((Element)v.get(174)).setAttribute("ID","EstCab" );
      ((Element)v.get(174)).setAttribute("cod","302" );
      ((Element)v.get(163)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("colFondo","" );
      ((Element)v.get(175)).setAttribute("ID","EstCab" );
      ((Element)v.get(175)).setAttribute("cod","530" );
      ((Element)v.get(163)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("colFondo","" );
      ((Element)v.get(176)).setAttribute("ID","EstCab" );
      ((Element)v.get(176)).setAttribute("cod","504" );
      ((Element)v.get(163)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("colFondo","" );
      ((Element)v.get(177)).setAttribute("ID","EstCab" );
      ((Element)v.get(177)).setAttribute("cod","339" );
      ((Element)v.get(163)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("colFondo","" );
      ((Element)v.get(178)).setAttribute("ID","EstCab" );
      ((Element)v.get(163)).appendChild((Element)v.get(178));

      /* Elemento padre:178 / Elemento actual: 179   */
      v.add(doc.createTextNode("Posicion"));
      ((Element)v.get(178)).appendChild((Text)v.get(179));

      /* Termina nodo Texto:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("colFondo","" );
      ((Element)v.get(180)).setAttribute("ID","EstCab" );
      ((Element)v.get(180)).setAttribute("cod","1604" );
      ((Element)v.get(163)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("colFondo","" );
      ((Element)v.get(181)).setAttribute("ID","EstCab" );
      ((Element)v.get(181)).setAttribute("cod","1664" );
      ((Element)v.get(163)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("colFondo","" );
      ((Element)v.get(182)).setAttribute("ID","EstCab" );
      ((Element)v.get(182)).setAttribute("cod","1691" );
      ((Element)v.get(163)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("colFondo","" );
      ((Element)v.get(183)).setAttribute("ID","EstCab" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(183)).setAttribute("cod","2578" );
      ((Element)v.get(163)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("colFondo","" );
      ((Element)v.get(184)).setAttribute("ID","EstCab" );
      ((Element)v.get(184)).setAttribute("cod","1604" );
      ((Element)v.get(163)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("colFondo","" );
      ((Element)v.get(185)).setAttribute("ID","EstCab" );
      ((Element)v.get(185)).setAttribute("cod","1664" );
      ((Element)v.get(163)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("colFondo","" );
      ((Element)v.get(186)).setAttribute("ID","EstCab" );
      ((Element)v.get(186)).setAttribute("cod","1691" );
      ((Element)v.get(163)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:163   */

      /* Empieza nodo:187 / Elemento padre: 130   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(187)).setAttribute("alto","22" );
      ((Element)v.get(187)).setAttribute("accion","" );
      ((Element)v.get(187)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(187)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(187)).setAttribute("maxSel","-1" );
      ((Element)v.get(187)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(187)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(187)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(187)).setAttribute("onLoad","" );
      ((Element)v.get(187)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(130)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("tipo","texto" );
      ((Element)v.get(188)).setAttribute("ID","EstDat" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("tipo","texto" );
      ((Element)v.get(189)).setAttribute("ID","EstDat2" );
      ((Element)v.get(187)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("tipo","texto" );
      ((Element)v.get(190)).setAttribute("ID","EstDat" );
      ((Element)v.get(187)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("tipo","texto" );
      ((Element)v.get(191)).setAttribute("ID","EstDat2" );
      ((Element)v.get(187)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("tipo","texto" );
      ((Element)v.get(192)).setAttribute("ID","EstDat" );
      ((Element)v.get(187)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("tipo","texto" );
      ((Element)v.get(193)).setAttribute("ID","EstDat" );
      ((Element)v.get(187)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("tipo","texto" );
      ((Element)v.get(194)).setAttribute("ID","EstDat" );
      ((Element)v.get(187)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(195)).setAttribute("tipo","texto" );
      ((Element)v.get(195)).setAttribute("ID","EstDat" );
      ((Element)v.get(187)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(196)).setAttribute("tipo","texto" );
      ((Element)v.get(196)).setAttribute("ID","EstDat" );
      ((Element)v.get(187)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(197)).setAttribute("tipo","texto" );
      ((Element)v.get(197)).setAttribute("ID","EstDat" );
      ((Element)v.get(187)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("tipo","texto" );
      ((Element)v.get(198)).setAttribute("ID","EstDat2" );
      ((Element)v.get(187)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(199)).setAttribute("tipo","texto" );
      ((Element)v.get(199)).setAttribute("ID","EstDat2" );
      ((Element)v.get(187)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(200)).setAttribute("tipo","texto" );
      ((Element)v.get(200)).setAttribute("ID","EstDat" );
      ((Element)v.get(187)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(201)).setAttribute("tipo","texto" );
      ((Element)v.get(201)).setAttribute("ID","EstDat" );
      ((Element)v.get(187)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(202)).setAttribute("tipo","texto" );
      ((Element)v.get(202)).setAttribute("ID","EstDat" );
      ((Element)v.get(187)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(203)).setAttribute("tipo","texto" );
      ((Element)v.get(203)).setAttribute("ID","EstDat2" );
      ((Element)v.get(187)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("tipo","texto" );
      ((Element)v.get(204)).setAttribute("ID","EstDat" );
      ((Element)v.get(187)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(205)).setAttribute("tipo","texto" );
      ((Element)v.get(205)).setAttribute("ID","EstDat2" );
      ((Element)v.get(187)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("tipo","texto" );
      ((Element)v.get(206)).setAttribute("ID","EstDat" );
      ((Element)v.get(187)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("tipo","texto" );
      ((Element)v.get(207)).setAttribute("ID","EstDat2" );
      ((Element)v.get(187)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("tipo","texto" );
      ((Element)v.get(208)).setAttribute("ID","EstDat" );
      ((Element)v.get(187)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(209)).setAttribute("tipo","texto" );
      ((Element)v.get(209)).setAttribute("ID","EstDat2" );
      ((Element)v.get(187)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:187   */

      /* Empieza nodo:210 / Elemento padre: 130   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(130)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 130   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(211)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(211)).setAttribute("ancho","631" );
      ((Element)v.get(211)).setAttribute("sep","$" );
      ((Element)v.get(211)).setAttribute("x","12" );
      ((Element)v.get(211)).setAttribute("class","botonera" );
      ((Element)v.get(211)).setAttribute("y","418" );
      ((Element)v.get(211)).setAttribute("control","|" );
      ((Element)v.get(211)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(211)).setAttribute("rowset","" );
      ((Element)v.get(211)).setAttribute("onload","procesarPaginado(mipgndo, msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(211)).setAttribute("cargainicial","N" );
      ((Element)v.get(130)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(212)).setAttribute("nombre","ret1" );
      ((Element)v.get(212)).setAttribute("x","37" );
      ((Element)v.get(212)).setAttribute("y","422" );
      ((Element)v.get(212)).setAttribute("ID","botonContenido" );
      ((Element)v.get(212)).setAttribute("img","retroceder_on" );
      ((Element)v.get(212)).setAttribute("tipo","0" );
      ((Element)v.get(212)).setAttribute("estado","false" );
      ((Element)v.get(212)).setAttribute("alt","" );
      ((Element)v.get(212)).setAttribute("codigo","" );
      ((Element)v.get(212)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 211   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(213)).setAttribute("nombre","ava1" );
      ((Element)v.get(213)).setAttribute("x","52" );
      ((Element)v.get(213)).setAttribute("y","422" );
      ((Element)v.get(213)).setAttribute("ID","botonContenido" );
      ((Element)v.get(213)).setAttribute("img","avanzar_on" );
      ((Element)v.get(213)).setAttribute("tipo","0" );
      ((Element)v.get(213)).setAttribute("estado","false" );
      ((Element)v.get(213)).setAttribute("alt","" );
      ((Element)v.get(213)).setAttribute("codigo","" );
      ((Element)v.get(213)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(211)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:211   */
      /* Termina nodo:130   */

      /* Empieza nodo:214 / Elemento padre: 11   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(214)).setAttribute("nombre","primera1" );
      ((Element)v.get(214)).setAttribute("x","20" );
      ((Element)v.get(214)).setAttribute("y","422" );
      ((Element)v.get(214)).setAttribute("ID","botonContenido" );
      ((Element)v.get(214)).setAttribute("img","primera_on" );
      ((Element)v.get(214)).setAttribute("tipo","-2" );
      ((Element)v.get(214)).setAttribute("estado","false" );
      ((Element)v.get(214)).setAttribute("alt","" );
      ((Element)v.get(214)).setAttribute("codigo","" );
      ((Element)v.get(214)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(11)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 11   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(215)).setAttribute("nombre","separa" );
      ((Element)v.get(215)).setAttribute("x","59" );
      ((Element)v.get(215)).setAttribute("y","418" );
      ((Element)v.get(215)).setAttribute("ID","botonContenido" );
      ((Element)v.get(215)).setAttribute("img","separa_base" );
      ((Element)v.get(215)).setAttribute("tipo","0" );
      ((Element)v.get(215)).setAttribute("estado","false" );
      ((Element)v.get(215)).setAttribute("alt","" );
      ((Element)v.get(215)).setAttribute("codigo","" );
      ((Element)v.get(215)).setAttribute("accion","" );
      ((Element)v.get(11)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 11   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(216)).setAttribute("nombre","anadir" );
      ((Element)v.get(216)).setAttribute("x","80" );
      ((Element)v.get(216)).setAttribute("y","419" );
      ((Element)v.get(216)).setAttribute("ID","botonContenido" );
      ((Element)v.get(216)).setAttribute("ontab","ontab_anyadir();" );
      ((Element)v.get(216)).setAttribute("onshtab","onshtab_anyadir();" );
      ((Element)v.get(216)).setAttribute("accion","onClickAnyadir();" );
      ((Element)v.get(216)).setAttribute("tipo","html" );
      ((Element)v.get(216)).setAttribute("estado","false" );
      ((Element)v.get(216)).setAttribute("cod","404" );
      ((Element)v.get(11)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 11   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(217)).setAttribute("nombre","lstProductos" );
      ((Element)v.get(217)).setAttribute("ancho","631" );
      ((Element)v.get(217)).setAttribute("alto","317" );
      ((Element)v.get(217)).setAttribute("x","12" );
      ((Element)v.get(217)).setAttribute("y","465" );
      ((Element)v.get(217)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(217)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(11)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(218)).setAttribute("precarga","S" );
      ((Element)v.get(218)).setAttribute("conROver","S" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(219)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(219)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(219)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(219)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 218   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(220)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(220)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(220)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(220)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(218)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 218   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(221)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(221)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(218)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:218   */

      /* Empieza nodo:222 / Elemento padre: 217   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(217)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(223)).setAttribute("borde","1" );
      ((Element)v.get(223)).setAttribute("horizDatos","1" );
      ((Element)v.get(223)).setAttribute("horizCabecera","1" );
      ((Element)v.get(223)).setAttribute("vertical","1" );
      ((Element)v.get(223)).setAttribute("horizTitulo","1" );
      ((Element)v.get(223)).setAttribute("horizBase","1" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 222   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(224)).setAttribute("borde","#999999" );
      ((Element)v.get(224)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(224)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(224)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(224)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(224)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(224)).setAttribute("horizBase","#999999" );
      ((Element)v.get(222)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:222   */

      /* Empieza nodo:225 / Elemento padre: 217   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(225)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(225)).setAttribute("alto","22" );
      ((Element)v.get(225)).setAttribute("imgFondo","" );
      ((Element)v.get(225)).setAttribute("cod","00499" );
      ((Element)v.get(225)).setAttribute("ID","datosTitle" );
      ((Element)v.get(217)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 217   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(226)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(226)).setAttribute("alto","22" );
      ((Element)v.get(226)).setAttribute("imgFondo","" );
      ((Element)v.get(217)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */

      /* Empieza nodo:227 / Elemento padre: 217   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(227)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(227)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(227)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(227)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(227)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(227)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(217)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(228)).setAttribute("ancho","150" );
      ((Element)v.get(228)).setAttribute("minimizable","S" );
      ((Element)v.get(228)).setAttribute("minimizada","N" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("ancho","100" );
      ((Element)v.get(229)).setAttribute("minimizable","S" );
      ((Element)v.get(229)).setAttribute("minimizada","N" );
      ((Element)v.get(227)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 227   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("ancho","100" );
      ((Element)v.get(230)).setAttribute("minimizable","S" );
      ((Element)v.get(230)).setAttribute("minimizada","N" );
      ((Element)v.get(227)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("ancho","100" );
      ((Element)v.get(231)).setAttribute("minimizable","S" );
      ((Element)v.get(231)).setAttribute("minimizada","N" );
      ((Element)v.get(231)).setAttribute("oculta","S" );
      ((Element)v.get(227)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(232)).setAttribute("ancho","100" );
      ((Element)v.get(232)).setAttribute("minimizable","S" );
      ((Element)v.get(232)).setAttribute("minimizada","N" );
      ((Element)v.get(232)).setAttribute("oculta","S" );
      ((Element)v.get(227)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(233)).setAttribute("ancho","100" );
      ((Element)v.get(233)).setAttribute("minimizable","S" );
      ((Element)v.get(233)).setAttribute("minimizada","N" );
      ((Element)v.get(233)).setAttribute("oculta","S" );
      ((Element)v.get(227)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */

      /* Empieza nodo:234 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(234)).setAttribute("ancho","100" );
      ((Element)v.get(234)).setAttribute("minimizable","S" );
      ((Element)v.get(234)).setAttribute("minimizada","N" );
      ((Element)v.get(234)).setAttribute("oculta","S" );
      ((Element)v.get(227)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(235)).setAttribute("ancho","100" );
      ((Element)v.get(235)).setAttribute("minimizable","S" );
      ((Element)v.get(235)).setAttribute("minimizada","N" );
      ((Element)v.get(227)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(236)).setAttribute("ancho","130" );
      ((Element)v.get(236)).setAttribute("minimizable","S" );
      ((Element)v.get(236)).setAttribute("minimizada","N" );
      ((Element)v.get(236)).setAttribute("oculta","S" );
      ((Element)v.get(227)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(237)).setAttribute("ancho","130" );
      ((Element)v.get(237)).setAttribute("minimizable","S" );
      ((Element)v.get(237)).setAttribute("minimizada","N" );
      ((Element)v.get(227)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(238)).setAttribute("ancho","130" );
      ((Element)v.get(238)).setAttribute("minimizable","S" );
      ((Element)v.get(238)).setAttribute("minimizada","N" );
      ((Element)v.get(238)).setAttribute("oculta","S" );
      ((Element)v.get(227)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(239)).setAttribute("ancho","110" );
      ((Element)v.get(239)).setAttribute("minimizable","S" );
      ((Element)v.get(239)).setAttribute("minimizada","N" );
      ((Element)v.get(227)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(240)).setAttribute("ancho","100" );
      ((Element)v.get(240)).setAttribute("minimizable","S" );
      ((Element)v.get(240)).setAttribute("minimizada","N" );
      ((Element)v.get(227)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(241)).setAttribute("ancho","100" );
      ((Element)v.get(241)).setAttribute("minimizable","S" );
      ((Element)v.get(241)).setAttribute("minimizada","N" );
      ((Element)v.get(227)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(242)).setAttribute("ancho","100" );
      ((Element)v.get(242)).setAttribute("minimizable","S" );
      ((Element)v.get(242)).setAttribute("minimizada","N" );
      ((Element)v.get(227)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(243)).setAttribute("ancho","150" );
      ((Element)v.get(243)).setAttribute("minimizable","S" );
      ((Element)v.get(243)).setAttribute("minimizada","N" );
      ((Element)v.get(243)).setAttribute("oculta","S" );
      ((Element)v.get(227)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(244)).setAttribute("ancho","110" );
      ((Element)v.get(244)).setAttribute("minimizable","S" );
      ((Element)v.get(244)).setAttribute("minimizada","N" );
      ((Element)v.get(227)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(245)).setAttribute("ancho","110" );
      ((Element)v.get(245)).setAttribute("minimizable","S" );
      ((Element)v.get(245)).setAttribute("minimizada","N" );
      ((Element)v.get(227)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */

      /* Empieza nodo:246 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(246)).setAttribute("ancho","110" );
      ((Element)v.get(246)).setAttribute("minimizable","S" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(246)).setAttribute("minimizada","N" );
      ((Element)v.get(227)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */

      /* Empieza nodo:247 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(247)).setAttribute("ancho","110" );
      ((Element)v.get(247)).setAttribute("minimizable","S" );
      ((Element)v.get(247)).setAttribute("minimizada","N" );
      ((Element)v.get(227)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(248)).setAttribute("ancho","130" );
      ((Element)v.get(248)).setAttribute("minimizable","S" );
      ((Element)v.get(248)).setAttribute("minimizada","N" );
      ((Element)v.get(248)).setAttribute("oculta","S" );
      ((Element)v.get(227)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */

      /* Empieza nodo:249 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(249)).setAttribute("ancho","130" );
      ((Element)v.get(249)).setAttribute("minimizable","S" );
      ((Element)v.get(249)).setAttribute("minimizada","N" );
      ((Element)v.get(249)).setAttribute("oculta","S" );
      ((Element)v.get(227)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 227   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(250)).setAttribute("ancho","130" );
      ((Element)v.get(250)).setAttribute("minimizable","S" );
      ((Element)v.get(250)).setAttribute("minimizada","N" );
      ((Element)v.get(250)).setAttribute("oculta","S" );
      ((Element)v.get(227)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:227   */

      /* Empieza nodo:251 / Elemento padre: 217   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(251)).setAttribute("alto","25" );
      ((Element)v.get(251)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(251)).setAttribute("imgFondo","" );
      ((Element)v.get(251)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(217)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("colFondo","" );
      ((Element)v.get(252)).setAttribute("ID","EstCab" );
      ((Element)v.get(252)).setAttribute("cod","338" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(253)).setAttribute("colFondo","" );
      ((Element)v.get(253)).setAttribute("ID","EstCab" );
      ((Element)v.get(253)).setAttribute("cod","276" );
      ((Element)v.get(251)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(254)).setAttribute("colFondo","" );
      ((Element)v.get(254)).setAttribute("ID","EstCab" );
      ((Element)v.get(254)).setAttribute("cod","465" );
      ((Element)v.get(251)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("colFondo","" );
      ((Element)v.get(255)).setAttribute("ID","EstCab" );
      ((Element)v.get(255)).setAttribute("cod","302" );
      ((Element)v.get(251)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(256)).setAttribute("colFondo","" );
      ((Element)v.get(256)).setAttribute("ID","EstCab" );
      ((Element)v.get(256)).setAttribute("cod","302" );
      ((Element)v.get(251)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("colFondo","" );
      ((Element)v.get(257)).setAttribute("ID","EstCab" );
      ((Element)v.get(257)).setAttribute("cod","302" );
      ((Element)v.get(251)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(258)).setAttribute("colFondo","" );
      ((Element)v.get(258)).setAttribute("ID","EstCab" );
      ((Element)v.get(258)).setAttribute("cod","302" );
      ((Element)v.get(251)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(259)).setAttribute("colFondo","" );
      ((Element)v.get(259)).setAttribute("ID","EstCab" );
      ((Element)v.get(259)).setAttribute("cod","1853" );
      ((Element)v.get(251)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(260)).setAttribute("colFondo","" );
      ((Element)v.get(260)).setAttribute("ID","EstCab" );
      ((Element)v.get(260)).setAttribute("cod","302" );
      ((Element)v.get(251)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(261)).setAttribute("colFondo","" );
      ((Element)v.get(261)).setAttribute("ID","EstCab" );
      ((Element)v.get(261)).setAttribute("cod","337" );
      ((Element)v.get(251)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */

      /* Empieza nodo:262 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(262)).setAttribute("colFondo","" );
      ((Element)v.get(262)).setAttribute("ID","EstCab" );
      ((Element)v.get(262)).setAttribute("cod","302" );
      ((Element)v.get(251)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(263)).setAttribute("colFondo","" );
      ((Element)v.get(263)).setAttribute("ID","EstCab" );
      ((Element)v.get(263)).setAttribute("cod","530" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(251)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */

      /* Empieza nodo:264 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(264)).setAttribute("colFondo","" );
      ((Element)v.get(264)).setAttribute("ID","EstCab" );
      ((Element)v.get(264)).setAttribute("cod","504" );
      ((Element)v.get(251)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("colFondo","" );
      ((Element)v.get(265)).setAttribute("ID","EstCab" );
      ((Element)v.get(265)).setAttribute("cod","339" );
      ((Element)v.get(251)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(266)).setAttribute("colFondo","" );
      ((Element)v.get(266)).setAttribute("ID","EstCab" );
      ((Element)v.get(266)).setAttribute("cod","506" );
      ((Element)v.get(251)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(267)).setAttribute("colFondo","" );
      ((Element)v.get(267)).setAttribute("ID","EstCab" );
      ((Element)v.get(251)).appendChild((Element)v.get(267));

      /* Elemento padre:267 / Elemento actual: 268   */
      v.add(doc.createTextNode("posi"));
      ((Element)v.get(267)).appendChild((Text)v.get(268));

      /* Termina nodo Texto:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("colFondo","" );
      ((Element)v.get(269)).setAttribute("ID","EstCab" );
      ((Element)v.get(269)).setAttribute("cod","1604" );
      ((Element)v.get(251)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("colFondo","" );
      ((Element)v.get(270)).setAttribute("ID","EstCab" );
      ((Element)v.get(270)).setAttribute("cod","1664" );
      ((Element)v.get(251)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(271)).setAttribute("colFondo","" );
      ((Element)v.get(271)).setAttribute("ID","EstCab" );
      ((Element)v.get(271)).setAttribute("cod","1691" );
      ((Element)v.get(251)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("colFondo","" );
      ((Element)v.get(272)).setAttribute("ID","EstCab" );
      ((Element)v.get(272)).setAttribute("cod","2578" );
      ((Element)v.get(251)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("colFondo","" );
      ((Element)v.get(273)).setAttribute("ID","EstCab" );
      ((Element)v.get(273)).setAttribute("cod","1604" );
      ((Element)v.get(251)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("colFondo","" );
      ((Element)v.get(274)).setAttribute("ID","EstCab" );
      ((Element)v.get(274)).setAttribute("cod","1664" );
      ((Element)v.get(251)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("colFondo","" );
      ((Element)v.get(275)).setAttribute("ID","EstCab" );
      ((Element)v.get(275)).setAttribute("cod","1691" );
      ((Element)v.get(251)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:251   */

      /* Empieza nodo:276 / Elemento padre: 217   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(276)).setAttribute("alto","22" );
      ((Element)v.get(276)).setAttribute("accion","" );
      ((Element)v.get(276)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(276)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(276)).setAttribute("maxSel","-1" );
      ((Element)v.get(276)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(276)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(276)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(276)).setAttribute("onLoad","" );
      ((Element)v.get(276)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(217)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("tipo","texto" );
      ((Element)v.get(277)).setAttribute("ID","EstDat" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("tipo","texto" );
      ((Element)v.get(278)).setAttribute("ID","EstDat2" );
      ((Element)v.get(276)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("tipo","texto" );
      ((Element)v.get(279)).setAttribute("ID","EstDat" );
      ((Element)v.get(276)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("tipo","texto" );
      ((Element)v.get(280)).setAttribute("ID","EstDat2" );
      ((Element)v.get(276)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(281)).setAttribute("tipo","texto" );
      ((Element)v.get(281)).setAttribute("ID","EstDat" );
      ((Element)v.get(276)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(282)).setAttribute("tipo","texto" );
      ((Element)v.get(282)).setAttribute("ID","EstDat" );
      ((Element)v.get(276)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(283)).setAttribute("tipo","texto" );
      ((Element)v.get(283)).setAttribute("ID","EstDat" );
      ((Element)v.get(276)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("tipo","texto" );
      ((Element)v.get(284)).setAttribute("ID","EstDat" );
      ((Element)v.get(276)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("tipo","texto" );
      ((Element)v.get(285)).setAttribute("ID","EstDat" );
      ((Element)v.get(276)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(286)).setAttribute("tipo","texto" );
      ((Element)v.get(286)).setAttribute("ID","EstDat" );
      ((Element)v.get(276)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(287)).setAttribute("tipo","texto" );
      ((Element)v.get(287)).setAttribute("ID","EstDat2" );
      ((Element)v.get(276)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(288)).setAttribute("tipo","texto" );
      ((Element)v.get(288)).setAttribute("ID","EstDat2" );
      ((Element)v.get(276)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(289)).setAttribute("tipo","texto" );
      ((Element)v.get(289)).setAttribute("ID","EstDat" );
      ((Element)v.get(276)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(290)).setAttribute("tipo","texto" );
      ((Element)v.get(290)).setAttribute("ID","EstDat" );
      ((Element)v.get(276)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(291)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(291)).setAttribute("nombre","txtNUnidR" );
      ((Element)v.get(291)).setAttribute("ID","EstDat2" );
      ((Element)v.get(291)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(291)).setAttribute("onShTab","focalizaAnteriorLista(FILAEVENTO, TECLAEVENTO)" );
      ((Element)v.get(291)).setAttribute("onTab","focalizaSiguienteLista(FILAEVENTO, TECLAEVENTO)" );
      ((Element)v.get(291)).setAttribute("onBlur","validar(FILAEVENTO);" );
      ((Element)v.get(291)).setAttribute("validacion","validaUnidades(valor, 6)" );
      ((Element)v.get(291)).setAttribute("size","8" );
      ((Element)v.get(291)).setAttribute("max","7" );
      ((Element)v.get(291)).setAttribute("req","N" );
      ((Element)v.get(276)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("tipo","texto" );
      ((Element)v.get(292)).setAttribute("ID","EstDat" );
      ((Element)v.get(276)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(293)).setAttribute("tipo","texto" );
      ((Element)v.get(293)).setAttribute("ID","EstDat2" );
      ((Element)v.get(276)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(294)).setAttribute("tipo","texto" );
      ((Element)v.get(294)).setAttribute("ID","EstDat" );
      ((Element)v.get(276)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(295)).setAttribute("tipo","texto" );
      ((Element)v.get(295)).setAttribute("ID","EstDat2" );
      ((Element)v.get(276)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(296)).setAttribute("tipo","texto" );
      ((Element)v.get(296)).setAttribute("ID","EstDat" );
      ((Element)v.get(276)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(297)).setAttribute("tipo","texto" );
      ((Element)v.get(297)).setAttribute("ID","EstDat2" );
      ((Element)v.get(276)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */

      /* Empieza nodo:298 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(298)).setAttribute("tipo","texto" );
      ((Element)v.get(298)).setAttribute("ID","EstDat" );
      ((Element)v.get(276)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(299)).setAttribute("tipo","texto" );
      ((Element)v.get(299)).setAttribute("ID","EstDat2" );
      ((Element)v.get(276)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:276   */

      /* Empieza nodo:300 / Elemento padre: 217   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(217)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:217   */

      /* Empieza nodo:301 / Elemento padre: 11   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(301)).setAttribute("nombre","aceptar" );
      ((Element)v.get(301)).setAttribute("x","13" );
      ((Element)v.get(301)).setAttribute("y","760" );
      ((Element)v.get(301)).setAttribute("ID","botonContenido" );
      ((Element)v.get(301)).setAttribute("onshtab","onshtab_aceptar();" );
      ((Element)v.get(301)).setAttribute("accion","onClickAceptar();" );
      ((Element)v.get(301)).setAttribute("tipo","html" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(301)).setAttribute("estado","false" );
      ((Element)v.get(301)).setAttribute("cod","12" );
      ((Element)v.get(11)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 11   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(302)).setAttribute("nombre","eliminar" );
      ((Element)v.get(302)).setAttribute("x","71" );
      ((Element)v.get(302)).setAttribute("y","760" );
      ((Element)v.get(302)).setAttribute("ID","botonContenido" );
      ((Element)v.get(302)).setAttribute("ontab","ontab_eliminar();" );
      ((Element)v.get(302)).setAttribute("accion","onClickEliminar();" );
      ((Element)v.get(302)).setAttribute("tipo","html" );
      ((Element)v.get(302)).setAttribute("estado","false" );
      ((Element)v.get(302)).setAttribute("cod","1254" );
      ((Element)v.get(11)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 11   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(303)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(303)).setAttribute("alto","12" );
      ((Element)v.get(303)).setAttribute("ancho","50" );
      ((Element)v.get(303)).setAttribute("colorf","" );
      ((Element)v.get(303)).setAttribute("borde","0" );
      ((Element)v.get(303)).setAttribute("imagenf","" );
      ((Element)v.get(303)).setAttribute("repeat","" );
      ((Element)v.get(303)).setAttribute("padding","" );
      ((Element)v.get(303)).setAttribute("visibilidad","visible" );
      ((Element)v.get(303)).setAttribute("contravsb","" );
      ((Element)v.get(303)).setAttribute("x","0" );
      ((Element)v.get(303)).setAttribute("y","782" );
      ((Element)v.get(303)).setAttribute("zindex","" );
      ((Element)v.get(11)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:11   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_matriz_codigos_alternativos_eliminar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_matriz_codigos_alternativos_eliminar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_matriz_codigos_alternativos_eliminar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","accion" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","LPBuscarMatrizCodigosAlternativos" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","hidDatosReemp" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","oidCabecera" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","hPais" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","elementosSeleccionados" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","UltimaLP" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","descripcionProducto" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","codigoVenta" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","gEmiteMen" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","gNrOrden" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","oidMatrizCodigoAlternativo" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","oidMatrizFacturacion" );
      ((Element)v.get(22)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(5)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 5   */
      v.add(doc.createElement("table"));
      ((Element)v.get(23)).setAttribute("width","100%" );
      ((Element)v.get(23)).setAttribute("border","0" );
      ((Element)v.get(23)).setAttribute("cellspacing","0" );
      ((Element)v.get(23)).setAttribute("cellpadding","0" );
      ((Element)v.get(5)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("align","center" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(26)).setAttribute("height","12" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","750" );
      ((Element)v.get(24)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).setAttribute("width","12" );
      ((Element)v.get(24)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).setAttribute("width","12" );
      ((Element)v.get(30)).setAttribute("height","1" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */
      /* Termina nodo:24   */

      /* Empieza nodo:31 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(36)).setAttribute("class","legend" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(37)).setAttribute("nombre","lblProductoPrincipal" );
      ((Element)v.get(37)).setAttribute("alto","13" );
      ((Element)v.get(37)).setAttribute("filas","1" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(37)).setAttribute("id","legend" );
      ((Element)v.get(37)).setAttribute("cod","0014" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("table"));
      ((Element)v.get(38)).setAttribute("width","100%" );
      ((Element)v.get(38)).setAttribute("border","0" );
      ((Element)v.get(38)).setAttribute("align","center" );
      ((Element)v.get(38)).setAttribute("cellspacing","0" );
      ((Element)v.get(38)).setAttribute("cellpadding","0" );
      ((Element)v.get(35)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("table"));
      ((Element)v.get(41)).setAttribute("width","500" );
      ((Element)v.get(41)).setAttribute("border","0" );
      ((Element)v.get(41)).setAttribute("align","left" );
      ((Element)v.get(41)).setAttribute("cellspacing","0" );
      ((Element)v.get(41)).setAttribute("cellpadding","0" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).setAttribute("colspan","4" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","8" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:45 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","8" );
      ((Element)v.get(47)).setAttribute("height","8" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(49)).setAttribute("nombre","lblCodigoVenta" );
      ((Element)v.get(49)).setAttribute("alto","13" );
      ((Element)v.get(49)).setAttribute("filas","1" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(49)).setAttribute("id","datosTitle" );
      ((Element)v.get(49)).setAttribute("cod","336" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","25" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(53)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(53)).setAttribute("alto","13" );
      ((Element)v.get(53)).setAttribute("filas","1" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(53)).setAttribute("id","datosTitle" );
      ((Element)v.get(53)).setAttribute("cod","9" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("width","100%" );
      ((Element)v.get(45)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","8" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:45   */

      /* Empieza nodo:56 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(60)).setAttribute("nombre","lblCodigoVentaXX" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("id","datosCampos" );
      ((Element)v.get(60)).setAttribute("codigo","" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","25" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(64)).setAttribute("nombre","lblDescripcionXX" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(64)).setAttribute("id","datosCampos" );
      ((Element)v.get(64)).setAttribute("codigo","" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","100%" );
      ((Element)v.get(56)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","8" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:56   */

      /* Empieza nodo:67 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("colspan","4" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","8" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:70 / Elemento padre: 31   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:31   */

      /* Empieza nodo:72 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("table"));
      ((Element)v.get(77)).setAttribute("width","100%" );
      ((Element)v.get(77)).setAttribute("border","0" );
      ((Element)v.get(77)).setAttribute("align","center" );
      ((Element)v.get(77)).setAttribute("cellspacing","0" );
      ((Element)v.get(77)).setAttribute("cellpadding","0" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("class","botonera" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(80)).setAttribute("nombre","btnBuscarProductoPrincipal" );
      ((Element)v.get(80)).setAttribute("ID","botonContenido" );
      ((Element)v.get(80)).setAttribute("tipo","html" );
      ((Element)v.get(80)).setAttribute("accion","cargarAccion('buscarProductoPrincipal');" );
      ((Element)v.get(80)).setAttribute("estado","false" );
      ((Element)v.get(80)).setAttribute("cod","431" );
      ((Element)v.get(80)).setAttribute("ontab","focalizaTab(1);" );
      ((Element)v.get(80)).setAttribute("onshtab","focalizaTabShift(1);" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 79   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(81)).setAttribute("nombre","btnBuscarProductoAlternativo" );
      ((Element)v.get(81)).setAttribute("ID","botonContenido" );
      ((Element)v.get(81)).setAttribute("tipo","html" );
      ((Element)v.get(81)).setAttribute("accion","cargarAccion('buscarProductoAlternativo');" );
      ((Element)v.get(81)).setAttribute("estado","false" );
      ((Element)v.get(81)).setAttribute("cod","432" );
      ((Element)v.get(81)).setAttribute("ontab","focalizaTab(2);" );
      ((Element)v.get(81)).setAttribute("onshtab","focalizaTabShift(2);" );
      ((Element)v.get(79)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:82 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","8" );
      ((Element)v.get(83)).setAttribute("height","12" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:72   */

      /* Empieza nodo:84 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(84));

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
      ((Element)v.get(87)).setAttribute("width","756" );
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
      /* Termina nodo:23   */

      /* Empieza nodo:91 / Elemento padre: 5   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(91)).setAttribute("nombre","listado1" );
      ((Element)v.get(91)).setAttribute("ancho","503" );
      ((Element)v.get(91)).setAttribute("alto","317" );
      ((Element)v.get(91)).setAttribute("x","12" );
      ((Element)v.get(91)).setAttribute("y","117" );
      ((Element)v.get(91)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(91)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(5)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMGBOTONES"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(92)).setAttribute("precarga","S" );
      ((Element)v.get(92)).setAttribute("conROver","S" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(93)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(93)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(93)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(93)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 92   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(94)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(94)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(94)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(94)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(92)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 92   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(95)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(95)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(92)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:92   */

      /* Empieza nodo:96 / Elemento padre: 91   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(91)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(97)).setAttribute("borde","1" );
      ((Element)v.get(97)).setAttribute("horizDatos","1" );
      ((Element)v.get(97)).setAttribute("horizCabecera","1" );
      ((Element)v.get(97)).setAttribute("vertical","1" );
      ((Element)v.get(97)).setAttribute("horizTitulo","1" );
      ((Element)v.get(97)).setAttribute("horizBase","1" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 96   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(98)).setAttribute("borde","#999999" );
      ((Element)v.get(98)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(98)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(98)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(98)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(98)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(98)).setAttribute("horizBase","#999999" );
      ((Element)v.get(96)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:96   */

      /* Empieza nodo:99 / Elemento padre: 91   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(99)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(99)).setAttribute("alto","22" );
      ((Element)v.get(99)).setAttribute("imgFondo","" );
      ((Element)v.get(99)).setAttribute("cod","430" );
      ((Element)v.get(99)).setAttribute("ID","datosTitle" );
      ((Element)v.get(91)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 91   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(100)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(100)).setAttribute("alto","22" );
      ((Element)v.get(100)).setAttribute("imgFondo","" );
      ((Element)v.get(91)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 91   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(101)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(101)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(101)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(101)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(101)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(101)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(91)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(102)).setAttribute("ancho","180" );
      ((Element)v.get(102)).setAttribute("minimizable","S" );
      ((Element)v.get(102)).setAttribute("minimizada","N" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("ancho","180" );
      ((Element)v.get(103)).setAttribute("minimizable","S" );
      ((Element)v.get(103)).setAttribute("minimizada","N" );
      ((Element)v.get(101)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("ancho","190" );
      ((Element)v.get(104)).setAttribute("minimizable","S" );
      ((Element)v.get(104)).setAttribute("minimizada","N" );
      ((Element)v.get(101)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("ancho","190" );
      ((Element)v.get(105)).setAttribute("minimizable","S" );
      ((Element)v.get(105)).setAttribute("minimizada","N" );
      ((Element)v.get(101)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("ancho","80" );
      ((Element)v.get(106)).setAttribute("minimizable","S" );
      ((Element)v.get(106)).setAttribute("minimizada","N" );
      ((Element)v.get(106)).setAttribute("orden","numerico" );
      ((Element)v.get(101)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 101   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("ancho","90" );
      ((Element)v.get(107)).setAttribute("minimizable","S" );
      ((Element)v.get(107)).setAttribute("minimizada","N" );
      ((Element)v.get(101)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:101   */

      /* Empieza nodo:108 / Elemento padre: 91   */
      v.add(doc.createElement("CABECERA"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(108)).setAttribute("alto","20" );
      ((Element)v.get(108)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(108)).setAttribute("imgFondo","" );
      ((Element)v.get(108)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(91)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("colFondo","" );
      ((Element)v.get(109)).setAttribute("ID","EstCab" );
      ((Element)v.get(109)).setAttribute("align","center" );
      ((Element)v.get(109)).setAttribute("cod","435" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Elemento padre:109 / Elemento actual: 110   */
      v.add(doc.createTextNode("C�d. venta producto"));
      ((Element)v.get(109)).appendChild((Text)v.get(110));

      /* Termina nodo Texto:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("colFondo","" );
      ((Element)v.get(111)).setAttribute("ID","EstCab" );
      ((Element)v.get(111)).setAttribute("cod","436" );
      ((Element)v.get(108)).appendChild((Element)v.get(111));

      /* Elemento padre:111 / Elemento actual: 112   */
      v.add(doc.createTextNode("Descripci�n producto"));
      ((Element)v.get(111)).appendChild((Text)v.get(112));

      /* Termina nodo Texto:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("colFondo","" );
      ((Element)v.get(113)).setAttribute("ID","EstCab" );
      ((Element)v.get(113)).setAttribute("cod","437" );
      ((Element)v.get(108)).appendChild((Element)v.get(113));

      /* Elemento padre:113 / Elemento actual: 114   */
      v.add(doc.createTextNode("C�d. venta producto alternativo"));
      ((Element)v.get(113)).appendChild((Text)v.get(114));

      /* Termina nodo Texto:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("colFondo","" );
      ((Element)v.get(115)).setAttribute("ID","EstCab" );
      ((Element)v.get(115)).setAttribute("cod","438" );
      ((Element)v.get(108)).appendChild((Element)v.get(115));

      /* Elemento padre:115 / Elemento actual: 116   */
      v.add(doc.createTextNode("Descripci�n"));
      ((Element)v.get(115)).appendChild((Text)v.get(116));

      /* Termina nodo Texto:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("colFondo","" );
      ((Element)v.get(117)).setAttribute("ID","EstCab" );
      ((Element)v.get(117)).setAttribute("cod","486" );
      ((Element)v.get(108)).appendChild((Element)v.get(117));

      /* Elemento padre:117 / Elemento actual: 118   */
      v.add(doc.createTextNode("N� orden"));
      ((Element)v.get(117)).appendChild((Text)v.get(118));

      /* Termina nodo Texto:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("colFondo","" );
      ((Element)v.get(119)).setAttribute("ID","EstCab" );
      ((Element)v.get(119)).setAttribute("cod","531" );
      ((Element)v.get(108)).appendChild((Element)v.get(119));

      /* Elemento padre:119 / Elemento actual: 120   */
      v.add(doc.createTextNode("Mensaje"));
      ((Element)v.get(119)).appendChild((Text)v.get(120));

      /* Termina nodo Texto:120   */
      /* Termina nodo:119   */
      /* Termina nodo:108   */

      /* Empieza nodo:121 / Elemento padre: 91   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(121)).setAttribute("alto","22" );
      ((Element)v.get(121)).setAttribute("accion","" );
      ((Element)v.get(121)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(121)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(121)).setAttribute("maxSel","-1" );
      ((Element)v.get(121)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(121)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(121)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(121)).setAttribute("onLoad","" );
      ((Element)v.get(121)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(91)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("tipo","texto" );
      ((Element)v.get(122)).setAttribute("ID","EstDat" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("tipo","texto" );
      ((Element)v.get(123)).setAttribute("ID","EstDat2" );
      ((Element)v.get(121)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("tipo","texto" );
      ((Element)v.get(124)).setAttribute("ID","EstDat" );
      ((Element)v.get(121)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("tipo","texto" );
      ((Element)v.get(125)).setAttribute("ID","EstDat2" );
      ((Element)v.get(121)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("tipo","texto" );
      ((Element)v.get(126)).setAttribute("ID","EstDat" );
      ((Element)v.get(121)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("tipo","texto" );
      ((Element)v.get(127)).setAttribute("ID","EstDat2" );
      ((Element)v.get(121)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:121   */

      /* Empieza nodo:128 / Elemento padre: 91   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(91)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(129)).setAttribute("ID","3" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(130)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(130)).setAttribute("TIPO","STRING" );
      ((Element)v.get(130)).setAttribute("VALOR","COD2" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(131)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(131)).setAttribute("TIPO","STRING" );
      ((Element)v.get(131)).setAttribute("VALOR","" );
      ((Element)v.get(129)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(132)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(132)).setAttribute("TIPO","STRING" );
      ((Element)v.get(132)).setAttribute("VALOR","" );
      ((Element)v.get(129)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(133)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(133)).setAttribute("TIPO","STRING" );
      ((Element)v.get(133)).setAttribute("VALOR","" );
      ((Element)v.get(129)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(134)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(134)).setAttribute("TIPO","STRING" );
      ((Element)v.get(134)).setAttribute("VALOR","" );
      ((Element)v.get(129)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(135)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(135)).setAttribute("TIPO","STRING" );
      ((Element)v.get(135)).setAttribute("VALOR","" );
      ((Element)v.get(129)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(136)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(136)).setAttribute("TIPO","STRING" );
      ((Element)v.get(136)).setAttribute("VALOR","" );
      ((Element)v.get(129)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(137)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(137)).setAttribute("TIPO","STRING" );
      ((Element)v.get(137)).setAttribute("VALOR","" );
      ((Element)v.get(129)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(138)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(138)).setAttribute("TIPO","STRING" );
      ((Element)v.get(138)).setAttribute("VALOR","" );
      ((Element)v.get(129)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(139)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(139)).setAttribute("TIPO","STRING" );
      ((Element)v.get(139)).setAttribute("VALOR","" );
      ((Element)v.get(129)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(140)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(140)).setAttribute("TIPO","STRING" );
      ((Element)v.get(140)).setAttribute("VALOR","" );
      ((Element)v.get(129)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(141)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(141)).setAttribute("TIPO","STRING" );
      ((Element)v.get(141)).setAttribute("VALOR","" );
      ((Element)v.get(129)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(142)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(142)).setAttribute("TIPO","STRING" );
      ((Element)v.get(142)).setAttribute("VALOR","" );
      ((Element)v.get(129)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(143)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(143)).setAttribute("TIPO","STRING" );
      ((Element)v.get(143)).setAttribute("VALOR","" );
      ((Element)v.get(129)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(144)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(144)).setAttribute("TIPO","STRING" );
      ((Element)v.get(144)).setAttribute("VALOR","" );
      ((Element)v.get(129)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(145)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(145)).setAttribute("TIPO","STRING" );
      ((Element)v.get(145)).setAttribute("VALOR","" );
      ((Element)v.get(129)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(146)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(146)).setAttribute("TIPO","STRING" );
      ((Element)v.get(146)).setAttribute("VALOR","" );
      ((Element)v.get(129)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(147)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(147)).setAttribute("TIPO","STRING" );
      ((Element)v.get(147)).setAttribute("VALOR","" );
      ((Element)v.get(129)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(148)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(148)).setAttribute("TIPO","STRING" );
      ((Element)v.get(148)).setAttribute("VALOR","" );
      ((Element)v.get(129)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:149 / Elemento padre: 91   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(149)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(149)).setAttribute("ancho","503" );
      ((Element)v.get(149)).setAttribute("sep","$" );
      ((Element)v.get(149)).setAttribute("x","12" );
      ((Element)v.get(149)).setAttribute("class","botonera" );
      ((Element)v.get(149)).setAttribute("y","411" );
      ((Element)v.get(149)).setAttribute("control","" );
      ((Element)v.get(149)).setAttribute("conector","" );
      ((Element)v.get(149)).setAttribute("rowset","" );
      ((Element)v.get(149)).setAttribute("cargainicial","N" );
      ((Element)v.get(149)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'mostrarLista(ultima, rowset)')" );
      ((Element)v.get(91)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(150)).setAttribute("nombre","ret1" );
      ((Element)v.get(150)).setAttribute("x","37" );
      ((Element)v.get(150)).setAttribute("y","415" );
      ((Element)v.get(150)).setAttribute("ID","botonContenido" );
      ((Element)v.get(150)).setAttribute("img","retroceder_on" );
      ((Element)v.get(150)).setAttribute("tipo","0" );
      ((Element)v.get(150)).setAttribute("estado","false" );
      ((Element)v.get(150)).setAttribute("alt","" );
      ((Element)v.get(150)).setAttribute("codigo","" );
      ((Element)v.get(150)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 149   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(151)).setAttribute("nombre","ava1" );
      ((Element)v.get(151)).setAttribute("x","52" );
      ((Element)v.get(151)).setAttribute("y","415" );
      ((Element)v.get(151)).setAttribute("ID","botonContenido" );
      ((Element)v.get(151)).setAttribute("img","avanzar_on" );
      ((Element)v.get(151)).setAttribute("tipo","0" );
      ((Element)v.get(151)).setAttribute("estado","false" );
      ((Element)v.get(151)).setAttribute("alt","" );
      ((Element)v.get(151)).setAttribute("codigo","" );
      ((Element)v.get(151)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(149)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:149   */
      /* Termina nodo:91   */

      /* Empieza nodo:152 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(152)).setAttribute("nombre","primera1" );
      ((Element)v.get(152)).setAttribute("x","20" );
      ((Element)v.get(152)).setAttribute("y","415" );
      ((Element)v.get(152)).setAttribute("ID","botonContenido" );
      ((Element)v.get(152)).setAttribute("img","primera_on" );
      ((Element)v.get(152)).setAttribute("tipo","-2" );
      ((Element)v.get(152)).setAttribute("estado","false" );
      ((Element)v.get(152)).setAttribute("alt","" );
      ((Element)v.get(152)).setAttribute("codigo","" );
      ((Element)v.get(152)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(5)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(153)).setAttribute("nombre","separa" );
      ((Element)v.get(153)).setAttribute("x","59" );
      ((Element)v.get(153)).setAttribute("y","411" );
      ((Element)v.get(153)).setAttribute("ID","botonContenido" );
      ((Element)v.get(153)).setAttribute("img","separa_base" );
      ((Element)v.get(153)).setAttribute("tipo","0" );
      ((Element)v.get(153)).setAttribute("estado","false" );
      ((Element)v.get(153)).setAttribute("alt","" );
      ((Element)v.get(153)).setAttribute("codigo","" );
      ((Element)v.get(153)).setAttribute("accion","" );
      ((Element)v.get(5)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(154)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(154)).setAttribute("alto","12" );
      ((Element)v.get(154)).setAttribute("ancho","50" );
      ((Element)v.get(154)).setAttribute("x","0" );
      ((Element)v.get(154)).setAttribute("y","679" );
      ((Element)v.get(5)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:5   */


   }

}

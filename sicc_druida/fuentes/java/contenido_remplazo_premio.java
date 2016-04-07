
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_remplazo_premio  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_remplazo_premio" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
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
      ((Element)v.get(4)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","contenido_reemplazo_premio.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","validaciones_sicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtCodProducto" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","337" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtNumUnidades4" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","495" );
      ((Element)v.get(9)).setAttribute("format","n" );
      ((Element)v.get(9)).setAttribute("min","0" );
      ((Element)v.get(9)).setAttribute("max","99.99" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtPrecioPublico4" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","1854" );
      ((Element)v.get(10)).setAttribute("format","n" );
      ((Element)v.get(10)).setAttribute("min","0" );
      ((Element)v.get(10)).setAttribute("max","99.99" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbCriterioReemplazo" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","3425" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtNumMeses" );
      ((Element)v.get(12)).setAttribute("cod","3186" );
      ((Element)v.get(12)).setAttribute("format","e" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","txtValorCriterio" );
      ((Element)v.get(13)).setAttribute("cod","3415" );
      ((Element)v.get(13)).setAttribute("format","e" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:7   */

      /* Empieza nodo:14 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(14)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","accion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(20)).setAttribute("nombre","oidProducto" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","oidSituacionRegistro" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","oidConcurso" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","OidSolicitud" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","OidCliente" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","numero_premio" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","pais" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","idioma" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","desProducto" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","codigo" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","Npremio" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","descripcionProducto" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","ChkIndCenServG" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","oidCenServGar" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","CenServGar" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","NumMeses" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","areaObservaciones" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","PrecioPublico4" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","ArticuloDespacha4" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","TipoEntrega" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","oidCenServEntrega" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","CenServEntrega" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","Comunicacion" );
      ((Element)v.get(42)).setAttribute("valor","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(14)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","AlcanceGeografico" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","AlcanceGeografico2" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","oidRegion" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","Region" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","oidZona" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","Zona" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","codVentaFicticio" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","oidCriterioReemplazo" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","CriterioReemplazo" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","indicadorActivo" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","codigoSegundo" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","numeroOreden" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","oidArticuloLote" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(56)).setAttribute("nombre","capa1" );
      ((Element)v.get(14)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("table"));
      ((Element)v.get(57)).setAttribute("width","100%" );
      ((Element)v.get(57)).setAttribute("border","0" );
      ((Element)v.get(57)).setAttribute("cellspacing","0" );
      ((Element)v.get(57)).setAttribute("cellpadding","0" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("width","12" );
      ((Element)v.get(59)).setAttribute("align","center" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","12" );
      ((Element)v.get(60)).setAttribute("height","12" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","12" );
      ((Element)v.get(58)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","12" );
      ((Element)v.get(58)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","12" );
      ((Element)v.get(64)).setAttribute("height","1" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:58   */

      /* Empieza nodo:65 / Elemento padre: 57   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(57)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(70)).setAttribute("class","legend" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(71)).setAttribute("nombre","lblReemplazoDePremio" );
      ((Element)v.get(71)).setAttribute("alto","13" );
      ((Element)v.get(71)).setAttribute("filas","1" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(71)).setAttribute("cod","3419" );
      ((Element)v.get(71)).setAttribute("id","legend" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 69   */
      v.add(doc.createElement("table"));
      ((Element)v.get(72)).setAttribute("width","100%" );
      ((Element)v.get(72)).setAttribute("border","0" );
      ((Element)v.get(72)).setAttribute("align","center" );
      ((Element)v.get(72)).setAttribute("cellspacing","0" );
      ((Element)v.get(72)).setAttribute("cellpadding","0" );
      ((Element)v.get(69)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("table"));
      ((Element)v.get(75)).setAttribute("width","600" );
      ((Element)v.get(75)).setAttribute("border","0" );
      ((Element)v.get(75)).setAttribute("align","left" );
      ((Element)v.get(75)).setAttribute("cellspacing","0" );
      ((Element)v.get(75)).setAttribute("cellpadding","0" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","12" );
      ((Element)v.get(77)).setAttribute("align","center" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","8" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("width","100%" );
      ((Element)v.get(76)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","8" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","12" );
      ((Element)v.get(76)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","12" );
      ((Element)v.get(82)).setAttribute("height","1" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:76   */

      /* Empieza nodo:83 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(88)).setAttribute("class","legend" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(89)).setAttribute("nombre","lblProductoReeplazado" );
      ((Element)v.get(89)).setAttribute("alto","13" );
      ((Element)v.get(89)).setAttribute("filas","1" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(89)).setAttribute("id","legend" );
      ((Element)v.get(89)).setAttribute("cod","3411" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 87   */
      v.add(doc.createElement("table"));
      ((Element)v.get(90)).setAttribute("width","100%" );
      ((Element)v.get(90)).setAttribute("border","0" );
      ((Element)v.get(90)).setAttribute("align","center" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(90)).setAttribute("cellspacing","0" );
      ((Element)v.get(90)).setAttribute("cellpadding","0" );
      ((Element)v.get(87)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("table"));
      ((Element)v.get(93)).setAttribute("width","576" );
      ((Element)v.get(93)).setAttribute("border","0" );
      ((Element)v.get(93)).setAttribute("align","left" );
      ((Element)v.get(93)).setAttribute("cellspacing","0" );
      ((Element)v.get(93)).setAttribute("cellpadding","0" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("colspan","9" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:97 / Elemento padre: 93   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(93)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","8" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(101)).setAttribute("nombre","lblNumPremio" );
      ((Element)v.get(101)).setAttribute("alto","13" );
      ((Element)v.get(101)).setAttribute("filas","1" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(101)).setAttribute("id","datosTitle" );
      ((Element)v.get(101)).setAttribute("cod","3418" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","25" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(105)).setAttribute("nombre","lblCodigo" );
      ((Element)v.get(105)).setAttribute("alto","13" );
      ((Element)v.get(105)).setAttribute("filas","1" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(105)).setAttribute("id","datosTitle" );
      ((Element)v.get(105)).setAttribute("cod","BelMedioPago.codMediPago.label" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","25" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(109)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(109)).setAttribute("alto","13" );
      ((Element)v.get(109)).setAttribute("filas","1" );
      ((Element)v.get(109)).setAttribute("valor","" );
      ((Element)v.get(109)).setAttribute("id","datosTitle" );
      ((Element)v.get(109)).setAttribute("cod","BelMedioPago.Descripcion.label" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("width","100%" );
      ((Element)v.get(97)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","8" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:97   */

      /* Empieza nodo:112 / Elemento padre: 93   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(93)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("valign","bottom" );
      ((Element)v.get(112)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(116)).setAttribute("nombre","lbNumPremio1" );
      ((Element)v.get(116)).setAttribute("alto","13" );
      ((Element)v.get(116)).setAttribute("filas","1" );
      ((Element)v.get(116)).setAttribute("valor","" );
      ((Element)v.get(116)).setAttribute("id","datosCampos" );
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
      ((Element)v.get(119)).setAttribute("valign","bottom" );
      ((Element)v.get(112)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(120)).setAttribute("nombre","lbCodigo2" );
      ((Element)v.get(120)).setAttribute("alto","13" );
      ((Element)v.get(120)).setAttribute("filas","1" );
      ((Element)v.get(120)).setAttribute("valor","" );
      ((Element)v.get(120)).setAttribute("id","datosCampos" );
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
      ((Element)v.get(123)).setAttribute("valign","bottom" );
      ((Element)v.get(112)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(124)).setAttribute("nombre","lbDescripcion2" );
      ((Element)v.get(124)).setAttribute("alto","13" );
      ((Element)v.get(124)).setAttribute("filas","1" );
      ((Element)v.get(124)).setAttribute("valor","" );
      ((Element)v.get(124)).setAttribute("id","datosCampos" );
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

      /* Empieza nodo:127 / Elemento padre: 93   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(93)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("colspan","4" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","8" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:83   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:130 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
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
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("width","12" );
      ((Element)v.get(134)).setAttribute("align","center" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("width","100%" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(133)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","8" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("width","12" );
      ((Element)v.get(133)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","12" );
      ((Element)v.get(139)).setAttribute("height","1" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:133   */

      /* Empieza nodo:140 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(145)).setAttribute("class","legend" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(146)).setAttribute("nombre","lblDatosDelProductoReemplazado" );
      ((Element)v.get(146)).setAttribute("alto","13" );
      ((Element)v.get(146)).setAttribute("filas","1" );
      ((Element)v.get(146)).setAttribute("valor","" );
      ((Element)v.get(146)).setAttribute("id","legend" );
      ((Element)v.get(146)).setAttribute("cod","3420" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 144   */
      v.add(doc.createElement("table"));
      ((Element)v.get(147)).setAttribute("width","100%" );
      ((Element)v.get(147)).setAttribute("border","0" );
      ((Element)v.get(147)).setAttribute("align","center" );
      ((Element)v.get(147)).setAttribute("cellspacing","0" );
      ((Element)v.get(147)).setAttribute("cellpadding","0" );
      ((Element)v.get(144)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("table"));
      ((Element)v.get(150)).setAttribute("width","673" );
      ((Element)v.get(150)).setAttribute("border","0" );
      ((Element)v.get(150)).setAttribute("align","left" );
      ((Element)v.get(150)).setAttribute("cellspacing","0" );
      ((Element)v.get(150)).setAttribute("cellpadding","0" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("colspan","11" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","8" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:154 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(158)).setAttribute("nombre","lblCodProducto4" );
      ((Element)v.get(158)).setAttribute("alto","13" );
      ((Element)v.get(158)).setAttribute("filas","1" );
      ((Element)v.get(158)).setAttribute("valor","" );
      ((Element)v.get(158)).setAttribute("id","datosTitle" );
      ((Element)v.get(158)).setAttribute("cod","337" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).setAttribute("width","100%" );
      ((Element)v.get(154)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","8" );
      ((Element)v.get(160)).setAttribute("height","8" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","8" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(164)).setAttribute("nombre","lblIndCenServGar" );
      ((Element)v.get(164)).setAttribute("alto","25" );
      ((Element)v.get(164)).setAttribute("ancho","105" );
      ((Element)v.get(164)).setAttribute("filas","1" );
      ((Element)v.get(164)).setAttribute("valor","" );
      ((Element)v.get(164)).setAttribute("id","datosTitle" );
      ((Element)v.get(164)).setAttribute("cod","3184" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","25" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(168)).setAttribute("nombre","lblCenServGar" );
      ((Element)v.get(168)).setAttribute("alto","25" );
      ((Element)v.get(168)).setAttribute("ancho","100" );
      ((Element)v.get(168)).setAttribute("filas","1" );
      ((Element)v.get(168)).setAttribute("valor","" );
      ((Element)v.get(168)).setAttribute("id","datosTitle" );
      ((Element)v.get(168)).setAttribute("cod","3185" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).setAttribute("width","100%" );
      ((Element)v.get(154)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","8" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(172)).setAttribute("nombre","lblNumMeses" );
      ((Element)v.get(172)).setAttribute("alto","25" );
      ((Element)v.get(172)).setAttribute("ancho","80" );
      ((Element)v.get(172)).setAttribute("filas","1" );
      ((Element)v.get(172)).setAttribute("valor","" );
      ((Element)v.get(172)).setAttribute("id","datosTitle" );
      ((Element)v.get(172)).setAttribute("cod","3186" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).setAttribute("width","100%" );
      ((Element)v.get(154)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","8" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(176)).setAttribute("nombre","lblObservaciones" );
      ((Element)v.get(176)).setAttribute("alto","13" );
      ((Element)v.get(176)).setAttribute("filas","1" );
      ((Element)v.get(176)).setAttribute("valor","" );
      ((Element)v.get(176)).setAttribute("id","datosTitle" );
      ((Element)v.get(176)).setAttribute("cod","169" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:154   */

      /* Empieza nodo:177 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(177));

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
      ((Element)v.get(180)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(177)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(181)).setAttribute("nombre","txtCodProducto" );
      ((Element)v.get(181)).setAttribute("id","datosCampos" );
      ((Element)v.get(181)).setAttribute("max","20" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(181)).setAttribute("tipo","" );
      ((Element)v.get(181)).setAttribute("onchange","" );
      ((Element)v.get(181)).setAttribute("req","S" );
      ((Element)v.get(181)).setAttribute("size","26" );
      ((Element)v.get(181)).setAttribute("valor","" );
      ((Element)v.get(181)).setAttribute("validacion","" );
      ((Element)v.get(181)).setAttribute("onshtab","onShTabTxtCodProducto();" );
      ((Element)v.get(181)).setAttribute("ontab","onTabTxtCodProducto();" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(183)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(183)).setAttribute("ID","botonContenido" );
      ((Element)v.get(183)).setAttribute("tipo","html" );
      ((Element)v.get(183)).setAttribute("accion","accionBuscarProducto();" );
      ((Element)v.get(183)).setAttribute("estado","false" );
      ((Element)v.get(183)).setAttribute("cod","1" );
      ((Element)v.get(183)).setAttribute("ontab","onTabBtnBuscar();" );
      ((Element)v.get(183)).setAttribute("onshtab","onShTabBtnBuscar();" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).setAttribute("width","100%" );
      ((Element)v.get(177)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","8" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(186)).setAttribute("align","center" );
      ((Element)v.get(177)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(187)).setAttribute("nombre","ChkIndCenServGar" );
      ((Element)v.get(187)).setAttribute("id","datosCampos" );
      ((Element)v.get(187)).setAttribute("onclick","onclickIndCenServGar();" );
      ((Element)v.get(187)).setAttribute("onshtab","onShTabChkIndCenServGar();" );
      ((Element)v.get(187)).setAttribute("ontab","onTabChkIndCenServGar();" );
      ((Element)v.get(187)).setAttribute("check","N" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","25" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(177)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(191)).setAttribute("nombre","cbCenServGar" );
      ((Element)v.get(191)).setAttribute("id","datosCampos" );
      ((Element)v.get(191)).setAttribute("size","1" );
      ((Element)v.get(191)).setAttribute("multiple","N" );
      ((Element)v.get(191)).setAttribute("req","N" );
      ((Element)v.get(191)).setAttribute("onchange","" );
      ((Element)v.get(191)).setAttribute("valorinicial","" );
      ((Element)v.get(191)).setAttribute("textoinicial","" );
      ((Element)v.get(191)).setAttribute("ontab","onTabCbCenServGar();" );
      ((Element)v.get(191)).setAttribute("onshtab","onShTabCbCenServGar();" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:193 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).setAttribute("width","100%" );
      ((Element)v.get(177)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","8" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(177)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(196)).setAttribute("nombre","txtNumMeses" );
      ((Element)v.get(196)).setAttribute("id","datosCampos" );
      ((Element)v.get(196)).setAttribute("max","4" );
      ((Element)v.get(196)).setAttribute("tipo","" );
      ((Element)v.get(196)).setAttribute("onblur","" );
      ((Element)v.get(196)).setAttribute("onchange","" );
      ((Element)v.get(196)).setAttribute("req","N" );
      ((Element)v.get(196)).setAttribute("size","6" );
      ((Element)v.get(196)).setAttribute("valor","" );
      ((Element)v.get(196)).setAttribute("validacion","" );
      ((Element)v.get(196)).setAttribute("ontab","onTabTxtNumMeses();" );
      ((Element)v.get(196)).setAttribute("onshtab","onShTabTxtNumMeses();" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 177   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("width","100%" );
      ((Element)v.get(177)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","8" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(177)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(200)).setAttribute("cols","20" );
      ((Element)v.get(200)).setAttribute("id","datosCampos" );
      ((Element)v.get(200)).setAttribute("msjreq","" );
      ((Element)v.get(200)).setAttribute("nombre","areaObservaciones" );
      ((Element)v.get(200)).setAttribute("readonly","N" );
      ((Element)v.get(200)).setAttribute("req","N" );
      ((Element)v.get(200)).setAttribute("rows","3" );
      ((Element)v.get(200)).setAttribute("tabindex","2" );
      ((Element)v.get(200)).setAttribute("valor","" );
      ((Element)v.get(200)).setAttribute("max","80" );
      ((Element)v.get(200)).setAttribute("ontab","onTabAreaObservaciones();" );
      ((Element)v.get(200)).setAttribute("onshtab","onShTabAreaObservaciones();" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:177   */

      /* Empieza nodo:201 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).setAttribute("colspan","11" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","8" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:204 / Elemento padre: 147   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(147)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("table"));
      ((Element)v.get(206)).setAttribute("width","673" );
      ((Element)v.get(206)).setAttribute("border","0" );
      ((Element)v.get(206)).setAttribute("align","left" );
      ((Element)v.get(206)).setAttribute("cellspacing","0" );
      ((Element)v.get(206)).setAttribute("cellpadding","0" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(211)).setAttribute("nombre","lblNumUnidades4" );
      ((Element)v.get(211)).setAttribute("alto","13" );
      ((Element)v.get(211)).setAttribute("filas","1" );
      ((Element)v.get(211)).setAttribute("valor","" );
      ((Element)v.get(211)).setAttribute("id","datosTitle" );
      ((Element)v.get(211)).setAttribute("cod","495" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).setAttribute("width","25" );
      ((Element)v.get(213)).setAttribute("height","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(215)).setAttribute("nombre","lblPrecioPublico4" );
      ((Element)v.get(215)).setAttribute("alto","13" );
      ((Element)v.get(215)).setAttribute("filas","1" );
      ((Element)v.get(215)).setAttribute("valor","" );
      ((Element)v.get(215)).setAttribute("id","datosTitle" );
      ((Element)v.get(215)).setAttribute("cod","1854" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(217)).setAttribute("width","25" );
      ((Element)v.get(217)).setAttribute("height","8" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(207)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(219)).setAttribute("nombre","lblDespachaArticulo4" );
      ((Element)v.get(219)).setAttribute("alto","13" );
      ((Element)v.get(219)).setAttribute("filas","1" );
      ((Element)v.get(219)).setAttribute("valor","" );
      ((Element)v.get(219)).setAttribute("id","datosTitle" );
      ((Element)v.get(219)).setAttribute("cod","1851" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).setAttribute("width","100%" );
      ((Element)v.get(207)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","8" );
      ((Element)v.get(221)).setAttribute("height","8" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(223)).setAttribute("nombre","lblTipoEntrega" );
      ((Element)v.get(223)).setAttribute("alto","13" );
      ((Element)v.get(223)).setAttribute("filas","1" );
      ((Element)v.get(223)).setAttribute("valor","" );
      ((Element)v.get(223)).setAttribute("id","datosTitle" );
      ((Element)v.get(223)).setAttribute("cod","3187" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","25" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(227)).setAttribute("nombre","lblCenServEntrega" );
      ((Element)v.get(227)).setAttribute("alto","13" );
      ((Element)v.get(227)).setAttribute("filas","1" );
      ((Element)v.get(227)).setAttribute("valor","" );
      ((Element)v.get(227)).setAttribute("id","datosTitle" );
      ((Element)v.get(227)).setAttribute("cod","3188" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).setAttribute("width","100%" );
      ((Element)v.get(207)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","8" );
      ((Element)v.get(229)).setAttribute("height","8" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:207   */

      /* Empieza nodo:230 / Elemento padre: 206   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(206)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","8" );
      ((Element)v.get(232)).setAttribute("height","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(233)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(230)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(234)).setAttribute("nombre","txtNumUnidades4" );
      ((Element)v.get(234)).setAttribute("id","datosCampos" );
      ((Element)v.get(234)).setAttribute("max","5" );
      ((Element)v.get(234)).setAttribute("tipo","" );
      ((Element)v.get(234)).setAttribute("onchange","" );
      ((Element)v.get(234)).setAttribute("req","S" );
      ((Element)v.get(234)).setAttribute("size","4" );
      ((Element)v.get(234)).setAttribute("valor","" );
      ((Element)v.get(234)).setAttribute("validacion","" );
      ((Element)v.get(234)).setAttribute("ontab","onTabTxtNumUnidades4();" );
      ((Element)v.get(234)).setAttribute("onshtab","onShTabTxtNumUnidades4();" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(236)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).setAttribute("width","25" );
      ((Element)v.get(236)).setAttribute("height","8" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(230)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(238)).setAttribute("nombre","txtPrecioPublico4" );
      ((Element)v.get(238)).setAttribute("id","datosCampos" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(238)).setAttribute("max","11" );
      ((Element)v.get(238)).setAttribute("tipo","" );
      ((Element)v.get(238)).setAttribute("onchange","" );
      ((Element)v.get(238)).setAttribute("req","S" );
      ((Element)v.get(238)).setAttribute("size","12" );
      ((Element)v.get(238)).setAttribute("valor","" );
      ((Element)v.get(238)).setAttribute("validacion","" );
      ((Element)v.get(238)).setAttribute("ontab","onTabTxtPrecioPublico4();" );
      ((Element)v.get(238)).setAttribute("onshtab","onShTabTxtPrecioPublico4();" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","25" );
      ((Element)v.get(240)).setAttribute("height","8" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).setAttribute("valing","bottom" );
      ((Element)v.get(230)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(242)).setAttribute("nombre","ckArticuloDespacha4" );
      ((Element)v.get(242)).setAttribute("id","datosCampos" );
      ((Element)v.get(242)).setAttribute("onclick","" );
      ((Element)v.get(242)).setAttribute("check","N" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("width","100%" );
      ((Element)v.get(230)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","8" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(230)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(246)).setAttribute("nombre","rdTipoEntrega" );
      ((Element)v.get(246)).setAttribute("onclick","onclickRdTipoEntrega();" );
      ((Element)v.get(246)).setAttribute("tipo","V" );
      ((Element)v.get(246)).setAttribute("req","N" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(247)).setAttribute("id","datosTitle" );
      ((Element)v.get(247)).setAttribute("valor","C" );
      ((Element)v.get(247)).setAttribute("cod","3190" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 246   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(248)).setAttribute("id","datosTitle" );
      ((Element)v.get(248)).setAttribute("valor","B" );
      ((Element)v.get(248)).setAttribute("cod","3189" );
      ((Element)v.get(248)).setAttribute("check","S" );
      ((Element)v.get(246)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:249 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).setAttribute("width","25" );
      ((Element)v.get(250)).setAttribute("height","8" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(230)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(252)).setAttribute("nombre","cbCenServEntrega" );
      ((Element)v.get(252)).setAttribute("id","datosCampos" );
      ((Element)v.get(252)).setAttribute("size","1" );
      ((Element)v.get(252)).setAttribute("multiple","N" );
      ((Element)v.get(252)).setAttribute("req","N" );
      ((Element)v.get(252)).setAttribute("onchange","" );
      ((Element)v.get(252)).setAttribute("valorinicial","" );
      ((Element)v.get(252)).setAttribute("textoinicial","" );
      ((Element)v.get(252)).setAttribute("ontab","onTabCbCenServEntrega();" );
      ((Element)v.get(252)).setAttribute("onshtab","onShTabCbCenServEntrega();" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:254 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).setAttribute("width","100%" );
      ((Element)v.get(230)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","8" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:230   */

      /* Empieza nodo:256 / Elemento padre: 206   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(206)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).setAttribute("colspan","11" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","8" );
      ((Element)v.get(258)).setAttribute("height","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:147   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:259 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:140   */

      /* Empieza nodo:261 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).setAttribute("colspan","3" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","8" );
      ((Element)v.get(263)).setAttribute("height","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:264 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("table"));
      ((Element)v.get(266)).setAttribute("width","100%" );
      ((Element)v.get(266)).setAttribute("border","0" );
      ((Element)v.get(266)).setAttribute("align","center" );
      ((Element)v.get(266)).setAttribute("cellspacing","0" );
      ((Element)v.get(266)).setAttribute("cellpadding","0" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).setAttribute("width","12" );
      ((Element)v.get(268)).setAttribute("align","center" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(269)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).setAttribute("width","8" );
      ((Element)v.get(269)).setAttribute("height","8" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).setAttribute("width","100%" );
      ((Element)v.get(267)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","8" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).setAttribute("width","12" );
      ((Element)v.get(267)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(273)).setAttribute("src","b.gif" );
      ((Element)v.get(273)).setAttribute("width","12" );
      ((Element)v.get(273)).setAttribute("height","1" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:267   */

      /* Empieza nodo:274 / Elemento padre: 266   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(266)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(279)).setAttribute("class","legend" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(280)).setAttribute("nombre","lblCondicionesDelProductoReempplazo" );
      ((Element)v.get(280)).setAttribute("alto","13" );
      ((Element)v.get(280)).setAttribute("filas","1" );
      ((Element)v.get(280)).setAttribute("valor","" );
      ((Element)v.get(280)).setAttribute("id","legend" );
      ((Element)v.get(280)).setAttribute("cod","3426" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:281 / Elemento padre: 278   */
      v.add(doc.createElement("table"));
      ((Element)v.get(281)).setAttribute("width","100%" );
      ((Element)v.get(281)).setAttribute("border","0" );
      ((Element)v.get(281)).setAttribute("align","center" );
      ((Element)v.get(281)).setAttribute("cellspacing","0" );
      ((Element)v.get(281)).setAttribute("cellpadding","0" );
      ((Element)v.get(278)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(282)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("table"));
      ((Element)v.get(284)).setAttribute("width","576" );
      ((Element)v.get(284)).setAttribute("border","0" );
      ((Element)v.get(284)).setAttribute("align","left" );
      ((Element)v.get(284)).setAttribute("cellspacing","0" );
      ((Element)v.get(284)).setAttribute("cellpadding","0" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).setAttribute("colspan","9" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(287)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).setAttribute("width","8" );
      ((Element)v.get(287)).setAttribute("height","8" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:288 / Elemento padre: 284   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(284)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(290)).setAttribute("src","b.gif" );
      ((Element)v.get(290)).setAttribute("width","8" );
      ((Element)v.get(290)).setAttribute("height","8" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:291 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(292)).setAttribute("nombre","lblCriterioParaInicioDeReemplazo" );
      ((Element)v.get(292)).setAttribute("alto","13" );
      ((Element)v.get(292)).setAttribute("filas","1" );
      ((Element)v.get(292)).setAttribute("valor","" );
      ((Element)v.get(292)).setAttribute("id","datosTitle" );
      ((Element)v.get(292)).setAttribute("cod","3425" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:293 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(294)).setAttribute("src","b.gif" );
      ((Element)v.get(294)).setAttribute("width","25" );
      ((Element)v.get(294)).setAttribute("height","8" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(296)).setAttribute("nombre","lblValorCriterio" );
      ((Element)v.get(296)).setAttribute("alto","13" );
      ((Element)v.get(296)).setAttribute("filas","1" );
      ((Element)v.get(296)).setAttribute("valor","" );
      ((Element)v.get(296)).setAttribute("id","datosTitle" );
      ((Element)v.get(296)).setAttribute("cod","3415" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).setAttribute("width","25" );
      ((Element)v.get(298)).setAttribute("height","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(300)).setAttribute("nombre","lblComunicacion" );
      ((Element)v.get(300)).setAttribute("alto","13" );
      ((Element)v.get(300)).setAttribute("filas","1" );
      ((Element)v.get(300)).setAttribute("valor","" );
      ((Element)v.get(300)).setAttribute("id","datosTitle" );
      ((Element)v.get(300)).setAttribute("cod","00322" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(301)).setAttribute("width","100%" );
      ((Element)v.get(288)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","8" );
      ((Element)v.get(302)).setAttribute("height","8" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */
      /* Termina nodo:288   */

      /* Empieza nodo:303 / Elemento padre: 284   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(284)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).setAttribute("width","8" );
      ((Element)v.get(305)).setAttribute("height","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(306)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(303)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(307)).setAttribute("nombre","cbCriterioReemplazo" );
      ((Element)v.get(307)).setAttribute("id","datosCampos" );
      ((Element)v.get(307)).setAttribute("size","1" );
      ((Element)v.get(307)).setAttribute("multiple","N" );
      ((Element)v.get(307)).setAttribute("req","S" );
      ((Element)v.get(307)).setAttribute("valorinicial","" );
      ((Element)v.get(307)).setAttribute("textoinicial","" );
      ((Element)v.get(307)).setAttribute("ontab","onTabCbCriterioReemplazo();" );
      ((Element)v.get(307)).setAttribute("onshtab","onShTabCbCriterioReemplazo();" );
      ((Element)v.get(307)).setAttribute("onchange","onChangeCbCriterioReemplazo();" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:309 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(310)).setAttribute("src","b.gif" );
      ((Element)v.get(310)).setAttribute("width","25" );
      ((Element)v.get(310)).setAttribute("height","8" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:311 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(303)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(312)).setAttribute("nombre","txtValorCriterio" );
      ((Element)v.get(312)).setAttribute("id","datosCampos" );
      ((Element)v.get(312)).setAttribute("max","4" );
      ((Element)v.get(312)).setAttribute("tipo","" );
      ((Element)v.get(312)).setAttribute("onblur","" );
      ((Element)v.get(312)).setAttribute("onchange","" );
      ((Element)v.get(312)).setAttribute("req","N" );
      ((Element)v.get(312)).setAttribute("size","6" );
      ((Element)v.get(312)).setAttribute("valor","" );
      ((Element)v.get(312)).setAttribute("validacion","" );
      ((Element)v.get(312)).setAttribute("ontab","onTabTxtValorCriterio();" );
      ((Element)v.get(312)).setAttribute("onshtab","onTabShTxtValorCriterio();" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(314)).setAttribute("src","b.gif" );
      ((Element)v.get(314)).setAttribute("width","25" );
      ((Element)v.get(314)).setAttribute("height","8" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(315)).setAttribute("align","center" );
      ((Element)v.get(303)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(316)).setAttribute("nombre","ChkComunicacion" );
      ((Element)v.get(316)).setAttribute("id","datosCampos" );
      ((Element)v.get(316)).setAttribute("onclick","onclickIndCenServGar();" );
      ((Element)v.get(316)).setAttribute("onshtab","focalizaShTab(2);" );
      ((Element)v.get(316)).setAttribute("check","S" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).setAttribute("width","100%" );
      ((Element)v.get(303)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).setAttribute("width","8" );
      ((Element)v.get(318)).setAttribute("height","8" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */
      /* Termina nodo:303   */
      /* Termina nodo:284   */
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:319 / Elemento padre: 281   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(281)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(321)).setAttribute("nombre","capa2" );
      ((Element)v.get(321)).setAttribute("visibilidad","O" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("td"));
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("table"));
      ((Element)v.get(324)).setAttribute("width","576" );
      ((Element)v.get(324)).setAttribute("border","0" );
      ((Element)v.get(324)).setAttribute("align","left" );
      ((Element)v.get(324)).setAttribute("cellspacing","0" );
      ((Element)v.get(324)).setAttribute("cellpadding","0" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).setAttribute("colspan","9" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(327)).setAttribute("src","b.gif" );
      ((Element)v.get(327)).setAttribute("width","8" );
      ((Element)v.get(327)).setAttribute("height","8" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:328 / Elemento padre: 324   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(324)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(330)).setAttribute("width","8" );
      ((Element)v.get(330)).setAttribute("height","8" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(332)).setAttribute("nombre","lblNroOrden" );
      ((Element)v.get(332)).setAttribute("alto","13" );
      ((Element)v.get(332)).setAttribute("filas","1" );
      ((Element)v.get(332)).setAttribute("valor","" );
      ((Element)v.get(332)).setAttribute("id","datosTitle" );
      ((Element)v.get(332)).setAttribute("cod","3416" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","25" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(336)).setAttribute("nombre","lblIndicadorActivo" );
      ((Element)v.get(336)).setAttribute("alto","13" );
      ((Element)v.get(336)).setAttribute("filas","1" );
      ((Element)v.get(336)).setAttribute("valor","" );
      ((Element)v.get(336)).setAttribute("id","datosTitle" );
      ((Element)v.get(336)).setAttribute("cod","3417" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).setAttribute("width","100%" );
      ((Element)v.get(328)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","8" );
      ((Element)v.get(338)).setAttribute("height","8" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */
      /* Termina nodo:328   */

      /* Empieza nodo:339 / Elemento padre: 324   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(324)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(341)).setAttribute("src","b.gif" );
      ((Element)v.get(341)).setAttribute("width","8" );
      ((Element)v.get(341)).setAttribute("height","8" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:342 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(342)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(339)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(343)).setAttribute("nombre","txtNumOrden" );
      ((Element)v.get(343)).setAttribute("id","datosCampos" );
      ((Element)v.get(343)).setAttribute("max","5" );
      ((Element)v.get(343)).setAttribute("tipo","" );
      ((Element)v.get(343)).setAttribute("onchange","" );
      ((Element)v.get(343)).setAttribute("req","N" );
      ((Element)v.get(343)).setAttribute("size","4" );
      ((Element)v.get(343)).setAttribute("valor","" );
      ((Element)v.get(343)).setAttribute("validacion","" );
      ((Element)v.get(343)).setAttribute("ontab","onTabTxtNumOrden();" );
      ((Element)v.get(343)).setAttribute("onshtab","onShTabTxtNumOrden();" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(345)).setAttribute("src","b.gif" );
      ((Element)v.get(345)).setAttribute("width","25" );
      ((Element)v.get(345)).setAttribute("height","8" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:346 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(339)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(347)).setAttribute("nombre","ChkIndicadorActivo" );
      ((Element)v.get(347)).setAttribute("id","datosCampos" );
      ((Element)v.get(347)).setAttribute("onclick","" );
      ((Element)v.get(347)).setAttribute("onshtab","focalizaShTab(2);" );
      ((Element)v.get(347)).setAttribute("check","" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:348 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).setAttribute("width","100%" );
      ((Element)v.get(339)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(349)).setAttribute("src","b.gif" );
      ((Element)v.get(349)).setAttribute("width","8" );
      ((Element)v.get(349)).setAttribute("height","8" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */
      /* Termina nodo:339   */
      /* Termina nodo:324   */
      /* Termina nodo:323   */
      /* Termina nodo:322   */
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:350 / Elemento padre: 281   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(281)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("td"));
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("table"));
      ((Element)v.get(352)).setAttribute("width","100%" );
      ((Element)v.get(352)).setAttribute("border","0" );
      ((Element)v.get(352)).setAttribute("align","center" );
      ((Element)v.get(352)).setAttribute("cellspacing","0" );
      ((Element)v.get(352)).setAttribute("cellpadding","0" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(354)).setAttribute("width","12" );
      ((Element)v.get(354)).setAttribute("align","center" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(355)).setAttribute("src","b.gif" );
      ((Element)v.get(355)).setAttribute("width","8" );
      ((Element)v.get(355)).setAttribute("height","8" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:356 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(356)).setAttribute("width","100%" );
      ((Element)v.get(353)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).setAttribute("width","8" );
      ((Element)v.get(357)).setAttribute("height","8" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(358)).setAttribute("width","12" );
      ((Element)v.get(353)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(359)).setAttribute("src","b.gif" );
      ((Element)v.get(359)).setAttribute("width","12" );
      ((Element)v.get(359)).setAttribute("height","1" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */
      /* Termina nodo:353   */

      /* Empieza nodo:360 / Elemento padre: 352   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(352)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("td"));
      ((Element)v.get(360)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */

      /* Empieza nodo:363 / Elemento padre: 360   */
      v.add(doc.createElement("td"));
      ((Element)v.get(360)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(365)).setAttribute("class","legend" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(366)).setAttribute("nombre","lblAlcanceGeografico" );
      ((Element)v.get(366)).setAttribute("alto","13" );
      ((Element)v.get(366)).setAttribute("filas","1" );
      ((Element)v.get(366)).setAttribute("valor","" );
      ((Element)v.get(366)).setAttribute("id","legend" );
      ((Element)v.get(366)).setAttribute("cod","00368" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:367 / Elemento padre: 364   */
      v.add(doc.createElement("table"));
      ((Element)v.get(367)).setAttribute("width","100%" );
      ((Element)v.get(367)).setAttribute("border","0" );
      ((Element)v.get(367)).setAttribute("align","center" );
      ((Element)v.get(367)).setAttribute("cellspacing","0" );
      ((Element)v.get(367)).setAttribute("cellpadding","0" );
      ((Element)v.get(364)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("table"));
      ((Element)v.get(370)).setAttribute("width","576" );
      ((Element)v.get(370)).setAttribute("border","0" );
      ((Element)v.get(370)).setAttribute("align","left" );
      ((Element)v.get(370)).setAttribute("cellspacing","0" );
      ((Element)v.get(370)).setAttribute("cellpadding","0" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("td"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(372)).setAttribute("colspan","9" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(373)).setAttribute("src","b.gif" );
      ((Element)v.get(373)).setAttribute("width","8" );
      ((Element)v.get(373)).setAttribute("height","8" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */
      /* Termina nodo:371   */

      /* Empieza nodo:374 / Elemento padre: 370   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(370)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(376)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).setAttribute("width","8" );
      ((Element)v.get(376)).setAttribute("height","8" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("table"));
      ((Element)v.get(378)).setAttribute("width","100%" );
      ((Element)v.get(378)).setAttribute("border","0" );
      ((Element)v.get(378)).setAttribute("cellspacing","0" );
      ((Element)v.get(378)).setAttribute("cellpadding","0" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(378)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("td"));
      ((Element)v.get(380)).setAttribute("class","datosTitle" );
      ((Element)v.get(380)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(381)).setAttribute("nombre","rbAlcanceGeografico" );
      ((Element)v.get(381)).setAttribute("tipo","H" );
      ((Element)v.get(381)).setAttribute("id","datosCampos" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(382)).setAttribute("valor","R" );
      ((Element)v.get(382)).setAttribute("onfocus","" );
      ((Element)v.get(382)).setAttribute("id","datosCampos" );
      ((Element)v.get(382)).setAttribute("onclick","onClickRbRegion()" );
      ((Element)v.get(382)).setAttribute("check","N" );
      ((Element)v.get(382)).setAttribute("onDblClick","uncheckRegion(this)" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */
      /* Termina nodo:380   */
      /* Termina nodo:379   */
      /* Termina nodo:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:383 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).setAttribute("width","249" );
      ((Element)v.get(374)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(384)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(384)).setAttribute("alto","13" );
      ((Element)v.get(384)).setAttribute("filas","1" );
      ((Element)v.get(384)).setAttribute("valor","" );
      ((Element)v.get(384)).setAttribute("id","datosTitle" );
      ((Element)v.get(384)).setAttribute("cod","109" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */

      /* Empieza nodo:385 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(386)).setAttribute("src","b.gif" );
      ((Element)v.get(386)).setAttribute("width","25" );
      ((Element)v.get(386)).setAttribute("height","8" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */
      /* Termina nodo:385   */

      /* Empieza nodo:387 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("table"));
      ((Element)v.get(388)).setAttribute("width","100%" );
      ((Element)v.get(388)).setAttribute("border","0" );
      ((Element)v.get(388)).setAttribute("cellspacing","0" );
      ((Element)v.get(388)).setAttribute("cellpadding","0" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(388)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("td"));
      ((Element)v.get(390)).setAttribute("class","datosTitle" );
      ((Element)v.get(390)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(391)).setAttribute("nombre","rbAlcanceGeografico" );
      ((Element)v.get(391)).setAttribute("tipo","H" );
      ((Element)v.get(391)).setAttribute("id","datosCampos" );
      ((Element)v.get(391)).setAttribute("onDblClick","uncheckZona(this)" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(392)).setAttribute("valor","Z" );
      ((Element)v.get(392)).setAttribute("onfocus","" );
      ((Element)v.get(392)).setAttribute("id","datosCampos" );
      ((Element)v.get(392)).setAttribute("onclick","onClickRbZona()" );
      ((Element)v.get(392)).setAttribute("check","N" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */
      /* Termina nodo:390   */
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:387   */

      /* Empieza nodo:393 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(393)).setAttribute("width","249" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(374)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(394)).setAttribute("nombre","lblZona" );
      ((Element)v.get(394)).setAttribute("alto","13" );
      ((Element)v.get(394)).setAttribute("filas","1" );
      ((Element)v.get(394)).setAttribute("valor","" );
      ((Element)v.get(394)).setAttribute("id","datosTitle" );
      ((Element)v.get(394)).setAttribute("cod","143" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(395)).setAttribute("width","100%" );
      ((Element)v.get(374)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(396)).setAttribute("src","b.gif" );
      ((Element)v.get(396)).setAttribute("width","8" );
      ((Element)v.get(396)).setAttribute("height","8" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */
      /* Termina nodo:374   */

      /* Empieza nodo:397 / Elemento padre: 370   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(370)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("td"));
      ((Element)v.get(397)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(399)).setAttribute("src","b.gif" );
      ((Element)v.get(399)).setAttribute("width","8" );
      ((Element)v.get(399)).setAttribute("height","8" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */

      /* Empieza nodo:400 / Elemento padre: 397   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(400)).setAttribute("colspan","2" );
      ((Element)v.get(397)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(401)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(401)).setAttribute("id","datosCampos" );
      ((Element)v.get(401)).setAttribute("size","5" );
      ((Element)v.get(401)).setAttribute("multiple","S" );
      ((Element)v.get(401)).setAttribute("req","N" );
      ((Element)v.get(401)).setAttribute("valorinicial","" );
      ((Element)v.get(401)).setAttribute("textoinicial","" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:403 / Elemento padre: 397   */
      v.add(doc.createElement("td"));
      ((Element)v.get(397)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(404)).setAttribute("src","b.gif" );
      ((Element)v.get(404)).setAttribute("width","25" );
      ((Element)v.get(404)).setAttribute("height","8" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:405 / Elemento padre: 397   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(405)).setAttribute("colspan","2" );
      ((Element)v.get(397)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(406)).setAttribute("nombre","cbZona" );
      ((Element)v.get(406)).setAttribute("id","datosCampos" );
      ((Element)v.get(406)).setAttribute("size","5" );
      ((Element)v.get(406)).setAttribute("multiple","S" );
      ((Element)v.get(406)).setAttribute("req","N" );
      ((Element)v.get(406)).setAttribute("valorinicial","" );
      ((Element)v.get(406)).setAttribute("textoinicial","" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:408 / Elemento padre: 397   */
      v.add(doc.createElement("td"));
      ((Element)v.get(408)).setAttribute("width","100%" );
      ((Element)v.get(397)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(409)).setAttribute("src","b.gif" );
      ((Element)v.get(409)).setAttribute("width","8" );
      ((Element)v.get(409)).setAttribute("height","8" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:408   */
      /* Termina nodo:397   */

      /* Empieza nodo:410 / Elemento padre: 370   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(370)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("td"));
      ((Element)v.get(411)).setAttribute("colspan","9" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(412)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).setAttribute("width","8" );
      ((Element)v.get(412)).setAttribute("height","8" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */
      /* Termina nodo:410   */
      /* Termina nodo:370   */
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:367   */
      /* Termina nodo:364   */
      /* Termina nodo:363   */

      /* Empieza nodo:413 / Elemento padre: 360   */
      v.add(doc.createElement("td"));
      ((Element)v.get(360)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(414)).setAttribute("src","b.gif" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */
      /* Termina nodo:360   */

      /* Empieza nodo:415 / Elemento padre: 352   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(352)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(416)).setAttribute("colspan","3" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(415)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(417)).setAttribute("src","b.gif" );
      ((Element)v.get(417)).setAttribute("width","8" );
      ((Element)v.get(417)).setAttribute("height","8" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */
      /* Termina nodo:415   */
      /* Termina nodo:352   */
      /* Termina nodo:351   */
      /* Termina nodo:350   */
      /* Termina nodo:281   */
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:418 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(419)).setAttribute("src","b.gif" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */
      /* Termina nodo:274   */
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:72   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:65   */

      /* Empieza nodo:420 / Elemento padre: 57   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(57)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("td"));
      ((Element)v.get(420)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(422)).setAttribute("src","b.gif" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:421   */

      /* Empieza nodo:423 / Elemento padre: 420   */
      v.add(doc.createElement("td"));
      ((Element)v.get(420)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(423)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("table"));
      ((Element)v.get(425)).setAttribute("width","100%" );
      ((Element)v.get(425)).setAttribute("border","0" );
      ((Element)v.get(425)).setAttribute("align","center" );
      ((Element)v.get(425)).setAttribute("cellspacing","0" );
      ((Element)v.get(425)).setAttribute("cellpadding","0" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("td"));
      ((Element)v.get(427)).setAttribute("class","botonera" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(428)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(428)).setAttribute("ID","botonContenido" );
      ((Element)v.get(428)).setAttribute("tipo","html" );
      ((Element)v.get(428)).setAttribute("accion","accionBtAceptar();" );
      ((Element)v.get(428)).setAttribute("estado","false" );
      ((Element)v.get(428)).setAttribute("cod","12" );
      ((Element)v.get(428)).setAttribute("ontab","onTabBtnAceptar();" );
      ((Element)v.get(428)).setAttribute("onshtab","onShTabBtnAceptar();" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */
      /* Termina nodo:426   */
      /* Termina nodo:425   */
      /* Termina nodo:424   */
      /* Termina nodo:423   */

      /* Empieza nodo:429 / Elemento padre: 420   */
      v.add(doc.createElement("td"));
      ((Element)v.get(420)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(430)).setAttribute("src","b.gif" );
      ((Element)v.get(430)).setAttribute("width","8" );
      ((Element)v.get(430)).setAttribute("height","12" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:429   */
      /* Termina nodo:420   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:14   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_boleta_recojo_pendiente_gestionar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_boleta_recojo_pendiente_gestionar" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("cod","01090" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_boleta_recojo_pendiente_gestionar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbMarca" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","6" );
      ((Element)v.get(7)).setAttribute("req","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbCanal" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","7" );
      ((Element)v.get(8)).setAttribute("req","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbPeriodoDde" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","1175" );
      ((Element)v.get(9)).setAttribute("req","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:6   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(10)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(13)).setAttribute("valor","LPGestionarBoletasRecojoPendientes" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","accion" );
      ((Element)v.get(14)).setAttribute("valor","buscar" );
      ((Element)v.get(10)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","oidPais" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hOidCanal" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hOidPeriodoDde" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hOidPeriodoHta" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hOidMarca" );
      ((Element)v.get(21)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(10)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hFechaRecojo" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","varCbMarca" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","varCBCanal" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","varCbPerDde" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","varCbPerHta" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","varFechReco" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","txtCodigoCliente" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","elemSelecc" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","numsAten" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","numsRecoj" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","numBoletaRecojo" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(33)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(33)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(33)).setAttribute("borde","0" );
      ((Element)v.get(33)).setAttribute("imagenf","" );
      ((Element)v.get(33)).setAttribute("repeat","" );
      ((Element)v.get(33)).setAttribute("padding","" );
      ((Element)v.get(33)).setAttribute("visibilidad","" );
      ((Element)v.get(33)).setAttribute("contravsb","" );
      ((Element)v.get(33)).setAttribute("x","0" );
      ((Element)v.get(33)).setAttribute("y","0" );
      ((Element)v.get(33)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("table"));
      ((Element)v.get(34)).setAttribute("width","100%" );
      ((Element)v.get(34)).setAttribute("border","0" );
      ((Element)v.get(34)).setAttribute("cellspacing","0" );
      ((Element)v.get(34)).setAttribute("cellpadding","0" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).setAttribute("width","12" );
      ((Element)v.get(36)).setAttribute("align","center" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).setAttribute("width","12" );
      ((Element)v.get(37)).setAttribute("height","12" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("width","750" );
      ((Element)v.get(35)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("width","12" );
      ((Element)v.get(35)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","12" );
      ((Element)v.get(41)).setAttribute("height","1" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:35   */

      /* Empieza nodo:42 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(34)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(47)).setAttribute("class","legend" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(48)).setAttribute("nombre","lblCriterios" );
      ((Element)v.get(48)).setAttribute("alto","13" );
      ((Element)v.get(48)).setAttribute("filas","1" );
      ((Element)v.get(48)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(48)).setAttribute("id","legend" );
      ((Element)v.get(48)).setAttribute("cod","0075" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 46   */
      v.add(doc.createElement("table"));
      ((Element)v.get(49)).setAttribute("width","100%" );
      ((Element)v.get(49)).setAttribute("border","0" );
      ((Element)v.get(49)).setAttribute("align","center" );
      ((Element)v.get(49)).setAttribute("cellspacing","0" );
      ((Element)v.get(49)).setAttribute("cellpadding","0" );
      ((Element)v.get(46)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("colspan","4" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","8" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:53 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","8" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(57)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(57)).setAttribute("alto","13" );
      ((Element)v.get(57)).setAttribute("filas","1" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("id","datosTitle" );
      ((Element)v.get(57)).setAttribute("cod","6" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","25" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(61)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(61)).setAttribute("alto","13" );
      ((Element)v.get(61)).setAttribute("filas","1" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(61)).setAttribute("id","datosTitle" );
      ((Element)v.get(61)).setAttribute("cod","7" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","25" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(65)).setAttribute("nombre","lblPeriodoDesde" );
      ((Element)v.get(65)).setAttribute("alto","13" );
      ((Element)v.get(65)).setAttribute("filas","1" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(65)).setAttribute("id","datosTitle" );
      ((Element)v.get(65)).setAttribute("cod","1175" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","25" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(69)).setAttribute("nombre","lblPeriodoHasta" );
      ((Element)v.get(69)).setAttribute("alto","13" );
      ((Element)v.get(69)).setAttribute("filas","1" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(69)).setAttribute("id","datosTitle" );
      ((Element)v.get(69)).setAttribute("cod","1176" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","25" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(73)).setAttribute("nombre","lblFechaRecojo" );
      ((Element)v.get(73)).setAttribute("alto","13" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(73)).setAttribute("id","datosTitle" );
      ((Element)v.get(73)).setAttribute("cod","RecFechaRecojo.fechRecojo.label" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("width","100%" );
      ((Element)v.get(53)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","8" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:53   */

      /* Empieza nodo:76 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
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
      ((Element)v.get(79)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(76)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(80)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(80)).setAttribute("id","datosCampos" );
      ((Element)v.get(80)).setAttribute("size","1" );
      ((Element)v.get(80)).setAttribute("multiple","N" );
      ((Element)v.get(80)).setAttribute("req","S" );
      ((Element)v.get(80)).setAttribute("valorinicial","" );
      ((Element)v.get(80)).setAttribute("textoinicial","" );
      ((Element)v.get(80)).setAttribute("onchange","cambioMarcaCanal();" );
      ((Element)v.get(80)).setAttribute("ontab","onTabMarca();" );
      ((Element)v.get(80)).setAttribute("onshtab","onShTabMarca();" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:82 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","8" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(76)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(85)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(85)).setAttribute("id","datosCampos" );
      ((Element)v.get(85)).setAttribute("size","1" );
      ((Element)v.get(85)).setAttribute("multiple","N" );
      ((Element)v.get(85)).setAttribute("req","S" );
      ((Element)v.get(85)).setAttribute("valorinicial","" );
      ((Element)v.get(85)).setAttribute("textoinicial","" );
      ((Element)v.get(85)).setAttribute("onchange","cambioMarcaCanal();" );
      ((Element)v.get(85)).setAttribute("ontab","onTabCanal();" );
      ((Element)v.get(85)).setAttribute("onshtab","onShTabCanal();" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:87 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","8" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(76)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(90)).setAttribute("nombre","cbPeriodoDde" );
      ((Element)v.get(90)).setAttribute("id","datosCampos" );
      ((Element)v.get(90)).setAttribute("size","1" );
      ((Element)v.get(90)).setAttribute("multiple","N" );
      ((Element)v.get(90)).setAttribute("req","S" );
      ((Element)v.get(90)).setAttribute("valorinicial","" );
      ((Element)v.get(90)).setAttribute("textoinicial","" );
      ((Element)v.get(90)).setAttribute("ontab","onTabPerDde();" );
      ((Element)v.get(90)).setAttribute("onshtab","onShTabPerDde();" );
      ((Element)v.get(90)).setAttribute("onchange","onChangePeriodoDesde();" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:92 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(76)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(95)).setAttribute("nombre","cbPeriodoHta" );
      ((Element)v.get(95)).setAttribute("id","datosCampos" );
      ((Element)v.get(95)).setAttribute("size","1" );
      ((Element)v.get(95)).setAttribute("multiple","N" );
      ((Element)v.get(95)).setAttribute("req","N" );
      ((Element)v.get(95)).setAttribute("valorinicial","" );
      ((Element)v.get(95)).setAttribute("textoinicial","" );
      ((Element)v.get(95)).setAttribute("ontab","onTabPerHta();" );
      ((Element)v.get(95)).setAttribute("onshtab","onShTabPerHta();" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:97 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","8" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(76)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(100)).setAttribute("nombre","txtFechaRecojo" );
      ((Element)v.get(100)).setAttribute("id","datosCampos" );
      ((Element)v.get(100)).setAttribute("max","10" );
      ((Element)v.get(100)).setAttribute("tipo","" );
      ((Element)v.get(100)).setAttribute("onchange","" );
      ((Element)v.get(100)).setAttribute("req","N" );
      ((Element)v.get(100)).setAttribute("size","12" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(100)).setAttribute("validacion","" );
      ((Element)v.get(100)).setAttribute("onshtab","onShTabFechReco();" );
      ((Element)v.get(100)).setAttribute("ontab","onTabFechReco();" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:76   */

      /* Empieza nodo:101 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("colspan","4" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:49   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:104 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:42   */

      /* Empieza nodo:106 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("table"));
      ((Element)v.get(111)).setAttribute("width","100%" );
      ((Element)v.get(111)).setAttribute("border","0" );
      ((Element)v.get(111)).setAttribute("align","center" );
      ((Element)v.get(111)).setAttribute("cellspacing","0" );
      ((Element)v.get(111)).setAttribute("cellpadding","0" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("class","botonera" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(114)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(114)).setAttribute("ID","botonContenido" );
      ((Element)v.get(114)).setAttribute("tipo","html" );
      ((Element)v.get(114)).setAttribute("estado","false" );
      ((Element)v.get(114)).setAttribute("cod","1" );
      ((Element)v.get(114)).setAttribute("accion","botonBuscar();" );
      ((Element)v.get(114)).setAttribute("ontab","onTabBot();" );
      ((Element)v.get(114)).setAttribute("onshtab","onShTabBot();" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:115 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","8" );
      ((Element)v.get(116)).setAttribute("height","12" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:106   */

      /* Empieza nodo:117 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("width","12" );
      ((Element)v.get(118)).setAttribute("align","center" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","12" );
      ((Element)v.get(119)).setAttribute("height","12" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","750" );
      ((Element)v.get(117)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("width","12" );
      ((Element)v.get(117)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","12" );
      ((Element)v.get(123)).setAttribute("height","1" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:117   */
      /* Termina nodo:34   */

      /* Empieza nodo:124 / Elemento padre: 33   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(124)).setAttribute("nombre","listado1" );
      ((Element)v.get(124)).setAttribute("ancho","664" );
      ((Element)v.get(124)).setAttribute("alto","317" );
      ((Element)v.get(124)).setAttribute("x","12" );
      ((Element)v.get(124)).setAttribute("y","151" );
      ((Element)v.get(124)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(124)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(33)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(125)).setAttribute("precarga","S" );
      ((Element)v.get(125)).setAttribute("conROver","S" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(126)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(126)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(126)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(126)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 125   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(127)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(127)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(127)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(127)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(125)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 125   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(128)).setAttribute("ordenar","ascendente_on.gif" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(128)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(125)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:125   */

      /* Empieza nodo:129 / Elemento padre: 124   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(124)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(130)).setAttribute("borde","1" );
      ((Element)v.get(130)).setAttribute("horizDatos","1" );
      ((Element)v.get(130)).setAttribute("horizCabecera","1" );
      ((Element)v.get(130)).setAttribute("vertical","1" );
      ((Element)v.get(130)).setAttribute("horizTitulo","1" );
      ((Element)v.get(130)).setAttribute("horizBase","1" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 129   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(131)).setAttribute("borde","#999999" );
      ((Element)v.get(131)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(131)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(131)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(131)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(131)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(131)).setAttribute("horizBase","#999999" );
      ((Element)v.get(129)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:129   */

      /* Empieza nodo:132 / Elemento padre: 124   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(132)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(132)).setAttribute("alto","22" );
      ((Element)v.get(132)).setAttribute("imgFondo","" );
      ((Element)v.get(132)).setAttribute("cod","00135" );
      ((Element)v.get(132)).setAttribute("ID","datosTitle" );
      ((Element)v.get(124)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 124   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(133)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(133)).setAttribute("alto","22" );
      ((Element)v.get(133)).setAttribute("imgFondo","" );
      ((Element)v.get(124)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 124   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(134)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(134)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(134)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(134)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(134)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(134)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(124)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(135)).setAttribute("ancho","100" );
      ((Element)v.get(135)).setAttribute("minimizable","S" );
      ((Element)v.get(135)).setAttribute("minimizada","N" );
      ((Element)v.get(135)).setAttribute("oculta","S" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("ancho","100" );
      ((Element)v.get(136)).setAttribute("minimizable","S" );
      ((Element)v.get(136)).setAttribute("minimizada","N" );
      ((Element)v.get(134)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(137)).setAttribute("ancho","100" );
      ((Element)v.get(137)).setAttribute("minimizable","S" );
      ((Element)v.get(137)).setAttribute("minimizada","N" );
      ((Element)v.get(134)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("ancho","100" );
      ((Element)v.get(138)).setAttribute("minimizable","S" );
      ((Element)v.get(138)).setAttribute("minimizada","N" );
      ((Element)v.get(134)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("ancho","100" );
      ((Element)v.get(139)).setAttribute("minimizable","S" );
      ((Element)v.get(139)).setAttribute("minimizada","N" );
      ((Element)v.get(134)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(140)).setAttribute("ancho","200" );
      ((Element)v.get(140)).setAttribute("minimizable","S" );
      ((Element)v.get(140)).setAttribute("minimizada","N" );
      ((Element)v.get(134)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("ancho","100" );
      ((Element)v.get(141)).setAttribute("minimizable","S" );
      ((Element)v.get(141)).setAttribute("minimizada","N" );
      ((Element)v.get(134)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("ancho","100" );
      ((Element)v.get(142)).setAttribute("minimizable","S" );
      ((Element)v.get(142)).setAttribute("minimizada","N" );
      ((Element)v.get(134)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("ancho","100" );
      ((Element)v.get(143)).setAttribute("minimizable","S" );
      ((Element)v.get(143)).setAttribute("minimizada","N" );
      ((Element)v.get(134)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("ancho","100" );
      ((Element)v.get(144)).setAttribute("minimizable","S" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(144)).setAttribute("minimizada","N" );
      ((Element)v.get(144)).setAttribute("oculta","S" );
      ((Element)v.get(134)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:134   */

      /* Empieza nodo:145 / Elemento padre: 124   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(145)).setAttribute("alto","20" );
      ((Element)v.get(145)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(145)).setAttribute("imgFondo","" );
      ((Element)v.get(145)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(124)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("colFondo","" );
      ((Element)v.get(146)).setAttribute("ID","EstCab" );
      ((Element)v.get(146)).setAttribute("cod","262" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Elemento padre:146 / Elemento actual: 147   */
      v.add(doc.createTextNode("Numero atencion"));
      ((Element)v.get(146)).appendChild((Text)v.get(147));

      /* Termina nodo Texto:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("colFondo","" );
      ((Element)v.get(148)).setAttribute("ID","EstCab" );
      ((Element)v.get(148)).setAttribute("cod","3277" );
      ((Element)v.get(145)).appendChild((Element)v.get(148));

      /* Elemento padre:148 / Elemento actual: 149   */
      v.add(doc.createTextNode("Numero boleta"));
      ((Element)v.get(148)).appendChild((Text)v.get(149));

      /* Termina nodo Texto:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("colFondo","" );
      ((Element)v.get(150)).setAttribute("ID","EstCab" );
      ((Element)v.get(150)).setAttribute("cod","628" );
      ((Element)v.get(145)).appendChild((Element)v.get(150));

      /* Elemento padre:150 / Elemento actual: 151   */
      v.add(doc.createTextNode("Cód. consultora"));
      ((Element)v.get(150)).appendChild((Text)v.get(151));

      /* Termina nodo Texto:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("colFondo","" );
      ((Element)v.get(152)).setAttribute("ID","EstCab" );
      ((Element)v.get(152)).setAttribute("cod","389" );
      ((Element)v.get(145)).appendChild((Element)v.get(152));

      /* Elemento padre:152 / Elemento actual: 153   */
      v.add(doc.createTextNode("Cód. tipo cliente"));
      ((Element)v.get(152)).appendChild((Text)v.get(153));

      /* Termina nodo Texto:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("colFondo","" );
      ((Element)v.get(154)).setAttribute("ID","EstCab" );
      ((Element)v.get(154)).setAttribute("cod","595" );
      ((Element)v.get(145)).appendChild((Element)v.get(154));

      /* Elemento padre:154 / Elemento actual: 155   */
      v.add(doc.createTextNode("Subtipo cliente"));
      ((Element)v.get(154)).appendChild((Text)v.get(155));

      /* Termina nodo Texto:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("colFondo","" );
      ((Element)v.get(156)).setAttribute("ID","EstCab" );
      ((Element)v.get(156)).setAttribute("cod","3269" );
      ((Element)v.get(145)).appendChild((Element)v.get(156));

      /* Elemento padre:156 / Elemento actual: 157   */
      v.add(doc.createTextNode("Region/Zona/Sección/Territorio"));
      ((Element)v.get(156)).appendChild((Text)v.get(157));

      /* Termina nodo Texto:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("colFondo","" );
      ((Element)v.get(158)).setAttribute("ID","EstCab" );
      ((Element)v.get(158)).setAttribute("cod","392" );
      ((Element)v.get(145)).appendChild((Element)v.get(158));

      /* Elemento padre:158 / Elemento actual: 159   */
      v.add(doc.createTextNode("Fecha emisión"));
      ((Element)v.get(158)).appendChild((Text)v.get(159));

      /* Termina nodo Texto:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("colFondo","" );
      ((Element)v.get(160)).setAttribute("ID","EstCab" );
      ((Element)v.get(160)).setAttribute("cod","3270" );
      ((Element)v.get(145)).appendChild((Element)v.get(160));

      /* Elemento padre:160 / Elemento actual: 161   */
      v.add(doc.createTextNode("Estado recojo"));
      ((Element)v.get(160)).appendChild((Text)v.get(161));

      /* Termina nodo Texto:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("colFondo","" );
      ((Element)v.get(162)).setAttribute("ID","EstCab" );
      ((Element)v.get(162)).setAttribute("cod","3271" );
      ((Element)v.get(145)).appendChild((Element)v.get(162));

      /* Elemento padre:162 / Elemento actual: 163   */
      v.add(doc.createTextNode("Número recojo"));
      ((Element)v.get(162)).appendChild((Text)v.get(163));

      /* Termina nodo Texto:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("colFondo","" );
      ((Element)v.get(164)).setAttribute("ID","EstCab" );
      ((Element)v.get(164)).setAttribute("cod","3271" );
      ((Element)v.get(145)).appendChild((Element)v.get(164));

      /* Elemento padre:164 / Elemento actual: 165   */
      v.add(doc.createTextNode("Oid num Recojo"));
      ((Element)v.get(164)).appendChild((Text)v.get(165));

      /* Termina nodo Texto:165   */
      /* Termina nodo:164   */
      /* Termina nodo:145   */

      /* Empieza nodo:166 / Elemento padre: 124   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(166)).setAttribute("alto","22" );
      ((Element)v.get(166)).setAttribute("accion","" );
      ((Element)v.get(166)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(166)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(166)).setAttribute("maxSel","-1" );
      ((Element)v.get(166)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(166)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(166)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(166)).setAttribute("onLoad","" );
      ((Element)v.get(166)).setAttribute("colorSelecc","#D0D9E8" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(124)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("tipo","texto" );
      ((Element)v.get(167)).setAttribute("ID","EstDat" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("tipo","texto" );
      ((Element)v.get(168)).setAttribute("ID","EstDat" );
      ((Element)v.get(166)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("tipo","texto" );
      ((Element)v.get(169)).setAttribute("ID","EstDat2" );
      ((Element)v.get(166)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("tipo","texto" );
      ((Element)v.get(170)).setAttribute("ID","EstDat" );
      ((Element)v.get(166)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("tipo","texto" );
      ((Element)v.get(171)).setAttribute("ID","EstDat2" );
      ((Element)v.get(166)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("tipo","texto" );
      ((Element)v.get(172)).setAttribute("ID","EstDat" );
      ((Element)v.get(166)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("tipo","texto" );
      ((Element)v.get(173)).setAttribute("ID","EstDat2" );
      ((Element)v.get(166)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("tipo","texto" );
      ((Element)v.get(174)).setAttribute("ID","EstDat" );
      ((Element)v.get(166)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("tipo","texto" );
      ((Element)v.get(175)).setAttribute("ID","EstDat2" );
      ((Element)v.get(166)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("tipo","texto" );
      ((Element)v.get(176)).setAttribute("ID","EstDat2" );
      ((Element)v.get(166)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:166   */

      /* Empieza nodo:177 / Elemento padre: 124   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(124)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 124   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(178)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(178)).setAttribute("ancho","664" );
      ((Element)v.get(178)).setAttribute("sep","$" );
      ((Element)v.get(178)).setAttribute("x","12" );
      ((Element)v.get(178)).setAttribute("class","botonera" );
      ((Element)v.get(178)).setAttribute("y","445" );
      ((Element)v.get(178)).setAttribute("control","|" );
      ((Element)v.get(178)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(178)).setAttribute("rowset","" );
      ((Element)v.get(178)).setAttribute("cargainicial","N" );
      ((Element)v.get(178)).setAttribute("onload","procesarPaginado(mipgndo1,msgError, ultima, rowset, 'prueba(ultima, rowset)');" );
      ((Element)v.get(124)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(179)).setAttribute("nombre","ret1" );
      ((Element)v.get(179)).setAttribute("x","37" );
      ((Element)v.get(179)).setAttribute("y","449" );
      ((Element)v.get(179)).setAttribute("ID","botonContenido" );
      ((Element)v.get(179)).setAttribute("img","retroceder_on" );
      ((Element)v.get(179)).setAttribute("tipo","0" );
      ((Element)v.get(179)).setAttribute("estado","false" );
      ((Element)v.get(179)).setAttribute("alt","" );
      ((Element)v.get(179)).setAttribute("codigo","" );
      ((Element)v.get(179)).setAttribute("accion","mipgndo1.retroceder();" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 178   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(180)).setAttribute("nombre","ava1" );
      ((Element)v.get(180)).setAttribute("x","52" );
      ((Element)v.get(180)).setAttribute("y","449" );
      ((Element)v.get(180)).setAttribute("ID","botonContenido" );
      ((Element)v.get(180)).setAttribute("img","avanzar_on" );
      ((Element)v.get(180)).setAttribute("tipo","0" );
      ((Element)v.get(180)).setAttribute("estado","false" );
      ((Element)v.get(180)).setAttribute("alt","" );
      ((Element)v.get(180)).setAttribute("codigo","" );
      ((Element)v.get(180)).setAttribute("accion","mipgndo1.avanzar();" );
      ((Element)v.get(178)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:178   */
      /* Termina nodo:124   */

      /* Empieza nodo:181 / Elemento padre: 33   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(181)).setAttribute("nombre","primera1" );
      ((Element)v.get(181)).setAttribute("x","20" );
      ((Element)v.get(181)).setAttribute("y","449" );
      ((Element)v.get(181)).setAttribute("ID","botonContenido" );
      ((Element)v.get(181)).setAttribute("img","primera_on" );
      ((Element)v.get(181)).setAttribute("tipo","-2" );
      ((Element)v.get(181)).setAttribute("estado","false" );
      ((Element)v.get(181)).setAttribute("alt","" );
      ((Element)v.get(181)).setAttribute("codigo","" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(181)).setAttribute("accion","mipgndo1.retrocederPrimeraPagina();" );
      ((Element)v.get(33)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 33   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(182)).setAttribute("nombre","separa1" );
      ((Element)v.get(182)).setAttribute("x","59" );
      ((Element)v.get(182)).setAttribute("y","445" );
      ((Element)v.get(182)).setAttribute("ID","botonContenido" );
      ((Element)v.get(182)).setAttribute("img","separa_base" );
      ((Element)v.get(182)).setAttribute("tipo","0" );
      ((Element)v.get(182)).setAttribute("estado","false" );
      ((Element)v.get(182)).setAttribute("alt","" );
      ((Element)v.get(182)).setAttribute("codigo","" );
      ((Element)v.get(182)).setAttribute("accion","" );
      ((Element)v.get(33)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 33   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(183)).setAttribute("nombre","NoExitoso" );
      ((Element)v.get(183)).setAttribute("x","80" );
      ((Element)v.get(183)).setAttribute("y","446" );
      ((Element)v.get(183)).setAttribute("ID","botonContenido" );
      ((Element)v.get(183)).setAttribute("tipo","html" );
      ((Element)v.get(183)).setAttribute("estado","false" );
      ((Element)v.get(183)).setAttribute("cod","3281" );
      ((Element)v.get(183)).setAttribute("accion","botonNoExitoso();" );
      ((Element)v.get(183)).setAttribute("ontab","focalizaBotonHTML('botonContenido','Anular');" );
      ((Element)v.get(183)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar');" );
      ((Element)v.get(33)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 33   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(184)).setAttribute("nombre","Anular" );
      ((Element)v.get(184)).setAttribute("x","155" );
      ((Element)v.get(184)).setAttribute("y","446" );
      ((Element)v.get(184)).setAttribute("ID","botonContenido" );
      ((Element)v.get(184)).setAttribute("tipo","html" );
      ((Element)v.get(184)).setAttribute("estado","false" );
      ((Element)v.get(184)).setAttribute("cod","1598" );
      ((Element)v.get(184)).setAttribute("accion","botonAnular();" );
      ((Element)v.get(184)).setAttribute("ontab","focalizaBotonHTML('botonContenido','Detalle');" );
      ((Element)v.get(184)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','NoExitoso');" );
      ((Element)v.get(33)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 33   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(185)).setAttribute("nombre","Detalle" );
      ((Element)v.get(185)).setAttribute("x","206" );
      ((Element)v.get(185)).setAttribute("y","446" );
      ((Element)v.get(185)).setAttribute("ID","botonContenido" );
      ((Element)v.get(185)).setAttribute("tipo","html" );
      ((Element)v.get(185)).setAttribute("estado","false" );
      ((Element)v.get(185)).setAttribute("cod","3" );
      ((Element)v.get(185)).setAttribute("accion","botonDetalle();" );
      ((Element)v.get(185)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnBuscar');" );
      ((Element)v.get(185)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','Anular');" );
      ((Element)v.get(33)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:33   */
      /* Termina nodo:10   */


   }

}

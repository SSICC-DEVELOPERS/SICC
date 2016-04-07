
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_matriz_reemplazos_consultar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_matriz_reemplazos_consultar" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar matriz de reemplazos" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Consultar matriz de reemplazos" );
      ((Element)v.get(0)).setAttribute("cod","0176" );
      ((Element)v.get(0)).setAttribute("onload","inicializar();" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_matriz_reemplazos_consultar.js" );
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
      ((Element)v.get(7)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","hidOidFacturacion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hidCodigoVenta" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hidDescripcion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(13)).setAttribute("valor","1" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hPais" );
      ((Element)v.get(14)).setAttribute("valor","1" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","casodeuso" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(16)).setAttribute("nombre","capaFormulario" );
      ((Element)v.get(16)).setAttribute("x","0" );
      ((Element)v.get(16)).setAttribute("y","0" );
      ((Element)v.get(5)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("table"));
      ((Element)v.get(17)).setAttribute("width","100%" );
      ((Element)v.get(17)).setAttribute("border","0" );
      ((Element)v.get(17)).setAttribute("cellspacing","0" );
      ((Element)v.get(17)).setAttribute("cellpadding","0" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","12" );
      ((Element)v.get(19)).setAttribute("align","center" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(20)).setAttribute("height","12" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:21 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","750" );
      ((Element)v.get(18)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(22)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:23 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(18)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("height","1" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */
      /* Termina nodo:18   */

      /* Empieza nodo:25 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(30)).setAttribute("class","legend" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(31)).setAttribute("nombre","lblCriteriosbusqueda" );
      ((Element)v.get(31)).setAttribute("ancho","150" );
      ((Element)v.get(31)).setAttribute("alto","13" );
      ((Element)v.get(31)).setAttribute("filas","1" );
      ((Element)v.get(31)).setAttribute("valor","Criterios de búsqueda" );
      ((Element)v.get(31)).setAttribute("id","legend" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("table"));
      ((Element)v.get(32)).setAttribute("width","100%" );
      ((Element)v.get(32)).setAttribute("border","0" );
      ((Element)v.get(32)).setAttribute("align","center" );
      ((Element)v.get(32)).setAttribute("cellspacing","0" );
      ((Element)v.get(32)).setAttribute("cellpadding","0" );
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).setAttribute("colspan","4" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).setAttribute("width","8" );
      ((Element)v.get(35)).setAttribute("height","8" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:36 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).setAttribute("width","8" );
      ((Element)v.get(38)).setAttribute("height","8" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(40)).setAttribute("nombre","lblCodigoVentaProducto" );
      ((Element)v.get(40)).setAttribute("ancho","105" );
      ((Element)v.get(40)).setAttribute("alto","13" );
      ((Element)v.get(40)).setAttribute("filas","1" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(40)).setAttribute("id","datosTitle" );
      ((Element)v.get(40)).setAttribute("cod","602" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","25" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(44)).setAttribute("nombre","lblDescripcionProducto" );
      ((Element)v.get(44)).setAttribute("ancho","120" );
      ((Element)v.get(44)).setAttribute("alto","13" );
      ((Element)v.get(44)).setAttribute("filas","1" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(44)).setAttribute("id","datosTitle" );
      ((Element)v.get(44)).setAttribute("cod","338" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).setAttribute("width","100%" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(36)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","8" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:36   */

      /* Empieza nodo:47 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(47)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(51)).setAttribute("nombre","lblCodigoVentaXX" );
      ((Element)v.get(51)).setAttribute("ancho","110" );
      ((Element)v.get(51)).setAttribute("alto","17" );
      ((Element)v.get(51)).setAttribute("filas","1" );
      ((Element)v.get(51)).setAttribute("id","datosCampos" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","25" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("valign","bottom" );
      ((Element)v.get(47)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(55)).setAttribute("nombre","lblDescripcionXX" );
      ((Element)v.get(55)).setAttribute("ancho","250" );
      ((Element)v.get(55)).setAttribute("alto","17" );
      ((Element)v.get(55)).setAttribute("filas","1" );
      ((Element)v.get(55)).setAttribute("id","datosCampos" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:47   */

      /* Empieza nodo:56 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("colspan","4" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:32   */
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:59 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","12" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:25   */

      /* Empieza nodo:61 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("table"));
      ((Element)v.get(66)).setAttribute("width","100%" );
      ((Element)v.get(66)).setAttribute("border","0" );
      ((Element)v.get(66)).setAttribute("align","center" );
      ((Element)v.get(66)).setAttribute("cellspacing","0" );
      ((Element)v.get(66)).setAttribute("cellpadding","0" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("class","botonera" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(69)).setAttribute("nombre","btnBuscarProductoPrincipal" );
      ((Element)v.get(69)).setAttribute("ID","botonContenido" );
      ((Element)v.get(69)).setAttribute("tipo","html" );
      ((Element)v.get(69)).setAttribute("accion","cargarAccion('buscarProductoPrincipal');" );
      ((Element)v.get(69)).setAttribute("estado","false" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).setAttribute("cod","431" );
      ((Element)v.get(69)).setAttribute("ontab","focalizaTab(1);" );
      ((Element)v.get(69)).setAttribute("onshtab","focalizaTabShift(1);" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 68   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(70)).setAttribute("nombre","btnBuscarProductoRemmplazos" );
      ((Element)v.get(70)).setAttribute("ID","botonContenido" );
      ((Element)v.get(70)).setAttribute("tipo","html" );
      ((Element)v.get(70)).setAttribute("accion","cargarAccion('buscarProductosReemplazo');" );
      ((Element)v.get(70)).setAttribute("estado","false" );
      ((Element)v.get(70)).setAttribute("cod","521" );
      ((Element)v.get(70)).setAttribute("ontab","focalizaTab(2);" );
      ((Element)v.get(70)).setAttribute("onshtab","focalizaTabShift(2);" );
      ((Element)v.get(68)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:71 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(72)).setAttribute("height","12" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:61   */

      /* Empieza nodo:73 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("width","12" );
      ((Element)v.get(74)).setAttribute("align","center" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","12" );
      ((Element)v.get(75)).setAttribute("height","24" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("width","750" );
      ((Element)v.get(73)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","12" );
      ((Element)v.get(73)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","12" );
      ((Element)v.get(79)).setAttribute("height","24" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:73   */
      /* Termina nodo:17   */

      /* Empieza nodo:80 / Elemento padre: 16   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(80)).setAttribute("nombre","capaTitulo" );
      ((Element)v.get(80)).setAttribute("alto","50" );
      ((Element)v.get(80)).setAttribute("ancho","100%" );
      ((Element)v.get(80)).setAttribute("colorf","" );
      ((Element)v.get(80)).setAttribute("borde","0" );
      ((Element)v.get(80)).setAttribute("imagenf","" );
      ((Element)v.get(80)).setAttribute("repeat","" );
      ((Element)v.get(80)).setAttribute("padding","" );
      ((Element)v.get(80)).setAttribute("visibilidad","visible" );
      ((Element)v.get(80)).setAttribute("contravsb","" );
      ((Element)v.get(80)).setAttribute("x","0" );
      ((Element)v.get(80)).setAttribute("y","120" );
      ((Element)v.get(80)).setAttribute("zindex","" );
      ((Element)v.get(16)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("table"));
      ((Element)v.get(81)).setAttribute("width","100%" );
      ((Element)v.get(81)).setAttribute("border","0" );
      ((Element)v.get(81)).setAttribute("align","center" );
      ((Element)v.get(81)).setAttribute("cellspacing","0" );
      ((Element)v.get(81)).setAttribute("cellpadding","0" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("width","12" );
      ((Element)v.get(83)).setAttribute("align","center" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","12" );
      ((Element)v.get(84)).setAttribute("height","1" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("width","750" );
      ((Element)v.get(82)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("width","1" );
      ((Element)v.get(82)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(88)).setAttribute("width","1" );
      ((Element)v.get(88)).setAttribute("height","1" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:82   */

      /* Empieza nodo:89 / Elemento padre: 81   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(81)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("table"));
      ((Element)v.get(94)).setAttribute("width","100%" );
      ((Element)v.get(94)).setAttribute("border","0" );
      ((Element)v.get(94)).setAttribute("align","center" );
      ((Element)v.get(94)).setAttribute("cellspacing","0" );
      ((Element)v.get(94)).setAttribute("cellpadding","0" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("bgcolor","#CCCCCC" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("img"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","4" );
      ((Element)v.get(97)).setAttribute("height","1" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("bgcolor","#CCCCCC" );
      ((Element)v.get(98)).setAttribute("valign","middle" );
      ((Element)v.get(98)).setAttribute("height","20" );
      ((Element)v.get(95)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(99)).setAttribute("nombre","lbltitulo" );
      ((Element)v.get(99)).setAttribute("ancho","396" );
      ((Element)v.get(99)).setAttribute("alto","13" );
      ((Element)v.get(99)).setAttribute("filas","1" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(99)).setAttribute("id","datosTitle" );
      ((Element)v.get(99)).setAttribute("cod","00135" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:100 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("width","12" );
      ((Element)v.get(89)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","12" );
      ((Element)v.get(101)).setAttribute("height","12" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:89   */

      /* Empieza nodo:102 / Elemento padre: 81   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(81)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","12" );
      ((Element)v.get(103)).setAttribute("align","center" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","12" );
      ((Element)v.get(104)).setAttribute("height","1" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("width","750" );
      ((Element)v.get(102)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("width","1" );
      ((Element)v.get(102)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","1" );
      ((Element)v.get(108)).setAttribute("height","1" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:102   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:109 / Elemento padre: 16   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(109)).setAttribute("nombre","listado1" );
      ((Element)v.get(109)).setAttribute("ancho","404" );
      ((Element)v.get(109)).setAttribute("alto","290" );
      ((Element)v.get(109)).setAttribute("x","12" );
      ((Element)v.get(109)).setAttribute("y","145" );
      ((Element)v.get(109)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(109)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(16)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(110)).setAttribute("precarga","S" );
      ((Element)v.get(110)).setAttribute("conROver","S" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(111)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(111)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(111)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(111)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 110   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(112)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(112)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(112)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(112)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(110)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:110   */

      /* Empieza nodo:113 / Elemento padre: 109   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(109)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(114)).setAttribute("borde","1" );
      ((Element)v.get(114)).setAttribute("horizDatos","1" );
      ((Element)v.get(114)).setAttribute("horizCabecera","1" );
      ((Element)v.get(114)).setAttribute("vertical","0" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 113   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(115)).setAttribute("borde","#999999" );
      ((Element)v.get(115)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(115)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(115)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(115)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(113)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:113   */

      /* Empieza nodo:116 / Elemento padre: 109   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(116)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(116)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(116)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(116)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(116)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(109)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("ancho","120" );
      ((Element)v.get(117)).setAttribute("minimizable","S" );
      ((Element)v.get(117)).setAttribute("minimizada","N" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("ancho","120" );
      ((Element)v.get(118)).setAttribute("minimizable","S" );
      ((Element)v.get(118)).setAttribute("minimizada","N" );
      ((Element)v.get(116)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("ancho","175" );
      ((Element)v.get(119)).setAttribute("minimizable","S" );
      ((Element)v.get(119)).setAttribute("minimizada","N" );
      ((Element)v.get(116)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("ancho","120" );
      ((Element)v.get(120)).setAttribute("minimizable","S" );
      ((Element)v.get(120)).setAttribute("minimizada","N" );
      ((Element)v.get(116)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("ancho","160" );
      ((Element)v.get(121)).setAttribute("minimizable","S" );
      ((Element)v.get(121)).setAttribute("minimizada","N" );
      ((Element)v.get(116)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("ancho","160" );
      ((Element)v.get(122)).setAttribute("minimizable","S" );
      ((Element)v.get(122)).setAttribute("minimizada","N" );
      ((Element)v.get(116)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("ancho","160" );
      ((Element)v.get(123)).setAttribute("minimizable","S" );
      ((Element)v.get(123)).setAttribute("minimizada","N" );
      ((Element)v.get(116)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("ancho","160" );
      ((Element)v.get(124)).setAttribute("minimizable","S" );
      ((Element)v.get(124)).setAttribute("minimizada","N" );
      ((Element)v.get(116)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("ancho","160" );
      ((Element)v.get(125)).setAttribute("minimizable","S" );
      ((Element)v.get(125)).setAttribute("minimizada","N" );
      ((Element)v.get(116)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("ancho","160" );
      ((Element)v.get(126)).setAttribute("minimizable","S" );
      ((Element)v.get(126)).setAttribute("minimizada","N" );
      ((Element)v.get(116)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("ancho","140" );
      ((Element)v.get(127)).setAttribute("minimizable","S" );
      ((Element)v.get(127)).setAttribute("minimizada","N" );
      ((Element)v.get(127)).setAttribute("orden","numerico" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(116)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("ancho","65" );
      ((Element)v.get(128)).setAttribute("minimizable","S" );
      ((Element)v.get(128)).setAttribute("minimizada","N" );
      ((Element)v.get(116)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:116   */

      /* Empieza nodo:129 / Elemento padre: 109   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(129)).setAttribute("alto","20" );
      ((Element)v.get(129)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(129)).setAttribute("imgFondo","" );
      ((Element)v.get(129)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(109)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("colFondo","" );
      ((Element)v.get(130)).setAttribute("ID","EstCab" );
      ((Element)v.get(130)).setAttribute("align","center" );
      ((Element)v.get(130)).setAttribute("cod","602" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Elemento padre:130 / Elemento actual: 131   */
      v.add(doc.createTextNode("Cód. venta producto"));
      ((Element)v.get(130)).appendChild((Text)v.get(131));

      /* Termina nodo Texto:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("colFondo","" );
      ((Element)v.get(132)).setAttribute("ID","EstCab" );
      ((Element)v.get(132)).setAttribute("cod","338" );
      ((Element)v.get(129)).appendChild((Element)v.get(132));

      /* Elemento padre:132 / Elemento actual: 133   */
      v.add(doc.createTextNode("Descripción producto"));
      ((Element)v.get(132)).appendChild((Text)v.get(133));

      /* Termina nodo Texto:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("colFondo","" );
      ((Element)v.get(134)).setAttribute("ID","EstCab" );
      ((Element)v.get(134)).setAttribute("cod","522" );
      ((Element)v.get(129)).appendChild((Element)v.get(134));

      /* Elemento padre:134 / Elemento actual: 135   */
      v.add(doc.createTextNode("Cód. venta reemplazo"));
      ((Element)v.get(134)).appendChild((Text)v.get(135));

      /* Termina nodo Texto:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("colFondo","" );
      ((Element)v.get(136)).setAttribute("ID","EstCab" );
      ((Element)v.get(136)).setAttribute("cod","338" );
      ((Element)v.get(129)).appendChild((Element)v.get(136));

      /* Elemento padre:136 / Elemento actual: 137   */
      v.add(doc.createTextNode("Descripción producto"));
      ((Element)v.get(136)).appendChild((Text)v.get(137));

      /* Termina nodo Texto:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("colFondo","" );
      ((Element)v.get(138)).setAttribute("ID","EstCab" );
      ((Element)v.get(138)).setAttribute("cod","109" );
      ((Element)v.get(129)).appendChild((Element)v.get(138));

      /* Elemento padre:138 / Elemento actual: 139   */
      v.add(doc.createTextNode("Región"));
      ((Element)v.get(138)).appendChild((Text)v.get(139));

      /* Termina nodo Texto:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(140)).setAttribute("colFondo","" );
      ((Element)v.get(140)).setAttribute("ID","EstCab" );
      ((Element)v.get(140)).setAttribute("cod","143" );
      ((Element)v.get(129)).appendChild((Element)v.get(140));

      /* Elemento padre:140 / Elemento actual: 141   */
      v.add(doc.createTextNode("Zona"));
      ((Element)v.get(140)).appendChild((Text)v.get(141));

      /* Termina nodo Texto:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("colFondo","" );
      ((Element)v.get(142)).setAttribute("ID","EstCab" );
      ((Element)v.get(142)).setAttribute("cod","393" );
      ((Element)v.get(129)).appendChild((Element)v.get(142));

      /* Elemento padre:142 / Elemento actual: 143   */
      v.add(doc.createTextNode("Tipo Cliente"));
      ((Element)v.get(142)).appendChild((Text)v.get(143));

      /* Termina nodo Texto:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("colFondo","" );
      ((Element)v.get(144)).setAttribute("ID","EstCab" );
      ((Element)v.get(144)).setAttribute("cod","595" );
      ((Element)v.get(129)).appendChild((Element)v.get(144));

      /* Elemento padre:144 / Elemento actual: 145   */
      v.add(doc.createTextNode("SubTipo Cliente"));
      ((Element)v.get(144)).appendChild((Text)v.get(145));

      /* Termina nodo Texto:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("colFondo","" );
      ((Element)v.get(146)).setAttribute("ID","EstCab" );
      ((Element)v.get(146)).setAttribute("cod","756" );
      ((Element)v.get(129)).appendChild((Element)v.get(146));

      /* Elemento padre:146 / Elemento actual: 147   */
      v.add(doc.createTextNode("Tipo Clasificacion"));
      ((Element)v.get(146)).appendChild((Text)v.get(147));

      /* Termina nodo Texto:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("colFondo","" );
      ((Element)v.get(148)).setAttribute("ID","EstCab" );
      ((Element)v.get(148)).setAttribute("cod","550" );
      ((Element)v.get(129)).appendChild((Element)v.get(148));

      /* Elemento padre:148 / Elemento actual: 149   */
      v.add(doc.createTextNode("Clasificacion"));
      ((Element)v.get(148)).appendChild((Text)v.get(149));

      /* Termina nodo Texto:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("colFondo","" );
      ((Element)v.get(150)).setAttribute("ID","EstCab" );
      ((Element)v.get(150)).setAttribute("cod","524" );
      ((Element)v.get(129)).appendChild((Element)v.get(150));

      /* Elemento padre:150 / Elemento actual: 151   */
      v.add(doc.createTextNode("Antes/Después cuadre"));
      ((Element)v.get(150)).appendChild((Text)v.get(151));

      /* Termina nodo Texto:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 129   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("colFondo","" );
      ((Element)v.get(152)).setAttribute("ID","EstCab" );
      ((Element)v.get(152)).setAttribute("cod","531" );
      ((Element)v.get(129)).appendChild((Element)v.get(152));

      /* Elemento padre:152 / Elemento actual: 153   */
      v.add(doc.createTextNode("Mensaje"));
      ((Element)v.get(152)).appendChild((Text)v.get(153));

      /* Termina nodo Texto:153   */
      /* Termina nodo:152   */
      /* Termina nodo:129   */

      /* Empieza nodo:154 / Elemento padre: 109   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(154)).setAttribute("alto","22" );
      ((Element)v.get(154)).setAttribute("accion","" );
      ((Element)v.get(154)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(154)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(154)).setAttribute("maxSel","-1" );
      ((Element)v.get(154)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(154)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(154)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(154)).setAttribute("onLoad","" );
      ((Element)v.get(154)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(109)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("tipo","texto" );
      ((Element)v.get(155)).setAttribute("ID","EstDat" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("tipo","texto" );
      ((Element)v.get(156)).setAttribute("ID","EstDat2" );
      ((Element)v.get(154)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("tipo","texto" );
      ((Element)v.get(157)).setAttribute("ID","EstDat" );
      ((Element)v.get(154)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("tipo","texto" );
      ((Element)v.get(158)).setAttribute("ID","EstDat2" );
      ((Element)v.get(154)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("tipo","texto" );
      ((Element)v.get(159)).setAttribute("ID","EstDat" );
      ((Element)v.get(154)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("tipo","texto" );
      ((Element)v.get(160)).setAttribute("ID","EstDat2" );
      ((Element)v.get(154)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("tipo","texto" );
      ((Element)v.get(161)).setAttribute("ID","EstDat" );
      ((Element)v.get(154)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("tipo","texto" );
      ((Element)v.get(162)).setAttribute("ID","EstDat2" );
      ((Element)v.get(154)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("tipo","texto" );
      ((Element)v.get(163)).setAttribute("ID","EstDat" );
      ((Element)v.get(154)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("tipo","texto" );
      ((Element)v.get(164)).setAttribute("ID","EstDat2" );
      ((Element)v.get(154)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("tipo","texto" );
      ((Element)v.get(165)).setAttribute("ID","EstDat" );
      ((Element)v.get(154)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("tipo","texto" );
      ((Element)v.get(166)).setAttribute("ID","EstDat2" );
      ((Element)v.get(154)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:154   */

      /* Empieza nodo:167 / Elemento padre: 109   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(109)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 109   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(168)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(168)).setAttribute("ancho","680" );
      ((Element)v.get(168)).setAttribute("sep","$" );
      ((Element)v.get(168)).setAttribute("x","12" );
      ((Element)v.get(168)).setAttribute("class","botonera" );
      ((Element)v.get(168)).setAttribute("y","396" );
      ((Element)v.get(168)).setAttribute("control","|" );
      ((Element)v.get(168)).setAttribute("conector","" );
      ((Element)v.get(168)).setAttribute("rowset","" );
      ((Element)v.get(168)).setAttribute("cargainicial","N" );
      ((Element)v.get(168)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'mostrarLista(ultima, rowset)')" );
      ((Element)v.get(109)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(169)).setAttribute("nombre","primera1" );
      ((Element)v.get(169)).setAttribute("x","23" );
      ((Element)v.get(169)).setAttribute("y","401" );
      ((Element)v.get(169)).setAttribute("ID","botonContenido" );
      ((Element)v.get(169)).setAttribute("img","primera_on" );
      ((Element)v.get(169)).setAttribute("tipo","-2" );
      ((Element)v.get(169)).setAttribute("estado","false" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(169)).setAttribute("alt","" );
      ((Element)v.get(169)).setAttribute("codigo","" );
      ((Element)v.get(169)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 168   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(170)).setAttribute("nombre","ret1" );
      ((Element)v.get(170)).setAttribute("x","45" );
      ((Element)v.get(170)).setAttribute("y","401" );
      ((Element)v.get(170)).setAttribute("ID","botonContenido" );
      ((Element)v.get(170)).setAttribute("img","retroceder_on" );
      ((Element)v.get(170)).setAttribute("tipo","0" );
      ((Element)v.get(170)).setAttribute("estado","false" );
      ((Element)v.get(170)).setAttribute("alt","" );
      ((Element)v.get(170)).setAttribute("codigo","" );
      ((Element)v.get(170)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(168)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 168   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(171)).setAttribute("nombre","ava1" );
      ((Element)v.get(171)).setAttribute("x","60" );
      ((Element)v.get(171)).setAttribute("y","401" );
      ((Element)v.get(171)).setAttribute("ID","botonContenido" );
      ((Element)v.get(171)).setAttribute("img","avanzar_on" );
      ((Element)v.get(171)).setAttribute("tipo","0" );
      ((Element)v.get(171)).setAttribute("estado","false" );
      ((Element)v.get(171)).setAttribute("alt","" );
      ((Element)v.get(171)).setAttribute("codigo","" );
      ((Element)v.get(171)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(168)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:168   */
      /* Termina nodo:109   */
      /* Termina nodo:16   */
      /* Termina nodo:5   */

      /* Empieza nodo:172 / Elemento padre: 0   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(172)).setAttribute("nombre","capaFinal" );
      ((Element)v.get(172)).setAttribute("alto","18" );
      ((Element)v.get(172)).setAttribute("ancho","100%" );
      ((Element)v.get(172)).setAttribute("colorf","" );
      ((Element)v.get(172)).setAttribute("borde","0" );
      ((Element)v.get(172)).setAttribute("imagenf","" );
      ((Element)v.get(172)).setAttribute("repeat","" );
      ((Element)v.get(172)).setAttribute("padding","" );
      ((Element)v.get(172)).setAttribute("visibilidad","visible" );
      ((Element)v.get(172)).setAttribute("contravsb","" );
      ((Element)v.get(172)).setAttribute("x","0" );
      ((Element)v.get(172)).setAttribute("y","460" );
      ((Element)v.get(172)).setAttribute("zindex","" );
      ((Element)v.get(0)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */


   }

}

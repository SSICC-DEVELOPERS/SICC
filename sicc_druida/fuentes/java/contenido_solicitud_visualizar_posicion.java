
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_solicitud_visualizar_posicion  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_solicitud_visualizar_posicion" );
      ((Element)v.get(0)).setAttribute("cod","0922" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar Solicitudes" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

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
      ((Element)v.get(5)).setAttribute("src","contenido_solicitud_visualizar_posicion.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hPais" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hOidCabeceraSolicitud" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hInformacionBasicaPosicion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hInformacionProductosPosicion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hInformacionCantidadesPosicion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hInformacionEconomicaPosicion" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(20)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(20)).setAttribute("x","0" );
      ((Element)v.get(20)).setAttribute("y","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("table"));
      ((Element)v.get(21)).setAttribute("width","100%" );
      ((Element)v.get(21)).setAttribute("border","0" );
      ((Element)v.get(21)).setAttribute("cellspacing","0" );
      ((Element)v.get(21)).setAttribute("cellpadding","0" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(23)).setAttribute("align","center" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("height","12" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","750" );
      ((Element)v.get(22)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(22)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(28)).setAttribute("height","1" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */
      /* Termina nodo:22   */

      /* Empieza nodo:29 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(34)).setAttribute("class","legend" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(35)).setAttribute("nombre","lblDatosDetalle" );
      ((Element)v.get(35)).setAttribute("alto","13" );
      ((Element)v.get(35)).setAttribute("filas","1" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(35)).setAttribute("id","legend" );
      ((Element)v.get(35)).setAttribute("cod","00133" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("table"));
      ((Element)v.get(36)).setAttribute("width","100%" );
      ((Element)v.get(36)).setAttribute("border","0" );
      ((Element)v.get(36)).setAttribute("align","center" );
      ((Element)v.get(36)).setAttribute("cellspacing","0" );
      ((Element)v.get(36)).setAttribute("cellpadding","0" );
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("table"));
      ((Element)v.get(39)).setAttribute("width","500" );
      ((Element)v.get(39)).setAttribute("border","0" );
      ((Element)v.get(39)).setAttribute("align","left" );
      ((Element)v.get(39)).setAttribute("cellspacing","0" );
      ((Element)v.get(39)).setAttribute("cellpadding","0" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("colspan","3" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","8" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:43 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","8" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblBloqueInformacion" );
      ((Element)v.get(47)).setAttribute("alto","13" );
      ((Element)v.get(47)).setAttribute("filas","1" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(47)).setAttribute("id","datosTitle" );
      ((Element)v.get(47)).setAttribute("cod","2353" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","100%" );
      ((Element)v.get(43)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:43   */

      /* Empieza nodo:50 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","8" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(53)).setAttribute("valign","top" );
      ((Element)v.get(50)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(54)).setAttribute("nombre","cbBloqueInformacion" );
      ((Element)v.get(54)).setAttribute("id","datosCampos" );
      ((Element)v.get(54)).setAttribute("size","1" );
      ((Element)v.get(54)).setAttribute("multiple","N" );
      ((Element)v.get(54)).setAttribute("req","N" );
      ((Element)v.get(54)).setAttribute("valorinicial","" );
      ((Element)v.get(54)).setAttribute("textoinicial","" );
      ((Element)v.get(54)).setAttribute("ontab","focButton('btnAceptar')" );
      ((Element)v.get(54)).setAttribute("onshtab","focButton('btnAceptar')" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:56 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("width","100%" );
      ((Element)v.get(50)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:50   */

      /* Empieza nodo:58 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("colspan","3" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","7" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:61 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:29   */

      /* Empieza nodo:63 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("table"));
      ((Element)v.get(68)).setAttribute("width","100%" );
      ((Element)v.get(68)).setAttribute("border","0" );
      ((Element)v.get(68)).setAttribute("align","left" );
      ((Element)v.get(68)).setAttribute("cellspacing","0" );
      ((Element)v.get(68)).setAttribute("cellpadding","0" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("class","botonera" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(71)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(71)).setAttribute("ID","botonContenido" );
      ((Element)v.get(71)).setAttribute("tipo","html" );
      ((Element)v.get(71)).setAttribute("accion","accionAceptar()" );
      ((Element)v.get(71)).setAttribute("estado","false" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(71)).setAttribute("cod","12" );
      ((Element)v.get(71)).setAttribute("ontab","focaliza('frmFormulario.cbBloqueInformacion')" );
      ((Element)v.get(71)).setAttribute("onshtab","focaliza('frmFormulario.cbBloqueInformacion')" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:72 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","8" );
      ((Element)v.get(73)).setAttribute("height","12" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:63   */

      /* Empieza nodo:74 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","12" );
      ((Element)v.get(75)).setAttribute("align","center" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","12" );
      ((Element)v.get(76)).setAttribute("height","12" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","756" );
      ((Element)v.get(74)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("width","12" );
      ((Element)v.get(74)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","12" );
      ((Element)v.get(80)).setAttribute("height","1" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:74   */
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:81 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(81)).setAttribute("nombre","listado1" );
      ((Element)v.get(81)).setAttribute("ancho","504" );
      ((Element)v.get(81)).setAttribute("alto","317" );
      ((Element)v.get(81)).setAttribute("x","12" );
      ((Element)v.get(81)).setAttribute("y","123" );
      ((Element)v.get(81)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(81)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(82)).setAttribute("precarga","S" );
      ((Element)v.get(82)).setAttribute("conROver","S" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(83)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(83)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(83)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(83)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 82   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(84)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(84)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(84)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(84)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(82)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 82   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(85)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(85)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(82)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:82   */

      /* Empieza nodo:86 / Elemento padre: 81   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(81)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(87)).setAttribute("borde","1" );
      ((Element)v.get(87)).setAttribute("horizDatos","1" );
      ((Element)v.get(87)).setAttribute("horizCabecera","1" );
      ((Element)v.get(87)).setAttribute("vertical","1" );
      ((Element)v.get(87)).setAttribute("horizTitulo","1" );
      ((Element)v.get(87)).setAttribute("horizBase","1" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 86   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(88)).setAttribute("borde","#999999" );
      ((Element)v.get(88)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(88)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(88)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(88)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(88)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(88)).setAttribute("horizBase","#999999" );
      ((Element)v.get(86)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:86   */

      /* Empieza nodo:89 / Elemento padre: 81   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(89)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(89)).setAttribute("alto","22" );
      ((Element)v.get(89)).setAttribute("imgFondo","" );
      ((Element)v.get(89)).setAttribute("cod","00575" );
      ((Element)v.get(89)).setAttribute("ID","datosTitle" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(81)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 81   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(90)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(90)).setAttribute("alto","22" );
      ((Element)v.get(90)).setAttribute("imgFondo","" );
      ((Element)v.get(81)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 81   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(91)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(91)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(91)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(91)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(91)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(91)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(81)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(92)).setAttribute("ancho","350" );
      ((Element)v.get(92)).setAttribute("minimizable","S" );
      ((Element)v.get(92)).setAttribute("minimizada","N" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 91   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(93)).setAttribute("ancho","350" );
      ((Element)v.get(93)).setAttribute("minimizable","S" );
      ((Element)v.get(93)).setAttribute("minimizada","N" );
      ((Element)v.get(91)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 91   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(94)).setAttribute("ancho","100" );
      ((Element)v.get(94)).setAttribute("minimizable","S" );
      ((Element)v.get(94)).setAttribute("minimizada","N" );
      ((Element)v.get(91)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:91   */

      /* Empieza nodo:95 / Elemento padre: 81   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(95)).setAttribute("alto","20" );
      ((Element)v.get(95)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(95)).setAttribute("imgFondo","" );
      ((Element)v.get(95)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(81)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(96)).setAttribute("colFondo","" );
      ((Element)v.get(96)).setAttribute("ID","EstCab" );
      ((Element)v.get(96)).setAttribute("cod","1426" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 95   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("colFondo","" );
      ((Element)v.get(97)).setAttribute("ID","EstCab" );
      ((Element)v.get(97)).setAttribute("cod","2175" );
      ((Element)v.get(95)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 95   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(98)).setAttribute("colFondo","" );
      ((Element)v.get(98)).setAttribute("ID","EstCab" );
      ((Element)v.get(98)).setAttribute("cod","1284" );
      ((Element)v.get(95)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:95   */

      /* Empieza nodo:99 / Elemento padre: 81   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(99)).setAttribute("alto","22" );
      ((Element)v.get(99)).setAttribute("accion","" );
      ((Element)v.get(99)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(99)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(99)).setAttribute("maxSel","-1" );
      ((Element)v.get(99)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(99)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(99)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(99)).setAttribute("onLoad","" );
      ((Element)v.get(99)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(81)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(100)).setAttribute("tipo","texto" );
      ((Element)v.get(100)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("tipo","texto" );
      ((Element)v.get(101)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(102)).setAttribute("tipo","texto" );
      ((Element)v.get(102)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:99   */

      /* Empieza nodo:103 / Elemento padre: 81   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(81)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 81   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(104)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(104)).setAttribute("ancho","504" );
      ((Element)v.get(104)).setAttribute("sep","$" );
      ((Element)v.get(104)).setAttribute("x","12" );
      ((Element)v.get(104)).setAttribute("class","botonera" );
      ((Element)v.get(104)).setAttribute("y","417" );
      ((Element)v.get(104)).setAttribute("control","|" );
      ((Element)v.get(104)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(104)).setAttribute("rowset","" );
      ((Element)v.get(104)).setAttribute("cargainicial","N" );
      ((Element)v.get(81)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(105)).setAttribute("nombre","ret1" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(105)).setAttribute("x","37" );
      ((Element)v.get(105)).setAttribute("y","421" );
      ((Element)v.get(105)).setAttribute("ID","botonContenido" );
      ((Element)v.get(105)).setAttribute("img","retroceder_on" );
      ((Element)v.get(105)).setAttribute("tipo","0" );
      ((Element)v.get(105)).setAttribute("estado","false" );
      ((Element)v.get(105)).setAttribute("alt","" );
      ((Element)v.get(105)).setAttribute("codigo","" );
      ((Element)v.get(105)).setAttribute("accion","mipgndo1.retroceder();" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 104   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(106)).setAttribute("nombre","ava1" );
      ((Element)v.get(106)).setAttribute("x","52" );
      ((Element)v.get(106)).setAttribute("y","421" );
      ((Element)v.get(106)).setAttribute("ID","botonContenido" );
      ((Element)v.get(106)).setAttribute("img","avanzar_on" );
      ((Element)v.get(106)).setAttribute("tipo","0" );
      ((Element)v.get(106)).setAttribute("estado","false" );
      ((Element)v.get(106)).setAttribute("alt","" );
      ((Element)v.get(106)).setAttribute("codigo","" );
      ((Element)v.get(106)).setAttribute("accion","mipgndo1.avanzar();" );
      ((Element)v.get(104)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:104   */
      /* Termina nodo:81   */

      /* Empieza nodo:107 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(107)).setAttribute("nombre","primera1" );
      ((Element)v.get(107)).setAttribute("x","20" );
      ((Element)v.get(107)).setAttribute("y","421" );
      ((Element)v.get(107)).setAttribute("ID","botonContenido" );
      ((Element)v.get(107)).setAttribute("img","primera_on" );
      ((Element)v.get(107)).setAttribute("tipo","0" );
      ((Element)v.get(107)).setAttribute("estado","false" );
      ((Element)v.get(107)).setAttribute("alt","" );
      ((Element)v.get(107)).setAttribute("codigo","" );
      ((Element)v.get(107)).setAttribute("accion","mipgndo1.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(108)).setAttribute("nombre","separa1" );
      ((Element)v.get(108)).setAttribute("x","59" );
      ((Element)v.get(108)).setAttribute("y","417" );
      ((Element)v.get(108)).setAttribute("ID","botonContenido" );
      ((Element)v.get(108)).setAttribute("img","separa_base" );
      ((Element)v.get(108)).setAttribute("tipo","0" );
      ((Element)v.get(108)).setAttribute("estado","false" );
      ((Element)v.get(108)).setAttribute("alt","" );
      ((Element)v.get(108)).setAttribute("codigo","" );
      ((Element)v.get(108)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(109)).setAttribute("nombre","listado2" );
      ((Element)v.get(109)).setAttribute("ancho","504" );
      ((Element)v.get(109)).setAttribute("alto","317" );
      ((Element)v.get(109)).setAttribute("x","12" );
      ((Element)v.get(109)).setAttribute("y","123" );
      ((Element)v.get(109)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(109)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(110)).setAttribute("precarga","S" );
      ((Element)v.get(110)).setAttribute("conROver","S" );
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

      /* Empieza nodo:113 / Elemento padre: 110   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(113)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(113)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(110)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:110   */

      /* Empieza nodo:114 / Elemento padre: 109   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(109)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(115)).setAttribute("borde","1" );
      ((Element)v.get(115)).setAttribute("horizDatos","1" );
      ((Element)v.get(115)).setAttribute("horizCabecera","1" );
      ((Element)v.get(115)).setAttribute("vertical","1" );
      ((Element)v.get(115)).setAttribute("horizTitulo","1" );
      ((Element)v.get(115)).setAttribute("horizBase","1" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 114   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(116)).setAttribute("borde","#999999" );
      ((Element)v.get(116)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(116)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(116)).setAttribute("horizDatos","#FFFFFF" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(116)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(116)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(116)).setAttribute("horizBase","#999999" );
      ((Element)v.get(114)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:114   */

      /* Empieza nodo:117 / Elemento padre: 109   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(117)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(117)).setAttribute("alto","22" );
      ((Element)v.get(117)).setAttribute("imgFondo","" );
      ((Element)v.get(117)).setAttribute("cod","00576" );
      ((Element)v.get(117)).setAttribute("ID","datosTitle" );
      ((Element)v.get(109)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 109   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(118)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(118)).setAttribute("alto","22" );
      ((Element)v.get(118)).setAttribute("imgFondo","" );
      ((Element)v.get(109)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 109   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(119)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(119)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(119)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(119)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(119)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(119)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(109)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("ancho","80" );
      ((Element)v.get(120)).setAttribute("minimizable","S" );
      ((Element)v.get(120)).setAttribute("minimizada","N" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("ancho","300" );
      ((Element)v.get(121)).setAttribute("minimizable","S" );
      ((Element)v.get(121)).setAttribute("minimizada","N" );
      ((Element)v.get(119)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("ancho","80" );
      ((Element)v.get(122)).setAttribute("minimizable","S" );
      ((Element)v.get(122)).setAttribute("minimizada","N" );
      ((Element)v.get(119)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("ancho","300" );
      ((Element)v.get(123)).setAttribute("minimizable","S" );
      ((Element)v.get(123)).setAttribute("minimizada","N" );
      ((Element)v.get(119)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:119   */

      /* Empieza nodo:124 / Elemento padre: 109   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(124)).setAttribute("alto","20" );
      ((Element)v.get(124)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(124)).setAttribute("imgFondo","" );
      ((Element)v.get(124)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(109)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("colFondo","" );
      ((Element)v.get(125)).setAttribute("ID","EstCab" );
      ((Element)v.get(125)).setAttribute("cod","336" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("colFondo","" );
      ((Element)v.get(126)).setAttribute("ID","EstCab" );
      ((Element)v.get(126)).setAttribute("cod","47" );
      ((Element)v.get(124)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("colFondo","" );
      ((Element)v.get(127)).setAttribute("ID","EstCab" );
      ((Element)v.get(127)).setAttribute("cod","337" );
      ((Element)v.get(124)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("colFondo","" );
      ((Element)v.get(128)).setAttribute("ID","EstCab" );
      ((Element)v.get(128)).setAttribute("cod","48" );
      ((Element)v.get(124)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:124   */

      /* Empieza nodo:129 / Elemento padre: 109   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(129)).setAttribute("alto","22" );
      ((Element)v.get(129)).setAttribute("accion","" );
      ((Element)v.get(129)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(129)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(129)).setAttribute("maxSel","-1" );
      ((Element)v.get(129)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(129)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(129)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(129)).setAttribute("onLoad","" );
      ((Element)v.get(129)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(109)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("tipo","texto" );
      ((Element)v.get(130)).setAttribute("ID","EstDat" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("tipo","texto" );
      ((Element)v.get(131)).setAttribute("ID","EstDat2" );
      ((Element)v.get(129)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 129   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("tipo","texto" );
      ((Element)v.get(132)).setAttribute("ID","EstDat" );
      ((Element)v.get(129)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("tipo","texto" );
      ((Element)v.get(133)).setAttribute("ID","EstDat2" );
      ((Element)v.get(129)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:129   */

      /* Empieza nodo:134 / Elemento padre: 109   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(109)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 109   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(135)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(135)).setAttribute("ancho","504" );
      ((Element)v.get(135)).setAttribute("sep","$" );
      ((Element)v.get(135)).setAttribute("x","12" );
      ((Element)v.get(135)).setAttribute("class","botonera" );
      ((Element)v.get(135)).setAttribute("y","417" );
      ((Element)v.get(135)).setAttribute("control","|" );
      ((Element)v.get(135)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(135)).setAttribute("rowset","" );
      ((Element)v.get(135)).setAttribute("cargainicial","N" );
      ((Element)v.get(109)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(136)).setAttribute("nombre","ret2" );
      ((Element)v.get(136)).setAttribute("x","37" );
      ((Element)v.get(136)).setAttribute("y","421" );
      ((Element)v.get(136)).setAttribute("ID","botonContenido" );
      ((Element)v.get(136)).setAttribute("img","retroceder_on" );
      ((Element)v.get(136)).setAttribute("tipo","0" );
      ((Element)v.get(136)).setAttribute("estado","false" );
      ((Element)v.get(136)).setAttribute("alt","" );
      ((Element)v.get(136)).setAttribute("codigo","" );
      ((Element)v.get(136)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 135   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(137)).setAttribute("nombre","ava2" );
      ((Element)v.get(137)).setAttribute("x","52" );
      ((Element)v.get(137)).setAttribute("y","421" );
      ((Element)v.get(137)).setAttribute("ID","botonContenido" );
      ((Element)v.get(137)).setAttribute("img","avanzar_on" );
      ((Element)v.get(137)).setAttribute("tipo","0" );
      ((Element)v.get(137)).setAttribute("estado","false" );
      ((Element)v.get(137)).setAttribute("alt","" );
      ((Element)v.get(137)).setAttribute("codigo","" );
      ((Element)v.get(137)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(135)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:135   */
      /* Termina nodo:109   */

      /* Empieza nodo:138 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(138)).setAttribute("nombre","primera2" );
      ((Element)v.get(138)).setAttribute("x","20" );
      ((Element)v.get(138)).setAttribute("y","421" );
      ((Element)v.get(138)).setAttribute("ID","botonContenido" );
      ((Element)v.get(138)).setAttribute("img","primera_on" );
      ((Element)v.get(138)).setAttribute("tipo","-2" );
      ((Element)v.get(138)).setAttribute("estado","false" );
      ((Element)v.get(138)).setAttribute("alt","" );
      ((Element)v.get(138)).setAttribute("codigo","" );
      ((Element)v.get(138)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(139)).setAttribute("nombre","separa2" );
      ((Element)v.get(139)).setAttribute("x","59" );
      ((Element)v.get(139)).setAttribute("y","417" );
      ((Element)v.get(139)).setAttribute("ID","botonContenido" );
      ((Element)v.get(139)).setAttribute("img","separa_base" );
      ((Element)v.get(139)).setAttribute("tipo","0" );
      ((Element)v.get(139)).setAttribute("estado","false" );
      ((Element)v.get(139)).setAttribute("alt","" );
      ((Element)v.get(139)).setAttribute("codigo","" );
      ((Element)v.get(139)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(140)).setAttribute("nombre","listado3" );
      ((Element)v.get(140)).setAttribute("ancho","504" );
      ((Element)v.get(140)).setAttribute("alto","317" );
      ((Element)v.get(140)).setAttribute("x","12" );
      ((Element)v.get(140)).setAttribute("y","123" );
      ((Element)v.get(140)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(140)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(141)).setAttribute("precarga","S" );
      ((Element)v.get(141)).setAttribute("conROver","S" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(142)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(142)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(142)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(142)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 141   */
      v.add(doc.createElement("BTNMINIMIZAR"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(143)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(143)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(143)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(143)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(141)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 141   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(144)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(144)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(141)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:141   */

      /* Empieza nodo:145 / Elemento padre: 140   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(140)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(146)).setAttribute("borde","1" );
      ((Element)v.get(146)).setAttribute("horizDatos","1" );
      ((Element)v.get(146)).setAttribute("horizCabecera","1" );
      ((Element)v.get(146)).setAttribute("vertical","1" );
      ((Element)v.get(146)).setAttribute("horizTitulo","1" );
      ((Element)v.get(146)).setAttribute("horizBase","1" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 145   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(147)).setAttribute("borde","#999999" );
      ((Element)v.get(147)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(147)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(147)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(147)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(147)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(147)).setAttribute("horizBase","#999999" );
      ((Element)v.get(145)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:145   */

      /* Empieza nodo:148 / Elemento padre: 140   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(148)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(148)).setAttribute("alto","22" );
      ((Element)v.get(148)).setAttribute("imgFondo","" );
      ((Element)v.get(148)).setAttribute("cod","00577" );
      ((Element)v.get(148)).setAttribute("ID","datosTitle" );
      ((Element)v.get(140)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 140   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(149)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(149)).setAttribute("alto","22" );
      ((Element)v.get(149)).setAttribute("imgFondo","" );
      ((Element)v.get(140)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 140   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(150)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(150)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(150)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(150)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(150)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(150)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(140)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("ancho","130" );
      ((Element)v.get(151)).setAttribute("minimizable","S" );
      ((Element)v.get(151)).setAttribute("minimizada","N" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 150   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("ancho","100" );
      ((Element)v.get(152)).setAttribute("minimizable","S" );
      ((Element)v.get(152)).setAttribute("minimizada","N" );
      ((Element)v.get(150)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 150   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("ancho","100" );
      ((Element)v.get(153)).setAttribute("minimizable","S" );
      ((Element)v.get(153)).setAttribute("minimizada","N" );
      ((Element)v.get(150)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 150   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("ancho","110" );
      ((Element)v.get(154)).setAttribute("minimizable","S" );
      ((Element)v.get(154)).setAttribute("minimizada","N" );
      ((Element)v.get(150)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 150   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("ancho","130" );
      ((Element)v.get(155)).setAttribute("minimizable","S" );
      ((Element)v.get(155)).setAttribute("minimizada","N" );
      ((Element)v.get(150)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 150   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("ancho","140" );
      ((Element)v.get(156)).setAttribute("minimizable","S" );
      ((Element)v.get(156)).setAttribute("minimizada","N" );
      ((Element)v.get(150)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 150   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("ancho","110" );
      ((Element)v.get(157)).setAttribute("minimizable","S" );
      ((Element)v.get(157)).setAttribute("minimizada","N" );
      ((Element)v.get(150)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:150   */

      /* Empieza nodo:158 / Elemento padre: 140   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(158)).setAttribute("alto","20" );
      ((Element)v.get(158)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(158)).setAttribute("imgFondo","" );
      ((Element)v.get(158)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(140)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("COL"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(159)).setAttribute("colFondo","" );
      ((Element)v.get(159)).setAttribute("ID","EstCab" );
      ((Element)v.get(159)).setAttribute("cod","1395" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 158   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("colFondo","" );
      ((Element)v.get(160)).setAttribute("ID","EstCab" );
      ((Element)v.get(160)).setAttribute("cod","1428" );
      ((Element)v.get(158)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 158   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("colFondo","" );
      ((Element)v.get(161)).setAttribute("ID","EstCab" );
      ((Element)v.get(161)).setAttribute("cod","1451" );
      ((Element)v.get(158)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 158   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("colFondo","" );
      ((Element)v.get(162)).setAttribute("ID","EstCab" );
      ((Element)v.get(162)).setAttribute("cod","1429" );
      ((Element)v.get(158)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 158   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("colFondo","" );
      ((Element)v.get(163)).setAttribute("ID","EstCab" );
      ((Element)v.get(163)).setAttribute("cod","1430" );
      ((Element)v.get(158)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 158   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("colFondo","" );
      ((Element)v.get(164)).setAttribute("ID","EstCab" );
      ((Element)v.get(164)).setAttribute("cod","1431" );
      ((Element)v.get(158)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 158   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("colFondo","" );
      ((Element)v.get(165)).setAttribute("ID","EstCab" );
      ((Element)v.get(165)).setAttribute("cod","504" );
      ((Element)v.get(158)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:158   */

      /* Empieza nodo:166 / Elemento padre: 140   */
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
      ((Element)v.get(140)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("tipo","texto" );
      ((Element)v.get(167)).setAttribute("ID","EstDat" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("tipo","texto" );
      ((Element)v.get(168)).setAttribute("ID","EstDat2" );
      ((Element)v.get(166)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("tipo","texto" );
      ((Element)v.get(169)).setAttribute("ID","EstDat" );
      ((Element)v.get(166)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("tipo","texto" );
      ((Element)v.get(170)).setAttribute("ID","EstDat2" );
      ((Element)v.get(166)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("tipo","texto" );
      ((Element)v.get(171)).setAttribute("ID","EstDat" );
      ((Element)v.get(166)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("tipo","texto" );
      ((Element)v.get(172)).setAttribute("ID","EstDat2" );
      ((Element)v.get(166)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("tipo","texto" );
      ((Element)v.get(173)).setAttribute("ID","EstDat" );
      ((Element)v.get(166)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:166   */

      /* Empieza nodo:174 / Elemento padre: 140   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(140)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 140   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(175)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(175)).setAttribute("ancho","504" );
      ((Element)v.get(175)).setAttribute("sep","$" );
      ((Element)v.get(175)).setAttribute("x","12" );
      ((Element)v.get(175)).setAttribute("class","botonera" );
      ((Element)v.get(175)).setAttribute("y","417" );
      ((Element)v.get(175)).setAttribute("control","|" );
      ((Element)v.get(175)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(175)).setAttribute("rowset","" );
      ((Element)v.get(175)).setAttribute("cargainicial","N" );
      ((Element)v.get(140)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(176)).setAttribute("nombre","ret3" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(176)).setAttribute("x","37" );
      ((Element)v.get(176)).setAttribute("y","421" );
      ((Element)v.get(176)).setAttribute("ID","botonContenido" );
      ((Element)v.get(176)).setAttribute("img","retroceder_on" );
      ((Element)v.get(176)).setAttribute("tipo","0" );
      ((Element)v.get(176)).setAttribute("estado","false" );
      ((Element)v.get(176)).setAttribute("alt","" );
      ((Element)v.get(176)).setAttribute("codigo","" );
      ((Element)v.get(176)).setAttribute("accion","mipgndo3.retroceder();" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 175   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(177)).setAttribute("nombre","ava3" );
      ((Element)v.get(177)).setAttribute("x","52" );
      ((Element)v.get(177)).setAttribute("y","421" );
      ((Element)v.get(177)).setAttribute("ID","botonContenido" );
      ((Element)v.get(177)).setAttribute("img","avanzar_on" );
      ((Element)v.get(177)).setAttribute("tipo","0" );
      ((Element)v.get(177)).setAttribute("estado","false" );
      ((Element)v.get(177)).setAttribute("alt","" );
      ((Element)v.get(177)).setAttribute("codigo","" );
      ((Element)v.get(177)).setAttribute("accion","mipgndo3.avanzar();" );
      ((Element)v.get(175)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:175   */
      /* Termina nodo:140   */

      /* Empieza nodo:178 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(178)).setAttribute("nombre","primera3" );
      ((Element)v.get(178)).setAttribute("x","20" );
      ((Element)v.get(178)).setAttribute("y","421" );
      ((Element)v.get(178)).setAttribute("ID","botonContenido" );
      ((Element)v.get(178)).setAttribute("img","primera_on" );
      ((Element)v.get(178)).setAttribute("tipo","-2" );
      ((Element)v.get(178)).setAttribute("estado","false" );
      ((Element)v.get(178)).setAttribute("alt","" );
      ((Element)v.get(178)).setAttribute("codigo","" );
      ((Element)v.get(178)).setAttribute("accion","mipgndo3.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(179)).setAttribute("nombre","separa3" );
      ((Element)v.get(179)).setAttribute("x","59" );
      ((Element)v.get(179)).setAttribute("y","417" );
      ((Element)v.get(179)).setAttribute("ID","botonContenido" );
      ((Element)v.get(179)).setAttribute("img","separa_base" );
      ((Element)v.get(179)).setAttribute("tipo","0" );
      ((Element)v.get(179)).setAttribute("estado","false" );
      ((Element)v.get(179)).setAttribute("alt","" );
      ((Element)v.get(179)).setAttribute("codigo","" );
      ((Element)v.get(179)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(180)).setAttribute("nombre","listado4" );
      ((Element)v.get(180)).setAttribute("ancho","504" );
      ((Element)v.get(180)).setAttribute("alto","317" );
      ((Element)v.get(180)).setAttribute("x","12" );
      ((Element)v.get(180)).setAttribute("y","123" );
      ((Element)v.get(180)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(180)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(181)).setAttribute("precarga","S" );
      ((Element)v.get(181)).setAttribute("conROver","S" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(182)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(182)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(182)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(182)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 181   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(183)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(183)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(183)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(183)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(181)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 181   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(184)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(184)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(181)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:181   */

      /* Empieza nodo:185 / Elemento padre: 180   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(180)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(186)).setAttribute("borde","1" );
      ((Element)v.get(186)).setAttribute("horizDatos","1" );
      ((Element)v.get(186)).setAttribute("horizCabecera","1" );
      ((Element)v.get(186)).setAttribute("vertical","1" );
      ((Element)v.get(186)).setAttribute("horizTitulo","1" );
      ((Element)v.get(186)).setAttribute("horizBase","1" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 185   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(187)).setAttribute("borde","#999999" );
      ((Element)v.get(187)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(187)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(187)).setAttribute("horizDatos","#FFFFFF" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(187)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(187)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(187)).setAttribute("horizBase","#999999" );
      ((Element)v.get(185)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:185   */

      /* Empieza nodo:188 / Elemento padre: 180   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(188)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(188)).setAttribute("alto","22" );
      ((Element)v.get(188)).setAttribute("imgFondo","" );
      ((Element)v.get(188)).setAttribute("cod","00578" );
      ((Element)v.get(188)).setAttribute("ID","datosTitle" );
      ((Element)v.get(180)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 180   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(189)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(189)).setAttribute("alto","22" );
      ((Element)v.get(189)).setAttribute("imgFondo","" );
      ((Element)v.get(180)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 180   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(190)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(190)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(190)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(190)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(190)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(190)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(180)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("ancho","160" );
      ((Element)v.get(191)).setAttribute("minimizable","S" );
      ((Element)v.get(191)).setAttribute("minimizada","N" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("ancho","160" );
      ((Element)v.get(192)).setAttribute("minimizable","S" );
      ((Element)v.get(192)).setAttribute("minimizada","N" );
      ((Element)v.get(190)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("ancho","160" );
      ((Element)v.get(193)).setAttribute("minimizable","S" );
      ((Element)v.get(193)).setAttribute("minimizada","N" );
      ((Element)v.get(190)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("ancho","160" );
      ((Element)v.get(194)).setAttribute("minimizable","S" );
      ((Element)v.get(194)).setAttribute("minimizada","N" );
      ((Element)v.get(190)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(195)).setAttribute("ancho","160" );
      ((Element)v.get(195)).setAttribute("minimizable","S" );
      ((Element)v.get(195)).setAttribute("minimizada","N" );
      ((Element)v.get(190)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(196)).setAttribute("ancho","160" );
      ((Element)v.get(196)).setAttribute("minimizable","S" );
      ((Element)v.get(196)).setAttribute("minimizada","N" );
      ((Element)v.get(190)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(197)).setAttribute("ancho","160" );
      ((Element)v.get(197)).setAttribute("minimizable","S" );
      ((Element)v.get(197)).setAttribute("minimizada","N" );
      ((Element)v.get(190)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("ancho","160" );
      ((Element)v.get(198)).setAttribute("minimizable","S" );
      ((Element)v.get(198)).setAttribute("minimizada","N" );
      ((Element)v.get(190)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(199)).setAttribute("ancho","160" );
      ((Element)v.get(199)).setAttribute("minimizable","S" );
      ((Element)v.get(199)).setAttribute("minimizada","N" );
      ((Element)v.get(190)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(200)).setAttribute("ancho","160" );
      ((Element)v.get(200)).setAttribute("minimizable","S" );
      ((Element)v.get(200)).setAttribute("minimizada","N" );
      ((Element)v.get(190)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(201)).setAttribute("ancho","160" );
      ((Element)v.get(201)).setAttribute("minimizable","S" );
      ((Element)v.get(201)).setAttribute("minimizada","N" );
      ((Element)v.get(190)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(202)).setAttribute("ancho","160" );
      ((Element)v.get(202)).setAttribute("minimizable","S" );
      ((Element)v.get(202)).setAttribute("minimizada","N" );
      ((Element)v.get(190)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(203)).setAttribute("ancho","160" );
      ((Element)v.get(203)).setAttribute("minimizable","S" );
      ((Element)v.get(203)).setAttribute("minimizada","N" );
      ((Element)v.get(190)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(204)).setAttribute("ancho","160" );
      ((Element)v.get(204)).setAttribute("minimizable","S" );
      ((Element)v.get(204)).setAttribute("minimizada","N" );
      ((Element)v.get(190)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:190   */

      /* Empieza nodo:205 / Elemento padre: 180   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(205)).setAttribute("alto","20" );
      ((Element)v.get(205)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(205)).setAttribute("imgFondo","" );
      ((Element)v.get(205)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(180)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("colFondo","" );
      ((Element)v.get(206)).setAttribute("ID","EstCab" );
      ((Element)v.get(206)).setAttribute("cod","2354" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("colFondo","" );
      ((Element)v.get(207)).setAttribute("ID","EstCab" );
      ((Element)v.get(207)).setAttribute("cod","2355" );
      ((Element)v.get(205)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("colFondo","" );
      ((Element)v.get(208)).setAttribute("ID","EstCab" );
      ((Element)v.get(208)).setAttribute("cod","2356" );
      ((Element)v.get(205)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(209)).setAttribute("colFondo","" );
      ((Element)v.get(209)).setAttribute("ID","EstCab" );
      ((Element)v.get(209)).setAttribute("cod","2357" );
      ((Element)v.get(205)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */

      /* Empieza nodo:210 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("colFondo","" );
      ((Element)v.get(210)).setAttribute("ID","EstCab" );
      ((Element)v.get(210)).setAttribute("cod","2358" );
      ((Element)v.get(205)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(211)).setAttribute("colFondo","" );
      ((Element)v.get(211)).setAttribute("ID","EstCab" );
      ((Element)v.get(211)).setAttribute("cod","2359" );
      ((Element)v.get(205)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("colFondo","" );
      ((Element)v.get(212)).setAttribute("ID","EstCab" );
      ((Element)v.get(212)).setAttribute("cod","2360" );
      ((Element)v.get(205)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(213)).setAttribute("colFondo","" );
      ((Element)v.get(213)).setAttribute("ID","EstCab" );
      ((Element)v.get(213)).setAttribute("cod","2361" );
      ((Element)v.get(205)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("colFondo","" );
      ((Element)v.get(214)).setAttribute("ID","EstCab" );
      ((Element)v.get(214)).setAttribute("cod","2362" );
      ((Element)v.get(205)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(215)).setAttribute("colFondo","" );
      ((Element)v.get(215)).setAttribute("ID","EstCab" );
      ((Element)v.get(215)).setAttribute("cod","2363" );
      ((Element)v.get(205)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("colFondo","" );
      ((Element)v.get(216)).setAttribute("ID","EstCab" );
      ((Element)v.get(216)).setAttribute("cod","2364" );
      ((Element)v.get(205)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("colFondo","" );
      ((Element)v.get(217)).setAttribute("ID","EstCab" );
      ((Element)v.get(217)).setAttribute("cod","2365" );
      ((Element)v.get(205)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(218)).setAttribute("colFondo","" );
      ((Element)v.get(218)).setAttribute("ID","EstCab" );
      ((Element)v.get(218)).setAttribute("cod","2366" );
      ((Element)v.get(205)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(219)).setAttribute("colFondo","" );
      ((Element)v.get(219)).setAttribute("ID","EstCab" );
      ((Element)v.get(219)).setAttribute("cod","2367" );
      ((Element)v.get(205)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:205   */

      /* Empieza nodo:220 / Elemento padre: 180   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(220)).setAttribute("alto","22" );
      ((Element)v.get(220)).setAttribute("accion","" );
      ((Element)v.get(220)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(220)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(220)).setAttribute("maxSel","-1" );
      ((Element)v.get(220)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(220)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(220)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(220)).setAttribute("onLoad","" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(220)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(180)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(221)).setAttribute("tipo","texto" );
      ((Element)v.get(221)).setAttribute("ID","EstDat" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("tipo","texto" );
      ((Element)v.get(222)).setAttribute("ID","EstDat2" );
      ((Element)v.get(220)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(223)).setAttribute("tipo","texto" );
      ((Element)v.get(223)).setAttribute("ID","EstDat" );
      ((Element)v.get(220)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("tipo","texto" );
      ((Element)v.get(224)).setAttribute("ID","EstDat2" );
      ((Element)v.get(220)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(225)).setAttribute("tipo","texto" );
      ((Element)v.get(225)).setAttribute("ID","EstDat" );
      ((Element)v.get(220)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(226)).setAttribute("tipo","texto" );
      ((Element)v.get(226)).setAttribute("ID","EstDat2" );
      ((Element)v.get(220)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */

      /* Empieza nodo:227 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("tipo","texto" );
      ((Element)v.get(227)).setAttribute("ID","EstDat" );
      ((Element)v.get(220)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(228)).setAttribute("tipo","texto" );
      ((Element)v.get(228)).setAttribute("ID","EstDat2" );
      ((Element)v.get(220)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("tipo","texto" );
      ((Element)v.get(229)).setAttribute("ID","EstDat" );
      ((Element)v.get(220)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("tipo","texto" );
      ((Element)v.get(230)).setAttribute("ID","EstDat2" );
      ((Element)v.get(220)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("tipo","texto" );
      ((Element)v.get(231)).setAttribute("ID","EstDat" );
      ((Element)v.get(220)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(232)).setAttribute("tipo","texto" );
      ((Element)v.get(232)).setAttribute("ID","EstDat2" );
      ((Element)v.get(220)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(233)).setAttribute("tipo","texto" );
      ((Element)v.get(233)).setAttribute("ID","EstDat" );
      ((Element)v.get(220)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */

      /* Empieza nodo:234 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(234)).setAttribute("tipo","texto" );
      ((Element)v.get(234)).setAttribute("ID","EstDat2" );
      ((Element)v.get(220)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:220   */

      /* Empieza nodo:235 / Elemento padre: 180   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(180)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 180   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(236)).setAttribute("nombre","mipgndo4" );
      ((Element)v.get(236)).setAttribute("ancho","504" );
      ((Element)v.get(236)).setAttribute("sep","$" );
      ((Element)v.get(236)).setAttribute("x","12" );
      ((Element)v.get(236)).setAttribute("class","botonera" );
      ((Element)v.get(236)).setAttribute("y","417" );
      ((Element)v.get(236)).setAttribute("control","|" );
      ((Element)v.get(236)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(236)).setAttribute("rowset","" );
      ((Element)v.get(236)).setAttribute("cargainicial","N" );
      ((Element)v.get(180)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(237)).setAttribute("nombre","ret4" );
      ((Element)v.get(237)).setAttribute("x","37" );
      ((Element)v.get(237)).setAttribute("y","421" );
      ((Element)v.get(237)).setAttribute("ID","botonContenido" );
      ((Element)v.get(237)).setAttribute("img","retroceder_on" );
      ((Element)v.get(237)).setAttribute("tipo","0" );
      ((Element)v.get(237)).setAttribute("estado","false" );
      ((Element)v.get(237)).setAttribute("alt","" );
      ((Element)v.get(237)).setAttribute("codigo","" );
      ((Element)v.get(237)).setAttribute("accion","mipgndo4.retroceder();" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 236   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(238)).setAttribute("nombre","ava4" );
      ((Element)v.get(238)).setAttribute("x","52" );
      ((Element)v.get(238)).setAttribute("y","421" );
      ((Element)v.get(238)).setAttribute("ID","botonContenido" );
      ((Element)v.get(238)).setAttribute("img","avanzar_on" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(238)).setAttribute("tipo","0" );
      ((Element)v.get(238)).setAttribute("estado","false" );
      ((Element)v.get(238)).setAttribute("alt","" );
      ((Element)v.get(238)).setAttribute("codigo","" );
      ((Element)v.get(238)).setAttribute("accion","mipgndo4.avanzar();" );
      ((Element)v.get(236)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:236   */
      /* Termina nodo:180   */

      /* Empieza nodo:239 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(239)).setAttribute("nombre","primera4" );
      ((Element)v.get(239)).setAttribute("x","20" );
      ((Element)v.get(239)).setAttribute("y","421" );
      ((Element)v.get(239)).setAttribute("ID","botonContenido" );
      ((Element)v.get(239)).setAttribute("img","primera_on" );
      ((Element)v.get(239)).setAttribute("tipo","-2" );
      ((Element)v.get(239)).setAttribute("estado","false" );
      ((Element)v.get(239)).setAttribute("alt","" );
      ((Element)v.get(239)).setAttribute("codigo","" );
      ((Element)v.get(239)).setAttribute("accion","mipgndo4.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(240)).setAttribute("nombre","separa4" );
      ((Element)v.get(240)).setAttribute("x","59" );
      ((Element)v.get(240)).setAttribute("y","417" );
      ((Element)v.get(240)).setAttribute("ID","botonContenido" );
      ((Element)v.get(240)).setAttribute("img","separa_base" );
      ((Element)v.get(240)).setAttribute("tipo","0" );
      ((Element)v.get(240)).setAttribute("estado","false" );
      ((Element)v.get(240)).setAttribute("alt","" );
      ((Element)v.get(240)).setAttribute("codigo","" );
      ((Element)v.get(240)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(241)).setAttribute("nombre","capaEspacio2" );
      ((Element)v.get(241)).setAttribute("alto","18" );
      ((Element)v.get(241)).setAttribute("ancho","100" );
      ((Element)v.get(241)).setAttribute("colorf","" );
      ((Element)v.get(241)).setAttribute("borde","0" );
      ((Element)v.get(241)).setAttribute("imagenf","" );
      ((Element)v.get(241)).setAttribute("repeat","" );
      ((Element)v.get(241)).setAttribute("padding","" );
      ((Element)v.get(241)).setAttribute("visibilidad","visible" );
      ((Element)v.get(241)).setAttribute("contravsb","" );
      ((Element)v.get(241)).setAttribute("x","0" );
      ((Element)v.get(241)).setAttribute("y","440" );
      ((Element)v.get(241)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:6   */


   }

}

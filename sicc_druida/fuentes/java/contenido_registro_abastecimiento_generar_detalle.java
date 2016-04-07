
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_registro_abastecimiento_generar_detalle  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_registro_abastecimiento_generar_detalle" );
      ((Element)v.get(0)).setAttribute("cod","0483" );
      ((Element)v.get(0)).setAttribute("titulo","Generar registro de abastecimiento" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
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
      ((Element)v.get(4)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","contenido_registro_abastecimiento_generar_detalle.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","formulario" );
      ((Element)v.get(6)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","idioma" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","pais" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","casoUso" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","accion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","detallesEnLista" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","opcionCrearRegistro" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","oidSubacceso" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","oidMarca" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","oidCanal" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oidAlmacen" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","oidPeriodo" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","oidRegistroAbastecimientoCabecera" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("nombre","oidAgrupacionStock" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","numeroSolicitud" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hid_SeparadorMiles" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hid_SeparadorDecimales" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hid_NumeroDecimales" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(27)).setAttribute("width","100%" );
      ((Element)v.get(27)).setAttribute("border","0" );
      ((Element)v.get(27)).setAttribute("cellspacing","0" );
      ((Element)v.get(27)).setAttribute("cellpadding","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(27));

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
      ((Element)v.get(41)).setAttribute("nombre","lblDatosCabecera" );
      ((Element)v.get(41)).setAttribute("alto","13" );
      ((Element)v.get(41)).setAttribute("filas","1" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(41)).setAttribute("cod","00156" );
      ((Element)v.get(41)).setAttribute("id","legend" );
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
      ((Element)v.get(45)).setAttribute("width","610" );
      ((Element)v.get(45)).setAttribute("border","0" );
      ((Element)v.get(45)).setAttribute("align","left" );
      ((Element)v.get(45)).setAttribute("cellspacing","0" );
      ((Element)v.get(45)).setAttribute("cellpadding","0" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
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
      ((Element)v.get(53)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(53)).setAttribute("alto","13" );
      ((Element)v.get(53)).setAttribute("filas","1" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(53)).setAttribute("id","datosTitle" );
      ((Element)v.get(53)).setAttribute("cod","6" );
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
      ((Element)v.get(57)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(57)).setAttribute("alto","13" );
      ((Element)v.get(57)).setAttribute("filas","1" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("id","datosTitle" );
      ((Element)v.get(57)).setAttribute("cod","7" );
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
      ((Element)v.get(49)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(61)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(61)).setAttribute("alto","13" );
      ((Element)v.get(61)).setAttribute("filas","1" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(61)).setAttribute("id","datosTitle" );
      ((Element)v.get(61)).setAttribute("cod","10" );
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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(68)).setAttribute("nombre","lbldtMarca" );
      ((Element)v.get(68)).setAttribute("alto","13" );
      ((Element)v.get(68)).setAttribute("filas","1" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(68)).setAttribute("id","datosCampos" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
   }

   private void getXML270(Document doc) {
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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(72)).setAttribute("nombre","lbldtCanal" );
      ((Element)v.get(72)).setAttribute("alto","13" );
      ((Element)v.get(72)).setAttribute("filas","1" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(72)).setAttribute("id","datosCampos" );
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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(76)).setAttribute("nombre","lbldtAcceso" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(76)).setAttribute("id","datosCampos" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","100%" );
      ((Element)v.get(64)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","8" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:64   */

      /* Empieza nodo:79 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("colspan","4" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:82 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("table"));
      ((Element)v.get(84)).setAttribute("width","610" );
      ((Element)v.get(84)).setAttribute("border","0" );
      ((Element)v.get(84)).setAttribute("align","left" );
      ((Element)v.get(84)).setAttribute("cellspacing","0" );
      ((Element)v.get(84)).setAttribute("cellpadding","0" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(89)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(89)).setAttribute("alto","13" );
      ((Element)v.get(89)).setAttribute("filas","1" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(89)).setAttribute("id","datosTitle" );
      ((Element)v.get(89)).setAttribute("cod","122" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","25" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(93)).setAttribute("nombre","lblAlmacen" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(93)).setAttribute("alto","13" );
      ((Element)v.get(93)).setAttribute("filas","1" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(93)).setAttribute("id","datosTitle" );
      ((Element)v.get(93)).setAttribute("cod","797" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","25" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(97)).setAttribute("nombre","lblNumSolicitud" );
      ((Element)v.get(97)).setAttribute("alto","13" );
      ((Element)v.get(97)).setAttribute("filas","1" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(97)).setAttribute("id","datosTitle" );
      ((Element)v.get(97)).setAttribute("cod","424" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("width","100%" );
      ((Element)v.get(85)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","8" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:85   */

      /* Empieza nodo:100 / Elemento padre: 84   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(84)).appendChild((Element)v.get(100));

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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(104)).setAttribute("nombre","lbldtSubacceso" );
      ((Element)v.get(104)).setAttribute("alto","13" );
      ((Element)v.get(104)).setAttribute("filas","1" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(104)).setAttribute("id","datosCampos" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","25" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(108)).setAttribute("nombre","lbldtAlmacen" );
      ((Element)v.get(108)).setAttribute("alto","13" );
      ((Element)v.get(108)).setAttribute("filas","1" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(108)).setAttribute("id","datosCampos" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","25" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(112)).setAttribute("nombre","lbldtNumSolicitud" );
      ((Element)v.get(112)).setAttribute("alto","13" );
      ((Element)v.get(112)).setAttribute("filas","1" );
      ((Element)v.get(112)).setAttribute("valor","" );
      ((Element)v.get(112)).setAttribute("id","datosCampos" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","100%" );
      ((Element)v.get(100)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:100   */

      /* Empieza nodo:115 / Elemento padre: 84   */
      v.add(doc.createElement("tr"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(84)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("colspan","4" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:42   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:118 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","8" );
      ((Element)v.get(119)).setAttribute("height","12" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:35   */

      /* Empieza nodo:120 / Elemento padre: 27   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(27)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("width","12" );
      ((Element)v.get(121)).setAttribute("align","center" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","12" );
      ((Element)v.get(122)).setAttribute("height","12" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("width","750" );
      ((Element)v.get(120)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("width","12" );
      ((Element)v.get(120)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","12" );
      ((Element)v.get(126)).setAttribute("height","12" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:120   */
      /* Termina nodo:27   */

      /* Empieza nodo:127 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(127)).setAttribute("nombre","datosDeDetalle" );
      ((Element)v.get(127)).setAttribute("ancho","614" );
      ((Element)v.get(127)).setAttribute("alto","317" );
      ((Element)v.get(127)).setAttribute("x","12" );
      ((Element)v.get(127)).setAttribute("y","125" );
      ((Element)v.get(127)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(127)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(128)).setAttribute("precarga","S" );
      ((Element)v.get(128)).setAttribute("conROver","S" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(129)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(129)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(129)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(129)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 128   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(130)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(130)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(130)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(130)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(128)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(131)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(131)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(128)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:128   */

      /* Empieza nodo:132 / Elemento padre: 127   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(127)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(133)).setAttribute("borde","1" );
      ((Element)v.get(133)).setAttribute("horizDatos","1" );
      ((Element)v.get(133)).setAttribute("horizCabecera","1" );
      ((Element)v.get(133)).setAttribute("vertical","1" );
      ((Element)v.get(133)).setAttribute("horizTitulo","1" );
      ((Element)v.get(133)).setAttribute("horizBase","1" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 132   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(134)).setAttribute("borde","#999999" );
      ((Element)v.get(134)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(134)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(134)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(134)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(134)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(134)).setAttribute("horizBase","#999999" );
      ((Element)v.get(132)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:132   */

      /* Empieza nodo:135 / Elemento padre: 127   */
      v.add(doc.createElement("TITULO"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(135)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(135)).setAttribute("alto","22" );
      ((Element)v.get(135)).setAttribute("imgFondo","" );
      ((Element)v.get(135)).setAttribute("cod","00133" );
      ((Element)v.get(135)).setAttribute("ID","datosTitle" );
      ((Element)v.get(127)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 127   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(136)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(136)).setAttribute("alto","22" );
      ((Element)v.get(136)).setAttribute("imgFondo","" );
      ((Element)v.get(127)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 127   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(137)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(137)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(137)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(137)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(137)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(137)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(127)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("ancho","100" );
      ((Element)v.get(138)).setAttribute("minimizable","S" );
      ((Element)v.get(138)).setAttribute("minimizada","N" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("ancho","80" );
      ((Element)v.get(139)).setAttribute("minimizable","S" );
      ((Element)v.get(139)).setAttribute("minimizada","N" );
      ((Element)v.get(137)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(140)).setAttribute("ancho","80" );
      ((Element)v.get(140)).setAttribute("minimizable","S" );
      ((Element)v.get(140)).setAttribute("minimizada","N" );
      ((Element)v.get(137)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("ancho","100" );
      ((Element)v.get(141)).setAttribute("minimizable","S" );
      ((Element)v.get(141)).setAttribute("minimizada","N" );
      ((Element)v.get(137)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("ancho","100" );
      ((Element)v.get(142)).setAttribute("minimizable","S" );
      ((Element)v.get(142)).setAttribute("minimizada","N" );
      ((Element)v.get(137)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("ancho","130" );
      ((Element)v.get(143)).setAttribute("minimizable","S" );
      ((Element)v.get(143)).setAttribute("minimizada","N" );
      ((Element)v.get(137)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("ancho","100" );
      ((Element)v.get(144)).setAttribute("minimizable","S" );
      ((Element)v.get(144)).setAttribute("minimizada","N" );
      ((Element)v.get(144)).setAttribute("oculta","S" );
      ((Element)v.get(137)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(145)).setAttribute("ancho","100" );
      ((Element)v.get(145)).setAttribute("minimizable","S" );
      ((Element)v.get(145)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).setAttribute("oculta","S" );
      ((Element)v.get(137)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:137   */

      /* Empieza nodo:146 / Elemento padre: 127   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(146)).setAttribute("alto","20" );
      ((Element)v.get(146)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(146)).setAttribute("imgFondo","" );
      ((Element)v.get(146)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(127)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(147)).setAttribute("colFondo","" );
      ((Element)v.get(147)).setAttribute("ID","EstCab" );
      ((Element)v.get(147)).setAttribute("cod","337" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("colFondo","" );
      ((Element)v.get(148)).setAttribute("ID","EstCab" );
      ((Element)v.get(148)).setAttribute("cod","338" );
      ((Element)v.get(146)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(149)).setAttribute("colFondo","" );
      ((Element)v.get(149)).setAttribute("ID","EstCab" );
      ((Element)v.get(149)).setAttribute("cod","2321" );
      ((Element)v.get(146)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("colFondo","" );
      ((Element)v.get(150)).setAttribute("ID","EstCab" );
      ((Element)v.get(150)).setAttribute("cod","1593" );
      ((Element)v.get(146)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("colFondo","" );
      ((Element)v.get(151)).setAttribute("ID","EstCab" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(151)).setAttribute("cod","1595" );
      ((Element)v.get(146)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("colFondo","" );
      ((Element)v.get(152)).setAttribute("ID","EstCab" );
      ((Element)v.get(152)).setAttribute("cod","2322" );
      ((Element)v.get(146)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("colFondo","" );
      ((Element)v.get(153)).setAttribute("ID","EstCab" );
      ((Element)v.get(146)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("colFondo","" );
      ((Element)v.get(154)).setAttribute("ID","EstCab" );
      ((Element)v.get(146)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:146   */

      /* Empieza nodo:155 / Elemento padre: 127   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(155)).setAttribute("alto","22" );
      ((Element)v.get(155)).setAttribute("accion","" );
      ((Element)v.get(155)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(155)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(155)).setAttribute("maxSel","-1" );
      ((Element)v.get(155)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(155)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(155)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(155)).setAttribute("onLoad","" );
      ((Element)v.get(155)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(127)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("tipo","texto" );
      ((Element)v.get(156)).setAttribute("ID","EstDat" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 155   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("tipo","texto" );
      ((Element)v.get(157)).setAttribute("ID","EstDat2" );
      ((Element)v.get(155)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 155   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("tipo","texto" );
      ((Element)v.get(158)).setAttribute("ID","EstDat" );
      ((Element)v.get(155)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 155   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("tipo","texto" );
      ((Element)v.get(159)).setAttribute("ID","EstDat2" );
      ((Element)v.get(155)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 155   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("tipo","texto" );
      ((Element)v.get(160)).setAttribute("ID","EstDat" );
      ((Element)v.get(155)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 155   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(161)).setAttribute("nombre","Unidades" );
      ((Element)v.get(161)).setAttribute("size","12" );
      ((Element)v.get(161)).setAttribute("max","10" );
      ((Element)v.get(161)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(161)).setAttribute("ID","EstDat2" );
      ((Element)v.get(161)).setAttribute("onTab","focalizaSig(FILAEVENTO, TECLAEVENTO);" );
      ((Element)v.get(161)).setAttribute("onShTab","focalizaAnt(FILAEVENTO, TECLAEVENTO);" );
      ((Element)v.get(161)).setAttribute("onBlur","datosDeDetalleOnChange(FILAEVENTO);" );
      ((Element)v.get(155)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 155   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("tipo","texto" );
      ((Element)v.get(162)).setAttribute("ID","EstDat" );
      ((Element)v.get(155)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 155   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("tipo","texto" );
      ((Element)v.get(163)).setAttribute("ID","EstDat" );
      ((Element)v.get(155)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:155   */

      /* Empieza nodo:164 / Elemento padre: 127   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(127)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 127   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(165)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(165)).setAttribute("ancho","614" );
      ((Element)v.get(165)).setAttribute("sep","$" );
      ((Element)v.get(165)).setAttribute("x","24" );
      ((Element)v.get(165)).setAttribute("class","botonera" );
      ((Element)v.get(165)).setAttribute("y","419" );
      ((Element)v.get(165)).setAttribute("control","|" );
      ((Element)v.get(165)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(165)).setAttribute("rowset","" );
      ((Element)v.get(165)).setAttribute("cargainicial","N" );
      ((Element)v.get(127)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(166)).setAttribute("nombre","ret1" );
      ((Element)v.get(166)).setAttribute("x","37" );
      ((Element)v.get(166)).setAttribute("y","423" );
      ((Element)v.get(166)).setAttribute("ID","botonContenido" );
      ((Element)v.get(166)).setAttribute("img","retroceder_on" );
      ((Element)v.get(166)).setAttribute("tipo","0" );
      ((Element)v.get(166)).setAttribute("estado","false" );
      ((Element)v.get(166)).setAttribute("alt","" );
      ((Element)v.get(166)).setAttribute("codigo","" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(166)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 165   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(167)).setAttribute("nombre","ava1" );
      ((Element)v.get(167)).setAttribute("x","52" );
      ((Element)v.get(167)).setAttribute("y","423" );
      ((Element)v.get(167)).setAttribute("ID","botonContenido" );
      ((Element)v.get(167)).setAttribute("img","avanzar_on" );
      ((Element)v.get(167)).setAttribute("tipo","0" );
      ((Element)v.get(167)).setAttribute("estado","false" );
      ((Element)v.get(167)).setAttribute("alt","" );
      ((Element)v.get(167)).setAttribute("codigo","" );
      ((Element)v.get(167)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(165)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:165   */
      /* Termina nodo:127   */

      /* Empieza nodo:168 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(168)).setAttribute("nombre","primera1" );
      ((Element)v.get(168)).setAttribute("x","20" );
      ((Element)v.get(168)).setAttribute("y","423" );
      ((Element)v.get(168)).setAttribute("ID","botonContenido" );
      ((Element)v.get(168)).setAttribute("img","primera_on" );
      ((Element)v.get(168)).setAttribute("tipo","-2" );
      ((Element)v.get(168)).setAttribute("estado","false" );
      ((Element)v.get(168)).setAttribute("alt","" );
      ((Element)v.get(168)).setAttribute("codigo","" );
      ((Element)v.get(168)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(169)).setAttribute("nombre","separa" );
      ((Element)v.get(169)).setAttribute("x","59" );
      ((Element)v.get(169)).setAttribute("y","419" );
      ((Element)v.get(169)).setAttribute("ID","botonContenido" );
      ((Element)v.get(169)).setAttribute("img","separa_base" );
      ((Element)v.get(169)).setAttribute("tipo","0" );
      ((Element)v.get(169)).setAttribute("estado","false" );
      ((Element)v.get(169)).setAttribute("alt","" );
      ((Element)v.get(169)).setAttribute("codigo","" );
      ((Element)v.get(169)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(170)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(170)).setAttribute("x","13" );
      ((Element)v.get(170)).setAttribute("y","420" );
      ((Element)v.get(170)).setAttribute("ID","botonContenido" );
      ((Element)v.get(170)).setAttribute("img","" );
      ((Element)v.get(170)).setAttribute("tipo","html" );
      ((Element)v.get(170)).setAttribute("estado","false" );
      ((Element)v.get(170)).setAttribute("cod","404" );
      ((Element)v.get(170)).setAttribute("accion","accionAnadir();" );
      ((Element)v.get(170)).setAttribute("onshtab","onShTabAnadir()" );
      ((Element)v.get(6)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(171)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(171)).setAttribute("x","61" );
      ((Element)v.get(171)).setAttribute("y","420" );
      ((Element)v.get(171)).setAttribute("ID","botonContenido" );
      ((Element)v.get(171)).setAttribute("img","" );
      ((Element)v.get(171)).setAttribute("tipo","html" );
      ((Element)v.get(171)).setAttribute("estado","false" );
      ((Element)v.get(171)).setAttribute("cod","1254" );
      ((Element)v.get(171)).setAttribute("accion","accionEliminar();" );
      ((Element)v.get(171)).setAttribute("ontab","onTabEliminar();" );
      ((Element)v.get(6)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(172)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(172)).setAttribute("alto","12" );
      ((Element)v.get(172)).setAttribute("ancho","100%" );
      ((Element)v.get(172)).setAttribute("colorf","" );
      ((Element)v.get(172)).setAttribute("borde","0" );
      ((Element)v.get(172)).setAttribute("imagenf","" );
      ((Element)v.get(172)).setAttribute("repeat","" );
      ((Element)v.get(172)).setAttribute("padding","" );
      ((Element)v.get(172)).setAttribute("visibilidad","visible" );
      ((Element)v.get(172)).setAttribute("contravsb","" );
      ((Element)v.get(172)).setAttribute("x","0" );
      ((Element)v.get(172)).setAttribute("y","442" );
      ((Element)v.get(172)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:6   */


   }

}

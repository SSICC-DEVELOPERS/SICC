
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_lotes_busqueda  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_lotes_busqueda" );
      ((Element)v.get(0)).setAttribute("cod","0348" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar provisiones/depuraciones" );
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
      ((Element)v.get(2)).setAttribute("src","contenido_lotes_busqueda.js" );
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
      v.add(doc.createElement("MATRIZJS"));
      ((Element)v.get(5)).setAttribute("nombre","datosAccesos" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("MATRIZJS"));
      ((Element)v.get(7)).setAttribute("nombre","datosSubaccesos" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:7   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(9)).setAttribute("nombre","frmCapturarCupon" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","idioma" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","pais" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","casoUso" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","accion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","subacceso" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","acceso" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","canal" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","situacion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 9   */
      v.add(doc.createElement("table"));
      ((Element)v.get(21)).setAttribute("width","100%" );
      ((Element)v.get(21)).setAttribute("border","0" );
      ((Element)v.get(21)).setAttribute("cellspacing","0" );
      ((Element)v.get(21)).setAttribute("cellpadding","0" );
      ((Element)v.get(9)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(23)).setAttribute("align","center" );
   }

   private void getXML90(Document doc) {
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
      ((Element)v.get(35)).setAttribute("nombre","lblTitCritBusc" );
      ((Element)v.get(35)).setAttribute("alto","13" );
      ((Element)v.get(35)).setAttribute("filas","1" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(35)).setAttribute("cod","0075" );
      ((Element)v.get(35)).setAttribute("id","legend" );
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
      ((Element)v.get(39)).setAttribute("width","728" );
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
      ((Element)v.get(41)).setAttribute("colspan","11" );
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
      ((Element)v.get(47)).setAttribute("nombre","lblNumero" );
      ((Element)v.get(47)).setAttribute("alto","13" );
      ((Element)v.get(47)).setAttribute("filas","1" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(47)).setAttribute("id","datosTitle" );
      ((Element)v.get(47)).setAttribute("cod","226" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(43)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","25" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(51)).setAttribute("nombre","lblAno" );
      ((Element)v.get(51)).setAttribute("alto","13" );
      ((Element)v.get(51)).setAttribute("filas","1" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(51)).setAttribute("id","datosTitle" );
      ((Element)v.get(51)).setAttribute("cod","171" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","25" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(55)).setAttribute("nombre","lblMes" );
      ((Element)v.get(55)).setAttribute("alto","13" );
      ((Element)v.get(55)).setAttribute("filas","1" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(55)).setAttribute("id","datosTitle" );
      ((Element)v.get(55)).setAttribute("cod","674" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","25" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(59)).setAttribute("nombre","lblFechaImputacion" );
      ((Element)v.get(59)).setAttribute("alto","13" );
      ((Element)v.get(59)).setAttribute("filas","1" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(59)).setAttribute("id","datosTitle" );
      ((Element)v.get(59)).setAttribute("cod","650" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","25" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(63)).setAttribute("nombre","lblTipoAbono" );
      ((Element)v.get(63)).setAttribute("alto","13" );
      ((Element)v.get(63)).setAttribute("filas","1" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(63)).setAttribute("id","datosTitle" );
      ((Element)v.get(63)).setAttribute("cod","700" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","25" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(67)).setAttribute("nombre","lblSituacion" );
      ((Element)v.get(67)).setAttribute("alto","13" );
      ((Element)v.get(67)).setAttribute("filas","1" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(67)).setAttribute("id","datosTitle" );
      ((Element)v.get(67)).setAttribute("cod","695" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("width","100%" );
      ((Element)v.get(43)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","8" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:43   */

      /* Empieza nodo:70 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(74)).setAttribute("nombre","textNumero" );
      ((Element)v.get(74)).setAttribute("id","datosCampos" );
      ((Element)v.get(74)).setAttribute("max","8" );
      ((Element)v.get(74)).setAttribute("tipo","" );
      ((Element)v.get(74)).setAttribute("onblur","validarNumero();" );
      ((Element)v.get(74)).setAttribute("onshtab","focalizaAnteriorNumero();" );
      ((Element)v.get(74)).setAttribute("onchange","" );
      ((Element)v.get(74)).setAttribute("req","N" );
      ((Element)v.get(74)).setAttribute("size","10" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(74)).setAttribute("validacion","" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","25" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(78)).setAttribute("nombre","textAno" );
      ((Element)v.get(78)).setAttribute("id","datosCampos" );
      ((Element)v.get(78)).setAttribute("max","2" );
      ((Element)v.get(78)).setAttribute("tipo","" );
      ((Element)v.get(78)).setAttribute("onblur","validarAnyo();" );
      ((Element)v.get(78)).setAttribute("onchange","" );
      ((Element)v.get(78)).setAttribute("req","N" );
      ((Element)v.get(78)).setAttribute("size","2" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(78)).setAttribute("validacion","" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","25" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(82)).setAttribute("nombre","textMes" );
      ((Element)v.get(82)).setAttribute("id","datosCampos" );
      ((Element)v.get(82)).setAttribute("max","2" );
      ((Element)v.get(82)).setAttribute("tipo","" );
      ((Element)v.get(82)).setAttribute("onblur","validarMes();" );
      ((Element)v.get(82)).setAttribute("onchange","" );
      ((Element)v.get(82)).setAttribute("req","N" );
      ((Element)v.get(82)).setAttribute("size","2" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(82)).setAttribute("validacion","" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","25" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(86)).setAttribute("nombre","textFechaImputacion" );
      ((Element)v.get(86)).setAttribute("id","datosCampos" );
      ((Element)v.get(86)).setAttribute("max","10" );
      ((Element)v.get(86)).setAttribute("tipo","" );
      ((Element)v.get(86)).setAttribute("onchange","" );
      ((Element)v.get(86)).setAttribute("req","N" );
      ((Element)v.get(86)).setAttribute("size","12" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(86)).setAttribute("validacion","" );
      ((Element)v.get(86)).setAttribute("onblur","validaFecha('textFechaImputacion')" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(70)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","25" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(70)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(90)).setAttribute("nombre","cbTipoAbono" );
      ((Element)v.get(90)).setAttribute("id","datosCampos" );
      ((Element)v.get(90)).setAttribute("size","1" );
      ((Element)v.get(90)).setAttribute("multiple","N" );
      ((Element)v.get(90)).setAttribute("req","N" );
      ((Element)v.get(90)).setAttribute("valorinicial","" );
      ((Element)v.get(90)).setAttribute("textoinicial","" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:92 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","25" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(70)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(95)).setAttribute("nombre","cbSituacion" );
      ((Element)v.get(95)).setAttribute("id","datosCampos" );
      ((Element)v.get(95)).setAttribute("size","1" );
      ((Element)v.get(95)).setAttribute("multiple","N" );
      ((Element)v.get(95)).setAttribute("req","N" );
      ((Element)v.get(95)).setAttribute("valorinicial","" );
      ((Element)v.get(95)).setAttribute("textoinicial","" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:97 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("width","100%" );
      ((Element)v.get(70)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","8" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:70   */

      /* Empieza nodo:99 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("colspan","11" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:102 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("table"));
      ((Element)v.get(104)).setAttribute("width","728" );
      ((Element)v.get(104)).setAttribute("border","0" );
      ((Element)v.get(104)).setAttribute("align","left" );
      ((Element)v.get(104)).setAttribute("cellspacing","0" );
      ((Element)v.get(104)).setAttribute("cellpadding","0" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(109)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(109)).setAttribute("alto","13" );
      ((Element)v.get(109)).setAttribute("filas","1" );
      ((Element)v.get(109)).setAttribute("valor","" );
      ((Element)v.get(109)).setAttribute("id","datosTitle" );
      ((Element)v.get(109)).setAttribute("cod","7" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(105)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","25" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(113)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(113)).setAttribute("alto","13" );
      ((Element)v.get(113)).setAttribute("filas","1" );
      ((Element)v.get(113)).setAttribute("valor","" );
      ((Element)v.get(113)).setAttribute("id","datosTitle" );
      ((Element)v.get(113)).setAttribute("cod","10" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","25" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(117)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(117)).setAttribute("alto","13" );
      ((Element)v.get(117)).setAttribute("filas","1" );
      ((Element)v.get(117)).setAttribute("valor","" );
      ((Element)v.get(117)).setAttribute("id","datosTitle" );
      ((Element)v.get(117)).setAttribute("cod","122" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("width","100%" );
      ((Element)v.get(105)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","8" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:105   */

      /* Empieza nodo:120 / Elemento padre: 104   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(104)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(120)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(124)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(124)).setAttribute("id","datosCampos" );
      ((Element)v.get(124)).setAttribute("size","1" );
      ((Element)v.get(124)).setAttribute("onchange","canalOnChange();" );
      ((Element)v.get(124)).setAttribute("multiple","N" );
      ((Element)v.get(124)).setAttribute("req","N" );
      ((Element)v.get(124)).setAttribute("valorinicial","" );
      ((Element)v.get(124)).setAttribute("textoinicial","" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:126 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","25" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(120)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(129)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(129)).setAttribute("id","datosCampos" );
      ((Element)v.get(129)).setAttribute("size","1" );
      ((Element)v.get(129)).setAttribute("onchange","accesoOnChange();" );
      ((Element)v.get(129)).setAttribute("multiple","N" );
      ((Element)v.get(129)).setAttribute("req","N" );
      ((Element)v.get(129)).setAttribute("valorinicial","" );
      ((Element)v.get(129)).setAttribute("textoinicial","" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:131 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","25" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(120)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(134)).setAttribute("nombre","cbSubacceso" );
      ((Element)v.get(134)).setAttribute("id","datosCampos" );
      ((Element)v.get(134)).setAttribute("size","1" );
      ((Element)v.get(134)).setAttribute("multiple","N" );
      ((Element)v.get(134)).setAttribute("req","N" );
      ((Element)v.get(134)).setAttribute("valorinicial","" );
      ((Element)v.get(134)).setAttribute("textoinicial","" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:136 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("width","100%" );
      ((Element)v.get(120)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","8" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:120   */

      /* Empieza nodo:138 / Elemento padre: 104   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(104)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("colspan","4" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","8" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:36   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:141 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("height","12" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:29   */

      /* Empieza nodo:143 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("table"));
      ((Element)v.get(148)).setAttribute("width","100%" );
      ((Element)v.get(148)).setAttribute("border","0" );
      ((Element)v.get(148)).setAttribute("align","center" );
      ((Element)v.get(148)).setAttribute("cellspacing","0" );
      ((Element)v.get(148)).setAttribute("cellpadding","0" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("class","botonera" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(151)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(151)).setAttribute("ID","botonContenido" );
      ((Element)v.get(151)).setAttribute("tipo","html" );
      ((Element)v.get(151)).setAttribute("estado","false" );
      ((Element)v.get(151)).setAttribute("cod","1" );
      ((Element)v.get(151)).setAttribute("ontab","focalizaSiguienteBuscar();" );
      ((Element)v.get(151)).setAttribute("accion","accionBuscar();" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:152 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","8" );
      ((Element)v.get(153)).setAttribute("height","12" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:143   */

      /* Empieza nodo:154 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("width","12" );
      ((Element)v.get(155)).setAttribute("align","center" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(156)).setAttribute("width","12" );
      ((Element)v.get(156)).setAttribute("height","24" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("width","750" );
      ((Element)v.get(154)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).setAttribute("width","12" );
      ((Element)v.get(154)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","12" );
      ((Element)v.get(160)).setAttribute("height","24" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:154   */
      /* Termina nodo:21   */

      /* Empieza nodo:161 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(161)).setAttribute("nombre","capaLista" );
      ((Element)v.get(161)).setAttribute("ancho","100%" );
      ((Element)v.get(161)).setAttribute("alto","330" );
      ((Element)v.get(161)).setAttribute("x","0" );
      ((Element)v.get(161)).setAttribute("y","164" );
      ((Element)v.get(161)).setAttribute("colorf","" );
      ((Element)v.get(161)).setAttribute("borde","0" );
      ((Element)v.get(161)).setAttribute("imagenf","" );
      ((Element)v.get(161)).setAttribute("repeat","" );
      ((Element)v.get(161)).setAttribute("padding","" );
      ((Element)v.get(161)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(161)).setAttribute("contravsb","" );
      ((Element)v.get(161)).setAttribute("zindex","" );
      ((Element)v.get(9)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(162)).setAttribute("nombre","listado1" );
      ((Element)v.get(162)).setAttribute("ancho","732" );
      ((Element)v.get(162)).setAttribute("alto","317" );
      ((Element)v.get(162)).setAttribute("x","12" );
      ((Element)v.get(162)).setAttribute("y","0" );
      ((Element)v.get(162)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(162)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(163)).setAttribute("precarga","S" );
      ((Element)v.get(163)).setAttribute("conROver","S" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(164)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(164)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(164)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(164)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 163   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(165)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(165)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(165)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(165)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(163)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 163   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(166)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(166)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(163)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:163   */

      /* Empieza nodo:167 / Elemento padre: 162   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(162)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(168)).setAttribute("borde","1" );
      ((Element)v.get(168)).setAttribute("horizDatos","1" );
      ((Element)v.get(168)).setAttribute("horizCabecera","1" );
      ((Element)v.get(168)).setAttribute("vertical","1" );
      ((Element)v.get(168)).setAttribute("horizTitulo","1" );
      ((Element)v.get(168)).setAttribute("horizBase","1" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 167   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(169)).setAttribute("borde","#999999" );
      ((Element)v.get(169)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(169)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(169)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(169)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(169)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(169)).setAttribute("horizBase","#999999" );
      ((Element)v.get(167)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:167   */

      /* Empieza nodo:170 / Elemento padre: 162   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(170)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(170)).setAttribute("alto","22" );
      ((Element)v.get(170)).setAttribute("imgFondo","" );
      ((Element)v.get(170)).setAttribute("cod","00135" );
      ((Element)v.get(170)).setAttribute("ID","datosTitle" );
      ((Element)v.get(162)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 162   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(171)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(171)).setAttribute("alto","22" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(171)).setAttribute("imgFondo","" );
      ((Element)v.get(162)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 162   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(172)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(172)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(172)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(172)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(172)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(172)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(162)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("ancho","85" );
      ((Element)v.get(173)).setAttribute("minimizable","S" );
      ((Element)v.get(173)).setAttribute("minimizada","N" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("ancho","75" );
      ((Element)v.get(174)).setAttribute("minimizable","S" );
      ((Element)v.get(174)).setAttribute("minimizada","N" );
      ((Element)v.get(172)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("ancho","75" );
      ((Element)v.get(175)).setAttribute("minimizable","S" );
      ((Element)v.get(175)).setAttribute("minimizada","N" );
      ((Element)v.get(172)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("ancho","115" );
      ((Element)v.get(176)).setAttribute("minimizable","S" );
      ((Element)v.get(176)).setAttribute("minimizada","N" );
      ((Element)v.get(172)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("ancho","100" );
      ((Element)v.get(177)).setAttribute("minimizable","S" );
      ((Element)v.get(177)).setAttribute("minimizada","N" );
      ((Element)v.get(172)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("ancho","100" );
      ((Element)v.get(178)).setAttribute("minimizable","S" );
      ((Element)v.get(178)).setAttribute("minimizada","N" );
      ((Element)v.get(172)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("ancho","100" );
      ((Element)v.get(179)).setAttribute("minimizable","S" );
      ((Element)v.get(179)).setAttribute("minimizada","N" );
      ((Element)v.get(172)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("ancho","100" );
      ((Element)v.get(180)).setAttribute("minimizable","S" );
      ((Element)v.get(180)).setAttribute("minimizada","N" );
      ((Element)v.get(172)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("ancho","100" );
      ((Element)v.get(181)).setAttribute("minimizable","S" );
      ((Element)v.get(181)).setAttribute("minimizada","N" );
      ((Element)v.get(172)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("ancho","250" );
      ((Element)v.get(182)).setAttribute("minimizable","S" );
      ((Element)v.get(182)).setAttribute("minimizada","N" );
      ((Element)v.get(172)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("ancho","250" );
      ((Element)v.get(183)).setAttribute("minimizable","S" );
      ((Element)v.get(183)).setAttribute("minimizada","N" );
      ((Element)v.get(172)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:172   */

      /* Empieza nodo:184 / Elemento padre: 162   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(184)).setAttribute("alto","20" );
      ((Element)v.get(184)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(184)).setAttribute("imgFondo","" );
      ((Element)v.get(184)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(162)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("colFondo","" );
      ((Element)v.get(185)).setAttribute("ID","EstCab" );
      ((Element)v.get(185)).setAttribute("align","center" );
      ((Element)v.get(185)).setAttribute("cod","226" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("colFondo","" );
      ((Element)v.get(186)).setAttribute("ID","EstCab" );
      ((Element)v.get(186)).setAttribute("align","center" );
      ((Element)v.get(186)).setAttribute("cod","171" );
      ((Element)v.get(184)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("colFondo","" );
      ((Element)v.get(187)).setAttribute("ID","EstCab" );
      ((Element)v.get(187)).setAttribute("align","center" );
      ((Element)v.get(187)).setAttribute("cod","674" );
      ((Element)v.get(184)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(188)).setAttribute("colFondo","" );
      ((Element)v.get(188)).setAttribute("ID","EstCab" );
      ((Element)v.get(188)).setAttribute("align","center" );
      ((Element)v.get(188)).setAttribute("cod","383" );
      ((Element)v.get(184)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("colFondo","" );
      ((Element)v.get(189)).setAttribute("ID","EstCab" );
      ((Element)v.get(189)).setAttribute("align","center" );
      ((Element)v.get(189)).setAttribute("cod","695" );
      ((Element)v.get(184)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("colFondo","" );
      ((Element)v.get(190)).setAttribute("ID","EstCab" );
      ((Element)v.get(190)).setAttribute("align","center" );
      ((Element)v.get(190)).setAttribute("cod","57" );
      ((Element)v.get(184)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("colFondo","" );
      ((Element)v.get(191)).setAttribute("ID","EstCab" );
      ((Element)v.get(191)).setAttribute("align","center" );
      ((Element)v.get(191)).setAttribute("cod","7" );
      ((Element)v.get(184)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("colFondo","" );
      ((Element)v.get(192)).setAttribute("ID","EstCab" );
      ((Element)v.get(192)).setAttribute("align","center" );
      ((Element)v.get(192)).setAttribute("cod","10" );
      ((Element)v.get(184)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("colFondo","" );
      ((Element)v.get(193)).setAttribute("ID","EstCab" );
      ((Element)v.get(193)).setAttribute("align","center" );
      ((Element)v.get(193)).setAttribute("cod","122" );
      ((Element)v.get(184)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("colFondo","" );
      ((Element)v.get(194)).setAttribute("ID","EstCab" );
      ((Element)v.get(194)).setAttribute("align","center" );
      ((Element)v.get(194)).setAttribute("cod","2508" );
      ((Element)v.get(184)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(195)).setAttribute("colFondo","" );
      ((Element)v.get(195)).setAttribute("ID","EstCab" );
      ((Element)v.get(195)).setAttribute("align","center" );
      ((Element)v.get(195)).setAttribute("cod","2509" );
      ((Element)v.get(184)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:184   */

      /* Empieza nodo:196 / Elemento padre: 162   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(196)).setAttribute("alto","22" );
      ((Element)v.get(196)).setAttribute("accion","" );
      ((Element)v.get(196)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(196)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(196)).setAttribute("maxSel","-1" );
      ((Element)v.get(196)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(196)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(196)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(196)).setAttribute("onLoad","" );
      ((Element)v.get(196)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(162)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(197)).setAttribute("tipo","texto" );
      ((Element)v.get(197)).setAttribute("ID","EstDat" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("tipo","texto" );
      ((Element)v.get(198)).setAttribute("ID","EstDat2" );
      ((Element)v.get(196)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(199)).setAttribute("tipo","texto" );
      ((Element)v.get(199)).setAttribute("ID","EstDat" );
      ((Element)v.get(196)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(200)).setAttribute("tipo","texto" );
      ((Element)v.get(200)).setAttribute("ID","EstDat2" );
      ((Element)v.get(196)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(201)).setAttribute("tipo","texto" );
      ((Element)v.get(201)).setAttribute("ID","EstDat" );
      ((Element)v.get(196)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(202)).setAttribute("tipo","texto" );
      ((Element)v.get(202)).setAttribute("ID","EstDat2" );
      ((Element)v.get(196)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(203)).setAttribute("tipo","texto" );
      ((Element)v.get(203)).setAttribute("ID","EstDat" );
      ((Element)v.get(196)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("tipo","texto" );
      ((Element)v.get(204)).setAttribute("ID","EstDat2" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(196)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(205)).setAttribute("tipo","texto" );
      ((Element)v.get(205)).setAttribute("ID","EstDat" );
      ((Element)v.get(196)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("tipo","texto" );
      ((Element)v.get(206)).setAttribute("ID","EstDat2" );
      ((Element)v.get(196)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("tipo","texto" );
      ((Element)v.get(207)).setAttribute("ID","EstDat" );
      ((Element)v.get(196)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:196   */

      /* Empieza nodo:208 / Elemento padre: 162   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(162)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 162   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(209)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(209)).setAttribute("ancho","732" );
      ((Element)v.get(209)).setAttribute("sep","$" );
      ((Element)v.get(209)).setAttribute("x","12" );
      ((Element)v.get(209)).setAttribute("class","botonera" );
      ((Element)v.get(209)).setAttribute("y","294" );
      ((Element)v.get(209)).setAttribute("control","|" );
      ((Element)v.get(209)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(209)).setAttribute("rowset","" );
      ((Element)v.get(209)).setAttribute("cargainicial","N" );
      ((Element)v.get(209)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(162)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(210)).setAttribute("nombre","ret1" );
      ((Element)v.get(210)).setAttribute("x","37" );
      ((Element)v.get(210)).setAttribute("y","298" );
      ((Element)v.get(210)).setAttribute("ID","botonContenido" );
      ((Element)v.get(210)).setAttribute("img","retroceder_on" );
      ((Element)v.get(210)).setAttribute("tipo","0" );
      ((Element)v.get(210)).setAttribute("estado","false" );
      ((Element)v.get(210)).setAttribute("alt","" );
      ((Element)v.get(210)).setAttribute("codigo","" );
      ((Element)v.get(210)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 209   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(211)).setAttribute("nombre","ava1" );
      ((Element)v.get(211)).setAttribute("x","52" );
      ((Element)v.get(211)).setAttribute("y","298" );
      ((Element)v.get(211)).setAttribute("ID","botonContenido" );
      ((Element)v.get(211)).setAttribute("img","avanzar_on" );
      ((Element)v.get(211)).setAttribute("tipo","0" );
      ((Element)v.get(211)).setAttribute("estado","false" );
      ((Element)v.get(211)).setAttribute("alt","" );
      ((Element)v.get(211)).setAttribute("codigo","" );
      ((Element)v.get(211)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(209)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:209   */
      /* Termina nodo:162   */

      /* Empieza nodo:212 / Elemento padre: 161   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(212)).setAttribute("nombre","primera1" );
      ((Element)v.get(212)).setAttribute("x","20" );
      ((Element)v.get(212)).setAttribute("y","298" );
      ((Element)v.get(212)).setAttribute("ID","botonContenido" );
      ((Element)v.get(212)).setAttribute("img","primera_on" );
      ((Element)v.get(212)).setAttribute("tipo","-2" );
      ((Element)v.get(212)).setAttribute("estado","false" );
      ((Element)v.get(212)).setAttribute("alt","" );
      ((Element)v.get(212)).setAttribute("codigo","" );
      ((Element)v.get(212)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(161)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 161   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(213)).setAttribute("nombre","separa" );
      ((Element)v.get(213)).setAttribute("x","59" );
      ((Element)v.get(213)).setAttribute("y","294" );
      ((Element)v.get(213)).setAttribute("ID","botonContenido" );
      ((Element)v.get(213)).setAttribute("img","separa_base" );
      ((Element)v.get(213)).setAttribute("tipo","0" );
      ((Element)v.get(213)).setAttribute("estado","false" );
      ((Element)v.get(213)).setAttribute("alt","" );
      ((Element)v.get(213)).setAttribute("codigo","" );
      ((Element)v.get(213)).setAttribute("accion","" );
      ((Element)v.get(161)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 161   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(214)).setAttribute("nombre","detalle" );
      ((Element)v.get(214)).setAttribute("x","80" );
      ((Element)v.get(214)).setAttribute("y","295" );
      ((Element)v.get(214)).setAttribute("ID","botonContenido" );
      ((Element)v.get(214)).setAttribute("tipo","html" );
      ((Element)v.get(214)).setAttribute("estado","false" );
      ((Element)v.get(214)).setAttribute("cod","3" );
      ((Element)v.get(214)).setAttribute("accion","accionDetalle();" );
      ((Element)v.get(214)).setAttribute("ontab","focalizaSiguienteDetalle();" );
      ((Element)v.get(214)).setAttribute("onshtab","focalizaAnteriorDetalle();" );
      ((Element)v.get(161)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:161   */

      /* Empieza nodo:215 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(215)).setAttribute("nombre","capaEspacio" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(215)).setAttribute("alto","12" );
      ((Element)v.get(215)).setAttribute("ancho","100%" );
      ((Element)v.get(215)).setAttribute("colorf","" );
      ((Element)v.get(215)).setAttribute("borde","0" );
      ((Element)v.get(215)).setAttribute("imagenf","" );
      ((Element)v.get(215)).setAttribute("repeat","" );
      ((Element)v.get(215)).setAttribute("padding","" );
      ((Element)v.get(215)).setAttribute("visibilidad","visible" );
      ((Element)v.get(215)).setAttribute("contravsb","" );
      ((Element)v.get(215)).setAttribute("x","0" );
      ((Element)v.get(215)).setAttribute("y","481" );
      ((Element)v.get(215)).setAttribute("zindex","" );
      ((Element)v.get(9)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:9   */


   }

}

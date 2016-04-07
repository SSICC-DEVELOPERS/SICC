
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cuenta_corriente_consultar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_cuenta_corriente_consultar" );
      ((Element)v.get(0)).setAttribute("cod","0841" );
      ((Element)v.get(0)).setAttribute("titulo","" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_cuenta_corriente_consultar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","Formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","codigoCliente" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hiddenDeudaTotal" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","pais" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","idioma" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(17)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(17)).setAttribute("x","0" );
      ((Element)v.get(17)).setAttribute("y","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("table"));
      ((Element)v.get(18)).setAttribute("width","100%" );
      ((Element)v.get(18)).setAttribute("border","0" );
      ((Element)v.get(18)).setAttribute("cellspacing","0" );
      ((Element)v.get(18)).setAttribute("cellpadding","0" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(20)).setAttribute("align","center" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(21)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(21)).setAttribute("height","12" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:22 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("width","750" );
      ((Element)v.get(19)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(19)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("height","1" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */
      /* Termina nodo:19   */

      /* Empieza nodo:26 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(31)).setAttribute("class","legend" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(32)).setAttribute("nombre","lblDatosCabecera" );
      ((Element)v.get(32)).setAttribute("alto","13" );
      ((Element)v.get(32)).setAttribute("filas","1" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(32)).setAttribute("id","legend" );
      ((Element)v.get(32)).setAttribute("cod","00156" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("table"));
      ((Element)v.get(33)).setAttribute("width","100%" );
      ((Element)v.get(33)).setAttribute("border","0" );
      ((Element)v.get(33)).setAttribute("align","center" );
      ((Element)v.get(33)).setAttribute("cellspacing","0" );
      ((Element)v.get(33)).setAttribute("cellpadding","0" );
      ((Element)v.get(30)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("table"));
      ((Element)v.get(36)).setAttribute("width","645" );
      ((Element)v.get(36)).setAttribute("border","0" );
      ((Element)v.get(36)).setAttribute("align","left" );
      ((Element)v.get(36)).setAttribute("cellspacing","0" );
      ((Element)v.get(36)).setAttribute("cellpadding","0" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("colspan","3" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","8" );
      ((Element)v.get(39)).setAttribute("height","8" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:40 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","8" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(44)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(44)).setAttribute("alto","13" );
      ((Element)v.get(44)).setAttribute("filas","1" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(44)).setAttribute("id","datosTitle" );
      ((Element)v.get(44)).setAttribute("cod","628" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","25" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(40)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(48)).setAttribute("nombre","lblNombre" );
      ((Element)v.get(48)).setAttribute("alto","13" );
      ((Element)v.get(48)).setAttribute("filas","1" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(48)).setAttribute("id","datosTitle" );
      ((Element)v.get(48)).setAttribute("cod","943" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("width","100%" );
      ((Element)v.get(40)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","8" );
      ((Element)v.get(50)).setAttribute("height","8" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:40   */

      /* Empieza nodo:51 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","8" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(55)).setAttribute("nombre","lblCodClientedt" );
      ((Element)v.get(55)).setAttribute("alto","13" );
      ((Element)v.get(55)).setAttribute("filas","1" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(55)).setAttribute("id","datosCampos" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","25" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(59)).setAttribute("nombre","lblNombredt" );
      ((Element)v.get(59)).setAttribute("alto","13" );
      ((Element)v.get(59)).setAttribute("filas","1" );
      ((Element)v.get(59)).setAttribute("valor","  " );
      ((Element)v.get(59)).setAttribute("id","datosCampos" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("width","100%" );
      ((Element)v.get(51)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","8" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:51   */

      /* Empieza nodo:62 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("colspan","3" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:65 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("table"));
      ((Element)v.get(67)).setAttribute("width","645" );
      ((Element)v.get(67)).setAttribute("border","0" );
      ((Element)v.get(67)).setAttribute("align","left" );
      ((Element)v.get(67)).setAttribute("cellspacing","0" );
      ((Element)v.get(67)).setAttribute("cellpadding","0" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(72)).setAttribute("nombre","lblRegionZonaTerritorio" );
      ((Element)v.get(72)).setAttribute("alto","13" );
      ((Element)v.get(72)).setAttribute("filas","1" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(72)).setAttribute("id","datosTitle" );
      ((Element)v.get(72)).setAttribute("cod","2844" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","25" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(76)).setAttribute("nombre","lblEstado" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(76)).setAttribute("id","datosTitle" );
      ((Element)v.get(76)).setAttribute("cod","400" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","25" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(80)).setAttribute("nombre","lblTipoDi" );
      ((Element)v.get(80)).setAttribute("alto","13" );
      ((Element)v.get(80)).setAttribute("filas","1" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(80)).setAttribute("id","datosTitle" );
      ((Element)v.get(80)).setAttribute("cod","1126" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","25" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(84)).setAttribute("nombre","lblDocIdentidad" );
      ((Element)v.get(84)).setAttribute("alto","13" );
      ((Element)v.get(84)).setAttribute("filas","1" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(84)).setAttribute("id","datosTitle" );
      ((Element)v.get(84)).setAttribute("cod","1533" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("width","100%" );
      ((Element)v.get(68)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:68   */

      /* Empieza nodo:87 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(91)).setAttribute("nombre","lblRegionZonaTerritoriodt" );
      ((Element)v.get(91)).setAttribute("alto","13" );
      ((Element)v.get(91)).setAttribute("filas","1" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(91)).setAttribute("id","datosCampos" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(93)).setAttribute("width","25" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(95)).setAttribute("nombre","lblEstadodt" );
      ((Element)v.get(95)).setAttribute("alto","13" );
      ((Element)v.get(95)).setAttribute("filas","1" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(95)).setAttribute("id","datosCampos" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","25" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(99)).setAttribute("nombre","lblTipoDidt" );
      ((Element)v.get(99)).setAttribute("alto","13" );
      ((Element)v.get(99)).setAttribute("filas","1" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(99)).setAttribute("id","datosCampos" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","25" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(103)).setAttribute("nombre","lblDocIdentidaddt" );
      ((Element)v.get(103)).setAttribute("alto","13" );
      ((Element)v.get(103)).setAttribute("filas","1" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(103)).setAttribute("id","datosCampos" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("width","100%" );
      ((Element)v.get(87)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","8" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:87   */

      /* Empieza nodo:106 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("colspan","3" );
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
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:109 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("table"));
      ((Element)v.get(111)).setAttribute("width","645" );
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
      ((Element)v.get(116)).setAttribute("nombre","lblDeudaTotal" );
      ((Element)v.get(116)).setAttribute("alto","13" );
      ((Element)v.get(116)).setAttribute("filas","1" );
      ((Element)v.get(116)).setAttribute("valor","" );
      ((Element)v.get(116)).setAttribute("id","datosTitle" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(116)).setAttribute("cod","2842" );
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
      ((Element)v.get(120)).setAttribute("nombre","lblFechaHora" );
      ((Element)v.get(120)).setAttribute("alto","13" );
      ((Element)v.get(120)).setAttribute("filas","1" );
      ((Element)v.get(120)).setAttribute("valor","" );
      ((Element)v.get(120)).setAttribute("id","datosTitle" );
      ((Element)v.get(120)).setAttribute("cod","2843" );
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
      ((Element)v.get(124)).setAttribute("nombre","lblLineaDisponible" );
      ((Element)v.get(124)).setAttribute("alto","13" );
      ((Element)v.get(124)).setAttribute("filas","1" );
      ((Element)v.get(124)).setAttribute("valor","" );
      ((Element)v.get(124)).setAttribute("id","datosTitle" );
      ((Element)v.get(124)).setAttribute("cod","1455" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","25" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(128)).setAttribute("nombre","lblLineaCredito" );
      ((Element)v.get(128)).setAttribute("alto","13" );
      ((Element)v.get(128)).setAttribute("filas","1" );
      ((Element)v.get(128)).setAttribute("valor","" );
      ((Element)v.get(128)).setAttribute("id","datosTitle" );
      ((Element)v.get(128)).setAttribute("cod","910" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","25" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(132)).setAttribute("nombre","lblCampanaIngreso" );
      ((Element)v.get(132)).setAttribute("alto","13" );
      ((Element)v.get(132)).setAttribute("filas","1" );
      ((Element)v.get(132)).setAttribute("valor","" );
      ((Element)v.get(132)).setAttribute("id","datosTitle" );
      ((Element)v.get(132)).setAttribute("cod","499" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","25" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(136)).setAttribute("nombre","lblRiesgo" );
      ((Element)v.get(136)).setAttribute("alto","13" );
      ((Element)v.get(136)).setAttribute("filas","1" );
      ((Element)v.get(136)).setAttribute("valor","" );
      ((Element)v.get(136)).setAttribute("id","datosTitle" );
      ((Element)v.get(136)).setAttribute("cod","2845" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("width","100%" );
      ((Element)v.get(112)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:112   */

      /* Empieza nodo:139 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(111)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(143)).setAttribute("nombre","lblDeudaTotaldt" );
      ((Element)v.get(143)).setAttribute("alto","13" );
      ((Element)v.get(143)).setAttribute("filas","1" );
      ((Element)v.get(143)).setAttribute("valor","" );
      ((Element)v.get(143)).setAttribute("id","datosCampos" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","25" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(147)).setAttribute("nombre","lblFechaHoradt" );
      ((Element)v.get(147)).setAttribute("alto","13" );
      ((Element)v.get(147)).setAttribute("filas","1" );
      ((Element)v.get(147)).setAttribute("valor","" );
      ((Element)v.get(147)).setAttribute("id","datosCampos" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","25" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(151)).setAttribute("nombre","lblLineaDisponibledt" );
      ((Element)v.get(151)).setAttribute("alto","13" );
      ((Element)v.get(151)).setAttribute("filas","1" );
      ((Element)v.get(151)).setAttribute("valor","" );
      ((Element)v.get(151)).setAttribute("id","datosCampos" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","25" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(155)).setAttribute("nombre","lblLineaCreditodt" );
      ((Element)v.get(155)).setAttribute("alto","13" );
      ((Element)v.get(155)).setAttribute("filas","1" );
      ((Element)v.get(155)).setAttribute("valor","" );
      ((Element)v.get(155)).setAttribute("id","datosCampos" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","25" );
      ((Element)v.get(157)).setAttribute("height","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(159)).setAttribute("nombre","lblCampanaIngresodt" );
      ((Element)v.get(159)).setAttribute("alto","13" );
      ((Element)v.get(159)).setAttribute("filas","1" );
      ((Element)v.get(159)).setAttribute("valor","" );
      ((Element)v.get(159)).setAttribute("id","datosCampos" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","25" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(163)).setAttribute("nombre","lblRiesgodt" );
      ((Element)v.get(163)).setAttribute("alto","13" );
      ((Element)v.get(163)).setAttribute("filas","1" );
      ((Element)v.get(163)).setAttribute("valor","" );
      ((Element)v.get(163)).setAttribute("id","datosCampos" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("width","100%" );
      ((Element)v.get(139)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","8" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:139   */

      /* Empieza nodo:166 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(111)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("colspan","3" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:169 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("table"));
      ((Element)v.get(171)).setAttribute("width","645" );
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
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","8" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(176)).setAttribute("nombre","lblDireccion" );
      ((Element)v.get(176)).setAttribute("alto","13" );
      ((Element)v.get(176)).setAttribute("filas","1" );
      ((Element)v.get(176)).setAttribute("valor","" );
      ((Element)v.get(176)).setAttribute("id","datosTitle" );
      ((Element)v.get(176)).setAttribute("cod","53" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","25" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(180)).setAttribute("nombre","lblFechaNaci" );
      ((Element)v.get(180)).setAttribute("alto","13" );
      ((Element)v.get(180)).setAttribute("filas","1" );
      ((Element)v.get(180)).setAttribute("valor","" );
      ((Element)v.get(180)).setAttribute("id","datosTitle" );
      ((Element)v.get(180)).setAttribute("cod","877" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","25" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(184)).setAttribute("nombre","lblpagoSaldoVencido" );
      ((Element)v.get(184)).setAttribute("alto","13" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(184)).setAttribute("filas","1" );
      ((Element)v.get(184)).setAttribute("valor","" );
      ((Element)v.get(184)).setAttribute("id","datosTitle" );
      ((Element)v.get(184)).setAttribute("cod","CCC0401" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","25" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(188)).setAttribute("nombre","lblSaldoPorVencer" );
      ((Element)v.get(188)).setAttribute("alto","13" );
      ((Element)v.get(188)).setAttribute("filas","1" );
      ((Element)v.get(188)).setAttribute("valor","" );
      ((Element)v.get(188)).setAttribute("id","datosTitle" );
      ((Element)v.get(188)).setAttribute("cod","CCC0402" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).setAttribute("width","100%" );
      ((Element)v.get(172)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","8" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:172   */

      /* Empieza nodo:191 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","8" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(195)).setAttribute("nombre","lblDirecciondt" );
      ((Element)v.get(195)).setAttribute("alto","13" );
      ((Element)v.get(195)).setAttribute("filas","1" );
      ((Element)v.get(195)).setAttribute("valor","" );
      ((Element)v.get(195)).setAttribute("id","datosCampos" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","25" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(199)).setAttribute("nombre","lblFechaNacidt" );
      ((Element)v.get(199)).setAttribute("alto","13" );
      ((Element)v.get(199)).setAttribute("filas","1" );
      ((Element)v.get(199)).setAttribute("valor","" );
      ((Element)v.get(199)).setAttribute("id","datosCampos" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","25" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(203)).setAttribute("nombre","lblpagoSaldoVencidot" );
      ((Element)v.get(203)).setAttribute("alto","13" );
      ((Element)v.get(203)).setAttribute("filas","1" );
      ((Element)v.get(203)).setAttribute("valor","" );
      ((Element)v.get(203)).setAttribute("id","datosCampos" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","25" );
      ((Element)v.get(205)).setAttribute("height","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(207)).setAttribute("nombre","lblSaldoPorVencert" );
      ((Element)v.get(207)).setAttribute("alto","13" );
      ((Element)v.get(207)).setAttribute("filas","1" );
      ((Element)v.get(207)).setAttribute("valor","" );
      ((Element)v.get(207)).setAttribute("id","datosCampos" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("width","100%" );
      ((Element)v.get(191)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:191   */

      /* Empieza nodo:210 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).setAttribute("colspan","3" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","8" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:33   */
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:213 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:26   */

      /* Empieza nodo:215 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).setAttribute("width","12" );
      ((Element)v.get(216)).setAttribute("align","center" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(217)).setAttribute("width","12" );
      ((Element)v.get(217)).setAttribute("height","12" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).setAttribute("width","756" );
      ((Element)v.get(215)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).setAttribute("width","12" );
      ((Element)v.get(215)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","12" );
      ((Element)v.get(221)).setAttribute("height","1" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:215   */
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:222 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(222)).setAttribute("nombre","listado1" );
      ((Element)v.get(222)).setAttribute("ancho","648" );
      ((Element)v.get(222)).setAttribute("alto","317" );
      ((Element)v.get(222)).setAttribute("x","12" );
      ((Element)v.get(222)).setAttribute("y","192" );
      ((Element)v.get(222)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(222)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(223)).setAttribute("precarga","S" );
      ((Element)v.get(223)).setAttribute("conROver","S" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(224)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(224)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(224)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(224)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 223   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(225)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(225)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(225)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(225)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(223)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 223   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(226)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(226)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(223)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:223   */

      /* Empieza nodo:227 / Elemento padre: 222   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(222)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(228)).setAttribute("borde","1" );
      ((Element)v.get(228)).setAttribute("horizDatos","1" );
      ((Element)v.get(228)).setAttribute("horizCabecera","1" );
      ((Element)v.get(228)).setAttribute("vertical","1" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(228)).setAttribute("horizTitulo","1" );
      ((Element)v.get(228)).setAttribute("horizBase","1" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 227   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(229)).setAttribute("borde","#999999" );
      ((Element)v.get(229)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(229)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(229)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(229)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(229)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(229)).setAttribute("horizBase","#999999" );
      ((Element)v.get(227)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:227   */

      /* Empieza nodo:230 / Elemento padre: 222   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(230)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(230)).setAttribute("alto","22" );
      ((Element)v.get(230)).setAttribute("imgFondo","" );
      ((Element)v.get(230)).setAttribute("cod","00418" );
      ((Element)v.get(230)).setAttribute("ID","datosTitle" );
      ((Element)v.get(222)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 222   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(231)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(231)).setAttribute("alto","22" );
      ((Element)v.get(231)).setAttribute("imgFondo","" );
      ((Element)v.get(222)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 222   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(232)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(232)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(232)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(232)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(232)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(232)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(222)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(233)).setAttribute("ancho","120" );
      ((Element)v.get(233)).setAttribute("minimizable","S" );
      ((Element)v.get(233)).setAttribute("minimizada","N" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */

      /* Empieza nodo:234 / Elemento padre: 232   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(234)).setAttribute("ancho","100" );
      ((Element)v.get(234)).setAttribute("orden","dd-mm-aaaa" );
      ((Element)v.get(234)).setAttribute("minimizable","S" );
      ((Element)v.get(234)).setAttribute("minimizada","N" );
      ((Element)v.get(232)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 232   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(235)).setAttribute("ancho","100" );
      ((Element)v.get(235)).setAttribute("minimizable","S" );
      ((Element)v.get(235)).setAttribute("minimizada","N" );
      ((Element)v.get(232)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 232   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(236)).setAttribute("ancho","100" );
      ((Element)v.get(236)).setAttribute("minimizable","S" );
      ((Element)v.get(236)).setAttribute("minimizada","N" );
      ((Element)v.get(232)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 232   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(237)).setAttribute("ancho","100" );
      ((Element)v.get(237)).setAttribute("minimizable","S" );
      ((Element)v.get(237)).setAttribute("minimizada","N" );
      ((Element)v.get(232)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 232   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(238)).setAttribute("ancho","100" );
      ((Element)v.get(238)).setAttribute("minimizable","S" );
      ((Element)v.get(238)).setAttribute("minimizada","N" );
      ((Element)v.get(232)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 232   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(239)).setAttribute("ancho","100" );
      ((Element)v.get(239)).setAttribute("minimizable","S" );
      ((Element)v.get(239)).setAttribute("minimizada","N" );
      ((Element)v.get(232)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 232   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(240)).setAttribute("ancho","100" );
      ((Element)v.get(240)).setAttribute("minimizable","S" );
      ((Element)v.get(240)).setAttribute("minimizada","N" );
      ((Element)v.get(232)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 232   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(241)).setAttribute("ancho","100" );
      ((Element)v.get(241)).setAttribute("minimizable","S" );
      ((Element)v.get(241)).setAttribute("minimizada","N" );
      ((Element)v.get(232)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 232   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(242)).setAttribute("ancho","100" );
      ((Element)v.get(242)).setAttribute("minimizable","S" );
      ((Element)v.get(242)).setAttribute("minimizada","N" );
      ((Element)v.get(242)).setAttribute("oculta","S" );
      ((Element)v.get(232)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 232   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(243)).setAttribute("ancho","100" );
      ((Element)v.get(243)).setAttribute("minimizable","S" );
      ((Element)v.get(243)).setAttribute("minimizada","N" );
      ((Element)v.get(243)).setAttribute("oculta","S" );
      ((Element)v.get(232)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 232   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(244)).setAttribute("ancho","100" );
      ((Element)v.get(244)).setAttribute("minimizable","S" );
      ((Element)v.get(244)).setAttribute("minimizada","N" );
      ((Element)v.get(244)).setAttribute("oculta","S" );
      ((Element)v.get(232)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 232   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(245)).setAttribute("ancho","100" );
      ((Element)v.get(245)).setAttribute("minimizable","S" );
      ((Element)v.get(245)).setAttribute("minimizada","N" );
      ((Element)v.get(245)).setAttribute("oculta","S" );
      ((Element)v.get(232)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */

      /* Empieza nodo:246 / Elemento padre: 232   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(246)).setAttribute("ancho","100" );
      ((Element)v.get(246)).setAttribute("minimizable","S" );
      ((Element)v.get(246)).setAttribute("minimizada","N" );
      ((Element)v.get(246)).setAttribute("oculta","S" );
      ((Element)v.get(232)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */

      /* Empieza nodo:247 / Elemento padre: 232   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(247)).setAttribute("ancho","100" );
      ((Element)v.get(247)).setAttribute("minimizable","S" );
      ((Element)v.get(247)).setAttribute("minimizada","N" );
      ((Element)v.get(247)).setAttribute("oculta","S" );
      ((Element)v.get(232)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 232   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(248)).setAttribute("ancho","100" );
      ((Element)v.get(248)).setAttribute("minimizable","S" );
      ((Element)v.get(248)).setAttribute("minimizada","N" );
      ((Element)v.get(232)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:232   */

      /* Empieza nodo:249 / Elemento padre: 222   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(249)).setAttribute("alto","20" );
      ((Element)v.get(249)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(249)).setAttribute("imgFondo","" );
      ((Element)v.get(249)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(222)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(250)).setAttribute("colFondo","" );
      ((Element)v.get(250)).setAttribute("ID","EstCab" );
      ((Element)v.get(250)).setAttribute("cod","2846" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(251)).setAttribute("colFondo","" );
      ((Element)v.get(251)).setAttribute("ID","EstCab" );
      ((Element)v.get(251)).setAttribute("cod","656" );
      ((Element)v.get(249)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("colFondo","" );
      ((Element)v.get(252)).setAttribute("ID","EstCab" );
      ((Element)v.get(252)).setAttribute("cod","2022" );
      ((Element)v.get(249)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(253)).setAttribute("colFondo","" );
      ((Element)v.get(253)).setAttribute("ID","EstCab" );
      ((Element)v.get(253)).setAttribute("cod","422" );
      ((Element)v.get(249)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(254)).setAttribute("colFondo","" );
      ((Element)v.get(254)).setAttribute("ID","EstCab" );
      ((Element)v.get(254)).setAttribute("cod","2672" );
      ((Element)v.get(249)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("colFondo","" );
      ((Element)v.get(255)).setAttribute("ID","EstCab" );
      ((Element)v.get(255)).setAttribute("cod","617" );
      ((Element)v.get(249)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(256)).setAttribute("colFondo","" );
      ((Element)v.get(256)).setAttribute("ID","EstCab" );
      ((Element)v.get(256)).setAttribute("cod","810" );
      ((Element)v.get(249)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("colFondo","" );
      ((Element)v.get(257)).setAttribute("ID","EstCab" );
      ((Element)v.get(257)).setAttribute("cod","573" );
      ((Element)v.get(249)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(258)).setAttribute("colFondo","" );
      ((Element)v.get(258)).setAttribute("ID","EstCab" );
      ((Element)v.get(258)).setAttribute("cod","1142" );
      ((Element)v.get(249)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(259)).setAttribute("colFondo","" );
      ((Element)v.get(259)).setAttribute("ID","EstCab" );
      ((Element)v.get(259)).setAttribute("cod","100" );
      ((Element)v.get(249)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(260)).setAttribute("colFondo","" );
      ((Element)v.get(260)).setAttribute("ID","EstCab" );
      ((Element)v.get(260)).setAttribute("cod","100" );
      ((Element)v.get(249)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 249   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(261)).setAttribute("colFondo","" );
      ((Element)v.get(261)).setAttribute("ID","EstCab" );
      ((Element)v.get(261)).setAttribute("cod","100" );
      ((Element)v.get(249)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */

      /* Empieza nodo:262 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(262)).setAttribute("colFondo","" );
      ((Element)v.get(262)).setAttribute("ID","EstCab" );
      ((Element)v.get(262)).setAttribute("cod","100" );
      ((Element)v.get(249)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(263)).setAttribute("colFondo","" );
      ((Element)v.get(263)).setAttribute("ID","EstCab" );
      ((Element)v.get(263)).setAttribute("cod","100" );
      ((Element)v.get(249)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */

      /* Empieza nodo:264 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(264)).setAttribute("colFondo","" );
      ((Element)v.get(264)).setAttribute("ID","EstCab" );
      ((Element)v.get(264)).setAttribute("cod","100" );
      ((Element)v.get(249)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("colFondo","" );
      ((Element)v.get(265)).setAttribute("ID","EstCab" );
      ((Element)v.get(265)).setAttribute("cod","883" );
      ((Element)v.get(249)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:249   */

      /* Empieza nodo:266 / Elemento padre: 222   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(266)).setAttribute("alto","22" );
      ((Element)v.get(266)).setAttribute("accion","" );
      ((Element)v.get(266)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(266)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(266)).setAttribute("maxSel","-1" );
      ((Element)v.get(266)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(266)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(266)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(266)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(222)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(267)).setAttribute("tipo","texto" );
      ((Element)v.get(267)).setAttribute("ID","EstDat" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("tipo","texto" );
      ((Element)v.get(268)).setAttribute("ID","EstDat2" );
      ((Element)v.get(266)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("tipo","texto" );
      ((Element)v.get(269)).setAttribute("ID","EstDat" );
      ((Element)v.get(266)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("tipo","texto" );
      ((Element)v.get(270)).setAttribute("ID","EstDat2" );
      ((Element)v.get(266)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(271)).setAttribute("tipo","texto" );
      ((Element)v.get(271)).setAttribute("ID","EstDat" );
      ((Element)v.get(266)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("tipo","texto" );
      ((Element)v.get(272)).setAttribute("ID","EstDat2" );
      ((Element)v.get(266)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("tipo","texto" );
      ((Element)v.get(273)).setAttribute("ID","EstDat" );
      ((Element)v.get(266)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("tipo","texto" );
      ((Element)v.get(274)).setAttribute("ID","EstDat2" );
      ((Element)v.get(266)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("tipo","texto" );
      ((Element)v.get(275)).setAttribute("ID","EstDat" );
      ((Element)v.get(266)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("tipo","texto" );
      ((Element)v.get(276)).setAttribute("ID","EstDat2" );
      ((Element)v.get(266)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("tipo","texto" );
      ((Element)v.get(277)).setAttribute("ID","EstDat" );
      ((Element)v.get(266)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("tipo","texto" );
      ((Element)v.get(278)).setAttribute("ID","EstDat2" );
      ((Element)v.get(266)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("tipo","texto" );
      ((Element)v.get(279)).setAttribute("ID","EstDat" );
      ((Element)v.get(266)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("tipo","texto" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(280)).setAttribute("ID","EstDat2" );
      ((Element)v.get(266)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(281)).setAttribute("tipo","texto" );
      ((Element)v.get(281)).setAttribute("ID","EstDat" );
      ((Element)v.get(266)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(282)).setAttribute("tipo","texto" );
      ((Element)v.get(282)).setAttribute("ID","EstDat2" );
      ((Element)v.get(266)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:266   */

      /* Empieza nodo:283 / Elemento padre: 222   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(222)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 222   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(284)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(284)).setAttribute("ancho","648" );
      ((Element)v.get(284)).setAttribute("sep","$" );
      ((Element)v.get(284)).setAttribute("x","12" );
      ((Element)v.get(284)).setAttribute("class","botonera" );
      ((Element)v.get(284)).setAttribute("y","452" );
      ((Element)v.get(284)).setAttribute("control","|" );
      ((Element)v.get(284)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(284)).setAttribute("rowset","" );
      ((Element)v.get(284)).setAttribute("cargainicial","N" );
      ((Element)v.get(222)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(285)).setAttribute("nombre","ret1" );
      ((Element)v.get(285)).setAttribute("x","37" );
      ((Element)v.get(285)).setAttribute("y","490" );
      ((Element)v.get(285)).setAttribute("ID","botonContenido" );
      ((Element)v.get(285)).setAttribute("img","retroceder_on" );
      ((Element)v.get(285)).setAttribute("tipo","0" );
      ((Element)v.get(285)).setAttribute("estado","false" );
      ((Element)v.get(285)).setAttribute("alt","" );
      ((Element)v.get(285)).setAttribute("codigo","" );
      ((Element)v.get(285)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 284   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(286)).setAttribute("nombre","ava1" );
      ((Element)v.get(286)).setAttribute("x","52" );
      ((Element)v.get(286)).setAttribute("y","490" );
      ((Element)v.get(286)).setAttribute("ID","botonContenido" );
      ((Element)v.get(286)).setAttribute("img","avanzar_on" );
      ((Element)v.get(286)).setAttribute("tipo","0" );
      ((Element)v.get(286)).setAttribute("estado","false" );
      ((Element)v.get(286)).setAttribute("alt","" );
      ((Element)v.get(286)).setAttribute("codigo","" );
      ((Element)v.get(286)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(284)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:284   */
      /* Termina nodo:222   */

      /* Empieza nodo:287 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(287)).setAttribute("nombre","primera1" );
      ((Element)v.get(287)).setAttribute("x","20" );
      ((Element)v.get(287)).setAttribute("y","490" );
      ((Element)v.get(287)).setAttribute("ID","botonContenido" );
      ((Element)v.get(287)).setAttribute("img","primera_on" );
      ((Element)v.get(287)).setAttribute("tipo","0" );
      ((Element)v.get(287)).setAttribute("estado","false" );
      ((Element)v.get(287)).setAttribute("alt","" );
      ((Element)v.get(287)).setAttribute("codigo","" );
      ((Element)v.get(287)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(288)).setAttribute("nombre","separa1" );
      ((Element)v.get(288)).setAttribute("x","59" );
      ((Element)v.get(288)).setAttribute("y","486" );
      ((Element)v.get(288)).setAttribute("ID","botonContenido" );
      ((Element)v.get(288)).setAttribute("img","separa_base" );
      ((Element)v.get(288)).setAttribute("tipo","0" );
      ((Element)v.get(288)).setAttribute("estado","false" );
      ((Element)v.get(288)).setAttribute("alt","" );
      ((Element)v.get(288)).setAttribute("codigo","" );
      ((Element)v.get(288)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(289)).setAttribute("nombre","SaldoCampanas" );
      ((Element)v.get(289)).setAttribute("x","13" );
      ((Element)v.get(289)).setAttribute("y","487" );
      ((Element)v.get(289)).setAttribute("ID","botonContenido" );
      ((Element)v.get(289)).setAttribute("img","" );
      ((Element)v.get(289)).setAttribute("tipo","html" );
      ((Element)v.get(289)).setAttribute("estado","false" );
      ((Element)v.get(289)).setAttribute("alt","" );
      ((Element)v.get(289)).setAttribute("cod","2847" );
      ((Element)v.get(289)).setAttribute("accion","saldoCampana();" );
      ((Element)v.get(6)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(290)).setAttribute("nombre","OrdenarFechaValor" );
      ((Element)v.get(290)).setAttribute("x","152" );
      ((Element)v.get(290)).setAttribute("y","487" );
      ((Element)v.get(290)).setAttribute("ID","botonContenido" );
      ((Element)v.get(290)).setAttribute("img","" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(290)).setAttribute("tipo","html" );
      ((Element)v.get(290)).setAttribute("estado","false" );
      ((Element)v.get(290)).setAttribute("alt","" );
      ((Element)v.get(290)).setAttribute("cod","2848" );
      ((Element)v.get(290)).setAttribute("accion","ordenar()" );
      ((Element)v.get(6)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(291)).setAttribute("nombre","Detalle" );
      ((Element)v.get(291)).setAttribute("x","299" );
      ((Element)v.get(291)).setAttribute("y","487" );
      ((Element)v.get(291)).setAttribute("ID","botonContenido" );
      ((Element)v.get(291)).setAttribute("img","" );
      ((Element)v.get(291)).setAttribute("tipo","html" );
      ((Element)v.get(291)).setAttribute("estado","false" );
      ((Element)v.get(291)).setAttribute("alt","" );
      ((Element)v.get(291)).setAttribute("cod","3" );
      ((Element)v.get(291)).setAttribute("accion","detalle();" );
      ((Element)v.get(6)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(292)).setAttribute("nombre","Cobranza" );
      ((Element)v.get(292)).setAttribute("x","347" );
      ((Element)v.get(292)).setAttribute("y","487" );
      ((Element)v.get(292)).setAttribute("ID","botonContenido" );
      ((Element)v.get(292)).setAttribute("img","" );
      ((Element)v.get(292)).setAttribute("tipo","html" );
      ((Element)v.get(292)).setAttribute("estado","false" );
      ((Element)v.get(292)).setAttribute("alt","" );
      ((Element)v.get(292)).setAttribute("cod","2849" );
      ((Element)v.get(292)).setAttribute("accion","cobranza();" );
      ((Element)v.get(6)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(293)).setAttribute("nombre","capaEspacio2" );
      ((Element)v.get(293)).setAttribute("alto","18" );
      ((Element)v.get(293)).setAttribute("ancho","100" );
      ((Element)v.get(293)).setAttribute("colorf","" );
      ((Element)v.get(293)).setAttribute("borde","0" );
      ((Element)v.get(293)).setAttribute("imagenf","" );
      ((Element)v.get(293)).setAttribute("repeat","" );
      ((Element)v.get(293)).setAttribute("padding","" );
      ((Element)v.get(293)).setAttribute("visibilidad","visible" );
      ((Element)v.get(293)).setAttribute("contravsb","" );
      ((Element)v.get(293)).setAttribute("x","0" );
      ((Element)v.get(293)).setAttribute("y","475" );
      ((Element)v.get(293)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:6   */

      /* Empieza nodo:294 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(294)).setAttribute("nombre","frmContenidoEnvia" );
      ((Element)v.get(294)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(295)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(295)).setAttribute("valor","" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 294   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(296)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(296)).setAttribute("valor","" );
      ((Element)v.get(294)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 294   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(297)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(297)).setAttribute("valor","" );
      ((Element)v.get(294)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:294   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_bolsa_faltantes_mantener  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","" );
      ((Element)v.get(0)).setAttribute("cod","0526" );
      ((Element)v.get(0)).setAttribute("titulo","Mantener bolsa de faltantes" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","bolsa_faltantes_mantener" );
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
      ((Element)v.get(5)).setAttribute("src","contenido_bolsa_faltantes_mantener.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","validaciones_sicc.js" );
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
      ((Element)v.get(9)).setAttribute("name","cbSituacionRegistro" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","2584" );
      ((Element)v.get(9)).setAttribute("group","situacionRegistro" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:8   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(10)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(11)).setAttribute("valor","LPMantenerBolsaDeFaltantes" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","accion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","ListadoDisponible" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","oidSituacionRegistro" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","oidConcurso" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","OidSolicitud" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","OidCliente" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","numero_premio" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","oidRegion" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("nombre","oidZona" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hPais" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hConstSitRegHist" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(27)).setAttribute("nombre","capa1" );
      ((Element)v.get(10)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("table"));
      ((Element)v.get(28)).setAttribute("width","100%" );
      ((Element)v.get(28)).setAttribute("border","0" );
      ((Element)v.get(28)).setAttribute("cellspacing","0" );
      ((Element)v.get(28)).setAttribute("cellpadding","0" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).setAttribute("width","12" );
      ((Element)v.get(30)).setAttribute("align","center" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).setAttribute("width","12" );
      ((Element)v.get(31)).setAttribute("height","12" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).setAttribute("width","750" );
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).setAttribute("width","12" );
      ((Element)v.get(29)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).setAttribute("width","12" );
      ((Element)v.get(35)).setAttribute("height","1" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:29   */

      /* Empieza nodo:36 / Elemento padre: 28   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(28)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(41)).setAttribute("class","legend" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(42)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(42)).setAttribute("alto","13" );
      ((Element)v.get(42)).setAttribute("filas","1" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(42)).setAttribute("cod","0075" );
      ((Element)v.get(42)).setAttribute("id","legend" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 40   */
      v.add(doc.createElement("table"));
      ((Element)v.get(43)).setAttribute("width","100%" );
      ((Element)v.get(43)).setAttribute("border","0" );
      ((Element)v.get(43)).setAttribute("align","center" );
      ((Element)v.get(43)).setAttribute("cellspacing","0" );
      ((Element)v.get(43)).setAttribute("cellpadding","0" );
      ((Element)v.get(40)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("table"));
      ((Element)v.get(46)).setAttribute("width","600" );
      ((Element)v.get(46)).setAttribute("border","0" );
      ((Element)v.get(46)).setAttribute("align","left" );
      ((Element)v.get(46)).setAttribute("cellspacing","0" );
      ((Element)v.get(46)).setAttribute("cellpadding","0" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("colspan","4" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:50 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(50));

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
      ((Element)v.get(50)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(54)).setAttribute("nombre","lblSituacionRegistro" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(54)).setAttribute("id","datosTitle" );
      ((Element)v.get(54)).setAttribute("cod","2584" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","25" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(58)).setAttribute("nombre","lblCodConcurso" );
      ((Element)v.get(58)).setAttribute("alto","13" );
      ((Element)v.get(58)).setAttribute("filas","1" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(58)).setAttribute("id","datosTitle" );
      ((Element)v.get(58)).setAttribute("cod","1656" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","25" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(62)).setAttribute("nombre","lblCodProducto" );
      ((Element)v.get(62)).setAttribute("alto","13" );
      ((Element)v.get(62)).setAttribute("filas","1" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(62)).setAttribute("id","datosTitle" );
      ((Element)v.get(62)).setAttribute("cod","337" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","100%" );
      ((Element)v.get(50)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:50   */

      /* Empieza nodo:65 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(68)).setAttribute("valign","top" );
      ((Element)v.get(65)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(69)).setAttribute("nombre","cbSituacionRegistro" );
      ((Element)v.get(69)).setAttribute("id","datosCampos" );
      ((Element)v.get(69)).setAttribute("size","1" );
      ((Element)v.get(69)).setAttribute("multiple","N" );
      ((Element)v.get(69)).setAttribute("req","S" );
      ((Element)v.get(69)).setAttribute("valorinicial","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).setAttribute("textoinicial","" );
      ((Element)v.get(69)).setAttribute("onchange","onChangeCbSituacionRegistro()" );
      ((Element)v.get(69)).setAttribute("ontab","focaliza('formulario.cbCodConcurso');" );
      ((Element)v.get(69)).setAttribute("onshtab","document.all.btnBuscar.focus();" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:71 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","25" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(73)).setAttribute("valign","top" );
      ((Element)v.get(65)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(74)).setAttribute("nombre","cbCodConcurso" );
      ((Element)v.get(74)).setAttribute("id","datosCampos" );
      ((Element)v.get(74)).setAttribute("size","1" );
      ((Element)v.get(74)).setAttribute("multiple","N" );
      ((Element)v.get(74)).setAttribute("req","N" );
      ((Element)v.get(74)).setAttribute("valorinicial","" );
      ((Element)v.get(74)).setAttribute("textoinicial","" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:76 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","25" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(65)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(79)).setAttribute("nombre","cbCodProducto" );
      ((Element)v.get(79)).setAttribute("id","datosCampos" );
      ((Element)v.get(79)).setAttribute("size","5" );
      ((Element)v.get(79)).setAttribute("multiple","S" );
      ((Element)v.get(79)).setAttribute("req","N" );
      ((Element)v.get(79)).setAttribute("valorinicial","" );
      ((Element)v.get(79)).setAttribute("textoinicial","" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:81 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","100%" );
      ((Element)v.get(65)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:65   */

      /* Empieza nodo:83 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("colspan","4" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:86 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("table"));
      ((Element)v.get(88)).setAttribute("width","100%" );
      ((Element)v.get(88)).setAttribute("border","0" );
      ((Element)v.get(88)).setAttribute("align","center" );
      ((Element)v.get(88)).setAttribute("cellspacing","0" );
      ((Element)v.get(88)).setAttribute("cellpadding","0" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("width","12" );
      ((Element)v.get(90)).setAttribute("align","center" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 89   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("width","100%" );
      ((Element)v.get(89)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("width","12" );
      ((Element)v.get(89)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","12" );
      ((Element)v.get(95)).setAttribute("height","1" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:89   */

      /* Empieza nodo:96 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(101)).setAttribute("class","legend" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(102)).setAttribute("nombre","lblAlcanceGeografico" );
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("filas","1" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(102)).setAttribute("id","legend" );
      ((Element)v.get(102)).setAttribute("cod","00368" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 100   */
      v.add(doc.createElement("table"));
      ((Element)v.get(103)).setAttribute("width","100%" );
      ((Element)v.get(103)).setAttribute("border","0" );
      ((Element)v.get(103)).setAttribute("align","center" );
      ((Element)v.get(103)).setAttribute("cellspacing","0" );
      ((Element)v.get(103)).setAttribute("cellpadding","0" );
      ((Element)v.get(100)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("table"));
      ((Element)v.get(106)).setAttribute("width","576" );
      ((Element)v.get(106)).setAttribute("border","0" );
      ((Element)v.get(106)).setAttribute("align","left" );
      ((Element)v.get(106)).setAttribute("cellspacing","0" );
      ((Element)v.get(106)).setAttribute("cellpadding","0" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("colspan","9" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:110 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("table"));
      ((Element)v.get(114)).setAttribute("width","100%" );
      ((Element)v.get(114)).setAttribute("border","0" );
      ((Element)v.get(114)).setAttribute("cellspacing","0" );
      ((Element)v.get(114)).setAttribute("cellpadding","0" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("class","datosTitle" );
      ((Element)v.get(116)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("RADIOB"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(117)).setAttribute("nombre","rbAlcanceGeografico" );
      ((Element)v.get(117)).setAttribute("tipo","H" );
      ((Element)v.get(117)).setAttribute("id","datosCampos" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(118)).setAttribute("valor","S" );
      ((Element)v.get(118)).setAttribute("check","N" );
      ((Element)v.get(118)).setAttribute("onfocus","" );
      ((Element)v.get(118)).setAttribute("id","datosCampos" );
      ((Element)v.get(118)).setAttribute("onclick","onClickRbRegion()" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:119 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("width","249" );
      ((Element)v.get(110)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(120)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(120)).setAttribute("alto","13" );
      ((Element)v.get(120)).setAttribute("filas","1" );
      ((Element)v.get(120)).setAttribute("valor","" );
      ((Element)v.get(120)).setAttribute("id","datosTitle" );
      ((Element)v.get(120)).setAttribute("cod","109" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","25" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("table"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(124)).setAttribute("border","0" );
      ((Element)v.get(124)).setAttribute("cellspacing","0" );
      ((Element)v.get(124)).setAttribute("cellpadding","0" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("class","datosTitle" );
      ((Element)v.get(126)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(127)).setAttribute("nombre","rbAlcanceGeografico" );
      ((Element)v.get(127)).setAttribute("tipo","H" );
      ((Element)v.get(127)).setAttribute("id","datosCampos" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(128)).setAttribute("valor","" );
      ((Element)v.get(128)).setAttribute("check","N" );
      ((Element)v.get(128)).setAttribute("onfocus","" );
      ((Element)v.get(128)).setAttribute("id","datosCampos" );
      ((Element)v.get(128)).setAttribute("onclick","onClickRbZona()" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:129 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","249" );
      ((Element)v.get(110)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(130)).setAttribute("nombre","lblZona" );
      ((Element)v.get(130)).setAttribute("alto","13" );
      ((Element)v.get(130)).setAttribute("filas","1" );
      ((Element)v.get(130)).setAttribute("valor","" );
      ((Element)v.get(130)).setAttribute("id","datosTitle" );
      ((Element)v.get(130)).setAttribute("cod","143" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("width","100%" );
      ((Element)v.get(110)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","8" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:110   */

      /* Empieza nodo:133 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
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
      ((Element)v.get(136)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(136)).setAttribute("colspan","2" );
      ((Element)v.get(133)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(137)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(137)).setAttribute("id","datosCampos" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(137)).setAttribute("size","5" );
      ((Element)v.get(137)).setAttribute("multiple","S" );
      ((Element)v.get(137)).setAttribute("req","N" );
      ((Element)v.get(137)).setAttribute("valorinicial","" );
      ((Element)v.get(137)).setAttribute("textoinicial","" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:139 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","25" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(141)).setAttribute("colspan","2" );
      ((Element)v.get(133)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(142)).setAttribute("nombre","cbZona" );
      ((Element)v.get(142)).setAttribute("id","datosCampos" );
      ((Element)v.get(142)).setAttribute("size","5" );
      ((Element)v.get(142)).setAttribute("multiple","S" );
      ((Element)v.get(142)).setAttribute("req","N" );
      ((Element)v.get(142)).setAttribute("valorinicial","" );
      ((Element)v.get(142)).setAttribute("textoinicial","" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:144 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("width","100%" );
      ((Element)v.get(133)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","8" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:133   */

      /* Empieza nodo:146 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("colspan","9" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","8" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:149 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:96   */

      /* Empieza nodo:151 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("colspan","3" );
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
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:43   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:154 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","8" );
      ((Element)v.get(155)).setAttribute("height","12" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:36   */

      /* Empieza nodo:156 / Elemento padre: 28   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(28)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("table"));
      ((Element)v.get(161)).setAttribute("width","100%" );
      ((Element)v.get(161)).setAttribute("border","0" );
      ((Element)v.get(161)).setAttribute("align","center" );
      ((Element)v.get(161)).setAttribute("cellspacing","0" );
      ((Element)v.get(161)).setAttribute("cellpadding","0" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("class","botonera" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(164)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(164)).setAttribute("ID","botonContenido" );
      ((Element)v.get(164)).setAttribute("tipo","html" );
      ((Element)v.get(164)).setAttribute("accion","accionBtBuscar();" );
      ((Element)v.get(164)).setAttribute("estado","false" );
      ((Element)v.get(164)).setAttribute("cod","1" );
      ((Element)v.get(164)).setAttribute("ontab","focaliza('formulario.cbSituacionRegistro');" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:165 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","8" );
      ((Element)v.get(166)).setAttribute("height","12" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:156   */

      /* Empieza nodo:167 / Elemento padre: 28   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(28)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).setAttribute("width","12" );
      ((Element)v.get(168)).setAttribute("align","center" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","12" );
      ((Element)v.get(169)).setAttribute("height","12" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).setAttribute("width","750" );
      ((Element)v.get(167)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("width","12" );
      ((Element)v.get(167)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","12" );
      ((Element)v.get(173)).setAttribute("height","12" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:167   */
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:174 / Elemento padre: 10   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(174)).setAttribute("nombre","listado1" );
      ((Element)v.get(174)).setAttribute("ancho","604" );
      ((Element)v.get(174)).setAttribute("alto","317" );
      ((Element)v.get(174)).setAttribute("x","12" );
      ((Element)v.get(174)).setAttribute("y","304" );
      ((Element)v.get(174)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(174)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(10)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(175)).setAttribute("precarga","S" );
      ((Element)v.get(175)).setAttribute("conROver","S" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(176)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(176)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(176)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(176)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 175   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(177)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(177)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(177)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(177)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(175)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 175   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(178)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(178)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(175)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:175   */

      /* Empieza nodo:179 / Elemento padre: 174   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(174)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(180)).setAttribute("borde","1" );
      ((Element)v.get(180)).setAttribute("horizDatos","1" );
      ((Element)v.get(180)).setAttribute("horizCabecera","1" );
      ((Element)v.get(180)).setAttribute("vertical","1" );
      ((Element)v.get(180)).setAttribute("horizTitulo","1" );
      ((Element)v.get(180)).setAttribute("horizBase","1" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 179   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(181)).setAttribute("borde","#999999" );
      ((Element)v.get(181)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(181)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(181)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(181)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(181)).setAttribute("horizTitulo","#999999" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(181)).setAttribute("horizBase","#999999" );
      ((Element)v.get(179)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:179   */

      /* Empieza nodo:182 / Elemento padre: 174   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(182)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(182)).setAttribute("alto","22" );
      ((Element)v.get(182)).setAttribute("imgFondo","" );
      ((Element)v.get(182)).setAttribute("cod","00135" );
      ((Element)v.get(182)).setAttribute("ID","datosTitle" );
      ((Element)v.get(174)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 174   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(183)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(183)).setAttribute("alto","22" );
      ((Element)v.get(183)).setAttribute("imgFondo","" );
      ((Element)v.get(174)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 174   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(184)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(184)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(184)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(184)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(184)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(184)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(174)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("ancho","180" );
      ((Element)v.get(185)).setAttribute("minimizable","S" );
      ((Element)v.get(185)).setAttribute("minimizada","N" );
      ((Element)v.get(185)).setAttribute("oculta","S" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("ancho","100" );
      ((Element)v.get(186)).setAttribute("minimizable","S" );
      ((Element)v.get(186)).setAttribute("minimizada","N" );
      ((Element)v.get(184)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("ancho","120" );
      ((Element)v.get(187)).setAttribute("minimizable","S" );
      ((Element)v.get(187)).setAttribute("minimizada","N" );
      ((Element)v.get(184)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("ancho","60" );
      ((Element)v.get(188)).setAttribute("minimizable","S" );
      ((Element)v.get(188)).setAttribute("minimizada","N" );
      ((Element)v.get(184)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("ancho","60" );
      ((Element)v.get(189)).setAttribute("minimizable","S" );
      ((Element)v.get(189)).setAttribute("minimizada","N" );
      ((Element)v.get(184)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("ancho","60" );
      ((Element)v.get(190)).setAttribute("minimizable","S" );
      ((Element)v.get(190)).setAttribute("minimizada","N" );
      ((Element)v.get(184)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("ancho","120" );
      ((Element)v.get(191)).setAttribute("minimizable","S" );
      ((Element)v.get(191)).setAttribute("minimizada","N" );
      ((Element)v.get(191)).setAttribute("oculta","N" );
      ((Element)v.get(184)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("ancho","120" );
      ((Element)v.get(192)).setAttribute("minimizable","S" );
      ((Element)v.get(192)).setAttribute("minimizada","N" );
      ((Element)v.get(192)).setAttribute("oculta","N" );
      ((Element)v.get(184)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("ancho","180" );
      ((Element)v.get(193)).setAttribute("minimizable","S" );
      ((Element)v.get(193)).setAttribute("minimizada","N" );
      ((Element)v.get(193)).setAttribute("oculta","N" );
      ((Element)v.get(184)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("ancho","180" );
      ((Element)v.get(194)).setAttribute("minimizable","S" );
      ((Element)v.get(194)).setAttribute("minimizada","N" );
      ((Element)v.get(194)).setAttribute("oculta","S" );
      ((Element)v.get(184)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(195)).setAttribute("ancho","130" );
      ((Element)v.get(195)).setAttribute("minimizable","S" );
      ((Element)v.get(195)).setAttribute("minimizada","N" );
      ((Element)v.get(195)).setAttribute("oculta","S" );
      ((Element)v.get(184)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:184   */

      /* Empieza nodo:196 / Elemento padre: 174   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(196)).setAttribute("alto","20" );
      ((Element)v.get(196)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(196)).setAttribute("imgFondo","" );
      ((Element)v.get(196)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(174)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(197)).setAttribute("colFondo","" );
      ((Element)v.get(197)).setAttribute("ID","EstCab" );
      ((Element)v.get(197)).setAttribute("align","center" );
      ((Element)v.get(197)).setAttribute("cod","" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("colFondo","" );
      ((Element)v.get(198)).setAttribute("ID","EstCab" );
      ((Element)v.get(198)).setAttribute("align","center" );
      ((Element)v.get(198)).setAttribute("cod","1604" );
      ((Element)v.get(196)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(199)).setAttribute("colFondo","" );
      ((Element)v.get(199)).setAttribute("ID","EstCab" );
      ((Element)v.get(199)).setAttribute("align","center" );
      ((Element)v.get(199)).setAttribute("cod","1783" );
      ((Element)v.get(196)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(200)).setAttribute("colFondo","" );
      ((Element)v.get(200)).setAttribute("ID","EstCab" );
      ((Element)v.get(200)).setAttribute("align","center" );
      ((Element)v.get(200)).setAttribute("cod","109" );
      ((Element)v.get(196)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(201)).setAttribute("colFondo","" );
      ((Element)v.get(201)).setAttribute("ID","EstCab" );
      ((Element)v.get(201)).setAttribute("align","center" );
      ((Element)v.get(201)).setAttribute("cod","143" );
      ((Element)v.get(196)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(202)).setAttribute("colFondo","" );
      ((Element)v.get(202)).setAttribute("ID","EstCab" );
      ((Element)v.get(202)).setAttribute("align","center" );
      ((Element)v.get(202)).setAttribute("cod","1784" );
      ((Element)v.get(196)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(203)).setAttribute("colFondo","" );
      ((Element)v.get(203)).setAttribute("ID","EstCab" );
      ((Element)v.get(203)).setAttribute("align","center" );
      ((Element)v.get(203)).setAttribute("cod","1785" );
      ((Element)v.get(196)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("colFondo","" );
      ((Element)v.get(204)).setAttribute("ID","EstCab" );
      ((Element)v.get(204)).setAttribute("align","center" );
      ((Element)v.get(204)).setAttribute("cod","2433" );
      ((Element)v.get(196)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(205)).setAttribute("colFondo","" );
      ((Element)v.get(205)).setAttribute("ID","EstCab" );
      ((Element)v.get(205)).setAttribute("align","center" );
      ((Element)v.get(205)).setAttribute("cod","2434" );
      ((Element)v.get(196)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("colFondo","" );
      ((Element)v.get(206)).setAttribute("ID","EstCab" );
      ((Element)v.get(206)).setAttribute("align","center" );
      ((Element)v.get(206)).setAttribute("cod","" );
      ((Element)v.get(196)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("colFondo","" );
      ((Element)v.get(207)).setAttribute("ID","EstCab" );
      ((Element)v.get(207)).setAttribute("align","center" );
      ((Element)v.get(207)).setAttribute("cod","" );
      ((Element)v.get(196)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:196   */

      /* Empieza nodo:208 / Elemento padre: 174   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(208)).setAttribute("alto","22" );
      ((Element)v.get(208)).setAttribute("accion","" );
      ((Element)v.get(208)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(208)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(208)).setAttribute("maxSel","1" );
      ((Element)v.get(208)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(208)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(208)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(208)).setAttribute("onLoad","" );
      ((Element)v.get(208)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(174)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(209)).setAttribute("tipo","texto" );
      ((Element)v.get(209)).setAttribute("ID","EstDat" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */

      /* Empieza nodo:210 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("tipo","texto" );
      ((Element)v.get(210)).setAttribute("ID","EstDat" );
      ((Element)v.get(208)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(211)).setAttribute("tipo","texto" );
      ((Element)v.get(211)).setAttribute("ID","EstDat2" );
      ((Element)v.get(208)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(212)).setAttribute("tipo","texto" );
      ((Element)v.get(212)).setAttribute("ID","EstDat" );
      ((Element)v.get(208)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(213)).setAttribute("tipo","texto" );
      ((Element)v.get(213)).setAttribute("ID","EstDat2" );
      ((Element)v.get(208)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("tipo","texto" );
      ((Element)v.get(214)).setAttribute("ID","EstDat" );
      ((Element)v.get(208)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(215)).setAttribute("tipo","texto" );
      ((Element)v.get(215)).setAttribute("ID","EstDat2" );
      ((Element)v.get(208)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("tipo","texto" );
      ((Element)v.get(216)).setAttribute("ID","EstDat" );
      ((Element)v.get(208)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("tipo","texto" );
      ((Element)v.get(217)).setAttribute("ID","EstDat2" );
      ((Element)v.get(208)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(218)).setAttribute("tipo","texto" );
      ((Element)v.get(218)).setAttribute("ID","EstDat" );
      ((Element)v.get(208)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(219)).setAttribute("tipo","texto" );
      ((Element)v.get(219)).setAttribute("ID","EstDat2" );
      ((Element)v.get(208)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:208   */

      /* Empieza nodo:220 / Elemento padre: 174   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(174)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 174   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(221)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(221)).setAttribute("ancho","403" );
      ((Element)v.get(221)).setAttribute("sep","$" );
      ((Element)v.get(221)).setAttribute("x","12" );
      ((Element)v.get(221)).setAttribute("class","botonera" );
      ((Element)v.get(221)).setAttribute("y","598" );
      ((Element)v.get(221)).setAttribute("control","|" );
      ((Element)v.get(221)).setAttribute("conector","" );
      ((Element)v.get(221)).setAttribute("rowset","" );
      ((Element)v.get(221)).setAttribute("cargainicial","N" );
      ((Element)v.get(221)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(174)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(222)).setAttribute("nombre","ret1" );
      ((Element)v.get(222)).setAttribute("x","37" );
      ((Element)v.get(222)).setAttribute("y","602" );
      ((Element)v.get(222)).setAttribute("ID","botonContenido" );
      ((Element)v.get(222)).setAttribute("img","retroceder_on" );
      ((Element)v.get(222)).setAttribute("tipo","0" );
      ((Element)v.get(222)).setAttribute("estado","false" );
      ((Element)v.get(222)).setAttribute("alt","" );
      ((Element)v.get(222)).setAttribute("codigo","" );
      ((Element)v.get(222)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 221   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(223)).setAttribute("nombre","ava1" );
      ((Element)v.get(223)).setAttribute("x","52" );
      ((Element)v.get(223)).setAttribute("y","602" );
      ((Element)v.get(223)).setAttribute("ID","botonContenido" );
      ((Element)v.get(223)).setAttribute("img","avanzar_on" );
      ((Element)v.get(223)).setAttribute("tipo","0" );
      ((Element)v.get(223)).setAttribute("estado","false" );
      ((Element)v.get(223)).setAttribute("alt","" );
      ((Element)v.get(223)).setAttribute("codigo","" );
      ((Element)v.get(223)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(221)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:221   */
      /* Termina nodo:174   */

      /* Empieza nodo:224 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(224)).setAttribute("nombre","primera1" );
      ((Element)v.get(224)).setAttribute("x","20" );
      ((Element)v.get(224)).setAttribute("y","602" );
      ((Element)v.get(224)).setAttribute("ID","botonContenido" );
      ((Element)v.get(224)).setAttribute("img","primera_on" );
      ((Element)v.get(224)).setAttribute("tipo","-2" );
      ((Element)v.get(224)).setAttribute("estado","false" );
      ((Element)v.get(224)).setAttribute("alt","" );
      ((Element)v.get(224)).setAttribute("codigo","" );
      ((Element)v.get(224)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(10)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(225)).setAttribute("nombre","separa" );
      ((Element)v.get(225)).setAttribute("x","59" );
      ((Element)v.get(225)).setAttribute("y","598" );
      ((Element)v.get(225)).setAttribute("ID","botonContenido" );
      ((Element)v.get(225)).setAttribute("img","separa_base" );
      ((Element)v.get(225)).setAttribute("tipo","0" );
      ((Element)v.get(225)).setAttribute("estado","false" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(225)).setAttribute("alt","" );
      ((Element)v.get(225)).setAttribute("codigo","" );
      ((Element)v.get(225)).setAttribute("accion","" );
      ((Element)v.get(10)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(226)).setAttribute("nombre","Aceptar" );
      ((Element)v.get(226)).setAttribute("x","80" );
      ((Element)v.get(226)).setAttribute("y","599" );
      ((Element)v.get(226)).setAttribute("ID","botonContenido" );
      ((Element)v.get(226)).setAttribute("tipo","html" );
      ((Element)v.get(226)).setAttribute("estado","false" );
      ((Element)v.get(226)).setAttribute("cod","12" );
      ((Element)v.get(226)).setAttribute("accion","accionBtAceptar();" );
      ((Element)v.get(10)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */

      /* Empieza nodo:227 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(227)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(227)).setAttribute("alto","12" );
      ((Element)v.get(227)).setAttribute("ancho","50" );
      ((Element)v.get(227)).setAttribute("x","0" );
      ((Element)v.get(227)).setAttribute("y","621" );
      ((Element)v.get(10)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:10   */


   }

}

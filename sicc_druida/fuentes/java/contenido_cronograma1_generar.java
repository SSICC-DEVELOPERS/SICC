
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cronograma1_generar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_cronograma1_generar" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("cod","083" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","contenido_cronograma1_generar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("ESTILO"));
      ((Element)v.get(5)).setAttribute("nombre","ESTILO1" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r\r    .actFija { font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7pt; color: #FF0000;\r    text-align: right; height: auto}\r\r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbMarcas" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","6" );
      ((Element)v.get(9)).setAttribute("group","grupo1" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbCanales" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","7" );
      ((Element)v.get(10)).setAttribute("group","grupo1" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtCodPeriod" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","30" );
      ((Element)v.get(11)).setAttribute("group","grupo1" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */
      /* Termina nodo:8   */

      /* Empieza nodo:12 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(12)).setAttribute("nombre","frmGenerarCronograma" );
      ((Element)v.get(12)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","accion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hMarca" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hCanal" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hCodPeriodo" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("nombre","hPais" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hPaisDesc" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hExisteCrono" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hPagOculta" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hIdVista" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hVecDiasSemana" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hVecMeses" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hMostrarFuera" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hlblActiFija" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hlblActiRefe" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hEsZona" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 12   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(33)).setAttribute("nombre","capaBusqueda" );
      ((Element)v.get(33)).setAttribute("x","0" );
      ((Element)v.get(33)).setAttribute("y","0" );
      ((Element)v.get(12)).appendChild((Element)v.get(33));

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
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("legend"));
      ((Element)v.get(47)).setAttribute("class","legend" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(48)).setAttribute("nombre","lblDatosDeCronograma" );
      ((Element)v.get(48)).setAttribute("alto","13" );
      ((Element)v.get(48)).setAttribute("filas","1" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(48)).setAttribute("id","legend" );
      ((Element)v.get(48)).setAttribute("cod","00504" );
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
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("table"));
      ((Element)v.get(52)).setAttribute("width","541" );
      ((Element)v.get(52)).setAttribute("border","0" );
      ((Element)v.get(52)).setAttribute("align","left" );
      ((Element)v.get(52)).setAttribute("cellspacing","0" );
      ((Element)v.get(52)).setAttribute("cellpadding","0" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("colspan","3" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","8" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:56 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(56));

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
      ((Element)v.get(60)).setAttribute("nombre","lblPais" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("id","datosTitle" );
      ((Element)v.get(60)).setAttribute("cod","5" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","100%" );
      ((Element)v.get(56)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","8" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:56   */

      /* Empieza nodo:63 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","8" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("valign","bottom" );
      ((Element)v.get(63)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(67)).setAttribute("nombre","lblCodPais" );
      ((Element)v.get(67)).setAttribute("alto","13" );
      ((Element)v.get(67)).setAttribute("filas","1" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(67)).setAttribute("id","datosCampos" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("width","100%" );
      ((Element)v.get(63)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).setAttribute("width","8" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:63   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:70 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("table"));
      ((Element)v.get(72)).setAttribute("width","590" );
      ((Element)v.get(72)).setAttribute("border","0" );
      ((Element)v.get(72)).setAttribute("align","left" );
      ((Element)v.get(72)).setAttribute("cellspacing","0" );
      ((Element)v.get(72)).setAttribute("cellpadding","0" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("colspan","3" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","8" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:76 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(76));

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
      ((Element)v.get(76)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(80)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(80)).setAttribute("alto","13" );
      ((Element)v.get(80)).setAttribute("filas","1" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(80)).setAttribute("id","datosTitle" );
      ((Element)v.get(80)).setAttribute("cod","6" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","25" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(84)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(84)).setAttribute("alto","13" );
      ((Element)v.get(84)).setAttribute("filas","1" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(84)).setAttribute("id","datosTitle" );
      ((Element)v.get(84)).setAttribute("cod","7" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","25" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(88)).setAttribute("nombre","lblCodPeriod" );
      ((Element)v.get(88)).setAttribute("alto","13" );
      ((Element)v.get(88)).setAttribute("filas","1" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(88)).setAttribute("id","datosTitle" );
      ((Element)v.get(88)).setAttribute("cod","30" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("width","100%" );
      ((Element)v.get(76)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:76   */

      /* Empieza nodo:91 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(95)).setAttribute("nombre","cbMarcas" );
      ((Element)v.get(95)).setAttribute("id","datosCampos" );
      ((Element)v.get(95)).setAttribute("size","1" );
      ((Element)v.get(95)).setAttribute("multiple","N" );
      ((Element)v.get(95)).setAttribute("req","S" );
      ((Element)v.get(95)).setAttribute("valorinicial","" );
      ((Element)v.get(95)).setAttribute("textoinicial","" );
      ((Element)v.get(95)).setAttribute("onshtab","focoShTabCbMarcas();" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:97 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","25" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(100)).setAttribute("nombre","cbCanales" );
      ((Element)v.get(100)).setAttribute("id","datosCampos" );
      ((Element)v.get(100)).setAttribute("size","1" );
      ((Element)v.get(100)).setAttribute("multiple","N" );
      ((Element)v.get(100)).setAttribute("req","S" );
      ((Element)v.get(100)).setAttribute("valorinicial","" );
      ((Element)v.get(100)).setAttribute("textoinicial","" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:102 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","25" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(105)).setAttribute("nombre","txtCodPeriod" );
      ((Element)v.get(105)).setAttribute("id","datosCampos" );
      ((Element)v.get(105)).setAttribute("max","6" );
      ((Element)v.get(105)).setAttribute("tipo","" );
      ((Element)v.get(105)).setAttribute("req","S" );
      ((Element)v.get(105)).setAttribute("size","7" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","100%" );
      ((Element)v.get(91)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:91   */

      /* Empieza nodo:108 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("colspan","3" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","8" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:49   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:111 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:42   */

      /* Empieza nodo:113 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(113)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("table"));
      ((Element)v.get(118)).setAttribute("width","100%" );
      ((Element)v.get(118)).setAttribute("border","0" );
      ((Element)v.get(118)).setAttribute("align","center" );
      ((Element)v.get(118)).setAttribute("cellspacing","0" );
      ((Element)v.get(118)).setAttribute("cellpadding","0" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("class","botonera" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(121)).setAttribute("nombre","btnGenerar" );
      ((Element)v.get(121)).setAttribute("ID","botonContenido" );
      ((Element)v.get(121)).setAttribute("tipo","html" );
      ((Element)v.get(121)).setAttribute("accion","Generar();" );
      ((Element)v.get(121)).setAttribute("estado","false" );
      ((Element)v.get(121)).setAttribute("cod","190" );
      ((Element)v.get(121)).setAttribute("ontab","focoTabBotonGenera();" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:122 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(123)).setAttribute("height","12" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:113   */

      /* Empieza nodo:124 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("width","12" );
      ((Element)v.get(125)).setAttribute("align","center" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","12" );
      ((Element)v.get(126)).setAttribute("height","12" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("width","756" );
      ((Element)v.get(124)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","12" );
      ((Element)v.get(124)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","12" );
      ((Element)v.get(130)).setAttribute("height","1" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:124   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:131 / Elemento padre: 12   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(131)).setAttribute("nombre","capaTablaGrafica" );
      ((Element)v.get(131)).setAttribute("alto","644" );
      ((Element)v.get(131)).setAttribute("ancho","100%" );
      ((Element)v.get(131)).setAttribute("colorf","" );
      ((Element)v.get(131)).setAttribute("borde","0" );
      ((Element)v.get(131)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(131)).setAttribute("x","-8" );
      ((Element)v.get(131)).setAttribute("y","140" );
      ((Element)v.get(12)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("table"));
      ((Element)v.get(132)).setAttribute("width","100%" );
      ((Element)v.get(132)).setAttribute("border","0" );
      ((Element)v.get(132)).setAttribute("cellspacing","0" );
      ((Element)v.get(132)).setAttribute("cellpadding","0" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("width","25" );
      ((Element)v.get(134)).setAttribute("align","left" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","25" );
      ((Element)v.get(135)).setAttribute("height","39" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("width","750" );
      ((Element)v.get(133)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","8" );
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
      ((Element)v.get(142)).setAttribute("width","12" );
      ((Element)v.get(142)).setAttribute("height","20" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(144)).setAttribute("width","100%" );
      ((Element)v.get(144)).setAttribute("border","0" );
      ((Element)v.get(144)).setAttribute("align","left" );
      ((Element)v.get(144)).setAttribute("cellspacing","0" );
      ((Element)v.get(144)).setAttribute("cellpadding","0" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).setAttribute("valign","top" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("id","tdContenedor" );
      ((Element)v.get(146)).setAttribute("style","border:1px solid #CECFCE" );
      ((Element)v.get(146)).setAttribute("onresize","try{document.getElementById('miscroll').style.width=this.offsetWidth;}catch(e){;}" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("REJILLA"));
      ((Element)v.get(147)).setAttribute("nombre","rejCronograma" );
      ((Element)v.get(147)).setAttribute("alto","317" );
      ((Element)v.get(147)).setAttribute("ancho","750" );
      ((Element)v.get(147)).setAttribute("x","-20" );
      ((Element)v.get(147)).setAttribute("y","437" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:148 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(144)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("table"));
      ((Element)v.get(150)).setAttribute("width","750" );
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
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","8" );
      ((Element)v.get(153)).setAttribute("height","277" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:154 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(154)).setAttribute("bgcolor","#CECFCE" );
      ((Element)v.get(144)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("width","750" );
      ((Element)v.get(155)).setAttribute("height","23" );
      ((Element)v.get(155)).setAttribute("style","border:1px solid #999999" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","12" );
      ((Element)v.get(156)).setAttribute("height","12" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:157 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:140   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:159 / Elemento padre: 12   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(159)).setAttribute("nombre","listado2" );
      ((Element)v.get(159)).setAttribute("ancho","593" );
      ((Element)v.get(159)).setAttribute("alto","317" );
      ((Element)v.get(159)).setAttribute("x","12" );
      ((Element)v.get(159)).setAttribute("y","521" );
      ((Element)v.get(159)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(159)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(12)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(160)).setAttribute("precarga","S" );
      ((Element)v.get(160)).setAttribute("conROver","S" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(161)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(161)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(161)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(161)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 160   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(162)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(162)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(162)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(162)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(160)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 160   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(163)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(163)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(160)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:160   */

      /* Empieza nodo:164 / Elemento padre: 159   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(159)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(165)).setAttribute("borde","1" );
      ((Element)v.get(165)).setAttribute("horizDatos","1" );
      ((Element)v.get(165)).setAttribute("horizCabecera","1" );
      ((Element)v.get(165)).setAttribute("vertical","1" );
      ((Element)v.get(165)).setAttribute("horizTitulo","1" );
      ((Element)v.get(165)).setAttribute("horizBase","1" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 164   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(166)).setAttribute("borde","#999999" );
      ((Element)v.get(166)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(166)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(166)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(166)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(166)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(166)).setAttribute("horizBase","#999999" );
      ((Element)v.get(164)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:164   */

      /* Empieza nodo:167 / Elemento padre: 159   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(167)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(167)).setAttribute("alto","22" );
      ((Element)v.get(167)).setAttribute("imgFondo","" );
      ((Element)v.get(167)).setAttribute("cod","0046" );
      ((Element)v.get(167)).setAttribute("ID","datosTitle" );
      ((Element)v.get(159)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 159   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(168)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(168)).setAttribute("alto","22" );
      ((Element)v.get(168)).setAttribute("imgFondo","" );
      ((Element)v.get(159)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 159   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(169)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(169)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(169)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(169)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(169)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(169)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(159)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("ancho","100" );
      ((Element)v.get(170)).setAttribute("minimizable","S" );
      ((Element)v.get(170)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("ancho","60" );
      ((Element)v.get(171)).setAttribute("minimizable","S" );
      ((Element)v.get(171)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("ancho","150" );
      ((Element)v.get(172)).setAttribute("minimizable","S" );
      ((Element)v.get(172)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("ancho","100" );
      ((Element)v.get(173)).setAttribute("minimizable","S" );
      ((Element)v.get(173)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("ancho","120" );
      ((Element)v.get(174)).setAttribute("minimizable","S" );
      ((Element)v.get(174)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("ancho","120" );
      ((Element)v.get(175)).setAttribute("minimizable","S" );
      ((Element)v.get(175)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("ancho","20" );
      ((Element)v.get(176)).setAttribute("minimizable","S" );
      ((Element)v.get(176)).setAttribute("minimizada","N" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(176)).setAttribute("oculta","S" );
      ((Element)v.get(169)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:169   */

      /* Empieza nodo:177 / Elemento padre: 159   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(177)).setAttribute("alto","20" );
      ((Element)v.get(177)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(177)).setAttribute("imgFondo","" );
      ((Element)v.get(177)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(159)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("colFondo","" );
      ((Element)v.get(178)).setAttribute("ID","EstCab" );
      ((Element)v.get(178)).setAttribute("cod","1309" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("colFondo","" );
      ((Element)v.get(179)).setAttribute("ID","EstCab" );
      ((Element)v.get(179)).setAttribute("cod","188" );
      ((Element)v.get(177)).appendChild((Element)v.get(179));

      /* Elemento padre:179 / Elemento actual: 180   */
      v.add(doc.createTextNode("fecha"));
      ((Element)v.get(179)).appendChild((Text)v.get(180));

      /* Termina nodo Texto:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("colFondo","" );
      ((Element)v.get(181)).setAttribute("ID","EstCab" );
      ((Element)v.get(181)).setAttribute("cod","192" );
      ((Element)v.get(177)).appendChild((Element)v.get(181));

      /* Elemento padre:181 / Elemento actual: 182   */
      v.add(doc.createTextNode("diasRespectoActividadOrigen"));
      ((Element)v.get(181)).appendChild((Text)v.get(182));

      /* Termina nodo Texto:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("colFondo","" );
      ((Element)v.get(183)).setAttribute("ID","EstCab" );
      ((Element)v.get(183)).setAttribute("cod","151" );
      ((Element)v.get(177)).appendChild((Element)v.get(183));

      /* Elemento padre:183 / Elemento actual: 184   */
      v.add(doc.createTextNode("codigoActividad"));
      ((Element)v.get(183)).appendChild((Text)v.get(184));

      /* Termina nodo Texto:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("colFondo","" );
      ((Element)v.get(185)).setAttribute("ID","EstCab" );
      ((Element)v.get(185)).setAttribute("cod","174" );
      ((Element)v.get(177)).appendChild((Element)v.get(185));

      /* Elemento padre:185 / Elemento actual: 186   */
      v.add(doc.createTextNode("nombreActividad"));
      ((Element)v.get(185)).appendChild((Text)v.get(186));

      /* Termina nodo Texto:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("colFondo","" );
      ((Element)v.get(187)).setAttribute("ID","EstCab" );
      ((Element)v.get(187)).setAttribute("cod","293" );
      ((Element)v.get(177)).appendChild((Element)v.get(187));

      /* Elemento padre:187 / Elemento actual: 188   */
      v.add(doc.createTextNode("fijaReferenciada"));
      ((Element)v.get(187)).appendChild((Text)v.get(188));

      /* Termina nodo Texto:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("colFondo","" );
      ((Element)v.get(189)).setAttribute("ID","EstCab" );
      ((Element)v.get(189)).setAttribute("cod","293" );
      ((Element)v.get(177)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("colFondo","" );
      ((Element)v.get(190)).setAttribute("ID","EstCab" );
      ((Element)v.get(190)).setAttribute("codigo","" );
      ((Element)v.get(177)).appendChild((Element)v.get(190));

      /* Elemento padre:190 / Elemento actual: 191   */
      v.add(doc.createTextNode("idVista"));
      ((Element)v.get(190)).appendChild((Text)v.get(191));

      /* Termina nodo Texto:191   */
      /* Termina nodo:190   */
      /* Termina nodo:177   */

      /* Empieza nodo:192 / Elemento padre: 159   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(192)).setAttribute("alto","22" );
      ((Element)v.get(192)).setAttribute("accion","" );
      ((Element)v.get(192)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(192)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(192)).setAttribute("maxSel","1" );
      ((Element)v.get(192)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(192)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(192)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(192)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(159)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(193)).setAttribute("ID","EstDat" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 192   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(194)).setAttribute("ID","EstDat2" );
      ((Element)v.get(192)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 192   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(195)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(195)).setAttribute("ID","EstDat" );
      ((Element)v.get(192)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 192   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(196)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(196)).setAttribute("ID","EstDat2" );
      ((Element)v.get(192)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 192   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(197)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(197)).setAttribute("ID","EstDat" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(192)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 192   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(198)).setAttribute("ID","EstDat2" );
      ((Element)v.get(192)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 192   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(199)).setAttribute("tipo","texto" );
      ((Element)v.get(199)).setAttribute("ID","EstDat2" );
      ((Element)v.get(192)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:192   */

      /* Empieza nodo:200 / Elemento padre: 159   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(159)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 159   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(201)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(201)).setAttribute("ancho","593" );
      ((Element)v.get(201)).setAttribute("sep","$" );
      ((Element)v.get(201)).setAttribute("x","12" );
      ((Element)v.get(201)).setAttribute("class","botonera" );
      ((Element)v.get(201)).setAttribute("y","815" );
      ((Element)v.get(201)).setAttribute("control","|" );
      ((Element)v.get(201)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(201)).setAttribute("rowset","" );
      ((Element)v.get(201)).setAttribute("cargainicial","N" );
      ((Element)v.get(159)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(202)).setAttribute("nombre","ret2" );
      ((Element)v.get(202)).setAttribute("x","37" );
      ((Element)v.get(202)).setAttribute("y","819" );
      ((Element)v.get(202)).setAttribute("ID","botonContenido" );
      ((Element)v.get(202)).setAttribute("img","retroceder_on" );
      ((Element)v.get(202)).setAttribute("tipo","0" );
      ((Element)v.get(202)).setAttribute("estado","false" );
      ((Element)v.get(202)).setAttribute("alt","" );
      ((Element)v.get(202)).setAttribute("codigo","" );
      ((Element)v.get(202)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 201   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(203)).setAttribute("nombre","ava2" );
      ((Element)v.get(203)).setAttribute("x","52" );
      ((Element)v.get(203)).setAttribute("y","819" );
      ((Element)v.get(203)).setAttribute("ID","botonContenido" );
      ((Element)v.get(203)).setAttribute("img","avanzar_on" );
      ((Element)v.get(203)).setAttribute("tipo","0" );
      ((Element)v.get(203)).setAttribute("estado","false" );
      ((Element)v.get(203)).setAttribute("alt","" );
      ((Element)v.get(203)).setAttribute("codigo","" );
      ((Element)v.get(203)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(201)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:201   */
      /* Termina nodo:159   */

      /* Empieza nodo:204 / Elemento padre: 12   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(204)).setAttribute("nombre","primera2" );
      ((Element)v.get(204)).setAttribute("x","20" );
      ((Element)v.get(204)).setAttribute("y","819" );
      ((Element)v.get(204)).setAttribute("ID","botonContenido" );
      ((Element)v.get(204)).setAttribute("img","primera_on" );
      ((Element)v.get(204)).setAttribute("tipo","-2" );
      ((Element)v.get(204)).setAttribute("estado","false" );
      ((Element)v.get(204)).setAttribute("alt","" );
      ((Element)v.get(204)).setAttribute("codigo","" );
      ((Element)v.get(204)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(12)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 12   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(205)).setAttribute("nombre","separa2" );
      ((Element)v.get(205)).setAttribute("x","59" );
      ((Element)v.get(205)).setAttribute("y","815" );
      ((Element)v.get(205)).setAttribute("ID","botonContenido" );
      ((Element)v.get(205)).setAttribute("img","separa_base" );
      ((Element)v.get(205)).setAttribute("tipo","0" );
      ((Element)v.get(205)).setAttribute("estado","false" );
      ((Element)v.get(205)).setAttribute("alt","" );
      ((Element)v.get(205)).setAttribute("codigo","" );
      ((Element)v.get(205)).setAttribute("accion","" );
      ((Element)v.get(12)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 12   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(206)).setAttribute("nombre","btnCambiarFecha2" );
      ((Element)v.get(206)).setAttribute("x","80" );
      ((Element)v.get(206)).setAttribute("y","816" );
      ((Element)v.get(206)).setAttribute("ID","botonContenido" );
      ((Element)v.get(206)).setAttribute("img","" );
      ((Element)v.get(206)).setAttribute("tipo","html" );
      ((Element)v.get(206)).setAttribute("estado","false" );
      ((Element)v.get(206)).setAttribute("cod","1978" );
      ((Element)v.get(206)).setAttribute("accion","camFechFuera();" );
      ((Element)v.get(206)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnCambiarFecha3');" );
      ((Element)v.get(206)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnCambiarFecha');" );
      ((Element)v.get(12)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 12   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(207)).setAttribute("nombre","capaEspacio2" );
      ((Element)v.get(207)).setAttribute("alto","18" );
      ((Element)v.get(207)).setAttribute("ancho","100" );
      ((Element)v.get(207)).setAttribute("colorf","" );
      ((Element)v.get(207)).setAttribute("borde","0" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(207)).setAttribute("imagenf","" );
      ((Element)v.get(207)).setAttribute("repeat","" );
      ((Element)v.get(207)).setAttribute("padding","" );
      ((Element)v.get(207)).setAttribute("visibilidad","visible" );
      ((Element)v.get(207)).setAttribute("contravsb","" );
      ((Element)v.get(207)).setAttribute("x","0" );
      ((Element)v.get(207)).setAttribute("y","839" );
      ((Element)v.get(207)).setAttribute("zindex","" );
      ((Element)v.get(12)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 12   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(208)).setAttribute("nombre","listado3" );
      ((Element)v.get(208)).setAttribute("ancho","593" );
      ((Element)v.get(208)).setAttribute("alto","317" );
      ((Element)v.get(208)).setAttribute("x","12" );
      ((Element)v.get(208)).setAttribute("y","861" );
      ((Element)v.get(208)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(208)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(12)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(209)).setAttribute("precarga","S" );
      ((Element)v.get(209)).setAttribute("conROver","S" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(210)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(210)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(210)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(210)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 209   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(211)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(211)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(211)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(211)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(209)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 209   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(212)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(212)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(209)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:209   */

      /* Empieza nodo:213 / Elemento padre: 208   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(208)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(214)).setAttribute("borde","1" );
      ((Element)v.get(214)).setAttribute("horizDatos","1" );
      ((Element)v.get(214)).setAttribute("horizCabecera","1" );
      ((Element)v.get(214)).setAttribute("vertical","1" );
      ((Element)v.get(214)).setAttribute("horizTitulo","1" );
      ((Element)v.get(214)).setAttribute("horizBase","1" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 213   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(215)).setAttribute("borde","#999999" );
      ((Element)v.get(215)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(215)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(215)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(215)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(215)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(215)).setAttribute("horizBase","#999999" );
      ((Element)v.get(213)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:213   */

      /* Empieza nodo:216 / Elemento padre: 208   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(216)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(216)).setAttribute("alto","22" );
      ((Element)v.get(216)).setAttribute("imgFondo","" );
      ((Element)v.get(216)).setAttribute("cod","00682" );
      ((Element)v.get(216)).setAttribute("ID","datosTitle" );
      ((Element)v.get(208)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 208   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(217)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(217)).setAttribute("alto","22" );
      ((Element)v.get(217)).setAttribute("imgFondo","" );
      ((Element)v.get(208)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 208   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(218)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(218)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(218)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(218)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(218)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(218)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(208)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(219)).setAttribute("ancho","100" );
      ((Element)v.get(219)).setAttribute("minimizable","S" );
      ((Element)v.get(219)).setAttribute("minimizada","N" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(220)).setAttribute("ancho","80" );
      ((Element)v.get(220)).setAttribute("minimizable","S" );
      ((Element)v.get(220)).setAttribute("minimizada","N" );
      ((Element)v.get(218)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(221)).setAttribute("ancho","80" );
      ((Element)v.get(221)).setAttribute("minimizable","S" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(221)).setAttribute("minimizada","N" );
      ((Element)v.get(218)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("ancho","100" );
      ((Element)v.get(222)).setAttribute("minimizable","S" );
      ((Element)v.get(222)).setAttribute("minimizada","N" );
      ((Element)v.get(218)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(223)).setAttribute("ancho","130" );
      ((Element)v.get(223)).setAttribute("minimizable","S" );
      ((Element)v.get(223)).setAttribute("minimizada","N" );
      ((Element)v.get(218)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("ancho","100" );
      ((Element)v.get(224)).setAttribute("minimizable","S" );
      ((Element)v.get(224)).setAttribute("minimizada","N" );
      ((Element)v.get(218)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(225)).setAttribute("ancho","100" );
      ((Element)v.get(225)).setAttribute("minimizable","S" );
      ((Element)v.get(225)).setAttribute("minimizada","N" );
      ((Element)v.get(218)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(226)).setAttribute("ancho","120" );
      ((Element)v.get(226)).setAttribute("minimizable","S" );
      ((Element)v.get(226)).setAttribute("minimizada","N" );
      ((Element)v.get(218)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */

      /* Empieza nodo:227 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("ancho","20" );
      ((Element)v.get(227)).setAttribute("minimizable","S" );
      ((Element)v.get(227)).setAttribute("minimizada","N" );
      ((Element)v.get(227)).setAttribute("oculta","S" );
      ((Element)v.get(218)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:218   */

      /* Empieza nodo:228 / Elemento padre: 208   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(228)).setAttribute("alto","20" );
      ((Element)v.get(228)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(228)).setAttribute("imgFondo","" );
      ((Element)v.get(228)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(208)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("colFondo","" );
      ((Element)v.get(229)).setAttribute("ID","EstCab" );
      ((Element)v.get(229)).setAttribute("cod","143" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 228   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("colFondo","" );
      ((Element)v.get(230)).setAttribute("ID","EstCab" );
      ((Element)v.get(230)).setAttribute("cod","188" );
      ((Element)v.get(228)).appendChild((Element)v.get(230));

      /* Elemento padre:230 / Elemento actual: 231   */
      v.add(doc.createTextNode("fecha"));
      ((Element)v.get(230)).appendChild((Text)v.get(231));

      /* Termina nodo Texto:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 228   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(232)).setAttribute("colFondo","" );
      ((Element)v.get(232)).setAttribute("ID","EstCab" );
      ((Element)v.get(232)).setAttribute("cod","151" );
      ((Element)v.get(228)).appendChild((Element)v.get(232));

      /* Elemento padre:232 / Elemento actual: 233   */
      v.add(doc.createTextNode("codigoActividad"));
      ((Element)v.get(232)).appendChild((Text)v.get(233));

      /* Termina nodo Texto:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 228   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(234)).setAttribute("colFondo","" );
      ((Element)v.get(234)).setAttribute("ID","EstCab" );
      ((Element)v.get(234)).setAttribute("cod","174" );
      ((Element)v.get(228)).appendChild((Element)v.get(234));

      /* Elemento padre:234 / Elemento actual: 235   */
      v.add(doc.createTextNode("nombreActividad"));
      ((Element)v.get(234)).appendChild((Text)v.get(235));

      /* Termina nodo Texto:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 228   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(236)).setAttribute("colFondo","" );
      ((Element)v.get(236)).setAttribute("ID","EstCab" );
      ((Element)v.get(236)).setAttribute("cod","192" );
      ((Element)v.get(228)).appendChild((Element)v.get(236));

      /* Elemento padre:236 / Elemento actual: 237   */
      v.add(doc.createTextNode("diasRespectoActividadOrigen"));
      ((Element)v.get(236)).appendChild((Text)v.get(237));

      /* Termina nodo Texto:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 228   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(238)).setAttribute("colFondo","" );
      ((Element)v.get(238)).setAttribute("ID","EstCab" );
      ((Element)v.get(238)).setAttribute("cod","297" );
      ((Element)v.get(228)).appendChild((Element)v.get(238));

      /* Elemento padre:238 / Elemento actual: 239   */
      v.add(doc.createTextNode("periodoReferencia"));
      ((Element)v.get(238)).appendChild((Text)v.get(239));

      /* Termina nodo Texto:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 228   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(240)).setAttribute("colFondo","" );
      ((Element)v.get(240)).setAttribute("ID","EstCab" );
      ((Element)v.get(240)).setAttribute("cod","3225" );
      ((Element)v.get(228)).appendChild((Element)v.get(240));

      /* Elemento padre:240 / Elemento actual: 241   */
      v.add(doc.createTextNode("codigoActividadOrigen"));
      ((Element)v.get(240)).appendChild((Text)v.get(241));

      /* Termina nodo Texto:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 228   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(242)).setAttribute("colFondo","" );
      ((Element)v.get(242)).setAttribute("ID","EstCab" );
      ((Element)v.get(242)).setAttribute("cod","3226" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(228)).appendChild((Element)v.get(242));

      /* Elemento padre:242 / Elemento actual: 243   */
      v.add(doc.createTextNode("nombreActividadOrigen"));
      ((Element)v.get(242)).appendChild((Text)v.get(243));

      /* Termina nodo Texto:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 228   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(244)).setAttribute("colFondo","" );
      ((Element)v.get(244)).setAttribute("ID","EstCab" );
      ((Element)v.get(244)).setAttribute("codigo","" );
      ((Element)v.get(228)).appendChild((Element)v.get(244));

      /* Elemento padre:244 / Elemento actual: 245   */
      v.add(doc.createTextNode("idVista"));
      ((Element)v.get(244)).appendChild((Text)v.get(245));

      /* Termina nodo Texto:245   */
      /* Termina nodo:244   */
      /* Termina nodo:228   */

      /* Empieza nodo:246 / Elemento padre: 208   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(246)).setAttribute("alto","22" );
      ((Element)v.get(246)).setAttribute("accion","" );
      ((Element)v.get(246)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(246)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(246)).setAttribute("maxSel","1" );
      ((Element)v.get(246)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(246)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(246)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(246)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(208)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(247)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(247)).setAttribute("ID","EstDat" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 246   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(248)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(248)).setAttribute("ID","EstDat2" );
      ((Element)v.get(246)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */

      /* Empieza nodo:249 / Elemento padre: 246   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(249)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(249)).setAttribute("ID","EstDat" );
      ((Element)v.get(246)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 246   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(250)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(250)).setAttribute("ID","EstDat2" );
      ((Element)v.get(246)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 246   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(251)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(251)).setAttribute("ID","EstDat" );
      ((Element)v.get(246)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 246   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(252)).setAttribute("ID","EstDat2" );
      ((Element)v.get(246)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 246   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(253)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(253)).setAttribute("ID","EstDat" );
      ((Element)v.get(246)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 246   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(254)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(254)).setAttribute("ID","EstDat2" );
      ((Element)v.get(246)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 246   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("tipo","texto" );
      ((Element)v.get(255)).setAttribute("ID","EstDat" );
      ((Element)v.get(246)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:246   */

      /* Empieza nodo:256 / Elemento padre: 208   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(208)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 208   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(257)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(257)).setAttribute("ancho","593" );
      ((Element)v.get(257)).setAttribute("sep","$" );
      ((Element)v.get(257)).setAttribute("x","12" );
      ((Element)v.get(257)).setAttribute("class","botonera" );
      ((Element)v.get(257)).setAttribute("y","1155" );
      ((Element)v.get(257)).setAttribute("control","|" );
      ((Element)v.get(257)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(257)).setAttribute("rowset","" );
      ((Element)v.get(257)).setAttribute("cargainicial","N" );
      ((Element)v.get(208)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(258)).setAttribute("nombre","ret3" );
      ((Element)v.get(258)).setAttribute("x","37" );
      ((Element)v.get(258)).setAttribute("y","1159" );
      ((Element)v.get(258)).setAttribute("ID","botonContenido" );
      ((Element)v.get(258)).setAttribute("img","retroceder_on" );
      ((Element)v.get(258)).setAttribute("tipo","0" );
      ((Element)v.get(258)).setAttribute("estado","false" );
      ((Element)v.get(258)).setAttribute("alt","" );
      ((Element)v.get(258)).setAttribute("codigo","" );
      ((Element)v.get(258)).setAttribute("accion","mipgndo3.retroceder();" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 257   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(259)).setAttribute("nombre","ava3" );
      ((Element)v.get(259)).setAttribute("x","52" );
      ((Element)v.get(259)).setAttribute("y","1159" );
      ((Element)v.get(259)).setAttribute("ID","botonContenido" );
      ((Element)v.get(259)).setAttribute("img","avanzar_on" );
      ((Element)v.get(259)).setAttribute("tipo","0" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(259)).setAttribute("estado","false" );
      ((Element)v.get(259)).setAttribute("alt","" );
      ((Element)v.get(259)).setAttribute("codigo","" );
      ((Element)v.get(259)).setAttribute("accion","mipgndo3.avanzar();" );
      ((Element)v.get(257)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:257   */
      /* Termina nodo:208   */

      /* Empieza nodo:260 / Elemento padre: 12   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(260)).setAttribute("nombre","primera3" );
      ((Element)v.get(260)).setAttribute("x","20" );
      ((Element)v.get(260)).setAttribute("y","1159" );
      ((Element)v.get(260)).setAttribute("ID","botonContenido" );
      ((Element)v.get(260)).setAttribute("img","primera_on" );
      ((Element)v.get(260)).setAttribute("tipo","-2" );
      ((Element)v.get(260)).setAttribute("estado","false" );
      ((Element)v.get(260)).setAttribute("alt","" );
      ((Element)v.get(260)).setAttribute("codigo","" );
      ((Element)v.get(260)).setAttribute("accion","mipgndo3.retrocederPrimeraPagina();" );
      ((Element)v.get(12)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 12   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(261)).setAttribute("nombre","separa3" );
      ((Element)v.get(261)).setAttribute("x","59" );
      ((Element)v.get(261)).setAttribute("y","1155" );
      ((Element)v.get(261)).setAttribute("ID","botonContenido" );
      ((Element)v.get(261)).setAttribute("img","separa_base" );
      ((Element)v.get(261)).setAttribute("tipo","0" );
      ((Element)v.get(261)).setAttribute("estado","false" );
      ((Element)v.get(261)).setAttribute("alt","" );
      ((Element)v.get(261)).setAttribute("codigo","" );
      ((Element)v.get(261)).setAttribute("accion","" );
      ((Element)v.get(12)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */

      /* Empieza nodo:262 / Elemento padre: 12   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(262)).setAttribute("nombre","btnCambiarFecha3" );
      ((Element)v.get(262)).setAttribute("x","80" );
      ((Element)v.get(262)).setAttribute("y","1156" );
      ((Element)v.get(262)).setAttribute("ID","botonContenido" );
      ((Element)v.get(262)).setAttribute("img","" );
      ((Element)v.get(262)).setAttribute("tipo","html" );
      ((Element)v.get(262)).setAttribute("estado","false" );
      ((Element)v.get(262)).setAttribute("cod","1978" );
      ((Element)v.get(262)).setAttribute("accion","camFechRefeOtroPeri();" );
      ((Element)v.get(262)).setAttribute("ontab","focaliza('frmGenerarCronograma.cbMarcas');" );
      ((Element)v.get(262)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnCambiarFecha2');" );
      ((Element)v.get(12)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 12   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(263)).setAttribute("nombre","capaEspacio3" );
      ((Element)v.get(263)).setAttribute("alto","18" );
      ((Element)v.get(263)).setAttribute("ancho","100" );
      ((Element)v.get(263)).setAttribute("colorf","" );
      ((Element)v.get(263)).setAttribute("borde","0" );
      ((Element)v.get(263)).setAttribute("imagenf","" );
      ((Element)v.get(263)).setAttribute("repeat","" );
      ((Element)v.get(263)).setAttribute("padding","" );
      ((Element)v.get(263)).setAttribute("visibilidad","visible" );
      ((Element)v.get(263)).setAttribute("contravsb","" );
      ((Element)v.get(263)).setAttribute("x","0" );
      ((Element)v.get(263)).setAttribute("y","1179" );
      ((Element)v.get(263)).setAttribute("zindex","" );
      ((Element)v.get(12)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:12   */


   }

}

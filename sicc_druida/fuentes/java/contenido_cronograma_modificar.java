
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cronograma_modificar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_cronograma_modificar" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("cod","081" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_cronograma_modificar.js" );
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
      ((Element)v.get(9)).setAttribute("name","cbPaises" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","5" );
      ((Element)v.get(9)).setAttribute("group","grupo1" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbMarcas" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","6" );
      ((Element)v.get(10)).setAttribute("group","grupo1" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbCanales" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","7" );
      ((Element)v.get(11)).setAttribute("group","grupo1" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtCodPeriod" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","30" );
      ((Element)v.get(12)).setAttribute("group","grupo1" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:8   */

      /* Empieza nodo:13 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(13)).setAttribute("nombre","frmModificarCronograma" );
      ((Element)v.get(0)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","accion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hCbPais" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hMarca" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hCanal" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 13   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hGrupoZona" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hSubgerencia" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hRegion" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hZona" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hCodPeriodo" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hPais" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hPaisDesc" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hExisteCrono" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hPagOculta" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hIdVista" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hVecDiasSemana" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hVecMeses" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hMostrarFuera" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hMostrarCrono" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hlblActiFija" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hlblActiRefe" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hChangePaisMC" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hChangeMarcaMC" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hChangeCanalMC" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hChangeGrupo" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hChangeSub" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hChangeRegion" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(45)).setAttribute("nombre","capaBusqueda" );
      ((Element)v.get(45)).setAttribute("x","0" );
      ((Element)v.get(45)).setAttribute("y","0" );
      ((Element)v.get(13)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("table"));
      ((Element)v.get(46)).setAttribute("width","100%" );
      ((Element)v.get(46)).setAttribute("border","0" );
      ((Element)v.get(46)).setAttribute("cellspacing","0" );
      ((Element)v.get(46)).setAttribute("cellpadding","0" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","12" );
      ((Element)v.get(48)).setAttribute("align","center" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","12" );
      ((Element)v.get(49)).setAttribute("height","12" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("width","750" );
      ((Element)v.get(47)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("width","12" );
      ((Element)v.get(47)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","12" );
      ((Element)v.get(53)).setAttribute("height","1" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:47   */

      /* Empieza nodo:54 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(59)).setAttribute("class","legend" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(60)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("id","legend" );
      ((Element)v.get(60)).setAttribute("cod","0075" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 58   */
      v.add(doc.createElement("table"));
      ((Element)v.get(61)).setAttribute("width","100%" );
      ((Element)v.get(61)).setAttribute("border","0" );
      ((Element)v.get(61)).setAttribute("align","center" );
      ((Element)v.get(61)).setAttribute("cellspacing","0" );
      ((Element)v.get(61)).setAttribute("cellpadding","0" );
      ((Element)v.get(58)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("table"));
      ((Element)v.get(64)).setAttribute("width","575" );
      ((Element)v.get(64)).setAttribute("border","0" );
      ((Element)v.get(64)).setAttribute("align","left" );
      ((Element)v.get(64)).setAttribute("cellspacing","0" );
      ((Element)v.get(64)).setAttribute("cellpadding","0" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("colspan","3" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:68 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
   }

   private void getXML270(Document doc) {
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
      ((Element)v.get(68)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(72)).setAttribute("nombre","lblPais" );
      ((Element)v.get(72)).setAttribute("alto","13" );
      ((Element)v.get(72)).setAttribute("filas","1" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(72)).setAttribute("id","datosTitle" );
      ((Element)v.get(72)).setAttribute("cod","5" );
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
      ((Element)v.get(76)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(76)).setAttribute("id","datosTitle" );
      ((Element)v.get(76)).setAttribute("cod","6" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","100%" );
      ((Element)v.get(68)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","8" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:68   */

      /* Empieza nodo:79 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(79)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(83)).setAttribute("nombre","cbPaises" );
      ((Element)v.get(83)).setAttribute("id","datosCampos" );
      ((Element)v.get(83)).setAttribute("size","1" );
      ((Element)v.get(83)).setAttribute("multiple","N" );
      ((Element)v.get(83)).setAttribute("req","S" );
      ((Element)v.get(83)).setAttribute("valorinicial","" );
      ((Element)v.get(83)).setAttribute("textoinicial","" );
      ((Element)v.get(83)).setAttribute("onshtab","focoShTabPaises();" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:85 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","25" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(79)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(88)).setAttribute("nombre","cbMarcas" );
      ((Element)v.get(88)).setAttribute("id","datosCampos" );
      ((Element)v.get(88)).setAttribute("size","1" );
      ((Element)v.get(88)).setAttribute("multiple","N" );
      ((Element)v.get(88)).setAttribute("req","S" );
      ((Element)v.get(88)).setAttribute("valorinicial","" );
      ((Element)v.get(88)).setAttribute("textoinicial","" );
      ((Element)v.get(88)).setAttribute("onchange","onChangeMarca();" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:90 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("width","100%" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(79)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:79   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:92 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("table"));
      ((Element)v.get(94)).setAttribute("width","575" );
      ((Element)v.get(94)).setAttribute("border","0" );
      ((Element)v.get(94)).setAttribute("align","left" );
      ((Element)v.get(94)).setAttribute("cellspacing","0" );
      ((Element)v.get(94)).setAttribute("cellpadding","0" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("colspan","3" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:98 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(102)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("filas","1" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(102)).setAttribute("id","datosTitle" );
      ((Element)v.get(102)).setAttribute("cod","7" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","25" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(106)).setAttribute("nombre","lblCodPeriod" );
      ((Element)v.get(106)).setAttribute("alto","13" );
      ((Element)v.get(106)).setAttribute("filas","1" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(106)).setAttribute("id","datosTitle" );
      ((Element)v.get(106)).setAttribute("cod","30" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("width","100%" );
      ((Element)v.get(98)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:98   */

      /* Empieza nodo:109 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","8" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(109)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(113)).setAttribute("nombre","cbCanales" );
      ((Element)v.get(113)).setAttribute("id","datosCampos" );
      ((Element)v.get(113)).setAttribute("size","1" );
      ((Element)v.get(113)).setAttribute("multiple","N" );
      ((Element)v.get(113)).setAttribute("req","S" );
      ((Element)v.get(113)).setAttribute("valorinicial","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(113)).setAttribute("textoinicial","" );
      ((Element)v.get(113)).setAttribute("onchange","onChangeCanal();" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:115 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","25" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(109)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(118)).setAttribute("nombre","txtCodPeriod" );
      ((Element)v.get(118)).setAttribute("id","datosCampos" );
      ((Element)v.get(118)).setAttribute("max","6" );
      ((Element)v.get(118)).setAttribute("tipo","" );
      ((Element)v.get(118)).setAttribute("onchange","" );
      ((Element)v.get(118)).setAttribute("req","S" );
      ((Element)v.get(118)).setAttribute("size","7" );
      ((Element)v.get(118)).setAttribute("valor","" );
      ((Element)v.get(118)).setAttribute("validacion","" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("width","100%" );
      ((Element)v.get(109)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","8" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:109   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:121 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("table"));
      ((Element)v.get(123)).setAttribute("width","575" );
      ((Element)v.get(123)).setAttribute("border","0" );
      ((Element)v.get(123)).setAttribute("align","left" );
      ((Element)v.get(123)).setAttribute("cellspacing","0" );
      ((Element)v.get(123)).setAttribute("cellpadding","0" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("colspan","3" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:127 / Elemento padre: 123   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(123)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","8" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(131)).setAttribute("nombre","lblGrupoZonas" );
      ((Element)v.get(131)).setAttribute("alto","13" );
      ((Element)v.get(131)).setAttribute("filas","1" );
      ((Element)v.get(131)).setAttribute("valor","" );
      ((Element)v.get(131)).setAttribute("id","datosTitle" );
      ((Element)v.get(131)).setAttribute("cod","298" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","25" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(135)).setAttribute("nombre","lblSubgerenciaVentas" );
      ((Element)v.get(135)).setAttribute("alto","13" );
      ((Element)v.get(135)).setAttribute("filas","1" );
      ((Element)v.get(135)).setAttribute("valor","" );
      ((Element)v.get(135)).setAttribute("id","datosTitle" );
      ((Element)v.get(135)).setAttribute("cod","124" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("width","100%" );
      ((Element)v.get(127)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","8" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:127   */

      /* Empieza nodo:138 / Elemento padre: 123   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(123)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","8" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(142)).setAttribute("nombre","cbGrupoZonas" );
      ((Element)v.get(142)).setAttribute("id","datosCampos" );
      ((Element)v.get(142)).setAttribute("size","1" );
      ((Element)v.get(142)).setAttribute("multiple","N" );
      ((Element)v.get(142)).setAttribute("req","N" );
      ((Element)v.get(142)).setAttribute("valorinicial","" );
      ((Element)v.get(142)).setAttribute("textoinicial","" );
      ((Element)v.get(142)).setAttribute("onchange","onChangeGrupo();" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:144 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","25" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(147)).setAttribute("nombre","cbSubgerenciaVentas" );
      ((Element)v.get(147)).setAttribute("id","datosCampos" );
      ((Element)v.get(147)).setAttribute("size","1" );
      ((Element)v.get(147)).setAttribute("multiple","N" );
      ((Element)v.get(147)).setAttribute("req","N" );
      ((Element)v.get(147)).setAttribute("valorinicial","" );
      ((Element)v.get(147)).setAttribute("textoinicial","" );
      ((Element)v.get(147)).setAttribute("onchange","onChangeSubgerencia();" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:149 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("width","100%" );
      ((Element)v.get(138)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:138   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:151 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("table"));
      ((Element)v.get(153)).setAttribute("width","575" );
      ((Element)v.get(153)).setAttribute("border","0" );
      ((Element)v.get(153)).setAttribute("align","left" );
      ((Element)v.get(153)).setAttribute("cellspacing","0" );
      ((Element)v.get(153)).setAttribute("cellpadding","0" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("colspan","3" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:157 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","8" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(161)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(161)).setAttribute("alto","13" );
      ((Element)v.get(161)).setAttribute("filas","1" );
      ((Element)v.get(161)).setAttribute("valor","" );
      ((Element)v.get(161)).setAttribute("id","datosTitle" );
      ((Element)v.get(161)).setAttribute("cod","109" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","25" );
      ((Element)v.get(163)).setAttribute("height","8" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(165)).setAttribute("nombre","lblZona" );
      ((Element)v.get(165)).setAttribute("alto","13" );
      ((Element)v.get(165)).setAttribute("filas","1" );
      ((Element)v.get(165)).setAttribute("valor","" );
      ((Element)v.get(165)).setAttribute("id","datosTitle" );
      ((Element)v.get(165)).setAttribute("cod","143" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).setAttribute("width","100%" );
      ((Element)v.get(157)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","8" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:157   */

      /* Empieza nodo:168 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","8" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(172)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(172)).setAttribute("id","datosCampos" );
      ((Element)v.get(172)).setAttribute("size","1" );
      ((Element)v.get(172)).setAttribute("multiple","N" );
      ((Element)v.get(172)).setAttribute("req","N" );
      ((Element)v.get(172)).setAttribute("valorinicial","" );
      ((Element)v.get(172)).setAttribute("textoinicial","" );
      ((Element)v.get(172)).setAttribute("onchange","onChangeRegion();" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:174 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","25" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(177)).setAttribute("nombre","cbZona" );
      ((Element)v.get(177)).setAttribute("id","datosCampos" );
      ((Element)v.get(177)).setAttribute("size","1" );
      ((Element)v.get(177)).setAttribute("multiple","N" );
      ((Element)v.get(177)).setAttribute("req","N" );
      ((Element)v.get(177)).setAttribute("valorinicial","" );
      ((Element)v.get(177)).setAttribute("textoinicial","" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:179 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).setAttribute("width","100%" );
      ((Element)v.get(168)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","8" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */
      /* Termina nodo:168   */

      /* Empieza nodo:181 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(182)).setAttribute("colspan","3" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","8" );
      ((Element)v.get(183)).setAttribute("height","8" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:61   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:184 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:54   */

      /* Empieza nodo:186 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("table"));
      ((Element)v.get(191)).setAttribute("width","100%" );
      ((Element)v.get(191)).setAttribute("border","0" );
      ((Element)v.get(191)).setAttribute("align","center" );
      ((Element)v.get(191)).setAttribute("cellspacing","0" );
      ((Element)v.get(191)).setAttribute("cellpadding","0" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).setAttribute("class","botonera" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(194)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(194)).setAttribute("ID","botonContenido" );
      ((Element)v.get(194)).setAttribute("tipo","html" );
      ((Element)v.get(194)).setAttribute("accion","buscar();" );
      ((Element)v.get(194)).setAttribute("estado","false" );
      ((Element)v.get(194)).setAttribute("cod","1" );
      ((Element)v.get(194)).setAttribute("ontab","focoTabBuscar();" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:195 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","8" );
      ((Element)v.get(196)).setAttribute("height","12" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:186   */

      /* Empieza nodo:197 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).setAttribute("width","12" );
      ((Element)v.get(198)).setAttribute("align","center" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).setAttribute("width","12" );
      ((Element)v.get(199)).setAttribute("height","12" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).setAttribute("width","756" );
      ((Element)v.get(197)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).setAttribute("width","12" );
      ((Element)v.get(197)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","12" );
      ((Element)v.get(203)).setAttribute("height","1" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:197   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:204 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(204)).setAttribute("nombre","capaTablas" );
      ((Element)v.get(204)).setAttribute("x","0" );
      ((Element)v.get(204)).setAttribute("y","226" );
      ((Element)v.get(204)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(13)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("table"));
      ((Element)v.get(205)).setAttribute("width","100%" );
      ((Element)v.get(205)).setAttribute("border","0" );
      ((Element)v.get(205)).setAttribute("cellspacing","0" );
      ((Element)v.get(205)).setAttribute("cellpadding","0" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).setAttribute("width","12" );
      ((Element)v.get(207)).setAttribute("align","center" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","12" );
      ((Element)v.get(208)).setAttribute("height","12" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).setAttribute("width","750" );
      ((Element)v.get(206)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).setAttribute("width","12" );
      ((Element)v.get(206)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","12" );
      ((Element)v.get(212)).setAttribute("height","1" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:206   */

      /* Empieza nodo:213 / Elemento padre: 205   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(205)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(218)).setAttribute("class","legend" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(219)).setAttribute("nombre","lblCronograma" );
      ((Element)v.get(219)).setAttribute("alto","13" );
      ((Element)v.get(219)).setAttribute("filas","1" );
      ((Element)v.get(219)).setAttribute("valor","" );
      ((Element)v.get(219)).setAttribute("id","legend" );
      ((Element)v.get(219)).setAttribute("cod","00589" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 217   */
      v.add(doc.createElement("table"));
      ((Element)v.get(220)).setAttribute("width","100%" );
      ((Element)v.get(220)).setAttribute("border","0" );
      ((Element)v.get(220)).setAttribute("align","center" );
      ((Element)v.get(220)).setAttribute("cellspacing","0" );
      ((Element)v.get(220)).setAttribute("cellpadding","0" );
      ((Element)v.get(217)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(221)).setAttribute("valign","top" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).setAttribute("id","tdContenedor" );
      ((Element)v.get(222)).setAttribute("style","border:1px solid black" );
      ((Element)v.get(222)).setAttribute("onresize","try{document.getElementById('miscroll').style.width=this.offsetWidth-15;                              document.getElementById('capaBotones').style.width=this.offsetWidth-15;                             }catch(e){;}" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("REJILLA"));
      ((Element)v.get(223)).setAttribute("nombre","rejCronograma" );
      ((Element)v.get(223)).setAttribute("alto","317" );
      ((Element)v.get(223)).setAttribute("ancho","790" );
      ((Element)v.get(223)).setAttribute("x","0" );
      ((Element)v.get(223)).setAttribute("y","437" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:224 / Elemento padre: 220   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(220)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("table"));
      ((Element)v.get(226)).setAttribute("width","525" );
      ((Element)v.get(226)).setAttribute("border","0" );
      ((Element)v.get(226)).setAttribute("align","left" );
      ((Element)v.get(226)).setAttribute("cellspacing","0" );
      ((Element)v.get(226)).setAttribute("cellpadding","0" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).setAttribute("colspan","3" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("id","imgAltoTablas" );
      ((Element)v.get(229)).setAttribute("name","imgAltoTablas" );
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","8" );
      ((Element)v.get(229)).setAttribute("height","430" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:230 / Elemento padre: 220   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(220)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("table"));
      ((Element)v.get(232)).setAttribute("width","525" );
      ((Element)v.get(232)).setAttribute("border","0" );
      ((Element)v.get(232)).setAttribute("align","left" );
      ((Element)v.get(232)).setAttribute("cellspacing","0" );
      ((Element)v.get(232)).setAttribute("cellpadding","0" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).setAttribute("colspan","3" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("id","imgAltoTablas" );
      ((Element)v.get(235)).setAttribute("name","imgAltoTablas" );
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","8" );
      ((Element)v.get(235)).setAttribute("height","610" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:220   */
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:236 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:213   */

      /* Empieza nodo:238 / Elemento padre: 205   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(205)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","8" );
      ((Element)v.get(242)).setAttribute("height","12" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:238   */

      /* Empieza nodo:243 / Elemento padre: 205   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(205)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).setAttribute("width","12" );
      ((Element)v.get(244)).setAttribute("align","center" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","12" );
      ((Element)v.get(245)).setAttribute("height","12" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).setAttribute("width","756" );
      ((Element)v.get(243)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).setAttribute("width","12" );
      ((Element)v.get(243)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","12" );
      ((Element)v.get(249)).setAttribute("height","1" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:243   */
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:250 / Elemento padre: 13   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(250)).setAttribute("nombre","listado2" );
      ((Element)v.get(250)).setAttribute("ancho","554" );
      ((Element)v.get(250)).setAttribute("alto","317" );
      ((Element)v.get(250)).setAttribute("x","24" );
      ((Element)v.get(250)).setAttribute("y","608" );
      ((Element)v.get(250)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(250)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(13)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(251)).setAttribute("precarga","S" );
      ((Element)v.get(251)).setAttribute("conROver","S" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(252)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(252)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(252)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(252)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 251   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(253)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(253)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(253)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(253)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(251)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 251   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(254)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(254)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(251)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:251   */

      /* Empieza nodo:255 / Elemento padre: 250   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(250)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(256)).setAttribute("borde","1" );
      ((Element)v.get(256)).setAttribute("horizDatos","1" );
      ((Element)v.get(256)).setAttribute("horizCabecera","1" );
      ((Element)v.get(256)).setAttribute("vertical","1" );
      ((Element)v.get(256)).setAttribute("horizTitulo","1" );
      ((Element)v.get(256)).setAttribute("horizBase","1" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 255   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(257)).setAttribute("borde","#999999" );
      ((Element)v.get(257)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(257)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(257)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(257)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(257)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(257)).setAttribute("horizBase","#999999" );
      ((Element)v.get(255)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:255   */

      /* Empieza nodo:258 / Elemento padre: 250   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(258)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(258)).setAttribute("alto","22" );
      ((Element)v.get(258)).setAttribute("imgFondo","" );
      ((Element)v.get(258)).setAttribute("cod","0046" );
      ((Element)v.get(258)).setAttribute("ID","datosTitle" );
      ((Element)v.get(250)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 250   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(259)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(259)).setAttribute("alto","22" );
      ((Element)v.get(259)).setAttribute("imgFondo","" );
      ((Element)v.get(250)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 250   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(260)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(260)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(260)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(260)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(260)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(260)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(250)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(261)).setAttribute("ancho","80" );
      ((Element)v.get(261)).setAttribute("minimizable","S" );
      ((Element)v.get(261)).setAttribute("minimizada","N" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */

      /* Empieza nodo:262 / Elemento padre: 260   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(262)).setAttribute("ancho","60" );
      ((Element)v.get(262)).setAttribute("minimizable","S" );
      ((Element)v.get(262)).setAttribute("minimizada","N" );
      ((Element)v.get(260)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 260   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(263)).setAttribute("ancho","170" );
      ((Element)v.get(263)).setAttribute("minimizable","S" );
      ((Element)v.get(263)).setAttribute("minimizada","N" );
      ((Element)v.get(260)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */

      /* Empieza nodo:264 / Elemento padre: 260   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(264)).setAttribute("ancho","100" );
      ((Element)v.get(264)).setAttribute("minimizable","S" );
      ((Element)v.get(264)).setAttribute("minimizada","N" );
      ((Element)v.get(260)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 260   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("ancho","120" );
      ((Element)v.get(265)).setAttribute("minimizable","S" );
      ((Element)v.get(265)).setAttribute("minimizada","N" );
      ((Element)v.get(260)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 260   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(266)).setAttribute("ancho","120" );
      ((Element)v.get(266)).setAttribute("minimizable","S" );
      ((Element)v.get(266)).setAttribute("minimizada","N" );
      ((Element)v.get(260)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 260   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(267)).setAttribute("ancho","20" );
      ((Element)v.get(267)).setAttribute("minimizable","S" );
      ((Element)v.get(267)).setAttribute("minimizada","N" );
      ((Element)v.get(267)).setAttribute("oculta","S" );
      ((Element)v.get(260)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:260   */

      /* Empieza nodo:268 / Elemento padre: 250   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(268)).setAttribute("alto","20" );
      ((Element)v.get(268)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(268)).setAttribute("imgFondo","" );
      ((Element)v.get(268)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(250)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("colFondo","" );
      ((Element)v.get(269)).setAttribute("ID","EstCab" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(269)).setAttribute("cod","1309" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 268   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("colFondo","" );
      ((Element)v.get(270)).setAttribute("ID","EstCab" );
      ((Element)v.get(270)).setAttribute("cod","188" );
      ((Element)v.get(268)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 268   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(271)).setAttribute("colFondo","" );
      ((Element)v.get(271)).setAttribute("ID","EstCab" );
      ((Element)v.get(271)).setAttribute("cod","192" );
      ((Element)v.get(268)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 268   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("colFondo","" );
      ((Element)v.get(272)).setAttribute("ID","EstCab" );
      ((Element)v.get(272)).setAttribute("cod","151" );
      ((Element)v.get(268)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 268   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("colFondo","" );
      ((Element)v.get(273)).setAttribute("ID","EstCab" );
      ((Element)v.get(273)).setAttribute("cod","174" );
      ((Element)v.get(268)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 268   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("colFondo","" );
      ((Element)v.get(274)).setAttribute("ID","EstCab" );
      ((Element)v.get(274)).setAttribute("cod","293" );
      ((Element)v.get(268)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 268   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("colFondo","" );
      ((Element)v.get(275)).setAttribute("ID","EstCab" );
      ((Element)v.get(275)).setAttribute("codigo","" );
      ((Element)v.get(268)).appendChild((Element)v.get(275));

      /* Elemento padre:275 / Elemento actual: 276   */
      v.add(doc.createTextNode("idVista"));
      ((Element)v.get(275)).appendChild((Text)v.get(276));

      /* Termina nodo Texto:276   */
      /* Termina nodo:275   */
      /* Termina nodo:268   */

      /* Empieza nodo:277 / Elemento padre: 250   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(277)).setAttribute("alto","22" );
      ((Element)v.get(277)).setAttribute("accion","" );
      ((Element)v.get(277)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(277)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(277)).setAttribute("maxSel","1" );
      ((Element)v.get(277)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(277)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(277)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(277)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(250)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(278)).setAttribute("ID","EstDat" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 277   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(279)).setAttribute("ID","EstDat2" );
      ((Element)v.get(277)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 277   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(280)).setAttribute("ID","EstDat" );
      ((Element)v.get(277)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 277   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(281)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(281)).setAttribute("ID","EstDat2" );
      ((Element)v.get(277)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 277   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(282)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(282)).setAttribute("ID","EstDat" );
      ((Element)v.get(277)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 277   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(283)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(283)).setAttribute("ID","EstDat2" );
      ((Element)v.get(277)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 277   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("tipo","texto" );
      ((Element)v.get(284)).setAttribute("ID","EstDat2" );
      ((Element)v.get(277)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:277   */

      /* Empieza nodo:285 / Elemento padre: 250   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(250)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 250   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(286)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(286)).setAttribute("ancho","554" );
      ((Element)v.get(286)).setAttribute("sep","$" );
      ((Element)v.get(286)).setAttribute("x","12" );
      ((Element)v.get(286)).setAttribute("class","botonera" );
      ((Element)v.get(286)).setAttribute("y","902" );
      ((Element)v.get(286)).setAttribute("control","|" );
      ((Element)v.get(286)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(286)).setAttribute("rowset","" );
      ((Element)v.get(286)).setAttribute("cargainicial","N" );
      ((Element)v.get(250)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(287)).setAttribute("nombre","ret2" );
      ((Element)v.get(287)).setAttribute("x","49" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(287)).setAttribute("y","906" );
      ((Element)v.get(287)).setAttribute("ID","botonContenido" );
      ((Element)v.get(287)).setAttribute("img","retroceder_on" );
      ((Element)v.get(287)).setAttribute("tipo","0" );
      ((Element)v.get(287)).setAttribute("estado","false" );
      ((Element)v.get(287)).setAttribute("alt","" );
      ((Element)v.get(287)).setAttribute("codigo","" );
      ((Element)v.get(287)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 286   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(288)).setAttribute("nombre","ava2" );
      ((Element)v.get(288)).setAttribute("x","64" );
      ((Element)v.get(288)).setAttribute("y","906" );
      ((Element)v.get(288)).setAttribute("ID","botonContenido" );
      ((Element)v.get(288)).setAttribute("img","avanzar_on" );
      ((Element)v.get(288)).setAttribute("tipo","0" );
      ((Element)v.get(288)).setAttribute("estado","false" );
      ((Element)v.get(288)).setAttribute("alt","" );
      ((Element)v.get(288)).setAttribute("codigo","" );
      ((Element)v.get(288)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(286)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:286   */
      /* Termina nodo:250   */

      /* Empieza nodo:289 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(289)).setAttribute("nombre","primera2" );
      ((Element)v.get(289)).setAttribute("x","32" );
      ((Element)v.get(289)).setAttribute("y","906" );
      ((Element)v.get(289)).setAttribute("ID","botonContenido" );
      ((Element)v.get(289)).setAttribute("img","primera_on" );
      ((Element)v.get(289)).setAttribute("tipo","-2" );
      ((Element)v.get(289)).setAttribute("estado","false" );
      ((Element)v.get(289)).setAttribute("alt","" );
      ((Element)v.get(289)).setAttribute("codigo","" );
      ((Element)v.get(289)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(13)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(290)).setAttribute("nombre","separa2" );
      ((Element)v.get(290)).setAttribute("x","71" );
      ((Element)v.get(290)).setAttribute("y","902" );
      ((Element)v.get(290)).setAttribute("ID","botonContenido" );
      ((Element)v.get(290)).setAttribute("img","separa_base" );
      ((Element)v.get(290)).setAttribute("tipo","0" );
      ((Element)v.get(290)).setAttribute("estado","false" );
      ((Element)v.get(290)).setAttribute("alt","" );
      ((Element)v.get(290)).setAttribute("codigo","" );
      ((Element)v.get(290)).setAttribute("accion","" );
      ((Element)v.get(13)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(291)).setAttribute("nombre","btnEliminarActividad2" );
      ((Element)v.get(291)).setAttribute("x","80" );
      ((Element)v.get(291)).setAttribute("y","903" );
      ((Element)v.get(291)).setAttribute("ID","botonContenido" );
      ((Element)v.get(291)).setAttribute("tipo","html" );
      ((Element)v.get(291)).setAttribute("accion","eliminaActFuera();" );
      ((Element)v.get(291)).setAttribute("estado","false" );
      ((Element)v.get(291)).setAttribute("cod","2410" );
      ((Element)v.get(291)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','AnadirTablaGrafica');" );
      ((Element)v.get(13)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(292)).setAttribute("nombre","CambiarFecha2" );
      ((Element)v.get(292)).setAttribute("x","203" );
      ((Element)v.get(292)).setAttribute("y","903" );
      ((Element)v.get(292)).setAttribute("ID","botonContenido" );
      ((Element)v.get(292)).setAttribute("img","" );
      ((Element)v.get(292)).setAttribute("tipo","html" );
      ((Element)v.get(292)).setAttribute("estado","false" );
      ((Element)v.get(292)).setAttribute("cod","1978" );
      ((Element)v.get(292)).setAttribute("accion","camFechFuera();" );
      ((Element)v.get(292)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnCambiarFecha2');" );
      ((Element)v.get(13)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 13   */
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
      ((Element)v.get(293)).setAttribute("y","925" );
      ((Element)v.get(293)).setAttribute("zindex","" );
      ((Element)v.get(13)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 13   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(294)).setAttribute("nombre","listado3" );
      ((Element)v.get(294)).setAttribute("ancho","554" );
      ((Element)v.get(294)).setAttribute("alto","317" );
      ((Element)v.get(294)).setAttribute("x","24" );
      ((Element)v.get(294)).setAttribute("y","948" );
      ((Element)v.get(294)).setAttribute("colorFondo","#CECFCE" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(294)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(13)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(295)).setAttribute("precarga","S" );
      ((Element)v.get(295)).setAttribute("conROver","S" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(296)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(296)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(296)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(296)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 295   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(297)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(297)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(297)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(297)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(295)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */

      /* Empieza nodo:298 / Elemento padre: 295   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(298)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(298)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(295)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:295   */

      /* Empieza nodo:299 / Elemento padre: 294   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(294)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(300)).setAttribute("borde","1" );
      ((Element)v.get(300)).setAttribute("horizDatos","1" );
      ((Element)v.get(300)).setAttribute("horizCabecera","1" );
      ((Element)v.get(300)).setAttribute("vertical","1" );
      ((Element)v.get(300)).setAttribute("horizTitulo","1" );
      ((Element)v.get(300)).setAttribute("horizBase","1" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 299   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(301)).setAttribute("borde","#999999" );
      ((Element)v.get(301)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(301)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(301)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(301)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(301)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(301)).setAttribute("horizBase","#999999" );
      ((Element)v.get(299)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:299   */

      /* Empieza nodo:302 / Elemento padre: 294   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(302)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(302)).setAttribute("alto","22" );
      ((Element)v.get(302)).setAttribute("imgFondo","" );
      ((Element)v.get(302)).setAttribute("cod","00682" );
      ((Element)v.get(302)).setAttribute("ID","datosTitle" );
      ((Element)v.get(294)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 294   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(303)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(303)).setAttribute("alto","22" );
      ((Element)v.get(303)).setAttribute("imgFondo","" );
      ((Element)v.get(294)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 294   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(304)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(304)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(304)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(304)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(304)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(304)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(294)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("ancho","100" );
      ((Element)v.get(305)).setAttribute("minimizable","S" );
      ((Element)v.get(305)).setAttribute("minimizada","N" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 304   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(306)).setAttribute("ancho","80" );
      ((Element)v.get(306)).setAttribute("minimizable","S" );
      ((Element)v.get(306)).setAttribute("minimizada","N" );
      ((Element)v.get(304)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 304   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(307)).setAttribute("ancho","80" );
      ((Element)v.get(307)).setAttribute("minimizable","S" );
      ((Element)v.get(307)).setAttribute("minimizada","N" );
      ((Element)v.get(304)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */

      /* Empieza nodo:308 / Elemento padre: 304   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(308)).setAttribute("ancho","100" );
      ((Element)v.get(308)).setAttribute("minimizable","S" );
      ((Element)v.get(308)).setAttribute("minimizada","N" );
      ((Element)v.get(304)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 304   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(309)).setAttribute("ancho","80" );
      ((Element)v.get(309)).setAttribute("minimizable","S" );
      ((Element)v.get(309)).setAttribute("minimizada","N" );
      ((Element)v.get(304)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */

      /* Empieza nodo:310 / Elemento padre: 304   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(310)).setAttribute("ancho","100" );
      ((Element)v.get(310)).setAttribute("minimizable","S" );
      ((Element)v.get(310)).setAttribute("minimizada","N" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(304)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 304   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(311)).setAttribute("ancho","80" );
      ((Element)v.get(311)).setAttribute("minimizable","S" );
      ((Element)v.get(311)).setAttribute("minimizada","N" );
      ((Element)v.get(304)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 304   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(312)).setAttribute("ancho","90" );
      ((Element)v.get(312)).setAttribute("minimizable","S" );
      ((Element)v.get(312)).setAttribute("minimizada","N" );
      ((Element)v.get(304)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */

      /* Empieza nodo:313 / Elemento padre: 304   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(313)).setAttribute("ancho","20" );
      ((Element)v.get(313)).setAttribute("minimizable","S" );
      ((Element)v.get(313)).setAttribute("minimizada","N" );
      ((Element)v.get(313)).setAttribute("oculta","S" );
      ((Element)v.get(304)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:304   */

      /* Empieza nodo:314 / Elemento padre: 294   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(314)).setAttribute("alto","30" );
      ((Element)v.get(314)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(314)).setAttribute("imgFondo","" );
      ((Element)v.get(314)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(294)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(315)).setAttribute("colFondo","" );
      ((Element)v.get(315)).setAttribute("ID","EstCab" );
      ((Element)v.get(315)).setAttribute("cod","1309" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Elemento padre:315 / Elemento actual: 316   */
      v.add(doc.createTextNode("zona"));
      ((Element)v.get(315)).appendChild((Text)v.get(316));

      /* Termina nodo Texto:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(317)).setAttribute("colFondo","" );
      ((Element)v.get(317)).setAttribute("ID","EstCab" );
      ((Element)v.get(317)).setAttribute("cod","188" );
      ((Element)v.get(314)).appendChild((Element)v.get(317));

      /* Elemento padre:317 / Elemento actual: 318   */
      v.add(doc.createTextNode("Fecha"));
      ((Element)v.get(317)).appendChild((Text)v.get(318));

      /* Termina nodo Texto:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(319)).setAttribute("colFondo","" );
      ((Element)v.get(319)).setAttribute("ID","EstCab" );
      ((Element)v.get(319)).setAttribute("cod","151" );
      ((Element)v.get(314)).appendChild((Element)v.get(319));

      /* Elemento padre:319 / Elemento actual: 320   */
      v.add(doc.createTextNode("codigoActividad"));
      ((Element)v.get(319)).appendChild((Text)v.get(320));

      /* Termina nodo Texto:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:321 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(321)).setAttribute("colFondo","" );
      ((Element)v.get(321)).setAttribute("ID","EstCab" );
      ((Element)v.get(321)).setAttribute("cod","174" );
      ((Element)v.get(314)).appendChild((Element)v.get(321));

      /* Elemento padre:321 / Elemento actual: 322   */
      v.add(doc.createTextNode("nombreActividad"));
      ((Element)v.get(321)).appendChild((Text)v.get(322));

      /* Termina nodo Texto:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:323 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(323)).setAttribute("colFondo","" );
      ((Element)v.get(323)).setAttribute("ID","EstCab" );
      ((Element)v.get(323)).setAttribute("cod","192" );
      ((Element)v.get(314)).appendChild((Element)v.get(323));

      /* Elemento padre:323 / Elemento actual: 324   */
      v.add(doc.createTextNode("diasRespectoActividadOrigen"));
      ((Element)v.get(323)).appendChild((Text)v.get(324));

      /* Termina nodo Texto:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:325 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(325)).setAttribute("colFondo","" );
      ((Element)v.get(325)).setAttribute("ID","EstCab" );
      ((Element)v.get(325)).setAttribute("cod","297" );
      ((Element)v.get(314)).appendChild((Element)v.get(325));

      /* Elemento padre:325 / Elemento actual: 326   */
      v.add(doc.createTextNode("periodoReferencia"));
      ((Element)v.get(325)).appendChild((Text)v.get(326));

      /* Termina nodo Texto:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:327 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(327)).setAttribute("colFondo","" );
      ((Element)v.get(327)).setAttribute("ID","EstCab" );
      ((Element)v.get(327)).setAttribute("cod","3225" );
      ((Element)v.get(314)).appendChild((Element)v.get(327));

      /* Elemento padre:327 / Elemento actual: 328   */
      v.add(doc.createTextNode("codigoActividadOrigen"));
      ((Element)v.get(327)).appendChild((Text)v.get(328));

      /* Termina nodo Texto:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(329)).setAttribute("colFondo","" );
      ((Element)v.get(329)).setAttribute("ID","EstCab" );
      ((Element)v.get(329)).setAttribute("cod","3226" );
      ((Element)v.get(314)).appendChild((Element)v.get(329));

      /* Elemento padre:329 / Elemento actual: 330   */
      v.add(doc.createTextNode("nombreActividadOrigen"));
      ((Element)v.get(329)).appendChild((Text)v.get(330));

      /* Termina nodo Texto:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(331)).setAttribute("colFondo","" );
      ((Element)v.get(331)).setAttribute("ID","EstCab" );
      ((Element)v.get(331)).setAttribute("codigo","" );
      ((Element)v.get(314)).appendChild((Element)v.get(331));

      /* Elemento padre:331 / Elemento actual: 332   */
      v.add(doc.createTextNode("idVista"));
      ((Element)v.get(331)).appendChild((Text)v.get(332));

      /* Termina nodo Texto:332   */
      /* Termina nodo:331   */
      /* Termina nodo:314   */

      /* Empieza nodo:333 / Elemento padre: 294   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(333)).setAttribute("alto","22" );
      ((Element)v.get(333)).setAttribute("accion","" );
      ((Element)v.get(333)).setAttribute("tipoEnvio","edicion" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(333)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(333)).setAttribute("maxSel","1" );
      ((Element)v.get(333)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(333)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(333)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(333)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(294)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(334)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(334)).setAttribute("ID","EstDat" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */

      /* Empieza nodo:335 / Elemento padre: 333   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(335)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(335)).setAttribute("ID","EstDat2" );
      ((Element)v.get(333)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */

      /* Empieza nodo:336 / Elemento padre: 333   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(336)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(336)).setAttribute("ID","EstDat" );
      ((Element)v.get(333)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */

      /* Empieza nodo:337 / Elemento padre: 333   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(337)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(337)).setAttribute("ID","EstDat2" );
      ((Element)v.get(333)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */

      /* Empieza nodo:338 / Elemento padre: 333   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(338)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(338)).setAttribute("ID","EstDat" );
      ((Element)v.get(333)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */

      /* Empieza nodo:339 / Elemento padre: 333   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(339)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(339)).setAttribute("ID","EstDat2" );
      ((Element)v.get(333)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */

      /* Empieza nodo:340 / Elemento padre: 333   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(340)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(340)).setAttribute("ID","EstDat" );
      ((Element)v.get(333)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */

      /* Empieza nodo:341 / Elemento padre: 333   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(341)).setAttribute("tipo","botonytexto" );
      ((Element)v.get(341)).setAttribute("ID","EstDat2" );
      ((Element)v.get(333)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */

      /* Empieza nodo:342 / Elemento padre: 333   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(342)).setAttribute("tipo","texto" );
      ((Element)v.get(342)).setAttribute("ID","EstDat" );
      ((Element)v.get(333)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:333   */

      /* Empieza nodo:343 / Elemento padre: 294   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(294)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */

      /* Empieza nodo:344 / Elemento padre: 294   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(344)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(344)).setAttribute("ancho","554" );
      ((Element)v.get(344)).setAttribute("sep","$" );
      ((Element)v.get(344)).setAttribute("x","12" );
      ((Element)v.get(344)).setAttribute("class","botonera" );
      ((Element)v.get(344)).setAttribute("y","1242" );
      ((Element)v.get(344)).setAttribute("control","|" );
      ((Element)v.get(344)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(344)).setAttribute("rowset","" );
      ((Element)v.get(344)).setAttribute("cargainicial","N" );
      ((Element)v.get(294)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(345)).setAttribute("nombre","ret3" );
      ((Element)v.get(345)).setAttribute("x","49" );
      ((Element)v.get(345)).setAttribute("y","1246" );
      ((Element)v.get(345)).setAttribute("ID","botonContenido" );
      ((Element)v.get(345)).setAttribute("img","retroceder_on" );
      ((Element)v.get(345)).setAttribute("tipo","0" );
      ((Element)v.get(345)).setAttribute("estado","false" );
      ((Element)v.get(345)).setAttribute("alt","" );
      ((Element)v.get(345)).setAttribute("codigo","" );
      ((Element)v.get(345)).setAttribute("accion","mipgndo3.retroceder();" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */

      /* Empieza nodo:346 / Elemento padre: 344   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(346)).setAttribute("nombre","ava3" );
      ((Element)v.get(346)).setAttribute("x","64" );
      ((Element)v.get(346)).setAttribute("y","1246" );
      ((Element)v.get(346)).setAttribute("ID","botonContenido" );
      ((Element)v.get(346)).setAttribute("img","avanzar_on" );
      ((Element)v.get(346)).setAttribute("tipo","0" );
      ((Element)v.get(346)).setAttribute("estado","false" );
      ((Element)v.get(346)).setAttribute("alt","" );
      ((Element)v.get(346)).setAttribute("codigo","" );
      ((Element)v.get(346)).setAttribute("accion","mipgndo3.avanzar();" );
      ((Element)v.get(344)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:344   */
      /* Termina nodo:294   */

      /* Empieza nodo:347 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(347)).setAttribute("nombre","primera3" );
      ((Element)v.get(347)).setAttribute("x","32" );
      ((Element)v.get(347)).setAttribute("y","1246" );
      ((Element)v.get(347)).setAttribute("ID","botonContenido" );
      ((Element)v.get(347)).setAttribute("img","primera_on" );
      ((Element)v.get(347)).setAttribute("tipo","-2" );
      ((Element)v.get(347)).setAttribute("estado","false" );
      ((Element)v.get(347)).setAttribute("alt","" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(347)).setAttribute("codigo","" );
      ((Element)v.get(347)).setAttribute("accion","mipgndo3.retrocederPrimeraPagina();" );
      ((Element)v.get(13)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */

      /* Empieza nodo:348 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(348)).setAttribute("nombre","separa3" );
      ((Element)v.get(348)).setAttribute("x","71" );
      ((Element)v.get(348)).setAttribute("y","1242" );
      ((Element)v.get(348)).setAttribute("ID","botonContenido" );
      ((Element)v.get(348)).setAttribute("img","separa_base" );
      ((Element)v.get(348)).setAttribute("tipo","0" );
      ((Element)v.get(348)).setAttribute("estado","false" );
      ((Element)v.get(348)).setAttribute("alt","" );
      ((Element)v.get(348)).setAttribute("codigo","" );
      ((Element)v.get(348)).setAttribute("accion","" );
      ((Element)v.get(13)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */

      /* Empieza nodo:349 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(349)).setAttribute("nombre","btnCambiarFecha3" );
      ((Element)v.get(349)).setAttribute("x","80" );
      ((Element)v.get(349)).setAttribute("y","1243" );
      ((Element)v.get(349)).setAttribute("ID","botonContenido" );
      ((Element)v.get(349)).setAttribute("img","" );
      ((Element)v.get(349)).setAttribute("tipo","html" );
      ((Element)v.get(349)).setAttribute("estado","false" );
      ((Element)v.get(349)).setAttribute("cod","1978" );
      ((Element)v.get(349)).setAttribute("accion","camFechRefeOtroPeri();" );
      ((Element)v.get(349)).setAttribute("ontab","focaliza('frmModificarCronograma.cbPaises');" );
      ((Element)v.get(349)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnCambiarFecha2');" );
      ((Element)v.get(13)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */

      /* Empieza nodo:350 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(350)).setAttribute("nombre","capaEspacio3" );
      ((Element)v.get(350)).setAttribute("alto","18" );
      ((Element)v.get(350)).setAttribute("ancho","100" );
      ((Element)v.get(350)).setAttribute("colorf","" );
      ((Element)v.get(350)).setAttribute("borde","0" );
      ((Element)v.get(350)).setAttribute("imagenf","" );
      ((Element)v.get(350)).setAttribute("repeat","" );
      ((Element)v.get(350)).setAttribute("padding","" );
      ((Element)v.get(350)).setAttribute("visibilidad","visible" );
      ((Element)v.get(350)).setAttribute("contravsb","" );
      ((Element)v.get(350)).setAttribute("x","0" );
      ((Element)v.get(350)).setAttribute("y","1255" );
      ((Element)v.get(350)).setAttribute("zindex","" );
      ((Element)v.get(13)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:13   */


   }

}

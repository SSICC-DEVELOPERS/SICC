
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_mapa_centro_insertar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_mapa_centro_insertar" );
      ((Element)v.get(0)).setAttribute("cod","0963" );
      ((Element)v.get(0)).setAttribute("titulo","Mantener mapa del centro de distribucion" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Mantener mapa del centro de distribucion" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_mapa_centro_insertar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","validaciones_sicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbCentroDistribucion" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","2054" );
      ((Element)v.get(7)).setAttribute("group","expandirDividir" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbMapaCentroDistribucion" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","2925" );
      ((Element)v.get(8)).setAttribute("group","expandirDividir" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbCentroDistribucion" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","2054" );
      ((Element)v.get(9)).setAttribute("group","Dividir" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbMapaCentroDistribucion" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","2925" );
      ((Element)v.get(10)).setAttribute("group","Dividir" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbMarca" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","EduTipoCurso.marcOidMarc.label" );
      ((Element)v.get(11)).setAttribute("group","aceptarExpandir" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbCanal" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","FacAsignImpre.canaOidCana.label" );
      ((Element)v.get(12)).setAttribute("group","aceptarExpandir" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbPeriodo" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","276" );
      ((Element)v.get(13)).setAttribute("group","aceptarExpandir" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","cbCodAnaquelDestino" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("cod","2945" );
      ((Element)v.get(14)).setAttribute("group","aceptarExpandir" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","txtCapacidad" );
      ((Element)v.get(15)).setAttribute("required","true" );
      ((Element)v.get(15)).setAttribute("cod","2955" );
      ((Element)v.get(15)).setAttribute("group","aceptarExpandir" );
      ((Element)v.get(15)).setAttribute("format","e" );
      ((Element)v.get(15)).setAttribute("min","0" );
      ((Element)v.get(15)).setAttribute("max","99" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","cbCodigoAnaquelOrigen" );
      ((Element)v.get(16)).setAttribute("required","true" );
      ((Element)v.get(16)).setAttribute("cod","2946" );
      ((Element)v.get(16)).setAttribute("group","busquedaDividir" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */
      /* Termina nodo:6   */

      /* Empieza nodo:17 / Elemento padre: 0   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(17)).setAttribute("nombre","formulario" );
      ((Element)v.get(17)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","accion" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","pais" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","idioma" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hOidMapaGenerado" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","oidCentroDistribucion" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","oidAnaquelDestino" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","capacidad" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","oidsAnaquelesOrigen" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","oidsAnaqueles" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hOidCentroDistribucionDefecto" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hOidsLineasArmadoDefecto" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","oidPeriodo" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 17   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(34)).setAttribute("nombre","capa1" );
      ((Element)v.get(17)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("table"));
      ((Element)v.get(35)).setAttribute("width","100%" );
      ((Element)v.get(35)).setAttribute("border","0" );
      ((Element)v.get(35)).setAttribute("cellspacing","0" );
      ((Element)v.get(35)).setAttribute("cellpadding","0" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("width","12" );
      ((Element)v.get(37)).setAttribute("align","center" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).setAttribute("width","12" );
      ((Element)v.get(38)).setAttribute("height","12" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("width","750" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(36)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("width","12" );
      ((Element)v.get(36)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(42)).setAttribute("height","1" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:36   */

      /* Empieza nodo:43 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(48)).setAttribute("class","legend" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(49)).setAttribute("nombre","lblSeleccionDeMapa" );
      ((Element)v.get(49)).setAttribute("alto","13" );
      ((Element)v.get(49)).setAttribute("filas","1" );
      ((Element)v.get(49)).setAttribute("cod","00664" );
      ((Element)v.get(49)).setAttribute("id","legend" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("table"));
      ((Element)v.get(50)).setAttribute("width","100%" );
      ((Element)v.get(50)).setAttribute("border","0" );
      ((Element)v.get(50)).setAttribute("align","center" );
      ((Element)v.get(50)).setAttribute("cellspacing","0" );
      ((Element)v.get(50)).setAttribute("cellpadding","0" );
      ((Element)v.get(47)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("colspan","4" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","8" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:54 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(58)).setAttribute("nombre","lblCentroDistribucion" );
      ((Element)v.get(58)).setAttribute("alto","13" );
      ((Element)v.get(58)).setAttribute("filas","1" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(58)).setAttribute("id","datosTitle" );
      ((Element)v.get(58)).setAttribute("cod","2054" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","25" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(62)).setAttribute("nombre","lblMapaCentroDistribucion" );
      ((Element)v.get(62)).setAttribute("alto","13" );
      ((Element)v.get(62)).setAttribute("filas","1" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(62)).setAttribute("id","datosTitle" );
      ((Element)v.get(62)).setAttribute("cod","2925" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","100%" );
      ((Element)v.get(54)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:54   */

      /* Empieza nodo:65 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(65));

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
      ((Element)v.get(65)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(69)).setAttribute("nombre","cbCentroDistribucion" );
      ((Element)v.get(69)).setAttribute("id","datosCampos" );
      ((Element)v.get(69)).setAttribute("size","1" );
      ((Element)v.get(69)).setAttribute("multiple","N" );
      ((Element)v.get(69)).setAttribute("req","S" );
      ((Element)v.get(69)).setAttribute("onchange","onChangeCbCentroDistribucion();" );
      ((Element)v.get(69)).setAttribute("ontab","onTabCentro();" );
      ((Element)v.get(69)).setAttribute("onshtab","onShTabCentro();" );
      ((Element)v.get(69)).setAttribute("valorinicial","" );
      ((Element)v.get(69)).setAttribute("textoinicial","" );
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
      ((Element)v.get(65)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(74)).setAttribute("nombre","cbMapaCentroDistribucion" );
      ((Element)v.get(74)).setAttribute("id","datosCampos" );
      ((Element)v.get(74)).setAttribute("size","1" );
      ((Element)v.get(74)).setAttribute("multiple","N" );
      ((Element)v.get(74)).setAttribute("req","S" );
      ((Element)v.get(74)).setAttribute("onchange","" );
      ((Element)v.get(74)).setAttribute("ontab","onTabMapa();" );
      ((Element)v.get(74)).setAttribute("onshtab","onShTabMapa();" );
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
      ((Element)v.get(76)).setAttribute("width","100%" );
      ((Element)v.get(65)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","8" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:65   */

      /* Empieza nodo:78 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("colspan","4" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","8" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:50   */
      /* Termina nodo:47   */

      /* Empieza nodo:81 / Elemento padre: 46   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(46)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("table"));
      ((Element)v.get(82)).setAttribute("width","100%" );
      ((Element)v.get(82)).setAttribute("border","0" );
      ((Element)v.get(82)).setAttribute("align","center" );
      ((Element)v.get(82)).setAttribute("cellspacing","0" );
      ((Element)v.get(82)).setAttribute("cellpadding","0" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("class","botonera" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(85)).setAttribute("nombre","btnExpandirAnaquel" );
      ((Element)v.get(85)).setAttribute("ID","botonContenido" );
      ((Element)v.get(85)).setAttribute("tipo","html" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(85)).setAttribute("accion","onClickExpandirAnaquel();" );
      ((Element)v.get(85)).setAttribute("estado","false" );
      ((Element)v.get(85)).setAttribute("cod","2935" );
      ((Element)v.get(85)).setAttribute("ontab","onTabExpandir();" );
      ((Element)v.get(85)).setAttribute("onshtab","onShTabExpandir();" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 84   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(86)).setAttribute("nombre","btnDividirAnaquel" );
      ((Element)v.get(86)).setAttribute("ID","botonContenido" );
      ((Element)v.get(86)).setAttribute("tipo","html" );
      ((Element)v.get(86)).setAttribute("accion","onClickDividirAnaquel();" );
      ((Element)v.get(86)).setAttribute("estado","false" );
      ((Element)v.get(86)).setAttribute("cod","2936" );
      ((Element)v.get(86)).setAttribute("ontab","onTabDividir();" );
      ((Element)v.get(86)).setAttribute("onshtab","onShTabDividir();" );
      ((Element)v.get(84)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:46   */
      /* Termina nodo:43   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:87 / Elemento padre: 17   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(87)).setAttribute("nombre","capa2" );
      ((Element)v.get(87)).setAttribute("x","0" );
      ((Element)v.get(87)).setAttribute("y","100" );
      ((Element)v.get(17)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("table"));
      ((Element)v.get(88)).setAttribute("width","100%" );
      ((Element)v.get(88)).setAttribute("border","0" );
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
      ((Element)v.get(91)).setAttribute("width","12" );
      ((Element)v.get(91)).setAttribute("height","12" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("width","750" );
      ((Element)v.get(89)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
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
      ((Element)v.get(102)).setAttribute("nombre","lblExpandirAnaquel" );
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("filas","1" );
      ((Element)v.get(102)).setAttribute("cod","2935" );
      ((Element)v.get(102)).setAttribute("id","legend" );
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
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(104)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(108)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(108)).setAttribute("alto","13" );
      ((Element)v.get(108)).setAttribute("filas","1" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(108)).setAttribute("id","datosTitle" );
      ((Element)v.get(108)).setAttribute("cod","EduTipoCurso.marcOidMarc.label" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","25" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(112)).setAttribute("nombre","lblCamal" );
      ((Element)v.get(112)).setAttribute("alto","13" );
      ((Element)v.get(112)).setAttribute("filas","1" );
      ((Element)v.get(112)).setAttribute("valor","" );
      ((Element)v.get(112)).setAttribute("id","datosTitle" );
      ((Element)v.get(112)).setAttribute("cod","FacAsignImpre.canaOidCana.label" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","25" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(116)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(116)).setAttribute("alto","13" );
      ((Element)v.get(116)).setAttribute("filas","1" );
      ((Element)v.get(116)).setAttribute("valor","" );
      ((Element)v.get(116)).setAttribute("id","datosTitle" );
      ((Element)v.get(116)).setAttribute("cod","276" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("width","100%" );
      ((Element)v.get(104)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:104   */

      /* Empieza nodo:119 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(119)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(123)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(123)).setAttribute("id","datosCampos" );
      ((Element)v.get(123)).setAttribute("size","1" );
      ((Element)v.get(123)).setAttribute("multiple","N" );
      ((Element)v.get(123)).setAttribute("req","S" );
      ((Element)v.get(123)).setAttribute("onchange","onChangeCbMarca();" );
      ((Element)v.get(123)).setAttribute("ontab","onTABComboMarca();" );
      ((Element)v.get(123)).setAttribute("onshtab","onSHTABComboMarca();" );
      ((Element)v.get(123)).setAttribute("valorinicial","" );
      ((Element)v.get(123)).setAttribute("textoinicial","" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:125 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","25" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(119)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(128)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(128)).setAttribute("id","datosCampos" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(128)).setAttribute("size","1" );
      ((Element)v.get(128)).setAttribute("multiple","N" );
      ((Element)v.get(128)).setAttribute("req","S" );
      ((Element)v.get(128)).setAttribute("onchange","onChangeCbCanal();" );
      ((Element)v.get(128)).setAttribute("ontab","onTABComboCanal();" );
      ((Element)v.get(128)).setAttribute("onshtab","onSHTABComboCanal();" );
      ((Element)v.get(128)).setAttribute("valorinicial","" );
      ((Element)v.get(128)).setAttribute("textoinicial","" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:130 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","25" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(119)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(133)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(133)).setAttribute("id","datosCampos" );
      ((Element)v.get(133)).setAttribute("size","1" );
      ((Element)v.get(133)).setAttribute("multiple","N" );
      ((Element)v.get(133)).setAttribute("req","S" );
      ((Element)v.get(133)).setAttribute("onchange","" );
      ((Element)v.get(133)).setAttribute("ontab","onTABComboPeriodo();" );
      ((Element)v.get(133)).setAttribute("onshtab","onSHTABComboPeriodo();" );
      ((Element)v.get(133)).setAttribute("valorinicial","" );
      ((Element)v.get(133)).setAttribute("textoinicial","" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:135 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("width","100%" );
      ((Element)v.get(119)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","8" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:119   */
      /* Termina nodo:103   */

      /* Empieza nodo:137 / Elemento padre: 100   */
      v.add(doc.createElement("table"));
      ((Element)v.get(137)).setAttribute("width","100%" );
      ((Element)v.get(137)).setAttribute("border","0" );
      ((Element)v.get(137)).setAttribute("align","center" );
      ((Element)v.get(137)).setAttribute("cellspacing","0" );
      ((Element)v.get(137)).setAttribute("cellpadding","0" );
      ((Element)v.get(100)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(137)).appendChild((Element)v.get(138));

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

      /* Empieza nodo:141 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(137)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","8" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(145)).setAttribute("nombre","lblCodAnaquelDestino" );
      ((Element)v.get(145)).setAttribute("alto","13" );
      ((Element)v.get(145)).setAttribute("filas","1" );
      ((Element)v.get(145)).setAttribute("valor","" );
      ((Element)v.get(145)).setAttribute("id","datosTitle" );
      ((Element)v.get(145)).setAttribute("cod","2945" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","25" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(149)).setAttribute("nombre","lblCapacidad" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(149)).setAttribute("alto","13" );
      ((Element)v.get(149)).setAttribute("filas","1" );
      ((Element)v.get(149)).setAttribute("valor","" );
      ((Element)v.get(149)).setAttribute("id","datosTitle" );
      ((Element)v.get(149)).setAttribute("cod","2955" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("width","100%" );
      ((Element)v.get(141)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:141   */

      /* Empieza nodo:152 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(137)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","8" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(152)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(156)).setAttribute("nombre","cbCodAnaquelDestino" );
      ((Element)v.get(156)).setAttribute("id","datosCampos" );
      ((Element)v.get(156)).setAttribute("size","1" );
      ((Element)v.get(156)).setAttribute("multiple","N" );
      ((Element)v.get(156)).setAttribute("req","S" );
      ((Element)v.get(156)).setAttribute("onchange","" );
      ((Element)v.get(156)).setAttribute("ontab","onTabAnaquelDestino();" );
      ((Element)v.get(156)).setAttribute("onshtab","onShTabAnaquelDestino();" );
      ((Element)v.get(156)).setAttribute("valorinicial","" );
      ((Element)v.get(156)).setAttribute("textoinicial","" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:158 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","25" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(152)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(161)).setAttribute("nombre","txtCapacidad" );
      ((Element)v.get(161)).setAttribute("id","datosCampos" );
      ((Element)v.get(161)).setAttribute("max","2" );
      ((Element)v.get(161)).setAttribute("tipo","" );
      ((Element)v.get(161)).setAttribute("onchange","" );
      ((Element)v.get(161)).setAttribute("ontab","onTabCapacidad();" );
      ((Element)v.get(161)).setAttribute("onshtab","onShTabCapacidad();" );
      ((Element)v.get(161)).setAttribute("req","S" );
      ((Element)v.get(161)).setAttribute("size","2" );
      ((Element)v.get(161)).setAttribute("valor","" );
      ((Element)v.get(161)).setAttribute("validacion","" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("width","100%" );
      ((Element)v.get(152)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","8" );
      ((Element)v.get(163)).setAttribute("height","8" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:152   */

      /* Empieza nodo:164 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(137)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("colspan","4" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","8" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:137   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:96   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:167 / Elemento padre: 17   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(167)).setAttribute("nombre","listado2" );
      ((Element)v.get(167)).setAttribute("ancho","369" );
      ((Element)v.get(167)).setAttribute("alto","301" );
      ((Element)v.get(167)).setAttribute("x","12" );
      ((Element)v.get(167)).setAttribute("y","230" );
      ((Element)v.get(167)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(167)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(17)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(168)).setAttribute("precarga","S" );
      ((Element)v.get(168)).setAttribute("conROver","S" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(169)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(169)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(169)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(169)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 168   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(170)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(170)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(170)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(170)).setAttribute("aximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(168)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 168   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(171)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(171)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(168)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:168   */

      /* Empieza nodo:172 / Elemento padre: 167   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(167)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(173)).setAttribute("borde","1" );
      ((Element)v.get(173)).setAttribute("horizDatos","1" );
      ((Element)v.get(173)).setAttribute("horizCabecera","1" );
      ((Element)v.get(173)).setAttribute("vertical","1" );
      ((Element)v.get(173)).setAttribute("horizTitulo","1" );
      ((Element)v.get(173)).setAttribute("horizBase","1" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 172   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(174)).setAttribute("borde","#999999" );
      ((Element)v.get(174)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(174)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(174)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(174)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(174)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(174)).setAttribute("horizBase","#999999" );
      ((Element)v.get(172)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:172   */

      /* Empieza nodo:175 / Elemento padre: 167   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(175)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(175)).setAttribute("alto","22" );
      ((Element)v.get(175)).setAttribute("imgFondo","" );
      ((Element)v.get(175)).setAttribute("cod","00135" );
      ((Element)v.get(175)).setAttribute("ID","datosTitle" );
      ((Element)v.get(167)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 167   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(176)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(176)).setAttribute("alto","22" );
      ((Element)v.get(176)).setAttribute("imgFondo","" );
      ((Element)v.get(167)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 167   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(177)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(177)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(177)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(177)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(177)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(177)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(167)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("ancho","50" );
      ((Element)v.get(178)).setAttribute("minimizable","S" );
      ((Element)v.get(178)).setAttribute("minimizada","N" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 167   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(179)).setAttribute("alto","25" );
      ((Element)v.get(179)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(179)).setAttribute("imgFondo","" );
      ((Element)v.get(179)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(167)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("colFondo","" );
      ((Element)v.get(180)).setAttribute("ID","EstCab" );
      ((Element)v.get(180)).setAttribute("cod","2946" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Elemento padre:180 / Elemento actual: 181   */
      v.add(doc.createTextNode("Cod. anaquel origen"));
      ((Element)v.get(180)).appendChild((Text)v.get(181));

      /* Termina nodo Texto:181   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:182 / Elemento padre: 167   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(182)).setAttribute("alto","22" );
      ((Element)v.get(182)).setAttribute("accion","" );
      ((Element)v.get(182)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(182)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(182)).setAttribute("maxSel","-1" );
      ((Element)v.get(182)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(182)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(182)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(182)).setAttribute("onLoad","" );
      ((Element)v.get(182)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(167)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("COL"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(183)).setAttribute("tipo","combo" );
      ((Element)v.get(183)).setAttribute("nombre","comboAnaquelOrigen" );
      ((Element)v.get(183)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(183)).setAttribute("ID","EstDat" );
      ((Element)v.get(183)).setAttribute("onchange","" );
      ((Element)v.get(183)).setAttribute("req","S" );
      ((Element)v.get(183)).setAttribute("size","1" );
      ((Element)v.get(183)).setAttribute("multiple","N" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:185 / Elemento padre: 167   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(167)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:167   */

      /* Empieza nodo:186 / Elemento padre: 17   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(186)).setAttribute("nombre","btnAniadir" );
      ((Element)v.get(186)).setAttribute("x","15" );
      ((Element)v.get(186)).setAttribute("y","509" );
      ((Element)v.get(186)).setAttribute("ID","botonContenido" );
      ((Element)v.get(186)).setAttribute("tipo","html" );
      ((Element)v.get(186)).setAttribute("estado","false" );
      ((Element)v.get(186)).setAttribute("cod","MMGGlobal.localization.addbutton.label" );
      ((Element)v.get(186)).setAttribute("accion","onClickAnadirAnaquel();" );
      ((Element)v.get(17)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 17   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(187)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(187)).setAttribute("x","70" );
      ((Element)v.get(187)).setAttribute("y","509" );
      ((Element)v.get(187)).setAttribute("ID","botonContenido" );
      ((Element)v.get(187)).setAttribute("tipo","html" );
      ((Element)v.get(187)).setAttribute("estado","false" );
      ((Element)v.get(187)).setAttribute("cod","MMGGlobal.removeButton.label" );
      ((Element)v.get(187)).setAttribute("accion","onClickEliminarAnaquel();" );
      ((Element)v.get(17)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 17   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(188)).setAttribute("nombre","btAceptarExpandir" );
      ((Element)v.get(188)).setAttribute("x","130" );
      ((Element)v.get(188)).setAttribute("y","509" );
      ((Element)v.get(188)).setAttribute("ID","botonContenido" );
      ((Element)v.get(188)).setAttribute("tipo","html" );
      ((Element)v.get(188)).setAttribute("estado","false" );
      ((Element)v.get(188)).setAttribute("cod","12" );
      ((Element)v.get(188)).setAttribute("accion","onClickAceptarExpandir();" );
      ((Element)v.get(188)).setAttribute("ontab","onTabBotonAceptarExpandir();" );
      ((Element)v.get(17)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 17   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(189)).setAttribute("nombre","capa3" );
      ((Element)v.get(189)).setAttribute("x","0" );
      ((Element)v.get(189)).setAttribute("y","100" );
      ((Element)v.get(17)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("table"));
      ((Element)v.get(190)).setAttribute("width","100%" );
      ((Element)v.get(190)).setAttribute("border","0" );
      ((Element)v.get(190)).setAttribute("cellspacing","0" );
      ((Element)v.get(190)).setAttribute("cellpadding","0" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).setAttribute("width","12" );
      ((Element)v.get(192)).setAttribute("align","center" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","12" );
      ((Element)v.get(193)).setAttribute("height","12" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).setAttribute("width","750" );
      ((Element)v.get(191)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).setAttribute("width","12" );
      ((Element)v.get(191)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","12" );
      ((Element)v.get(197)).setAttribute("height","1" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:191   */

      /* Empieza nodo:198 / Elemento padre: 190   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(190)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("fieldset"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(203)).setAttribute("class","legend" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(204)).setAttribute("nombre","lblDividirAnaquel" );
      ((Element)v.get(204)).setAttribute("alto","13" );
      ((Element)v.get(204)).setAttribute("filas","1" );
      ((Element)v.get(204)).setAttribute("cod","2936" );
      ((Element)v.get(204)).setAttribute("id","legend" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 202   */
      v.add(doc.createElement("table"));
      ((Element)v.get(205)).setAttribute("width","100%" );
      ((Element)v.get(205)).setAttribute("border","0" );
      ((Element)v.get(205)).setAttribute("align","center" );
      ((Element)v.get(205)).setAttribute("cellspacing","0" );
      ((Element)v.get(205)).setAttribute("cellpadding","0" );
      ((Element)v.get(202)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).setAttribute("colspan","4" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:209 / Elemento padre: 205   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(205)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","8" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(213)).setAttribute("nombre","lblCodigoAnaquelOrigen" );
      ((Element)v.get(213)).setAttribute("alto","13" );
      ((Element)v.get(213)).setAttribute("filas","1" );
      ((Element)v.get(213)).setAttribute("valor","" );
      ((Element)v.get(213)).setAttribute("id","datosTitle" );
      ((Element)v.get(213)).setAttribute("cod","2946" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","25" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:209   */

      /* Empieza nodo:216 / Elemento padre: 205   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(205)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","8" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(216)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(220)).setAttribute("nombre","cbCodigoAnaquelOrigen" );
      ((Element)v.get(220)).setAttribute("id","datosCampos" );
      ((Element)v.get(220)).setAttribute("size","1" );
      ((Element)v.get(220)).setAttribute("multiple","N" );
      ((Element)v.get(220)).setAttribute("req","S" );
      ((Element)v.get(220)).setAttribute("onchange","" );
      ((Element)v.get(220)).setAttribute("ontab","onTabAnaquelOrigen();" );
      ((Element)v.get(220)).setAttribute("onshtab","onShTabAnaquelOrigen();" );
      ((Element)v.get(220)).setAttribute("valorinicial","" );
      ((Element)v.get(220)).setAttribute("textoinicial","" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:222 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).setAttribute("width","100%" );
      ((Element)v.get(216)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","8" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:216   */

      /* Empieza nodo:224 / Elemento padre: 205   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(205)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).setAttribute("colspan","4" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","8" );
      ((Element)v.get(226)).setAttribute("height","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:205   */
      /* Termina nodo:202   */

      /* Empieza nodo:227 / Elemento padre: 201   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(201)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("table"));
      ((Element)v.get(228)).setAttribute("width","100%" );
      ((Element)v.get(228)).setAttribute("border","0" );
      ((Element)v.get(228)).setAttribute("align","center" );
      ((Element)v.get(228)).setAttribute("cellspacing","0" );
      ((Element)v.get(228)).setAttribute("cellpadding","0" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).setAttribute("class","botonera" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(231)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(231)).setAttribute("ID","botonContenido" );
      ((Element)v.get(231)).setAttribute("tipo","html" );
      ((Element)v.get(231)).setAttribute("accion","onClickAceptar();" );
      ((Element)v.get(231)).setAttribute("estado","false" );
      ((Element)v.get(231)).setAttribute("cod","12" );
      ((Element)v.get(231)).setAttribute("ontab","onTabBotonAceptar();" );
      ((Element)v.get(231)).setAttribute("onshtab","onShTabBotonAceptar();" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:201   */
      /* Termina nodo:198   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:232 / Elemento padre: 17   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(232)).setAttribute("nombre","listado1" );
      ((Element)v.get(232)).setAttribute("ancho","369" );
      ((Element)v.get(232)).setAttribute("alto","301" );
      ((Element)v.get(232)).setAttribute("x","12" );
      ((Element)v.get(232)).setAttribute("y","220" );
      ((Element)v.get(232)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(232)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(17)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(233)).setAttribute("precarga","S" );
      ((Element)v.get(233)).setAttribute("conROver","S" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(234)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(234)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(234)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(234)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 233   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(235)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(235)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(235)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(235)).setAttribute("aximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(233)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 233   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(236)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(236)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(233)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:233   */

      /* Empieza nodo:237 / Elemento padre: 232   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(232)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(238)).setAttribute("borde","1" );
      ((Element)v.get(238)).setAttribute("horizDatos","1" );
      ((Element)v.get(238)).setAttribute("horizCabecera","1" );
      ((Element)v.get(238)).setAttribute("vertical","1" );
      ((Element)v.get(238)).setAttribute("horizTitulo","1" );
      ((Element)v.get(238)).setAttribute("horizBase","1" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 237   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(239)).setAttribute("borde","#999999" );
      ((Element)v.get(239)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(239)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(239)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(239)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(239)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(239)).setAttribute("horizBase","#999999" );
      ((Element)v.get(237)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:237   */

      /* Empieza nodo:240 / Elemento padre: 232   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(240)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(240)).setAttribute("alto","22" );
      ((Element)v.get(240)).setAttribute("imgFondo","" );
      ((Element)v.get(240)).setAttribute("cod","00135" );
      ((Element)v.get(240)).setAttribute("ID","datosTitle" );
      ((Element)v.get(232)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 232   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(241)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(241)).setAttribute("alto","22" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(241)).setAttribute("imgFondo","" );
      ((Element)v.get(232)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 232   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(242)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(242)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(242)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(242)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(242)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(242)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(232)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(243)).setAttribute("ancho","50" );
      ((Element)v.get(243)).setAttribute("minimizable","S" );
      ((Element)v.get(243)).setAttribute("minimizada","N" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 242   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(244)).setAttribute("ancho","50" );
      ((Element)v.get(244)).setAttribute("minimizable","S" );
      ((Element)v.get(244)).setAttribute("minimizada","N" );
      ((Element)v.get(242)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:242   */

      /* Empieza nodo:245 / Elemento padre: 232   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(245)).setAttribute("alto","25" );
      ((Element)v.get(245)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(245)).setAttribute("imgFondo","" );
      ((Element)v.get(245)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(232)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(246)).setAttribute("colFondo","" );
      ((Element)v.get(246)).setAttribute("ID","EstCab" );
      ((Element)v.get(246)).setAttribute("cod","2946" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Elemento padre:246 / Elemento actual: 247   */
      v.add(doc.createTextNode("Cod. anaquel origen"));
      ((Element)v.get(246)).appendChild((Text)v.get(247));

      /* Termina nodo Texto:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(248)).setAttribute("colFondo","" );
      ((Element)v.get(248)).setAttribute("ID","EstCab" );
      ((Element)v.get(248)).setAttribute("cod","2955" );
      ((Element)v.get(245)).appendChild((Element)v.get(248));

      /* Elemento padre:248 / Elemento actual: 249   */
      v.add(doc.createTextNode("Capacidad"));
      ((Element)v.get(248)).appendChild((Text)v.get(249));

      /* Termina nodo Texto:249   */
      /* Termina nodo:248   */
      /* Termina nodo:245   */

      /* Empieza nodo:250 / Elemento padre: 232   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(250)).setAttribute("alto","22" );
      ((Element)v.get(250)).setAttribute("accion","" );
      ((Element)v.get(250)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(250)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(250)).setAttribute("maxSel","0" );
      ((Element)v.get(250)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(250)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(250)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(250)).setAttribute("onLoad","" );
      ((Element)v.get(250)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(232)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(251)).setAttribute("tipo","texto" );
      ((Element)v.get(251)).setAttribute("ID","EstDat" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("tipo","texto" );
      ((Element)v.get(252)).setAttribute("ID","EstDat" );
      ((Element)v.get(250)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:250   */

      /* Empieza nodo:253 / Elemento padre: 232   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(232)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 232   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(254)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(254)).setAttribute("ancho","489" );
      ((Element)v.get(254)).setAttribute("sep","$" );
      ((Element)v.get(254)).setAttribute("x","12" );
      ((Element)v.get(254)).setAttribute("class","botonera" );
      ((Element)v.get(254)).setAttribute("y","500" );
      ((Element)v.get(254)).setAttribute("control","|" );
      ((Element)v.get(254)).setAttribute("conector","" );
      ((Element)v.get(254)).setAttribute("rowset","" );
      ((Element)v.get(254)).setAttribute("cargainicial","N" );
      ((Element)v.get(254)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(232)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(255)).setAttribute("nombre","ret" );
      ((Element)v.get(255)).setAttribute("x","37" );
      ((Element)v.get(255)).setAttribute("y","504" );
      ((Element)v.get(255)).setAttribute("ID","botonContenido" );
      ((Element)v.get(255)).setAttribute("img","retroceder_on" );
      ((Element)v.get(255)).setAttribute("tipo","0" );
      ((Element)v.get(255)).setAttribute("estado","false" );
      ((Element)v.get(255)).setAttribute("alt","" );
      ((Element)v.get(255)).setAttribute("codigo","" );
      ((Element)v.get(255)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 254   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(256)).setAttribute("nombre","ava" );
      ((Element)v.get(256)).setAttribute("x","52" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(256)).setAttribute("y","504" );
      ((Element)v.get(256)).setAttribute("ID","botonContenido" );
      ((Element)v.get(256)).setAttribute("img","avanzar_on" );
      ((Element)v.get(256)).setAttribute("tipo","0" );
      ((Element)v.get(256)).setAttribute("estado","false" );
      ((Element)v.get(256)).setAttribute("alt","" );
      ((Element)v.get(256)).setAttribute("codigo","" );
      ((Element)v.get(256)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(254)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:254   */
      /* Termina nodo:232   */

      /* Empieza nodo:257 / Elemento padre: 17   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(257)).setAttribute("nombre","primera" );
      ((Element)v.get(257)).setAttribute("x","20" );
      ((Element)v.get(257)).setAttribute("y","504" );
      ((Element)v.get(257)).setAttribute("ID","botonContenido" );
      ((Element)v.get(257)).setAttribute("img","primera_on" );
      ((Element)v.get(257)).setAttribute("tipo","0" );
      ((Element)v.get(257)).setAttribute("estado","false" );
      ((Element)v.get(257)).setAttribute("alt","" );
      ((Element)v.get(257)).setAttribute("codigo","" );
      ((Element)v.get(257)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(17)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 17   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(258)).setAttribute("nombre","separa" );
      ((Element)v.get(258)).setAttribute("x","59" );
      ((Element)v.get(258)).setAttribute("y","499" );
      ((Element)v.get(258)).setAttribute("ID","botonContenido" );
      ((Element)v.get(258)).setAttribute("img","separa_base" );
      ((Element)v.get(258)).setAttribute("tipo","0" );
      ((Element)v.get(258)).setAttribute("estado","false" );
      ((Element)v.get(258)).setAttribute("alt","" );
      ((Element)v.get(258)).setAttribute("codigo","" );
      ((Element)v.get(258)).setAttribute("accion","" );
      ((Element)v.get(17)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 17   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(259)).setAttribute("nombre","btAceptarDividir" );
      ((Element)v.get(259)).setAttribute("x","80" );
      ((Element)v.get(259)).setAttribute("y","499" );
      ((Element)v.get(259)).setAttribute("ID","botonContenido" );
      ((Element)v.get(259)).setAttribute("tipo","html" );
      ((Element)v.get(259)).setAttribute("estado","false" );
      ((Element)v.get(259)).setAttribute("cod","12" );
      ((Element)v.get(259)).setAttribute("accion","onClickAceptarDividir();" );
      ((Element)v.get(259)).setAttribute("ontab","onTabBotonAceptarDividir();" );
      ((Element)v.get(259)).setAttribute("onshtab","onShTabBotonAceptarDividir();" );
      ((Element)v.get(17)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:17   */


   }

}

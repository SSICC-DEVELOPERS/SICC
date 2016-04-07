
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_solicitudes_bloqueadas_liberar  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML1620(doc);
         

      getXML1710(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_solicitudes_bloqueadas_liberar" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("cod","0272" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_solicitudes_bloqueadas_liberar.js" );
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
      ((Element)v.get(7)).setAttribute("name","txtMontoOrdenDesde" );
      ((Element)v.get(7)).setAttribute("required","false" );
      ((Element)v.get(7)).setAttribute("cod","919" );
      ((Element)v.get(7)).setAttribute("format","n" );
      ((Element)v.get(7)).setAttribute("min","0" );
      ((Element)v.get(7)).setAttribute("max","999999999999,99" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtMontoOrdenHasta" );
      ((Element)v.get(8)).setAttribute("required","false" );
      ((Element)v.get(8)).setAttribute("cod","1452" );
      ((Element)v.get(8)).setAttribute("format","n" );
      ((Element)v.get(8)).setAttribute("min","0" );
      ((Element)v.get(8)).setAttribute("max","999999999999,99" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtMontoDeudaDesde" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("cod","918" );
      ((Element)v.get(9)).setAttribute("format","n" );
      ((Element)v.get(9)).setAttribute("min","0" );
      ((Element)v.get(9)).setAttribute("max","999999999999,99" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtMontoDeudaHasta" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("cod","1453" );
      ((Element)v.get(10)).setAttribute("format","n" );
      ((Element)v.get(10)).setAttribute("min","0" );
      ((Element)v.get(10)).setAttribute("max","999999999999,99" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:6   */

      /* Empieza nodo:11 / Elemento padre: 0   */
      v.add(doc.createElement("STYLE"));
      ((Element)v.get(11)).setAttribute("TYPE","text/css" );
      ((Element)v.get(0)).appendChild((Element)v.get(11));

      /* Elemento padre:11 / Elemento actual: 12   */
      v.add(doc.createTextNode("\r   \r\r#Cplistado1{visibility:hidden;}\r#CpLin1listado1{visibility:hidden;}\r#CpLin2listado1{visibility:hidden;}\r#CpLin3listado1{visibility:hidden;}\r#CpLin4listado1{visibility:hidden;}\r#capa1{visibility:hidden;}\r#ModificarDiv{visibility:hidden;}\r#EliminarDiv{visibility:hidden;}\r#primera1Div{visibility:hidden;}\r#ret1Div{visibility:hidden;}\r#ava1Div{visibility:hidden;}\r#separaDiv{visibility:hidden;}\r#capaContenido2{visibility:hidden;}\r#RechazarDiv{visibility:hidden;}\r#ReasignarDiv{visibility:hidden;}\r#LiberarDiv{visibility:hidden;}\r   \r"));
      ((Element)v.get(11)).appendChild((Text)v.get(12));

      /* Termina nodo Texto:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:13 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(13)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(13)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","accion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(15)).setAttribute("valor","LPSolicitudesBloqueadas" );
      ((Element)v.get(13)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","pais" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","varNivelJerarquiaUsuario" );
      ((Element)v.get(19)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(13)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","varEjecutivo" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","seleccion" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","ESTATUS_BLOQUEADO" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","ESTATUS_LIBERADO" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","ESTATUS_REASIGNADO" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","ESTATUS_RECHAZADO" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","formato" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","varEjecutivoCuenta" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(28)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(13)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("table"));
      ((Element)v.get(29)).setAttribute("width","100%" );
      ((Element)v.get(29)).setAttribute("border","0" );
      ((Element)v.get(29)).setAttribute("cellspacing","0" );
      ((Element)v.get(29)).setAttribute("cellpadding","0" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).setAttribute("width","12" );
      ((Element)v.get(31)).setAttribute("align","center" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).setAttribute("width","12" );
      ((Element)v.get(32)).setAttribute("height","12" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).setAttribute("width","750" );
      ((Element)v.get(30)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(34)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("width","12" );
      ((Element)v.get(30)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","12" );
      ((Element)v.get(36)).setAttribute("height","1" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:30   */

      /* Empieza nodo:37 / Elemento padre: 29   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(29)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(42)).setAttribute("class","legend" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(43)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(43)).setAttribute("alto","13" );
      ((Element)v.get(43)).setAttribute("filas","1" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(43)).setAttribute("id","legend" );
      ((Element)v.get(43)).setAttribute("cod","0075" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("table"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(44)).setAttribute("width","100%" );
      ((Element)v.get(44)).setAttribute("border","0" );
      ((Element)v.get(44)).setAttribute("align","center" );
      ((Element)v.get(44)).setAttribute("cellspacing","0" );
      ((Element)v.get(44)).setAttribute("cellpadding","0" );
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("table"));
      ((Element)v.get(47)).setAttribute("width","652" );
      ((Element)v.get(47)).setAttribute("border","0" );
      ((Element)v.get(47)).setAttribute("align","left" );
      ((Element)v.get(47)).setAttribute("cellspacing","0" );
      ((Element)v.get(47)).setAttribute("cellpadding","0" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("colspan","4" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","8" );
      ((Element)v.get(50)).setAttribute("height","8" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:51 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(51));

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
      ((Element)v.get(55)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(55)).setAttribute("alto","13" );
      ((Element)v.get(55)).setAttribute("filas","1" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(55)).setAttribute("id","datosTitle" );
      ((Element)v.get(55)).setAttribute("cod","6" );
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
      ((Element)v.get(59)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(59)).setAttribute("alto","13" );
      ((Element)v.get(59)).setAttribute("filas","1" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(59)).setAttribute("id","datosTitle" );
      ((Element)v.get(59)).setAttribute("cod","7" );
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

      /* Empieza nodo:62 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(62)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(66)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(66)).setAttribute("id","datosCampos" );
      ((Element)v.get(66)).setAttribute("size","1" );
      ((Element)v.get(66)).setAttribute("multiple","N" );
      ((Element)v.get(66)).setAttribute("req","N" );
      ((Element)v.get(66)).setAttribute("valorinicial","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(66)).setAttribute("textoinicial","" );
      ((Element)v.get(66)).setAttribute("onchange","marca_onChange()" );
      ((Element)v.get(66)).setAttribute("ontab","tab('cbMarca')" );
      ((Element)v.get(66)).setAttribute("onshtab","shtab('cbMarca')" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:68 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","25" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(62)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(71)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(71)).setAttribute("id","datosCampos" );
      ((Element)v.get(71)).setAttribute("size","1" );
      ((Element)v.get(71)).setAttribute("multiple","N" );
      ((Element)v.get(71)).setAttribute("req","N" );
      ((Element)v.get(71)).setAttribute("valorinicial","" );
      ((Element)v.get(71)).setAttribute("textoinicial","" );
      ((Element)v.get(71)).setAttribute("onchange","canal_onChange()" );
      ((Element)v.get(71)).setAttribute("ontab","tab('cbCanal')" );
      ((Element)v.get(71)).setAttribute("onshtab","shtab('cbCanal')" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:73 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("width","100%" );
      ((Element)v.get(62)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","8" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:62   */

      /* Empieza nodo:75 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("colspan","4" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","8" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:78 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("table"));
      ((Element)v.get(80)).setAttribute("width","652" );
      ((Element)v.get(80)).setAttribute("border","0" );
      ((Element)v.get(80)).setAttribute("align","left" );
      ((Element)v.get(80)).setAttribute("cellspacing","0" );
      ((Element)v.get(80)).setAttribute("cellpadding","0" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","8" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(85)).setAttribute("nombre","lblSubVentas" );
      ((Element)v.get(85)).setAttribute("alto","13" );
      ((Element)v.get(85)).setAttribute("filas","1" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(85)).setAttribute("id","datosTitle" );
      ((Element)v.get(85)).setAttribute("cod","124" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","25" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(89)).setAttribute("nombre","lblRegion" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(89)).setAttribute("alto","13" );
      ((Element)v.get(89)).setAttribute("filas","1" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(89)).setAttribute("id","datosTitle" );
      ((Element)v.get(89)).setAttribute("cod","109" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("width","100%" );
      ((Element)v.get(81)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:81   */

      /* Empieza nodo:92 / Elemento padre: 80   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(80)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","8" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(92)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(96)).setAttribute("nombre","cbSubVentas" );
      ((Element)v.get(96)).setAttribute("id","datosCampos" );
      ((Element)v.get(96)).setAttribute("size","1" );
      ((Element)v.get(96)).setAttribute("multiple","N" );
      ((Element)v.get(96)).setAttribute("req","N" );
      ((Element)v.get(96)).setAttribute("valorinicial","" );
      ((Element)v.get(96)).setAttribute("textoinicial","" );
      ((Element)v.get(96)).setAttribute("onchange","subgerencia_onChange()" );
      ((Element)v.get(96)).setAttribute("ontab","tab('cbSubVentas')" );
      ((Element)v.get(96)).setAttribute("onshtab","shtab('cbSubVentas')" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:98 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","25" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(92)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(101)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(101)).setAttribute("id","datosCampos" );
      ((Element)v.get(101)).setAttribute("size","1" );
      ((Element)v.get(101)).setAttribute("multiple","N" );
      ((Element)v.get(101)).setAttribute("req","N" );
      ((Element)v.get(101)).setAttribute("valorinicial","" );
      ((Element)v.get(101)).setAttribute("textoinicial","" );
      ((Element)v.get(101)).setAttribute("onchange","region_onChange()" );
      ((Element)v.get(101)).setAttribute("ontab","tab('cbRegion')" );
      ((Element)v.get(101)).setAttribute("onshtab","shtab('cbRegion')" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:103 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","100%" );
      ((Element)v.get(92)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:92   */

      /* Empieza nodo:105 / Elemento padre: 80   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(80)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("colspan","4" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:108 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("table"));
      ((Element)v.get(110)).setAttribute("width","652" );
      ((Element)v.get(110)).setAttribute("border","0" );
      ((Element)v.get(110)).setAttribute("align","left" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(110)).setAttribute("cellspacing","0" );
      ((Element)v.get(110)).setAttribute("cellpadding","0" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","8" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(115)).setAttribute("nombre","lblZona" );
      ((Element)v.get(115)).setAttribute("alto","13" );
      ((Element)v.get(115)).setAttribute("filas","1" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(115)).setAttribute("id","datosTitle" );
      ((Element)v.get(115)).setAttribute("cod","143" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","25" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(119)).setAttribute("nombre","lblNJerarUsu" );
      ((Element)v.get(119)).setAttribute("alto","13" );
      ((Element)v.get(119)).setAttribute("filas","1" );
      ((Element)v.get(119)).setAttribute("valor","" );
      ((Element)v.get(119)).setAttribute("id","datosTitle" );
      ((Element)v.get(119)).setAttribute("cod","927" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","25" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(123)).setAttribute("nombre","lblNivelRiesgo" );
      ((Element)v.get(123)).setAttribute("alto","13" );
      ((Element)v.get(123)).setAttribute("filas","1" );
      ((Element)v.get(123)).setAttribute("valor","" );
      ((Element)v.get(123)).setAttribute("id","datosTitle" );
      ((Element)v.get(123)).setAttribute("cod","928" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(111)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:111   */

      /* Empieza nodo:126 / Elemento padre: 110   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(110)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(126)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(130)).setAttribute("nombre","cbZona" );
      ((Element)v.get(130)).setAttribute("id","datosCampos" );
      ((Element)v.get(130)).setAttribute("size","1" );
      ((Element)v.get(130)).setAttribute("multiple","N" );
      ((Element)v.get(130)).setAttribute("req","N" );
      ((Element)v.get(130)).setAttribute("valorinicial","" );
      ((Element)v.get(130)).setAttribute("textoinicial","" );
      ((Element)v.get(130)).setAttribute("ontab","tab('cbZona')" );
      ((Element)v.get(130)).setAttribute("onshtab","shtab('cbZona')" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:132 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(126)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","25" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(126)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(135)).setAttribute("nombre","cbNJerarUsu" );
      ((Element)v.get(135)).setAttribute("id","datosCampos" );
      ((Element)v.get(135)).setAttribute("size","1" );
      ((Element)v.get(135)).setAttribute("multiple","N" );
      ((Element)v.get(135)).setAttribute("req","N" );
      ((Element)v.get(135)).setAttribute("valorinicial","" );
      ((Element)v.get(135)).setAttribute("textoinicial","" );
      ((Element)v.get(135)).setAttribute("ontab","tab('cbNJerarUsu')" );
      ((Element)v.get(135)).setAttribute("onshtab","shtab('cbNJerarUsu')" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:137 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","25" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(126)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(140)).setAttribute("nombre","cbNivelRiesgo" );
      ((Element)v.get(140)).setAttribute("id","datosCampos" );
      ((Element)v.get(140)).setAttribute("size","1" );
      ((Element)v.get(140)).setAttribute("multiple","N" );
      ((Element)v.get(140)).setAttribute("req","N" );
      ((Element)v.get(140)).setAttribute("valorinicial","" );
      ((Element)v.get(140)).setAttribute("textoinicial","" );
      ((Element)v.get(140)).setAttribute("ontab","tab('cbNivelRiesgo')" );
      ((Element)v.get(140)).setAttribute("onshtab","shtab('cbNivelRiesgo')" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:142 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("width","100%" );
      ((Element)v.get(126)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","8" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:126   */

      /* Empieza nodo:144 / Elemento padre: 110   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(110)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("colspan","4" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:147 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("table"));
      ((Element)v.get(149)).setAttribute("width","652" );
      ((Element)v.get(149)).setAttribute("border","0" );
      ((Element)v.get(149)).setAttribute("align","left" );
      ((Element)v.get(149)).setAttribute("cellspacing","0" );
      ((Element)v.get(149)).setAttribute("cellpadding","0" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","8" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(154)).setAttribute("nombre","lblNValidacionCredNoSuperada" );
      ((Element)v.get(154)).setAttribute("alto","13" );
      ((Element)v.get(154)).setAttribute("filas","1" );
      ((Element)v.get(154)).setAttribute("valor","" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(154)).setAttribute("id","datosTitle" );
      ((Element)v.get(154)).setAttribute("cod","929" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","25" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(158)).setAttribute("nombre","lblGrupoSolicitud" );
      ((Element)v.get(158)).setAttribute("alto","13" );
      ((Element)v.get(158)).setAttribute("filas","1" );
      ((Element)v.get(158)).setAttribute("valor","" );
      ((Element)v.get(158)).setAttribute("id","datosTitle" );
      ((Element)v.get(158)).setAttribute("cod","888" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).setAttribute("width","100%" );
      ((Element)v.get(150)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","8" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:150   */

      /* Empieza nodo:161 / Elemento padre: 149   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(149)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","8" );
      ((Element)v.get(163)).setAttribute("height","8" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(161)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("table"));
      ((Element)v.get(165)).setAttribute("width","100%" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("class","datosCampos" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(168)).setAttribute("check","" );
      ((Element)v.get(168)).setAttribute("id","" );
      ((Element)v.get(168)).setAttribute("msjreq","" );
      ((Element)v.get(168)).setAttribute("nombre","chk1" );
      ((Element)v.get(168)).setAttribute("onclick","" );
      ((Element)v.get(168)).setAttribute("onfocus","" );
      ((Element)v.get(168)).setAttribute("ontab","tab('chk1')" );
      ((Element)v.get(168)).setAttribute("onshtab","shtab('chk1')" );
      ((Element)v.get(168)).setAttribute("readonly","" );
      ((Element)v.get(168)).setAttribute("req","" );
      ((Element)v.get(168)).setAttribute("tabindex","1" );
      ((Element)v.get(168)).setAttribute("texto","1" );
      ((Element)v.get(168)).setAttribute("validacion","" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).setAttribute("class","datosCampos" );
      ((Element)v.get(166)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(170)).setAttribute("check","" );
      ((Element)v.get(170)).setAttribute("id","" );
      ((Element)v.get(170)).setAttribute("msjreq","" );
      ((Element)v.get(170)).setAttribute("nombre","chk2" );
      ((Element)v.get(170)).setAttribute("onclick","" );
      ((Element)v.get(170)).setAttribute("onfocus","" );
      ((Element)v.get(170)).setAttribute("ontab","tab('chk2')" );
      ((Element)v.get(170)).setAttribute("onshtab","shtab('chk2')" );
      ((Element)v.get(170)).setAttribute("readonly","" );
      ((Element)v.get(170)).setAttribute("req","" );
      ((Element)v.get(170)).setAttribute("tabindex","1" );
      ((Element)v.get(170)).setAttribute("texto","2" );
      ((Element)v.get(170)).setAttribute("validacion","" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).setAttribute("class","datosCampos" );
      ((Element)v.get(166)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(172)).setAttribute("check","" );
      ((Element)v.get(172)).setAttribute("id","" );
      ((Element)v.get(172)).setAttribute("msjreq","" );
      ((Element)v.get(172)).setAttribute("nombre","chk3" );
      ((Element)v.get(172)).setAttribute("onclick","" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(172)).setAttribute("onfocus","" );
      ((Element)v.get(172)).setAttribute("ontab","tab('chk3')" );
      ((Element)v.get(172)).setAttribute("onshtab","shtab('chk3')" );
      ((Element)v.get(172)).setAttribute("readonly","" );
      ((Element)v.get(172)).setAttribute("req","" );
      ((Element)v.get(172)).setAttribute("tabindex","1" );
      ((Element)v.get(172)).setAttribute("texto","3" );
      ((Element)v.get(172)).setAttribute("validacion","" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).setAttribute("class","datosCampos" );
      ((Element)v.get(166)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(174)).setAttribute("check","" );
      ((Element)v.get(174)).setAttribute("id","" );
      ((Element)v.get(174)).setAttribute("msjreq","" );
      ((Element)v.get(174)).setAttribute("nombre","chk4" );
      ((Element)v.get(174)).setAttribute("onclick","" );
      ((Element)v.get(174)).setAttribute("onfocus","" );
      ((Element)v.get(174)).setAttribute("ontab","tab('chk4')" );
      ((Element)v.get(174)).setAttribute("onshtab","shtab('chk4')" );
      ((Element)v.get(174)).setAttribute("readonly","" );
      ((Element)v.get(174)).setAttribute("req","" );
      ((Element)v.get(174)).setAttribute("tabindex","1" );
      ((Element)v.get(174)).setAttribute("texto","4" );
      ((Element)v.get(174)).setAttribute("validacion","" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:175 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","25" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(161)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(178)).setAttribute("nombre","cbGrupoSolicitud" );
      ((Element)v.get(178)).setAttribute("id","datosCampos" );
      ((Element)v.get(178)).setAttribute("size","1" );
      ((Element)v.get(178)).setAttribute("multiple","N" );
      ((Element)v.get(178)).setAttribute("req","N" );
      ((Element)v.get(178)).setAttribute("valorinicial","" );
      ((Element)v.get(178)).setAttribute("textoinicial","" );
      ((Element)v.get(178)).setAttribute("ontab","tab('cbGrupoSolicitud')" );
      ((Element)v.get(178)).setAttribute("onshtab","shtab('cbGrupoSolicitud')" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:180 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("width","100%" );
      ((Element)v.get(161)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:161   */

      /* Empieza nodo:182 / Elemento padre: 149   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(149)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).setAttribute("colspan","4" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:185 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("table"));
      ((Element)v.get(187)).setAttribute("width","652" );
      ((Element)v.get(187)).setAttribute("border","0" );
      ((Element)v.get(187)).setAttribute("align","left" );
      ((Element)v.get(187)).setAttribute("cellspacing","0" );
      ((Element)v.get(187)).setAttribute("cellpadding","0" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","8" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(192)).setAttribute("nombre","lblEstatus" );
      ((Element)v.get(192)).setAttribute("alto","13" );
      ((Element)v.get(192)).setAttribute("filas","1" );
      ((Element)v.get(192)).setAttribute("valor","" );
      ((Element)v.get(192)).setAttribute("id","datosTitle" );
      ((Element)v.get(192)).setAttribute("cod","596" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","25" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(196)).setAttribute("nombre","lblEjecutivoCuenta" );
      ((Element)v.get(196)).setAttribute("alto","13" );
      ((Element)v.get(196)).setAttribute("filas","1" );
      ((Element)v.get(196)).setAttribute("valor","" );
      ((Element)v.get(196)).setAttribute("id","datosTitle" );
      ((Element)v.get(196)).setAttribute("cod","854" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","25" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(200)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(200)).setAttribute("alto","13" );
      ((Element)v.get(200)).setAttribute("filas","1" );
      ((Element)v.get(200)).setAttribute("valor","" );
      ((Element)v.get(200)).setAttribute("id","datosTitle" );
      ((Element)v.get(200)).setAttribute("cod","276" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).setAttribute("width","100%" );
      ((Element)v.get(188)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","8" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:188   */

      /* Empieza nodo:203 / Elemento padre: 187   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(187)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","8" );
      ((Element)v.get(205)).setAttribute("height","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(203)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(207)).setAttribute("nombre","cbEstatus" );
      ((Element)v.get(207)).setAttribute("id","datosCampos" );
      ((Element)v.get(207)).setAttribute("size","4" );
      ((Element)v.get(207)).setAttribute("multiple","S" );
      ((Element)v.get(207)).setAttribute("req","N" );
      ((Element)v.get(207)).setAttribute("valorinicial","" );
      ((Element)v.get(207)).setAttribute("textoinicial","" );
      ((Element)v.get(207)).setAttribute("ontab","tab('cbEstatus')" );
      ((Element)v.get(207)).setAttribute("onshtab","shtab('cbEstatus')" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:209 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).setAttribute("width","25" );
      ((Element)v.get(210)).setAttribute("height","8" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(211)).setAttribute("valign","top" );
      ((Element)v.get(203)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(212)).setAttribute("nombre","txtEjecutivoCuenta" );
      ((Element)v.get(212)).setAttribute("id","datosCampos" );
      ((Element)v.get(212)).setAttribute("max","20" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(212)).setAttribute("tipo","" );
      ((Element)v.get(212)).setAttribute("onchange","" );
      ((Element)v.get(212)).setAttribute("req","N" );
      ((Element)v.get(212)).setAttribute("size","27" );
      ((Element)v.get(212)).setAttribute("valor","" );
      ((Element)v.get(212)).setAttribute("validacion","" );
      ((Element)v.get(212)).setAttribute("ontab","tab('txtEjecutivoCuenta')" );
      ((Element)v.get(212)).setAttribute("onshtab","shtab('txtEjecutivoCuenta')" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","25" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(215)).setAttribute("valign","top" );
      ((Element)v.get(203)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(216)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(216)).setAttribute("id","datosCampos" );
      ((Element)v.get(216)).setAttribute("size","1" );
      ((Element)v.get(216)).setAttribute("multiple","N" );
      ((Element)v.get(216)).setAttribute("req","N" );
      ((Element)v.get(216)).setAttribute("valorinicial","" );
      ((Element)v.get(216)).setAttribute("textoinicial","" );
      ((Element)v.get(216)).setAttribute("ontab","tab('cbPeriodo')" );
      ((Element)v.get(216)).setAttribute("onshtab","shtab('cbPeriodo')" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:218 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).setAttribute("width","100%" );
      ((Element)v.get(203)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","8" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:203   */

      /* Empieza nodo:220 / Elemento padre: 187   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(187)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).setAttribute("colspan","4" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","8" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:223 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("table"));
      ((Element)v.get(225)).setAttribute("width","652" );
      ((Element)v.get(225)).setAttribute("border","0" );
      ((Element)v.get(225)).setAttribute("align","left" );
      ((Element)v.get(225)).setAttribute("cellspacing","0" );
      ((Element)v.get(225)).setAttribute("cellpadding","0" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","8" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(230)).setAttribute("nombre","lblMontoOrdenDesde" );
      ((Element)v.get(230)).setAttribute("alto","13" );
      ((Element)v.get(230)).setAttribute("filas","1" );
      ((Element)v.get(230)).setAttribute("valor","" );
      ((Element)v.get(230)).setAttribute("id","datosTitle" );
      ((Element)v.get(230)).setAttribute("cod","919" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","25" );
      ((Element)v.get(232)).setAttribute("height","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(234)).setAttribute("nombre","lblMontoOrdenHasta" );
      ((Element)v.get(234)).setAttribute("alto","13" );
      ((Element)v.get(234)).setAttribute("filas","1" );
      ((Element)v.get(234)).setAttribute("valor","" );
      ((Element)v.get(234)).setAttribute("id","datosTitle" );
      ((Element)v.get(234)).setAttribute("cod","1452" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(236)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).setAttribute("width","25" );
      ((Element)v.get(236)).setAttribute("height","8" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(238)).setAttribute("nombre","lblMontoDeudaDesde" );
      ((Element)v.get(238)).setAttribute("alto","13" );
      ((Element)v.get(238)).setAttribute("filas","1" );
      ((Element)v.get(238)).setAttribute("valor","" );
      ((Element)v.get(238)).setAttribute("id","datosTitle" );
      ((Element)v.get(238)).setAttribute("cod","918" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","25" );
      ((Element)v.get(240)).setAttribute("height","8" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(242)).setAttribute("nombre","lblMontoDeudaHasta" );
      ((Element)v.get(242)).setAttribute("alto","13" );
      ((Element)v.get(242)).setAttribute("filas","1" );
      ((Element)v.get(242)).setAttribute("valor","" );
      ((Element)v.get(242)).setAttribute("id","datosTitle" );
      ((Element)v.get(242)).setAttribute("cod","1453" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("width","100%" );
      ((Element)v.get(226)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","8" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:226   */

      /* Empieza nodo:245 / Elemento padre: 225   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(225)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","8" );
      ((Element)v.get(247)).setAttribute("height","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(245)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(249)).setAttribute("nombre","txtMontoOrdenDesde" );
      ((Element)v.get(249)).setAttribute("id","datosCampos" );
      ((Element)v.get(249)).setAttribute("max","18" );
      ((Element)v.get(249)).setAttribute("tipo","" );
      ((Element)v.get(249)).setAttribute("onchange","" );
      ((Element)v.get(249)).setAttribute("req","N" );
      ((Element)v.get(249)).setAttribute("size","20" );
      ((Element)v.get(249)).setAttribute("valor","" );
      ((Element)v.get(249)).setAttribute("validacion","" );
      ((Element)v.get(249)).setAttribute("ontab","tab('txtMontoOrdenDesde')" );
      ((Element)v.get(249)).setAttribute("onshtab","shtab('txtMontoOrdenDesde')" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","25" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(245)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(253)).setAttribute("nombre","txtMontoOrdenHasta" );
      ((Element)v.get(253)).setAttribute("id","datosCampos" );
      ((Element)v.get(253)).setAttribute("max","18" );
      ((Element)v.get(253)).setAttribute("tipo","" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(253)).setAttribute("onchange","" );
      ((Element)v.get(253)).setAttribute("req","N" );
      ((Element)v.get(253)).setAttribute("size","20" );
      ((Element)v.get(253)).setAttribute("valor","" );
      ((Element)v.get(253)).setAttribute("validacion","" );
      ((Element)v.get(253)).setAttribute("ontab","tab('txtMontoOrdenHasta')" );
      ((Element)v.get(253)).setAttribute("onshtab","shtab('txtMontoOrdenHasta')" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","25" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(245)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(257)).setAttribute("nombre","txtMontoDeudaDesde" );
      ((Element)v.get(257)).setAttribute("id","datosCampos" );
      ((Element)v.get(257)).setAttribute("max","18" );
      ((Element)v.get(257)).setAttribute("tipo","" );
      ((Element)v.get(257)).setAttribute("onchange","" );
      ((Element)v.get(257)).setAttribute("req","N" );
      ((Element)v.get(257)).setAttribute("size","20" );
      ((Element)v.get(257)).setAttribute("valor","" );
      ((Element)v.get(257)).setAttribute("validacion","" );
      ((Element)v.get(257)).setAttribute("ontab","tab('txtMontoDeudaDesde')" );
      ((Element)v.get(257)).setAttribute("onshtab","shtab('txtMontoDeudaDesde')" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","25" );
      ((Element)v.get(259)).setAttribute("height","8" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(245)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(261)).setAttribute("nombre","txtMontoDeudaHasta" );
      ((Element)v.get(261)).setAttribute("id","datosCampos" );
      ((Element)v.get(261)).setAttribute("max","18" );
      ((Element)v.get(261)).setAttribute("tipo","" );
      ((Element)v.get(261)).setAttribute("onchange","" );
      ((Element)v.get(261)).setAttribute("req","N" );
      ((Element)v.get(261)).setAttribute("size","20" );
      ((Element)v.get(261)).setAttribute("valor","" );
      ((Element)v.get(261)).setAttribute("validacion","" );
      ((Element)v.get(261)).setAttribute("ontab","tab('txtMontoDeudaHasta')" );
      ((Element)v.get(261)).setAttribute("onshtab","shtab('txtMontoDeudaHasta')" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).setAttribute("width","100%" );
      ((Element)v.get(245)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","8" );
      ((Element)v.get(263)).setAttribute("height","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:245   */

      /* Empieza nodo:264 / Elemento padre: 225   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(225)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).setAttribute("colspan","4" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","8" );
      ((Element)v.get(266)).setAttribute("height","8" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:44   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:267 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:37   */

      /* Empieza nodo:269 / Elemento padre: 29   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(29)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("table"));
      ((Element)v.get(274)).setAttribute("width","100%" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(274)).setAttribute("border","0" );
      ((Element)v.get(274)).setAttribute("align","center" );
      ((Element)v.get(274)).setAttribute("cellspacing","0" );
      ((Element)v.get(274)).setAttribute("cellpadding","0" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(276)).setAttribute("class","botonera" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(277)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(277)).setAttribute("ID","botonContenido" );
      ((Element)v.get(277)).setAttribute("tipo","html" );
      ((Element)v.get(277)).setAttribute("accion","buscar_click()" );
      ((Element)v.get(277)).setAttribute("estado","false" );
      ((Element)v.get(277)).setAttribute("cod","1" );
      ((Element)v.get(277)).setAttribute("ontab","tab('btnBuscar')" );
      ((Element)v.get(277)).setAttribute("onshtab","shtab('btnBuscar')" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:278 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).setAttribute("width","8" );
      ((Element)v.get(279)).setAttribute("height","12" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:269   */

      /* Empieza nodo:280 / Elemento padre: 29   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(29)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).setAttribute("width","12" );
      ((Element)v.get(281)).setAttribute("align","center" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).setAttribute("width","12" );
      ((Element)v.get(282)).setAttribute("height","12" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).setAttribute("width","750" );
      ((Element)v.get(280)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).setAttribute("width","12" );
      ((Element)v.get(280)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(286)).setAttribute("src","b.gif" );
      ((Element)v.get(286)).setAttribute("width","12" );
      ((Element)v.get(286)).setAttribute("height","1" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:280   */
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:287 / Elemento padre: 13   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(287)).setAttribute("nombre","listado1" );
      ((Element)v.get(287)).setAttribute("ancho","655" );
      ((Element)v.get(287)).setAttribute("alto","317" );
      ((Element)v.get(287)).setAttribute("x","12" );
      ((Element)v.get(287)).setAttribute("y","361" );
      ((Element)v.get(287)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(287)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(13)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(288)).setAttribute("precarga","S" );
      ((Element)v.get(288)).setAttribute("conROver","S" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(289)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(289)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(289)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(289)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 288   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(290)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(290)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(290)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(290)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(288)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 288   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(291)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(291)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(288)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:288   */

      /* Empieza nodo:292 / Elemento padre: 287   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(287)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(293)).setAttribute("borde","1" );
      ((Element)v.get(293)).setAttribute("horizDatos","1" );
      ((Element)v.get(293)).setAttribute("horizCabecera","1" );
      ((Element)v.get(293)).setAttribute("vertical","1" );
      ((Element)v.get(293)).setAttribute("horizTitulo","1" );
      ((Element)v.get(293)).setAttribute("horizBase","1" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 292   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(294)).setAttribute("borde","#999999" );
      ((Element)v.get(294)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(294)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(294)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(294)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(294)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(294)).setAttribute("horizBase","#999999" );
      ((Element)v.get(292)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:292   */

      /* Empieza nodo:295 / Elemento padre: 287   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(295)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(295)).setAttribute("alto","22" );
      ((Element)v.get(295)).setAttribute("imgFondo","" );
      ((Element)v.get(295)).setAttribute("cod","00135" );
      ((Element)v.get(295)).setAttribute("ID","datosTitle" );
      ((Element)v.get(287)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 287   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(296)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(296)).setAttribute("alto","22" );
      ((Element)v.get(296)).setAttribute("imgFondo","" );
      ((Element)v.get(287)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 287   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(297)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(297)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(297)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(297)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(297)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(297)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(287)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(298)).setAttribute("ancho","100" );
      ((Element)v.get(298)).setAttribute("minimizable","S" );
      ((Element)v.get(298)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(299)).setAttribute("ancho","100" );
      ((Element)v.get(299)).setAttribute("minimizable","S" );
      ((Element)v.get(299)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(300)).setAttribute("ancho","100" );
      ((Element)v.get(300)).setAttribute("minimizable","S" );
      ((Element)v.get(300)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(301)).setAttribute("ancho","150" );
      ((Element)v.get(301)).setAttribute("minimizable","S" );
      ((Element)v.get(301)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(302)).setAttribute("ancho","100" );
      ((Element)v.get(302)).setAttribute("minimizable","S" );
      ((Element)v.get(302)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(303)).setAttribute("ancho","100" );
      ((Element)v.get(303)).setAttribute("minimizable","S" );
      ((Element)v.get(303)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(304)).setAttribute("ancho","100" );
      ((Element)v.get(304)).setAttribute("minimizable","S" );
      ((Element)v.get(304)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("ancho","150" );
      ((Element)v.get(305)).setAttribute("minimizable","S" );
      ((Element)v.get(305)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(306)).setAttribute("ancho","100" );
      ((Element)v.get(306)).setAttribute("minimizable","S" );
      ((Element)v.get(306)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(307)).setAttribute("ancho","150" );
      ((Element)v.get(307)).setAttribute("minimizable","S" );
      ((Element)v.get(307)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */

      /* Empieza nodo:308 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(308)).setAttribute("ancho","100" );
      ((Element)v.get(308)).setAttribute("minimizable","S" );
      ((Element)v.get(308)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(309)).setAttribute("ancho","100" );
      ((Element)v.get(309)).setAttribute("minimizable","S" );
      ((Element)v.get(309)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */

      /* Empieza nodo:310 / Elemento padre: 297   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(310)).setAttribute("ancho","120" );
      ((Element)v.get(310)).setAttribute("minimizable","S" );
      ((Element)v.get(310)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(311)).setAttribute("ancho","100" );
      ((Element)v.get(311)).setAttribute("minimizable","S" );
      ((Element)v.get(311)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(312)).setAttribute("ancho","190" );
      ((Element)v.get(312)).setAttribute("minimizable","S" );
      ((Element)v.get(312)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */

      /* Empieza nodo:313 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(313)).setAttribute("ancho","100" );
      ((Element)v.get(313)).setAttribute("minimizable","S" );
      ((Element)v.get(313)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */

      /* Empieza nodo:314 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(314)).setAttribute("ancho","100" );
      ((Element)v.get(314)).setAttribute("minimizable","S" );
      ((Element)v.get(314)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */

      /* Empieza nodo:315 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(315)).setAttribute("ancho","100" );
      ((Element)v.get(315)).setAttribute("minimizable","S" );
      ((Element)v.get(315)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */

      /* Empieza nodo:316 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(316)).setAttribute("ancho","100" );
      ((Element)v.get(316)).setAttribute("minimizable","S" );
      ((Element)v.get(316)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */

      /* Empieza nodo:317 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(317)).setAttribute("ancho","150" );
      ((Element)v.get(317)).setAttribute("minimizable","S" );
      ((Element)v.get(317)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */

      /* Empieza nodo:318 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(318)).setAttribute("ancho","100" );
      ((Element)v.get(318)).setAttribute("minimizable","S" );
      ((Element)v.get(318)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */

      /* Empieza nodo:319 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(319)).setAttribute("ancho","100" );
      ((Element)v.get(319)).setAttribute("minimizable","S" );
      ((Element)v.get(319)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(320)).setAttribute("ancho","100" );
      ((Element)v.get(320)).setAttribute("minimizable","S" );
      ((Element)v.get(320)).setAttribute("minimizada","N" );
      ((Element)v.get(320)).setAttribute("oculta","S" );
      ((Element)v.get(297)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:297   */

      /* Empieza nodo:321 / Elemento padre: 287   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(321)).setAttribute("alto","20" );
      ((Element)v.get(321)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(321)).setAttribute("imgFondo","" );
      ((Element)v.get(321)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(287)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(322)).setAttribute("colFondo","" );
      ((Element)v.get(322)).setAttribute("ID","EstCab" );
      ((Element)v.get(322)).setAttribute("cod","143" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */

      /* Empieza nodo:323 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(323)).setAttribute("colFondo","" );
      ((Element)v.get(323)).setAttribute("ID","EstCab" );
      ((Element)v.get(323)).setAttribute("cod","263" );
      ((Element)v.get(321)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */

      /* Empieza nodo:324 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(324)).setAttribute("colFondo","" );
      ((Element)v.get(324)).setAttribute("ID","EstCab" );
      ((Element)v.get(324)).setAttribute("cod","264" );
      ((Element)v.get(321)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */

      /* Empieza nodo:325 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(325)).setAttribute("colFondo","" );
      ((Element)v.get(325)).setAttribute("ID","EstCab" );
      ((Element)v.get(325)).setAttribute("cod","1167" );
      ((Element)v.get(321)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(326)).setAttribute("colFondo","" );
      ((Element)v.get(326)).setAttribute("ID","EstCab" );
      ((Element)v.get(326)).setAttribute("cod","132" );
      ((Element)v.get(321)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */

      /* Empieza nodo:327 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(327)).setAttribute("colFondo","" );
      ((Element)v.get(327)).setAttribute("ID","EstCab" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(327)).setAttribute("cod","276" );
      ((Element)v.get(321)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */

      /* Empieza nodo:328 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(328)).setAttribute("colFondo","" );
      ((Element)v.get(328)).setAttribute("ID","EstCab" );
      ((Element)v.get(328)).setAttribute("cod","1165" );
      ((Element)v.get(321)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */

      /* Empieza nodo:329 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(329)).setAttribute("colFondo","" );
      ((Element)v.get(329)).setAttribute("ID","EstCab" );
      ((Element)v.get(329)).setAttribute("cod","1166" );
      ((Element)v.get(321)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */

      /* Empieza nodo:330 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(330)).setAttribute("colFondo","" );
      ((Element)v.get(330)).setAttribute("ID","EstCab" );
      ((Element)v.get(330)).setAttribute("cod","596" );
      ((Element)v.get(321)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */

      /* Empieza nodo:331 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(331)).setAttribute("colFondo","" );
      ((Element)v.get(331)).setAttribute("ID","EstCab" );
      ((Element)v.get(331)).setAttribute("cod","1478" );
      ((Element)v.get(321)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */

      /* Empieza nodo:332 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(332)).setAttribute("colFondo","" );
      ((Element)v.get(332)).setAttribute("ID","EstCab" );
      ((Element)v.get(332)).setAttribute("cod","910" );
      ((Element)v.get(321)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */

      /* Empieza nodo:333 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(333)).setAttribute("colFondo","" );
      ((Element)v.get(333)).setAttribute("ID","EstCab" );
      ((Element)v.get(333)).setAttribute("cod","1416" );
      ((Element)v.get(321)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */

      /* Empieza nodo:334 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(334)).setAttribute("colFondo","" );
      ((Element)v.get(334)).setAttribute("ID","EstCab" );
      ((Element)v.get(334)).setAttribute("cod","1487" );
      ((Element)v.get(321)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */

      /* Empieza nodo:335 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(335)).setAttribute("colFondo","" );
      ((Element)v.get(335)).setAttribute("ID","EstCab" );
      ((Element)v.get(335)).setAttribute("cod","928" );
      ((Element)v.get(321)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */

      /* Empieza nodo:336 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(336)).setAttribute("colFondo","" );
      ((Element)v.get(336)).setAttribute("ID","EstCab" );
      ((Element)v.get(336)).setAttribute("cod","927" );
      ((Element)v.get(321)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */

      /* Empieza nodo:337 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(337)).setAttribute("colFondo","" );
      ((Element)v.get(337)).setAttribute("ID","EstCab" );
      ((Element)v.get(337)).setAttribute("cod","854" );
      ((Element)v.get(321)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */

      /* Empieza nodo:338 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(338)).setAttribute("colFondo","" );
      ((Element)v.get(338)).setAttribute("ID","EstCab" );
      ((Element)v.get(338)).setAttribute("cod","888" );
      ((Element)v.get(321)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */

      /* Empieza nodo:339 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(339)).setAttribute("colFondo","" );
      ((Element)v.get(339)).setAttribute("ID","EstCab" );
      ((Element)v.get(339)).setAttribute("cod","6" );
      ((Element)v.get(321)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */

      /* Empieza nodo:340 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(340)).setAttribute("colFondo","" );
      ((Element)v.get(340)).setAttribute("ID","EstCab" );
      ((Element)v.get(340)).setAttribute("cod","7" );
      ((Element)v.get(321)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */

      /* Empieza nodo:341 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(341)).setAttribute("colFondo","" );
      ((Element)v.get(341)).setAttribute("ID","EstCab" );
      ((Element)v.get(341)).setAttribute("cod","124" );
      ((Element)v.get(321)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */

      /* Empieza nodo:342 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(342)).setAttribute("colFondo","" );
      ((Element)v.get(342)).setAttribute("ID","EstCab" );
      ((Element)v.get(342)).setAttribute("cod","109" );
      ((Element)v.get(321)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */

      /* Empieza nodo:343 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(343)).setAttribute("colFondo","" );
      ((Element)v.get(343)).setAttribute("ID","EstCab" );
      ((Element)v.get(343)).setAttribute("cod","1164" );
      ((Element)v.get(321)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */

      /* Empieza nodo:344 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(344)).setAttribute("colFondo","" );
      ((Element)v.get(344)).setAttribute("ID","EstCab" );
      ((Element)v.get(344)).setAttribute("cod","" );
      ((Element)v.get(321)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:321   */

      /* Empieza nodo:345 / Elemento padre: 287   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(345)).setAttribute("alto","22" );
      ((Element)v.get(345)).setAttribute("accion","" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(345)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(345)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(345)).setAttribute("maxSel","1" );
      ((Element)v.get(345)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(345)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(345)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(345)).setAttribute("onLoad","" );
      ((Element)v.get(345)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(287)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(346)).setAttribute("tipo","texto" );
      ((Element)v.get(346)).setAttribute("ID","EstDat" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */

      /* Empieza nodo:347 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(347)).setAttribute("tipo","texto" );
      ((Element)v.get(347)).setAttribute("ID","EstDat2" );
      ((Element)v.get(345)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */

      /* Empieza nodo:348 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(348)).setAttribute("tipo","texto" );
      ((Element)v.get(348)).setAttribute("ID","EstDat" );
      ((Element)v.get(345)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */

      /* Empieza nodo:349 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(349)).setAttribute("tipo","texto" );
      ((Element)v.get(349)).setAttribute("ID","EstDat2" );
      ((Element)v.get(345)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */

      /* Empieza nodo:350 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(350)).setAttribute("tipo","texto" );
      ((Element)v.get(350)).setAttribute("ID","EstDat" );
      ((Element)v.get(345)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */

      /* Empieza nodo:351 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(351)).setAttribute("tipo","texto" );
      ((Element)v.get(351)).setAttribute("ID","EstDat2" );
      ((Element)v.get(345)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */

      /* Empieza nodo:352 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(352)).setAttribute("tipo","texto" );
      ((Element)v.get(352)).setAttribute("ID","EstDat" );
      ((Element)v.get(345)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */

      /* Empieza nodo:353 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(353)).setAttribute("tipo","texto" );
      ((Element)v.get(353)).setAttribute("ID","EstDat2" );
      ((Element)v.get(345)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */

      /* Empieza nodo:354 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(354)).setAttribute("tipo","texto" );
      ((Element)v.get(354)).setAttribute("ID","EstDat" );
      ((Element)v.get(345)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */

      /* Empieza nodo:355 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(355)).setAttribute("tipo","texto" );
      ((Element)v.get(355)).setAttribute("ID","EstDat2" );
      ((Element)v.get(345)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */

      /* Empieza nodo:356 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(356)).setAttribute("tipo","texto" );
      ((Element)v.get(356)).setAttribute("ID","EstDat" );
      ((Element)v.get(345)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */

      /* Empieza nodo:357 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(357)).setAttribute("tipo","texto" );
      ((Element)v.get(357)).setAttribute("ID","EstDat2" );
      ((Element)v.get(345)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */

      /* Empieza nodo:358 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(358)).setAttribute("tipo","texto" );
      ((Element)v.get(358)).setAttribute("ID","EstDat" );
      ((Element)v.get(345)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(359)).setAttribute("tipo","texto" );
      ((Element)v.get(359)).setAttribute("ID","EstDat2" );
      ((Element)v.get(345)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(360)).setAttribute("tipo","texto" );
      ((Element)v.get(360)).setAttribute("ID","EstDat" );
      ((Element)v.get(345)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */

      /* Empieza nodo:361 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(361)).setAttribute("tipo","texto" );
      ((Element)v.get(361)).setAttribute("ID","EstDat2" );
      ((Element)v.get(345)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(362)).setAttribute("tipo","texto" );
      ((Element)v.get(362)).setAttribute("ID","EstDat" );
      ((Element)v.get(345)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */

      /* Empieza nodo:363 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(363)).setAttribute("tipo","texto" );
      ((Element)v.get(363)).setAttribute("ID","EstDat2" );
      ((Element)v.get(345)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */

      /* Empieza nodo:364 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(364)).setAttribute("tipo","texto" );
      ((Element)v.get(364)).setAttribute("ID","EstDat" );
      ((Element)v.get(345)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */

      /* Empieza nodo:365 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(365)).setAttribute("tipo","texto" );
      ((Element)v.get(365)).setAttribute("ID","EstDat2" );
      ((Element)v.get(345)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */

      /* Empieza nodo:366 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(366)).setAttribute("tipo","texto" );
      ((Element)v.get(366)).setAttribute("ID","EstDat" );
      ((Element)v.get(345)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */

      /* Empieza nodo:367 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(367)).setAttribute("tipo","texto" );
      ((Element)v.get(367)).setAttribute("ID","EstDat2" );
      ((Element)v.get(345)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */

      /* Empieza nodo:368 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(368)).setAttribute("tipo","texto" );
      ((Element)v.get(368)).setAttribute("ID","EstDat" );
      ((Element)v.get(345)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:345   */

      /* Empieza nodo:369 / Elemento padre: 287   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(287)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */

      /* Empieza nodo:370 / Elemento padre: 287   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(370)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(370)).setAttribute("ancho","655" );
      ((Element)v.get(370)).setAttribute("sep","$" );
      ((Element)v.get(370)).setAttribute("x","12" );
      ((Element)v.get(370)).setAttribute("class","botonera" );
      ((Element)v.get(370)).setAttribute("y","655" );
      ((Element)v.get(370)).setAttribute("control","|" );
      ((Element)v.get(370)).setAttribute("conector","" );
      ((Element)v.get(370)).setAttribute("rowset","" );
      ((Element)v.get(370)).setAttribute("cargainicial","N" );
      ((Element)v.get(370)).setAttribute("onload","procesarPaginado(mipgndo, msgError, ultima, rowset, 'gestionaLista(ultima, rowset)')" );
      ((Element)v.get(287)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(371)).setAttribute("nombre","ret1" );
      ((Element)v.get(371)).setAttribute("x","37" );
      ((Element)v.get(371)).setAttribute("y","659" );
      ((Element)v.get(371)).setAttribute("ID","botonContenido" );
      ((Element)v.get(371)).setAttribute("img","retroceder_on" );
      ((Element)v.get(371)).setAttribute("tipo","0" );
      ((Element)v.get(371)).setAttribute("estado","false" );
      ((Element)v.get(371)).setAttribute("alt","" );
      ((Element)v.get(371)).setAttribute("codigo","" );
      ((Element)v.get(371)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */

      /* Empieza nodo:372 / Elemento padre: 370   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(372)).setAttribute("nombre","ava1" );
      ((Element)v.get(372)).setAttribute("x","52" );
      ((Element)v.get(372)).setAttribute("y","659" );
      ((Element)v.get(372)).setAttribute("ID","botonContenido" );
      ((Element)v.get(372)).setAttribute("img","avanzar_on" );
      ((Element)v.get(372)).setAttribute("tipo","0" );
      ((Element)v.get(372)).setAttribute("estado","false" );
      ((Element)v.get(372)).setAttribute("alt","" );
      ((Element)v.get(372)).setAttribute("codigo","" );
      ((Element)v.get(372)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(370)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:370   */
      /* Termina nodo:287   */

      /* Empieza nodo:373 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(373)).setAttribute("nombre","primera1" );
      ((Element)v.get(373)).setAttribute("x","20" );
      ((Element)v.get(373)).setAttribute("y","659" );
      ((Element)v.get(373)).setAttribute("ID","botonContenido" );
      ((Element)v.get(373)).setAttribute("img","primera_on" );
      ((Element)v.get(373)).setAttribute("tipo","-2" );
      ((Element)v.get(373)).setAttribute("estado","false" );
      ((Element)v.get(373)).setAttribute("alt","" );
      ((Element)v.get(373)).setAttribute("codigo","" );
      ((Element)v.get(373)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(13)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */

      /* Empieza nodo:374 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(374)).setAttribute("nombre","separa" );
      ((Element)v.get(374)).setAttribute("x","59" );
      ((Element)v.get(374)).setAttribute("y","655" );
      ((Element)v.get(374)).setAttribute("ID","botonContenido" );
      ((Element)v.get(374)).setAttribute("img","separa_base" );
      ((Element)v.get(374)).setAttribute("tipo","0" );
      ((Element)v.get(374)).setAttribute("estado","false" );
      ((Element)v.get(374)).setAttribute("alt","" );
      ((Element)v.get(374)).setAttribute("codigo","" );
      ((Element)v.get(374)).setAttribute("accion","" );
      ((Element)v.get(13)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */

      /* Empieza nodo:375 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(375)).setAttribute("nombre","Rechazar" );
      ((Element)v.get(375)).setAttribute("x","80" );
      ((Element)v.get(375)).setAttribute("y","656" );
      ((Element)v.get(375)).setAttribute("ID","botonContenido" );
      ((Element)v.get(375)).setAttribute("tipo","html" );
      ((Element)v.get(375)).setAttribute("estado","false" );
      ((Element)v.get(375)).setAttribute("cod","979" );
      ((Element)v.get(375)).setAttribute("accion","rechazar_click();" );
      ((Element)v.get(375)).setAttribute("ontab","tab('Rechazar')" );
      ((Element)v.get(375)).setAttribute("onshtab","shtab('Rechazar')" );
      ((Element)v.get(13)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */

      /* Empieza nodo:376 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(376)).setAttribute("nombre","Reasignar" );
      ((Element)v.get(376)).setAttribute("x","150" );
      ((Element)v.get(376)).setAttribute("y","656" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(376)).setAttribute("ID","botonContenido" );
      ((Element)v.get(376)).setAttribute("tipo","html" );
      ((Element)v.get(376)).setAttribute("estado","false" );
      ((Element)v.get(376)).setAttribute("cod","977" );
      ((Element)v.get(376)).setAttribute("accion","reasignar_click();" );
      ((Element)v.get(376)).setAttribute("ontab","tab('Reasignar')" );
      ((Element)v.get(376)).setAttribute("onshtab","shtab('Reasignar')" );
      ((Element)v.get(13)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */

      /* Empieza nodo:377 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(377)).setAttribute("nombre","Liberar" );
      ((Element)v.get(377)).setAttribute("x","223" );
      ((Element)v.get(377)).setAttribute("y","656" );
      ((Element)v.get(377)).setAttribute("ID","botonContenido" );
      ((Element)v.get(377)).setAttribute("tipo","html" );
      ((Element)v.get(377)).setAttribute("estado","false" );
      ((Element)v.get(377)).setAttribute("cod","1454" );
      ((Element)v.get(377)).setAttribute("accion","liberar_click();" );
      ((Element)v.get(377)).setAttribute("ontab","tab('Liberar')" );
      ((Element)v.get(377)).setAttribute("onshtab","shtab('Liberar')" );
      ((Element)v.get(13)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */

      /* Empieza nodo:378 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(378)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(378)).setAttribute("alto","18" );
      ((Element)v.get(378)).setAttribute("ancho","100" );
      ((Element)v.get(378)).setAttribute("colorf","" );
      ((Element)v.get(378)).setAttribute("borde","0" );
      ((Element)v.get(378)).setAttribute("imagenf","" );
      ((Element)v.get(378)).setAttribute("repeat","" );
      ((Element)v.get(378)).setAttribute("padding","" );
      ((Element)v.get(378)).setAttribute("visibilidad","visible" );
      ((Element)v.get(378)).setAttribute("contravsb","" );
      ((Element)v.get(378)).setAttribute("x","0" );
      ((Element)v.get(378)).setAttribute("y","678" );
      ((Element)v.get(378)).setAttribute("zindex","" );
      ((Element)v.get(13)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:13   */

      /* Empieza nodo:379 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(379)).setAttribute("nombre","frmContenidoEnvia" );
      ((Element)v.get(379)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(380)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(380)).setAttribute("valor","" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */

      /* Empieza nodo:381 / Elemento padre: 379   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(381)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(381)).setAttribute("valor","" );
      ((Element)v.get(379)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */

      /* Empieza nodo:382 / Elemento padre: 379   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(382)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(382)).setAttribute("valor","" );
      ((Element)v.get(379)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:379   */


   }

}

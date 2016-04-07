
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_informacion_producto_buscar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_informacion_producto_buscar" );
      ((Element)v.get(0)).setAttribute("cod","0592" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar información sobre productos" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("onunload","unLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","contenido_informacion_producto_buscar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","pais" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","idioma" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","accion" );
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
      ((Element)v.get(13)).setAttribute("nombre","MAE_TXT_PRODUCTO" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","MAE_TXT_SERVICIO" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","MAE_TXT_PRODUCTO_ACTIVO" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","MAE_TXT_PRODUCTO_INACTIVO" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","CMN_VAL_FALSE" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","CMN_VAL_TRUE" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","MAE_PRODUCTO_INACTIVO" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","MAE_PRODUCTO_ACTIVO" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("nombre","oidTipoCliente" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","oidPeriodo" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","oidMarca" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","oidCanal" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","oidZona" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","oidContacto" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hid_SeparadorMiles" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hid_NumeroDecimales" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hid_SeparadorDecimales" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(31)).setAttribute("nombre","capa1" );
      ((Element)v.get(6)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("table"));
      ((Element)v.get(32)).setAttribute("width","100%" );
      ((Element)v.get(32)).setAttribute("border","0" );
      ((Element)v.get(32)).setAttribute("cellspacing","0" );
      ((Element)v.get(32)).setAttribute("cellpadding","0" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).setAttribute("width","12" );
      ((Element)v.get(34)).setAttribute("align","center" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).setAttribute("width","12" );
      ((Element)v.get(35)).setAttribute("height","12" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).setAttribute("width","750" );
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("width","12" );
      ((Element)v.get(33)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","12" );
      ((Element)v.get(39)).setAttribute("height","1" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:33   */

      /* Empieza nodo:40 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(45)).setAttribute("class","legend" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(46)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(46)).setAttribute("alto","13" );
      ((Element)v.get(46)).setAttribute("filas","1" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(46)).setAttribute("id","legend" );
      ((Element)v.get(46)).setAttribute("cod","0075" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("table"));
      ((Element)v.get(47)).setAttribute("width","100%" );
      ((Element)v.get(47)).setAttribute("border","0" );
      ((Element)v.get(47)).setAttribute("align","center" );
      ((Element)v.get(47)).setAttribute("cellspacing","0" );
      ((Element)v.get(47)).setAttribute("cellpadding","0" );
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("table"));
      ((Element)v.get(50)).setAttribute("width","664" );
      ((Element)v.get(50)).setAttribute("border","0" );
      ((Element)v.get(50)).setAttribute("align","left" );
      ((Element)v.get(50)).setAttribute("cellspacing","0" );
      ((Element)v.get(50)).setAttribute("cellpadding","0" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

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
      ((Element)v.get(58)).setAttribute("nombre","lblCodSAP" );
      ((Element)v.get(58)).setAttribute("alto","13" );
      ((Element)v.get(58)).setAttribute("filas","1" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(58)).setAttribute("id","datosTitle" );
      ((Element)v.get(58)).setAttribute("cod","585" );
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
      ((Element)v.get(62)).setAttribute("nombre","lblCodAntiguo" );
      ((Element)v.get(62)).setAttribute("alto","13" );
      ((Element)v.get(62)).setAttribute("filas","1" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(62)).setAttribute("id","datosTitle" );
      ((Element)v.get(62)).setAttribute("cod","1059" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","25" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(66)).setAttribute("nombre","lblDescripcionCorta" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("filas","1" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(66)).setAttribute("id","datosTitle" );
      ((Element)v.get(66)).setAttribute("cod","47" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("width","100%" );
      ((Element)v.get(54)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:54   */

      /* Empieza nodo:69 / Elemento padre: 50   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(69)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(73)).setAttribute("nombre","txtCodSAP" );
      ((Element)v.get(73)).setAttribute("id","datosCampos" );
      ((Element)v.get(73)).setAttribute("max","20" );
      ((Element)v.get(73)).setAttribute("tipo","" );
      ((Element)v.get(73)).setAttribute("onchange","" );
      ((Element)v.get(73)).setAttribute("req","N" );
      ((Element)v.get(73)).setAttribute("size","26" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(73)).setAttribute("validacion","" );
      ((Element)v.get(73)).setAttribute("onshtab","document.body.focus();onshtabTxtCodSAP();" );
      ((Element)v.get(73)).setAttribute("onblur","mayusculas('txtCodSAP');" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","25" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(69)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(77)).setAttribute("nombre","txtCodAntiguo" );
      ((Element)v.get(77)).setAttribute("id","datosCampos" );
      ((Element)v.get(77)).setAttribute("max","18" );
      ((Element)v.get(77)).setAttribute("tipo","" );
      ((Element)v.get(77)).setAttribute("onchange","" );
      ((Element)v.get(77)).setAttribute("req","N" );
      ((Element)v.get(77)).setAttribute("size","22" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(77)).setAttribute("validacion","" );
      ((Element)v.get(77)).setAttribute("onblur","mayusculas('txtCodAntiguo');" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","25" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(69)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(81)).setAttribute("nombre","txtDescripcionCorta" );
      ((Element)v.get(81)).setAttribute("id","datosCampos" );
      ((Element)v.get(81)).setAttribute("max","40" );
      ((Element)v.get(81)).setAttribute("tipo","" );
      ((Element)v.get(81)).setAttribute("onchange","" );
      ((Element)v.get(81)).setAttribute("req","N" );
      ((Element)v.get(81)).setAttribute("size","55" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(81)).setAttribute("validacion","" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","100%" );
      ((Element)v.get(69)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","8" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:69   */

      /* Empieza nodo:84 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("colspan","4" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:87 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("table"));
      ((Element)v.get(89)).setAttribute("width","664" );
      ((Element)v.get(89)).setAttribute("border","0" );
      ((Element)v.get(89)).setAttribute("align","left" );
      ((Element)v.get(89)).setAttribute("cellspacing","0" );
      ((Element)v.get(89)).setAttribute("cellpadding","0" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(94)).setAttribute("nombre","lblDescripcionSAP" );
      ((Element)v.get(94)).setAttribute("alto","13" );
      ((Element)v.get(94)).setAttribute("filas","1" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(94)).setAttribute("id","datosTitle" );
      ((Element)v.get(94)).setAttribute("cod","1068" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","25" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(98)).setAttribute("nombre","lblProductoServicio" );
      ((Element)v.get(98)).setAttribute("alto","13" );
      ((Element)v.get(98)).setAttribute("filas","1" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(98)).setAttribute("id","datosTitle" );
      ((Element)v.get(98)).setAttribute("cod","2078" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","25" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(102)).setAttribute("nombre","lblMarcaProducto" );
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("filas","1" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(102)).setAttribute("id","datosTitle" );
      ((Element)v.get(102)).setAttribute("cod","2448" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","100%" );
      ((Element)v.get(90)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:90   */

      /* Empieza nodo:105 / Elemento padre: 89   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(89)).appendChild((Element)v.get(105));

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
      ((Element)v.get(108)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(105)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(109)).setAttribute("nombre","txtDescripcionSAP" );
      ((Element)v.get(109)).setAttribute("id","datosCampos" );
      ((Element)v.get(109)).setAttribute("max","40" );
      ((Element)v.get(109)).setAttribute("tipo","" );
      ((Element)v.get(109)).setAttribute("onchange","" );
      ((Element)v.get(109)).setAttribute("req","N" );
      ((Element)v.get(109)).setAttribute("size","55" );
      ((Element)v.get(109)).setAttribute("valor","" );
      ((Element)v.get(109)).setAttribute("validacion","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
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
      ((Element)v.get(112)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(105)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(113)).setAttribute("nombre","cbProductoServicio" );
      ((Element)v.get(113)).setAttribute("id","datosCampos" );
      ((Element)v.get(113)).setAttribute("size","1" );
      ((Element)v.get(113)).setAttribute("multiple","N" );
      ((Element)v.get(113)).setAttribute("req","N" );
      ((Element)v.get(113)).setAttribute("valorinicial","" );
      ((Element)v.get(113)).setAttribute("textoinicial","" );
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
      ((Element)v.get(116)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(105)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(117)).setAttribute("nombre","cbMarcaProducto" );
      ((Element)v.get(117)).setAttribute("id","datosCampos" );
      ((Element)v.get(117)).setAttribute("size","1" );
      ((Element)v.get(117)).setAttribute("multiple","N" );
      ((Element)v.get(117)).setAttribute("req","N" );
      ((Element)v.get(117)).setAttribute("valorinicial","" );
      ((Element)v.get(117)).setAttribute("textoinicial","" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:119 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("width","100%" );
      ((Element)v.get(105)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","8" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:105   */

      /* Empieza nodo:121 / Elemento padre: 89   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(89)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("colspan","4" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:124 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("table"));
      ((Element)v.get(126)).setAttribute("width","664" );
      ((Element)v.get(126)).setAttribute("border","0" );
      ((Element)v.get(126)).setAttribute("align","left" );
      ((Element)v.get(126)).setAttribute("cellspacing","0" );
      ((Element)v.get(126)).setAttribute("cellpadding","0" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

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
      ((Element)v.get(131)).setAttribute("nombre","lblUniNegocio" );
      ((Element)v.get(131)).setAttribute("alto","13" );
      ((Element)v.get(131)).setAttribute("filas","1" );
      ((Element)v.get(131)).setAttribute("valor","" );
      ((Element)v.get(131)).setAttribute("id","datosTitle" );
      ((Element)v.get(131)).setAttribute("cod","587" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
   }

   private void getXML540(Document doc) {
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
      ((Element)v.get(135)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(135)).setAttribute("alto","13" );
      ((Element)v.get(135)).setAttribute("filas","1" );
      ((Element)v.get(135)).setAttribute("valor","" );
      ((Element)v.get(135)).setAttribute("id","datosTitle" );
      ((Element)v.get(135)).setAttribute("cod","588" );
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

      /* Empieza nodo:138 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(138));

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
      ((Element)v.get(141)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(142)).setAttribute("nombre","cbUnidadNegocio" );
      ((Element)v.get(142)).setAttribute("id","datosCampos" );
      ((Element)v.get(142)).setAttribute("size","1" );
      ((Element)v.get(142)).setAttribute("multiple","N" );
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
      ((Element)v.get(146)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(138)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(147)).setAttribute("nombre","cbNegocio" );
      ((Element)v.get(147)).setAttribute("id","datosCampos" );
      ((Element)v.get(147)).setAttribute("size","1" );
      ((Element)v.get(147)).setAttribute("multiple","N" );
      ((Element)v.get(147)).setAttribute("req","N" );
      ((Element)v.get(147)).setAttribute("valorinicial","" );
      ((Element)v.get(147)).setAttribute("textoinicial","" );
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

      /* Empieza nodo:151 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("colspan","4" );
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
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:154 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("table"));
      ((Element)v.get(156)).setAttribute("width","664" );
      ((Element)v.get(156)).setAttribute("border","0" );
      ((Element)v.get(156)).setAttribute("align","left" );
      ((Element)v.get(156)).setAttribute("cellspacing","0" );
      ((Element)v.get(156)).setAttribute("cellpadding","0" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(161)).setAttribute("nombre","lblLinea" );
      ((Element)v.get(161)).setAttribute("alto","13" );
      ((Element)v.get(161)).setAttribute("filas","1" );
      ((Element)v.get(161)).setAttribute("valor","" );
      ((Element)v.get(161)).setAttribute("id","datosTitle" );
      ((Element)v.get(161)).setAttribute("cod","1091" );
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
      ((Element)v.get(165)).setAttribute("nombre","lblSituacion" );
      ((Element)v.get(165)).setAttribute("alto","13" );
      ((Element)v.get(165)).setAttribute("filas","1" );
      ((Element)v.get(165)).setAttribute("valor","" );
      ((Element)v.get(165)).setAttribute("id","datosTitle" );
      ((Element)v.get(165)).setAttribute("cod","695" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","25" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(169)).setAttribute("nombre","lblEstatusProducto" );
      ((Element)v.get(169)).setAttribute("alto","13" );
      ((Element)v.get(169)).setAttribute("filas","1" );
      ((Element)v.get(169)).setAttribute("valor","" );
      ((Element)v.get(169)).setAttribute("id","datosTitle" );
      ((Element)v.get(169)).setAttribute("cod","1077" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).setAttribute("width","100%" );
      ((Element)v.get(157)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","8" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:157   */

      /* Empieza nodo:172 / Elemento padre: 156   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(156)).appendChild((Element)v.get(172));

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
      ((Element)v.get(175)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(172)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(176)).setAttribute("nombre","cbLinea" );
      ((Element)v.get(176)).setAttribute("id","datosCampos" );
      ((Element)v.get(176)).setAttribute("size","1" );
      ((Element)v.get(176)).setAttribute("multiple","N" );
      ((Element)v.get(176)).setAttribute("req","N" );
      ((Element)v.get(176)).setAttribute("valorinicial","" );
      ((Element)v.get(176)).setAttribute("textoinicial","" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("ROWSET"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:178 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","25" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(172)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(181)).setAttribute("nombre","cbSituacion" );
      ((Element)v.get(181)).setAttribute("id","datosCampos" );
      ((Element)v.get(181)).setAttribute("size","1" );
      ((Element)v.get(181)).setAttribute("multiple","N" );
      ((Element)v.get(181)).setAttribute("req","N" );
      ((Element)v.get(181)).setAttribute("valorinicial","" );
      ((Element)v.get(181)).setAttribute("textoinicial","" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","25" );
      ((Element)v.get(183)).setAttribute("height","8" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(172)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(185)).setAttribute("nombre","cbEstatusProducto" );
      ((Element)v.get(185)).setAttribute("id","datosCampos" );
      ((Element)v.get(185)).setAttribute("size","1" );
      ((Element)v.get(185)).setAttribute("multiple","N" );
      ((Element)v.get(185)).setAttribute("req","N" );
      ((Element)v.get(185)).setAttribute("valorinicial","" );
      ((Element)v.get(185)).setAttribute("textoinicial","" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:187 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).setAttribute("width","100%" );
      ((Element)v.get(172)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:172   */

      /* Empieza nodo:189 / Elemento padre: 156   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(156)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("colspan","4" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","8" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:192 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("table"));
      ((Element)v.get(194)).setAttribute("width","664" );
      ((Element)v.get(194)).setAttribute("border","0" );
      ((Element)v.get(194)).setAttribute("align","left" );
      ((Element)v.get(194)).setAttribute("cellspacing","0" );
      ((Element)v.get(194)).setAttribute("cellpadding","0" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(199)).setAttribute("nombre","lblPrecioCatalogo" );
      ((Element)v.get(199)).setAttribute("alto","13" );
      ((Element)v.get(199)).setAttribute("filas","1" );
      ((Element)v.get(199)).setAttribute("valor","" );
      ((Element)v.get(199)).setAttribute("id","datosTitle" );
      ((Element)v.get(199)).setAttribute("cod","503" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(195)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","25" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(203)).setAttribute("nombre","lblPrecioContable" );
      ((Element)v.get(203)).setAttribute("alto","13" );
      ((Element)v.get(203)).setAttribute("filas","1" );
      ((Element)v.get(203)).setAttribute("valor","" );
      ((Element)v.get(203)).setAttribute("id","datosTitle" );
      ((Element)v.get(203)).setAttribute("cod","974" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).setAttribute("width","100%" );
      ((Element)v.get(195)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","8" );
      ((Element)v.get(205)).setAttribute("height","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:195   */

      /* Empieza nodo:206 / Elemento padre: 194   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(194)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(206)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(210)).setAttribute("nombre","txtPrecioCatalogo" );
      ((Element)v.get(210)).setAttribute("id","datosCampos" );
      ((Element)v.get(210)).setAttribute("max","17" );
      ((Element)v.get(210)).setAttribute("tipo","" );
      ((Element)v.get(210)).setAttribute("onchange","" );
      ((Element)v.get(210)).setAttribute("req","N" );
      ((Element)v.get(210)).setAttribute("size","21" );
      ((Element)v.get(210)).setAttribute("valor","" );
      ((Element)v.get(210)).setAttribute("validacion","" );
      ((Element)v.get(210)).setAttribute("onblur","validaPrecio('txtPrecioCatalogo');" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","25" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(206)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(214)).setAttribute("nombre","txtPrecioContable" );
      ((Element)v.get(214)).setAttribute("id","datosCampos" );
      ((Element)v.get(214)).setAttribute("max","17" );
      ((Element)v.get(214)).setAttribute("tipo","" );
      ((Element)v.get(214)).setAttribute("onchange","" );
      ((Element)v.get(214)).setAttribute("req","N" );
      ((Element)v.get(214)).setAttribute("size","21" );
      ((Element)v.get(214)).setAttribute("valor","" );
      ((Element)v.get(214)).setAttribute("validacion","" );
      ((Element)v.get(214)).setAttribute("onblur","validaPrecio('txtPrecioContable');" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).setAttribute("width","100%" );
      ((Element)v.get(206)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","8" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:206   */

      /* Empieza nodo:217 / Elemento padre: 194   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(194)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).setAttribute("colspan","4" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","8" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:47   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:220 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:40   */

      /* Empieza nodo:222 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("table"));
      ((Element)v.get(227)).setAttribute("width","100%" );
      ((Element)v.get(227)).setAttribute("border","0" );
      ((Element)v.get(227)).setAttribute("align","center" );
      ((Element)v.get(227)).setAttribute("cellspacing","0" );
      ((Element)v.get(227)).setAttribute("cellpadding","0" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).setAttribute("class","botonera" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(230)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(230)).setAttribute("ID","botonContenido" );
      ((Element)v.get(230)).setAttribute("tipo","html" );
      ((Element)v.get(230)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(230)).setAttribute("estado","false" );
      ((Element)v.get(230)).setAttribute("cod","1" );
      ((Element)v.get(230)).setAttribute("ontab","ontabBtnBuscar();" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:231 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","8" );
      ((Element)v.get(232)).setAttribute("height","12" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:222   */

      /* Empieza nodo:233 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).setAttribute("width","12" );
      ((Element)v.get(234)).setAttribute("align","center" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","12" );
      ((Element)v.get(235)).setAttribute("height","12" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).setAttribute("width","750" );
      ((Element)v.get(233)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).setAttribute("width","12" );
      ((Element)v.get(233)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(239)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).setAttribute("width","12" );
      ((Element)v.get(239)).setAttribute("height","1" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:233   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:240 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(240)).setAttribute("nombre","capaLista" );
      ((Element)v.get(240)).setAttribute("alto","350" );
      ((Element)v.get(240)).setAttribute("ancho","100%" );
      ((Element)v.get(240)).setAttribute("colorf","" );
      ((Element)v.get(240)).setAttribute("borde","0" );
      ((Element)v.get(240)).setAttribute("imagenf","" );
      ((Element)v.get(240)).setAttribute("repeat","" );
      ((Element)v.get(240)).setAttribute("padding","" );
      ((Element)v.get(240)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(240)).setAttribute("contravsb","" );
      ((Element)v.get(240)).setAttribute("x","12" );
      ((Element)v.get(240)).setAttribute("y","282" );
      ((Element)v.get(240)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(241)).setAttribute("nombre","listado1" );
      ((Element)v.get(241)).setAttribute("ancho","668" );
      ((Element)v.get(241)).setAttribute("alto","317" );
      ((Element)v.get(241)).setAttribute("x","0" );
      ((Element)v.get(241)).setAttribute("y","0" );
      ((Element)v.get(241)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(241)).setAttribute("msgDebugJS","S" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(242)).setAttribute("precarga","S" );
      ((Element)v.get(242)).setAttribute("conROver","S" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(243)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(243)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(243)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(243)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 242   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(244)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(244)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(244)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(244)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(242)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 242   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(245)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(245)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(242)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:242   */

      /* Empieza nodo:246 / Elemento padre: 241   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(241)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(247)).setAttribute("borde","1" );
      ((Element)v.get(247)).setAttribute("horizDatos","1" );
      ((Element)v.get(247)).setAttribute("horizCabecera","1" );
      ((Element)v.get(247)).setAttribute("vertical","0" );
      ((Element)v.get(247)).setAttribute("horizTitulo","1" );
      ((Element)v.get(247)).setAttribute("horizBase","1" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 246   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(248)).setAttribute("borde","#999999" );
      ((Element)v.get(248)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(248)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(248)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(248)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(248)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(248)).setAttribute("horizBase","#999999" );
      ((Element)v.get(246)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:246   */

      /* Empieza nodo:249 / Elemento padre: 241   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(249)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(249)).setAttribute("alto","22" );
      ((Element)v.get(249)).setAttribute("imgFondo","" );
      ((Element)v.get(249)).setAttribute("cod","00135" );
      ((Element)v.get(249)).setAttribute("ID","datosTitle" );
      ((Element)v.get(241)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 241   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(250)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(250)).setAttribute("alto","22" );
      ((Element)v.get(250)).setAttribute("imgFondo","" );
      ((Element)v.get(241)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 241   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(251)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(251)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(251)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(251)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(251)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(251)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(241)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("ancho","100" );
      ((Element)v.get(252)).setAttribute("minimizable","S" );
      ((Element)v.get(252)).setAttribute("minimizada","N" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(253)).setAttribute("ancho","100" );
      ((Element)v.get(253)).setAttribute("minimizable","S" );
      ((Element)v.get(253)).setAttribute("minimizada","N" );
      ((Element)v.get(253)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(251)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(254)).setAttribute("ancho","100" );
      ((Element)v.get(254)).setAttribute("minimizable","S" );
      ((Element)v.get(254)).setAttribute("minimizada","N" );
      ((Element)v.get(251)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("ancho","100" );
      ((Element)v.get(255)).setAttribute("minimizable","S" );
      ((Element)v.get(255)).setAttribute("minimizada","N" );
      ((Element)v.get(251)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(256)).setAttribute("ancho","100" );
      ((Element)v.get(256)).setAttribute("minimizable","S" );
      ((Element)v.get(256)).setAttribute("minimizada","N" );
      ((Element)v.get(256)).setAttribute("orden","numerico" );
      ((Element)v.get(251)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("ancho","100" );
      ((Element)v.get(257)).setAttribute("minimizable","S" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(257)).setAttribute("minimizada","N" );
      ((Element)v.get(251)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(258)).setAttribute("ancho","100" );
      ((Element)v.get(258)).setAttribute("minimizable","S" );
      ((Element)v.get(258)).setAttribute("minimizada","N" );
      ((Element)v.get(258)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(251)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(259)).setAttribute("ancho","100" );
      ((Element)v.get(259)).setAttribute("minimizable","S" );
      ((Element)v.get(259)).setAttribute("minimizada","N" );
      ((Element)v.get(251)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(260)).setAttribute("ancho","100" );
      ((Element)v.get(260)).setAttribute("minimizable","S" );
      ((Element)v.get(260)).setAttribute("minimizada","N" );
      ((Element)v.get(251)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 251   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(261)).setAttribute("ancho","100" );
      ((Element)v.get(261)).setAttribute("minimizable","S" );
      ((Element)v.get(261)).setAttribute("minimizada","N" );
      ((Element)v.get(261)).setAttribute("orden","numerico" );
      ((Element)v.get(251)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:251   */

      /* Empieza nodo:262 / Elemento padre: 241   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(262)).setAttribute("alto","20" );
      ((Element)v.get(262)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(262)).setAttribute("imgFondo","" );
      ((Element)v.get(262)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(241)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(263)).setAttribute("colFondo","" );
      ((Element)v.get(263)).setAttribute("ID","EstCab" );
      ((Element)v.get(263)).setAttribute("align","center" );
      ((Element)v.get(263)).setAttribute("cod","585" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Elemento padre:263 / Elemento actual: 264   */
      v.add(doc.createTextNode("Cód. SAP"));
      ((Element)v.get(263)).appendChild((Text)v.get(264));

      /* Termina nodo Texto:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("colFondo","" );
      ((Element)v.get(265)).setAttribute("ID","EstCab" );
      ((Element)v.get(265)).setAttribute("cod","1059" );
      ((Element)v.get(262)).appendChild((Element)v.get(265));

      /* Elemento padre:265 / Elemento actual: 266   */
      v.add(doc.createTextNode("Cód. antiguo"));
      ((Element)v.get(265)).appendChild((Text)v.get(266));

      /* Termina nodo Texto:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(267)).setAttribute("colFondo","" );
      ((Element)v.get(267)).setAttribute("ID","EstCab" );
      ((Element)v.get(267)).setAttribute("cod","47" );
      ((Element)v.get(262)).appendChild((Element)v.get(267));

      /* Elemento padre:267 / Elemento actual: 268   */
      v.add(doc.createTextNode("Descripción corta"));
      ((Element)v.get(267)).appendChild((Text)v.get(268));

      /* Termina nodo Texto:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("colFondo","" );
      ((Element)v.get(269)).setAttribute("ID","EstCab" );
      ((Element)v.get(269)).setAttribute("cod","1068" );
      ((Element)v.get(262)).appendChild((Element)v.get(269));

      /* Elemento padre:269 / Elemento actual: 270   */
      v.add(doc.createTextNode("Descripción SAP"));
      ((Element)v.get(269)).appendChild((Text)v.get(270));

      /* Termina nodo Texto:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:271 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(271)).setAttribute("colFondo","" );
      ((Element)v.get(271)).setAttribute("ID","EstCab" );
      ((Element)v.get(271)).setAttribute("cod","2078" );
      ((Element)v.get(262)).appendChild((Element)v.get(271));

      /* Elemento padre:271 / Elemento actual: 272   */
      v.add(doc.createTextNode("Producto/Servicio"));
      ((Element)v.get(271)).appendChild((Text)v.get(272));

      /* Termina nodo Texto:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("colFondo","" );
      ((Element)v.get(273)).setAttribute("ID","EstCab" );
      ((Element)v.get(273)).setAttribute("align","center" );
      ((Element)v.get(273)).setAttribute("cod","2448" );
      ((Element)v.get(262)).appendChild((Element)v.get(273));

      /* Elemento padre:273 / Elemento actual: 274   */
      v.add(doc.createTextNode("Marca producto"));
      ((Element)v.get(273)).appendChild((Text)v.get(274));

      /* Termina nodo Texto:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("colFondo","" );
      ((Element)v.get(275)).setAttribute("ID","EstCab" );
      ((Element)v.get(275)).setAttribute("cod","587" );
      ((Element)v.get(262)).appendChild((Element)v.get(275));

      /* Elemento padre:275 / Elemento actual: 276   */
      v.add(doc.createTextNode("Unidad negocio"));
      ((Element)v.get(275)).appendChild((Text)v.get(276));

      /* Termina nodo Texto:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("colFondo","" );
      ((Element)v.get(277)).setAttribute("ID","EstCab" );
      ((Element)v.get(277)).setAttribute("cod","588" );
      ((Element)v.get(262)).appendChild((Element)v.get(277));

      /* Elemento padre:277 / Elemento actual: 278   */
      v.add(doc.createTextNode("Negocio"));
      ((Element)v.get(277)).appendChild((Text)v.get(278));

      /* Termina nodo Texto:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("colFondo","" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(279)).setAttribute("ID","EstCab" );
      ((Element)v.get(279)).setAttribute("cod","1091" );
      ((Element)v.get(262)).appendChild((Element)v.get(279));

      /* Elemento padre:279 / Elemento actual: 280   */
      v.add(doc.createTextNode("Línea"));
      ((Element)v.get(279)).appendChild((Text)v.get(280));

      /* Termina nodo Texto:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:281 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(281)).setAttribute("colFondo","" );
      ((Element)v.get(281)).setAttribute("ID","EstCab" );
      ((Element)v.get(281)).setAttribute("cod","695" );
      ((Element)v.get(262)).appendChild((Element)v.get(281));

      /* Elemento padre:281 / Elemento actual: 282   */
      v.add(doc.createTextNode("Situación"));
      ((Element)v.get(281)).appendChild((Text)v.get(282));

      /* Termina nodo Texto:282   */
      /* Termina nodo:281   */
      /* Termina nodo:262   */

      /* Empieza nodo:283 / Elemento padre: 241   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(283)).setAttribute("alto","22" );
      ((Element)v.get(283)).setAttribute("accion","" );
      ((Element)v.get(283)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(283)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(283)).setAttribute("maxSel","-1" );
      ((Element)v.get(283)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(283)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(283)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(283)).setAttribute("onLoad","" );
      ((Element)v.get(283)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(241)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("tipo","texto" );
      ((Element)v.get(284)).setAttribute("ID","EstDat" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("tipo","texto" );
      ((Element)v.get(285)).setAttribute("ID","EstDat2" );
      ((Element)v.get(283)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(286)).setAttribute("tipo","texto" );
      ((Element)v.get(286)).setAttribute("ID","EstDat" );
      ((Element)v.get(283)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(287)).setAttribute("tipo","texto" );
      ((Element)v.get(287)).setAttribute("ID","EstDat2" );
      ((Element)v.get(283)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(288)).setAttribute("tipo","texto" );
      ((Element)v.get(288)).setAttribute("ID","EstDat" );
      ((Element)v.get(283)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(289)).setAttribute("tipo","texto" );
      ((Element)v.get(289)).setAttribute("ID","EstDat2" );
      ((Element)v.get(283)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(290)).setAttribute("tipo","texto" );
      ((Element)v.get(290)).setAttribute("ID","EstDat" );
      ((Element)v.get(283)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(291)).setAttribute("tipo","texto" );
      ((Element)v.get(291)).setAttribute("ID","EstDat2" );
      ((Element)v.get(283)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("tipo","texto" );
      ((Element)v.get(292)).setAttribute("ID","EstDat" );
      ((Element)v.get(283)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(293)).setAttribute("tipo","texto" );
      ((Element)v.get(293)).setAttribute("ID","EstDat2" );
      ((Element)v.get(283)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:283   */

      /* Empieza nodo:294 / Elemento padre: 241   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(241)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 241   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(295)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(295)).setAttribute("ancho","726" );
      ((Element)v.get(295)).setAttribute("sep","$" );
      ((Element)v.get(295)).setAttribute("x","0" );
      ((Element)v.get(295)).setAttribute("class","botonera" );
      ((Element)v.get(295)).setAttribute("y","294" );
      ((Element)v.get(295)).setAttribute("control","|" );
      ((Element)v.get(295)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(295)).setAttribute("rowset","" );
      ((Element)v.get(295)).setAttribute("cargainicial","N" );
      ((Element)v.get(295)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(241)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(296)).setAttribute("nombre","ret1" );
      ((Element)v.get(296)).setAttribute("x","37" );
      ((Element)v.get(296)).setAttribute("y","298" );
      ((Element)v.get(296)).setAttribute("ID","botonContenido" );
      ((Element)v.get(296)).setAttribute("img","retroceder_on" );
      ((Element)v.get(296)).setAttribute("tipo","0" );
      ((Element)v.get(296)).setAttribute("estado","false" );
      ((Element)v.get(296)).setAttribute("alt","" );
      ((Element)v.get(296)).setAttribute("codigo","" );
      ((Element)v.get(296)).setAttribute("accion","mipgndo.retroceder();" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 295   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(297)).setAttribute("nombre","ava1" );
      ((Element)v.get(297)).setAttribute("x","52" );
      ((Element)v.get(297)).setAttribute("y","298" );
      ((Element)v.get(297)).setAttribute("ID","botonContenido" );
      ((Element)v.get(297)).setAttribute("img","avanzar_on" );
      ((Element)v.get(297)).setAttribute("tipo","0" );
      ((Element)v.get(297)).setAttribute("estado","false" );
      ((Element)v.get(297)).setAttribute("alt","" );
      ((Element)v.get(297)).setAttribute("codigo","" );
      ((Element)v.get(297)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(295)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:295   */
      /* Termina nodo:241   */

      /* Empieza nodo:298 / Elemento padre: 240   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(298)).setAttribute("nombre","primera1" );
      ((Element)v.get(298)).setAttribute("x","20" );
      ((Element)v.get(298)).setAttribute("y","298" );
      ((Element)v.get(298)).setAttribute("ID","botonContenido" );
      ((Element)v.get(298)).setAttribute("img","primera_on" );
      ((Element)v.get(298)).setAttribute("tipo","-2" );
      ((Element)v.get(298)).setAttribute("estado","false" );
      ((Element)v.get(298)).setAttribute("alt","" );
      ((Element)v.get(298)).setAttribute("codigo","" );
      ((Element)v.get(298)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(240)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 240   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(299)).setAttribute("nombre","separa" );
      ((Element)v.get(299)).setAttribute("x","59" );
      ((Element)v.get(299)).setAttribute("y","294" );
      ((Element)v.get(299)).setAttribute("ID","botonContenido" );
      ((Element)v.get(299)).setAttribute("img","separa_base" );
      ((Element)v.get(299)).setAttribute("tipo","0" );
      ((Element)v.get(299)).setAttribute("estado","false" );
      ((Element)v.get(299)).setAttribute("alt","" );
      ((Element)v.get(299)).setAttribute("codigo","" );
      ((Element)v.get(299)).setAttribute("accion","" );
      ((Element)v.get(240)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 240   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(300)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(300)).setAttribute("x","80" );
      ((Element)v.get(300)).setAttribute("y","295" );
      ((Element)v.get(300)).setAttribute("ID","botonContenido" );
      ((Element)v.get(300)).setAttribute("tipo","html" );
      ((Element)v.get(300)).setAttribute("estado","false" );
      ((Element)v.get(300)).setAttribute("cod","3" );
      ((Element)v.get(300)).setAttribute("onshtab","document.all['btnBuscar'].focus();" );
      ((Element)v.get(300)).setAttribute("ontab","ontabBtnDetalle();" );
      ((Element)v.get(300)).setAttribute("accion","onClickDetalle();" );
      ((Element)v.get(240)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:240   */

      /* Empieza nodo:301 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(301)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(301)).setAttribute("alto","12" );
      ((Element)v.get(301)).setAttribute("ancho","100%" );
      ((Element)v.get(301)).setAttribute("colorf","" );
      ((Element)v.get(301)).setAttribute("borde","0" );
      ((Element)v.get(301)).setAttribute("imagenf","" );
      ((Element)v.get(301)).setAttribute("repeat","" );
      ((Element)v.get(301)).setAttribute("padding","" );
      ((Element)v.get(301)).setAttribute("visibilidad","visible" );
      ((Element)v.get(301)).setAttribute("contravsb","" );
      ((Element)v.get(301)).setAttribute("x","0" );
      ((Element)v.get(301)).setAttribute("y","599" );
      ((Element)v.get(301)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:6   */


   }

}

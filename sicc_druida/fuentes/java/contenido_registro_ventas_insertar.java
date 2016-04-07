
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_registro_ventas_insertar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_registro_ventas_insertar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoad()" );
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
      ((Element)v.get(3)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","ccc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","contenido_registro_ventas_insertar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbEmpresa" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","57" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbTipoImpuesto" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","2613" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtFechaEmision" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","392" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtBaseImponible" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","2614" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtImporteImpuesto" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","2615" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbTipoDocLegal" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","1392" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","txtSerieDocLegal" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("cod","1562" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","txtNumDocLegal" );
      ((Element)v.get(15)).setAttribute("required","true" );
      ((Element)v.get(15)).setAttribute("cod","1421" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","txtDescuento" );
      ((Element)v.get(16)).setAttribute("required","true" );
      ((Element)v.get(16)).setAttribute("cod","341" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","txtBaseImponibleNeto" );
      ((Element)v.get(17)).setAttribute("required","true" );
      ((Element)v.get(17)).setAttribute("cod","3385" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */
      /* Termina nodo:7   */

      /* Empieza nodo:18 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(18)).setAttribute("nombre","Formulario" );
      ((Element)v.get(18)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","idioma" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","pais" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","accion" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","casoUso" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hid_SeparadorMiles" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hid_NumeroDecimales" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hid_SeparadorDecimales" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","cbOidEmpresa" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","cbOidTipoImpuesto" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","cbOidCanal" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","cbOidAcceso" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","cbOidSubAcceso" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","cbOidTipoDocumentoLegal" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","cbOidTipoDocumentoRef" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","numDigitosCodigoCliente" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","baseSinFormato" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","importeSinFormato" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","totalSinFormato" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","estadoRUV" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","oidSeleccionado" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 18   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","coeficienteImp" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","descuentoSinFormato" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 18   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(46)).setAttribute("nombre","capa1" );
      ((Element)v.get(18)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("table"));
      ((Element)v.get(47)).setAttribute("width","100%" );
      ((Element)v.get(47)).setAttribute("border","0" );
      ((Element)v.get(47)).setAttribute("cellspacing","0" );
      ((Element)v.get(47)).setAttribute("cellpadding","0" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("width","12" );
      ((Element)v.get(49)).setAttribute("align","center" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","12" );
      ((Element)v.get(50)).setAttribute("height","12" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("width","750" );
      ((Element)v.get(48)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","12" );
      ((Element)v.get(48)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","12" );
      ((Element)v.get(54)).setAttribute("height","1" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:48   */

      /* Empieza nodo:55 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(60)).setAttribute("class","legend" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(61)).setAttribute("nombre","lblDatosAlta" );
      ((Element)v.get(61)).setAttribute("alto","13" );
      ((Element)v.get(61)).setAttribute("filas","1" );
      ((Element)v.get(61)).setAttribute("id","legend" );
      ((Element)v.get(61)).setAttribute("cod","00127" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 59   */
      v.add(doc.createElement("table"));
      ((Element)v.get(62)).setAttribute("width","100%" );
      ((Element)v.get(62)).setAttribute("border","0" );
      ((Element)v.get(62)).setAttribute("align","center" );
      ((Element)v.get(62)).setAttribute("cellspacing","0" );
      ((Element)v.get(62)).setAttribute("cellpadding","0" );
      ((Element)v.get(59)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("table"));
      ((Element)v.get(65)).setAttribute("width","100%" );
      ((Element)v.get(65)).setAttribute("border","0" );
      ((Element)v.get(65)).setAttribute("align","left" );
      ((Element)v.get(65)).setAttribute("cellspacing","0" );
      ((Element)v.get(65)).setAttribute("cellpadding","0" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("colspan","4" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:69 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(69));

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
      ((Element)v.get(69)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(73)).setAttribute("nombre","lblEmpresa" );
      ((Element)v.get(73)).setAttribute("alto","13" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("id","datosTitle" );
      ((Element)v.get(73)).setAttribute("cod","57" );
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
      ((Element)v.get(69)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(77)).setAttribute("nombre","lblTipoImpuesto" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("filas","1" );
      ((Element)v.get(77)).setAttribute("id","datosTitle" );
      ((Element)v.get(77)).setAttribute("cod","2613" );
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
      ((Element)v.get(69)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(81)).setAttribute("nombre","lblFechaEmision" );
      ((Element)v.get(81)).setAttribute("alto","13" );
      ((Element)v.get(81)).setAttribute("filas","1" );
      ((Element)v.get(81)).setAttribute("id","datosTitle" );
      ((Element)v.get(81)).setAttribute("cod","392" );
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

      /* Empieza nodo:84 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(84)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(88)).setAttribute("nombre","cbEmpresa" );
      ((Element)v.get(88)).setAttribute("id","datosCampos" );
      ((Element)v.get(88)).setAttribute("size","1" );
      ((Element)v.get(88)).setAttribute("multiple","N" );
      ((Element)v.get(88)).setAttribute("disabled","" );
      ((Element)v.get(88)).setAttribute("onshtab","focaliza('Formulario.ckIndicadorTransferenciaGratuita')" );
      ((Element)v.get(88)).setAttribute("req","S" );
      ((Element)v.get(88)).setAttribute("valorinicial","" );
      ((Element)v.get(88)).setAttribute("textoinicial","" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:90 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","25" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(84)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(93)).setAttribute("nombre","cbTipoImpuesto" );
      ((Element)v.get(93)).setAttribute("id","datosCampos" );
      ((Element)v.get(93)).setAttribute("size","1" );
      ((Element)v.get(93)).setAttribute("multiple","N" );
      ((Element)v.get(93)).setAttribute("disabled","" );
      ((Element)v.get(93)).setAttribute("req","S" );
      ((Element)v.get(93)).setAttribute("valorinicial","" );
      ((Element)v.get(93)).setAttribute("textoinicial","" );
      ((Element)v.get(93)).setAttribute("onchange","tipoImpuesto_onChange();" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:95 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","25" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(84)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(98)).setAttribute("nombre","txtFechaEmision" );
      ((Element)v.get(98)).setAttribute("id","datosCampos" );
      ((Element)v.get(98)).setAttribute("max","10" );
      ((Element)v.get(98)).setAttribute("tipo","" );
      ((Element)v.get(98)).setAttribute("onchange","" );
      ((Element)v.get(98)).setAttribute("onblur","comprobarFecha()" );
      ((Element)v.get(98)).setAttribute("req","S" );
      ((Element)v.get(98)).setAttribute("size","12" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(98)).setAttribute("validacion","" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("width","100%" );
      ((Element)v.get(84)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:84   */

      /* Empieza nodo:101 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("colspan","4" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:104 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("table"));
      ((Element)v.get(106)).setAttribute("width","100%" );
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
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("colspan","3" );
      ((Element)v.get(107)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(111)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(111)).setAttribute("alto","13" );
      ((Element)v.get(111)).setAttribute("filas","1" );
      ((Element)v.get(111)).setAttribute("id","datosTitle" );
      ((Element)v.get(111)).setAttribute("cod","263" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","25" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(115)).setAttribute("nombre","lblNombre1" );
      ((Element)v.get(115)).setAttribute("alto","13" );
      ((Element)v.get(115)).setAttribute("filas","1" );
      ((Element)v.get(115)).setAttribute("id","datosTitle" );
      ((Element)v.get(115)).setAttribute("cod","93" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","25" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(119)).setAttribute("nombre","lblNombre2" );
      ((Element)v.get(119)).setAttribute("alto","13" );
      ((Element)v.get(119)).setAttribute("filas","1" );
      ((Element)v.get(119)).setAttribute("id","datosTitle" );
      ((Element)v.get(119)).setAttribute("cod","94" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","100%" );
      ((Element)v.get(107)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:107   */

      /* Empieza nodo:122 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","8" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(122)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(126)).setAttribute("nombre","txtCodCliente" );
      ((Element)v.get(126)).setAttribute("id","datosCampos" );
      ((Element)v.get(126)).setAttribute("max","15" );
      ((Element)v.get(126)).setAttribute("tipo","" );
      ((Element)v.get(126)).setAttribute("onchange","clienteUsuarioLupa();" );
      ((Element)v.get(126)).setAttribute("onblur","textCodClienteOnBlur();" );
      ((Element)v.get(126)).setAttribute("req","N" );
      ((Element)v.get(126)).setAttribute("size","22" );
      ((Element)v.get(126)).setAttribute("valor","" );
      ((Element)v.get(126)).setAttribute("validacion","" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(130)).setAttribute("onclick","accionBTNIMG_BuscarCliente()" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","25" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(122)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(134)).setAttribute("nombre","txtNombre1" );
      ((Element)v.get(134)).setAttribute("id","datosCampos" );
      ((Element)v.get(134)).setAttribute("max","25" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(134)).setAttribute("tipo","" );
      ((Element)v.get(134)).setAttribute("onchange","" );
      ((Element)v.get(134)).setAttribute("req","N" );
      ((Element)v.get(134)).setAttribute("size","38" );
      ((Element)v.get(134)).setAttribute("valor","" );
      ((Element)v.get(134)).setAttribute("validacion","" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","25" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(137)).setAttribute("valign","bottom" );
      ((Element)v.get(122)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(138)).setAttribute("nombre","txtNombre2" );
      ((Element)v.get(138)).setAttribute("id","datosCampos" );
      ((Element)v.get(138)).setAttribute("max","25" );
      ((Element)v.get(138)).setAttribute("tipo","" );
      ((Element)v.get(138)).setAttribute("onchange","" );
      ((Element)v.get(138)).setAttribute("req","N" );
      ((Element)v.get(138)).setAttribute("size","38" );
      ((Element)v.get(138)).setAttribute("valor","" );
      ((Element)v.get(138)).setAttribute("validacion","" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("width","100%" );
      ((Element)v.get(122)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","8" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:122   */

      /* Empieza nodo:141 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("colspan","4" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","8" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:144 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("table"));
      ((Element)v.get(146)).setAttribute("width","100%" );
      ((Element)v.get(146)).setAttribute("border","0" );
      ((Element)v.get(146)).setAttribute("align","left" );
      ((Element)v.get(146)).setAttribute("cellspacing","0" );
      ((Element)v.get(146)).setAttribute("cellpadding","0" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","8" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(151)).setAttribute("nombre","lblApellido1" );
      ((Element)v.get(151)).setAttribute("alto","13" );
      ((Element)v.get(151)).setAttribute("filas","1" );
      ((Element)v.get(151)).setAttribute("id","datosTitle" );
      ((Element)v.get(151)).setAttribute("cod","16" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","25" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(155)).setAttribute("nombre","lblApellido2" );
      ((Element)v.get(155)).setAttribute("alto","13" );
      ((Element)v.get(155)).setAttribute("filas","1" );
      ((Element)v.get(155)).setAttribute("id","datosTitle" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(155)).setAttribute("cod","17" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).setAttribute("width","100%" );
      ((Element)v.get(147)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","8" );
      ((Element)v.get(157)).setAttribute("height","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:147   */

      /* Empieza nodo:158 / Elemento padre: 146   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(146)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","8" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(158)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(162)).setAttribute("nombre","txtApellido1" );
      ((Element)v.get(162)).setAttribute("id","datosCampos" );
      ((Element)v.get(162)).setAttribute("max","25" );
      ((Element)v.get(162)).setAttribute("tipo","" );
      ((Element)v.get(162)).setAttribute("onchange","" );
      ((Element)v.get(162)).setAttribute("req","N" );
      ((Element)v.get(162)).setAttribute("size","38" );
      ((Element)v.get(162)).setAttribute("valor","" );
      ((Element)v.get(162)).setAttribute("validacion","" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","25" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(158)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(166)).setAttribute("nombre","txtApellido2" );
      ((Element)v.get(166)).setAttribute("id","datosCampos" );
      ((Element)v.get(166)).setAttribute("max","25" );
      ((Element)v.get(166)).setAttribute("tipo","" );
      ((Element)v.get(166)).setAttribute("onchange","" );
      ((Element)v.get(166)).setAttribute("req","N" );
      ((Element)v.get(166)).setAttribute("size","38" );
      ((Element)v.get(166)).setAttribute("valor","" );
      ((Element)v.get(166)).setAttribute("validacion","" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("width","100%" );
      ((Element)v.get(158)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:158   */

      /* Empieza nodo:169 / Elemento padre: 146   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(146)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).setAttribute("colspan","4" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","8" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:172 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("table"));
      ((Element)v.get(174)).setAttribute("width","100%" );
      ((Element)v.get(174)).setAttribute("border","0" );
      ((Element)v.get(174)).setAttribute("align","left" );
      ((Element)v.get(174)).setAttribute("cellspacing","0" );
      ((Element)v.get(174)).setAttribute("cellpadding","0" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","8" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(179)).setAttribute("nombre","lblBaseImponible" );
      ((Element)v.get(179)).setAttribute("alto","13" );
      ((Element)v.get(179)).setAttribute("filas","1" );
      ((Element)v.get(179)).setAttribute("id","datosTitle" );
      ((Element)v.get(179)).setAttribute("cod","2614" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","25" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(183)).setAttribute("nombre","lblDescuento" );
      ((Element)v.get(183)).setAttribute("alto","13" );
      ((Element)v.get(183)).setAttribute("filas","1" );
      ((Element)v.get(183)).setAttribute("id","datosTitle" );
      ((Element)v.get(183)).setAttribute("cod","341" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","25" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(187)).setAttribute("nombre","lblBaseImponibleNeto" );
      ((Element)v.get(187)).setAttribute("alto","13" );
      ((Element)v.get(187)).setAttribute("filas","1" );
      ((Element)v.get(187)).setAttribute("id","datosTitle" );
      ((Element)v.get(187)).setAttribute("cod","3385" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","25" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(191)).setAttribute("nombre","lblImporteImpuesto" );
      ((Element)v.get(191)).setAttribute("alto","13" );
      ((Element)v.get(191)).setAttribute("filas","1" );
      ((Element)v.get(191)).setAttribute("id","datosTitle" );
      ((Element)v.get(191)).setAttribute("cod","2615" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","25" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(195)).setAttribute("nombre","lblImporteTotal" );
      ((Element)v.get(195)).setAttribute("alto","13" );
      ((Element)v.get(195)).setAttribute("filas","1" );
      ((Element)v.get(195)).setAttribute("id","datosTitle" );
      ((Element)v.get(195)).setAttribute("cod","1313" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","25" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(199)).setAttribute("nombre","lblCoeficienteImpuesto" );
      ((Element)v.get(199)).setAttribute("alto","13" );
      ((Element)v.get(199)).setAttribute("filas","1" );
      ((Element)v.get(199)).setAttribute("id","datosTitle" );
      ((Element)v.get(199)).setAttribute("cod","2616" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).setAttribute("width","100%" );
      ((Element)v.get(175)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:175   */

      /* Empieza nodo:202 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","8" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(202)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(206)).setAttribute("nombre","txtBaseImponible" );
      ((Element)v.get(206)).setAttribute("id","datosCampos" );
      ((Element)v.get(206)).setAttribute("max","13" );
      ((Element)v.get(206)).setAttribute("tipo","" );
      ((Element)v.get(206)).setAttribute("onchange","" );
      ((Element)v.get(206)).setAttribute("onblur","" );
      ((Element)v.get(206)).setAttribute("req","S" );
      ((Element)v.get(206)).setAttribute("size","20" );
      ((Element)v.get(206)).setAttribute("valor","" );
      ((Element)v.get(206)).setAttribute("validacion","" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","25" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(202)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(210)).setAttribute("nombre","txtDescuento" );
      ((Element)v.get(210)).setAttribute("id","datosCampos" );
      ((Element)v.get(210)).setAttribute("max","13" );
      ((Element)v.get(210)).setAttribute("tipo","" );
      ((Element)v.get(210)).setAttribute("onchange","" );
      ((Element)v.get(210)).setAttribute("req","S" );
      ((Element)v.get(210)).setAttribute("size","20" );
      ((Element)v.get(210)).setAttribute("valor","" );
      ((Element)v.get(210)).setAttribute("onblur","truncar('txtDescuento'); calcularImporteTotal('txtDescuento');" );
      ((Element)v.get(210)).setAttribute("validacion","" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","25" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(202)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(214)).setAttribute("nombre","txtBaseImponibleNeto" );
      ((Element)v.get(214)).setAttribute("id","datosCampos" );
      ((Element)v.get(214)).setAttribute("max","13" );
      ((Element)v.get(214)).setAttribute("tipo","" );
      ((Element)v.get(214)).setAttribute("onchange","" );
      ((Element)v.get(214)).setAttribute("onblur","truncar('txtBaseImponibleNeto'); calcularImporteTotal('txtBaseImponibleNeto');" );
      ((Element)v.get(214)).setAttribute("req","S" );
      ((Element)v.get(214)).setAttribute("size","20" );
      ((Element)v.get(214)).setAttribute("valor","" );
      ((Element)v.get(214)).setAttribute("validacion","" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","25" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(202)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(218)).setAttribute("nombre","txtImporteImpuesto" );
      ((Element)v.get(218)).setAttribute("id","datosCampos" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(218)).setAttribute("max","13" );
      ((Element)v.get(218)).setAttribute("tipo","" );
      ((Element)v.get(218)).setAttribute("onchange","" );
      ((Element)v.get(218)).setAttribute("onblur","truncar('txtImporteImpuesto'); calcularImporteTotal('txtImporteImpuesto');" );
      ((Element)v.get(218)).setAttribute("req","S" );
      ((Element)v.get(218)).setAttribute("size","20" );
      ((Element)v.get(218)).setAttribute("valor","" );
      ((Element)v.get(218)).setAttribute("validacion","" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","25" );
      ((Element)v.get(220)).setAttribute("height","8" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(222)).setAttribute("nombre","lbldtImporteTotal" );
      ((Element)v.get(222)).setAttribute("alto","13" );
      ((Element)v.get(222)).setAttribute("filas","1" );
      ((Element)v.get(222)).setAttribute("id","datosCampos" );
      ((Element)v.get(222)).setAttribute("valor","" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","25" );
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(226)).setAttribute("nombre","lbldtCoeficienteImpuesto" );
      ((Element)v.get(226)).setAttribute("alto","13" );
      ((Element)v.get(226)).setAttribute("filas","1" );
      ((Element)v.get(226)).setAttribute("id","datosCampos" );
      ((Element)v.get(226)).setAttribute("valor","" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).setAttribute("width","100%" );
      ((Element)v.get(202)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","8" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:202   */

      /* Empieza nodo:229 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).setAttribute("colspan","4" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","8" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:232 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("table"));
      ((Element)v.get(234)).setAttribute("width","100%" );
      ((Element)v.get(234)).setAttribute("border","0" );
      ((Element)v.get(234)).setAttribute("align","left" );
      ((Element)v.get(234)).setAttribute("cellspacing","0" );
      ((Element)v.get(234)).setAttribute("cellpadding","0" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","8" );
      ((Element)v.get(237)).setAttribute("height","8" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(239)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(239)).setAttribute("alto","13" );
      ((Element)v.get(239)).setAttribute("filas","1" );
      ((Element)v.get(239)).setAttribute("id","datosTitle" );
      ((Element)v.get(239)).setAttribute("cod","7" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(241)).setAttribute("src","b.gif" );
      ((Element)v.get(241)).setAttribute("width","20" );
      ((Element)v.get(241)).setAttribute("height","8" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(243)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(243)).setAttribute("alto","13" );
      ((Element)v.get(243)).setAttribute("filas","1" );
      ((Element)v.get(243)).setAttribute("id","datosTitle" );
      ((Element)v.get(243)).setAttribute("cod","10" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","20" );
      ((Element)v.get(245)).setAttribute("height","8" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(247)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(247)).setAttribute("alto","13" );
      ((Element)v.get(247)).setAttribute("filas","1" );
      ((Element)v.get(247)).setAttribute("id","datosTitle" );
      ((Element)v.get(247)).setAttribute("cod","122" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).setAttribute("width","100%" );
      ((Element)v.get(235)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","8" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:235   */

      /* Empieza nodo:250 / Elemento padre: 234   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(234)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","8" );
      ((Element)v.get(252)).setAttribute("height","8" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(250)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(254)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(254)).setAttribute("id","datosCampos" );
      ((Element)v.get(254)).setAttribute("size","1" );
      ((Element)v.get(254)).setAttribute("onchange","canal_onChange()" );
      ((Element)v.get(254)).setAttribute("multiple","N" );
      ((Element)v.get(254)).setAttribute("disabled","" );
      ((Element)v.get(254)).setAttribute("req","N" );
      ((Element)v.get(254)).setAttribute("valorinicial","" );
      ((Element)v.get(254)).setAttribute("textoinicial","" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:256 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","25" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(250)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(259)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(259)).setAttribute("id","datosCampos" );
      ((Element)v.get(259)).setAttribute("size","1" );
      ((Element)v.get(259)).setAttribute("onchange","acceso_onChange()" );
      ((Element)v.get(259)).setAttribute("multiple","N" );
      ((Element)v.get(259)).setAttribute("disabled","" );
      ((Element)v.get(259)).setAttribute("req","N" );
      ((Element)v.get(259)).setAttribute("valorinicial","" );
      ((Element)v.get(259)).setAttribute("textoinicial","" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:261 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(262)).setAttribute("width","25" );
      ((Element)v.get(262)).setAttribute("height","8" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(250)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(264)).setAttribute("nombre","cbSubacceso" );
      ((Element)v.get(264)).setAttribute("id","datosCampos" );
      ((Element)v.get(264)).setAttribute("size","1" );
      ((Element)v.get(264)).setAttribute("multiple","N" );
      ((Element)v.get(264)).setAttribute("disabled","" );
      ((Element)v.get(264)).setAttribute("req","N" );
      ((Element)v.get(264)).setAttribute("valorinicial","" );
      ((Element)v.get(264)).setAttribute("textoinicial","" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:266 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).setAttribute("width","100%" );
      ((Element)v.get(250)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(267)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).setAttribute("width","8" );
      ((Element)v.get(267)).setAttribute("height","8" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:250   */

      /* Empieza nodo:268 / Elemento padre: 234   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(234)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).setAttribute("colspan","4" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(270)).setAttribute("src","b.gif" );
      ((Element)v.get(270)).setAttribute("width","8" );
      ((Element)v.get(270)).setAttribute("height","8" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:271 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("td"));
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("table"));
      ((Element)v.get(273)).setAttribute("width","100%" );
      ((Element)v.get(273)).setAttribute("border","0" );
      ((Element)v.get(273)).setAttribute("align","left" );
      ((Element)v.get(273)).setAttribute("cellspacing","0" );
      ((Element)v.get(273)).setAttribute("cellpadding","0" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","8" );
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(278)).setAttribute("nombre","lblPuntoEmision" );
      ((Element)v.get(278)).setAttribute("alto","13" );
      ((Element)v.get(278)).setAttribute("filas","1" );
      ((Element)v.get(278)).setAttribute("id","datosTitle" );
      ((Element)v.get(278)).setAttribute("cod","2617" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","25" );
      ((Element)v.get(280)).setAttribute("height","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:281 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(282)).setAttribute("nombre","lblTipoDocLegal" );
      ((Element)v.get(282)).setAttribute("alto","13" );
      ((Element)v.get(282)).setAttribute("filas","1" );
      ((Element)v.get(282)).setAttribute("id","datosTitle" );
      ((Element)v.get(282)).setAttribute("cod","1392" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","25" );
      ((Element)v.get(284)).setAttribute("height","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(286)).setAttribute("nombre","lblSerieDocLegal" );
      ((Element)v.get(286)).setAttribute("alto","13" );
      ((Element)v.get(286)).setAttribute("filas","1" );
      ((Element)v.get(286)).setAttribute("id","datosTitle" );
      ((Element)v.get(286)).setAttribute("cod","1562" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:287 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).setAttribute("width","25" );
      ((Element)v.get(288)).setAttribute("height","8" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:289 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(290)).setAttribute("nombre","lblNumDocLegal" );
      ((Element)v.get(290)).setAttribute("alto","13" );
      ((Element)v.get(290)).setAttribute("filas","1" );
      ((Element)v.get(290)).setAttribute("id","datosTitle" );
      ((Element)v.get(290)).setAttribute("cod","1421" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:291 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(292)).setAttribute("src","b.gif" );
      ((Element)v.get(292)).setAttribute("width","25" );
      ((Element)v.get(292)).setAttribute("height","8" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:293 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(294)).setAttribute("nombre","lblNumDocLegalFinal" );
      ((Element)v.get(294)).setAttribute("alto","13" );
      ((Element)v.get(294)).setAttribute("filas","1" );
      ((Element)v.get(294)).setAttribute("id","datosTitle" );
      ((Element)v.get(294)).setAttribute("cod","3386" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(295)).setAttribute("width","100%" );
      ((Element)v.get(274)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(296)).setAttribute("width","8" );
      ((Element)v.get(296)).setAttribute("height","8" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */
      /* Termina nodo:274   */

      /* Empieza nodo:297 / Elemento padre: 273   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(273)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(299)).setAttribute("src","b.gif" );
      ((Element)v.get(299)).setAttribute("width","8" );
      ((Element)v.get(299)).setAttribute("height","8" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:300 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(300)).setAttribute("valign","bottom" );
      ((Element)v.get(297)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(301)).setAttribute("nombre","txtPuntoEmision" );
      ((Element)v.get(301)).setAttribute("id","datosCampos" );
      ((Element)v.get(301)).setAttribute("max","5" );
      ((Element)v.get(301)).setAttribute("tipo","" );
      ((Element)v.get(301)).setAttribute("onchange","" );
      ((Element)v.get(301)).setAttribute("req","N" );
      ((Element)v.get(301)).setAttribute("size","7" );
      ((Element)v.get(301)).setAttribute("valor","" );
      ((Element)v.get(301)).setAttribute("validacion","" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:302 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(303)).setAttribute("src","b.gif" );
      ((Element)v.get(303)).setAttribute("width","25" );
      ((Element)v.get(303)).setAttribute("height","8" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:304 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(304)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(297)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(305)).setAttribute("nombre","cbTipoDocLegal" );
      ((Element)v.get(305)).setAttribute("id","datosCampos" );
      ((Element)v.get(305)).setAttribute("size","1" );
      ((Element)v.get(305)).setAttribute("multiple","N" );
      ((Element)v.get(305)).setAttribute("disabled","" );
      ((Element)v.get(305)).setAttribute("req","S" );
      ((Element)v.get(305)).setAttribute("valorinicial","" );
      ((Element)v.get(305)).setAttribute("textoinicial","" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(304)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:307 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(308)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).setAttribute("width","25" );
      ((Element)v.get(308)).setAttribute("height","8" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:309 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(297)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(310)).setAttribute("nombre","txtSerieDocLegal" );
      ((Element)v.get(310)).setAttribute("id","datosCampos" );
      ((Element)v.get(310)).setAttribute("max","10" );
      ((Element)v.get(310)).setAttribute("tipo","" );
      ((Element)v.get(310)).setAttribute("onchange","" );
      ((Element)v.get(310)).setAttribute("req","S" );
      ((Element)v.get(310)).setAttribute("size","15" );
      ((Element)v.get(310)).setAttribute("valor","" );
      ((Element)v.get(310)).setAttribute("validacion","" );
      ((Element)v.get(310)).setAttribute("onblur","soloNumerosSinSeparador('txtSerieDocLegal')" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:311 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("width","25" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(313)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(297)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(314)).setAttribute("nombre","txtNumDocLegal" );
      ((Element)v.get(314)).setAttribute("id","datosCampos" );
      ((Element)v.get(314)).setAttribute("max","10" );
      ((Element)v.get(314)).setAttribute("tipo","" );
      ((Element)v.get(314)).setAttribute("onblur","soloNumerosSinSeparador('txtNumDocLegal')" );
      ((Element)v.get(314)).setAttribute("onchange","" );
      ((Element)v.get(314)).setAttribute("req","S" );
      ((Element)v.get(314)).setAttribute("size","15" );
      ((Element)v.get(314)).setAttribute("valor","" );
      ((Element)v.get(314)).setAttribute("validacion","" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","25" );
      ((Element)v.get(316)).setAttribute("height","8" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(297)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(318)).setAttribute("nombre","txtNumDocLegalFinal" );
      ((Element)v.get(318)).setAttribute("id","datosCampos" );
      ((Element)v.get(318)).setAttribute("max","10" );
      ((Element)v.get(318)).setAttribute("tipo","" );
      ((Element)v.get(318)).setAttribute("onblur","" );
      ((Element)v.get(318)).setAttribute("onchange","" );
      ((Element)v.get(318)).setAttribute("req","N" );
      ((Element)v.get(318)).setAttribute("size","15" );
      ((Element)v.get(318)).setAttribute("valor","" );
      ((Element)v.get(318)).setAttribute("validacion","" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).setAttribute("width","100%" );
      ((Element)v.get(297)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).setAttribute("width","8" );
      ((Element)v.get(320)).setAttribute("height","8" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:297   */

      /* Empieza nodo:321 / Elemento padre: 273   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(273)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(322)).setAttribute("colspan","4" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","8" );
      ((Element)v.get(323)).setAttribute("height","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */
      /* Termina nodo:321   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:324 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("td"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("table"));
      ((Element)v.get(326)).setAttribute("width","100%" );
      ((Element)v.get(326)).setAttribute("border","0" );
      ((Element)v.get(326)).setAttribute("align","left" );
      ((Element)v.get(326)).setAttribute("cellspacing","0" );
      ((Element)v.get(326)).setAttribute("cellpadding","0" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).setAttribute("width","8" );
      ((Element)v.get(329)).setAttribute("height","8" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(331)).setAttribute("nombre","lblNumIdentificacionFiscal" );
      ((Element)v.get(331)).setAttribute("alto","13" );
      ((Element)v.get(331)).setAttribute("filas","1" );
      ((Element)v.get(331)).setAttribute("id","datosTitle" );
      ((Element)v.get(331)).setAttribute("cod","1534" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(333)).setAttribute("src","b.gif" );
      ((Element)v.get(333)).setAttribute("width","25" );
      ((Element)v.get(333)).setAttribute("height","8" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */

      /* Empieza nodo:334 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(335)).setAttribute("nombre","lblNumIdentificacionNacional" );
      ((Element)v.get(335)).setAttribute("alto","13" );
      ((Element)v.get(335)).setAttribute("filas","1" );
      ((Element)v.get(335)).setAttribute("id","datosTitle" );
      ((Element)v.get(335)).setAttribute("cod","2618" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:336 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(336)).setAttribute("width","100%" );
      ((Element)v.get(327)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(337)).setAttribute("src","b.gif" );
      ((Element)v.get(337)).setAttribute("width","8" );
      ((Element)v.get(337)).setAttribute("height","8" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */
      /* Termina nodo:327   */

      /* Empieza nodo:338 / Elemento padre: 326   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(326)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","8" );
      ((Element)v.get(340)).setAttribute("height","8" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(338)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(342)).setAttribute("nombre","txtNumIdentificaionFiscal" );
      ((Element)v.get(342)).setAttribute("id","datosCampos" );
      ((Element)v.get(342)).setAttribute("max","15" );
      ((Element)v.get(342)).setAttribute("tipo","" );
      ((Element)v.get(342)).setAttribute("onchange","" );
      ((Element)v.get(342)).setAttribute("req","N" );
      ((Element)v.get(342)).setAttribute("size","22" );
      ((Element)v.get(342)).setAttribute("valor","" );
      ((Element)v.get(342)).setAttribute("validacion","" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(338)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("width","25" );
      ((Element)v.get(344)).setAttribute("height","8" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(345)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(345)).setAttribute("valign","bottom" );
      ((Element)v.get(338)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(346)).setAttribute("nombre","txtNumIdentificaionNacional" );
      ((Element)v.get(346)).setAttribute("id","datosCampos" );
      ((Element)v.get(346)).setAttribute("max","15" );
      ((Element)v.get(346)).setAttribute("tipo","" );
      ((Element)v.get(346)).setAttribute("onchange","" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(346)).setAttribute("req","N" );
      ((Element)v.get(346)).setAttribute("size","22" );
      ((Element)v.get(346)).setAttribute("valor","" );
      ((Element)v.get(346)).setAttribute("validacion","" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).setAttribute("width","100%" );
      ((Element)v.get(338)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(348)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).setAttribute("width","8" );
      ((Element)v.get(348)).setAttribute("height","8" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */
      /* Termina nodo:338   */

      /* Empieza nodo:349 / Elemento padre: 326   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(326)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(350)).setAttribute("colspan","4" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(351)).setAttribute("src","b.gif" );
      ((Element)v.get(351)).setAttribute("width","8" );
      ((Element)v.get(351)).setAttribute("height","8" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */
      /* Termina nodo:349   */
      /* Termina nodo:326   */
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:352 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("table"));
      ((Element)v.get(354)).setAttribute("width","100%" );
      ((Element)v.get(354)).setAttribute("border","0" );
      ((Element)v.get(354)).setAttribute("align","left" );
      ((Element)v.get(354)).setAttribute("cellspacing","0" );
      ((Element)v.get(354)).setAttribute("cellpadding","0" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).setAttribute("width","8" );
      ((Element)v.get(357)).setAttribute("height","8" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(359)).setAttribute("nombre","lblTipoDocLegalReferencia" );
      ((Element)v.get(359)).setAttribute("alto","13" );
      ((Element)v.get(359)).setAttribute("filas","1" );
      ((Element)v.get(359)).setAttribute("id","datosTitle" );
      ((Element)v.get(359)).setAttribute("cod","2619" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:360 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(361)).setAttribute("src","b.gif" );
      ((Element)v.get(361)).setAttribute("width","25" );
      ((Element)v.get(361)).setAttribute("height","8" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:362 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(363)).setAttribute("nombre","lblSerieDocReferencia" );
      ((Element)v.get(363)).setAttribute("alto","13" );
      ((Element)v.get(363)).setAttribute("filas","1" );
      ((Element)v.get(363)).setAttribute("id","datosTitle" );
      ((Element)v.get(363)).setAttribute("cod","2620" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:364 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(365)).setAttribute("src","b.gif" );
      ((Element)v.get(365)).setAttribute("width","25" );
      ((Element)v.get(365)).setAttribute("height","8" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:366 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(367)).setAttribute("nombre","lblNumDocReferencia" );
      ((Element)v.get(367)).setAttribute("alto","13" );
      ((Element)v.get(367)).setAttribute("filas","1" );
      ((Element)v.get(367)).setAttribute("id","datosTitle" );
      ((Element)v.get(367)).setAttribute("cod","367" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).setAttribute("width","100%" );
      ((Element)v.get(355)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).setAttribute("width","8" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(369)).setAttribute("height","8" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:355   */

      /* Empieza nodo:370 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("td"));
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(372)).setAttribute("src","b.gif" );
      ((Element)v.get(372)).setAttribute("width","8" );
      ((Element)v.get(372)).setAttribute("height","8" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */

      /* Empieza nodo:373 / Elemento padre: 370   */
      v.add(doc.createElement("td"));
      ((Element)v.get(373)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(370)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(374)).setAttribute("nombre","cbTipoDocLegalReferencia" );
      ((Element)v.get(374)).setAttribute("id","datosCampos" );
      ((Element)v.get(374)).setAttribute("size","1" );
      ((Element)v.get(374)).setAttribute("disabled","" );
      ((Element)v.get(374)).setAttribute("multiple","N" );
      ((Element)v.get(374)).setAttribute("req","N" );
      ((Element)v.get(374)).setAttribute("valorinicial","" );
      ((Element)v.get(374)).setAttribute("textoinicial","" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:376 / Elemento padre: 370   */
      v.add(doc.createElement("td"));
      ((Element)v.get(370)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(377)).setAttribute("src","b.gif" );
      ((Element)v.get(377)).setAttribute("width","25" );
      ((Element)v.get(377)).setAttribute("height","8" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:378 / Elemento padre: 370   */
      v.add(doc.createElement("td"));
      ((Element)v.get(378)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(370)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(379)).setAttribute("nombre","txtSerieDocReferencia" );
      ((Element)v.get(379)).setAttribute("id","datosCampos" );
      ((Element)v.get(379)).setAttribute("max","10" );
      ((Element)v.get(379)).setAttribute("tipo","" );
      ((Element)v.get(379)).setAttribute("onchange","" );
      ((Element)v.get(379)).setAttribute("req","N" );
      ((Element)v.get(379)).setAttribute("size","15" );
      ((Element)v.get(379)).setAttribute("valor","" );
      ((Element)v.get(379)).setAttribute("validacion","" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:380 / Elemento padre: 370   */
      v.add(doc.createElement("td"));
      ((Element)v.get(370)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(381)).setAttribute("src","b.gif" );
      ((Element)v.get(381)).setAttribute("width","25" );
      ((Element)v.get(381)).setAttribute("height","8" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:382 / Elemento padre: 370   */
      v.add(doc.createElement("td"));
      ((Element)v.get(382)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(370)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(383)).setAttribute("nombre","txtNumDocReferencia" );
      ((Element)v.get(383)).setAttribute("id","datosCampos" );
      ((Element)v.get(383)).setAttribute("max","10" );
      ((Element)v.get(383)).setAttribute("tipo","" );
      ((Element)v.get(383)).setAttribute("onblur","soloNumerosSinSeparador('txtNumDocReferencia')" );
      ((Element)v.get(383)).setAttribute("onchange","" );
      ((Element)v.get(383)).setAttribute("req","N" );
      ((Element)v.get(383)).setAttribute("size","15" );
      ((Element)v.get(383)).setAttribute("valor","" );
      ((Element)v.get(383)).setAttribute("validacion","" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:384 / Elemento padre: 370   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).setAttribute("width","100%" );
      ((Element)v.get(370)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(385)).setAttribute("width","8" );
      ((Element)v.get(385)).setAttribute("height","8" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */
      /* Termina nodo:370   */

      /* Empieza nodo:386 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).setAttribute("colspan","4" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(388)).setAttribute("src","b.gif" );
      ((Element)v.get(388)).setAttribute("width","8" );
      ((Element)v.get(388)).setAttribute("height","8" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */
      /* Termina nodo:387   */
      /* Termina nodo:386   */
      /* Termina nodo:354   */
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:389 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("td"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(389)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("table"));
      ((Element)v.get(391)).setAttribute("width","100%" );
      ((Element)v.get(391)).setAttribute("border","0" );
      ((Element)v.get(391)).setAttribute("align","left" );
      ((Element)v.get(391)).setAttribute("cellspacing","0" );
      ((Element)v.get(391)).setAttribute("cellpadding","0" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(394)).setAttribute("src","b.gif" );
      ((Element)v.get(394)).setAttribute("width","8" );
      ((Element)v.get(394)).setAttribute("height","8" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(396)).setAttribute("nombre","lblEstadoAnulado" );
      ((Element)v.get(396)).setAttribute("alto","13" );
      ((Element)v.get(396)).setAttribute("filas","1" );
      ((Element)v.get(396)).setAttribute("id","datosTitle" );
      ((Element)v.get(396)).setAttribute("cod","2621" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */

      /* Empieza nodo:397 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(398)).setAttribute("src","b.gif" );
      ((Element)v.get(398)).setAttribute("width","25" );
      ((Element)v.get(398)).setAttribute("height","8" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:399 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(400)).setAttribute("nombre","lblIndicadorTransferenciaGratuita" );
      ((Element)v.get(400)).setAttribute("alto","13" );
      ((Element)v.get(400)).setAttribute("filas","1" );
      ((Element)v.get(400)).setAttribute("id","datosTitle" );
      ((Element)v.get(400)).setAttribute("cod","2622" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:401 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(402)).setAttribute("src","b.gif" );
      ((Element)v.get(402)).setAttribute("width","25" );
      ((Element)v.get(402)).setAttribute("height","8" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */

      /* Empieza nodo:403 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(404)).setAttribute("nombre","lblEstadoRUV" );
      ((Element)v.get(404)).setAttribute("alto","13" );
      ((Element)v.get(404)).setAttribute("filas","1" );
      ((Element)v.get(404)).setAttribute("id","datosTitle" );
      ((Element)v.get(404)).setAttribute("cod","2623" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:405 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).setAttribute("width","100%" );
      ((Element)v.get(392)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(406)).setAttribute("src","b.gif" );
      ((Element)v.get(406)).setAttribute("width","8" );
      ((Element)v.get(406)).setAttribute("height","8" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */
      /* Termina nodo:392   */

      /* Empieza nodo:407 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("td"));
      ((Element)v.get(407)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(409)).setAttribute("src","b.gif" );
      ((Element)v.get(409)).setAttribute("width","8" );
      ((Element)v.get(409)).setAttribute("height","8" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:408   */

      /* Empieza nodo:410 / Elemento padre: 407   */
      v.add(doc.createElement("td"));
      ((Element)v.get(407)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(411)).setAttribute("nombre","ckEstadoAnulado" );
      ((Element)v.get(411)).setAttribute("id","datosCampos" );
      ((Element)v.get(411)).setAttribute("onclick","" );
      ((Element)v.get(411)).setAttribute("check","N" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */

      /* Empieza nodo:412 / Elemento padre: 407   */
      v.add(doc.createElement("td"));
      ((Element)v.get(407)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(413)).setAttribute("src","b.gif" );
      ((Element)v.get(413)).setAttribute("width","25" );
      ((Element)v.get(413)).setAttribute("height","8" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */

      /* Empieza nodo:414 / Elemento padre: 407   */
   }

   private void getXML1710(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(407)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(415)).setAttribute("nombre","ckIndicadorTransferenciaGratuita" );
      ((Element)v.get(415)).setAttribute("id","datosCampos" );
      ((Element)v.get(415)).setAttribute("ontab","focaliza('Formulario.cbEmpresa')" );
      ((Element)v.get(415)).setAttribute("onclick","" );
      ((Element)v.get(415)).setAttribute("check","N" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */
      /* Termina nodo:414   */

      /* Empieza nodo:416 / Elemento padre: 407   */
      v.add(doc.createElement("td"));
      ((Element)v.get(407)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(417)).setAttribute("src","b.gif" );
      ((Element)v.get(417)).setAttribute("width","25" );
      ((Element)v.get(417)).setAttribute("height","8" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */

      /* Empieza nodo:418 / Elemento padre: 407   */
      v.add(doc.createElement("td"));
      ((Element)v.get(407)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(419)).setAttribute("nombre","lbldtEstadoRUV" );
      ((Element)v.get(419)).setAttribute("alto","13" );
      ((Element)v.get(419)).setAttribute("filas","1" );
      ((Element)v.get(419)).setAttribute("id","datosCampos" );
      ((Element)v.get(419)).setAttribute("valor","" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:420 / Elemento padre: 407   */
      v.add(doc.createElement("td"));
      ((Element)v.get(420)).setAttribute("width","100%" );
      ((Element)v.get(407)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(421)).setAttribute("src","b.gif" );
      ((Element)v.get(421)).setAttribute("width","8" );
      ((Element)v.get(421)).setAttribute("height","8" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */
      /* Termina nodo:407   */

      /* Empieza nodo:422 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("td"));
      ((Element)v.get(423)).setAttribute("colspan","4" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(424)).setAttribute("src","b.gif" );
      ((Element)v.get(424)).setAttribute("width","8" );
      ((Element)v.get(424)).setAttribute("height","8" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:423   */
      /* Termina nodo:422   */
      /* Termina nodo:391   */
      /* Termina nodo:390   */
      /* Termina nodo:389   */
      /* Termina nodo:62   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:425 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(426)).setAttribute("src","b.gif" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:425   */
      /* Termina nodo:55   */

      /* Empieza nodo:427 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("td"));
      ((Element)v.get(428)).setAttribute("width","12" );
      ((Element)v.get(428)).setAttribute("align","center" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(429)).setAttribute("src","b.gif" );
      ((Element)v.get(429)).setAttribute("width","12" );
      ((Element)v.get(429)).setAttribute("height","12" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:428   */

      /* Empieza nodo:430 / Elemento padre: 427   */
      v.add(doc.createElement("td"));
      ((Element)v.get(430)).setAttribute("width","756" );
      ((Element)v.get(427)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(431)).setAttribute("src","b.gif" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:430   */

      /* Empieza nodo:432 / Elemento padre: 427   */
      v.add(doc.createElement("td"));
      ((Element)v.get(432)).setAttribute("width","12" );
      ((Element)v.get(427)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(433)).setAttribute("src","b.gif" );
      ((Element)v.get(433)).setAttribute("width","12" );
      ((Element)v.get(433)).setAttribute("height","1" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:432   */
      /* Termina nodo:427   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:18   */


   }

}

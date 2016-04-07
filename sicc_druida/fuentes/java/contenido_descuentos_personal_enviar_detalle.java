
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_descuentos_personal_enviar_detalle  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_descuentos_personal_enviar_detalle" );
      ((Element)v.get(0)).setAttribute("cod","0891" );
      ((Element)v.get(0)).setAttribute("titulo","Enviar descuentos a personal" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_descuentos_personal_enviar_detalle.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","formulario" );
      ((Element)v.get(5)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","idioma" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","pais" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","casoUso" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","accion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hMarca" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hCanal" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hAcceso" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hOidEstatus" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hEstatus" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hDescripcion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hFechaVencimientoDesde" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hFechaVencimientoHasta" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hNumeroLote" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hNumeroDocumento" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hFechaCreacion" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 5   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","ConstantesINT_ESTADO_PENDIENTE" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","ConstantesINT_ESTADO_ENVIADO" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","ConstantesINT_ESTADO_ANULADO" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","ConstantesINT_ESTADO_CONFIRMADO" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","listaOidClientes" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","listaOidSubTipoClientes" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","listaImporteCalculados" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","listaImportesDescontar" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","listaImportesEnviar" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","listaCodCliente" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","listaTipoCliente" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","listaCodPlanilla" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hid_SeparadorMiles" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hid_NumeroDecimales" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hid_SeparadorDecimales" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 5   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","100%" );
      ((Element)v.get(40)).setAttribute("border","0" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("cellpadding","0" );
      ((Element)v.get(5)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(42)).setAttribute("align","center" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","12" );
      ((Element)v.get(43)).setAttribute("height","12" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(44)).setAttribute("width","750" );
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("width","12" );
      ((Element)v.get(41)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","12" );
      ((Element)v.get(47)).setAttribute("height","1" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:41   */

      /* Empieza nodo:48 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(53)).setAttribute("class","legend" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(54)).setAttribute("nombre","lblDatosCabecera" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(54)).setAttribute("id","legend" );
      ((Element)v.get(54)).setAttribute("cod","00156" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 52   */
      v.add(doc.createElement("table"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(55)).setAttribute("border","0" );
      ((Element)v.get(55)).setAttribute("align","center" );
      ((Element)v.get(55)).setAttribute("cellspacing","0" );
      ((Element)v.get(55)).setAttribute("cellpadding","0" );
      ((Element)v.get(52)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("table"));
      ((Element)v.get(58)).setAttribute("width","690" );
      ((Element)v.get(58)).setAttribute("border","0" );
      ((Element)v.get(58)).setAttribute("align","left" );
      ((Element)v.get(58)).setAttribute("cellspacing","0" );
      ((Element)v.get(58)).setAttribute("cellpadding","0" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("colspan","4" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","8" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:62 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(62));

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
      ((Element)v.get(62)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(66)).setAttribute("nombre","lblNumeroDocumento" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("filas","1" );
      ((Element)v.get(66)).setAttribute("id","datosTitle" );
      ((Element)v.get(66)).setAttribute("cod","422" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","25" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(70)).setAttribute("nombre","lblLote" );
      ((Element)v.get(70)).setAttribute("alto","13" );
      ((Element)v.get(70)).setAttribute("filas","1" );
      ((Element)v.get(70)).setAttribute("id","datosTitle" );
      ((Element)v.get(70)).setAttribute("cod","680" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","25" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(74)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("filas","1" );
      ((Element)v.get(74)).setAttribute("id","datosTitle" );
      ((Element)v.get(74)).setAttribute("cod","844" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","25" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(78)).setAttribute("nombre","lblFechaCreacion" );
      ((Element)v.get(78)).setAttribute("alto","13" );
      ((Element)v.get(78)).setAttribute("filas","1" );
      ((Element)v.get(78)).setAttribute("id","datosTitle" );
      ((Element)v.get(78)).setAttribute("cod","2770" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","25" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(82)).setAttribute("nombre","lblEstatus" );
      ((Element)v.get(82)).setAttribute("alto","13" );
      ((Element)v.get(82)).setAttribute("filas","1" );
      ((Element)v.get(82)).setAttribute("id","datosTitle" );
      ((Element)v.get(82)).setAttribute("cod","596" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("width","100%" );
      ((Element)v.get(62)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:62   */

      /* Empieza nodo:85 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(85));

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
      ((Element)v.get(89)).setAttribute("nombre","lbldtNumeroDocumento" );
      ((Element)v.get(89)).setAttribute("alto","13" );
      ((Element)v.get(89)).setAttribute("filas","1" );
      ((Element)v.get(89)).setAttribute("id","datosCampos" );
      ((Element)v.get(89)).setAttribute("valor","" );
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
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(93)).setAttribute("nombre","lbldtLote" );
      ((Element)v.get(93)).setAttribute("alto","13" );
      ((Element)v.get(93)).setAttribute("filas","1" );
      ((Element)v.get(93)).setAttribute("id","datosCampos" );
      ((Element)v.get(93)).setAttribute("valor","" );
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
      ((Element)v.get(97)).setAttribute("nombre","lbldtDescripcion" );
      ((Element)v.get(97)).setAttribute("alto","13" );
      ((Element)v.get(97)).setAttribute("filas","1" );
      ((Element)v.get(97)).setAttribute("id","datosCampos" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","25" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(101)).setAttribute("nombre","lbldtFechaCreacion" );
      ((Element)v.get(101)).setAttribute("alto","13" );
      ((Element)v.get(101)).setAttribute("filas","1" );
      ((Element)v.get(101)).setAttribute("id","datosCampos" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","25" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(105)).setAttribute("nombre","lbldtEstatus" );
      ((Element)v.get(105)).setAttribute("alto","13" );
      ((Element)v.get(105)).setAttribute("filas","1" );
      ((Element)v.get(105)).setAttribute("id","datosCampos" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","100%" );
      ((Element)v.get(85)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:85   */

      /* Empieza nodo:108 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("colspan","4" );
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
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:111 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("table"));
      ((Element)v.get(113)).setAttribute("width","690" );
      ((Element)v.get(113)).setAttribute("border","0" );
      ((Element)v.get(113)).setAttribute("align","left" );
      ((Element)v.get(113)).setAttribute("cellspacing","0" );
      ((Element)v.get(113)).setAttribute("cellpadding","0" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(116)).setAttribute("width","8" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(118)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(118)).setAttribute("alto","13" );
      ((Element)v.get(118)).setAttribute("filas","1" );
      ((Element)v.get(118)).setAttribute("id","datosTitle" );
      ((Element)v.get(118)).setAttribute("cod","6" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","25" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(122)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(122)).setAttribute("alto","13" );
      ((Element)v.get(122)).setAttribute("filas","1" );
      ((Element)v.get(122)).setAttribute("id","datosTitle" );
      ((Element)v.get(122)).setAttribute("cod","7" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","25" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(126)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(126)).setAttribute("alto","13" );
      ((Element)v.get(126)).setAttribute("filas","1" );
      ((Element)v.get(126)).setAttribute("id","datosTitle" );
      ((Element)v.get(126)).setAttribute("cod","10" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("width","100%" );
      ((Element)v.get(114)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:114   */

      /* Empieza nodo:129 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","8" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(133)).setAttribute("nombre","lbldtMarca" );
      ((Element)v.get(133)).setAttribute("alto","13" );
      ((Element)v.get(133)).setAttribute("filas","1" );
      ((Element)v.get(133)).setAttribute("id","datosCampos" );
      ((Element)v.get(133)).setAttribute("valor","" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","25" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(137)).setAttribute("nombre","lbldtCanal" );
      ((Element)v.get(137)).setAttribute("alto","13" );
      ((Element)v.get(137)).setAttribute("filas","1" );
      ((Element)v.get(137)).setAttribute("id","datosCampos" );
      ((Element)v.get(137)).setAttribute("valor","" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(139)).setAttribute("width","25" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(141)).setAttribute("nombre","lbldtAcceso" );
      ((Element)v.get(141)).setAttribute("alto","13" );
      ((Element)v.get(141)).setAttribute("filas","1" );
      ((Element)v.get(141)).setAttribute("id","datosCampos" );
      ((Element)v.get(141)).setAttribute("valor","" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("width","100%" );
      ((Element)v.get(129)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","8" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:129   */

      /* Empieza nodo:144 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(144));

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
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:147 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("table"));
      ((Element)v.get(149)).setAttribute("width","690" );
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
      ((Element)v.get(154)).setAttribute("nombre","lblObservaciones" );
      ((Element)v.get(154)).setAttribute("alto","13" );
      ((Element)v.get(154)).setAttribute("filas","1" );
      ((Element)v.get(154)).setAttribute("id","datosTitle" );
      ((Element)v.get(154)).setAttribute("cod","169" );
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
      ((Element)v.get(158)).setAttribute("nombre","lblFechaVencimientoDesde" );
      ((Element)v.get(158)).setAttribute("alto","13" );
      ((Element)v.get(158)).setAttribute("filas","1" );
      ((Element)v.get(158)).setAttribute("id","datosTitle" );
      ((Element)v.get(158)).setAttribute("cod","657" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","25" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(162)).setAttribute("nombre","lblFechaVencimientoHasta" );
      ((Element)v.get(162)).setAttribute("alto","13" );
      ((Element)v.get(162)).setAttribute("filas","1" );
      ((Element)v.get(162)).setAttribute("id","datosTitle" );
      ((Element)v.get(162)).setAttribute("cod","658" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("width","100%" );
      ((Element)v.get(150)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:150   */

      /* Empieza nodo:165 / Elemento padre: 149   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(149)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","8" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(165)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(169)).setAttribute("cols","50" );
      ((Element)v.get(169)).setAttribute("id","datosCampos" );
      ((Element)v.get(169)).setAttribute("msjreq","" );
      ((Element)v.get(169)).setAttribute("nombre","areatxtObservaciones" );
      ((Element)v.get(169)).setAttribute("readonly","S" );
      ((Element)v.get(169)).setAttribute("req","N" );
      ((Element)v.get(169)).setAttribute("rows","3" );
      ((Element)v.get(169)).setAttribute("tabindex","2" );
      ((Element)v.get(169)).setAttribute("valor","" );
      ((Element)v.get(169)).setAttribute("max","256" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","25" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("valign","top" );
      ((Element)v.get(165)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(173)).setAttribute("nombre","lbldtFechaVencimientoDesde" );
      ((Element)v.get(173)).setAttribute("alto","13" );
      ((Element)v.get(173)).setAttribute("filas","1" );
      ((Element)v.get(173)).setAttribute("id","datosCampos" );
      ((Element)v.get(173)).setAttribute("valor","" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","25" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("valign","top" );
      ((Element)v.get(165)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(177)).setAttribute("nombre","lbldtFechaVencimientoHasta" );
      ((Element)v.get(177)).setAttribute("alto","13" );
      ((Element)v.get(177)).setAttribute("filas","1" );
      ((Element)v.get(177)).setAttribute("id","datosCampos" );
      ((Element)v.get(177)).setAttribute("valor","" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).setAttribute("width","100%" );
      ((Element)v.get(165)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:165   */

      /* Empieza nodo:180 / Elemento padre: 149   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(149)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).setAttribute("colspan","4" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","8" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:55   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:183 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:48   */

      /* Empieza nodo:185 / Elemento padre: 40   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).setAttribute("width","12" );
      ((Element)v.get(186)).setAttribute("align","center" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","12" );
      ((Element)v.get(187)).setAttribute("height","12" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).setAttribute("width","756" );
      ((Element)v.get(185)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("width","12" );
      ((Element)v.get(185)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","12" );
      ((Element)v.get(191)).setAttribute("height","1" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:185   */
      /* Termina nodo:40   */

      /* Empieza nodo:192 / Elemento padre: 5   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(192)).setAttribute("nombre","datosDeDetalle" );
      ((Element)v.get(192)).setAttribute("ancho","694" );
      ((Element)v.get(192)).setAttribute("alto","317" );
      ((Element)v.get(192)).setAttribute("x","12" );
      ((Element)v.get(192)).setAttribute("y","193" );
      ((Element)v.get(192)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(192)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(5)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(193)).setAttribute("precarga","S" );
      ((Element)v.get(193)).setAttribute("conROver","S" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(194)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(194)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(194)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(194)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 193   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(195)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(195)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(195)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(195)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(193)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 193   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(196)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(196)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(193)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:193   */

      /* Empieza nodo:197 / Elemento padre: 192   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(192)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(198)).setAttribute("borde","1" );
      ((Element)v.get(198)).setAttribute("horizDatos","1" );
      ((Element)v.get(198)).setAttribute("horizCabecera","1" );
      ((Element)v.get(198)).setAttribute("vertical","1" );
      ((Element)v.get(198)).setAttribute("horizTitulo","1" );
      ((Element)v.get(198)).setAttribute("horizBase","1" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 197   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(199)).setAttribute("borde","#999999" );
      ((Element)v.get(199)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(199)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(199)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(199)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(199)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(199)).setAttribute("horizBase","#999999" );
      ((Element)v.get(197)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:197   */

      /* Empieza nodo:200 / Elemento padre: 192   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(200)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(200)).setAttribute("alto","22" );
      ((Element)v.get(200)).setAttribute("imgFondo","" );
      ((Element)v.get(200)).setAttribute("cod","00133" );
      ((Element)v.get(200)).setAttribute("ID","datosTitle" );
      ((Element)v.get(192)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 192   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(201)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(201)).setAttribute("alto","22" );
      ((Element)v.get(201)).setAttribute("imgFondo","" );
      ((Element)v.get(192)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 192   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(202)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(202)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(202)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(202)).setAttribute("sinSaltoLinea","S" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(202)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(202)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(192)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(203)).setAttribute("ancho","100" );
      ((Element)v.get(203)).setAttribute("minimizable","S" );
      ((Element)v.get(203)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("ancho","100" );
      ((Element)v.get(204)).setAttribute("minimizable","S" );
      ((Element)v.get(204)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(205)).setAttribute("ancho","100" );
      ((Element)v.get(205)).setAttribute("minimizable","S" );
      ((Element)v.get(205)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("ancho","100" );
      ((Element)v.get(206)).setAttribute("minimizable","S" );
      ((Element)v.get(206)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("ancho","100" );
      ((Element)v.get(207)).setAttribute("minimizable","S" );
      ((Element)v.get(207)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("ancho","100" );
      ((Element)v.get(208)).setAttribute("minimizable","S" );
      ((Element)v.get(208)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(209)).setAttribute("ancho","30" );
      ((Element)v.get(209)).setAttribute("minimizable","S" );
      ((Element)v.get(209)).setAttribute("minimizada","N" );
      ((Element)v.get(209)).setAttribute("oculta","S" );
      ((Element)v.get(202)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */

      /* Empieza nodo:210 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("ancho","100" );
      ((Element)v.get(210)).setAttribute("minimizable","S" );
      ((Element)v.get(210)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(211)).setAttribute("ancho","30" );
      ((Element)v.get(211)).setAttribute("minimizable","S" );
      ((Element)v.get(211)).setAttribute("minimizada","N" );
      ((Element)v.get(211)).setAttribute("oculta","S" );
      ((Element)v.get(202)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("ancho","100" );
      ((Element)v.get(212)).setAttribute("minimizable","S" );
      ((Element)v.get(212)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(213)).setAttribute("ancho","150" );
      ((Element)v.get(213)).setAttribute("minimizable","S" );
      ((Element)v.get(213)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("ancho","150" );
      ((Element)v.get(214)).setAttribute("minimizable","S" );
      ((Element)v.get(214)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(215)).setAttribute("ancho","150" );
      ((Element)v.get(215)).setAttribute("minimizable","S" );
      ((Element)v.get(215)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("ancho","180" );
      ((Element)v.get(216)).setAttribute("minimizable","S" );
      ((Element)v.get(216)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("ancho","150" );
      ((Element)v.get(217)).setAttribute("minimizable","S" );
      ((Element)v.get(217)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:202   */

      /* Empieza nodo:218 / Elemento padre: 192   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(218)).setAttribute("alto","20" );
      ((Element)v.get(218)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(218)).setAttribute("imgFondo","" );
      ((Element)v.get(218)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(192)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(219)).setAttribute("colFondo","" );
      ((Element)v.get(219)).setAttribute("ID","EstCab" );
      ((Element)v.get(219)).setAttribute("cod","263" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Elemento padre:219 / Elemento actual: 220   */
      v.add(doc.createTextNode("Cód. cliente"));
      ((Element)v.get(219)).appendChild((Text)v.get(220));

      /* Termina nodo Texto:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(221)).setAttribute("colFondo","" );
      ((Element)v.get(221)).setAttribute("ID","EstCab" );
      ((Element)v.get(221)).setAttribute("cod","93" );
      ((Element)v.get(218)).appendChild((Element)v.get(221));

      /* Elemento padre:221 / Elemento actual: 222   */
      v.add(doc.createTextNode("Nombre 1"));
      ((Element)v.get(221)).appendChild((Text)v.get(222));

      /* Termina nodo Texto:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(223)).setAttribute("colFondo","" );
      ((Element)v.get(223)).setAttribute("ID","EstCab" );
      ((Element)v.get(223)).setAttribute("cod","94" );
      ((Element)v.get(218)).appendChild((Element)v.get(223));

      /* Elemento padre:223 / Elemento actual: 224   */
      v.add(doc.createTextNode("Nombre 2"));
      ((Element)v.get(223)).appendChild((Text)v.get(224));

      /* Termina nodo Texto:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(225)).setAttribute("colFondo","" );
      ((Element)v.get(225)).setAttribute("ID","EstCab" );
      ((Element)v.get(225)).setAttribute("cod","16" );
      ((Element)v.get(218)).appendChild((Element)v.get(225));

      /* Elemento padre:225 / Elemento actual: 226   */
      v.add(doc.createTextNode("Apellido 1"));
      ((Element)v.get(225)).appendChild((Text)v.get(226));

      /* Termina nodo Texto:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("colFondo","" );
      ((Element)v.get(227)).setAttribute("ID","EstCab" );
      ((Element)v.get(227)).setAttribute("cod","17" );
      ((Element)v.get(218)).appendChild((Element)v.get(227));

      /* Elemento padre:227 / Elemento actual: 228   */
      v.add(doc.createTextNode("Apellido 2"));
      ((Element)v.get(227)).appendChild((Text)v.get(228));

      /* Termina nodo Texto:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("colFondo","" );
      ((Element)v.get(229)).setAttribute("ID","EstCab" );
      ((Element)v.get(229)).setAttribute("cod","2750" );
      ((Element)v.get(218)).appendChild((Element)v.get(229));

      /* Elemento padre:229 / Elemento actual: 230   */
      v.add(doc.createTextNode("Cód. planilla"));
      ((Element)v.get(229)).appendChild((Text)v.get(230));

      /* Termina nodo Texto:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("colFondo","" );
      ((Element)v.get(231)).setAttribute("ID","EstCab" );
      ((Element)v.get(218)).appendChild((Element)v.get(231));

      /* Elemento padre:231 / Elemento actual: 232   */
      v.add(doc.createTextNode("oidTipoCliente"));
      ((Element)v.get(231)).appendChild((Text)v.get(232));

      /* Termina nodo Texto:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(233)).setAttribute("colFondo","" );
      ((Element)v.get(233)).setAttribute("ID","EstCab" );
      ((Element)v.get(233)).setAttribute("cod","1869" );
      ((Element)v.get(218)).appendChild((Element)v.get(233));

      /* Elemento padre:233 / Elemento actual: 234   */
      v.add(doc.createTextNode("Tipo cliente"));
      ((Element)v.get(233)).appendChild((Text)v.get(234));

      /* Termina nodo Texto:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(235)).setAttribute("colFondo","" );
      ((Element)v.get(235)).setAttribute("ID","EstCab" );
      ((Element)v.get(218)).appendChild((Element)v.get(235));

      /* Elemento padre:235 / Elemento actual: 236   */
      v.add(doc.createTextNode("oidSubtipoCliente"));
      ((Element)v.get(235)).appendChild((Text)v.get(236));

      /* Termina nodo Texto:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(237)).setAttribute("colFondo","" );
      ((Element)v.get(237)).setAttribute("ID","EstCab" );
      ((Element)v.get(237)).setAttribute("cod","595" );
      ((Element)v.get(218)).appendChild((Element)v.get(237));

      /* Elemento padre:237 / Elemento actual: 238   */
      v.add(doc.createTextNode("Subtipo cliente"));
      ((Element)v.get(237)).appendChild((Text)v.get(238));

      /* Termina nodo Texto:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(239)).setAttribute("colFondo","" );
      ((Element)v.get(239)).setAttribute("ID","EstCab" );
      ((Element)v.get(239)).setAttribute("cod","2751" );
      ((Element)v.get(218)).appendChild((Element)v.get(239));

      /* Elemento padre:239 / Elemento actual: 240   */
      v.add(doc.createTextNode("Línea crédito concedida"));
      ((Element)v.get(239)).appendChild((Text)v.get(240));

      /* Termina nodo Texto:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(241)).setAttribute("colFondo","" );
      ((Element)v.get(241)).setAttribute("ID","EstCab" );
      ((Element)v.get(241)).setAttribute("cod","2752" );
      ((Element)v.get(218)).appendChild((Element)v.get(241));

      /* Elemento padre:241 / Elemento actual: 242   */
      v.add(doc.createTextNode("Línea crédito disponible"));
      ((Element)v.get(241)).appendChild((Text)v.get(242));

      /* Termina nodo Texto:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(243)).setAttribute("colFondo","" );
      ((Element)v.get(243)).setAttribute("ID","EstCab" );
      ((Element)v.get(243)).setAttribute("cod","2753" );
      ((Element)v.get(218)).appendChild((Element)v.get(243));

      /* Elemento padre:243 / Elemento actual: 244   */
      v.add(doc.createTextNode("Importe deuda calculado"));
      ((Element)v.get(243)).appendChild((Text)v.get(244));

      /* Termina nodo Texto:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(245)).setAttribute("colFondo","" );
      ((Element)v.get(245)).setAttribute("ID","EstCab" );
      ((Element)v.get(245)).setAttribute("cod","2754" );
      ((Element)v.get(218)).appendChild((Element)v.get(245));

      /* Elemento padre:245 / Elemento actual: 246   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createTextNode("Importe deuda enviar ADAM"));
      ((Element)v.get(245)).appendChild((Text)v.get(246));

      /* Termina nodo Texto:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(247)).setAttribute("colFondo","" );
      ((Element)v.get(247)).setAttribute("ID","EstCab" );
      ((Element)v.get(247)).setAttribute("cod","2755" );
      ((Element)v.get(218)).appendChild((Element)v.get(247));

      /* Elemento padre:247 / Elemento actual: 248   */
      v.add(doc.createTextNode("Importe deuda descontar"));
      ((Element)v.get(247)).appendChild((Text)v.get(248));

      /* Termina nodo Texto:248   */
      /* Termina nodo:247   */
      /* Termina nodo:218   */

      /* Empieza nodo:249 / Elemento padre: 192   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(249)).setAttribute("alto","22" );
      ((Element)v.get(249)).setAttribute("accion","" );
      ((Element)v.get(249)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(249)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(249)).setAttribute("maxSel","-1" );
      ((Element)v.get(249)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(249)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(249)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(249)).setAttribute("onLoad","" );
      ((Element)v.get(249)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(192)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(250)).setAttribute("tipo","texto" );
      ((Element)v.get(250)).setAttribute("ID","EstDat" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(251)).setAttribute("tipo","texto" );
      ((Element)v.get(251)).setAttribute("ID","EstDat2" );
      ((Element)v.get(249)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("tipo","texto" );
      ((Element)v.get(252)).setAttribute("ID","EstDat" );
      ((Element)v.get(249)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(253)).setAttribute("tipo","texto" );
      ((Element)v.get(253)).setAttribute("ID","EstDat2" );
      ((Element)v.get(249)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(254)).setAttribute("tipo","texto" );
      ((Element)v.get(254)).setAttribute("ID","EstDat" );
      ((Element)v.get(249)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("tipo","texto" );
      ((Element)v.get(255)).setAttribute("ID","EstDat2" );
      ((Element)v.get(249)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(256)).setAttribute("tipo","texto" );
      ((Element)v.get(256)).setAttribute("ID","EstDat" );
      ((Element)v.get(249)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("tipo","texto" );
      ((Element)v.get(257)).setAttribute("ID","EstDat2" );
      ((Element)v.get(249)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(258)).setAttribute("tipo","texto" );
      ((Element)v.get(258)).setAttribute("ID","EstDat" );
      ((Element)v.get(249)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(259)).setAttribute("tipo","texto" );
      ((Element)v.get(259)).setAttribute("ID","EstDat2" );
      ((Element)v.get(249)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(260)).setAttribute("tipo","texto" );
      ((Element)v.get(260)).setAttribute("ID","EstDat" );
      ((Element)v.get(249)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(261)).setAttribute("tipo","texto" );
      ((Element)v.get(261)).setAttribute("ID","EstDat2" );
      ((Element)v.get(249)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */

      /* Empieza nodo:262 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(262)).setAttribute("tipo","texto" );
      ((Element)v.get(262)).setAttribute("ID","EstDat" );
      ((Element)v.get(249)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(263)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(263)).setAttribute("nombre","txtImporteDeudaEnviarADAM" );
      ((Element)v.get(263)).setAttribute("size","18" );
      ((Element)v.get(263)).setAttribute("max","18" );
      ((Element)v.get(263)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(263)).setAttribute("ID","EstDat2" );
      ((Element)v.get(263)).setAttribute("validacion","" );
      ((Element)v.get(263)).setAttribute("onShTab","focalizaAnt(FILAEVENTO, TECLAEVENTO);" );
      ((Element)v.get(263)).setAttribute("onBlur","importeDeudaOnBlurEspera(FILAEVENTO,'txtImporteDeudaEnviarADAM',14);" );
      ((Element)v.get(249)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */

      /* Empieza nodo:264 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(264)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(264)).setAttribute("nombre","txtImporteDeudaDescontar" );
      ((Element)v.get(264)).setAttribute("size","18" );
      ((Element)v.get(264)).setAttribute("max","18" );
      ((Element)v.get(264)).setAttribute("IDOBJ","EstCajaDatForm" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(264)).setAttribute("ID","EstDat" );
      ((Element)v.get(264)).setAttribute("validacion","" );
      ((Element)v.get(264)).setAttribute("onBlur","importeDeudaOnBlur(FILAEVENTO,'txtImporteDeudaDescontar',15);" );
      ((Element)v.get(249)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:249   */

      /* Empieza nodo:265 / Elemento padre: 192   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(192)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 192   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(266)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(266)).setAttribute("ancho","694" );
      ((Element)v.get(266)).setAttribute("sep","$" );
      ((Element)v.get(266)).setAttribute("x","12" );
      ((Element)v.get(266)).setAttribute("class","botonera" );
      ((Element)v.get(266)).setAttribute("y","487" );
      ((Element)v.get(266)).setAttribute("control","|" );
      ((Element)v.get(266)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(266)).setAttribute("rowset","" );
      ((Element)v.get(266)).setAttribute("cargainicial","N" );
      ((Element)v.get(192)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(267)).setAttribute("nombre","ret1" );
      ((Element)v.get(267)).setAttribute("x","37" );
      ((Element)v.get(267)).setAttribute("y","491" );
      ((Element)v.get(267)).setAttribute("ID","botonContenido" );
      ((Element)v.get(267)).setAttribute("img","retroceder_on" );
      ((Element)v.get(267)).setAttribute("tipo","0" );
      ((Element)v.get(267)).setAttribute("estado","false" );
      ((Element)v.get(267)).setAttribute("alt","" );
      ((Element)v.get(267)).setAttribute("codigo","" );
      ((Element)v.get(267)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 266   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(268)).setAttribute("nombre","ava1" );
      ((Element)v.get(268)).setAttribute("x","52" );
      ((Element)v.get(268)).setAttribute("y","491" );
      ((Element)v.get(268)).setAttribute("ID","botonContenido" );
      ((Element)v.get(268)).setAttribute("img","avanzar_on" );
      ((Element)v.get(268)).setAttribute("tipo","0" );
      ((Element)v.get(268)).setAttribute("estado","false" );
      ((Element)v.get(268)).setAttribute("alt","" );
      ((Element)v.get(268)).setAttribute("codigo","" );
      ((Element)v.get(268)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(266)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:266   */
      /* Termina nodo:192   */

      /* Empieza nodo:269 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(269)).setAttribute("nombre","primera1" );
      ((Element)v.get(269)).setAttribute("x","20" );
      ((Element)v.get(269)).setAttribute("y","491" );
      ((Element)v.get(269)).setAttribute("ID","botonContenido" );
      ((Element)v.get(269)).setAttribute("img","primera_on" );
      ((Element)v.get(269)).setAttribute("tipo","-2" );
      ((Element)v.get(269)).setAttribute("estado","false" );
      ((Element)v.get(269)).setAttribute("alt","" );
      ((Element)v.get(269)).setAttribute("codigo","" );
      ((Element)v.get(269)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(5)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(270)).setAttribute("nombre","separa" );
      ((Element)v.get(270)).setAttribute("x","59" );
      ((Element)v.get(270)).setAttribute("y","487" );
      ((Element)v.get(270)).setAttribute("ID","botonContenido" );
      ((Element)v.get(270)).setAttribute("img","separa_base" );
      ((Element)v.get(270)).setAttribute("tipo","0" );
      ((Element)v.get(270)).setAttribute("estado","false" );
      ((Element)v.get(270)).setAttribute("alt","" );
      ((Element)v.get(270)).setAttribute("codigo","" );
      ((Element)v.get(270)).setAttribute("accion","" );
      ((Element)v.get(5)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(271)).setAttribute("nombre","btnGenerarFichero" );
      ((Element)v.get(271)).setAttribute("ontab","gestionaTabBotones('btnGenerarFichero');" );
      ((Element)v.get(271)).setAttribute("x","13" );
      ((Element)v.get(271)).setAttribute("y","488" );
      ((Element)v.get(271)).setAttribute("ID","botonContenido" );
      ((Element)v.get(271)).setAttribute("tipo","html" );
      ((Element)v.get(271)).setAttribute("estado","false" );
      ((Element)v.get(271)).setAttribute("cod","2756" );
      ((Element)v.get(271)).setAttribute("accion","onClickGenerarFichero();" );
      ((Element)v.get(5)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(272)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(272)).setAttribute("ontab","gestionaTabBotones('btnEliminar');" );
      ((Element)v.get(272)).setAttribute("x","128" );
      ((Element)v.get(272)).setAttribute("y","488" );
      ((Element)v.get(272)).setAttribute("ID","botonContenido" );
      ((Element)v.get(272)).setAttribute("tipo","html" );
      ((Element)v.get(272)).setAttribute("estado","false" );
      ((Element)v.get(272)).setAttribute("cod","1254" );
      ((Element)v.get(272)).setAttribute("accion","onClickEliminar();" );
      ((Element)v.get(5)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(273)).setAttribute("nombre","btnGuardarConsulta" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(273)).setAttribute("ontab","gestionaTabBotones('btnGuardarConsulta');" );
      ((Element)v.get(273)).setAttribute("x","183" );
      ((Element)v.get(273)).setAttribute("y","488" );
      ((Element)v.get(273)).setAttribute("ID","botonContenido" );
      ((Element)v.get(273)).setAttribute("tipo","html" );
      ((Element)v.get(273)).setAttribute("estado","false" );
      ((Element)v.get(273)).setAttribute("cod","2758" );
      ((Element)v.get(273)).setAttribute("accion","onClickGuardar();" );
      ((Element)v.get(5)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(274)).setAttribute("nombre","btnAnular" );
      ((Element)v.get(274)).setAttribute("ontab","gestionaTabBotones('btnAnular');" );
      ((Element)v.get(274)).setAttribute("x","310" );
      ((Element)v.get(274)).setAttribute("y","488" );
      ((Element)v.get(274)).setAttribute("ID","botonContenido" );
      ((Element)v.get(274)).setAttribute("tipo","html" );
      ((Element)v.get(274)).setAttribute("estado","false" );
      ((Element)v.get(274)).setAttribute("cod","1598" );
      ((Element)v.get(274)).setAttribute("accion","onClickAnular();" );
      ((Element)v.get(5)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(275)).setAttribute("nombre","btnGenerarDescuento" );
      ((Element)v.get(275)).setAttribute("ontab","gestionaTabBotones('btnGenerarDescuento');" );
      ((Element)v.get(275)).setAttribute("x","359" );
      ((Element)v.get(275)).setAttribute("y","488" );
      ((Element)v.get(275)).setAttribute("ID","botonContenido" );
      ((Element)v.get(275)).setAttribute("tipo","html" );
      ((Element)v.get(275)).setAttribute("estado","false" );
      ((Element)v.get(275)).setAttribute("cod","2811" );
      ((Element)v.get(275)).setAttribute("accion","onClickGenerarDescuentosDeuda();" );
      ((Element)v.get(5)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(276)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(276)).setAttribute("alto","12" );
      ((Element)v.get(276)).setAttribute("ancho","100%" );
      ((Element)v.get(276)).setAttribute("colorf","" );
      ((Element)v.get(276)).setAttribute("borde","0" );
      ((Element)v.get(276)).setAttribute("imagenf","" );
      ((Element)v.get(276)).setAttribute("repeat","" );
      ((Element)v.get(276)).setAttribute("padding","" );
      ((Element)v.get(276)).setAttribute("visibilidad","visible" );
      ((Element)v.get(276)).setAttribute("contravsb","" );
      ((Element)v.get(276)).setAttribute("x","0" );
      ((Element)v.get(276)).setAttribute("y","510" );
      ((Element)v.get(276)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:5   */


   }

}

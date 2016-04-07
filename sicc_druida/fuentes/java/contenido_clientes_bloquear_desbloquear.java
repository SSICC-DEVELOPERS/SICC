
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_clientes_bloquear_desbloquear  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_clientes_bloquear_desbloquear" );
      ((Element)v.get(0)).setAttribute("cod","0396" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_clientes_bloquear_desbloquear.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","formulario" );
      ((Element)v.get(5)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","accion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","varIdioma" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","varPais" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hLongitudCodCliente" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hOidTipoDocumentoDNI" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hTiposDocumento" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hOidTipoBloqueoElemSeleccionado" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(17)).setAttribute("nombre","capa1" );
      ((Element)v.get(5)).appendChild((Element)v.get(17));

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
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("td"));
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
      ((Element)v.get(32)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(32)).setAttribute("alto","13" );
      ((Element)v.get(32)).setAttribute("filas","1" );
      ((Element)v.get(32)).setAttribute("cod","MMGGlobal.legend.searchcriteria.label" );
      ((Element)v.get(32)).setAttribute("id","legend" );
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
      ((Element)v.get(35)).setAttribute("colspan","4" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","8" );
      ((Element)v.get(36)).setAttribute("height","8" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:37 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","8" );
      ((Element)v.get(39)).setAttribute("height","8" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(41)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(41)).setAttribute("alto","13" );
      ((Element)v.get(41)).setAttribute("filas","1" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(41)).setAttribute("id","datosTitle" );
      ((Element)v.get(41)).setAttribute("cod","263" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","8" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(45)).setAttribute("nombre","lblNombre1" );
      ((Element)v.get(45)).setAttribute("alto","13" );
      ((Element)v.get(45)).setAttribute("filas","1" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(45)).setAttribute("id","datosTitle" );
      ((Element)v.get(45)).setAttribute("cod","93" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","8" );
      ((Element)v.get(47)).setAttribute("height","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(49)).setAttribute("nombre","lblNombre2" );
      ((Element)v.get(49)).setAttribute("alto","13" );
      ((Element)v.get(49)).setAttribute("filas","1" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(49)).setAttribute("id","datosTitle" );
      ((Element)v.get(49)).setAttribute("cod","94" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("width","100%" );
      ((Element)v.get(37)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","8" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:37   */

      /* Empieza nodo:52 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","8" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(52)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(56)).setAttribute("nombre","txtCodCliente" );
      ((Element)v.get(56)).setAttribute("id","datosCampos" );
      ((Element)v.get(56)).setAttribute("max","15" );
      ((Element)v.get(56)).setAttribute("tipo","" );
      ((Element)v.get(56)).setAttribute("onchange","" );
      ((Element)v.get(56)).setAttribute("req","N" );
      ((Element)v.get(56)).setAttribute("size","18" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(56)).setAttribute("onblur","onBlurTxtCodCliente()" );
      ((Element)v.get(56)).setAttribute("validacion","" );
      ((Element)v.get(56)).setAttribute("ontab","onTab('txtCodCliente')" );
      ((Element)v.get(56)).setAttribute("onshtab","onShiftTab('txtCodCliente')" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","25" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(52)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(60)).setAttribute("nombre","txtNombre1" );
      ((Element)v.get(60)).setAttribute("id","datosCampos" );
      ((Element)v.get(60)).setAttribute("max","25" );
      ((Element)v.get(60)).setAttribute("tipo","" );
      ((Element)v.get(60)).setAttribute("req","N" );
      ((Element)v.get(60)).setAttribute("size","30" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("validacion","" );
      ((Element)v.get(60)).setAttribute("ontab","onTab('txtNombre1')" );
      ((Element)v.get(60)).setAttribute("onshtab","onShiftTab('txtNombre1')" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","25" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(52)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(64)).setAttribute("nombre","txtNombre2" );
      ((Element)v.get(64)).setAttribute("id","datosCampos" );
      ((Element)v.get(64)).setAttribute("max","25" );
      ((Element)v.get(64)).setAttribute("tipo","" );
      ((Element)v.get(64)).setAttribute("req","N" );
      ((Element)v.get(64)).setAttribute("size","30" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(64)).setAttribute("validacion","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(64)).setAttribute("ontab","onTab('txtNombre2')" );
      ((Element)v.get(64)).setAttribute("onshtab","onShiftTab('txtNombre2')" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","100%" );
      ((Element)v.get(52)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","8" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:52   */

      /* Empieza nodo:67 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("colspan","4" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","8" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:33   */

      /* Empieza nodo:70 / Elemento padre: 30   */
      v.add(doc.createElement("table"));
      ((Element)v.get(70)).setAttribute("width","100%" );
      ((Element)v.get(70)).setAttribute("border","0" );
      ((Element)v.get(70)).setAttribute("align","center" );
      ((Element)v.get(70)).setAttribute("cellspacing","0" );
      ((Element)v.get(70)).setAttribute("cellpadding","0" );
      ((Element)v.get(30)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","8" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(75)).setAttribute("nombre","lblApellido1" );
      ((Element)v.get(75)).setAttribute("alto","13" );
      ((Element)v.get(75)).setAttribute("filas","1" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(75)).setAttribute("id","datosTitle" );
      ((Element)v.get(75)).setAttribute("cod","16" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","25" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(79)).setAttribute("nombre","lblApellido2" );
      ((Element)v.get(79)).setAttribute("alto","13" );
      ((Element)v.get(79)).setAttribute("filas","1" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(79)).setAttribute("id","datosTitle" );
      ((Element)v.get(79)).setAttribute("cod","17" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","25" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(83)).setAttribute("nombre","lblTipoDocumento" );
      ((Element)v.get(83)).setAttribute("alto","13" );
      ((Element)v.get(83)).setAttribute("filas","1" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(83)).setAttribute("id","datosTitle" );
      ((Element)v.get(83)).setAttribute("cod","MaeTipoDocum.codTipoDocu.label" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","25" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(87)).setAttribute("nombre","lblNumeroDocumento" );
      ((Element)v.get(87)).setAttribute("alto","13" );
      ((Element)v.get(87)).setAttribute("filas","1" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(87)).setAttribute("id","datosTitle" );
      ((Element)v.get(87)).setAttribute("cod","422" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("width","100%" );
      ((Element)v.get(71)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:71   */

      /* Empieza nodo:90 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).appendChild((Element)v.get(90));

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
      ((Element)v.get(93)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(90)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(94)).setAttribute("nombre","txtApellido1" );
      ((Element)v.get(94)).setAttribute("id","datosCampos" );
      ((Element)v.get(94)).setAttribute("max","25" );
      ((Element)v.get(94)).setAttribute("tipo","" );
      ((Element)v.get(94)).setAttribute("req","N" );
      ((Element)v.get(94)).setAttribute("size","30" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(94)).setAttribute("validacion","" );
      ((Element)v.get(94)).setAttribute("ontab","onTab('txtApellido1')" );
      ((Element)v.get(94)).setAttribute("onshtab","onShiftTab('txtApellido1')" );
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
      ((Element)v.get(97)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(90)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(98)).setAttribute("nombre","txtApellido2" );
      ((Element)v.get(98)).setAttribute("id","datosCampos" );
      ((Element)v.get(98)).setAttribute("max","25" );
      ((Element)v.get(98)).setAttribute("tipo","" );
      ((Element)v.get(98)).setAttribute("req","N" );
      ((Element)v.get(98)).setAttribute("size","30" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(98)).setAttribute("validacion","" );
      ((Element)v.get(98)).setAttribute("ontab","onTab('txtApellido2')" );
      ((Element)v.get(98)).setAttribute("onshtab","onShiftTab('txtApellido2')" );
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
      ((Element)v.get(101)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(90)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(102)).setAttribute("nombre","cbTipoDocumento" );
      ((Element)v.get(102)).setAttribute("id","datosCampos" );
      ((Element)v.get(102)).setAttribute("size","1" );
      ((Element)v.get(102)).setAttribute("multiple","N" );
      ((Element)v.get(102)).setAttribute("req","N" );
      ((Element)v.get(102)).setAttribute("onchange","" );
      ((Element)v.get(102)).setAttribute("valorinicial","" );
      ((Element)v.get(102)).setAttribute("textoinicial","" );
      ((Element)v.get(102)).setAttribute("ontab","onTab('cbTipoDocumento')" );
      ((Element)v.get(102)).setAttribute("onshtab","onShiftTab('cbTipoDocumento')" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:104 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(105)).setAttribute("width","25" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(90)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(107)).setAttribute("nombre","txtNumeroDocumento" );
      ((Element)v.get(107)).setAttribute("id","datosCampos" );
      ((Element)v.get(107)).setAttribute("max","15" );
      ((Element)v.get(107)).setAttribute("tipo","" );
      ((Element)v.get(107)).setAttribute("req","N" );
      ((Element)v.get(107)).setAttribute("size","18" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(107)).setAttribute("validacion","" );
      ((Element)v.get(107)).setAttribute("ontab","onTab('txtNumeroDocumento')" );
      ((Element)v.get(107)).setAttribute("onshtab","onShiftTab('txtNumeroDocumento')" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","100%" );
      ((Element)v.get(90)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:90   */

      /* Empieza nodo:110 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("colspan","4" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:70   */
      /* Termina nodo:30   */

      /* Empieza nodo:113 / Elemento padre: 29   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(29)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("table"));
      ((Element)v.get(114)).setAttribute("width","100%" );
      ((Element)v.get(114)).setAttribute("border","0" );
      ((Element)v.get(114)).setAttribute("align","center" );
      ((Element)v.get(114)).setAttribute("cellspacing","0" );
      ((Element)v.get(114)).setAttribute("cellpadding","0" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("class","botonera" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(117)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(117)).setAttribute("ID","botonContenido" );
      ((Element)v.get(117)).setAttribute("tipo","html" );
      ((Element)v.get(117)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(117)).setAttribute("estado","false" );
      ((Element)v.get(117)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:29   */
      /* Termina nodo:26   */
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:118 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(118)).setAttribute("nombre","capaLista" );
      ((Element)v.get(118)).setAttribute("ancho","100%" );
      ((Element)v.get(118)).setAttribute("alto","330" );
      ((Element)v.get(118)).setAttribute("x","5" );
      ((Element)v.get(118)).setAttribute("y","180" );
      ((Element)v.get(118)).setAttribute("colorf","" );
      ((Element)v.get(118)).setAttribute("borde","0" );
      ((Element)v.get(118)).setAttribute("imagenf","" );
      ((Element)v.get(118)).setAttribute("repeat","" );
      ((Element)v.get(118)).setAttribute("padding","" );
      ((Element)v.get(118)).setAttribute("visibilidad","" );
      ((Element)v.get(118)).setAttribute("contravsb","" );
      ((Element)v.get(118)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(119)).setAttribute("nombre","listado1" );
      ((Element)v.get(119)).setAttribute("ancho","369" );
      ((Element)v.get(119)).setAttribute("alto","301" );
      ((Element)v.get(119)).setAttribute("x","12" );
      ((Element)v.get(119)).setAttribute("y","0" );
      ((Element)v.get(119)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(119)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(120)).setAttribute("precarga","S" );
      ((Element)v.get(120)).setAttribute("conROver","S" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(121)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(121)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(121)).setAttribute("seleccionado","btnLista2M.gif" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(121)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 120   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(122)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(122)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(122)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(122)).setAttribute("aximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(120)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 120   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(123)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(123)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(120)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:120   */

      /* Empieza nodo:124 / Elemento padre: 119   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(119)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(125)).setAttribute("borde","1" );
      ((Element)v.get(125)).setAttribute("horizDatos","1" );
      ((Element)v.get(125)).setAttribute("horizCabecera","1" );
      ((Element)v.get(125)).setAttribute("vertical","1" );
      ((Element)v.get(125)).setAttribute("horizTitulo","1" );
      ((Element)v.get(125)).setAttribute("horizBase","1" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 124   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(126)).setAttribute("borde","#999999" );
      ((Element)v.get(126)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(126)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(126)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(126)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(126)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(126)).setAttribute("horizBase","#999999" );
      ((Element)v.get(124)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:124   */

      /* Empieza nodo:127 / Elemento padre: 119   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(127)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(127)).setAttribute("alto","22" );
      ((Element)v.get(127)).setAttribute("imgFondo","" );
      ((Element)v.get(127)).setAttribute("cod","00135" );
      ((Element)v.get(127)).setAttribute("ID","datosTitle" );
      ((Element)v.get(119)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 119   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(128)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(128)).setAttribute("alto","22" );
      ((Element)v.get(128)).setAttribute("imgFondo","" );
      ((Element)v.get(119)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 119   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(129)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(129)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(129)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(129)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(129)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(129)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(119)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("ancho","50" );
      ((Element)v.get(130)).setAttribute("minimizable","S" );
      ((Element)v.get(130)).setAttribute("minimizada","N" );
      ((Element)v.get(130)).setAttribute("oculta","S" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("ancho","50" );
      ((Element)v.get(131)).setAttribute("minimizable","S" );
      ((Element)v.get(131)).setAttribute("minimizada","N" );
      ((Element)v.get(131)).setAttribute("oculta","S" );
      ((Element)v.get(129)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("ancho","40" );
      ((Element)v.get(132)).setAttribute("minimizable","S" );
      ((Element)v.get(132)).setAttribute("minimizada","N" );
      ((Element)v.get(129)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("ancho","50" );
      ((Element)v.get(133)).setAttribute("minimizable","S" );
      ((Element)v.get(133)).setAttribute("minimizada","N" );
      ((Element)v.get(129)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("ancho","50" );
      ((Element)v.get(134)).setAttribute("minimizable","S" );
      ((Element)v.get(134)).setAttribute("minimizada","N" );
      ((Element)v.get(129)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(135)).setAttribute("ancho","50" );
      ((Element)v.get(135)).setAttribute("minimizable","S" );
      ((Element)v.get(135)).setAttribute("minimizada","N" );
      ((Element)v.get(129)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("ancho","50" );
      ((Element)v.get(136)).setAttribute("minimizable","S" );
      ((Element)v.get(136)).setAttribute("minimizada","N" );
      ((Element)v.get(129)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(137)).setAttribute("ancho","35" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(137)).setAttribute("minimizable","S" );
      ((Element)v.get(137)).setAttribute("minimizada","N" );
      ((Element)v.get(129)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("ancho","65" );
      ((Element)v.get(138)).setAttribute("minimizable","S" );
      ((Element)v.get(138)).setAttribute("minimizada","N" );
      ((Element)v.get(129)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("ancho","50" );
      ((Element)v.get(139)).setAttribute("minimizable","S" );
      ((Element)v.get(139)).setAttribute("minimizada","N" );
      ((Element)v.get(129)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(140)).setAttribute("ancho","50" );
      ((Element)v.get(140)).setAttribute("minimizable","S" );
      ((Element)v.get(140)).setAttribute("minimizada","N" );
      ((Element)v.get(129)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("ancho","50" );
      ((Element)v.get(141)).setAttribute("minimizable","S" );
      ((Element)v.get(141)).setAttribute("minimizada","N" );
      ((Element)v.get(141)).setAttribute("oculta","S" );
      ((Element)v.get(129)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("ancho","50" );
      ((Element)v.get(142)).setAttribute("minimizable","S" );
      ((Element)v.get(142)).setAttribute("minimizada","N" );
      ((Element)v.get(142)).setAttribute("oculta","S" );
      ((Element)v.get(129)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("ancho","50" );
      ((Element)v.get(143)).setAttribute("minimizable","S" );
      ((Element)v.get(143)).setAttribute("minimizada","N" );
      ((Element)v.get(143)).setAttribute("oculta","S" );
      ((Element)v.get(129)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("ancho","50" );
      ((Element)v.get(144)).setAttribute("minimizable","S" );
      ((Element)v.get(144)).setAttribute("minimizada","N" );
      ((Element)v.get(144)).setAttribute("oculta","S" );
      ((Element)v.get(129)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(145)).setAttribute("ancho","50" );
      ((Element)v.get(145)).setAttribute("minimizable","S" );
      ((Element)v.get(145)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).setAttribute("oculta","S" );
      ((Element)v.get(129)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("ancho","50" );
      ((Element)v.get(146)).setAttribute("minimizable","S" );
      ((Element)v.get(146)).setAttribute("minimizada","N" );
      ((Element)v.get(146)).setAttribute("oculta","S" );
      ((Element)v.get(129)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(147)).setAttribute("ancho","50" );
      ((Element)v.get(147)).setAttribute("minimizable","S" );
      ((Element)v.get(147)).setAttribute("minimizada","N" );
      ((Element)v.get(147)).setAttribute("oculta","S" );
      ((Element)v.get(129)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("ancho","50" );
      ((Element)v.get(148)).setAttribute("minimizable","S" );
      ((Element)v.get(148)).setAttribute("minimizada","N" );
      ((Element)v.get(148)).setAttribute("oculta","S" );
      ((Element)v.get(129)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:129   */

      /* Empieza nodo:149 / Elemento padre: 119   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(149)).setAttribute("alto","25" );
      ((Element)v.get(149)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(149)).setAttribute("imgFondo","" );
      ((Element)v.get(149)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(119)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("colFondo","" );
      ((Element)v.get(150)).setAttribute("ID","EstCab" );
      ((Element)v.get(150)).setAttribute("cod","" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Elemento padre:150 / Elemento actual: 151   */
      v.add(doc.createTextNode("OID bloqueo"));
      ((Element)v.get(150)).appendChild((Text)v.get(151));

      /* Termina nodo Texto:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("colFondo","" );
      ((Element)v.get(152)).setAttribute("ID","EstCab" );
      ((Element)v.get(152)).setAttribute("cod","" );
      ((Element)v.get(149)).appendChild((Element)v.get(152));

      /* Elemento padre:152 / Elemento actual: 153   */
      v.add(doc.createTextNode("OID cliente"));
      ((Element)v.get(152)).appendChild((Text)v.get(153));

      /* Termina nodo Texto:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("colFondo","" );
      ((Element)v.get(154)).setAttribute("ID","EstCab" );
      ((Element)v.get(154)).setAttribute("cod","263" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(149)).appendChild((Element)v.get(154));

      /* Elemento padre:154 / Elemento actual: 155   */
      v.add(doc.createTextNode("codigo cliente"));
      ((Element)v.get(154)).appendChild((Text)v.get(155));

      /* Termina nodo Texto:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("colFondo","" );
      ((Element)v.get(156)).setAttribute("ID","EstCab" );
      ((Element)v.get(156)).setAttribute("cod","93" );
      ((Element)v.get(149)).appendChild((Element)v.get(156));

      /* Elemento padre:156 / Elemento actual: 157   */
      v.add(doc.createTextNode("nombre 1"));
      ((Element)v.get(156)).appendChild((Text)v.get(157));

      /* Termina nodo Texto:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("colFondo","" );
      ((Element)v.get(158)).setAttribute("ID","EstCab" );
      ((Element)v.get(158)).setAttribute("cod","94" );
      ((Element)v.get(149)).appendChild((Element)v.get(158));

      /* Elemento padre:158 / Elemento actual: 159   */
      v.add(doc.createTextNode("nombre 2"));
      ((Element)v.get(158)).appendChild((Text)v.get(159));

      /* Termina nodo Texto:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("colFondo","" );
      ((Element)v.get(160)).setAttribute("ID","EstCab" );
      ((Element)v.get(160)).setAttribute("cod","16" );
      ((Element)v.get(149)).appendChild((Element)v.get(160));

      /* Elemento padre:160 / Elemento actual: 161   */
      v.add(doc.createTextNode("apellido 1"));
      ((Element)v.get(160)).appendChild((Text)v.get(161));

      /* Termina nodo Texto:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("colFondo","" );
      ((Element)v.get(162)).setAttribute("ID","EstCab" );
      ((Element)v.get(162)).setAttribute("cod","17" );
      ((Element)v.get(149)).appendChild((Element)v.get(162));

      /* Elemento padre:162 / Elemento actual: 163   */
      v.add(doc.createTextNode("apellido 2"));
      ((Element)v.get(162)).appendChild((Text)v.get(163));

      /* Termina nodo Texto:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("colFondo","" );
      ((Element)v.get(164)).setAttribute("ID","EstCab" );
      ((Element)v.get(164)).setAttribute("cod","1328" );
      ((Element)v.get(149)).appendChild((Element)v.get(164));

      /* Elemento padre:164 / Elemento actual: 165   */
      v.add(doc.createTextNode("bloqueado"));
      ((Element)v.get(164)).appendChild((Text)v.get(165));

      /* Termina nodo Texto:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("colFondo","" );
      ((Element)v.get(166)).setAttribute("ID","EstCab" );
      ((Element)v.get(166)).setAttribute("cod","369" );
      ((Element)v.get(149)).appendChild((Element)v.get(166));

      /* Elemento padre:166 / Elemento actual: 167   */
      v.add(doc.createTextNode("tipo bloqueo"));
      ((Element)v.get(166)).appendChild((Text)v.get(167));

      /* Termina nodo Texto:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("colFondo","" );
      ((Element)v.get(168)).setAttribute("ID","EstCab" );
      ((Element)v.get(168)).setAttribute("cod","3234" );
      ((Element)v.get(149)).appendChild((Element)v.get(168));

      /* Elemento padre:168 / Elemento actual: 169   */
      v.add(doc.createTextNode("fecha bloqueo"));
      ((Element)v.get(168)).appendChild((Text)v.get(169));

      /* Termina nodo Texto:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("colFondo","" );
      ((Element)v.get(170)).setAttribute("ID","EstCab" );
      ((Element)v.get(170)).setAttribute("cod","3235" );
      ((Element)v.get(149)).appendChild((Element)v.get(170));

      /* Elemento padre:170 / Elemento actual: 171   */
      v.add(doc.createTextNode("fecha desbloqueo"));
      ((Element)v.get(170)).appendChild((Text)v.get(171));

      /* Termina nodo Texto:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("colFondo","" );
      ((Element)v.get(172)).setAttribute("ID","EstCab" );
      ((Element)v.get(172)).setAttribute("cod","3235" );
      ((Element)v.get(149)).appendChild((Element)v.get(172));

      /* Elemento padre:172 / Elemento actual: 173   */
      v.add(doc.createTextNode("motivo bloqueo"));
      ((Element)v.get(172)).appendChild((Text)v.get(173));

      /* Termina nodo Texto:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("colFondo","" );
      ((Element)v.get(174)).setAttribute("ID","EstCab" );
      ((Element)v.get(174)).setAttribute("cod","3236" );
      ((Element)v.get(149)).appendChild((Element)v.get(174));

      /* Elemento padre:174 / Elemento actual: 175   */
      v.add(doc.createTextNode("Usuario bloqueo"));
      ((Element)v.get(174)).appendChild((Text)v.get(175));

      /* Termina nodo Texto:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("colFondo","" );
      ((Element)v.get(176)).setAttribute("ID","EstCab" );
      ((Element)v.get(176)).setAttribute("cod","3237" );
      ((Element)v.get(149)).appendChild((Element)v.get(176));

      /* Elemento padre:176 / Elemento actual: 177   */
      v.add(doc.createTextNode("Usuario desbloqueo"));
      ((Element)v.get(176)).appendChild((Text)v.get(177));

      /* Termina nodo Texto:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("colFondo","" );
      ((Element)v.get(178)).setAttribute("ID","EstCab" );
      ((Element)v.get(178)).setAttribute("cod","3238" );
      ((Element)v.get(149)).appendChild((Element)v.get(178));

      /* Elemento padre:178 / Elemento actual: 179   */
      v.add(doc.createTextNode("indicador bloqueo"));
      ((Element)v.get(178)).appendChild((Text)v.get(179));

      /* Termina nodo Texto:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("colFondo","" );
      ((Element)v.get(180)).setAttribute("ID","EstCab" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(180)).setAttribute("cod","3239" );
      ((Element)v.get(149)).appendChild((Element)v.get(180));

      /* Elemento padre:180 / Elemento actual: 181   */
      v.add(doc.createTextNode("indicador desbloqueo"));
      ((Element)v.get(180)).appendChild((Text)v.get(181));

      /* Termina nodo Texto:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("colFondo","" );
      ((Element)v.get(182)).setAttribute("ID","EstCab" );
      ((Element)v.get(182)).setAttribute("cod","3240" );
      ((Element)v.get(149)).appendChild((Element)v.get(182));

      /* Elemento padre:182 / Elemento actual: 183   */
      v.add(doc.createTextNode("obs bloq"));
      ((Element)v.get(182)).appendChild((Text)v.get(183));

      /* Termina nodo Texto:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("colFondo","" );
      ((Element)v.get(184)).setAttribute("ID","EstCab" );
      ((Element)v.get(184)).setAttribute("cod","3241" );
      ((Element)v.get(149)).appendChild((Element)v.get(184));

      /* Elemento padre:184 / Elemento actual: 185   */
      v.add(doc.createTextNode("obs desb"));
      ((Element)v.get(184)).appendChild((Text)v.get(185));

      /* Termina nodo Texto:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("colFondo","" );
      ((Element)v.get(186)).setAttribute("ID","EstCab" );
      ((Element)v.get(186)).setAttribute("cod","" );
      ((Element)v.get(149)).appendChild((Element)v.get(186));

      /* Elemento padre:186 / Elemento actual: 187   */
      v.add(doc.createTextNode("oid tipo bloqueo"));
      ((Element)v.get(186)).appendChild((Text)v.get(187));

      /* Termina nodo Texto:187   */
      /* Termina nodo:186   */
      /* Termina nodo:149   */

      /* Empieza nodo:188 / Elemento padre: 119   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(188)).setAttribute("alto","22" );
      ((Element)v.get(188)).setAttribute("accion","" );
      ((Element)v.get(188)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(188)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(188)).setAttribute("maxSel","1" );
      ((Element)v.get(188)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(188)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(188)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(188)).setAttribute("onLoad","" );
      ((Element)v.get(188)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(119)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("tipo","texto" );
      ((Element)v.get(189)).setAttribute("ID","EstDat2" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("tipo","texto" );
      ((Element)v.get(190)).setAttribute("ID","EstDat" );
      ((Element)v.get(188)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("tipo","texto" );
      ((Element)v.get(191)).setAttribute("ID","EstDat2" );
      ((Element)v.get(188)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("tipo","texto" );
      ((Element)v.get(192)).setAttribute("ID","EstDat" );
      ((Element)v.get(188)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("tipo","texto" );
      ((Element)v.get(193)).setAttribute("ID","EstDat2" );
      ((Element)v.get(188)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("tipo","texto" );
      ((Element)v.get(194)).setAttribute("ID","EstDat" );
      ((Element)v.get(188)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(195)).setAttribute("tipo","texto" );
      ((Element)v.get(195)).setAttribute("ID","EstDat2" );
      ((Element)v.get(188)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(196)).setAttribute("tipo","checkbox" );
      ((Element)v.get(196)).setAttribute("ID","EstDat" );
      ((Element)v.get(196)).setAttribute("deshabilitado","S" );
      ((Element)v.get(188)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(197)).setAttribute("tipo","texto" );
      ((Element)v.get(197)).setAttribute("ID","EstDat2" );
      ((Element)v.get(188)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("tipo","texto" );
      ((Element)v.get(198)).setAttribute("ID","EstDat" );
      ((Element)v.get(188)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(199)).setAttribute("tipo","texto" );
      ((Element)v.get(199)).setAttribute("ID","EstDat2" );
      ((Element)v.get(188)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(200)).setAttribute("tipo","texto" );
      ((Element)v.get(200)).setAttribute("ID","EstDat" );
      ((Element)v.get(188)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(201)).setAttribute("tipo","texto" );
      ((Element)v.get(201)).setAttribute("ID","EstDat2" );
      ((Element)v.get(188)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 188   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(202)).setAttribute("tipo","texto" );
      ((Element)v.get(202)).setAttribute("ID","EstDat" );
      ((Element)v.get(188)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(203)).setAttribute("tipo","texto" );
      ((Element)v.get(203)).setAttribute("ID","EstDat2" );
      ((Element)v.get(188)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("tipo","texto" );
      ((Element)v.get(204)).setAttribute("ID","EstDat" );
      ((Element)v.get(188)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(205)).setAttribute("tipo","texto" );
      ((Element)v.get(205)).setAttribute("ID","EstDat2" );
      ((Element)v.get(188)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("tipo","texto" );
      ((Element)v.get(206)).setAttribute("ID","EstDat" );
      ((Element)v.get(188)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("tipo","texto" );
      ((Element)v.get(207)).setAttribute("ID","EstDat2" );
      ((Element)v.get(188)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:188   */

      /* Empieza nodo:208 / Elemento padre: 119   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(119)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 119   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(209)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(209)).setAttribute("ancho","679" );
      ((Element)v.get(209)).setAttribute("sep","$" );
      ((Element)v.get(209)).setAttribute("x","12" );
      ((Element)v.get(209)).setAttribute("class","botonera" );
      ((Element)v.get(209)).setAttribute("y","294" );
      ((Element)v.get(209)).setAttribute("control","|" );
      ((Element)v.get(209)).setAttribute("conector","ConectorBuscarCargosAbonos" );
      ((Element)v.get(209)).setAttribute("rowset","" );
      ((Element)v.get(209)).setAttribute("cargainicial","N" );
      ((Element)v.get(209)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(119)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(210)).setAttribute("nombre","ret1" );
      ((Element)v.get(210)).setAttribute("x","37" );
      ((Element)v.get(210)).setAttribute("y","282" );
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
      ((Element)v.get(211)).setAttribute("y","282" );
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
      /* Termina nodo:119   */

      /* Empieza nodo:212 / Elemento padre: 118   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(212)).setAttribute("nombre","primera1" );
      ((Element)v.get(212)).setAttribute("x","20" );
      ((Element)v.get(212)).setAttribute("y","282" );
      ((Element)v.get(212)).setAttribute("ID","botonContenido" );
      ((Element)v.get(212)).setAttribute("img","primera_on" );
      ((Element)v.get(212)).setAttribute("tipo","-2" );
      ((Element)v.get(212)).setAttribute("estado","false" );
      ((Element)v.get(212)).setAttribute("alt","" );
      ((Element)v.get(212)).setAttribute("codigo","" );
      ((Element)v.get(212)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(118)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 118   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(213)).setAttribute("nombre","separa" );
      ((Element)v.get(213)).setAttribute("x","59" );
      ((Element)v.get(213)).setAttribute("y","278" );
      ((Element)v.get(213)).setAttribute("ID","botonContenido" );
      ((Element)v.get(213)).setAttribute("img","separa_base" );
      ((Element)v.get(213)).setAttribute("tipo","0" );
      ((Element)v.get(213)).setAttribute("estado","false" );
      ((Element)v.get(213)).setAttribute("alt","" );
      ((Element)v.get(213)).setAttribute("codigo","" );
      ((Element)v.get(213)).setAttribute("accion","" );
      ((Element)v.get(118)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 118   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(214)).setAttribute("nombre","btnBloquear" );
      ((Element)v.get(214)).setAttribute("x","80" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(214)).setAttribute("y","279" );
      ((Element)v.get(214)).setAttribute("ID","botonContenido" );
      ((Element)v.get(214)).setAttribute("tipo","html" );
      ((Element)v.get(214)).setAttribute("estado","false" );
      ((Element)v.get(214)).setAttribute("cod","428" );
      ((Element)v.get(214)).setAttribute("accion","onClickBloquear()" );
      ((Element)v.get(118)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 118   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(215)).setAttribute("nombre","btnConsultaDetalle" );
      ((Element)v.get(215)).setAttribute("x","147" );
      ((Element)v.get(215)).setAttribute("y","279" );
      ((Element)v.get(215)).setAttribute("ID","botonContenido" );
      ((Element)v.get(215)).setAttribute("tipo","html" );
      ((Element)v.get(215)).setAttribute("estado","false" );
      ((Element)v.get(215)).setAttribute("cod","3242" );
      ((Element)v.get(215)).setAttribute("accion","onClickConsultaDetalle();" );
      ((Element)v.get(118)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 118   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(216)).setAttribute("nombre","btnConsultaHistorico" );
      ((Element)v.get(216)).setAttribute("x","264" );
      ((Element)v.get(216)).setAttribute("y","279" );
      ((Element)v.get(216)).setAttribute("ID","botonContenido" );
      ((Element)v.get(216)).setAttribute("tipo","html" );
      ((Element)v.get(216)).setAttribute("estado","false" );
      ((Element)v.get(216)).setAttribute("cod","3243" );
      ((Element)v.get(216)).setAttribute("accion","onClickConsultaHistorico();" );
      ((Element)v.get(118)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 118   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(217)).setAttribute("nombre","btnDesbloquear" );
      ((Element)v.get(217)).setAttribute("x","396" );
      ((Element)v.get(217)).setAttribute("y","279" );
      ((Element)v.get(217)).setAttribute("ID","botonContenido" );
      ((Element)v.get(217)).setAttribute("tipo","html" );
      ((Element)v.get(217)).setAttribute("estado","false" );
      ((Element)v.get(217)).setAttribute("cod","1329" );
      ((Element)v.get(217)).setAttribute("accion","onClickDesbloquear();" );
      ((Element)v.get(118)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:118   */
      /* Termina nodo:5   */


   }

}

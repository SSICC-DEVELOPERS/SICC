
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_parametros_contables_facturacion_insertar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_parametros_contables_facturacion_insertar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );

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
      ((Element)v.get(5)).setAttribute("src","contenido_parametros_contables_facturacion_insertar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","txtCodApunte" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","IntParamContaFactu.codApun.label" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbTipoAsiento" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","IntParamContaFactu.valTipoAsie.label" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbCabecDetalle" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","IntParamContaFactu.valIdenCabeDeta.label" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtDescripcion" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","IntParamContaFactu.valDesc.label" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbCuentaContable" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","IntParamContaFactu.cucoOidCuenCont.label" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbDebeHaber" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","IntParamContaFactu.valIndiDebeHabe.label" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbCodImporte" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","IntParamContaFactu.imcfOidImpoContFact.label" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:6   */

      /* Empieza nodo:14 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(14)).setAttribute("nombre","formulario" );
      ((Element)v.get(14)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","accion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","varPais" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","varIdioma" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hCodApunte" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hTipoAsiento" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hCabecDetalle" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hDescripcion" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hGrupoProductos" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hMarcaProductos" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hNegocio" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hCodSap" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hCuentaContable" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hDebeHaber" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hCodImporte" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hOid" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(35)).setAttribute("nombre","capa1" );
      ((Element)v.get(14)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("table"));
      ((Element)v.get(36)).setAttribute("width","100%" );
      ((Element)v.get(36)).setAttribute("border","0" );
      ((Element)v.get(36)).setAttribute("cellspacing","0" );
      ((Element)v.get(36)).setAttribute("cellpadding","0" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("width","12" );
      ((Element)v.get(38)).setAttribute("align","center" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","12" );
      ((Element)v.get(39)).setAttribute("height","12" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("width","750" );
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(37)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","12" );
      ((Element)v.get(43)).setAttribute("height","1" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:37   */

      /* Empieza nodo:44 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(36)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(49)).setAttribute("class","legend" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(50)).setAttribute("nombre","lblDatosPrincipales" );
      ((Element)v.get(50)).setAttribute("alto","13" );
      ((Element)v.get(50)).setAttribute("filas","1" );
      ((Element)v.get(50)).setAttribute("cod","IntParamContaFactu.legend.label" );
      ((Element)v.get(50)).setAttribute("id","legend" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(51)).setAttribute("width","100%" );
      ((Element)v.get(51)).setAttribute("border","0" );
      ((Element)v.get(51)).setAttribute("align","center" );
      ((Element)v.get(51)).setAttribute("cellspacing","0" );
      ((Element)v.get(51)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("colspan","4" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","8" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:55 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(59)).setAttribute("nombre","lblCodApunte" );
      ((Element)v.get(59)).setAttribute("alto","13" );
      ((Element)v.get(59)).setAttribute("filas","1" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(59)).setAttribute("id","datosTitle" );
      ((Element)v.get(59)).setAttribute("cod","IntParamContaFactu.codApun.label" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("width","100%" );
      ((Element)v.get(55)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","8" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:55   */

      /* Empieza nodo:62 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(62));

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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(66)).setAttribute("nombre","txtCodApunte" );
      ((Element)v.get(66)).setAttribute("id","datosCampos" );
      ((Element)v.get(66)).setAttribute("max","4" );
      ((Element)v.get(66)).setAttribute("tipo","" );
      ((Element)v.get(66)).setAttribute("onchange","" );
      ((Element)v.get(66)).setAttribute("req","S" );
      ((Element)v.get(66)).setAttribute("size","4" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(66)).setAttribute("validacion","" );
      ((Element)v.get(66)).setAttribute("ontab","onTab('txtCodApunte')" );
      ((Element)v.get(66)).setAttribute("onshtab","onShiftTab('txtCodApunte')" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(67)).setAttribute("width","100%" );
      ((Element)v.get(62)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:62   */

      /* Empieza nodo:69 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("colspan","4" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:51   */

      /* Empieza nodo:72 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(72)).setAttribute("width","100%" );
      ((Element)v.get(72)).setAttribute("border","0" );
      ((Element)v.get(72)).setAttribute("align","center" );
      ((Element)v.get(72)).setAttribute("cellspacing","0" );
      ((Element)v.get(72)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","8" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(77)).setAttribute("nombre","lblTipoAsiento" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("filas","1" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(77)).setAttribute("id","datosTitle" );
      ((Element)v.get(77)).setAttribute("cod","IntParamContaFactu.valTipoAsie.label" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","100%" );
      ((Element)v.get(73)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:73   */

      /* Empieza nodo:80 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(84)).setAttribute("nombre","cbTipoAsiento" );
      ((Element)v.get(84)).setAttribute("id","datosCampos" );
      ((Element)v.get(84)).setAttribute("size","1" );
      ((Element)v.get(84)).setAttribute("multiple","N" );
      ((Element)v.get(84)).setAttribute("req","S" );
      ((Element)v.get(84)).setAttribute("valorinicial","" );
      ((Element)v.get(84)).setAttribute("textoinicial","" );
      ((Element)v.get(84)).setAttribute("ontab","onTab('cbTipoAsiento')" );
      ((Element)v.get(84)).setAttribute("onshtab","onShiftTab('cbTipoAsiento')" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:86 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("width","100%" );
      ((Element)v.get(80)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:80   */

      /* Empieza nodo:88 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("colspan","4" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:72   */

      /* Empieza nodo:91 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(91)).setAttribute("width","100%" );
      ((Element)v.get(91)).setAttribute("border","0" );
      ((Element)v.get(91)).setAttribute("align","center" );
      ((Element)v.get(91)).setAttribute("cellspacing","0" );
      ((Element)v.get(91)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

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
      ((Element)v.get(92)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(96)).setAttribute("nombre","lblCabecDetalle" );
      ((Element)v.get(96)).setAttribute("alto","13" );
      ((Element)v.get(96)).setAttribute("filas","1" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(96)).setAttribute("id","datosTitle" );
      ((Element)v.get(96)).setAttribute("cod","IntParamContaFactu.valIdenCabeDeta.label" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("width","100%" );
      ((Element)v.get(92)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","8" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:92   */

      /* Empieza nodo:99 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(91)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(99)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(103)).setAttribute("nombre","cbCabecDetalle" );
      ((Element)v.get(103)).setAttribute("id","datosCampos" );
      ((Element)v.get(103)).setAttribute("size","1" );
      ((Element)v.get(103)).setAttribute("multiple","N" );
      ((Element)v.get(103)).setAttribute("req","S" );
      ((Element)v.get(103)).setAttribute("valorinicial","" );
      ((Element)v.get(103)).setAttribute("textoinicial","" );
      ((Element)v.get(103)).setAttribute("ontab","onTab('cbCabecDetalle')" );
      ((Element)v.get(103)).setAttribute("onshtab","onShiftTab('cbCabecDetalle')" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:105 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("width","100%" );
      ((Element)v.get(99)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:99   */

      /* Empieza nodo:107 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(91)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("colspan","4" );
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
      /* Termina nodo:91   */

      /* Empieza nodo:110 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(110)).setAttribute("width","100%" );
      ((Element)v.get(110)).setAttribute("border","0" );
      ((Element)v.get(110)).setAttribute("align","center" );
      ((Element)v.get(110)).setAttribute("cellspacing","0" );
      ((Element)v.get(110)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
   }

   private void getXML450(Document doc) {
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
      ((Element)v.get(115)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(115)).setAttribute("alto","13" );
      ((Element)v.get(115)).setAttribute("filas","1" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(115)).setAttribute("id","datosTitle" );
      ((Element)v.get(115)).setAttribute("cod","IntParamContaFactu.valDesc.label" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("width","100%" );
      ((Element)v.get(111)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:111   */

      /* Empieza nodo:118 / Elemento padre: 110   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(110)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","8" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(118)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(122)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(122)).setAttribute("id","datosCampos" );
      ((Element)v.get(122)).setAttribute("max","40" );
      ((Element)v.get(122)).setAttribute("tipo","" );
      ((Element)v.get(122)).setAttribute("onchange","" );
      ((Element)v.get(122)).setAttribute("req","S" );
      ((Element)v.get(122)).setAttribute("size","41" );
      ((Element)v.get(122)).setAttribute("valor","" );
      ((Element)v.get(122)).setAttribute("validacion","" );
      ((Element)v.get(122)).setAttribute("ontab","onTab('txtDescripcion')" );
      ((Element)v.get(122)).setAttribute("onshtab","onShiftTab('txtDescripcion')" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("width","100%" );
      ((Element)v.get(118)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","8" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:118   */

      /* Empieza nodo:125 / Elemento padre: 110   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(110)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("colspan","2" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:110   */

      /* Empieza nodo:128 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(128)).setAttribute("width","100%" );
      ((Element)v.get(128)).setAttribute("border","0" );
      ((Element)v.get(128)).setAttribute("align","center" );
      ((Element)v.get(128)).setAttribute("cellspacing","0" );
      ((Element)v.get(128)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));

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
      ((Element)v.get(133)).setAttribute("nombre","lblGrupoProductos" );
      ((Element)v.get(133)).setAttribute("alto","13" );
      ((Element)v.get(133)).setAttribute("filas","1" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(133)).setAttribute("valor","" );
      ((Element)v.get(133)).setAttribute("id","datosTitle" );
      ((Element)v.get(133)).setAttribute("cod","IntParamContaFactu.valGrupArti.label" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("width","100%" );
      ((Element)v.get(129)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:129   */

      /* Empieza nodo:136 / Elemento padre: 128   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(128)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(136)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(140)).setAttribute("nombre","txtGrupoProductos" );
      ((Element)v.get(140)).setAttribute("id","datosCampos" );
      ((Element)v.get(140)).setAttribute("max","9" );
      ((Element)v.get(140)).setAttribute("tipo","" );
      ((Element)v.get(140)).setAttribute("onchange","" );
      ((Element)v.get(140)).setAttribute("req","N" );
      ((Element)v.get(140)).setAttribute("size","9" );
      ((Element)v.get(140)).setAttribute("valor","" );
      ((Element)v.get(140)).setAttribute("validacion","" );
      ((Element)v.get(140)).setAttribute("ontab","onTab('txtGrupoProductos')" );
      ((Element)v.get(140)).setAttribute("onshtab","onShiftTab('txtGrupoProductos')" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(136)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:136   */

      /* Empieza nodo:143 / Elemento padre: 128   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(128)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("colspan","2" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","8" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:128   */

      /* Empieza nodo:146 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(146)).setAttribute("width","100%" );
      ((Element)v.get(146)).setAttribute("border","0" );
      ((Element)v.get(146)).setAttribute("align","center" );
      ((Element)v.get(146)).setAttribute("cellspacing","0" );
      ((Element)v.get(146)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).appendChild((Element)v.get(146));

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
      ((Element)v.get(151)).setAttribute("nombre","lblMarcaProductos" );
      ((Element)v.get(151)).setAttribute("alto","13" );
      ((Element)v.get(151)).setAttribute("filas","1" );
      ((Element)v.get(151)).setAttribute("valor","" );
      ((Element)v.get(151)).setAttribute("id","datosTitle" );
      ((Element)v.get(151)).setAttribute("cod","IntParamContaFactu.maprOidMarcProd.label" );
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
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(155)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(155)).setAttribute("alto","13" );
      ((Element)v.get(155)).setAttribute("filas","1" );
      ((Element)v.get(155)).setAttribute("valor","" );
      ((Element)v.get(155)).setAttribute("id","datosTitle" );
      ((Element)v.get(155)).setAttribute("cod","IntParamContaFactu.negoOidNego.label" );
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
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(162)).setAttribute("nombre","cbMarcaProductos" );
      ((Element)v.get(162)).setAttribute("id","datosCampos" );
      ((Element)v.get(162)).setAttribute("size","1" );
      ((Element)v.get(162)).setAttribute("multiple","N" );
      ((Element)v.get(162)).setAttribute("req","N" );
      ((Element)v.get(162)).setAttribute("valorinicial","" );
      ((Element)v.get(162)).setAttribute("textoinicial","" );
      ((Element)v.get(162)).setAttribute("ontab","onTab('cbMarcaProductos')" );
      ((Element)v.get(162)).setAttribute("onshtab","onShiftTab('cbMarcaProductos')" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:164 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","25" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(158)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(167)).setAttribute("nombre","cbNegocio" );
      ((Element)v.get(167)).setAttribute("id","datosCampos" );
      ((Element)v.get(167)).setAttribute("size","1" );
      ((Element)v.get(167)).setAttribute("multiple","N" );
      ((Element)v.get(167)).setAttribute("req","N" );
      ((Element)v.get(167)).setAttribute("valorinicial","" );
      ((Element)v.get(167)).setAttribute("textoinicial","" );
      ((Element)v.get(167)).setAttribute("ontab","onTab('cbNegocio')" );
      ((Element)v.get(167)).setAttribute("onshtab","onShiftTab('cbNegocio')" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:169 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).setAttribute("width","100%" );
      ((Element)v.get(158)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","8" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:158   */

      /* Empieza nodo:171 / Elemento padre: 146   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(146)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("colspan","4" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","8" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:146   */

      /* Empieza nodo:174 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(174)).setAttribute("width","100%" );
      ((Element)v.get(174)).setAttribute("border","0" );
      ((Element)v.get(174)).setAttribute("align","center" );
      ((Element)v.get(174)).setAttribute("cellspacing","0" );
      ((Element)v.get(174)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","8" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(179)).setAttribute("nombre","lblCodSap" );
      ((Element)v.get(179)).setAttribute("alto","13" );
      ((Element)v.get(179)).setAttribute("filas","1" );
      ((Element)v.get(179)).setAttribute("valor","" );
      ((Element)v.get(179)).setAttribute("id","datosTitle" );
      ((Element)v.get(179)).setAttribute("cod","IntParamContaFactu.prodOidProd.label" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("width","100%" );
      ((Element)v.get(175)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:175   */

      /* Empieza nodo:182 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(182)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(186)).setAttribute("nombre","txtCodSap" );
      ((Element)v.get(186)).setAttribute("id","datosCampos" );
      ((Element)v.get(186)).setAttribute("max","20" );
      ((Element)v.get(186)).setAttribute("tipo","" );
      ((Element)v.get(186)).setAttribute("onchange","" );
      ((Element)v.get(186)).setAttribute("req","N" );
      ((Element)v.get(186)).setAttribute("size","20" );
      ((Element)v.get(186)).setAttribute("valor","" );
      ((Element)v.get(186)).setAttribute("validacion","" );
      ((Element)v.get(186)).setAttribute("ontab","onTab('txtCodSap')" );
      ((Element)v.get(186)).setAttribute("onshtab","onShiftTab('txtCodSap')" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).setAttribute("width","100%" );
      ((Element)v.get(182)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:182   */

      /* Empieza nodo:189 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(189));

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
      /* Termina nodo:174   */

      /* Empieza nodo:192 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(192)).setAttribute("width","100%" );
      ((Element)v.get(192)).setAttribute("border","0" );
      ((Element)v.get(192)).setAttribute("align","center" );
      ((Element)v.get(192)).setAttribute("cellspacing","0" );
      ((Element)v.get(192)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","8" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(197)).setAttribute("nombre","lblCuentaContable" );
      ((Element)v.get(197)).setAttribute("alto","13" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(197)).setAttribute("filas","1" );
      ((Element)v.get(197)).setAttribute("valor","" );
      ((Element)v.get(197)).setAttribute("id","datosTitle" );
      ((Element)v.get(197)).setAttribute("cod","IntParamContaFactu.cucoOidCuenCont.label" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).setAttribute("width","25" );
      ((Element)v.get(199)).setAttribute("height","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(201)).setAttribute("nombre","lblDebeHaber" );
      ((Element)v.get(201)).setAttribute("alto","13" );
      ((Element)v.get(201)).setAttribute("filas","1" );
      ((Element)v.get(201)).setAttribute("valor","" );
      ((Element)v.get(201)).setAttribute("id","datosTitle" );
      ((Element)v.get(201)).setAttribute("cod","IntParamContaFactu.valIndiDebeHabe.label" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).setAttribute("width","100%" );
      ((Element)v.get(193)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","8" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:193   */

      /* Empieza nodo:204 / Elemento padre: 192   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(192)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","8" );
      ((Element)v.get(206)).setAttribute("height","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(204)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(208)).setAttribute("nombre","cbCuentaContable" );
      ((Element)v.get(208)).setAttribute("id","datosCampos" );
      ((Element)v.get(208)).setAttribute("size","1" );
      ((Element)v.get(208)).setAttribute("multiple","N" );
      ((Element)v.get(208)).setAttribute("req","S" );
      ((Element)v.get(208)).setAttribute("valorinicial","" );
      ((Element)v.get(208)).setAttribute("textoinicial","" );
      ((Element)v.get(208)).setAttribute("ontab","onTab('cbCuentaContable')" );
      ((Element)v.get(208)).setAttribute("onshtab","onShiftTab('cbCuentaContable')" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:210 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","25" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(204)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(213)).setAttribute("nombre","cbDebeHaber" );
      ((Element)v.get(213)).setAttribute("id","datosCampos" );
      ((Element)v.get(213)).setAttribute("size","1" );
      ((Element)v.get(213)).setAttribute("multiple","N" );
      ((Element)v.get(213)).setAttribute("req","S" );
      ((Element)v.get(213)).setAttribute("valorinicial","" );
      ((Element)v.get(213)).setAttribute("textoinicial","" );
      ((Element)v.get(213)).setAttribute("ontab","onTab('cbDebeHaber')" );
      ((Element)v.get(213)).setAttribute("onshtab","onShiftTab('cbDebeHaber')" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:215 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).setAttribute("width","100%" );
      ((Element)v.get(204)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","8" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:204   */

      /* Empieza nodo:217 / Elemento padre: 192   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(192)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).setAttribute("colspan","4" );
   }

   private void getXML900(Document doc) {
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
      /* Termina nodo:192   */

      /* Empieza nodo:220 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(220)).setAttribute("width","100%" );
      ((Element)v.get(220)).setAttribute("border","0" );
      ((Element)v.get(220)).setAttribute("align","center" );
      ((Element)v.get(220)).setAttribute("cellspacing","0" );
      ((Element)v.get(220)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","8" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(225)).setAttribute("nombre","lblCodImporte" );
      ((Element)v.get(225)).setAttribute("alto","3" );
      ((Element)v.get(225)).setAttribute("filas","1" );
      ((Element)v.get(225)).setAttribute("valor","" );
      ((Element)v.get(225)).setAttribute("id","datosTitle" );
      ((Element)v.get(225)).setAttribute("cod","IntParamContaFactu.imcfOidImpoContFact.label" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).setAttribute("width","100%" );
      ((Element)v.get(221)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","8" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:221   */

      /* Empieza nodo:228 / Elemento padre: 220   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(220)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","8" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(228)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(232)).setAttribute("nombre","cbCodImporte" );
      ((Element)v.get(232)).setAttribute("id","datosCampos" );
      ((Element)v.get(232)).setAttribute("size","1" );
      ((Element)v.get(232)).setAttribute("multiple","N" );
      ((Element)v.get(232)).setAttribute("req","S" );
      ((Element)v.get(232)).setAttribute("valorinicial","" );
      ((Element)v.get(232)).setAttribute("textoinicial","" );
      ((Element)v.get(232)).setAttribute("ontab","onTab('cbCodImporte')" );
      ((Element)v.get(232)).setAttribute("onshtab","onShiftTab('cbCodImporte')" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:234 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).setAttribute("width","100%" );
      ((Element)v.get(228)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","8" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:228   */

      /* Empieza nodo:236 / Elemento padre: 220   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(220)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).setAttribute("colspan","4" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","8" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:220   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:239 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","8" );
      ((Element)v.get(240)).setAttribute("height","12" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:44   */

      /* Empieza nodo:241 / Elemento padre: 36   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).setAttribute("width","12" );
      ((Element)v.get(242)).setAttribute("align","center" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","12" );
      ((Element)v.get(243)).setAttribute("height","12" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).setAttribute("width","756" );
      ((Element)v.get(241)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).setAttribute("width","12" );
      ((Element)v.get(241)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","12" );
      ((Element)v.get(247)).setAttribute("height","1" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:241   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:14   */


   }

}

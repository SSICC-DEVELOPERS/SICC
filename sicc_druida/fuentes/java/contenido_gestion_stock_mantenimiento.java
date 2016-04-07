
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_gestion_stock_mantenimiento  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML1800(doc);
         

      getXML1890(doc);
         

      getXML1980(doc);
         

      getXML2070(doc);
         

      getXML2160(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_gestion_stock_mantenimiento" );
      ((Element)v.get(0)).setAttribute("cod","0451" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_gestion_stock_mantenimiento.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","cbMarca" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","6" );
      ((Element)v.get(6)).setAttribute("group","GrupoBusqueda" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbCanal" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","7" );
      ((Element)v.get(7)).setAttribute("group","GrupoBusqueda" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbPeriodo" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","276" );
      ((Element)v.get(8)).setAttribute("group","GrupoBusqueda" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtCodigoVentaBuscar" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("cod","336" );
      ((Element)v.get(9)).setAttribute("group","GrupoBusqueda" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtLimiteVenta" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","1428" );
      ((Element)v.get(10)).setAttribute("group","Grupo2" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtControlStock" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","1451" );
      ((Element)v.get(11)).setAttribute("group","Grupo2" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtControlStockPorcentual" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","2338" );
      ((Element)v.get(12)).setAttribute("group","Grupo2" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","chkControlLiquidacion" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","1429" );
      ((Element)v.get(13)).setAttribute("group","Grupo2" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","txtCodigoVenta" );
      ((Element)v.get(14)).setAttribute("required","false" );
      ((Element)v.get(14)).setAttribute("cod","336" );
      ((Element)v.get(14)).setAttribute("group","GrupoCodigoVenta" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","txtCodigoVenta" );
      ((Element)v.get(15)).setAttribute("required","false" );
      ((Element)v.get(15)).setAttribute("cod","336" );
      ((Element)v.get(15)).setAttribute("group","GrupoModificacion" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","cbTipoCliente" );
      ((Element)v.get(16)).setAttribute("required","true" );
      ((Element)v.get(16)).setAttribute("cod","1869" );
      ((Element)v.get(16)).setAttribute("group","GrupoModificacion" );
      ((Element)v.get(5)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 5   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","cbTipoCliente" );
      ((Element)v.get(17)).setAttribute("required","true" );
      ((Element)v.get(17)).setAttribute("cod","1869" );
      ((Element)v.get(17)).setAttribute("group","GrupoAnyadir" );
      ((Element)v.get(5)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(18)).setAttribute("name","txtLimiteVenta" );
      ((Element)v.get(18)).setAttribute("required","false" );
      ((Element)v.get(18)).setAttribute("cod","1428" );
      ((Element)v.get(18)).setAttribute("format","e" );
      ((Element)v.get(18)).setAttribute("min","0" );
      ((Element)v.get(18)).setAttribute("max","9999999999" );
      ((Element)v.get(18)).setAttribute("group","GrupoAnyadir" );
      ((Element)v.get(5)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(19)).setAttribute("name","txtControlStock" );
      ((Element)v.get(19)).setAttribute("required","false" );
      ((Element)v.get(19)).setAttribute("format","e" );
      ((Element)v.get(19)).setAttribute("cod","1451" );
      ((Element)v.get(19)).setAttribute("min","0" );
      ((Element)v.get(19)).setAttribute("max","9999999999" );
      ((Element)v.get(19)).setAttribute("group","GrupoAnyadir" );
      ((Element)v.get(5)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(20)).setAttribute("name","txtControlStockPorcentual" );
      ((Element)v.get(20)).setAttribute("required","false" );
      ((Element)v.get(20)).setAttribute("format","N" );
      ((Element)v.get(20)).setAttribute("cod","2338" );
      ((Element)v.get(20)).setAttribute("min","0" );
      ((Element)v.get(20)).setAttribute("max","999.999" );
      ((Element)v.get(20)).setAttribute("group","GrupoAnyadir" );
      ((Element)v.get(5)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:5   */

      /* Empieza nodo:21 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 0   */
      v.add(doc.createElement("STYLE"));
      ((Element)v.get(22)).setAttribute("TYPE","text/css" );
      ((Element)v.get(0)).appendChild((Element)v.get(22));

      /* Elemento padre:22 / Elemento actual: 23   */
      v.add(doc.createTextNode("\r   \r\r#Cplistado1{visibility:hidden;}\r#CpLin1listado1{visibility:hidden;}\r#CpLin2listado1{visibility:hidden;}\r#CpLin3listado1{visibility:hidden;}\r#CpLin4listado1{visibility:hidden;}\r#capa1{visibility:hidden;}\r#ModificarDiv{visibility:hidden;}\r#EliminarDiv{visibility:hidden;}\r#primera1Div{visibility:hidden;}\r#ret1Div{visibility:hidden;}\r#ava1Div{visibility:hidden;}\r#separaDiv{visibility:hidden;}\r#capaContenido2{visibility:hidden;}\r\r   \r"));
      ((Element)v.get(22)).appendChild((Text)v.get(23));

      /* Termina nodo Texto:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(24)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(24)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","accion" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(26)).setAttribute("valor","LPMantieneGestionStock" );
      ((Element)v.get(24)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","formato" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","exito" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","ejecutar" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hMarca" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hCanal" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hPeriodo" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hPais" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hRegion" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hZona" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hTipoCliente" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hSubtipoCliente" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hTipoClasificacion" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hClasificacion" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hControlLiquidacion" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hUltimasNoticias" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hAnyadirCodigoVenta" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hOidCodigoVenta" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hTxtCodigoVenta" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hCodSeleccionadosEnListaEditable" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hAsignarCombosBusqueda" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hAsignarCamposModificar" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hSiI18N" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hNoI18N" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hMarcaDefecto" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hCanalDefecto" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hCargarMarcaCanalDefecto" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 24   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(56)).setAttribute("nombre","capaTemporal" );
      ((Element)v.get(56)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(24)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(57)).setAttribute("nombre","cbTemporal" );
      ((Element)v.get(57)).setAttribute("valorinicial","" );
      ((Element)v.get(57)).setAttribute("req","S" );
      ((Element)v.get(57)).setAttribute("multiple","N" );
      ((Element)v.get(57)).setAttribute("size","1" );
      ((Element)v.get(57)).setAttribute("id","datosCamposTemporal" );
      ((Element)v.get(57)).setAttribute("textoinicial","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(57)).setAttribute("onchange","" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:59 / Elemento padre: 24   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(59)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(24)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("table"));
      ((Element)v.get(60)).setAttribute("width","100%" );
      ((Element)v.get(60)).setAttribute("border","0" );
      ((Element)v.get(60)).setAttribute("cellspacing","0" );
      ((Element)v.get(60)).setAttribute("cellpadding","0" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("width","12" );
      ((Element)v.get(62)).setAttribute("align","center" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","12" );
      ((Element)v.get(63)).setAttribute("height","12" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("width","750" );
      ((Element)v.get(61)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","12" );
      ((Element)v.get(61)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","12" );
      ((Element)v.get(67)).setAttribute("height","1" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:61   */

      /* Empieza nodo:68 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(73)).setAttribute("class","legend" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(74)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("filas","1" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(74)).setAttribute("id","legend" );
      ((Element)v.get(74)).setAttribute("cod","0075" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 72   */
      v.add(doc.createElement("table"));
      ((Element)v.get(75)).setAttribute("width","100%" );
      ((Element)v.get(75)).setAttribute("border","0" );
      ((Element)v.get(75)).setAttribute("align","center" );
      ((Element)v.get(75)).setAttribute("cellspacing","0" );
      ((Element)v.get(75)).setAttribute("cellpadding","0" );
      ((Element)v.get(72)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("table"));
      ((Element)v.get(78)).setAttribute("width","597" );
      ((Element)v.get(78)).setAttribute("border","0" );
      ((Element)v.get(78)).setAttribute("align","left" );
      ((Element)v.get(78)).setAttribute("cellspacing","0" );
      ((Element)v.get(78)).setAttribute("cellpadding","0" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("colspan","4" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:82 / Elemento padre: 78   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(78)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(86)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(86)).setAttribute("alto","13" );
      ((Element)v.get(86)).setAttribute("filas","1" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(86)).setAttribute("id","datosTitle" );
      ((Element)v.get(86)).setAttribute("cod","6" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","25" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(90)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(90)).setAttribute("alto","13" );
      ((Element)v.get(90)).setAttribute("filas","1" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(90)).setAttribute("id","datosTitle" );
      ((Element)v.get(90)).setAttribute("cod","7" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","100%" );
      ((Element)v.get(82)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:82   */

      /* Empieza nodo:93 / Elemento padre: 78   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(78)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","8" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(93)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(97)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(97)).setAttribute("valorinicial","" );
      ((Element)v.get(97)).setAttribute("req","S" );
      ((Element)v.get(97)).setAttribute("multiple","N" );
      ((Element)v.get(97)).setAttribute("size","1" );
      ((Element)v.get(97)).setAttribute("id","datosCampos" );
      ((Element)v.get(97)).setAttribute("textoinicial","" );
      ((Element)v.get(97)).setAttribute("onchange","onChangeMarca();" );
      ((Element)v.get(97)).setAttribute("ontab","setTabFocus('cbMarca');" );
      ((Element)v.get(97)).setAttribute("onshtab","setSHTabFocus('cbMarca');" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:99 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","25" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(93)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(102)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(102)).setAttribute("valorinicial","" );
      ((Element)v.get(102)).setAttribute("req","S" );
      ((Element)v.get(102)).setAttribute("multiple","N" );
      ((Element)v.get(102)).setAttribute("size","1" );
      ((Element)v.get(102)).setAttribute("id","datosCampos" );
      ((Element)v.get(102)).setAttribute("textoinicial","" );
      ((Element)v.get(102)).setAttribute("onchange","onChangeCanal();" );
      ((Element)v.get(102)).setAttribute("ontab","setTabFocus('cbCanal');" );
      ((Element)v.get(102)).setAttribute("onshtab","setSHTabFocus('cbCanal');" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:104 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("width","100%" );
      ((Element)v.get(93)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","8" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:93   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:106 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("table"));
      ((Element)v.get(108)).setAttribute("width","597" );
      ((Element)v.get(108)).setAttribute("border","0" );
      ((Element)v.get(108)).setAttribute("align","left" );
      ((Element)v.get(108)).setAttribute("cellspacing","0" );
      ((Element)v.get(108)).setAttribute("cellpadding","0" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("colspan","4" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","8" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:112 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("table"));
      ((Element)v.get(114)).setAttribute("width","597" );
      ((Element)v.get(114)).setAttribute("border","0" );
      ((Element)v.get(114)).setAttribute("align","left" );
      ((Element)v.get(114)).setAttribute("cellspacing","0" );
      ((Element)v.get(114)).setAttribute("cellpadding","0" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(119)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(119)).setAttribute("alto","13" );
      ((Element)v.get(119)).setAttribute("filas","1" );
      ((Element)v.get(119)).setAttribute("valor","" );
      ((Element)v.get(119)).setAttribute("id","datosTitle" );
      ((Element)v.get(119)).setAttribute("cod","276" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","25" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(123)).setAttribute("nombre","lblCodigoVenta" );
      ((Element)v.get(123)).setAttribute("alto","13" );
      ((Element)v.get(123)).setAttribute("filas","1" );
      ((Element)v.get(123)).setAttribute("valor","" );
      ((Element)v.get(123)).setAttribute("id","datosTitle" );
      ((Element)v.get(123)).setAttribute("cod","336" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(115)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:115   */

      /* Empieza nodo:126 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
   }

   private void getXML540(Document doc) {
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
      ((Element)v.get(130)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(130)).setAttribute("valorinicial","" );
      ((Element)v.get(130)).setAttribute("req","S" );
      ((Element)v.get(130)).setAttribute("multiple","N" );
      ((Element)v.get(130)).setAttribute("size","1" );
      ((Element)v.get(130)).setAttribute("id","datosCampos" );
      ((Element)v.get(130)).setAttribute("textoinicial","" );
      ((Element)v.get(130)).setAttribute("ontab","setTabFocus('cbPeriodo');" );
      ((Element)v.get(130)).setAttribute("onshtab","setSHTabFocus('cbPeriodo');" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:132 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(126)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(135)).setAttribute("nombre","txtCodigoVentaBuscar" );
      ((Element)v.get(135)).setAttribute("id","datosCampos" );
      ((Element)v.get(135)).setAttribute("max","18" );
      ((Element)v.get(135)).setAttribute("tipo","" );
      ((Element)v.get(135)).setAttribute("onchange","" );
      ((Element)v.get(135)).setAttribute("req","N" );
      ((Element)v.get(135)).setAttribute("size","24" );
      ((Element)v.get(135)).setAttribute("valor","" );
      ((Element)v.get(135)).setAttribute("validacion","" );
      ((Element)v.get(135)).setAttribute("ontab","setTabFocus('txtCodigoVentaBuscar');" );
      ((Element)v.get(135)).setAttribute("onshtab","setSHTabFocus('txtCodigoVentaBuscar');" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("width","100%" );
      ((Element)v.get(126)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","8" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:126   */

      /* Empieza nodo:138 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("width","4" );
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
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:141 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(141));

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
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:75   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:144 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:68   */

      /* Empieza nodo:146 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("table"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(151)).setAttribute("width","100%" );
      ((Element)v.get(151)).setAttribute("border","0" );
      ((Element)v.get(151)).setAttribute("align","center" );
      ((Element)v.get(151)).setAttribute("cellspacing","0" );
      ((Element)v.get(151)).setAttribute("cellpadding","0" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("class","botonera" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(154)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(154)).setAttribute("ID","botonContenido" );
      ((Element)v.get(154)).setAttribute("tipo","html" );
      ((Element)v.get(154)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(154)).setAttribute("estado","false" );
      ((Element)v.get(154)).setAttribute("cod","1" );
      ((Element)v.get(154)).setAttribute("ontab","setTabFocus('btnBuscar');" );
      ((Element)v.get(154)).setAttribute("onshtab","setSHTabFocus('btnBuscar');" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:155 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","12" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:146   */

      /* Empieza nodo:157 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("width","12" );
      ((Element)v.get(158)).setAttribute("align","center" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","12" );
      ((Element)v.get(159)).setAttribute("height","12" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("width","750" );
      ((Element)v.get(157)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("width","12" );
      ((Element)v.get(157)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","12" );
      ((Element)v.get(163)).setAttribute("height","1" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:157   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:164 / Elemento padre: 24   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(164)).setAttribute("nombre","capaContenido2" );
      ((Element)v.get(164)).setAttribute("x","0" );
      ((Element)v.get(164)).setAttribute("y","146" );
      ((Element)v.get(164)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(24)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("table"));
      ((Element)v.get(165)).setAttribute("width","100%" );
      ((Element)v.get(165)).setAttribute("border","0" );
      ((Element)v.get(165)).setAttribute("cellspacing","0" );
      ((Element)v.get(165)).setAttribute("cellpadding","0" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("width","12" );
      ((Element)v.get(167)).setAttribute("align","center" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","12" );
      ((Element)v.get(168)).setAttribute("height","12" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).setAttribute("width","750" );
      ((Element)v.get(166)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).setAttribute("width","12" );
      ((Element)v.get(166)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","12" );
      ((Element)v.get(172)).setAttribute("height","1" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:166   */

      /* Empieza nodo:173 / Elemento padre: 165   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(178)).setAttribute("class","legend" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(179)).setAttribute("nombre","lblDatosStock" );
      ((Element)v.get(179)).setAttribute("alto","13" );
      ((Element)v.get(179)).setAttribute("filas","1" );
      ((Element)v.get(179)).setAttribute("valor","" );
      ((Element)v.get(179)).setAttribute("id","legend" );
      ((Element)v.get(179)).setAttribute("cod","00272" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 177   */
      v.add(doc.createElement("table"));
      ((Element)v.get(180)).setAttribute("width","100%" );
      ((Element)v.get(180)).setAttribute("border","0" );
      ((Element)v.get(180)).setAttribute("align","center" );
      ((Element)v.get(180)).setAttribute("cellspacing","0" );
      ((Element)v.get(180)).setAttribute("cellpadding","0" );
      ((Element)v.get(177)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("table"));
      ((Element)v.get(183)).setAttribute("width","597" );
      ((Element)v.get(183)).setAttribute("border","0" );
      ((Element)v.get(183)).setAttribute("align","left" );
      ((Element)v.get(183)).setAttribute("cellspacing","0" );
      ((Element)v.get(183)).setAttribute("cellpadding","0" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).setAttribute("colspan","7" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","8" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:187 / Elemento padre: 183   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(183)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","8" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(191)).setAttribute("nombre","lblCodigoVenta" );
      ((Element)v.get(191)).setAttribute("alto","13" );
      ((Element)v.get(191)).setAttribute("filas","1" );
      ((Element)v.get(191)).setAttribute("valor","" );
      ((Element)v.get(191)).setAttribute("id","datosTitle" );
      ((Element)v.get(191)).setAttribute("cod","336" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).setAttribute("colspan","2" );
      ((Element)v.get(187)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).setAttribute("width","100%" );
      ((Element)v.get(187)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","8" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:187   */

      /* Empieza nodo:196 / Elemento padre: 183   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(183)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","8" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(196)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(200)).setAttribute("nombre","txtCodigoVenta" );
      ((Element)v.get(200)).setAttribute("id","datosCampos" );
      ((Element)v.get(200)).setAttribute("max","18" );
      ((Element)v.get(200)).setAttribute("tipo","" );
      ((Element)v.get(200)).setAttribute("onchange","" );
      ((Element)v.get(200)).setAttribute("req","S" );
      ((Element)v.get(200)).setAttribute("size","24" );
      ((Element)v.get(200)).setAttribute("valor","" );
      ((Element)v.get(200)).setAttribute("validacion","" );
      ((Element)v.get(200)).setAttribute("ontab","setTabFocus('txtCodigoVenta');" );
      ((Element)v.get(200)).setAttribute("onshtab","setSHTabFocus('txtCodigoVenta');" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","16" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).setAttribute("align","left" );
      ((Element)v.get(203)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(196)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(204)).setAttribute("nombre","btnAnyadirCodigo" );
      ((Element)v.get(204)).setAttribute("ID","botonContenido" );
      ((Element)v.get(204)).setAttribute("tipo","html" );
      ((Element)v.get(204)).setAttribute("accion","onClickAnyadirCodigo();" );
      ((Element)v.get(204)).setAttribute("estado","false" );
      ((Element)v.get(204)).setAttribute("cod","404" );
      ((Element)v.get(204)).setAttribute("ontab","setTabFocus('btnAnyadirCodigo');" );
      ((Element)v.get(204)).setAttribute("onshtab","setSHTabFocus('btnAnyadirCodigo');" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 203   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(205)).setAttribute("nombre","btnBuscarCodVenta" );
      ((Element)v.get(205)).setAttribute("ID","botonContenido" );
      ((Element)v.get(205)).setAttribute("tipo","html" );
      ((Element)v.get(205)).setAttribute("accion","onClickBuscarCodVenta();" );
      ((Element)v.get(205)).setAttribute("estado","false" );
      ((Element)v.get(205)).setAttribute("cod","1" );
      ((Element)v.get(205)).setAttribute("ontab","setTabFocus('btnBuscarCodVenta');" );
      ((Element)v.get(205)).setAttribute("onshtab","setSHTabFocus('btnBuscarCodVenta');" );
      ((Element)v.get(203)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:203   */

      /* Empieza nodo:206 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).setAttribute("width","100%" );
      ((Element)v.get(196)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","8" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */
      /* Termina nodo:196   */

      /* Empieza nodo:208 / Elemento padre: 183   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(183)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).setAttribute("colspan","3" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).setAttribute("width","8" );
      ((Element)v.get(210)).setAttribute("height","8" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:211 / Elemento padre: 180   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(180)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("table"));
      ((Element)v.get(213)).setAttribute("width","597" );
      ((Element)v.get(213)).setAttribute("border","0" );
      ((Element)v.get(213)).setAttribute("align","left" );
      ((Element)v.get(213)).setAttribute("cellspacing","0" );
      ((Element)v.get(213)).setAttribute("cellpadding","0" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","8" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(214)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(218)).setAttribute("nombre","cbCodVenta2" );
      ((Element)v.get(218)).setAttribute("valorinicial","" );
      ((Element)v.get(218)).setAttribute("req","N" );
      ((Element)v.get(218)).setAttribute("multiple","M" );
      ((Element)v.get(218)).setAttribute("size","5" );
      ((Element)v.get(218)).setAttribute("id","datosCampos" );
      ((Element)v.get(218)).setAttribute("textoinicial","" );
      ((Element)v.get(218)).setAttribute("ontab","setTabFocus('cbCodVenta2');" );
      ((Element)v.get(218)).setAttribute("onshtab","setSHTabFocus('cbCodVenta2');" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:220 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","25" );
      ((Element)v.get(221)).setAttribute("height","8" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).setAttribute("valign","bottom" );
      ((Element)v.get(214)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(223)).setAttribute("nombre","btnEliminarCodigo" );
      ((Element)v.get(223)).setAttribute("ID","botonContenido" );
      ((Element)v.get(223)).setAttribute("tipo","html" );
      ((Element)v.get(223)).setAttribute("accion","onClickEliminarCodigo();" );
      ((Element)v.get(223)).setAttribute("estado","false" );
      ((Element)v.get(223)).setAttribute("cod","1254" );
      ((Element)v.get(223)).setAttribute("ontab","setTabFocus('btnEliminarCodigo');" );
      ((Element)v.get(223)).setAttribute("onshtab","setSHTabFocus('btnEliminarCodigo');" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("width","100%" );
      ((Element)v.get(214)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:214   */

      /* Empieza nodo:226 / Elemento padre: 213   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(213)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).setAttribute("colspan","3" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","8" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:229 / Elemento padre: 180   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(180)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("table"));
      ((Element)v.get(231)).setAttribute("border","0" );
      ((Element)v.get(231)).setAttribute("align","left" );
      ((Element)v.get(231)).setAttribute("cellspacing","0" );
      ((Element)v.get(231)).setAttribute("cellpadding","0" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("table"));
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
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(239)).setAttribute("nombre","rbTipoUbic" );
      ((Element)v.get(239)).setAttribute("tipo","H" );
      ((Element)v.get(239)).setAttribute("id","datosTitle" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(240)).setAttribute("valor","R" );
      ((Element)v.get(240)).setAttribute("check","S" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(240)).setAttribute("onfocus","" );
      ((Element)v.get(240)).setAttribute("id","datosCampos" );
      ((Element)v.get(240)).setAttribute("cod","109" );
      ((Element)v.get(240)).setAttribute("onclick","habilitarListaRegionZona()" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:241 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).setAttribute("width","100%" );
      ((Element)v.get(235)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","8" );
      ((Element)v.get(242)).setAttribute("height","8" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:235   */

      /* Empieza nodo:243 / Elemento padre: 234   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(234)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","8" );
      ((Element)v.get(245)).setAttribute("height","8" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(243)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(247)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(247)).setAttribute("valorinicial","" );
      ((Element)v.get(247)).setAttribute("req","N" );
      ((Element)v.get(247)).setAttribute("multiple","S" );
      ((Element)v.get(247)).setAttribute("size","5" );
      ((Element)v.get(247)).setAttribute("id","datosCampos" );
      ((Element)v.get(247)).setAttribute("textoinicial","" );
      ((Element)v.get(247)).setAttribute("ontab","setTabFocus('cbRegion');" );
      ((Element)v.get(247)).setAttribute("onshtab","setSHTabFocus('cbRegion');" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:249 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).setAttribute("width","25" );
      ((Element)v.get(250)).setAttribute("height","8" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:243   */

      /* Empieza nodo:251 / Elemento padre: 234   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(234)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).setAttribute("colspan","3" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","8" );
      ((Element)v.get(253)).setAttribute("height","8" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:254 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("table"));
      ((Element)v.get(255)).setAttribute("border","0" );
      ((Element)v.get(255)).setAttribute("align","left" );
      ((Element)v.get(255)).setAttribute("cellspacing","0" );
      ((Element)v.get(255)).setAttribute("cellpadding","0" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","8" );
      ((Element)v.get(258)).setAttribute("height","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(256)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(260)).setAttribute("nombre","rbTipoUbic" );
      ((Element)v.get(260)).setAttribute("tipo","H" );
      ((Element)v.get(260)).setAttribute("id","datosTitle" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(261)).setAttribute("valor","Z" );
      ((Element)v.get(261)).setAttribute("check","N" );
      ((Element)v.get(261)).setAttribute("onfocus","" );
      ((Element)v.get(261)).setAttribute("id","datosCampos" );
      ((Element)v.get(261)).setAttribute("cod","143" );
      ((Element)v.get(261)).setAttribute("onclick","habilitarListaRegionZona()" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:262 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).setAttribute("width","100%" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(256)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","8" );
      ((Element)v.get(263)).setAttribute("height","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:256   */

      /* Empieza nodo:264 / Elemento padre: 255   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(255)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","8" );
      ((Element)v.get(266)).setAttribute("height","8" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(264)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(268)).setAttribute("nombre","cbZona" );
      ((Element)v.get(268)).setAttribute("valorinicial","" );
      ((Element)v.get(268)).setAttribute("req","N" );
      ((Element)v.get(268)).setAttribute("multiple","S" );
      ((Element)v.get(268)).setAttribute("size","5" );
      ((Element)v.get(268)).setAttribute("id","datosCampos" );
      ((Element)v.get(268)).setAttribute("textoinicial","" );
      ((Element)v.get(268)).setAttribute("ontab","setTabFocus('cbZona');" );
      ((Element)v.get(268)).setAttribute("onshtab","setSHTabFocus('cbZona');" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:270 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).setAttribute("width","100%" );
      ((Element)v.get(264)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","8" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:264   */

      /* Empieza nodo:272 / Elemento padre: 255   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(255)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).setAttribute("colspan","3" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(274)).setAttribute("width","8" );
      ((Element)v.get(274)).setAttribute("height","8" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:275 / Elemento padre: 180   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(180)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("table"));
      ((Element)v.get(277)).setAttribute("width","597" );
      ((Element)v.get(277)).setAttribute("border","0" );
      ((Element)v.get(277)).setAttribute("align","left" );
      ((Element)v.get(277)).setAttribute("cellspacing","0" );
      ((Element)v.get(277)).setAttribute("cellpadding","0" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("td"));
      ((Element)v.get(278)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","8" );
      ((Element)v.get(280)).setAttribute("height","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:281 / Elemento padre: 278   */
      v.add(doc.createElement("td"));
      ((Element)v.get(278)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(282)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(282)).setAttribute("alto","13" );
      ((Element)v.get(282)).setAttribute("filas","1" );
      ((Element)v.get(282)).setAttribute("valor","" );
      ((Element)v.get(282)).setAttribute("id","datosTitle" );
      ((Element)v.get(282)).setAttribute("cod","1869" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 278   */
      v.add(doc.createElement("td"));
      ((Element)v.get(278)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","25" );
      ((Element)v.get(284)).setAttribute("height","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 278   */
      v.add(doc.createElement("td"));
      ((Element)v.get(278)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(286)).setAttribute("nombre","lblSubtipoCliente" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(286)).setAttribute("alto","13" );
      ((Element)v.get(286)).setAttribute("filas","1" );
      ((Element)v.get(286)).setAttribute("valor","" );
      ((Element)v.get(286)).setAttribute("id","datosTitle" );
      ((Element)v.get(286)).setAttribute("cod","595" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:287 / Elemento padre: 278   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).setAttribute("width","100%" );
      ((Element)v.get(278)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).setAttribute("width","8" );
      ((Element)v.get(288)).setAttribute("height","8" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */
      /* Termina nodo:278   */

      /* Empieza nodo:289 / Elemento padre: 277   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(277)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(291)).setAttribute("src","b.gif" );
      ((Element)v.get(291)).setAttribute("width","8" );
      ((Element)v.get(291)).setAttribute("height","8" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(289)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(293)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(293)).setAttribute("valorinicial","" );
      ((Element)v.get(293)).setAttribute("req","S" );
      ((Element)v.get(293)).setAttribute("multiple","N" );
      ((Element)v.get(293)).setAttribute("size","1" );
      ((Element)v.get(293)).setAttribute("id","datosCampos" );
      ((Element)v.get(293)).setAttribute("textoinicial","" );
      ((Element)v.get(293)).setAttribute("onchange","onChangeTipoCliente();" );
      ((Element)v.get(293)).setAttribute("ontab","setTabFocus('cbTipoCliente');" );
      ((Element)v.get(293)).setAttribute("onshtab","setSHTabFocus('cbTipoCliente');" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:295 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(296)).setAttribute("width","25" );
      ((Element)v.get(296)).setAttribute("height","8" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(289)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(298)).setAttribute("nombre","cbSubtipoCliente" );
      ((Element)v.get(298)).setAttribute("valorinicial","" );
      ((Element)v.get(298)).setAttribute("req","N" );
      ((Element)v.get(298)).setAttribute("multiple","N" );
      ((Element)v.get(298)).setAttribute("size","1" );
      ((Element)v.get(298)).setAttribute("id","datosCampos" );
      ((Element)v.get(298)).setAttribute("textoinicial","" );
      ((Element)v.get(298)).setAttribute("onchange","onChangeSubtipoCliente();" );
      ((Element)v.get(298)).setAttribute("ontab","setTabFocus('cbSubtipoCliente');" );
      ((Element)v.get(298)).setAttribute("onshtab","setSHTabFocus('cbSubtipoCliente');" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:300 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).setAttribute("width","100%" );
      ((Element)v.get(289)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(301)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).setAttribute("width","8" );
      ((Element)v.get(301)).setAttribute("height","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */
      /* Termina nodo:289   */

      /* Empieza nodo:302 / Elemento padre: 277   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(277)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).setAttribute("colspan","3" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).setAttribute("width","8" );
      ((Element)v.get(304)).setAttribute("height","8" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:305 / Elemento padre: 180   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(180)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("table"));
      ((Element)v.get(307)).setAttribute("width","597" );
      ((Element)v.get(307)).setAttribute("border","0" );
      ((Element)v.get(307)).setAttribute("align","left" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(307)).setAttribute("cellspacing","0" );
      ((Element)v.get(307)).setAttribute("cellpadding","0" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(310)).setAttribute("src","b.gif" );
      ((Element)v.get(310)).setAttribute("width","8" );
      ((Element)v.get(310)).setAttribute("height","8" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:311 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(312)).setAttribute("nombre","lblTipoClasificacion" );
      ((Element)v.get(312)).setAttribute("alto","13" );
      ((Element)v.get(312)).setAttribute("filas","1" );
      ((Element)v.get(312)).setAttribute("valor","" );
      ((Element)v.get(312)).setAttribute("id","datosTitle" );
      ((Element)v.get(312)).setAttribute("cod","756" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(314)).setAttribute("src","b.gif" );
      ((Element)v.get(314)).setAttribute("width","25" );
      ((Element)v.get(314)).setAttribute("height","8" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(316)).setAttribute("nombre","lblClasificacion" );
      ((Element)v.get(316)).setAttribute("alto","13" );
      ((Element)v.get(316)).setAttribute("filas","1" );
      ((Element)v.get(316)).setAttribute("valor","" );
      ((Element)v.get(316)).setAttribute("id","datosTitle" );
      ((Element)v.get(316)).setAttribute("cod","550" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).setAttribute("width","100%" );
      ((Element)v.get(308)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).setAttribute("width","8" );
      ((Element)v.get(318)).setAttribute("height","8" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */
      /* Termina nodo:308   */

      /* Empieza nodo:319 / Elemento padre: 307   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(307)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(321)).setAttribute("src","b.gif" );
      ((Element)v.get(321)).setAttribute("width","8" );
      ((Element)v.get(321)).setAttribute("height","8" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:322 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(322)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(319)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(323)).setAttribute("nombre","cbTipoClasificacion" );
      ((Element)v.get(323)).setAttribute("valorinicial","" );
      ((Element)v.get(323)).setAttribute("req","N" );
      ((Element)v.get(323)).setAttribute("multiple","N" );
      ((Element)v.get(323)).setAttribute("size","1" );
      ((Element)v.get(323)).setAttribute("id","datosCampos" );
      ((Element)v.get(323)).setAttribute("textoinicial","" );
      ((Element)v.get(323)).setAttribute("onchange","onChangeTipoClasificacion();" );
      ((Element)v.get(323)).setAttribute("ontab","setTabFocus('cbTipoClasificacion');" );
      ((Element)v.get(323)).setAttribute("onshtab","setSHTabFocus('cbTipoClasificacion');" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:325 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(326)).setAttribute("src","b.gif" );
      ((Element)v.get(326)).setAttribute("width","25" );
      ((Element)v.get(326)).setAttribute("height","8" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:327 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(319)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(328)).setAttribute("nombre","cbClasificacion" );
      ((Element)v.get(328)).setAttribute("valorinicial","" );
      ((Element)v.get(328)).setAttribute("req","N" );
      ((Element)v.get(328)).setAttribute("multiple","N" );
      ((Element)v.get(328)).setAttribute("size","1" );
      ((Element)v.get(328)).setAttribute("id","datosCampos" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(328)).setAttribute("textoinicial","" );
      ((Element)v.get(328)).setAttribute("ontab","setTabFocus('cbClasificacion');" );
      ((Element)v.get(328)).setAttribute("onshtab","setSHTabFocus('cbClasificacion');" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:330 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(330)).setAttribute("width","100%" );
      ((Element)v.get(319)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","8" );
      ((Element)v.get(331)).setAttribute("height","8" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:319   */

      /* Empieza nodo:332 / Elemento padre: 307   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(307)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(333)).setAttribute("colspan","3" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","8" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:307   */
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:335 / Elemento padre: 180   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(180)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("table"));
      ((Element)v.get(337)).setAttribute("width","597" );
      ((Element)v.get(337)).setAttribute("border","0" );
      ((Element)v.get(337)).setAttribute("align","left" );
      ((Element)v.get(337)).setAttribute("cellspacing","0" );
      ((Element)v.get(337)).setAttribute("cellpadding","0" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(337)).appendChild((Element)v.get(338));

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
      ((Element)v.get(338)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(342)).setAttribute("nombre","lblLimiteVenta" );
      ((Element)v.get(342)).setAttribute("alto","13" );
      ((Element)v.get(342)).setAttribute("filas","1" );
      ((Element)v.get(342)).setAttribute("valor","" );
      ((Element)v.get(342)).setAttribute("id","datosTitle" );
      ((Element)v.get(342)).setAttribute("cod","1428" );
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
      ((Element)v.get(338)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(346)).setAttribute("nombre","lblControlStock" );
      ((Element)v.get(346)).setAttribute("alto","13" );
      ((Element)v.get(346)).setAttribute("filas","1" );
      ((Element)v.get(346)).setAttribute("valor","" );
      ((Element)v.get(346)).setAttribute("id","datosTitle" );
      ((Element)v.get(346)).setAttribute("cod","1451" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(338)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(348)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).setAttribute("width","25" );
      ((Element)v.get(348)).setAttribute("height","8" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(338)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(350)).setAttribute("nombre","lblControlStockPorcentual" );
      ((Element)v.get(350)).setAttribute("alto","13" );
      ((Element)v.get(350)).setAttribute("filas","1" );
      ((Element)v.get(350)).setAttribute("valor","" );
      ((Element)v.get(350)).setAttribute("id","datosTitle" );
      ((Element)v.get(350)).setAttribute("cod","2338" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(338)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(352)).setAttribute("src","b.gif" );
      ((Element)v.get(352)).setAttribute("width","25" );
      ((Element)v.get(352)).setAttribute("height","8" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:353 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(338)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(354)).setAttribute("nombre","lblControlLiquidacion" );
      ((Element)v.get(354)).setAttribute("alto","13" );
      ((Element)v.get(354)).setAttribute("filas","1" );
      ((Element)v.get(354)).setAttribute("valor","" );
      ((Element)v.get(354)).setAttribute("id","datosTitle" );
      ((Element)v.get(354)).setAttribute("cod","1429" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:355 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(338)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(356)).setAttribute("src","b.gif" );
      ((Element)v.get(356)).setAttribute("width","25" );
      ((Element)v.get(356)).setAttribute("height","8" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:355   */

      /* Empieza nodo:357 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(338)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(358)).setAttribute("nombre","lblUltimasNoticias" );
      ((Element)v.get(358)).setAttribute("alto","13" );
      ((Element)v.get(358)).setAttribute("filas","1" );
      ((Element)v.get(358)).setAttribute("valor","" );
      ((Element)v.get(358)).setAttribute("id","datosTitle" );
      ((Element)v.get(358)).setAttribute("cod","1436" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */

      /* Empieza nodo:359 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(359)).setAttribute("width","100%" );
      ((Element)v.get(338)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(360)).setAttribute("src","b.gif" );
      ((Element)v.get(360)).setAttribute("width","8" );
      ((Element)v.get(360)).setAttribute("height","8" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */
      /* Termina nodo:338   */

      /* Empieza nodo:361 / Elemento padre: 337   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(337)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(363)).setAttribute("src","b.gif" );
      ((Element)v.get(363)).setAttribute("width","8" );
      ((Element)v.get(363)).setAttribute("height","8" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:364 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(361)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(365)).setAttribute("nombre","txtLimiteVenta" );
      ((Element)v.get(365)).setAttribute("id","datosCampos" );
      ((Element)v.get(365)).setAttribute("max","13" );
      ((Element)v.get(365)).setAttribute("tipo","" );
      ((Element)v.get(365)).setAttribute("onchange","" );
      ((Element)v.get(365)).setAttribute("req","N" );
      ((Element)v.get(365)).setAttribute("size","14" );
      ((Element)v.get(365)).setAttribute("valor","" );
      ((Element)v.get(365)).setAttribute("validacion","" );
      ((Element)v.get(365)).setAttribute("ontab","setTabFocus('txtLimiteVenta');" );
      ((Element)v.get(365)).setAttribute("onshtab","setSHTabFocus('txtLimiteVenta');" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:366 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(367)).setAttribute("src","b.gif" );
      ((Element)v.get(367)).setAttribute("width","25" );
      ((Element)v.get(367)).setAttribute("height","8" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(361)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(369)).setAttribute("nombre","txtControlStock" );
      ((Element)v.get(369)).setAttribute("id","datosCampos" );
      ((Element)v.get(369)).setAttribute("max","13" );
      ((Element)v.get(369)).setAttribute("tipo","" );
      ((Element)v.get(369)).setAttribute("onchange","" );
      ((Element)v.get(369)).setAttribute("req","N" );
      ((Element)v.get(369)).setAttribute("size","14" );
      ((Element)v.get(369)).setAttribute("valor","" );
      ((Element)v.get(369)).setAttribute("validacion","" );
      ((Element)v.get(369)).setAttribute("ontab","setTabFocus('txtControlStock');" );
      ((Element)v.get(369)).setAttribute("onshtab","setSHTabFocus('txtControlStock');" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).setAttribute("width","25" );
      ((Element)v.get(371)).setAttribute("height","8" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:372 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(372)).setAttribute("class","datosCampos" );
      ((Element)v.get(361)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(373)).setAttribute("nombre","txtControlStockPorcentual" );
      ((Element)v.get(373)).setAttribute("id","datosCampos" );
      ((Element)v.get(373)).setAttribute("max","7" );
      ((Element)v.get(373)).setAttribute("tipo","" );
      ((Element)v.get(373)).setAttribute("onchange","" );
      ((Element)v.get(373)).setAttribute("req","N" );
      ((Element)v.get(373)).setAttribute("size","8" );
      ((Element)v.get(373)).setAttribute("valor","" );
      ((Element)v.get(373)).setAttribute("validacion","" );
      ((Element)v.get(373)).setAttribute("ontab","setTabFocus('txtControlStockPorcentual');" );
      ((Element)v.get(373)).setAttribute("onshtab","setSHTabFocus('txtControlStockPorcentual');" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */

      /* Elemento padre:372 / Elemento actual: 374   */
      v.add(doc.createTextNode("%"));
      ((Element)v.get(372)).appendChild((Text)v.get(374));

      /* Termina nodo Texto:374   */
      /* Termina nodo:372   */

      /* Empieza nodo:375 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(376)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).setAttribute("width","25" );
      ((Element)v.get(376)).setAttribute("height","8" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(378)).setAttribute("check","" );
      ((Element)v.get(378)).setAttribute("id","" );
      ((Element)v.get(378)).setAttribute("msjreq","" );
      ((Element)v.get(378)).setAttribute("nombre","chkControlLiquidacion" );
      ((Element)v.get(378)).setAttribute("onclick","" );
      ((Element)v.get(378)).setAttribute("onfocus","" );
      ((Element)v.get(378)).setAttribute("readonly","" );
      ((Element)v.get(378)).setAttribute("req","" );
      ((Element)v.get(378)).setAttribute("tabindex","1" );
      ((Element)v.get(378)).setAttribute("texto","" );
      ((Element)v.get(378)).setAttribute("validacion","" );
      ((Element)v.get(378)).setAttribute("ontab","setTabFocus('chkControlLiquidacion');" );
      ((Element)v.get(378)).setAttribute("onshtab","setSHTabFocus('chkControlLiquidacion');" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(380)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).setAttribute("width","25" );
      ((Element)v.get(380)).setAttribute("height","8" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(382)).setAttribute("check","" );
      ((Element)v.get(382)).setAttribute("id","" );
      ((Element)v.get(382)).setAttribute("msjreq","" );
      ((Element)v.get(382)).setAttribute("nombre","chkUltimasNoticias" );
      ((Element)v.get(382)).setAttribute("onclick","" );
      ((Element)v.get(382)).setAttribute("onfocus","" );
      ((Element)v.get(382)).setAttribute("readonly","" );
      ((Element)v.get(382)).setAttribute("req","" );
      ((Element)v.get(382)).setAttribute("tabindex","1" );
      ((Element)v.get(382)).setAttribute("texto","" );
      ((Element)v.get(382)).setAttribute("validacion","" );
      ((Element)v.get(382)).setAttribute("ontab","setTabFocus('chkUltimasNoticias');" );
      ((Element)v.get(382)).setAttribute("onshtab","setSHTabFocus('chkUltimasNoticias');" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:383 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).setAttribute("width","100%" );
      ((Element)v.get(361)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(384)).setAttribute("src","b.gif" );
      ((Element)v.get(384)).setAttribute("width","8" );
      ((Element)v.get(384)).setAttribute("height","8" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */
      /* Termina nodo:361   */

      /* Empieza nodo:385 / Elemento padre: 337   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(337)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).setAttribute("colspan","3" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(387)).setAttribute("src","b.gif" );
      ((Element)v.get(387)).setAttribute("width","8" );
      ((Element)v.get(387)).setAttribute("height","8" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */
      /* Termina nodo:385   */
      /* Termina nodo:337   */
      /* Termina nodo:336   */
      /* Termina nodo:335   */
      /* Termina nodo:180   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:388 / Elemento padre: 173   */
   }

   private void getXML1620(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(389)).setAttribute("src","b.gif" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:173   */

      /* Empieza nodo:390 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("td"));
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(392)).setAttribute("src","b.gif" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */

      /* Empieza nodo:393 / Elemento padre: 390   */
      v.add(doc.createElement("td"));
      ((Element)v.get(390)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("table"));
      ((Element)v.get(395)).setAttribute("width","100%" );
      ((Element)v.get(395)).setAttribute("border","0" );
      ((Element)v.get(395)).setAttribute("align","center" );
      ((Element)v.get(395)).setAttribute("cellspacing","0" );
      ((Element)v.get(395)).setAttribute("cellpadding","0" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(395)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(397)).setAttribute("class","botonera" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(398)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(398)).setAttribute("ID","botonContenido" );
      ((Element)v.get(398)).setAttribute("tipo","html" );
      ((Element)v.get(398)).setAttribute("accion","onClickAnyadir();" );
      ((Element)v.get(398)).setAttribute("estado","false" );
      ((Element)v.get(398)).setAttribute("cod","404" );
      ((Element)v.get(398)).setAttribute("ontab","setTabFocus('btnAnadir');" );
      ((Element)v.get(398)).setAttribute("onshtab","setSHTabFocus('btnAnadir');" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */
      /* Termina nodo:396   */
      /* Termina nodo:395   */
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:399 / Elemento padre: 390   */
      v.add(doc.createElement("td"));
      ((Element)v.get(390)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(400)).setAttribute("src","b.gif" );
      ((Element)v.get(400)).setAttribute("width","8" );
      ((Element)v.get(400)).setAttribute("height","12" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */
      /* Termina nodo:390   */

      /* Empieza nodo:401 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).setAttribute("width","12" );
      ((Element)v.get(402)).setAttribute("align","center" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(403)).setAttribute("src","b.gif" );
      ((Element)v.get(403)).setAttribute("width","12" );
      ((Element)v.get(403)).setAttribute("height","12" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:404 / Elemento padre: 401   */
      v.add(doc.createElement("td"));
      ((Element)v.get(404)).setAttribute("width","756" );
      ((Element)v.get(401)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(405)).setAttribute("src","b.gif" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:406 / Elemento padre: 401   */
      v.add(doc.createElement("td"));
      ((Element)v.get(406)).setAttribute("width","12" );
      ((Element)v.get(401)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(407)).setAttribute("src","b.gif" );
      ((Element)v.get(407)).setAttribute("width","12" );
      ((Element)v.get(407)).setAttribute("height","1" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */
      /* Termina nodo:401   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:408 / Elemento padre: 24   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(408)).setAttribute("nombre","listado1" );
      ((Element)v.get(408)).setAttribute("ancho","600" );
      ((Element)v.get(408)).setAttribute("alto","317" );
      ((Element)v.get(408)).setAttribute("x","12" );
      ((Element)v.get(408)).setAttribute("y","540" );
      ((Element)v.get(408)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(408)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(24)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(409)).setAttribute("precarga","S" );
      ((Element)v.get(409)).setAttribute("conROver","S" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(410)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(410)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(410)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(410)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */

      /* Empieza nodo:411 / Elemento padre: 409   */
      v.add(doc.createElement("BTNMINIMIZAR"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(411)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(411)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(411)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(411)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(409)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */

      /* Empieza nodo:412 / Elemento padre: 409   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(412)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(412)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(409)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:409   */

      /* Empieza nodo:413 / Elemento padre: 408   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(408)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(414)).setAttribute("borde","1" );
      ((Element)v.get(414)).setAttribute("horizDatos","1" );
      ((Element)v.get(414)).setAttribute("horizCabecera","1" );
      ((Element)v.get(414)).setAttribute("vertical","1" );
      ((Element)v.get(414)).setAttribute("horizTitulo","1" );
      ((Element)v.get(414)).setAttribute("horizBase","1" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */

      /* Empieza nodo:415 / Elemento padre: 413   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(415)).setAttribute("borde","#999999" );
      ((Element)v.get(415)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(415)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(415)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(415)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(415)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(415)).setAttribute("horizBase","#999999" );
      ((Element)v.get(413)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */
      /* Termina nodo:413   */

      /* Empieza nodo:416 / Elemento padre: 408   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(416)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(416)).setAttribute("alto","22" );
      ((Element)v.get(416)).setAttribute("imgFondo","" );
      ((Element)v.get(416)).setAttribute("cod","00135" );
      ((Element)v.get(416)).setAttribute("ID","datosTitle" );
      ((Element)v.get(408)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */

      /* Empieza nodo:417 / Elemento padre: 408   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(417)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(417)).setAttribute("alto","22" );
      ((Element)v.get(417)).setAttribute("imgFondo","" );
      ((Element)v.get(408)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */

      /* Empieza nodo:418 / Elemento padre: 408   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(418)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(418)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(418)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(418)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(418)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(418)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(408)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(419)).setAttribute("ancho","100" );
      ((Element)v.get(419)).setAttribute("minimizable","S" );
      ((Element)v.get(419)).setAttribute("minimizada","N" );
      ((Element)v.get(419)).setAttribute("oculta","S" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */

      /* Empieza nodo:420 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(420)).setAttribute("ancho","150" );
      ((Element)v.get(420)).setAttribute("minimizable","S" );
      ((Element)v.get(420)).setAttribute("minimizada","N" );
      ((Element)v.get(420)).setAttribute("oculta","S" );
      ((Element)v.get(418)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */

      /* Empieza nodo:421 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(421)).setAttribute("ancho","80" );
      ((Element)v.get(421)).setAttribute("minimizable","S" );
      ((Element)v.get(421)).setAttribute("minimizada","N" );
      ((Element)v.get(421)).setAttribute("oculta","N" );
      ((Element)v.get(418)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */

      /* Empieza nodo:422 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(422)).setAttribute("ancho","200" );
      ((Element)v.get(422)).setAttribute("minimizable","S" );
      ((Element)v.get(422)).setAttribute("minimizada","N" );
      ((Element)v.get(418)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */

      /* Empieza nodo:423 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(423)).setAttribute("ancho","80" );
      ((Element)v.get(423)).setAttribute("minimizable","S" );
      ((Element)v.get(423)).setAttribute("minimizada","N" );
      ((Element)v.get(423)).setAttribute("oculta","N" );
      ((Element)v.get(418)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */

      /* Empieza nodo:424 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(424)).setAttribute("ancho","80" );
      ((Element)v.get(424)).setAttribute("minimizable","S" );
      ((Element)v.get(424)).setAttribute("minimizada","N" );
      ((Element)v.get(424)).setAttribute("oculta","N" );
      ((Element)v.get(418)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */

      /* Empieza nodo:425 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(425)).setAttribute("ancho","150" );
      ((Element)v.get(425)).setAttribute("minimizable","S" );
      ((Element)v.get(425)).setAttribute("minimizada","N" );
      ((Element)v.get(425)).setAttribute("oculta","S" );
      ((Element)v.get(418)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */

      /* Empieza nodo:426 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(426)).setAttribute("ancho","150" );
      ((Element)v.get(426)).setAttribute("minimizable","S" );
      ((Element)v.get(426)).setAttribute("minimizada","N" );
      ((Element)v.get(426)).setAttribute("oculta","N" );
      ((Element)v.get(418)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */

      /* Empieza nodo:427 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(427)).setAttribute("ancho","150" );
      ((Element)v.get(427)).setAttribute("minimizable","S" );
      ((Element)v.get(427)).setAttribute("minimizada","N" );
      ((Element)v.get(427)).setAttribute("oculta","S" );
      ((Element)v.get(418)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */

      /* Empieza nodo:428 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(428)).setAttribute("ancho","150" );
      ((Element)v.get(428)).setAttribute("minimizable","S" );
      ((Element)v.get(428)).setAttribute("minimizada","N" );
      ((Element)v.get(428)).setAttribute("oculta","N" );
      ((Element)v.get(418)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */

      /* Empieza nodo:429 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(429)).setAttribute("ancho","150" );
      ((Element)v.get(429)).setAttribute("minimizable","S" );
      ((Element)v.get(429)).setAttribute("minimizada","N" );
      ((Element)v.get(429)).setAttribute("oculta","S" );
      ((Element)v.get(418)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */

      /* Empieza nodo:430 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(430)).setAttribute("ancho","150" );
      ((Element)v.get(430)).setAttribute("minimizable","S" );
      ((Element)v.get(430)).setAttribute("minimizada","N" );
      ((Element)v.get(430)).setAttribute("oculta","N" );
      ((Element)v.get(418)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */

      /* Empieza nodo:431 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(431)).setAttribute("ancho","150" );
      ((Element)v.get(431)).setAttribute("minimizable","S" );
      ((Element)v.get(431)).setAttribute("minimizada","N" );
      ((Element)v.get(431)).setAttribute("oculta","S" );
      ((Element)v.get(418)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */

      /* Empieza nodo:432 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(432)).setAttribute("ancho","120" );
      ((Element)v.get(432)).setAttribute("minimizable","S" );
      ((Element)v.get(432)).setAttribute("minimizada","N" );
      ((Element)v.get(432)).setAttribute("oculta","N" );
      ((Element)v.get(418)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */

      /* Empieza nodo:433 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(433)).setAttribute("ancho","120" );
      ((Element)v.get(433)).setAttribute("minimizable","S" );
      ((Element)v.get(433)).setAttribute("minimizada","N" );
      ((Element)v.get(433)).setAttribute("oculta","S" );
      ((Element)v.get(418)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */

      /* Empieza nodo:434 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(434)).setAttribute("ancho","120" );
      ((Element)v.get(434)).setAttribute("minimizable","S" );
      ((Element)v.get(434)).setAttribute("minimizada","N" );
      ((Element)v.get(434)).setAttribute("oculta","N" );
      ((Element)v.get(418)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */

      /* Empieza nodo:435 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(435)).setAttribute("ancho","120" );
      ((Element)v.get(435)).setAttribute("minimizable","S" );
      ((Element)v.get(435)).setAttribute("minimizada","N" );
      ((Element)v.get(435)).setAttribute("oculta","S" );
      ((Element)v.get(418)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */

      /* Empieza nodo:436 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(436)).setAttribute("ancho","120" );
      ((Element)v.get(436)).setAttribute("minimizable","S" );
      ((Element)v.get(436)).setAttribute("minimizada","N" );
      ((Element)v.get(436)).setAttribute("oculta","N" );
      ((Element)v.get(418)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */

      /* Empieza nodo:437 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(437)).setAttribute("ancho","120" );
      ((Element)v.get(437)).setAttribute("minimizable","S" );
      ((Element)v.get(437)).setAttribute("minimizada","N" );
      ((Element)v.get(437)).setAttribute("oculta","N" );
      ((Element)v.get(418)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */

      /* Empieza nodo:438 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(438)).setAttribute("ancho","120" );
      ((Element)v.get(438)).setAttribute("minimizable","S" );
      ((Element)v.get(438)).setAttribute("minimizada","N" );
      ((Element)v.get(438)).setAttribute("oculta","N" );
      ((Element)v.get(418)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */

      /* Empieza nodo:439 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(439)).setAttribute("ancho","120" );
      ((Element)v.get(439)).setAttribute("minimizable","S" );
      ((Element)v.get(439)).setAttribute("minimizada","N" );
      ((Element)v.get(439)).setAttribute("oculta","N" );
      ((Element)v.get(418)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */

      /* Empieza nodo:440 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(440)).setAttribute("ancho","120" );
      ((Element)v.get(440)).setAttribute("minimizable","S" );
      ((Element)v.get(440)).setAttribute("minimizada","N" );
      ((Element)v.get(440)).setAttribute("oculta","N" );
      ((Element)v.get(418)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */

      /* Empieza nodo:441 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(441)).setAttribute("ancho","120" );
      ((Element)v.get(441)).setAttribute("minimizable","S" );
      ((Element)v.get(441)).setAttribute("minimizada","N" );
      ((Element)v.get(441)).setAttribute("oculta","N" );
      ((Element)v.get(418)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */
      /* Termina nodo:418   */

      /* Empieza nodo:442 / Elemento padre: 408   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(442)).setAttribute("alto","32" );
      ((Element)v.get(442)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(442)).setAttribute("imgFondo","" );
      ((Element)v.get(442)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(408)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(443)).setAttribute("colFondo","" );
      ((Element)v.get(443)).setAttribute("ID","EstCab" );
      ((Element)v.get(443)).setAttribute("cod","336" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */

      /* Empieza nodo:444 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(444)).setAttribute("colFondo","" );
      ((Element)v.get(444)).setAttribute("ID","EstCab" );
      ((Element)v.get(444)).setAttribute("cod","336" );
      ((Element)v.get(442)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */

      /* Empieza nodo:445 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(445)).setAttribute("colFondo","" );
      ((Element)v.get(445)).setAttribute("ID","EstCab" );
      ((Element)v.get(445)).setAttribute("cod","336" );
      ((Element)v.get(442)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */

      /* Empieza nodo:446 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(446)).setAttribute("colFondo","" );
      ((Element)v.get(446)).setAttribute("ID","EstCab" );
      ((Element)v.get(446)).setAttribute("cod","338" );
      ((Element)v.get(442)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */

      /* Empieza nodo:447 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(447)).setAttribute("colFondo","" );
      ((Element)v.get(447)).setAttribute("ID","EstCab" );
      ((Element)v.get(447)).setAttribute("cod","452" );
      ((Element)v.get(442)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */

      /* Empieza nodo:448 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(448)).setAttribute("colFondo","" );
      ((Element)v.get(448)).setAttribute("ID","EstCab" );
      ((Element)v.get(448)).setAttribute("cod","606" );
      ((Element)v.get(442)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */

      /* Empieza nodo:449 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(449)).setAttribute("colFondo","" );
      ((Element)v.get(449)).setAttribute("ID","EstCab" );
      ((Element)v.get(449)).setAttribute("cod","109" );
      ((Element)v.get(442)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */

      /* Empieza nodo:450 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(450)).setAttribute("colFondo","" );
      ((Element)v.get(450)).setAttribute("ID","EstCab" );
      ((Element)v.get(450)).setAttribute("cod","109" );
      ((Element)v.get(442)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */

      /* Empieza nodo:451 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(451)).setAttribute("colFondo","" );
      ((Element)v.get(451)).setAttribute("ID","EstCab" );
      ((Element)v.get(451)).setAttribute("cod","143" );
      ((Element)v.get(442)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */

      /* Empieza nodo:452 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(452)).setAttribute("colFondo","" );
      ((Element)v.get(452)).setAttribute("ID","EstCab" );
      ((Element)v.get(452)).setAttribute("cod","143" );
      ((Element)v.get(442)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */

      /* Empieza nodo:453 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(453)).setAttribute("colFondo","" );
      ((Element)v.get(453)).setAttribute("ID","EstCab" );
      ((Element)v.get(453)).setAttribute("cod","393" );
      ((Element)v.get(442)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */

      /* Empieza nodo:454 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(454)).setAttribute("colFondo","" );
      ((Element)v.get(454)).setAttribute("ID","EstCab" );
      ((Element)v.get(454)).setAttribute("cod","393" );
      ((Element)v.get(442)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */

      /* Empieza nodo:455 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(455)).setAttribute("colFondo","" );
      ((Element)v.get(455)).setAttribute("ID","EstCab" );
      ((Element)v.get(455)).setAttribute("cod","595" );
      ((Element)v.get(442)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */

      /* Empieza nodo:456 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(456)).setAttribute("colFondo","" );
      ((Element)v.get(456)).setAttribute("ID","EstCab" );
      ((Element)v.get(456)).setAttribute("cod","595" );
      ((Element)v.get(442)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */

      /* Empieza nodo:457 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(457)).setAttribute("colFondo","" );
      ((Element)v.get(457)).setAttribute("ID","EstCab" );
      ((Element)v.get(457)).setAttribute("cod","756" );
      ((Element)v.get(442)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */

      /* Empieza nodo:458 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(458)).setAttribute("colFondo","" );
      ((Element)v.get(458)).setAttribute("ID","EstCab" );
      ((Element)v.get(458)).setAttribute("cod","756" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(442)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */

      /* Empieza nodo:459 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(459)).setAttribute("colFondo","" );
      ((Element)v.get(459)).setAttribute("ID","EstCab" );
      ((Element)v.get(459)).setAttribute("cod","550" );
      ((Element)v.get(442)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */

      /* Empieza nodo:460 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(460)).setAttribute("colFondo","" );
      ((Element)v.get(460)).setAttribute("ID","EstCab" );
      ((Element)v.get(460)).setAttribute("cod","550" );
      ((Element)v.get(442)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */

      /* Empieza nodo:461 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(461)).setAttribute("colFondo","" );
      ((Element)v.get(461)).setAttribute("ID","EstCab" );
      ((Element)v.get(461)).setAttribute("cod","1428" );
      ((Element)v.get(442)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */

      /* Empieza nodo:462 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(462)).setAttribute("colFondo","" );
      ((Element)v.get(462)).setAttribute("ID","EstCab" );
      ((Element)v.get(462)).setAttribute("cod","1451" );
      ((Element)v.get(442)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */

      /* Empieza nodo:463 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(463)).setAttribute("colFondo","" );
      ((Element)v.get(463)).setAttribute("ID","EstCab" );
      ((Element)v.get(463)).setAttribute("cod","2338" );
      ((Element)v.get(442)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */

      /* Empieza nodo:464 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(464)).setAttribute("colFondo","" );
      ((Element)v.get(464)).setAttribute("ID","EstCab" );
      ((Element)v.get(464)).setAttribute("cod","1429" );
      ((Element)v.get(442)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */

      /* Empieza nodo:465 / Elemento padre: 442   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(465)).setAttribute("colFondo","" );
      ((Element)v.get(465)).setAttribute("ID","EstCab" );
      ((Element)v.get(465)).setAttribute("cod","1436" );
      ((Element)v.get(442)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:442   */

      /* Empieza nodo:466 / Elemento padre: 408   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(466)).setAttribute("alto","22" );
      ((Element)v.get(466)).setAttribute("accion","" );
      ((Element)v.get(466)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(466)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(466)).setAttribute("maxSel","-1" );
      ((Element)v.get(466)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(466)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(466)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(466)).setAttribute("onLoad","" );
      ((Element)v.get(466)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(408)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(467)).setAttribute("tipo","texto" );
      ((Element)v.get(467)).setAttribute("ID","EstDat" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */

      /* Empieza nodo:468 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(468)).setAttribute("tipo","texto" );
      ((Element)v.get(468)).setAttribute("ID","EstDat2" );
      ((Element)v.get(466)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */

      /* Empieza nodo:469 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(469)).setAttribute("tipo","texto" );
      ((Element)v.get(469)).setAttribute("ID","EstDat" );
      ((Element)v.get(466)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */

      /* Empieza nodo:470 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(470)).setAttribute("tipo","texto" );
      ((Element)v.get(470)).setAttribute("ID","EstDat2" );
      ((Element)v.get(466)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */

      /* Empieza nodo:471 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(471)).setAttribute("tipo","texto" );
      ((Element)v.get(471)).setAttribute("ID","EstDat" );
      ((Element)v.get(466)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */

      /* Empieza nodo:472 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(472)).setAttribute("tipo","texto" );
      ((Element)v.get(472)).setAttribute("ID","EstDat" );
      ((Element)v.get(466)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */

      /* Empieza nodo:473 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(473)).setAttribute("tipo","texto" );
      ((Element)v.get(473)).setAttribute("ID","EstDat2" );
      ((Element)v.get(466)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */

      /* Empieza nodo:474 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(474)).setAttribute("tipo","texto" );
      ((Element)v.get(474)).setAttribute("ID","EstDat" );
      ((Element)v.get(466)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */

      /* Empieza nodo:475 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(475)).setAttribute("tipo","texto" );
      ((Element)v.get(475)).setAttribute("ID","EstDat2" );
      ((Element)v.get(466)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */

      /* Empieza nodo:476 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(476)).setAttribute("tipo","texto" );
      ((Element)v.get(476)).setAttribute("ID","EstDat" );
      ((Element)v.get(466)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */

      /* Empieza nodo:477 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(477)).setAttribute("tipo","texto" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(477)).setAttribute("ID","EstDat2" );
      ((Element)v.get(466)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */

      /* Empieza nodo:478 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(478)).setAttribute("tipo","texto" );
      ((Element)v.get(478)).setAttribute("ID","EstDat" );
      ((Element)v.get(466)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */

      /* Empieza nodo:479 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(479)).setAttribute("tipo","texto" );
      ((Element)v.get(479)).setAttribute("ID","EstDat2" );
      ((Element)v.get(466)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */

      /* Empieza nodo:480 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(480)).setAttribute("tipo","texto" );
      ((Element)v.get(480)).setAttribute("ID","EstDat" );
      ((Element)v.get(466)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */

      /* Empieza nodo:481 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(481)).setAttribute("tipo","texto" );
      ((Element)v.get(481)).setAttribute("ID","EstDat2" );
      ((Element)v.get(466)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */

      /* Empieza nodo:482 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(482)).setAttribute("tipo","texto" );
      ((Element)v.get(482)).setAttribute("ID","EstDat" );
      ((Element)v.get(466)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */

      /* Empieza nodo:483 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(483)).setAttribute("tipo","texto" );
      ((Element)v.get(483)).setAttribute("ID","EstDat2" );
      ((Element)v.get(466)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */

      /* Empieza nodo:484 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(484)).setAttribute("tipo","texto" );
      ((Element)v.get(484)).setAttribute("ID","EstDat" );
      ((Element)v.get(466)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */

      /* Empieza nodo:485 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(485)).setAttribute("tipo","texto" );
      ((Element)v.get(485)).setAttribute("ID","EstDat2" );
      ((Element)v.get(466)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */

      /* Empieza nodo:486 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(486)).setAttribute("tipo","texto" );
      ((Element)v.get(486)).setAttribute("ID","EstDat" );
      ((Element)v.get(466)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */

      /* Empieza nodo:487 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(487)).setAttribute("tipo","texto" );
      ((Element)v.get(487)).setAttribute("ID","EstDat2" );
      ((Element)v.get(466)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */

      /* Empieza nodo:488 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(488)).setAttribute("tipo","texto" );
      ((Element)v.get(488)).setAttribute("ID","EstDat" );
      ((Element)v.get(466)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */

      /* Empieza nodo:489 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(489)).setAttribute("tipo","texto" );
      ((Element)v.get(489)).setAttribute("ID","EstDat2" );
      ((Element)v.get(466)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:466   */

      /* Empieza nodo:490 / Elemento padre: 408   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(408)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */

      /* Empieza nodo:491 / Elemento padre: 408   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(491)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(491)).setAttribute("ancho","600" );
      ((Element)v.get(491)).setAttribute("sep","$" );
      ((Element)v.get(491)).setAttribute("x","12" );
      ((Element)v.get(491)).setAttribute("class","botonera" );
      ((Element)v.get(491)).setAttribute("y","834" );
      ((Element)v.get(491)).setAttribute("control","|" );
      ((Element)v.get(491)).setAttribute("conector","" );
      ((Element)v.get(491)).setAttribute("rowset","" );
      ((Element)v.get(491)).setAttribute("cargainicial","N" );
      ((Element)v.get(491)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(408)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(492)).setAttribute("nombre","ret1" );
      ((Element)v.get(492)).setAttribute("x","37" );
      ((Element)v.get(492)).setAttribute("y","838" );
      ((Element)v.get(492)).setAttribute("ID","botonContenido" );
      ((Element)v.get(492)).setAttribute("img","retroceder_on" );
      ((Element)v.get(492)).setAttribute("tipo","0" );
      ((Element)v.get(492)).setAttribute("estado","false" );
      ((Element)v.get(492)).setAttribute("alt","" );
      ((Element)v.get(492)).setAttribute("codigo","" );
      ((Element)v.get(492)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */

      /* Empieza nodo:493 / Elemento padre: 491   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(493)).setAttribute("nombre","ava1" );
      ((Element)v.get(493)).setAttribute("x","52" );
      ((Element)v.get(493)).setAttribute("y","838" );
      ((Element)v.get(493)).setAttribute("ID","botonContenido" );
      ((Element)v.get(493)).setAttribute("img","avanzar_on" );
      ((Element)v.get(493)).setAttribute("tipo","0" );
      ((Element)v.get(493)).setAttribute("estado","false" );
      ((Element)v.get(493)).setAttribute("alt","" );
      ((Element)v.get(493)).setAttribute("codigo","" );
      ((Element)v.get(493)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(491)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */
      /* Termina nodo:491   */
      /* Termina nodo:408   */

      /* Empieza nodo:494 / Elemento padre: 24   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(494)).setAttribute("nombre","primera1" );
      ((Element)v.get(494)).setAttribute("x","20" );
      ((Element)v.get(494)).setAttribute("y","838" );
      ((Element)v.get(494)).setAttribute("ID","botonContenido" );
      ((Element)v.get(494)).setAttribute("img","primera_on" );
      ((Element)v.get(494)).setAttribute("tipo","-2" );
      ((Element)v.get(494)).setAttribute("estado","false" );
      ((Element)v.get(494)).setAttribute("alt","" );
      ((Element)v.get(494)).setAttribute("codigo","" );
      ((Element)v.get(494)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(24)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */

      /* Empieza nodo:495 / Elemento padre: 24   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(495)).setAttribute("nombre","separa" );
      ((Element)v.get(495)).setAttribute("x","59" );
      ((Element)v.get(495)).setAttribute("y","834" );
      ((Element)v.get(495)).setAttribute("ID","botonContenido" );
      ((Element)v.get(495)).setAttribute("img","separa_base" );
      ((Element)v.get(495)).setAttribute("tipo","0" );
      ((Element)v.get(495)).setAttribute("estado","false" );
      ((Element)v.get(495)).setAttribute("alt","" );
      ((Element)v.get(495)).setAttribute("codigo","" );
      ((Element)v.get(495)).setAttribute("accion","" );
      ((Element)v.get(24)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */

      /* Empieza nodo:496 / Elemento padre: 24   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(496)).setAttribute("nombre","Modificar" );
      ((Element)v.get(496)).setAttribute("x","80" );
      ((Element)v.get(496)).setAttribute("y","835" );
      ((Element)v.get(496)).setAttribute("ID","botonContenido" );
      ((Element)v.get(496)).setAttribute("img","" );
      ((Element)v.get(496)).setAttribute("tipo","html" );
      ((Element)v.get(496)).setAttribute("estado","false" );
      ((Element)v.get(496)).setAttribute("alt","" );
      ((Element)v.get(496)).setAttribute("cod","2" );
      ((Element)v.get(496)).setAttribute("accion","onClickModificar();" );
      ((Element)v.get(496)).setAttribute("ontab","setTabFocus('Modificar');" );
      ((Element)v.get(496)).setAttribute("onshtab","setSHTabFocus('Modificar');" );
      ((Element)v.get(24)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */

      /* Empieza nodo:497 / Elemento padre: 24   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(497)).setAttribute("nombre","Eliminar" );
      ((Element)v.get(497)).setAttribute("x","146" );
      ((Element)v.get(497)).setAttribute("y","835" );
      ((Element)v.get(497)).setAttribute("ID","botonContenido" );
      ((Element)v.get(497)).setAttribute("img","" );
      ((Element)v.get(497)).setAttribute("tipo","html" );
      ((Element)v.get(497)).setAttribute("estado","false" );
      ((Element)v.get(497)).setAttribute("alt","" );
      ((Element)v.get(497)).setAttribute("cod","1254" );
      ((Element)v.get(497)).setAttribute("accion","onClickEliminar();" );
      ((Element)v.get(497)).setAttribute("ontab","setTabFocus('Eliminar');" );
      ((Element)v.get(497)).setAttribute("onshtab","setSHTabFocus('Eliminar');" );
      ((Element)v.get(24)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */

      /* Empieza nodo:498 / Elemento padre: 24   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(498)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(498)).setAttribute("alto","12" );
      ((Element)v.get(498)).setAttribute("ancho","50" );
      ((Element)v.get(498)).setAttribute("colorf","" );
      ((Element)v.get(498)).setAttribute("borde","0" );
      ((Element)v.get(498)).setAttribute("imagenf","" );
      ((Element)v.get(498)).setAttribute("repeat","" );
      ((Element)v.get(498)).setAttribute("padding","" );
      ((Element)v.get(498)).setAttribute("visibilidad","visible" );
      ((Element)v.get(498)).setAttribute("contravsb","" );
      ((Element)v.get(498)).setAttribute("x","0" );
      ((Element)v.get(498)).setAttribute("y","857" );
      ((Element)v.get(498)).setAttribute("zindex","" );
      ((Element)v.get(24)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:24   */

      /* Empieza nodo:499 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(499)).setAttribute("nombre","frmContenidoEnvia" );
      ((Element)v.get(499)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(500)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(500)).setAttribute("valor","" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */

      /* Empieza nodo:501 / Elemento padre: 499   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(501)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(501)).setAttribute("valor","" );
      ((Element)v.get(499)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */

      /* Empieza nodo:502 / Elemento padre: 499   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(502)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(502)).setAttribute("valor","" );
      ((Element)v.get(499)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */

      /* Empieza nodo:503 / Elemento padre: 499   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(499)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:499   */


   }

}

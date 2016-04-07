
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_campos_parametrizables_modificar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_campos_parametrizables_modificar" );
      ((Element)v.get(0)).setAttribute("cod","0371" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Modificar Campos Obligatorios" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag(); datosPrevios();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","contenido_campos_parametrizables_modificar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","LPBusquedaConfiguracionCampos" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","hCasoDeUso" );
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
      ((Element)v.get(10)).setAttribute("nombre","hTipoCampo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hNombreCampo" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hObligatorio" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hModificable" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hTipoCliente" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hSubtipoCliente" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hOID" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hOidIdioma" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hOidPais" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","exito" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(22)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(22)).setAttribute("x","0" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("y","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("table"));
      ((Element)v.get(23)).setAttribute("width","100%" );
      ((Element)v.get(23)).setAttribute("border","0" );
      ((Element)v.get(23)).setAttribute("cellspacing","0" );
      ((Element)v.get(23)).setAttribute("cellpadding","0" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("align","center" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(26)).setAttribute("height","12" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","750" );
      ((Element)v.get(24)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).setAttribute("width","12" );
      ((Element)v.get(24)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).setAttribute("width","12" );
      ((Element)v.get(30)).setAttribute("height","1" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */
      /* Termina nodo:24   */

      /* Empieza nodo:31 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(36)).setAttribute("class","legend" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(37)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(37)).setAttribute("alto","13" );
      ((Element)v.get(37)).setAttribute("filas","1" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(37)).setAttribute("id","legend" );
      ((Element)v.get(37)).setAttribute("cod","0075" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("table"));
      ((Element)v.get(38)).setAttribute("width","100%" );
      ((Element)v.get(38)).setAttribute("border","0" );
      ((Element)v.get(38)).setAttribute("align","center" );
      ((Element)v.get(38)).setAttribute("cellspacing","0" );
      ((Element)v.get(38)).setAttribute("cellpadding","0" );
      ((Element)v.get(35)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("table"));
      ((Element)v.get(41)).setAttribute("width","677" );
      ((Element)v.get(41)).setAttribute("border","0" );
      ((Element)v.get(41)).setAttribute("align","left" );
      ((Element)v.get(41)).setAttribute("cellspacing","0" );
      ((Element)v.get(41)).setAttribute("cellpadding","0" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).setAttribute("colspan","3" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","8" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:45 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","8" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("height","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(49)).setAttribute("nombre","lblTipoCampo" );
      ((Element)v.get(49)).setAttribute("alto","13" );
      ((Element)v.get(49)).setAttribute("filas","1" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(49)).setAttribute("id","datosTitle" );
      ((Element)v.get(49)).setAttribute("cod","1361" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","25" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(53)).setAttribute("nombre","capaLblTipoCLiente" );
      ((Element)v.get(53)).setAttribute("alto","50" );
      ((Element)v.get(53)).setAttribute("ancho","100%" );
      ((Element)v.get(53)).setAttribute("colorf","" );
      ((Element)v.get(53)).setAttribute("borde","0" );
      ((Element)v.get(53)).setAttribute("imagenf","" );
      ((Element)v.get(53)).setAttribute("repeat","" );
      ((Element)v.get(53)).setAttribute("padding","" );
      ((Element)v.get(53)).setAttribute("visibilidad","visible" );
      ((Element)v.get(53)).setAttribute("contravsb","" );
      ((Element)v.get(53)).setAttribute("x","160" );
      ((Element)v.get(53)).setAttribute("y","30" );
      ((Element)v.get(53)).setAttribute("zindex","" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("table"));
      ((Element)v.get(54)).setAttribute("width","100%" );
      ((Element)v.get(54)).setAttribute("border","0" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(57)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(57)).setAttribute("alto","13" );
      ((Element)v.get(57)).setAttribute("filas","1" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("id","datosTitle" );
      ((Element)v.get(57)).setAttribute("cod","1869" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:58 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","25" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(61)).setAttribute("nombre","capaLblSubTipoCLiente" );
      ((Element)v.get(61)).setAttribute("alto","50" );
      ((Element)v.get(61)).setAttribute("ancho","100%" );
      ((Element)v.get(61)).setAttribute("colorf","" );
      ((Element)v.get(61)).setAttribute("borde","0" );
      ((Element)v.get(61)).setAttribute("imagenf","" );
      ((Element)v.get(61)).setAttribute("repeat","" );
      ((Element)v.get(61)).setAttribute("padding","" );
      ((Element)v.get(61)).setAttribute("visibilidad","visible" );
      ((Element)v.get(61)).setAttribute("contravsb","" );
      ((Element)v.get(61)).setAttribute("x","620" );
      ((Element)v.get(61)).setAttribute("y","30" );
      ((Element)v.get(61)).setAttribute("zindex","" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("table"));
      ((Element)v.get(62)).setAttribute("width","100%" );
      ((Element)v.get(62)).setAttribute("border","0" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(65)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(65)).setAttribute("alto","13" );
      ((Element)v.get(65)).setAttribute("filas","1" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(65)).setAttribute("id","datosTitle" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(65)).setAttribute("cod","595" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:66 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","100%" );
      ((Element)v.get(45)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:45   */

      /* Empieza nodo:68 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
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
      ((Element)v.get(71)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(68)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(72)).setAttribute("nombre","cbTipoCampo" );
      ((Element)v.get(72)).setAttribute("id","datosCampos" );
      ((Element)v.get(72)).setAttribute("size","1" );
      ((Element)v.get(72)).setAttribute("multiple","N" );
      ((Element)v.get(72)).setAttribute("req","N" );
      ((Element)v.get(72)).setAttribute("valorinicial","" );
      ((Element)v.get(72)).setAttribute("textoinicial","" );
      ((Element)v.get(72)).setAttribute("onchange","completarComboNombreCampo();habilitacionCombosCli();" );
      ((Element)v.get(72)).setAttribute("ontab","setTabFocus('cbTipoCampo');" );
      ((Element)v.get(72)).setAttribute("onshtab","setSHTabFocus('cbTipoCampo');" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:74 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","25" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(68)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(77)).setAttribute("nombre","capaCbTipoCLiente" );
      ((Element)v.get(77)).setAttribute("alto","50" );
      ((Element)v.get(77)).setAttribute("ancho","100%" );
      ((Element)v.get(77)).setAttribute("colorf","" );
      ((Element)v.get(77)).setAttribute("borde","0" );
      ((Element)v.get(77)).setAttribute("imagenf","" );
      ((Element)v.get(77)).setAttribute("repeat","" );
      ((Element)v.get(77)).setAttribute("padding","" );
      ((Element)v.get(77)).setAttribute("visibilidad","visible" );
      ((Element)v.get(77)).setAttribute("contravsb","" );
      ((Element)v.get(77)).setAttribute("x","160" );
      ((Element)v.get(77)).setAttribute("y","43" );
      ((Element)v.get(77)).setAttribute("zindex","" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("table"));
      ((Element)v.get(78)).setAttribute("width","100%" );
      ((Element)v.get(78)).setAttribute("border","0" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(81)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(81)).setAttribute("id","datosCampos" );
      ((Element)v.get(81)).setAttribute("size","1" );
      ((Element)v.get(81)).setAttribute("multiple","N" );
      ((Element)v.get(81)).setAttribute("req","N" );
      ((Element)v.get(81)).setAttribute("valorinicial","" );
      ((Element)v.get(81)).setAttribute("textoinicial","" );
      ((Element)v.get(81)).setAttribute("onchange","completarComboSubtipoCliente();" );
      ((Element)v.get(81)).setAttribute("ontab","setTabFocus('cbTipoCliente');" );
      ((Element)v.get(81)).setAttribute("onshtab","setSHTabFocus('cbTipoCliente');" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:83 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","25" );
      ((Element)v.get(84)).setAttribute("height","8" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(68)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(86)).setAttribute("nombre","capaCbSubTipoCLiente" );
      ((Element)v.get(86)).setAttribute("alto","50" );
      ((Element)v.get(86)).setAttribute("ancho","100%" );
      ((Element)v.get(86)).setAttribute("colorf","" );
      ((Element)v.get(86)).setAttribute("borde","0" );
      ((Element)v.get(86)).setAttribute("imagenf","" );
      ((Element)v.get(86)).setAttribute("repeat","" );
      ((Element)v.get(86)).setAttribute("padding","" );
      ((Element)v.get(86)).setAttribute("visibilidad","visible" );
      ((Element)v.get(86)).setAttribute("contravsb","" );
      ((Element)v.get(86)).setAttribute("x","620" );
      ((Element)v.get(86)).setAttribute("y","43" );
      ((Element)v.get(86)).setAttribute("zindex","" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("table"));
      ((Element)v.get(87)).setAttribute("width","100%" );
      ((Element)v.get(87)).setAttribute("border","0" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(90)).setAttribute("nombre","cbSubTipoCliente" );
      ((Element)v.get(90)).setAttribute("id","datosCampos" );
      ((Element)v.get(90)).setAttribute("size","1" );
      ((Element)v.get(90)).setAttribute("multiple","N" );
      ((Element)v.get(90)).setAttribute("req","N" );
      ((Element)v.get(90)).setAttribute("valorinicial","" );
      ((Element)v.get(90)).setAttribute("textoinicial","" );
      ((Element)v.get(90)).setAttribute("ontab","setTabFocus('cbSubTipoCliente');" );
      ((Element)v.get(90)).setAttribute("onshtab","setSHTabFocus('cbSubTipoCliente');" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:92 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("width","100%" );
      ((Element)v.get(68)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:68   */

      /* Empieza nodo:94 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("colspan","3" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","7" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:97 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("table"));
      ((Element)v.get(99)).setAttribute("width","677" );
      ((Element)v.get(99)).setAttribute("border","0" );
      ((Element)v.get(99)).setAttribute("align","left" );
      ((Element)v.get(99)).setAttribute("cellspacing","0" );
      ((Element)v.get(99)).setAttribute("cellpadding","0" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","8" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(104)).setAttribute("nombre","lblNombreCampo" );
      ((Element)v.get(104)).setAttribute("alto","13" );
      ((Element)v.get(104)).setAttribute("filas","1" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(104)).setAttribute("id","datosTitle" );
      ((Element)v.get(104)).setAttribute("cod","1285" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(100)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","25" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(108)).setAttribute("nombre","lblIngresoObligatorio" );
      ((Element)v.get(108)).setAttribute("alto","13" );
      ((Element)v.get(108)).setAttribute("filas","1" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(108)).setAttribute("id","datosTitle" );
      ((Element)v.get(108)).setAttribute("cod","1362" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","25" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(112)).setAttribute("nombre","lblModificableporUsuario" );
      ((Element)v.get(112)).setAttribute("alto","13" );
      ((Element)v.get(112)).setAttribute("filas","1" );
      ((Element)v.get(112)).setAttribute("valor","" );
      ((Element)v.get(112)).setAttribute("id","datosTitle" );
      ((Element)v.get(112)).setAttribute("cod","1363" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","100%" );
      ((Element)v.get(100)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:100   */

      /* Empieza nodo:115 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).appendChild((Element)v.get(115));

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
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(119)).setAttribute("nombre","cbNombreCampo" );
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(119)).setAttribute("size","1" );
      ((Element)v.get(119)).setAttribute("multiple","N" );
      ((Element)v.get(119)).setAttribute("req","N" );
      ((Element)v.get(119)).setAttribute("valorinicial","" );
      ((Element)v.get(119)).setAttribute("textoinicial","" );
      ((Element)v.get(119)).setAttribute("ontab","setTabFocus('cbNombreCampo');" );
      ((Element)v.get(119)).setAttribute("onshtab","setSHTabFocus('cbNombreCampo');" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:121 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","25" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("class","datosCampos" );
      ((Element)v.get(115)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("table"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(124)).setAttribute("border","0" );
      ((Element)v.get(124)).setAttribute("cellspacing","0" );
      ((Element)v.get(124)).setAttribute("cellpadding","0" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(126)).setAttribute("nombre","IngresoObligatorio" );
      ((Element)v.get(126)).setAttribute("tipo","H" );
      ((Element)v.get(126)).setAttribute("id","datosCampos" );
      ((Element)v.get(126)).setAttribute("ontab","setTabFocus('IngresoObligatorio');" );
      ((Element)v.get(126)).setAttribute("onshtab","setSHTabFocus('IngresoObligatorio');" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(127)).setAttribute("valor","S" );
      ((Element)v.get(127)).setAttribute("check","N" );
      ((Element)v.get(127)).setAttribute("onfocus","" );
      ((Element)v.get(127)).setAttribute("id","datosCampos" );
      ((Element)v.get(127)).setAttribute("cod","117" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Elemento padre:127 / Elemento actual: 128   */
      v.add(doc.createTextNode("S"));
      ((Element)v.get(127)).appendChild((Text)v.get(128));

      /* Termina nodo Texto:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 126   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(129)).setAttribute("valor","N" );
      ((Element)v.get(129)).setAttribute("onfocus","" );
      ((Element)v.get(129)).setAttribute("id","datosCampos" );
      ((Element)v.get(129)).setAttribute("cod","87" );
      ((Element)v.get(126)).appendChild((Element)v.get(129));

      /* Elemento padre:129 / Elemento actual: 130   */
      v.add(doc.createTextNode("N"));
      ((Element)v.get(129)).appendChild((Text)v.get(130));

      /* Termina nodo Texto:130   */
      /* Termina nodo:129   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:131 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","25" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("class","datosCampos" );
      ((Element)v.get(115)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("table"));
      ((Element)v.get(134)).setAttribute("width","100%" );
      ((Element)v.get(134)).setAttribute("border","0" );
      ((Element)v.get(134)).setAttribute("cellspacing","0" );
      ((Element)v.get(134)).setAttribute("cellpadding","0" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(136)).setAttribute("nombre","ModificableporUsuario" );
      ((Element)v.get(136)).setAttribute("tipo","H" );
      ((Element)v.get(136)).setAttribute("id","datosCampos" );
      ((Element)v.get(136)).setAttribute("ontab","setTabFocus('ModificableporUsuario');" );
      ((Element)v.get(136)).setAttribute("onshtab","setSHTabFocus('ModificableporUsuario');" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(137)).setAttribute("valor","S" );
      ((Element)v.get(137)).setAttribute("check","N" );
      ((Element)v.get(137)).setAttribute("onfocus","" );
      ((Element)v.get(137)).setAttribute("id","datosCampos" );
      ((Element)v.get(137)).setAttribute("cod","117" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Elemento padre:137 / Elemento actual: 138   */
      v.add(doc.createTextNode("S"));
      ((Element)v.get(137)).appendChild((Text)v.get(138));

      /* Termina nodo Texto:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(139)).setAttribute("valor","N" );
      ((Element)v.get(139)).setAttribute("onfocus","" );
      ((Element)v.get(139)).setAttribute("id","datosCampos" );
      ((Element)v.get(139)).setAttribute("cod","87" );
      ((Element)v.get(136)).appendChild((Element)v.get(139));

      /* Elemento padre:139 / Elemento actual: 140   */
      v.add(doc.createTextNode("N"));
      ((Element)v.get(139)).appendChild((Text)v.get(140));

      /* Termina nodo Texto:140   */
      /* Termina nodo:139   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:141 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(115)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:115   */

      /* Empieza nodo:143 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("colspan","3" );
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
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:146 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("table"));
      ((Element)v.get(148)).setAttribute("width","677" );
      ((Element)v.get(148)).setAttribute("border","0" );
      ((Element)v.get(148)).setAttribute("align","left" );
      ((Element)v.get(148)).setAttribute("cellspacing","0" );
      ((Element)v.get(148)).setAttribute("cellpadding","0" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(153)).setAttribute("nombre","capaLblValorDefecto" );
      ((Element)v.get(153)).setAttribute("alto","50" );
      ((Element)v.get(153)).setAttribute("ancho","100%" );
      ((Element)v.get(153)).setAttribute("colorf","" );
      ((Element)v.get(153)).setAttribute("borde","0" );
      ((Element)v.get(153)).setAttribute("imagenf","" );
      ((Element)v.get(153)).setAttribute("repeat","" );
      ((Element)v.get(153)).setAttribute("padding","" );
      ((Element)v.get(153)).setAttribute("visibilidad","visible" );
      ((Element)v.get(153)).setAttribute("contravsb","" );
      ((Element)v.get(153)).setAttribute("x","24" );
      ((Element)v.get(153)).setAttribute("y","109" );
      ((Element)v.get(153)).setAttribute("zindex","" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("table"));
      ((Element)v.get(154)).setAttribute("width","100%" );
      ((Element)v.get(154)).setAttribute("border","0" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(157)).setAttribute("nombre","lblValorPorDefecto" );
      ((Element)v.get(157)).setAttribute("alto","13" );
      ((Element)v.get(157)).setAttribute("filas","1" );
      ((Element)v.get(157)).setAttribute("valor","" );
      ((Element)v.get(157)).setAttribute("id","datosTitle" );
      ((Element)v.get(157)).setAttribute("cod","1286" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:158 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("width","100%" );
      ((Element)v.get(149)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:149   */

      /* Empieza nodo:160 / Elemento padre: 148   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(148)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","8" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(160)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(164)).setAttribute("nombre","capaTxtValorDefecto" );
      ((Element)v.get(164)).setAttribute("alto","50" );
      ((Element)v.get(164)).setAttribute("ancho","100%" );
      ((Element)v.get(164)).setAttribute("colorf","" );
      ((Element)v.get(164)).setAttribute("borde","0" );
      ((Element)v.get(164)).setAttribute("imagenf","" );
      ((Element)v.get(164)).setAttribute("repeat","" );
      ((Element)v.get(164)).setAttribute("padding","" );
      ((Element)v.get(164)).setAttribute("visibilidad","visible" );
      ((Element)v.get(164)).setAttribute("contravsb","" );
      ((Element)v.get(164)).setAttribute("x","24" );
      ((Element)v.get(164)).setAttribute("y","122" );
      ((Element)v.get(164)).setAttribute("zindex","" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("table"));
      ((Element)v.get(165)).setAttribute("width","100%" );
      ((Element)v.get(165)).setAttribute("border","0" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(168)).setAttribute("nombre","txtValorPorDefecto" );
      ((Element)v.get(168)).setAttribute("id","datosCampos" );
      ((Element)v.get(168)).setAttribute("max","40" );
      ((Element)v.get(168)).setAttribute("tipo","" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(168)).setAttribute("onchange","" );
      ((Element)v.get(168)).setAttribute("req","N" );
      ((Element)v.get(168)).setAttribute("size","40" );
      ((Element)v.get(168)).setAttribute("valor","" );
      ((Element)v.get(168)).setAttribute("validacion","" );
      ((Element)v.get(168)).setAttribute("ontab","setTabFocus('txtValorPorDefecto');" );
      ((Element)v.get(168)).setAttribute("onshtab","setSHTabFocus('txtValorPorDefecto');" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:169 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).setAttribute("width","100%" );
      ((Element)v.get(160)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","8" );
      ((Element)v.get(170)).setAttribute("height","20" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:160   */

      /* Empieza nodo:171 / Elemento padre: 148   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(148)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("colspan","3" );
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
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:38   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:174 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:31   */

      /* Empieza nodo:176 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("table"));
      ((Element)v.get(181)).setAttribute("width","100%" );
      ((Element)v.get(181)).setAttribute("border","0" );
      ((Element)v.get(181)).setAttribute("align","center" );
      ((Element)v.get(181)).setAttribute("cellspacing","0" );
      ((Element)v.get(181)).setAttribute("cellpadding","0" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).setAttribute("class","botonera" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(184)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(184)).setAttribute("ID","botonContenido" );
      ((Element)v.get(184)).setAttribute("tipo","html" );
      ((Element)v.get(184)).setAttribute("accion","buscar();" );
      ((Element)v.get(184)).setAttribute("estado","false" );
      ((Element)v.get(184)).setAttribute("cod","1" );
      ((Element)v.get(184)).setAttribute("ontab","setTabFocus('btnBuscar');" );
      ((Element)v.get(184)).setAttribute("onshtab","setSHTabFocus('btnBuscar');" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:185 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","8" );
      ((Element)v.get(186)).setAttribute("height","12" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:176   */

      /* Empieza nodo:187 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).setAttribute("width","12" );
      ((Element)v.get(188)).setAttribute("align","center" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","12" );
      ((Element)v.get(189)).setAttribute("height","12" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("width","756" );
      ((Element)v.get(187)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).setAttribute("width","12" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(187)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","12" );
      ((Element)v.get(193)).setAttribute("height","1" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:187   */
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:194 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(194)).setAttribute("nombre","listado1" );
      ((Element)v.get(194)).setAttribute("ancho","680" );
      ((Element)v.get(194)).setAttribute("alto","317" );
      ((Element)v.get(194)).setAttribute("x","12" );
      ((Element)v.get(194)).setAttribute("y","203" );
      ((Element)v.get(194)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(194)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(195)).setAttribute("precarga","S" );
      ((Element)v.get(195)).setAttribute("conROver","S" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(196)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(196)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(196)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(196)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 195   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(197)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(197)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(197)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(197)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(195)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 195   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(198)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(198)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(195)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:195   */

      /* Empieza nodo:199 / Elemento padre: 194   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(194)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(200)).setAttribute("borde","1" );
      ((Element)v.get(200)).setAttribute("horizDatos","1" );
      ((Element)v.get(200)).setAttribute("horizCabecera","1" );
      ((Element)v.get(200)).setAttribute("vertical","1" );
      ((Element)v.get(200)).setAttribute("horizTitulo","1" );
      ((Element)v.get(200)).setAttribute("horizBase","1" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 199   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(201)).setAttribute("borde","#999999" );
      ((Element)v.get(201)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(201)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(201)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(201)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(201)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(201)).setAttribute("horizBase","#999999" );
      ((Element)v.get(199)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:199   */

      /* Empieza nodo:202 / Elemento padre: 194   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(202)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(202)).setAttribute("alto","22" );
      ((Element)v.get(202)).setAttribute("imgFondo","" );
      ((Element)v.get(202)).setAttribute("cod","00135" );
      ((Element)v.get(202)).setAttribute("ID","datosTitle" );
      ((Element)v.get(194)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 194   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(203)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(203)).setAttribute("alto","22" );
      ((Element)v.get(203)).setAttribute("imgFondo","" );
      ((Element)v.get(194)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 194   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(204)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(204)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(204)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(204)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(204)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(204)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(194)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(205)).setAttribute("ancho","20" );
      ((Element)v.get(205)).setAttribute("minimizable","S" );
      ((Element)v.get(205)).setAttribute("minimizada","N" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("ancho","20" );
      ((Element)v.get(206)).setAttribute("minimizable","S" );
      ((Element)v.get(206)).setAttribute("minimizada","N" );
      ((Element)v.get(204)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("ancho","20" );
      ((Element)v.get(207)).setAttribute("minimizable","S" );
      ((Element)v.get(207)).setAttribute("minimizada","N" );
      ((Element)v.get(204)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(208)).setAttribute("ancho","40" );
      ((Element)v.get(208)).setAttribute("minimizable","S" );
      ((Element)v.get(208)).setAttribute("minimizada","N" );
      ((Element)v.get(204)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(209)).setAttribute("ancho","40" );
      ((Element)v.get(209)).setAttribute("minimizable","S" );
      ((Element)v.get(209)).setAttribute("minimizada","N" );
      ((Element)v.get(204)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */

      /* Empieza nodo:210 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("ancho","20" );
      ((Element)v.get(210)).setAttribute("minimizable","S" );
      ((Element)v.get(210)).setAttribute("minimizada","N" );
      ((Element)v.get(204)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:204   */

      /* Empieza nodo:211 / Elemento padre: 194   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(211)).setAttribute("alto","20" );
      ((Element)v.get(211)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(211)).setAttribute("imgFondo","" );
      ((Element)v.get(211)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(194)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("colFondo","" );
      ((Element)v.get(212)).setAttribute("ID","EstCab" );
      ((Element)v.get(212)).setAttribute("cod","1869" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 211   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(213)).setAttribute("colFondo","" );
      ((Element)v.get(213)).setAttribute("ID","EstCab" );
      ((Element)v.get(213)).setAttribute("cod","595" );
      ((Element)v.get(211)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 211   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("colFondo","" );
      ((Element)v.get(214)).setAttribute("ID","EstCab" );
      ((Element)v.get(214)).setAttribute("cod","1285" );
      ((Element)v.get(211)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 211   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(215)).setAttribute("colFondo","" );
      ((Element)v.get(215)).setAttribute("ID","EstCab" );
      ((Element)v.get(215)).setAttribute("cod","1362" );
      ((Element)v.get(211)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 211   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("colFondo","" );
      ((Element)v.get(216)).setAttribute("ID","EstCab" );
      ((Element)v.get(216)).setAttribute("cod","1363" );
      ((Element)v.get(211)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 211   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("colFondo","" );
      ((Element)v.get(217)).setAttribute("ID","EstCab" );
      ((Element)v.get(217)).setAttribute("cod","1286" );
      ((Element)v.get(211)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:211   */

      /* Empieza nodo:218 / Elemento padre: 194   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(218)).setAttribute("alto","22" );
      ((Element)v.get(218)).setAttribute("accion","" );
      ((Element)v.get(218)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(218)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(218)).setAttribute("maxSel","-1" );
      ((Element)v.get(218)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(218)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(218)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(218)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(194)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(219)).setAttribute("tipo","texto" );
      ((Element)v.get(219)).setAttribute("ID","EstDat" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(220)).setAttribute("tipo","texto" );
      ((Element)v.get(220)).setAttribute("ID","EstDat2" );
      ((Element)v.get(218)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(221)).setAttribute("tipo","texto" );
      ((Element)v.get(221)).setAttribute("ID","EstDat" );
      ((Element)v.get(218)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("tipo","texto" );
      ((Element)v.get(222)).setAttribute("ID","EstDat2" );
      ((Element)v.get(218)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(223)).setAttribute("tipo","texto" );
      ((Element)v.get(223)).setAttribute("ID","EstDat" );
      ((Element)v.get(218)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("tipo","texto" );
      ((Element)v.get(224)).setAttribute("ID","EstDat2" );
      ((Element)v.get(218)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:218   */

      /* Empieza nodo:225 / Elemento padre: 194   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(194)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 194   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(226)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(226)).setAttribute("onload","procesarPaginado(mipgndo1,msgError, ultima, rowset, 'transformarLista(rowset)');" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(226)).setAttribute("ancho","680" );
      ((Element)v.get(226)).setAttribute("sep","$" );
      ((Element)v.get(226)).setAttribute("x","12" );
      ((Element)v.get(226)).setAttribute("class","botonera" );
      ((Element)v.get(226)).setAttribute("y","497" );
      ((Element)v.get(226)).setAttribute("control","|" );
      ((Element)v.get(226)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(226)).setAttribute("rowset","" );
      ((Element)v.get(226)).setAttribute("cargainicial","N" );
      ((Element)v.get(194)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(227)).setAttribute("nombre","ret1" );
      ((Element)v.get(227)).setAttribute("x","37" );
      ((Element)v.get(227)).setAttribute("y","501" );
      ((Element)v.get(227)).setAttribute("ID","botonContenido" );
      ((Element)v.get(227)).setAttribute("img","retroceder_on" );
      ((Element)v.get(227)).setAttribute("tipo","0" );
      ((Element)v.get(227)).setAttribute("estado","false" );
      ((Element)v.get(227)).setAttribute("alt","" );
      ((Element)v.get(227)).setAttribute("codigo","" );
      ((Element)v.get(227)).setAttribute("accion","mipgndo1.retroceder();" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 226   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(228)).setAttribute("nombre","ava1" );
      ((Element)v.get(228)).setAttribute("x","52" );
      ((Element)v.get(228)).setAttribute("y","501" );
      ((Element)v.get(228)).setAttribute("ID","botonContenido" );
      ((Element)v.get(228)).setAttribute("img","avanzar_on" );
      ((Element)v.get(228)).setAttribute("tipo","0" );
      ((Element)v.get(228)).setAttribute("estado","false" );
      ((Element)v.get(228)).setAttribute("alt","" );
      ((Element)v.get(228)).setAttribute("codigo","" );
      ((Element)v.get(228)).setAttribute("accion","mipgndo1.avanzar();" );
      ((Element)v.get(226)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:226   */
      /* Termina nodo:194   */

      /* Empieza nodo:229 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(229)).setAttribute("nombre","primera1" );
      ((Element)v.get(229)).setAttribute("x","20" );
      ((Element)v.get(229)).setAttribute("y","501" );
      ((Element)v.get(229)).setAttribute("ID","botonContenido" );
      ((Element)v.get(229)).setAttribute("img","primera_on" );
      ((Element)v.get(229)).setAttribute("tipo","-2" );
      ((Element)v.get(229)).setAttribute("estado","false" );
      ((Element)v.get(229)).setAttribute("alt","" );
      ((Element)v.get(229)).setAttribute("codigo","" );
      ((Element)v.get(229)).setAttribute("accion","mipgndo1.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(230)).setAttribute("nombre","Modificar" );
      ((Element)v.get(230)).setAttribute("x","80" );
      ((Element)v.get(230)).setAttribute("y","498" );
      ((Element)v.get(230)).setAttribute("ID","botonContenido" );
      ((Element)v.get(230)).setAttribute("img","" );
      ((Element)v.get(230)).setAttribute("tipo","html" );
      ((Element)v.get(230)).setAttribute("estado","false" );
      ((Element)v.get(230)).setAttribute("alt","" );
      ((Element)v.get(230)).setAttribute("cod","2" );
      ((Element)v.get(230)).setAttribute("accion","modificar();" );
      ((Element)v.get(230)).setAttribute("ontab","setTabFocus('Modificar');" );
      ((Element)v.get(230)).setAttribute("onshtab","setSHTabFocus('Modificar');" );
      ((Element)v.get(6)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(231)).setAttribute("nombre","Consultar" );
      ((Element)v.get(231)).setAttribute("x","80" );
      ((Element)v.get(231)).setAttribute("y","498" );
      ((Element)v.get(231)).setAttribute("ID","botonContenido" );
      ((Element)v.get(231)).setAttribute("img","" );
      ((Element)v.get(231)).setAttribute("tipo","html" );
      ((Element)v.get(231)).setAttribute("estado","false" );
      ((Element)v.get(231)).setAttribute("alt","" );
      ((Element)v.get(231)).setAttribute("cod","3" );
      ((Element)v.get(231)).setAttribute("accion","consultar();" );
      ((Element)v.get(231)).setAttribute("ontab","setTabFocus('Consultar');" );
      ((Element)v.get(231)).setAttribute("onshtab","setSHTabFocus('Consultar');" );
      ((Element)v.get(6)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(232)).setAttribute("nombre","capaEspacio2" );
      ((Element)v.get(232)).setAttribute("alto","18" );
      ((Element)v.get(232)).setAttribute("ancho","100" );
      ((Element)v.get(232)).setAttribute("colorf","" );
      ((Element)v.get(232)).setAttribute("borde","0" );
      ((Element)v.get(232)).setAttribute("imagenf","" );
      ((Element)v.get(232)).setAttribute("repeat","" );
      ((Element)v.get(232)).setAttribute("padding","" );
      ((Element)v.get(232)).setAttribute("visibilidad","visible" );
      ((Element)v.get(232)).setAttribute("contravsb","" );
      ((Element)v.get(232)).setAttribute("x","0" );
      ((Element)v.get(232)).setAttribute("y","520" );
      ((Element)v.get(232)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(233)).setAttribute("nombre","capaListaOcultaNC" );
      ((Element)v.get(233)).setAttribute("alto","100%" );
      ((Element)v.get(233)).setAttribute("ancho","100%" );
      ((Element)v.get(233)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(233)).setAttribute("borde","0" );
      ((Element)v.get(233)).setAttribute("imagenf","" );
      ((Element)v.get(233)).setAttribute("repeat","" );
      ((Element)v.get(233)).setAttribute("padding","" );
      ((Element)v.get(233)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(233)).setAttribute("contravsb","" );
      ((Element)v.get(233)).setAttribute("x","0" );
      ((Element)v.get(233)).setAttribute("y","460" );
      ((Element)v.get(233)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(234)).setAttribute("seleccion","boton" );
      ((Element)v.get(234)).setAttribute("nombre","listaOcultaNC" );
      ((Element)v.get(234)).setAttribute("ancho","580" );
      ((Element)v.get(234)).setAttribute("alto","100" );
      ((Element)v.get(234)).setAttribute("entradax","" );
      ((Element)v.get(234)).setAttribute("entraday","" );
      ((Element)v.get(234)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(234)).setAttribute("oncolor","" );
      ((Element)v.get(234)).setAttribute("chkcolor","" );
      ((Element)v.get(234)).setAttribute("visibilidad","" );
      ((Element)v.get(234)).setAttribute("incx","10" );
      ((Element)v.get(234)).setAttribute("incy","10" );
      ((Element)v.get(234)).setAttribute("nmin","" );
      ((Element)v.get(234)).setAttribute("nmax","1" );
      ((Element)v.get(234)).setAttribute("multisel","1" );
      ((Element)v.get(234)).setAttribute("accion","" );
      ((Element)v.get(234)).setAttribute("sep","|" );
      ((Element)v.get(234)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(234)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(234)).setAttribute("pixelsborde","1" );
      ((Element)v.get(234)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(234)).setAttribute("onSetDatos","" );
      ((Element)v.get(234)).setAttribute("blockImg","" );
      ((Element)v.get(234)).setAttribute("x","12" );
      ((Element)v.get(234)).setAttribute("y","0" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(235)).setAttribute("nombre","cab1" );
      ((Element)v.get(235)).setAttribute("height","20" );
      ((Element)v.get(235)).setAttribute("ancho","662" );
      ((Element)v.get(235)).setAttribute("colorf","#CCCCCC" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(236)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(236)).setAttribute("ancho","13" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 235   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(237)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(237)).setAttribute("ancho","230" );
      ((Element)v.get(235)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(238)).setAttribute("nombre","lblElementoCampoCliProd" );
      ((Element)v.get(238)).setAttribute("ancho","230" );
      ((Element)v.get(238)).setAttribute("alto","20" );
      ((Element)v.get(238)).setAttribute("filas","1" );
      ((Element)v.get(238)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(238)).setAttribute("cod","1285" );
      ((Element)v.get(238)).setAttribute("enviaroculto","N" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 235   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(239)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(239)).setAttribute("ancho","230" );
      ((Element)v.get(235)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(240)).setAttribute("nombre","lblTipoCliProd" );
      ((Element)v.get(240)).setAttribute("ancho","230" );
      ((Element)v.get(240)).setAttribute("alto","20" );
      ((Element)v.get(240)).setAttribute("filas","1" );
      ((Element)v.get(240)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(240)).setAttribute("cod","755" );
      ((Element)v.get(240)).setAttribute("enviaroculto","N" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:235   */

      /* Empieza nodo:241 / Elemento padre: 234   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(241)).setAttribute("ancho","1383" );
      ((Element)v.get(241)).setAttribute("filas","1" );
      ((Element)v.get(241)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(234)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(242)).setAttribute("ancho","13" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(243)).setAttribute("ancho","230" );
      ((Element)v.get(243)).setAttribute("caracteres","20" );
      ((Element)v.get(241)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(244)).setAttribute("ancho","230" );
      ((Element)v.get(244)).setAttribute("caracteres","20" );
      ((Element)v.get(241)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:241   */

      /* Empieza nodo:245 / Elemento padre: 234   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(234)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:246 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(246)).setAttribute("nombre","capaListaOcultaSTC" );
      ((Element)v.get(246)).setAttribute("alto","100%" );
      ((Element)v.get(246)).setAttribute("ancho","100%" );
      ((Element)v.get(246)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(246)).setAttribute("borde","0" );
      ((Element)v.get(246)).setAttribute("imagenf","" );
      ((Element)v.get(246)).setAttribute("repeat","" );
      ((Element)v.get(246)).setAttribute("padding","" );
      ((Element)v.get(246)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(246)).setAttribute("contravsb","" );
      ((Element)v.get(246)).setAttribute("x","0" );
      ((Element)v.get(246)).setAttribute("y","565" );
      ((Element)v.get(246)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(247)).setAttribute("seleccion","boton" );
      ((Element)v.get(247)).setAttribute("nombre","listaOcultaSTC" );
      ((Element)v.get(247)).setAttribute("ancho","580" );
      ((Element)v.get(247)).setAttribute("alto","100" );
      ((Element)v.get(247)).setAttribute("entradax","" );
      ((Element)v.get(247)).setAttribute("entraday","" );
      ((Element)v.get(247)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(247)).setAttribute("oncolor","" );
      ((Element)v.get(247)).setAttribute("chkcolor","" );
      ((Element)v.get(247)).setAttribute("visibilidad","" );
      ((Element)v.get(247)).setAttribute("incx","10" );
      ((Element)v.get(247)).setAttribute("incy","10" );
      ((Element)v.get(247)).setAttribute("nmin","" );
      ((Element)v.get(247)).setAttribute("nmax","1" );
      ((Element)v.get(247)).setAttribute("multisel","1" );
      ((Element)v.get(247)).setAttribute("accion","" );
      ((Element)v.get(247)).setAttribute("sep","|" );
      ((Element)v.get(247)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(247)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(247)).setAttribute("pixelsborde","1" );
      ((Element)v.get(247)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(247)).setAttribute("onSetDatos","" );
      ((Element)v.get(247)).setAttribute("blockImg","" );
      ((Element)v.get(247)).setAttribute("x","12" );
      ((Element)v.get(247)).setAttribute("y","0" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(248)).setAttribute("nombre","cab2" );
      ((Element)v.get(248)).setAttribute("height","20" );
      ((Element)v.get(248)).setAttribute("ancho","662" );
      ((Element)v.get(248)).setAttribute("colorf","#CCCCCC" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(249)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(249)).setAttribute("ancho","13" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(250)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(250)).setAttribute("ancho","230" );
      ((Element)v.get(248)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(251)).setAttribute("nombre","lblValueTipoCliente" );
      ((Element)v.get(251)).setAttribute("ancho","230" );
      ((Element)v.get(251)).setAttribute("alto","20" );
      ((Element)v.get(251)).setAttribute("filas","1" );
      ((Element)v.get(251)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(251)).setAttribute("cod","393" );
      ((Element)v.get(251)).setAttribute("enviaroculto","N" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(252)).setAttribute("ancho","230" );
      ((Element)v.get(248)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(253)).setAttribute("nombre","lblElementoSubtipoCliente" );
      ((Element)v.get(253)).setAttribute("ancho","230" );
      ((Element)v.get(253)).setAttribute("alto","20" );
      ((Element)v.get(253)).setAttribute("filas","1" );
      ((Element)v.get(253)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(253)).setAttribute("cod","595" );
      ((Element)v.get(253)).setAttribute("enviaroculto","N" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:248   */

      /* Empieza nodo:254 / Elemento padre: 247   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(254)).setAttribute("ancho","1383" );
      ((Element)v.get(254)).setAttribute("filas","1" );
      ((Element)v.get(254)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(247)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("ancho","13" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 254   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(256)).setAttribute("ancho","230" );
      ((Element)v.get(256)).setAttribute("caracteres","20" );
      ((Element)v.get(254)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 254   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("ancho","230" );
      ((Element)v.get(257)).setAttribute("caracteres","20" );
      ((Element)v.get(254)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:254   */

      /* Empieza nodo:258 / Elemento padre: 247   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(247)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:6   */


   }

}

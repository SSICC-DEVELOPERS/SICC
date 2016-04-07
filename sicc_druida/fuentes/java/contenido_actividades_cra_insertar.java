
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_actividades_cra_insertar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_actividades_cra_insertar" );
      ((Element)v.get(0)).setAttribute("titulo","Insertar Actividades" );
      ((Element)v.get(0)).setAttribute("cod","050" );
      ((Element)v.get(0)).setAttribute("estilos","estilos.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","inicializacion(); posicionarCombo();inicializacionRadioB();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","contenido_actividades_cra_insertar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("ESTILO"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode(" \r                  #estcombomenorF {width:150px} \r                  #estcomboF {width:355px}\r                  #estcombo2F {width:150px}\r                  #estcombo3F {width:300px}\r         "));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmInsertarActividades" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(8)).setAttribute("valor","LPInsertarActividadCRA" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","elementosSeleccionados" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hCodigoCanal" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hCanales" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hPais" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hPaisOrigen" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hMarcas" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hAreaResp" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hCasoDeUso" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hComboProc" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hCodActi" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hPaisCodPais" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hMarcCodMarc" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("nombre","hCanaCodCana" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hCodActi2" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hNomActi" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hTipoAct" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hCactCodActi" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hDpteCodDpto" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hEbel" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hCantProcAsig" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hDiasDesp" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hTipoDia" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hVProcAsig" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hTProcAsig" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hVProcDisp" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hTProcDisp" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(37)).setAttribute("nombre","capaPaisMarcaCanal" );
      ((Element)v.get(37)).setAttribute("alto","600" );
      ((Element)v.get(37)).setAttribute("ancho","590" );
      ((Element)v.get(37)).setAttribute("colorf","" );
      ((Element)v.get(37)).setAttribute("borde","0" );
      ((Element)v.get(37)).setAttribute("imagenf","" );
      ((Element)v.get(37)).setAttribute("repeat","" );
      ((Element)v.get(37)).setAttribute("padding","" );
      ((Element)v.get(37)).setAttribute("visibilidad","visible" );
      ((Element)v.get(37)).setAttribute("contravsb","" );
      ((Element)v.get(37)).setAttribute("x","10" );
      ((Element)v.get(37)).setAttribute("y","10" );
      ((Element)v.get(37)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(38)).setAttribute("width","590" );
      ((Element)v.get(38)).setAttribute("border","0" );
      ((Element)v.get(38)).setAttribute("cellspacing","0" );
      ((Element)v.get(38)).setAttribute("cellpadding","0" );
      ((Element)v.get(38)).setAttribute("align","left" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(40)).setAttribute("align","center" );
      ((Element)v.get(40)).setAttribute("width","0" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","0" );
      ((Element)v.get(41)).setAttribute("height","0" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(42)).setAttribute("width","590" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(39)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 39   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(43)).setAttribute("width","0" );
      ((Element)v.get(39)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","0" );
      ((Element)v.get(44)).setAttribute("height","0" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:39   */

      /* Empieza nodo:45 / Elemento padre: 38   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(38)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(46)).setAttribute("align","center" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 45   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(45)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(48)).setAttribute("width","100%" );
      ((Element)v.get(48)).setAttribute("border","1" );
      ((Element)v.get(48)).setAttribute("cellspacing","1" );
      ((Element)v.get(48)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).setAttribute("bordercolor","#CCCCCC" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(51)).setAttribute("width","98%" );
      ((Element)v.get(51)).setAttribute("border","0" );
      ((Element)v.get(51)).setAttribute("cellspacing","0" );
      ((Element)v.get(51)).setAttribute("cellpadding","0" );
      ((Element)v.get(51)).setAttribute("align","left" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(53)).setAttribute("class","datosCampos" );
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
      v.add(doc.createElement("TR"));
      ((Element)v.get(51)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(56)).setAttribute("width","120" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(57)).setAttribute("nombre","lbl_pais" );
      ((Element)v.get(57)).setAttribute("alto","30" );
      ((Element)v.get(57)).setAttribute("ancho","150" );
      ((Element)v.get(57)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(57)).setAttribute("texto","" );
      ((Element)v.get(57)).setAttribute("filas","" );
      ((Element)v.get(57)).setAttribute("cod","154" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(58)).setAttribute("width","1%" );
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 55   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(60)).setAttribute("width","98%" );
      ((Element)v.get(55)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(61)).setAttribute("textoinicial","" );
      ((Element)v.get(61)).setAttribute("valorinicial","" );
      ((Element)v.get(61)).setAttribute("req","N" );
      ((Element)v.get(61)).setAttribute("multiple","N" );
      ((Element)v.get(61)).setAttribute("id","estcombo" );
      ((Element)v.get(61)).setAttribute("size","1" );
      ((Element)v.get(61)).setAttribute("nombre","cbPais" );
      ((Element)v.get(61)).setAttribute("readonly","N" );
      ((Element)v.get(61)).setAttribute("onchange","canalSeleccionado();" );
      ((Element)v.get(61)).setAttribute("onshtab","focaliza('frmInsertarActividades.cbProcDisp');" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:55   */

      /* Empieza nodo:63 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(51)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(64)).setAttribute("width","120" );
      ((Element)v.get(64)).setAttribute("valign","top" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(65)).setAttribute("nombre","lbl_marca" );
      ((Element)v.get(65)).setAttribute("alto","30" );
      ((Element)v.get(65)).setAttribute("ancho","150" );
      ((Element)v.get(65)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(65)).setAttribute("texto","" );
      ((Element)v.get(65)).setAttribute("filas","" );
      ((Element)v.get(65)).setAttribute("cod","165" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 63   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(66)).setAttribute("width","1%" );
      ((Element)v.get(63)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 63   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(68)).setAttribute("width","98%" );
      ((Element)v.get(63)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(69)).setAttribute("nombre","cboMarcas" );
      ((Element)v.get(69)).setAttribute("size","5" );
      ((Element)v.get(69)).setAttribute("multiple","N" );
      ((Element)v.get(69)).setAttribute("req","N" );
      ((Element)v.get(69)).setAttribute("id","estcombo" );
      ((Element)v.get(69)).setAttribute("onchange","canalSeleccionado();" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:63   */

      /* Empieza nodo:71 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(51)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(72)).setAttribute("width","120" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 71   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(73)).setAttribute("width","1%" );
      ((Element)v.get(71)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","8" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 71   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(75)).setAttribute("width","98%" );
      ((Element)v.get(71)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(79)).setAttribute("nombre","txtTodas" );
      ((Element)v.get(79)).setAttribute("class","" );
      ((Element)v.get(79)).setAttribute("id","txtTodas" );
      ((Element)v.get(79)).setAttribute("max","1" );
      ((Element)v.get(79)).setAttribute("tipo","" );
      ((Element)v.get(79)).setAttribute("onchange","" );
      ((Element)v.get(79)).setAttribute("req","N" );
      ((Element)v.get(79)).setAttribute("size","1" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(79)).setAttribute("validacion","" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 77   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(80)).setAttribute("width","95" );
      ((Element)v.get(80)).setAttribute("align","left" );
      ((Element)v.get(77)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(81)).setAttribute("nombre","etiqueta13" );
      ((Element)v.get(81)).setAttribute("ancho","150" );
      ((Element)v.get(81)).setAttribute("alto","30" );
      ((Element)v.get(81)).setAttribute("filas","1" );
      ((Element)v.get(81)).setAttribute("id","datosTitleLeft" );
      ((Element)v.get(81)).setAttribute("cod","777" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(81)).setAttribute("enviaroculto","N" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:71   */

      /* Empieza nodo:82 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(51)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(83)).setAttribute("width","120" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(84)).setAttribute("nombre","lbl_canal" );
      ((Element)v.get(84)).setAttribute("alto","30" );
      ((Element)v.get(84)).setAttribute("ancho","150" );
      ((Element)v.get(84)).setAttribute("id","datosTitle" );
      ((Element)v.get(84)).setAttribute("texto","" );
      ((Element)v.get(84)).setAttribute("filas","" );
      ((Element)v.get(84)).setAttribute("cod","166" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 82   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(85)).setAttribute("width","1%" );
      ((Element)v.get(82)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 82   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(87)).setAttribute("width","98%" );
      ((Element)v.get(82)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(88)).setAttribute("textoinicial","" );
      ((Element)v.get(88)).setAttribute("valorinicial","" );
      ((Element)v.get(88)).setAttribute("req","N" );
      ((Element)v.get(88)).setAttribute("multiple","N" );
      ((Element)v.get(88)).setAttribute("size","1" );
      ((Element)v.get(88)).setAttribute("id","estcombo" );
      ((Element)v.get(88)).setAttribute("nombre","cboCanales" );
      ((Element)v.get(88)).setAttribute("onchange","canalSeleccionado();" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:82   */

      /* Empieza nodo:90 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(51)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(91)).setAttribute("width","120" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(92)).setAttribute("nombre","lbl_cdActividad" );
      ((Element)v.get(92)).setAttribute("alto","30" );
      ((Element)v.get(92)).setAttribute("ancho","150" );
      ((Element)v.get(92)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(92)).setAttribute("texto","" );
      ((Element)v.get(92)).setAttribute("filas","" );
      ((Element)v.get(92)).setAttribute("cod","799" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 90   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(93)).setAttribute("width","1%" );
      ((Element)v.get(90)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","8" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 90   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(95)).setAttribute("width","98%" );
      ((Element)v.get(90)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(96)).setAttribute("nombre","txtcdActividad" );
      ((Element)v.get(96)).setAttribute("class","datosCampos" );
      ((Element)v.get(96)).setAttribute("id","txtcdActividad" );
      ((Element)v.get(96)).setAttribute("max","2" );
      ((Element)v.get(96)).setAttribute("tipo","" );
      ((Element)v.get(96)).setAttribute("onchange","" );
      ((Element)v.get(96)).setAttribute("req","N" );
      ((Element)v.get(96)).setAttribute("size","2" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(96)).setAttribute("validacion","" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:90   */

      /* Empieza nodo:97 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(51)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(98)).setAttribute("width","120" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(99)).setAttribute("nombre","lbl_desActividad" );
      ((Element)v.get(99)).setAttribute("alto","30" );
      ((Element)v.get(99)).setAttribute("ancho","150" );
      ((Element)v.get(99)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(99)).setAttribute("texto","" );
      ((Element)v.get(99)).setAttribute("filas","" );
      ((Element)v.get(99)).setAttribute("cod","800" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(100)).setAttribute("width","1%" );
      ((Element)v.get(97)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 97   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(102)).setAttribute("width","98%" );
      ((Element)v.get(97)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(103)).setAttribute("nombre","txtdesActividad" );
      ((Element)v.get(103)).setAttribute("class","datosCampos" );
      ((Element)v.get(103)).setAttribute("id","txTDesActividad" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(103)).setAttribute("max","40" );
      ((Element)v.get(103)).setAttribute("tipo","" );
      ((Element)v.get(103)).setAttribute("onchange","" );
      ((Element)v.get(103)).setAttribute("req","N" );
      ((Element)v.get(103)).setAttribute("size","65" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(103)).setAttribute("validacion","" );
      ((Element)v.get(103)).setAttribute("onshtab","focalizaDesc()" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:97   */

      /* Empieza nodo:104 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(51)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(105)).setAttribute("width","120" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(106)).setAttribute("nombre","lbl_tipoActividad" );
      ((Element)v.get(106)).setAttribute("alto","30" );
      ((Element)v.get(106)).setAttribute("ancho","150" );
      ((Element)v.get(106)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(106)).setAttribute("texto","" );
      ((Element)v.get(106)).setAttribute("filas","" );
      ((Element)v.get(106)).setAttribute("cod","801" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(107)).setAttribute("width","1%" );
      ((Element)v.get(104)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 104   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(109)).setAttribute("width","98%" );
      ((Element)v.get(104)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(110)).setAttribute("textoinicial","" );
      ((Element)v.get(110)).setAttribute("valorinicial","" );
      ((Element)v.get(110)).setAttribute("req","N" );
      ((Element)v.get(110)).setAttribute("multiple","N" );
      ((Element)v.get(110)).setAttribute("size","1" );
      ((Element)v.get(110)).setAttribute("id","estcombomenor" );
      ((Element)v.get(110)).setAttribute("nombre","cboTpAct" );
      ((Element)v.get(110)).setAttribute("onchange","deshabilitarActRef();revisionActividadOrigen();" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(112)).setAttribute("ID","1" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(113)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(113)).setAttribute("TIPO","STRING" );
      ((Element)v.get(113)).setAttribute("VALOR","0" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 112   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(114)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(114)).setAttribute("TIPO","STRING" );
      ((Element)v.get(114)).setAttribute("VALOR","Fija" );
      ((Element)v.get(112)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:112   */

      /* Empieza nodo:115 / Elemento padre: 111   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(115)).setAttribute("ID","2" );
      ((Element)v.get(111)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(116)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(116)).setAttribute("TIPO","STRING" );
      ((Element)v.get(116)).setAttribute("VALOR","1" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 115   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(117)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(117)).setAttribute("TIPO","STRING" );
      ((Element)v.get(117)).setAttribute("VALOR","con Actividad Origen" );
      ((Element)v.get(115)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:115   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:104   */

      /* Empieza nodo:118 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(51)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(119)).setAttribute("width","120" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(120)).setAttribute("nombre","lbl_actividadRef" );
      ((Element)v.get(120)).setAttribute("alto","30" );
      ((Element)v.get(120)).setAttribute("ancho","150" );
      ((Element)v.get(120)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(120)).setAttribute("texto","" );
      ((Element)v.get(120)).setAttribute("filas","" );
      ((Element)v.get(120)).setAttribute("cod","2464" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 118   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(121)).setAttribute("width","1%" );
      ((Element)v.get(118)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 118   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(123)).setAttribute("width","98%" );
      ((Element)v.get(118)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(124)).setAttribute("nombre","txtActRef" );
      ((Element)v.get(124)).setAttribute("class","datosCampos" );
      ((Element)v.get(124)).setAttribute("id","txtEjemplo" );
      ((Element)v.get(124)).setAttribute("max","2" );
      ((Element)v.get(124)).setAttribute("tipo","" );
      ((Element)v.get(124)).setAttribute("onchange","" );
      ((Element)v.get(124)).setAttribute("req","N" );
      ((Element)v.get(124)).setAttribute("size","2" );
      ((Element)v.get(124)).setAttribute("valor","" );
      ((Element)v.get(124)).setAttribute("validacion","" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:118   */

      /* Empieza nodo:125 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(51)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(126)).setAttribute("width","120" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(127)).setAttribute("nombre","lbl_tipo_dias" );
      ((Element)v.get(127)).setAttribute("alto","30" );
      ((Element)v.get(127)).setAttribute("ancho","150" );
      ((Element)v.get(127)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(127)).setAttribute("texto","" );
      ((Element)v.get(127)).setAttribute("filas","" );
      ((Element)v.get(127)).setAttribute("cod","2466" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 125   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(128)).setAttribute("width","1%" );
      ((Element)v.get(125)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","8" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 125   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(130)).setAttribute("width","140" );
      ((Element)v.get(130)).setAttribute("class","datosCampos" );
      ((Element)v.get(130)).setAttribute("aligne","left" );
      ((Element)v.get(125)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(131)).setAttribute("nombre","rbTipoDias" );
      ((Element)v.get(131)).setAttribute("tipo","H" );
      ((Element)v.get(131)).setAttribute("req","N" );
      ((Element)v.get(131)).setAttribute("id","B00" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(132)).setAttribute("valor","L" );
      ((Element)v.get(132)).setAttribute("check","S" );
      ((Element)v.get(132)).setAttribute("onfocus","" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Elemento padre:132 / Elemento actual: 133   */
      v.add(doc.createTextNode("Laborable"));
      ((Element)v.get(132)).appendChild((Text)v.get(133));

      /* Termina nodo Texto:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 131   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(134)).setAttribute("valor","C" );
      ((Element)v.get(134)).setAttribute("check","N" );
      ((Element)v.get(134)).setAttribute("focus","" );
      ((Element)v.get(131)).appendChild((Element)v.get(134));

      /* Elemento padre:134 / Elemento actual: 135   */
      v.add(doc.createTextNode("Continuo"));
      ((Element)v.get(134)).appendChild((Text)v.get(135));

      /* Termina nodo Texto:135   */
      /* Termina nodo:134   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:125   */

      /* Empieza nodo:136 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(51)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(137)).setAttribute("width","120" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(138)).setAttribute("nombre","lbl_dias" );
      ((Element)v.get(138)).setAttribute("alto","30" );
      ((Element)v.get(138)).setAttribute("ancho","150" );
      ((Element)v.get(138)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(138)).setAttribute("texto","" );
      ((Element)v.get(138)).setAttribute("filas","" );
      ((Element)v.get(138)).setAttribute("cod","2019" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(139)).setAttribute("width","1%" );
      ((Element)v.get(136)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","8" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(141)).setAttribute("width","98%" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(136)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(142)).setAttribute("nombre","txtDias" );
      ((Element)v.get(142)).setAttribute("class","datosCampos" );
      ((Element)v.get(142)).setAttribute("id","txtDias" );
      ((Element)v.get(142)).setAttribute("max","5" );
      ((Element)v.get(142)).setAttribute("tipo","" );
      ((Element)v.get(142)).setAttribute("onchange","" );
      ((Element)v.get(142)).setAttribute("req","N" );
      ((Element)v.get(142)).setAttribute("size","6" );
      ((Element)v.get(142)).setAttribute("valor","" );
      ((Element)v.get(142)).setAttribute("validacion","fValidarNumero(valor,5,0,99999)" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:136   */

      /* Empieza nodo:143 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(51)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(144)).setAttribute("width","180" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(145)).setAttribute("nombre","lbl_ebelNoticias" );
      ((Element)v.get(145)).setAttribute("alto","30" );
      ((Element)v.get(145)).setAttribute("ancho","150" );
      ((Element)v.get(145)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(145)).setAttribute("texto","" );
      ((Element)v.get(145)).setAttribute("filas","" );
      ((Element)v.get(145)).setAttribute("cod","804" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 143   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(146)).setAttribute("width","1%" );
      ((Element)v.get(143)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 143   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(148)).setAttribute("width","77" );
      ((Element)v.get(148)).setAttribute("class","datosCampos" );
      ((Element)v.get(143)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(149)).setAttribute("nombre","RebelNoticias" );
      ((Element)v.get(149)).setAttribute("tipo","H" );
      ((Element)v.get(149)).setAttribute("req","N" );
      ((Element)v.get(149)).setAttribute("id","B00" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(150)).setAttribute("valor","S" );
      ((Element)v.get(150)).setAttribute("check","N" );
      ((Element)v.get(150)).setAttribute("onfocus","" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Elemento padre:150 / Elemento actual: 151   */
      v.add(doc.createTextNode("Si"));
      ((Element)v.get(150)).appendChild((Text)v.get(151));

      /* Termina nodo Texto:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 149   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(152)).setAttribute("valor","N" );
      ((Element)v.get(152)).setAttribute("check","S" );
      ((Element)v.get(152)).setAttribute("onfocus","" );
      ((Element)v.get(149)).appendChild((Element)v.get(152));

      /* Elemento padre:152 / Elemento actual: 153   */
      v.add(doc.createTextNode("No"));
      ((Element)v.get(152)).appendChild((Text)v.get(153));

      /* Termina nodo Texto:153   */
      /* Termina nodo:152   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:143   */

      /* Empieza nodo:154 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(51)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(155)).setAttribute("width","120" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(156)).setAttribute("nombre","lbl_areaResp" );
      ((Element)v.get(156)).setAttribute("alto","30" );
      ((Element)v.get(156)).setAttribute("ancho","150" );
      ((Element)v.get(156)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(156)).setAttribute("texto","" );
      ((Element)v.get(156)).setAttribute("filas","" );
      ((Element)v.get(156)).setAttribute("cod","803" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(157)).setAttribute("width","1%" );
      ((Element)v.get(154)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","8" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(159)).setAttribute("width","98%" );
      ((Element)v.get(154)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(160)).setAttribute("textoinicial","" );
      ((Element)v.get(160)).setAttribute("valorinicial","" );
      ((Element)v.get(160)).setAttribute("id","estcombo3" );
      ((Element)v.get(160)).setAttribute("req","N" );
      ((Element)v.get(160)).setAttribute("multiple","N" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(160)).setAttribute("size","1" );
      ((Element)v.get(160)).setAttribute("nombre","cboAreaResp" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:154   */

      /* Empieza nodo:162 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(51)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 162   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(164)).setAttribute("width","1%" );
      ((Element)v.get(162)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("witdh","8" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 162   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(166)).setAttribute("width","98%" );
      ((Element)v.get(162)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(169)).setAttribute("valign","top" );
      ((Element)v.get(169)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(169)).setAttribute("width","120" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(170)).setAttribute("nombre","lbl_procesosAsig" );
      ((Element)v.get(170)).setAttribute("alto","30" );
      ((Element)v.get(170)).setAttribute("ancho","130" );
      ((Element)v.get(170)).setAttribute("id","datosTitleCenter" );
      ((Element)v.get(170)).setAttribute("texto","" );
      ((Element)v.get(170)).setAttribute("filas","" );
      ((Element)v.get(170)).setAttribute("cod","805" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 168   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(171)).setAttribute("width","20" );
      ((Element)v.get(171)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(168)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 168   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(173)).setAttribute("valign","top" );
      ((Element)v.get(173)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(173)).setAttribute("width","140" );
      ((Element)v.get(168)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(174)).setAttribute("nombre","lbl_procesosDisp" );
      ((Element)v.get(174)).setAttribute("alto","30" );
      ((Element)v.get(174)).setAttribute("ancho","145" );
      ((Element)v.get(174)).setAttribute("id","datosTitleCenter" );
      ((Element)v.get(174)).setAttribute("texto","" );
      ((Element)v.get(174)).setAttribute("filas","" );
      ((Element)v.get(174)).setAttribute("cod","806" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:168   */

      /* Empieza nodo:175 / Elemento padre: 167   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(175)).setAttribute("height","60" );
      ((Element)v.get(167)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(176)).setAttribute("valign","top" );
      ((Element)v.get(176)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(176)).setAttribute("style","" );
      ((Element)v.get(176)).setAttribute("width","120" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(177)).setAttribute("req","N" );
      ((Element)v.get(177)).setAttribute("multiple","S" );
      ((Element)v.get(177)).setAttribute("size","5" );
      ((Element)v.get(177)).setAttribute("id","estcombo2" );
      ((Element)v.get(177)).setAttribute("nombre","cbProcAsig" );
      ((Element)v.get(177)).setAttribute("ontab","focaliza('frmInsertarActividades.cbProcDisp');" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:179 / Elemento padre: 175   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(179)).setAttribute("align","center" );
      ((Element)v.get(179)).setAttribute("width","20" );
      ((Element)v.get(175)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(180)).setAttribute("bgcolor","" );
      ((Element)v.get(180)).setAttribute("width","20" );
      ((Element)v.get(180)).setAttribute("border","0" );
      ((Element)v.get(180)).setAttribute("cellspacing","0" );
      ((Element)v.get(180)).setAttribute("cellpadding","0" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(182)).setAttribute("class","tablaTitle" );
      ((Element)v.get(182)).setAttribute("align","center" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(183)).setAttribute("cod","1049" );
      ((Element)v.get(183)).setAttribute("estado","false" );
      ((Element)v.get(183)).setAttribute("accion","agregando();" );
      ((Element)v.get(183)).setAttribute("tipo","html" );
      ((Element)v.get(183)).setAttribute("ID","BotonContenido" );
      ((Element)v.get(183)).setAttribute("nombre","btnAgregar" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:184 / Elemento padre: 180   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(180)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("TD"));
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

      /* Empieza nodo:187 / Elemento padre: 180   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(180)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(188)).setAttribute("class","tablaTitle" );
      ((Element)v.get(188)).setAttribute("align","center" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(189)).setAttribute("cod","1050" );
      ((Element)v.get(189)).setAttribute("estado","false" );
      ((Element)v.get(189)).setAttribute("accion","eliminando();" );
      ((Element)v.get(189)).setAttribute("tipo","html" );
      ((Element)v.get(189)).setAttribute("ID","BotonContenido" );
      ((Element)v.get(189)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:190 / Elemento padre: 175   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(190)).setAttribute("valign","top" );
      ((Element)v.get(190)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(190)).setAttribute("style","" );
      ((Element)v.get(190)).setAttribute("width","140" );
      ((Element)v.get(175)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(191)).setAttribute("req","N" );
      ((Element)v.get(191)).setAttribute("multiple","S" );
      ((Element)v.get(191)).setAttribute("size","5" );
      ((Element)v.get(191)).setAttribute("id","estcombo2" );
      ((Element)v.get(191)).setAttribute("nombre","cbProcDisp" );
      ((Element)v.get(191)).setAttribute("ontab","focalizaUltimo();" );
      ((Element)v.get(191)).setAttribute("onshtab","focaliza('frmInsertarActividades.cbProcAsig');" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(193)).setAttribute("ID","1" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:175   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:162   */

      /* Empieza nodo:194 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(51)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(195)).setAttribute("class","datosCampos" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","8" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:45   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:6   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_usuario_consultar  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML2250(doc);
         

      getXML2340(doc);
         

      getXML2430(doc);
         

      getXML2520(doc);
         

      getXML2610(doc);
         

      getXML2700(doc);
         

      getXML2790(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_usuario_consultar" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilos.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","inicializar();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("cod","06" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","contenido_usuarios_consultar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(3)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(4)).setAttribute("nombre","accion" );
      ((Element)v.get(4)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","LPConsultarUsuarios" );
      ((Element)v.get(3)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","casodeuso" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","elementosSeleccionados" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","hIndicacionClaveInicial" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hUsuarioHabilitado" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hPerfil" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hPais" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hSubgerenciaVentas" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hRegion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hZona" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hSeccion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hTerritorio" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hPaisDefecto" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hSGVDefecto" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hRegionDefecto" );
      ((Element)v.get(21)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(3)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hZonaDefecto" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hSeccionDefecto" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hTerritorioDefecto" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hDepartamento" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hSociedad" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hSociedadDefecto" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hMarca" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hMarcaDefecto" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hCanal" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hCanalDefecto" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hAcceso" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hAccesoDefecto" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hSubnivelAcceso" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hSubaccesoDefecto" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hTipoUsuario" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hRastreoAcceso" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hUsuarioSustitucion" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hFuncionDirecta" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hIndNDG" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hIndAdmNDG" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 3   */
      v.add(doc.createElement("table"));
      ((Element)v.get(43)).setAttribute("width","310" );
      ((Element)v.get(43)).setAttribute("border","0" );
      ((Element)v.get(43)).setAttribute("cellspacing","0" );
      ((Element)v.get(43)).setAttribute("cellpadding","0" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(43)).setAttribute("align","left" );
      ((Element)v.get(3)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).setAttribute("width","12" );
      ((Element)v.get(45)).setAttribute("align","center" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","12" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("width","776" );
      ((Element)v.get(44)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","12" );
      ((Element)v.get(44)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","12" );
      ((Element)v.get(49)).setAttribute("height","1" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:44   */

      /* Empieza nodo:50 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("align","center" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("table"));
      ((Element)v.get(53)).setAttribute("width","100%" );
      ((Element)v.get(53)).setAttribute("border","1" );
      ((Element)v.get(53)).setAttribute("cellspacing","1" );
      ((Element)v.get(53)).setAttribute("cellpadding","0" );
      ((Element)v.get(53)).setAttribute("bordercolor","#CCCCCC" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("table"));
      ((Element)v.get(56)).setAttribute("width","98%" );
      ((Element)v.get(56)).setAttribute("border","0" );
      ((Element)v.get(56)).setAttribute("cellspacing","0" );
      ((Element)v.get(56)).setAttribute("cellpadding","0" );
      ((Element)v.get(56)).setAttribute("align","center" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("colspan","11" );
      ((Element)v.get(58)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(58)).setAttribute("class","datosCampos" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:60 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(62)).setAttribute("nombre","lblIdentificadorUsuarioT" );
      ((Element)v.get(62)).setAttribute("ancho","120" );
      ((Element)v.get(62)).setAttribute("alto","30" );
      ((Element)v.get(62)).setAttribute("filas","1" );
      ((Element)v.get(62)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(62)).setAttribute("cod","136" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(62)).setAttribute("enviaroculto","N" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("colspan","5" );
      ((Element)v.get(65)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(60)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(66)).setAttribute("nombre","lblIdentificadorUsuario" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(66)).setAttribute("ancho","160" );
      ((Element)v.get(66)).setAttribute("alto","20" );
      ((Element)v.get(66)).setAttribute("filas","1" );
      ((Element)v.get(66)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("colspan","4" );
      ((Element)v.get(60)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:60   */

      /* Empieza nodo:69 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(71)).setAttribute("nombre","lblIndicacionClaveInicialT" );
      ((Element)v.get(71)).setAttribute("ancho","120" );
      ((Element)v.get(71)).setAttribute("alto","30" );
      ((Element)v.get(71)).setAttribute("filas","1" );
      ((Element)v.get(71)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(71)).setAttribute("cod","22" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(71)).setAttribute("enviaroculto","N" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","8" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("colspan","5" );
      ((Element)v.get(74)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(69)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(75)).setAttribute("nombre","lblIndicacionClaveInicial" );
      ((Element)v.get(75)).setAttribute("ancho","160" );
      ((Element)v.get(75)).setAttribute("alto","20" );
      ((Element)v.get(75)).setAttribute("filas","1" );
      ((Element)v.get(75)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("colspan","4" );
      ((Element)v.get(69)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","8" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:69   */

      /* Empieza nodo:78 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("width","105" );
      ((Element)v.get(79)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(80)).setAttribute("nombre","lblPerfilT" );
      ((Element)v.get(80)).setAttribute("ancho","120" );
      ((Element)v.get(80)).setAttribute("alto","30" );
      ((Element)v.get(80)).setAttribute("filas","1" );
      ((Element)v.get(80)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(80)).setAttribute("cod","104" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(80)).setAttribute("enviaroculto","N" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(83)).setAttribute("colspan","5" );
      ((Element)v.get(78)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(84)).setAttribute("nombre","lblPerfil" );
      ((Element)v.get(84)).setAttribute("ancho","160" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(84)).setAttribute("alto","20" );
      ((Element)v.get(84)).setAttribute("filas","1" );
      ((Element)v.get(84)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("colspan","4" );
      ((Element)v.get(78)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:78   */

      /* Empieza nodo:87 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(89)).setAttribute("nombre","lblUsuarioHabilitadoT" );
      ((Element)v.get(89)).setAttribute("ancho","120" );
      ((Element)v.get(89)).setAttribute("alto","30" );
      ((Element)v.get(89)).setAttribute("filas","1" );
      ((Element)v.get(89)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(89)).setAttribute("cod","138" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(89)).setAttribute("enviaroculto","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("colspan","9" );
      ((Element)v.get(92)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(87)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(93)).setAttribute("nombre","lblUsuarioHabilitado" );
      ((Element)v.get(93)).setAttribute("ancho","160" );
      ((Element)v.get(93)).setAttribute("alto","20" );
      ((Element)v.get(93)).setAttribute("filas","1" );
      ((Element)v.get(93)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:87   */

      /* Empieza nodo:94 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("colspan","11" );
      ((Element)v.get(95)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(95)).setAttribute("class","datosCampos" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:97 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","8" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:50   */

      /* Empieza nodo:99 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("align","center" );
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
      ((Element)v.get(99)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","8" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:99   */

      /* Empieza nodo:106 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("align","center" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("table"));
      ((Element)v.get(110)).setAttribute("width","100%" );
      ((Element)v.get(110)).setAttribute("border","1" );
      ((Element)v.get(110)).setAttribute("cellspacing","1" );
      ((Element)v.get(110)).setAttribute("cellpadding","0" );
      ((Element)v.get(110)).setAttribute("bordercolor","#CCCCCC" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("table"));
      ((Element)v.get(113)).setAttribute("width","98%" );
      ((Element)v.get(113)).setAttribute("border","0" );
      ((Element)v.get(113)).setAttribute("cellspacing","0" );
      ((Element)v.get(113)).setAttribute("cellpadding","0" );
      ((Element)v.get(113)).setAttribute("align","center" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("colspan","11" );
      ((Element)v.get(115)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(115)).setAttribute("class","datosCampos" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","8" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:117 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(119)).setAttribute("nombre","lblPrimerApellidoT" );
      ((Element)v.get(119)).setAttribute("ancho","120" );
      ((Element)v.get(119)).setAttribute("alto","30" );
      ((Element)v.get(119)).setAttribute("filas","1" );
      ((Element)v.get(119)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(119)).setAttribute("cod","16" );
      ((Element)v.get(119)).setAttribute("valor","" );
      ((Element)v.get(119)).setAttribute("enviaroculto","N" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("colspan","5" );
      ((Element)v.get(122)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(117)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(123)).setAttribute("nombre","lblPrimerApellido" );
      ((Element)v.get(123)).setAttribute("ancho","180" );
      ((Element)v.get(123)).setAttribute("alto","20" );
      ((Element)v.get(123)).setAttribute("filas","1" );
      ((Element)v.get(123)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(123)).setAttribute("valor","" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("width","8" );
      ((Element)v.get(124)).setAttribute("colspan","4" );
      ((Element)v.get(117)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:117   */

      /* Empieza nodo:126 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(128)).setAttribute("nombre","lblApellidoCasadaT" );
      ((Element)v.get(128)).setAttribute("ancho","120" );
      ((Element)v.get(128)).setAttribute("alto","30" );
      ((Element)v.get(128)).setAttribute("filas","1" );
      ((Element)v.get(128)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(128)).setAttribute("cod","18" );
      ((Element)v.get(128)).setAttribute("valor","" );
      ((Element)v.get(128)).setAttribute("enviaroculto","N" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("colspan","5" );
      ((Element)v.get(131)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(126)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(132)).setAttribute("nombre","lblApellidoCasada" );
      ((Element)v.get(132)).setAttribute("ancho","180" );
      ((Element)v.get(132)).setAttribute("alto","20" );
      ((Element)v.get(132)).setAttribute("filas","1" );
      ((Element)v.get(132)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(132)).setAttribute("valor","" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("colspan","4" );
      ((Element)v.get(126)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","8" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:126   */

      /* Empieza nodo:135 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(137)).setAttribute("nombre","lblSegundoApellidoT" );
      ((Element)v.get(137)).setAttribute("ancho","120" );
      ((Element)v.get(137)).setAttribute("alto","30" );
      ((Element)v.get(137)).setAttribute("filas","1" );
      ((Element)v.get(137)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(137)).setAttribute("cod","17" );
      ((Element)v.get(137)).setAttribute("valor","" );
      ((Element)v.get(137)).setAttribute("enviaroculto","N" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","8" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("colspan","5" );
      ((Element)v.get(140)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(135)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(141)).setAttribute("nombre","lblSegundoApellido" );
      ((Element)v.get(141)).setAttribute("ancho","180" );
      ((Element)v.get(141)).setAttribute("alto","20" );
      ((Element)v.get(141)).setAttribute("filas","1" );
      ((Element)v.get(141)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(141)).setAttribute("valor","" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("colspan","4" );
      ((Element)v.get(135)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","8" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:135   */

      /* Empieza nodo:144 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("nowrap","nowrap" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(146)).setAttribute("nombre","lblPrimerNombreT" );
      ((Element)v.get(146)).setAttribute("ancho","120" );
      ((Element)v.get(146)).setAttribute("alto","30" );
      ((Element)v.get(146)).setAttribute("filas","1" );
      ((Element)v.get(146)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(146)).setAttribute("cod","93" );
      ((Element)v.get(146)).setAttribute("valor","" );
      ((Element)v.get(146)).setAttribute("enviaroculto","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","8" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("colspan","5" );
      ((Element)v.get(149)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(144)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(150)).setAttribute("nombre","lblPrimerNombre" );
      ((Element)v.get(150)).setAttribute("ancho","180" );
      ((Element)v.get(150)).setAttribute("alto","20" );
      ((Element)v.get(150)).setAttribute("filas","1" );
      ((Element)v.get(150)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(150)).setAttribute("valor","" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(151)).setAttribute("colspan","4" );
      ((Element)v.get(144)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","8" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:144   */

      /* Empieza nodo:153 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(155)).setAttribute("nombre","lblSegundoNombreT" );
      ((Element)v.get(155)).setAttribute("ancho","120" );
      ((Element)v.get(155)).setAttribute("alto","30" );
      ((Element)v.get(155)).setAttribute("filas","1" );
      ((Element)v.get(155)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(155)).setAttribute("cod","94" );
      ((Element)v.get(155)).setAttribute("valor","" );
      ((Element)v.get(155)).setAttribute("enviaroculto","N" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","8" );
      ((Element)v.get(157)).setAttribute("height","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("colspan","5" );
      ((Element)v.get(158)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(153)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(159)).setAttribute("nombre","lblSegundoNombre" );
      ((Element)v.get(159)).setAttribute("ancho","180" );
      ((Element)v.get(159)).setAttribute("alto","20" );
      ((Element)v.get(159)).setAttribute("filas","1" );
      ((Element)v.get(159)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(159)).setAttribute("valor","" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("width","8" );
      ((Element)v.get(160)).setAttribute("colspan","4" );
      ((Element)v.get(153)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","8" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:153   */

      /* Empieza nodo:162 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(164)).setAttribute("nombre","lblEMailT" );
      ((Element)v.get(164)).setAttribute("ancho","120" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(164)).setAttribute("alto","30" );
      ((Element)v.get(164)).setAttribute("filas","1" );
      ((Element)v.get(164)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(164)).setAttribute("cod","55" );
      ((Element)v.get(164)).setAttribute("valor","" );
      ((Element)v.get(164)).setAttribute("enviaroculto","N" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("width","8" );
      ((Element)v.get(162)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","8" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("colspan","5" );
      ((Element)v.get(167)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(162)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(168)).setAttribute("nombre","lblEMail" );
      ((Element)v.get(168)).setAttribute("ancho","180" );
      ((Element)v.get(168)).setAttribute("alto","20" );
      ((Element)v.get(168)).setAttribute("filas","1" );
      ((Element)v.get(168)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(168)).setAttribute("valor","" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).setAttribute("width","8" );
      ((Element)v.get(169)).setAttribute("colspan","4" );
      ((Element)v.get(162)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","8" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:162   */

      /* Empieza nodo:171 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("width","105" );
      ((Element)v.get(172)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(173)).setAttribute("nombre","lblTelefonoT" );
      ((Element)v.get(173)).setAttribute("ancho","120" );
      ((Element)v.get(173)).setAttribute("alto","30" );
      ((Element)v.get(173)).setAttribute("filas","1" );
      ((Element)v.get(173)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(173)).setAttribute("cod","125" );
      ((Element)v.get(173)).setAttribute("valor","" );
      ((Element)v.get(173)).setAttribute("enviaroculto","N" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).setAttribute("width","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","8" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("colspan","5" );
      ((Element)v.get(176)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(171)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(177)).setAttribute("nombre","lblTelefono" );
      ((Element)v.get(177)).setAttribute("ancho","180" );
      ((Element)v.get(177)).setAttribute("alto","20" );
      ((Element)v.get(177)).setAttribute("filas","1" );
      ((Element)v.get(177)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(177)).setAttribute("valor","" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).setAttribute("width","8" );
      ((Element)v.get(178)).setAttribute("colspan","4" );
      ((Element)v.get(171)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:171   */

      /* Empieza nodo:180 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(182)).setAttribute("nombre","lblDepartamentoT" );
      ((Element)v.get(182)).setAttribute("ancho","120" );
      ((Element)v.get(182)).setAttribute("alto","30" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(182)).setAttribute("filas","1" );
      ((Element)v.get(182)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(182)).setAttribute("cod","45" );
      ((Element)v.get(182)).setAttribute("valor","" );
      ((Element)v.get(182)).setAttribute("enviaroculto","N" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).setAttribute("width","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).setAttribute("colspan","5" );
      ((Element)v.get(185)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(180)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(186)).setAttribute("nombre","lblDepartamento" );
      ((Element)v.get(186)).setAttribute("ancho","160" );
      ((Element)v.get(186)).setAttribute("alto","20" );
      ((Element)v.get(186)).setAttribute("filas","1" );
      ((Element)v.get(186)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(186)).setAttribute("valor","" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).setAttribute("width","8" );
      ((Element)v.get(187)).setAttribute("colspan","4" );
      ((Element)v.get(180)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:180   */

      /* Empieza nodo:189 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("width","105" );
      ((Element)v.get(190)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(191)).setAttribute("nombre","lblIdentificadorPCT" );
      ((Element)v.get(191)).setAttribute("ancho","120" );
      ((Element)v.get(191)).setAttribute("alto","30" );
      ((Element)v.get(191)).setAttribute("filas","1" );
      ((Element)v.get(191)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(191)).setAttribute("cod","70" );
      ((Element)v.get(191)).setAttribute("valor","" );
      ((Element)v.get(191)).setAttribute("enviaroculto","N" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).setAttribute("width","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","8" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).setAttribute("colspan","5" );
      ((Element)v.get(194)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(189)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(195)).setAttribute("nombre","lblIdentificadorPC" );
      ((Element)v.get(195)).setAttribute("ancho","160" );
      ((Element)v.get(195)).setAttribute("alto","20" );
      ((Element)v.get(195)).setAttribute("filas","1" );
      ((Element)v.get(195)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(195)).setAttribute("valor","" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).setAttribute("width","8" );
      ((Element)v.get(196)).setAttribute("colspan","4" );
      ((Element)v.get(189)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:189   */

      /* Empieza nodo:198 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(200)).setAttribute("nombre","lblValidezDesdeT" );
      ((Element)v.get(200)).setAttribute("ancho","120" );
      ((Element)v.get(200)).setAttribute("alto","30" );
      ((Element)v.get(200)).setAttribute("filas","1" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(200)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(200)).setAttribute("cod","141" );
      ((Element)v.get(200)).setAttribute("valor","" );
      ((Element)v.get(200)).setAttribute("enviaroculto","N" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","8" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).setAttribute("colspan","5" );
      ((Element)v.get(203)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(198)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(204)).setAttribute("nombre","lblValidezDesde" );
      ((Element)v.get(204)).setAttribute("ancho","160" );
      ((Element)v.get(204)).setAttribute("alto","20" );
      ((Element)v.get(204)).setAttribute("filas","1" );
      ((Element)v.get(204)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(204)).setAttribute("valor","" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("width","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","8" );
      ((Element)v.get(206)).setAttribute("height","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(198)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(208)).setAttribute("nombre","lblValidezHastaT" );
      ((Element)v.get(208)).setAttribute("ancho","120" );
      ((Element)v.get(208)).setAttribute("alto","30" );
      ((Element)v.get(208)).setAttribute("filas","1" );
      ((Element)v.get(208)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(208)).setAttribute("cod","145" );
      ((Element)v.get(208)).setAttribute("valor","" );
      ((Element)v.get(208)).setAttribute("enviaroculto","N" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).setAttribute("width","8" );
      ((Element)v.get(210)).setAttribute("height","8" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(198)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(212)).setAttribute("nombre","lblValidezHasta" );
      ((Element)v.get(212)).setAttribute("ancho","150" );
      ((Element)v.get(212)).setAttribute("alto","20" );
      ((Element)v.get(212)).setAttribute("filas","1" );
      ((Element)v.get(212)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(212)).setAttribute("valor","" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:198   */

      /* Empieza nodo:213 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).setAttribute("colspan","11" );
      ((Element)v.get(214)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(214)).setAttribute("class","datosCampos" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","8" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:216 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(217)).setAttribute("width","8" );
      ((Element)v.get(217)).setAttribute("height","8" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:106   */

      /* Empieza nodo:218 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).setAttribute("align","center" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","8" );
      ((Element)v.get(220)).setAttribute("height","8" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","8" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","8" );
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:218   */

      /* Empieza nodo:225 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).setAttribute("align","center" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","8" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("table"));
      ((Element)v.get(229)).setAttribute("width","100%" );
      ((Element)v.get(229)).setAttribute("border","1" );
      ((Element)v.get(229)).setAttribute("cellspacing","1" );
      ((Element)v.get(229)).setAttribute("cellpadding","0" );
      ((Element)v.get(229)).setAttribute("bordercolor","#CCCCCC" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("table"));
      ((Element)v.get(232)).setAttribute("width","98%" );
      ((Element)v.get(232)).setAttribute("border","0" );
      ((Element)v.get(232)).setAttribute("cellspacing","0" );
      ((Element)v.get(232)).setAttribute("cellpadding","0" );
      ((Element)v.get(232)).setAttribute("align","center" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).setAttribute("colspan","11" );
      ((Element)v.get(234)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(234)).setAttribute("class","datosCampos" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","8" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:236 / Elemento padre: 232   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(232)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(238)).setAttribute("nombre","lblSociedadT" );
      ((Element)v.get(238)).setAttribute("ancho","120" );
      ((Element)v.get(238)).setAttribute("alto","30" );
      ((Element)v.get(238)).setAttribute("filas","1" );
      ((Element)v.get(238)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(238)).setAttribute("cod","120" );
      ((Element)v.get(238)).setAttribute("valor","" );
      ((Element)v.get(238)).setAttribute("enviaroculto","N" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).setAttribute("width","8" );
      ((Element)v.get(236)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","8" );
      ((Element)v.get(240)).setAttribute("height","8" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).setAttribute("colspan","5" );
      ((Element)v.get(241)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(236)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(242)).setAttribute("nombre","lblSociedad" );
      ((Element)v.get(242)).setAttribute("ancho","280" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(242)).setAttribute("alto","20" );
      ((Element)v.get(242)).setAttribute("filas","1" );
      ((Element)v.get(242)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(242)).setAttribute("valor","" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("width","8" );
      ((Element)v.get(243)).setAttribute("colspan","4" );
      ((Element)v.get(236)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","8" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:236   */

      /* Empieza nodo:245 / Elemento padre: 232   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(232)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(247)).setAttribute("nombre","lblMarcaT" );
      ((Element)v.get(247)).setAttribute("ancho","120" );
      ((Element)v.get(247)).setAttribute("alto","30" );
      ((Element)v.get(247)).setAttribute("filas","1" );
      ((Element)v.get(247)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(247)).setAttribute("cod","6" );
      ((Element)v.get(247)).setAttribute("valor","" );
      ((Element)v.get(247)).setAttribute("enviaroculto","N" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).setAttribute("width","8" );
      ((Element)v.get(245)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","8" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("colspan","5" );
      ((Element)v.get(250)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(245)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(251)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(251)).setAttribute("ancho","180" );
      ((Element)v.get(251)).setAttribute("alto","20" );
      ((Element)v.get(251)).setAttribute("filas","1" );
      ((Element)v.get(251)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(251)).setAttribute("valor","" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).setAttribute("width","8" );
      ((Element)v.get(252)).setAttribute("colspan","4" );
      ((Element)v.get(245)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","8" );
      ((Element)v.get(253)).setAttribute("height","8" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:245   */

      /* Empieza nodo:254 / Elemento padre: 232   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(232)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(255)).setAttribute("valign","top" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(256)).setAttribute("nombre","lblCanalT" );
      ((Element)v.get(256)).setAttribute("ancho","120" );
      ((Element)v.get(256)).setAttribute("alto","30" );
      ((Element)v.get(256)).setAttribute("filas","1" );
      ((Element)v.get(256)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(256)).setAttribute("cod","7" );
      ((Element)v.get(256)).setAttribute("valor","" );
      ((Element)v.get(256)).setAttribute("enviaroculto","N" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).setAttribute("width","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","8" );
      ((Element)v.get(258)).setAttribute("height","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).setAttribute("colspan","5" );
      ((Element)v.get(259)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(254)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(260)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(260)).setAttribute("ancho","200" );
      ((Element)v.get(260)).setAttribute("alto","20" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(260)).setAttribute("filas","1" );
      ((Element)v.get(260)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(260)).setAttribute("valor","" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).setAttribute("width","8" );
      ((Element)v.get(261)).setAttribute("colspan","4" );
      ((Element)v.get(254)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).setAttribute("width","8" );
      ((Element)v.get(262)).setAttribute("height","8" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:254   */

      /* Empieza nodo:263 / Elemento padre: 232   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(232)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(264)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(264)).setAttribute("valign","top" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(265)).setAttribute("nombre","lblAccesoT" );
      ((Element)v.get(265)).setAttribute("ancho","120" );
      ((Element)v.get(265)).setAttribute("alto","30" );
      ((Element)v.get(265)).setAttribute("filas","1" );
      ((Element)v.get(265)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(265)).setAttribute("cod","10" );
      ((Element)v.get(265)).setAttribute("valor","" );
      ((Element)v.get(265)).setAttribute("enviaroculto","N" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).setAttribute("width","8" );
      ((Element)v.get(263)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(267)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).setAttribute("width","8" );
      ((Element)v.get(267)).setAttribute("height","8" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).setAttribute("colspan","5" );
      ((Element)v.get(268)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(263)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(269)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(269)).setAttribute("ancho","200" );
      ((Element)v.get(269)).setAttribute("alto","20" );
      ((Element)v.get(269)).setAttribute("filas","1" );
      ((Element)v.get(269)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(269)).setAttribute("valor","" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).setAttribute("width","8" );
      ((Element)v.get(270)).setAttribute("colspan","4" );
      ((Element)v.get(263)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","8" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:263   */

      /* Empieza nodo:272 / Elemento padre: 232   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(232)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).setAttribute("width","105" );
      ((Element)v.get(273)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(273)).setAttribute("valign","top" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(274)).setAttribute("nombre","lblSubnivelAccesoT" );
      ((Element)v.get(274)).setAttribute("ancho","120" );
      ((Element)v.get(274)).setAttribute("alto","30" );
      ((Element)v.get(274)).setAttribute("filas","1" );
      ((Element)v.get(274)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(274)).setAttribute("cod","122" );
      ((Element)v.get(274)).setAttribute("valor","" );
      ((Element)v.get(274)).setAttribute("enviaroculto","N" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).setAttribute("width","8" );
      ((Element)v.get(272)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","8" );
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).setAttribute("colspan","5" );
      ((Element)v.get(277)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(272)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(278)).setAttribute("nombre","lblSubnivelAcceso" );
      ((Element)v.get(278)).setAttribute("ancho","200" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(278)).setAttribute("alto","20" );
      ((Element)v.get(278)).setAttribute("filas","1" );
      ((Element)v.get(278)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(278)).setAttribute("valor","" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).setAttribute("width","8" );
      ((Element)v.get(279)).setAttribute("colspan","4" );
      ((Element)v.get(272)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","8" );
      ((Element)v.get(280)).setAttribute("height","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */
      /* Termina nodo:272   */

      /* Empieza nodo:281 / Elemento padre: 232   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(232)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(282)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(282)).setAttribute("valign","top" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(283)).setAttribute("nombre","lblPaisT" );
      ((Element)v.get(283)).setAttribute("ancho","120" );
      ((Element)v.get(283)).setAttribute("alto","30" );
      ((Element)v.get(283)).setAttribute("filas","1" );
      ((Element)v.get(283)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(283)).setAttribute("cod","5" );
      ((Element)v.get(283)).setAttribute("valor","" );
      ((Element)v.get(283)).setAttribute("enviaroculto","N" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(284)).setAttribute("width","8" );
      ((Element)v.get(281)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","8" );
      ((Element)v.get(285)).setAttribute("height","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).setAttribute("colspan","5" );
      ((Element)v.get(286)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(281)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(287)).setAttribute("nombre","lblPais" );
      ((Element)v.get(287)).setAttribute("ancho","220" );
      ((Element)v.get(287)).setAttribute("alto","20" );
      ((Element)v.get(287)).setAttribute("filas","1" );
      ((Element)v.get(287)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(287)).setAttribute("valor","" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).setAttribute("width","8" );
      ((Element)v.get(288)).setAttribute("colspan","4" );
      ((Element)v.get(281)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","8" );
      ((Element)v.get(289)).setAttribute("height","8" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */
      /* Termina nodo:281   */

      /* Empieza nodo:290 / Elemento padre: 232   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(232)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(291)).setAttribute("valign","top" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(292)).setAttribute("nombre","lblSubgerenciaT" );
      ((Element)v.get(292)).setAttribute("ancho","120" );
      ((Element)v.get(292)).setAttribute("alto","30" );
      ((Element)v.get(292)).setAttribute("filas","1" );
      ((Element)v.get(292)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(292)).setAttribute("cod","124" );
      ((Element)v.get(292)).setAttribute("valor","" );
      ((Element)v.get(292)).setAttribute("enviaroculto","N" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:293 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).setAttribute("width","8" );
      ((Element)v.get(290)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(294)).setAttribute("src","b.gif" );
      ((Element)v.get(294)).setAttribute("width","8" );
      ((Element)v.get(294)).setAttribute("height","8" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(295)).setAttribute("colspan","5" );
      ((Element)v.get(295)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(290)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(296)).setAttribute("nombre","lblSubgerencia" );
      ((Element)v.get(296)).setAttribute("ancho","220" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(296)).setAttribute("alto","20" );
      ((Element)v.get(296)).setAttribute("filas","1" );
      ((Element)v.get(296)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(296)).setAttribute("valor","" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).setAttribute("width","8" );
      ((Element)v.get(297)).setAttribute("colspan","4" );
      ((Element)v.get(290)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).setAttribute("width","8" );
      ((Element)v.get(298)).setAttribute("height","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */
      /* Termina nodo:290   */

      /* Empieza nodo:299 / Elemento padre: 232   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(232)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(300)).setAttribute("valign","top" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(301)).setAttribute("nombre","lblRegionT" );
      ((Element)v.get(301)).setAttribute("ancho","120" );
      ((Element)v.get(301)).setAttribute("alto","30" );
      ((Element)v.get(301)).setAttribute("filas","1" );
      ((Element)v.get(301)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(301)).setAttribute("cod","109" );
      ((Element)v.get(301)).setAttribute("valor","" );
      ((Element)v.get(301)).setAttribute("enviaroculto","N" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:302 / Elemento padre: 299   */
      v.add(doc.createElement("td"));
      ((Element)v.get(302)).setAttribute("width","8" );
      ((Element)v.get(299)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(303)).setAttribute("src","b.gif" );
      ((Element)v.get(303)).setAttribute("width","8" );
      ((Element)v.get(303)).setAttribute("height","8" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:304 / Elemento padre: 299   */
      v.add(doc.createElement("td"));
      ((Element)v.get(304)).setAttribute("colspan","5" );
      ((Element)v.get(304)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(299)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(305)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(305)).setAttribute("ancho","220" );
      ((Element)v.get(305)).setAttribute("alto","20" );
      ((Element)v.get(305)).setAttribute("filas","1" );
      ((Element)v.get(305)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(305)).setAttribute("valor","" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 299   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).setAttribute("width","8" );
      ((Element)v.get(306)).setAttribute("colspan","4" );
      ((Element)v.get(299)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
      ((Element)v.get(307)).setAttribute("width","8" );
      ((Element)v.get(307)).setAttribute("height","8" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */
      /* Termina nodo:299   */

      /* Empieza nodo:308 / Elemento padre: 232   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(232)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(309)).setAttribute("valign","top" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(310)).setAttribute("nombre","lblZonaT" );
      ((Element)v.get(310)).setAttribute("ancho","120" );
      ((Element)v.get(310)).setAttribute("alto","30" );
      ((Element)v.get(310)).setAttribute("filas","1" );
      ((Element)v.get(310)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(310)).setAttribute("cod","143" );
      ((Element)v.get(310)).setAttribute("valor","" );
      ((Element)v.get(310)).setAttribute("enviaroculto","N" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:311 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).setAttribute("width","8" );
      ((Element)v.get(308)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("width","8" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(313)).setAttribute("colspan","5" );
      ((Element)v.get(313)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(308)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(314)).setAttribute("nombre","lblZona" );
      ((Element)v.get(314)).setAttribute("ancho","220" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(314)).setAttribute("alto","20" );
      ((Element)v.get(314)).setAttribute("filas","1" );
      ((Element)v.get(314)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(314)).setAttribute("valor","" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).setAttribute("width","8" );
      ((Element)v.get(315)).setAttribute("colspan","4" );
      ((Element)v.get(308)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","8" );
      ((Element)v.get(316)).setAttribute("height","8" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */
      /* Termina nodo:308   */

      /* Empieza nodo:317 / Elemento padre: 232   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(232)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(318)).setAttribute("valign","top" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(319)).setAttribute("nombre","lblSeccionT" );
      ((Element)v.get(319)).setAttribute("ancho","120" );
      ((Element)v.get(319)).setAttribute("alto","30" );
      ((Element)v.get(319)).setAttribute("filas","1" );
      ((Element)v.get(319)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(319)).setAttribute("cod","112" );
      ((Element)v.get(319)).setAttribute("valor","" );
      ((Element)v.get(319)).setAttribute("enviaroculto","N" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(320)).setAttribute("width","8" );
      ((Element)v.get(317)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(321)).setAttribute("src","b.gif" );
      ((Element)v.get(321)).setAttribute("width","8" );
      ((Element)v.get(321)).setAttribute("height","8" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:322 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(322)).setAttribute("colspan","5" );
      ((Element)v.get(322)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(317)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(323)).setAttribute("nombre","lblSeccion" );
      ((Element)v.get(323)).setAttribute("ancho","220" );
      ((Element)v.get(323)).setAttribute("alto","20" );
      ((Element)v.get(323)).setAttribute("filas","1" );
      ((Element)v.get(323)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(323)).setAttribute("valor","" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(324)).setAttribute("width","8" );
      ((Element)v.get(324)).setAttribute("colspan","4" );
      ((Element)v.get(317)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","8" );
      ((Element)v.get(325)).setAttribute("height","8" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */
      /* Termina nodo:317   */

      /* Empieza nodo:326 / Elemento padre: 232   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(232)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).setAttribute("width","105" );
      ((Element)v.get(327)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(327)).setAttribute("valign","top" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(328)).setAttribute("nombre","lblTerritorioT" );
      ((Element)v.get(328)).setAttribute("ancho","120" );
      ((Element)v.get(328)).setAttribute("alto","30" );
      ((Element)v.get(328)).setAttribute("filas","1" );
      ((Element)v.get(328)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(328)).setAttribute("cod","126" );
      ((Element)v.get(328)).setAttribute("valor","" );
      ((Element)v.get(328)).setAttribute("enviaroculto","N" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(329)).setAttribute("width","8" );
      ((Element)v.get(326)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(330)).setAttribute("width","8" );
      ((Element)v.get(330)).setAttribute("height","8" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(331)).setAttribute("colspan","5" );
      ((Element)v.get(331)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(326)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(332)).setAttribute("nombre","lblTerritorio" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(332)).setAttribute("ancho","220" );
      ((Element)v.get(332)).setAttribute("alto","20" );
      ((Element)v.get(332)).setAttribute("filas","1" );
      ((Element)v.get(332)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(332)).setAttribute("valor","" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(333)).setAttribute("width","8" );
      ((Element)v.get(333)).setAttribute("colspan","4" );
      ((Element)v.get(326)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","8" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */
      /* Termina nodo:326   */

      /* Empieza nodo:335 / Elemento padre: 232   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(232)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("td"));
      ((Element)v.get(336)).setAttribute("colspan","11" );
      ((Element)v.get(336)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(336)).setAttribute("class","datosCampos" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(337)).setAttribute("src","b.gif" );
      ((Element)v.get(337)).setAttribute("width","8" );
      ((Element)v.get(337)).setAttribute("height","8" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */
      /* Termina nodo:335   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:338 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(339)).setAttribute("src","b.gif" );
      ((Element)v.get(339)).setAttribute("width","8" );
      ((Element)v.get(339)).setAttribute("height","8" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:338   */
      /* Termina nodo:225   */

      /* Empieza nodo:340 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).setAttribute("align","center" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","8" );
      ((Element)v.get(342)).setAttribute("height","8" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 340   */
      v.add(doc.createElement("td"));
      ((Element)v.get(340)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("width","8" );
      ((Element)v.get(344)).setAttribute("height","8" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 340   */
      v.add(doc.createElement("td"));
      ((Element)v.get(340)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(346)).setAttribute("src","b.gif" );
      ((Element)v.get(346)).setAttribute("width","8" );
      ((Element)v.get(346)).setAttribute("height","8" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */
      /* Termina nodo:340   */

      /* Empieza nodo:347 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).setAttribute("align","center" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(349)).setAttribute("src","b.gif" );
      ((Element)v.get(349)).setAttribute("width","8" );
      ((Element)v.get(349)).setAttribute("height","8" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */

      /* Empieza nodo:350 / Elemento padre: 347   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("table"));
      ((Element)v.get(351)).setAttribute("width","100%" );
      ((Element)v.get(351)).setAttribute("border","1" );
      ((Element)v.get(351)).setAttribute("cellspacing","1" );
      ((Element)v.get(351)).setAttribute("cellpadding","0" );
      ((Element)v.get(351)).setAttribute("bordercolor","#CCCCCC" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("table"));
      ((Element)v.get(354)).setAttribute("width","98%" );
      ((Element)v.get(354)).setAttribute("border","0" );
      ((Element)v.get(354)).setAttribute("cellspacing","0" );
      ((Element)v.get(354)).setAttribute("cellpadding","0" );
      ((Element)v.get(354)).setAttribute("align","center" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
   }

   private void getXML1620(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(356)).setAttribute("colspan","11" );
      ((Element)v.get(356)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(356)).setAttribute("class","datosCampos" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).setAttribute("width","8" );
      ((Element)v.get(357)).setAttribute("height","8" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:355   */

      /* Empieza nodo:358 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(359)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(360)).setAttribute("nombre","lblPaisDefectoT" );
      ((Element)v.get(360)).setAttribute("ancho","190" );
      ((Element)v.get(360)).setAttribute("alto","30" );
      ((Element)v.get(360)).setAttribute("filas","1" );
      ((Element)v.get(360)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(360)).setAttribute("cod","101" );
      ((Element)v.get(360)).setAttribute("valor","" );
      ((Element)v.get(360)).setAttribute("enviaroculto","N" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:361 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).setAttribute("width","8" );
      ((Element)v.get(358)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(362)).setAttribute("width","8" );
      ((Element)v.get(362)).setAttribute("height","8" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */

      /* Empieza nodo:363 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(363)).setAttribute("colspan","5" );
      ((Element)v.get(363)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(358)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(364)).setAttribute("nombre","lblPaisDefecto" );
      ((Element)v.get(364)).setAttribute("ancho","160" );
      ((Element)v.get(364)).setAttribute("alto","20" );
      ((Element)v.get(364)).setAttribute("filas","1" );
      ((Element)v.get(364)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(364)).setAttribute("valor","" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */

      /* Empieza nodo:365 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(365)).setAttribute("width","8" );
      ((Element)v.get(365)).setAttribute("colspan","4" );
      ((Element)v.get(358)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(366)).setAttribute("src","b.gif" );
      ((Element)v.get(366)).setAttribute("width","8" );
      ((Element)v.get(366)).setAttribute("height","8" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */
      /* Termina nodo:358   */

      /* Empieza nodo:367 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(369)).setAttribute("nombre","lblSGVDefectoT" );
      ((Element)v.get(369)).setAttribute("ancho","190" );
      ((Element)v.get(369)).setAttribute("alto","30" );
      ((Element)v.get(369)).setAttribute("filas","1" );
      ((Element)v.get(369)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(369)).setAttribute("cod","166" );
      ((Element)v.get(369)).setAttribute("valor","" );
      ((Element)v.get(369)).setAttribute("enviaroculto","N" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(370)).setAttribute("width","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).setAttribute("width","8" );
      ((Element)v.get(371)).setAttribute("height","8" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:372 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).setAttribute("colspan","5" );
      ((Element)v.get(372)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(367)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(373)).setAttribute("nombre","lblSGVDefecto" );
      ((Element)v.get(373)).setAttribute("ancho","220" );
      ((Element)v.get(373)).setAttribute("alto","20" );
      ((Element)v.get(373)).setAttribute("filas","1" );
      ((Element)v.get(373)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(373)).setAttribute("valor","" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */

      /* Empieza nodo:374 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(374)).setAttribute("width","8" );
      ((Element)v.get(374)).setAttribute("colspan","4" );
      ((Element)v.get(367)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(375)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).setAttribute("width","8" );
      ((Element)v.get(375)).setAttribute("height","8" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */
      /* Termina nodo:367   */

      /* Empieza nodo:376 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(378)).setAttribute("nombre","lblRegionDefectoT" );
      ((Element)v.get(378)).setAttribute("ancho","190" );
      ((Element)v.get(378)).setAttribute("alto","30" );
      ((Element)v.get(378)).setAttribute("filas","1" );
      ((Element)v.get(378)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(378)).setAttribute("cod","110" );
      ((Element)v.get(378)).setAttribute("valor","" );
      ((Element)v.get(378)).setAttribute("enviaroculto","N" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 376   */
      v.add(doc.createElement("td"));
      ((Element)v.get(379)).setAttribute("width","8" );
      ((Element)v.get(376)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(380)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).setAttribute("width","8" );
      ((Element)v.get(380)).setAttribute("height","8" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 376   */
      v.add(doc.createElement("td"));
      ((Element)v.get(381)).setAttribute("colspan","5" );
      ((Element)v.get(381)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(376)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(382)).setAttribute("nombre","lblRegionDefecto" );
      ((Element)v.get(382)).setAttribute("ancho","220" );
      ((Element)v.get(382)).setAttribute("alto","20" );
      ((Element)v.get(382)).setAttribute("filas","1" );
      ((Element)v.get(382)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(382)).setAttribute("valor","" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:383 / Elemento padre: 376   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).setAttribute("colspan","4" );
      ((Element)v.get(383)).setAttribute("width","8" );
      ((Element)v.get(376)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(384)).setAttribute("src","b.gif" );
      ((Element)v.get(384)).setAttribute("width","8" );
      ((Element)v.get(384)).setAttribute("height","8" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */
      /* Termina nodo:376   */

      /* Empieza nodo:385 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).setAttribute("width","105" );
      ((Element)v.get(386)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(387)).setAttribute("nombre","lblZonaDefectoT" );
      ((Element)v.get(387)).setAttribute("ancho","190" );
      ((Element)v.get(387)).setAttribute("alto","30" );
      ((Element)v.get(387)).setAttribute("filas","1" );
      ((Element)v.get(387)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(387)).setAttribute("cod","144" );
      ((Element)v.get(387)).setAttribute("valor","" );
      ((Element)v.get(387)).setAttribute("enviaroculto","N" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:388 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(388)).setAttribute("width","8" );
      ((Element)v.get(385)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(389)).setAttribute("src","b.gif" );
      ((Element)v.get(389)).setAttribute("width","8" );
      ((Element)v.get(389)).setAttribute("height","8" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:390 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(390)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(385)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(391)).setAttribute("nombre","lblZonaDefecto" );
      ((Element)v.get(391)).setAttribute("ancho","220" );
      ((Element)v.get(391)).setAttribute("alto","20" );
      ((Element)v.get(391)).setAttribute("filas","1" );
      ((Element)v.get(391)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(391)).setAttribute("valor","" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).setAttribute("width","8" );
      ((Element)v.get(392)).setAttribute("colspan","4" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(385)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(393)).setAttribute("src","b.gif" );
      ((Element)v.get(393)).setAttribute("width","8" );
      ((Element)v.get(393)).setAttribute("height","8" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */
      /* Termina nodo:385   */

      /* Empieza nodo:394 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("td"));
      ((Element)v.get(395)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(396)).setAttribute("nombre","lblSeccionDefectoT" );
      ((Element)v.get(396)).setAttribute("ancho","190" );
      ((Element)v.get(396)).setAttribute("alto","30" );
      ((Element)v.get(396)).setAttribute("filas","1" );
      ((Element)v.get(396)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(396)).setAttribute("cod","113" );
      ((Element)v.get(396)).setAttribute("valor","" );
      ((Element)v.get(396)).setAttribute("enviaroculto","N" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */

      /* Empieza nodo:397 / Elemento padre: 394   */
      v.add(doc.createElement("td"));
      ((Element)v.get(394)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(398)).setAttribute("src","b.gif" );
      ((Element)v.get(398)).setAttribute("width","8" );
      ((Element)v.get(398)).setAttribute("height","8" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:399 / Elemento padre: 394   */
      v.add(doc.createElement("td"));
      ((Element)v.get(399)).setAttribute("colspan","5" );
      ((Element)v.get(399)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(394)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(400)).setAttribute("nombre","lblSeccionDefecto" );
      ((Element)v.get(400)).setAttribute("ancho","220" );
      ((Element)v.get(400)).setAttribute("alto","20" );
      ((Element)v.get(400)).setAttribute("filas","1" );
      ((Element)v.get(400)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(400)).setAttribute("valor","" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:401 / Elemento padre: 394   */
      v.add(doc.createElement("td"));
      ((Element)v.get(401)).setAttribute("width","8" );
      ((Element)v.get(401)).setAttribute("colspan","4" );
      ((Element)v.get(394)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(402)).setAttribute("src","b.gif" );
      ((Element)v.get(402)).setAttribute("width","8" );
      ((Element)v.get(402)).setAttribute("height","8" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */
      /* Termina nodo:394   */

      /* Empieza nodo:403 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(404)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(405)).setAttribute("nombre","lblTerritorioDefectoT" );
      ((Element)v.get(405)).setAttribute("ancho","190" );
      ((Element)v.get(405)).setAttribute("alto","30" );
      ((Element)v.get(405)).setAttribute("filas","1" );
      ((Element)v.get(405)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(405)).setAttribute("cod","127" );
      ((Element)v.get(405)).setAttribute("valor","" );
      ((Element)v.get(405)).setAttribute("enviaroculto","N" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:406 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(407)).setAttribute("src","b.gif" );
      ((Element)v.get(407)).setAttribute("width","8" );
      ((Element)v.get(407)).setAttribute("height","8" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */

      /* Empieza nodo:408 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(408)).setAttribute("colspan","5" );
      ((Element)v.get(408)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(403)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(409)).setAttribute("nombre","lblTerritorioDefecto" );
      ((Element)v.get(409)).setAttribute("ancho","220" );
      ((Element)v.get(409)).setAttribute("alto","20" );
      ((Element)v.get(409)).setAttribute("filas","1" );
      ((Element)v.get(409)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(409)).setAttribute("valor","" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:408   */

      /* Empieza nodo:410 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(410)).setAttribute("width","8" );
      ((Element)v.get(410)).setAttribute("colspan","4" );
      ((Element)v.get(403)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(411)).setAttribute("src","b.gif" );
      ((Element)v.get(411)).setAttribute("width","8" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(411)).setAttribute("height","8" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */
      /* Termina nodo:403   */

      /* Empieza nodo:412 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(414)).setAttribute("nombre","lblSociedadDefectoT" );
      ((Element)v.get(414)).setAttribute("ancho","190" );
      ((Element)v.get(414)).setAttribute("alto","30" );
      ((Element)v.get(414)).setAttribute("filas","1" );
      ((Element)v.get(414)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(414)).setAttribute("cod","121" );
      ((Element)v.get(414)).setAttribute("valor","" );
      ((Element)v.get(414)).setAttribute("enviaroculto","N" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */

      /* Empieza nodo:415 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(412)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(416)).setAttribute("src","b.gif" );
      ((Element)v.get(416)).setAttribute("width","8" );
      ((Element)v.get(416)).setAttribute("height","8" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:417 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).setAttribute("colspan","5" );
      ((Element)v.get(417)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(412)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(418)).setAttribute("nombre","lblSociedadDefecto" );
      ((Element)v.get(418)).setAttribute("ancho","220" );
      ((Element)v.get(418)).setAttribute("alto","20" );
      ((Element)v.get(418)).setAttribute("filas","1" );
      ((Element)v.get(418)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(418)).setAttribute("valor","" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */

      /* Empieza nodo:419 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(419)).setAttribute("width","8" );
      ((Element)v.get(419)).setAttribute("colspan","4" );
      ((Element)v.get(412)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(420)).setAttribute("src","b.gif" );
      ((Element)v.get(420)).setAttribute("width","8" );
      ((Element)v.get(420)).setAttribute("height","8" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:419   */
      /* Termina nodo:412   */

      /* Empieza nodo:421 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(423)).setAttribute("nombre","lblMarcaDefectoT" );
      ((Element)v.get(423)).setAttribute("ancho","190" );
      ((Element)v.get(423)).setAttribute("alto","30" );
      ((Element)v.get(423)).setAttribute("filas","1" );
      ((Element)v.get(423)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(423)).setAttribute("cod","81" );
      ((Element)v.get(423)).setAttribute("valor","" );
      ((Element)v.get(423)).setAttribute("enviaroculto","N" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */

      /* Empieza nodo:424 / Elemento padre: 421   */
      v.add(doc.createElement("td"));
      ((Element)v.get(421)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(425)).setAttribute("src","b.gif" );
      ((Element)v.get(425)).setAttribute("width","8" );
      ((Element)v.get(425)).setAttribute("height","8" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:424   */

      /* Empieza nodo:426 / Elemento padre: 421   */
      v.add(doc.createElement("td"));
      ((Element)v.get(426)).setAttribute("colspan","5" );
      ((Element)v.get(426)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(421)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(427)).setAttribute("nombre","lblMarcaDefecto" );
      ((Element)v.get(427)).setAttribute("ancho","220" );
      ((Element)v.get(427)).setAttribute("alto","20" );
      ((Element)v.get(427)).setAttribute("filas","1" );
      ((Element)v.get(427)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(427)).setAttribute("valor","" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:428 / Elemento padre: 421   */
      v.add(doc.createElement("td"));
      ((Element)v.get(428)).setAttribute("width","8" );
      ((Element)v.get(428)).setAttribute("colspan","4" );
      ((Element)v.get(421)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(429)).setAttribute("src","b.gif" );
      ((Element)v.get(429)).setAttribute("width","8" );
      ((Element)v.get(429)).setAttribute("height","8" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:428   */
      /* Termina nodo:421   */

      /* Empieza nodo:430 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(432)).setAttribute("nombre","lblCanalDefectoT" );
      ((Element)v.get(432)).setAttribute("ancho","190" );
      ((Element)v.get(432)).setAttribute("alto","30" );
      ((Element)v.get(432)).setAttribute("filas","1" );
      ((Element)v.get(432)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(432)).setAttribute("cod","19" );
      ((Element)v.get(432)).setAttribute("valor","" );
      ((Element)v.get(432)).setAttribute("enviaroculto","N" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:431   */

      /* Empieza nodo:433 / Elemento padre: 430   */
      v.add(doc.createElement("td"));
      ((Element)v.get(430)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(434)).setAttribute("src","b.gif" );
      ((Element)v.get(434)).setAttribute("width","8" );
      ((Element)v.get(434)).setAttribute("height","8" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:435 / Elemento padre: 430   */
      v.add(doc.createElement("td"));
      ((Element)v.get(435)).setAttribute("colspan","5" );
      ((Element)v.get(435)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(430)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(436)).setAttribute("nombre","lblCanalDefecto" );
      ((Element)v.get(436)).setAttribute("ancho","220" );
      ((Element)v.get(436)).setAttribute("alto","20" );
      ((Element)v.get(436)).setAttribute("filas","1" );
      ((Element)v.get(436)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(436)).setAttribute("valor","" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */
      /* Termina nodo:435   */

      /* Empieza nodo:437 / Elemento padre: 430   */
      v.add(doc.createElement("td"));
      ((Element)v.get(437)).setAttribute("width","8" );
      ((Element)v.get(437)).setAttribute("colspan","4" );
      ((Element)v.get(430)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(438)).setAttribute("src","b.gif" );
      ((Element)v.get(438)).setAttribute("width","8" );
      ((Element)v.get(438)).setAttribute("height","8" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:437   */
      /* Termina nodo:430   */

      /* Empieza nodo:439 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("td"));
      ((Element)v.get(440)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(441)).setAttribute("nombre","lblAccesoDefectoT" );
      ((Element)v.get(441)).setAttribute("ancho","190" );
      ((Element)v.get(441)).setAttribute("alto","30" );
      ((Element)v.get(441)).setAttribute("filas","1" );
      ((Element)v.get(441)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(441)).setAttribute("cod","11" );
      ((Element)v.get(441)).setAttribute("valor","" );
      ((Element)v.get(441)).setAttribute("enviaroculto","N" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */
      /* Termina nodo:440   */

      /* Empieza nodo:442 / Elemento padre: 439   */
      v.add(doc.createElement("td"));
      ((Element)v.get(439)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(443)).setAttribute("src","b.gif" );
      ((Element)v.get(443)).setAttribute("width","8" );
      ((Element)v.get(443)).setAttribute("height","8" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:442   */

      /* Empieza nodo:444 / Elemento padre: 439   */
      v.add(doc.createElement("td"));
      ((Element)v.get(444)).setAttribute("colspan","5" );
      ((Element)v.get(444)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(439)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(445)).setAttribute("nombre","lblAccesoDefecto" );
      ((Element)v.get(445)).setAttribute("ancho","220" );
      ((Element)v.get(445)).setAttribute("alto","20" );
      ((Element)v.get(445)).setAttribute("filas","1" );
      ((Element)v.get(445)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(445)).setAttribute("valor","" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:444   */

      /* Empieza nodo:446 / Elemento padre: 439   */
      v.add(doc.createElement("td"));
      ((Element)v.get(446)).setAttribute("width","8" );
      ((Element)v.get(446)).setAttribute("colspan","4" );
      ((Element)v.get(439)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(447)).setAttribute("src","b.gif" );
      ((Element)v.get(447)).setAttribute("width","8" );
      ((Element)v.get(447)).setAttribute("height","8" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */
      /* Termina nodo:439   */

      /* Empieza nodo:448 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("td"));
      ((Element)v.get(449)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(450)).setAttribute("nombre","lblSubaccesoDefectoT" );
      ((Element)v.get(450)).setAttribute("ancho","190" );
      ((Element)v.get(450)).setAttribute("alto","30" );
      ((Element)v.get(450)).setAttribute("filas","1" );
      ((Element)v.get(450)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(450)).setAttribute("cod","123" );
      ((Element)v.get(450)).setAttribute("valor","" );
      ((Element)v.get(450)).setAttribute("enviaroculto","N" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:449   */

      /* Empieza nodo:451 / Elemento padre: 448   */
      v.add(doc.createElement("td"));
      ((Element)v.get(448)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(452)).setAttribute("src","b.gif" );
      ((Element)v.get(452)).setAttribute("width","8" );
      ((Element)v.get(452)).setAttribute("height","8" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */

      /* Empieza nodo:453 / Elemento padre: 448   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).setAttribute("colspan","5" );
      ((Element)v.get(453)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(448)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(454)).setAttribute("nombre","lblSubaccesoDefecto" );
      ((Element)v.get(454)).setAttribute("ancho","220" );
      ((Element)v.get(454)).setAttribute("alto","20" );
      ((Element)v.get(454)).setAttribute("filas","1" );
      ((Element)v.get(454)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(454)).setAttribute("valor","" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */

      /* Empieza nodo:455 / Elemento padre: 448   */
      v.add(doc.createElement("td"));
      ((Element)v.get(455)).setAttribute("width","8" );
      ((Element)v.get(455)).setAttribute("colspan","4" );
      ((Element)v.get(448)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(456)).setAttribute("src","b.gif" );
      ((Element)v.get(456)).setAttribute("width","8" );
      ((Element)v.get(456)).setAttribute("height","8" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:455   */
      /* Termina nodo:448   */

      /* Empieza nodo:457 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(458)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(459)).setAttribute("nombre","lblTipoUsuarioT" );
      ((Element)v.get(459)).setAttribute("ancho","190" );
      ((Element)v.get(459)).setAttribute("alto","30" );
      ((Element)v.get(459)).setAttribute("filas","1" );
      ((Element)v.get(459)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(459)).setAttribute("cod","131" );
      ((Element)v.get(459)).setAttribute("valor","" );
      ((Element)v.get(459)).setAttribute("enviaroculto","N" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:458   */

      /* Empieza nodo:460 / Elemento padre: 457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(457)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(461)).setAttribute("src","b.gif" );
      ((Element)v.get(461)).setAttribute("width","8" );
      ((Element)v.get(461)).setAttribute("height","8" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:460   */

      /* Empieza nodo:462 / Elemento padre: 457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(462)).setAttribute("colspan","5" );
      ((Element)v.get(462)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(457)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(463)).setAttribute("nombre","lblTipoUsuario" );
      ((Element)v.get(463)).setAttribute("ancho","220" );
      ((Element)v.get(463)).setAttribute("alto","20" );
      ((Element)v.get(463)).setAttribute("filas","1" );
      ((Element)v.get(463)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(463)).setAttribute("valor","" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:464 / Elemento padre: 457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(464)).setAttribute("width","8" );
      ((Element)v.get(464)).setAttribute("colspan","4" );
      ((Element)v.get(457)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(465)).setAttribute("src","b.gif" );
      ((Element)v.get(465)).setAttribute("width","8" );
      ((Element)v.get(465)).setAttribute("height","8" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */
      /* Termina nodo:457   */

      /* Empieza nodo:466 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("td"));
      ((Element)v.get(467)).setAttribute("colspan","11" );
      ((Element)v.get(467)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(467)).setAttribute("class","datosCampos" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(468)).setAttribute("src","b.gif" );
      ((Element)v.get(468)).setAttribute("width","8" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(468)).setAttribute("height","8" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */
      /* Termina nodo:467   */
      /* Termina nodo:466   */
      /* Termina nodo:354   */
      /* Termina nodo:353   */
      /* Termina nodo:352   */
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:469 / Elemento padre: 347   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(470)).setAttribute("src","b.gif" );
      ((Element)v.get(470)).setAttribute("width","8" );
      ((Element)v.get(470)).setAttribute("height","8" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */
      /* Termina nodo:469   */
      /* Termina nodo:347   */

      /* Empieza nodo:471 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("td"));
      ((Element)v.get(472)).setAttribute("align","center" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(473)).setAttribute("src","b.gif" );
      ((Element)v.get(473)).setAttribute("width","8" );
      ((Element)v.get(473)).setAttribute("height","8" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:472   */

      /* Empieza nodo:474 / Elemento padre: 471   */
      v.add(doc.createElement("td"));
      ((Element)v.get(471)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(475)).setAttribute("src","b.gif" );
      ((Element)v.get(475)).setAttribute("width","8" );
      ((Element)v.get(475)).setAttribute("height","8" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */
      /* Termina nodo:474   */

      /* Empieza nodo:476 / Elemento padre: 471   */
      v.add(doc.createElement("td"));
      ((Element)v.get(471)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(477)).setAttribute("src","b.gif" );
      ((Element)v.get(477)).setAttribute("width","8" );
      ((Element)v.get(477)).setAttribute("height","8" );
      ((Element)v.get(476)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */
      /* Termina nodo:476   */
      /* Termina nodo:471   */

      /* Empieza nodo:478 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("td"));
      ((Element)v.get(479)).setAttribute("align","center" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(480)).setAttribute("src","b.gif" );
      ((Element)v.get(480)).setAttribute("width","8" );
      ((Element)v.get(480)).setAttribute("height","8" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:479   */

      /* Empieza nodo:481 / Elemento padre: 478   */
      v.add(doc.createElement("td"));
      ((Element)v.get(478)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("table"));
      ((Element)v.get(482)).setAttribute("width","100%" );
      ((Element)v.get(482)).setAttribute("border","1" );
      ((Element)v.get(482)).setAttribute("cellspacing","1" );
      ((Element)v.get(482)).setAttribute("cellpadding","0" );
      ((Element)v.get(482)).setAttribute("bordercolor","#CCCCCC" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(482)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("table"));
      ((Element)v.get(485)).setAttribute("width","98%" );
      ((Element)v.get(485)).setAttribute("border","0" );
      ((Element)v.get(485)).setAttribute("cellspacing","0" );
      ((Element)v.get(485)).setAttribute("cellpadding","0" );
      ((Element)v.get(485)).setAttribute("align","center" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(485)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("td"));
      ((Element)v.get(487)).setAttribute("colspan","11" );
      ((Element)v.get(487)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(487)).setAttribute("class","datosCampos" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(488)).setAttribute("src","b.gif" );
      ((Element)v.get(488)).setAttribute("width","8" );
      ((Element)v.get(488)).setAttribute("height","8" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */
      /* Termina nodo:487   */
      /* Termina nodo:486   */

      /* Empieza nodo:489 / Elemento padre: 485   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(485)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(490)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(491)).setAttribute("nombre","lblIdiomaT" );
      ((Element)v.get(491)).setAttribute("ancho","160" );
      ((Element)v.get(491)).setAttribute("alto","30" );
      ((Element)v.get(491)).setAttribute("filas","1" );
      ((Element)v.get(491)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(491)).setAttribute("cod","71" );
      ((Element)v.get(491)).setAttribute("valor","" );
      ((Element)v.get(491)).setAttribute("enviaroculto","N" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */

      /* Empieza nodo:492 / Elemento padre: 489   */
   }

   private void getXML2250(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(489)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(493)).setAttribute("src","b.gif" );
      ((Element)v.get(493)).setAttribute("width","8" );
      ((Element)v.get(493)).setAttribute("height","8" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */
      /* Termina nodo:492   */

      /* Empieza nodo:494 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(494)).setAttribute("colspan","5" );
      ((Element)v.get(494)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(489)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(495)).setAttribute("nombre","lblIdioma" );
      ((Element)v.get(495)).setAttribute("ancho","160" );
      ((Element)v.get(495)).setAttribute("alto","20" );
      ((Element)v.get(495)).setAttribute("filas","1" );
      ((Element)v.get(495)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(495)).setAttribute("valor","" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:496 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(496)).setAttribute("width","8" );
      ((Element)v.get(496)).setAttribute("colspan","4" );
      ((Element)v.get(489)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(497)).setAttribute("src","b.gif" );
      ((Element)v.get(497)).setAttribute("width","8" );
      ((Element)v.get(497)).setAttribute("height","8" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */
      /* Termina nodo:496   */
      /* Termina nodo:489   */

      /* Empieza nodo:498 / Elemento padre: 485   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(485)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("td"));
      ((Element)v.get(499)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(500)).setAttribute("nombre","lblRastreoAccesoT" );
      ((Element)v.get(500)).setAttribute("ancho","160" );
      ((Element)v.get(500)).setAttribute("alto","30" );
      ((Element)v.get(500)).setAttribute("filas","1" );
      ((Element)v.get(500)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(500)).setAttribute("cod","167" );
      ((Element)v.get(500)).setAttribute("valor","" );
      ((Element)v.get(500)).setAttribute("enviaroculto","N" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */
      /* Termina nodo:499   */

      /* Empieza nodo:501 / Elemento padre: 498   */
      v.add(doc.createElement("td"));
      ((Element)v.get(501)).setAttribute("width","8" );
      ((Element)v.get(498)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(502)).setAttribute("src","b.gif" );
      ((Element)v.get(502)).setAttribute("width","8" );
      ((Element)v.get(502)).setAttribute("height","8" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */
      /* Termina nodo:501   */

      /* Empieza nodo:503 / Elemento padre: 498   */
      v.add(doc.createElement("td"));
      ((Element)v.get(503)).setAttribute("colspan","5" );
      ((Element)v.get(503)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(498)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(504)).setAttribute("nombre","lblRastreoAcceso" );
      ((Element)v.get(504)).setAttribute("ancho","160" );
      ((Element)v.get(504)).setAttribute("alto","20" );
      ((Element)v.get(504)).setAttribute("filas","1" );
      ((Element)v.get(504)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(504)).setAttribute("valor","" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */
      /* Termina nodo:503   */

      /* Empieza nodo:505 / Elemento padre: 498   */
      v.add(doc.createElement("td"));
      ((Element)v.get(505)).setAttribute("width","8" );
      ((Element)v.get(505)).setAttribute("colspan","4" );
      ((Element)v.get(498)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(506)).setAttribute("src","b.gif" );
      ((Element)v.get(506)).setAttribute("width","8" );
      ((Element)v.get(506)).setAttribute("height","8" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */
      /* Termina nodo:505   */
      /* Termina nodo:498   */

      /* Empieza nodo:507 / Elemento padre: 485   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(485)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(508)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(509)).setAttribute("nombre","lblFechaInicioRastreoT" );
      ((Element)v.get(509)).setAttribute("ancho","160" );
      ((Element)v.get(509)).setAttribute("alto","30" );
      ((Element)v.get(509)).setAttribute("filas","1" );
      ((Element)v.get(509)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(509)).setAttribute("cod","61" );
      ((Element)v.get(509)).setAttribute("valor","" );
      ((Element)v.get(509)).setAttribute("enviaroculto","N" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:510 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(510)).setAttribute("width","8" );
      ((Element)v.get(507)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
   }

   private void getXML2340(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(511)).setAttribute("src","b.gif" );
      ((Element)v.get(511)).setAttribute("width","8" );
      ((Element)v.get(511)).setAttribute("height","8" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */
      /* Termina nodo:510   */

      /* Empieza nodo:512 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(512)).setAttribute("colspan","5" );
      ((Element)v.get(512)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(507)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(513)).setAttribute("nombre","lblFechaInicioRastreo" );
      ((Element)v.get(513)).setAttribute("ancho","160" );
      ((Element)v.get(513)).setAttribute("alto","20" );
      ((Element)v.get(513)).setAttribute("filas","1" );
      ((Element)v.get(513)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(513)).setAttribute("valor","" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */
      /* Termina nodo:512   */

      /* Empieza nodo:514 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(514)).setAttribute("width","8" );
      ((Element)v.get(507)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(515)).setAttribute("src","b.gif" );
      ((Element)v.get(515)).setAttribute("width","8" );
      ((Element)v.get(515)).setAttribute("height","8" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:514   */

      /* Empieza nodo:516 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(516)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(507)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(517)).setAttribute("nombre","lblFechaFinRastreoT" );
      ((Element)v.get(517)).setAttribute("ancho","100" );
      ((Element)v.get(517)).setAttribute("alto","30" );
      ((Element)v.get(517)).setAttribute("filas","1" );
      ((Element)v.get(517)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(517)).setAttribute("cod","60" );
      ((Element)v.get(517)).setAttribute("valor","" );
      ((Element)v.get(517)).setAttribute("enviaroculto","N" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */
      /* Termina nodo:516   */

      /* Empieza nodo:518 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(518)).setAttribute("width","8" );
      ((Element)v.get(507)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(519)).setAttribute("src","b.gif" );
      ((Element)v.get(519)).setAttribute("width","8" );
      ((Element)v.get(519)).setAttribute("height","8" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:520 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(520)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(507)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(521)).setAttribute("nombre","lblFechaFinRastreo" );
      ((Element)v.get(521)).setAttribute("ancho","120" );
      ((Element)v.get(521)).setAttribute("alto","20" );
      ((Element)v.get(521)).setAttribute("filas","1" );
      ((Element)v.get(521)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(521)).setAttribute("valor","" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */
      /* Termina nodo:507   */

      /* Empieza nodo:522 / Elemento padre: 485   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(485)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("td"));
      ((Element)v.get(523)).setAttribute("width","105" );
      ((Element)v.get(523)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(524)).setAttribute("nombre","lblFuncionDirectaT" );
      ((Element)v.get(524)).setAttribute("ancho","160" );
      ((Element)v.get(524)).setAttribute("alto","30" );
      ((Element)v.get(524)).setAttribute("filas","1" );
      ((Element)v.get(524)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(524)).setAttribute("cod","102" );
      ((Element)v.get(524)).setAttribute("valor","" );
      ((Element)v.get(524)).setAttribute("enviaroculto","N" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */
      /* Termina nodo:523   */

      /* Empieza nodo:525 / Elemento padre: 522   */
      v.add(doc.createElement("td"));
      ((Element)v.get(525)).setAttribute("width","8" );
      ((Element)v.get(522)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(526)).setAttribute("src","b.gif" );
      ((Element)v.get(526)).setAttribute("width","8" );
      ((Element)v.get(526)).setAttribute("height","8" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */
      /* Termina nodo:525   */

      /* Empieza nodo:527 / Elemento padre: 522   */
      v.add(doc.createElement("td"));
      ((Element)v.get(527)).setAttribute("colspan","5" );
      ((Element)v.get(527)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(522)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(528)).setAttribute("nombre","lblFuncionDirecta" );
      ((Element)v.get(528)).setAttribute("ancho","160" );
      ((Element)v.get(528)).setAttribute("alto","20" );
      ((Element)v.get(528)).setAttribute("filas","1" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(528)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(528)).setAttribute("valor","" );
      ((Element)v.get(527)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */
      /* Termina nodo:527   */

      /* Empieza nodo:529 / Elemento padre: 522   */
      v.add(doc.createElement("td"));
      ((Element)v.get(529)).setAttribute("width","8" );
      ((Element)v.get(529)).setAttribute("colspan","4" );
      ((Element)v.get(522)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(530)).setAttribute("src","b.gif" );
      ((Element)v.get(530)).setAttribute("width","8" );
      ((Element)v.get(530)).setAttribute("height","8" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:529   */
      /* Termina nodo:522   */

      /* Empieza nodo:531 / Elemento padre: 485   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(485)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("td"));
      ((Element)v.get(532)).setAttribute("colspan","11" );
      ((Element)v.get(532)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(532)).setAttribute("class","datosCampos" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(533)).setAttribute("src","b.gif" );
      ((Element)v.get(533)).setAttribute("width","8" );
      ((Element)v.get(533)).setAttribute("height","8" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */
      /* Termina nodo:532   */
      /* Termina nodo:531   */
      /* Termina nodo:485   */
      /* Termina nodo:484   */
      /* Termina nodo:483   */
      /* Termina nodo:482   */
      /* Termina nodo:481   */

      /* Empieza nodo:534 / Elemento padre: 478   */
      v.add(doc.createElement("td"));
      ((Element)v.get(478)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(535)).setAttribute("src","b.gif" );
      ((Element)v.get(535)).setAttribute("width","8" );
      ((Element)v.get(535)).setAttribute("height","8" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */
      /* Termina nodo:534   */
      /* Termina nodo:478   */

      /* Empieza nodo:536 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(537)).setAttribute("align","center" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(538)).setAttribute("src","b.gif" );
      ((Element)v.get(538)).setAttribute("width","8" );
      ((Element)v.get(538)).setAttribute("height","8" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:537   */

      /* Empieza nodo:539 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(540)).setAttribute("src","b.gif" );
      ((Element)v.get(540)).setAttribute("width","8" );
      ((Element)v.get(540)).setAttribute("height","8" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */

      /* Empieza nodo:541 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(542)).setAttribute("src","b.gif" );
      ((Element)v.get(542)).setAttribute("width","8" );
      ((Element)v.get(542)).setAttribute("height","8" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */
      /* Termina nodo:541   */
      /* Termina nodo:536   */

      /* Empieza nodo:543 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("td"));
      ((Element)v.get(544)).setAttribute("align","center" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(545)).setAttribute("src","b.gif" );
      ((Element)v.get(545)).setAttribute("width","8" );
      ((Element)v.get(545)).setAttribute("height","8" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:544   */

      /* Empieza nodo:546 / Elemento padre: 543   */
      v.add(doc.createElement("td"));
      ((Element)v.get(543)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("table"));
      ((Element)v.get(547)).setAttribute("width","100%" );
      ((Element)v.get(547)).setAttribute("border","1" );
      ((Element)v.get(547)).setAttribute("cellspacing","1" );
      ((Element)v.get(547)).setAttribute("cellpadding","0" );
      ((Element)v.get(547)).setAttribute("bordercolor","#CCCCCC" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(547)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("td"));
      ((Element)v.get(548)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("table"));
      ((Element)v.get(550)).setAttribute("width","98%" );
      ((Element)v.get(550)).setAttribute("border","0" );
      ((Element)v.get(550)).setAttribute("cellspacing","0" );
      ((Element)v.get(550)).setAttribute("cellpadding","0" );
      ((Element)v.get(550)).setAttribute("align","center" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(550)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("td"));
      ((Element)v.get(552)).setAttribute("colspan","11" );
      ((Element)v.get(552)).setAttribute("nowrap","nowrap" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(552)).setAttribute("class","datosCampos" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(553)).setAttribute("src","b.gif" );
      ((Element)v.get(553)).setAttribute("width","8" );
      ((Element)v.get(553)).setAttribute("height","8" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));
      /* Termina nodo:553   */
      /* Termina nodo:552   */
      /* Termina nodo:551   */

      /* Empieza nodo:554 / Elemento padre: 550   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(550)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(556)).setAttribute("nombre","lblUsuarioSustitucionT" );
      ((Element)v.get(556)).setAttribute("ancho","160" );
      ((Element)v.get(556)).setAttribute("alto","30" );
      ((Element)v.get(556)).setAttribute("filas","1" );
      ((Element)v.get(556)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(556)).setAttribute("cod","140" );
      ((Element)v.get(556)).setAttribute("valor","" );
      ((Element)v.get(556)).setAttribute("enviaroculto","N" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */
      /* Termina nodo:555   */

      /* Empieza nodo:557 / Elemento padre: 554   */
      v.add(doc.createElement("td"));
      ((Element)v.get(557)).setAttribute("width","8" );
      ((Element)v.get(554)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(558)).setAttribute("src","b.gif" );
      ((Element)v.get(558)).setAttribute("width","8" );
      ((Element)v.get(558)).setAttribute("height","8" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));
      /* Termina nodo:558   */
      /* Termina nodo:557   */

      /* Empieza nodo:559 / Elemento padre: 554   */
      v.add(doc.createElement("td"));
      ((Element)v.get(559)).setAttribute("colspan","9" );
      ((Element)v.get(559)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(554)).appendChild((Element)v.get(559));

      /* Empieza nodo:560 / Elemento padre: 559   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(560)).setAttribute("nombre","lblUsuarioSustitucion" );
      ((Element)v.get(560)).setAttribute("ancho","320" );
      ((Element)v.get(560)).setAttribute("alto","40" );
      ((Element)v.get(560)).setAttribute("filas","1" );
      ((Element)v.get(560)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(560)).setAttribute("valor","" );
      ((Element)v.get(559)).appendChild((Element)v.get(560));
      /* Termina nodo:560   */
      /* Termina nodo:559   */
      /* Termina nodo:554   */

      /* Empieza nodo:561 / Elemento padre: 550   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(550)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("td"));
      ((Element)v.get(562)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(563)).setAttribute("nombre","lblFechaDesdeT" );
      ((Element)v.get(563)).setAttribute("ancho","160" );
      ((Element)v.get(563)).setAttribute("alto","30" );
      ((Element)v.get(563)).setAttribute("filas","1" );
      ((Element)v.get(563)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(563)).setAttribute("cod","168" );
      ((Element)v.get(563)).setAttribute("valor","" );
      ((Element)v.get(563)).setAttribute("enviaroculto","N" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */
      /* Termina nodo:562   */

      /* Empieza nodo:564 / Elemento padre: 561   */
      v.add(doc.createElement("td"));
      ((Element)v.get(564)).setAttribute("width","8" );
      ((Element)v.get(561)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(565)).setAttribute("src","b.gif" );
      ((Element)v.get(565)).setAttribute("width","8" );
      ((Element)v.get(565)).setAttribute("height","8" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */
      /* Termina nodo:564   */

      /* Empieza nodo:566 / Elemento padre: 561   */
      v.add(doc.createElement("td"));
      ((Element)v.get(566)).setAttribute("colspan","5" );
      ((Element)v.get(566)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(561)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(567)).setAttribute("nombre","lblFechaDesde" );
      ((Element)v.get(567)).setAttribute("ancho","160" );
      ((Element)v.get(567)).setAttribute("alto","20" );
      ((Element)v.get(567)).setAttribute("filas","1" );
      ((Element)v.get(567)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(567)).setAttribute("valor","" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:566   */

      /* Empieza nodo:568 / Elemento padre: 561   */
      v.add(doc.createElement("td"));
      ((Element)v.get(568)).setAttribute("width","8" );
      ((Element)v.get(561)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(569)).setAttribute("src","b.gif" );
      ((Element)v.get(569)).setAttribute("width","8" );
      ((Element)v.get(569)).setAttribute("height","8" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */
      /* Termina nodo:568   */

      /* Empieza nodo:570 / Elemento padre: 561   */
      v.add(doc.createElement("td"));
      ((Element)v.get(570)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(561)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(571)).setAttribute("nombre","lblFechaHastaT" );
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(571)).setAttribute("ancho","100" );
      ((Element)v.get(571)).setAttribute("alto","30" );
      ((Element)v.get(571)).setAttribute("filas","1" );
      ((Element)v.get(571)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(571)).setAttribute("cod","145" );
      ((Element)v.get(571)).setAttribute("valor","" );
      ((Element)v.get(571)).setAttribute("enviaroculto","N" );
      ((Element)v.get(570)).appendChild((Element)v.get(571));
      /* Termina nodo:571   */
      /* Termina nodo:570   */

      /* Empieza nodo:572 / Elemento padre: 561   */
      v.add(doc.createElement("td"));
      ((Element)v.get(572)).setAttribute("width","8" );
      ((Element)v.get(561)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(573)).setAttribute("src","b.gif" );
      ((Element)v.get(573)).setAttribute("width","8" );
      ((Element)v.get(573)).setAttribute("height","8" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:572   */

      /* Empieza nodo:574 / Elemento padre: 561   */
      v.add(doc.createElement("td"));
      ((Element)v.get(574)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(561)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(575)).setAttribute("nombre","lblFechaHasta" );
      ((Element)v.get(575)).setAttribute("ancho","120" );
      ((Element)v.get(575)).setAttribute("alto","20" );
      ((Element)v.get(575)).setAttribute("filas","1" );
      ((Element)v.get(575)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(575)).setAttribute("valor","" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));
      /* Termina nodo:575   */
      /* Termina nodo:574   */
      /* Termina nodo:561   */

      /* Empieza nodo:576 / Elemento padre: 550   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(550)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("td"));
      ((Element)v.get(577)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(578)).setAttribute("nombre","lblObservacionesT" );
      ((Element)v.get(578)).setAttribute("ancho","160" );
      ((Element)v.get(578)).setAttribute("alto","30" );
      ((Element)v.get(578)).setAttribute("filas","1" );
      ((Element)v.get(578)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(578)).setAttribute("cod","169" );
      ((Element)v.get(578)).setAttribute("valor","" );
      ((Element)v.get(578)).setAttribute("enviaroculto","N" );
      ((Element)v.get(577)).appendChild((Element)v.get(578));
      /* Termina nodo:578   */
      /* Termina nodo:577   */

      /* Empieza nodo:579 / Elemento padre: 576   */
      v.add(doc.createElement("td"));
      ((Element)v.get(579)).setAttribute("width","8" );
      ((Element)v.get(576)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(580)).setAttribute("src","b.gif" );
      ((Element)v.get(580)).setAttribute("width","8" );
      ((Element)v.get(580)).setAttribute("height","8" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));
      /* Termina nodo:580   */
      /* Termina nodo:579   */

      /* Empieza nodo:581 / Elemento padre: 576   */
      v.add(doc.createElement("td"));
      ((Element)v.get(581)).setAttribute("colspan","10" );
      ((Element)v.get(581)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(576)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(582)).setAttribute("nombre","lblObservaciones" );
      ((Element)v.get(582)).setAttribute("ancho","400" );
      ((Element)v.get(582)).setAttribute("alto","20" );
      ((Element)v.get(582)).setAttribute("filas","1" );
      ((Element)v.get(582)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(582)).setAttribute("valor","" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */
      /* Termina nodo:581   */
      /* Termina nodo:576   */

      /* Empieza nodo:583 / Elemento padre: 550   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(550)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("td"));
      ((Element)v.get(584)).setAttribute("colspan","12" );
      ((Element)v.get(584)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(584)).setAttribute("class","datosCampos" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(585)).setAttribute("src","b.gif" );
      ((Element)v.get(585)).setAttribute("width","8" );
      ((Element)v.get(585)).setAttribute("height","8" );
      ((Element)v.get(584)).appendChild((Element)v.get(585));
      /* Termina nodo:585   */
      /* Termina nodo:584   */
      /* Termina nodo:583   */
      /* Termina nodo:550   */
      /* Termina nodo:549   */
      /* Termina nodo:548   */
      /* Termina nodo:547   */
      /* Termina nodo:546   */

      /* Empieza nodo:586 / Elemento padre: 543   */
      v.add(doc.createElement("td"));
      ((Element)v.get(543)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */
      /* Termina nodo:543   */

      /* Empieza nodo:587 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("td"));
      ((Element)v.get(588)).setAttribute("align","center" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(589)).setAttribute("src","b.gif" );
      ((Element)v.get(589)).setAttribute("width","8" );
      ((Element)v.get(589)).setAttribute("height","8" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */
      /* Termina nodo:588   */

      /* Empieza nodo:590 / Elemento padre: 587   */
      v.add(doc.createElement("td"));
      ((Element)v.get(587)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(591)).setAttribute("src","b.gif" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(591)).setAttribute("width","8" );
      ((Element)v.get(591)).setAttribute("height","8" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));
      /* Termina nodo:591   */
      /* Termina nodo:590   */

      /* Empieza nodo:592 / Elemento padre: 587   */
      v.add(doc.createElement("td"));
      ((Element)v.get(587)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(593)).setAttribute("src","b.gif" );
      ((Element)v.get(593)).setAttribute("width","8" );
      ((Element)v.get(593)).setAttribute("height","8" );
      ((Element)v.get(592)).appendChild((Element)v.get(593));
      /* Termina nodo:593   */
      /* Termina nodo:592   */
      /* Termina nodo:587   */

      /* Empieza nodo:594 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("td"));
      ((Element)v.get(595)).setAttribute("align","center" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));
      /* Termina nodo:595   */

      /* Empieza nodo:596 / Elemento padre: 594   */
      v.add(doc.createElement("td"));
      ((Element)v.get(594)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("table"));
      ((Element)v.get(597)).setAttribute("width","100%" );
      ((Element)v.get(597)).setAttribute("border","1" );
      ((Element)v.get(597)).setAttribute("cellspacing","1" );
      ((Element)v.get(597)).setAttribute("cellpadding","0" );
      ((Element)v.get(597)).setAttribute("bordercolor","#CCCCCC" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(597)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("td"));
      ((Element)v.get(598)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("table"));
      ((Element)v.get(600)).setAttribute("width","98%" );
      ((Element)v.get(600)).setAttribute("border","0" );
      ((Element)v.get(600)).setAttribute("cellspacing","0" );
      ((Element)v.get(600)).setAttribute("cellpadding","0" );
      ((Element)v.get(600)).setAttribute("align","center" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(600)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(602)).setAttribute("colspan","11" );
      ((Element)v.get(602)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(602)).setAttribute("class","datosCampos" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(603)).setAttribute("src","b.gif" );
      ((Element)v.get(603)).setAttribute("width","8" );
      ((Element)v.get(603)).setAttribute("height","8" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */
      /* Termina nodo:602   */
      /* Termina nodo:601   */

      /* Empieza nodo:604 / Elemento padre: 600   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(600)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("td"));
      ((Element)v.get(605)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(604)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(606)).setAttribute("nombre","lblIndNDGT" );
      ((Element)v.get(606)).setAttribute("ancho","120" );
      ((Element)v.get(606)).setAttribute("alto","30" );
      ((Element)v.get(606)).setAttribute("filas","1" );
      ((Element)v.get(606)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(606)).setAttribute("cod","2474" );
      ((Element)v.get(606)).setAttribute("valor","" );
      ((Element)v.get(606)).setAttribute("enviaroculto","N" );
      ((Element)v.get(605)).appendChild((Element)v.get(606));
      /* Termina nodo:606   */
      /* Termina nodo:605   */

      /* Empieza nodo:607 / Elemento padre: 604   */
      v.add(doc.createElement("td"));
      ((Element)v.get(607)).setAttribute("width","8" );
      ((Element)v.get(604)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(608)).setAttribute("src","b.gif" );
      ((Element)v.get(608)).setAttribute("width","8" );
      ((Element)v.get(608)).setAttribute("height","8" );
      ((Element)v.get(607)).appendChild((Element)v.get(608));
      /* Termina nodo:608   */
      /* Termina nodo:607   */

      /* Empieza nodo:609 / Elemento padre: 604   */
      v.add(doc.createElement("td"));
      ((Element)v.get(609)).setAttribute("colspan","5" );
      ((Element)v.get(609)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(604)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(610)).setAttribute("nombre","lblIndNDG" );
      ((Element)v.get(610)).setAttribute("ancho","160" );
      ((Element)v.get(610)).setAttribute("alto","20" );
      ((Element)v.get(610)).setAttribute("filas","1" );
      ((Element)v.get(610)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(610)).setAttribute("valor","" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));
      /* Termina nodo:610   */
      /* Termina nodo:609   */

      /* Empieza nodo:611 / Elemento padre: 604   */
      v.add(doc.createElement("td"));
      ((Element)v.get(611)).setAttribute("width","8" );
      ((Element)v.get(611)).setAttribute("colspan","4" );
      ((Element)v.get(604)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(612)).setAttribute("src","b.gif" );
      ((Element)v.get(612)).setAttribute("width","8" );
      ((Element)v.get(612)).setAttribute("height","8" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(611)).appendChild((Element)v.get(612));
      /* Termina nodo:612   */
      /* Termina nodo:611   */
      /* Termina nodo:604   */

      /* Empieza nodo:613 / Elemento padre: 600   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(600)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("td"));
      ((Element)v.get(614)).setAttribute("width","105" );
      ((Element)v.get(614)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(613)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(615)).setAttribute("nombre","lblAminNDGT" );
      ((Element)v.get(615)).setAttribute("ancho","120" );
      ((Element)v.get(615)).setAttribute("alto","30" );
      ((Element)v.get(615)).setAttribute("filas","1" );
      ((Element)v.get(615)).setAttribute("id","datosTitleRight" );
      ((Element)v.get(615)).setAttribute("cod","2475" );
      ((Element)v.get(615)).setAttribute("valor","" );
      ((Element)v.get(615)).setAttribute("enviaroculto","N" );
      ((Element)v.get(614)).appendChild((Element)v.get(615));
      /* Termina nodo:615   */
      /* Termina nodo:614   */

      /* Empieza nodo:616 / Elemento padre: 613   */
      v.add(doc.createElement("td"));
      ((Element)v.get(616)).setAttribute("width","8" );
      ((Element)v.get(613)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(617)).setAttribute("src","b.gif" );
      ((Element)v.get(617)).setAttribute("width","8" );
      ((Element)v.get(617)).setAttribute("height","8" );
      ((Element)v.get(616)).appendChild((Element)v.get(617));
      /* Termina nodo:617   */
      /* Termina nodo:616   */

      /* Empieza nodo:618 / Elemento padre: 613   */
      v.add(doc.createElement("td"));
      ((Element)v.get(618)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(618)).setAttribute("colspan","5" );
      ((Element)v.get(613)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(619)).setAttribute("nombre","lblAminNDG" );
      ((Element)v.get(619)).setAttribute("ancho","160" );
      ((Element)v.get(619)).setAttribute("alto","20" );
      ((Element)v.get(619)).setAttribute("filas","1" );
      ((Element)v.get(619)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(619)).setAttribute("valor","" );
      ((Element)v.get(618)).appendChild((Element)v.get(619));
      /* Termina nodo:619   */
      /* Termina nodo:618   */

      /* Empieza nodo:620 / Elemento padre: 613   */
      v.add(doc.createElement("td"));
      ((Element)v.get(620)).setAttribute("width","8" );
      ((Element)v.get(620)).setAttribute("colspan","4" );
      ((Element)v.get(613)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(621)).setAttribute("src","b.gif" );
      ((Element)v.get(621)).setAttribute("width","8" );
      ((Element)v.get(621)).setAttribute("height","8" );
      ((Element)v.get(620)).appendChild((Element)v.get(621));
      /* Termina nodo:621   */
      /* Termina nodo:620   */
      /* Termina nodo:613   */

      /* Empieza nodo:622 / Elemento padre: 600   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(600)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("td"));
      ((Element)v.get(623)).setAttribute("colspan","11" );
      ((Element)v.get(623)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(623)).setAttribute("class","datosCampos" );
      ((Element)v.get(622)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(624)).setAttribute("src","b.gif" );
      ((Element)v.get(624)).setAttribute("width","8" );
      ((Element)v.get(624)).setAttribute("height","8" );
      ((Element)v.get(623)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */
      /* Termina nodo:623   */
      /* Termina nodo:622   */
      /* Termina nodo:600   */
      /* Termina nodo:599   */
      /* Termina nodo:598   */
      /* Termina nodo:597   */
      /* Termina nodo:596   */

      /* Empieza nodo:625 / Elemento padre: 594   */
      v.add(doc.createElement("td"));
      ((Element)v.get(594)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(626)).setAttribute("src","b.gif" );
      ((Element)v.get(626)).setAttribute("width","8" );
      ((Element)v.get(626)).setAttribute("height","8" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));
      /* Termina nodo:626   */
      /* Termina nodo:625   */
      /* Termina nodo:594   */
      /* Termina nodo:43   */
      /* Termina nodo:3   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_usuario_insertar  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML2880(doc);
         

      getXML2970(doc);
         

      getXML3060(doc);
         

      getXML3150(doc);
         

      getXML3240(doc);
         

      getXML3330(doc);
         

      getXML3420(doc);
         

      getXML3510(doc);
         

      getXML3600(doc);
         

      getXML3690(doc);
         

      getXML3780(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_usuario_insertar" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","inicializar(true);" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("cod","024" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","usuario_general.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","txtUsuario" );
      ((Element)v.get(5)).setAttribute("required","true" );
      ((Element)v.get(5)).setAttribute("cod","136" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","rbClaveInicial" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","22" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","txtClaveAcceso" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","21" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtConfirmarClaveAcceso" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","42" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbPerfil" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","104" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtPrimerApellido" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","16" );
      ((Element)v.get(4)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtSegundoApellido" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","17" );
      ((Element)v.get(4)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtPrimerNombre" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","93" );
      ((Element)v.get(4)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","txtSegundoNombre" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","94" );
      ((Element)v.get(4)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","txtValidezDesde" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("cod","141" );
      ((Element)v.get(14)).setAttribute("format","F" );
      ((Element)v.get(4)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","txtValidezHasta" );
      ((Element)v.get(15)).setAttribute("required","true" );
      ((Element)v.get(15)).setAttribute("cod","142" );
      ((Element)v.get(15)).setAttribute("format","F" );
      ((Element)v.get(4)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","cbSociedad" );
      ((Element)v.get(16)).setAttribute("required","true" );
      ((Element)v.get(16)).setAttribute("cod","120" );
      ((Element)v.get(4)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","cbMarca" );
      ((Element)v.get(17)).setAttribute("required","true" );
      ((Element)v.get(17)).setAttribute("cod","6" );
      ((Element)v.get(4)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(18)).setAttribute("name","cbCanal" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(18)).setAttribute("required","true" );
      ((Element)v.get(18)).setAttribute("cod","7" );
      ((Element)v.get(4)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(19)).setAttribute("name","cbAcceso" );
      ((Element)v.get(19)).setAttribute("required","true" );
      ((Element)v.get(19)).setAttribute("cod","10" );
      ((Element)v.get(4)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(20)).setAttribute("name","cbSubacceso" );
      ((Element)v.get(20)).setAttribute("required","true" );
      ((Element)v.get(20)).setAttribute("cod","122" );
      ((Element)v.get(4)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(21)).setAttribute("name","cbPais" );
      ((Element)v.get(21)).setAttribute("required","true" );
      ((Element)v.get(21)).setAttribute("cod","5" );
      ((Element)v.get(4)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(22)).setAttribute("name","cbSubgerenciaVentas" );
      ((Element)v.get(22)).setAttribute("required","true" );
      ((Element)v.get(22)).setAttribute("cod","124" );
      ((Element)v.get(4)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(23)).setAttribute("name","cbRegion" );
      ((Element)v.get(23)).setAttribute("required","true" );
      ((Element)v.get(23)).setAttribute("cod","109" );
      ((Element)v.get(4)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(24)).setAttribute("name","cbZona" );
      ((Element)v.get(24)).setAttribute("required","true" );
      ((Element)v.get(24)).setAttribute("cod","143" );
      ((Element)v.get(4)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(25)).setAttribute("name","cbSeccion" );
      ((Element)v.get(25)).setAttribute("required","true" );
      ((Element)v.get(25)).setAttribute("cod","112" );
      ((Element)v.get(4)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(26)).setAttribute("name","cbTerritorio" );
      ((Element)v.get(26)).setAttribute("required","true" );
      ((Element)v.get(26)).setAttribute("cod","126" );
      ((Element)v.get(4)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(27)).setAttribute("name","cbPaisPorDefecto" );
      ((Element)v.get(27)).setAttribute("required","true" );
      ((Element)v.get(27)).setAttribute("cod","101" );
      ((Element)v.get(4)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(28)).setAttribute("name","cbSGVPorDefecto" );
      ((Element)v.get(28)).setAttribute("required","true" );
      ((Element)v.get(28)).setAttribute("cod","166" );
      ((Element)v.get(4)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(29)).setAttribute("name","cbRegionPorDefecto" );
      ((Element)v.get(29)).setAttribute("required","true" );
      ((Element)v.get(29)).setAttribute("cod","110" );
      ((Element)v.get(4)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(30)).setAttribute("name","cbZonaPorDefecto" );
      ((Element)v.get(30)).setAttribute("required","true" );
      ((Element)v.get(30)).setAttribute("cod","140" );
      ((Element)v.get(4)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(31)).setAttribute("name","cbSeccionPorDefecto" );
      ((Element)v.get(31)).setAttribute("required","true" );
      ((Element)v.get(31)).setAttribute("cod","113" );
      ((Element)v.get(4)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(32)).setAttribute("name","cbTerritorioPorDefecto" );
      ((Element)v.get(32)).setAttribute("required","true" );
      ((Element)v.get(32)).setAttribute("cod","127" );
      ((Element)v.get(4)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(33)).setAttribute("name","cbSociedadPorDefecto" );
      ((Element)v.get(33)).setAttribute("required","true" );
      ((Element)v.get(33)).setAttribute("cod","121" );
      ((Element)v.get(4)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(34)).setAttribute("name","cbMarcaPorDefecto" );
      ((Element)v.get(34)).setAttribute("required","true" );
      ((Element)v.get(34)).setAttribute("cod","81" );
      ((Element)v.get(4)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(35)).setAttribute("name","cbCanalPorDefecto" );
      ((Element)v.get(35)).setAttribute("required","true" );
      ((Element)v.get(35)).setAttribute("cod","19" );
      ((Element)v.get(4)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(36)).setAttribute("name","cbAccesoPorDefecto" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(36)).setAttribute("required","true" );
      ((Element)v.get(36)).setAttribute("cod","11" );
      ((Element)v.get(4)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(37)).setAttribute("name","cbSubaccesoPorDefecto" );
      ((Element)v.get(37)).setAttribute("required","true" );
      ((Element)v.get(37)).setAttribute("cod","123" );
      ((Element)v.get(4)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(38)).setAttribute("name","cbTipoUsuario" );
      ((Element)v.get(38)).setAttribute("required","true" );
      ((Element)v.get(38)).setAttribute("cod","131" );
      ((Element)v.get(4)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(39)).setAttribute("name","cbIdioma" );
      ((Element)v.get(39)).setAttribute("required","true" );
      ((Element)v.get(39)).setAttribute("cod","71" );
      ((Element)v.get(4)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(40)).setAttribute("name","cbTipoRastreo" );
      ((Element)v.get(40)).setAttribute("required","true" );
      ((Element)v.get(40)).setAttribute("cod","108" );
      ((Element)v.get(4)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(41)).setAttribute("name","rbUsuarioHabilitado" );
      ((Element)v.get(41)).setAttribute("required","true" );
      ((Element)v.get(41)).setAttribute("cod","138" );
      ((Element)v.get(4)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(42)).setAttribute("name","txtFechaSustitucionDesde" );
      ((Element)v.get(42)).setAttribute("group","txtFechaSustitucionDesde" );
      ((Element)v.get(42)).setAttribute("required","false" );
      ((Element)v.get(42)).setAttribute("cod","168" );
      ((Element)v.get(42)).setAttribute("format","F" );
      ((Element)v.get(4)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(43)).setAttribute("name","txtFechaSustitucionHasta" );
      ((Element)v.get(43)).setAttribute("group","txtFechaSustitucionHasta" );
      ((Element)v.get(43)).setAttribute("required","false" );
      ((Element)v.get(43)).setAttribute("cod","2211" );
      ((Element)v.get(43)).setAttribute("format","F" );
      ((Element)v.get(4)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(44)).setAttribute("name","txtFechaInicioRastreo" );
      ((Element)v.get(44)).setAttribute("group","txtFechaInicioRastreo" );
      ((Element)v.get(44)).setAttribute("required","false" );
      ((Element)v.get(44)).setAttribute("cod","61" );
      ((Element)v.get(44)).setAttribute("format","F" );
      ((Element)v.get(4)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(45)).setAttribute("name","txtFechaFinRastreo" );
      ((Element)v.get(45)).setAttribute("group","txtFechaFinRastreo" );
      ((Element)v.get(45)).setAttribute("required","false" );
      ((Element)v.get(45)).setAttribute("cod","60" );
      ((Element)v.get(45)).setAttribute("format","F" );
      ((Element)v.get(4)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:4   */

      /* Empieza nodo:46 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(46)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(46)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","duplicado" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","accion" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(49)).setAttribute("valor","LPInsertarUsuarios" );
      ((Element)v.get(46)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","casodeuso" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","casoUso" );
      ((Element)v.get(51)).setAttribute("valor","insertar" );
      ((Element)v.get(46)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hIndicacionClaveInicial" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hUsuarioHabilitado" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hPerfil" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","hPais" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","hSubgerenciaVentas" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hRegion" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hZona" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","hSeccion" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","hTerritorio" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","hDepartamento" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","hSociedad" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","hMarca" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","hCanal" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","hAcceso" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","hSubnivelAcceso" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","hTipoUsuario" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","hFormatoFecha" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","hTipoRastreo" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","hUsuarioSustitucion" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","hFuncionDirecta" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","hPaisPorDefecto" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","hRegionPorDefecto" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 46   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","hZonaPorDefecto" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","hSeccionPorDefecto" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","hSGVPorDefecto" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","hTerritorioPorDefecto" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","hSociedadPorDefecto" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","hMarcaPorDefecto" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","hCanalPorDefecto" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","hAccesoPorDefecto" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","hSubaccesoPorDefecto" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 46   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","hUsuarioActual" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(46)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 46   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(87)).setAttribute("nombre","capa" );
      ((Element)v.get(46)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("table"));
      ((Element)v.get(88)).setAttribute("width","100%" );
      ((Element)v.get(88)).setAttribute("border","0" );
      ((Element)v.get(88)).setAttribute("cellspacing","0" );
      ((Element)v.get(88)).setAttribute("cellpadding","0" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("width","12" );
      ((Element)v.get(90)).setAttribute("align","center" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","12" );
      ((Element)v.get(91)).setAttribute("height","12" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("width","750" );
      ((Element)v.get(89)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("width","12" );
      ((Element)v.get(89)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","12" );
      ((Element)v.get(95)).setAttribute("height","1" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:89   */

      /* Empieza nodo:96 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(101)).setAttribute("class","legend" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(102)).setAttribute("nombre","lblDatosPrincipales" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("filas","1" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(102)).setAttribute("id","legend" );
      ((Element)v.get(102)).setAttribute("cod","00282" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 100   */
      v.add(doc.createElement("table"));
      ((Element)v.get(103)).setAttribute("width","100%" );
      ((Element)v.get(103)).setAttribute("border","0" );
      ((Element)v.get(103)).setAttribute("align","center" );
      ((Element)v.get(103)).setAttribute("cellspacing","0" );
      ((Element)v.get(103)).setAttribute("cellpadding","0" );
      ((Element)v.get(100)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("table"));
      ((Element)v.get(106)).setAttribute("width","688" );
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

      /* Empieza nodo:110 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(114)).setAttribute("nombre","lblUsuario" );
      ((Element)v.get(114)).setAttribute("alto","13" );
      ((Element)v.get(114)).setAttribute("filas","1" );
      ((Element)v.get(114)).setAttribute("valor","" );
      ((Element)v.get(114)).setAttribute("id","datosTitle" );
      ((Element)v.get(114)).setAttribute("cod","136" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","25" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(118)).setAttribute("nombre","lblClaveInicial" );
      ((Element)v.get(118)).setAttribute("alto","13" );
      ((Element)v.get(118)).setAttribute("filas","1" );
      ((Element)v.get(118)).setAttribute("valor","" );
      ((Element)v.get(118)).setAttribute("id","datosTitle" );
      ((Element)v.get(118)).setAttribute("cod","22" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","25" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(122)).setAttribute("nombre","lblClaveAcceso" );
      ((Element)v.get(122)).setAttribute("alto","13" );
      ((Element)v.get(122)).setAttribute("filas","1" );
      ((Element)v.get(122)).setAttribute("valor","" );
      ((Element)v.get(122)).setAttribute("id","datosTitle" );
      ((Element)v.get(122)).setAttribute("cod","21" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","25" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(126)).setAttribute("nombre","lblConfirmarClaveAcceso" );
      ((Element)v.get(126)).setAttribute("alto","13" );
      ((Element)v.get(126)).setAttribute("filas","1" );
      ((Element)v.get(126)).setAttribute("valor","" );
      ((Element)v.get(126)).setAttribute("id","datosTitle" );
      ((Element)v.get(126)).setAttribute("cod","42" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("width","100%" );
      ((Element)v.get(110)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:110   */

      /* Empieza nodo:129 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(129));

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
      ((Element)v.get(132)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(132)).setAttribute("valign","top" );
      ((Element)v.get(129)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(133)).setAttribute("nombre","txtUsuario" );
      ((Element)v.get(133)).setAttribute("id","datosCampos" );
      ((Element)v.get(133)).setAttribute("max","20" );
      ((Element)v.get(133)).setAttribute("tipo","" );
      ((Element)v.get(133)).setAttribute("onchange","" );
      ((Element)v.get(133)).setAttribute("req","S" );
      ((Element)v.get(133)).setAttribute("size","20" );
      ((Element)v.get(133)).setAttribute("valor","" );
      ((Element)v.get(133)).setAttribute("validacion","" );
      ((Element)v.get(133)).setAttribute("msjreq","" );
      ((Element)v.get(133)).setAttribute("onshtab","focalizaAnterior2();" );
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
      ((Element)v.get(136)).setAttribute("valign","top" );
      ((Element)v.get(136)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(129)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("table"));
      ((Element)v.get(137)).setAttribute("width","100%" );
      ((Element)v.get(137)).setAttribute("border","0" );
      ((Element)v.get(137)).setAttribute("cellspacing","0" );
      ((Element)v.get(137)).setAttribute("cellpadding","0" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("class","datosCampos" );
      ((Element)v.get(139)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(140)).setAttribute("nombre","rbClaveInicial" );
      ((Element)v.get(140)).setAttribute("tipo","H" );
      ((Element)v.get(140)).setAttribute("id","datosCampos" );
      ((Element)v.get(140)).setAttribute("req","S" );
      ((Element)v.get(140)).setAttribute("onshtab","focalizaAnterior();" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(141)).setAttribute("valor","S" );
      ((Element)v.get(141)).setAttribute("check","S" );
      ((Element)v.get(141)).setAttribute("onfocus","" );
      ((Element)v.get(141)).setAttribute("id","datosCampos" );
      ((Element)v.get(141)).setAttribute("cod","117" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Elemento padre:141 / Elemento actual: 142   */
      v.add(doc.createTextNode("yy"));
      ((Element)v.get(141)).appendChild((Text)v.get(142));

      /* Termina nodo Texto:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 140   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(143)).setAttribute("valor","N" );
      ((Element)v.get(143)).setAttribute("check","N" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(143)).setAttribute("onfocus","" );
      ((Element)v.get(143)).setAttribute("id","datosCampos" );
      ((Element)v.get(143)).setAttribute("cod","87" );
      ((Element)v.get(140)).appendChild((Element)v.get(143));

      /* Elemento padre:143 / Elemento actual: 144   */
      v.add(doc.createTextNode("nn"));
      ((Element)v.get(143)).appendChild((Text)v.get(144));

      /* Termina nodo Texto:144   */
      /* Termina nodo:143   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:145 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","25" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(147)).setAttribute("valign","top" );
      ((Element)v.get(129)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(148)).setAttribute("nombre","txtClaveAcceso" );
      ((Element)v.get(148)).setAttribute("id","datosCampos" );
      ((Element)v.get(148)).setAttribute("max","15" );
      ((Element)v.get(148)).setAttribute("tipo","password" );
      ((Element)v.get(148)).setAttribute("onchange","" );
      ((Element)v.get(148)).setAttribute("req","S" );
      ((Element)v.get(148)).setAttribute("size","20" );
      ((Element)v.get(148)).setAttribute("valor","" );
      ((Element)v.get(148)).setAttribute("validacion","" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","25" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(151)).setAttribute("valign","top" );
      ((Element)v.get(129)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(152)).setAttribute("nombre","txtConfirmarClaveAcceso" );
      ((Element)v.get(152)).setAttribute("id","datosCampos" );
      ((Element)v.get(152)).setAttribute("max","15" );
      ((Element)v.get(152)).setAttribute("tipo","password" );
      ((Element)v.get(152)).setAttribute("onchange","" );
      ((Element)v.get(152)).setAttribute("req","S" );
      ((Element)v.get(152)).setAttribute("size","20" );
      ((Element)v.get(152)).setAttribute("valor","" );
      ((Element)v.get(152)).setAttribute("validacion","" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("width","100%" );
      ((Element)v.get(129)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","8" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:129   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:155 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("table"));
      ((Element)v.get(157)).setAttribute("width","688" );
      ((Element)v.get(157)).setAttribute("border","0" );
      ((Element)v.get(157)).setAttribute("align","left" );
      ((Element)v.get(157)).setAttribute("cellspacing","0" );
      ((Element)v.get(157)).setAttribute("cellpadding","0" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).setAttribute("colspan","4" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","8" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:161 / Elemento padre: 157   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(157)).appendChild((Element)v.get(161));

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
      ((Element)v.get(161)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(165)).setAttribute("nombre","lblPerfil" );
      ((Element)v.get(165)).setAttribute("alto","13" );
      ((Element)v.get(165)).setAttribute("filas","1" );
      ((Element)v.get(165)).setAttribute("valor","" );
      ((Element)v.get(165)).setAttribute("id","datosTitle" );
      ((Element)v.get(165)).setAttribute("cod","104" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","25" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(169)).setAttribute("nombre","lblUsuarioHabilitado" );
      ((Element)v.get(169)).setAttribute("alto","13" );
      ((Element)v.get(169)).setAttribute("filas","1" );
      ((Element)v.get(169)).setAttribute("valor","" );
      ((Element)v.get(169)).setAttribute("id","datosTitle" );
      ((Element)v.get(169)).setAttribute("cod","138" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","25" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(173)).setAttribute("nombre","lblFechaCambioClave" );
      ((Element)v.get(173)).setAttribute("alto","13" );
      ((Element)v.get(173)).setAttribute("filas","1" );
      ((Element)v.get(173)).setAttribute("valor","" );
      ((Element)v.get(173)).setAttribute("id","datosTitle" );
      ((Element)v.get(173)).setAttribute("cod","170" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).setAttribute("width","100%" );
      ((Element)v.get(161)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","8" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:161   */

      /* Empieza nodo:176 / Elemento padre: 157   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(157)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","8" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(176)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(180)).setAttribute("nombre","cbPerfil" );
      ((Element)v.get(180)).setAttribute("id","datosCampos" );
      ((Element)v.get(180)).setAttribute("size","5" );
      ((Element)v.get(180)).setAttribute("multiple","S" );
      ((Element)v.get(180)).setAttribute("req","S" );
      ((Element)v.get(180)).setAttribute("valorinicial","" );
      ((Element)v.get(180)).setAttribute("textoinicial","" );
      ((Element)v.get(180)).setAttribute("onchange","actualizarSeleccion('cbPerfil');" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:182 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","25" );
      ((Element)v.get(183)).setAttribute("height","8" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(184)).setAttribute("valign","top" );
      ((Element)v.get(176)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("table"));
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(187)).setAttribute("class","datosCampos" );
      ((Element)v.get(187)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(188)).setAttribute("nombre","rbUsuarioHabilitado" );
      ((Element)v.get(188)).setAttribute("tipo","H" );
      ((Element)v.get(188)).setAttribute("id","datosCampos" );
      ((Element)v.get(188)).setAttribute("req","N" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(189)).setAttribute("valor","S" );
      ((Element)v.get(189)).setAttribute("check","S" );
      ((Element)v.get(189)).setAttribute("onfocus","" );
      ((Element)v.get(189)).setAttribute("id","datosCampos" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Elemento padre:189 / Elemento actual: 190   */
      v.add(doc.createTextNode("Si"));
      ((Element)v.get(189)).appendChild((Text)v.get(190));

      /* Termina nodo Texto:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 188   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(191)).setAttribute("valor","N" );
      ((Element)v.get(191)).setAttribute("check","N" );
      ((Element)v.get(191)).setAttribute("onfocus","" );
      ((Element)v.get(191)).setAttribute("id","datosCampos" );
      ((Element)v.get(188)).appendChild((Element)v.get(191));

      /* Elemento padre:191 / Elemento actual: 192   */
      v.add(doc.createTextNode("No"));
      ((Element)v.get(191)).appendChild((Text)v.get(192));

      /* Termina nodo Texto:192   */
      /* Termina nodo:191   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:193 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","25" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).setAttribute("valign","top" );
      ((Element)v.get(176)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(196)).setAttribute("nombre","txtFechaCambioClave" );
      ((Element)v.get(196)).setAttribute("alto","13" );
      ((Element)v.get(196)).setAttribute("filas","1" );
      ((Element)v.get(196)).setAttribute("valor","" );
      ((Element)v.get(196)).setAttribute("id","datosCampos" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("width","100%" );
      ((Element)v.get(176)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","8" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:176   */

      /* Empieza nodo:199 / Elemento padre: 157   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(157)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).setAttribute("colspan","4" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:103   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:202 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:96   */

      /* Empieza nodo:204 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("colspan","4" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","8" );
      ((Element)v.get(206)).setAttribute("height","15" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:207 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(212)).setAttribute("class","legend" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(213)).setAttribute("nombre","lblDatosPersonales" );
      ((Element)v.get(213)).setAttribute("alto","13" );
      ((Element)v.get(213)).setAttribute("filas","1" );
      ((Element)v.get(213)).setAttribute("valor","" );
      ((Element)v.get(213)).setAttribute("id","legend" );
      ((Element)v.get(213)).setAttribute("cod","00508" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 211   */
      v.add(doc.createElement("table"));
      ((Element)v.get(214)).setAttribute("width","100%" );
      ((Element)v.get(214)).setAttribute("border","0" );
      ((Element)v.get(214)).setAttribute("align","center" );
      ((Element)v.get(214)).setAttribute("cellspacing","0" );
      ((Element)v.get(214)).setAttribute("cellpadding","0" );
      ((Element)v.get(211)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("table"));
      ((Element)v.get(217)).setAttribute("width","688" );
      ((Element)v.get(217)).setAttribute("border","0" );
      ((Element)v.get(217)).setAttribute("align","left" );
      ((Element)v.get(217)).setAttribute("cellspacing","0" );
      ((Element)v.get(217)).setAttribute("cellpadding","0" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).setAttribute("colspan","4" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","8" );
      ((Element)v.get(220)).setAttribute("height","8" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:221 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(217)).appendChild((Element)v.get(221));

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
      ((Element)v.get(225)).setAttribute("nombre","lblPrimerApellido" );
      ((Element)v.get(225)).setAttribute("alto","13" );
      ((Element)v.get(225)).setAttribute("filas","1" );
      ((Element)v.get(225)).setAttribute("valor","" );
      ((Element)v.get(225)).setAttribute("id","datosTitle" );
      ((Element)v.get(225)).setAttribute("cod","16" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","25" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(229)).setAttribute("nombre","lblSegundoApellido" );
      ((Element)v.get(229)).setAttribute("alto","13" );
      ((Element)v.get(229)).setAttribute("filas","1" );
      ((Element)v.get(229)).setAttribute("valor","" );
      ((Element)v.get(229)).setAttribute("id","datosTitle" );
      ((Element)v.get(229)).setAttribute("cod","17" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","25" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(233)).setAttribute("nombre","lblApellidoCasada" );
      ((Element)v.get(233)).setAttribute("alto","13" );
      ((Element)v.get(233)).setAttribute("filas","1" );
      ((Element)v.get(233)).setAttribute("valor","" );
      ((Element)v.get(233)).setAttribute("id","datosTitle" );
      ((Element)v.get(233)).setAttribute("cod","18" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).setAttribute("width","100%" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(221)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","8" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:221   */

      /* Empieza nodo:236 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(217)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","8" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(236)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(240)).setAttribute("nombre","txtPrimerApellido" );
      ((Element)v.get(240)).setAttribute("id","datosCampos" );
      ((Element)v.get(240)).setAttribute("max","25" );
      ((Element)v.get(240)).setAttribute("tipo","" );
      ((Element)v.get(240)).setAttribute("onchange","" );
      ((Element)v.get(240)).setAttribute("req","S" );
      ((Element)v.get(240)).setAttribute("size","25" );
      ((Element)v.get(240)).setAttribute("valor","" );
      ((Element)v.get(240)).setAttribute("validacion","" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","25" );
      ((Element)v.get(242)).setAttribute("height","8" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(236)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(244)).setAttribute("nombre","txtSegundoApellido" );
      ((Element)v.get(244)).setAttribute("id","datosCampos" );
      ((Element)v.get(244)).setAttribute("max","25" );
      ((Element)v.get(244)).setAttribute("tipo","" );
      ((Element)v.get(244)).setAttribute("onchange","" );
      ((Element)v.get(244)).setAttribute("req","S" );
      ((Element)v.get(244)).setAttribute("size","25" );
      ((Element)v.get(244)).setAttribute("valor","" );
      ((Element)v.get(244)).setAttribute("validacion","" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("width","25" );
      ((Element)v.get(246)).setAttribute("height","8" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(236)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(248)).setAttribute("nombre","txtApellidoCasada" );
      ((Element)v.get(248)).setAttribute("id","datosCampos" );
      ((Element)v.get(248)).setAttribute("max","25" );
      ((Element)v.get(248)).setAttribute("tipo","" );
      ((Element)v.get(248)).setAttribute("onchange","" );
      ((Element)v.get(248)).setAttribute("req","N" );
      ((Element)v.get(248)).setAttribute("size","25" );
      ((Element)v.get(248)).setAttribute("valor","" );
      ((Element)v.get(248)).setAttribute("validacion","" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).setAttribute("width","100%" );
      ((Element)v.get(236)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).setAttribute("width","8" );
      ((Element)v.get(250)).setAttribute("height","8" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:236   */

      /* Empieza nodo:251 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(217)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).setAttribute("colspan","4" );
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
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:254 / Elemento padre: 214   */
      v.add(doc.createElement("tr"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(214)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("table"));
      ((Element)v.get(256)).setAttribute("width","688" );
      ((Element)v.get(256)).setAttribute("border","0" );
      ((Element)v.get(256)).setAttribute("align","left" );
      ((Element)v.get(256)).setAttribute("cellspacing","0" );
      ((Element)v.get(256)).setAttribute("cellpadding","0" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","8" );
      ((Element)v.get(259)).setAttribute("height","8" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(261)).setAttribute("nombre","lblPrimerNombre" );
      ((Element)v.get(261)).setAttribute("alto","13" );
      ((Element)v.get(261)).setAttribute("filas","1" );
      ((Element)v.get(261)).setAttribute("valor","" );
      ((Element)v.get(261)).setAttribute("id","datosTitle" );
      ((Element)v.get(261)).setAttribute("cod","93" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","25" );
      ((Element)v.get(263)).setAttribute("height","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(265)).setAttribute("nombre","lblSegundoNombre" );
      ((Element)v.get(265)).setAttribute("alto","13" );
      ((Element)v.get(265)).setAttribute("filas","1" );
      ((Element)v.get(265)).setAttribute("valor","" );
      ((Element)v.get(265)).setAttribute("id","datosTitle" );
      ((Element)v.get(265)).setAttribute("cod","94" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(267)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).setAttribute("width","25" );
      ((Element)v.get(267)).setAttribute("height","8" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(269)).setAttribute("nombre","lblEmail" );
      ((Element)v.get(269)).setAttribute("alto","13" );
      ((Element)v.get(269)).setAttribute("filas","1" );
      ((Element)v.get(269)).setAttribute("valor","" );
      ((Element)v.get(269)).setAttribute("id","datosTitle" );
      ((Element)v.get(269)).setAttribute("cod","55" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).setAttribute("width","100%" );
      ((Element)v.get(257)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","8" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:257   */

      /* Empieza nodo:272 / Elemento padre: 256   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(256)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(274)).setAttribute("width","8" );
      ((Element)v.get(274)).setAttribute("height","8" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(272)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(276)).setAttribute("nombre","txtPrimerNombre" );
      ((Element)v.get(276)).setAttribute("id","datosCampos" );
      ((Element)v.get(276)).setAttribute("max","25" );
      ((Element)v.get(276)).setAttribute("tipo","" );
      ((Element)v.get(276)).setAttribute("onchange","" );
      ((Element)v.get(276)).setAttribute("req","S" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(276)).setAttribute("size","25" );
      ((Element)v.get(276)).setAttribute("valor","" );
      ((Element)v.get(276)).setAttribute("validacion","" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).setAttribute("width","25" );
      ((Element)v.get(278)).setAttribute("height","8" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(272)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(280)).setAttribute("nombre","txtSegundoNombre" );
      ((Element)v.get(280)).setAttribute("id","datosCampos" );
      ((Element)v.get(280)).setAttribute("max","25" );
      ((Element)v.get(280)).setAttribute("tipo","" );
      ((Element)v.get(280)).setAttribute("onchange","" );
      ((Element)v.get(280)).setAttribute("req","S" );
      ((Element)v.get(280)).setAttribute("size","25" );
      ((Element)v.get(280)).setAttribute("valor","" );
      ((Element)v.get(280)).setAttribute("validacion","" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:281 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).setAttribute("width","25" );
      ((Element)v.get(282)).setAttribute("height","8" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(283)).setAttribute("valign","bottom" );
      ((Element)v.get(272)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(284)).setAttribute("nombre","txtEmail" );
      ((Element)v.get(284)).setAttribute("id","datosCampos" );
      ((Element)v.get(284)).setAttribute("max","40" );
      ((Element)v.get(284)).setAttribute("tipo","" );
      ((Element)v.get(284)).setAttribute("onchange","" );
      ((Element)v.get(284)).setAttribute("req","N" );
      ((Element)v.get(284)).setAttribute("size","40" );
      ((Element)v.get(284)).setAttribute("valor","" );
      ((Element)v.get(284)).setAttribute("validacion","" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).setAttribute("width","100%" );
      ((Element)v.get(272)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(286)).setAttribute("src","b.gif" );
      ((Element)v.get(286)).setAttribute("width","8" );
      ((Element)v.get(286)).setAttribute("height","8" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:272   */

      /* Empieza nodo:287 / Elemento padre: 256   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(256)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).setAttribute("colspan","4" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","8" );
      ((Element)v.get(289)).setAttribute("height","8" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */
      /* Termina nodo:287   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:290 / Elemento padre: 214   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(214)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("table"));
      ((Element)v.get(292)).setAttribute("width","688" );
      ((Element)v.get(292)).setAttribute("border","0" );
      ((Element)v.get(292)).setAttribute("align","left" );
      ((Element)v.get(292)).setAttribute("cellspacing","0" );
      ((Element)v.get(292)).setAttribute("cellpadding","0" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(295)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).setAttribute("width","8" );
      ((Element)v.get(295)).setAttribute("height","8" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(297)).setAttribute("nombre","lblTelefono" );
      ((Element)v.get(297)).setAttribute("alto","13" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(297)).setAttribute("filas","1" );
      ((Element)v.get(297)).setAttribute("valor","" );
      ((Element)v.get(297)).setAttribute("id","datosTitle" );
      ((Element)v.get(297)).setAttribute("cod","125" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:298 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(299)).setAttribute("src","b.gif" );
      ((Element)v.get(299)).setAttribute("width","25" );
      ((Element)v.get(299)).setAttribute("height","8" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:300 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(301)).setAttribute("nombre","lblDepartamento" );
      ((Element)v.get(301)).setAttribute("alto","13" );
      ((Element)v.get(301)).setAttribute("filas","1" );
      ((Element)v.get(301)).setAttribute("valor","" );
      ((Element)v.get(301)).setAttribute("id","datosTitle" );
      ((Element)v.get(301)).setAttribute("cod","45" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:302 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(303)).setAttribute("src","b.gif" );
      ((Element)v.get(303)).setAttribute("width","25" );
      ((Element)v.get(303)).setAttribute("height","8" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:304 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(305)).setAttribute("nombre","lblIdentificadorPC" );
      ((Element)v.get(305)).setAttribute("alto","13" );
      ((Element)v.get(305)).setAttribute("filas","1" );
      ((Element)v.get(305)).setAttribute("valor","" );
      ((Element)v.get(305)).setAttribute("id","datosTitle" );
      ((Element)v.get(305)).setAttribute("cod","70" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
      ((Element)v.get(307)).setAttribute("width","25" );
      ((Element)v.get(307)).setAttribute("height","8" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(309)).setAttribute("nombre","lblValidezDesde" );
      ((Element)v.get(309)).setAttribute("alto","13" );
      ((Element)v.get(309)).setAttribute("filas","1" );
      ((Element)v.get(309)).setAttribute("valor","" );
      ((Element)v.get(309)).setAttribute("id","datosTitle" );
      ((Element)v.get(309)).setAttribute("cod","141" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","25" );
      ((Element)v.get(311)).setAttribute("height","8" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(313)).setAttribute("nombre","lblHasta" );
      ((Element)v.get(313)).setAttribute("alto","13" );
      ((Element)v.get(313)).setAttribute("filas","1" );
      ((Element)v.get(313)).setAttribute("valor","" );
      ((Element)v.get(313)).setAttribute("id","datosTitle" );
      ((Element)v.get(313)).setAttribute("cod","142" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(314)).setAttribute("width","100%" );
      ((Element)v.get(293)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(315)).setAttribute("width","8" );
      ((Element)v.get(315)).setAttribute("height","8" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */
      /* Termina nodo:293   */

      /* Empieza nodo:316 / Elemento padre: 292   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(292)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).setAttribute("width","8" );
      ((Element)v.get(318)).setAttribute("height","8" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 316   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(319)).setAttribute("valign","bottom" );
      ((Element)v.get(316)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(320)).setAttribute("nombre","txtTelefono" );
      ((Element)v.get(320)).setAttribute("id","datosCampos" );
      ((Element)v.get(320)).setAttribute("max","12" );
      ((Element)v.get(320)).setAttribute("tipo","" );
      ((Element)v.get(320)).setAttribute("onchange","" );
      ((Element)v.get(320)).setAttribute("req","N" );
      ((Element)v.get(320)).setAttribute("size","15" );
      ((Element)v.get(320)).setAttribute("valor","" );
      ((Element)v.get(320)).setAttribute("validacion","" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:321 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(322)).setAttribute("src","b.gif" );
      ((Element)v.get(322)).setAttribute("width","25" );
      ((Element)v.get(322)).setAttribute("height","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:323 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(316)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(324)).setAttribute("nombre","cbDepartamento" );
      ((Element)v.get(324)).setAttribute("id","datosCampos" );
      ((Element)v.get(324)).setAttribute("size","1" );
      ((Element)v.get(324)).setAttribute("multiple","N" );
      ((Element)v.get(324)).setAttribute("req","N" );
      ((Element)v.get(324)).setAttribute("valorinicial","" );
      ((Element)v.get(324)).setAttribute("textoinicial","" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:326 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(327)).setAttribute("src","b.gif" );
      ((Element)v.get(327)).setAttribute("width","25" );
      ((Element)v.get(327)).setAttribute("height","8" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(328)).setAttribute("valign","bottom" );
      ((Element)v.get(316)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(329)).setAttribute("nombre","txtIdentificadorPC" );
      ((Element)v.get(329)).setAttribute("id","datosCampos" );
      ((Element)v.get(329)).setAttribute("max","20" );
      ((Element)v.get(329)).setAttribute("tipo","" );
      ((Element)v.get(329)).setAttribute("onchange","" );
      ((Element)v.get(329)).setAttribute("req","N" );
      ((Element)v.get(329)).setAttribute("size","27" );
      ((Element)v.get(329)).setAttribute("valor","" );
      ((Element)v.get(329)).setAttribute("validacion","" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","25" );
      ((Element)v.get(331)).setAttribute("height","8" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(316)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(333)).setAttribute("nombre","txtValidezDesde" );
      ((Element)v.get(333)).setAttribute("id","datosCampos" );
      ((Element)v.get(333)).setAttribute("max","10" );
      ((Element)v.get(333)).setAttribute("tipo","" );
      ((Element)v.get(333)).setAttribute("onchange","" );
      ((Element)v.get(333)).setAttribute("req","S" );
      ((Element)v.get(333)).setAttribute("size","13" );
      ((Element)v.get(333)).setAttribute("valor","" );
      ((Element)v.get(333)).setAttribute("validacion","" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */

      /* Empieza nodo:334 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(335)).setAttribute("src","b.gif" );
      ((Element)v.get(335)).setAttribute("width","25" );
      ((Element)v.get(335)).setAttribute("height","8" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:336 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(336)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(316)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("CTEXTO"));
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(337)).setAttribute("nombre","txtValidezHasta" );
      ((Element)v.get(337)).setAttribute("id","datosCampos" );
      ((Element)v.get(337)).setAttribute("max","10" );
      ((Element)v.get(337)).setAttribute("tipo","" );
      ((Element)v.get(337)).setAttribute("onchange","" );
      ((Element)v.get(337)).setAttribute("req","S" );
      ((Element)v.get(337)).setAttribute("size","13" );
      ((Element)v.get(337)).setAttribute("valor","" );
      ((Element)v.get(337)).setAttribute("validacion","" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:338 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(338)).setAttribute("width","100%" );
      ((Element)v.get(316)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(339)).setAttribute("src","b.gif" );
      ((Element)v.get(339)).setAttribute("width","8" );
      ((Element)v.get(339)).setAttribute("height","8" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:338   */
      /* Termina nodo:316   */

      /* Empieza nodo:340 / Elemento padre: 292   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(292)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).setAttribute("colspan","4" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","8" );
      ((Element)v.get(342)).setAttribute("height","8" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */
      /* Termina nodo:340   */
      /* Termina nodo:292   */
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:214   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:343 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */
      /* Termina nodo:207   */

      /* Empieza nodo:345 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).setAttribute("colspan","4" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(347)).setAttribute("src","b.gif" );
      ((Element)v.get(347)).setAttribute("width","8" );
      ((Element)v.get(347)).setAttribute("height","15" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:348 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(350)).setAttribute("src","b.gif" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(353)).setAttribute("class","legend" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(354)).setAttribute("nombre","lblDatosComplementarios" );
      ((Element)v.get(354)).setAttribute("alto","13" );
      ((Element)v.get(354)).setAttribute("filas","1" );
      ((Element)v.get(354)).setAttribute("valor","" );
      ((Element)v.get(354)).setAttribute("id","legend" );
      ((Element)v.get(354)).setAttribute("cod","00509" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:355 / Elemento padre: 352   */
      v.add(doc.createElement("table"));
      ((Element)v.get(355)).setAttribute("width","100%" );
      ((Element)v.get(355)).setAttribute("border","0" );
      ((Element)v.get(355)).setAttribute("align","center" );
      ((Element)v.get(355)).setAttribute("cellspacing","0" );
      ((Element)v.get(355)).setAttribute("cellpadding","0" );
      ((Element)v.get(352)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("td"));
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("table"));
      ((Element)v.get(358)).setAttribute("width","688" );
      ((Element)v.get(358)).setAttribute("border","0" );
      ((Element)v.get(358)).setAttribute("align","left" );
      ((Element)v.get(358)).setAttribute("cellspacing","0" );
      ((Element)v.get(358)).setAttribute("cellpadding","0" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("td"));
      ((Element)v.get(360)).setAttribute("colspan","4" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(361)).setAttribute("src","b.gif" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(361)).setAttribute("width","8" );
      ((Element)v.get(361)).setAttribute("height","8" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:362 / Elemento padre: 358   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(358)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("td"));
      ((Element)v.get(362)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(364)).setAttribute("src","b.gif" );
      ((Element)v.get(364)).setAttribute("width","8" );
      ((Element)v.get(364)).setAttribute("height","8" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */

      /* Empieza nodo:365 / Elemento padre: 362   */
      v.add(doc.createElement("td"));
      ((Element)v.get(362)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(366)).setAttribute("nombre","lblSociedad" );
      ((Element)v.get(366)).setAttribute("alto","13" );
      ((Element)v.get(366)).setAttribute("filas","1" );
      ((Element)v.get(366)).setAttribute("valor","" );
      ((Element)v.get(366)).setAttribute("id","datosTitle" );
      ((Element)v.get(366)).setAttribute("cod","120" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:367 / Elemento padre: 362   */
      v.add(doc.createElement("td"));
      ((Element)v.get(362)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(368)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).setAttribute("width","25" );
      ((Element)v.get(368)).setAttribute("height","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */

      /* Empieza nodo:369 / Elemento padre: 362   */
      v.add(doc.createElement("td"));
      ((Element)v.get(362)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(370)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(370)).setAttribute("alto","13" );
      ((Element)v.get(370)).setAttribute("filas","1" );
      ((Element)v.get(370)).setAttribute("valor","Marca" );
      ((Element)v.get(370)).setAttribute("id","datosTitle" );
      ((Element)v.get(370)).setAttribute("cod","6" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */
      /* Termina nodo:369   */

      /* Empieza nodo:371 / Elemento padre: 362   */
      v.add(doc.createElement("td"));
      ((Element)v.get(371)).setAttribute("width","100%" );
      ((Element)v.get(362)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(372)).setAttribute("src","b.gif" );
      ((Element)v.get(372)).setAttribute("width","8" );
      ((Element)v.get(372)).setAttribute("height","8" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */
      /* Termina nodo:362   */

      /* Empieza nodo:373 / Elemento padre: 358   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(358)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(375)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).setAttribute("width","8" );
      ((Element)v.get(375)).setAttribute("height","8" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:376 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(376)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(373)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(377)).setAttribute("nombre","cbSociedad" );
      ((Element)v.get(377)).setAttribute("id","datosCampos" );
      ((Element)v.get(377)).setAttribute("size","5" );
      ((Element)v.get(377)).setAttribute("multiple","S" );
      ((Element)v.get(377)).setAttribute("req","S" );
      ((Element)v.get(377)).setAttribute("valorinicial","" );
      ((Element)v.get(377)).setAttribute("textoinicial","" );
      ((Element)v.get(377)).setAttribute("onchange","actualizarSeleccion('cbSociedad');" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:379 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(373)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(380)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).setAttribute("width","25" );
      ((Element)v.get(380)).setAttribute("height","8" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(381)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(373)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(382)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(382)).setAttribute("id","datosCampos" );
      ((Element)v.get(382)).setAttribute("size","5" );
      ((Element)v.get(382)).setAttribute("multiple","S" );
      ((Element)v.get(382)).setAttribute("req","S" );
      ((Element)v.get(382)).setAttribute("valorinicial","" );
      ((Element)v.get(382)).setAttribute("textoinicial","" );
      ((Element)v.get(382)).setAttribute("onchange","actualizarSeleccion('cbMarca');" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:384 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).setAttribute("width","100%" );
      ((Element)v.get(373)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(385)).setAttribute("width","8" );
      ((Element)v.get(385)).setAttribute("height","8" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */
      /* Termina nodo:373   */

      /* Empieza nodo:386 / Elemento padre: 358   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(358)).appendChild((Element)v.get(386));

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
      /* Termina nodo:358   */
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:389 / Elemento padre: 355   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(355)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("td"));
      ((Element)v.get(389)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("table"));
      ((Element)v.get(391)).setAttribute("width","688" );
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
      ((Element)v.get(396)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(396)).setAttribute("alto","13" );
      ((Element)v.get(396)).setAttribute("filas","1" );
      ((Element)v.get(396)).setAttribute("valor","" );
      ((Element)v.get(396)).setAttribute("id","datosTitle" );
      ((Element)v.get(396)).setAttribute("cod","7" );
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
      ((Element)v.get(400)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(400)).setAttribute("alto","13" );
      ((Element)v.get(400)).setAttribute("filas","1" );
      ((Element)v.get(400)).setAttribute("valor","" );
      ((Element)v.get(400)).setAttribute("id","datosTitle" );
      ((Element)v.get(400)).setAttribute("cod","10" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:401 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(401)).setAttribute("width","100%" );
      ((Element)v.get(392)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(402)).setAttribute("src","b.gif" );
      ((Element)v.get(402)).setAttribute("width","8" );
      ((Element)v.get(402)).setAttribute("height","8" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */
      /* Termina nodo:392   */

      /* Empieza nodo:403 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(405)).setAttribute("src","b.gif" );
      ((Element)v.get(405)).setAttribute("width","8" );
      ((Element)v.get(405)).setAttribute("height","8" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:406 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(406)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(403)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(407)).setAttribute("nombre","cbCanal" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(407)).setAttribute("id","datosCampos" );
      ((Element)v.get(407)).setAttribute("size","5" );
      ((Element)v.get(407)).setAttribute("multiple","S" );
      ((Element)v.get(407)).setAttribute("req","S" );
      ((Element)v.get(407)).setAttribute("valorinicial","" );
      ((Element)v.get(407)).setAttribute("textoinicial","" );
      ((Element)v.get(407)).setAttribute("onchange","actualizarSeleccion('cbCanal');" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */
      /* Termina nodo:406   */

      /* Empieza nodo:409 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(410)).setAttribute("src","b.gif" );
      ((Element)v.get(410)).setAttribute("width","25" );
      ((Element)v.get(410)).setAttribute("height","8" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:411 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(411)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(403)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(412)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(412)).setAttribute("id","datosCampos" );
      ((Element)v.get(412)).setAttribute("size","5" );
      ((Element)v.get(412)).setAttribute("multiple","S" );
      ((Element)v.get(412)).setAttribute("req","S" );
      ((Element)v.get(412)).setAttribute("valorinicial","" );
      ((Element)v.get(412)).setAttribute("textoinicial","" );
      ((Element)v.get(412)).setAttribute("onchange","actualizarSeleccion('cbAcceso');" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */
      /* Termina nodo:411   */

      /* Empieza nodo:414 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(414)).setAttribute("width","100%" );
      ((Element)v.get(403)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(415)).setAttribute("src","b.gif" );
      ((Element)v.get(415)).setAttribute("width","8" );
      ((Element)v.get(415)).setAttribute("height","8" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */
      /* Termina nodo:414   */
      /* Termina nodo:403   */

      /* Empieza nodo:416 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).setAttribute("colspan","4" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(418)).setAttribute("src","b.gif" );
      ((Element)v.get(418)).setAttribute("width","8" );
      ((Element)v.get(418)).setAttribute("height","8" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */
      /* Termina nodo:416   */
      /* Termina nodo:391   */
      /* Termina nodo:390   */
      /* Termina nodo:389   */

      /* Empieza nodo:419 / Elemento padre: 355   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(355)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("td"));
      ((Element)v.get(419)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("table"));
      ((Element)v.get(421)).setAttribute("width","688" );
      ((Element)v.get(421)).setAttribute("border","0" );
      ((Element)v.get(421)).setAttribute("align","left" );
      ((Element)v.get(421)).setAttribute("cellspacing","0" );
      ((Element)v.get(421)).setAttribute("cellpadding","0" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(421)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(424)).setAttribute("src","b.gif" );
      ((Element)v.get(424)).setAttribute("width","8" );
      ((Element)v.get(424)).setAttribute("height","8" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:423   */

      /* Empieza nodo:425 / Elemento padre: 422   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(426)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(426)).setAttribute("alto","13" );
      ((Element)v.get(426)).setAttribute("filas","1" );
      ((Element)v.get(426)).setAttribute("valor","" );
      ((Element)v.get(426)).setAttribute("id","datosTitle" );
      ((Element)v.get(426)).setAttribute("cod","122" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:425   */

      /* Empieza nodo:427 / Elemento padre: 422   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(428)).setAttribute("src","b.gif" );
      ((Element)v.get(428)).setAttribute("width","25" );
      ((Element)v.get(428)).setAttribute("height","8" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */

      /* Empieza nodo:429 / Elemento padre: 422   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(430)).setAttribute("nombre","lblPais" );
      ((Element)v.get(430)).setAttribute("alto","13" );
      ((Element)v.get(430)).setAttribute("filas","1" );
      ((Element)v.get(430)).setAttribute("valor","" );
      ((Element)v.get(430)).setAttribute("id","datosTitle" );
      ((Element)v.get(430)).setAttribute("cod","5" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:429   */

      /* Empieza nodo:431 / Elemento padre: 422   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).setAttribute("width","100%" );
      ((Element)v.get(422)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(432)).setAttribute("src","b.gif" );
      ((Element)v.get(432)).setAttribute("width","8" );
      ((Element)v.get(432)).setAttribute("height","8" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:431   */
      /* Termina nodo:422   */

      /* Empieza nodo:433 / Elemento padre: 421   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(421)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("td"));
      ((Element)v.get(433)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(435)).setAttribute("src","b.gif" );
      ((Element)v.get(435)).setAttribute("width","8" );
      ((Element)v.get(435)).setAttribute("height","8" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */

      /* Empieza nodo:436 / Elemento padre: 433   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(433)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(437)).setAttribute("nombre","cbSubacceso" );
      ((Element)v.get(437)).setAttribute("id","datosCampos" );
      ((Element)v.get(437)).setAttribute("size","5" );
      ((Element)v.get(437)).setAttribute("multiple","S" );
      ((Element)v.get(437)).setAttribute("req","S" );
      ((Element)v.get(437)).setAttribute("valorinicial","" );
      ((Element)v.get(437)).setAttribute("textoinicial","" );
      ((Element)v.get(437)).setAttribute("onchange","actualizarSeleccion('cbSubacceso');" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:437   */
      /* Termina nodo:436   */

      /* Empieza nodo:439 / Elemento padre: 433   */
      v.add(doc.createElement("td"));
      ((Element)v.get(433)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(440)).setAttribute("src","b.gif" );
      ((Element)v.get(440)).setAttribute("width","25" );
      ((Element)v.get(440)).setAttribute("height","8" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:439   */

      /* Empieza nodo:441 / Elemento padre: 433   */
      v.add(doc.createElement("td"));
      ((Element)v.get(441)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(433)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(442)).setAttribute("nombre","cbPais" );
      ((Element)v.get(442)).setAttribute("id","datosCampos" );
      ((Element)v.get(442)).setAttribute("size","5" );
      ((Element)v.get(442)).setAttribute("multiple","S" );
      ((Element)v.get(442)).setAttribute("req","S" );
      ((Element)v.get(442)).setAttribute("valorinicial","" );
      ((Element)v.get(442)).setAttribute("textoinicial","" );
      ((Element)v.get(442)).setAttribute("onchange","actualizarSeleccion('cbPais');" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(442)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:442   */
      /* Termina nodo:441   */

      /* Empieza nodo:444 / Elemento padre: 433   */
      v.add(doc.createElement("td"));
      ((Element)v.get(444)).setAttribute("width","100%" );
      ((Element)v.get(433)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(445)).setAttribute("src","b.gif" );
      ((Element)v.get(445)).setAttribute("width","8" );
      ((Element)v.get(445)).setAttribute("height","8" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:444   */
      /* Termina nodo:433   */

      /* Empieza nodo:446 / Elemento padre: 421   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(421)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("td"));
      ((Element)v.get(447)).setAttribute("colspan","4" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(448)).setAttribute("src","b.gif" );
      ((Element)v.get(448)).setAttribute("width","8" );
      ((Element)v.get(448)).setAttribute("height","8" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */
      /* Termina nodo:447   */
      /* Termina nodo:446   */
      /* Termina nodo:421   */
      /* Termina nodo:420   */
      /* Termina nodo:419   */

      /* Empieza nodo:449 / Elemento padre: 355   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(355)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("td"));
      ((Element)v.get(449)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("table"));
      ((Element)v.get(451)).setAttribute("width","688" );
      ((Element)v.get(451)).setAttribute("border","0" );
      ((Element)v.get(451)).setAttribute("align","left" );
      ((Element)v.get(451)).setAttribute("cellspacing","0" );
      ((Element)v.get(451)).setAttribute("cellpadding","0" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(451)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(452)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(454)).setAttribute("src","b.gif" );
      ((Element)v.get(454)).setAttribute("width","8" );
      ((Element)v.get(454)).setAttribute("height","8" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */

      /* Empieza nodo:455 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(452)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(456)).setAttribute("nombre","lblSubgerenciaVentas" );
      ((Element)v.get(456)).setAttribute("alto","13" );
      ((Element)v.get(456)).setAttribute("filas","1" );
      ((Element)v.get(456)).setAttribute("valor","" );
      ((Element)v.get(456)).setAttribute("id","datosTitle" );
      ((Element)v.get(456)).setAttribute("cod","124" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:455   */

      /* Empieza nodo:457 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(457)).setAttribute("width","100%" );
      ((Element)v.get(452)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(458)).setAttribute("src","b.gif" );
      ((Element)v.get(458)).setAttribute("width","8" );
      ((Element)v.get(458)).setAttribute("height","8" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:457   */
      /* Termina nodo:452   */

      /* Empieza nodo:459 / Elemento padre: 451   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(451)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("td"));
      ((Element)v.get(459)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(461)).setAttribute("src","b.gif" );
      ((Element)v.get(461)).setAttribute("width","8" );
      ((Element)v.get(461)).setAttribute("height","8" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:460   */

      /* Empieza nodo:462 / Elemento padre: 459   */
      v.add(doc.createElement("td"));
      ((Element)v.get(462)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(459)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(463)).setAttribute("nombre","cbSubgerenciaVentas" );
      ((Element)v.get(463)).setAttribute("id","datosCampos" );
      ((Element)v.get(463)).setAttribute("size","5" );
      ((Element)v.get(463)).setAttribute("multiple","S" );
      ((Element)v.get(463)).setAttribute("req","S" );
      ((Element)v.get(463)).setAttribute("valorinicial","" );
      ((Element)v.get(463)).setAttribute("textoinicial","" );
      ((Element)v.get(463)).setAttribute("onchange","actualizarSeleccion('cbSubgerenciaVentas');" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(463)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:465 / Elemento padre: 459   */
      v.add(doc.createElement("td"));
      ((Element)v.get(465)).setAttribute("width","100%" );
      ((Element)v.get(459)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(466)).setAttribute("src","b.gif" );
      ((Element)v.get(466)).setAttribute("width","8" );
      ((Element)v.get(466)).setAttribute("height","8" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */
      /* Termina nodo:465   */
      /* Termina nodo:459   */

      /* Empieza nodo:467 / Elemento padre: 451   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(451)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("td"));
      ((Element)v.get(468)).setAttribute("colspan","4" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(469)).setAttribute("src","b.gif" );
      ((Element)v.get(469)).setAttribute("width","8" );
      ((Element)v.get(469)).setAttribute("height","8" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */
      /* Termina nodo:467   */
      /* Termina nodo:451   */
      /* Termina nodo:450   */
      /* Termina nodo:449   */

      /* Empieza nodo:470 / Elemento padre: 355   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(355)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("td"));
      ((Element)v.get(470)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("table"));
      ((Element)v.get(472)).setAttribute("width","688" );
      ((Element)v.get(472)).setAttribute("border","0" );
      ((Element)v.get(472)).setAttribute("align","left" );
      ((Element)v.get(472)).setAttribute("cellspacing","0" );
      ((Element)v.get(472)).setAttribute("cellpadding","0" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(472)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
      ((Element)v.get(473)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(475)).setAttribute("src","b.gif" );
      ((Element)v.get(475)).setAttribute("width","8" );
      ((Element)v.get(475)).setAttribute("height","8" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */
      /* Termina nodo:474   */

      /* Empieza nodo:476 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(473)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(477)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(477)).setAttribute("alto","13" );
      ((Element)v.get(477)).setAttribute("filas","1" );
      ((Element)v.get(477)).setAttribute("valor","" );
      ((Element)v.get(477)).setAttribute("id","datosTitle" );
      ((Element)v.get(477)).setAttribute("cod","109" );
      ((Element)v.get(476)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */
      /* Termina nodo:476   */

      /* Empieza nodo:478 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
      ((Element)v.get(473)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(479)).setAttribute("src","b.gif" );
      ((Element)v.get(479)).setAttribute("width","25" );
      ((Element)v.get(479)).setAttribute("height","8" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */
      /* Termina nodo:478   */

      /* Empieza nodo:480 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
      ((Element)v.get(473)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(481)).setAttribute("nombre","lblZona" );
      ((Element)v.get(481)).setAttribute("alto","13" );
      ((Element)v.get(481)).setAttribute("filas","1" );
      ((Element)v.get(481)).setAttribute("valor","" );
      ((Element)v.get(481)).setAttribute("id","datosTitle" );
      ((Element)v.get(481)).setAttribute("cod","143" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */
      /* Termina nodo:480   */

      /* Empieza nodo:482 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
      ((Element)v.get(482)).setAttribute("width","100%" );
      ((Element)v.get(473)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(483)).setAttribute("src","b.gif" );
      ((Element)v.get(483)).setAttribute("width","8" );
      ((Element)v.get(483)).setAttribute("height","8" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */
      /* Termina nodo:482   */
      /* Termina nodo:473   */

      /* Empieza nodo:484 / Elemento padre: 472   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(472)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("td"));
      ((Element)v.get(484)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(486)).setAttribute("src","b.gif" );
      ((Element)v.get(486)).setAttribute("width","8" );
      ((Element)v.get(486)).setAttribute("height","8" );
      ((Element)v.get(485)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */
      /* Termina nodo:485   */

      /* Empieza nodo:487 / Elemento padre: 484   */
      v.add(doc.createElement("td"));
      ((Element)v.get(487)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(484)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(488)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(488)).setAttribute("id","datosCampos" );
      ((Element)v.get(488)).setAttribute("size","5" );
      ((Element)v.get(488)).setAttribute("multiple","S" );
      ((Element)v.get(488)).setAttribute("req","S" );
      ((Element)v.get(488)).setAttribute("valorinicial","" );
      ((Element)v.get(488)).setAttribute("textoinicial","" );
      ((Element)v.get(488)).setAttribute("onchange","actualizarSeleccion('cbRegion');" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(488)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:488   */
      /* Termina nodo:487   */

      /* Empieza nodo:490 / Elemento padre: 484   */
      v.add(doc.createElement("td"));
      ((Element)v.get(484)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(491)).setAttribute("src","b.gif" );
      ((Element)v.get(491)).setAttribute("width","25" );
      ((Element)v.get(491)).setAttribute("height","8" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */

      /* Empieza nodo:492 / Elemento padre: 484   */
      v.add(doc.createElement("td"));
      ((Element)v.get(492)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(484)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(493)).setAttribute("nombre","cbZona" );
      ((Element)v.get(493)).setAttribute("id","datosCampos" );
      ((Element)v.get(493)).setAttribute("size","5" );
      ((Element)v.get(493)).setAttribute("multiple","S" );
      ((Element)v.get(493)).setAttribute("req","S" );
      ((Element)v.get(493)).setAttribute("valorinicial","" );
      ((Element)v.get(493)).setAttribute("textoinicial","" );
      ((Element)v.get(493)).setAttribute("onchange","actualizarSeleccion('cbZona');" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:493   */
      /* Termina nodo:492   */

      /* Empieza nodo:495 / Elemento padre: 484   */
      v.add(doc.createElement("td"));
      ((Element)v.get(495)).setAttribute("width","100%" );
      ((Element)v.get(484)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(496)).setAttribute("src","b.gif" );
      ((Element)v.get(496)).setAttribute("width","8" );
      ((Element)v.get(496)).setAttribute("height","8" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */
      /* Termina nodo:495   */
      /* Termina nodo:484   */

      /* Empieza nodo:497 / Elemento padre: 472   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(472)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
   }

   private void getXML2070(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(498)).setAttribute("colspan","4" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(499)).setAttribute("src","b.gif" );
      ((Element)v.get(499)).setAttribute("width","8" );
      ((Element)v.get(499)).setAttribute("height","8" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */
      /* Termina nodo:498   */
      /* Termina nodo:497   */
      /* Termina nodo:472   */
      /* Termina nodo:471   */
      /* Termina nodo:470   */

      /* Empieza nodo:500 / Elemento padre: 355   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(355)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("td"));
      ((Element)v.get(500)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("table"));
      ((Element)v.get(502)).setAttribute("width","688" );
      ((Element)v.get(502)).setAttribute("border","0" );
      ((Element)v.get(502)).setAttribute("align","left" );
      ((Element)v.get(502)).setAttribute("cellspacing","0" );
      ((Element)v.get(502)).setAttribute("cellpadding","0" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(502)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(503)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(505)).setAttribute("src","b.gif" );
      ((Element)v.get(505)).setAttribute("width","8" );
      ((Element)v.get(505)).setAttribute("height","8" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */

      /* Empieza nodo:506 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(503)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(507)).setAttribute("nombre","lblSeccion" );
      ((Element)v.get(507)).setAttribute("alto","13" );
      ((Element)v.get(507)).setAttribute("filas","1" );
      ((Element)v.get(507)).setAttribute("valor","" );
      ((Element)v.get(507)).setAttribute("id","datosTitle" );
      ((Element)v.get(507)).setAttribute("cod","112" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */
      /* Termina nodo:506   */

      /* Empieza nodo:508 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(503)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(509)).setAttribute("src","b.gif" );
      ((Element)v.get(509)).setAttribute("width","25" );
      ((Element)v.get(509)).setAttribute("height","8" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:510 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(503)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(511)).setAttribute("nombre","lblTerritorio" );
      ((Element)v.get(511)).setAttribute("alto","13" );
      ((Element)v.get(511)).setAttribute("filas","1" );
      ((Element)v.get(511)).setAttribute("valor","" );
      ((Element)v.get(511)).setAttribute("id","datosTitle" );
      ((Element)v.get(511)).setAttribute("cod","126" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */
      /* Termina nodo:510   */

      /* Empieza nodo:512 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(512)).setAttribute("width","100%" );
      ((Element)v.get(503)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(513)).setAttribute("src","b.gif" );
      ((Element)v.get(513)).setAttribute("width","8" );
      ((Element)v.get(513)).setAttribute("height","8" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */
      /* Termina nodo:512   */
      /* Termina nodo:503   */

      /* Empieza nodo:514 / Elemento padre: 502   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(502)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("td"));
      ((Element)v.get(514)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(516)).setAttribute("src","b.gif" );
      ((Element)v.get(516)).setAttribute("width","8" );
      ((Element)v.get(516)).setAttribute("height","8" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */
      /* Termina nodo:515   */

      /* Empieza nodo:517 / Elemento padre: 514   */
      v.add(doc.createElement("td"));
      ((Element)v.get(517)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(514)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(518)).setAttribute("nombre","cbSeccion" );
      ((Element)v.get(518)).setAttribute("id","datosCampos" );
      ((Element)v.get(518)).setAttribute("size","5" );
      ((Element)v.get(518)).setAttribute("multiple","S" );
      ((Element)v.get(518)).setAttribute("req","S" );
      ((Element)v.get(518)).setAttribute("valorinicial","" );
      ((Element)v.get(518)).setAttribute("textoinicial","" );
      ((Element)v.get(518)).setAttribute("onchange","actualizarSeleccion('cbSeccion');" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */
      /* Termina nodo:517   */

      /* Empieza nodo:520 / Elemento padre: 514   */
      v.add(doc.createElement("td"));
      ((Element)v.get(514)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(521)).setAttribute("src","b.gif" );
      ((Element)v.get(521)).setAttribute("width","25" );
      ((Element)v.get(521)).setAttribute("height","8" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 514   */
      v.add(doc.createElement("td"));
      ((Element)v.get(522)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(514)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(523)).setAttribute("nombre","cbTerritorio" );
      ((Element)v.get(523)).setAttribute("id","datosCampos" );
      ((Element)v.get(523)).setAttribute("size","5" );
      ((Element)v.get(523)).setAttribute("multiple","S" );
      ((Element)v.get(523)).setAttribute("req","S" );
      ((Element)v.get(523)).setAttribute("valorinicial","" );
      ((Element)v.get(523)).setAttribute("textoinicial","" );
      ((Element)v.get(523)).setAttribute("onchange","actualizarSeleccion('cbTerritorio');" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(523)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */
      /* Termina nodo:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:525 / Elemento padre: 514   */
      v.add(doc.createElement("td"));
      ((Element)v.get(525)).setAttribute("width","100%" );
      ((Element)v.get(514)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(526)).setAttribute("src","b.gif" );
      ((Element)v.get(526)).setAttribute("width","8" );
      ((Element)v.get(526)).setAttribute("height","8" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */
      /* Termina nodo:525   */
      /* Termina nodo:514   */

      /* Empieza nodo:527 / Elemento padre: 502   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(502)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("td"));
      ((Element)v.get(528)).setAttribute("colspan","4" );
      ((Element)v.get(527)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(529)).setAttribute("src","b.gif" );
      ((Element)v.get(529)).setAttribute("width","8" );
      ((Element)v.get(529)).setAttribute("height","8" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */
      /* Termina nodo:527   */
      /* Termina nodo:502   */
      /* Termina nodo:501   */
      /* Termina nodo:500   */
      /* Termina nodo:355   */
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:530 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(531)).setAttribute("src","b.gif" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */
      /* Termina nodo:530   */
      /* Termina nodo:348   */

      /* Empieza nodo:532 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("td"));
      ((Element)v.get(533)).setAttribute("colspan","4" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(534)).setAttribute("src","b.gif" );
      ((Element)v.get(534)).setAttribute("width","8" );
      ((Element)v.get(534)).setAttribute("height","15" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:533   */
      /* Termina nodo:532   */

      /* Empieza nodo:535 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("td"));
      ((Element)v.get(535)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(537)).setAttribute("src","b.gif" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */
      /* Termina nodo:536   */

      /* Empieza nodo:538 / Elemento padre: 535   */
      v.add(doc.createElement("td"));
      ((Element)v.get(535)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(538)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(540)).setAttribute("class","legend" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(541)).setAttribute("nombre","lblDatosDefecto" );
      ((Element)v.get(541)).setAttribute("alto","13" );
      ((Element)v.get(541)).setAttribute("filas","1" );
      ((Element)v.get(541)).setAttribute("valor","" );
      ((Element)v.get(541)).setAttribute("id","legend" );
      ((Element)v.get(541)).setAttribute("cod","00510" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */
      /* Termina nodo:540   */

      /* Empieza nodo:542 / Elemento padre: 539   */
      v.add(doc.createElement("table"));
      ((Element)v.get(542)).setAttribute("width","100%" );
      ((Element)v.get(542)).setAttribute("border","0" );
      ((Element)v.get(542)).setAttribute("align","center" );
      ((Element)v.get(542)).setAttribute("cellspacing","0" );
      ((Element)v.get(542)).setAttribute("cellpadding","0" );
      ((Element)v.get(539)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(542)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("td"));
      ((Element)v.get(543)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("table"));
      ((Element)v.get(545)).setAttribute("width","688" );
      ((Element)v.get(545)).setAttribute("border","0" );
      ((Element)v.get(545)).setAttribute("align","left" );
      ((Element)v.get(545)).setAttribute("cellspacing","0" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(545)).setAttribute("cellpadding","0" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(545)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("td"));
      ((Element)v.get(547)).setAttribute("colspan","4" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(548)).setAttribute("src","b.gif" );
      ((Element)v.get(548)).setAttribute("width","8" );
      ((Element)v.get(548)).setAttribute("height","8" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */
      /* Termina nodo:547   */
      /* Termina nodo:546   */

      /* Empieza nodo:549 / Elemento padre: 545   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(545)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("td"));
      ((Element)v.get(549)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(551)).setAttribute("src","b.gif" );
      ((Element)v.get(551)).setAttribute("width","8" );
      ((Element)v.get(551)).setAttribute("height","8" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));
      /* Termina nodo:551   */
      /* Termina nodo:550   */

      /* Empieza nodo:552 / Elemento padre: 549   */
      v.add(doc.createElement("td"));
      ((Element)v.get(549)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(553)).setAttribute("nombre","lblPaisPorDefecto" );
      ((Element)v.get(553)).setAttribute("alto","13" );
      ((Element)v.get(553)).setAttribute("filas","1" );
      ((Element)v.get(553)).setAttribute("valor","" );
      ((Element)v.get(553)).setAttribute("id","datosTitle" );
      ((Element)v.get(553)).setAttribute("cod","101" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));
      /* Termina nodo:553   */
      /* Termina nodo:552   */

      /* Empieza nodo:554 / Elemento padre: 549   */
      v.add(doc.createElement("td"));
      ((Element)v.get(549)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(555)).setAttribute("src","b.gif" );
      ((Element)v.get(555)).setAttribute("width","25" );
      ((Element)v.get(555)).setAttribute("height","8" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));
      /* Termina nodo:555   */
      /* Termina nodo:554   */

      /* Empieza nodo:556 / Elemento padre: 549   */
      v.add(doc.createElement("td"));
      ((Element)v.get(549)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(557)).setAttribute("nombre","lblSGVPorDefecto" );
      ((Element)v.get(557)).setAttribute("alto","13" );
      ((Element)v.get(557)).setAttribute("filas","1" );
      ((Element)v.get(557)).setAttribute("valor","" );
      ((Element)v.get(557)).setAttribute("id","datosTitle" );
      ((Element)v.get(557)).setAttribute("cod","166" );
      ((Element)v.get(556)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */
      /* Termina nodo:556   */

      /* Empieza nodo:558 / Elemento padre: 549   */
      v.add(doc.createElement("td"));
      ((Element)v.get(558)).setAttribute("width","100%" );
      ((Element)v.get(549)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(559)).setAttribute("src","b.gif" );
      ((Element)v.get(559)).setAttribute("width","8" );
      ((Element)v.get(559)).setAttribute("height","8" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:558   */
      /* Termina nodo:549   */

      /* Empieza nodo:560 / Elemento padre: 545   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(545)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(562)).setAttribute("src","b.gif" );
      ((Element)v.get(562)).setAttribute("width","8" );
      ((Element)v.get(562)).setAttribute("height","8" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */
      /* Termina nodo:561   */

      /* Empieza nodo:563 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(563)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(560)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(564)).setAttribute("nombre","cbPaisPorDefecto" );
      ((Element)v.get(564)).setAttribute("id","datosCampos" );
      ((Element)v.get(564)).setAttribute("size","1" );
      ((Element)v.get(564)).setAttribute("multiple","N" );
      ((Element)v.get(564)).setAttribute("req","S" );
      ((Element)v.get(564)).setAttribute("valorinicial","" );
      ((Element)v.get(564)).setAttribute("textoinicial","" );
      ((Element)v.get(564)).setAttribute("onchange","actualizarSeleccion('cbPaisPorDefecto');" );
      ((Element)v.get(563)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(564)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */
      /* Termina nodo:564   */
      /* Termina nodo:563   */

      /* Empieza nodo:566 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(567)).setAttribute("src","b.gif" );
      ((Element)v.get(567)).setAttribute("width","25" );
      ((Element)v.get(567)).setAttribute("height","8" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:566   */

      /* Empieza nodo:568 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(568)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(560)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
   }

   private void getXML2340(Document doc) {
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(569)).setAttribute("nombre","cbSGVPorDefecto" );
      ((Element)v.get(569)).setAttribute("id","datosCampos" );
      ((Element)v.get(569)).setAttribute("size","1" );
      ((Element)v.get(569)).setAttribute("multiple","N" );
      ((Element)v.get(569)).setAttribute("req","S" );
      ((Element)v.get(569)).setAttribute("valorinicial","" );
      ((Element)v.get(569)).setAttribute("textoinicial","" );
      ((Element)v.get(569)).setAttribute("onchange","actualizarSeleccion('cbSGVPorDefecto');" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(569)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */
      /* Termina nodo:569   */
      /* Termina nodo:568   */

      /* Empieza nodo:571 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(571)).setAttribute("width","100%" );
      ((Element)v.get(560)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(572)).setAttribute("src","b.gif" );
      ((Element)v.get(572)).setAttribute("width","8" );
      ((Element)v.get(572)).setAttribute("height","8" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));
      /* Termina nodo:572   */
      /* Termina nodo:571   */
      /* Termina nodo:560   */

      /* Empieza nodo:573 / Elemento padre: 545   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(545)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("td"));
      ((Element)v.get(574)).setAttribute("colspan","4" );
      ((Element)v.get(573)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(575)).setAttribute("src","b.gif" );
      ((Element)v.get(575)).setAttribute("width","8" );
      ((Element)v.get(575)).setAttribute("height","8" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));
      /* Termina nodo:575   */
      /* Termina nodo:574   */
      /* Termina nodo:573   */
      /* Termina nodo:545   */
      /* Termina nodo:544   */
      /* Termina nodo:543   */

      /* Empieza nodo:576 / Elemento padre: 542   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(542)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("td"));
      ((Element)v.get(576)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("table"));
      ((Element)v.get(578)).setAttribute("width","688" );
      ((Element)v.get(578)).setAttribute("border","0" );
      ((Element)v.get(578)).setAttribute("align","left" );
      ((Element)v.get(578)).setAttribute("cellspacing","0" );
      ((Element)v.get(578)).setAttribute("cellpadding","0" );
      ((Element)v.get(577)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(578)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("td"));
      ((Element)v.get(580)).setAttribute("colspan","4" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(581)).setAttribute("src","b.gif" );
      ((Element)v.get(581)).setAttribute("width","8" );
      ((Element)v.get(581)).setAttribute("height","8" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */
      /* Termina nodo:580   */
      /* Termina nodo:579   */

      /* Empieza nodo:582 / Elemento padre: 578   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(578)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(582)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(584)).setAttribute("src","b.gif" );
      ((Element)v.get(584)).setAttribute("width","8" );
      ((Element)v.get(584)).setAttribute("height","8" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */
      /* Termina nodo:583   */

      /* Empieza nodo:585 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(582)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(586)).setAttribute("nombre","lblRegionPorDefecto" );
      ((Element)v.get(586)).setAttribute("alto","13" );
      ((Element)v.get(586)).setAttribute("filas","1" );
      ((Element)v.get(586)).setAttribute("valor","" );
      ((Element)v.get(586)).setAttribute("id","datosTitle" );
      ((Element)v.get(586)).setAttribute("cod","110" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */
      /* Termina nodo:585   */

      /* Empieza nodo:587 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(582)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(588)).setAttribute("src","b.gif" );
      ((Element)v.get(588)).setAttribute("width","25" );
      ((Element)v.get(588)).setAttribute("height","8" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));
      /* Termina nodo:588   */
      /* Termina nodo:587   */

      /* Empieza nodo:589 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(582)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(590)).setAttribute("nombre","lblZonaPorDefecto" );
      ((Element)v.get(590)).setAttribute("alto","13" );
      ((Element)v.get(590)).setAttribute("filas","1" );
      ((Element)v.get(590)).setAttribute("valor","" );
      ((Element)v.get(590)).setAttribute("id","datosTitle" );
      ((Element)v.get(590)).setAttribute("cod","144" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));
      /* Termina nodo:590   */
      /* Termina nodo:589   */

      /* Empieza nodo:591 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(591)).setAttribute("width","100%" );
      ((Element)v.get(582)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
   }

   private void getXML2430(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(592)).setAttribute("src","b.gif" );
      ((Element)v.get(592)).setAttribute("width","8" );
      ((Element)v.get(592)).setAttribute("height","8" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */
      /* Termina nodo:591   */
      /* Termina nodo:582   */

      /* Empieza nodo:593 / Elemento padre: 578   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(578)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("td"));
      ((Element)v.get(593)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(595)).setAttribute("src","b.gif" );
      ((Element)v.get(595)).setAttribute("width","8" );
      ((Element)v.get(595)).setAttribute("height","8" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));
      /* Termina nodo:595   */
      /* Termina nodo:594   */

      /* Empieza nodo:596 / Elemento padre: 593   */
      v.add(doc.createElement("td"));
      ((Element)v.get(596)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(593)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(597)).setAttribute("nombre","cbRegionPorDefecto" );
      ((Element)v.get(597)).setAttribute("id","datosCampos" );
      ((Element)v.get(597)).setAttribute("size","1" );
      ((Element)v.get(597)).setAttribute("multiple","N" );
      ((Element)v.get(597)).setAttribute("req","S" );
      ((Element)v.get(597)).setAttribute("valorinicial","" );
      ((Element)v.get(597)).setAttribute("textoinicial","" );
      ((Element)v.get(597)).setAttribute("onchange","actualizarSeleccion('cbRegionPorDefecto');" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(597)).appendChild((Element)v.get(598));
      /* Termina nodo:598   */
      /* Termina nodo:597   */
      /* Termina nodo:596   */

      /* Empieza nodo:599 / Elemento padre: 593   */
      v.add(doc.createElement("td"));
      ((Element)v.get(593)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(600)).setAttribute("src","b.gif" );
      ((Element)v.get(600)).setAttribute("width","25" );
      ((Element)v.get(600)).setAttribute("height","8" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));
      /* Termina nodo:600   */
      /* Termina nodo:599   */

      /* Empieza nodo:601 / Elemento padre: 593   */
      v.add(doc.createElement("td"));
      ((Element)v.get(601)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(593)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(602)).setAttribute("nombre","cbZonaPorDefecto" );
      ((Element)v.get(602)).setAttribute("id","datosCampos" );
      ((Element)v.get(602)).setAttribute("size","1" );
      ((Element)v.get(602)).setAttribute("multiple","N" );
      ((Element)v.get(602)).setAttribute("req","S" );
      ((Element)v.get(602)).setAttribute("valorinicial","" );
      ((Element)v.get(602)).setAttribute("textoinicial","" );
      ((Element)v.get(602)).setAttribute("onchange","actualizarSeleccion('cbZonaPorDefecto');" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(602)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */
      /* Termina nodo:602   */
      /* Termina nodo:601   */

      /* Empieza nodo:604 / Elemento padre: 593   */
      v.add(doc.createElement("td"));
      ((Element)v.get(604)).setAttribute("width","100%" );
      ((Element)v.get(593)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(605)).setAttribute("src","b.gif" );
      ((Element)v.get(605)).setAttribute("width","8" );
      ((Element)v.get(605)).setAttribute("height","8" );
      ((Element)v.get(604)).appendChild((Element)v.get(605));
      /* Termina nodo:605   */
      /* Termina nodo:604   */
      /* Termina nodo:593   */

      /* Empieza nodo:606 / Elemento padre: 578   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(578)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("td"));
      ((Element)v.get(607)).setAttribute("colspan","4" );
      ((Element)v.get(606)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(608)).setAttribute("src","b.gif" );
      ((Element)v.get(608)).setAttribute("width","8" );
      ((Element)v.get(608)).setAttribute("height","8" );
      ((Element)v.get(607)).appendChild((Element)v.get(608));
      /* Termina nodo:608   */
      /* Termina nodo:607   */
      /* Termina nodo:606   */
      /* Termina nodo:578   */
      /* Termina nodo:577   */
      /* Termina nodo:576   */

      /* Empieza nodo:609 / Elemento padre: 542   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(542)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("td"));
      ((Element)v.get(609)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
      v.add(doc.createElement("table"));
      ((Element)v.get(611)).setAttribute("width","688" );
      ((Element)v.get(611)).setAttribute("border","0" );
      ((Element)v.get(611)).setAttribute("align","left" );
      ((Element)v.get(611)).setAttribute("cellspacing","0" );
      ((Element)v.get(611)).setAttribute("cellpadding","0" );
      ((Element)v.get(610)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(611)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("td"));
      ((Element)v.get(612)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(614)).setAttribute("src","b.gif" );
      ((Element)v.get(614)).setAttribute("width","8" );
      ((Element)v.get(614)).setAttribute("height","8" );
      ((Element)v.get(613)).appendChild((Element)v.get(614));
      /* Termina nodo:614   */
      /* Termina nodo:613   */

      /* Empieza nodo:615 / Elemento padre: 612   */
      v.add(doc.createElement("td"));
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(612)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(616)).setAttribute("nombre","lblSeccionPorDefecto" );
      ((Element)v.get(616)).setAttribute("alto","13" );
      ((Element)v.get(616)).setAttribute("filas","1" );
      ((Element)v.get(616)).setAttribute("valor","" );
      ((Element)v.get(616)).setAttribute("id","datosTitle" );
      ((Element)v.get(616)).setAttribute("cod","113" );
      ((Element)v.get(615)).appendChild((Element)v.get(616));
      /* Termina nodo:616   */
      /* Termina nodo:615   */

      /* Empieza nodo:617 / Elemento padre: 612   */
      v.add(doc.createElement("td"));
      ((Element)v.get(612)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(618)).setAttribute("src","b.gif" );
      ((Element)v.get(618)).setAttribute("width","25" );
      ((Element)v.get(618)).setAttribute("height","8" );
      ((Element)v.get(617)).appendChild((Element)v.get(618));
      /* Termina nodo:618   */
      /* Termina nodo:617   */

      /* Empieza nodo:619 / Elemento padre: 612   */
      v.add(doc.createElement("td"));
      ((Element)v.get(612)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(620)).setAttribute("nombre","lblTerritorioPorDefecto" );
      ((Element)v.get(620)).setAttribute("alto","13" );
      ((Element)v.get(620)).setAttribute("filas","1" );
      ((Element)v.get(620)).setAttribute("valor","" );
      ((Element)v.get(620)).setAttribute("id","datosTitle" );
      ((Element)v.get(620)).setAttribute("cod","127" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));
      /* Termina nodo:620   */
      /* Termina nodo:619   */

      /* Empieza nodo:621 / Elemento padre: 612   */
      v.add(doc.createElement("td"));
      ((Element)v.get(621)).setAttribute("width","100%" );
      ((Element)v.get(612)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(622)).setAttribute("src","b.gif" );
      ((Element)v.get(622)).setAttribute("width","8" );
      ((Element)v.get(622)).setAttribute("height","8" );
      ((Element)v.get(621)).appendChild((Element)v.get(622));
      /* Termina nodo:622   */
      /* Termina nodo:621   */
      /* Termina nodo:612   */

      /* Empieza nodo:623 / Elemento padre: 611   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(611)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(623)).appendChild((Element)v.get(624));

      /* Empieza nodo:625 / Elemento padre: 624   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(625)).setAttribute("src","b.gif" );
      ((Element)v.get(625)).setAttribute("width","8" );
      ((Element)v.get(625)).setAttribute("height","8" );
      ((Element)v.get(624)).appendChild((Element)v.get(625));
      /* Termina nodo:625   */
      /* Termina nodo:624   */

      /* Empieza nodo:626 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(626)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(623)).appendChild((Element)v.get(626));

      /* Empieza nodo:627 / Elemento padre: 626   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(627)).setAttribute("nombre","cbSeccionPorDefecto" );
      ((Element)v.get(627)).setAttribute("id","datosCampos" );
      ((Element)v.get(627)).setAttribute("size","1" );
      ((Element)v.get(627)).setAttribute("multiple","N" );
      ((Element)v.get(627)).setAttribute("req","S" );
      ((Element)v.get(627)).setAttribute("valorinicial","" );
      ((Element)v.get(627)).setAttribute("textoinicial","" );
      ((Element)v.get(627)).setAttribute("onchange","actualizarSeleccion('cbSeccionPorDefecto');" );
      ((Element)v.get(626)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(627)).appendChild((Element)v.get(628));
      /* Termina nodo:628   */
      /* Termina nodo:627   */
      /* Termina nodo:626   */

      /* Empieza nodo:629 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(623)).appendChild((Element)v.get(629));

      /* Empieza nodo:630 / Elemento padre: 629   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(630)).setAttribute("src","b.gif" );
      ((Element)v.get(630)).setAttribute("width","25" );
      ((Element)v.get(630)).setAttribute("height","8" );
      ((Element)v.get(629)).appendChild((Element)v.get(630));
      /* Termina nodo:630   */
      /* Termina nodo:629   */

      /* Empieza nodo:631 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(631)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(623)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(632)).setAttribute("nombre","cbTerritorioPorDefecto" );
      ((Element)v.get(632)).setAttribute("id","datosCampos" );
      ((Element)v.get(632)).setAttribute("size","1" );
      ((Element)v.get(632)).setAttribute("multiple","N" );
      ((Element)v.get(632)).setAttribute("req","S" );
      ((Element)v.get(632)).setAttribute("valorinicial","" );
      ((Element)v.get(632)).setAttribute("textoinicial","" );
      ((Element)v.get(632)).setAttribute("onchange","actualizarSeleccion('cbTerritorioPorDefecto');" );
      ((Element)v.get(631)).appendChild((Element)v.get(632));

      /* Empieza nodo:633 / Elemento padre: 632   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(632)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */
      /* Termina nodo:632   */
      /* Termina nodo:631   */

      /* Empieza nodo:634 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(634)).setAttribute("width","100%" );
      ((Element)v.get(623)).appendChild((Element)v.get(634));

      /* Empieza nodo:635 / Elemento padre: 634   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(635)).setAttribute("src","b.gif" );
      ((Element)v.get(635)).setAttribute("width","8" );
      ((Element)v.get(635)).setAttribute("height","8" );
      ((Element)v.get(634)).appendChild((Element)v.get(635));
      /* Termina nodo:635   */
      /* Termina nodo:634   */
      /* Termina nodo:623   */

      /* Empieza nodo:636 / Elemento padre: 611   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(611)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
   }

   private void getXML2610(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(637)).setAttribute("colspan","4" );
      ((Element)v.get(636)).appendChild((Element)v.get(637));

      /* Empieza nodo:638 / Elemento padre: 637   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(638)).setAttribute("src","b.gif" );
      ((Element)v.get(638)).setAttribute("width","8" );
      ((Element)v.get(638)).setAttribute("height","8" );
      ((Element)v.get(637)).appendChild((Element)v.get(638));
      /* Termina nodo:638   */
      /* Termina nodo:637   */
      /* Termina nodo:636   */
      /* Termina nodo:611   */
      /* Termina nodo:610   */
      /* Termina nodo:609   */

      /* Empieza nodo:639 / Elemento padre: 542   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(542)).appendChild((Element)v.get(639));

      /* Empieza nodo:640 / Elemento padre: 639   */
      v.add(doc.createElement("td"));
      ((Element)v.get(639)).appendChild((Element)v.get(640));

      /* Empieza nodo:641 / Elemento padre: 640   */
      v.add(doc.createElement("table"));
      ((Element)v.get(641)).setAttribute("width","688" );
      ((Element)v.get(641)).setAttribute("border","0" );
      ((Element)v.get(641)).setAttribute("align","left" );
      ((Element)v.get(641)).setAttribute("cellspacing","0" );
      ((Element)v.get(641)).setAttribute("cellpadding","0" );
      ((Element)v.get(640)).appendChild((Element)v.get(641));

      /* Empieza nodo:642 / Elemento padre: 641   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(641)).appendChild((Element)v.get(642));

      /* Empieza nodo:643 / Elemento padre: 642   */
      v.add(doc.createElement("td"));
      ((Element)v.get(642)).appendChild((Element)v.get(643));

      /* Empieza nodo:644 / Elemento padre: 643   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(644)).setAttribute("src","b.gif" );
      ((Element)v.get(644)).setAttribute("width","8" );
      ((Element)v.get(644)).setAttribute("height","8" );
      ((Element)v.get(643)).appendChild((Element)v.get(644));
      /* Termina nodo:644   */
      /* Termina nodo:643   */

      /* Empieza nodo:645 / Elemento padre: 642   */
      v.add(doc.createElement("td"));
      ((Element)v.get(642)).appendChild((Element)v.get(645));

      /* Empieza nodo:646 / Elemento padre: 645   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(646)).setAttribute("nombre","lblSociedadPorDefecto" );
      ((Element)v.get(646)).setAttribute("alto","13" );
      ((Element)v.get(646)).setAttribute("filas","1" );
      ((Element)v.get(646)).setAttribute("valor","" );
      ((Element)v.get(646)).setAttribute("id","datosTitle" );
      ((Element)v.get(646)).setAttribute("cod","121" );
      ((Element)v.get(645)).appendChild((Element)v.get(646));
      /* Termina nodo:646   */
      /* Termina nodo:645   */

      /* Empieza nodo:647 / Elemento padre: 642   */
      v.add(doc.createElement("td"));
      ((Element)v.get(647)).setAttribute("width","100%" );
      ((Element)v.get(642)).appendChild((Element)v.get(647));

      /* Empieza nodo:648 / Elemento padre: 647   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(648)).setAttribute("src","b.gif" );
      ((Element)v.get(648)).setAttribute("width","8" );
      ((Element)v.get(648)).setAttribute("height","8" );
      ((Element)v.get(647)).appendChild((Element)v.get(648));
      /* Termina nodo:648   */
      /* Termina nodo:647   */
      /* Termina nodo:642   */

      /* Empieza nodo:649 / Elemento padre: 641   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(641)).appendChild((Element)v.get(649));

      /* Empieza nodo:650 / Elemento padre: 649   */
      v.add(doc.createElement("td"));
      ((Element)v.get(649)).appendChild((Element)v.get(650));

      /* Empieza nodo:651 / Elemento padre: 650   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(651)).setAttribute("src","b.gif" );
      ((Element)v.get(651)).setAttribute("width","8" );
      ((Element)v.get(651)).setAttribute("height","8" );
      ((Element)v.get(650)).appendChild((Element)v.get(651));
      /* Termina nodo:651   */
      /* Termina nodo:650   */

      /* Empieza nodo:652 / Elemento padre: 649   */
      v.add(doc.createElement("td"));
      ((Element)v.get(652)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(649)).appendChild((Element)v.get(652));

      /* Empieza nodo:653 / Elemento padre: 652   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(653)).setAttribute("nombre","cbSociedadPorDefecto" );
      ((Element)v.get(653)).setAttribute("id","datosCampos" );
      ((Element)v.get(653)).setAttribute("size","1" );
      ((Element)v.get(653)).setAttribute("multiple","N" );
      ((Element)v.get(653)).setAttribute("req","S" );
      ((Element)v.get(653)).setAttribute("valorinicial","" );
      ((Element)v.get(653)).setAttribute("textoinicial","" );
      ((Element)v.get(653)).setAttribute("onchange","actualizarSeleccion('cbSociedadPorDefecto');" );
      ((Element)v.get(652)).appendChild((Element)v.get(653));

      /* Empieza nodo:654 / Elemento padre: 653   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(653)).appendChild((Element)v.get(654));
      /* Termina nodo:654   */
      /* Termina nodo:653   */
      /* Termina nodo:652   */

      /* Empieza nodo:655 / Elemento padre: 649   */
      v.add(doc.createElement("td"));
      ((Element)v.get(655)).setAttribute("width","100%" );
      ((Element)v.get(649)).appendChild((Element)v.get(655));

      /* Empieza nodo:656 / Elemento padre: 655   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(656)).setAttribute("src","b.gif" );
      ((Element)v.get(656)).setAttribute("width","8" );
      ((Element)v.get(656)).setAttribute("height","8" );
      ((Element)v.get(655)).appendChild((Element)v.get(656));
      /* Termina nodo:656   */
      /* Termina nodo:655   */
      /* Termina nodo:649   */

      /* Empieza nodo:657 / Elemento padre: 641   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(641)).appendChild((Element)v.get(657));

      /* Empieza nodo:658 / Elemento padre: 657   */
      v.add(doc.createElement("td"));
      ((Element)v.get(658)).setAttribute("colspan","4" );
      ((Element)v.get(657)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(659)).setAttribute("src","b.gif" );
      ((Element)v.get(659)).setAttribute("width","8" );
      ((Element)v.get(659)).setAttribute("height","8" );
      ((Element)v.get(658)).appendChild((Element)v.get(659));
      /* Termina nodo:659   */
      /* Termina nodo:658   */
      /* Termina nodo:657   */
      /* Termina nodo:641   */
      /* Termina nodo:640   */
      /* Termina nodo:639   */

      /* Empieza nodo:660 / Elemento padre: 542   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(542)).appendChild((Element)v.get(660));

      /* Empieza nodo:661 / Elemento padre: 660   */
   }

   private void getXML2700(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(660)).appendChild((Element)v.get(661));

      /* Empieza nodo:662 / Elemento padre: 661   */
      v.add(doc.createElement("table"));
      ((Element)v.get(662)).setAttribute("width","688" );
      ((Element)v.get(662)).setAttribute("border","0" );
      ((Element)v.get(662)).setAttribute("align","left" );
      ((Element)v.get(662)).setAttribute("cellspacing","0" );
      ((Element)v.get(662)).setAttribute("cellpadding","0" );
      ((Element)v.get(661)).appendChild((Element)v.get(662));

      /* Empieza nodo:663 / Elemento padre: 662   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(662)).appendChild((Element)v.get(663));

      /* Empieza nodo:664 / Elemento padre: 663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(663)).appendChild((Element)v.get(664));

      /* Empieza nodo:665 / Elemento padre: 664   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(665)).setAttribute("src","b.gif" );
      ((Element)v.get(665)).setAttribute("width","8" );
      ((Element)v.get(665)).setAttribute("height","8" );
      ((Element)v.get(664)).appendChild((Element)v.get(665));
      /* Termina nodo:665   */
      /* Termina nodo:664   */

      /* Empieza nodo:666 / Elemento padre: 663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(663)).appendChild((Element)v.get(666));

      /* Empieza nodo:667 / Elemento padre: 666   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(667)).setAttribute("nombre","lblMarcaPorDefecto" );
      ((Element)v.get(667)).setAttribute("alto","13" );
      ((Element)v.get(667)).setAttribute("filas","1" );
      ((Element)v.get(667)).setAttribute("valor","" );
      ((Element)v.get(667)).setAttribute("id","datosTitle" );
      ((Element)v.get(667)).setAttribute("cod","81" );
      ((Element)v.get(666)).appendChild((Element)v.get(667));
      /* Termina nodo:667   */
      /* Termina nodo:666   */

      /* Empieza nodo:668 / Elemento padre: 663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(663)).appendChild((Element)v.get(668));

      /* Empieza nodo:669 / Elemento padre: 668   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(669)).setAttribute("src","b.gif" );
      ((Element)v.get(669)).setAttribute("width","25" );
      ((Element)v.get(669)).setAttribute("height","8" );
      ((Element)v.get(668)).appendChild((Element)v.get(669));
      /* Termina nodo:669   */
      /* Termina nodo:668   */

      /* Empieza nodo:670 / Elemento padre: 663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(663)).appendChild((Element)v.get(670));

      /* Empieza nodo:671 / Elemento padre: 670   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(671)).setAttribute("nombre","lblCanalPorDefecto" );
      ((Element)v.get(671)).setAttribute("alto","13" );
      ((Element)v.get(671)).setAttribute("filas","1" );
      ((Element)v.get(671)).setAttribute("valor","" );
      ((Element)v.get(671)).setAttribute("id","datosTitle" );
      ((Element)v.get(671)).setAttribute("cod","19" );
      ((Element)v.get(670)).appendChild((Element)v.get(671));
      /* Termina nodo:671   */
      /* Termina nodo:670   */

      /* Empieza nodo:672 / Elemento padre: 663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(672)).setAttribute("width","100%" );
      ((Element)v.get(663)).appendChild((Element)v.get(672));

      /* Empieza nodo:673 / Elemento padre: 672   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(673)).setAttribute("src","b.gif" );
      ((Element)v.get(673)).setAttribute("width","8" );
      ((Element)v.get(673)).setAttribute("height","8" );
      ((Element)v.get(672)).appendChild((Element)v.get(673));
      /* Termina nodo:673   */
      /* Termina nodo:672   */
      /* Termina nodo:663   */

      /* Empieza nodo:674 / Elemento padre: 662   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(662)).appendChild((Element)v.get(674));

      /* Empieza nodo:675 / Elemento padre: 674   */
      v.add(doc.createElement("td"));
      ((Element)v.get(674)).appendChild((Element)v.get(675));

      /* Empieza nodo:676 / Elemento padre: 675   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(676)).setAttribute("src","b.gif" );
      ((Element)v.get(676)).setAttribute("width","8" );
      ((Element)v.get(676)).setAttribute("height","8" );
      ((Element)v.get(675)).appendChild((Element)v.get(676));
      /* Termina nodo:676   */
      /* Termina nodo:675   */

      /* Empieza nodo:677 / Elemento padre: 674   */
      v.add(doc.createElement("td"));
      ((Element)v.get(677)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(674)).appendChild((Element)v.get(677));

      /* Empieza nodo:678 / Elemento padre: 677   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(678)).setAttribute("nombre","cbMarcaPorDefecto" );
      ((Element)v.get(678)).setAttribute("id","datosCampos" );
      ((Element)v.get(678)).setAttribute("size","1" );
      ((Element)v.get(678)).setAttribute("multiple","N" );
      ((Element)v.get(678)).setAttribute("req","S" );
      ((Element)v.get(678)).setAttribute("valorinicial","" );
      ((Element)v.get(678)).setAttribute("textoinicial","" );
      ((Element)v.get(678)).setAttribute("onchange","actualizarSeleccion('cbMarcaPorDefecto');" );
      ((Element)v.get(677)).appendChild((Element)v.get(678));

      /* Empieza nodo:679 / Elemento padre: 678   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(678)).appendChild((Element)v.get(679));
      /* Termina nodo:679   */
      /* Termina nodo:678   */
      /* Termina nodo:677   */

      /* Empieza nodo:680 / Elemento padre: 674   */
      v.add(doc.createElement("td"));
      ((Element)v.get(674)).appendChild((Element)v.get(680));

      /* Empieza nodo:681 / Elemento padre: 680   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(681)).setAttribute("src","b.gif" );
      ((Element)v.get(681)).setAttribute("width","25" );
      ((Element)v.get(681)).setAttribute("height","8" );
      ((Element)v.get(680)).appendChild((Element)v.get(681));
      /* Termina nodo:681   */
      /* Termina nodo:680   */

      /* Empieza nodo:682 / Elemento padre: 674   */
      v.add(doc.createElement("td"));
      ((Element)v.get(682)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(674)).appendChild((Element)v.get(682));

      /* Empieza nodo:683 / Elemento padre: 682   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(683)).setAttribute("nombre","cbCanalPorDefecto" );
      ((Element)v.get(683)).setAttribute("id","datosCampos" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(683)).setAttribute("size","1" );
      ((Element)v.get(683)).setAttribute("multiple","N" );
      ((Element)v.get(683)).setAttribute("req","S" );
      ((Element)v.get(683)).setAttribute("valorinicial","" );
      ((Element)v.get(683)).setAttribute("textoinicial","" );
      ((Element)v.get(683)).setAttribute("onchange","actualizarSeleccion('cbCanalPorDefecto');" );
      ((Element)v.get(682)).appendChild((Element)v.get(683));

      /* Empieza nodo:684 / Elemento padre: 683   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(683)).appendChild((Element)v.get(684));
      /* Termina nodo:684   */
      /* Termina nodo:683   */
      /* Termina nodo:682   */

      /* Empieza nodo:685 / Elemento padre: 674   */
      v.add(doc.createElement("td"));
      ((Element)v.get(685)).setAttribute("width","100%" );
      ((Element)v.get(674)).appendChild((Element)v.get(685));

      /* Empieza nodo:686 / Elemento padre: 685   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(686)).setAttribute("src","b.gif" );
      ((Element)v.get(686)).setAttribute("width","8" );
      ((Element)v.get(686)).setAttribute("height","8" );
      ((Element)v.get(685)).appendChild((Element)v.get(686));
      /* Termina nodo:686   */
      /* Termina nodo:685   */
      /* Termina nodo:674   */

      /* Empieza nodo:687 / Elemento padre: 662   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(662)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("td"));
      ((Element)v.get(688)).setAttribute("colspan","4" );
      ((Element)v.get(687)).appendChild((Element)v.get(688));

      /* Empieza nodo:689 / Elemento padre: 688   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(689)).setAttribute("src","b.gif" );
      ((Element)v.get(689)).setAttribute("width","8" );
      ((Element)v.get(689)).setAttribute("height","8" );
      ((Element)v.get(688)).appendChild((Element)v.get(689));
      /* Termina nodo:689   */
      /* Termina nodo:688   */
      /* Termina nodo:687   */
      /* Termina nodo:662   */
      /* Termina nodo:661   */
      /* Termina nodo:660   */

      /* Empieza nodo:690 / Elemento padre: 542   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(542)).appendChild((Element)v.get(690));

      /* Empieza nodo:691 / Elemento padre: 690   */
      v.add(doc.createElement("td"));
      ((Element)v.get(690)).appendChild((Element)v.get(691));

      /* Empieza nodo:692 / Elemento padre: 691   */
      v.add(doc.createElement("table"));
      ((Element)v.get(692)).setAttribute("width","688" );
      ((Element)v.get(692)).setAttribute("border","0" );
      ((Element)v.get(692)).setAttribute("align","left" );
      ((Element)v.get(692)).setAttribute("cellspacing","0" );
      ((Element)v.get(692)).setAttribute("cellpadding","0" );
      ((Element)v.get(691)).appendChild((Element)v.get(692));

      /* Empieza nodo:693 / Elemento padre: 692   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(692)).appendChild((Element)v.get(693));

      /* Empieza nodo:694 / Elemento padre: 693   */
      v.add(doc.createElement("td"));
      ((Element)v.get(693)).appendChild((Element)v.get(694));

      /* Empieza nodo:695 / Elemento padre: 694   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(695)).setAttribute("src","b.gif" );
      ((Element)v.get(695)).setAttribute("width","8" );
      ((Element)v.get(695)).setAttribute("height","8" );
      ((Element)v.get(694)).appendChild((Element)v.get(695));
      /* Termina nodo:695   */
      /* Termina nodo:694   */

      /* Empieza nodo:696 / Elemento padre: 693   */
      v.add(doc.createElement("td"));
      ((Element)v.get(693)).appendChild((Element)v.get(696));

      /* Empieza nodo:697 / Elemento padre: 696   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(697)).setAttribute("nombre","lblAccesoPorDefecto" );
      ((Element)v.get(697)).setAttribute("alto","13" );
      ((Element)v.get(697)).setAttribute("filas","1" );
      ((Element)v.get(697)).setAttribute("valor","" );
      ((Element)v.get(697)).setAttribute("id","datosTitle" );
      ((Element)v.get(697)).setAttribute("cod","11" );
      ((Element)v.get(696)).appendChild((Element)v.get(697));
      /* Termina nodo:697   */
      /* Termina nodo:696   */

      /* Empieza nodo:698 / Elemento padre: 693   */
      v.add(doc.createElement("td"));
      ((Element)v.get(693)).appendChild((Element)v.get(698));

      /* Empieza nodo:699 / Elemento padre: 698   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(699)).setAttribute("src","b.gif" );
      ((Element)v.get(699)).setAttribute("width","25" );
      ((Element)v.get(699)).setAttribute("height","8" );
      ((Element)v.get(698)).appendChild((Element)v.get(699));
      /* Termina nodo:699   */
      /* Termina nodo:698   */

      /* Empieza nodo:700 / Elemento padre: 693   */
      v.add(doc.createElement("td"));
      ((Element)v.get(693)).appendChild((Element)v.get(700));

      /* Empieza nodo:701 / Elemento padre: 700   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(701)).setAttribute("nombre","lblSubaccesoPorDefecto" );
      ((Element)v.get(701)).setAttribute("alto","13" );
      ((Element)v.get(701)).setAttribute("filas","1" );
      ((Element)v.get(701)).setAttribute("valor","" );
      ((Element)v.get(701)).setAttribute("id","datosTitle" );
      ((Element)v.get(701)).setAttribute("cod","123" );
      ((Element)v.get(700)).appendChild((Element)v.get(701));
      /* Termina nodo:701   */
      /* Termina nodo:700   */

      /* Empieza nodo:702 / Elemento padre: 693   */
      v.add(doc.createElement("td"));
      ((Element)v.get(693)).appendChild((Element)v.get(702));

      /* Empieza nodo:703 / Elemento padre: 702   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(703)).setAttribute("src","b.gif" );
      ((Element)v.get(703)).setAttribute("width","25" );
      ((Element)v.get(703)).setAttribute("height","8" );
      ((Element)v.get(702)).appendChild((Element)v.get(703));
      /* Termina nodo:703   */
      /* Termina nodo:702   */

      /* Empieza nodo:704 / Elemento padre: 693   */
      v.add(doc.createElement("td"));
      ((Element)v.get(693)).appendChild((Element)v.get(704));

      /* Empieza nodo:705 / Elemento padre: 704   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(705)).setAttribute("nombre","lblTipoUsuario" );
      ((Element)v.get(705)).setAttribute("alto","13" );
      ((Element)v.get(705)).setAttribute("filas","1" );
      ((Element)v.get(705)).setAttribute("valor","" );
      ((Element)v.get(705)).setAttribute("id","datosTitle" );
      ((Element)v.get(705)).setAttribute("cod","131" );
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(704)).appendChild((Element)v.get(705));
      /* Termina nodo:705   */
      /* Termina nodo:704   */

      /* Empieza nodo:706 / Elemento padre: 693   */
      v.add(doc.createElement("td"));
      ((Element)v.get(706)).setAttribute("width","100%" );
      ((Element)v.get(693)).appendChild((Element)v.get(706));

      /* Empieza nodo:707 / Elemento padre: 706   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(707)).setAttribute("src","b.gif" );
      ((Element)v.get(707)).setAttribute("width","8" );
      ((Element)v.get(707)).setAttribute("height","8" );
      ((Element)v.get(706)).appendChild((Element)v.get(707));
      /* Termina nodo:707   */
      /* Termina nodo:706   */
      /* Termina nodo:693   */

      /* Empieza nodo:708 / Elemento padre: 692   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(692)).appendChild((Element)v.get(708));

      /* Empieza nodo:709 / Elemento padre: 708   */
      v.add(doc.createElement("td"));
      ((Element)v.get(708)).appendChild((Element)v.get(709));

      /* Empieza nodo:710 / Elemento padre: 709   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(710)).setAttribute("src","b.gif" );
      ((Element)v.get(710)).setAttribute("width","8" );
      ((Element)v.get(710)).setAttribute("height","8" );
      ((Element)v.get(709)).appendChild((Element)v.get(710));
      /* Termina nodo:710   */
      /* Termina nodo:709   */

      /* Empieza nodo:711 / Elemento padre: 708   */
      v.add(doc.createElement("td"));
      ((Element)v.get(711)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(708)).appendChild((Element)v.get(711));

      /* Empieza nodo:712 / Elemento padre: 711   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(712)).setAttribute("nombre","cbAccesoPorDefecto" );
      ((Element)v.get(712)).setAttribute("id","datosCampos" );
      ((Element)v.get(712)).setAttribute("size","1" );
      ((Element)v.get(712)).setAttribute("multiple","N" );
      ((Element)v.get(712)).setAttribute("req","S" );
      ((Element)v.get(712)).setAttribute("valorinicial","" );
      ((Element)v.get(712)).setAttribute("textoinicial","" );
      ((Element)v.get(712)).setAttribute("onchange","actualizarSeleccion('cbAccesoPorDefecto');" );
      ((Element)v.get(711)).appendChild((Element)v.get(712));

      /* Empieza nodo:713 / Elemento padre: 712   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(712)).appendChild((Element)v.get(713));
      /* Termina nodo:713   */
      /* Termina nodo:712   */
      /* Termina nodo:711   */

      /* Empieza nodo:714 / Elemento padre: 708   */
      v.add(doc.createElement("td"));
      ((Element)v.get(708)).appendChild((Element)v.get(714));

      /* Empieza nodo:715 / Elemento padre: 714   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(715)).setAttribute("src","b.gif" );
      ((Element)v.get(715)).setAttribute("width","25" );
      ((Element)v.get(715)).setAttribute("height","8" );
      ((Element)v.get(714)).appendChild((Element)v.get(715));
      /* Termina nodo:715   */
      /* Termina nodo:714   */

      /* Empieza nodo:716 / Elemento padre: 708   */
      v.add(doc.createElement("td"));
      ((Element)v.get(716)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(716)).setAttribute("valign","bottom" );
      ((Element)v.get(708)).appendChild((Element)v.get(716));

      /* Empieza nodo:717 / Elemento padre: 716   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(717)).setAttribute("nombre","cbSubaccesoPorDefecto" );
      ((Element)v.get(717)).setAttribute("id","datosCampos" );
      ((Element)v.get(717)).setAttribute("size","1" );
      ((Element)v.get(717)).setAttribute("multiple","N" );
      ((Element)v.get(717)).setAttribute("req","S" );
      ((Element)v.get(717)).setAttribute("valorinicial","" );
      ((Element)v.get(717)).setAttribute("textoinicial","" );
      ((Element)v.get(717)).setAttribute("onchange","actualizarSeleccion('cbSubaccesoPorDefecto');" );
      ((Element)v.get(716)).appendChild((Element)v.get(717));

      /* Empieza nodo:718 / Elemento padre: 717   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(717)).appendChild((Element)v.get(718));
      /* Termina nodo:718   */
      /* Termina nodo:717   */
      /* Termina nodo:716   */

      /* Empieza nodo:719 / Elemento padre: 708   */
      v.add(doc.createElement("td"));
      ((Element)v.get(708)).appendChild((Element)v.get(719));

      /* Empieza nodo:720 / Elemento padre: 719   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(720)).setAttribute("src","b.gif" );
      ((Element)v.get(720)).setAttribute("width","25" );
      ((Element)v.get(720)).setAttribute("height","8" );
      ((Element)v.get(719)).appendChild((Element)v.get(720));
      /* Termina nodo:720   */
      /* Termina nodo:719   */

      /* Empieza nodo:721 / Elemento padre: 708   */
      v.add(doc.createElement("td"));
      ((Element)v.get(721)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(708)).appendChild((Element)v.get(721));

      /* Empieza nodo:722 / Elemento padre: 721   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(722)).setAttribute("nombre","cbTipoUsuario" );
      ((Element)v.get(722)).setAttribute("id","datosCampos" );
      ((Element)v.get(722)).setAttribute("size","1" );
      ((Element)v.get(722)).setAttribute("multiple","N" );
      ((Element)v.get(722)).setAttribute("req","S" );
      ((Element)v.get(722)).setAttribute("valorinicial","" );
      ((Element)v.get(722)).setAttribute("textoinicial","" );
      ((Element)v.get(721)).appendChild((Element)v.get(722));

      /* Empieza nodo:723 / Elemento padre: 722   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(722)).appendChild((Element)v.get(723));
      /* Termina nodo:723   */
      /* Termina nodo:722   */
      /* Termina nodo:721   */

      /* Empieza nodo:724 / Elemento padre: 708   */
      v.add(doc.createElement("td"));
      ((Element)v.get(724)).setAttribute("width","100%" );
      ((Element)v.get(708)).appendChild((Element)v.get(724));

      /* Empieza nodo:725 / Elemento padre: 724   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(725)).setAttribute("src","b.gif" );
      ((Element)v.get(725)).setAttribute("width","8" );
      ((Element)v.get(725)).setAttribute("height","8" );
      ((Element)v.get(724)).appendChild((Element)v.get(725));
      /* Termina nodo:725   */
      /* Termina nodo:724   */
      /* Termina nodo:708   */

      /* Empieza nodo:726 / Elemento padre: 692   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(692)).appendChild((Element)v.get(726));

      /* Empieza nodo:727 / Elemento padre: 726   */
      v.add(doc.createElement("td"));
      ((Element)v.get(727)).setAttribute("colspan","4" );
      ((Element)v.get(726)).appendChild((Element)v.get(727));

      /* Empieza nodo:728 / Elemento padre: 727   */
   }

   private void getXML2970(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(728)).setAttribute("src","b.gif" );
      ((Element)v.get(728)).setAttribute("width","8" );
      ((Element)v.get(728)).setAttribute("height","8" );
      ((Element)v.get(727)).appendChild((Element)v.get(728));
      /* Termina nodo:728   */
      /* Termina nodo:727   */
      /* Termina nodo:726   */
      /* Termina nodo:692   */
      /* Termina nodo:691   */
      /* Termina nodo:690   */
      /* Termina nodo:542   */
      /* Termina nodo:539   */
      /* Termina nodo:538   */

      /* Empieza nodo:729 / Elemento padre: 535   */
      v.add(doc.createElement("td"));
      ((Element)v.get(535)).appendChild((Element)v.get(729));

      /* Empieza nodo:730 / Elemento padre: 729   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(730)).setAttribute("src","b.gif" );
      ((Element)v.get(729)).appendChild((Element)v.get(730));
      /* Termina nodo:730   */
      /* Termina nodo:729   */
      /* Termina nodo:535   */

      /* Empieza nodo:731 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(731));

      /* Empieza nodo:732 / Elemento padre: 731   */
      v.add(doc.createElement("td"));
      ((Element)v.get(732)).setAttribute("colspan","4" );
      ((Element)v.get(731)).appendChild((Element)v.get(732));

      /* Empieza nodo:733 / Elemento padre: 732   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(733)).setAttribute("src","b.gif" );
      ((Element)v.get(733)).setAttribute("width","8" );
      ((Element)v.get(733)).setAttribute("height","15" );
      ((Element)v.get(732)).appendChild((Element)v.get(733));
      /* Termina nodo:733   */
      /* Termina nodo:732   */
      /* Termina nodo:731   */

      /* Empieza nodo:734 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(734));

      /* Empieza nodo:735 / Elemento padre: 734   */
      v.add(doc.createElement("td"));
      ((Element)v.get(734)).appendChild((Element)v.get(735));

      /* Empieza nodo:736 / Elemento padre: 735   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(736)).setAttribute("src","b.gif" );
      ((Element)v.get(735)).appendChild((Element)v.get(736));
      /* Termina nodo:736   */
      /* Termina nodo:735   */

      /* Empieza nodo:737 / Elemento padre: 734   */
      v.add(doc.createElement("td"));
      ((Element)v.get(734)).appendChild((Element)v.get(737));

      /* Empieza nodo:738 / Elemento padre: 737   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(737)).appendChild((Element)v.get(738));

      /* Empieza nodo:739 / Elemento padre: 738   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(739)).setAttribute("class","legend" );
      ((Element)v.get(738)).appendChild((Element)v.get(739));

      /* Empieza nodo:740 / Elemento padre: 739   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(740)).setAttribute("nombre","lblDatosTecnicos" );
      ((Element)v.get(740)).setAttribute("alto","13" );
      ((Element)v.get(740)).setAttribute("filas","1" );
      ((Element)v.get(740)).setAttribute("valor","" );
      ((Element)v.get(740)).setAttribute("id","legend" );
      ((Element)v.get(740)).setAttribute("cod","00511" );
      ((Element)v.get(739)).appendChild((Element)v.get(740));
      /* Termina nodo:740   */
      /* Termina nodo:739   */

      /* Empieza nodo:741 / Elemento padre: 738   */
      v.add(doc.createElement("table"));
      ((Element)v.get(741)).setAttribute("width","100%" );
      ((Element)v.get(741)).setAttribute("border","0" );
      ((Element)v.get(741)).setAttribute("align","center" );
      ((Element)v.get(741)).setAttribute("cellspacing","0" );
      ((Element)v.get(741)).setAttribute("cellpadding","0" );
      ((Element)v.get(738)).appendChild((Element)v.get(741));

      /* Empieza nodo:742 / Elemento padre: 741   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(741)).appendChild((Element)v.get(742));

      /* Empieza nodo:743 / Elemento padre: 742   */
      v.add(doc.createElement("td"));
      ((Element)v.get(742)).appendChild((Element)v.get(743));

      /* Empieza nodo:744 / Elemento padre: 743   */
      v.add(doc.createElement("table"));
      ((Element)v.get(744)).setAttribute("width","688" );
      ((Element)v.get(744)).setAttribute("border","0" );
      ((Element)v.get(744)).setAttribute("align","left" );
      ((Element)v.get(744)).setAttribute("cellspacing","0" );
      ((Element)v.get(744)).setAttribute("cellpadding","0" );
      ((Element)v.get(743)).appendChild((Element)v.get(744));

      /* Empieza nodo:745 / Elemento padre: 744   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(744)).appendChild((Element)v.get(745));

      /* Empieza nodo:746 / Elemento padre: 745   */
      v.add(doc.createElement("td"));
      ((Element)v.get(746)).setAttribute("colspan","4" );
      ((Element)v.get(745)).appendChild((Element)v.get(746));

      /* Empieza nodo:747 / Elemento padre: 746   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(747)).setAttribute("src","b.gif" );
      ((Element)v.get(747)).setAttribute("width","8" );
      ((Element)v.get(747)).setAttribute("height","8" );
      ((Element)v.get(746)).appendChild((Element)v.get(747));
      /* Termina nodo:747   */
      /* Termina nodo:746   */
      /* Termina nodo:745   */

      /* Empieza nodo:748 / Elemento padre: 744   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(744)).appendChild((Element)v.get(748));

      /* Empieza nodo:749 / Elemento padre: 748   */
      v.add(doc.createElement("td"));
      ((Element)v.get(748)).appendChild((Element)v.get(749));

      /* Empieza nodo:750 / Elemento padre: 749   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(750)).setAttribute("src","b.gif" );
      ((Element)v.get(750)).setAttribute("width","8" );
      ((Element)v.get(750)).setAttribute("height","8" );
      ((Element)v.get(749)).appendChild((Element)v.get(750));
      /* Termina nodo:750   */
      /* Termina nodo:749   */

      /* Empieza nodo:751 / Elemento padre: 748   */
      v.add(doc.createElement("td"));
      ((Element)v.get(748)).appendChild((Element)v.get(751));

      /* Empieza nodo:752 / Elemento padre: 751   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(752)).setAttribute("nombre","lblIdioma" );
      ((Element)v.get(752)).setAttribute("alto","13" );
      ((Element)v.get(752)).setAttribute("filas","1" );
      ((Element)v.get(752)).setAttribute("valor","" );
      ((Element)v.get(752)).setAttribute("id","datosTitle" );
      ((Element)v.get(752)).setAttribute("cod","71" );
      ((Element)v.get(751)).appendChild((Element)v.get(752));
      /* Termina nodo:752   */
      /* Termina nodo:751   */

      /* Empieza nodo:753 / Elemento padre: 748   */
      v.add(doc.createElement("td"));
   }

   private void getXML3060(Document doc) {
      ((Element)v.get(748)).appendChild((Element)v.get(753));

      /* Empieza nodo:754 / Elemento padre: 753   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(754)).setAttribute("src","b.gif" );
      ((Element)v.get(754)).setAttribute("width","25" );
      ((Element)v.get(754)).setAttribute("height","8" );
      ((Element)v.get(753)).appendChild((Element)v.get(754));
      /* Termina nodo:754   */
      /* Termina nodo:753   */

      /* Empieza nodo:755 / Elemento padre: 748   */
      v.add(doc.createElement("td"));
      ((Element)v.get(748)).appendChild((Element)v.get(755));

      /* Empieza nodo:756 / Elemento padre: 755   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(756)).setAttribute("nombre","lblTipoRastreo" );
      ((Element)v.get(756)).setAttribute("alto","13" );
      ((Element)v.get(756)).setAttribute("filas","1" );
      ((Element)v.get(756)).setAttribute("valor","" );
      ((Element)v.get(756)).setAttribute("id","datosTitle" );
      ((Element)v.get(756)).setAttribute("cod","108" );
      ((Element)v.get(755)).appendChild((Element)v.get(756));
      /* Termina nodo:756   */
      /* Termina nodo:755   */

      /* Empieza nodo:757 / Elemento padre: 748   */
      v.add(doc.createElement("td"));
      ((Element)v.get(748)).appendChild((Element)v.get(757));

      /* Empieza nodo:758 / Elemento padre: 757   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(758)).setAttribute("src","b.gif" );
      ((Element)v.get(758)).setAttribute("width","25" );
      ((Element)v.get(758)).setAttribute("height","8" );
      ((Element)v.get(757)).appendChild((Element)v.get(758));
      /* Termina nodo:758   */
      /* Termina nodo:757   */

      /* Empieza nodo:759 / Elemento padre: 748   */
      v.add(doc.createElement("td"));
      ((Element)v.get(748)).appendChild((Element)v.get(759));

      /* Empieza nodo:760 / Elemento padre: 759   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(760)).setAttribute("nombre","lblFechaInicioRastreo" );
      ((Element)v.get(760)).setAttribute("alto","13" );
      ((Element)v.get(760)).setAttribute("filas","1" );
      ((Element)v.get(760)).setAttribute("valor","" );
      ((Element)v.get(760)).setAttribute("id","datosTitle" );
      ((Element)v.get(760)).setAttribute("cod","61" );
      ((Element)v.get(759)).appendChild((Element)v.get(760));
      /* Termina nodo:760   */
      /* Termina nodo:759   */

      /* Empieza nodo:761 / Elemento padre: 748   */
      v.add(doc.createElement("td"));
      ((Element)v.get(748)).appendChild((Element)v.get(761));

      /* Empieza nodo:762 / Elemento padre: 761   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(762)).setAttribute("src","b.gif" );
      ((Element)v.get(762)).setAttribute("width","25" );
      ((Element)v.get(762)).setAttribute("height","8" );
      ((Element)v.get(761)).appendChild((Element)v.get(762));
      /* Termina nodo:762   */
      /* Termina nodo:761   */

      /* Empieza nodo:763 / Elemento padre: 748   */
      v.add(doc.createElement("td"));
      ((Element)v.get(748)).appendChild((Element)v.get(763));

      /* Empieza nodo:764 / Elemento padre: 763   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(764)).setAttribute("nombre","lblFechaFinRastreo" );
      ((Element)v.get(764)).setAttribute("alto","13" );
      ((Element)v.get(764)).setAttribute("filas","1" );
      ((Element)v.get(764)).setAttribute("valor","" );
      ((Element)v.get(764)).setAttribute("id","datosTitle" );
      ((Element)v.get(764)).setAttribute("cod","60" );
      ((Element)v.get(763)).appendChild((Element)v.get(764));
      /* Termina nodo:764   */
      /* Termina nodo:763   */

      /* Empieza nodo:765 / Elemento padre: 748   */
      v.add(doc.createElement("td"));
      ((Element)v.get(765)).setAttribute("width","100%" );
      ((Element)v.get(748)).appendChild((Element)v.get(765));

      /* Empieza nodo:766 / Elemento padre: 765   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(766)).setAttribute("src","b.gif" );
      ((Element)v.get(766)).setAttribute("width","8" );
      ((Element)v.get(766)).setAttribute("height","8" );
      ((Element)v.get(765)).appendChild((Element)v.get(766));
      /* Termina nodo:766   */
      /* Termina nodo:765   */
      /* Termina nodo:748   */

      /* Empieza nodo:767 / Elemento padre: 744   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(744)).appendChild((Element)v.get(767));

      /* Empieza nodo:768 / Elemento padre: 767   */
      v.add(doc.createElement("td"));
      ((Element)v.get(767)).appendChild((Element)v.get(768));

      /* Empieza nodo:769 / Elemento padre: 768   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(769)).setAttribute("src","b.gif" );
      ((Element)v.get(769)).setAttribute("width","8" );
      ((Element)v.get(769)).setAttribute("height","8" );
      ((Element)v.get(768)).appendChild((Element)v.get(769));
      /* Termina nodo:769   */
      /* Termina nodo:768   */

      /* Empieza nodo:770 / Elemento padre: 767   */
      v.add(doc.createElement("td"));
      ((Element)v.get(770)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(767)).appendChild((Element)v.get(770));

      /* Empieza nodo:771 / Elemento padre: 770   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(771)).setAttribute("nombre","cbIdioma" );
      ((Element)v.get(771)).setAttribute("id","datosCampos" );
      ((Element)v.get(771)).setAttribute("size","1" );
      ((Element)v.get(771)).setAttribute("multiple","N" );
      ((Element)v.get(771)).setAttribute("req","S" );
      ((Element)v.get(771)).setAttribute("valorinicial","" );
      ((Element)v.get(771)).setAttribute("textoinicial","" );
      ((Element)v.get(770)).appendChild((Element)v.get(771));

      /* Empieza nodo:772 / Elemento padre: 771   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(771)).appendChild((Element)v.get(772));
      /* Termina nodo:772   */
      /* Termina nodo:771   */
      /* Termina nodo:770   */

      /* Empieza nodo:773 / Elemento padre: 767   */
      v.add(doc.createElement("td"));
      ((Element)v.get(767)).appendChild((Element)v.get(773));

      /* Empieza nodo:774 / Elemento padre: 773   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(774)).setAttribute("src","b.gif" );
      ((Element)v.get(774)).setAttribute("width","25" );
      ((Element)v.get(774)).setAttribute("height","8" );
      ((Element)v.get(773)).appendChild((Element)v.get(774));
      /* Termina nodo:774   */
      /* Termina nodo:773   */

      /* Empieza nodo:775 / Elemento padre: 767   */
      v.add(doc.createElement("td"));
      ((Element)v.get(775)).setAttribute("nowrap","nowrap" );
   }

   private void getXML3150(Document doc) {
      ((Element)v.get(767)).appendChild((Element)v.get(775));

      /* Empieza nodo:776 / Elemento padre: 775   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(776)).setAttribute("nombre","cbTipoRastreo" );
      ((Element)v.get(776)).setAttribute("id","datosCampos" );
      ((Element)v.get(776)).setAttribute("size","1" );
      ((Element)v.get(776)).setAttribute("multiple","N" );
      ((Element)v.get(776)).setAttribute("req","S" );
      ((Element)v.get(776)).setAttribute("valorinicial","" );
      ((Element)v.get(776)).setAttribute("textoinicial","" );
      ((Element)v.get(776)).setAttribute("onchange","verificarCamposRastreo();" );
      ((Element)v.get(775)).appendChild((Element)v.get(776));

      /* Empieza nodo:777 / Elemento padre: 776   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(776)).appendChild((Element)v.get(777));
      /* Termina nodo:777   */
      /* Termina nodo:776   */
      /* Termina nodo:775   */

      /* Empieza nodo:778 / Elemento padre: 767   */
      v.add(doc.createElement("td"));
      ((Element)v.get(767)).appendChild((Element)v.get(778));

      /* Empieza nodo:779 / Elemento padre: 778   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(779)).setAttribute("src","b.gif" );
      ((Element)v.get(779)).setAttribute("width","25" );
      ((Element)v.get(779)).setAttribute("height","8" );
      ((Element)v.get(778)).appendChild((Element)v.get(779));
      /* Termina nodo:779   */
      /* Termina nodo:778   */

      /* Empieza nodo:780 / Elemento padre: 767   */
      v.add(doc.createElement("td"));
      ((Element)v.get(780)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(780)).setAttribute("valign","bottom" );
      ((Element)v.get(767)).appendChild((Element)v.get(780));

      /* Empieza nodo:781 / Elemento padre: 780   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(781)).setAttribute("nombre","txtFechaInicioRastreo" );
      ((Element)v.get(781)).setAttribute("group","txtFechaInicioRastreo" );
      ((Element)v.get(781)).setAttribute("id","datosCampos" );
      ((Element)v.get(781)).setAttribute("max","10" );
      ((Element)v.get(781)).setAttribute("tipo","" );
      ((Element)v.get(781)).setAttribute("onchange","" );
      ((Element)v.get(781)).setAttribute("req","N" );
      ((Element)v.get(781)).setAttribute("size","12" );
      ((Element)v.get(781)).setAttribute("valor","" );
      ((Element)v.get(781)).setAttribute("validacion","" );
      ((Element)v.get(780)).appendChild((Element)v.get(781));
      /* Termina nodo:781   */
      /* Termina nodo:780   */

      /* Empieza nodo:782 / Elemento padre: 767   */
      v.add(doc.createElement("td"));
      ((Element)v.get(767)).appendChild((Element)v.get(782));

      /* Empieza nodo:783 / Elemento padre: 782   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(783)).setAttribute("src","b.gif" );
      ((Element)v.get(783)).setAttribute("width","25" );
      ((Element)v.get(783)).setAttribute("height","8" );
      ((Element)v.get(782)).appendChild((Element)v.get(783));
      /* Termina nodo:783   */
      /* Termina nodo:782   */

      /* Empieza nodo:784 / Elemento padre: 767   */
      v.add(doc.createElement("td"));
      ((Element)v.get(784)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(784)).setAttribute("valign","bottom" );
      ((Element)v.get(767)).appendChild((Element)v.get(784));

      /* Empieza nodo:785 / Elemento padre: 784   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(785)).setAttribute("nombre","txtFechaFinRastreo" );
      ((Element)v.get(785)).setAttribute("group","txtFechaFinRastreo" );
      ((Element)v.get(785)).setAttribute("id","datosCampos" );
      ((Element)v.get(785)).setAttribute("max","10" );
      ((Element)v.get(785)).setAttribute("tipo","" );
      ((Element)v.get(785)).setAttribute("onchange","" );
      ((Element)v.get(785)).setAttribute("req","N" );
      ((Element)v.get(785)).setAttribute("size","12" );
      ((Element)v.get(785)).setAttribute("valor","" );
      ((Element)v.get(785)).setAttribute("validacion","" );
      ((Element)v.get(784)).appendChild((Element)v.get(785));
      /* Termina nodo:785   */
      /* Termina nodo:784   */

      /* Empieza nodo:786 / Elemento padre: 767   */
      v.add(doc.createElement("td"));
      ((Element)v.get(786)).setAttribute("width","100%" );
      ((Element)v.get(767)).appendChild((Element)v.get(786));

      /* Empieza nodo:787 / Elemento padre: 786   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(787)).setAttribute("src","b.gif" );
      ((Element)v.get(787)).setAttribute("width","8" );
      ((Element)v.get(787)).setAttribute("height","8" );
      ((Element)v.get(786)).appendChild((Element)v.get(787));
      /* Termina nodo:787   */
      /* Termina nodo:786   */
      /* Termina nodo:767   */

      /* Empieza nodo:788 / Elemento padre: 744   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(744)).appendChild((Element)v.get(788));

      /* Empieza nodo:789 / Elemento padre: 788   */
      v.add(doc.createElement("td"));
      ((Element)v.get(789)).setAttribute("colspan","4" );
      ((Element)v.get(788)).appendChild((Element)v.get(789));

      /* Empieza nodo:790 / Elemento padre: 789   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(790)).setAttribute("src","b.gif" );
      ((Element)v.get(790)).setAttribute("width","8" );
      ((Element)v.get(790)).setAttribute("height","8" );
      ((Element)v.get(789)).appendChild((Element)v.get(790));
      /* Termina nodo:790   */
      /* Termina nodo:789   */
      /* Termina nodo:788   */
      /* Termina nodo:744   */
      /* Termina nodo:743   */
      /* Termina nodo:742   */

      /* Empieza nodo:791 / Elemento padre: 741   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(741)).appendChild((Element)v.get(791));

      /* Empieza nodo:792 / Elemento padre: 791   */
      v.add(doc.createElement("td"));
      ((Element)v.get(791)).appendChild((Element)v.get(792));

      /* Empieza nodo:793 / Elemento padre: 792   */
      v.add(doc.createElement("table"));
      ((Element)v.get(793)).setAttribute("width","688" );
      ((Element)v.get(793)).setAttribute("border","0" );
      ((Element)v.get(793)).setAttribute("align","left" );
      ((Element)v.get(793)).setAttribute("cellspacing","0" );
      ((Element)v.get(793)).setAttribute("cellpadding","0" );
      ((Element)v.get(792)).appendChild((Element)v.get(793));

      /* Empieza nodo:794 / Elemento padre: 793   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(793)).appendChild((Element)v.get(794));

      /* Empieza nodo:795 / Elemento padre: 794   */
   }

   private void getXML3240(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(794)).appendChild((Element)v.get(795));

      /* Empieza nodo:796 / Elemento padre: 795   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(796)).setAttribute("src","b.gif" );
      ((Element)v.get(796)).setAttribute("width","8" );
      ((Element)v.get(796)).setAttribute("height","8" );
      ((Element)v.get(795)).appendChild((Element)v.get(796));
      /* Termina nodo:796   */
      /* Termina nodo:795   */

      /* Empieza nodo:797 / Elemento padre: 794   */
      v.add(doc.createElement("td"));
      ((Element)v.get(794)).appendChild((Element)v.get(797));

      /* Empieza nodo:798 / Elemento padre: 797   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(798)).setAttribute("nombre","lblPantallaInicioAsociada" );
      ((Element)v.get(798)).setAttribute("alto","13" );
      ((Element)v.get(798)).setAttribute("filas","1" );
      ((Element)v.get(798)).setAttribute("valor","" );
      ((Element)v.get(798)).setAttribute("id","datosTitle" );
      ((Element)v.get(798)).setAttribute("cod","102" );
      ((Element)v.get(797)).appendChild((Element)v.get(798));
      /* Termina nodo:798   */
      /* Termina nodo:797   */

      /* Empieza nodo:799 / Elemento padre: 794   */
      v.add(doc.createElement("td"));
      ((Element)v.get(799)).setAttribute("width","100%" );
      ((Element)v.get(794)).appendChild((Element)v.get(799));

      /* Empieza nodo:800 / Elemento padre: 799   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(800)).setAttribute("src","b.gif" );
      ((Element)v.get(800)).setAttribute("width","8" );
      ((Element)v.get(800)).setAttribute("height","8" );
      ((Element)v.get(799)).appendChild((Element)v.get(800));
      /* Termina nodo:800   */
      /* Termina nodo:799   */
      /* Termina nodo:794   */

      /* Empieza nodo:801 / Elemento padre: 793   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(793)).appendChild((Element)v.get(801));

      /* Empieza nodo:802 / Elemento padre: 801   */
      v.add(doc.createElement("td"));
      ((Element)v.get(801)).appendChild((Element)v.get(802));

      /* Empieza nodo:803 / Elemento padre: 802   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(803)).setAttribute("src","b.gif" );
      ((Element)v.get(803)).setAttribute("width","8" );
      ((Element)v.get(803)).setAttribute("height","8" );
      ((Element)v.get(802)).appendChild((Element)v.get(803));
      /* Termina nodo:803   */
      /* Termina nodo:802   */

      /* Empieza nodo:804 / Elemento padre: 801   */
      v.add(doc.createElement("td"));
      ((Element)v.get(804)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(801)).appendChild((Element)v.get(804));

      /* Empieza nodo:805 / Elemento padre: 804   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(805)).setAttribute("nombre","cbPantallaInicioAsociada" );
      ((Element)v.get(805)).setAttribute("id","datosCampos" );
      ((Element)v.get(805)).setAttribute("size","1" );
      ((Element)v.get(805)).setAttribute("multiple","N" );
      ((Element)v.get(805)).setAttribute("req","N" );
      ((Element)v.get(805)).setAttribute("valorinicial","" );
      ((Element)v.get(805)).setAttribute("textoinicial","" );
      ((Element)v.get(804)).appendChild((Element)v.get(805));

      /* Empieza nodo:806 / Elemento padre: 805   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(805)).appendChild((Element)v.get(806));
      /* Termina nodo:806   */
      /* Termina nodo:805   */
      /* Termina nodo:804   */

      /* Empieza nodo:807 / Elemento padre: 801   */
      v.add(doc.createElement("td"));
      ((Element)v.get(807)).setAttribute("width","100%" );
      ((Element)v.get(801)).appendChild((Element)v.get(807));

      /* Empieza nodo:808 / Elemento padre: 807   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(808)).setAttribute("src","b.gif" );
      ((Element)v.get(808)).setAttribute("width","8" );
      ((Element)v.get(808)).setAttribute("height","8" );
      ((Element)v.get(807)).appendChild((Element)v.get(808));
      /* Termina nodo:808   */
      /* Termina nodo:807   */
      /* Termina nodo:801   */

      /* Empieza nodo:809 / Elemento padre: 793   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(793)).appendChild((Element)v.get(809));

      /* Empieza nodo:810 / Elemento padre: 809   */
      v.add(doc.createElement("td"));
      ((Element)v.get(810)).setAttribute("colspan","4" );
      ((Element)v.get(809)).appendChild((Element)v.get(810));

      /* Empieza nodo:811 / Elemento padre: 810   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(811)).setAttribute("src","b.gif" );
      ((Element)v.get(811)).setAttribute("width","8" );
      ((Element)v.get(811)).setAttribute("height","8" );
      ((Element)v.get(810)).appendChild((Element)v.get(811));
      /* Termina nodo:811   */
      /* Termina nodo:810   */
      /* Termina nodo:809   */
      /* Termina nodo:793   */
      /* Termina nodo:792   */
      /* Termina nodo:791   */
      /* Termina nodo:741   */
      /* Termina nodo:738   */
      /* Termina nodo:737   */

      /* Empieza nodo:812 / Elemento padre: 734   */
      v.add(doc.createElement("td"));
      ((Element)v.get(734)).appendChild((Element)v.get(812));

      /* Empieza nodo:813 / Elemento padre: 812   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(813)).setAttribute("src","b.gif" );
      ((Element)v.get(812)).appendChild((Element)v.get(813));
      /* Termina nodo:813   */
      /* Termina nodo:812   */
      /* Termina nodo:734   */

      /* Empieza nodo:814 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(814));

      /* Empieza nodo:815 / Elemento padre: 814   */
      v.add(doc.createElement("td"));
      ((Element)v.get(815)).setAttribute("colspan","4" );
      ((Element)v.get(814)).appendChild((Element)v.get(815));

      /* Empieza nodo:816 / Elemento padre: 815   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(816)).setAttribute("src","b.gif" );
      ((Element)v.get(816)).setAttribute("width","8" );
      ((Element)v.get(816)).setAttribute("height","15" );
      ((Element)v.get(815)).appendChild((Element)v.get(816));
      /* Termina nodo:816   */
      /* Termina nodo:815   */
      /* Termina nodo:814   */

      /* Empieza nodo:817 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(817));

      /* Empieza nodo:818 / Elemento padre: 817   */
      v.add(doc.createElement("td"));
      ((Element)v.get(817)).appendChild((Element)v.get(818));

      /* Empieza nodo:819 / Elemento padre: 818   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(819)).setAttribute("src","b.gif" );
      ((Element)v.get(818)).appendChild((Element)v.get(819));
      /* Termina nodo:819   */
      /* Termina nodo:818   */

      /* Empieza nodo:820 / Elemento padre: 817   */
      v.add(doc.createElement("td"));
      ((Element)v.get(817)).appendChild((Element)v.get(820));

      /* Empieza nodo:821 / Elemento padre: 820   */
   }

   private void getXML3330(Document doc) {
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(820)).appendChild((Element)v.get(821));

      /* Empieza nodo:822 / Elemento padre: 821   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(822)).setAttribute("class","legend" );
      ((Element)v.get(821)).appendChild((Element)v.get(822));

      /* Empieza nodo:823 / Elemento padre: 822   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(823)).setAttribute("nombre","lblDatosSustitucion" );
      ((Element)v.get(823)).setAttribute("alto","13" );
      ((Element)v.get(823)).setAttribute("filas","1" );
      ((Element)v.get(823)).setAttribute("valor","" );
      ((Element)v.get(823)).setAttribute("id","legend" );
      ((Element)v.get(823)).setAttribute("cod","00512" );
      ((Element)v.get(822)).appendChild((Element)v.get(823));
      /* Termina nodo:823   */
      /* Termina nodo:822   */

      /* Empieza nodo:824 / Elemento padre: 821   */
      v.add(doc.createElement("table"));
      ((Element)v.get(824)).setAttribute("width","100%" );
      ((Element)v.get(824)).setAttribute("border","0" );
      ((Element)v.get(824)).setAttribute("align","center" );
      ((Element)v.get(824)).setAttribute("cellspacing","0" );
      ((Element)v.get(824)).setAttribute("cellpadding","0" );
      ((Element)v.get(821)).appendChild((Element)v.get(824));

      /* Empieza nodo:825 / Elemento padre: 824   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(824)).appendChild((Element)v.get(825));

      /* Empieza nodo:826 / Elemento padre: 825   */
      v.add(doc.createElement("td"));
      ((Element)v.get(825)).appendChild((Element)v.get(826));

      /* Empieza nodo:827 / Elemento padre: 826   */
      v.add(doc.createElement("table"));
      ((Element)v.get(827)).setAttribute("width","688" );
      ((Element)v.get(827)).setAttribute("border","0" );
      ((Element)v.get(827)).setAttribute("align","left" );
      ((Element)v.get(827)).setAttribute("cellspacing","0" );
      ((Element)v.get(827)).setAttribute("cellpadding","0" );
      ((Element)v.get(826)).appendChild((Element)v.get(827));

      /* Empieza nodo:828 / Elemento padre: 827   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(827)).appendChild((Element)v.get(828));

      /* Empieza nodo:829 / Elemento padre: 828   */
      v.add(doc.createElement("td"));
      ((Element)v.get(829)).setAttribute("colspan","4" );
      ((Element)v.get(828)).appendChild((Element)v.get(829));

      /* Empieza nodo:830 / Elemento padre: 829   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(830)).setAttribute("src","b.gif" );
      ((Element)v.get(830)).setAttribute("width","8" );
      ((Element)v.get(830)).setAttribute("height","8" );
      ((Element)v.get(829)).appendChild((Element)v.get(830));
      /* Termina nodo:830   */
      /* Termina nodo:829   */
      /* Termina nodo:828   */

      /* Empieza nodo:831 / Elemento padre: 827   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(827)).appendChild((Element)v.get(831));

      /* Empieza nodo:832 / Elemento padre: 831   */
      v.add(doc.createElement("td"));
      ((Element)v.get(831)).appendChild((Element)v.get(832));

      /* Empieza nodo:833 / Elemento padre: 832   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(833)).setAttribute("src","b.gif" );
      ((Element)v.get(833)).setAttribute("width","8" );
      ((Element)v.get(833)).setAttribute("height","8" );
      ((Element)v.get(832)).appendChild((Element)v.get(833));
      /* Termina nodo:833   */
      /* Termina nodo:832   */

      /* Empieza nodo:834 / Elemento padre: 831   */
      v.add(doc.createElement("td"));
      ((Element)v.get(831)).appendChild((Element)v.get(834));

      /* Empieza nodo:835 / Elemento padre: 834   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(835)).setAttribute("nombre","lblUsuarioSustitucion" );
      ((Element)v.get(835)).setAttribute("alto","13" );
      ((Element)v.get(835)).setAttribute("filas","1" );
      ((Element)v.get(835)).setAttribute("valor","" );
      ((Element)v.get(835)).setAttribute("id","datosTitle" );
      ((Element)v.get(835)).setAttribute("cod","140" );
      ((Element)v.get(834)).appendChild((Element)v.get(835));
      /* Termina nodo:835   */
      /* Termina nodo:834   */

      /* Empieza nodo:836 / Elemento padre: 831   */
      v.add(doc.createElement("td"));
      ((Element)v.get(836)).setAttribute("width","100%" );
      ((Element)v.get(831)).appendChild((Element)v.get(836));

      /* Empieza nodo:837 / Elemento padre: 836   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(837)).setAttribute("src","b.gif" );
      ((Element)v.get(837)).setAttribute("width","8" );
      ((Element)v.get(837)).setAttribute("height","8" );
      ((Element)v.get(836)).appendChild((Element)v.get(837));
      /* Termina nodo:837   */
      /* Termina nodo:836   */
      /* Termina nodo:831   */

      /* Empieza nodo:838 / Elemento padre: 827   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(827)).appendChild((Element)v.get(838));

      /* Empieza nodo:839 / Elemento padre: 838   */
      v.add(doc.createElement("td"));
      ((Element)v.get(838)).appendChild((Element)v.get(839));

      /* Empieza nodo:840 / Elemento padre: 839   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(840)).setAttribute("src","b.gif" );
      ((Element)v.get(840)).setAttribute("width","8" );
      ((Element)v.get(840)).setAttribute("height","8" );
      ((Element)v.get(839)).appendChild((Element)v.get(840));
      /* Termina nodo:840   */
      /* Termina nodo:839   */

      /* Empieza nodo:841 / Elemento padre: 838   */
      v.add(doc.createElement("td"));
      ((Element)v.get(841)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(838)).appendChild((Element)v.get(841));

      /* Empieza nodo:842 / Elemento padre: 841   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(842)).setAttribute("nombre","cbUsuarioSustitucion" );
      ((Element)v.get(842)).setAttribute("id","datosCampos" );
      ((Element)v.get(842)).setAttribute("size","1" );
      ((Element)v.get(842)).setAttribute("multiple","N" );
      ((Element)v.get(842)).setAttribute("req","N" );
      ((Element)v.get(842)).setAttribute("valorinicial","" );
      ((Element)v.get(842)).setAttribute("textoinicial","" );
      ((Element)v.get(842)).setAttribute("onchange","verificarCamposSust();" );
      ((Element)v.get(841)).appendChild((Element)v.get(842));

      /* Empieza nodo:843 / Elemento padre: 842   */
   }

   private void getXML3420(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(842)).appendChild((Element)v.get(843));
      /* Termina nodo:843   */
      /* Termina nodo:842   */
      /* Termina nodo:841   */

      /* Empieza nodo:844 / Elemento padre: 838   */
      v.add(doc.createElement("td"));
      ((Element)v.get(844)).setAttribute("width","100%" );
      ((Element)v.get(838)).appendChild((Element)v.get(844));

      /* Empieza nodo:845 / Elemento padre: 844   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(845)).setAttribute("src","b.gif" );
      ((Element)v.get(845)).setAttribute("width","8" );
      ((Element)v.get(845)).setAttribute("height","8" );
      ((Element)v.get(844)).appendChild((Element)v.get(845));
      /* Termina nodo:845   */
      /* Termina nodo:844   */
      /* Termina nodo:838   */
      /* Termina nodo:827   */
      /* Termina nodo:826   */
      /* Termina nodo:825   */

      /* Empieza nodo:846 / Elemento padre: 824   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(824)).appendChild((Element)v.get(846));

      /* Empieza nodo:847 / Elemento padre: 846   */
      v.add(doc.createElement("td"));
      ((Element)v.get(846)).appendChild((Element)v.get(847));

      /* Empieza nodo:848 / Elemento padre: 847   */
      v.add(doc.createElement("table"));
      ((Element)v.get(848)).setAttribute("width","688" );
      ((Element)v.get(848)).setAttribute("border","0" );
      ((Element)v.get(848)).setAttribute("align","left" );
      ((Element)v.get(848)).setAttribute("cellspacing","0" );
      ((Element)v.get(848)).setAttribute("cellpadding","0" );
      ((Element)v.get(847)).appendChild((Element)v.get(848));

      /* Empieza nodo:849 / Elemento padre: 848   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(848)).appendChild((Element)v.get(849));

      /* Empieza nodo:850 / Elemento padre: 849   */
      v.add(doc.createElement("td"));
      ((Element)v.get(850)).setAttribute("colspan","4" );
      ((Element)v.get(849)).appendChild((Element)v.get(850));

      /* Empieza nodo:851 / Elemento padre: 850   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(851)).setAttribute("src","b.gif" );
      ((Element)v.get(851)).setAttribute("width","8" );
      ((Element)v.get(851)).setAttribute("height","8" );
      ((Element)v.get(850)).appendChild((Element)v.get(851));
      /* Termina nodo:851   */
      /* Termina nodo:850   */
      /* Termina nodo:849   */

      /* Empieza nodo:852 / Elemento padre: 848   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(848)).appendChild((Element)v.get(852));

      /* Empieza nodo:853 / Elemento padre: 852   */
      v.add(doc.createElement("td"));
      ((Element)v.get(852)).appendChild((Element)v.get(853));

      /* Empieza nodo:854 / Elemento padre: 853   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(854)).setAttribute("src","b.gif" );
      ((Element)v.get(854)).setAttribute("width","8" );
      ((Element)v.get(854)).setAttribute("height","8" );
      ((Element)v.get(853)).appendChild((Element)v.get(854));
      /* Termina nodo:854   */
      /* Termina nodo:853   */

      /* Empieza nodo:855 / Elemento padre: 852   */
      v.add(doc.createElement("td"));
      ((Element)v.get(852)).appendChild((Element)v.get(855));

      /* Empieza nodo:856 / Elemento padre: 855   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(856)).setAttribute("nombre","lblFechaSustitucionDesde" );
      ((Element)v.get(856)).setAttribute("alto","13" );
      ((Element)v.get(856)).setAttribute("filas","1" );
      ((Element)v.get(856)).setAttribute("valor","" );
      ((Element)v.get(856)).setAttribute("id","datosTitle" );
      ((Element)v.get(856)).setAttribute("cod","168" );
      ((Element)v.get(855)).appendChild((Element)v.get(856));
      /* Termina nodo:856   */
      /* Termina nodo:855   */

      /* Empieza nodo:857 / Elemento padre: 852   */
      v.add(doc.createElement("td"));
      ((Element)v.get(852)).appendChild((Element)v.get(857));

      /* Empieza nodo:858 / Elemento padre: 857   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(858)).setAttribute("src","b.gif" );
      ((Element)v.get(858)).setAttribute("width","25" );
      ((Element)v.get(858)).setAttribute("height","8" );
      ((Element)v.get(857)).appendChild((Element)v.get(858));
      /* Termina nodo:858   */
      /* Termina nodo:857   */

      /* Empieza nodo:859 / Elemento padre: 852   */
      v.add(doc.createElement("td"));
      ((Element)v.get(852)).appendChild((Element)v.get(859));

      /* Empieza nodo:860 / Elemento padre: 859   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(860)).setAttribute("nombre","lblFechaSustitucionHasta" );
      ((Element)v.get(860)).setAttribute("alto","13" );
      ((Element)v.get(860)).setAttribute("filas","1" );
      ((Element)v.get(860)).setAttribute("valor","" );
      ((Element)v.get(860)).setAttribute("id","datosTitle" );
      ((Element)v.get(860)).setAttribute("cod","2211" );
      ((Element)v.get(859)).appendChild((Element)v.get(860));
      /* Termina nodo:860   */
      /* Termina nodo:859   */

      /* Empieza nodo:861 / Elemento padre: 852   */
      v.add(doc.createElement("td"));
      ((Element)v.get(861)).setAttribute("width","100%" );
      ((Element)v.get(852)).appendChild((Element)v.get(861));

      /* Empieza nodo:862 / Elemento padre: 861   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(862)).setAttribute("src","b.gif" );
      ((Element)v.get(862)).setAttribute("width","8" );
      ((Element)v.get(862)).setAttribute("height","8" );
      ((Element)v.get(861)).appendChild((Element)v.get(862));
      /* Termina nodo:862   */
      /* Termina nodo:861   */
      /* Termina nodo:852   */

      /* Empieza nodo:863 / Elemento padre: 848   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(848)).appendChild((Element)v.get(863));

      /* Empieza nodo:864 / Elemento padre: 863   */
      v.add(doc.createElement("td"));
      ((Element)v.get(863)).appendChild((Element)v.get(864));

      /* Empieza nodo:865 / Elemento padre: 864   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(865)).setAttribute("src","b.gif" );
      ((Element)v.get(865)).setAttribute("width","8" );
      ((Element)v.get(865)).setAttribute("height","8" );
      ((Element)v.get(864)).appendChild((Element)v.get(865));
      /* Termina nodo:865   */
      /* Termina nodo:864   */

      /* Empieza nodo:866 / Elemento padre: 863   */
      v.add(doc.createElement("td"));
      ((Element)v.get(866)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(866)).setAttribute("valign","bottom" );
      ((Element)v.get(863)).appendChild((Element)v.get(866));

      /* Empieza nodo:867 / Elemento padre: 866   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(867)).setAttribute("nombre","txtFechaSustitucionDesde" );
   }

   private void getXML3510(Document doc) {
      ((Element)v.get(867)).setAttribute("group","txtFechaSustitucionDesde" );
      ((Element)v.get(867)).setAttribute("id","datosCampos" );
      ((Element)v.get(867)).setAttribute("max","10" );
      ((Element)v.get(867)).setAttribute("tipo","" );
      ((Element)v.get(867)).setAttribute("onchange","" );
      ((Element)v.get(867)).setAttribute("req","N" );
      ((Element)v.get(867)).setAttribute("size","12" );
      ((Element)v.get(867)).setAttribute("valor","" );
      ((Element)v.get(867)).setAttribute("validacion","" );
      ((Element)v.get(866)).appendChild((Element)v.get(867));
      /* Termina nodo:867   */
      /* Termina nodo:866   */

      /* Empieza nodo:868 / Elemento padre: 863   */
      v.add(doc.createElement("td"));
      ((Element)v.get(863)).appendChild((Element)v.get(868));

      /* Empieza nodo:869 / Elemento padre: 868   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(869)).setAttribute("src","b.gif" );
      ((Element)v.get(869)).setAttribute("width","25" );
      ((Element)v.get(869)).setAttribute("height","8" );
      ((Element)v.get(868)).appendChild((Element)v.get(869));
      /* Termina nodo:869   */
      /* Termina nodo:868   */

      /* Empieza nodo:870 / Elemento padre: 863   */
      v.add(doc.createElement("td"));
      ((Element)v.get(870)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(870)).setAttribute("valign","bottom" );
      ((Element)v.get(863)).appendChild((Element)v.get(870));

      /* Empieza nodo:871 / Elemento padre: 870   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(871)).setAttribute("nombre","txtFechaSustitucionHasta" );
      ((Element)v.get(871)).setAttribute("group","txtFechaSustitucionHasta" );
      ((Element)v.get(871)).setAttribute("id","datosCampos" );
      ((Element)v.get(871)).setAttribute("max","10" );
      ((Element)v.get(871)).setAttribute("tipo","" );
      ((Element)v.get(871)).setAttribute("onchange","" );
      ((Element)v.get(871)).setAttribute("req","N" );
      ((Element)v.get(871)).setAttribute("size","12" );
      ((Element)v.get(871)).setAttribute("valor","" );
      ((Element)v.get(871)).setAttribute("validacion","" );
      ((Element)v.get(870)).appendChild((Element)v.get(871));
      /* Termina nodo:871   */
      /* Termina nodo:870   */

      /* Empieza nodo:872 / Elemento padre: 863   */
      v.add(doc.createElement("td"));
      ((Element)v.get(872)).setAttribute("width","100%" );
      ((Element)v.get(863)).appendChild((Element)v.get(872));

      /* Empieza nodo:873 / Elemento padre: 872   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(873)).setAttribute("src","b.gif" );
      ((Element)v.get(873)).setAttribute("width","8" );
      ((Element)v.get(873)).setAttribute("height","8" );
      ((Element)v.get(872)).appendChild((Element)v.get(873));
      /* Termina nodo:873   */
      /* Termina nodo:872   */
      /* Termina nodo:863   */

      /* Empieza nodo:874 / Elemento padre: 848   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(848)).appendChild((Element)v.get(874));

      /* Empieza nodo:875 / Elemento padre: 874   */
      v.add(doc.createElement("td"));
      ((Element)v.get(875)).setAttribute("colspan","4" );
      ((Element)v.get(874)).appendChild((Element)v.get(875));

      /* Empieza nodo:876 / Elemento padre: 875   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(876)).setAttribute("src","b.gif" );
      ((Element)v.get(876)).setAttribute("width","8" );
      ((Element)v.get(876)).setAttribute("height","8" );
      ((Element)v.get(875)).appendChild((Element)v.get(876));
      /* Termina nodo:876   */
      /* Termina nodo:875   */
      /* Termina nodo:874   */
      /* Termina nodo:848   */
      /* Termina nodo:847   */
      /* Termina nodo:846   */

      /* Empieza nodo:877 / Elemento padre: 824   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(824)).appendChild((Element)v.get(877));

      /* Empieza nodo:878 / Elemento padre: 877   */
      v.add(doc.createElement("td"));
      ((Element)v.get(877)).appendChild((Element)v.get(878));

      /* Empieza nodo:879 / Elemento padre: 878   */
      v.add(doc.createElement("table"));
      ((Element)v.get(879)).setAttribute("width","688" );
      ((Element)v.get(879)).setAttribute("border","0" );
      ((Element)v.get(879)).setAttribute("align","left" );
      ((Element)v.get(879)).setAttribute("cellspacing","0" );
      ((Element)v.get(879)).setAttribute("cellpadding","0" );
      ((Element)v.get(878)).appendChild((Element)v.get(879));

      /* Empieza nodo:880 / Elemento padre: 879   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(879)).appendChild((Element)v.get(880));

      /* Empieza nodo:881 / Elemento padre: 880   */
      v.add(doc.createElement("td"));
      ((Element)v.get(880)).appendChild((Element)v.get(881));

      /* Empieza nodo:882 / Elemento padre: 881   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(882)).setAttribute("src","b.gif" );
      ((Element)v.get(882)).setAttribute("width","8" );
      ((Element)v.get(882)).setAttribute("height","8" );
      ((Element)v.get(881)).appendChild((Element)v.get(882));
      /* Termina nodo:882   */
      /* Termina nodo:881   */

      /* Empieza nodo:883 / Elemento padre: 880   */
      v.add(doc.createElement("td"));
      ((Element)v.get(880)).appendChild((Element)v.get(883));

      /* Empieza nodo:884 / Elemento padre: 883   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(884)).setAttribute("nombre","lblObservaciones" );
      ((Element)v.get(884)).setAttribute("alto","13" );
      ((Element)v.get(884)).setAttribute("filas","1" );
      ((Element)v.get(884)).setAttribute("valor","" );
      ((Element)v.get(884)).setAttribute("id","datosTitle" );
      ((Element)v.get(884)).setAttribute("cod","169" );
      ((Element)v.get(883)).appendChild((Element)v.get(884));
      /* Termina nodo:884   */
      /* Termina nodo:883   */

      /* Empieza nodo:885 / Elemento padre: 880   */
      v.add(doc.createElement("td"));
      ((Element)v.get(885)).setAttribute("width","100%" );
      ((Element)v.get(880)).appendChild((Element)v.get(885));

      /* Empieza nodo:886 / Elemento padre: 885   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(886)).setAttribute("src","b.gif" );
      ((Element)v.get(886)).setAttribute("width","8" );
      ((Element)v.get(886)).setAttribute("height","8" );
      ((Element)v.get(885)).appendChild((Element)v.get(886));
      /* Termina nodo:886   */
      /* Termina nodo:885   */
      /* Termina nodo:880   */

      /* Empieza nodo:887 / Elemento padre: 879   */
      v.add(doc.createElement("tr"));
   }

   private void getXML3600(Document doc) {
      ((Element)v.get(879)).appendChild((Element)v.get(887));

      /* Empieza nodo:888 / Elemento padre: 887   */
      v.add(doc.createElement("td"));
      ((Element)v.get(887)).appendChild((Element)v.get(888));

      /* Empieza nodo:889 / Elemento padre: 888   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(889)).setAttribute("src","b.gif" );
      ((Element)v.get(889)).setAttribute("width","8" );
      ((Element)v.get(889)).setAttribute("height","8" );
      ((Element)v.get(888)).appendChild((Element)v.get(889));
      /* Termina nodo:889   */
      /* Termina nodo:888   */

      /* Empieza nodo:890 / Elemento padre: 887   */
      v.add(doc.createElement("td"));
      ((Element)v.get(890)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(887)).appendChild((Element)v.get(890));

      /* Empieza nodo:891 / Elemento padre: 890   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(891)).setAttribute("cols","50" );
      ((Element)v.get(891)).setAttribute("id","datosCampos" );
      ((Element)v.get(891)).setAttribute("msjreq","" );
      ((Element)v.get(891)).setAttribute("nombre","areatxtObservaciones" );
      ((Element)v.get(891)).setAttribute("readonly","N" );
      ((Element)v.get(891)).setAttribute("req","N" );
      ((Element)v.get(891)).setAttribute("rows","3" );
      ((Element)v.get(891)).setAttribute("tabindex","2" );
      ((Element)v.get(891)).setAttribute("valor","" );
      ((Element)v.get(891)).setAttribute("max","200" );
      ((Element)v.get(890)).appendChild((Element)v.get(891));
      /* Termina nodo:891   */
      /* Termina nodo:890   */

      /* Empieza nodo:892 / Elemento padre: 887   */
      v.add(doc.createElement("td"));
      ((Element)v.get(892)).setAttribute("width","100%" );
      ((Element)v.get(887)).appendChild((Element)v.get(892));

      /* Empieza nodo:893 / Elemento padre: 892   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(893)).setAttribute("src","b.gif" );
      ((Element)v.get(893)).setAttribute("width","8" );
      ((Element)v.get(893)).setAttribute("height","8" );
      ((Element)v.get(892)).appendChild((Element)v.get(893));
      /* Termina nodo:893   */
      /* Termina nodo:892   */
      /* Termina nodo:887   */

      /* Empieza nodo:894 / Elemento padre: 879   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(879)).appendChild((Element)v.get(894));

      /* Empieza nodo:895 / Elemento padre: 894   */
      v.add(doc.createElement("td"));
      ((Element)v.get(895)).setAttribute("colspan","4" );
      ((Element)v.get(894)).appendChild((Element)v.get(895));

      /* Empieza nodo:896 / Elemento padre: 895   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(896)).setAttribute("src","b.gif" );
      ((Element)v.get(896)).setAttribute("width","8" );
      ((Element)v.get(896)).setAttribute("height","8" );
      ((Element)v.get(895)).appendChild((Element)v.get(896));
      /* Termina nodo:896   */
      /* Termina nodo:895   */
      /* Termina nodo:894   */
      /* Termina nodo:879   */
      /* Termina nodo:878   */
      /* Termina nodo:877   */
      /* Termina nodo:824   */
      /* Termina nodo:821   */
      /* Termina nodo:820   */

      /* Empieza nodo:897 / Elemento padre: 817   */
      v.add(doc.createElement("td"));
      ((Element)v.get(817)).appendChild((Element)v.get(897));

      /* Empieza nodo:898 / Elemento padre: 897   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(898)).setAttribute("src","b.gif" );
      ((Element)v.get(897)).appendChild((Element)v.get(898));
      /* Termina nodo:898   */
      /* Termina nodo:897   */
      /* Termina nodo:817   */

      /* Empieza nodo:899 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(899));

      /* Empieza nodo:900 / Elemento padre: 899   */
      v.add(doc.createElement("td"));
      ((Element)v.get(900)).setAttribute("colspan","4" );
      ((Element)v.get(899)).appendChild((Element)v.get(900));

      /* Empieza nodo:901 / Elemento padre: 900   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(901)).setAttribute("src","b.gif" );
      ((Element)v.get(901)).setAttribute("width","8" );
      ((Element)v.get(901)).setAttribute("height","15" );
      ((Element)v.get(900)).appendChild((Element)v.get(901));
      /* Termina nodo:901   */
      /* Termina nodo:900   */
      /* Termina nodo:899   */

      /* Empieza nodo:902 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(902));

      /* Empieza nodo:903 / Elemento padre: 902   */
      v.add(doc.createElement("td"));
      ((Element)v.get(902)).appendChild((Element)v.get(903));

      /* Empieza nodo:904 / Elemento padre: 903   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(904)).setAttribute("src","b.gif" );
      ((Element)v.get(903)).appendChild((Element)v.get(904));
      /* Termina nodo:904   */
      /* Termina nodo:903   */

      /* Empieza nodo:905 / Elemento padre: 902   */
      v.add(doc.createElement("td"));
      ((Element)v.get(902)).appendChild((Element)v.get(905));

      /* Empieza nodo:906 / Elemento padre: 905   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(905)).appendChild((Element)v.get(906));

      /* Empieza nodo:907 / Elemento padre: 906   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(907)).setAttribute("class","legend" );
      ((Element)v.get(906)).appendChild((Element)v.get(907));

      /* Empieza nodo:908 / Elemento padre: 907   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(908)).setAttribute("nombre","lblDatosNodoDigitacion" );
      ((Element)v.get(908)).setAttribute("alto","13" );
      ((Element)v.get(908)).setAttribute("filas","1" );
      ((Element)v.get(908)).setAttribute("valor","" );
      ((Element)v.get(908)).setAttribute("id","legend" );
      ((Element)v.get(908)).setAttribute("cod","00609" );
      ((Element)v.get(907)).appendChild((Element)v.get(908));
      /* Termina nodo:908   */
      /* Termina nodo:907   */

      /* Empieza nodo:909 / Elemento padre: 906   */
      v.add(doc.createElement("table"));
      ((Element)v.get(909)).setAttribute("width","100%" );
      ((Element)v.get(909)).setAttribute("border","0" );
      ((Element)v.get(909)).setAttribute("align","center" );
      ((Element)v.get(909)).setAttribute("cellspacing","0" );
      ((Element)v.get(909)).setAttribute("cellpadding","0" );
      ((Element)v.get(906)).appendChild((Element)v.get(909));

      /* Empieza nodo:910 / Elemento padre: 909   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(909)).appendChild((Element)v.get(910));

      /* Empieza nodo:911 / Elemento padre: 910   */
      v.add(doc.createElement("td"));
      ((Element)v.get(911)).setAttribute("colspan","4" );
      ((Element)v.get(910)).appendChild((Element)v.get(911));

      /* Empieza nodo:912 / Elemento padre: 911   */
   }

   private void getXML3690(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(912)).setAttribute("src","b.gif" );
      ((Element)v.get(912)).setAttribute("width","8" );
      ((Element)v.get(912)).setAttribute("height","8" );
      ((Element)v.get(911)).appendChild((Element)v.get(912));
      /* Termina nodo:912   */
      /* Termina nodo:911   */
      /* Termina nodo:910   */

      /* Empieza nodo:913 / Elemento padre: 909   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(909)).appendChild((Element)v.get(913));

      /* Empieza nodo:914 / Elemento padre: 913   */
      v.add(doc.createElement("td"));
      ((Element)v.get(913)).appendChild((Element)v.get(914));

      /* Empieza nodo:915 / Elemento padre: 914   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(915)).setAttribute("src","b.gif" );
      ((Element)v.get(915)).setAttribute("width","8" );
      ((Element)v.get(915)).setAttribute("height","8" );
      ((Element)v.get(914)).appendChild((Element)v.get(915));
      /* Termina nodo:915   */
      /* Termina nodo:914   */

      /* Empieza nodo:916 / Elemento padre: 913   */
      v.add(doc.createElement("td"));
      ((Element)v.get(913)).appendChild((Element)v.get(916));

      /* Empieza nodo:917 / Elemento padre: 916   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(917)).setAttribute("nombre","lblIndNDG" );
      ((Element)v.get(917)).setAttribute("alto","13" );
      ((Element)v.get(917)).setAttribute("filas","1" );
      ((Element)v.get(917)).setAttribute("valor","" );
      ((Element)v.get(917)).setAttribute("id","datosTitle" );
      ((Element)v.get(917)).setAttribute("cod","2474" );
      ((Element)v.get(916)).appendChild((Element)v.get(917));
      /* Termina nodo:917   */
      /* Termina nodo:916   */

      /* Empieza nodo:918 / Elemento padre: 913   */
      v.add(doc.createElement("td"));
      ((Element)v.get(913)).appendChild((Element)v.get(918));

      /* Empieza nodo:919 / Elemento padre: 918   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(919)).setAttribute("src","b.gif" );
      ((Element)v.get(919)).setAttribute("width","25" );
      ((Element)v.get(919)).setAttribute("height","8" );
      ((Element)v.get(918)).appendChild((Element)v.get(919));
      /* Termina nodo:919   */
      /* Termina nodo:918   */

      /* Empieza nodo:920 / Elemento padre: 913   */
      v.add(doc.createElement("td"));
      ((Element)v.get(913)).appendChild((Element)v.get(920));

      /* Empieza nodo:921 / Elemento padre: 920   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(921)).setAttribute("nombre","lblAminNDG" );
      ((Element)v.get(921)).setAttribute("alto","13" );
      ((Element)v.get(921)).setAttribute("filas","1" );
      ((Element)v.get(921)).setAttribute("valor","" );
      ((Element)v.get(921)).setAttribute("id","datosTitle" );
      ((Element)v.get(921)).setAttribute("cod","2475" );
      ((Element)v.get(920)).appendChild((Element)v.get(921));
      /* Termina nodo:921   */
      /* Termina nodo:920   */

      /* Empieza nodo:922 / Elemento padre: 913   */
      v.add(doc.createElement("td"));
      ((Element)v.get(922)).setAttribute("width","100%" );
      ((Element)v.get(913)).appendChild((Element)v.get(922));

      /* Empieza nodo:923 / Elemento padre: 922   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(923)).setAttribute("src","b.gif" );
      ((Element)v.get(923)).setAttribute("width","8" );
      ((Element)v.get(923)).setAttribute("height","8" );
      ((Element)v.get(922)).appendChild((Element)v.get(923));
      /* Termina nodo:923   */
      /* Termina nodo:922   */
      /* Termina nodo:913   */

      /* Empieza nodo:924 / Elemento padre: 909   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(909)).appendChild((Element)v.get(924));

      /* Empieza nodo:925 / Elemento padre: 924   */
      v.add(doc.createElement("td"));
      ((Element)v.get(924)).appendChild((Element)v.get(925));

      /* Empieza nodo:926 / Elemento padre: 925   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(926)).setAttribute("src","b.gif" );
      ((Element)v.get(926)).setAttribute("width","8" );
      ((Element)v.get(926)).setAttribute("height","8" );
      ((Element)v.get(925)).appendChild((Element)v.get(926));
      /* Termina nodo:926   */
      /* Termina nodo:925   */

      /* Empieza nodo:927 / Elemento padre: 924   */
      v.add(doc.createElement("td"));
      ((Element)v.get(924)).appendChild((Element)v.get(927));

      /* Empieza nodo:928 / Elemento padre: 927   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(928)).setAttribute("nombre","ckIndNDG" );
      ((Element)v.get(928)).setAttribute("id","datosCampos" );
      ((Element)v.get(928)).setAttribute("onclick","habilita();" );
      ((Element)v.get(928)).setAttribute("check","N" );
      ((Element)v.get(928)).setAttribute("ontab","focalizaSiguiente();" );
      ((Element)v.get(927)).appendChild((Element)v.get(928));
      /* Termina nodo:928   */
      /* Termina nodo:927   */

      /* Empieza nodo:929 / Elemento padre: 924   */
      v.add(doc.createElement("td"));
      ((Element)v.get(924)).appendChild((Element)v.get(929));

      /* Empieza nodo:930 / Elemento padre: 929   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(930)).setAttribute("src","b.gif" );
      ((Element)v.get(930)).setAttribute("width","25" );
      ((Element)v.get(930)).setAttribute("height","8" );
      ((Element)v.get(929)).appendChild((Element)v.get(930));
      /* Termina nodo:930   */
      /* Termina nodo:929   */

      /* Empieza nodo:931 / Elemento padre: 924   */
      v.add(doc.createElement("td"));
      ((Element)v.get(924)).appendChild((Element)v.get(931));

      /* Empieza nodo:932 / Elemento padre: 931   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(932)).setAttribute("nombre","ckAdminNDG" );
      ((Element)v.get(932)).setAttribute("id","datosCampos" );
      ((Element)v.get(932)).setAttribute("onclick","" );
      ((Element)v.get(932)).setAttribute("check","N" );
      ((Element)v.get(932)).setAttribute("ontab","focalizaSiguiente2()" );
      ((Element)v.get(931)).appendChild((Element)v.get(932));
      /* Termina nodo:932   */
      /* Termina nodo:931   */

      /* Empieza nodo:933 / Elemento padre: 924   */
      v.add(doc.createElement("td"));
      ((Element)v.get(933)).setAttribute("width","100%" );
      ((Element)v.get(924)).appendChild((Element)v.get(933));

      /* Empieza nodo:934 / Elemento padre: 933   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(934)).setAttribute("src","b.gif" );
      ((Element)v.get(934)).setAttribute("width","8" );
      ((Element)v.get(934)).setAttribute("height","8" );
   }

   private void getXML3780(Document doc) {
      ((Element)v.get(933)).appendChild((Element)v.get(934));
      /* Termina nodo:934   */
      /* Termina nodo:933   */
      /* Termina nodo:924   */

      /* Empieza nodo:935 / Elemento padre: 909   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(909)).appendChild((Element)v.get(935));

      /* Empieza nodo:936 / Elemento padre: 935   */
      v.add(doc.createElement("td"));
      ((Element)v.get(936)).setAttribute("colspan","4" );
      ((Element)v.get(935)).appendChild((Element)v.get(936));

      /* Empieza nodo:937 / Elemento padre: 936   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(937)).setAttribute("src","b.gif" );
      ((Element)v.get(937)).setAttribute("width","8" );
      ((Element)v.get(937)).setAttribute("height","8" );
      ((Element)v.get(936)).appendChild((Element)v.get(937));
      /* Termina nodo:937   */
      /* Termina nodo:936   */
      /* Termina nodo:935   */
      /* Termina nodo:909   */
      /* Termina nodo:906   */
      /* Termina nodo:905   */
      /* Termina nodo:902   */

      /* Empieza nodo:938 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(938));

      /* Empieza nodo:939 / Elemento padre: 938   */
      v.add(doc.createElement("td"));
      ((Element)v.get(939)).setAttribute("width","12" );
      ((Element)v.get(939)).setAttribute("align","center" );
      ((Element)v.get(938)).appendChild((Element)v.get(939));

      /* Empieza nodo:940 / Elemento padre: 939   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(940)).setAttribute("src","b.gif" );
      ((Element)v.get(940)).setAttribute("width","12" );
      ((Element)v.get(940)).setAttribute("height","12" );
      ((Element)v.get(939)).appendChild((Element)v.get(940));
      /* Termina nodo:940   */
      /* Termina nodo:939   */

      /* Empieza nodo:941 / Elemento padre: 938   */
      v.add(doc.createElement("td"));
      ((Element)v.get(941)).setAttribute("width","756" );
      ((Element)v.get(938)).appendChild((Element)v.get(941));

      /* Empieza nodo:942 / Elemento padre: 941   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(942)).setAttribute("src","b.gif" );
      ((Element)v.get(941)).appendChild((Element)v.get(942));
      /* Termina nodo:942   */
      /* Termina nodo:941   */

      /* Empieza nodo:943 / Elemento padre: 938   */
      v.add(doc.createElement("td"));
      ((Element)v.get(943)).setAttribute("width","12" );
      ((Element)v.get(938)).appendChild((Element)v.get(943));

      /* Empieza nodo:944 / Elemento padre: 943   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(944)).setAttribute("src","b.gif" );
      ((Element)v.get(944)).setAttribute("width","12" );
      ((Element)v.get(944)).setAttribute("height","1" );
      ((Element)v.get(943)).appendChild((Element)v.get(944));
      /* Termina nodo:944   */
      /* Termina nodo:943   */
      /* Termina nodo:938   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:46   */


   }

}

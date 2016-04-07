
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_grupo4_insertar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_grupo4_insertar" );
      ((Element)v.get(0)).setAttribute("cod","0309" );
      ((Element)v.get(0)).setAttribute("titulo","Insertar Clientes" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Insertar Clientes" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","menu_basicas.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","scripts_clientes.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","contenido_grupo4_insertar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r          \r\r\r\r/*****************************************************************************************************************/\r   \r\r "));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(5)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("group","grupo1" );
      ((Element)v.get(8)).setAttribute("name","comboMarca" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","6" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("group","grupo1" );
      ((Element)v.get(9)).setAttribute("name","comboCanal" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","7" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("group","grupo2" );
      ((Element)v.get(10)).setAttribute("name","cbTipoCliente" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","1869" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("group","grupo2" );
      ((Element)v.get(11)).setAttribute("name","cbSubtipoCliente" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","595" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("group","grupo2" );
      ((Element)v.get(12)).setAttribute("name","comboTipoClasificacion" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","756" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("group","grupo2" );
      ((Element)v.get(13)).setAttribute("name","comboClasificacion" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","550" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:7   */
      /* Termina nodo:5   */

      /* Empieza nodo:14 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(14)).setAttribute("nombre","frmInsertarCliente" );
      ((Element)v.get(14)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","accion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","nameComboSelected" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","valueComboSelected" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","nameComboSelectedTipo" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","valueComboSelectedTipo" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","nameComboSelectedSubtipo" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","valueComboSelectedSubtipo" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hFormatoFechaPais" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidPais" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hidFocusPrimerComponente" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hidTipoClienDescripcion" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hPestanya" );
      ((Element)v.get(30)).setAttribute("valor","4" );
      ((Element)v.get(14)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hReentrandoP1" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hReentrandoP2" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hReentrandoP3" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hReentrandoP4" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hI18N" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","elementos" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","cbTipo" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","cbSTipo" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hidCodigoAutomatico" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hidDigitoControl" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hidtextCodCliente" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hidListaIdentificacion" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 14   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","codigoCliente" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","elementosP2" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hidFechaIngreso" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hidtextApellido1" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hidtextApellido2" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hidtextApellidoCasada" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hidtextNombre1" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hidtextNombre2" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hidcbTratamiento" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hidcbTratamientoDesc" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hidrbSexo" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hidcbFormaPago" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hidtextFechaNacimiento" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hidEdad" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","hidtextCodEmpleado" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","hidcbNacionalidad" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hidcbEstadoCivil" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hidtextOcupacion" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","hidtextProfesion" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","hidtextCentroTrabajo" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","hidtextCargoDesempena" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","hidcbNivelEstudios" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","hidtextCentroEstudios" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","hidtextNHijos" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","hidtextNPersonasDependientes" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","hidcbNivelSocioEconomico" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","hidcbCicloVidaFamiliar" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","hidrbDeseaCorrespondencia" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","hidtextImporteIngresoFamiliar" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","hidcbPaisContactado" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","hidtextCodClienteContactado" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","hidcbTipoClienteContactado" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","hidcbCodTipoContactado" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","hidtextFechaContacto" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","hidtextFecha1PedidoContacto" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","hidtextFechaSiguienteContacto" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","hidtxtFechaIngresoActual" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","hidListaVinculo" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","hidListaObservacion" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","hidListaPrefe" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","hidMarcaContacto" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","hidCanalContacto" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","hidPeriodoContacto" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","elementosP3" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","hidListaDirecciones" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 14   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","hidListaComunicacion" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(89)).setAttribute("nombre","hidListaMarca" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(90)).setAttribute("nombre","hidMarcaValor" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(91)).setAttribute("nombre","hidOidClienteCont" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(92)).setAttribute("nombre","usaGeoreferenciador" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(93)).setAttribute("nombre","listaVinculosOid" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(94)).setAttribute("nombre","elementosP4" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(95)).setAttribute("nombre","hidListaTarjetas" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(96)).setAttribute("nombre","hidListaClasificacion" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(97)).setAttribute("nombre","hidListaProbSolu" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(98)).setAttribute("nombre","hidListaPsico" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(99)).setAttribute("nombre","hidSubtipoClasi" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(100)).setAttribute("nombre","elemEliminadosTarjetas" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(101)).setAttribute("nombre","elemEliminadosClasificacion" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(102)).setAttribute("nombre","elemEliminadosProblema" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(103)).setAttribute("nombre","elemEliminadosPsico" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(104)).setAttribute("nombre","hiddenOid" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(105)).setAttribute("nombre","hiddenCodigo" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(106)).setAttribute("nombre","hidPestanya" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(107)).setAttribute("nombre","dtoOid" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(108)).setAttribute("nombre","hidCodigoCliente" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(109)).setAttribute("nombre","hCerrarVentana" );
      ((Element)v.get(109)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(110)).setAttribute("nombre","origen" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(110)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 14   */
      v.add(doc.createElement("table"));
      ((Element)v.get(111)).setAttribute("width","100%" );
      ((Element)v.get(111)).setAttribute("height","100%" );
      ((Element)v.get(111)).setAttribute("border","0" );
      ((Element)v.get(111)).setAttribute("align","center" );
      ((Element)v.get(111)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).setAttribute("cellspacing","0" );
      ((Element)v.get(111)).setAttribute("class","menu4" );
      ((Element)v.get(14)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","12" );
      ((Element)v.get(113)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(113)).setAttribute("class","menu5texto" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","12" );
      ((Element)v.get(114)).setAttribute("height","30" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(115)).setAttribute("class","menu5texto" );
      ((Element)v.get(112)).appendChild((Element)v.get(115));

      /* Elemento padre:115 / Elemento actual: 116   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(115)).appendChild((Text)v.get(116));

      /* Termina nodo Texto:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("width","10" );
      ((Element)v.get(117)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(117)).setAttribute("class","menu5texto" );
      ((Element)v.get(112)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","10" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("width","20" );
      ((Element)v.get(119)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(119)).setAttribute("class","menu5texto" );
      ((Element)v.get(112)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("table"));
      ((Element)v.get(120)).setAttribute("width","75" );
      ((Element)v.get(120)).setAttribute("border","1" );
      ((Element)v.get(120)).setAttribute("align","center" );
      ((Element)v.get(120)).setAttribute("cellpadding","1" );
      ((Element)v.get(120)).setAttribute("cellspacing","0" );
      ((Element)v.get(120)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(121)).setAttribute("align","center" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(123)).setAttribute("id","pes1" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(124)).setAttribute("nombre","lblPes1" );
      ((Element)v.get(124)).setAttribute("alto","13" );
      ((Element)v.get(124)).setAttribute("filas","1" );
      ((Element)v.get(124)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(124)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(124)).setAttribute("cod","00515" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:125 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("width","10" );
      ((Element)v.get(125)).setAttribute("class","menu5texto" );
      ((Element)v.get(112)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","10" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("width","20" );
      ((Element)v.get(127)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(127)).setAttribute("class","menu5texto" );
      ((Element)v.get(112)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("table"));
      ((Element)v.get(128)).setAttribute("width","75" );
      ((Element)v.get(128)).setAttribute("border","1" );
      ((Element)v.get(128)).setAttribute("align","center" );
      ((Element)v.get(128)).setAttribute("cellpadding","1" );
      ((Element)v.get(128)).setAttribute("cellspacing","0" );
      ((Element)v.get(128)).setAttribute("bordercolor","#496A9A" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).setAttribute("align","center" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(131)).setAttribute("nombre","lblPes2" );
      ((Element)v.get(131)).setAttribute("alto","13" );
      ((Element)v.get(131)).setAttribute("filas","1" );
      ((Element)v.get(131)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(131)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(131)).setAttribute("cod","00516" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:132 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("width","10" );
      ((Element)v.get(132)).setAttribute("class","menu5texto" );
      ((Element)v.get(112)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","10" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("width","20" );
      ((Element)v.get(134)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(134)).setAttribute("class","menu5texto" );
      ((Element)v.get(112)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("table"));
      ((Element)v.get(135)).setAttribute("width","75" );
      ((Element)v.get(135)).setAttribute("border","1" );
      ((Element)v.get(135)).setAttribute("align","center" );
      ((Element)v.get(135)).setAttribute("cellpadding","1" );
      ((Element)v.get(135)).setAttribute("cellspacing","0" );
      ((Element)v.get(135)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(136)).setAttribute("align","center" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(138)).setAttribute("id","pes3" );
      ((Element)v.get(138)).setAttribute("onclick","accionP3()" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(139)).setAttribute("nombre","lblPes3" );
      ((Element)v.get(139)).setAttribute("alto","13" );
      ((Element)v.get(139)).setAttribute("filas","1" );
      ((Element)v.get(139)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(139)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(139)).setAttribute("cod","00517" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:140 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("width","10" );
      ((Element)v.get(140)).setAttribute("class","menu5texto" );
      ((Element)v.get(112)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","10" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("width","20" );
      ((Element)v.get(142)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(142)).setAttribute("class","menu5texto" );
      ((Element)v.get(112)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("table"));
      ((Element)v.get(143)).setAttribute("width","75" );
      ((Element)v.get(143)).setAttribute("border","1" );
      ((Element)v.get(143)).setAttribute("align","center" );
      ((Element)v.get(143)).setAttribute("cellpadding","1" );
      ((Element)v.get(143)).setAttribute("cellspacing","0" );
      ((Element)v.get(143)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(143)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(144)).setAttribute("align","center" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(145)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(146)).setAttribute("nombre","lblPes4" );
      ((Element)v.get(146)).setAttribute("alto","13" );
      ((Element)v.get(146)).setAttribute("filas","1" );
      ((Element)v.get(146)).setAttribute("valor","Pestaña 1" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(146)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(146)).setAttribute("cod","00518" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:147 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("width","16" );
      ((Element)v.get(147)).setAttribute("class","menu5texto" );
      ((Element)v.get(112)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","12" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:149 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(149)).setAttribute("nombre","capaEspacio2" );
      ((Element)v.get(14)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("table"));
      ((Element)v.get(150)).setAttribute("width","100%" );
      ((Element)v.get(150)).setAttribute("border","0" );
      ((Element)v.get(150)).setAttribute("cellspacing","0" );
      ((Element)v.get(150)).setAttribute("cellpadding","0" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("width","9" );
      ((Element)v.get(152)).setAttribute("align","center" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","9" );
      ((Element)v.get(153)).setAttribute("height","12" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("width","750" );
      ((Element)v.get(151)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).setAttribute("width","9" );
      ((Element)v.get(151)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","9" );
      ((Element)v.get(157)).setAttribute("height","1" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:151   */

      /* Empieza nodo:158 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(163)).setAttribute("class","legend" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(164)).setAttribute("nombre","lblDatosClasificacion" );
      ((Element)v.get(164)).setAttribute("alto","13" );
      ((Element)v.get(164)).setAttribute("filas","1" );
      ((Element)v.get(164)).setAttribute("valor","" );
      ((Element)v.get(164)).setAttribute("id","legend" );
      ((Element)v.get(164)).setAttribute("cod","00539" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 162   */
      v.add(doc.createElement("table"));
      ((Element)v.get(165)).setAttribute("width","100%" );
      ((Element)v.get(165)).setAttribute("border","0" );
      ((Element)v.get(165)).setAttribute("align","center" );
      ((Element)v.get(165)).setAttribute("cellspacing","0" );
      ((Element)v.get(165)).setAttribute("cellpadding","0" );
      ((Element)v.get(162)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("table"));
      ((Element)v.get(168)).setAttribute("width","642" );
      ((Element)v.get(168)).setAttribute("border","0" );
      ((Element)v.get(168)).setAttribute("align","left" );
      ((Element)v.get(168)).setAttribute("cellspacing","0" );
      ((Element)v.get(168)).setAttribute("cellpadding","0" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).setAttribute("colspan","3" );
   }

   private void getXML720(Document doc) {
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

      /* Empieza nodo:172 / Elemento padre: 168   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(168)).appendChild((Element)v.get(172));

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
      ((Element)v.get(172)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(176)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(176)).setAttribute("alto","13" );
      ((Element)v.get(176)).setAttribute("filas","1" );
      ((Element)v.get(176)).setAttribute("valor","" );
      ((Element)v.get(176)).setAttribute("id","datosTitle" );
      ((Element)v.get(176)).setAttribute("cod","6" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","25" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(180)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(180)).setAttribute("alto","13" );
      ((Element)v.get(180)).setAttribute("filas","1" );
      ((Element)v.get(180)).setAttribute("valor","" );
      ((Element)v.get(180)).setAttribute("id","datosTitle" );
      ((Element)v.get(180)).setAttribute("cod","7" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).setAttribute("width","100%" );
      ((Element)v.get(172)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","8" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:172   */

      /* Empieza nodo:183 / Elemento padre: 168   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(168)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","8" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(183)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(187)).setAttribute("nombre","comboMarca" );
      ((Element)v.get(187)).setAttribute("onshtab","shift_tab('marca');" );
      ((Element)v.get(187)).setAttribute("req","S" );
      ((Element)v.get(187)).setAttribute("multiple","N" );
      ((Element)v.get(187)).setAttribute("size","1" );
      ((Element)v.get(187)).setAttribute("id","datosCampos" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:189 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","25" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(183)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(192)).setAttribute("nombre","comboCanal" );
      ((Element)v.get(192)).setAttribute("req","S" );
      ((Element)v.get(192)).setAttribute("multiple","N" );
      ((Element)v.get(192)).setAttribute("size","1" );
      ((Element)v.get(192)).setAttribute("id","datosCampos" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("ROWSET"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:194 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).setAttribute("width","100%" );
      ((Element)v.get(183)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","8" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:183   */

      /* Empieza nodo:196 / Elemento padre: 168   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(168)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("colspan","4" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","8" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:199 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("table"));
      ((Element)v.get(201)).setAttribute("width","642" );
      ((Element)v.get(201)).setAttribute("border","0" );
      ((Element)v.get(201)).setAttribute("align","left" );
      ((Element)v.get(201)).setAttribute("cellspacing","0" );
      ((Element)v.get(201)).setAttribute("cellpadding","0" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(201)).appendChild((Element)v.get(202));

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
      ((Element)v.get(202)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(206)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(206)).setAttribute("alto","13" );
      ((Element)v.get(206)).setAttribute("filas","1" );
      ((Element)v.get(206)).setAttribute("valor","" );
      ((Element)v.get(206)).setAttribute("id","datosTitle" );
      ((Element)v.get(206)).setAttribute("cod","1869" );
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
      ((Element)v.get(202)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(210)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(210)).setAttribute("alto","13" );
      ((Element)v.get(210)).setAttribute("filas","1" );
      ((Element)v.get(210)).setAttribute("valor","" );
      ((Element)v.get(210)).setAttribute("id","datosTitle" );
      ((Element)v.get(210)).setAttribute("cod","595" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).setAttribute("width","100%" );
      ((Element)v.get(202)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","8" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:202   */

      /* Empieza nodo:213 / Elemento padre: 201   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(201)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","8" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(213)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(217)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(217)).setAttribute("valorinicial","" );
      ((Element)v.get(217)).setAttribute("onchange","onChangeTipo();" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(217)).setAttribute("req","N" );
      ((Element)v.get(217)).setAttribute("multiple","N" );
      ((Element)v.get(217)).setAttribute("size","1" );
      ((Element)v.get(217)).setAttribute("id","datosCampos" );
      ((Element)v.get(217)).setAttribute("textoinicial","" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:219 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","25" );
      ((Element)v.get(220)).setAttribute("height","8" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(213)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(222)).setAttribute("nombre","cbSubtipoCliente" );
      ((Element)v.get(222)).setAttribute("valorinicial","" );
      ((Element)v.get(222)).setAttribute("req","N" );
      ((Element)v.get(222)).setAttribute("onchange","onChangeSubtipo();" );
      ((Element)v.get(222)).setAttribute("multiple","N" );
      ((Element)v.get(222)).setAttribute("size","1" );
      ((Element)v.get(222)).setAttribute("id","datosCampos" );
      ((Element)v.get(222)).setAttribute("textoinicial","" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:224 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("width","100%" );
      ((Element)v.get(213)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:213   */

      /* Empieza nodo:226 / Elemento padre: 201   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(201)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).setAttribute("colspan","4" );
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
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:229 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("table"));
      ((Element)v.get(231)).setAttribute("width","642" );
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
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","8" );
      ((Element)v.get(234)).setAttribute("height","8" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(236)).setAttribute("nombre","lblTipoClasificacion" );
      ((Element)v.get(236)).setAttribute("alto","13" );
      ((Element)v.get(236)).setAttribute("filas","1" );
      ((Element)v.get(236)).setAttribute("valor","" );
      ((Element)v.get(236)).setAttribute("id","datosTitle" );
      ((Element)v.get(236)).setAttribute("cod","756" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","25" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(240)).setAttribute("nombre","lblClasificacion" );
      ((Element)v.get(240)).setAttribute("alto","13" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(240)).setAttribute("filas","1" );
      ((Element)v.get(240)).setAttribute("valor","" );
      ((Element)v.get(240)).setAttribute("id","datosTitle" );
      ((Element)v.get(240)).setAttribute("cod","550" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).setAttribute("width","100%" );
      ((Element)v.get(232)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","8" );
      ((Element)v.get(242)).setAttribute("height","8" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:232   */

      /* Empieza nodo:243 / Elemento padre: 231   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(231)).appendChild((Element)v.get(243));

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
      ((Element)v.get(247)).setAttribute("nombre","comboTipoClasificacion" );
      ((Element)v.get(247)).setAttribute("req","N" );
      ((Element)v.get(247)).setAttribute("multiple","N" );
      ((Element)v.get(247)).setAttribute("size","1" );
      ((Element)v.get(247)).setAttribute("id","datosCampos" );
      ((Element)v.get(247)).setAttribute("onchange","onChangeTipoClasificacion();" );
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

      /* Empieza nodo:251 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(243)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(252)).setAttribute("nombre","comboClasificacion" );
      ((Element)v.get(252)).setAttribute("req","N" );
      ((Element)v.get(252)).setAttribute("multiple","N" );
      ((Element)v.get(252)).setAttribute("size","1" );
      ((Element)v.get(252)).setAttribute("id","datosCampos" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:254 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).setAttribute("width","100%" );
      ((Element)v.get(243)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","8" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:243   */

      /* Empieza nodo:256 / Elemento padre: 231   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(231)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).setAttribute("colspan","4" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","8" );
      ((Element)v.get(258)).setAttribute("height","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:165   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:259 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","9" );
      ((Element)v.get(260)).setAttribute("height","12" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:158   */

      /* Empieza nodo:261 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("table"));
      ((Element)v.get(266)).setAttribute("width","100%" );
      ((Element)v.get(266)).setAttribute("border","0" );
      ((Element)v.get(266)).setAttribute("align","center" );
      ((Element)v.get(266)).setAttribute("cellspacing","0" );
      ((Element)v.get(266)).setAttribute("cellpadding","0" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).setAttribute("class","botonera" );
      ((Element)v.get(268)).setAttribute("width","100%" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(269)).setAttribute("nombre","btnAnadir2" );
      ((Element)v.get(269)).setAttribute("ID","botonContenido" );
      ((Element)v.get(269)).setAttribute("tipo","html" );
      ((Element)v.get(269)).setAttribute("accion","aniadirLinea(2);" );
      ((Element)v.get(269)).setAttribute("estado","false" );
      ((Element)v.get(269)).setAttribute("cod","404" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:270 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","9" );
      ((Element)v.get(271)).setAttribute("height","12" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:261   */

      /* Empieza nodo:272 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).setAttribute("width","9" );
      ((Element)v.get(273)).setAttribute("align","center" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(274)).setAttribute("width","9" );
      ((Element)v.get(274)).setAttribute("height","12" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).setAttribute("width","756" );
      ((Element)v.get(272)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).setAttribute("width","9" );
      ((Element)v.get(272)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).setAttribute("width","9" );
      ((Element)v.get(278)).setAttribute("height","1" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */
      /* Termina nodo:272   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:279 / Elemento padre: 14   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(279)).setAttribute("nombre","listado2" );
      ((Element)v.get(279)).setAttribute("ancho","645" );
      ((Element)v.get(279)).setAttribute("alto","179" );
      ((Element)v.get(279)).setAttribute("x","12" );
      ((Element)v.get(279)).setAttribute("y","232" );
      ((Element)v.get(279)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(279)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(280)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(280)).setAttribute("alto","22" );
      ((Element)v.get(280)).setAttribute("imgFondo","" );
      ((Element)v.get(280)).setAttribute("cod","0059" );
      ((Element)v.get(280)).setAttribute("ID","datosTitle" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 279   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(281)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(281)).setAttribute("alto","22" );
      ((Element)v.get(281)).setAttribute("imgFondo","" );
      ((Element)v.get(279)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 279   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(282)).setAttribute("precarga","S" );
      ((Element)v.get(282)).setAttribute("conROver","S" );
      ((Element)v.get(279)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(283)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(283)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(283)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(283)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 282   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(284)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(284)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(284)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(284)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(282)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 282   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(285)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(285)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(282)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:282   */

      /* Empieza nodo:286 / Elemento padre: 279   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(279)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(287)).setAttribute("borde","1" );
      ((Element)v.get(287)).setAttribute("horizDatos","1" );
      ((Element)v.get(287)).setAttribute("horizCabecera","1" );
      ((Element)v.get(287)).setAttribute("vertical","1" );
      ((Element)v.get(287)).setAttribute("horizTitulo","1" );
      ((Element)v.get(287)).setAttribute("horizBase","1" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 286   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(288)).setAttribute("borde","#999999" );
      ((Element)v.get(288)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(288)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(288)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(288)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(288)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(288)).setAttribute("horizBase","#999999" );
      ((Element)v.get(286)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:286   */

      /* Empieza nodo:289 / Elemento padre: 279   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(289)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(289)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(289)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(289)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(289)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(289)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(279)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(290)).setAttribute("ancho","60" );
      ((Element)v.get(290)).setAttribute("minimizable","S" );
      ((Element)v.get(290)).setAttribute("minimizada","N" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 289   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(291)).setAttribute("ancho","65" );
      ((Element)v.get(291)).setAttribute("minimizable","S" );
      ((Element)v.get(291)).setAttribute("minimizada","N" );
      ((Element)v.get(289)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 289   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("ancho","100" );
      ((Element)v.get(292)).setAttribute("minimizable","S" );
      ((Element)v.get(292)).setAttribute("minimizada","N" );
      ((Element)v.get(289)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 289   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(293)).setAttribute("ancho","100" );
      ((Element)v.get(293)).setAttribute("minimizable","S" );
      ((Element)v.get(293)).setAttribute("minimizada","N" );
      ((Element)v.get(289)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 289   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(294)).setAttribute("ancho","110" );
      ((Element)v.get(294)).setAttribute("minimizable","S" );
      ((Element)v.get(294)).setAttribute("minimizada","N" );
      ((Element)v.get(289)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 289   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(295)).setAttribute("ancho","75" );
      ((Element)v.get(295)).setAttribute("minimizable","S" );
      ((Element)v.get(295)).setAttribute("minimizada","N" );
      ((Element)v.get(289)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 289   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(296)).setAttribute("ancho","60" );
      ((Element)v.get(296)).setAttribute("minimizable","S" );
      ((Element)v.get(296)).setAttribute("minimizada","N" );
      ((Element)v.get(296)).setAttribute("oculta","S" );
      ((Element)v.get(289)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 289   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(297)).setAttribute("ancho","65" );
      ((Element)v.get(297)).setAttribute("minimizable","S" );
      ((Element)v.get(297)).setAttribute("minimizada","N" );
      ((Element)v.get(297)).setAttribute("oculta","S" );
      ((Element)v.get(289)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */

      /* Empieza nodo:298 / Elemento padre: 289   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(298)).setAttribute("ancho","110" );
      ((Element)v.get(298)).setAttribute("minimizable","S" );
      ((Element)v.get(298)).setAttribute("minimizada","N" );
      ((Element)v.get(298)).setAttribute("oculta","S" );
      ((Element)v.get(289)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 289   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(299)).setAttribute("ancho","75" );
      ((Element)v.get(299)).setAttribute("minimizable","S" );
      ((Element)v.get(299)).setAttribute("minimizada","N" );
      ((Element)v.get(299)).setAttribute("oculta","S" );
      ((Element)v.get(289)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 289   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(300)).setAttribute("ancho","110" );
      ((Element)v.get(300)).setAttribute("minimizable","S" );
      ((Element)v.get(300)).setAttribute("minimizada","N" );
      ((Element)v.get(300)).setAttribute("oculta","S" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(289)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 289   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(301)).setAttribute("ancho","75" );
      ((Element)v.get(301)).setAttribute("minimizable","S" );
      ((Element)v.get(301)).setAttribute("minimizada","N" );
      ((Element)v.get(301)).setAttribute("oculta","S" );
      ((Element)v.get(289)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:289   */

      /* Empieza nodo:302 / Elemento padre: 279   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(302)).setAttribute("alto","20" );
      ((Element)v.get(302)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(302)).setAttribute("imgFondo","" );
      ((Element)v.get(302)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(279)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(303)).setAttribute("colFondo","" );
      ((Element)v.get(303)).setAttribute("ID","EstCab" );
      ((Element)v.get(303)).setAttribute("align","center" );
      ((Element)v.get(303)).setAttribute("cod","6" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 302   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(304)).setAttribute("colFondo","" );
      ((Element)v.get(304)).setAttribute("ID","EstCab" );
      ((Element)v.get(304)).setAttribute("align","center" );
      ((Element)v.get(304)).setAttribute("cod","7" );
      ((Element)v.get(302)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 302   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("colFondo","" );
      ((Element)v.get(305)).setAttribute("ID","EstCab" );
      ((Element)v.get(305)).setAttribute("align","center" );
      ((Element)v.get(305)).setAttribute("cod","1869" );
      ((Element)v.get(302)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 302   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(306)).setAttribute("colFondo","" );
      ((Element)v.get(306)).setAttribute("ID","EstCab" );
      ((Element)v.get(306)).setAttribute("align","center" );
      ((Element)v.get(306)).setAttribute("cod","595" );
      ((Element)v.get(302)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 302   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(307)).setAttribute("colFondo","" );
      ((Element)v.get(307)).setAttribute("ID","EstCab" );
      ((Element)v.get(307)).setAttribute("align","center" );
      ((Element)v.get(307)).setAttribute("cod","756" );
      ((Element)v.get(302)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */

      /* Empieza nodo:308 / Elemento padre: 302   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(308)).setAttribute("colFondo","" );
      ((Element)v.get(308)).setAttribute("ID","EstCab" );
      ((Element)v.get(308)).setAttribute("align","center" );
      ((Element)v.get(308)).setAttribute("cod","550" );
      ((Element)v.get(302)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 302   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(309)).setAttribute("colFondo","" );
      ((Element)v.get(309)).setAttribute("ID","EstCab" );
      ((Element)v.get(309)).setAttribute("align","center" );
      ((Element)v.get(302)).appendChild((Element)v.get(309));

      /* Elemento padre:309 / Elemento actual: 310   */
      v.add(doc.createTextNode("oidMarcaClasificacion"));
      ((Element)v.get(309)).appendChild((Text)v.get(310));

      /* Termina nodo Texto:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:311 / Elemento padre: 302   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(311)).setAttribute("colFondo","" );
      ((Element)v.get(311)).setAttribute("ID","EstCab" );
      ((Element)v.get(311)).setAttribute("align","center" );
      ((Element)v.get(302)).appendChild((Element)v.get(311));

      /* Elemento padre:311 / Elemento actual: 312   */
      v.add(doc.createTextNode("oidCanalClasificacion"));
      ((Element)v.get(311)).appendChild((Text)v.get(312));

      /* Termina nodo Texto:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 302   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(313)).setAttribute("colFondo","" );
      ((Element)v.get(313)).setAttribute("ID","EstCab" );
      ((Element)v.get(313)).setAttribute("align","center" );
      ((Element)v.get(302)).appendChild((Element)v.get(313));

      /* Elemento padre:313 / Elemento actual: 314   */
      v.add(doc.createTextNode("oidTipoClasificacion"));
      ((Element)v.get(313)).appendChild((Text)v.get(314));

      /* Termina nodo Texto:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 302   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(315)).setAttribute("colFondo","" );
      ((Element)v.get(315)).setAttribute("ID","EstCab" );
      ((Element)v.get(315)).setAttribute("align","center" );
      ((Element)v.get(302)).appendChild((Element)v.get(315));

      /* Elemento padre:315 / Elemento actual: 316   */
      v.add(doc.createTextNode("oidClasificacion"));
      ((Element)v.get(315)).appendChild((Text)v.get(316));

      /* Termina nodo Texto:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 302   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(317)).setAttribute("colFondo","" );
      ((Element)v.get(317)).setAttribute("ID","EstCab" );
      ((Element)v.get(317)).setAttribute("align","center" );
      ((Element)v.get(302)).appendChild((Element)v.get(317));

      /* Elemento padre:317 / Elemento actual: 318   */
      v.add(doc.createTextNode("oidTipoCliente"));
      ((Element)v.get(317)).appendChild((Text)v.get(318));

      /* Termina nodo Texto:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 302   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(319)).setAttribute("colFondo","" );
      ((Element)v.get(319)).setAttribute("ID","EstCab" );
      ((Element)v.get(319)).setAttribute("align","center" );
      ((Element)v.get(302)).appendChild((Element)v.get(319));

      /* Elemento padre:319 / Elemento actual: 320   */
      v.add(doc.createTextNode("oidSubtipoCliente"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(319)).appendChild((Text)v.get(320));

      /* Termina nodo Texto:320   */
      /* Termina nodo:319   */
      /* Termina nodo:302   */

      /* Empieza nodo:321 / Elemento padre: 279   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(321)).setAttribute("alto","22" );
      ((Element)v.get(321)).setAttribute("accion","" );
      ((Element)v.get(321)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(321)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(321)).setAttribute("maxSel","-1" );
      ((Element)v.get(321)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(321)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(321)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(321)).setAttribute("onLoad","" );
      ((Element)v.get(321)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(279)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(322)).setAttribute("tipo","texto" );
      ((Element)v.get(322)).setAttribute("ID","EstDat" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */

      /* Empieza nodo:323 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(323)).setAttribute("tipo","texto" );
      ((Element)v.get(323)).setAttribute("ID","EstDat2" );
      ((Element)v.get(321)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */

      /* Empieza nodo:324 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(324)).setAttribute("tipo","texto" );
      ((Element)v.get(324)).setAttribute("ID","EstDat" );
      ((Element)v.get(321)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */

      /* Empieza nodo:325 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(325)).setAttribute("tipo","texto" );
      ((Element)v.get(325)).setAttribute("ID","EstDat2" );
      ((Element)v.get(321)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(326)).setAttribute("tipo","texto" );
      ((Element)v.get(326)).setAttribute("ID","EstDat" );
      ((Element)v.get(321)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */

      /* Empieza nodo:327 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(327)).setAttribute("tipo","texto" );
      ((Element)v.get(327)).setAttribute("ID","EstDat2" );
      ((Element)v.get(321)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */

      /* Empieza nodo:328 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(328)).setAttribute("tipo","texto" );
      ((Element)v.get(328)).setAttribute("ID","EstDat" );
      ((Element)v.get(321)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */

      /* Empieza nodo:329 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(329)).setAttribute("tipo","texto" );
      ((Element)v.get(329)).setAttribute("ID","EstDat2" );
      ((Element)v.get(321)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */

      /* Empieza nodo:330 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(330)).setAttribute("tipo","texto" );
      ((Element)v.get(330)).setAttribute("ID","EstDat" );
      ((Element)v.get(321)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */

      /* Empieza nodo:331 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(331)).setAttribute("tipo","texto" );
      ((Element)v.get(331)).setAttribute("ID","EstDat2" );
      ((Element)v.get(321)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */

      /* Empieza nodo:332 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(332)).setAttribute("tipo","texto" );
      ((Element)v.get(332)).setAttribute("ID","EstDat" );
      ((Element)v.get(321)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */

      /* Empieza nodo:333 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(333)).setAttribute("tipo","texto" );
      ((Element)v.get(333)).setAttribute("ID","EstDat2" );
      ((Element)v.get(321)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:321   */

      /* Empieza nodo:334 / Elemento padre: 279   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(279)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */

      /* Empieza nodo:335 / Elemento padre: 279   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(335)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(335)).setAttribute("ancho","645" );
      ((Element)v.get(335)).setAttribute("sep","$" );
      ((Element)v.get(335)).setAttribute("x","12" );
      ((Element)v.get(335)).setAttribute("class","botonera" );
      ((Element)v.get(335)).setAttribute("y","388" );
      ((Element)v.get(335)).setAttribute("control","|" );
      ((Element)v.get(335)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(335)).setAttribute("rowset","" );
      ((Element)v.get(335)).setAttribute("cargainicial","N" );
      ((Element)v.get(279)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:279   */

      /* Empieza nodo:336 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(336)).setAttribute("nombre","Eliminar2" );
      ((Element)v.get(336)).setAttribute("x","13" );
      ((Element)v.get(336)).setAttribute("y","389" );
      ((Element)v.get(336)).setAttribute("ID","botonContenido" );
      ((Element)v.get(336)).setAttribute("tipo","html" );
      ((Element)v.get(336)).setAttribute("estado","false" );
      ((Element)v.get(336)).setAttribute("cod","1254" );
      ((Element)v.get(336)).setAttribute("accion","eliminarLinea(2);" );
      ((Element)v.get(14)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */

      /* Empieza nodo:337 / Elemento padre: 14   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(337)).setAttribute("nombre","listado1" );
      ((Element)v.get(337)).setAttribute("ancho","645" );
      ((Element)v.get(337)).setAttribute("alto","162" );
      ((Element)v.get(337)).setAttribute("x","12" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(337)).setAttribute("y","435" );
      ((Element)v.get(337)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(337)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(338)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(338)).setAttribute("alto","22" );
      ((Element)v.get(338)).setAttribute("imgFondo","" );
      ((Element)v.get(338)).setAttribute("cod","0058" );
      ((Element)v.get(338)).setAttribute("ID","datosTitle" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */

      /* Empieza nodo:339 / Elemento padre: 337   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(339)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(339)).setAttribute("alto","22" );
      ((Element)v.get(339)).setAttribute("imgFondo","" );
      ((Element)v.get(337)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */

      /* Empieza nodo:340 / Elemento padre: 337   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(340)).setAttribute("precarga","S" );
      ((Element)v.get(340)).setAttribute("conROver","S" );
      ((Element)v.get(337)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(341)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(341)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(341)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(341)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */

      /* Empieza nodo:342 / Elemento padre: 340   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(342)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(342)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(342)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(342)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(340)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */

      /* Empieza nodo:343 / Elemento padre: 340   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(343)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(343)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(340)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:340   */

      /* Empieza nodo:344 / Elemento padre: 337   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(337)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(345)).setAttribute("borde","1" );
      ((Element)v.get(345)).setAttribute("horizDatos","1" );
      ((Element)v.get(345)).setAttribute("horizCabecera","1" );
      ((Element)v.get(345)).setAttribute("vertical","1" );
      ((Element)v.get(345)).setAttribute("horizTitulo","1" );
      ((Element)v.get(345)).setAttribute("horizBase","1" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */

      /* Empieza nodo:346 / Elemento padre: 344   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(346)).setAttribute("borde","#999999" );
      ((Element)v.get(346)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(346)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(346)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(346)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(346)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(346)).setAttribute("horizBase","#999999" );
      ((Element)v.get(344)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:344   */

      /* Empieza nodo:347 / Elemento padre: 337   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(347)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(347)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(347)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(347)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(347)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(347)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(337)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(348)).setAttribute("ancho","80" );
      ((Element)v.get(348)).setAttribute("minimizable","S" );
      ((Element)v.get(348)).setAttribute("minimizada","N" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */

      /* Empieza nodo:349 / Elemento padre: 347   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(349)).setAttribute("ancho","95" );
      ((Element)v.get(349)).setAttribute("minimizable","S" );
      ((Element)v.get(349)).setAttribute("minimizada","N" );
      ((Element)v.get(347)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */

      /* Empieza nodo:350 / Elemento padre: 347   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(350)).setAttribute("ancho","215" );
      ((Element)v.get(350)).setAttribute("minimizable","S" );
      ((Element)v.get(350)).setAttribute("minimizada","N" );
      ((Element)v.get(347)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:347   */

      /* Empieza nodo:351 / Elemento padre: 337   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(351)).setAttribute("alto","20" );
      ((Element)v.get(351)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(351)).setAttribute("imgFondo","" );
      ((Element)v.get(351)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(337)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(352)).setAttribute("colFondo","" );
      ((Element)v.get(352)).setAttribute("ID","EstCab" );
      ((Element)v.get(352)).setAttribute("align","center" );
      ((Element)v.get(352)).setAttribute("cod","1130" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */

      /* Empieza nodo:353 / Elemento padre: 351   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(353)).setAttribute("colFondo","" );
      ((Element)v.get(353)).setAttribute("ID","EstCab" );
      ((Element)v.get(353)).setAttribute("align","center" );
      ((Element)v.get(353)).setAttribute("cod","1057" );
      ((Element)v.get(351)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */

      /* Empieza nodo:354 / Elemento padre: 351   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(354)).setAttribute("colFondo","" );
      ((Element)v.get(354)).setAttribute("ID","EstCab" );
      ((Element)v.get(354)).setAttribute("align","center" );
      ((Element)v.get(354)).setAttribute("cod","1075" );
      ((Element)v.get(351)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:351   */

      /* Empieza nodo:355 / Elemento padre: 337   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(355)).setAttribute("alto","22" );
      ((Element)v.get(355)).setAttribute("accion","" );
      ((Element)v.get(355)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(355)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(355)).setAttribute("maxSel","-1" );
      ((Element)v.get(355)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(355)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(355)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(355)).setAttribute("onLoad","" );
      ((Element)v.get(355)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(337)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(356)).setAttribute("tipo","combo" );
      ((Element)v.get(356)).setAttribute("nombre","comboTipoTarjeta" );
      ((Element)v.get(356)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(356)).setAttribute("ID","EstDat" );
      ((Element)v.get(356)).setAttribute("req","S" );
      ((Element)v.get(356)).setAttribute("size","1" );
      ((Element)v.get(356)).setAttribute("multiple","N" );
      ((Element)v.get(356)).setAttribute("onshtab","shift_tab(this.name);" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(358)).setAttribute("tipo","combo" );
      ((Element)v.get(358)).setAttribute("nombre","comboClasesTarjeta" );
      ((Element)v.get(358)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(358)).setAttribute("ID","EstDat2" );
      ((Element)v.get(358)).setAttribute("req","S" );
      ((Element)v.get(358)).setAttribute("size","1" );
      ((Element)v.get(358)).setAttribute("multiple","N" );
      ((Element)v.get(355)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:360 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(360)).setAttribute("tipo","combo" );
      ((Element)v.get(360)).setAttribute("nombre","comboEntidadBancaria" );
      ((Element)v.get(360)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(360)).setAttribute("ID","EstDat" );
      ((Element)v.get(360)).setAttribute("req","S" );
      ((Element)v.get(360)).setAttribute("size","1" );
      ((Element)v.get(360)).setAttribute("multiple","N" );
      ((Element)v.get(355)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */
      /* Termina nodo:355   */

      /* Empieza nodo:362 / Elemento padre: 337   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(337)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */

      /* Empieza nodo:363 / Elemento padre: 337   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(363)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(363)).setAttribute("ancho","645" );
      ((Element)v.get(363)).setAttribute("sep","$" );
      ((Element)v.get(363)).setAttribute("x","12" );
      ((Element)v.get(363)).setAttribute("class","botonera" );
      ((Element)v.get(363)).setAttribute("y","570" );
      ((Element)v.get(363)).setAttribute("control","|" );
      ((Element)v.get(363)).setAttribute("conector","conector_victor" );
      ((Element)v.get(363)).setAttribute("rowset","" );
      ((Element)v.get(363)).setAttribute("cargainicial","N" );
      ((Element)v.get(337)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:337   */

      /* Empieza nodo:364 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(364)).setAttribute("nombre","masDatos1" );
      ((Element)v.get(364)).setAttribute("x","13" );
      ((Element)v.get(364)).setAttribute("y","575" );
      ((Element)v.get(364)).setAttribute("ID","botonContenido" );
      ((Element)v.get(364)).setAttribute("tipo","html" );
      ((Element)v.get(364)).setAttribute("estado","false" );
      ((Element)v.get(364)).setAttribute("cod","404" );
      ((Element)v.get(364)).setAttribute("accion","aniadirLinea(1);" );
      ((Element)v.get(14)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */

      /* Empieza nodo:365 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(365)).setAttribute("nombre","Eliminar1" );
      ((Element)v.get(365)).setAttribute("x","61" );
      ((Element)v.get(365)).setAttribute("y","575" );
      ((Element)v.get(365)).setAttribute("ID","botonContenido" );
      ((Element)v.get(365)).setAttribute("tipo","html" );
      ((Element)v.get(365)).setAttribute("estado","false" );
      ((Element)v.get(365)).setAttribute("cod","1254" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(365)).setAttribute("accion","eliminarLinea(1);" );
      ((Element)v.get(14)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */

      /* Empieza nodo:366 / Elemento padre: 14   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(366)).setAttribute("nombre","listado3" );
      ((Element)v.get(366)).setAttribute("ancho","645" );
      ((Element)v.get(366)).setAttribute("alto","315" );
      ((Element)v.get(366)).setAttribute("x","12" );
      ((Element)v.get(366)).setAttribute("y","621" );
      ((Element)v.get(366)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(366)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(367)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(367)).setAttribute("alto","22" );
      ((Element)v.get(367)).setAttribute("imgFondo","" );
      ((Element)v.get(367)).setAttribute("cod","0060" );
      ((Element)v.get(367)).setAttribute("ID","datosTitle" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */

      /* Empieza nodo:368 / Elemento padre: 366   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(368)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(368)).setAttribute("alto","22" );
      ((Element)v.get(368)).setAttribute("imgFondo","" );
      ((Element)v.get(366)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */

      /* Empieza nodo:369 / Elemento padre: 366   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(369)).setAttribute("precarga","S" );
      ((Element)v.get(369)).setAttribute("conROver","S" );
      ((Element)v.get(366)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(370)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(370)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(370)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(370)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */

      /* Empieza nodo:371 / Elemento padre: 369   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(371)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(371)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(371)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(371)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(369)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */

      /* Empieza nodo:372 / Elemento padre: 369   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(372)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(372)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(369)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:369   */

      /* Empieza nodo:373 / Elemento padre: 366   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(366)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(374)).setAttribute("borde","1" );
      ((Element)v.get(374)).setAttribute("horizDatos","1" );
      ((Element)v.get(374)).setAttribute("horizCabecera","1" );
      ((Element)v.get(374)).setAttribute("vertical","1" );
      ((Element)v.get(374)).setAttribute("horizTitulo","1" );
      ((Element)v.get(374)).setAttribute("horizBase","1" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */

      /* Empieza nodo:375 / Elemento padre: 373   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(375)).setAttribute("borde","#999999" );
      ((Element)v.get(375)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(375)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(375)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(375)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(375)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(375)).setAttribute("horizBase","#999999" );
      ((Element)v.get(373)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:373   */

      /* Empieza nodo:376 / Elemento padre: 366   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(376)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(376)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(376)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(376)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(376)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(376)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(366)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(377)).setAttribute("ancho","97" );
      ((Element)v.get(377)).setAttribute("minimizable","S" );
      ((Element)v.get(377)).setAttribute("minimizada","N" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */

      /* Empieza nodo:378 / Elemento padre: 376   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(378)).setAttribute("ancho","305" );
      ((Element)v.get(378)).setAttribute("minimizable","S" );
      ((Element)v.get(378)).setAttribute("minimizada","N" );
      ((Element)v.get(376)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */

      /* Empieza nodo:379 / Elemento padre: 376   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(379)).setAttribute("ancho","55" );
      ((Element)v.get(379)).setAttribute("minimizable","S" );
      ((Element)v.get(379)).setAttribute("minimizada","N" );
      ((Element)v.get(376)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */

      /* Empieza nodo:380 / Elemento padre: 376   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(380)).setAttribute("ancho","90" );
      ((Element)v.get(380)).setAttribute("minimizable","S" );
      ((Element)v.get(380)).setAttribute("minimizada","N" );
      ((Element)v.get(376)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */

      /* Empieza nodo:381 / Elemento padre: 376   */
   }

   private void getXML1710(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(381)).setAttribute("ancho","305" );
      ((Element)v.get(381)).setAttribute("minimizable","S" );
      ((Element)v.get(381)).setAttribute("minimizada","N" );
      ((Element)v.get(376)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */

      /* Empieza nodo:382 / Elemento padre: 376   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(382)).setAttribute("ancho","305" );
      ((Element)v.get(382)).setAttribute("minimizable","S" );
      ((Element)v.get(382)).setAttribute("minimizada","N" );
      ((Element)v.get(376)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:376   */

      /* Empieza nodo:383 / Elemento padre: 366   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(383)).setAttribute("alto","20" );
      ((Element)v.get(383)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(383)).setAttribute("imgFondo","" );
      ((Element)v.get(383)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(366)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(384)).setAttribute("colFondo","" );
      ((Element)v.get(384)).setAttribute("ID","EstCab" );
      ((Element)v.get(384)).setAttribute("align","center" );
      ((Element)v.get(384)).setAttribute("cod","1128" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */

      /* Empieza nodo:385 / Elemento padre: 383   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(385)).setAttribute("colFondo","" );
      ((Element)v.get(385)).setAttribute("ID","EstCab" );
      ((Element)v.get(385)).setAttribute("align","center" );
      ((Element)v.get(385)).setAttribute("cod","1067" );
      ((Element)v.get(383)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */

      /* Empieza nodo:386 / Elemento padre: 383   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(386)).setAttribute("colFondo","" );
      ((Element)v.get(386)).setAttribute("ID","EstCab" );
      ((Element)v.get(386)).setAttribute("align","center" );
      ((Element)v.get(386)).setAttribute("cod","1123" );
      ((Element)v.get(383)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */

      /* Empieza nodo:387 / Elemento padre: 383   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(387)).setAttribute("colFondo","" );
      ((Element)v.get(387)).setAttribute("ID","EstCab" );
      ((Element)v.get(387)).setAttribute("align","center" );
      ((Element)v.get(387)).setAttribute("cod","1129" );
      ((Element)v.get(383)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */

      /* Empieza nodo:388 / Elemento padre: 383   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(388)).setAttribute("colFondo","" );
      ((Element)v.get(388)).setAttribute("ID","EstCab" );
      ((Element)v.get(388)).setAttribute("align","center" );
      ((Element)v.get(388)).setAttribute("cod","1069" );
      ((Element)v.get(383)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */

      /* Empieza nodo:389 / Elemento padre: 383   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(389)).setAttribute("colFondo","" );
      ((Element)v.get(389)).setAttribute("ID","EstCab" );
      ((Element)v.get(389)).setAttribute("align","center" );
      ((Element)v.get(389)).setAttribute("cod","1096" );
      ((Element)v.get(383)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:383   */

      /* Empieza nodo:390 / Elemento padre: 366   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(390)).setAttribute("alto","22" );
      ((Element)v.get(390)).setAttribute("accion","" );
      ((Element)v.get(390)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(390)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(390)).setAttribute("maxSel","-1" );
      ((Element)v.get(390)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(390)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(390)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(390)).setAttribute("onLoad","" );
      ((Element)v.get(390)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(366)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(391)).setAttribute("tipo","combo" );
      ((Element)v.get(391)).setAttribute("nombre","comboTipoProblema" );
      ((Element)v.get(391)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(391)).setAttribute("ID","EstDat" );
      ((Element)v.get(391)).setAttribute("req","S" );
      ((Element)v.get(391)).setAttribute("size","1" );
      ((Element)v.get(391)).setAttribute("multiple","N" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */

      /* Empieza nodo:393 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(393)).setAttribute("tipo","areatexto" );
      ((Element)v.get(393)).setAttribute("nombre","AreaTxtDescripcionProblema" );
      ((Element)v.get(393)).setAttribute("ID","EstDat2" );
      ((Element)v.get(393)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(393)).setAttribute("rows","3" );
      ((Element)v.get(393)).setAttribute("cols","35" );
      ((Element)v.get(393)).setAttribute("validacion","" );
      ((Element)v.get(390)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */

      /* Empieza nodo:394 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(394)).setAttribute("tipo","checkbox" );
      ((Element)v.get(394)).setAttribute("nombre","cbxSolucion" );
      ((Element)v.get(394)).setAttribute("ID","EstDat" );
      ((Element)v.get(394)).setAttribute("onchange","activarSolucion(FILAEVENTO);" );
      ((Element)v.get(390)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */

      /* Empieza nodo:395 / Elemento padre: 390   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(395)).setAttribute("tipo","combo" );
      ((Element)v.get(395)).setAttribute("nombre","comboTipoSolucion" );
      ((Element)v.get(395)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(395)).setAttribute("ID","EstDat2" );
      ((Element)v.get(395)).setAttribute("req","S" );
      ((Element)v.get(395)).setAttribute("size","1" );
      ((Element)v.get(395)).setAttribute("multiple","N" );
      ((Element)v.get(390)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */

      /* Empieza nodo:397 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(397)).setAttribute("tipo","areatexto" );
      ((Element)v.get(397)).setAttribute("nombre","AreaTxtDescripcionSolucion" );
      ((Element)v.get(397)).setAttribute("ID","EstDat2" );
      ((Element)v.get(397)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(397)).setAttribute("rows","3" );
      ((Element)v.get(397)).setAttribute("cols","35" );
      ((Element)v.get(397)).setAttribute("validacion","" );
      ((Element)v.get(390)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */

      /* Empieza nodo:398 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(398)).setAttribute("tipo","areatexto" );
      ((Element)v.get(398)).setAttribute("nombre","AreaTxtNegocioProducto" );
      ((Element)v.get(398)).setAttribute("ID","EstDat2" );
      ((Element)v.get(398)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(398)).setAttribute("rows","3" );
      ((Element)v.get(398)).setAttribute("cols","35" );
      ((Element)v.get(398)).setAttribute("validacion","" );
      ((Element)v.get(390)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:390   */

      /* Empieza nodo:399 / Elemento padre: 366   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(366)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */

      /* Empieza nodo:400 / Elemento padre: 366   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(400)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(400)).setAttribute("ancho","645" );
      ((Element)v.get(400)).setAttribute("sep","$" );
      ((Element)v.get(400)).setAttribute("x","12" );
      ((Element)v.get(400)).setAttribute("class","botonera" );
      ((Element)v.get(400)).setAttribute("y","914" );
      ((Element)v.get(400)).setAttribute("control","|" );
      ((Element)v.get(400)).setAttribute("conector","conector_victor" );
      ((Element)v.get(400)).setAttribute("rowset","" );
      ((Element)v.get(400)).setAttribute("cargainicial","N" );
      ((Element)v.get(366)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:366   */

      /* Empieza nodo:401 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(401)).setAttribute("nombre","masDatos3" );
      ((Element)v.get(401)).setAttribute("x","13" );
      ((Element)v.get(401)).setAttribute("y","914" );
      ((Element)v.get(401)).setAttribute("ID","botonContenido" );
      ((Element)v.get(401)).setAttribute("tipo","html" );
      ((Element)v.get(401)).setAttribute("estado","false" );
      ((Element)v.get(401)).setAttribute("cod","404" );
      ((Element)v.get(401)).setAttribute("accion","aniadirLinea(3);" );
      ((Element)v.get(14)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */

      /* Empieza nodo:402 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(402)).setAttribute("nombre","Eliminar3" );
      ((Element)v.get(402)).setAttribute("x","61" );
      ((Element)v.get(402)).setAttribute("y","914" );
      ((Element)v.get(402)).setAttribute("ID","botonContenido" );
      ((Element)v.get(402)).setAttribute("tipo","html" );
      ((Element)v.get(402)).setAttribute("estado","false" );
      ((Element)v.get(402)).setAttribute("cod","1254" );
      ((Element)v.get(402)).setAttribute("accion","eliminarLinea(3);" );
      ((Element)v.get(14)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */

      /* Empieza nodo:403 / Elemento padre: 14   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(403)).setAttribute("nombre","listado4" );
      ((Element)v.get(403)).setAttribute("ancho","645" );
      ((Element)v.get(403)).setAttribute("alto","162" );
      ((Element)v.get(403)).setAttribute("x","12" );
      ((Element)v.get(403)).setAttribute("y","960" );
      ((Element)v.get(403)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(403)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(404)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(404)).setAttribute("alto","22" );
      ((Element)v.get(404)).setAttribute("imgFondo","" );
      ((Element)v.get(404)).setAttribute("cod","00155" );
      ((Element)v.get(404)).setAttribute("ID","datosTitle" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */

      /* Empieza nodo:405 / Elemento padre: 403   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(405)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(405)).setAttribute("alto","22" );
      ((Element)v.get(405)).setAttribute("imgFondo","" );
      ((Element)v.get(403)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */

      /* Empieza nodo:406 / Elemento padre: 403   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(406)).setAttribute("precarga","S" );
      ((Element)v.get(406)).setAttribute("conROver","S" );
      ((Element)v.get(403)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(407)).setAttribute("normal","btnLista2N.gif" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(407)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(407)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(407)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */

      /* Empieza nodo:408 / Elemento padre: 406   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(408)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(408)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(408)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(408)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(406)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */

      /* Empieza nodo:409 / Elemento padre: 406   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(409)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(409)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(406)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:406   */

      /* Empieza nodo:410 / Elemento padre: 403   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(403)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(411)).setAttribute("borde","1" );
      ((Element)v.get(411)).setAttribute("horizDatos","1" );
      ((Element)v.get(411)).setAttribute("horizCabecera","1" );
      ((Element)v.get(411)).setAttribute("vertical","1" );
      ((Element)v.get(411)).setAttribute("horizTitulo","1" );
      ((Element)v.get(411)).setAttribute("horizBase","1" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */

      /* Empieza nodo:412 / Elemento padre: 410   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(412)).setAttribute("borde","#999999" );
      ((Element)v.get(412)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(412)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(412)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(412)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(412)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(412)).setAttribute("horizBase","#999999" );
      ((Element)v.get(410)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:410   */

      /* Empieza nodo:413 / Elemento padre: 403   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(413)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(413)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(413)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(413)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(413)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(413)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(403)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(414)).setAttribute("ancho","220" );
      ((Element)v.get(414)).setAttribute("minimizable","S" );
      ((Element)v.get(414)).setAttribute("minimizada","N" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */

      /* Empieza nodo:415 / Elemento padre: 413   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(415)).setAttribute("ancho","77" );
      ((Element)v.get(415)).setAttribute("minimizable","S" );
      ((Element)v.get(415)).setAttribute("minimizada","N" );
      ((Element)v.get(413)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */

      /* Empieza nodo:416 / Elemento padre: 413   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(416)).setAttribute("ancho","77" );
      ((Element)v.get(416)).setAttribute("minimizable","S" );
      ((Element)v.get(416)).setAttribute("minimizada","N" );
      ((Element)v.get(413)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */

      /* Empieza nodo:417 / Elemento padre: 413   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(417)).setAttribute("ancho","77" );
      ((Element)v.get(417)).setAttribute("minimizable","S" );
      ((Element)v.get(417)).setAttribute("minimizada","N" );
      ((Element)v.get(413)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:413   */

      /* Empieza nodo:418 / Elemento padre: 403   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(418)).setAttribute("alto","20" );
      ((Element)v.get(418)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(418)).setAttribute("imgFondo","" );
      ((Element)v.get(418)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(403)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(419)).setAttribute("colFondo","" );
      ((Element)v.get(419)).setAttribute("ID","EstCab" );
      ((Element)v.get(419)).setAttribute("align","center" );
      ((Element)v.get(419)).setAttribute("cod","6" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */

      /* Empieza nodo:420 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(420)).setAttribute("colFondo","" );
      ((Element)v.get(420)).setAttribute("ID","EstCab" );
      ((Element)v.get(420)).setAttribute("align","center" );
      ((Element)v.get(420)).setAttribute("cod","1365" );
      ((Element)v.get(418)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */

      /* Empieza nodo:421 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(421)).setAttribute("colFondo","" );
      ((Element)v.get(421)).setAttribute("ID","EstCab" );
      ((Element)v.get(421)).setAttribute("align","center" );
      ((Element)v.get(421)).setAttribute("cod","1366" );
      ((Element)v.get(418)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */

      /* Empieza nodo:422 / Elemento padre: 418   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(422)).setAttribute("colFondo","" );
      ((Element)v.get(422)).setAttribute("ID","EstCab" );
      ((Element)v.get(422)).setAttribute("align","center" );
      ((Element)v.get(422)).setAttribute("cod","188" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(418)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:418   */

      /* Empieza nodo:423 / Elemento padre: 403   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(423)).setAttribute("alto","22" );
      ((Element)v.get(423)).setAttribute("accion","" );
      ((Element)v.get(423)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(423)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(423)).setAttribute("maxSel","-1" );
      ((Element)v.get(423)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(423)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(423)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(423)).setAttribute("onLoad","" );
      ((Element)v.get(423)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(403)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(424)).setAttribute("tipo","combo" );
      ((Element)v.get(424)).setAttribute("nombre","comboMarcaPsico" );
      ((Element)v.get(424)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(424)).setAttribute("ID","EstDat" );
      ((Element)v.get(424)).setAttribute("req","S" );
      ((Element)v.get(424)).setAttribute("size","1" );
      ((Element)v.get(424)).setAttribute("multiple","N" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:424   */

      /* Empieza nodo:426 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(426)).setAttribute("tipo","combo" );
      ((Element)v.get(426)).setAttribute("nombre","comboTipoPerfil" );
      ((Element)v.get(426)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(426)).setAttribute("ID","EstDat2" );
      ((Element)v.get(426)).setAttribute("req","S" );
      ((Element)v.get(426)).setAttribute("size","1" );
      ((Element)v.get(426)).setAttribute("multiple","N" );
      ((Element)v.get(423)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:428 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(428)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(428)).setAttribute("nombre","TextoCodTest" );
      ((Element)v.get(428)).setAttribute("size","10" );
      ((Element)v.get(428)).setAttribute("max","10" );
      ((Element)v.get(428)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(428)).setAttribute("ID","EstDat" );
      ((Element)v.get(423)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */

      /* Empieza nodo:429 / Elemento padre: 423   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(429)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(429)).setAttribute("nombre","TextoFecha" );
      ((Element)v.get(429)).setAttribute("size","10" );
      ((Element)v.get(429)).setAttribute("max","10" );
      ((Element)v.get(429)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(429)).setAttribute("ID","EstDat2" );
      ((Element)v.get(423)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:423   */

      /* Empieza nodo:430 / Elemento padre: 403   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(403)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */

      /* Empieza nodo:431 / Elemento padre: 403   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(431)).setAttribute("nombre","mipgndo4" );
      ((Element)v.get(431)).setAttribute("ancho","645" );
      ((Element)v.get(431)).setAttribute("sep","$" );
      ((Element)v.get(431)).setAttribute("x","12" );
      ((Element)v.get(431)).setAttribute("class","botonera" );
      ((Element)v.get(431)).setAttribute("y","1101" );
      ((Element)v.get(431)).setAttribute("control","|" );
      ((Element)v.get(431)).setAttribute("conector","conector_victor" );
      ((Element)v.get(431)).setAttribute("rowset","" );
      ((Element)v.get(431)).setAttribute("cargainicial","N" );
      ((Element)v.get(403)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:403   */

      /* Empieza nodo:432 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(432)).setAttribute("nombre","masDatos4" );
      ((Element)v.get(432)).setAttribute("x","13" );
      ((Element)v.get(432)).setAttribute("y","1101" );
      ((Element)v.get(432)).setAttribute("ID","botonContenido" );
      ((Element)v.get(432)).setAttribute("tipo","html" );
      ((Element)v.get(432)).setAttribute("estado","false" );
      ((Element)v.get(432)).setAttribute("cod","404" );
      ((Element)v.get(432)).setAttribute("accion","aniadirLinea(4);" );
      ((Element)v.get(14)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */

      /* Empieza nodo:433 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(433)).setAttribute("nombre","Eliminar4" );
      ((Element)v.get(433)).setAttribute("x","61" );
      ((Element)v.get(433)).setAttribute("y","1101" );
      ((Element)v.get(433)).setAttribute("ID","botonContenido" );
      ((Element)v.get(433)).setAttribute("tipo","html" );
      ((Element)v.get(433)).setAttribute("estado","false" );
      ((Element)v.get(433)).setAttribute("cod","1254" );
      ((Element)v.get(433)).setAttribute("accion","eliminarLinea(4);" );
      ((Element)v.get(14)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */

      /* Empieza nodo:434 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(434)).setAttribute("nombre","capaEspacio3" );
      ((Element)v.get(434)).setAttribute("x","0" );
      ((Element)v.get(434)).setAttribute("y","1123" );
      ((Element)v.get(14)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
   }

   private void getXML2070(Document doc) {
      v.add(doc.createElement("table"));
      ((Element)v.get(435)).setAttribute("width","100%" );
      ((Element)v.get(435)).setAttribute("border","0" );
      ((Element)v.get(435)).setAttribute("cellspacing","0" );
      ((Element)v.get(435)).setAttribute("cellpadding","0" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(435)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(438)).setAttribute("src","b.gif" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:437   */

      /* Empieza nodo:439 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("table"));
      ((Element)v.get(440)).setAttribute("width","100%" );
      ((Element)v.get(440)).setAttribute("border","0" );
      ((Element)v.get(440)).setAttribute("align","center" );
      ((Element)v.get(440)).setAttribute("cellspacing","0" );
      ((Element)v.get(440)).setAttribute("cellpadding","0" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(440)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("td"));
      ((Element)v.get(441)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("table"));
      ((Element)v.get(443)).setAttribute("width","646" );
      ((Element)v.get(443)).setAttribute("border","0" );
      ((Element)v.get(443)).setAttribute("align","left" );
      ((Element)v.get(443)).setAttribute("cellspacing","0" );
      ((Element)v.get(443)).setAttribute("cellpadding","0" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(443)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("td"));
      ((Element)v.get(444)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(446)).setAttribute("src","b.gif" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:445   */
      /* Termina nodo:444   */
      /* Termina nodo:443   */
      /* Termina nodo:442   */
      /* Termina nodo:441   */
      /* Termina nodo:440   */
      /* Termina nodo:439   */

      /* Empieza nodo:447 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(448)).setAttribute("src","b.gif" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */
      /* Termina nodo:447   */
      /* Termina nodo:436   */

      /* Empieza nodo:449 / Elemento padre: 435   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(435)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("td"));
      ((Element)v.get(449)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(451)).setAttribute("src","b.gif" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */

      /* Empieza nodo:452 / Elemento padre: 449   */
      v.add(doc.createElement("td"));
      ((Element)v.get(449)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(452)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("table"));
      ((Element)v.get(454)).setAttribute("width","100%" );
      ((Element)v.get(454)).setAttribute("border","0" );
      ((Element)v.get(454)).setAttribute("align","center" );
      ((Element)v.get(454)).setAttribute("cellspacing","0" );
      ((Element)v.get(454)).setAttribute("cellpadding","0" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(454)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("td"));
      ((Element)v.get(456)).setAttribute("align","right" );
      ((Element)v.get(456)).setAttribute("class","botonera" );
      ((Element)v.get(456)).setAttribute("width","100%" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(457)).setAttribute("nombre","btnAnterior" );
      ((Element)v.get(457)).setAttribute("ID","botonContenido" );
      ((Element)v.get(457)).setAttribute("tipo","html" );
      ((Element)v.get(457)).setAttribute("accion","accionP3();" );
      ((Element)v.get(457)).setAttribute("ontab","focalizarComponente();" );
      ((Element)v.get(457)).setAttribute("estado","false" );
      ((Element)v.get(457)).setAttribute("cod","1649" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */
      /* Termina nodo:456   */
      /* Termina nodo:455   */
      /* Termina nodo:454   */
      /* Termina nodo:453   */
      /* Termina nodo:452   */

      /* Empieza nodo:458 / Elemento padre: 449   */
      v.add(doc.createElement("td"));
      ((Element)v.get(449)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(459)).setAttribute("src","b.gif" );
      ((Element)v.get(459)).setAttribute("width","9" );
      ((Element)v.get(459)).setAttribute("height","12" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:458   */
      /* Termina nodo:449   */

      /* Empieza nodo:460 / Elemento padre: 435   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(435)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).setAttribute("width","12" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(461)).setAttribute("align","center" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(462)).setAttribute("src","b.gif" );
      ((Element)v.get(462)).setAttribute("width","12" );
      ((Element)v.get(462)).setAttribute("height","12" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */
      /* Termina nodo:461   */

      /* Empieza nodo:463 / Elemento padre: 460   */
      v.add(doc.createElement("td"));
      ((Element)v.get(463)).setAttribute("width","756" );
      ((Element)v.get(460)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(464)).setAttribute("src","b.gif" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */
      /* Termina nodo:463   */

      /* Empieza nodo:465 / Elemento padre: 460   */
      v.add(doc.createElement("td"));
      ((Element)v.get(465)).setAttribute("width","12" );
      ((Element)v.get(460)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(466)).setAttribute("src","b.gif" );
      ((Element)v.get(466)).setAttribute("width","12" );
      ((Element)v.get(466)).setAttribute("height","1" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */
      /* Termina nodo:465   */
      /* Termina nodo:460   */
      /* Termina nodo:435   */
      /* Termina nodo:434   */

      /* Empieza nodo:467 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(467)).setAttribute("nombre","capaSubtipo" );
      ((Element)v.get(467)).setAttribute("alto","10" );
      ((Element)v.get(467)).setAttribute("ancho","10" );
      ((Element)v.get(467)).setAttribute("colorf","" );
      ((Element)v.get(467)).setAttribute("borde","1" );
      ((Element)v.get(467)).setAttribute("imagenf","" );
      ((Element)v.get(467)).setAttribute("repeat","" );
      ((Element)v.get(467)).setAttribute("padding","" );
      ((Element)v.get(467)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(467)).setAttribute("contravsb","" );
      ((Element)v.get(467)).setAttribute("zindex","" );
      ((Element)v.get(467)).setAttribute("x","10" );
      ((Element)v.get(467)).setAttribute("y","10" );
      ((Element)v.get(14)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(468)).setAttribute("seleccion","boton" );
      ((Element)v.get(468)).setAttribute("nombre","ListaSubtipo" );
      ((Element)v.get(468)).setAttribute("ancho","582" );
      ((Element)v.get(468)).setAttribute("alto","150" );
      ((Element)v.get(468)).setAttribute("multisel","-1" );
      ((Element)v.get(468)).setAttribute("incy","1" );
      ((Element)v.get(468)).setAttribute("incx","10" );
      ((Element)v.get(468)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(468)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(468)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(468)).setAttribute("accion","" );
      ((Element)v.get(468)).setAttribute("sep","|" );
      ((Element)v.get(468)).setAttribute("pixelsborde","3" );
      ((Element)v.get(468)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(469)).setAttribute("nombre","cabecera" );
      ((Element)v.get(469)).setAttribute("height","20" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(470)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(470)).setAttribute("ancho","13" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */

      /* Empieza nodo:471 / Elemento padre: 469   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(471)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(471)).setAttribute("ancho","300" );
      ((Element)v.get(469)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(472)).setAttribute("nombre","lbDivisionesPoliticas" );
      ((Element)v.get(472)).setAttribute("ancho","300" );
      ((Element)v.get(472)).setAttribute("alto","20" );
      ((Element)v.get(472)).setAttribute("filas","1" );
      ((Element)v.get(472)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(472)).setAttribute("valor","Divisiones Políticas" );
      ((Element)v.get(472)).setAttribute("enviaroculto","N" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:473 / Elemento padre: 469   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(473)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(473)).setAttribute("ancho","150" );
      ((Element)v.get(469)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(474)).setAttribute("nombre","lbPais01" );
      ((Element)v.get(474)).setAttribute("ancho","150" );
      ((Element)v.get(474)).setAttribute("alto","20" );
      ((Element)v.get(474)).setAttribute("filas","1" );
      ((Element)v.get(474)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(474)).setAttribute("valor","País 01" );
      ((Element)v.get(474)).setAttribute("enviaroculto","N" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:473   */
      /* Termina nodo:469   */

      /* Empieza nodo:475 / Elemento padre: 468   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(475)).setAttribute("ancho","10" );
      ((Element)v.get(475)).setAttribute("filas","1" );
      ((Element)v.get(475)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(468)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(476)).setAttribute("ancho","13" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */

      /* Empieza nodo:477 / Elemento padre: 475   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(477)).setAttribute("ancho","300" );
      ((Element)v.get(477)).setAttribute("caracteres","100" );
      ((Element)v.get(475)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */

      /* Empieza nodo:478 / Elemento padre: 475   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(478)).setAttribute("ancho","150" );
      ((Element)v.get(478)).setAttribute("caracteres","30" );
      ((Element)v.get(475)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */
      /* Termina nodo:475   */

      /* Empieza nodo:479 / Elemento padre: 468   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(468)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */
      /* Termina nodo:468   */
      /* Termina nodo:467   */
      /* Termina nodo:14   */

      /* Empieza nodo:480 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(480)).setAttribute("nombre","frmInsertarClienteVolver" );
      ((Element)v.get(0)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(481)).setAttribute("nombre","accion" );
      ((Element)v.get(481)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */

      /* Empieza nodo:482 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(482)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(482)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */

      /* Empieza nodo:483 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(483)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(483)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */

      /* Empieza nodo:484 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(484)).setAttribute("nombre","nameComboSelected" );
      ((Element)v.get(484)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */

      /* Empieza nodo:485 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(485)).setAttribute("nombre","valueComboSelected" );
      ((Element)v.get(485)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */

      /* Empieza nodo:486 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(486)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(486)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */

      /* Empieza nodo:487 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(487)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(487)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */

      /* Empieza nodo:488 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(488)).setAttribute("nombre","hFormatoFechaPais" );
      ((Element)v.get(488)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */

      /* Empieza nodo:489 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(489)).setAttribute("nombre","hidPais" );
      ((Element)v.get(489)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */

      /* Empieza nodo:490 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(490)).setAttribute("nombre","hidFocusPrimerComponente" );
      ((Element)v.get(490)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */

      /* Empieza nodo:491 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(491)).setAttribute("nombre","hidTipoClienDescripcion" );
      ((Element)v.get(491)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */

      /* Empieza nodo:492 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(492)).setAttribute("nombre","hPestanya" );
      ((Element)v.get(492)).setAttribute("valor","4" );
      ((Element)v.get(480)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */

      /* Empieza nodo:493 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(493)).setAttribute("nombre","hReentrandoP1" );
      ((Element)v.get(493)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */

      /* Empieza nodo:494 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(494)).setAttribute("nombre","hReentrandoP2" );
      ((Element)v.get(494)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */

      /* Empieza nodo:495 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(495)).setAttribute("nombre","hReentrandoP3" );
      ((Element)v.get(495)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */

      /* Empieza nodo:496 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(496)).setAttribute("nombre","hReentrandoP4" );
      ((Element)v.get(496)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */

      /* Empieza nodo:497 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(497)).setAttribute("nombre","hI18N" );
      ((Element)v.get(497)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */

      /* Empieza nodo:498 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(498)).setAttribute("nombre","elementos" );
      ((Element)v.get(498)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */

      /* Empieza nodo:499 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(499)).setAttribute("nombre","cbTipo" );
      ((Element)v.get(499)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */

      /* Empieza nodo:500 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(500)).setAttribute("nombre","cbSTipo" );
      ((Element)v.get(500)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */

      /* Empieza nodo:501 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(501)).setAttribute("nombre","hidCodigoAutomatico" );
      ((Element)v.get(501)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */

      /* Empieza nodo:502 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(502)).setAttribute("nombre","hidDigitoControl" );
      ((Element)v.get(502)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */

      /* Empieza nodo:503 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(503)).setAttribute("nombre","hidtextCodCliente" );
      ((Element)v.get(503)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */

      /* Empieza nodo:504 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(504)).setAttribute("nombre","hidListaIdentificacion" );
      ((Element)v.get(504)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */

      /* Empieza nodo:505 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(505)).setAttribute("nombre","elementosP2" );
      ((Element)v.get(505)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */

      /* Empieza nodo:506 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(506)).setAttribute("nombre","hidFechaIngreso" );
      ((Element)v.get(506)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */

      /* Empieza nodo:507 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(507)).setAttribute("nombre","hidtextApellido1" );
      ((Element)v.get(507)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */

      /* Empieza nodo:508 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(508)).setAttribute("nombre","hidtextApellido2" );
      ((Element)v.get(508)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */

      /* Empieza nodo:509 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(509)).setAttribute("nombre","hidtextApellidoCasada" );
      ((Element)v.get(509)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */

      /* Empieza nodo:510 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(510)).setAttribute("nombre","hidtextNombre1" );
      ((Element)v.get(510)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */

      /* Empieza nodo:511 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(511)).setAttribute("nombre","hidtextNombre2" );
      ((Element)v.get(511)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */

      /* Empieza nodo:512 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(512)).setAttribute("nombre","hidcbTratamiento" );
      ((Element)v.get(512)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */

      /* Empieza nodo:513 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(513)).setAttribute("nombre","hidcbTratamientoDesc" );
      ((Element)v.get(513)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */

      /* Empieza nodo:514 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(514)).setAttribute("nombre","hidrbSexo" );
      ((Element)v.get(514)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */

      /* Empieza nodo:515 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(515)).setAttribute("nombre","hidcbFormaPago" );
      ((Element)v.get(515)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */

      /* Empieza nodo:516 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(516)).setAttribute("nombre","hidtextFechaNacimiento" );
      ((Element)v.get(516)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */

      /* Empieza nodo:517 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(517)).setAttribute("nombre","hidEdad" );
      ((Element)v.get(517)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */

      /* Empieza nodo:518 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(518)).setAttribute("nombre","hidtextCodEmpleado" );
      ((Element)v.get(518)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */

      /* Empieza nodo:519 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(519)).setAttribute("nombre","hidcbNacionalidad" );
      ((Element)v.get(519)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */

      /* Empieza nodo:520 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(520)).setAttribute("nombre","hidcbEstadoCivil" );
      ((Element)v.get(520)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */

      /* Empieza nodo:521 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(521)).setAttribute("nombre","hidtextOcupacion" );
      ((Element)v.get(521)).setAttribute("valor","" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(480)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */

      /* Empieza nodo:522 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(522)).setAttribute("nombre","hidtextProfesion" );
      ((Element)v.get(522)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(522));
      /* Termina nodo:522   */

      /* Empieza nodo:523 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(523)).setAttribute("nombre","hidtextCentroTrabajo" );
      ((Element)v.get(523)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */

      /* Empieza nodo:524 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(524)).setAttribute("nombre","hidtextCargoDesempena" );
      ((Element)v.get(524)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */

      /* Empieza nodo:525 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(525)).setAttribute("nombre","hidcbNivelEstudios" );
      ((Element)v.get(525)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */

      /* Empieza nodo:526 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(526)).setAttribute("nombre","hidtextCentroEstudios" );
      ((Element)v.get(526)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */

      /* Empieza nodo:527 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(527)).setAttribute("nombre","hidtextNHijos" );
      ((Element)v.get(527)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */

      /* Empieza nodo:528 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(528)).setAttribute("nombre","hidtextNPersonasDependientes" );
      ((Element)v.get(528)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */

      /* Empieza nodo:529 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(529)).setAttribute("nombre","hidcbNivelSocioEconomico" );
      ((Element)v.get(529)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */

      /* Empieza nodo:530 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(530)).setAttribute("nombre","hidcbCicloVidaFamiliar" );
      ((Element)v.get(530)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */

      /* Empieza nodo:531 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(531)).setAttribute("nombre","hidrbDeseaCorrespondencia" );
      ((Element)v.get(531)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */

      /* Empieza nodo:532 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(532)).setAttribute("nombre","hidtextImporteIngresoFamiliar" );
      ((Element)v.get(532)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */

      /* Empieza nodo:533 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(533)).setAttribute("nombre","hidcbPaisContactado" );
      ((Element)v.get(533)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */

      /* Empieza nodo:534 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(534)).setAttribute("nombre","hidtextCodClienteContactado" );
      ((Element)v.get(534)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */

      /* Empieza nodo:535 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(535)).setAttribute("nombre","hidcbTipoClienteContactado" );
      ((Element)v.get(535)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */

      /* Empieza nodo:536 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(536)).setAttribute("nombre","hidcbCodTipoContactado" );
      ((Element)v.get(536)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */

      /* Empieza nodo:537 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(537)).setAttribute("nombre","hidtextFechaContacto" );
      ((Element)v.get(537)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */

      /* Empieza nodo:538 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(538)).setAttribute("nombre","hidtextFecha1PedidoContacto" );
      ((Element)v.get(538)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */

      /* Empieza nodo:539 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(539)).setAttribute("nombre","hidtextFechaSiguienteContacto" );
      ((Element)v.get(539)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */

      /* Empieza nodo:540 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(540)).setAttribute("nombre","hidtxtFechaIngresoActual" );
      ((Element)v.get(540)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */

      /* Empieza nodo:541 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(541)).setAttribute("nombre","hidListaVinculo" );
      ((Element)v.get(541)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */

      /* Empieza nodo:542 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(542)).setAttribute("nombre","hidListaObservacion" );
      ((Element)v.get(542)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */

      /* Empieza nodo:543 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(543)).setAttribute("nombre","hidListaPrefe" );
      ((Element)v.get(543)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */

      /* Empieza nodo:544 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(544)).setAttribute("nombre","codigoCliente" );
      ((Element)v.get(544)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(544));
      /* Termina nodo:544   */

      /* Empieza nodo:545 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(545)).setAttribute("nombre","hidMarcaContacto" );
      ((Element)v.get(545)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */

      /* Empieza nodo:546 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(546)).setAttribute("nombre","hidCanalContacto" );
      ((Element)v.get(546)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */

      /* Empieza nodo:547 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(547)).setAttribute("nombre","hidPeriodoContacto" );
      ((Element)v.get(547)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */

      /* Empieza nodo:548 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(548)).setAttribute("nombre","elementosP3" );
      ((Element)v.get(548)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */

      /* Empieza nodo:549 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(549)).setAttribute("nombre","hidListaDirecciones" );
      ((Element)v.get(549)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(549));
      /* Termina nodo:549   */

      /* Empieza nodo:550 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(550)).setAttribute("nombre","hidListaComunicacion" );
      ((Element)v.get(550)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(550));
      /* Termina nodo:550   */

      /* Empieza nodo:551 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(551)).setAttribute("nombre","hidListaMarca" );
      ((Element)v.get(551)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(551));
      /* Termina nodo:551   */

      /* Empieza nodo:552 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(552)).setAttribute("nombre","hidMarcaValor" );
      ((Element)v.get(552)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */

      /* Empieza nodo:553 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(553)).setAttribute("nombre","hidOidClienteCont" );
      ((Element)v.get(553)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(553));
      /* Termina nodo:553   */

      /* Empieza nodo:554 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(554)).setAttribute("nombre","usaGeoreferenciador" );
      ((Element)v.get(554)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */

      /* Empieza nodo:555 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(555)).setAttribute("nombre","listaVinculosOid" );
      ((Element)v.get(555)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(555));
      /* Termina nodo:555   */

      /* Empieza nodo:556 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(556)).setAttribute("nombre","elementosP4" );
      ((Element)v.get(556)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */

      /* Empieza nodo:557 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(557)).setAttribute("nombre","hidListaTarjetas" );
      ((Element)v.get(557)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */

      /* Empieza nodo:558 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(558)).setAttribute("nombre","hidListaClasificacion" );
      ((Element)v.get(558)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(558));
      /* Termina nodo:558   */

      /* Empieza nodo:559 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(559)).setAttribute("nombre","hidListaProbSolu" );
      ((Element)v.get(559)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */

      /* Empieza nodo:560 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(560)).setAttribute("nombre","hidListaPsico" );
      ((Element)v.get(560)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(560));
      /* Termina nodo:560   */

      /* Empieza nodo:561 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(561)).setAttribute("nombre","hidSubtipoClasi" );
      ((Element)v.get(561)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */

      /* Empieza nodo:562 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(562)).setAttribute("nombre","elemEliminadosTarjetas" );
      ((Element)v.get(562)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */

      /* Empieza nodo:563 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(563)).setAttribute("nombre","elemEliminadosClasificacion" );
      ((Element)v.get(563)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */

      /* Empieza nodo:564 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(564)).setAttribute("nombre","elemEliminadosProblema" );
      ((Element)v.get(564)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */

      /* Empieza nodo:565 / Elemento padre: 480   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(565)).setAttribute("nombre","elemEliminadosPsico" );
      ((Element)v.get(565)).setAttribute("valor","" );
      ((Element)v.get(480)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */
      /* Termina nodo:480   */


   }

}

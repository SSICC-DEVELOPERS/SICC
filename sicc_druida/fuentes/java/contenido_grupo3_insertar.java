
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_grupo3_insertar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_grupo3_insertar" );
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
      ((Element)v.get(4)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","contenido_grupo3_insertar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(8)).setAttribute("nombre","frmInsertarCliente" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","codigoAutomatico" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","digitoControl" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","nameComboSelected" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","valueComboSelected" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","docPrincipal" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","elementos" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","componente" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","radioStatus" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","back" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","envia" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","atrasTipoSubtipo" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","accion" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","nameComboSelected" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","valueComboSelected" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","ultimoChequeado" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hFormatoFechaPais" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hidPais" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hPestanya" );
      ((Element)v.get(30)).setAttribute("valor","3" );
      ((Element)v.get(8)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hReentrandoP1" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hReentrandoP2" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hReentrandoP3" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hReentrandoP4" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hidFocusPrimerComponente" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hidTipoClienDescripcion" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","cbTipo" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","cbSTipo" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hidCodigoAutomatico" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hidDigitoControl" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hidtextCodCliente" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hidListaIdentificacion" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","codigoCliente" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","elementosP2" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hidFechaIngreso" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 8   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hidtextApellido1" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hidtextApellido2" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hidtextApellidoCasada" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hidtextNombre1" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hidtextNombre2" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hidcbTratamiento" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hidcbTratamientoDesc" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hidrbSexo" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hidcbFormaPago" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hidtextFechaNacimiento" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hidEdad" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","hidtextCodEmpleado" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","hidcbNacionalidad" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hidcbEstadoCivil" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hidtextOcupacion" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","hidtextProfesion" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","hidtextCentroTrabajo" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","hidtextCargoDesempena" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","hidcbNivelEstudios" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","hidtextCentroEstudios" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","hidtextNHijos" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","hidtextNPersonasDependientes" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","hidcbNivelSocioEconomico" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","hidcbCicloVidaFamiliar" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","hidrbDeseaCorrespondencia" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","hidtextImporteIngresoFamiliar" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","hidcbPaisContactado" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","hidtextCodClienteContactado" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","hidcbTipoClienteContactado" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","hidcbCodTipoContactado" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","hidtextFechaContacto" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","hidtextFecha1PedidoContacto" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","hidtextFechaSiguienteContacto" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","hidtxtFechaIngresoActual" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","hidMarcaContacto" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","hidCanalContacto" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","hidPeriodoContacto" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","hidListaVinculo" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","hidListaObservacion" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","hidListaPrefe" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","hOidCliente" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","listaVinculosOid" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","elementosP3" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(89)).setAttribute("nombre","hidListaDirecciones" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(90)).setAttribute("nombre","hidListaComunicacion" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 8   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(91)).setAttribute("nombre","hidListaMarca" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(92)).setAttribute("nombre","hidMarcaValor" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(93)).setAttribute("nombre","hidOidClienteCont" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(94)).setAttribute("nombre","elemToDelDir" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(95)).setAttribute("nombre","elemToDelComm" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(96)).setAttribute("nombre","elemToDelMarcas" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(97)).setAttribute("nombre","hiddenOidVia" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(98)).setAttribute("nombre","valDefTipoDirr" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(99)).setAttribute("nombre","hidOidTerritorio" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(100)).setAttribute("nombre","hidtxtTerritorio" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(101)).setAttribute("nombre","usaGeoreferenciador" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(102)).setAttribute("nombre","elementosP4" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(103)).setAttribute("nombre","hidListaTarjetas" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(104)).setAttribute("nombre","hidListaClasificacion" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(105)).setAttribute("nombre","hidListaProbSolu" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(106)).setAttribute("nombre","hiddenOid" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(107)).setAttribute("nombre","hiddenCodigo" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(108)).setAttribute("nombre","hidPestanya" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(109)).setAttribute("nombre","dtoOid" );
      ((Element)v.get(109)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(110)).setAttribute("nombre","hidCodigoCliente" );
      ((Element)v.get(110)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 8   */
      v.add(doc.createElement("table"));
      ((Element)v.get(111)).setAttribute("width","100%" );
      ((Element)v.get(111)).setAttribute("height","100%" );
      ((Element)v.get(111)).setAttribute("border","0" );
      ((Element)v.get(111)).setAttribute("align","center" );
      ((Element)v.get(111)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).setAttribute("cellspacing","0" );
      ((Element)v.get(111)).setAttribute("class","menu4" );
      ((Element)v.get(8)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
   }

   private void getXML450(Document doc) {
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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(123)).setAttribute("nombre","lblPes1" );
      ((Element)v.get(123)).setAttribute("alto","13" );
      ((Element)v.get(123)).setAttribute("filas","1" );
      ((Element)v.get(123)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(123)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(123)).setAttribute("cod","00515" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:124 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("width","10" );
      ((Element)v.get(124)).setAttribute("class","menu5texto" );
      ((Element)v.get(112)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","10" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("width","20" );
      ((Element)v.get(126)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(126)).setAttribute("class","menu5texto" );
      ((Element)v.get(112)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("table"));
      ((Element)v.get(127)).setAttribute("width","75" );
      ((Element)v.get(127)).setAttribute("border","1" );
      ((Element)v.get(127)).setAttribute("align","center" );
      ((Element)v.get(127)).setAttribute("cellpadding","1" );
      ((Element)v.get(127)).setAttribute("cellspacing","0" );
      ((Element)v.get(127)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(128)).setAttribute("align","center" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(130)).setAttribute("id","pes2" );
      ((Element)v.get(130)).setAttribute("onclick","accionP2();" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(131)).setAttribute("nombre","lblPes2" );
      ((Element)v.get(131)).setAttribute("alto","13" );
      ((Element)v.get(131)).setAttribute("filas","1" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(131)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(131)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(131)).setAttribute("cod","00516" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */

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
      ((Element)v.get(135)).setAttribute("bgcolor","#496A9A" );
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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(138)).setAttribute("nombre","lblPes3" );
      ((Element)v.get(138)).setAttribute("alto","13" );
      ((Element)v.get(138)).setAttribute("filas","1" );
      ((Element)v.get(138)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(138)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(138)).setAttribute("cod","00517" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:139 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("width","10" );
      ((Element)v.get(139)).setAttribute("class","menu5texto" );
      ((Element)v.get(112)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","10" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("width","20" );
      ((Element)v.get(141)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(141)).setAttribute("class","menu5texto" );
      ((Element)v.get(112)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("table"));
      ((Element)v.get(142)).setAttribute("width","75" );
      ((Element)v.get(142)).setAttribute("border","1" );
      ((Element)v.get(142)).setAttribute("align","center" );
      ((Element)v.get(142)).setAttribute("cellpadding","1" );
      ((Element)v.get(142)).setAttribute("cellspacing","0" );
      ((Element)v.get(142)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(143)).setAttribute("align","center" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(144)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(145)).setAttribute("id","pes4" );
      ((Element)v.get(145)).setAttribute("onclick","accionP4();" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(146)).setAttribute("nombre","lblPes4" );
      ((Element)v.get(146)).setAttribute("alto","13" );
      ((Element)v.get(146)).setAttribute("filas","1" );
      ((Element)v.get(146)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(146)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(146)).setAttribute("cod","00518" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */

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
   }

   private void getXML630(Document doc) {
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:149 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(149)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(8)).appendChild((Element)v.get(149));

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
      ((Element)v.get(152)).setAttribute("width","12" );
      ((Element)v.get(152)).setAttribute("align","center" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","12" );
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
      ((Element)v.get(156)).setAttribute("width","12" );
      ((Element)v.get(151)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","12" );
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
      ((Element)v.get(164)).setAttribute("nombre","lblDatosDirecciones" );
      ((Element)v.get(164)).setAttribute("alto","13" );
      ((Element)v.get(164)).setAttribute("filas","1" );
      ((Element)v.get(164)).setAttribute("valor","" );
      ((Element)v.get(164)).setAttribute("id","legend" );
      ((Element)v.get(164)).setAttribute("cod","00430" );
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
      ((Element)v.get(168)).setAttribute("width","515" );
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
   }

   private void getXML720(Document doc) {
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
      ((Element)v.get(176)).setAttribute("nombre","lblTipoDireccion" );
      ((Element)v.get(176)).setAttribute("alto","13" );
      ((Element)v.get(176)).setAttribute("filas","1" );
      ((Element)v.get(176)).setAttribute("valor","" );
      ((Element)v.get(176)).setAttribute("id","datosTitle" );
      ((Element)v.get(176)).setAttribute("cod","159" );
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
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(180)).setAttribute("nombre","capalblTipoVia" );
      ((Element)v.get(180)).setAttribute("alto","100%" );
      ((Element)v.get(180)).setAttribute("ancho","100%" );
      ((Element)v.get(180)).setAttribute("colorf","" );
      ((Element)v.get(180)).setAttribute("borde","0" );
      ((Element)v.get(180)).setAttribute("imagenf","" );
      ((Element)v.get(180)).setAttribute("repeat","" );
      ((Element)v.get(180)).setAttribute("padding","" );
      ((Element)v.get(180)).setAttribute("visibilidad","" );
      ((Element)v.get(180)).setAttribute("contravsb","" );
      ((Element)v.get(180)).setAttribute("position","relative" );
      ((Element)v.get(180)).setAttribute("zindex","" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(181)).setAttribute("nombre","lblTipoVia" );
      ((Element)v.get(181)).setAttribute("alto","13" );
      ((Element)v.get(181)).setAttribute("filas","1" );
      ((Element)v.get(181)).setAttribute("valor","" );
      ((Element)v.get(181)).setAttribute("id","datosTitle" );
      ((Element)v.get(181)).setAttribute("cod","215" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:182 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).setAttribute("width","100%" );
      ((Element)v.get(172)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","8" );
      ((Element)v.get(183)).setAttribute("height","8" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:172   */

      /* Empieza nodo:184 / Elemento padre: 168   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(168)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","8" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(184)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(188)).setAttribute("nombre","comboTipoDireccion" );
      ((Element)v.get(188)).setAttribute("req","S" );
      ((Element)v.get(188)).setAttribute("multiple","N" );
      ((Element)v.get(188)).setAttribute("size","1" );
      ((Element)v.get(188)).setAttribute("id","datosCampos" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:190 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","25" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(184)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(193)).setAttribute("nombre","capaComboTipoVia" );
      ((Element)v.get(193)).setAttribute("alto","100%" );
      ((Element)v.get(193)).setAttribute("ancho","100%" );
      ((Element)v.get(193)).setAttribute("colorf","" );
      ((Element)v.get(193)).setAttribute("borde","0" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(193)).setAttribute("imagenf","" );
      ((Element)v.get(193)).setAttribute("repeat","" );
      ((Element)v.get(193)).setAttribute("padding","" );
      ((Element)v.get(193)).setAttribute("visibilidad","visible" );
      ((Element)v.get(193)).setAttribute("contravsb","" );
      ((Element)v.get(193)).setAttribute("position","relative" );
      ((Element)v.get(193)).setAttribute("zindex","" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(194)).setAttribute("nombre","comboTipoVia" );
      ((Element)v.get(194)).setAttribute("req","S" );
      ((Element)v.get(194)).setAttribute("multiple","N" );
      ((Element)v.get(194)).setAttribute("size","1" );
      ((Element)v.get(194)).setAttribute("id","datosCampos" );
      ((Element)v.get(194)).setAttribute("onchange","TipoViaOnChange();" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:196 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).setAttribute("width","100%" );
      ((Element)v.get(184)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:184   */

      /* Empieza nodo:198 / Elemento padre: 168   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(168)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("colspan","4" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","8" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:201 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("table"));
      ((Element)v.get(203)).setAttribute("width","515" );
      ((Element)v.get(203)).setAttribute("height","41" );
      ((Element)v.get(203)).setAttribute("border","0" );
      ((Element)v.get(203)).setAttribute("align","left" );
      ((Element)v.get(203)).setAttribute("cellspacing","0" );
      ((Element)v.get(203)).setAttribute("cellpadding","0" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(203)).appendChild((Element)v.get(204));

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
      ((Element)v.get(204)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(208)).setAttribute("nombre","capalblNombreVia" );
      ((Element)v.get(208)).setAttribute("alto","100%" );
      ((Element)v.get(208)).setAttribute("ancho","100%" );
      ((Element)v.get(208)).setAttribute("colorf","" );
      ((Element)v.get(208)).setAttribute("borde","0" );
      ((Element)v.get(208)).setAttribute("imagenf","" );
      ((Element)v.get(208)).setAttribute("repeat","" );
      ((Element)v.get(208)).setAttribute("padding","" );
      ((Element)v.get(208)).setAttribute("visibilidad","" );
      ((Element)v.get(208)).setAttribute("contravsb","" );
      ((Element)v.get(208)).setAttribute("position","relative" );
      ((Element)v.get(208)).setAttribute("zindex","" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(209)).setAttribute("nombre","lblNombreVia" );
      ((Element)v.get(209)).setAttribute("alto","13" );
      ((Element)v.get(209)).setAttribute("filas","1" );
      ((Element)v.get(209)).setAttribute("valor","" );
      ((Element)v.get(209)).setAttribute("id","datosTitle" );
      ((Element)v.get(209)).setAttribute("cod","216" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 207   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(210)).setAttribute("nombre","capalblVia" );
      ((Element)v.get(210)).setAttribute("alto","100%" );
      ((Element)v.get(210)).setAttribute("ancho","100%" );
      ((Element)v.get(210)).setAttribute("colorf","" );
      ((Element)v.get(210)).setAttribute("borde","1" );
      ((Element)v.get(210)).setAttribute("imagenf","" );
      ((Element)v.get(210)).setAttribute("repeat","" );
      ((Element)v.get(210)).setAttribute("padding","" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(210)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(210)).setAttribute("contravsb","" );
      ((Element)v.get(210)).setAttribute("position","relative" );
      ((Element)v.get(210)).setAttribute("zindex","" );
      ((Element)v.get(207)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(211)).setAttribute("nombre","lblVia" );
      ((Element)v.get(211)).setAttribute("alto","13" );
      ((Element)v.get(211)).setAttribute("filas","1" );
      ((Element)v.get(211)).setAttribute("valor","" );
      ((Element)v.get(211)).setAttribute("id","datosTitle" );
      ((Element)v.get(211)).setAttribute("cod","2267" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:207   */

      /* Empieza nodo:212 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).setAttribute("width","100%" );
      ((Element)v.get(204)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).setAttribute("width","8" );
      ((Element)v.get(213)).setAttribute("height","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:204   */

      /* Empieza nodo:214 / Elemento padre: 203   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(203)).appendChild((Element)v.get(214));

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
      ((Element)v.get(214)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(218)).setAttribute("nombre","capaTextoNombreVia" );
      ((Element)v.get(218)).setAttribute("alto","100%" );
      ((Element)v.get(218)).setAttribute("ancho","100%" );
      ((Element)v.get(218)).setAttribute("colorf","" );
      ((Element)v.get(218)).setAttribute("borde","0" );
      ((Element)v.get(218)).setAttribute("imagenf","" );
      ((Element)v.get(218)).setAttribute("repeat","" );
      ((Element)v.get(218)).setAttribute("padding","" );
      ((Element)v.get(218)).setAttribute("visibilidad","" );
      ((Element)v.get(218)).setAttribute("contravsb","" );
      ((Element)v.get(218)).setAttribute("position","relative" );
      ((Element)v.get(218)).setAttribute("zindex","" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(219)).setAttribute("nombre","TextoNombreVia" );
      ((Element)v.get(219)).setAttribute("id","datosCampos" );
      ((Element)v.get(219)).setAttribute("max","60" );
      ((Element)v.get(219)).setAttribute("tipo","" );
      ((Element)v.get(219)).setAttribute("onchange","" );
      ((Element)v.get(219)).setAttribute("req","N" );
      ((Element)v.get(219)).setAttribute("size","60" );
      ((Element)v.get(219)).setAttribute("valor","" );
      ((Element)v.get(219)).setAttribute("validacion","" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 217   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(220)).setAttribute("nombre","capaComboVia" );
      ((Element)v.get(220)).setAttribute("alto","100%" );
      ((Element)v.get(220)).setAttribute("ancho","100%" );
      ((Element)v.get(220)).setAttribute("colorf","" );
      ((Element)v.get(220)).setAttribute("borde","0" );
      ((Element)v.get(220)).setAttribute("imagenf","" );
      ((Element)v.get(220)).setAttribute("repeat","" );
      ((Element)v.get(220)).setAttribute("padding","" );
      ((Element)v.get(220)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(220)).setAttribute("contravsb","" );
      ((Element)v.get(220)).setAttribute("position","relative" );
      ((Element)v.get(220)).setAttribute("zindex","" );
      ((Element)v.get(217)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("table"));
      ((Element)v.get(221)).setAttribute("width","515" );
      ((Element)v.get(221)).setAttribute("border","0" );
      ((Element)v.get(221)).setAttribute("align","left" );
      ((Element)v.get(221)).setAttribute("cellspacing","0" );
      ((Element)v.get(221)).setAttribute("cellpadding","0" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(224)).setAttribute("nombre","comboNombreVia" );
      ((Element)v.get(224)).setAttribute("id","datosCampos" );
      ((Element)v.get(224)).setAttribute("max","60" );
      ((Element)v.get(224)).setAttribute("tipo","" );
      ((Element)v.get(224)).setAttribute("onchange","" );
      ((Element)v.get(224)).setAttribute("req","S" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(224)).setAttribute("size","60" );
      ((Element)v.get(224)).setAttribute("valor","" );
      ((Element)v.get(224)).setAttribute("validacion","" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).setAttribute("width","100%" );
      ((Element)v.get(222)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","5" );
      ((Element)v.get(226)).setAttribute("height","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).setAttribute("class","botonera" );
      ((Element)v.get(222)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(228)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(228)).setAttribute("ID","botonContenido" );
      ((Element)v.get(228)).setAttribute("tipo","html" );
      ((Element)v.get(228)).setAttribute("accion","buscarVia();" );
      ((Element)v.get(228)).setAttribute("estado","false" );
      ((Element)v.get(228)).setAttribute("cod","1" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:217   */

      /* Empieza nodo:229 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).setAttribute("width","100%" );
      ((Element)v.get(214)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","9" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:214   */

      /* Empieza nodo:231 / Elemento padre: 203   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(203)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).setAttribute("colspan","4" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","9" );
      ((Element)v.get(233)).setAttribute("height","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:234 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("table"));
      ((Element)v.get(236)).setAttribute("width","515" );
      ((Element)v.get(236)).setAttribute("border","0" );
      ((Element)v.get(236)).setAttribute("align","left" );
      ((Element)v.get(236)).setAttribute("cellspacing","0" );
      ((Element)v.get(236)).setAttribute("cellpadding","0" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(239)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).setAttribute("width","8" );
      ((Element)v.get(239)).setAttribute("height","8" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(241)).setAttribute("nombre","lblNumeroPrincipal" );
      ((Element)v.get(241)).setAttribute("alto","13" );
      ((Element)v.get(241)).setAttribute("filas","1" );
      ((Element)v.get(241)).setAttribute("valor","" );
      ((Element)v.get(241)).setAttribute("id","datosTitle" );
      ((Element)v.get(241)).setAttribute("cod","939" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","25" );
      ((Element)v.get(243)).setAttribute("height","8" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(245)).setAttribute("nombre","lblCodigoPostal" );
      ((Element)v.get(245)).setAttribute("alto","13" );
      ((Element)v.get(245)).setAttribute("filas","1" );
      ((Element)v.get(245)).setAttribute("valor","" );
      ((Element)v.get(245)).setAttribute("id","datosTitle" );
      ((Element)v.get(245)).setAttribute("cod","1344" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","25" );
      ((Element)v.get(247)).setAttribute("height","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(249)).setAttribute("nombre","lblDireccionPrincipal" );
      ((Element)v.get(249)).setAttribute("alto","13" );
      ((Element)v.get(249)).setAttribute("filas","1" );
      ((Element)v.get(249)).setAttribute("valor","" );
      ((Element)v.get(249)).setAttribute("id","datosTitle" );
      ((Element)v.get(249)).setAttribute("cod","1349" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("width","100%" );
      ((Element)v.get(237)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","8" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:237   */

      /* Empieza nodo:252 / Elemento padre: 236   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(236)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","8" );
      ((Element)v.get(254)).setAttribute("height","8" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(252)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(256)).setAttribute("nombre","txtNumeroPrincipal" );
      ((Element)v.get(256)).setAttribute("id","datosCampos" );
      ((Element)v.get(256)).setAttribute("max","6" );
      ((Element)v.get(256)).setAttribute("tipo","" );
      ((Element)v.get(256)).setAttribute("onchange","" );
      ((Element)v.get(256)).setAttribute("req","N" );
      ((Element)v.get(256)).setAttribute("size","6" );
      ((Element)v.get(256)).setAttribute("valor","" );
      ((Element)v.get(256)).setAttribute("validacion","" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","25" );
      ((Element)v.get(258)).setAttribute("height","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(260)).setAttribute("nombre","txtCodigoPostal" );
      ((Element)v.get(260)).setAttribute("id","datosCampos" );
      ((Element)v.get(260)).setAttribute("max","5" );
      ((Element)v.get(260)).setAttribute("tipo","" );
      ((Element)v.get(260)).setAttribute("onchange","" );
      ((Element)v.get(260)).setAttribute("req","N" );
      ((Element)v.get(260)).setAttribute("size","5" );
      ((Element)v.get(260)).setAttribute("valor","" );
      ((Element)v.get(260)).setAttribute("validacion","" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).setAttribute("width","25" );
      ((Element)v.get(262)).setAttribute("height","8" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(264)).setAttribute("nombre","ckDireccionPrincipal" );
      ((Element)v.get(264)).setAttribute("texto","" );
      ((Element)v.get(264)).setAttribute("check","N" );
      ((Element)v.get(264)).setAttribute("validacion","" );
      ((Element)v.get(264)).setAttribute("req","N" );
      ((Element)v.get(264)).setAttribute("id","datosCampos" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).setAttribute("width","100%" );
      ((Element)v.get(252)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","8" );
      ((Element)v.get(266)).setAttribute("height","8" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:252   */

      /* Empieza nodo:267 / Elemento padre: 236   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(236)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).setAttribute("colspan","4" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(269)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).setAttribute("width","8" );
      ((Element)v.get(269)).setAttribute("height","8" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:270 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("table"));
      ((Element)v.get(272)).setAttribute("width","515" );
      ((Element)v.get(272)).setAttribute("border","0" );
      ((Element)v.get(272)).setAttribute("align","left" );
      ((Element)v.get(272)).setAttribute("cellspacing","0" );
      ((Element)v.get(272)).setAttribute("cellpadding","0" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(275)).setAttribute("src","b.gif" );
      ((Element)v.get(275)).setAttribute("width","8" );
      ((Element)v.get(275)).setAttribute("height","8" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:276 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(277)).setAttribute("nombre","lblUnidadesGeograficas" );
      ((Element)v.get(277)).setAttribute("alto","13" );
      ((Element)v.get(277)).setAttribute("filas","1" );
      ((Element)v.get(277)).setAttribute("valor","" );
      ((Element)v.get(277)).setAttribute("id","datosTitle" );
      ((Element)v.get(277)).setAttribute("cod","1137" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(278)).setAttribute("width","100%" );
      ((Element)v.get(273)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).setAttribute("width","8" );
      ((Element)v.get(279)).setAttribute("height","8" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:273   */

      /* Empieza nodo:280 / Elemento padre: 272   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(272)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).setAttribute("width","8" );
      ((Element)v.get(282)).setAttribute("height","8" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(284)).setAttribute("nombre","lblUnidadesGeograficasXX" );
      ((Element)v.get(284)).setAttribute("alto","13" );
      ((Element)v.get(284)).setAttribute("filas","1" );
      ((Element)v.get(284)).setAttribute("valor","" );
      ((Element)v.get(284)).setAttribute("id","datosCampos" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).setAttribute("width","100%" );
      ((Element)v.get(280)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(286)).setAttribute("src","b.gif" );
      ((Element)v.get(286)).setAttribute("width","8" );
      ((Element)v.get(286)).setAttribute("height","8" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:280   */

      /* Empieza nodo:287 / Elemento padre: 272   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(272)).appendChild((Element)v.get(287));

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
      /* Termina nodo:272   */
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:290 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("table"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(292)).setAttribute("width","515" );
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
      ((Element)v.get(297)).setAttribute("nombre","lblObservaciones" );
      ((Element)v.get(297)).setAttribute("alto","13" );
      ((Element)v.get(297)).setAttribute("filas","1" );
      ((Element)v.get(297)).setAttribute("valor","" );
      ((Element)v.get(297)).setAttribute("id","datosTitle" );
      ((Element)v.get(297)).setAttribute("cod","169" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:298 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).setAttribute("width","100%" );
      ((Element)v.get(293)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(299)).setAttribute("src","b.gif" );
      ((Element)v.get(299)).setAttribute("width","8" );
      ((Element)v.get(299)).setAttribute("height","8" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:293   */

      /* Empieza nodo:300 / Elemento padre: 292   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(292)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","8" );
      ((Element)v.get(302)).setAttribute("height","8" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(304)).setAttribute("nombre","areatxtObservaciones" );
      ((Element)v.get(304)).setAttribute("id","datosCampos" );
      ((Element)v.get(304)).setAttribute("cols","50" );
      ((Element)v.get(304)).setAttribute("rows","3" );
      ((Element)v.get(304)).setAttribute("msjreq","" );
      ((Element)v.get(304)).setAttribute("readonly","N" );
      ((Element)v.get(304)).setAttribute("req","N" );
      ((Element)v.get(304)).setAttribute("tabindex","2" );
      ((Element)v.get(304)).setAttribute("valor","" );
      ((Element)v.get(304)).setAttribute("max","100" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).setAttribute("width","100%" );
      ((Element)v.get(300)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","8" );
      ((Element)v.get(306)).setAttribute("height","8" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */
      /* Termina nodo:300   */

      /* Empieza nodo:307 / Elemento padre: 292   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(292)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).setAttribute("colspan","4" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","8" );
      ((Element)v.get(309)).setAttribute("height","8" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:292   */
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:165   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:310 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","12" );
      ((Element)v.get(311)).setAttribute("height","12" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */
      /* Termina nodo:158   */

      /* Empieza nodo:312 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(314)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(315)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("table"));
      ((Element)v.get(317)).setAttribute("width","100%" );
      ((Element)v.get(317)).setAttribute("border","0" );
      ((Element)v.get(317)).setAttribute("align","center" );
      ((Element)v.get(317)).setAttribute("cellspacing","0" );
      ((Element)v.get(317)).setAttribute("cellpadding","0" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).setAttribute("class","botonera" );
      ((Element)v.get(319)).setAttribute("width","100%" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(320)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(320)).setAttribute("ID","botonContenido" );
      ((Element)v.get(320)).setAttribute("tipo","html" );
      ((Element)v.get(320)).setAttribute("accion","aniadirLinea(1);" );
      ((Element)v.get(320)).setAttribute("estado","false" );
      ((Element)v.get(320)).setAttribute("cod","404" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 319   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(321)).setAttribute("nombre","SeleccionarUnidadesGeograficas" );
      ((Element)v.get(321)).setAttribute("ID","botonContenido" );
      ((Element)v.get(321)).setAttribute("tipo","html" );
      ((Element)v.get(321)).setAttribute("accion","seleccionarTerritorioLinea();" );
      ((Element)v.get(321)).setAttribute("estado","false" );
      ((Element)v.get(321)).setAttribute("cod","2266" );
      ((Element)v.get(319)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:319   */
      /* Termina nodo:318   */
      /* Termina nodo:317   */
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:322 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","12" );
      ((Element)v.get(323)).setAttribute("height","12" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */
      /* Termina nodo:312   */

      /* Empieza nodo:324 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("td"));
      ((Element)v.get(325)).setAttribute("width","12" );
      ((Element)v.get(325)).setAttribute("align","center" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(326)).setAttribute("src","b.gif" );
      ((Element)v.get(326)).setAttribute("width","12" );
      ((Element)v.get(326)).setAttribute("height","12" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:327 / Elemento padre: 324   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).setAttribute("width","756" );
      ((Element)v.get(324)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 324   */
      v.add(doc.createElement("td"));
      ((Element)v.get(329)).setAttribute("width","12" );
      ((Element)v.get(324)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(330)).setAttribute("width","12" );
      ((Element)v.get(330)).setAttribute("height","1" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */
      /* Termina nodo:324   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:331 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(331)).setAttribute("nombre","listado1" );
      ((Element)v.get(331)).setAttribute("ancho","518" );
      ((Element)v.get(331)).setAttribute("alto","179" );
      ((Element)v.get(331)).setAttribute("x","12" );
      ((Element)v.get(331)).setAttribute("y","343" );
      ((Element)v.get(331)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(331)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(332)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(332)).setAttribute("alto","22" );
      ((Element)v.get(332)).setAttribute("imgFondo","" );
      ((Element)v.get(332)).setAttribute("cod","00143" );
      ((Element)v.get(332)).setAttribute("ID","datosTitle" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */

      /* Empieza nodo:333 / Elemento padre: 331   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(333)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(333)).setAttribute("alto","22" );
      ((Element)v.get(333)).setAttribute("imgFondo","" );
      ((Element)v.get(331)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */

      /* Empieza nodo:334 / Elemento padre: 331   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(334)).setAttribute("precarga","S" );
      ((Element)v.get(334)).setAttribute("conROver","S" );
      ((Element)v.get(331)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(335)).setAttribute("normal","btnLista2N.gif" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(335)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(335)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(335)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */

      /* Empieza nodo:336 / Elemento padre: 334   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(336)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(336)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(336)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(336)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(334)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */

      /* Empieza nodo:337 / Elemento padre: 334   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(337)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(337)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(334)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:334   */

      /* Empieza nodo:338 / Elemento padre: 331   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(331)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(339)).setAttribute("borde","1" );
      ((Element)v.get(339)).setAttribute("horizDatos","1" );
      ((Element)v.get(339)).setAttribute("horizCabecera","1" );
      ((Element)v.get(339)).setAttribute("vertical","1" );
      ((Element)v.get(339)).setAttribute("horizTitulo","1" );
      ((Element)v.get(339)).setAttribute("horizBase","1" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */

      /* Empieza nodo:340 / Elemento padre: 338   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(340)).setAttribute("borde","#999999" );
      ((Element)v.get(340)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(340)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(340)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(340)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(340)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(340)).setAttribute("horizBase","#999999" );
      ((Element)v.get(338)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:338   */

      /* Empieza nodo:341 / Elemento padre: 331   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(341)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(341)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(341)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(341)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(341)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(341)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(331)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(342)).setAttribute("ancho","200" );
      ((Element)v.get(342)).setAttribute("minimizable","S" );
      ((Element)v.get(342)).setAttribute("minimizada","N" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */

      /* Empieza nodo:343 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(343)).setAttribute("ancho","90" );
      ((Element)v.get(343)).setAttribute("minimizable","S" );
      ((Element)v.get(343)).setAttribute("minimizada","N" );
      ((Element)v.get(341)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */

      /* Empieza nodo:344 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(344)).setAttribute("ancho","61" );
      ((Element)v.get(344)).setAttribute("minimizable","S" );
      ((Element)v.get(344)).setAttribute("minimizada","N" );
      ((Element)v.get(341)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */

      /* Empieza nodo:345 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(345)).setAttribute("ancho","215" );
      ((Element)v.get(345)).setAttribute("minimizable","S" );
      ((Element)v.get(345)).setAttribute("minimizada","N" );
      ((Element)v.get(341)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */

      /* Empieza nodo:346 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(346)).setAttribute("ancho","73" );
      ((Element)v.get(346)).setAttribute("minimizable","S" );
      ((Element)v.get(346)).setAttribute("minimizada","N" );
      ((Element)v.get(341)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */

      /* Empieza nodo:347 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(347)).setAttribute("ancho","72" );
      ((Element)v.get(347)).setAttribute("minimizable","S" );
      ((Element)v.get(347)).setAttribute("minimizada","N" );
      ((Element)v.get(341)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */

      /* Empieza nodo:348 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(348)).setAttribute("ancho","100" );
      ((Element)v.get(348)).setAttribute("minimizable","S" );
      ((Element)v.get(348)).setAttribute("minimizada","N" );
      ((Element)v.get(341)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */

      /* Empieza nodo:349 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(349)).setAttribute("ancho","115" );
      ((Element)v.get(349)).setAttribute("minimizable","S" );
      ((Element)v.get(349)).setAttribute("minimizada","N" );
      ((Element)v.get(341)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */

      /* Empieza nodo:350 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(350)).setAttribute("ancho","115" );
      ((Element)v.get(350)).setAttribute("minimizable","S" );
      ((Element)v.get(350)).setAttribute("minimizada","N" );
      ((Element)v.get(341)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */

      /* Empieza nodo:351 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(351)).setAttribute("ancho","60" );
      ((Element)v.get(351)).setAttribute("minimizable","S" );
      ((Element)v.get(351)).setAttribute("minimizada","N" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(351)).setAttribute("oculta","S" );
      ((Element)v.get(341)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */

      /* Empieza nodo:352 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(352)).setAttribute("ancho","60" );
      ((Element)v.get(352)).setAttribute("minimizable","S" );
      ((Element)v.get(352)).setAttribute("minimizada","N" );
      ((Element)v.get(352)).setAttribute("oculta","S" );
      ((Element)v.get(341)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */

      /* Empieza nodo:353 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(353)).setAttribute("ancho","315" );
      ((Element)v.get(353)).setAttribute("minimizable","S" );
      ((Element)v.get(353)).setAttribute("minimizada","N" );
      ((Element)v.get(353)).setAttribute("oculta","S" );
      ((Element)v.get(341)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */

      /* Empieza nodo:354 / Elemento padre: 341   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(354)).setAttribute("ancho","115" );
      ((Element)v.get(354)).setAttribute("minimizable","S" );
      ((Element)v.get(354)).setAttribute("minimizada","N" );
      ((Element)v.get(354)).setAttribute("oculta","S" );
      ((Element)v.get(341)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:341   */

      /* Empieza nodo:355 / Elemento padre: 331   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(355)).setAttribute("alto","20" );
      ((Element)v.get(355)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(355)).setAttribute("imgFondo","" );
      ((Element)v.get(355)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(331)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(356)).setAttribute("colFondo","" );
      ((Element)v.get(356)).setAttribute("ID","EstCab" );
      ((Element)v.get(356)).setAttribute("align","center" );
      ((Element)v.get(356)).setAttribute("cod","1137" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */

      /* Empieza nodo:357 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(357)).setAttribute("colFondo","" );
      ((Element)v.get(357)).setAttribute("ID","EstCab" );
      ((Element)v.get(357)).setAttribute("align","center" );
      ((Element)v.get(357)).setAttribute("cod","159" );
      ((Element)v.get(355)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */

      /* Empieza nodo:358 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(358)).setAttribute("colFondo","" );
      ((Element)v.get(358)).setAttribute("ID","EstCab" );
      ((Element)v.get(358)).setAttribute("align","center" );
      ((Element)v.get(358)).setAttribute("cod","215" );
      ((Element)v.get(355)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(359)).setAttribute("colFondo","" );
      ((Element)v.get(359)).setAttribute("ID","EstCab" );
      ((Element)v.get(359)).setAttribute("align","center" );
      ((Element)v.get(359)).setAttribute("cod","216" );
      ((Element)v.get(355)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(360)).setAttribute("colFondo","" );
      ((Element)v.get(360)).setAttribute("ID","EstCab" );
      ((Element)v.get(360)).setAttribute("align","center" );
      ((Element)v.get(360)).setAttribute("cod","2267" );
      ((Element)v.get(355)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */

      /* Empieza nodo:361 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(361)).setAttribute("colFondo","" );
      ((Element)v.get(361)).setAttribute("ID","EstCab" );
      ((Element)v.get(361)).setAttribute("align","center" );
      ((Element)v.get(361)).setAttribute("cod","939" );
      ((Element)v.get(355)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(362)).setAttribute("colFondo","" );
      ((Element)v.get(362)).setAttribute("ID","EstCab" );
      ((Element)v.get(362)).setAttribute("align","center" );
      ((Element)v.get(362)).setAttribute("cod","1344" );
      ((Element)v.get(355)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */

      /* Empieza nodo:363 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(363)).setAttribute("colFondo","" );
      ((Element)v.get(363)).setAttribute("ID","EstCab" );
      ((Element)v.get(363)).setAttribute("align","center" );
      ((Element)v.get(363)).setAttribute("cod","169" );
      ((Element)v.get(355)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */

      /* Empieza nodo:364 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(364)).setAttribute("colFondo","" );
      ((Element)v.get(364)).setAttribute("ID","EstCab" );
      ((Element)v.get(364)).setAttribute("align","center" );
      ((Element)v.get(364)).setAttribute("cod","1349" );
      ((Element)v.get(355)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */

      /* Empieza nodo:365 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(365)).setAttribute("colFondo","" );
      ((Element)v.get(365)).setAttribute("ID","EstCab" );
      ((Element)v.get(365)).setAttribute("align","center" );
      ((Element)v.get(355)).appendChild((Element)v.get(365));

      /* Elemento padre:365 / Elemento actual: 366   */
      v.add(doc.createTextNode("oidUnidadGeografica"));
      ((Element)v.get(365)).appendChild((Text)v.get(366));

      /* Termina nodo Texto:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:367 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(367)).setAttribute("colFondo","" );
      ((Element)v.get(367)).setAttribute("ID","EstCab" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(367)).setAttribute("align","center" );
      ((Element)v.get(355)).appendChild((Element)v.get(367));

      /* Elemento padre:367 / Elemento actual: 368   */
      v.add(doc.createTextNode("oidVia"));
      ((Element)v.get(367)).appendChild((Text)v.get(368));

      /* Termina nodo Texto:368   */
      /* Termina nodo:367   */

      /* Empieza nodo:369 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(369)).setAttribute("colFondo","" );
      ((Element)v.get(369)).setAttribute("ID","EstCab" );
      ((Element)v.get(369)).setAttribute("align","center" );
      ((Element)v.get(355)).appendChild((Element)v.get(369));

      /* Elemento padre:369 / Elemento actual: 370   */
      v.add(doc.createTextNode("oidTipoVia"));
      ((Element)v.get(369)).appendChild((Text)v.get(370));

      /* Termina nodo Texto:370   */
      /* Termina nodo:369   */

      /* Empieza nodo:371 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(371)).setAttribute("colFondo","" );
      ((Element)v.get(371)).setAttribute("ID","EstCab" );
      ((Element)v.get(371)).setAttribute("align","center" );
      ((Element)v.get(355)).appendChild((Element)v.get(371));

      /* Elemento padre:371 / Elemento actual: 372   */
      v.add(doc.createTextNode("oidTipoDireccion"));
      ((Element)v.get(371)).appendChild((Text)v.get(372));

      /* Termina nodo Texto:372   */
      /* Termina nodo:371   */
      /* Termina nodo:355   */

      /* Empieza nodo:373 / Elemento padre: 331   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(373)).setAttribute("alto","22" );
      ((Element)v.get(373)).setAttribute("accion","" );
      ((Element)v.get(373)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(373)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(373)).setAttribute("maxSel","-1" );
      ((Element)v.get(373)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(373)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(373)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(373)).setAttribute("onLoad","" );
      ((Element)v.get(373)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(331)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(374)).setAttribute("tipo","texto" );
      ((Element)v.get(374)).setAttribute("ID","EstDat" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */

      /* Empieza nodo:375 / Elemento padre: 373   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(375)).setAttribute("tipo","texto" );
      ((Element)v.get(375)).setAttribute("ID","EstDat2" );
      ((Element)v.get(373)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */

      /* Empieza nodo:376 / Elemento padre: 373   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(376)).setAttribute("tipo","texto" );
      ((Element)v.get(376)).setAttribute("ID","EstDat" );
      ((Element)v.get(373)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */

      /* Empieza nodo:377 / Elemento padre: 373   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(377)).setAttribute("tipo","texto" );
      ((Element)v.get(377)).setAttribute("ID","EstDat2" );
      ((Element)v.get(373)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */

      /* Empieza nodo:378 / Elemento padre: 373   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(378)).setAttribute("tipo","texto" );
      ((Element)v.get(378)).setAttribute("ID","EstDat" );
      ((Element)v.get(373)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */

      /* Empieza nodo:379 / Elemento padre: 373   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(379)).setAttribute("tipo","texto" );
      ((Element)v.get(379)).setAttribute("ID","EstDat2" );
      ((Element)v.get(373)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */

      /* Empieza nodo:380 / Elemento padre: 373   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(380)).setAttribute("tipo","texto" );
      ((Element)v.get(380)).setAttribute("ID","EstDat" );
      ((Element)v.get(373)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */

      /* Empieza nodo:381 / Elemento padre: 373   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(381)).setAttribute("tipo","texto" );
      ((Element)v.get(381)).setAttribute("ID","EstDat2" );
      ((Element)v.get(373)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */

      /* Empieza nodo:382 / Elemento padre: 373   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(382)).setAttribute("tipo","texto" );
      ((Element)v.get(382)).setAttribute("ID","EstDat" );
      ((Element)v.get(373)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */

      /* Empieza nodo:383 / Elemento padre: 373   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(383)).setAttribute("tipo","texto" );
      ((Element)v.get(383)).setAttribute("ID","EstDat2" );
      ((Element)v.get(373)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */

      /* Empieza nodo:384 / Elemento padre: 373   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(384)).setAttribute("tipo","texto" );
      ((Element)v.get(384)).setAttribute("ID","EstDat" );
      ((Element)v.get(373)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */

      /* Empieza nodo:385 / Elemento padre: 373   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(385)).setAttribute("tipo","texto" );
      ((Element)v.get(385)).setAttribute("ID","EstDat2" );
      ((Element)v.get(373)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */

      /* Empieza nodo:386 / Elemento padre: 373   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(386)).setAttribute("tipo","texto" );
      ((Element)v.get(386)).setAttribute("ID","EstDat" );
      ((Element)v.get(373)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */
      /* Termina nodo:373   */

      /* Empieza nodo:387 / Elemento padre: 331   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(331)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */

      /* Empieza nodo:388 / Elemento padre: 331   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(388)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(388)).setAttribute("ancho","518" );
      ((Element)v.get(388)).setAttribute("sep","$" );
      ((Element)v.get(388)).setAttribute("x","12" );
      ((Element)v.get(388)).setAttribute("class","botonera" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(388)).setAttribute("y","499" );
      ((Element)v.get(388)).setAttribute("control","|" );
      ((Element)v.get(388)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(388)).setAttribute("rowset","" );
      ((Element)v.get(388)).setAttribute("cargainicial","N" );
      ((Element)v.get(331)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */
      /* Termina nodo:331   */

      /* Empieza nodo:389 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(389)).setAttribute("nombre","Eliminar" );
      ((Element)v.get(389)).setAttribute("x","13" );
      ((Element)v.get(389)).setAttribute("y","500" );
      ((Element)v.get(389)).setAttribute("ID","botonContenido" );
      ((Element)v.get(389)).setAttribute("tipo","html" );
      ((Element)v.get(389)).setAttribute("accion","eliminarLinea(1);" );
      ((Element)v.get(389)).setAttribute("estado","false" );
      ((Element)v.get(389)).setAttribute("cod","1254" );
      ((Element)v.get(8)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */

      /* Empieza nodo:390 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(390)).setAttribute("nombre","listado2" );
      ((Element)v.get(390)).setAttribute("ancho","518" );
      ((Element)v.get(390)).setAttribute("alto","250" );
      ((Element)v.get(390)).setAttribute("x","12" );
      ((Element)v.get(390)).setAttribute("y","546" );
      ((Element)v.get(390)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(390)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(391)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(391)).setAttribute("alto","22" );
      ((Element)v.get(391)).setAttribute("imgFondo","" );
      ((Element)v.get(391)).setAttribute("cod","00144" );
      ((Element)v.get(391)).setAttribute("ID","datosTitle" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */

      /* Empieza nodo:392 / Elemento padre: 390   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(392)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(392)).setAttribute("alto","22" );
      ((Element)v.get(392)).setAttribute("imgFondo","" );
      ((Element)v.get(390)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */

      /* Empieza nodo:393 / Elemento padre: 390   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(393)).setAttribute("precarga","S" );
      ((Element)v.get(393)).setAttribute("conROver","S" );
      ((Element)v.get(390)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(394)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(394)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(394)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(394)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */

      /* Empieza nodo:395 / Elemento padre: 393   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(395)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(395)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(395)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(395)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(393)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */

      /* Empieza nodo:396 / Elemento padre: 393   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(396)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(396)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(393)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:393   */

      /* Empieza nodo:397 / Elemento padre: 390   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(390)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(398)).setAttribute("borde","1" );
      ((Element)v.get(398)).setAttribute("horizDatos","1" );
      ((Element)v.get(398)).setAttribute("horizCabecera","1" );
      ((Element)v.get(398)).setAttribute("vertical","1" );
      ((Element)v.get(398)).setAttribute("horizTitulo","1" );
      ((Element)v.get(398)).setAttribute("horizBase","1" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */

      /* Empieza nodo:399 / Elemento padre: 397   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(399)).setAttribute("borde","#999999" );
      ((Element)v.get(399)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(399)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(399)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(399)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(399)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(399)).setAttribute("horizBase","#999999" );
      ((Element)v.get(397)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:397   */

      /* Empieza nodo:400 / Elemento padre: 390   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(400)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(400)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(400)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(400)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(400)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(400)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(390)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(401)).setAttribute("ancho","120" );
      ((Element)v.get(401)).setAttribute("minimizable","S" );
      ((Element)v.get(401)).setAttribute("minimizada","N" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */

      /* Empieza nodo:402 / Elemento padre: 400   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(402)).setAttribute("ancho","120" );
      ((Element)v.get(402)).setAttribute("minimizable","S" );
      ((Element)v.get(402)).setAttribute("minimizada","N" );
      ((Element)v.get(400)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */

      /* Empieza nodo:403 / Elemento padre: 400   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(403)).setAttribute("ancho","120" );
      ((Element)v.get(403)).setAttribute("minimizable","S" );
      ((Element)v.get(403)).setAttribute("minimizada","N" );
      ((Element)v.get(400)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */

      /* Empieza nodo:404 / Elemento padre: 400   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(404)).setAttribute("ancho","160" );
      ((Element)v.get(404)).setAttribute("minimizable","S" );
      ((Element)v.get(404)).setAttribute("minimizada","N" );
      ((Element)v.get(400)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */

      /* Empieza nodo:405 / Elemento padre: 400   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(405)).setAttribute("ancho","120" );
      ((Element)v.get(405)).setAttribute("minimizable","S" );
      ((Element)v.get(405)).setAttribute("minimizada","N" );
      ((Element)v.get(400)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */

      /* Empieza nodo:406 / Elemento padre: 400   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(406)).setAttribute("ancho","120" );
      ((Element)v.get(406)).setAttribute("minimizable","S" );
      ((Element)v.get(406)).setAttribute("minimizada","N" );
      ((Element)v.get(400)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */

      /* Empieza nodo:407 / Elemento padre: 400   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(407)).setAttribute("ancho","160" );
      ((Element)v.get(407)).setAttribute("minimizable","S" );
      ((Element)v.get(407)).setAttribute("minimizada","N" );
      ((Element)v.get(400)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:400   */

      /* Empieza nodo:408 / Elemento padre: 390   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(408)).setAttribute("alto","20" );
      ((Element)v.get(408)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(408)).setAttribute("imgFondo","" );
      ((Element)v.get(408)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(390)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(409)).setAttribute("colFondo","" );
      ((Element)v.get(409)).setAttribute("ID","EstCab" );
      ((Element)v.get(409)).setAttribute("align","center" );
      ((Element)v.get(409)).setAttribute("cod","1350" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */

      /* Empieza nodo:410 / Elemento padre: 408   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(410)).setAttribute("colFondo","" );
      ((Element)v.get(410)).setAttribute("ID","EstCab" );
      ((Element)v.get(410)).setAttribute("align","center" );
      ((Element)v.get(410)).setAttribute("cod","1351" );
      ((Element)v.get(408)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */

      /* Empieza nodo:411 / Elemento padre: 408   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(411)).setAttribute("colFondo","" );
      ((Element)v.get(411)).setAttribute("ID","EstCab" );
      ((Element)v.get(411)).setAttribute("align","center" );
      ((Element)v.get(411)).setAttribute("cod","1352" );
      ((Element)v.get(408)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */

      /* Empieza nodo:412 / Elemento padre: 408   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(412)).setAttribute("colFondo","" );
      ((Element)v.get(412)).setAttribute("ID","EstCab" );
      ((Element)v.get(412)).setAttribute("align","center" );
      ((Element)v.get(412)).setAttribute("cod","1353" );
      ((Element)v.get(408)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */

      /* Empieza nodo:413 / Elemento padre: 408   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(413)).setAttribute("colFondo","" );
      ((Element)v.get(413)).setAttribute("ID","EstCab" );
      ((Element)v.get(413)).setAttribute("align","center" );
      ((Element)v.get(413)).setAttribute("cod","1354" );
      ((Element)v.get(408)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */

      /* Empieza nodo:414 / Elemento padre: 408   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(414)).setAttribute("colFondo","" );
      ((Element)v.get(414)).setAttribute("ID","EstCab" );
      ((Element)v.get(414)).setAttribute("align","center" );
      ((Element)v.get(414)).setAttribute("cod","1355" );
      ((Element)v.get(408)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */

      /* Empieza nodo:415 / Elemento padre: 408   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(415)).setAttribute("colFondo","" );
      ((Element)v.get(415)).setAttribute("ID","EstCab" );
      ((Element)v.get(415)).setAttribute("align","center" );
      ((Element)v.get(415)).setAttribute("cod","1356" );
      ((Element)v.get(408)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */
      /* Termina nodo:408   */

      /* Empieza nodo:416 / Elemento padre: 390   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(416)).setAttribute("alto","22" );
      ((Element)v.get(416)).setAttribute("accion","" );
      ((Element)v.get(416)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(416)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(416)).setAttribute("maxSel","-1" );
      ((Element)v.get(416)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(416)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(416)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(416)).setAttribute("onLoad","" );
      ((Element)v.get(416)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(390)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(417)).setAttribute("tipo","combo" );
      ((Element)v.get(417)).setAttribute("nombre","comboTipoComunicacion" );
      ((Element)v.get(417)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(417)).setAttribute("ID","EstDat" );
      ((Element)v.get(417)).setAttribute("req","S" );
      ((Element)v.get(417)).setAttribute("size","1" );
      ((Element)v.get(417)).setAttribute("multiple","N" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(417)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(419)).setAttribute("ID","1" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(420)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(420)).setAttribute("TIPO","STRING" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));

      /* Elemento padre:420 / Elemento actual: 421   */
      v.add(doc.createTextNode("S"));
      ((Element)v.get(420)).appendChild((Text)v.get(421));

      /* Termina nodo Texto:421   */
      /* Termina nodo:420   */

      /* Empieza nodo:422 / Elemento padre: 419   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(422)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(422)).setAttribute("TIPO","STRING" );
      ((Element)v.get(422)).setAttribute("VALOR","xx" );
      ((Element)v.get(419)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:419   */
      /* Termina nodo:418   */
      /* Termina nodo:417   */

      /* Empieza nodo:423 / Elemento padre: 416   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(423)).setAttribute("tipo","combo" );
      ((Element)v.get(423)).setAttribute("nombre","comboDiaComunicacion" );
      ((Element)v.get(423)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(423)).setAttribute("ID","EstDat2" );
      ((Element)v.get(423)).setAttribute("req","S" );
      ((Element)v.get(423)).setAttribute("size","1" );
      ((Element)v.get(423)).setAttribute("multiple","N" );
      ((Element)v.get(416)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(423)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(425)).setAttribute("ID","1" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(426)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(426)).setAttribute("TIPO","STRING" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Elemento padre:426 / Elemento actual: 427   */
      v.add(doc.createTextNode("S"));
      ((Element)v.get(426)).appendChild((Text)v.get(427));

      /* Termina nodo Texto:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:428 / Elemento padre: 425   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(428)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(428)).setAttribute("TIPO","STRING" );
      ((Element)v.get(428)).setAttribute("VALOR","x" );
      ((Element)v.get(425)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:425   */
      /* Termina nodo:424   */
      /* Termina nodo:423   */

      /* Empieza nodo:429 / Elemento padre: 416   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(429)).setAttribute("tipo","areatexto" );
      ((Element)v.get(429)).setAttribute("nombre","AreaTxtTextoComunicacion" );
      ((Element)v.get(429)).setAttribute("ID","EstDat2" );
      ((Element)v.get(429)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(429)).setAttribute("rows","2" );
      ((Element)v.get(429)).setAttribute("cols","50" );
      ((Element)v.get(429)).setAttribute("validacion","" );
      ((Element)v.get(416)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */

      /* Empieza nodo:430 / Elemento padre: 416   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(430)).setAttribute("tipo","checkbox" );
      ((Element)v.get(430)).setAttribute("nombre","ckComunicacionPrincipal" );
      ((Element)v.get(430)).setAttribute("ID","EstDat2" );
      ((Element)v.get(416)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */

      /* Empieza nodo:431 / Elemento padre: 416   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(431)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(431)).setAttribute("nombre","TextoHoraDesde" );
      ((Element)v.get(431)).setAttribute("size","5" );
      ((Element)v.get(431)).setAttribute("max","5" );
      ((Element)v.get(431)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(431)).setAttribute("ID","EstDat" );
      ((Element)v.get(416)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */

      /* Empieza nodo:432 / Elemento padre: 416   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(432)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(432)).setAttribute("nombre","TextoHoraHasta" );
      ((Element)v.get(432)).setAttribute("size","5" );
      ((Element)v.get(432)).setAttribute("max","5" );
      ((Element)v.get(432)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(432)).setAttribute("ID","EstDat2" );
      ((Element)v.get(416)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */

      /* Empieza nodo:433 / Elemento padre: 416   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(433)).setAttribute("tipo","combo" );
      ((Element)v.get(433)).setAttribute("nombre","comboIntervaloComunicacion" );
      ((Element)v.get(433)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(433)).setAttribute("ID","EstDat" );
      ((Element)v.get(433)).setAttribute("req","S" );
      ((Element)v.get(433)).setAttribute("size","1" );
      ((Element)v.get(433)).setAttribute("multiple","N" );
      ((Element)v.get(416)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(433)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("ROW"));
      ((Element)v.get(435)).setAttribute("ID","1" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(436)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(436)).setAttribute("TIPO","STRING" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));

      /* Elemento padre:436 / Elemento actual: 437   */
      v.add(doc.createTextNode("g"));
      ((Element)v.get(436)).appendChild((Text)v.get(437));

      /* Termina nodo Texto:437   */
      /* Termina nodo:436   */

      /* Empieza nodo:438 / Elemento padre: 435   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(438)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(438)).setAttribute("TIPO","STRING" );
      ((Element)v.get(438)).setAttribute("VALOR","x" );
      ((Element)v.get(435)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:435   */
      /* Termina nodo:434   */
      /* Termina nodo:433   */
      /* Termina nodo:416   */

      /* Empieza nodo:439 / Elemento padre: 390   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(390)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */

      /* Empieza nodo:440 / Elemento padre: 390   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(440)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(440)).setAttribute("ancho","518" );
      ((Element)v.get(440)).setAttribute("sep","$" );
      ((Element)v.get(440)).setAttribute("x","12" );
      ((Element)v.get(440)).setAttribute("class","botonera" );
      ((Element)v.get(440)).setAttribute("y","774" );
      ((Element)v.get(440)).setAttribute("control","|" );
      ((Element)v.get(440)).setAttribute("conector","conector_prototipo" );
      ((Element)v.get(440)).setAttribute("rowset","" );
      ((Element)v.get(440)).setAttribute("cargainicial","N" );
      ((Element)v.get(390)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:390   */

      /* Empieza nodo:441 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(441)).setAttribute("nombre","masDatos2" );
      ((Element)v.get(441)).setAttribute("x","13" );
      ((Element)v.get(441)).setAttribute("y","775" );
      ((Element)v.get(441)).setAttribute("ID","botonContenido" );
      ((Element)v.get(441)).setAttribute("tipo","html" );
      ((Element)v.get(441)).setAttribute("estado","false" );
      ((Element)v.get(441)).setAttribute("accion","aniadirLinea(2);" );
      ((Element)v.get(441)).setAttribute("cod","404" );
      ((Element)v.get(8)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */

      /* Empieza nodo:442 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(442)).setAttribute("nombre","Eliminar2" );
      ((Element)v.get(442)).setAttribute("x","61" );
      ((Element)v.get(442)).setAttribute("y","775" );
      ((Element)v.get(442)).setAttribute("ID","botonContenido" );
      ((Element)v.get(442)).setAttribute("tipo","html" );
      ((Element)v.get(442)).setAttribute("accion","eliminarLinea(2);" );
      ((Element)v.get(442)).setAttribute("estado","false" );
      ((Element)v.get(442)).setAttribute("cod","1254" );
      ((Element)v.get(8)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */

      /* Empieza nodo:443 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(443)).setAttribute("nombre","listado3" );
      ((Element)v.get(443)).setAttribute("ancho","518" );
      ((Element)v.get(443)).setAttribute("alto","162" );
      ((Element)v.get(443)).setAttribute("x","12" );
      ((Element)v.get(443)).setAttribute("y","820" );
      ((Element)v.get(443)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(443)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(444)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(444)).setAttribute("alto","22" );
      ((Element)v.get(444)).setAttribute("imgFondo","" );
      ((Element)v.get(444)).setAttribute("cod","00145" );
      ((Element)v.get(444)).setAttribute("ID","datosTitle" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */

      /* Empieza nodo:445 / Elemento padre: 443   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(445)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(445)).setAttribute("alto","22" );
      ((Element)v.get(445)).setAttribute("imgFondo","" );
      ((Element)v.get(443)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */

      /* Empieza nodo:446 / Elemento padre: 443   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(446)).setAttribute("precarga","S" );
      ((Element)v.get(446)).setAttribute("conROver","S" );
      ((Element)v.get(443)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(447)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(447)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(447)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(447)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */

      /* Empieza nodo:448 / Elemento padre: 446   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(448)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(448)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(448)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(448)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(446)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */

      /* Empieza nodo:449 / Elemento padre: 446   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(449)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(449)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(446)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:446   */

      /* Empieza nodo:450 / Elemento padre: 443   */
      v.add(doc.createElement("LINEAS"));
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(443)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(451)).setAttribute("borde","1" );
      ((Element)v.get(451)).setAttribute("horizDatos","1" );
      ((Element)v.get(451)).setAttribute("horizCabecera","1" );
      ((Element)v.get(451)).setAttribute("vertical","1" );
      ((Element)v.get(451)).setAttribute("horizTitulo","1" );
      ((Element)v.get(451)).setAttribute("horizBase","1" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */

      /* Empieza nodo:452 / Elemento padre: 450   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(452)).setAttribute("borde","#999999" );
      ((Element)v.get(452)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(452)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(452)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(452)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(452)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(452)).setAttribute("horizBase","#999999" );
      ((Element)v.get(450)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:450   */

      /* Empieza nodo:453 / Elemento padre: 443   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(453)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(453)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(453)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(453)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(453)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(453)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(443)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(454)).setAttribute("ancho","40" );
      ((Element)v.get(454)).setAttribute("minimizable","S" );
      ((Element)v.get(454)).setAttribute("minimizada","N" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */

      /* Empieza nodo:455 / Elemento padre: 443   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(455)).setAttribute("alto","20" );
      ((Element)v.get(455)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(455)).setAttribute("imgFondo","" );
      ((Element)v.get(455)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(443)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(456)).setAttribute("colFondo","" );
      ((Element)v.get(456)).setAttribute("ID","EstCab" );
      ((Element)v.get(456)).setAttribute("align","center" );
      ((Element)v.get(456)).setAttribute("cod","6" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:455   */

      /* Empieza nodo:457 / Elemento padre: 443   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(457)).setAttribute("alto","22" );
      ((Element)v.get(457)).setAttribute("accion","" );
      ((Element)v.get(457)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(457)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(457)).setAttribute("maxSel","-1" );
      ((Element)v.get(457)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(457)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(457)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(457)).setAttribute("onLoad","" );
      ((Element)v.get(457)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(443)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(458)).setAttribute("tipo","combo" );
      ((Element)v.get(458)).setAttribute("nombre","comboMarca" );
      ((Element)v.get(458)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(458)).setAttribute("ID","EstDat" );
      ((Element)v.get(458)).setAttribute("onchange","cambioMarca();" );
      ((Element)v.get(458)).setAttribute("req","S" );
      ((Element)v.get(458)).setAttribute("size","1" );
      ((Element)v.get(458)).setAttribute("multiple","N" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(458)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(460)).setAttribute("ID","1" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(461)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(461)).setAttribute("TIPO","STRING" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));

      /* Elemento padre:461 / Elemento actual: 462   */
      v.add(doc.createTextNode("S"));
      ((Element)v.get(461)).appendChild((Text)v.get(462));

      /* Termina nodo Texto:462   */
      /* Termina nodo:461   */

      /* Empieza nodo:463 / Elemento padre: 460   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(463)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(463)).setAttribute("TIPO","STRING" );
      ((Element)v.get(463)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(460)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:460   */
      /* Termina nodo:459   */
      /* Termina nodo:458   */
      /* Termina nodo:457   */

      /* Empieza nodo:464 / Elemento padre: 443   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(443)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(465)).setAttribute("ID","1" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(466)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(466)).setAttribute("TIPO","STRING" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));

      /* Elemento padre:466 / Elemento actual: 467   */
   }

   private void getXML2160(Document doc) {
      v.add(doc.createTextNode("S"));
      ((Element)v.get(466)).appendChild((Text)v.get(467));

      /* Termina nodo Texto:467   */
      /* Termina nodo:466   */

      /* Empieza nodo:468 / Elemento padre: 465   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(468)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(468)).setAttribute("TIPO","STRING" );
      ((Element)v.get(468)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(465)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */
      /* Termina nodo:465   */
      /* Termina nodo:464   */

      /* Empieza nodo:469 / Elemento padre: 443   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(469)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(469)).setAttribute("ancho","518" );
      ((Element)v.get(469)).setAttribute("sep","$" );
      ((Element)v.get(469)).setAttribute("x","12" );
      ((Element)v.get(469)).setAttribute("class","botonera" );
      ((Element)v.get(469)).setAttribute("y","959" );
      ((Element)v.get(469)).setAttribute("control","|" );
      ((Element)v.get(469)).setAttribute("conector","conector_victor" );
      ((Element)v.get(469)).setAttribute("rowset","" );
      ((Element)v.get(469)).setAttribute("cargainicial","N" );
      ((Element)v.get(443)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:443   */

      /* Empieza nodo:470 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(470)).setAttribute("nombre","masDatos3" );
      ((Element)v.get(470)).setAttribute("x","13" );
      ((Element)v.get(470)).setAttribute("y","960" );
      ((Element)v.get(470)).setAttribute("ID","botonContenido" );
      ((Element)v.get(470)).setAttribute("tipo","html" );
      ((Element)v.get(470)).setAttribute("accion","aniadirLinea(3);" );
      ((Element)v.get(470)).setAttribute("estado","false" );
      ((Element)v.get(470)).setAttribute("cod","404" );
      ((Element)v.get(8)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */

      /* Empieza nodo:471 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(471)).setAttribute("nombre","Eliminar3" );
      ((Element)v.get(471)).setAttribute("x","61" );
      ((Element)v.get(471)).setAttribute("y","960" );
      ((Element)v.get(471)).setAttribute("ID","botonContenido" );
      ((Element)v.get(471)).setAttribute("tipo","html" );
      ((Element)v.get(471)).setAttribute("accion","eliminarLinea(3);" );
      ((Element)v.get(471)).setAttribute("estado","false" );
      ((Element)v.get(471)).setAttribute("cod","1254" );
      ((Element)v.get(8)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */

      /* Empieza nodo:472 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(472)).setAttribute("nombre","capaEspacio2" );
      ((Element)v.get(472)).setAttribute("x","0" );
      ((Element)v.get(472)).setAttribute("y","982" );
      ((Element)v.get(8)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("table"));
      ((Element)v.get(473)).setAttribute("width","100%" );
      ((Element)v.get(473)).setAttribute("border","0" );
      ((Element)v.get(473)).setAttribute("cellspacing","0" );
      ((Element)v.get(473)).setAttribute("cellpadding","0" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(473)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("td"));
      ((Element)v.get(474)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(476)).setAttribute("src","b.gif" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */

      /* Empieza nodo:477 / Elemento padre: 474   */
      v.add(doc.createElement("td"));
      ((Element)v.get(474)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("table"));
      ((Element)v.get(478)).setAttribute("width","100%" );
      ((Element)v.get(478)).setAttribute("border","0" );
      ((Element)v.get(478)).setAttribute("align","center" );
      ((Element)v.get(478)).setAttribute("cellspacing","0" );
      ((Element)v.get(478)).setAttribute("cellpadding","0" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(478)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("td"));
      ((Element)v.get(479)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("table"));
      ((Element)v.get(481)).setAttribute("width","519" );
      ((Element)v.get(481)).setAttribute("border","0" );
      ((Element)v.get(481)).setAttribute("align","left" );
      ((Element)v.get(481)).setAttribute("cellspacing","0" );
      ((Element)v.get(481)).setAttribute("cellpadding","0" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(481)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("td"));
      ((Element)v.get(482)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(484)).setAttribute("src","b.gif" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */
      /* Termina nodo:483   */
      /* Termina nodo:482   */
      /* Termina nodo:481   */
      /* Termina nodo:480   */
      /* Termina nodo:479   */
      /* Termina nodo:478   */
      /* Termina nodo:477   */

      /* Empieza nodo:485 / Elemento padre: 474   */
      v.add(doc.createElement("td"));
      ((Element)v.get(474)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(486)).setAttribute("src","b.gif" );
      ((Element)v.get(485)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */
      /* Termina nodo:485   */
      /* Termina nodo:474   */

      /* Empieza nodo:487 / Elemento padre: 473   */
      v.add(doc.createElement("tr"));
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(473)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("td"));
      ((Element)v.get(487)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(489)).setAttribute("src","b.gif" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:488   */

      /* Empieza nodo:490 / Elemento padre: 487   */
      v.add(doc.createElement("td"));
      ((Element)v.get(487)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(490)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("table"));
      ((Element)v.get(492)).setAttribute("width","100%" );
      ((Element)v.get(492)).setAttribute("border","0" );
      ((Element)v.get(492)).setAttribute("align","center" );
      ((Element)v.get(492)).setAttribute("cellspacing","0" );
      ((Element)v.get(492)).setAttribute("cellpadding","0" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(492)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("td"));
      ((Element)v.get(494)).setAttribute("align","right" );
      ((Element)v.get(494)).setAttribute("class","botonera" );
      ((Element)v.get(494)).setAttribute("width","100%" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(495)).setAttribute("nombre","btnAnterior" );
      ((Element)v.get(495)).setAttribute("ID","botonContenido" );
      ((Element)v.get(495)).setAttribute("tipo","html" );
      ((Element)v.get(495)).setAttribute("accion","accionP2();" );
      ((Element)v.get(495)).setAttribute("estado","false" );
      ((Element)v.get(495)).setAttribute("cod","1649" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */

      /* Empieza nodo:496 / Elemento padre: 494   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(496)).setAttribute("nombre","btnSiguiente" );
      ((Element)v.get(496)).setAttribute("ID","botonContenido" );
      ((Element)v.get(496)).setAttribute("tipo","html" );
      ((Element)v.get(496)).setAttribute("accion","accionP4();" );
      ((Element)v.get(496)).setAttribute("ontab","accionP4();" );
      ((Element)v.get(496)).setAttribute("estado","false" );
      ((Element)v.get(496)).setAttribute("cod","446" );
      ((Element)v.get(494)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */
      /* Termina nodo:494   */
      /* Termina nodo:493   */
      /* Termina nodo:492   */
      /* Termina nodo:491   */
      /* Termina nodo:490   */

      /* Empieza nodo:497 / Elemento padre: 487   */
      v.add(doc.createElement("td"));
      ((Element)v.get(487)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(498)).setAttribute("src","b.gif" );
      ((Element)v.get(498)).setAttribute("width","12" );
      ((Element)v.get(498)).setAttribute("height","12" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */
      /* Termina nodo:487   */

      /* Empieza nodo:499 / Elemento padre: 473   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(473)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("td"));
      ((Element)v.get(500)).setAttribute("width","12" );
      ((Element)v.get(500)).setAttribute("align","center" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(501)).setAttribute("src","b.gif" );
      ((Element)v.get(501)).setAttribute("width","12" );
      ((Element)v.get(501)).setAttribute("height","12" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */
      /* Termina nodo:500   */

      /* Empieza nodo:502 / Elemento padre: 499   */
      v.add(doc.createElement("td"));
      ((Element)v.get(502)).setAttribute("width","756" );
      ((Element)v.get(499)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(503)).setAttribute("src","b.gif" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */

      /* Empieza nodo:504 / Elemento padre: 499   */
      v.add(doc.createElement("td"));
      ((Element)v.get(504)).setAttribute("width","12" );
      ((Element)v.get(499)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(505)).setAttribute("src","b.gif" );
      ((Element)v.get(505)).setAttribute("width","12" );
      ((Element)v.get(505)).setAttribute("height","1" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */
      /* Termina nodo:499   */
      /* Termina nodo:473   */
      /* Termina nodo:472   */
      /* Termina nodo:8   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_grupo1_cliente_basico_crear2  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_grupo1_cliente_basico_crear2" );
      ((Element)v.get(0)).setAttribute("cod","0309" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Insertar Cliente Básico" );
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
      ((Element)v.get(2)).setAttribute("src","scripts_clientes.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","contenido_grupo1_cliente_basico_crear2.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","frmInsertarCliente" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","codigoAutomatico" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","digitoControl" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","nameComboSelected" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","valueComboSelected" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","docPrincipal" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","elementos" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","componente" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","radioStatus" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","codigoCliente" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","back" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","envia" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","atrasTipoSubtipo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","accion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","nameComboSelected" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","valueComboSelected" );
      ((Element)v.get(22)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(5)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","ultimoChequeado" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hFormatoFechaPais" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hPestanya" );
      ((Element)v.get(27)).setAttribute("valor","1" );
      ((Element)v.get(5)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hReentrandoP1" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hReentrandoP2" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hReentrandoP3" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hReentrandoP4" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hidFocusPrimerComponente" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hidTipoClienDescripcion" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","codCliente" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","cbTipo" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","cbSTipo" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hidCodigoAutomatico" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hidDigitoControl" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hidtextCodCliente" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hidListaIdentificacion" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","elemToDelP2" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hidlongCliente" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hIndActivoP2" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","columnaPersonaEmpresa" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).setAttribute("nombre","elementosP2" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hidFechaIngreso" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hidtextApellido1" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hidtextApellido2" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hidtextApellidoCasada" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hidtextNombre1" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hidtextNombre2" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hidcbTratamiento" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hidrbSexo" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hidcbFormaPago" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hidtextFechaNacimiento" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hidEdad" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","hidtextCodEmpleado" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","hidcbNacionalidad" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hidcbEstadoCivil" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hidtextOcupacion" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","hidtextProfesion" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","hidtextCentroTrabajo" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","hidtextCargoDesempena" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","hidcbNivelEstudios" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","hidtextCentroEstudios" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","hidtextNHijos" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","hidtextNPersonasDependientes" );
      ((Element)v.get(67)).setAttribute("valor","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(5)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","hidcbNivelSocioEconomico" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","hidcbCicloVidaFamiliar" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","hidrbDeseaCorrespondencia" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","hidtextImporteIngresoFamiliar" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","hidcbPaisContactado" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","hidtextCodClienteContactado" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","hidcbTipoClienteContactado" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","hidcbCodTipoContactado" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","hidtextFechaContacto" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","hidtextFecha1PedidoContacto" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","hidtextFechaSiguienteContacto" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","hidtxtFechaIngresoActual" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","hidListaVinculo" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","hidListaObservacion" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","hidListaPrefe" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","hOidCliente" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","hidMarcaContacto" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","hidCanalContacto" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","hidPeriodoContacto" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","listaVinculosOid" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","elementosP3" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(89)).setAttribute("nombre","elementosP3Marca" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(90)).setAttribute("nombre","hidListaDirecciones" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(91)).setAttribute("nombre","hidListaComunicacion" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(92)).setAttribute("nombre","hidListaMarca" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(93)).setAttribute("nombre","hidMarcaValor" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(94)).setAttribute("nombre","hidOidClienteCont" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(95)).setAttribute("nombre","usaGeoreferenciador" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(96)).setAttribute("nombre","elementosExtra" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(97)).setAttribute("nombre","elementosP4" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(98)).setAttribute("nombre","hidListaTarjetas" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(99)).setAttribute("nombre","hidListaClasificacion" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(100)).setAttribute("nombre","hidListaProbSolu" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(101)).setAttribute("nombre","hiddenOid" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(102)).setAttribute("nombre","hiddenCodigo" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(103)).setAttribute("nombre","hidPestanya" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(104)).setAttribute("nombre","dtoOid" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(105)).setAttribute("nombre","hidCodigoCliente" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(106)).setAttribute("nombre","hOidDefTipoDoc" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 5   */
      v.add(doc.createElement("table"));
      ((Element)v.get(107)).setAttribute("width","100%" );
      ((Element)v.get(107)).setAttribute("height","100%" );
      ((Element)v.get(107)).setAttribute("border","0" );
      ((Element)v.get(107)).setAttribute("align","center" );
      ((Element)v.get(107)).setAttribute("cellpadding","0" );
      ((Element)v.get(107)).setAttribute("cellspacing","0" );
      ((Element)v.get(107)).setAttribute("class","menu4" );
      ((Element)v.get(5)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("width","12" );
      ((Element)v.get(109)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(109)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","12" );
      ((Element)v.get(110)).setAttribute("height","30" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("nowrap","nowrap" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(111)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(111));

      /* Elemento padre:111 / Elemento actual: 112   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(111)).appendChild((Text)v.get(112));

      /* Termina nodo Texto:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","10" );
      ((Element)v.get(113)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(113)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","10" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("width","20" );
      ((Element)v.get(115)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(115)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("table"));
      ((Element)v.get(116)).setAttribute("width","75" );
      ((Element)v.get(116)).setAttribute("border","1" );
      ((Element)v.get(116)).setAttribute("align","center" );
      ((Element)v.get(116)).setAttribute("cellpadding","1" );
      ((Element)v.get(116)).setAttribute("cellspacing","0" );
      ((Element)v.get(116)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(116)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(117)).setAttribute("align","center" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(119)).setAttribute("nombre","lblPes1" );
      ((Element)v.get(119)).setAttribute("alto","13" );
      ((Element)v.get(119)).setAttribute("filas","1" );
      ((Element)v.get(119)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(119)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(119)).setAttribute("cod","00515" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:120 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","10" );
      ((Element)v.get(120)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","10" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("width","20" );
      ((Element)v.get(122)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(122)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("table"));
      ((Element)v.get(123)).setAttribute("width","75" );
      ((Element)v.get(123)).setAttribute("border","1" );
      ((Element)v.get(123)).setAttribute("align","center" );
      ((Element)v.get(123)).setAttribute("cellpadding","1" );
      ((Element)v.get(123)).setAttribute("cellspacing","0" );
      ((Element)v.get(123)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).setAttribute("align","center" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(126)).setAttribute("id","Pes2" );
      ((Element)v.get(126)).setAttribute("onclick","accionP2();" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(127)).setAttribute("nombre","lblPes2" );
      ((Element)v.get(127)).setAttribute("alto","13" );
      ((Element)v.get(127)).setAttribute("filas","1" );
      ((Element)v.get(127)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(127)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(127)).setAttribute("cod","00516" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:128 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("width","10" );
      ((Element)v.get(128)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","10" );
      ((Element)v.get(129)).setAttribute("height","8" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("width","20" );
      ((Element)v.get(130)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(130)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("table"));
      ((Element)v.get(131)).setAttribute("width","75" );
      ((Element)v.get(131)).setAttribute("border","1" );
      ((Element)v.get(131)).setAttribute("align","center" );
      ((Element)v.get(131)).setAttribute("cellpadding","1" );
      ((Element)v.get(131)).setAttribute("cellspacing","0" );
      ((Element)v.get(131)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).setAttribute("align","center" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(134)).setAttribute("nombre","lblPes3" );
      ((Element)v.get(134)).setAttribute("alto","13" );
      ((Element)v.get(134)).setAttribute("filas","1" );
      ((Element)v.get(134)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(134)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(134)).setAttribute("cod","00517" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:135 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("width","10" );
      ((Element)v.get(135)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","10" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("width","20" );
      ((Element)v.get(137)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(137)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("table"));
      ((Element)v.get(138)).setAttribute("width","75" );
      ((Element)v.get(138)).setAttribute("border","1" );
      ((Element)v.get(138)).setAttribute("align","center" );
      ((Element)v.get(138)).setAttribute("cellpadding","1" );
      ((Element)v.get(138)).setAttribute("cellspacing","0" );
      ((Element)v.get(138)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(139)).setAttribute("align","center" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(140)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(141)).setAttribute("nombre","lblPes4" );
      ((Element)v.get(141)).setAttribute("alto","13" );
      ((Element)v.get(141)).setAttribute("filas","1" );
      ((Element)v.get(141)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(141)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(141)).setAttribute("cod","00518" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:142 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("width","16" );
      ((Element)v.get(142)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","12" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:144 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(144)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(5)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("table"));
      ((Element)v.get(145)).setAttribute("width","100%" );
      ((Element)v.get(145)).setAttribute("border","0" );
      ((Element)v.get(145)).setAttribute("cellspacing","0" );
      ((Element)v.get(145)).setAttribute("cellpadding","0" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("width","12" );
      ((Element)v.get(147)).setAttribute("align","center" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","12" );
      ((Element)v.get(148)).setAttribute("height","12" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("width","750" );
      ((Element)v.get(146)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("width","12" );
      ((Element)v.get(146)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","12" );
      ((Element)v.get(152)).setAttribute("height","1" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:146   */

      /* Empieza nodo:153 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(158)).setAttribute("class","legend" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(159)).setAttribute("nombre","lblTitDatosComunes" );
      ((Element)v.get(159)).setAttribute("alto","13" );
      ((Element)v.get(159)).setAttribute("filas","1" );
      ((Element)v.get(159)).setAttribute("valor","" );
      ((Element)v.get(159)).setAttribute("cod","00159" );
      ((Element)v.get(159)).setAttribute("id","legend" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 157   */
      v.add(doc.createElement("table"));
      ((Element)v.get(160)).setAttribute("width","100%" );
      ((Element)v.get(160)).setAttribute("border","0" );
      ((Element)v.get(160)).setAttribute("align","center" );
      ((Element)v.get(160)).setAttribute("cellspacing","0" );
      ((Element)v.get(160)).setAttribute("cellpadding","0" );
      ((Element)v.get(157)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("table"));
      ((Element)v.get(163)).setAttribute("width","370" );
      ((Element)v.get(163)).setAttribute("border","0" );
      ((Element)v.get(163)).setAttribute("align","left" );
      ((Element)v.get(163)).setAttribute("cellspacing","0" );
      ((Element)v.get(163)).setAttribute("cellpadding","0" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("colspan","4" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","8" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:167 / Elemento padre: 163   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(163)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","8" );
      ((Element)v.get(169)).setAttribute("height","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(171)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(171)).setAttribute("alto","13" );
      ((Element)v.get(171)).setAttribute("filas","1" );
      ((Element)v.get(171)).setAttribute("valor","" );
      ((Element)v.get(171)).setAttribute("id","datosTitle" );
      ((Element)v.get(171)).setAttribute("cod","263" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","8" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(175)).setAttribute("nombre","lblIndActivo" );
      ((Element)v.get(175)).setAttribute("alto","13" );
      ((Element)v.get(175)).setAttribute("filas","1" );
      ((Element)v.get(175)).setAttribute("valor","" );
      ((Element)v.get(175)).setAttribute("id","datosTitle" );
      ((Element)v.get(175)).setAttribute("cod","905" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("width","100%" );
      ((Element)v.get(167)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","8" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:167   */

      /* Empieza nodo:178 / Elemento padre: 163   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(163)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","8" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(182)).setAttribute("nombre","lblCodClienteActual" );
      ((Element)v.get(182)).setAttribute("alto","13" );
      ((Element)v.get(182)).setAttribute("filas","1" );
      ((Element)v.get(182)).setAttribute("valor","" );
      ((Element)v.get(182)).setAttribute("id","datosCampos" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","25" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(186)).setAttribute("check","" );
      ((Element)v.get(186)).setAttribute("id","datosCampos" );
      ((Element)v.get(186)).setAttribute("msjreq","" );
      ((Element)v.get(186)).setAttribute("nombre","ckIndActivoP2" );
      ((Element)v.get(186)).setAttribute("onclick","" );
      ((Element)v.get(186)).setAttribute("onfocus","" );
      ((Element)v.get(186)).setAttribute("readonly","" );
      ((Element)v.get(186)).setAttribute("req","" );
      ((Element)v.get(186)).setAttribute("tabindex","1" );
      ((Element)v.get(186)).setAttribute("texto","" );
      ((Element)v.get(186)).setAttribute("validacion","" );
      ((Element)v.get(186)).setAttribute("onshtab","" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).setAttribute("width","100%" );
      ((Element)v.get(178)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:178   */

      /* Empieza nodo:189 / Elemento padre: 163   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(163)).appendChild((Element)v.get(189));

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
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:192 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","8" );
      ((Element)v.get(193)).setAttribute("height","12" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:153   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:194 / Elemento padre: 5   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(194)).setAttribute("nombre","listado1" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(194)).setAttribute("ancho","673" );
      ((Element)v.get(194)).setAttribute("alto","179" );
      ((Element)v.get(194)).setAttribute("x","12" );
      ((Element)v.get(194)).setAttribute("y","122" );
      ((Element)v.get(194)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(194)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(5)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(195)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(195)).setAttribute("alto","22" );
      ((Element)v.get(195)).setAttribute("imgFondo","" );
      ((Element)v.get(195)).setAttribute("cod","0053" );
      ((Element)v.get(195)).setAttribute("ID","datosTitle" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 194   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(196)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(196)).setAttribute("alto","22" );
      ((Element)v.get(196)).setAttribute("imgFondo","" );
      ((Element)v.get(194)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 194   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(197)).setAttribute("precarga","S" );
      ((Element)v.get(197)).setAttribute("conROver","S" );
      ((Element)v.get(194)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(198)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(198)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(198)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(198)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 197   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(199)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(199)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(199)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(199)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(197)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 197   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(200)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(200)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(197)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:197   */

      /* Empieza nodo:201 / Elemento padre: 194   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(194)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(202)).setAttribute("borde","1" );
      ((Element)v.get(202)).setAttribute("horizDatos","1" );
      ((Element)v.get(202)).setAttribute("horizCabecera","1" );
      ((Element)v.get(202)).setAttribute("vertical","1" );
      ((Element)v.get(202)).setAttribute("horizTitulo","1" );
      ((Element)v.get(202)).setAttribute("horizBase","1" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 201   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(203)).setAttribute("borde","#999999" );
      ((Element)v.get(203)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(203)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(203)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(203)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(203)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(203)).setAttribute("horizBase","#999999" );
      ((Element)v.get(201)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:201   */

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
      ((Element)v.get(205)).setAttribute("ancho","215" );
      ((Element)v.get(205)).setAttribute("minimizable","S" );
      ((Element)v.get(205)).setAttribute("minimizada","N" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("ancho","200" );
      ((Element)v.get(206)).setAttribute("minimizable","S" );
      ((Element)v.get(206)).setAttribute("minimizada","N" );
      ((Element)v.get(204)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("ancho","200" );
      ((Element)v.get(207)).setAttribute("minimizable","S" );
      ((Element)v.get(207)).setAttribute("minimizada","N" );
      ((Element)v.get(204)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("ancho","120" );
      ((Element)v.get(208)).setAttribute("minimizable","S" );
      ((Element)v.get(208)).setAttribute("minimizada","N" );
      ((Element)v.get(204)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(209)).setAttribute("ancho","140" );
      ((Element)v.get(209)).setAttribute("minimizable","S" );
      ((Element)v.get(209)).setAttribute("minimizada","N" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(204)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:204   */

      /* Empieza nodo:210 / Elemento padre: 194   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(210)).setAttribute("alto","20" );
      ((Element)v.get(210)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(210)).setAttribute("imgFondo","" );
      ((Element)v.get(210)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(194)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(211)).setAttribute("colFondo","" );
      ((Element)v.get(211)).setAttribute("ID","EstCab" );
      ((Element)v.get(211)).setAttribute("align","center" );
      ((Element)v.get(211)).setAttribute("cod","1126" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("colFondo","" );
      ((Element)v.get(212)).setAttribute("ID","EstCab" );
      ((Element)v.get(212)).setAttribute("align","center" );
      ((Element)v.get(212)).setAttribute("cod","1364" );
      ((Element)v.get(210)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(213)).setAttribute("colFondo","" );
      ((Element)v.get(213)).setAttribute("ID","EstCab" );
      ((Element)v.get(213)).setAttribute("align","center" );
      ((Element)v.get(213)).setAttribute("cod","1332" );
      ((Element)v.get(210)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("colFondo","" );
      ((Element)v.get(214)).setAttribute("ID","EstCab" );
      ((Element)v.get(214)).setAttribute("align","center" );
      ((Element)v.get(214)).setAttribute("cod","1073" );
      ((Element)v.get(210)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(215)).setAttribute("colFondo","" );
      ((Element)v.get(215)).setAttribute("ID","EstCab" );
      ((Element)v.get(215)).setAttribute("align","center" );
      ((Element)v.get(215)).setAttribute("cod","1113" );
      ((Element)v.get(210)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:210   */

      /* Empieza nodo:216 / Elemento padre: 194   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(216)).setAttribute("alto","22" );
      ((Element)v.get(216)).setAttribute("accion","" );
      ((Element)v.get(216)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(216)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(216)).setAttribute("maxSel","-1" );
      ((Element)v.get(216)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(216)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(216)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(216)).setAttribute("onLoad","" );
      ((Element)v.get(216)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(194)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("tipo","combo" );
      ((Element)v.get(217)).setAttribute("nombre","comboTipoDocId" );
      ((Element)v.get(217)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(217)).setAttribute("ID","EstDat2" );
      ((Element)v.get(217)).setAttribute("req","N" );
      ((Element)v.get(217)).setAttribute("onchange","" );
      ((Element)v.get(217)).setAttribute("onShTab","shiftTab(FILAEVENTO);" );
      ((Element)v.get(217)).setAttribute("size","1" );
      ((Element)v.get(217)).setAttribute("multiple","N" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(219)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(219)).setAttribute("nombre","TextoNDoc" );
      ((Element)v.get(219)).setAttribute("size","21" );
      ((Element)v.get(219)).setAttribute("max","15" );
      ((Element)v.get(219)).setAttribute("onchange","flagRadio(FILAEVENTO);" );
      ((Element)v.get(219)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(219)).setAttribute("ID","EstDat" );
      ((Element)v.get(216)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(220)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(220)).setAttribute("nombre","TextoConfirmacionDoc" );
      ((Element)v.get(220)).setAttribute("size","21" );
      ((Element)v.get(220)).setAttribute("max","15" );
      ((Element)v.get(220)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(220)).setAttribute("ID","EstDat2" );
      ((Element)v.get(216)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(221)).setAttribute("tipo","checkbox" );
      ((Element)v.get(221)).setAttribute("nombre","RbDocPrincipal" );
      ((Element)v.get(221)).setAttribute("ID","EstDat" );
      ((Element)v.get(221)).setAttribute("onchange","flagRadio(FILAEVENTO);" );
      ((Element)v.get(216)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(222)).setAttribute("valor","" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(223)).setAttribute("tipo","combo" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(223)).setAttribute("nombre","comboPersonaEmpresa" );
      ((Element)v.get(223)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(223)).setAttribute("ID","EstDat2" );
      ((Element)v.get(223)).setAttribute("req","N" );
      ((Element)v.get(223)).setAttribute("size","1" );
      ((Element)v.get(223)).setAttribute("multiple","N" );
      ((Element)v.get(216)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:216   */

      /* Empieza nodo:225 / Elemento padre: 194   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(194)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(226)).setAttribute("ID","1" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(227)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(227)).setAttribute("TIPO","STRING" );
      ((Element)v.get(227)).setAttribute("VALOR","g" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 226   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(228)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(228)).setAttribute("TIPO","STRING" );
      ((Element)v.get(228)).setAttribute("VALOR","" );
      ((Element)v.get(226)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 226   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(229)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(229)).setAttribute("TIPO","STRING" );
      ((Element)v.get(229)).setAttribute("VALOR","" );
      ((Element)v.get(226)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 226   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(230)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(230)).setAttribute("TIPO","STRING" );
      ((Element)v.get(230)).setAttribute("VALOR","" );
      ((Element)v.get(226)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 226   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(231)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(231)).setAttribute("TIPO","STRING" );
      ((Element)v.get(231)).setAttribute("VALOR","" );
      ((Element)v.get(226)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 226   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(232)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(232)).setAttribute("TIPO","STRING" );
      ((Element)v.get(232)).setAttribute("VALOR","" );
      ((Element)v.get(226)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:194   */

      /* Empieza nodo:233 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(233)).setAttribute("nombre","Anadir" );
      ((Element)v.get(233)).setAttribute("x","13" );
      ((Element)v.get(233)).setAttribute("y","279" );
      ((Element)v.get(233)).setAttribute("ID","botonContenido" );
      ((Element)v.get(233)).setAttribute("tipo","html" );
      ((Element)v.get(233)).setAttribute("accion","aniadirFila();" );
      ((Element)v.get(233)).setAttribute("estado","false" );
      ((Element)v.get(233)).setAttribute("cod","404" );
      ((Element)v.get(5)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */

      /* Empieza nodo:234 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(234)).setAttribute("nombre","Eliminar" );
      ((Element)v.get(234)).setAttribute("x","61" );
      ((Element)v.get(234)).setAttribute("y","279" );
      ((Element)v.get(234)).setAttribute("ID","botonContenido" );
      ((Element)v.get(234)).setAttribute("tipo","html" );
      ((Element)v.get(234)).setAttribute("estado","false" );
      ((Element)v.get(234)).setAttribute("cod","1254" );
      ((Element)v.get(234)).setAttribute("accion","fBorrar();" );
      ((Element)v.get(5)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(235)).setAttribute("nombre","capaEspacio2" );
      ((Element)v.get(235)).setAttribute("x","0" );
      ((Element)v.get(235)).setAttribute("y","300" );
      ((Element)v.get(5)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("table"));
      ((Element)v.get(236)).setAttribute("width","100%" );
      ((Element)v.get(236)).setAttribute("border","0" );
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
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("table"));
      ((Element)v.get(241)).setAttribute("width","100%" );
      ((Element)v.get(241)).setAttribute("border","0" );
      ((Element)v.get(241)).setAttribute("align","center" );
      ((Element)v.get(241)).setAttribute("cellspacing","0" );
      ((Element)v.get(241)).setAttribute("cellpadding","0" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("table"));
      ((Element)v.get(244)).setAttribute("width","674" );
      ((Element)v.get(244)).setAttribute("border","0" );
      ((Element)v.get(244)).setAttribute("align","left" );
      ((Element)v.get(244)).setAttribute("cellspacing","0" );
      ((Element)v.get(244)).setAttribute("cellpadding","0" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:248 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:237   */

      /* Empieza nodo:250 / Elemento padre: 236   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(236)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("table"));
      ((Element)v.get(255)).setAttribute("width","100%" );
      ((Element)v.get(255)).setAttribute("border","0" );
      ((Element)v.get(255)).setAttribute("align","center" );
      ((Element)v.get(255)).setAttribute("cellspacing","0" );
      ((Element)v.get(255)).setAttribute("cellpadding","0" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).setAttribute("align","right" );
      ((Element)v.get(257)).setAttribute("class","botonera" );
      ((Element)v.get(257)).setAttribute("width","100%" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(258)).setAttribute("nombre","Validar" );
      ((Element)v.get(258)).setAttribute("ID","botonContenido" );
      ((Element)v.get(258)).setAttribute("tipo","html" );
      ((Element)v.get(258)).setAttribute("estado","false" );
      ((Element)v.get(258)).setAttribute("cod","1138" );
      ((Element)v.get(258)).setAttribute("accion","javascript:accionP2();" );
      ((Element)v.get(258)).setAttribute("ontab","javascript:accionP2();" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 257   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(259)).setAttribute("nombre","Anterior" );
      ((Element)v.get(259)).setAttribute("ID","botonContenido" );
      ((Element)v.get(259)).setAttribute("tipo","html" );
      ((Element)v.get(259)).setAttribute("estado","false" );
      ((Element)v.get(259)).setAttribute("cod","1649" );
      ((Element)v.get(259)).setAttribute("ontab","focalizaLista(0, 'listado1', 'comboTipoDocId');" );
      ((Element)v.get(259)).setAttribute("onshtab","volver();" );
      ((Element)v.get(259)).setAttribute("accion","volver();" );
      ((Element)v.get(257)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:260 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).setAttribute("width","8" );
      ((Element)v.get(261)).setAttribute("height","12" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:250   */

      /* Empieza nodo:262 / Elemento padre: 236   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(236)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).setAttribute("width","12" );
      ((Element)v.get(263)).setAttribute("align","center" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).setAttribute("width","12" );
      ((Element)v.get(264)).setAttribute("height","12" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 262   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).setAttribute("width","750" );
      ((Element)v.get(262)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 262   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).setAttribute("width","12" );
      ((Element)v.get(262)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","12" );
      ((Element)v.get(268)).setAttribute("height","1" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:262   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:5   */


   }

}

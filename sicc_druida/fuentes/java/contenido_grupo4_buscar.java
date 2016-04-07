
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_grupo4_buscar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_grupo4_buscar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","buscar Clientes" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","buscar Clientes" );
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
      ((Element)v.get(2)).setAttribute("src","contenido_grupo4_buscar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(3)).setAttribute("nombre","frmUnico" );
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
      ((Element)v.get(5)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","clasOid" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","clasDesc" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","clasTipoClas" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","nameComboSelected" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","valueComboSelected" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","nameComboSelectedTipo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","valueComboSelectedTipo" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","nameComboSelectedSubtipo" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","valueComboSelectedSubtipo" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hiddenTipoCliente" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hiddenSubTipoCliente" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hidCriterioBusqueda1" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hidCriterioBusqueda2" );
      ((Element)v.get(21)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(3)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hidTipoSubtipo" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hidtextCodCliente" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hidcbTipoDocId" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hidtextNDocId" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hidrbDocPrincipal" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidcbPersonaCliente" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hidIndActivo" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hidtextApellido1" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hidtextApellido2" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hidtextApellidoCasada" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hidtextNombre1" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hidtextNombre2" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hidcbTratamiento" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hidrbSexo" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hidcbFormaPago" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hidtextFechaNacimiento" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hidtextCodEmpleado" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hidcbNacionalidad" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hidcbEstadoCivil" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hidtextOcupacion" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hidtextProfesion" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hidtextCentroTrabajo" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(44)).setAttribute("nombre","hidtextCargoDesempena" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hidcbNivelEstudios" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hidtextCentroEstudios" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hidtextNHijos" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hidtextNPersonasDependientes" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hidcbNivelSocioEconomico" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hidcbCicloVidaFamiliar" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hidrbDeseaCorrespondencia" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hidtextImporteIngresoFamiliar" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hidcbPaisVinculo" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hidtextClienteVinculo" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hidcbTipoVinculo" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hidtextFechaD" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","hidtextFechaH" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","hidrbVinculoPrincipal" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hidcb" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hidtextDescripcion" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","hidcbPaisContactado" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","hidtextCodClienteContactado" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","hidcbTipoClienteContactado" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","hidcbCodTipoContactado" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","hidtextFechaContacto" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","hidtextFecha1PedidoContacto" );
      ((Element)v.get(66)).setAttribute("valor","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(3)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","hidtextFechaSiguienteContacto" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","hidtxtFechaIngresoActual" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","hidcbMarcaContacto" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","hidcbCanalContacto" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","hidcbPeriodoPrimerPedido" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","hidcbTipoDireccion" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","hidcbTipoVia" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","hidtextNombreVia" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","hidtextNPrincipal" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","hidtextCodPostal" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","hidtextInterior" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","hidtextManzana" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","hidtextLote" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","hidtextKm" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","hidrbDireccionPrincipal" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","hidtextObservaciones" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","hidcbTipoComunicacion" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","hidcbDiaComunicacion" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","hidrbComunicacionPrincipal" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","hidtextHoraDesde" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","hidtextHoraHasta" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","hidcbIntervaloComunicacion" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(89)).setAttribute("nombre","hidtextTextoComunicacion" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(90)).setAttribute("nombre","hidcbMarca" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(91)).setAttribute("nombre","hidcbVia" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(92)).setAttribute("nombre","hidcbTipoTarjeta" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(93)).setAttribute("nombre","hidcbClasesTarjeta" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(94)).setAttribute("nombre","hidcbEntidadBancaria" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(95)).setAttribute("nombre","hidcbMarcaPestanya4" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(96)).setAttribute("nombre","hidcbCanal" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(97)).setAttribute("nombre","hidcbTipoClasificacion" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(98)).setAttribute("nombre","hidcbTipoProblema" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(99)).setAttribute("nombre","hidrbSolucion" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(100)).setAttribute("nombre","hidcbTipoSolucion" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(101)).setAttribute("nombre","hidtextDescripcionProblema" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(102)).setAttribute("nombre","hidtextDescripcionSolucion" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(103)).setAttribute("nombre","hidcbClasificacion" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(104)).setAttribute("nombre","hidtextNegocioProducto" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(105)).setAttribute("nombre","ListaComboClasificacion" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(106)).setAttribute("nombre","hCadenaParams" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 3   */
      v.add(doc.createElement("table"));
      ((Element)v.get(107)).setAttribute("width","100%" );
      ((Element)v.get(107)).setAttribute("height","100%" );
      ((Element)v.get(107)).setAttribute("border","0" );
      ((Element)v.get(107)).setAttribute("align","center" );
      ((Element)v.get(107)).setAttribute("cellpadding","0" );
      ((Element)v.get(107)).setAttribute("cellspacing","0" );
      ((Element)v.get(107)).setAttribute("class","menu4" );
      ((Element)v.get(3)).appendChild((Element)v.get(107));

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
   }

   private void getXML450(Document doc) {
      ((Element)v.get(110)).setAttribute("height","30" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("nowrap","nowrap" );
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
      ((Element)v.get(115)).setAttribute("width","92" );
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
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(117)).setAttribute("align","center" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(118)).setAttribute("class","menu5textoblanca" );
      ((Element)v.get(118)).setAttribute("onclick","siguientePestanya(-1)" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(119)).setAttribute("nombre","lblPesCriterios" );
      ((Element)v.get(119)).setAttribute("alto","13" );
      ((Element)v.get(119)).setAttribute("filas","1" );
      ((Element)v.get(119)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(119)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(119)).setAttribute("cod","0075" );
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
      ((Element)v.get(125)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(125)).setAttribute("onclick","siguientePestanya(0)" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(126)).setAttribute("nombre","lblPesTipoSubtipo" );
      ((Element)v.get(126)).setAttribute("alto","13" );
      ((Element)v.get(126)).setAttribute("filas","1" );
      ((Element)v.get(126)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(126)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(126)).setAttribute("cod","00519" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:127 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("width","10" );
      ((Element)v.get(127)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","10" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","20" );
      ((Element)v.get(129)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(129)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("table"));
      ((Element)v.get(130)).setAttribute("width","75" );
      ((Element)v.get(130)).setAttribute("border","1" );
      ((Element)v.get(130)).setAttribute("align","center" );
      ((Element)v.get(130)).setAttribute("cellpadding","1" );
      ((Element)v.get(130)).setAttribute("cellspacing","0" );
      ((Element)v.get(130)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(131)).setAttribute("align","center" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(132)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(132)).setAttribute("onclick","siguientePestanya(1)" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(133)).setAttribute("nombre","lblPes1" );
      ((Element)v.get(133)).setAttribute("alto","13" );
      ((Element)v.get(133)).setAttribute("filas","1" );
      ((Element)v.get(133)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(133)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(133)).setAttribute("cod","00515" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:134 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("width","10" );
      ((Element)v.get(134)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","10" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("width","20" );
      ((Element)v.get(136)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(136)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("table"));
      ((Element)v.get(137)).setAttribute("width","75" );
      ((Element)v.get(137)).setAttribute("border","1" );
      ((Element)v.get(137)).setAttribute("align","center" );
      ((Element)v.get(137)).setAttribute("cellpadding","1" );
      ((Element)v.get(137)).setAttribute("cellspacing","0" );
      ((Element)v.get(137)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(138)).setAttribute("align","center" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(139)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(139)).setAttribute("onclick","siguientePestanya(2)" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(140)).setAttribute("nombre","lblPes2" );
      ((Element)v.get(140)).setAttribute("alto","13" );
      ((Element)v.get(140)).setAttribute("filas","1" );
      ((Element)v.get(140)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(140)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(140)).setAttribute("cod","00516" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:141 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("width","10" );
      ((Element)v.get(141)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","10" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("width","20" );
      ((Element)v.get(143)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(143)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(144)).setAttribute("width","75" );
      ((Element)v.get(144)).setAttribute("border","1" );
      ((Element)v.get(144)).setAttribute("align","center" );
      ((Element)v.get(144)).setAttribute("cellpadding","1" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(144)).setAttribute("cellspacing","0" );
      ((Element)v.get(144)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).setAttribute("align","center" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(146)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(146)).setAttribute("onclick","siguientePestanya(3)" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(147)).setAttribute("nombre","lblPes3" );
      ((Element)v.get(147)).setAttribute("alto","13" );
      ((Element)v.get(147)).setAttribute("filas","1" );
      ((Element)v.get(147)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(147)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(147)).setAttribute("cod","00517" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:148 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("width","10" );
      ((Element)v.get(148)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","10" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("width","20" );
      ((Element)v.get(150)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(150)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("table"));
      ((Element)v.get(151)).setAttribute("width","75" );
      ((Element)v.get(151)).setAttribute("border","1" );
      ((Element)v.get(151)).setAttribute("align","center" );
      ((Element)v.get(151)).setAttribute("cellpadding","1" );
      ((Element)v.get(151)).setAttribute("cellspacing","0" );
      ((Element)v.get(151)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(151)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).setAttribute("align","center" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(153)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(154)).setAttribute("nombre","lblPes4" );
      ((Element)v.get(154)).setAttribute("alto","13" );
      ((Element)v.get(154)).setAttribute("filas","1" );
      ((Element)v.get(154)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(154)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(154)).setAttribute("cod","00518" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:155 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("width","16" );
      ((Element)v.get(155)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","12" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:157 / Elemento padre: 3   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(157)).setAttribute("nombre","capaUnica" );
      ((Element)v.get(157)).setAttribute("alto","500" );
      ((Element)v.get(157)).setAttribute("ancho","100%" );
      ((Element)v.get(3)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("table"));
      ((Element)v.get(158)).setAttribute("width","100%" );
      ((Element)v.get(158)).setAttribute("border","0" );
      ((Element)v.get(158)).setAttribute("cellspacing","0" );
      ((Element)v.get(158)).setAttribute("cellpadding","0" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("width","12" );
      ((Element)v.get(160)).setAttribute("align","center" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","12" );
      ((Element)v.get(161)).setAttribute("height","12" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("width","750" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(159)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("width","12" );
      ((Element)v.get(159)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","12" );
      ((Element)v.get(165)).setAttribute("height","1" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:159   */

      /* Empieza nodo:166 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(171)).setAttribute("class","legend" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(172)).setAttribute("nombre","lblTitGrupoTarjetas" );
      ((Element)v.get(172)).setAttribute("alto","13" );
      ((Element)v.get(172)).setAttribute("filas","1" );
      ((Element)v.get(172)).setAttribute("valor","" );
      ((Element)v.get(172)).setAttribute("cod","0058" );
      ((Element)v.get(172)).setAttribute("id","legend" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 170   */
      v.add(doc.createElement("table"));
      ((Element)v.get(173)).setAttribute("width","100%" );
      ((Element)v.get(173)).setAttribute("border","0" );
      ((Element)v.get(173)).setAttribute("align","center" );
      ((Element)v.get(173)).setAttribute("cellspacing","0" );
      ((Element)v.get(173)).setAttribute("cellpadding","0" );
      ((Element)v.get(170)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).setAttribute("colspan","4" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:177 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(181)).setAttribute("nombre","lblTipoTarjeta" );
      ((Element)v.get(181)).setAttribute("alto","13" );
      ((Element)v.get(181)).setAttribute("filas","1" );
      ((Element)v.get(181)).setAttribute("valor","" );
      ((Element)v.get(181)).setAttribute("id","datosTitle" );
      ((Element)v.get(181)).setAttribute("cod","1130" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","25" );
      ((Element)v.get(183)).setAttribute("height","8" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(185)).setAttribute("nombre","lblClasesTarjeta" );
      ((Element)v.get(185)).setAttribute("alto","13" );
      ((Element)v.get(185)).setAttribute("filas","1" );
      ((Element)v.get(185)).setAttribute("valor","" );
      ((Element)v.get(185)).setAttribute("id","datosTitle" );
      ((Element)v.get(185)).setAttribute("cod","1057" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","25" );
      ((Element)v.get(187)).setAttribute("height","8" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(189)).setAttribute("nombre","lblEntidadBancaria" );
      ((Element)v.get(189)).setAttribute("alto","13" );
      ((Element)v.get(189)).setAttribute("filas","1" );
      ((Element)v.get(189)).setAttribute("valor","" );
      ((Element)v.get(189)).setAttribute("id","datosTitle" );
      ((Element)v.get(189)).setAttribute("cod","1075" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("width","100%" );
      ((Element)v.get(177)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","8" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:177   */

      /* Empieza nodo:192 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","8" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(192)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(196)).setAttribute("nombre","cbTipoTarjeta" );
      ((Element)v.get(196)).setAttribute("id","datosCampos" );
      ((Element)v.get(196)).setAttribute("size","1" );
      ((Element)v.get(196)).setAttribute("multiple","N" );
      ((Element)v.get(196)).setAttribute("req","N" );
      ((Element)v.get(196)).setAttribute("valorinicial","" );
      ((Element)v.get(196)).setAttribute("textoinicial","" );
      ((Element)v.get(196)).setAttribute("onshtab","siguientePestanya(3);" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:198 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).setAttribute("width","25" );
      ((Element)v.get(199)).setAttribute("height","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(192)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(201)).setAttribute("nombre","cbClasesTarjeta" );
      ((Element)v.get(201)).setAttribute("id","datosCampos" );
      ((Element)v.get(201)).setAttribute("size","1" );
      ((Element)v.get(201)).setAttribute("multiple","N" );
      ((Element)v.get(201)).setAttribute("req","N" );
      ((Element)v.get(201)).setAttribute("valorinicial","" );
      ((Element)v.get(201)).setAttribute("textoinicial","" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:203 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","25" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(192)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(206)).setAttribute("nombre","cbEntidadBancaria" );
      ((Element)v.get(206)).setAttribute("id","datosCampos" );
      ((Element)v.get(206)).setAttribute("size","1" );
      ((Element)v.get(206)).setAttribute("multiple","N" );
      ((Element)v.get(206)).setAttribute("req","N" );
      ((Element)v.get(206)).setAttribute("valorinicial","" );
      ((Element)v.get(206)).setAttribute("textoinicial","" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:208 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("width","100%" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(192)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:192   */

      /* Empieza nodo:210 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).setAttribute("colspan","4" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","8" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:173   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:213 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","8" );
      ((Element)v.get(214)).setAttribute("height","12" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:166   */

      /* Empieza nodo:215 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).setAttribute("width","12" );
      ((Element)v.get(216)).setAttribute("align","center" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(217)).setAttribute("width","12" );
      ((Element)v.get(217)).setAttribute("height","15" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).setAttribute("width","750" );
      ((Element)v.get(215)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).setAttribute("width","12" );
      ((Element)v.get(215)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","12" );
      ((Element)v.get(221)).setAttribute("height","15" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:215   */

      /* Empieza nodo:222 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(227)).setAttribute("class","legend" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(228)).setAttribute("nombre","lblTitClasificacion" );
      ((Element)v.get(228)).setAttribute("alto","13" );
      ((Element)v.get(228)).setAttribute("filas","1" );
      ((Element)v.get(228)).setAttribute("valor","" );
      ((Element)v.get(228)).setAttribute("cod","0059" );
      ((Element)v.get(228)).setAttribute("id","legend" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 226   */
      v.add(doc.createElement("table"));
      ((Element)v.get(229)).setAttribute("width","100%" );
      ((Element)v.get(229)).setAttribute("border","0" );
      ((Element)v.get(229)).setAttribute("align","center" );
      ((Element)v.get(229)).setAttribute("cellspacing","0" );
      ((Element)v.get(229)).setAttribute("cellpadding","0" );
      ((Element)v.get(226)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).setAttribute("colspan","4" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","8" );
      ((Element)v.get(232)).setAttribute("height","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:233 / Elemento padre: 229   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(229)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","8" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(233)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(237)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(237)).setAttribute("alto","13" );
      ((Element)v.get(237)).setAttribute("filas","1" );
      ((Element)v.get(237)).setAttribute("valor","" );
      ((Element)v.get(237)).setAttribute("id","datosTitle" );
      ((Element)v.get(237)).setAttribute("cod","6" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(233)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(239)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).setAttribute("width","25" );
      ((Element)v.get(239)).setAttribute("height","8" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(233)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(241)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(241)).setAttribute("alto","13" );
      ((Element)v.get(241)).setAttribute("filas","1" );
      ((Element)v.get(241)).setAttribute("valor","" );
      ((Element)v.get(241)).setAttribute("id","datosTitle" );
      ((Element)v.get(241)).setAttribute("cod","7" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).setAttribute("width","100%" );
      ((Element)v.get(233)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","8" );
      ((Element)v.get(243)).setAttribute("height","8" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:233   */

      /* Empieza nodo:244 / Elemento padre: 229   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(229)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("width","8" );
      ((Element)v.get(246)).setAttribute("height","8" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(244)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(248)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(248)).setAttribute("id","datosCampos" );
      ((Element)v.get(248)).setAttribute("size","1" );
      ((Element)v.get(248)).setAttribute("multiple","N" );
      ((Element)v.get(248)).setAttribute("req","N" );
      ((Element)v.get(248)).setAttribute("valorinicial","" );
      ((Element)v.get(248)).setAttribute("textoinicial","" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:250 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","25" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(244)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(253)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(253)).setAttribute("id","datosCampos" );
      ((Element)v.get(253)).setAttribute("size","1" );
      ((Element)v.get(253)).setAttribute("multiple","N" );
      ((Element)v.get(253)).setAttribute("req","N" );
      ((Element)v.get(253)).setAttribute("valorinicial","" );
      ((Element)v.get(253)).setAttribute("textoinicial","" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:255 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).setAttribute("width","100%" );
      ((Element)v.get(244)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(256)).setAttribute("width","8" );
      ((Element)v.get(256)).setAttribute("height","8" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:244   */

      /* Empieza nodo:257 / Elemento padre: 229   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(229)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).setAttribute("colspan","4" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","8" );
      ((Element)v.get(259)).setAttribute("height","8" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:229   */

      /* Empieza nodo:260 / Elemento padre: 226   */
      v.add(doc.createElement("table"));
      ((Element)v.get(260)).setAttribute("width","100%" );
      ((Element)v.get(260)).setAttribute("border","0" );
      ((Element)v.get(260)).setAttribute("align","center" );
      ((Element)v.get(260)).setAttribute("cellspacing","0" );
      ((Element)v.get(260)).setAttribute("cellpadding","0" );
      ((Element)v.get(226)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","8" );
      ((Element)v.get(263)).setAttribute("height","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(265)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(265)).setAttribute("alto","13" );
      ((Element)v.get(265)).setAttribute("filas","1" );
      ((Element)v.get(265)).setAttribute("valor","" );
      ((Element)v.get(265)).setAttribute("id","datosTitle" );
      ((Element)v.get(265)).setAttribute("cod","1869" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(267)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).setAttribute("width","25" );
      ((Element)v.get(267)).setAttribute("height","8" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(269)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(269)).setAttribute("alto","13" );
      ((Element)v.get(269)).setAttribute("filas","1" );
      ((Element)v.get(269)).setAttribute("valor","" );
      ((Element)v.get(269)).setAttribute("id","datosTitle" );
      ((Element)v.get(269)).setAttribute("cod","595" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).setAttribute("width","100%" );
      ((Element)v.get(261)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","8" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:261   */

      /* Empieza nodo:272 / Elemento padre: 260   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(260)).appendChild((Element)v.get(272));

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
      ((Element)v.get(272)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(276)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(276)).setAttribute("valorinicial","" );
      ((Element)v.get(276)).setAttribute("req","N" );
      ((Element)v.get(276)).setAttribute("multiple","N" );
      ((Element)v.get(276)).setAttribute("size","1" );
      ((Element)v.get(276)).setAttribute("id","datosCampos" );
      ((Element)v.get(276)).setAttribute("textoinicial","" );
      ((Element)v.get(276)).setAttribute("onchange","onChangeTipo();" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:278 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).setAttribute("width","25" );
      ((Element)v.get(279)).setAttribute("height","8" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(281)).setAttribute("nombre","cbSubtipoCliente" );
      ((Element)v.get(281)).setAttribute("valorinicial","" );
      ((Element)v.get(281)).setAttribute("req","N" );
      ((Element)v.get(281)).setAttribute("multiple","N" );
      ((Element)v.get(281)).setAttribute("size","1" );
      ((Element)v.get(281)).setAttribute("id","datosCampos" );
      ((Element)v.get(281)).setAttribute("textoinicial","" );
      ((Element)v.get(281)).setAttribute("onchange","onChangeSubtipo();" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:283 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).setAttribute("width","100%" );
      ((Element)v.get(272)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","8" );
      ((Element)v.get(284)).setAttribute("height","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */
      /* Termina nodo:272   */

      /* Empieza nodo:285 / Elemento padre: 260   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(260)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).setAttribute("colspan","4" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(287)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).setAttribute("width","8" );
      ((Element)v.get(287)).setAttribute("height","8" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:260   */

      /* Empieza nodo:288 / Elemento padre: 226   */
      v.add(doc.createElement("table"));
      ((Element)v.get(288)).setAttribute("width","100%" );
      ((Element)v.get(288)).setAttribute("border","0" );
      ((Element)v.get(288)).setAttribute("align","center" );
      ((Element)v.get(288)).setAttribute("cellspacing","0" );
      ((Element)v.get(288)).setAttribute("cellpadding","0" );
      ((Element)v.get(226)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(288)).appendChild((Element)v.get(289));

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
      ((Element)v.get(289)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(293)).setAttribute("nombre","lblTipoClasificacion" );
      ((Element)v.get(293)).setAttribute("alto","13" );
      ((Element)v.get(293)).setAttribute("filas","1" );
      ((Element)v.get(293)).setAttribute("valor","" );
      ((Element)v.get(293)).setAttribute("id","datosTitle" );
      ((Element)v.get(293)).setAttribute("cod","756" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(295)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).setAttribute("width","25" );
      ((Element)v.get(295)).setAttribute("height","8" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(297)).setAttribute("nombre","lblClasificacion" );
      ((Element)v.get(297)).setAttribute("alto","13" );
      ((Element)v.get(297)).setAttribute("filas","1" );
      ((Element)v.get(297)).setAttribute("valor","" );
      ((Element)v.get(297)).setAttribute("id","datosTitle" );
      ((Element)v.get(297)).setAttribute("cod","550" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:298 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).setAttribute("width","100%" );
      ((Element)v.get(289)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(299)).setAttribute("src","b.gif" );
      ((Element)v.get(299)).setAttribute("width","8" );
      ((Element)v.get(299)).setAttribute("height","8" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:289   */

      /* Empieza nodo:300 / Elemento padre: 288   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(288)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
   }

   private void getXML1260(Document doc) {
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
      ((Element)v.get(303)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(300)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(304)).setAttribute("nombre","cbTipoClasificacion" );
      ((Element)v.get(304)).setAttribute("onchange","onChangeTipoClasificacion();" );
      ((Element)v.get(304)).setAttribute("id","datosCampos" );
      ((Element)v.get(304)).setAttribute("size","1" );
      ((Element)v.get(304)).setAttribute("multiple","N" );
      ((Element)v.get(304)).setAttribute("req","N" );
      ((Element)v.get(304)).setAttribute("valorinicial","" );
      ((Element)v.get(304)).setAttribute("textoinicial","" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:306 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
      ((Element)v.get(307)).setAttribute("width","25" );
      ((Element)v.get(307)).setAttribute("height","8" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(300)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(309)).setAttribute("nombre","cbClasificacion" );
      ((Element)v.get(309)).setAttribute("id","datosCampos" );
      ((Element)v.get(309)).setAttribute("size","1" );
      ((Element)v.get(309)).setAttribute("multiple","N" );
      ((Element)v.get(309)).setAttribute("req","N" );
      ((Element)v.get(309)).setAttribute("valorinicial","" );
      ((Element)v.get(309)).setAttribute("textoinicial","" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:311 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).setAttribute("width","100%" );
      ((Element)v.get(300)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("width","8" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */
      /* Termina nodo:300   */

      /* Empieza nodo:313 / Elemento padre: 288   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(288)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("td"));
      ((Element)v.get(314)).setAttribute("colspan","4" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(315)).setAttribute("width","8" );
      ((Element)v.get(315)).setAttribute("height","8" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */
      /* Termina nodo:313   */
      /* Termina nodo:288   */
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:316 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(317)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).setAttribute("width","8" );
      ((Element)v.get(317)).setAttribute("height","12" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */
      /* Termina nodo:222   */

      /* Empieza nodo:318 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).setAttribute("width","12" );
      ((Element)v.get(319)).setAttribute("align","center" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).setAttribute("width","12" );
      ((Element)v.get(320)).setAttribute("height","15" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:321 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).setAttribute("width","750" );
      ((Element)v.get(318)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(322)).setAttribute("src","b.gif" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:323 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).setAttribute("width","12" );
      ((Element)v.get(318)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(324)).setAttribute("src","b.gif" );
      ((Element)v.get(324)).setAttribute("width","12" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(324)).setAttribute("height","15" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */
      /* Termina nodo:318   */

      /* Empieza nodo:325 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(327)).setAttribute("src","b.gif" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(325)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(330)).setAttribute("class","legend" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(331)).setAttribute("nombre","lblTitGrupoProblemasSoluciones" );
      ((Element)v.get(331)).setAttribute("alto","13" );
      ((Element)v.get(331)).setAttribute("filas","1" );
      ((Element)v.get(331)).setAttribute("valor","" );
      ((Element)v.get(331)).setAttribute("cod","0060" );
      ((Element)v.get(331)).setAttribute("id","legend" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 329   */
      v.add(doc.createElement("table"));
      ((Element)v.get(332)).setAttribute("width","100%" );
      ((Element)v.get(332)).setAttribute("border","0" );
      ((Element)v.get(332)).setAttribute("align","center" );
      ((Element)v.get(332)).setAttribute("cellspacing","0" );
      ((Element)v.get(332)).setAttribute("cellpadding","0" );
      ((Element)v.get(329)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).setAttribute("colspan","4" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(335)).setAttribute("src","b.gif" );
      ((Element)v.get(335)).setAttribute("width","8" );
      ((Element)v.get(335)).setAttribute("height","8" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:336 / Elemento padre: 332   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(332)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("td"));
      ((Element)v.get(336)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","8" );
      ((Element)v.get(338)).setAttribute("height","8" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 336   */
      v.add(doc.createElement("td"));
      ((Element)v.get(336)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(340)).setAttribute("nombre","lblTipoProblema" );
      ((Element)v.get(340)).setAttribute("alto","13" );
      ((Element)v.get(340)).setAttribute("filas","1" );
      ((Element)v.get(340)).setAttribute("valor","" );
      ((Element)v.get(340)).setAttribute("id","datosTitle" );
      ((Element)v.get(340)).setAttribute("cod","1128" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 336   */
      v.add(doc.createElement("td"));
      ((Element)v.get(336)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","25" );
      ((Element)v.get(342)).setAttribute("height","8" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 336   */
      v.add(doc.createElement("td"));
      ((Element)v.get(336)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(344)).setAttribute("nombre","lblSolucion" );
      ((Element)v.get(344)).setAttribute("alto","13" );
      ((Element)v.get(344)).setAttribute("filas","1" );
      ((Element)v.get(344)).setAttribute("valor","" );
      ((Element)v.get(344)).setAttribute("id","datosTitle" );
      ((Element)v.get(344)).setAttribute("cod","1123" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 336   */
      v.add(doc.createElement("td"));
      ((Element)v.get(336)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(346)).setAttribute("src","b.gif" );
      ((Element)v.get(346)).setAttribute("width","25" );
      ((Element)v.get(346)).setAttribute("height","8" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 336   */
      v.add(doc.createElement("td"));
      ((Element)v.get(336)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(348)).setAttribute("nombre","lblTipoSolucion" );
      ((Element)v.get(348)).setAttribute("alto","13" );
      ((Element)v.get(348)).setAttribute("filas","1" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(348)).setAttribute("valor","" );
      ((Element)v.get(348)).setAttribute("id","datosTitle" );
      ((Element)v.get(348)).setAttribute("cod","1129" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 336   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).setAttribute("width","100%" );
      ((Element)v.get(336)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(350)).setAttribute("src","b.gif" );
      ((Element)v.get(350)).setAttribute("width","8" );
      ((Element)v.get(350)).setAttribute("height","8" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */
      /* Termina nodo:336   */

      /* Empieza nodo:351 / Elemento padre: 332   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(332)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(353)).setAttribute("src","b.gif" );
      ((Element)v.get(353)).setAttribute("width","8" );
      ((Element)v.get(353)).setAttribute("height","8" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:354 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(354)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(351)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(355)).setAttribute("nombre","cbTipoProblema" );
      ((Element)v.get(355)).setAttribute("id","datosCampos" );
      ((Element)v.get(355)).setAttribute("size","1" );
      ((Element)v.get(355)).setAttribute("multiple","N" );
      ((Element)v.get(355)).setAttribute("req","N" );
      ((Element)v.get(355)).setAttribute("valorinicial","" );
      ((Element)v.get(355)).setAttribute("textoinicial","" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:357 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(358)).setAttribute("src","b.gif" );
      ((Element)v.get(358)).setAttribute("width","25" );
      ((Element)v.get(358)).setAttribute("height","8" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */

      /* Empieza nodo:359 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(359)).setAttribute("class","datosCampos" );
      ((Element)v.get(351)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(360)).setAttribute("nombre","rbSolucion" );
      ((Element)v.get(360)).setAttribute("tipo","H" );
      ((Element)v.get(360)).setAttribute("id","datosCampos" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(361)).setAttribute("valor","S" );
      ((Element)v.get(361)).setAttribute("check","N" );
      ((Element)v.get(361)).setAttribute("onfocus","" );
      ((Element)v.get(361)).setAttribute("id","datosCampos" );
      ((Element)v.get(361)).setAttribute("cod","117" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));

      /* Elemento padre:361 / Elemento actual: 362   */
      v.add(doc.createTextNode("yy"));
      ((Element)v.get(361)).appendChild((Text)v.get(362));

      /* Termina nodo Texto:362   */
      /* Termina nodo:361   */

      /* Empieza nodo:363 / Elemento padre: 360   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(363)).setAttribute("valor","N" );
      ((Element)v.get(363)).setAttribute("check","N" );
      ((Element)v.get(363)).setAttribute("onfocus","" );
      ((Element)v.get(363)).setAttribute("id","datosCampos" );
      ((Element)v.get(363)).setAttribute("cod","87" );
      ((Element)v.get(360)).appendChild((Element)v.get(363));

      /* Elemento padre:363 / Elemento actual: 364   */
      v.add(doc.createTextNode("nn"));
      ((Element)v.get(363)).appendChild((Text)v.get(364));

      /* Termina nodo Texto:364   */
      /* Termina nodo:363   */
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:365 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(366)).setAttribute("src","b.gif" );
      ((Element)v.get(366)).setAttribute("width","25" );
      ((Element)v.get(366)).setAttribute("height","8" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:367 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(351)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(368)).setAttribute("nombre","cbTipoSolucion" );
      ((Element)v.get(368)).setAttribute("id","datosCampos" );
      ((Element)v.get(368)).setAttribute("size","1" );
      ((Element)v.get(368)).setAttribute("multiple","N" );
      ((Element)v.get(368)).setAttribute("req","N" );
      ((Element)v.get(368)).setAttribute("valorinicial","" );
      ((Element)v.get(368)).setAttribute("textoinicial","" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:367   */

      /* Empieza nodo:370 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(370)).setAttribute("width","100%" );
      ((Element)v.get(351)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).setAttribute("width","8" );
      ((Element)v.get(371)).setAttribute("height","8" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:351   */

      /* Empieza nodo:372 / Elemento padre: 332   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(332)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(373)).setAttribute("colspan","4" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(374)).setAttribute("src","b.gif" );
      ((Element)v.get(374)).setAttribute("width","8" );
      ((Element)v.get(374)).setAttribute("height","8" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */
      /* Termina nodo:372   */
      /* Termina nodo:332   */

      /* Empieza nodo:375 / Elemento padre: 329   */
      v.add(doc.createElement("table"));
      ((Element)v.get(375)).setAttribute("width","100%" );
      ((Element)v.get(375)).setAttribute("border","0" );
      ((Element)v.get(375)).setAttribute("align","center" );
      ((Element)v.get(375)).setAttribute("cellspacing","0" );
      ((Element)v.get(375)).setAttribute("cellpadding","0" );
      ((Element)v.get(329)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(375)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("td"));
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(378)).setAttribute("src","b.gif" );
      ((Element)v.get(378)).setAttribute("width","8" );
      ((Element)v.get(378)).setAttribute("height","8" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 376   */
      v.add(doc.createElement("td"));
      ((Element)v.get(376)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(380)).setAttribute("nombre","lblDescripcionProblema" );
      ((Element)v.get(380)).setAttribute("alto","13" );
      ((Element)v.get(380)).setAttribute("filas","1" );
      ((Element)v.get(380)).setAttribute("valor","" );
      ((Element)v.get(380)).setAttribute("id","datosTitle" );
      ((Element)v.get(380)).setAttribute("cod","1067" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 376   */
      v.add(doc.createElement("td"));
      ((Element)v.get(376)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(382)).setAttribute("src","b.gif" );
      ((Element)v.get(382)).setAttribute("width","25" );
      ((Element)v.get(382)).setAttribute("height","8" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:383 / Elemento padre: 376   */
      v.add(doc.createElement("td"));
      ((Element)v.get(376)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(384)).setAttribute("nombre","lblDescripcionSolucion" );
      ((Element)v.get(384)).setAttribute("alto","13" );
      ((Element)v.get(384)).setAttribute("filas","1" );
      ((Element)v.get(384)).setAttribute("valor","" );
      ((Element)v.get(384)).setAttribute("id","datosTitle" );
      ((Element)v.get(384)).setAttribute("cod","1069" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */

      /* Empieza nodo:385 / Elemento padre: 376   */
      v.add(doc.createElement("td"));
      ((Element)v.get(385)).setAttribute("width","100%" );
      ((Element)v.get(376)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(386)).setAttribute("src","b.gif" );
      ((Element)v.get(386)).setAttribute("width","8" );
      ((Element)v.get(386)).setAttribute("height","8" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */
      /* Termina nodo:385   */
      /* Termina nodo:376   */

      /* Empieza nodo:387 / Elemento padre: 375   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(375)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(389)).setAttribute("src","b.gif" );
      ((Element)v.get(389)).setAttribute("width","8" );
      ((Element)v.get(389)).setAttribute("height","8" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:390 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(390)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(387)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(391)).setAttribute("cols","50" );
      ((Element)v.get(391)).setAttribute("id","datosCampos" );
      ((Element)v.get(391)).setAttribute("nombre","textDescripcionProblema" );
      ((Element)v.get(391)).setAttribute("readonly","N" );
      ((Element)v.get(391)).setAttribute("req","N" );
      ((Element)v.get(391)).setAttribute("rows","3" );
      ((Element)v.get(391)).setAttribute("tabindex","2" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(387)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(393)).setAttribute("src","b.gif" );
      ((Element)v.get(393)).setAttribute("width","25" );
      ((Element)v.get(393)).setAttribute("height","8" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:394 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(394)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(387)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(395)).setAttribute("cols","50" );
      ((Element)v.get(395)).setAttribute("id","datosCampos" );
      ((Element)v.get(395)).setAttribute("nombre","textDescripcionSolucion" );
      ((Element)v.get(395)).setAttribute("readonly","N" );
      ((Element)v.get(395)).setAttribute("req","N" );
      ((Element)v.get(395)).setAttribute("rows","3" );
      ((Element)v.get(395)).setAttribute("tabindex","2" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(396)).setAttribute("width","100%" );
      ((Element)v.get(387)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(397)).setAttribute("width","8" );
      ((Element)v.get(397)).setAttribute("height","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */
      /* Termina nodo:387   */

      /* Empieza nodo:398 / Elemento padre: 375   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(375)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(399)).setAttribute("colspan","4" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(400)).setAttribute("src","b.gif" );
      ((Element)v.get(400)).setAttribute("width","8" );
      ((Element)v.get(400)).setAttribute("height","8" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */
      /* Termina nodo:398   */
      /* Termina nodo:375   */

      /* Empieza nodo:401 / Elemento padre: 329   */
      v.add(doc.createElement("table"));
      ((Element)v.get(401)).setAttribute("width","100%" );
      ((Element)v.get(401)).setAttribute("border","0" );
      ((Element)v.get(401)).setAttribute("align","center" );
      ((Element)v.get(401)).setAttribute("cellspacing","0" );
      ((Element)v.get(401)).setAttribute("cellpadding","0" );
      ((Element)v.get(329)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(401)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(404)).setAttribute("src","b.gif" );
      ((Element)v.get(404)).setAttribute("width","8" );
      ((Element)v.get(404)).setAttribute("height","8" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:405 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(406)).setAttribute("nombre","lblNegocioProducto" );
      ((Element)v.get(406)).setAttribute("alto","13" );
      ((Element)v.get(406)).setAttribute("filas","1" );
      ((Element)v.get(406)).setAttribute("valor","" );
      ((Element)v.get(406)).setAttribute("id","datosTitle" );
      ((Element)v.get(406)).setAttribute("cod","1096" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:407 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(407)).setAttribute("width","100%" );
      ((Element)v.get(402)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(408)).setAttribute("src","b.gif" );
      ((Element)v.get(408)).setAttribute("width","8" );
      ((Element)v.get(408)).setAttribute("height","8" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */
      /* Termina nodo:402   */

      /* Empieza nodo:409 / Elemento padre: 401   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(401)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("td"));
      ((Element)v.get(409)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(411)).setAttribute("src","b.gif" );
      ((Element)v.get(411)).setAttribute("width","8" );
      ((Element)v.get(411)).setAttribute("height","8" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */

      /* Empieza nodo:412 / Elemento padre: 409   */
      v.add(doc.createElement("td"));
      ((Element)v.get(412)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(409)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(413)).setAttribute("cols","50" );
      ((Element)v.get(413)).setAttribute("id","datosCampos" );
      ((Element)v.get(413)).setAttribute("nombre","textNegocioProducto" );
      ((Element)v.get(413)).setAttribute("readonly","N" );
      ((Element)v.get(413)).setAttribute("req","N" );
      ((Element)v.get(413)).setAttribute("rows","3" );
      ((Element)v.get(413)).setAttribute("tabindex","2" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */

      /* Empieza nodo:414 / Elemento padre: 409   */
      v.add(doc.createElement("td"));
      ((Element)v.get(414)).setAttribute("width","100%" );
      ((Element)v.get(409)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(415)).setAttribute("src","b.gif" );
      ((Element)v.get(415)).setAttribute("width","8" );
      ((Element)v.get(415)).setAttribute("height","8" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */
      /* Termina nodo:414   */
      /* Termina nodo:409   */

      /* Empieza nodo:416 / Elemento padre: 401   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(401)).appendChild((Element)v.get(416));

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
      /* Termina nodo:401   */
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:419 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(325)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(420)).setAttribute("src","b.gif" );
      ((Element)v.get(420)).setAttribute("width","8" );
      ((Element)v.get(420)).setAttribute("height","12" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:419   */
      /* Termina nodo:325   */

      /* Empieza nodo:421 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("td"));
      ((Element)v.get(421)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(423)).setAttribute("src","b.gif" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */

      /* Empieza nodo:424 / Elemento padre: 421   */
      v.add(doc.createElement("td"));
      ((Element)v.get(421)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(424)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("table"));
      ((Element)v.get(426)).setAttribute("width","100%" );
      ((Element)v.get(426)).setAttribute("border","0" );
      ((Element)v.get(426)).setAttribute("align","center" );
      ((Element)v.get(426)).setAttribute("cellspacing","0" );
      ((Element)v.get(426)).setAttribute("cellpadding","0" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(426)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("td"));
      ((Element)v.get(428)).setAttribute("class","botonera" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(429)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(429)).setAttribute("ID","botonContenido" );
      ((Element)v.get(429)).setAttribute("tipo","html" );
      ((Element)v.get(429)).setAttribute("accion","busca();" );
      ((Element)v.get(429)).setAttribute("ontab","siguientePestanya(-1);" );
      ((Element)v.get(429)).setAttribute("estado","false" );
      ((Element)v.get(429)).setAttribute("cod","1" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:428   */
      /* Termina nodo:427   */
      /* Termina nodo:426   */
      /* Termina nodo:425   */
      /* Termina nodo:424   */

      /* Empieza nodo:430 / Elemento padre: 421   */
      v.add(doc.createElement("td"));
      ((Element)v.get(421)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(431)).setAttribute("src","b.gif" );
      ((Element)v.get(431)).setAttribute("width","8" );
      ((Element)v.get(431)).setAttribute("height","12" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:430   */
      /* Termina nodo:421   */

      /* Empieza nodo:432 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("td"));
      ((Element)v.get(433)).setAttribute("width","12" );
      ((Element)v.get(433)).setAttribute("align","center" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(434)).setAttribute("src","b.gif" );
      ((Element)v.get(434)).setAttribute("width","12" );
      ((Element)v.get(434)).setAttribute("height","12" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:435 / Elemento padre: 432   */
      v.add(doc.createElement("td"));
      ((Element)v.get(435)).setAttribute("width","750" );
      ((Element)v.get(432)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(436)).setAttribute("src","b.gif" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */
      /* Termina nodo:435   */

      /* Empieza nodo:437 / Elemento padre: 432   */
      v.add(doc.createElement("td"));
      ((Element)v.get(437)).setAttribute("width","12" );
      ((Element)v.get(432)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(438)).setAttribute("src","b.gif" );
      ((Element)v.get(438)).setAttribute("width","12" );
      ((Element)v.get(438)).setAttribute("height","12" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:437   */
      /* Termina nodo:432   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:439 / Elemento padre: 3   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(439)).setAttribute("nombre","capaSubtipo" );
      ((Element)v.get(439)).setAttribute("alto","10" );
      ((Element)v.get(439)).setAttribute("ancho","10" );
      ((Element)v.get(439)).setAttribute("colorf","" );
      ((Element)v.get(439)).setAttribute("borde","1" );
      ((Element)v.get(439)).setAttribute("imagenf","" );
      ((Element)v.get(439)).setAttribute("repeat","" );
      ((Element)v.get(439)).setAttribute("padding","" );
      ((Element)v.get(439)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(439)).setAttribute("contravsb","" );
      ((Element)v.get(439)).setAttribute("zindex","" );
      ((Element)v.get(439)).setAttribute("x","10" );
      ((Element)v.get(439)).setAttribute("y","10" );
      ((Element)v.get(3)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(440)).setAttribute("seleccion","boton" );
      ((Element)v.get(440)).setAttribute("nombre","listaSubtipos" );
      ((Element)v.get(440)).setAttribute("ancho","582" );
      ((Element)v.get(440)).setAttribute("alto","150" );
      ((Element)v.get(440)).setAttribute("multisel","-1" );
      ((Element)v.get(440)).setAttribute("incy","1" );
      ((Element)v.get(440)).setAttribute("incx","10" );
      ((Element)v.get(440)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(440)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(440)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(440)).setAttribute("accion","" );
      ((Element)v.get(440)).setAttribute("sep","|" );
      ((Element)v.get(440)).setAttribute("pixelsborde","3" );
      ((Element)v.get(440)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(441)).setAttribute("nombre","cabecera" );
      ((Element)v.get(441)).setAttribute("height","20" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(442)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(442)).setAttribute("ancho","13" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */

      /* Empieza nodo:443 / Elemento padre: 441   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(443)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(443)).setAttribute("ancho","300" );
      ((Element)v.get(441)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(444)).setAttribute("nombre","lbDivisionesPoliticas" );
      ((Element)v.get(444)).setAttribute("ancho","300" );
      ((Element)v.get(444)).setAttribute("alto","20" );
      ((Element)v.get(444)).setAttribute("filas","1" );
      ((Element)v.get(444)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(444)).setAttribute("valor","Divisiones Políticas" );
      ((Element)v.get(444)).setAttribute("enviaroculto","N" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */

      /* Empieza nodo:445 / Elemento padre: 441   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(445)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(445)).setAttribute("ancho","150" );
      ((Element)v.get(441)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(446)).setAttribute("nombre","lbPais01" );
      ((Element)v.get(446)).setAttribute("ancho","150" );
      ((Element)v.get(446)).setAttribute("alto","20" );
      ((Element)v.get(446)).setAttribute("filas","1" );
      ((Element)v.get(446)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(446)).setAttribute("valor","País 01" );
      ((Element)v.get(446)).setAttribute("enviaroculto","N" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:445   */
      /* Termina nodo:441   */

      /* Empieza nodo:447 / Elemento padre: 440   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(447)).setAttribute("ancho","10" );
      ((Element)v.get(447)).setAttribute("filas","1" );
      ((Element)v.get(447)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(440)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(448)).setAttribute("ancho","13" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */

      /* Empieza nodo:449 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(449)).setAttribute("ancho","300" );
      ((Element)v.get(449)).setAttribute("caracteres","100" );
      ((Element)v.get(447)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */

      /* Empieza nodo:450 / Elemento padre: 447   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(450)).setAttribute("ancho","150" );
      ((Element)v.get(450)).setAttribute("caracteres","30" );
      ((Element)v.get(447)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:447   */

      /* Empieza nodo:451 / Elemento padre: 440   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(440)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:440   */
      /* Termina nodo:439   */
      /* Termina nodo:3   */

      /* Empieza nodo:452 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(452)).setAttribute("nombre","frmUnicoBusq" );
      ((Element)v.get(452)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(453)).setAttribute("nombre","accion" );
      ((Element)v.get(453)).setAttribute("valor","" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(452)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */

      /* Empieza nodo:454 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(454)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(454)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */

      /* Empieza nodo:455 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(455)).setAttribute("nombre","clasOid" );
      ((Element)v.get(455)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */

      /* Empieza nodo:456 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(456)).setAttribute("nombre","clasDesc" );
      ((Element)v.get(456)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */

      /* Empieza nodo:457 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(457)).setAttribute("nombre","clasTipoClas" );
      ((Element)v.get(457)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */

      /* Empieza nodo:458 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(458)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(458)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */

      /* Empieza nodo:459 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(459)).setAttribute("nombre","hidCriterioBusqueda1" );
      ((Element)v.get(459)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */

      /* Empieza nodo:460 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(460)).setAttribute("nombre","hidCriterioBusqueda2" );
      ((Element)v.get(460)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */

      /* Empieza nodo:461 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(461)).setAttribute("nombre","hidTipoSubtipo" );
      ((Element)v.get(461)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */

      /* Empieza nodo:462 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(462)).setAttribute("nombre","hidtextCodCliente" );
      ((Element)v.get(462)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */

      /* Empieza nodo:463 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(463)).setAttribute("nombre","hidcbTipoDocId" );
      ((Element)v.get(463)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */

      /* Empieza nodo:464 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(464)).setAttribute("nombre","hidtextNDocId" );
      ((Element)v.get(464)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */

      /* Empieza nodo:465 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(465)).setAttribute("nombre","hidrbDocPrincipal" );
      ((Element)v.get(465)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */

      /* Empieza nodo:466 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(466)).setAttribute("nombre","hidcbPersonaCliente" );
      ((Element)v.get(466)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */

      /* Empieza nodo:467 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(467)).setAttribute("nombre","hidtextApellido1" );
      ((Element)v.get(467)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */

      /* Empieza nodo:468 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(468)).setAttribute("nombre","hidtextApellido2" );
      ((Element)v.get(468)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */

      /* Empieza nodo:469 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(469)).setAttribute("nombre","hidtextApellidoCasada" );
      ((Element)v.get(469)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */

      /* Empieza nodo:470 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(470)).setAttribute("nombre","hidtextNombre1" );
      ((Element)v.get(470)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */

      /* Empieza nodo:471 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(471)).setAttribute("nombre","hidtextNombre2" );
      ((Element)v.get(471)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */

      /* Empieza nodo:472 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(472)).setAttribute("nombre","hidcbTratamiento" );
      ((Element)v.get(472)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */

      /* Empieza nodo:473 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(473)).setAttribute("nombre","hidrbSexo" );
      ((Element)v.get(473)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */

      /* Empieza nodo:474 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(474)).setAttribute("nombre","hidcbFormaPago" );
      ((Element)v.get(474)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */

      /* Empieza nodo:475 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(475)).setAttribute("nombre","hidtextFechaNacimiento" );
      ((Element)v.get(475)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */

      /* Empieza nodo:476 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(476)).setAttribute("nombre","hidtextCodEmpleado" );
      ((Element)v.get(476)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */

      /* Empieza nodo:477 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(477)).setAttribute("nombre","hidcbNacionalidad" );
      ((Element)v.get(477)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */

      /* Empieza nodo:478 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(478)).setAttribute("nombre","hidcbEstadoCivil" );
      ((Element)v.get(478)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */

      /* Empieza nodo:479 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(479)).setAttribute("nombre","hidtextOcupacion" );
      ((Element)v.get(479)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */

      /* Empieza nodo:480 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(480)).setAttribute("nombre","hidtextProfesion" );
      ((Element)v.get(480)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */

      /* Empieza nodo:481 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(481)).setAttribute("nombre","hidtextCentroTrabajo" );
      ((Element)v.get(481)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */

      /* Empieza nodo:482 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(482)).setAttribute("nombre","hidtextCargoDesempena" );
      ((Element)v.get(482)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */

      /* Empieza nodo:483 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(483)).setAttribute("nombre","hidcbNivelEstudios" );
      ((Element)v.get(483)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */

      /* Empieza nodo:484 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(484)).setAttribute("nombre","hidtextCentroEstudios" );
      ((Element)v.get(484)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */

      /* Empieza nodo:485 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(485)).setAttribute("nombre","hidtextNHijos" );
      ((Element)v.get(485)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */

      /* Empieza nodo:486 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(486)).setAttribute("nombre","hidtextNPersonasDependientes" );
      ((Element)v.get(486)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */

      /* Empieza nodo:487 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(487)).setAttribute("nombre","hidcbNivelSocioEconomico" );
      ((Element)v.get(487)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */

      /* Empieza nodo:488 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(488)).setAttribute("nombre","hidcbCicloVidaFamiliar" );
      ((Element)v.get(488)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */

      /* Empieza nodo:489 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(489)).setAttribute("nombre","hidrbDeseaCorrespondencia" );
      ((Element)v.get(489)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */

      /* Empieza nodo:490 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(490)).setAttribute("nombre","hidtextImporteIngresoFamiliar" );
      ((Element)v.get(490)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */

      /* Empieza nodo:491 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(491)).setAttribute("nombre","hidcbPaisVinculo" );
      ((Element)v.get(491)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */

      /* Empieza nodo:492 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(492)).setAttribute("nombre","hidtextClienteVinculo" );
      ((Element)v.get(492)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */

      /* Empieza nodo:493 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(493)).setAttribute("nombre","hidcbTipoVinculo" );
      ((Element)v.get(493)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */

      /* Empieza nodo:494 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(494)).setAttribute("nombre","hidtextFechaD" );
      ((Element)v.get(494)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */

      /* Empieza nodo:495 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(495)).setAttribute("nombre","hidtextFechaH" );
      ((Element)v.get(495)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */

      /* Empieza nodo:496 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(496)).setAttribute("nombre","hidrbVinculoPrincipal" );
      ((Element)v.get(496)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */

      /* Empieza nodo:497 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(497)).setAttribute("nombre","hidcb" );
      ((Element)v.get(497)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */

      /* Empieza nodo:498 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(498)).setAttribute("nombre","hidtextDescripcion" );
      ((Element)v.get(498)).setAttribute("valor","" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(452)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */

      /* Empieza nodo:499 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(499)).setAttribute("nombre","hidcbPaisContactado" );
      ((Element)v.get(499)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */

      /* Empieza nodo:500 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(500)).setAttribute("nombre","hidtextCodClienteContactado" );
      ((Element)v.get(500)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */

      /* Empieza nodo:501 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(501)).setAttribute("nombre","hidcbTipoClienteContactado" );
      ((Element)v.get(501)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */

      /* Empieza nodo:502 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(502)).setAttribute("nombre","hidcbCodTipoContactado" );
      ((Element)v.get(502)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */

      /* Empieza nodo:503 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(503)).setAttribute("nombre","hidtextFechaContacto" );
      ((Element)v.get(503)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */

      /* Empieza nodo:504 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(504)).setAttribute("nombre","hidtextFecha1PedidoContacto" );
      ((Element)v.get(504)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */

      /* Empieza nodo:505 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(505)).setAttribute("nombre","hidtextFechaSiguienteContacto" );
      ((Element)v.get(505)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */

      /* Empieza nodo:506 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(506)).setAttribute("nombre","hidtxtFechaIngresoActual" );
      ((Element)v.get(506)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */

      /* Empieza nodo:507 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(507)).setAttribute("nombre","hidcbMarcaContacto" );
      ((Element)v.get(507)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */

      /* Empieza nodo:508 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(508)).setAttribute("nombre","hidcbCanalContacto" );
      ((Element)v.get(508)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */

      /* Empieza nodo:509 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(509)).setAttribute("nombre","hidcbPeriodoPrimerPedido" );
      ((Element)v.get(509)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */

      /* Empieza nodo:510 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(510)).setAttribute("nombre","hidcbTipoDireccion" );
      ((Element)v.get(510)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */

      /* Empieza nodo:511 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(511)).setAttribute("nombre","hidcbTipoVia" );
      ((Element)v.get(511)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */

      /* Empieza nodo:512 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(512)).setAttribute("nombre","hidtextNombreVia" );
      ((Element)v.get(512)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */

      /* Empieza nodo:513 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(513)).setAttribute("nombre","hidtextNPrincipal" );
      ((Element)v.get(513)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */

      /* Empieza nodo:514 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(514)).setAttribute("nombre","hidtextCodPostal" );
      ((Element)v.get(514)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */

      /* Empieza nodo:515 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(515)).setAttribute("nombre","hidtextInterior" );
      ((Element)v.get(515)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */

      /* Empieza nodo:516 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(516)).setAttribute("nombre","hidtextManzana" );
      ((Element)v.get(516)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */

      /* Empieza nodo:517 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(517)).setAttribute("nombre","hidtextLote" );
      ((Element)v.get(517)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */

      /* Empieza nodo:518 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(518)).setAttribute("nombre","hidtextKm" );
      ((Element)v.get(518)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */

      /* Empieza nodo:519 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(519)).setAttribute("nombre","hidrbDireccionPrincipal" );
      ((Element)v.get(519)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */

      /* Empieza nodo:520 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(520)).setAttribute("nombre","hidtextObservaciones" );
      ((Element)v.get(520)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */

      /* Empieza nodo:521 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(521)).setAttribute("nombre","hidcbTipoComunicacion" );
      ((Element)v.get(521)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */

      /* Empieza nodo:522 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(522)).setAttribute("nombre","hidcbDiaComunicacion" );
      ((Element)v.get(522)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(522));
      /* Termina nodo:522   */

      /* Empieza nodo:523 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(523)).setAttribute("nombre","hidrbComunicacionPrincipal" );
      ((Element)v.get(523)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */

      /* Empieza nodo:524 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(524)).setAttribute("nombre","hidtextHoraDesde" );
      ((Element)v.get(524)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */

      /* Empieza nodo:525 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(525)).setAttribute("nombre","hidtextHoraHasta" );
      ((Element)v.get(525)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */

      /* Empieza nodo:526 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(526)).setAttribute("nombre","hidcbIntervaloComunicacion" );
      ((Element)v.get(526)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */

      /* Empieza nodo:527 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(527)).setAttribute("nombre","hidtextTextoComunicacion" );
      ((Element)v.get(527)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */

      /* Empieza nodo:528 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(528)).setAttribute("nombre","hidcbMarca" );
      ((Element)v.get(528)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */

      /* Empieza nodo:529 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(529)).setAttribute("nombre","hidcbVia" );
      ((Element)v.get(529)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */

      /* Empieza nodo:530 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(530)).setAttribute("nombre","hidcbTipoTarjeta" );
      ((Element)v.get(530)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */

      /* Empieza nodo:531 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(531)).setAttribute("nombre","hidcbClasesTarjeta" );
      ((Element)v.get(531)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */

      /* Empieza nodo:532 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(532)).setAttribute("nombre","hidcbEntidadBancaria" );
      ((Element)v.get(532)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */

      /* Empieza nodo:533 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(533)).setAttribute("nombre","hidcbMarcaPestanya4" );
      ((Element)v.get(533)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */

      /* Empieza nodo:534 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(534)).setAttribute("nombre","hidcbCanal" );
      ((Element)v.get(534)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */

      /* Empieza nodo:535 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(535)).setAttribute("nombre","hidcbTipoClasificacion" );
      ((Element)v.get(535)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */

      /* Empieza nodo:536 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(536)).setAttribute("nombre","hidcbTipoProblema" );
      ((Element)v.get(536)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */

      /* Empieza nodo:537 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(537)).setAttribute("nombre","hidrbSolucion" );
      ((Element)v.get(537)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */

      /* Empieza nodo:538 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(538)).setAttribute("nombre","hidcbTipoSolucion" );
      ((Element)v.get(538)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */

      /* Empieza nodo:539 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(539)).setAttribute("nombre","hidtextDescripcionProblema" );
      ((Element)v.get(539)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */

      /* Empieza nodo:540 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(540)).setAttribute("nombre","hidtextDescripcionSolucion" );
      ((Element)v.get(540)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */

      /* Empieza nodo:541 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(541)).setAttribute("nombre","hidcbClasificacion" );
      ((Element)v.get(541)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */

      /* Empieza nodo:542 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(542)).setAttribute("nombre","hidtextNegocioProducto" );
      ((Element)v.get(542)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */

      /* Empieza nodo:543 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(543)).setAttribute("nombre","ListaComboClasificacion" );
      ((Element)v.get(543)).setAttribute("valor","" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(452)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */

      /* Empieza nodo:544 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(544)).setAttribute("nombre","hiddenTipoCliente" );
      ((Element)v.get(544)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(544));
      /* Termina nodo:544   */

      /* Empieza nodo:545 / Elemento padre: 452   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(545)).setAttribute("nombre","hiddenSubTipoCliente" );
      ((Element)v.get(545)).setAttribute("valor","" );
      ((Element)v.get(452)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:452   */


   }

}

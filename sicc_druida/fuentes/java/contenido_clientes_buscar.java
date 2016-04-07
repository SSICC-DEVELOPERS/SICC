
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_clientes_buscar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_clientes_buscar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","buscar Clientes" );
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
      ((Element)v.get(2)).setAttribute("src","contenido_clientes_buscar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","frmbuscarCliente" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","accion" );
      ((Element)v.get(5)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hidCriterioBusqueda1" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hidCriterioBusqueda2" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hidTipoSubtipo" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hidtextCodCliente" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hidcbTipoDocId" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hidtextNDocId" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hidrbDocPrincipal" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hidcbPersonaCliente" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hidtextApellido1" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hidtextApellido2" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hidtextApellidoCasada" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("nombre","hidtextNombre1" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hidtextNombre2" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hidcbTratamiento" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hidrbSexo" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hidcbFormaPago" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidtextFechaNacimiento" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hidtextCodEmpleado" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hidcbNacionalidad" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hidcbEstadoCivil" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hidtextOcupacion" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hidtextProfesion" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hidtextCentroTrabajo" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hidtextCargoDesempena" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hidcbNivelEstudios" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hidtextCentroEstudios" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hidtextNHijos" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hidtextNPersonasDependientes" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hidcbNivelSocioEconomico" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hidcbCicloVidaFamiliar" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hidrbDeseaCorrespondencia" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hidtextImporteIngresoFamiliar" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hidcbPaisVinculo" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hidtextClienteVinculo" );
      ((Element)v.get(44)).setAttribute("valor","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(4)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hidcbTipoVinculo" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hidtextFechaD" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hidtextFechaH" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hidrbVinculoPrincipal" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hidcb" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hidtextDescripcion" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hidcbPaisContactado" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hidtextCodClienteContactado" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hidcbTipoClienteContactado" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hidcbCodTipoContactado" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hidtextFechaContacto" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hidtextFecha1PedidoContacto" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","hidtextFechaSiguienteContacto" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","hidtxtFechaIngresoActual" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hidcbMarcaContacto" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hidcbCanalContacto" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","hidcbPeriodoPrimerPedido" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","hidcbTipoDireccion" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","hidcbTipoVia" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","hidtextNombreVia" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","hidtextNPrincipal" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","hidtextCodPostal" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(67)).setAttribute("nombre","hidtextInterior" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","hidtextManzana" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","hidtextLote" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","hidtextKm" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","hidrbDireccionPrincipal" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","hidtextObservaciones" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","hidcbTipoComunicacion" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","hidcbDiaComunicacion" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","hidrbComunicacionPrincipal" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","hidtextHoraDesde" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","hidtextHoraHasta" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","hidcbIntervaloComunicacion" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","hidtextTextoComunicacion" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","hidcbMarca" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","hidcbVia" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","hidcbTipoTarjeta" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","hidcbClasesTarjeta" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","hidcbEntidadBancaria" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","hidcbMarcaPestanya4" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","hidcbCanal" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","hidcbTipoClasificacion" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","hidcbTipoProblema" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(89)).setAttribute("nombre","hidrbSolucion" );
      ((Element)v.get(89)).setAttribute("valor","" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(4)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(90)).setAttribute("nombre","hidcbTipoSolucion" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(91)).setAttribute("nombre","hidtextDescripcionProblema" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(92)).setAttribute("nombre","hidtextDescripcionSolucion" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(93)).setAttribute("nombre","hidcbClasificacion" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(94)).setAttribute("nombre","hidtextNegocioProducto" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(95)).setAttribute("nombre","ListaComboClasificacion" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(96)).setAttribute("nombre","hiddenTipoCliente" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(97)).setAttribute("nombre","hiddenSubTipoCliente" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(98)).setAttribute("nombre","hCadenaParams" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 4   */
      v.add(doc.createElement("table"));
      ((Element)v.get(99)).setAttribute("width","100%" );
      ((Element)v.get(99)).setAttribute("height","100%" );
      ((Element)v.get(99)).setAttribute("border","0" );
      ((Element)v.get(99)).setAttribute("align","center" );
      ((Element)v.get(99)).setAttribute("cellpadding","0" );
      ((Element)v.get(99)).setAttribute("cellspacing","0" );
      ((Element)v.get(99)).setAttribute("class","menu4" );
      ((Element)v.get(4)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("width","12" );
      ((Element)v.get(101)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(101)).setAttribute("class","menu5texto" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","12" );
      ((Element)v.get(102)).setAttribute("height","30" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(103)).setAttribute("class","menu5texto" );
      ((Element)v.get(100)).appendChild((Element)v.get(103));

      /* Elemento padre:103 / Elemento actual: 104   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(103)).appendChild((Text)v.get(104));

      /* Termina nodo Texto:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("width","10" );
      ((Element)v.get(105)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(105)).setAttribute("class","menu5texto" );
      ((Element)v.get(100)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","10" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("width","92" );
      ((Element)v.get(107)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(107)).setAttribute("class","menu5texto" );
      ((Element)v.get(100)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("table"));
      ((Element)v.get(108)).setAttribute("width","75" );
      ((Element)v.get(108)).setAttribute("border","1" );
      ((Element)v.get(108)).setAttribute("align","center" );
      ((Element)v.get(108)).setAttribute("cellpadding","1" );
      ((Element)v.get(108)).setAttribute("cellspacing","0" );
      ((Element)v.get(108)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(108)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(109)).setAttribute("align","center" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(110)).setAttribute("class","menu5textoblanca" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(111)).setAttribute("nombre","lblPesCriterios" );
      ((Element)v.get(111)).setAttribute("alto","13" );
      ((Element)v.get(111)).setAttribute("filas","1" );
      ((Element)v.get(111)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(111)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(111)).setAttribute("cod","0075" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:112 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("width","10" );
      ((Element)v.get(112)).setAttribute("class","menu5texto" );
      ((Element)v.get(100)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","10" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("width","20" );
      ((Element)v.get(114)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(114)).setAttribute("class","menu5texto" );
      ((Element)v.get(100)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("table"));
      ((Element)v.get(115)).setAttribute("width","75" );
      ((Element)v.get(115)).setAttribute("border","1" );
      ((Element)v.get(115)).setAttribute("align","center" );
      ((Element)v.get(115)).setAttribute("cellpadding","1" );
      ((Element)v.get(115)).setAttribute("cellspacing","0" );
      ((Element)v.get(115)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(116)).setAttribute("align","center" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(117)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(117)).setAttribute("onclick","siguientePestanya(0)" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(118)).setAttribute("nombre","lblPesTipoSubtipo" );
      ((Element)v.get(118)).setAttribute("alto","13" );
      ((Element)v.get(118)).setAttribute("filas","1" );
      ((Element)v.get(118)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(118)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(118)).setAttribute("cod","00519" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:119 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("width","10" );
      ((Element)v.get(119)).setAttribute("class","menu5texto" );
      ((Element)v.get(100)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","10" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("width","20" );
      ((Element)v.get(121)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(121)).setAttribute("class","menu5texto" );
      ((Element)v.get(100)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("table"));
      ((Element)v.get(122)).setAttribute("width","75" );
      ((Element)v.get(122)).setAttribute("border","1" );
      ((Element)v.get(122)).setAttribute("align","center" );
      ((Element)v.get(122)).setAttribute("cellpadding","1" );
      ((Element)v.get(122)).setAttribute("cellspacing","0" );
      ((Element)v.get(122)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(123)).setAttribute("align","center" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(124)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(124)).setAttribute("onclick","siguientePestanya(1)" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(125)).setAttribute("nombre","lblPes1" );
      ((Element)v.get(125)).setAttribute("alto","13" );
      ((Element)v.get(125)).setAttribute("filas","1" );
      ((Element)v.get(125)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(125)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(125)).setAttribute("cod","00515" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:126 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(126)).setAttribute("width","10" );
      ((Element)v.get(126)).setAttribute("class","menu5texto" );
      ((Element)v.get(100)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","10" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("width","20" );
      ((Element)v.get(128)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(128)).setAttribute("class","menu5texto" );
      ((Element)v.get(100)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("table"));
      ((Element)v.get(129)).setAttribute("width","75" );
      ((Element)v.get(129)).setAttribute("border","1" );
      ((Element)v.get(129)).setAttribute("align","center" );
      ((Element)v.get(129)).setAttribute("cellpadding","1" );
      ((Element)v.get(129)).setAttribute("cellspacing","0" );
      ((Element)v.get(129)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(130)).setAttribute("align","center" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(131)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(131)).setAttribute("onclick","siguientePestanya(2)" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(132)).setAttribute("nombre","lblPes2" );
      ((Element)v.get(132)).setAttribute("alto","13" );
      ((Element)v.get(132)).setAttribute("filas","1" );
      ((Element)v.get(132)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(132)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(132)).setAttribute("cod","00516" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:133 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("width","10" );
      ((Element)v.get(133)).setAttribute("class","menu5texto" );
      ((Element)v.get(100)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","10" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("width","20" );
      ((Element)v.get(135)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(135)).setAttribute("class","menu5texto" );
      ((Element)v.get(100)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("table"));
      ((Element)v.get(136)).setAttribute("width","75" );
      ((Element)v.get(136)).setAttribute("border","1" );
      ((Element)v.get(136)).setAttribute("align","center" );
      ((Element)v.get(136)).setAttribute("cellpadding","1" );
      ((Element)v.get(136)).setAttribute("cellspacing","0" );
      ((Element)v.get(136)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(137)).setAttribute("align","center" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(138)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(138)).setAttribute("onclick","siguientePestanya(3)" );
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

      /* Empieza nodo:140 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("width","10" );
      ((Element)v.get(140)).setAttribute("class","menu5texto" );
      ((Element)v.get(100)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","10" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("width","20" );
      ((Element)v.get(142)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(142)).setAttribute("class","menu5texto" );
      ((Element)v.get(100)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("table"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(143)).setAttribute("width","75" );
      ((Element)v.get(143)).setAttribute("border","1" );
      ((Element)v.get(143)).setAttribute("align","center" );
      ((Element)v.get(143)).setAttribute("cellpadding","1" );
      ((Element)v.get(143)).setAttribute("cellspacing","0" );
      ((Element)v.get(143)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(144)).setAttribute("align","center" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(145)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(145)).setAttribute("onclick","siguientePestanya(4)" );
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

      /* Empieza nodo:147 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("width","16" );
      ((Element)v.get(147)).setAttribute("class","menu5texto" );
      ((Element)v.get(100)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","12" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:149 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(149)).setAttribute("nombre","capaUnica" );
      ((Element)v.get(149)).setAttribute("alto","121" );
      ((Element)v.get(149)).setAttribute("ancho","100%" );
      ((Element)v.get(4)).appendChild((Element)v.get(149));

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
      ((Element)v.get(164)).setAttribute("nombre","lblTit" );
      ((Element)v.get(164)).setAttribute("ancho","150" );
      ((Element)v.get(164)).setAttribute("alto","13" );
      ((Element)v.get(164)).setAttribute("filas","1" );
      ((Element)v.get(164)).setAttribute("valor","" );
      ((Element)v.get(164)).setAttribute("cod","0075" );
      ((Element)v.get(164)).setAttribute("id","legend" );
   }

   private void getXML720(Document doc) {
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
      ((Element)v.get(167)).setAttribute("colspan","4" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:169 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","8" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(173)).setAttribute("nombre","lblCriterioBusqueda1" );
      ((Element)v.get(173)).setAttribute("ancho","120" );
      ((Element)v.get(173)).setAttribute("alto","13" );
      ((Element)v.get(173)).setAttribute("filas","1" );
      ((Element)v.get(173)).setAttribute("valor","" );
      ((Element)v.get(173)).setAttribute("id","datosTitle" );
      ((Element)v.get(173)).setAttribute("cod","1200" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","25" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(177)).setAttribute("nombre","lblCriterioBusqueda2" );
      ((Element)v.get(177)).setAttribute("ancho","120" );
      ((Element)v.get(177)).setAttribute("alto","13" );
      ((Element)v.get(177)).setAttribute("filas","1" );
      ((Element)v.get(177)).setAttribute("valor","" );
      ((Element)v.get(177)).setAttribute("id","datosTitle" );
      ((Element)v.get(177)).setAttribute("cod","1201" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).setAttribute("width","100%" );
      ((Element)v.get(169)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:169   */

      /* Empieza nodo:180 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","8" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(184)).setAttribute("nombre","textCriterioBusqueda1" );
      ((Element)v.get(184)).setAttribute("id","datosCampos" );
      ((Element)v.get(184)).setAttribute("max","50" );
      ((Element)v.get(184)).setAttribute("tipo","" );
      ((Element)v.get(184)).setAttribute("onchange","" );
      ((Element)v.get(184)).setAttribute("req","N" );
      ((Element)v.get(184)).setAttribute("size","50" );
      ((Element)v.get(184)).setAttribute("valor","" );
      ((Element)v.get(184)).setAttribute("validacion","" );
      ((Element)v.get(184)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar')" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","25" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(188)).setAttribute("nombre","textCriterioBusqueda2" );
      ((Element)v.get(188)).setAttribute("id","datosCampos" );
      ((Element)v.get(188)).setAttribute("max","50" );
      ((Element)v.get(188)).setAttribute("tipo","" );
      ((Element)v.get(188)).setAttribute("onchange","" );
      ((Element)v.get(188)).setAttribute("req","N" );
      ((Element)v.get(188)).setAttribute("size","50" );
      ((Element)v.get(188)).setAttribute("valor","" );
      ((Element)v.get(188)).setAttribute("validacion","" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).setAttribute("width","100%" );
      ((Element)v.get(180)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","8" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:180   */

      /* Empieza nodo:191 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).setAttribute("colspan","4" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","8" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:165   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:194 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","8" );
      ((Element)v.get(195)).setAttribute("height","12" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:158   */

      /* Empieza nodo:196 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("table"));
      ((Element)v.get(201)).setAttribute("width","100%" );
      ((Element)v.get(201)).setAttribute("border","0" );
      ((Element)v.get(201)).setAttribute("align","center" );
      ((Element)v.get(201)).setAttribute("cellspacing","0" );
      ((Element)v.get(201)).setAttribute("cellpadding","0" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).setAttribute("class","botonera" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(204)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(204)).setAttribute("ID","botonContenido" );
      ((Element)v.get(204)).setAttribute("tipo","html" );
      ((Element)v.get(204)).setAttribute("accion","busca();" );
      ((Element)v.get(204)).setAttribute("ontab","siguientePestanya(0);" );
      ((Element)v.get(204)).setAttribute("estado","false" );
      ((Element)v.get(204)).setAttribute("cod","1" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:205 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","8" );
      ((Element)v.get(206)).setAttribute("height","12" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:196   */

      /* Empieza nodo:207 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("width","12" );
      ((Element)v.get(208)).setAttribute("align","center" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","12" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(209)).setAttribute("height","12" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).setAttribute("width","750" );
      ((Element)v.get(207)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).setAttribute("width","12" );
      ((Element)v.get(207)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).setAttribute("width","12" );
      ((Element)v.get(213)).setAttribute("height","12" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:207   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:4   */

      /* Empieza nodo:214 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(214)).setAttribute("nombre","frmbuscarClienteBusq" );
      ((Element)v.get(214)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(215)).setAttribute("nombre","accion" );
      ((Element)v.get(215)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(216)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(216)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(217)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(217)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(218)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(218)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(219)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(219)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(220)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(220)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(221)).setAttribute("nombre","hidCriterioBusqueda1" );
      ((Element)v.get(221)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(222)).setAttribute("nombre","hidCriterioBusqueda2" );
      ((Element)v.get(222)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(223)).setAttribute("nombre","hidTipoSubtipo" );
      ((Element)v.get(223)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(224)).setAttribute("nombre","hidtextCodCliente" );
      ((Element)v.get(224)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(225)).setAttribute("nombre","hidcbTipoDocId" );
      ((Element)v.get(225)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(226)).setAttribute("nombre","hidtextNDocId" );
      ((Element)v.get(226)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */

      /* Empieza nodo:227 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(227)).setAttribute("nombre","hidrbDocPrincipal" );
      ((Element)v.get(227)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(228)).setAttribute("nombre","hidcbPersonaCliente" );
      ((Element)v.get(228)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(229)).setAttribute("nombre","hidtextApellido1" );
      ((Element)v.get(229)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(230)).setAttribute("nombre","hidtextApellido2" );
      ((Element)v.get(230)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(231)).setAttribute("nombre","hidtextApellidoCasada" );
      ((Element)v.get(231)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(232)).setAttribute("nombre","hidtextNombre1" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(232)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(233)).setAttribute("nombre","hidtextNombre2" );
      ((Element)v.get(233)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */

      /* Empieza nodo:234 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(234)).setAttribute("nombre","hidcbTratamiento" );
      ((Element)v.get(234)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(235)).setAttribute("nombre","hidrbSexo" );
      ((Element)v.get(235)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(236)).setAttribute("nombre","hidcbFormaPago" );
      ((Element)v.get(236)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(237)).setAttribute("nombre","hidtextFechaNacimiento" );
      ((Element)v.get(237)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(238)).setAttribute("nombre","hidtextCodEmpleado" );
      ((Element)v.get(238)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(239)).setAttribute("nombre","hidcbNacionalidad" );
      ((Element)v.get(239)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(240)).setAttribute("nombre","hidcbEstadoCivil" );
      ((Element)v.get(240)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(241)).setAttribute("nombre","hidtextOcupacion" );
      ((Element)v.get(241)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(242)).setAttribute("nombre","hidtextProfesion" );
      ((Element)v.get(242)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(243)).setAttribute("nombre","hidtextCentroTrabajo" );
      ((Element)v.get(243)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(244)).setAttribute("nombre","hidtextCargoDesempena" );
      ((Element)v.get(244)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(245)).setAttribute("nombre","hidcbNivelEstudios" );
      ((Element)v.get(245)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */

      /* Empieza nodo:246 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(246)).setAttribute("nombre","hidtextCentroEstudios" );
      ((Element)v.get(246)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */

      /* Empieza nodo:247 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(247)).setAttribute("nombre","hidtextNHijos" );
      ((Element)v.get(247)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(248)).setAttribute("nombre","hidtextNPersonasDependientes" );
      ((Element)v.get(248)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */

      /* Empieza nodo:249 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(249)).setAttribute("nombre","hidcbNivelSocioEconomico" );
      ((Element)v.get(249)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(250)).setAttribute("nombre","hidcbCicloVidaFamiliar" );
      ((Element)v.get(250)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(251)).setAttribute("nombre","hidrbDeseaCorrespondencia" );
      ((Element)v.get(251)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(252)).setAttribute("nombre","hidtextImporteIngresoFamiliar" );
      ((Element)v.get(252)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(253)).setAttribute("nombre","hidcbPaisVinculo" );
      ((Element)v.get(253)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(254)).setAttribute("nombre","hidtextClienteVinculo" );
      ((Element)v.get(254)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 214   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(255)).setAttribute("nombre","hidcbTipoVinculo" );
      ((Element)v.get(255)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(256)).setAttribute("nombre","hidtextFechaD" );
      ((Element)v.get(256)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(257)).setAttribute("nombre","hidtextFechaH" );
      ((Element)v.get(257)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(258)).setAttribute("nombre","hidrbVinculoPrincipal" );
      ((Element)v.get(258)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(259)).setAttribute("nombre","hidcb" );
      ((Element)v.get(259)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(260)).setAttribute("nombre","hidtextDescripcion" );
      ((Element)v.get(260)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(261)).setAttribute("nombre","hidcbPaisContactado" );
      ((Element)v.get(261)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */

      /* Empieza nodo:262 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(262)).setAttribute("nombre","hidtextCodClienteContactado" );
      ((Element)v.get(262)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(263)).setAttribute("nombre","hidcbTipoClienteContactado" );
      ((Element)v.get(263)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */

      /* Empieza nodo:264 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(264)).setAttribute("nombre","hidcbCodTipoContactado" );
      ((Element)v.get(264)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(265)).setAttribute("nombre","hidtextFechaContacto" );
      ((Element)v.get(265)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(266)).setAttribute("nombre","hidtextFecha1PedidoContacto" );
      ((Element)v.get(266)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(267)).setAttribute("nombre","hidtextFechaSiguienteContacto" );
      ((Element)v.get(267)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(268)).setAttribute("nombre","hidtxtFechaIngresoActual" );
      ((Element)v.get(268)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(269)).setAttribute("nombre","hidcbMarcaContacto" );
      ((Element)v.get(269)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(270)).setAttribute("nombre","hidcbCanalContacto" );
      ((Element)v.get(270)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(271)).setAttribute("nombre","hidcbPeriodoPrimerPedido" );
      ((Element)v.get(271)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(272)).setAttribute("nombre","hidcbTipoDireccion" );
      ((Element)v.get(272)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(273)).setAttribute("nombre","hidcbTipoVia" );
      ((Element)v.get(273)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(274)).setAttribute("nombre","hidtextNombreVia" );
      ((Element)v.get(274)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(275)).setAttribute("nombre","hidtextNPrincipal" );
      ((Element)v.get(275)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(276)).setAttribute("nombre","hidtextCodPostal" );
      ((Element)v.get(276)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(277)).setAttribute("nombre","hidtextInterior" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(277)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(278)).setAttribute("nombre","hidtextManzana" );
      ((Element)v.get(278)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(279)).setAttribute("nombre","hidtextLote" );
      ((Element)v.get(279)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(280)).setAttribute("nombre","hidtextKm" );
      ((Element)v.get(280)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(281)).setAttribute("nombre","hidrbDireccionPrincipal" );
      ((Element)v.get(281)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(282)).setAttribute("nombre","hidtextObservaciones" );
      ((Element)v.get(282)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(283)).setAttribute("nombre","hidcbTipoComunicacion" );
      ((Element)v.get(283)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(284)).setAttribute("nombre","hidcbDiaComunicacion" );
      ((Element)v.get(284)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(285)).setAttribute("nombre","hidrbComunicacionPrincipal" );
      ((Element)v.get(285)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(286)).setAttribute("nombre","hidtextHoraDesde" );
      ((Element)v.get(286)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(287)).setAttribute("nombre","hidtextHoraHasta" );
      ((Element)v.get(287)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(288)).setAttribute("nombre","hidcbIntervaloComunicacion" );
      ((Element)v.get(288)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(289)).setAttribute("nombre","hidtextTextoComunicacion" );
      ((Element)v.get(289)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(290)).setAttribute("nombre","hidcbMarca" );
      ((Element)v.get(290)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(291)).setAttribute("nombre","hidcbVia" );
      ((Element)v.get(291)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(292)).setAttribute("nombre","hidcbTipoTarjeta" );
      ((Element)v.get(292)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(293)).setAttribute("nombre","hidcbClasesTarjeta" );
      ((Element)v.get(293)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(294)).setAttribute("nombre","hidcbEntidadBancaria" );
      ((Element)v.get(294)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(295)).setAttribute("nombre","hidcbMarcaPestanya4" );
      ((Element)v.get(295)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(296)).setAttribute("nombre","hidcbCanal" );
      ((Element)v.get(296)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(297)).setAttribute("nombre","hidcbTipoClasificacion" );
      ((Element)v.get(297)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */

      /* Empieza nodo:298 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(298)).setAttribute("nombre","hidcbTipoProblema" );
      ((Element)v.get(298)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(299)).setAttribute("nombre","hidrbSolucion" );
      ((Element)v.get(299)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 214   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(300)).setAttribute("nombre","hidcbTipoSolucion" );
      ((Element)v.get(300)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(301)).setAttribute("nombre","hidtextDescripcionProblema" );
      ((Element)v.get(301)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(302)).setAttribute("nombre","hidtextDescripcionSolucion" );
      ((Element)v.get(302)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(303)).setAttribute("nombre","hidcbClasificacion" );
      ((Element)v.get(303)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(304)).setAttribute("nombre","hidtextNegocioProducto" );
      ((Element)v.get(304)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(305)).setAttribute("nombre","ListaComboClasificacion" );
      ((Element)v.get(305)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(306)).setAttribute("nombre","hiddenTipoCliente" );
      ((Element)v.get(306)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 214   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(307)).setAttribute("nombre","hiddenSubTipoCliente" );
      ((Element)v.get(307)).setAttribute("valor","" );
      ((Element)v.get(214)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:214   */


   }

}

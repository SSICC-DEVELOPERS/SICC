
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_mensajes_insertar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_mensajes_insertar" );
      ((Element)v.get(0)).setAttribute("cod","0361" );
      ((Element)v.get(0)).setAttribute("titulo","Insertar mensajes" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Insertar mensajes" );
      ((Element)v.get(0)).setAttribute("onload","onLoadCargarBarra();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","contenido_mensajes_insertar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","TextoFijo" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","1265" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbModulo" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","1257" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtCodigoMensaje" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","821" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbTipoMensaje" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","1259" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","atDescripcion" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","9" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbPermanenciaMensaje" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","1263" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbAsignacionDestinatarios" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","1267" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:5   */

      /* Empieza nodo:13 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(13)).setAttribute("nombre","frmConsultarListaConsultoras" );
      ((Element)v.get(13)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","accion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hCasoDeUso" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hModulo" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hMarca" );
      ((Element)v.get(20)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(13)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hTipoPeriodo" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hTipoMensaje" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hPermanencia" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hPais" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hNivel" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hNivelTipificacion" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hSeccion" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hTerritorio" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hZona" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hRegion" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hTipo" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hProceso" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hSubtipo" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hTipoClasificacion" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hConsultoras" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hClasificacion" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","oidMensaje" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","oidTipoMensaje" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","unidadAdministrativa" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","tipoCliente" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","marca" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","codigoVenta" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(43)).setAttribute("nombre","pedido" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","consultoras" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hFormatoFechaPais" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hCodMensaje" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hDescripcion" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hProgramaAsociado" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hBloqueGrupo" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hDesde" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hHasta" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hPeriodoDesde" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hPeriodoHasta" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hTextoFijoYDatosVariables" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hNVariable" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hAsigDest" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","ExitoAlInsertar" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","oculto" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hOidPermanenciaH" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hOidPermanenciaR" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","hOidMensaje" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","hModuloSeleccionado" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","hTipoMensajeSeleccionado" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","hPermanenciaMensaje" );
      ((Element)v.get(65)).setAttribute("valor","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(13)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","hTipoPeriodoDesde" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","hTipoPeriodoHasta" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","hAsignacionDestinatarios" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","hTipoPeriodoSeleccionado" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","hGeneracionDatosSeleccionado" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","hPermanenciaMensajeSeleccionado" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","hTipoPeriodoDesdeSeleccionado" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","hTipoPeriodoHastaSeleccionado" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","hDescTipoMensaje" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","cteOidPedido" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","cteOidConsultora" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","cteOidTipoG1" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","cteOidTipoG2" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","cteOidUA" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","cteOidClasiClien" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","hTextoFijo" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","hDescMensaje" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","hCodigoMensaje" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","flagModificar" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","hExclusionTipologia" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(86)).setAttribute("nombre","camposBusqueda" );
      ((Element)v.get(13)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("table"));
      ((Element)v.get(87)).setAttribute("width","100%" );
      ((Element)v.get(87)).setAttribute("border","0" );
      ((Element)v.get(87)).setAttribute("cellspacing","0" );
      ((Element)v.get(87)).setAttribute("cellpadding","0" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("width","12" );
      ((Element)v.get(89)).setAttribute("align","center" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","12" );
      ((Element)v.get(90)).setAttribute("height","12" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","750" );
      ((Element)v.get(88)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("width","12" );
      ((Element)v.get(88)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","12" );
      ((Element)v.get(94)).setAttribute("height","1" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:88   */

      /* Empieza nodo:95 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(100)).setAttribute("class","legend" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(101)).setAttribute("nombre","lblAlta" );
      ((Element)v.get(101)).setAttribute("alto","13" );
      ((Element)v.get(101)).setAttribute("filas","1" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(101)).setAttribute("id","legend" );
      ((Element)v.get(101)).setAttribute("cod","00127" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 99   */
      v.add(doc.createElement("table"));
      ((Element)v.get(102)).setAttribute("width","100%" );
      ((Element)v.get(102)).setAttribute("border","0" );
      ((Element)v.get(102)).setAttribute("align","center" );
      ((Element)v.get(102)).setAttribute("cellspacing","0" );
      ((Element)v.get(102)).setAttribute("cellpadding","0" );
      ((Element)v.get(99)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("table"));
      ((Element)v.get(105)).setAttribute("width","731" );
      ((Element)v.get(105)).setAttribute("border","0" );
      ((Element)v.get(105)).setAttribute("align","left" );
      ((Element)v.get(105)).setAttribute("cellspacing","0" );
      ((Element)v.get(105)).setAttribute("cellpadding","0" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("colspan","4" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:109 / Elemento padre: 105   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(105)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","8" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(113)).setAttribute("nombre","lblTextoFijo" );
      ((Element)v.get(113)).setAttribute("alto","13" );
      ((Element)v.get(113)).setAttribute("filas","1" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(113)).setAttribute("valor","" );
      ((Element)v.get(113)).setAttribute("id","datosTitle" );
      ((Element)v.get(113)).setAttribute("cod","1265" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("width","100%" );
      ((Element)v.get(109)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:109   */

      /* Empieza nodo:116 / Elemento padre: 105   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(105)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(116)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(120)).setAttribute("nombre","TextoFijo" );
      ((Element)v.get(120)).setAttribute("id","datosCampos" );
      ((Element)v.get(120)).setAttribute("cols","130" );
      ((Element)v.get(120)).setAttribute("rows","3" );
      ((Element)v.get(120)).setAttribute("valor","" );
      ((Element)v.get(120)).setAttribute("max","2000" );
      ((Element)v.get(120)).setAttribute("req","S" );
      ((Element)v.get(120)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnAceptar');" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("width","100%" );
      ((Element)v.get(116)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:116   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:123 / Elemento padre: 102   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(102)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("table"));
      ((Element)v.get(125)).setAttribute("width","731" );
      ((Element)v.get(125)).setAttribute("border","0" );
      ((Element)v.get(125)).setAttribute("align","left" );
      ((Element)v.get(125)).setAttribute("cellspacing","0" );
      ((Element)v.get(125)).setAttribute("cellpadding","0" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("colspan","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:129 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(129));

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
      ((Element)v.get(132)).setAttribute("colspan","3" );
      ((Element)v.get(129)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(133)).setAttribute("nombre","lblMetacaracteresControlFormato" );
      ((Element)v.get(133)).setAttribute("alto","13" );
      ((Element)v.get(133)).setAttribute("filas","1" );
      ((Element)v.get(133)).setAttribute("valor","" );
      ((Element)v.get(133)).setAttribute("id","datosTitle" );
      ((Element)v.get(133)).setAttribute("cod","2476" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("width","100%" );
      ((Element)v.get(129)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(135)).setAttribute("height","8" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:129   */

      /* Empieza nodo:136 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(136)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(140)).setAttribute("nombre","cbMetacaracteresControlFormato" );
      ((Element)v.get(140)).setAttribute("id","datosCampos" );
      ((Element)v.get(140)).setAttribute("size","1" );
      ((Element)v.get(140)).setAttribute("multiple","N" );
      ((Element)v.get(140)).setAttribute("req","N" );
      ((Element)v.get(140)).setAttribute("valorinicial","" );
      ((Element)v.get(140)).setAttribute("textoinicial","" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:142 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","25" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(145)).setAttribute("nombre","btnIncluir" );
      ((Element)v.get(145)).setAttribute("ID","botonContenido" );
      ((Element)v.get(145)).setAttribute("tipo","html" );
      ((Element)v.get(145)).setAttribute("accion","accionIncluir();" );
      ((Element)v.get(145)).setAttribute("estado","false" );
      ((Element)v.get(145)).setAttribute("cod","2477" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("width","100%" );
      ((Element)v.get(136)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:136   */

      /* Empieza nodo:148 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("colspan","9" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:151 / Elemento padre: 102   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(102)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("table"));
      ((Element)v.get(153)).setAttribute("width","731" );
      ((Element)v.get(153)).setAttribute("border","0" );
      ((Element)v.get(153)).setAttribute("align","left" );
      ((Element)v.get(153)).setAttribute("cellspacing","0" );
      ((Element)v.get(153)).setAttribute("cellpadding","0" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("colspan","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:157 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(157)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(161)).setAttribute("nombre","lblModulo" );
      ((Element)v.get(161)).setAttribute("alto","13" );
      ((Element)v.get(161)).setAttribute("filas","1" );
      ((Element)v.get(161)).setAttribute("valor","" );
      ((Element)v.get(161)).setAttribute("id","datosTitle" );
      ((Element)v.get(161)).setAttribute("cod","1257" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","25" );
      ((Element)v.get(163)).setAttribute("height","8" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(165)).setAttribute("nombre","lblCodMensajes" );
      ((Element)v.get(165)).setAttribute("alto","13" );
      ((Element)v.get(165)).setAttribute("filas","1" );
      ((Element)v.get(165)).setAttribute("valor","" );
      ((Element)v.get(165)).setAttribute("id","datosTitle" );
      ((Element)v.get(165)).setAttribute("cod","821" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","25" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(169)).setAttribute("nombre","lblTipoMSG" );
      ((Element)v.get(169)).setAttribute("alto","13" );
      ((Element)v.get(169)).setAttribute("filas","1" );
      ((Element)v.get(169)).setAttribute("valor","" );
      ((Element)v.get(169)).setAttribute("id","datosTitle" );
      ((Element)v.get(169)).setAttribute("cod","1259" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).setAttribute("width","100%" );
      ((Element)v.get(157)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","8" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:157   */

      /* Empieza nodo:172 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).appendChild((Element)v.get(172));

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
      ((Element)v.get(175)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(172)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(176)).setAttribute("nombre","cbModulo" );
      ((Element)v.get(176)).setAttribute("id","datosCampos" );
      ((Element)v.get(176)).setAttribute("size","1" );
      ((Element)v.get(176)).setAttribute("multiple","N" );
      ((Element)v.get(176)).setAttribute("req","S" );
      ((Element)v.get(176)).setAttribute("valorinicial","" );
      ((Element)v.get(176)).setAttribute("textoinicial","" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:178 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","25" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(172)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(181)).setAttribute("nombre","txtCodigoMensaje" );
      ((Element)v.get(181)).setAttribute("id","datosCampos" );
      ((Element)v.get(181)).setAttribute("max","5" );
      ((Element)v.get(181)).setAttribute("tipo","" );
      ((Element)v.get(181)).setAttribute("onchange","" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(181)).setAttribute("req","S" );
      ((Element)v.get(181)).setAttribute("size","5" );
      ((Element)v.get(181)).setAttribute("valor","" );
      ((Element)v.get(181)).setAttribute("validacion","" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","25" );
      ((Element)v.get(183)).setAttribute("height","8" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(185)).setAttribute("nombre","cbTipoMensaje" );
      ((Element)v.get(185)).setAttribute("id","datosCampos" );
      ((Element)v.get(185)).setAttribute("size","1" );
      ((Element)v.get(185)).setAttribute("multiple","N" );
      ((Element)v.get(185)).setAttribute("req","S" );
      ((Element)v.get(185)).setAttribute("valorinicial","" );
      ((Element)v.get(185)).setAttribute("textoinicial","" );
      ((Element)v.get(185)).setAttribute("onchange","tipoMensajeOnChange();" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:187 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).setAttribute("width","100%" );
      ((Element)v.get(172)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:172   */

      /* Empieza nodo:189 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("colspan","7" );
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
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:192 / Elemento padre: 102   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(102)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("table"));
      ((Element)v.get(194)).setAttribute("width","731" );
      ((Element)v.get(194)).setAttribute("border","0" );
      ((Element)v.get(194)).setAttribute("align","left" );
      ((Element)v.get(194)).setAttribute("cellspacing","0" );
      ((Element)v.get(194)).setAttribute("cellpadding","0" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(199)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(199)).setAttribute("alto","13" );
      ((Element)v.get(199)).setAttribute("filas","1" );
      ((Element)v.get(199)).setAttribute("valor","" );
      ((Element)v.get(199)).setAttribute("id","datosTitle" );
      ((Element)v.get(199)).setAttribute("cod","9" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","25" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(203)).setAttribute("nombre","lblBloqueGrupo" );
      ((Element)v.get(203)).setAttribute("alto","13" );
      ((Element)v.get(203)).setAttribute("filas","1" );
      ((Element)v.get(203)).setAttribute("valor","" );
      ((Element)v.get(203)).setAttribute("id","datosTitle" );
      ((Element)v.get(203)).setAttribute("cod","1262" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).setAttribute("width","100%" );
      ((Element)v.get(195)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","8" );
      ((Element)v.get(205)).setAttribute("height","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:195   */

      /* Empieza nodo:206 / Elemento padre: 194   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(194)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(206)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(210)).setAttribute("nombre","atDescripcion" );
      ((Element)v.get(210)).setAttribute("id","datosCampos" );
      ((Element)v.get(210)).setAttribute("cols","50" );
      ((Element)v.get(210)).setAttribute("rows","3" );
      ((Element)v.get(210)).setAttribute("valor","" );
      ((Element)v.get(210)).setAttribute("max","80" );
      ((Element)v.get(210)).setAttribute("req","S" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","25" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(213)).setAttribute("valign","top" );
      ((Element)v.get(206)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(214)).setAttribute("nombre","txtBloqueGrupo" );
      ((Element)v.get(214)).setAttribute("id","datosCampos" );
      ((Element)v.get(214)).setAttribute("max","20" );
      ((Element)v.get(214)).setAttribute("tipo","" );
      ((Element)v.get(214)).setAttribute("onchange","" );
      ((Element)v.get(214)).setAttribute("req","N" );
      ((Element)v.get(214)).setAttribute("size","20" );
      ((Element)v.get(214)).setAttribute("valor","" );
      ((Element)v.get(214)).setAttribute("validacion","" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).setAttribute("width","100%" );
      ((Element)v.get(206)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","8" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:206   */

      /* Empieza nodo:217 / Elemento padre: 194   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(194)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).setAttribute("colspan","5" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","8" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:220 / Elemento padre: 102   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(102)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("table"));
      ((Element)v.get(222)).setAttribute("width","731" );
      ((Element)v.get(222)).setAttribute("border","0" );
      ((Element)v.get(222)).setAttribute("align","left" );
      ((Element)v.get(222)).setAttribute("cellspacing","0" );
      ((Element)v.get(222)).setAttribute("cellpadding","0" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 223   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(227)).setAttribute("nombre","lblPermanencia" );
      ((Element)v.get(227)).setAttribute("alto","13" );
      ((Element)v.get(227)).setAttribute("filas","1" );
      ((Element)v.get(227)).setAttribute("valor","" );
      ((Element)v.get(227)).setAttribute("id","datosTitle" );
      ((Element)v.get(227)).setAttribute("cod","1263" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","25" );
      ((Element)v.get(229)).setAttribute("height","8" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(231)).setAttribute("nombre","lblPermanenciaDesde" );
      ((Element)v.get(231)).setAttribute("alto","13" );
      ((Element)v.get(231)).setAttribute("filas","1" );
      ((Element)v.get(231)).setAttribute("valor","" );
      ((Element)v.get(231)).setAttribute("id","datosTitle" );
      ((Element)v.get(231)).setAttribute("cod","1264" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","25" );
      ((Element)v.get(233)).setAttribute("height","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(235)).setAttribute("nombre","lblHasta" );
      ((Element)v.get(235)).setAttribute("alto","13" );
      ((Element)v.get(235)).setAttribute("filas","1" );
      ((Element)v.get(235)).setAttribute("valor","" );
      ((Element)v.get(235)).setAttribute("id","datosTitle" );
      ((Element)v.get(235)).setAttribute("cod","2210" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","25" );
      ((Element)v.get(237)).setAttribute("height","8" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(239)).setAttribute("nombre","lblTipoPeriodo" );
      ((Element)v.get(239)).setAttribute("alto","13" );
      ((Element)v.get(239)).setAttribute("filas","1" );
      ((Element)v.get(239)).setAttribute("valor","" );
      ((Element)v.get(239)).setAttribute("id","datosTitle" );
      ((Element)v.get(239)).setAttribute("cod","132" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(241)).setAttribute("src","b.gif" );
      ((Element)v.get(241)).setAttribute("width","25" );
      ((Element)v.get(241)).setAttribute("height","8" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(243)).setAttribute("nombre","lblPeriodoDesde" );
      ((Element)v.get(243)).setAttribute("alto","13" );
      ((Element)v.get(243)).setAttribute("filas","1" );
      ((Element)v.get(243)).setAttribute("valor","" );
      ((Element)v.get(243)).setAttribute("id","datosTitle" );
      ((Element)v.get(243)).setAttribute("cod","1175" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","25" );
      ((Element)v.get(245)).setAttribute("height","8" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(247)).setAttribute("nombre","lblPeridodHasta" );
      ((Element)v.get(247)).setAttribute("alto","13" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(247)).setAttribute("filas","1" );
      ((Element)v.get(247)).setAttribute("valor","" );
      ((Element)v.get(247)).setAttribute("id","datosTitle" );
      ((Element)v.get(247)).setAttribute("cod","1176" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).setAttribute("width","100%" );
      ((Element)v.get(223)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","8" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:223   */

      /* Empieza nodo:250 / Elemento padre: 222   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(222)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","8" );
      ((Element)v.get(252)).setAttribute("height","8" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(254)).setAttribute("nombre","cbPermanenciaMensaje" );
      ((Element)v.get(254)).setAttribute("id","datosCampos" );
      ((Element)v.get(254)).setAttribute("size","1" );
      ((Element)v.get(254)).setAttribute("multiple","N" );
      ((Element)v.get(254)).setAttribute("req","S" );
      ((Element)v.get(254)).setAttribute("valorinicial","" );
      ((Element)v.get(254)).setAttribute("textoinicial","" );
      ((Element)v.get(254)).setAttribute("onchange","permanenciaMensajeOnChange();" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:256 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","25" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(250)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(259)).setAttribute("nombre","txtPermanenciaDesde" );
      ((Element)v.get(259)).setAttribute("id","datosCampos" );
      ((Element)v.get(259)).setAttribute("max","10" );
      ((Element)v.get(259)).setAttribute("tipo","" );
      ((Element)v.get(259)).setAttribute("onchange","" );
      ((Element)v.get(259)).setAttribute("req","N" );
      ((Element)v.get(259)).setAttribute("size","12" );
      ((Element)v.get(259)).setAttribute("valor","" );
      ((Element)v.get(259)).setAttribute("validacion","" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).setAttribute("width","25" );
      ((Element)v.get(261)).setAttribute("height","8" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(250)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(263)).setAttribute("nombre","txtPermanenciaHasta" );
      ((Element)v.get(263)).setAttribute("id","datosCampos" );
      ((Element)v.get(263)).setAttribute("max","10" );
      ((Element)v.get(263)).setAttribute("tipo","" );
      ((Element)v.get(263)).setAttribute("onchange","" );
      ((Element)v.get(263)).setAttribute("req","N" );
      ((Element)v.get(263)).setAttribute("size","12" );
      ((Element)v.get(263)).setAttribute("valor","" );
      ((Element)v.get(263)).setAttribute("validacion","" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","25" );
      ((Element)v.get(265)).setAttribute("height","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(267)).setAttribute("nombre","cbTipoPeriodo" );
      ((Element)v.get(267)).setAttribute("id","datosCampos" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(267)).setAttribute("size","1" );
      ((Element)v.get(267)).setAttribute("multiple","N" );
      ((Element)v.get(267)).setAttribute("req","N" );
      ((Element)v.get(267)).setAttribute("valorinicial","" );
      ((Element)v.get(267)).setAttribute("textoinicial","" );
      ((Element)v.get(267)).setAttribute("onchange","tipoPeriodoOnChange();" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:269 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(270)).setAttribute("src","b.gif" );
      ((Element)v.get(270)).setAttribute("width","25" );
      ((Element)v.get(270)).setAttribute("height","8" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:271 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(272)).setAttribute("nombre","cbPeriodoDesde" );
      ((Element)v.get(272)).setAttribute("id","datosCampos" );
      ((Element)v.get(272)).setAttribute("size","1" );
      ((Element)v.get(272)).setAttribute("multiple","N" );
      ((Element)v.get(272)).setAttribute("req","N" );
      ((Element)v.get(272)).setAttribute("valorinicial","" );
      ((Element)v.get(272)).setAttribute("textoinicial","" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:274 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(275)).setAttribute("src","b.gif" );
      ((Element)v.get(275)).setAttribute("width","25" );
      ((Element)v.get(275)).setAttribute("height","8" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:276 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(277)).setAttribute("nombre","cbPeriodoHasta" );
      ((Element)v.get(277)).setAttribute("id","datosCampos" );
      ((Element)v.get(277)).setAttribute("size","1" );
      ((Element)v.get(277)).setAttribute("multiple","N" );
      ((Element)v.get(277)).setAttribute("req","N" );
      ((Element)v.get(277)).setAttribute("valorinicial","" );
      ((Element)v.get(277)).setAttribute("textoinicial","" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:279 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).setAttribute("width","100%" );
      ((Element)v.get(250)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","8" );
      ((Element)v.get(280)).setAttribute("height","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */
      /* Termina nodo:250   */

      /* Empieza nodo:281 / Elemento padre: 222   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(222)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(282)).setAttribute("colspan","4" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(283)).setAttribute("width","8" );
      ((Element)v.get(283)).setAttribute("height","8" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */
      /* Termina nodo:281   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:284 / Elemento padre: 102   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(102)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("td"));
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("table"));
      ((Element)v.get(286)).setAttribute("width","731" );
      ((Element)v.get(286)).setAttribute("border","0" );
      ((Element)v.get(286)).setAttribute("align","left" );
      ((Element)v.get(286)).setAttribute("cellspacing","0" );
      ((Element)v.get(286)).setAttribute("cellpadding","0" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","8" );
      ((Element)v.get(289)).setAttribute("height","8" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(291)).setAttribute("nombre","lblAsignacionDestiantarios" );
      ((Element)v.get(291)).setAttribute("alto","13" );
      ((Element)v.get(291)).setAttribute("filas","1" );
      ((Element)v.get(291)).setAttribute("valor","" );
      ((Element)v.get(291)).setAttribute("id","datosTitle" );
      ((Element)v.get(291)).setAttribute("cod","1267" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(293)).setAttribute("nombre","lblExclusionTipologia" );
      ((Element)v.get(293)).setAttribute("alto","13" );
      ((Element)v.get(293)).setAttribute("filas","1" );
      ((Element)v.get(293)).setAttribute("valor","" );
      ((Element)v.get(293)).setAttribute("id","datosTitle" );
      ((Element)v.get(293)).setAttribute("cod","3164" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).setAttribute("width","100%" );
      ((Element)v.get(287)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(295)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).setAttribute("width","8" );
      ((Element)v.get(295)).setAttribute("height","8" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:287   */

      /* Empieza nodo:296 / Elemento padre: 286   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(286)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("td"));
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).setAttribute("width","8" );
      ((Element)v.get(298)).setAttribute("height","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 296   */
      v.add(doc.createElement("td"));
      ((Element)v.get(299)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(296)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(300)).setAttribute("nombre","cbAsignacionDestinatarios" );
      ((Element)v.get(300)).setAttribute("id","datosCampos" );
      ((Element)v.get(300)).setAttribute("size","5" );
      ((Element)v.get(300)).setAttribute("multiple","S" );
      ((Element)v.get(300)).setAttribute("req","S" );
      ((Element)v.get(300)).setAttribute("valorinicial","" );
      ((Element)v.get(300)).setAttribute("textoinicial","" );
      ((Element)v.get(300)).setAttribute("onchange","asignacionDestinatariosOnChange();" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:302 / Elemento padre: 296   */
      v.add(doc.createElement("td"));
      ((Element)v.get(296)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(303)).setAttribute("src","b.gif" );
      ((Element)v.get(303)).setAttribute("width","25" );
      ((Element)v.get(303)).setAttribute("height","8" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:304 / Elemento padre: 296   */
      v.add(doc.createElement("td"));
      ((Element)v.get(304)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(304)).setAttribute("valign","top" );
      ((Element)v.get(296)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(305)).setAttribute("nombre","chkExclusionTipologia" );
      ((Element)v.get(305)).setAttribute("id","datosCampos" );
      ((Element)v.get(305)).setAttribute("onclick","" );
      ((Element)v.get(305)).setAttribute("check","N" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 296   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).setAttribute("width","100%" );
      ((Element)v.get(296)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
      ((Element)v.get(307)).setAttribute("width","8" );
      ((Element)v.get(307)).setAttribute("height","8" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */
      /* Termina nodo:296   */

      /* Empieza nodo:308 / Elemento padre: 286   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(286)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).setAttribute("colspan","4" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(310)).setAttribute("src","b.gif" );
      ((Element)v.get(310)).setAttribute("width","8" );
      ((Element)v.get(310)).setAttribute("height","8" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */
      /* Termina nodo:308   */
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:102   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:311 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */
      /* Termina nodo:95   */

      /* Empieza nodo:313 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(87)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("td"));
      ((Element)v.get(313)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:316 / Elemento padre: 313   */
      v.add(doc.createElement("td"));
      ((Element)v.get(313)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(317)).setAttribute("nombre","capaBotonAceptar" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("table"));
      ((Element)v.get(319)).setAttribute("width","100%" );
      ((Element)v.get(319)).setAttribute("border","0" );
      ((Element)v.get(319)).setAttribute("align","center" );
      ((Element)v.get(319)).setAttribute("cellspacing","0" );
      ((Element)v.get(319)).setAttribute("cellpadding","0" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).setAttribute("class","botonera" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(322)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(322)).setAttribute("ID","botonContenido" );
      ((Element)v.get(322)).setAttribute("tipo","html" );
      ((Element)v.get(322)).setAttribute("accion","accionAceptar();" );
      ((Element)v.get(322)).setAttribute("estado","false" );
      ((Element)v.get(322)).setAttribute("cod","12" );
      ((Element)v.get(322)).setAttribute("ontab","focaliza('frmConsultarListaConsultoras.TextoFijo')" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:318   */
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:323 / Elemento padre: 313   */
      v.add(doc.createElement("td"));
      ((Element)v.get(313)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(324)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */
      /* Termina nodo:313   */

      /* Empieza nodo:325 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).setAttribute("width","12" );
      ((Element)v.get(326)).setAttribute("align","center" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(327)).setAttribute("src","b.gif" );
      ((Element)v.get(327)).setAttribute("width","12" );
      ((Element)v.get(327)).setAttribute("height","12" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).setAttribute("width","756" );
      ((Element)v.get(325)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(330)).setAttribute("width","12" );
      ((Element)v.get(325)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","12" );
      ((Element)v.get(331)).setAttribute("height","1" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:325   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:13   */


   }

}

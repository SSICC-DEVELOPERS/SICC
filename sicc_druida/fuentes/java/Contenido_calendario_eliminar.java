
import org.w3c.dom.*;
import java.util.ArrayList;

public class Contenido_calendario_eliminar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_calendario_eliminar" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("cod","089" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Eliminar Calendario" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPagina();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Elemento padre:3 / Elemento actual: 4   */
      v.add(doc.createTextNode("    \r          \r    \r       function onLoadPagina(){         \r			configurarMenuSecundario('frmContenido');   \r			fMostrarMensajeError();   \r			set( 'frmContenido.txtAnio', '' );   \r			cargarMarcaCanalDefecto();   \r			focaliza( 'frmContenido.txtAnio' );   \r       }\r    \r          function cargarMarcaCanalDefecto(){   \r            var marcaDefecto = get( 'frmContenido.hMarcaDefecto' );   \r            var canalDefecto = get( 'frmContenido.hCanalDefecto' );   \r            var aMarca = new Array( marcaDefecto );   \r            var aCanal = new Array( canalDefecto );   \r            set( 'frmContenido.cmbMarca', aMarca );   \r            set( 'frmContenido.cmbCanal', aCanal );   \r          }   \r    \r       function fLimpiar(){   \r			set( 'frmContenido.txtAnio', '' );   \r			cargarMarcaCanalDefecto();\r			focaliza( 'frmContenido.txtAnio' );   \r       }\r\r       function fBorrar(){\r          accionEliminar();\r       }\r\r       function despuesError() {\r			fLimpiar();\r       }\r    \r       function accionEliminar(){   \r            if(!sicc_validaciones_generales()){   \r            return false;   \r            }         \r                   if( esNumero( get( 'frmContenido.txtAnio' ) )=='OK' ){   \r                            var aMarca = get( 'frmContenido.cmbMarca' );   \r                            var aCanal = get( 'frmContenido.cmbCanal' );   \r                            var marca = aMarca[0];   \r                            var canal = aCanal[0];   \r                            set( 'frmContenido.hMarca', marca );   \r                            set( 'frmContenido.hCanal', canal );   \r                            set( 'frmContenido.conectorAction', 'LPMantieneCalendario' );   \r                            set( 'frmContenido.accion', 'eliminar' );   \r                            enviaSICC( 'frmContenido' );   \r                   }   \r                   else{   \r                            GestionarMensaje( '2555' );   \r                   }   \r       }   \r  \r\r    \r  "));
      ((Element)v.get(3)).appendChild((Text)v.get(4));

      /* Termina nodo Texto:4   */
      /* Termina nodo:3   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","txtAnio" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","171" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cmbMarca" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","6" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cmbCanal" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","7" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:5   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(9)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(9)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","accion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hPais" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hPrograma" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hIPCliente" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hMarca" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hCanal" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hActividad" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hGrupoDeZona" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("nombre","hCasoDeUso" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","listaFestivos" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","listaTipoFestivos" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hMarcaDefecto" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hCanalDefecto" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(28)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(28)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(28)).setAttribute("borde","0" );
      ((Element)v.get(28)).setAttribute("imagenf","" );
      ((Element)v.get(28)).setAttribute("repeat","" );
      ((Element)v.get(28)).setAttribute("padding","" );
      ((Element)v.get(28)).setAttribute("visibilidad","" );
      ((Element)v.get(28)).setAttribute("contravsb","" );
      ((Element)v.get(28)).setAttribute("x","0" );
      ((Element)v.get(28)).setAttribute("y","0" );
      ((Element)v.get(28)).setAttribute("zindex","" );
      ((Element)v.get(9)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("table"));
      ((Element)v.get(29)).setAttribute("width","100%" );
      ((Element)v.get(29)).setAttribute("border","0" );
      ((Element)v.get(29)).setAttribute("cellspacing","0" );
      ((Element)v.get(29)).setAttribute("cellpadding","0" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).setAttribute("width","12" );
      ((Element)v.get(31)).setAttribute("align","center" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).setAttribute("width","12" );
      ((Element)v.get(32)).setAttribute("height","12" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).setAttribute("width","750" );
      ((Element)v.get(30)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(34)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("width","12" );
      ((Element)v.get(30)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","12" );
      ((Element)v.get(36)).setAttribute("height","1" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:30   */

      /* Empieza nodo:37 / Elemento padre: 29   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(29)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(42)).setAttribute("class","legend" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(43)).setAttribute("nombre","lblDatosCal" );
      ((Element)v.get(43)).setAttribute("alto","13" );
      ((Element)v.get(43)).setAttribute("filas","1" );
      ((Element)v.get(43)).setAttribute("valor","Datos de calendario" );
      ((Element)v.get(43)).setAttribute("id","legend" );
      ((Element)v.get(43)).setAttribute("cod","00492" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("table"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(44)).setAttribute("width","100%" );
      ((Element)v.get(44)).setAttribute("border","0" );
      ((Element)v.get(44)).setAttribute("align","center" );
      ((Element)v.get(44)).setAttribute("cellspacing","0" );
      ((Element)v.get(44)).setAttribute("cellpadding","0" );
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("colspan","4" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","8" );
      ((Element)v.get(47)).setAttribute("height","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:48 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","8" );
      ((Element)v.get(50)).setAttribute("height","8" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","etiqueta1" );
      ((Element)v.get(52)).setAttribute("alto","13" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(52)).setAttribute("id","datosTitle" );
      ((Element)v.get(52)).setAttribute("cod","5" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","25" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(56)).setAttribute("nombre","etiqueta2" );
      ((Element)v.get(56)).setAttribute("alto","13" );
      ((Element)v.get(56)).setAttribute("filas","1" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(56)).setAttribute("id","datosTitle" );
      ((Element)v.get(56)).setAttribute("cod","171" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","25" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(60)).setAttribute("nombre","etiqueta23" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("id","datosTitle" );
      ((Element)v.get(60)).setAttribute("cod","6" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","100%" );
      ((Element)v.get(48)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","8" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:48   */

      /* Empieza nodo:63 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","8" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(63)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(67)).setAttribute("nombre","lblContenidoPais" );
      ((Element)v.get(67)).setAttribute("alto","13" );
      ((Element)v.get(67)).setAttribute("filas","1" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(67)).setAttribute("id","datosCampos" );
      ((Element)v.get(67)).setAttribute("codi","5" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","25" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(63)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(71)).setAttribute("nombre","txtAnio" );
      ((Element)v.get(71)).setAttribute("id","datosCampos" );
      ((Element)v.get(71)).setAttribute("max","4" );
      ((Element)v.get(71)).setAttribute("tipo","" );
      ((Element)v.get(71)).setAttribute("onchange","" );
      ((Element)v.get(71)).setAttribute("req","S" );
      ((Element)v.get(71)).setAttribute("size","4" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(71)).setAttribute("validacion","" );
      ((Element)v.get(71)).setAttribute("onshtab","focaliza('frmContenido.cmbCanal');" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","25" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(63)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(75)).setAttribute("nombre","cmbMarca" );
      ((Element)v.get(75)).setAttribute("id","datosCampos" );
      ((Element)v.get(75)).setAttribute("size","1" );
      ((Element)v.get(75)).setAttribute("multiple","N" );
      ((Element)v.get(75)).setAttribute("req","S" );
      ((Element)v.get(75)).setAttribute("valorinicial","" );
      ((Element)v.get(75)).setAttribute("textoinicial","" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:77 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","100%" );
      ((Element)v.get(63)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","8" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:63   */

      /* Empieza nodo:79 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("colspan","4" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:44   */

      /* Empieza nodo:82 / Elemento padre: 41   */
      v.add(doc.createElement("table"));
      ((Element)v.get(82)).setAttribute("width","100%" );
      ((Element)v.get(82)).setAttribute("border","0" );
      ((Element)v.get(82)).setAttribute("align","center" );
      ((Element)v.get(82)).setAttribute("cellspacing","0" );
      ((Element)v.get(82)).setAttribute("cellpadding","0" );
      ((Element)v.get(41)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(87)).setAttribute("nombre","etiqueta21" );
      ((Element)v.get(87)).setAttribute("alto","13" );
      ((Element)v.get(87)).setAttribute("filas","1" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(87)).setAttribute("id","datosTitle" );
      ((Element)v.get(87)).setAttribute("cod","7" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("width","100%" );
      ((Element)v.get(83)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:83   */

      /* Empieza nodo:90 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(90)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(94)).setAttribute("nombre","cmbCanal" );
      ((Element)v.get(94)).setAttribute("id","datosCampos" );
      ((Element)v.get(94)).setAttribute("size","1" );
      ((Element)v.get(94)).setAttribute("multiple","N" );
      ((Element)v.get(94)).setAttribute("req","S" );
      ((Element)v.get(94)).setAttribute("valorinicial","" );
      ((Element)v.get(94)).setAttribute("textoinicial","" );
      ((Element)v.get(94)).setAttribute("ontab","focaliza('frmContenido.txtAnio');" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:96 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","100%" );
      ((Element)v.get(90)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:90   */

      /* Empieza nodo:98 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("colspan","4" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:82   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:101 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:37   */

      /* Empieza nodo:103 / Elemento padre: 29   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(29)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("table"));
      ((Element)v.get(108)).setAttribute("width","100%" );
      ((Element)v.get(108)).setAttribute("border","0" );
      ((Element)v.get(108)).setAttribute("align","center" );
      ((Element)v.get(108)).setAttribute("cellspacing","0" );
      ((Element)v.get(108)).setAttribute("cellpadding","0" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("class","botonera" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(111)).setAttribute("nombre","btnEliminarCalendario" );
      ((Element)v.get(111)).setAttribute("ID","botonContenido" );
      ((Element)v.get(111)).setAttribute("tipo","html" );
      ((Element)v.get(111)).setAttribute("accion","accionEliminar();" );
      ((Element)v.get(111)).setAttribute("estado","false" );
      ((Element)v.get(111)).setAttribute("cod","1254" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:112 / Elemento padre: 103   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","8" );
      ((Element)v.get(113)).setAttribute("height","12" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:103   */

      /* Empieza nodo:114 / Elemento padre: 29   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(29)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("width","12" );
      ((Element)v.get(115)).setAttribute("align","center" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","12" );
      ((Element)v.get(116)).setAttribute("height","12" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("width","750" );
      ((Element)v.get(114)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("width","12" );
      ((Element)v.get(114)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","12" );
      ((Element)v.get(120)).setAttribute("height","1" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:114   */
      /* Termina nodo:29   */
      /* Termina nodo:28   */
      /* Termina nodo:9   */


   }

}

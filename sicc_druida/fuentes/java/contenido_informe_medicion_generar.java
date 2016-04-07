
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_informe_medicion_generar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_informe_medicion_generar" );
      ((Element)v.get(0)).setAttribute("cod","0804" );
      ((Element)v.get(0)).setAttribute("titulo","Generar Informe de Medición" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoad();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r   \r   \r   function onLoad(){\r      configurarMenuSecundario('Formulario');\r      fMostrarMensajeError();\r      setearPais();\r      var arrayTR = new Array(); \r      arrayTR[0] = '1';\r      set('Formulario.cbTipoReporte',arrayTR);      \r      focaliza('Formulario.cbPais');\r   }\r   function generar(formato){\r     if(sicc_validaciones_generales()){\r       /*recolectarParametros();\r       set('Formulario.conectorAction', 'EDUInformeMedicion');           \r       set('Formulario.accion', 'generar');\r       enviaSICC('Formulario');*/\r       var a = new Object();\r       a.accion = 'generar';\r       a.paisSelec = get('Formulario.cbPais');  \r       a.marca = get('Formulario.cbMarca');\r       a.canal = get('Formulario.cbCanal');\r       a.periodo = get('Formulario.cbPeriodoMedicion');\r       a.codigoPlantilla = get('Formulario.cbCodPlantilla');\r       a.codigoCurso = get('Formulario.cbCodCurso');\r       a.zona = get('Formulario.cbZona');\r       a.modalidadParticipante = get('Formulario.cbModalidadParticipante');\r       a.tamanioMuestra = get('Formulario.txtTamanoMuestraCompara');\r       a.muestraPorVentas = get('Formulario.cbMuestraTomadaVentas');\r       a.tiporeporte = get('Formulario.cbTipoReporte');             \r       mostrarModalSICC('EDUInformeMedicion','generar', a);  \r     }\r   }\r\r   function recolectarParametros(){\r      \r           \r    set('Formulario.paisSelec', get('Formulario.cbPais') );  \r    set('Formulario.marca', get('Formulario.cbMarca'));\r    set('Formulario.canal', get('Formulario.cbCanal'));\r    set('Formulario.periodo', get('Formulario.cbPeriodoMedicion'));\r    set('Formulario.codigoPlantilla', get('Formulario.cbCodPlantilla'));\r    set('Formulario.codigoCurso', get('Formulario.cbCodCurso'));\r    set('Formulario.zona', get('Formulario.cbZona'));\r    set('Formulario.modalidadParticipante', get('Formulario.cbModalidadParticipante'))\r    set('Formulario.tamanioMuestra', get('Formulario.txtTamanoMuestraCompara'))\r    set('Formulario.muestraPorVentas', get('Formulario.cbMuestraTomadaVentas'))\r    set('Formulario.tiporeporte',get('Formulario.cbTipoReporte')) ;    \r       \r   }\r \r   \r\r   function fLimpiar(){\r      var aCombo = new Array(new Array(\"\",\"\"));\r      set_combo('Formulario.cbPeriodoMedicion', aCombo, []);\r      set_combo('Formulario.cbCodCurso', aCombo, []);\r      set_combo('Formulario.cbZona', aCombo, []);\r               \r      focaliza('Formulario.cbPais');\r \r   }\r   \r    function onchangeMarcaCanal(){\r          \r       var marca  = get('Formulario.cbMarca');\r       var canal  = get('Formulario.cbCanal');\r       var pais   = get('Formulario.cbPais');\r       var idioma = get('Formulario.idioma');\r              \r       if(marca != '' && canal != '' && pais != ''){\r	      var aCombo = new Array(new Array(\"\",\"\"));\r		  set_combo('Formulario.cbCodCurso', aCombo, []);\r           \r          var arr2 = new Array();\r          var arr = new Array();\r                \r          arr2[arr2.length] = [\"oidIdioma\", idioma]; \r          arr2[arr2.length] = [\"oidPais\", pais]; \r          arr2[arr2.length] = [\"marca\", marca];\r          arr2[arr2.length] = [\"canal\", canal];\r          \r          arr[arr.length] = [\"oidPais\", pais]; \r          arr[arr.length] = [\"oidMarca\", marca];\r          arr[arr.length] = [\"oidCanal\", canal];\r                  \r          recargaCombo(\"Formulario.cbPeriodoMedicion\",\"PRECargarPeriodos\",\"es.indra.sicc.dtos.cra.DTOPeriodo\",arr2);   \r          recargaCombo('Formulario.cbZona', 'ZONRecargaZonas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', arr );\r                    \r       }\r   \r    } \r \r   \r   function onchangePlantilla(){\r      \r      var marca = get('Formulario.cbMarca');\r      var canal = get('Formulario.cbCanal');\r      var pais = get('Formulario.cbPais');\r      var plantilla = get('Formulario.cbCodPlantilla');\r      \r      if(pais != '' && marca != '' && canal != '' && plantilla != ''){\r         var aCombo = new Array(new Array(\"\",\"\"));\r		 set_combo('Formulario.cbCodCurso', aCombo, []);\r		 var arr = new Array();\r         \r         arr[arr.length] = [\"oidPais\",pais];\r         arr[arr.length] = [\"oidMarca\",marca];\r         arr[arr.length] = [\"oidCanal\",canal];\r         arr[arr.length] = [\"oidPlantilla\",plantilla];\r \r         recargaCombo(\"Formulario.cbCodCurso\",\"EDUObtieneCodigoCurso\", \"es.indra.sicc.dtos.edu.DTORelacionesCurso\",arr); \r         \r         \r      }else{\r  	     var aCombo = new Array(new Array(\"\",\"\"));\r 		 set_combo('Formulario.cbCodCurso', aCombo, []);\r	  }\r   \r   \r   \r   \r   }\r\r\r   function setearPais(){\r      var pais = get('Formulario.pais');\r      \r      iSeleccionado = new Array(); \r      iSeleccionado[0] = pais;\r      set('Formulario.cbPais',iSeleccionado);\r   }\r   \r\r\r  \r  \r  "));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(4)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbPeriodoMedicion" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","2649" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtTamanoMuestraCompara" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","2651" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbMuestraTomadaVentas" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","2652" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbTipoReporte" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","2534" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:6   */
      /* Termina nodo:4   */

      /* Empieza nodo:11 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(11)).setAttribute("nombre","Formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","accion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","idioma" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","pais" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","paisSelec" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","marca" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","canal" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","periodo" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","codigoPlantilla" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","codigoCurso" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","region" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","zona" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","modalidadParticipante" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","tamanioMuestra" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","muestraPorVentas" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","tiporeporte" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 11   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(31)).setAttribute("nombre","capa" );
      ((Element)v.get(11)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("table"));
      ((Element)v.get(32)).setAttribute("width","100%" );
      ((Element)v.get(32)).setAttribute("border","0" );
      ((Element)v.get(32)).setAttribute("cellspacing","0" );
      ((Element)v.get(32)).setAttribute("cellpadding","0" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).setAttribute("width","12" );
      ((Element)v.get(34)).setAttribute("align","center" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).setAttribute("width","12" );
      ((Element)v.get(35)).setAttribute("height","12" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).setAttribute("width","750" );
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("width","12" );
      ((Element)v.get(33)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","12" );
      ((Element)v.get(39)).setAttribute("height","1" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:33   */

      /* Empieza nodo:40 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(45)).setAttribute("class","legend" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(46)).setAttribute("nombre","lblCriteriosSeleccion" );
      ((Element)v.get(46)).setAttribute("filas","1" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(46)).setAttribute("id","legend" );
      ((Element)v.get(46)).setAttribute("cod","00275" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("table"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("width","100%" );
      ((Element)v.get(47)).setAttribute("border","0" );
      ((Element)v.get(47)).setAttribute("align","center" );
      ((Element)v.get(47)).setAttribute("cellspacing","0" );
      ((Element)v.get(47)).setAttribute("cellpadding","0" );
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("table"));
      ((Element)v.get(50)).setAttribute("width","100%" );
      ((Element)v.get(50)).setAttribute("border","0" );
      ((Element)v.get(50)).setAttribute("align","left" );
      ((Element)v.get(50)).setAttribute("cellspacing","0" );
      ((Element)v.get(50)).setAttribute("cellpadding","0" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("colspan","4" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","8" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:54 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(58)).setAttribute("nombre","lblPais" );
      ((Element)v.get(58)).setAttribute("filas","1" );
      ((Element)v.get(58)).setAttribute("id","datosTitle" );
      ((Element)v.get(58)).setAttribute("cod","5" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","25" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(62)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(62)).setAttribute("filas","1" );
      ((Element)v.get(62)).setAttribute("id","datosTitle" );
      ((Element)v.get(62)).setAttribute("cod","6" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","100%" );
      ((Element)v.get(54)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:54   */

      /* Empieza nodo:65 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(65)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(69)).setAttribute("nombre","cbPais" );
      ((Element)v.get(69)).setAttribute("size","1" );
      ((Element)v.get(69)).setAttribute("multiple","N" );
      ((Element)v.get(69)).setAttribute("valorinicial","" );
      ((Element)v.get(69)).setAttribute("textoinicial","" );
      ((Element)v.get(69)).setAttribute("id","datosCampos" );
      ((Element)v.get(69)).setAttribute("req","N" );
      ((Element)v.get(69)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnGenerarInforme');" );
      ((Element)v.get(69)).setAttribute("onchange","onchangeMarcaCanal();" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:71 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","25" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(65)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(74)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(74)).setAttribute("size","1" );
      ((Element)v.get(74)).setAttribute("multiple","N" );
      ((Element)v.get(74)).setAttribute("valorinicial","" );
      ((Element)v.get(74)).setAttribute("textoinicial","" );
      ((Element)v.get(74)).setAttribute("id","datosCampos" );
      ((Element)v.get(74)).setAttribute("req","N" );
      ((Element)v.get(74)).setAttribute("onchange","onchangeMarcaCanal()" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:76 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("width","100%" );
      ((Element)v.get(65)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","8" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:65   */

      /* Empieza nodo:78 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("colspan","4" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","8" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:81 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("table"));
      ((Element)v.get(83)).setAttribute("width","100%" );
      ((Element)v.get(83)).setAttribute("border","0" );
      ((Element)v.get(83)).setAttribute("align","left" );
      ((Element)v.get(83)).setAttribute("cellspacing","0" );
      ((Element)v.get(83)).setAttribute("cellpadding","0" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(88)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(88)).setAttribute("filas","1" );
      ((Element)v.get(88)).setAttribute("id","datosTitle" );
      ((Element)v.get(88)).setAttribute("cod","7" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","25" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(92)).setAttribute("nombre","lblPeriodoMedicion" );
      ((Element)v.get(92)).setAttribute("filas","1" );
      ((Element)v.get(92)).setAttribute("id","datosTitle" );
      ((Element)v.get(92)).setAttribute("cod","2649" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("width","100%" );
      ((Element)v.get(84)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(94)).setAttribute("width","8" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:84   */

      /* Empieza nodo:95 / Elemento padre: 83   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(83)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(95)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(99)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(99)).setAttribute("size","1" );
      ((Element)v.get(99)).setAttribute("multiple","N" );
      ((Element)v.get(99)).setAttribute("valorinicial","" );
      ((Element)v.get(99)).setAttribute("textoinicial","" );
      ((Element)v.get(99)).setAttribute("id","datosCampos" );
      ((Element)v.get(99)).setAttribute("req","N" );
      ((Element)v.get(99)).setAttribute("onchange","onchangeMarcaCanal()" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:101 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","25" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(95)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(104)).setAttribute("nombre","cbPeriodoMedicion" );
      ((Element)v.get(104)).setAttribute("size","1" );
      ((Element)v.get(104)).setAttribute("multiple","N" );
      ((Element)v.get(104)).setAttribute("valorinicial","" );
      ((Element)v.get(104)).setAttribute("textoinicial","" );
      ((Element)v.get(104)).setAttribute("id","datosCampos" );
      ((Element)v.get(104)).setAttribute("req","S" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:106 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","100%" );
      ((Element)v.get(95)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:95   */

      /* Empieza nodo:108 / Elemento padre: 83   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(83)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("colspan","4" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","8" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:111 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("table"));
      ((Element)v.get(113)).setAttribute("width","100%" );
      ((Element)v.get(113)).setAttribute("border","0" );
      ((Element)v.get(113)).setAttribute("align","left" );
      ((Element)v.get(113)).setAttribute("cellspacing","0" );
      ((Element)v.get(113)).setAttribute("cellpadding","0" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","8" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(118)).setAttribute("nombre","lblCodPlantilla" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(118)).setAttribute("filas","1" );
      ((Element)v.get(118)).setAttribute("id","datosTitle" );
      ((Element)v.get(118)).setAttribute("cod","716" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","25" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(122)).setAttribute("nombre","lblCodCurso" );
      ((Element)v.get(122)).setAttribute("filas","1" );
      ((Element)v.get(122)).setAttribute("id","datosTitle" );
      ((Element)v.get(122)).setAttribute("cod","715" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("width","100%" );
      ((Element)v.get(114)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","8" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:114   */

      /* Empieza nodo:125 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(125)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(129)).setAttribute("nombre","cbCodPlantilla" );
      ((Element)v.get(129)).setAttribute("size","1" );
      ((Element)v.get(129)).setAttribute("multiple","N" );
      ((Element)v.get(129)).setAttribute("valorinicial","" );
      ((Element)v.get(129)).setAttribute("textoinicial","" );
      ((Element)v.get(129)).setAttribute("id","datosCampos" );
      ((Element)v.get(129)).setAttribute("req","N" );
      ((Element)v.get(129)).setAttribute("onchange","onchangePlantilla();" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:131 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","25" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(125)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(134)).setAttribute("nombre","cbCodCurso" );
      ((Element)v.get(134)).setAttribute("size","1" );
      ((Element)v.get(134)).setAttribute("multiple","N" );
      ((Element)v.get(134)).setAttribute("valorinicial","" );
      ((Element)v.get(134)).setAttribute("textoinicial","" );
      ((Element)v.get(134)).setAttribute("id","datosCampos" );
      ((Element)v.get(134)).setAttribute("req","N" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:136 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("width","100%" );
      ((Element)v.get(125)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","8" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:125   */

      /* Empieza nodo:138 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("colspan","4" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","8" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:141 / Elemento padre: 47   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("table"));
      ((Element)v.get(143)).setAttribute("width","100%" );
      ((Element)v.get(143)).setAttribute("border","0" );
      ((Element)v.get(143)).setAttribute("align","left" );
      ((Element)v.get(143)).setAttribute("cellspacing","0" );
      ((Element)v.get(143)).setAttribute("cellpadding","0" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(148)).setAttribute("nombre","lblZona" );
      ((Element)v.get(148)).setAttribute("filas","1" );
      ((Element)v.get(148)).setAttribute("id","datosTitle" );
      ((Element)v.get(148)).setAttribute("cod","143" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","25" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(152)).setAttribute("nombre","lblModalidadParticipante" );
      ((Element)v.get(152)).setAttribute("filas","1" );
      ((Element)v.get(152)).setAttribute("id","datosTitle" );
      ((Element)v.get(152)).setAttribute("cod","2650" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","25" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(156)).setAttribute("nombre","lblTamanoMuestraCompara" );
      ((Element)v.get(156)).setAttribute("filas","1" );
      ((Element)v.get(156)).setAttribute("id","datosTitle" );
      ((Element)v.get(156)).setAttribute("cod","2651" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","25" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(160)).setAttribute("nombre","lblMuestraTomadaVentas" );
      ((Element)v.get(160)).setAttribute("filas","1" );
      ((Element)v.get(160)).setAttribute("id","datosTitle" );
      ((Element)v.get(160)).setAttribute("cod","2652" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","25" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(164)).setAttribute("nombre","lblTipoReporte" );
      ((Element)v.get(164)).setAttribute("filas","1" );
      ((Element)v.get(164)).setAttribute("id","datosTitle" );
      ((Element)v.get(164)).setAttribute("cod","2534" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("width","100%" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(144)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","8" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:144   */

      /* Empieza nodo:167 / Elemento padre: 143   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(143)).appendChild((Element)v.get(167));

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
      ((Element)v.get(170)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(167)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(171)).setAttribute("nombre","cbZona" );
      ((Element)v.get(171)).setAttribute("size","1" );
      ((Element)v.get(171)).setAttribute("multiple","N" );
      ((Element)v.get(171)).setAttribute("valorinicial","" );
      ((Element)v.get(171)).setAttribute("textoinicial","" );
      ((Element)v.get(171)).setAttribute("id","datosCampos" );
      ((Element)v.get(171)).setAttribute("req","N" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:173 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","25" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(167)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(176)).setAttribute("nombre","cbModalidadParticipante" );
      ((Element)v.get(176)).setAttribute("size","1" );
      ((Element)v.get(176)).setAttribute("multiple","N" );
      ((Element)v.get(176)).setAttribute("valorinicial","" );
      ((Element)v.get(176)).setAttribute("textoinicial","" );
      ((Element)v.get(176)).setAttribute("id","datosCampos" );
      ((Element)v.get(176)).setAttribute("req","N" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(178)).setAttribute("ID","1" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(179)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(179)).setAttribute("TIPO","STRING" );
      ((Element)v.get(179)).setAttribute("VALOR","1" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 178   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(180)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(180)).setAttribute("TIPO","STRING" );
      ((Element)v.get(180)).setAttribute("VALOR","Apta" );
      ((Element)v.get(178)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:178   */

      /* Empieza nodo:181 / Elemento padre: 177   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(181)).setAttribute("ID","2" );
      ((Element)v.get(177)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(182)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(182)).setAttribute("TIPO","STRING" );
      ((Element)v.get(182)).setAttribute("VALOR","2" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 181   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(183)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(183)).setAttribute("TIPO","STRING" );
      ((Element)v.get(183)).setAttribute("VALOR","Invitado" );
      ((Element)v.get(181)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:181   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:184 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","25" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(167)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(187)).setAttribute("nombre","txtTamanoMuestraCompara" );
      ((Element)v.get(187)).setAttribute("id","datosCampos" );
      ((Element)v.get(187)).setAttribute("max","3" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(187)).setAttribute("tipo","" );
      ((Element)v.get(187)).setAttribute("onchange","" );
      ((Element)v.get(187)).setAttribute("req","S" );
      ((Element)v.get(187)).setAttribute("size","3" );
      ((Element)v.get(187)).setAttribute("valor","" );
      ((Element)v.get(187)).setAttribute("validacion","" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","25" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(167)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(191)).setAttribute("nombre","cbMuestraTomadaVentas" );
      ((Element)v.get(191)).setAttribute("size","1" );
      ((Element)v.get(191)).setAttribute("multiple","N" );
      ((Element)v.get(191)).setAttribute("valorinicial","1" );
      ((Element)v.get(191)).setAttribute("textoinicial","Ascendente" );
      ((Element)v.get(191)).setAttribute("id","datosCampos" );
      ((Element)v.get(191)).setAttribute("req","S" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(193)).setAttribute("ID","1" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(194)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(194)).setAttribute("TIPO","STRING" );
      ((Element)v.get(194)).setAttribute("VALOR","2" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 193   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(195)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(195)).setAttribute("TIPO","STRING" );
      ((Element)v.get(195)).setAttribute("VALOR","Descendente" );
      ((Element)v.get(193)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:196 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","25" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(167)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(199)).setAttribute("nombre","cbTipoReporte" );
      ((Element)v.get(199)).setAttribute("size","1" );
      ((Element)v.get(199)).setAttribute("multiple","N" );
      ((Element)v.get(199)).setAttribute("valorinicial","" );
      ((Element)v.get(199)).setAttribute("textoinicial","" );
      ((Element)v.get(199)).setAttribute("id","datosCampos" );
      ((Element)v.get(199)).setAttribute("req","S" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(201)).setAttribute("ID","1" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(202)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(202)).setAttribute("TIPO","STRING" );
      ((Element)v.get(202)).setAttribute("VALOR","1" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 201   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(203)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(203)).setAttribute("TIPO","STRING" );
      ((Element)v.get(203)).setAttribute("VALOR","Detalle" );
      ((Element)v.get(201)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:201   */

      /* Empieza nodo:204 / Elemento padre: 200   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(204)).setAttribute("ID","2" );
      ((Element)v.get(200)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(205)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(205)).setAttribute("TIPO","STRING" );
      ((Element)v.get(205)).setAttribute("VALOR","2" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 204   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(206)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(206)).setAttribute("TIPO","STRING" );
      ((Element)v.get(206)).setAttribute("VALOR","Resumen" );
      ((Element)v.get(204)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:204   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:207 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).setAttribute("width","100%" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(167)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:167   */

      /* Empieza nodo:209 / Elemento padre: 143   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(143)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).setAttribute("colspan","4" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","8" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:47   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:212 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:40   */

      /* Empieza nodo:214 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("table"));
      ((Element)v.get(219)).setAttribute("width","100%" );
      ((Element)v.get(219)).setAttribute("border","0" );
      ((Element)v.get(219)).setAttribute("align","center" );
      ((Element)v.get(219)).setAttribute("cellspacing","0" );
      ((Element)v.get(219)).setAttribute("cellpadding","0" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).setAttribute("class","botonera" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(222)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(222)).setAttribute("ID","botonContenido" );
      ((Element)v.get(222)).setAttribute("tipo","html" );
      ((Element)v.get(222)).setAttribute("accion","generar();" );
      ((Element)v.get(222)).setAttribute("estado","false" );
      ((Element)v.get(222)).setAttribute("cod","2495" );
      ((Element)v.get(222)).setAttribute("ontab","focaliza('Formulario.cbPais')" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:223 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","8" );
      ((Element)v.get(224)).setAttribute("height","12" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:214   */

      /* Empieza nodo:225 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).setAttribute("width","12" );
      ((Element)v.get(226)).setAttribute("align","center" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","12" );
      ((Element)v.get(227)).setAttribute("height","12" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).setAttribute("width","756" );
      ((Element)v.get(225)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).setAttribute("width","12" );
      ((Element)v.get(225)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","12" );
      ((Element)v.get(231)).setAttribute("height","1" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:225   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:11   */


   }

}

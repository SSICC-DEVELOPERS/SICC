
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_informe_historial_participantes_generar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         

      getXML540(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_informe_historial_participantes_generar" );
      ((Element)v.get(0)).setAttribute("cod","0805" );
      ((Element)v.get(0)).setAttribute("titulo","Generar Informe Historial de Participantes" );
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
      v.add(doc.createTextNode("\r   \r   \r   function onLoad(){\r      configurarMenuSecundario('Formulario');\r      fMostrarMensajeError();\r            focaliza('Formulario.cbPais');\r   }\r   function generar(){\r       /*recolectarParametros();\r       set('Formulario.conectorAction', 'EDUHistorialParticipantes');           \r       set('Formulario.accion', 'generar');\r       enviaSICC('Formulario');*/\r       var a = new Object();\r       a.accion = 'generar';\r       a.paisSelec = get('Formulario.cbPais');  \r       a.marca = get('Formulario.cbMarca');\r       a.tipoCliente = get('Formulario.cbTipoCliente');\r       a.subtipoCliente = get('Formulario.cbSubtipoCliente');\r       a.codigoCliente = get('Formulario.txtCodCliente');    \r       mostrarModalSICC('EDUHistorialParticipantes','generar', a);  \r     \r   }\r\r   function recolectarParametros(){\r      \r           \r    set('Formulario.paisSelec', get('Formulario.cbPais') );  \r    set('Formulario.marca', get('Formulario.cbMarca'));\r    set('Formulario.tipoCliente', get('Formulario.cbTipoCliente'));\r    set('Formulario.subtipoCliente', get('Formulario.cbSubtipoCliente'));\r    set('Formulario.codigoCliente', get('Formulario.txtCodCliente'));\r    \r    \r       \r   }\r \r   \r\r   function fLimpiar(){\r      var aCombo = new Array(new Array(\"\",\"\"));\r      set_combo('Formulario.cbSubtipoCliente', aCombo, []);\r                  \r      focaliza('Formulario.cbPais');\r \r   }\r   \r\r\r   function setearPais(){\r      var pais = get('Formulario.pais');\r      \r      iSeleccionado = new Array(); \r      iSeleccionado[0] = pais;\r      set('Formulario.cbPais',iSeleccionado);\r   }\r   \r   \r   function cambioTipo(){\r          \r     opciones = new Array();\r     set_combo('Formulario.cbSubtipoCliente',opciones);                         \r     tipo = get('Formulario.cbTipoCliente','V');\r     combo_add('Formulario.cbSubtipoCliente', '', '');\r        \r     for(var k=0;k<lstSubtipo.datos.longitud;k++) {\r         for(var y=0;y<tipo.length;y++){\r            if (lstSubtipo.datos.ij(k,1) == tipo[y]){                        \r                combo_add('Formulario.cbSubtipoCliente',lstSubtipo.datos.ij(k,0),lstSubtipo.datos.ij(k,2));\r    \r            }\r         }\r     }\r  }\r\r  function clienteOnBlur() {\r\r        var longiCod = get('Formulario.hLongCliente');\r        var elTexto  = get('Formulario.txtCodCliente');\r\r        if(elTexto.length!=0){\r           var faltantes = longiCod -  elTexto.length;\r           var resultCod = new String(\"\");\r           if(faltantes > 0){\r              for(var t = 0 ; t<faltantes; t++){\r                  resultCod = resultCod + \"0\";\r              }\r         }\r         resultCod = resultCod + elTexto;\r         set('Formulario.txtCodCliente', resultCod);\r        }\r             \r   }\r   \r\r\r  \r  \r \r \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","Formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","idioma" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","pais" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","paisSelec" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","marca" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","tipoCliente" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","subtipoCliente" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","codigoCliente" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hLongCliente" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(20)).setAttribute("nombre","capa" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("table"));
      ((Element)v.get(21)).setAttribute("width","100%" );
      ((Element)v.get(21)).setAttribute("border","0" );
      ((Element)v.get(21)).setAttribute("cellspacing","0" );
      ((Element)v.get(21)).setAttribute("cellpadding","0" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(23)).setAttribute("align","center" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("height","12" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","750" );
      ((Element)v.get(22)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(22)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(28)).setAttribute("height","1" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */
      /* Termina nodo:22   */

      /* Empieza nodo:29 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(34)).setAttribute("class","legend" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(35)).setAttribute("nombre","lblCriteriosSeleccion" );
      ((Element)v.get(35)).setAttribute("filas","1" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(35)).setAttribute("id","legend" );
      ((Element)v.get(35)).setAttribute("cod","00275" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("table"));
      ((Element)v.get(36)).setAttribute("width","100%" );
      ((Element)v.get(36)).setAttribute("border","0" );
      ((Element)v.get(36)).setAttribute("align","center" );
      ((Element)v.get(36)).setAttribute("cellspacing","0" );
      ((Element)v.get(36)).setAttribute("cellpadding","0" );
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("table"));
      ((Element)v.get(39)).setAttribute("width","100%" );
      ((Element)v.get(39)).setAttribute("border","0" );
      ((Element)v.get(39)).setAttribute("align","left" );
      ((Element)v.get(39)).setAttribute("cellspacing","0" );
      ((Element)v.get(39)).setAttribute("cellpadding","0" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("colspan","4" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","8" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:43 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","8" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblPais" );
      ((Element)v.get(47)).setAttribute("filas","1" );
      ((Element)v.get(47)).setAttribute("id","datosTitle" );
      ((Element)v.get(47)).setAttribute("cod","5" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","100%" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(43)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:43   */

      /* Empieza nodo:50 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","8" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(50)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(54)).setAttribute("nombre","cbPais" );
      ((Element)v.get(54)).setAttribute("size","1" );
      ((Element)v.get(54)).setAttribute("multiple","N" );
      ((Element)v.get(54)).setAttribute("valorinicial","" );
      ((Element)v.get(54)).setAttribute("textoinicial","" );
      ((Element)v.get(54)).setAttribute("id","datosCampos" );
      ((Element)v.get(54)).setAttribute("req","N" );
      ((Element)v.get(54)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnGenerarInforme');" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:56 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("width","100%" );
      ((Element)v.get(50)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:50   */

      /* Empieza nodo:58 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("colspan","4" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:61 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("table"));
      ((Element)v.get(63)).setAttribute("width","100%" );
      ((Element)v.get(63)).setAttribute("border","0" );
      ((Element)v.get(63)).setAttribute("align","left" );
      ((Element)v.get(63)).setAttribute("cellspacing","0" );
      ((Element)v.get(63)).setAttribute("cellpadding","0" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","8" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(68)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(68)).setAttribute("filas","1" );
      ((Element)v.get(68)).setAttribute("id","datosTitle" );
      ((Element)v.get(68)).setAttribute("cod","1869" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","25" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(72)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(72)).setAttribute("filas","1" );
      ((Element)v.get(72)).setAttribute("id","datosTitle" );
      ((Element)v.get(72)).setAttribute("cod","595" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("width","100%" );
      ((Element)v.get(64)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","8" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:64   */

      /* Empieza nodo:75 / Elemento padre: 63   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(63)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","8" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(75)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(79)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(79)).setAttribute("size","1" );
      ((Element)v.get(79)).setAttribute("multiple","N" );
      ((Element)v.get(79)).setAttribute("valorinicial","" );
      ((Element)v.get(79)).setAttribute("textoinicial","" );
      ((Element)v.get(79)).setAttribute("id","datosCampos" );
      ((Element)v.get(79)).setAttribute("req","N" );
      ((Element)v.get(79)).setAttribute("onchange","cambioTipo();" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:81 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","25" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(75)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(84)).setAttribute("nombre","cbSubtipoCliente" );
      ((Element)v.get(84)).setAttribute("size","1" );
      ((Element)v.get(84)).setAttribute("multiple","N" );
      ((Element)v.get(84)).setAttribute("valorinicial","" );
      ((Element)v.get(84)).setAttribute("textoinicial","" );
      ((Element)v.get(84)).setAttribute("id","datosCampos" );
      ((Element)v.get(84)).setAttribute("req","N" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:86 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("width","100%" );
      ((Element)v.get(75)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:75   */

      /* Empieza nodo:88 / Elemento padre: 63   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(63)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("colspan","4" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:91 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("table"));
      ((Element)v.get(93)).setAttribute("width","100%" );
      ((Element)v.get(93)).setAttribute("border","0" );
      ((Element)v.get(93)).setAttribute("align","left" );
      ((Element)v.get(93)).setAttribute("cellspacing","0" );
      ((Element)v.get(93)).setAttribute("cellpadding","0" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(98)).setAttribute("nombre","lblCódCliente" );
      ((Element)v.get(98)).setAttribute("filas","1" );
      ((Element)v.get(98)).setAttribute("id","datosTitle" );
      ((Element)v.get(98)).setAttribute("cod","263" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","25" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(102)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(102)).setAttribute("filas","1" );
      ((Element)v.get(102)).setAttribute("id","datosTitle" );
      ((Element)v.get(102)).setAttribute("cod","6" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","100%" );
      ((Element)v.get(94)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:94   */

      /* Empieza nodo:105 / Elemento padre: 93   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(93)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(105)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(109)).setAttribute("nombre","txtCodCliente" );
      ((Element)v.get(109)).setAttribute("id","datosCampos" );
      ((Element)v.get(109)).setAttribute("max","30" );
      ((Element)v.get(109)).setAttribute("tipo","" );
      ((Element)v.get(109)).setAttribute("onchange","" );
      ((Element)v.get(109)).setAttribute("req","N" );
      ((Element)v.get(109)).setAttribute("size","30" );
      ((Element)v.get(109)).setAttribute("valor","" );
      ((Element)v.get(109)).setAttribute("validacion","" );
      ((Element)v.get(109)).setAttribute("onblur","clienteOnBlur();" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","25" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(105)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(113)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(113)).setAttribute("size","1" );
      ((Element)v.get(113)).setAttribute("multiple","N" );
      ((Element)v.get(113)).setAttribute("valorinicial","" );
      ((Element)v.get(113)).setAttribute("textoinicial","" );
      ((Element)v.get(113)).setAttribute("id","datosCampos" );
      ((Element)v.get(113)).setAttribute("req","N" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:115 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("width","100%" );
      ((Element)v.get(105)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","8" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:105   */

      /* Empieza nodo:117 / Elemento padre: 93   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(93)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("colspan","4" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","8" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:36   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:120 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:29   */

      /* Empieza nodo:122 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("table"));
      ((Element)v.get(127)).setAttribute("width","100%" );
      ((Element)v.get(127)).setAttribute("border","0" );
      ((Element)v.get(127)).setAttribute("align","center" );
      ((Element)v.get(127)).setAttribute("cellspacing","0" );
      ((Element)v.get(127)).setAttribute("cellpadding","0" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("class","botonera" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(130)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(130)).setAttribute("ID","botonContenido" );
      ((Element)v.get(130)).setAttribute("tipo","html" );
      ((Element)v.get(130)).setAttribute("accion","generar();" );
      ((Element)v.get(130)).setAttribute("estado","false" );
      ((Element)v.get(130)).setAttribute("cod","2495" );
      ((Element)v.get(130)).setAttribute("ontab","focaliza('Formulario.cbPais')" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:131 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","8" );
      ((Element)v.get(132)).setAttribute("height","12" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:122   */

      /* Empieza nodo:133 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("width","12" );
      ((Element)v.get(134)).setAttribute("align","center" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","12" );
      ((Element)v.get(135)).setAttribute("height","12" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("width","756" );
      ((Element)v.get(133)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("width","12" );
      ((Element)v.get(133)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","12" );
      ((Element)v.get(139)).setAttribute("height","1" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:133   */
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:140 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(140)).setAttribute("nombre","capaSubtipo" );
      ((Element)v.get(140)).setAttribute("alto","3" );
      ((Element)v.get(140)).setAttribute("ancho","624" );
      ((Element)v.get(140)).setAttribute("colorf","" );
      ((Element)v.get(140)).setAttribute("borde","0" );
      ((Element)v.get(140)).setAttribute("imagenf","" );
      ((Element)v.get(140)).setAttribute("repeat","" );
      ((Element)v.get(140)).setAttribute("padding","" );
      ((Element)v.get(140)).setAttribute("visibilidad","visible" );
      ((Element)v.get(140)).setAttribute("contravsb","" );
      ((Element)v.get(140)).setAttribute("x","0" );
      ((Element)v.get(140)).setAttribute("y","165" );
      ((Element)v.get(140)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(141)).setAttribute("seleccion","boton" );
      ((Element)v.get(141)).setAttribute("nombre","lstSubtipo" );
      ((Element)v.get(141)).setAttribute("x","12" );
      ((Element)v.get(141)).setAttribute("y","10" );
      ((Element)v.get(141)).setAttribute("ancho","600" );
      ((Element)v.get(141)).setAttribute("alto","3" );
      ((Element)v.get(141)).setAttribute("multisel","-1" );
      ((Element)v.get(141)).setAttribute("incy","10" );
      ((Element)v.get(141)).setAttribute("incx","10" );
      ((Element)v.get(141)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(141)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(141)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(141)).setAttribute("accion","" );
      ((Element)v.get(141)).setAttribute("sep","|" );
      ((Element)v.get(141)).setAttribute("pixelsborde","2" );
      ((Element)v.get(141)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(142)).setAttribute("nombre","cab1" );
      ((Element)v.get(142)).setAttribute("height","20" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(143)).setAttribute("ancho","40" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(144)).setAttribute("ancho","60" );
      ((Element)v.get(142)).appendChild((Element)v.get(144));

      /* Elemento padre:144 / Elemento actual: 145   */
      v.add(doc.createTextNode("Subtipo"));
      ((Element)v.get(144)).appendChild((Text)v.get(145));

      /* Termina nodo Texto:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(146)).setAttribute("ancho","440" );
      ((Element)v.get(142)).appendChild((Element)v.get(146));

      /* Elemento padre:146 / Elemento actual: 147   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(146)).appendChild((Text)v.get(147));

      /* Termina nodo Texto:147   */
      /* Termina nodo:146   */
      /* Termina nodo:142   */

      /* Empieza nodo:148 / Elemento padre: 141   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(148)).setAttribute("ancho","590" );
      ((Element)v.get(148)).setAttribute("filas","1" );
      ((Element)v.get(148)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(141)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(149)).setAttribute("ancho","40" );
      ((Element)v.get(149)).setAttribute("caracteres","20" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("ancho","60" );
      ((Element)v.get(150)).setAttribute("caracteres","20" );
      ((Element)v.get(148)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("ancho","440" );
      ((Element)v.get(151)).setAttribute("caracteres","30" );
      ((Element)v.get(148)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:148   */

      /* Empieza nodo:152 / Elemento padre: 141   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(141)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:6   */


   }

}

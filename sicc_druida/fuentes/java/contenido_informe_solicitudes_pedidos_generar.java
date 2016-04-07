
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_informe_solicitudes_pedidos_generar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_informe_solicitudes_pedidos_generar" );
      ((Element)v.get(0)).setAttribute("cod","0833" );
      ((Element)v.get(0)).setAttribute("titulo","Generar Informe Solicitudes de Pedidos Facturadas" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","loadPag()" );
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
      v.add(doc.createTextNode("\r   \r   function loadPag(){\r      configurarMenuSecundario('Formulario');\r      focaliza('Formulario.cbMarca');\r   }\r\r    function quitarItemVacio(elemento){\r      var elementoADevolver = new Array();\r     \r      for(var k=0;k<elemento.length;k++) {\r          if (elemento[k] != ''){                            \r             elementoADevolver[elementoADevolver.length] = elemento[k];\r          }\r      }\r         \r      return elementoADevolver;\r      \r   }\r\r   function fLimpiar(){\r \r      var aCombo = new Array(new Array(\"\",\"\"));            \r      set_combo('Formulario.cbAcceso', aCombo, []);            \r      set_combo('Formulario.cbPeriodo', aCombo, []);      \r      set_combo('Formulario.cbTipoSolicitud', aCombo, []);      \r      \r      focaliza('Formulario.cbMarca'); \r   }\r   function generar(){\r\r            /*recolectarParametros();\r            set('Formulario.conectorAction', 'PEDSolicitudesPedidosFacturadas');           \r            set('Formulario.accion', 'generar');\r            enviaSICC('Formulario');*/\r            var a = new Object();\r            a.accion = 'generar';\r            a.marca = get('Formulario.cbMarca');\r            a.canal = get('Formulario.cbCanal');\r            a.acceso = quitarItemVacio(get('Formulario.cbAcceso'));\r            a.periodo = quitarItemVacio(get('Formulario.cbPeriodo'));\r            a.tiposol = quitarItemVacio(get('Formulario.cbTipoSolicitud'));  \r			a.zonas = quitarItemVacio(get('Formulario.cbZona'));\r            mostrarModalSICC('PEDSolicitudesPedidosFacturadas','generar', a);  \r\r   }\r  function recolectarParametros(){\r        set('Formulario.marca',get('Formulario.cbMarca')) ;\r        set('Formulario.canal',get('Formulario.cbCanal')) ;\r        set('Formulario.acceso', get('Formulario.cbAcceso'));\r        set('Formulario.periodo',get('Formulario.cbPeriodo'));\r        set('Formulario.tiposol',get('Formulario.cbTipoSolicitud'));\r  }\r    function onchangeCanal(){\r      onchangeMarcaCanal();\r      cargaAccesos();\r    }\r\r    function cargaAccesos(){\r        \r       canal  = get('Formulario.cbCanal');\r       pais   = get('Formulario.pais');\r       idioma = get('Formulario.idioma');\r        \r       if(canal != ''){\r       \r          var arr = new Array();\r               \r          arr[arr.length] = [\"oidIdioma\", idioma]; \r          arr[arr.length] = [\"oidPais\", pais]; \r                    arr[arr.length] = [\"oid\", canal];\r             \r          recargaCombo(\"Formulario.cbAcceso\",\"SEGObtieneAccesosPorCanal\",\"es.indra.sicc.util.DTOOID\",arr);\r       }else{\r          var aCombo = new Array(new Array(\"\",\"\"));\r          set_combo('Formulario.cbAcceso', aCombo, []);\r       }\r    } \r    function onchangeMarcaCanal(){\r     tipoM = get('Formulario.cbMarca','V');\r     tipoC = get('Formulario.cbCanal','V');\r\r          if(tipoM != '' && tipoC != ''){\r         var arr = new Array();     \r         pais   = get('Formulario.pais');\r         idioma = get('Formulario.idioma');\r          \r         arr[arr.length] = [\"oidIdioma\", idioma]; \r         arr[arr.length] = [\"oidPais\", pais]; \r         arr[arr.length] = [\"marca\", tipoM];\r         arr[arr.length] = [\"canal\", tipoC];\r     \r         recargaCombo(\"Formulario.cbPeriodo\",\"REPCargarPeriodos\",\"es.indra.sicc.dtos.cra.DTOPeriodo\",arr);\r          \r     } else {\r         var aCombo = new Array(new Array(\"\",\"\"));\r         set_combo('Formulario.cbPeriodo', aCombo, []); \r     }\r         \r	  cargaZonas();\r    cambioAccesoMarcaCanal();\r    } \r\r   function cargaZonas(){\r      var marca = get('Formulario.cbMarca') ;\r	  var canal = get('Formulario.cbCanal');\r      var pais  = get('Formulario.pais');\r\r	  if(marca != ''  && canal != ''){\r    	   var arr = new Array();\r                     \r           arr[arr.length] = [\"oidPais\", pais]; \r           arr[arr.length] = [\"oidMarca\", marca];\r           arr[arr.length] = [\"oidCanal\", canal];\r\r	       recargaCombo('Formulario.cbZona', 'ZONRecargaZonas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',arr);\r  \r	  }else{\r          var aCombo = new Array(new Array(\"\",\"\"));\r          set_combo('Formulario.cbZona', aCombo, []);\r	  \r	  \r	  }\r   \r   \r   \r   }\r\r   \r   function cambioAccesoMarcaCanal(){\r         \r     opcionesTipoSoli = new Array();     \r     set_combo('Formulario.cbTipoSolicitud',opcionesTipoSoli);        \r     tipoM = get('Formulario.cbMarca','V');\r     tipoC = get('Formulario.cbCanal','V');\r     tipoR = get('Formulario.cbAcceso','V');          \r     combo_add('Formulario.cbTipoSolicitud', '', '');\r       \r     for(var k=0;k<lstTipoSoli.datos.longitud;k++) {\r        for(var y=0;y<tipoM.length;y++){\r          for(var x=0;x<tipoC.length;x++){\r            for(var z=0;z<tipoR.length;z++){              \r               if ((lstTipoSoli.datos.ij(k,3) == tipoM[y])&&\r                   (lstTipoSoli.datos.ij(k,4) == tipoC[x])&&\r                   (lstTipoSoli.datos.ij(k,2) == tipoR[z])){\r                  combo_add('Formulario.cbTipoSolicitud',lstTipoSoli.datos.ij(k,0),lstTipoSoli.datos.ij(k,1));\r        \r               }\r             }\r           }\r        }\r    }  \r  }    \r    function cargaAccesos(){\r        \r       canal  = get('Formulario.cbCanal');\r       pais   = get('Formulario.pais');\r       idioma = get('Formulario.idioma');\r        \r       if(canal != ''){\r       \r          var arr = new Array();\r               \r          arr[arr.length] = [\"oidIdioma\", idioma]; \r          arr[arr.length] = [\"oidPais\", pais]; \r                    arr[arr.length] = [\"oid\", canal];\r             \r          recargaCombo(\"Formulario.cbAcceso\",\"SEGObtieneAccesosPorCanal\",\"es.indra.sicc.util.DTOOID\",arr);\r       }else{\r          var aCombo = new Array(new Array(\"\",\"\"));\r          set_combo('Formulario.cbAcceso', aCombo, []);\r       }\r    } \r        function arrayComponentes(){\r              var arr = new Array();               \r              arr[arr.length]= new Array(\"cbMarca\",\"\");\r              arr[arr.length]= new Array(\"cbCanal\",\"\");              \r              arr[arr.length]= new Array(\"cbAcceso\",\"\");\r              arr[arr.length]= new Array(\"cbPeriodo\",\"\");\r              arr[arr.length]= new Array(\"cbTipoSolicitud\",\"\");\r              arr[arr.length]= new Array(\"btnGenerarInforme\",\"BOTON\");\r\r              return arr;\r          }\r          function tabGenerico(nombreComp, tipotab){       \r            var arr = arrayComponentes();\r            var tabular = false;\r            var nombreFormulario = getFormularioSICC();\r            var j = 0;\r            var k = arr.length;\r            if (tipotab != \"sh\") {\r                j = j-1;                \r                k = k-1;\r            }\r\r            while(j<k){\r                var t;\r                if(tipotab == \"sh\"){\r                  k--;\r                  t = k;\r                } else{\r                  j++;\r                  t = j;                  \r                }\r                  \r                var nombre = arr[t][0];\r                var tipo = arr[t][1];\r                if (tabular==false){\r                  if (nombreComp==nombre){\r                      tabular=true;\r                      if (tipotab == \"sh\"){\r                        if (k==0) k= arr.length;\r                      } else {\r                        if ((j+1)==arr.length)  j = -1;\r                      }\r                  }                \r                } else {\r                  try {\r                    var name = nombreFormulario+\".\"+nombre;\r                    if (tipo==\"BOTONXY\"){\r                       focalizaBotonHTML_XY(nombre);\r                    } else if (tipo==\"BOTON\") {\r                       focalizaBotonHTML(\"botonContenido\",nombre)\r                    } else {\r                       focaliza(name);\r                    }\r                    return;\r                  } catch (e) {\r                  }\r                }\r            }\r          } \r   \r   function cambioAcceso(){\r    cambioAccesoMarcaCanal();\r  }\r   \r   \r"));
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
      ((Element)v.get(8)).setAttribute("valor","PEDSolicitudesPedidosFacturadas" );
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
      ((Element)v.get(14)).setAttribute("nombre","marca" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","canal" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","acceso" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","periodo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","tiposol" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(19)).setAttribute("nombre","capa" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("table"));
      ((Element)v.get(20)).setAttribute("width","100%" );
      ((Element)v.get(20)).setAttribute("border","0" );
      ((Element)v.get(20)).setAttribute("cellspacing","0" );
      ((Element)v.get(20)).setAttribute("cellpadding","0" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(22)).setAttribute("align","center" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(23)).setAttribute("height","12" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","750" );
      ((Element)v.get(21)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(21)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(27)).setAttribute("height","1" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */
      /* Termina nodo:21   */

      /* Empieza nodo:28 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(33)).setAttribute("class","legend" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(34)).setAttribute("nombre","lblCriteriosSeleccion" );
      ((Element)v.get(34)).setAttribute("filas","1" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(34)).setAttribute("id","legend" );
      ((Element)v.get(34)).setAttribute("cod","00275" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 32   */
      v.add(doc.createElement("table"));
      ((Element)v.get(35)).setAttribute("width","100%" );
      ((Element)v.get(35)).setAttribute("border","0" );
      ((Element)v.get(35)).setAttribute("align","center" );
      ((Element)v.get(35)).setAttribute("cellspacing","0" );
      ((Element)v.get(35)).setAttribute("cellpadding","0" );
      ((Element)v.get(32)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("table"));
      ((Element)v.get(38)).setAttribute("width","100%" );
      ((Element)v.get(38)).setAttribute("border","0" );
      ((Element)v.get(38)).setAttribute("align","left" );
      ((Element)v.get(38)).setAttribute("cellspacing","0" );
      ((Element)v.get(38)).setAttribute("cellpadding","0" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","8" );
      ((Element)v.get(41)).setAttribute("height","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(43)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(43)).setAttribute("filas","1" );
      ((Element)v.get(43)).setAttribute("id","datosTitle" );
      ((Element)v.get(43)).setAttribute("cod","6" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","25" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(47)).setAttribute("filas","1" );
      ((Element)v.get(47)).setAttribute("id","datosTitle" );
      ((Element)v.get(47)).setAttribute("cod","7" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(48)).setAttribute("width","100%" );
      ((Element)v.get(39)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:39   */

      /* Empieza nodo:50 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(50));

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
      ((Element)v.get(54)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(54)).setAttribute("size","1" );
      ((Element)v.get(54)).setAttribute("multiple","N" );
      ((Element)v.get(54)).setAttribute("valorinicial","" );
      ((Element)v.get(54)).setAttribute("textoinicial","" );
      ((Element)v.get(54)).setAttribute("id","datosCampos" );
      ((Element)v.get(54)).setAttribute("req","N" );
      ((Element)v.get(54)).setAttribute("onchange","onchangeMarcaCanal();" );
      ((Element)v.get(54)).setAttribute("ontab","tabGenerico('cbMarca');" );
      ((Element)v.get(54)).setAttribute("onshtab","tabGenerico('cbMarca','sh');" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:56 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","25" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(58)).setAttribute("valign","top" );
      ((Element)v.get(50)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(59)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(59)).setAttribute("size","1" );
      ((Element)v.get(59)).setAttribute("multiple","N" );
      ((Element)v.get(59)).setAttribute("valorinicial","" );
      ((Element)v.get(59)).setAttribute("textoinicial","" );
      ((Element)v.get(59)).setAttribute("id","datosCampos" );
      ((Element)v.get(59)).setAttribute("req","N" );
      ((Element)v.get(59)).setAttribute("onchange","onchangeCanal();" );
      ((Element)v.get(59)).setAttribute("ontab","tabGenerico('cbCanal');" );
      ((Element)v.get(59)).setAttribute("onshtab","tabGenerico('cbCanal','sh');" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:61 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","100%" );
      ((Element)v.get(50)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","8" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:50   */

      /* Empieza nodo:63 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("colspan","4" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","8" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:66 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("table"));
      ((Element)v.get(68)).setAttribute("width","100%" );
      ((Element)v.get(68)).setAttribute("border","0" );
      ((Element)v.get(68)).setAttribute("align","left" );
      ((Element)v.get(68)).setAttribute("cellspacing","0" );
      ((Element)v.get(68)).setAttribute("cellpadding","0" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(73)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("id","datosTitle" );
      ((Element)v.get(73)).setAttribute("cod","10" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","25" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(77)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(77)).setAttribute("filas","1" );
      ((Element)v.get(77)).setAttribute("id","datosTitle" );
      ((Element)v.get(77)).setAttribute("cod","276" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","100%" );
      ((Element)v.get(69)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:69   */

      /* Empieza nodo:80 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(84)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(84)).setAttribute("size","5" );
      ((Element)v.get(84)).setAttribute("multiple","S" );
      ((Element)v.get(84)).setAttribute("valorinicial","" );
      ((Element)v.get(84)).setAttribute("textoinicial","" );
      ((Element)v.get(84)).setAttribute("id","datosCampos" );
      ((Element)v.get(84)).setAttribute("req","N" );
      ((Element)v.get(84)).setAttribute("onchange","cambioAcceso();" );
      ((Element)v.get(84)).setAttribute("ontab","tabGenerico('cbAcceso');" );
      ((Element)v.get(84)).setAttribute("onshtab","tabGenerico('cbAcceso','sh');" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:86 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","25" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(89)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(89)).setAttribute("size","5" );
      ((Element)v.get(89)).setAttribute("multiple","S" );
      ((Element)v.get(89)).setAttribute("valorinicial","" );
      ((Element)v.get(89)).setAttribute("textoinicial","" );
      ((Element)v.get(89)).setAttribute("id","datosCampos" );
      ((Element)v.get(89)).setAttribute("req","N" );
      ((Element)v.get(89)).setAttribute("ontab","tabGenerico('cbPeriodo');" );
      ((Element)v.get(89)).setAttribute("onshtab","tabGenerico('cbPeriodo','sh');" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:91 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","100%" );
      ((Element)v.get(80)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:80   */

      /* Empieza nodo:93 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("colspan","4" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","8" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:96 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("table"));
      ((Element)v.get(98)).setAttribute("width","100%" );
      ((Element)v.get(98)).setAttribute("border","0" );
      ((Element)v.get(98)).setAttribute("align","left" );
      ((Element)v.get(98)).setAttribute("cellspacing","0" );
      ((Element)v.get(98)).setAttribute("cellpadding","0" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(103)).setAttribute("nombre","lblTipoSolicitud" );
      ((Element)v.get(103)).setAttribute("filas","1" );
      ((Element)v.get(103)).setAttribute("id","datosTitle" );
      ((Element)v.get(103)).setAttribute("cod","415" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","25" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(107)).setAttribute("nombre","lblZona" );
      ((Element)v.get(107)).setAttribute("filas","1" );
      ((Element)v.get(107)).setAttribute("id","datosTitle" );
      ((Element)v.get(107)).setAttribute("cod","143" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","100%" );
      ((Element)v.get(99)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:99   */

      /* Empieza nodo:110 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(110));

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
      ((Element)v.get(113)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(110)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(114)).setAttribute("nombre","cbTipoSolicitud" );
      ((Element)v.get(114)).setAttribute("size","5" );
      ((Element)v.get(114)).setAttribute("multiple","S" );
      ((Element)v.get(114)).setAttribute("valorinicial","" );
      ((Element)v.get(114)).setAttribute("textoinicial","" );
      ((Element)v.get(114)).setAttribute("id","datosCampos" );
      ((Element)v.get(114)).setAttribute("req","N" );
      ((Element)v.get(114)).setAttribute("ontab","tabGenerico('cbTipoSolicitud');" );
      ((Element)v.get(114)).setAttribute("onshtab","tabGenerico('cbTipoSolicitud','sh');" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:116 / Elemento padre: 110   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","25" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(110)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(119)).setAttribute("nombre","cbZona" );
      ((Element)v.get(119)).setAttribute("size","5" );
      ((Element)v.get(119)).setAttribute("multiple","S" );
      ((Element)v.get(119)).setAttribute("valorinicial","" );
      ((Element)v.get(119)).setAttribute("textoinicial","" );
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(119)).setAttribute("req","N" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:121 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("width","100%" );
      ((Element)v.get(110)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:110   */

      /* Empieza nodo:123 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("colspan","4" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:35   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:126 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:28   */

      /* Empieza nodo:128 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("table"));
      ((Element)v.get(133)).setAttribute("width","100%" );
      ((Element)v.get(133)).setAttribute("border","0" );
      ((Element)v.get(133)).setAttribute("align","center" );
      ((Element)v.get(133)).setAttribute("cellspacing","0" );
      ((Element)v.get(133)).setAttribute("cellpadding","0" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("class","botonera" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(136)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(136)).setAttribute("ID","botonContenido" );
      ((Element)v.get(136)).setAttribute("tipo","html" );
      ((Element)v.get(136)).setAttribute("accion","generar();" );
      ((Element)v.get(136)).setAttribute("estado","false" );
      ((Element)v.get(136)).setAttribute("cod","2495" );
      ((Element)v.get(136)).setAttribute("ontab","tabGenerico('btnGenerarInforme');" );
      ((Element)v.get(136)).setAttribute("onshtab","tabGenerico('btnGenerarInforme','sh');" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:137 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","12" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:128   */

      /* Empieza nodo:139 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("width","12" );
      ((Element)v.get(140)).setAttribute("align","center" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","12" );
      ((Element)v.get(141)).setAttribute("height","12" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("width","756" );
      ((Element)v.get(139)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("width","12" );
      ((Element)v.get(139)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","12" );
      ((Element)v.get(145)).setAttribute("height","1" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:139   */
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:146 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(146)).setAttribute("nombre","capaAcceso" );
      ((Element)v.get(146)).setAttribute("alto","3" );
      ((Element)v.get(146)).setAttribute("ancho","624" );
      ((Element)v.get(146)).setAttribute("colorf","" );
      ((Element)v.get(146)).setAttribute("borde","0" );
      ((Element)v.get(146)).setAttribute("imagenf","" );
      ((Element)v.get(146)).setAttribute("repeat","" );
      ((Element)v.get(146)).setAttribute("padding","" );
      ((Element)v.get(146)).setAttribute("visibilidad","visible" );
      ((Element)v.get(146)).setAttribute("contravsb","" );
      ((Element)v.get(146)).setAttribute("x","0" );
      ((Element)v.get(146)).setAttribute("y","165" );
      ((Element)v.get(146)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(147)).setAttribute("seleccion","boton" );
      ((Element)v.get(147)).setAttribute("nombre","lstAcceso" );
      ((Element)v.get(147)).setAttribute("x","12" );
      ((Element)v.get(147)).setAttribute("y","10" );
      ((Element)v.get(147)).setAttribute("ancho","600" );
      ((Element)v.get(147)).setAttribute("alto","3" );
      ((Element)v.get(147)).setAttribute("multisel","-1" );
      ((Element)v.get(147)).setAttribute("incy","10" );
      ((Element)v.get(147)).setAttribute("incx","10" );
      ((Element)v.get(147)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(147)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(147)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(147)).setAttribute("accion","" );
      ((Element)v.get(147)).setAttribute("sep","|" );
      ((Element)v.get(147)).setAttribute("pixelsborde","2" );
      ((Element)v.get(147)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(148)).setAttribute("nombre","cab1" );
      ((Element)v.get(148)).setAttribute("height","20" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(149)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(149)).setAttribute("ancho","40" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Elemento padre:149 / Elemento actual: 150   */
      v.add(doc.createTextNode("Acceso"));
      ((Element)v.get(149)).appendChild((Text)v.get(150));

      /* Termina nodo Texto:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(151)).setAttribute("ancho","60" );
      ((Element)v.get(148)).appendChild((Element)v.get(151));

      /* Elemento padre:151 / Elemento actual: 152   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(151)).appendChild((Text)v.get(152));

      /* Termina nodo Texto:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(153)).setAttribute("ancho","440" );
      ((Element)v.get(148)).appendChild((Element)v.get(153));

      /* Elemento padre:153 / Elemento actual: 154   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(153)).appendChild((Text)v.get(154));

      /* Termina nodo Texto:154   */
      /* Termina nodo:153   */
      /* Termina nodo:148   */

      /* Empieza nodo:155 / Elemento padre: 147   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(155)).setAttribute("ancho","590" );
      ((Element)v.get(155)).setAttribute("filas","1" );
      ((Element)v.get(155)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(147)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("ancho","40" );
      ((Element)v.get(156)).setAttribute("caracteres","20" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 155   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("ancho","60" );
      ((Element)v.get(157)).setAttribute("caracteres","20" );
      ((Element)v.get(155)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 155   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("ancho","440" );
      ((Element)v.get(158)).setAttribute("caracteres","30" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(155)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:155   */

      /* Empieza nodo:159 / Elemento padre: 147   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(147)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:160 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(160)).setAttribute("nombre","capaPeriodo" );
      ((Element)v.get(160)).setAttribute("alto","3" );
      ((Element)v.get(160)).setAttribute("ancho","624" );
      ((Element)v.get(160)).setAttribute("colorf","" );
      ((Element)v.get(160)).setAttribute("borde","0" );
      ((Element)v.get(160)).setAttribute("imagenf","" );
      ((Element)v.get(160)).setAttribute("repeat","" );
      ((Element)v.get(160)).setAttribute("padding","" );
      ((Element)v.get(160)).setAttribute("visibilidad","visible" );
      ((Element)v.get(160)).setAttribute("contravsb","" );
      ((Element)v.get(160)).setAttribute("x","0" );
      ((Element)v.get(160)).setAttribute("y","165" );
      ((Element)v.get(160)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(161)).setAttribute("seleccion","boton" );
      ((Element)v.get(161)).setAttribute("nombre","lstPeriodo" );
      ((Element)v.get(161)).setAttribute("x","12" );
      ((Element)v.get(161)).setAttribute("y","10" );
      ((Element)v.get(161)).setAttribute("ancho","600" );
      ((Element)v.get(161)).setAttribute("alto","3" );
      ((Element)v.get(161)).setAttribute("multisel","-1" );
      ((Element)v.get(161)).setAttribute("incy","10" );
      ((Element)v.get(161)).setAttribute("incx","10" );
      ((Element)v.get(161)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(161)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(161)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(161)).setAttribute("accion","" );
      ((Element)v.get(161)).setAttribute("sep","|" );
      ((Element)v.get(161)).setAttribute("pixelsborde","2" );
      ((Element)v.get(161)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(162)).setAttribute("nombre","cab1" );
      ((Element)v.get(162)).setAttribute("height","20" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(163)).setAttribute("ancho","40" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Elemento padre:163 / Elemento actual: 164   */
      v.add(doc.createTextNode("Periodo"));
      ((Element)v.get(163)).appendChild((Text)v.get(164));

      /* Termina nodo Texto:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 162   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(165)).setAttribute("ancho","60" );
      ((Element)v.get(162)).appendChild((Element)v.get(165));

      /* Elemento padre:165 / Elemento actual: 166   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(165)).appendChild((Text)v.get(166));

      /* Termina nodo Texto:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 162   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(167)).setAttribute("ancho","440" );
      ((Element)v.get(162)).appendChild((Element)v.get(167));

      /* Elemento padre:167 / Elemento actual: 168   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(167)).appendChild((Text)v.get(168));

      /* Termina nodo Texto:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 162   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(169)).setAttribute("ancho","440" );
      ((Element)v.get(162)).appendChild((Element)v.get(169));

      /* Elemento padre:169 / Elemento actual: 170   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(169)).appendChild((Text)v.get(170));

      /* Termina nodo Texto:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 162   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(171)).setAttribute("ancho","440" );
      ((Element)v.get(162)).appendChild((Element)v.get(171));

      /* Elemento padre:171 / Elemento actual: 172   */
      v.add(doc.createTextNode("FechaInicio"));
      ((Element)v.get(171)).appendChild((Text)v.get(172));

      /* Termina nodo Texto:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 162   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(173)).setAttribute("ancho","440" );
      ((Element)v.get(162)).appendChild((Element)v.get(173));

      /* Elemento padre:173 / Elemento actual: 174   */
      v.add(doc.createTextNode("FechaFin"));
      ((Element)v.get(173)).appendChild((Text)v.get(174));

      /* Termina nodo Texto:174   */
      /* Termina nodo:173   */
      /* Termina nodo:162   */

      /* Empieza nodo:175 / Elemento padre: 161   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(175)).setAttribute("ancho","590" );
      ((Element)v.get(175)).setAttribute("filas","1" );
      ((Element)v.get(175)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(161)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("ancho","40" );
      ((Element)v.get(176)).setAttribute("caracteres","20" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 175   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("ancho","60" );
      ((Element)v.get(177)).setAttribute("caracteres","20" );
      ((Element)v.get(175)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 175   */
      v.add(doc.createElement("COL"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(178)).setAttribute("ancho","440" );
      ((Element)v.get(178)).setAttribute("caracteres","30" );
      ((Element)v.get(175)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 175   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("ancho","440" );
      ((Element)v.get(179)).setAttribute("caracteres","30" );
      ((Element)v.get(175)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 175   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("ancho","440" );
      ((Element)v.get(180)).setAttribute("caracteres","30" );
      ((Element)v.get(175)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 175   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("ancho","440" );
      ((Element)v.get(181)).setAttribute("caracteres","30" );
      ((Element)v.get(175)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:175   */

      /* Empieza nodo:182 / Elemento padre: 161   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(161)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:183 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(183)).setAttribute("nombre","capaZona" );
      ((Element)v.get(183)).setAttribute("alto","3" );
      ((Element)v.get(183)).setAttribute("ancho","624" );
      ((Element)v.get(183)).setAttribute("colorf","" );
      ((Element)v.get(183)).setAttribute("borde","0" );
      ((Element)v.get(183)).setAttribute("imagenf","" );
      ((Element)v.get(183)).setAttribute("repeat","" );
      ((Element)v.get(183)).setAttribute("padding","" );
      ((Element)v.get(183)).setAttribute("visibilidad","visible" );
      ((Element)v.get(183)).setAttribute("contravsb","" );
      ((Element)v.get(183)).setAttribute("x","0" );
      ((Element)v.get(183)).setAttribute("y","165" );
      ((Element)v.get(183)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(184)).setAttribute("seleccion","boton" );
      ((Element)v.get(184)).setAttribute("nombre","lstZona" );
      ((Element)v.get(184)).setAttribute("x","12" );
      ((Element)v.get(184)).setAttribute("y","10" );
      ((Element)v.get(184)).setAttribute("ancho","600" );
      ((Element)v.get(184)).setAttribute("alto","3" );
      ((Element)v.get(184)).setAttribute("multisel","-1" );
      ((Element)v.get(184)).setAttribute("incy","10" );
      ((Element)v.get(184)).setAttribute("incx","10" );
      ((Element)v.get(184)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(184)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(184)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(184)).setAttribute("accion","" );
      ((Element)v.get(184)).setAttribute("sep","|" );
      ((Element)v.get(184)).setAttribute("pixelsborde","2" );
      ((Element)v.get(184)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(185)).setAttribute("nombre","cab1" );
      ((Element)v.get(185)).setAttribute("height","20" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(186)).setAttribute("ancho","40" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Elemento padre:186 / Elemento actual: 187   */
      v.add(doc.createTextNode("Zona"));
      ((Element)v.get(186)).appendChild((Text)v.get(187));

      /* Termina nodo Texto:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(188)).setAttribute("ancho","40" );
      ((Element)v.get(185)).appendChild((Element)v.get(188));

      /* Elemento padre:188 / Elemento actual: 189   */
      v.add(doc.createTextNode("Region"));
      ((Element)v.get(188)).appendChild((Text)v.get(189));

      /* Termina nodo Texto:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(190)).setAttribute("ancho","60" );
      ((Element)v.get(185)).appendChild((Element)v.get(190));

      /* Elemento padre:190 / Elemento actual: 191   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(190)).appendChild((Text)v.get(191));

      /* Termina nodo Texto:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(192)).setAttribute("ancho","440" );
      ((Element)v.get(185)).appendChild((Element)v.get(192));

      /* Elemento padre:192 / Elemento actual: 193   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(192)).appendChild((Text)v.get(193));

      /* Termina nodo Texto:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(194)).setAttribute("ancho","440" );
      ((Element)v.get(185)).appendChild((Element)v.get(194));

      /* Elemento padre:194 / Elemento actual: 195   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(194)).appendChild((Text)v.get(195));

      /* Termina nodo Texto:195   */
      /* Termina nodo:194   */
      /* Termina nodo:185   */

      /* Empieza nodo:196 / Elemento padre: 184   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(196)).setAttribute("ancho","590" );
      ((Element)v.get(196)).setAttribute("filas","1" );
      ((Element)v.get(196)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(184)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(197)).setAttribute("ancho","40" );
      ((Element)v.get(197)).setAttribute("caracteres","20" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("ancho","60" );
      ((Element)v.get(198)).setAttribute("caracteres","20" );
      ((Element)v.get(196)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(199)).setAttribute("ancho","440" );
      ((Element)v.get(199)).setAttribute("caracteres","30" );
      ((Element)v.get(196)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(200)).setAttribute("ancho","440" );
      ((Element)v.get(200)).setAttribute("caracteres","30" );
      ((Element)v.get(196)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(201)).setAttribute("ancho","440" );
      ((Element)v.get(201)).setAttribute("caracteres","30" );
      ((Element)v.get(196)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:196   */

      /* Empieza nodo:202 / Elemento padre: 184   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(184)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:203 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(203)).setAttribute("nombre","capaTipoSolicitud" );
      ((Element)v.get(203)).setAttribute("alto","3" );
      ((Element)v.get(203)).setAttribute("ancho","624" );
      ((Element)v.get(203)).setAttribute("colorf","" );
      ((Element)v.get(203)).setAttribute("borde","0" );
      ((Element)v.get(203)).setAttribute("imagenf","" );
      ((Element)v.get(203)).setAttribute("repeat","" );
      ((Element)v.get(203)).setAttribute("padding","" );
      ((Element)v.get(203)).setAttribute("visibilidad","visible" );
      ((Element)v.get(203)).setAttribute("contravsb","" );
      ((Element)v.get(203)).setAttribute("x","0" );
      ((Element)v.get(203)).setAttribute("y","165" );
      ((Element)v.get(203)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(204)).setAttribute("seleccion","boton" );
      ((Element)v.get(204)).setAttribute("nombre","lstTipoSoli" );
      ((Element)v.get(204)).setAttribute("x","12" );
      ((Element)v.get(204)).setAttribute("y","10" );
      ((Element)v.get(204)).setAttribute("ancho","600" );
      ((Element)v.get(204)).setAttribute("alto","3" );
      ((Element)v.get(204)).setAttribute("multisel","-1" );
      ((Element)v.get(204)).setAttribute("incy","10" );
      ((Element)v.get(204)).setAttribute("incx","10" );
      ((Element)v.get(204)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(204)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(204)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(204)).setAttribute("accion","" );
      ((Element)v.get(204)).setAttribute("sep","|" );
      ((Element)v.get(204)).setAttribute("pixelsborde","2" );
      ((Element)v.get(204)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(205)).setAttribute("nombre","cab1" );
      ((Element)v.get(205)).setAttribute("height","20" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(206)).setAttribute("ancho","40" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Elemento padre:206 / Elemento actual: 207   */
      v.add(doc.createTextNode("TipoSoli"));
      ((Element)v.get(206)).appendChild((Text)v.get(207));

      /* Termina nodo Texto:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(208)).setAttribute("ancho","40" );
      ((Element)v.get(205)).appendChild((Element)v.get(208));

      /* Elemento padre:208 / Elemento actual: 209   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(208)).appendChild((Text)v.get(209));

      /* Termina nodo Texto:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(210)).setAttribute("ancho","60" );
      ((Element)v.get(205)).appendChild((Element)v.get(210));

      /* Elemento padre:210 / Elemento actual: 211   */
      v.add(doc.createTextNode("Acceso"));
      ((Element)v.get(210)).appendChild((Text)v.get(211));

      /* Termina nodo Texto:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(212)).setAttribute("ancho","440" );
      ((Element)v.get(205)).appendChild((Element)v.get(212));

      /* Elemento padre:212 / Elemento actual: 213   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(212)).appendChild((Text)v.get(213));

      /* Termina nodo Texto:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(214)).setAttribute("ancho","440" );
      ((Element)v.get(205)).appendChild((Element)v.get(214));

      /* Elemento padre:214 / Elemento actual: 215   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(214)).appendChild((Text)v.get(215));

      /* Termina nodo Texto:215   */
      /* Termina nodo:214   */
      /* Termina nodo:205   */

      /* Empieza nodo:216 / Elemento padre: 204   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(216)).setAttribute("ancho","590" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(216)).setAttribute("filas","1" );
      ((Element)v.get(216)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(204)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("ancho","40" );
      ((Element)v.get(217)).setAttribute("caracteres","20" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(218)).setAttribute("ancho","60" );
      ((Element)v.get(218)).setAttribute("caracteres","20" );
      ((Element)v.get(216)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(219)).setAttribute("ancho","440" );
      ((Element)v.get(219)).setAttribute("caracteres","30" );
      ((Element)v.get(216)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(220)).setAttribute("ancho","440" );
      ((Element)v.get(220)).setAttribute("caracteres","30" );
      ((Element)v.get(216)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(221)).setAttribute("ancho","440" );
      ((Element)v.get(221)).setAttribute("caracteres","30" );
      ((Element)v.get(216)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:216   */

      /* Empieza nodo:222 / Elemento padre: 204   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(204)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:6   */


   }

}

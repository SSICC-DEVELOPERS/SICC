
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_informe_recepcion_diarios_generar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_informe_recepcion_diarios_generar" );
      ((Element)v.get(0)).setAttribute("cod","0838" );
      ((Element)v.get(0)).setAttribute("titulo","Generar Informe Recepción de Pedidos Diarios" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Generar Informe Recepción de Pedidos Diarios" );
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
      v.add(doc.createTextNode("\r   \r   \r   function onLoad(){\r      configurarMenuSecundario('Formulario');\r      focaliza('Formulario.cbMarca');\r   }\r\r     function quitarItemVacio(elemento){\r      var elementoADevolver = new Array();\r     \r      for(var k=0;k<elemento.length;k++) {\r          if (elemento[k] != ''){                            \r             elementoADevolver[elementoADevolver.length] = elemento[k];\r          }\r      }\r         \r      return elementoADevolver;\r      \r   }\r   function generar(){\r      \r      if(sicc_validaciones_generales()){\r          /*recolectarParametros();\r          set('Formulario.conectorAction', 'PEDRecepcionPedidosDiarios');           \r          set('Formulario.accion', 'generar');\r          enviaSICC('Formulario');*/\r          var a = new Object();\r          a.accion = 'generar';\r          a.marca= get('Formulario.cbMarca');\r          a.canales= quitarItemVacio(get('Formulario.cbCanal'));            \r          a.accesos= quitarItemVacio(get('Formulario.cbAcceso'));\r          a.periodos= quitarItemVacio(get('Formulario.cbPeriodo'));\r          a.regiones= quitarItemVacio(get('Formulario.cbRegion'));\r          a.nomgerenregs= quitarItemVacio(get('Formulario.cbNomGerenteRegion'));           \r          mostrarModalSICC('PEDRecepcionPedidosDiarios','generar', a);        \r      }\r\r   }\r  function recolectarParametros(){\r            set('Formulario.marca',get('Formulario.cbMarca')) ;\r            set('Formulario.canales',get('Formulario.cbCanal')) ;            \r            set('Formulario.accesos',get('Formulario.cbAcceso'));\r            set('Formulario.periodos', get('Formulario.cbPeriodo'));\r            set('Formulario.regiones',get('Formulario.cbRegion')) ;\r            set('Formulario.nomgerenregs',get('Formulario.cbNomGerenteRegion')) ;        \r  }\r\r   function fLimpiar(){\r      var aCombo = new Array(new Array(\"\",\"\"));      \r      set_combo('Formulario.cbAcceso', aCombo, []);\r      set_combo('Formulario.cbPeriodo', aCombo, []);            \r      set_combo('Formulario.cbRegion', aCombo, []);      \r      set_combo('Formulario.cbNomGerenteRegion', aCombo, []);      \r      \r      focaliza('Formulario.cbMarca'); \r   }\r\r   \r   function cambioCanal(){\r         \r     opciones = new Array();\r     set_combo('Formulario.cbAcceso',opciones);        \r     tipo = get('Formulario.cbCanal','V');\r     combo_add('Formulario.cbAcceso', '', '');\r       \r     for(var k=0;k<lstAcceso.datos.longitud;k++) {\r        for(var y=0;y<tipo.length;y++){\r                     if (lstAcceso.datos.ij(k,2) == tipo[y]){ 			 \r              combo_add('Formulario.cbAcceso',lstAcceso.datos.ij(k,0),lstAcceso.datos.ij(k,1));\r    \r           }\r        }\r    }\r    cambioMarcaCanal();\r  }    \r   \r   function cambioMarcaCanal(){\r		opciones = new Array();\r		set_combo('Formulario.cbRegion',opciones);\r		combo_add('Formulario.cbRegion', '', '');\r		set_combo('Formulario.cbPeriodo',opciones);\r		combo_add('Formulario.cbPeriodo', '', '');\r		tipoM = get('Formulario.cbMarca','V');\r		pais   = get('Formulario.pais');\r		idioma = get('Formulario.idioma');\r		var canales = quitarItemVacio(get('Formulario.cbCanal'));\r		var canalesConc = new String();\r		for(i=0;i<canales.length;i++){\r		   canalesConc += canales[i] + \",\";\r		}\r		canalesConc = canalesConc.substring(0, canalesConc.length-1);\r		var aCombo = new Array(new Array(\"\",\"\"));\r		if(tipoM != '' && canalesConc != ''){\r			var arr = new Array();\r			arr[arr.length] = ['oidPais', pais]\r			arr[arr.length] = [\"oidIdioma\", idioma]; \r			arr[arr.length] = [\"marca\", tipoM];\r			arr[arr.length] = [\"canales\", canalesConc];\r			set_combo('Formulario.cbPeriodo', aCombo, []); \r			recargaCombo(\"Formulario.cbPeriodo\", \"REPPeriodosEstructura\", \"es.indra.sicc.rep.dtos.DTOEstructuraFacturacion\",arr);\r\r			var arr2 = new Array();\r			arr2[arr2.length] = [\"oidPais\", pais]; \r          	arr2[arr2.length] = [\"oidMarca\", tipoM];\r			          	arr2[arr2.length] = [\"descripcion\", canalesConc];\r			set_combo('Formulario.cbRegion', aCombo, []);\r			recargaCombo(\"Formulario.cbRegion\",\"RepRecargarRegionesParaListaCanal\", \"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\",arr2);\r		}\r		else{\r			set_combo('Formulario.cbPeriodo', aCombo, []); \r			set_combo('Formulario.cbRegion', aCombo, []);\r		}\r		cambioRegionMarcaCanal();\r  }    \r   \r   function cambioRegionMarcaCanal(){\r		opcionesNomGere = new Array();     \r		set_combo('Formulario.cbNomGerenteRegion',opcionesNomGere);         \r		combo_add('Formulario.cbNomGerenteRegion', '', '');\r		pais   = get('Formulario.pais');\r		var regiones = quitarItemVacio(get('Formulario.cbRegion'));\r		var regionesConc = new String();\r		for(i=0;i<regiones.length;i++){\r		   regionesConc += regiones[i] + \"x\";\r		}\r		regionesConc = regionesConc.substring(0, regionesConc.length-1);\r		if(regionesConc != ''){\r			var arr = new Array();\r			arr[arr.length] = ['oidPais', pais]\r			arr[arr.length] = [\"cadena\", regionesConc]; \r			set_combo('Formulario.cbNomGerenteRegion',opcionesNomGere);\r			recargaCombo(\"Formulario.cbNomGerenteRegion\", \"RepRecargarGerentesRegion\", \"es.indra.sicc.util.DTOString\",arr);\r		}\r		else{\r			set_combo('Formulario.cbNomGerenteRegion',opcionesNomGere); \r		}\r  }  \r        function arrayComponentes(){\r              var arr = new Array();\r              arr[arr.length]= new Array(\"cbMarca\",\"\");\r              arr[arr.length]= new Array(\"cbCanal\",\"\");\r              arr[arr.length]= new Array(\"cbAcceso\",\"\");\r              arr[arr.length]= new Array(\"cbPeriodo\",\"\");\r              arr[arr.length]= new Array(\"cbRegion\",\"\");\r              arr[arr.length]= new Array(\"cbNomGerenteRegion\",\"\");\r              arr[arr.length]= new Array(\"btnGenerarInforme\",\"BOTON\");\r              \r              return arr;\r          }\r          function tabGenerico(nombreComp, tipotab){       \r            var arr = arrayComponentes();\r            var tabular = false;\r            var nombreFormulario = getFormularioSICC();\r            var j = 0;\r            var k = arr.length;\r            if (tipotab != \"sh\") {\r                j = j-1;                \r                k = k-1;\r            }\r\r            while(j<k){\r                var t;\r                if(tipotab == \"sh\"){\r                  k--;\r                  t = k;\r                } else{\r                  j++;\r                  t = j;                  \r                }\r                  \r                var nombre = arr[t][0];\r                var tipo = arr[t][1];\r                if (tabular==false){\r                  if (nombreComp==nombre){\r                      tabular=true;\r                      if (tipotab == \"sh\"){\r                        if (k==0) k= arr.length;\r                      } else {\r                        if ((j+1)==arr.length)  j = -1;\r                      }\r                  }                \r                } else {\r                  try {\r                    var name = nombreFormulario+\".\"+nombre;\r                    if (tipo==\"BOTONXY\"){\r                       focalizaBotonHTML_XY(nombre);\r                    } else if (tipo==\"BOTON\") {\r                       focalizaBotonHTML(\"botonContenido\",nombre)\r                    } else {\r                       focaliza(name);\r                    }\r                    return;\r                  } catch (e) {\r                  }\r                }\r            }\r          } \r   \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbMarca" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","6" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbCanal" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","7" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbCanal" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","276" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:6   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(10)).setAttribute("nombre","Formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","accion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(12)).setAttribute("valor","PEDRecepcionPedidosDiarios" );
      ((Element)v.get(10)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","idioma" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","pais" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","marca" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","canales" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","accesos" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","periodos" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","regiones" );
      ((Element)v.get(22)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(10)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","nomgerenregs" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(24)).setAttribute("nombre","capa" );
      ((Element)v.get(10)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("table"));
      ((Element)v.get(25)).setAttribute("width","100%" );
      ((Element)v.get(25)).setAttribute("border","0" );
      ((Element)v.get(25)).setAttribute("cellspacing","0" );
      ((Element)v.get(25)).setAttribute("cellpadding","0" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(27)).setAttribute("align","center" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(28)).setAttribute("height","12" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).setAttribute("width","750" );
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).setAttribute("width","12" );
      ((Element)v.get(26)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).setAttribute("width","12" );
      ((Element)v.get(32)).setAttribute("height","1" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:26   */

      /* Empieza nodo:33 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(38)).setAttribute("class","legend" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(39)).setAttribute("nombre","lblCriteriosSeleccion" );
      ((Element)v.get(39)).setAttribute("filas","1" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(39)).setAttribute("id","legend" );
      ((Element)v.get(39)).setAttribute("cod","00275" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","100%" );
      ((Element)v.get(40)).setAttribute("border","0" );
      ((Element)v.get(40)).setAttribute("align","center" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("cellpadding","0" );
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("table"));
      ((Element)v.get(43)).setAttribute("width","100%" );
      ((Element)v.get(43)).setAttribute("border","0" );
      ((Element)v.get(43)).setAttribute("align","left" );
      ((Element)v.get(43)).setAttribute("cellspacing","0" );
      ((Element)v.get(43)).setAttribute("cellpadding","0" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","8" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(48)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(48)).setAttribute("filas","1" );
      ((Element)v.get(48)).setAttribute("id","datosTitle" );
      ((Element)v.get(48)).setAttribute("cod","6" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","25" );
      ((Element)v.get(50)).setAttribute("height","8" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("id","datosTitle" );
      ((Element)v.get(52)).setAttribute("cod","7" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","100%" );
      ((Element)v.get(44)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","8" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:44   */

      /* Empieza nodo:55 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(58)).setAttribute("valign","top" );
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(59)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(59)).setAttribute("onchange","cambioMarcaCanal();" );
      ((Element)v.get(59)).setAttribute("size","1" );
      ((Element)v.get(59)).setAttribute("multiple","N" );
      ((Element)v.get(59)).setAttribute("valorinicial","" );
      ((Element)v.get(59)).setAttribute("textoinicial","" );
      ((Element)v.get(59)).setAttribute("id","datosCampos" );
      ((Element)v.get(59)).setAttribute("req","S" );
      ((Element)v.get(59)).setAttribute("ontab","tabGenerico('cbMarca');" );
      ((Element)v.get(59)).setAttribute("onshtab","tabGenerico('cbMarca','sh');" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:61 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","25" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(55)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(64)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(64)).setAttribute("onchange","cambioCanal();" );
      ((Element)v.get(64)).setAttribute("size","5" );
      ((Element)v.get(64)).setAttribute("multiple","S" );
      ((Element)v.get(64)).setAttribute("valorinicial","" );
      ((Element)v.get(64)).setAttribute("textoinicial","" );
      ((Element)v.get(64)).setAttribute("id","datosCampos" );
      ((Element)v.get(64)).setAttribute("req","S" );
      ((Element)v.get(64)).setAttribute("ontab","tabGenerico('cbCanal');" );
      ((Element)v.get(64)).setAttribute("onshtab","tabGenerico('cbCanal','sh');" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:66 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","100%" );
      ((Element)v.get(55)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:55   */

      /* Empieza nodo:68 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).setAttribute("colspan","4" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:71 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("table"));
      ((Element)v.get(73)).setAttribute("width","100%" );
      ((Element)v.get(73)).setAttribute("border","0" );
      ((Element)v.get(73)).setAttribute("align","left" );
      ((Element)v.get(73)).setAttribute("cellspacing","0" );
      ((Element)v.get(73)).setAttribute("cellpadding","0" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(78)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(78)).setAttribute("filas","1" );
      ((Element)v.get(78)).setAttribute("id","datosTitle" );
      ((Element)v.get(78)).setAttribute("cod","10" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","25" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(82)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(82)).setAttribute("filas","1" );
      ((Element)v.get(82)).setAttribute("id","datosTitle" );
      ((Element)v.get(82)).setAttribute("cod","276" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("width","100%" );
      ((Element)v.get(74)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:74   */

      /* Empieza nodo:85 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(85)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(89)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(89)).setAttribute("size","5" );
      ((Element)v.get(89)).setAttribute("multiple","S" );
      ((Element)v.get(89)).setAttribute("valorinicial","" );
      ((Element)v.get(89)).setAttribute("textoinicial","" );
      ((Element)v.get(89)).setAttribute("id","datosCampos" );
      ((Element)v.get(89)).setAttribute("req","N" );
      ((Element)v.get(89)).setAttribute("ontab","tabGenerico('cbAcceso');" );
      ((Element)v.get(89)).setAttribute("onshtab","tabGenerico('cbAcceso','sh');" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:91 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","25" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 85   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(85)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(94)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(94)).setAttribute("size","5" );
      ((Element)v.get(94)).setAttribute("multiple","S" );
      ((Element)v.get(94)).setAttribute("valorinicial","" );
      ((Element)v.get(94)).setAttribute("textoinicial","" );
      ((Element)v.get(94)).setAttribute("id","datosCampos" );
      ((Element)v.get(94)).setAttribute("req","S" );
      ((Element)v.get(94)).setAttribute("ontab","tabGenerico('cbPeriodo');" );
      ((Element)v.get(94)).setAttribute("onshtab","tabGenerico('cbPeriodo','sh');" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:96 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","100%" );
      ((Element)v.get(85)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:85   */

      /* Empieza nodo:98 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(98));

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
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:101 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("table"));
      ((Element)v.get(103)).setAttribute("width","100%" );
      ((Element)v.get(103)).setAttribute("border","0" );
      ((Element)v.get(103)).setAttribute("align","left" );
      ((Element)v.get(103)).setAttribute("cellspacing","0" );
      ((Element)v.get(103)).setAttribute("cellpadding","0" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(108)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(108)).setAttribute("filas","1" );
      ((Element)v.get(108)).setAttribute("id","datosTitle" );
      ((Element)v.get(108)).setAttribute("cod","109" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","25" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(112)).setAttribute("nombre","lblNomGerenteRegion" );
      ((Element)v.get(112)).setAttribute("filas","1" );
      ((Element)v.get(112)).setAttribute("id","datosTitle" );
      ((Element)v.get(112)).setAttribute("cod","2693" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","100%" );
      ((Element)v.get(104)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:104   */

      /* Empieza nodo:115 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(115)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(119)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(119)).setAttribute("onchange","cambioRegionMarcaCanal();" );
      ((Element)v.get(119)).setAttribute("size","5" );
      ((Element)v.get(119)).setAttribute("multiple","S" );
      ((Element)v.get(119)).setAttribute("valorinicial","" );
      ((Element)v.get(119)).setAttribute("textoinicial","" );
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(119)).setAttribute("req","N" );
      ((Element)v.get(119)).setAttribute("ontab","tabGenerico('cbRegion');" );
      ((Element)v.get(119)).setAttribute("onshtab","tabGenerico('cbRegion','sh');" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:121 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","25" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(115)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(124)).setAttribute("nombre","cbNomGerenteRegion" );
      ((Element)v.get(124)).setAttribute("size","5" );
      ((Element)v.get(124)).setAttribute("multiple","S" );
      ((Element)v.get(124)).setAttribute("valorinicial","" );
      ((Element)v.get(124)).setAttribute("textoinicial","" );
      ((Element)v.get(124)).setAttribute("id","datosCampos" );
      ((Element)v.get(124)).setAttribute("req","N" );
      ((Element)v.get(124)).setAttribute("ontab","tabGenerico('cbNomGerenteRegion');" );
      ((Element)v.get(124)).setAttribute("onshtab","tabGenerico('cbNomGerenteRegion','sh');" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:126 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("width","100%" );
      ((Element)v.get(115)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:115   */

      /* Empieza nodo:128 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("colspan","4" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:40   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:131 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:33   */

      /* Empieza nodo:133 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("table"));
      ((Element)v.get(138)).setAttribute("width","100%" );
      ((Element)v.get(138)).setAttribute("border","0" );
      ((Element)v.get(138)).setAttribute("align","center" );
      ((Element)v.get(138)).setAttribute("cellspacing","0" );
      ((Element)v.get(138)).setAttribute("cellpadding","0" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("class","botonera" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(141)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(141)).setAttribute("ID","botonContenido" );
      ((Element)v.get(141)).setAttribute("tipo","html" );
      ((Element)v.get(141)).setAttribute("accion","generar();" );
      ((Element)v.get(141)).setAttribute("estado","false" );
      ((Element)v.get(141)).setAttribute("cod","2495" );
      ((Element)v.get(141)).setAttribute("ontab","tabGenerico('btnGenerarInforme');" );
      ((Element)v.get(141)).setAttribute("onshtab","tabGenerico('btnGenerarInforme','sh');" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:142 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","8" );
      ((Element)v.get(143)).setAttribute("height","12" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:133   */

      /* Empieza nodo:144 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("width","12" );
      ((Element)v.get(145)).setAttribute("align","center" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","12" );
      ((Element)v.get(146)).setAttribute("height","12" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("width","756" );
      ((Element)v.get(144)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("width","12" );
      ((Element)v.get(144)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","12" );
      ((Element)v.get(150)).setAttribute("height","1" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:144   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:151 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(151)).setAttribute("nombre","capaAcceso" );
      ((Element)v.get(151)).setAttribute("alto","3" );
      ((Element)v.get(151)).setAttribute("ancho","624" );
      ((Element)v.get(151)).setAttribute("colorf","" );
      ((Element)v.get(151)).setAttribute("borde","0" );
      ((Element)v.get(151)).setAttribute("imagenf","" );
      ((Element)v.get(151)).setAttribute("repeat","" );
      ((Element)v.get(151)).setAttribute("padding","" );
      ((Element)v.get(151)).setAttribute("visibilidad","visible" );
      ((Element)v.get(151)).setAttribute("contravsb","" );
      ((Element)v.get(151)).setAttribute("x","0" );
      ((Element)v.get(151)).setAttribute("y","165" );
      ((Element)v.get(151)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(152)).setAttribute("seleccion","boton" );
      ((Element)v.get(152)).setAttribute("nombre","lstAcceso" );
      ((Element)v.get(152)).setAttribute("x","12" );
      ((Element)v.get(152)).setAttribute("y","10" );
      ((Element)v.get(152)).setAttribute("ancho","600" );
      ((Element)v.get(152)).setAttribute("alto","3" );
      ((Element)v.get(152)).setAttribute("multisel","-1" );
      ((Element)v.get(152)).setAttribute("incy","10" );
      ((Element)v.get(152)).setAttribute("incx","10" );
      ((Element)v.get(152)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(152)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(152)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(152)).setAttribute("accion","" );
      ((Element)v.get(152)).setAttribute("sep","|" );
      ((Element)v.get(152)).setAttribute("pixelsborde","2" );
      ((Element)v.get(152)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(153)).setAttribute("nombre","cab1" );
      ((Element)v.get(153)).setAttribute("height","20" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(154)).setAttribute("ancho","40" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Elemento padre:154 / Elemento actual: 155   */
      v.add(doc.createTextNode("Acceso"));
      ((Element)v.get(154)).appendChild((Text)v.get(155));

      /* Termina nodo Texto:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(156)).setAttribute("ancho","60" );
      ((Element)v.get(153)).appendChild((Element)v.get(156));

      /* Elemento padre:156 / Elemento actual: 157   */
      v.add(doc.createTextNode("Descripción"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(156)).appendChild((Text)v.get(157));

      /* Termina nodo Texto:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(158)).setAttribute("ancho","440" );
      ((Element)v.get(153)).appendChild((Element)v.get(158));

      /* Elemento padre:158 / Elemento actual: 159   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(158)).appendChild((Text)v.get(159));

      /* Termina nodo Texto:159   */
      /* Termina nodo:158   */
      /* Termina nodo:153   */

      /* Empieza nodo:160 / Elemento padre: 152   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(160)).setAttribute("ancho","590" );
      ((Element)v.get(160)).setAttribute("filas","1" );
      ((Element)v.get(160)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(152)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("ancho","40" );
      ((Element)v.get(161)).setAttribute("caracteres","20" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("ancho","60" );
      ((Element)v.get(162)).setAttribute("caracteres","20" );
      ((Element)v.get(160)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("ancho","440" );
      ((Element)v.get(163)).setAttribute("caracteres","30" );
      ((Element)v.get(160)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:160   */

      /* Empieza nodo:164 / Elemento padre: 152   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(152)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:165 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(165)).setAttribute("nombre","capaPeriodo" );
      ((Element)v.get(165)).setAttribute("alto","3" );
      ((Element)v.get(165)).setAttribute("ancho","624" );
      ((Element)v.get(165)).setAttribute("colorf","" );
      ((Element)v.get(165)).setAttribute("borde","0" );
      ((Element)v.get(165)).setAttribute("imagenf","" );
      ((Element)v.get(165)).setAttribute("repeat","" );
      ((Element)v.get(165)).setAttribute("padding","" );
      ((Element)v.get(165)).setAttribute("visibilidad","visible" );
      ((Element)v.get(165)).setAttribute("contravsb","" );
      ((Element)v.get(165)).setAttribute("x","0" );
      ((Element)v.get(165)).setAttribute("y","165" );
      ((Element)v.get(165)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(166)).setAttribute("seleccion","boton" );
      ((Element)v.get(166)).setAttribute("nombre","lstPeriodo" );
      ((Element)v.get(166)).setAttribute("x","12" );
      ((Element)v.get(166)).setAttribute("y","10" );
      ((Element)v.get(166)).setAttribute("ancho","600" );
      ((Element)v.get(166)).setAttribute("alto","3" );
      ((Element)v.get(166)).setAttribute("multisel","-1" );
      ((Element)v.get(166)).setAttribute("incy","10" );
      ((Element)v.get(166)).setAttribute("incx","10" );
      ((Element)v.get(166)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(166)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(166)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(166)).setAttribute("accion","" );
      ((Element)v.get(166)).setAttribute("sep","|" );
      ((Element)v.get(166)).setAttribute("pixelsborde","2" );
      ((Element)v.get(166)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(167)).setAttribute("nombre","cab1" );
      ((Element)v.get(167)).setAttribute("height","20" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(168)).setAttribute("ancho","40" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Elemento padre:168 / Elemento actual: 169   */
      v.add(doc.createTextNode("Periodo"));
      ((Element)v.get(168)).appendChild((Text)v.get(169));

      /* Termina nodo Texto:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(170)).setAttribute("ancho","60" );
      ((Element)v.get(167)).appendChild((Element)v.get(170));

      /* Elemento padre:170 / Elemento actual: 171   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(170)).appendChild((Text)v.get(171));

      /* Termina nodo Texto:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(172)).setAttribute("ancho","440" );
      ((Element)v.get(167)).appendChild((Element)v.get(172));

      /* Elemento padre:172 / Elemento actual: 173   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(172)).appendChild((Text)v.get(173));

      /* Termina nodo Texto:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(174)).setAttribute("ancho","440" );
      ((Element)v.get(167)).appendChild((Element)v.get(174));

      /* Elemento padre:174 / Elemento actual: 175   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(174)).appendChild((Text)v.get(175));

      /* Termina nodo Texto:175   */
      /* Termina nodo:174   */
      /* Termina nodo:167   */

      /* Empieza nodo:176 / Elemento padre: 166   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(176)).setAttribute("ancho","590" );
      ((Element)v.get(176)).setAttribute("filas","1" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(176)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(166)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("ancho","40" );
      ((Element)v.get(177)).setAttribute("caracteres","20" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("ancho","60" );
      ((Element)v.get(178)).setAttribute("caracteres","20" );
      ((Element)v.get(176)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("ancho","440" );
      ((Element)v.get(179)).setAttribute("caracteres","30" );
      ((Element)v.get(176)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("ancho","440" );
      ((Element)v.get(180)).setAttribute("caracteres","30" );
      ((Element)v.get(176)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:176   */

      /* Empieza nodo:181 / Elemento padre: 166   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(166)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:182 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(182)).setAttribute("nombre","capaRegion" );
      ((Element)v.get(182)).setAttribute("alto","3" );
      ((Element)v.get(182)).setAttribute("ancho","624" );
      ((Element)v.get(182)).setAttribute("colorf","" );
      ((Element)v.get(182)).setAttribute("borde","0" );
      ((Element)v.get(182)).setAttribute("imagenf","" );
      ((Element)v.get(182)).setAttribute("repeat","" );
      ((Element)v.get(182)).setAttribute("padding","" );
      ((Element)v.get(182)).setAttribute("visibilidad","visible" );
      ((Element)v.get(182)).setAttribute("contravsb","" );
      ((Element)v.get(182)).setAttribute("x","0" );
      ((Element)v.get(182)).setAttribute("y","165" );
      ((Element)v.get(182)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(183)).setAttribute("seleccion","boton" );
      ((Element)v.get(183)).setAttribute("nombre","lstRegion" );
      ((Element)v.get(183)).setAttribute("x","12" );
      ((Element)v.get(183)).setAttribute("y","10" );
      ((Element)v.get(183)).setAttribute("ancho","600" );
      ((Element)v.get(183)).setAttribute("alto","3" );
      ((Element)v.get(183)).setAttribute("multisel","-1" );
      ((Element)v.get(183)).setAttribute("incy","10" );
      ((Element)v.get(183)).setAttribute("incx","10" );
      ((Element)v.get(183)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(183)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(183)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(183)).setAttribute("accion","" );
      ((Element)v.get(183)).setAttribute("sep","|" );
      ((Element)v.get(183)).setAttribute("pixelsborde","2" );
      ((Element)v.get(183)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(184)).setAttribute("nombre","cab1" );
      ((Element)v.get(184)).setAttribute("height","20" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(185)).setAttribute("ancho","40" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Elemento padre:185 / Elemento actual: 186   */
      v.add(doc.createTextNode("Region"));
      ((Element)v.get(185)).appendChild((Text)v.get(186));

      /* Termina nodo Texto:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(187)).setAttribute("ancho","60" );
      ((Element)v.get(184)).appendChild((Element)v.get(187));

      /* Elemento padre:187 / Elemento actual: 188   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(187)).appendChild((Text)v.get(188));

      /* Termina nodo Texto:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(189)).setAttribute("ancho","440" );
      ((Element)v.get(184)).appendChild((Element)v.get(189));

      /* Elemento padre:189 / Elemento actual: 190   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(189)).appendChild((Text)v.get(190));

      /* Termina nodo Texto:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(191)).setAttribute("ancho","440" );
      ((Element)v.get(184)).appendChild((Element)v.get(191));

      /* Elemento padre:191 / Elemento actual: 192   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(191)).appendChild((Text)v.get(192));

      /* Termina nodo Texto:192   */
      /* Termina nodo:191   */
      /* Termina nodo:184   */

      /* Empieza nodo:193 / Elemento padre: 183   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(193)).setAttribute("ancho","590" );
      ((Element)v.get(193)).setAttribute("filas","1" );
      ((Element)v.get(193)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(183)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("ancho","40" );
      ((Element)v.get(194)).setAttribute("caracteres","20" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 193   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(195)).setAttribute("ancho","60" );
      ((Element)v.get(195)).setAttribute("caracteres","20" );
      ((Element)v.get(193)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(196)).setAttribute("ancho","440" );
      ((Element)v.get(196)).setAttribute("caracteres","30" );
      ((Element)v.get(193)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(197)).setAttribute("ancho","440" );
      ((Element)v.get(197)).setAttribute("caracteres","30" );
      ((Element)v.get(193)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:193   */

      /* Empieza nodo:198 / Elemento padre: 183   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(183)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:199 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(199)).setAttribute("nombre","capaNomGerenReg" );
      ((Element)v.get(199)).setAttribute("alto","3" );
      ((Element)v.get(199)).setAttribute("ancho","624" );
      ((Element)v.get(199)).setAttribute("colorf","" );
      ((Element)v.get(199)).setAttribute("borde","0" );
      ((Element)v.get(199)).setAttribute("imagenf","" );
      ((Element)v.get(199)).setAttribute("repeat","" );
      ((Element)v.get(199)).setAttribute("padding","" );
      ((Element)v.get(199)).setAttribute("visibilidad","visible" );
      ((Element)v.get(199)).setAttribute("contravsb","" );
      ((Element)v.get(199)).setAttribute("x","0" );
      ((Element)v.get(199)).setAttribute("y","165" );
      ((Element)v.get(199)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(200)).setAttribute("seleccion","boton" );
      ((Element)v.get(200)).setAttribute("nombre","lstNomGerenReg" );
      ((Element)v.get(200)).setAttribute("x","12" );
      ((Element)v.get(200)).setAttribute("y","10" );
      ((Element)v.get(200)).setAttribute("ancho","600" );
      ((Element)v.get(200)).setAttribute("alto","3" );
      ((Element)v.get(200)).setAttribute("multisel","-1" );
      ((Element)v.get(200)).setAttribute("incy","10" );
      ((Element)v.get(200)).setAttribute("incx","10" );
      ((Element)v.get(200)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(200)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(200)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(200)).setAttribute("accion","" );
      ((Element)v.get(200)).setAttribute("sep","|" );
      ((Element)v.get(200)).setAttribute("pixelsborde","2" );
      ((Element)v.get(200)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(201)).setAttribute("nombre","cab1" );
      ((Element)v.get(201)).setAttribute("height","20" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(202)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(202)).setAttribute("ancho","40" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Elemento padre:202 / Elemento actual: 203   */
      v.add(doc.createTextNode("NomGerenReg"));
      ((Element)v.get(202)).appendChild((Text)v.get(203));

      /* Termina nodo Texto:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 201   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(204)).setAttribute("ancho","60" );
      ((Element)v.get(201)).appendChild((Element)v.get(204));

      /* Elemento padre:204 / Elemento actual: 205   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(204)).appendChild((Text)v.get(205));

      /* Termina nodo Texto:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 201   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(206)).setAttribute("ancho","440" );
      ((Element)v.get(201)).appendChild((Element)v.get(206));

      /* Elemento padre:206 / Elemento actual: 207   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(206)).appendChild((Text)v.get(207));

      /* Termina nodo Texto:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 201   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(208)).setAttribute("ancho","440" );
      ((Element)v.get(201)).appendChild((Element)v.get(208));

      /* Elemento padre:208 / Elemento actual: 209   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(208)).appendChild((Text)v.get(209));

      /* Termina nodo Texto:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 201   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(210)).setAttribute("ancho","440" );
      ((Element)v.get(201)).appendChild((Element)v.get(210));

      /* Elemento padre:210 / Elemento actual: 211   */
      v.add(doc.createTextNode("Region"));
      ((Element)v.get(210)).appendChild((Text)v.get(211));

      /* Termina nodo Texto:211   */
      /* Termina nodo:210   */
      /* Termina nodo:201   */

      /* Empieza nodo:212 / Elemento padre: 200   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(212)).setAttribute("ancho","590" );
      ((Element)v.get(212)).setAttribute("filas","1" );
      ((Element)v.get(212)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(200)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(213)).setAttribute("ancho","40" );
      ((Element)v.get(213)).setAttribute("caracteres","20" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 212   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("ancho","60" );
      ((Element)v.get(214)).setAttribute("caracteres","20" );
      ((Element)v.get(212)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 212   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(215)).setAttribute("ancho","440" );
      ((Element)v.get(215)).setAttribute("caracteres","30" );
      ((Element)v.get(212)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 212   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("ancho","440" );
      ((Element)v.get(216)).setAttribute("caracteres","30" );
      ((Element)v.get(212)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 212   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("ancho","440" );
      ((Element)v.get(217)).setAttribute("caracteres","30" );
      ((Element)v.get(212)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:212   */

      /* Empieza nodo:218 / Elemento padre: 200   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(200)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:10   */


   }

}

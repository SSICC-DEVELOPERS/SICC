
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_notas_credito  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_notas_credito" );
      ((Element)v.get(0)).setAttribute("cod","0792" );
      ((Element)v.get(0)).setAttribute("titulo","" );
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
      v.add(doc.createTextNode("\r   \r   \r   function loadPag(){\r      configurarMenuSecundario('Formulario');\r      focaliza('Formulario.cbMarca');\r   }\r\r     function quitarItemVacio(elemento){\r      var elementoADevolver = new Array();\r     \r      for(var k=0;k<elemento.length;k++) {\r          if (elemento[k] != ''){                            \r             elementoADevolver[elementoADevolver.length] = elemento[k];\r          }\r      }\r         \r      return elementoADevolver;\r      \r   }\r\r   function generar(){\r      if(sicc_validaciones_generales()){\r          /*recolectarParametros();\r          set('Formulario.conectorAction', 'FACNotasCreditoEbelistas');           \r          set('Formulario.accion', 'generar');\r          enviaSICC('Formulario');*/\r          var a = new Object();\r          a.accion = 'generar';\r          a.marca = get('Formulario.cbMarca');\r          a.canal = get('Formulario.cbCanal');\r          a.periodo = get('Formulario.cbPeriodo');\r          a.periodoDesc = get('Formulario.cbPeriodo', 'T');\r          a.region = get('Formulario.cbRegion');\r          a.zonas = quitarItemVacio(get('Formulario.cbZona'));          \r          mostrarModalSICC('FACNotasCreditoEbelistas','generar', a);  \r      }\r   }\r\r  function recolectarParametros(){\r        set('Formulario.marca',get('Formulario.cbMarca')) ;\r        set('Formulario.canal',get('Formulario.cbCanal')) ;\r        set('Formulario.periodo',get('Formulario.cbPeriodo'));\r        set('Formulario.region',get('Formulario.cbRegion'));\r        set('Formulario.zonas',get('Formulario.cbZona')) ;\r        \r  }\r\r   function fLimpiar(){\r      \r      var aCombo = new Array(new Array(\"\",\"\"));\r      \r      set_combo('Formulario.cbPeriodo', aCombo, []);\r      set_combo('Formulario.cbRegion', aCombo, []);\r      set_combo('Formulario.cbZona', aCombo, []);\r      \r      focaliza('Formulario.cbMarca'); \r   \r   }\r\r    function onchangeMarcaCanal(){\r		tipoM = get('Formulario.cbMarca','V');\r		tipoC = get('Formulario.cbCanal','V');\r		pais   = get('Formulario.pais');\r	    idioma = get('Formulario.idioma');\r		\r		if(tipoM != '' && tipoC != ''){\r			 var arr = new Array();\r			 var arr2 = new Array();\r		 \r			 arr[arr.length] = [\"oidIdioma\", idioma]; \r			 arr[arr.length] = [\"oidPais\", pais]; \r			 arr[arr.length] = [\"marca\", tipoM];\r			 arr[arr.length] = [\"canal\", tipoC];\r			 \r			 arr2[arr2.length] = [\"oidPais\", pais]; \r          	 arr2[arr2.length] = [\"oidMarca\", tipoM];\r          	 arr2[arr2.length] = [\"oidCanal\", tipoC];\r			 \r			 recargaCombo(\"Formulario.cbPeriodo\",\"PRECargarPeriodos\",\"es.indra.sicc.dtos.cra.DTOPeriodo\",arr);\r			 recargaCombo(\"Formulario.cbRegion\",\"ZONRecargaRegiones\", \"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\",arr2); \r          	 \r             cambioRegionMarcaCanal();\r		} else {\r			 var aCombo = new Array(new Array(\"\",\"\"));\r			 set_combo('Formulario.cbPeriodo', aCombo, []); \r			 set_combo('Formulario.cbRegion', aCombo, []);\r			 set_combo('Formulario.cbZona', aCombo, []);\r		}\r    } \r   \r   function cambioRegionMarcaCanal(){\r		opciones = new Array();\r		set_combo('Formulario.cbZona',opciones);\r		combo_add('Formulario.cbZona', '', '');\r		var regiones = quitarItemVacio(get('Formulario.cbRegion'));\r		var pais = get('Formulario.pais');\r		var regionConc = new String();\r		for(i=0;i<regiones.length;i++){\r			regionConc += regiones[i] + \"x\";\r		}\r		regionConc = regionConc.substring(0, regionConc.length-1);\r		var arr = new Array();\r		arr[arr.length] = ['cadena', regionConc];\r		arr[arr.length] = ['oidPais', pais]\r		if(regionConc != ''){\r			recargaCombo(\"Formulario.cbZona\", \"REPRecargaZonas\", \"es.indra.sicc.util.DTOString\",arr);\r		}  \r  }  \r    function onchangeCanal(){\r      onchangeMarcaCanal();\r    }\r\r        function arrayComponentes(){\r              var arr = new Array();\r              arr[arr.length]= new Array(\"cbMarca\",\"\");\r              arr[arr.length]= new Array(\"cbCanal\",\"\");\r              arr[arr.length]= new Array(\"cbPeriodo\",\"\");\r              arr[arr.length]= new Array(\"cbRegion\",\"\");\r	      arr[arr.length]= new Array(\"cbZona\",\"\");\r\r              arr[arr.length]= new Array(\"btnGenerarInforme\",\"BOTON\");\r              \r              return arr;\r          }\r\r          function tabGenerico(nombreComp, tipotab){       \r            var arr = arrayComponentes();\r            var tabular = false;\r            var nombreFormulario = getFormularioSICC();\r            var j = 0;\r            var k = arr.length;\r            if (tipotab != \"sh\") {\r                j = j-1;                \r                k = k-1;\r            }\r\r            while(j<k){\r                var t;\r                if(tipotab == \"sh\"){\r                  k--;\r                  t = k;\r                } else{\r                  j++;\r                  t = j;                  \r                }\r                  \r                var nombre = arr[t][0];\r                var tipo = arr[t][1];\r                if (tabular==false){\r                  if (nombreComp==nombre){\r                      tabular=true;\r                      if (tipotab == \"sh\"){\r                        if (k==0) k= arr.length;\r                      } else {\r                        if ((j+1)==arr.length)  j = -1;\r                      }\r                  }                \r                } else {\r                  try {\r                    var name = nombreFormulario+\".\"+nombre;\r                    if (tipo==\"BOTONXY\"){\r                       focalizaBotonHTML_XY(nombre);\r                    } else if (tipo==\"BOTON\") {\r                       focalizaBotonHTML(\"botonContenido\",nombre)\r                    } else {\r                       focaliza(name);\r                    }\r                    return;\r                  } catch (e) {\r                  }\r                }\r            }\r          } \r\r   \r"));
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
      ((Element)v.get(9)).setAttribute("name","cbPeriodo" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","276" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbRegion" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","109" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbZona" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","143" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */
      /* Termina nodo:6   */

      /* Empieza nodo:12 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(12)).setAttribute("nombre","Formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","accion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(14)).setAttribute("valor","FACNotasCreditoEbelistas" );
      ((Element)v.get(12)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","idioma" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","pais" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","marca" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","canal" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("nombre","periodo" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","region" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","zonas" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 12   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(25)).setAttribute("nombre","capa" );
      ((Element)v.get(12)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("table"));
      ((Element)v.get(26)).setAttribute("width","100%" );
      ((Element)v.get(26)).setAttribute("border","0" );
      ((Element)v.get(26)).setAttribute("cellspacing","0" );
      ((Element)v.get(26)).setAttribute("cellpadding","0" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(28)).setAttribute("align","center" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).setAttribute("width","12" );
      ((Element)v.get(29)).setAttribute("height","12" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).setAttribute("width","750" );
      ((Element)v.get(27)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).setAttribute("width","12" );
      ((Element)v.get(27)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).setAttribute("width","12" );
      ((Element)v.get(33)).setAttribute("height","1" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */
      /* Termina nodo:27   */

      /* Empieza nodo:34 / Elemento padre: 26   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(26)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(39)).setAttribute("class","legend" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(40)).setAttribute("nombre","lblCriteriosSeleccion" );
      ((Element)v.get(40)).setAttribute("alto","13" );
      ((Element)v.get(40)).setAttribute("filas","1" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(40)).setAttribute("id","legend" );
      ((Element)v.get(40)).setAttribute("cod","00275" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 38   */
      v.add(doc.createElement("table"));
      ((Element)v.get(41)).setAttribute("width","100%" );
      ((Element)v.get(41)).setAttribute("border","0" );
      ((Element)v.get(41)).setAttribute("align","center" );
      ((Element)v.get(41)).setAttribute("cellspacing","0" );
      ((Element)v.get(41)).setAttribute("cellpadding","0" );
      ((Element)v.get(38)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).setAttribute("colspan","7" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","8" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:45 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("width","8" );
      ((Element)v.get(47)).setAttribute("height","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(49)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(49)).setAttribute("alto","13" );
      ((Element)v.get(49)).setAttribute("filas","1" );
      ((Element)v.get(49)).setAttribute("id","datosTitle" );
      ((Element)v.get(49)).setAttribute("cod","6" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","25" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(53)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(53)).setAttribute("alto","13" );
      ((Element)v.get(53)).setAttribute("filas","1" );
      ((Element)v.get(53)).setAttribute("id","datosTitle" );
      ((Element)v.get(53)).setAttribute("cod","7" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("width","100%" );
      ((Element)v.get(45)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","8" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:45   */

      /* Empieza nodo:56 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(56)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(60)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(60)).setAttribute("size","1" );
      ((Element)v.get(60)).setAttribute("multiple","N" );
      ((Element)v.get(60)).setAttribute("valorinicial","" );
      ((Element)v.get(60)).setAttribute("onchange","onchangeMarcaCanal();" );
      ((Element)v.get(60)).setAttribute("textoinicial","" );
      ((Element)v.get(60)).setAttribute("id","datosCampos" );
      ((Element)v.get(60)).setAttribute("req","S" );
      ((Element)v.get(60)).setAttribute("ontab","tabGenerico('cbMarca');" );
      ((Element)v.get(60)).setAttribute("onshtab","tabGenerico('cbMarca','sh');" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:62 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","25" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(56)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(65)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(65)).setAttribute("size","1" );
      ((Element)v.get(65)).setAttribute("onchange","onchangeCanal();" );
      ((Element)v.get(65)).setAttribute("multiple","N" );
      ((Element)v.get(65)).setAttribute("valorinicial","" );
      ((Element)v.get(65)).setAttribute("textoinicial","" );
      ((Element)v.get(65)).setAttribute("id","datosCampos" );
      ((Element)v.get(65)).setAttribute("req","S" );
      ((Element)v.get(65)).setAttribute("ontab","tabGenerico('cbCanal');" );
      ((Element)v.get(65)).setAttribute("onshtab","tabGenerico('cbCanal','sh');" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:67 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("width","100%" );
      ((Element)v.get(56)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:56   */

      /* Empieza nodo:69 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("colspan","7" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:41   */

      /* Empieza nodo:72 / Elemento padre: 38   */
      v.add(doc.createElement("table"));
      ((Element)v.get(72)).setAttribute("width","100%" );
      ((Element)v.get(72)).setAttribute("border","0" );
      ((Element)v.get(72)).setAttribute("align","center" );
      ((Element)v.get(72)).setAttribute("cellspacing","0" );
      ((Element)v.get(72)).setAttribute("cellpadding","0" );
      ((Element)v.get(38)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","8" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(77)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("filas","1" );
      ((Element)v.get(77)).setAttribute("id","datosTitle" );
      ((Element)v.get(77)).setAttribute("cod","276" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","25" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(81)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(81)).setAttribute("alto","13" );
      ((Element)v.get(81)).setAttribute("filas","1" );
      ((Element)v.get(81)).setAttribute("id","datosTitle" );
      ((Element)v.get(81)).setAttribute("cod","109" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","100%" );
      ((Element)v.get(73)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","8" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:73   */

      /* Empieza nodo:84 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(84));

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
      ((Element)v.get(87)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(84)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(88)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(88)).setAttribute("size","1" );
      ((Element)v.get(88)).setAttribute("multiple","N" );
      ((Element)v.get(88)).setAttribute("valorinicial","" );
      ((Element)v.get(88)).setAttribute("textoinicial","" );
      ((Element)v.get(88)).setAttribute("id","datosCampos" );
      ((Element)v.get(88)).setAttribute("req","S" );
      ((Element)v.get(88)).setAttribute("ontab","tabGenerico('cbPeriodo');" );
      ((Element)v.get(88)).setAttribute("onshtab","tabGenerico('cbPeriodo','sh');" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:90 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","25" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(84)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(93)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(93)).setAttribute("size","1" );
      ((Element)v.get(93)).setAttribute("multiple","N" );
      ((Element)v.get(93)).setAttribute("valorinicial","" );
      ((Element)v.get(93)).setAttribute("textoinicial","" );
      ((Element)v.get(93)).setAttribute("id","datosCampos" );
      ((Element)v.get(93)).setAttribute("req","S" );
      ((Element)v.get(93)).setAttribute("onchange","cambioRegionMarcaCanal();" );
      ((Element)v.get(93)).setAttribute("ontab","tabGenerico('cbRegion');" );
      ((Element)v.get(93)).setAttribute("onshtab","tabGenerico('cbRegion','sh');" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:95 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("width","100%" );
      ((Element)v.get(84)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:84   */

      /* Empieza nodo:97 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("colspan","7" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","8" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:72   */

      /* Empieza nodo:100 / Elemento padre: 38   */
      v.add(doc.createElement("table"));
      ((Element)v.get(100)).setAttribute("width","100%" );
      ((Element)v.get(100)).setAttribute("border","0" );
      ((Element)v.get(100)).setAttribute("align","center" );
      ((Element)v.get(100)).setAttribute("cellspacing","0" );
      ((Element)v.get(100)).setAttribute("cellpadding","0" );
      ((Element)v.get(38)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(105)).setAttribute("nombre","lblZona" );
      ((Element)v.get(105)).setAttribute("alto","13" );
      ((Element)v.get(105)).setAttribute("filas","1" );
      ((Element)v.get(105)).setAttribute("id","datosTitle" );
      ((Element)v.get(105)).setAttribute("cod","143" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","100%" );
      ((Element)v.get(101)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:101   */

      /* Empieza nodo:108 / Elemento padre: 100   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(100)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","8" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(108)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(112)).setAttribute("nombre","cbZona" );
      ((Element)v.get(112)).setAttribute("size","5" );
      ((Element)v.get(112)).setAttribute("multiple","S" );
      ((Element)v.get(112)).setAttribute("valorinicial","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(112)).setAttribute("textoinicial","" );
      ((Element)v.get(112)).setAttribute("id","datosCampos" );
      ((Element)v.get(112)).setAttribute("req","S" );
      ((Element)v.get(112)).setAttribute("ontab","tabGenerico('cbZona');" );
      ((Element)v.get(112)).setAttribute("onshtab","tabGenerico('cbZona','sh');" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:114 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("width","100%" );
      ((Element)v.get(108)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:108   */

      /* Empieza nodo:116 / Elemento padre: 100   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(100)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("colspan","7" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:100   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:119 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:34   */

      /* Empieza nodo:121 / Elemento padre: 26   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(26)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("table"));
      ((Element)v.get(126)).setAttribute("width","100%" );
      ((Element)v.get(126)).setAttribute("border","0" );
      ((Element)v.get(126)).setAttribute("align","center" );
      ((Element)v.get(126)).setAttribute("cellspacing","0" );
      ((Element)v.get(126)).setAttribute("cellpadding","0" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("class","botonera" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(129)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(129)).setAttribute("ID","botonContenido" );
      ((Element)v.get(129)).setAttribute("tipo","html" );
      ((Element)v.get(129)).setAttribute("estado","false" );
      ((Element)v.get(129)).setAttribute("cod","2495" );
      ((Element)v.get(129)).setAttribute("accion","generar();" );
      ((Element)v.get(129)).setAttribute("ontab","tabGenerico('btnGenerarInforme');" );
      ((Element)v.get(129)).setAttribute("onshtab","tabGenerico('btnGenerarInforme','sh');" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:130 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","8" );
      ((Element)v.get(131)).setAttribute("height","12" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:121   */

      /* Empieza nodo:132 / Elemento padre: 26   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(26)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("width","12" );
      ((Element)v.get(133)).setAttribute("align","center" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","12" );
      ((Element)v.get(134)).setAttribute("height","12" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("width","756" );
      ((Element)v.get(132)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("width","12" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(132)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","12" );
      ((Element)v.get(138)).setAttribute("height","1" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:132   */
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:139 / Elemento padre: 12   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(139)).setAttribute("nombre","capaPeriodo" );
      ((Element)v.get(139)).setAttribute("alto","3" );
      ((Element)v.get(139)).setAttribute("ancho","624" );
      ((Element)v.get(139)).setAttribute("colorf","" );
      ((Element)v.get(139)).setAttribute("borde","0" );
      ((Element)v.get(139)).setAttribute("imagenf","" );
      ((Element)v.get(139)).setAttribute("repeat","" );
      ((Element)v.get(139)).setAttribute("padding","" );
      ((Element)v.get(139)).setAttribute("visibilidad","visible" );
      ((Element)v.get(139)).setAttribute("contravsb","" );
      ((Element)v.get(139)).setAttribute("x","0" );
      ((Element)v.get(139)).setAttribute("y","165" );
      ((Element)v.get(139)).setAttribute("zindex","" );
      ((Element)v.get(12)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(140)).setAttribute("seleccion","boton" );
      ((Element)v.get(140)).setAttribute("nombre","lstPeriodo" );
      ((Element)v.get(140)).setAttribute("x","12" );
      ((Element)v.get(140)).setAttribute("y","10" );
      ((Element)v.get(140)).setAttribute("ancho","600" );
      ((Element)v.get(140)).setAttribute("alto","3" );
      ((Element)v.get(140)).setAttribute("multisel","-1" );
      ((Element)v.get(140)).setAttribute("incy","10" );
      ((Element)v.get(140)).setAttribute("incx","10" );
      ((Element)v.get(140)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(140)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(140)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(140)).setAttribute("accion","" );
      ((Element)v.get(140)).setAttribute("sep","|" );
      ((Element)v.get(140)).setAttribute("pixelsborde","2" );
      ((Element)v.get(140)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(141)).setAttribute("nombre","cab1" );
      ((Element)v.get(141)).setAttribute("height","20" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(142)).setAttribute("ancho","40" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Elemento padre:142 / Elemento actual: 143   */
      v.add(doc.createTextNode("Periodo"));
      ((Element)v.get(142)).appendChild((Text)v.get(143));

      /* Termina nodo Texto:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 141   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(144)).setAttribute("ancho","60" );
      ((Element)v.get(141)).appendChild((Element)v.get(144));

      /* Elemento padre:144 / Elemento actual: 145   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(144)).appendChild((Text)v.get(145));

      /* Termina nodo Texto:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 141   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(146)).setAttribute("ancho","440" );
      ((Element)v.get(141)).appendChild((Element)v.get(146));

      /* Elemento padre:146 / Elemento actual: 147   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(146)).appendChild((Text)v.get(147));

      /* Termina nodo Texto:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 141   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(148)).setAttribute("ancho","440" );
      ((Element)v.get(141)).appendChild((Element)v.get(148));

      /* Elemento padre:148 / Elemento actual: 149   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(148)).appendChild((Text)v.get(149));

      /* Termina nodo Texto:149   */
      /* Termina nodo:148   */
      /* Termina nodo:141   */

      /* Empieza nodo:150 / Elemento padre: 140   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(150)).setAttribute("ancho","590" );
      ((Element)v.get(150)).setAttribute("filas","1" );
      ((Element)v.get(150)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(140)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("ancho","40" );
      ((Element)v.get(151)).setAttribute("caracteres","20" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 150   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("ancho","60" );
      ((Element)v.get(152)).setAttribute("caracteres","20" );
      ((Element)v.get(150)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 150   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("ancho","440" );
      ((Element)v.get(153)).setAttribute("caracteres","30" );
      ((Element)v.get(150)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 150   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("ancho","440" );
      ((Element)v.get(154)).setAttribute("caracteres","30" );
      ((Element)v.get(150)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:150   */

      /* Empieza nodo:155 / Elemento padre: 140   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(140)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:156 / Elemento padre: 12   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(156)).setAttribute("nombre","capaRegion" );
      ((Element)v.get(156)).setAttribute("alto","3" );
      ((Element)v.get(156)).setAttribute("ancho","624" );
      ((Element)v.get(156)).setAttribute("colorf","" );
      ((Element)v.get(156)).setAttribute("borde","0" );
      ((Element)v.get(156)).setAttribute("imagenf","" );
      ((Element)v.get(156)).setAttribute("repeat","" );
      ((Element)v.get(156)).setAttribute("padding","" );
      ((Element)v.get(156)).setAttribute("visibilidad","visible" );
      ((Element)v.get(156)).setAttribute("contravsb","" );
      ((Element)v.get(156)).setAttribute("x","0" );
      ((Element)v.get(156)).setAttribute("y","165" );
      ((Element)v.get(156)).setAttribute("zindex","" );
      ((Element)v.get(12)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(157)).setAttribute("seleccion","boton" );
      ((Element)v.get(157)).setAttribute("nombre","lstRegion" );
      ((Element)v.get(157)).setAttribute("x","12" );
      ((Element)v.get(157)).setAttribute("y","10" );
      ((Element)v.get(157)).setAttribute("ancho","600" );
      ((Element)v.get(157)).setAttribute("alto","3" );
      ((Element)v.get(157)).setAttribute("multisel","-1" );
      ((Element)v.get(157)).setAttribute("incy","10" );
      ((Element)v.get(157)).setAttribute("incx","10" );
      ((Element)v.get(157)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(157)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(157)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(157)).setAttribute("accion","" );
      ((Element)v.get(157)).setAttribute("sep","|" );
      ((Element)v.get(157)).setAttribute("pixelsborde","2" );
      ((Element)v.get(157)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(158)).setAttribute("nombre","cab1" );
      ((Element)v.get(158)).setAttribute("height","20" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(159)).setAttribute("ancho","40" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Elemento padre:159 / Elemento actual: 160   */
      v.add(doc.createTextNode("Region"));
      ((Element)v.get(159)).appendChild((Text)v.get(160));

      /* Termina nodo Texto:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 158   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(161)).setAttribute("ancho","60" );
      ((Element)v.get(158)).appendChild((Element)v.get(161));

      /* Elemento padre:161 / Elemento actual: 162   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(161)).appendChild((Text)v.get(162));

      /* Termina nodo Texto:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 158   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(163)).setAttribute("ancho","440" );
      ((Element)v.get(158)).appendChild((Element)v.get(163));

      /* Elemento padre:163 / Elemento actual: 164   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(163)).appendChild((Text)v.get(164));

      /* Termina nodo Texto:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 158   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(165)).setAttribute("ancho","440" );
      ((Element)v.get(158)).appendChild((Element)v.get(165));

      /* Elemento padre:165 / Elemento actual: 166   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(165)).appendChild((Text)v.get(166));

      /* Termina nodo Texto:166   */
      /* Termina nodo:165   */
      /* Termina nodo:158   */

      /* Empieza nodo:167 / Elemento padre: 157   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(167)).setAttribute("ancho","590" );
      ((Element)v.get(167)).setAttribute("filas","1" );
      ((Element)v.get(167)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(157)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("ancho","40" );
      ((Element)v.get(168)).setAttribute("caracteres","20" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("ancho","60" );
      ((Element)v.get(169)).setAttribute("caracteres","20" );
      ((Element)v.get(167)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("ancho","440" );
      ((Element)v.get(170)).setAttribute("caracteres","30" );
      ((Element)v.get(167)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("ancho","440" );
      ((Element)v.get(171)).setAttribute("caracteres","30" );
      ((Element)v.get(167)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:167   */

      /* Empieza nodo:172 / Elemento padre: 157   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(157)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:173 / Elemento padre: 12   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(173)).setAttribute("nombre","capaZona" );
      ((Element)v.get(173)).setAttribute("alto","3" );
      ((Element)v.get(173)).setAttribute("ancho","624" );
      ((Element)v.get(173)).setAttribute("colorf","" );
      ((Element)v.get(173)).setAttribute("borde","0" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(173)).setAttribute("imagenf","" );
      ((Element)v.get(173)).setAttribute("repeat","" );
      ((Element)v.get(173)).setAttribute("padding","" );
      ((Element)v.get(173)).setAttribute("visibilidad","visible" );
      ((Element)v.get(173)).setAttribute("contravsb","" );
      ((Element)v.get(173)).setAttribute("x","0" );
      ((Element)v.get(173)).setAttribute("y","165" );
      ((Element)v.get(173)).setAttribute("zindex","" );
      ((Element)v.get(12)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(174)).setAttribute("seleccion","boton" );
      ((Element)v.get(174)).setAttribute("nombre","lstZona" );
      ((Element)v.get(174)).setAttribute("x","12" );
      ((Element)v.get(174)).setAttribute("y","10" );
      ((Element)v.get(174)).setAttribute("ancho","600" );
      ((Element)v.get(174)).setAttribute("alto","3" );
      ((Element)v.get(174)).setAttribute("multisel","-1" );
      ((Element)v.get(174)).setAttribute("incy","10" );
      ((Element)v.get(174)).setAttribute("incx","10" );
      ((Element)v.get(174)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(174)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(174)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(174)).setAttribute("accion","" );
      ((Element)v.get(174)).setAttribute("sep","|" );
      ((Element)v.get(174)).setAttribute("pixelsborde","2" );
      ((Element)v.get(174)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(175)).setAttribute("nombre","cab1" );
      ((Element)v.get(175)).setAttribute("height","20" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(176)).setAttribute("ancho","40" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Elemento padre:176 / Elemento actual: 177   */
      v.add(doc.createTextNode("Zona"));
      ((Element)v.get(176)).appendChild((Text)v.get(177));

      /* Termina nodo Texto:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 175   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(178)).setAttribute("ancho","40" );
      ((Element)v.get(175)).appendChild((Element)v.get(178));

      /* Elemento padre:178 / Elemento actual: 179   */
      v.add(doc.createTextNode("Region"));
      ((Element)v.get(178)).appendChild((Text)v.get(179));

      /* Termina nodo Texto:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 175   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(180)).setAttribute("ancho","60" );
      ((Element)v.get(175)).appendChild((Element)v.get(180));

      /* Elemento padre:180 / Elemento actual: 181   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(180)).appendChild((Text)v.get(181));

      /* Termina nodo Texto:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 175   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(182)).setAttribute("ancho","440" );
      ((Element)v.get(175)).appendChild((Element)v.get(182));

      /* Elemento padre:182 / Elemento actual: 183   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(182)).appendChild((Text)v.get(183));

      /* Termina nodo Texto:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 175   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(184)).setAttribute("ancho","440" );
      ((Element)v.get(175)).appendChild((Element)v.get(184));

      /* Elemento padre:184 / Elemento actual: 185   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(184)).appendChild((Text)v.get(185));

      /* Termina nodo Texto:185   */
      /* Termina nodo:184   */
      /* Termina nodo:175   */

      /* Empieza nodo:186 / Elemento padre: 174   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(186)).setAttribute("ancho","590" );
      ((Element)v.get(186)).setAttribute("filas","1" );
      ((Element)v.get(186)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(174)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("ancho","40" );
      ((Element)v.get(187)).setAttribute("caracteres","20" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("ancho","60" );
      ((Element)v.get(188)).setAttribute("caracteres","20" );
      ((Element)v.get(186)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("ancho","440" );
      ((Element)v.get(189)).setAttribute("caracteres","30" );
      ((Element)v.get(186)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("ancho","440" );
      ((Element)v.get(190)).setAttribute("caracteres","30" );
      ((Element)v.get(186)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("ancho","440" );
      ((Element)v.get(191)).setAttribute("caracteres","30" );
      ((Element)v.get(186)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:186   */

      /* Empieza nodo:192 / Elemento padre: 174   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(174)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:12   */


   }

}

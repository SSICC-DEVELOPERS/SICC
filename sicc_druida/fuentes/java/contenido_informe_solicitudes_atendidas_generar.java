
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_informe_solicitudes_atendidas_generar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_informe_solicitudes_atendidas_generar" );
      ((Element)v.get(0)).setAttribute("cod","0837" );
      ((Element)v.get(0)).setAttribute("titulo","Generar Informe Solicitudes de Pedidos Atendidas" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Generar Informe Solicitudes de Pedidos Atendidas" );
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
      v.add(doc.createTextNode("\r   \r   \r   function onLoad(){\r      configurarMenuSecundario('Formulario');      \r      focaliza('Formulario.cbMarca');\r   }\r\r     function quitarItemVacio(elemento){\r      var elementoADevolver = new Array();\r     \r      for(var k=0;k<elemento.length;k++) {\r          if (elemento[k] != ''){                            \r             elementoADevolver[elementoADevolver.length] = elemento[k];\r          }\r      }\r         \r      return elementoADevolver;\r      \r   }\r   function generar(formato){\r      \r      if(sicc_validaciones_generales()){\r          \r          var a = new Object();\r          a.accion = 'generar';\r          a.marca = get('Formulario.cbMarca');\r          a.canal = get('Formulario.cbCanal');\r          a.accesos = quitarItemVacio(get('Formulario.cbAcceso'));\r          a.subaccesos = quitarItemVacio(get('Formulario.cbSubacceso'));\r          a.periodos = quitarItemVacio(get('Formulario.cbPeriodo'));\r          a.tipossolicitudes = quitarItemVacio(get('Formulario.cbTipoSolicitud'));\r          a.regiones = quitarItemVacio(get('Formulario.cbRegion'));\r          a.zonas = quitarItemVacio(get('Formulario.cbZona')) ;           \r          \r          a.formatoSalida = formato;\r         \r         \r          mostrarModalSICC('PEDSolicitudesPedidosAtendidas','generar', a);\r      }\r\r   }\r  function recolectarParametros(){\r        set('Formulario.marca',get('Formulario.cbMarca')) ;\r        set('Formulario.canal',get('Formulario.cbCanal')) ;\r        set('Formulario.accesos', get('Formulario.cbAcceso'));\r        set('Formulario.subaccesos', get('Formulario.cbSubacceso'));\r        set('Formulario.periodos',get('Formulario.cbPeriodo'));\r        set('Formulario.tipossolicitudes',get('Formulario.cbTipoSolicitud'));\r        set('Formulario.regiones',get('Formulario.cbRegion'));\r        set('Formulario.zonas',get('Formulario.cbZona')) ;\r        \r  }\r\r   function fLimpiar(){\r \r      var aCombo = new Array(new Array(\"\",\"\"));            \r      set_combo('Formulario.cbAcceso', aCombo, []);            \r      set_combo('Formulario.cbSubacceso', aCombo, []);      \r      set_combo('Formulario.cbPeriodo', aCombo, []);      \r      set_combo('Formulario.cbTipoSolicitud', aCombo, []);      \r      set_combo('Formulario.cbRegion', aCombo, []); \r      set_combo('Formulario.cbZona', aCombo, []);\r      \r      focaliza('Formulario.cbMarca'); \r   }\r   function cambioCanal(){\r    cargaAccesos();\r    cambioMarcaCanal();\r  }    \r\r  function cargaAccesos(){\r    canal  = get('Formulario.cbCanal');\r    pais   = get('Formulario.pais');\r    idioma = get('Formulario.idioma');\r     \r    if(canal != ''){\r    \r       var arr = new Array();\r             \r       arr[arr.length] = [\"oidIdioma\", idioma]; \r       arr[arr.length] = [\"oidPais\", pais]; \r       arr[arr.length] = [\"oid\", canal];\r          \r       recargaCombo(\"Formulario.cbAcceso\",\"SEGObtieneAccesosPorCanal\",\"es.indra.sicc.util.DTOOID\",arr);\r\r       var aCombo = new Array(new Array(\"\",\"\"));\r       set_combo('Formulario.cbSubacceso', aCombo, []);\r       set_combo('Formulario.cbTipoSolicitud', aCombo, []);              \r       \r    }else{\r       var aCombo = new Array(new Array(\"\",\"\"));\r       set_combo('Formulario.cbAcceso', aCombo, []);\r       set_combo('Formulario.cbSubacceso', aCombo, []);\r       set_combo('Formulario.cbTipoSolicitud', aCombo, []);              \r    }\r  } \r   \r   function cambioMarcaCanal(){\r          \r     tipoM = get('Formulario.cbMarca','V');\r     tipoC = get('Formulario.cbCanal','V');\r\r          if(tipoM != '' && tipoC != ''){\r       var arr = new Array();     \r       var arr2 = new Array();            \r       pais   = get('Formulario.pais');\r       idioma = get('Formulario.idioma');\r        \r       arr[arr.length] = [\"oidIdioma\", idioma]; \r       arr[arr.length] = [\"oidPais\", pais]; \r       arr[arr.length] = [\"marca\", tipoM];\r       arr[arr.length] = [\"canal\", tipoC];\r\r       arr2[arr2.length] = [\"oidPais\", pais]; \r       arr2[arr2.length] = [\"oidMarca\", tipoM];\r       arr2[arr2.length] = [\"oidCanal\", tipoC];\r     \r       recargaCombo(\"Formulario.cbPeriodo\",\"REPCargarPeriodos\",\"es.indra.sicc.dtos.cra.DTOPeriodo\",arr);\r       recargaCombo(\"Formulario.cbRegion\",\"ZONRecargaRegiones\", \"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\",arr2); \r        \r       var aCombo = new Array(new Array(\"\",\"\")); \r       set_combo('Formulario.cbZona', aCombo, []);          \r       \r     } else {\r       var aCombo = new Array(new Array(\"\",\"\"));\r       set_combo('Formulario.cbPeriodo', aCombo, []); \r       set_combo('Formulario.cbRegion', aCombo, []);          \r       set_combo('Formulario.cbZona', aCombo, []);          \r     }\r         \r  }    \r   \r   function cambioAccesoMarcaCanal(){\r         \r     opcionesTipoSoli = new Array();     \r     set_combo('Formulario.cbTipoSolicitud',opcionesTipoSoli);        \r     tipoM = get('Formulario.cbMarca','V');\r     tipoC = get('Formulario.cbCanal','V');\r     tipoR = get('Formulario.cbAcceso','V');          \r     combo_add('Formulario.cbTipoSolicitud', '', '');\r       \r     for(var k=0;k<lstTipoSoli.datos.longitud;k++) {\r        for(var y=0;y<tipoM.length;y++){\r          for(var x=0;x<tipoC.length;x++){\r            for(var z=0;z<tipoR.length;z++){              \r               if ((lstTipoSoli.datos.ij(k,3) == tipoM[y])&&\r                   (lstTipoSoli.datos.ij(k,4) == tipoC[x])&&\r                   (lstTipoSoli.datos.ij(k,2) == tipoR[z])){\r                  combo_add('Formulario.cbTipoSolicitud',lstTipoSoli.datos.ij(k,0),lstTipoSoli.datos.ij(k,1));\r        \r               }\r             }\r           }\r        }\r    }  \r  }    \r   \r   /*function cambioRegionMarcaCanal(){\r         \r     opcionesNZona = new Array();     \r     set_combo('Formulario.cbZona',opcionesNZona);        \r     tipoM = get('Formulario.cbMarca','V');\r     tipoC = get('Formulario.cbCanal','V');\r     tipoR = get('Formulario.cbRegion','V');          \r     combo_add('Formulario.cbZona', '', '');\r       \r     for(var k=0;k<lstZona.datos.longitud;k++) {\r        for(var y=0;y<tipoM.length;y++){\r          for(var x=0;x<tipoC.length;x++){\r            for(var z=0;z<tipoR.length;z++){              \r               if ((lstZona.datos.ij(k,3) == tipoM[y])&&\r                   (lstZona.datos.ij(k,4) == tipoC[x])&&\r                   (lstZona.datos.ij(k,1) == tipoR[z])){\r                  combo_add('Formulario.cbZona',lstZona.datos.ij(k,0),lstZona.datos.ij(k,2));\r        \r               }\r             }\r           }\r        }\r    }  \r  }*/\r\r    function cambioRegionMarcaCanal(){\r    \r    opciones = new Array();\r    set_combo('Formulario.cbZona',opciones);\r         \r    combo_add('Formulario.cbZona', '', '');\r\r    var regiones = quitarItemVacio(get('Formulario.cbRegion'));\r    var pais = get('Formulario.pais');\r    var regionConc = new String();\r\r    for(i=0;i<regiones.length;i++){\r      regionConc += regiones[i] + \"x\";\r    }\r          \r    regionConc = regionConc.substring(0, regionConc.length-1);\r    \r    var arr = new Array();\r    arr[arr.length] = ['cadena', regionConc];\r    arr[arr.length] = ['oidPais', pais]\r    \r    if(regionConc != ''){\r      recargaCombo(\"Formulario.cbZona\", \"REPRecargaZonas\", \"es.indra.sicc.util.DTOString\",arr);\r    }     \r  }\r    \r   \r   function cambioAcceso(){\r     \r          opciones = new Array();\r     set_combo('Formulario.cbSubacceso',opciones);        \r     tipo = get('Formulario.cbAcceso','V');\r     combo_add('Formulario.cbSubacceso', '', '');\r       \r     for(var k=0;k<lstSubacceso.datos.longitud;k++) {\r        for(var y=0;y<tipo.length;y++){\r                     if (lstSubacceso.datos.ij(k,2) == tipo[y]){ 			 \r              combo_add('Formulario.cbSubacceso',lstSubacceso.datos.ij(k,0),lstSubacceso.datos.ij(k,1));\r    \r           }\r        }\r    }\r    \r    \r    \r    cambioAccesoMarcaCanal();\r  }\r        function arrayComponentes(){\r              var arr = new Array();               \r              arr[arr.length]= new Array(\"cbMarca\",\"\");\r              arr[arr.length]= new Array(\"cbCanal\",\"\");              \r              arr[arr.length]= new Array(\"cbAcceso\",\"\");\r              arr[arr.length]= new Array(\"cbSubacceso\",\"\");\r              arr[arr.length]= new Array(\"cbPeriodo\",\"\");\r              arr[arr.length]= new Array(\"cbTipoSolicitud\",\"\");\r              arr[arr.length]= new Array(\"cbRegion\",\"\");\r              arr[arr.length]= new Array(\"cbZona\",\"\");\r              arr[arr.length]= new Array(\"btnGenerarInforme\",\"BOTON\");\r              arr[arr.length]= new Array(\"btnGenerarExcel\",\"BOTON\");\r              \r              return arr;\r          }\r          function tabGenerico(nombreComp, tipotab){       \r            var arr = arrayComponentes();\r            var tabular = false;\r            var nombreFormulario = getFormularioSICC();\r            var j = 0;\r            var k = arr.length;\r            if (tipotab != \"sh\") {\r                j = j-1;                \r                k = k-1;\r            }\r\r            while(j<k){\r                var t;\r                if(tipotab == \"sh\"){\r                  k--;\r                  t = k;\r                } else{\r                  j++;\r                  t = j;                  \r                }\r                  \r                var nombre = arr[t][0];\r                var tipo = arr[t][1];\r                if (tabular==false){\r                  if (nombreComp==nombre){\r                      tabular=true;\r                      if (tipotab == \"sh\"){\r                        if (k==0) k= arr.length;\r                      } else {\r                        if ((j+1)==arr.length)  j = -1;\r                      }\r                  }                \r                } else {\r                  try {\r                    var name = nombreFormulario+\".\"+nombre;\r                    if (tipo==\"BOTONXY\"){\r                       focalizaBotonHTML_XY(nombre);\r                    } else if (tipo==\"BOTON\") {\r                       focalizaBotonHTML(\"botonContenido\",nombre)\r                    } else {\r                       focaliza(name);\r                    }\r                    return;\r                  } catch (e) {\r                  }\r                }\r            }\r          } \r   \r"));
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
      ((Element)v.get(12)).setAttribute("valor","PEDSolicitudesPedidosAtendidas" );
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
      ((Element)v.get(19)).setAttribute("nombre","marca" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","canal" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","accesos" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","subaccesos" );
      ((Element)v.get(22)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(10)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","periodos" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","tipossolicitudes" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","regiones" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","zonas" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","formatoSalida" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(28)).setAttribute("nombre","capa" );
      ((Element)v.get(10)).appendChild((Element)v.get(28));

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
      ((Element)v.get(43)).setAttribute("nombre","lblCriteriosSeleccion" );
      ((Element)v.get(43)).setAttribute("filas","1" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(43)).setAttribute("id","legend" );
      ((Element)v.get(43)).setAttribute("cod","00275" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("table"));
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
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("table"));
      ((Element)v.get(47)).setAttribute("width","100%" );
      ((Element)v.get(47)).setAttribute("border","0" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("align","left" );
      ((Element)v.get(47)).setAttribute("cellspacing","0" );
      ((Element)v.get(47)).setAttribute("cellpadding","0" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

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
      ((Element)v.get(52)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("id","datosTitle" );
      ((Element)v.get(52)).setAttribute("cod","6" );
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
      ((Element)v.get(56)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(56)).setAttribute("filas","1" );
      ((Element)v.get(56)).setAttribute("id","datosTitle" );
      ((Element)v.get(56)).setAttribute("cod","7" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("width","100%" );
      ((Element)v.get(48)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:48   */

      /* Empieza nodo:59 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","8" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(62)).setAttribute("valign","top" );
      ((Element)v.get(59)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(63)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(63)).setAttribute("onchange","cambioMarcaCanal();" );
      ((Element)v.get(63)).setAttribute("size","1" );
      ((Element)v.get(63)).setAttribute("multiple","N" );
      ((Element)v.get(63)).setAttribute("valorinicial","" );
      ((Element)v.get(63)).setAttribute("textoinicial","" );
      ((Element)v.get(63)).setAttribute("id","datosCampos" );
      ((Element)v.get(63)).setAttribute("req","S" );
      ((Element)v.get(63)).setAttribute("ontab","tabGenerico('cbMarca');" );
      ((Element)v.get(63)).setAttribute("onshtab","tabGenerico('cbMarca','sh');" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:65 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","25" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(59)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(68)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(68)).setAttribute("onchange","cambioCanal();" );
      ((Element)v.get(68)).setAttribute("size","1" );
      ((Element)v.get(68)).setAttribute("multiple","N" );
      ((Element)v.get(68)).setAttribute("valorinicial","" );
      ((Element)v.get(68)).setAttribute("textoinicial","" );
      ((Element)v.get(68)).setAttribute("id","datosCampos" );
      ((Element)v.get(68)).setAttribute("req","S" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).setAttribute("ontab","tabGenerico('cbCanal');" );
      ((Element)v.get(68)).setAttribute("onshtab","tabGenerico('cbCanal','sh');" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:70 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("width","100%" );
      ((Element)v.get(59)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:59   */

      /* Empieza nodo:72 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("colspan","4" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","8" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:75 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("table"));
      ((Element)v.get(77)).setAttribute("width","100%" );
      ((Element)v.get(77)).setAttribute("border","0" );
      ((Element)v.get(77)).setAttribute("align","left" );
      ((Element)v.get(77)).setAttribute("cellspacing","0" );
      ((Element)v.get(77)).setAttribute("cellpadding","0" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","8" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(82)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(82)).setAttribute("filas","1" );
      ((Element)v.get(82)).setAttribute("id","datosTitle" );
      ((Element)v.get(82)).setAttribute("cod","10" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","25" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(86)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(86)).setAttribute("filas","1" );
      ((Element)v.get(86)).setAttribute("id","datosTitle" );
      ((Element)v.get(86)).setAttribute("cod","122" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("width","100%" );
      ((Element)v.get(78)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","8" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:78   */

      /* Empieza nodo:89 / Elemento padre: 77   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(77)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(89)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(93)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(93)).setAttribute("onchange","cambioAcceso();" );
      ((Element)v.get(93)).setAttribute("size","5" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(93)).setAttribute("multiple","S" );
      ((Element)v.get(93)).setAttribute("valorinicial","" );
      ((Element)v.get(93)).setAttribute("textoinicial","" );
      ((Element)v.get(93)).setAttribute("id","datosCampos" );
      ((Element)v.get(93)).setAttribute("req","N" );
      ((Element)v.get(93)).setAttribute("ontab","tabGenerico('cbAcceso');" );
      ((Element)v.get(93)).setAttribute("onshtab","tabGenerico('cbAcceso','sh');" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:95 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","25" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(89)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(98)).setAttribute("nombre","cbSubacceso" );
      ((Element)v.get(98)).setAttribute("size","5" );
      ((Element)v.get(98)).setAttribute("multiple","S" );
      ((Element)v.get(98)).setAttribute("valorinicial","" );
      ((Element)v.get(98)).setAttribute("textoinicial","" );
      ((Element)v.get(98)).setAttribute("id","datosCampos" );
      ((Element)v.get(98)).setAttribute("req","N" );
      ((Element)v.get(98)).setAttribute("ontab","tabGenerico('cbSubacceso');" );
      ((Element)v.get(98)).setAttribute("onshtab","tabGenerico('cbSubacceso','sh');" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:100 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("width","100%" );
      ((Element)v.get(89)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:89   */

      /* Empieza nodo:102 / Elemento padre: 77   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(77)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("colspan","4" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:105 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("table"));
      ((Element)v.get(107)).setAttribute("width","100%" );
      ((Element)v.get(107)).setAttribute("border","0" );
      ((Element)v.get(107)).setAttribute("align","left" );
      ((Element)v.get(107)).setAttribute("cellspacing","0" );
      ((Element)v.get(107)).setAttribute("cellpadding","0" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(107)).appendChild((Element)v.get(108));

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
      ((Element)v.get(108)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(112)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(112)).setAttribute("filas","1" );
      ((Element)v.get(112)).setAttribute("id","datosTitle" );
      ((Element)v.get(112)).setAttribute("cod","276" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","25" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(116)).setAttribute("nombre","lblTipoSolicitud" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(116)).setAttribute("filas","1" );
      ((Element)v.get(116)).setAttribute("id","datosTitle" );
      ((Element)v.get(116)).setAttribute("cod","415" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("width","100%" );
      ((Element)v.get(108)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:108   */

      /* Empieza nodo:119 / Elemento padre: 107   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(107)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(119)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(123)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(123)).setAttribute("size","5" );
      ((Element)v.get(123)).setAttribute("multiple","S" );
      ((Element)v.get(123)).setAttribute("valorinicial","" );
      ((Element)v.get(123)).setAttribute("textoinicial","" );
      ((Element)v.get(123)).setAttribute("id","datosCampos" );
      ((Element)v.get(123)).setAttribute("req","S" );
      ((Element)v.get(123)).setAttribute("ontab","tabGenerico('cbPeriodo');" );
      ((Element)v.get(123)).setAttribute("onshtab","tabGenerico('cbPeriodo','sh');" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:125 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","25" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(119)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(128)).setAttribute("nombre","cbTipoSolicitud" );
      ((Element)v.get(128)).setAttribute("size","5" );
      ((Element)v.get(128)).setAttribute("multiple","S" );
      ((Element)v.get(128)).setAttribute("valorinicial","" );
      ((Element)v.get(128)).setAttribute("textoinicial","" );
      ((Element)v.get(128)).setAttribute("id","datosCampos" );
      ((Element)v.get(128)).setAttribute("req","N" );
      ((Element)v.get(128)).setAttribute("ontab","tabGenerico('cbTipoSolicitud');" );
      ((Element)v.get(128)).setAttribute("onshtab","tabGenerico('cbTipoSolicitud','sh');" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:130 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("width","100%" );
      ((Element)v.get(119)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","8" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:119   */

      /* Empieza nodo:132 / Elemento padre: 107   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(107)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("colspan","4" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","8" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:135 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("table"));
      ((Element)v.get(137)).setAttribute("width","100%" );
      ((Element)v.get(137)).setAttribute("border","0" );
      ((Element)v.get(137)).setAttribute("align","left" );
      ((Element)v.get(137)).setAttribute("cellspacing","0" );
      ((Element)v.get(137)).setAttribute("cellpadding","0" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","8" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(142)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(142)).setAttribute("filas","1" );
      ((Element)v.get(142)).setAttribute("id","datosTitle" );
      ((Element)v.get(142)).setAttribute("cod","109" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","25" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(146)).setAttribute("nombre","lblZona" );
      ((Element)v.get(146)).setAttribute("filas","1" );
      ((Element)v.get(146)).setAttribute("id","datosTitle" );
      ((Element)v.get(146)).setAttribute("cod","143" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("width","100%" );
      ((Element)v.get(138)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","8" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:138   */

      /* Empieza nodo:149 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(137)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(149)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(153)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(153)).setAttribute("onchange","cambioRegionMarcaCanal();" );
      ((Element)v.get(153)).setAttribute("size","5" );
      ((Element)v.get(153)).setAttribute("multiple","S" );
      ((Element)v.get(153)).setAttribute("valorinicial","" );
      ((Element)v.get(153)).setAttribute("textoinicial","" );
      ((Element)v.get(153)).setAttribute("id","datosCampos" );
      ((Element)v.get(153)).setAttribute("req","N" );
      ((Element)v.get(153)).setAttribute("ontab","tabGenerico('cbRegion');" );
      ((Element)v.get(153)).setAttribute("onshtab","tabGenerico('cbRegion','sh');" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:155 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","25" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(149)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(158)).setAttribute("nombre","cbZona" );
      ((Element)v.get(158)).setAttribute("size","5" );
      ((Element)v.get(158)).setAttribute("multiple","S" );
      ((Element)v.get(158)).setAttribute("valorinicial","" );
      ((Element)v.get(158)).setAttribute("textoinicial","" );
      ((Element)v.get(158)).setAttribute("id","datosCampos" );
      ((Element)v.get(158)).setAttribute("req","N" );
      ((Element)v.get(158)).setAttribute("ontab","tabGenerico('cbZona');" );
      ((Element)v.get(158)).setAttribute("onshtab","tabGenerico('cbZona','sh');" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:160 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("width","100%" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(149)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","8" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:149   */

      /* Empieza nodo:162 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(137)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("colspan","4" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:44   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:165 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:37   */

      /* Empieza nodo:167 / Elemento padre: 29   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(29)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("table"));
      ((Element)v.get(172)).setAttribute("width","100%" );
      ((Element)v.get(172)).setAttribute("border","0" );
      ((Element)v.get(172)).setAttribute("align","center" );
      ((Element)v.get(172)).setAttribute("cellspacing","0" );
      ((Element)v.get(172)).setAttribute("cellpadding","0" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).setAttribute("class","botonera" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(175)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(175)).setAttribute("ID","botonContenido" );
      ((Element)v.get(175)).setAttribute("tipo","html" );
      ((Element)v.get(175)).setAttribute("accion","generar('pdf');" );
      ((Element)v.get(175)).setAttribute("estado","false" );
      ((Element)v.get(175)).setAttribute("cod","2495" );
      ((Element)v.get(175)).setAttribute("ontab","tabGenerico('btnGenerarInforme');" );
      ((Element)v.get(175)).setAttribute("onshtab","tabGenerico('btnGenerarInforme','sh');" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 174   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(176)).setAttribute("nombre","btnGenerarExcel" );
      ((Element)v.get(176)).setAttribute("ID","botonContenido" );
      ((Element)v.get(176)).setAttribute("tipo","html" );
      ((Element)v.get(176)).setAttribute("accion","generar('xls');" );
      ((Element)v.get(176)).setAttribute("estado","false" );
      ((Element)v.get(176)).setAttribute("cod","2526" );
      ((Element)v.get(176)).setAttribute("ontab","tabGenerico('btnGenerarExcel');" );
      ((Element)v.get(176)).setAttribute("onshtab","tabGenerico('btnGenerarExcel','sh');" );
      ((Element)v.get(174)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:177 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","8" );
      ((Element)v.get(178)).setAttribute("height","12" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:167   */

      /* Empieza nodo:179 / Elemento padre: 29   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(29)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("width","12" );
      ((Element)v.get(180)).setAttribute("align","center" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","12" );
      ((Element)v.get(181)).setAttribute("height","12" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).setAttribute("width","756" );
      ((Element)v.get(179)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).setAttribute("width","12" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(179)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","12" );
      ((Element)v.get(185)).setAttribute("height","1" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:179   */
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:186 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(186)).setAttribute("nombre","capaAcceso" );
      ((Element)v.get(186)).setAttribute("alto","3" );
      ((Element)v.get(186)).setAttribute("ancho","624" );
      ((Element)v.get(186)).setAttribute("colorf","" );
      ((Element)v.get(186)).setAttribute("borde","0" );
      ((Element)v.get(186)).setAttribute("imagenf","" );
      ((Element)v.get(186)).setAttribute("repeat","" );
      ((Element)v.get(186)).setAttribute("padding","" );
      ((Element)v.get(186)).setAttribute("visibilidad","visible" );
      ((Element)v.get(186)).setAttribute("contravsb","" );
      ((Element)v.get(186)).setAttribute("x","0" );
      ((Element)v.get(186)).setAttribute("y","165" );
      ((Element)v.get(186)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(187)).setAttribute("seleccion","boton" );
      ((Element)v.get(187)).setAttribute("nombre","lstAcceso" );
      ((Element)v.get(187)).setAttribute("x","12" );
      ((Element)v.get(187)).setAttribute("y","10" );
      ((Element)v.get(187)).setAttribute("ancho","600" );
      ((Element)v.get(187)).setAttribute("alto","3" );
      ((Element)v.get(187)).setAttribute("multisel","-1" );
      ((Element)v.get(187)).setAttribute("incy","10" );
      ((Element)v.get(187)).setAttribute("incx","10" );
      ((Element)v.get(187)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(187)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(187)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(187)).setAttribute("accion","" );
      ((Element)v.get(187)).setAttribute("sep","|" );
      ((Element)v.get(187)).setAttribute("pixelsborde","2" );
      ((Element)v.get(187)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(188)).setAttribute("nombre","cab1" );
      ((Element)v.get(188)).setAttribute("height","20" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(189)).setAttribute("ancho","40" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Elemento padre:189 / Elemento actual: 190   */
      v.add(doc.createTextNode("Acceso"));
      ((Element)v.get(189)).appendChild((Text)v.get(190));

      /* Termina nodo Texto:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(191)).setAttribute("ancho","60" );
      ((Element)v.get(188)).appendChild((Element)v.get(191));

      /* Elemento padre:191 / Elemento actual: 192   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(191)).appendChild((Text)v.get(192));

      /* Termina nodo Texto:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(193)).setAttribute("ancho","440" );
      ((Element)v.get(188)).appendChild((Element)v.get(193));

      /* Elemento padre:193 / Elemento actual: 194   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(193)).appendChild((Text)v.get(194));

      /* Termina nodo Texto:194   */
      /* Termina nodo:193   */
      /* Termina nodo:188   */

      /* Empieza nodo:195 / Elemento padre: 187   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(195)).setAttribute("ancho","590" );
      ((Element)v.get(195)).setAttribute("filas","1" );
      ((Element)v.get(195)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(187)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(196)).setAttribute("ancho","40" );
      ((Element)v.get(196)).setAttribute("caracteres","20" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(197)).setAttribute("ancho","60" );
      ((Element)v.get(197)).setAttribute("caracteres","20" );
      ((Element)v.get(195)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("ancho","440" );
      ((Element)v.get(198)).setAttribute("caracteres","30" );
      ((Element)v.get(195)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:195   */

      /* Empieza nodo:199 / Elemento padre: 187   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(187)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:200 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(200)).setAttribute("nombre","capaSubacceso" );
      ((Element)v.get(200)).setAttribute("alto","3" );
      ((Element)v.get(200)).setAttribute("ancho","624" );
      ((Element)v.get(200)).setAttribute("colorf","" );
      ((Element)v.get(200)).setAttribute("borde","0" );
      ((Element)v.get(200)).setAttribute("imagenf","" );
      ((Element)v.get(200)).setAttribute("repeat","" );
      ((Element)v.get(200)).setAttribute("padding","" );
      ((Element)v.get(200)).setAttribute("visibilidad","visible" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(200)).setAttribute("contravsb","" );
      ((Element)v.get(200)).setAttribute("x","0" );
      ((Element)v.get(200)).setAttribute("y","165" );
      ((Element)v.get(200)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(201)).setAttribute("seleccion","boton" );
      ((Element)v.get(201)).setAttribute("nombre","lstSubacceso" );
      ((Element)v.get(201)).setAttribute("x","12" );
      ((Element)v.get(201)).setAttribute("y","10" );
      ((Element)v.get(201)).setAttribute("ancho","600" );
      ((Element)v.get(201)).setAttribute("alto","3" );
      ((Element)v.get(201)).setAttribute("multisel","-1" );
      ((Element)v.get(201)).setAttribute("incy","10" );
      ((Element)v.get(201)).setAttribute("incx","10" );
      ((Element)v.get(201)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(201)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(201)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(201)).setAttribute("accion","" );
      ((Element)v.get(201)).setAttribute("sep","|" );
      ((Element)v.get(201)).setAttribute("pixelsborde","2" );
      ((Element)v.get(201)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(202)).setAttribute("nombre","cab1" );
      ((Element)v.get(202)).setAttribute("height","20" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(203)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(203)).setAttribute("ancho","40" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Elemento padre:203 / Elemento actual: 204   */
      v.add(doc.createTextNode("Subacceso"));
      ((Element)v.get(203)).appendChild((Text)v.get(204));

      /* Termina nodo Texto:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(205)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(205)).setAttribute("ancho","60" );
      ((Element)v.get(202)).appendChild((Element)v.get(205));

      /* Elemento padre:205 / Elemento actual: 206   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(205)).appendChild((Text)v.get(206));

      /* Termina nodo Texto:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(207)).setAttribute("ancho","440" );
      ((Element)v.get(202)).appendChild((Element)v.get(207));

      /* Elemento padre:207 / Elemento actual: 208   */
      v.add(doc.createTextNode("Acceso"));
      ((Element)v.get(207)).appendChild((Text)v.get(208));

      /* Termina nodo Texto:208   */
      /* Termina nodo:207   */
      /* Termina nodo:202   */

      /* Empieza nodo:209 / Elemento padre: 201   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(209)).setAttribute("ancho","590" );
      ((Element)v.get(209)).setAttribute("filas","1" );
      ((Element)v.get(209)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(201)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("ancho","40" );
      ((Element)v.get(210)).setAttribute("caracteres","20" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(211)).setAttribute("ancho","60" );
      ((Element)v.get(211)).setAttribute("caracteres","20" );
      ((Element)v.get(209)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("ancho","440" );
      ((Element)v.get(212)).setAttribute("caracteres","30" );
      ((Element)v.get(209)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:209   */

      /* Empieza nodo:213 / Elemento padre: 201   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(201)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:214 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(214)).setAttribute("nombre","capaPeriodo" );
      ((Element)v.get(214)).setAttribute("alto","3" );
      ((Element)v.get(214)).setAttribute("ancho","624" );
      ((Element)v.get(214)).setAttribute("colorf","" );
      ((Element)v.get(214)).setAttribute("borde","0" );
      ((Element)v.get(214)).setAttribute("imagenf","" );
      ((Element)v.get(214)).setAttribute("repeat","" );
      ((Element)v.get(214)).setAttribute("padding","" );
      ((Element)v.get(214)).setAttribute("visibilidad","visible" );
      ((Element)v.get(214)).setAttribute("contravsb","" );
      ((Element)v.get(214)).setAttribute("x","0" );
      ((Element)v.get(214)).setAttribute("y","165" );
      ((Element)v.get(214)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(215)).setAttribute("seleccion","boton" );
      ((Element)v.get(215)).setAttribute("nombre","lstPeriodo" );
      ((Element)v.get(215)).setAttribute("x","12" );
      ((Element)v.get(215)).setAttribute("y","10" );
      ((Element)v.get(215)).setAttribute("ancho","600" );
      ((Element)v.get(215)).setAttribute("alto","3" );
      ((Element)v.get(215)).setAttribute("multisel","-1" );
      ((Element)v.get(215)).setAttribute("incy","10" );
      ((Element)v.get(215)).setAttribute("incx","10" );
      ((Element)v.get(215)).setAttribute("colorf","#EFEFEF" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(215)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(215)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(215)).setAttribute("accion","" );
      ((Element)v.get(215)).setAttribute("sep","|" );
      ((Element)v.get(215)).setAttribute("pixelsborde","2" );
      ((Element)v.get(215)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(216)).setAttribute("nombre","cab1" );
      ((Element)v.get(216)).setAttribute("height","20" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(217)).setAttribute("ancho","40" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Elemento padre:217 / Elemento actual: 218   */
      v.add(doc.createTextNode("Periodo"));
      ((Element)v.get(217)).appendChild((Text)v.get(218));

      /* Termina nodo Texto:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(219)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(219)).setAttribute("ancho","60" );
      ((Element)v.get(216)).appendChild((Element)v.get(219));

      /* Elemento padre:219 / Elemento actual: 220   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(219)).appendChild((Text)v.get(220));

      /* Termina nodo Texto:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(221)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(221)).setAttribute("ancho","440" );
      ((Element)v.get(216)).appendChild((Element)v.get(221));

      /* Elemento padre:221 / Elemento actual: 222   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(221)).appendChild((Text)v.get(222));

      /* Termina nodo Texto:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(223)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(223)).setAttribute("ancho","440" );
      ((Element)v.get(216)).appendChild((Element)v.get(223));

      /* Elemento padre:223 / Elemento actual: 224   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(223)).appendChild((Text)v.get(224));

      /* Termina nodo Texto:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(225)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(225)).setAttribute("ancho","440" );
      ((Element)v.get(216)).appendChild((Element)v.get(225));

      /* Elemento padre:225 / Elemento actual: 226   */
      v.add(doc.createTextNode("FechaInicio"));
      ((Element)v.get(225)).appendChild((Text)v.get(226));

      /* Termina nodo Texto:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(227)).setAttribute("ancho","440" );
      ((Element)v.get(216)).appendChild((Element)v.get(227));

      /* Elemento padre:227 / Elemento actual: 228   */
      v.add(doc.createTextNode("FechaFin"));
      ((Element)v.get(227)).appendChild((Text)v.get(228));

      /* Termina nodo Texto:228   */
      /* Termina nodo:227   */
      /* Termina nodo:216   */

      /* Empieza nodo:229 / Elemento padre: 215   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(229)).setAttribute("ancho","590" );
      ((Element)v.get(229)).setAttribute("filas","1" );
      ((Element)v.get(229)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(215)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("ancho","40" );
      ((Element)v.get(230)).setAttribute("caracteres","20" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 229   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("ancho","60" );
      ((Element)v.get(231)).setAttribute("caracteres","20" );
      ((Element)v.get(229)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 229   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(232)).setAttribute("ancho","440" );
      ((Element)v.get(232)).setAttribute("caracteres","30" );
      ((Element)v.get(229)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 229   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(233)).setAttribute("ancho","440" );
      ((Element)v.get(233)).setAttribute("caracteres","30" );
      ((Element)v.get(229)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */

      /* Empieza nodo:234 / Elemento padre: 229   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(234)).setAttribute("ancho","440" );
      ((Element)v.get(234)).setAttribute("caracteres","30" );
      ((Element)v.get(229)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 229   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(235)).setAttribute("ancho","440" );
      ((Element)v.get(235)).setAttribute("caracteres","30" );
      ((Element)v.get(229)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:229   */

      /* Empieza nodo:236 / Elemento padre: 215   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(215)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:237 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(237)).setAttribute("nombre","capaRegion" );
      ((Element)v.get(237)).setAttribute("alto","3" );
      ((Element)v.get(237)).setAttribute("ancho","624" );
      ((Element)v.get(237)).setAttribute("colorf","" );
      ((Element)v.get(237)).setAttribute("borde","0" );
      ((Element)v.get(237)).setAttribute("imagenf","" );
      ((Element)v.get(237)).setAttribute("repeat","" );
      ((Element)v.get(237)).setAttribute("padding","" );
      ((Element)v.get(237)).setAttribute("visibilidad","visible" );
      ((Element)v.get(237)).setAttribute("contravsb","" );
      ((Element)v.get(237)).setAttribute("x","0" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(237)).setAttribute("y","165" );
      ((Element)v.get(237)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(238)).setAttribute("seleccion","boton" );
      ((Element)v.get(238)).setAttribute("nombre","lstRegion" );
      ((Element)v.get(238)).setAttribute("x","12" );
      ((Element)v.get(238)).setAttribute("y","10" );
      ((Element)v.get(238)).setAttribute("ancho","600" );
      ((Element)v.get(238)).setAttribute("alto","3" );
      ((Element)v.get(238)).setAttribute("multisel","-1" );
      ((Element)v.get(238)).setAttribute("incy","10" );
      ((Element)v.get(238)).setAttribute("incx","10" );
      ((Element)v.get(238)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(238)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(238)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(238)).setAttribute("accion","" );
      ((Element)v.get(238)).setAttribute("sep","|" );
      ((Element)v.get(238)).setAttribute("pixelsborde","2" );
      ((Element)v.get(238)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(239)).setAttribute("nombre","cab1" );
      ((Element)v.get(239)).setAttribute("height","20" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(240)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(240)).setAttribute("ancho","40" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Elemento padre:240 / Elemento actual: 241   */
      v.add(doc.createTextNode("Region"));
      ((Element)v.get(240)).appendChild((Text)v.get(241));

      /* Termina nodo Texto:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 239   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(242)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(242)).setAttribute("ancho","60" );
      ((Element)v.get(239)).appendChild((Element)v.get(242));

      /* Elemento padre:242 / Elemento actual: 243   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(242)).appendChild((Text)v.get(243));

      /* Termina nodo Texto:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 239   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(244)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(244)).setAttribute("ancho","440" );
      ((Element)v.get(239)).appendChild((Element)v.get(244));

      /* Elemento padre:244 / Elemento actual: 245   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(244)).appendChild((Text)v.get(245));

      /* Termina nodo Texto:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 239   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(246)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(246)).setAttribute("ancho","440" );
      ((Element)v.get(239)).appendChild((Element)v.get(246));

      /* Elemento padre:246 / Elemento actual: 247   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(246)).appendChild((Text)v.get(247));

      /* Termina nodo Texto:247   */
      /* Termina nodo:246   */
      /* Termina nodo:239   */

      /* Empieza nodo:248 / Elemento padre: 238   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(248)).setAttribute("ancho","590" );
      ((Element)v.get(248)).setAttribute("filas","1" );
      ((Element)v.get(248)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(238)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(249)).setAttribute("ancho","40" );
      ((Element)v.get(249)).setAttribute("caracteres","20" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(250)).setAttribute("ancho","60" );
      ((Element)v.get(250)).setAttribute("caracteres","20" );
      ((Element)v.get(248)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(251)).setAttribute("ancho","440" );
      ((Element)v.get(251)).setAttribute("caracteres","30" );
      ((Element)v.get(248)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("ancho","440" );
      ((Element)v.get(252)).setAttribute("caracteres","30" );
      ((Element)v.get(248)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:248   */

      /* Empieza nodo:253 / Elemento padre: 238   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(238)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:254 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(254)).setAttribute("nombre","capaZona" );
      ((Element)v.get(254)).setAttribute("alto","3" );
      ((Element)v.get(254)).setAttribute("ancho","624" );
      ((Element)v.get(254)).setAttribute("colorf","" );
      ((Element)v.get(254)).setAttribute("borde","0" );
      ((Element)v.get(254)).setAttribute("imagenf","" );
      ((Element)v.get(254)).setAttribute("repeat","" );
      ((Element)v.get(254)).setAttribute("padding","" );
      ((Element)v.get(254)).setAttribute("visibilidad","visible" );
      ((Element)v.get(254)).setAttribute("contravsb","" );
      ((Element)v.get(254)).setAttribute("x","0" );
      ((Element)v.get(254)).setAttribute("y","165" );
      ((Element)v.get(254)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(255)).setAttribute("seleccion","boton" );
      ((Element)v.get(255)).setAttribute("nombre","lstZona" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(255)).setAttribute("x","12" );
      ((Element)v.get(255)).setAttribute("y","10" );
      ((Element)v.get(255)).setAttribute("ancho","600" );
      ((Element)v.get(255)).setAttribute("alto","3" );
      ((Element)v.get(255)).setAttribute("multisel","-1" );
      ((Element)v.get(255)).setAttribute("incy","10" );
      ((Element)v.get(255)).setAttribute("incx","10" );
      ((Element)v.get(255)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(255)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(255)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(255)).setAttribute("accion","" );
      ((Element)v.get(255)).setAttribute("sep","|" );
      ((Element)v.get(255)).setAttribute("pixelsborde","2" );
      ((Element)v.get(255)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(256)).setAttribute("nombre","cab1" );
      ((Element)v.get(256)).setAttribute("height","20" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(257)).setAttribute("ancho","40" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Elemento padre:257 / Elemento actual: 258   */
      v.add(doc.createTextNode("Zona"));
      ((Element)v.get(257)).appendChild((Text)v.get(258));

      /* Termina nodo Texto:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(259)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(259)).setAttribute("ancho","40" );
      ((Element)v.get(256)).appendChild((Element)v.get(259));

      /* Elemento padre:259 / Elemento actual: 260   */
      v.add(doc.createTextNode("Region"));
      ((Element)v.get(259)).appendChild((Text)v.get(260));

      /* Termina nodo Texto:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(261)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(261)).setAttribute("ancho","60" );
      ((Element)v.get(256)).appendChild((Element)v.get(261));

      /* Elemento padre:261 / Elemento actual: 262   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(261)).appendChild((Text)v.get(262));

      /* Termina nodo Texto:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(263)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(263)).setAttribute("ancho","440" );
      ((Element)v.get(256)).appendChild((Element)v.get(263));

      /* Elemento padre:263 / Elemento actual: 264   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(263)).appendChild((Text)v.get(264));

      /* Termina nodo Texto:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(265)).setAttribute("ancho","440" );
      ((Element)v.get(256)).appendChild((Element)v.get(265));

      /* Elemento padre:265 / Elemento actual: 266   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(265)).appendChild((Text)v.get(266));

      /* Termina nodo Texto:266   */
      /* Termina nodo:265   */
      /* Termina nodo:256   */

      /* Empieza nodo:267 / Elemento padre: 255   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(267)).setAttribute("ancho","590" );
      ((Element)v.get(267)).setAttribute("filas","1" );
      ((Element)v.get(267)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(255)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("ancho","40" );
      ((Element)v.get(268)).setAttribute("caracteres","20" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("ancho","60" );
      ((Element)v.get(269)).setAttribute("caracteres","20" );
      ((Element)v.get(267)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("ancho","440" );
      ((Element)v.get(270)).setAttribute("caracteres","30" );
      ((Element)v.get(267)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(271)).setAttribute("ancho","440" );
      ((Element)v.get(271)).setAttribute("caracteres","30" );
      ((Element)v.get(267)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("ancho","440" );
      ((Element)v.get(272)).setAttribute("caracteres","30" );
      ((Element)v.get(267)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:267   */

      /* Empieza nodo:273 / Elemento padre: 255   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(255)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:274 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(274)).setAttribute("nombre","capaTipoSolicitud" );
      ((Element)v.get(274)).setAttribute("alto","3" );
      ((Element)v.get(274)).setAttribute("ancho","624" );
      ((Element)v.get(274)).setAttribute("colorf","" );
      ((Element)v.get(274)).setAttribute("borde","0" );
      ((Element)v.get(274)).setAttribute("imagenf","" );
      ((Element)v.get(274)).setAttribute("repeat","" );
      ((Element)v.get(274)).setAttribute("padding","" );
      ((Element)v.get(274)).setAttribute("visibilidad","visible" );
      ((Element)v.get(274)).setAttribute("contravsb","" );
      ((Element)v.get(274)).setAttribute("x","0" );
      ((Element)v.get(274)).setAttribute("y","165" );
      ((Element)v.get(274)).setAttribute("zindex","" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(10)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(275)).setAttribute("seleccion","boton" );
      ((Element)v.get(275)).setAttribute("nombre","lstTipoSoli" );
      ((Element)v.get(275)).setAttribute("x","12" );
      ((Element)v.get(275)).setAttribute("y","10" );
      ((Element)v.get(275)).setAttribute("ancho","600" );
      ((Element)v.get(275)).setAttribute("alto","3" );
      ((Element)v.get(275)).setAttribute("multisel","-1" );
      ((Element)v.get(275)).setAttribute("incy","10" );
      ((Element)v.get(275)).setAttribute("incx","10" );
      ((Element)v.get(275)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(275)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(275)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(275)).setAttribute("accion","" );
      ((Element)v.get(275)).setAttribute("sep","|" );
      ((Element)v.get(275)).setAttribute("pixelsborde","2" );
      ((Element)v.get(275)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(276)).setAttribute("nombre","cab1" );
      ((Element)v.get(276)).setAttribute("height","20" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(277)).setAttribute("ancho","40" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));

      /* Elemento padre:277 / Elemento actual: 278   */
      v.add(doc.createTextNode("TipoSoli"));
      ((Element)v.get(277)).appendChild((Text)v.get(278));

      /* Termina nodo Texto:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(279)).setAttribute("ancho","40" );
      ((Element)v.get(276)).appendChild((Element)v.get(279));

      /* Elemento padre:279 / Elemento actual: 280   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(279)).appendChild((Text)v.get(280));

      /* Termina nodo Texto:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:281 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(281)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(281)).setAttribute("ancho","60" );
      ((Element)v.get(276)).appendChild((Element)v.get(281));

      /* Elemento padre:281 / Elemento actual: 282   */
      v.add(doc.createTextNode("Acceso"));
      ((Element)v.get(281)).appendChild((Text)v.get(282));

      /* Termina nodo Texto:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(283)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(283)).setAttribute("ancho","440" );
      ((Element)v.get(276)).appendChild((Element)v.get(283));

      /* Elemento padre:283 / Elemento actual: 284   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(283)).appendChild((Text)v.get(284));

      /* Termina nodo Texto:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 276   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(285)).setAttribute("ancho","440" );
      ((Element)v.get(276)).appendChild((Element)v.get(285));

      /* Elemento padre:285 / Elemento actual: 286   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(285)).appendChild((Text)v.get(286));

      /* Termina nodo Texto:286   */
      /* Termina nodo:285   */
      /* Termina nodo:276   */

      /* Empieza nodo:287 / Elemento padre: 275   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(287)).setAttribute("ancho","590" );
      ((Element)v.get(287)).setAttribute("filas","1" );
      ((Element)v.get(287)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(275)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(288)).setAttribute("ancho","40" );
      ((Element)v.get(288)).setAttribute("caracteres","20" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(289)).setAttribute("ancho","60" );
      ((Element)v.get(289)).setAttribute("caracteres","20" );
      ((Element)v.get(287)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(290)).setAttribute("ancho","440" );
      ((Element)v.get(290)).setAttribute("caracteres","30" );
      ((Element)v.get(287)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(291)).setAttribute("ancho","440" );
      ((Element)v.get(291)).setAttribute("caracteres","30" );
      ((Element)v.get(287)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("ancho","440" );
      ((Element)v.get(292)).setAttribute("caracteres","30" );
      ((Element)v.get(287)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:287   */

      /* Empieza nodo:293 / Elemento padre: 275   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(275)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:275   */
      /* Termina nodo:274   */
      /* Termina nodo:10   */


   }

}

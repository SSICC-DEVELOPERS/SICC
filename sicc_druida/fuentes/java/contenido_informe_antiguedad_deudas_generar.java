
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_informe_antiguedad_deudas_generar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_informe_antiguedad_deudas_generar" );
      ((Element)v.get(0)).setAttribute("cod","0843" );
      ((Element)v.get(0)).setAttribute("titulo","Generar informe antigüedad de deudas" );
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
      v.add(doc.createTextNode("\r   \r   \r   function loadPag(){\r      configurarMenuSecundario('Formulario');\r      focaliza('Formulario.cbMarca');\r   }\r\r    function quitarItemVacio(elemento){\r      var elementoADevolver = new Array();\r     \r      for(var k=0;k<elemento.length;k++) {\r          if (elemento[k] != ''){                            \r             elementoADevolver[elementoADevolver.length] = elemento[k];\r          }\r      }\r         \r      return elementoADevolver;\r      \r   }\r   function generar(){\r       if(sicc_validaciones_generales()){\r         /*recolectarParametros();\r         set('Formulario.conectorAction', 'CCCAntiguedadDeudas');           \r         set('Formulario.accion', 'generar');\r         enviaSICC('Formulario');*/\r         var a = new Object();\r         a.accion = 'generar';\r         a.marca = get('Formulario.cbMarca');\r         a.canal = get('Formulario.cbCanal');\r         a.marcaDesc = get('Formulario.cbMarca', 'T');\r         a.canalDesc = get('Formulario.cbCanal', 'T');\r         a.region = quitarItemVacio(get('Formulario.cbRegion'));\r         a.zona = quitarItemVacio(get('Formulario.cbZona'));\r         a.seccion = quitarItemVacio(get('Formulario.cbSeccion'));\r 	     a.regionDesc = quitarItemVacio(get('Formulario.cbRegion', 'T'));\r         a.zonaDesc = quitarItemVacio(get('Formulario.cbZona', 'T'));\r         a.seccionDesc = quitarItemVacio(get('Formulario.cbSeccion', 'T'));\r         a.territorioDesde = quitarItemVacio(get('Formulario.txtTerritorioDesde'));\r         a.territorioHasta = quitarItemVacio(get('Formulario.txtTerritorioHasta'));\r         a.vista = get('Formulario.cbVista');         \r         mostrarModalSICC('CCCAntiguedadDeudas','generar', a);  \r      }\r   }\r\r   function cambioMarcaCanal(){\r         \r     opcionesRegion = new Array();     \r     set_combo('Formulario.cbRegion',opcionesRegion);        \r     tipoM1 = get('Formulario.cbMarca','V');\r     tipoC1 = get('Formulario.cbCanal','V');\r     combo_add('Formulario.cbRegion', '', '');\r\r     for(var k=0;k<lstRegion.datos.longitud;k++) {\r        for(var y=0;y<tipoM1.length;y++){\r          for(var x=0;x<tipoC1.length;x++){\r             if ((lstRegion.datos.ij(k,2) == tipoM1[y])&&\r                 (lstRegion.datos.ij(k,3) == tipoC1[x])){ 			 \r                combo_add('Formulario.cbRegion',lstRegion.datos.ij(k,0),lstRegion.datos.ij(k,1));\r      \r             }\r           }\r        }\r    }\r    cambioRegionMarcaCanal();\r  } \r   /*\r   function cambioRegionMarcaCanal(){\r         \r     opcionesNZona = new Array();     \r     set_combo('Formulario.cbZona',opcionesNZona);        \r     tipoM = get('Formulario.cbMarca','V');\r     tipoC = get('Formulario.cbCanal','V');\r     tipoR = get('Formulario.cbRegion','V');          \r     combo_add('Formulario.cbZona', '', '');\r       \r     for(var k=0;k<lstZona.datos.longitud;k++) {\r        for(var y=0;y<tipoM.length;y++){\r          for(var x=0;x<tipoC.length;x++){\r            for(var z=0;z<tipoR.length;z++){              \r               if ((lstZona.datos.ij(k,3) == tipoM[y])&&\r                   (lstZona.datos.ij(k,4) == tipoC[x])&&\r                   (lstZona.datos.ij(k,1) == tipoR[z])){\r                  combo_add('Formulario.cbZona',lstZona.datos.ij(k,0),lstZona.datos.ij(k,2));\r        \r               }\r             }\r           }\r        }\r    }  \r  }\r  */\r    function cambioRegionMarcaCanal(){\r    \r    opciones = new Array();\r    set_combo('Formulario.cbZona',opciones);\r    set_combo('Formulario.cbSeccion',opciones);\r        \r    combo_add('Formulario.cbZona', '', '');\r	combo_add('Formulario.cbSeccion', '', '');\r\r    var regiones = quitarItemVacio(get('Formulario.cbRegion'));\r    	var pais = get('Formulario.pais');\r    var regionConc = new String();\r    \r    for(i=0;i<regiones.length;i++){\r        regionConc += regiones[i] + \"x\";\r    }\r         \r    regionConc = regionConc.substring(0, regionConc.length-1);\r\r    \r    var arr = new Array();\r    arr[arr.length] = ['cadena', regionConc];\r    arr[arr.length] = ['oidPais', pais]\r    \r    if(regionConc != ''){\r        recargaCombo(\"Formulario.cbZona\", \"REPRecargaZonas\", \"es.indra.sicc.util.DTOString\",arr);\r    }     \r    \r  }\r\r  function recolectarParametros(){\r      set('Formulario.marca',get('Formulario.cbMarca'));\r      set('Formulario.canal',get('Formulario.cbCanal'));\r      set('Formulario.marcaDesc',get('Formulario.cbMarca', 'T'));\r      set('Formulario.canalDesc',get('Formulario.cbCanal', 'T'));\r      set('Formulario.region',get('Formulario.cbRegion'));\r      set('Formulario.zona',get('Formulario.cbZona'));\r      set('Formulario.seccion',get('Formulario.cbSeccion'));\r      set('Formulario.territorioDesde',get('Formulario.txtTerritorioDesde'));\r      set('Formulario.territorioHasta',get('Formulario.txtTerritorioHasta'));\r      set('Formulario.vista',get('Formulario.cbVista'));\r  }\r        function arrayComponentes(){\r              var arr = new Array();               \r              arr[arr.length]= new Array(\"cbMarca\",\"\");\r              arr[arr.length]= new Array(\"cbCanal\",\"\");              \r              arr[arr.length]= new Array(\"cbRegion\",\"\");\r              arr[arr.length]= new Array(\"cbZona\",\"\");\r              arr[arr.length]= new Array(\"cbSeccion\",\"\");\r              arr[arr.length]= new Array(\"txtTerritorioDesde\",\"\");\r              arr[arr.length]= new Array(\"txtTerritorioHasta\",\"\");\r	      arr[arr.length]= new Array(\"cbVista\",\"\");\r              \r              return arr;\r          }\r          function tabGenerico(nombreComp, tipotab){       \r            var arr = arrayComponentes();\r            var tabular = false;\r            var nombreFormulario = getFormularioSICC();\r            var j = 0;\r            var k = arr.length;\r            if (tipotab != \"sh\") {\r                j = j-1;                \r                k = k-1;\r            }\r\r            while(j<k){\r                var t;\r                if(tipotab == \"sh\"){\r                  k--;\r                  t = k;\r                } else{\r                  j++;\r                  t = j;                  \r                }\r                  \r                var nombre = arr[t][0];\r                var tipo = arr[t][1];\r                if (tabular==false){\r                  if (nombreComp==nombre){\r                      tabular=true;\r                      if (tipotab == \"sh\"){\r                        if (k==0) k= arr.length;\r                      } else {\r                        if ((j+1)==arr.length)  j = -1;\r                      }\r                  }                \r                } else {\r                  try {\r                    var name = nombreFormulario+\".\"+nombre;\r                    if (tipo==\"BOTONXY\"){\r                       focalizaBotonHTML_XY(nombre);\r                    } else if (tipo==\"BOTON\") {\r                       focalizaBotonHTML(\"botonContenido\",nombre)\r                    } else {\r                       focaliza(name);\r                    }\r                    return;\r                  } catch (e) {\r                  }\r                }\r            }\r          } \r   function cambioCanal(){\r    cambioMarcaCanal();\r  }    \r   function fLimpiar(){\r      var aCombo = new Array(new Array(\"\",\"\"));\r      set_combo('Formulario.cbRegion', aCombo, []);\r      set_combo('Formulario.cbZona', aCombo, []);\r      set_combo('Formulario.cbSeccion', aCombo, []);\r\r      focaliza('Formulario.cbMarca');\r   }\r\r   function cambioZona(){\r     /*opciones = new Array();\r     set_combo('Formulario.cbSeccion',opciones);                      \r     \r     var zona = get('Formulario.cbZona','V');\r     combo_add('Formulario.cbSeccion', '', '');\r     \r     for(var k=0;k<lstSecciones.datos.longitud;k++) {\r        for(var y=0;y<zona.length;y++){\r           if (lstSecciones.datos.ij(k,0) == zona[y]){ 			 \r              combo_add('Formulario.cbSeccion',lstSecciones.datos.ij(k,1),lstSecciones.datos.ij(k,2));\r           }\r        }\r     }*/\r\r     opciones = new Array();\r     set_combo('Formulario.cbSeccion',opciones);\r        \r     combo_add('Formulario.cbSeccion', '', '');\r     var zonas = quitarItemVacio(get('Formulario.cbZona'));\r     	 var pais = get('Formulario.pais');\r     var zonaConc = new String();\r    \r     for(i=0;i<zonas.length;i++){\r        zonaConc += zonas[i] + \"x\";\r     }\r         \r     zonaConc = zonaConc.substring(0, zonaConc.length-1);\r\r     var arr = new Array();\r     arr[arr.length] = ['cadena', zonaConc];\r     arr[arr.length] = ['oidPais', pais]\r    \r     if(zonaConc != ''){\r        recargaCombo(\"Formulario.cbSeccion\", \"REPRecargaSecciones\", \"es.indra.sicc.util.DTOString\",arr);\r     }  \r   }\r   \r   function seteaMarcaCanal(){\r     \r     if(get('Formulario.seteaMarcaCanal') == 'true'){\r       var marca = get('Formulario.marca');\r       var canal = get('Formulario.canal');\r       \r       iSeleccionado = new Array(); \r       iSeleccionado[0] = marca;\r       set('Formulario.cbMarca',iSeleccionado);\r       \r       iSeleccionado2 = new Array(); \r       iSeleccionado2[0] = canal;\r       set('Formulario.cbCanal',iSeleccionado2);\r     }\r \r   }\r   \r   function setearPais(){\r      var pais = get('Formulario.pais');\r      \r      iSeleccionado = new Array(); \r      iSeleccionado[0] = pais;\r      set('Formulario.cbPais',iSeleccionado);\r   }\r   \r   \r"));
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
      ((Element)v.get(9)).setAttribute("name","cbRegion" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","109" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbVista" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","2647" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:6   */

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
      ((Element)v.get(13)).setAttribute("valor","CCCAntiguedadDeudas" );
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
      ((Element)v.get(19)).setAttribute("nombre","marca" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","canal" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","region" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","zona" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","seccion" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","territorioDesde" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","territorioHasta" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","marcaDesc" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","canalDesc" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","vista" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","cargaUA" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 11   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(30)).setAttribute("nombre","capa1" );
      ((Element)v.get(11)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("table"));
      ((Element)v.get(31)).setAttribute("width","100%" );
      ((Element)v.get(31)).setAttribute("border","0" );
      ((Element)v.get(31)).setAttribute("cellspacing","0" );
      ((Element)v.get(31)).setAttribute("cellpadding","0" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).setAttribute("width","12" );
      ((Element)v.get(33)).setAttribute("align","center" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(34)).setAttribute("src","b.gif" );
      ((Element)v.get(34)).setAttribute("width","12" );
      ((Element)v.get(34)).setAttribute("height","12" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("width","750" );
      ((Element)v.get(32)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("width","12" );
      ((Element)v.get(32)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).setAttribute("width","12" );
      ((Element)v.get(38)).setAttribute("height","1" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:32   */

      /* Empieza nodo:39 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(44)).setAttribute("class","legend" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(45)).setAttribute("nombre","lblCriteriosSeleccion" );
      ((Element)v.get(45)).setAttribute("alto","13" );
      ((Element)v.get(45)).setAttribute("filas","1" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(45)).setAttribute("id","legend" );
      ((Element)v.get(45)).setAttribute("cod","00275" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("table"));
      ((Element)v.get(46)).setAttribute("width","100%" );
      ((Element)v.get(46)).setAttribute("border","0" );
      ((Element)v.get(46)).setAttribute("align","center" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).setAttribute("cellspacing","0" );
      ((Element)v.get(46)).setAttribute("cellpadding","0" );
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(49)).setAttribute("width","100%" );
      ((Element)v.get(49)).setAttribute("border","0" );
      ((Element)v.get(49)).setAttribute("align","left" );
      ((Element)v.get(49)).setAttribute("cellspacing","0" );
      ((Element)v.get(49)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("colspan","4" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","8" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:53 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","8" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(57)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(57)).setAttribute("alto","13" );
      ((Element)v.get(57)).setAttribute("filas","1" );
      ((Element)v.get(57)).setAttribute("id","datosTitle" );
      ((Element)v.get(57)).setAttribute("cod","6" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","25" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(61)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(61)).setAttribute("alto","13" );
      ((Element)v.get(61)).setAttribute("filas","1" );
      ((Element)v.get(61)).setAttribute("id","datosTitle" );
      ((Element)v.get(61)).setAttribute("cod","7" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("width","100%" );
      ((Element)v.get(53)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:53   */

      /* Empieza nodo:64 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(64));

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
      ((Element)v.get(67)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(64)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(68)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(68)).setAttribute("size","1" );
      ((Element)v.get(68)).setAttribute("multiple","N" );
      ((Element)v.get(68)).setAttribute("valorinicial","" );
      ((Element)v.get(68)).setAttribute("textoinicial","" );
      ((Element)v.get(68)).setAttribute("id","datosCampos" );
      ((Element)v.get(68)).setAttribute("req","S" );
      ((Element)v.get(68)).setAttribute("onchange","cambioMarcaCanal();" );
      ((Element)v.get(68)).setAttribute("ontab","tabGenerico('cbMarca');" );
      ((Element)v.get(68)).setAttribute("onshtab","tabGenerico('cbMarca','sh');" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:70 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","25" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(64)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(73)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(73)).setAttribute("size","1" );
      ((Element)v.get(73)).setAttribute("multiple","N" );
      ((Element)v.get(73)).setAttribute("valorinicial","" );
      ((Element)v.get(73)).setAttribute("textoinicial","" );
      ((Element)v.get(73)).setAttribute("id","datosCampos" );
      ((Element)v.get(73)).setAttribute("req","S" );
      ((Element)v.get(73)).setAttribute("onchange","cambioCanal();" );
      ((Element)v.get(73)).setAttribute("ontab","tabGenerico('cbCanal');" );
      ((Element)v.get(73)).setAttribute("onshtab","tabGenerico('cbCanal','sh');" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:75 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","100%" );
      ((Element)v.get(64)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:64   */

      /* Empieza nodo:77 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("colspan","4" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:80 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("table"));
      ((Element)v.get(82)).setAttribute("width","100%" );
      ((Element)v.get(82)).setAttribute("border","0" );
      ((Element)v.get(82)).setAttribute("align","left" );
      ((Element)v.get(82)).setAttribute("cellspacing","0" );
      ((Element)v.get(82)).setAttribute("cellpadding","0" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

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
      ((Element)v.get(87)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(87)).setAttribute("alto","13" );
      ((Element)v.get(87)).setAttribute("filas","1" );
      ((Element)v.get(87)).setAttribute("id","datosTitle" );
      ((Element)v.get(87)).setAttribute("cod","109" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","25" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(91)).setAttribute("nombre","lblZona" );
      ((Element)v.get(91)).setAttribute("alto","13" );
      ((Element)v.get(91)).setAttribute("filas","1" );
      ((Element)v.get(91)).setAttribute("id","datosTitle" );
      ((Element)v.get(91)).setAttribute("cod","143" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(92)).setAttribute("width","100%" );
      ((Element)v.get(83)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:83   */

      /* Empieza nodo:94 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(94)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(98)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(98)).setAttribute("size","5" );
      ((Element)v.get(98)).setAttribute("multiple","S" );
      ((Element)v.get(98)).setAttribute("valorinicial","" );
      ((Element)v.get(98)).setAttribute("textoinicial","" );
      ((Element)v.get(98)).setAttribute("id","datosCampos" );
      ((Element)v.get(98)).setAttribute("req","S" );
      ((Element)v.get(98)).setAttribute("onchange","cambioRegionMarcaCanal();" );
      ((Element)v.get(98)).setAttribute("ontab","tabGenerico('cbRegion');" );
      ((Element)v.get(98)).setAttribute("onshtab","tabGenerico('cbRegion','sh');" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:100 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","25" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(102)).setAttribute("valign","bottom" );
      ((Element)v.get(94)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(103)).setAttribute("nombre","cbZona" );
      ((Element)v.get(103)).setAttribute("size","5" );
      ((Element)v.get(103)).setAttribute("multiple","S" );
      ((Element)v.get(103)).setAttribute("valorinicial","" );
      ((Element)v.get(103)).setAttribute("textoinicial","" );
      ((Element)v.get(103)).setAttribute("id","datosCampos" );
      ((Element)v.get(103)).setAttribute("req","N" );
      ((Element)v.get(103)).setAttribute("onchange","cambioZona();" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:105 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("width","100%" );
      ((Element)v.get(94)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:94   */

      /* Empieza nodo:107 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("colspan","4" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:110 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(112)).setAttribute("width","10%" );
      ((Element)v.get(112)).setAttribute("border","0" );
      ((Element)v.get(112)).setAttribute("align","left" );
      ((Element)v.get(112)).setAttribute("cellspacing","0" );
      ((Element)v.get(112)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(117)).setAttribute("nombre","lblSeccion" );
      ((Element)v.get(117)).setAttribute("alto","13" );
      ((Element)v.get(117)).setAttribute("filas","1" );
      ((Element)v.get(117)).setAttribute("id","datosTitle" );
      ((Element)v.get(117)).setAttribute("cod","112" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","25" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(121)).setAttribute("nombre","lblTerritorioDesde" );
      ((Element)v.get(121)).setAttribute("alto","13" );
      ((Element)v.get(121)).setAttribute("filas","1" );
      ((Element)v.get(121)).setAttribute("id","datosTitle" );
      ((Element)v.get(121)).setAttribute("cod","997" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("width","100%" );
      ((Element)v.get(113)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(125)).setAttribute("nombre","lblTerritorioHasta" );
      ((Element)v.get(125)).setAttribute("alto","13" );
      ((Element)v.get(125)).setAttribute("filas","1" );
      ((Element)v.get(125)).setAttribute("id","datosTitle" );
      ((Element)v.get(125)).setAttribute("cod","998" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("width","100%" );
      ((Element)v.get(113)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:113   */

      /* Empieza nodo:128 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(112)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(128)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(132)).setAttribute("nombre","cbSeccion" );
      ((Element)v.get(132)).setAttribute("size","5" );
      ((Element)v.get(132)).setAttribute("multiple","S" );
      ((Element)v.get(132)).setAttribute("valorinicial","" );
      ((Element)v.get(132)).setAttribute("textoinicial","" );
      ((Element)v.get(132)).setAttribute("id","datosCampos" );
      ((Element)v.get(132)).setAttribute("req","N" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:134 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","25" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(136)).setAttribute("valign","top" );
      ((Element)v.get(128)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(137)).setAttribute("nombre","txtTerritorioDesde" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(137)).setAttribute("size","6" );
      ((Element)v.get(137)).setAttribute("multiple","S" );
      ((Element)v.get(137)).setAttribute("valorinicial","" );
      ((Element)v.get(137)).setAttribute("textoinicial","" );
      ((Element)v.get(137)).setAttribute("id","datosCampos" );
      ((Element)v.get(137)).setAttribute("req","N" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("width","100%" );
      ((Element)v.get(128)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","8" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(140)).setAttribute("valign","top" );
      ((Element)v.get(128)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(141)).setAttribute("nombre","txtTerritorioHasta" );
      ((Element)v.get(141)).setAttribute("size","6" );
      ((Element)v.get(141)).setAttribute("multiple","S" );
      ((Element)v.get(141)).setAttribute("valorinicial","" );
      ((Element)v.get(141)).setAttribute("textoinicial","" );
      ((Element)v.get(141)).setAttribute("id","datosCampos" );
      ((Element)v.get(141)).setAttribute("req","N" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("width","100%" );
      ((Element)v.get(128)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","8" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:128   */

      /* Empieza nodo:144 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(112)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("colspan","6" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:147 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("table"));
      ((Element)v.get(149)).setAttribute("width","100%" );
      ((Element)v.get(149)).setAttribute("border","0" );
      ((Element)v.get(149)).setAttribute("align","left" );
      ((Element)v.get(149)).setAttribute("cellspacing","0" );
      ((Element)v.get(149)).setAttribute("cellpadding","0" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","8" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(154)).setAttribute("nombre","lblVista" );
      ((Element)v.get(154)).setAttribute("alto","13" );
      ((Element)v.get(154)).setAttribute("filas","1" );
      ((Element)v.get(154)).setAttribute("id","datosTitle" );
      ((Element)v.get(154)).setAttribute("cod","2647" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("width","100%" );
      ((Element)v.get(150)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:150   */

      /* Empieza nodo:157 / Elemento padre: 149   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(149)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(157)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(161)).setAttribute("nombre","cbVista" );
      ((Element)v.get(161)).setAttribute("size","1" );
      ((Element)v.get(161)).setAttribute("multiple","N" );
      ((Element)v.get(161)).setAttribute("valorinicial","1" );
      ((Element)v.get(161)).setAttribute("textoinicial","Por mes" );
      ((Element)v.get(161)).setAttribute("id","datosCampos" );
      ((Element)v.get(161)).setAttribute("req","S" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(163)).setAttribute("ID","2" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(164)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(164)).setAttribute("TIPO","STRING" );
      ((Element)v.get(164)).setAttribute("VALOR","2" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 163   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(165)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(165)).setAttribute("TIPO","STRING" );
      ((Element)v.get(165)).setAttribute("VALOR","Por período" );
      ((Element)v.get(163)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:166 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).setAttribute("width","100%" );
      ((Element)v.get(157)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","8" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:157   */

      /* Empieza nodo:168 / Elemento padre: 149   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(149)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).setAttribute("colspan","4" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","8" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:46   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:171 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:39   */

      /* Empieza nodo:173 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("table"));
      ((Element)v.get(178)).setAttribute("width","100%" );
      ((Element)v.get(178)).setAttribute("border","0" );
      ((Element)v.get(178)).setAttribute("align","center" );
      ((Element)v.get(178)).setAttribute("cellspacing","0" );
      ((Element)v.get(178)).setAttribute("cellpadding","0" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("class","botonera" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(181)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(181)).setAttribute("ID","botonContenido" );
      ((Element)v.get(181)).setAttribute("tipo","html" );
      ((Element)v.get(181)).setAttribute("accion","generar()" );
      ((Element)v.get(181)).setAttribute("estado","false" );
      ((Element)v.get(181)).setAttribute("cod","2495" );
      ((Element)v.get(181)).setAttribute("ontab","focaliza('Formulario.cbMarca');" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:182 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","8" );
      ((Element)v.get(183)).setAttribute("height","12" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:173   */

      /* Empieza nodo:184 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).setAttribute("width","12" );
      ((Element)v.get(185)).setAttribute("align","center" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","12" );
      ((Element)v.get(186)).setAttribute("height","12" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).setAttribute("width","756" );
      ((Element)v.get(184)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).setAttribute("width","12" );
      ((Element)v.get(184)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","12" );
      ((Element)v.get(190)).setAttribute("height","1" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:184   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:191 / Elemento padre: 11   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(191)).setAttribute("nombre","capaRegion" );
      ((Element)v.get(191)).setAttribute("alto","3" );
      ((Element)v.get(191)).setAttribute("ancho","624" );
      ((Element)v.get(191)).setAttribute("colorf","" );
      ((Element)v.get(191)).setAttribute("borde","0" );
      ((Element)v.get(191)).setAttribute("imagenf","" );
      ((Element)v.get(191)).setAttribute("repeat","" );
      ((Element)v.get(191)).setAttribute("padding","" );
      ((Element)v.get(191)).setAttribute("visibilidad","visible" );
      ((Element)v.get(191)).setAttribute("contravsb","" );
      ((Element)v.get(191)).setAttribute("x","0" );
      ((Element)v.get(191)).setAttribute("y","165" );
      ((Element)v.get(191)).setAttribute("zindex","" );
      ((Element)v.get(11)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(192)).setAttribute("seleccion","boton" );
      ((Element)v.get(192)).setAttribute("nombre","lstRegion" );
      ((Element)v.get(192)).setAttribute("x","12" );
      ((Element)v.get(192)).setAttribute("y","10" );
      ((Element)v.get(192)).setAttribute("ancho","600" );
      ((Element)v.get(192)).setAttribute("alto","3" );
      ((Element)v.get(192)).setAttribute("multisel","-1" );
      ((Element)v.get(192)).setAttribute("incy","10" );
      ((Element)v.get(192)).setAttribute("incx","10" );
      ((Element)v.get(192)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(192)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(192)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(192)).setAttribute("accion","" );
      ((Element)v.get(192)).setAttribute("sep","|" );
      ((Element)v.get(192)).setAttribute("pixelsborde","2" );
      ((Element)v.get(192)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(193)).setAttribute("nombre","cab1" );
      ((Element)v.get(193)).setAttribute("height","20" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(194)).setAttribute("ancho","40" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Elemento padre:194 / Elemento actual: 195   */
      v.add(doc.createTextNode("Region"));
      ((Element)v.get(194)).appendChild((Text)v.get(195));

      /* Termina nodo Texto:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(196)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(196)).setAttribute("ancho","60" );
      ((Element)v.get(193)).appendChild((Element)v.get(196));

      /* Elemento padre:196 / Elemento actual: 197   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(196)).appendChild((Text)v.get(197));

      /* Termina nodo Texto:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(198)).setAttribute("ancho","440" );
      ((Element)v.get(193)).appendChild((Element)v.get(198));

      /* Elemento padre:198 / Elemento actual: 199   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(198)).appendChild((Text)v.get(199));

      /* Termina nodo Texto:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 193   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(200)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(200)).setAttribute("ancho","440" );
      ((Element)v.get(193)).appendChild((Element)v.get(200));

      /* Elemento padre:200 / Elemento actual: 201   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(200)).appendChild((Text)v.get(201));

      /* Termina nodo Texto:201   */
      /* Termina nodo:200   */
      /* Termina nodo:193   */

      /* Empieza nodo:202 / Elemento padre: 192   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(202)).setAttribute("ancho","590" );
      ((Element)v.get(202)).setAttribute("filas","1" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(202)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(192)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(203)).setAttribute("ancho","40" );
      ((Element)v.get(203)).setAttribute("caracteres","20" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("ancho","60" );
      ((Element)v.get(204)).setAttribute("caracteres","20" );
      ((Element)v.get(202)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(205)).setAttribute("ancho","440" );
      ((Element)v.get(205)).setAttribute("caracteres","30" );
      ((Element)v.get(202)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("ancho","440" );
      ((Element)v.get(206)).setAttribute("caracteres","30" );
      ((Element)v.get(202)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:202   */

      /* Empieza nodo:207 / Elemento padre: 192   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(192)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:208 / Elemento padre: 11   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(208)).setAttribute("nombre","capaZona" );
      ((Element)v.get(208)).setAttribute("alto","3" );
      ((Element)v.get(208)).setAttribute("ancho","624" );
      ((Element)v.get(208)).setAttribute("colorf","" );
      ((Element)v.get(208)).setAttribute("borde","0" );
      ((Element)v.get(208)).setAttribute("imagenf","" );
      ((Element)v.get(208)).setAttribute("repeat","" );
      ((Element)v.get(208)).setAttribute("padding","" );
      ((Element)v.get(208)).setAttribute("visibilidad","visible" );
      ((Element)v.get(208)).setAttribute("contravsb","" );
      ((Element)v.get(208)).setAttribute("x","0" );
      ((Element)v.get(208)).setAttribute("y","165" );
      ((Element)v.get(208)).setAttribute("zindex","" );
      ((Element)v.get(11)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(209)).setAttribute("seleccion","boton" );
      ((Element)v.get(209)).setAttribute("nombre","lstZona" );
      ((Element)v.get(209)).setAttribute("x","12" );
      ((Element)v.get(209)).setAttribute("y","10" );
      ((Element)v.get(209)).setAttribute("ancho","600" );
      ((Element)v.get(209)).setAttribute("alto","3" );
      ((Element)v.get(209)).setAttribute("multisel","-1" );
      ((Element)v.get(209)).setAttribute("incy","10" );
      ((Element)v.get(209)).setAttribute("incx","10" );
      ((Element)v.get(209)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(209)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(209)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(209)).setAttribute("accion","" );
      ((Element)v.get(209)).setAttribute("sep","|" );
      ((Element)v.get(209)).setAttribute("pixelsborde","2" );
      ((Element)v.get(209)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(210)).setAttribute("nombre","cab1" );
      ((Element)v.get(210)).setAttribute("height","20" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(211)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(211)).setAttribute("ancho","40" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Elemento padre:211 / Elemento actual: 212   */
      v.add(doc.createTextNode("Zona"));
      ((Element)v.get(211)).appendChild((Text)v.get(212));

      /* Termina nodo Texto:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(213)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(213)).setAttribute("ancho","40" );
      ((Element)v.get(210)).appendChild((Element)v.get(213));

      /* Elemento padre:213 / Elemento actual: 214   */
      v.add(doc.createTextNode("Region"));
      ((Element)v.get(213)).appendChild((Text)v.get(214));

      /* Termina nodo Texto:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(215)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(215)).setAttribute("ancho","60" );
      ((Element)v.get(210)).appendChild((Element)v.get(215));

      /* Elemento padre:215 / Elemento actual: 216   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(215)).appendChild((Text)v.get(216));

      /* Termina nodo Texto:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(217)).setAttribute("ancho","440" );
      ((Element)v.get(210)).appendChild((Element)v.get(217));

      /* Elemento padre:217 / Elemento actual: 218   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(217)).appendChild((Text)v.get(218));

      /* Termina nodo Texto:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(219)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(219)).setAttribute("ancho","440" );
      ((Element)v.get(210)).appendChild((Element)v.get(219));

      /* Elemento padre:219 / Elemento actual: 220   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(219)).appendChild((Text)v.get(220));

      /* Termina nodo Texto:220   */
      /* Termina nodo:219   */
      /* Termina nodo:210   */

      /* Empieza nodo:221 / Elemento padre: 209   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(221)).setAttribute("ancho","590" );
      ((Element)v.get(221)).setAttribute("filas","1" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(221)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(209)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("ancho","40" );
      ((Element)v.get(222)).setAttribute("caracteres","20" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(223)).setAttribute("ancho","60" );
      ((Element)v.get(223)).setAttribute("caracteres","20" );
      ((Element)v.get(221)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("ancho","440" );
      ((Element)v.get(224)).setAttribute("caracteres","30" );
      ((Element)v.get(221)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(225)).setAttribute("ancho","440" );
      ((Element)v.get(225)).setAttribute("caracteres","30" );
      ((Element)v.get(221)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(226)).setAttribute("ancho","440" );
      ((Element)v.get(226)).setAttribute("caracteres","30" );
      ((Element)v.get(221)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:221   */

      /* Empieza nodo:227 / Elemento padre: 209   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(209)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:228 / Elemento padre: 11   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(228)).setAttribute("nombre","capaZona" );
      ((Element)v.get(228)).setAttribute("alto","3" );
      ((Element)v.get(228)).setAttribute("ancho","624" );
      ((Element)v.get(228)).setAttribute("colorf","" );
      ((Element)v.get(228)).setAttribute("borde","0" );
      ((Element)v.get(228)).setAttribute("imagenf","" );
      ((Element)v.get(228)).setAttribute("repeat","" );
      ((Element)v.get(228)).setAttribute("padding","" );
      ((Element)v.get(228)).setAttribute("visibilidad","visible" );
      ((Element)v.get(228)).setAttribute("contravsb","" );
      ((Element)v.get(228)).setAttribute("x","0" );
      ((Element)v.get(228)).setAttribute("y","165" );
      ((Element)v.get(228)).setAttribute("zindex","" );
      ((Element)v.get(11)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(229)).setAttribute("seleccion","boton" );
      ((Element)v.get(229)).setAttribute("nombre","lstSecciones" );
      ((Element)v.get(229)).setAttribute("x","12" );
      ((Element)v.get(229)).setAttribute("y","10" );
      ((Element)v.get(229)).setAttribute("ancho","600" );
      ((Element)v.get(229)).setAttribute("alto","3" );
      ((Element)v.get(229)).setAttribute("multisel","-1" );
      ((Element)v.get(229)).setAttribute("incy","10" );
      ((Element)v.get(229)).setAttribute("incx","10" );
      ((Element)v.get(229)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(229)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(229)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(229)).setAttribute("accion","" );
      ((Element)v.get(229)).setAttribute("sep","|" );
      ((Element)v.get(229)).setAttribute("pixelsborde","2" );
      ((Element)v.get(229)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(230)).setAttribute("nombre","cab1" );
      ((Element)v.get(230)).setAttribute("height","20" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(231)).setAttribute("ancho","40" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Elemento padre:231 / Elemento actual: 232   */
      v.add(doc.createTextNode("Zona"));
      ((Element)v.get(231)).appendChild((Text)v.get(232));

      /* Termina nodo Texto:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(233)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(233)).setAttribute("ancho","40" );
      ((Element)v.get(230)).appendChild((Element)v.get(233));

      /* Elemento padre:233 / Elemento actual: 234   */
      v.add(doc.createTextNode("Seccion"));
      ((Element)v.get(233)).appendChild((Text)v.get(234));

      /* Termina nodo Texto:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(235)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(235)).setAttribute("ancho","60" );
      ((Element)v.get(230)).appendChild((Element)v.get(235));

      /* Elemento padre:235 / Elemento actual: 236   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(235)).appendChild((Text)v.get(236));

      /* Termina nodo Texto:236   */
      /* Termina nodo:235   */
      /* Termina nodo:230   */

      /* Empieza nodo:237 / Elemento padre: 229   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(237)).setAttribute("ancho","590" );
      ((Element)v.get(237)).setAttribute("filas","1" );
      ((Element)v.get(237)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(229)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(238)).setAttribute("ancho","40" );
      ((Element)v.get(238)).setAttribute("caracteres","20" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 237   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(239)).setAttribute("ancho","60" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(239)).setAttribute("caracteres","20" );
      ((Element)v.get(237)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 237   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(240)).setAttribute("ancho","440" );
      ((Element)v.get(240)).setAttribute("caracteres","30" );
      ((Element)v.get(237)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:237   */

      /* Empieza nodo:241 / Elemento padre: 229   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(229)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:11   */


   }

}

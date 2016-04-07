
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_informe_reporte_fletes_generar  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML1350(doc);
         

      getXML1440(doc);
         

      getXML1530(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_informe_reporte_fletes_generar" );
      ((Element)v.get(0)).setAttribute("cod","0840" );
      ((Element)v.get(0)).setAttribute("titulo","Generar Informe Reporte de Fletes" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Generar Informe Reporte de Fletes" );
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
      v.add(doc.createTextNode("\r   \r   \r   function onLoad(){\r      configurarMenuSecundario('Formulario');\r      cargarTipos();\r      focaliza('Formulario.cbMarca');\r   }\r\r     function quitarItemVacio(elemento){\r      var elementoADevolver = new Array();\r     \r      for(var k=0;k<elemento.length;k++) {\r          if (elemento[k] != ''){                            \r             elementoADevolver[elementoADevolver.length] = elemento[k];\r          }\r      }\r         \r      return elementoADevolver;\r      \r   }\r\r   function generar(){\r      \r      if(sicc_validaciones_generales()){\r          /*recolectarParametros();\r          set('Formulario.conectorAction', 'PEDInformeReporteFletes');           \r          set('Formulario.accion', 'generar');\r          enviaSICC('Formulario');*/      \r          var a = new Object();\r          a.accion = 'generar';\r          a.marca= get('Formulario.cbMarca');\r          a.canal= get('Formulario.cbCanal');\r          a.accesos= quitarItemVacio(get('Formulario.cbAcceso'));\r          a.periodos= quitarItemVacio(get('Formulario.cbPeriodo'));\r          a.regiones= quitarItemVacio(get('Formulario.cbRegion'));\r          a.zonas= quitarItemVacio(get('Formulario.cbZona'));\r          a.tiposdespacho= quitarItemVacio(get('Formulario.cbTipoDespacho'));\r          a.tiposcliente = quitarItemVacio(get('Formulario.cbTipoCliente'));\r          a.subtiposcliente= quitarItemVacio(get('Formulario.cbSubtipoCliente'));\r          a.tiposclasifica= quitarItemVacio(get('Formulario.cbTipoClasificacion'));\r          a.clasificaciones= quitarItemVacio(get('Formulario.cbClasificacion'));                        \r          mostrarModalSICC('PEDInformeReporteFletes','generar', a);        \r      }\r\r   }\r  function recolectarParametros(){\r        set('Formulario.marca',get('Formulario.cbMarca')) ;\r        set('Formulario.canal',get('Formulario.cbCanal')) ;\r        set('Formulario.accesos', get('Formulario.cbAcceso'));\r        set('Formulario.periodos',get('Formulario.cbPeriodo'));\r        set('Formulario.regiones',get('Formulario.cbRegion'));\r        set('Formulario.zonas',get('Formulario.cbZona')) ;\r        set('Formulario.tiposdespacho',get('Formulario.cbTipoDespacho')) ;\r        set('Formulario.tiposcliente',get('Formulario.cbTipoCliente')) ;\r        set('Formulario.subtiposcliente',get('Formulario.cbSubtipoCliente'));\r        set('Formulario.tiposclasifica',get('Formulario.cbTipoClasificacion')) ;\r        set('Formulario.clasificaciones',get('Formulario.cbClasificacion')) ;   \r  }\r\r   function fLimpiar(){\r \r      var aCombo = new Array(new Array(\"\",\"\"));            \r      set_combo('Formulario.cbAcceso', aCombo, []);            \r      set_combo('Formulario.cbPeriodo', aCombo, []);      \r      set_combo('Formulario.cbRegion', aCombo, []); \r      set_combo('Formulario.cbZona', aCombo, []);                        \r      set_combo('Formulario.cbSubtipoCliente', aCombo, []);            \r      set_combo('Formulario.cbTipoClasificacion', aCombo, []);      \r      set_combo('Formulario.cbClasificacion', aCombo, []);         \r      \r      focaliza('Formulario.cbMarca'); \r   }\r  function cargarTipos(){\r     for(var k=0;k<lstTipo.datos.longitud;k++) {                             	 \r        combo_add('Formulario.cbTipoCliente',lstTipo.datos.ij(k,0),lstTipo.datos.ij(k,1));    \r     }  \r  }\r   function cambioCanal(){\r         \r     opciones = new Array();\r     set_combo('Formulario.cbAcceso',opciones);        \r     tipo = get('Formulario.cbCanal','V');\r     combo_add('Formulario.cbAcceso', '', '');\r       \r     for(var k=0;k<lstAcceso.datos.longitud;k++) {\r        for(var y=0;y<tipo.length;y++){\r                     if (lstAcceso.datos.ij(k,2) == tipo[y]){ 			 \r              combo_add('Formulario.cbAcceso',lstAcceso.datos.ij(k,0),lstAcceso.datos.ij(k,1));\r    \r           }\r        }\r    }\r    cambioMarcaCanal();\r  }    \r   \r   function cambioMarcaCanal(){\r         \r     tipoM = get('Formulario.cbMarca','V');\r     tipoC = get('Formulario.cbCanal','V');\r\r          if(tipoM != '' && tipoC != ''){\r       var arr = new Array();     \r	     pais   = get('Formulario.pais');\r	     idioma = get('Formulario.idioma');\r	     \r	     arr[arr.length] = [\"oidIdioma\", idioma]; \r	     arr[arr.length] = [\"oidPais\", pais]; \r	     arr[arr.length] = [\"marca\", tipoM];\r	     arr[arr.length] = [\"canal\", tipoC];\r     \r       recargaCombo(\"Formulario.cbPeriodo\",\"REPCargarPeriodos\",\"es.indra.sicc.dtos.cra.DTOPeriodo\",arr);\r       \r     } else {\r       var aCombo = new Array(new Array(\"\",\"\"));\r       set_combo('Formulario.cbPeriodo', aCombo, []); \r     }\r          \r     opcionesRegion = new Array();     \r     set_combo('Formulario.cbRegion',opcionesRegion);        \r     tipoM1 = get('Formulario.cbMarca','V');\r     tipoC1 = get('Formulario.cbCanal','V');\r     combo_add('Formulario.cbRegion', '', '');\r       \r     for(var k=0;k<lstRegion.datos.longitud;k++) {\r        for(var y=0;y<tipoM1.length;y++){\r          for(var x=0;x<tipoC1.length;x++){\r                         if ((lstRegion.datos.ij(k,2) == tipoM1[y])&&\r                 (lstRegion.datos.ij(k,3) == tipoC1[x])){ 			 \r                combo_add('Formulario.cbRegion',lstRegion.datos.ij(k,0),lstRegion.datos.ij(k,1));\r      \r             }\r           }\r        }\r    }\r    cambioRegionMarcaCanal();\r  }    \r   /*\r   function cambioRegionMarcaCanal(){\r         \r     opcionesNZona = new Array();     \r     set_combo('Formulario.cbZona',opcionesNZona);        \r     tipoM = get('Formulario.cbMarca','V');\r     tipoC = get('Formulario.cbCanal','V');\r     tipoR = get('Formulario.cbRegion','V');          \r     combo_add('Formulario.cbZona', '', '');\r       \r     for(var k=0;k<lstZona.datos.longitud;k++) {\r        for(var y=0;y<tipoM.length;y++){\r          for(var x=0;x<tipoC.length;x++){\r            for(var z=0;z<tipoR.length;z++){              \r               if ((lstZona.datos.ij(k,3) == tipoM[y])&&\r                   (lstZona.datos.ij(k,4) == tipoC[x])&&\r                   (lstZona.datos.ij(k,1) == tipoR[z])){\r                  combo_add('Formulario.cbZona',lstZona.datos.ij(k,0),lstZona.datos.ij(k,2));\r        \r               }\r             }\r           }\r        }\r    }  \r  }  \r  */\r    function cambioRegionMarcaCanal(){\r    \r    opciones = new Array();\r    set_combo('Formulario.cbZona',opciones);\r        \r    combo_add('Formulario.cbZona', '', '');\r\r    var regiones = quitarItemVacio(get('Formulario.cbRegion'));\r	  var pais = get('Formulario.pais');\r    var regionConc = new String();\r    \r    for(i=0;i<regiones.length;i++){\r        regionConc += regiones[i] + \"x\";\r    }\r         \r    regionConc = regionConc.substring(0, regionConc.length-1);\r    \r    var arr = new Array();\r    arr[arr.length] = ['cadena', regionConc];\r    arr[arr.length] = ['oidPais', pais]\r    \r    if(regionConc != ''){\r        recargaCombo(\"Formulario.cbZona\", \"REPRecargaZonas\", \"es.indra.sicc.util.DTOString\",arr);\r    }     \r  }\r\r   function cambioTipoClie(){\r         \r     opciones = new Array();\r     set_combo('Formulario.cbSubtipoCliente',opciones);        \r     tipo = get('Formulario.cbTipoCliente','V');\r     combo_add('Formulario.cbSubtipoCliente', '', '');\r       \r     for(var k=0;k<lstSubTipo.datos.longitud;k++) {\r        for(var y=0;y<tipo.length;y++){          \r           if (lstSubTipo.datos.ij(k,1) == tipo[y]){ 			 \r              combo_add('Formulario.cbSubtipoCliente',lstSubTipo.datos.ij(k,0),lstSubTipo.datos.ij(k,2));\r    \r           }\r        }\r    }\r    cambioSubTipoClie();\r  }\r   function cambioSubTipoClie(){     \r     opciones = new Array();\r     set_combo('Formulario.cbTipoClasificacion',opciones);        \r     tipo = get('Formulario.cbSubtipoCliente','V');\r     combo_add('Formulario.cbTipoClasificacion', '', '');\r       \r     for(var k=0;k<lstTipoClasi.datos.longitud;k++) {\r        for(var y=0;y<tipo.length;y++){          \r           if (lstTipoClasi.datos.ij(k,1) == tipo[y]){ 		\r              \r              combo_add('Formulario.cbTipoClasificacion',lstTipoClasi.datos.ij(k,0),lstTipoClasi.datos.ij(k,2));\r    \r           }\r        }\r    }\r    cambioTipoClasi();\r  }\r  \r   function cambioTipoClasi(){\r         \r     opciones = new Array();\r     set_combo('Formulario.cbClasificacion',opciones);        \r     tipo = get('Formulario.cbTipoClasificacion','V');\r     combo_add('Formulario.cbClasificacion', '', '');\r       \r     for(var k=0;k<lstClasi.datos.longitud;k++) {\r        for(var y=0;y<tipo.length;y++){          \r           if (lstClasi.datos.ij(k,1) == tipo[y]){ 			 \r              combo_add('Formulario.cbClasificacion',lstClasi.datos.ij(k,0),lstClasi.datos.ij(k,2));\r    \r           }\r        }\r    }    \r  }\r  \r        function arrayComponentes(){\r              var arr = new Array();               \r              arr[arr.length]= new Array(\"cbMarca\",\"\");\r              arr[arr.length]= new Array(\"cbCanal\",\"\");              \r              arr[arr.length]= new Array(\"cbAcceso\",\"\");\r              arr[arr.length]= new Array(\"cbPeriodo\",\"\");\r              arr[arr.length]= new Array(\"cbRegion\",\"\");\r              arr[arr.length]= new Array(\"cbZona\",\"\");\r              arr[arr.length]= new Array(\"cbTipoDespacho\",\"\");\r              arr[arr.length]= new Array(\"cbTipoCliente\",\"\");\r              arr[arr.length]= new Array(\"cbSubtipoCliente\",\"\");\r              arr[arr.length]= new Array(\"cbTipoClasificacion\",\"\");\r              arr[arr.length]= new Array(\"cbClasificacion\",\"\");\r              arr[arr.length]= new Array(\"btnGenerarInforme\",\"BOTON\");\r              \r              return arr;\r          }\r          function tabGenerico(nombreComp, tipotab){       \r            var arr = arrayComponentes();\r            var tabular = false;\r            var nombreFormulario = getFormularioSICC();\r            var j = 0;\r            var k = arr.length;\r            if (tipotab != \"sh\") {\r                j = j-1;                \r                k = k-1;\r            }\r\r            while(j<k){\r                var t;\r                if(tipotab == \"sh\"){\r                  k--;\r                  t = k;\r                } else{\r                  j++;\r                  t = j;                  \r                }\r                  \r                var nombre = arr[t][0];\r                var tipo = arr[t][1];\r                if (tabular==false){\r                  if (nombreComp==nombre){\r                      tabular=true;\r                      if (tipotab == \"sh\"){\r                        if (k==0) k= arr.length;\r                      } else {\r                        if ((j+1)==arr.length)  j = -1;\r                      }\r                  }                \r                } else {\r                  try {\r                    var name = nombreFormulario+\".\"+nombre;\r                    if (tipo==\"BOTONXY\"){\r                       focalizaBotonHTML_XY(nombre);\r                    } else if (tipo==\"BOTON\") {\r                       focalizaBotonHTML(\"botonContenido\",nombre)\r                    } else {\r                       focaliza(name);\r                    }\r                    return;\r                  } catch (e) {\r                  }\r                }\r            }\r          } \r   \r"));
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
      ((Element)v.get(12)).setAttribute("valor","PEDInformeReporteFletes" );
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
      ((Element)v.get(22)).setAttribute("nombre","periodos" );
      ((Element)v.get(22)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(10)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","regiones" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","zonas" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","tiposdespacho" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","tiposcliente" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","subtiposcliente" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","tiposclasifica" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","clasificaciones" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(30)).setAttribute("nombre","capa" );
      ((Element)v.get(10)).appendChild((Element)v.get(30));

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
      ((Element)v.get(46)).setAttribute("cellspacing","0" );
      ((Element)v.get(46)).setAttribute("cellpadding","0" );
   }

   private void getXML180(Document doc) {
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
      ((Element)v.get(50)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(54)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("id","datosTitle" );
      ((Element)v.get(54)).setAttribute("cod","6" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","25" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(58)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(58)).setAttribute("filas","1" );
      ((Element)v.get(58)).setAttribute("id","datosTitle" );
      ((Element)v.get(58)).setAttribute("cod","7" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("width","100%" );
      ((Element)v.get(50)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:50   */

      /* Empieza nodo:61 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(64)).setAttribute("valign","top" );
      ((Element)v.get(61)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(65)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(65)).setAttribute("onchange","cambioMarcaCanal();" );
      ((Element)v.get(65)).setAttribute("size","1" );
      ((Element)v.get(65)).setAttribute("multiple","N" );
      ((Element)v.get(65)).setAttribute("valorinicial","" );
      ((Element)v.get(65)).setAttribute("textoinicial","" );
      ((Element)v.get(65)).setAttribute("id","datosCampos" );
      ((Element)v.get(65)).setAttribute("req","S" );
      ((Element)v.get(65)).setAttribute("ontab","tabGenerico('cbMarca');" );
      ((Element)v.get(65)).setAttribute("onshtab","tabGenerico('cbMarca','sh');" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:67 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","25" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(61)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("COMBO"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(70)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(70)).setAttribute("onchange","cambioCanal();" );
      ((Element)v.get(70)).setAttribute("size","1" );
      ((Element)v.get(70)).setAttribute("multiple","N" );
      ((Element)v.get(70)).setAttribute("valorinicial","" );
      ((Element)v.get(70)).setAttribute("textoinicial","" );
      ((Element)v.get(70)).setAttribute("id","datosCampos" );
      ((Element)v.get(70)).setAttribute("req","S" );
      ((Element)v.get(70)).setAttribute("ontab","tabGenerico('cbCanal');" );
      ((Element)v.get(70)).setAttribute("onshtab","tabGenerico('cbCanal','sh');" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:72 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("width","100%" );
      ((Element)v.get(61)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","8" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:61   */

      /* Empieza nodo:74 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("colspan","4" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:77 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("table"));
      ((Element)v.get(79)).setAttribute("width","100%" );
      ((Element)v.get(79)).setAttribute("border","0" );
      ((Element)v.get(79)).setAttribute("align","left" );
      ((Element)v.get(79)).setAttribute("cellspacing","0" );
      ((Element)v.get(79)).setAttribute("cellpadding","0" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

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
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(84)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(84)).setAttribute("filas","1" );
      ((Element)v.get(84)).setAttribute("id","datosTitle" );
      ((Element)v.get(84)).setAttribute("cod","10" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","25" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(88)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(88)).setAttribute("filas","1" );
      ((Element)v.get(88)).setAttribute("id","datosTitle" );
      ((Element)v.get(88)).setAttribute("cod","276" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("width","100%" );
      ((Element)v.get(80)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:80   */

      /* Empieza nodo:91 / Elemento padre: 79   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(79)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(95)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(95)).setAttribute("size","5" );
      ((Element)v.get(95)).setAttribute("multiple","S" );
      ((Element)v.get(95)).setAttribute("valorinicial","" );
      ((Element)v.get(95)).setAttribute("textoinicial","" );
      ((Element)v.get(95)).setAttribute("id","datosCampos" );
      ((Element)v.get(95)).setAttribute("req","N" );
      ((Element)v.get(95)).setAttribute("ontab","tabGenerico('cbAcceso');" );
      ((Element)v.get(95)).setAttribute("onshtab","tabGenerico('cbAcceso','sh');" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:97 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","25" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(100)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(100)).setAttribute("size","5" );
      ((Element)v.get(100)).setAttribute("multiple","S" );
      ((Element)v.get(100)).setAttribute("valorinicial","" );
      ((Element)v.get(100)).setAttribute("textoinicial","" );
      ((Element)v.get(100)).setAttribute("id","datosCampos" );
      ((Element)v.get(100)).setAttribute("req","S" );
      ((Element)v.get(100)).setAttribute("ontab","tabGenerico('cbPeriodo');" );
      ((Element)v.get(100)).setAttribute("onshtab","tabGenerico('cbPeriodo','sh');" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:102 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("width","100%" );
      ((Element)v.get(91)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:91   */

      /* Empieza nodo:104 / Elemento padre: 79   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(79)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("colspan","4" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:107 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("table"));
      ((Element)v.get(109)).setAttribute("width","100%" );
      ((Element)v.get(109)).setAttribute("border","0" );
      ((Element)v.get(109)).setAttribute("align","left" );
      ((Element)v.get(109)).setAttribute("cellspacing","0" );
      ((Element)v.get(109)).setAttribute("cellpadding","0" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

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
      ((Element)v.get(110)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(114)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(114)).setAttribute("filas","1" );
      ((Element)v.get(114)).setAttribute("id","datosTitle" );
      ((Element)v.get(114)).setAttribute("cod","109" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(116)).setAttribute("width","25" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(118)).setAttribute("nombre","lblZona" );
      ((Element)v.get(118)).setAttribute("filas","1" );
      ((Element)v.get(118)).setAttribute("id","datosTitle" );
      ((Element)v.get(118)).setAttribute("cod","143" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("width","100%" );
      ((Element)v.get(110)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","8" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:110   */

      /* Empieza nodo:121 / Elemento padre: 109   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(109)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(121)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(125)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(125)).setAttribute("onchange","cambioRegionMarcaCanal();" );
      ((Element)v.get(125)).setAttribute("size","5" );
      ((Element)v.get(125)).setAttribute("multiple","S" );
      ((Element)v.get(125)).setAttribute("valorinicial","" );
      ((Element)v.get(125)).setAttribute("textoinicial","" );
      ((Element)v.get(125)).setAttribute("id","datosCampos" );
      ((Element)v.get(125)).setAttribute("req","N" );
      ((Element)v.get(125)).setAttribute("ontab","tabGenerico('cbRegion');" );
      ((Element)v.get(125)).setAttribute("onshtab","tabGenerico('cbRegion','sh');" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:127 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","25" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(121)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(130)).setAttribute("nombre","cbZona" );
      ((Element)v.get(130)).setAttribute("size","5" );
      ((Element)v.get(130)).setAttribute("multiple","S" );
      ((Element)v.get(130)).setAttribute("valorinicial","" );
      ((Element)v.get(130)).setAttribute("textoinicial","" );
      ((Element)v.get(130)).setAttribute("id","datosCampos" );
      ((Element)v.get(130)).setAttribute("req","N" );
      ((Element)v.get(130)).setAttribute("ontab","tabGenerico('cbZona');" );
      ((Element)v.get(130)).setAttribute("onshtab","tabGenerico('cbZona','sh');" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:132 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("width","100%" );
      ((Element)v.get(121)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:121   */

      /* Empieza nodo:134 / Elemento padre: 109   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(109)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("colspan","4" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","8" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:137 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("table"));
      ((Element)v.get(139)).setAttribute("width","100%" );
      ((Element)v.get(139)).setAttribute("border","0" );
      ((Element)v.get(139)).setAttribute("align","left" );
      ((Element)v.get(139)).setAttribute("cellspacing","0" );
      ((Element)v.get(139)).setAttribute("cellpadding","0" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(144)).setAttribute("nombre","lblTipoDespacho" );
      ((Element)v.get(144)).setAttribute("filas","1" );
      ((Element)v.get(144)).setAttribute("id","datosTitle" );
      ((Element)v.get(144)).setAttribute("cod","1000" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("width","100%" );
      ((Element)v.get(140)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:140   */

      /* Empieza nodo:147 / Elemento padre: 139   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(139)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","8" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(147)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(151)).setAttribute("nombre","cbTipoDespacho" );
      ((Element)v.get(151)).setAttribute("size","5" );
      ((Element)v.get(151)).setAttribute("multiple","S" );
      ((Element)v.get(151)).setAttribute("valorinicial","" );
      ((Element)v.get(151)).setAttribute("textoinicial","" );
      ((Element)v.get(151)).setAttribute("id","datosCampos" );
      ((Element)v.get(151)).setAttribute("req","N" );
      ((Element)v.get(151)).setAttribute("ontab","tabGenerico('cbTipoDespacho');" );
      ((Element)v.get(151)).setAttribute("onshtab","tabGenerico('cbTipoDespacho','sh');" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:153 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("width","100%" );
      ((Element)v.get(147)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","8" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:147   */

      /* Empieza nodo:155 / Elemento padre: 139   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(139)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).setAttribute("colspan","4" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","8" );
      ((Element)v.get(157)).setAttribute("height","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:158 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("table"));
      ((Element)v.get(160)).setAttribute("width","100%" );
      ((Element)v.get(160)).setAttribute("border","0" );
      ((Element)v.get(160)).setAttribute("align","left" );
      ((Element)v.get(160)).setAttribute("cellspacing","0" );
      ((Element)v.get(160)).setAttribute("cellpadding","0" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","8" );
      ((Element)v.get(163)).setAttribute("height","8" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(165)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(165)).setAttribute("filas","1" );
      ((Element)v.get(165)).setAttribute("id","datosTitle" );
      ((Element)v.get(165)).setAttribute("cod","1869" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","25" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(169)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(169)).setAttribute("filas","1" );
      ((Element)v.get(169)).setAttribute("id","datosTitle" );
      ((Element)v.get(169)).setAttribute("cod","595" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).setAttribute("width","100%" );
      ((Element)v.get(161)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","8" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:161   */

      /* Empieza nodo:172 / Elemento padre: 160   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(160)).appendChild((Element)v.get(172));

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
      ((Element)v.get(176)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(176)).setAttribute("onchange","cambioTipoClie();" );
      ((Element)v.get(176)).setAttribute("size","5" );
      ((Element)v.get(176)).setAttribute("multiple","S" );
      ((Element)v.get(176)).setAttribute("valorinicial","" );
      ((Element)v.get(176)).setAttribute("textoinicial","" );
      ((Element)v.get(176)).setAttribute("id","datosCampos" );
      ((Element)v.get(176)).setAttribute("req","N" );
      ((Element)v.get(176)).setAttribute("ontab","tabGenerico('cbTipoCliente');" );
      ((Element)v.get(176)).setAttribute("onshtab","tabGenerico('cbTipoCliente','sh');" );
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
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(181)).setAttribute("nombre","cbSubtipoCliente" );
      ((Element)v.get(181)).setAttribute("onchange","cambioSubTipoClie();" );
      ((Element)v.get(181)).setAttribute("size","5" );
      ((Element)v.get(181)).setAttribute("multiple","S" );
      ((Element)v.get(181)).setAttribute("valorinicial","" );
      ((Element)v.get(181)).setAttribute("textoinicial","" );
      ((Element)v.get(181)).setAttribute("id","datosCampos" );
      ((Element)v.get(181)).setAttribute("req","N" );
      ((Element)v.get(181)).setAttribute("ontab","tabGenerico('cbSubtipoCliente');" );
      ((Element)v.get(181)).setAttribute("onshtab","tabGenerico('cbSubtipoCliente','sh');" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:183 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).setAttribute("width","100%" );
      ((Element)v.get(172)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:172   */

      /* Empieza nodo:185 / Elemento padre: 160   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(160)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).setAttribute("colspan","4" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","8" );
      ((Element)v.get(187)).setAttribute("height","8" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:188 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("table"));
      ((Element)v.get(190)).setAttribute("width","100%" );
      ((Element)v.get(190)).setAttribute("border","0" );
      ((Element)v.get(190)).setAttribute("align","left" );
      ((Element)v.get(190)).setAttribute("cellspacing","0" );
      ((Element)v.get(190)).setAttribute("cellpadding","0" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","8" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(195)).setAttribute("nombre","lblTipoClasificacion" );
      ((Element)v.get(195)).setAttribute("filas","1" );
      ((Element)v.get(195)).setAttribute("id","datosTitle" );
      ((Element)v.get(195)).setAttribute("cod","756" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","25" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(199)).setAttribute("nombre","lblClasificacion" );
      ((Element)v.get(199)).setAttribute("filas","1" );
      ((Element)v.get(199)).setAttribute("id","datosTitle" );
      ((Element)v.get(199)).setAttribute("cod","550" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).setAttribute("width","100%" );
      ((Element)v.get(191)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:191   */

      /* Empieza nodo:202 / Elemento padre: 190   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(190)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","8" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(202)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(206)).setAttribute("nombre","cbTipoClasificacion" );
      ((Element)v.get(206)).setAttribute("onchange","cambioTipoClasi();" );
      ((Element)v.get(206)).setAttribute("size","5" );
      ((Element)v.get(206)).setAttribute("multiple","S" );
      ((Element)v.get(206)).setAttribute("valorinicial","" );
      ((Element)v.get(206)).setAttribute("textoinicial","" );
      ((Element)v.get(206)).setAttribute("id","datosCampos" );
      ((Element)v.get(206)).setAttribute("req","N" );
      ((Element)v.get(206)).setAttribute("ontab","tabGenerico('cbTipoClasificacion');" );
      ((Element)v.get(206)).setAttribute("onshtab","tabGenerico('cbTipoClasificacion','sh');" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("ROWSET"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:208 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","25" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(202)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(211)).setAttribute("nombre","cbClasificacion" );
      ((Element)v.get(211)).setAttribute("size","5" );
      ((Element)v.get(211)).setAttribute("multiple","S" );
      ((Element)v.get(211)).setAttribute("valorinicial","" );
      ((Element)v.get(211)).setAttribute("textoinicial","" );
      ((Element)v.get(211)).setAttribute("id","datosCampos" );
      ((Element)v.get(211)).setAttribute("req","N" );
      ((Element)v.get(211)).setAttribute("ontab","tabGenerico('cbClasificacion');" );
      ((Element)v.get(211)).setAttribute("onshtab","tabGenerico('cbClasificacion','sh');" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:213 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).setAttribute("width","100%" );
      ((Element)v.get(202)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","8" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:202   */

      /* Empieza nodo:215 / Elemento padre: 190   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(190)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).setAttribute("colspan","4" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(217)).setAttribute("width","8" );
      ((Element)v.get(217)).setAttribute("height","8" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:46   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:218 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:39   */

      /* Empieza nodo:220 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("table"));
      ((Element)v.get(225)).setAttribute("width","100%" );
      ((Element)v.get(225)).setAttribute("border","0" );
      ((Element)v.get(225)).setAttribute("align","center" );
      ((Element)v.get(225)).setAttribute("cellspacing","0" );
      ((Element)v.get(225)).setAttribute("cellpadding","0" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).setAttribute("class","botonera" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(228)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(228)).setAttribute("ID","botonContenido" );
      ((Element)v.get(228)).setAttribute("tipo","html" );
      ((Element)v.get(228)).setAttribute("accion","generar();" );
      ((Element)v.get(228)).setAttribute("estado","false" );
      ((Element)v.get(228)).setAttribute("cod","2495" );
      ((Element)v.get(228)).setAttribute("ontab","tabGenerico('btnGenerarInforme');" );
      ((Element)v.get(228)).setAttribute("onshtab","tabGenerico('btnGenerarInforme','sh');" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:229 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","8" );
      ((Element)v.get(230)).setAttribute("height","12" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:220   */

      /* Empieza nodo:231 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(232)).setAttribute("width","12" );
      ((Element)v.get(232)).setAttribute("align","center" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","12" );
      ((Element)v.get(233)).setAttribute("height","12" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).setAttribute("width","756" );
      ((Element)v.get(231)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).setAttribute("width","12" );
      ((Element)v.get(231)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","12" );
      ((Element)v.get(237)).setAttribute("height","1" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:231   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:238 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(238)).setAttribute("nombre","capaPeriodo" );
      ((Element)v.get(238)).setAttribute("alto","3" );
      ((Element)v.get(238)).setAttribute("ancho","624" );
      ((Element)v.get(238)).setAttribute("colorf","" );
      ((Element)v.get(238)).setAttribute("borde","0" );
      ((Element)v.get(238)).setAttribute("imagenf","" );
      ((Element)v.get(238)).setAttribute("repeat","" );
      ((Element)v.get(238)).setAttribute("padding","" );
      ((Element)v.get(238)).setAttribute("visibilidad","visible" );
      ((Element)v.get(238)).setAttribute("contravsb","" );
      ((Element)v.get(238)).setAttribute("x","0" );
      ((Element)v.get(238)).setAttribute("y","165" );
      ((Element)v.get(238)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(239)).setAttribute("seleccion","boton" );
      ((Element)v.get(239)).setAttribute("nombre","lstPeriodo" );
      ((Element)v.get(239)).setAttribute("x","12" );
      ((Element)v.get(239)).setAttribute("y","10" );
      ((Element)v.get(239)).setAttribute("ancho","600" );
      ((Element)v.get(239)).setAttribute("alto","3" );
      ((Element)v.get(239)).setAttribute("multisel","-1" );
      ((Element)v.get(239)).setAttribute("incy","10" );
      ((Element)v.get(239)).setAttribute("incx","10" );
      ((Element)v.get(239)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(239)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(239)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(239)).setAttribute("accion","" );
      ((Element)v.get(239)).setAttribute("sep","|" );
      ((Element)v.get(239)).setAttribute("pixelsborde","2" );
      ((Element)v.get(239)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(240)).setAttribute("nombre","cab1" );
      ((Element)v.get(240)).setAttribute("height","20" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(241)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(241)).setAttribute("ancho","40" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Elemento padre:241 / Elemento actual: 242   */
      v.add(doc.createTextNode("Periodo"));
      ((Element)v.get(241)).appendChild((Text)v.get(242));

      /* Termina nodo Texto:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 240   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(243)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(243)).setAttribute("ancho","60" );
      ((Element)v.get(240)).appendChild((Element)v.get(243));

      /* Elemento padre:243 / Elemento actual: 244   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(243)).appendChild((Text)v.get(244));

      /* Termina nodo Texto:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 240   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(245)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(245)).setAttribute("ancho","440" );
      ((Element)v.get(240)).appendChild((Element)v.get(245));

      /* Elemento padre:245 / Elemento actual: 246   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(245)).appendChild((Text)v.get(246));

      /* Termina nodo Texto:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 240   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(247)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(247)).setAttribute("ancho","440" );
      ((Element)v.get(240)).appendChild((Element)v.get(247));

      /* Elemento padre:247 / Elemento actual: 248   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(247)).appendChild((Text)v.get(248));

      /* Termina nodo Texto:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 240   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(249)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(249)).setAttribute("ancho","440" );
      ((Element)v.get(240)).appendChild((Element)v.get(249));

      /* Elemento padre:249 / Elemento actual: 250   */
      v.add(doc.createTextNode("FechaIncio"));
      ((Element)v.get(249)).appendChild((Text)v.get(250));

      /* Termina nodo Texto:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 240   */
      v.add(doc.createElement("COL"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(251)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(251)).setAttribute("ancho","440" );
      ((Element)v.get(240)).appendChild((Element)v.get(251));

      /* Elemento padre:251 / Elemento actual: 252   */
      v.add(doc.createTextNode("FechaFin"));
      ((Element)v.get(251)).appendChild((Text)v.get(252));

      /* Termina nodo Texto:252   */
      /* Termina nodo:251   */
      /* Termina nodo:240   */

      /* Empieza nodo:253 / Elemento padre: 239   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(253)).setAttribute("ancho","590" );
      ((Element)v.get(253)).setAttribute("filas","1" );
      ((Element)v.get(253)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(239)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(254)).setAttribute("ancho","40" );
      ((Element)v.get(254)).setAttribute("caracteres","20" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 253   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("ancho","60" );
      ((Element)v.get(255)).setAttribute("caracteres","20" );
      ((Element)v.get(253)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 253   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(256)).setAttribute("ancho","440" );
      ((Element)v.get(256)).setAttribute("caracteres","30" );
      ((Element)v.get(253)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 253   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("ancho","440" );
      ((Element)v.get(257)).setAttribute("caracteres","30" );
      ((Element)v.get(253)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 253   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(258)).setAttribute("ancho","440" );
      ((Element)v.get(258)).setAttribute("caracteres","30" );
      ((Element)v.get(253)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 253   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(259)).setAttribute("ancho","440" );
      ((Element)v.get(259)).setAttribute("caracteres","30" );
      ((Element)v.get(253)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:253   */

      /* Empieza nodo:260 / Elemento padre: 239   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(239)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:261 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(261)).setAttribute("nombre","capaRegion" );
      ((Element)v.get(261)).setAttribute("alto","3" );
      ((Element)v.get(261)).setAttribute("ancho","624" );
      ((Element)v.get(261)).setAttribute("colorf","" );
      ((Element)v.get(261)).setAttribute("borde","0" );
      ((Element)v.get(261)).setAttribute("imagenf","" );
      ((Element)v.get(261)).setAttribute("repeat","" );
      ((Element)v.get(261)).setAttribute("padding","" );
      ((Element)v.get(261)).setAttribute("visibilidad","visible" );
      ((Element)v.get(261)).setAttribute("contravsb","" );
      ((Element)v.get(261)).setAttribute("x","0" );
      ((Element)v.get(261)).setAttribute("y","165" );
      ((Element)v.get(261)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(262)).setAttribute("seleccion","boton" );
      ((Element)v.get(262)).setAttribute("nombre","lstRegion" );
      ((Element)v.get(262)).setAttribute("x","12" );
      ((Element)v.get(262)).setAttribute("y","10" );
      ((Element)v.get(262)).setAttribute("ancho","600" );
      ((Element)v.get(262)).setAttribute("alto","3" );
      ((Element)v.get(262)).setAttribute("multisel","-1" );
      ((Element)v.get(262)).setAttribute("incy","10" );
      ((Element)v.get(262)).setAttribute("incx","10" );
      ((Element)v.get(262)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(262)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(262)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(262)).setAttribute("accion","" );
      ((Element)v.get(262)).setAttribute("sep","|" );
      ((Element)v.get(262)).setAttribute("pixelsborde","2" );
      ((Element)v.get(262)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(263)).setAttribute("nombre","cab1" );
      ((Element)v.get(263)).setAttribute("height","20" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(264)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(264)).setAttribute("ancho","40" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Elemento padre:264 / Elemento actual: 265   */
      v.add(doc.createTextNode("Region"));
      ((Element)v.get(264)).appendChild((Text)v.get(265));

      /* Termina nodo Texto:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(266)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(266)).setAttribute("ancho","60" );
      ((Element)v.get(263)).appendChild((Element)v.get(266));

      /* Elemento padre:266 / Elemento actual: 267   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(266)).appendChild((Text)v.get(267));

      /* Termina nodo Texto:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(268)).setAttribute("ancho","440" );
      ((Element)v.get(263)).appendChild((Element)v.get(268));

      /* Elemento padre:268 / Elemento actual: 269   */
      v.add(doc.createTextNode("Marca"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(268)).appendChild((Text)v.get(269));

      /* Termina nodo Texto:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(270)).setAttribute("ancho","440" );
      ((Element)v.get(263)).appendChild((Element)v.get(270));

      /* Elemento padre:270 / Elemento actual: 271   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(270)).appendChild((Text)v.get(271));

      /* Termina nodo Texto:271   */
      /* Termina nodo:270   */
      /* Termina nodo:263   */

      /* Empieza nodo:272 / Elemento padre: 262   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(272)).setAttribute("ancho","590" );
      ((Element)v.get(272)).setAttribute("filas","1" );
      ((Element)v.get(272)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(262)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("ancho","40" );
      ((Element)v.get(273)).setAttribute("caracteres","20" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 272   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("ancho","60" );
      ((Element)v.get(274)).setAttribute("caracteres","20" );
      ((Element)v.get(272)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 272   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("ancho","440" );
      ((Element)v.get(275)).setAttribute("caracteres","30" );
      ((Element)v.get(272)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 272   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("ancho","440" );
      ((Element)v.get(276)).setAttribute("caracteres","30" );
      ((Element)v.get(272)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:272   */

      /* Empieza nodo:277 / Elemento padre: 262   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(262)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:278 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(278)).setAttribute("nombre","capaZona" );
      ((Element)v.get(278)).setAttribute("alto","3" );
      ((Element)v.get(278)).setAttribute("ancho","624" );
      ((Element)v.get(278)).setAttribute("colorf","" );
      ((Element)v.get(278)).setAttribute("borde","0" );
      ((Element)v.get(278)).setAttribute("imagenf","" );
      ((Element)v.get(278)).setAttribute("repeat","" );
      ((Element)v.get(278)).setAttribute("padding","" );
      ((Element)v.get(278)).setAttribute("visibilidad","visible" );
      ((Element)v.get(278)).setAttribute("contravsb","" );
      ((Element)v.get(278)).setAttribute("x","0" );
      ((Element)v.get(278)).setAttribute("y","165" );
      ((Element)v.get(278)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(279)).setAttribute("seleccion","boton" );
      ((Element)v.get(279)).setAttribute("nombre","lstZona" );
      ((Element)v.get(279)).setAttribute("x","12" );
      ((Element)v.get(279)).setAttribute("y","10" );
      ((Element)v.get(279)).setAttribute("ancho","600" );
      ((Element)v.get(279)).setAttribute("alto","3" );
      ((Element)v.get(279)).setAttribute("multisel","-1" );
      ((Element)v.get(279)).setAttribute("incy","10" );
      ((Element)v.get(279)).setAttribute("incx","10" );
      ((Element)v.get(279)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(279)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(279)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(279)).setAttribute("accion","" );
      ((Element)v.get(279)).setAttribute("sep","|" );
      ((Element)v.get(279)).setAttribute("pixelsborde","2" );
      ((Element)v.get(279)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(280)).setAttribute("nombre","cab1" );
      ((Element)v.get(280)).setAttribute("height","20" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(281)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(281)).setAttribute("ancho","40" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Elemento padre:281 / Elemento actual: 282   */
      v.add(doc.createTextNode("Zona"));
      ((Element)v.get(281)).appendChild((Text)v.get(282));

      /* Termina nodo Texto:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 280   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(283)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(283)).setAttribute("ancho","60" );
      ((Element)v.get(280)).appendChild((Element)v.get(283));

      /* Elemento padre:283 / Elemento actual: 284   */
      v.add(doc.createTextNode("Region"));
      ((Element)v.get(283)).appendChild((Text)v.get(284));

      /* Termina nodo Texto:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 280   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(285)).setAttribute("ancho","440" );
      ((Element)v.get(280)).appendChild((Element)v.get(285));

      /* Elemento padre:285 / Elemento actual: 286   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(285)).appendChild((Text)v.get(286));

      /* Termina nodo Texto:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:287 / Elemento padre: 280   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(287)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(287)).setAttribute("ancho","440" );
      ((Element)v.get(280)).appendChild((Element)v.get(287));

      /* Elemento padre:287 / Elemento actual: 288   */
      v.add(doc.createTextNode("Marca"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(287)).appendChild((Text)v.get(288));

      /* Termina nodo Texto:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:289 / Elemento padre: 280   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(289)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(289)).setAttribute("ancho","440" );
      ((Element)v.get(280)).appendChild((Element)v.get(289));

      /* Elemento padre:289 / Elemento actual: 290   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(289)).appendChild((Text)v.get(290));

      /* Termina nodo Texto:290   */
      /* Termina nodo:289   */
      /* Termina nodo:280   */

      /* Empieza nodo:291 / Elemento padre: 279   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(291)).setAttribute("ancho","590" );
      ((Element)v.get(291)).setAttribute("filas","1" );
      ((Element)v.get(291)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(279)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("ancho","40" );
      ((Element)v.get(292)).setAttribute("caracteres","20" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 291   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(293)).setAttribute("ancho","60" );
      ((Element)v.get(293)).setAttribute("caracteres","20" );
      ((Element)v.get(291)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 291   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(294)).setAttribute("ancho","440" );
      ((Element)v.get(294)).setAttribute("caracteres","30" );
      ((Element)v.get(291)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 291   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(295)).setAttribute("ancho","440" );
      ((Element)v.get(295)).setAttribute("caracteres","30" );
      ((Element)v.get(291)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 291   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(296)).setAttribute("ancho","440" );
      ((Element)v.get(296)).setAttribute("caracteres","30" );
      ((Element)v.get(291)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:291   */

      /* Empieza nodo:297 / Elemento padre: 279   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(279)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:298 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(298)).setAttribute("nombre","capaAcceso" );
      ((Element)v.get(298)).setAttribute("alto","3" );
      ((Element)v.get(298)).setAttribute("ancho","624" );
      ((Element)v.get(298)).setAttribute("colorf","" );
      ((Element)v.get(298)).setAttribute("borde","0" );
      ((Element)v.get(298)).setAttribute("imagenf","" );
      ((Element)v.get(298)).setAttribute("repeat","" );
      ((Element)v.get(298)).setAttribute("padding","" );
      ((Element)v.get(298)).setAttribute("visibilidad","visible" );
      ((Element)v.get(298)).setAttribute("contravsb","" );
      ((Element)v.get(298)).setAttribute("x","0" );
      ((Element)v.get(298)).setAttribute("y","165" );
      ((Element)v.get(298)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(299)).setAttribute("seleccion","boton" );
      ((Element)v.get(299)).setAttribute("nombre","lstAcceso" );
      ((Element)v.get(299)).setAttribute("x","12" );
      ((Element)v.get(299)).setAttribute("y","10" );
      ((Element)v.get(299)).setAttribute("ancho","600" );
      ((Element)v.get(299)).setAttribute("alto","3" );
      ((Element)v.get(299)).setAttribute("multisel","-1" );
      ((Element)v.get(299)).setAttribute("incy","10" );
      ((Element)v.get(299)).setAttribute("incx","10" );
      ((Element)v.get(299)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(299)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(299)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(299)).setAttribute("accion","" );
      ((Element)v.get(299)).setAttribute("sep","|" );
      ((Element)v.get(299)).setAttribute("pixelsborde","2" );
      ((Element)v.get(299)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(300)).setAttribute("nombre","cab1" );
      ((Element)v.get(300)).setAttribute("height","20" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(301)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(301)).setAttribute("ancho","40" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Elemento padre:301 / Elemento actual: 302   */
      v.add(doc.createTextNode("Acceso"));
      ((Element)v.get(301)).appendChild((Text)v.get(302));

      /* Termina nodo Texto:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(303)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(303)).setAttribute("ancho","60" );
      ((Element)v.get(300)).appendChild((Element)v.get(303));

      /* Elemento padre:303 / Elemento actual: 304   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(303)).appendChild((Text)v.get(304));

      /* Termina nodo Texto:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(305)).setAttribute("ancho","440" );
      ((Element)v.get(300)).appendChild((Element)v.get(305));

      /* Elemento padre:305 / Elemento actual: 306   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(305)).appendChild((Text)v.get(306));

      /* Termina nodo Texto:306   */
      /* Termina nodo:305   */
      /* Termina nodo:300   */

      /* Empieza nodo:307 / Elemento padre: 299   */
      v.add(doc.createElement("PRESENTACION"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(307)).setAttribute("ancho","590" );
      ((Element)v.get(307)).setAttribute("filas","1" );
      ((Element)v.get(307)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(299)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(308)).setAttribute("ancho","40" );
      ((Element)v.get(308)).setAttribute("caracteres","20" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(309)).setAttribute("ancho","60" );
      ((Element)v.get(309)).setAttribute("caracteres","20" );
      ((Element)v.get(307)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */

      /* Empieza nodo:310 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(310)).setAttribute("ancho","440" );
      ((Element)v.get(310)).setAttribute("caracteres","30" );
      ((Element)v.get(307)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:307   */

      /* Empieza nodo:311 / Elemento padre: 299   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(299)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:312 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(312)).setAttribute("nombre","capaTipo" );
      ((Element)v.get(312)).setAttribute("alto","3" );
      ((Element)v.get(312)).setAttribute("ancho","624" );
      ((Element)v.get(312)).setAttribute("colorf","" );
      ((Element)v.get(312)).setAttribute("borde","0" );
      ((Element)v.get(312)).setAttribute("imagenf","" );
      ((Element)v.get(312)).setAttribute("repeat","" );
      ((Element)v.get(312)).setAttribute("padding","" );
      ((Element)v.get(312)).setAttribute("visibilidad","visible" );
      ((Element)v.get(312)).setAttribute("contravsb","" );
      ((Element)v.get(312)).setAttribute("x","0" );
      ((Element)v.get(312)).setAttribute("y","165" );
      ((Element)v.get(312)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(313)).setAttribute("seleccion","boton" );
      ((Element)v.get(313)).setAttribute("nombre","lstTipo" );
      ((Element)v.get(313)).setAttribute("x","12" );
      ((Element)v.get(313)).setAttribute("y","10" );
      ((Element)v.get(313)).setAttribute("ancho","600" );
      ((Element)v.get(313)).setAttribute("alto","3" );
      ((Element)v.get(313)).setAttribute("multisel","-1" );
      ((Element)v.get(313)).setAttribute("incy","10" );
      ((Element)v.get(313)).setAttribute("incx","10" );
      ((Element)v.get(313)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(313)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(313)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(313)).setAttribute("accion","" );
      ((Element)v.get(313)).setAttribute("sep","|" );
      ((Element)v.get(313)).setAttribute("pixelsborde","2" );
      ((Element)v.get(313)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(314)).setAttribute("nombre","cab1" );
      ((Element)v.get(314)).setAttribute("height","20" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(315)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(315)).setAttribute("ancho","40" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Elemento padre:315 / Elemento actual: 316   */
      v.add(doc.createTextNode("Tipo"));
      ((Element)v.get(315)).appendChild((Text)v.get(316));

      /* Termina nodo Texto:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(317)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(317)).setAttribute("ancho","60" );
      ((Element)v.get(314)).appendChild((Element)v.get(317));

      /* Elemento padre:317 / Elemento actual: 318   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(317)).appendChild((Text)v.get(318));

      /* Termina nodo Texto:318   */
      /* Termina nodo:317   */
      /* Termina nodo:314   */

      /* Empieza nodo:319 / Elemento padre: 313   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(319)).setAttribute("ancho","590" );
      ((Element)v.get(319)).setAttribute("filas","1" );
      ((Element)v.get(319)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(313)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(320)).setAttribute("ancho","40" );
      ((Element)v.get(320)).setAttribute("caracteres","20" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 319   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(321)).setAttribute("ancho","60" );
      ((Element)v.get(321)).setAttribute("caracteres","20" );
      ((Element)v.get(319)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:319   */

      /* Empieza nodo:322 / Elemento padre: 313   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(313)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:323 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(323)).setAttribute("nombre","capaSubTipo" );
      ((Element)v.get(323)).setAttribute("alto","3" );
      ((Element)v.get(323)).setAttribute("ancho","624" );
      ((Element)v.get(323)).setAttribute("colorf","" );
      ((Element)v.get(323)).setAttribute("borde","0" );
      ((Element)v.get(323)).setAttribute("imagenf","" );
      ((Element)v.get(323)).setAttribute("repeat","" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(323)).setAttribute("padding","" );
      ((Element)v.get(323)).setAttribute("visibilidad","visible" );
      ((Element)v.get(323)).setAttribute("contravsb","" );
      ((Element)v.get(323)).setAttribute("x","0" );
      ((Element)v.get(323)).setAttribute("y","165" );
      ((Element)v.get(323)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(324)).setAttribute("seleccion","boton" );
      ((Element)v.get(324)).setAttribute("nombre","lstSubTipo" );
      ((Element)v.get(324)).setAttribute("x","12" );
      ((Element)v.get(324)).setAttribute("y","10" );
      ((Element)v.get(324)).setAttribute("ancho","600" );
      ((Element)v.get(324)).setAttribute("alto","3" );
      ((Element)v.get(324)).setAttribute("multisel","-1" );
      ((Element)v.get(324)).setAttribute("incy","10" );
      ((Element)v.get(324)).setAttribute("incx","10" );
      ((Element)v.get(324)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(324)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(324)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(324)).setAttribute("accion","" );
      ((Element)v.get(324)).setAttribute("sep","|" );
      ((Element)v.get(324)).setAttribute("pixelsborde","2" );
      ((Element)v.get(324)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(325)).setAttribute("nombre","cab1" );
      ((Element)v.get(325)).setAttribute("height","20" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(326)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(326)).setAttribute("ancho","40" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Elemento padre:326 / Elemento actual: 327   */
      v.add(doc.createTextNode("Subtipo"));
      ((Element)v.get(326)).appendChild((Text)v.get(327));

      /* Termina nodo Texto:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 325   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(328)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(328)).setAttribute("ancho","60" );
      ((Element)v.get(325)).appendChild((Element)v.get(328));

      /* Elemento padre:328 / Elemento actual: 329   */
      v.add(doc.createTextNode("Tipo"));
      ((Element)v.get(328)).appendChild((Text)v.get(329));

      /* Termina nodo Texto:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 325   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(330)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(330)).setAttribute("ancho","440" );
      ((Element)v.get(325)).appendChild((Element)v.get(330));

      /* Elemento padre:330 / Elemento actual: 331   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(330)).appendChild((Text)v.get(331));

      /* Termina nodo Texto:331   */
      /* Termina nodo:330   */
      /* Termina nodo:325   */

      /* Empieza nodo:332 / Elemento padre: 324   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(332)).setAttribute("ancho","590" );
      ((Element)v.get(332)).setAttribute("filas","1" );
      ((Element)v.get(332)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(324)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(333)).setAttribute("ancho","40" );
      ((Element)v.get(333)).setAttribute("caracteres","20" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */

      /* Empieza nodo:334 / Elemento padre: 332   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(334)).setAttribute("ancho","60" );
      ((Element)v.get(334)).setAttribute("caracteres","20" );
      ((Element)v.get(332)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */

      /* Empieza nodo:335 / Elemento padre: 332   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(335)).setAttribute("ancho","440" );
      ((Element)v.get(335)).setAttribute("caracteres","30" );
      ((Element)v.get(332)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:332   */

      /* Empieza nodo:336 / Elemento padre: 324   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(324)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:337 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(337)).setAttribute("nombre","capaTipoClasi" );
      ((Element)v.get(337)).setAttribute("alto","3" );
      ((Element)v.get(337)).setAttribute("ancho","624" );
      ((Element)v.get(337)).setAttribute("colorf","" );
      ((Element)v.get(337)).setAttribute("borde","0" );
      ((Element)v.get(337)).setAttribute("imagenf","" );
      ((Element)v.get(337)).setAttribute("repeat","" );
      ((Element)v.get(337)).setAttribute("padding","" );
      ((Element)v.get(337)).setAttribute("visibilidad","visible" );
      ((Element)v.get(337)).setAttribute("contravsb","" );
      ((Element)v.get(337)).setAttribute("x","0" );
      ((Element)v.get(337)).setAttribute("y","165" );
      ((Element)v.get(337)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(338)).setAttribute("seleccion","boton" );
      ((Element)v.get(338)).setAttribute("nombre","lstTipoClasi" );
      ((Element)v.get(338)).setAttribute("x","12" );
      ((Element)v.get(338)).setAttribute("y","10" );
      ((Element)v.get(338)).setAttribute("ancho","600" );
      ((Element)v.get(338)).setAttribute("alto","3" );
      ((Element)v.get(338)).setAttribute("multisel","-1" );
      ((Element)v.get(338)).setAttribute("incy","10" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(338)).setAttribute("incx","10" );
      ((Element)v.get(338)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(338)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(338)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(338)).setAttribute("accion","" );
      ((Element)v.get(338)).setAttribute("sep","|" );
      ((Element)v.get(338)).setAttribute("pixelsborde","2" );
      ((Element)v.get(338)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(339)).setAttribute("nombre","cab1" );
      ((Element)v.get(339)).setAttribute("height","20" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(340)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(340)).setAttribute("ancho","40" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Elemento padre:340 / Elemento actual: 341   */
      v.add(doc.createTextNode("TipoClasi"));
      ((Element)v.get(340)).appendChild((Text)v.get(341));

      /* Termina nodo Texto:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:342 / Elemento padre: 339   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(342)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(342)).setAttribute("ancho","60" );
      ((Element)v.get(339)).appendChild((Element)v.get(342));

      /* Elemento padre:342 / Elemento actual: 343   */
      v.add(doc.createTextNode("SubTipoClie"));
      ((Element)v.get(342)).appendChild((Text)v.get(343));

      /* Termina nodo Texto:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 339   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(344)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(344)).setAttribute("ancho","440" );
      ((Element)v.get(339)).appendChild((Element)v.get(344));

      /* Elemento padre:344 / Elemento actual: 345   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(344)).appendChild((Text)v.get(345));

      /* Termina nodo Texto:345   */
      /* Termina nodo:344   */
      /* Termina nodo:339   */

      /* Empieza nodo:346 / Elemento padre: 338   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(346)).setAttribute("ancho","590" );
      ((Element)v.get(346)).setAttribute("filas","1" );
      ((Element)v.get(346)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(338)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(347)).setAttribute("ancho","40" );
      ((Element)v.get(347)).setAttribute("caracteres","20" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */

      /* Empieza nodo:348 / Elemento padre: 346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(348)).setAttribute("ancho","60" );
      ((Element)v.get(348)).setAttribute("caracteres","20" );
      ((Element)v.get(346)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */

      /* Empieza nodo:349 / Elemento padre: 346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(349)).setAttribute("ancho","440" );
      ((Element)v.get(349)).setAttribute("caracteres","30" );
      ((Element)v.get(346)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:346   */

      /* Empieza nodo:350 / Elemento padre: 338   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(338)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:351 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(351)).setAttribute("nombre","capaClasi" );
      ((Element)v.get(351)).setAttribute("alto","3" );
      ((Element)v.get(351)).setAttribute("ancho","624" );
      ((Element)v.get(351)).setAttribute("colorf","" );
      ((Element)v.get(351)).setAttribute("borde","0" );
      ((Element)v.get(351)).setAttribute("imagenf","" );
      ((Element)v.get(351)).setAttribute("repeat","" );
      ((Element)v.get(351)).setAttribute("padding","" );
      ((Element)v.get(351)).setAttribute("visibilidad","visible" );
      ((Element)v.get(351)).setAttribute("contravsb","" );
      ((Element)v.get(351)).setAttribute("x","0" );
      ((Element)v.get(351)).setAttribute("y","165" );
      ((Element)v.get(351)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(352)).setAttribute("seleccion","boton" );
      ((Element)v.get(352)).setAttribute("nombre","lstClasi" );
      ((Element)v.get(352)).setAttribute("x","12" );
      ((Element)v.get(352)).setAttribute("y","10" );
      ((Element)v.get(352)).setAttribute("ancho","600" );
      ((Element)v.get(352)).setAttribute("alto","3" );
      ((Element)v.get(352)).setAttribute("multisel","-1" );
      ((Element)v.get(352)).setAttribute("incy","10" );
      ((Element)v.get(352)).setAttribute("incx","10" );
      ((Element)v.get(352)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(352)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(352)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(352)).setAttribute("accion","" );
      ((Element)v.get(352)).setAttribute("sep","|" );
      ((Element)v.get(352)).setAttribute("pixelsborde","2" );
      ((Element)v.get(352)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(353)).setAttribute("nombre","cab1" );
      ((Element)v.get(353)).setAttribute("height","20" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(354)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(354)).setAttribute("ancho","40" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Elemento padre:354 / Elemento actual: 355   */
      v.add(doc.createTextNode("Clasi"));
      ((Element)v.get(354)).appendChild((Text)v.get(355));

      /* Termina nodo Texto:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:356 / Elemento padre: 353   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(356)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(356)).setAttribute("ancho","60" );
      ((Element)v.get(353)).appendChild((Element)v.get(356));

      /* Elemento padre:356 / Elemento actual: 357   */
      v.add(doc.createTextNode("TipoClasi"));
      ((Element)v.get(356)).appendChild((Text)v.get(357));

      /* Termina nodo Texto:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 353   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(358)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(358)).setAttribute("ancho","440" );
      ((Element)v.get(353)).appendChild((Element)v.get(358));

      /* Elemento padre:358 / Elemento actual: 359   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(358)).appendChild((Text)v.get(359));

      /* Termina nodo Texto:359   */
      /* Termina nodo:358   */
      /* Termina nodo:353   */

      /* Empieza nodo:360 / Elemento padre: 352   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(360)).setAttribute("ancho","590" );
      ((Element)v.get(360)).setAttribute("filas","1" );
      ((Element)v.get(360)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(352)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(361)).setAttribute("ancho","40" );
      ((Element)v.get(361)).setAttribute("caracteres","20" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(362)).setAttribute("ancho","60" );
      ((Element)v.get(362)).setAttribute("caracteres","20" );
      ((Element)v.get(360)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */

      /* Empieza nodo:363 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(363)).setAttribute("ancho","440" );
      ((Element)v.get(363)).setAttribute("caracteres","30" );
      ((Element)v.get(360)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:360   */

      /* Empieza nodo:364 / Elemento padre: 352   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(352)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:352   */
      /* Termina nodo:351   */
      /* Termina nodo:10   */


   }

}

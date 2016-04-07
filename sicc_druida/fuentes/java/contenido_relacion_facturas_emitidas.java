
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_relacion_facturas_emitidas  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_relacion_facturas_emitidas" );
      ((Element)v.get(0)).setAttribute("cod","0787" );
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
      v.add(doc.createTextNode("\r   \r   \r   function loadPag(){\r      configurarMenuSecundario('Formulario');\r      focaliza('Formulario.cbMarca');\r   }\r\r     function quitarItemVacio(elemento){\r      var elementoADevolver = new Array();\r     \r      for(var k=0;k<elemento.length;k++) {\r          if (elemento[k] != ''){                            \r             elementoADevolver[elementoADevolver.length] = elemento[k];\r          }\r      }\r         \r      return elementoADevolver;\r      \r   }\r   function generar(){\r      if(sicc_validaciones_generales()){\r         if ( validarangofechas(get('Formulario.txtFechaInicio'), get('Formulario.txtFechaFin')) ) { \r            var a = new Object();\r            a.accion = 'generar';\r            a.marca = get('Formulario.cbMarca');\r            a.canal = get('Formulario.cbCanal');\r            a.periodo = get('Formulario.cbPeriodo');\r            a.periodoDesc = get('Formulario.cbPeriodo', 'T');\r            a.acceso = get('Formulario.cbAcceso');\r            a.region = quitarItemVacio(get('Formulario.cbRegion'));\r            a.zonas = quitarItemVacio(get('Formulario.cbZona')) ;\r            a.desde = get('Formulario.txtFechaInicio');\r            a.hasta = get('Formulario.txtFechaFin');          \r            mostrarModalSICC('FACRelacionFacturasEmitidas','generar', a);  \r         }\r      }\r   }\r\r   function cambioMarcaCanal(){\r    /*opcionesPeriodo = new Array();     \r     set_combo('Formulario.cbPeriodo',opcionesPeriodo);        \r     tipoM = get('Formulario.cbMarca','V');\r     tipoC = get('Formulario.cbCanal','V');\r     combo_add('Formulario.cbPeriodo', '', '');\r\r     for(var k=0;k<lstPeriodo.datos.longitud;k++) {\r        for(var y=0;y<tipoM.length;y++){\r          for(var x=0;x<tipoC.length;x++){\r             if ((lstPeriodo.datos.ij(k,2) == tipoM[y])&&\r                 (lstPeriodo.datos.ij(k,3) == tipoC[x])){ 			 \r                combo_add('Formulario.cbPeriodo',lstPeriodo.datos.ij(k,0),lstPeriodo.datos.ij(k,1));\r      \r             }\r           }\r        }\r    }*/\r     opcionesPeriodo = new Array();\r     set_combo('Formulario.cbPeriodo',opcionesPeriodo);\r     combo_add('Formulario.cbPeriodo', '', '');\r\r	 var pais = get('Formulario.pais');\r     var tipoM = get('Formulario.cbMarca','V');\r     var tipoC = get('Formulario.cbCanal','V');\r\r     var arr = new Array();\r     arr[arr.length] = ['oidPais', pais];\r     arr[arr.length] = ['marca', tipoM];\r     arr[arr.length] = ['canal', tipoC];\r	 if (tipoM!='' && tipoC!='') {\r		recargaCombo(\"Formulario.cbPeriodo\", \"CRAObtenerPeriodos\", \"es.indra.sicc.dtos.cra.DTOPeriodo\", arr);\r	 }\r\r     opcionesRegion = new Array();     \r     set_combo('Formulario.cbRegion',opcionesRegion);        \r     tipoM1 = get('Formulario.cbMarca','V');\r     tipoC1 = get('Formulario.cbCanal','V');\r     combo_add('Formulario.cbRegion', '', '');\r\r     for(var k=0;k<lstRegion.datos.longitud;k++) {\r        for(var y=0;y<tipoM1.length;y++){\r          for(var x=0;x<tipoC1.length;x++){\r             if ((lstRegion.datos.ij(k,2) == tipoM1[y])&&\r                 (lstRegion.datos.ij(k,3) == tipoC1[x])){ 			 \r                combo_add('Formulario.cbRegion',lstRegion.datos.ij(k,0),lstRegion.datos.ij(k,1));\r      \r             }\r           }\r        }\r    }\r    cambioRegionMarcaCanal();\r	seteoFechasDdeHta();\r  }      \r   function cambioCanal(){\r         \r     opciones = new Array();\r     set_combo('Formulario.cbAcceso',opciones);        \r     tipo = get('Formulario.cbCanal','V');\r     combo_add('Formulario.cbAcceso', '', '');\r       \r     for(var k=0;k<lstAcceso.datos.longitud;k++) {\r        for(var y=0;y<tipo.length;y++){\r           if (lstAcceso.datos.ij(k,2) == tipo[y]){ 			 \r              combo_add('Formulario.cbAcceso',lstAcceso.datos.ij(k,0),lstAcceso.datos.ij(k,1));\r    \r           }\r        }\r    }\r    cambioMarcaCanal();\r  }    \r   \r   function cambioRegionMarcaCanal(){\r     /*  \r     opcionesNZona = new Array();     \r     set_combo('Formulario.cbZona',opcionesNZona);        \r     tipoM = get('Formulario.cbMarca','V');\r     tipoC = get('Formulario.cbCanal','V');\r     tipoR = get('Formulario.cbRegion','V');          \r     combo_add('Formulario.cbZona', '', '');\r       \r     for(var k=0;k<lstZona.datos.longitud;k++) {\r        for(var y=0;y<tipoM.length;y++){\r          for(var x=0;x<tipoC.length;x++){\r            for(var z=0;z<tipoR.length;z++){              \r               if ((lstZona.datos.ij(k,3) == tipoM[y])&&\r                   (lstZona.datos.ij(k,4) == tipoC[x])&&\r                   (lstZona.datos.ij(k,1) == tipoR[z])){\r                  combo_add('Formulario.cbZona',lstZona.datos.ij(k,0),lstZona.datos.ij(k,2));\r        \r               }\r             }\r           }\r        }\r    }*/\r    opciones = new Array();\r    set_combo('Formulario.cbZona',opciones);\r    combo_add('Formulario.cbZona', '', '');\r\r    var regiones = quitarItemVacio(get('Formulario.cbRegion'));\r	var pais = get('Formulario.pais');\r    var regionConc = new String();\r    \r    for(i=0;i<regiones.length;i++){\r        regionConc += regiones[i] + \"x\";\r    }\r    regionConc = regionConc.substring(0, regionConc.length-1);\r\r    var arr = new Array();\r    arr[arr.length] = ['cadena', regionConc];\r    arr[arr.length] = ['oidPais', pais];\r    \r    if(regionConc != ''){\r        recargaCombo(\"Formulario.cbZona\", \"REPRecargaZonas\", \"es.indra.sicc.util.DTOString\",arr);\r    }\r  }  \r  function recolectarParametros(){\r        set('Formulario.marca',get('Formulario.cbMarca')) ;\r        set('Formulario.canal',get('Formulario.cbCanal')) ;\r        set('Formulario.periodo',get('Formulario.cbPeriodo'));\r        set('Formulario.acceso', get('Formulario.cbAcceso'));\r        set('Formulario.region',get('Formulario.cbRegion'));\r        set('Formulario.zonas',get('Formulario.cbZona')) ;\r        set('Formulario.desde', get('Formulario.txtFechaInicio'));\r        set('Formulario.hasta',get('Formulario.txtFechaFin'));\r        \r  }\r\r   function fLimpiar(){\r   \r      var aCombo = new Array(new Array(\"\",\"\"));\r      set_combo('Formulario.cbAcceso', aCombo, []);\r      set_combo('Formulario.cbPeriodo', aCombo, []);\r      set_combo('Formulario.cbRegion', aCombo, []);\r      set_combo('Formulario.cbZona', aCombo, []);\r      \r      focaliza('Formulario.cbMarca');\r   \r   }\r\r        function arrayComponentes(){\r              var arr = new Array();               \r              arr[arr.length]= new Array(\"cbMarca\",\"\");\r              arr[arr.length]= new Array(\"cbCanal\",\"\");              \r              arr[arr.length]= new Array(\"cbPeriodo\",\"\");\r              arr[arr.length]= new Array(\"cbAcceso\",\"\");\r              arr[arr.length]= new Array(\"cbRegion\",\"\");\r              arr[arr.length]= new Array(\"cbZona\",\"\");\r	      arr[arr.length]= new Array(\"txtFechaInicio\",\"\");\r	      arr[arr.length]= new Array(\"txtFechaFin\",\"\");\r              arr[arr.length]= new Array(\"btnGenerarInforme\",\"BOTON\");\r              \r              return arr;\r          }\r          function tabGenerico(nombreComp, tipotab){       \r            var arr = arrayComponentes();\r            var tabular = false;\r            var nombreFormulario = getFormularioSICC();\r            var j = 0;\r            var k = arr.length;\r            if (tipotab != \"sh\") {\r                j = j-1;                \r                k = k-1;\r            }\r\r            while(j<k){\r                var t;\r                if(tipotab == \"sh\"){\r                  k--;\r                  t = k;\r                } else{\r                  j++;\r                  t = j;                  \r                }\r                  \r                var nombre = arr[t][0];\r                var tipo = arr[t][1];\r                if (tabular==false){\r                  if (nombreComp==nombre){\r                      tabular=true;\r                      if (tipotab == \"sh\"){\r                        if (k==0) k= arr.length;\r                      } else {\r                        if ((j+1)==arr.length)  j = -1;\r                      }\r                  }                \r                } else {\r                  try {\r                    var name = nombreFormulario+\".\"+nombre;\r                    if (tipo==\"BOTONXY\"){\r                       focalizaBotonHTML_XY(nombre);\r                    } else if (tipo==\"BOTON\") {\r                       focalizaBotonHTML(\"botonContenido\",nombre)\r                    } else {\r                       focaliza(name);\r                    }\r                    return;\r                  } catch (e) {\r                  }\r                }\r            }\r          } \r\rfunction seteoFechasDdeHta() {\r      \r    oidPeri = get('Formulario.cbPeriodo','V');\r  if (oidPeri != ''){\r      \r        /*for(var k=0;k<lstPeriodo.datos.longitud;k++) {\r          if (lstPeriodo.datos.ij(k,0) == oidPeri[0]) {\r            set('Formulario.txtFechaInicio', lstPeriodo.datos.ij(k,4));\r            set('Formulario.txtFechaFin', lstPeriodo.datos.ij(k,5));\r            break;\r          }\r        }*/\r   var pais = get('Formulario.pais');\r   var arr = new Array();\r   arr[arr.length] = ['oid', oidPeri];\r   arr[arr.length] = ['oidPais', pais];\r   var datos = new Array();\r   recargaCombo(\"Formulario.cbPeriodo\", \"CRAobtieneFechasPeriodo\",\"es.indra.sicc.dtos.cra.DTOPeriodo\", arr,\"salidaRecarga(datos)\");\r\r  } else {\r        set('Formulario.txtFechaInicio', '');\r        set('Formulario.txtFechaFin', '');\r  }\r}\r\rfunction salidaRecarga( datos )	{\r	\r		var formato = get('Formulario.formatoFecha').toLowerCase();\r    set('Formulario.txtFechaInicio', formateaFechaJava( datos[0][0], formato) );\r    set('Formulario.txtFechaFin', formateaFechaJava( datos[0][1], formato) );\r	return false;\r}\r\rfunction formateaFechaJava( fecha, formato )	{\r\r	var nuevaFecha;\r	if (formato=='dd/mm/yyyy')	{\r	    vfecha = fecha.split(\"-\");\r	    nuevaFecha = vfecha[2] + '/' + vfecha[1] + '/' + vfecha[0]; \r	}\r	else if (formato=='mm/dd/yyyy')	{\r	    vfecha = fecha.split(\"-\");\r	    nuevaFecha = vfecha[2] + '/' + vfecha[0] + '/' + vfecha[1]; \r	}\r	else if (formato=='yyyy/mm/dd')	{\r	    vfecha = fecha.split(\"-\");\r	    nuevaFecha = vfecha[0] + '/' + vfecha[1] + '/' + vfecha[2]; \r	}\r	else if (formato=='dd-mm-yyyy')	{\r	    vfecha = fecha.split(\"-\");\r	    nuevaFecha = vfecha[2] + '-' + vfecha[1] + '-' + vfecha[0]; \r	}\r	else {\r		nuevaFecha = fecha;\r	}\r	return nuevaFecha;\r}\r\r  function validarangofechas(fecha1, fecha2){\r    \r        \r    if ( (cdos_trim(fecha1) != \"\" ) && (cdos_trim(fecha2) != \"\" ) ) {\r    \r	    vfecha1=fecha1.split(\"/\");\r	    vfecha2=fecha2.split(\"/\");\r	    nfecha1=vfecha1[1] + '/' + vfecha1[0] + '/' + vfecha1[2]; \r	    nfecha2=vfecha2[1] + '/' + vfecha2[0] + '/' + vfecha2[2];     \r    \r	    f1=new Date(nfecha1); \r	    f2=new Date(nfecha2);\r\r	    if(f1>f2){\r	      cdos_mostrarAlert(GestionarMensaje('936'));\r	      focaliza('Formulario.txtFechaFin');\r	      return false;\r	    }else {\r	      if(f1<f2){     \r	      return true;\r	      } else {\r	      cdos_mostrarAlert(GestionarMensaje('936'));\r	      focaliza('Formulario.txtFechaFin');\r	      return false;\r	    }\r       }\r    }\r}\r   \r"));
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
      ((Element)v.get(11)).setAttribute("name","txtFechaInicio" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","274" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtFechaFin" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","251" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:6   */

      /* Empieza nodo:13 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(13)).setAttribute("nombre","Formulario" );
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
      ((Element)v.get(15)).setAttribute("valor","FACRelacionFacturasEmitidas" );
      ((Element)v.get(13)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","idioma" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","pais" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","marca" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 13   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","canal" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","periodo" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","acceso" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","region" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","zonas" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","desde" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hasta" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","formatoFecha" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(30)).setAttribute("nombre","capa" );
      ((Element)v.get(13)).appendChild((Element)v.get(30));

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
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).setAttribute("border","0" );
      ((Element)v.get(46)).setAttribute("align","center" );
      ((Element)v.get(46)).setAttribute("cellspacing","0" );
      ((Element)v.get(46)).setAttribute("cellpadding","0" );
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("colspan","7" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:50 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(50));

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
      ((Element)v.get(54)).setAttribute("nombre","lblPais" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("id","datosTitle" );
      ((Element)v.get(54)).setAttribute("cod","5" );
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
      ((Element)v.get(58)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(58)).setAttribute("alto","13" );
      ((Element)v.get(58)).setAttribute("filas","1" );
      ((Element)v.get(58)).setAttribute("id","datosTitle" );
      ((Element)v.get(58)).setAttribute("cod","6" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","25" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(62)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(62)).setAttribute("alto","13" );
      ((Element)v.get(62)).setAttribute("filas","1" );
      ((Element)v.get(62)).setAttribute("id","datosTitle" );
      ((Element)v.get(62)).setAttribute("cod","7" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","100%" );
      ((Element)v.get(50)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:50   */

      /* Empieza nodo:65 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(65));

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
      ((Element)v.get(65)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(69)).setAttribute("nombre","lblPaisdt" );
      ((Element)v.get(69)).setAttribute("alto","13" );
      ((Element)v.get(69)).setAttribute("filas","1" );
      ((Element)v.get(69)).setAttribute("id","datosCampos" );
      ((Element)v.get(69)).setAttribute("valor","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","25" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(65)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(73)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(73)).setAttribute("size","1" );
      ((Element)v.get(73)).setAttribute("multiple","N" );
      ((Element)v.get(73)).setAttribute("valorinicial","" );
      ((Element)v.get(73)).setAttribute("textoinicial","" );
      ((Element)v.get(73)).setAttribute("id","datosCampos" );
      ((Element)v.get(73)).setAttribute("req","S" );
      ((Element)v.get(73)).setAttribute("onchange","cambioMarcaCanal();" );
      ((Element)v.get(73)).setAttribute("ontab","tabGenerico('cbMarca');" );
      ((Element)v.get(73)).setAttribute("onshtab","tabGenerico('cbMarca','sh');" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:75 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","25" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(65)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(78)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(78)).setAttribute("size","1" );
      ((Element)v.get(78)).setAttribute("multiple","N" );
      ((Element)v.get(78)).setAttribute("valorinicial","" );
      ((Element)v.get(78)).setAttribute("textoinicial","" );
      ((Element)v.get(78)).setAttribute("id","datosCampos" );
      ((Element)v.get(78)).setAttribute("req","S" );
      ((Element)v.get(78)).setAttribute("onchange","cambioCanal();" );
      ((Element)v.get(78)).setAttribute("ontab","tabGenerico('cbCanal');" );
      ((Element)v.get(78)).setAttribute("onshtab","tabGenerico('cbCanal','sh');" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:80 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("width","100%" );
      ((Element)v.get(65)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:65   */

      /* Empieza nodo:82 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("colspan","7" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:46   */

      /* Empieza nodo:85 / Elemento padre: 43   */
      v.add(doc.createElement("table"));
      ((Element)v.get(85)).setAttribute("width","100%" );
      ((Element)v.get(85)).setAttribute("border","0" );
      ((Element)v.get(85)).setAttribute("align","center" );
      ((Element)v.get(85)).setAttribute("cellspacing","0" );
      ((Element)v.get(85)).setAttribute("cellpadding","0" );
      ((Element)v.get(43)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","8" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(90)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(90)).setAttribute("alto","13" );
      ((Element)v.get(90)).setAttribute("filas","1" );
      ((Element)v.get(90)).setAttribute("id","datosTitle" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(90)).setAttribute("cod","276" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","25" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(94)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(94)).setAttribute("alto","13" );
      ((Element)v.get(94)).setAttribute("filas","1" );
      ((Element)v.get(94)).setAttribute("id","datosTitle" );
      ((Element)v.get(94)).setAttribute("cod","10" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("width","100%" );
      ((Element)v.get(86)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:86   */

      /* Empieza nodo:97 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","8" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(97)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(101)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(101)).setAttribute("size","1" );
      ((Element)v.get(101)).setAttribute("multiple","N" );
      ((Element)v.get(101)).setAttribute("valorinicial","" );
      ((Element)v.get(101)).setAttribute("textoinicial","" );
      ((Element)v.get(101)).setAttribute("id","datosCampos" );
      ((Element)v.get(101)).setAttribute("req","S" );
      ((Element)v.get(101)).setAttribute("ontab","tabGenerico('cbPeriodo');" );
      ((Element)v.get(101)).setAttribute("onshtab","tabGenerico('cbPeriodo','sh');" );
      ((Element)v.get(101)).setAttribute("onchange","seteoFechasDdeHta();" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:103 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","25" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(97)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(106)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(106)).setAttribute("size","1" );
      ((Element)v.get(106)).setAttribute("multiple","N" );
      ((Element)v.get(106)).setAttribute("valorinicial","" );
      ((Element)v.get(106)).setAttribute("textoinicial","" );
      ((Element)v.get(106)).setAttribute("id","datosCampos" );
      ((Element)v.get(106)).setAttribute("req","N" );
      ((Element)v.get(106)).setAttribute("ontab","tabGenerico('cbAcceso');" );
      ((Element)v.get(106)).setAttribute("onshtab","tabGenerico('cbAcceso','sh');" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:108 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","100%" );
      ((Element)v.get(97)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:97   */

      /* Empieza nodo:110 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("colspan","7" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:85   */

      /* Empieza nodo:113 / Elemento padre: 43   */
      v.add(doc.createElement("table"));
      ((Element)v.get(113)).setAttribute("width","100%" );
      ((Element)v.get(113)).setAttribute("border","0" );
      ((Element)v.get(113)).setAttribute("align","center" );
      ((Element)v.get(113)).setAttribute("cellspacing","0" );
      ((Element)v.get(113)).setAttribute("cellpadding","0" );
      ((Element)v.get(43)).appendChild((Element)v.get(113));

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
      ((Element)v.get(118)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(118)).setAttribute("alto","13" );
      ((Element)v.get(118)).setAttribute("filas","1" );
      ((Element)v.get(118)).setAttribute("id","datosTitle" );
      ((Element)v.get(118)).setAttribute("cod","109" );
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
      ((Element)v.get(122)).setAttribute("nombre","lblZona" );
      ((Element)v.get(122)).setAttribute("alto","13" );
      ((Element)v.get(122)).setAttribute("filas","1" );
      ((Element)v.get(122)).setAttribute("id","datosTitle" );
      ((Element)v.get(122)).setAttribute("cod","143" );
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
      ((Element)v.get(129)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(129)).setAttribute("size","5" );
      ((Element)v.get(129)).setAttribute("multiple","S" );
      ((Element)v.get(129)).setAttribute("valorinicial","" );
      ((Element)v.get(129)).setAttribute("textoinicial","" );
      ((Element)v.get(129)).setAttribute("id","datosCampos" );
      ((Element)v.get(129)).setAttribute("req","S" );
      ((Element)v.get(129)).setAttribute("onchange","cambioRegionMarcaCanal();" );
      ((Element)v.get(129)).setAttribute("ontab","tabGenerico('cbRegion');" );
      ((Element)v.get(129)).setAttribute("onshtab","tabGenerico('cbRegion','sh');" );
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
      ((Element)v.get(134)).setAttribute("nombre","cbZona" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(134)).setAttribute("size","5" );
      ((Element)v.get(134)).setAttribute("multiple","S" );
      ((Element)v.get(134)).setAttribute("valorinicial","" );
      ((Element)v.get(134)).setAttribute("textoinicial","" );
      ((Element)v.get(134)).setAttribute("id","datosCampos" );
      ((Element)v.get(134)).setAttribute("req","N" );
      ((Element)v.get(134)).setAttribute("ontab","tabGenerico('cbZona');" );
      ((Element)v.get(134)).setAttribute("onshtab","tabGenerico('cbZona','sh');" );
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
      ((Element)v.get(139)).setAttribute("colspan","7" );
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

      /* Empieza nodo:141 / Elemento padre: 43   */
      v.add(doc.createElement("table"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(141)).setAttribute("border","0" );
      ((Element)v.get(141)).setAttribute("align","center" );
      ((Element)v.get(141)).setAttribute("cellspacing","0" );
      ((Element)v.get(141)).setAttribute("cellpadding","0" );
      ((Element)v.get(43)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(146)).setAttribute("nombre","lblFechaInicio" );
      ((Element)v.get(146)).setAttribute("alto","13" );
      ((Element)v.get(146)).setAttribute("filas","1" );
      ((Element)v.get(146)).setAttribute("id","datosTitle" );
      ((Element)v.get(146)).setAttribute("cod","274" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","25" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(150)).setAttribute("nombre","lblFechaFin" );
      ((Element)v.get(150)).setAttribute("alto","13" );
      ((Element)v.get(150)).setAttribute("filas","1" );
      ((Element)v.get(150)).setAttribute("id","datosTitle" );
      ((Element)v.get(150)).setAttribute("cod","251" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("width","100%" );
      ((Element)v.get(142)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","8" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:142   */

      /* Empieza nodo:153 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(141)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","8" );
      ((Element)v.get(155)).setAttribute("height","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(153)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(157)).setAttribute("nombre","txtFechaInicio" );
      ((Element)v.get(157)).setAttribute("id","datosCampos" );
      ((Element)v.get(157)).setAttribute("max","10" );
      ((Element)v.get(157)).setAttribute("tipo","" );
      ((Element)v.get(157)).setAttribute("onchange","" );
      ((Element)v.get(157)).setAttribute("req","S" );
      ((Element)v.get(157)).setAttribute("size","12" );
      ((Element)v.get(157)).setAttribute("valor","" );
      ((Element)v.get(157)).setAttribute("validacion","" );
      ((Element)v.get(157)).setAttribute("ontab","tabGenerico('txtFechaInicio');" );
      ((Element)v.get(157)).setAttribute("onshtab","tabGenerico('txtFechaInicio','sh');" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","25" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(153)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(161)).setAttribute("nombre","txtFechaFin" );
      ((Element)v.get(161)).setAttribute("id","datosCampos" );
      ((Element)v.get(161)).setAttribute("max","10" );
      ((Element)v.get(161)).setAttribute("tipo","" );
      ((Element)v.get(161)).setAttribute("onchange","" );
      ((Element)v.get(161)).setAttribute("req","S" );
      ((Element)v.get(161)).setAttribute("size","12" );
      ((Element)v.get(161)).setAttribute("valor","" );
      ((Element)v.get(161)).setAttribute("validacion","" );
      ((Element)v.get(161)).setAttribute("ontab","tabGenerico('txtFechaFin');" );
      ((Element)v.get(161)).setAttribute("onshtab","tabGenerico('txtFechaFin','sh');" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("width","100%" );
      ((Element)v.get(153)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","8" );
      ((Element)v.get(163)).setAttribute("height","8" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:153   */

      /* Empieza nodo:164 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(141)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("colspan","7" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","8" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:141   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:167 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:39   */

      /* Empieza nodo:169 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("table"));
      ((Element)v.get(174)).setAttribute("width","100%" );
      ((Element)v.get(174)).setAttribute("border","0" );
      ((Element)v.get(174)).setAttribute("align","center" );
      ((Element)v.get(174)).setAttribute("cellspacing","0" );
      ((Element)v.get(174)).setAttribute("cellpadding","0" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("class","botonera" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(177)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(177)).setAttribute("ID","botonContenido" );
      ((Element)v.get(177)).setAttribute("tipo","html" );
      ((Element)v.get(177)).setAttribute("accion","generar();" );
      ((Element)v.get(177)).setAttribute("estado","false" );
      ((Element)v.get(177)).setAttribute("cod","2495" );
      ((Element)v.get(177)).setAttribute("ontab","tabGenerico('btnGenerarInforme');" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(177)).setAttribute("onshtab","tabGenerico('btnGenerarInforme','sh');" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:178 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","12" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:169   */

      /* Empieza nodo:180 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).setAttribute("width","12" );
      ((Element)v.get(181)).setAttribute("align","center" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","12" );
      ((Element)v.get(182)).setAttribute("height","12" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).setAttribute("width","756" );
      ((Element)v.get(180)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).setAttribute("width","12" );
      ((Element)v.get(180)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","12" );
      ((Element)v.get(186)).setAttribute("height","1" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:180   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:187 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(187)).setAttribute("nombre","capaAcceso" );
      ((Element)v.get(187)).setAttribute("alto","3" );
      ((Element)v.get(187)).setAttribute("ancho","624" );
      ((Element)v.get(187)).setAttribute("colorf","" );
      ((Element)v.get(187)).setAttribute("borde","0" );
      ((Element)v.get(187)).setAttribute("imagenf","" );
      ((Element)v.get(187)).setAttribute("repeat","" );
      ((Element)v.get(187)).setAttribute("padding","" );
      ((Element)v.get(187)).setAttribute("visibilidad","visible" );
      ((Element)v.get(187)).setAttribute("contravsb","" );
      ((Element)v.get(187)).setAttribute("x","0" );
      ((Element)v.get(187)).setAttribute("y","165" );
      ((Element)v.get(187)).setAttribute("zindex","" );
      ((Element)v.get(13)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(188)).setAttribute("seleccion","boton" );
      ((Element)v.get(188)).setAttribute("nombre","lstAcceso" );
      ((Element)v.get(188)).setAttribute("x","12" );
      ((Element)v.get(188)).setAttribute("y","10" );
      ((Element)v.get(188)).setAttribute("ancho","600" );
      ((Element)v.get(188)).setAttribute("alto","3" );
      ((Element)v.get(188)).setAttribute("multisel","-1" );
      ((Element)v.get(188)).setAttribute("incy","10" );
      ((Element)v.get(188)).setAttribute("incx","10" );
      ((Element)v.get(188)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(188)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(188)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(188)).setAttribute("accion","" );
      ((Element)v.get(188)).setAttribute("sep","|" );
      ((Element)v.get(188)).setAttribute("pixelsborde","2" );
      ((Element)v.get(188)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(189)).setAttribute("nombre","cab1" );
      ((Element)v.get(189)).setAttribute("height","20" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(190)).setAttribute("ancho","40" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Elemento padre:190 / Elemento actual: 191   */
      v.add(doc.createTextNode("Acceso"));
      ((Element)v.get(190)).appendChild((Text)v.get(191));

      /* Termina nodo Texto:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(192)).setAttribute("ancho","60" );
      ((Element)v.get(189)).appendChild((Element)v.get(192));

      /* Elemento padre:192 / Elemento actual: 193   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(192)).appendChild((Text)v.get(193));

      /* Termina nodo Texto:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(194)).setAttribute("ancho","440" );
      ((Element)v.get(189)).appendChild((Element)v.get(194));

      /* Elemento padre:194 / Elemento actual: 195   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(194)).appendChild((Text)v.get(195));

      /* Termina nodo Texto:195   */
      /* Termina nodo:194   */
      /* Termina nodo:189   */

      /* Empieza nodo:196 / Elemento padre: 188   */
      v.add(doc.createElement("PRESENTACION"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(196)).setAttribute("ancho","590" );
      ((Element)v.get(196)).setAttribute("filas","1" );
      ((Element)v.get(196)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(188)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("COL"));
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
      /* Termina nodo:196   */

      /* Empieza nodo:200 / Elemento padre: 188   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(188)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:201 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(201)).setAttribute("nombre","capaPeriodo" );
      ((Element)v.get(201)).setAttribute("alto","3" );
      ((Element)v.get(201)).setAttribute("ancho","624" );
      ((Element)v.get(201)).setAttribute("colorf","" );
      ((Element)v.get(201)).setAttribute("borde","0" );
      ((Element)v.get(201)).setAttribute("imagenf","" );
      ((Element)v.get(201)).setAttribute("repeat","" );
      ((Element)v.get(201)).setAttribute("padding","" );
      ((Element)v.get(201)).setAttribute("visibilidad","visible" );
      ((Element)v.get(201)).setAttribute("contravsb","" );
      ((Element)v.get(201)).setAttribute("x","0" );
      ((Element)v.get(201)).setAttribute("y","165" );
      ((Element)v.get(201)).setAttribute("zindex","" );
      ((Element)v.get(13)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(202)).setAttribute("seleccion","boton" );
      ((Element)v.get(202)).setAttribute("nombre","lstPeriodo" );
      ((Element)v.get(202)).setAttribute("x","12" );
      ((Element)v.get(202)).setAttribute("y","10" );
      ((Element)v.get(202)).setAttribute("ancho","600" );
      ((Element)v.get(202)).setAttribute("alto","3" );
      ((Element)v.get(202)).setAttribute("multisel","-1" );
      ((Element)v.get(202)).setAttribute("incy","10" );
      ((Element)v.get(202)).setAttribute("incx","10" );
      ((Element)v.get(202)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(202)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(202)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(202)).setAttribute("accion","" );
      ((Element)v.get(202)).setAttribute("sep","|" );
      ((Element)v.get(202)).setAttribute("pixelsborde","2" );
      ((Element)v.get(202)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(203)).setAttribute("nombre","cab1" );
      ((Element)v.get(203)).setAttribute("height","20" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(204)).setAttribute("ancho","40" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Elemento padre:204 / Elemento actual: 205   */
      v.add(doc.createTextNode("Periodo"));
      ((Element)v.get(204)).appendChild((Text)v.get(205));

      /* Termina nodo Texto:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 203   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(206)).setAttribute("ancho","60" );
      ((Element)v.get(203)).appendChild((Element)v.get(206));

      /* Elemento padre:206 / Elemento actual: 207   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(206)).appendChild((Text)v.get(207));

      /* Termina nodo Texto:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 203   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(208)).setAttribute("ancho","440" );
      ((Element)v.get(203)).appendChild((Element)v.get(208));

      /* Elemento padre:208 / Elemento actual: 209   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(208)).appendChild((Text)v.get(209));

      /* Termina nodo Texto:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 203   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(210)).setAttribute("ancho","440" );
      ((Element)v.get(203)).appendChild((Element)v.get(210));

      /* Elemento padre:210 / Elemento actual: 211   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(210)).appendChild((Text)v.get(211));

      /* Termina nodo Texto:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 203   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(212)).setAttribute("ancho","440" );
      ((Element)v.get(203)).appendChild((Element)v.get(212));

      /* Elemento padre:212 / Elemento actual: 213   */
      v.add(doc.createTextNode("FechaInicio"));
      ((Element)v.get(212)).appendChild((Text)v.get(213));

      /* Termina nodo Texto:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 203   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(214)).setAttribute("ancho","440" );
      ((Element)v.get(203)).appendChild((Element)v.get(214));

      /* Elemento padre:214 / Elemento actual: 215   */
      v.add(doc.createTextNode("FechaFin"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(214)).appendChild((Text)v.get(215));

      /* Termina nodo Texto:215   */
      /* Termina nodo:214   */
      /* Termina nodo:203   */

      /* Empieza nodo:216 / Elemento padre: 202   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(216)).setAttribute("ancho","590" );
      ((Element)v.get(216)).setAttribute("filas","1" );
      ((Element)v.get(216)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(202)).appendChild((Element)v.get(216));

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

      /* Empieza nodo:222 / Elemento padre: 216   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("ancho","440" );
      ((Element)v.get(222)).setAttribute("caracteres","30" );
      ((Element)v.get(216)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:216   */

      /* Empieza nodo:223 / Elemento padre: 202   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(202)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:224 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(224)).setAttribute("nombre","capaRegion" );
      ((Element)v.get(224)).setAttribute("alto","3" );
      ((Element)v.get(224)).setAttribute("ancho","624" );
      ((Element)v.get(224)).setAttribute("colorf","" );
      ((Element)v.get(224)).setAttribute("borde","0" );
      ((Element)v.get(224)).setAttribute("imagenf","" );
      ((Element)v.get(224)).setAttribute("repeat","" );
      ((Element)v.get(224)).setAttribute("padding","" );
      ((Element)v.get(224)).setAttribute("visibilidad","visible" );
      ((Element)v.get(224)).setAttribute("contravsb","" );
      ((Element)v.get(224)).setAttribute("x","0" );
      ((Element)v.get(224)).setAttribute("y","165" );
      ((Element)v.get(224)).setAttribute("zindex","" );
      ((Element)v.get(13)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(225)).setAttribute("seleccion","boton" );
      ((Element)v.get(225)).setAttribute("nombre","lstRegion" );
      ((Element)v.get(225)).setAttribute("x","12" );
      ((Element)v.get(225)).setAttribute("y","10" );
      ((Element)v.get(225)).setAttribute("ancho","600" );
      ((Element)v.get(225)).setAttribute("alto","3" );
      ((Element)v.get(225)).setAttribute("multisel","-1" );
      ((Element)v.get(225)).setAttribute("incy","10" );
      ((Element)v.get(225)).setAttribute("incx","10" );
      ((Element)v.get(225)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(225)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(225)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(225)).setAttribute("accion","" );
      ((Element)v.get(225)).setAttribute("sep","|" );
      ((Element)v.get(225)).setAttribute("pixelsborde","2" );
      ((Element)v.get(225)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(226)).setAttribute("nombre","cab1" );
      ((Element)v.get(226)).setAttribute("height","20" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(227)).setAttribute("ancho","40" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Elemento padre:227 / Elemento actual: 228   */
      v.add(doc.createTextNode("Region"));
      ((Element)v.get(227)).appendChild((Text)v.get(228));

      /* Termina nodo Texto:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(229)).setAttribute("ancho","60" );
      ((Element)v.get(226)).appendChild((Element)v.get(229));

      /* Elemento padre:229 / Elemento actual: 230   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(229)).appendChild((Text)v.get(230));

      /* Termina nodo Texto:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(231)).setAttribute("ancho","440" );
      ((Element)v.get(226)).appendChild((Element)v.get(231));

      /* Elemento padre:231 / Elemento actual: 232   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(231)).appendChild((Text)v.get(232));

      /* Termina nodo Texto:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(233)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(233)).setAttribute("ancho","440" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(226)).appendChild((Element)v.get(233));

      /* Elemento padre:233 / Elemento actual: 234   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(233)).appendChild((Text)v.get(234));

      /* Termina nodo Texto:234   */
      /* Termina nodo:233   */
      /* Termina nodo:226   */

      /* Empieza nodo:235 / Elemento padre: 225   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(235)).setAttribute("ancho","590" );
      ((Element)v.get(235)).setAttribute("filas","1" );
      ((Element)v.get(235)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(225)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(236)).setAttribute("ancho","40" );
      ((Element)v.get(236)).setAttribute("caracteres","20" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 235   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(237)).setAttribute("ancho","60" );
      ((Element)v.get(237)).setAttribute("caracteres","20" );
      ((Element)v.get(235)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 235   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(238)).setAttribute("ancho","440" );
      ((Element)v.get(238)).setAttribute("caracteres","30" );
      ((Element)v.get(235)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 235   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(239)).setAttribute("ancho","440" );
      ((Element)v.get(239)).setAttribute("caracteres","30" );
      ((Element)v.get(235)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:235   */

      /* Empieza nodo:240 / Elemento padre: 225   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(225)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:241 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(241)).setAttribute("nombre","capaZona" );
      ((Element)v.get(241)).setAttribute("alto","3" );
      ((Element)v.get(241)).setAttribute("ancho","624" );
      ((Element)v.get(241)).setAttribute("colorf","" );
      ((Element)v.get(241)).setAttribute("borde","0" );
      ((Element)v.get(241)).setAttribute("imagenf","" );
      ((Element)v.get(241)).setAttribute("repeat","" );
      ((Element)v.get(241)).setAttribute("padding","" );
      ((Element)v.get(241)).setAttribute("visibilidad","visible" );
      ((Element)v.get(241)).setAttribute("contravsb","" );
      ((Element)v.get(241)).setAttribute("x","0" );
      ((Element)v.get(241)).setAttribute("y","165" );
      ((Element)v.get(241)).setAttribute("zindex","" );
      ((Element)v.get(13)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(242)).setAttribute("seleccion","boton" );
      ((Element)v.get(242)).setAttribute("nombre","lstZona" );
      ((Element)v.get(242)).setAttribute("x","12" );
      ((Element)v.get(242)).setAttribute("y","10" );
      ((Element)v.get(242)).setAttribute("ancho","600" );
      ((Element)v.get(242)).setAttribute("alto","3" );
      ((Element)v.get(242)).setAttribute("multisel","-1" );
      ((Element)v.get(242)).setAttribute("incy","10" );
      ((Element)v.get(242)).setAttribute("incx","10" );
      ((Element)v.get(242)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(242)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(242)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(242)).setAttribute("accion","" );
      ((Element)v.get(242)).setAttribute("sep","|" );
      ((Element)v.get(242)).setAttribute("pixelsborde","2" );
      ((Element)v.get(242)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(243)).setAttribute("nombre","cab1" );
      ((Element)v.get(243)).setAttribute("height","20" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(244)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(244)).setAttribute("ancho","40" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Elemento padre:244 / Elemento actual: 245   */
      v.add(doc.createTextNode("Zona"));
      ((Element)v.get(244)).appendChild((Text)v.get(245));

      /* Termina nodo Texto:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 243   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(246)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(246)).setAttribute("ancho","40" );
      ((Element)v.get(243)).appendChild((Element)v.get(246));

      /* Elemento padre:246 / Elemento actual: 247   */
      v.add(doc.createTextNode("Region"));
      ((Element)v.get(246)).appendChild((Text)v.get(247));

      /* Termina nodo Texto:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 243   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(248)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(248)).setAttribute("ancho","60" );
      ((Element)v.get(243)).appendChild((Element)v.get(248));

      /* Elemento padre:248 / Elemento actual: 249   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(248)).appendChild((Text)v.get(249));

      /* Termina nodo Texto:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 243   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(250)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(250)).setAttribute("ancho","440" );
      ((Element)v.get(243)).appendChild((Element)v.get(250));

      /* Elemento padre:250 / Elemento actual: 251   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(250)).appendChild((Text)v.get(251));

      /* Termina nodo Texto:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 243   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(252)).setAttribute("ancho","440" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(243)).appendChild((Element)v.get(252));

      /* Elemento padre:252 / Elemento actual: 253   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(252)).appendChild((Text)v.get(253));

      /* Termina nodo Texto:253   */
      /* Termina nodo:252   */
      /* Termina nodo:243   */

      /* Empieza nodo:254 / Elemento padre: 242   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(254)).setAttribute("ancho","590" );
      ((Element)v.get(254)).setAttribute("filas","1" );
      ((Element)v.get(254)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(242)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("ancho","40" );
      ((Element)v.get(255)).setAttribute("caracteres","20" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 254   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(256)).setAttribute("ancho","60" );
      ((Element)v.get(256)).setAttribute("caracteres","20" );
      ((Element)v.get(254)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 254   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("ancho","440" );
      ((Element)v.get(257)).setAttribute("caracteres","30" );
      ((Element)v.get(254)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 254   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(258)).setAttribute("ancho","440" );
      ((Element)v.get(258)).setAttribute("caracteres","30" );
      ((Element)v.get(254)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 254   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(259)).setAttribute("ancho","440" );
      ((Element)v.get(259)).setAttribute("caracteres","30" );
      ((Element)v.get(254)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:254   */

      /* Empieza nodo:260 / Elemento padre: 242   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(242)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:13   */


   }

}

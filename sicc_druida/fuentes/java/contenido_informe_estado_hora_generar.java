
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_informe_estado_hora_generar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_informe_estado_hora_generar" );
      ((Element)v.get(0)).setAttribute("cod","0836" );
      ((Element)v.get(0)).setAttribute("titulo","Generar Informe Estado de Digitación Informe por Hora" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Generar Informe Estado de Digitación Informe por Hora" );
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
      v.add(doc.createTextNode("\r\r\r\r    function onLoad(){\r      \r      configurarMenuSecundario('Formulario');\r      focaliza('Formulario.cbMarca');\r    \r    }\r\r\r    function generar(){\r      \r      if(sicc_validaciones_generales() && validarangofechas(get('Formulario.txtFechaInicio'), get('Formulario.txtFechaFin'))){\r        \r        /*recolectarParametros();\r        set('Formulario.conectorAction', 'PEDEstadoDigitacionInformeHora');           \r        set('Formulario.accion', 'generar');\r        enviaSICC('Formulario');*/\r      \r        var a = new Object();\r        a.accion = 'generar';\r        a.marca= get('Formulario.cbMarca');\r        a.canal= get('Formulario.cbCanal');\r        a.periodo= get('Formulario.cbPeriodo');      \r        a.fechaInicio= get('Formulario.txtFechaInicio');\r        a.fechaFin=get('Formulario.txtFechaFin');\r        mostrarModalSICC('PEDEstadoDigitacionInformeHora','generar', a);\r        \r      }\r      \r    }\r\r\r    function validarangofechas(fechaInicioIngresada,fechaFinIngresada){\r    \r            a = get('Formulario.fechaInicioPeriodo');\r      vfechaInicioPeriodo = a.split(\"/\");\r      nfechaInicioPeriodo = vfechaInicioPeriodo[1] + '/' + vfechaInicioPeriodo[0] + '/' + vfechaInicioPeriodo[2];\r      f1Periodo = new Date(nfechaInicioPeriodo);\r      \r            b = fechaInicioIngresada;\r      vfechaInicioIngresada = b.split(\"/\");\r      nfechaInicioIngresada = vfechaInicioIngresada[1] + '/' + vfechaInicioIngresada[0] + '/' + vfechaInicioIngresada[2];\r      f1Ingresada = new Date(nfechaInicioIngresada);\r      \r            c = get('Formulario.fechaFinPeriodo');\r      vfechaFinPeriodo = c.split(\"/\");\r      nfechaFinPeriodo = vfechaFinPeriodo[1] + '/' + vfechaFinPeriodo[0] + '/' + vfechaFinPeriodo[2];\r      f2Periodo = new Date(nfechaFinPeriodo);\r    \r            d = fechaFinIngresada;\r      vfechaFinIngresada = d.split(\"/\");\r      nfechaFinIngresada = vfechaFinIngresada[1] + '/' + vfechaFinIngresada[0] + '/' + vfechaFinIngresada[2];\r      f2Ingresada = new Date(nfechaFinIngresada);\r      \r      \r      if (f1Ingresada > f2Ingresada){\r        \r        cdos_mostrarAlert(GestionarMensaje('936'));\r        focaliza('Formulario.txtFechaFin');\r        return false;\r      \r      }else{\r        \r        if((f1Ingresada < f1Periodo) || (f1Ingresada > f2Periodo)){\r          cdos_mostrarAlert(\"La fecha de inicio ingresada no está dentro del periodo seleccionado.\");\r          focaliza('Formulario.txtFechaInicio');\r          return false;\r        }\r        \r        if((f2Ingresada > f2Periodo) || (f2Ingresada < f1Periodo)){\r          cdos_mostrarAlert(\"La fecha de fin ingresada no está dentro del periodo seleccionado.\");\r          focaliza('Formulario.txtFechaFin');\r          return false;\r        }\r        \r        return true;\r      \r      }\r      \r      \r    }\r\r\r    function recolectarParametros(){\r      \r      set('Formulario.marca', get('Formulario.cbMarca'));\r      set('Formulario.canal', get('Formulario.cbCanal'));      \r      set('Formulario.periodo', get('Formulario.cbPeriodo'))      \r      set('Formulario.fechaInicio', get('Formulario.txtFechaInicio'));\r      set('Formulario.fechaFin', get('Formulario.txtFechaFin'));      \r      \r   }\r    \r\r    function fLimpiar(){\r      \r      var aCombo = new Array(new Array(\"\",\"\"));\r      set_combo('Formulario.cbPeriodo', aCombo, []);\r      \r      focaliza('Formulario.cbMarca'); \r      \r   }\r\r\r  function onchangeMarcaCanal(){\r  /*opcionesPeriodo = new Array();\r    set_combo('Formulario.cbPeriodo',opcionesPeriodo);         \r    \r    set('Formulario.txtFechaInicio', '');\r    set('Formulario.txtFechaFin', '');\r     \r    tipoM = get('Formulario.cbMarca','V');\r    tipoC = get('Formulario.cbCanal','V');\r    combo_add('Formulario.cbPeriodo', '', '');\r    \r    for(var k=0;k<lstPeriodo.datos.longitud;k++) {\r      for(var y=0;y<tipoM.length;y++){\r        for(var x=0;x<tipoC.length;x++){\r          if ((lstPeriodo.datos.ij(k,2) == tipoM[y])&&(lstPeriodo.datos.ij(k,3) == tipoC[x])){\r            combo_add('Formulario.cbPeriodo',lstPeriodo.datos.ij(k,0),lstPeriodo.datos.ij(k,1));\r          }\r        }\r      }\r    }*/\r     opcionesPeriodo = new Array();\r     set_combo('Formulario.cbPeriodo',opcionesPeriodo);\r     combo_add('Formulario.cbPeriodo', '', '');\r\r	 var pais = get('Formulario.pais');\r     var tipoM = get('Formulario.cbMarca','V');\r     var tipoC = get('Formulario.cbCanal','V');\r\r     var arr = new Array();\r     arr[arr.length] = ['oidPais', pais];\r     arr[arr.length] = ['marca', tipoM];\r     arr[arr.length] = ['canal', tipoC];\r	 if (tipoM!='' && tipoC!='') {\r	     recargaCombo(\"Formulario.cbPeriodo\", \"CRAObtenerPeriodos\", \"es.indra.sicc.dtos.cra.DTOPeriodo\", arr);\r     }\r	 seteoFechasDdeHta();\r  }\r\r\rfunction seteoFechasDdeHta() {\r    oidPeri = get('Formulario.cbPeriodo','V');\r  if (oidPeri != ''){\r      /*for(var k=0;k<lstPeriodo.datos.longitud;k++) {\r          if (lstPeriodo.datos.ij(k,0) == oidPeri[0]) {\r            set('Formulario.txtFechaInicio', lstPeriodo.datos.ij(k,4));\r            set('Formulario.fechaInicioPeriodo', lstPeriodo.datos.ij(k,4));\r            set('Formulario.txtFechaFin', lstPeriodo.datos.ij(k,5));\r            set('Formulario.fechaFinPeriodo', lstPeriodo.datos.ij(k,5));\r            break;\r          }\r        }*/\r	var pais = get('Formulario.pais');\r    var arr = new Array();\r    arr[arr.length] = ['oid', oidPeri];\r    arr[arr.length] = ['oidPais', pais];\r	var datos = new Array();\r    recargaCombo(\"Formulario.cbPeriodo\", \"CRAobtieneFechasPeriodo\",\"es.indra.sicc.dtos.cra.DTOPeriodo\", arr,\"salidaRecarga(datos)\");    \r  }else{\r        set('Formulario.txtFechaInicio', '');\r        set('Formulario.txtFechaFin', '');\r  }\r}\r\rfunction salidaRecarga( datos )	{\r	 \r		var formato = get('Formulario.formatoFecha').toLowerCase();\r    set('Formulario.txtFechaInicio', formateaFechaJava( datos[0][0], formato) );\r    set('Formulario.fechaInicioPeriodo', formateaFechaJava( datos[0][0], formato) );\r    set('Formulario.txtFechaFin', formateaFechaJava( datos[0][1], formato) );\r    set('Formulario.fechaFinPeriodo', formateaFechaJava( datos[0][1], formato) );\r	return false;\r} \r\rfunction formateaFechaJava( fecha, formato )	{\r\r	var nuevaFecha;\r	if (formato=='dd/mm/yyyy')	{\r	    vfecha = fecha.split(\"-\");\r	    nuevaFecha = vfecha[2] + '/' + vfecha[1] + '/' + vfecha[0]; \r	}\r	else if (formato=='mm/dd/yyyy')	{\r	    vfecha = fecha.split(\"-\");\r	    nuevaFecha = vfecha[2] + '/' + vfecha[0] + '/' + vfecha[1]; \r	}\r	else if (formato=='yyyy/mm/dd')	{\r	    vfecha = fecha.split(\"-\");\r	    nuevaFecha = vfecha[0] + '/' + vfecha[1] + '/' + vfecha[2]; \r	}\r	else if (formato=='dd-mm-yyyy')	{\r	    vfecha = fecha.split(\"-\");\r	    nuevaFecha = vfecha[2] + '-' + vfecha[1] + '-' + vfecha[0]; \r	}\r	else {\r		nuevaFecha = fecha;\r	}\r	return nuevaFecha;\r}\r\r    function arrayComponentes(){\r              var arr = new Array();\r              arr[arr.length]= new Array(\"cbMarca\",\"\");\r              arr[arr.length]= new Array(\"cbCanal\",\"\");\r              arr[arr.length]= new Array(\"cbPeriodo\",\"\");              \r              arr[arr.length]= new Array(\"txtFechaInicio\",\"\");\r              arr[arr.length]= new Array(\"txtFechaFin\",\"\");\r              arr[arr.length]= new Array(\"btnGenerarInforme\",\"BOTON\");\r              \r              return arr;\r          }\r          function tabGenerico(nombreComp, tipotab){       \r            var arr = arrayComponentes();\r            var tabular = false;\r            var nombreFormulario = getFormularioSICC();\r            var j = 0;\r            var k = arr.length;\r            if (tipotab != \"sh\") {\r                j = j-1;                \r                k = k-1;\r            }\r\r            while(j<k){\r                var t;\r                if(tipotab == \"sh\"){\r                  k--;\r                  t = k;\r                } else{\r                  j++;\r                  t = j;                  \r                }\r                  \r                var nombre = arr[t][0];\r                var tipo = arr[t][1];\r                if (tabular==false){\r                  if (nombreComp==nombre){\r                      tabular=true;\r                      if (tipotab == \"sh\"){\r                        if (k==0) k= arr.length;\r                      } else {\r                        if ((j+1)==arr.length)  j = -1;\r                      }\r                  }                \r                } else {\r                  try {\r                    var name = nombreFormulario+\".\"+nombre;\r                    if (tipo==\"BOTONXY\"){\r                       focalizaBotonHTML_XY(nombre);\r                    } else if (tipo==\"BOTON\") {\r                       focalizaBotonHTML(\"botonContenido\",nombre)\r                    } else {\r                       focaliza(name);\r                    }\r                    return;\r                  } catch (e) {\r                  }\r                }\r            }\r          } \r\r\r\r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","txtFechaInicio" );
      ((Element)v.get(7)).setAttribute("required","false" );
      ((Element)v.get(7)).setAttribute("cod","274" );
      ((Element)v.get(7)).setAttribute("format","F" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtFechaFin" );
      ((Element)v.get(8)).setAttribute("required","false" );
      ((Element)v.get(8)).setAttribute("cod","251" );
      ((Element)v.get(8)).setAttribute("format","F" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:6   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(9)).setAttribute("nombre","Formulario" );
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
      ((Element)v.get(11)).setAttribute("valor","PEDEstadoDigitacionInformeHora" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","idioma" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","pais" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","marca" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","canal" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","periodo" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","fechaInicio" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","fechaFin" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","fechaInicioPeriodo" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","fechaFinPeriodo" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","formatoFecha" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(25)).setAttribute("nombre","capa" );
      ((Element)v.get(9)).appendChild((Element)v.get(25));

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
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("table"));
      ((Element)v.get(44)).setAttribute("width","100%" );
      ((Element)v.get(44)).setAttribute("border","0" );
      ((Element)v.get(44)).setAttribute("align","left" );
      ((Element)v.get(44)).setAttribute("cellspacing","0" );
      ((Element)v.get(44)).setAttribute("cellpadding","0" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","8" );
   }

   private void getXML180(Document doc) {
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

      /* Empieza nodo:56 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(56));

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
      ((Element)v.get(60)).setAttribute("onchange","onchangeMarcaCanal();" );
      ((Element)v.get(60)).setAttribute("valorinicial","" );
      ((Element)v.get(60)).setAttribute("textoinicial","" );
      ((Element)v.get(60)).setAttribute("id","datosCampos" );
      ((Element)v.get(60)).setAttribute("req","N" );
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
      ((Element)v.get(64)).setAttribute("valign","top" );
      ((Element)v.get(56)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(65)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(65)).setAttribute("size","1" );
      ((Element)v.get(65)).setAttribute("multiple","N" );
      ((Element)v.get(65)).setAttribute("onchange","onchangeMarcaCanal();" );
      ((Element)v.get(65)).setAttribute("valorinicial","" );
      ((Element)v.get(65)).setAttribute("textoinicial","" );
      ((Element)v.get(65)).setAttribute("id","datosCampos" );
      ((Element)v.get(65)).setAttribute("req","N" );
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
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:56   */

      /* Empieza nodo:69 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("colspan","4" );
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
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:72 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("table"));
      ((Element)v.get(74)).setAttribute("width","100%" );
      ((Element)v.get(74)).setAttribute("border","0" );
      ((Element)v.get(74)).setAttribute("align","left" );
      ((Element)v.get(74)).setAttribute("cellspacing","0" );
      ((Element)v.get(74)).setAttribute("cellpadding","0" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));

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
      ((Element)v.get(75)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(79)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(79)).setAttribute("filas","1" );
      ((Element)v.get(79)).setAttribute("id","datosTitle" );
      ((Element)v.get(79)).setAttribute("cod","276" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","25" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(83)).setAttribute("nombre","lblFechaInicio" );
      ((Element)v.get(83)).setAttribute("filas","1" );
      ((Element)v.get(83)).setAttribute("id","datosTitle" );
      ((Element)v.get(83)).setAttribute("cod","274" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","25" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(87)).setAttribute("nombre","lblFechaFin" );
      ((Element)v.get(87)).setAttribute("filas","1" );
      ((Element)v.get(87)).setAttribute("id","datosTitle" );
      ((Element)v.get(87)).setAttribute("cod","251" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("width","100%" );
      ((Element)v.get(75)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:75   */

      /* Empieza nodo:90 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(90));

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
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(94)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(94)).setAttribute("size","1" );
      ((Element)v.get(94)).setAttribute("multiple","N" );
      ((Element)v.get(94)).setAttribute("valorinicial","" );
      ((Element)v.get(94)).setAttribute("textoinicial","" );
      ((Element)v.get(94)).setAttribute("id","datosCampos" );
      ((Element)v.get(94)).setAttribute("req","N" );
      ((Element)v.get(94)).setAttribute("ontab","tabGenerico('cbPeriodo');" );
      ((Element)v.get(94)).setAttribute("onshtab","tabGenerico('cbPeriodo','sh');" );
      ((Element)v.get(94)).setAttribute("onchange","seteoFechasDdeHta()" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:96 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","25" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(90)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(99)).setAttribute("nombre","txtFechaInicio" );
      ((Element)v.get(99)).setAttribute("id","datosCampos" );
      ((Element)v.get(99)).setAttribute("max","10" );
      ((Element)v.get(99)).setAttribute("tipo","" );
      ((Element)v.get(99)).setAttribute("onchange","" );
      ((Element)v.get(99)).setAttribute("req","N" );
      ((Element)v.get(99)).setAttribute("size","12" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(99)).setAttribute("validacion","" );
      ((Element)v.get(99)).setAttribute("ontab","tabGenerico('txtFechaInicio');" );
      ((Element)v.get(99)).setAttribute("onshtab","tabGenerico('txtFechaInicio','sh');" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","25" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(90)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(103)).setAttribute("nombre","txtFechaFin" );
      ((Element)v.get(103)).setAttribute("id","datosCampos" );
      ((Element)v.get(103)).setAttribute("max","10" );
      ((Element)v.get(103)).setAttribute("tipo","" );
      ((Element)v.get(103)).setAttribute("onchange","" );
      ((Element)v.get(103)).setAttribute("req","N" );
      ((Element)v.get(103)).setAttribute("size","12" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(103)).setAttribute("validacion","" );
      ((Element)v.get(103)).setAttribute("ontab","tabGenerico('txtFechaFin');" );
      ((Element)v.get(103)).setAttribute("onshtab","tabGenerico('txtFechaFin','sh');" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("width","100%" );
      ((Element)v.get(90)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","8" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:90   */

      /* Empieza nodo:106 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("colspan","4" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:41   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:109 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:34   */

      /* Empieza nodo:111 / Elemento padre: 26   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(26)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 111   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("table"));
      ((Element)v.get(116)).setAttribute("width","100%" );
      ((Element)v.get(116)).setAttribute("border","0" );
      ((Element)v.get(116)).setAttribute("align","center" );
      ((Element)v.get(116)).setAttribute("cellspacing","0" );
      ((Element)v.get(116)).setAttribute("cellpadding","0" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("class","botonera" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(119)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(119)).setAttribute("ID","botonContenido" );
      ((Element)v.get(119)).setAttribute("tipo","html" );
      ((Element)v.get(119)).setAttribute("accion","generar();" );
      ((Element)v.get(119)).setAttribute("estado","false" );
      ((Element)v.get(119)).setAttribute("cod","2495" );
      ((Element)v.get(119)).setAttribute("ontab","tabGenerico('btnGenerarInforme');" );
      ((Element)v.get(119)).setAttribute("onshtab","tabGenerico('btnGenerarInforme','sh');" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:120 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","12" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:111   */

      /* Empieza nodo:122 / Elemento padre: 26   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(26)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("width","12" );
      ((Element)v.get(123)).setAttribute("align","center" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","12" );
      ((Element)v.get(124)).setAttribute("height","12" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("width","756" );
      ((Element)v.get(122)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("width","12" );
      ((Element)v.get(122)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","12" );
      ((Element)v.get(128)).setAttribute("height","1" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:122   */
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:129 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(129)).setAttribute("nombre","capaPeriodo" );
      ((Element)v.get(129)).setAttribute("alto","3" );
      ((Element)v.get(129)).setAttribute("ancho","624" );
      ((Element)v.get(129)).setAttribute("colorf","" );
      ((Element)v.get(129)).setAttribute("borde","0" );
      ((Element)v.get(129)).setAttribute("imagenf","" );
      ((Element)v.get(129)).setAttribute("repeat","" );
      ((Element)v.get(129)).setAttribute("padding","" );
      ((Element)v.get(129)).setAttribute("visibilidad","visible" );
      ((Element)v.get(129)).setAttribute("contravsb","" );
      ((Element)v.get(129)).setAttribute("x","0" );
      ((Element)v.get(129)).setAttribute("y","165" );
      ((Element)v.get(129)).setAttribute("zindex","" );
      ((Element)v.get(9)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(130)).setAttribute("seleccion","boton" );
      ((Element)v.get(130)).setAttribute("nombre","lstPeriodo" );
      ((Element)v.get(130)).setAttribute("x","12" );
      ((Element)v.get(130)).setAttribute("y","10" );
      ((Element)v.get(130)).setAttribute("ancho","600" );
      ((Element)v.get(130)).setAttribute("alto","3" );
      ((Element)v.get(130)).setAttribute("multisel","-1" );
      ((Element)v.get(130)).setAttribute("incy","10" );
      ((Element)v.get(130)).setAttribute("incx","10" );
      ((Element)v.get(130)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(130)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(130)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(130)).setAttribute("accion","" );
      ((Element)v.get(130)).setAttribute("sep","|" );
      ((Element)v.get(130)).setAttribute("pixelsborde","2" );
      ((Element)v.get(130)).setAttribute("colorborde","#CCCCCC" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(131)).setAttribute("nombre","cab1" );
      ((Element)v.get(131)).setAttribute("height","20" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(132)).setAttribute("ancho","40" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Elemento padre:132 / Elemento actual: 133   */
      v.add(doc.createTextNode("Periodo"));
      ((Element)v.get(132)).appendChild((Text)v.get(133));

      /* Termina nodo Texto:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(134)).setAttribute("ancho","60" );
      ((Element)v.get(131)).appendChild((Element)v.get(134));

      /* Elemento padre:134 / Elemento actual: 135   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(134)).appendChild((Text)v.get(135));

      /* Termina nodo Texto:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(136)).setAttribute("ancho","440" );
      ((Element)v.get(131)).appendChild((Element)v.get(136));

      /* Elemento padre:136 / Elemento actual: 137   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(136)).appendChild((Text)v.get(137));

      /* Termina nodo Texto:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(138)).setAttribute("ancho","440" );
      ((Element)v.get(131)).appendChild((Element)v.get(138));

      /* Elemento padre:138 / Elemento actual: 139   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(138)).appendChild((Text)v.get(139));

      /* Termina nodo Texto:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(140)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(140)).setAttribute("ancho","440" );
      ((Element)v.get(131)).appendChild((Element)v.get(140));

      /* Elemento padre:140 / Elemento actual: 141   */
      v.add(doc.createTextNode("FechaInicio"));
      ((Element)v.get(140)).appendChild((Text)v.get(141));

      /* Termina nodo Texto:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(142)).setAttribute("ancho","440" );
      ((Element)v.get(131)).appendChild((Element)v.get(142));

      /* Elemento padre:142 / Elemento actual: 143   */
      v.add(doc.createTextNode("FechaFin"));
      ((Element)v.get(142)).appendChild((Text)v.get(143));

      /* Termina nodo Texto:143   */
      /* Termina nodo:142   */
      /* Termina nodo:131   */

      /* Empieza nodo:144 / Elemento padre: 130   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(144)).setAttribute("ancho","590" );
      ((Element)v.get(144)).setAttribute("filas","1" );
      ((Element)v.get(144)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(130)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(145)).setAttribute("ancho","40" );
      ((Element)v.get(145)).setAttribute("caracteres","20" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 144   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("ancho","60" );
      ((Element)v.get(146)).setAttribute("caracteres","20" );
      ((Element)v.get(144)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 144   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(147)).setAttribute("ancho","440" );
      ((Element)v.get(147)).setAttribute("caracteres","30" );
      ((Element)v.get(144)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 144   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("ancho","440" );
      ((Element)v.get(148)).setAttribute("caracteres","30" );
      ((Element)v.get(144)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 144   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(149)).setAttribute("ancho","440" );
      ((Element)v.get(149)).setAttribute("caracteres","30" );
      ((Element)v.get(144)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 144   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("ancho","440" );
      ((Element)v.get(150)).setAttribute("caracteres","30" );
      ((Element)v.get(144)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:144   */

      /* Empieza nodo:151 / Elemento padre: 130   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(130)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:9   */


   }

}

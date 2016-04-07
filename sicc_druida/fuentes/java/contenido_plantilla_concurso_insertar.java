
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_plantilla_concurso_insertar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_plantilla_concurso_insertar" );
      ((Element)v.get(0)).setAttribute("cod","0939" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
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
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r  \r\rvar opcionMenu;\rvar accion;\rvar cargarTiposCalificacion;\rvar cargarTiposVenta;\r\rvar cteBaseCalculoMonto;\rvar cteDirigidoAConsultora;\rvar cteBaseCalculoNumeroPedidos;\r\r function onLoadPag()   {  		 \r	opcionMenu = get(\"frmFormulario.opcionMenu\");\r\r		cteBaseCalculoMonto = get(\"frmFormulario.cteBaseCalculoMonto\");\r	cteDirigidoAConsultora = get(\"frmFormulario.cteDirigidoAConsultora\");\r	cteBaseCalculoNumeroPedidos = get(\"frmFormulario.cteBaseCalculoNumeroPedidos\");\r\r			cargarTiposCalificacion = get(\"frmFormulario.estaCargadaTiposCalificacion\");\r	cargarTiposVenta = get(\"frmFormulario.estaCargadaTiposVenta\");\r\r			if (opcionMenu == \"InsertarPlantilla\") {\r		accion('frmFormulario.cbTipoVentas','.disabled=true');\r		accion('frmFormulario.cbTipoCalificacion','.disabled=true');\r		accion('frmFormulario.ckIncremental','.disabled=true');\r	}\r		if((opcionMenu == \"ModificarPlantilla\") || (opcionMenu == \"ConsultarPlantilla\") || (opcionMenu == \"EliminarPlantilla\")) { 	  \r		reasignarDatosPantalla();\r	}\r\r	if((opcionMenu == \"ConsultarPlantilla\") || (opcionMenu == \"EliminarPlantilla\")) {\r		accion('frmFormulario.txtNombrePlantilla','.disabled=true')\r		accion('frmFormulario.cbPais','.disabled=true')\r		accion('frmFormulario.cbMarca','.disabled=true')\r		accion('frmFormulario.cbCanal','.disabled=true')\r		accion('frmFormulario.cbAcceso','.disabled=true')\r		accion('frmFormulario.ckMultinivel','.disabled=true')\r		accion('frmFormulario.ckFaseCalificacion','.disabled=true')\r		accion('frmFormulario.cbTipoCalificacion','.disabled=true')\r		accion('frmFormulario.ckIncremental','.disabled=true')\r		accion('frmFormulario.cbDirigidoA','.disabled=true')\r		accion('frmFormulario.cbBaseCalculo','.disabled=true')\r		accion('frmFormulario.ckProgramaNuevas','.disabled=true')\r		accion('frmFormulario.cbTipoVentas','.disabled=true')\r  	    accion('frmFormulario.ckAmbitoGeograficoCompleto','.disabled=true')\r		accion('frmFormulario.ckParticipacionParticipantesCompleto','.disabled=true')\r		accion('frmFormulario.ckProductosValidosCompleto','.disabled=true')\r		accion('frmFormulario.ckProductosExcluidos','.disabled=true')\r		accion('frmFormulario.ckProductosBonificados','.disabled=true')\r		accion('frmFormulario.ckProductosExigidos','.disabled=true')\r		accion('frmFormulario.ckPremiosAcumulativosPorNiveles','.disabled=true')\r		accion('frmFormulario.ckNivelesRotativos','.disabled=true')\r		accion('frmFormulario.ckPremiosElectivos','.disabled=true')\r		accion('frmFormulario.ckPuntajeServicio','.disabled=true')\r		accion('frmFormulario.ckActiva','.disabled=true')\r		accion('frmFormulario.cbTipoConcursoIVR','.disabled=true')\r\r				accion('frmFormulario.ckSorteo','.disabled=true')\r\r\r	}\r\r		accion('frmFormulario.ckBloqueado','.disabled=true')\r	onTabTipoConcurso();\r	configurarMenuSecundario(\"frmFormulario\");\r}\r\rfunction onClickIndSorteo() {\r\r	if(get('frmFormulario.ckSorteo')==\"S\"){\r\r	      if(get('frmFormulario.cbDirigidoA')== get(\"frmFormulario.cteDirigidoAConsultora\") &&\r			 get('frmFormulario.cbBaseCalculo')== get(\"frmFormulario.cteBaseCalculoMonto\") &&\r			 get('frmFormulario.cbTipoConcursoIVR')== get(\"frmFormulario.OID_TIPO_CONCURSO_VENTAS\")) {\r\r				  set('frmFormulario.ckMultinivel', 'N');     \r				  accion('frmFormulario.ckMultinivel', '.disabled=true');  \r\r				  set('frmFormulario.ckFaseCalificacion', 'N');     \r				  accion('frmFormulario.ckFaseCalificacion', '.disabled=true');  \r\r				  set('frmFormulario.ckProgramaNuevas', 'N');     \r				  accion('frmFormulario.ckProgramaNuevas', '.disabled=true');  \r\r				  set('frmFormulario.ckPremiosAcumulativosPorNiveles', 'N');     \r				  accion('frmFormulario.ckPremiosAcumulativosPorNiveles', '.disabled=true');  \r\r				  set('frmFormulario.ckNivelesRotativos', 'N');     \r				  accion('frmFormulario.ckNivelesRotativos', '.disabled=true');  \r\r				  set('frmFormulario.ckPremiosElectivos', 'N');     \r				  accion('frmFormulario.ckPremiosElectivos', '.disabled=true');  \r\r				  set('frmFormulario.ckPuntajeServicio', 'N');     \r				  accion('frmFormulario.ckPuntajeServicio', '.disabled=true');  \r\r		 } else {\r			  GestionarMensaje(\"2643\");\r			  set('frmFormulario.ckSorteo', 'N');    \r		 }\r\r    } else if(get('frmFormulario.ckSorteo')==\"N\"){\r\r          accion('frmFormulario.ckMultinivel', '.disabled=false');  \r          accion('frmFormulario.ckFaseCalificacion', '.disabled=false'); \r          accion('frmFormulario.ckProgramaNuevas', '.disabled=false');  \r          accion('frmFormulario.ckPremiosAcumulativosPorNiveles', '.disabled=false');  \r          accion('frmFormulario.ckNivelesRotativos', '.disabled=false');  \r          accion('frmFormulario.ckPremiosElectivos', '.disabled=false');  \r          accion('frmFormulario.ckPuntajeServicio', '.disabled=false');  \r	}\r}\r\rfunction onChangeDirigidoA() {\r\r	if(get('frmFormulario.cbDirigidoA')!= get(\"frmFormulario.cteDirigidoAConsultora\")){\r		set('frmFormulario.ckSorteo', 'N');    \r		onClickIndSorteo();\r	}	\r}\r\rfunction onChangeTipoConcursoIVR() {\r\r	if(get('frmFormulario.cbTipoConcursoIVR')!= get(\"frmFormulario.OID_TIPO_CONCURSO_VENTAS\")){\r		set('frmFormulario.ckSorteo', 'N');    \r		onClickIndSorteo();\r	}	\r}\r\r\rfunction reasignarDatosPantalla() {\r	 	  var plantilla = get(\"frmFormulario.oidPlantilla\");\r  	  var nombre = get(\"frmFormulario.nombreplantilla\");\r  	  var paises = get(\"frmFormulario.arraypaises\");\r  	  var marcas = get(\"frmFormulario.arraymarcas\");\r  	  var canal = get(\"frmFormulario.canal\");\r	  var accesos = get(\"frmFormulario.arrayaccesos\");\r  	  var multi = get(\"frmFormulario.multinivel\");\r  	  var fasecal = get(\"frmFormulario.fasecalificacion\");  	  \r  	  var incre = get(\"frmFormulario.incremental\");\r	  var diri = get(\"frmFormulario.dirigido\");\r	  var base = get(\"frmFormulario.basecalculo\");\r	  var pronuevas = get(\"frmFormulario.programanuevas\");\r  	  var tipoven = get(\"frmFormulario.tipoventas\");\r  	  var ambito = get(\"frmFormulario.ambitogeografico\");\r  	  var participacion = get(\"frmFormulario.participacionparticipantes\");\r  	  var productosval = get(\"frmFormulario.productosvalidos\");\r	  var productosexclu = get(\"frmFormulario.productosexcluidos\");\r  	  var productosbon = get(\"frmFormulario.productosbonificados\");\r  	  var productosexi = get(\"frmFormulario.productosexigidos\");\r  	  var premiosacu = get(\"frmFormulario.premiosacumulativos\");\r  	  var niveles = get(\"frmFormulario.nivelesrotativos\");\r	  var premioselec = get(\"frmFormulario.premioselectivos\");\r  	  var puntajeser = get(\"frmFormulario.puntajeservicio\");\r  	  var act = get(\"frmFormulario.activa\");\r  	  var tipocon = get(\"frmFormulario.tipoconcurso\");\r	  var bloqueado = get(\"frmFormulario.bloqueado\");\r\r	  	  var sorteo = get(\"frmFormulario.sorteo\");\r\r  	  \r  	  \r	  	  set(\"frmFormulario.oidPlantilla\", plantilla);\r\r	  	  set(\"frmFormulario.txtNombrePlantilla\", nombre);\r\r      	  if(paises!=\"\") {\r		  var paisesSeleccionados = new Array();\r		  paisesSeleccionados = paises.split(\",\");	  \r		  set(\"frmFormulario.cbPais\", paisesSeleccionados);\r	  }\r\r	    	  var marcasSeleccionadas = new Array();\r	  marcasSeleccionadas = marcas.split(\",\");	  \r	  set(\"frmFormulario.cbMarca\", marcasSeleccionadas);\r\r	  	  var canalesSeleccionados = new Array();\r	  canalesSeleccionados = canal.split(\",\");	  \r	  set(\"frmFormulario.cbCanal\", canalesSeleccionados);\r\r	  	  recargaComboAccesoModificacion();\r\r	   	  set(\"frmFormulario.ckMultinivel\", multi);\r\r	     	  set(\"frmFormulario.ckFaseCalificacion\", fasecal);\r\r	  	  set(\"frmFormulario.ckIncremental\", incre);\r\r   	  	  var diriSeleccionados = new Array();\r	  diriSeleccionados = diri.split(\",\");	  \r	  set(\"frmFormulario.cbDirigidoA\", diriSeleccionados);\r\r	  	  var baseCalculoSeleccionada = new Array();\r	  baseCalculoSeleccionada = base.split(\",\");	  \r  	  set(\"frmFormulario.cbBaseCalculo\", baseCalculoSeleccionada);\r\r	  	  set(\"frmFormulario.ckProgramaNuevas\", pronuevas);\r\r	  	  recargaComboTipoVentaModificacion();\r\r	  	  set(\"frmFormulario.ckAmbitoGeograficoCompleto\", ambito);\r\r	  	  set(\"frmFormulario.ckParticipacionParticipantesCompleto\", participacion);\r\r	  	  set(\"frmFormulario.ckProductosValidosCompleto\", productosval);\r	  	  \r	  	  set(\"frmFormulario.ckProductosExcluidos\", productosexclu);\r\r	  	  set(\"frmFormulario.ckProductosBonificados\", productosbon);\r\r	  	  set(\"frmFormulario.ckProductosExigidos\", productosexi);\r\r	  	  set(\"frmFormulario.ckPremiosAcumulativosPorNiveles\", premiosacu);\r\r	  	  set(\"frmFormulario.ckNivelesRotativos\", niveles);\r\r	  	  set(\"frmFormulario.ckPremiosElectivos\", premioselec);\r\r	  	  set(\"frmFormulario.ckPuntajeServicio\", puntajeser);\r\r	  	  set(\"frmFormulario.ckActiva\", act);\r\r	  	  var tipoConcursoSeleccionado = new Array();\r	  tipoConcursoSeleccionado = tipocon.split(\",\");	  \r	  set(\"frmFormulario.cbTipoConcursoIVR\", tipoConcursoSeleccionado);\r\r	  	  accion('frmFormulario.cbDirigidoA','.disabled=false');			\r	\r	    	  accion('frmFormulario.cbBaseCalculo','.disabled=false')\r\r	  	  recargaComboTipoCalificacion();\r\r	  	  set(\"frmFormulario.ckBloqueado\", bloqueado);\r\r	  if(pronuevas==\"S\") {\r		accion('frmFormulario.cbDirigidoA','.disabled=true')\r		accion('frmFormulario.cbBaseCalculo','.disabled=true')\r	  }\r\r	  	  set(\"frmFormulario.ckSorteo\", sorteo);\r      onClickIndSorteo();\r\r	  }\r\rfunction recargaComboAccesoModificacion() {\r	if(get(\"frmFormulario.cbCanal\")!=\"\"){	\r		var arr = new Array();      \r		arr[arr.length] = new Array(\"oid\", get(\"frmFormulario.cbCanal\"));\r		arr[arr.length] = new Array(\"oidPais\", get(\"frmFormulario.oidPais\")); \r		arr[arr.length] = new Array(\"oidIdioma\", get(\"frmFormulario.oidIdioma\")); \r\r		recargaCombo(\"frmFormulario.cbAcceso\", 'SEGObtieneAccesosPorCanal','es.indra.sicc.util.DTOOID', arr, \"marcaComboAcceso(datos);\");\r	}\r}\r\rfunction marcaComboAcceso(datos) {\r		var datosNuevo = new Array();\r	datosNuevo[0] = [\"\",\"\"];\r\r	for (var i = 0; i < datos.length; i++ )\r		datosNuevo[i+1]  = datos[i];\r\r	set_combo(\"frmFormulario.cbAcceso\", datosNuevo);\r    \r	var accesos = get(\"frmFormulario.arrayaccesos\");\r	var accesosSeleccionados = new Array();\r	accesosSeleccionados = accesos.split(\",\");	  \r	set(\"frmFormulario.cbAcceso\", accesosSeleccionados);\r}\r\r\rfunction recargaComboTipoVentaModificacion() {\r	var baseCalculo = get(\"frmFormulario.cbBaseCalculo\");\r	if (baseCalculo == cteBaseCalculoMonto) {\r		accion('frmFormulario.cbTipoVentas','.disabled=false');		\r		if (cargarTiposVenta == \"false\") {\r			cargarTiposVenta = \"true\";\r			var arr = new Array();      \r			arr[arr.length] = new Array(\"oidPais\", get(\"frmFormulario.oidPais\")); \r			arr[arr.length] = new Array(\"oidIdioma\", get(\"frmFormulario.oidIdioma\")); \r			recargaCombo(\"frmFormulario.cbTipoVentas\", 'INCConsultaTiposVenta','es.indra.sicc.util.DTOOID', arr, \"marcaComboTipoVenta(datos);\");			\r		}\r	} else {\r		set(\"frmFormulario.cbTipoVentas\", \"\");\r		accion('frmFormulario.cbTipoVentas','.disabled=true');		\r	}\r}\r\rfunction marcaComboTipoVenta(datos) {\r		var datosNuevo = new Array();\r	datosNuevo[0] = [\"\",\"\"];\r\r	for (var i = 0; i < datos.length; i++ )\r		datosNuevo[i+1]  = datos[i];\r\r	set_combo(\"frmFormulario.cbTipoVentas\", datosNuevo);\r\r	var tipoven = get(\"frmFormulario.tipoventas\");\r    var tipoVentaSeleccionado = new Array();\r	tipoVentaSeleccionado = tipoven.split(\",\");\r	set(\"frmFormulario.cbTipoVentas\", tipoVentaSeleccionado);	\r}\r\r function recargaComboTipoCalificacion() {\r	if (get(\"frmFormulario.ckFaseCalificacion\")==\"S\") {\r		if (get(\"frmFormulario.ckMultinivel\")==\"S\") {\r			set(\"frmFormulario.ckMultinivel\", \"N\");\r		}\r		if (get(\"frmFormulario.ckProgramaNuevas\")==\"S\") {\r			set(\"frmFormulario.ckProgramaNuevas\", \"N\");\r		}\r		accion('frmFormulario.ckIncremental','.disabled=false');\r		accion('frmFormulario.cbTipoCalificacion','.disabled=false');\r		\r		if (cargarTiposCalificacion == \"false\") {\r			cargarTiposCalificacion = \"true\";\r\r			var arr = new Array();      \r			arr[arr.length] = new Array(\"oidPais\", get(\"frmFormulario.oidPais\")); \r			arr[arr.length] = new Array(\"oidIdioma\", get(\"frmFormulario.oidIdioma\")); \r			recargaCombo(\"frmFormulario.cbTipoCalificacion\", 'INCConsultaTiposCalificacion','es.indra.sicc.util.DTOOID', arr, \"marcaComboTipoCalificacion(datos);\");\r		}\r\r	} else {\r		set(\"frmFormulario.cbTipoCalificacion\", \"\");\r		accion('frmFormulario.cbTipoCalificacion','.disabled=true');\r		accion('frmFormulario.ckIncremental','.disabled=true');\r	}\r}\r\r function marcaComboTipoCalificacion(datos){\r		var datosNuevo = new Array();\r	datosNuevo[0] = [\"\",\"\"];\r\r	for (var i = 0; i < datos.length; i++ )\r		datosNuevo[i+1]  = datos[i];\r\r	set_combo(\"frmFormulario.cbTipoCalificacion\", datosNuevo);\r  \r	var tipocal = get(\"frmFormulario.tipocalificacion\");\r    var tipoCalificacionSeleccionado = new Array();\r	tipoCalificacionSeleccionado = tipocal.split(\",\");	  \r	set(\"frmFormulario.cbTipoCalificacion\", tipoCalificacionSeleccionado);\r	onChangeTipoCalificacion();\r }\r\r\rfunction onChangeCanal(){\r		if(get(\"frmFormulario.cbCanal\")!=\"\"){	\r		var arr = new Array();      \r		arr[arr.length] = new Array(\"oid\", get(\"frmFormulario.cbCanal\"));\r		arr[arr.length] = new Array(\"oidPais\", get(\"frmFormulario.oidPais\")); \r		arr[arr.length] = new Array(\"oidIdioma\", get(\"frmFormulario.oidIdioma\")); \r		recargaCombo(\"frmFormulario.cbAcceso\", 'SEGObtieneAccesosPorCanal','es.indra.sicc.util.DTOOID', arr);\r	}\r	else {\r	    var objArr = document.all['cbAcceso'];\r	    for(var i=0; i < objArr.length; i++){\r		if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r			if (!objArr[i].disabled) {\r				var aCombo = new Array(new Array(\"\",\"\"));\r				set_combo('frmFormulario.cbAcceso',aCombo, []);				\r			}\r        }\r     }\r\r	}\r}\r\rfunction onChangeFaseCalificacion() {\r	if (get(\"frmFormulario.ckFaseCalificacion\")==\"S\") {\r				accion('frmFormulario.cbDirigidoA','.disabled=false');\r		accion('frmFormulario.cbBaseCalculo','.disabled=false');\r\r		if (get(\"frmFormulario.ckMultinivel\")==\"S\") {\r			set(\"frmFormulario.ckMultinivel\", \"N\");\r		}\r		if (get(\"frmFormulario.ckProgramaNuevas\")==\"S\") {\r			set(\"frmFormulario.ckProgramaNuevas\", \"N\");\r		}\r		accion('frmFormulario.ckIncremental','.disabled=false');\r		accion('frmFormulario.cbTipoCalificacion','.disabled=false');\r		\r\r		if (cargarTiposCalificacion == \"false\") {\r			cargarTiposCalificacion = \"true\";\r\r			var arr = new Array();      \r			arr[arr.length] = new Array(\"oidPais\", get(\"frmFormulario.oidPais\")); \r			arr[arr.length] = new Array(\"oidIdioma\", get(\"frmFormulario.oidIdioma\")); \r			recargaCombo(\"frmFormulario.cbTipoCalificacion\", 'INCConsultaTiposCalificacion','es.indra.sicc.util.DTOOID', arr);\r		}\r\r	} else {\r		set(\"frmFormulario.cbTipoCalificacion\", \"\");\r		accion('frmFormulario.cbTipoCalificacion','.disabled=true');\r		accion('frmFormulario.ckIncremental','.disabled=true');\r		accion('frmFormulario.cbDirigidoA','.disabled=false');\r\r				set(\"frmFormulario.ckIncremental\",\"N\");\r	}\r}\r\rfunction onChangeMultinivel(){\r	if (get(\"frmFormulario.ckMultinivel\")==\"S\") {\r				set(\"frmFormulario.cbTipoCalificacion\", \"\");\r		accion('frmFormulario.cbTipoCalificacion','.disabled=true');\r		accion('frmFormulario.ckIncremental','.disabled=true');\r\r				set(\"frmFormulario.ckIncremental\",\"N\");\r\r				accion('frmFormulario.cbDirigidoA','.disabled=false');\r		accion('frmFormulario.cbBaseCalculo','.disabled=false');\r\r		if (get(\"frmFormulario.ckFaseCalificacion\")==\"S\") {	\r			set(\"frmFormulario.ckFaseCalificacion\", \"N\");\r		}\r		if (get(\"frmFormulario.ckProgramaNuevas\")==\"S\") {	\r			set(\"frmFormulario.ckProgramaNuevas\", \"N\");\r		}\r	}\r}\r\rfunction onChangeBaseCalculo() {\r	var baseCalculo = get(\"frmFormulario.cbBaseCalculo\");\r	if (baseCalculo == cteBaseCalculoMonto) {\r		accion('frmFormulario.cbTipoVentas','.disabled=false');		\r		if (cargarTiposVenta == \"false\") {\r			cargarTiposVenta = \"true\";\r			var arr = new Array();      \r			arr[arr.length] = new Array(\"oidPais\", get(\"frmFormulario.oidPais\")); \r			arr[arr.length] = new Array(\"oidIdioma\", get(\"frmFormulario.oidIdioma\")); \r			recargaCombo(\"frmFormulario.cbTipoVentas\", 'INCConsultaTiposVenta','es.indra.sicc.util.DTOOID', arr);			\r		}\r	} else {\r		set(\"frmFormulario.cbTipoVentas\", \"\");\r		accion('frmFormulario.cbTipoVentas','.disabled=true');		\r\r        		set('frmFormulario.ckSorteo', 'N');    \r		onClickIndSorteo();\r	}\r}\r\rfunction onChangeProgramaNuevas() {\r	if (get(\"frmFormulario.ckProgramaNuevas\") ==\"S\") {\r				set(\"frmFormulario.cbTipoCalificacion\", \"\");\r		accion('frmFormulario.cbTipoCalificacion','.disabled=true');\r		accion('frmFormulario.ckIncremental','.disabled=true');\r\r		if (get(\"frmFormulario.ckFaseCalificacion\")==\"S\") {	\r			set(\"frmFormulario.ckFaseCalificacion\", \"N\");\r		}\r		if (get(\"frmFormulario.ckMultinivel\")==\"S\") {	\r			set(\"frmFormulario.ckMultinivel\", \"N\");\r		}\r\r		set(\"frmFormulario.cbDirigidoA\", new Array(cteDirigidoAConsultora));		\r		accion('frmFormulario.cbDirigidoA','.disabled=true');\r		set(\"frmFormulario.cbBaseCalculo\", new Array(cteBaseCalculoNumeroPedidos));\r		accion('frmFormulario.cbBaseCalculo','.disabled=true')\r\r				set('frmFormulario.ckSorteo', 'N');    \r		onClickIndSorteo();\r	}\r	else {\r		accion('frmFormulario.cbDirigidoA','.disabled=false');\r		accion('frmFormulario.cbBaseCalculo','.disabled=false')\r	}\r}\r\rfunction accionGuardar() {\r			if(sicc_validaciones_generales('obligatorios')) {\r		\r						if (get(\"frmFormulario.ckFaseCalificacion\")==\"S\") {\r			if(!sicc_validaciones_generales('tipoCalificacion')) {\r				return;\r			}\r		}		\r	    \r		var nombreplantilla = get(\"frmFormulario.txtNombrePlantilla\");\r\r		var paises = get(\"frmFormulario.cbPais\");\r		var arraypaises = new Array();\r		var j = 0;\r		for(var i=0; i<paises.length; i++) {\r			var temp = paises[i];\r			if(temp!='') {\r				arraypaises[j] = paises[i];\r				j++;\r			}\r		}\r\r		var marcas = get(\"frmFormulario.cbMarca\");\r		var arraymarcas = new Array();\r		var j = 0;\r		for(var i=0; i<marcas.length; i++) {\r			var temp = marcas[i];\r			if(temp!='') {\r				arraymarcas[j] = marcas[i];\r				j++;\r			}\r		}\r\r\r\r		var canal = get(\"frmFormulario.cbCanal\");\r\r		var accesos = get(\"frmFormulario.cbAcceso\");\r		var arrayaccesos = new Array();\r		var j = 0;\r		for(var i=0 ;i<accesos.length; i++) {\r			var temp = accesos[i];\r			if(temp!='') {\r				arrayaccesos[j] = accesos[i];\r				j++;\r			}\r		}\r\r\r		var multinivel = get(\"frmFormulario.ckMultinivel\");\r		var fasecalificacion = get(\"frmFormulario.ckFaseCalificacion\");\r		var tipocalificacion = get(\"frmFormulario.cbTipoCalificacion\");\r		var incremental = get(\"frmFormulario.ckIncremental\");\r		var dirigido = get(\"frmFormulario.cbDirigidoA\");\r		var basecalculo = get(\"frmFormulario.cbBaseCalculo\");\r		var programanuevas = get(\"frmFormulario.ckProgramaNuevas\");\r		var tipoventas = get(\"frmFormulario.cbTipoVentas\");\r		var ambitogeografico = get(\"frmFormulario.ckAmbitoGeograficoCompleto\");\r		var participacionparticipantes = get(\"frmFormulario.ckParticipacionParticipantesCompleto\");\r		var productosvalidos = get(\"frmFormulario.ckProductosValidosCompleto\");\r		var productosexcluidos = get(\"frmFormulario.ckProductosExcluidos\");\r		var productosbonificados = get(\"frmFormulario.ckProductosBonificados\");\r		var productosexigidos = get(\"frmFormulario.ckProductosExigidos\");\r		var premiosacumulativos = get(\"frmFormulario.ckPremiosAcumulativosPorNiveles\");\r		var nivelesrotativos = get(\"frmFormulario.ckNivelesRotativos\");\r		var premioselectivos = get(\"frmFormulario.ckPremiosElectivos\");\r		var puntajeservicio = get(\"frmFormulario.ckPuntajeServicio\");\r		var activa = get(\"frmFormulario.ckActiva\");\r		var tipoconcurso = get(\"frmFormulario.cbTipoConcursoIVR\");\r        	    var sorteo = get(\"frmFormulario.ckSorteo\");	\r\r		var bloqueado = get(\"frmFormulario.ckBloqueado\");\r    \r		set(\"frmFormulario.nombreplantilla\", nombreplantilla);\r		set(\"frmFormulario.arraypaises\", arraypaises);\r		set(\"frmFormulario.arraymarcas\", arraymarcas);\r		set(\"frmFormulario.canal\", canal);\r		set(\"frmFormulario.arrayaccesos\", arrayaccesos);\r		set(\"frmFormulario.multinivel\", multinivel);\r		set(\"frmFormulario.fasecalificacion\", fasecalificacion);\r		set(\"frmFormulario.tipocalificacion\", tipocalificacion);\r		set(\"frmFormulario.incremental\", incremental);\r		set(\"frmFormulario.dirigido\", dirigido);\r		set(\"frmFormulario.basecalculo\", basecalculo);\r		set(\"frmFormulario.programanuevas\", programanuevas);\r		set(\"frmFormulario.tipoventas\", tipoventas);\r		set(\"frmFormulario.ambitogeografico\", ambitogeografico);\r		set(\"frmFormulario.participacionparticipantes\", participacionparticipantes);\r		set(\"frmFormulario.productosvalidos\", productosvalidos);\r		set(\"frmFormulario.productosexcluidos\", productosexcluidos);\r		set(\"frmFormulario.productosbonificados\", productosbonificados);\r		set(\"frmFormulario.productosexigidos\", productosexigidos);\r		set(\"frmFormulario.premiosacumulativos\", premiosacumulativos);\r		set(\"frmFormulario.nivelesrotativos\", nivelesrotativos);\r		set(\"frmFormulario.premioselectivos\", premioselectivos);\r		set(\"frmFormulario.puntajeservicio\", puntajeservicio);\r		set(\"frmFormulario.activa\", activa);\r		set(\"frmFormulario.tipoconcurso\", tipoconcurso);\r		        set(\"frmFormulario.sorteo\", sorteo);\r\r        set(\"frmFormulario.bloqueado\", bloqueado);\r    \r		eval(\"frmFormulario\").oculto= \"S\";\r		set(\"frmFormulario.conectorAction\", \"LPMantenimientoPlantilla\");\r		set(\"frmFormulario.accion\", \"guardar\");\r		enviaSICC(\"frmFormulario\"); \r	}\r}\r\rfunction fGuardar() {\r	accionGuardar();\r}\r\rfunction onTabTipoConcurso() {\r	focaliza('frmFormulario.txtNombrePlantilla','');\r}\r\rfunction onShTabNombrePlantilla() {\r	focaliza('frmFormulario.cbTipoConcursoIVR','');\r}\r\rfunction fLimpiar() {\r	cargarTiposVenta = \"false\";\r	cargarTiposCalificacion = \"false\"; \r\r	limpiaI18N('frmFormulario', 1)\r	var opc = get(\"frmFormulario.opcionMenu\");\r\r	if(opc == \"InsertarPlantilla\") {\r		despuesLimpiar();\r	}\r	else {\r		reasignarDatosPantalla();\r	}\r\r	onTabTipoConcurso();\r}\r\rfunction reInicio() {\r	eval(\"frmFormulario\").oculto= \"N\";\r    limpiaPaginaInsertar();\r}\r\rfunction despuesLimpiar() {\r		set(\"frmFormulario.txtNombrePlantilla\",\"\");\r\r		set(\"frmFormulario.cbPais\",\"\");\r\r		set(\"frmFormulario.cbMarca\",\"\");\r\r		set(\"frmFormulario.cbCanal\",\"\");\r\r		var objArr = document.all['cbAcceso'];\r      for(var i=0; i < objArr.length; i++){\r        if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r          if (!objArr[i].disabled) {\r            var aCombo = new Array(new Array(\"\",\"\"));\r            set_combo('frmFormulario.cbAcceso',aCombo, []);				\r          }\r        }\r      }\r\r	 	 set(\"frmFormulario.ckMultinivel\",\"N\");\r\r	 	 set(\"frmFormulario.ckFaseCalificacion\",\"N\");\r\r		var objArr = document.all['cbTipoCalificacion'];\r      for(var i=0; i < objArr.length; i++){\r        if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r          if (!objArr[i].disabled) {\r            var aCombo = new Array(new Array(\"\",\"\"));\r            set_combo('frmFormulario.cbTipoCalificacion',aCombo, []);				\r          }\r        }\r      }\r		\r\r		set(\"frmFormulario.ckIncremental\",\"N\");\r	accion('frmFormulario.ckIncremental','.disabled=true');\r\r		set(\"frmFormulario.cbDirigidoA\",\"\");\r\r		set(\"frmFormulario.cbBaseCalculo\",\"\");\r\r		set(\"frmFormulario.ckProgramaNuevas\",\"N\");\r\r		var objArr = document.all['cbTipoVentas'];\r      for(var i=0; i < objArr.length; i++){\r        if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r          if (!objArr[i].disabled) {\r            var aCombo = new Array(new Array(\"\",\"\"));\r            set_combo('frmFormulario.cbTipoVentas',aCombo, []);				\r          }\r        }\r      }\r\r		set(\"frmFormulario.ckAmbitoGeograficoCompleto\",\"S\");\r\r		set(\"frmFormulario.ckParticipacionParticipantesCompleto\",\"S\");\r\r		set(\"frmFormulario.ckProductosValidosCompleto\",\"S\");\r	\r		set(\"frmFormulario.ckProductosExcluidos\",\"N\");\r\r		set(\"frmFormulario.ckProductosBonificados\",\"N\");\r\r		set(\"frmFormulario.ckProductosExigidos\",\"N\");\r\r		set(\"frmFormulario.ckPremiosAcumulativosPorNiveles\",\"S\");\r\r		set(\"frmFormulario.ckNivelesRotativos\",\"N\");\r\r		set(\"frmFormulario.ckPremiosElectivos\",\"N\");\r\r		set(\"frmFormulario.ckPuntajeServicio\",\"N\");\r\r		set(\"frmFormulario.ckActiva\",\"N\");\r\r        set(\"frmFormulario.ckSorteo\",\"N\");\r	onClickIndSorteo();\r	\r		set(\"frmFormulario.cbTipoConcursoIVR\",\"\");\r\r			accion('frmFormulario.cbTipoVentas','.disabled=true');\r	accion('frmFormulario.cbTipoCalificacion','.disabled=true');\r	accion('frmFormulario.ckIncremental','.disabled=true');\r\r			accion('frmFormulario.cbDirigidoA','.disabled=false')\r	accion('frmFormulario.cbBaseCalculo','.disabled=false')\r}\r\rfunction limpiaPaginaInsertar() {\r		despuesLimpiar();	\r	limpiaI18N('frmFormulario', 1)\r	onLoadPag();\r}\r\rfunction reModifica() {\r	eval(\"frmFormulario\").oculto= \"N\";\r    window.close();\r}\r\rfunction fErrorAlGuardarI() {\r	onTabTipoConcurso();\r}\r\rfunction fErrorAlGuardarM() {\r	onTabTipoConcurso();\r}\r\rfunction fVolver() {\r	window.close();\r}\r\rfunction onChangeTipoCalificacion() {\r	var valorElegido = get(\"frmFormulario.cbTipoCalificacion\");\r\r	if(valorElegido==get(\"frmFormulario.OID_TIPO_CALIF_PROYECTADA\")) {\r		var arraySeteo = new Array();\r		arraySeteo[0] = get(\"frmFormulario.OID_DIRIGIDO_A_GERENTE\");\r		set(\"frmFormulario.cbDirigidoA\", arraySeteo);\r		accion('frmFormulario.cbDirigidoA','.disabled=true');\r	}	\r	else {\r		accion('frmFormulario.cbDirigidoA','.disabled=false');\r	}\r}\r\rfunction onClickProductosValidos() {\r	if (get(\"frmFormulario.ckProductosValidosCompleto\")==\"S\") {\r		set(\"frmFormulario.ckProductosExcluidos\", \"N\");\r		set(\"frmFormulario.ckProductosBonificados\", \"N\");\r		set(\"frmFormulario.ckProductosExigidos\", \"N\");\r\r		accion('frmFormulario.ckProductosExcluidos','.disabled=true');\r		accion('frmFormulario.ckProductosBonificados','.disabled=true');\r		accion('frmFormulario.ckProductosExigidos','.disabled=true');\r	}\r	else {\r		accion('frmFormulario.ckProductosExcluidos','.disabled=false');\r		accion('frmFormulario.ckProductosBonificados','.disabled=false');\r		accion('frmFormulario.ckProductosExigidos','.disabled=false');\r	}\r}\r\r   \r  "));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtNombrePlantilla" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","743" );
      ((Element)v.get(8)).setAttribute("group","obligatorios" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbMarca" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","6" );
      ((Element)v.get(9)).setAttribute("group","obligatorios" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbCanal" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","7" );
      ((Element)v.get(10)).setAttribute("group","obligatorios" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbAcceso" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","10" );
      ((Element)v.get(11)).setAttribute("group","obligatorios" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbDirigidoA" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","1626" );
      ((Element)v.get(12)).setAttribute("group","obligatorios" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbTipoCalificacion" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","2799" );
      ((Element)v.get(13)).setAttribute("group","tipoCalificacion" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:7   */

      /* Empieza nodo:14 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(14)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","accion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","oidPais" );
      ((Element)v.get(20)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(14)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","estaCargadaTiposVenta" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","estaCargadaTiposCalificacion" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","cteBaseCalculoMonto" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","cteDirigidoAConsultora" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","cteBaseCalculoNumeroPedidos" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","oidPlantilla" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","nombreplantilla" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","arraypaises" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","arraymarcas" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","canal" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","arrayaccesos" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","multinivel" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","fasecalificacion" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","tipocalificacion" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","incremental" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","dirigido" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","basecalculo" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","programanuevas" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","tipoventas" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","ambitogeografico" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","participacionparticipantes" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(43)).setAttribute("nombre","productosvalidos" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","productosexcluidos" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","productosbonificados" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","productosexigidos" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","premiosacumulativos" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","nivelesrotativos" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","premioselectivos" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","puntajeservicio" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","activa" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","tipoconcurso" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","sorteo" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","bloqueado" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","OID_TIPO_CALIF_PROYECTADA" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","OID_DIRIGIDO_A_GERENTE" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","OID_TIPO_CONCURSO_VENTAS" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(58)).setAttribute("nombre","capa1" );
      ((Element)v.get(58)).setAttribute("x","0" );
      ((Element)v.get(58)).setAttribute("y","0" );
      ((Element)v.get(14)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("table"));
      ((Element)v.get(59)).setAttribute("width","100%" );
      ((Element)v.get(59)).setAttribute("border","0" );
      ((Element)v.get(59)).setAttribute("cellspacing","0" );
      ((Element)v.get(59)).setAttribute("cellpadding","0" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","12" );
      ((Element)v.get(61)).setAttribute("align","center" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","12" );
      ((Element)v.get(62)).setAttribute("height","12" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","750" );
      ((Element)v.get(60)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","12" );
      ((Element)v.get(60)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","12" );
      ((Element)v.get(66)).setAttribute("height","1" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:60   */

      /* Empieza nodo:67 / Elemento padre: 59   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(59)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(72)).setAttribute("class","legend" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(73)).setAttribute("nombre","lblDatosAlta" );
      ((Element)v.get(73)).setAttribute("alto","13" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(73)).setAttribute("id","legend" );
      ((Element)v.get(73)).setAttribute("cod","00125" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 71   */
      v.add(doc.createElement("table"));
      ((Element)v.get(74)).setAttribute("width","100%" );
      ((Element)v.get(74)).setAttribute("border","0" );
      ((Element)v.get(74)).setAttribute("align","center" );
      ((Element)v.get(74)).setAttribute("cellspacing","0" );
      ((Element)v.get(74)).setAttribute("cellpadding","0" );
      ((Element)v.get(71)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("colspan","3" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","8" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:78 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(78));

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
      ((Element)v.get(81)).setAttribute("colspan","3" );
      ((Element)v.get(78)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(82)).setAttribute("nombre","lblNombrePlantilla" );
      ((Element)v.get(82)).setAttribute("alto","13" );
      ((Element)v.get(82)).setAttribute("filas","1" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(82)).setAttribute("id","datosTitle" );
      ((Element)v.get(82)).setAttribute("cod","743" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("width","100%" );
      ((Element)v.get(78)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:78   */

      /* Empieza nodo:85 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(85));

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
      ((Element)v.get(85)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(89)).setAttribute("nombre","txtNombrePlantilla" );
      ((Element)v.get(89)).setAttribute("id","datosCampos" );
      ((Element)v.get(89)).setAttribute("max","75" );
      ((Element)v.get(89)).setAttribute("tipo","" );
      ((Element)v.get(89)).setAttribute("onchange","" );
      ((Element)v.get(89)).setAttribute("req","N" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(89)).setAttribute("size","75" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(89)).setAttribute("validacion","" );
      ((Element)v.get(89)).setAttribute("onshtab","onShTabNombrePlantilla();" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(93)).setAttribute("onclick","levantarI18N('frmFormulario','1');" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("width","100%" );
      ((Element)v.get(85)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","8" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:85   */

      /* Empieza nodo:96 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("colspan","3" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","8" );
      ((Element)v.get(98)).setAttribute("height","7" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:74   */

      /* Empieza nodo:99 / Elemento padre: 71   */
      v.add(doc.createElement("table"));
      ((Element)v.get(99)).setAttribute("width","100%" );
      ((Element)v.get(99)).setAttribute("border","0" );
      ((Element)v.get(99)).setAttribute("align","center" );
      ((Element)v.get(99)).setAttribute("cellspacing","0" );
      ((Element)v.get(99)).setAttribute("cellpadding","0" );
      ((Element)v.get(71)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","8" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(104)).setAttribute("nombre","lblPais" );
      ((Element)v.get(104)).setAttribute("alto","13" );
      ((Element)v.get(104)).setAttribute("filas","1" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(104)).setAttribute("id","datosTitle" );
      ((Element)v.get(104)).setAttribute("cod","5" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","25" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(108)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(108)).setAttribute("alto","13" );
      ((Element)v.get(108)).setAttribute("filas","1" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(108)).setAttribute("id","datosTitle" );
      ((Element)v.get(108)).setAttribute("cod","6" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("width","100%" );
      ((Element)v.get(100)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","8" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:100   */

      /* Empieza nodo:111 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","8" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(111)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(115)).setAttribute("nombre","cbPais" );
      ((Element)v.get(115)).setAttribute("id","datosCampos" );
      ((Element)v.get(115)).setAttribute("size","5" );
      ((Element)v.get(115)).setAttribute("multiple","S" );
      ((Element)v.get(115)).setAttribute("req","N" );
      ((Element)v.get(115)).setAttribute("valorinicial","" );
      ((Element)v.get(115)).setAttribute("textoinicial","" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:117 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","25" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(111)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(120)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(120)).setAttribute("id","datosCampos" );
      ((Element)v.get(120)).setAttribute("size","5" );
      ((Element)v.get(120)).setAttribute("multiple","S" );
      ((Element)v.get(120)).setAttribute("req","S" );
      ((Element)v.get(120)).setAttribute("valorinicial","" );
      ((Element)v.get(120)).setAttribute("textoinicial","" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:122 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("width","100%" );
      ((Element)v.get(111)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:111   */

      /* Empieza nodo:124 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("colspan","3" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:99   */

      /* Empieza nodo:127 / Elemento padre: 71   */
      v.add(doc.createElement("table"));
      ((Element)v.get(127)).setAttribute("width","100%" );
      ((Element)v.get(127)).setAttribute("border","0" );
      ((Element)v.get(127)).setAttribute("align","center" );
      ((Element)v.get(127)).setAttribute("cellspacing","0" );
      ((Element)v.get(127)).setAttribute("cellpadding","0" );
      ((Element)v.get(71)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));

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
      ((Element)v.get(128)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(132)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(132)).setAttribute("alto","13" );
      ((Element)v.get(132)).setAttribute("filas","1" );
      ((Element)v.get(132)).setAttribute("valor","" );
      ((Element)v.get(132)).setAttribute("id","datosTitle" );
      ((Element)v.get(132)).setAttribute("cod","7" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","25" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(136)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(136)).setAttribute("alto","13" );
      ((Element)v.get(136)).setAttribute("filas","1" );
      ((Element)v.get(136)).setAttribute("valor","" );
      ((Element)v.get(136)).setAttribute("id","datosTitle" );
      ((Element)v.get(136)).setAttribute("cod","10" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("width","100%" );
      ((Element)v.get(128)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:128   */

      /* Empieza nodo:139 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(142)).setAttribute("valign","top" );
      ((Element)v.get(139)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(143)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(143)).setAttribute("id","datosCampos" );
      ((Element)v.get(143)).setAttribute("size","1" );
      ((Element)v.get(143)).setAttribute("multiple","N" );
      ((Element)v.get(143)).setAttribute("req","S" );
      ((Element)v.get(143)).setAttribute("valorinicial","" );
      ((Element)v.get(143)).setAttribute("textoinicial","" );
      ((Element)v.get(143)).setAttribute("onchange","onChangeCanal();" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:145 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","25" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(139)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(148)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(148)).setAttribute("id","datosCampos" );
      ((Element)v.get(148)).setAttribute("size","5" );
      ((Element)v.get(148)).setAttribute("multiple","S" );
      ((Element)v.get(148)).setAttribute("req","S" );
      ((Element)v.get(148)).setAttribute("valorinicial","" );
      ((Element)v.get(148)).setAttribute("textoinicial","" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:150 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("width","100%" );
      ((Element)v.get(139)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:139   */

      /* Empieza nodo:152 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("colspan","3" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","8" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:127   */

      /* Empieza nodo:155 / Elemento padre: 71   */
      v.add(doc.createElement("table"));
      ((Element)v.get(155)).setAttribute("width","100%" );
      ((Element)v.get(155)).setAttribute("border","0" );
      ((Element)v.get(155)).setAttribute("align","center" );
      ((Element)v.get(155)).setAttribute("cellspacing","0" );
      ((Element)v.get(155)).setAttribute("cellpadding","0" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(71)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","8" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(160)).setAttribute("nombre","lblMultinivel" );
      ((Element)v.get(160)).setAttribute("alto","13" );
      ((Element)v.get(160)).setAttribute("filas","1" );
      ((Element)v.get(160)).setAttribute("valor","" );
      ((Element)v.get(160)).setAttribute("id","datosTitle" );
      ((Element)v.get(160)).setAttribute("cod","00400" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","25" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(164)).setAttribute("nombre","lblFaseCalificacion" );
      ((Element)v.get(164)).setAttribute("alto","13" );
      ((Element)v.get(164)).setAttribute("filas","1" );
      ((Element)v.get(164)).setAttribute("valor","" );
      ((Element)v.get(164)).setAttribute("id","datosTitle" );
      ((Element)v.get(164)).setAttribute("cod","2798" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","25" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(168)).setAttribute("nombre","lblTipoCalificacion" );
      ((Element)v.get(168)).setAttribute("alto","13" );
      ((Element)v.get(168)).setAttribute("filas","1" );
      ((Element)v.get(168)).setAttribute("valor","" );
      ((Element)v.get(168)).setAttribute("id","datosTitle" );
      ((Element)v.get(168)).setAttribute("cod","2799" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","25" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(172)).setAttribute("nombre","lblIncremental" );
      ((Element)v.get(172)).setAttribute("alto","13" );
      ((Element)v.get(172)).setAttribute("filas","1" );
      ((Element)v.get(172)).setAttribute("valor","" );
      ((Element)v.get(172)).setAttribute("id","datosTitle" );
      ((Element)v.get(172)).setAttribute("cod","2800" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","25" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(176)).setAttribute("nombre","lblDirigidoA" );
      ((Element)v.get(176)).setAttribute("alto","13" );
      ((Element)v.get(176)).setAttribute("filas","1" );
      ((Element)v.get(176)).setAttribute("valor","" );
      ((Element)v.get(176)).setAttribute("id","datosTitle" );
      ((Element)v.get(176)).setAttribute("cod","1626" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).setAttribute("width","100%" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(156)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","8" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:156   */

      /* Empieza nodo:179 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(183)).setAttribute("nombre","ckMultinivel" );
      ((Element)v.get(183)).setAttribute("id","datosCampos" );
      ((Element)v.get(183)).setAttribute("onclick","onChangeMultinivel();" );
      ((Element)v.get(183)).setAttribute("check","N" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","25" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(187)).setAttribute("nombre","ckFaseCalificacion" );
      ((Element)v.get(187)).setAttribute("id","datosCampos" );
      ((Element)v.get(187)).setAttribute("onclick","onChangeFaseCalificacion();" );
      ((Element)v.get(187)).setAttribute("check","N" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","25" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(179)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(191)).setAttribute("nombre","cbTipoCalificacion" );
      ((Element)v.get(191)).setAttribute("id","datosCampos" );
      ((Element)v.get(191)).setAttribute("size","1" );
      ((Element)v.get(191)).setAttribute("multiple","N" );
      ((Element)v.get(191)).setAttribute("req","N" );
      ((Element)v.get(191)).setAttribute("valorinicial","" );
      ((Element)v.get(191)).setAttribute("textoinicial","" );
      ((Element)v.get(191)).setAttribute("onchange","onChangeTipoCalificacion();" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:193 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","25" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(196)).setAttribute("nombre","ckIncremental" );
      ((Element)v.get(196)).setAttribute("id","datosCampos" );
      ((Element)v.get(196)).setAttribute("onclick","" );
      ((Element)v.get(196)).setAttribute("check","N" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","25" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(179)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(200)).setAttribute("nombre","cbDirigidoA" );
      ((Element)v.get(200)).setAttribute("id","datosCampos" );
      ((Element)v.get(200)).setAttribute("size","1" );
      ((Element)v.get(200)).setAttribute("multiple","N" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(200)).setAttribute("req","S" );
      ((Element)v.get(200)).setAttribute("onchange","onChangeDirigidoA();" );
      ((Element)v.get(200)).setAttribute("valorinicial","" );
      ((Element)v.get(200)).setAttribute("textoinicial","" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:202 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).setAttribute("width","100%" );
      ((Element)v.get(179)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","8" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:179   */

      /* Empieza nodo:204 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("colspan","3" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","8" );
      ((Element)v.get(206)).setAttribute("height","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:155   */

      /* Empieza nodo:207 / Elemento padre: 71   */
      v.add(doc.createElement("table"));
      ((Element)v.get(207)).setAttribute("width","100%" );
      ((Element)v.get(207)).setAttribute("border","0" );
      ((Element)v.get(207)).setAttribute("align","center" );
      ((Element)v.get(207)).setAttribute("cellspacing","0" );
      ((Element)v.get(207)).setAttribute("cellpadding","0" );
      ((Element)v.get(71)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).setAttribute("width","8" );
      ((Element)v.get(210)).setAttribute("height","8" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(212)).setAttribute("nombre","lblBaseCalculo" );
      ((Element)v.get(212)).setAttribute("alto","13" );
      ((Element)v.get(212)).setAttribute("filas","1" );
      ((Element)v.get(212)).setAttribute("valor","" );
      ((Element)v.get(212)).setAttribute("id","datosTitle" );
      ((Element)v.get(212)).setAttribute("cod","1181" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","25" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(216)).setAttribute("nombre","lblProgramaNuevas" );
      ((Element)v.get(216)).setAttribute("alto","13" );
      ((Element)v.get(216)).setAttribute("filas","1" );
      ((Element)v.get(216)).setAttribute("valor","" );
      ((Element)v.get(216)).setAttribute("id","datosTitle" );
      ((Element)v.get(216)).setAttribute("cod","00590" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","25" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(220)).setAttribute("nombre","lblTipoVenta" );
      ((Element)v.get(220)).setAttribute("alto","13" );
      ((Element)v.get(220)).setAttribute("filas","1" );
      ((Element)v.get(220)).setAttribute("valor","" );
      ((Element)v.get(220)).setAttribute("id","datosTitle" );
      ((Element)v.get(220)).setAttribute("cod","1622" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","25" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(224)).setAttribute("nombre","lblAmbitoGeograficoCompleto" );
      ((Element)v.get(224)).setAttribute("alto","13" );
      ((Element)v.get(224)).setAttribute("filas","1" );
      ((Element)v.get(224)).setAttribute("valor","" );
      ((Element)v.get(224)).setAttribute("id","datosTitle" );
      ((Element)v.get(224)).setAttribute("cod","2801" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","25" );
      ((Element)v.get(226)).setAttribute("height","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(228)).setAttribute("nombre","lblParticipacionParticipantesCompleto" );
      ((Element)v.get(228)).setAttribute("alto","13" );
      ((Element)v.get(228)).setAttribute("filas","1" );
      ((Element)v.get(228)).setAttribute("valor","" );
      ((Element)v.get(228)).setAttribute("id","datosTitle" );
      ((Element)v.get(228)).setAttribute("cod","2802" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).setAttribute("width","100%" );
      ((Element)v.get(208)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","8" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:208   */

      /* Empieza nodo:231 / Elemento padre: 207   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(207)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","8" );
      ((Element)v.get(233)).setAttribute("height","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(231)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(235)).setAttribute("nombre","cbBaseCalculo" );
      ((Element)v.get(235)).setAttribute("id","datosCampos" );
      ((Element)v.get(235)).setAttribute("size","1" );
      ((Element)v.get(235)).setAttribute("multiple","N" );
      ((Element)v.get(235)).setAttribute("req","N" );
      ((Element)v.get(235)).setAttribute("valorinicial","" );
      ((Element)v.get(235)).setAttribute("textoinicial","" );
      ((Element)v.get(235)).setAttribute("onchange","onChangeBaseCalculo();" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:237 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","25" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(240)).setAttribute("nombre","ckProgramaNuevas" );
      ((Element)v.get(240)).setAttribute("id","datosCampos" );
      ((Element)v.get(240)).setAttribute("onclick","onChangeProgramaNuevas();" );
      ((Element)v.get(240)).setAttribute("check","N" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","25" );
      ((Element)v.get(242)).setAttribute("height","8" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(231)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(244)).setAttribute("nombre","cbTipoVentas" );
      ((Element)v.get(244)).setAttribute("id","datosCampos" );
      ((Element)v.get(244)).setAttribute("size","1" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(244)).setAttribute("multiple","N" );
      ((Element)v.get(244)).setAttribute("req","N" );
      ((Element)v.get(244)).setAttribute("valorinicial","" );
      ((Element)v.get(244)).setAttribute("textoinicial","" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:246 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","25" );
      ((Element)v.get(247)).setAttribute("height","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(249)).setAttribute("nombre","ckAmbitoGeograficoCompleto" );
      ((Element)v.get(249)).setAttribute("id","datosCampos" );
      ((Element)v.get(249)).setAttribute("onclick","" );
      ((Element)v.get(249)).setAttribute("check","N" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","25" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(253)).setAttribute("nombre","ckParticipacionParticipantesCompleto" );
      ((Element)v.get(253)).setAttribute("id","datosCampos" );
      ((Element)v.get(253)).setAttribute("onclick","" );
      ((Element)v.get(253)).setAttribute("check","N" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).setAttribute("width","100%" );
      ((Element)v.get(231)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","8" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:231   */

      /* Empieza nodo:256 / Elemento padre: 207   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(207)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).setAttribute("colspan","3" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","8" );
      ((Element)v.get(258)).setAttribute("height","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:207   */

      /* Empieza nodo:259 / Elemento padre: 71   */
      v.add(doc.createElement("table"));
      ((Element)v.get(259)).setAttribute("width","100%" );
      ((Element)v.get(259)).setAttribute("border","0" );
      ((Element)v.get(259)).setAttribute("align","center" );
      ((Element)v.get(259)).setAttribute("cellspacing","0" );
      ((Element)v.get(259)).setAttribute("cellpadding","0" );
      ((Element)v.get(71)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).setAttribute("width","8" );
      ((Element)v.get(262)).setAttribute("height","8" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(264)).setAttribute("nombre","lblProductosValidosCompleto" );
      ((Element)v.get(264)).setAttribute("alto","13" );
      ((Element)v.get(264)).setAttribute("filas","1" );
      ((Element)v.get(264)).setAttribute("valor","" );
      ((Element)v.get(264)).setAttribute("id","datosTitle" );
      ((Element)v.get(264)).setAttribute("cod","00338" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","25" );
      ((Element)v.get(266)).setAttribute("height","8" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(268)).setAttribute("nombre","lblProductosExcluidos" );
      ((Element)v.get(268)).setAttribute("alto","13" );
      ((Element)v.get(268)).setAttribute("filas","1" );
      ((Element)v.get(268)).setAttribute("valor","" );
      ((Element)v.get(268)).setAttribute("id","datosTitle" );
      ((Element)v.get(268)).setAttribute("cod","00339" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(270)).setAttribute("src","b.gif" );
      ((Element)v.get(270)).setAttribute("width","25" );
      ((Element)v.get(270)).setAttribute("height","8" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:271 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(272)).setAttribute("nombre","lblProductosBonificados" );
      ((Element)v.get(272)).setAttribute("alto","13" );
      ((Element)v.get(272)).setAttribute("filas","1" );
      ((Element)v.get(272)).setAttribute("valor","" );
      ((Element)v.get(272)).setAttribute("id","datosTitle" );
      ((Element)v.get(272)).setAttribute("cod","00340" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(274)).setAttribute("width","25" );
      ((Element)v.get(274)).setAttribute("height","8" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(276)).setAttribute("nombre","lblProductosExigidos" );
      ((Element)v.get(276)).setAttribute("alto","13" );
      ((Element)v.get(276)).setAttribute("filas","1" );
      ((Element)v.get(276)).setAttribute("valor","" );
      ((Element)v.get(276)).setAttribute("id","datosTitle" );
      ((Element)v.get(276)).setAttribute("cod","00341" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).setAttribute("width","25" );
      ((Element)v.get(278)).setAttribute("height","8" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(280)).setAttribute("nombre","lblPremiosAcumulativosPorNiveles" );
      ((Element)v.get(280)).setAttribute("alto","13" );
      ((Element)v.get(280)).setAttribute("filas","1" );
      ((Element)v.get(280)).setAttribute("valor","" );
      ((Element)v.get(280)).setAttribute("id","datosTitle" );
      ((Element)v.get(280)).setAttribute("cod","1820" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:281 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).setAttribute("width","100%" );
      ((Element)v.get(260)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).setAttribute("width","8" );
      ((Element)v.get(282)).setAttribute("height","8" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */
      /* Termina nodo:260   */

      /* Empieza nodo:283 / Elemento padre: 259   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(259)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","8" );
      ((Element)v.get(285)).setAttribute("height","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(287)).setAttribute("nombre","ckProductosValidosCompleto" );
      ((Element)v.get(287)).setAttribute("id","datosCampos" );
      ((Element)v.get(287)).setAttribute("check","N" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","25" );
      ((Element)v.get(289)).setAttribute("height","8" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 283   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(291)).setAttribute("nombre","ckProductosExcluidos" );
      ((Element)v.get(291)).setAttribute("id","datosCampos" );
      ((Element)v.get(291)).setAttribute("onclick","" );
      ((Element)v.get(291)).setAttribute("check","N" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","25" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(295)).setAttribute("nombre","ckProductosBonificados" );
      ((Element)v.get(295)).setAttribute("id","datosCampos" );
      ((Element)v.get(295)).setAttribute("onclick","" );
      ((Element)v.get(295)).setAttribute("check","N" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(297)).setAttribute("src","b.gif" );
      ((Element)v.get(297)).setAttribute("width","25" );
      ((Element)v.get(297)).setAttribute("height","8" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:298 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(299)).setAttribute("nombre","ckProductosExigidos" );
      ((Element)v.get(299)).setAttribute("id","datosCampos" );
      ((Element)v.get(299)).setAttribute("onclick","" );
      ((Element)v.get(299)).setAttribute("check","N" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:300 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(301)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).setAttribute("width","25" );
      ((Element)v.get(301)).setAttribute("height","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:302 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(303)).setAttribute("nombre","ckPremiosAcumulativosPorNiveles" );
      ((Element)v.get(303)).setAttribute("id","datosCampos" );
      ((Element)v.get(303)).setAttribute("onclick","" );
      ((Element)v.get(303)).setAttribute("check","N" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:304 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(304)).setAttribute("width","100%" );
      ((Element)v.get(283)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).setAttribute("width","8" );
      ((Element)v.get(305)).setAttribute("height","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */
      /* Termina nodo:283   */

      /* Empieza nodo:306 / Elemento padre: 259   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(259)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("td"));
      ((Element)v.get(307)).setAttribute("colspan","3" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(308)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).setAttribute("width","8" );
      ((Element)v.get(308)).setAttribute("height","8" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:306   */
      /* Termina nodo:259   */

      /* Empieza nodo:309 / Elemento padre: 71   */
      v.add(doc.createElement("table"));
      ((Element)v.get(309)).setAttribute("width","100%" );
      ((Element)v.get(309)).setAttribute("border","0" );
      ((Element)v.get(309)).setAttribute("align","center" );
      ((Element)v.get(309)).setAttribute("cellspacing","0" );
      ((Element)v.get(309)).setAttribute("cellpadding","0" );
      ((Element)v.get(71)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("width","8" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(314)).setAttribute("nombre","lblNivelesRotativos" );
      ((Element)v.get(314)).setAttribute("alto","13" );
      ((Element)v.get(314)).setAttribute("filas","1" );
      ((Element)v.get(314)).setAttribute("valor","" );
      ((Element)v.get(314)).setAttribute("id","datosTitle" );
      ((Element)v.get(314)).setAttribute("cod","1822" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","25" );
      ((Element)v.get(316)).setAttribute("height","8" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(318)).setAttribute("nombre","lblPremiosElectivos" );
      ((Element)v.get(318)).setAttribute("alto","13" );
      ((Element)v.get(318)).setAttribute("filas","1" );
      ((Element)v.get(318)).setAttribute("valor","" );
      ((Element)v.get(318)).setAttribute("id","datosTitle" );
      ((Element)v.get(318)).setAttribute("cod","1942" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).setAttribute("width","25" );
      ((Element)v.get(320)).setAttribute("height","8" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:321 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(322)).setAttribute("nombre","lblPuntajeServicio" );
      ((Element)v.get(322)).setAttribute("alto","13" );
      ((Element)v.get(322)).setAttribute("filas","1" );
      ((Element)v.get(322)).setAttribute("valor","" );
      ((Element)v.get(322)).setAttribute("id","datosTitle" );
      ((Element)v.get(322)).setAttribute("cod","1833" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:323 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(324)).setAttribute("src","b.gif" );
      ((Element)v.get(324)).setAttribute("width","25" );
      ((Element)v.get(324)).setAttribute("height","8" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:325 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(326)).setAttribute("nombre","lblActiva" );
      ((Element)v.get(326)).setAttribute("alto","13" );
      ((Element)v.get(326)).setAttribute("filas","1" );
      ((Element)v.get(326)).setAttribute("valor","" );
      ((Element)v.get(326)).setAttribute("id","datosTitle" );
      ((Element)v.get(326)).setAttribute("cod","794" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:327 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","25" );
      ((Element)v.get(328)).setAttribute("height","8" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(330)).setAttribute("nombre","lblTipoConcursoIVR" );
      ((Element)v.get(330)).setAttribute("alto","13" );
      ((Element)v.get(330)).setAttribute("filas","1" );
      ((Element)v.get(330)).setAttribute("valor","" );
      ((Element)v.get(330)).setAttribute("id","datosTitle" );
      ((Element)v.get(330)).setAttribute("cod","2417" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(332)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).setAttribute("width","25" );
      ((Element)v.get(332)).setAttribute("height","8" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(334)).setAttribute("nombre","lblSorteo" );
      ((Element)v.get(334)).setAttribute("alto","13" );
      ((Element)v.get(334)).setAttribute("filas","1" );
      ((Element)v.get(334)).setAttribute("valor","" );
      ((Element)v.get(334)).setAttribute("id","datosTitle" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(334)).setAttribute("cod","3449" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","25" );
      ((Element)v.get(336)).setAttribute("height","8" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(338)).setAttribute("nombre","lblBloqueado" );
      ((Element)v.get(338)).setAttribute("alto","13" );
      ((Element)v.get(338)).setAttribute("filas","1" );
      ((Element)v.get(338)).setAttribute("valor","" );
      ((Element)v.get(338)).setAttribute("id","datosTitle" );
      ((Element)v.get(338)).setAttribute("cod","1328" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).setAttribute("width","100%" );
      ((Element)v.get(310)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","8" );
      ((Element)v.get(340)).setAttribute("height","8" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:310   */

      /* Empieza nodo:341 / Elemento padre: 309   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(309)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).setAttribute("width","8" );
      ((Element)v.get(343)).setAttribute("height","8" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(345)).setAttribute("nombre","ckNivelesRotativos" );
      ((Element)v.get(345)).setAttribute("id","datosCampos" );
      ((Element)v.get(345)).setAttribute("onclick","" );
      ((Element)v.get(345)).setAttribute("check","N" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:346 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(347)).setAttribute("src","b.gif" );
      ((Element)v.get(347)).setAttribute("width","25" );
      ((Element)v.get(347)).setAttribute("height","8" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:348 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(349)).setAttribute("nombre","ckPremiosElectivos" );
      ((Element)v.get(349)).setAttribute("id","datosCampos" );
      ((Element)v.get(349)).setAttribute("onclick","" );
      ((Element)v.get(349)).setAttribute("check","N" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */

      /* Empieza nodo:350 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(351)).setAttribute("src","b.gif" );
      ((Element)v.get(351)).setAttribute("width","25" );
      ((Element)v.get(351)).setAttribute("height","8" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:352 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(353)).setAttribute("nombre","ckPuntajeServicio" );
      ((Element)v.get(353)).setAttribute("id","datosCampos" );
      ((Element)v.get(353)).setAttribute("onclick","" );
      ((Element)v.get(353)).setAttribute("check","N" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:354 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(355)).setAttribute("src","b.gif" );
      ((Element)v.get(355)).setAttribute("width","25" );
      ((Element)v.get(355)).setAttribute("height","8" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:356 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(357)).setAttribute("nombre","ckActiva" );
      ((Element)v.get(357)).setAttribute("id","datosCampos" );
      ((Element)v.get(357)).setAttribute("onclick","" );
      ((Element)v.get(357)).setAttribute("check","N" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(341)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(359)).setAttribute("src","b.gif" );
      ((Element)v.get(359)).setAttribute("width","25" );
      ((Element)v.get(359)).setAttribute("height","8" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:360 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(360)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(341)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(361)).setAttribute("nombre","cbTipoConcursoIVR" );
      ((Element)v.get(361)).setAttribute("id","datosCampos" );
      ((Element)v.get(361)).setAttribute("size","1" );
      ((Element)v.get(361)).setAttribute("multiple","N" );
      ((Element)v.get(361)).setAttribute("req","N" );
      ((Element)v.get(361)).setAttribute("onchange","onChangeTipoConcursoIVR();" );
      ((Element)v.get(361)).setAttribute("valorinicial","" );
      ((Element)v.get(361)).setAttribute("textoinicial","" );
      ((Element)v.get(361)).setAttribute("ontab","onTabTipoConcurso();" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:363 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(364)).setAttribute("src","b.gif" );
      ((Element)v.get(364)).setAttribute("width","25" );
      ((Element)v.get(364)).setAttribute("height","8" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */

      /* Empieza nodo:365 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(366)).setAttribute("nombre","ckSorteo" );
      ((Element)v.get(366)).setAttribute("id","datosCampos" );
      ((Element)v.get(366)).setAttribute("onclick","onClickIndSorteo()" );
      ((Element)v.get(366)).setAttribute("check","N" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:367 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(368)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).setAttribute("width","25" );
      ((Element)v.get(368)).setAttribute("height","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */

      /* Empieza nodo:369 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(370)).setAttribute("nombre","ckBloqueado" );
      ((Element)v.get(370)).setAttribute("id","datosCampos" );
      ((Element)v.get(370)).setAttribute("onclick","" );
      ((Element)v.get(370)).setAttribute("check","N" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */
      /* Termina nodo:369   */

      /* Empieza nodo:371 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(371)).setAttribute("width","100%" );
      ((Element)v.get(341)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(372)).setAttribute("src","b.gif" );
      ((Element)v.get(372)).setAttribute("width","8" );
      ((Element)v.get(372)).setAttribute("height","8" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */
      /* Termina nodo:341   */

      /* Empieza nodo:373 / Elemento padre: 309   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(309)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).setAttribute("colspan","3" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(375)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).setAttribute("width","8" );
      ((Element)v.get(375)).setAttribute("height","8" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */
      /* Termina nodo:373   */
      /* Termina nodo:309   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:376 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(377)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */
      /* Termina nodo:67   */

      /* Empieza nodo:378 / Elemento padre: 59   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(59)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("td"));
      ((Element)v.get(379)).setAttribute("width","12" );
      ((Element)v.get(379)).setAttribute("align","center" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(380)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).setAttribute("width","12" );
      ((Element)v.get(380)).setAttribute("height","12" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 378   */
      v.add(doc.createElement("td"));
      ((Element)v.get(381)).setAttribute("width","756" );
      ((Element)v.get(378)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(382)).setAttribute("src","b.gif" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:383 / Elemento padre: 378   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).setAttribute("width","12" );
      ((Element)v.get(378)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(384)).setAttribute("src","b.gif" );
      ((Element)v.get(384)).setAttribute("width","12" );
      ((Element)v.get(384)).setAttribute("height","1" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */
      /* Termina nodo:378   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:14   */


   }

}

/**
* Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/ 

/*
    INDRA/CAR/PROY
    $Id: contenido_plantilla_cursos_insertar.js,v 1.1 2009/12/03 19:02:14 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'frmInsertarPlantilla';
var DTODruidaBusqueda = 'es.indra.sicc.dtos.edu.DTODruidaBusqueda';
var NombresCampos = ['Marca|COMBO','Canal|COMBO','TipoCurso|COMBO','NombreCurso|CTEXTO','ObjetivoCurso|CTEXTO',
	'ContenidoCurso|CTEXTO','AccesoInformacion|COMBO','AccesoSeleccionDM|RADIOB',
	'FrecuenciaDictado|COMBO','FechaDisponible|CTEXTO','FechaLanzamiento|CTEXTO','FechaFin|CTEXTO',
	'AlcanceGeografico|RADIOB','SubgerenciaVentas|COMBO','Region|COMBO','Zona|COMBO','Seccion|COMBO',
	'Territorio|COMBO','NOptimo|CTEXTO','TipoCliente|COMBO','Bloqueo|RADIOB','Capacitador|COMBO',
	'Relacion|CTEXTO','SubtipoCliente|COMBO','Clasificacion|COMBO','TipoClasificacion|COMBO',
	'StatusCliente|COMBO','StatusCursosExigidos|COMBO','NOrdenes|CTEXTO','PeriodoInicio|COMBO',
	'PeriodoFin|COMBO','Monto|CTEXTO','PeriodoInicioV|COMBO','PeriodoFinV|COMBO','PeriodoIngreso|COMBO',
	'FechaIngreso|CTEXTO','NCondicion|CTEXTO','FechaUltimo|CTEXTO','ProductoEntregar|COMBO',
	'NRegaloParticipantes|CTEXTO','MomentoEntregar|COMBO','CondicionPedido|RADIOB',
	'ControlMorosidad|RADIOB','DescripcionD|CTEXTO'];

//Matriz donde se almacenarán nombres para saber los campos que hay que comprobar al guardar.
var nombresValidacion = new Array();
var parametrosRecargaCombos = new Array();
var combosIndependientes = ['Marca', 'Canal', 'TipoCliente', 'StatusCliente', 'ProductoEntregar', 'FrecuenciaDictado', 'MomentoEntregar'];

// Arrays con las dependencias entre combos. Cada elemento del array puede tener dos elementos separados por |
// El primero es el nombre del combo y el segundo es una funcion que vacia todos los combos que dependen de
// este. Si el segundo esta vacio es que no hay combos que dependan de el 
var combosDepMarca = ['ValorTipoCurso|vaciaCombosDepTipoCurso','ValorStatusCursosExigidos','ValorPeriodoInicio',
		'ValorPeriodoFin','ValorPeriodoInicioV','ValorPeriodoFinV','ValorPeriodoIngreso',
		'ValorSubgerenciaVentas|vaciaCombosDepSubgerencia()'];
var combosDepTipoCurso = ['ValorCapacitador'];
var combosDepCanal = ['ValorAccesoInformacion','ValorStatusCursosExigidos','ValorPeriodoInicio','ValorPeriodoFin',
		'ValorPeriodoInicioV','ValorPeriodoFinV','ValorPeriodoIngreso',
		'ValorSubgerenciaVentas|vaciaCombosDepSubgerencia()'];
var combosDepTipoCliente = ['ValorSubtipoCliente|vaciaCombosDepSubtipoCliente()'];
var combosDepSubtipoCliente = ['ValorTipoClasificacion|vaciaCombosDepTipoClasificacion()'];
var combosDepTipoClasificacion = ['ValorClasificacion'];
var combosDepSubgerencia = ['ValorRegion|vaciaCombosDepRegion()'];
var combosDepRegion = ['ValorZona|vaciaCombosDepZona()'];
var combosDepZona = ['ValorSeccion|vaciaCombosDepSeccion()'];
var combosDepSeccion = ['ValorTerritorio'];




/* ------------------------------------------------------------------------------------------------------  */ 
function onLoadPag() {
	// Si ha habido algún error, se muestra el mensaje
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
	if (errDescripcion !='') {
		var errCodigo = get(FORMULARIO+'.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}
	
	configurarMenuSecundario(FORMULARIO);
	camposNoModificables();	
	var casoUso = get(FORMULARIO+'.casoUso').toString();
	if (casoUso == 'insertar' || casoUso == 'modificar' || casoUso == 'copiar') {
		focaliza(FORMULARIO + '.txtNombrePlantilla');
	}	
	
	
	// Se cargan los combos dependientes	
	if (casoUso != 'insertar') {
		seleccionaCursos();
		desactivaNoVisibles();
		
		// Si alcance geografico nacional es si, desactiva y pone a no 
		// visible los campos subgerencia, region, zona, sección y territorio 
		if (get(FORMULARIO+'.ValorAlcanceGeografico') == 'S') {
			onCambiaAlcance('ValorAlcanceGeografico');
		}
	}	
}


/* ------------------------------------------------------------------------------------------------------  */ 
function camposNoModificables() {
	for (var i = 0; i < NombresCampos.length; i++) {
		var modif = get(FORMULARIO + '.Modificable' + NombresCampos[i].split('|')[0]);
		
		if (modif == 'N')
			nombresValidacion[nombresValidacion.length] = NombresCampos[i].split('|')[0];
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
function seleccionaCursos() {
	// Se obtienen los cursos seleccionados 
	var statusCursos = get(FORMULARIO+'.hStatusCursosExigidos').toString();
	var seleccionados = statusCursos.split('|');
	
	if (statusCursos != '') {
		set(FORMULARIO+'.ValorStatusCursosExigidos', seleccionados);
	} 
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Desactiva obligatorio, modificable y valor para los campos que son no visibles
function desactivaNoVisibles() {
	var strNoVisibles = get(FORMULARIO+'.noVisibles').toString();
	
	if (strNoVisibles != '') {
		var camposNoVisibles = strNoVisibles.split('|');
	
		// Para cada campo no visible, se desactivan los campos obligatorio, modificable
		// y valor
		for (var i=0;i<camposNoVisibles.length;i++) {	
			var strVisible = FORMULARIO + '.Visible' + camposNoVisibles[i];
			var strObligatorio = FORMULARIO + '.Obligatorio' + camposNoVisibles[i];
			var strModificable = FORMULARIO + '.Modificable' + camposNoVisibles[i];
			var strValor = FORMULARIO + '.Valor' + camposNoVisibles[i];
		
			set(strObligatorio,'N');
			set(strModificable,'N');
			accion(strObligatorio,'.disabled=true');
			accion(strModificable,'.disabled=true');
			accion(strValor,'.disabled=true');
		}
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Carga los combos dependientes
function cargaCombosDependientes() {
	cargaCombosMarcaCanal();
	cargaCombosClientes();
	cargaCombosZonas();
	if (parametrosRecargaCombos.length > 0) {
		recargaComboMultiple(parametrosRecargaCombos); 
		parametrosRecargaCombos = new Array();
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
function seleccionaCapacitador(datos) {
	var capacitador = get(FORMULARIO+'.hCapacitador').toString();
	set_combo(FORMULARIO+'.ValorCapacitador', incluyeOpcionVacia(datos));
	set(FORMULARIO+'.ValorCapacitador', [capacitador]);
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Carga los combos que dependen de marca y canal
function cargaCombosMarcaCanal() {
	var idioma = get(FORMULARIO+'.idioma').toString();
	var pais = get(FORMULARIO+'.pais').toString();

	var marca = get(FORMULARIO+'.hMarca').toString();
	var canal = get(FORMULARIO+'.hCanal').toString();
	var tipoCurso = get(FORMULARIO+'.hTipoCurso').toString();
	var accesoInformacion = get(FORMULARIO+'.hAccesoInformacion').toString();
	var statusCursos = get(FORMULARIO+'.hStatusCursosExigidos').toString();
	var periodoInicio = get(FORMULARIO+'.hPeriodoInicio').toString();
	var periodoFin = get(FORMULARIO+'.hPeriodoFin').toString();
	var periodoInicioV = get(FORMULARIO+'.hPeriodoInicioV').toString();
	var periodoFinV = get(FORMULARIO+'.hPeriodoFinV').toString();
	var periodoIngreso = get(FORMULARIO+'.hPeriodoIngreso').toString();
	var subgerenciaVentas = get(FORMULARIO+'.hSubgerenciaVentas').toString();
	
	// Se carga el combo de tipo de curso
	if (marca != '') {
		var parametros = new Array(5);
     	parametros[0] = FORMULARIO+'.ValorTipoCurso';   
     	parametros[1] = "CMNObtieneTiposCurso";
     	parametros[2] = DTODruidaBusqueda;
     	parametros[3] = "[['oidMarca', " + marca + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     	parametros[4] = "seleccionaTipoCurso(datos)";
     	parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
		/*gestionaCombo(FORMULARIO+'.ValorTipoCurso', 'CMNObtieneTiposCurso', DTODruidaBusqueda, 
			[['oidIdioma',idioma], ['oidPais',pais], ['oidMarca', marca]], 
			'seleccionaTipoCurso(datos)', tipoCurso);*/
	}
	
	// Se carga el combo de acceso informacion
	if (canal != '') {
		var parametros = new Array(5);
     	parametros[0] = FORMULARIO+'.ValorAccesoInformacion';   
     	parametros[1] = "CMNObtieneAccesos";
     	parametros[2] = DTODruidaBusqueda;
     	parametros[3] = "[['oidCanal', " + canal + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     	parametros[4] = "seleccionaAccesoInformacion(datos)";
     	parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
		/*gestionaCombo(FORMULARIO+'.ValorAccesoInformacion', 'CMNObtieneAccesos', DTODruidaBusqueda, 
			[['oidCanal', canal], ['oidIdioma',idioma], ['oidPais',pais]], 
			'seleccionaAccesoInformacion(datos)', accesoInformacion);*/
	}
	
	// Se cargan los combos de status de cursos, periodos (los 5) y subgerencias
	if (marca != '' && canal !='') {
		var casoUso = get(FORMULARIO+'.casoUso').toString();
		if (casoUso == 'modificar' || statusCursos != '')  {
			var parametros = new Array(5);
     		parametros[0] = FORMULARIO+'.ValorStatusCursosExigidos';   
     		//SCS, se cambia por: CMNObtieneTiposCurso parametros[1] = "CMNObtieneCursos";
			parametros[1] = "CMNObtieneTiposCurso";
     		parametros[2] = DTODruidaBusqueda;
     		parametros[3] = "[['oidMarca', " + marca + "], ['oidCanal', " + canal + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     		parametros[4] = "seleccionaStatusCursos(datos)";
     		parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
			/*gestionaCombo(FORMULARIO+'.ValorStatusCursos', 'CMNObtieneCursos', DTODruidaBusqueda,
				[['oidMarca', marca],['oidCanal', canal], ['oidIdioma',idioma], ['oidPais',pais]],
				'seleccionaStatusCursos(datos)',statusCursos);*/
		}
		
		var parametros = new Array(5);
     	parametros[0] = FORMULARIO+'.ValorPeriodoInicio';   
     	parametros[1] = "CMNObtienePeriodos";
     	parametros[2] = DTODruidaBusqueda;
     	parametros[3] = "[['oidMarca', " + marca + "], ['oidCanal', " + canal + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     	parametros[4] = "seleccionaPeriodoInicio(datos)";
     	parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
		/*gestionaCombo(FORMULARIO+'.ValorPeriodoInicio', 'CMNObtienePeriodos', DTODruidaBusqueda, 
			[['oidMarca', marca],['oidCanal', canal], ['oidIdioma',idioma], ['oidPais',pais]],
			'seleccionaPeriodoInicio(datos)',periodoInicio); */

		parametros = new Array(5);
     	parametros[0] = FORMULARIO+'.ValorPeriodoFin';   
     	parametros[1] = "CMNObtienePeriodos";
     	parametros[2] = DTODruidaBusqueda;
     	parametros[3] = "[['oidMarca', " + marca + "], ['oidCanal', " + canal + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     	parametros[4] = "seleccionaPeriodoFin(datos)";
     	parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
		/*gestionaCombo(FORMULARIO+'.ValorPeriodoFin', 'CMNObtienePeriodos', DTODruidaBusqueda, 
			[['oidMarca', marca],['oidCanal', canal], ['oidIdioma',idioma], ['oidPais',pais]],
			'seleccionaPeriodoFin(datos)',periodoFin);*/
		
		parametros = new Array(5);
     	parametros[0] = FORMULARIO+'.ValorPeriodoInicioV';   
     	parametros[1] = "CMNObtienePeriodos";
     	parametros[2] = DTODruidaBusqueda;
     	parametros[3] = "[['oidMarca', " + marca + "], ['oidCanal', " + canal + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     	parametros[4] = "seleccionaPeriodoInicioV(datos)";
     	parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
		/*gestionaCombo(FORMULARIO+'.ValorPeriodoInicioV', 'CMNObtienePeriodos', DTODruidaBusqueda,
			[['oidMarca', marca],['oidCanal', canal], ['oidIdioma',idioma], ['oidPais',pais]],
			'seleccionaPeriodoInicioV(datos)',periodoInicioV);*/
		
		parametros = new Array(5);
     	parametros[0] = FORMULARIO+'.ValorPeriodoFinV';   
     	parametros[1] = "CMNObtienePeriodos";
     	parametros[2] = DTODruidaBusqueda;
     	parametros[3] = "[['oidMarca', " + marca + "], ['oidCanal', " + canal + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     	parametros[4] = "seleccionaPeriodoFinV(datos)";
     	parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
		/*gestionaCombo(FORMULARIO+'.ValorPeriodoFinV', 'CMNObtienePeriodos', DTODruidaBusqueda, 
			[['oidMarca', marca],['oidCanal', canal], ['oidIdioma',idioma], ['oidPais',pais]],
			'seleccionaPeriodoFinV(datos)',periodoFinV);*/
	
		parametros = new Array(5);
     	parametros[0] = FORMULARIO+'.ValorPeriodoIngreso';   
     	parametros[1] = "CMNObtienePeriodos";
     	parametros[2] = DTODruidaBusqueda;
     	parametros[3] = "[['oidMarca', " + marca + "], ['oidCanal', " + canal + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     	parametros[4] = "seleccionaPeriodoIngreso(datos)";
     	parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
		/*gestionaCombo(FORMULARIO+'.ValorPeriodoIngreso', 'CMNObtienePeriodos', DTODruidaBusqueda,
			[['oidMarca', marca],['oidCanal', canal], ['oidIdioma',idioma], ['oidPais',pais]],
			'seleccionaPeriodoIngreso(datos)',periodoIngreso); */
	
		parametros = new Array(5);
     	parametros[0] = FORMULARIO+'.ValorSubgerenciaVentas';   
     	parametros[1] = "CMNObtieneSubgerenciasVentas";
     	parametros[2] = DTODruidaBusqueda;
     	parametros[3] = "[['oidMarca', " + marca + "], ['oidCanal', " + canal + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     	parametros[4] = "seleccionaSubgerenciaVentas(datos)";
     	parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
		/*gestionaCombo(FORMULARIO+'.ValorSubgerenciaVentas', 'CMNObtieneSubgerenciasVentas', DTODruidaBusqueda,
			[['oidMarca', marca],['oidCanal', canal], ['oidIdioma',idioma], ['oidPais',pais]],
			'seleccionaSubgerenciaVentas(datos)',subgerenciaVentas);*/
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Incluye la opcion vacia al principio del array 
function incluyeOpcionVacia(datos) {
	var datos2 = new Array();
	datos2[0] = ['',''];
	
	for (var i=0;i<datos.length;i++) {
    	datos2[i+1] = datos[i];
	}
	return datos2;
}


/* ------------------------------------------------------------------------------------------------------  */ 
function seleccionaTipoCurso(datos) {
	var tipoCurso = get(FORMULARIO+'.hTipoCurso').toString();
	set_combo(FORMULARIO+'.ValorTipoCurso', incluyeOpcionVacia(datos));
	set(FORMULARIO+'.ValorTipoCurso', [tipoCurso]);
	
	var idioma = get(FORMULARIO+'.idioma').toString();
	var pais = get(FORMULARIO+'.pais').toString();
	
	// Se carga el combo de capacitadores
	//var tipoCurso = get(FORMULARIO+'.hTipoCurso').toString();
	var tipoCurso = get(FORMULARIO+'.ValorTipoCurso').toString();
	var capacitador = get(FORMULARIO+'.hCapacitador').toString();
	
	if (tipoCurso != '') {
		gestionaCombo(FORMULARIO+'.ValorCapacitador', 'CMNObtieneCapacitadores', DTODruidaBusqueda,
			[['oidTipoCurso', tipoCurso],  ['oidIdioma',idioma], ['oidPais',pais]],
			'seleccionaCapacitador(datos)',capacitador);
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
function seleccionaAccesoInformacion(datos) {
	var accesoInformacion = get(FORMULARIO+'.hAccesoInformacion').toString();
	set_combo(FORMULARIO+'.ValorAccesoInformacion', incluyeOpcionVacia(datos));
	set(FORMULARIO+'.ValorAccesoInformacion', [accesoInformacion]);
}

/*
function seleccionaStatusCursos(datos) {
	var statusCursos = get(FORMULARIO+'.hStatusCursos').toString();
	set_combo(FORMULARIO+'.ValorStatusCursos', incluyeOpcionVacia(datos));
	seleccionados = statusCursos.split('|');
	set(FORMULARIO+'.ValorStatusCursos', seleccionados);
}
*/

/* ------------------------------------------------------------------------------------------------------  */ 
function seleccionaStatusCursos(datos) {
	var casoUso = get(FORMULARIO+'.casoUso').toString();
	
	// Se obtienen los cursos seleccionados 
	var statusCursos = get(FORMULARIO+'.hStatusCursosExigidos').toString();
	var seleccionados = statusCursos.split('|');
	
	if (casoUso == 'consultar' || casoUso == 'eliminar') {	
		// Se crea un array solo con los valores seleccionados
		if (statusCursos != '') {
			var k=0;
			var cursos = new Array(seleccionados.length);
			for (var i=0;i<datos.length;i++) {
				for (var j=0;j<seleccionados.length;j++) {
					if (datos[i][0] == seleccionados[j]) {
						cursos[k]= datos[i];
						k++;
					}
				}
			}
			set_combo(FORMULARIO+'.ValorStatusCursosExigidos', cursos);
			set(FORMULARIO+'.ValorStatusCursosExigidos', seleccionados);
		} 
	} else {
		set_combo(FORMULARIO+'.ValorStatusCursosExigidos', incluyeOpcionVacia(datos));
		set(FORMULARIO+'.ValorStatusCursosExigidos', seleccionados);
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
function seleccionaPeriodoInicio(datos) {
	var periodoInicio = get(FORMULARIO+'.hPeriodoInicio').toString();
	set_combo(FORMULARIO+'.ValorPeriodoInicio', incluyeOpcionVacia(datos));
	set(FORMULARIO+'.ValorPeriodoInicio', [periodoInicio]);
}

function seleccionaPeriodoFin(datos) {
	var periodoFin = get(FORMULARIO+'.hPeriodoFin').toString();
	set_combo(FORMULARIO+'.ValorPeriodoFin', incluyeOpcionVacia(datos));
	set(FORMULARIO+'.ValorPeriodoFin', [periodoFin]);
}

function seleccionaPeriodoInicioV(datos) {
	var periodoInicioV = get(FORMULARIO+'.hPeriodoInicioV').toString();
	set_combo(FORMULARIO+'.ValorPeriodoInicioV', incluyeOpcionVacia(datos));
	set(FORMULARIO+'.ValorPeriodoInicioV', [periodoInicioV]);
}

function seleccionaPeriodoFinV(datos) {
	var periodoFinV = get(FORMULARIO+'.hPeriodoFinV').toString();
	set_combo(FORMULARIO+'.ValorPeriodoFinV', datos);
	set(FORMULARIO+'.ValorPeriodoFinV', [periodoFinV]);
}

function seleccionaPeriodoIngreso(datos) {
	var periodoIngreso = get(FORMULARIO+'.hPeriodoIngreso').toString();
	set_combo(FORMULARIO+'.ValorPeriodoIngreso', incluyeOpcionVacia(datos));
	set(FORMULARIO+'.ValorPeriodoIngreso', [periodoIngreso]);
}

function seleccionaSubgerenciaVentas(datos) {
	var subgerenciaVentas = get(FORMULARIO+'.hSubgerenciaVentas').toString();
	set_combo(FORMULARIO+'.ValorSubgerenciaVentas', incluyeOpcionVacia(datos));
	set(FORMULARIO+'.ValorSubgerenciaVentas', [subgerenciaVentas]);
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Carga los combos que dependen de clientes y clasificaciones
function cargaCombosClientes() {
	var idioma = get(FORMULARIO+'.idioma').toString();
	var pais = get(FORMULARIO+'.pais').toString();
	
	var tipoCliente = get(FORMULARIO+'.hTipoCliente').toString();
	var subtipoCliente = get(FORMULARIO+'.hSubtipoCliente').toString();
	var tipoClasificacion = get(FORMULARIO+'.hTipoClasificacion').toString();
	var clasificacion = get(FORMULARIO+'.hClasificacion').toString();
	
	// Se carga el combo de subtipos de cliente
	if (tipoCliente != '') {
		var parametros = new Array(5);
     	parametros[0] = FORMULARIO+'.ValorSubtipoCliente';   
     	parametros[1] = "CMNObtieneSubtiposCliente";
     	parametros[2] = DTODruidaBusqueda;
     	parametros[3] = "[['oidTipoCliente', " + tipoCliente + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     	parametros[4] = "seleccionaSubtipoCliente(datos)";
     	parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
		/*gestionaCombo(FORMULARIO+'.ValorSubtipoCliente', 'CMNObtieneSubtiposCliente', DTODruidaBusqueda,
			[['oidTipoCliente', tipoCliente], ['oidIdioma',idioma], ['oidPais',pais]],
			'seleccionaSubtipoCliente(datos)',subtipoCliente); */
	}
	
	// Se carga el combo de tipos de clasificación
	if (subtipoCliente != '') {
		var parametros = new Array(5);
     	parametros[0] = FORMULARIO+'.ValorTipoClasificacion';   
     	parametros[1] = "CMNObtieneTiposClasificacion";
     	parametros[2] = DTODruidaBusqueda;
     	parametros[3] = "[['oidSubtipoCliente', " + subtipoCliente + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     	parametros[4] = "seleccionaTipoClasificacion(datos)";
     	parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
		/*gestionaCombo(FORMULARIO+'.ValorTipoClasificacion', 'CMNObtieneTiposClasificacion', DTODruidaBusqueda,
			[['oidSubtipoCliente', subtipoCliente], ['oidIdioma',idioma], ['oidPais',pais]],
			'seleccionaTipoClasificacion(datos)',tipoClasificacion);*/
	}
	
	// Se recarga el combo de clasificaciones
	if (tipoClasificacion != '' && subtipoCliente != '') {
		var parametros = new Array(5);
     	parametros[0] = FORMULARIO+'.ValorClasificacion';   
     	parametros[1] = "CMNObtieneClasificaciones";
     	parametros[2] = DTODruidaBusqueda;
     	parametros[3] = "[['oidTipoClasificacion', " + tipoClasificacion + "], ['oidSubtipoCliente', " + subtipoCliente + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     	parametros[4] = "seleccionaClasificacion(datos)";
     	parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
		/*recargaCombo(FORMULARIO+'.ValorClasificacion', 'CMNObtieneClasificaciones', DTODruidaBusqueda, 
			[['oidTipoClasificacion', tipoClasificacion], ['oidSubtipoCliente', subtipoCliente], 
			['oidIdioma',idioma], ['oidPais',pais]],'seleccionaClasificacion(datos)',clasificacion);*/
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
function seleccionaSubtipoCliente(datos) {
	var subtipoCliente = get(FORMULARIO+'.hSubtipoCliente').toString();
	set_combo(FORMULARIO+'.ValorSubtipoCliente', incluyeOpcionVacia(datos));
	set(FORMULARIO+'.ValorSubtipoCliente', [subtipoCliente]);
}

function seleccionaTipoClasificacion(datos) {
	var tipoClasificacion = get(FORMULARIO+'.hTipoClasificacion').toString();
	set_combo(FORMULARIO+'.ValorTipoClasificacion', incluyeOpcionVacia(datos));
	set(FORMULARIO+'.ValorTipoClasificacion', [tipoClasificacion]);
}

function seleccionaClasificacion(datos) {
	var clasificacion = get(FORMULARIO+'.hClasificacion').toString();
	set_combo(FORMULARIO+'.ValorClasificacion', incluyeOpcionVacia(datos));
	set(FORMULARIO+'.ValorClasificacion', [clasificacion]);
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Carga los combos de agrupaciones geograficas
function cargaCombosZonas() {
	var subgerencia = get(FORMULARIO+'.hSubgerenciaVentas').toString();
	var region = get(FORMULARIO+'.hRegion').toString();
	var zona = get(FORMULARIO+'.hZona').toString();
	var seccion = get(FORMULARIO+'.hSeccion').toString();
	
	var idioma = get(FORMULARIO+'.idioma').toString();
	var pais = get(FORMULARIO+'.pais').toString();
	
	// Se carga el combo de regiones
	if (subgerencia != '') {
		var parametros = new Array(5);
     	parametros[0] = FORMULARIO+'.ValorRegion';   
     	parametros[1] = "CMNObtieneRegiones";
     	parametros[2] = DTODruidaBusqueda;
     	parametros[3] = "[['oidSubgerencia', " + subgerencia + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     	parametros[4] = "seleccionaRegion(datos)";
     	parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
		/*gestionaCombo(FORMULARIO+'.ValorRegion', 'CMNObtieneRegiones', DTODruidaBusqueda,
			[['oidSubgerencia', subgerencia], ['oidIdioma',idioma], ['oidPais',pais]],
			'seleccionaRegion(datos)',region);*/
	}
	// Se carga el combo de zonas
	if (region != '') {
		var parametros = new Array(5);
     	parametros[0] = FORMULARIO+'.ValorZona';   
     	parametros[1] = "CMNObtieneZonas";
     	parametros[2] = DTODruidaBusqueda;
     	parametros[3] = "[['oidRegion', " + region + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     	parametros[4] = "seleccionaZona(datos)";
     	parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
		/*gestionaCombo(FORMULARIO+'.ValorZona', 'CMNObtieneZonas', DTODruidaBusqueda,
			[['oidRegion', region], ['oidIdioma',idioma], ['oidPais',pais]],
			'seleccionaZona(datos)',zona);*/
	}

	// Se carga el combo de secciones
	if (zona != '') {
		var parametros = new Array(5);
     	parametros[0] = FORMULARIO+'.ValorSeccion';   
     	parametros[1] = "CMNObtieneSecciones";
     	parametros[2] = DTODruidaBusqueda;
     	parametros[3] = "[['oidZona', " + zona + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     	parametros[4] = "seleccionaSeccion(datos)";
     	parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
		/*gestionaCombo(FORMULARIO+'.ValorSeccion', 'CMNObtieneSecciones', DTODruidaBusqueda,
			[['oidZona', zona], ['oidIdioma',idioma], ['oidPais',pais]],
			'seleccionaSeccion(datos)',seccion);*/
	}

	// Se carga el combo de territorios
	if (seccion != '') {
		var parametros = new Array(5);
     	parametros[0] = FORMULARIO+'.ValorTerritorio';   
     	parametros[1] = "CMNObtieneTerritorios";
     	parametros[2] = DTODruidaBusqueda;
     	parametros[3] = "[['oidSeccion', " + seccion + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     	parametros[4] = "seleccionaTerritorio(datos)";
     	parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
		/*gestionaCombo(FORMULARIO+'.ValorTerritorio', 'CMNObtieneTerritorios', DTODruidaBusqueda,
			[['oidSeccion', seccion], ['oidIdioma',idioma], ['oidPais',pais]],
			'seleccionaTerritorio(datos)',territorio);*/
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
function seleccionaRegion(datos) {
	var region = get(FORMULARIO+'.hRegion').toString();
	var zona = get(FORMULARIO+'.hZona').toString();
	set_combo(FORMULARIO+'.ValorRegion', incluyeOpcionVacia(datos));
	set(FORMULARIO+'.ValorRegion', [region]);
	
	/*var idioma = get(FORMULARIO+'.idioma').toString();
	var pais = get(FORMULARIO+'.pais').toString();
	
	// Se carga el combo de zonas
	if (region != '') {
		var parametros = new Array(5);
     	parametros[0] = FORMULARIO+'.ValorZona';   
     	parametros[1] = "CMNObtieneZonas";
     	parametros[2] = DTODruidaBusqueda;
     	parametros[3] = "[['oidRegion', " + region + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     	parametros[4] = "seleccionaZona(datos)";
     	parametrosRecargaCombos[parametrosRecargaCombos.length] = parametros;
		gestionaCombo(FORMULARIO+'.ValorZona', 'CMNObtieneZonas', DTODruidaBusqueda,
			[['oidRegion', region], ['oidIdioma',idioma], ['oidPais',pais]],
			'seleccionaZona(datos)',zona);
	}*/
}


/* ------------------------------------------------------------------------------------------------------  */ 
function seleccionaZona(datos) {
	var zona = get(FORMULARIO+'.hZona').toString();
	var seccion = get(FORMULARIO+'.hSeccion').toString();
	set_combo(FORMULARIO+'.ValorZona', incluyeOpcionVacia(datos));
	set(FORMULARIO+'.ValorZona', [zona]);
	
	/*var idioma = get(FORMULARIO+'.idioma').toString();
	var pais = get(FORMULARIO+'.pais').toString();
	
	// Se carga el combo de secciones
	if (zona != '') {
		var parametros = new Array(5);
     	parametros[0] = FORMULARIO+'.ValorSeccion';   
     	parametros[1] = "CMNObtieneSecciones";
     	parametros[2] = DTODruidaBusqueda;
     	parametros[3] = "[['oidZona', " + zona + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     	parametros[4] = "seleccionaSeccion(datos)";
		gestionaCombo(FORMULARIO+'.ValorSeccion', 'CMNObtieneSecciones', DTODruidaBusqueda,
			[['oidZona', zona], ['oidIdioma',idioma], ['oidPais',pais]],
			'seleccionaSeccion(datos)',seccion);
	}*/
}


/* ------------------------------------------------------------------------------------------------------  */ 
function seleccionaSeccion(datos) {
	var seccion = get(FORMULARIO+'.hSeccion').toString();
	var territorio = get(FORMULARIO+'.hTerritorio').toString();
	set_combo(FORMULARIO+'.ValorSeccion', incluyeOpcionVacia(datos));
	set(FORMULARIO+'.ValorSeccion', [seccion]);
	
	/*var idioma = get(FORMULARIO+'.idioma').toString();
	var pais = get(FORMULARIO+'.pais').toString();
	
	// Se carga el combo de territorios
	if (seccion != '') {
		var parametros = new Array(5);
     	parametros[0] = FORMULARIO+'.ValorTerritorio';   
     	parametros[1] = "CMNObtieneTerritorios";
     	parametros[2] = DTODruidaBusqueda;
     	parametros[3] = "[['oidSeccion', " + seccion + "], ['oidIdioma'," + idioma + "], ['oidPais'," + pais + "]]";
     	parametros[4] = "seleccionaTerritorio(datos)";
		gestionaCombo(FORMULARIO+'.ValorTerritorio', 'CMNObtieneTerritorios', DTODruidaBusqueda,
			[['oidSeccion', seccion], ['oidIdioma',idioma], ['oidPais',pais]],
			'seleccionaTerritorio(datos)',territorio);
	}*/
}


/* ------------------------------------------------------------------------------------------------------  */ 
function seleccionaTerritorio(datos) {
	var territorio = get(FORMULARIO+'.hTerritorio').toString();
	set_combo(FORMULARIO+'.ValorTerritorio', incluyeOpcionVacia(datos));
	set(FORMULARIO+'.ValorTerritorio', [territorio]);
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Recarga un combo y establece su valor
function gestionaCombo(combo, idBusiness, dto, valoresEntrada, funcion, valorSeleccionar) {
	//if (eval('document.'+combo) != undefined) {
		if (valorSeleccionar != '') {
    		asignar([["COMBO", combo, "ConectorDruidaTransactionQuery", 
    			'dtoSalida.resultado_ROWSET', formarCadenaDT(idBusiness, dto, valoresEntrada), funcion]],"","");
		} else {
    		recargaCombo(combo, idBusiness, dto, valoresEntrada);
    	}
    //}
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Función que se ejecuta cuando se selecciona una marca
function onSeleccionaMarca() {

    /* Modificado por ssantana, 24/08/2006, se usan "recargaCombo" para evitar error con cadena URL mayor
	    a 2048 caracteres debido a limitacion de METHOD=GET.*/ 
	var valorMarca = get(FORMULARIO+'.ValorMarca').toString();
	var valorCanal = get(FORMULARIO+'.ValorCanal').toString();
	var idioma = get(FORMULARIO+'.idioma').toString();
	var pais = get(FORMULARIO+'.pais').toString();

	
/* var ini = new Date();*/
	vaciaCombosDepMarca();
/*	var fin = new Date();
	alert("Tiempo al limpiar: " + (fin.getTime() - ini.getTime()) );*/
	var parametrosCM = new Array(); //Vamos a cargar 7 combos
	var parametro = null;
	
	// Se cargan los combos de tipo de curso, cursos recibidos, periodos (los 5 combos) y 
	// subgerencias
	if (valorMarca != ''){
		recargaCombo(FORMULARIO+'.ValorTipoCurso', 'CMNObtieneTiposCurso', DTODruidaBusqueda,
			[['oidIdioma',idioma], ['oidPais',pais], ['oidMarca', valorMarca]]);
	}
	
	if (valorMarca != '' && valorCanal != '') {
		var arrayValores = [ ['oidMarca', valorMarca],
								    ['oidCanal', valorCanal], 
									['oidIdioma', idioma], 
									['oidPais', pais]
								  ];
    
		//Para cada combo ponemos las siguientes columnas: 
		//nombre del combo a cargar
		//idBusiness
		//DTO con ruta completa
		//Array multidimensional con los atributos y valores con los que rellena el dto   
		recargaCombo(FORMULARIO+'.ValorStatusCursosExigidos', 'CMNObtieneTiposCurso', DTODruidaBusqueda, arrayValores);
		recargaCombo(FORMULARIO+'.ValorPeriodoInicio', 'CMNObtienePeriodos', DTODruidaBusqueda, arrayValores);
		recargaCombo(FORMULARIO+'.ValorPeriodoInicioV', 'CMNObtienePeriodos', DTODruidaBusqueda, arrayValores);
		recargaCombo(FORMULARIO+'.ValorPeriodoFinV', 'CMNObtienePeriodos', DTODruidaBusqueda, arrayValores);
		recargaCombo(FORMULARIO+'.ValorPeriodoIngreso', 'CMNObtienePeriodos', DTODruidaBusqueda, arrayValores);
		recargaCombo(FORMULARIO+'.ValorPeriodoFin', 'CMNObtienePeriodos', DTODruidaBusqueda, arrayValores);
		recargaCombo(FORMULARIO+'.ValorSubgerenciaVentas', 'CMNObtieneSubgerenciasVentas', DTODruidaBusqueda, arrayValores);
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
//Recarga multiples combos, para ello recibe un array con tantas filas como combos a cargar
// cada fila debe tener las siguientes columnas: combo, idBusiness, dto, parametros
function recargaComboMultiple(parametros) {
	  var i;
	  var instruccion = "asignar([";

  	  for (i=0; i<parametros.length; ++i) {
	  	instruccion = instruccion + "['COMBO', '" + parametros[i][0] + 
	  	               "', 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET', " +
  				      "formarCadenaDT('" + parametros[i][1] + "', '" + parametros[i][2] + 
  				      "', " + parametros[i][3] + ")";
		if (parametros[i].length == 5)
			instruccion = instruccion + ", '" + parametros[i][4] + "'";

		instruccion = instruccion + "]";
  		if (i != parametros.length -1) {
  		//Si no es la ultima fila ponemos la coma que separa del siguiente array  		
  			instruccion = instruccion + ", ";
  		}
  	  }
  	  instruccion = instruccion + "]);";

  	  eval(instruccion);
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Función que se ejecuta cuando se selecciona un canal
function onSeleccionaCanal () {

    /* Modificado por ssantana, 24/08/2006, se usan "recargaCombo" para evitar error con cadena URL mayor
	    a 2048 caracteres debido a limitacion de METHOD=GET.*/ 
	var valorMarca = get(FORMULARIO+'.ValorMarca').toString();
	var valorCanal = get(FORMULARIO+'.ValorCanal').toString();
	var idioma = get(FORMULARIO+'.idioma').toString();
	var pais = get(FORMULARIO+'.pais').toString();
	
	vaciaCombosDepCanal();

	var parametrosCM = new Array(); //Vamos a cargar 7 combos
	var parametro = null;
	
	// Se recargan los combos de accesos, cursos recibidos, periodos (los 5 combos) y subgerencias
	if (valorCanal != '') {
		recargaCombo(FORMULARIO+'.ValorAccesoInformacion', 'CMNObtieneAccesos', DTODruidaBusqueda,
							[['oidCanal', valorCanal], ['oidIdioma',idioma], ['oidPais',pais]]);
	}

	if (valorMarca != '' && valorCanal != '') {			
		var arrayValores = [ ['oidMarca', valorMarca],
								    ['oidCanal', valorCanal], 
			                        ['oidIdioma',idioma], 
			                        ['oidPais',pais]
			                      ];
		recargaCombo(FORMULARIO+'.ValorStatusCursosExigidos', 'CMNObtieneTiposCurso', DTODruidaBusqueda, arrayValores);
		recargaCombo(FORMULARIO + '.ValorPeriodoInicio', 'CMNObtienePeriodos', DTODruidaBusqueda, arrayValores);
		recargaCombo(FORMULARIO + '.ValorPeriodoInicioV', 'CMNObtienePeriodos', DTODruidaBusqueda, arrayValores);
		recargaCombo(FORMULARIO + '.ValorPeriodoFinV', 'CMNObtienePeriodos', DTODruidaBusqueda, arrayValores);
		recargaCombo(FORMULARIO + '.ValorPeriodoIngreso', 'CMNObtienePeriodos', DTODruidaBusqueda, arrayValores);
		recargaCombo(FORMULARIO + '.ValorPeriodoFin', 'CMNObtienePeriodos', DTODruidaBusqueda, arrayValores);
		recargaCombo(FORMULARIO + '.ValorSubgerenciaVentas', 'CMNObtieneSubgerenciasVentas', DTODruidaBusqueda, arrayValores);
	}

}


/* ------------------------------------------------------------------------------------------------------  */ 
// Función que se ejecuta cuando se selecciona un tipo de cliente
function onSeleccionaTipoCliente() {
	var valorTipoCliente = get(FORMULARIO+'.ValorTipoCliente').toString();
	var idioma = get(FORMULARIO+'.idioma').toString();
	var pais = get(FORMULARIO+'.pais').toString();
	
	vaciaCombosDepTipoCliente();
	
	// Se recarga el combo de subtipos de cliente
	if (valorTipoCliente != '') {
		recargaCombo(FORMULARIO+'.ValorSubtipoCliente', 'CMNObtieneSubtiposCliente', DTODruidaBusqueda,
			[['oidTipoCliente', valorTipoCliente], ['oidIdioma',idioma], ['oidPais',pais]]); 
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Función que se ejecuta cuando se selecciona un subtipo de cliente
function onSeleccionaSubtipoCliente() {
	var valorSubtipoCliente = get(FORMULARIO+'.ValorSubtipoCliente').toString();
	var idioma = get(FORMULARIO+'.idioma').toString();
	var pais = get(FORMULARIO+'.pais').toString();
	
	vaciaCombosDepSubtipoCliente();
	
	// Se recarga el combo de tipos de clasificación
	if (valorSubtipoCliente != '') {
		recargaCombo(FORMULARIO+'.ValorTipoClasificacion', 'CMNObtieneTiposClasificacion', DTODruidaBusqueda,
			[['oidSubtipoCliente', valorSubtipoCliente], ['oidIdioma',idioma], ['oidPais',pais]]);
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Función que se ejecuta cuando se selecciona un tipo de clasificacion
function onSeleccionaTipoClasificacion() {
	var valorTipoClasificacion = get(FORMULARIO+'.ValorTipoClasificacion');
	var valorSubtipoCliente = get(FORMULARIO+'.ValorSubtipoCliente').toString();
	var idioma = get(FORMULARIO+'.idioma').toString();
	var pais = get(FORMULARIO+'.pais').toString();

	vaciaCombosDepTipoClasificacion();

	// Se recarga el combo de clasificaciones
	if (valorTipoClasificacion != '' && valorSubtipoCliente != '') {
		recargaCombo(FORMULARIO+'.ValorClasificacion', 'CMNObtieneClasificaciones', DTODruidaBusqueda, 
			[['oidTipoClasificacion', valorTipoClasificacion], ['oidSubtipoCliente', valorSubtipoCliente], 
			['oidIdioma',idioma], ['oidPais',pais]]);
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Función que se ejecuta cuando se selecciona una subgerencia
function onSeleccionaSubgerencia() {
	var valorSubgerencia = get(FORMULARIO+'.ValorSubgerenciaVentas').toString();
	var idioma = get(FORMULARIO+'.idioma').toString();
	var pais = get(FORMULARIO+'.pais').toString();
	
	vaciaCombosDepSubgerencia();
	
	// Se recarga el combo de regiones
	if (valorSubgerencia != '') {
		recargaCombo(FORMULARIO+'.ValorRegion', 'CMNObtieneRegiones', DTODruidaBusqueda,
			[['oidSubgerencia', valorSubgerencia], ['oidIdioma',idioma], ['oidPais',pais]]);
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Función que se ejecuta cuando se selecciona una region
function onSeleccionaRegion() {
	var valorRegion = get(FORMULARIO+'.ValorRegion').toString();
	var idioma = get(FORMULARIO+'.idioma').toString();
	var pais = get(FORMULARIO+'.pais').toString();
	
	vaciaCombosDepRegion();
	
	// Se recarga el combo de zonas
	if (valorRegion != '') {
		recargaCombo(FORMULARIO+'.ValorZona', 'CMNObtieneZonas', DTODruidaBusqueda,
			[['oidRegion', valorRegion], ['oidIdioma',idioma], ['oidPais',pais]]);
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Función que se ejecuta cuando se selecciona una zona
function onSeleccionaZona() {
	var valorZona = get(FORMULARIO+'.ValorZona').toString();
	var idioma = get(FORMULARIO+'.idioma').toString();
	var pais = get(FORMULARIO+'.pais').toString();

	vaciaCombosDepZona();
	
	// Se recarga el combo de secciones
	if (valorZona != '') {
		recargaCombo(FORMULARIO+'.ValorSeccion', 'CMNObtieneSecciones', DTODruidaBusqueda,
			[['oidZona', valorZona], ['oidIdioma',idioma], ['oidPais',pais]]);
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Función que se ejecuta cuando se selecciona una seccion
function onSeleccionaSeccion() {
	var valorSeccion = get(FORMULARIO+'.ValorSeccion').toString();
	var idioma = get(FORMULARIO+'.idioma').toString();
	var pais = get(FORMULARIO+'.pais').toString();
	
	vaciaCombosDepSeccion();
	
	// Se recarga el combo de territorios
	if (valorSeccion != '') {
		recargaCombo(FORMULARIO+'.ValorTerritorio', 'CMNObtieneTerritorios', DTODruidaBusqueda,
			[['oidSeccion', valorSeccion], ['oidIdioma',idioma], ['oidPais',pais]]);
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Función que se ejecuta cuando se selecciona un tipo de curso
function onSeleccionaTipoCurso() {
	var descripcionTipoCurso = get(FORMULARIO+'.ValorTipoCurso').toString();
	var idioma = get(FORMULARIO+'.idioma').toString();
	var pais = get(FORMULARIO+'.pais').toString();
	
	vaciaCombosDepTipoCurso();
	
	// Se recarga el combo de capacitadores
	if (descripcionTipoCurso != '') {
		recargaCombo(FORMULARIO+'.ValorCapacitador', 'CMNObtieneCapacitadores', DTODruidaBusqueda,
			[['oidTipoCurso', descripcionTipoCurso], ['oidIdioma',idioma], ['oidPais',pais]]); 
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Desactiva o activa modificable, obligatorio y valor dependiendo del valor de visible
function onVisible(visible,obligatorio,modificable,valor) {
	var strVisible = FORMULARIO + '.' + visible;
	var strObligatorio = FORMULARIO + '.' + obligatorio;
	var strModificable = FORMULARIO + '.' + modificable;
	var strValor = FORMULARIO + '.' + valor;

	// Si se desactiva el checbox visible, se deshabilitan los
	// checkbox obligatorio y modificado
	if (get(strVisible) == 'S') {
		set(strObligatorio,'S');
		set(strModificable,'S');
		accion(strObligatorio,'.disabled=false');
		accion(strModificable,'.disabled=false');
		accion(strValor,'.disabled=false');
	}else {
		set(strObligatorio,'N');
		set(strModificable,'N');
		accion(strObligatorio,'.disabled=true');
		accion(strModificable,'.disabled=true');
		accion(strValor,'.disabled=true');
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
function comprobarValor(visible,obligatorio,modificable,valor) {
	// Si el campo Visible = "Si", Obligatorio = "Si", Valor = Nulo
	// y Modificable = "No" no se debe permitir la grabación sino
	// mostrar un mensaje de error indicando "Si atributo visible, obligatorio
	// y no modificable, el valor no puede ser nulo". 
	var valorVisible = get(FORMULARIO+'.'+visible);
	var valorObligatorio = get(FORMULARIO+'.'+obligatorio);
	var valorModificable = get(FORMULARIO+'.'+modificable);
	var valorValor = get(FORMULARIO+'.'+valor);

	if (valorVisible == 'S' && valorObligatorio == 'S' && valorModificable == 'N' &&
		valorValor == '') {
		// Muestra el mensaje: Si atributo visible, obligatorio y no modificable, el valor no puede ser nulo
		GestionarMensaje('1059');		
		focaliza(FORMULARIO+'.'+valor);
		return false;
	}
	return true;
}


/* ------------------------------------------------------------------------------------------------------  */ 
function comprobarPeriodoIngreso(periodo,fecha,numero) {
	var valorPeriodo = get(FORMULARIO+'.'+periodo);
	var valorFecha = get(FORMULARIO+'.'+fecha);
	var valorNumero = get(FORMULARIO+'.'+numero);

	// El campo "Período de ingreso condición" es excluyente con los campos
	// "Fecha de ingreso condición" y "Número de períodos condición". Si se
	// introduce, se desactivan los otros dos
	if (valorPeriodo != '' && (valorFecha != '' || valorNumero !='')) {
		set(FORMULARIO+'.'+fecha,'');
		set(FORMULARIO+'.'+numero,'');
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
function comprobarFechaIngreso(fecha,periodo,numero) {
	var valorFecha = get(FORMULARIO+'.'+fecha);
	var valorPeriodo = get(FORMULARIO+'.'+periodo);
	var valorNumero = get(FORMULARIO+'.'+numero);

	// El campo "Fecha de ingreso condición" es excluyente con los campos
	// "Período de ingreso condición" y "Número de períodos condición". Si se
	// introduce, se desactivan los otros dos
	if (valorFecha != '' && (valorPeriodo != '' || valorNumero != '')) {
		set(FORMULARIO+'.'+periodo,'');
		set(FORMULARIO+'.'+numero,'');
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
function comprobarNumeroPeriodos(numero,periodo,fecha) {
	var valorNumero = get(FORMULARIO+'.'+numero);
	var valorPeriodo = get(FORMULARIO+'.'+periodo);
	var valorFecha = get(FORMULARIO+'.'+fecha);

	// El campo "Número de períodos condición" es excluyente con los campos
	// "Período de ingreso condición" y "Fecha de ingreso condición". Si se
	// introduce, se desactivan los otros dos
	if (valorNumero != '' && (valorPeriodo != '' || valorFecha != '')) {
		set(FORMULARIO+'.'+periodo,'');
		set(FORMULARIO+'.'+fecha,'');
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
function validaFecha(nombreElemento) {
	var casoUso = get(FORMULARIO+'.casoUso').toString();
	
	if (casoUso != 'consultar' && casoUso != 'eliminar') {
	 	if (get(FORMULARIO+'.'+nombreElemento).toString() != "") {
	 		var resul = EsFechaValida(get(FORMULARIO+'.'+nombreElemento),get(FORMULARIO+'.'+nombreElemento), FORMULARIO,null);
	 		if(resul==1 || resul==2){
         		GestionarMensaje('947',FORMULARIO+'.'+nombreElemento);
				focaliza(FORMULARIO+'.'+nombreElemento);
				return false;
			}
		}
	}
}

/*function EsFechaValida_SICCFormateada(fecha, formName) {
		var formatoFecha = get(formName + ".hFormatoFechaPais");
		var delim  = obtieneDelimitador(formName);
		var fechaSpliteada = "";

		// Valida que fecha no esté no esten VACIO.
		var valorFecha = get(formName + "." + fecha);
		if ( !valorFecha )
			return false;
	  
		fechaCortada = valorFecha.split(delim);
		fechaSpliteada = formatoFecha.split(delim);

		// Valida que haya las 3 partes de la fecha luego de splitear x el delimitador.
		if ( fechaCortada.length != 3 )
		  return false;
  
		// Chequea cuál es el año (Y o y), al resto (mes o dia, le agrega ceros si es necesario).
		var formatoArray = new Array(3);
		for (var i = 0; i<3; i++ ) {
			formatoArray[i] = parseaFormato(i, formName);
		}	

		var diaMesAgno = "";
		for (var i = 0; i<3 ; i++) {
			diaMesAgno = formatoArray[i];
			switch (diaMesAgno) {
				case 1:
					NDiaD = fechaCortada[i];
					break;
				case 2:
					NMesD = fechaCortada[i];
					break;
				case 3: 
					NAnoD = fechaCortada[i];
					break;
			}
		}

		NDiaD = AgregaCero(NDiaD);
		NMesD = AgregaCero(NMesD);

		var longAgno = obtieneLongAgno(formName);
	  
		if (NDiaD >31 || NMesD > 12 || NAnoD.length != longAgno) return false;  // Valores no validos en Desde. 

		if( ! EsDiaValido(parseInt(NDiaD, 10), parseInt(NMesD, 10), parseInt(NAnoD, 10)) ) return false;

		var ND = NAnoD + NMesD + NDiaD;
		var fechaFormateada = NDiaD + delim + NMesD + delim + NAnoD ;
		set(formName + "." + fecha, fechaFormateada);
		return true;
	}
	*/


/* ------------------------------------------------------------------------------------------------------  */ 
function validaEntero(nombreElemento) {
	var casoUso = get(FORMULARIO+'.casoUso').toString();
	
	if (casoUso != 'consultar' && casoUso != 'eliminar') {
		if (get(FORMULARIO+'.'+nombreElemento).toString() != "") {
			//Como no nos interesa validar el número de dígitos que tiene el entero ponemos uno suficientemente grande.
			if (ValidaInt(get(FORMULARIO+'.'+nombreElemento).toString(), 10000, 0)!="OK") {
				GestionarMensaje('747', null, null, null);
				focaliza(FORMULARIO+'.'+nombreElemento);
				return false;
			}
		}
	}   
}


/* ------------------------------------------------------------------------------------------------------  */ 
function validaMonto(nombreElemento) {
	var casoUso = get(FORMULARIO+'.casoUso').toString();
	
	if (casoUso != 'consultar' && casoUso != 'eliminar') {
		var valorElemento = get(FORMULARIO+'.'+nombreElemento).toString();
		var separadorMiles = get(FORMULARIO+'.hid_SeparadorMiles').toString();
		var numeroDecimales = get(FORMULARIO+'.hid_NumeroDecimales').toString();
		var separadorDecimales = get(FORMULARIO+'.hid_SeparadorDecimales').toString();
		
		if (valorElemento != '') {
			var mensaje = ValidaMilesDecimales(valorElemento, 10, numeroDecimales, separadorMiles, separadorDecimales, 0);
			if (mensaje != 'OK') {
				cdos_mostrarAlert(mensaje);
				focaliza(FORMULARIO+'.'+nombreElemento);
				return false;
			} 
		}
	} 
}


/* ------------------------------------------------------------------------------------------------------  */ 
//Función accion arreglada a partir de la función accionRB enviada desde Madrid.
function accion(campo, tipo_accion) {
	if (ns) {var nsdoc=eval(campo+'NS'); eval(nsdoc+tipo_accion);}
	if (ie) {
		var iedoc=eval(campo+'IE');
		if (eval(campo+'TC')=='Radio'){
		   	var obj=eval(eval(campo+'IE'));
   			for(var j=0;j<obj.length;j++) eval(eval(campo+'IE')+'['+j+']'+tipo_accion);			
		}else{
			eval(iedoc+tipo_accion);
		}
		if (tipo_accion=='.disabled=true' && window.deshabilitadoColor) {
			var obj=eval(eval(campo+'IE'));
			if (eval(campo+'TC')=='Radio') {for(var j=0;j<obj.length;j++) {eval(eval(campo+'IE')+'['+j+'].style.backgroundColor=window.deshabilitadoColor');}}
			else {
				obj.style.backgroundColor=window.deshabilitadoColor;
				obj.style.fontWeight='bold';
				if (window.disableFontSize) obj.style.fontSize=window.disableFontSize;
			}
		}
		if (tipo_accion=='.disabled=false') {
			var color=null;
			var oblig=eval(campo+"MV");
			if (oblig=='C') {color=window.requeridoS;}
			else {color=window.requeridoN;}

			var obj=eval(eval(campo+'IE'));
			if (eval(campo+'TC')=='Radio') {for(var j=0;j<obj.length;j++) {eval(eval(campo+'IE')+'['+j+'].style.backgroundColor="'+color+'"');}}
			else {
				obj.style.backgroundColor=color;
				obj.style.fontWeight='normal';
				if (window.enableFontSize) obj.style.fontSize=window.enableFontSize;
			}
		}
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Sitúa el foco en el último elemento de la pagina
function irAUltimo(){
	var nombreUltimo = get(FORMULARIO+'.nombreUltimo');
	var nombreUltimoModif = 'Modificable'+nombreUltimo;
	var nombreUltimoVisib = 'Visible'+nombreUltimo;
	if(!document.all[nombreUltimoModif][0].disabled){
		focaliza(FORMULARIO+'.'+nombreUltimoModif);
	}else if(!document.all[nombreUltimoVisib][0].disabled){
		focaliza(FORMULARIO+'.'+nombreUltimoVisib);		
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Función que sitúa el foco en el primer elemento de la página si el obligatorio siguiente está deshabilitado.
// está función se aplicará al evento onTab del último campo de visible.
function onTabUltimoVisible(nombre){
	if (document.all['Obligatorio'+nombre][0].disabled){
		focaliza(FORMULARIO+'.txtNombrePlantilla');
	}else{
		focaliza(FORMULARIO+'.Obligatorio'+nombre);	
	}
		
}


/* ------------------------------------------------------------------------------------------------------  */ 
//Función que añade nombres para los campos que hay que validar.
function onModificable(nombre) {
	var encontrado = false;
	for (var i=0;i<nombresValidacion.length;i++){
		if(nombre == nombresValidacion[i]) {
			encontrado = true;
			return false;
		}
	}
	if (!encontrado) nombresValidacion[nombresValidacion.length]=nombre;
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Si alcance geografico nacional es si, desactiva y pone a no visible los campos subgerencia, 
// region, zona, sección y territorio. En caso contrario, los activa
function onCambiaAlcance(valorAlcance){
	var strValorAlcance = FORMULARIO + '.' + valorAlcance;
	var arrCamposModificar = ['SubgerenciaVentas','Region','Zona','Seccion','Territorio'];
	
	if (get(strValorAlcance) == "S") {
		for (var i=0;i<arrCamposModificar.length;i++) deshabilitaFieldset(arrCamposModificar[i]);
	} else {
		for (var i=0;i<arrCamposModificar.length;i++) habilitaFieldset(arrCamposModificar[i]);
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
function habilitaFieldset(nombre){
	var strVisible = FORMULARIO + '.Visible' + nombre;
	var strObligatorio = FORMULARIO + '.Obligatorio' + nombre;
	var strModificable = FORMULARIO + '.Modificable' + nombre;
	var strValor = FORMULARIO + '.Valor' + nombre;
	set(strVisible,'S');
	set(strObligatorio,'S');
	//set(strModificable,'S');
	onModificable(nombre);
	accion(strVisible,'.disabled=false');
	accion(strObligatorio,'.disabled=false');
	accion(strModificable,'.disabled=false');
	accion(strValor,'.disabled=false');
}


/* ------------------------------------------------------------------------------------------------------  */ 
function deshabilitaFieldset(nombre){
	var strVisible = FORMULARIO + '.Visible' + nombre;
	var strObligatorio = FORMULARIO + '.Obligatorio' + nombre;
	var strModificable = FORMULARIO + '.Modificable' + nombre;
	var strValor = FORMULARIO + '.Valor' + nombre;
	set(strVisible,'S');
	//set(strObligatorio,'S');
	set(strObligatorio,'N');

	set(strModificable,'S');
	accion(strVisible,'.disabled=true');
	accion(strObligatorio,'.disabled=true');
	accion(strModificable,'.disabled=true');
	accion(strValor,'.disabled=true');	
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Función que se llama al pulsar el botón Guardar
function fGuardar() {
	if (validar()) {
		// Se obtienen las descripciones del combo "Status de cursos recibidos" y
		// se almacenan en un campo hidden
		var descripcionesCursos = get(FORMULARIO+'.ValorStatusCursosExigidos','T');
		descripcionesCursos = descripcionesCursos.join('|');
		set(FORMULARIO + '.nombresCursos',descripcionesCursos);
		// Se envia el formulario, validando los campos obligatorios previamente
		set(FORMULARIO + '.accion','guardar');
		var casoUso = get(FORMULARIO+'.casoUso').toString();

		/* Agregado por ssantana, 28/08/2006, inc. DBLG500001008 */ 
		seteaValoresParaGuardar();
		/* Fin agregado por ssantana, 28/08/2006, inc. DBLG500001008 */ 
		if (sicc_validaciones_generales()) {
			if (casoUso == 'insertar') {
				set(FORMULARIO + '.conectorAction','LPInsertaPlantilla');
				enviaSICC(FORMULARIO);
			} else if (casoUso == 'modificar' || casoUso == 'copiar') {
				set(FORMULARIO + '.conectorAction','LPModificaPlantilla');
				enviaSICC(FORMULARIO);
			}
		}
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Función que realiza las validaciones
function validar() {
	/*if (!comprobarDataMart('ValorAccesoSeleccionDM','ValorPathDM')) {
		return false;
	}*/
		if (!validaPeriodoConstancia()) return false;
		if (!validaPeriodoVentas()) return false;
	
	if (!comprobarRegalo('ValorProductoEntregar','ValorNRegaloParticipantes','ValorMomentoEntregar')) {
		return false;
	}
	
	for (var i=0;i<nombresValidacion.length;i++){
		var nombre = nombresValidacion[i];
		if (!comprobarValor('Visible'+nombre,'Obligatorio'+nombre,'Modificable'+nombre,'Valor'+nombre)){
			return false;
		}
	}
	return true;
}


/* ------------------------------------------------------------------------------------------------------  */ 
	function validaPeriodoConstancia() {
		var informadoPeriodoIni = false;
		var informadoPeriodoFin = false;
		if (get(FORMULARIO + '.ValorPeriodoInicio') != "")  informadoPeriodoIni = true;
		if (get(FORMULARIO + '.ValorPeriodoFin') != "")  informadoPeriodoFin = true;
		
		//comprobación de que si viene señalado uno de los combos Período de inicio Constancia
		// o Período Fin Constancia venga el otro y el periodo de fin sea mayor que es de inicio

			//Si ambos combos Período de inicio Constancia o Período Fin Constancia son distintos de null 
			if (informadoPeriodoIni && informadoPeriodoFin) {
				//Validamos que el periodo fin sea mayor que el de inicio
			    if (!comprobarPeriodos(get(FORMULARIO + '.ValorPeriodoInicio', 'T').toString(), get(FORMULARIO + '.ValorPeriodoFin', 'T').toString())) {
			       	//Si No correcto  //Si el periodo fin no es mayor que el periodo inicio
					//mostrar error: UIEDU0005 ("El Período Fin Constancia debe ser mayor que el Período Inicio
					//Constancia ")
					GestionarMensaje('UIEDU0005', null);
					focaliza(FORMULARIO + '.ValorPeriodoInicio')
					return false;
			    }
			}	
		//Si el campo"Número de órdenes de Constancia" está informado 
		if (get(FORMULARIO + '.ValorNOrdenes') != "") {
		
			if (informadoPeriodoIni ^ informadoPeriodoFin) {
			    //Si uno de ellos es null y el otro no 
				//mostrar error: UIEDU0003 ("No puede informarse el Período Inicio Constancia sin Período Fin Constancia o viceversa")
				GestionarMensaje('UIEDU0003', null);
				focaliza(FORMULARIO + '.ValorPeriodoInicio')
				return false;
			}
		
		}
		return true;
	}


/* ------------------------------------------------------------------------------------------------------  */ 
	function validaPeriodoVentas(){
		var informadoPeriodoIni = false;
		var informadoPeriodoFin = false;
		if (get(FORMULARIO + '.ValorPeriodoInicioV') != "")  informadoPeriodoIni = true;
		if (get(FORMULARIO + '.ValorPeriodoFinV') != "")  informadoPeriodoFin = true;
		
		//comprobación de que si viene señalado uno de los combos Período de inicio Constancia
		// o Período Fin Constancia venga el otro y el periodo de fin sea mayor que es de inicio

			//Si ambos combos Período de inicio Constancia o Período Fin Constancia son distintos de null 
			if (informadoPeriodoIni && informadoPeriodoFin) {
				//Validamos que el periodo fin sea mayor que el de inicio
			    if (!comprobarPeriodos(get(FORMULARIO + '.ValorPeriodoInicioV', 'T').toString(), get(FORMULARIO + '.ValorPeriodoFinV', 'T').toString())) {
			       	//Si No correcto  //Si el periodo fin no es mayor que el periodo inicio
					//mostrar error: UIEDU0006 ("El Período Fin Ventas debe ser mayor que el Período Inicio Ventas ")
					GestionarMensaje('UIEDU0006', null);
					focaliza(FORMULARIO + '.ValorPeriodoInicioV')
					return false;
			    }
			} 	
		//Si el campo "Monto de ventas comparativo" está informado 
		if (get(FORMULARIO + '.ValorMonto') != "") {
		
			if (informadoPeriodoIni ^ informadoPeriodoFin) {
			    //Si uno de ellos es null y el otro no 
				//mostrar error: UIEDU0004 ("No puede informarse el Período Inicio Ventas sin Período Fin Ventas o viceversa")
				GestionarMensaje('UIEDU0004', null);
				focaliza(FORMULARIO + '.ValorPeriodoInicioV')
				return false;
			}
		
		}
		return true;
	}


/* ------------------------------------------------------------------------------------------------------  */ 
	function comprobarPeriodos(periodoIni, periodoFin) {
		var inicioIni = periodoIni.substr(periodoIni.length-6, 4);
		var inicioFin = periodoFin.substr(periodoFin.length-6, 4);
		var correcto = false;
		//Si los 4 primeros digitos de la cmbPeriodoFin > los 4 primeros digitos de la cmbPeriodoInicio => correcto
		if (inicioFin > inicioIni) correcto = true;
		else if (inicioFin == inicioIni) {
		//- Si los 4 primeros digitos de la cmbPeriodoFin = los 4 primeros digitos de la cmbPeriodoInicio 
	   	// - Si los 2 ultimos digitos de la cmbPeriodoFin >= los 2 ultimos digitos de la cmbPeriodoInicio 
	   		var finIni = periodoIni.substr(periodoIni.length - 2);
			var finFin = periodoFin.substr(periodoFin.length - 2);
			if (finFin >= finIni) correcto = true;
		}
		return correcto;
	}

/*function comprobarDataMart(acceso, path) {
	var valorAcceso = get(FORMULARIO+'.'+acceso);
	var valorPath = get(FORMULARIO+'.'+path);
	
	// Si el campo "Acceso de selección Data Mart" = Si entonces es obligatorio
	//introducir un dato en el campo Path y nombre de fichero DataMart
	if (valorAcceso == 'S' && valorPath == '') {
		// Muestra el mensaje: El campo es obligatorio. Debe ingresar un valor
		GestionarMensaje('9');
		focaliza(FORMULARIO+'.'+path);
		return false;
	}
	return true;
}*/


/* ------------------------------------------------------------------------------------------------------  */ 
function comprobarRegalo(producto,unidades,momento) {
	var valorProducto = get(FORMULARIO+'.'+producto);
	var valorUnidades = get(FORMULARIO+'.'+unidades);
	var valorMomento = get(FORMULARIO+'.'+momento);
	
	// Si el campo "Producto a entregar" está relleno entonces es obligatorio
	// dar un valor	a los campos "Número de unidades de regalo por participante"
	// y "Momento de entrega del regalo"
	if (valorProducto != '') {
		
		if (valorUnidades == '') {
			// Muestra el mensaje: El campo es obligatorio. Debe ingresar un valor
			GestionarMensaje('9');
			focaliza(FORMULARIO+'.'+unidades);
			return false;
		}else if (valorMomento == '') {
			// Muestra el mensaje: El campo es obligatorio. Debe ingresar un valor
			GestionarMensaje('9');
			focaliza(FORMULARIO+'.'+momento);
			return false;
		}
	}
	
	return true;
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Función que se ejecuta al pulsar el botón Limpiar
function fLimpiar() {
	limpiaI18N(FORMULARIO, '1');
	
	var casoUso = get(FORMULARIO+'.casoUso');
	if (casoUso == 'insertar') {
		limpiarTodo();
	} else {
		restablecerValoresIniciales();
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Limpia todos los campos de la página
function limpiarTodo(){
	limpiarVisible();
	limpiarObligatorio();
	limpiarValor();
	limpiarModificable();
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Restablece los valores que había cuando se cargó la pagina
function restablecerValoresIniciales() {
	// Se reestablecen los valores de las cajas de texto y radios
	restablecerCamposTexto();
	
	// Se reestablecen los valores de los combos
	restablecerCombosIndependientes();
	cargaCombosDependientes();
	
	// Se reestablecen los valores de los campos visible, obligatorio y modificable
	restablecerVisibles();
	restablecerModificables();
	restablecerObligatorios();
	desactivaNoVisibles();
}


/* ------------------------------------------------------------------------------------------------------  */ 
function restablecerCombosIndependientes() {
	for (var i = 0; i < combosIndependientes.length; i++) {
		var nombre = combosIndependientes[i];
		var valorInicial = get(FORMULARIO + '.h' + nombre);
		set(FORMULARIO + '.Valor' + nombre, [valorInicial]);
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
function restablecerCamposTexto() {
/*	for (var i = 0; i < NombresCampos.length; i++) {
		//var campo = FORMULARIO+'.Valor'+NombresCampos[i].split('|')[0];
		var campo = NombresCampos[i].split('|')[0];
		var tipo = NombresCampos[i].split('|')[1];
		
		if (tipo != 'COMBO') {
			var valorInicial = get(FORMULARIO+'.h'+campo);
			set(FORMULARIO+'.Valor'+campo,valorInicial);
		}
	}*/
}


/* ------------------------------------------------------------------------------------------------------  */ 
function restablecerVisibles() {
	// Se activan todos los campos visibles
	for (var i=0; i<NombresCampos.length;i++) {
		var campo = FORMULARIO+'.Visible'+NombresCampos[i].split('|')[0];
		accion(campo,'.disabled=false');
		set(campo,'S');
	}
	
	// Se desactivan los que estan en el hidden noVisibles
	var strNoVisibles = get(FORMULARIO+'.noVisibles');
	if (strNoVisibles != '') {
		var camposNoVisibles = strNoVisibles.split('|');
	
		for (var i=0;i<camposNoVisibles.length;i++) {	
			var strVisible = FORMULARIO + '.Visible' + camposNoVisibles[i];
			set(strVisible,'N');
		}
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
function restablecerModificables() {
	// Se activan todos los campos modificables
	for (var i=0; i<NombresCampos.length;i++) {
		var campo = FORMULARIO+'.Modificable'+NombresCampos[i].split('|')[0];
		accion(campo,'.disabled=false');
		set(campo,'S');
	}
	
	// Se desactivan los que estan en el hidden noModificables
	var strNoModificables = get(FORMULARIO+'.noModificables');
	if (strNoModificables != '') {
		var camposNoModificables = strNoModificables.split('|');
	
		for (var i=0;i<camposNoModificables.length;i++) {	
			var strModificable = FORMULARIO + '.Modificable' + camposNoModificables[i];
			set(strModificable,'N');
		}
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
function restablecerObligatorios() {
	// Se activan todos los campos obligatorios
	for (var i=0; i<NombresCampos.length;i++) {
		var campo = FORMULARIO+'.Obligatorio'+NombresCampos[i].split('|')[0];
		accion(campo,'.disabled=false');
		set(campo,'S');
	}
	
	// Se desactivan los que estan en el hidden noObligatorios
	var strNoObligatorios = get(FORMULARIO+'.noObligatorios');
	if (strNoObligatorios != '') {
		var camposNoObligatorios = strNoObligatorios.split('|');
	
		for (var i=0;i<camposNoObligatorios.length;i++) {	
			var strObligatorio = FORMULARIO + '.Obligatorio' + camposNoObligatorios[i];
			set(strObligatorio,'N');
		}
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
function limpiarVisible(){
	for (var i=0; i<NombresCampos.length;i++) {
		var campo = FORMULARIO+'.Visible'+NombresCampos[i].split('|')[0];
		accion(campo,'.disabled=false');
		set(campo,'S');
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
function limpiarObligatorio(){
	for (var i=0; i<NombresCampos.length;i++) {
		var campo = FORMULARIO+'.Obligatorio'+NombresCampos[i].split('|')[0];
		accion(campo,'.disabled=false');
		set(campo,'S');
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
function limpiarValor() {
	// Se borra el nombre de la plantilla
	set(FORMULARIO+'.txtNombrePlantilla',"");
	
	for (var i=0; i<NombresCampos.length;i++) {
		var campo = FORMULARIO+'.Valor'+NombresCampos[i].split('|')[0];
		accion(campo,'.disabled=false');
		switch(NombresCampos[i].split('|')[1]){
			case "COMBO":
				// Si es un combo independiente, se selecciona el valor vacio. Si es un 
				// combo dependiente, se borran sus valores
				var nombre = NombresCampos[i].split('|')[0];
				if((nombre=="Marca")||(nombre=="Canal")||(nombre=="TipoCliente")||(nombre=="StatusCliente")||(nombre=="ProductoEntregar")||(nombre=="FrecuenciaDictado")){
					set(campo,0);				
				}else{
					set_combo(campo,[['','']],['']);
				}
				break;
			case "CTEXTO":
				set(campo,"");
				break;
			case "RADIOB":
				set(campo,"N");
				break;
		}
	}	
}


/* ------------------------------------------------------------------------------------------------------  */ 
function limpiarModificable(){
	for (var i=0; i<NombresCampos.length;i++) {
		var campo = FORMULARIO+'.Modificable'+NombresCampos[i].split('|')[0];
		accion(campo,'.disabled=false');
		set(campo,'S');
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Función que se ejecuta al pulsar el botón Volver
function fVolver() {
	var casoUso = get(FORMULARIO+'.casoUso').toString();
	if (casoUso == 'modificar' || casoUso == 'consultar' || 
		casoUso == 'copiar' || casoUso == 'eliminar') {
			window.close();
	}
}


/* ------------------------------------------------------------------------------------------------------  */ 
function vaciaCombo(combo) {
	if (eval('document.'+combo) != undefined) {
		set_combo(combo,[['','']],['']);
	}
}

/* ------------------------------------------------------------------------------------------------------  */ 
function vaciaCombosDep(combosDep) {
	for (var i=0; i<combosDep.length; i++) {
		// Obtiene el nombre del combo y la funcion 
		var arr = combosDep[i].split('|');
		var combo = arr[0];
		var funcion = '';
		if (arr.length > 1) {
			funcion = arr[1];
		}
		
		// Vacia el combo
		vaciaCombo(FORMULARIO+'.'+combo);
		
		// Llama a la funcion que vacia los combos dependientes del combo actual
		if (funcion != '') {
			eval(funcion);
		}
	}
}

/* ------------------------------------------------------------------------------------------------------  */ 		
function vaciaCombosDepMarca() {
	vaciaCombosDep(combosDepMarca);
}

function vaciaCombosDepCanal() {
	vaciaCombosDep(combosDepCanal);
}

function vaciaCombosDepTipoCliente() {
	vaciaCombosDep(combosDepTipoCliente);
	
}

function vaciaCombosDepSubtipoCliente() {
	vaciaCombosDep(combosDepSubtipoCliente);
}

function vaciaCombosDepTipoClasificacion() {
	vaciaCombosDep(combosDepTipoClasificacion);
}

function vaciaCombosDepSubgerencia() {
	vaciaCombosDep(combosDepSubgerencia);
}

function vaciaCombosDepRegion() {
	vaciaCombosDep(combosDepRegion);
}

function vaciaCombosDepZona() {
	vaciaCombosDep(combosDepZona);
}

function vaciaCombosDepSeccion() {
	vaciaCombosDep(combosDepSeccion);
}

function vaciaCombosDepTipoCurso() {
	vaciaCombosDep(combosDepTipoCurso);
}



// Funciones para convertir en excluyentes los campos obligatorios de Período de ingreso condición ,
// Fecha de ingreso condición y Número de períodos condición
/* ------------------------------------------------------------------------------------------------------  */ 
function onObligatorioPeriodoIngreso(){
	set(FORMULARIO+'.ObligatorioFechaIngreso','N');		
	set(FORMULARIO+'.ObligatorioNCondicion','N');		
}


/* ------------------------------------------------------------------------------------------------------  */ 
function onObligatorioFechaIngreso(){
	set(FORMULARIO+'.ObligatorioPeriodoIngreso','N');
	set(FORMULARIO+'.ObligatorioNCondicion','N');
}


/* ------------------------------------------------------------------------------------------------------  */ 
function onObligatorioNCondicion(){
	set(FORMULARIO+'.ObligatorioPeriodoIngreso','N');	
	set(FORMULARIO+'.ObligatorioFechaIngreso','N');
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Funciones para el evento onClick de los check visible de los campos exclusivos.
function onVisiblePeriodoIngreso(visible,obligatorio,modificable,valor){
	var strVisible = FORMULARIO + '.' + visible;
	// Si estoy marcando visible desactivo la obligatoriedad de los exclusivos.
	if (get(strVisible) == 'S') {
		onObligatorioPeriodoIngreso();
	}
	onVisible(visible,obligatorio,modificable,valor);
}


/* ------------------------------------------------------------------------------------------------------  */ 
function onVisibleFechaIngreso(visible,obligatorio,modificable,valor){
	var strVisible = FORMULARIO + '.' + visible;
	// Si estoy marcando visible desactivo la obligatoriedad de los exclusivos.
	if (get(strVisible) == 'S') {
		onObligatorioFechaIngreso();	
	}
	onVisible(visible,obligatorio,modificable,valor);
}


/* ------------------------------------------------------------------------------------------------------  */ 
function onVisibleNCondicion(visible,obligatorio,modificable,valor){
	var strVisible = FORMULARIO + '.' + visible;
	// Si estoy marcando visible desactivo la obligatoriedad de los exclusivos.
	if (get(strVisible) == 'S') {
		onObligatorioNCondicion();	
	}
	onVisible(visible,obligatorio,modificable,valor);
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Funcion para el evento onClick de los check visible de los campos nOrdenes y relacionados.
function onVisibleNOrdenes(visible, obligatorio, modificable, valor) {
	var strVisible = FORMULARIO + '.' + visible;
	// Si visible activar la visibilidad de los relacionados.
	if (get(strVisible) == 'S') {
		set(FORMULARIO + '.VisiblePeriodoInicio', 'S');		
		onVisible('VisiblePeriodoInicio', 'ObligatorioPeriodoInicio', 'ModificablePeriodoInicio', 'ValorPeriodoInicio');
		set(FORMULARIO + '.VisiblePeriodoFin', 'S');		
		onVisible('VisiblePeriodoFin', 'ObligatorioPeriodoFin', 'ModificablePeriodoFin', 'ValorPeriodoFin');
	}
	onVisible(visible, obligatorio, modificable, valor);
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Si NOrdenes está visible PeriodoIniCons debe ser visible.
function onVisiblePeriodoIniCons(visible, obligatorio, modificable, valor) {
	var strVisible = FORMULARIO + '.VisibleNOrdenes';
	if (get(strVisible) == 'S') {
		set(FORMULARIO + '.' + visible, 'S');		
	}
	onVisible(visible, obligatorio, modificable, valor);
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Si NOrdenes está visible PeriodoFin debe ser visible.
function onVisiblePeriodoFinCons(visible, obligatorio, modificable, valor) {
	var strVisible = FORMULARIO + '.VisibleNOrdenes';
	if (get(strVisible) == 'S') {
		set(FORMULARIO + '.' + visible, 'S');		
	}
	onVisible(visible, obligatorio, modificable, valor);
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Funcion para el evento onClick de los check obligatorio de los campos nOrdenes y relacionados.
function onObligatorioNOrdenes() {
	// Si obligatorio activar la obligatoriedad de los relacionados.
	if (get(FORMULARIO + '.ObligatorioNOrdenes') == 'S') {
		set(FORMULARIO + '.ObligatorioPeriodoInicio', 'S');		
		set(FORMULARIO + '.ObligatorioPeriodoFin', 'S');
	}		
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Si NOrdenes está obligatorio PeriodoInicons debe ser obligatorio.
function onObligatorioPeriodoIniCons() {
	if (get(FORMULARIO + '.ObligatorioNOrdenes') == 'S')
		set(FORMULARIO + '.ObligatorioPeriodoInicio', 'S');
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Si NOrdenes está obligatorio PeriodoFincons debe ser obligatorio.
function onObligatorioPeriodoFinCons() {
	if (get(FORMULARIO + '.ObligatorioNOrdenes') == 'S')
		set(FORMULARIO + '.ObligatorioPeriodoFin', 'S');
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Funcion para el evento onClick de los check visible de los campos Monto y relacionados.
function onVisibleMonto(visible, obligatorio, modificable, valor) {
	var strVisible = FORMULARIO + '.' + visible;
	// Si visible activar la visibilidad de los relacionados.
	if (get(strVisible) == 'S') {
		set(FORMULARIO + '.VisiblePeriodoInicioV', 'S');		
		onVisible('VisiblePeriodoInicioV', 'ObligatorioPeriodoInicioV', 'ModificablePeriodoInicioV', 'ValorPeriodoInicioV');
		set(FORMULARIO + '.VisiblePeriodoFinV', 'S');		
		onVisible('VisiblePeriodoFinV', 'ObligatorioPeriodoFinV', 'ModificablePeriodoFinV', 'ValorPeriodoFinV');
	}
	onVisible(visible, obligatorio, modificable, valor);
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Si Monto está visible PeriodoInicioV debe ser visible.
function onVisiblePeriodoInicioV(visible, obligatorio, modificable, valor) {
	var strVisible = FORMULARIO + '.VisibleMonto';
	if (get(strVisible) == 'S') {
		set(FORMULARIO + '.' + visible, 'S');		
	}
	onVisible(visible, obligatorio, modificable, valor);
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Si Monto está visible PeriodoFinV debe ser visible.
function onVisiblePeriodoFinV(visible, obligatorio, modificable, valor) {
	var strVisible = FORMULARIO + '.VisibleMonto';
	if (get(strVisible) == 'S') {
		set(FORMULARIO + '.' + visible, 'S');		
	}
	onVisible(visible, obligatorio, modificable, valor);
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Funcion para el evento onClick de los check obligatorio de los campos Monto y relacionados.
function onObligatorioMonto() {
	// Si obligatorio activar la obligatoriedad de los relacionados.
	if (get(FORMULARIO + '.ObligatorioMonto') == 'S') {
		set(FORMULARIO + '.ObligatorioPeriodoInicioV', 'S');		
		set(FORMULARIO + '.ObligatorioPeriodoFinV', 'S');
	}		
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Si Monto está obligatorio PeriodoInicioV debe ser obligatorio.
function onObligatorioPeriodoInicioV() {
	if (get(FORMULARIO + '.ObligatorioMonto') == 'S')
		set(FORMULARIO + '.ObligatorioPeriodoInicioV', 'S');
}


/* ------------------------------------------------------------------------------------------------------  */ 
// Si Monto está obligatorio PeriodoFinV debe ser obligatorio.
function onObligatorioPeriodoFinV() {
	if (get(FORMULARIO + '.ObligatorioMonto') == 'S')
		set(FORMULARIO + '.ObligatorioPeriodoFinV', 'S');
}


/* ------------------------------------------------------------------------------------------------------  */ 
/* Agregado por ssantana, 28/08/2006, inc. DBLG500001008 */ 
function seteaValoresParaGuardar() {
	set(FORMULARIO + '.hDescripcionD', get(FORMULARIO + '.ValorDescripcionD') );
	set(FORMULARIO + '.hMarca', get(FORMULARIO + '.ValorMarca') );
	set(FORMULARIO + '.hCanal', get(FORMULARIO + '.ValorCanal') );
	set(FORMULARIO + '.hTipoCurso', get(FORMULARIO + '.ValorTipoCurso') ); 
	set(FORMULARIO + '.hAccesoInformacion', get(FORMULARIO + '.ValorAccesoInformacion') ); 
	set(FORMULARIO + '.hFrecuenciaDictado', get(FORMULARIO + '.ValorFrecuenciaDictado') ); 
	set(FORMULARIO + '.hSubgerenciaVentas', get(FORMULARIO + '.ValorSubgerenciaVentas') ); 
	set(FORMULARIO + '.hRegion', get(FORMULARIO + '.ValorRegion') ); 
	set(FORMULARIO + '.hZona', get(FORMULARIO + '.ValorZona') ); 
	set(FORMULARIO + '.hSeccion', get(FORMULARIO + '.ValorSeccion') ); 
	set(FORMULARIO + '.hTerritorio', get(FORMULARIO + '.ValorTerritorio') ); 
	set(FORMULARIO + '.hTipoCliente', get(FORMULARIO + '.ValorTipoCliente') ); 
	set(FORMULARIO + '.hCapacitador', get(FORMULARIO + '.ValorCapacitador') ); 
	set(FORMULARIO + '.hSubtipoCliente', get(FORMULARIO + '.ValorSubtipoCliente') ); 
	set(FORMULARIO + '.hClasificacion', get(FORMULARIO + '.ValorClasificacion') ); 
	set(FORMULARIO + '.hTipoClasificacion', get(FORMULARIO + '.ValorTipoClasificacion') ); 
	set(FORMULARIO + '.hStatusCliente', get(FORMULARIO + '.ValorStatusCliente') ); 
	set(FORMULARIO + '.hStatusCursosExigidos', get(FORMULARIO + '.ValorStatusCursosExigidos') ); 
	set(FORMULARIO + '.hPeriodoInicio', get(FORMULARIO + '.ValorPeriodoInicio') ); 
	set(FORMULARIO + '.hPeriodoFin', get(FORMULARIO + '.ValorPeriodoFin') ); 
	set(FORMULARIO + '.hPeriodoInicioV', get(FORMULARIO + '.ValorPeriodoInicioV') ); 
	set(FORMULARIO + '.hPeriodoFinV', get(FORMULARIO + '.ValorPeriodoFinV') ); 
	set(FORMULARIO + '.hPeriodoIngreso', get(FORMULARIO + '.ValorPeriodoIngreso') ); 
	set(FORMULARIO + '.hProductoEntregar', get(FORMULARIO + '.ValorProductoEntregar') ); 
	set(FORMULARIO + '.hMomentoEntregar', get(FORMULARIO + '.ValorMomentoEntregar') ); 

	set(FORMULARIO + '.hNombreCurso', get(FORMULARIO + '.ValorNombreCurso') ); 
	set(FORMULARIO + '.hObjetivoCurso', get(FORMULARIO + '.ValorObjetivoCurso') ); 
	set(FORMULARIO + '.hContenidoCurso', get(FORMULARIO + '.ValorContenidoCurso') ); 
	set(FORMULARIO + '.hAccesoSeleccionDM', get(FORMULARIO + '.ValorAccesoSeleccionDM') ); 
	set(FORMULARIO + '.hPathDM', get(FORMULARIO + '.ValorPathDM') ); 
	set(FORMULARIO + '.hFechaDisponible', get(FORMULARIO + '.ValorFechaDisponible') ); 
	set(FORMULARIO + '.hFechaLanzamiento', get(FORMULARIO + '.ValorFechaLanzamiento') ); 
	set(FORMULARIO + '.hFechaFin', get(FORMULARIO + '.ValorFechaFin') ); 
	set(FORMULARIO + '.hAlcanceGeografico', get(FORMULARIO + '.ValorAlcanceGeografico') ); 
	set(FORMULARIO + '.hNOptimo', get(FORMULARIO + '.ValorNOptimo') ); 
	set(FORMULARIO + '.hBloqueo', get(FORMULARIO + '.ValorBloqueo') ); 
	set(FORMULARIO + '.hRelacion', get(FORMULARIO + '.ValorRelacion') ); 
	set(FORMULARIO + '.hNOrdenes', get(FORMULARIO + '.ValorNOrdenes') ); 
	set(FORMULARIO + '.hMonto', get(FORMULARIO + '.ValorMonto') ); 
	set(FORMULARIO + '.hFechaIngreso', get(FORMULARIO + '.ValorFechaIngreso') ); 
	set(FORMULARIO + '.hNCondicion', get(FORMULARIO + '.ValorNCondicion') ); 
	set(FORMULARIO + '.hFechaUltimo', get(FORMULARIO + '.ValorFechaUltimo') ); 
	set(FORMULARIO + '.hNRegaloParticipantes', get(FORMULARIO + '.ValorNRegaloParticipantes') ); 
	set(FORMULARIO + '.hCondicionPedido', get(FORMULARIO + '.ValorCondicionPedido') ); 
	set(FORMULARIO + '.hControlMorosidad', get(FORMULARIO + '.ValorControlMorosidad') ); 
	set(FORMULARIO + '.hDescripcionD', get(FORMULARIO + '.ValorDescripcionD') );
}
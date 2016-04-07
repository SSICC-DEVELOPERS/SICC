

/*
    INDRA/CAR/mmg
    $Id: zonvalorestrugeopo.js,v 1.1 2009/12/03 19:01:32 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsZonValorEstruGeopoId = "";
var jsZonValorEstruGeopoCodUnidGeog = "";
var jsZonValorEstruGeopoDesGeog = "";
var jsZonValorEstruGeopoCodNse1 = "";
var jsZonValorEstruGeopoCodNse2 = "";
var jsZonValorEstruGeopoCodNse3 = "";
var jsZonValorEstruGeopoCodPost = "";
var jsZonValorEstruGeopoIndActi = "";
var jsZonValorEstruGeopoIndAsig = "";
var jsZonValorEstruGeopoIndBorr = "";
var jsZonValorEstruGeopoOrde1 = "";
var jsZonValorEstruGeopoOrde2 = "";
var jsZonValorEstruGeopoOrde3 = "";
var jsZonValorEstruGeopoOrde4 = "";
var jsZonValorEstruGeopoOrde5 = "";
var jsZonValorEstruGeopoOrde6 = "";
var jsZonValorEstruGeopoOrde7 = "";
var jsZonValorEstruGeopoOrde8 = "";
var jsZonValorEstruGeopoOrde9 = "";
var jsZonValorEstruGeopoEgeoOidEstrGeop = "";
var jsZonValorEstruGeopoPaisOidPais = "";
var jsZonValorEstruGeopoFecActu = "";
var jsZonValorEstruGeopoSgeoOidSubeGeop = "";

//Variables de paginacion, 
var zonValorEstruGeopoPageCount = 1;

//Varible de columna que representa el campo de choice
var zonValorEstruGeopoChoiceColumn = 22;

//Flag de siguiente pagina;
var zonValorEstruGeopoMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var zonValorEstruGeopoTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 987;
var sizeFormView = 981;
var sizeFormUpdate = 981;

//Ultima busqueda realizada
var zonValorEstruGeopoLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focalizaComboDependence("zonValorEstruGeopo","sgeoOidSubeGeop", false);','focalizaComboDependence("zonValorEstruGeopo","sgeoOidSubeGeop", false);','focalizaComboDependence("zonValorEstruGeopo","sgeoOidSubeGeop", false);','focalizaComboDependence("zonValorEstruGeopo","sgeoOidSubeGeop", true);','focalizaComboDependence("zonValorEstruGeopo","sgeoOidSubeGeop", true);','focalizaComboDependence("zonValorEstruGeopo","sgeoOidSubeGeop", true);']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var egeoOidEstrGeopDependeceMap = new Vector();
egeoOidEstrGeopDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
egeoOidEstrGeopDependeceMap.agregar(['egeoOidEstrGeop', padresTmp, '', 'ZonEstruGeopo']);
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_fopaOidFormPago', padresTmp, 'paisOidPais', 'BelFormaPagoTapon']);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_moneOidMoneAlt', padresTmp, 'paisOidPais', 'SegMoned']);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_moneOidMone', padresTmp, 'paisOidPais', 'SegMoned']);
padresTmp =  new Vector();
padresTmp.cargar(['paisOidPais_fopaOidFormPago','paisOidPais_moneOidMoneAlt','paisOidPais_moneOidMone'])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPais']);
var sgeoOidSubeGeopDependeceMap = new Vector();
sgeoOidSubeGeopDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
sgeoOidSubeGeopDependeceMap.agregar(['sgeoOidSubeGeop_egeoOidEstrGeop', padresTmp, 'sgeoOidSubeGeop', 'ZonEstruGeopo']);
padresTmp =  new Vector();
padresTmp.cargar(['sgeoOidSubeGeop_egeoOidEstrGeop'])
sgeoOidSubeGeopDependeceMap.agregar(['sgeoOidSubeGeop', padresTmp, '', 'ZonSubesGeopo']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
zonValorEstruGeopoLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var zonValorEstruGeopoTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function zonValorEstruGeopoInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('zonValorEstruGeopoFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('zonValorEstruGeopoFrm.accion')){
		case "query": zonValorEstruGeopoQueryInitComponents(); break;
		case "view": zonValorEstruGeopoViewInitComponents(); break;
		case "create": zonValorEstruGeopoCreateInitComponents(); break;
		case "update": zonValorEstruGeopoUpdateInitComponents(); break;
		case "remove": zonValorEstruGeopoRemoveInitComponents(); break;
		case "lov": zonValorEstruGeopoLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('zonValorEstruGeopoFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('zonValorEstruGeopo')) zonValorEstruGeopoCmdRequery();
}

function zonValorEstruGeopoQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

function zonValorEstruGeopoViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
}

function zonValorEstruGeopoCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('zonValorEstruGeopoFrm.codUnidGeog','S', GestionarMensaje('ZonValorEstruGeopo.codUnidGeog.requiered.message'));
	
	setMV('zonValorEstruGeopoFrm.egeoOidEstrGeop','S', GestionarMensaje('ZonValorEstruGeopo.egeoOidEstrGeop.requiered.message'));
	
	setMV('zonValorEstruGeopoFrm.paisOidPais','S', GestionarMensaje('ZonValorEstruGeopo.paisOidPais.requiered.message'));
	
	setMV('zonValorEstruGeopoFrm.fecActu','S', GestionarMensaje('ZonValorEstruGeopo.fecActu.requiered.message'));
	
	setMV('zonValorEstruGeopoFrm.sgeoOidSubeGeop','S', GestionarMensaje('ZonValorEstruGeopo.sgeoOidSubeGeop.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function zonValorEstruGeopoUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('zonValorEstruGeopoFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		zonValorEstruGeopoTmpUpdateValues = zonValorEstruGeopoBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('zonValorEstruGeopoFrm.codUnidGeog','S', GestionarMensaje('ZonValorEstruGeopo.codUnidGeog.requiered.message'));
		setMV('zonValorEstruGeopoFrm.egeoOidEstrGeop','S', GestionarMensaje('ZonValorEstruGeopo.egeoOidEstrGeop.requiered.message'));
		setMV('zonValorEstruGeopoFrm.paisOidPais','S', GestionarMensaje('ZonValorEstruGeopo.paisOidPais.requiered.message'));
		setMV('zonValorEstruGeopoFrm.fecActu','S', GestionarMensaje('ZonValorEstruGeopo.fecActu.requiered.message'));
		setMV('zonValorEstruGeopoFrm.sgeoOidSubeGeop','S', GestionarMensaje('ZonValorEstruGeopo.sgeoOidSubeGeop.requiered.message'));
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('zonValorEstruGeopoFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function zonValorEstruGeopoRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	zonValorEstruGeopoList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function zonValorEstruGeopoLovInitComponents(){
	zonValorEstruGeopoLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad

























//Función que permite cargar los datos de un elemento de lov seleccionado
function zonValorEstruGeopoSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('zonValorEstruGeopoFrm.' + campo, id);
	set('zonValorEstruGeopoFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function zonValorEstruGeopoLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	zonValorEstruGeopoLovReturnParameters.id = '';
	zonValorEstruGeopoLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function zonValorEstruGeopoLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonValorEstruGeopoList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = zonValorEstruGeopoList.codSeleccionados();
	var descripcion = zonValorEstruGeopoList.extraeDato(
		zonValorEstruGeopoList.codSeleccionados()[0], zonValorEstruGeopoChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	zonValorEstruGeopoLovReturnParameters.id = codigo;
	zonValorEstruGeopoLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function zonValorEstruGeopoCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('zonValorEstruGeopoFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('zonValorEstruGeopoFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "zonValorEstruGeopoList", "ZonValorEstruGeopoConectorTransactionQuery", 
		"result_ROWSET", parametros, "zonValorEstruGeopoPostQueryActions(datos);"]], "", "");	
}

function zonValorEstruGeopoCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('zonValorEstruGeopoFrm.lastQueryToSession'));
	var i =0;
	set('zonValorEstruGeopoFrm.codUnidGeog', paramsRequery.ij(i++));
	
	set('zonValorEstruGeopoFrm.desGeog', paramsRequery.ij(i++));
	
	set('zonValorEstruGeopoFrm.codNse1', paramsRequery.ij(i++));
	
	set('zonValorEstruGeopoFrm.codNse2', paramsRequery.ij(i++));
	
	set('zonValorEstruGeopoFrm.codNse3', paramsRequery.ij(i++));
	
	set('zonValorEstruGeopoFrm.codPost', paramsRequery.ij(i++));
	
	set('zonValorEstruGeopoFrm.indActi', paramsRequery.ij(i++));
	
	set('zonValorEstruGeopoFrm.indAsig', paramsRequery.ij(i++));
	
	set('zonValorEstruGeopoFrm.indBorr', paramsRequery.ij(i++));
	
	set('zonValorEstruGeopoFrm.orde1', paramsRequery.ij(i++));
	
	set('zonValorEstruGeopoFrm.orde2', paramsRequery.ij(i++));
	
	set('zonValorEstruGeopoFrm.orde3', paramsRequery.ij(i++));
	
	set('zonValorEstruGeopoFrm.orde4', paramsRequery.ij(i++));
	
	set('zonValorEstruGeopoFrm.orde5', paramsRequery.ij(i++));
	
	set('zonValorEstruGeopoFrm.orde6', paramsRequery.ij(i++));
	
	set('zonValorEstruGeopoFrm.orde7', paramsRequery.ij(i++));
	
	set('zonValorEstruGeopoFrm.orde8', paramsRequery.ij(i++));
	
	set('zonValorEstruGeopoFrm.orde9', paramsRequery.ij(i++));
	
	set('zonValorEstruGeopoFrm.egeoOidEstrGeop', [paramsRequery.ij(i++)]);
	
	set('zonValorEstruGeopoFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('zonValorEstruGeopoFrm.fecActu', paramsRequery.ij(i++));
	
	set('zonValorEstruGeopoFrm.sgeoOidSubeGeop', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	zonValorEstruGeopoPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	zonValorEstruGeopoCmdQuery(zonValorEstruGeopoPageCount);
}

function zonValorEstruGeopoFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	zonValorEstruGeopoPageCount = 1;
	zonValorEstruGeopoCmdQuery(zonValorEstruGeopoPageCount);
}

function zonValorEstruGeopoPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonValorEstruGeopoLastQuery){
		zonValorEstruGeopoFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	zonValorEstruGeopoPageCount--;
	zonValorEstruGeopoCmdQuery(zonValorEstruGeopoPageCount);
}

function zonValorEstruGeopoNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonValorEstruGeopoLastQuery){
		zonValorEstruGeopoFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	zonValorEstruGeopoPageCount++;
	zonValorEstruGeopoCmdQuery(zonValorEstruGeopoPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function zonValorEstruGeopoPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('zonValorEstruGeopoListLayer', 'O');
		visibilidad('zonValorEstruGeopoListButtonsLayer', 'O');
		if(get('zonValorEstruGeopoFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	zonValorEstruGeopoLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:zonValorEstruGeopoViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, zonValorEstruGeopoChoiceColumn) + "</A>",
			i, zonValorEstruGeopoChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	zonValorEstruGeopoList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	zonValorEstruGeopoTimeStamps = datosTmp.filtrar([23],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		zonValorEstruGeopoMorePagesFlag = true;
		zonValorEstruGeopoList.eliminar(mmgPageSize, 1);
	}else{
		zonValorEstruGeopoMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('zonValorEstruGeopoFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('zonValorEstruGeopoListLayer', 'V');
	visibilidad('zonValorEstruGeopoListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('zonValorEstruGeopoList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	zonValorEstruGeopoList.display();
	
	//Actualizamos el estado de los botones 
	if(zonValorEstruGeopoMorePagesFlag){
		set_estado_botonera('zonValorEstruGeopoPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('zonValorEstruGeopoPaginationButtonBar',
			3,"inactivo");
	}
	if(zonValorEstruGeopoPageCount > 1){
		set_estado_botonera('zonValorEstruGeopoPaginationButtonBar',
			2,"activo");
		set_estado_botonera('zonValorEstruGeopoPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('zonValorEstruGeopoPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('zonValorEstruGeopoPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function zonValorEstruGeopoUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonValorEstruGeopoList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('zonValorEstruGeopoFrm.idSelection', zonValorEstruGeopoList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('zonValorEstruGeopoFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = zonValorEstruGeopoList.codSeleccionados()[0];
		parametros["previousAction"] = get('zonValorEstruGeopoFrm.accion');
		parametros["accion"] = get('zonValorEstruGeopoFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('ZonValorEstruGeopoLPStartUp', get('zonValorEstruGeopoFrm.accion'), parametros, null, sizeFormView + 55);
		if(result == MMG_RC_OK) zonValorEstruGeopoCmdRequery();
	}
}

function zonValorEstruGeopoRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonValorEstruGeopoList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = zonValorEstruGeopoList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('zonValorEstruGeopoFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(zonValorEstruGeopoList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += zonValorEstruGeopoTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('zonValorEstruGeopoFrm.timestamp', timestamps);


	zonValorEstruGeopoFrm.oculto='S';
	envia('zonValorEstruGeopoFrm');
	zonValorEstruGeopoFrm.oculto='N';
}

function zonValorEstruGeopoViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonValorEstruGeopoList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	zonValorEstruGeopoViewDetail(zonValorEstruGeopoList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function zonValorEstruGeopoViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('zonValorEstruGeopoFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	mostrarModalSICC('ZonValorEstruGeopoLPStartUp', 'view', parametros, null, sizeFormView + 55);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('zonValorEstruGeopoFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		zonValorEstruGeopoFrm.oculto='S';
		envia('zonValorEstruGeopoFrm');
		zonValorEstruGeopoFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('zonValorEstruGeopoFrm.egeoOidEstrGeop').toString() == ''){
		set('zonValorEstruGeopoFrm.egeoOidEstrGeop', []);
		mmgResetCombosOnCascade('egeoOidEstrGeop', 'egeoOidEstrGeop', 'zonValorEstruGeopo');
		
	}
	if(get('zonValorEstruGeopoFrm.paisOidPais').toString() == ''){
		set('zonValorEstruGeopoFrm.paisOidPais_fopaOidFormPago', []);
		mmgResetCombosOnCascade('paisOidPais_fopaOidFormPago', 'paisOidPais', 'zonValorEstruGeopo');
		set('zonValorEstruGeopoFrm.paisOidPais_moneOidMoneAlt', []);
		mmgResetCombosOnCascade('paisOidPais_moneOidMoneAlt', 'paisOidPais', 'zonValorEstruGeopo');
		set('zonValorEstruGeopoFrm.paisOidPais_moneOidMone', []);
		mmgResetCombosOnCascade('paisOidPais_moneOidMone', 'paisOidPais', 'zonValorEstruGeopo');
		
	}
	if(get('zonValorEstruGeopoFrm.sgeoOidSubeGeop').toString() == ''){
		set('zonValorEstruGeopoFrm.sgeoOidSubeGeop_egeoOidEstrGeop', []);
		mmgResetCombosOnCascade('sgeoOidSubeGeop_egeoOidEstrGeop', 'sgeoOidSubeGeop', 'zonValorEstruGeopo');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	zonValorEstruGeopoRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('zonValorEstruGeopoFrm.accion');
	var origenTmp = get('zonValorEstruGeopoFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(zonValorEstruGeopoBuildUpdateRecordString() != zonValorEstruGeopoTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
		window.close();
	}else if(accionTmp == 'view'){
		window.close();
	}
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.zonValorEstruGeopoListLayer.style.display='none';
	document.all.zonValorEstruGeopoListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.zonValorEstruGeopoListLayer.style.display='';
	document.all.zonValorEstruGeopoListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsZonValorEstruGeopoCodUnidGeog = get('zonValorEstruGeopoFrm.codUnidGeog').toString();
	jsZonValorEstruGeopoDesGeog = get('zonValorEstruGeopoFrm.desGeog').toString();
	jsZonValorEstruGeopoCodNse1 = get('zonValorEstruGeopoFrm.codNse1').toString();
	jsZonValorEstruGeopoCodNse2 = get('zonValorEstruGeopoFrm.codNse2').toString();
	jsZonValorEstruGeopoCodNse3 = get('zonValorEstruGeopoFrm.codNse3').toString();
	jsZonValorEstruGeopoCodPost = get('zonValorEstruGeopoFrm.codPost').toString();
	jsZonValorEstruGeopoIndActi = get('zonValorEstruGeopoFrm.indActi').toString();
	jsZonValorEstruGeopoIndAsig = get('zonValorEstruGeopoFrm.indAsig').toString();
	jsZonValorEstruGeopoIndBorr = get('zonValorEstruGeopoFrm.indBorr').toString();
	jsZonValorEstruGeopoOrde1 = get('zonValorEstruGeopoFrm.orde1').toString();
	jsZonValorEstruGeopoOrde2 = get('zonValorEstruGeopoFrm.orde2').toString();
	jsZonValorEstruGeopoOrde3 = get('zonValorEstruGeopoFrm.orde3').toString();
	jsZonValorEstruGeopoOrde4 = get('zonValorEstruGeopoFrm.orde4').toString();
	jsZonValorEstruGeopoOrde5 = get('zonValorEstruGeopoFrm.orde5').toString();
	jsZonValorEstruGeopoOrde6 = get('zonValorEstruGeopoFrm.orde6').toString();
	jsZonValorEstruGeopoOrde7 = get('zonValorEstruGeopoFrm.orde7').toString();
	jsZonValorEstruGeopoOrde8 = get('zonValorEstruGeopoFrm.orde8').toString();
	jsZonValorEstruGeopoOrde9 = get('zonValorEstruGeopoFrm.orde9').toString();
	jsZonValorEstruGeopoEgeoOidEstrGeop = get('zonValorEstruGeopoFrm.egeoOidEstrGeop')[0];
	jsZonValorEstruGeopoPaisOidPais = get('zonValorEstruGeopoFrm.paisOidPais')[0];
	jsZonValorEstruGeopoFecActu = get('zonValorEstruGeopoFrm.fecActu').toString();
	jsZonValorEstruGeopoSgeoOidSubeGeop = get('zonValorEstruGeopoFrm.sgeoOidSubeGeop')[0];
	
	
	var parametros = "";
	parametros += jsZonValorEstruGeopoCodUnidGeog + "|";
	parametros += jsZonValorEstruGeopoDesGeog + "|";
	parametros += jsZonValorEstruGeopoCodNse1 + "|";
	parametros += jsZonValorEstruGeopoCodNse2 + "|";
	parametros += jsZonValorEstruGeopoCodNse3 + "|";
	parametros += jsZonValorEstruGeopoCodPost + "|";
	parametros += jsZonValorEstruGeopoIndActi + "|";
	parametros += jsZonValorEstruGeopoIndAsig + "|";
	parametros += jsZonValorEstruGeopoIndBorr + "|";
	parametros += jsZonValorEstruGeopoOrde1 + "|";
	parametros += jsZonValorEstruGeopoOrde2 + "|";
	parametros += jsZonValorEstruGeopoOrde3 + "|";
	parametros += jsZonValorEstruGeopoOrde4 + "|";
	parametros += jsZonValorEstruGeopoOrde5 + "|";
	parametros += jsZonValorEstruGeopoOrde6 + "|";
	parametros += jsZonValorEstruGeopoOrde7 + "|";
	parametros += jsZonValorEstruGeopoOrde8 + "|";
	parametros += jsZonValorEstruGeopoOrde9 + "|";
	parametros += jsZonValorEstruGeopoEgeoOidEstrGeop + "|";
	parametros += jsZonValorEstruGeopoPaisOidPais + "|";
	parametros += jsZonValorEstruGeopoFecActu + "|";
	parametros += jsZonValorEstruGeopoSgeoOidSubeGeop + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function zonValorEstruGeopoBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsZonValorEstruGeopoCodUnidGeog + "|";
	parametros += jsZonValorEstruGeopoDesGeog + "|";
	parametros += jsZonValorEstruGeopoCodNse1 + "|";
	parametros += jsZonValorEstruGeopoCodNse2 + "|";
	parametros += jsZonValorEstruGeopoCodNse3 + "|";
	parametros += jsZonValorEstruGeopoCodPost + "|";
	parametros += jsZonValorEstruGeopoIndActi + "|";
	parametros += jsZonValorEstruGeopoIndAsig + "|";
	parametros += jsZonValorEstruGeopoIndBorr + "|";
	parametros += jsZonValorEstruGeopoOrde1 + "|";
	parametros += jsZonValorEstruGeopoOrde2 + "|";
	parametros += jsZonValorEstruGeopoOrde3 + "|";
	parametros += jsZonValorEstruGeopoOrde4 + "|";
	parametros += jsZonValorEstruGeopoOrde5 + "|";
	parametros += jsZonValorEstruGeopoOrde6 + "|";
	parametros += jsZonValorEstruGeopoOrde7 + "|";
	parametros += jsZonValorEstruGeopoOrde8 + "|";
	parametros += jsZonValorEstruGeopoOrde9 + "|";
	parametros += jsZonValorEstruGeopoEgeoOidEstrGeop + "|";
	parametros += jsZonValorEstruGeopoPaisOidPais + "|";
	parametros += jsZonValorEstruGeopoFecActu + "|";
	parametros += jsZonValorEstruGeopoSgeoOidSubeGeop + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonValorEstruGeopoFrm.accion'), 
		get('zonValorEstruGeopoFrm.origen'));
	
	jsZonValorEstruGeopoId = get('zonValorEstruGeopoFrm.id').toString();
	jsZonValorEstruGeopoCodUnidGeog = get('zonValorEstruGeopoFrm.codUnidGeog').toString();
	jsZonValorEstruGeopoDesGeog = get('zonValorEstruGeopoFrm.desGeog').toString();
	jsZonValorEstruGeopoCodNse1 = get('zonValorEstruGeopoFrm.codNse1').toString();
	jsZonValorEstruGeopoCodNse2 = get('zonValorEstruGeopoFrm.codNse2').toString();
	jsZonValorEstruGeopoCodNse3 = get('zonValorEstruGeopoFrm.codNse3').toString();
	jsZonValorEstruGeopoCodPost = get('zonValorEstruGeopoFrm.codPost').toString();
	jsZonValorEstruGeopoIndActi = get('zonValorEstruGeopoFrm.indActi').toString();
	jsZonValorEstruGeopoIndAsig = get('zonValorEstruGeopoFrm.indAsig').toString();
	jsZonValorEstruGeopoIndBorr = get('zonValorEstruGeopoFrm.indBorr').toString();
	jsZonValorEstruGeopoOrde1 = get('zonValorEstruGeopoFrm.orde1').toString();
	jsZonValorEstruGeopoOrde2 = get('zonValorEstruGeopoFrm.orde2').toString();
	jsZonValorEstruGeopoOrde3 = get('zonValorEstruGeopoFrm.orde3').toString();
	jsZonValorEstruGeopoOrde4 = get('zonValorEstruGeopoFrm.orde4').toString();
	jsZonValorEstruGeopoOrde5 = get('zonValorEstruGeopoFrm.orde5').toString();
	jsZonValorEstruGeopoOrde6 = get('zonValorEstruGeopoFrm.orde6').toString();
	jsZonValorEstruGeopoOrde7 = get('zonValorEstruGeopoFrm.orde7').toString();
	jsZonValorEstruGeopoOrde8 = get('zonValorEstruGeopoFrm.orde8').toString();
	jsZonValorEstruGeopoOrde9 = get('zonValorEstruGeopoFrm.orde9').toString();
	jsZonValorEstruGeopoEgeoOidEstrGeop = get('zonValorEstruGeopoFrm.egeoOidEstrGeop')[0];
	jsZonValorEstruGeopoPaisOidPais = get('zonValorEstruGeopoFrm.paisOidPais')[0];
	jsZonValorEstruGeopoFecActu = get('zonValorEstruGeopoFrm.fecActu').toString();
	jsZonValorEstruGeopoSgeoOidSubeGeop = get('zonValorEstruGeopoFrm.sgeoOidSubeGeop')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonValorEstruGeopoFrm.accion'), 
		get('zonValorEstruGeopoFrm.origen'));


	set('zonValorEstruGeopoFrm.id', jsZonValorEstruGeopoId);
	set('zonValorEstruGeopoFrm.codUnidGeog', jsZonValorEstruGeopoCodUnidGeog);
	set('zonValorEstruGeopoFrm.desGeog', jsZonValorEstruGeopoDesGeog);
	set('zonValorEstruGeopoFrm.codNse1', jsZonValorEstruGeopoCodNse1);
	set('zonValorEstruGeopoFrm.codNse2', jsZonValorEstruGeopoCodNse2);
	set('zonValorEstruGeopoFrm.codNse3', jsZonValorEstruGeopoCodNse3);
	set('zonValorEstruGeopoFrm.codPost', jsZonValorEstruGeopoCodPost);
	set('zonValorEstruGeopoFrm.indActi', jsZonValorEstruGeopoIndActi);
	set('zonValorEstruGeopoFrm.indAsig', jsZonValorEstruGeopoIndAsig);
	set('zonValorEstruGeopoFrm.indBorr', jsZonValorEstruGeopoIndBorr);
	set('zonValorEstruGeopoFrm.orde1', jsZonValorEstruGeopoOrde1);
	set('zonValorEstruGeopoFrm.orde2', jsZonValorEstruGeopoOrde2);
	set('zonValorEstruGeopoFrm.orde3', jsZonValorEstruGeopoOrde3);
	set('zonValorEstruGeopoFrm.orde4', jsZonValorEstruGeopoOrde4);
	set('zonValorEstruGeopoFrm.orde5', jsZonValorEstruGeopoOrde5);
	set('zonValorEstruGeopoFrm.orde6', jsZonValorEstruGeopoOrde6);
	set('zonValorEstruGeopoFrm.orde7', jsZonValorEstruGeopoOrde7);
	set('zonValorEstruGeopoFrm.orde8', jsZonValorEstruGeopoOrde8);
	set('zonValorEstruGeopoFrm.orde9', jsZonValorEstruGeopoOrde9);
	set('zonValorEstruGeopoFrm.egeoOidEstrGeop', [jsZonValorEstruGeopoEgeoOidEstrGeop]);
	set('zonValorEstruGeopoFrm.paisOidPais', [jsZonValorEstruGeopoPaisOidPais]);
	set('zonValorEstruGeopoFrm.fecActu', jsZonValorEstruGeopoFecActu);
	set('zonValorEstruGeopoFrm.sgeoOidSubeGeop', [jsZonValorEstruGeopoSgeoOidSubeGeop]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realziar la búsqueda
	jsZonValorEstruGeopoCodUnidGeog = '';
	jsZonValorEstruGeopoDesGeog = '';
	jsZonValorEstruGeopoCodNse1 = '';
	jsZonValorEstruGeopoCodNse2 = '';
	jsZonValorEstruGeopoCodNse3 = '';
	jsZonValorEstruGeopoCodPost = '';
	jsZonValorEstruGeopoIndActi = '';
	jsZonValorEstruGeopoIndAsig = '';
	jsZonValorEstruGeopoIndBorr = '';
	jsZonValorEstruGeopoOrde1 = '';
	jsZonValorEstruGeopoOrde2 = '';
	jsZonValorEstruGeopoOrde3 = '';
	jsZonValorEstruGeopoOrde4 = '';
	jsZonValorEstruGeopoOrde5 = '';
	jsZonValorEstruGeopoOrde6 = '';
	jsZonValorEstruGeopoOrde7 = '';
	jsZonValorEstruGeopoOrde8 = '';
	jsZonValorEstruGeopoOrde9 = '';
	jsZonValorEstruGeopoEgeoOidEstrGeop = '';
	jsZonValorEstruGeopoPaisOidPais = '';
	jsZonValorEstruGeopoFecActu = '';
	jsZonValorEstruGeopoSgeoOidSubeGeop = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('zonValorEstruGeopoFrm.errCodigo', errorCode);
	set('zonValorEstruGeopoFrm.errDescripcion', description);
	set('zonValorEstruGeopoFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	



/*
    INDRA/CAR/mmg
    $Id: carparamcarte.js,v 1.1 2009/12/03 19:01:30 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCarParamCarteId = "";
var jsCarParamCartePaisOidPais = "";
var jsCarParamCarteGrsoOidGrupSoli = "";
var jsCarParamCarteNiriOidNiveRies = "";
var jsCarParamCarteCodConf = "";
var jsCarParamCarteIndDeudVenc = "";
var jsCarParamCarteNumDiasDeudVenc = "";
var jsCarParamCarteIndLineCred = "";
var jsCarParamCarteFecVigeDesd = "";
var jsCarParamCarteFecVigeHast = "";
var jsCarParamCarteValPorcVali = "";
var jsCarParamCarteIndMontMaxi = "";
var jsCarParamCarteValMontMaxiPerm = "";
var jsCarParamCarteIndPorcMaxi = "";
var jsCarParamCarteValPorc = "";
var jsCarParamCarteNumDiasAdic = "";
var jsCarParamCarteInvaOidIndiVali = "";

//Variables de paginacion, 
var carParamCartePageCount = 1;

//Varible de columna que representa el campo de choice
var carParamCarteChoiceColumn = 16;

//Flag de siguiente pagina;
var carParamCarteMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var carParamCarteTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 885;
var sizeFormView = 885;
var sizeFormUpdate = 885;

//Ultima busqueda realizada
var carParamCarteLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focalizaComboDependence("carParamCarte","invaOidIndiVali", false);','focalizaComboDependence("carParamCarte","invaOidIndiVali", false);','focalizaComboDependence("carParamCarte","invaOidIndiVali", false);','focalizaComboDependence("carParamCarte","invaOidIndiVali", true);','focalizaComboDependence("carParamCarte","invaOidIndiVali", true);','focalizaComboDependence("carParamCarte","invaOidIndiVali", true);']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_moneOidMone', padresTmp, 'paisOidPais', 'SegMoned']);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_moneOidMoneAlt', padresTmp, 'paisOidPais', 'SegMoned']);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_fopaOidFormPago', padresTmp, 'paisOidPais', 'BelFormaPagoTapon']);
padresTmp =  new Vector();
padresTmp.cargar(['paisOidPais_moneOidMone','paisOidPais_moneOidMoneAlt','paisOidPais_fopaOidFormPago'])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPais']);
var grsoOidGrupSoliDependeceMap = new Vector();
grsoOidGrupSoliDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
grsoOidGrupSoliDependeceMap.agregar(['grsoOidGrupSoli', padresTmp, '', 'CarGrupoSolic']);
var niriOidNiveRiesDependeceMap = new Vector();
niriOidNiveRiesDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
niriOidNiveRiesDependeceMap.agregar(['niriOidNiveRies', padresTmp, '', 'CarNivelRiesg']);
var invaOidIndiValiDependeceMap = new Vector();
invaOidIndiValiDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
invaOidIndiValiDependeceMap.agregar(['invaOidIndiVali', padresTmp, '', 'CarIndicValid']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
carParamCarteLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var carParamCarteTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function carParamCarteInitComponents(){
	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('carParamCarteFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('carParamCarteFrm.accion')){
		case "query": carParamCarteQueryInitComponents(); break;
		case "view": carParamCarteViewInitComponents(); break;
		case "create": carParamCarteCreateInitComponents(); break;
		case "update": carParamCarteUpdateInitComponents(); break;
		case "remove": carParamCarteRemoveInitComponents(); break;
		case "lov": carParamCarteLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('carParamCarteFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('carParamCarte')) carParamCarteCmdRequery();
}

function carParamCarteQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

function carParamCarteViewInitComponents(){
	//En principiono se hace nada
}

function carParamCarteCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('carParamCarteFrm.paisOidPais','S', GestionarMensaje('CarParamCarte.paisOidPais.requiered.message'));
	
	setMV('carParamCarteFrm.grsoOidGrupSoli','S', GestionarMensaje('CarParamCarte.grsoOidGrupSoli.requiered.message'));
	
	setMV('carParamCarteFrm.niriOidNiveRies','S', GestionarMensaje('CarParamCarte.niriOidNiveRies.requiered.message'));
	
	setMV('carParamCarteFrm.codConf','S', GestionarMensaje('CarParamCarte.codConf.requiered.message'));
	
	setMV('carParamCarteFrm.indDeudVenc','S', GestionarMensaje('CarParamCarte.indDeudVenc.requiered.message'));
	
	setMV('carParamCarteFrm.indLineCred','S', GestionarMensaje('CarParamCarte.indLineCred.requiered.message'));
	
	setMV('carParamCarteFrm.indMontMaxi','S', GestionarMensaje('CarParamCarte.indMontMaxi.requiered.message'));
	
	setMV('carParamCarteFrm.indPorcMaxi','S', GestionarMensaje('CarParamCarte.indPorcMaxi.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function carParamCarteUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('carParamCarteFrm.origen') == "pagina"){
		

		//Registramos el valor del elemento que estamos modificando
		carParamCarteTmpUpdateValues = carParamCarteBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('carParamCarteFrm.paisOidPais','S', GestionarMensaje('CarParamCarte.paisOidPais.requiered.message'));
		
		setMV('carParamCarteFrm.grsoOidGrupSoli','S', GestionarMensaje('CarParamCarte.grsoOidGrupSoli.requiered.message'));
		
		setMV('carParamCarteFrm.niriOidNiveRies','S', GestionarMensaje('CarParamCarte.niriOidNiveRies.requiered.message'));
		
		setMV('carParamCarteFrm.codConf','S', GestionarMensaje('CarParamCarte.codConf.requiered.message'));
		
		setMV('carParamCarteFrm.indDeudVenc','S', GestionarMensaje('CarParamCarte.indDeudVenc.requiered.message'));
		
		setMV('carParamCarteFrm.indLineCred','S', GestionarMensaje('CarParamCarte.indLineCred.requiered.message'));
		
		setMV('carParamCarteFrm.indMontMaxi','S', GestionarMensaje('CarParamCarte.indMontMaxi.requiered.message'));
		
		setMV('carParamCarteFrm.indPorcMaxi','S', GestionarMensaje('CarParamCarte.indPorcMaxi.requiered.message'));
		
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('carParamCarteFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function carParamCarteRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	carParamCarteList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function carParamCarteLovInitComponents(){
	carParamCarteLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad



















//Función que permite cargar los datos de un elemento de lov seleccionado
function carParamCarteSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('carParamCarteFrm.' + campo, id);
	set('carParamCarteFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function carParamCarteLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	carParamCarteLovReturnParameters.id = '';
	carParamCarteLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function carParamCarteLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carParamCarteList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = carParamCarteList.codSeleccionados();
	var descripcion = carParamCarteList.extraeDato(
		carParamCarteList.codSeleccionados()[0], carParamCarteChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	carParamCarteLovReturnParameters.id = codigo;
	carParamCarteLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function carParamCarteCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('carParamCarteFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	carParamCarteLastQuery = parametros;

	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('carParamCarteFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "carParamCarteList", "CarParamCarteConectorTransactionQuery", 
		"result_ROWSET", parametros, "carParamCartePostQueryActions(datos);"]], "", "");	
}

function carParamCarteCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('carParamCarteFrm.lastQueryToSession'));
	var i =0;
	set('carParamCarteFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('carParamCarteFrm.grsoOidGrupSoli', [paramsRequery.ij(i++)]);
	
	set('carParamCarteFrm.niriOidNiveRies', [paramsRequery.ij(i++)]);
	
	set('carParamCarteFrm.codConf', paramsRequery.ij(i++));
	
	set('carParamCarteFrm.indDeudVenc', paramsRequery.ij(i++));
	
	set('carParamCarteFrm.numDiasDeudVenc', paramsRequery.ij(i++));
	
	set('carParamCarteFrm.indLineCred', paramsRequery.ij(i++));
	
	set('carParamCarteFrm.fecVigeDesd', paramsRequery.ij(i++));
	
	set('carParamCarteFrm.fecVigeHast', paramsRequery.ij(i++));
	
	set('carParamCarteFrm.valPorcVali', paramsRequery.ij(i++));
	
	set('carParamCarteFrm.indMontMaxi', paramsRequery.ij(i++));
	
	set('carParamCarteFrm.valMontMaxiPerm', paramsRequery.ij(i++));
	
	set('carParamCarteFrm.indPorcMaxi', paramsRequery.ij(i++));
	
	set('carParamCarteFrm.valPorc', paramsRequery.ij(i++));
	
	set('carParamCarteFrm.numDiasAdic', paramsRequery.ij(i++));
	
	set('carParamCarteFrm.invaOidIndiVali', [paramsRequery.ij(i++)]);
	
	
	
	//No se nos actualizar los parmámetros de la paginación
	carParamCartePageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	carParamCarteCmdQuery(carParamCartePageCount);
}

function carParamCarteFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	carParamCartePageCount = 1;
	carParamCarteCmdQuery(carParamCartePageCount);
}

function carParamCartePreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != carParamCarteLastQuery){
		carParamCarteFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	carParamCartePageCount--;
	carParamCarteCmdQuery(carParamCartePageCount);
}

function carParamCarteNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != carParamCarteLastQuery){
		carParamCarteFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	carParamCartePageCount++;
	carParamCarteCmdQuery(carParamCartePageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function carParamCartePostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('carParamCarteListLayer', 'O');
		visibilidad('carParamCarteListButtonsLayer', 'O');
		if(get('carParamCarteFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:carParamCarteViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, carParamCarteChoiceColumn) + "</A>",
			i, carParamCarteChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	carParamCarteList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	carParamCarteTimeStamps = datosTmp.filtrar([17],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		carParamCarteMorePagesFlag = true;
		carParamCarteList.eliminar(mmgPageSize, 1);
	}else{
		carParamCarteMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('carParamCarteFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('carParamCarteListLayer', 'V');
	visibilidad('carParamCarteListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('carParamCarteList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	carParamCarteList.display();
	
	//Actualizamos el estado de los botones 
	if(carParamCarteMorePagesFlag){
		set_estado_botonera('carParamCartePaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('carParamCartePaginationButtonBar',
			3,"inactivo");
	}
	if(carParamCartePageCount > 1){
		set_estado_botonera('carParamCartePaginationButtonBar',
			2,"activo");
		set_estado_botonera('carParamCartePaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('carParamCartePaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('carParamCartePaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function carParamCarteUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carParamCarteList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('carParamCarteFrm.idSelection', carParamCarteList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('carParamCarteFrm', true);
	if(validacion){
		/*set('carParamCarteFrm.previousAction', 'update');
		set('carParamCarteFrm.ON', 'CarParamCarteLPStartUp');
		set('carParamCarteFrm.conectorAction', 'CarParamCarteLPStartUp');
		set('carParamCarteFrm.origen', 'pagina');
		envia('carParamCarteFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = carParamCarteList.codSeleccionados()[0];
		parametros["previousAction"] = get('carParamCarteFrm.accion');
		parametros["accion"] = get('carParamCarteFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('CarParamCarteLPStartUp', get('carParamCarteFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) carParamCarteCmdRequery();
	}
}

function carParamCarteRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carParamCarteList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = carParamCarteList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('carParamCarteFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(carParamCarteList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += carParamCarteTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('carParamCarteFrm.timestamp', timestamps);
	envia('carParamCarteFrm');
}

function carParamCarteViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carParamCarteList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('carParamCarteFrm.previousAction', get('carParamCarteFrm.accion'));
	set('carParamCarteFrm.accion', 'view');
	set('carParamCarteFrm.origen', 'pagina');
	set('carParamCarteFrm.ON', 'CarParamCarteLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('carParamCarteFrm.idSelection', carParamCarteList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('carParamCarteFrm');
	carParamCarteViewDetail(carParamCarteList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function carParamCarteViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('carParamCarteFrm.accion');
	parametros["accion"] = get('carParamCarteFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('CarParamCarteLPStartUp', get('carParamCarteFrm.accion'), parametros, null, sizeFormView + 30);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar on dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('carParamCarteFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion)envia('carParamCarteFrm');
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	carParamCarteRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('carParamCarteFrm.accion');
	var origenTmp = get('carParamCarteFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(carParamCarteBuildUpdateRecordString() != carParamCarteTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('carParamCarteFrm.performRequery', 'true');
		set('carParamCarteFrm.accion', 
			get('carParamCarteFrm.previousAction'));
		set('carParamCarteFrm.origen', 'menu');
		set('carParamCarteFrm.ON', 'CarParamCarteLPStartUp');
		set('carParamCarteFrm.conectorAction', 'CarParamCarteLPStartUp');
		carParamCarteFrm.oculto='N';
		envia('carParamCarteFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.carParamCarteListLayer.style.display='none';
	document.all.carParamCarteListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.carParamCarteListLayer.style.display='';
	document.all.carParamCarteListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda

	jsCarParamCartePaisOidPais = get('carParamCarteFrm.paisOidPais')[0];





	jsCarParamCarteGrsoOidGrupSoli = get('carParamCarteFrm.grsoOidGrupSoli')[0];





	jsCarParamCarteNiriOidNiveRies = get('carParamCarteFrm.niriOidNiveRies')[0];




	jsCarParamCarteCodConf = get('carParamCarteFrm.codConf').toString();






	jsCarParamCarteIndDeudVenc = get('carParamCarteFrm.indDeudVenc').toString();






	jsCarParamCarteNumDiasDeudVenc = get('carParamCarteFrm.numDiasDeudVenc').toString();






	jsCarParamCarteIndLineCred = get('carParamCarteFrm.indLineCred').toString();






	jsCarParamCarteFecVigeDesd = get('carParamCarteFrm.fecVigeDesd').toString();






	jsCarParamCarteFecVigeHast = get('carParamCarteFrm.fecVigeHast').toString();






	jsCarParamCarteValPorcVali = get('carParamCarteFrm.valPorcVali').toString();






	jsCarParamCarteIndMontMaxi = get('carParamCarteFrm.indMontMaxi').toString();






	jsCarParamCarteValMontMaxiPerm = get('carParamCarteFrm.valMontMaxiPerm').toString();






	jsCarParamCarteIndPorcMaxi = get('carParamCarteFrm.indPorcMaxi').toString();






	jsCarParamCarteValPorc = get('carParamCarteFrm.valPorc').toString();






	jsCarParamCarteNumDiasAdic = get('carParamCarteFrm.numDiasAdic').toString();







	jsCarParamCarteInvaOidIndiVali = get('carParamCarteFrm.invaOidIndiVali')[0];






	var parametros = "";
	parametros += jsCarParamCartePaisOidPais + "|";



	parametros += jsCarParamCarteGrsoOidGrupSoli + "|";



	parametros += jsCarParamCarteNiriOidNiveRies + "|";



	parametros += jsCarParamCarteCodConf + "|";



	parametros += jsCarParamCarteIndDeudVenc + "|";



	parametros += jsCarParamCarteNumDiasDeudVenc + "|";



	parametros += jsCarParamCarteIndLineCred + "|";



	parametros += jsCarParamCarteFecVigeDesd + "|";



	parametros += jsCarParamCarteFecVigeHast + "|";



	parametros += jsCarParamCarteValPorcVali + "|";



	parametros += jsCarParamCarteIndMontMaxi + "|";



	parametros += jsCarParamCarteValMontMaxiPerm + "|";



	parametros += jsCarParamCarteIndPorcMaxi + "|";



	parametros += jsCarParamCarteValPorc + "|";



	parametros += jsCarParamCarteNumDiasAdic + "|";



	parametros += jsCarParamCarteInvaOidIndiVali + "|";




	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function carParamCarteBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCarParamCartePaisOidPais + "|";
	parametros += jsCarParamCarteGrsoOidGrupSoli + "|";
	parametros += jsCarParamCarteNiriOidNiveRies + "|";
	parametros += jsCarParamCarteCodConf + "|";
	parametros += jsCarParamCarteIndDeudVenc + "|";
	parametros += jsCarParamCarteNumDiasDeudVenc + "|";
	parametros += jsCarParamCarteIndLineCred + "|";
	parametros += jsCarParamCarteFecVigeDesd + "|";
	parametros += jsCarParamCarteFecVigeHast + "|";
	parametros += jsCarParamCarteValPorcVali + "|";
	parametros += jsCarParamCarteIndMontMaxi + "|";
	parametros += jsCarParamCarteValMontMaxiPerm + "|";
	parametros += jsCarParamCarteIndPorcMaxi + "|";
	parametros += jsCarParamCarteValPorc + "|";
	parametros += jsCarParamCarteNumDiasAdic + "|";
	parametros += jsCarParamCarteInvaOidIndiVali + "|";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carParamCarteFrm.accion'), 
		get('carParamCarteFrm.origen'));
	
	jsCarParamCarteId = get('carParamCarteFrm.id').toString();
	jsCarParamCartePaisOidPais = get('carParamCarteFrm.paisOidPais')[0];
	jsCarParamCarteGrsoOidGrupSoli = get('carParamCarteFrm.grsoOidGrupSoli')[0];
	jsCarParamCarteNiriOidNiveRies = get('carParamCarteFrm.niriOidNiveRies')[0];
	jsCarParamCarteCodConf = get('carParamCarteFrm.codConf').toString();
	jsCarParamCarteIndDeudVenc = get('carParamCarteFrm.indDeudVenc').toString();
	jsCarParamCarteNumDiasDeudVenc = get('carParamCarteFrm.numDiasDeudVenc').toString();
	jsCarParamCarteIndLineCred = get('carParamCarteFrm.indLineCred').toString();
	jsCarParamCarteFecVigeDesd = get('carParamCarteFrm.fecVigeDesd').toString();
	jsCarParamCarteFecVigeHast = get('carParamCarteFrm.fecVigeHast').toString();
	jsCarParamCarteValPorcVali = get('carParamCarteFrm.valPorcVali').toString();
	jsCarParamCarteIndMontMaxi = get('carParamCarteFrm.indMontMaxi').toString();
	jsCarParamCarteValMontMaxiPerm = get('carParamCarteFrm.valMontMaxiPerm').toString();
	jsCarParamCarteIndPorcMaxi = get('carParamCarteFrm.indPorcMaxi').toString();
	jsCarParamCarteValPorc = get('carParamCarteFrm.valPorc').toString();
	jsCarParamCarteNumDiasAdic = get('carParamCarteFrm.numDiasAdic').toString();
	jsCarParamCarteInvaOidIndiVali = get('carParamCarteFrm.invaOidIndiVali')[0];

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carParamCarteFrm.accion'), 
		get('carParamCarteFrm.origen'));


	set('carParamCarteFrm.id', jsCarParamCarteId);
	set('carParamCarteFrm.paisOidPais', [jsCarParamCartePaisOidPais]);
	set('carParamCarteFrm.grsoOidGrupSoli', [jsCarParamCarteGrsoOidGrupSoli]);
	set('carParamCarteFrm.niriOidNiveRies', [jsCarParamCarteNiriOidNiveRies]);
	set('carParamCarteFrm.codConf', jsCarParamCarteCodConf);
	set('carParamCarteFrm.indDeudVenc', jsCarParamCarteIndDeudVenc);
	set('carParamCarteFrm.numDiasDeudVenc', jsCarParamCarteNumDiasDeudVenc);
	set('carParamCarteFrm.indLineCred', jsCarParamCarteIndLineCred);
	set('carParamCarteFrm.fecVigeDesd', jsCarParamCarteFecVigeDesd);
	set('carParamCarteFrm.fecVigeHast', jsCarParamCarteFecVigeHast);
	set('carParamCarteFrm.valPorcVali', jsCarParamCarteValPorcVali);
	set('carParamCarteFrm.indMontMaxi', jsCarParamCarteIndMontMaxi);
	set('carParamCarteFrm.valMontMaxiPerm', jsCarParamCarteValMontMaxiPerm);
	set('carParamCarteFrm.indPorcMaxi', jsCarParamCarteIndPorcMaxi);
	set('carParamCarteFrm.valPorc', jsCarParamCarteValPorc);
	set('carParamCarteFrm.numDiasAdic', jsCarParamCarteNumDiasAdic);
	set('carParamCarteFrm.invaOidIndiVali', [jsCarParamCarteInvaOidIndiVali]);

}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('carParamCarteFrm.errCodigo', errorCode);
	set('carParamCarteFrm.errDescripcion', description);
	set('carParamCarteFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	

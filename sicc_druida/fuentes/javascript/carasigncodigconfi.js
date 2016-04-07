

/*
    INDRA/CAR/mmg
    $Id: carasigncodigconfi.js,v 1.1 2009/12/03 19:01:52 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCarAsignCodigConfiId = "";
var jsCarAsignCodigConfiZsgvOidSubgVent = "";
var jsCarAsignCodigConfiZorgOidRegi = "";
var jsCarAsignCodigConfiZzonOidZona = "";
var jsCarAsignCodigConfiGrsoOidGrupSoli = "";
var jsCarAsignCodigConfiNiriOidNiveRies = "";
var jsCarAsignCodigConfiNiriOidNiveRiesInici = "";
var jsCarAsignCodigConfiPacaOidParaCart = "";
var jsCarAsignCodigConfiValLineCredInic = "";

//Variables de paginacion, 
var carAsignCodigConfiPageCount = 1;

//Varible de columna que representa el campo de choice
var carAsignCodigConfiChoiceColumn = 8;

//Flag de siguiente pagina;
var carAsignCodigConfiMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var carAsignCodigConfiTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 605;
var sizeFormView = 605;
var sizeFormUpdate = 605;

//Ultima busqueda realizada
var carAsignCodigConfiLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("carAsignCodigConfiFrm.valLineCredInic");','focaliza("carAsignCodigConfiFrm.valLineCredInic");','focaliza("carAsignCodigConfiFrm.valLineCredInic");','focaliza("carAsignCodigConfiFrm.valLineCredInic");','focaliza("carAsignCodigConfiFrm.valLineCredInic");','focaliza("carAsignCodigConfiFrm.valLineCredInic");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var zsgvOidSubgVentDependeceMap = new Vector();
zsgvOidSubgVentDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zsgvOidSubgVentDependeceMap.agregar(['zsgvOidSubgVent', padresTmp, '', 'ZonSubGerenVenta']);
var zorgOidRegiDependeceMap = new Vector();
zorgOidRegiDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zorgOidRegiDependeceMap.agregar(['zorgOidRegi', padresTmp, '', 'ZonRegio']);
var zzonOidZonaDependeceMap = new Vector();
zzonOidZonaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zzonOidZonaDependeceMap.agregar(['zzonOidZona', padresTmp, '', 'ZonZona']);
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
var niriOidNiveRiesIniciDependeceMap = new Vector();
niriOidNiveRiesIniciDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
niriOidNiveRiesIniciDependeceMap.agregar(['niriOidNiveRiesInici', padresTmp, '', 'CarNivelRiesg']);
var pacaOidParaCartDependeceMap = new Vector();
pacaOidParaCartDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
pacaOidParaCartDependeceMap.agregar(['pacaOidParaCart', padresTmp, '', 'CarParamCarte']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
carAsignCodigConfiLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var carAsignCodigConfiTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function carAsignCodigConfiInitComponents(){
	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('carAsignCodigConfiFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('carAsignCodigConfiFrm.accion')){
		case "query": carAsignCodigConfiQueryInitComponents(); break;
		case "view": carAsignCodigConfiViewInitComponents(); break;
		case "create": carAsignCodigConfiCreateInitComponents(); break;
		case "update": carAsignCodigConfiUpdateInitComponents(); break;
		case "remove": carAsignCodigConfiRemoveInitComponents(); break;
		case "lov": carAsignCodigConfiLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('carAsignCodigConfiFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('carAsignCodigConfi')) carAsignCodigConfiCmdRequery();
}

function carAsignCodigConfiQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
}

function carAsignCodigConfiViewInitComponents(){
	//En principiono se hace nada
}

function carAsignCodigConfiCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('carAsignCodigConfiFrm.zsgvOidSubgVent','S', GestionarMensaje('CarAsignCodigConfi.zsgvOidSubgVent.requiered.message'));
	
	setMV('carAsignCodigConfiFrm.zorgOidRegi','S', GestionarMensaje('CarAsignCodigConfi.zorgOidRegi.requiered.message'));
	
	setMV('carAsignCodigConfiFrm.zzonOidZona','S', GestionarMensaje('CarAsignCodigConfi.zzonOidZona.requiered.message'));
	
	setMV('carAsignCodigConfiFrm.grsoOidGrupSoli','S', GestionarMensaje('CarAsignCodigConfi.grsoOidGrupSoli.requiered.message'));
	
	setMV('carAsignCodigConfiFrm.niriOidNiveRies','S', GestionarMensaje('CarAsignCodigConfi.niriOidNiveRies.requiered.message'));
	
	setMV('carAsignCodigConfiFrm.niriOidNiveRiesInici','S', GestionarMensaje('CarAsignCodigConfi.niriOidNiveRiesInici.requiered.message'));
	
	setMV('carAsignCodigConfiFrm.pacaOidParaCart','S', GestionarMensaje('CarAsignCodigConfi.pacaOidParaCart.requiered.message'));
	
	setMV('carAsignCodigConfiFrm.valLineCredInic','S', GestionarMensaje('CarAsignCodigConfi.valLineCredInic.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function carAsignCodigConfiUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('carAsignCodigConfiFrm.origen') == "pagina"){
		

		//Registramos el valor del elemento que estamos modificando
		carAsignCodigConfiTmpUpdateValues = carAsignCodigConfiBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('carAsignCodigConfiFrm.zsgvOidSubgVent','S', GestionarMensaje('CarAsignCodigConfi.zsgvOidSubgVent.requiered.message'));
		
		setMV('carAsignCodigConfiFrm.zorgOidRegi','S', GestionarMensaje('CarAsignCodigConfi.zorgOidRegi.requiered.message'));
		
		setMV('carAsignCodigConfiFrm.zzonOidZona','S', GestionarMensaje('CarAsignCodigConfi.zzonOidZona.requiered.message'));
		
		setMV('carAsignCodigConfiFrm.grsoOidGrupSoli','S', GestionarMensaje('CarAsignCodigConfi.grsoOidGrupSoli.requiered.message'));
		
		setMV('carAsignCodigConfiFrm.niriOidNiveRies','S', GestionarMensaje('CarAsignCodigConfi.niriOidNiveRies.requiered.message'));
		
		setMV('carAsignCodigConfiFrm.niriOidNiveRiesInici','S', GestionarMensaje('CarAsignCodigConfi.niriOidNiveRiesInici.requiered.message'));
		
		setMV('carAsignCodigConfiFrm.pacaOidParaCart','S', GestionarMensaje('CarAsignCodigConfi.pacaOidParaCart.requiered.message'));
		
		setMV('carAsignCodigConfiFrm.valLineCredInic','S', GestionarMensaje('CarAsignCodigConfi.valLineCredInic.requiered.message'));
		
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('carAsignCodigConfiFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function carAsignCodigConfiRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	carAsignCodigConfiList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function carAsignCodigConfiLovInitComponents(){
	carAsignCodigConfiLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad











//Función que permite cargar los datos de un elemento de lov seleccionado
function carAsignCodigConfiSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('carAsignCodigConfiFrm.' + campo, id);
	set('carAsignCodigConfiFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function carAsignCodigConfiLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	carAsignCodigConfiLovReturnParameters.id = '';
	carAsignCodigConfiLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function carAsignCodigConfiLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carAsignCodigConfiList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = carAsignCodigConfiList.codSeleccionados();
	var descripcion = carAsignCodigConfiList.extraeDato(
		carAsignCodigConfiList.codSeleccionados()[0], carAsignCodigConfiChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	carAsignCodigConfiLovReturnParameters.id = codigo;
	carAsignCodigConfiLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function carAsignCodigConfiCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('carAsignCodigConfiFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	carAsignCodigConfiLastQuery = parametros;

	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('carAsignCodigConfiFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "carAsignCodigConfiList", "CarAsignCodigConfiConectorTransactionQuery", 
		"result_ROWSET", parametros, "carAsignCodigConfiPostQueryActions(datos);"]], "", "");	
}

function carAsignCodigConfiCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('carAsignCodigConfiFrm.lastQueryToSession'));
	var i =0;
	set('carAsignCodigConfiFrm.zsgvOidSubgVent', [paramsRequery.ij(i++)]);
	
	set('carAsignCodigConfiFrm.zorgOidRegi', [paramsRequery.ij(i++)]);
	
	set('carAsignCodigConfiFrm.zzonOidZona', [paramsRequery.ij(i++)]);
	
	set('carAsignCodigConfiFrm.grsoOidGrupSoli', [paramsRequery.ij(i++)]);
	
	set('carAsignCodigConfiFrm.niriOidNiveRies', [paramsRequery.ij(i++)]);
	
	set('carAsignCodigConfiFrm.niriOidNiveRiesInici', [paramsRequery.ij(i++)]);
	
	set('carAsignCodigConfiFrm.pacaOidParaCart', [paramsRequery.ij(i++)]);
	
	set('carAsignCodigConfiFrm.valLineCredInic', paramsRequery.ij(i++));
	
	
	
	//No se nos actualizar los parmámetros de la paginación
	carAsignCodigConfiPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	carAsignCodigConfiCmdQuery(carAsignCodigConfiPageCount);
}

function carAsignCodigConfiFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	carAsignCodigConfiPageCount = 1;
	carAsignCodigConfiCmdQuery(carAsignCodigConfiPageCount);
}

function carAsignCodigConfiPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != carAsignCodigConfiLastQuery){
		carAsignCodigConfiFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	carAsignCodigConfiPageCount--;
	carAsignCodigConfiCmdQuery(carAsignCodigConfiPageCount);
}

function carAsignCodigConfiNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != carAsignCodigConfiLastQuery){
		carAsignCodigConfiFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	carAsignCodigConfiPageCount++;
	carAsignCodigConfiCmdQuery(carAsignCodigConfiPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function carAsignCodigConfiPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('carAsignCodigConfiListLayer', 'O');
		visibilidad('carAsignCodigConfiListButtonsLayer', 'O');
		if(get('carAsignCodigConfiFrm.accion') == "remove"){
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
		datosTmp.ij2("<A HREF=\'javascript:carAsignCodigConfiViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, carAsignCodigConfiChoiceColumn) + "</A>",
			i, carAsignCodigConfiChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	carAsignCodigConfiList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	carAsignCodigConfiTimeStamps = datosTmp.filtrar([9],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		carAsignCodigConfiMorePagesFlag = true;
		carAsignCodigConfiList.eliminar(mmgPageSize, 1);
	}else{
		carAsignCodigConfiMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('carAsignCodigConfiFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('carAsignCodigConfiListLayer', 'V');
	visibilidad('carAsignCodigConfiListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('carAsignCodigConfiList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	carAsignCodigConfiList.display();
	
	//Actualizamos el estado de los botones 
	if(carAsignCodigConfiMorePagesFlag){
		set_estado_botonera('carAsignCodigConfiPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('carAsignCodigConfiPaginationButtonBar',
			3,"inactivo");
	}
	if(carAsignCodigConfiPageCount > 1){
		set_estado_botonera('carAsignCodigConfiPaginationButtonBar',
			2,"activo");
		set_estado_botonera('carAsignCodigConfiPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('carAsignCodigConfiPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('carAsignCodigConfiPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function carAsignCodigConfiUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carAsignCodigConfiList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('carAsignCodigConfiFrm.idSelection', carAsignCodigConfiList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('carAsignCodigConfiFrm', true);
	if(validacion){
		/*set('carAsignCodigConfiFrm.previousAction', 'update');
		set('carAsignCodigConfiFrm.ON', 'CarAsignCodigConfiLPStartUp');
		set('carAsignCodigConfiFrm.conectorAction', 'CarAsignCodigConfiLPStartUp');
		set('carAsignCodigConfiFrm.origen', 'pagina');
		envia('carAsignCodigConfiFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = carAsignCodigConfiList.codSeleccionados()[0];
		parametros["previousAction"] = get('carAsignCodigConfiFrm.accion');
		parametros["accion"] = get('carAsignCodigConfiFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('CarAsignCodigConfiLPStartUp', get('carAsignCodigConfiFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) carAsignCodigConfiCmdRequery();
	}
}

function carAsignCodigConfiRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carAsignCodigConfiList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = carAsignCodigConfiList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('carAsignCodigConfiFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(carAsignCodigConfiList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += carAsignCodigConfiTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('carAsignCodigConfiFrm.timestamp', timestamps);
	envia('carAsignCodigConfiFrm');
}

function carAsignCodigConfiViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carAsignCodigConfiList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('carAsignCodigConfiFrm.previousAction', get('carAsignCodigConfiFrm.accion'));
	set('carAsignCodigConfiFrm.accion', 'view');
	set('carAsignCodigConfiFrm.origen', 'pagina');
	set('carAsignCodigConfiFrm.ON', 'CarAsignCodigConfiLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('carAsignCodigConfiFrm.idSelection', carAsignCodigConfiList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('carAsignCodigConfiFrm');
	carAsignCodigConfiViewDetail(carAsignCodigConfiList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function carAsignCodigConfiViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('carAsignCodigConfiFrm.accion');
	parametros["accion"] = get('carAsignCodigConfiFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('CarAsignCodigConfiLPStartUp', get('carAsignCodigConfiFrm.accion'), parametros, null, sizeFormView + 30);
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
	var validacion = ValidaForm('carAsignCodigConfiFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
		
	
	if(validacion)envia('carAsignCodigConfiFrm');
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	carAsignCodigConfiRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('carAsignCodigConfiFrm.accion');
	var origenTmp = get('carAsignCodigConfiFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(carAsignCodigConfiBuildUpdateRecordString() != carAsignCodigConfiTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('carAsignCodigConfiFrm.performRequery', 'true');
		set('carAsignCodigConfiFrm.accion', 
			get('carAsignCodigConfiFrm.previousAction'));
		set('carAsignCodigConfiFrm.origen', 'menu');
		set('carAsignCodigConfiFrm.ON', 'CarAsignCodigConfiLPStartUp');
		set('carAsignCodigConfiFrm.conectorAction', 'CarAsignCodigConfiLPStartUp');
		carAsignCodigConfiFrm.oculto='N';
		envia('carAsignCodigConfiFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.carAsignCodigConfiListLayer.style.display='none';
	document.all.carAsignCodigConfiListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.carAsignCodigConfiListLayer.style.display='';
	document.all.carAsignCodigConfiListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda

	jsCarAsignCodigConfiZsgvOidSubgVent = get('carAsignCodigConfiFrm.zsgvOidSubgVent')[0];





	jsCarAsignCodigConfiZorgOidRegi = get('carAsignCodigConfiFrm.zorgOidRegi')[0];





	jsCarAsignCodigConfiZzonOidZona = get('carAsignCodigConfiFrm.zzonOidZona')[0];





	jsCarAsignCodigConfiGrsoOidGrupSoli = get('carAsignCodigConfiFrm.grsoOidGrupSoli')[0];





	jsCarAsignCodigConfiNiriOidNiveRies = get('carAsignCodigConfiFrm.niriOidNiveRies')[0];





	jsCarAsignCodigConfiNiriOidNiveRiesInici = get('carAsignCodigConfiFrm.niriOidNiveRiesInici')[0];





	jsCarAsignCodigConfiPacaOidParaCart = get('carAsignCodigConfiFrm.pacaOidParaCart')[0];




	jsCarAsignCodigConfiValLineCredInic = get('carAsignCodigConfiFrm.valLineCredInic').toString();








	var parametros = "";
	parametros += jsCarAsignCodigConfiZsgvOidSubgVent + "|";



	parametros += jsCarAsignCodigConfiZorgOidRegi + "|";



	parametros += jsCarAsignCodigConfiZzonOidZona + "|";



	parametros += jsCarAsignCodigConfiGrsoOidGrupSoli + "|";



	parametros += jsCarAsignCodigConfiNiriOidNiveRies + "|";



	parametros += jsCarAsignCodigConfiNiriOidNiveRiesInici + "|";



	parametros += jsCarAsignCodigConfiPacaOidParaCart + "|";



	parametros += jsCarAsignCodigConfiValLineCredInic + "|";




	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function carAsignCodigConfiBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCarAsignCodigConfiZsgvOidSubgVent + "|";
	parametros += jsCarAsignCodigConfiZorgOidRegi + "|";
	parametros += jsCarAsignCodigConfiZzonOidZona + "|";
	parametros += jsCarAsignCodigConfiGrsoOidGrupSoli + "|";
	parametros += jsCarAsignCodigConfiNiriOidNiveRies + "|";
	parametros += jsCarAsignCodigConfiNiriOidNiveRiesInici + "|";
	parametros += jsCarAsignCodigConfiPacaOidParaCart + "|";
	parametros += jsCarAsignCodigConfiValLineCredInic + "|";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carAsignCodigConfiFrm.accion'), 
		get('carAsignCodigConfiFrm.origen'));
	
	jsCarAsignCodigConfiId = get('carAsignCodigConfiFrm.id').toString();
	jsCarAsignCodigConfiZsgvOidSubgVent = get('carAsignCodigConfiFrm.zsgvOidSubgVent')[0];
	jsCarAsignCodigConfiZorgOidRegi = get('carAsignCodigConfiFrm.zorgOidRegi')[0];
	jsCarAsignCodigConfiZzonOidZona = get('carAsignCodigConfiFrm.zzonOidZona')[0];
	jsCarAsignCodigConfiGrsoOidGrupSoli = get('carAsignCodigConfiFrm.grsoOidGrupSoli')[0];
	jsCarAsignCodigConfiNiriOidNiveRies = get('carAsignCodigConfiFrm.niriOidNiveRies')[0];
	jsCarAsignCodigConfiNiriOidNiveRiesInici = get('carAsignCodigConfiFrm.niriOidNiveRiesInici')[0];
	jsCarAsignCodigConfiPacaOidParaCart = get('carAsignCodigConfiFrm.pacaOidParaCart')[0];
	jsCarAsignCodigConfiValLineCredInic = get('carAsignCodigConfiFrm.valLineCredInic').toString();

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carAsignCodigConfiFrm.accion'), 
		get('carAsignCodigConfiFrm.origen'));


	set('carAsignCodigConfiFrm.id', jsCarAsignCodigConfiId);
	set('carAsignCodigConfiFrm.zsgvOidSubgVent', [jsCarAsignCodigConfiZsgvOidSubgVent]);
	set('carAsignCodigConfiFrm.zorgOidRegi', [jsCarAsignCodigConfiZorgOidRegi]);
	set('carAsignCodigConfiFrm.zzonOidZona', [jsCarAsignCodigConfiZzonOidZona]);
	set('carAsignCodigConfiFrm.grsoOidGrupSoli', [jsCarAsignCodigConfiGrsoOidGrupSoli]);
	set('carAsignCodigConfiFrm.niriOidNiveRies', [jsCarAsignCodigConfiNiriOidNiveRies]);
	set('carAsignCodigConfiFrm.niriOidNiveRiesInici', [jsCarAsignCodigConfiNiriOidNiveRiesInici]);
	set('carAsignCodigConfiFrm.pacaOidParaCart', [jsCarAsignCodigConfiPacaOidParaCart]);
	set('carAsignCodigConfiFrm.valLineCredInic', jsCarAsignCodigConfiValLineCredInic);

}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('carAsignCodigConfiFrm.errCodigo', errorCode);
	set('carAsignCodigConfiFrm.errDescripcion', description);
	set('carAsignCodigConfiFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	

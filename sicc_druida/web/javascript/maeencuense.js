

/*
    INDRA/CAR/mmg
    $Id: maeencuense.js,v 1.1 2009/12/03 19:02:00 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeEncueNseId = "";
var jsMaeEncueNsePaisOidPais = "";
var jsMaeEncueNseCodTipoEncu = "";
var jsMaeEncueNseDescripcion = "";
var jsMaeEncueNseMarcOidMarc = "";

//Variables de paginacion, 
var maeEncueNsePageCount = 1;

//Varible de columna que representa el campo de choice
var maeEncueNseChoiceColumn = 1;

//Flag de siguiente pagina;
var maeEncueNseMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeEncueNseTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 147;
var sizeFormView = 129;
var sizeFormUpdate = 129;

//Ultima busqueda realizada
var maeEncueNseLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focaliza("maeEncueNseFrm.codTipoEncu");','focaliza("maeEncueNseFrm.codTipoEncu");','focaliza("maeEncueNseFrm.codTipoEncu");','focaliza("maeEncueNseFrm.codTipoEncu");','focaliza("maeEncueNseFrm.codTipoEncu");','focaliza("maeEncueNseFrm.codTipoEncu");'],[4,'focaliza("maeEncueNseFrm.Descripcion");','focaliza("maeEncueNseFrm.Descripcion");','focaliza("maeEncueNseFrm.Descripcion");','focaliza("maeEncueNseFrm.Descripcion");','focaliza("maeEncueNseFrm.Descripcion");','focaliza("maeEncueNseFrm.Descripcion");'],[7,'focalizaComboDependence("maeEncueNse","marcOidMarc", false);','focalizaComboDependence("maeEncueNse","marcOidMarc", false);','focalizaComboDependence("maeEncueNse","marcOidMarc", false);','focalizaComboDependence("maeEncueNse","marcOidMarc", true);','focalizaComboDependence("maeEncueNse","marcOidMarc", true);','focalizaComboDependence("maeEncueNse","marcOidMarc", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'focaliza("maeEncueNseFrm.Descripcion");','focaliza("maeEncueNseFrm.Descripcion");','focaliza("maeEncueNseFrm.Descripcion");','focaliza("maeEncueNseFrm.Descripcion");','focaliza("maeEncueNseFrm.Descripcion");','focaliza("maeEncueNseFrm.Descripcion");'],[7,'focalizaComboDependence("maeEncueNse","marcOidMarc", false);','focalizaComboDependence("maeEncueNse","marcOidMarc", false);','focalizaComboDependence("maeEncueNse","marcOidMarc", false);','focalizaComboDependence("maeEncueNse","marcOidMarc", true);','focalizaComboDependence("maeEncueNse","marcOidMarc", true);','focalizaComboDependence("maeEncueNse","marcOidMarc", true);']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);
var marcOidMarcDependeceMap = new Vector();
marcOidMarcDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
marcOidMarcDependeceMap.agregar(['marcOidMarc', padresTmp, '', 'SegMarca']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeEncueNseLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeEncueNseTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeEncueNseInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeEncueNseFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeEncueNseFrm.accion')){
		case "query": maeEncueNseQueryInitComponents(); break;
		case "view": maeEncueNseViewInitComponents(); break;
		case "create": maeEncueNseCreateInitComponents(); break;
		case "update": maeEncueNseUpdateInitComponents(); break;
		case "remove": maeEncueNseRemoveInitComponents(); break;
		case "lov": maeEncueNseLovInitComponents(); break;
	}
	//alert('accion :' + get('maeEncueNseFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeEncueNseFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeEncueNse')) maeEncueNseCmdRequery();
}

function maeEncueNseQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('maeEncueNseFrm', true);	
}

function maeEncueNseViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('maeEncueNseFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('maeEncueNseFrm', true);
}

function maeEncueNseCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeEncueNseFrm.codTipoEncu','S', GestionarMensaje('MaeEncueNse.codTipoEncu.requiered.message'));
	
	setMV('maeEncueNseFrm.Descripcion','S', GestionarMensaje('MaeEncueNse.Descripcion.requiered.message'));
	
	setMV('maeEncueNseFrm.marcOidMarc','S', GestionarMensaje('MaeEncueNse.marcOidMarc.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeEncueNseFrm', true);
}

function maeEncueNseUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeEncueNseFrm.origen') == "pagina"){
		loadLocalizationWidget('maeEncueNseFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		maeEncueNseTmpUpdateValues = maeEncueNseBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeEncueNseFrm.codTipoEncu','S', GestionarMensaje('MaeEncueNse.codTipoEncu.requiered.message'));
		setMV('maeEncueNseFrm.Descripcion','S', GestionarMensaje('MaeEncueNse.Descripcion.requiered.message'));
		setMV('maeEncueNseFrm.marcOidMarc','S', GestionarMensaje('MaeEncueNse.marcOidMarc.requiered.message'));
		
			focusFirstFieldModify('maeEncueNseFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('maeEncueNseFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeEncueNseFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeEncueNseRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeEncueNseList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeEncueNseFrm', true);
}

function maeEncueNseLovInitComponents(){
	maeEncueNseLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeEncueNseFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function maeEncueNseSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeEncueNseFrm.' + campo, id);
	set('maeEncueNseFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeEncueNseLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeEncueNseLovReturnParameters.id = '';
	maeEncueNseLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeEncueNseLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeEncueNseList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeEncueNseList.codSeleccionados();
	var descripcion = maeEncueNseList.extraeDato(
		maeEncueNseList.codSeleccionados()[0], maeEncueNseChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeEncueNseLovReturnParameters.id = codigo;
	maeEncueNseLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeEncueNseCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeEncueNseFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeEncueNseFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeEncueNseList", "MaeEncueNseConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeEncueNsePostQueryActions(datos);"]], "", "");	
}

function maeEncueNseCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeEncueNseFrm.lastQueryToSession'));
	var i =0;
	set('maeEncueNseFrm.codTipoEncu', paramsRequery.ij(i++));
	
	set('maeEncueNseFrm.Descripcion', paramsRequery.ij(i++));
	
	set('maeEncueNseFrm.marcOidMarc', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	maeEncueNsePageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeEncueNseCmdQuery(maeEncueNsePageCount);
}

function maeEncueNseFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeEncueNsePageCount = 1;
	maeEncueNseCmdQuery(maeEncueNsePageCount);
}

function maeEncueNsePreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeEncueNseLastQuery){
		maeEncueNseFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeEncueNsePageCount--;
	maeEncueNseCmdQuery(maeEncueNsePageCount);
}

function maeEncueNseNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeEncueNseLastQuery){
		maeEncueNseFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeEncueNsePageCount++;
	maeEncueNseCmdQuery(maeEncueNsePageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeEncueNsePostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeEncueNseListLayer', 'O');
		visibilidad('maeEncueNseListButtonsLayer', 'O');
		if(get('maeEncueNseFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeEncueNseLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeEncueNseViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeEncueNseChoiceColumn) + "</A>",
			i, maeEncueNseChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeEncueNseList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeEncueNseTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeEncueNseMorePagesFlag = true;
		maeEncueNseList.eliminar(mmgPageSize, 1);
	}else{
		maeEncueNseMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeEncueNseFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeEncueNseListLayer', 'V');
	visibilidad('maeEncueNseListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeEncueNseList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeEncueNseList.display();
	
	//Actualizamos el estado de los botones 
	if(maeEncueNseMorePagesFlag){
		set_estado_botonera('maeEncueNsePaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeEncueNsePaginationButtonBar',
			3,"inactivo");
	}
	if(maeEncueNsePageCount > 1){
		set_estado_botonera('maeEncueNsePaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeEncueNsePaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeEncueNsePaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeEncueNsePaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeEncueNseUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeEncueNseList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeEncueNseFrm.idSelection', maeEncueNseList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeEncueNseFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeEncueNseList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeEncueNseFrm.accion');
		parametros["accion"] = get('maeEncueNseFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeEncueNseLPStartUp', get('maeEncueNseFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeEncueNseCmdRequery();
	}
}

function maeEncueNseRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeEncueNseList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeEncueNseList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeEncueNseFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeEncueNseList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeEncueNseTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeEncueNseFrm.timestamp', timestamps);


	maeEncueNseFrm.oculto='S';
	envia('maeEncueNseFrm');
	maeEncueNseFrm.oculto='N';
}

function maeEncueNseViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeEncueNseList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeEncueNseViewDetail(maeEncueNseList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeEncueNseViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeEncueNseFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeEncueNseLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('maeEncueNseFrm', 
		'Descripcion', 1,
		get('maeEncueNseFrm.Descripcion'));	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeEncueNseFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('maeEncueNseFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeEncueNse.Descripcion.requiered.message'));
		focaliza('maeEncueNseFrm.Descripcion');
		return;
	}	
	
	
		
	
	if(validacion){
		maeEncueNseFrm.oculto='S';
		envia('maeEncueNseFrm');
		maeEncueNseFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeEncueNseFrm.paisOidPais').toString() == ''){
		set('maeEncueNseFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'maeEncueNse');
		
	}
	if(get('maeEncueNseFrm.marcOidMarc').toString() == ''){
		set('maeEncueNseFrm.marcOidMarc', []);
		mmgResetCombosOnCascade('marcOidMarc', 'marcOidMarc', 'maeEncueNse');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeEncueNseRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeEncueNseFrm.accion');
	var origenTmp = get('maeEncueNseFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeEncueNseBuildUpdateRecordString() != maeEncueNseTmpUpdateValues){
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
	document.all.maeEncueNseListLayer.style.display='none';
	document.all.maeEncueNseListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeEncueNseListLayer.style.display='';
	document.all.maeEncueNseListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeEncueNseCodTipoEncu = get('maeEncueNseFrm.codTipoEncu').toString();
	jsMaeEncueNseDescripcion = get('maeEncueNseFrm.Descripcion').toString();
	jsMaeEncueNseMarcOidMarc = get('maeEncueNseFrm.marcOidMarc')[0];
	
	
	var parametros = "";
	parametros += jsMaeEncueNseCodTipoEncu + "|";
	parametros += jsMaeEncueNseDescripcion + "|";
	parametros += jsMaeEncueNseMarcOidMarc + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeEncueNseBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeEncueNseCodTipoEncu + "|";
	parametros += jsMaeEncueNseDescripcion + "|";
	parametros += jsMaeEncueNseMarcOidMarc + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeEncueNseFrm.accion'), 
		get('maeEncueNseFrm.origen'));
	
	jsMaeEncueNseId = get('maeEncueNseFrm.id').toString();
	jsMaeEncueNsePaisOidPais = get('maeEncueNseFrm.paisOidPais')[0];
	jsMaeEncueNseCodTipoEncu = get('maeEncueNseFrm.codTipoEncu').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeEncueNseDescripcion = buildLocalizedString('maeEncueNseFrm', 1);
	}else{
		jsMaeEncueNseDescripcion = get('maeEncueNseFrm.Descripcion');
	}
	jsMaeEncueNseMarcOidMarc = get('maeEncueNseFrm.marcOidMarc')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeEncueNseFrm.accion'), 
		get('maeEncueNseFrm.origen'));


	set('maeEncueNseFrm.id', jsMaeEncueNseId);
	set('maeEncueNseFrm.paisOidPais', [jsMaeEncueNsePaisOidPais]);
	set('maeEncueNseFrm.codTipoEncu', jsMaeEncueNseCodTipoEncu);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeEncueNseFrm', 1,  jsMaeEncueNseDescripcion)
		loadLocalizationWidget('maeEncueNseFrm', 'Descripcion', 1);
	}else{
		set('maeEncueNseFrm.Descripcion', jsMaeEncueNseDescripcion);		
	}
	set('maeEncueNseFrm.marcOidMarc', [jsMaeEncueNseMarcOidMarc]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeEncueNseCodTipoEncu = '';
	jsMaeEncueNseDescripcion = '';
	jsMaeEncueNseMarcOidMarc = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeEncueNseFrm.errCodigo', errorCode);
	set('maeEncueNseFrm.errDescripcion', description);
	set('maeEncueNseFrm.errSeverity', severity);
	fMostrarMensajeError();
}

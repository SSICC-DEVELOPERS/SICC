

/*
    INDRA/CAR/mmg
    $Id: maeencuenseview.js,v 1.1 2009/12/03 19:02:22 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeEncueNseViewId = "";
var jsMaeEncueNseViewPaisOidPais = "";
var jsMaeEncueNseViewCodTipoEncu = "";
var jsMaeEncueNseViewDescripcion = "";
var jsMaeEncueNseViewMarcOidMarc = "";

//Variables de paginacion, 
var maeEncueNseViewPageCount = 1;

//Varible de columna que representa el campo de choice
var maeEncueNseViewChoiceColumn = 1;

//Flag de siguiente pagina;
var maeEncueNseViewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeEncueNseViewTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var maeEncueNseViewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focaliza("maeEncueNseViewFrm.codTipoEncu");','focaliza("maeEncueNseViewFrm.codTipoEncu");','','focaliza("maeEncueNseViewFrm.codTipoEncu");','focaliza("maeEncueNseViewFrm.codTipoEncu");',''],[4,'focaliza("maeEncueNseViewFrm.Descripcion");','focaliza("maeEncueNseViewFrm.Descripcion");','focaliza("maeEncueNseViewFrm.Descripcion");','focaliza("maeEncueNseViewFrm.Descripcion");','focaliza("maeEncueNseViewFrm.Descripcion");','focaliza("maeEncueNseViewFrm.Descripcion");'],[7,'focalizaComboDependence("maeEncueNseView","marcOidMarc", false);','focalizaComboDependence("maeEncueNseView","marcOidMarc", false);','focalizaComboDependence("maeEncueNseView","marcOidMarc", false);','focalizaComboDependence("maeEncueNseView","marcOidMarc", true);','focalizaComboDependence("maeEncueNseView","marcOidMarc", true);','focalizaComboDependence("maeEncueNseView","marcOidMarc", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'','','','','',''],[3,'focaliza("maeEncueNseViewFrm.codTipoEncu");','focaliza("maeEncueNseViewFrm.codTipoEncu");','','focaliza("maeEncueNseViewFrm.codTipoEncu");','focaliza("maeEncueNseViewFrm.codTipoEncu");',''],[4,'focaliza("maeEncueNseViewFrm.Descripcion");','focaliza("maeEncueNseViewFrm.Descripcion");','focaliza("maeEncueNseViewFrm.Descripcion");','focaliza("maeEncueNseViewFrm.Descripcion");','focaliza("maeEncueNseViewFrm.Descripcion");','focaliza("maeEncueNseViewFrm.Descripcion");'],[7,'focalizaComboDependence("maeEncueNseView","marcOidMarc", false);','focalizaComboDependence("maeEncueNseView","marcOidMarc", false);','focalizaComboDependence("maeEncueNseView","marcOidMarc", false);','focalizaComboDependence("maeEncueNseView","marcOidMarc", true);','focalizaComboDependence("maeEncueNseView","marcOidMarc", true);','focalizaComboDependence("maeEncueNseView","marcOidMarc", true);']]);

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
maeEncueNseViewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeEncueNseViewTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeEncueNseViewInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeEncueNseViewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeEncueNseViewFrm.accion')){
		case "query": maeEncueNseViewQueryInitComponents(); break;
		case "view": maeEncueNseViewViewInitComponents(); break;
		case "create": maeEncueNseViewCreateInitComponents(); break;
		case "update": maeEncueNseViewUpdateInitComponents(); break;
		case "remove": maeEncueNseViewRemoveInitComponents(); break;
		case "lov": maeEncueNseViewLovInitComponents(); break;
	}
	//alert('accion :' + get('maeEncueNseViewFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeEncueNseViewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeEncueNseView')) maeEncueNseViewCmdRequery();
}

function maeEncueNseViewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('maeEncueNseViewFrm', true);	
}

function maeEncueNseViewViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('maeEncueNseViewFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('maeEncueNseViewFrm', true);
}

function maeEncueNseViewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeEncueNseViewFrm.codTipoEncu','S', GestionarMensaje('MaeEncueNseView.codTipoEncu.requiered.message'));
	
	setMV('maeEncueNseViewFrm.Descripcion','S', GestionarMensaje('MaeEncueNseView.Descripcion.requiered.message'));
	
	setMV('maeEncueNseViewFrm.marcOidMarc','S', GestionarMensaje('MaeEncueNseView.marcOidMarc.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeEncueNseViewFrm', true);
}

function maeEncueNseViewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeEncueNseViewFrm.origen') == "pagina"){
		loadLocalizationWidget('maeEncueNseViewFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		maeEncueNseViewTmpUpdateValues = maeEncueNseViewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeEncueNseViewFrm.Descripcion','S', GestionarMensaje('MaeEncueNseView.Descripcion.requiered.message'));
		setMV('maeEncueNseViewFrm.marcOidMarc','S', GestionarMensaje('MaeEncueNseView.marcOidMarc.requiered.message'));
		
			focusFirstFieldModify('maeEncueNseViewFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('maeEncueNseViewFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeEncueNseViewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeEncueNseViewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeEncueNseViewList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeEncueNseViewFrm', true);
}

function maeEncueNseViewLovInitComponents(){
	maeEncueNseViewLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeEncueNseViewFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function maeEncueNseViewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeEncueNseViewFrm.' + campo, id);
	set('maeEncueNseViewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeEncueNseViewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeEncueNseViewLovReturnParameters.id = '';
	maeEncueNseViewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeEncueNseViewLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeEncueNseViewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeEncueNseViewList.codSeleccionados();
	var descripcion = maeEncueNseViewList.extraeDato(
		maeEncueNseViewList.codSeleccionados()[0], maeEncueNseViewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeEncueNseViewLovReturnParameters.id = codigo;
	maeEncueNseViewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeEncueNseViewCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeEncueNseViewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeEncueNseViewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeEncueNseViewList", "MaeEncueNseViewConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeEncueNseViewPostQueryActions(datos);"]], "", "");	
}

function maeEncueNseViewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeEncueNseViewFrm.lastQueryToSession'));
	var i =0;
	set('maeEncueNseViewFrm.codTipoEncu', paramsRequery.ij(i++));
	
	set('maeEncueNseViewFrm.Descripcion', paramsRequery.ij(i++));
	
	set('maeEncueNseViewFrm.marcOidMarc', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	maeEncueNseViewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeEncueNseViewCmdQuery(maeEncueNseViewPageCount);
}

function maeEncueNseViewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeEncueNseViewPageCount = 1;
	maeEncueNseViewCmdQuery(maeEncueNseViewPageCount);
}

function maeEncueNseViewPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeEncueNseViewLastQuery){
		maeEncueNseViewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeEncueNseViewPageCount--;
	maeEncueNseViewCmdQuery(maeEncueNseViewPageCount);
}

function maeEncueNseViewNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeEncueNseViewLastQuery){
		maeEncueNseViewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeEncueNseViewPageCount++;
	maeEncueNseViewCmdQuery(maeEncueNseViewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeEncueNseViewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeEncueNseViewListLayer', 'O');
		visibilidad('maeEncueNseViewListButtonsLayer', 'O');
		if(get('maeEncueNseViewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeEncueNseViewLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeEncueNseViewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeEncueNseViewChoiceColumn) + "</A>",
			i, maeEncueNseViewChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeEncueNseViewList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeEncueNseViewTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeEncueNseViewMorePagesFlag = true;
		maeEncueNseViewList.eliminar(mmgPageSize, 1);
	}else{
		maeEncueNseViewMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeEncueNseViewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeEncueNseViewListLayer', 'V');
	visibilidad('maeEncueNseViewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeEncueNseViewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeEncueNseViewList.display();
	
	//Actualizamos el estado de los botones 
	if(maeEncueNseViewMorePagesFlag){
		set_estado_botonera('maeEncueNseViewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeEncueNseViewPaginationButtonBar',
			3,"inactivo");
	}
	if(maeEncueNseViewPageCount > 1){
		set_estado_botonera('maeEncueNseViewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeEncueNseViewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeEncueNseViewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeEncueNseViewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeEncueNseViewUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeEncueNseViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeEncueNseViewFrm.idSelection', maeEncueNseViewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeEncueNseViewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeEncueNseViewList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeEncueNseViewFrm.accion');
		parametros["accion"] = get('maeEncueNseViewFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeEncueNseViewLPStartUp', get('maeEncueNseViewFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeEncueNseViewCmdRequery();
	}
}

function maeEncueNseViewRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeEncueNseViewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeEncueNseViewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeEncueNseViewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeEncueNseViewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeEncueNseViewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeEncueNseViewFrm.timestamp', timestamps);


	maeEncueNseViewFrm.oculto='S';
	envia('maeEncueNseViewFrm');
	maeEncueNseViewFrm.oculto='N';
}

function maeEncueNseViewViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeEncueNseViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeEncueNseViewViewDetail(maeEncueNseViewList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeEncueNseViewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeEncueNseViewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeEncueNseViewLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('maeEncueNseViewFrm', 
		'Descripcion', 1,
		get('maeEncueNseViewFrm.Descripcion'));	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeEncueNseViewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('maeEncueNseViewFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeEncueNseView.Descripcion.requiered.message'));
		focaliza('maeEncueNseViewFrm.Descripcion');
		return;
	}	
	
	
		
	
	if(validacion){
		maeEncueNseViewFrm.oculto='S';
		envia('maeEncueNseViewFrm');
		maeEncueNseViewFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeEncueNseViewFrm.paisOidPais').toString() == ''){
		set('maeEncueNseViewFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'maeEncueNseView');
		
	}
	if(get('maeEncueNseViewFrm.marcOidMarc').toString() == ''){
		set('maeEncueNseViewFrm.marcOidMarc', []);
		mmgResetCombosOnCascade('marcOidMarc', 'marcOidMarc', 'maeEncueNseView');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeEncueNseViewRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeEncueNseViewFrm.accion');
	var origenTmp = get('maeEncueNseViewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeEncueNseViewBuildUpdateRecordString() != maeEncueNseViewTmpUpdateValues){
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
	document.all.maeEncueNseViewListLayer.style.display='none';
	document.all.maeEncueNseViewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeEncueNseViewListLayer.style.display='';
	document.all.maeEncueNseViewListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeEncueNseViewCodTipoEncu = get('maeEncueNseViewFrm.codTipoEncu').toString();
	jsMaeEncueNseViewDescripcion = get('maeEncueNseViewFrm.Descripcion').toString();
	jsMaeEncueNseViewMarcOidMarc = get('maeEncueNseViewFrm.marcOidMarc')[0];
	
	
	var parametros = "";
	parametros += jsMaeEncueNseViewCodTipoEncu + "|";
	parametros += jsMaeEncueNseViewDescripcion + "|";
	parametros += jsMaeEncueNseViewMarcOidMarc + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeEncueNseViewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeEncueNseViewDescripcion + "|";
	parametros += jsMaeEncueNseViewMarcOidMarc + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeEncueNseViewFrm.accion'), 
		get('maeEncueNseViewFrm.origen'));
	
	jsMaeEncueNseViewId = get('maeEncueNseViewFrm.id').toString();
	jsMaeEncueNseViewPaisOidPais = get('maeEncueNseViewFrm.paisOidPais')[0];
	jsMaeEncueNseViewCodTipoEncu = get('maeEncueNseViewFrm.codTipoEncu').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeEncueNseViewDescripcion = buildLocalizedString('maeEncueNseViewFrm', 1);
	}else{
		jsMaeEncueNseViewDescripcion = get('maeEncueNseViewFrm.Descripcion');
	}
	jsMaeEncueNseViewMarcOidMarc = get('maeEncueNseViewFrm.marcOidMarc')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeEncueNseViewFrm.accion'), 
		get('maeEncueNseViewFrm.origen'));


	set('maeEncueNseViewFrm.id', jsMaeEncueNseViewId);
	set('maeEncueNseViewFrm.paisOidPais', [jsMaeEncueNseViewPaisOidPais]);
	set('maeEncueNseViewFrm.codTipoEncu', jsMaeEncueNseViewCodTipoEncu);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeEncueNseViewFrm', 1,  jsMaeEncueNseViewDescripcion)
		loadLocalizationWidget('maeEncueNseViewFrm', 'Descripcion', 1);
	}else{
		set('maeEncueNseViewFrm.Descripcion', jsMaeEncueNseViewDescripcion);		
	}
	set('maeEncueNseViewFrm.marcOidMarc', [jsMaeEncueNseViewMarcOidMarc]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeEncueNseViewCodTipoEncu = '';
	jsMaeEncueNseViewDescripcion = '';
	jsMaeEncueNseViewMarcOidMarc = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeEncueNseViewFrm.errCodigo', errorCode);
	set('maeEncueNseViewFrm.errDescripcion', description);
	set('maeEncueNseViewFrm.errSeverity', severity);
	fMostrarMensajeError();
}



/*
    INDRA/CAR/mmg
    $Id: maesubticlienview.js,v 1.1 2009/12/03 19:02:21 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeSubtiClienViewId = "";
var jsMaeSubtiClienViewTiclOidTipoClie = "";
var jsMaeSubtiClienViewCodSubtClie = "";
var jsMaeSubtiClienViewDescripcion = "";

//Variables de paginacion, 
var maeSubtiClienViewPageCount = 1;

//Varible de columna que representa el campo de choice
var maeSubtiClienViewChoiceColumn = 2;

//Flag de siguiente pagina;
var maeSubtiClienViewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeSubtiClienViewTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var maeSubtiClienViewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("maeSubtiClienView","ticlOidTipoClie", false);','focalizaComboDependence("maeSubtiClienView","ticlOidTipoClie", false);','focalizaComboDependence("maeSubtiClienView","ticlOidTipoClie", false);','focalizaComboDependence("maeSubtiClienView","ticlOidTipoClie", true);','focalizaComboDependence("maeSubtiClienView","ticlOidTipoClie", true);','focalizaComboDependence("maeSubtiClienView","ticlOidTipoClie", true);'],[3,'focaliza("maeSubtiClienViewFrm.codSubtClie");','focaliza("maeSubtiClienViewFrm.codSubtClie");','focaliza("maeSubtiClienViewFrm.codSubtClie");','focaliza("maeSubtiClienViewFrm.codSubtClie");','focaliza("maeSubtiClienViewFrm.codSubtClie");','focaliza("maeSubtiClienViewFrm.codSubtClie");'],[4,'focaliza("maeSubtiClienViewFrm.Descripcion");','focaliza("maeSubtiClienViewFrm.Descripcion");','focaliza("maeSubtiClienViewFrm.Descripcion");','focaliza("maeSubtiClienViewFrm.Descripcion");','focaliza("maeSubtiClienViewFrm.Descripcion");','focaliza("maeSubtiClienViewFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'focaliza("maeSubtiClienViewFrm.Descripcion");','focaliza("maeSubtiClienViewFrm.Descripcion");','focaliza("maeSubtiClienViewFrm.Descripcion");','focaliza("maeSubtiClienViewFrm.Descripcion");','focaliza("maeSubtiClienViewFrm.Descripcion");','focaliza("maeSubtiClienViewFrm.Descripcion");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var ticlOidTipoClieDependeceMap = new Vector();
ticlOidTipoClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ticlOidTipoClieDependeceMap.agregar(['ticlOidTipoClie', padresTmp, '', 'MaeTipoClien']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeSubtiClienViewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeSubtiClienViewTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeSubtiClienViewInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeSubtiClienViewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeSubtiClienViewFrm.accion')){
		case "query": maeSubtiClienViewQueryInitComponents(); break;
		case "view": maeSubtiClienViewViewInitComponents(); break;
		case "create": maeSubtiClienViewCreateInitComponents(); break;
		case "update": maeSubtiClienViewUpdateInitComponents(); break;
		case "remove": maeSubtiClienViewRemoveInitComponents(); break;
		case "lov": maeSubtiClienViewLovInitComponents(); break;
	}
	//alert('accion :' + get('maeSubtiClienViewFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeSubtiClienViewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeSubtiClienView')) maeSubtiClienViewCmdRequery();
}

function maeSubtiClienViewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('maeSubtiClienViewFrm', true);	
}

function maeSubtiClienViewViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('maeSubtiClienViewFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('maeSubtiClienViewFrm', true);
}

function maeSubtiClienViewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeSubtiClienViewFrm.ticlOidTipoClie','S', GestionarMensaje('MaeSubtiClienView.ticlOidTipoClie.requiered.message'));
	
	setMV('maeSubtiClienViewFrm.codSubtClie','S', GestionarMensaje('MaeSubtiClienView.codSubtClie.requiered.message'));
	
	setMV('maeSubtiClienViewFrm.Descripcion','S', GestionarMensaje('MaeSubtiClienView.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeSubtiClienViewFrm', true);
}

function maeSubtiClienViewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeSubtiClienViewFrm.origen') == "pagina"){
		loadLocalizationWidget('maeSubtiClienViewFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		maeSubtiClienViewTmpUpdateValues = maeSubtiClienViewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeSubtiClienViewFrm.ticlOidTipoClie','S', GestionarMensaje('MaeSubtiClienView.ticlOidTipoClie.requiered.message'));
		setMV('maeSubtiClienViewFrm.codSubtClie','S', GestionarMensaje('MaeSubtiClienView.codSubtClie.requiered.message'));
		setMV('maeSubtiClienViewFrm.Descripcion','S', GestionarMensaje('MaeSubtiClienView.Descripcion.requiered.message'));
		
			focusFirstFieldModify('maeSubtiClienViewFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('maeSubtiClienViewFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeSubtiClienViewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeSubtiClienViewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeSubtiClienViewList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeSubtiClienViewFrm', true);
}

function maeSubtiClienViewLovInitComponents(){
	maeSubtiClienViewLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeSubtiClienViewFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function maeSubtiClienViewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeSubtiClienViewFrm.' + campo, id);
	set('maeSubtiClienViewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeSubtiClienViewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeSubtiClienViewLovReturnParameters.id = '';
	maeSubtiClienViewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeSubtiClienViewLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeSubtiClienViewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeSubtiClienViewList.codSeleccionados();
	var descripcion = maeSubtiClienViewList.extraeDato(
		maeSubtiClienViewList.codSeleccionados()[0], maeSubtiClienViewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeSubtiClienViewLovReturnParameters.id = codigo;
	maeSubtiClienViewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeSubtiClienViewCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeSubtiClienViewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeSubtiClienViewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeSubtiClienViewList", "MaeSubtiClienViewConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeSubtiClienViewPostQueryActions(datos);"]], "", "");	
}

function maeSubtiClienViewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeSubtiClienViewFrm.lastQueryToSession'));
	var i =0;
	set('maeSubtiClienViewFrm.ticlOidTipoClie', [paramsRequery.ij(i++)]);
	
	set('maeSubtiClienViewFrm.codSubtClie', paramsRequery.ij(i++));
	
	set('maeSubtiClienViewFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeSubtiClienViewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeSubtiClienViewCmdQuery(maeSubtiClienViewPageCount);
}

function maeSubtiClienViewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeSubtiClienViewPageCount = 1;
	maeSubtiClienViewCmdQuery(maeSubtiClienViewPageCount);
}

function maeSubtiClienViewPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeSubtiClienViewLastQuery){
		maeSubtiClienViewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeSubtiClienViewPageCount--;
	maeSubtiClienViewCmdQuery(maeSubtiClienViewPageCount);
}

function maeSubtiClienViewNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeSubtiClienViewLastQuery){
		maeSubtiClienViewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeSubtiClienViewPageCount++;
	maeSubtiClienViewCmdQuery(maeSubtiClienViewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeSubtiClienViewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeSubtiClienViewListLayer', 'O');
		visibilidad('maeSubtiClienViewListButtonsLayer', 'O');
		if(get('maeSubtiClienViewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeSubtiClienViewLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeSubtiClienViewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeSubtiClienViewChoiceColumn) + "</A>",
			i, maeSubtiClienViewChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeSubtiClienViewList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeSubtiClienViewTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeSubtiClienViewMorePagesFlag = true;
		maeSubtiClienViewList.eliminar(mmgPageSize, 1);
	}else{
		maeSubtiClienViewMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeSubtiClienViewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeSubtiClienViewListLayer', 'V');
	visibilidad('maeSubtiClienViewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeSubtiClienViewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeSubtiClienViewList.display();
	
	//Actualizamos el estado de los botones 
	if(maeSubtiClienViewMorePagesFlag){
		set_estado_botonera('maeSubtiClienViewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeSubtiClienViewPaginationButtonBar',
			3,"inactivo");
	}
	if(maeSubtiClienViewPageCount > 1){
		set_estado_botonera('maeSubtiClienViewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeSubtiClienViewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeSubtiClienViewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeSubtiClienViewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeSubtiClienViewUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeSubtiClienViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeSubtiClienViewFrm.idSelection', maeSubtiClienViewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeSubtiClienViewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeSubtiClienViewList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeSubtiClienViewFrm.accion');
		parametros["accion"] = get('maeSubtiClienViewFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeSubtiClienViewLPStartUp', get('maeSubtiClienViewFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeSubtiClienViewCmdRequery();
	}
}

function maeSubtiClienViewRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeSubtiClienViewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeSubtiClienViewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeSubtiClienViewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeSubtiClienViewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeSubtiClienViewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeSubtiClienViewFrm.timestamp', timestamps);


	maeSubtiClienViewFrm.oculto='S';
	envia('maeSubtiClienViewFrm');
	maeSubtiClienViewFrm.oculto='N';
}

function maeSubtiClienViewViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeSubtiClienViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeSubtiClienViewViewDetail(maeSubtiClienViewList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeSubtiClienViewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeSubtiClienViewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeSubtiClienViewLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('maeSubtiClienViewFrm', 
		'Descripcion', 1,
		get('maeSubtiClienViewFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeSubtiClienViewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('maeSubtiClienViewFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeSubtiClienView.Descripcion.requiered.message'));
		focaliza('maeSubtiClienViewFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		maeSubtiClienViewFrm.oculto='S';
		envia('maeSubtiClienViewFrm');
		maeSubtiClienViewFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeSubtiClienViewFrm.ticlOidTipoClie').toString() == ''){
		set('maeSubtiClienViewFrm.ticlOidTipoClie', []);
		mmgResetCombosOnCascade('ticlOidTipoClie', 'ticlOidTipoClie', 'maeSubtiClienView');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeSubtiClienViewRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeSubtiClienViewFrm.accion');
	var origenTmp = get('maeSubtiClienViewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeSubtiClienViewBuildUpdateRecordString() != maeSubtiClienViewTmpUpdateValues){
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
	document.all.maeSubtiClienViewListLayer.style.display='none';
	document.all.maeSubtiClienViewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeSubtiClienViewListLayer.style.display='';
	document.all.maeSubtiClienViewListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeSubtiClienViewTiclOidTipoClie = get('maeSubtiClienViewFrm.ticlOidTipoClie')[0];
	jsMaeSubtiClienViewCodSubtClie = get('maeSubtiClienViewFrm.codSubtClie').toString();
	jsMaeSubtiClienViewDescripcion = get('maeSubtiClienViewFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsMaeSubtiClienViewTiclOidTipoClie + "|";
	parametros += jsMaeSubtiClienViewCodSubtClie + "|";
	parametros += jsMaeSubtiClienViewDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeSubtiClienViewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeSubtiClienViewTiclOidTipoClie + "|";
	parametros += jsMaeSubtiClienViewCodSubtClie + "|";
	parametros += jsMaeSubtiClienViewDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeSubtiClienViewFrm.accion'), 
		get('maeSubtiClienViewFrm.origen'));
	
	jsMaeSubtiClienViewId = get('maeSubtiClienViewFrm.id').toString();
	jsMaeSubtiClienViewTiclOidTipoClie = get('maeSubtiClienViewFrm.ticlOidTipoClie')[0];
	jsMaeSubtiClienViewCodSubtClie = get('maeSubtiClienViewFrm.codSubtClie').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeSubtiClienViewDescripcion = buildLocalizedString('maeSubtiClienViewFrm', 1);
	}else{
		jsMaeSubtiClienViewDescripcion = get('maeSubtiClienViewFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeSubtiClienViewFrm.accion'), 
		get('maeSubtiClienViewFrm.origen'));


	set('maeSubtiClienViewFrm.id', jsMaeSubtiClienViewId);
	set('maeSubtiClienViewFrm.ticlOidTipoClie', [jsMaeSubtiClienViewTiclOidTipoClie]);
	set('maeSubtiClienViewFrm.codSubtClie', jsMaeSubtiClienViewCodSubtClie);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeSubtiClienViewFrm', 1,  jsMaeSubtiClienViewDescripcion)
		loadLocalizationWidget('maeSubtiClienViewFrm', 'Descripcion', 1);
	}else{
		set('maeSubtiClienViewFrm.Descripcion', jsMaeSubtiClienViewDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeSubtiClienViewTiclOidTipoClie = '';
	jsMaeSubtiClienViewCodSubtClie = '';
	jsMaeSubtiClienViewDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeSubtiClienViewFrm.errCodigo', errorCode);
	set('maeSubtiClienViewFrm.errDescripcion', description);
	set('maeSubtiClienViewFrm.errSeverity', severity);
	fMostrarMensajeError();
}

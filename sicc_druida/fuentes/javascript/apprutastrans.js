

/*
    INDRA/CAR/mmg
    $Id: apprutastrans.js,v 1.1 2009/12/03 19:02:03 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsAppRutasTransId = "";
var jsAppRutasTransPaisOidPais = "";
var jsAppRutasTransCodRuta = "";
var jsAppRutasTransDescripcion = "";
var jsAppRutasTransNumSecu = "";
var jsAppRutasTransValObse = "";

//Variables de paginacion, 
var appRutasTransPageCount = 1;

//Varible de columna que representa el campo de choice
var appRutasTransChoiceColumn = 1;

//Flag de siguiente pagina;
var appRutasTransMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var appRutasTransTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 149;
var sizeFormUpdate = 149;

//Ultima busqueda realizada
var appRutasTransLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focaliza("appRutasTransFrm.codRuta");','focaliza("appRutasTransFrm.codRuta");','focaliza("appRutasTransFrm.codRuta");','focaliza("appRutasTransFrm.codRuta");','focaliza("appRutasTransFrm.codRuta");','focaliza("appRutasTransFrm.codRuta");'],[4,'focaliza("appRutasTransFrm.Descripcion");','focaliza("appRutasTransFrm.Descripcion");','focaliza("appRutasTransFrm.Descripcion");','focaliza("appRutasTransFrm.Descripcion");','focaliza("appRutasTransFrm.Descripcion");','focaliza("appRutasTransFrm.Descripcion");'],[5,'focaliza("appRutasTransFrm.numSecu");','focaliza("appRutasTransFrm.numSecu");','focaliza("appRutasTransFrm.numSecu");','focaliza("appRutasTransFrm.numSecu");','focaliza("appRutasTransFrm.numSecu");','focaliza("appRutasTransFrm.numSecu");'],[6,'','focaliza("appRutasTransFrm.valObse");','focaliza("appRutasTransFrm.valObse");','','focaliza("appRutasTransFrm.valObse");','focaliza("appRutasTransFrm.valObse");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'','','','','',''],[4,'focaliza("appRutasTransFrm.Descripcion");','focaliza("appRutasTransFrm.Descripcion");','focaliza("appRutasTransFrm.Descripcion");','focaliza("appRutasTransFrm.Descripcion");','focaliza("appRutasTransFrm.Descripcion");','focaliza("appRutasTransFrm.Descripcion");'],[5,'focaliza("appRutasTransFrm.numSecu");','focaliza("appRutasTransFrm.numSecu");','focaliza("appRutasTransFrm.numSecu");','focaliza("appRutasTransFrm.numSecu");','focaliza("appRutasTransFrm.numSecu");','focaliza("appRutasTransFrm.numSecu");'],[6,'','focaliza("appRutasTransFrm.valObse");','focaliza("appRutasTransFrm.valObse");','','focaliza("appRutasTransFrm.valObse");','focaliza("appRutasTransFrm.valObse");']]);

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

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
appRutasTransLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var appRutasTransTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function appRutasTransInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('appRutasTransFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('appRutasTransFrm.accion')){
		case "query": appRutasTransQueryInitComponents(); break;
		case "view": appRutasTransViewInitComponents(); break;
		case "create": appRutasTransCreateInitComponents(); break;
		case "update": appRutasTransUpdateInitComponents(); break;
		case "remove": appRutasTransRemoveInitComponents(); break;
		case "lov": appRutasTransLovInitComponents(); break;
	}
	//alert('accion :' + get('appRutasTransFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('appRutasTransFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('appRutasTrans')) appRutasTransCmdRequery();
}

function appRutasTransQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('appRutasTransFrm', true);	
}

function appRutasTransViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('appRutasTransFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('appRutasTransFrm', true);
}

function appRutasTransCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('appRutasTransFrm.codRuta','S', GestionarMensaje('AppRutasTrans.codRuta.requiered.message'));
	
	setMV('appRutasTransFrm.Descripcion','S', GestionarMensaje('AppRutasTrans.Descripcion.requiered.message'));
	
	setMV('appRutasTransFrm.numSecu','S', GestionarMensaje('AppRutasTrans.numSecu.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('appRutasTransFrm', true);
}

function appRutasTransUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('appRutasTransFrm.origen') == "pagina"){
		loadLocalizationWidget('appRutasTransFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		appRutasTransTmpUpdateValues = appRutasTransBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('appRutasTransFrm.codRuta','S', GestionarMensaje('AppRutasTrans.codRuta.requiered.message'));
		setMV('appRutasTransFrm.Descripcion','S', GestionarMensaje('AppRutasTrans.Descripcion.requiered.message'));
		setMV('appRutasTransFrm.numSecu','S', GestionarMensaje('AppRutasTrans.numSecu.requiered.message'));
		
			focusFirstFieldModify('appRutasTransFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('appRutasTransFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('appRutasTransFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function appRutasTransRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	appRutasTransList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('appRutasTransFrm', true);
}

function appRutasTransLovInitComponents(){
	appRutasTransLovReturnParameters = window.dialogArguments;
	
	focusFirstField('appRutasTransFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad








//Función que permite cargar los datos de un elemento de lov seleccionado
function appRutasTransSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('appRutasTransFrm.' + campo, id);
	set('appRutasTransFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function appRutasTransLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	appRutasTransLovReturnParameters.id = '';
	appRutasTransLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function appRutasTransLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(appRutasTransList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = appRutasTransList.codSeleccionados();
	var descripcion = appRutasTransList.extraeDato(
		appRutasTransList.codSeleccionados()[0], appRutasTransChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	appRutasTransLovReturnParameters.id = codigo;
	appRutasTransLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function appRutasTransCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('appRutasTransFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('appRutasTransFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "appRutasTransList", "AppRutasTransConectorTransactionQuery", 
		"result_ROWSET", parametros, "appRutasTransPostQueryActions(datos);"]], "", "");	
}

function appRutasTransCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('appRutasTransFrm.lastQueryToSession'));
	var i =0;
	set('appRutasTransFrm.codRuta', paramsRequery.ij(i++));
	
	set('appRutasTransFrm.Descripcion', paramsRequery.ij(i++));
	
	set('appRutasTransFrm.numSecu', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	appRutasTransPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	appRutasTransCmdQuery(appRutasTransPageCount);
}

function appRutasTransFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	appRutasTransPageCount = 1;
	appRutasTransCmdQuery(appRutasTransPageCount);
}

function appRutasTransPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != appRutasTransLastQuery){
		appRutasTransFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	appRutasTransPageCount--;
	appRutasTransCmdQuery(appRutasTransPageCount);
}

function appRutasTransNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != appRutasTransLastQuery){
		appRutasTransFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	appRutasTransPageCount++;
	appRutasTransCmdQuery(appRutasTransPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function appRutasTransPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('appRutasTransListLayer', 'O');
		visibilidad('appRutasTransListButtonsLayer', 'O');
		if(get('appRutasTransFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	appRutasTransLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:appRutasTransViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, appRutasTransChoiceColumn) + "</A>",
			i, appRutasTransChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	appRutasTransList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	appRutasTransTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		appRutasTransMorePagesFlag = true;
		appRutasTransList.eliminar(mmgPageSize, 1);
	}else{
		appRutasTransMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('appRutasTransFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('appRutasTransListLayer', 'V');
	visibilidad('appRutasTransListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('appRutasTransList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	appRutasTransList.display();
	
	//Actualizamos el estado de los botones 
	if(appRutasTransMorePagesFlag){
		set_estado_botonera('appRutasTransPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('appRutasTransPaginationButtonBar',
			3,"inactivo");
	}
	if(appRutasTransPageCount > 1){
		set_estado_botonera('appRutasTransPaginationButtonBar',
			2,"activo");
		set_estado_botonera('appRutasTransPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('appRutasTransPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('appRutasTransPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function appRutasTransUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(appRutasTransList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('appRutasTransFrm.idSelection', appRutasTransList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('appRutasTransFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = appRutasTransList.codSeleccionados()[0];
		parametros["previousAction"] = get('appRutasTransFrm.accion');
		parametros["accion"] = get('appRutasTransFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('AppRutasTransLPStartUp', get('appRutasTransFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) appRutasTransCmdRequery();
	}
}

function appRutasTransRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(appRutasTransList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = appRutasTransList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('appRutasTransFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(appRutasTransList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += appRutasTransTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('appRutasTransFrm.timestamp', timestamps);


	appRutasTransFrm.oculto='S';
	envia('appRutasTransFrm');
	appRutasTransFrm.oculto='N';
}

function appRutasTransViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(appRutasTransList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	appRutasTransViewDetail(appRutasTransList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function appRutasTransViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('appRutasTransFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('AppRutasTransLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	// splatas - DBLG500000796 - 10/07/2006
	var valObse = get('appRutasTransFrm.valObse');	
	set('appRutasTransFrm.valObse', valObse);
	
	setDefaultLanguageValue('appRutasTransFrm', 
		'Descripcion', 1,
		get('appRutasTransFrm.Descripcion'));	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('appRutasTransFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('appRutasTransFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('AppRutasTrans.Descripcion.requiered.message'));
		focaliza('appRutasTransFrm.Descripcion');
		return;
	}	
	
	
	
		
	
	if(validacion){
		appRutasTransFrm.oculto='S';
		envia('appRutasTransFrm');
		appRutasTransFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('appRutasTransFrm.paisOidPais').toString() == ''){
		set('appRutasTransFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'appRutasTrans');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	appRutasTransRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('appRutasTransFrm.accion');
	var origenTmp = get('appRutasTransFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(appRutasTransBuildUpdateRecordString() != appRutasTransTmpUpdateValues){
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
	document.all.appRutasTransListLayer.style.display='none';
	document.all.appRutasTransListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.appRutasTransListLayer.style.display='';
	document.all.appRutasTransListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsAppRutasTransCodRuta = get('appRutasTransFrm.codRuta').toString();
	jsAppRutasTransDescripcion = get('appRutasTransFrm.Descripcion').toString();
	jsAppRutasTransNumSecu = get('appRutasTransFrm.numSecu').toString();
	
	
	var parametros = "";
	parametros += jsAppRutasTransCodRuta + "|";
	parametros += jsAppRutasTransDescripcion + "|";
	parametros += jsAppRutasTransNumSecu + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function appRutasTransBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsAppRutasTransCodRuta + "|";
	parametros += jsAppRutasTransDescripcion + "|";
	parametros += jsAppRutasTransNumSecu + "|";
	parametros += jsAppRutasTransValObse + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('appRutasTransFrm.accion'), 
		get('appRutasTransFrm.origen'));
	
	jsAppRutasTransId = get('appRutasTransFrm.id').toString();
	jsAppRutasTransPaisOidPais = get('appRutasTransFrm.paisOidPais')[0];
	jsAppRutasTransCodRuta = get('appRutasTransFrm.codRuta').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsAppRutasTransDescripcion = buildLocalizedString('appRutasTransFrm', 1);
	}else{
		jsAppRutasTransDescripcion = get('appRutasTransFrm.Descripcion');
	}
	jsAppRutasTransNumSecu = get('appRutasTransFrm.numSecu').toString();
	jsAppRutasTransValObse = get('appRutasTransFrm.valObse').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('appRutasTransFrm.accion'), 
		get('appRutasTransFrm.origen'));


	set('appRutasTransFrm.id', jsAppRutasTransId);
	set('appRutasTransFrm.paisOidPais', [jsAppRutasTransPaisOidPais]);
	set('appRutasTransFrm.codRuta', jsAppRutasTransCodRuta);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('appRutasTransFrm', 1,  jsAppRutasTransDescripcion)
		loadLocalizationWidget('appRutasTransFrm', 'Descripcion', 1);
	}else{
		set('appRutasTransFrm.Descripcion', jsAppRutasTransDescripcion);		
	}
	set('appRutasTransFrm.numSecu', jsAppRutasTransNumSecu);
	set('appRutasTransFrm.valObse', jsAppRutasTransValObse);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsAppRutasTransCodRuta = '';
	jsAppRutasTransDescripcion = '';
	jsAppRutasTransNumSecu = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('appRutasTransFrm.errCodigo', errorCode);
	set('appRutasTransFrm.errDescripcion', description);
	set('appRutasTransFrm.errSeverity', severity);
	fMostrarMensajeError();
}

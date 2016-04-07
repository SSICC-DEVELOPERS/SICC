

/*
    INDRA/CAR/mmg
    $Id: precatal.js,v 1.1 2009/12/03 19:01:31 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPreCatalId = "";
var jsPreCatalCodCata = "";
var jsPreCatalDesCata = "";
var jsPreCatalPaisOidPais = "";

//Variables de paginacion, 
var preCatalPageCount = 1;

//Varible de columna que representa el campo de choice
var preCatalChoiceColumn = 1;

//Flag de siguiente pagina;
var preCatalMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var preCatalTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var preCatalLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("preCatalFrm.codCata");','focaliza("preCatalFrm.codCata");','','focaliza("preCatalFrm.codCata");','focaliza("preCatalFrm.codCata");',''],[3,'focaliza("preCatalFrm.desCata");','focaliza("preCatalFrm.desCata");','focaliza("preCatalFrm.desCata");','focaliza("preCatalFrm.desCata");','focaliza("preCatalFrm.desCata");','focaliza("preCatalFrm.desCata");'],[4,'','','','','','']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("preCatalFrm.codCata");','focaliza("preCatalFrm.codCata");','','focaliza("preCatalFrm.codCata");','focaliza("preCatalFrm.codCata");',''],[3,'focaliza("preCatalFrm.desCata");','focaliza("preCatalFrm.desCata");','focaliza("preCatalFrm.desCata");','focaliza("preCatalFrm.desCata");','focaliza("preCatalFrm.desCata");','focaliza("preCatalFrm.desCata");'],[4,'','','','','','']]);

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
preCatalLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var preCatalTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function preCatalInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('preCatalFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('preCatalFrm.accion')){
		case "query": preCatalQueryInitComponents(); break;
		case "view": preCatalViewInitComponents(); break;
		case "create": preCatalCreateInitComponents(); break;
		case "update": preCatalUpdateInitComponents(); break;
		case "remove": preCatalRemoveInitComponents(); break;
		case "lov": preCatalLovInitComponents(); break;
	}
	//alert('accion :' + get('preCatalFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('preCatalFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('preCatal')) preCatalCmdRequery();
}

function preCatalQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('preCatalFrm', true);	
}

function preCatalViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('preCatalFrm', 'desCata', 1);
	
		
	
	focusFirstField('preCatalFrm', true);
}

function preCatalCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('preCatalFrm.codCata','S', GestionarMensaje('PreCatal.codCata.requiered.message'));
	
	setMV('preCatalFrm.desCata','S', GestionarMensaje('PreCatal.desCata.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('preCatalFrm', true);
}

function preCatalUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('preCatalFrm.origen') == "pagina"){
		loadLocalizationWidget('preCatalFrm', 'desCata', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		preCatalTmpUpdateValues = preCatalBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('preCatalFrm.desCata','S', GestionarMensaje('PreCatal.desCata.requiered.message'));
		
			focusFirstFieldModify('preCatalFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('preCatalFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('preCatalFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function preCatalRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	preCatalList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('preCatalFrm', true);
}

function preCatalLovInitComponents(){
	preCatalLovReturnParameters = window.dialogArguments;
	
	focusFirstField('preCatalFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function preCatalSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('preCatalFrm.' + campo, id);
	set('preCatalFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function preCatalLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	preCatalLovReturnParameters.id = '';
	preCatalLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function preCatalLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preCatalList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = preCatalList.codSeleccionados();
	var descripcion = preCatalList.extraeDato(
		preCatalList.codSeleccionados()[0], preCatalChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	preCatalLovReturnParameters.id = codigo;
	preCatalLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function preCatalCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('preCatalFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('preCatalFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "preCatalList", "PreCatalConectorTransactionQuery", 
		"result_ROWSET", parametros, "preCatalPostQueryActions(datos);"]], "", "");	
}

function preCatalCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('preCatalFrm.lastQueryToSession'));
	var i =0;
	set('preCatalFrm.codCata', paramsRequery.ij(i++));
	
	set('preCatalFrm.desCata', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	preCatalPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	preCatalCmdQuery(preCatalPageCount);
}

function preCatalFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	preCatalPageCount = 1;
	preCatalCmdQuery(preCatalPageCount);
}

function preCatalPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != preCatalLastQuery){
		preCatalFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	preCatalPageCount--;
	preCatalCmdQuery(preCatalPageCount);
}

function preCatalNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != preCatalLastQuery){
		preCatalFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	preCatalPageCount++;
	preCatalCmdQuery(preCatalPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function preCatalPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('preCatalListLayer', 'O');
		visibilidad('preCatalListButtonsLayer', 'O');
		if(get('preCatalFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	preCatalLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:preCatalViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, preCatalChoiceColumn) + "</A>",
			i, preCatalChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	preCatalList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	preCatalTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		preCatalMorePagesFlag = true;
		preCatalList.eliminar(mmgPageSize, 1);
	}else{
		preCatalMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('preCatalFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('preCatalListLayer', 'V');
	visibilidad('preCatalListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('preCatalList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	preCatalList.display();
	
	//Actualizamos el estado de los botones 
	if(preCatalMorePagesFlag){
		set_estado_botonera('preCatalPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('preCatalPaginationButtonBar',
			3,"inactivo");
	}
	if(preCatalPageCount > 1){
		set_estado_botonera('preCatalPaginationButtonBar',
			2,"activo");
		set_estado_botonera('preCatalPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('preCatalPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('preCatalPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function preCatalUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preCatalList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('preCatalFrm.idSelection', preCatalList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('preCatalFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = preCatalList.codSeleccionados()[0];
		parametros["previousAction"] = get('preCatalFrm.accion');
		parametros["accion"] = get('preCatalFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('PreCatalLPStartUp', get('preCatalFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) preCatalCmdRequery();
	}
}

function preCatalRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preCatalList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = preCatalList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('preCatalFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(preCatalList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += preCatalTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('preCatalFrm.timestamp', timestamps);


	preCatalFrm.oculto='S';
	envia('preCatalFrm');
	preCatalFrm.oculto='N';
}

function preCatalViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preCatalList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	preCatalViewDetail(preCatalList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function preCatalViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('preCatalFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('PreCatalLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	setDefaultLanguageValue('preCatalFrm', 
		'desCata', 1,
		get('preCatalFrm.desCata'));	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('preCatalFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	if(!hasDefaultLanguageValue('preCatalFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('PreCatal.desCata.requiered.message'));
		focaliza('preCatalFrm.desCata');
		return;
	}	
	
	
		
	
	if(validacion){
		preCatalFrm.oculto='S';
		envia('preCatalFrm');
		preCatalFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('preCatalFrm.paisOidPais').toString() == ''){
		set('preCatalFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'preCatal');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	preCatalRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('preCatalFrm.accion');
	var origenTmp = get('preCatalFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(preCatalBuildUpdateRecordString() != preCatalTmpUpdateValues){
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
	document.all.preCatalListLayer.style.display='none';
	document.all.preCatalListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.preCatalListLayer.style.display='';
	document.all.preCatalListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsPreCatalCodCata = get('preCatalFrm.codCata').toString();
	jsPreCatalDesCata = get('preCatalFrm.desCata').toString();
	
	
	var parametros = "";
	parametros += jsPreCatalCodCata + "|";
	parametros += jsPreCatalDesCata + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function preCatalBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPreCatalDesCata + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('preCatalFrm.accion'), 
		get('preCatalFrm.origen'));
	
	jsPreCatalId = get('preCatalFrm.id').toString();
	jsPreCatalCodCata = get('preCatalFrm.codCata').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsPreCatalDesCata = buildLocalizedString('preCatalFrm', 1);
	}else{
		jsPreCatalDesCata = get('preCatalFrm.desCata');
	}
	jsPreCatalPaisOidPais = get('preCatalFrm.paisOidPais')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('preCatalFrm.accion'), 
		get('preCatalFrm.origen'));


	set('preCatalFrm.id', jsPreCatalId);
	set('preCatalFrm.codCata', jsPreCatalCodCata);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('preCatalFrm', 1,  jsPreCatalDesCata)
		loadLocalizationWidget('preCatalFrm', 'desCata', 1);
	}else{
		set('preCatalFrm.desCata', jsPreCatalDesCata);		
	}
	set('preCatalFrm.paisOidPais', [jsPreCatalPaisOidPais]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsPreCatalCodCata = '';
	jsPreCatalDesCata = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('preCatalFrm.errCodigo', errorCode);
	set('preCatalFrm.errDescripcion', description);
	set('preCatalFrm.errSeverity', severity);
	fMostrarMensajeError();
}



/*
    INDRA/CAR/mmg
    $Id: maenegoc.js,v 1.1 2009/12/03 19:02:23 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeNegocId = "";
var jsMaeNegocPaisOidPais = "";
var jsMaeNegocCodNego = "";
var jsMaeNegocDescripcion = "";

//Variables de paginacion, 
var maeNegocPageCount = 1;

//Varible de columna que representa el campo de choice
var maeNegocChoiceColumn = 1;

//Flag de siguiente pagina;
var maeNegocMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeNegocTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var maeNegocLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focaliza("maeNegocFrm.codNego");','focaliza("maeNegocFrm.codNego");','focaliza("maeNegocFrm.codNego");','focaliza("maeNegocFrm.codNego");','focaliza("maeNegocFrm.codNego");','focaliza("maeNegocFrm.codNego");'],[4,'focaliza("maeNegocFrm.Descripcion");','focaliza("maeNegocFrm.Descripcion");','focaliza("maeNegocFrm.Descripcion");','focaliza("maeNegocFrm.Descripcion");','focaliza("maeNegocFrm.Descripcion");','focaliza("maeNegocFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'focaliza("maeNegocFrm.Descripcion");','focaliza("maeNegocFrm.Descripcion");','focaliza("maeNegocFrm.Descripcion");','focaliza("maeNegocFrm.Descripcion");','focaliza("maeNegocFrm.Descripcion");','focaliza("maeNegocFrm.Descripcion");']]);

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
maeNegocLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeNegocTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeNegocInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeNegocFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeNegocFrm.accion')){
		case "query": maeNegocQueryInitComponents(); break;
		case "view": maeNegocViewInitComponents(); break;
		case "create": maeNegocCreateInitComponents(); break;
		case "update": maeNegocUpdateInitComponents(); break;
		case "remove": maeNegocRemoveInitComponents(); break;
		case "lov": maeNegocLovInitComponents(); break;
	}
	//alert('accion :' + get('maeNegocFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeNegocFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeNegoc')) maeNegocCmdRequery();
}

function maeNegocQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('maeNegocFrm', true);	
}

function maeNegocViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('maeNegocFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('maeNegocFrm', true);
}

function maeNegocCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeNegocFrm.codNego','S', GestionarMensaje('MaeNegoc.codNego.requiered.message'));
	
	setMV('maeNegocFrm.Descripcion','S', GestionarMensaje('MaeNegoc.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeNegocFrm', true);
}

function maeNegocUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeNegocFrm.origen') == "pagina"){
		loadLocalizationWidget('maeNegocFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		maeNegocTmpUpdateValues = maeNegocBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeNegocFrm.codNego','S', GestionarMensaje('MaeNegoc.codNego.requiered.message'));
		setMV('maeNegocFrm.Descripcion','S', GestionarMensaje('MaeNegoc.Descripcion.requiered.message'));
		
			focusFirstFieldModify('maeNegocFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('maeNegocFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeNegocFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeNegocRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeNegocList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeNegocFrm', true);
}

function maeNegocLovInitComponents(){
	maeNegocLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeNegocFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function maeNegocSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeNegocFrm.' + campo, id);
	set('maeNegocFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeNegocLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeNegocLovReturnParameters.id = '';
	maeNegocLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeNegocLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeNegocList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeNegocList.codSeleccionados();
	var descripcion = maeNegocList.extraeDato(
		maeNegocList.codSeleccionados()[0], maeNegocChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeNegocLovReturnParameters.id = codigo;
	maeNegocLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeNegocCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeNegocFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeNegocFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeNegocList", "MaeNegocConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeNegocPostQueryActions(datos);"]], "", "");	
}

function maeNegocCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeNegocFrm.lastQueryToSession'));
	var i =0;
	set('maeNegocFrm.codNego', paramsRequery.ij(i++));
	
	set('maeNegocFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeNegocPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeNegocCmdQuery(maeNegocPageCount);
}

function maeNegocFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeNegocPageCount = 1;
	maeNegocCmdQuery(maeNegocPageCount);
}

function maeNegocPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeNegocLastQuery){
		maeNegocFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeNegocPageCount--;
	maeNegocCmdQuery(maeNegocPageCount);
}

function maeNegocNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeNegocLastQuery){
		maeNegocFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeNegocPageCount++;
	maeNegocCmdQuery(maeNegocPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeNegocPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeNegocListLayer', 'O');
		visibilidad('maeNegocListButtonsLayer', 'O');
		if(get('maeNegocFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeNegocLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeNegocViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeNegocChoiceColumn) + "</A>",
			i, maeNegocChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeNegocList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeNegocTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeNegocMorePagesFlag = true;
		maeNegocList.eliminar(mmgPageSize, 1);
	}else{
		maeNegocMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeNegocFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeNegocListLayer', 'V');
	visibilidad('maeNegocListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeNegocList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeNegocList.display();
	
	//Actualizamos el estado de los botones 
	if(maeNegocMorePagesFlag){
		set_estado_botonera('maeNegocPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeNegocPaginationButtonBar',
			3,"inactivo");
	}
	if(maeNegocPageCount > 1){
		set_estado_botonera('maeNegocPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeNegocPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeNegocPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeNegocPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeNegocUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeNegocList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeNegocFrm.idSelection', maeNegocList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeNegocFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeNegocList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeNegocFrm.accion');
		parametros["accion"] = get('maeNegocFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeNegocLPStartUp', get('maeNegocFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeNegocCmdRequery();
	}
}

function maeNegocRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeNegocList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeNegocList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeNegocFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeNegocList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeNegocTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeNegocFrm.timestamp', timestamps);


	maeNegocFrm.oculto='S';
	envia('maeNegocFrm');
	maeNegocFrm.oculto='N';
}

function maeNegocViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeNegocList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeNegocViewDetail(maeNegocList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeNegocViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeNegocFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeNegocLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('maeNegocFrm', 
		'Descripcion', 1,
		get('maeNegocFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeNegocFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('maeNegocFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeNegoc.Descripcion.requiered.message'));
		focaliza('maeNegocFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		maeNegocFrm.oculto='S';
		envia('maeNegocFrm');
		maeNegocFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeNegocFrm.paisOidPais').toString() == ''){
		set('maeNegocFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'maeNegoc');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeNegocRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeNegocFrm.accion');
	var origenTmp = get('maeNegocFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeNegocBuildUpdateRecordString() != maeNegocTmpUpdateValues){
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
	document.all.maeNegocListLayer.style.display='none';
	document.all.maeNegocListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeNegocListLayer.style.display='';
	document.all.maeNegocListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeNegocCodNego = get('maeNegocFrm.codNego').toString();
	jsMaeNegocDescripcion = get('maeNegocFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsMaeNegocCodNego + "|";
	parametros += jsMaeNegocDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeNegocBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeNegocCodNego + "|";
	parametros += jsMaeNegocDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeNegocFrm.accion'), 
		get('maeNegocFrm.origen'));
	
	jsMaeNegocId = get('maeNegocFrm.id').toString();
	jsMaeNegocPaisOidPais = get('maeNegocFrm.paisOidPais')[0];
	jsMaeNegocCodNego = get('maeNegocFrm.codNego').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeNegocDescripcion = buildLocalizedString('maeNegocFrm', 1);
	}else{
		jsMaeNegocDescripcion = get('maeNegocFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeNegocFrm.accion'), 
		get('maeNegocFrm.origen'));


	set('maeNegocFrm.id', jsMaeNegocId);
	set('maeNegocFrm.paisOidPais', [jsMaeNegocPaisOidPais]);
	set('maeNegocFrm.codNego', jsMaeNegocCodNego);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeNegocFrm', 1,  jsMaeNegocDescripcion)
		loadLocalizationWidget('maeNegocFrm', 'Descripcion', 1);
	}else{
		set('maeNegocFrm.Descripcion', jsMaeNegocDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeNegocCodNego = '';
	jsMaeNegocDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeNegocFrm.errCodigo', errorCode);
	set('maeNegocFrm.errDescripcion', description);
	set('maeNegocFrm.errSeverity', severity);
	fMostrarMensajeError();
}

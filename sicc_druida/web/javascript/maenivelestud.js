

/*
    INDRA/CAR/mmg
    $Id: maenivelestud.js,v 1.1 2009/12/03 19:02:10 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeNivelEstudId = "";
var jsMaeNivelEstudPaisOidPais = "";
var jsMaeNivelEstudCodNiveEstu = "";
var jsMaeNivelEstudDescripcion = "";

//Variables de paginacion, 
var maeNivelEstudPageCount = 1;

//Varible de columna que representa el campo de choice
var maeNivelEstudChoiceColumn = 1;

//Flag de siguiente pagina;
var maeNivelEstudMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeNivelEstudTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var maeNivelEstudLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focaliza("maeNivelEstudFrm.codNiveEstu");','focaliza("maeNivelEstudFrm.codNiveEstu");','focaliza("maeNivelEstudFrm.codNiveEstu");','focaliza("maeNivelEstudFrm.codNiveEstu");','focaliza("maeNivelEstudFrm.codNiveEstu");','focaliza("maeNivelEstudFrm.codNiveEstu");'],[4,'focaliza("maeNivelEstudFrm.Descripcion");','focaliza("maeNivelEstudFrm.Descripcion");','focaliza("maeNivelEstudFrm.Descripcion");','focaliza("maeNivelEstudFrm.Descripcion");','focaliza("maeNivelEstudFrm.Descripcion");','focaliza("maeNivelEstudFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'focaliza("maeNivelEstudFrm.Descripcion");','focaliza("maeNivelEstudFrm.Descripcion");','focaliza("maeNivelEstudFrm.Descripcion");','focaliza("maeNivelEstudFrm.Descripcion");','focaliza("maeNivelEstudFrm.Descripcion");','focaliza("maeNivelEstudFrm.Descripcion");']]);

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
maeNivelEstudLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeNivelEstudTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeNivelEstudInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeNivelEstudFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeNivelEstudFrm.accion')){
		case "query": maeNivelEstudQueryInitComponents(); break;
		case "view": maeNivelEstudViewInitComponents(); break;
		case "create": maeNivelEstudCreateInitComponents(); break;
		case "update": maeNivelEstudUpdateInitComponents(); break;
		case "remove": maeNivelEstudRemoveInitComponents(); break;
		case "lov": maeNivelEstudLovInitComponents(); break;
	}
	//alert('accion :' + get('maeNivelEstudFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeNivelEstudFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeNivelEstud')) maeNivelEstudCmdRequery();
}

function maeNivelEstudQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('maeNivelEstudFrm', true);	
}

function maeNivelEstudViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('maeNivelEstudFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('maeNivelEstudFrm', true);
}

function maeNivelEstudCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeNivelEstudFrm.codNiveEstu','S', GestionarMensaje('MaeNivelEstud.codNiveEstu.requiered.message'));
	
	setMV('maeNivelEstudFrm.Descripcion','S', GestionarMensaje('MaeNivelEstud.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeNivelEstudFrm', true);
}

function maeNivelEstudUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeNivelEstudFrm.origen') == "pagina"){
		loadLocalizationWidget('maeNivelEstudFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		maeNivelEstudTmpUpdateValues = maeNivelEstudBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeNivelEstudFrm.codNiveEstu','S', GestionarMensaje('MaeNivelEstud.codNiveEstu.requiered.message'));
		setMV('maeNivelEstudFrm.Descripcion','S', GestionarMensaje('MaeNivelEstud.Descripcion.requiered.message'));
		
			focusFirstFieldModify('maeNivelEstudFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('maeNivelEstudFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeNivelEstudFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeNivelEstudRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeNivelEstudList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeNivelEstudFrm', true);
}

function maeNivelEstudLovInitComponents(){
	maeNivelEstudLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeNivelEstudFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function maeNivelEstudSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeNivelEstudFrm.' + campo, id);
	set('maeNivelEstudFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeNivelEstudLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeNivelEstudLovReturnParameters.id = '';
	maeNivelEstudLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeNivelEstudLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeNivelEstudList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeNivelEstudList.codSeleccionados();
	var descripcion = maeNivelEstudList.extraeDato(
		maeNivelEstudList.codSeleccionados()[0], maeNivelEstudChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeNivelEstudLovReturnParameters.id = codigo;
	maeNivelEstudLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeNivelEstudCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeNivelEstudFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeNivelEstudFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeNivelEstudList", "MaeNivelEstudConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeNivelEstudPostQueryActions(datos);"]], "", "");	
}

function maeNivelEstudCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeNivelEstudFrm.lastQueryToSession'));
	var i =0;
	set('maeNivelEstudFrm.codNiveEstu', paramsRequery.ij(i++));
	
	set('maeNivelEstudFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeNivelEstudPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeNivelEstudCmdQuery(maeNivelEstudPageCount);
}

function maeNivelEstudFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeNivelEstudPageCount = 1;
	maeNivelEstudCmdQuery(maeNivelEstudPageCount);
}

function maeNivelEstudPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeNivelEstudLastQuery){
		maeNivelEstudFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeNivelEstudPageCount--;
	maeNivelEstudCmdQuery(maeNivelEstudPageCount);
}

function maeNivelEstudNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeNivelEstudLastQuery){
		maeNivelEstudFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeNivelEstudPageCount++;
	maeNivelEstudCmdQuery(maeNivelEstudPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeNivelEstudPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeNivelEstudListLayer', 'O');
		visibilidad('maeNivelEstudListButtonsLayer', 'O');
		if(get('maeNivelEstudFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeNivelEstudLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeNivelEstudViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeNivelEstudChoiceColumn) + "</A>",
			i, maeNivelEstudChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeNivelEstudList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeNivelEstudTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeNivelEstudMorePagesFlag = true;
		maeNivelEstudList.eliminar(mmgPageSize, 1);
	}else{
		maeNivelEstudMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeNivelEstudFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeNivelEstudListLayer', 'V');
	visibilidad('maeNivelEstudListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeNivelEstudList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeNivelEstudList.display();
	
	//Actualizamos el estado de los botones 
	if(maeNivelEstudMorePagesFlag){
		set_estado_botonera('maeNivelEstudPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeNivelEstudPaginationButtonBar',
			3,"inactivo");
	}
	if(maeNivelEstudPageCount > 1){
		set_estado_botonera('maeNivelEstudPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeNivelEstudPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeNivelEstudPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeNivelEstudPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeNivelEstudUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeNivelEstudList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeNivelEstudFrm.idSelection', maeNivelEstudList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeNivelEstudFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeNivelEstudList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeNivelEstudFrm.accion');
		parametros["accion"] = get('maeNivelEstudFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeNivelEstudLPStartUp', get('maeNivelEstudFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeNivelEstudCmdRequery();
	}
}

function maeNivelEstudRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeNivelEstudList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeNivelEstudList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeNivelEstudFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeNivelEstudList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeNivelEstudTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeNivelEstudFrm.timestamp', timestamps);


	maeNivelEstudFrm.oculto='S';
	envia('maeNivelEstudFrm');
	maeNivelEstudFrm.oculto='N';
}

function maeNivelEstudViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeNivelEstudList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeNivelEstudViewDetail(maeNivelEstudList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeNivelEstudViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeNivelEstudFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeNivelEstudLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('maeNivelEstudFrm', 
		'Descripcion', 1,
		get('maeNivelEstudFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeNivelEstudFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('maeNivelEstudFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeNivelEstud.Descripcion.requiered.message'));
		focaliza('maeNivelEstudFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		maeNivelEstudFrm.oculto='S';
		envia('maeNivelEstudFrm');
		maeNivelEstudFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeNivelEstudFrm.paisOidPais').toString() == ''){
		set('maeNivelEstudFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'maeNivelEstud');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeNivelEstudRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeNivelEstudFrm.accion');
	var origenTmp = get('maeNivelEstudFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeNivelEstudBuildUpdateRecordString() != maeNivelEstudTmpUpdateValues){
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
	document.all.maeNivelEstudListLayer.style.display='none';
	document.all.maeNivelEstudListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeNivelEstudListLayer.style.display='';
	document.all.maeNivelEstudListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeNivelEstudCodNiveEstu = get('maeNivelEstudFrm.codNiveEstu').toString();
	jsMaeNivelEstudDescripcion = get('maeNivelEstudFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsMaeNivelEstudCodNiveEstu + "|";
	parametros += jsMaeNivelEstudDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeNivelEstudBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeNivelEstudCodNiveEstu + "|";
	parametros += jsMaeNivelEstudDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeNivelEstudFrm.accion'), 
		get('maeNivelEstudFrm.origen'));
	
	jsMaeNivelEstudId = get('maeNivelEstudFrm.id').toString();
	jsMaeNivelEstudPaisOidPais = get('maeNivelEstudFrm.paisOidPais')[0];
	jsMaeNivelEstudCodNiveEstu = get('maeNivelEstudFrm.codNiveEstu').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeNivelEstudDescripcion = buildLocalizedString('maeNivelEstudFrm', 1);
	}else{
		jsMaeNivelEstudDescripcion = get('maeNivelEstudFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeNivelEstudFrm.accion'), 
		get('maeNivelEstudFrm.origen'));


	set('maeNivelEstudFrm.id', jsMaeNivelEstudId);
	set('maeNivelEstudFrm.paisOidPais', [jsMaeNivelEstudPaisOidPais]);
	set('maeNivelEstudFrm.codNiveEstu', jsMaeNivelEstudCodNiveEstu);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeNivelEstudFrm', 1,  jsMaeNivelEstudDescripcion)
		loadLocalizationWidget('maeNivelEstudFrm', 'Descripcion', 1);
	}else{
		set('maeNivelEstudFrm.Descripcion', jsMaeNivelEstudDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeNivelEstudCodNiveEstu = '';
	jsMaeNivelEstudDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeNivelEstudFrm.errCodigo', errorCode);
	set('maeNivelEstudFrm.errDescripcion', description);
	set('maeNivelEstudFrm.errSeverity', severity);
	fMostrarMensajeError();
}



/*
    INDRA/CAR/mmg
    $Id: maesubticlien.js,v 1.1 2009/12/03 19:02:01 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeSubtiClienId = "";
var jsMaeSubtiClienTiclOidTipoClie = "";
var jsMaeSubtiClienCodSubtClie = "";
var jsMaeSubtiClienDescripcion = "";

//Variables de paginacion, 
var maeSubtiClienPageCount = 1;

//Varible de columna que representa el campo de choice
var maeSubtiClienChoiceColumn = 2;

//Flag de siguiente pagina;
var maeSubtiClienMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeSubtiClienTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var maeSubtiClienLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("maeSubtiClien","ticlOidTipoClie", false);','focalizaComboDependence("maeSubtiClien","ticlOidTipoClie", false);','focalizaComboDependence("maeSubtiClien","ticlOidTipoClie", false);','focalizaComboDependence("maeSubtiClien","ticlOidTipoClie", true);','focalizaComboDependence("maeSubtiClien","ticlOidTipoClie", true);','focalizaComboDependence("maeSubtiClien","ticlOidTipoClie", true);'],[3,'focaliza("maeSubtiClienFrm.codSubtClie");','focaliza("maeSubtiClienFrm.codSubtClie");','focaliza("maeSubtiClienFrm.codSubtClie");','focaliza("maeSubtiClienFrm.codSubtClie");','focaliza("maeSubtiClienFrm.codSubtClie");','focaliza("maeSubtiClienFrm.codSubtClie");'],[4,'focaliza("maeSubtiClienFrm.Descripcion");','focaliza("maeSubtiClienFrm.Descripcion");','focaliza("maeSubtiClienFrm.Descripcion");','focaliza("maeSubtiClienFrm.Descripcion");','focaliza("maeSubtiClienFrm.Descripcion");','focaliza("maeSubtiClienFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'focaliza("maeSubtiClienFrm.Descripcion");','focaliza("maeSubtiClienFrm.Descripcion");','focaliza("maeSubtiClienFrm.Descripcion");','focaliza("maeSubtiClienFrm.Descripcion");','focaliza("maeSubtiClienFrm.Descripcion");','focaliza("maeSubtiClienFrm.Descripcion");']]);

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
maeSubtiClienLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeSubtiClienTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeSubtiClienInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeSubtiClienFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeSubtiClienFrm.accion')){
		case "query": maeSubtiClienQueryInitComponents(); break;
		case "view": maeSubtiClienViewInitComponents(); break;
		case "create": maeSubtiClienCreateInitComponents(); break;
		case "update": maeSubtiClienUpdateInitComponents(); break;
		case "remove": maeSubtiClienRemoveInitComponents(); break;
		case "lov": maeSubtiClienLovInitComponents(); break;
	}
	//alert('accion :' + get('maeSubtiClienFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeSubtiClienFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeSubtiClien')) maeSubtiClienCmdRequery();
}

function maeSubtiClienQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('maeSubtiClienFrm', true);	
}

function maeSubtiClienViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('maeSubtiClienFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('maeSubtiClienFrm', true);
}

function maeSubtiClienCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeSubtiClienFrm.ticlOidTipoClie','S', GestionarMensaje('MaeSubtiClien.ticlOidTipoClie.requiered.message'));
	
	setMV('maeSubtiClienFrm.codSubtClie','S', GestionarMensaje('MaeSubtiClien.codSubtClie.requiered.message'));
	
	setMV('maeSubtiClienFrm.Descripcion','S', GestionarMensaje('MaeSubtiClien.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeSubtiClienFrm', true);
}

function maeSubtiClienUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeSubtiClienFrm.origen') == "pagina"){
		loadLocalizationWidget('maeSubtiClienFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		maeSubtiClienTmpUpdateValues = maeSubtiClienBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeSubtiClienFrm.ticlOidTipoClie','S', GestionarMensaje('MaeSubtiClien.ticlOidTipoClie.requiered.message'));
		setMV('maeSubtiClienFrm.codSubtClie','S', GestionarMensaje('MaeSubtiClien.codSubtClie.requiered.message'));
		setMV('maeSubtiClienFrm.Descripcion','S', GestionarMensaje('MaeSubtiClien.Descripcion.requiered.message'));
		
			focusFirstFieldModify('maeSubtiClienFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('maeSubtiClienFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeSubtiClienFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeSubtiClienRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeSubtiClienList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeSubtiClienFrm', true);
}

function maeSubtiClienLovInitComponents(){
	maeSubtiClienLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeSubtiClienFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function maeSubtiClienSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeSubtiClienFrm.' + campo, id);
	set('maeSubtiClienFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeSubtiClienLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeSubtiClienLovReturnParameters.id = '';
	maeSubtiClienLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeSubtiClienLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeSubtiClienList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeSubtiClienList.codSeleccionados();
	var descripcion = maeSubtiClienList.extraeDato(
		maeSubtiClienList.codSeleccionados()[0], maeSubtiClienChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeSubtiClienLovReturnParameters.id = codigo;
	maeSubtiClienLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeSubtiClienCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeSubtiClienFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeSubtiClienFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeSubtiClienList", "MaeSubtiClienConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeSubtiClienPostQueryActions(datos);"]], "", "");	
}

function maeSubtiClienCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeSubtiClienFrm.lastQueryToSession'));
	var i =0;
	set('maeSubtiClienFrm.ticlOidTipoClie', [paramsRequery.ij(i++)]);
	
	set('maeSubtiClienFrm.codSubtClie', paramsRequery.ij(i++));
	
	set('maeSubtiClienFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeSubtiClienPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeSubtiClienCmdQuery(maeSubtiClienPageCount);
}

function maeSubtiClienFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeSubtiClienPageCount = 1;
	maeSubtiClienCmdQuery(maeSubtiClienPageCount);
}

function maeSubtiClienPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeSubtiClienLastQuery){
		maeSubtiClienFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeSubtiClienPageCount--;
	maeSubtiClienCmdQuery(maeSubtiClienPageCount);
}

function maeSubtiClienNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeSubtiClienLastQuery){
		maeSubtiClienFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeSubtiClienPageCount++;
	maeSubtiClienCmdQuery(maeSubtiClienPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeSubtiClienPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeSubtiClienListLayer', 'O');
		visibilidad('maeSubtiClienListButtonsLayer', 'O');
		if(get('maeSubtiClienFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeSubtiClienLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeSubtiClienViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeSubtiClienChoiceColumn) + "</A>",
			i, maeSubtiClienChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeSubtiClienList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeSubtiClienTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeSubtiClienMorePagesFlag = true;
		maeSubtiClienList.eliminar(mmgPageSize, 1);
	}else{
		maeSubtiClienMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeSubtiClienFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeSubtiClienListLayer', 'V');
	visibilidad('maeSubtiClienListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeSubtiClienList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeSubtiClienList.display();
	
	//Actualizamos el estado de los botones 
	if(maeSubtiClienMorePagesFlag){
		set_estado_botonera('maeSubtiClienPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeSubtiClienPaginationButtonBar',
			3,"inactivo");
	}
	if(maeSubtiClienPageCount > 1){
		set_estado_botonera('maeSubtiClienPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeSubtiClienPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeSubtiClienPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeSubtiClienPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeSubtiClienUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeSubtiClienList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeSubtiClienFrm.idSelection', maeSubtiClienList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeSubtiClienFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeSubtiClienList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeSubtiClienFrm.accion');
		parametros["accion"] = get('maeSubtiClienFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeSubtiClienLPStartUp', get('maeSubtiClienFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeSubtiClienCmdRequery();
	}
}

function maeSubtiClienRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeSubtiClienList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeSubtiClienList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeSubtiClienFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeSubtiClienList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeSubtiClienTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeSubtiClienFrm.timestamp', timestamps);


	maeSubtiClienFrm.oculto='S';
	envia('maeSubtiClienFrm');
	maeSubtiClienFrm.oculto='N';
}

function maeSubtiClienViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeSubtiClienList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeSubtiClienViewDetail(maeSubtiClienList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeSubtiClienViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeSubtiClienFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeSubtiClienLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('maeSubtiClienFrm', 
		'Descripcion', 1,
		get('maeSubtiClienFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeSubtiClienFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('maeSubtiClienFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeSubtiClien.Descripcion.requiered.message'));
		focaliza('maeSubtiClienFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		maeSubtiClienFrm.oculto='S';
		envia('maeSubtiClienFrm');
		maeSubtiClienFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeSubtiClienFrm.ticlOidTipoClie').toString() == ''){
		set('maeSubtiClienFrm.ticlOidTipoClie', []);
		mmgResetCombosOnCascade('ticlOidTipoClie', 'ticlOidTipoClie', 'maeSubtiClien');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeSubtiClienRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeSubtiClienFrm.accion');
	var origenTmp = get('maeSubtiClienFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeSubtiClienBuildUpdateRecordString() != maeSubtiClienTmpUpdateValues){
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
	document.all.maeSubtiClienListLayer.style.display='none';
	document.all.maeSubtiClienListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeSubtiClienListLayer.style.display='';
	document.all.maeSubtiClienListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeSubtiClienTiclOidTipoClie = get('maeSubtiClienFrm.ticlOidTipoClie')[0];
	jsMaeSubtiClienCodSubtClie = get('maeSubtiClienFrm.codSubtClie').toString();
	jsMaeSubtiClienDescripcion = get('maeSubtiClienFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsMaeSubtiClienTiclOidTipoClie + "|";
	parametros += jsMaeSubtiClienCodSubtClie + "|";
	parametros += jsMaeSubtiClienDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeSubtiClienBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeSubtiClienTiclOidTipoClie + "|";
	parametros += jsMaeSubtiClienCodSubtClie + "|";
	parametros += jsMaeSubtiClienDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeSubtiClienFrm.accion'), 
		get('maeSubtiClienFrm.origen'));
	
	jsMaeSubtiClienId = get('maeSubtiClienFrm.id').toString();
	jsMaeSubtiClienTiclOidTipoClie = get('maeSubtiClienFrm.ticlOidTipoClie')[0];
	jsMaeSubtiClienCodSubtClie = get('maeSubtiClienFrm.codSubtClie').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeSubtiClienDescripcion = buildLocalizedString('maeSubtiClienFrm', 1);
	}else{
		jsMaeSubtiClienDescripcion = get('maeSubtiClienFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeSubtiClienFrm.accion'), 
		get('maeSubtiClienFrm.origen'));


	set('maeSubtiClienFrm.id', jsMaeSubtiClienId);
	set('maeSubtiClienFrm.ticlOidTipoClie', [jsMaeSubtiClienTiclOidTipoClie]);
	set('maeSubtiClienFrm.codSubtClie', jsMaeSubtiClienCodSubtClie);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeSubtiClienFrm', 1,  jsMaeSubtiClienDescripcion)
		loadLocalizationWidget('maeSubtiClienFrm', 'Descripcion', 1);
	}else{
		set('maeSubtiClienFrm.Descripcion', jsMaeSubtiClienDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeSubtiClienTiclOidTipoClie = '';
	jsMaeSubtiClienCodSubtClie = '';
	jsMaeSubtiClienDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeSubtiClienFrm.errCodigo', errorCode);
	set('maeSubtiClienFrm.errDescripcion', description);
	set('maeSubtiClienFrm.errSeverity', severity);
	fMostrarMensajeError();
}

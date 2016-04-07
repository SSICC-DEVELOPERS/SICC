

/*
    INDRA/CAR/mmg
    $Id: recresulchequ.js,v 1.1 2009/12/03 19:01:39 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsRecResulChequId = "";
var jsRecResulChequPaisOidPais = "";
var jsRecResulChequCodResuCheq = "";
var jsRecResulChequDescripcion = "";
var jsRecResulChequIndResu = "";

//Variables de paginacion, 
var recResulChequPageCount = 1;

//Varible de columna que representa el campo de choice
var recResulChequChoiceColumn = 3;

//Flag de siguiente pagina;
var recResulChequMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var recResulChequTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 147;
var sizeFormView = 129;
var sizeFormUpdate = 129;

//Ultima busqueda realizada
var recResulChequLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focaliza("recResulChequFrm.codResuCheq");','focaliza("recResulChequFrm.codResuCheq");','focaliza("recResulChequFrm.codResuCheq");','focaliza("recResulChequFrm.codResuCheq");','focaliza("recResulChequFrm.codResuCheq");','focaliza("recResulChequFrm.codResuCheq");'],[4,'focaliza("recResulChequFrm.Descripcion");','focaliza("recResulChequFrm.Descripcion");','focaliza("recResulChequFrm.Descripcion");','focaliza("recResulChequFrm.Descripcion");','focaliza("recResulChequFrm.Descripcion");','focaliza("recResulChequFrm.Descripcion");'],[5,'focaliza("recResulChequFrm.indResu");','focaliza("recResulChequFrm.indResu");','focaliza("recResulChequFrm.indResu");','focaliza("recResulChequFrm.indResu");','focaliza("recResulChequFrm.indResu");','focaliza("recResulChequFrm.indResu");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'','','','','',''],[4,'focaliza("recResulChequFrm.Descripcion");','focaliza("recResulChequFrm.Descripcion");','focaliza("recResulChequFrm.Descripcion");','focaliza("recResulChequFrm.Descripcion");','focaliza("recResulChequFrm.Descripcion");','focaliza("recResulChequFrm.Descripcion");'],[5,'focaliza("recResulChequFrm.indResu");','focaliza("recResulChequFrm.indResu");','focaliza("recResulChequFrm.indResu");','focaliza("recResulChequFrm.indResu");','focaliza("recResulChequFrm.indResu");','focaliza("recResulChequFrm.indResu");']]);

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
recResulChequLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var recResulChequTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function recResulChequInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('recResulChequFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('recResulChequFrm.accion')){
		case "query": recResulChequQueryInitComponents(); break;
		case "view": recResulChequViewInitComponents(); break;
		case "create": recResulChequCreateInitComponents(); break;
		case "update": recResulChequUpdateInitComponents(); break;
		case "remove": recResulChequRemoveInitComponents(); break;
		case "lov": recResulChequLovInitComponents(); break;
	}
	//alert('accion :' + get('recResulChequFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('recResulChequFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('recResulChequ')) recResulChequCmdRequery();
}

function recResulChequQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('recResulChequFrm', true);	
}

function recResulChequViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('recResulChequFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('recResulChequFrm', true);
}

function recResulChequCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('recResulChequFrm.codResuCheq','S', GestionarMensaje('RecResulChequ.codResuCheq.requiered.message'));
	
	setMV('recResulChequFrm.Descripcion','S', GestionarMensaje('RecResulChequ.Descripcion.requiered.message'));
	
	setMV('recResulChequFrm.indResu','S', GestionarMensaje('RecResulChequ.indResu.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('recResulChequFrm', true);
}

function recResulChequUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('recResulChequFrm.origen') == "pagina"){
		loadLocalizationWidget('recResulChequFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		recResulChequTmpUpdateValues = recResulChequBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('recResulChequFrm.codResuCheq','S', GestionarMensaje('RecResulChequ.codResuCheq.requiered.message'));
		setMV('recResulChequFrm.Descripcion','S', GestionarMensaje('RecResulChequ.Descripcion.requiered.message'));
		setMV('recResulChequFrm.indResu','S', GestionarMensaje('RecResulChequ.indResu.requiered.message'));
		
			focusFirstFieldModify('recResulChequFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('recResulChequFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('recResulChequFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function recResulChequRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	recResulChequList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('recResulChequFrm', true);
}

function recResulChequLovInitComponents(){
	recResulChequLovReturnParameters = window.dialogArguments;
	
	focusFirstField('recResulChequFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function recResulChequSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('recResulChequFrm.' + campo, id);
	set('recResulChequFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function recResulChequLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	recResulChequLovReturnParameters.id = '';
	recResulChequLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function recResulChequLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(recResulChequList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = recResulChequList.codSeleccionados();
	var descripcion = recResulChequList.extraeDato(
		recResulChequList.codSeleccionados()[0], recResulChequChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	recResulChequLovReturnParameters.id = codigo;
	recResulChequLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function recResulChequCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('recResulChequFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('recResulChequFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "recResulChequList", "RecResulChequConectorTransactionQuery", 
		"result_ROWSET", parametros, "recResulChequPostQueryActions(datos);"]], "", "");	
}

function recResulChequCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('recResulChequFrm.lastQueryToSession'));
	var i =0;
	set('recResulChequFrm.codResuCheq', paramsRequery.ij(i++));
	
	set('recResulChequFrm.Descripcion', paramsRequery.ij(i++));
	
	set('recResulChequFrm.indResu', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	recResulChequPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	recResulChequCmdQuery(recResulChequPageCount);
}

function recResulChequFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	recResulChequPageCount = 1;
	recResulChequCmdQuery(recResulChequPageCount);
}

function recResulChequPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != recResulChequLastQuery){
		recResulChequFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	recResulChequPageCount--;
	recResulChequCmdQuery(recResulChequPageCount);
}

function recResulChequNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != recResulChequLastQuery){
		recResulChequFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	recResulChequPageCount++;
	recResulChequCmdQuery(recResulChequPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function recResulChequPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('recResulChequListLayer', 'O');
		visibilidad('recResulChequListButtonsLayer', 'O');
		if(get('recResulChequFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	recResulChequLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 3)){
			case '1': datosTmp.ij2(GestionarMensaje('RecResulChequ.indResu.1.value'), i, 3); break;
			case '0': datosTmp.ij2(GestionarMensaje('RecResulChequ.indResu.0.value'), i, 3); break;
			default: datosTmp .ij2('', i, 3);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:recResulChequViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, recResulChequChoiceColumn) + "</A>",
			i, recResulChequChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	recResulChequList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	recResulChequTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		recResulChequMorePagesFlag = true;
		recResulChequList.eliminar(mmgPageSize, 1);
	}else{
		recResulChequMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('recResulChequFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('recResulChequListLayer', 'V');
	visibilidad('recResulChequListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('recResulChequList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	recResulChequList.display();
	
	//Actualizamos el estado de los botones 
	if(recResulChequMorePagesFlag){
		set_estado_botonera('recResulChequPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('recResulChequPaginationButtonBar',
			3,"inactivo");
	}
	if(recResulChequPageCount > 1){
		set_estado_botonera('recResulChequPaginationButtonBar',
			2,"activo");
		set_estado_botonera('recResulChequPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('recResulChequPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('recResulChequPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function recResulChequUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(recResulChequList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('recResulChequFrm.idSelection', recResulChequList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('recResulChequFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = recResulChequList.codSeleccionados()[0];
		parametros["previousAction"] = get('recResulChequFrm.accion');
		parametros["accion"] = get('recResulChequFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('RecResulChequLPStartUp', get('recResulChequFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) recResulChequCmdRequery();
	}
}

function recResulChequRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(recResulChequList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = recResulChequList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('recResulChequFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(recResulChequList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += recResulChequTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('recResulChequFrm.timestamp', timestamps);


	recResulChequFrm.oculto='S';
	envia('recResulChequFrm');
	recResulChequFrm.oculto='N';
}

function recResulChequViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(recResulChequList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	recResulChequViewDetail(recResulChequList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function recResulChequViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('recResulChequFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('RecResulChequLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('recResulChequFrm', 
		'Descripcion', 1,
		get('recResulChequFrm.Descripcion'));	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('recResulChequFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('recResulChequFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('RecResulChequ.Descripcion.requiered.message'));
		focaliza('recResulChequFrm.Descripcion');
		return;
	}	
	
	
		
	
	if(validacion){
		recResulChequFrm.oculto='S';
		envia('recResulChequFrm');
		recResulChequFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('recResulChequFrm.paisOidPais').toString() == ''){
		set('recResulChequFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'recResulChequ');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	recResulChequRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('recResulChequFrm.accion');
	var origenTmp = get('recResulChequFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(recResulChequBuildUpdateRecordString() != recResulChequTmpUpdateValues){
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
	document.all.recResulChequListLayer.style.display='none';
	document.all.recResulChequListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.recResulChequListLayer.style.display='';
	document.all.recResulChequListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsRecResulChequCodResuCheq = get('recResulChequFrm.codResuCheq').toString();
	jsRecResulChequDescripcion = get('recResulChequFrm.Descripcion').toString();
	jsRecResulChequIndResu = get('recResulChequFrm.indResu')[0];
	
	
	var parametros = "";
	parametros += jsRecResulChequCodResuCheq + "|";
	parametros += jsRecResulChequDescripcion + "|";
	parametros += jsRecResulChequIndResu + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function recResulChequBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsRecResulChequCodResuCheq + "|";
	parametros += jsRecResulChequDescripcion + "|";
	parametros += jsRecResulChequIndResu + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('recResulChequFrm.accion'), 
		get('recResulChequFrm.origen'));
	
	jsRecResulChequId = get('recResulChequFrm.id').toString();
	jsRecResulChequPaisOidPais = get('recResulChequFrm.paisOidPais')[0];
	jsRecResulChequCodResuCheq = get('recResulChequFrm.codResuCheq').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsRecResulChequDescripcion = buildLocalizedString('recResulChequFrm', 1);
	}else{
		jsRecResulChequDescripcion = get('recResulChequFrm.Descripcion');
	}
	jsRecResulChequIndResu = get('recResulChequFrm.indResu')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('recResulChequFrm.accion'), 
		get('recResulChequFrm.origen'));


	set('recResulChequFrm.id', jsRecResulChequId);
	set('recResulChequFrm.paisOidPais', [jsRecResulChequPaisOidPais]);
	set('recResulChequFrm.codResuCheq', jsRecResulChequCodResuCheq);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('recResulChequFrm', 1,  jsRecResulChequDescripcion)
		loadLocalizationWidget('recResulChequFrm', 'Descripcion', 1);
	}else{
		set('recResulChequFrm.Descripcion', jsRecResulChequDescripcion);		
	}
	set('recResulChequFrm.indResu', [jsRecResulChequIndResu]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsRecResulChequCodResuCheq = '';
	jsRecResulChequDescripcion = '';
	jsRecResulChequIndResu = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('recResulChequFrm.errCodigo', errorCode);
	set('recResulChequFrm.errDescripcion', description);
	set('recResulChequFrm.errSeverity', severity);
	fMostrarMensajeError();
}

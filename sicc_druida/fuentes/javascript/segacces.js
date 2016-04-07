

/*
    INDRA/CAR/mmg
    $Id: segacces.js,v 1.1 2009/12/03 19:02:01 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsSegAccesId = "";
var jsSegAccesCodAcce = "";
var jsSegAccesDescripcion = "";
var jsSegAccesCanaOidCana = "";
var jsSegAccesIndAcce = "";

//Variables de paginacion, 
var segAccesPageCount = 1;

//Varible de columna que representa el campo de choice
var segAccesChoiceColumn = 1;

//Flag de siguiente pagina;
var segAccesMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var segAccesTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 147;
var sizeFormView = 129;
var sizeFormUpdate = 129;

//Ultima busqueda realizada
var segAccesLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("segAccesFrm.codAcce");','focaliza("segAccesFrm.codAcce");','focaliza("segAccesFrm.codAcce");','focaliza("segAccesFrm.codAcce");','focaliza("segAccesFrm.codAcce");','focaliza("segAccesFrm.codAcce");'],[3,'focaliza("segAccesFrm.Descripcion");','focaliza("segAccesFrm.Descripcion");','focaliza("segAccesFrm.Descripcion");','focaliza("segAccesFrm.Descripcion");','focaliza("segAccesFrm.Descripcion");','focaliza("segAccesFrm.Descripcion");'],[4,'focalizaComboDependence("segAcces","canaOidCana", false);','focalizaComboDependence("segAcces","canaOidCana", false);','focalizaComboDependence("segAcces","canaOidCana", false);','focalizaComboDependence("segAcces","canaOidCana", true);','focalizaComboDependence("segAcces","canaOidCana", true);','focalizaComboDependence("segAcces","canaOidCana", true);'],[5,'focaliza("segAccesFrm.indAcce");','focaliza("segAccesFrm.indAcce");','focaliza("segAccesFrm.indAcce");','focaliza("segAccesFrm.indAcce");','focaliza("segAccesFrm.indAcce");','focaliza("segAccesFrm.indAcce");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("segAccesFrm.Descripcion");','focaliza("segAccesFrm.Descripcion");','focaliza("segAccesFrm.Descripcion");','focaliza("segAccesFrm.Descripcion");','focaliza("segAccesFrm.Descripcion");','focaliza("segAccesFrm.Descripcion");'],[5,'focaliza("segAccesFrm.indAcce");','focaliza("segAccesFrm.indAcce");','focaliza("segAccesFrm.indAcce");','focaliza("segAccesFrm.indAcce");','focaliza("segAccesFrm.indAcce");','focaliza("segAccesFrm.indAcce");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var canaOidCanaDependeceMap = new Vector();
canaOidCanaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
canaOidCanaDependeceMap.agregar(['canaOidCana', padresTmp, '', 'SegCanalView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
segAccesLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var segAccesTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function segAccesInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('segAccesFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('segAccesFrm.accion')){
		case "query": segAccesQueryInitComponents(); break;
		case "view": segAccesViewInitComponents(); break;
		case "create": segAccesCreateInitComponents(); break;
		case "update": segAccesUpdateInitComponents(); break;
		case "remove": segAccesRemoveInitComponents(); break;
		case "lov": segAccesLovInitComponents(); break;
	}
	//alert('accion :' + get('segAccesFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('segAccesFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('segAcces')) segAccesCmdRequery();
}

function segAccesQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	focusFirstField('segAccesFrm', true);	
}

function segAccesViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('segAccesFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('segAccesFrm', true);
}

function segAccesCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('segAccesFrm.codAcce','S', GestionarMensaje('SegAcces.codAcce.requiered.message'));
	
	setMV('segAccesFrm.Descripcion','S', GestionarMensaje('SegAcces.Descripcion.requiered.message'));
	
	setMV('segAccesFrm.canaOidCana','S', GestionarMensaje('SegAcces.canaOidCana.requiered.message'));
	
	setMV('segAccesFrm.indAcce','S', GestionarMensaje('SegAcces.indAcce.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('segAccesFrm', true);
}

function segAccesUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('segAccesFrm.origen') == "pagina"){
		loadLocalizationWidget('segAccesFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		segAccesTmpUpdateValues = segAccesBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('segAccesFrm.codAcce','S', GestionarMensaje('SegAcces.codAcce.requiered.message'));
		setMV('segAccesFrm.Descripcion','S', GestionarMensaje('SegAcces.Descripcion.requiered.message'));
		setMV('segAccesFrm.canaOidCana','S', GestionarMensaje('SegAcces.canaOidCana.requiered.message'));
		setMV('segAccesFrm.indAcce','S', GestionarMensaje('SegAcces.indAcce.requiered.message'));
		
			focusFirstFieldModify('segAccesFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		focusFirstField('segAccesFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('segAccesFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function segAccesRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	segAccesList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('segAccesFrm', true);
}

function segAccesLovInitComponents(){
	segAccesLovReturnParameters = window.dialogArguments;
	
	focusFirstField('segAccesFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function segAccesSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('segAccesFrm.' + campo, id);
	set('segAccesFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function segAccesLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	segAccesLovReturnParameters.id = '';
	segAccesLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function segAccesLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segAccesList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = segAccesList.codSeleccionados();
	var descripcion = segAccesList.extraeDato(
		segAccesList.codSeleccionados()[0], segAccesChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	segAccesLovReturnParameters.id = codigo;
	segAccesLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function segAccesCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('segAccesFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('segAccesFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "segAccesList", "SegAccesConectorTransactionQuery", 
		"result_ROWSET", parametros, "segAccesPostQueryActions(datos);"]], "", "");	
}

function segAccesCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('segAccesFrm.lastQueryToSession'));
	var i =0;
	set('segAccesFrm.codAcce', paramsRequery.ij(i++));
	
	set('segAccesFrm.Descripcion', paramsRequery.ij(i++));
	
	set('segAccesFrm.canaOidCana', [paramsRequery.ij(i++)]);
	
	set('segAccesFrm.indAcce', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	segAccesPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	segAccesCmdQuery(segAccesPageCount);
}

function segAccesFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	segAccesPageCount = 1;
	segAccesCmdQuery(segAccesPageCount);
}

function segAccesPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != segAccesLastQuery){
		segAccesFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	segAccesPageCount--;
	segAccesCmdQuery(segAccesPageCount);
}

function segAccesNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != segAccesLastQuery){
		segAccesFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	segAccesPageCount++;
	segAccesCmdQuery(segAccesPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function segAccesPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('segAccesListLayer', 'O');
		visibilidad('segAccesListButtonsLayer', 'O');
		if(get('segAccesFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	segAccesLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 4)){
			case 'C': datosTmp.ij2(GestionarMensaje('SegAcces.indAcce.C.value'), i, 4); break;
			case 'B': datosTmp.ij2(GestionarMensaje('SegAcces.indAcce.B.value'), i, 4); break;
			case 'G': datosTmp.ij2(GestionarMensaje('SegAcces.indAcce.G.value'), i, 4); break;
			case 'O': datosTmp.ij2(GestionarMensaje('SegAcces.indAcce.O.value'), i, 4); break;
			default: datosTmp .ij2('', i, 4);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:segAccesViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, segAccesChoiceColumn) + "</A>",
			i, segAccesChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	segAccesList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	segAccesTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		segAccesMorePagesFlag = true;
		segAccesList.eliminar(mmgPageSize, 1);
	}else{
		segAccesMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('segAccesFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('segAccesListLayer', 'V');
	visibilidad('segAccesListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('segAccesList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	segAccesList.display();
	
	//Actualizamos el estado de los botones 
	if(segAccesMorePagesFlag){
		set_estado_botonera('segAccesPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('segAccesPaginationButtonBar',
			3,"inactivo");
	}
	if(segAccesPageCount > 1){
		set_estado_botonera('segAccesPaginationButtonBar',
			2,"activo");
		set_estado_botonera('segAccesPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('segAccesPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('segAccesPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function segAccesUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segAccesList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('segAccesFrm.idSelection', segAccesList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('segAccesFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = segAccesList.codSeleccionados()[0];
		parametros["previousAction"] = get('segAccesFrm.accion');
		parametros["accion"] = get('segAccesFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('SegAccesLPStartUp', get('segAccesFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) segAccesCmdRequery();
	}
}

function segAccesRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segAccesList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = segAccesList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('segAccesFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(segAccesList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += segAccesTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('segAccesFrm.timestamp', timestamps);


	segAccesFrm.oculto='S';
	envia('segAccesFrm');
	segAccesFrm.oculto='N';
}

function segAccesViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segAccesList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	segAccesViewDetail(segAccesList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function segAccesViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('segAccesFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('SegAccesLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	setDefaultLanguageValue('segAccesFrm', 
		'Descripcion', 1,
		get('segAccesFrm.Descripcion'));	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('segAccesFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	if(!hasDefaultLanguageValue('segAccesFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('SegAcces.Descripcion.requiered.message'));
		focaliza('segAccesFrm.Descripcion');
		return;
	}	
	
	
	
		
	
	if(validacion){
		segAccesFrm.oculto='S';
		envia('segAccesFrm');
		segAccesFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('segAccesFrm.canaOidCana').toString() == ''){
		set('segAccesFrm.canaOidCana', []);
		mmgResetCombosOnCascade('canaOidCana', 'canaOidCana', 'segAcces');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	segAccesRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('segAccesFrm.accion');
	var origenTmp = get('segAccesFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(segAccesBuildUpdateRecordString() != segAccesTmpUpdateValues){
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
	document.all.segAccesListLayer.style.display='none';
	document.all.segAccesListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.segAccesListLayer.style.display='';
	document.all.segAccesListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsSegAccesCodAcce = get('segAccesFrm.codAcce').toString();
	jsSegAccesDescripcion = get('segAccesFrm.Descripcion').toString();
	jsSegAccesCanaOidCana = get('segAccesFrm.canaOidCana')[0];
	jsSegAccesIndAcce = get('segAccesFrm.indAcce')[0];
	
	
	var parametros = "";
	parametros += jsSegAccesCodAcce + "|";
	parametros += jsSegAccesDescripcion + "|";
	parametros += jsSegAccesCanaOidCana + "|";
	parametros += jsSegAccesIndAcce + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function segAccesBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsSegAccesCodAcce + "|";
	parametros += jsSegAccesDescripcion + "|";
	parametros += jsSegAccesCanaOidCana + "|";
	parametros += jsSegAccesIndAcce + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('segAccesFrm.accion'), 
		get('segAccesFrm.origen'));
	
	jsSegAccesId = get('segAccesFrm.id').toString();
	jsSegAccesCodAcce = get('segAccesFrm.codAcce').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsSegAccesDescripcion = buildLocalizedString('segAccesFrm', 1);
	}else{
		jsSegAccesDescripcion = get('segAccesFrm.Descripcion');
	}
	jsSegAccesCanaOidCana = get('segAccesFrm.canaOidCana')[0];
	jsSegAccesIndAcce = get('segAccesFrm.indAcce')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('segAccesFrm.accion'), 
		get('segAccesFrm.origen'));


	set('segAccesFrm.id', jsSegAccesId);
	set('segAccesFrm.codAcce', jsSegAccesCodAcce);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('segAccesFrm', 1,  jsSegAccesDescripcion)
		loadLocalizationWidget('segAccesFrm', 'Descripcion', 1);
	}else{
		set('segAccesFrm.Descripcion', jsSegAccesDescripcion);		
	}
	set('segAccesFrm.canaOidCana', [jsSegAccesCanaOidCana]);
	set('segAccesFrm.indAcce', [jsSegAccesIndAcce]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsSegAccesCodAcce = '';
	jsSegAccesDescripcion = '';
	jsSegAccesCanaOidCana = '';
	jsSegAccesIndAcce = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('segAccesFrm.errCodigo', errorCode);
	set('segAccesFrm.errDescripcion', description);
	set('segAccesFrm.errSeverity', severity);
	fMostrarMensajeError();
}



/*
    INDRA/CAR/mmg
    $Id: segsubac.js,v 1.1 2009/12/03 19:01:58 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsSegSubacId = "";
var jsSegSubacAcceOidAcce = "";
var jsSegSubacCodSbac = "";
var jsSegSubacDescripcion = "";

//Variables de paginacion, 
var segSubacPageCount = 1;

//Varible de columna que representa el campo de choice
var segSubacChoiceColumn = 2;

//Flag de siguiente pagina;
var segSubacMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var segSubacTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 189;
var sizeFormView = 175;
var sizeFormUpdate = 175;

//Ultima busqueda realizada
var segSubacLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("segSubac","acceOidAcce", false);','focalizaComboDependence("segSubac","acceOidAcce", false);','focalizaComboDependence("segSubac","acceOidAcce", false);','focalizaComboDependence("segSubac","acceOidAcce", true);','focalizaComboDependence("segSubac","acceOidAcce", true);','focalizaComboDependence("segSubac","acceOidAcce", true);'],[3,'focaliza("segSubacFrm.codSbac");','focaliza("segSubacFrm.codSbac");','focaliza("segSubacFrm.codSbac");','focaliza("segSubacFrm.codSbac");','focaliza("segSubacFrm.codSbac");','focaliza("segSubacFrm.codSbac");'],[4,'focaliza("segSubacFrm.Descripcion");','focaliza("segSubacFrm.Descripcion");','focaliza("segSubacFrm.Descripcion");','focaliza("segSubacFrm.Descripcion");','focaliza("segSubacFrm.Descripcion");','focaliza("segSubacFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focalizaComboDependence("segSubac","acceOidAcce", false);','focalizaComboDependence("segSubac","acceOidAcce", false);','focalizaComboDependence("segSubac","acceOidAcce", false);','focalizaComboDependence("segSubac","acceOidAcce", true);','focalizaComboDependence("segSubac","acceOidAcce", true);','focalizaComboDependence("segSubac","acceOidAcce", true);'],[3,'focaliza("segSubacFrm.codSbac");','focaliza("segSubacFrm.codSbac");','focaliza("segSubacFrm.codSbac");','focaliza("segSubacFrm.codSbac");','focaliza("segSubacFrm.codSbac");','focaliza("segSubacFrm.codSbac");'],[4,'focaliza("segSubacFrm.Descripcion");','focaliza("segSubacFrm.Descripcion");','focaliza("segSubacFrm.Descripcion");','focaliza("segSubacFrm.Descripcion");','focaliza("segSubacFrm.Descripcion");','focaliza("segSubacFrm.Descripcion");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var acceOidAcceDependeceMap = new Vector();
acceOidAcceDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
acceOidAcceDependeceMap.agregar(['acceOidAcce_canaOidCana', padresTmp, 'acceOidAcce', 'SegCanalView']);
padresTmp =  new Vector();
padresTmp.cargar(['acceOidAcce_canaOidCana'])
acceOidAcceDependeceMap.agregar(['acceOidAcce', padresTmp, '', 'SegAcces']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
segSubacLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var segSubacTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function segSubacInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('segSubacFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('segSubacFrm.accion')){
		case "query": segSubacQueryInitComponents(); break;
		case "view": segSubacViewInitComponents(); break;
		case "create": segSubacCreateInitComponents(); break;
		case "update": segSubacUpdateInitComponents(); break;
		case "remove": segSubacRemoveInitComponents(); break;
		case "lov": segSubacLovInitComponents(); break;
	}
	//alert('accion :' + get('segSubacFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('segSubacFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('segSubac')) segSubacCmdRequery();
}

function segSubacQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('segSubacFrm', true);	
}

function segSubacViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('segSubacFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('segSubacFrm', true);
}

function segSubacCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('segSubacFrm.acceOidAcce','S', GestionarMensaje('SegSubac.acceOidAcce.requiered.message'));
	
	setMV('segSubacFrm.codSbac','S', GestionarMensaje('SegSubac.codSbac.requiered.message'));
	
	setMV('segSubacFrm.Descripcion','S', GestionarMensaje('SegSubac.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('segSubacFrm', true);
}

function segSubacUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('segSubacFrm.origen') == "pagina"){
		loadLocalizationWidget('segSubacFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		segSubacTmpUpdateValues = segSubacBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('segSubacFrm.acceOidAcce','S', GestionarMensaje('SegSubac.acceOidAcce.requiered.message'));
		setMV('segSubacFrm.codSbac','S', GestionarMensaje('SegSubac.codSbac.requiered.message'));
		setMV('segSubacFrm.Descripcion','S', GestionarMensaje('SegSubac.Descripcion.requiered.message'));
		
			focusFirstFieldModify('segSubacFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('segSubacFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('segSubacFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function segSubacRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	segSubacList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('segSubacFrm', true);
}

function segSubacLovInitComponents(){
	segSubacLovReturnParameters = window.dialogArguments;
	
	focusFirstField('segSubacFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function segSubacSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('segSubacFrm.' + campo, id);
	set('segSubacFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function segSubacLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	segSubacLovReturnParameters.id = '';
	segSubacLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function segSubacLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segSubacList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = segSubacList.codSeleccionados();
	var descripcion = segSubacList.extraeDato(
		segSubacList.codSeleccionados()[0], segSubacChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	segSubacLovReturnParameters.id = codigo;
	segSubacLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function segSubacCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('segSubacFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('segSubacFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "segSubacList", "SegSubacConectorTransactionQuery", 
		"result_ROWSET", parametros, "segSubacPostQueryActions(datos);"]], "", "");	
}

function segSubacCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('segSubacFrm.lastQueryToSession'));
	var i =0;
	set('segSubacFrm.acceOidAcce', [paramsRequery.ij(i++)]);
	
	set('segSubacFrm.codSbac', paramsRequery.ij(i++));
	
	set('segSubacFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	segSubacPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	segSubacCmdQuery(segSubacPageCount);
}

function segSubacFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	segSubacPageCount = 1;
	segSubacCmdQuery(segSubacPageCount);
}

function segSubacPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != segSubacLastQuery){
		segSubacFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	segSubacPageCount--;
	segSubacCmdQuery(segSubacPageCount);
}

function segSubacNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != segSubacLastQuery){
		segSubacFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	segSubacPageCount++;
	segSubacCmdQuery(segSubacPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function segSubacPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('segSubacListLayer', 'O');
		visibilidad('segSubacListButtonsLayer', 'O');
		if(get('segSubacFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	segSubacLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:segSubacViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, segSubacChoiceColumn) + "</A>",
			i, segSubacChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	segSubacList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	segSubacTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		segSubacMorePagesFlag = true;
		segSubacList.eliminar(mmgPageSize, 1);
	}else{
		segSubacMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('segSubacFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('segSubacListLayer', 'V');
	visibilidad('segSubacListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('segSubacList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	segSubacList.display();
	
	//Actualizamos el estado de los botones 
	if(segSubacMorePagesFlag){
		set_estado_botonera('segSubacPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('segSubacPaginationButtonBar',
			3,"inactivo");
	}
	if(segSubacPageCount > 1){
		set_estado_botonera('segSubacPaginationButtonBar',
			2,"activo");
		set_estado_botonera('segSubacPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('segSubacPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('segSubacPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function segSubacUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segSubacList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('segSubacFrm.idSelection', segSubacList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('segSubacFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = segSubacList.codSeleccionados()[0];
		parametros["previousAction"] = get('segSubacFrm.accion');
		parametros["accion"] = get('segSubacFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('SegSubacLPStartUp', get('segSubacFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) segSubacCmdRequery();
	}
}

function segSubacRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segSubacList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = segSubacList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('segSubacFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(segSubacList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += segSubacTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('segSubacFrm.timestamp', timestamps);


	segSubacFrm.oculto='S';
	envia('segSubacFrm');
	segSubacFrm.oculto='N';
}

function segSubacViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segSubacList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	segSubacViewDetail(segSubacList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function segSubacViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('segSubacFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('SegSubacLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('segSubacFrm', 
		'Descripcion', 1,
		get('segSubacFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('segSubacFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('segSubacFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('SegSubac.Descripcion.requiered.message'));
		focaliza('segSubacFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		segSubacFrm.oculto='S';
		envia('segSubacFrm');
		segSubacFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('segSubacFrm.acceOidAcce').toString() == ''){
		set('segSubacFrm.acceOidAcce_canaOidCana', []);
		mmgResetCombosOnCascade('acceOidAcce_canaOidCana', 'acceOidAcce', 'segSubac');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	segSubacRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('segSubacFrm.accion');
	var origenTmp = get('segSubacFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(segSubacBuildUpdateRecordString() != segSubacTmpUpdateValues){
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
	document.all.segSubacListLayer.style.display='none';
	document.all.segSubacListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.segSubacListLayer.style.display='';
	document.all.segSubacListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsSegSubacAcceOidAcce = get('segSubacFrm.acceOidAcce')[0];
	jsSegSubacCodSbac = get('segSubacFrm.codSbac').toString();
	jsSegSubacDescripcion = get('segSubacFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsSegSubacAcceOidAcce + "|";
	parametros += jsSegSubacCodSbac + "|";
	parametros += jsSegSubacDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function segSubacBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsSegSubacAcceOidAcce + "|";
	parametros += jsSegSubacCodSbac + "|";
	parametros += jsSegSubacDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('segSubacFrm.accion'), 
		get('segSubacFrm.origen'));
	
	jsSegSubacId = get('segSubacFrm.id').toString();
	jsSegSubacAcceOidAcce = get('segSubacFrm.acceOidAcce')[0];
	jsSegSubacCodSbac = get('segSubacFrm.codSbac').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsSegSubacDescripcion = buildLocalizedString('segSubacFrm', 1);
	}else{
		jsSegSubacDescripcion = get('segSubacFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('segSubacFrm.accion'), 
		get('segSubacFrm.origen'));


	set('segSubacFrm.id', jsSegSubacId);
	set('segSubacFrm.acceOidAcce', [jsSegSubacAcceOidAcce]);
	set('segSubacFrm.codSbac', jsSegSubacCodSbac);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('segSubacFrm', 1,  jsSegSubacDescripcion)
		loadLocalizationWidget('segSubacFrm', 'Descripcion', 1);
	}else{
		set('segSubacFrm.Descripcion', jsSegSubacDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsSegSubacAcceOidAcce = '';
	jsSegSubacCodSbac = '';
	jsSegSubacDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('segSubacFrm.errCodigo', errorCode);
	set('segSubacFrm.errDescripcion', description);
	set('segSubacFrm.errSeverity', severity);
	fMostrarMensajeError();
}

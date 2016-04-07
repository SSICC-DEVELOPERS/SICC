

/*
    INDRA/CAR/mmg
    $Id: carcodigaprob.js,v 1.1 2009/12/03 19:02:29 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCarCodigAprobId = "";
var jsCarCodigAprobCodApro = "";
var jsCarCodigAprobDescripcion = "";

//Variables de paginacion, 
var carCodigAprobPageCount = 1;

//Varible de columna que representa el campo de choice
var carCodigAprobChoiceColumn = 1;

//Flag de siguiente pagina;
var carCodigAprobMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var carCodigAprobTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var carCodigAprobLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("carCodigAprobFrm.codApro");','focaliza("carCodigAprobFrm.codApro");','focaliza("carCodigAprobFrm.codApro");','focaliza("carCodigAprobFrm.codApro");','focaliza("carCodigAprobFrm.codApro");','focaliza("carCodigAprobFrm.codApro");'],[3,'focaliza("carCodigAprobFrm.Descripcion");','focaliza("carCodigAprobFrm.Descripcion");','focaliza("carCodigAprobFrm.Descripcion");','focaliza("carCodigAprobFrm.Descripcion");','focaliza("carCodigAprobFrm.Descripcion");','focaliza("carCodigAprobFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("carCodigAprobFrm.Descripcion");','focaliza("carCodigAprobFrm.Descripcion");','focaliza("carCodigAprobFrm.Descripcion");','focaliza("carCodigAprobFrm.Descripcion");','focaliza("carCodigAprobFrm.Descripcion");','focaliza("carCodigAprobFrm.Descripcion");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
carCodigAprobLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var carCodigAprobTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function carCodigAprobInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('carCodigAprobFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('carCodigAprobFrm.accion')){
		case "query": carCodigAprobQueryInitComponents(); break;
		case "view": carCodigAprobViewInitComponents(); break;
		case "create": carCodigAprobCreateInitComponents(); break;
		case "update": carCodigAprobUpdateInitComponents(); break;
		case "remove": carCodigAprobRemoveInitComponents(); break;
		case "lov": carCodigAprobLovInitComponents(); break;
	}
	//alert('accion :' + get('carCodigAprobFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('carCodigAprobFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('carCodigAprob')) carCodigAprobCmdRequery();
}

function carCodigAprobQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('carCodigAprobFrm', true);	
}

function carCodigAprobViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('carCodigAprobFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('carCodigAprobFrm', true);
}

function carCodigAprobCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('carCodigAprobFrm.codApro','S', GestionarMensaje('CarCodigAprob.codApro.requiered.message'));
	
	setMV('carCodigAprobFrm.Descripcion','S', GestionarMensaje('CarCodigAprob.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('carCodigAprobFrm', true);
}

function carCodigAprobUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('carCodigAprobFrm.origen') == "pagina"){
		loadLocalizationWidget('carCodigAprobFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		carCodigAprobTmpUpdateValues = carCodigAprobBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('carCodigAprobFrm.codApro','S', GestionarMensaje('CarCodigAprob.codApro.requiered.message'));
		setMV('carCodigAprobFrm.Descripcion','S', GestionarMensaje('CarCodigAprob.Descripcion.requiered.message'));
		
			focusFirstFieldModify('carCodigAprobFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('carCodigAprobFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('carCodigAprobFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function carCodigAprobRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	carCodigAprobList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('carCodigAprobFrm', true);
}

function carCodigAprobLovInitComponents(){
	carCodigAprobLovReturnParameters = window.dialogArguments;
	
	focusFirstField('carCodigAprobFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad





//Función que permite cargar los datos de un elemento de lov seleccionado
function carCodigAprobSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('carCodigAprobFrm.' + campo, id);
	set('carCodigAprobFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function carCodigAprobLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	carCodigAprobLovReturnParameters.id = '';
	carCodigAprobLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function carCodigAprobLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carCodigAprobList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = carCodigAprobList.codSeleccionados();
	var descripcion = carCodigAprobList.extraeDato(
		carCodigAprobList.codSeleccionados()[0], carCodigAprobChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	carCodigAprobLovReturnParameters.id = codigo;
	carCodigAprobLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function carCodigAprobCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('carCodigAprobFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('carCodigAprobFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "carCodigAprobList", "CarCodigAprobConectorTransactionQuery", 
		"result_ROWSET", parametros, "carCodigAprobPostQueryActions(datos);"]], "", "");	
}

function carCodigAprobCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('carCodigAprobFrm.lastQueryToSession'));
	var i =0;
	set('carCodigAprobFrm.codApro', paramsRequery.ij(i++));
	
	set('carCodigAprobFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	carCodigAprobPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	carCodigAprobCmdQuery(carCodigAprobPageCount);
}

function carCodigAprobFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	carCodigAprobPageCount = 1;
	carCodigAprobCmdQuery(carCodigAprobPageCount);
}

function carCodigAprobPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != carCodigAprobLastQuery){
		carCodigAprobFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	carCodigAprobPageCount--;
	carCodigAprobCmdQuery(carCodigAprobPageCount);
}

function carCodigAprobNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != carCodigAprobLastQuery){
		carCodigAprobFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	carCodigAprobPageCount++;
	carCodigAprobCmdQuery(carCodigAprobPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function carCodigAprobPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('carCodigAprobListLayer', 'O');
		visibilidad('carCodigAprobListButtonsLayer', 'O');
		if(get('carCodigAprobFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	carCodigAprobLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:carCodigAprobViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, carCodigAprobChoiceColumn) + "</A>",
			i, carCodigAprobChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	carCodigAprobList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	carCodigAprobTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		carCodigAprobMorePagesFlag = true;
		carCodigAprobList.eliminar(mmgPageSize, 1);
	}else{
		carCodigAprobMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('carCodigAprobFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('carCodigAprobListLayer', 'V');
	visibilidad('carCodigAprobListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('carCodigAprobList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	carCodigAprobList.display();
	
	//Actualizamos el estado de los botones 
	if(carCodigAprobMorePagesFlag){
		set_estado_botonera('carCodigAprobPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('carCodigAprobPaginationButtonBar',
			3,"inactivo");
	}
	if(carCodigAprobPageCount > 1){
		set_estado_botonera('carCodigAprobPaginationButtonBar',
			2,"activo");
		set_estado_botonera('carCodigAprobPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('carCodigAprobPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('carCodigAprobPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function carCodigAprobUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carCodigAprobList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('carCodigAprobFrm.idSelection', carCodigAprobList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('carCodigAprobFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = carCodigAprobList.codSeleccionados()[0];
		parametros["previousAction"] = get('carCodigAprobFrm.accion');
		parametros["accion"] = get('carCodigAprobFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CarCodigAprobLPStartUp', get('carCodigAprobFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) carCodigAprobCmdRequery();
	}
}

function carCodigAprobRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carCodigAprobList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = carCodigAprobList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('carCodigAprobFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(carCodigAprobList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += carCodigAprobTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('carCodigAprobFrm.timestamp', timestamps);


	carCodigAprobFrm.oculto='S';
	envia('carCodigAprobFrm');
	carCodigAprobFrm.oculto='N';
}

function carCodigAprobViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carCodigAprobList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	carCodigAprobViewDetail(carCodigAprobList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function carCodigAprobViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('carCodigAprobFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CarCodigAprobLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	setDefaultLanguageValue('carCodigAprobFrm', 
		'Descripcion', 1,
		get('carCodigAprobFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('carCodigAprobFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	if(!hasDefaultLanguageValue('carCodigAprobFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('CarCodigAprob.Descripcion.requiered.message'));
		focaliza('carCodigAprobFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		carCodigAprobFrm.oculto='S';
		envia('carCodigAprobFrm');
		carCodigAprobFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	carCodigAprobRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('carCodigAprobFrm.accion');
	var origenTmp = get('carCodigAprobFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(carCodigAprobBuildUpdateRecordString() != carCodigAprobTmpUpdateValues){
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
	document.all.carCodigAprobListLayer.style.display='none';
	document.all.carCodigAprobListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.carCodigAprobListLayer.style.display='';
	document.all.carCodigAprobListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCarCodigAprobCodApro = get('carCodigAprobFrm.codApro').toString();
	jsCarCodigAprobDescripcion = get('carCodigAprobFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsCarCodigAprobCodApro + "|";
	parametros += jsCarCodigAprobDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function carCodigAprobBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCarCodigAprobCodApro + "|";
	parametros += jsCarCodigAprobDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carCodigAprobFrm.accion'), 
		get('carCodigAprobFrm.origen'));
	
	jsCarCodigAprobId = get('carCodigAprobFrm.id').toString();
	jsCarCodigAprobCodApro = get('carCodigAprobFrm.codApro').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsCarCodigAprobDescripcion = buildLocalizedString('carCodigAprobFrm', 1);
	}else{
		jsCarCodigAprobDescripcion = get('carCodigAprobFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carCodigAprobFrm.accion'), 
		get('carCodigAprobFrm.origen'));


	set('carCodigAprobFrm.id', jsCarCodigAprobId);
	set('carCodigAprobFrm.codApro', jsCarCodigAprobCodApro);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('carCodigAprobFrm', 1,  jsCarCodigAprobDescripcion)
		loadLocalizationWidget('carCodigAprobFrm', 'Descripcion', 1);
	}else{
		set('carCodigAprobFrm.Descripcion', jsCarCodigAprobDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCarCodigAprobCodApro = '';
	jsCarCodigAprobDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('carCodigAprobFrm.errCodigo', errorCode);
	set('carCodigAprobFrm.errDescripcion', description);
	set('carCodigAprobFrm.errSeverity', severity);
	fMostrarMensajeError();
}

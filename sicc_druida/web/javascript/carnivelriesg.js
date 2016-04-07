

/*
    INDRA/CAR/mmg
    $Id: carnivelriesg.js,v 1.1 2009/12/03 19:02:08 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCarNivelRiesgId = "";
var jsCarNivelRiesgCodNiveRies = "";
var jsCarNivelRiesgDescripcion = "";

//Variables de paginacion, 
var carNivelRiesgPageCount = 1;

//Varible de columna que representa el campo de choice
var carNivelRiesgChoiceColumn = 1;

//Flag de siguiente pagina;
var carNivelRiesgMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var carNivelRiesgTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var carNivelRiesgLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("carNivelRiesgFrm.codNiveRies");','focaliza("carNivelRiesgFrm.codNiveRies");','focaliza("carNivelRiesgFrm.codNiveRies");','focaliza("carNivelRiesgFrm.codNiveRies");','focaliza("carNivelRiesgFrm.codNiveRies");','focaliza("carNivelRiesgFrm.codNiveRies");'],[3,'focaliza("carNivelRiesgFrm.Descripcion");','focaliza("carNivelRiesgFrm.Descripcion");','focaliza("carNivelRiesgFrm.Descripcion");','focaliza("carNivelRiesgFrm.Descripcion");','focaliza("carNivelRiesgFrm.Descripcion");','focaliza("carNivelRiesgFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("carNivelRiesgFrm.Descripcion");','focaliza("carNivelRiesgFrm.Descripcion");','focaliza("carNivelRiesgFrm.Descripcion");','focaliza("carNivelRiesgFrm.Descripcion");','focaliza("carNivelRiesgFrm.Descripcion");','focaliza("carNivelRiesgFrm.Descripcion");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
carNivelRiesgLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var carNivelRiesgTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function carNivelRiesgInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('carNivelRiesgFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('carNivelRiesgFrm.accion')){
		case "query": carNivelRiesgQueryInitComponents(); break;
		case "view": carNivelRiesgViewInitComponents(); break;
		case "create": carNivelRiesgCreateInitComponents(); break;
		case "update": carNivelRiesgUpdateInitComponents(); break;
		case "remove": carNivelRiesgRemoveInitComponents(); break;
		case "lov": carNivelRiesgLovInitComponents(); break;
	}
	//alert('accion :' + get('carNivelRiesgFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('carNivelRiesgFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('carNivelRiesg')) carNivelRiesgCmdRequery();
}

function carNivelRiesgQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('carNivelRiesgFrm', true);	
}

function carNivelRiesgViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('carNivelRiesgFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('carNivelRiesgFrm', true);
}

function carNivelRiesgCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('carNivelRiesgFrm.codNiveRies','S', GestionarMensaje('CarNivelRiesg.codNiveRies.requiered.message'));
	
	setMV('carNivelRiesgFrm.Descripcion','S', GestionarMensaje('CarNivelRiesg.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('carNivelRiesgFrm', true);
}

function carNivelRiesgUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('carNivelRiesgFrm.origen') == "pagina"){
		loadLocalizationWidget('carNivelRiesgFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		carNivelRiesgTmpUpdateValues = carNivelRiesgBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('carNivelRiesgFrm.codNiveRies','S', GestionarMensaje('CarNivelRiesg.codNiveRies.requiered.message'));
		setMV('carNivelRiesgFrm.Descripcion','S', GestionarMensaje('CarNivelRiesg.Descripcion.requiered.message'));
		
			focusFirstFieldModify('carNivelRiesgFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('carNivelRiesgFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('carNivelRiesgFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function carNivelRiesgRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	carNivelRiesgList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('carNivelRiesgFrm', true);
}

function carNivelRiesgLovInitComponents(){
	carNivelRiesgLovReturnParameters = window.dialogArguments;
	
	focusFirstField('carNivelRiesgFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad





//Función que permite cargar los datos de un elemento de lov seleccionado
function carNivelRiesgSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('carNivelRiesgFrm.' + campo, id);
	set('carNivelRiesgFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function carNivelRiesgLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	carNivelRiesgLovReturnParameters.id = '';
	carNivelRiesgLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function carNivelRiesgLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carNivelRiesgList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = carNivelRiesgList.codSeleccionados();
	var descripcion = carNivelRiesgList.extraeDato(
		carNivelRiesgList.codSeleccionados()[0], carNivelRiesgChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	carNivelRiesgLovReturnParameters.id = codigo;
	carNivelRiesgLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function carNivelRiesgCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('carNivelRiesgFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('carNivelRiesgFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "carNivelRiesgList", "CarNivelRiesgConectorTransactionQuery", 
		"result_ROWSET", parametros, "carNivelRiesgPostQueryActions(datos);"]], "", "");	
}

function carNivelRiesgCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('carNivelRiesgFrm.lastQueryToSession'));
	var i =0;
	set('carNivelRiesgFrm.codNiveRies', paramsRequery.ij(i++));
	
	set('carNivelRiesgFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	carNivelRiesgPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	carNivelRiesgCmdQuery(carNivelRiesgPageCount);
}

function carNivelRiesgFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	carNivelRiesgPageCount = 1;
	carNivelRiesgCmdQuery(carNivelRiesgPageCount);
}

function carNivelRiesgPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != carNivelRiesgLastQuery){
		carNivelRiesgFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	carNivelRiesgPageCount--;
	carNivelRiesgCmdQuery(carNivelRiesgPageCount);
}

function carNivelRiesgNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != carNivelRiesgLastQuery){
		carNivelRiesgFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	carNivelRiesgPageCount++;
	carNivelRiesgCmdQuery(carNivelRiesgPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function carNivelRiesgPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('carNivelRiesgListLayer', 'O');
		visibilidad('carNivelRiesgListButtonsLayer', 'O');
		if(get('carNivelRiesgFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	carNivelRiesgLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:carNivelRiesgViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, carNivelRiesgChoiceColumn) + "</A>",
			i, carNivelRiesgChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	carNivelRiesgList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	carNivelRiesgTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		carNivelRiesgMorePagesFlag = true;
		carNivelRiesgList.eliminar(mmgPageSize, 1);
	}else{
		carNivelRiesgMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('carNivelRiesgFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('carNivelRiesgListLayer', 'V');
	visibilidad('carNivelRiesgListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('carNivelRiesgList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	carNivelRiesgList.display();
	
	//Actualizamos el estado de los botones 
	if(carNivelRiesgMorePagesFlag){
		set_estado_botonera('carNivelRiesgPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('carNivelRiesgPaginationButtonBar',
			3,"inactivo");
	}
	if(carNivelRiesgPageCount > 1){
		set_estado_botonera('carNivelRiesgPaginationButtonBar',
			2,"activo");
		set_estado_botonera('carNivelRiesgPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('carNivelRiesgPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('carNivelRiesgPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function carNivelRiesgUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carNivelRiesgList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('carNivelRiesgFrm.idSelection', carNivelRiesgList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('carNivelRiesgFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = carNivelRiesgList.codSeleccionados()[0];
		parametros["previousAction"] = get('carNivelRiesgFrm.accion');
		parametros["accion"] = get('carNivelRiesgFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CarNivelRiesgLPStartUp', get('carNivelRiesgFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) carNivelRiesgCmdRequery();
	}
}

function carNivelRiesgRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carNivelRiesgList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = carNivelRiesgList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('carNivelRiesgFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(carNivelRiesgList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += carNivelRiesgTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('carNivelRiesgFrm.timestamp', timestamps);


	carNivelRiesgFrm.oculto='S';
	envia('carNivelRiesgFrm');
	carNivelRiesgFrm.oculto='N';
}

function carNivelRiesgViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carNivelRiesgList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	carNivelRiesgViewDetail(carNivelRiesgList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function carNivelRiesgViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('carNivelRiesgFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CarNivelRiesgLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	setDefaultLanguageValue('carNivelRiesgFrm', 
		'Descripcion', 1,
		get('carNivelRiesgFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('carNivelRiesgFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	if(!hasDefaultLanguageValue('carNivelRiesgFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('CarNivelRiesg.Descripcion.requiered.message'));
		focaliza('carNivelRiesgFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		carNivelRiesgFrm.oculto='S';
		envia('carNivelRiesgFrm');
		carNivelRiesgFrm.oculto='N';
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
	carNivelRiesgRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('carNivelRiesgFrm.accion');
	var origenTmp = get('carNivelRiesgFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(carNivelRiesgBuildUpdateRecordString() != carNivelRiesgTmpUpdateValues){
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
	document.all.carNivelRiesgListLayer.style.display='none';
	document.all.carNivelRiesgListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.carNivelRiesgListLayer.style.display='';
	document.all.carNivelRiesgListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCarNivelRiesgCodNiveRies = get('carNivelRiesgFrm.codNiveRies').toString();
	jsCarNivelRiesgDescripcion = get('carNivelRiesgFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsCarNivelRiesgCodNiveRies + "|";
	parametros += jsCarNivelRiesgDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function carNivelRiesgBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCarNivelRiesgCodNiveRies + "|";
	parametros += jsCarNivelRiesgDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carNivelRiesgFrm.accion'), 
		get('carNivelRiesgFrm.origen'));
	
	jsCarNivelRiesgId = get('carNivelRiesgFrm.id').toString();
	jsCarNivelRiesgCodNiveRies = get('carNivelRiesgFrm.codNiveRies').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsCarNivelRiesgDescripcion = buildLocalizedString('carNivelRiesgFrm', 1);
	}else{
		jsCarNivelRiesgDescripcion = get('carNivelRiesgFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carNivelRiesgFrm.accion'), 
		get('carNivelRiesgFrm.origen'));


	set('carNivelRiesgFrm.id', jsCarNivelRiesgId);
	set('carNivelRiesgFrm.codNiveRies', jsCarNivelRiesgCodNiveRies);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('carNivelRiesgFrm', 1,  jsCarNivelRiesgDescripcion)
		loadLocalizationWidget('carNivelRiesgFrm', 'Descripcion', 1);
	}else{
		set('carNivelRiesgFrm.Descripcion', jsCarNivelRiesgDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCarNivelRiesgCodNiveRies = '';
	jsCarNivelRiesgDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('carNivelRiesgFrm.errCodigo', errorCode);
	set('carNivelRiesgFrm.errDescripcion', description);
	set('carNivelRiesgFrm.errSeverity', severity);
	fMostrarMensajeError();
}

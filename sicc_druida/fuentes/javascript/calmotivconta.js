

/*
    INDRA/CAR/mmg
    $Id: calmotivconta.js,v 1.1 2009/12/03 19:02:04 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCalMotivContaId = "";
var jsCalMotivContaCodMoti = "";
var jsCalMotivContaDescripcion = "";
var jsCalMotivContaCodProc = "";

//Variables de paginacion, 
var calMotivContaPageCount = 1;

//Varible de columna que representa el campo de choice
var calMotivContaChoiceColumn = 1;

//Flag de siguiente pagina;
var calMotivContaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var calMotivContaTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var calMotivContaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("calMotivContaFrm.codMoti");','focaliza("calMotivContaFrm.codMoti");','','focaliza("calMotivContaFrm.codMoti");','focaliza("calMotivContaFrm.codMoti");',''],[3,'focaliza("calMotivContaFrm.Descripcion");','focaliza("calMotivContaFrm.Descripcion");','focaliza("calMotivContaFrm.Descripcion");','focaliza("calMotivContaFrm.Descripcion");','focaliza("calMotivContaFrm.Descripcion");','focaliza("calMotivContaFrm.Descripcion");'],[4,'focaliza("calMotivContaFrm.codProc");','focaliza("calMotivContaFrm.codProc");','focaliza("calMotivContaFrm.codProc");','focaliza("calMotivContaFrm.codProc");','focaliza("calMotivContaFrm.codProc");','focaliza("calMotivContaFrm.codProc");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("calMotivContaFrm.codMoti");','focaliza("calMotivContaFrm.codMoti");','','focaliza("calMotivContaFrm.codMoti");','focaliza("calMotivContaFrm.codMoti");',''],[3,'focaliza("calMotivContaFrm.Descripcion");','focaliza("calMotivContaFrm.Descripcion");','focaliza("calMotivContaFrm.Descripcion");','focaliza("calMotivContaFrm.Descripcion");','focaliza("calMotivContaFrm.Descripcion");','focaliza("calMotivContaFrm.Descripcion");'],[4,'focaliza("calMotivContaFrm.codProc");','focaliza("calMotivContaFrm.codProc");','focaliza("calMotivContaFrm.codProc");','focaliza("calMotivContaFrm.codProc");','focaliza("calMotivContaFrm.codProc");','focaliza("calMotivContaFrm.codProc");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
calMotivContaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var calMotivContaTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function calMotivContaInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('calMotivContaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('calMotivContaFrm.accion')){
		case "query": calMotivContaQueryInitComponents(); break;
		case "view": calMotivContaViewInitComponents(); break;
		case "create": calMotivContaCreateInitComponents(); break;
		case "update": calMotivContaUpdateInitComponents(); break;
		case "remove": calMotivContaRemoveInitComponents(); break;
		case "lov": calMotivContaLovInitComponents(); break;
	}
	//alert('accion :' + get('calMotivContaFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('calMotivContaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('calMotivConta')) calMotivContaCmdRequery();
}

function calMotivContaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('calMotivContaFrm', true);	
}

function calMotivContaViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('calMotivContaFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('calMotivContaFrm', true);
}

function calMotivContaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('calMotivContaFrm.codMoti','S', GestionarMensaje('CalMotivConta.codMoti.requiered.message'));
	
	setMV('calMotivContaFrm.Descripcion','S', GestionarMensaje('CalMotivConta.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('calMotivContaFrm', true);
}

function calMotivContaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('calMotivContaFrm.origen') == "pagina"){
		loadLocalizationWidget('calMotivContaFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		calMotivContaTmpUpdateValues = calMotivContaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('calMotivContaFrm.Descripcion','S', GestionarMensaje('CalMotivConta.Descripcion.requiered.message'));
		
			focusFirstFieldModify('calMotivContaFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('calMotivContaFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('calMotivContaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function calMotivContaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	calMotivContaList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('calMotivContaFrm', true);
}

function calMotivContaLovInitComponents(){
	calMotivContaLovReturnParameters = window.dialogArguments;
	
	focusFirstField('calMotivContaFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function calMotivContaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('calMotivContaFrm.' + campo, id);
	set('calMotivContaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function calMotivContaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	calMotivContaLovReturnParameters.id = '';
	calMotivContaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function calMotivContaLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(calMotivContaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = calMotivContaList.codSeleccionados();
	var descripcion = calMotivContaList.extraeDato(
		calMotivContaList.codSeleccionados()[0], calMotivContaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	calMotivContaLovReturnParameters.id = codigo;
	calMotivContaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function calMotivContaCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('calMotivContaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('calMotivContaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "calMotivContaList", "CalMotivContaConectorTransactionQuery", 
		"result_ROWSET", parametros, "calMotivContaPostQueryActions(datos);"]], "", "");	
}

function calMotivContaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('calMotivContaFrm.lastQueryToSession'));
	var i =0;
	set('calMotivContaFrm.codMoti', paramsRequery.ij(i++));
	
	set('calMotivContaFrm.Descripcion', paramsRequery.ij(i++));
	
	set('calMotivContaFrm.codProc', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	calMotivContaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	calMotivContaCmdQuery(calMotivContaPageCount);
}

function calMotivContaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	calMotivContaPageCount = 1;
	calMotivContaCmdQuery(calMotivContaPageCount);
}

function calMotivContaPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != calMotivContaLastQuery){
		calMotivContaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	calMotivContaPageCount--;
	calMotivContaCmdQuery(calMotivContaPageCount);
}

function calMotivContaNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != calMotivContaLastQuery){
		calMotivContaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	calMotivContaPageCount++;
	calMotivContaCmdQuery(calMotivContaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function calMotivContaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('calMotivContaListLayer', 'O');
		visibilidad('calMotivContaListButtonsLayer', 'O');
		if(get('calMotivContaFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	calMotivContaLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:calMotivContaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, calMotivContaChoiceColumn) + "</A>",
			i, calMotivContaChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	calMotivContaList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	calMotivContaTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		calMotivContaMorePagesFlag = true;
		calMotivContaList.eliminar(mmgPageSize, 1);
	}else{
		calMotivContaMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('calMotivContaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('calMotivContaListLayer', 'V');
	visibilidad('calMotivContaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('calMotivContaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	calMotivContaList.display();
	
	//Actualizamos el estado de los botones 
	if(calMotivContaMorePagesFlag){
		set_estado_botonera('calMotivContaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('calMotivContaPaginationButtonBar',
			3,"inactivo");
	}
	if(calMotivContaPageCount > 1){
		set_estado_botonera('calMotivContaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('calMotivContaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('calMotivContaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('calMotivContaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function calMotivContaUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(calMotivContaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('calMotivContaFrm.idSelection', calMotivContaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('calMotivContaFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = calMotivContaList.codSeleccionados()[0];
		parametros["previousAction"] = get('calMotivContaFrm.accion');
		parametros["accion"] = get('calMotivContaFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CalMotivContaLPStartUp', get('calMotivContaFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) calMotivContaCmdRequery();
	}
}

function calMotivContaRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(calMotivContaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = calMotivContaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('calMotivContaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(calMotivContaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += calMotivContaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('calMotivContaFrm.timestamp', timestamps);


	calMotivContaFrm.oculto='S';
	envia('calMotivContaFrm');
	calMotivContaFrm.oculto='N';
}

function calMotivContaViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(calMotivContaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	calMotivContaViewDetail(calMotivContaList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function calMotivContaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('calMotivContaFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CalMotivContaLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	setDefaultLanguageValue('calMotivContaFrm', 
		'Descripcion', 1,
		get('calMotivContaFrm.Descripcion'));	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('calMotivContaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	if(!hasDefaultLanguageValue('calMotivContaFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('CalMotivConta.Descripcion.requiered.message'));
		focaliza('calMotivContaFrm.Descripcion');
		return;
	}	
	
	
		
	
	if(validacion){
		calMotivContaFrm.oculto='S';
		envia('calMotivContaFrm');
		calMotivContaFrm.oculto='N';
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
	calMotivContaRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('calMotivContaFrm.accion');
	var origenTmp = get('calMotivContaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(calMotivContaBuildUpdateRecordString() != calMotivContaTmpUpdateValues){
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
	document.all.calMotivContaListLayer.style.display='none';
	document.all.calMotivContaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.calMotivContaListLayer.style.display='';
	document.all.calMotivContaListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCalMotivContaCodMoti = get('calMotivContaFrm.codMoti').toString();
	jsCalMotivContaDescripcion = get('calMotivContaFrm.Descripcion').toString();
	jsCalMotivContaCodProc = get('calMotivContaFrm.codProc').toString();
	
	
	var parametros = "";
	parametros += jsCalMotivContaCodMoti + "|";
	parametros += jsCalMotivContaDescripcion + "|";
	parametros += jsCalMotivContaCodProc + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function calMotivContaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCalMotivContaDescripcion + "|";
	parametros += jsCalMotivContaCodProc + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('calMotivContaFrm.accion'), 
		get('calMotivContaFrm.origen'));
	
	jsCalMotivContaId = get('calMotivContaFrm.id').toString();
	jsCalMotivContaCodMoti = get('calMotivContaFrm.codMoti').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsCalMotivContaDescripcion = buildLocalizedString('calMotivContaFrm', 1);
	}else{
		jsCalMotivContaDescripcion = get('calMotivContaFrm.Descripcion');
	}
	jsCalMotivContaCodProc = get('calMotivContaFrm.codProc').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('calMotivContaFrm.accion'), 
		get('calMotivContaFrm.origen'));


	set('calMotivContaFrm.id', jsCalMotivContaId);
	set('calMotivContaFrm.codMoti', jsCalMotivContaCodMoti);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('calMotivContaFrm', 1,  jsCalMotivContaDescripcion)
		loadLocalizationWidget('calMotivContaFrm', 'Descripcion', 1);
	}else{
		set('calMotivContaFrm.Descripcion', jsCalMotivContaDescripcion);		
	}
	set('calMotivContaFrm.codProc', jsCalMotivContaCodProc);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCalMotivContaCodMoti = '';
	jsCalMotivContaDescripcion = '';
	jsCalMotivContaCodProc = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('calMotivContaFrm.errCodigo', errorCode);
	set('calMotivContaFrm.errDescripcion', description);
	set('calMotivContaFrm.errSeverity', severity);
	fMostrarMensajeError();
}

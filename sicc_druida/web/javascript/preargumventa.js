

/*
    INDRA/CAR/mmg
    $Id: preargumventa.js,v 1.1 2009/12/03 19:02:05 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPreArgumVentaId = "";
var jsPreArgumVentaCodArguVent = "";
var jsPreArgumVentaDescripcion = "";
var jsPreArgumVentaTiesOidTipoEstr = "";
var jsPreArgumVentaValFactRepe = "";

//Variables de paginacion, 
var preArgumVentaPageCount = 1;

//Varible de columna que representa el campo de choice
var preArgumVentaChoiceColumn = 1;

//Flag de siguiente pagina;
var preArgumVentaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var preArgumVentaTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var preArgumVentaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("preArgumVentaFrm.codArguVent");','focaliza("preArgumVentaFrm.codArguVent");','focaliza("preArgumVentaFrm.codArguVent");','focaliza("preArgumVentaFrm.codArguVent");','focaliza("preArgumVentaFrm.codArguVent");','focaliza("preArgumVentaFrm.codArguVent");'],[3,'focaliza("preArgumVentaFrm.Descripcion");','focaliza("preArgumVentaFrm.Descripcion");','focaliza("preArgumVentaFrm.Descripcion");','focaliza("preArgumVentaFrm.Descripcion");','focaliza("preArgumVentaFrm.Descripcion");','focaliza("preArgumVentaFrm.Descripcion");'],[4,'','focalizaComboDependence("preArgumVenta","tiesOidTipoEstr", false);','focalizaComboDependence("preArgumVenta","tiesOidTipoEstr", false);','','focalizaComboDependence("preArgumVenta","tiesOidTipoEstr", true);','focalizaComboDependence("preArgumVenta","tiesOidTipoEstr", true);'],[5,'','focaliza("preArgumVentaFrm.valFactRepe");','focaliza("preArgumVentaFrm.valFactRepe");','','focaliza("preArgumVentaFrm.valFactRepe");','focaliza("preArgumVentaFrm.valFactRepe");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("preArgumVentaFrm.codArguVent");','focaliza("preArgumVentaFrm.codArguVent");','focaliza("preArgumVentaFrm.codArguVent");','focaliza("preArgumVentaFrm.codArguVent");','focaliza("preArgumVentaFrm.codArguVent");','focaliza("preArgumVentaFrm.codArguVent");'],[3,'focaliza("preArgumVentaFrm.Descripcion");','focaliza("preArgumVentaFrm.Descripcion");','focaliza("preArgumVentaFrm.Descripcion");','focaliza("preArgumVentaFrm.Descripcion");','focaliza("preArgumVentaFrm.Descripcion");','focaliza("preArgumVentaFrm.Descripcion");'],[4,'','focalizaComboDependence("preArgumVenta","tiesOidTipoEstr", false);','focalizaComboDependence("preArgumVenta","tiesOidTipoEstr", false);','','focalizaComboDependence("preArgumVenta","tiesOidTipoEstr", true);','focalizaComboDependence("preArgumVenta","tiesOidTipoEstr", true);'],[5,'','focaliza("preArgumVentaFrm.valFactRepe");','focaliza("preArgumVentaFrm.valFactRepe");','','focaliza("preArgumVentaFrm.valFactRepe");','focaliza("preArgumVentaFrm.valFactRepe");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var tiesOidTipoEstrDependeceMap = new Vector();
tiesOidTipoEstrDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tiesOidTipoEstrDependeceMap.agregar(['tiesOidTipoEstr', padresTmp, '', 'PreTipoEstra']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
preArgumVentaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var preArgumVentaTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function preArgumVentaInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('preArgumVentaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('preArgumVentaFrm.accion')){
		case "query": preArgumVentaQueryInitComponents(); break;
		case "view": preArgumVentaViewInitComponents(); break;
		case "create": preArgumVentaCreateInitComponents(); break;
		case "update": preArgumVentaUpdateInitComponents(); break;
		case "remove": preArgumVentaRemoveInitComponents(); break;
		case "lov": preArgumVentaLovInitComponents(); break;
	}
	//alert('accion :' + get('preArgumVentaFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('preArgumVentaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('preArgumVenta')) preArgumVentaCmdRequery();
}

function preArgumVentaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('preArgumVentaFrm', true);	
}

function preArgumVentaViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('preArgumVentaFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('preArgumVentaFrm', true);
}

function preArgumVentaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('preArgumVentaFrm.codArguVent','S', GestionarMensaje('PreArgumVenta.codArguVent.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('preArgumVentaFrm', true);
}

function preArgumVentaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('preArgumVentaFrm.origen') == "pagina"){
		loadLocalizationWidget('preArgumVentaFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		preArgumVentaTmpUpdateValues = preArgumVentaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('preArgumVentaFrm.codArguVent','S', GestionarMensaje('PreArgumVenta.codArguVent.requiered.message'));
		
			focusFirstFieldModify('preArgumVentaFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('preArgumVentaFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('preArgumVentaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function preArgumVentaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	preArgumVentaList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('preArgumVentaFrm', true);
}

function preArgumVentaLovInitComponents(){
	preArgumVentaLovReturnParameters = window.dialogArguments;
	
	focusFirstField('preArgumVentaFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function preArgumVentaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('preArgumVentaFrm.' + campo, id);
	set('preArgumVentaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function preArgumVentaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	preArgumVentaLovReturnParameters.id = '';
	preArgumVentaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function preArgumVentaLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preArgumVentaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = preArgumVentaList.codSeleccionados();
	var descripcion = preArgumVentaList.extraeDato(
		preArgumVentaList.codSeleccionados()[0], preArgumVentaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	preArgumVentaLovReturnParameters.id = codigo;
	preArgumVentaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function preArgumVentaCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('preArgumVentaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('preArgumVentaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "preArgumVentaList", "PreArgumVentaConectorTransactionQuery", 
		"result_ROWSET", parametros, "preArgumVentaPostQueryActions(datos);"]], "", "");	
}

function preArgumVentaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('preArgumVentaFrm.lastQueryToSession'));
	var i =0;
	set('preArgumVentaFrm.codArguVent', paramsRequery.ij(i++));
	
	set('preArgumVentaFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	preArgumVentaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	preArgumVentaCmdQuery(preArgumVentaPageCount);
}

function preArgumVentaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	preArgumVentaPageCount = 1;
	preArgumVentaCmdQuery(preArgumVentaPageCount);
}

function preArgumVentaPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != preArgumVentaLastQuery){
		preArgumVentaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	preArgumVentaPageCount--;
	preArgumVentaCmdQuery(preArgumVentaPageCount);
}

function preArgumVentaNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != preArgumVentaLastQuery){
		preArgumVentaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	preArgumVentaPageCount++;
	preArgumVentaCmdQuery(preArgumVentaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function preArgumVentaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('preArgumVentaListLayer', 'O');
		visibilidad('preArgumVentaListButtonsLayer', 'O');
		if(get('preArgumVentaFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	preArgumVentaLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:preArgumVentaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, preArgumVentaChoiceColumn) + "</A>",
			i, preArgumVentaChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	preArgumVentaList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	preArgumVentaTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		preArgumVentaMorePagesFlag = true;
		preArgumVentaList.eliminar(mmgPageSize, 1);
	}else{
		preArgumVentaMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('preArgumVentaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('preArgumVentaListLayer', 'V');
	visibilidad('preArgumVentaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('preArgumVentaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	preArgumVentaList.display();
	
	//Actualizamos el estado de los botones 
	if(preArgumVentaMorePagesFlag){
		set_estado_botonera('preArgumVentaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('preArgumVentaPaginationButtonBar',
			3,"inactivo");
	}
	if(preArgumVentaPageCount > 1){
		set_estado_botonera('preArgumVentaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('preArgumVentaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('preArgumVentaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('preArgumVentaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function preArgumVentaUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preArgumVentaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('preArgumVentaFrm.idSelection', preArgumVentaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('preArgumVentaFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = preArgumVentaList.codSeleccionados()[0];
		parametros["previousAction"] = get('preArgumVentaFrm.accion');
		parametros["accion"] = get('preArgumVentaFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('PreArgumVentaLPStartUp', get('preArgumVentaFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) preArgumVentaCmdRequery();
	}
}

function preArgumVentaRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preArgumVentaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = preArgumVentaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('preArgumVentaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(preArgumVentaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += preArgumVentaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('preArgumVentaFrm.timestamp', timestamps);


	preArgumVentaFrm.oculto='S';
	envia('preArgumVentaFrm');
	preArgumVentaFrm.oculto='N';
}

function preArgumVentaViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preArgumVentaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	preArgumVentaViewDetail(preArgumVentaList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function preArgumVentaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('preArgumVentaFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('PreArgumVentaLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	setDefaultLanguageValue('preArgumVentaFrm', 
		'Descripcion', 1,
		get('preArgumVentaFrm.Descripcion'));	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('preArgumVentaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
		
	
	if(validacion){
		preArgumVentaFrm.oculto='S';
		envia('preArgumVentaFrm');
		preArgumVentaFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('preArgumVentaFrm.tiesOidTipoEstr').toString() == ''){
		set('preArgumVentaFrm.tiesOidTipoEstr', []);
		mmgResetCombosOnCascade('tiesOidTipoEstr', 'tiesOidTipoEstr', 'preArgumVenta');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	preArgumVentaRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('preArgumVentaFrm.accion');
	var origenTmp = get('preArgumVentaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(preArgumVentaBuildUpdateRecordString() != preArgumVentaTmpUpdateValues){
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
	document.all.preArgumVentaListLayer.style.display='none';
	document.all.preArgumVentaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.preArgumVentaListLayer.style.display='';
	document.all.preArgumVentaListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsPreArgumVentaCodArguVent = get('preArgumVentaFrm.codArguVent').toString();
	jsPreArgumVentaDescripcion = get('preArgumVentaFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsPreArgumVentaCodArguVent + "|";
	parametros += jsPreArgumVentaDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function preArgumVentaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPreArgumVentaCodArguVent + "|";
	parametros += jsPreArgumVentaDescripcion + "|";
	parametros += jsPreArgumVentaTiesOidTipoEstr + "|";
	parametros += jsPreArgumVentaValFactRepe + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('preArgumVentaFrm.accion'), 
		get('preArgumVentaFrm.origen'));
	
	jsPreArgumVentaId = get('preArgumVentaFrm.id').toString();
	jsPreArgumVentaCodArguVent = get('preArgumVentaFrm.codArguVent').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsPreArgumVentaDescripcion = buildLocalizedString('preArgumVentaFrm', 1);
	}else{
		jsPreArgumVentaDescripcion = get('preArgumVentaFrm.Descripcion');
	}
	jsPreArgumVentaTiesOidTipoEstr = get('preArgumVentaFrm.tiesOidTipoEstr')[0];
	jsPreArgumVentaValFactRepe = get('preArgumVentaFrm.valFactRepe').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('preArgumVentaFrm.accion'), 
		get('preArgumVentaFrm.origen'));


	set('preArgumVentaFrm.id', jsPreArgumVentaId);
	set('preArgumVentaFrm.codArguVent', jsPreArgumVentaCodArguVent);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('preArgumVentaFrm', 1,  jsPreArgumVentaDescripcion)
		loadLocalizationWidget('preArgumVentaFrm', 'Descripcion', 1);
	}else{
		set('preArgumVentaFrm.Descripcion', jsPreArgumVentaDescripcion);		
	}
	set('preArgumVentaFrm.tiesOidTipoEstr', [jsPreArgumVentaTiesOidTipoEstr]);
	set('preArgumVentaFrm.valFactRepe', jsPreArgumVentaValFactRepe);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsPreArgumVentaCodArguVent = '';
	jsPreArgumVentaDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('preArgumVentaFrm.errCodigo', errorCode);
	set('preArgumVentaFrm.errDescripcion', description);
	set('preArgumVentaFrm.errSeverity', severity);
	fMostrarMensajeError();
}



/*
    INDRA/CAR/mmg
    $Id: craactiv.js,v 1.1 2009/12/03 19:01:40 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCraActivId = "";
var jsCraActivCodActi = "";
var jsCraActivNumDiasDesp = "";
var jsCraActivNumCampAnte = "";
var jsCraActivIndEbel = "";
var jsCraActivIndFest = "";
var jsCraActivIndLabo = "";
var jsCraActivDescripcion = "";

//Variables de paginacion, 
var craActivPageCount = 1;

//Varible de columna que representa el campo de choice
var craActivChoiceColumn = 6;

//Flag de siguiente pagina;
var craActivMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var craActivTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 315;
var sizeFormView = 343;
var sizeFormUpdate = 343;

//Ultima busqueda realizada
var craActivLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("craActivFrm.codActi");','focaliza("craActivFrm.codActi");','focaliza("craActivFrm.codActi");','focaliza("craActivFrm.codActi");','focaliza("craActivFrm.codActi");','focaliza("craActivFrm.codActi");'],[3,'focaliza("craActivFrm.numDiasDesp");','focaliza("craActivFrm.numDiasDesp");','focaliza("craActivFrm.numDiasDesp");','focaliza("craActivFrm.numDiasDesp");','focaliza("craActivFrm.numDiasDesp");','focaliza("craActivFrm.numDiasDesp");'],[4,'focaliza("craActivFrm.numCampAnte");','focaliza("craActivFrm.numCampAnte");','focaliza("craActivFrm.numCampAnte");','focaliza("craActivFrm.numCampAnte");','focaliza("craActivFrm.numCampAnte");','focaliza("craActivFrm.numCampAnte");'],[5,'focaliza("craActivFrm.indEbel");','focaliza("craActivFrm.indEbel");','focaliza("craActivFrm.indEbel");','focaliza("craActivFrm.indEbel");','focaliza("craActivFrm.indEbel");','focaliza("craActivFrm.indEbel");'],[6,'focaliza("craActivFrm.indFest");','focaliza("craActivFrm.indFest");','focaliza("craActivFrm.indFest");','focaliza("craActivFrm.indFest");','focaliza("craActivFrm.indFest");','focaliza("craActivFrm.indFest");'],[7,'focaliza("craActivFrm.indLabo");','focaliza("craActivFrm.indLabo");','focaliza("craActivFrm.indLabo");','focaliza("craActivFrm.indLabo");','focaliza("craActivFrm.indLabo");','focaliza("craActivFrm.indLabo");'],[8,'','focaliza("craActivFrm.Descripcion");','focaliza("craActivFrm.Descripcion");','','focaliza("craActivFrm.Descripcion");','focaliza("craActivFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("craActivFrm.codActi");','focaliza("craActivFrm.codActi");','focaliza("craActivFrm.codActi");','focaliza("craActivFrm.codActi");','focaliza("craActivFrm.codActi");','focaliza("craActivFrm.codActi");'],[3,'focaliza("craActivFrm.numDiasDesp");','focaliza("craActivFrm.numDiasDesp");','focaliza("craActivFrm.numDiasDesp");','focaliza("craActivFrm.numDiasDesp");','focaliza("craActivFrm.numDiasDesp");','focaliza("craActivFrm.numDiasDesp");'],[4,'focaliza("craActivFrm.numCampAnte");','focaliza("craActivFrm.numCampAnte");','focaliza("craActivFrm.numCampAnte");','focaliza("craActivFrm.numCampAnte");','focaliza("craActivFrm.numCampAnte");','focaliza("craActivFrm.numCampAnte");'],[5,'focaliza("craActivFrm.indEbel");','focaliza("craActivFrm.indEbel");','focaliza("craActivFrm.indEbel");','focaliza("craActivFrm.indEbel");','focaliza("craActivFrm.indEbel");','focaliza("craActivFrm.indEbel");'],[6,'focaliza("craActivFrm.indFest");','focaliza("craActivFrm.indFest");','focaliza("craActivFrm.indFest");','focaliza("craActivFrm.indFest");','focaliza("craActivFrm.indFest");','focaliza("craActivFrm.indFest");'],[7,'focaliza("craActivFrm.indLabo");','focaliza("craActivFrm.indLabo");','focaliza("craActivFrm.indLabo");','focaliza("craActivFrm.indLabo");','focaliza("craActivFrm.indLabo");','focaliza("craActivFrm.indLabo");'],[8,'','focaliza("craActivFrm.Descripcion");','focaliza("craActivFrm.Descripcion");','','focaliza("craActivFrm.Descripcion");','focaliza("craActivFrm.Descripcion");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
craActivLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var craActivTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function craActivInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('craActivFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('craActivFrm.accion')){
		case "query": craActivQueryInitComponents(); break;
		case "view": craActivViewInitComponents(); break;
		case "create": craActivCreateInitComponents(); break;
		case "update": craActivUpdateInitComponents(); break;
		case "remove": craActivRemoveInitComponents(); break;
		case "lov": craActivLovInitComponents(); break;
	}
	//alert('accion :' + get('craActivFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('craActivFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('craActiv')) craActivCmdRequery();
}

function craActivQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	focusFirstField('craActivFrm', true);	
}

function craActivViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('craActivFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('craActivFrm', true);
}

function craActivCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('craActivFrm.codActi','S', GestionarMensaje('CraActiv.codActi.requiered.message'));
	
	setMV('craActivFrm.indEbel','S', GestionarMensaje('CraActiv.indEbel.requiered.message'));
	
	setMV('craActivFrm.Descripcion','S', GestionarMensaje('CraActiv.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('craActivFrm', true);
}

function craActivUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('craActivFrm.origen') == "pagina"){
		loadLocalizationWidget('craActivFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		craActivTmpUpdateValues = craActivBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('craActivFrm.codActi','S', GestionarMensaje('CraActiv.codActi.requiered.message'));
		setMV('craActivFrm.indEbel','S', GestionarMensaje('CraActiv.indEbel.requiered.message'));
		setMV('craActivFrm.Descripcion','S', GestionarMensaje('CraActiv.Descripcion.requiered.message'));
		
			focusFirstFieldModify('craActivFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		focusFirstField('craActivFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('craActivFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function craActivRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	craActivList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('craActivFrm', true);
}

function craActivLovInitComponents(){
	craActivLovReturnParameters = window.dialogArguments;
	
	focusFirstField('craActivFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad










//Función que permite cargar los datos de un elemento de lov seleccionado
function craActivSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('craActivFrm.' + campo, id);
	set('craActivFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function craActivLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	craActivLovReturnParameters.id = '';
	craActivLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function craActivLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(craActivList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = craActivList.codSeleccionados();
	var descripcion = craActivList.extraeDato(
		craActivList.codSeleccionados()[0], craActivChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	craActivLovReturnParameters.id = codigo;
	craActivLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function craActivCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('craActivFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('craActivFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "craActivList", "CraActivConectorTransactionQuery", 
		"result_ROWSET", parametros, "craActivPostQueryActions(datos);"]], "", "");	
}

function craActivCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('craActivFrm.lastQueryToSession'));
	var i =0;
	set('craActivFrm.codActi', paramsRequery.ij(i++));
	
	set('craActivFrm.numDiasDesp', paramsRequery.ij(i++));
	
	set('craActivFrm.numCampAnte', paramsRequery.ij(i++));
	
	set('craActivFrm.indEbel', paramsRequery.ij(i++));
	
	set('craActivFrm.indFest', paramsRequery.ij(i++));
	
	set('craActivFrm.indLabo', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	craActivPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	craActivCmdQuery(craActivPageCount);
}

function craActivFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	craActivPageCount = 1;
	craActivCmdQuery(craActivPageCount);
}

function craActivPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != craActivLastQuery){
		craActivFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	craActivPageCount--;
	craActivCmdQuery(craActivPageCount);
}

function craActivNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != craActivLastQuery){
		craActivFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	craActivPageCount++;
	craActivCmdQuery(craActivPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function craActivPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('craActivListLayer', 'O');
		visibilidad('craActivListButtonsLayer', 'O');
		if(get('craActivFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	craActivLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:craActivViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, craActivChoiceColumn) + "</A>",
			i, craActivChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	craActivList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	craActivTimeStamps = datosTmp.filtrar([7],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		craActivMorePagesFlag = true;
		craActivList.eliminar(mmgPageSize, 1);
	}else{
		craActivMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('craActivFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('craActivListLayer', 'V');
	visibilidad('craActivListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('craActivList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	craActivList.display();
	
	//Actualizamos el estado de los botones 
	if(craActivMorePagesFlag){
		set_estado_botonera('craActivPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('craActivPaginationButtonBar',
			3,"inactivo");
	}
	if(craActivPageCount > 1){
		set_estado_botonera('craActivPaginationButtonBar',
			2,"activo");
		set_estado_botonera('craActivPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('craActivPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('craActivPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function craActivUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(craActivList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('craActivFrm.idSelection', craActivList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('craActivFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = craActivList.codSeleccionados()[0];
		parametros["previousAction"] = get('craActivFrm.accion');
		parametros["accion"] = get('craActivFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CraActivLPStartUp', get('craActivFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) craActivCmdRequery();
	}
}

function craActivRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(craActivList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = craActivList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('craActivFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(craActivList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += craActivTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('craActivFrm.timestamp', timestamps);


	craActivFrm.oculto='S';
	envia('craActivFrm');
	craActivFrm.oculto='N';
}

function craActivViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(craActivList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	craActivViewDetail(craActivList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function craActivViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('craActivFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CraActivLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	
	
	
	setDefaultLanguageValue('craActivFrm', 
		'Descripcion', 1,
		get('craActivFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('craActivFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	if(!hasDefaultLanguageValue('craActivFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('CraActiv.Descripcion.requiered.message'));
		focaliza('craActivFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		craActivFrm.oculto='S';
		envia('craActivFrm');
		craActivFrm.oculto='N';
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
	craActivRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('craActivFrm.accion');
	var origenTmp = get('craActivFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(craActivBuildUpdateRecordString() != craActivTmpUpdateValues){
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
	document.all.craActivListLayer.style.display='none';
	document.all.craActivListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.craActivListLayer.style.display='';
	document.all.craActivListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCraActivCodActi = get('craActivFrm.codActi').toString();
	jsCraActivNumDiasDesp = get('craActivFrm.numDiasDesp').toString();
	jsCraActivNumCampAnte = get('craActivFrm.numCampAnte').toString();
	jsCraActivIndEbel = get('craActivFrm.indEbel').toString();
	jsCraActivIndFest = get('craActivFrm.indFest').toString();
	jsCraActivIndLabo = get('craActivFrm.indLabo').toString();
	
	
	var parametros = "";
	parametros += jsCraActivCodActi + "|";
	parametros += jsCraActivNumDiasDesp + "|";
	parametros += jsCraActivNumCampAnte + "|";
	parametros += jsCraActivIndEbel + "|";
	parametros += jsCraActivIndFest + "|";
	parametros += jsCraActivIndLabo + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function craActivBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCraActivCodActi + "|";
	parametros += jsCraActivNumDiasDesp + "|";
	parametros += jsCraActivNumCampAnte + "|";
	parametros += jsCraActivIndEbel + "|";
	parametros += jsCraActivIndFest + "|";
	parametros += jsCraActivIndLabo + "|";
	parametros += jsCraActivDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('craActivFrm.accion'), 
		get('craActivFrm.origen'));
	
	jsCraActivId = get('craActivFrm.id').toString();
	jsCraActivCodActi = get('craActivFrm.codActi').toString();
	jsCraActivNumDiasDesp = get('craActivFrm.numDiasDesp').toString();
	jsCraActivNumCampAnte = get('craActivFrm.numCampAnte').toString();
	jsCraActivIndEbel = get('craActivFrm.indEbel').toString();
	jsCraActivIndFest = get('craActivFrm.indFest').toString();
	jsCraActivIndLabo = get('craActivFrm.indLabo').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsCraActivDescripcion = buildLocalizedString('craActivFrm', 1);
	}else{
		jsCraActivDescripcion = get('craActivFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('craActivFrm.accion'), 
		get('craActivFrm.origen'));


	set('craActivFrm.id', jsCraActivId);
	set('craActivFrm.codActi', jsCraActivCodActi);
	set('craActivFrm.numDiasDesp', jsCraActivNumDiasDesp);
	set('craActivFrm.numCampAnte', jsCraActivNumCampAnte);
	set('craActivFrm.indEbel', jsCraActivIndEbel);
	set('craActivFrm.indFest', jsCraActivIndFest);
	set('craActivFrm.indLabo', jsCraActivIndLabo);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('craActivFrm', 1,  jsCraActivDescripcion)
		loadLocalizationWidget('craActivFrm', 'Descripcion', 1);
	}else{
		set('craActivFrm.Descripcion', jsCraActivDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCraActivCodActi = '';
	jsCraActivNumDiasDesp = '';
	jsCraActivNumCampAnte = '';
	jsCraActivIndEbel = '';
	jsCraActivIndFest = '';
	jsCraActivIndLabo = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('craActivFrm.errCodigo', errorCode);
	set('craActivFrm.errDescripcion', description);
	set('craActivFrm.errSeverity', severity);
	fMostrarMensajeError();
}

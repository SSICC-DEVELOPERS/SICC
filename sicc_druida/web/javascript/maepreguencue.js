

/*
    INDRA/CAR/mmg
    $Id: maepreguencue.js,v 1.1 2009/12/03 19:01:38 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaePreguEncueId = "";
var jsMaePreguEncueCodPreg = "";
var jsMaePreguEncueValPesoPreg = "";
var jsMaePreguEncueEnseOidEncu = "";
var jsMaePreguEncueDescripcion = "";

//Variables de paginacion, 
var maePreguEncuePageCount = 1;

//Varible de columna que representa el campo de choice
var maePreguEncueChoiceColumn = 3;

//Flag de siguiente pagina;
var maePreguEncueMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maePreguEncueTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 189;
var sizeFormView = 175;
var sizeFormUpdate = 175;

//Ultima busqueda realizada
var maePreguEncueLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("maePreguEncueFrm.codPreg");','focaliza("maePreguEncueFrm.codPreg");','focaliza("maePreguEncueFrm.codPreg");','focaliza("maePreguEncueFrm.codPreg");','focaliza("maePreguEncueFrm.codPreg");','focaliza("maePreguEncueFrm.codPreg");'],[3,'focaliza("maePreguEncueFrm.valPesoPreg");','focaliza("maePreguEncueFrm.valPesoPreg");','focaliza("maePreguEncueFrm.valPesoPreg");','focaliza("maePreguEncueFrm.valPesoPreg");','focaliza("maePreguEncueFrm.valPesoPreg");','focaliza("maePreguEncueFrm.valPesoPreg");'],[4,'focalizaComboDependence("maePreguEncue","enseOidEncu", false);','focalizaComboDependence("maePreguEncue","enseOidEncu", false);','focalizaComboDependence("maePreguEncue","enseOidEncu", false);','focalizaComboDependence("maePreguEncue","enseOidEncu", true);','focalizaComboDependence("maePreguEncue","enseOidEncu", true);','focalizaComboDependence("maePreguEncue","enseOidEncu", true);'],[5,'focaliza("maePreguEncueFrm.Descripcion");','focaliza("maePreguEncueFrm.Descripcion");','focaliza("maePreguEncueFrm.Descripcion");','focaliza("maePreguEncueFrm.Descripcion");','focaliza("maePreguEncueFrm.Descripcion");','focaliza("maePreguEncueFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("maePreguEncueFrm.valPesoPreg");','focaliza("maePreguEncueFrm.valPesoPreg");','focaliza("maePreguEncueFrm.valPesoPreg");','focaliza("maePreguEncueFrm.valPesoPreg");','focaliza("maePreguEncueFrm.valPesoPreg");','focaliza("maePreguEncueFrm.valPesoPreg");'],[4,'focalizaComboDependence("maePreguEncue","enseOidEncu", false);','focalizaComboDependence("maePreguEncue","enseOidEncu", false);','focalizaComboDependence("maePreguEncue","enseOidEncu", false);','focalizaComboDependence("maePreguEncue","enseOidEncu", true);','focalizaComboDependence("maePreguEncue","enseOidEncu", true);','focalizaComboDependence("maePreguEncue","enseOidEncu", true);'],[5,'focaliza("maePreguEncueFrm.Descripcion");','focaliza("maePreguEncueFrm.Descripcion");','focaliza("maePreguEncueFrm.Descripcion");','focaliza("maePreguEncueFrm.Descripcion");','focaliza("maePreguEncueFrm.Descripcion");','focaliza("maePreguEncueFrm.Descripcion");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var enseOidEncuDependeceMap = new Vector();
enseOidEncuDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
enseOidEncuDependeceMap.agregar(['enseOidEncu', padresTmp, '', 'MaeEncueNseView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maePreguEncueLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maePreguEncueTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maePreguEncueInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maePreguEncueFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maePreguEncueFrm.accion')){
		case "query": maePreguEncueQueryInitComponents(); break;
		case "view": maePreguEncueViewInitComponents(); break;
		case "create": maePreguEncueCreateInitComponents(); break;
		case "update": maePreguEncueUpdateInitComponents(); break;
		case "remove": maePreguEncueRemoveInitComponents(); break;
		case "lov": maePreguEncueLovInitComponents(); break;
	}
	//alert('accion :' + get('maePreguEncueFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maePreguEncueFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maePreguEncue')) maePreguEncueCmdRequery();
}

function maePreguEncueQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	focusFirstField('maePreguEncueFrm', true);	
}

function maePreguEncueViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('maePreguEncueFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('maePreguEncueFrm', true);
}

function maePreguEncueCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maePreguEncueFrm.codPreg','S', GestionarMensaje('MaePreguEncue.codPreg.requiered.message'));
	
	setMV('maePreguEncueFrm.valPesoPreg','S', GestionarMensaje('MaePreguEncue.valPesoPreg.requiered.message'));
	
	setMV('maePreguEncueFrm.enseOidEncu','S', GestionarMensaje('MaePreguEncue.enseOidEncu.requiered.message'));
	
	setMV('maePreguEncueFrm.Descripcion','S', GestionarMensaje('MaePreguEncue.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maePreguEncueFrm', true);
}

function maePreguEncueUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maePreguEncueFrm.origen') == "pagina"){
		loadLocalizationWidget('maePreguEncueFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		maePreguEncueTmpUpdateValues = maePreguEncueBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maePreguEncueFrm.codPreg','S', GestionarMensaje('MaePreguEncue.codPreg.requiered.message'));
		setMV('maePreguEncueFrm.valPesoPreg','S', GestionarMensaje('MaePreguEncue.valPesoPreg.requiered.message'));
		setMV('maePreguEncueFrm.enseOidEncu','S', GestionarMensaje('MaePreguEncue.enseOidEncu.requiered.message'));
		setMV('maePreguEncueFrm.Descripcion','S', GestionarMensaje('MaePreguEncue.Descripcion.requiered.message'));
		
			focusFirstFieldModify('maePreguEncueFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		focusFirstField('maePreguEncueFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maePreguEncueFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maePreguEncueRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maePreguEncueList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maePreguEncueFrm', true);
}

function maePreguEncueLovInitComponents(){
	maePreguEncueLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maePreguEncueFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function maePreguEncueSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maePreguEncueFrm.' + campo, id);
	set('maePreguEncueFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maePreguEncueLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maePreguEncueLovReturnParameters.id = '';
	maePreguEncueLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maePreguEncueLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maePreguEncueList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maePreguEncueList.codSeleccionados();
	var descripcion = maePreguEncueList.extraeDato(
		maePreguEncueList.codSeleccionados()[0], maePreguEncueChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maePreguEncueLovReturnParameters.id = codigo;
	maePreguEncueLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maePreguEncueCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maePreguEncueFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maePreguEncueFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maePreguEncueList", "MaePreguEncueConectorTransactionQuery", 
		"result_ROWSET", parametros, "maePreguEncuePostQueryActions(datos);"]], "", "");	
}

function maePreguEncueCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maePreguEncueFrm.lastQueryToSession'));
	var i =0;
	set('maePreguEncueFrm.codPreg', paramsRequery.ij(i++));
	
	set('maePreguEncueFrm.valPesoPreg', paramsRequery.ij(i++));
	
	set('maePreguEncueFrm.enseOidEncu', [paramsRequery.ij(i++)]);
	
	set('maePreguEncueFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maePreguEncuePageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maePreguEncueCmdQuery(maePreguEncuePageCount);
}

function maePreguEncueFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maePreguEncuePageCount = 1;
	maePreguEncueCmdQuery(maePreguEncuePageCount);
}

function maePreguEncuePreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maePreguEncueLastQuery){
		maePreguEncueFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maePreguEncuePageCount--;
	maePreguEncueCmdQuery(maePreguEncuePageCount);
}

function maePreguEncueNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maePreguEncueLastQuery){
		maePreguEncueFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maePreguEncuePageCount++;
	maePreguEncueCmdQuery(maePreguEncuePageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maePreguEncuePostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maePreguEncueListLayer', 'O');
		visibilidad('maePreguEncueListButtonsLayer', 'O');
		if(get('maePreguEncueFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maePreguEncueLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maePreguEncueViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maePreguEncueChoiceColumn) + "</A>",
			i, maePreguEncueChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maePreguEncueList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maePreguEncueTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maePreguEncueMorePagesFlag = true;
		maePreguEncueList.eliminar(mmgPageSize, 1);
	}else{
		maePreguEncueMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maePreguEncueFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maePreguEncueListLayer', 'V');
	visibilidad('maePreguEncueListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maePreguEncueList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maePreguEncueList.display();
	
	//Actualizamos el estado de los botones 
	if(maePreguEncueMorePagesFlag){
		set_estado_botonera('maePreguEncuePaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maePreguEncuePaginationButtonBar',
			3,"inactivo");
	}
	if(maePreguEncuePageCount > 1){
		set_estado_botonera('maePreguEncuePaginationButtonBar',
			2,"activo");
		set_estado_botonera('maePreguEncuePaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maePreguEncuePaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maePreguEncuePaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maePreguEncueUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maePreguEncueList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maePreguEncueFrm.idSelection', maePreguEncueList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maePreguEncueFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maePreguEncueList.codSeleccionados()[0];
		parametros["previousAction"] = get('maePreguEncueFrm.accion');
		parametros["accion"] = get('maePreguEncueFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaePreguEncueLPStartUp', get('maePreguEncueFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maePreguEncueCmdRequery();
	}
}

function maePreguEncueRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maePreguEncueList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maePreguEncueList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maePreguEncueFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maePreguEncueList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maePreguEncueTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maePreguEncueFrm.timestamp', timestamps);


	maePreguEncueFrm.oculto='S';
	envia('maePreguEncueFrm');
	maePreguEncueFrm.oculto='N';
}

function maePreguEncueViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maePreguEncueList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maePreguEncueViewDetail(maePreguEncueList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maePreguEncueViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maePreguEncueFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaePreguEncueLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	setDefaultLanguageValue('maePreguEncueFrm', 
		'Descripcion', 1,
		get('maePreguEncueFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maePreguEncueFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	if(!hasDefaultLanguageValue('maePreguEncueFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaePreguEncue.Descripcion.requiered.message'));
		focaliza('maePreguEncueFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		maePreguEncueFrm.oculto='S';
		envia('maePreguEncueFrm');
		maePreguEncueFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maePreguEncueFrm.enseOidEncu').toString() == ''){
		set('maePreguEncueFrm.enseOidEncu', []);
		mmgResetCombosOnCascade('enseOidEncu', 'enseOidEncu', 'maePreguEncue');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maePreguEncueRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maePreguEncueFrm.accion');
	var origenTmp = get('maePreguEncueFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maePreguEncueBuildUpdateRecordString() != maePreguEncueTmpUpdateValues){
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
	document.all.maePreguEncueListLayer.style.display='none';
	document.all.maePreguEncueListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maePreguEncueListLayer.style.display='';
	document.all.maePreguEncueListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaePreguEncueCodPreg = get('maePreguEncueFrm.codPreg').toString();
	jsMaePreguEncueValPesoPreg = get('maePreguEncueFrm.valPesoPreg').toString();
	jsMaePreguEncueEnseOidEncu = get('maePreguEncueFrm.enseOidEncu')[0];
	jsMaePreguEncueDescripcion = get('maePreguEncueFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsMaePreguEncueCodPreg + "|";
	parametros += jsMaePreguEncueValPesoPreg + "|";
	parametros += jsMaePreguEncueEnseOidEncu + "|";
	parametros += jsMaePreguEncueDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maePreguEncueBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaePreguEncueCodPreg + "|";
	parametros += jsMaePreguEncueValPesoPreg + "|";
	parametros += jsMaePreguEncueEnseOidEncu + "|";
	parametros += jsMaePreguEncueDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maePreguEncueFrm.accion'), 
		get('maePreguEncueFrm.origen'));
	
	jsMaePreguEncueId = get('maePreguEncueFrm.id').toString();
	jsMaePreguEncueCodPreg = get('maePreguEncueFrm.codPreg').toString();
	jsMaePreguEncueValPesoPreg = get('maePreguEncueFrm.valPesoPreg').toString();
	jsMaePreguEncueEnseOidEncu = get('maePreguEncueFrm.enseOidEncu')[0];
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaePreguEncueDescripcion = buildLocalizedString('maePreguEncueFrm', 1);
	}else{
		jsMaePreguEncueDescripcion = get('maePreguEncueFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maePreguEncueFrm.accion'), 
		get('maePreguEncueFrm.origen'));


	set('maePreguEncueFrm.id', jsMaePreguEncueId);
	set('maePreguEncueFrm.codPreg', jsMaePreguEncueCodPreg);
	set('maePreguEncueFrm.valPesoPreg', jsMaePreguEncueValPesoPreg);
	set('maePreguEncueFrm.enseOidEncu', [jsMaePreguEncueEnseOidEncu]);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maePreguEncueFrm', 1,  jsMaePreguEncueDescripcion)
		loadLocalizationWidget('maePreguEncueFrm', 'Descripcion', 1);
	}else{
		set('maePreguEncueFrm.Descripcion', jsMaePreguEncueDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaePreguEncueCodPreg = '';
	jsMaePreguEncueValPesoPreg = '';
	jsMaePreguEncueEnseOidEncu = '';
	jsMaePreguEncueDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maePreguEncueFrm.errCodigo', errorCode);
	set('maePreguEncueFrm.errDescripcion', description);
	set('maePreguEncueFrm.errSeverity', severity);
	fMostrarMensajeError();
}

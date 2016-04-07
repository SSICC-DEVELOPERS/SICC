

/*
    INDRA/CAR/mmg
    $Id: maeestatclien.js,v 1.1 2009/12/03 19:01:43 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeEstatClienId = "";
var jsMaeEstatClienTescOidTipoEsta = "";
var jsMaeEstatClienCodEstaClie = "";
var jsMaeEstatClienDescripcion = "";
var jsMaeEstatClienEstaOidEstaClie = "";

//Variables de paginacion, 
var maeEstatClienPageCount = 1;

//Varible de columna que representa el campo de choice
var maeEstatClienChoiceColumn = 1;

//Flag de siguiente pagina;
var maeEstatClienMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeEstatClienTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var maeEstatClienLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("maeEstatClien","tescOidTipoEsta", false);','focalizaComboDependence("maeEstatClien","tescOidTipoEsta", false);','focalizaComboDependence("maeEstatClien","tescOidTipoEsta", false);','focalizaComboDependence("maeEstatClien","tescOidTipoEsta", true);','focalizaComboDependence("maeEstatClien","tescOidTipoEsta", true);','focalizaComboDependence("maeEstatClien","tescOidTipoEsta", true);'],[3,'focaliza("maeEstatClienFrm.codEstaClie");','focaliza("maeEstatClienFrm.codEstaClie");','focaliza("maeEstatClienFrm.codEstaClie");','focaliza("maeEstatClienFrm.codEstaClie");','focaliza("maeEstatClienFrm.codEstaClie");','focaliza("maeEstatClienFrm.codEstaClie");'],[4,'focaliza("maeEstatClienFrm.Descripcion");','focaliza("maeEstatClienFrm.Descripcion");','focaliza("maeEstatClienFrm.Descripcion");','focaliza("maeEstatClienFrm.Descripcion");','focaliza("maeEstatClienFrm.Descripcion");','focaliza("maeEstatClienFrm.Descripcion");'],[5,'focalizaComboDependence("maeEstatClien","estaOidEstaClie", false);','focalizaComboDependence("maeEstatClien","estaOidEstaClie", false);','focalizaComboDependence("maeEstatClien","estaOidEstaClie", false);','focalizaComboDependence("maeEstatClien","estaOidEstaClie", true);','focalizaComboDependence("maeEstatClien","estaOidEstaClie", true);','focalizaComboDependence("maeEstatClien","estaOidEstaClie", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'focaliza("maeEstatClienFrm.Descripcion");','focaliza("maeEstatClienFrm.Descripcion");','focaliza("maeEstatClienFrm.Descripcion");','focaliza("maeEstatClienFrm.Descripcion");','focaliza("maeEstatClienFrm.Descripcion");','focaliza("maeEstatClienFrm.Descripcion");'],[5,'focalizaComboDependence("maeEstatClien","estaOidEstaClie", false);','focalizaComboDependence("maeEstatClien","estaOidEstaClie", false);','focalizaComboDependence("maeEstatClien","estaOidEstaClie", false);','focalizaComboDependence("maeEstatClien","estaOidEstaClie", true);','focalizaComboDependence("maeEstatClien","estaOidEstaClie", true);','focalizaComboDependence("maeEstatClien","estaOidEstaClie", true);']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var tescOidTipoEstaDependeceMap = new Vector();
tescOidTipoEstaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tescOidTipoEstaDependeceMap.agregar(['tescOidTipoEsta', padresTmp, '', 'MaeTipoEstatClienView']);
var estaOidEstaClieDependeceMap = new Vector();
estaOidEstaClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
estaOidEstaClieDependeceMap.agregar(['estaOidEstaClie', padresTmp, '', 'MaeEstatClienView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeEstatClienLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeEstatClienTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeEstatClienInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeEstatClienFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeEstatClienFrm.accion')){
		case "query": maeEstatClienQueryInitComponents(); break;
		case "view": maeEstatClienViewInitComponents(); break;
		case "create": maeEstatClienCreateInitComponents(); break;
		case "update": maeEstatClienUpdateInitComponents(); break;
		case "remove": maeEstatClienRemoveInitComponents(); break;
		case "lov": maeEstatClienLovInitComponents(); break;
	}
	//alert('accion :' + get('maeEstatClienFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeEstatClienFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeEstatClien')) maeEstatClienCmdRequery();
}

function maeEstatClienQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	focusFirstField('maeEstatClienFrm', true);	
}

function maeEstatClienViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('maeEstatClienFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('maeEstatClienFrm', true);
}

function maeEstatClienCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeEstatClienFrm.tescOidTipoEsta','S', GestionarMensaje('MaeEstatClien.tescOidTipoEsta.requiered.message'));
	
	setMV('maeEstatClienFrm.codEstaClie','S', GestionarMensaje('MaeEstatClien.codEstaClie.requiered.message'));
	
	setMV('maeEstatClienFrm.Descripcion','S', GestionarMensaje('MaeEstatClien.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeEstatClienFrm', true);
}

function maeEstatClienUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeEstatClienFrm.origen') == "pagina"){
		loadLocalizationWidget('maeEstatClienFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		maeEstatClienTmpUpdateValues = maeEstatClienBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeEstatClienFrm.tescOidTipoEsta','S', GestionarMensaje('MaeEstatClien.tescOidTipoEsta.requiered.message'));
		setMV('maeEstatClienFrm.codEstaClie','S', GestionarMensaje('MaeEstatClien.codEstaClie.requiered.message'));
		setMV('maeEstatClienFrm.Descripcion','S', GestionarMensaje('MaeEstatClien.Descripcion.requiered.message'));
		
			focusFirstFieldModify('maeEstatClienFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		focusFirstField('maeEstatClienFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeEstatClienFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeEstatClienRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeEstatClienList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeEstatClienFrm', true);
}

function maeEstatClienLovInitComponents(){
	maeEstatClienLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeEstatClienFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function maeEstatClienSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeEstatClienFrm.' + campo, id);
	set('maeEstatClienFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeEstatClienLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeEstatClienLovReturnParameters.id = '';
	maeEstatClienLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeEstatClienLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeEstatClienList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeEstatClienList.codSeleccionados();
	var descripcion = maeEstatClienList.extraeDato(
		maeEstatClienList.codSeleccionados()[0], maeEstatClienChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeEstatClienLovReturnParameters.id = codigo;
	maeEstatClienLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeEstatClienCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeEstatClienFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeEstatClienFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeEstatClienList", "MaeEstatClienConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeEstatClienPostQueryActions(datos);"]], "", "");	
}

function maeEstatClienCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeEstatClienFrm.lastQueryToSession'));
	var i =0;
	set('maeEstatClienFrm.tescOidTipoEsta', [paramsRequery.ij(i++)]);
	
	set('maeEstatClienFrm.codEstaClie', paramsRequery.ij(i++));
	
	set('maeEstatClienFrm.Descripcion', paramsRequery.ij(i++));
	
	set('maeEstatClienFrm.estaOidEstaClie', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	maeEstatClienPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeEstatClienCmdQuery(maeEstatClienPageCount);
}

function maeEstatClienFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeEstatClienPageCount = 1;
	maeEstatClienCmdQuery(maeEstatClienPageCount);
}

function maeEstatClienPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeEstatClienLastQuery){
		maeEstatClienFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeEstatClienPageCount--;
	maeEstatClienCmdQuery(maeEstatClienPageCount);
}

function maeEstatClienNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeEstatClienLastQuery){
		maeEstatClienFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeEstatClienPageCount++;
	maeEstatClienCmdQuery(maeEstatClienPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeEstatClienPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeEstatClienListLayer', 'O');
		visibilidad('maeEstatClienListButtonsLayer', 'O');
		if(get('maeEstatClienFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeEstatClienLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeEstatClienViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeEstatClienChoiceColumn) + "</A>",
			i, maeEstatClienChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeEstatClienList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeEstatClienTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeEstatClienMorePagesFlag = true;
		maeEstatClienList.eliminar(mmgPageSize, 1);
	}else{
		maeEstatClienMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeEstatClienFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeEstatClienListLayer', 'V');
	visibilidad('maeEstatClienListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeEstatClienList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeEstatClienList.display();
	
	//Actualizamos el estado de los botones 
	if(maeEstatClienMorePagesFlag){
		set_estado_botonera('maeEstatClienPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeEstatClienPaginationButtonBar',
			3,"inactivo");
	}
	if(maeEstatClienPageCount > 1){
		set_estado_botonera('maeEstatClienPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeEstatClienPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeEstatClienPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeEstatClienPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeEstatClienUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeEstatClienList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeEstatClienFrm.idSelection', maeEstatClienList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeEstatClienFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeEstatClienList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeEstatClienFrm.accion');
		parametros["accion"] = get('maeEstatClienFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeEstatClienLPStartUp', get('maeEstatClienFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeEstatClienCmdRequery();
	}
}

function maeEstatClienRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeEstatClienList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeEstatClienList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeEstatClienFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeEstatClienList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeEstatClienTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeEstatClienFrm.timestamp', timestamps);


	maeEstatClienFrm.oculto='S';
	envia('maeEstatClienFrm');
	maeEstatClienFrm.oculto='N';
}

function maeEstatClienViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeEstatClienList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeEstatClienViewDetail(maeEstatClienList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeEstatClienViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeEstatClienFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeEstatClienLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('maeEstatClienFrm', 
		'Descripcion', 1,
		get('maeEstatClienFrm.Descripcion'));	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeEstatClienFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('maeEstatClienFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeEstatClien.Descripcion.requiered.message'));
		focaliza('maeEstatClienFrm.Descripcion');
		return;
	}	
	
	
		
	
	if(validacion){
		maeEstatClienFrm.oculto='S';
		envia('maeEstatClienFrm');
		maeEstatClienFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeEstatClienFrm.tescOidTipoEsta').toString() == ''){
		set('maeEstatClienFrm.tescOidTipoEsta', []);
		mmgResetCombosOnCascade('tescOidTipoEsta', 'tescOidTipoEsta', 'maeEstatClien');
		
	}
	if(get('maeEstatClienFrm.estaOidEstaClie').toString() == ''){
		set('maeEstatClienFrm.estaOidEstaClie', []);
		mmgResetCombosOnCascade('estaOidEstaClie', 'estaOidEstaClie', 'maeEstatClien');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeEstatClienRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeEstatClienFrm.accion');
	var origenTmp = get('maeEstatClienFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeEstatClienBuildUpdateRecordString() != maeEstatClienTmpUpdateValues){
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
	document.all.maeEstatClienListLayer.style.display='none';
	document.all.maeEstatClienListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeEstatClienListLayer.style.display='';
	document.all.maeEstatClienListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeEstatClienTescOidTipoEsta = get('maeEstatClienFrm.tescOidTipoEsta')[0];
	jsMaeEstatClienCodEstaClie = get('maeEstatClienFrm.codEstaClie').toString();
	jsMaeEstatClienDescripcion = get('maeEstatClienFrm.Descripcion').toString();
	jsMaeEstatClienEstaOidEstaClie = get('maeEstatClienFrm.estaOidEstaClie')[0];
	
	
	var parametros = "";
	parametros += jsMaeEstatClienTescOidTipoEsta + "|";
	parametros += jsMaeEstatClienCodEstaClie + "|";
	parametros += jsMaeEstatClienDescripcion + "|";
	parametros += jsMaeEstatClienEstaOidEstaClie + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeEstatClienBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeEstatClienTescOidTipoEsta + "|";
	parametros += jsMaeEstatClienCodEstaClie + "|";
	parametros += jsMaeEstatClienDescripcion + "|";
	parametros += jsMaeEstatClienEstaOidEstaClie + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeEstatClienFrm.accion'), 
		get('maeEstatClienFrm.origen'));
	
	jsMaeEstatClienId = get('maeEstatClienFrm.id').toString();
	jsMaeEstatClienTescOidTipoEsta = get('maeEstatClienFrm.tescOidTipoEsta')[0];
	jsMaeEstatClienCodEstaClie = get('maeEstatClienFrm.codEstaClie').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeEstatClienDescripcion = buildLocalizedString('maeEstatClienFrm', 1);
	}else{
		jsMaeEstatClienDescripcion = get('maeEstatClienFrm.Descripcion');
	}
	jsMaeEstatClienEstaOidEstaClie = get('maeEstatClienFrm.estaOidEstaClie')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeEstatClienFrm.accion'), 
		get('maeEstatClienFrm.origen'));


	set('maeEstatClienFrm.id', jsMaeEstatClienId);
	set('maeEstatClienFrm.tescOidTipoEsta', [jsMaeEstatClienTescOidTipoEsta]);
	set('maeEstatClienFrm.codEstaClie', jsMaeEstatClienCodEstaClie);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeEstatClienFrm', 1,  jsMaeEstatClienDescripcion)
		loadLocalizationWidget('maeEstatClienFrm', 'Descripcion', 1);
	}else{
		set('maeEstatClienFrm.Descripcion', jsMaeEstatClienDescripcion);		
	}
	set('maeEstatClienFrm.estaOidEstaClie', [jsMaeEstatClienEstaOidEstaClie]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeEstatClienTescOidTipoEsta = '';
	jsMaeEstatClienCodEstaClie = '';
	jsMaeEstatClienDescripcion = '';
	jsMaeEstatClienEstaOidEstaClie = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeEstatClienFrm.errCodigo', errorCode);
	set('maeEstatClienFrm.errDescripcion', description);
	set('maeEstatClienFrm.errSeverity', severity);
	fMostrarMensajeError();
}

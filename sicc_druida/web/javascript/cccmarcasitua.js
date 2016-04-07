

/*
    INDRA/CAR/mmg
    $Id: cccmarcasitua.js,v 1.1 2009/12/03 19:01:42 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCccMarcaSituaId = "";
var jsCccMarcaSituaPaisOidPais = "";
var jsCccMarcaSituaCodMarcSitu = "";
var jsCccMarcaSituaDescripcion = "";
var jsCccMarcaSituaIndCuenCast = "";
var jsCccMarcaSituaValObse = "";

//Variables de paginacion, 
var cccMarcaSituaPageCount = 1;

//Varible de columna que representa el campo de choice
var cccMarcaSituaChoiceColumn = 1;

//Flag de siguiente pagina;
var cccMarcaSituaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cccMarcaSituaTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 149;
var sizeFormUpdate = 149;

//Ultima busqueda realizada
var cccMarcaSituaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focaliza("cccMarcaSituaFrm.codMarcSitu");','focaliza("cccMarcaSituaFrm.codMarcSitu");','focaliza("cccMarcaSituaFrm.codMarcSitu");','focaliza("cccMarcaSituaFrm.codMarcSitu");','focaliza("cccMarcaSituaFrm.codMarcSitu");','focaliza("cccMarcaSituaFrm.codMarcSitu");'],[4,'focaliza("cccMarcaSituaFrm.Descripcion");','focaliza("cccMarcaSituaFrm.Descripcion");','focaliza("cccMarcaSituaFrm.Descripcion");','focaliza("cccMarcaSituaFrm.Descripcion");','focaliza("cccMarcaSituaFrm.Descripcion");','focaliza("cccMarcaSituaFrm.Descripcion");'],[5,'focaliza("cccMarcaSituaFrm.indCuenCast");','focaliza("cccMarcaSituaFrm.indCuenCast");','focaliza("cccMarcaSituaFrm.indCuenCast");','focaliza("cccMarcaSituaFrm.indCuenCast");','focaliza("cccMarcaSituaFrm.indCuenCast");','focaliza("cccMarcaSituaFrm.indCuenCast");'],[6,'','focaliza("cccMarcaSituaFrm.valObse");','focaliza("cccMarcaSituaFrm.valObse");','','focaliza("cccMarcaSituaFrm.valObse");','focaliza("cccMarcaSituaFrm.valObse");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'','','','','',''],[4,'focaliza("cccMarcaSituaFrm.Descripcion");','focaliza("cccMarcaSituaFrm.Descripcion");','focaliza("cccMarcaSituaFrm.Descripcion");','focaliza("cccMarcaSituaFrm.Descripcion");','focaliza("cccMarcaSituaFrm.Descripcion");','focaliza("cccMarcaSituaFrm.Descripcion");'],[5,'focaliza("cccMarcaSituaFrm.indCuenCast");','focaliza("cccMarcaSituaFrm.indCuenCast");','focaliza("cccMarcaSituaFrm.indCuenCast");','focaliza("cccMarcaSituaFrm.indCuenCast");','focaliza("cccMarcaSituaFrm.indCuenCast");','focaliza("cccMarcaSituaFrm.indCuenCast");'],[6,'','focaliza("cccMarcaSituaFrm.valObse");','focaliza("cccMarcaSituaFrm.valObse");','','focaliza("cccMarcaSituaFrm.valObse");','focaliza("cccMarcaSituaFrm.valObse");']]);

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
cccMarcaSituaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var cccMarcaSituaTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function cccMarcaSituaInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('cccMarcaSituaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('cccMarcaSituaFrm.accion')){
		case "query": cccMarcaSituaQueryInitComponents(); break;
		case "view": cccMarcaSituaViewInitComponents(); break;
		case "create": cccMarcaSituaCreateInitComponents(); break;
		case "update": cccMarcaSituaUpdateInitComponents(); break;
		case "remove": cccMarcaSituaRemoveInitComponents(); break;
		case "lov": cccMarcaSituaLovInitComponents(); break;
	}
	//alert('accion :' + get('cccMarcaSituaFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('cccMarcaSituaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cccMarcaSitua')) cccMarcaSituaCmdRequery();
}

function cccMarcaSituaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('cccMarcaSituaFrm', true);	
}

function cccMarcaSituaViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('cccMarcaSituaFrm', 'Descripcion', 1);
	
		
	//Establecemos el valor de los radiobuttons
		set('cccMarcaSituaFrm.indCuenCast', get('cccMarcaSituaFrm.indCuenCastCheckValue'));
		
	focusFirstField('cccMarcaSituaFrm', true);
}

function cccMarcaSituaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cccMarcaSituaFrm.codMarcSitu','S', GestionarMensaje('CccMarcaSitua.codMarcSitu.requiered.message'));
	
	setMV('cccMarcaSituaFrm.Descripcion','S', GestionarMensaje('CccMarcaSitua.Descripcion.requiered.message'));
	
	setMV('cccMarcaSituaFrm.indCuenCast','S', GestionarMensaje('CccMarcaSitua.indCuenCast.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('cccMarcaSituaFrm', true);
}

function cccMarcaSituaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('cccMarcaSituaFrm.origen') == "pagina"){
		loadLocalizationWidget('cccMarcaSituaFrm', 'Descripcion', 1);
		

		//Establecemos el valor de los radiobuttons
			set('cccMarcaSituaFrm.indCuenCast', get('cccMarcaSituaFrm.indCuenCastCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		cccMarcaSituaTmpUpdateValues = cccMarcaSituaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cccMarcaSituaFrm.codMarcSitu','S', GestionarMensaje('CccMarcaSitua.codMarcSitu.requiered.message'));
		setMV('cccMarcaSituaFrm.Descripcion','S', GestionarMensaje('CccMarcaSitua.Descripcion.requiered.message'));
		setMV('cccMarcaSituaFrm.indCuenCast','S', GestionarMensaje('CccMarcaSitua.indCuenCast.requiered.message'));
		
			focusFirstFieldModify('cccMarcaSituaFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('cccMarcaSituaFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('cccMarcaSituaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cccMarcaSituaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	cccMarcaSituaList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('cccMarcaSituaFrm', true);
}

function cccMarcaSituaLovInitComponents(){
	cccMarcaSituaLovReturnParameters = window.dialogArguments;
	
	focusFirstField('cccMarcaSituaFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad








//Función que permite cargar los datos de un elemento de lov seleccionado
function cccMarcaSituaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cccMarcaSituaFrm.' + campo, id);
	set('cccMarcaSituaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function cccMarcaSituaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cccMarcaSituaLovReturnParameters.id = '';
	cccMarcaSituaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cccMarcaSituaLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccMarcaSituaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cccMarcaSituaList.codSeleccionados();
	var descripcion = cccMarcaSituaList.extraeDato(
		cccMarcaSituaList.codSeleccionados()[0], cccMarcaSituaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cccMarcaSituaLovReturnParameters.id = codigo;
	cccMarcaSituaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function cccMarcaSituaCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cccMarcaSituaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('cccMarcaSituaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cccMarcaSituaList", "CccMarcaSituaConectorTransactionQuery", 
		"result_ROWSET", parametros, "cccMarcaSituaPostQueryActions(datos);"]], "", "");	
}

function cccMarcaSituaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cccMarcaSituaFrm.lastQueryToSession'));
	var i =0;
	set('cccMarcaSituaFrm.codMarcSitu', paramsRequery.ij(i++));
	
	set('cccMarcaSituaFrm.Descripcion', paramsRequery.ij(i++));
	
	set('cccMarcaSituaFrm.indCuenCast', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	cccMarcaSituaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cccMarcaSituaCmdQuery(cccMarcaSituaPageCount);
}

function cccMarcaSituaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cccMarcaSituaPageCount = 1;
	cccMarcaSituaCmdQuery(cccMarcaSituaPageCount);
}

function cccMarcaSituaPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cccMarcaSituaLastQuery){
		cccMarcaSituaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cccMarcaSituaPageCount--;
	cccMarcaSituaCmdQuery(cccMarcaSituaPageCount);
}

function cccMarcaSituaNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cccMarcaSituaLastQuery){
		cccMarcaSituaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cccMarcaSituaPageCount++;
	cccMarcaSituaCmdQuery(cccMarcaSituaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cccMarcaSituaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cccMarcaSituaListLayer', 'O');
		visibilidad('cccMarcaSituaListButtonsLayer', 'O');
		if(get('cccMarcaSituaFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	cccMarcaSituaLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 3)){
			case '1': datosTmp.ij2(GestionarMensaje('CccMarcaSitua.indCuenCast.1.value'), i, 3); break;
			case '0': datosTmp.ij2(GestionarMensaje('CccMarcaSitua.indCuenCast.0.value'), i, 3); break;
			default: datosTmp .ij2('', i, 3);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:cccMarcaSituaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cccMarcaSituaChoiceColumn) + "</A>",
			i, cccMarcaSituaChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cccMarcaSituaList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	cccMarcaSituaTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		cccMarcaSituaMorePagesFlag = true;
		cccMarcaSituaList.eliminar(mmgPageSize, 1);
	}else{
		cccMarcaSituaMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('cccMarcaSituaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cccMarcaSituaListLayer', 'V');
	visibilidad('cccMarcaSituaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cccMarcaSituaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cccMarcaSituaList.display();
	
	//Actualizamos el estado de los botones 
	if(cccMarcaSituaMorePagesFlag){
		set_estado_botonera('cccMarcaSituaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cccMarcaSituaPaginationButtonBar',
			3,"inactivo");
	}
	if(cccMarcaSituaPageCount > 1){
		set_estado_botonera('cccMarcaSituaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cccMarcaSituaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cccMarcaSituaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cccMarcaSituaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cccMarcaSituaUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccMarcaSituaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cccMarcaSituaFrm.idSelection', cccMarcaSituaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('cccMarcaSituaFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = cccMarcaSituaList.codSeleccionados()[0];
		parametros["previousAction"] = get('cccMarcaSituaFrm.accion');
		parametros["accion"] = get('cccMarcaSituaFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CccMarcaSituaLPStartUp', get('cccMarcaSituaFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) cccMarcaSituaCmdRequery();
	}
}

function cccMarcaSituaRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccMarcaSituaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cccMarcaSituaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cccMarcaSituaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cccMarcaSituaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cccMarcaSituaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cccMarcaSituaFrm.timestamp', timestamps);


	cccMarcaSituaFrm.oculto='S';
	envia('cccMarcaSituaFrm');
	cccMarcaSituaFrm.oculto='N';
}

function cccMarcaSituaViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccMarcaSituaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	cccMarcaSituaViewDetail(cccMarcaSituaList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function cccMarcaSituaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cccMarcaSituaFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CccMarcaSituaLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	// splatas - 20/07/2006 - DBLG500000869
	var observaciones = get("cccMarcaSituaFrm.valObse");
	set("cccMarcaSituaFrm.valObse", observaciones);
	
	
	
	setDefaultLanguageValue('cccMarcaSituaFrm', 
		'Descripcion', 1,
		get('cccMarcaSituaFrm.Descripcion'));	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('cccMarcaSituaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('cccMarcaSituaFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('CccMarcaSitua.Descripcion.requiered.message'));
		focaliza('cccMarcaSituaFrm.Descripcion');
		return;
	}	
	
	
	
		
	
	if(validacion){
		cccMarcaSituaFrm.oculto='S';
		envia('cccMarcaSituaFrm');
		cccMarcaSituaFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('cccMarcaSituaFrm.paisOidPais').toString() == ''){
		set('cccMarcaSituaFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'cccMarcaSitua');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	cccMarcaSituaRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('cccMarcaSituaFrm.accion');
	var origenTmp = get('cccMarcaSituaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cccMarcaSituaBuildUpdateRecordString() != cccMarcaSituaTmpUpdateValues){
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
	document.all.cccMarcaSituaListLayer.style.display='none';
	document.all.cccMarcaSituaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cccMarcaSituaListLayer.style.display='';
	document.all.cccMarcaSituaListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCccMarcaSituaCodMarcSitu = get('cccMarcaSituaFrm.codMarcSitu').toString();
	jsCccMarcaSituaDescripcion = get('cccMarcaSituaFrm.Descripcion').toString();
	jsCccMarcaSituaIndCuenCast = get('cccMarcaSituaFrm.indCuenCast');
	
	
	var parametros = "";
	parametros += jsCccMarcaSituaCodMarcSitu + "|";
	parametros += jsCccMarcaSituaDescripcion + "|";
	parametros += jsCccMarcaSituaIndCuenCast + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cccMarcaSituaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCccMarcaSituaCodMarcSitu + "|";
	parametros += jsCccMarcaSituaDescripcion + "|";
	parametros += jsCccMarcaSituaIndCuenCast + "|";
	parametros += jsCccMarcaSituaValObse + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cccMarcaSituaFrm.accion'), 
		get('cccMarcaSituaFrm.origen'));
	
	jsCccMarcaSituaId = get('cccMarcaSituaFrm.id').toString();
	jsCccMarcaSituaPaisOidPais = get('cccMarcaSituaFrm.paisOidPais')[0];
	jsCccMarcaSituaCodMarcSitu = get('cccMarcaSituaFrm.codMarcSitu').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsCccMarcaSituaDescripcion = buildLocalizedString('cccMarcaSituaFrm', 1);
	}else{
		jsCccMarcaSituaDescripcion = get('cccMarcaSituaFrm.Descripcion');
	}
	jsCccMarcaSituaIndCuenCast = get('cccMarcaSituaFrm.indCuenCast');
	jsCccMarcaSituaValObse = get('cccMarcaSituaFrm.valObse').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cccMarcaSituaFrm.accion'), 
		get('cccMarcaSituaFrm.origen'));


	set('cccMarcaSituaFrm.id', jsCccMarcaSituaId);
	set('cccMarcaSituaFrm.paisOidPais', [jsCccMarcaSituaPaisOidPais]);
	set('cccMarcaSituaFrm.codMarcSitu', jsCccMarcaSituaCodMarcSitu);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('cccMarcaSituaFrm', 1,  jsCccMarcaSituaDescripcion)
		loadLocalizationWidget('cccMarcaSituaFrm', 'Descripcion', 1);
	}else{
		set('cccMarcaSituaFrm.Descripcion', jsCccMarcaSituaDescripcion);		
	}
	set('cccMarcaSituaFrm.indCuenCast', jsCccMarcaSituaIndCuenCast);
	set('cccMarcaSituaFrm.valObse', jsCccMarcaSituaValObse);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCccMarcaSituaCodMarcSitu = '';
	jsCccMarcaSituaDescripcion = '';
	jsCccMarcaSituaIndCuenCast = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cccMarcaSituaFrm.errCodigo', errorCode);
	set('cccMarcaSituaFrm.errDescripcion', description);
	set('cccMarcaSituaFrm.errSeverity', severity);
	fMostrarMensajeError();
}

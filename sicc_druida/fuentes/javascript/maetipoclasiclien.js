

/*
    INDRA/CAR/mmg
    $Id: maetipoclasiclien.js,v 1.1 2009/12/03 19:02:06 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeTipoClasiClienId = "";
var jsMaeTipoClasiClienSbtiOidSubtClie = "";
var jsMaeTipoClasiClienCodTipoClas = "";
var jsMaeTipoClasiClienDescripcion = "";

//Variables de paginacion, 
var maeTipoClasiClienPageCount = 1;

//Varible de columna que representa el campo de choice
var maeTipoClasiClienChoiceColumn = 2;

//Flag de siguiente pagina;
var maeTipoClasiClienMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeTipoClasiClienTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var maeTipoClasiClienLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("maeTipoClasiClien","sbtiOidSubtClie", false);','focalizaComboDependence("maeTipoClasiClien","sbtiOidSubtClie", false);','focalizaComboDependence("maeTipoClasiClien","sbtiOidSubtClie", false);','focalizaComboDependence("maeTipoClasiClien","sbtiOidSubtClie", true);','focalizaComboDependence("maeTipoClasiClien","sbtiOidSubtClie", true);','focalizaComboDependence("maeTipoClasiClien","sbtiOidSubtClie", true);'],[3,'focaliza("maeTipoClasiClienFrm.codTipoClas");','focaliza("maeTipoClasiClienFrm.codTipoClas");','focaliza("maeTipoClasiClienFrm.codTipoClas");','focaliza("maeTipoClasiClienFrm.codTipoClas");','focaliza("maeTipoClasiClienFrm.codTipoClas");','focaliza("maeTipoClasiClienFrm.codTipoClas");'],[4,'focaliza("maeTipoClasiClienFrm.Descripcion");','focaliza("maeTipoClasiClienFrm.Descripcion");','focaliza("maeTipoClasiClienFrm.Descripcion");','focaliza("maeTipoClasiClienFrm.Descripcion");','focaliza("maeTipoClasiClienFrm.Descripcion");','focaliza("maeTipoClasiClienFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'focaliza("maeTipoClasiClienFrm.Descripcion");','focaliza("maeTipoClasiClienFrm.Descripcion");','focaliza("maeTipoClasiClienFrm.Descripcion");','focaliza("maeTipoClasiClienFrm.Descripcion");','focaliza("maeTipoClasiClienFrm.Descripcion");','focaliza("maeTipoClasiClienFrm.Descripcion");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var sbtiOidSubtClieDependeceMap = new Vector();
sbtiOidSubtClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
sbtiOidSubtClieDependeceMap.agregar(['sbtiOidSubtClie_ticlOidTipoClie', padresTmp, 'sbtiOidSubtClie', 'MaeTipoClien']);
padresTmp =  new Vector();
padresTmp.cargar(['sbtiOidSubtClie_ticlOidTipoClie'])
sbtiOidSubtClieDependeceMap.agregar(['sbtiOidSubtClie', padresTmp, '', 'MaeSubtiClien']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeTipoClasiClienLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeTipoClasiClienTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeTipoClasiClienInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeTipoClasiClienFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeTipoClasiClienFrm.accion')){
		case "query": maeTipoClasiClienQueryInitComponents(); break;
		case "view": maeTipoClasiClienViewInitComponents(); break;
		case "create": maeTipoClasiClienCreateInitComponents(); break;
		case "update": maeTipoClasiClienUpdateInitComponents(); break;
		case "remove": maeTipoClasiClienRemoveInitComponents(); break;
		case "lov": maeTipoClasiClienLovInitComponents(); break;
	}
	//alert('accion :' + get('maeTipoClasiClienFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeTipoClasiClienFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeTipoClasiClien')) maeTipoClasiClienCmdRequery();
}

function maeTipoClasiClienQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('maeTipoClasiClienFrm', true);	
}

function maeTipoClasiClienViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('maeTipoClasiClienFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('maeTipoClasiClienFrm', true);
}

function maeTipoClasiClienCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeTipoClasiClienFrm.sbtiOidSubtClie','S', GestionarMensaje('MaeTipoClasiClien.sbtiOidSubtClie.requiered.message'));
	
	setMV('maeTipoClasiClienFrm.codTipoClas','S', GestionarMensaje('MaeTipoClasiClien.codTipoClas.requiered.message'));
	
	setMV('maeTipoClasiClienFrm.Descripcion','S', GestionarMensaje('MaeTipoClasiClien.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeTipoClasiClienFrm', true);
}

function maeTipoClasiClienUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeTipoClasiClienFrm.origen') == "pagina"){
		loadLocalizationWidget('maeTipoClasiClienFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		maeTipoClasiClienTmpUpdateValues = maeTipoClasiClienBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeTipoClasiClienFrm.sbtiOidSubtClie','S', GestionarMensaje('MaeTipoClasiClien.sbtiOidSubtClie.requiered.message'));
		setMV('maeTipoClasiClienFrm.codTipoClas','S', GestionarMensaje('MaeTipoClasiClien.codTipoClas.requiered.message'));
		setMV('maeTipoClasiClienFrm.Descripcion','S', GestionarMensaje('MaeTipoClasiClien.Descripcion.requiered.message'));
		
			focusFirstFieldModify('maeTipoClasiClienFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('maeTipoClasiClienFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeTipoClasiClienFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeTipoClasiClienRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeTipoClasiClienList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeTipoClasiClienFrm', true);
}

function maeTipoClasiClienLovInitComponents(){
	maeTipoClasiClienLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeTipoClasiClienFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function maeTipoClasiClienSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeTipoClasiClienFrm.' + campo, id);
	set('maeTipoClasiClienFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeTipoClasiClienLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeTipoClasiClienLovReturnParameters.id = '';
	maeTipoClasiClienLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeTipoClasiClienLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoClasiClienList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeTipoClasiClienList.codSeleccionados();
	var descripcion = maeTipoClasiClienList.extraeDato(
		maeTipoClasiClienList.codSeleccionados()[0], maeTipoClasiClienChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeTipoClasiClienLovReturnParameters.id = codigo;
	maeTipoClasiClienLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeTipoClasiClienCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeTipoClasiClienFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeTipoClasiClienFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeTipoClasiClienList", "MaeTipoClasiClienConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeTipoClasiClienPostQueryActions(datos);"]], "", "");	
}

function maeTipoClasiClienCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeTipoClasiClienFrm.lastQueryToSession'));
	var i =0;
	set('maeTipoClasiClienFrm.sbtiOidSubtClie', [paramsRequery.ij(i++)]);
	
	set('maeTipoClasiClienFrm.codTipoClas', paramsRequery.ij(i++));
	
	set('maeTipoClasiClienFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeTipoClasiClienPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeTipoClasiClienCmdQuery(maeTipoClasiClienPageCount);
}

function maeTipoClasiClienFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeTipoClasiClienPageCount = 1;
	maeTipoClasiClienCmdQuery(maeTipoClasiClienPageCount);
}

function maeTipoClasiClienPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeTipoClasiClienLastQuery){
		maeTipoClasiClienFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeTipoClasiClienPageCount--;
	maeTipoClasiClienCmdQuery(maeTipoClasiClienPageCount);
}

function maeTipoClasiClienNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeTipoClasiClienLastQuery){
		maeTipoClasiClienFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeTipoClasiClienPageCount++;
	maeTipoClasiClienCmdQuery(maeTipoClasiClienPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeTipoClasiClienPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeTipoClasiClienListLayer', 'O');
		visibilidad('maeTipoClasiClienListButtonsLayer', 'O');
		if(get('maeTipoClasiClienFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeTipoClasiClienLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeTipoClasiClienViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeTipoClasiClienChoiceColumn) + "</A>",
			i, maeTipoClasiClienChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeTipoClasiClienList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeTipoClasiClienTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeTipoClasiClienMorePagesFlag = true;
		maeTipoClasiClienList.eliminar(mmgPageSize, 1);
	}else{
		maeTipoClasiClienMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeTipoClasiClienFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeTipoClasiClienListLayer', 'V');
	visibilidad('maeTipoClasiClienListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeTipoClasiClienList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeTipoClasiClienList.display();
	
	//Actualizamos el estado de los botones 
	if(maeTipoClasiClienMorePagesFlag){
		set_estado_botonera('maeTipoClasiClienPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeTipoClasiClienPaginationButtonBar',
			3,"inactivo");
	}
	if(maeTipoClasiClienPageCount > 1){
		set_estado_botonera('maeTipoClasiClienPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeTipoClasiClienPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeTipoClasiClienPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeTipoClasiClienPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeTipoClasiClienUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoClasiClienList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeTipoClasiClienFrm.idSelection', maeTipoClasiClienList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeTipoClasiClienFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeTipoClasiClienList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeTipoClasiClienFrm.accion');
		parametros["accion"] = get('maeTipoClasiClienFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeTipoClasiClienLPStartUp', get('maeTipoClasiClienFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeTipoClasiClienCmdRequery();
	}
}

function maeTipoClasiClienRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoClasiClienList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeTipoClasiClienList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeTipoClasiClienFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeTipoClasiClienList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeTipoClasiClienTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeTipoClasiClienFrm.timestamp', timestamps);


	maeTipoClasiClienFrm.oculto='S';
	envia('maeTipoClasiClienFrm');
	maeTipoClasiClienFrm.oculto='N';
}

function maeTipoClasiClienViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoClasiClienList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeTipoClasiClienViewDetail(maeTipoClasiClienList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeTipoClasiClienViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeTipoClasiClienFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeTipoClasiClienLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('maeTipoClasiClienFrm', 
		'Descripcion', 1,
		get('maeTipoClasiClienFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeTipoClasiClienFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('maeTipoClasiClienFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeTipoClasiClien.Descripcion.requiered.message'));
		focaliza('maeTipoClasiClienFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		maeTipoClasiClienFrm.oculto='S';
		envia('maeTipoClasiClienFrm');
		maeTipoClasiClienFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeTipoClasiClienFrm.sbtiOidSubtClie').toString() == ''){
		set('maeTipoClasiClienFrm.sbtiOidSubtClie_ticlOidTipoClie', []);
		mmgResetCombosOnCascade('sbtiOidSubtClie_ticlOidTipoClie', 'sbtiOidSubtClie', 'maeTipoClasiClien');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeTipoClasiClienRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeTipoClasiClienFrm.accion');
	var origenTmp = get('maeTipoClasiClienFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeTipoClasiClienBuildUpdateRecordString() != maeTipoClasiClienTmpUpdateValues){
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
	document.all.maeTipoClasiClienListLayer.style.display='none';
	document.all.maeTipoClasiClienListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeTipoClasiClienListLayer.style.display='';
	document.all.maeTipoClasiClienListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeTipoClasiClienSbtiOidSubtClie = get('maeTipoClasiClienFrm.sbtiOidSubtClie')[0];
	jsMaeTipoClasiClienCodTipoClas = get('maeTipoClasiClienFrm.codTipoClas').toString();
	jsMaeTipoClasiClienDescripcion = get('maeTipoClasiClienFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsMaeTipoClasiClienSbtiOidSubtClie + "|";
	parametros += jsMaeTipoClasiClienCodTipoClas + "|";
	parametros += jsMaeTipoClasiClienDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeTipoClasiClienBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeTipoClasiClienSbtiOidSubtClie + "|";
	parametros += jsMaeTipoClasiClienCodTipoClas + "|";
	parametros += jsMaeTipoClasiClienDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeTipoClasiClienFrm.accion'), 
		get('maeTipoClasiClienFrm.origen'));
	
	jsMaeTipoClasiClienId = get('maeTipoClasiClienFrm.id').toString();
	jsMaeTipoClasiClienSbtiOidSubtClie = get('maeTipoClasiClienFrm.sbtiOidSubtClie')[0];
	jsMaeTipoClasiClienCodTipoClas = get('maeTipoClasiClienFrm.codTipoClas').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeTipoClasiClienDescripcion = buildLocalizedString('maeTipoClasiClienFrm', 1);
	}else{
		jsMaeTipoClasiClienDescripcion = get('maeTipoClasiClienFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeTipoClasiClienFrm.accion'), 
		get('maeTipoClasiClienFrm.origen'));


	set('maeTipoClasiClienFrm.id', jsMaeTipoClasiClienId);
	set('maeTipoClasiClienFrm.sbtiOidSubtClie', [jsMaeTipoClasiClienSbtiOidSubtClie]);
	set('maeTipoClasiClienFrm.codTipoClas', jsMaeTipoClasiClienCodTipoClas);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeTipoClasiClienFrm', 1,  jsMaeTipoClasiClienDescripcion)
		loadLocalizationWidget('maeTipoClasiClienFrm', 'Descripcion', 1);
	}else{
		set('maeTipoClasiClienFrm.Descripcion', jsMaeTipoClasiClienDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeTipoClasiClienSbtiOidSubtClie = '';
	jsMaeTipoClasiClienCodTipoClas = '';
	jsMaeTipoClasiClienDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeTipoClasiClienFrm.errCodigo', errorCode);
	set('maeTipoClasiClienFrm.errDescripcion', description);
	set('maeTipoClasiClienFrm.errSeverity', severity);
	fMostrarMensajeError();
}

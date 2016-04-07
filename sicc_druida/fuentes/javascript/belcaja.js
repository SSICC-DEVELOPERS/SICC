

/*
    INDRA/CAR/mmg
    $Id: belcaja.js,v 1.1 2009/12/03 19:01:56 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsBelCajaId = "";
var jsBelCajaPaisOidPais = "";
var jsBelCajaSbacOidSbac = "";
var jsBelCajaCodCaja = "";
var jsBelCajaValEstaCaja = "";
var jsBelCajaFecCier = "";
var jsBelCajaUserOidUser = "";
var jsBelCajaTicjOidTipoCaja = "";

//Variables de paginacion, 
var belCajaPageCount = 1;

//Varible de columna que representa el campo de choice
var belCajaChoiceColumn = 4;

//Flag de siguiente pagina;
var belCajaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var belCajaTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 231;
var sizeFormView = 217;
var sizeFormUpdate = 217;

//Ultima busqueda realizada
var belCajaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focalizaComboDependence("belCaja","sbacOidSbac", false);','focalizaComboDependence("belCaja","sbacOidSbac", false);','focalizaComboDependence("belCaja","sbacOidSbac", false);','focalizaComboDependence("belCaja","sbacOidSbac", true);','focalizaComboDependence("belCaja","sbacOidSbac", true);','focalizaComboDependence("belCaja","sbacOidSbac", true);'],[4,'focaliza("belCajaFrm.codCaja");','focaliza("belCajaFrm.codCaja");','focaliza("belCajaFrm.codCaja");','focaliza("belCajaFrm.codCaja");','focaliza("belCajaFrm.codCaja");','focaliza("belCajaFrm.codCaja");'],[5,'','','','','',''],[6,'','','','','',''],[7,'focalizaComboDependence("belCaja","userOidUser", false);','focalizaComboDependence("belCaja","userOidUser", false);','focalizaComboDependence("belCaja","userOidUser", false);','focalizaComboDependence("belCaja","userOidUser", true);','focalizaComboDependence("belCaja","userOidUser", true);','focalizaComboDependence("belCaja","userOidUser", true);'],[8,'focalizaComboDependence("belCaja","ticjOidTipoCaja", false);','focalizaComboDependence("belCaja","ticjOidTipoCaja", false);','focalizaComboDependence("belCaja","ticjOidTipoCaja", false);','focalizaComboDependence("belCaja","ticjOidTipoCaja", true);','focalizaComboDependence("belCaja","ticjOidTipoCaja", true);','focalizaComboDependence("belCaja","ticjOidTipoCaja", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'','','','','',''],[5,'','','','','',''],[6,'','','','','',''],[7,'focalizaComboDependence("belCaja","userOidUser", false);','focalizaComboDependence("belCaja","userOidUser", false);','focalizaComboDependence("belCaja","userOidUser", false);','focalizaComboDependence("belCaja","userOidUser", true);','focalizaComboDependence("belCaja","userOidUser", true);','focalizaComboDependence("belCaja","userOidUser", true);'],[8,'focalizaComboDependence("belCaja","ticjOidTipoCaja", false);','focalizaComboDependence("belCaja","ticjOidTipoCaja", false);','focalizaComboDependence("belCaja","ticjOidTipoCaja", false);','focalizaComboDependence("belCaja","ticjOidTipoCaja", true);','focalizaComboDependence("belCaja","ticjOidTipoCaja", true);','focalizaComboDependence("belCaja","ticjOidTipoCaja", true);']]);

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
var sbacOidSbacDependeceMap = new Vector();
sbacOidSbacDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
sbacOidSbacDependeceMap.agregar(['sbacOidSbac_acceOidAcce_canaOidCana', padresTmp, 'sbacOidSbac_acceOidAcce', 'SegCanalView']);
padresTmp =  new Vector();
padresTmp.cargar(['sbacOidSbac_acceOidAcce_canaOidCana'])
sbacOidSbacDependeceMap.agregar(['sbacOidSbac_acceOidAcce', padresTmp, 'sbacOidSbac', 'SegAcces']);
padresTmp =  new Vector();
padresTmp.cargar(['sbacOidSbac_acceOidAcce'])
sbacOidSbacDependeceMap.agregar(['sbacOidSbac', padresTmp, '', 'SegSubac']);
var userOidUserDependeceMap = new Vector();
userOidUserDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
userOidUserDependeceMap.agregar(['userOidUser', padresTmp, '', 'GenUsers']);
var ticjOidTipoCajaDependeceMap = new Vector();
ticjOidTipoCajaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ticjOidTipoCajaDependeceMap.agregar(['ticjOidTipoCaja', padresTmp, '', 'BelTipoCaja']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
belCajaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var belCajaTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function belCajaInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('belCajaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('belCajaFrm.accion')){
		case "query": belCajaQueryInitComponents(); break;
		case "view": belCajaViewInitComponents(); break;
		case "create": belCajaCreateInitComponents(); break;
		case "update": belCajaUpdateInitComponents(); break;
		case "remove": belCajaRemoveInitComponents(); break;
		case "lov": belCajaLovInitComponents(); break;
	}
	//alert('accion :' + get('belCajaFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('belCajaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('belCaja')) belCajaCmdRequery();
}

function belCajaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	focusFirstField('belCajaFrm', true);	
}

function belCajaViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('belCajaFrm', true);
}

function belCajaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('belCajaFrm.sbacOidSbac','S', GestionarMensaje('BelCaja.sbacOidSbac.requiered.message'));
	
	setMV('belCajaFrm.codCaja','S', GestionarMensaje('BelCaja.codCaja.requiered.message'));
	
	setMV('belCajaFrm.userOidUser','S', GestionarMensaje('BelCaja.userOidUser.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('belCajaFrm', true);
}

function belCajaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('belCajaFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		belCajaTmpUpdateValues = belCajaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('belCajaFrm.sbacOidSbac','S', GestionarMensaje('BelCaja.sbacOidSbac.requiered.message'));
		setMV('belCajaFrm.codCaja','S', GestionarMensaje('BelCaja.codCaja.requiered.message'));
		setMV('belCajaFrm.userOidUser','S', GestionarMensaje('BelCaja.userOidUser.requiered.message'));
		
			focusFirstFieldModify('belCajaFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		focusFirstField('belCajaFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('belCajaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function belCajaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	belCajaList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('belCajaFrm', true);
}

function belCajaLovInitComponents(){
	belCajaLovReturnParameters = window.dialogArguments;
	
	focusFirstField('belCajaFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad










//Función que permite cargar los datos de un elemento de lov seleccionado
function belCajaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('belCajaFrm.' + campo, id);
	set('belCajaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function belCajaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	belCajaLovReturnParameters.id = '';
	belCajaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function belCajaLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belCajaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = belCajaList.codSeleccionados();
	var descripcion = belCajaList.extraeDato(
		belCajaList.codSeleccionados()[0], belCajaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	belCajaLovReturnParameters.id = codigo;
	belCajaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function belCajaCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('belCajaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('belCajaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "belCajaList", "BelCajaConectorTransactionQuery", 
		"result_ROWSET", parametros, "belCajaPostQueryActions(datos);"]], "", "");	
}

function belCajaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('belCajaFrm.lastQueryToSession'));
	var i =0;
	set('belCajaFrm.sbacOidSbac', [paramsRequery.ij(i++)]);
	
	set('belCajaFrm.codCaja', paramsRequery.ij(i++));
	
	set('belCajaFrm.userOidUser', [paramsRequery.ij(i++)]);
	
	set('belCajaFrm.ticjOidTipoCaja', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	belCajaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	belCajaCmdQuery(belCajaPageCount);
}

function belCajaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	belCajaPageCount = 1;
	belCajaCmdQuery(belCajaPageCount);
}

function belCajaPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != belCajaLastQuery){
		belCajaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	belCajaPageCount--;
	belCajaCmdQuery(belCajaPageCount);
}

function belCajaNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != belCajaLastQuery){
		belCajaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	belCajaPageCount++;
	belCajaCmdQuery(belCajaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function belCajaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('belCajaListLayer', 'O');
		visibilidad('belCajaListButtonsLayer', 'O');
		if(get('belCajaFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	belCajaLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 4)){
			case 'F': datosTmp.ij2(GestionarMensaje('BelCaja.ticjOidTipoCaja.F.value'), i, 4); break;
			case 'N': datosTmp.ij2(GestionarMensaje('BelCaja.ticjOidTipoCaja.N.value'), i, 4); break;
			case 'P': datosTmp.ij2(GestionarMensaje('BelCaja.ticjOidTipoCaja.P.value'), i, 4); break;
			default: datosTmp .ij2('', i, 4);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:belCajaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, belCajaChoiceColumn) + "</A>",
			i, belCajaChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	belCajaList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	belCajaTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		belCajaMorePagesFlag = true;
		belCajaList.eliminar(mmgPageSize, 1);
	}else{
		belCajaMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('belCajaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('belCajaListLayer', 'V');
	visibilidad('belCajaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('belCajaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	belCajaList.display();
	
	//Actualizamos el estado de los botones 
	if(belCajaMorePagesFlag){
		set_estado_botonera('belCajaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('belCajaPaginationButtonBar',
			3,"inactivo");
	}
	if(belCajaPageCount > 1){
		set_estado_botonera('belCajaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('belCajaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('belCajaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('belCajaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function belCajaUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belCajaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('belCajaFrm.idSelection', belCajaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('belCajaFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = belCajaList.codSeleccionados()[0];
		parametros["previousAction"] = get('belCajaFrm.accion');
		parametros["accion"] = get('belCajaFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('BelCajaLPStartUp', get('belCajaFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) belCajaCmdRequery();
	}
}

function belCajaRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belCajaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = belCajaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('belCajaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(belCajaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += belCajaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('belCajaFrm.timestamp', timestamps);


	belCajaFrm.oculto='S';
	envia('belCajaFrm');
	belCajaFrm.oculto='N';
}

function belCajaViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belCajaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	belCajaViewDetail(belCajaList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function belCajaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('belCajaFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('BelCajaLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('belCajaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		belCajaFrm.oculto='S';
		envia('belCajaFrm');
		belCajaFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('belCajaFrm.paisOidPais').toString() == ''){
		set('belCajaFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'belCaja');
		
	}
	if(get('belCajaFrm.sbacOidSbac').toString() == ''){
		set('belCajaFrm.sbacOidSbac_acceOidAcce_canaOidCana', []);
		mmgResetCombosOnCascade('sbacOidSbac_acceOidAcce_canaOidCana', 'sbacOidSbac', 'belCaja');
		
	}
	if(get('belCajaFrm.userOidUser').toString() == ''){
		set('belCajaFrm.userOidUser', []);
		mmgResetCombosOnCascade('userOidUser', 'userOidUser', 'belCaja');
		
	}
	if(get('belCajaFrm.ticjOidTipoCaja').toString() == ''){
		set('belCajaFrm.ticjOidTipoCaja', []);
		mmgResetCombosOnCascade('ticjOidTipoCaja', 'ticjOidTipoCaja', 'belCaja');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	belCajaRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('belCajaFrm.accion');
	var origenTmp = get('belCajaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(belCajaBuildUpdateRecordString() != belCajaTmpUpdateValues){
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
	document.all.belCajaListLayer.style.display='none';
	document.all.belCajaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.belCajaListLayer.style.display='';
	document.all.belCajaListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsBelCajaSbacOidSbac = get('belCajaFrm.sbacOidSbac')[0];
	jsBelCajaCodCaja = get('belCajaFrm.codCaja').toString();
	jsBelCajaUserOidUser = get('belCajaFrm.userOidUser')[0];
	jsBelCajaTicjOidTipoCaja = get('belCajaFrm.ticjOidTipoCaja')[0];
	
	
	var parametros = "";
	parametros += jsBelCajaSbacOidSbac + "|";
	parametros += jsBelCajaCodCaja + "|";
	parametros += jsBelCajaUserOidUser + "|";
	parametros += jsBelCajaTicjOidTipoCaja + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function belCajaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsBelCajaSbacOidSbac + "|";
	parametros += jsBelCajaCodCaja + "|";
	parametros += jsBelCajaUserOidUser + "|";
	parametros += jsBelCajaTicjOidTipoCaja + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('belCajaFrm.accion'), 
		get('belCajaFrm.origen'));
	
	jsBelCajaId = get('belCajaFrm.id').toString();
	jsBelCajaPaisOidPais = get('belCajaFrm.paisOidPais')[0];
	jsBelCajaSbacOidSbac = get('belCajaFrm.sbacOidSbac')[0];
	jsBelCajaCodCaja = get('belCajaFrm.codCaja').toString();
	jsBelCajaValEstaCaja = get('belCajaFrm.valEstaCaja').toString();
	jsBelCajaFecCier = get('belCajaFrm.fecCier').toString();
	jsBelCajaUserOidUser = get('belCajaFrm.userOidUser')[0];
	jsBelCajaTicjOidTipoCaja = get('belCajaFrm.ticjOidTipoCaja')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('belCajaFrm.accion'), 
		get('belCajaFrm.origen'));


	set('belCajaFrm.id', jsBelCajaId);
	set('belCajaFrm.paisOidPais', [jsBelCajaPaisOidPais]);
	set('belCajaFrm.sbacOidSbac', [jsBelCajaSbacOidSbac]);
	set('belCajaFrm.codCaja', jsBelCajaCodCaja);
	set('belCajaFrm.valEstaCaja', jsBelCajaValEstaCaja);
	set('belCajaFrm.fecCier', jsBelCajaFecCier);
	set('belCajaFrm.userOidUser', [jsBelCajaUserOidUser]);
	set('belCajaFrm.ticjOidTipoCaja', [jsBelCajaTicjOidTipoCaja]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsBelCajaSbacOidSbac = '';
	jsBelCajaCodCaja = '';
	jsBelCajaUserOidUser = '';
	jsBelCajaTicjOidTipoCaja = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('belCajaFrm.errCodigo', errorCode);
	set('belCajaFrm.errDescripcion', description);
	set('belCajaFrm.errSeverity', severity);
	fMostrarMensajeError();
}

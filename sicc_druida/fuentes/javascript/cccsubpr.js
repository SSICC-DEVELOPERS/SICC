

/*
    INDRA/CAR/mmg
    $Id: cccsubpr.js,v 1.1 2009/12/03 19:02:04 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCccSubprId = "";
var jsCccSubprCcprOidProc = "";
var jsCccSubprCodSubp = "";
var jsCccSubprDesSubp = "";
var jsCccSubprValIndiGestMarc = "";
var jsCccSubprValIndiActuCuot = "";
var jsCccSubprValIndiTipoAbon = "";
var jsCccSubprValIndiCons = "";
var jsCccSubprValObse = "";

//Variables de paginacion, 
var cccSubprPageCount = 1;

//Varible de columna que representa el campo de choice
var cccSubprChoiceColumn = 2;

//Flag de siguiente pagina;
var cccSubprMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cccSubprTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 195;
var sizeFormUpdate = 195;

//Ultima busqueda realizada
var cccSubprLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("cccSubpr","ccprOidProc", false);','focalizaComboDependence("cccSubpr","ccprOidProc", false);','focalizaComboDependence("cccSubpr","ccprOidProc", false);','focalizaComboDependence("cccSubpr","ccprOidProc", true);','focalizaComboDependence("cccSubpr","ccprOidProc", true);','focalizaComboDependence("cccSubpr","ccprOidProc", true);'],[3,'focaliza("cccSubprFrm.codSubp");','focaliza("cccSubprFrm.codSubp");','focaliza("cccSubprFrm.codSubp");','focaliza("cccSubprFrm.codSubp");','focaliza("cccSubprFrm.codSubp");','focaliza("cccSubprFrm.codSubp");'],[5,'','focaliza("cccSubprFrm.desSubp");','','','focaliza("cccSubprFrm.desSubp");',''],[6,'','focaliza("cccSubprFrm.valIndiGestMarc");','focaliza("cccSubprFrm.valIndiGestMarc");','','focaliza("cccSubprFrm.valIndiGestMarc");','focaliza("cccSubprFrm.valIndiGestMarc");'],[7,'','focaliza("cccSubprFrm.valIndiActuCuot");','focaliza("cccSubprFrm.valIndiActuCuot");','','focaliza("cccSubprFrm.valIndiActuCuot");','focaliza("cccSubprFrm.valIndiActuCuot");'],[8,'','focaliza("cccSubprFrm.valIndiTipoAbon");','focaliza("cccSubprFrm.valIndiTipoAbon");','','focaliza("cccSubprFrm.valIndiTipoAbon");','focaliza("cccSubprFrm.valIndiTipoAbon");'],[9,'','focaliza("cccSubprFrm.valIndiCons");','focaliza("cccSubprFrm.valIndiCons");','','focaliza("cccSubprFrm.valIndiCons");','focaliza("cccSubprFrm.valIndiCons");'],[10,'','focaliza("cccSubprFrm.valObse");','focaliza("cccSubprFrm.valObse");','','focaliza("cccSubprFrm.valObse");','focaliza("cccSubprFrm.valObse");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[5,'','focaliza("cccSubprFrm.desSubp");','','','focaliza("cccSubprFrm.desSubp");',''],[6,'','focaliza("cccSubprFrm.valIndiGestMarc");','focaliza("cccSubprFrm.valIndiGestMarc");','','focaliza("cccSubprFrm.valIndiGestMarc");','focaliza("cccSubprFrm.valIndiGestMarc");'],[7,'','focaliza("cccSubprFrm.valIndiActuCuot");','focaliza("cccSubprFrm.valIndiActuCuot");','','focaliza("cccSubprFrm.valIndiActuCuot");','focaliza("cccSubprFrm.valIndiActuCuot");'],[8,'','focaliza("cccSubprFrm.valIndiTipoAbon");','focaliza("cccSubprFrm.valIndiTipoAbon");','','focaliza("cccSubprFrm.valIndiTipoAbon");','focaliza("cccSubprFrm.valIndiTipoAbon");'],[9,'','focaliza("cccSubprFrm.valIndiCons");','focaliza("cccSubprFrm.valIndiCons");','','focaliza("cccSubprFrm.valIndiCons");','focaliza("cccSubprFrm.valIndiCons");'],[10,'','focaliza("cccSubprFrm.valObse");','focaliza("cccSubprFrm.valObse");','','focaliza("cccSubprFrm.valObse");','focaliza("cccSubprFrm.valObse");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var ccprOidProcDependeceMap = new Vector();
ccprOidProcDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ccprOidProcDependeceMap.agregar(['ccprOidProc', padresTmp, '', 'CccProce']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
cccSubprLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var cccSubprTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function cccSubprInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('cccSubprFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('cccSubprFrm.accion')){
		case "query": cccSubprQueryInitComponents(); break;
		case "view": cccSubprViewInitComponents(); break;
		case "create": cccSubprCreateInitComponents(); break;
		case "update": cccSubprUpdateInitComponents(); break;
		case "remove": cccSubprRemoveInitComponents(); break;
		case "lov": cccSubprLovInitComponents(); break;
	}
	//alert('accion :' + get('cccSubprFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('cccSubprFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cccSubpr')) cccSubprCmdRequery();
}

function cccSubprQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('cccSubprFrm', true);	
}

function cccSubprViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	//Establecemos el valor de los radiobuttons
		set('cccSubprFrm.valIndiCons', get('cccSubprFrm.valIndiConsCheckValue'));
		
	focusFirstField('cccSubprFrm', true);
}

function cccSubprCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cccSubprFrm.ccprOidProc','S', GestionarMensaje('CccSubpr.ccprOidProc.requiered.message'));
	
	setMV('cccSubprFrm.codSubp','S', GestionarMensaje('CccSubpr.codSubp.requiered.message'));
	
	setMV('cccSubprFrm.desSubp','S', GestionarMensaje('CccSubpr.desSubp.requiered.message'));
	
	setMV('cccSubprFrm.valIndiCons','S', GestionarMensaje('CccSubpr.valIndiCons.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('cccSubprFrm', true);
}

function cccSubprUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('cccSubprFrm.origen') == "pagina"){
		

		//Establecemos el valor de los radiobuttons
			set('cccSubprFrm.valIndiCons', get('cccSubprFrm.valIndiConsCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		cccSubprTmpUpdateValues = cccSubprBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cccSubprFrm.ccprOidProc','S', GestionarMensaje('CccSubpr.ccprOidProc.requiered.message'));
		setMV('cccSubprFrm.codSubp','S', GestionarMensaje('CccSubpr.codSubp.requiered.message'));
		setMV('cccSubprFrm.valIndiCons','S', GestionarMensaje('CccSubpr.valIndiCons.requiered.message'));
		
			focusFirstFieldModify('cccSubprFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('cccSubprFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('cccSubprFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cccSubprRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	cccSubprList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('cccSubprFrm', true);
}

function cccSubprLovInitComponents(){
	cccSubprLovReturnParameters = window.dialogArguments;
	
	focusFirstField('cccSubprFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad











//Función que permite cargar los datos de un elemento de lov seleccionado
function cccSubprSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cccSubprFrm.' + campo, id);
	set('cccSubprFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function cccSubprLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cccSubprLovReturnParameters.id = '';
	cccSubprLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cccSubprLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccSubprList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cccSubprList.codSeleccionados();
	var descripcion = cccSubprList.extraeDato(
		cccSubprList.codSeleccionados()[0], cccSubprChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cccSubprLovReturnParameters.id = codigo;
	cccSubprLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function cccSubprCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cccSubprFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('cccSubprFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cccSubprList", "CccSubprConectorTransactionQuery", 
		"result_ROWSET", parametros, "cccSubprPostQueryActions(datos);"]], "", "");	
}

function cccSubprCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cccSubprFrm.lastQueryToSession'));
	var i =0;
	set('cccSubprFrm.ccprOidProc', [paramsRequery.ij(i++)]);
	
	set('cccSubprFrm.codSubp', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	cccSubprPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cccSubprCmdQuery(cccSubprPageCount);
}

function cccSubprFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cccSubprPageCount = 1;
	cccSubprCmdQuery(cccSubprPageCount);
}

function cccSubprPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cccSubprLastQuery){
		cccSubprFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cccSubprPageCount--;
	cccSubprCmdQuery(cccSubprPageCount);
}

function cccSubprNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cccSubprLastQuery){
		cccSubprFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cccSubprPageCount++;
	cccSubprCmdQuery(cccSubprPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cccSubprPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cccSubprListLayer', 'O');
		visibilidad('cccSubprListButtonsLayer', 'O');
		if(get('cccSubprFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	cccSubprLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 7)){
			case 'D': datosTmp.ij2(GestionarMensaje('CccSubpr.valIndiCons.D.value'), i, 7); break;
			case 'H': datosTmp.ij2(GestionarMensaje('CccSubpr.valIndiCons.H.value'), i, 7); break;
			case 'A': datosTmp.ij2(GestionarMensaje('CccSubpr.valIndiCons.A.value'), i, 7); break;
			case 'N': datosTmp.ij2(GestionarMensaje('CccSubpr.valIndiCons.N.value'), i, 7); break;
			default: datosTmp .ij2('', i, 7);
		}
	}
	
		
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 4) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 4);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 4);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 5) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 5);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 5);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 6) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 6);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 6);
		}
	}
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:cccSubprViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cccSubprChoiceColumn) + "</A>",
			i, cccSubprChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cccSubprList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	cccSubprTimeStamps = datosTmp.filtrar([8],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		cccSubprMorePagesFlag = true;
		cccSubprList.eliminar(mmgPageSize, 1);
	}else{
		cccSubprMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('cccSubprFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cccSubprListLayer', 'V');
	visibilidad('cccSubprListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cccSubprList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cccSubprList.display();
	
	//Actualizamos el estado de los botones 
	if(cccSubprMorePagesFlag){
		set_estado_botonera('cccSubprPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cccSubprPaginationButtonBar',
			3,"inactivo");
	}
	if(cccSubprPageCount > 1){
		set_estado_botonera('cccSubprPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cccSubprPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cccSubprPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cccSubprPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cccSubprUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccSubprList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cccSubprFrm.idSelection', cccSubprList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('cccSubprFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = cccSubprList.codSeleccionados()[0];
		parametros["previousAction"] = get('cccSubprFrm.accion');
		parametros["accion"] = get('cccSubprFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CccSubprLPStartUp', get('cccSubprFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) cccSubprCmdRequery();
	}
}

function cccSubprRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccSubprList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cccSubprList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cccSubprFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cccSubprList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cccSubprTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cccSubprFrm.timestamp', timestamps);


	cccSubprFrm.oculto='S';
	envia('cccSubprFrm');
	cccSubprFrm.oculto='N';
}

function cccSubprViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccSubprList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	cccSubprViewDetail(cccSubprList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function cccSubprViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cccSubprFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CccSubprLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('cccSubprFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		cccSubprFrm.oculto='S';
		envia('cccSubprFrm');
		cccSubprFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('cccSubprFrm.ccprOidProc').toString() == ''){
		set('cccSubprFrm.ccprOidProc', []);
		mmgResetCombosOnCascade('ccprOidProc', 'ccprOidProc', 'cccSubpr');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	cccSubprRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('cccSubprFrm.accion');
	var origenTmp = get('cccSubprFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cccSubprBuildUpdateRecordString() != cccSubprTmpUpdateValues){
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
	document.all.cccSubprListLayer.style.display='none';
	document.all.cccSubprListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cccSubprListLayer.style.display='';
	document.all.cccSubprListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCccSubprCcprOidProc = get('cccSubprFrm.ccprOidProc')[0];
	jsCccSubprCodSubp = get('cccSubprFrm.codSubp').toString();
	
	
	var parametros = "";
	parametros += jsCccSubprCcprOidProc + "|";
	parametros += jsCccSubprCodSubp + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cccSubprBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCccSubprCcprOidProc + "|";
	parametros += jsCccSubprCodSubp + "|";
	parametros += jsCccSubprValIndiGestMarc + "|";
	parametros += jsCccSubprValIndiActuCuot + "|";
	parametros += jsCccSubprValIndiTipoAbon + "|";
	parametros += jsCccSubprValIndiCons + "|";
	parametros += jsCccSubprValObse + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cccSubprFrm.accion'), 
		get('cccSubprFrm.origen'));
	
	jsCccSubprId = get('cccSubprFrm.id').toString();
	jsCccSubprCcprOidProc = get('cccSubprFrm.ccprOidProc')[0];
	jsCccSubprCodSubp = get('cccSubprFrm.codSubp').toString();
	jsCccSubprDesSubp = get('cccSubprFrm.desSubp').toString();
	if(get('cccSubprFrm.valIndiGestMarc').toString() == 'S') jsCccSubprValIndiGestMarc = "true";
		else jsCccSubprValIndiGestMarc = "false";
	if(get('cccSubprFrm.valIndiActuCuot').toString() == 'S') jsCccSubprValIndiActuCuot = "true";
		else jsCccSubprValIndiActuCuot = "false";
	if(get('cccSubprFrm.valIndiTipoAbon').toString() == 'S') jsCccSubprValIndiTipoAbon = "true";
		else jsCccSubprValIndiTipoAbon = "false";
	jsCccSubprValIndiCons = get('cccSubprFrm.valIndiCons');
	jsCccSubprValObse = get('cccSubprFrm.valObse').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cccSubprFrm.accion'), 
		get('cccSubprFrm.origen'));


	set('cccSubprFrm.id', jsCccSubprId);
	set('cccSubprFrm.ccprOidProc', [jsCccSubprCcprOidProc]);
	set('cccSubprFrm.codSubp', jsCccSubprCodSubp);
	set('cccSubprFrm.desSubp', jsCccSubprDesSubp);
	
			
			if(jsCccSubprValIndiGestMarc == "true") set('cccSubprFrm.valIndiGestMarc', 'S');
			else set('cccSubprFrm.valIndiGestMarc', 'N');
	
			
			if(jsCccSubprValIndiActuCuot == "true") set('cccSubprFrm.valIndiActuCuot', 'S');
			else set('cccSubprFrm.valIndiActuCuot', 'N');
	
			
			if(jsCccSubprValIndiTipoAbon == "true") set('cccSubprFrm.valIndiTipoAbon', 'S');
			else set('cccSubprFrm.valIndiTipoAbon', 'N');
	set('cccSubprFrm.valIndiCons', jsCccSubprValIndiCons);
	set('cccSubprFrm.valObse', jsCccSubprValObse);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCccSubprCcprOidProc = '';
	jsCccSubprCodSubp = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cccSubprFrm.errCodigo', errorCode);
	set('cccSubprFrm.errDescripcion', description);
	set('cccSubprFrm.errSeverity', severity);
	fMostrarMensajeError();
}

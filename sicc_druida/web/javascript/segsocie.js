

/*
    INDRA/CAR/mmg
    $Id: segsocie.js,v 1.1 2009/12/03 19:02:17 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsSegSocieId = "";
var jsSegSociePaisOidPais = "";
var jsSegSocieCodSoci = "";
var jsSegSocieValDeno = "";
var jsSegSocieValDire = "";
var jsSegSocieValTlfn = "";
var jsSegSocieValFax = "";
var jsSegSocieValIdenFisc = "";

//Variables de paginacion, 
var segSociePageCount = 1;

//Varible de columna que representa el campo de choice
var segSocieChoiceColumn = 1;

//Flag de siguiente pagina;
var segSocieMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var segSocieTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 171;
var sizeFormUpdate = 171;

//Ultima busqueda realizada
var segSocieLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focaliza("segSocieFrm.codSoci");','focaliza("segSocieFrm.codSoci");','focaliza("segSocieFrm.codSoci");','focaliza("segSocieFrm.codSoci");','focaliza("segSocieFrm.codSoci");','focaliza("segSocieFrm.codSoci");'],[4,'focaliza("segSocieFrm.valDeno");','focaliza("segSocieFrm.valDeno");','focaliza("segSocieFrm.valDeno");','focaliza("segSocieFrm.valDeno");','focaliza("segSocieFrm.valDeno");','focaliza("segSocieFrm.valDeno");'],[5,'','focaliza("segSocieFrm.valDire");','focaliza("segSocieFrm.valDire");','','focaliza("segSocieFrm.valDire");','focaliza("segSocieFrm.valDire");'],[6,'','focaliza("segSocieFrm.valTlfn");','focaliza("segSocieFrm.valTlfn");','','focaliza("segSocieFrm.valTlfn");','focaliza("segSocieFrm.valTlfn");'],[7,'','focaliza("segSocieFrm.valFax");','focaliza("segSocieFrm.valFax");','','focaliza("segSocieFrm.valFax");','focaliza("segSocieFrm.valFax");'],[8,'','focaliza("segSocieFrm.valIdenFisc");','focaliza("segSocieFrm.valIdenFisc");','','focaliza("segSocieFrm.valIdenFisc");','focaliza("segSocieFrm.valIdenFisc");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'focaliza("segSocieFrm.valDeno");','focaliza("segSocieFrm.valDeno");','focaliza("segSocieFrm.valDeno");','focaliza("segSocieFrm.valDeno");','focaliza("segSocieFrm.valDeno");','focaliza("segSocieFrm.valDeno");'],[5,'','focaliza("segSocieFrm.valDire");','focaliza("segSocieFrm.valDire");','','focaliza("segSocieFrm.valDire");','focaliza("segSocieFrm.valDire");'],[6,'','focaliza("segSocieFrm.valTlfn");','focaliza("segSocieFrm.valTlfn");','','focaliza("segSocieFrm.valTlfn");','focaliza("segSocieFrm.valTlfn");'],[7,'','focaliza("segSocieFrm.valFax");','focaliza("segSocieFrm.valFax");','','focaliza("segSocieFrm.valFax");','focaliza("segSocieFrm.valFax");'],[8,'','focaliza("segSocieFrm.valIdenFisc");','focaliza("segSocieFrm.valIdenFisc");','','focaliza("segSocieFrm.valIdenFisc");','focaliza("segSocieFrm.valIdenFisc");']]);

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
segSocieLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var segSocieTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function segSocieInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('segSocieFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('segSocieFrm.accion')){
		case "query": segSocieQueryInitComponents(); break;
		case "view": segSocieViewInitComponents(); break;
		case "create": segSocieCreateInitComponents(); break;
		case "update": segSocieUpdateInitComponents(); break;
		case "remove": segSocieRemoveInitComponents(); break;
		case "lov": segSocieLovInitComponents(); break;
	}
	//alert('accion :' + get('segSocieFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('segSocieFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('segSocie')) segSocieCmdRequery();
}

function segSocieQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('segSocieFrm', true);	
}

function segSocieViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('segSocieFrm', true);
}

function segSocieCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('segSocieFrm.codSoci','S', GestionarMensaje('SegSocie.codSoci.requiered.message'));
	
	setMV('segSocieFrm.valDeno','S', GestionarMensaje('SegSocie.valDeno.requiered.message'));
	
	setMV('segSocieFrm.valIdenFisc','S', GestionarMensaje('SegSocie.valIdenFisc.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('segSocieFrm', true);
}

function segSocieUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('segSocieFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		segSocieTmpUpdateValues = segSocieBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('segSocieFrm.codSoci','S', GestionarMensaje('SegSocie.codSoci.requiered.message'));
		setMV('segSocieFrm.valDeno','S', GestionarMensaje('SegSocie.valDeno.requiered.message'));
		setMV('segSocieFrm.valIdenFisc','S', GestionarMensaje('SegSocie.valIdenFisc.requiered.message'));
		
			focusFirstFieldModify('segSocieFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('segSocieFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('segSocieFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function segSocieRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	segSocieList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('segSocieFrm', true);
}

function segSocieLovInitComponents(){
	segSocieLovReturnParameters = window.dialogArguments;
	
	focusFirstField('segSocieFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad










//Función que permite cargar los datos de un elemento de lov seleccionado
function segSocieSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('segSocieFrm.' + campo, id);
	set('segSocieFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function segSocieLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	segSocieLovReturnParameters.id = '';
	segSocieLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function segSocieLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segSocieList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = segSocieList.codSeleccionados();
	var descripcion = segSocieList.extraeDato(
		segSocieList.codSeleccionados()[0], segSocieChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	segSocieLovReturnParameters.id = codigo;
	segSocieLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function segSocieCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('segSocieFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('segSocieFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "segSocieList", "SegSocieConectorTransactionQuery", 
		"result_ROWSET", parametros, "segSociePostQueryActions(datos);"]], "", "");	
}

function segSocieCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('segSocieFrm.lastQueryToSession'));
	var i =0;
	set('segSocieFrm.codSoci', paramsRequery.ij(i++));
	
	set('segSocieFrm.valDeno', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	segSociePageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	segSocieCmdQuery(segSociePageCount);
}

function segSocieFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	segSociePageCount = 1;
	segSocieCmdQuery(segSociePageCount);
}

function segSociePreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != segSocieLastQuery){
		segSocieFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	segSociePageCount--;
	segSocieCmdQuery(segSociePageCount);
}

function segSocieNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != segSocieLastQuery){
		segSocieFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	segSociePageCount++;
	segSocieCmdQuery(segSociePageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function segSociePostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('segSocieListLayer', 'O');
		visibilidad('segSocieListButtonsLayer', 'O');
		if(get('segSocieFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	segSocieLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:segSocieViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, segSocieChoiceColumn) + "</A>",
			i, segSocieChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	segSocieList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	segSocieTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		segSocieMorePagesFlag = true;
		segSocieList.eliminar(mmgPageSize, 1);
	}else{
		segSocieMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('segSocieFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('segSocieListLayer', 'V');
	visibilidad('segSocieListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('segSocieList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	segSocieList.display();
	
	//Actualizamos el estado de los botones 
	if(segSocieMorePagesFlag){
		set_estado_botonera('segSociePaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('segSociePaginationButtonBar',
			3,"inactivo");
	}
	if(segSociePageCount > 1){
		set_estado_botonera('segSociePaginationButtonBar',
			2,"activo");
		set_estado_botonera('segSociePaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('segSociePaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('segSociePaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function segSocieUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segSocieList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('segSocieFrm.idSelection', segSocieList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('segSocieFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = segSocieList.codSeleccionados()[0];
		parametros["previousAction"] = get('segSocieFrm.accion');
		parametros["accion"] = get('segSocieFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('SegSocieLPStartUp', get('segSocieFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) segSocieCmdRequery();
	}
}

function segSocieRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segSocieList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = segSocieList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('segSocieFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(segSocieList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += segSocieTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('segSocieFrm.timestamp', timestamps);


	segSocieFrm.oculto='S';
	envia('segSocieFrm');
	segSocieFrm.oculto='N';
}

function segSocieViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segSocieList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	segSocieViewDetail(segSocieList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function segSocieViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('segSocieFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('SegSocieLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('segSocieFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		segSocieFrm.oculto='S';
		envia('segSocieFrm');
		segSocieFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('segSocieFrm.paisOidPais').toString() == ''){
		set('segSocieFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'segSocie');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	segSocieRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('segSocieFrm.accion');
	var origenTmp = get('segSocieFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(segSocieBuildUpdateRecordString() != segSocieTmpUpdateValues){
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
	document.all.segSocieListLayer.style.display='none';
	document.all.segSocieListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.segSocieListLayer.style.display='';
	document.all.segSocieListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsSegSocieCodSoci = get('segSocieFrm.codSoci').toString();
	jsSegSocieValDeno = get('segSocieFrm.valDeno').toString();
	
	
	var parametros = "";
	parametros += jsSegSocieCodSoci + "|";
	parametros += jsSegSocieValDeno + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function segSocieBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsSegSocieCodSoci + "|";
	parametros += jsSegSocieValDeno + "|";
	parametros += jsSegSocieValDire + "|";
	parametros += jsSegSocieValTlfn + "|";
	parametros += jsSegSocieValFax + "|";
	parametros += jsSegSocieValIdenFisc + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('segSocieFrm.accion'), 
		get('segSocieFrm.origen'));
	
	jsSegSocieId = get('segSocieFrm.id').toString();
	jsSegSociePaisOidPais = get('segSocieFrm.paisOidPais')[0];
	jsSegSocieCodSoci = get('segSocieFrm.codSoci').toString();
	jsSegSocieValDeno = get('segSocieFrm.valDeno').toString();
	jsSegSocieValDire = get('segSocieFrm.valDire').toString();
	jsSegSocieValTlfn = get('segSocieFrm.valTlfn').toString();
	jsSegSocieValFax = get('segSocieFrm.valFax').toString();
	jsSegSocieValIdenFisc = get('segSocieFrm.valIdenFisc').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('segSocieFrm.accion'), 
		get('segSocieFrm.origen'));


	set('segSocieFrm.id', jsSegSocieId);
	set('segSocieFrm.paisOidPais', [jsSegSociePaisOidPais]);
	set('segSocieFrm.codSoci', jsSegSocieCodSoci);
	set('segSocieFrm.valDeno', jsSegSocieValDeno);
	set('segSocieFrm.valDire', jsSegSocieValDire);
	set('segSocieFrm.valTlfn', jsSegSocieValTlfn);
	set('segSocieFrm.valFax', jsSegSocieValFax);
	set('segSocieFrm.valIdenFisc', jsSegSocieValIdenFisc);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsSegSocieCodSoci = '';
	jsSegSocieValDeno = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('segSocieFrm.errCodigo', errorCode);
	set('segSocieFrm.errDescripcion', description);
	set('segSocieFrm.errSeverity', severity);
	fMostrarMensajeError();
}

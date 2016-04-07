

/*
    INDRA/CAR/mmg
    $Id: zonterri.js,v 1.1 2009/12/03 19:02:05 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsZonTerriPaisOidPais = "";
var jsZonTerriId = "";
var jsZonTerriCodTerr = "";
var jsZonTerriCodNse1 = "";
var jsZonTerriCodNse2 = "";
var jsZonTerriCodNse3 = "";
var jsZonTerriIndBorr = "";
var jsZonTerriVepoOidValoEstrGeop = "";
var jsZonTerriFecRtz = "";

//Variables de paginacion, 
var zonTerriPageCount = 1;

//Varible de columna que representa el campo de choice
var zonTerriChoiceColumn = 8;

//Flag de siguiente pagina;
var zonTerriMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var zonTerriTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 399;
var sizeFormView = 389;
var sizeFormUpdate = 389;

//Ultima busqueda realizada
var zonTerriLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("zonTerriFrm.fecRtz");','focaliza("zonTerriFrm.fecRtz");','focaliza("zonTerriFrm.fecRtz");','focaliza("zonTerriFrm.fecRtz");','focaliza("zonTerriFrm.fecRtz");','focaliza("zonTerriFrm.fecRtz");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_moneOidMone', padresTmp, 'paisOidPais', 'SegMoned']);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_moneOidMoneAlt', padresTmp, 'paisOidPais', 'SegMoned']);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_fopaOidFormPago', padresTmp, 'paisOidPais', 'BelFormaPagoTapon']);
padresTmp =  new Vector();
padresTmp.cargar(['paisOidPais_moneOidMone','paisOidPais_moneOidMoneAlt','paisOidPais_fopaOidFormPago'])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPais']);
var vepoOidValoEstrGeopDependeceMap = new Vector();
vepoOidValoEstrGeopDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
vepoOidValoEstrGeopDependeceMap.agregar(['vepoOidValoEstrGeop', padresTmp, '', 'ZonValorEstruGeopo']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
zonTerriLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var zonTerriTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function zonTerriInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('zonTerriFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('zonTerriFrm.accion')){
		case "query": zonTerriQueryInitComponents(); break;
		case "view": zonTerriViewInitComponents(); break;
		case "create": zonTerriCreateInitComponents(); break;
		case "update": zonTerriUpdateInitComponents(); break;
		case "remove": zonTerriRemoveInitComponents(); break;
		case "lov": zonTerriLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('zonTerriFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('zonTerri')) zonTerriCmdRequery();
}

function zonTerriQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
}

function zonTerriViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
}

function zonTerriCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('zonTerriFrm.paisOidPais','S', GestionarMensaje('ZonTerri.paisOidPais.requiered.message'));
	
	setMV('zonTerriFrm.codTerr','S', GestionarMensaje('ZonTerri.codTerr.requiered.message'));
	
	setMV('zonTerriFrm.indBorr','S', GestionarMensaje('ZonTerri.indBorr.requiered.message'));
	
	setMV('zonTerriFrm.fecRtz','S', GestionarMensaje('ZonTerri.fecRtz.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function zonTerriUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('zonTerriFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		zonTerriTmpUpdateValues = zonTerriBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('zonTerriFrm.paisOidPais','S', GestionarMensaje('ZonTerri.paisOidPais.requiered.message'));
		setMV('zonTerriFrm.codTerr','S', GestionarMensaje('ZonTerri.codTerr.requiered.message'));
		setMV('zonTerriFrm.indBorr','S', GestionarMensaje('ZonTerri.indBorr.requiered.message'));
		setMV('zonTerriFrm.fecRtz','S', GestionarMensaje('ZonTerri.fecRtz.requiered.message'));
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('zonTerriFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function zonTerriRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	zonTerriList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function zonTerriLovInitComponents(){
	zonTerriLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad











//Función que permite cargar los datos de un elemento de lov seleccionado
function zonTerriSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('zonTerriFrm.' + campo, id);
	set('zonTerriFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function zonTerriLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	zonTerriLovReturnParameters.id = '';
	zonTerriLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function zonTerriLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonTerriList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = zonTerriList.codSeleccionados();
	var descripcion = zonTerriList.extraeDato(
		zonTerriList.codSeleccionados()[0], zonTerriChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	zonTerriLovReturnParameters.id = codigo;
	zonTerriLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function zonTerriCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('zonTerriFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('zonTerriFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "zonTerriList", "ZonTerriConectorTransactionQuery", 
		"result_ROWSET", parametros, "zonTerriPostQueryActions(datos);"]], "", "");	
}

function zonTerriCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('zonTerriFrm.lastQueryToSession'));
	var i =0;
	set('zonTerriFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('zonTerriFrm.codTerr', paramsRequery.ij(i++));
	
	set('zonTerriFrm.codNse1', paramsRequery.ij(i++));
	
	set('zonTerriFrm.codNse2', paramsRequery.ij(i++));
	
	set('zonTerriFrm.codNse3', paramsRequery.ij(i++));
	
	set('zonTerriFrm.indBorr', paramsRequery.ij(i++));
	
	set('zonTerriFrm.vepoOidValoEstrGeop', [paramsRequery.ij(i++)]);
	
	set('zonTerriFrm.fecRtz', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	zonTerriPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	zonTerriCmdQuery(zonTerriPageCount);
}

function zonTerriFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	zonTerriPageCount = 1;
	zonTerriCmdQuery(zonTerriPageCount);
}

function zonTerriPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonTerriLastQuery){
		zonTerriFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	zonTerriPageCount--;
	zonTerriCmdQuery(zonTerriPageCount);
}

function zonTerriNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonTerriLastQuery){
		zonTerriFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	zonTerriPageCount++;
	zonTerriCmdQuery(zonTerriPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function zonTerriPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('zonTerriListLayer', 'O');
		visibilidad('zonTerriListButtonsLayer', 'O');
		if(get('zonTerriFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	zonTerriLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:zonTerriViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, zonTerriChoiceColumn) + "</A>",
			i, zonTerriChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	zonTerriList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	zonTerriTimeStamps = datosTmp.filtrar([9],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		zonTerriMorePagesFlag = true;
		zonTerriList.eliminar(mmgPageSize, 1);
	}else{
		zonTerriMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('zonTerriFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('zonTerriListLayer', 'V');
	visibilidad('zonTerriListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('zonTerriList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	zonTerriList.display();
	
	//Actualizamos el estado de los botones 
	if(zonTerriMorePagesFlag){
		set_estado_botonera('zonTerriPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('zonTerriPaginationButtonBar',
			3,"inactivo");
	}
	if(zonTerriPageCount > 1){
		set_estado_botonera('zonTerriPaginationButtonBar',
			2,"activo");
		set_estado_botonera('zonTerriPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('zonTerriPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('zonTerriPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function zonTerriUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonTerriList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('zonTerriFrm.idSelection', zonTerriList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('zonTerriFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = zonTerriList.codSeleccionados()[0];
		parametros["previousAction"] = get('zonTerriFrm.accion');
		parametros["accion"] = get('zonTerriFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('ZonTerriLPStartUp', get('zonTerriFrm.accion'), parametros, null, sizeFormView + 55);
		if(result == MMG_RC_OK) zonTerriCmdRequery();
	}
}

function zonTerriRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonTerriList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = zonTerriList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('zonTerriFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(zonTerriList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += zonTerriTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('zonTerriFrm.timestamp', timestamps);


	zonTerriFrm.oculto='S';
	envia('zonTerriFrm');
	zonTerriFrm.oculto='N';
}

function zonTerriViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonTerriList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	zonTerriViewDetail(zonTerriList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function zonTerriViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('zonTerriFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	mostrarModalSICC('ZonTerriLPStartUp', 'view', parametros, null, sizeFormView + 55);
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
	var validacion = ValidaForm('zonTerriFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		zonTerriFrm.oculto='S';
		envia('zonTerriFrm');
		zonTerriFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('zonTerriFrm.paisOidPais').toString() == ''){
		set('zonTerriFrm.paisOidPais_moneOidMone', []);
		mmgResetCombosOnCascade('paisOidPais_moneOidMone', 'paisOidPais', 'zonTerri');
		set('zonTerriFrm.paisOidPais_moneOidMoneAlt', []);
		mmgResetCombosOnCascade('paisOidPais_moneOidMoneAlt', 'paisOidPais', 'zonTerri');
		set('zonTerriFrm.paisOidPais_fopaOidFormPago', []);
		mmgResetCombosOnCascade('paisOidPais_fopaOidFormPago', 'paisOidPais', 'zonTerri');
		
	}
	if(get('zonTerriFrm.vepoOidValoEstrGeop').toString() == ''){
		set('zonTerriFrm.vepoOidValoEstrGeop', []);
		mmgResetCombosOnCascade('vepoOidValoEstrGeop', 'vepoOidValoEstrGeop', 'zonTerri');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	zonTerriRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('zonTerriFrm.accion');
	var origenTmp = get('zonTerriFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(zonTerriBuildUpdateRecordString() != zonTerriTmpUpdateValues){
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
	document.all.zonTerriListLayer.style.display='none';
	document.all.zonTerriListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.zonTerriListLayer.style.display='';
	document.all.zonTerriListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsZonTerriPaisOidPais = get('zonTerriFrm.paisOidPais')[0];
	jsZonTerriCodTerr = get('zonTerriFrm.codTerr').toString();
	jsZonTerriCodNse1 = get('zonTerriFrm.codNse1').toString();
	jsZonTerriCodNse2 = get('zonTerriFrm.codNse2').toString();
	jsZonTerriCodNse3 = get('zonTerriFrm.codNse3').toString();
	jsZonTerriIndBorr = get('zonTerriFrm.indBorr').toString();
	jsZonTerriVepoOidValoEstrGeop = get('zonTerriFrm.vepoOidValoEstrGeop')[0];
	jsZonTerriFecRtz = get('zonTerriFrm.fecRtz').toString();
	
	
	var parametros = "";
	parametros += jsZonTerriPaisOidPais + "|";
	parametros += jsZonTerriCodTerr + "|";
	parametros += jsZonTerriCodNse1 + "|";
	parametros += jsZonTerriCodNse2 + "|";
	parametros += jsZonTerriCodNse3 + "|";
	parametros += jsZonTerriIndBorr + "|";
	parametros += jsZonTerriVepoOidValoEstrGeop + "|";
	parametros += jsZonTerriFecRtz + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function zonTerriBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsZonTerriPaisOidPais + "|";
	parametros += jsZonTerriCodTerr + "|";
	parametros += jsZonTerriCodNse1 + "|";
	parametros += jsZonTerriCodNse2 + "|";
	parametros += jsZonTerriCodNse3 + "|";
	parametros += jsZonTerriIndBorr + "|";
	parametros += jsZonTerriVepoOidValoEstrGeop + "|";
	parametros += jsZonTerriFecRtz + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonTerriFrm.accion'), 
		get('zonTerriFrm.origen'));
	
	jsZonTerriPaisOidPais = get('zonTerriFrm.paisOidPais')[0];
	jsZonTerriId = get('zonTerriFrm.id').toString();
	jsZonTerriCodTerr = get('zonTerriFrm.codTerr').toString();
	jsZonTerriCodNse1 = get('zonTerriFrm.codNse1').toString();
	jsZonTerriCodNse2 = get('zonTerriFrm.codNse2').toString();
	jsZonTerriCodNse3 = get('zonTerriFrm.codNse3').toString();
	jsZonTerriIndBorr = get('zonTerriFrm.indBorr').toString();
	jsZonTerriVepoOidValoEstrGeop = get('zonTerriFrm.vepoOidValoEstrGeop')[0];
	jsZonTerriFecRtz = get('zonTerriFrm.fecRtz').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonTerriFrm.accion'), 
		get('zonTerriFrm.origen'));


	set('zonTerriFrm.paisOidPais', [jsZonTerriPaisOidPais]);
	set('zonTerriFrm.id', jsZonTerriId);
	set('zonTerriFrm.codTerr', jsZonTerriCodTerr);
	set('zonTerriFrm.codNse1', jsZonTerriCodNse1);
	set('zonTerriFrm.codNse2', jsZonTerriCodNse2);
	set('zonTerriFrm.codNse3', jsZonTerriCodNse3);
	set('zonTerriFrm.indBorr', jsZonTerriIndBorr);
	set('zonTerriFrm.vepoOidValoEstrGeop', [jsZonTerriVepoOidValoEstrGeop]);
	set('zonTerriFrm.fecRtz', jsZonTerriFecRtz);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realziar la búsqueda
	jsZonTerriPaisOidPais = '';
	jsZonTerriCodTerr = '';
	jsZonTerriCodNse1 = '';
	jsZonTerriCodNse2 = '';
	jsZonTerriCodNse3 = '';
	jsZonTerriIndBorr = '';
	jsZonTerriVepoOidValoEstrGeop = '';
	jsZonTerriFecRtz = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('zonTerriFrm.errCodigo', errorCode);
	set('zonTerriFrm.errDescripcion', description);
	set('zonTerriFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	



/*
    INDRA/CAR/mmg
    $Id: zonterriadmin.js,v 1.1 2009/12/03 19:02:18 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsZonTerriAdminId = "";
var jsZonTerriAdminIndBorr = "";
var jsZonTerriAdminZsccOidSecc = "";
var jsZonTerriAdminTerrOidTerr = "";
var jsZonTerriAdminFecRtz = "";

//Variables de paginacion, 
var zonTerriAdminPageCount = 1;

//Varible de columna que representa el campo de choice
var zonTerriAdminChoiceColumn = 4;

//Flag de siguiente pagina;
var zonTerriAdminMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var zonTerriAdminTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 231;
var sizeFormView = 217;
var sizeFormUpdate = 217;

//Ultima busqueda realizada
var zonTerriAdminLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("zonTerriAdminFrm.fecRtz");','focaliza("zonTerriAdminFrm.fecRtz");','focaliza("zonTerriAdminFrm.fecRtz");','focaliza("zonTerriAdminFrm.fecRtz");','focaliza("zonTerriAdminFrm.fecRtz");','focaliza("zonTerriAdminFrm.fecRtz");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var zsccOidSeccDependeceMap = new Vector();
zsccOidSeccDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zsccOidSeccDependeceMap.agregar(['zsccOidSecc', padresTmp, '', 'ZonSecci']);
var terrOidTerrDependeceMap = new Vector();
terrOidTerrDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
terrOidTerrDependeceMap.agregar(['terrOidTerr', padresTmp, '', 'ZonTerri']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
zonTerriAdminLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var zonTerriAdminTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function zonTerriAdminInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('zonTerriAdminFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('zonTerriAdminFrm.accion')){
		case "query": zonTerriAdminQueryInitComponents(); break;
		case "view": zonTerriAdminViewInitComponents(); break;
		case "create": zonTerriAdminCreateInitComponents(); break;
		case "update": zonTerriAdminUpdateInitComponents(); break;
		case "remove": zonTerriAdminRemoveInitComponents(); break;
		case "lov": zonTerriAdminLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('zonTerriAdminFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('zonTerriAdmin')) zonTerriAdminCmdRequery();
}

function zonTerriAdminQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
}

function zonTerriAdminViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
}

function zonTerriAdminCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('zonTerriAdminFrm.zsccOidSecc','S', GestionarMensaje('ZonTerriAdmin.zsccOidSecc.requiered.message'));
	
	setMV('zonTerriAdminFrm.terrOidTerr','S', GestionarMensaje('ZonTerriAdmin.terrOidTerr.requiered.message'));
	
	setMV('zonTerriAdminFrm.fecRtz','S', GestionarMensaje('ZonTerriAdmin.fecRtz.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function zonTerriAdminUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('zonTerriAdminFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		zonTerriAdminTmpUpdateValues = zonTerriAdminBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('zonTerriAdminFrm.zsccOidSecc','S', GestionarMensaje('ZonTerriAdmin.zsccOidSecc.requiered.message'));
		setMV('zonTerriAdminFrm.terrOidTerr','S', GestionarMensaje('ZonTerriAdmin.terrOidTerr.requiered.message'));
		setMV('zonTerriAdminFrm.fecRtz','S', GestionarMensaje('ZonTerriAdmin.fecRtz.requiered.message'));
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('zonTerriAdminFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function zonTerriAdminRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	zonTerriAdminList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function zonTerriAdminLovInitComponents(){
	zonTerriAdminLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function zonTerriAdminSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('zonTerriAdminFrm.' + campo, id);
	set('zonTerriAdminFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function zonTerriAdminLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	zonTerriAdminLovReturnParameters.id = '';
	zonTerriAdminLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function zonTerriAdminLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonTerriAdminList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = zonTerriAdminList.codSeleccionados();
	var descripcion = zonTerriAdminList.extraeDato(
		zonTerriAdminList.codSeleccionados()[0], zonTerriAdminChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	zonTerriAdminLovReturnParameters.id = codigo;
	zonTerriAdminLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function zonTerriAdminCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('zonTerriAdminFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('zonTerriAdminFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "zonTerriAdminList", "ZonTerriAdminConectorTransactionQuery", 
		"result_ROWSET", parametros, "zonTerriAdminPostQueryActions(datos);"]], "", "");	
}

function zonTerriAdminCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('zonTerriAdminFrm.lastQueryToSession'));
	var i =0;
	set('zonTerriAdminFrm.indBorr', paramsRequery.ij(i++));
	
	set('zonTerriAdminFrm.zsccOidSecc', [paramsRequery.ij(i++)]);
	
	set('zonTerriAdminFrm.terrOidTerr', [paramsRequery.ij(i++)]);
	
	set('zonTerriAdminFrm.fecRtz', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	zonTerriAdminPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	zonTerriAdminCmdQuery(zonTerriAdminPageCount);
}

function zonTerriAdminFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	zonTerriAdminPageCount = 1;
	zonTerriAdminCmdQuery(zonTerriAdminPageCount);
}

function zonTerriAdminPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonTerriAdminLastQuery){
		zonTerriAdminFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	zonTerriAdminPageCount--;
	zonTerriAdminCmdQuery(zonTerriAdminPageCount);
}

function zonTerriAdminNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonTerriAdminLastQuery){
		zonTerriAdminFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	zonTerriAdminPageCount++;
	zonTerriAdminCmdQuery(zonTerriAdminPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function zonTerriAdminPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('zonTerriAdminListLayer', 'O');
		visibilidad('zonTerriAdminListButtonsLayer', 'O');
		if(get('zonTerriAdminFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	zonTerriAdminLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:zonTerriAdminViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, zonTerriAdminChoiceColumn) + "</A>",
			i, zonTerriAdminChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	zonTerriAdminList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	zonTerriAdminTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		zonTerriAdminMorePagesFlag = true;
		zonTerriAdminList.eliminar(mmgPageSize, 1);
	}else{
		zonTerriAdminMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('zonTerriAdminFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('zonTerriAdminListLayer', 'V');
	visibilidad('zonTerriAdminListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('zonTerriAdminList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	zonTerriAdminList.display();
	
	//Actualizamos el estado de los botones 
	if(zonTerriAdminMorePagesFlag){
		set_estado_botonera('zonTerriAdminPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('zonTerriAdminPaginationButtonBar',
			3,"inactivo");
	}
	if(zonTerriAdminPageCount > 1){
		set_estado_botonera('zonTerriAdminPaginationButtonBar',
			2,"activo");
		set_estado_botonera('zonTerriAdminPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('zonTerriAdminPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('zonTerriAdminPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function zonTerriAdminUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonTerriAdminList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('zonTerriAdminFrm.idSelection', zonTerriAdminList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('zonTerriAdminFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = zonTerriAdminList.codSeleccionados()[0];
		parametros["previousAction"] = get('zonTerriAdminFrm.accion');
		parametros["accion"] = get('zonTerriAdminFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('ZonTerriAdminLPStartUp', get('zonTerriAdminFrm.accion'), parametros, null, sizeFormView + 55);
		if(result == MMG_RC_OK) zonTerriAdminCmdRequery();
	}
}

function zonTerriAdminRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonTerriAdminList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = zonTerriAdminList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('zonTerriAdminFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(zonTerriAdminList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += zonTerriAdminTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('zonTerriAdminFrm.timestamp', timestamps);


	zonTerriAdminFrm.oculto='S';
	envia('zonTerriAdminFrm');
	zonTerriAdminFrm.oculto='N';
}

function zonTerriAdminViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonTerriAdminList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	zonTerriAdminViewDetail(zonTerriAdminList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function zonTerriAdminViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('zonTerriAdminFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	mostrarModalSICC('ZonTerriAdminLPStartUp', 'view', parametros, null, sizeFormView + 55);
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
	var validacion = ValidaForm('zonTerriAdminFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
		
	
	if(validacion){
		zonTerriAdminFrm.oculto='S';
		envia('zonTerriAdminFrm');
		zonTerriAdminFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('zonTerriAdminFrm.zsccOidSecc').toString() == ''){
		set('zonTerriAdminFrm.zsccOidSecc', []);
		mmgResetCombosOnCascade('zsccOidSecc', 'zsccOidSecc', 'zonTerriAdmin');
		
	}
	if(get('zonTerriAdminFrm.terrOidTerr').toString() == ''){
		set('zonTerriAdminFrm.terrOidTerr', []);
		mmgResetCombosOnCascade('terrOidTerr', 'terrOidTerr', 'zonTerriAdmin');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	zonTerriAdminRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('zonTerriAdminFrm.accion');
	var origenTmp = get('zonTerriAdminFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(zonTerriAdminBuildUpdateRecordString() != zonTerriAdminTmpUpdateValues){
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
	document.all.zonTerriAdminListLayer.style.display='none';
	document.all.zonTerriAdminListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.zonTerriAdminListLayer.style.display='';
	document.all.zonTerriAdminListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsZonTerriAdminIndBorr = get('zonTerriAdminFrm.indBorr').toString();
	jsZonTerriAdminZsccOidSecc = get('zonTerriAdminFrm.zsccOidSecc')[0];
	jsZonTerriAdminTerrOidTerr = get('zonTerriAdminFrm.terrOidTerr')[0];
	jsZonTerriAdminFecRtz = get('zonTerriAdminFrm.fecRtz').toString();
	
	
	var parametros = "";
	parametros += jsZonTerriAdminIndBorr + "|";
	parametros += jsZonTerriAdminZsccOidSecc + "|";
	parametros += jsZonTerriAdminTerrOidTerr + "|";
	parametros += jsZonTerriAdminFecRtz + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function zonTerriAdminBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsZonTerriAdminIndBorr + "|";
	parametros += jsZonTerriAdminZsccOidSecc + "|";
	parametros += jsZonTerriAdminTerrOidTerr + "|";
	parametros += jsZonTerriAdminFecRtz + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonTerriAdminFrm.accion'), 
		get('zonTerriAdminFrm.origen'));
	
	jsZonTerriAdminId = get('zonTerriAdminFrm.id').toString();
	jsZonTerriAdminIndBorr = get('zonTerriAdminFrm.indBorr').toString();
	jsZonTerriAdminZsccOidSecc = get('zonTerriAdminFrm.zsccOidSecc')[0];
	jsZonTerriAdminTerrOidTerr = get('zonTerriAdminFrm.terrOidTerr')[0];
	jsZonTerriAdminFecRtz = get('zonTerriAdminFrm.fecRtz').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonTerriAdminFrm.accion'), 
		get('zonTerriAdminFrm.origen'));


	set('zonTerriAdminFrm.id', jsZonTerriAdminId);
	set('zonTerriAdminFrm.indBorr', jsZonTerriAdminIndBorr);
	set('zonTerriAdminFrm.zsccOidSecc', [jsZonTerriAdminZsccOidSecc]);
	set('zonTerriAdminFrm.terrOidTerr', [jsZonTerriAdminTerrOidTerr]);
	set('zonTerriAdminFrm.fecRtz', jsZonTerriAdminFecRtz);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realziar la búsqueda
	jsZonTerriAdminIndBorr = '';
	jsZonTerriAdminZsccOidSecc = '';
	jsZonTerriAdminTerrOidTerr = '';
	jsZonTerriAdminFecRtz = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('zonTerriAdminFrm.errCodigo', errorCode);
	set('zonTerriAdminFrm.errDescripcion', description);
	set('zonTerriAdminFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	

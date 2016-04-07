

/*
    INDRA/CAR/mmg
    $Id: ccctipotrans.js,v 1.1 2009/12/03 19:01:57 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCccTipoTransId = "";
var jsCccTipoTransPaisOidPais = "";
var jsCccTipoTransCodTipoTran = "";
var jsCccTipoTransDescripcion = "";
var jsCccTipoTransCodTipoTranCheq = "";

//Variables de paginacion, 
var cccTipoTransPageCount = 1;

//Varible de columna que representa el campo de choice
var cccTipoTransChoiceColumn = 1;

//Flag de siguiente pagina;
var cccTipoTransMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cccTipoTransTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var cccTipoTransLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focaliza("cccTipoTransFrm.codTipoTran");','focaliza("cccTipoTransFrm.codTipoTran");','focaliza("cccTipoTransFrm.codTipoTran");','focaliza("cccTipoTransFrm.codTipoTran");','focaliza("cccTipoTransFrm.codTipoTran");','focaliza("cccTipoTransFrm.codTipoTran");'],[4,'focaliza("cccTipoTransFrm.Descripcion");','focaliza("cccTipoTransFrm.Descripcion");','focaliza("cccTipoTransFrm.Descripcion");','focaliza("cccTipoTransFrm.Descripcion");','focaliza("cccTipoTransFrm.Descripcion");','focaliza("cccTipoTransFrm.Descripcion");'],[5,'focaliza("cccTipoTransFrm.codTipoTranCheq");','focaliza("cccTipoTransFrm.codTipoTranCheq");','focaliza("cccTipoTransFrm.codTipoTranCheq");','focaliza("cccTipoTransFrm.codTipoTranCheq");','focaliza("cccTipoTransFrm.codTipoTranCheq");','focaliza("cccTipoTransFrm.codTipoTranCheq");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'','','','','',''],[4,'focaliza("cccTipoTransFrm.Descripcion");','focaliza("cccTipoTransFrm.Descripcion");','focaliza("cccTipoTransFrm.Descripcion");','focaliza("cccTipoTransFrm.Descripcion");','focaliza("cccTipoTransFrm.Descripcion");','focaliza("cccTipoTransFrm.Descripcion");'],[5,'focaliza("cccTipoTransFrm.codTipoTranCheq");','focaliza("cccTipoTransFrm.codTipoTranCheq");','focaliza("cccTipoTransFrm.codTipoTranCheq");','focaliza("cccTipoTransFrm.codTipoTranCheq");','focaliza("cccTipoTransFrm.codTipoTranCheq");','focaliza("cccTipoTransFrm.codTipoTranCheq");']]);

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
cccTipoTransLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var cccTipoTransTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function cccTipoTransInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('cccTipoTransFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('cccTipoTransFrm.accion')){
		case "query": cccTipoTransQueryInitComponents(); break;
		case "view": cccTipoTransViewInitComponents(); break;
		case "create": cccTipoTransCreateInitComponents(); break;
		case "update": cccTipoTransUpdateInitComponents(); break;
		case "remove": cccTipoTransRemoveInitComponents(); break;
		case "lov": cccTipoTransLovInitComponents(); break;
	}
	//alert('accion :' + get('cccTipoTransFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('cccTipoTransFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cccTipoTrans')) cccTipoTransCmdRequery();
}

function cccTipoTransQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('cccTipoTransFrm', true);	
}

function cccTipoTransViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('cccTipoTransFrm', 'Descripcion', 1);
	
		
	//Establecemos el valor de los radiobuttons
		set('cccTipoTransFrm.codTipoTranCheq', get('cccTipoTransFrm.codTipoTranCheqCheckValue'));
		
	focusFirstField('cccTipoTransFrm', true);
}

function cccTipoTransCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cccTipoTransFrm.codTipoTran','S', GestionarMensaje('CccTipoTrans.codTipoTran.requiered.message'));
	
	setMV('cccTipoTransFrm.Descripcion','S', GestionarMensaje('CccTipoTrans.Descripcion.requiered.message'));
	
	setMV('cccTipoTransFrm.codTipoTranCheq','S', GestionarMensaje('CccTipoTrans.codTipoTranCheq.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('cccTipoTransFrm', true);
}

function cccTipoTransUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('cccTipoTransFrm.origen') == "pagina"){
		loadLocalizationWidget('cccTipoTransFrm', 'Descripcion', 1);
		

		//Establecemos el valor de los radiobuttons
			set('cccTipoTransFrm.codTipoTranCheq', get('cccTipoTransFrm.codTipoTranCheqCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		cccTipoTransTmpUpdateValues = cccTipoTransBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cccTipoTransFrm.codTipoTran','S', GestionarMensaje('CccTipoTrans.codTipoTran.requiered.message'));
		setMV('cccTipoTransFrm.Descripcion','S', GestionarMensaje('CccTipoTrans.Descripcion.requiered.message'));
		setMV('cccTipoTransFrm.codTipoTranCheq','S', GestionarMensaje('CccTipoTrans.codTipoTranCheq.requiered.message'));
		
			focusFirstFieldModify('cccTipoTransFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('cccTipoTransFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('cccTipoTransFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cccTipoTransRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	cccTipoTransList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('cccTipoTransFrm', true);
}

function cccTipoTransLovInitComponents(){
	cccTipoTransLovReturnParameters = window.dialogArguments;
	
	focusFirstField('cccTipoTransFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function cccTipoTransSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cccTipoTransFrm.' + campo, id);
	set('cccTipoTransFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function cccTipoTransLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cccTipoTransLovReturnParameters.id = '';
	cccTipoTransLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cccTipoTransLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccTipoTransList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cccTipoTransList.codSeleccionados();
	var descripcion = cccTipoTransList.extraeDato(
		cccTipoTransList.codSeleccionados()[0], cccTipoTransChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cccTipoTransLovReturnParameters.id = codigo;
	cccTipoTransLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function cccTipoTransCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cccTipoTransFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('cccTipoTransFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cccTipoTransList", "CccTipoTransConectorTransactionQuery", 
		"result_ROWSET", parametros, "cccTipoTransPostQueryActions(datos);"]], "", "");	
}

function cccTipoTransCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cccTipoTransFrm.lastQueryToSession'));
	var i =0;
	set('cccTipoTransFrm.codTipoTran', paramsRequery.ij(i++));
	
	set('cccTipoTransFrm.Descripcion', paramsRequery.ij(i++));
	
	set('cccTipoTransFrm.codTipoTranCheq', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	cccTipoTransPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cccTipoTransCmdQuery(cccTipoTransPageCount);
}

function cccTipoTransFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cccTipoTransPageCount = 1;
	cccTipoTransCmdQuery(cccTipoTransPageCount);
}

function cccTipoTransPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cccTipoTransLastQuery){
		cccTipoTransFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cccTipoTransPageCount--;
	cccTipoTransCmdQuery(cccTipoTransPageCount);
}

function cccTipoTransNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cccTipoTransLastQuery){
		cccTipoTransFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cccTipoTransPageCount++;
	cccTipoTransCmdQuery(cccTipoTransPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cccTipoTransPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cccTipoTransListLayer', 'O');
		visibilidad('cccTipoTransListButtonsLayer', 'O');
		if(get('cccTipoTransFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	cccTipoTransLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 3)){
			case 'S': datosTmp.ij2(GestionarMensaje('CccTipoTrans.codTipoTranCheq.S.value'), i, 3); break;
			case 'N': datosTmp.ij2(GestionarMensaje('CccTipoTrans.codTipoTranCheq.N.value'), i, 3); break;
			default: datosTmp .ij2('', i, 3);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:cccTipoTransViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cccTipoTransChoiceColumn) + "</A>",
			i, cccTipoTransChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cccTipoTransList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	cccTipoTransTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		cccTipoTransMorePagesFlag = true;
		cccTipoTransList.eliminar(mmgPageSize, 1);
	}else{
		cccTipoTransMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('cccTipoTransFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cccTipoTransListLayer', 'V');
	visibilidad('cccTipoTransListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cccTipoTransList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cccTipoTransList.display();
	
	//Actualizamos el estado de los botones 
	if(cccTipoTransMorePagesFlag){
		set_estado_botonera('cccTipoTransPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cccTipoTransPaginationButtonBar',
			3,"inactivo");
	}
	if(cccTipoTransPageCount > 1){
		set_estado_botonera('cccTipoTransPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cccTipoTransPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cccTipoTransPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cccTipoTransPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cccTipoTransUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccTipoTransList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cccTipoTransFrm.idSelection', cccTipoTransList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('cccTipoTransFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = cccTipoTransList.codSeleccionados()[0];
		parametros["previousAction"] = get('cccTipoTransFrm.accion');
		parametros["accion"] = get('cccTipoTransFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CccTipoTransLPStartUp', get('cccTipoTransFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) cccTipoTransCmdRequery();
	}
}

function cccTipoTransRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccTipoTransList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cccTipoTransList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cccTipoTransFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cccTipoTransList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cccTipoTransTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cccTipoTransFrm.timestamp', timestamps);


	cccTipoTransFrm.oculto='S';
	envia('cccTipoTransFrm');
	cccTipoTransFrm.oculto='N';
}

function cccTipoTransViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccTipoTransList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	cccTipoTransViewDetail(cccTipoTransList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function cccTipoTransViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cccTipoTransFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CccTipoTransLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('cccTipoTransFrm', 
		'Descripcion', 1,
		get('cccTipoTransFrm.Descripcion'));	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('cccTipoTransFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('cccTipoTransFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('CccTipoTrans.Descripcion.requiered.message'));
		focaliza('cccTipoTransFrm.Descripcion');
		return;
	}	
	
	
		
	
	if(validacion){
		cccTipoTransFrm.oculto='S';
		envia('cccTipoTransFrm');
		cccTipoTransFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('cccTipoTransFrm.paisOidPais').toString() == ''){
		set('cccTipoTransFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'cccTipoTrans');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	cccTipoTransRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('cccTipoTransFrm.accion');
	var origenTmp = get('cccTipoTransFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cccTipoTransBuildUpdateRecordString() != cccTipoTransTmpUpdateValues){
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
	document.all.cccTipoTransListLayer.style.display='none';
	document.all.cccTipoTransListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cccTipoTransListLayer.style.display='';
	document.all.cccTipoTransListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCccTipoTransCodTipoTran = get('cccTipoTransFrm.codTipoTran').toString();
	jsCccTipoTransDescripcion = get('cccTipoTransFrm.Descripcion').toString();
	jsCccTipoTransCodTipoTranCheq = get('cccTipoTransFrm.codTipoTranCheq');
	
	
	var parametros = "";
	parametros += jsCccTipoTransCodTipoTran + "|";
	parametros += jsCccTipoTransDescripcion + "|";
	parametros += jsCccTipoTransCodTipoTranCheq + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cccTipoTransBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCccTipoTransCodTipoTran + "|";
	parametros += jsCccTipoTransDescripcion + "|";
	parametros += jsCccTipoTransCodTipoTranCheq + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cccTipoTransFrm.accion'), 
		get('cccTipoTransFrm.origen'));
	
	jsCccTipoTransId = get('cccTipoTransFrm.id').toString();
	jsCccTipoTransPaisOidPais = get('cccTipoTransFrm.paisOidPais')[0];
	jsCccTipoTransCodTipoTran = get('cccTipoTransFrm.codTipoTran').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsCccTipoTransDescripcion = buildLocalizedString('cccTipoTransFrm', 1);
	}else{
		jsCccTipoTransDescripcion = get('cccTipoTransFrm.Descripcion');
	}
	jsCccTipoTransCodTipoTranCheq = get('cccTipoTransFrm.codTipoTranCheq');
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cccTipoTransFrm.accion'), 
		get('cccTipoTransFrm.origen'));


	set('cccTipoTransFrm.id', jsCccTipoTransId);
	set('cccTipoTransFrm.paisOidPais', [jsCccTipoTransPaisOidPais]);
	set('cccTipoTransFrm.codTipoTran', jsCccTipoTransCodTipoTran);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('cccTipoTransFrm', 1,  jsCccTipoTransDescripcion)
		loadLocalizationWidget('cccTipoTransFrm', 'Descripcion', 1);
	}else{
		set('cccTipoTransFrm.Descripcion', jsCccTipoTransDescripcion);		
	}
	set('cccTipoTransFrm.codTipoTranCheq', jsCccTipoTransCodTipoTranCheq);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCccTipoTransCodTipoTran = '';
	jsCccTipoTransDescripcion = '';
	jsCccTipoTransCodTipoTranCheq = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cccTipoTransFrm.errCodigo', errorCode);
	set('cccTipoTransFrm.errDescripcion', description);
	set('cccTipoTransFrm.errSeverity', severity);
	fMostrarMensajeError();
}

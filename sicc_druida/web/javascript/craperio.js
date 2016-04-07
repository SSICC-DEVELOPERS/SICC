

/*
    INDRA/CAR/mmg
    $Id: craperio.js,v 1.1 2009/12/03 19:01:56 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCraPerioId = "";
var jsCraPerioMarcOidMarc = "";
var jsCraPerioCanaOidCana = "";
var jsCraPerioPaisOidPais = "";
var jsCraPerioAcceOidAcce = "";
var jsCraPerioPeriOidPeri = "";
var jsCraPerioFecInic = "";
var jsCraPerioFecFina = "";
var jsCraPerioValEsta = "";
var jsCraPerioValNombPeri = "";
var jsCraPerioIndPeriCort = "";
var jsCraPerioIndPeriCruc = "";

//Variables de paginacion, 
var craPerioPageCount = 1;

//Varible de columna que representa el campo de choice
var craPerioChoiceColumn = 11;

//Flag de siguiente pagina;
var craPerioMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var craPerioTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 525;
var sizeFormView = 531;
var sizeFormUpdate = 531;

//Ultima busqueda realizada
var craPerioLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("craPerioFrm.indPeriCruc");','focaliza("craPerioFrm.indPeriCruc");','focaliza("craPerioFrm.indPeriCruc");','focaliza("craPerioFrm.indPeriCruc");','focaliza("craPerioFrm.indPeriCruc");','focaliza("craPerioFrm.indPeriCruc");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[0,'focaliza("craPerioFrm.indPeriCruc");','focaliza("craPerioFrm.indPeriCruc");','focaliza("craPerioFrm.indPeriCruc");','focaliza("craPerioFrm.indPeriCruc");','focaliza("craPerioFrm.indPeriCruc");','focaliza("craPerioFrm.indPeriCruc");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var marcOidMarcDependeceMap = new Vector();
marcOidMarcDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
marcOidMarcDependeceMap.agregar(['marcOidMarc', padresTmp, '', 'SegMarca']);
var canaOidCanaDependeceMap = new Vector();
canaOidCanaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
canaOidCanaDependeceMap.agregar(['canaOidCana_tipeOidTipoPeri', padresTmp, 'canaOidCana', 'SegTipoPerio']);
padresTmp =  new Vector();
padresTmp.cargar(['canaOidCana_tipeOidTipoPeri'])
canaOidCanaDependeceMap.agregar(['canaOidCana', padresTmp, '', 'SegCanal']);
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
var acceOidAcceDependeceMap = new Vector();
acceOidAcceDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
acceOidAcceDependeceMap.agregar(['acceOidAcce_canaOidCana', padresTmp, 'acceOidAcce', 'SegCanalView']);
padresTmp =  new Vector();
padresTmp.cargar(['acceOidAcce_canaOidCana'])
acceOidAcceDependeceMap.agregar(['acceOidAcce', padresTmp, '', 'SegAcces']);
var periOidPeriDependeceMap = new Vector();
periOidPeriDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
periOidPeriDependeceMap.agregar(['periOidPeri_tipeOidTipoPeri', padresTmp, 'periOidPeri', 'SegTipoPerio']);
padresTmp =  new Vector();
padresTmp.cargar(['periOidPeri_tipeOidTipoPeri'])
periOidPeriDependeceMap.agregar(['periOidPeri', padresTmp, '', 'SegPerioCorpo']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
craPerioLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var craPerioTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function craPerioInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('craPerioFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('craPerioFrm.accion')){
		case "query": craPerioQueryInitComponents(); break;
		case "view": craPerioViewInitComponents(); break;
		case "create": craPerioCreateInitComponents(); break;
		case "update": craPerioUpdateInitComponents(); break;
		case "remove": craPerioRemoveInitComponents(); break;
		case "lov": craPerioLovInitComponents(); break;
	}
	//alert('accion :' + get('craPerioFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('craPerioFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('craPerio')) craPerioCmdRequery();
}

function craPerioQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	focusFirstField('craPerioFrm', true);	
}

function craPerioViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('craPerioFrm', true);
}

function craPerioCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('craPerioFrm.marcOidMarc','S', GestionarMensaje('CraPerio.marcOidMarc.requiered.message'));
	
	setMV('craPerioFrm.canaOidCana','S', GestionarMensaje('CraPerio.canaOidCana.requiered.message'));
	
	setMV('craPerioFrm.paisOidPais','S', GestionarMensaje('CraPerio.paisOidPais.requiered.message'));
	
	setMV('craPerioFrm.periOidPeri','S', GestionarMensaje('CraPerio.periOidPeri.requiered.message'));
	
	setMV('craPerioFrm.fecInic','S', GestionarMensaje('CraPerio.fecInic.requiered.message'));
	
	setMV('craPerioFrm.fecFina','S', GestionarMensaje('CraPerio.fecFina.requiered.message'));
	
	setMV('craPerioFrm.valEsta','S', GestionarMensaje('CraPerio.valEsta.requiered.message'));
	
	setMV('craPerioFrm.valNombPeri','S', GestionarMensaje('CraPerio.valNombPeri.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('craPerioFrm', true);
}

function craPerioUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('craPerioFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		craPerioTmpUpdateValues = craPerioBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('craPerioFrm.marcOidMarc','S', GestionarMensaje('CraPerio.marcOidMarc.requiered.message'));
		setMV('craPerioFrm.canaOidCana','S', GestionarMensaje('CraPerio.canaOidCana.requiered.message'));
		setMV('craPerioFrm.paisOidPais','S', GestionarMensaje('CraPerio.paisOidPais.requiered.message'));
		setMV('craPerioFrm.periOidPeri','S', GestionarMensaje('CraPerio.periOidPeri.requiered.message'));
		setMV('craPerioFrm.fecInic','S', GestionarMensaje('CraPerio.fecInic.requiered.message'));
		setMV('craPerioFrm.fecFina','S', GestionarMensaje('CraPerio.fecFina.requiered.message'));
		setMV('craPerioFrm.valEsta','S', GestionarMensaje('CraPerio.valEsta.requiered.message'));
		setMV('craPerioFrm.valNombPeri','S', GestionarMensaje('CraPerio.valNombPeri.requiered.message'));
		
			focusFirstFieldModify('craPerioFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		focusFirstField('craPerioFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('craPerioFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function craPerioRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	craPerioList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('craPerioFrm', true);
}

function craPerioLovInitComponents(){
	craPerioLovReturnParameters = window.dialogArguments;
	
	focusFirstField('craPerioFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad














//Función que permite cargar los datos de un elemento de lov seleccionado
function craPerioSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('craPerioFrm.' + campo, id);
	set('craPerioFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function craPerioLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	craPerioLovReturnParameters.id = '';
	craPerioLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function craPerioLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(craPerioList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = craPerioList.codSeleccionados();
	var descripcion = craPerioList.extraeDato(
		craPerioList.codSeleccionados()[0], craPerioChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	craPerioLovReturnParameters.id = codigo;
	craPerioLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function craPerioCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('craPerioFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('craPerioFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "craPerioList", "CraPerioConectorTransactionQuery", 
		"result_ROWSET", parametros, "craPerioPostQueryActions(datos);"]], "", "");	
}

function craPerioCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('craPerioFrm.lastQueryToSession'));
	var i =0;
	set('craPerioFrm.marcOidMarc', [paramsRequery.ij(i++)]);
	
	set('craPerioFrm.canaOidCana', [paramsRequery.ij(i++)]);
	
	set('craPerioFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('craPerioFrm.acceOidAcce', [paramsRequery.ij(i++)]);
	
	set('craPerioFrm.periOidPeri', [paramsRequery.ij(i++)]);
	
	set('craPerioFrm.fecInic', paramsRequery.ij(i++));
	
	set('craPerioFrm.fecFina', paramsRequery.ij(i++));
	
	set('craPerioFrm.valEsta', paramsRequery.ij(i++));
	
	set('craPerioFrm.valNombPeri', paramsRequery.ij(i++));
	
	set('craPerioFrm.indPeriCort', paramsRequery.ij(i++));
	
	set('craPerioFrm.indPeriCruc', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	craPerioPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	craPerioCmdQuery(craPerioPageCount);
}

function craPerioFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	craPerioPageCount = 1;
	craPerioCmdQuery(craPerioPageCount);
}

function craPerioPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != craPerioLastQuery){
		craPerioFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	craPerioPageCount--;
	craPerioCmdQuery(craPerioPageCount);
}

function craPerioNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != craPerioLastQuery){
		craPerioFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	craPerioPageCount++;
	craPerioCmdQuery(craPerioPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function craPerioPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('craPerioListLayer', 'O');
		visibilidad('craPerioListButtonsLayer', 'O');
		if(get('craPerioFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	craPerioLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:craPerioViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, craPerioChoiceColumn) + "</A>",
			i, craPerioChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	craPerioList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10,11],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	craPerioTimeStamps = datosTmp.filtrar([12],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		craPerioMorePagesFlag = true;
		craPerioList.eliminar(mmgPageSize, 1);
	}else{
		craPerioMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('craPerioFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('craPerioListLayer', 'V');
	visibilidad('craPerioListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('craPerioList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	craPerioList.display();
	
	//Actualizamos el estado de los botones 
	if(craPerioMorePagesFlag){
		set_estado_botonera('craPerioPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('craPerioPaginationButtonBar',
			3,"inactivo");
	}
	if(craPerioPageCount > 1){
		set_estado_botonera('craPerioPaginationButtonBar',
			2,"activo");
		set_estado_botonera('craPerioPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('craPerioPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('craPerioPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function craPerioUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(craPerioList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('craPerioFrm.idSelection', craPerioList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('craPerioFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = craPerioList.codSeleccionados()[0];
		parametros["previousAction"] = get('craPerioFrm.accion');
		parametros["accion"] = get('craPerioFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CraPerioLPStartUp', get('craPerioFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) craPerioCmdRequery();
	}
}

function craPerioRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(craPerioList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = craPerioList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('craPerioFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(craPerioList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += craPerioTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('craPerioFrm.timestamp', timestamps);


	craPerioFrm.oculto='S';
	envia('craPerioFrm');
	craPerioFrm.oculto='N';
}

function craPerioViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(craPerioList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	craPerioViewDetail(craPerioList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function craPerioViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('craPerioFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CraPerioLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('craPerioFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		craPerioFrm.oculto='S';
		envia('craPerioFrm');
		craPerioFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('craPerioFrm.marcOidMarc').toString() == ''){
		set('craPerioFrm.marcOidMarc', []);
		mmgResetCombosOnCascade('marcOidMarc', 'marcOidMarc', 'craPerio');
		
	}
	if(get('craPerioFrm.canaOidCana').toString() == ''){
		set('craPerioFrm.canaOidCana_tipeOidTipoPeri', []);
		mmgResetCombosOnCascade('canaOidCana_tipeOidTipoPeri', 'canaOidCana', 'craPerio');
		
	}
	if(get('craPerioFrm.paisOidPais').toString() == ''){
		set('craPerioFrm.paisOidPais_moneOidMone', []);
		mmgResetCombosOnCascade('paisOidPais_moneOidMone', 'paisOidPais', 'craPerio');
		set('craPerioFrm.paisOidPais_moneOidMoneAlt', []);
		mmgResetCombosOnCascade('paisOidPais_moneOidMoneAlt', 'paisOidPais', 'craPerio');
		set('craPerioFrm.paisOidPais_fopaOidFormPago', []);
		mmgResetCombosOnCascade('paisOidPais_fopaOidFormPago', 'paisOidPais', 'craPerio');
		
	}
	if(get('craPerioFrm.acceOidAcce').toString() == ''){
		set('craPerioFrm.acceOidAcce_canaOidCana', []);
		mmgResetCombosOnCascade('acceOidAcce_canaOidCana', 'acceOidAcce', 'craPerio');
		
	}
	if(get('craPerioFrm.periOidPeri').toString() == ''){
		set('craPerioFrm.periOidPeri_tipeOidTipoPeri', []);
		mmgResetCombosOnCascade('periOidPeri_tipeOidTipoPeri', 'periOidPeri', 'craPerio');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	craPerioRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('craPerioFrm.accion');
	var origenTmp = get('craPerioFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(craPerioBuildUpdateRecordString() != craPerioTmpUpdateValues){
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
	document.all.craPerioListLayer.style.display='none';
	document.all.craPerioListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.craPerioListLayer.style.display='';
	document.all.craPerioListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCraPerioMarcOidMarc = get('craPerioFrm.marcOidMarc')[0];
	jsCraPerioCanaOidCana = get('craPerioFrm.canaOidCana')[0];
	jsCraPerioPaisOidPais = get('craPerioFrm.paisOidPais')[0];
	jsCraPerioAcceOidAcce = get('craPerioFrm.acceOidAcce')[0];
	jsCraPerioPeriOidPeri = get('craPerioFrm.periOidPeri')[0];
	jsCraPerioFecInic = get('craPerioFrm.fecInic').toString();
	jsCraPerioFecFina = get('craPerioFrm.fecFina').toString();
	jsCraPerioValEsta = get('craPerioFrm.valEsta').toString();
	jsCraPerioValNombPeri = get('craPerioFrm.valNombPeri').toString();
	jsCraPerioIndPeriCort = get('craPerioFrm.indPeriCort').toString();
	jsCraPerioIndPeriCruc = get('craPerioFrm.indPeriCruc').toString();
	
	
	var parametros = "";
	parametros += jsCraPerioMarcOidMarc + "|";
	parametros += jsCraPerioCanaOidCana + "|";
	parametros += jsCraPerioPaisOidPais + "|";
	parametros += jsCraPerioAcceOidAcce + "|";
	parametros += jsCraPerioPeriOidPeri + "|";
	parametros += jsCraPerioFecInic + "|";
	parametros += jsCraPerioFecFina + "|";
	parametros += jsCraPerioValEsta + "|";
	parametros += jsCraPerioValNombPeri + "|";
	parametros += jsCraPerioIndPeriCort + "|";
	parametros += jsCraPerioIndPeriCruc + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function craPerioBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCraPerioMarcOidMarc + "|";
	parametros += jsCraPerioCanaOidCana + "|";
	parametros += jsCraPerioPaisOidPais + "|";
	parametros += jsCraPerioAcceOidAcce + "|";
	parametros += jsCraPerioPeriOidPeri + "|";
	parametros += jsCraPerioFecInic + "|";
	parametros += jsCraPerioFecFina + "|";
	parametros += jsCraPerioValEsta + "|";
	parametros += jsCraPerioValNombPeri + "|";
	parametros += jsCraPerioIndPeriCort + "|";
	parametros += jsCraPerioIndPeriCruc + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('craPerioFrm.accion'), 
		get('craPerioFrm.origen'));
	
	jsCraPerioId = get('craPerioFrm.id').toString();
	jsCraPerioMarcOidMarc = get('craPerioFrm.marcOidMarc')[0];
	jsCraPerioCanaOidCana = get('craPerioFrm.canaOidCana')[0];
	jsCraPerioPaisOidPais = get('craPerioFrm.paisOidPais')[0];
	jsCraPerioAcceOidAcce = get('craPerioFrm.acceOidAcce')[0];
	jsCraPerioPeriOidPeri = get('craPerioFrm.periOidPeri')[0];
	jsCraPerioFecInic = get('craPerioFrm.fecInic').toString();
	jsCraPerioFecFina = get('craPerioFrm.fecFina').toString();
	jsCraPerioValEsta = get('craPerioFrm.valEsta').toString();
	jsCraPerioValNombPeri = get('craPerioFrm.valNombPeri').toString();
	jsCraPerioIndPeriCort = get('craPerioFrm.indPeriCort').toString();
	jsCraPerioIndPeriCruc = get('craPerioFrm.indPeriCruc').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('craPerioFrm.accion'), 
		get('craPerioFrm.origen'));


	set('craPerioFrm.id', jsCraPerioId);
	set('craPerioFrm.marcOidMarc', [jsCraPerioMarcOidMarc]);
	set('craPerioFrm.canaOidCana', [jsCraPerioCanaOidCana]);
	set('craPerioFrm.paisOidPais', [jsCraPerioPaisOidPais]);
	set('craPerioFrm.acceOidAcce', [jsCraPerioAcceOidAcce]);
	set('craPerioFrm.periOidPeri', [jsCraPerioPeriOidPeri]);
	set('craPerioFrm.fecInic', jsCraPerioFecInic);
	set('craPerioFrm.fecFina', jsCraPerioFecFina);
	set('craPerioFrm.valEsta', jsCraPerioValEsta);
	set('craPerioFrm.valNombPeri', jsCraPerioValNombPeri);
	set('craPerioFrm.indPeriCort', jsCraPerioIndPeriCort);
	set('craPerioFrm.indPeriCruc', jsCraPerioIndPeriCruc);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCraPerioMarcOidMarc = '';
	jsCraPerioCanaOidCana = '';
	jsCraPerioPaisOidPais = '';
	jsCraPerioAcceOidAcce = '';
	jsCraPerioPeriOidPeri = '';
	jsCraPerioFecInic = '';
	jsCraPerioFecFina = '';
	jsCraPerioValEsta = '';
	jsCraPerioValNombPeri = '';
	jsCraPerioIndPeriCort = '';
	jsCraPerioIndPeriCruc = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('craPerioFrm.errCodigo', errorCode);
	set('craPerioFrm.errDescripcion', description);
	set('craPerioFrm.errSeverity', severity);
	fMostrarMensajeError();
}



/*
    INDRA/CAR/mmg
    $Id: maeclien.js,v 1.1 2009/12/03 19:01:45 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeClienId = "";
var jsMaeClienCodClie = "";
var jsMaeClienIndFichInsc = "";
var jsMaeClienPaisOidPais = "";
var jsMaeClienCodDigiCtrl = "";
var jsMaeClienValApe1 = "";
var jsMaeClienValApe2 = "";
var jsMaeClienValNom1 = "";
var jsMaeClienValNom2 = "";
var jsMaeClienValTrat = "";
var jsMaeClienValCritBus1 = "";
var jsMaeClienValCritBus2 = "";
var jsMaeClienCodSexo = "";
var jsMaeClienFecIngr = "";
var jsMaeClienFopaOidFormPago = "";
var jsMaeClienValApelCasa = "";

//Variables de paginacion, 
var maeClienPageCount = 1;

//Varible de columna que representa el campo de choice
var maeClienChoiceColumn = 0;

//Flag de siguiente pagina;
var maeClienMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeClienTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 693;
var sizeFormView = 675;
var sizeFormUpdate = 675;

//Ultima busqueda realizada
var maeClienLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("maeClienFrm.valApelCasa");','focaliza("maeClienFrm.valApelCasa");','focaliza("maeClienFrm.valApelCasa");','focaliza("maeClienFrm.valApelCasa");','focaliza("maeClienFrm.valApelCasa");','focaliza("maeClienFrm.valApelCasa");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[0,'focaliza("maeClienFrm.valApelCasa");','focaliza("maeClienFrm.valApelCasa");','focaliza("maeClienFrm.valApelCasa");','focaliza("maeClienFrm.valApelCasa");','focaliza("maeClienFrm.valApelCasa");','focaliza("maeClienFrm.valApelCasa");']]);

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
paisOidPaisDependeceMap.agregar(['paisOidPais_moneOidMoneAlt', padresTmp, 'paisOidPais', 'SegMoned']);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_moneOidMone', padresTmp, 'paisOidPais', 'SegMoned']);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_fopaOidFormPago', padresTmp, 'paisOidPais', 'BelFormaPagoTapon']);
padresTmp =  new Vector();
padresTmp.cargar(['paisOidPais_moneOidMoneAlt','paisOidPais_moneOidMone','paisOidPais_fopaOidFormPago'])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPais']);
var fopaOidFormPagoDependeceMap = new Vector();
fopaOidFormPagoDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
fopaOidFormPagoDependeceMap.agregar(['fopaOidFormPago', padresTmp, '', 'BelFormaPagoTapon']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeClienLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeClienTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeClienInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeClienFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeClienFrm.accion')){
		case "query": maeClienQueryInitComponents(); break;
		case "view": maeClienViewInitComponents(); break;
		case "create": maeClienCreateInitComponents(); break;
		case "update": maeClienUpdateInitComponents(); break;
		case "remove": maeClienRemoveInitComponents(); break;
		case "lov": maeClienLovInitComponents(); break;
	}
	//alert('accion :' + get('maeClienFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeClienFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeClien')) maeClienCmdRequery();
}

function maeClienQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	focusFirstField('maeClienFrm', true);	
}

function maeClienViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('maeClienFrm', true);
}

function maeClienCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeClienFrm.codClie','S', GestionarMensaje('MaeClien.codClie.requiered.message'));
	
	setMV('maeClienFrm.paisOidPais','S', GestionarMensaje('MaeClien.paisOidPais.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeClienFrm', true);
}

function maeClienUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeClienFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		maeClienTmpUpdateValues = maeClienBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeClienFrm.codClie','S', GestionarMensaje('MaeClien.codClie.requiered.message'));
		setMV('maeClienFrm.paisOidPais','S', GestionarMensaje('MaeClien.paisOidPais.requiered.message'));
		
			focusFirstFieldModify('maeClienFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		focusFirstField('maeClienFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeClienFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeClienRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeClienList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeClienFrm', true);
}

function maeClienLovInitComponents(){
	maeClienLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeClienFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad


















//Función que permite cargar los datos de un elemento de lov seleccionado
function maeClienSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeClienFrm.' + campo, id);
	set('maeClienFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeClienLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeClienLovReturnParameters.id = '';
	maeClienLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeClienLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClienList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeClienList.codSeleccionados();
	var descripcion = maeClienList.extraeDato(
		maeClienList.codSeleccionados()[0], maeClienChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeClienLovReturnParameters.id = codigo;
	maeClienLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeClienCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeClienFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeClienFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeClienList", "MaeClienConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeClienPostQueryActions(datos);"]], "", "");	
}

function maeClienCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeClienFrm.lastQueryToSession'));
	var i =0;
	set('maeClienFrm.codClie', paramsRequery.ij(i++));
	
	set('maeClienFrm.indFichInsc', paramsRequery.ij(i++));
	
	set('maeClienFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('maeClienFrm.codDigiCtrl', paramsRequery.ij(i++));
	
	set('maeClienFrm.valApe1', paramsRequery.ij(i++));
	
	set('maeClienFrm.valApe2', paramsRequery.ij(i++));
	
	set('maeClienFrm.valNom1', paramsRequery.ij(i++));
	
	set('maeClienFrm.valNom2', paramsRequery.ij(i++));
	
	set('maeClienFrm.valTrat', paramsRequery.ij(i++));
	
	set('maeClienFrm.valCritBus1', paramsRequery.ij(i++));
	
	set('maeClienFrm.valCritBus2', paramsRequery.ij(i++));
	
	set('maeClienFrm.codSexo', paramsRequery.ij(i++));
	
	set('maeClienFrm.fecIngr', paramsRequery.ij(i++));
	
	set('maeClienFrm.fopaOidFormPago', [paramsRequery.ij(i++)]);
	
	set('maeClienFrm.valApelCasa', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeClienPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeClienCmdQuery(maeClienPageCount);
}

function maeClienFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeClienPageCount = 1;
	maeClienCmdQuery(maeClienPageCount);
}

function maeClienPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeClienLastQuery){
		maeClienFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeClienPageCount--;
	maeClienCmdQuery(maeClienPageCount);
}

function maeClienNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeClienLastQuery){
		maeClienFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeClienPageCount++;
	maeClienCmdQuery(maeClienPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeClienPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeClienListLayer', 'O');
		visibilidad('maeClienListButtonsLayer', 'O');
		if(get('maeClienFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeClienLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeClienViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeClienChoiceColumn) + "</A>",
			i, maeClienChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeClienList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeClienTimeStamps = datosTmp.filtrar([16],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeClienMorePagesFlag = true;
		maeClienList.eliminar(mmgPageSize, 1);
	}else{
		maeClienMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeClienFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeClienListLayer', 'V');
	visibilidad('maeClienListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeClienList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeClienList.display();
	
	//Actualizamos el estado de los botones 
	if(maeClienMorePagesFlag){
		set_estado_botonera('maeClienPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeClienPaginationButtonBar',
			3,"inactivo");
	}
	if(maeClienPageCount > 1){
		set_estado_botonera('maeClienPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeClienPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeClienPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeClienPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeClienUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClienList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeClienFrm.idSelection', maeClienList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeClienFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeClienList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeClienFrm.accion');
		parametros["accion"] = get('maeClienFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeClienLPStartUp', get('maeClienFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeClienCmdRequery();
	}
}

function maeClienRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClienList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeClienList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeClienFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeClienList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeClienTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeClienFrm.timestamp', timestamps);


	maeClienFrm.oculto='S';
	envia('maeClienFrm');
	maeClienFrm.oculto='N';
}

function maeClienViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClienList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeClienViewDetail(maeClienList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeClienViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeClienFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeClienLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('maeClienFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		maeClienFrm.oculto='S';
		envia('maeClienFrm');
		maeClienFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeClienFrm.paisOidPais').toString() == ''){
		set('maeClienFrm.paisOidPais_moneOidMoneAlt', []);
		mmgResetCombosOnCascade('paisOidPais_moneOidMoneAlt', 'paisOidPais', 'maeClien');
		set('maeClienFrm.paisOidPais_moneOidMone', []);
		mmgResetCombosOnCascade('paisOidPais_moneOidMone', 'paisOidPais', 'maeClien');
		set('maeClienFrm.paisOidPais_fopaOidFormPago', []);
		mmgResetCombosOnCascade('paisOidPais_fopaOidFormPago', 'paisOidPais', 'maeClien');
		
	}
	if(get('maeClienFrm.fopaOidFormPago').toString() == ''){
		set('maeClienFrm.fopaOidFormPago', []);
		mmgResetCombosOnCascade('fopaOidFormPago', 'fopaOidFormPago', 'maeClien');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeClienRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeClienFrm.accion');
	var origenTmp = get('maeClienFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeClienBuildUpdateRecordString() != maeClienTmpUpdateValues){
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
	document.all.maeClienListLayer.style.display='none';
	document.all.maeClienListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeClienListLayer.style.display='';
	document.all.maeClienListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeClienCodClie = get('maeClienFrm.codClie').toString();
	jsMaeClienIndFichInsc = get('maeClienFrm.indFichInsc').toString();
	jsMaeClienPaisOidPais = get('maeClienFrm.paisOidPais')[0];
	jsMaeClienCodDigiCtrl = get('maeClienFrm.codDigiCtrl').toString();
	jsMaeClienValApe1 = get('maeClienFrm.valApe1').toString();
	jsMaeClienValApe2 = get('maeClienFrm.valApe2').toString();
	jsMaeClienValNom1 = get('maeClienFrm.valNom1').toString();
	jsMaeClienValNom2 = get('maeClienFrm.valNom2').toString();
	jsMaeClienValTrat = get('maeClienFrm.valTrat').toString();
	jsMaeClienValCritBus1 = get('maeClienFrm.valCritBus1').toString();
	jsMaeClienValCritBus2 = get('maeClienFrm.valCritBus2').toString();
	jsMaeClienCodSexo = get('maeClienFrm.codSexo').toString();
	jsMaeClienFecIngr = get('maeClienFrm.fecIngr').toString();
	jsMaeClienFopaOidFormPago = get('maeClienFrm.fopaOidFormPago')[0];
	jsMaeClienValApelCasa = get('maeClienFrm.valApelCasa').toString();
	
	
	var parametros = "";
	parametros += jsMaeClienCodClie + "|";
	parametros += jsMaeClienIndFichInsc + "|";
	parametros += jsMaeClienPaisOidPais + "|";
	parametros += jsMaeClienCodDigiCtrl + "|";
	parametros += jsMaeClienValApe1 + "|";
	parametros += jsMaeClienValApe2 + "|";
	parametros += jsMaeClienValNom1 + "|";
	parametros += jsMaeClienValNom2 + "|";
	parametros += jsMaeClienValTrat + "|";
	parametros += jsMaeClienValCritBus1 + "|";
	parametros += jsMaeClienValCritBus2 + "|";
	parametros += jsMaeClienCodSexo + "|";
	parametros += jsMaeClienFecIngr + "|";
	parametros += jsMaeClienFopaOidFormPago + "|";
	parametros += jsMaeClienValApelCasa + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeClienBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeClienCodClie + "|";
	parametros += jsMaeClienIndFichInsc + "|";
	parametros += jsMaeClienPaisOidPais + "|";
	parametros += jsMaeClienCodDigiCtrl + "|";
	parametros += jsMaeClienValApe1 + "|";
	parametros += jsMaeClienValApe2 + "|";
	parametros += jsMaeClienValNom1 + "|";
	parametros += jsMaeClienValNom2 + "|";
	parametros += jsMaeClienValTrat + "|";
	parametros += jsMaeClienValCritBus1 + "|";
	parametros += jsMaeClienValCritBus2 + "|";
	parametros += jsMaeClienCodSexo + "|";
	parametros += jsMaeClienFecIngr + "|";
	parametros += jsMaeClienFopaOidFormPago + "|";
	parametros += jsMaeClienValApelCasa + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeClienFrm.accion'), 
		get('maeClienFrm.origen'));
	
	jsMaeClienId = get('maeClienFrm.id').toString();
	jsMaeClienCodClie = get('maeClienFrm.codClie').toString();
	jsMaeClienIndFichInsc = get('maeClienFrm.indFichInsc').toString();
	jsMaeClienPaisOidPais = get('maeClienFrm.paisOidPais')[0];
	jsMaeClienCodDigiCtrl = get('maeClienFrm.codDigiCtrl').toString();
	jsMaeClienValApe1 = get('maeClienFrm.valApe1').toString();
	jsMaeClienValApe2 = get('maeClienFrm.valApe2').toString();
	jsMaeClienValNom1 = get('maeClienFrm.valNom1').toString();
	jsMaeClienValNom2 = get('maeClienFrm.valNom2').toString();
	jsMaeClienValTrat = get('maeClienFrm.valTrat').toString();
	jsMaeClienValCritBus1 = get('maeClienFrm.valCritBus1').toString();
	jsMaeClienValCritBus2 = get('maeClienFrm.valCritBus2').toString();
	jsMaeClienCodSexo = get('maeClienFrm.codSexo').toString();
	jsMaeClienFecIngr = get('maeClienFrm.fecIngr').toString();
	jsMaeClienFopaOidFormPago = get('maeClienFrm.fopaOidFormPago')[0];
	jsMaeClienValApelCasa = get('maeClienFrm.valApelCasa').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeClienFrm.accion'), 
		get('maeClienFrm.origen'));


	set('maeClienFrm.id', jsMaeClienId);
	set('maeClienFrm.codClie', jsMaeClienCodClie);
	set('maeClienFrm.indFichInsc', jsMaeClienIndFichInsc);
	set('maeClienFrm.paisOidPais', [jsMaeClienPaisOidPais]);
	set('maeClienFrm.codDigiCtrl', jsMaeClienCodDigiCtrl);
	set('maeClienFrm.valApe1', jsMaeClienValApe1);
	set('maeClienFrm.valApe2', jsMaeClienValApe2);
	set('maeClienFrm.valNom1', jsMaeClienValNom1);
	set('maeClienFrm.valNom2', jsMaeClienValNom2);
	set('maeClienFrm.valTrat', jsMaeClienValTrat);
	set('maeClienFrm.valCritBus1', jsMaeClienValCritBus1);
	set('maeClienFrm.valCritBus2', jsMaeClienValCritBus2);
	set('maeClienFrm.codSexo', jsMaeClienCodSexo);
	set('maeClienFrm.fecIngr', jsMaeClienFecIngr);
	set('maeClienFrm.fopaOidFormPago', [jsMaeClienFopaOidFormPago]);
	set('maeClienFrm.valApelCasa', jsMaeClienValApelCasa);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeClienCodClie = '';
	jsMaeClienIndFichInsc = '';
	jsMaeClienPaisOidPais = '';
	jsMaeClienCodDigiCtrl = '';
	jsMaeClienValApe1 = '';
	jsMaeClienValApe2 = '';
	jsMaeClienValNom1 = '';
	jsMaeClienValNom2 = '';
	jsMaeClienValTrat = '';
	jsMaeClienValCritBus1 = '';
	jsMaeClienValCritBus2 = '';
	jsMaeClienCodSexo = '';
	jsMaeClienFecIngr = '';
	jsMaeClienFopaOidFormPago = '';
	jsMaeClienValApelCasa = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeClienFrm.errCodigo', errorCode);
	set('maeClienFrm.errDescripcion', description);
	set('maeClienFrm.errSeverity', severity);
	fMostrarMensajeError();
}

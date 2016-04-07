

/*
    INDRA/CAR/mmg
    $Id: maeclientiposubti.js,v 1.1 2009/12/03 19:01:37 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeClienTipoSubtiId = "";
var jsMaeClienTipoSubtiClieOidClie = "";
var jsMaeClienTipoSubtiTiclOidTipoClie = "";
var jsMaeClienTipoSubtiSbtiOidSubtClie = "";
var jsMaeClienTipoSubtiIndPpal = "";

//Variables de paginacion, 
var maeClienTipoSubtiPageCount = 1;

//Varible de columna que representa el campo de choice
var maeClienTipoSubtiChoiceColumn = 4;

//Flag de siguiente pagina;
var maeClienTipoSubtiMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeClienTipoSubtiTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 231;
var sizeFormView = 221;
var sizeFormUpdate = 221;

//Ultima busqueda realizada
var maeClienTipoSubtiLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("maeClienTipoSubtiFrm.indPpal");','focaliza("maeClienTipoSubtiFrm.indPpal");','focaliza("maeClienTipoSubtiFrm.indPpal");','focaliza("maeClienTipoSubtiFrm.indPpal");','focaliza("maeClienTipoSubtiFrm.indPpal");','focaliza("maeClienTipoSubtiFrm.indPpal");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var clieOidClieDependeceMap = new Vector();
clieOidClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
clieOidClieDependeceMap.agregar(['clieOidClie', padresTmp, '', 'MaeClien']);
var ticlOidTipoClieDependeceMap = new Vector();
ticlOidTipoClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ticlOidTipoClieDependeceMap.agregar(['ticlOidTipoClie', padresTmp, '', 'MaeTipoClien']);
var sbtiOidSubtClieDependeceMap = new Vector();
sbtiOidSubtClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
sbtiOidSubtClieDependeceMap.agregar(['sbtiOidSubtClie_ticlOidTipoClie', padresTmp, 'sbtiOidSubtClie', 'MaeTipoClienView']);
padresTmp =  new Vector();
padresTmp.cargar(['sbtiOidSubtClie_ticlOidTipoClie'])
sbtiOidSubtClieDependeceMap.agregar(['sbtiOidSubtClie', padresTmp, '', 'MaeSubtiClien']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeClienTipoSubtiLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeClienTipoSubtiTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function maeClienTipoSubtiInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeClienTipoSubtiFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeClienTipoSubtiFrm.accion')){
		case "query": maeClienTipoSubtiQueryInitComponents(); break;
		case "view": maeClienTipoSubtiViewInitComponents(); break;
		case "create": maeClienTipoSubtiCreateInitComponents(); break;
		case "update": maeClienTipoSubtiUpdateInitComponents(); break;
		case "remove": maeClienTipoSubtiRemoveInitComponents(); break;
		case "lov": maeClienTipoSubtiLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('maeClienTipoSubtiFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeClienTipoSubti')) maeClienTipoSubtiCmdRequery();
}

function maeClienTipoSubtiQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
}

function maeClienTipoSubtiViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
}

function maeClienTipoSubtiCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeClienTipoSubtiFrm.clieOidClie','S', GestionarMensaje('MaeClienTipoSubti.clieOidClie.requiered.message'));
	
	setMV('maeClienTipoSubtiFrm.ticlOidTipoClie','S', GestionarMensaje('MaeClienTipoSubti.ticlOidTipoClie.requiered.message'));
	
	setMV('maeClienTipoSubtiFrm.sbtiOidSubtClie','S', GestionarMensaje('MaeClienTipoSubti.sbtiOidSubtClie.requiered.message'));
	
	setMV('maeClienTipoSubtiFrm.indPpal','S', GestionarMensaje('MaeClienTipoSubti.indPpal.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function maeClienTipoSubtiUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeClienTipoSubtiFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		maeClienTipoSubtiTmpUpdateValues = maeClienTipoSubtiBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeClienTipoSubtiFrm.clieOidClie','S', GestionarMensaje('MaeClienTipoSubti.clieOidClie.requiered.message'));
		setMV('maeClienTipoSubtiFrm.ticlOidTipoClie','S', GestionarMensaje('MaeClienTipoSubti.ticlOidTipoClie.requiered.message'));
		setMV('maeClienTipoSubtiFrm.sbtiOidSubtClie','S', GestionarMensaje('MaeClienTipoSubti.sbtiOidSubtClie.requiered.message'));
		setMV('maeClienTipoSubtiFrm.indPpal','S', GestionarMensaje('MaeClienTipoSubti.indPpal.requiered.message'));
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeClienTipoSubtiFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeClienTipoSubtiRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeClienTipoSubtiList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function maeClienTipoSubtiLovInitComponents(){
	maeClienTipoSubtiLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function maeClienTipoSubtiSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeClienTipoSubtiFrm.' + campo, id);
	set('maeClienTipoSubtiFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeClienTipoSubtiLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeClienTipoSubtiLovReturnParameters.id = '';
	maeClienTipoSubtiLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeClienTipoSubtiLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClienTipoSubtiList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeClienTipoSubtiList.codSeleccionados();
	var descripcion = maeClienTipoSubtiList.extraeDato(
		maeClienTipoSubtiList.codSeleccionados()[0], maeClienTipoSubtiChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeClienTipoSubtiLovReturnParameters.id = codigo;
	maeClienTipoSubtiLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeClienTipoSubtiCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeClienTipoSubtiFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeClienTipoSubtiFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeClienTipoSubtiList", "MaeClienTipoSubtiConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeClienTipoSubtiPostQueryActions(datos);"]], "", "");	
}

function maeClienTipoSubtiCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeClienTipoSubtiFrm.lastQueryToSession'));
	var i =0;
	set('maeClienTipoSubtiFrm.clieOidClie', [paramsRequery.ij(i++)]);
	
	set('maeClienTipoSubtiFrm.ticlOidTipoClie', [paramsRequery.ij(i++)]);
	
	set('maeClienTipoSubtiFrm.sbtiOidSubtClie', [paramsRequery.ij(i++)]);
	
	set('maeClienTipoSubtiFrm.indPpal', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeClienTipoSubtiPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeClienTipoSubtiCmdQuery(maeClienTipoSubtiPageCount);
}

function maeClienTipoSubtiFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeClienTipoSubtiPageCount = 1;
	maeClienTipoSubtiCmdQuery(maeClienTipoSubtiPageCount);
}

function maeClienTipoSubtiPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeClienTipoSubtiLastQuery){
		maeClienTipoSubtiFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeClienTipoSubtiPageCount--;
	maeClienTipoSubtiCmdQuery(maeClienTipoSubtiPageCount);
}

function maeClienTipoSubtiNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeClienTipoSubtiLastQuery){
		maeClienTipoSubtiFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeClienTipoSubtiPageCount++;
	maeClienTipoSubtiCmdQuery(maeClienTipoSubtiPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeClienTipoSubtiPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeClienTipoSubtiListLayer', 'O');
		visibilidad('maeClienTipoSubtiListButtonsLayer', 'O');
		if(get('maeClienTipoSubtiFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeClienTipoSubtiLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeClienTipoSubtiViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeClienTipoSubtiChoiceColumn) + "</A>",
			i, maeClienTipoSubtiChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeClienTipoSubtiList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeClienTipoSubtiTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeClienTipoSubtiMorePagesFlag = true;
		maeClienTipoSubtiList.eliminar(mmgPageSize, 1);
	}else{
		maeClienTipoSubtiMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeClienTipoSubtiFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeClienTipoSubtiListLayer', 'V');
	visibilidad('maeClienTipoSubtiListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeClienTipoSubtiList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeClienTipoSubtiList.display();
	
	//Actualizamos el estado de los botones 
	if(maeClienTipoSubtiMorePagesFlag){
		set_estado_botonera('maeClienTipoSubtiPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeClienTipoSubtiPaginationButtonBar',
			3,"inactivo");
	}
	if(maeClienTipoSubtiPageCount > 1){
		set_estado_botonera('maeClienTipoSubtiPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeClienTipoSubtiPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeClienTipoSubtiPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeClienTipoSubtiPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeClienTipoSubtiUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClienTipoSubtiList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeClienTipoSubtiFrm.idSelection', maeClienTipoSubtiList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeClienTipoSubtiFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeClienTipoSubtiList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeClienTipoSubtiFrm.accion');
		parametros["accion"] = get('maeClienTipoSubtiFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('MaeClienTipoSubtiLPStartUp', get('maeClienTipoSubtiFrm.accion'), parametros, null, sizeFormView + 55);
		if(result == MMG_RC_OK) maeClienTipoSubtiCmdRequery();
	}
}

function maeClienTipoSubtiRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClienTipoSubtiList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeClienTipoSubtiList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeClienTipoSubtiFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeClienTipoSubtiList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeClienTipoSubtiTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeClienTipoSubtiFrm.timestamp', timestamps);


	maeClienTipoSubtiFrm.oculto='S';
	envia('maeClienTipoSubtiFrm');
	maeClienTipoSubtiFrm.oculto='N';
}

function maeClienTipoSubtiViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClienTipoSubtiList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeClienTipoSubtiViewDetail(maeClienTipoSubtiList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeClienTipoSubtiViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeClienTipoSubtiFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	mostrarModalSICC('MaeClienTipoSubtiLPStartUp', 'view', parametros, null, sizeFormView + 55);
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
	var validacion = ValidaForm('maeClienTipoSubtiFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
		
	
	if(validacion){
		maeClienTipoSubtiFrm.oculto='S';
		envia('maeClienTipoSubtiFrm');
		maeClienTipoSubtiFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeClienTipoSubtiFrm.clieOidClie').toString() == ''){
		set('maeClienTipoSubtiFrm.clieOidClie', []);
		mmgResetCombosOnCascade('clieOidClie', 'clieOidClie', 'maeClienTipoSubti');
		
	}
	if(get('maeClienTipoSubtiFrm.ticlOidTipoClie').toString() == ''){
		set('maeClienTipoSubtiFrm.ticlOidTipoClie', []);
		mmgResetCombosOnCascade('ticlOidTipoClie', 'ticlOidTipoClie', 'maeClienTipoSubti');
		
	}
	if(get('maeClienTipoSubtiFrm.sbtiOidSubtClie').toString() == ''){
		set('maeClienTipoSubtiFrm.sbtiOidSubtClie_ticlOidTipoClie', []);
		mmgResetCombosOnCascade('sbtiOidSubtClie_ticlOidTipoClie', 'sbtiOidSubtClie', 'maeClienTipoSubti');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeClienTipoSubtiRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeClienTipoSubtiFrm.accion');
	var origenTmp = get('maeClienTipoSubtiFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeClienTipoSubtiBuildUpdateRecordString() != maeClienTipoSubtiTmpUpdateValues){
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
	document.all.maeClienTipoSubtiListLayer.style.display='none';
	document.all.maeClienTipoSubtiListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeClienTipoSubtiListLayer.style.display='';
	document.all.maeClienTipoSubtiListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeClienTipoSubtiClieOidClie = get('maeClienTipoSubtiFrm.clieOidClie')[0];
	jsMaeClienTipoSubtiTiclOidTipoClie = get('maeClienTipoSubtiFrm.ticlOidTipoClie')[0];
	jsMaeClienTipoSubtiSbtiOidSubtClie = get('maeClienTipoSubtiFrm.sbtiOidSubtClie')[0];
	jsMaeClienTipoSubtiIndPpal = get('maeClienTipoSubtiFrm.indPpal').toString();
	
	
	var parametros = "";
	parametros += jsMaeClienTipoSubtiClieOidClie + "|";
	parametros += jsMaeClienTipoSubtiTiclOidTipoClie + "|";
	parametros += jsMaeClienTipoSubtiSbtiOidSubtClie + "|";
	parametros += jsMaeClienTipoSubtiIndPpal + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeClienTipoSubtiBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeClienTipoSubtiClieOidClie + "|";
	parametros += jsMaeClienTipoSubtiTiclOidTipoClie + "|";
	parametros += jsMaeClienTipoSubtiSbtiOidSubtClie + "|";
	parametros += jsMaeClienTipoSubtiIndPpal + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeClienTipoSubtiFrm.accion'), 
		get('maeClienTipoSubtiFrm.origen'));
	
	jsMaeClienTipoSubtiId = get('maeClienTipoSubtiFrm.id').toString();
	jsMaeClienTipoSubtiClieOidClie = get('maeClienTipoSubtiFrm.clieOidClie')[0];
	jsMaeClienTipoSubtiTiclOidTipoClie = get('maeClienTipoSubtiFrm.ticlOidTipoClie')[0];
	jsMaeClienTipoSubtiSbtiOidSubtClie = get('maeClienTipoSubtiFrm.sbtiOidSubtClie')[0];
	jsMaeClienTipoSubtiIndPpal = get('maeClienTipoSubtiFrm.indPpal').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeClienTipoSubtiFrm.accion'), 
		get('maeClienTipoSubtiFrm.origen'));


	set('maeClienTipoSubtiFrm.id', jsMaeClienTipoSubtiId);
	set('maeClienTipoSubtiFrm.clieOidClie', [jsMaeClienTipoSubtiClieOidClie]);
	set('maeClienTipoSubtiFrm.ticlOidTipoClie', [jsMaeClienTipoSubtiTiclOidTipoClie]);
	set('maeClienTipoSubtiFrm.sbtiOidSubtClie', [jsMaeClienTipoSubtiSbtiOidSubtClie]);
	set('maeClienTipoSubtiFrm.indPpal', jsMaeClienTipoSubtiIndPpal);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeClienTipoSubtiClieOidClie = '';
	jsMaeClienTipoSubtiTiclOidTipoClie = '';
	jsMaeClienTipoSubtiSbtiOidSubtClie = '';
	jsMaeClienTipoSubtiIndPpal = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeClienTipoSubtiFrm.errCodigo', errorCode);
	set('maeClienTipoSubtiFrm.errDescripcion', description);
	set('maeClienTipoSubtiFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	

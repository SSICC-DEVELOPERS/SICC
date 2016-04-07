

/*
    INDRA/CAR/mmg
    $Id: maeconficampo.js,v 1.1 2009/12/03 19:02:16 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeConfiCampoId = "";
var jsMaeConfiCampoPaisOidPais = "";
var jsMaeConfiCampoSbtiOidSubtClie = "";
var jsMaeConfiCampoAtreOidAtriEspe = "";
var jsMaeConfiCampoValDefe = "";
var jsMaeConfiCampoIndObli = "";
var jsMaeConfiCampoIndModi = "";

//Variables de paginacion, 
var maeConfiCampoPageCount = 1;

//Varible de columna que representa el campo de choice
var maeConfiCampoChoiceColumn = 6;

//Flag de siguiente pagina;
var maeConfiCampoMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeConfiCampoTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 315;
var sizeFormView = 305;
var sizeFormUpdate = 305;

//Ultima busqueda realizada
var maeConfiCampoLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("maeConfiCampoFrm.indModi");','focaliza("maeConfiCampoFrm.indModi");','focaliza("maeConfiCampoFrm.indModi");','focaliza("maeConfiCampoFrm.indModi");','focaliza("maeConfiCampoFrm.indModi");','focaliza("maeConfiCampoFrm.indModi");']]);

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
paisOidPaisDependeceMap.agregar(['paisOidPais_fopaOidFormPago', padresTmp, 'paisOidPais', 'BelFormaPagoTapon']);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_moneOidMoneAlt', padresTmp, 'paisOidPais', 'SegMoned']);
padresTmp =  new Vector();
padresTmp.cargar(['paisOidPais_moneOidMone','paisOidPais_fopaOidFormPago','paisOidPais_moneOidMoneAlt'])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPais']);
var sbtiOidSubtClieDependeceMap = new Vector();
sbtiOidSubtClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
sbtiOidSubtClieDependeceMap.agregar(['sbtiOidSubtClie_ticlOidTipoClie', padresTmp, 'sbtiOidSubtClie', 'MaeTipoClienView']);
padresTmp =  new Vector();
padresTmp.cargar(['sbtiOidSubtClie_ticlOidTipoClie'])
sbtiOidSubtClieDependeceMap.agregar(['sbtiOidSubtClie', padresTmp, '', 'MaeSubtiClien']);
var atreOidAtriEspeDependeceMap = new Vector();
atreOidAtriEspeDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
atreOidAtriEspeDependeceMap.agregar(['atreOidAtriEspe_moduOidModu', padresTmp, 'atreOidAtriEspe', 'SegModul']);
padresTmp =  new Vector();
padresTmp.cargar(['atreOidAtriEspe_moduOidModu'])
atreOidAtriEspeDependeceMap.agregar(['atreOidAtriEspe', padresTmp, '', 'PedAtribEspec']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeConfiCampoLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeConfiCampoTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function maeConfiCampoInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeConfiCampoFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeConfiCampoFrm.accion')){
		case "query": maeConfiCampoQueryInitComponents(); break;
		case "view": maeConfiCampoViewInitComponents(); break;
		case "create": maeConfiCampoCreateInitComponents(); break;
		case "update": maeConfiCampoUpdateInitComponents(); break;
		case "remove": maeConfiCampoRemoveInitComponents(); break;
		case "lov": maeConfiCampoLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('maeConfiCampoFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeConfiCampo')) maeConfiCampoCmdRequery();
}

function maeConfiCampoQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
}

function maeConfiCampoViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
}

function maeConfiCampoCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeConfiCampoFrm.paisOidPais','S', GestionarMensaje('MaeConfiCampo.paisOidPais.requiered.message'));
	
	setMV('maeConfiCampoFrm.atreOidAtriEspe','S', GestionarMensaje('MaeConfiCampo.atreOidAtriEspe.requiered.message'));
	
	setMV('maeConfiCampoFrm.indObli','S', GestionarMensaje('MaeConfiCampo.indObli.requiered.message'));
	
	setMV('maeConfiCampoFrm.indModi','S', GestionarMensaje('MaeConfiCampo.indModi.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function maeConfiCampoUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeConfiCampoFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		maeConfiCampoTmpUpdateValues = maeConfiCampoBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeConfiCampoFrm.paisOidPais','S', GestionarMensaje('MaeConfiCampo.paisOidPais.requiered.message'));
		setMV('maeConfiCampoFrm.atreOidAtriEspe','S', GestionarMensaje('MaeConfiCampo.atreOidAtriEspe.requiered.message'));
		setMV('maeConfiCampoFrm.indObli','S', GestionarMensaje('MaeConfiCampo.indObli.requiered.message'));
		setMV('maeConfiCampoFrm.indModi','S', GestionarMensaje('MaeConfiCampo.indModi.requiered.message'));
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeConfiCampoFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeConfiCampoRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeConfiCampoList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function maeConfiCampoLovInitComponents(){
	maeConfiCampoLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad









//Función que permite cargar los datos de un elemento de lov seleccionado
function maeConfiCampoSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeConfiCampoFrm.' + campo, id);
	set('maeConfiCampoFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeConfiCampoLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeConfiCampoLovReturnParameters.id = '';
	maeConfiCampoLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeConfiCampoLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeConfiCampoList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeConfiCampoList.codSeleccionados();
	var descripcion = maeConfiCampoList.extraeDato(
		maeConfiCampoList.codSeleccionados()[0], maeConfiCampoChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeConfiCampoLovReturnParameters.id = codigo;
	maeConfiCampoLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeConfiCampoCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeConfiCampoFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeConfiCampoFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeConfiCampoList", "MaeConfiCampoConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeConfiCampoPostQueryActions(datos);"]], "", "");	
}

function maeConfiCampoCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeConfiCampoFrm.lastQueryToSession'));
	var i =0;
	set('maeConfiCampoFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('maeConfiCampoFrm.sbtiOidSubtClie', [paramsRequery.ij(i++)]);
	
	set('maeConfiCampoFrm.atreOidAtriEspe', [paramsRequery.ij(i++)]);
	
	set('maeConfiCampoFrm.valDefe', paramsRequery.ij(i++));
	
	set('maeConfiCampoFrm.indObli', paramsRequery.ij(i++));
	
	set('maeConfiCampoFrm.indModi', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeConfiCampoPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeConfiCampoCmdQuery(maeConfiCampoPageCount);
}

function maeConfiCampoFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeConfiCampoPageCount = 1;
	maeConfiCampoCmdQuery(maeConfiCampoPageCount);
}

function maeConfiCampoPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeConfiCampoLastQuery){
		maeConfiCampoFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeConfiCampoPageCount--;
	maeConfiCampoCmdQuery(maeConfiCampoPageCount);
}

function maeConfiCampoNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeConfiCampoLastQuery){
		maeConfiCampoFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeConfiCampoPageCount++;
	maeConfiCampoCmdQuery(maeConfiCampoPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeConfiCampoPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeConfiCampoListLayer', 'O');
		visibilidad('maeConfiCampoListButtonsLayer', 'O');
		if(get('maeConfiCampoFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeConfiCampoLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeConfiCampoViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeConfiCampoChoiceColumn) + "</A>",
			i, maeConfiCampoChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeConfiCampoList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeConfiCampoTimeStamps = datosTmp.filtrar([7],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeConfiCampoMorePagesFlag = true;
		maeConfiCampoList.eliminar(mmgPageSize, 1);
	}else{
		maeConfiCampoMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeConfiCampoFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeConfiCampoListLayer', 'V');
	visibilidad('maeConfiCampoListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeConfiCampoList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeConfiCampoList.display();
	
	//Actualizamos el estado de los botones 
	if(maeConfiCampoMorePagesFlag){
		set_estado_botonera('maeConfiCampoPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeConfiCampoPaginationButtonBar',
			3,"inactivo");
	}
	if(maeConfiCampoPageCount > 1){
		set_estado_botonera('maeConfiCampoPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeConfiCampoPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeConfiCampoPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeConfiCampoPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeConfiCampoUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeConfiCampoList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeConfiCampoFrm.idSelection', maeConfiCampoList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeConfiCampoFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeConfiCampoList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeConfiCampoFrm.accion');
		parametros["accion"] = get('maeConfiCampoFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('MaeConfiCampoLPStartUp', get('maeConfiCampoFrm.accion'), parametros, null, sizeFormView + 55);
		if(result == MMG_RC_OK) maeConfiCampoCmdRequery();
	}
}

function maeConfiCampoRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeConfiCampoList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeConfiCampoList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeConfiCampoFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeConfiCampoList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeConfiCampoTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeConfiCampoFrm.timestamp', timestamps);


	maeConfiCampoFrm.oculto='S';
	envia('maeConfiCampoFrm');
	maeConfiCampoFrm.oculto='N';
}

function maeConfiCampoViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeConfiCampoList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeConfiCampoViewDetail(maeConfiCampoList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeConfiCampoViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeConfiCampoFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	mostrarModalSICC('MaeConfiCampoLPStartUp', 'view', parametros, null, sizeFormView + 55);
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
	var validacion = ValidaForm('maeConfiCampoFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
		
	
	if(validacion){
		maeConfiCampoFrm.oculto='S';
		envia('maeConfiCampoFrm');
		maeConfiCampoFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeConfiCampoFrm.paisOidPais').toString() == ''){
		set('maeConfiCampoFrm.paisOidPais_moneOidMone', []);
		mmgResetCombosOnCascade('paisOidPais_moneOidMone', 'paisOidPais', 'maeConfiCampo');
		set('maeConfiCampoFrm.paisOidPais_fopaOidFormPago', []);
		mmgResetCombosOnCascade('paisOidPais_fopaOidFormPago', 'paisOidPais', 'maeConfiCampo');
		set('maeConfiCampoFrm.paisOidPais_moneOidMoneAlt', []);
		mmgResetCombosOnCascade('paisOidPais_moneOidMoneAlt', 'paisOidPais', 'maeConfiCampo');
		
	}
	if(get('maeConfiCampoFrm.sbtiOidSubtClie').toString() == ''){
		set('maeConfiCampoFrm.sbtiOidSubtClie_ticlOidTipoClie', []);
		mmgResetCombosOnCascade('sbtiOidSubtClie_ticlOidTipoClie', 'sbtiOidSubtClie', 'maeConfiCampo');
		
	}
	if(get('maeConfiCampoFrm.atreOidAtriEspe').toString() == ''){
		set('maeConfiCampoFrm.atreOidAtriEspe_moduOidModu', []);
		mmgResetCombosOnCascade('atreOidAtriEspe_moduOidModu', 'atreOidAtriEspe', 'maeConfiCampo');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeConfiCampoRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeConfiCampoFrm.accion');
	var origenTmp = get('maeConfiCampoFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeConfiCampoBuildUpdateRecordString() != maeConfiCampoTmpUpdateValues){
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
	document.all.maeConfiCampoListLayer.style.display='none';
	document.all.maeConfiCampoListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeConfiCampoListLayer.style.display='';
	document.all.maeConfiCampoListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeConfiCampoPaisOidPais = get('maeConfiCampoFrm.paisOidPais')[0];
	jsMaeConfiCampoSbtiOidSubtClie = get('maeConfiCampoFrm.sbtiOidSubtClie')[0];
	jsMaeConfiCampoAtreOidAtriEspe = get('maeConfiCampoFrm.atreOidAtriEspe')[0];
	jsMaeConfiCampoValDefe = get('maeConfiCampoFrm.valDefe').toString();
	jsMaeConfiCampoIndObli = get('maeConfiCampoFrm.indObli').toString();
	jsMaeConfiCampoIndModi = get('maeConfiCampoFrm.indModi').toString();
	
	
	var parametros = "";
	parametros += jsMaeConfiCampoPaisOidPais + "|";
	parametros += jsMaeConfiCampoSbtiOidSubtClie + "|";
	parametros += jsMaeConfiCampoAtreOidAtriEspe + "|";
	parametros += jsMaeConfiCampoValDefe + "|";
	parametros += jsMaeConfiCampoIndObli + "|";
	parametros += jsMaeConfiCampoIndModi + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeConfiCampoBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeConfiCampoPaisOidPais + "|";
	parametros += jsMaeConfiCampoSbtiOidSubtClie + "|";
	parametros += jsMaeConfiCampoAtreOidAtriEspe + "|";
	parametros += jsMaeConfiCampoValDefe + "|";
	parametros += jsMaeConfiCampoIndObli + "|";
	parametros += jsMaeConfiCampoIndModi + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeConfiCampoFrm.accion'), 
		get('maeConfiCampoFrm.origen'));
	
	jsMaeConfiCampoId = get('maeConfiCampoFrm.id').toString();
	jsMaeConfiCampoPaisOidPais = get('maeConfiCampoFrm.paisOidPais')[0];
	jsMaeConfiCampoSbtiOidSubtClie = get('maeConfiCampoFrm.sbtiOidSubtClie')[0];
	jsMaeConfiCampoAtreOidAtriEspe = get('maeConfiCampoFrm.atreOidAtriEspe')[0];
	jsMaeConfiCampoValDefe = get('maeConfiCampoFrm.valDefe').toString();
	jsMaeConfiCampoIndObli = get('maeConfiCampoFrm.indObli').toString();
	jsMaeConfiCampoIndModi = get('maeConfiCampoFrm.indModi').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeConfiCampoFrm.accion'), 
		get('maeConfiCampoFrm.origen'));


	set('maeConfiCampoFrm.id', jsMaeConfiCampoId);
	set('maeConfiCampoFrm.paisOidPais', [jsMaeConfiCampoPaisOidPais]);
	set('maeConfiCampoFrm.sbtiOidSubtClie', [jsMaeConfiCampoSbtiOidSubtClie]);
	set('maeConfiCampoFrm.atreOidAtriEspe', [jsMaeConfiCampoAtreOidAtriEspe]);
	set('maeConfiCampoFrm.valDefe', jsMaeConfiCampoValDefe);
	set('maeConfiCampoFrm.indObli', jsMaeConfiCampoIndObli);
	set('maeConfiCampoFrm.indModi', jsMaeConfiCampoIndModi);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeConfiCampoPaisOidPais = '';
	jsMaeConfiCampoSbtiOidSubtClie = '';
	jsMaeConfiCampoAtreOidAtriEspe = '';
	jsMaeConfiCampoValDefe = '';
	jsMaeConfiCampoIndObli = '';
	jsMaeConfiCampoIndModi = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeConfiCampoFrm.errCodigo', errorCode);
	set('maeConfiCampoFrm.errDescripcion', description);
	set('maeConfiCampoFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	

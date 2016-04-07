

/*
    INDRA/CAR/mmg
    $Id: eduregal.js,v 1.1 2009/12/03 19:02:17 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsEduRegalId = "";
var jsEduRegalCodRega = "";
var jsEduRegalProdOidProd = "";
var jsEduRegalDescripcion = "";

//Variables de paginacion, 
var eduRegalPageCount = 1;

//Varible de columna que representa el campo de choice
var eduRegalChoiceColumn = 2;

//Flag de siguiente pagina;
var eduRegalMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var eduRegalTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var eduRegalLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("eduRegalFrm.codRega");','focaliza("eduRegalFrm.codRega");','','focaliza("eduRegalFrm.codRega");','focaliza("eduRegalFrm.codRega");',''],[3,'focalizaComboDependence("eduRegal","prodOidProd", false);','focalizaComboDependence("eduRegal","prodOidProd", false);','','focalizaComboDependence("eduRegal","prodOidProd", true);','focalizaComboDependence("eduRegal","prodOidProd", true);',''],[4,'','focaliza("eduRegalFrm.Descripcion");','focaliza("eduRegalFrm.Descripcion");','','focaliza("eduRegalFrm.Descripcion");','focaliza("eduRegalFrm.Descripcion");']]);

//Creamos la informaci�n de las jerarqu�as de dependencias de combos (si existen)
//Para cada jerarqu�a de dependencia definimos un vector donde se defina la jerar�a
//La definici�n de la jerarqu� consiste en definir para cada combo de la jerarqu�a cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de �l para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedar�an [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var prodOidProdDependeceMap = new Vector();
prodOidProdDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
prodOidProdDependeceMap.agregar(['prodOidProd', padresTmp, '', 'MaeProdu']);

	
//variable conreferencia al obejto usado para devolver los resultados de una b�squeda lov
eduRegalLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var eduRegalTmpUpdateValues;


//Funci�n ejecutada en el onload de la pagina
function eduRegalInitComponents(){
	//Deshabilitamos la limpieza gen�rica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('eduRegalFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('eduRegalFrm.accion')){
		case "query": eduRegalQueryInitComponents(); break;
		case "view": eduRegalViewInitComponents(); break;
		case "create": eduRegalCreateInitComponents(); break;
		case "update": eduRegalUpdateInitComponents(); break;
		case "remove": eduRegalRemoveInitComponents(); break;
		case "lov": eduRegalLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('eduRegalFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('eduRegal')) eduRegalCmdRequery();
}

function eduRegalQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
}

function eduRegalViewInitComponents(){
	//Cargamos la descripci�n en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('eduRegalFrm', 'Descripcion', 1);
	
		
	
}

function eduRegalCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('eduRegalFrm.codRega','S', GestionarMensaje('EduRegal.codRega.requiered.message'));
	
	setMV('eduRegalFrm.prodOidProd','S', GestionarMensaje('EduRegal.prodOidProd.requiered.message'));
	
	setMV('eduRegalFrm.Descripcion','S', GestionarMensaje('EduRegal.Descripcion.requiered.message'));
	
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function eduRegalUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('eduRegalFrm.origen') == "pagina"){
		loadLocalizationWidget('eduRegalFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		eduRegalTmpUpdateValues = eduRegalBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('eduRegalFrm.Descripcion','S', GestionarMensaje('EduRegal.Descripcion.requiered.message'));
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('eduRegalFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function eduRegalRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	eduRegalList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera. Al realizar la query se activar�;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function eduRegalLovInitComponents(){
	eduRegalLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function eduRegalSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('eduRegalFrm.' + campo, id);
	set('eduRegalFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function eduRegalLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	eduRegalLovReturnParameters.id = '';
	eduRegalLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function eduRegalLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(eduRegalList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = eduRegalList.codSeleccionados();
	var descripcion = eduRegalList.extraeDato(
		eduRegalList.codSeleccionados()[0], eduRegalChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	eduRegalLovReturnParameters.id = codigo;
	eduRegalLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function eduRegalCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('eduRegalFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('eduRegalFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "eduRegalList", "EduRegalConectorTransactionQuery", 
		"result_ROWSET", parametros, "eduRegalPostQueryActions(datos);"]], "", "");	
}

function eduRegalCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('eduRegalFrm.lastQueryToSession'));
	var i =0;
	set('eduRegalFrm.codRega', paramsRequery.ij(i++));
	
	set('eduRegalFrm.prodOidProd', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la p�gina de busqueda como la actual
	eduRegalPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	eduRegalCmdQuery(eduRegalPageCount);
}

function eduRegalFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	eduRegalPageCount = 1;
	eduRegalCmdQuery(eduRegalPageCount);
}

function eduRegalPreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != eduRegalLastQuery){
		eduRegalFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	eduRegalPageCount--;
	eduRegalCmdQuery(eduRegalPageCount);
}

function eduRegalNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != eduRegalLastQuery){
		eduRegalFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	eduRegalPageCount++;
	eduRegalCmdQuery(eduRegalPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function eduRegalPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('eduRegalListLayer', 'O');
		visibilidad('eduRegalListButtonsLayer', 'O');
		if(get('eduRegalFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	eduRegalLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripci�n en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminaci�n)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:eduRegalViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, eduRegalChoiceColumn) + "</A>",
			i, eduRegalChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	eduRegalList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	eduRegalTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		eduRegalMorePagesFlag = true;
		eduRegalList.eliminar(mmgPageSize, 1);
	}else{
		eduRegalMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('eduRegalFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('eduRegalListLayer', 'V');
	visibilidad('eduRegalListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('eduRegalList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	eduRegalList.display();
	
	//Actualizamos el estado de los botones 
	if(eduRegalMorePagesFlag){
		set_estado_botonera('eduRegalPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('eduRegalPaginationButtonBar',
			3,"inactivo");
	}
	if(eduRegalPageCount > 1){
		set_estado_botonera('eduRegalPaginationButtonBar',
			2,"activo");
		set_estado_botonera('eduRegalPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('eduRegalPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('eduRegalPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function eduRegalUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(eduRegalList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('eduRegalFrm.idSelection', eduRegalList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('eduRegalFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = eduRegalList.codSeleccionados()[0];
		parametros["previousAction"] = get('eduRegalFrm.accion');
		parametros["accion"] = get('eduRegalFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('EduRegalLPStartUp', get('eduRegalFrm.accion'), parametros, null, sizeFormView + 55);
		if(result == MMG_RC_OK) eduRegalCmdRequery();
	}
}

function eduRegalRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(eduRegalList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci�n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = eduRegalList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('eduRegalFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(eduRegalList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += eduRegalTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('eduRegalFrm.timestamp', timestamps);


	eduRegalFrm.oculto='S';
	envia('eduRegalFrm');
	eduRegalFrm.oculto='N';
}

function eduRegalViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(eduRegalList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	eduRegalViewDetail(eduRegalList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function eduRegalViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('eduRegalFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	mostrarModalSICC('EduRegalLPStartUp', 'view', parametros, null, sizeFormView + 55);
}

//Funci�n ejecutada cuando se pulsa el bot�n de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripci�n del idioma por defecto
	//intreoducido directamente a trav�s del widget. Esto se pone debio a que la tecla r�pida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('eduRegalFrm', 
		'Descripcion', 1,
		get('eduRegalFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validaci�n los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('eduRegalFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('eduRegalFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('EduRegal.Descripcion.requiered.message'));
		focaliza('eduRegalFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		eduRegalFrm.oculto='S';
		envia('eduRegalFrm');
		eduRegalFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarqu�a de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('eduRegalFrm.prodOidProd').toString() == ''){
		set('eduRegalFrm.prodOidProd', []);
		mmgResetCombosOnCascade('prodOidProd', 'prodOidProd', 'eduRegal');
		
	}
	
	
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	eduRegalRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('eduRegalFrm.accion');
	var origenTmp = get('eduRegalFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(eduRegalBuildUpdateRecordString() != eduRegalTmpUpdateValues){
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
	document.all.eduRegalListLayer.style.display='none';
	document.all.eduRegalListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.eduRegalListLayer.style.display='';
	document.all.eduRegalListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda
	jsEduRegalCodRega = get('eduRegalFrm.codRega').toString();
	jsEduRegalProdOidProd = get('eduRegalFrm.prodOidProd')[0];
	
	
	var parametros = "";
	parametros += jsEduRegalCodRega + "|";
	parametros += jsEduRegalProdOidProd + "|";
	
	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function eduRegalBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsEduRegalDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('eduRegalFrm.accion'), 
		get('eduRegalFrm.origen'));
	
	jsEduRegalId = get('eduRegalFrm.id').toString();
	jsEduRegalCodRega = get('eduRegalFrm.codRega').toString();
	jsEduRegalProdOidProd = get('eduRegalFrm.prodOidProd')[0];
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsEduRegalDescripcion = buildLocalizedString('eduRegalFrm', 1);
	}else{
		jsEduRegalDescripcion = get('eduRegalFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('eduRegalFrm.accion'), 
		get('eduRegalFrm.origen'));


	set('eduRegalFrm.id', jsEduRegalId);
	set('eduRegalFrm.codRega', jsEduRegalCodRega);
	set('eduRegalFrm.prodOidProd', [jsEduRegalProdOidProd]);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('eduRegalFrm', 1,  jsEduRegalDescripcion)
		loadLocalizationWidget('eduRegalFrm', 'Descripcion', 1);
	}else{
		set('eduRegalFrm.Descripcion', jsEduRegalDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realziar la b�squeda
	jsEduRegalCodRega = '';
	jsEduRegalProdOidProd = '';
	
}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('eduRegalFrm.errCodigo', errorCode);
	set('eduRegalFrm.errDescripcion', description);
	set('eduRegalFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	

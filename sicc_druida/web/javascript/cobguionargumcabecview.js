

/*
    INDRA/CAR/mmg
    $Id: cobguionargumcabecview.js,v 1.1 2009/12/03 19:02:00 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCobGuionArgumCabecViewId = "";
var jsCobGuionArgumCabecViewCodGuiaArgu = "";
var jsCobGuionArgumCabecViewValObse = "";
var jsCobGuionArgumCabecViewDescripcion = "";
var jsCobGuionArgumCabecViewPaisOidPais = "";

//Variables de paginacion, 
var cobGuionArgumCabecViewPageCount = 1;

//Varible de columna que representa el campo de choice
var cobGuionArgumCabecViewChoiceColumn = 1;

//Flag de siguiente pagina;
var cobGuionArgumCabecViewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cobGuionArgumCabecViewTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 147;
var sizeFormView = 195;
var sizeFormUpdate = 195;

//Ultima busqueda realizada
var cobGuionArgumCabecViewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("cobGuionArgumCabecViewFrm.codGuiaArgu");','focaliza("cobGuionArgumCabecViewFrm.codGuiaArgu");','focaliza("cobGuionArgumCabecViewFrm.codGuiaArgu");','focaliza("cobGuionArgumCabecViewFrm.codGuiaArgu");','focaliza("cobGuionArgumCabecViewFrm.codGuiaArgu");','focaliza("cobGuionArgumCabecViewFrm.codGuiaArgu");'],[3,'','focaliza("cobGuionArgumCabecViewFrm.valObse");','focaliza("cobGuionArgumCabecViewFrm.valObse");','','focaliza("cobGuionArgumCabecViewFrm.valObse");','focaliza("cobGuionArgumCabecViewFrm.valObse");'],[4,'focaliza("cobGuionArgumCabecViewFrm.Descripcion");','focaliza("cobGuionArgumCabecViewFrm.Descripcion");','focaliza("cobGuionArgumCabecViewFrm.Descripcion");','focaliza("cobGuionArgumCabecViewFrm.Descripcion");','focaliza("cobGuionArgumCabecViewFrm.Descripcion");','focaliza("cobGuionArgumCabecViewFrm.Descripcion");'],[5,'','','','','','']]);

//Vector con acciones de foco para la pantalla de modificaci�n.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'','focaliza("cobGuionArgumCabecViewFrm.valObse");','focaliza("cobGuionArgumCabecViewFrm.valObse");','','focaliza("cobGuionArgumCabecViewFrm.valObse");','focaliza("cobGuionArgumCabecViewFrm.valObse");'],[4,'focaliza("cobGuionArgumCabecViewFrm.Descripcion");','focaliza("cobGuionArgumCabecViewFrm.Descripcion");','focaliza("cobGuionArgumCabecViewFrm.Descripcion");','focaliza("cobGuionArgumCabecViewFrm.Descripcion");','focaliza("cobGuionArgumCabecViewFrm.Descripcion");','focaliza("cobGuionArgumCabecViewFrm.Descripcion");'],[5,'','','','','','']]);

//Creamos la informaci�n de las jerarqu�as de dependencias de combos (si existen)
//Para cada jerarqu�a de dependencia definimos un vector donde se defina la jerar�a
//La definici�n de la jerarqu�a consiste en definir para cada combo de la jerarqu�a cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de �l para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedar�an [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una b�squeda lov
cobGuionArgumCabecViewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var cobGuionArgumCabecViewTmpUpdateValues;



//Funci�n ejecutada en el onload de la pagina
function cobGuionArgumCabecViewInitComponents(){
	//Deshabilitamos la limpieza gen�rica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('cobGuionArgumCabecViewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('cobGuionArgumCabecViewFrm.accion')){
		case "query": cobGuionArgumCabecViewQueryInitComponents(); break;
		case "view": cobGuionArgumCabecViewViewInitComponents(); break;
		case "create": cobGuionArgumCabecViewCreateInitComponents(); break;
		case "update": cobGuionArgumCabecViewUpdateInitComponents(); break;
		case "remove": cobGuionArgumCabecViewRemoveInitComponents(); break;
		case "lov": cobGuionArgumCabecViewLovInitComponents(); break;
	}
	//alert('accion :' + get('cobGuionArgumCabecViewFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('cobGuionArgumCabecViewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cobGuionArgumCabecView')) cobGuionArgumCabecViewCmdRequery();
}

function cobGuionArgumCabecViewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('cobGuionArgumCabecViewFrm', true);	
}

function cobGuionArgumCabecViewViewInitComponents(){
	//Cargamos la descripci�n en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('cobGuionArgumCabecViewFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('cobGuionArgumCabecViewFrm', true);
}

function cobGuionArgumCabecViewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cobGuionArgumCabecViewFrm.codGuiaArgu','S', GestionarMensaje('CobGuionArgumCabecView.codGuiaArgu.requiered.message'));
	
	setMV('cobGuionArgumCabecViewFrm.Descripcion','S', GestionarMensaje('CobGuionArgumCabecView.Descripcion.requiered.message'));
	
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('cobGuionArgumCabecViewFrm', true);
}

function cobGuionArgumCabecViewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('cobGuionArgumCabecViewFrm.origen') == "pagina"){
		loadLocalizationWidget('cobGuionArgumCabecViewFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		cobGuionArgumCabecViewTmpUpdateValues = cobGuionArgumCabecViewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cobGuionArgumCabecViewFrm.codGuiaArgu','S', GestionarMensaje('CobGuionArgumCabecView.codGuiaArgu.requiered.message'));
		setMV('cobGuionArgumCabecViewFrm.Descripcion','S', GestionarMensaje('CobGuionArgumCabecView.Descripcion.requiered.message'));
		
			focusFirstFieldModify('cobGuionArgumCabecViewFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('cobGuionArgumCabecViewFrm', true);
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('cobGuionArgumCabecViewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cobGuionArgumCabecViewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	cobGuionArgumCabecViewList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera. Al realizar la query se activar�;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('cobGuionArgumCabecViewFrm', true);
}

function cobGuionArgumCabecViewLovInitComponents(){
	cobGuionArgumCabecViewLovReturnParameters = window.dialogArguments;
	
	focusFirstField('cobGuionArgumCabecViewFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function cobGuionArgumCabecViewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cobGuionArgumCabecViewFrm.' + campo, id);
	set('cobGuionArgumCabecViewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function cobGuionArgumCabecViewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cobGuionArgumCabecViewLovReturnParameters.id = '';
	cobGuionArgumCabecViewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cobGuionArgumCabecViewLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(cobGuionArgumCabecViewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cobGuionArgumCabecViewList.codSeleccionados();
	var descripcion = cobGuionArgumCabecViewList.extraeDato(
		cobGuionArgumCabecViewList.codSeleccionados()[0], cobGuionArgumCabecViewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cobGuionArgumCabecViewLovReturnParameters.id = codigo;
	cobGuionArgumCabecViewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function cobGuionArgumCabecViewCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cobGuionArgumCabecViewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('cobGuionArgumCabecViewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cobGuionArgumCabecViewList", "CobGuionArgumCabecViewConectorTransactionQuery", 
		"result_ROWSET", parametros, "cobGuionArgumCabecViewPostQueryActions(datos);"]], "", "");	
}

function cobGuionArgumCabecViewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cobGuionArgumCabecViewFrm.lastQueryToSession'));
	var i =0;
	set('cobGuionArgumCabecViewFrm.codGuiaArgu', paramsRequery.ij(i++));
	
	set('cobGuionArgumCabecViewFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la p�gina de busqueda como la actual
	cobGuionArgumCabecViewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cobGuionArgumCabecViewCmdQuery(cobGuionArgumCabecViewPageCount);
}

function cobGuionArgumCabecViewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cobGuionArgumCabecViewPageCount = 1;
	cobGuionArgumCabecViewCmdQuery(cobGuionArgumCabecViewPageCount);
}

function cobGuionArgumCabecViewPreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != cobGuionArgumCabecViewLastQuery){
		cobGuionArgumCabecViewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cobGuionArgumCabecViewPageCount--;
	cobGuionArgumCabecViewCmdQuery(cobGuionArgumCabecViewPageCount);
}

function cobGuionArgumCabecViewNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != cobGuionArgumCabecViewLastQuery){
		cobGuionArgumCabecViewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cobGuionArgumCabecViewPageCount++;
	cobGuionArgumCabecViewCmdQuery(cobGuionArgumCabecViewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cobGuionArgumCabecViewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cobGuionArgumCabecViewListLayer', 'O');
		visibilidad('cobGuionArgumCabecViewListButtonsLayer', 'O');
		if(get('cobGuionArgumCabecViewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	cobGuionArgumCabecViewLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripci�n en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminaci�n)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:cobGuionArgumCabecViewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cobGuionArgumCabecViewChoiceColumn) + "</A>",
			i, cobGuionArgumCabecViewChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cobGuionArgumCabecViewList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	cobGuionArgumCabecViewTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		cobGuionArgumCabecViewMorePagesFlag = true;
		cobGuionArgumCabecViewList.eliminar(mmgPageSize, 1);
	}else{
		cobGuionArgumCabecViewMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('cobGuionArgumCabecViewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cobGuionArgumCabecViewListLayer', 'V');
	visibilidad('cobGuionArgumCabecViewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cobGuionArgumCabecViewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cobGuionArgumCabecViewList.display();
	
	//Actualizamos el estado de los botones 
	if(cobGuionArgumCabecViewMorePagesFlag){
		set_estado_botonera('cobGuionArgumCabecViewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cobGuionArgumCabecViewPaginationButtonBar',
			3,"inactivo");
	}
	if(cobGuionArgumCabecViewPageCount > 1){
		set_estado_botonera('cobGuionArgumCabecViewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cobGuionArgumCabecViewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cobGuionArgumCabecViewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cobGuionArgumCabecViewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cobGuionArgumCabecViewUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(cobGuionArgumCabecViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cobGuionArgumCabecViewFrm.idSelection', cobGuionArgumCabecViewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('cobGuionArgumCabecViewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = cobGuionArgumCabecViewList.codSeleccionados()[0];
		parametros["previousAction"] = get('cobGuionArgumCabecViewFrm.accion');
		parametros["accion"] = get('cobGuionArgumCabecViewFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CobGuionArgumCabecViewLPStartUp', get('cobGuionArgumCabecViewFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) cobGuionArgumCabecViewCmdRequery();
	}
}

function cobGuionArgumCabecViewRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(cobGuionArgumCabecViewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci�n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cobGuionArgumCabecViewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cobGuionArgumCabecViewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cobGuionArgumCabecViewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cobGuionArgumCabecViewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cobGuionArgumCabecViewFrm.timestamp', timestamps);


	cobGuionArgumCabecViewFrm.oculto='S';
	envia('cobGuionArgumCabecViewFrm');
	cobGuionArgumCabecViewFrm.oculto='N';
}

function cobGuionArgumCabecViewViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(cobGuionArgumCabecViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	cobGuionArgumCabecViewViewDetail(cobGuionArgumCabecViewList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function cobGuionArgumCabecViewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cobGuionArgumCabecViewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CobGuionArgumCabecViewLPStartUp', 'view', parametros, null, null);
}

//Funci�n ejecutada cuando se pulsa el bot�n de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripci�n del idioma por defecto
	//intreoducido directamente a trav�s del widget. Esto se pone debio a que la tecla r�pida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('cobGuionArgumCabecViewFrm', 
		'Descripcion', 1,
		get('cobGuionArgumCabecViewFrm.Descripcion'));	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validaci�n los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('cobGuionArgumCabecViewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('cobGuionArgumCabecViewFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('CobGuionArgumCabecView.Descripcion.requiered.message'));
		focaliza('cobGuionArgumCabecViewFrm.Descripcion');
		return;
	}	
	
	
		
	
	if(validacion){
		cobGuionArgumCabecViewFrm.oculto='S';
		envia('cobGuionArgumCabecViewFrm');
		cobGuionArgumCabecViewFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarqu�a de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('cobGuionArgumCabecViewFrm.paisOidPais').toString() == ''){
		set('cobGuionArgumCabecViewFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'cobGuionArgumCabecView');
		
	}
	
	
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	cobGuionArgumCabecViewRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('cobGuionArgumCabecViewFrm.accion');
	var origenTmp = get('cobGuionArgumCabecViewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cobGuionArgumCabecViewBuildUpdateRecordString() != cobGuionArgumCabecViewTmpUpdateValues){
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
	document.all.cobGuionArgumCabecViewListLayer.style.display='none';
	document.all.cobGuionArgumCabecViewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cobGuionArgumCabecViewListLayer.style.display='';
	document.all.cobGuionArgumCabecViewListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda
	jsCobGuionArgumCabecViewCodGuiaArgu = get('cobGuionArgumCabecViewFrm.codGuiaArgu').toString();
	jsCobGuionArgumCabecViewDescripcion = get('cobGuionArgumCabecViewFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsCobGuionArgumCabecViewCodGuiaArgu + "|";
	parametros += jsCobGuionArgumCabecViewDescripcion + "|";
	
	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cobGuionArgumCabecViewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCobGuionArgumCabecViewCodGuiaArgu + "|";
	parametros += jsCobGuionArgumCabecViewValObse + "|";
	parametros += jsCobGuionArgumCabecViewDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobGuionArgumCabecViewFrm.accion'), 
		get('cobGuionArgumCabecViewFrm.origen'));
	
	jsCobGuionArgumCabecViewId = get('cobGuionArgumCabecViewFrm.id').toString();
	jsCobGuionArgumCabecViewCodGuiaArgu = get('cobGuionArgumCabecViewFrm.codGuiaArgu').toString();
	jsCobGuionArgumCabecViewValObse = get('cobGuionArgumCabecViewFrm.valObse').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsCobGuionArgumCabecViewDescripcion = buildLocalizedString('cobGuionArgumCabecViewFrm', 1);
	}else{
		jsCobGuionArgumCabecViewDescripcion = get('cobGuionArgumCabecViewFrm.Descripcion');
	}
	jsCobGuionArgumCabecViewPaisOidPais = get('cobGuionArgumCabecViewFrm.paisOidPais')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobGuionArgumCabecViewFrm.accion'), 
		get('cobGuionArgumCabecViewFrm.origen'));


	set('cobGuionArgumCabecViewFrm.id', jsCobGuionArgumCabecViewId);
	set('cobGuionArgumCabecViewFrm.codGuiaArgu', jsCobGuionArgumCabecViewCodGuiaArgu);
	set('cobGuionArgumCabecViewFrm.valObse', jsCobGuionArgumCabecViewValObse);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('cobGuionArgumCabecViewFrm', 1,  jsCobGuionArgumCabecViewDescripcion)
		loadLocalizationWidget('cobGuionArgumCabecViewFrm', 'Descripcion', 1);
	}else{
		set('cobGuionArgumCabecViewFrm.Descripcion', jsCobGuionArgumCabecViewDescripcion);		
	}
	set('cobGuionArgumCabecViewFrm.paisOidPais', [jsCobGuionArgumCabecViewPaisOidPais]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la b�squeda
	jsCobGuionArgumCabecViewCodGuiaArgu = '';
	jsCobGuionArgumCabecViewDescripcion = '';
	
}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cobGuionArgumCabecViewFrm.errCodigo', errorCode);
	set('cobGuionArgumCabecViewFrm.errDescripcion', description);
	set('cobGuionArgumCabecViewFrm.errSeverity', severity);
	fMostrarMensajeError();
}

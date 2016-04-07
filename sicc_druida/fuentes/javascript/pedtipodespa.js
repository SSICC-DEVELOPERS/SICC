

/*
    INDRA/CAR/mmg
    $Id: pedtipodespa.js,v 1.1 2009/12/03 19:01:59 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPedTipoDespaId = "";
var jsPedTipoDespaPaisOidPais = "";
var jsPedTipoDespaCodTipoDesp = "";
var jsPedTipoDespaDescripcion = "";
var jsPedTipoDespaIndCron = "";

//Variables de paginacion, 
var pedTipoDespaPageCount = 1;

//Varible de columna que representa el campo de choice
var pedTipoDespaChoiceColumn = 1;

//Flag de siguiente pagina;
var pedTipoDespaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var pedTipoDespaTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var pedTipoDespaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focaliza("pedTipoDespaFrm.codTipoDesp");','focaliza("pedTipoDespaFrm.codTipoDesp");','focaliza("pedTipoDespaFrm.codTipoDesp");','focaliza("pedTipoDespaFrm.codTipoDesp");','focaliza("pedTipoDespaFrm.codTipoDesp");','focaliza("pedTipoDespaFrm.codTipoDesp");'],[4,'focaliza("pedTipoDespaFrm.Descripcion");','focaliza("pedTipoDespaFrm.Descripcion");','focaliza("pedTipoDespaFrm.Descripcion");','focaliza("pedTipoDespaFrm.Descripcion");','focaliza("pedTipoDespaFrm.Descripcion");','focaliza("pedTipoDespaFrm.Descripcion");'],[5,'focaliza("pedTipoDespaFrm.indCron");','focaliza("pedTipoDespaFrm.indCron");','focaliza("pedTipoDespaFrm.indCron");','focaliza("pedTipoDespaFrm.indCron");','focaliza("pedTipoDespaFrm.indCron");','focaliza("pedTipoDespaFrm.indCron");']]);

//Vector con acciones de foco para la pantalla de modificaci�n.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'','','','','',''],[4,'focaliza("pedTipoDespaFrm.Descripcion");','focaliza("pedTipoDespaFrm.Descripcion");','focaliza("pedTipoDespaFrm.Descripcion");','focaliza("pedTipoDespaFrm.Descripcion");','focaliza("pedTipoDespaFrm.Descripcion");','focaliza("pedTipoDespaFrm.Descripcion");'],[5,'focaliza("pedTipoDespaFrm.indCron");','focaliza("pedTipoDespaFrm.indCron");','focaliza("pedTipoDespaFrm.indCron");','focaliza("pedTipoDespaFrm.indCron");','focaliza("pedTipoDespaFrm.indCron");','focaliza("pedTipoDespaFrm.indCron");']]);

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
pedTipoDespaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var pedTipoDespaTmpUpdateValues;



//Funci�n ejecutada en el onload de la pagina
function pedTipoDespaInitComponents(){
	//Deshabilitamos la limpieza gen�rica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('pedTipoDespaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('pedTipoDespaFrm.accion')){
		case "query": pedTipoDespaQueryInitComponents(); break;
		case "view": pedTipoDespaViewInitComponents(); break;
		case "create": pedTipoDespaCreateInitComponents(); break;
		case "update": pedTipoDespaUpdateInitComponents(); break;
		case "remove": pedTipoDespaRemoveInitComponents(); break;
		case "lov": pedTipoDespaLovInitComponents(); break;
	}
	//alert('accion :' + get('pedTipoDespaFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('pedTipoDespaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('pedTipoDespa')) pedTipoDespaCmdRequery();
}

function pedTipoDespaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('pedTipoDespaFrm', true);	
}

function pedTipoDespaViewInitComponents(){
	//Cargamos la descripci�n en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('pedTipoDespaFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('pedTipoDespaFrm', true);
}

function pedTipoDespaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('pedTipoDespaFrm.codTipoDesp','S', GestionarMensaje('PedTipoDespa.codTipoDesp.requiered.message'));
	
	setMV('pedTipoDespaFrm.Descripcion','S', GestionarMensaje('PedTipoDespa.Descripcion.requiered.message'));
	
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('pedTipoDespaFrm', true);
}

function pedTipoDespaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('pedTipoDespaFrm.origen') == "pagina"){
		loadLocalizationWidget('pedTipoDespaFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		pedTipoDespaTmpUpdateValues = pedTipoDespaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('pedTipoDespaFrm.codTipoDesp','S', GestionarMensaje('PedTipoDespa.codTipoDesp.requiered.message'));
		setMV('pedTipoDespaFrm.Descripcion','S', GestionarMensaje('PedTipoDespa.Descripcion.requiered.message'));
		
			focusFirstFieldModify('pedTipoDespaFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('pedTipoDespaFrm', true);
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('pedTipoDespaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function pedTipoDespaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	pedTipoDespaList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera. Al realizar la query se activar�;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('pedTipoDespaFrm', true);
}

function pedTipoDespaLovInitComponents(){
	pedTipoDespaLovReturnParameters = window.dialogArguments;
	
	focusFirstField('pedTipoDespaFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function pedTipoDespaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('pedTipoDespaFrm.' + campo, id);
	set('pedTipoDespaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function pedTipoDespaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	pedTipoDespaLovReturnParameters.id = '';
	pedTipoDespaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function pedTipoDespaLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(pedTipoDespaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = pedTipoDespaList.codSeleccionados();
	var descripcion = pedTipoDespaList.extraeDato(
		pedTipoDespaList.codSeleccionados()[0], pedTipoDespaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	pedTipoDespaLovReturnParameters.id = codigo;
	pedTipoDespaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function pedTipoDespaCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('pedTipoDespaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('pedTipoDespaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "pedTipoDespaList", "PedTipoDespaConectorTransactionQuery", 
		"result_ROWSET", parametros, "pedTipoDespaPostQueryActions(datos);"]], "", "");	
}

function pedTipoDespaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('pedTipoDespaFrm.lastQueryToSession'));
	var i =0;
	set('pedTipoDespaFrm.codTipoDesp', paramsRequery.ij(i++));
	
	set('pedTipoDespaFrm.Descripcion', paramsRequery.ij(i++));
	
	set('pedTipoDespaFrm.indCron', (paramsRequery.ij(i++) == 'true'? 'S': 'N'));
	
	
	
	//Establecemos la p�gina de busqueda como la actual
	pedTipoDespaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	pedTipoDespaCmdQuery(pedTipoDespaPageCount);
}

function pedTipoDespaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	pedTipoDespaPageCount = 1;
	pedTipoDespaCmdQuery(pedTipoDespaPageCount);
}

function pedTipoDespaPreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != pedTipoDespaLastQuery){
		pedTipoDespaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	pedTipoDespaPageCount--;
	pedTipoDespaCmdQuery(pedTipoDespaPageCount);
}

function pedTipoDespaNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != pedTipoDespaLastQuery){
		pedTipoDespaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	pedTipoDespaPageCount++;
	pedTipoDespaCmdQuery(pedTipoDespaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function pedTipoDespaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('pedTipoDespaListLayer', 'O');
		visibilidad('pedTipoDespaListButtonsLayer', 'O');
		if(get('pedTipoDespaFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	pedTipoDespaLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripci�n en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 3) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 3);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 3);
		}
	}
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminaci�n)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:pedTipoDespaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, pedTipoDespaChoiceColumn) + "</A>",
			i, pedTipoDespaChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	pedTipoDespaList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	pedTipoDespaTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		pedTipoDespaMorePagesFlag = true;
		pedTipoDespaList.eliminar(mmgPageSize, 1);
	}else{
		pedTipoDespaMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('pedTipoDespaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('pedTipoDespaListLayer', 'V');
	visibilidad('pedTipoDespaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('pedTipoDespaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	pedTipoDespaList.display();
	
	//Actualizamos el estado de los botones 
	if(pedTipoDespaMorePagesFlag){
		set_estado_botonera('pedTipoDespaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('pedTipoDespaPaginationButtonBar',
			3,"inactivo");
	}
	if(pedTipoDespaPageCount > 1){
		set_estado_botonera('pedTipoDespaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('pedTipoDespaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('pedTipoDespaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('pedTipoDespaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function pedTipoDespaUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(pedTipoDespaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('pedTipoDespaFrm.idSelection', pedTipoDespaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('pedTipoDespaFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = pedTipoDespaList.codSeleccionados()[0];
		parametros["previousAction"] = get('pedTipoDespaFrm.accion');
		parametros["accion"] = get('pedTipoDespaFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('PedTipoDespaLPStartUp', get('pedTipoDespaFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) pedTipoDespaCmdRequery();
	}
}

function pedTipoDespaRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(pedTipoDespaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci�n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = pedTipoDespaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('pedTipoDespaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(pedTipoDespaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += pedTipoDespaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('pedTipoDespaFrm.timestamp', timestamps);


	pedTipoDespaFrm.oculto='S';
	envia('pedTipoDespaFrm');
	pedTipoDespaFrm.oculto='N';
}

function pedTipoDespaViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(pedTipoDespaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	pedTipoDespaViewDetail(pedTipoDespaList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function pedTipoDespaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('pedTipoDespaFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('PedTipoDespaLPStartUp', 'view', parametros, null, null);
}

//Funci�n ejecutada cuando se pulsa el bot�n de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripci�n del idioma por defecto
	//intreoducido directamente a trav�s del widget. Esto se pone debio a que la tecla r�pida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('pedTipoDespaFrm', 
		'Descripcion', 1,
		get('pedTipoDespaFrm.Descripcion'));	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validaci�n los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('pedTipoDespaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('pedTipoDespaFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('PedTipoDespa.Descripcion.requiered.message'));
		focaliza('pedTipoDespaFrm.Descripcion');
		return;
	}	
	
	
		
	
	if(validacion){
		pedTipoDespaFrm.oculto='S';
		envia('pedTipoDespaFrm');
		pedTipoDespaFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarqu�a de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('pedTipoDespaFrm.paisOidPais').toString() == ''){
		set('pedTipoDespaFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'pedTipoDespa');
		
	}
	
	
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	pedTipoDespaRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('pedTipoDespaFrm.accion');
	var origenTmp = get('pedTipoDespaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(pedTipoDespaBuildUpdateRecordString() != pedTipoDespaTmpUpdateValues){
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
	document.all.pedTipoDespaListLayer.style.display='none';
	document.all.pedTipoDespaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.pedTipoDespaListLayer.style.display='';
	document.all.pedTipoDespaListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda
	jsPedTipoDespaCodTipoDesp = get('pedTipoDespaFrm.codTipoDesp').toString();
	jsPedTipoDespaDescripcion = get('pedTipoDespaFrm.Descripcion').toString();
	if(get('pedTipoDespaFrm.indCron').toString() == 'S') jsPedTipoDespaIndCron = "true";
	else jsPedTipoDespaIndCron = "false";
	
	
	var parametros = "";
	parametros += jsPedTipoDespaCodTipoDesp + "|";
	parametros += jsPedTipoDespaDescripcion + "|";
	parametros += jsPedTipoDespaIndCron + "|";
	
	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function pedTipoDespaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPedTipoDespaCodTipoDesp + "|";
	parametros += jsPedTipoDespaDescripcion + "|";
	parametros += jsPedTipoDespaIndCron + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedTipoDespaFrm.accion'), 
		get('pedTipoDespaFrm.origen'));
	
	jsPedTipoDespaId = get('pedTipoDespaFrm.id').toString();
	jsPedTipoDespaPaisOidPais = get('pedTipoDespaFrm.paisOidPais')[0];
	jsPedTipoDespaCodTipoDesp = get('pedTipoDespaFrm.codTipoDesp').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsPedTipoDespaDescripcion = buildLocalizedString('pedTipoDespaFrm', 1);
	}else{
		jsPedTipoDespaDescripcion = get('pedTipoDespaFrm.Descripcion');
	}
	if(get('pedTipoDespaFrm.indCron').toString() == 'S') jsPedTipoDespaIndCron = "true";
		else jsPedTipoDespaIndCron = "false";
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedTipoDespaFrm.accion'), 
		get('pedTipoDespaFrm.origen'));


	set('pedTipoDespaFrm.id', jsPedTipoDespaId);
	set('pedTipoDespaFrm.paisOidPais', [jsPedTipoDespaPaisOidPais]);
	set('pedTipoDespaFrm.codTipoDesp', jsPedTipoDespaCodTipoDesp);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('pedTipoDespaFrm', 1,  jsPedTipoDespaDescripcion)
		loadLocalizationWidget('pedTipoDespaFrm', 'Descripcion', 1);
	}else{
		set('pedTipoDespaFrm.Descripcion', jsPedTipoDespaDescripcion);		
	}
	
			
			if(jsPedTipoDespaIndCron == "true") set('pedTipoDespaFrm.indCron', 'S');
			else set('pedTipoDespaFrm.indCron', 'N');
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la b�squeda
	jsPedTipoDespaCodTipoDesp = '';
	jsPedTipoDespaDescripcion = '';
	jsPedTipoDespaIndCron = '';
	
}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('pedTipoDespaFrm.errCodigo', errorCode);
	set('pedTipoDespaFrm.errDescripcion', description);
	set('pedTipoDespaFrm.errSeverity', severity);
	fMostrarMensajeError();
}

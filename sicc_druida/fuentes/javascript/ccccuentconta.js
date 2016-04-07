

/*
    INDRA/CAR/mmg
    $Id: ccccuentconta.js,v 1.1 2009/12/03 19:01:59 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCccCuentContaId = "";
var jsCccCuentContaPaisOidPais = "";
var jsCccCuentContaCodCuenCont = "";
var jsCccCuentContaDescripcion = "";
var jsCccCuentContaCodCuenSap = "";
var jsCccCuentContaValObse = "";

//Variables de paginacion, 
var cccCuentContaPageCount = 1;

//Varible de columna que representa el campo de choice
var cccCuentContaChoiceColumn = 1;

//Flag de siguiente pagina;
var cccCuentContaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cccCuentContaTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 105;
var sizeFormView = 149;
var sizeFormUpdate = 149;

//Ultima busqueda realizada
var cccCuentContaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focaliza("cccCuentContaFrm.codCuenCont");','focaliza("cccCuentContaFrm.codCuenCont");','focaliza("cccCuentContaFrm.codCuenCont");','focaliza("cccCuentContaFrm.codCuenCont");','focaliza("cccCuentContaFrm.codCuenCont");','focaliza("cccCuentContaFrm.codCuenCont");'],[4,'focaliza("cccCuentContaFrm.Descripcion");','focaliza("cccCuentContaFrm.Descripcion");','focaliza("cccCuentContaFrm.Descripcion");','focaliza("cccCuentContaFrm.Descripcion");','focaliza("cccCuentContaFrm.Descripcion");','focaliza("cccCuentContaFrm.Descripcion");'],[5,'focaliza("cccCuentContaFrm.codCuenSap");','focaliza("cccCuentContaFrm.codCuenSap");','focaliza("cccCuentContaFrm.codCuenSap");','focaliza("cccCuentContaFrm.codCuenSap");','focaliza("cccCuentContaFrm.codCuenSap");','focaliza("cccCuentContaFrm.codCuenSap");'],[6,'','focaliza("cccCuentContaFrm.valObse");','focaliza("cccCuentContaFrm.valObse");','','focaliza("cccCuentContaFrm.valObse");','focaliza("cccCuentContaFrm.valObse");']]);

//Vector con acciones de foco para la pantalla de modificaci�n.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'','','','','',''],[4,'focaliza("cccCuentContaFrm.Descripcion");','focaliza("cccCuentContaFrm.Descripcion");','focaliza("cccCuentContaFrm.Descripcion");','focaliza("cccCuentContaFrm.Descripcion");','focaliza("cccCuentContaFrm.Descripcion");','focaliza("cccCuentContaFrm.Descripcion");'],[5,'focaliza("cccCuentContaFrm.codCuenSap");','focaliza("cccCuentContaFrm.codCuenSap");','focaliza("cccCuentContaFrm.codCuenSap");','focaliza("cccCuentContaFrm.codCuenSap");','focaliza("cccCuentContaFrm.codCuenSap");','focaliza("cccCuentContaFrm.codCuenSap");'],[6,'','focaliza("cccCuentContaFrm.valObse");','focaliza("cccCuentContaFrm.valObse");','','focaliza("cccCuentContaFrm.valObse");','focaliza("cccCuentContaFrm.valObse");']]);

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
cccCuentContaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var cccCuentContaTmpUpdateValues;



//Funci�n ejecutada en el onload de la pagina
function cccCuentContaInitComponents(){
	//Deshabilitamos la limpieza gen�rica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('cccCuentContaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('cccCuentContaFrm.accion')){
		case "query": cccCuentContaQueryInitComponents(); break;
		case "view": cccCuentContaViewInitComponents(); break;
		case "create": cccCuentContaCreateInitComponents(); break;
		case "update": cccCuentContaUpdateInitComponents(); break;
		case "remove": cccCuentContaRemoveInitComponents(); break;
		case "lov": cccCuentContaLovInitComponents(); break;
	}
	//alert('accion :' + get('cccCuentContaFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('cccCuentContaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cccCuentConta')) cccCuentContaCmdRequery();
}

function cccCuentContaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('cccCuentContaFrm', true);	
}

function cccCuentContaViewInitComponents(){
	//Cargamos la descripci�n en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('cccCuentContaFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('cccCuentContaFrm', true);
}

function cccCuentContaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cccCuentContaFrm.codCuenCont','S', GestionarMensaje('CccCuentConta.codCuenCont.requiered.message'));
	
	setMV('cccCuentContaFrm.Descripcion','S', GestionarMensaje('CccCuentConta.Descripcion.requiered.message'));
	
	setMV('cccCuentContaFrm.codCuenSap','S', GestionarMensaje('CccCuentConta.codCuenSap.requiered.message'));
	
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('cccCuentContaFrm', true);
}

function cccCuentContaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('cccCuentContaFrm.origen') == "pagina"){
		loadLocalizationWidget('cccCuentContaFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		cccCuentContaTmpUpdateValues = cccCuentContaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cccCuentContaFrm.codCuenCont','S', GestionarMensaje('CccCuentConta.codCuenCont.requiered.message'));
		setMV('cccCuentContaFrm.Descripcion','S', GestionarMensaje('CccCuentConta.Descripcion.requiered.message'));
		setMV('cccCuentContaFrm.codCuenSap','S', GestionarMensaje('CccCuentConta.codCuenSap.requiered.message'));
		
			focusFirstFieldModify('cccCuentContaFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('cccCuentContaFrm', true);
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('cccCuentContaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cccCuentContaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	cccCuentContaList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera. Al realizar la query se activar�;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('cccCuentContaFrm', true);
}

function cccCuentContaLovInitComponents(){
	cccCuentContaLovReturnParameters = window.dialogArguments;
	
	focusFirstField('cccCuentContaFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad








//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function cccCuentContaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cccCuentContaFrm.' + campo, id);
	set('cccCuentContaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function cccCuentContaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cccCuentContaLovReturnParameters.id = '';
	cccCuentContaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cccCuentContaLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(cccCuentContaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cccCuentContaList.codSeleccionados();
	var descripcion = cccCuentContaList.extraeDato(
		cccCuentContaList.codSeleccionados()[0], cccCuentContaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cccCuentContaLovReturnParameters.id = codigo;
	cccCuentContaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function cccCuentContaCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cccCuentContaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('cccCuentContaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cccCuentContaList", "CccCuentContaConectorTransactionQuery", 
		"result_ROWSET", parametros, "cccCuentContaPostQueryActions(datos);"]], "", "");	
}

function cccCuentContaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cccCuentContaFrm.lastQueryToSession'));
	var i =0;
	set('cccCuentContaFrm.codCuenCont', paramsRequery.ij(i++));
	
	set('cccCuentContaFrm.Descripcion', paramsRequery.ij(i++));
	
	set('cccCuentContaFrm.codCuenSap', paramsRequery.ij(i++));
	
	
	
	//Establecemos la p�gina de busqueda como la actual
	cccCuentContaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cccCuentContaCmdQuery(cccCuentContaPageCount);
}

function cccCuentContaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cccCuentContaPageCount = 1;
	cccCuentContaCmdQuery(cccCuentContaPageCount);
}

function cccCuentContaPreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != cccCuentContaLastQuery){
		cccCuentContaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cccCuentContaPageCount--;
	cccCuentContaCmdQuery(cccCuentContaPageCount);
}

function cccCuentContaNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != cccCuentContaLastQuery){
		cccCuentContaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cccCuentContaPageCount++;
	cccCuentContaCmdQuery(cccCuentContaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cccCuentContaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cccCuentContaListLayer', 'O');
		visibilidad('cccCuentContaListButtonsLayer', 'O');
		if(get('cccCuentContaFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	cccCuentContaLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripci�n en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminaci�n)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:cccCuentContaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cccCuentContaChoiceColumn) + "</A>",
			i, cccCuentContaChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cccCuentContaList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	cccCuentContaTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		cccCuentContaMorePagesFlag = true;
		cccCuentContaList.eliminar(mmgPageSize, 1);
	}else{
		cccCuentContaMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('cccCuentContaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cccCuentContaListLayer', 'V');
	visibilidad('cccCuentContaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cccCuentContaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cccCuentContaList.display();
	
	//Actualizamos el estado de los botones 
	if(cccCuentContaMorePagesFlag){
		set_estado_botonera('cccCuentContaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cccCuentContaPaginationButtonBar',
			3,"inactivo");
	}
	if(cccCuentContaPageCount > 1){
		set_estado_botonera('cccCuentContaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cccCuentContaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cccCuentContaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cccCuentContaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cccCuentContaUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(cccCuentContaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cccCuentContaFrm.idSelection', cccCuentContaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('cccCuentContaFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = cccCuentContaList.codSeleccionados()[0];
		parametros["previousAction"] = get('cccCuentContaFrm.accion');
		parametros["accion"] = get('cccCuentContaFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CccCuentContaLPStartUp', get('cccCuentContaFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) cccCuentContaCmdRequery();
	}
}

function cccCuentContaRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(cccCuentContaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci�n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cccCuentContaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cccCuentContaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cccCuentContaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cccCuentContaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cccCuentContaFrm.timestamp', timestamps);


	cccCuentContaFrm.oculto='S';
	envia('cccCuentContaFrm');
	cccCuentContaFrm.oculto='N';
}

function cccCuentContaViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(cccCuentContaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	cccCuentContaViewDetail(cccCuentContaList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function cccCuentContaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cccCuentContaFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CccCuentContaLPStartUp', 'view', parametros, null, null);
}

//Funci�n ejecutada cuando se pulsa el bot�n de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripci�n del idioma por defecto
	//intreoducido directamente a trav�s del widget. Esto se pone debio a que la tecla r�pida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	// splatas - 20/07/2006 - DBLG500000869
	var observaciones = get("cccCuentContaFrm.valObse");
	set("cccCuentContaFrm.valObse", observaciones);
	
	
	setDefaultLanguageValue('cccCuentContaFrm', 
		'Descripcion', 1,
		get('cccCuentContaFrm.Descripcion'));	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validaci�n los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('cccCuentContaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('cccCuentContaFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('CccCuentConta.Descripcion.requiered.message'));
		focaliza('cccCuentContaFrm.Descripcion');
		return;
	}	
	
	
	
		
	
	if(validacion){
		cccCuentContaFrm.oculto='S';
		envia('cccCuentContaFrm');
		cccCuentContaFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarqu�a de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('cccCuentContaFrm.paisOidPais').toString() == ''){
		set('cccCuentContaFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'cccCuentConta');
		
	}
	
	
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	cccCuentContaRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('cccCuentContaFrm.accion');
	var origenTmp = get('cccCuentContaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cccCuentContaBuildUpdateRecordString() != cccCuentContaTmpUpdateValues){
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
	document.all.cccCuentContaListLayer.style.display='none';
	document.all.cccCuentContaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cccCuentContaListLayer.style.display='';
	document.all.cccCuentContaListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda
	jsCccCuentContaCodCuenCont = get('cccCuentContaFrm.codCuenCont').toString();
	jsCccCuentContaDescripcion = get('cccCuentContaFrm.Descripcion').toString();
	jsCccCuentContaCodCuenSap = get('cccCuentContaFrm.codCuenSap').toString();
	
	
	var parametros = "";
	parametros += jsCccCuentContaCodCuenCont + "|";
	parametros += jsCccCuentContaDescripcion + "|";
	parametros += jsCccCuentContaCodCuenSap + "|";
	
	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cccCuentContaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCccCuentContaCodCuenCont + "|";
	parametros += jsCccCuentContaDescripcion + "|";
	parametros += jsCccCuentContaCodCuenSap + "|";
	parametros += jsCccCuentContaValObse + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cccCuentContaFrm.accion'), 
		get('cccCuentContaFrm.origen'));
	
	jsCccCuentContaId = get('cccCuentContaFrm.id').toString();
	jsCccCuentContaPaisOidPais = get('cccCuentContaFrm.paisOidPais')[0];
	jsCccCuentContaCodCuenCont = get('cccCuentContaFrm.codCuenCont').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsCccCuentContaDescripcion = buildLocalizedString('cccCuentContaFrm', 1);
	}else{
		jsCccCuentContaDescripcion = get('cccCuentContaFrm.Descripcion');
	}
	jsCccCuentContaCodCuenSap = get('cccCuentContaFrm.codCuenSap').toString();
	jsCccCuentContaValObse = get('cccCuentContaFrm.valObse').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cccCuentContaFrm.accion'), 
		get('cccCuentContaFrm.origen'));


	set('cccCuentContaFrm.id', jsCccCuentContaId);
	set('cccCuentContaFrm.paisOidPais', [jsCccCuentContaPaisOidPais]);
	set('cccCuentContaFrm.codCuenCont', jsCccCuentContaCodCuenCont);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('cccCuentContaFrm', 1,  jsCccCuentContaDescripcion)
		loadLocalizationWidget('cccCuentContaFrm', 'Descripcion', 1);
	}else{
		set('cccCuentContaFrm.Descripcion', jsCccCuentContaDescripcion);		
	}
	set('cccCuentContaFrm.codCuenSap', jsCccCuentContaCodCuenSap);
	set('cccCuentContaFrm.valObse', jsCccCuentContaValObse);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la b�squeda
	jsCccCuentContaCodCuenCont = '';
	jsCccCuentContaDescripcion = '';
	jsCccCuentContaCodCuenSap = '';
	
}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cccCuentContaFrm.errCodigo', errorCode);
	set('cccCuentContaFrm.errDescripcion', description);
	set('cccCuentContaFrm.errSeverity', severity);
	fMostrarMensajeError();
}

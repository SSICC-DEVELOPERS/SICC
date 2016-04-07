

/*
    INDRA/CAR/mmg
    $Id: calatribestadconta.js,v 1.1 2009/12/03 19:02:28 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCalAtribEstadContaId = "";
var jsCalAtribEstadContaTecoOidTipoEstaCont = "";
var jsCalAtribEstadContaCodAtri = "";
var jsCalAtribEstadContaDescripcion = "";

//Variables de paginacion, 
var calAtribEstadContaPageCount = 1;

//Varible de columna que representa el campo de choice
var calAtribEstadContaChoiceColumn = 2;

//Flag de siguiente pagina;
var calAtribEstadContaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var calAtribEstadContaTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var calAtribEstadContaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("calAtribEstadConta","tecoOidTipoEstaCont", false);','focalizaComboDependence("calAtribEstadConta","tecoOidTipoEstaCont", false);','focalizaComboDependence("calAtribEstadConta","tecoOidTipoEstaCont", false);','focalizaComboDependence("calAtribEstadConta","tecoOidTipoEstaCont", true);','focalizaComboDependence("calAtribEstadConta","tecoOidTipoEstaCont", true);','focalizaComboDependence("calAtribEstadConta","tecoOidTipoEstaCont", true);'],[3,'focaliza("calAtribEstadContaFrm.codAtri");','focaliza("calAtribEstadContaFrm.codAtri");','focaliza("calAtribEstadContaFrm.codAtri");','focaliza("calAtribEstadContaFrm.codAtri");','focaliza("calAtribEstadContaFrm.codAtri");','focaliza("calAtribEstadContaFrm.codAtri");'],[4,'focaliza("calAtribEstadContaFrm.Descripcion");','focaliza("calAtribEstadContaFrm.Descripcion");','focaliza("calAtribEstadContaFrm.Descripcion");','focaliza("calAtribEstadContaFrm.Descripcion");','focaliza("calAtribEstadContaFrm.Descripcion");','focaliza("calAtribEstadContaFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificaci�n.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'focaliza("calAtribEstadContaFrm.Descripcion");','focaliza("calAtribEstadContaFrm.Descripcion");','focaliza("calAtribEstadContaFrm.Descripcion");','focaliza("calAtribEstadContaFrm.Descripcion");','focaliza("calAtribEstadContaFrm.Descripcion");','focaliza("calAtribEstadContaFrm.Descripcion");']]);

//Creamos la informaci�n de las jerarqu�as de dependencias de combos (si existen)
//Para cada jerarqu�a de dependencia definimos un vector donde se defina la jerar�a
//La definici�n de la jerarqu�a consiste en definir para cada combo de la jerarqu�a cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de �l para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedar�an [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var tecoOidTipoEstaContDependeceMap = new Vector();
tecoOidTipoEstaContDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tecoOidTipoEstaContDependeceMap.agregar(['tecoOidTipoEstaCont', padresTmp, '', 'CalTipoEstadConta']);

	
//variable conreferencia al obejto usado para devolver los resultados de una b�squeda lov
calAtribEstadContaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var calAtribEstadContaTmpUpdateValues;



//Funci�n ejecutada en el onload de la pagina
function calAtribEstadContaInitComponents(){
	//Deshabilitamos la limpieza gen�rica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('calAtribEstadContaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('calAtribEstadContaFrm.accion')){
		case "query": calAtribEstadContaQueryInitComponents(); break;
		case "view": calAtribEstadContaViewInitComponents(); break;
		case "create": calAtribEstadContaCreateInitComponents(); break;
		case "update": calAtribEstadContaUpdateInitComponents(); break;
		case "remove": calAtribEstadContaRemoveInitComponents(); break;
		case "lov": calAtribEstadContaLovInitComponents(); break;
	}
	//alert('accion :' + get('calAtribEstadContaFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('calAtribEstadContaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('calAtribEstadConta')) calAtribEstadContaCmdRequery();
}

function calAtribEstadContaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('calAtribEstadContaFrm', true);	
}

function calAtribEstadContaViewInitComponents(){
	//Cargamos la descripci�n en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('calAtribEstadContaFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('calAtribEstadContaFrm', true);
}

function calAtribEstadContaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('calAtribEstadContaFrm.tecoOidTipoEstaCont','S', GestionarMensaje('CalAtribEstadConta.tecoOidTipoEstaCont.requiered.message'));
	
	setMV('calAtribEstadContaFrm.codAtri','S', GestionarMensaje('CalAtribEstadConta.codAtri.requiered.message'));
	
	setMV('calAtribEstadContaFrm.Descripcion','S', GestionarMensaje('CalAtribEstadConta.Descripcion.requiered.message'));
	
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('calAtribEstadContaFrm', true);
}

function calAtribEstadContaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('calAtribEstadContaFrm.origen') == "pagina"){
		loadLocalizationWidget('calAtribEstadContaFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		calAtribEstadContaTmpUpdateValues = calAtribEstadContaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('calAtribEstadContaFrm.tecoOidTipoEstaCont','S', GestionarMensaje('CalAtribEstadConta.tecoOidTipoEstaCont.requiered.message'));
		setMV('calAtribEstadContaFrm.codAtri','S', GestionarMensaje('CalAtribEstadConta.codAtri.requiered.message'));
		setMV('calAtribEstadContaFrm.Descripcion','S', GestionarMensaje('CalAtribEstadConta.Descripcion.requiered.message'));
		
			focusFirstFieldModify('calAtribEstadContaFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('calAtribEstadContaFrm', true);
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('calAtribEstadContaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function calAtribEstadContaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	calAtribEstadContaList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera. Al realizar la query se activar�;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('calAtribEstadContaFrm', true);
}

function calAtribEstadContaLovInitComponents(){
	calAtribEstadContaLovReturnParameters = window.dialogArguments;
	
	focusFirstField('calAtribEstadContaFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function calAtribEstadContaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('calAtribEstadContaFrm.' + campo, id);
	set('calAtribEstadContaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function calAtribEstadContaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	calAtribEstadContaLovReturnParameters.id = '';
	calAtribEstadContaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function calAtribEstadContaLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(calAtribEstadContaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = calAtribEstadContaList.codSeleccionados();
	var descripcion = calAtribEstadContaList.extraeDato(
		calAtribEstadContaList.codSeleccionados()[0], calAtribEstadContaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	calAtribEstadContaLovReturnParameters.id = codigo;
	calAtribEstadContaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function calAtribEstadContaCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('calAtribEstadContaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('calAtribEstadContaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "calAtribEstadContaList", "CalAtribEstadContaConectorTransactionQuery", 
		"result_ROWSET", parametros, "calAtribEstadContaPostQueryActions(datos);"]], "", "");	
}

function calAtribEstadContaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('calAtribEstadContaFrm.lastQueryToSession'));
	var i =0;
	set('calAtribEstadContaFrm.tecoOidTipoEstaCont', [paramsRequery.ij(i++)]);
	
	set('calAtribEstadContaFrm.codAtri', paramsRequery.ij(i++));
	
	set('calAtribEstadContaFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la p�gina de busqueda como la actual
	calAtribEstadContaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	calAtribEstadContaCmdQuery(calAtribEstadContaPageCount);
}

function calAtribEstadContaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	calAtribEstadContaPageCount = 1;
	calAtribEstadContaCmdQuery(calAtribEstadContaPageCount);
}

function calAtribEstadContaPreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != calAtribEstadContaLastQuery){
		calAtribEstadContaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	calAtribEstadContaPageCount--;
	calAtribEstadContaCmdQuery(calAtribEstadContaPageCount);
}

function calAtribEstadContaNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != calAtribEstadContaLastQuery){
		calAtribEstadContaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	calAtribEstadContaPageCount++;
	calAtribEstadContaCmdQuery(calAtribEstadContaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function calAtribEstadContaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('calAtribEstadContaListLayer', 'O');
		visibilidad('calAtribEstadContaListButtonsLayer', 'O');
		if(get('calAtribEstadContaFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	calAtribEstadContaLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripci�n en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminaci�n)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:calAtribEstadContaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, calAtribEstadContaChoiceColumn) + "</A>",
			i, calAtribEstadContaChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	calAtribEstadContaList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	calAtribEstadContaTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		calAtribEstadContaMorePagesFlag = true;
		calAtribEstadContaList.eliminar(mmgPageSize, 1);
	}else{
		calAtribEstadContaMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('calAtribEstadContaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('calAtribEstadContaListLayer', 'V');
	visibilidad('calAtribEstadContaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('calAtribEstadContaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	calAtribEstadContaList.display();
	
	//Actualizamos el estado de los botones 
	if(calAtribEstadContaMorePagesFlag){
		set_estado_botonera('calAtribEstadContaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('calAtribEstadContaPaginationButtonBar',
			3,"inactivo");
	}
	if(calAtribEstadContaPageCount > 1){
		set_estado_botonera('calAtribEstadContaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('calAtribEstadContaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('calAtribEstadContaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('calAtribEstadContaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function calAtribEstadContaUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(calAtribEstadContaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('calAtribEstadContaFrm.idSelection', calAtribEstadContaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('calAtribEstadContaFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = calAtribEstadContaList.codSeleccionados()[0];
		parametros["previousAction"] = get('calAtribEstadContaFrm.accion');
		parametros["accion"] = get('calAtribEstadContaFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CalAtribEstadContaLPStartUp', get('calAtribEstadContaFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) calAtribEstadContaCmdRequery();
	}
}

function calAtribEstadContaRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(calAtribEstadContaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci�n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = calAtribEstadContaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('calAtribEstadContaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(calAtribEstadContaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += calAtribEstadContaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('calAtribEstadContaFrm.timestamp', timestamps);


	calAtribEstadContaFrm.oculto='S';
	envia('calAtribEstadContaFrm');
	calAtribEstadContaFrm.oculto='N';
}

function calAtribEstadContaViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(calAtribEstadContaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	calAtribEstadContaViewDetail(calAtribEstadContaList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function calAtribEstadContaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('calAtribEstadContaFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CalAtribEstadContaLPStartUp', 'view', parametros, null, null);
}

//Funci�n ejecutada cuando se pulsa el bot�n de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripci�n del idioma por defecto
	//intreoducido directamente a trav�s del widget. Esto se pone debio a que la tecla r�pida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('calAtribEstadContaFrm', 
		'Descripcion', 1,
		get('calAtribEstadContaFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validaci�n los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('calAtribEstadContaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('calAtribEstadContaFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('CalAtribEstadConta.Descripcion.requiered.message'));
		focaliza('calAtribEstadContaFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		calAtribEstadContaFrm.oculto='S';
		envia('calAtribEstadContaFrm');
		calAtribEstadContaFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarqu�a de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('calAtribEstadContaFrm.tecoOidTipoEstaCont').toString() == ''){
		set('calAtribEstadContaFrm.tecoOidTipoEstaCont', []);
		mmgResetCombosOnCascade('tecoOidTipoEstaCont', 'tecoOidTipoEstaCont', 'calAtribEstadConta');
		
	}
	
	
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	calAtribEstadContaRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('calAtribEstadContaFrm.accion');
	var origenTmp = get('calAtribEstadContaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(calAtribEstadContaBuildUpdateRecordString() != calAtribEstadContaTmpUpdateValues){
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
	document.all.calAtribEstadContaListLayer.style.display='none';
	document.all.calAtribEstadContaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.calAtribEstadContaListLayer.style.display='';
	document.all.calAtribEstadContaListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda
	jsCalAtribEstadContaTecoOidTipoEstaCont = get('calAtribEstadContaFrm.tecoOidTipoEstaCont')[0];
	jsCalAtribEstadContaCodAtri = get('calAtribEstadContaFrm.codAtri').toString();
	jsCalAtribEstadContaDescripcion = get('calAtribEstadContaFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsCalAtribEstadContaTecoOidTipoEstaCont + "|";
	parametros += jsCalAtribEstadContaCodAtri + "|";
	parametros += jsCalAtribEstadContaDescripcion + "|";
	
	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function calAtribEstadContaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCalAtribEstadContaTecoOidTipoEstaCont + "|";
	parametros += jsCalAtribEstadContaCodAtri + "|";
	parametros += jsCalAtribEstadContaDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('calAtribEstadContaFrm.accion'), 
		get('calAtribEstadContaFrm.origen'));
	
	jsCalAtribEstadContaId = get('calAtribEstadContaFrm.id').toString();
	jsCalAtribEstadContaTecoOidTipoEstaCont = get('calAtribEstadContaFrm.tecoOidTipoEstaCont')[0];
	jsCalAtribEstadContaCodAtri = get('calAtribEstadContaFrm.codAtri').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsCalAtribEstadContaDescripcion = buildLocalizedString('calAtribEstadContaFrm', 1);
	}else{
		jsCalAtribEstadContaDescripcion = get('calAtribEstadContaFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('calAtribEstadContaFrm.accion'), 
		get('calAtribEstadContaFrm.origen'));


	set('calAtribEstadContaFrm.id', jsCalAtribEstadContaId);
	set('calAtribEstadContaFrm.tecoOidTipoEstaCont', [jsCalAtribEstadContaTecoOidTipoEstaCont]);
	set('calAtribEstadContaFrm.codAtri', jsCalAtribEstadContaCodAtri);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('calAtribEstadContaFrm', 1,  jsCalAtribEstadContaDescripcion)
		loadLocalizationWidget('calAtribEstadContaFrm', 'Descripcion', 1);
	}else{
		set('calAtribEstadContaFrm.Descripcion', jsCalAtribEstadContaDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la b�squeda
	jsCalAtribEstadContaTecoOidTipoEstaCont = '';
	jsCalAtribEstadContaCodAtri = '';
	jsCalAtribEstadContaDescripcion = '';
	
}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('calAtribEstadContaFrm.errCodigo', errorCode);
	set('calAtribEstadContaFrm.errDescripcion', description);
	set('calAtribEstadContaFrm.errSeverity', severity);
	fMostrarMensajeError();
}



/*
    INDRA/CAR/mmg
    $Id: maeencuense_old.js,v 1.1 2009/12/03 19:01:30 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeEncueNseId = "";
var jsMaeEncueNsePaisOidPais = "";
var jsMaeEncueNseCodTipoEncu = "";
var jsMaeEncueNseDescripcion = "";
var jsMaeEncueNsePrenOidPreg = "";
var jsMaeEncueNseValPesoPreg = "";
var jsMaeEncueNseMarcOidMarc = "";

//Variables de paginacion, 
var maeEncueNsePageCount = 1;

//Varible de columna que representa el campo de choice
var maeEncueNseChoiceColumn = 1;

//Flag de siguiente pagina;
var maeEncueNseMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeEncueNseTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 395;
var sizeFormView = 325;
var sizeFormUpdate = 290;

//Ultima busqueda realizada
var maeEncueNseLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("maeEncueNse","paisOidPais", false);','','focalizaComboDependence("maeEncueNse","paisOidPais", false);','focalizaComboDependence("maeEncueNse","paisOidPais", true);','','focalizaComboDependence("maeEncueNse","paisOidPais", true);'],[3,'focaliza("maeEncueNseFrm.codTipoEncu");','focaliza("maeEncueNseFrm.codTipoEncu");','','focaliza("maeEncueNseFrm.codTipoEncu");','focaliza("maeEncueNseFrm.codTipoEncu");',''],[4,'focaliza("maeEncueNseFrm.Descripcion");','focaliza("maeEncueNseFrm.Descripcion");','focaliza("maeEncueNseFrm.Descripcion");','focaliza("maeEncueNseFrm.Descripcion");','focaliza("maeEncueNseFrm.Descripcion");','focaliza("maeEncueNseFrm.Descripcion");'],[5,'focalizaComboDependence("maeEncueNse","prenOidPreg", false);','focalizaComboDependence("maeEncueNse","prenOidPreg", false);','','focalizaComboDependence("maeEncueNse","prenOidPreg", true);','focalizaComboDependence("maeEncueNse","prenOidPreg", true);',''],[6,'focaliza("maeEncueNseFrm.valPesoPreg");','focaliza("maeEncueNseFrm.valPesoPreg");','focaliza("maeEncueNseFrm.valPesoPreg");','focaliza("maeEncueNseFrm.valPesoPreg");','focaliza("maeEncueNseFrm.valPesoPreg");','focaliza("maeEncueNseFrm.valPesoPreg");'],[7,'focalizaComboDependence("maeEncueNse","marcOidMarc", false);','focalizaComboDependence("maeEncueNse","marcOidMarc", false);','focalizaComboDependence("maeEncueNse","marcOidMarc", false);','focalizaComboDependence("maeEncueNse","marcOidMarc", true);','focalizaComboDependence("maeEncueNse","marcOidMarc", true);','focalizaComboDependence("maeEncueNse","marcOidMarc", true);']]);

//Creamos la informaci�n de las jerarqu�as de dependencias de combos (si existen)
//Para cada jerarqu�a de dependencia definimos un vector donde se defina la jerar�a
//La definici�n de la jerarqu� consiste en definir para cada combo de la jerarqu�a cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de �l para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedar�an [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);
var prenOidPregDependeceMap = new Vector();
prenOidPregDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
prenOidPregDependeceMap.agregar(['prenOidPreg', padresTmp, '', 'MaePreguEncue']);
var marcOidMarcDependeceMap = new Vector();
marcOidMarcDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
marcOidMarcDependeceMap.agregar(['marcOidMarc', padresTmp, '', 'SegMarca']);

	
//variable conreferencia al obejto usado para devolver los resultados de una b�squeda lov
maeEncueNseLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var maeEncueNseTmpUpdateValues;


//Funci�n ejecutada en el onload de la pagina
function maeEncueNseInitComponents(){
	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('maeEncueNseFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('maeEncueNseFrm.accion')){
		case "query": maeEncueNseQueryInitComponents(); break;
		case "view": maeEncueNseViewInitComponents(); break;
		case "create": maeEncueNseCreateInitComponents(); break;
		case "update": maeEncueNseUpdateInitComponents(); break;
		case "remove": maeEncueNseRemoveInitComponents(); break;
		case "lov": maeEncueNseLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('maeEncueNseFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeEncueNse')) maeEncueNseCmdRequery();
}

function maeEncueNseQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
}

function maeEncueNseViewInitComponents(){
	//En principiono se hace nada
}

function maeEncueNseCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeEncueNseFrm.codTipoEncu','S', GestionarMensaje('MaeEncueNse.codTipoEncu.requiered.message'));
	
	setMV('maeEncueNseFrm.Descripcion','S', GestionarMensaje('MaeEncueNse.Descripcion.requiered.message'));
	
	setMV('maeEncueNseFrm.prenOidPreg','S', GestionarMensaje('MaeEncueNse.prenOidPreg.requiered.message'));
	
	setMV('maeEncueNseFrm.valPesoPreg','S', GestionarMensaje('MaeEncueNse.valPesoPreg.requiered.message'));
	
	setMV('maeEncueNseFrm.marcOidMarc','S', GestionarMensaje('MaeEncueNse.marcOidMarc.requiered.message'));
	
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function maeEncueNseUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('maeEncueNseFrm.origen') == "pagina"){
		loadLocalizationWidget('maeEncueNseFrm', 'Descripcion', 1);
		

		//Registramos el valor del elemento que estamos modificando
		maeEncueNseTmpUpdateValues = maeEncueNseBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeEncueNseFrm.paisOidPais','S', GestionarMensaje('MaeEncueNse.paisOidPais.requiered.message'));
		
		setMV('maeEncueNseFrm.Descripcion','S', GestionarMensaje('MaeEncueNse.Descripcion.requiered.message'));
		
		setMV('maeEncueNseFrm.valPesoPreg','S', GestionarMensaje('MaeEncueNse.valPesoPreg.requiered.message'));
		
		setMV('maeEncueNseFrm.marcOidMarc','S', GestionarMensaje('MaeEncueNse.marcOidMarc.requiered.message'));
		
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('maeEncueNseFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeEncueNseRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	maeEncueNseList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function maeEncueNseLovInitComponents(){
	maeEncueNseLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad









//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function maeEncueNseSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeEncueNseFrm.' + campo, id);
	set('maeEncueNseFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function maeEncueNseLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeEncueNseLovReturnParameters.id = '';
	maeEncueNseLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeEncueNseLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(maeEncueNseList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeEncueNseList.codSeleccionados();
	var descripcion = maeEncueNseList.extraeDato(
		maeEncueNseList.codSeleccionados()[0], maeEncueNseChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeEncueNseLovReturnParameters.id = codigo;
	maeEncueNseLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function maeEncueNseCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeEncueNseFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	maeEncueNseLastQuery = parametros;

	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('maeEncueNseFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeEncueNseList", "MaeEncueNseConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeEncueNsePostQueryActions(datos);"]], "", "");	
}

function maeEncueNseCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeEncueNseFrm.lastQueryToSession'));
	var i =0;
	set('maeEncueNseFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('maeEncueNseFrm.codTipoEncu', paramsRequery.ij(i++));
	
	set('maeEncueNseFrm.Descripcion', paramsRequery.ij(i++));
	
	set('maeEncueNseFrm.prenOidPreg', [paramsRequery.ij(i++)]);
	
	set('maeEncueNseFrm.valPesoPreg', paramsRequery.ij(i++));
	
	set('maeEncueNseFrm.marcOidMarc', [paramsRequery.ij(i++)]);
	
	
	
	//No se nos actualizar los parm�metros de la paginaci�n
	maeEncueNsePageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeEncueNseCmdQuery(maeEncueNsePageCount);
}

function maeEncueNseFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeEncueNsePageCount = 1;
	maeEncueNseCmdQuery(maeEncueNsePageCount);
}

function maeEncueNsePreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != maeEncueNseLastQuery){
		maeEncueNseFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeEncueNsePageCount--;
	maeEncueNseCmdQuery(maeEncueNsePageCount);
}

function maeEncueNseNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != maeEncueNseLastQuery){
		maeEncueNseFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeEncueNsePageCount++;
	maeEncueNseCmdQuery(maeEncueNsePageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeEncueNsePostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeEncueNseListLayer', 'O');
		visibilidad('maeEncueNseListButtonsLayer', 'O');
		visibilidad('maeEncueNsePreListLayer', 'O');
		if(get('maeEncueNseFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripci�n en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminaci�n)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeEncueNseViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeEncueNseChoiceColumn) + "</A>",
			i, maeEncueNseChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeEncueNseList.setDatos(datosTmp.filtrar([0,1,2,3,4,5],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	maeEncueNseTimeStamps = datosTmp.filtrar([6],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		maeEncueNseMorePagesFlag = true;
		maeEncueNseList.eliminar(mmgPageSize, 1);
	}else{
		maeEncueNseMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('maeEncueNseFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeEncueNseListLayer', 'V');
	visibilidad('maeEncueNseListButtonsLayer', 'V');
	visibilidad('maeEncueNsePreListLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeEncueNseList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeEncueNseList.display();
	
	//Actualizamos el estado de los botones 
	if(maeEncueNseMorePagesFlag){
		set_estado_botonera('maeEncueNsePaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeEncueNsePaginationButtonBar',
			3,"inactivo");
	}
	if(maeEncueNsePageCount > 1){
		set_estado_botonera('maeEncueNsePaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeEncueNsePaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeEncueNsePaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeEncueNsePaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeEncueNseUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(maeEncueNseList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeEncueNseFrm.idSelection', maeEncueNseList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('maeEncueNseFrm', true);
	if(validacion){
		/*set('maeEncueNseFrm.previousAction', 'update');
		set('maeEncueNseFrm.ON', 'MaeEncueNseLPStartUp');
		set('maeEncueNseFrm.conectorAction', 'MaeEncueNseLPStartUp');
		set('maeEncueNseFrm.origen', 'pagina');
		envia('maeEncueNseFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = maeEncueNseList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeEncueNseFrm.accion');
		parametros["accion"] = get('maeEncueNseFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('MaeEncueNseLPStartUp', get('maeEncueNseFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) maeEncueNseCmdRequery();
	}
}

function maeEncueNseRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(maeEncueNseList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeEncueNseList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeEncueNseFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeEncueNseList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeEncueNseTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeEncueNseFrm.timestamp', timestamps);
	envia('maeEncueNseFrm');
}

function maeEncueNseViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(maeEncueNseList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('maeEncueNseFrm.previousAction', get('maeEncueNseFrm.accion'));
	set('maeEncueNseFrm.accion', 'view');
	set('maeEncueNseFrm.origen', 'pagina');
	set('maeEncueNseFrm.ON', 'MaeEncueNseLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('maeEncueNseFrm.idSelection', maeEncueNseList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('maeEncueNseFrm');
	maeEncueNseViewDetail(maeEncueNseList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function maeEncueNseViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeEncueNseFrm.accion');
	parametros["accion"] = get('maeEncueNseFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('MaeEncueNseLPStartUp', get('maeEncueNseFrm.accion'), parametros, null, sizeFormView + 30);
}

//Funci�n ejecutada cuando se pulsa el bot�n de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripci�n del idioma por defecto
	//intreoducido directamente a trav�s del widget. Esto se pone debio a que la tecla r�pida
	//de guardar on dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('maeEncueNseFrm', 
		'Descripcion', 1,
		get('maeEncueNseFrm.Descripcion'));	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validaci�n los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeEncueNseFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('maeEncueNseFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeEncueNse.Descripcion.requiered.message'));
		focaliza('maeEncueNseFrm.Descripcion');
		return;
	}	
	
	
	
	
		
	
	if(validacion)envia('maeEncueNseFrm');
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	maeEncueNseRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('maeEncueNseFrm.accion');
	var origenTmp = get('maeEncueNseFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeEncueNseBuildUpdateRecordString() != maeEncueNseTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('maeEncueNseFrm.performRequery', 'true');
		set('maeEncueNseFrm.accion', 
			get('maeEncueNseFrm.previousAction'));
		set('maeEncueNseFrm.origen', 'menu');
		set('maeEncueNseFrm.ON', 'MaeEncueNseLPStartUp');
		set('maeEncueNseFrm.conectorAction', 'MaeEncueNseLPStartUp');
		maeEncueNseFrm.oculto='N';
		envia('maeEncueNseFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.maeEncueNseListLayer.style.display='none';
	document.all.maeEncueNseListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeEncueNseListLayer.style.display='';
	document.all.maeEncueNseListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda

	jsMaeEncueNsePaisOidPais = get('maeEncueNseFrm.paisOidPais')[0];




	jsMaeEncueNseCodTipoEncu = get('maeEncueNseFrm.codTipoEncu').toString();






	jsMaeEncueNseDescripcion = get('maeEncueNseFrm.Descripcion').toString();







	jsMaeEncueNsePrenOidPreg = get('maeEncueNseFrm.prenOidPreg')[0];




	jsMaeEncueNseValPesoPreg = get('maeEncueNseFrm.valPesoPreg').toString();







	jsMaeEncueNseMarcOidMarc = get('maeEncueNseFrm.marcOidMarc')[0];






	var parametros = "";
	parametros += jsMaeEncueNsePaisOidPais + "|";



	parametros += jsMaeEncueNseCodTipoEncu + "|";



	parametros += jsMaeEncueNseDescripcion + "|";



	parametros += jsMaeEncueNsePrenOidPreg + "|";



	parametros += jsMaeEncueNseValPesoPreg + "|";



	parametros += jsMaeEncueNseMarcOidMarc + "|";




	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeEncueNseBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeEncueNsePaisOidPais + "|";
	parametros += jsMaeEncueNseDescripcion + "|";
	parametros += jsMaeEncueNseValPesoPreg + "|";
	parametros += jsMaeEncueNseMarcOidMarc + "|";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeEncueNseFrm.accion'), 
		get('maeEncueNseFrm.origen'));
	
	jsMaeEncueNseId = get('maeEncueNseFrm.id').toString();
	jsMaeEncueNsePaisOidPais = get('maeEncueNseFrm.paisOidPais')[0];
	jsMaeEncueNseCodTipoEncu = get('maeEncueNseFrm.codTipoEncu').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeEncueNseDescripcion = buildLocalizedString('maeEncueNseFrm', 1);
	}else{
		jsMaeEncueNseDescripcion = get('maeEncueNseFrm.Descripcion');
	}
	jsMaeEncueNsePrenOidPreg = get('maeEncueNseFrm.prenOidPreg')[0];
	jsMaeEncueNseValPesoPreg = get('maeEncueNseFrm.valPesoPreg').toString();
	jsMaeEncueNseMarcOidMarc = get('maeEncueNseFrm.marcOidMarc')[0];

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeEncueNseFrm.accion'), 
		get('maeEncueNseFrm.origen'));


	set('maeEncueNseFrm.id', jsMaeEncueNseId);
	set('maeEncueNseFrm.paisOidPais', [jsMaeEncueNsePaisOidPais]);
	set('maeEncueNseFrm.codTipoEncu', jsMaeEncueNseCodTipoEncu);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeEncueNseFrm', 1,  jsMaeEncueNseDescripcion)
		loadLocalizationWidget('maeEncueNseFrm', 'Descripcion', 1);
	}else{
		set('maeEncueNseFrm.Descripcion', jsMaeEncueNseDescripcion);		
	}
	set('maeEncueNseFrm.prenOidPreg', [jsMaeEncueNsePrenOidPreg]);
	set('maeEncueNseFrm.valPesoPreg', jsMaeEncueNseValPesoPreg);
	set('maeEncueNseFrm.marcOidMarc', [jsMaeEncueNseMarcOidMarc]);

}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeEncueNseFrm.errCodigo', errorCode);
	set('maeEncueNseFrm.errDescripcion', description);
	set('maeEncueNseFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	

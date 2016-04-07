

/*
    INDRA/CAR/mmg
    $Id: carasignejecucuent.js,v 1.1 2009/12/03 19:01:35 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCarAsignEjecuCuentId = "";
var jsCarAsignEjecuCuentNiriOidNiveRies = "";
var jsCarAsignEjecuCuentZsgvOidSubgVent = "";
var jsCarAsignEjecuCuentZorgOidRegi = "";
var jsCarAsignEjecuCuentZzonOidZona = "";
var jsCarAsignEjecuCuentEjcuOidEjecCuen = "";

//Variables de paginacion, 
var carAsignEjecuCuentPageCount = 1;

//Varible de columna que representa el campo de choice
var carAsignEjecuCuentChoiceColumn = 5;

//Flag de siguiente pagina;
var carAsignEjecuCuentMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var carAsignEjecuCuentTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 430;
var sizeFormView = 430;
var sizeFormUpdate = 430;

//Ultima busqueda realizada
var carAsignEjecuCuentLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focalizaComboDependence("carAsignEjecuCuent","ejcuOidEjecCuen", false);','focalizaComboDependence("carAsignEjecuCuent","ejcuOidEjecCuen", false);','focalizaComboDependence("carAsignEjecuCuent","ejcuOidEjecCuen", false);','focalizaComboDependence("carAsignEjecuCuent","ejcuOidEjecCuen", true);','focalizaComboDependence("carAsignEjecuCuent","ejcuOidEjecCuen", true);','focalizaComboDependence("carAsignEjecuCuent","ejcuOidEjecCuen", true);']]);

//Creamos la informaci�n de las jerarqu�as de dependencias de combos (si existen)
//Para cada jerarqu�a de dependencia definimos un vector donde se defina la jerar�a
//La definici�n de la jerarqu� consiste en definir para cada combo de la jerarqu�a cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de �l para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedar�an [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var niriOidNiveRiesDependeceMap = new Vector();
niriOidNiveRiesDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
niriOidNiveRiesDependeceMap.agregar(['niriOidNiveRies', padresTmp, '', 'CarNivelRiesg']);
var zsgvOidSubgVentDependeceMap = new Vector();
zsgvOidSubgVentDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zsgvOidSubgVentDependeceMap.agregar(['zsgvOidSubgVent', padresTmp, '', 'ZonSubGerenVenta']);
var zorgOidRegiDependeceMap = new Vector();
zorgOidRegiDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zorgOidRegiDependeceMap.agregar(['zorgOidRegi', padresTmp, '', 'ZonRegio']);
var zzonOidZonaDependeceMap = new Vector();
zzonOidZonaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zzonOidZonaDependeceMap.agregar(['zzonOidZona', padresTmp, '', 'ZonZona']);
var ejcuOidEjecCuenDependeceMap = new Vector();
ejcuOidEjecCuenDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ejcuOidEjecCuenDependeceMap.agregar(['ejcuOidEjecCuen', padresTmp, '', 'CarEjecuCuent']);

	
//variable conreferencia al obejto usado para devolver los resultados de una b�squeda lov
carAsignEjecuCuentLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var carAsignEjecuCuentTmpUpdateValues;


//Funci�n ejecutada en el onload de la pagina
function carAsignEjecuCuentInitComponents(){
	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('carAsignEjecuCuentFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('carAsignEjecuCuentFrm.accion')){
		case "query": carAsignEjecuCuentQueryInitComponents(); break;
		case "view": carAsignEjecuCuentViewInitComponents(); break;
		case "create": carAsignEjecuCuentCreateInitComponents(); break;
		case "update": carAsignEjecuCuentUpdateInitComponents(); break;
		case "remove": carAsignEjecuCuentRemoveInitComponents(); break;
		case "lov": carAsignEjecuCuentLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('carAsignEjecuCuentFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('carAsignEjecuCuent')) carAsignEjecuCuentCmdRequery();
}

function carAsignEjecuCuentQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
}

function carAsignEjecuCuentViewInitComponents(){
	//En principiono se hace nada
}

function carAsignEjecuCuentCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('carAsignEjecuCuentFrm.niriOidNiveRies','S', GestionarMensaje('CarAsignEjecuCuent.niriOidNiveRies.requiered.message'));
	
	setMV('carAsignEjecuCuentFrm.zsgvOidSubgVent','S', GestionarMensaje('CarAsignEjecuCuent.zsgvOidSubgVent.requiered.message'));
	
	setMV('carAsignEjecuCuentFrm.zorgOidRegi','S', GestionarMensaje('CarAsignEjecuCuent.zorgOidRegi.requiered.message'));
	
	setMV('carAsignEjecuCuentFrm.zzonOidZona','S', GestionarMensaje('CarAsignEjecuCuent.zzonOidZona.requiered.message'));
	
	setMV('carAsignEjecuCuentFrm.ejcuOidEjecCuen','S', GestionarMensaje('CarAsignEjecuCuent.ejcuOidEjecCuen.requiered.message'));
	
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function carAsignEjecuCuentUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('carAsignEjecuCuentFrm.origen') == "pagina"){
		

		//Registramos el valor del elemento que estamos modificando
		carAsignEjecuCuentTmpUpdateValues = carAsignEjecuCuentBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('carAsignEjecuCuentFrm.niriOidNiveRies','S', GestionarMensaje('CarAsignEjecuCuent.niriOidNiveRies.requiered.message'));
		
		setMV('carAsignEjecuCuentFrm.zsgvOidSubgVent','S', GestionarMensaje('CarAsignEjecuCuent.zsgvOidSubgVent.requiered.message'));
		
		setMV('carAsignEjecuCuentFrm.zorgOidRegi','S', GestionarMensaje('CarAsignEjecuCuent.zorgOidRegi.requiered.message'));
		
		setMV('carAsignEjecuCuentFrm.zzonOidZona','S', GestionarMensaje('CarAsignEjecuCuent.zzonOidZona.requiered.message'));
		
		setMV('carAsignEjecuCuentFrm.ejcuOidEjecCuen','S', GestionarMensaje('CarAsignEjecuCuent.ejcuOidEjecCuen.requiered.message'));
		
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('carAsignEjecuCuentFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function carAsignEjecuCuentRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	carAsignEjecuCuentList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function carAsignEjecuCuentLovInitComponents(){
	carAsignEjecuCuentLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad








//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function carAsignEjecuCuentSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('carAsignEjecuCuentFrm.' + campo, id);
	set('carAsignEjecuCuentFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function carAsignEjecuCuentLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	carAsignEjecuCuentLovReturnParameters.id = '';
	carAsignEjecuCuentLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function carAsignEjecuCuentLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(carAsignEjecuCuentList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = carAsignEjecuCuentList.codSeleccionados();
	var descripcion = carAsignEjecuCuentList.extraeDato(
		carAsignEjecuCuentList.codSeleccionados()[0], carAsignEjecuCuentChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	carAsignEjecuCuentLovReturnParameters.id = codigo;
	carAsignEjecuCuentLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function carAsignEjecuCuentCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('carAsignEjecuCuentFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	carAsignEjecuCuentLastQuery = parametros;

	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('carAsignEjecuCuentFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "carAsignEjecuCuentList", "CarAsignEjecuCuentConectorTransactionQuery", 
		"result_ROWSET", parametros, "carAsignEjecuCuentPostQueryActions(datos);"]], "", "");	
}

function carAsignEjecuCuentCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('carAsignEjecuCuentFrm.lastQueryToSession'));
	var i =0;
	set('carAsignEjecuCuentFrm.niriOidNiveRies', [paramsRequery.ij(i++)]);
	
	set('carAsignEjecuCuentFrm.zsgvOidSubgVent', [paramsRequery.ij(i++)]);
	
	set('carAsignEjecuCuentFrm.zorgOidRegi', [paramsRequery.ij(i++)]);
	
	set('carAsignEjecuCuentFrm.zzonOidZona', [paramsRequery.ij(i++)]);
	
	set('carAsignEjecuCuentFrm.ejcuOidEjecCuen', [paramsRequery.ij(i++)]);
	
	
	
	//No se nos actualizar los parm�metros de la paginaci�n
	carAsignEjecuCuentPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	carAsignEjecuCuentCmdQuery(carAsignEjecuCuentPageCount);
}

function carAsignEjecuCuentFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	carAsignEjecuCuentPageCount = 1;
	carAsignEjecuCuentCmdQuery(carAsignEjecuCuentPageCount);
}

function carAsignEjecuCuentPreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != carAsignEjecuCuentLastQuery){
		carAsignEjecuCuentFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	carAsignEjecuCuentPageCount--;
	carAsignEjecuCuentCmdQuery(carAsignEjecuCuentPageCount);
}

function carAsignEjecuCuentNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != carAsignEjecuCuentLastQuery){
		carAsignEjecuCuentFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	carAsignEjecuCuentPageCount++;
	carAsignEjecuCuentCmdQuery(carAsignEjecuCuentPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function carAsignEjecuCuentPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('carAsignEjecuCuentListLayer', 'O');
		visibilidad('carAsignEjecuCuentListButtonsLayer', 'O');
		visibilidad('carAsignEjecuCuentPreListLayer', 'O');
		if(get('carAsignEjecuCuentFrm.accion') == "remove"){
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
		datosTmp.ij2("<A HREF=\'javascript:carAsignEjecuCuentViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, carAsignEjecuCuentChoiceColumn) + "</A>",
			i, carAsignEjecuCuentChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	carAsignEjecuCuentList.setDatos(datosTmp.filtrar([0,1,2,3,4,5],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	carAsignEjecuCuentTimeStamps = datosTmp.filtrar([6],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		carAsignEjecuCuentMorePagesFlag = true;
		carAsignEjecuCuentList.eliminar(mmgPageSize, 1);
	}else{
		carAsignEjecuCuentMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('carAsignEjecuCuentFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('carAsignEjecuCuentListLayer', 'V');
	visibilidad('carAsignEjecuCuentListButtonsLayer', 'V');
	visibilidad('carAsignEjecuCuentPreListLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('carAsignEjecuCuentList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	carAsignEjecuCuentList.display();
	
	//Actualizamos el estado de los botones 
	if(carAsignEjecuCuentMorePagesFlag){
		set_estado_botonera('carAsignEjecuCuentPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('carAsignEjecuCuentPaginationButtonBar',
			3,"inactivo");
	}
	if(carAsignEjecuCuentPageCount > 1){
		set_estado_botonera('carAsignEjecuCuentPaginationButtonBar',
			2,"activo");
		set_estado_botonera('carAsignEjecuCuentPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('carAsignEjecuCuentPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('carAsignEjecuCuentPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function carAsignEjecuCuentUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(carAsignEjecuCuentList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('carAsignEjecuCuentFrm.idSelection', carAsignEjecuCuentList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('carAsignEjecuCuentFrm', true);
	if(validacion){
		/*set('carAsignEjecuCuentFrm.previousAction', 'update');
		set('carAsignEjecuCuentFrm.ON', 'CarAsignEjecuCuentLPStartUp');
		set('carAsignEjecuCuentFrm.conectorAction', 'CarAsignEjecuCuentLPStartUp');
		set('carAsignEjecuCuentFrm.origen', 'pagina');
		envia('carAsignEjecuCuentFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = carAsignEjecuCuentList.codSeleccionados()[0];
		parametros["previousAction"] = get('carAsignEjecuCuentFrm.accion');
		parametros["accion"] = get('carAsignEjecuCuentFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('CarAsignEjecuCuentLPStartUp', get('carAsignEjecuCuentFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) carAsignEjecuCuentCmdRequery();
	}
}

function carAsignEjecuCuentRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(carAsignEjecuCuentList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = carAsignEjecuCuentList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('carAsignEjecuCuentFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(carAsignEjecuCuentList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += carAsignEjecuCuentTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('carAsignEjecuCuentFrm.timestamp', timestamps);
	envia('carAsignEjecuCuentFrm');
}

function carAsignEjecuCuentViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(carAsignEjecuCuentList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('carAsignEjecuCuentFrm.previousAction', get('carAsignEjecuCuentFrm.accion'));
	set('carAsignEjecuCuentFrm.accion', 'view');
	set('carAsignEjecuCuentFrm.origen', 'pagina');
	set('carAsignEjecuCuentFrm.ON', 'CarAsignEjecuCuentLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('carAsignEjecuCuentFrm.idSelection', carAsignEjecuCuentList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('carAsignEjecuCuentFrm');
	carAsignEjecuCuentViewDetail(carAsignEjecuCuentList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function carAsignEjecuCuentViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('carAsignEjecuCuentFrm.accion');
	parametros["accion"] = get('carAsignEjecuCuentFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('CarAsignEjecuCuentLPStartUp', get('carAsignEjecuCuentFrm.accion'), parametros, null, sizeFormView + 30);
}

//Funci�n ejecutada cuando se pulsa el bot�n de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripci�n del idioma por defecto
	//intreoducido directamente a trav�s del widget. Esto se pone debio a que la tecla r�pida
	//de guardar on dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validaci�n los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('carAsignEjecuCuentFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
		
	
	if(validacion)envia('carAsignEjecuCuentFrm');
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	carAsignEjecuCuentRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('carAsignEjecuCuentFrm.accion');
	var origenTmp = get('carAsignEjecuCuentFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(carAsignEjecuCuentBuildUpdateRecordString() != carAsignEjecuCuentTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('carAsignEjecuCuentFrm.performRequery', 'true');
		set('carAsignEjecuCuentFrm.accion', 
			get('carAsignEjecuCuentFrm.previousAction'));
		set('carAsignEjecuCuentFrm.origen', 'menu');
		set('carAsignEjecuCuentFrm.ON', 'CarAsignEjecuCuentLPStartUp');
		set('carAsignEjecuCuentFrm.conectorAction', 'CarAsignEjecuCuentLPStartUp');
		carAsignEjecuCuentFrm.oculto='N';
		envia('carAsignEjecuCuentFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.carAsignEjecuCuentListLayer.style.display='none';
	document.all.carAsignEjecuCuentListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.carAsignEjecuCuentListLayer.style.display='';
	document.all.carAsignEjecuCuentListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda

	jsCarAsignEjecuCuentNiriOidNiveRies = get('carAsignEjecuCuentFrm.niriOidNiveRies')[0];





	jsCarAsignEjecuCuentZsgvOidSubgVent = get('carAsignEjecuCuentFrm.zsgvOidSubgVent')[0];





	jsCarAsignEjecuCuentZorgOidRegi = get('carAsignEjecuCuentFrm.zorgOidRegi')[0];





	jsCarAsignEjecuCuentZzonOidZona = get('carAsignEjecuCuentFrm.zzonOidZona')[0];





	jsCarAsignEjecuCuentEjcuOidEjecCuen = get('carAsignEjecuCuentFrm.ejcuOidEjecCuen')[0];






	var parametros = "";
	parametros += jsCarAsignEjecuCuentNiriOidNiveRies + "|";



	parametros += jsCarAsignEjecuCuentZsgvOidSubgVent + "|";



	parametros += jsCarAsignEjecuCuentZorgOidRegi + "|";



	parametros += jsCarAsignEjecuCuentZzonOidZona + "|";



	parametros += jsCarAsignEjecuCuentEjcuOidEjecCuen + "|";




	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function carAsignEjecuCuentBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCarAsignEjecuCuentNiriOidNiveRies + "|";
	parametros += jsCarAsignEjecuCuentZsgvOidSubgVent + "|";
	parametros += jsCarAsignEjecuCuentZorgOidRegi + "|";
	parametros += jsCarAsignEjecuCuentZzonOidZona + "|";
	parametros += jsCarAsignEjecuCuentEjcuOidEjecCuen + "|";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carAsignEjecuCuentFrm.accion'), 
		get('carAsignEjecuCuentFrm.origen'));
	
	jsCarAsignEjecuCuentId = get('carAsignEjecuCuentFrm.id').toString();
	jsCarAsignEjecuCuentNiriOidNiveRies = get('carAsignEjecuCuentFrm.niriOidNiveRies')[0];
	jsCarAsignEjecuCuentZsgvOidSubgVent = get('carAsignEjecuCuentFrm.zsgvOidSubgVent')[0];
	jsCarAsignEjecuCuentZorgOidRegi = get('carAsignEjecuCuentFrm.zorgOidRegi')[0];
	jsCarAsignEjecuCuentZzonOidZona = get('carAsignEjecuCuentFrm.zzonOidZona')[0];
	jsCarAsignEjecuCuentEjcuOidEjecCuen = get('carAsignEjecuCuentFrm.ejcuOidEjecCuen')[0];

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carAsignEjecuCuentFrm.accion'), 
		get('carAsignEjecuCuentFrm.origen'));


	set('carAsignEjecuCuentFrm.id', jsCarAsignEjecuCuentId);
	set('carAsignEjecuCuentFrm.niriOidNiveRies', [jsCarAsignEjecuCuentNiriOidNiveRies]);
	set('carAsignEjecuCuentFrm.zsgvOidSubgVent', [jsCarAsignEjecuCuentZsgvOidSubgVent]);
	set('carAsignEjecuCuentFrm.zorgOidRegi', [jsCarAsignEjecuCuentZorgOidRegi]);
	set('carAsignEjecuCuentFrm.zzonOidZona', [jsCarAsignEjecuCuentZzonOidZona]);
	set('carAsignEjecuCuentFrm.ejcuOidEjecCuen', [jsCarAsignEjecuCuentEjcuOidEjecCuen]);

}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('carAsignEjecuCuentFrm.errCodigo', errorCode);
	set('carAsignEjecuCuentFrm.errDescripcion', description);
	set('carAsignEjecuCuentFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	

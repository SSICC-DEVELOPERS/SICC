

/*
    INDRA/CAR/mmg
    $Id: zonregioview2.js,v 1.1 2009/12/03 19:02:16 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsZonRegioView2Id = "";
var jsZonRegioView2CodRegi = "";
var jsZonRegioView2CanaOidCana = "";
var jsZonRegioView2MarcOidMarc = "";
var jsZonRegioView2PaisOidPais = "";

//Variables de paginacion, 
var zonRegioView2PageCount = 1;

//Varible de columna que representa el campo de choice
var zonRegioView2ChoiceColumn = 0;

//Flag de siguiente pagina;
var zonRegioView2MorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var zonRegioView2TimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 189;
var sizeFormView = 175;
var sizeFormUpdate = 175;

//Ultima busqueda realizada
var zonRegioView2LastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("zonRegioView2Frm.codRegi");','focaliza("zonRegioView2Frm.codRegi");','focaliza("zonRegioView2Frm.codRegi");','focaliza("zonRegioView2Frm.codRegi");','focaliza("zonRegioView2Frm.codRegi");','focaliza("zonRegioView2Frm.codRegi");'],[3,'focalizaComboDependence("zonRegioView2","canaOidCana", false);','focalizaComboDependence("zonRegioView2","canaOidCana", false);','focalizaComboDependence("zonRegioView2","canaOidCana", false);','focalizaComboDependence("zonRegioView2","canaOidCana", true);','focalizaComboDependence("zonRegioView2","canaOidCana", true);','focalizaComboDependence("zonRegioView2","canaOidCana", true);'],[4,'focalizaComboDependence("zonRegioView2","marcOidMarc", false);','focalizaComboDependence("zonRegioView2","marcOidMarc", false);','focalizaComboDependence("zonRegioView2","marcOidMarc", false);','focalizaComboDependence("zonRegioView2","marcOidMarc", true);','focalizaComboDependence("zonRegioView2","marcOidMarc", true);','focalizaComboDependence("zonRegioView2","marcOidMarc", true);'],[5,'','','','','','']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("zonRegioView2Frm.codRegi");','focaliza("zonRegioView2Frm.codRegi");','focaliza("zonRegioView2Frm.codRegi");','focaliza("zonRegioView2Frm.codRegi");','focaliza("zonRegioView2Frm.codRegi");','focaliza("zonRegioView2Frm.codRegi");'],[3,'focalizaComboDependence("zonRegioView2","canaOidCana", false);','focalizaComboDependence("zonRegioView2","canaOidCana", false);','focalizaComboDependence("zonRegioView2","canaOidCana", false);','focalizaComboDependence("zonRegioView2","canaOidCana", true);','focalizaComboDependence("zonRegioView2","canaOidCana", true);','focalizaComboDependence("zonRegioView2","canaOidCana", true);'],[4,'focalizaComboDependence("zonRegioView2","marcOidMarc", false);','focalizaComboDependence("zonRegioView2","marcOidMarc", false);','focalizaComboDependence("zonRegioView2","marcOidMarc", false);','focalizaComboDependence("zonRegioView2","marcOidMarc", true);','focalizaComboDependence("zonRegioView2","marcOidMarc", true);','focalizaComboDependence("zonRegioView2","marcOidMarc", true);'],[5,'','','','','','']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var canaOidCanaDependeceMap = new Vector();
canaOidCanaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
canaOidCanaDependeceMap.agregar(['canaOidCana', padresTmp, '', 'SegCanalView']);
var marcOidMarcDependeceMap = new Vector();
marcOidMarcDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
marcOidMarcDependeceMap.agregar(['marcOidMarc', padresTmp, '', 'SegMarca']);
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
zonRegioView2LovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var zonRegioView2TmpUpdateValues;



//Función ejecutada en el onload de la pagina
function zonRegioView2InitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('zonRegioView2Frm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('zonRegioView2Frm.accion')){
		case "query": zonRegioView2QueryInitComponents(); break;
		case "view": zonRegioView2ViewInitComponents(); break;
		case "create": zonRegioView2CreateInitComponents(); break;
		case "update": zonRegioView2UpdateInitComponents(); break;
		case "remove": zonRegioView2RemoveInitComponents(); break;
		case "lov": zonRegioView2LovInitComponents(); break;
	}
	//alert('accion :' + get('zonRegioView2Frm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('zonRegioView2Frm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('zonRegioView2')) zonRegioView2CmdRequery();
}

function zonRegioView2QueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('zonRegioView2Frm', true);	
}

function zonRegioView2ViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('zonRegioView2Frm', true);
}

function zonRegioView2CreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('zonRegioView2Frm.codRegi','S', GestionarMensaje('ZonRegioView2.codRegi.requiered.message'));
	
	setMV('zonRegioView2Frm.canaOidCana','S', GestionarMensaje('ZonRegioView2.canaOidCana.requiered.message'));
	
	setMV('zonRegioView2Frm.marcOidMarc','S', GestionarMensaje('ZonRegioView2.marcOidMarc.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('zonRegioView2Frm', true);
}

function zonRegioView2UpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('zonRegioView2Frm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		zonRegioView2TmpUpdateValues = zonRegioView2BuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('zonRegioView2Frm.codRegi','S', GestionarMensaje('ZonRegioView2.codRegi.requiered.message'));
		setMV('zonRegioView2Frm.canaOidCana','S', GestionarMensaje('ZonRegioView2.canaOidCana.requiered.message'));
		setMV('zonRegioView2Frm.marcOidMarc','S', GestionarMensaje('ZonRegioView2.marcOidMarc.requiered.message'));
		
			focusFirstFieldModify('zonRegioView2Frm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('zonRegioView2Frm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('zonRegioView2Frm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function zonRegioView2RemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	zonRegioView2List.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('zonRegioView2Frm', true);
}

function zonRegioView2LovInitComponents(){
	zonRegioView2LovReturnParameters = window.dialogArguments;
	
	focusFirstField('zonRegioView2Frm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function zonRegioView2SetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('zonRegioView2Frm.' + campo, id);
	set('zonRegioView2Frm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function zonRegioView2LovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	zonRegioView2LovReturnParameters.id = '';
	zonRegioView2LovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function zonRegioView2LovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonRegioView2List.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = zonRegioView2List.codSeleccionados();
	var descripcion = zonRegioView2List.extraeDato(
		zonRegioView2List.codSeleccionados()[0], zonRegioView2ChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	zonRegioView2LovReturnParameters.id = codigo;
	zonRegioView2LovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function zonRegioView2CmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('zonRegioView2Frm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('zonRegioView2Frm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "zonRegioView2List", "ZonRegioView2ConectorTransactionQuery", 
		"result_ROWSET", parametros, "zonRegioView2PostQueryActions(datos);"]], "", "");	
}

function zonRegioView2CmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('zonRegioView2Frm.lastQueryToSession'));
	var i =0;
	set('zonRegioView2Frm.codRegi', paramsRequery.ij(i++));
	
	set('zonRegioView2Frm.canaOidCana', [paramsRequery.ij(i++)]);
	
	set('zonRegioView2Frm.marcOidMarc', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	zonRegioView2PageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	zonRegioView2CmdQuery(zonRegioView2PageCount);
}

function zonRegioView2FirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	zonRegioView2PageCount = 1;
	zonRegioView2CmdQuery(zonRegioView2PageCount);
}

function zonRegioView2PreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonRegioView2LastQuery){
		zonRegioView2FirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	zonRegioView2PageCount--;
	zonRegioView2CmdQuery(zonRegioView2PageCount);
}

function zonRegioView2NextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonRegioView2LastQuery){
		zonRegioView2FirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	zonRegioView2PageCount++;
	zonRegioView2CmdQuery(zonRegioView2PageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function zonRegioView2PostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('zonRegioView2ListLayer', 'O');
		visibilidad('zonRegioView2ListButtonsLayer', 'O');
		if(get('zonRegioView2Frm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	zonRegioView2LastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:zonRegioView2ViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, zonRegioView2ChoiceColumn) + "</A>",
			i, zonRegioView2ChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	zonRegioView2List.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	zonRegioView2TimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		zonRegioView2MorePagesFlag = true;
		zonRegioView2List.eliminar(mmgPageSize, 1);
	}else{
		zonRegioView2MorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('zonRegioView2Frm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('zonRegioView2ListLayer', 'V');
	visibilidad('zonRegioView2ListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('zonRegioView2List',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	zonRegioView2List.display();
	
	//Actualizamos el estado de los botones 
	if(zonRegioView2MorePagesFlag){
		set_estado_botonera('zonRegioView2PaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('zonRegioView2PaginationButtonBar',
			3,"inactivo");
	}
	if(zonRegioView2PageCount > 1){
		set_estado_botonera('zonRegioView2PaginationButtonBar',
			2,"activo");
		set_estado_botonera('zonRegioView2PaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('zonRegioView2PaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('zonRegioView2PaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function zonRegioView2UpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonRegioView2List.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('zonRegioView2Frm.idSelection', zonRegioView2List.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('zonRegioView2Frm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = zonRegioView2List.codSeleccionados()[0];
		parametros["previousAction"] = get('zonRegioView2Frm.accion');
		parametros["accion"] = get('zonRegioView2Frm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('ZonRegioView2LPStartUp', get('zonRegioView2Frm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) zonRegioView2CmdRequery();
	}
}

function zonRegioView2RemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonRegioView2List.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = zonRegioView2List.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('zonRegioView2Frm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(zonRegioView2List.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += zonRegioView2TimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('zonRegioView2Frm.timestamp', timestamps);


	zonRegioView2Frm.oculto='S';
	envia('zonRegioView2Frm');
	zonRegioView2Frm.oculto='N';
}

function zonRegioView2ViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonRegioView2List.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	zonRegioView2ViewDetail(zonRegioView2List.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function zonRegioView2ViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('zonRegioView2Frm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('ZonRegioView2LPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('zonRegioView2Frm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
		
	
	if(validacion){
		zonRegioView2Frm.oculto='S';
		envia('zonRegioView2Frm');
		zonRegioView2Frm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('zonRegioView2Frm.canaOidCana').toString() == ''){
		set('zonRegioView2Frm.canaOidCana', []);
		mmgResetCombosOnCascade('canaOidCana', 'canaOidCana', 'zonRegioView2');
		
	}
	if(get('zonRegioView2Frm.marcOidMarc').toString() == ''){
		set('zonRegioView2Frm.marcOidMarc', []);
		mmgResetCombosOnCascade('marcOidMarc', 'marcOidMarc', 'zonRegioView2');
		
	}
	if(get('zonRegioView2Frm.paisOidPais').toString() == ''){
		set('zonRegioView2Frm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'zonRegioView2');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	zonRegioView2RemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('zonRegioView2Frm.accion');
	var origenTmp = get('zonRegioView2Frm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(zonRegioView2BuildUpdateRecordString() != zonRegioView2TmpUpdateValues){
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
	document.all.zonRegioView2ListLayer.style.display='none';
	document.all.zonRegioView2ListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.zonRegioView2ListLayer.style.display='';
	document.all.zonRegioView2ListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsZonRegioView2CodRegi = get('zonRegioView2Frm.codRegi').toString();
	jsZonRegioView2CanaOidCana = get('zonRegioView2Frm.canaOidCana')[0];
	jsZonRegioView2MarcOidMarc = get('zonRegioView2Frm.marcOidMarc')[0];
	
	
	var parametros = "";
	parametros += jsZonRegioView2CodRegi + "|";
	parametros += jsZonRegioView2CanaOidCana + "|";
	parametros += jsZonRegioView2MarcOidMarc + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function zonRegioView2BuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsZonRegioView2CodRegi + "|";
	parametros += jsZonRegioView2CanaOidCana + "|";
	parametros += jsZonRegioView2MarcOidMarc + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonRegioView2Frm.accion'), 
		get('zonRegioView2Frm.origen'));
	
	jsZonRegioView2Id = get('zonRegioView2Frm.id').toString();
	jsZonRegioView2CodRegi = get('zonRegioView2Frm.codRegi').toString();
	jsZonRegioView2CanaOidCana = get('zonRegioView2Frm.canaOidCana')[0];
	jsZonRegioView2MarcOidMarc = get('zonRegioView2Frm.marcOidMarc')[0];
	jsZonRegioView2PaisOidPais = get('zonRegioView2Frm.paisOidPais')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonRegioView2Frm.accion'), 
		get('zonRegioView2Frm.origen'));


	set('zonRegioView2Frm.id', jsZonRegioView2Id);
	set('zonRegioView2Frm.codRegi', jsZonRegioView2CodRegi);
	set('zonRegioView2Frm.canaOidCana', [jsZonRegioView2CanaOidCana]);
	set('zonRegioView2Frm.marcOidMarc', [jsZonRegioView2MarcOidMarc]);
	set('zonRegioView2Frm.paisOidPais', [jsZonRegioView2PaisOidPais]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsZonRegioView2CodRegi = '';
	jsZonRegioView2CanaOidCana = '';
	jsZonRegioView2MarcOidMarc = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('zonRegioView2Frm.errCodigo', errorCode);
	set('zonRegioView2Frm.errDescripcion', description);
	set('zonRegioView2Frm.errSeverity', severity);
	fMostrarMensajeError();
}



/*
    INDRA/CAR/mmg
    $Id: zonzonaview2.js,v 1.1 2009/12/03 19:01:44 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsZonZonaView2Id = "";
var jsZonZonaView2MarcOidMarc = "";
var jsZonZonaView2CanaOidCana = "";
var jsZonZonaView2CodZona = "";
var jsZonZonaView2PaisOidPais = "";
var jsZonZonaView2IndActi = "";
var jsZonZonaView2IndBorr = "";

//Variables de paginacion, 
var zonZonaView2PageCount = 1;

//Varible de columna que representa el campo de choice
var zonZonaView2ChoiceColumn = 2;

//Flag de siguiente pagina;
var zonZonaView2MorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var zonZonaView2TimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 189;
var sizeFormView = 259;
var sizeFormUpdate = 259;

//Ultima busqueda realizada
var zonZonaView2LastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("zonZonaView2","marcOidMarc", false);','focalizaComboDependence("zonZonaView2","marcOidMarc", false);','focalizaComboDependence("zonZonaView2","marcOidMarc", false);','focalizaComboDependence("zonZonaView2","marcOidMarc", true);','focalizaComboDependence("zonZonaView2","marcOidMarc", true);','focalizaComboDependence("zonZonaView2","marcOidMarc", true);'],[3,'focalizaComboDependence("zonZonaView2","canaOidCana", false);','focalizaComboDependence("zonZonaView2","canaOidCana", false);','focalizaComboDependence("zonZonaView2","canaOidCana", false);','focalizaComboDependence("zonZonaView2","canaOidCana", true);','focalizaComboDependence("zonZonaView2","canaOidCana", true);','focalizaComboDependence("zonZonaView2","canaOidCana", true);'],[4,'focaliza("zonZonaView2Frm.codZona");','focaliza("zonZonaView2Frm.codZona");','focaliza("zonZonaView2Frm.codZona");','focaliza("zonZonaView2Frm.codZona");','focaliza("zonZonaView2Frm.codZona");','focaliza("zonZonaView2Frm.codZona");'],[5,'','','','','',''],[6,'','focaliza("zonZonaView2Frm.indActi");','focaliza("zonZonaView2Frm.indActi");','','focaliza("zonZonaView2Frm.indActi");','focaliza("zonZonaView2Frm.indActi");'],[7,'','focaliza("zonZonaView2Frm.indBorr");','focaliza("zonZonaView2Frm.indBorr");','','focaliza("zonZonaView2Frm.indBorr");','focaliza("zonZonaView2Frm.indBorr");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focalizaComboDependence("zonZonaView2","marcOidMarc", false);','focalizaComboDependence("zonZonaView2","marcOidMarc", false);','focalizaComboDependence("zonZonaView2","marcOidMarc", false);','focalizaComboDependence("zonZonaView2","marcOidMarc", true);','focalizaComboDependence("zonZonaView2","marcOidMarc", true);','focalizaComboDependence("zonZonaView2","marcOidMarc", true);'],[3,'focalizaComboDependence("zonZonaView2","canaOidCana", false);','focalizaComboDependence("zonZonaView2","canaOidCana", false);','focalizaComboDependence("zonZonaView2","canaOidCana", false);','focalizaComboDependence("zonZonaView2","canaOidCana", true);','focalizaComboDependence("zonZonaView2","canaOidCana", true);','focalizaComboDependence("zonZonaView2","canaOidCana", true);'],[4,'focaliza("zonZonaView2Frm.codZona");','focaliza("zonZonaView2Frm.codZona");','focaliza("zonZonaView2Frm.codZona");','focaliza("zonZonaView2Frm.codZona");','focaliza("zonZonaView2Frm.codZona");','focaliza("zonZonaView2Frm.codZona");'],[5,'','','','','',''],[6,'','focaliza("zonZonaView2Frm.indActi");','focaliza("zonZonaView2Frm.indActi");','','focaliza("zonZonaView2Frm.indActi");','focaliza("zonZonaView2Frm.indActi");'],[7,'','focaliza("zonZonaView2Frm.indBorr");','focaliza("zonZonaView2Frm.indBorr");','','focaliza("zonZonaView2Frm.indBorr");','focaliza("zonZonaView2Frm.indBorr");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var marcOidMarcDependeceMap = new Vector();
marcOidMarcDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
marcOidMarcDependeceMap.agregar(['marcOidMarc', padresTmp, '', 'SegMarca']);
var canaOidCanaDependeceMap = new Vector();
canaOidCanaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
canaOidCanaDependeceMap.agregar(['canaOidCana', padresTmp, '', 'SegCanalView']);
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
zonZonaView2LovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var zonZonaView2TmpUpdateValues;



//Función ejecutada en el onload de la pagina
function zonZonaView2InitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('zonZonaView2Frm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('zonZonaView2Frm.accion')){
		case "query": zonZonaView2QueryInitComponents(); break;
		case "view": zonZonaView2ViewInitComponents(); break;
		case "create": zonZonaView2CreateInitComponents(); break;
		case "update": zonZonaView2UpdateInitComponents(); break;
		case "remove": zonZonaView2RemoveInitComponents(); break;
		case "lov": zonZonaView2LovInitComponents(); break;
	}
	//alert('accion :' + get('zonZonaView2Frm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('zonZonaView2Frm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('zonZonaView2')) zonZonaView2CmdRequery();
}

function zonZonaView2QueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('zonZonaView2Frm', true);	
}

function zonZonaView2ViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('zonZonaView2Frm', true);
}

function zonZonaView2CreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('zonZonaView2Frm.marcOidMarc','S', GestionarMensaje('ZonZonaView2.marcOidMarc.requiered.message'));
	
	setMV('zonZonaView2Frm.canaOidCana','S', GestionarMensaje('ZonZonaView2.canaOidCana.requiered.message'));
	
	setMV('zonZonaView2Frm.codZona','S', GestionarMensaje('ZonZonaView2.codZona.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('zonZonaView2Frm', true);
}

function zonZonaView2UpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('zonZonaView2Frm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		zonZonaView2TmpUpdateValues = zonZonaView2BuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('zonZonaView2Frm.marcOidMarc','S', GestionarMensaje('ZonZonaView2.marcOidMarc.requiered.message'));
		setMV('zonZonaView2Frm.canaOidCana','S', GestionarMensaje('ZonZonaView2.canaOidCana.requiered.message'));
		setMV('zonZonaView2Frm.codZona','S', GestionarMensaje('ZonZonaView2.codZona.requiered.message'));
		
			focusFirstFieldModify('zonZonaView2Frm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('zonZonaView2Frm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('zonZonaView2Frm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function zonZonaView2RemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	zonZonaView2List.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('zonZonaView2Frm', true);
}

function zonZonaView2LovInitComponents(){
	zonZonaView2LovReturnParameters = window.dialogArguments;
	
	focusFirstField('zonZonaView2Frm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad









//Función que permite cargar los datos de un elemento de lov seleccionado
function zonZonaView2SetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('zonZonaView2Frm.' + campo, id);
	set('zonZonaView2Frm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function zonZonaView2LovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	zonZonaView2LovReturnParameters.id = '';
	zonZonaView2LovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function zonZonaView2LovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonZonaView2List.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = zonZonaView2List.codSeleccionados();
	var descripcion = zonZonaView2List.extraeDato(
		zonZonaView2List.codSeleccionados()[0], zonZonaView2ChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	zonZonaView2LovReturnParameters.id = codigo;
	zonZonaView2LovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function zonZonaView2CmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('zonZonaView2Frm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('zonZonaView2Frm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "zonZonaView2List", "ZonZonaView2ConectorTransactionQuery", 
		"result_ROWSET", parametros, "zonZonaView2PostQueryActions(datos);"]], "", "");	
}

function zonZonaView2CmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('zonZonaView2Frm.lastQueryToSession'));
	var i =0;
	set('zonZonaView2Frm.marcOidMarc', [paramsRequery.ij(i++)]);
	
	set('zonZonaView2Frm.canaOidCana', [paramsRequery.ij(i++)]);
	
	set('zonZonaView2Frm.codZona', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	zonZonaView2PageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	zonZonaView2CmdQuery(zonZonaView2PageCount);
}

function zonZonaView2FirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	zonZonaView2PageCount = 1;
	zonZonaView2CmdQuery(zonZonaView2PageCount);
}

function zonZonaView2PreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonZonaView2LastQuery){
		zonZonaView2FirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	zonZonaView2PageCount--;
	zonZonaView2CmdQuery(zonZonaView2PageCount);
}

function zonZonaView2NextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonZonaView2LastQuery){
		zonZonaView2FirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	zonZonaView2PageCount++;
	zonZonaView2CmdQuery(zonZonaView2PageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function zonZonaView2PostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('zonZonaView2ListLayer', 'O');
		visibilidad('zonZonaView2ListButtonsLayer', 'O');
		if(get('zonZonaView2Frm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	zonZonaView2LastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:zonZonaView2ViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, zonZonaView2ChoiceColumn) + "</A>",
			i, zonZonaView2ChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	zonZonaView2List.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	zonZonaView2TimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		zonZonaView2MorePagesFlag = true;
		zonZonaView2List.eliminar(mmgPageSize, 1);
	}else{
		zonZonaView2MorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('zonZonaView2Frm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('zonZonaView2ListLayer', 'V');
	visibilidad('zonZonaView2ListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('zonZonaView2List',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	zonZonaView2List.display();
	
	//Actualizamos el estado de los botones 
	if(zonZonaView2MorePagesFlag){
		set_estado_botonera('zonZonaView2PaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('zonZonaView2PaginationButtonBar',
			3,"inactivo");
	}
	if(zonZonaView2PageCount > 1){
		set_estado_botonera('zonZonaView2PaginationButtonBar',
			2,"activo");
		set_estado_botonera('zonZonaView2PaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('zonZonaView2PaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('zonZonaView2PaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function zonZonaView2UpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonZonaView2List.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('zonZonaView2Frm.idSelection', zonZonaView2List.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('zonZonaView2Frm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = zonZonaView2List.codSeleccionados()[0];
		parametros["previousAction"] = get('zonZonaView2Frm.accion');
		parametros["accion"] = get('zonZonaView2Frm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('ZonZonaView2LPStartUp', get('zonZonaView2Frm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) zonZonaView2CmdRequery();
	}
}

function zonZonaView2RemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonZonaView2List.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = zonZonaView2List.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('zonZonaView2Frm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(zonZonaView2List.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += zonZonaView2TimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('zonZonaView2Frm.timestamp', timestamps);


	zonZonaView2Frm.oculto='S';
	envia('zonZonaView2Frm');
	zonZonaView2Frm.oculto='N';
}

function zonZonaView2ViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonZonaView2List.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	zonZonaView2ViewDetail(zonZonaView2List.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function zonZonaView2ViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('zonZonaView2Frm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('ZonZonaView2LPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('zonZonaView2Frm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
		
	
	if(validacion){
		zonZonaView2Frm.oculto='S';
		envia('zonZonaView2Frm');
		zonZonaView2Frm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('zonZonaView2Frm.marcOidMarc').toString() == ''){
		set('zonZonaView2Frm.marcOidMarc', []);
		mmgResetCombosOnCascade('marcOidMarc', 'marcOidMarc', 'zonZonaView2');
		
	}
	if(get('zonZonaView2Frm.canaOidCana').toString() == ''){
		set('zonZonaView2Frm.canaOidCana', []);
		mmgResetCombosOnCascade('canaOidCana', 'canaOidCana', 'zonZonaView2');
		
	}
	if(get('zonZonaView2Frm.paisOidPais').toString() == ''){
		set('zonZonaView2Frm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'zonZonaView2');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	zonZonaView2RemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('zonZonaView2Frm.accion');
	var origenTmp = get('zonZonaView2Frm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(zonZonaView2BuildUpdateRecordString() != zonZonaView2TmpUpdateValues){
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
	document.all.zonZonaView2ListLayer.style.display='none';
	document.all.zonZonaView2ListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.zonZonaView2ListLayer.style.display='';
	document.all.zonZonaView2ListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsZonZonaView2MarcOidMarc = get('zonZonaView2Frm.marcOidMarc')[0];
	jsZonZonaView2CanaOidCana = get('zonZonaView2Frm.canaOidCana')[0];
	jsZonZonaView2CodZona = get('zonZonaView2Frm.codZona').toString();
	
	
	var parametros = "";
	parametros += jsZonZonaView2MarcOidMarc + "|";
	parametros += jsZonZonaView2CanaOidCana + "|";
	parametros += jsZonZonaView2CodZona + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function zonZonaView2BuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsZonZonaView2MarcOidMarc + "|";
	parametros += jsZonZonaView2CanaOidCana + "|";
	parametros += jsZonZonaView2CodZona + "|";
	parametros += jsZonZonaView2IndActi + "|";
	parametros += jsZonZonaView2IndBorr + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonZonaView2Frm.accion'), 
		get('zonZonaView2Frm.origen'));
	
	jsZonZonaView2Id = get('zonZonaView2Frm.id').toString();
	jsZonZonaView2MarcOidMarc = get('zonZonaView2Frm.marcOidMarc')[0];
	jsZonZonaView2CanaOidCana = get('zonZonaView2Frm.canaOidCana')[0];
	jsZonZonaView2CodZona = get('zonZonaView2Frm.codZona').toString();
	jsZonZonaView2PaisOidPais = get('zonZonaView2Frm.paisOidPais')[0];
	jsZonZonaView2IndActi = get('zonZonaView2Frm.indActi').toString();
	jsZonZonaView2IndBorr = get('zonZonaView2Frm.indBorr').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonZonaView2Frm.accion'), 
		get('zonZonaView2Frm.origen'));


	set('zonZonaView2Frm.id', jsZonZonaView2Id);
	set('zonZonaView2Frm.marcOidMarc', [jsZonZonaView2MarcOidMarc]);
	set('zonZonaView2Frm.canaOidCana', [jsZonZonaView2CanaOidCana]);
	set('zonZonaView2Frm.codZona', jsZonZonaView2CodZona);
	set('zonZonaView2Frm.paisOidPais', [jsZonZonaView2PaisOidPais]);
	set('zonZonaView2Frm.indActi', jsZonZonaView2IndActi);
	set('zonZonaView2Frm.indBorr', jsZonZonaView2IndBorr);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsZonZonaView2MarcOidMarc = '';
	jsZonZonaView2CanaOidCana = '';
	jsZonZonaView2CodZona = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('zonZonaView2Frm.errCodigo', errorCode);
	set('zonZonaView2Frm.errDescripcion', description);
	set('zonZonaView2Frm.errSeverity', severity);
	fMostrarMensajeError();
}

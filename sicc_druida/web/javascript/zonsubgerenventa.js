

/*
    INDRA/CAR/mmg
    $Id: zonsubgerenventa.js,v 1.1 2009/12/03 19:02:18 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsZonSubGerenVentaPaisOidPais = "";
var jsZonSubGerenVentaMarcOidMarc = "";
var jsZonSubGerenVentaCanaOidCana = "";
var jsZonSubGerenVentaId = "";
var jsZonSubGerenVentaCodSubgVent = "";
var jsZonSubGerenVentaIndBorr = "";
var jsZonSubGerenVentaIndActi = "";
var jsZonSubGerenVentaCodNse1 = "";
var jsZonSubGerenVentaCodNse2 = "";
var jsZonSubGerenVentaCodNse3 = "";
var jsZonSubGerenVentaDesSubgVent = "";
var jsZonSubGerenVentaClieOidClie = "";
var jsZonSubGerenVentaFecRezo = "";

//Variables de paginacion, 
var zonSubGerenVentaPageCount = 1;

//Varible de columna que representa el campo de choice
var zonSubGerenVentaChoiceColumn = 12;

//Flag de siguiente pagina;
var zonSubGerenVentaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var zonSubGerenVentaTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 567;
var sizeFormView = 561;
var sizeFormUpdate = 561;

//Ultima busqueda realizada
var zonSubGerenVentaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("zonSubGerenVentaFrm.fecRezo");','focaliza("zonSubGerenVentaFrm.fecRezo");','focaliza("zonSubGerenVentaFrm.fecRezo");','focaliza("zonSubGerenVentaFrm.fecRezo");','focaliza("zonSubGerenVentaFrm.fecRezo");','focaliza("zonSubGerenVentaFrm.fecRezo");']]);

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
paisOidPaisDependeceMap.agregar(['paisOidPais_moneOidMoneAlt', padresTmp, 'paisOidPais', 'SegMoned']);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_moneOidMone', padresTmp, 'paisOidPais', 'SegMoned']);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_fopaOidFormPago', padresTmp, 'paisOidPais', 'BelFormaPagoTapon']);
padresTmp =  new Vector();
padresTmp.cargar(['paisOidPais_moneOidMoneAlt','paisOidPais_moneOidMone','paisOidPais_fopaOidFormPago'])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPais']);
var marcOidMarcDependeceMap = new Vector();
marcOidMarcDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
marcOidMarcDependeceMap.agregar(['marcOidMarc', padresTmp, '', 'SegMarca']);
var canaOidCanaDependeceMap = new Vector();
canaOidCanaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
canaOidCanaDependeceMap.agregar(['canaOidCana_tipeOidTipoPeri', padresTmp, 'canaOidCana', 'SegTipoPerio']);
padresTmp =  new Vector();
padresTmp.cargar(['canaOidCana_tipeOidTipoPeri'])
canaOidCanaDependeceMap.agregar(['canaOidCana', padresTmp, '', 'SegCanal']);
var clieOidClieDependeceMap = new Vector();
clieOidClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
clieOidClieDependeceMap.agregar(['clieOidClie', padresTmp, '', 'MaeClien']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
zonSubGerenVentaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var zonSubGerenVentaTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function zonSubGerenVentaInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('zonSubGerenVentaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('zonSubGerenVentaFrm.accion')){
		case "query": zonSubGerenVentaQueryInitComponents(); break;
		case "view": zonSubGerenVentaViewInitComponents(); break;
		case "create": zonSubGerenVentaCreateInitComponents(); break;
		case "update": zonSubGerenVentaUpdateInitComponents(); break;
		case "remove": zonSubGerenVentaRemoveInitComponents(); break;
		case "lov": zonSubGerenVentaLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('zonSubGerenVentaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('zonSubGerenVenta')) zonSubGerenVentaCmdRequery();
}

function zonSubGerenVentaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

function zonSubGerenVentaViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
}

function zonSubGerenVentaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('zonSubGerenVentaFrm.paisOidPais','S', GestionarMensaje('ZonSubGerenVenta.paisOidPais.requiered.message'));
	
	setMV('zonSubGerenVentaFrm.marcOidMarc','S', GestionarMensaje('ZonSubGerenVenta.marcOidMarc.requiered.message'));
	
	setMV('zonSubGerenVentaFrm.canaOidCana','S', GestionarMensaje('ZonSubGerenVenta.canaOidCana.requiered.message'));
	
	setMV('zonSubGerenVentaFrm.codSubgVent','S', GestionarMensaje('ZonSubGerenVenta.codSubgVent.requiered.message'));
	
	setMV('zonSubGerenVentaFrm.fecRezo','S', GestionarMensaje('ZonSubGerenVenta.fecRezo.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function zonSubGerenVentaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('zonSubGerenVentaFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		zonSubGerenVentaTmpUpdateValues = zonSubGerenVentaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('zonSubGerenVentaFrm.paisOidPais','S', GestionarMensaje('ZonSubGerenVenta.paisOidPais.requiered.message'));
		setMV('zonSubGerenVentaFrm.marcOidMarc','S', GestionarMensaje('ZonSubGerenVenta.marcOidMarc.requiered.message'));
		setMV('zonSubGerenVentaFrm.canaOidCana','S', GestionarMensaje('ZonSubGerenVenta.canaOidCana.requiered.message'));
		setMV('zonSubGerenVentaFrm.codSubgVent','S', GestionarMensaje('ZonSubGerenVenta.codSubgVent.requiered.message'));
		setMV('zonSubGerenVentaFrm.fecRezo','S', GestionarMensaje('ZonSubGerenVenta.fecRezo.requiered.message'));
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('zonSubGerenVentaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function zonSubGerenVentaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	zonSubGerenVentaList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function zonSubGerenVentaLovInitComponents(){
	zonSubGerenVentaLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad















//Función que permite cargar los datos de un elemento de lov seleccionado
function zonSubGerenVentaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('zonSubGerenVentaFrm.' + campo, id);
	set('zonSubGerenVentaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function zonSubGerenVentaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	zonSubGerenVentaLovReturnParameters.id = '';
	zonSubGerenVentaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function zonSubGerenVentaLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonSubGerenVentaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = zonSubGerenVentaList.codSeleccionados();
	var descripcion = zonSubGerenVentaList.extraeDato(
		zonSubGerenVentaList.codSeleccionados()[0], zonSubGerenVentaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	zonSubGerenVentaLovReturnParameters.id = codigo;
	zonSubGerenVentaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function zonSubGerenVentaCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('zonSubGerenVentaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('zonSubGerenVentaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "zonSubGerenVentaList", "ZonSubGerenVentaConectorTransactionQuery", 
		"result_ROWSET", parametros, "zonSubGerenVentaPostQueryActions(datos);"]], "", "");	
}

function zonSubGerenVentaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('zonSubGerenVentaFrm.lastQueryToSession'));
	var i =0;
	set('zonSubGerenVentaFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('zonSubGerenVentaFrm.marcOidMarc', [paramsRequery.ij(i++)]);
	
	set('zonSubGerenVentaFrm.canaOidCana', [paramsRequery.ij(i++)]);
	
	set('zonSubGerenVentaFrm.codSubgVent', paramsRequery.ij(i++));
	
	set('zonSubGerenVentaFrm.indBorr', paramsRequery.ij(i++));
	
	set('zonSubGerenVentaFrm.indActi', paramsRequery.ij(i++));
	
	set('zonSubGerenVentaFrm.codNse1', paramsRequery.ij(i++));
	
	set('zonSubGerenVentaFrm.codNse2', paramsRequery.ij(i++));
	
	set('zonSubGerenVentaFrm.codNse3', paramsRequery.ij(i++));
	
	set('zonSubGerenVentaFrm.desSubgVent', paramsRequery.ij(i++));
	
	set('zonSubGerenVentaFrm.clieOidClie', [paramsRequery.ij(i++)]);
	
	set('zonSubGerenVentaFrm.fecRezo', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	zonSubGerenVentaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	zonSubGerenVentaCmdQuery(zonSubGerenVentaPageCount);
}

function zonSubGerenVentaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	zonSubGerenVentaPageCount = 1;
	zonSubGerenVentaCmdQuery(zonSubGerenVentaPageCount);
}

function zonSubGerenVentaPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonSubGerenVentaLastQuery){
		zonSubGerenVentaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	zonSubGerenVentaPageCount--;
	zonSubGerenVentaCmdQuery(zonSubGerenVentaPageCount);
}

function zonSubGerenVentaNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonSubGerenVentaLastQuery){
		zonSubGerenVentaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	zonSubGerenVentaPageCount++;
	zonSubGerenVentaCmdQuery(zonSubGerenVentaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function zonSubGerenVentaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('zonSubGerenVentaListLayer', 'O');
		visibilidad('zonSubGerenVentaListButtonsLayer', 'O');
		if(get('zonSubGerenVentaFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	zonSubGerenVentaLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:zonSubGerenVentaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, zonSubGerenVentaChoiceColumn) + "</A>",
			i, zonSubGerenVentaChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	zonSubGerenVentaList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10,11,12],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	zonSubGerenVentaTimeStamps = datosTmp.filtrar([13],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		zonSubGerenVentaMorePagesFlag = true;
		zonSubGerenVentaList.eliminar(mmgPageSize, 1);
	}else{
		zonSubGerenVentaMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('zonSubGerenVentaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('zonSubGerenVentaListLayer', 'V');
	visibilidad('zonSubGerenVentaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('zonSubGerenVentaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	zonSubGerenVentaList.display();
	
	//Actualizamos el estado de los botones 
	if(zonSubGerenVentaMorePagesFlag){
		set_estado_botonera('zonSubGerenVentaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('zonSubGerenVentaPaginationButtonBar',
			3,"inactivo");
	}
	if(zonSubGerenVentaPageCount > 1){
		set_estado_botonera('zonSubGerenVentaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('zonSubGerenVentaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('zonSubGerenVentaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('zonSubGerenVentaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function zonSubGerenVentaUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonSubGerenVentaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('zonSubGerenVentaFrm.idSelection', zonSubGerenVentaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('zonSubGerenVentaFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = zonSubGerenVentaList.codSeleccionados()[0];
		parametros["previousAction"] = get('zonSubGerenVentaFrm.accion');
		parametros["accion"] = get('zonSubGerenVentaFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('ZonSubGerenVentaLPStartUp', get('zonSubGerenVentaFrm.accion'), parametros, null, sizeFormView + 55);
		if(result == MMG_RC_OK) zonSubGerenVentaCmdRequery();
	}
}

function zonSubGerenVentaRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonSubGerenVentaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = zonSubGerenVentaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('zonSubGerenVentaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(zonSubGerenVentaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += zonSubGerenVentaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('zonSubGerenVentaFrm.timestamp', timestamps);


	zonSubGerenVentaFrm.oculto='S';
	envia('zonSubGerenVentaFrm');
	zonSubGerenVentaFrm.oculto='N';
}

function zonSubGerenVentaViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonSubGerenVentaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	zonSubGerenVentaViewDetail(zonSubGerenVentaList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function zonSubGerenVentaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('zonSubGerenVentaFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	mostrarModalSICC('ZonSubGerenVentaLPStartUp', 'view', parametros, null, sizeFormView + 55);
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
	var validacion = ValidaForm('zonSubGerenVentaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		zonSubGerenVentaFrm.oculto='S';
		envia('zonSubGerenVentaFrm');
		zonSubGerenVentaFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('zonSubGerenVentaFrm.paisOidPais').toString() == ''){
		set('zonSubGerenVentaFrm.paisOidPais_moneOidMoneAlt', []);
		mmgResetCombosOnCascade('paisOidPais_moneOidMoneAlt', 'paisOidPais', 'zonSubGerenVenta');
		set('zonSubGerenVentaFrm.paisOidPais_moneOidMone', []);
		mmgResetCombosOnCascade('paisOidPais_moneOidMone', 'paisOidPais', 'zonSubGerenVenta');
		set('zonSubGerenVentaFrm.paisOidPais_fopaOidFormPago', []);
		mmgResetCombosOnCascade('paisOidPais_fopaOidFormPago', 'paisOidPais', 'zonSubGerenVenta');
		
	}
	if(get('zonSubGerenVentaFrm.marcOidMarc').toString() == ''){
		set('zonSubGerenVentaFrm.marcOidMarc', []);
		mmgResetCombosOnCascade('marcOidMarc', 'marcOidMarc', 'zonSubGerenVenta');
		
	}
	if(get('zonSubGerenVentaFrm.canaOidCana').toString() == ''){
		set('zonSubGerenVentaFrm.canaOidCana_tipeOidTipoPeri', []);
		mmgResetCombosOnCascade('canaOidCana_tipeOidTipoPeri', 'canaOidCana', 'zonSubGerenVenta');
		
	}
	if(get('zonSubGerenVentaFrm.clieOidClie').toString() == ''){
		set('zonSubGerenVentaFrm.clieOidClie', []);
		mmgResetCombosOnCascade('clieOidClie', 'clieOidClie', 'zonSubGerenVenta');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	zonSubGerenVentaRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('zonSubGerenVentaFrm.accion');
	var origenTmp = get('zonSubGerenVentaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(zonSubGerenVentaBuildUpdateRecordString() != zonSubGerenVentaTmpUpdateValues){
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
	document.all.zonSubGerenVentaListLayer.style.display='none';
	document.all.zonSubGerenVentaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.zonSubGerenVentaListLayer.style.display='';
	document.all.zonSubGerenVentaListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsZonSubGerenVentaPaisOidPais = get('zonSubGerenVentaFrm.paisOidPais')[0];
	jsZonSubGerenVentaMarcOidMarc = get('zonSubGerenVentaFrm.marcOidMarc')[0];
	jsZonSubGerenVentaCanaOidCana = get('zonSubGerenVentaFrm.canaOidCana')[0];
	jsZonSubGerenVentaCodSubgVent = get('zonSubGerenVentaFrm.codSubgVent').toString();
	jsZonSubGerenVentaIndBorr = get('zonSubGerenVentaFrm.indBorr').toString();
	jsZonSubGerenVentaIndActi = get('zonSubGerenVentaFrm.indActi').toString();
	jsZonSubGerenVentaCodNse1 = get('zonSubGerenVentaFrm.codNse1').toString();
	jsZonSubGerenVentaCodNse2 = get('zonSubGerenVentaFrm.codNse2').toString();
	jsZonSubGerenVentaCodNse3 = get('zonSubGerenVentaFrm.codNse3').toString();
	jsZonSubGerenVentaDesSubgVent = get('zonSubGerenVentaFrm.desSubgVent').toString();
	jsZonSubGerenVentaClieOidClie = get('zonSubGerenVentaFrm.clieOidClie')[0];
	jsZonSubGerenVentaFecRezo = get('zonSubGerenVentaFrm.fecRezo').toString();
	
	
	var parametros = "";
	parametros += jsZonSubGerenVentaPaisOidPais + "|";
	parametros += jsZonSubGerenVentaMarcOidMarc + "|";
	parametros += jsZonSubGerenVentaCanaOidCana + "|";
	parametros += jsZonSubGerenVentaCodSubgVent + "|";
	parametros += jsZonSubGerenVentaIndBorr + "|";
	parametros += jsZonSubGerenVentaIndActi + "|";
	parametros += jsZonSubGerenVentaCodNse1 + "|";
	parametros += jsZonSubGerenVentaCodNse2 + "|";
	parametros += jsZonSubGerenVentaCodNse3 + "|";
	parametros += jsZonSubGerenVentaDesSubgVent + "|";
	parametros += jsZonSubGerenVentaClieOidClie + "|";
	parametros += jsZonSubGerenVentaFecRezo + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function zonSubGerenVentaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsZonSubGerenVentaPaisOidPais + "|";
	parametros += jsZonSubGerenVentaMarcOidMarc + "|";
	parametros += jsZonSubGerenVentaCanaOidCana + "|";
	parametros += jsZonSubGerenVentaCodSubgVent + "|";
	parametros += jsZonSubGerenVentaIndBorr + "|";
	parametros += jsZonSubGerenVentaIndActi + "|";
	parametros += jsZonSubGerenVentaCodNse1 + "|";
	parametros += jsZonSubGerenVentaCodNse2 + "|";
	parametros += jsZonSubGerenVentaCodNse3 + "|";
	parametros += jsZonSubGerenVentaDesSubgVent + "|";
	parametros += jsZonSubGerenVentaClieOidClie + "|";
	parametros += jsZonSubGerenVentaFecRezo + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonSubGerenVentaFrm.accion'), 
		get('zonSubGerenVentaFrm.origen'));
	
	jsZonSubGerenVentaPaisOidPais = get('zonSubGerenVentaFrm.paisOidPais')[0];
	jsZonSubGerenVentaMarcOidMarc = get('zonSubGerenVentaFrm.marcOidMarc')[0];
	jsZonSubGerenVentaCanaOidCana = get('zonSubGerenVentaFrm.canaOidCana')[0];
	jsZonSubGerenVentaId = get('zonSubGerenVentaFrm.id').toString();
	jsZonSubGerenVentaCodSubgVent = get('zonSubGerenVentaFrm.codSubgVent').toString();
	jsZonSubGerenVentaIndBorr = get('zonSubGerenVentaFrm.indBorr').toString();
	jsZonSubGerenVentaIndActi = get('zonSubGerenVentaFrm.indActi').toString();
	jsZonSubGerenVentaCodNse1 = get('zonSubGerenVentaFrm.codNse1').toString();
	jsZonSubGerenVentaCodNse2 = get('zonSubGerenVentaFrm.codNse2').toString();
	jsZonSubGerenVentaCodNse3 = get('zonSubGerenVentaFrm.codNse3').toString();
	jsZonSubGerenVentaDesSubgVent = get('zonSubGerenVentaFrm.desSubgVent').toString();
	jsZonSubGerenVentaClieOidClie = get('zonSubGerenVentaFrm.clieOidClie')[0];
	jsZonSubGerenVentaFecRezo = get('zonSubGerenVentaFrm.fecRezo').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonSubGerenVentaFrm.accion'), 
		get('zonSubGerenVentaFrm.origen'));


	set('zonSubGerenVentaFrm.paisOidPais', [jsZonSubGerenVentaPaisOidPais]);
	set('zonSubGerenVentaFrm.marcOidMarc', [jsZonSubGerenVentaMarcOidMarc]);
	set('zonSubGerenVentaFrm.canaOidCana', [jsZonSubGerenVentaCanaOidCana]);
	set('zonSubGerenVentaFrm.id', jsZonSubGerenVentaId);
	set('zonSubGerenVentaFrm.codSubgVent', jsZonSubGerenVentaCodSubgVent);
	set('zonSubGerenVentaFrm.indBorr', jsZonSubGerenVentaIndBorr);
	set('zonSubGerenVentaFrm.indActi', jsZonSubGerenVentaIndActi);
	set('zonSubGerenVentaFrm.codNse1', jsZonSubGerenVentaCodNse1);
	set('zonSubGerenVentaFrm.codNse2', jsZonSubGerenVentaCodNse2);
	set('zonSubGerenVentaFrm.codNse3', jsZonSubGerenVentaCodNse3);
	set('zonSubGerenVentaFrm.desSubgVent', jsZonSubGerenVentaDesSubgVent);
	set('zonSubGerenVentaFrm.clieOidClie', [jsZonSubGerenVentaClieOidClie]);
	set('zonSubGerenVentaFrm.fecRezo', jsZonSubGerenVentaFecRezo);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realziar la búsqueda
	jsZonSubGerenVentaPaisOidPais = '';
	jsZonSubGerenVentaMarcOidMarc = '';
	jsZonSubGerenVentaCanaOidCana = '';
	jsZonSubGerenVentaCodSubgVent = '';
	jsZonSubGerenVentaIndBorr = '';
	jsZonSubGerenVentaIndActi = '';
	jsZonSubGerenVentaCodNse1 = '';
	jsZonSubGerenVentaCodNse2 = '';
	jsZonSubGerenVentaCodNse3 = '';
	jsZonSubGerenVentaDesSubgVent = '';
	jsZonSubGerenVentaClieOidClie = '';
	jsZonSubGerenVentaFecRezo = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('zonSubGerenVentaFrm.errCodigo', errorCode);
	set('zonSubGerenVentaFrm.errDescripcion', description);
	set('zonSubGerenVentaFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	



/*
    INDRA/CAR/mmg
    $Id: pedasignalmac.js,v 1.1 2009/12/03 19:02:21 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPedAsignAlmacId = "";
var jsPedAsignAlmacPaisOidPais = "";
var jsPedAsignAlmacMarcOidMarc = "";
var jsPedAsignAlmacSbacOidSbac = "";
var jsPedAsignAlmacAlmcOidAlma = "";

//Variables de paginacion, 
var pedAsignAlmacPageCount = 1;

//Varible de columna que representa el campo de choice
var pedAsignAlmacChoiceColumn = 3;

//Flag de siguiente pagina;
var pedAsignAlmacMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var pedAsignAlmacTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 189;
var sizeFormView = 175;
var sizeFormUpdate = 175;

//Ultima busqueda realizada
var pedAsignAlmacLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focalizaComboDependence("pedAsignAlmac","marcOidMarc", false);','focalizaComboDependence("pedAsignAlmac","marcOidMarc", false);','focalizaComboDependence("pedAsignAlmac","marcOidMarc", false);','focalizaComboDependence("pedAsignAlmac","marcOidMarc", true);','focalizaComboDependence("pedAsignAlmac","marcOidMarc", true);','focalizaComboDependence("pedAsignAlmac","marcOidMarc", true);'],[6,'focalizaComboDependence("pedAsignAlmac","sbacOidSbac", false);','focalizaComboDependence("pedAsignAlmac","sbacOidSbac", false);','focalizaComboDependence("pedAsignAlmac","sbacOidSbac", false);','focalizaComboDependence("pedAsignAlmac","sbacOidSbac", true);','focalizaComboDependence("pedAsignAlmac","sbacOidSbac", true);','focalizaComboDependence("pedAsignAlmac","sbacOidSbac", true);'],[7,'focalizaComboDependence("pedAsignAlmac","almcOidAlma", false);','focalizaComboDependence("pedAsignAlmac","almcOidAlma", false);','focalizaComboDependence("pedAsignAlmac","almcOidAlma", false);','focalizaComboDependence("pedAsignAlmac","almcOidAlma", true);','focalizaComboDependence("pedAsignAlmac","almcOidAlma", true);','focalizaComboDependence("pedAsignAlmac","almcOidAlma", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'','','','','',''],[3,'focalizaComboDependence("pedAsignAlmac","marcOidMarc", false);','focalizaComboDependence("pedAsignAlmac","marcOidMarc", false);','focalizaComboDependence("pedAsignAlmac","marcOidMarc", false);','focalizaComboDependence("pedAsignAlmac","marcOidMarc", true);','focalizaComboDependence("pedAsignAlmac","marcOidMarc", true);','focalizaComboDependence("pedAsignAlmac","marcOidMarc", true);'],[6,'focalizaComboDependence("pedAsignAlmac","sbacOidSbac", false);','focalizaComboDependence("pedAsignAlmac","sbacOidSbac", false);','focalizaComboDependence("pedAsignAlmac","sbacOidSbac", false);','focalizaComboDependence("pedAsignAlmac","sbacOidSbac", true);','focalizaComboDependence("pedAsignAlmac","sbacOidSbac", true);','focalizaComboDependence("pedAsignAlmac","sbacOidSbac", true);'],[7,'focalizaComboDependence("pedAsignAlmac","almcOidAlma", false);','focalizaComboDependence("pedAsignAlmac","almcOidAlma", false);','focalizaComboDependence("pedAsignAlmac","almcOidAlma", false);','focalizaComboDependence("pedAsignAlmac","almcOidAlma", true);','focalizaComboDependence("pedAsignAlmac","almcOidAlma", true);','focalizaComboDependence("pedAsignAlmac","almcOidAlma", true);']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);
var marcOidMarcDependeceMap = new Vector();
marcOidMarcDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
marcOidMarcDependeceMap.agregar(['marcOidMarc', padresTmp, '', 'SegMarca']);
var sbacOidSbacDependeceMap = new Vector();
sbacOidSbacDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
sbacOidSbacDependeceMap.agregar(['sbacOidSbac_acceOidAcce_canaOidCana', padresTmp, 'sbacOidSbac_acceOidAcce', 'SegCanalView']);
padresTmp =  new Vector();
padresTmp.cargar(['sbacOidSbac_acceOidAcce_canaOidCana'])
sbacOidSbacDependeceMap.agregar(['sbacOidSbac_acceOidAcce', padresTmp, 'sbacOidSbac', 'SegAcces']);
padresTmp =  new Vector();
padresTmp.cargar(['sbacOidSbac_acceOidAcce'])
sbacOidSbacDependeceMap.agregar(['sbacOidSbac', padresTmp, '', 'SegSubac']);
var almcOidAlmaDependeceMap = new Vector();
almcOidAlmaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
almcOidAlmaDependeceMap.agregar(['almcOidAlma', padresTmp, '', 'BelAlmac']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
pedAsignAlmacLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var pedAsignAlmacTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function pedAsignAlmacInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('pedAsignAlmacFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('pedAsignAlmacFrm.accion')){
		case "query": pedAsignAlmacQueryInitComponents(); break;
		case "view": pedAsignAlmacViewInitComponents(); break;
		case "create": pedAsignAlmacCreateInitComponents(); break;
		case "update": pedAsignAlmacUpdateInitComponents(); break;
		case "remove": pedAsignAlmacRemoveInitComponents(); break;
		case "lov": pedAsignAlmacLovInitComponents(); break;
	}
	//alert('accion :' + get('pedAsignAlmacFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('pedAsignAlmacFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('pedAsignAlmac')) pedAsignAlmacCmdRequery();
}

function pedAsignAlmacQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('pedAsignAlmacFrm', true);	
}

function pedAsignAlmacViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('pedAsignAlmacFrm', true);
}

function pedAsignAlmacCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('pedAsignAlmacFrm.marcOidMarc','S', GestionarMensaje('PedAsignAlmac.marcOidMarc.requiered.message'));
	
	setMV('pedAsignAlmacFrm.sbacOidSbac','S', GestionarMensaje('PedAsignAlmac.sbacOidSbac.requiered.message'));
	
	setMV('pedAsignAlmacFrm.almcOidAlma','S', GestionarMensaje('PedAsignAlmac.almcOidAlma.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('pedAsignAlmacFrm', true);
}

function pedAsignAlmacUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('pedAsignAlmacFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		pedAsignAlmacTmpUpdateValues = pedAsignAlmacBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('pedAsignAlmacFrm.marcOidMarc','S', GestionarMensaje('PedAsignAlmac.marcOidMarc.requiered.message'));
		setMV('pedAsignAlmacFrm.sbacOidSbac','S', GestionarMensaje('PedAsignAlmac.sbacOidSbac.requiered.message'));
		setMV('pedAsignAlmacFrm.almcOidAlma','S', GestionarMensaje('PedAsignAlmac.almcOidAlma.requiered.message'));
		
			focusFirstFieldModify('pedAsignAlmacFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('pedAsignAlmacFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('pedAsignAlmacFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function pedAsignAlmacRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	pedAsignAlmacList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('pedAsignAlmacFrm', true);
}

function pedAsignAlmacLovInitComponents(){
	pedAsignAlmacLovReturnParameters = window.dialogArguments;
	
	focusFirstField('pedAsignAlmacFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function pedAsignAlmacSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('pedAsignAlmacFrm.' + campo, id);
	set('pedAsignAlmacFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function pedAsignAlmacLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	pedAsignAlmacLovReturnParameters.id = '';
	pedAsignAlmacLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function pedAsignAlmacLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedAsignAlmacList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = pedAsignAlmacList.codSeleccionados();
	var descripcion = pedAsignAlmacList.extraeDato(
		pedAsignAlmacList.codSeleccionados()[0], pedAsignAlmacChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	pedAsignAlmacLovReturnParameters.id = codigo;
	pedAsignAlmacLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function pedAsignAlmacCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('pedAsignAlmacFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('pedAsignAlmacFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "pedAsignAlmacList", "PedAsignAlmacConectorTransactionQuery", 
		"result_ROWSET", parametros, "pedAsignAlmacPostQueryActions(datos);"]], "", "");	
}

function pedAsignAlmacCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('pedAsignAlmacFrm.lastQueryToSession'));
	var i =0;
	set('pedAsignAlmacFrm.marcOidMarc', [paramsRequery.ij(i++)]);
	
	set('pedAsignAlmacFrm.sbacOidSbac', [paramsRequery.ij(i++)]);
	
	set('pedAsignAlmacFrm.almcOidAlma', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	pedAsignAlmacPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	pedAsignAlmacCmdQuery(pedAsignAlmacPageCount);
}

function pedAsignAlmacFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	pedAsignAlmacPageCount = 1;
	pedAsignAlmacCmdQuery(pedAsignAlmacPageCount);
}

function pedAsignAlmacPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedAsignAlmacLastQuery){
		pedAsignAlmacFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	pedAsignAlmacPageCount--;
	pedAsignAlmacCmdQuery(pedAsignAlmacPageCount);
}

function pedAsignAlmacNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedAsignAlmacLastQuery){
		pedAsignAlmacFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	pedAsignAlmacPageCount++;
	pedAsignAlmacCmdQuery(pedAsignAlmacPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function pedAsignAlmacPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('pedAsignAlmacListLayer', 'O');
		visibilidad('pedAsignAlmacListButtonsLayer', 'O');
		if(get('pedAsignAlmacFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	pedAsignAlmacLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:pedAsignAlmacViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, pedAsignAlmacChoiceColumn) + "</A>",
			i, pedAsignAlmacChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	pedAsignAlmacList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	pedAsignAlmacTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		pedAsignAlmacMorePagesFlag = true;
		pedAsignAlmacList.eliminar(mmgPageSize, 1);
	}else{
		pedAsignAlmacMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('pedAsignAlmacFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('pedAsignAlmacListLayer', 'V');
	visibilidad('pedAsignAlmacListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('pedAsignAlmacList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	pedAsignAlmacList.display();
	
	//Actualizamos el estado de los botones 
	if(pedAsignAlmacMorePagesFlag){
		set_estado_botonera('pedAsignAlmacPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('pedAsignAlmacPaginationButtonBar',
			3,"inactivo");
	}
	if(pedAsignAlmacPageCount > 1){
		set_estado_botonera('pedAsignAlmacPaginationButtonBar',
			2,"activo");
		set_estado_botonera('pedAsignAlmacPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('pedAsignAlmacPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('pedAsignAlmacPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function pedAsignAlmacUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedAsignAlmacList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('pedAsignAlmacFrm.idSelection', pedAsignAlmacList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('pedAsignAlmacFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = pedAsignAlmacList.codSeleccionados()[0];
		parametros["previousAction"] = get('pedAsignAlmacFrm.accion');
		parametros["accion"] = get('pedAsignAlmacFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('PedAsignAlmacLPStartUp', get('pedAsignAlmacFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) pedAsignAlmacCmdRequery();
	}
}

function pedAsignAlmacRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedAsignAlmacList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = pedAsignAlmacList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('pedAsignAlmacFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(pedAsignAlmacList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += pedAsignAlmacTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('pedAsignAlmacFrm.timestamp', timestamps);


	pedAsignAlmacFrm.oculto='S';
	envia('pedAsignAlmacFrm');
	pedAsignAlmacFrm.oculto='N';
}

function pedAsignAlmacViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedAsignAlmacList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	pedAsignAlmacViewDetail(pedAsignAlmacList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function pedAsignAlmacViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('pedAsignAlmacFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('PedAsignAlmacLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('pedAsignAlmacFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
		
	
	if(validacion){
		pedAsignAlmacFrm.oculto='S';
		envia('pedAsignAlmacFrm');
		pedAsignAlmacFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('pedAsignAlmacFrm.paisOidPais').toString() == ''){
		set('pedAsignAlmacFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'pedAsignAlmac');
		
	}
	if(get('pedAsignAlmacFrm.marcOidMarc').toString() == ''){
		set('pedAsignAlmacFrm.marcOidMarc', []);
		mmgResetCombosOnCascade('marcOidMarc', 'marcOidMarc', 'pedAsignAlmac');
		
	}
	if(get('pedAsignAlmacFrm.sbacOidSbac').toString() == ''){
		set('pedAsignAlmacFrm.sbacOidSbac_acceOidAcce_canaOidCana', []);
		mmgResetCombosOnCascade('sbacOidSbac_acceOidAcce_canaOidCana', 'sbacOidSbac', 'pedAsignAlmac');
		
	}
	if(get('pedAsignAlmacFrm.almcOidAlma').toString() == ''){
		set('pedAsignAlmacFrm.almcOidAlma', []);
		mmgResetCombosOnCascade('almcOidAlma', 'almcOidAlma', 'pedAsignAlmac');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	pedAsignAlmacRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('pedAsignAlmacFrm.accion');
	var origenTmp = get('pedAsignAlmacFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(pedAsignAlmacBuildUpdateRecordString() != pedAsignAlmacTmpUpdateValues){
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
	document.all.pedAsignAlmacListLayer.style.display='none';
	document.all.pedAsignAlmacListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.pedAsignAlmacListLayer.style.display='';
	document.all.pedAsignAlmacListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsPedAsignAlmacMarcOidMarc = get('pedAsignAlmacFrm.marcOidMarc')[0];
	jsPedAsignAlmacSbacOidSbac = get('pedAsignAlmacFrm.sbacOidSbac')[0];
	jsPedAsignAlmacAlmcOidAlma = get('pedAsignAlmacFrm.almcOidAlma')[0];
	
	
	var parametros = "";
	parametros += jsPedAsignAlmacMarcOidMarc + "|";
	parametros += jsPedAsignAlmacSbacOidSbac + "|";
	parametros += jsPedAsignAlmacAlmcOidAlma + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function pedAsignAlmacBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPedAsignAlmacMarcOidMarc + "|";
	parametros += jsPedAsignAlmacSbacOidSbac + "|";
	parametros += jsPedAsignAlmacAlmcOidAlma + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedAsignAlmacFrm.accion'), 
		get('pedAsignAlmacFrm.origen'));
	
	jsPedAsignAlmacId = get('pedAsignAlmacFrm.id').toString();
	jsPedAsignAlmacPaisOidPais = get('pedAsignAlmacFrm.paisOidPais')[0];
	jsPedAsignAlmacMarcOidMarc = get('pedAsignAlmacFrm.marcOidMarc')[0];
	jsPedAsignAlmacSbacOidSbac = get('pedAsignAlmacFrm.sbacOidSbac')[0];
	jsPedAsignAlmacAlmcOidAlma = get('pedAsignAlmacFrm.almcOidAlma')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedAsignAlmacFrm.accion'), 
		get('pedAsignAlmacFrm.origen'));


	set('pedAsignAlmacFrm.id', jsPedAsignAlmacId);
	set('pedAsignAlmacFrm.paisOidPais', [jsPedAsignAlmacPaisOidPais]);
	set('pedAsignAlmacFrm.marcOidMarc', [jsPedAsignAlmacMarcOidMarc]);
	set('pedAsignAlmacFrm.sbacOidSbac', [jsPedAsignAlmacSbacOidSbac]);
	set('pedAsignAlmacFrm.almcOidAlma', [jsPedAsignAlmacAlmcOidAlma]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsPedAsignAlmacMarcOidMarc = '';
	jsPedAsignAlmacSbacOidSbac = '';
	jsPedAsignAlmacAlmcOidAlma = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('pedAsignAlmacFrm.errCodigo', errorCode);
	set('pedAsignAlmacFrm.errDescripcion', description);
	set('pedAsignAlmacFrm.errSeverity', severity);
	fMostrarMensajeError();
}

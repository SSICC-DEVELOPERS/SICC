

/*
    INDRA/CAR/mmg
    $Id: pedimpuenegoc.js,v 1.1 2009/12/03 19:01:45 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPedImpueNegocId = "";
var jsPedImpueNegocPaisOidPais = "";
var jsPedImpueNegocSbacOidSbac = "";
var jsPedImpueNegocNegoOidNego = "";
var jsPedImpueNegocTaimOidTasaImpu = "";

//Variables de paginacion, 
var pedImpueNegocPageCount = 1;

//Varible de columna que representa el campo de choice
var pedImpueNegocChoiceColumn = 3;

//Flag de siguiente pagina;
var pedImpueNegocMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var pedImpueNegocTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 147;
var sizeFormView = 129;
var sizeFormUpdate = 129;

//Ultima busqueda realizada
var pedImpueNegocLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[5,'focalizaComboDependence("pedImpueNegoc","sbacOidSbac", false);','focalizaComboDependence("pedImpueNegoc","sbacOidSbac", false);','focalizaComboDependence("pedImpueNegoc","sbacOidSbac", false);','focalizaComboDependence("pedImpueNegoc","sbacOidSbac", true);','focalizaComboDependence("pedImpueNegoc","sbacOidSbac", true);','focalizaComboDependence("pedImpueNegoc","sbacOidSbac", true);'],[6,'focalizaComboDependence("pedImpueNegoc","negoOidNego", false);','focalizaComboDependence("pedImpueNegoc","negoOidNego", false);','focalizaComboDependence("pedImpueNegoc","negoOidNego", false);','focalizaComboDependence("pedImpueNegoc","negoOidNego", true);','focalizaComboDependence("pedImpueNegoc","negoOidNego", true);','focalizaComboDependence("pedImpueNegoc","negoOidNego", true);'],[7,'focalizaComboDependence("pedImpueNegoc","taimOidTasaImpu", false);','focalizaComboDependence("pedImpueNegoc","taimOidTasaImpu", false);','focalizaComboDependence("pedImpueNegoc","taimOidTasaImpu", false);','focalizaComboDependence("pedImpueNegoc","taimOidTasaImpu", true);','focalizaComboDependence("pedImpueNegoc","taimOidTasaImpu", true);','focalizaComboDependence("pedImpueNegoc","taimOidTasaImpu", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'','','','','',''],[7,'focalizaComboDependence("pedImpueNegoc","taimOidTasaImpu", false);','focalizaComboDependence("pedImpueNegoc","taimOidTasaImpu", false);','focalizaComboDependence("pedImpueNegoc","taimOidTasaImpu", false);','focalizaComboDependence("pedImpueNegoc","taimOidTasaImpu", true);','focalizaComboDependence("pedImpueNegoc","taimOidTasaImpu", true);','focalizaComboDependence("pedImpueNegoc","taimOidTasaImpu", true);']]);

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
var negoOidNegoDependeceMap = new Vector();
negoOidNegoDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
negoOidNegoDependeceMap.agregar(['negoOidNego', padresTmp, '', 'MaeNegoc']);
var taimOidTasaImpuDependeceMap = new Vector();
taimOidTasaImpuDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
taimOidTasaImpuDependeceMap.agregar(['taimOidTasaImpu', padresTmp, '', 'PedTasaImpue']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
pedImpueNegocLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var pedImpueNegocTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function pedImpueNegocInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('pedImpueNegocFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('pedImpueNegocFrm.accion')){
		case "query": pedImpueNegocQueryInitComponents(); break;
		case "view": pedImpueNegocViewInitComponents(); break;
		case "create": pedImpueNegocCreateInitComponents(); break;
		case "update": pedImpueNegocUpdateInitComponents(); break;
		case "remove": pedImpueNegocRemoveInitComponents(); break;
		case "lov": pedImpueNegocLovInitComponents(); break;
	}
	//alert('accion :' + get('pedImpueNegocFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('pedImpueNegocFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('pedImpueNegoc')) pedImpueNegocCmdRequery();
}

function pedImpueNegocQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('pedImpueNegocFrm', true);	
}

function pedImpueNegocViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('pedImpueNegocFrm', true);
}

function pedImpueNegocCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('pedImpueNegocFrm.sbacOidSbac','S', GestionarMensaje('PedImpueNegoc.sbacOidSbac.requiered.message'));
	
	setMV('pedImpueNegocFrm.negoOidNego','S', GestionarMensaje('PedImpueNegoc.negoOidNego.requiered.message'));
	
	setMV('pedImpueNegocFrm.taimOidTasaImpu','S', GestionarMensaje('PedImpueNegoc.taimOidTasaImpu.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('pedImpueNegocFrm', true);
}

function pedImpueNegocUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('pedImpueNegocFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		pedImpueNegocTmpUpdateValues = pedImpueNegocBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('pedImpueNegocFrm.sbacOidSbac','S', GestionarMensaje('PedImpueNegoc.sbacOidSbac.requiered.message'));
		setMV('pedImpueNegocFrm.negoOidNego','S', GestionarMensaje('PedImpueNegoc.negoOidNego.requiered.message'));
		setMV('pedImpueNegocFrm.taimOidTasaImpu','S', GestionarMensaje('PedImpueNegoc.taimOidTasaImpu.requiered.message'));
		
			focusFirstFieldModify('pedImpueNegocFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('pedImpueNegocFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('pedImpueNegocFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function pedImpueNegocRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	pedImpueNegocList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('pedImpueNegocFrm', true);
}

function pedImpueNegocLovInitComponents(){
	pedImpueNegocLovReturnParameters = window.dialogArguments;
	
	focusFirstField('pedImpueNegocFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function pedImpueNegocSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('pedImpueNegocFrm.' + campo, id);
	set('pedImpueNegocFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function pedImpueNegocLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	pedImpueNegocLovReturnParameters.id = '';
	pedImpueNegocLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function pedImpueNegocLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedImpueNegocList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = pedImpueNegocList.codSeleccionados();
	var descripcion = pedImpueNegocList.extraeDato(
		pedImpueNegocList.codSeleccionados()[0], pedImpueNegocChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	pedImpueNegocLovReturnParameters.id = codigo;
	pedImpueNegocLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function pedImpueNegocCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('pedImpueNegocFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('pedImpueNegocFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "pedImpueNegocList", "PedImpueNegocConectorTransactionQuery", 
		"result_ROWSET", parametros, "pedImpueNegocPostQueryActions(datos);"]], "", "");	
}

function pedImpueNegocCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('pedImpueNegocFrm.lastQueryToSession'));
	var i =0;
	set('pedImpueNegocFrm.sbacOidSbac', [paramsRequery.ij(i++)]);
	
	set('pedImpueNegocFrm.negoOidNego', [paramsRequery.ij(i++)]);
	
	set('pedImpueNegocFrm.taimOidTasaImpu', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	pedImpueNegocPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	pedImpueNegocCmdQuery(pedImpueNegocPageCount);
}

function pedImpueNegocFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	pedImpueNegocPageCount = 1;
	pedImpueNegocCmdQuery(pedImpueNegocPageCount);
}

function pedImpueNegocPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedImpueNegocLastQuery){
		pedImpueNegocFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	pedImpueNegocPageCount--;
	pedImpueNegocCmdQuery(pedImpueNegocPageCount);
}

function pedImpueNegocNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedImpueNegocLastQuery){
		pedImpueNegocFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	pedImpueNegocPageCount++;
	pedImpueNegocCmdQuery(pedImpueNegocPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function pedImpueNegocPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('pedImpueNegocListLayer', 'O');
		visibilidad('pedImpueNegocListButtonsLayer', 'O');
		if(get('pedImpueNegocFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	pedImpueNegocLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:pedImpueNegocViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, pedImpueNegocChoiceColumn) + "</A>",
			i, pedImpueNegocChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	pedImpueNegocList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	pedImpueNegocTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		pedImpueNegocMorePagesFlag = true;
		pedImpueNegocList.eliminar(mmgPageSize, 1);
	}else{
		pedImpueNegocMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('pedImpueNegocFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('pedImpueNegocListLayer', 'V');
	visibilidad('pedImpueNegocListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('pedImpueNegocList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	pedImpueNegocList.display();
	
	//Actualizamos el estado de los botones 
	if(pedImpueNegocMorePagesFlag){
		set_estado_botonera('pedImpueNegocPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('pedImpueNegocPaginationButtonBar',
			3,"inactivo");
	}
	if(pedImpueNegocPageCount > 1){
		set_estado_botonera('pedImpueNegocPaginationButtonBar',
			2,"activo");
		set_estado_botonera('pedImpueNegocPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('pedImpueNegocPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('pedImpueNegocPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function pedImpueNegocUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedImpueNegocList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('pedImpueNegocFrm.idSelection', pedImpueNegocList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('pedImpueNegocFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = pedImpueNegocList.codSeleccionados()[0];
		parametros["previousAction"] = get('pedImpueNegocFrm.accion');
		parametros["accion"] = get('pedImpueNegocFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('PedImpueNegocLPStartUp', get('pedImpueNegocFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) pedImpueNegocCmdRequery();
	}
}

function pedImpueNegocRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedImpueNegocList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = pedImpueNegocList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('pedImpueNegocFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(pedImpueNegocList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += pedImpueNegocTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('pedImpueNegocFrm.timestamp', timestamps);


	pedImpueNegocFrm.oculto='S';
	envia('pedImpueNegocFrm');
	pedImpueNegocFrm.oculto='N';
}

function pedImpueNegocViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedImpueNegocList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	pedImpueNegocViewDetail(pedImpueNegocList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function pedImpueNegocViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('pedImpueNegocFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('PedImpueNegocLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('pedImpueNegocFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
		
	
	if(validacion){
		pedImpueNegocFrm.oculto='S';
		envia('pedImpueNegocFrm');
		pedImpueNegocFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('pedImpueNegocFrm.paisOidPais').toString() == ''){
		set('pedImpueNegocFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'pedImpueNegoc');
		
	}
	if(get('pedImpueNegocFrm.sbacOidSbac').toString() == ''){
		set('pedImpueNegocFrm.sbacOidSbac_acceOidAcce_canaOidCana', []);
		mmgResetCombosOnCascade('sbacOidSbac_acceOidAcce_canaOidCana', 'sbacOidSbac', 'pedImpueNegoc');
		
	}
	if(get('pedImpueNegocFrm.negoOidNego').toString() == ''){
		set('pedImpueNegocFrm.negoOidNego', []);
		mmgResetCombosOnCascade('negoOidNego', 'negoOidNego', 'pedImpueNegoc');
		
	}
	if(get('pedImpueNegocFrm.taimOidTasaImpu').toString() == ''){
		set('pedImpueNegocFrm.taimOidTasaImpu', []);
		mmgResetCombosOnCascade('taimOidTasaImpu', 'taimOidTasaImpu', 'pedImpueNegoc');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	pedImpueNegocRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('pedImpueNegocFrm.accion');
	var origenTmp = get('pedImpueNegocFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(pedImpueNegocBuildUpdateRecordString() != pedImpueNegocTmpUpdateValues){
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
	document.all.pedImpueNegocListLayer.style.display='none';
	document.all.pedImpueNegocListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.pedImpueNegocListLayer.style.display='';
	document.all.pedImpueNegocListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsPedImpueNegocSbacOidSbac = get('pedImpueNegocFrm.sbacOidSbac')[0];
	jsPedImpueNegocNegoOidNego = get('pedImpueNegocFrm.negoOidNego')[0];
	jsPedImpueNegocTaimOidTasaImpu = get('pedImpueNegocFrm.taimOidTasaImpu')[0];
	
	
	var parametros = "";
	parametros += jsPedImpueNegocSbacOidSbac + "|";
	parametros += jsPedImpueNegocNegoOidNego + "|";
	parametros += jsPedImpueNegocTaimOidTasaImpu + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function pedImpueNegocBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPedImpueNegocSbacOidSbac + "|";
	parametros += jsPedImpueNegocNegoOidNego + "|";
	parametros += jsPedImpueNegocTaimOidTasaImpu + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedImpueNegocFrm.accion'), 
		get('pedImpueNegocFrm.origen'));
	
	jsPedImpueNegocId = get('pedImpueNegocFrm.id').toString();
	jsPedImpueNegocPaisOidPais = get('pedImpueNegocFrm.paisOidPais')[0];
	jsPedImpueNegocSbacOidSbac = get('pedImpueNegocFrm.sbacOidSbac')[0];
	jsPedImpueNegocNegoOidNego = get('pedImpueNegocFrm.negoOidNego')[0];
	jsPedImpueNegocTaimOidTasaImpu = get('pedImpueNegocFrm.taimOidTasaImpu')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedImpueNegocFrm.accion'), 
		get('pedImpueNegocFrm.origen'));


	set('pedImpueNegocFrm.id', jsPedImpueNegocId);
	set('pedImpueNegocFrm.paisOidPais', [jsPedImpueNegocPaisOidPais]);
	set('pedImpueNegocFrm.sbacOidSbac', [jsPedImpueNegocSbacOidSbac]);
	set('pedImpueNegocFrm.negoOidNego', [jsPedImpueNegocNegoOidNego]);
	set('pedImpueNegocFrm.taimOidTasaImpu', [jsPedImpueNegocTaimOidTasaImpu]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsPedImpueNegocSbacOidSbac = '';
	jsPedImpueNegocNegoOidNego = '';
	jsPedImpueNegocTaimOidTasaImpu = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('pedImpueNegocFrm.errCodigo', errorCode);
	set('pedImpueNegocFrm.errDescripcion', description);
	set('pedImpueNegocFrm.errSeverity', severity);
	fMostrarMensajeError();
}

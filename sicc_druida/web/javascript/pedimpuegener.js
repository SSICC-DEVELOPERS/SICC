

/*
    INDRA/CAR/mmg
    $Id: pedimpuegener.js,v 1.1 2009/12/03 19:01:30 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPedImpueGenerId = "";
var jsPedImpueGenerPaisOidPais = "";
var jsPedImpueGenerSbacOidSbac = "";
var jsPedImpueGenerTaimOidTasaImpu = "";
var jsPedImpueGenerTaimOidTasaImpuFlet = "";
var jsPedImpueGenerIndTasaUnic = "";

//Variables de paginacion, 
var pedImpueGenerPageCount = 1;

//Varible de columna que representa el campo de choice
var pedImpueGenerChoiceColumn = 4;

//Flag de siguiente pagina;
var pedImpueGenerMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var pedImpueGenerTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 147;
var sizeFormView = 129;
var sizeFormUpdate = 129;

//Ultima busqueda realizada
var pedImpueGenerLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[5,'focalizaComboDependence("pedImpueGener","sbacOidSbac", false);','focalizaComboDependence("pedImpueGener","sbacOidSbac", false);','focalizaComboDependence("pedImpueGener","sbacOidSbac", false);','focalizaComboDependence("pedImpueGener","sbacOidSbac", true);','focalizaComboDependence("pedImpueGener","sbacOidSbac", true);','focalizaComboDependence("pedImpueGener","sbacOidSbac", true);'],[6,'focalizaComboDependence("pedImpueGener","taimOidTasaImpu", false);','focalizaComboDependence("pedImpueGener","taimOidTasaImpu", false);','focalizaComboDependence("pedImpueGener","taimOidTasaImpu", false);','focalizaComboDependence("pedImpueGener","taimOidTasaImpu", true);','focalizaComboDependence("pedImpueGener","taimOidTasaImpu", true);','focalizaComboDependence("pedImpueGener","taimOidTasaImpu", true);'],[7,'focalizaComboDependence("pedImpueGener","taimOidTasaImpuFlet", false);','focalizaComboDependence("pedImpueGener","taimOidTasaImpuFlet", false);','focalizaComboDependence("pedImpueGener","taimOidTasaImpuFlet", false);','focalizaComboDependence("pedImpueGener","taimOidTasaImpuFlet", true);','focalizaComboDependence("pedImpueGener","taimOidTasaImpuFlet", true);','focalizaComboDependence("pedImpueGener","taimOidTasaImpuFlet", true);'],[8,'focaliza("pedImpueGenerFrm.indTasaUnic");','focaliza("pedImpueGenerFrm.indTasaUnic");','focaliza("pedImpueGenerFrm.indTasaUnic");','focaliza("pedImpueGenerFrm.indTasaUnic");','focaliza("pedImpueGenerFrm.indTasaUnic");','focaliza("pedImpueGenerFrm.indTasaUnic");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'','','','','',''],[6,'focalizaComboDependence("pedImpueGener","taimOidTasaImpu", false);','focalizaComboDependence("pedImpueGener","taimOidTasaImpu", false);','focalizaComboDependence("pedImpueGener","taimOidTasaImpu", false);','focalizaComboDependence("pedImpueGener","taimOidTasaImpu", true);','focalizaComboDependence("pedImpueGener","taimOidTasaImpu", true);','focalizaComboDependence("pedImpueGener","taimOidTasaImpu", true);'],[7,'focalizaComboDependence("pedImpueGener","taimOidTasaImpuFlet", false);','focalizaComboDependence("pedImpueGener","taimOidTasaImpuFlet", false);','focalizaComboDependence("pedImpueGener","taimOidTasaImpuFlet", false);','focalizaComboDependence("pedImpueGener","taimOidTasaImpuFlet", true);','focalizaComboDependence("pedImpueGener","taimOidTasaImpuFlet", true);','focalizaComboDependence("pedImpueGener","taimOidTasaImpuFlet", true);'],[8,'focaliza("pedImpueGenerFrm.indTasaUnic");','focaliza("pedImpueGenerFrm.indTasaUnic");','focaliza("pedImpueGenerFrm.indTasaUnic");','focaliza("pedImpueGenerFrm.indTasaUnic");','focaliza("pedImpueGenerFrm.indTasaUnic");','focaliza("pedImpueGenerFrm.indTasaUnic");']]);

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
var taimOidTasaImpuDependeceMap = new Vector();
taimOidTasaImpuDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
taimOidTasaImpuDependeceMap.agregar(['taimOidTasaImpu', padresTmp, '', 'PedTasaImpue']);
var taimOidTasaImpuFletDependeceMap = new Vector();
taimOidTasaImpuFletDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
taimOidTasaImpuFletDependeceMap.agregar(['taimOidTasaImpuFlet', padresTmp, '', 'PedTasaImpue']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
pedImpueGenerLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var pedImpueGenerTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function pedImpueGenerInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('pedImpueGenerFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('pedImpueGenerFrm.accion')){
		case "query": pedImpueGenerQueryInitComponents(); break;
		case "view": pedImpueGenerViewInitComponents(); break;
		case "create": pedImpueGenerCreateInitComponents(); break;
		case "update": pedImpueGenerUpdateInitComponents(); break;
		case "remove": pedImpueGenerRemoveInitComponents(); break;
		case "lov": pedImpueGenerLovInitComponents(); break;
	}
	//alert('accion :' + get('pedImpueGenerFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('pedImpueGenerFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('pedImpueGener')) pedImpueGenerCmdRequery();
}

function pedImpueGenerQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	focusFirstField('pedImpueGenerFrm', true);	
}

function pedImpueGenerViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('pedImpueGenerFrm', true);
}

function pedImpueGenerCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('pedImpueGenerFrm.sbacOidSbac','S', GestionarMensaje('PedImpueGener.sbacOidSbac.requiered.message'));
	
	setMV('pedImpueGenerFrm.taimOidTasaImpu','S', GestionarMensaje('PedImpueGener.taimOidTasaImpu.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('pedImpueGenerFrm', true);
}

function pedImpueGenerUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('pedImpueGenerFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		pedImpueGenerTmpUpdateValues = pedImpueGenerBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('pedImpueGenerFrm.sbacOidSbac','S', GestionarMensaje('PedImpueGener.sbacOidSbac.requiered.message'));
		setMV('pedImpueGenerFrm.taimOidTasaImpu','S', GestionarMensaje('PedImpueGener.taimOidTasaImpu.requiered.message'));
		
			focusFirstFieldModify('pedImpueGenerFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		focusFirstField('pedImpueGenerFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('pedImpueGenerFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function pedImpueGenerRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	pedImpueGenerList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('pedImpueGenerFrm', true);
}

function pedImpueGenerLovInitComponents(){
	pedImpueGenerLovReturnParameters = window.dialogArguments;
	
	focusFirstField('pedImpueGenerFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad








//Función que permite cargar los datos de un elemento de lov seleccionado
function pedImpueGenerSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('pedImpueGenerFrm.' + campo, id);
	set('pedImpueGenerFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function pedImpueGenerLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	pedImpueGenerLovReturnParameters.id = '';
	pedImpueGenerLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function pedImpueGenerLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedImpueGenerList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = pedImpueGenerList.codSeleccionados();
	var descripcion = pedImpueGenerList.extraeDato(
		pedImpueGenerList.codSeleccionados()[0], pedImpueGenerChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	pedImpueGenerLovReturnParameters.id = codigo;
	pedImpueGenerLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function pedImpueGenerCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('pedImpueGenerFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('pedImpueGenerFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "pedImpueGenerList", "PedImpueGenerConectorTransactionQuery", 
		"result_ROWSET", parametros, "pedImpueGenerPostQueryActions(datos);"]], "", "");	
}

function pedImpueGenerCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('pedImpueGenerFrm.lastQueryToSession'));
	var i =0;
	set('pedImpueGenerFrm.sbacOidSbac', [paramsRequery.ij(i++)]);
	
	set('pedImpueGenerFrm.taimOidTasaImpu', [paramsRequery.ij(i++)]);
	
	set('pedImpueGenerFrm.taimOidTasaImpuFlet', [paramsRequery.ij(i++)]);
	
	set('pedImpueGenerFrm.indTasaUnic', (paramsRequery.ij(i++) == 'true'? 'S': 'N'));
	
	
	
	//Establecemos la página de busqueda como la actual
	pedImpueGenerPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	pedImpueGenerCmdQuery(pedImpueGenerPageCount);
}

function pedImpueGenerFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	pedImpueGenerPageCount = 1;
	pedImpueGenerCmdQuery(pedImpueGenerPageCount);
}

function pedImpueGenerPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedImpueGenerLastQuery){
		pedImpueGenerFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	pedImpueGenerPageCount--;
	pedImpueGenerCmdQuery(pedImpueGenerPageCount);
}

function pedImpueGenerNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedImpueGenerLastQuery){
		pedImpueGenerFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	pedImpueGenerPageCount++;
	pedImpueGenerCmdQuery(pedImpueGenerPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function pedImpueGenerPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('pedImpueGenerListLayer', 'O');
		visibilidad('pedImpueGenerListButtonsLayer', 'O');
		if(get('pedImpueGenerFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	pedImpueGenerLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 4) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 4);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 4);
		}
	}
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:pedImpueGenerViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, pedImpueGenerChoiceColumn) + "</A>",
			i, pedImpueGenerChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	pedImpueGenerList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	pedImpueGenerTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		pedImpueGenerMorePagesFlag = true;
		pedImpueGenerList.eliminar(mmgPageSize, 1);
	}else{
		pedImpueGenerMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('pedImpueGenerFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('pedImpueGenerListLayer', 'V');
	visibilidad('pedImpueGenerListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('pedImpueGenerList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	pedImpueGenerList.display();
	
	//Actualizamos el estado de los botones 
	if(pedImpueGenerMorePagesFlag){
		set_estado_botonera('pedImpueGenerPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('pedImpueGenerPaginationButtonBar',
			3,"inactivo");
	}
	if(pedImpueGenerPageCount > 1){
		set_estado_botonera('pedImpueGenerPaginationButtonBar',
			2,"activo");
		set_estado_botonera('pedImpueGenerPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('pedImpueGenerPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('pedImpueGenerPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function pedImpueGenerUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedImpueGenerList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('pedImpueGenerFrm.idSelection', pedImpueGenerList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('pedImpueGenerFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = pedImpueGenerList.codSeleccionados()[0];
		parametros["previousAction"] = get('pedImpueGenerFrm.accion');
		parametros["accion"] = get('pedImpueGenerFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('PedImpueGenerLPStartUp', get('pedImpueGenerFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) pedImpueGenerCmdRequery();
	}
}

function pedImpueGenerRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedImpueGenerList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = pedImpueGenerList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('pedImpueGenerFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(pedImpueGenerList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += pedImpueGenerTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('pedImpueGenerFrm.timestamp', timestamps);


	pedImpueGenerFrm.oculto='S';
	envia('pedImpueGenerFrm');
	pedImpueGenerFrm.oculto='N';
}

function pedImpueGenerViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedImpueGenerList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	pedImpueGenerViewDetail(pedImpueGenerList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function pedImpueGenerViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('pedImpueGenerFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('PedImpueGenerLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('pedImpueGenerFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
		
	
	if(validacion){
		pedImpueGenerFrm.oculto='S';
		envia('pedImpueGenerFrm');
		pedImpueGenerFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('pedImpueGenerFrm.paisOidPais').toString() == ''){
		set('pedImpueGenerFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'pedImpueGener');
		
	}
	if(get('pedImpueGenerFrm.sbacOidSbac').toString() == ''){
		set('pedImpueGenerFrm.sbacOidSbac_acceOidAcce_canaOidCana', []);
		mmgResetCombosOnCascade('sbacOidSbac_acceOidAcce_canaOidCana', 'sbacOidSbac', 'pedImpueGener');
		
	}
	if(get('pedImpueGenerFrm.taimOidTasaImpu').toString() == ''){
		set('pedImpueGenerFrm.taimOidTasaImpu', []);
		mmgResetCombosOnCascade('taimOidTasaImpu', 'taimOidTasaImpu', 'pedImpueGener');
		
	}
	if(get('pedImpueGenerFrm.taimOidTasaImpuFlet').toString() == ''){
		set('pedImpueGenerFrm.taimOidTasaImpuFlet', []);
		mmgResetCombosOnCascade('taimOidTasaImpuFlet', 'taimOidTasaImpuFlet', 'pedImpueGener');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	pedImpueGenerRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('pedImpueGenerFrm.accion');
	var origenTmp = get('pedImpueGenerFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(pedImpueGenerBuildUpdateRecordString() != pedImpueGenerTmpUpdateValues){
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
	document.all.pedImpueGenerListLayer.style.display='none';
	document.all.pedImpueGenerListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.pedImpueGenerListLayer.style.display='';
	document.all.pedImpueGenerListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsPedImpueGenerSbacOidSbac = get('pedImpueGenerFrm.sbacOidSbac')[0];
	jsPedImpueGenerTaimOidTasaImpu = get('pedImpueGenerFrm.taimOidTasaImpu')[0];
	jsPedImpueGenerTaimOidTasaImpuFlet = get('pedImpueGenerFrm.taimOidTasaImpuFlet')[0];
	if(get('pedImpueGenerFrm.indTasaUnic').toString() == 'S') jsPedImpueGenerIndTasaUnic = "true";
	else jsPedImpueGenerIndTasaUnic = "false";
	
	
	var parametros = "";
	parametros += jsPedImpueGenerSbacOidSbac + "|";
	parametros += jsPedImpueGenerTaimOidTasaImpu + "|";
	parametros += jsPedImpueGenerTaimOidTasaImpuFlet + "|";
	parametros += jsPedImpueGenerIndTasaUnic + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function pedImpueGenerBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPedImpueGenerSbacOidSbac + "|";
	parametros += jsPedImpueGenerTaimOidTasaImpu + "|";
	parametros += jsPedImpueGenerTaimOidTasaImpuFlet + "|";
	parametros += jsPedImpueGenerIndTasaUnic + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedImpueGenerFrm.accion'), 
		get('pedImpueGenerFrm.origen'));
	
	jsPedImpueGenerId = get('pedImpueGenerFrm.id').toString();
	jsPedImpueGenerPaisOidPais = get('pedImpueGenerFrm.paisOidPais')[0];
	jsPedImpueGenerSbacOidSbac = get('pedImpueGenerFrm.sbacOidSbac')[0];
	jsPedImpueGenerTaimOidTasaImpu = get('pedImpueGenerFrm.taimOidTasaImpu')[0];
	jsPedImpueGenerTaimOidTasaImpuFlet = get('pedImpueGenerFrm.taimOidTasaImpuFlet')[0];
	if(get('pedImpueGenerFrm.indTasaUnic').toString() == 'S') jsPedImpueGenerIndTasaUnic = "true";
		else jsPedImpueGenerIndTasaUnic = "false";
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedImpueGenerFrm.accion'), 
		get('pedImpueGenerFrm.origen'));


	set('pedImpueGenerFrm.id', jsPedImpueGenerId);
	set('pedImpueGenerFrm.paisOidPais', [jsPedImpueGenerPaisOidPais]);
	set('pedImpueGenerFrm.sbacOidSbac', [jsPedImpueGenerSbacOidSbac]);
	set('pedImpueGenerFrm.taimOidTasaImpu', [jsPedImpueGenerTaimOidTasaImpu]);
	set('pedImpueGenerFrm.taimOidTasaImpuFlet', [jsPedImpueGenerTaimOidTasaImpuFlet]);
	
			
			if(jsPedImpueGenerIndTasaUnic == "true") set('pedImpueGenerFrm.indTasaUnic', 'S');
			else set('pedImpueGenerFrm.indTasaUnic', 'N');
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsPedImpueGenerSbacOidSbac = '';
	jsPedImpueGenerTaimOidTasaImpu = '';
	jsPedImpueGenerTaimOidTasaImpuFlet = '';
	jsPedImpueGenerIndTasaUnic = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('pedImpueGenerFrm.errCodigo', errorCode);
	set('pedImpueGenerFrm.errDescripcion', description);
	set('pedImpueGenerFrm.errSeverity', severity);
	fMostrarMensajeError();
}

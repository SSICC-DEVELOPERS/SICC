

/*
    INDRA/CAR/mmg
    $Id: intaccesbuzonivrrg.js,v 1.1 2009/12/03 19:01:51 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsIntAccesBuzonIvrrgId = "";
var jsIntAccesBuzonIvrrgCodAcceBuzoIvrr = "";
var jsIntAccesBuzonIvrrgZorgOidRegi = "";

//Variables de paginacion, 
var intAccesBuzonIvrrgPageCount = 1;

//Varible de columna que representa el campo de choice
var intAccesBuzonIvrrgChoiceColumn = 2;

//Flag de siguiente pagina;
var intAccesBuzonIvrrgMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var intAccesBuzonIvrrgTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 147;
var sizeFormView = 129;
var sizeFormUpdate = 129;

//Ultima busqueda realizada
var intAccesBuzonIvrrgLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("intAccesBuzonIvrrgFrm.codAcceBuzoIvrr");','focaliza("intAccesBuzonIvrrgFrm.codAcceBuzoIvrr");','focaliza("intAccesBuzonIvrrgFrm.codAcceBuzoIvrr");','focaliza("intAccesBuzonIvrrgFrm.codAcceBuzoIvrr");','focaliza("intAccesBuzonIvrrgFrm.codAcceBuzoIvrr");','focaliza("intAccesBuzonIvrrgFrm.codAcceBuzoIvrr");'],[3,'focalizaComboDependence("intAccesBuzonIvrrg","zorgOidRegi", false);','focalizaComboDependence("intAccesBuzonIvrrg","zorgOidRegi", false);','focalizaComboDependence("intAccesBuzonIvrrg","zorgOidRegi", false);','focalizaComboDependence("intAccesBuzonIvrrg","zorgOidRegi", true);','focalizaComboDependence("intAccesBuzonIvrrg","zorgOidRegi", true);','focalizaComboDependence("intAccesBuzonIvrrg","zorgOidRegi", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focalizaComboDependence("intAccesBuzonIvrrg","zorgOidRegi", false);','focalizaComboDependence("intAccesBuzonIvrrg","zorgOidRegi", false);','focalizaComboDependence("intAccesBuzonIvrrg","zorgOidRegi", false);','focalizaComboDependence("intAccesBuzonIvrrg","zorgOidRegi", true);','focalizaComboDependence("intAccesBuzonIvrrg","zorgOidRegi", true);','focalizaComboDependence("intAccesBuzonIvrrg","zorgOidRegi", true);']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var zorgOidRegiDependeceMap = new Vector();
zorgOidRegiDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zorgOidRegiDependeceMap.agregar(['zorgOidRegi_canaOidCana', padresTmp, 'zorgOidRegi', 'SegCanalView']);
padresTmp =  new Vector();
padresTmp.cargar([])
zorgOidRegiDependeceMap.agregar(['zorgOidRegi_marcOidMarc', padresTmp, 'zorgOidRegi', 'SegMarca']);
padresTmp =  new Vector();
padresTmp.cargar(['zorgOidRegi_canaOidCana','zorgOidRegi_marcOidMarc'])
zorgOidRegiDependeceMap.agregar(['zorgOidRegi', padresTmp, '', 'ZonRegioView2']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
intAccesBuzonIvrrgLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var intAccesBuzonIvrrgTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function intAccesBuzonIvrrgInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('intAccesBuzonIvrrgFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('intAccesBuzonIvrrgFrm.accion')){
		case "query": intAccesBuzonIvrrgQueryInitComponents(); break;
		case "view": intAccesBuzonIvrrgViewInitComponents(); break;
		case "create": intAccesBuzonIvrrgCreateInitComponents(); break;
		case "update": intAccesBuzonIvrrgUpdateInitComponents(); break;
		case "remove": intAccesBuzonIvrrgRemoveInitComponents(); break;
		case "lov": intAccesBuzonIvrrgLovInitComponents(); break;
	}
	//alert('accion :' + get('intAccesBuzonIvrrgFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('intAccesBuzonIvrrgFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('intAccesBuzonIvrrg')) intAccesBuzonIvrrgCmdRequery();
}

function intAccesBuzonIvrrgQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('intAccesBuzonIvrrgFrm', true);	
}

function intAccesBuzonIvrrgViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('intAccesBuzonIvrrgFrm', true);
}

function intAccesBuzonIvrrgCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('intAccesBuzonIvrrgFrm.codAcceBuzoIvrr','S', GestionarMensaje('IntAccesBuzonIvrrg.codAcceBuzoIvrr.requiered.message'));
	
	setMV('intAccesBuzonIvrrgFrm.zorgOidRegi','S', GestionarMensaje('IntAccesBuzonIvrrg.zorgOidRegi.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('intAccesBuzonIvrrgFrm', true);
}

function intAccesBuzonIvrrgUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('intAccesBuzonIvrrgFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		intAccesBuzonIvrrgTmpUpdateValues = intAccesBuzonIvrrgBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('intAccesBuzonIvrrgFrm.codAcceBuzoIvrr','S', GestionarMensaje('IntAccesBuzonIvrrg.codAcceBuzoIvrr.requiered.message'));
		setMV('intAccesBuzonIvrrgFrm.zorgOidRegi','S', GestionarMensaje('IntAccesBuzonIvrrg.zorgOidRegi.requiered.message'));
		
			focusFirstFieldModify('intAccesBuzonIvrrgFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('intAccesBuzonIvrrgFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('intAccesBuzonIvrrgFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function intAccesBuzonIvrrgRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	intAccesBuzonIvrrgList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('intAccesBuzonIvrrgFrm', true);
}

function intAccesBuzonIvrrgLovInitComponents(){
	intAccesBuzonIvrrgLovReturnParameters = window.dialogArguments;
	
	focusFirstField('intAccesBuzonIvrrgFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad





//Función que permite cargar los datos de un elemento de lov seleccionado
function intAccesBuzonIvrrgSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('intAccesBuzonIvrrgFrm.' + campo, id);
	set('intAccesBuzonIvrrgFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function intAccesBuzonIvrrgLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	intAccesBuzonIvrrgLovReturnParameters.id = '';
	intAccesBuzonIvrrgLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function intAccesBuzonIvrrgLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(intAccesBuzonIvrrgList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = intAccesBuzonIvrrgList.codSeleccionados();
	var descripcion = intAccesBuzonIvrrgList.extraeDato(
		intAccesBuzonIvrrgList.codSeleccionados()[0], intAccesBuzonIvrrgChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	intAccesBuzonIvrrgLovReturnParameters.id = codigo;
	intAccesBuzonIvrrgLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function intAccesBuzonIvrrgCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('intAccesBuzonIvrrgFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('intAccesBuzonIvrrgFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "intAccesBuzonIvrrgList", "IntAccesBuzonIvrrgConectorTransactionQuery", 
		"result_ROWSET", parametros, "intAccesBuzonIvrrgPostQueryActions(datos);"]], "", "");	
}

function intAccesBuzonIvrrgCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('intAccesBuzonIvrrgFrm.lastQueryToSession'));
	var i =0;
	set('intAccesBuzonIvrrgFrm.codAcceBuzoIvrr', paramsRequery.ij(i++));
	
	set('intAccesBuzonIvrrgFrm.zorgOidRegi', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	intAccesBuzonIvrrgPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	intAccesBuzonIvrrgCmdQuery(intAccesBuzonIvrrgPageCount);
}

function intAccesBuzonIvrrgFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	intAccesBuzonIvrrgPageCount = 1;
	intAccesBuzonIvrrgCmdQuery(intAccesBuzonIvrrgPageCount);
}

function intAccesBuzonIvrrgPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != intAccesBuzonIvrrgLastQuery){
		intAccesBuzonIvrrgFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	intAccesBuzonIvrrgPageCount--;
	intAccesBuzonIvrrgCmdQuery(intAccesBuzonIvrrgPageCount);
}

function intAccesBuzonIvrrgNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != intAccesBuzonIvrrgLastQuery){
		intAccesBuzonIvrrgFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	intAccesBuzonIvrrgPageCount++;
	intAccesBuzonIvrrgCmdQuery(intAccesBuzonIvrrgPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function intAccesBuzonIvrrgPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('intAccesBuzonIvrrgListLayer', 'O');
		visibilidad('intAccesBuzonIvrrgListButtonsLayer', 'O');
		if(get('intAccesBuzonIvrrgFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	intAccesBuzonIvrrgLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:intAccesBuzonIvrrgViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, intAccesBuzonIvrrgChoiceColumn) + "</A>",
			i, intAccesBuzonIvrrgChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	intAccesBuzonIvrrgList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	intAccesBuzonIvrrgTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		intAccesBuzonIvrrgMorePagesFlag = true;
		intAccesBuzonIvrrgList.eliminar(mmgPageSize, 1);
	}else{
		intAccesBuzonIvrrgMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('intAccesBuzonIvrrgFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('intAccesBuzonIvrrgListLayer', 'V');
	visibilidad('intAccesBuzonIvrrgListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('intAccesBuzonIvrrgList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	intAccesBuzonIvrrgList.display();
	
	//Actualizamos el estado de los botones 
	if(intAccesBuzonIvrrgMorePagesFlag){
		set_estado_botonera('intAccesBuzonIvrrgPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('intAccesBuzonIvrrgPaginationButtonBar',
			3,"inactivo");
	}
	if(intAccesBuzonIvrrgPageCount > 1){
		set_estado_botonera('intAccesBuzonIvrrgPaginationButtonBar',
			2,"activo");
		set_estado_botonera('intAccesBuzonIvrrgPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('intAccesBuzonIvrrgPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('intAccesBuzonIvrrgPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function intAccesBuzonIvrrgUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(intAccesBuzonIvrrgList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('intAccesBuzonIvrrgFrm.idSelection', intAccesBuzonIvrrgList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('intAccesBuzonIvrrgFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = intAccesBuzonIvrrgList.codSeleccionados()[0];
		parametros["previousAction"] = get('intAccesBuzonIvrrgFrm.accion');
		parametros["accion"] = get('intAccesBuzonIvrrgFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('IntAccesBuzonIvrrgLPStartUp', get('intAccesBuzonIvrrgFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) intAccesBuzonIvrrgCmdRequery();
	}
}

function intAccesBuzonIvrrgRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(intAccesBuzonIvrrgList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = intAccesBuzonIvrrgList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('intAccesBuzonIvrrgFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(intAccesBuzonIvrrgList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += intAccesBuzonIvrrgTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('intAccesBuzonIvrrgFrm.timestamp', timestamps);


	intAccesBuzonIvrrgFrm.oculto='S';
	envia('intAccesBuzonIvrrgFrm');
	intAccesBuzonIvrrgFrm.oculto='N';
}

function intAccesBuzonIvrrgViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(intAccesBuzonIvrrgList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	intAccesBuzonIvrrgViewDetail(intAccesBuzonIvrrgList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function intAccesBuzonIvrrgViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('intAccesBuzonIvrrgFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('IntAccesBuzonIvrrgLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('intAccesBuzonIvrrgFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
		
	
	if(validacion){
		intAccesBuzonIvrrgFrm.oculto='S';
		envia('intAccesBuzonIvrrgFrm');
		intAccesBuzonIvrrgFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('intAccesBuzonIvrrgFrm.zorgOidRegi').toString() == ''){
		set('intAccesBuzonIvrrgFrm.zorgOidRegi_canaOidCana', []);
		mmgResetCombosOnCascade('zorgOidRegi_canaOidCana', 'zorgOidRegi', 'intAccesBuzonIvrrg');
		set('intAccesBuzonIvrrgFrm.zorgOidRegi_marcOidMarc', []);
		mmgResetCombosOnCascade('zorgOidRegi_marcOidMarc', 'zorgOidRegi', 'intAccesBuzonIvrrg');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	intAccesBuzonIvrrgRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('intAccesBuzonIvrrgFrm.accion');
	var origenTmp = get('intAccesBuzonIvrrgFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(intAccesBuzonIvrrgBuildUpdateRecordString() != intAccesBuzonIvrrgTmpUpdateValues){
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
	document.all.intAccesBuzonIvrrgListLayer.style.display='none';
	document.all.intAccesBuzonIvrrgListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.intAccesBuzonIvrrgListLayer.style.display='';
	document.all.intAccesBuzonIvrrgListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsIntAccesBuzonIvrrgCodAcceBuzoIvrr = get('intAccesBuzonIvrrgFrm.codAcceBuzoIvrr').toString();
	jsIntAccesBuzonIvrrgZorgOidRegi = get('intAccesBuzonIvrrgFrm.zorgOidRegi')[0];
	
	
	var parametros = "";
	parametros += jsIntAccesBuzonIvrrgCodAcceBuzoIvrr + "|";
	parametros += jsIntAccesBuzonIvrrgZorgOidRegi + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function intAccesBuzonIvrrgBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsIntAccesBuzonIvrrgCodAcceBuzoIvrr + "|";
	parametros += jsIntAccesBuzonIvrrgZorgOidRegi + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('intAccesBuzonIvrrgFrm.accion'), 
		get('intAccesBuzonIvrrgFrm.origen'));
	
	jsIntAccesBuzonIvrrgId = get('intAccesBuzonIvrrgFrm.id').toString();
	jsIntAccesBuzonIvrrgCodAcceBuzoIvrr = get('intAccesBuzonIvrrgFrm.codAcceBuzoIvrr').toString();
	jsIntAccesBuzonIvrrgZorgOidRegi = get('intAccesBuzonIvrrgFrm.zorgOidRegi')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('intAccesBuzonIvrrgFrm.accion'), 
		get('intAccesBuzonIvrrgFrm.origen'));


	set('intAccesBuzonIvrrgFrm.id', jsIntAccesBuzonIvrrgId);
	set('intAccesBuzonIvrrgFrm.codAcceBuzoIvrr', jsIntAccesBuzonIvrrgCodAcceBuzoIvrr);
	set('intAccesBuzonIvrrgFrm.zorgOidRegi', [jsIntAccesBuzonIvrrgZorgOidRegi]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsIntAccesBuzonIvrrgCodAcceBuzoIvrr = '';
	jsIntAccesBuzonIvrrgZorgOidRegi = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('intAccesBuzonIvrrgFrm.errCodigo', errorCode);
	set('intAccesBuzonIvrrgFrm.errDescripcion', description);
	set('intAccesBuzonIvrrgFrm.errSeverity', severity);
	fMostrarMensajeError();
}

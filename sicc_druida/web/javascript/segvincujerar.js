

/*
    INDRA/CAR/mmg
    $Id: segvincujerar.js,v 1.1 2009/12/03 19:01:37 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsSegVincuJerarId = "";
var jsSegVincuJerarMarcOidMarc = "";
var jsSegVincuJerarCanaOidCana = "";
var jsSegVincuJerarAcceOidAcce = "";
var jsSegVincuJerarSbacOidSbac = "";
var jsSegVincuJerarPaisOidPais = "";
var jsSegVincuJerarSociOidSoci = "";

//Variables de paginacion, 
var segVincuJerarPageCount = 1;

//Varible de columna que representa el campo de choice
var segVincuJerarChoiceColumn = 5;

//Flag de siguiente pagina;
var segVincuJerarMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var segVincuJerarTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 189;
var sizeFormView = 163;
var sizeFormUpdate = 37;

//Ultima busqueda realizada
var segVincuJerarLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("segVincuJerar","marcOidMarc", false);','focalizaComboDependence("segVincuJerar","marcOidMarc", false);','','focalizaComboDependence("segVincuJerar","marcOidMarc", true);','focalizaComboDependence("segVincuJerar","marcOidMarc", true);',''],[3,'focalizaComboDependence("segVincuJerar","canaOidCana", false);','focalizaComboDependence("segVincuJerar","canaOidCana", false);','','focalizaComboDependence("segVincuJerar","canaOidCana", true);','focalizaComboDependence("segVincuJerar","canaOidCana", true);',''],[4,'focalizaComboDependence("segVincuJerar","acceOidAcce", false);','focalizaComboDependence("segVincuJerar","acceOidAcce", false);','','focalizaComboDependence("segVincuJerar","acceOidAcce", true);','focalizaComboDependence("segVincuJerar","acceOidAcce", true);',''],[5,'focalizaComboDependence("segVincuJerar","sbacOidSbac", false);','focalizaComboDependence("segVincuJerar","sbacOidSbac", false);','','focalizaComboDependence("segVincuJerar","sbacOidSbac", true);','focalizaComboDependence("segVincuJerar","sbacOidSbac", true);',''],[6,'','','','','',''],[7,'focalizaComboDependence("segVincuJerar","sociOidSoci", false);','focalizaComboDependence("segVincuJerar","sociOidSoci", false);','','focalizaComboDependence("segVincuJerar","sociOidSoci", true);','focalizaComboDependence("segVincuJerar","sociOidSoci", true);','']]);

//Vector con acciones de foco para la pantalla de modificaci�n.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focalizaComboDependence("segVincuJerar","marcOidMarc", false);','focalizaComboDependence("segVincuJerar","marcOidMarc", false);','','focalizaComboDependence("segVincuJerar","marcOidMarc", true);','focalizaComboDependence("segVincuJerar","marcOidMarc", true);',''],[3,'focalizaComboDependence("segVincuJerar","canaOidCana", false);','focalizaComboDependence("segVincuJerar","canaOidCana", false);','','focalizaComboDependence("segVincuJerar","canaOidCana", true);','focalizaComboDependence("segVincuJerar","canaOidCana", true);',''],[4,'focalizaComboDependence("segVincuJerar","acceOidAcce", false);','focalizaComboDependence("segVincuJerar","acceOidAcce", false);','','focalizaComboDependence("segVincuJerar","acceOidAcce", true);','focalizaComboDependence("segVincuJerar","acceOidAcce", true);',''],[5,'focalizaComboDependence("segVincuJerar","sbacOidSbac", false);','focalizaComboDependence("segVincuJerar","sbacOidSbac", false);','','focalizaComboDependence("segVincuJerar","sbacOidSbac", true);','focalizaComboDependence("segVincuJerar","sbacOidSbac", true);',''],[6,'','','','','',''],[7,'focalizaComboDependence("segVincuJerar","sociOidSoci", false);','focalizaComboDependence("segVincuJerar","sociOidSoci", false);','','focalizaComboDependence("segVincuJerar","sociOidSoci", true);','focalizaComboDependence("segVincuJerar","sociOidSoci", true);','']]);

//Creamos la informaci�n de las jerarqu�as de dependencias de combos (si existen)
//Para cada jerarqu�a de dependencia definimos un vector donde se defina la jerar�a
//La definici�n de la jerarqu�a consiste en definir para cada combo de la jerarqu�a cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de �l para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedar�an [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
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
canaOidCanaDependeceMap.agregar(['canaOidCana_tipeOidTipoPeri', padresTmp, 'canaOidCana', 'SegTipoPerio']);
padresTmp =  new Vector();
padresTmp.cargar(['canaOidCana_tipeOidTipoPeri'])
canaOidCanaDependeceMap.agregar(['canaOidCana', padresTmp, '', 'SegCanal']);
var acceOidAcceDependeceMap = new Vector();
acceOidAcceDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
acceOidAcceDependeceMap.agregar(['acceOidAcce_canaOidCana', padresTmp, 'acceOidAcce', 'SegCanalView']);
padresTmp =  new Vector();
padresTmp.cargar(['acceOidAcce_canaOidCana'])
acceOidAcceDependeceMap.agregar(['acceOidAcce', padresTmp, '', 'SegAcces']);
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
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);
var sociOidSociDependeceMap = new Vector();
sociOidSociDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
sociOidSociDependeceMap.agregar(['sociOidSoci', padresTmp, '', 'SegSocie']);

	
//variable conreferencia al obejto usado para devolver los resultados de una b�squeda lov
segVincuJerarLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var segVincuJerarTmpUpdateValues;



//Funci�n ejecutada en el onload de la pagina
function segVincuJerarInitComponents(){
	//Deshabilitamos la limpieza gen�rica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('segVincuJerarFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('segVincuJerarFrm.accion')){
		case "query": segVincuJerarQueryInitComponents(); break;
		case "view": segVincuJerarViewInitComponents(); break;
		case "create": segVincuJerarCreateInitComponents(); break;
		case "update": segVincuJerarUpdateInitComponents(); break;
		case "remove": segVincuJerarRemoveInitComponents(); break;
		case "lov": segVincuJerarLovInitComponents(); break;
	}
	//alert('accion :' + get('segVincuJerarFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('segVincuJerarFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('segVincuJerar')) segVincuJerarCmdRequery();
}

function segVincuJerarQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	focusFirstField('segVincuJerarFrm', true);	
}

function segVincuJerarViewInitComponents(){
	//Cargamos la descripci�n en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('segVincuJerarFrm', true);
}

function segVincuJerarCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('segVincuJerarFrm', true);
}

function segVincuJerarUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('segVincuJerarFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		segVincuJerarTmpUpdateValues = segVincuJerarBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		
			focusFirstFieldModify('segVincuJerarFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		focusFirstField('segVincuJerarFrm', true);
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('segVincuJerarFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function segVincuJerarRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	segVincuJerarList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera. Al realizar la query se activar�;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('segVincuJerarFrm', true);
}

function segVincuJerarLovInitComponents(){
	segVincuJerarLovReturnParameters = window.dialogArguments;
	
	focusFirstField('segVincuJerarFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad









//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function segVincuJerarSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('segVincuJerarFrm.' + campo, id);
	set('segVincuJerarFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function segVincuJerarLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	segVincuJerarLovReturnParameters.id = '';
	segVincuJerarLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function segVincuJerarLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(segVincuJerarList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = segVincuJerarList.codSeleccionados();
	var descripcion = segVincuJerarList.extraeDato(
		segVincuJerarList.codSeleccionados()[0], segVincuJerarChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	segVincuJerarLovReturnParameters.id = codigo;
	segVincuJerarLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function segVincuJerarCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('segVincuJerarFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('segVincuJerarFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "segVincuJerarList", "SegVincuJerarConectorTransactionQuery", 
		"result_ROWSET", parametros, "segVincuJerarPostQueryActions(datos);"]], "", "");	
}

function segVincuJerarCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('segVincuJerarFrm.lastQueryToSession'));
	var i =0;
	set('segVincuJerarFrm.marcOidMarc', [paramsRequery.ij(i++)]);
	
	set('segVincuJerarFrm.canaOidCana', [paramsRequery.ij(i++)]);
	
	set('segVincuJerarFrm.acceOidAcce', [paramsRequery.ij(i++)]);
	
	set('segVincuJerarFrm.sbacOidSbac', [paramsRequery.ij(i++)]);
	
	set('segVincuJerarFrm.sociOidSoci', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la p�gina de busqueda como la actual
	segVincuJerarPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	segVincuJerarCmdQuery(segVincuJerarPageCount);
}

function segVincuJerarFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	segVincuJerarPageCount = 1;
	segVincuJerarCmdQuery(segVincuJerarPageCount);
}

function segVincuJerarPreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != segVincuJerarLastQuery){
		segVincuJerarFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	segVincuJerarPageCount--;
	segVincuJerarCmdQuery(segVincuJerarPageCount);
}

function segVincuJerarNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != segVincuJerarLastQuery){
		segVincuJerarFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	segVincuJerarPageCount++;
	segVincuJerarCmdQuery(segVincuJerarPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function segVincuJerarPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('segVincuJerarListLayer', 'O');
		visibilidad('segVincuJerarListButtonsLayer', 'O');
		if(get('segVincuJerarFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	segVincuJerarLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripci�n en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminaci�n)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:segVincuJerarViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, segVincuJerarChoiceColumn) + "</A>",
			i, segVincuJerarChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	segVincuJerarList.setDatos(datosTmp.filtrar([0,1,2,3,4,5],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	segVincuJerarTimeStamps = datosTmp.filtrar([6],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		segVincuJerarMorePagesFlag = true;
		segVincuJerarList.eliminar(mmgPageSize, 1);
	}else{
		segVincuJerarMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('segVincuJerarFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('segVincuJerarListLayer', 'V');
	visibilidad('segVincuJerarListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('segVincuJerarList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	segVincuJerarList.display();
	
	//Actualizamos el estado de los botones 
	if(segVincuJerarMorePagesFlag){
		set_estado_botonera('segVincuJerarPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('segVincuJerarPaginationButtonBar',
			3,"inactivo");
	}
	if(segVincuJerarPageCount > 1){
		set_estado_botonera('segVincuJerarPaginationButtonBar',
			2,"activo");
		set_estado_botonera('segVincuJerarPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('segVincuJerarPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('segVincuJerarPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function segVincuJerarUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(segVincuJerarList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('segVincuJerarFrm.idSelection', segVincuJerarList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('segVincuJerarFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = segVincuJerarList.codSeleccionados()[0];
		parametros["previousAction"] = get('segVincuJerarFrm.accion');
		parametros["accion"] = get('segVincuJerarFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('SegVincuJerarLPStartUp', get('segVincuJerarFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) segVincuJerarCmdRequery();
	}
}

function segVincuJerarRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(segVincuJerarList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci�n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = segVincuJerarList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('segVincuJerarFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(segVincuJerarList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += segVincuJerarTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('segVincuJerarFrm.timestamp', timestamps);


	segVincuJerarFrm.oculto='S';
	envia('segVincuJerarFrm');
	segVincuJerarFrm.oculto='N';
}

function segVincuJerarViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(segVincuJerarList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	segVincuJerarViewDetail(segVincuJerarList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function segVincuJerarViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('segVincuJerarFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('SegVincuJerarLPStartUp', 'view', parametros, null, null);
}

//Funci�n ejecutada cuando se pulsa el bot�n de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripci�n del idioma por defecto
	//intreoducido directamente a trav�s del widget. Esto se pone debio a que la tecla r�pida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validaci�n los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('segVincuJerarFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
		
	
	if(validacion){
		segVincuJerarFrm.oculto='S';
		envia('segVincuJerarFrm');
		segVincuJerarFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarqu�a de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('segVincuJerarFrm.marcOidMarc').toString() == ''){
		set('segVincuJerarFrm.marcOidMarc', []);
		mmgResetCombosOnCascade('marcOidMarc', 'marcOidMarc', 'segVincuJerar');
		
	}
	if(get('segVincuJerarFrm.canaOidCana').toString() == ''){
		set('segVincuJerarFrm.canaOidCana_tipeOidTipoPeri', []);
		mmgResetCombosOnCascade('canaOidCana_tipeOidTipoPeri', 'canaOidCana', 'segVincuJerar');
		
	}
	if(get('segVincuJerarFrm.acceOidAcce').toString() == ''){
		set('segVincuJerarFrm.acceOidAcce_canaOidCana', []);
		mmgResetCombosOnCascade('acceOidAcce_canaOidCana', 'acceOidAcce', 'segVincuJerar');
		
	}
	if(get('segVincuJerarFrm.sbacOidSbac').toString() == ''){
		set('segVincuJerarFrm.sbacOidSbac_acceOidAcce_canaOidCana', []);
		mmgResetCombosOnCascade('sbacOidSbac_acceOidAcce_canaOidCana', 'sbacOidSbac', 'segVincuJerar');
		
	}
	if(get('segVincuJerarFrm.paisOidPais').toString() == ''){
		set('segVincuJerarFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'segVincuJerar');
		
	}
	if(get('segVincuJerarFrm.sociOidSoci').toString() == ''){
		set('segVincuJerarFrm.sociOidSoci', []);
		mmgResetCombosOnCascade('sociOidSoci', 'sociOidSoci', 'segVincuJerar');
		
	}
	
	
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	segVincuJerarRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('segVincuJerarFrm.accion');
	var origenTmp = get('segVincuJerarFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(segVincuJerarBuildUpdateRecordString() != segVincuJerarTmpUpdateValues){
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
	document.all.segVincuJerarListLayer.style.display='none';
	document.all.segVincuJerarListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.segVincuJerarListLayer.style.display='';
	document.all.segVincuJerarListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda
	jsSegVincuJerarMarcOidMarc = get('segVincuJerarFrm.marcOidMarc')[0];
	jsSegVincuJerarCanaOidCana = get('segVincuJerarFrm.canaOidCana')[0];
	jsSegVincuJerarAcceOidAcce = get('segVincuJerarFrm.acceOidAcce')[0];
	jsSegVincuJerarSbacOidSbac = get('segVincuJerarFrm.sbacOidSbac')[0];
	jsSegVincuJerarSociOidSoci = get('segVincuJerarFrm.sociOidSoci')[0];
	
	
	var parametros = "";
	parametros += jsSegVincuJerarMarcOidMarc + "|";
	parametros += jsSegVincuJerarCanaOidCana + "|";
	parametros += jsSegVincuJerarAcceOidAcce + "|";
	parametros += jsSegVincuJerarSbacOidSbac + "|";
	parametros += jsSegVincuJerarSociOidSoci + "|";
	
	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function segVincuJerarBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('segVincuJerarFrm.accion'), 
		get('segVincuJerarFrm.origen'));
	
	jsSegVincuJerarId = get('segVincuJerarFrm.id').toString();
	jsSegVincuJerarMarcOidMarc = get('segVincuJerarFrm.marcOidMarc')[0];
	jsSegVincuJerarCanaOidCana = get('segVincuJerarFrm.canaOidCana')[0];
	jsSegVincuJerarAcceOidAcce = get('segVincuJerarFrm.acceOidAcce')[0];
	jsSegVincuJerarSbacOidSbac = get('segVincuJerarFrm.sbacOidSbac')[0];
	jsSegVincuJerarPaisOidPais = get('segVincuJerarFrm.paisOidPais')[0];
	jsSegVincuJerarSociOidSoci = get('segVincuJerarFrm.sociOidSoci')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('segVincuJerarFrm.accion'), 
		get('segVincuJerarFrm.origen'));


	set('segVincuJerarFrm.id', jsSegVincuJerarId);
	set('segVincuJerarFrm.marcOidMarc', [jsSegVincuJerarMarcOidMarc]);
	set('segVincuJerarFrm.canaOidCana', [jsSegVincuJerarCanaOidCana]);
	set('segVincuJerarFrm.acceOidAcce', [jsSegVincuJerarAcceOidAcce]);
	set('segVincuJerarFrm.sbacOidSbac', [jsSegVincuJerarSbacOidSbac]);
	set('segVincuJerarFrm.paisOidPais', [jsSegVincuJerarPaisOidPais]);
	set('segVincuJerarFrm.sociOidSoci', [jsSegVincuJerarSociOidSoci]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la b�squeda
	jsSegVincuJerarMarcOidMarc = '';
	jsSegVincuJerarCanaOidCana = '';
	jsSegVincuJerarAcceOidAcce = '';
	jsSegVincuJerarSbacOidSbac = '';
	jsSegVincuJerarSociOidSoci = '';
	
}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('segVincuJerarFrm.errCodigo', errorCode);
	set('segVincuJerarFrm.errDescripcion', description);
	set('segVincuJerarFrm.errSeverity', severity);
	fMostrarMensajeError();
}

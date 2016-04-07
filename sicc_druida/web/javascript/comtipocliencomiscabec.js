

/*
    INDRA/CAR/mmg
    $Id: comtipocliencomiscabec.js,v 1.1 2009/12/03 19:02:08 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsComTipoClienComisCabecId = "";
var jsComTipoClienComisCabecCodClas = "";
var jsComTipoClienComisCabecCodSubc = "";
var jsComTipoClienComisCabecPaisOidPais = "";
var jsComTipoClienComisCabecDescripcion = "";

//Variables de paginacion, 
var comTipoClienComisCabecPageCount = 1;

//Varible de columna que representa el campo de choice
var comTipoClienComisCabecChoiceColumn = 2;

//Flag de siguiente pagina;
var comTipoClienComisCabecMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var comTipoClienComisCabecTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 189;
var sizeFormView = 175;
var sizeFormUpdate = 175;

//Ultima busqueda realizada
var comTipoClienComisCabecLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("comTipoClienComisCabecFrm.codClas");','focaliza("comTipoClienComisCabecFrm.codClas");','focaliza("comTipoClienComisCabecFrm.codClas");','focaliza("comTipoClienComisCabecFrm.codClas");','focaliza("comTipoClienComisCabecFrm.codClas");','focaliza("comTipoClienComisCabecFrm.codClas");'],[3,'focaliza("comTipoClienComisCabecFrm.codSubc");','focaliza("comTipoClienComisCabecFrm.codSubc");','focaliza("comTipoClienComisCabecFrm.codSubc");','focaliza("comTipoClienComisCabecFrm.codSubc");','focaliza("comTipoClienComisCabecFrm.codSubc");','focaliza("comTipoClienComisCabecFrm.codSubc");'],[4,'','','','','',''],[5,'focaliza("comTipoClienComisCabecFrm.Descripcion");','focaliza("comTipoClienComisCabecFrm.Descripcion");','focaliza("comTipoClienComisCabecFrm.Descripcion");','focaliza("comTipoClienComisCabecFrm.Descripcion");','focaliza("comTipoClienComisCabecFrm.Descripcion");','focaliza("comTipoClienComisCabecFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificaci�n.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'','','','','',''],[5,'focaliza("comTipoClienComisCabecFrm.Descripcion");','focaliza("comTipoClienComisCabecFrm.Descripcion");','focaliza("comTipoClienComisCabecFrm.Descripcion");','focaliza("comTipoClienComisCabecFrm.Descripcion");','focaliza("comTipoClienComisCabecFrm.Descripcion");','focaliza("comTipoClienComisCabecFrm.Descripcion");']]);

//Creamos la informaci�n de las jerarqu�as de dependencias de combos (si existen)
//Para cada jerarqu�a de dependencia definimos un vector donde se defina la jerar�a
//La definici�n de la jerarqu�a consiste en definir para cada combo de la jerarqu�a cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de �l para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedar�an [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una b�squeda lov
comTipoClienComisCabecLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var comTipoClienComisCabecTmpUpdateValues;



//Funci�n ejecutada en el onload de la pagina
function comTipoClienComisCabecInitComponents(){
	//Deshabilitamos la limpieza gen�rica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('comTipoClienComisCabecFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('comTipoClienComisCabecFrm.accion')){
		case "query": comTipoClienComisCabecQueryInitComponents(); break;
		case "view": comTipoClienComisCabecViewInitComponents(); break;
		case "create": comTipoClienComisCabecCreateInitComponents(); break;
		case "update": comTipoClienComisCabecUpdateInitComponents(); break;
		case "remove": comTipoClienComisCabecRemoveInitComponents(); break;
		case "lov": comTipoClienComisCabecLovInitComponents(); break;
	}
	//alert('accion :' + get('comTipoClienComisCabecFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('comTipoClienComisCabecFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('comTipoClienComisCabec')) comTipoClienComisCabecCmdRequery();
}

function comTipoClienComisCabecQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('comTipoClienComisCabecFrm', true);	
}

function comTipoClienComisCabecViewInitComponents(){
	//Cargamos la descripci�n en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('comTipoClienComisCabecFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('comTipoClienComisCabecFrm', true);
}

function comTipoClienComisCabecCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('comTipoClienComisCabecFrm.codClas','S', GestionarMensaje('ComTipoClienComisCabec.codClas.requiered.message'));
	
	setMV('comTipoClienComisCabecFrm.codSubc','S', GestionarMensaje('ComTipoClienComisCabec.codSubc.requiered.message'));
	
	setMV('comTipoClienComisCabecFrm.Descripcion','S', GestionarMensaje('ComTipoClienComisCabec.Descripcion.requiered.message'));
	
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('comTipoClienComisCabecFrm', true);
}

function comTipoClienComisCabecUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('comTipoClienComisCabecFrm.origen') == "pagina"){
		loadLocalizationWidget('comTipoClienComisCabecFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		comTipoClienComisCabecTmpUpdateValues = comTipoClienComisCabecBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('comTipoClienComisCabecFrm.codClas','S', GestionarMensaje('ComTipoClienComisCabec.codClas.requiered.message'));
		setMV('comTipoClienComisCabecFrm.codSubc','S', GestionarMensaje('ComTipoClienComisCabec.codSubc.requiered.message'));
		setMV('comTipoClienComisCabecFrm.Descripcion','S', GestionarMensaje('ComTipoClienComisCabec.Descripcion.requiered.message'));
		
			focusFirstFieldModify('comTipoClienComisCabecFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('comTipoClienComisCabecFrm', true);
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('comTipoClienComisCabecFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function comTipoClienComisCabecRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	comTipoClienComisCabecList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera. Al realizar la query se activar�;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('comTipoClienComisCabecFrm', true);
}

function comTipoClienComisCabecLovInitComponents(){
	comTipoClienComisCabecLovReturnParameters = window.dialogArguments;
	
	focusFirstField('comTipoClienComisCabecFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function comTipoClienComisCabecSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('comTipoClienComisCabecFrm.' + campo, id);
	set('comTipoClienComisCabecFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function comTipoClienComisCabecLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	comTipoClienComisCabecLovReturnParameters.id = '';
	comTipoClienComisCabecLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function comTipoClienComisCabecLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(comTipoClienComisCabecList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = comTipoClienComisCabecList.codSeleccionados();
	var descripcion = comTipoClienComisCabecList.extraeDato(
		comTipoClienComisCabecList.codSeleccionados()[0], comTipoClienComisCabecChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	comTipoClienComisCabecLovReturnParameters.id = codigo;
	comTipoClienComisCabecLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function comTipoClienComisCabecCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('comTipoClienComisCabecFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('comTipoClienComisCabecFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "comTipoClienComisCabecList", "ComTipoClienComisCabecConectorTransactionQuery", 
		"result_ROWSET", parametros, "comTipoClienComisCabecPostQueryActions(datos);"]], "", "");	
}

function comTipoClienComisCabecCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('comTipoClienComisCabecFrm.lastQueryToSession'));
	var i =0;
	set('comTipoClienComisCabecFrm.codClas', [paramsRequery.ij(i++)]);
	
	set('comTipoClienComisCabecFrm.codSubc', paramsRequery.ij(i++));
	
	set('comTipoClienComisCabecFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la p�gina de busqueda como la actual
	comTipoClienComisCabecPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	comTipoClienComisCabecCmdQuery(comTipoClienComisCabecPageCount);
}

function comTipoClienComisCabecFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	comTipoClienComisCabecPageCount = 1;
	comTipoClienComisCabecCmdQuery(comTipoClienComisCabecPageCount);
}

function comTipoClienComisCabecPreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != comTipoClienComisCabecLastQuery){
		comTipoClienComisCabecFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	comTipoClienComisCabecPageCount--;
	comTipoClienComisCabecCmdQuery(comTipoClienComisCabecPageCount);
}

function comTipoClienComisCabecNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != comTipoClienComisCabecLastQuery){
		comTipoClienComisCabecFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	comTipoClienComisCabecPageCount++;
	comTipoClienComisCabecCmdQuery(comTipoClienComisCabecPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function comTipoClienComisCabecPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('comTipoClienComisCabecListLayer', 'O');
		visibilidad('comTipoClienComisCabecListButtonsLayer', 'O');
		if(get('comTipoClienComisCabecFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	comTipoClienComisCabecLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripci�n en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 1)){
			case 'G': datosTmp.ij2(GestionarMensaje('ComTipoClienComisCabec.codClas.G.value'), i, 1); break;
			default: datosTmp .ij2('', i, 1);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminaci�n)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:comTipoClienComisCabecViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, comTipoClienComisCabecChoiceColumn) + "</A>",
			i, comTipoClienComisCabecChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	comTipoClienComisCabecList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	comTipoClienComisCabecTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		comTipoClienComisCabecMorePagesFlag = true;
		comTipoClienComisCabecList.eliminar(mmgPageSize, 1);
	}else{
		comTipoClienComisCabecMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('comTipoClienComisCabecFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('comTipoClienComisCabecListLayer', 'V');
	visibilidad('comTipoClienComisCabecListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('comTipoClienComisCabecList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	comTipoClienComisCabecList.display();
	
	//Actualizamos el estado de los botones 
	if(comTipoClienComisCabecMorePagesFlag){
		set_estado_botonera('comTipoClienComisCabecPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('comTipoClienComisCabecPaginationButtonBar',
			3,"inactivo");
	}
	if(comTipoClienComisCabecPageCount > 1){
		set_estado_botonera('comTipoClienComisCabecPaginationButtonBar',
			2,"activo");
		set_estado_botonera('comTipoClienComisCabecPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('comTipoClienComisCabecPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('comTipoClienComisCabecPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function comTipoClienComisCabecUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(comTipoClienComisCabecList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('comTipoClienComisCabecFrm.idSelection', comTipoClienComisCabecList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('comTipoClienComisCabecFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = comTipoClienComisCabecList.codSeleccionados()[0];
		parametros["previousAction"] = get('comTipoClienComisCabecFrm.accion');
		parametros["accion"] = get('comTipoClienComisCabecFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('ComTipoClienComisCabecLPStartUp', get('comTipoClienComisCabecFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) comTipoClienComisCabecCmdRequery();
	}
}

function comTipoClienComisCabecRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(comTipoClienComisCabecList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci�n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = comTipoClienComisCabecList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('comTipoClienComisCabecFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(comTipoClienComisCabecList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += comTipoClienComisCabecTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('comTipoClienComisCabecFrm.timestamp', timestamps);


	comTipoClienComisCabecFrm.oculto='S';
	envia('comTipoClienComisCabecFrm');
	comTipoClienComisCabecFrm.oculto='N';
}

function comTipoClienComisCabecViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(comTipoClienComisCabecList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	comTipoClienComisCabecViewDetail(comTipoClienComisCabecList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function comTipoClienComisCabecViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('comTipoClienComisCabecFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('ComTipoClienComisCabecLPStartUp', 'view', parametros, null, null);
}

//Funci�n ejecutada cuando se pulsa el bot�n de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripci�n del idioma por defecto
	//intreoducido directamente a trav�s del widget. Esto se pone debio a que la tecla r�pida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	setDefaultLanguageValue('comTipoClienComisCabecFrm', 
		'Descripcion', 1,
		get('comTipoClienComisCabecFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validaci�n los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('comTipoClienComisCabecFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	if(!hasDefaultLanguageValue('comTipoClienComisCabecFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('ComTipoClienComisCabec.Descripcion.requiered.message'));
		focaliza('comTipoClienComisCabecFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		comTipoClienComisCabecFrm.oculto='S';
		envia('comTipoClienComisCabecFrm');
		comTipoClienComisCabecFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarqu�a de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('comTipoClienComisCabecFrm.paisOidPais').toString() == ''){
		set('comTipoClienComisCabecFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'comTipoClienComisCabec');
		
	}
	
	
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	comTipoClienComisCabecRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('comTipoClienComisCabecFrm.accion');
	var origenTmp = get('comTipoClienComisCabecFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(comTipoClienComisCabecBuildUpdateRecordString() != comTipoClienComisCabecTmpUpdateValues){
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
	document.all.comTipoClienComisCabecListLayer.style.display='none';
	document.all.comTipoClienComisCabecListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.comTipoClienComisCabecListLayer.style.display='';
	document.all.comTipoClienComisCabecListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda
	jsComTipoClienComisCabecCodClas = get('comTipoClienComisCabecFrm.codClas')[0];
	jsComTipoClienComisCabecCodSubc = get('comTipoClienComisCabecFrm.codSubc').toString();
	jsComTipoClienComisCabecDescripcion = get('comTipoClienComisCabecFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsComTipoClienComisCabecCodClas + "|";
	parametros += jsComTipoClienComisCabecCodSubc + "|";
	parametros += jsComTipoClienComisCabecDescripcion + "|";
	
	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function comTipoClienComisCabecBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsComTipoClienComisCabecCodClas + "|";
	parametros += jsComTipoClienComisCabecCodSubc + "|";
	parametros += jsComTipoClienComisCabecDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('comTipoClienComisCabecFrm.accion'), 
		get('comTipoClienComisCabecFrm.origen'));
	
	jsComTipoClienComisCabecId = get('comTipoClienComisCabecFrm.id').toString();
	jsComTipoClienComisCabecCodClas = get('comTipoClienComisCabecFrm.codClas')[0];
	jsComTipoClienComisCabecCodSubc = get('comTipoClienComisCabecFrm.codSubc').toString();
	jsComTipoClienComisCabecPaisOidPais = get('comTipoClienComisCabecFrm.paisOidPais')[0];
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsComTipoClienComisCabecDescripcion = buildLocalizedString('comTipoClienComisCabecFrm', 1);
	}else{
		jsComTipoClienComisCabecDescripcion = get('comTipoClienComisCabecFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('comTipoClienComisCabecFrm.accion'), 
		get('comTipoClienComisCabecFrm.origen'));


	set('comTipoClienComisCabecFrm.id', jsComTipoClienComisCabecId);
	set('comTipoClienComisCabecFrm.codClas', [jsComTipoClienComisCabecCodClas]);
	set('comTipoClienComisCabecFrm.codSubc', jsComTipoClienComisCabecCodSubc);
	set('comTipoClienComisCabecFrm.paisOidPais', [jsComTipoClienComisCabecPaisOidPais]);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('comTipoClienComisCabecFrm', 1,  jsComTipoClienComisCabecDescripcion)
		loadLocalizationWidget('comTipoClienComisCabecFrm', 'Descripcion', 1);
	}else{
		set('comTipoClienComisCabecFrm.Descripcion', jsComTipoClienComisCabecDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la b�squeda
	jsComTipoClienComisCabecCodClas = '';
	jsComTipoClienComisCabecCodSubc = '';
	jsComTipoClienComisCabecDescripcion = '';
	
}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('comTipoClienComisCabecFrm.errCodigo', errorCode);
	set('comTipoClienComisCabecFrm.errDescripcion', description);
	set('comTipoClienComisCabecFrm.errSeverity', severity);
	fMostrarMensajeError();
}
